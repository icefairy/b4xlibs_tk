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
	Public Name As String = "CompCustomCompPage"
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
	theme.AddCellTheme("aligncenter")
	theme.Cell("aligncenter").Align = ABM.CELL_ALIGN_CENTER
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMCustomComponent"
	page.PageDescription = "The custom component "	
	page.PageHTMLName = "abmaterial-custom-component.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMCustomComponent", "../images/logo.png", "", "Controls", "ABMCustomComponent")
		
	' create the page grid
	page.AddRows(1,True, "").AddCells12(1,"")
	page.AddRows(1,True, "").AddCells12(1,"aligncenter")
	page.AddRows(14,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' we need extra javascript files and CSSfiles, they need to be added in the BuildPage() method!
	page.AddExtraJavaScriptFile("custom/nouislider.min.js")
	page.AddExtraJavaScriptFile("custom/wNumb.js")
    page.AddExtraCSSFile("custom/nouislider.css")
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","The ABMCustomComponent is a component for advanced users with good knowledge on Javascript/HTML/CSS and wants to add their own components to the ABMaterial framework."))		
	
	Dim custSlider As CustomSlidebar
	custSlider.Initialize(page, "custSlider", 25)
	page.Cell(2,1).AddComponent(custSlider.ABMComp)

	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par2","This is an example where we add a vertical noUISlider component to the framework."))		
	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par3","First we have to add our javascript and css files to the page:"))		
	
	Dim code1 As String = $"page.AddExtraJavaScriptFile("custom/nouislider.min.js")
page.AddExtraJavaScriptFile("custom/wNumb.js")
page.AddExtraCSSFile("custom/nouislider.css")"$

	page.Cell(4,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code1))
	
	' add paragraph	
	page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par4","Create a new standard class. Here we call it CustomSlidebar.  Add two variables to the global: "))	
		
	Dim code3 As String = $"Dim ABM As ABMaterial // used for the modification methods.
Dim ABMComp As ABMCustomComponent // the component that holds the object."$

	page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code3", code3))
	
	' add paragraph	
	page.Cell(7,1).AddComponent(ABMShared.BuildParagraph(page,"par5","The ABMComp object has 4 events: "))
	
	Dim Headers, codes, Descriptions As List
	Headers.Initialize2(Array As String("Event", "Description"))
	codes.Initialize2(Array As String("Build", "FirstRun", "Refresh", "CleanUp"))
	Descriptions.Initialize2(Array As String("Runs when an object is created for the first time.", "Is useful to run some initialisation script.", "runs when a refresh is called.", "Do the stuff needed when the object is removed."))
	page.Cell(8,1).AddComponent(ABMShared.BuildParamTable(page, "param2", Headers, codes, Descriptions))
	
	' add paragraph	
	page.Cell(9,1).AddComponent(ABMShared.BuildParagraph(page,"par6","Check out the full source code of the CustomSlidebar class for more info."))		
	' add paragraph	
	page.Cell(9,1).AddComponent(ABMShared.BuildParagraph(page,"par7","We're ready to add our new component to the page."))		
	
	Dim code2 As String = $"Dim custSlider As CustomSlidebar
custSlider.Initialize(page, "custSlider", 25)
page.CellR(2,1).AddComponent(custSlider.ABMComp)"$

	page.Cell(10,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code2))
	
	' add paragraph	
	page.Cell(11, 1).AddComponent(ABMShared.BuildParagraph(page,"par8","In the Refresh() event you can use some helper methods to modify the object."))		
	
	Headers.Initialize2(Array As String("Method", "Description"))
	codes.Initialize2(Array As String("HasClass", "AddClass", "RemoveClass", "AddHTML", "InsertHTMLAfter", "RemoveHTML", "GetProperty", "SetProperty", "RemoveProperty", "GetStyleProperty", "SetStyleProperty"))
	Descriptions.Initialize2(Array As String("Checks if a class is set on a tag","Adds a class to a tag","Removes a class from a tag","Appends HTML to a tag","Finds the parent of the tag and adds the HTML at the end of it","Removes the HTML from the tag","Gets a property of a tag","Sets a property of a tag","Removes a property from a tag","Gets the value of a style property of a tag","Sets the value of a style property of a tag"))
	page.Cell(12,1).AddComponent(ABMShared.BuildParamTable(page, "param3", Headers, codes, Descriptions))
	
	' add paragraph	
	page.Cell(13, 1).AddComponent(ABMShared.BuildParagraph(page,"par9","All the Automatic events (clicked, mousemove, etc) will be automatically generated thanks to B4J.  For specific events, you'll have to program them yourself using the b4j_raiseEvent() method in javascript.  It will return the event on the page in the format: comp_event(params as Map)."))		
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub custSlider_Changed(Params As Map)
	Log("changed")
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastred", "New value:" & Params.Get("value"), 5000)	
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMCustomComponent" Then Return
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
