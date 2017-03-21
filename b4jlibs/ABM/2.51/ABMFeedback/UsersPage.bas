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
	Public Name As String = "UsersPage"
	
	' your own variables
	Dim ActiveUserId As Int
	Dim Filter As String = " WHERE UserActive<>99 "
	Dim LastSort As String
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
	
	theme.Table("tbltheme").AddCellTheme("negative")
	theme.Table("tbltheme").Cell("negative").BackColor = ABM.COLOR_RED
	theme.Table("tbltheme").Cell("negative").BackColorIntensity = ABM.INTENSITY_LIGHTEN3
	theme.Table("tbltheme").Cell("negative").ActiveBackColor = ABM.COLOR_RED
	theme.Table("tbltheme").Cell("negative").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN1
	'theme.Table("tbltheme").Cell("negative").Align = ABM.TABLECELL_HORIZONTALALIGN_RIGHT
	
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
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.PageTitle = "ABMFeedback"
	page.PageDescription = "Feedback App for the ABMaterial Framework for B4J"	
	page.PageHTMLName = "index.html"
	page.PageKeywords = ""
	page.PageSiteMapPriority = ""
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_YEARLY
	page.DisableBackButton = True
	page.ShowConnectedIndicator = True
		
	ABMShared.BuildNavigationBar(page, "Users", "../images/logo.png", "Users", "", "")
		
	' create the page grid
	page.AddRowsM(1,True,0,0, "").AddCells12(1,"")	
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,10,10,11,""). _
							 AddCellsOSMP(1,0,0,0,2,2,1,14,0,0,0,"")	
	page.AddRows(4,True, "").AddCells12(1,"")	
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components	
		
	' add a modal sheet template to enter user information
	page.AddModalSheetTemplate(BuildInputSheet)
	' add a modal sheet template for a yes no msgbox
	page.AddModalSheetTemplate(BuildMsgBoxYesNo)
		
	' create the action button
	Dim AddUserbtn As ABMActionButton
	AddUserbtn.Initialize(page, "AddUserbtn", "mdi-content-add","", "bigblue")
	AddUserbtn.MainButton.Size = ABM.BUTTONSIZE_LARGE
	
	' add to page
	page.AddActionButton(AddUserbtn)
	
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
		Dim searchUser As ABMInput
		searchUser.Initialize(page, "searchUser", ABM.INPUT_TEXT, "Search user", False, "lightblue")
		page.CellR(1,1).AddComponent(searchUser)
	
		Dim btnSearch As ABMButton
		btnSearch.InitializeFloating(page, "btnSearch", "mdi-action-search", "")
		page.CellR(0,2).AddComponent(btnSearch)
	
		Dim pagination As ABMPagination
		pagination.Initialize(page, "pagination", 10, True, True, "")
		pagination.SetTotalNumberOfPages(0)
	
		page.CellR(1,1).AddComponent(pagination)
	
		' create a table
		Dim tblUsers As ABMTable
		tblUsers.IsResponsive = True
		' IMPORTANT: we set usingQueriesToSort = true because we are going to handle the sorting, not the javascript sorting library
		' When using Pagination, the sorting library does not know all the data
		' SetColumnDataFields() is used when the user clicks on a column head to sort to return in the SortChanged() event and the GetSortColumn() And SetSortColumn() methods.
		tblUsers.Initialize(page, "tblUsers", True, True, True, "tbltheme")
		tblUsers.SetHeaders(         Array As String ("ID"  , "Type"   , "Name"    , "Login"    , "Password"    , "Open/Edit", "Delete"))
		tblUsers.SetHeaderThemes(    Array As String ("bg"  ,"bg"      , "bg"      , "bg"       ,"bg"           , "bgc"      , "bgc"   ))
		tblUsers.SetHeaderHeights(   Array As Int    (0     , 0        , 0         , 0          , 0             , 48         , 48      ))	
		tblUsers.SetColumnVisible(   Array As Boolean(False, True      , True      , True       , True          , True       , True    ))
		tblUsers.SetColumnSortable(  Array As Boolean(False, True      , True      , True       , True          , False      , False   ))
		tblUsers.SetColumnDataFields(Array As String (""   , "UserType", "UserName", "UserLogin", "UserPassword", ""         , ""      ))
		
		tblUsers.SetFooter("Total number of users: 0", 12,"bg")
	
		page.CellR(1,1).AddComponent(tblUsers)	
	
		If page.ws.Session.GetAttribute2("UserType", "0") = "1" Then
			page.NavigationBar.AddSideBarItem("Users", "Users", "mdi-action-dashboard", "../UsersPage")
		End If	
	
		page.Refresh ' IMPORTANT
	
		' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
		page.FinishedLoading 'IMPORTANT
		
		' comes from the Page_Ready event
		page.RestoreNavigationBarPosition
	
		' so it represents the correct values, not the ones saved in the .html file IMPORTANT!
		LoadUsers(1)	
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

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	'If Action = "Users" Then Return	
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

private Sub LoadUsers(fromPage As Int)	
	Dim tblUsers As ABMTable = page.Component("tblUsers")	
	
	Dim SQL As SQL = DBM.GetSQL
	
	Dim numusers As Int = DBM.SQLSelectSingleResult(SQL, "SELECT Count(UserId) as IDS FROM users " & Filter)
	Dim users As List = DBM.SQLSelect(SQL, "SELECT * FROM users " & Filter & " " & LastSort & " LIMIT " & ((fromPage - 1) * 10) & ", 10", Null)
	If users.Size = 0 And fromPage > 1 Then
		' we are on a page without any lines (maybe removed by other user?) 
		DBM.CloseSQL(SQL)
		fromPage = fromPage - 1
		LoadUsers(fromPage)		
		Return
	End If
	tblUsers.SetFooter("Total number of users: " & numusers, 12,"bg")
	tblUsers.Clear
	
	For i = 0 To users.Size - 1
		Dim tblFields As Map = users.Get(i)
		Dim rCellValues As List
		Dim rCellThemes As List
		rCellValues.Initialize
		rCellThemes.Initialize
		
		rCellValues.Add(tblFields.Get("userid")) 
		rCellThemes.Add("nocolor")
		
		Select Case tblFields.Get("usertype")
			Case "0"
				rCellValues.Add("Guest")
			Case "1"
				rCellValues.Add("Admin")
			Case "2"
				rCellValues.Add("Donator")
		End Select		
		rCellThemes.Add("nocolor")
		
		rCellValues.Add(tblFields.Get("username"))
		rCellThemes.Add("nocolor")	
		
		rCellValues.Add(tblFields.Get("userlogin"))
		rCellThemes.Add("nocolor")	
		
		rCellValues.Add(tblFields.Get("userpassword"))
		rCellThemes.Add("nocolor")	
		
		Dim btnEdit As ABMButton
		btnEdit.InitializeFloating(page, "btnEdit", "mdi-action-visibility", "")
		rCellValues.Add(btnEdit)
		rCellThemes.Add("openedit")	
		
		Dim btnDelete As ABMButton
		btnDelete.InitializeFloating(page, "btnDelete", "mdi-action-delete", "")
		rCellValues.Add(btnDelete)
		rCellThemes.Add("openedit")		
		
		tblUsers.AddRow("uid" & i, rCellValues)
		tblUsers.SetRowThemes(rCellThemes) ' make sure you have as many items in rCellThemes as in rCellValues!  Must follow IMMEDIATELY AFTER AddRow!		
	Next
	tblUsers.Refresh
	
	DBM.CloseSQL(SQL)
	
	Dim pagination As ABMPagination = page.Component("pagination")
	If (numusers Mod 10 > 0) Or (numusers = 0) Then
		numusers = numusers/10 + 1
	Else
		numusers = numusers/10
	End If
	pagination.SetTotalNumberOfPages(numusers)
	pagination.SetActivePage(fromPage)
	pagination.Refresh
End Sub

Sub pagination_PageChanged(OldPage As Int, NewPage As Int)
	' do your stuff
	LoadUsers(NewPage)	
End Sub

Sub AddUserbtn_Clicked(Target As String, SubTarget As String)	
	' reset all the values on the form
	ActiveUserId = 0
	Dim inp As ABMModalSheet = page.ModalSheet("inp")	
	Dim combo1 As ABMCombo = inp.Content.Component("combo1")
	combo1.SetActiveItemId("")
	Dim inpName As ABMInput = inp.Content.Component("inpName")
	inpName.Text = ""
	Dim inpLogin As ABMInput = inp.Content.Component("inpLogin")
	inpLogin.Text = ""
	Dim inpPwd As ABMInput = inp.Content.Component("inpPwd")
	inpPwd.Text = ""
	'inp.Refresh
	page.ShowModalSheet("inp")
End Sub

Sub tblUsers_Clicked(PassedRowsAndColumns As List)
	' fill with the active values
	Dim tblCellInfo As ABMTableCell = PassedRowsAndColumns.Get(0)
	Dim tblUsers As ABMTable = page.Component(tblCellInfo.TableName)
	If tblCellInfo.Column = 5 Then ' edit
		Dim SQL As SQL = DBM.GetSQL
		
		Dim inp As ABMModalSheet = page.ModalSheet("inp")
		ActiveUserId = tblUsers.GetString(tblCellInfo.Row, 0)
		Dim users As List = DBM.SQLSelect(SQL, "SELECT * FROM users WHERE userId=" & ActiveUserId, Null)
		If users.Size > 0 Then
			Dim user As Map = users.Get(0)
			Dim combo1 As ABMCombo = inp.Content.Component("combo1")
			combo1.SetActiveItemId("combo1S" & user.Get("usertype"))
			
			Dim inpName As ABMInput = inp.Content.Component("inpName")
			inpName.Text =  user.Get("username")
		
			Dim inpLogin As ABMInput = inp.Content.Component("inpLogin")
			inpLogin.Text =  user.Get("userlogin")
		
			Dim inpPwd As ABMInput = inp.Content.Component("inpPwd")
			inpPwd.Text =  user.Get("userpassword")
		End If
		
		DBM.CloseSQL(SQL)
		
		'inp.Refresh
		page.ShowModalSheet("inp")
		
		Return
	End If
	If tblCellInfo.Column = 6 Then ' delete
		Dim msg As ABMModalSheet = page.ModalSheet("msg")		
		ActiveUserId = tblUsers.GetString(tblCellInfo.Row, 0)
		Dim lbl As ABMLabel = msg.Content.Component("par1")
		lbl.Text = "Are you sure you want to delete '" & tblUsers.GetString(tblCellInfo.Row,2) & "'?"
		page.ShowModalSheet("msg")
		Return
	End If
End Sub

Sub tblUsers_SortChanged(DataField As String, Order As String)
	Select Case DataField
		Case "UserType", "UserName", "UserLogin", "UserPassword"
			LastSort = " ORDER BY " & DataField & " " & Order & " "
		Case Else
			LastSort = ""
	End Select
	' reload the table
	Dim pagination As ABMPagination = page.Component("pagination")		
	LoadUsers(pagination.GetActivePage())
End Sub

Sub BuildInputSheet() As ABMModalSheet
	Dim inp As ABMModalSheet
	inp.Initialize(page, "inp", False, False, "")
	inp.IsDismissible = False
	
	inp.Content.AddRowsM(5, True,0,0, "").AddCells12(1, "")
	inp.Content.BuildGrid
	
	' add paragraph	
	inp.Content.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Enter the information for this user.") )
	
	Dim combo1 As ABMCombo
	combo1.Initialize(page, "combo1", "User Type", 650 , "lightblue")	
	
	' add items
	combo1.AddItem("combo1S1", "Admin", BuildSimpleItem("S1", "mdi-action-account-circle", "{NBSP}{NBSP}Admin"))
	combo1.AddItem("combo1S2", "Donator", BuildSimpleItem("S2", "mdi-action-account-circle", "{NBSP}{NBSP}Donator"))
	combo1.AddItem("combo1S0", "Guest", BuildSimpleItem("S3", "mdi-action-dashboard", "{NBSP}{NBSP}Guest"))	
	
	inp.Content.CellR(1,1).AddComponent(combo1)
	
	Dim inpName As ABMInput
	inpName.Initialize(page, "inpName", ABM.INPUT_TEXT, "Name", False, "lightblue")
	inp.Content.CellR(1,1).AddComponent(inpName)
	
	Dim inpLogin As ABMInput
	inpLogin.Initialize(page, "inpLogin", ABM.INPUT_TEXT, "Login", False, "lightblue")
	inp.Content.CellR(1,1).AddComponent(inpLogin)
	
	Dim inpPwd As ABMInput
	inpPwd.Initialize(page, "inpPwd", ABM.INPUT_TEXT, "Password", False, "lightblue")
	inp.Content.CellR(1,1).AddComponent(inpPwd)
	
	inp.Footer.AddRowsM(1,True,0,0, "").AddCells12(1,"")
	inp.Footer.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	' create the buttons for the footer, create in opposite order as aligned right in a footer
	Dim CancelBtn As ABMButton
	CancelBtn.InitializeFlat(page, "CancelBtn", "", "", "CANCEL", "transparent")
	inp.Footer.Cell(1,1).AddComponent(CancelBtn)
	
	Dim SaveBtn As ABMButton
	SaveBtn.InitializeFlat(page, "SaveBtn", "", "", "SAVE", "transparent")
	inp.Footer.Cell(1,1).AddComponent(SaveBtn)	
		
	Return inp
End Sub

Sub BuildMsgBoxYesNo() As ABMModalSheet
	Dim msg As ABMModalSheet
	msg.Initialize(page, "msg", False, False, "")
	msg.IsDismissible = False
	
	msg.Content.AddRowsM(1, True,0,0, "").AddCells12(1, "")
	msg.Content.BuildGrid
	
	' add paragraph	
	msg.Content.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Are you sure you want to delete this user?") )
		
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

Sub SaveBtn_Clicked(Target As String)
	Dim inp As ABMModalSheet = page.ModalSheet("inp")
	
	Dim CurrentFields, WhereFields As Map
	CurrentFields.Initialize
	WhereFields.Initialize
	
	' get the current values
	Dim combo1 As ABMCombo = inp.Content.Component("combo1")
	CurrentFields.Put("UserType", ABMShared.Mid(combo1.GetActiveItemId(), 8, 1))
	
	Dim inpName As ABMInput = inp.Content.Component("inpName")
	CurrentFields.Put("UserName", DBM.SetQuotes(inpName.Text))
	
	Dim inpLogin As ABMInput = inp.Content.Component("inpLogin")
	CurrentFields.Put("UserLogin", DBM.SetQuotes(inpLogin.Text))
	
	Dim inpPwd As ABMInput = inp.Content.Component("inpPwd")
	CurrentFields.Put("UserPassword", DBM.SetQuotes(inpPwd.Text))
	
	CurrentFields.Put("UserActive", 0)
	
	' build the where values
	WhereFields.Put("UserId", ActiveUserId)
	
	Dim SQL As SQL = DBM.GetSQL
	
	Dim SQL_Select As String = "SELECT UserID FROM users WHERE UserID=" & ActiveUserId
	Dim SQL_Insert As String = DBM.BuildInsertQuery("users", CurrentFields)
	Dim SQL_Update As String = DBM.BuildUpdateQuery("users", CurrentFields, WhereFields)
	DBM.SQLInsertOrUpdate(SQL, SQL_Select, SQL_Insert, SQL_Update)
	
	DBM.CloseSQL(SQL)
	
	' reload the table
	Dim pagination As ABMPagination = page.Component("pagination")		
	LoadUsers(pagination.GetActivePage())
	
	page.CloseModalSheet("inp")
End Sub

Sub CancelBtn_Clicked(Target As String)
	page.CloseModalSheet("inp")	
End Sub

Sub msgyes_Clicked(Target As String)	
	Dim Currentfields, Wherefields As Map	
	Currentfields.Initialize
	Wherefields.Initialize
	
	Currentfields.Put("UserActive", 99)
		
	' build the where values
	Wherefields.Put("UserId", ActiveUserId)
	
	Dim SQL As SQL = DBM.GetSQL
	
	' we're not actual deleting it, as we would also loose his cases, so we update his active param
	Dim SQL_Update As String = DBM.BuildUpdateQuery("users", Currentfields, Wherefields)
	DBM.SQLUpdate(SQL, SQL_Update)
	
	' this would actualy delete him, but then we will have to remove all his cases, attachments, etc also
	'DBUtils.DeleteRecord(DBM.SQLite, "users", Wherefields)			
	
	DBM.CloseSQL(SQL)
	
	' reload the table
	Dim pagination As ABMPagination = page.Component("pagination")		
	LoadUsers(pagination.GetActivePage())
	
	page.CloseModalSheet("msg")
End Sub

Sub msgno_Clicked(Target As String)
	page.CloseModalSheet("msg")	
End Sub

Sub btnSearch_Clicked(Target As String)
	DoSearch
End Sub

Sub searchUser_EnterPressed(value As String)
	DoSearch
End Sub

Sub DoSearch()
	Dim searchUser As ABMInput = page.Component("searchUser")
	Filter = searchUser.Text
	If Filter <> "" Then
		Filter = " WHERE UserActive<>99 AND (userLogin LIKE '%" & Filter & "%' OR userName LIKE '%" & Filter & "%') "
	Else
		Filter = " WHERE UserActive<>99 "
	End If
	' reload the table
	LoadUsers(1)
End Sub