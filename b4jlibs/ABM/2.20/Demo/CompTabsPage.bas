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
	Public Name As String = "CompTabsPage"
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
	
	' a tabs theme
	theme.AddTabsTheme("tabsgreen")
	theme.Tabs("tabsgreen").ForeColor = ABM.COLOR_AMBER
	theme.Tabs("tabsgreen").HoverForeColor = ABM.COLOR_GREEN
	theme.Tabs("tabsgreen").IndicatorColor = ABM.COLOR_GREEN
	
	' tabpage theme
	theme.AddContainerTheme("tabpagewhite")
	theme.Container("tabpagewhite").BackColor = ABM.COLOR_WHITE
	theme.Container("tabpagewhite").ZDepth = ABM.ZDEPTH_1
	
	' add additional themes specific for this page
	theme.AddTableTheme("tbl1theme")
	theme.Table("tbl1theme").ZDepth = ABM.ZDEPTH_1
	
	theme.Table("tbl1theme").AddCellTheme("headerfooter")
	theme.Table("tbl1theme").Cell("headerfooter").BackColor = ABM.COLOR_BLUEGREY
	theme.Table("tbl1theme").Cell("headerfooter").ForeColor = ABM.COLOR_WHITE	
	
	theme.Table("tbl1theme").AddCellTheme("headerfooterright")
	theme.Table("tbl1theme").Cell("headerfooterright").BackColor = ABM.COLOR_BLUEGREY
	theme.Table("tbl1theme").Cell("headerfooterright").ForeColor = ABM.COLOR_WHITE
	theme.Table("tbl1theme").Cell("headerfooterright").Align = ABM.TABLECELL_HORIZONTALALIGN_RIGHT
	
	theme.Table("tbl1theme").AddCellTheme("nocolor")
	theme.Table("tbl1theme").Cell("nocolor").ActiveBackColor = ABM.COLOR_BLUEGREY
	theme.Table("tbl1theme").Cell("nocolor").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN2
	
	theme.Table("tbl1theme").AddCellTheme("positive")
	theme.Table("tbl1theme").Cell("positive").BackColor = ABM.COLOR_GREEN
	theme.Table("tbl1theme").Cell("positive").BackColorIntensity = ABM.INTENSITY_LIGHTEN3
	theme.Table("tbl1theme").Cell("positive").ActiveBackColor = ABM.COLOR_GREEN
	theme.Table("tbl1theme").Cell("positive").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN1
	theme.Table("tbl1theme").Cell("positive").Align = ABM.TABLECELL_HORIZONTALALIGN_RIGHT
	
	theme.Table("tbl1theme").AddCellTheme("negative")
	theme.Table("tbl1theme").Cell("negative").BackColor = ABM.COLOR_RED
	theme.Table("tbl1theme").Cell("negative").BackColorIntensity = ABM.INTENSITY_LIGHTEN3
	theme.Table("tbl1theme").Cell("negative").ActiveBackColor = ABM.COLOR_RED
	theme.Table("tbl1theme").Cell("negative").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN1
	theme.Table("tbl1theme").Cell("negative").Align = ABM.TABLECELL_HORIZONTALALIGN_RIGHT
	
	theme.Table("tbl1theme").AddCellTheme("aligntop")
	theme.Table("tbl1theme").Cell("aligntop").VerticalAlign = ABM.TABLECELL_VERTICALALIGN_TOP
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMTabs"
	page.PageDescription = "The tabs component "	
	page.PageHTMLName = "abmaterial-tabs.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMTabs", "../images/logo.png", "", "Controls", "ABMTabs")
	
	' create the page grid	
	page.AddRows(5,True, "").AddCells12(1,"")	
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add a header label
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Introduction"))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","The tabs structure consists of an unordered list of tabs. Then when you click on each tab, only the container with the corresponding tab id will become visible. You can set disabled to make a tab inaccessible.") )
	
	' add the tabs object
	Dim tabs As ABMTabs
	tabs.Initialize(page, "tabs", "")
	
	' create the tabs as ABMContainers
	tabs.AddTab("tab1", "TAB 1", BuildTabContainer("tab1", "Demo tab text TAB1"),3,3,3,12,12,12,True,False, "", "") 
	tabs.AddTab("tab2", "TAB 2", BuildTabContainer("tab2", "Demo tab text TAB2"),3,3,3,12,12,12,True,True, "", "") 
	tabs.AddTab("tab3", "TAB 3", BuildTabContainer("tab3", "Demo tab text TAB3"),3,3,3,12,12,12,False,False, "", "") 
	'tabs.AddTab("tab4", "TAB 4", BuildTabContainer("tab4", "Demo tab text TAB4"),3,3,3,12,12,12,True,False, "") 
	
	' create a table
	Dim tbl1 As ABMTable
	tbl1.Initialize(page, "tbl1", True, False, True, "tbl1theme")
	tbl1.SetHeaders(Array As String("First Name", "Last Name", "Sales Profit"))
	tbl1.SetHeaderThemes(Array As String("headerfooter", "headerfooter", "headerfooterright"))
	
	Dim FirstNames As List
	Dim LastNames As List

	FirstNames.Initialize2(Array As String("Alain", "Jos", "Paul", "Bertrande", "Julie", "Stephanie", "Bert", "Charles", "James", "Walter"))
	LastNames.Initialize2(Array As String("Bailleul", "Rogiers", "Dougherty", "Rodrigues", "Ostrander", "Kenyon", "Grant", "Klinger", "Sheffield", "Pointdexter"))
	
	' add some random values
	For i = 0 To 9
		Dim r As List
		Dim rCellThemes As List
		r.Initialize
		rCellThemes.Initialize
		r.Add(FirstNames.get(Rnd(0,9)))
		rCellThemes.Add("nocolor")
		r.Add(LastNames.get(Rnd(0,9)))
		rCellThemes.Add("nocolor")		
		Dim Neg As Int = Rnd(0,100)
		If Neg > 50 Then
			r.Add("$" & Rnd(1000, 15000))
			rCellThemes.Add("positive")
		Else
			r.Add("$-" & Rnd(1000, 15000))
			rCellThemes.Add("negative")
		End If
		tbl1.AddRow("uid" & i, r)
		tbl1.SetRowThemes(rCellThemes) ' make sure you have as many items in rCellThemes as in r!
	Next
	
	tbl1.SetFooter("This is a footer that appears on the bottom of the table.", 12,"headerfooter")
	
	Dim tbl1cont As ABMContainer
	tbl1cont.Initialize(page, "tblcont","tabpagewhite")
	
	tbl1cont.AddRows(1,True, "").AddCells12(1,"")
	tbl1cont.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	tbl1cont.Cell(1,1).AddComponent(tbl1)
	
	tabs.AddTab("tab4", "TAB 4", tbl1cont,3,3,3,12,12,12,True,False, "","") 
	
	
	' add to cell
	page.Cell(2,1).AddComponent(tabs)
	
	' add button
	Dim btn1 As ABMButton
	btn1.InitializeRaised(page, "btn1", "", "", "Get active", "bluegrey")
	page.Cell(3,1).AddComponent(btn1)
	
	' add codeblock	
	Dim code As StringBuilder
	code.Initialize
	code.Append("Dim tabs As ABMTabs").Append(CRLF)
	code.Append("tabs.Initialize(page, ""tabs"", """")").Append(CRLF)
	code.Append("").Append(CRLF)
	code.Append("// create the tabs As ABMContainer.").Append(CRLF)
	code.Append("tabs.AddTab(""tab1"", ""TAB 1"", BuildTabContainer(page, ""tab1"", ""Demo TAB text""),3,3,3,12,12,12,True,False)").Append(CRLF) 
	code.Append("tabs.AddTab(""tab2"", ""TAB 2"", BuildTabContainer(page, ""tab2"", ""Demo TAB text""),3,3,3,12,12,12,True,True)").Append(CRLF)
	code.Append("tabs.AddTab(""tab3"", ""TAB 3"", BuildTabContainer(page, ""tab3"", ""Demo TAB text""),3,3,3,12,12,12,False,False)").Append(CRLF)
	code.Append("tabs.AddTab(""tab4"", ""TAB 4"", BuildTabContainer(page, ""tab4"", ""Demo TAB text""),3,3,3,12,12,12,True,False)").Append(CRLF)
	code.Append("").Append(CRLF)
	code.Append("// add to row").Append(CRLF)
	code.Append("page.Cell(2,1).AddComponent(tabs)").Append(CRLF)
	
	page.Cell(4,1).AddComponent(ABMShared.BuildCodeBlock(page, "code", code))
	
	' add paragraph	
	page.Cell(4,1).AddComponent(ABMShared.BuildParagraph(page,"par2","The code for BuildTabContainer:") )
	
	' add codeblock	
	Dim code2 As StringBuilder
	code2.Initialize
	code2.Append("public Sub BuildTabContainer(page As ABMPage, id As String, Text As String) As ABMContainer").Append(CRLF)
	code2.Append("  Dim Tabc As ABMContainer").Append(CRLF)
	code2.Append("  Tabc.Initialize(page, id, ""tabpagewhite"")").Append(CRLF)
	code2.Append("").Append(CRLF)
	code2.Append("  tabc.AddRows(1,True, """").AddCells12(1,"""")").Append(CRLF)
	code2.Append("  Dim lbl As ABMLabel").Append(CRLF)
	code2.Append("  lbl.Initialize(page, id & ""lbl"", Text, ABM.SIZE_H5, True, """")").Append(CRLF)
	code2.Append("  Tabc.Cell(1,1).AddComponent(lbl)").Append(CRLF)
	code2.Append("  Return Tabc").Append(CRLF)
	code2.Append("End Sub").Append(CRLF)
	
	page.Cell(4,1).AddComponent(ABMShared.BuildCodeBlock(page, "code2", code2))
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub tbl1_Clicked(PassedRowsAndColumns As List)
	' is the root table
	Dim tblCellInfo As ABMTableCell = PassedRowsAndColumns.Get(0)
	Log(tblCellInfo.TableName)
End Sub

Sub BuildTabContainer(id As String, Text As String) As ABMContainer
	Dim Tabc As ABMContainer
	Tabc.Initialize(page, id,"tabpagewhite")
	
	Tabc.AddRows(1,True, "").AddCells12(1,"")
	Tabc.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	Dim lbl As ABMLabel
	lbl.Initialize(page, id & "lbl", Text, ABM.SIZE_H5, True, "")
	Tabc.Cell(1,1).AddComponent(lbl)
	Return Tabc
End Sub


' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition
	If Action = "ABMTabs" Then Return
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

Sub btn1_Clicked(Target As String)
	Dim tabs As ABMTabs = page.Component("tabs")
	myToastId = myToastId + 1
	page.ShowToast("toast" & myToastId, "toast", tabs.GetActive & " is active!", 5000)
End Sub
