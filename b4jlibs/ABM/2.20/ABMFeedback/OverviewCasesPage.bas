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
	Public Name As String = "OverviewCasesPage"
	
	' your own variables
	Dim myToastId As Int
	Dim ActiveCaseId As Int
	Dim ActiveCaseNumber As String
	Dim ActiveCaseUserID As Int
	
	Dim ActiveCaseNoteID As Int
	Dim Filter As String
	Dim FilterCount As String
	Dim LastSort As String = " ORDER BY CaseCreationDate DESC, CaseId "
	'Dim MyPoints As Map
	'Dim MyNotAvailablePoints As Map
	Dim UserType As String
	Dim UserID As Int
	Dim UserName As String
	Dim Attachments As Map
	Dim RemoveAttachments As Map
	Dim TypeDelete As String
		
	Public DownloadFolder As String = "/www/" & ABMShared.AppName & "/uploads/"
	Public DownloadMaxSize As String = 500*1024
	Public MaxRows As Int = 10
	Private ABMPageId As String = ""
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	' build the local structure IMPORTANT!
	' start with the base theme defined in ABMShared
	theme.Initialize("pagetheme")
	theme.AddABMTheme(ABMShared.MyTheme)
	
	' add additional themes specific for this page
	theme.AddTableTheme("tbltheme")
	theme.Table("tbltheme").ZDepth = ABM.ZDEPTH_1
	
	theme.Table("tbltheme").AddCellTheme("bg")
	theme.Table("tbltheme").Cell("bg").BackColor = ABM.COLOR_BLUEGREY
	theme.Table("tbltheme").Cell("bg").ForeColor = ABM.COLOR_WHITE	
	
	theme.Table("tbltheme").AddCellTheme("bgr")
	theme.Table("tbltheme").Cell("bgr").BackColor = ABM.COLOR_BLUEGREY
	theme.Table("tbltheme").Cell("bgr").ForeColor = ABM.COLOR_WHITE
	theme.Table("tbltheme").Cell("bgr").Align = ABM.TABLECELL_HORIZONTALALIGN_RIGHT	
	
	theme.Table("tbltheme").AddCellTheme("bgc")
	theme.Table("tbltheme").Cell("bgc").BackColor = ABM.COLOR_BLUEGREY
	theme.Table("tbltheme").Cell("bgc").ForeColor = ABM.COLOR_WHITE
	theme.Table("tbltheme").Cell("bgc").Align = ABM.TABLECELL_HORIZONTALALIGN_CENTER
	
	theme.Table("tbltheme").AddCellTheme("nocolor")
	theme.Table("tbltheme").Cell("nocolor").ActiveBackColor = ABM.COLOR_BLUEGREY
	theme.Table("tbltheme").Cell("nocolor").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN2
	
	theme.Table("tbltheme").AddCellTheme("positive")
	theme.Table("tbltheme").Cell("positive").BackColor = ABM.COLOR_GREEN
	theme.Table("tbltheme").Cell("positive").BackColorIntensity = ABM.INTENSITY_LIGHTEN3
	theme.Table("tbltheme").Cell("positive").ActiveBackColor = ABM.COLOR_GREEN
	theme.Table("tbltheme").Cell("positive").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN1
	'theme.Table("tbltheme").Cell("positive").Align = ABM.TABLECELL_HORIZONTALALIGN_RIGHT
	
	theme.Table("tbltheme").AddCellTheme("caseorange")
	theme.Table("tbltheme").Cell("caseorange").BackColor = ABM.COLOR_ORANGE
	theme.Table("tbltheme").Cell("caseorange").BackColorIntensity = ABM.INTENSITY_LIGHTEN3
	theme.Table("tbltheme").Cell("caseorange").ActiveBackColor = ABM.COLOR_ORANGE
	theme.Table("tbltheme").Cell("caseorange").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN1
	
	theme.Table("tbltheme").AddCellTheme("casegrey")
	theme.Table("tbltheme").Cell("casegrey").BackColor = ABM.COLOR_GREY
	theme.Table("tbltheme").Cell("casegrey").BackColorIntensity = ABM.INTENSITY_LIGHTEN3
	theme.Table("tbltheme").Cell("casegrey").ActiveBackColor = ABM.COLOR_GREY
	theme.Table("tbltheme").Cell("casegrey").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN1
	
	theme.Table("tbltheme").AddCellTheme("caseyellow")
	theme.Table("tbltheme").Cell("caseyellow").BackColor = ABM.COLOR_YELLOW
	theme.Table("tbltheme").Cell("caseyellow").BackColorIntensity = ABM.INTENSITY_LIGHTEN3
	theme.Table("tbltheme").Cell("caseyellow").ActiveBackColor = ABM.COLOR_YELLOW
	theme.Table("tbltheme").Cell("caseyellow").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN1
	
	theme.Table("tbltheme").AddCellTheme("negative")
	theme.Table("tbltheme").Cell("negative").BackColor = ABM.COLOR_RED
	theme.Table("tbltheme").Cell("negative").BackColorIntensity = ABM.INTENSITY_LIGHTEN3
	theme.Table("tbltheme").Cell("negative").ActiveBackColor = ABM.COLOR_RED
	theme.Table("tbltheme").Cell("negative").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN1
	'theme.Table("tbltheme").Cell("negative").Align = ABM.TABLECELL_HORIZONTALALIGN_RIGHT
	
	theme.Table("tbltheme").AddCellTheme("unread")	
	theme.Table("tbltheme").Cell("unread").ActiveBackColor = ABM.COLOR_BLUEGREY
	theme.Table("tbltheme").Cell("unread").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN2		
	theme.Table("tbltheme").Cell("unread").BorderColor = ABM.COLOR_LIGHTBLUE
	theme.Table("tbltheme").Cell("unread").BorderWidth = 1
	theme.Table("tbltheme").Cell("unread").Align = ABM.TABLECELL_HORIZONTALALIGN_RIGHT
	
	theme.Table("tbltheme").AddCellTheme("points")	
	theme.Table("tbltheme").Cell("points").ActiveBackColor = ABM.COLOR_BLUEGREY
	theme.Table("tbltheme").Cell("points").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN2
	theme.Table("tbltheme").Cell("points").Align = ABM.TABLECELL_HORIZONTALALIGN_RIGHT
	
	theme.Table("tbltheme").AddCellTheme("openedit")	
	theme.Table("tbltheme").Cell("openedit").ActiveBackColor = ABM.COLOR_BLUEGREY
	theme.Table("tbltheme").Cell("openedit").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN2
	theme.Table("tbltheme").Cell("openedit").Align = ABM.TABLECELL_HORIZONTALALIGN_CENTER
	
	' add additional themes specific for this page
	theme.AddButtonTheme("bigblue")
	theme.Button("bigblue").BackColor = ABM.COLOR_LIGHTBLUE
	
	' modal sheet
	theme.AddContainerTheme("modalcontent")
	theme.Container("modalcontent").BackColor = ABM.COLOR_WHITE	
	
	' modal sheet
	theme.AddContainerTheme("modalfooter")
	theme.Container("modalfooter").BackColor = ABM.COLOR_LIGHTBLUE
	
	' chip
	theme.AddChipTheme("chip")
	theme.Chip("chip").BackColorIntensity = ABM.INTENSITY_LIGHTEN4
	
	' note container theme
	theme.AddContainerTheme("notetheme")
	theme.Container("notetheme").BackColor = ABM.COLOR_BLUEGREY
	theme.Container("notetheme").BackColorIntensity = ABM.INTENSITY_LIGHTEN5
	theme.Container("notetheme").ZDepth = ABM.ZDEPTH_1
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	' SPECIAL ONE, we're going to add chips later for the zip attachments, but not in the build
	' however, we want all javascript code and css code to be loaded.
	' Note: in case you add chips in BuildPage() this is done automatically by ABMaterial	
	page.NeedsChips = True 	
	page.PageTitle = "ABMFeedback"
	page.PageDescription = "Feedback App for the ABMaterial Framework for B4J"	
	page.PageHTMLName = "index.html"
	page.PageKeywords = ""
	page.PageSiteMapPriority = ""
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_YEARLY
	page.DisableBackButton = True
	page.ShowConnectedIndicator = True
		
	ABMShared.BuildNavigationBar(page, "Overview Cases", "../images/logo.png", "Cases", "", "")
		
	' create the page grid
	page.AddRowsM(2,True,0,0, "").AddCells12(1,"")	
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,6,6,8,"").AddCellsOS(1,0,0,0,4,4,2,"").AddCellsOSMP(1,0,0,0,2,2,1,14,0,0,0,"")
	page.AddRows(4,True, "").AddCells12(1,"")	
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' add a modal sheet template to enter user information
	page.AddModalSheetTemplate(BuildInputSheet)
	' add a modal sheet template for a yes no msgbox
	page.AddModalSheetTemplate(BuildMsgBoxYesNo)
	' add a modal sheet template for a  msgbox
	page.AddModalSheetTemplate(BuildMsgBox)
	' add a modal sheet template for an upload
	page.AddModalSheetTemplate(BuildAttachmentSheet)
	' add a modal sheet template to enter case information
	page.AddModalSheetTemplate(BuildNoteInputSheet)
	
	' create the action button
	Dim AddCaseBtn As ABMActionButton
	AddCaseBtn.Initialize(page, "AddCaseBtn", "mdi-content-add", "", "bigblue")
	AddCaseBtn.MainButton.Size = ABM.BUTTONSIZE_LARGE
	
	' add to page
	page.AddActionButton(AddCaseBtn)	
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
		
		' Load the dynamic part of the page
		' ********************* 1 **********************
		' set all the code you have in ConnectPage() HERE.
		' add paragraph	
		page.CellR(1,1).AddComponent(ABMShared.BuildParagraphBQ(page,"par1","Before submitting a new case, please check if it is not in the Feedback already!") )
			
		Dim searchCase As ABMInput
		searchCase.Initialize(page, "searchCase", ABM.INPUT_TEXT, "Search case", False, "lightblue")
		page.CellR(1,1).AddComponent(searchCase)
		
		Dim casestatussearch As ABMCombo
		casestatussearch.Initialize(page, "casestatussearch", "Status", 650 , "lightblue")	
		
		' add items
'		casestatussearch.AddItem("statsearch", "All", BuildSimpleItem("SST", "mdi-content-reply-all", "{NBSP}{NBSP}All"))
'		casestatussearch.AddItem("statsearch0", "0 - Submitted", BuildSimpleItem("SST0", "mdi-action-shop", "{NBSP}{NBSP}0 - Submitted"))
'		casestatussearch.AddItem("statsearch1", "1 - Closed, no action", BuildSimpleItem("SST1", "mdi-action-delete", "{NBSP}{NBSP}1 - Closed, no action"))
'		casestatussearch.AddItem("statsearch2", "2 - Fixed", BuildSimpleItem("SST2", "mdi-action-done", "{NBSP}{NBSP}2 - Fixed"))
'		casestatussearch.AddItem("statsearch3", "3 - Implemented", BuildSimpleItem("SST3", "mdi-action-done-all", "{NBSP}{NBSP}3 - Implemented"))
'		casestatussearch.AddItem("statsearch4", "4 - More info needed", BuildSimpleItem("SST4", "mdi-action-info", "{NBSP}{NBSP}4 - More info needed"))
'		casestatussearch.AddItem("statsearch5", "5 - Confirmed", BuildSimpleItem("SST5", "mdi-action-stars", "{NBSP}{NBSP}5 - Confirmed"))
'		casestatussearch.AddItem("statsearch6", "6 - On hold", BuildSimpleItem("SST6", "mdi-av-pause-circle-fill", "{NBSP}{NBSP}6 - On hold"))	
'		casestatussearch.AddItem("statsearchmycases", "My cases", BuildSimpleItem("SSTMC", "mdi-action-account-box", "{NBSP}{NBSP}My cases"))
		
		casestatussearch.AddItem("statsearch", "All", BuildSimpleItem("SST", "", "{NBSP}{NBSP}All"))
		casestatussearch.AddItem("statsearch0", "0 - Submitted", BuildSimpleItem("SST0", "", "{NBSP}{NBSP}0 - Submitted"))
		casestatussearch.AddItem("statsearch1", "1 - Closed, no action", BuildSimpleItem("SST1", "", "{NBSP}{NBSP}1 - Closed, no action"))
		casestatussearch.AddItem("statsearch2", "2 - Fixed", BuildSimpleItem("SST2", "", "{NBSP}{NBSP}2 - Fixed"))
		casestatussearch.AddItem("statsearch3", "3 - Implemented", BuildSimpleItem("SST3", "", "{NBSP}{NBSP}3 - Implemented"))
		casestatussearch.AddItem("statsearch4", "4 - More info needed", BuildSimpleItem("SST4", "", "{NBSP}{NBSP}4 - More info needed"))
		casestatussearch.AddItem("statsearch5", "5 - Confirmed", BuildSimpleItem("SST5", "", "{NBSP}{NBSP}5 - Confirmed"))
		casestatussearch.AddItem("statsearch6", "6 - On hold", BuildSimpleItem("SST6", "", "{NBSP}{NBSP}6 - On hold"))
		casestatussearch.AddItem("statsearch7", "7 - Expired, missing feedback", BuildSimpleItem("SST7", "", "{NBSP}{NBSP}7 - Expired, missing feedback"))
		casestatussearch.AddItem("statsearch8", "8 - Closed, ask in forum", BuildSimpleItem("SST8", "", "{NBSP}{NBSP}8 - Closed, ask in forum"))
		casestatussearch.AddItem("statsearch9", "9 - Solved, no action", BuildSimpleItem("SST8", "", "{NBSP}{NBSP}9 - Solved, no action"))
		casestatussearch.AddItem("statsearchmycases", "My cases", BuildSimpleItem("SSTMC", "", "{NBSP}{NBSP}My cases"))
		
		
		
		casestatussearch.SetActiveItemId("statsearch")
		
		page.CellR(0,2).AddComponent(casestatussearch)
		
		Dim btnSearch As ABMButton
		btnSearch.InitializeFloating(page, "btnSearch", "mdi-action-search", "")
		page.CellR(0,3).AddComponent(btnSearch)
		
		Dim pagination As ABMPagination
		pagination.Initialize(page, "pagination", 10, True, True, "")
		pagination.SetTotalNumberOfPages(20)
		
		page.CellR(1,1).AddComponent(pagination)
		
		' create a table
		Dim tblCases As ABMTable
		tblCases.IsResponsive = True
		' IMPORTANT: we set usingQueriesToSort = true because we are going to handle the sorting, not the javascript sorting library
		' When using Pagination, the sorting library does not know all the data
		' SetColumnDataFields() is used when the user clicks on a column head to sort to return in the SortChanged() event and the GetSortColumn() And SetSortColumn() methods.
	'	tblCases.Initialize(page, "tblCases", True, True, True, "tbltheme")
	'	tblCases.SetHeaders(         Array As String ("ID" , "{NBSP}", "Type"    , "Summary"    , "Status"    , "New in"          , "Submit date"     , "Points"     , "My Rank", "MyPoints", "Notes", "Open/Edit", "Delete"))
	'	tblCases.SetHeaderThemes(    Array As String ("bg" , "bg"    , "bg"      , "bg"         , "bg"        , "bg"              , "bg"              , "bgr"        , "bgc"    , "bgr"     , "bgr"  ,"bgc"       , "bgc"   ))
	'	tblCases.SetHeaderHeights(   Array As Int    (0    , 51      , 0         , 0            , 0           , 0                 , 0                 , 0            , 0        , 0         , 0      , 48         , 48      ))
	'	tblCases.SetColumnVisible(   Array As Boolean(False, True    , True      , True         , True        , True              , True              , True         , True     , False     , True   , True       , True    ))
	'	tblCases.SetColumnSortable(  Array As Boolean(False, False   , True      , True         , True        , True              , True              , True         , True     , False     , False  ,False       , False   ))
	'	tblCases.SetColumnDataFields(Array As String (""   , ""      , "CaseType", "CaseSummary", "CaseStatus", "CaseFixedVersion", "CaseCreationDate", "TotalPoints", "MyRank" , ""        , ""     ,""          , ""      ))
	'		
		tblCases.Initialize(page, "tblCases", True, True, True, "tbltheme")
		tblCases.SetHeaders(         Array As String ("ID" , "{NBSP}", "Type"    , "Summary"    , "Status"    , "New/Fixed in"    , "Submit date"     , "Notes", "Open/Edit", "Delete"))
		tblCases.SetHeaderThemes(    Array As String ("bg" , "bg"    , "bg"      , "bg"         , "bg"        , "bg"              , "bg"              , "bgr"  ,"bgc"       , "bgc"   ))
		tblCases.SetHeaderHeights(   Array As Int    (0    , 51      , 0         , 0            , 0           , 0                 , 0                 , 0      , 48         , 48      ))
		tblCases.SetColumnVisible(   Array As Boolean(False, True    , True      , True         , True        , True              , True              , True   , True       , True    ))
		tblCases.SetColumnSortable(  Array As Boolean(False, False   , True      , True         , True        , True              , True              , False  ,False       , False   ))
		tblCases.SetColumnDataFields(Array As String (""   , ""      , "CaseType", "CaseSummary", "CaseStatus", "CaseFixedVersion", "CaseCreationDate", ""     ,""          , ""      ))
			
		tblCases.SetFooter("Total number of cases: 0", 12,"bg")
		
		page.CellR(1,1).AddComponent(tblCases)	
		
		UserType = page.ws.Session.GetAttribute2("UserType", "0")
		UserID = page.ws.Session.GetAttribute2("UserID", "0")
		
		Dim SQL As SQL = DBM.GetSQL
		
		Dim NowWH As String = ABM.GetBrowserWidthHeight(page)
		If NowWH <> "" And NowWH <> ";" Then
			Dim split() As String = Regex.Split(";", NowWH)
			Dim NewH As Int = split(1) - 350
			NewH = NewH / 50		
			NewH = NewH / 5
			NewH = NewH * 5
			If NewH >= 10 Then
				MaxRows = NewH
			End If
		End If
		'Log(MaxRows)
		
		Dim users As List = DBM.SQLSelect(SQL, "SELECT UserName FROM users WHERE userId=" & UserID, Null)
		If users.Size > 0 Then
			Dim user As Map = users.Get(0)
			UserName = user.GetDefault("username", "")
		End If
			
		DBM.CloseSQL(SQL)
		
		'LoadMyPoints
		
		Dim inp As ABMModalSheet = page.ModalSheet("inp")
		Dim casetype As ABMCombo = inp.Content.Component("casetype")
		
		casetype.Clear
		
		If UserType = "1" Then ' administrators can access users and create NEW items for features not requested	
			page.NavigationBar.AddSideBarItem("Users", "Users", "mdi-action-account-child", "../UsersPage")	
			casetype.AddItem("combo1S0", "[BUG]", BuildSimpleItem("S1", "mdi-action-bug-report", "{NBSP}{NBSP}[BUG]"))
			casetype.AddItem("combo1S1", "[WISH]", BuildSimpleItem("S2", "mdi-action-alarm-add", "{NBSP}{NBSP}[WISH]"))
			casetype.AddItem("combo1S2", "[NEW]", BuildSimpleItem("S3", "mdi-av-new-releases", "{NBSP}{NBSP}[NEW]"))
		Else		
			casetype.AddItem("combo1S0", "[BUG]", BuildSimpleItem("S1", "mdi-action-bug-report", "{NBSP}{NBSP}[BUG]"))
			casetype.AddItem("combo1S1", "[WISH]", BuildSimpleItem("S2", "mdi-action-alarm-add", "{NBSP}{NBSP}[WISH]"))		
		End If
		
		casetype.Refresh
		
		page.NavigationBar.Refresh
		
		' this page uses uploads, so needs some settings	
		page.ws.session.SetAttribute("abmcallback", Me)	
		page.ws.session.SetAttribute("abmdownloadfolder", DownloadFolder)
		page.ws.session.SetAttribute("abmmaxsize", DownloadMaxSize)	
				
		page.Refresh ' IMPORTANT
		
		' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
		page.FinishedLoading 'IMPORTANT
		
		' comes from the Page_Ready event
		page.RestoreNavigationBarPosition
		
		' so it represents the correct values, not the ones saved in the .html file IMPORTANT!
		LoadCases(1)
	End If
	Log(ABMPageId)
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

private Sub LoadCases(fromPage As Int)	
	Dim tblCases As ABMTable = page.Component("tblCases")	
	
	If UserType = "1" Then ' if andministrator, show delete button column
		tblCases.SetColumnVisible(Array As Boolean(False, True    , True      , True         , True        , True              , True              , True         , True       , True    ))
	Else
		tblCases.SetColumnVisible(Array As Boolean(False, True    , True      , True         , True        , True              , True              , True         , True       , False   ))
	End If
	
	Dim SQL As SQL = DBM.GetSQL
	
	Dim SQL_str As String
	SQL_str = "SELECT Count(CaseId) as IDS FROM cases " & FilterCount
	Dim numcases As Int = DBM.SQLSelectSingleResult(SQL, SQL_str)	

' 	SQL_str = "SELECT cases.CaseID, cases.CaseUserID, cases.CaseType, cases.CaseSummary, cases.CaseStatus, cases.CaseFixedVersion, cases.CaseCreationDate, Sum(casepoints.CasePPoints) AS TotalPoints, Query2.CasePPoints AS MyPoints, Query3.CountOfCaseNID, Query4.CaseRStatus " _
' & "FROM ((Select casenotes.CaseNCaseID, Count(casenotes.CaseNID) As CountOfCaseNID FROM casenotes GROUP BY casenotes.CaseNCaseID)  As Query3 RIGHT JOIN ((cases LEFT JOIN casepoints ON cases.CaseID = casepoints.CasePCaseID) LEFT JOIN (Select cases.CaseID, casepoints.CasePPoints FROM cases INNER JOIN casepoints ON cases.CaseID = casepoints.CasePCaseID WHERE (((casepoints.CasePUserID)=" & UserID & ")))  As Query2 ON cases.CaseID = Query2.CaseID) ON Query3.CaseNCaseID = cases.CaseID) LEFT JOIN (Select caseread.CaseRCaseID, caseread.CaseRStatus FROM caseread WHERE (((caseread.CaseRUserID)=" & UserID & "))) As Query4 ON cases.CaseID = Query4.CaseRCaseID " _
' & "GROUP BY cases.CaseID, cases.CaseUserID, cases.CaseType, cases.CaseSummary, cases.CaseStatus, cases.CaseFixedVersion, cases.CaseCreationDate, Query2.CasePPoints, Query3.CountOfCaseNID, Query4.CaseRStatus " & Filter & " " & LastSort & " LIMIT " & ((fromPage - 1) * MaxRows) & "," & MaxRows
	SQL_str = $"Select
  abmfeedback.cases.CaseID,
  abmfeedback.cases.CaseType,
  abmfeedback.cases.CaseSummary,
  abmfeedback.cases.CaseStatus,
  abmfeedback.cases.CaseFixedVersion,
  abmfeedback.cases.CaseCreationDate,
  Count(abmfeedback.casenotes.CaseNID) As countofcasenid,
  SubQuery.CaseRStatus
From
  abmfeedback.cases Left Join
  abmfeedback.casenotes
    On abmfeedback.cases.CaseID = abmfeedback.casenotes.CaseNCaseID Left Join
  (Select
    abmfeedback.caseread.CaseRCaseID,
    abmfeedback.caseread.CaseRStatus
  From
    abmfeedback.caseread
  Where
    abmfeedback.caseread.CaseRUserID = ${UserID}) As SubQuery
    On SubQuery.CaseRCaseID = abmfeedback.cases.CaseID
Group By
  abmfeedback.cases.CaseID, abmfeedback.cases.CaseType,
  abmfeedback.cases.CaseSummary, abmfeedback.cases.CaseStatus,
  abmfeedback.cases.CaseFixedVersion, abmfeedback.cases.CaseCreationDate,
  SubQuery.CaseRStatus ${Filter} ${LastSort} LIMIT ${(fromPage-1)*MaxRows},${MaxRows}"$
  
	Dim cases As List = DBM.SQLSelect(SQL, SQL_str, Null)
	If cases.Size = 0 And fromPage > 1 Then
		' we are on a page without any lines (maybe removed by other user?) 
		DBM.CloseSQL(SQL)
		fromPage = fromPage - 1
		LoadCases(fromPage)
		Return
	End If
	tblCases.SetFooter("Total number of cases: " & numcases, 12,"bg")
	tblCases.Clear
	For i = 0 To cases.Size - 1
		Dim tblFields As Map = cases.Get(i)
		Dim rCellValues As List
		Dim rCellThemes As List
		rCellValues.Initialize
		rCellThemes.Initialize
		
		rCellValues.Add(tblFields.Get("caseid"))
		rCellThemes.Add("nocolor")
		
		' special string value: if starts with [ICON], not the text but the icon will be shown
		Select Case tblFields.Get("casetype")
			Case "0"
				rCellValues.Add("[ICON]mdi-action-bug-report")
			Case "1"
				rCellValues.Add("[ICON]mdi-action-alarm-add")	
			Case "2"
				rCellValues.Add("[ICON]mdi-av-new-releases")	
		End Select		
		rCellThemes.Add("nocolor")		
		
		Select Case tblFields.Get("casetype")
			Case "0"
				rCellValues.Add("[BUG]")
			Case "1"
				rCellValues.Add("[WISH]")	
			Case "2"
				rCellValues.Add("[NEW]")	
		End Select		
		rCellThemes.Add("nocolor")		
		
		rCellValues.Add(tblFields.Get("casesummary"))
		rCellThemes.Add("nocolor")	
		
		Select Case tblFields.Get("casestatus")
			Case "0"
				rCellValues.Add("0 - Submitted")
				rCellThemes.Add("nocolor")	
			Case "1"
				rCellValues.Add("1 - Closed, no action")
				rCellThemes.Add("negative")				
			Case "2"
				rCellValues.Add("2 - Fixed")			
				rCellThemes.Add("positive")	
			Case "3"
				rCellValues.Add("3 - Implemented")	
				rCellThemes.Add("positive")			
			Case "4"
				rCellValues.Add("4 - More info needed")
				rCellThemes.Add("caseorange")	
			Case "5"
				rCellValues.Add("5 - Confirmed")
				rCellThemes.Add("caseyellow")	
			Case "6"
				rCellValues.Add("6 - On hold")
				rCellThemes.Add("casegrey")
			Case "7"
				rCellValues.Add("7 - Expired, no info given")
				rCellThemes.Add("negative")	
			Case "8"
				rCellValues.Add("8 - Closed, forum question")
				rCellThemes.Add("negative")		
			Case "9"
				rCellValues.Add("9 - Solved, no action")
				rCellthemes.Add("positive")				
		End Select	
		
		If tblFields.Get("casefixedversion") ="" Then
		 	rCellValues.Add("{NBSP}")
		Else
			rCellValues.Add(tblFields.Get("casefixedversion"))
		End If
		rCellThemes.Add("nocolor")
		
		rCellValues.Add(tblFields.Get("casecreationdate"))
		rCellThemes.Add("nocolor")
		
'		If tblFields.Get("totalpoints") = Null Then
'			rCellValues.Add("0")
'		Else
'			rCellValues.Add(tblFields.Get("totalpoints"))		
'		End If
'		rCellThemes.Add("points")		
'		
'		Dim points As String = GetMyPoints(tblFields.Get("caseid"))
'		If points <> "0" Then			
'			If UserType <> "0" Then ' admins and donators get double point value
'				Select Case points
'					Case "10"
'						rCellValues.Add("[ICON]mdi-image-looks-5")
'					Case "20"
'						rCellValues.Add("[ICON]mdi-image-looks-4")
'					Case "30"	
'						rCellValues.Add("[ICON]mdi-image-looks-3")
'					Case "40"
'						rCellValues.Add("[ICON]mdi-image-looks-two")
'					Case "50"
'						rCellValues.Add("[ICON]mdi-image-looks-one")
'				End Select
'			Else
'				Select Case points
'					Case "5"
'						rCellValues.Add("[ICON]mdi-image-looks-5")
'					Case "10"
'						rCellValues.Add("[ICON]mdi-image-looks-4")
'					Case "15"	
'						rCellValues.Add("[ICON]mdi-image-looks-3")
'					Case "20"
'						rCellValues.Add("[ICON]mdi-image-looks-two")
'					Case "25"
'						rCellValues.Add("[ICON]mdi-image-looks-one")
'				End Select
'			End If			
'			rCellThemes.Add("points")
'			
'			rCellValues.Add(points)
'			rCellThemes.Add("points")
'		Else
'			rCellValues.Add("{NBSP}")
'			rCellThemes.Add("points")
'			
'			rCellValues.Add("0")
'			rCellThemes.Add("points")
'		End If
		
		If tblFields.Get("countofcasenid") <> Null Then
			Dim numNotes As String = tblFields.Get("countofcasenid")					
			rCellValues.Add(numNotes)
			Dim numNotesTheme As String = "unread"
			If tblFields.Get("caserstatus") <> Null Then
				If tblFields.Get("caserstatus") = "1" Then
					numNotesTheme = "points"
				End If
			End If				
			rCellThemes.Add(numNotesTheme)
		Else
			rCellValues.Add("{NBSP}")
			rCellThemes.Add("points")
		End If
		
		Dim btnEdit As ABMButton
		btnEdit.InitializeFloating(page, "btnEdit", "mdi-action-visibility", "")
		rCellValues.Add(btnEdit)
		rCellThemes.Add("openedit")	
		
		If UserType = "1" Then	
			Dim btnDelete As ABMButton
			btnDelete.InitializeFloating(page, "btnDelete", "mdi-action-delete", "")
			rCellValues.Add(btnDelete)
			rCellThemes.Add("openedit")		
		End If
		
		tblCases.AddRow("uid" & i, rCellValues) 
		tblCases.SetRowThemes(rCellThemes) ' make sure you have as many items in rCellThemes as in rCellValues!  Must follow IMMEDIATELY AFTER AddRow!
	Next
	tblCases.Refresh
	
	DBM.CloseSQL(SQL)
	
	Dim pagination As ABMPagination = page.Component("pagination")
	If (numcases Mod MaxRows > 0) Or (numcases = 0) Then
		numcases = numcases/MaxRows + 1
	Else
		numcases = numcases/MaxRows
	End If
	pagination.SetTotalNumberOfPages(numcases)
	pagination.SetActivePage(fromPage)
	pagination.Refresh
End Sub

'Sub GetMyPoints(caseID As Int) As Int
'	Return MyPoints.GetDefault("" & caseID, "0")
'End Sub
'
'Sub LoadMyPoints()
'	Dim SQL As SQL = DBM.GetSQL
'	MyPoints.Initialize
'	MyPoints.Clear
'	MyNotAvailablePoints.Initialize
'	MyNotAvailablePoints.Clear
'	Dim cases As List = DBM.SQLSelect(SQL, "SELECT CasePCaseID, CasePPoints FROM casepoints WHERE CasePUserID=" & UserID & " AND CasePPoints>0 ORDER BY CasePPoints", Null )
'	For i = 0 To cases.Size - 1
'		Dim cas As Map = cases.Get(i)
'		MyPoints.Put(cas.Get("casepcaseid"), cas.Get("caseppoints"))		
'		MyNotAvailablePoints.Put(cas.Get("caseppoints"), False)
'	Next
'	DBM.CloseSQL(SQL)
'End Sub
'
'Sub GetArePointsAvailable(points As String) As Boolean
'	Return MyNotAvailablePoints.GetDefault(points, True)
'End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)	
	page.SaveNavigationBarPosition	
	'If Action = "Cases" Then Return	
	If Action = "LogOff" Then
		ABMShared.LogOff(page, ABMShared.AppName)
		Return
	End If
	ABMShared.NavigateToPage(ws, ABMPageId, Value)
End Sub

Sub Page_SignedOffSocialNetwork(Network As String, Extra As String)
	page.ws.Session.SetAttribute("authType", "")
	page.ws.Session.SetAttribute("authName", "")
	page.ws.Session.SetAttribute("IsAuthorized", "")	
	page.ws.Session.SetAttribute("UserType", "" )				
	page.ws.Session.SetAttribute("UserID", "" ) 		
	ABMShared.NavigateToPage(ws, ABMPageId, "../")
End Sub

Sub pagination_PageChanged(OldPage As Int, NewPage As Int)
	' do your stuff
	LoadCases(NewPage)
End Sub

Sub btnSearch_Clicked(Target As String)
	DoSearch
End Sub

Sub searchCase_EnterPressed(value As String)
	DoSearch
End Sub

Sub DoSearch()
	Dim searchCase As ABMInput = page.Component("searchCase")
	Dim casestatussearch As ABMCombo = page.Component("CaseStatusSearch")
	FilterCount="";
	Filter = searchCase.Text	
	Dim extra As String
	Select Case casestatussearch.GetActiveItemId
		Case "statsearch"
			extra = ""
		Case "statsearch0"
			extra = "CaseStatus=0 "
		Case "statsearch1"
			extra = "CaseStatus=1 "
		Case "statsearch2"
			extra = "CaseStatus=2 "
		Case "statsearch3"
			extra = "CaseStatus=3 "
		Case "statsearch4"
			extra = "CaseStatus=4 "
		Case "statsearch5"
			extra = "CaseStatus=5 "
		Case "statsearch6"
			extra = "CaseStatus=6 "
		Case "statsearch7"
			extra = "CaseStatus=7 "
		Case "statsearch8"
			extra = "CaseStatus=8 "
		Case "statsearch9"
			extra = "CaseStatus=9 "
		Case "statsearchmycases"
			extra = "CaseUserId=" & UserID & " "
	End Select
	If Filter <> "" Then		
		If extra <> "" Then
			FilterCount = " WHERE (" & extra & " AND CaseSummary LIKE '%" & Filter & "%') "
			Filter = " HAVING (" & extra & " AND CaseSummary LIKE '%" & Filter & "%') "		
		Else 
			FilterCount = " WHERE (CaseSummary LIKE '%" & Filter & "%') "
			Filter = " HAVING (CaseSummary LIKE '%" & Filter & "%') "		
		End If
	Else
		If extra <> "" Then
			FilterCount = " WHERE (" & extra & ") "
			Filter = " HAVING (" & extra & ") "		
		End If
	End If
	' reload the table
	LoadCases(1)
End Sub

Sub AddCaseBtn_Clicked(Target As String, SubTarget As String)
	' reset all the values on the form
	ActiveCaseId = 0
	Dim inp As ABMModalSheet = page.ModalSheet("inp")	
	
	Dim lblCaseCreator As ABMLabel =  inp.Content.Component("lblCaseCreator")
	lblCaseCreator.Text = UserName
	
	Dim casetype As ABMCombo = inp.Content.Component("casetype")
	casetype.SetActiveItemId("")
	casetype.Enabled = True
	
	Dim casesummary As ABMInput = inp.Content.Component("casesummary")
	casesummary.Text = ""
	casesummary.Enabled = True
	
	Dim casedescription As ABMInput = inp.Content.Component("casedescription")
	casedescription.Text = ""
	casedescription.Enabled = True
	
	Dim casestatus As ABMCombo = inp.Content.Component("casestatus")
	casestatus.Visibility = ABM.VISIBILITY_HIDE_ALL
	casestatus.SetActiveItemId("stat0")
	Dim caseversion As ABMInput = inp.Content.Component("caseversion")
	caseversion.Visibility = ABM.VISIBILITY_HIDE_ALL
	caseversion.Text = ""
	
	Dim savebtn As ABMButton = inp.Footer.Component("SaveBtn")
	savebtn.Visibility = ABM.VISIBILITY_ALL
		
	Dim attbtn As ABMButton = inp.Footer.Component("AttBtn")
	attbtn.Visibility = ABM.VISIBILITY_ALL
	
	' don't allow notes to be added until the case is created
	Dim notebtn As ABMButton = inp.Footer.Component("NoteBtn")
	notebtn.Visibility = ABM.VISIBILITY_HIDE_ALL
	
	If UserType = "1" Then ' admin, we're allowed to do everythig
		Dim casestatus As ABMCombo = inp.Content.Component("casestatus")
		casestatus.Visibility = ABM.VISIBILITY_ALL
		casestatus.SetActiveItemId("stat0")
		
		Dim caseversion As ABMInput = inp.Content.Component("caseversion")
		caseversion.Visibility = ABM.VISIBILITY_ALL
		caseversion.Text = ""			
	Else ' a user
		Dim casestatus As ABMCombo = inp.Content.Component("casestatus")
		casestatus.Visibility = ABM.VISIBILITY_HIDE_ALL
		casestatus.SetActiveItemId("stat0")
		
		Dim caseversion As ABMInput = inp.Content.Component("caseversion")
		caseversion.Visibility = ABM.VISIBILITY_HIDE_ALL
		caseversion.Text = ""
	End If
	
'	Dim casepoints As ABMCombo
'	casepoints = inp.Content.Component("casepoints")
'	casepoints.Clear
'	' only show availble choice of points
'	If UserType <> 0 Then ' if administrator or donator, points count triple
'		casepoints.AddItem("rank0", "0", BuildSimpleItem("r0", "mdi-action-stars", "{NBSP}{NBSP}No Rank"))
'		If GetArePointsAvailable("10") Then
'			casepoints.AddItem("rank1", "10", BuildSimpleItem("r1", "mdi-image-looks-5", "{NBSP}{NBSP}10 points"))
'		End If
'		If GetArePointsAvailable("20") Then
'			casepoints.AddItem("rank2", "20", BuildSimpleItem("r2", "mdi-image-looks-4", "{NBSP}{NBSP}20 points"))
'		End If
'		If GetArePointsAvailable("30") Then
'			casepoints.AddItem("rank3", "30", BuildSimpleItem("r3", "mdi-image-looks-3", "{NBSP}{NBSP}30 points"))
'		End If
'		If GetArePointsAvailable("40") Then
'			casepoints.AddItem("rank4", "40", BuildSimpleItem("r4", "mdi-image-looks-two", "{NBSP}{NBSP}40 points"))
'		End If
'		If GetArePointsAvailable("50") Then
'			casepoints.AddItem("rank5", "50", BuildSimpleItem("r5", "mdi-image-looks-one", "{NBSP}{NBSP}50 points"))
'		End If
'	Else
'		casepoints.AddItem("rank0", "0", BuildSimpleItem("r0", "mdi-action-stars", "{NBSP}{NBSP}No Rank"))
'		If GetArePointsAvailable("5") Then
'			casepoints.AddItem("rank1", "5", BuildSimpleItem("r1", "mdi-image-looks-5", "{NBSP}{NBSP}5 point"))
'		End If
'		If GetArePointsAvailable("10") Then
'			casepoints.AddItem("rank2", "10", BuildSimpleItem("r2", "mdi-image-looks-4", "{NBSP}{NBSP}10 points"))
'		End If
'		If GetArePointsAvailable("15") Then
'			casepoints.AddItem("rank3", "15", BuildSimpleItem("r3", "mdi-image-looks-3", "{NBSP}{NBSP}15 points"))
'		End If
'		If GetArePointsAvailable("20") Then
'			casepoints.AddItem("rank4", "20", BuildSimpleItem("r4", "mdi-image-looks-two", "{NBSP}{NBSP}20 points"))
'		End If
'		If GetArePointsAvailable("25") Then
'			casepoints.AddItem("rank5", "25", BuildSimpleItem("r5", "mdi-image-looks-one", "{NBSP}{NBSP}25 points"))		
'		End If
'	End If
'	casepoints.SetActiveItemId("rank0")
'	casepoints.Refresh
	
	' removes all attachment chip components in this cell from possible a previous edit/view
	inp.Content.Cell(5,1).RemoveAllComponents
	
	' removes all note components in this cell from possible a previous edit/view
	inp.Content.Cell(6,1).RemoveAllComponents
	
	
		
	'inp.Refresh
	
	Attachments.Initialize
	RemoveAttachments.Initialize
	
	DateTime.DateFormat = "yyyyMMdd"
	DateTime.TimeFormat = "HHmmss"
	
	ActiveCaseNumber = DateTime.Date(DateTime.Now) & DateTime.Time(DateTime.Now) & Rnd(1,50000)
	ws.Session.SetAttribute("abmactivecasenumber", ActiveCaseNumber)	
	page.ShowModalSheet("inp")
	
	
End Sub

Sub tblCases_Clicked(PassedRowsAndColumns As List)
	' fill with the active values
	Dim tblCellInfo As ABMTableCell = PassedRowsAndColumns.Get(0)
	Dim tblCases As ABMTable = page.Component(tblCellInfo.TableName)
	If tblCellInfo.Column = 8 Then ' edit
		Dim inp As ABMModalSheet = page.ModalSheet("inp")
		ActiveCaseId = tblCases.GetString(tblCellInfo.Row, 0)
		
		Dim SQL As SQL = DBM.GetSQL
		
		Dim cases As List = DBM.SQLSelect(SQL, "SELECT cases.*, users.UserName FROM cases INNER JOIN users ON cases.CaseUserID = users.UserID WHERE caseId=" & ActiveCaseId, Null)
		If cases.Size = 0 Then
			DBM.CloseSQL(SQL)
			Return
		End If
		
		Dim cas As Map = cases.Get(0)
		
		ActiveCaseNumber = cas.Get("casenumber")	
		' used for the upload of attachements in ABMUploadHandler		
		ws.Session.SetAttribute("abmactivecasenumber", ActiveCaseNumber)	
		
		Attachments.Initialize
		' list with attachments that should be removed (clicked x on chip)
		RemoveAttachments.Initialize
		' load attachments
		Dim attCounter As Int = 0
		
		ActiveCaseUserID = cas.Get("caseuserid")
		
		Dim CanBeclosed As Boolean = (UserType = "1" Or page.ws.Session.GetAttribute("UserID") = ActiveCaseUserID) ' if the administrator or the creator of the case
		
		Dim SQL_str As String = "SELECT * FROM caseattachments WHERE caseACaseID=" & ActiveCaseId
		Dim attachs As List = DBM.SQLSelect(SQL,SQL_str, Null)
		
		Dim attLocation As String = "../uploads/"
				
		' removes all chip components in this cell
		inp.Content.Cell(5,1).RemoveAllComponents
				
		For i=0 To attachs.Size - 1
			Dim attach As Map = attachs.Get(i)
			Dim fileName As String = attach.Get("caseavalue")
			Attachments.Put(attach.Get("caseaid"), fileName)	
			
			Dim chip As ABMChip
			attCounter = attCounter + 1
			chip.Initialize(page, attCounter, "{AL}" & attLocation & fileName & "{AT}" & ABMShared.mid2(fileName, ActiveCaseNumber.Length+1) & "{/AL}" , CanBeclosed, "chip")
			chip.Tag = attach.Get("caseaid")
			inp.Content.Cell(5,1).AddArrayComponent(chip, "Chip")				
		Next	
		
		Dim lblCaseCreator As ABMLabel =  inp.Content.Component("lblCaseCreator")
		lblCaseCreator.Text = cas.Get("username")				
		
		' set the rest of the input fields		
		Dim casetype As ABMCombo = inp.Content.Component("casetype")	
		casetype.SetActiveItemId("combo1S" & cas.Get("casetype"))
		casetype.Enabled = True
		
		Dim casesummary As ABMInput = inp.Content.Component("casesummary")
		casesummary.Text = cas.Get("casesummary")
		casesummary.Enabled = True
		
		Dim casedescription As ABMInput = inp.Content.Component("casedescription")
		casedescription.Text = cas.Get("casedescription")
		casedescription.Enabled = True
		
'		Dim casepoints As ABMCombo  = inp.Content.Component("casepoints")
'		Dim points As String = GetMyPoints(ActiveCaseId)
'		Dim PointsInt As Int
'		PointsInt = points
'		If UserID <> 0 Then ' admins and donators get double the point value
'			PointsInt = PointsInt / 10
'		Else
'			PointsInt = PointsInt / 5
'		End If
'		
'		casepoints.Clear
'		' only show availble choice of points
'		If UserType <> 0 Then ' if administrator or donator, points count triple
'			casepoints.AddItem("rank0", "0", BuildSimpleItem("r0", "mdi-action-stars", "{NBSP}{NBSP}No Rank"))
'			If GetArePointsAvailable("10") Or PointsInt = 1 Then
'				casepoints.AddItem("rank1", "10", BuildSimpleItem("r1", "mdi-image-looks-5", "{NBSP}{NBSP}10 points"))
'			End If
'			If GetArePointsAvailable("20") Or PointsInt = 2 Then
'				casepoints.AddItem("rank2", "20", BuildSimpleItem("r2", "mdi-image-looks-4", "{NBSP}{NBSP}20 points"))
'			End If
'			If GetArePointsAvailable("30") Or PointsInt = 3 Then
'				casepoints.AddItem("rank3", "30", BuildSimpleItem("r3", "mdi-image-looks-3", "{NBSP}{NBSP}30 points"))
'			End If
'			If GetArePointsAvailable("40") Or PointsInt = 4 Then
'				casepoints.AddItem("rank4", "40", BuildSimpleItem("r4", "mdi-image-looks-two", "{NBSP}{NBSP}40 points"))
'			End If
'			If GetArePointsAvailable("50") Or PointsInt = 5 Then
'				casepoints.AddItem("rank5", "50", BuildSimpleItem("r5", "mdi-image-looks-one", "{NBSP}{NBSP}50 points"))
'			End If
'		Else
'			casepoints.AddItem("rank0", "0", BuildSimpleItem("r0", "mdi-action-stars", "{NBSP}{NBSP}No Rank"))
'			If GetArePointsAvailable("5") Or PointsInt = 1 Then
'				casepoints.AddItem("rank1", "5", BuildSimpleItem("r1", "mdi-image-looks-5", "{NBSP}{NBSP}5 point"))
'			End If
'			If GetArePointsAvailable("10") Or PointsInt = 2 Then
'				casepoints.AddItem("rank2", "10", BuildSimpleItem("r2", "mdi-image-looks-4", "{NBSP}{NBSP}10 points"))
'			End If
'			If GetArePointsAvailable("15") Or PointsInt = 3 Then
'				casepoints.AddItem("rank3", "15", BuildSimpleItem("r3", "mdi-image-looks-3", "{NBSP}{NBSP}15 points"))
'			End If
'			If GetArePointsAvailable("20") Or PointsInt = 4 Then
'				casepoints.AddItem("rank4", "20", BuildSimpleItem("r4", "mdi-image-looks-two", "{NBSP}{NBSP}20 points"))
'			End If
'			If GetArePointsAvailable("25") Or PointsInt = 5 Then
'				casepoints.AddItem("rank5", "25", BuildSimpleItem("r5", "mdi-image-looks-one", "{NBSP}{NBSP}25 points"))		
'			End If
'		End If
'		casepoints.SetActiveItemId("rank" & PointsInt)
'		casepoints.Refresh
		
		Dim savebtn As ABMButton = inp.Footer.Component("SaveBtn")
		savebtn.Visibility = ABM.VISIBILITY_ALL
		
		Dim attbtn As ABMButton = inp.Footer.Component("AttBtn")
		attbtn.Visibility = ABM.VISIBILITY_ALL
		
		Dim notebtn As ABMButton = inp.Footer.Component("NoteBtn")
		notebtn.Visibility = ABM.VISIBILITY_ALL
		
		If UserType = "1" Then ' admin, we're allowed to do everything
			Dim casestatus As ABMCombo = inp.Content.Component("casestatus")
			casestatus.Visibility = ABM.VISIBILITY_ALL
			casestatus.SetActiveItemId("stat" & cas.Get("casestatus"))
			
			Dim caseversion As ABMInput = inp.Content.Component("caseversion")
			caseversion.Visibility = ABM.VISIBILITY_ALL
			caseversion.Text = cas.Get("casefixedversion")
			
		Else ' a user
			Dim casestatus As ABMCombo = inp.Content.Component("casestatus")
			casestatus.Visibility = ABM.VISIBILITY_HIDE_ALL
			casestatus.SetActiveItemId("stat" & cas.Get("casestatus"))
			
			Dim caseversion As ABMInput = inp.Content.Component("caseversion")
			caseversion.Visibility = ABM.VISIBILITY_HIDE_ALL
			caseversion.Text = cas.Get("casefixedversion")
			
			If page.ws.Session.GetAttribute("UserID") <> ActiveCaseUserID Then ' this is not the creator, so disable editing
				casetype.Enabled = False
				casesummary.Enabled = False
				casedescription.Enabled = False
				attbtn.Visibility = ABM.VISIBILITY_HIDE_ALL
				
			End If
		End If
		
		' Show the notes
		SQL_str = "SELECT casenotes.*, users.UserName FROM casenotes INNER JOIN users ON casenotes.CaseNUserID = users.UserID WHERE CaseNCaseID=" & ActiveCaseId & " ORDER BY CaseNCreationDate DESC, CaseNID DESC"
		Dim notes As List = DBM.SQLSelect(SQL, SQL_str, Null)
				
		' removes all note components in this cell
		inp.Content.Cell(6,1).RemoveAllComponents
				
		For i = 0 To notes.Size - 1
			Dim note As Map = notes.Get(i)
			Dim notecont As ABMContainer = BuildNoteContainer(("notes" & note.Get("casenid")), note.get("casendescription"), note.Get("username"), note.Get("casencreationdate"), note.Get("casenuserid"))
			inp.Content.Cell(6,1).AddComponent(notecont)
		Next
		
		' set my read status for this case
		
		tblCases.UseCellTheme(tblCellInfo.Row, 7, "points")
		tblCases.Refresh
		
		Dim CurrentFields, WhereFields As Map
		CurrentFields.Initialize
		WhereFields.Initialize
		CurrentFields.Clear
		WhereFields.Clear
			
		CurrentFields.Put("CaseRCaseID", ActiveCaseId)			
		CurrentFields.Put("CaseRUserID", UserID)	
		CurrentFields.Put("CaseRStatus", 1)
		
		' build the where values
		WhereFields.Put("CaseRCaseID", ActiveCaseId)
		WhereFields.Put("CaseRUserID", UserID)
			
		Dim SQL_Select As String = DBM.BuildSelectQuery("caseread", CurrentFields, WhereFields, Null)
		Dim SQL_Insert As String = DBM.BuildInsertQuery("caseread", CurrentFields)
		Dim SQL_Update As String = DBM.BuildUpdateQuery("caseread", CurrentFields, WhereFields)
		DBM.SQLInsertOrUpdate(SQL, SQL_Select, SQL_Insert, SQL_Update)	
			
		DBM.CloseSQL(SQL)
		
		'inp.Refresh
		page.ShowModalSheet("inp")		
		Return
	End If
	If tblCellInfo.Column = 9 Then ' delete
		TypeDelete = "Case"
		Dim msg As ABMModalSheet = page.ModalSheet("msg")		
		ActiveCaseId = tblCases.GetString(tblCellInfo.Row, 0)
		Dim lbl As ABMLabel = msg.Content.Component("par1")
		lbl.Text = "Are you sure you want to delete '" & tblCases.GetString(tblCellInfo.Row,3) & "'?"
		page.ShowModalSheet("msg")
		Return
	End If
End Sub

Sub Chip_Closed(Target As String)
	Dim inp As ABMModalSheet = page.ModalSheet("inp")
	Dim ch As ABMChip = inp.Content.Component(Target)
	Dim intTag As Int = ch.Tag
	RemoveAttachments.put(intTag, ch.Tag)	
End Sub

Sub tblCases_SortChanged(DataField As String, Order As String)
	Select Case DataField
		Case "CaseType", "CaseSummary", "CaseStatus", "CaseFixedVersion", "CaseCreationDate"', "TotalPoints"
			LastSort = " ORDER BY " & DataField & " " & Order & " ,CaseCreationDate DESC, CaseId "
		'Case "MyRank"			
			'LastSort = " ORDER BY Query2.CasePPoints " & Order & " ,CaseCreationDate DESC, CaseId "
		Case Else
			LastSort = " ORDER BY CaseCreationDate DESC, CaseId "
	End Select
	' reload the table
	Dim pagination As ABMPagination = page.Component("pagination")		
	LoadCases(pagination.GetActivePage())
End Sub

#Region Inputscreen
Sub BuildInputSheet() As ABMModalSheet
	Dim inp As ABMModalSheet
	inp.Initialize(page, "inp", True, False, "")
	inp.IsDismissible = False
	inp.Size = ABM.MODALSHEET_SIZE_LARGE
		
	inp.Content.AddRowsM(1, True,0,0, "").AddCells12(1, "")
	inp.Content.AddRowsM(1, True,0,0, "").AddCellsOS(1, 0,0,0,3,3,3, "").AddCellsOS(1, 0,0,0,9,9,9, "")'.AddCellsOS(1, 0,0,0,2,2,2, "")
	inp.Content.AddRowsM(1, True,0,0, "").AddCells12(1, "")
	inp.Content.AddRowsM(1, True,0,0, "").AddCellsOS(1, 0,0,0,3,3,3, "").AddCellsOS(1, 0,0,0,9,9,9, "")
	inp.Content.AddRowsM(6, True,0,0, "").AddCells12(1, "")
	inp.Content.BuildGrid
	
	' add paragraph	
	inp.Content.CellR(0,1).AddComponent(ABMShared.BuildParagraphBQWithZDepth(page,"par1","Enter the information for this case.") )
	
	Dim lblCaseCreator As ABMLabel
	lblCaseCreator.Initialize(page, "lblCaseCreator", UserName, ABM.SIZE_PARAGRAPH, False, "lightblue")
	inp.Content.CellR(0,1).AddComponent(lblCaseCreator)
	
	Dim casetype As ABMCombo
	casetype.Initialize(page, "casetype", "Case Type", 650 , "lightblue")	
	
	' add items
	casetype.AddItem("combo1S0", "[BUG]", BuildSimpleItem("S1", "mdi-action-bug-report", "{NBSP}{NBSP}[BUG]"))
	casetype.AddItem("combo1S1", "[WISH]", BuildSimpleItem("S2", "mdi-action-alarm-add", "{NBSP}{NBSP}[WISH]"))
	casetype.AddItem("combo1S2", "[NEW]", BuildSimpleItem("S3", "mdi-av-new-releases", "{NBSP}{NBSP}[NEW]"))
			
	inp.Content.CellR(1,1).AddComponent(casetype)	
	
	Dim casesummary As ABMInput
	casesummary.Initialize(page, "casesummary", ABM.INPUT_TEXT, "Summary", False, "lightblue")
	inp.Content.CellR(0,2).AddComponent(casesummary)
	
'	Dim casepoints As ABMCombo
'	casepoints.Initialize(page, "casepoints", "My Rank", 650 , "lightblue")	
'	
'	' add items
'	If UserType <> 0 Then ' if administrator or donator, points count double
'		casepoints.AddItem("rank0", "0", BuildSimpleItem("r0", "mdi-action-stars", "{NBSP}{NBSP}No Rank"))
'		casepoints.AddItem("rank1", "10", BuildSimpleItem("r1", "mdi-image-looks-5", "{NBSP}{NBSP}10 points"))
'		casepoints.AddItem("rank2", "20", BuildSimpleItem("r2", "mdi-image-looks-4", "{NBSP}{NBSP}20 points"))
'		casepoints.AddItem("rank3", "30", BuildSimpleItem("r3", "mdi-image-looks-3", "{NBSP}{NBSP}30 points"))
'		casepoints.AddItem("rank4", "40", BuildSimpleItem("r4", "mdi-image-looks-two", "{NBSP}{NBSP}40 points"))
'		casepoints.AddItem("rank5", "50", BuildSimpleItem("r5", "mdi-image-looks-one", "{NBSP}{NBSP}50 points"))
'	Else
'		casepoints.AddItem("rank0", "0", BuildSimpleItem("r0", "mdi-action-stars", "{NBSP}{NBSP}No Rank"))
'		casepoints.AddItem("rank1", "5", BuildSimpleItem("r1", "mdi-image-looks-5", "{NBSP}{NBSP}5 points"))
'		casepoints.AddItem("rank2", "10", BuildSimpleItem("r2", "mdi-image-looks-4", "{NBSP}{NBSP}10 points"))
'		casepoints.AddItem("rank3", "15", BuildSimpleItem("r3", "mdi-image-looks-3", "{NBSP}{NBSP}15 points"))
'		casepoints.AddItem("rank4", "20", BuildSimpleItem("r4", "mdi-image-looks-two", "{NBSP}{NBSP}20 points"))
'		casepoints.AddItem("rank5", "25", BuildSimpleItem("r5", "mdi-image-looks-one", "{NBSP}{NBSP}25 points"))		
'	End If
'	casepoints.SetActiveItemId("rank0")
'		
'	inp.Content.CellR(0,3).AddComponent(casepoints)		
	
	Dim casedescription As ABMInput
	casedescription.Initialize(page, "casedescription", ABM.INPUT_TEXT, "Description", True, "lightblue")
	inp.Content.CellR(1,1).AddComponent(casedescription)
	
	Dim casestatus As ABMCombo
	casestatus.Initialize(page, "casestatus", "Status", 650 , "lightblue")	
	
	' add items
'	casestatus.AddItem("stat0", "0 - Submitted", BuildSimpleItem("ST0", "mdi-action-shop", "{NBSP}{NBSP}0 - Submitted"))
'	casestatus.AddItem("stat1", "1 - Closed, no action", BuildSimpleItem("ST1", "mdi-action-delete", "{NBSP}{NBSP}1 - Closed, no action"))
'	casestatus.AddItem("stat2", "2 - Fixed", BuildSimpleItem("ST2", "mdi-action-done", "{NBSP}{NBSP}2 - Fixed"))
'	casestatus.AddItem("stat3", "3 - Implemented", BuildSimpleItem("ST3", "mdi-action-done-all", "{NBSP}{NBSP}3 - Implemented"))
'	casestatus.AddItem("stat4", "4 - More info needed", BuildSimpleItem("ST4", "mdi-action-info", "{NBSP}{NBSP}4 - More info needed"))
'	casestatus.AddItem("stat5", "5 - Confirmed", BuildSimpleItem("ST5", "mdi-action-stars", "{NBSP}{NBSP}5 - Confirmed"))
'	casestatus.AddItem("stat6", "6 - On hold", BuildSimpleItem("ST6", "mdi-av-pause-circle-fill", "{NBSP}{NBSP}6 - On hold"))

	casestatus.AddItem("stat0", "0 - Submitted", BuildSimpleItem("ST0", "", "{NBSP}{NBSP}0 - Submitted"))
	casestatus.AddItem("stat1", "1 - Closed, no action", BuildSimpleItem("ST1", "", "{NBSP}{NBSP}1 - Closed, no action"))
	casestatus.AddItem("stat2", "2 - Fixed", BuildSimpleItem("ST2", "", "{NBSP}{NBSP}2 - Fixed"))
	casestatus.AddItem("stat3", "3 - Implemented", BuildSimpleItem("ST3", "", "{NBSP}{NBSP}3 - Implemented"))
	casestatus.AddItem("stat4", "4 - More info needed", BuildSimpleItem("ST4", "", "{NBSP}{NBSP}4 - More info needed"))
	casestatus.AddItem("stat5", "5 - Confirmed", BuildSimpleItem("ST5", "", "{NBSP}{NBSP}5 - Confirmed"))
	casestatus.AddItem("stat6", "6 - On hold", BuildSimpleItem("ST6", "", "{NBSP}{NBSP}6 - On hold"))
	casestatus.AddItem("stat7", "7 - Expired, missing feedback", BuildSimpleItem("ST7", "", "{NBSP}{NBSP}7 - Expired, missing feedback"))
	casestatus.AddItem("stat8", "8 - Closed, ask in forum", BuildSimpleItem("ST8", "", "{NBSP}{NBSP}8 - Closed, ask in forum"))
	casestatus.AddItem("stat9", "9 - Solved, no action", BuildSimpleItem("ST8", "", "{NBSP}{NBSP}9 - Solved, no action"))
		
	inp.Content.CellR(1,1).AddComponent(casestatus)		
	
	Dim caseversion As ABMInput
	caseversion.Initialize(page, "caseversion", ABM.INPUT_TEXT, "Fixed version", False, "lightblue")
	inp.Content.CellR(0,2).AddComponent(caseversion)
	
	' keep two rows for the attachments and notes
	
	inp.Footer.AddRowsM(1,True,0,0, "").AddCells12(1,"")
	inp.Footer.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	' create the buttons for the footer, create in opposite order as aligned right in a footer
	Dim CancelBtn As ABMButton
	CancelBtn.InitializeFlat(page, "CancelBtn", "", "", "CANCEL", "transparent")
	inp.Footer.Cell(1,1).AddComponent(CancelBtn)
	
	Dim SaveBtn As ABMButton
	SaveBtn.InitializeFlat(page, "SaveBtn", "", "", "SAVE", "transparent")
	inp.Footer.Cell(1,1).AddComponent(SaveBtn)	
	
	Dim AttBtn As ABMButton
	AttBtn.InitializeFlat(page, "AttBtn", "", "", "ATTACHMENT", "transparent")
	inp.Footer.Cell(1,1).AddComponent(AttBtn)
	
	Dim NoteBtn As ABMButton
	NoteBtn.InitializeFlat(page, "NoteBtn", "", "", "ADD NOTE", "transparent")
	inp.Footer.Cell(1,1).AddComponent(NoteBtn)
	
	Return inp
End Sub

Sub BuildSimpleItem(id As String, icon As String, Title As String) As ABMLabel
	Dim lbl As ABMLabel
	If icon <> "" Then
		lbl.Initialize(page, id, Title, ABM.SIZE_H6, True, "header")
	Else
		lbl.Initialize(page, id, Title, ABM.SIZE_H6, True, "")
	End If
	lbl.VerticalAlign = True
	lbl.IconName = icon
	Return lbl
End Sub

Sub NoteBtn_Clicked(Target As String)
	ActiveCaseNoteID = 0
	
	Dim inpNote As ABMModalSheet = page.ModalSheet("inpNote")	
	Dim Notedescription As ABMInput = inpNote.Content.Component("notedescription")
	Notedescription.Text = ""
	
	page.ShowModalSheet("inpNote")
End Sub

Sub SaveBtn_Clicked(Target As String)
	If CheckInput = False Then
		Dim msgbox As ABMModalSheet = page.ModalSheet("msgbox")
		Dim lbl As ABMLabel = msgbox.Content.Component("par1")
		lbl.Text = "Please fill in all fields!"
		page.ShowModalSheet("msgbox")
		Return
	End If
	
	Dim inp As ABMModalSheet = page.ModalSheet("inp")
	
	Dim CurrentFields, WhereFields As Map
	CurrentFields.Initialize
	WhereFields.Initialize
	
	Dim casetype As ABMCombo = inp.Content.Component("casetype")	
	Dim casesummary As ABMInput = inp.Content.Component("casesummary")
	Dim casedescription As ABMInput = inp.Content.Component("casedescription")
	Dim casestatus As ABMCombo = inp.Content.Component("casestatus")	
	Dim caseversion As ABMInput = inp.Content.Component("caseversion")
	'Dim casepoints As ABMCombo = inp.Content.Component("casepoints")	
	
	CurrentFields.Put("CaseType", ABMShared.Mid(casetype.GetActiveItemId(), 8, 1))	
	CurrentFields.Put("CaseSummary", DBM.SetQuotes(casesummary.Text))
	CurrentFields.Put("CaseDescription", DBM.SetQuotes(casedescription.Text))
	CurrentFields.Put("CaseStatus", ABMShared.Mid(casestatus.GetActiveItemId(), 5, 1))
	CurrentFields.Put("CaseUserID", page.ws.Session.GetAttribute2("UserID", "0"))
	DateTime.DateFormat = "yyyy-MM-dd"
	CurrentFields.Put("CaseCreationDate", DBM.SetQuotes(DateTime.Date(DateTime.Now)))
	CurrentFields.Put("CaseFixedVersion", DBM.SetQuotes(caseversion.text))
	CurrentFields.Put("CaseNumber", DBM.SetQuotes(ActiveCaseNumber))
	'Dim MyRank As Int = ABMShared.Mid(casepoints.GetActiveItemId(), 5, 1)	
	
'	' admins and donators get double the point value
'	If UserType <> "0" Then
'		MyRank = MyRank * 10
'	Else
'		MyRank = MyRank * 5
'	End If
	
	' build the where values
	WhereFields.Put("CaseId", ActiveCaseId)
	
	
	Dim SQL As SQL = DBM.GetSQL
		
	Dim SQL_Select As String = "SELECT CaseID FROM cases WHERE CaseID=" & ActiveCaseId
	Dim SQL_Insert As String = DBM.BuildInsertQuery("cases", CurrentFields)
	
	CurrentFields.Remove("CaseUserID")	
	CurrentFields.Remove("CaseCreationDate")
	
	Dim SQL_Update As String = DBM.BuildUpdateQuery("cases", CurrentFields, WhereFields)
	ActiveCaseId = DBM.SQLInsertOrUpdate(SQL, SQL_Select, SQL_Insert, SQL_Update)			
	
'	' clear the current one with so many points
'	If MyRank > 0 Then
'		DBM.SQLDelete(SQL,"DELETE FROM casepoints WHERE CasePPoints=" & MyRank & " AND CasePUserID=" & UserID)
'	End If
'	' save myPoints
'	Dim CurrentFields, WhereFields As Map
'	CurrentFields.Initialize
'	WhereFields.Initialize
'	CurrentFields.Clear
'	WhereFields.Clear
'	
'	CurrentFields.Put("CasePCaseID", ActiveCaseId)
'	CurrentFields.Put("CasePUserID", UserID)
'	CurrentFields.Put("CasePPoints", MyRank)
'	
'	WhereFields.Put("CasePCaseID", ActiveCaseId)
'	WhereFields.Put("CasePUserID", UserID)
'	
'	Dim SQL_Select As String = DBM.BuildSelectQuery("casepoints", CurrentFields, WhereFields, Null)
'	Dim SQL_Insert As String = DBM.BuildInsertQuery("casepoints", CurrentFields)
'	Dim SQL_Update As String = DBM.BuildUpdateQuery("casepoints", CurrentFields, WhereFields)
'	DBM.SQLInsertOrUpdate(SQL, SQL_Select, SQL_Insert, SQL_Update)			
	
	' add/update the new ones	
	For i = 0 To Attachments.Size - 1
		Dim fileName As String = Attachments.GetValueAt(i)
		Dim CaseAID As Int = Attachments.GetKeyAt(i)
		If RemoveAttachments.ContainsKey(CaseAID) = False Then
			Dim CurrentFields, WhereFields As Map
			CurrentFields.Initialize
			WhereFields.Initialize
			CurrentFields.Clear
			WhereFields.Clear
			
			CurrentFields.Put("CaseACaseID", ActiveCaseId)
			If fileName.ToUpperCase.EndsWith(".ZIP") Then
				CurrentFields.Put("CaseAType", 0)
			Else ' image
				CurrentFields.Put("CaseAType", 1)
			End If
			CurrentFields.Put("CaseAValue", DBM.SetQuotes(fileName))
		
			' build the where values
			WhereFields.Put("CaseAID", CaseAID)
		
			Dim SQL_Select As String = "SELECT CaseAID FROM caseattachments WHERE CaseAID=" & CaseAID
			Dim SQL_Insert As String = DBM.BuildInsertQuery("caseattachments", CurrentFields)
			Dim SQL_Update As String = DBM.BuildUpdateQuery("caseattachments", CurrentFields, WhereFields)
			DBM.SQLInsertOrUpdate(SQL, SQL_Select, SQL_Insert, SQL_Update)	
		End If
	Next
	' remove the ones the x button on the chip was pressed
	For Each CaseAID As Int In RemoveAttachments.Keys
		DBM.SQLDelete(SQL, "DELETE FROM caseattachments WHERE CaseAID=" & CaseAID)
		Dim fileName As String = Attachments.GetDefault(CaseAID, "")
		If fileName <> "" Then
			File.Delete(File.DirApp, "/www/" & ABMShared.AppName & "/uploads/" & fileName) 
		End If
	Next
	
	DBM.CloseSQL(SQL)
	
	' reload my points
	'LoadMyPoints
	
	' reload the table
	Dim pagination As ABMPagination = page.Component("pagination")		
	LoadCases(pagination.GetActivePage())
	
	page.CloseModalSheet("inp")
End Sub

Sub CheckInput() As Boolean
	Dim inp As ABMModalSheet = page.ModalSheet("inp")
	
	Dim casetype As ABMCombo = inp.Content.Component("casetype")	
	Dim casesummary As ABMInput = inp.Content.Component("casesummary")
	Dim casedescription As ABMInput = inp.Content.Component("casedescription")
	If casetype.GetActiveItemId = "" Or casesummary.Text = "" Or casedescription.Text = "" Then
		Return False
	End If
	Return True
End Sub

Sub CancelBtn_Clicked(Target As String)
	page.CloseModalSheet("inp")	
End Sub

Sub AttBtn_Clicked(Target As String)
	If CheckInput = False Then
		Dim msgbox As ABMModalSheet = page.ModalSheet("msgbox")
		Dim lbl As ABMLabel = msgbox.Content.Component("par1")
		lbl.Text = "Please fill in all fields!"
		page.ShowModalSheet("msgbox")
		Return
	End If
	page.ShowModalSheet("att") 			
End Sub

#End Region

#Region Attachment screen
Sub BuildAttachmentSheet() As ABMModalSheet
	Dim att As ABMModalSheet
	att.Initialize(page, "att", False, False, "")
	att.IsDismissible = False	
		
	att.Content.AddRowsM(2, True,0,0, "").AddCells12(1, "")
	att.Content.BuildGrid
	
	' add paragraph	
	att.Content.CellR(0,1).AddComponent(ABMShared.BuildParagraphBQ(page,"par1","Maximum 500K, images and zip files only.") )
	
	' create the upload
	Dim upload1 As ABMUpload
	upload1.Initialize(page, "upload1", "Drop Here", "Browse", "")
	att.Content.CellR(1,1).AddComponent(upload1)
	
	
	att.Footer.AddRowsM(1,True,0,0, "").AddCells12(1,"")
	att.Footer.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	' create the buttons for the footer, create in opposite order as aligned right in a footer
	Dim AttCloseBtn As ABMButton
	AttCloseBtn.InitializeFlat(page, "AttCloseBtn", "", "", "CLOSE", "transparent")
	att.Footer.Cell(1,1).AddComponent(AttCloseBtn)	
	
	Return att
End Sub

Sub Page_FileUploaded(FileName As String, success As Boolean)	
	myToastId = myToastId + 1	
	
	Dim SQL As SQL = DBM.GetSQL
	
	Dim attachs As List = DBM.SQLSelect(SQL, "SELECT CaseAID FROM caseattachments WHERE CaseAValue='" & ActiveCaseNumber & FileName & "'", Null)
	
	If attachs.Size = 0 Then
		Attachments.put(Attachments.Size-1000, ActiveCaseNumber & FileName)
	Else
		Dim attach As Map = attachs.Get(0)
		Attachments.put(attach.Get("caseaid"), ActiveCaseNumber & FileName)
	End If
	
	If success Then
		page.ShowToast("toast" & myToastId, "toastgreen", "File " & FileName & " uploaded!", 5000)
	Else
		page.ShowToast("toast" & myToastId, "toastred", "File " & FileName & " not uploaded!", 5000)
	End If
	
	DBM.CloseSQL(SQL)
	page.ws.Flush ' IMPORTANT
End Sub

Sub AttCloseBtn_Clicked(Target As String)
	page.CloseModalSheet("att")	
	
	' refresh the sheet met the new attachments
	Dim inp As ABMModalSheet = page.ModalSheet("inp")
	
	' removes all components in this cell
	inp.Content.Cell(5,1).RemoveAllComponents
	
	Dim CanBeclosed As Boolean = (UserType = "1" Or page.ws.Session.GetAttribute("UserID") = ActiveCaseUserID) ' if the administrator or the creator of the case
		
	Dim attLocation As String = "../uploads/"
	
	Dim attcounter As Int = 0
	For i = 0 To Attachments.Size - 1	
		Dim fileName As String	= Attachments.GetValueAt(i)
		Dim CaseAID As Int = Attachments.GetKeyAt(i)
		If RemoveAttachments.ContainsKey(CaseAID) = False  Then
			attcounter = attcounter + 1
			Dim chip As ABMChip
			chip.Initialize(page, attcounter, "{AL}" & attLocation & fileName & "{AT}" & ABMShared.mid2(fileName, ActiveCaseNumber.Length+1) & "{/AL}" , CanBeclosed, "chip")
			chip.Tag = CaseAID
			inp.Content.Cell(5,1).AddArrayComponent(chip, "Chip")	
		End If			
	Next
	
	inp.Refresh
End Sub
#End Region

#Region MessageboxYesNo
Sub BuildMsgBoxYesNo() As ABMModalSheet
	Dim msg As ABMModalSheet
	msg.Initialize(page, "msg", False, False, "")
	msg.IsDismissible = False
	
	msg.Content.AddRowsM(1, True,0,0, "").AddCells12(1, "")
	msg.Content.BuildGrid
	
	' add paragraph	
	msg.Content.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Are you sure you want to delete this case?") )
		
	msg.Footer.AddRowsM(1,True,0,0, "").AddCellsOS(1,6,6,6,3,3,3,"").AddCellsOS(1,0,0,0,3,3,3, "")
	msg.Footer.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' create the buttons for the footer
	Dim msgyes As ABMButton
	msgyes.InitializeFlat(page, "msgyes", "", "", "YES", "transparent")
	msg.Footer.Cell(1,1).AddComponent(msgyes)
	
	Dim msgno As ABMButton
	msgno.InitializeFlat(page, "msgno", "", "", "NO", "transparent")
	msg.Footer.Cell(1,2).AddComponent(msgno)
	
	Return msg
End Sub

Sub msgyes_Clicked(Target As String)
	Dim SQL As SQL = DBM.GetSQL
		
	Select Case TypeDelete
		Case "Note"
			' delete the note
			DBM.SQLDelete(SQL, "DELETE FROM casenotes WHERE CaseNID=" & ActiveCaseNoteID)
			
			' refresh to case input sheet
			Dim inp As ABMModalSheet = page.ModalSheet("inp")
			
			' Show the notes
			Dim SQL_Str As String = "SELECT casenotes.*, users.UserName FROM casenotes INNER JOIN users ON casenotes.CaseNUserID = users.UserID WHERE CaseNCaseID=" & ActiveCaseId & " ORDER BY CaseNCreationDate DESC, CaseNID DESC"
			Dim notes As List = DBM.SQLSelect(SQL, SQL_Str, Null)
				
			' removes all note components in this cell
			inp.Content.Cell(6,1).RemoveAllComponents
				
			For i = 0 To notes.Size - 1
				Dim note As Map = notes.Get(i)
				Dim notecont As ABMContainer = BuildNoteContainer(("notes" & note.Get("casenid")), note.get("casendescription"), note.Get("username"), note.Get("casencreationdate"), note.Get("casenuserid"))
				inp.Content.Cell(6,1).AddComponent(notecont)
			Next		
		
			inp.Refresh
		Case "Case"
			' delete all the notes
			DBM.SQLDelete(SQL, "DELETE FROM casenotes WHERE CaseNCaseID=" & ActiveCaseId)
			
			' delete all the attachements
			DBM.SQLDelete(SQL, "DELETE FROM caseattachments WHERE CaseACaseID=" & ActiveCaseId)
			
			' delete all the points
			' DBM.SQLDelete(SQL, "DELETE FROM casepoints WHERE CasePCaseID=" & ActiveCaseId)
			
			' build the where values
			DBM.SQLDelete(SQL, "DELETE FROM cases WHERE CaseID=" & ActiveCaseId)
	
			' reload the table
			Dim pagination As ABMPagination = page.Component("pagination")		
			LoadCases(pagination.GetActivePage())		
	End Select
	
	DBM.CloseSQL(SQL)
	
	page.CloseModalSheet("msg")
End Sub

Sub msgno_Clicked(Target As String)
	page.CloseModalSheet("msg")	
End Sub
#End Region

#Region Messagebox
Sub BuildMsgBox() As ABMModalSheet
	Dim msgbox As ABMModalSheet
	msgbox.Initialize(page, "msgbox", False, False, "")
	msgbox.IsDismissible = False
	
	msgbox.Content.AddRowsM(1, True,0,0, "").AddCells12(1, "")
	msgbox.Content.BuildGrid
	
	' add paragraph	
	msgbox.Content.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par1","message") )
		
	msgbox.Footer.AddRowsM(1,True,0,0, "").AddCellsOS(1,6,6,6,3,3,3,"").AddCellsOS(1,0,0,0,3,3,3, "")
	msgbox.Footer.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' create the buttons for the footer
	Dim msgok As ABMButton
	msgok.InitializeFlat(page, "msgok", "", "", "CLOSE", "transparent")
	msgbox.Footer.Cell(1,1).AddComponent(msgok)
	
	Return msgbox
End Sub

Sub msgok_Clicked(Target As String)	
	page.CloseModalSheet("msgbox")
End Sub

#End Region

#region Notes
Sub BuildNoteContainer(CaseNoteID As String, Description As String, Creator As String, CreationDate As String, CreatorID As Int) As ABMContainer
	
	Dim caseNote As ABMContainer
	caseNote.Initialize(page, CaseNoteID, "notetheme")
	
	caseNote.AddRowsM(1, True, 10,0,"").AddCellsOS(2,0,0,0,6,6,6, "")
	caseNote.AddRowsM(2, True, 0,0,"").AddCells12(1, "")
	caseNote.AddRows(2, True,"").AddCells12(1, "")
	
	caseNote.BuildGrid
	
	Dim lblCreationDate As ABMLabel
	lblCreationDate.Initialize(page, "lblCreationDate", CreationDate, ABM.SIZE_PARAGRAPH, False, "lightblue")
	caseNote.CellR(0,1).AddComponent(lblCreationDate)
	
	Dim lblCreator As ABMLabel
	lblCreator.Initialize(page, "lblCreator", Creator, ABM.SIZE_PARAGRAPH, False, "lightblue")
	caseNote.CellR(0,2).AddComponent(lblCreator)
	
	Dim casenotedescription As ABMInput
	casenotedescription.Initialize(page, "casenotedescription", ABM.INPUT_TEXT, "Description", True, "lightblue")
	casenotedescription.Enabled = False
	casenotedescription.Text = Description
	caseNote.CellR(1,1).AddComponent(casenotedescription)
	
	If UserID = CreatorID Or UserType = "1" Then ' admin or creator of then note
		Dim btnNoteEdit As ABMButton
		btnNoteEdit.InitializeFloating(page, CaseNoteID, "mdi-editor-mode-edit", "")
		caseNote.Cell(3,1).AddArrayComponent(btnNoteEdit, "btnNoteEdit")
	End If
		
	If UserType = "1" Then	
		Dim btnNoteDelete As ABMButton
		btnNoteDelete.InitializeFloating(page, CaseNoteID, "mdi-action-delete", "")
		caseNote.Cell(3,1).AddArrayComponent(btnNoteDelete, "btnNoteDelete")
	End If
	
	Return caseNote
End Sub

Sub btnNoteEdit_Clicked(Target As String)
	Dim inp As ABMModalSheet = page.ModalSheet("inp")
	
	'as this is an array element we have to find out from which one.
	Target = ABMShared.replaceAll(Target, "btnnoteedit", "") ' watch case!
	ActiveCaseNoteID = ABMShared.Mid2(Target, "notes".Length + 1)
	
	Dim note As ABMContainer = inp.Content.Component("notes" & ActiveCaseNoteID)
	Dim casenotedescription As ABMInput = note.Component("casenotedescription")
	
	Dim inpNote As ABMModalSheet = page.ModalSheet("inpNote")	
	Dim Notedescription As ABMInput = inpNote.Content.Component("notedescription")
	Notedescription.Text = casenotedescription.Text
	
	page.ShowModalSheet("inpNote")
End Sub

Sub btnNoteDelete_Clicked(Target As String)	
	
	TypeDelete = "Note"
	
	Dim inp As ABMModalSheet = page.ModalSheet("inp")	
	
	'as this is an array element we have to find out from which one
	Target = ABMShared.replaceAll(Target, "btnnotedelete", "") ' watch case
	ActiveCaseNoteID = ABMShared.Mid2(Target, "notes".Length + 1)
	
	Dim note As ABMContainer = inp.Content.Component("notes" & ActiveCaseNoteID)
	Dim casenotedescription As ABMInput = note.Component("casenotedescription")
	
	Dim msg As ABMModalSheet = page.ModalSheet("msg")
	
	Dim lbl As ABMLabel = msg.Content.Component("par1")
	lbl.Text = "Are you sure you want to delete '" & casenotedescription.Text & "'?"
	page.ShowModalSheet("msg")
	
	Log(Target)
End Sub

Sub BuildNoteInputSheet() As ABMModalSheet
	Dim inpNote As ABMModalSheet
	inpNote.Initialize(page, "inpNote", False, False, "")
	inpNote.IsDismissible = False
		
	inpNote.Content.AddRowsM(2, True,0,0, "").AddCells12(1, "")
	inpNote.Content.BuildGrid
	
	' add paragraph	
	inpNote.Content.CellR(0,1).AddComponent(ABMShared.BuildParagraphBQWithZDepth(page,"par1","Enter the information for this note.") )
	
	Dim Notedescription As ABMInput
	Notedescription.Initialize(page, "notedescription", ABM.INPUT_TEXT, "Description", True, "lightblue")
	inpNote.Content.CellR(1,1).AddComponent(Notedescription)
	
	inpNote.Footer.AddRowsM(1,True,0,0, "").AddCells12(1,"")
	inpNote.Footer.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	' create the buttons for the footer, create in opposite order as aligned right in a footer
	Dim btnNoteCancel As ABMButton
	btnNoteCancel.InitializeFlat(page, "btnNoteCancel", "", "", "CANCEL", "transparent")
	inpNote.Footer.Cell(1,1).AddComponent(btnNoteCancel)
	
	Dim BtnNoteSave As ABMButton
	BtnNoteSave.InitializeFlat(page, "btnNoteSave", "", "", "SAVE", "transparent")
	inpNote.Footer.Cell(1,1).AddComponent(BtnNoteSave)	
	
	Return inpNote	
End Sub

Sub btnNoteCancel_Clicked(Target As String)
	page.CloseModalSheet("inpNote")	
End Sub

Sub btnNoteSave_Clicked(Target As String)
	Dim inpNote As ABMModalSheet = page.ModalSheet("inpNote")
	
	Dim Notedescription As ABMInput = inpNote.Content.Component("notedescription")	
	
	Dim CurrentFields, WhereFields As Map
	CurrentFields.Initialize
	WhereFields.Initialize
	
	CurrentFields.Put("CaseNCaseID", ActiveCaseId)
	CurrentFields.Put("CaseNUserID", UserID)
	CurrentFields.Put("CaseNDescription", DBM.SetQuotes(Notedescription.Text))	
	DateTime.DateFormat = "yyyy-MM-dd"
	CurrentFields.Put("CaseNCreationDate", DBM.SetQuotes(DateTime.Date(DateTime.Now)))
	
	' build the where values
	WhereFields.Put("CaseNId", ActiveCaseNoteID)

	
	Dim SQL As SQL = DBM.GetSQL
	
	Dim SQL_Select As String = "SELECT CaseNId FROM casenotes WHERE CaseNID=" & ActiveCaseNoteID
	Dim SQL_Insert As String = DBM.BuildInsertQuery("casenotes", CurrentFields)
	Dim SQL_Update As String = DBM.BuildUpdateQuery("casenotes", CurrentFields, WhereFields)
	ActiveCaseNoteID = DBM.SQLInsertOrUpdate(SQL, SQL_Select, SQL_Insert, SQL_Update)
	
	page.CloseModalSheet("inpNote")	
	
	' reset everyones read status for this case
	DBM.SQLDelete(SQL, "DELETE FROM caseread WHERE CaseRCaseID=" & ActiveCaseId)
	
	' refresh to case input sheet
	Dim inp As ABMModalSheet = page.ModalSheet("inp")
	' Show the notes
	Dim vars As List
	vars.initialize
	vars.Add(ActiveCaseId)
	Dim SQL_str As String = "SELECT casenotes.*, users.UserName FROM casenotes INNER JOIN users ON casenotes.CaseNUserID = users.UserID WHERE CaseNCaseID=? ORDER BY CaseNCreationDate DESC, CaseNID DESC"
	Dim notes As List = DBM.SQLSelect(SQL, SQL_str, vars)
				
	' removes all note components in this cell
	inp.Content.Cell(6,1).RemoveAllComponents
				
	For i = 0 To notes.Size - 1
		Dim note As Map = notes.Get(i)
		Dim notecont As ABMContainer = BuildNoteContainer(("notes" & note.Get("casenid")), note.get("casendescription"), note.Get("username"), note.Get("casencreationdate"), note.Get("casenuserid"))
		inp.Content.Cell(6,1).AddComponent(notecont)
	Next
		
	inp.Refresh
	
	DBM.CloseSQL(SQL)
End Sub

#End Region


