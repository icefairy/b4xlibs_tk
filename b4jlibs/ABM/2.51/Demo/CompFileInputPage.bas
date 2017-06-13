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
	Public Name As String = "CompFileInputPage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
	' the download folder
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
	
	' this page uses uploads, so needs some settings	
	ws.Session.SetAttribute("abmcallback", Me)	
	ws.Session.SetAttribute("abmdownloadfolder", DownloadFolder)
	ws.Session.SetAttribute("abmmaxsize", DownloadMaxSize)
End Sub

Private Sub WebSocket_Disconnected
	Log("Disconnected")	
		
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
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMFileInput"
	page.PageDescription = "The File Input component "	
	page.PageHTMLName = "abmaterial-fileinput.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMFileInput", "../images/logo.png", "", "Controls", "ABMSVGFileInput")
		
	' create the page grid
	page.AddRows(5,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","ABMFileInput is an alternative control to let the user select a file and upload it.  It is made up by an ABMInput control and a ABMButton control.  It does not upload automatically on selecting the file and has no progress feedback.") )	
		
	Dim inp1 As ABMFileInput
	inp1.Initialize(page, "inp1", "Select a file", "Open", True, "", "")	
	page.Cell(2,1).AddComponent(inp1)
	
	Dim code1 As String = $"Dim inp1 As ABMFileInput
	inp1.Initialize(page, "inp1", "Select a file", "Open", True, "", "")	
	page.Cell(2,1).AddComponent(inp1)"$
	
	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code1))
	
	Dim code2 As String = $"Sub inp1_Changed(value As String)
	Log("value : " & value)
	Dim inp1 As ABMFileInput  = page.Component("inp1")
	inp1.UploadToServer //Here the file is uploading
End Sub"$
	
	page.Cell(4,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code2))
	
	Dim code3 As String = $"Sub Page_FileUploaded(FileName As String, success As Boolean)	
	Dim inp1 As ABMFileInput  = page.Component("inp1")
	inp1.Clear
	Log(FileName & " = " & success)
End Sub"$
	
	page.Cell(5,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code3", code3))
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub inp1_Changed(value As String)
	Log("value : " & value)
	Dim inp1 As ABMFileInput  = page.Component("inp1")
	inp1.UploadToServer 'Here the file is uploading
End Sub

Sub Page_FileUploaded(FileName As String, success As Boolean)	
	Dim inp1 As ABMFileInput  = page.Component("inp1")
	inp1.Clear
	Log(FileName & " = " & success)
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastred", "Uploading " & FileName & ": Success = " & success, 3000)
	page.ws.Flush 'IMPORTANT
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMFileInput" Then Return
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

