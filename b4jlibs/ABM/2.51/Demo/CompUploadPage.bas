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
	Public Name As String = "CompUploadPage"
	Private ABMPageId As String = ""
	' the download folder
	Public DownloadFolder As String = "/www/" & ABMShared.AppName & "/uploads/"
	Public DownloadMaxSize As String = 100*1024
	
	' your own variables
	Dim myToastId As Int	
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
	' another toast theme
	theme.AddToastTheme("toastgreen")
	theme.Toast("toastgreen").Rounded = True
	theme.Toast("toastgreen").ActionForeColor = ABM.COLOR_BLACK
	theme.Toast("toastgreen").BackColor = ABM.COLOR_GREEN
	
	theme.AddUploadTheme("upload")
	theme.Upload("upload").ErrorColor = ABM.COLOR_RED
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.PageTitle = "ABMUpload"
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageDescription = "The file upload component "	
	page.PageHTMLName = "abmaterial-file-upload.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMUpload", "../images/logo.png", "", "Controls", "ABMUpload")
		
	' create the page grid
	page.AddRows(7,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page, "par1","ABMUpload is a control to upload files to the server.  You can drag/drop files into the dropzone or use the button to select files (100K max for demo). The files will start uploading immediately one after each other.  The user can cancel the upload clicking the 'x'."))
		
	' create the upload
	Dim upload1 As ABMUpload
	upload1.Initialize(page, "upload1", "Drop Here", "Browse", "upload")
	page.Cell(2,1).AddComponent(upload1)
		
	' add codeblock	
	Dim code As String = $"// create the upload
Dim upload1 As ABMUpload
upload1.Initialize(page, "upload1", "Drop Here", "Browse", True, "upload")
page.Cell(2,1).AddComponent(upload1)"$
	
	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code))
	
	' add paragraph
	page.Cell(4,1).AddComponent(ABMShared.BuildParagraph(page, "par1b","When the download is finished, you'll receive an FileUploaded() event on the page."))
	
	' add codeblock	
	code = $"Sub Page_FileUploaded(FileName As String, success As Boolean)
   myToastId = myToastId + 1	
   If success Then
      page.ShowToast("toast" & myToastId, "toastgreen", "File " & FileName & " uploaded!", 5000)
   Else
      page.ShowToast("toast" & myToastId, "toastred", "File " & FileName & " uploaded!", 5000)
   End If
   page.ws.Flush // IMPORTANT
End Sub"$

	page.Cell(5,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code))
	
	' add paragraph
	page.Cell(6,1).AddComponent(ABMShared.BuildParagraph(page, "par2","Additionally, you have to add the following lines of code to WebSocket_Connected() and WebSocket_Disconnected()!"))
	
	' add codeblock	
	code = $"// In WebSocket_Connected()
ws.Session.SetAttribute("abmcallback", Me)	
ws.Session.SetAttribute("abmdownloadfolder", DownloadFolder)
ws.Session.SetAttribute("abmmaxsize", DownloadMaxSize)"$

	page.Cell(7,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code3", code))
	' add codeblock	
	code = $"// In WebSocket_Disconnected()
Try
	ws.Session.RemoveAttribute("abmcallback")	
	ws.Session.RemoveAttribute("abmdownloadfolder")
	ws.Session.RemoveAttribute("abmmaxsize")
Catch
	Log(LastException.Message)
End Try"$

	page.Cell(7,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code4", code))
	
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
	If Action = "ABMUpload" Then Return
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

Sub Page_FileUploaded(FileName As String, success As Boolean)
	myToastId = myToastId + 1	
	If success Then
		page.ShowToast("toast" & myToastId, "toastgreen", "File " & FileName & " uploaded!", 5000)
	Else
		page.ShowToast("toast" & myToastId, "toastred", "File " & FileName & " not uploaded!", 5000)
	End If
	page.ws.Flush ' IMPORTANT
End Sub