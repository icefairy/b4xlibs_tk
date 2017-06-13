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
	Public Name As String = "ThemesPage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
	Dim Colors As List
	Dim Intensities As List	
	Dim Zdepths As List
	Dim RowTeller As Int
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
	Colors.Initialize2(Array As String(ABM.COLOR_RED, ABM.COLOR_PINK, ABM.COLOR_PURPLE, ABM.COLOR_DEEPPURPLE, ABM.COLOR_INDIGO, ABM.COLOR_BLUE, ABM.COLOR_LIGHTBLUE, ABM.COLOR_CYAN, ABM.COLOR_TEAL, ABM.COLOR_GREEN, ABM.COLOR_LIGHTGREEN, ABM.COLOR_LIME, ABM.COLOR_YELLOW, ABM.COLOR_AMBER, ABM.COLOR_ORANGE, ABM.COLOR_DEEPORANGE, ABM.COLOR_BROWN, ABM.COLOR_GREY, ABM.COLOR_BLUEGREY))
	Intensities.Initialize2(Array As String(ABM.INTENSITY_LIGHTEN5, ABM.INTENSITY_LIGHTEN4,ABM.INTENSITY_LIGHTEN3,ABM.INTENSITY_LIGHTEN2,ABM.INTENSITY_LIGHTEN1,ABM.INTENSITY_NORMAL, ABM.INTENSITY_DARKEN1, ABM.INTENSITY_DARKEN2,ABM.INTENSITY_DARKEN3,ABM.INTENSITY_DARKEN4,ABM.INTENSITY_ACCENT1,ABM.INTENSITY_ACCENT2,ABM.INTENSITY_ACCENT3,ABM.INTENSITY_ACCENT4))
	
	theme.AddTableTheme("ColorTable")
	For i = 0 To 15
		For j = 0 To 13
			theme.Table("ColorTable").AddCellTheme(Colors.Get(i) & j)
			theme.Table("ColorTable").Cell(Colors.Get(i) & j).BackColor = Colors.Get(i)		
			theme.Table("ColorTable").Cell(Colors.Get(i) & j).BackColorIntensity = Intensities.Get(j)
		Next
	Next
	For i = 16 To 18
		For j = 0 To 9
			theme.Table("ColorTable").AddCellTheme(Colors.Get(i) & j)
			theme.Table("ColorTable").Cell(Colors.Get(i) & j).BackColor = Colors.Get(i)		
			theme.Table("ColorTable").Cell(Colors.Get(i) & j).BackColorIntensity = Intensities.Get(j)
		Next
	Next
	theme.Table("ColorTable").AddCellTheme("black")
	theme.Table("ColorTable").Cell("black").BackColor = ABM.COLOR_BLACK
	theme.Table("ColorTable").AddCellTheme("white")
	theme.Table("ColorTable").Cell("white").BackColor = ABM.COLOR_WHITE
	theme.Table("ColorTable").AddCellTheme("transparent")
	theme.Table("ColorTable").Cell("transparent").BackColor = ABM.COLOR_TRANSPARENT
	
	theme.AddLabelTheme("black")
	theme.Label("black").ForeColor = ABM.COLOR_BLACK
	theme.AddLabelTheme("white")
	theme.Label("white").ForeColor = ABM.COLOR_WHITE	
	
	Zdepths.Initialize2(Array As String(ABM.ZDEPTH_REMOVE, ABM.ZDEPTH_1, ABM.ZDEPTH_2, ABM.ZDEPTH_3, ABM.ZDEPTH_4, ABM.ZDEPTH_5))
	
	For i = 0 To 5	
		theme.AddLabelTheme("zdepth" & i)
		theme.Label("zdepth" & i).ZDepth = Zdepths.get(i)
		theme.Label("zdepth" & i).BackColor = ABM.COLOR_WHITE
	Next
	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "Themes"
	page.PageDescription = "The themes and colors in ABMaterial"	
	page.PageHTMLName = "abmaterial-theme-color.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "Themes", "../images/logo.png", "", "Themes", "")
		
	' create the page grid
	page.AddRows(5,True, "").AddCells12(1,"")
	page.AddRows(7,True, "").AddCellsOS(3,0,0,0,4,4,4,"")
	page.AddRows(4,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	'page.ShowGridInfo = true
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)	
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1", "ABMaterial makes use of 'Themes' to set properties like backcolors, text colors, Zdepths, etc... to ABMComponents.  Good practice is using a module (like ABMChared' in this demo) to create all the themes you'll need a lot in all your pages. You can set in each page the themes specifically needed for that page.") )
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2", "Creating a theme is done using the Theme.AddxxxxxxTheme(""Name"") methods.  The name you give the theme can then be used later in the ThemeName parameter of the ABMComponent. Next you use the Theme.xxxxxx(""name"") methods to set properties like backcolors, zdepths, alignments etc..."))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par3", "In this demo app, this is the code of the themes that are used accross the app. "))
	
	Dim code As String
	code = $"Sub BuildTheme(themeName As String)
	MyTheme.Initialize(themeName)
	
	// the page theme
	MyTheme.Page.BackColor = ABM.COLOR_BLUEGREY
	MyTheme.Page.BackColorIntensity = ABM.INTENSITY_LIGHTEN4
	
	// the navbar theme
	MyTheme.AddNavigationBarTheme("nav1theme")
	MyTheme.NavigationBar("nav1theme").TopBarBackColor = ABM.COLOR_LIGHTBLUE
	
	// another navbar theme
	MyTheme.AddNavigationBarTheme("nav2theme")
	MyTheme.NavigationBar("nav2theme").TopBarBackColor = ABM.COLOR_RED
	
	// the footer theme
	MyTheme.AddContainerTheme("footertheme")
	MyTheme.Container("footertheme").BackColor = ABM.COLOR_LIGHTBLUE
	MyTheme.Container("footertheme").BackColorIntensity = ABM.INTENSITY_DARKEN3
	
	// footer label theme
	MyTheme.AddLabelTheme("whitefc")
	MyTheme.Label("whitefc").ForeColor = ABM.COLOR_WHITE
		
	// a label header theme
	MyTheme.AddLabelTheme("lightblue")
	MyTheme.Label("lightblue").ForeColor = ABM.COLOR_LIGHTBLUE	
	MyTheme.Label("lightblue").ForeColorIntensity = ABM.INTENSITY_DARKEN2
	
	// a table theme
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
	
	// a toast theme
	MyTheme.AddToastTheme("toast")
	MyTheme.Toast("toast").Rounded = True
	MyTheme.Toast("toast").ActionForeColor = ABM.COLOR_ORANGE
	
	// another toast theme
	MyTheme.AddToastTheme("toastred")
	MyTheme.Toast("toastred").Rounded = True
	MyTheme.Toast("toastred").ActionForeColor = ABM.COLOR_BLACK
	MyTheme.Toast("toastred").BackColor = ABM.COLOR_RED
	
End Sub"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code))
	
	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par4", "And this is the code specific for the CompButtonPage"))
	
	code = $"public Sub BuildTheme()
	// start with the base theme defined in ABMShared
	theme.Initialize("pagetheme")
	theme.AddABMTheme(ABMShared.MyTheme)
	
	// add additional themes specific for this page
	
	// toast theme
	theme.AddToastTheme("toastgreen")
	theme.Toast("toastgreen").BackColor = ABM.COLOR_GREEN
	theme.Toast("toastgreen").BackColorIntensity = ABM.INTENSITY_DARKEN2
	
	// bluegray button
	theme.AddButtonTheme("bluegrey")
	theme.Button("bluegrey").BackColor = ABM.COLOR_BLUEGREY
	theme.Button("bluegrey").BackColorIntensity = ABM.INTENSITY_DARKEN1
	
	// darkred button
	theme.AddButtonTheme("darkred")
	theme.Button("darkred").BackColor = ABM.COLOR_RED
	theme.Button("darkred").BackColorIntensity = ABM.INTENSITY_DARKEN1
	
	// transparent button
	theme.AddButtonTheme("transparent")
	theme.Button("transparent").BackColor = ABM.COLOR_TRANSPARENT	
	
	// darkgreen button
	theme.AddButtonTheme("darkgreen")
	theme.Button("darkgreen").BackColor = ABM.COLOR_GREEN
	theme.Button("darkgreen").BackColorIntensity = ABM.INTENSITY_DARKEN1	
	
	// modal sheet
	theme.AddContainerTheme("modalcontent")
	theme.Container("modalcontent").BackColor = ABM.COLOR_WHITE	
End Sub"$

	page.Cell(4,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code))

	' add a header label
	page.Cell(5,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Colors"))
	' add paragraph	
	page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par1", "This is the color palette that can be used within ABMaterial.  Use the ABM.COLOR_XXXX and ABM.INTENSITY_XXXX constants!"))
	
	page.Cell(6,1).AddComponent(BuildColorTable16(ABM.COLOR_RED))
	page.Cell(6,2).AddComponent(BuildColorTable16(ABM.COLOR_PINK))
	page.Cell(6,3).AddComponent(BuildColorTable16(ABM.COLOR_PURPLE))
	
	page.Cell(7,1).AddComponent(BuildColorTable16(ABM.COLOR_DEEPPURPLE))
	page.Cell(7,2).AddComponent(BuildColorTable16(ABM.COLOR_INDIGO))
	page.Cell(7,3).AddComponent(BuildColorTable16(ABM.COLOR_BLUE))
	
	page.Cell(8,1).AddComponent(BuildColorTable16(ABM.COLOR_LIGHTBLUE))
	page.Cell(8,2).AddComponent(BuildColorTable16(ABM.COLOR_CYAN))
	page.Cell(8,3).AddComponent(BuildColorTable16(ABM.COLOR_TEAL))
		
	page.Cell(9,1).AddComponent(BuildColorTable16(ABM.COLOR_GREEN))
	page.Cell(9,2).AddComponent(BuildColorTable16(ABM.COLOR_LIGHTGREEN))
	page.Cell(9,3).AddComponent(BuildColorTable16(ABM.COLOR_LIME))
	
	page.Cell(10,1).AddComponent(BuildColorTable16(ABM.COLOR_YELLOW))
	page.Cell(10,2).AddComponent(BuildColorTable16(ABM.COLOR_AMBER))
	page.Cell(10,3).AddComponent(BuildColorTable16(ABM.COLOR_ORANGE))
	
	page.Cell(11,1).AddComponent(BuildColorTable16(ABM.COLOR_DEEPORANGE))
	page.Cell(11,2).AddComponent(BuildColorTable12(ABM.COLOR_BROWN))
	page.Cell(11,3).AddComponent(BuildColorTable12(ABM.COLOR_GREY))
	
	page.Cell(12,1).AddComponent(BuildColorTable12(ABM.COLOR_BLUEGREY))
	page.Cell(12,2).AddComponent(BuildColorTableOther)
	
	' add paragraph	
	page.Cell(13,1).AddComponent(ABMShared.BuildParagraph(page,"par1", "The ZDEPTH_ constans can be used to set the ZDepth of a component."))	
		
	Dim lbl As ABMLabel
	lbl.Initialize(page, "lbl0", "ZDEPTH_REMOVE" ,ABM.SIZE_PARAGRAPH, True, "zdepth0")
	page.Cell(14,1).AddComponent(lbl)	
	For i = 1 To 5
		Dim lbl As ABMLabel
		lbl.Initialize(page, "lbl" & i, "ZDEPTH_" & i ,ABM.SIZE_PARAGRAPH, True, "zdepth" & i)
		page.Cell(14,1).AddComponent(lbl)		
	Next	
	
	' add paragraph
	page.Cell(15,1).AddComponent(ABMShared.BuildParagraph(page, "par2", "Now is a good time to start reading the Grids chapter and find out how layouts are designed in Googles Material Design.  Click the Grids section in the menu."))

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
	If Action = "Themes" Then Return
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

Sub BuildColorTable16(Col As String) As ABMTable
	' create a table
	Dim tbl1 As ABMTable
	tbl1.Initialize(page, "tbl1" & Col, False, False, False, "ColorTable")
	
	Dim ColString As String = "COLOR_" & Col.ToUpperCase
	
	For i = 0 To 13
		Dim r As List
		Dim t As List
		r.Initialize
		t.Initialize
		Dim lbl As ABMLabel
		Dim Intensity As String = "INTENSITY_" & Intensities.get(i)
		Intensity = Intensity.ToUpperCase
		If i < 6 Or i > 9 Then
			lbl.Initialize(page, "lbl" & Col, ColString & "{BR} " & Intensity,ABM.SIZE_PARAGRAPH, False, "black")
		Else
			lbl.Initialize(page, "lbl" & Col, ColString & "{BR}" & Intensity,ABM.SIZE_PARAGRAPH, False, "white")
		End If
		r.Add(lbl)
		t.Add(Col & i)
		RowTeller = RowTeller + 1
		tbl1.AddRow("uidct" & RowTeller, r)
		tbl1.SetRowThemes(t)
	Next
	Return tbl1
End Sub

Sub BuildColorTable12(Col As String) As ABMTable
	' create a table
	Dim tbl1 As ABMTable
	tbl1.Initialize(page, "tbl1" & Col, False, False, False, "ColorTable")
	
	Dim ColString As String = "COLOR_" & Col.ToUpperCase
	
	For i = 0 To 9
		Dim r As List
		Dim t As List
		r.Initialize
		t.Initialize
		Dim lbl As ABMLabel
		Dim Intensity As String = "INTENSITY_" & Intensities.get(i)
		Intensity = Intensity.ToUpperCase
		If i < 6 Then
			lbl.Initialize(page, "lbl" & Col, ColString & "{BR}" & Intensity,ABM.SIZE_PARAGRAPH, False, "black")
		Else
			lbl.Initialize(page, "lbl" & Col, ColString & "{BR}" & Intensity,ABM.SIZE_PARAGRAPH, False, "white")
		End If
		r.Add(lbl)
		t.Add(Col & i)
		RowTeller = RowTeller + 1
		tbl1.AddRow("uidct" & RowTeller, r)
		tbl1.SetRowThemes(t)
	Next
	Return tbl1
End Sub

Sub BuildColorTableOther() As ABMTable
	' create a table
	Dim tbl1 As ABMTable
	tbl1.Initialize(page, "tbl1", False, False, False, "ColorTable")
	
	
	Dim r As List
	Dim t As List
	
	r.Initialize
	t.Initialize
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, "lbl", "COLOR_BLACK{BR}{NBSP}",ABM.SIZE_PARAGRAPH, False, "white")
	r.Add(lbl1)
	t.Add("black")
	RowTeller = RowTeller + 1
	tbl1.AddRow("uidcd" & RowTeller, r)
	tbl1.SetRowThemes(t)
	
	r.Initialize
	t.Initialize
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, "lbl", "COLOR_WHITE{BR}{NBSP}",ABM.SIZE_PARAGRAPH, False, "black")
	r.Add(lbl1)
	t.Add("white")
	RowTeller = RowTeller + 1
	tbl1.AddRow("uidcd" & RowTeller, r)
	tbl1.SetRowThemes(t)
	
	r.Initialize
	t.Initialize
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, "lbl", "COLOR_TRANSPARENT{BR}{NBSP}" ,ABM.SIZE_PARAGRAPH, False, "black")
	r.Add(lbl1)
	t.Add("transparent")
	RowTeller = RowTeller + 1
	tbl1.AddRow("uidcd" & RowTeller, r)
	tbl1.SetRowThemes(t)
	
	Return tbl1
End Sub