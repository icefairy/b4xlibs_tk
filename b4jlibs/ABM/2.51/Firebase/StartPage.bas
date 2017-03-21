Type=Class
Version=4.7
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	Private ws As WebSocket 'ignore
	' will hold our page information
	Public page As ABMPage
	' page theme
	Private theme As ABMTheme
	' to access the constants
	Private ABM As ABMaterial 'ignore	
	' name of the page, must be the same as the class name (case sensitive!)
	Public Name As String = "StartPage"  '<-------------------------------------------------------- IMPORTANT
	Private ABMPageId As String = ""
	
	
	' your own variables
	Public DownloadFolder As String = "/www/" & ABMShared.AppName & "/uploads/"
	Public DownloadMaxSize As String = 100*1024	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	' build the local structure IMPORTANT!
	BuildPage
End Sub

Private Sub WebSocket_Connected (WebSocket1 As WebSocket)
	Log("Connected")
	ws = WebSocket1	
	ABMPageId = ABM.GetPageID(page, Name,ws)
	Dim session As HttpSession = ABM.GetSession(ws, ABMShared.SessionMaxInactiveIntervalSeconds)
	
	ABM.UpdateFromCache(Me, ABMShared.CachedPages, ABMPageId, ws)
	If page.ComesFromPageCache Then
		' refresh the page
		page.Refresh
		' Tell the browser we finished loading
		page.FinishedLoading
	Else
		' Prepare the page 
		page.Prepare
		' load the dynamic content
		ConnectPage
	End If
	Log(ABMPageId)		
	
	' this page uses uploads, so needs some settings	
	session.SetAttribute("abmcallback", Me)	
	session.SetAttribute("abmdownloadfolder", DownloadFolder)
	session.SetAttribute("abmmaxsize", DownloadMaxSize)
	
	' NEW FIREBASE
	page.Firebase.CheckAuthorized	
End Sub

Private Sub WebSocket_Disconnected
	Log("Disconnected")
	' and remove them again
	Try
		ws.Session.RemoveAttribute("abmcallback")	
		ws.Session.RemoveAttribute("abmdownloadfolder")
		ws.Session.RemoveAttribute("abmmaxsize")
	Catch
		Log(LastException.Message)
	End Try
End Sub

Sub Page_ParseEvent(Params As Map) 
	Dim eventName As String = Params.Get("eventname")
	Dim eventParams() As String = Regex.Split(",",Params.Get("eventparams"))
	If eventName = "beforeunload" Then
		Log("preparing for url refresh")	
		ABM.RemoveMeFromCache(ABMShared.CachedPages, ABMPageId)	
		Return
	End If
	If SubExists(Me, eventName) Then
		Params.Remove("eventname")
		Params.Remove("eventparams")
		Select Case Params.Size
			Case 0
				CallSub(Me, eventName)
			Case 1
				CallSub2(Me, eventName, Params.Get(eventParams(0)))					
			Case 2
				If Params.get(eventParams(0)) = "abmistable" Then
					Dim PassedTables As List = ABM.ProcessTablesFromTargetName(Params.get(eventParams(1)))
					CallSub2(Me, eventName, PassedTables)
				Else
					CallSub3(Me, eventName, Params.Get(eventParams(0)), Params.Get(eventParams(1)))
				End If
			Case Else
				' cannot be called directly, to many param
				CallSub2(Me, eventName, Params)				
		End Select
	End If
End Sub

public Sub BuildTheme()
	' start with the base theme defined in ABMShared
	theme.Initialize("pagetheme")
	theme.AddABMTheme(ABMShared.MyTheme)
	
	' add additional themes specific for this page
	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageHTMLName = "index.html"
	page.PageTitle = ""
	page.PageDescription = ""
	page.PageKeywords = ""
	page.PageSiteMapPriority = ""
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_YEARLY
		
	' NEW FIREBASE
	page.Firebase.ApiKey = "AIzaSyDKZfPY31sFAaCGyAcryYMvJD7zgBcdM8w"
	page.Firebase.AuthDomain = "project-3666844930973071900.firebaseapp.com"
	page.Firebase.DatabaseURL = "https://project-3666844930973071900.firebaseio.com"	
	page.Firebase.StorageBucket = "project-3666844930973071900.appspot.com"
		
	' adding a navigation bar
	
			
	' create the page grid
	page.AddRows(1,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	
End Sub

public Sub ConnectPage()
	Dim inp1 As ABMFileInput
	inp1.Initialize(page, "inp1", "Select a file", "Open", True, "", "")	
	page.CellR(0,1).AddComponent(inp1)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition
	
End Sub

Sub inp1_Changed(value As String)
	Log("value : " & value)
	Dim inp1 As ABMFileInput  = page.Component("inp1")
	page.Firebase.Storage.Upload("UPLOAD", "images/hqdefault.jpg", inp1, "{contentType: 'image/jpeg'}")
	'inp1.UploadToServer
End Sub

Sub Page_FileUploaded(FileName As String, success As Boolean)	
	'Dim inp1 As ABMFileInput  = page.Component("inp1")
	'inp1.Clear
	'Log(FileName & " = " & success)
End Sub

Sub Page_ToastClicked(ToastId As String, Action As String)
		
End Sub

Sub Page_ToastDismissed(ToastId As String)	
	
End Sub

' NEW FIREBASE
Sub Page_FirebaseAuthStateChanged(IsLoggedIn As Boolean)
	Log(IsLoggedIn)
	If IsLoggedIn Then		
		page.Firebase.Auth.CurrentUser.UpdateFromBrowser' IMPORTANT
		Log("ProviderId: " & page.Firebase.Auth.CurrentUser.ProviderId)
		Log("ProviderData: " & page.Firebase.Auth.CurrentUser.ProviderData.Size)
	Else
		Log("Authorizing...")		
		page.Firebase.Auth.SignInWithGoogle(False)	
	End If	
End Sub

' NEW FIREBASE
Sub Page_FirebaseAuthError(extra As String)
	Log(extra)
	ws.Session.SetAttribute("IsAuthorized", "")
End Sub

Sub Page_FirebaseStorageResult(JobID As String, extra As String)
	Log(extra)
	Select Case JobID
		Case "UPLOAD"
			page.Firebase.Storage.GetDownloadUrl("GETDOWNLOADURL", "images/hqdefault.jpg")			
		Case "GETDOWNLOADURL"
			page.Firebase.Storage.GetMetaData("GETMETADATA","images/hqdefault.jpg")
		Case "GETMETADATA"
			Dim inp1 As ABMFileInput  = page.Component("inp1")
			inp1.Clear
	End Select	
End Sub

Sub Page_FirebaseStorageError(JobID As String, extra As String)
	
End Sub



