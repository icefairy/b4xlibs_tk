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
	Public Name As String = "HelperNavigationBarPage"
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
	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMNavigationBar"
	page.PageDescription = "The navigation bar helper"	
	page.PageHTMLName = "abmaterial-navigation-bar.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMNavigationBar", "../images/logo.png", "", "Helpers", "ABMNavigationBar")
		
	' create the page grid
	page.AddRows(12,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add a header label
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Introduction"))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","ABMNavigationBar is not a real stand-alone component, but a property of an ABMPage.  This is why it is placed under Helpers.") )
	
	' add a header label
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr2", "How does it work"))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","Building a Naviagion Bar with an optional Side Bar is really easy in ABMaterial. It is important to know that for every page that uses the Navigation Bar, you must create the complete bar, just changing the active items. The sidebar can have only {B}one{/B} sublevel in the tree.") )  
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par3","Let's start with checking out the code we used for this WebApp and I'll explain afterwards.") )
	
	
	' add a code block
	Dim code As String = $"Sub BuildNavigationBar(page As ABMPage, Title As String, logo As String, ActiveTopReturnName As String, ActiveSideReturnName As String, ActiveSideSubReturnName As String) 
	page.NavigationBar.Initialize(page, "nav1", Title, ABM.TEXTALIGN_LEFT, False, True, False,True, 300, 48, logo, ABM.COLLAPSE_ACCORDION, "nav1theme")
	page.NavigationBar.ActiveTopReturnName = ActiveTopReturnName
	page.NavigationBar.ActiveSideReturnName = ActiveSideReturnName
	page.NavigationBar.ActiveSideSubReturnName = ActiveSideSubReturnName
			
	// this is a special one: a full screen toggle icon.  Will be handled automatically
	// this is experimental, as it has side effects e.g. when you navigate to another page, it is switched of again
	// nb.AddTopFullScreenIcon
	
	page.NavigationBar.AddTopItem("Contact", "", "mdi-action-account-circle", "")
		
	page.NavigationBar.AddSideBarItem("About", "About", "mdi-action-dashboard", "../AboutPage")
	page.NavigationBar.AddSideBarItem("GettingStarted", "Getting started", "mdi-editor-insert-comment", "../GettingStartedPage")
	page.NavigationBar.AddSideBarItem("Themes", "Themes", "mdi-action-invert-colors", "../ThemesPage")
	page.NavigationBar.AddSideBarItem("Layouts", "Grids", "mdi-editor-border-all", "../GridsPage")	
	page.NavigationBar.AddSideBarDivider("")
	page.NavigationBar.AddSideBarItem("Controls", "Controls", "mdi-image-palette", "")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMActionButton", "ABMActionButton", "", "../CompActionButtonPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMBadge", "ABMBadge", "", "../CompBadgePage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMButton", "ABMButton", "", "../CompButtonPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMCanvas", "ABMCanvas", "", "../CompCanvasPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMCard", "ABMCard", "", "../CompCardPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMCheckbox", "ABMCheckbox", "", "../CompCheckboxPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMCombo", "ABMCombo", "", "../CompComboPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMChip", "ABMChip", "", "../CompChipPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMCodeLabel", "ABMCodeLabel", "", "../CompCodeLabelPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMDivider", "ABMDivider", "", "../CompDividerPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMGoogleMap", "ABMGoogleMap", "", "../CompGoogleMapPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMLabel", "ABMLabel", "", "../CompLabelPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMList", "ABMList", "", "../CompListPage")	
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMImage", "ABMImage", "", "../CompImagePage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMInput", "ABMInput", "", "../CompInputPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMRadioGroup", "ABMRadioGroup", "", "../CompRadioGroupPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMSignaturePad", "ABMSignaturePad", "", "../CompSignaturePage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMImageSlider", "ABMImageSlider", "", "../CompSliderPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMSwitch", "ABMSwitch", "", "../CompSwitchPage")	
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMTabs", "ABMTabs", "", "../CompTabsPage")	
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMUpload", "ABMUpload", "", "../CompUploadPage")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMVideo", "ABMVideo", "", "../CompVideoPage")
	page.NavigationBar.AddSideBarDivider("")	
	page.NavigationBar.AddSideBarItem("Helpers", "Helpers", "mdi-device-now-widgets", "")
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMContainer", "ABMContainer", "", "../HelperContainerPage")
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMModalSheet", "ABMModalSheet", "", "../HelperModalSheetPage")
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMNavigationBar", "ABMNavigationBar", "", "../HelperNavigationBarPage")	
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMPage", "ABMPage", "", "../HelperPagePage")
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMParallax", "ABMParallax", "", "../HelperParallaxPage")
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMTable", "ABMTable", "", "../HelperTablePage")	
	page.NavigationBar.AddSideBarDivider("")
	page.NavigationBar.AddSideBarItem("Icons", "Icons", "mdi-action-account-circle", "../IconsPage")	
End Sub"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code))
	
	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par4","We also take the code from the BuildPage() method of this page 'HelperNaviagationBarPage' with us.") )
	
	code = $"ABMShared.BuildNavigationBar(page, "ABMNavigationBar", "../images/logo.png", "", "Helpers", "ABMNavigationBar")"$
	page.Cell(4,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code))
	
	' add paragraph	
	page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par5","If we go over the parameters we filled in in the BuildNavigationBar() method, we'll notice we gave it a Title (the text on top), a logo (the picture on the top of the Side Bar saying ABMaterial) and three extra parameters:") )
	
	' param table
	Dim Headers, codes, Descriptions As List
	Headers.Initialize2(Array As String("Param", "Description"))
	codes.Initialize2(Array As String("ActiveTopReturnName","ActiveSideReturnName","ActiveSideSubReturnName"))
	Descriptions.Initialize2(Array As String("If you have multiple TopItems, you set this parameter to be the active one.  In this demo, we have only one item, so we can leave it empty.","This sets the active item from the side bar.  In our example it is 'Helpers'.", "This sets the active sub item from the side bar.  In our example it is 'ABMNavigationBar'."))
	page.Cell(6,1).AddComponent(ABMShared.BuildParamTable(page, "param1", Headers, codes, Descriptions))
	
	' add paragraph	
	page.Cell(7,1).AddComponent(ABMShared.BuildParagraph(page,"par6","We can find those values back in the BuildNavigationBar() method, being params (1) and (2).  Param (3) is here the same, but this is the title of the item. Param(4) is an optional icon name and param(5) is de page we want to jump to when the user clicks on the item.  Note the '../' before as we have to respect the folder tree. (it is one folder down, then the page name in this case.  Check the folder structure in Explorer if you are in doubt.") )
	
	' add a code block
	Dim code As String = $"page.NavigationBar.AddSideBarSubItem("Helpers", "ABMNavigationBar", "ABMNavigationBar", "", "../HelperNavigationBarPage")"$
	
	page.Cell(8,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code3", code))
	
	' add a header label
	page.Cell(9,1).AddComponent(ABMShared.BuildHeader(page,"hdr2", "Initialization"))
	' add paragraph	
	page.Cell(9,1).AddComponent(ABMShared.BuildParagraph(page,"par7","There are some options you can set to the Naviagation Bar during Initialization:") )  
	
	' param table
	Dim Headers, codes, Descriptions As List
	Headers.Initialize2(Array As String("Param", "Description"))
	codes.Initialize2(Array As String("page", "id", "title", "alignTitle", "alignTopItemsLeftIfTitleCentered", "topBarDropDownBelow", "hideTopBarItemsOnSmallAndMedium", "topBarFixed", "sideBarWidthPx", "sideBarItemHeightPx", "sideBarLogo", "sideBarCollapseType", "themeName"))
	Descriptions.Initialize
	Descriptions.Add("The page object in you class. Is only to be conform with all other controls and may be usefull in the future.")
	Descriptions.Add("The ID of the control.")
	Descriptions.Add("The title on the top bar.")
	Descriptions.Add("Alignment of the title text. Can be one of the constants ABM.TEXTALIGN_LEFT, ABM.TEXTALIGN_CENTER or ABM.TEXTALIGN_RIGHT.")
	Descriptions.Add("If the Title is centered, do you want the items to be on the left of it.  On the right by default.")
	Descriptions.Add("If the topbar has sub items, does the dropdown list be under the bar, or over it.")
	Descriptions.Add("Hide all the topbar items if on a small screen.")
	Descriptions.Add("If fixed, the top bar stays on top of the window when scrolling the body.  If false, then the top bar will float with the scrolling.  In this Web App, all top bars are fixed.")
	Descriptions.Add("Width of the side bar.")
	Descriptions.Add("Height of a sidebar item.")
	Descriptions.Add("Logo on the top left of the side bar.")
	Descriptions.Add("Can be either the constant ABM.COLLAPSE_ACCORDION or ABM.COLLAPSE_EXPANDABLE.")
	Descriptions.Add("The name of the theme you want to use.")
	page.Cell(10,1).AddComponent(ABMShared.BuildParamTable(page, "param1", Headers, codes, Descriptions))
	
	' add paragraph	
	page.Cell(11,1).AddComponent(ABMShared.BuildParagraph(page,"par8","The Navigation bar has one event NavigationbarClicked(), raised on the page object. Use this event to load another page for example.") )  
	
	code = $"Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMNavigationBar" Then Return
	If Action = "Contact" Then	
		myToastId = myToastId + 1	
		page.ShowToast("toast" & myToastId, "toastred", "Hello to you too!", 5000)
		Return
	End If
	ABMShared.NavigateToPage(ws, Value)
End Sub"$
	
	page.Cell(12,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code4", code))
	
	
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
	If Action = "ABMNavigationBar" Then Return
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
