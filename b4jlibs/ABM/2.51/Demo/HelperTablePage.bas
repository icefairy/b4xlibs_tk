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
	Public Name As String = "HelperTablePage"
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
	Dim FirstNames As List
	Dim LastNames As List
	Dim tbl1Counter As Int = 1
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
	
	theme.Table("tbl1theme").AddCellTheme("nocoloredit")
	theme.Table("tbl1theme").Cell("nocoloredit").ActiveBackColor = ABM.COLOR_BLUEGREY
	theme.Table("tbl1theme").Cell("nocoloredit").ActiveBackColorIntensity = ABM.INTENSITY_LIGHTEN2
	theme.Table("tbl1theme").Cell("nocoloredit").IsEditable = True
	theme.Table("tbl1theme").Cell("nocoloredit").InputMask = "'alias':'decimal', 'digits': 2"
	theme.Table("tbl1theme").Cell("nocoloredit").AllowEnterKey = False
	
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
	
	theme.AddCardTheme("whitetitle")
	theme.Card("whitetitle").TitleForeColor = ABM.COLOR_WHITE
	
	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMTable"
	page.PageDescription = "The table helper"	
	page.PageHTMLName = "abmaterial-table.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMTable", "../images/logo.png", "", "Helpers", "ABMTable")
		
	' create the page grid
	page.AddRows(7,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	FirstNames.Initialize2(Array As String("Alain", "Jos", "Paul", "Bertrande", "Julie", "Stephanie", "Bert", "Charles", "James", "Walter"))
	LastNames.Initialize2(Array As String("Bailleul", "Rogiers", "Dougherty", "Rodrigues", "Ostrander", "Kenyon", "Grant", "Klinger", "Sheffield", "Poindexter"))
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1", "With tables you can create data grids. Tables have build-in goodies like being sortable. Click on the headers for a demo.") )
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraphBQ(page,"par1b", "The Id of a table {B}MAY NOT CONTAIN A _ CHARACTER!{/B}.  This is because of the inner working of nested table and the _ character is reserved.") )
	
	' create a table
	Dim tbl1 As ABMTable
	tbl1.Initialize(page, "tbl1", True, False, True, "tbl1theme")
	tbl1.SetHeaders(Array As String("First Name", "Last Name", "Sales Profit"))
	tbl1.SetColumnDataFields(Array As String("FirstName", "LastName", "SalesProfit"))
	tbl1.SetHeaderThemes(Array As String("headerfooter", "headerfooter", "headerfooterright"))
	
	' add some random values
	For i = 0 To 9
		Dim r As List
		Dim rCellThemes As List
		r.Initialize
		rCellThemes.Initialize
		r.Add(FirstNames.get(Rnd(0,9)))
		rCellThemes.Add("nocolor") ' nocoloredit
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
	
	page.Cell(2,1).AddComponent(tbl1)
	
	Dim pagination As ABMPagination
	pagination.Initialize(page, "pagination", 10, True, True, "")
	pagination.SetTotalNumberOfPages(20)
	
	page.Cell(3,1).AddComponent(pagination)	
	
	' add paragraph	
	page.Cell(4,1).AddComponent(ABMShared.BuildParagraph(page,"par2", "Tables can be scrollable.  You'll need to set the height of the parent cell and specify the column widths.") )
	
	' create a table scrollable
	Dim tbl2 As ABMTable
	tbl2.InitializeScrollable(page, "tbl2", True, False, False, Array As Int(300,300,150), "tbl1theme")	
	tbl2.SetHeaders(Array As String("First Name", "Last Name", "Sales Profit"))
	tbl2.SetHeaderThemes(Array As String("headerfooter", "headerfooter", "headerfooterright"))
	
	tbl2.SetFooter("This is a footer that appears on the bottom of the table.", 12,"headerfooter")
	
	' scrollable, so we need to set a fixed height IMPORTANT!
	page.Cell(5,1).SetFixedHeight(360,True)
	page.Cell(5,1).AddComponent(tbl2)
	
	' add paragraph	
	page.Cell(6,1).AddComponent(ABMShared.BuildParagraph(page,"par3", "Tables can contain all kind of ABM components.  In the example below we have Cards and even another table (the profits) as a column. Also, it is made interactive so we receive a clicked() event when we click into a cell. Check the source code of this page on how it is done.") )
		
	' add paragraph	
	page.Cell(6,1).AddComponent(ABMShared.BuildParagraphBQ(page,"par4", "Because the profits are random created, the value it reutrns will not match the one you clicked.  This is because when the page was build other values were saved in the html than the ones shown.  In a real world app you would get the values from a database for example so they would match.") )
	
	' create a table scrollable
	Dim tbl3 As ABMTable
	tbl3.InitializeScrollable(page, "tbl3", False, False, True, Array As Int(300, 200,200,150), "tbl1theme")
	tbl3.SetHeaders(Array As String("Card", "First Name", "Last Name", "Sales Profit"))
	tbl3.SetHeaderThemes(Array As String("headerfooter", "headerfooter", "headerfooter", "headerfooterright"))
	
	Dim fName, lName As String
	
	' add some random values
	For i = 0 To 9
		Dim r As List
		Dim rCellThemes As List
		r.Initialize
		rCellThemes.Initialize
		fName = FirstNames.get(Rnd(0,9))
		lName = LastNames.get(Rnd(0,9))
		r.Add(BuildCard("card","../images/list" & (i+1) & ".jpg", fName & " " & lName)) ' <--- note we do not give every card a unique id.  
		rCellThemes.Add("aligntop")
		r.Add(fName)
		rCellThemes.Add("aligntop")
		r.Add(lName)
		rCellThemes.Add("aligntop")		
		r.Add(BuildOtherTable("innertable")) ' <--- note we do not give every innertable a unique id.  
		rCellThemes.Add("aligntop")
		tbl3.AddRow("uid" & i, r)
		tbl3.SetRowThemes(rCellThemes) ' make sure you have as many items in rCellThemes as in r!
	Next
	
	tbl3.SetFooter("This is a footer that appears on the bottom of the table.", 12,"headerfooter")
	
	' scrollable, so we need to set a fixed height IMPORTANT!
	page.Cell(7,1).SetFixedHeight(500,True)
	page.Cell(7,1).AddComponent(tbl3)
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT	
	
	page.RestoreNavigationBarPosition
End Sub

'Sub tbl1_Changed(Params As Map)
'	Dim row As String = Params.Get("row")
'    Dim Value As String = Params.Get("value")
'    
'    Dim tbl As ABMTable = page.Component("tbl1")
'   
'    Dim cCantidad As String = "$" & (Value * 100)
'    tbl.SetString(row, 2, cCantidad)        
'    tbl.RefreshCell(row, 2)
'End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMTable" Then Return
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

Sub BuildOtherTable(id As String) As ABMTable
	' create a table
	Dim tblinner As ABMTable
	tblinner.Initialize(page, id, True, False, True, "tbl1theme")
	
	Dim rand As Int = Rnd(1,20)
	For i = 0 To rand
		Dim r As List
		Dim rCellThemes As List
		r.Initialize
		rCellThemes.Initialize
		Dim Neg As Int = Rnd(0,100)
		If Neg > 50 Then
			r.Add("$" & Rnd(1000, 15000))
			rCellThemes.Add("positive")
		Else
			r.Add("$-" & Rnd(1000, 15000))
			rCellThemes.Add("negative")
		End If
		tblinner.AddRow(id & "uid" & i, r)
		tblinner.SetRowThemes(rCellThemes) ' make sure you have as many items in rCellThemes as in r!
	Next
	Return tblinner
End Sub

Sub BuildCard(id As String, image As String, title As String) As ABMCard
	' image card
	Dim card4 As ABMCard
	card4.InitializeAsCard(page, "card", title, "This is my card content...", ABM.CARD_NOTSPECIFIED,"whitetitle")
	card4.Image = image
	Return card4
End Sub

' rows and columns are zero-base, meaning they start with row 0, cell 0
Sub tbl3_Clicked(PassedRowsAndColumns As List)
	' is the root table
	Dim tblCellInfo As ABMTableCell = PassedRowsAndColumns.Get(0)
	Dim tbl As ABMTable = page.Cell(7,1).Component(tblCellInfo.TableName)
	If tblCellInfo.Column = 0 Then		
		Dim card As ABMCard = tbl.GetComponent(tblCellInfo.Row,"card")
		If card <> Null Then
			Log("We've got the card in row " & tblCellInfo.Row & " column " & tblCellInfo.Column & "!")
		End If		
	End If
	tbl.Refresh
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastred", "Clicked " & tblCellInfo.TableName & " row " & tblCellInfo.Row & " column " & tblCellInfo.Column, 5000)
End Sub

' rows and columns are zero-base, meaning they start with row 0, cell 0
Sub innertable_Clicked(PassedRowsAndColumns As List)
	' this is more complicated
	' first we get the parent of our innertable
	Dim tblCellInfo As ABMTableCell = PassedRowsAndColumns.Get(0)
	Dim tbl As ABMTable = page.Cell(6,1).Component(tblCellInfo.TableName)
	' next we get our innertable
	Dim innerTblCellInfo As ABMTableCell = PassedRowsAndColumns.Get(1)
	Dim innerTbl As ABMTable = tbl.GetComponent(tblCellInfo.Row,innerTblCellInfo.TableName)
	' note the value will not be the right one because I used randomize in the BuildOtherTable() method.  So when be saved the page we got other values than when we connected through the websocket.
	' this is just to show the principle of getting a string value
	Dim profit As String = innerTbl.GetString(innerTblCellInfo.Row, innerTblCellInfo.Column)	
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastred", "Clicked row " & innerTblCellInfo.Row & " column " & innerTblCellInfo.Column & " value=" & profit , 5000)
	Return
End Sub

Sub tbl1_Clicked(PassedRowsAndColumns As List)
	' is the root table
	Dim tblCellInfo As ABMTableCell = PassedRowsAndColumns.Get(0)
	Dim tbl As ABMTable = page.Cell(2,1).Component(tblCellInfo.TableName)
	Dim str As String = tbl.GetString(tblCellInfo.row, 2)
	Dim value As Int = ABMShared.Mid(str,2,str.Length-1)
	
	'Log(tbl.GetActiveRow)
	
	value = value + 10
	tbl.SetString(tblCellInfo.row, 2,"$" & value)
	tbl.RefreshCell(tblCellInfo.Row, 2)
	
	Dim tbl2 As ABMTable = page.Cell(5,1).Component("tbl2")
	Dim r As List
		Dim rCellThemes As List
		r.Initialize
		rCellThemes.Initialize
		r.Add(FirstNames.get(Rnd(0,9)))
		rCellThemes.Add("")
		r.Add(LastNames.get(Rnd(0,9)))
		rCellThemes.Add("")		
		Dim Neg As Int = Rnd(0,100)
		If Neg > 50 Then
			r.Add("$" & Rnd(1000, 15000))
			rCellThemes.Add("positive")
		Else
			r.Add("$-" & Rnd(1000, 15000))
			rCellThemes.Add("negative")
		End If
		tbl1Counter = tbl1Counter + 1
		tbl2.AddRow("uid" & tbl1Counter, r)
		tbl2.SetRowThemes(rCellThemes) ' make sure you have as many items in rCellThemes as in r!
	
	'tbl.SetActiveRow("")
	'Log(tbl.GetActiveRow)
	Dim tbl3 As ABMTable = page.Cell(7,1).Component("tbl3")
	tbl3.ScrollTo("uid9", False)
	'tbl.Refresh
	tbl2.refresh
End Sub

Sub pagination_PageChanged(OldPage As Int, NewPage As Int)
	' do your stuff
	Dim pagination As ABMPagination = page.Component("pagination")
	pagination.SetActivePage(NewPage) ' IMPORTANT!
	pagination.Refresh ' IMPORTANT!
	Dim tbl As ABMTable = page.Cell(2,1).Component("tbl1")
	tbl.SetActiveRow("")
	tbl.Refresh
End Sub

