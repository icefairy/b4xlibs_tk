Type=StaticCode
Version=5.45
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Static code module
Sub Process_Globals
	Public MyTheme As ABMTheme	
	Private ABM As ABMaterial 'ignore	
	Public NeedsAuthorization As Boolean = False
	Public AppVersion As String = DateTime.Now
	Public AppPublishedStartURL As String = "http://prd.one-two.com:51042/demo/"
	Public AppName As String = "demo"
	'Public AppPublishedStartURL As String = "http://81.165.232.188:8081/demo/"
	
	Public TrackingID As String	
	
	Public CachedPages As Map
	Public CacheScavengePeriodSeconds As Int = 15*60 ' 15 minutes ' 10 minutes
	Public SessionMaxInactiveIntervalSeconds As Int = 30*60 ' 30 minutes '1*60*24 ' one hour ' -1 = immortal but beware! This means the cache is NEVER emptied!
End Sub

Public Sub NavigateToPage(ws As WebSocket, PageId As String, TargetUrl As String)	
	If AppVersion <> "" Then
		TargetUrl = TargetUrl & "?" & AppVersion
	End If
	ABM.RemoveMeFromCache(CachedPages, PageId)
	If ws.Open Then
		ws.Eval("window.location = arguments[0]", Array As Object(TargetUrl))			
		ws.Flush
	End If
End Sub	

Sub RedirectOutput (Dir As String, FileName As String)
   #if RELEASE
   Dim out As OutputStream = File.OpenOutput(Dir, FileName, False) 'Set to True to append the logs
   Dim ps As JavaObject
   ps.InitializeNewInstance("java.io.PrintStream", Array(out, True, "utf8"))
   Dim jo As JavaObject
   jo.InitializeStatic("java.lang.System")
   jo.RunMethod("setOut", Array(ps))
   jo.RunMethod("setErr", Array(ps))
   #end if
End Sub

' build methods for ABM objects
Sub BuildTheme(themeName As String)
	MyTheme.Initialize(themeName)
		
	' the page theme
	MyTheme.Page.BackColor = ABM.COLOR_BLUEGREY
	MyTheme.Page.BackColorIntensity = ABM.INTENSITY_LIGHTEN5
	
	' the navbar theme
	MyTheme.AddNavigationBarTheme("nav1theme")
	MyTheme.NavigationBar("nav1theme").TopBarBackColor = ABM.COLOR_LIGHTBLUE
	
	' another navbar theme
	MyTheme.AddNavigationBarTheme("nav2theme")
	MyTheme.NavigationBar("nav2theme").SideBarWavesEffect = ABM.WAVESEFFECT_NONE	
	MyTheme.NavigationBar("nav2theme").SideBarBackColor = ABM.COLOR_BLUEGREY
	MyTheme.NavigationBar("nav2theme").SideBarBackColorIntensity = ABM.INTENSITY_LIGHTEN4
	
	' another navbar theme
	MyTheme.AddNavigationBarTheme("nav3theme")
	MyTheme.NavigationBar("nav3theme").SideBarWavesEffect = ABM.WAVESEFFECT_NONE	
	MyTheme.NavigationBar("nav3theme").SideBarBackColor = ABM.COLOR_LIME
	MyTheme.NavigationBar("nav3theme").SideBarBackColorIntensity = ABM.INTENSITY_LIGHTEN4
	
	' another navbar theme
	MyTheme.AddNavigationBarTheme("nav4theme")
	MyTheme.NavigationBar("nav4theme").SideBarWavesEffect = ABM.WAVESEFFECT_NONE	
	MyTheme.NavigationBar("nav4theme").SideBarBackColor = ABM.COLOR_TEAL
	MyTheme.NavigationBar("nav4theme").SideBarBackColorIntensity = ABM.INTENSITY_LIGHTEN4
		
	' the footer theme
	MyTheme.AddContainerTheme("footertheme")
	MyTheme.Container("footertheme").BackColor = ABM.COLOR_LIGHTBLUE
	MyTheme.Container("footertheme").BackColorIntensity = ABM.INTENSITY_DARKEN3
	
	' footer label theme
	MyTheme.AddLabelTheme("whitefc")
	MyTheme.Label("whitefc").ForeColor = ABM.COLOR_WHITE
	
	' footer label theme
	MyTheme.AddLabelTheme("justify")
	MyTheme.Label("justify").align = ABM.TEXTALIGN_JUSTIFY
		
	' a label header theme
	MyTheme.AddLabelTheme("lightblue")
	MyTheme.Label("lightblue").ForeColor = ABM.COLOR_LIGHTBLUE	
	MyTheme.Label("lightblue").ForeColorIntensity = ABM.INTENSITY_DARKEN2
	
	' a table theme
	MyTheme.AddTableTheme("params")
	MyTheme.Table("params").ZDepth = ABM.ZDEPTH_2
	MyTheme.Table("params").AddCellTheme("header")
	MyTheme.Table("params").Cell("header").BackColor = ABM.COLOR_BLUEGREY
	MyTheme.Table("params").Cell("header").BackColorIntensity = ABM.INTENSITY_DARKEN2
	MyTheme.Table("params").Cell("header").ForeColor = ABM.COLOR_WHITE
	MyTheme.Table("params").AddCellTheme("name")
	MyTheme.Table("params").Cell("name").BackColor = ABM.COLOR_BLUEGREY
	MyTheme.Table("params").Cell("name").BackColorIntensity = ABM.INTENSITY_LIGHTEN2
	MyTheme.Table("params").Cell("name").VerticalAlign = ABM.TABLECELL_VERTICALALIGN_TOP
	MyTheme.Table("params").AddCellTheme("description")
	MyTheme.Table("params").Cell("description").BackColor = ABM.COLOR_WHITE	
	MyTheme.Table("params").Cell("description").VerticalAlign = ABM.TABLECELL_VERTICALALIGN_TOP	
	
	' a toast theme
	MyTheme.AddToastTheme("toast")
	MyTheme.Toast("toast").Rounded = True
	MyTheme.Toast("toast").ActionForeColor = ABM.COLOR_ORANGE
	
	' another toast theme
	MyTheme.AddToastTheme("toastred")
	MyTheme.Toast("toastred").Rounded = True
	MyTheme.Toast("toastred").ActionForeColor = ABM.COLOR_BLACK
	MyTheme.Toast("toastred").BackColor = ABM.COLOR_RED
	
	' a container theme
	MyTheme.AddContainerTheme("lightblue")
	MyTheme.Container("lightblue").BackColor = ABM.COLOR_LIGHTBLUE
	MyTheme.Container("lightblue").BackColorIntensity = ABM.INTENSITY_DARKEN2
	
	MyTheme.AddContainerTheme("darkblue")
	MyTheme.Container("darkblue").BackColor = ABM.COLOR_LIGHTBLUE
	MyTheme.Container("darkblue").BackColorIntensity = ABM.INTENSITY_DARKEN3
	
	MyTheme.AddChartTheme("chartsidebar")
	MyTheme.Chart("chartsidebar").ZDepth = ABM.ZDEPTH_2
	MyTheme.Chart("chartsidebar").BackColor = ABM.COLOR_WHITE
	MyTheme.Chart("chartsidebar").BackColorIntensity = ABM.INTENSITY_LIGHTEN5
End Sub

Sub BuildNavigationBar(page As ABMPage, Title As String, logo As String, ActiveTopReturnName As String, ActiveSideReturnName As String, ActiveSideSubReturnName As String) 
	'page.SetFontStack("arial,sans-serif") ' this is the default now
	
	' old declaration:
	'page.NavigationBar.Initialize(page, "nav1", Title, ABM.TEXTALIGN_LEFT, False, True, False,True, 330, 48, logo, ABM.COLLAPSE_ACCORDION, "nav1theme")	
	
	' new declarations:
	
	' we have to make an ABMImage from our logo url
	Dim sbtopimg As ABMImage
	sbtopimg.Initialize(page, "sbtopimg", logo, 1)
	sbtopimg.SetFixedSize(236, 49)
	
	' our top component can be a more complex component than an image
	'Dim sbtopimg As ABMContainer = BuildSideBarTopComponent(page, "sbtopimg", "../images/me.jpg", "Me", "Simply the best")
	'' we have to adjust the 'logo' height
	'page.NavigationBar.SideBarLogoHeight = 245
	
	
	' behaviour as the old declaration	
	page.NavigationBar.Initialize(page, "nav1", ABM.SIDEBAR_MANUAL_HIDEMEDIUMSMALL, Title, True, True, 330, 48, sbtopimg, ABM.COLLAPSE_ACCORDION, "nav1theme")	
	
	' new behaviour, the sidebar is ALWAYS hidden
	' page.NavigationBar.Initialize(page, "nav1", ABM.SIDEBAR_MANUAL_ALWAYSHIDE, Title, True, True, 330, 48, sbtopimg, ABM.COLLAPSE_ACCORDION, "nav1theme")	
	
	' new behaviour, the sidebar is created automatically from the top items if the device size is tablet or mobile
	' note in this case, ALL AddSideBarItem(), AddSideBarSubItem(), AddSideBarDivider() and AddSideBarSubDivider() calls will be IGNORED, as the sidebar will be build dynamically from the top items!
	' page.NavigationBar.Initialize(page, "nav1", ABM.SIDEBAR_AUTO, Title, True, True, 330, 48, sbtopimg, ABM.COLLAPSE_ACCORDION, "nav1theme")	
	page.NavigationBar.TopBarDropDownConstrainWidth = False
	page.NavigationBar.ActiveTopReturnName = ActiveTopReturnName
	page.NavigationBar.ActiveSideReturnName = ActiveSideReturnName
	page.NavigationBar.ActiveSideSubReturnName = ActiveSideSubReturnName
	
	' you must add at least ONE dummy item if you want to add items to the topbar	in ConnectNaviagationBar
	page.NavigationBar.AddTopItem("DUMMY", "DUMMY", "", "", False)
	
	' you must add at least ONE dummy item if you want to add items to the sidebar	
	page.NavigationBar.AddSideBarItem("DUMMY", "DUMMY", "", "")		

	
End Sub

Sub ConnectNavigationBar(page As ABMPage)
	
	' Clear the dummies we created in BuildNavigationBar
	page.NavigationBar.Clear
	
'	Dim comp As ABMComponent = page.NavigationBar.SideBarTopComponent
'	If comp <> Null Then
'		If comp.Type = ABM.UITYPE_ABMCONTAINER Then
'			Dim topItem As ABMContainer = ABM.CastABMComponent(comp)
'			Dim subContainer As ABMContainer = topItem.Component(comp.ID & "SubItemCont")
'			Dim lbl1 As ABMLabel = subContainer.Component(comp.ID & "lbl1")
'			lbl1.Text = "I'm changed!"
'			topItem.Refresh
'		End If
'	End If
	
	' this is a special one: a full screen toggle icon.  Will be handled automatically
	' this is experimental, as it has side effects e.g. when you navigate to another page, it is switched of again
	'nb.AddTopFullScreenIcon
	
	' new behaviour: on each top item you can set if it should hide of not on a medium or small device.
	page.NavigationBar.AddTopItem("Contact", "", "mdi-action-account-circle", "", False)

'   NOTE Extra Sidebar
'   Page_NavigationbarClicked() is NOT raised for an Extra sidebar!
	
'   BEGIN Extra SideBar	
'	Dim extraSideBar As ABMSideBar
'	extraSideBar.Initialize(page, "extrasidebar", 530, 48, 56, Null, ABM.COLLAPSE_ACCORDION, "nav2theme")
'	extraSideBar.AddSideBarComponent("esbHello", BuildSideBarComponent(page, "sidebarcomp", "../images2/16.jpg", "This is a sidebar component", "With an image and an editor"))
'	page.NavigationBar.AddTopItemWithSideBar("SideBar", "", "mdi-action-dashboard", "", False, extraSideBar)
'	
'	Dim extraSideBar2 As ABMSideBar
'	extraSideBar2.Initialize(page, "extrasidebar2", 330, 48,56, Null, ABM.COLLAPSE_ACCORDION, "nav3theme")
'	extraSideBar2.AddSideBarDivider("")
'	extraSideBar2.AddSideBarItem("esbHello2", "Hello Again!", "mdi-action-invert-colors")
'	
'	page.NavigationBar.AddTopItemWithSideBar("SideBar2", "", "mdi-action-dashboard", "", False, extraSideBar2)
'	
'	Dim extraSideBar3 As ABMSideBar
'	extraSideBar3.Initialize(page, "extrasidebar3", 330, 48,56, Null, ABM.COLLAPSE_ACCORDION, "nav4theme")
'	extraSideBar3.AddSideBarDivider("")
'	extraSideBar3.AddSideBarItem("esbHello3", "Hello!", "mdi-action-invert-colors")
'	
'	page.NavigationBar.AddTopItemWithSideBar("SideBar3", "", "mdi-action-dashboard", "", False, extraSideBar3)
'    END Extra Sidebar
	
	' Example topbar items with dropdown
'	page.NavigationBar.AddTopItem("About", "About", "", "", True)
'	page.NavigationBar.AddTopItem("Themes", "Themes", "", "", True)
'	page.NavigationBar.AddTopSubItem("Themes", "Lightblue", "Very Light Blue", "", "")
'	page.NavigationBar.AddTopSubItem("Themes", "Orange", "Orange", "", "")
'	page.NavigationBar.AddTopSubItem("Themes", "Black", "Black", "", "")
'	page.NavigationBar.AddTopItem("Layouts", "Layouts", "", "",True)
	
	' example of adding a component (container) to a side bar menu		
	'page.NavigationBar.AddSideBarComponent("TestComp1", BuildSideBarComponent(page, "tcS1", "../images/mom.jpg", "Mom", "The loving one"), "")	
	'page.NavigationBar.AddSideBarComponent("TestComp2", BuildSideBarComponent(page, "tcS2", "../images/dad.jpg", "Dad", "The strong one"), "")	
	'page.NavigationBar.AddSideBarComponent("TestComp3", BuildSideBarComponent(page, "tcS3", "../images/brother.jpg", "Brother", "My best friend"), "")
	'page.NavigationBar.AddSideBarComponent("TestComp4", BuildSideBarComponent(page, "tcS4", "../images/sister.jpg", "Sister", "The annoying one"), "")
	page.NavigationBar.AddSideBarDivider("")
	page.NavigationBar.AddSideBarItem("About", "About", "mdi-action-dashboard", "../AboutPage/abmaterial-about.html")
	page.NavigationBar.AddSideBarDivider("")
	page.NavigationBar.AddSideBarItem("GettingStarted", "Getting started", "mdi-editor-insert-comment", "../GettingStartedPage/abmaterial-getting-started.html")
	page.NavigationBar.AddSideBarDivider("")
	page.NavigationBar.AddSideBarItem("Themes", "Themes", "mdi-action-invert-colors", "../ThemesPage/abmaterial-theme-color.html")
	page.NavigationBar.AddSideBarDivider("")
	page.NavigationBar.AddSideBarItem("Layouts", "Grids", "mdi-editor-border-all", "../GridsPage/abmaterial-grid-layout.html")	
	page.NavigationBar.AddSideBarDivider("")
	page.NavigationBar.AddSideBarItem("Controls", "Controls", "mdi-image-palette", "")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMActionButton", "ABMActionButton", "", "../CompActionButtonPage/abmaterial-action-button.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMAudioPlayer", "ABMAudioPlayer (1.08)", "", "../CompAudioPlayerPage/abmaterial-audioplayer.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMBadge", "ABMBadge", "", "../CompBadgePage/abmaterial-badge.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMButton", "ABMButton", "", "../CompButtonPage/abmaterial-button.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMCalendar", "ABMCalendar", "", "../CompCalendarPage/abmaterial-calendar.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMCanvas", "ABMCanvas", "", "../CompCanvasPage/abmaterial-canvas.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMCard", "ABMCard", "", "../CompCardPage/abmaterial-card.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMChart", "ABMChart", "", "../CompChartPage/abmaterial-chart.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMChat", "ABMChat (2.50)", "", "../CompChatPage/abmaterial-chat.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMCheckbox", "ABMCheckbox", "", "../CompCheckboxPage/abmaterial-checkbox.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMChip", "ABMChip", "", "../CompChipPage/abmaterial-chip.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMChronologyList", "ABMChronologyList (2.00)", "", "../CompChronologyPage/abmaterial-chronology.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMCodeLabel", "ABMCodeLabel", "", "../CompCodeLabelPage/abmaterial-code-label.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMCombo", "ABMCombo", "", "../CompComboPage/abmaterial-combo.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMCustomComponent", "ABMCustomComponent", "", "../CompCustomCompPage/abmaterial-custom-component.html")	
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMDateTimePicker", "ABMDateTimePicker (1.06)", "", "../CompDateTimePickerPage/abmaterial-date-time-picker.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMDateTimeScroller", "ABMDateTimeScroller (1.06)", "", "../CompDateTimeScrollerPage/abmaterial-date-time-scroller.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMDivider", "ABMDivider", "", "../CompDividerPage/abmaterial-divider.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMFileInput", "ABMFileInput (1.20)", "", "../CompFileInputPage/abmaterial-fileinput.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMEditor", "ABMEditor (1.07)", "", "../CompEditorPage/abmaterial-editor.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMGoogleMap", "ABMGoogleMap", "", "../CompGoogleMapPage/abmaterial-google-map.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMImage", "ABMImage", "", "../CompImagePage/abmaterial-image.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMImageSlider", "ABMImageSlider", "", "../CompSliderPage/abmaterial-image-slider-carousel.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMInput", "ABMInput", "", "../CompInputPage/abmaterial-input.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMLabel", "ABMLabel", "", "../CompLabelPage/abmaterial-label.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMList", "ABMList", "", "../CompListPage/abmaterial-list.html")	
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMPagination", "ABMPagination", "", "../CompPaginationPage/abmaterial-pagination.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMPatternLock", "ABMPatternLock (1.20)", "", "../CompPatternLockPage/abmaterial-patternlock.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMPDFViewer", "ABMPDFViewer (1.08)", "", "../CompPDFViewerPage/abmaterial-pdfviewer.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMPercentSlider", "ABMPercentSlider (2.50)", "", "../CompPercentSliderPage/abmaterial-percentslider.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMPivotTable", "ABMPivotTable (1.08)", "", "../CompPivotTablePage/abmaterial-pivottable.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMPlanner", "ABMPlanner (2.50)", "", "../CompPlannerPage/abmaterial-planner.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMRadioGroup", "ABMRadioGroup", "", "../CompRadioGroupPage/abmaterial-radio-group.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMRange", "ABMRange", "", "../CompRangePage/abmaterial-range.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMSignaturePad", "ABMSignaturePad", "", "../CompSignaturePage/abmaterial-signature.html")	
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMSlider", "ABMSlider", "", "../CompRealSliderPage/abmaterial-slider.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMSocialOAuth", "ABMSocialOAuth", "", "../CompOAuthPage/abmaterial-oauth.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMSocialShare", "ABMSocialShare (1.07)", "", "../CompSocialSharePage/abmaterial-social-share.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMSVGSurface", "ABMSVGSurface (1.20)", "", "../CompSVGSurfacePage/abmaterial-svgsurface.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMSwitch", "ABMSwitch", "", "../CompSwitchPage/abmaterial-switch.html")	
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMTabs", "ABMTabs", "", "../CompTabsPage/abmaterial-tabs.html")	
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMTimeLine", "ABMTimeLine (1.09)", "", "../CompTimeLinePage/abmaterial-timeline.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMTreeTable", "ABMTreeTable", "", "../CompTreeTablePage/abmaterial-tree-table.html")	
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMUpload", "ABMUpload", "", "../CompUploadPage/abmaterial-file-upload.html")
	page.NavigationBar.AddSideBarSubItem("Controls", "ABMVideo", "ABMVideo", "", "../CompVideoPage/abmaterial-video.html")
	'page.NavigationBar.AddSideBarSubItem("Controls", "ABMXPlay", "ABMXPlay (2.00)", "", "../CompXPlayPage/abmaterial-xplay.html")
	page.NavigationBar.AddSideBarDivider("")	
	page.NavigationBar.AddSideBarItem("Helpers", "Helpers", "mdi-device-now-widgets", "")
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMContainer", "ABMContainer", "", "../HelperContainerPage/abmaterial-container.html")
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMFlexWall", "ABMFlexWall (1.09)", "", "../HelperFlexWallPage/abmaterial-flexwall.html")
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMGenerator", "ABMGenerator (1.07)", "", "../HelperGeneratorPage/abmaterial-generator.html")
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMModalSheet", "ABMModalSheet", "", "../HelperModalSheetPage/abmaterial-modal-sheet.html")
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMNavigationBar", "ABMNavigationBar", "", "../HelperNavigationBarPage/abmaterial-navigation-bar.html")	
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMPage", "ABMPage", "", "../HelperPagePage/abmaterial-page.html")
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMParallax", "ABMParallax", "", "../HelperParallaxPage/abmaterial-parallax.html")
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMTable", "ABMTable", "", "../HelperTablePage/abmaterial-table.html")	
	page.NavigationBar.AddSideBarSubItem("Helpers", "ABMTableMutable", "ABMTableMutable (1.20)", "", "../HelperTableMutablePage/abmaterial-table-mutable.html")	
	page.NavigationBar.AddSideBarDivider("")
	page.NavigationBar.AddSideBarItem("Icons", "Icons", "mdi-action-account-circle", "../IconsPage/abmaterial-material-icons.html")
	page.NavigationBar.AddSideBarDivider("")	
	page.NavigationBar.AddSideBarItem("Firebase", "Firebase", "mdi-device-gps-not-fixed", "")
	page.NavigationBar.AddSideBarSubItem("Firebase", "Firebase", "Firebase Auth (1.20)", "", "../OtherFirebasePage/abmaterial-firebase.html")
	page.NavigationBar.AddSideBarSubItem("Firebase", "FirebaseStor", "Firebase Storage (1.20)", "", "../OtherFirebaseStorPage/abmaterial-firebasestorage.html")
	page.NavigationBar.AddSideBarDivider("")	
	page.NavigationBar.AddSideBarItem("Donators", "Donators", "mdi-editor-attach-money", "")
	page.NavigationBar.AddSideBarSubItem("Donators", "ExtraLibs", "Extra libraries", "", "../DonatorsExtraLibsPage/abmaterial-extralibs.html")
	page.NavigationBar.AddSideBarDivider("")
	
	page.NavigationBar.Refresh ' IMPORTANT
End Sub

Sub BuildSideBarComponent(page As ABMPage, id As String, image As String, Title As String, Subtitle As String) As ABMContainer 'ignore
	Dim ItemCont As ABMContainer
	ItemCont.Initialize(page, id, "")	
	ItemCont.AddRowsM(1,False,0,0, "").AddCellsOSMP(1,0,0,0,3,3,3,4,0,0,0,"").AddCellsOSMP(1,0,0,0,9,9,9,4,0,0,0,"")
	ItemCont.AddRowsM(1,False,0,0, "").AddCells12(1, "")
	ItemCont.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	Dim SubItemCont As ABMContainer
	SubItemCont.Initialize(page, id & "SubItemCont", "")	
	SubItemCont.AddRowsM(1,False, 0,0,"").AddCells12MP(1,-6,0,0,0,"").AddCells12(1,"")
	SubItemCont.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	ItemCont.Cell(1,2).AddComponent(SubItemCont)
	
	Dim img As ABMImage
	img.Initialize(page, id & "img", image, 1)
	img.SetFixedSize(48,48)
	img.IsCircular = True
	img.IsResponsive = True
	
	ItemCont.Cell(1,1).AddComponent(img)
	
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, id & "lbl1", Title, ABM.SIZE_H6, False, "lightblue")
	lbl1.VerticalAlign = True
	
	SubItemCont.Cell(1,1).AddComponent(lbl1)
	
	Dim lbl2 As ABMLabel
	lbl2.Initialize(page, id & "lbl2", Subtitle, ABM.SIZE_H6, False, "")
	lbl2.VerticalAlign = True
	
	SubItemCont.Cell(1,2).AddComponent(lbl2)
	
	Dim editor As ABMEditor
	editor.Initialize(page, "editor", True, True, "editor")
	ItemCont.Cell(2,1).AddComponent(editor) 
	
	Return ItemCont
End Sub

Sub BuildSideBarTopComponent(page As ABMPage, id As String, image As String, Title As String, Subtitle As String) As ABMContainer 'ignore
	' important!
	'page.NeedsChart = true
	
	Dim ItemCont As ABMContainer
	ItemCont.Initialize(page, id, "")	
	ItemCont.AddRowsM(1,False,0,0, "").AddCellsOSMP(1,0,0,0,3,3,3,4,0,0,0,"").AddCellsOSMP(1,0,0,0,9,9,9,4,0,0,0,"")
	ItemCont.AddRowsM(1,False,0,0, "").AddCellsOSMP(1,0,0,0,12,12,12,0,0,0,0,"")
	ItemCont.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	Dim SubItemCont As ABMContainer
	SubItemCont.Initialize(page, id & "SubItemCont", "")	
	SubItemCont.AddRowsM(1,False, 0,0,"").AddCells12MP(1,-6,0,0,0,"").AddCells12(1,"")
	SubItemCont.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	ItemCont.Cell(1,2).AddComponent(SubItemCont)
	
	Dim img As ABMImage
	img.Initialize(page, id & "img", image, 1)
	img.SetFixedSize(48,48)
	img.IsCircular = True
	img.IsResponsive = True
	
	ItemCont.Cell(1,1).AddComponent(img)
	
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, id & "lbl1", Title, ABM.SIZE_H6, False, "whitefc")
	lbl1.VerticalAlign = True
	
	SubItemCont.Cell(1,1).AddComponent(lbl1)
	
	Dim lbl2 As ABMLabel
	lbl2.Initialize(page, id & "lbl2", Subtitle, ABM.SIZE_H6, False, "whitefc")
	lbl2.VerticalAlign = True
	
	SubItemCont.Cell(1,2).AddComponent(lbl2)
	
	' create a bar chart
	Dim chart3 As ABMChart
	chart3.Initialize(page, "chart3", ABM.CHART_TYPEBAR, ABM.CHART_RATIO_GOLDENSECTION, "chartsidebar")
	' set some options
	chart3.OptionsBar.AxisYOnlyInteger=True
	chart3.OptionsBar.ChartPaddingRight=60
		
	' add the labels
	chart3.AddLabels(Array As String("M", "T", "W", "T", "F", "S", "S"))
	
	' add some series	
	Dim Serie3A As ABMChartSerie
	Serie3A.InitializeForBar
	Serie3A.SetValues(Array As Int(30,50,70,80,100,140,170))
	chart3.AddSerie(Serie3A)
	
	Dim Serie3B As ABMChartSerie
	Serie3B.InitializeForBar
	Serie3B.SetValues(Array As Int(100,120,180,150,190,100,70))
	chart3.AddSerie(Serie3B)
	
	' add the chart
	ItemCont.Cell(2,1).AddComponent(chart3)
		
	Return ItemCont
End Sub

Sub LogOff(page As ABMPage)
	Dim Network As String = page.ws.Session.GetAttribute("authType")
	Dim Name As String = page.ws.Session.GetAttribute("authName")
	Select Case Network
		Case "local"
			' do whatever you have to do to log off your user
			
			page.ws.Session.SetAttribute("authType", "")
			page.ws.Session.SetAttribute("authName", "")
			page.ws.Session.SetAttribute("IsAuthorized", "")				
			NavigateToPage(page.ws, page.GetPageID, "../")
		Case ABM.SOCIALOAUTH_FACEBOOK
			' the event SignedOffSocialNetwork will be raised on the page, do the rest there
			page.SignOffSocialNetwork(Network, "", Name)						
	End Select	
End Sub

Sub Date2String(date As Long, withTime As Boolean) As String
	Dim OrigFormat As String=DateTime.DateFormat
	If withTime Then
		DateTime.DateFormat="yyyy-MM-dd'T'HH:mm:ss"		
	Else
		DateTime.DateFormat="yyyy-MM-dd"
	End If
	Dim MyDate As String =DateTime.Date(date)	
	DateTime.DateFormat=OrigFormat
	Return MyDate
End Sub

Sub String2Date(date As String) As Long
	Dim lng As Long
	Dim OrigFormat As String=DateTime.DateFormat
	If date.Length > 10 Then
		DateTime.DateFormat = "yyyy-MM-dd"
		DateTime.DateFormat = "HH:mm:ss"
		Dim d As String = date.SubString2(0,11)
		Dim t As String = date.SubString(12)
		lng = DateTime.DateTimeParse(d,t)
	Else
		DateTime.DateFormat = "yyyy-MM-dd"
		lng = DateTime.Dateparse(date)
	End If
	DateTime.DateFormat=OrigFormat
	Return lng
End Sub

Sub Mid(Text As String, Start As Int, Length As Int) As String
   Return Text.SubString2(Start-1,Start+Length-1)
End Sub

Sub Mid2(Text As String, Start As Int) As String
   Return Text.SubString(Start-1)
End Sub

Sub BuildFooter(page As ABMPage)		
	page.Footer.AddRows(1, True, "").AddCellsOS(2,0,0,0,6,6,6, "") 
	page.Footer.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components	
	
	page.Footer.UseTheme("footertheme")		
End Sub

Sub ConnectFooter(page As ABMPage)	
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, "footlbl1", "Blog: Alwaysbusy's Corner{BR}{BR}B4J by Anywhere Software{BR}Materialize CSS by students from Carnegie Mellon University",ABM.SIZE_PARAGRAPH, False, "whitefc")
	page.Footer.Cell(1,1).AddComponent(lbl1)
	
	Dim lbl2 As ABMLabel
	lbl2.Initialize(page, "footlbl2", "ABMaterial Copyright @2015-2016{BR}By Alain Bailleul{BR}{BR}Email: alain.bailleul@telenet.be",ABM.SIZE_PARAGRAPH, False, "whitefc")
	page.Footer.Cell(1,2).AddComponent(lbl2)	
End Sub

Sub BuildFooterFixed(page As ABMPage)	
	page.isFixedFooter= True
	' because we have a fixed footer at the bottom, we have to adjust the padding of the body in pixels
	page.PaddingBottom = 200
	
	page.Footer.AddRows(1, True, "").AddCellsOS(2,0,0,0,6,6,6, "") 
	page.Footer.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components	
	
	page.Footer.UseTheme("footertheme")	
End Sub

Sub ConnectFooterFixed(page As ABMPage)		
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, "footlbl1", "Blog: Alwaysbusy's Corner{BR}{BR}B4J by Anywhere Software{BR}Materialize CSS by students from Carnegie Mellon University",ABM.SIZE_PARAGRAPH, False, "whitefc")
	page.Footer.Cell(1,1).AddComponent(lbl1)
	
	Dim lbl2 As ABMLabel
	lbl2.Initialize(page, "footlbl2", "ABMaterial Copyright @2015-2016{BR}By Alain Bailleul{BR}{BR}Email: alain.bailleul@telenet.be",ABM.SIZE_PARAGRAPH, False, "whitefc")
	page.Footer.Cell(1,2).AddComponent(lbl2)	
End Sub

public Sub BuildParamTable(page As ABMPage, id As String, Headers As List, Names As List, Descriptions As List) As ABMTable
	Dim tbl As ABMTable
	tbl.Initialize(page, id, False, False, False, "Params")
	tbl.IgnoreFormattingCodes = True ' build in to ignore formatting tags
	Dim themes As List	
	
	themes.Initialize2(Array As String("header","header"))	
	tbl.SetHeaders(Headers)
	tbl.SetHeaderThemes(themes)
	
	themes.Initialize2(Array As String("name","description"))	
	
	For i = 0 To Names.Size - 1	
		Dim Values As List
		Values.Initialize
		Values.Add( Names.Get(i))
		Values.Add( Descriptions.Get(i))
		tbl.AddRow("uid" & i, Values)
		tbl.SetRowThemes(themes)
	Next	
	Return tbl
End Sub

public Sub BuildParamTable2(page As ABMPage, id As String, Headers As List, Names As List, Descriptions As List) As ABMTable
	Dim tbl As ABMTable
	tbl.Initialize(page, id, False, False, False, "Params")
	Dim themes As List	
	
	themes.Initialize2(Array As String("header","header"))	
	tbl.SetHeaders(Headers)
	tbl.SetHeaderThemes(themes)
	
	themes.Initialize2(Array As String("name","description"))	
	
	For i = 0 To Names.Size - 1	
		Dim Values As List
		Values.Initialize
		Values.Add( Names.Get(i))
		Values.Add( Descriptions.Get(i))
		tbl.AddRow("uid" & i, Values)
		tbl.SetRowThemes(themes)
	Next	
	Return tbl
End Sub

public Sub BuildHeader(page As ABMPage, id As String, Text As String) As ABMLabel
	Dim hdr As ABMLabel
	hdr.Initialize(page, id, Text, ABM.SIZE_H5, False, "lightblue")
	Return hdr
End Sub

public Sub BuildSubHeader(page As ABMPage, id As String, Text As String) As ABMLabel
	Dim shdr As ABMLabel
	shdr.Initialize(page, id, Text, ABM.SIZE_H5, False, "")
	Return shdr
End Sub

public Sub BuildSubHeader2(page As ABMPage, id As String, Text As String) As ABMLabel
	Dim shdr As ABMLabel
	shdr.Initialize(page, id, Text, ABM.SIZE_H6, False, "")	
	Return shdr
End Sub

public Sub BuildParagraph(page As ABMPage, id As String, Text As String) As ABMLabel
	Dim lbl As ABMLabel	
	lbl.Initialize(page, id, Text , ABM.SIZE_PARAGRAPH, False, "justify")	
	Return lbl
End Sub

public Sub BuildParagraphBQ(page As ABMPage, id As String, Text As String) As ABMLabel
	Dim lbl As ABMLabel	
	lbl.Initialize(page, id, Text , ABM.SIZE_PARAGRAPH, False, "")
	lbl.IsBlockQuote = True
	Return lbl
End Sub

public Sub BuildSpan(page As ABMPage, id As String, Text As String) As ABMLabel
	Dim lbl As ABMLabel	
	lbl.Initialize(page, id, Text , ABM.SIZE_SPAN, False, "")
	Return lbl
End Sub

public Sub BuildCodeBlock(page As ABMPage, id As String, code As StringBuilder) As ABMCodeLabel
	Dim codelab As ABMCodeLabel	
	codelab.Initialize(page, id, code.ToString, "vb")
	Return codelab
End Sub

public Sub BuildCodeBlockFromSmartString(page As ABMPage, id As String, code As String) As ABMCodeLabel
	Dim codelab As ABMCodeLabel	
	codelab.Initialize(page, id, code, "vb")
	Return codelab
End Sub

public Sub BuildImage(page As ABMPage, id As String, image As String, opacity As Double, Caption As String) As ABMImage
	Dim img As ABMImage
	img.Initialize(page, id, image,opacity)
	img.IsMaterialBoxed = True
	img.IsResponsive = True
	img.Caption = Caption
	Return img
End Sub

public Sub BuildIconBlock(page As ABMPage, id As String, iconName As String) As ABMContainer
	Dim cont As ABMContainer
	cont.Initialize(page, id, "lightblue")
	cont.AddRows(2,False, "").AddCells12(1,"")
	cont.BuildGrid ' IMPORTANT
	
	' to help see how the grids looks like in the log
	' cont.DebugPrintGrid
	
	Dim lblicon As ABMLabel
	lblicon.Initialize(page, id & "icon", "", ABM.SIZE_H5, False, "whitefc")
	lblicon.IconName = iconName
	lblicon.IconSize = ABM.ICONSIZE_MEDIUM
	cont.Cell(1,1).AddComponent(lblicon)
	
	Dim lbliconName As ABMLabel
	lbliconName.Initialize(page, id & "lbl", iconName, ABM.SIZE_SPAN, False, "whitefc")
	cont.Cell(2,1).AddComponent(lbliconName)
	
	Return cont
End Sub
