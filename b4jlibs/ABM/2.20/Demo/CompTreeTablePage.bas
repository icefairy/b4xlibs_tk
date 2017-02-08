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
	Public Name As String = "CompTreeTablePage"  '<-------------------------------------------------------- IMPORTANT
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int	
	'Dim PDFName As String	
	Dim PlusParents As Map	
	
	Type PlusStructure (Prefix As String, NextValue As Int)
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

' imagine this comes from a database, for the demo's purpose it is hard coded
' you can call this method with a different query every time (e.g. depending on the user)
Sub LoadTree()
	
	DateTime.DateFormat = "EEEE d MMMM yyyy"
	Dim view1 As ABMTreeTable = page.Component("view1")
	view1.Clear
	view1.AddRow(BuildLev1Header(1, "1", "", "", "Ypres"))
	view1.AddRow(BuildLev2Header1(2, "1_1", "1", "", "Menin Gate", DateTime.Date(DateTime.Now))) 
	view1.AddRow(BuildLev3Header(3, "1_1_1", "1_1", "" , "Hours", Array As String("HOUR"), "lev3hour", 1))	
	view1.AddRow(BuildLev4Body1(4, "1_1_1_1", "1_1_1", "", "JSM", "Jones Smith", "03:00"))
	view1.AddRow(BuildLev4Body1(4, "1_1_1_3", "1_1_1", "", "SBF", "Sindy Belfast", "03:00"))
	view1.AddRow(BuildLev4Body1(4, "1_1_1_2", "1_1_1", "", "ABA", "Alain Bailleul", "05:00"))
	view1.AddRow(BuildLev3Footer1(3, "1_1_2", "1_1", "1_1_1", "3 pers.", "11 hours", "lev3hour"))
	view1.AddRow(BuildLev3Header(3, "1_1_3", "1_1", "", "Done",Array As String("DONE"), "lev3done", 0))
	view1.AddRow(BuildLev4Body2(4, "1_1_3_1", "1_1_3", "", "First floor - swept"))
	view1.AddRow(BuildLev4Body2(4, "1_1_3_2", "1_1_3", "", "Second floor - vacuum-cleaned"))
	view1.AddRow(BuildLev3Footer2(3, "1_1_4", "1_1", "1_1_3", "lev3done"))
	view1.AddRow(BuildLev3Header(3, "1_1_5", "1_1", "", "Used devices",Array As String(), "lev3devices", 0))
	view1.AddRow(BuildLev4Body3(4, "1_1_5_1", "1_1_5", "", "Vacuum Cleaner", "2", "half a day"))
	view1.AddRow(BuildLev3Footer2(3, "1_1_6", "1_1", "1_1_5", "lev3devices"))
	view1.AddRow(BuildLev3Header(3, "1_1_7", "1_1", "", "Result",Array As String(), "", 0))
	view1.AddRow(BuildLev4Body3(4, "1_1_7_1", "1_1_7", "", "2 dust bins full", "2", "ton"))
	view1.AddRow(BuildLev3Footer2(3, "1_1_8", "1_1", "1_1_7", ""))
	view1.AddRow(BuildLev3Header(3, "1_1_9", "1_1", "", "Extra info",Array As String(), "", 0))
	view1.AddRow(BuildLev4Body2(4, "1_1_9_1", "1_1_9", "", "Everything cleaned, vacuum cleaner needs to be repaired"))
	view1.AddRow(BuildLev3Footer2(3, "1_1_10", "1_1", "1_1_9", ""))
	view1.AddRow(BuildLev3Header(3, "1_1_11", "1_1", "", "Overview",Array As String(), "", 0))
	view1.AddRow(BuildLev4Body4(4, "1_1_11_1", "1_1_11", "", Array As Int(30,50,70,80,100,140,170), Array As Int(100,120,180,150,190,100,70)))
	view1.AddRow(BuildLev3Footer2(3, "1_1_12", "1_1", "1_1_11", ""))
	view1.AddRow(BuildLev2Footer(2, "1_2", "1", "1_1"))
	
	PlusParents.Put("1_2", NewPlusStructure("1_1_1", 4))
		
	view1.AddRow(BuildLev2Header1(2, "1_3", "1", "", "Big Square", DateTime.Date(DateTime.Now)))
	view1.AddRow(BuildLev3Header(3, "1_3_1", "1_3", "" , "Hours",Array As String("HOUR"), "lev3hour", 1))
	view1.AddRow(BuildLev4Body1(4, "1_3_1_1", "1_3_1", "", "SBF", "Sindy Belfast", "04:00"))
	view1.AddRow(BuildLev3Footer1(3, "1_3_2", "1_3", "1_3_1", "1 pers.", "4 hours", "lev3hour"))
	view1.AddRow(BuildLev3Header(3, "1_3_3", "1_3", "", "Done",Array As String("DONE"), "lev3done", 0))
	view1.AddRow(BuildLev4Body2(4, "1_3_3_1", "1_3_3", "", "First floor - swept"))
	view1.AddRow(BuildLev4Body2(4, "1_3_3_2", "1_3_3", "", "Second floor - vacuum-cleaned"))
	view1.AddRow(BuildLev3Footer2(3, "1_3_4", "1_3", "1_3_3", "lev3done"))
	view1.AddRow(BuildLev3Header(3, "1_3_5", "1_3", "", "On map",Array As String(), "", 0))
	view1.AddRow(BuildLev4Body5(4, "1_3_5_1", "1_3_5", "", 50.8500, 2.8833))
	view1.AddRow(BuildLev3Footer2(3, "1_3_6", "1_3", "1_3_5", ""))
	view1.AddRow(BuildLev2Footer(2, "1_4", "1", "1_3"))
	
	PlusParents.Put("1_4", NewPlusStructure("1_3_1", 2))
	
	view1.AddRow(BuildLev2Header1(2, "1_5", "1", "", "Swimming pool", DateTime.Date(DateTime.Now)))
	view1.AddRow(BuildLev3Header(3, "1_5_1", "1_5", "" , "Hours",Array As String("HOUR"), "lev3hour", 1))
	view1.AddRow(BuildLev4Body1(4, "1_5_1_1", "1_5_1", "", "SBF", "Sindy Belfast", "04:00"))
	view1.AddRow(BuildLev3Footer1(3, "1_5_2", "1_5", "1_5_1", "1 pers.", "4 hours", "lev3hour"))
	view1.AddRow(BuildLev3Header(3, "1_5_3", "1_5", "", "Done",Array As String("DONE"), "lev3done", 0))
	view1.AddRow(BuildLev4Body2(4, "1_5_3_1", "1_5_3", "", "First floor - swept"))
	view1.AddRow(BuildLev3Footer2(3, "1_5_4", "1_5", "1_5_3", "lev3done"))
	view1.AddRow(BuildLev3Header(3, "1_5_5", "1_5", "", "Used devices",Array As String(), "lev3devices", 0))
	view1.AddRow(BuildLev4Body3(4, "1_5_5_1", "1_5_5", "", "Vacuum Cleaner", "2", "half a day"))
	view1.AddRow(BuildLev3Footer2(3, "1_5_6", "1_5", "1_5_5", "lev3devices"))	
	view1.AddRow(BuildLev2Footer(2, "1_6", "1", "1_5"))
	
	PlusParents.Put("1_6", NewPlusStructure("1_5_1", 1))
	
	view1.AddRow(BuildLev2Header1(2, "1_7", "1", "", "Parking lot", DateTime.Date(DateTime.Now)))
	view1.AddRow(BuildLev3Header(3, "1_7_1", "1_7", "", "Hours",Array As String("HOUR"), "lev3hour", 1))
	view1.AddRow(BuildLev4Body1(4, "1_7_1_1", "1_7_1", "", "ABA", "Alain Bailleul", "05:00"))
	view1.AddRow(BuildLev4Body1(4, "1_7_1_2", "1_7_1", "", "JSM", "Jones Smith", "03:00"))
	view1.AddRow(BuildLev4Body1(4, "1_7_1_3", "1_7_1", "", "SBF", "Sindy Belfast", "03:00"))
	view1.AddRow(BuildLev3Footer1(3, "1_7_2", "1_7", "1_7_1", "3 pers.", "11 hours", "lev3hour"))
	view1.AddRow(BuildLev3Header(3, "1_7_3", "1_7", "", "Done",Array As String("DONE"), "lev3done", 0))
	view1.AddRow(BuildLev4Body2(4, "1_7_3_1", "1_7_3", "", "First floor - swept"))
	view1.AddRow(BuildLev3Footer2(3, "1_7_4", "1_7", "1_7_3", "lev3done"))
	view1.AddRow(BuildLev3Header(3, "1_7_5", "1_7", "", "Result",Array As String(), "", 0))
	view1.AddRow(BuildLev4Body3(4, "1_7_5_1", "1_7_5", "", "2 dust bins full", "2", "ton"))
	view1.AddRow(BuildLev3Footer2(3, "1_7_6", "1_7", "1_7_5", ""))
	view1.AddRow(BuildLev2Footer(2, "1_8", "1", "1_7"))
	
	PlusParents.Put("1_8", NewPlusStructure("1_7_1", 4))
	
	view1.AddRow(BuildLev1Footer(1, "2", "", "1"))
	
	view1.AddRow(BuildLev1Header(1, "3", "", "", "Brussels"))
	view1.AddRow(BuildLev2Header1(2, "3_1", "3", "", "Palace", DateTime.Date(DateTime.Now)))
	view1.AddRow(BuildLev3Header(3, "3_1_1", "3_1", "" , "Hours",Array As String("HOUR"), "lev3hour", 1))
	view1.AddRow(BuildLev4Body1(4, "3_1_1_1", "3_1_1", "", "ABA", "Alain Bailleul", "05:00"))
	view1.AddRow(BuildLev4Body1(4, "3_1_1_2", "3_1_1", "", "SBF", "Sindy Belfast", "03:00"))
	view1.AddRow(BuildLev3Footer1(3, "3_1_2", "3_1", "3_1_1", "2 pers.", "8 hours", "lev3hour"))
	view1.AddRow(BuildLev3Header(3, "3_1_3", "3_1", "", "Done",Array As String("DONE"), "lev3done", 0))
	view1.AddRow(BuildLev4Body2(4, "3_1_3_1", "3_1_3", "", "First floor - swept"))
	view1.AddRow(BuildLev4Body2(4, "3_1_3_2", "3_1_3", "", "Second floor - vacuum-cleaned"))
	view1.AddRow(BuildLev3Footer2(3, "3_1_4", "3_1", "3_1_3", "lev3done"))
	
	view1.AddRow(BuildLev2Footer(2, "3_2", "3", "3_1"))
	
	PlusParents.Put("3_2", NewPlusStructure("3_1_1", 3))
	
	view1.AddRow(BuildLev1Footer(1, "4", "", "3"))
		
	view1.Refresh
End Sub

Sub NewPlusStructure(Prefix As String, NextValue As Int) As PlusStructure
	Dim ps As PlusStructure
	ps.Initialize
	ps.Prefix = Prefix
	ps.NextValue = NextValue
	Return ps
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
	theme.AddTreeTableTheme("view1")
	theme.TreeTable("view1").AddCellTheme("lev1default")
		
	theme.TreeTable("view1").Cell("lev1default").BackColor = ABM.COLOR_LIGHTBLUE
	theme.TreeTable("view1").Cell("lev1default").BackColorIntensity = ABM.INTENSITY_DARKEN3
	theme.TreeTable("view1").Cell("lev1default").ForeColor = ABM.COLOR_WHITE
	theme.TreeTable("view1").Cell("lev1default").IsEditable = True
		
	theme.TreeTable("view1").AddCellTheme("lev2default")
	theme.TreeTable("view1").Cell("lev2default").BackColor = ABM.COLOR_LIGHTBLUE
	theme.TreeTable("view1").Cell("lev2default").BackColorIntensity = ABM.INTENSITY_LIGHTEN2
		
	theme.TreeTable("view1").AddCellTheme("lev3default")
	theme.TreeTable("view1").Cell("lev3default").BackColor = ABM.COLOR_LIGHTBLUE
	theme.TreeTable("view1").Cell("lev3default").BackColorIntensity = ABM.INTENSITY_LIGHTEN4
	
	theme.TreeTable("view1").AddCellTheme("lev3hour")
	theme.TreeTable("view1").Cell("lev3hour").BackColor = ABM.COLOR_LIGHTGREEN
	theme.TreeTable("view1").Cell("lev3hour").BackColorIntensity = ABM.INTENSITY_LIGHTEN4
	
	theme.TreeTable("view1").AddCellTheme("lev3done")
	theme.TreeTable("view1").Cell("lev3done").BackColor = ABM.COLOR_ORANGE
	theme.TreeTable("view1").Cell("lev3done").BackColorIntensity = ABM.INTENSITY_LIGHTEN4
	
	theme.TreeTable("view1").AddCellTheme("lev3devices")
	theme.TreeTable("view1").Cell("lev3devices").BackColor = ABM.COLOR_PURPLE
	theme.TreeTable("view1").Cell("lev3devices").BackColorIntensity = ABM.INTENSITY_LIGHTEN4
			
	theme.TreeTable("view1").AddCellTheme("lev4default")
	theme.TreeTable("view1").Cell("lev4default").BackColor = ABM.COLOR_WHITE	
	
	theme.TreeTable("view1").AddCellTheme("lev4right")
	theme.TreeTable("view1").Cell("lev4right").BackColor = ABM.COLOR_WHITE	
	theme.TreeTable("view1").Cell("lev4right").Align = ABM.TABLECELL_HORIZONTALALIGN_RIGHT
	
	theme.TreeTable("view1").AddCellTheme("lev4orange")
	theme.TreeTable("view1").Cell("lev4orange").BackColor = ABM.COLOR_AMBER
	theme.TreeTable("view1").Cell("lev4orange").BackColorIntensity = ABM.INTENSITY_LIGHTEN3
	
	theme.TreeTable("view1").AddTreeIconColorTheme("white")
	theme.TreeTable("view1").TreeIconColor("white").ForeColor = ABM.COLOR_WHITE
	
	theme.AddChartTheme("chart1theme")
	theme.Chart("chart1theme").Serie(ABM.CHART_SERIEINDEX_C).LinePointStrokeWidthPx=8
	theme.Chart("chart1theme").Serie(ABM.CHART_SERIEINDEX_C).LineStrokeWidthPx=5	
	
	' bluegray button
	theme.AddButtonTheme("bluegrey")
	theme.Button("bluegrey").BackColor = ABM.COLOR_BLUEGREY
	theme.Button("bluegrey").BackColorIntensity = ABM.INTENSITY_DARKEN1
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMTreeTable"
	page.PageDescription = "The tree table component "	
	page.PageHTMLName = "abmaterial-tree-table.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	'page.NeedsChart=True ' needed because we're going to add charts in our tree later
	'page.NeedsGoogleMap=True ' needed because we're going to add google maps in our tree later
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
			
	' adding a navigation bar
	ABMShared.BuildNavigationBar(page, "ABMTreeTable", "../images/logo.png", "", "Controls", "ABMTreeTable")
			
	' create the page grid
	page.AddRows(6,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)	
End Sub

Sub ConnectPage()
	PlusParents.Initialize
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.CellR(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","With the ABMTreeTable component you can build collapsable tree structures.  You can even use them to create simple reports (see the ABMPrint module).") )
	' add paragraph	
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par2","The tree is dynamic so you add, change, delete and move (try dragging an 'hour' detail line to another 'hour' block for example).") )
	
	' build an empty example tree	
	Dim view1 As ABMTreeTable
	view1.Initialize(page, "view1", False, "view1", 20, Array As String("lev1default", "lev2default", "lev3default", "lev4default"), 24)
	view1.CollapseTooltip = "Close"
	view1.ExpandTooltip = "Open"	
		
	page.CellR(1,1).AddComponent(view1)
	
'	Dim btnGetSign As ABMButton
'	btnGetSign.InitializeRaised(page, "btnPrint", "", "", "Create PDF", "bluegrey")
'	page.CellR(1,1).AddComponent(btnGetSign)
		
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	LoadTree
	
	Dim view1 As ABMTreeTable = page.Component("view1")
	view1.Expand("1")	
	
	page.RestoreNavigationBarPosition	
End Sub

Sub BuildLev1Header(depth As Int, treeRowId As String, treeRowParentId As String, IsFooterForId As String, Stad As String) As ABMtreeTableRow
	Dim l As ABMtreeTableRow
	l.Initialize(depth, treeRowId, treeRowParentId, IsFooterForId, "", "white", "")	
	Dim cell1 As ABMTreeTableCell
	cell1.Initalize("v1_" & treeRowId & "c1", Stad, 1,24, False, "")
	l.Addcell(cell1)
	Return l
End Sub

Sub BuildLev1Footer(depth As Int, treeRowId As String, treeRowParentId As String, IsFooterForId As String) As ABMtreeTableRow
	Dim l As ABMtreeTableRow
	l.Initialize(depth, treeRowId, treeRowParentId, IsFooterForId, "", "white", "")	
	Dim cell1 As ABMTreeTableCell
	cell1.InitalizeAsIcon("v1_" & treeRowId & "c1", "", "", 3,3, "")
	l.addcell(cell1)
	Return l
End Sub

Sub BuildLev2Header1(depth As Int, treeRowId As String, treeRowParentId As String, IsFooterForId As String, Straat As String, Datum As String) As ABMtreeTableRow
	Dim l As ABMtreeTableRow
	l.Initialize(depth, treeRowId, treeRowParentId, IsFooterForId, "", "", "")	
	Dim cell1 As ABMTreeTableCell
	cell1.Initalize("v1_" & treeRowId & "c1", Straat, 2,12, False, "")
	l.addcell(cell1)
	Dim cell2 As ABMTreeTableCell
	cell2.Initalize("v1_" & treeRowId & "c2", Datum, 14,10, False, "")
	l.addcell(cell2)
	Return l
End Sub

Sub BuildLev2Footer(depth As Int, treeRowId As String, treeRowParentId As String, IsFooterForId As String) As ABMtreeTableRow
	Dim l As ABMtreeTableRow
	l.Initialize(depth, treeRowId, treeRowParentId, IsFooterForId, "", "", "")	
	Dim cell1 As ABMTreeTableCell
	cell1.InitalizeAsIcon("v1_" & treeRowId & "c1", "mdi-content-add", "", 4,3, "")
	l.addcell(cell1)
	Return l
End Sub

Sub BuildLev3Header(depth As Int, treeRowId As String, treeRowParentId As String, IsFooterForId As String, soort As String, DragDropNames As List, overruleTheme As String, sortIndex As Int) As ABMtreeTableRow
	Dim l As ABMtreeTableRow
	l.Initialize(depth, treeRowId, treeRowParentId, IsFooterForId, "", "", overruleTheme)	
	If sortIndex > 0 Then
		l.SortChildrenOn(sortIndex)
	End If
	l.SetCanReceiveDropsFrom(DragDropNames)
	Dim cell1 As ABMTreeTableCell
	cell1.Initalize("v1_" & treeRowId & "c1", soort, 3,21, False, "")
	l.Addcell(cell1)
	Return l
End Sub

Sub BuildLev3Footer1(depth As Int, treeRowId As String, treeRowParentId As String, IsFooterForId As String, pers As String, time As String, overruleTheme As String) As ABMtreeTableRow
	Dim l As ABMtreeTableRow
	l.Initialize(depth, treeRowId, treeRowParentId, IsFooterForId, "", "", overruleTheme)	
	Dim cell1 As ABMTreeTableCell
	cell1.Initalize("v1_" & treeRowId & "c1", pers, 4,3, False, "")
	l.Addcell(cell1)
	Dim cell2 As ABMTreeTableCell
	cell2.Initalize("v1_" & treeRowId & "c2", time, 16,4, False, "")
	l.Addcell(cell2)
	Return l
End Sub

Sub BuildLev3Footer2(depth As Int, treeRowId As String, treeRowParentId As String, IsFooterForId As String, overruleTheme As String) As ABMtreeTableRow
	Dim l As ABMtreeTableRow
	l.Initialize(depth, treeRowId, treeRowParentId, IsFooterForId, "", "", overruleTheme)	
	Dim cell1 As ABMTreeTableCell
	cell1.Initalize("v1_" & treeRowId & "c1", "", 4,3, False, "")
	l.Addcell(cell1)
	Return l
		
End Sub

Sub BuildLev4Body1(depth As Int, treeRowId As String, treeRowParentId As String, IsFooterForId As String, Code As String, Naam As String, Hours As String) As ABMtreeTableRow
	Dim l As ABMtreeTableRow
	l.Initialize(depth, treeRowId, treeRowParentId, IsFooterForId, "HOUR", "", "")	
	Dim cell1 As ABMTreeTableCell
	cell1.Initalize("v1_" & treeRowId & "c1", Code, 4,3, False, "")
	l.Addcell(cell1)
	Dim cell2 As ABMTreeTableCell
	cell2.Initalize("v1_" & treeRowId & "c2", Naam, 8,6, False, "")
	l.Addcell(cell2)
	Dim cell3 As ABMTreeTableCell
	cell3.Initalize("v1_" & treeRowId & "c3", Hours, 15,2, False, "")
	l.Addcell(cell3)
	
	Dim cell4 As ABMTreeTableCell
	Dim btnEdit As ABMButton
	btnEdit.InitializeFloating(page, treeRowId, "mdi-action-visibility", "")
	btnEdit.size = ABM.BUTTONSIZE_SMALL
	cell4.InitalizeAsComponent("v1_" & treeRowId & "cEdit", btnEdit, "btnEdit", 18,1, "")
	l.Addcell(cell4)
		
	Dim cell5 As ABMTreeTableCell
	Dim btnDelete As ABMButton
	btnDelete.InitializeFloating(page, treeRowId, "mdi-action-delete", "")
	btnDelete.size = ABM.BUTTONSIZE_SMALL
	cell5.InitalizeAsComponent("v1_" & treeRowId & "cDelete", btnDelete, "btnDelete", 19,1, "")
	l.Addcell(cell5)
		
	Return l
End Sub

Sub BuildLev4Body2(depth As Int, treeRowId As String, treeRowParentId As String, IsFooterForId As String, Artikel As String) As ABMtreeTableRow
	Dim l As ABMtreeTableRow
	l.Initialize(depth, treeRowId, treeRowParentId, IsFooterForId, "DONE", "", "")	
	Dim cell1 As ABMTreeTableCell
	cell1.Initalize("v1_" & treeRowId & "c1", Artikel, 4,19, False, "")
	l.Addcell(cell1)
	Return l
End Sub

Sub BuildLev4Body3(depth As Int, treeRowId As String, treeRowParentId As String, IsFooterForId As String, Artikel As String, aantal As String, eenheid As String) As ABMtreeTableRow
	Dim l As ABMtreeTableRow
	l.Initialize(depth, treeRowId, treeRowParentId, IsFooterForId, "", "", "")	
	Dim cell1 As ABMTreeTableCell
	cell1.Initalize("v1_" & treeRowId & "c1", Artikel, 4,9, False, "")
	l.Addcell(cell1)
	Dim cell2 As ABMTreeTableCell
	cell2.Initalize("v1_" & treeRowId & "c2", aantal, 15,2, False, "lev4right")
	l.Addcell(cell2)
	Dim cell3 As ABMTreeTableCell
	cell3.Initalize("v1_" & treeRowId & "c3", eenheid, 17,3, False, "lev4orange")
	l.Addcell(cell3)
	Return l
End Sub

Sub BuildLev4Body4(depth As Int, treeRowId As String, treeRowParentId As String, IsFooterForId As String, values1 As List, values2 As List) As ABMtreeTableRow
	' create a line chart
	Dim chart1 As ABMChart
	chart1.Initialize(page, treeRowId, ABM.CHART_TYPELINE, ABM.CHART_RATIO_GOLDENSECTION, "chart1theme")
		
	' add the labels
	chart1.AddLabels(Array As String("Mon", "The", "Wed", "Thu", "Fri", "Sat", "Sun"))
	' set some options
	chart1.OptionsLine.FullWidth=True
	chart1.OptionsLine.ChartPaddingRight=60 ' because we set fullwidth, we have to adjust so the final label also fits
	chart1.OptionsLine.Serie(ABM.CHART_SERIEINDEX_A).LineSmooth = ABM.CHART_LINESMOOTH_NONE
	chart1.OptionsLine.Serie(ABM.CHART_SERIEINDEX_C).LineSmooth = ABM.CHART_LINESMOOTH_SIMPLE
	chart1.OptionsLine.Serie(ABM.CHART_SERIEINDEX_C).ShowArea = True
	
	' add some series	
	Dim SerieA As ABMChartSerie
	SerieA.InitializeForLine(ABM.CHART_SERIEINDEX_A)
	SerieA.SetValues(values1)
	chart1.AddSerie(SerieA)
	
	Dim SerieC As ABMChartSerie
	SerieC.InitializeForLine(ABM.CHART_SERIEINDEX_C)
	SerieC.SetValues(values2)
	chart1.AddSerie(SerieC)
	
	Dim l As ABMtreeTableRow
	l.Initialize(depth, treeRowId, treeRowParentId, IsFooterForId, "", "", "")	
	Dim cell1 As ABMTreeTableCell
	cell1.InitalizeAsComponent("v1_" & treeRowId & "c1", chart1, "chart1", 4,19, "")
	l.Addcell(cell1)
	Return l
End Sub

Sub BuildLev4Body5(depth As Int, treeRowId As String, treeRowParentId As String, IsFooterForId As String, lat As Double, lng As Double) As ABMtreeTableRow
	' create the google map
	Dim gm1 As ABMGoogleMap
	gm1.Initialize(page, treeRowId, lat, lng, 15, 350, ABM.GOOGLEMAPTYPE_ROADMAP)
	gm1.Draggable = False
	gm1.HasMapTypeControl = True	
	gm1.HasStreetViewControl = True
	gm1.HasZoomControl = True
	gm1.AddMapType(ABM.GOOGLEMAPTYPE_ROADMAP)
	gm1.AddMapType(ABM.GOOGLEMAPTYPE_TERRAIN)
	gm1.AddMapType(ABM.GOOGLEMAPTYPE_HYBRID)
	gm1.AddMapType(ABM.GOOGLEMAPTYPE_SATELLITE)
	
	Dim l As ABMtreeTableRow
	l.Initialize(depth, treeRowId, treeRowParentId, IsFooterForId, "", "", "")	
	Dim cell1 As ABMTreeTableCell
	cell1.InitalizeAsComponent("v1_" & treeRowId & "g1", gm1, "gm1", 4,19, "")
	l.Addcell(cell1)
	Return l
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition
	If Action = "ABMTreeTable" Then Return
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

Sub Page_FileUploaded(FileName As String, success As Boolean)	
	
End Sub

Sub Page_ToastClicked(ToastId As String, Action As String)
		
End Sub

Sub Page_ToastDismissed(ToastId As String)	
	
End Sub

' event raised when node is expanded by the user so maybe som children (like a ABMGoogleMap) needs to be refreshed
Sub View1_NeedsRefreshChildren(rowId As String)
	Dim view1 As ABMTreeTable = page.Component("view1")
	view1.RefreshChildren(rowId)
End Sub

' the user clicked on a row
Sub view1_Clicked(TreeRowId As String, TreeCellId As String)
	
	' did he click on a plus, let him add the values of the new row
	If PlusParents.ContainsKey(TreeRowId) Then
		Dim ps As PlusStructure = PlusParents.Get(TreeRowId)
		
		' here you can show a modal sheet where the user adds new data in the browser
		' after saving the modal sheet, add the new data in the database and add a new leaf
		
		Log("The user added a new row: " & ps.Prefix & "_" & ps.NextValue)
		
		Dim view1 As ABMTreeTable = page.Component("view1")
		DateTime.timeFormat = "HH:mm:ss"
		view1.AddRow(BuildLev4Body1(4, ps.Prefix & "_" & ps.NextValue, ps.Prefix, "", "NEW", DateTime.time(DateTime.Now), "01:00"))
		ps.NextValue = ps.NextValue + 1
		PlusParents.Put(TreeRowId, ps)
		view1.Refresh	
	End If
	
End Sub

Sub view1_Dropped(Params As Map)
	Dim Success As Boolean = Params.Get("success")
	Dim TreeRowId As String = Params.Get("treerowid")
	Dim FromTreeRowID As String = Params.get("fromtreerowid")
	Dim OnTreeRowID As String = Params.get("ontreerowid")
	Log("TreeRowId: " & TreeRowId & "from: " & FromTreeRowID & " dropped on: " & OnTreeRowID & " Success: " & Success)
	
	Dim view1 As ABMTreeTable = page.Component("view1")
	view1.Sync(TreeRowId, FromTreeRowID, OnTreeRowID) ' IMPORTANT so the tree in memory is the same as the tree in the browser
End Sub

' here a sheet can be shown to let the user modify the row
Sub btnEdit_Clicked(Target As String)
	' get the current row form the Target btnEdit1_1_1_1 -> 1_1_1_1
	Dim currRow As String = ABMShared.Mid2(Target, 8)
	Log("btnEdit: " & currRow)
	
	' do your stuff in the database
	
	' change it in the tree
	Dim view1 As ABMTreeTable = page.Component("view1")
	DateTime.timeFormat = "HH:mm:ss"
	view1.SetString(currRow, 2, DateTime.time(DateTime.Now))
	' refresh, only what is changed will be refreshed
	view1.Refresh
End Sub

Sub btnDelete_Clicked(Target As String)
	' get the current row form the Target btnDelete1_1_1_1 -> 1_1_1_1
	Dim currRow As String = ABMShared.Mid2(Target, 10)
	Log("btnDelete: " & currRow)
	
	' do your stuff in the database
	
	
	' delete it in the tree
	Dim view1 As ABMTreeTable = page.Component("view1")
	view1.RemoveRow(currRow)
	' refresh, only what is changed will be refreshed
	view1.Refresh
End Sub

'Sub btnPrint_Clicked(Target As String)
'	Log("print clicked")
'	
'	'page.ws.RunFunction("doprint", Null)
'	'page.ws.Flush
'	
'	Dim view1 As ABMTreeTable = page.Component("view1")
'	PDFName = "test" & DateTime.Now
'	ABMPrint.PrintToPDF(page, Me, theme, "view1", view1, File.DirApp, PDFName & ".pdf")	
'End Sub
'
'public Sub PDFCreated()
'	Dim lbl As ABMLabel
'	lbl.Initialize(page, "lbl" & PDFName, "{AL}../PDF/" & PDFName & ".pdf" & "{AT}Download here{/AL}", ABM.SIZE_H6, False, "")
'	page.Cell(6,1).AddComponent(lbl)
'	page.Row(6).Refresh	
'End Sub

