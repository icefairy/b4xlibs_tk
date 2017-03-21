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
	Public Name As String = "CompEditorPage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
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
		
	' bluegray button
	theme.AddButtonTheme("bluegrey")
	theme.Button("bluegrey").BackColor = ABM.COLOR_BLUEGREY
	theme.Button("bluegrey").BackColorIntensity = ABM.INTENSITY_DARKEN1
	
	theme.AddEditorTheme("editor")
	theme.Editor("editor").BackColor = ABM.COLOR_WHITE
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMEditor"
	page.PageDescription = "The rich text editor component "	
	page.PageHTMLName = "abmaterial-editor.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMEditor", "../images/logo.png", "", "Controls", "ABMEditor")
		
	' create the page grid
	page.AddRows(8,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par1","The ABMEditor component is an alternative input component that allows rich text. It is based on Squire.") )	
	
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par2","Squire Is an HTML5 rich text editor, which provides powerful cross-browser normalisation, whilst being supremely lightweight and flexible. It is built for the present and the future, and as such does not support truly ancient browsers. It should work fine back to around Opera 12, Firefox 3.5, Safari 5, Chrome 9 and IE9."))

	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par3","Unlike other HTML5 rich text editors, Squire was written as a component for writing documents (emails, essays, etc.), not doing wysiwyg websites. If you are looking for support for inserting form controls or flash components or the like, you'll need to look elsewhere. However for many purposes, Squire may be just what you need, providing the power without the bloat.")) 
	
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par4","Note that the copy/paste behaviour can vary on the browser.  E.g. some browsers will allow to copy/paste an image in it, others don't."))
	
	' add a editor on the row
	Dim editor As ABMEditor
	editor.Initialize(page, "editor", True, True, "editor")
	page.CellR(1,1).AddComponent(editor) 
	
	' code block
	Dim code1 As String = $"Dim editor As ABMEditor
editor.Initialize(page, "editor", True, True, "editor")
page.CellR(1,1).AddComponent(editor)"$
	
	page.CellR(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code1))
	
	' add paragraph
	page.CellR(1,1).AddComponent(ABMShared.BuildParagraph(page,"par5","With the GetHTML/SetHTML methods you can set or get the input text."))
	
	Dim btn1 As ABMButton
	btn1.InitializeRaised(page, "btn1", "", "", "Get HTML text", "bluegrey")
	page.CellR(1,1).AddComponent(btn1)
	
	' code block
	Dim code2 As String = $"Sub btn1_Clicked(Target As String)
	Dim editor As ABMEditor = page.Component("editor")
	Dim editorlbl As ABMEditor = page.Component("editorlbl")
	editorlbl.SetHTML(editor.GetHTML)
	editorlbl.Refresh
End Sub"$
	
	page.CellR(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code2))
	
	Dim editorlbl As ABMEditor
	editorlbl.Initialize(page, "editorlbl", False, False, "")
	page.CellR(1,1).AddComponent(editorlbl)
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub btn1_Clicked(Target As String)
	Dim editor As ABMEditor = page.Component("editor")
	Dim editorlbl As ABMEditor = page.Component("editorlbl")
	editorlbl.SetHTML(editor.GetHTML)
	editorlbl.Refresh	
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMEditor" Then Return
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
