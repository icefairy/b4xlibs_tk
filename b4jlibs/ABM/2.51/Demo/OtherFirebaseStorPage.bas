Type=Class
Version=5.45
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
	Public Name As String = "OtherFirebaseStorPage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
End Sub

Public Sub Initialize
	' build the local structure IMPORTANT!
	BuildPage
End Sub

Private Sub WebSocket_Connected (WebSocket1 As WebSocket)
	Log("Connected")
	ws = WebSocket1	
	ABMPageId = ABM.GetPageID(page, Name,ws)
	Dim session As HttpSession = ABM.GetSession(ws, ABMShared.SessionMaxInactiveIntervalSeconds)
	
	If ABMShared.NeedsAuthorization Then
		If session.GetAttribute2("IsAuthorized", "") = "" Then
			ABMShared.NavigateToPage(ws, ABMPageId, "../")
			Return
		End If
	End If		
	
	ABM.UpdateFromCache(Me, ABMShared.CachedPages, ABMPageId, ws)
	If page.ComesFromPageCache Then
		' refresh the page
		page.Refresh
		' because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
		page.FinishedLoading
	Else
		' Prepare the page 
		page.Prepare
		' load the dynamic content
		ConnectPage
	End If
	Log(ABMPageId)
End Sub

Private Sub WebSocket_Disconnected
	Log("Disconnected")		
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
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True	
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "Firebase Storage"
	page.PageDescription = "Firebase Storage support"	
	page.PageHTMLName = "abmaterial-firebasestorage.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
	
	ABMShared.BuildNavigationBar(page, "Firebase Storage","../images/logo.png", "", "Firebase", "FirebaseStor")
	
	' create the page grid
	page.AddRows(4,True, "").AddCells12(1,"")
	
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","With storage you can upload/download files with ease. Here is an example using it together with the new ABMFileInput component. Read Firebase Auth first to authenticate you to Firebase."))	
	
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Usage in ABMaterial"))	
	
	Dim code1 As String = $"public Sub BuildPage()
  ...     
  page.Firebase.ApiKey = "AIzaSyCS5-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
  page.Firebase.AuthDomain = "project-xxxxxxxxxxxxxxxxxxxxxxxxxxx.firebaseapp.com"
  page.Firebase.DatabaseURL = "https://project-xxxxxxxxxxxxxxxxxxxxxxxx.firebaseio.com" 
  page.Firebase.StorageBucket = "project-xxxxxxxxxxxxxxxxxxxxxxx.appspot.com"
  ...      
End Sub"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code1))
	
	Dim code2 As String = $"public Sub ConnectPage()
  ...
  // create a ABMFileInput component so the user can pick a file from disk
   Dim inp1 As ABMFileInput
   inp1.Initialize(page, "inp1", "Select a file", "Open", True, "", "")   
   page.CellR(0,1).AddComponent(inp1)
   
   page.Refresh // IMPORTANT
   
   // NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
   page.FinishedLoading //IMPORTANT
End Sub"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code2))
	
	Dim code3 As String = $"Sub inp1_Changed(value As String)
	// the user has picked a file, so lets upload it to the storage
    Log("value : " & value)
    Dim inp1 As ABMFileInput = page.Component("inp1")
    page.Firebase.Storage.Upload("UPLOAD", "images/hqdefault.jpg", inp1, "{contentType: 'image/jpeg'}")
End Sub"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code3", code3))
	
	Dim code4 As String = $"Sub Page_FirebaseStorageResult(JobID As String, extra As String)
    // file has been stored, we can retrieve the metadata or the download url (e.g. use in an ABMImage, or as a link in an ABMLabel)
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
End Sub"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code4", code4))
	
	Dim code5 As String = $"Sub Page_FirebaseStorageError(JobID As String, extra As String)
    log("Error: " & extra & " for job: " & JobID)
End Sub"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code5", code5))
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "FirebaseStor" Then Return
	If Action = "Contact" Then		
		myToastId = myToastId + 1
		page.ShowToast("toast" & myToastId, "toastred", "Hello to you too!", 5000)
		Return
	End If
	If Action = "LogOff" Then
		ABMShared.LogOff(page)
		Return
	End If
	ABMShared.NavigateToPage(ws, ABMPageId, Value)
End Sub

Sub Page_SignedOffSocialNetwork(Network As String, Extra As String)
	page.ws.Session.SetAttribute("authType", "")
	page.ws.Session.SetAttribute("authName", "")
	page.ws.Session.SetAttribute("IsAuthorized", "")			
	ABMShared.NavigateToPage(ws, ABMPageId, "../")
End Sub
