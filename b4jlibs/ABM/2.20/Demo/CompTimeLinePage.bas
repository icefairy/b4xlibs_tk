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
	Public Name As String = "CompTimeLinePage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
	Dim counter As Int = 4
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
	theme.AddDividerTheme("lightblue")
	theme.Divider("lightblue").ForeColor = ABM.COLOR_LIGHTBLUE
	
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
	page.PageTitle = "ABMTimeLine"
	page.PageDescription = "The Timeline component "	
	page.PageHTMLName = "abmaterial-timeline.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMTimeLine", "../images/logo.png", "", "Controls", "ABMTimeLine")
		
	' create the page grid
	page.AddRows(4,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	page.Cell(2,1).SetFixedHeight(800) ' IMPORTANT TO DO IN BUILDPAGE FOR EDGE!
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","ABMTimeline is a component to present a time line of events. Using the ABMTimeLineSlide you can create events, with some assets like images, and event other ABMComponents!.") )	
	' add paragraph
	
	'page.Cell(2,1).SetFixedHeight(800) ' IMPORTANT
	
	Dim timeline As ABMTimeLine
	timeline.Initialize(page, "timeline", "H1", "", "alain.json","")
	timeline.Language = "nl"
	timeline.StartAtSlideNumber = 1
	timeline.HideSwipeMessage = True
	
	
	Dim date1 As ABMTimeLineSlide
	date1.Initialize("id1", "2016", "")
	date1.Text.Text = "A table overview"
	date1.Container.Initialize(page, "cont1", "")
	
		' create a table
		Dim tbl1 As ABMTable
		tbl1.Initialize(page, "tbl1", True, False, True, "tbl1theme")
		tbl1.SetHeaders(Array As String("First Name", "Last Name", "Sales Profit"))
		tbl1.SetColumnDataFields(Array As String("FirstName", "LastName", "SalesProfit"))
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
	
	date1.Container.AddRows(1,True, "").AddCells12(1,"")
	date1.Container.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	date1.Container.Cell(1,1).AddComponent(tbl1)
	
	
	timeline.AddSlide(date1)
	
	Dim date2 As ABMTimeLineSlide
	date2.Initialize("id2", "2018", "")
	date2.StartDate.Month = 12
	date2.Text.Text = "A PDF report"
	'date2.BackgroundURL = "http://gorgeousapps.com/abmaterial-abmtimeline.png"
	date2.Container.Initialize(page, "cont2", "")
	date2.Container.AddRows(1,True, "").AddCells12(1,"")
	date2.Container.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
		Dim pdf As ABMPDFViewer
		pdf.Initialize(page, "pdf", 400, "../PDF/1.pdf","")
		pdf.PreparePrintingText = "Preparing to print..."
		pdf.ReadDirection = ABM.PDF_READDIRECTION_LTR
		pdf.AllowDownload = True
		pdf.AllowOpen = False
		pdf.AllowPrint = True
		pdf.AllowSideBar = True
		pdf.AllowViewBookmark = False
	
	date2.Container.Cell(1,1).AddComponent(pdf)
	timeline.AddSlide(date2)
	
	Dim date4 As ABMTimeLineSlide
	date4.Initialize("id3", "2016", "")
	date4.StartDate.Month = 5
	date4.Text.Text = "A panorama view"
	'date2.BackgroundURL = "http://gorgeousapps.com/abmaterial-abmtimeline.png"
	date4.Container.Initialize(page, "cont4", "")
	date4.Container.AddRows(1,True, "").AddCells12(1,"")
	date4.Container.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
		' create the panorama
		Dim gm2 As ABMGoogleMap
		gm2.InitializeAsPanorama(page, "gm2", 50.8500, 2.8833, 1, 300, 45, 0)		
	
	date4.Container.Cell(1,1).AddComponent(gm2)
	timeline.AddSlide(date4)
	
	page.Cell(2,1).AddComponent(timeline)
	
	Dim btn1 As ABMButton
	btn1.InitializeFlat(page, "btn1", "", "", "Add", "")
	page.Cell(3,1).AddComponent(btn1)
	
	Dim btn2 As ABMButton
	btn2.InitializeFlat(page, "btn2", "", "", "Remove last added", "")
	page.Cell(3,1).AddComponent(btn2)
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub btn1_Clicked(Target As String)
	Dim timeline As ABMTimeLine = page.Component("timeline")
	Dim date3 As ABMTimeLineSlide
	date3.Initialize("id" & counter, "2016", "")
	date3.StartDate.Month = Rnd(1,13)
	date3.Text.Text = "An input form"
	date3.Container.Initialize(page, "cont" & counter, "")
	
	' create the grid for the content
	date3.Container.AddRows(1,True, "").AddCells12(1,"")
	date3.Container.AddRows(1,True, "").AddCellsOS(2,0,0,0,6,6,6,"") 
	date3.Container.AddRows(3,True, "").AddCells12(1,"")
	date3.Container.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
		' add paragraph	
		date3.Container.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Enter your info so we can contact you later") )
	
		' create the input fields for the content
		Dim inp1 As ABMInput
		inp1.Initialize(page, "inp1", ABM.INPUT_TEXT, "First Name", False, "")
		inp1.PlaceHolderText = "or your call name"
		date3.Container.Cell(2,1).AddComponent(inp1)
	
		Dim inp2 As ABMInput
		inp2.Initialize(page, "inp2", ABM.INPUT_TEXT, "Last Name", False, "")
		date3.Container.Cell(2,2).AddComponent(inp2)
	
	
		' create combo
		Dim combo1 As ABMCombo
		combo1.Initialize(page, "combo1", "Select a person", 650, "")
		
		' add items
		combo1.AddItem("combo1S1", "Mom", BuildSimpleItem("S1", "mdi-action-account-circle", "{NBSP}{NBSP}Mom"))
		combo1.AddItem("combo1S2", "Dad", BuildSimpleItem("S2", "mdi-action-account-circle", "{NBSP}{NBSP}Dad"))
		combo1.AddItem("combo1S3", "Brother", BuildSimpleItem("S3", "mdi-action-dashboard", "{NBSP}{NBSP}Brother"))
		combo1.AddItem("combo1S4", "Sister", BuildSimpleItem("S4", "mdi-action-dashboard", "{NBSP}{NBSP}Sister"))
	
		date3.Container.Cell(3,1).AddComponent(combo1)
	
		Dim inp4 As ABMInput
		inp4.Initialize(page, "inp4", ABM.INPUT_PASSWORD, "Password", False, "")
		date3.Container.Cell(4,1).AddComponent(inp4)
	
		Dim inp5 As ABMInput
		inp5.Initialize(page, "inp5", ABM.INPUT_EMAIL, "Email", False, "")
		inp5.WrongMessage = "Wrong"
		inp5.SuccessMessage = "Correct"
		date3.Container.Cell(5,1).AddComponent(inp5)
	
	timeline.AddSlideRunTime(date3)
	
	counter = counter + 1
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

Sub btn2_Clicked(Target As String)
	Dim timeline As ABMTimeLine = page.Component("timeline")
	timeline.RemoveSlideRunTime("id" & (counter - 1))
End Sub

Sub timeline_DataLoaded()
	Log("Data loaded")
	Dim timeline As ABMTimeLine = page.Component("timeline")
	timeline.PrepareComponentsForAllSlides ' IMPORTANT
End Sub

Sub timeline_Added(uniqueID As String)
	Log("added " & uniqueID)
	Dim timeline As ABMTimeLine = page.Component("timeline")
	timeline.Goto(uniqueID, True)
	timeline.PrepareComponentsForSlide(uniqueID) ' IMPORTANT
End Sub

Sub timeline_BackToStart()
	Log("back to start")
End Sub

Sub timeline_MovedToSlide(uniqueID As String)
	Log("Changed: " & uniqueID)
End Sub

Sub timeline_Removed(uniqueID As String)
	Log("Removed")
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMTimeLine" Then Return
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
