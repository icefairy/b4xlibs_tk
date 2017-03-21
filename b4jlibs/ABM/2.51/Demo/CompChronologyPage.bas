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
	Public Name As String = "CompChronologyPage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
	
	'Dim testo1 As ABMCanvasObject
	'Dim imgfrec As ABMCanvasObject
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
	
	
	theme.AddCardTheme("whitetitle")
	theme.Card("whitetitle").TitleForeColor = ABM.COLOR_WHITE
	
	theme.AddChronologyList("chrono")
	theme.ChronologyList("chrono").AddChronologyBadgeTheme("blue")
	theme.ChronologyList("chrono").ChronologyBadge("blue").BackColor = ABM.COLOR_LIGHTBLUE
	theme.ChronologyList("chrono").ChronologyBadge("blue").ColorizePointer = True
	theme.ChronologyList("chrono").ChronologyBadge("blue").IconName = "mdi-maps-directions-car"
	
	theme.ChronologyList("chrono").AddChronologyBadgeTheme("red")
	theme.ChronologyList("chrono").ChronologyBadge("red").BackColor = ABM.COLOR_RED
	theme.ChronologyList("chrono").ChronologyBadge("red").ColorizePointer = True
	theme.ChronologyList("chrono").ChronologyBadge("red").IconName = "mdi-action-report-problem"
	
	theme.ChronologyList("chrono").AddChronologyBadgeTheme("green")
	theme.ChronologyList("chrono").ChronologyBadge("green").BackColor = ABM.COLOR_GREEN
	theme.ChronologyList("chrono").ChronologyBadge("green").ColorizePointer = True
	theme.ChronologyList("chrono").ChronologyBadge("green").IconName = "mdi-action-assignment-turned-in"
	
	theme.ChronologyList("chrono").AddChronologyBadgeTheme("black")
	theme.ChronologyList("chrono").ChronologyBadge("black").BackColor = ABM.COLOR_BLACK
	theme.ChronologyList("chrono").ChronologyBadge("black").ColorizePointer = True
	theme.ChronologyList("chrono").ChronologyBadge("black").IconName = "mdi-action-dashboard"
	
	theme.AddRowTheme("blue")
	theme.Row("blue").BackColor = ABM.COLOR_LIGHTBLUE
	theme.AddRowTheme("green")
	theme.Row("green").BackColor = ABM.COLOR_GREEN
	theme.AddRowTheme("red")
	theme.Row("red").BackColor = ABM.COLOR_RED
	theme.AddRowTheme("black")
	theme.Row("black").BackColor = ABM.COLOR_BLACK
	
	' add additional themes specific for this page
	theme.AddTableTheme("tbl1theme")
	theme.Table("tbl1theme").ZDepth = ABM.ZDEPTH_1
	
	theme.Table("tbl1theme").AddCellTheme("headerfooter")
	theme.Table("tbl1theme").Cell("headerfooter").BackColor = ABM.COLOR_BLACK
	theme.Table("tbl1theme").Cell("headerfooter").ForeColor = ABM.COLOR_WHITE	
	
	theme.Table("tbl1theme").AddCellTheme("headerfooterright")
	theme.Table("tbl1theme").Cell("headerfooterright").BackColor = ABM.COLOR_BLACK
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
		
	theme.AddLabelTheme("white")
	theme.Label("white").ForeColor = ABM.COLOR_WHITE
	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True	
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMaterial"
	page.PageDescription = "About material design with ABMaterial "	
	page.PageHTMLName = "abmaterial-chronology.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY	
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
				
	ABMShared.BuildNavigationBar(page, "ABMChronologyList", "../images/logo.png", "", "Controls", "ABMChronologyList")	
	
	' create the page grid
	page.AddRows(3,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	ABMShared.BuildFooter(page)
End Sub

public Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)	
	
'	' add paragraph
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page, "par1", "The ABMChronologyList is a vertical timeline component.  Useful to give an overview of a limited period."))
	
	' chronolist test
	Dim chrono As ABMChronologyList
	chrono.Initialize(page, "chrono", "chrono")
	chrono.AddSlide("Slide1", BuildFiche(1, "08:05 - 08:29", "", "blue"), "blue")
	chrono.AddSlide("Slide2", BuildFiche(2, "08:29 - 10:05", "../images/gardenbefore.jpg", "green"), "green")
	chrono.AddSlide("Slide3", BuildFiche(3, "10:05 - 10:12", "", "green"), "green")
	chrono.AddSlide("Slide4", BuildFiche(4, "10:12 - 11:59", "", "red"), "red")
	chrono.AddSlide("Slide5", BuildFiche(5, "Used Material", "", "black"), "black")
	chrono.AddSlide("Slide6", BuildFiche(6, "11:59 - 12:25", "", "green"), "green")
	chrono.AddSlide("Slide7", BuildFiche(7, "12:25 - 15:02", "", "green"), "green")
	chrono.AddSlide("Slide8", BuildFiche(8, "15:02 - 15:17", "", "green"), "green")
	chrono.AddSlide("Slide9", BuildFiche(9, "15:17 - 16:32", "", "red"), "red")
	chrono.AddSlide("Slide10", BuildFiche(10, "16:32 - 17:43", "../images/gardenafter.jpg", "green"), "green")
	chrono.AddSlide("Slide11", BuildFiche(11, "17:43 - 18:07", "", "blue"), "blue")
	page.Cell(2,1).AddComponent(chrono)
		
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT!
		
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub BuildFiche(id As String, Title As String, pic As String, themeName As String) As ABMContainer 
	Dim Fiche As ABMContainer
	Fiche.Initialize(page, "fiche" & id, "")

	Fiche.AddRowsM(1, False,0,0, themeName).AddCellsOSMP(1,0,0,0,12,12,12,0,12,10,10,"")
	If themeName = "black" Then
		Fiche.AddRowsM(1, False,0,0, "").AddCellsOSMP(1,0,0,0,12,12,12,0,0,0,0,"")		
	Else
		Fiche.AddRowsM(1, True,0,0, "").AddCellsOSMP(1,0,0,0,12,12,12,0,0,0,0,"")
	End If
	If themeName = "red" Then
		Fiche.AddRowsM(1, True,0,10, "").AddCellsOSMP(1,0,0,0,12,12,12,0,0,0,0,"")		
	End If
	
	Fiche.BuildGrid
	If themeName = "black" Then
		Fiche.Row(2).MarginLeft = "auto"
		Fiche.Row(2).MarginRight = "auto"		
	End If
	
	Fiche.Row(1).MarginLeft = "0"
	Fiche.Row(1).MarginRight = "0"
	
	Dim titLabel As ABMLabel
	titLabel.Initialize(page, "titlabel" & id, Title, ABM.SIZE_H5,False, "white")
	Fiche.Cell(1,1).AddComponent(titLabel)
	Dim titLabel2 As ABMLabel
	titLabel2.Initialize(page, "titlabel2_" & id, ABM.Util.words(Rnd(1,5)), ABM.SIZE_H6,False, "white")
	Fiche.Cell(1,1).AddComponent(titLabel2)
	
	If pic <> "" Then
		Fiche.Cell(2,1).AddComponent(ABMShared.BuildImage(page, "ficheimg" & id, pic,1, "Garden"))
	End If
	
	If themeName = "black" Then
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
	
		Fiche.Cell(2,1).AddComponent(tbl1)
		
	Else
		Dim body As ABMLabel
		body.Initialize(page, "body" & id, ABM.Util.sentences(Rnd(1,10)), ABM.SIZE_PARAGRAPH, True, "")
		Fiche.Cell(2,1).AddComponent(body)
	End If
	
	If themeName = "red" Then
		Dim btn As ABMButton
		btn.InitializeFlat(page, id, "", "", "Validate", "")
		Fiche.Cell(3,1).AddArrayComponent(btn, "btn")
	End If
	
	Return Fiche	
End Sub

Sub btn_Clicked(Target As String)
	Log(Target)
	Dim slideNr As String = ABMShared.Mid2(Target,4)
	Log(slideNr)
	Dim chrono As ABMChronologyList = page.Component("chrono")
	chrono.SetSlideTheme("Slide" & slideNr, "green")
	chrono.GetSlideContainer("Slide" & slideNr).Cell(3,1).RemoveAllComponents
	chrono.GetSlideContainer("Slide" & slideNr).Row(1).UseTheme("green")
	chrono.Refresh
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "About" Then Return
	If Action = "ABMChronologyList" Then		
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


