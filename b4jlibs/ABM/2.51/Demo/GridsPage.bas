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
	Public Name As String = "GridsPage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
	
	Dim Origin As String = "http://prd.one-two.com:51042" '<--- IMPORTANT for youtube videos.  Set here your website address
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
		ws.session.SetAttribute("ABMNewSession", True)
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
				' cannot be called diretly, to many param
				CallSub2(Me, eventName, Params)				
		End Select
	End If
End Sub

public Sub BuildTheme()
	' start with the base theme defined in ABMShared
	theme.Initialize("pagetheme")
	theme.AddABMTheme(ABMShared.MyTheme)
	
	' add additional themes specific for this page
		
	' cell theme
	theme.AddCellTheme("cellLB")
	theme.Cell("cellLB").BackColor = ABM.COLOR_LIGHTBLUE
	theme.Cell("cellLB").BorderColor = ABM.COLOR_WHITE
	theme.Cell("cellLB").BorderWidth = 1
	
	' grid label
	theme.AddLabelTheme("lblGrid")
	theme.Label("lblGrid").ForeColor = ABM.COLOR_WHITE
	theme.Label("lblGrid").Align = ABM.TEXTALIGN_CENTER
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "Grids"
	page.PageDescription = "Grids and layouts in ABMaterial"	
	page.PageHTMLName = "abmaterial-grid-layout.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "Grids", "../images/logo.png", "", "Layouts", "")
	
	' create the page grid
	page.AddRows(1, True,"").AddCells12(1,"")
	page.AddRowsM(1, True,0,0,"").AddCellsOS(12,0,0,0,3,2,1,"")
	page.AddRows(3, True,"").AddCells12(1,"")
	page.AddRowsM(1, True,0,0,"").AddCellsOS(2,0,0,0,6,6,6,"")
	page.AddRows(2, True,"").AddCells12(1,"")
	page.AddRowsM(1, True,0,0,"").AddCellsOS(1,6,6,6,6,6,6,"")
	page.AddRows(11, True,"").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add a header label
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Introduction"))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Take a look at this section to quickly understand how grids work! Make sure you have read theThemes topic first. We use themes when we design a grid.") )
	' add sub header
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1b","{B}In ABMaterial 2.20+, we have a GRID BUILDER to make it easy to build Grids.  You can find this chapter at the end of this topic, but it is very important you grab the concept of the Grid and Cells before proceeding!{/B}") )
	Dim img2 As ABMImage
	img2.Initialize(page, "img2", "../images/gridbuilder1.png", 1)	
	img2.IsResponsive = True
	page.Cell(1,1).AddComponent(img2)
	
	' add sub header
	page.Cell(1,1).AddComponent(ABMShared.BuildSubHeader(page, "shdr1", "12 Cells"))
	' add paragraph
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page, "par2","Our standard grid has 12 cells. No matter the size of the browser, each of these cells will always have an equal width."))
	' add 12 cells
	For i=1 To 12
		page.Cell(2,i).UseTheme("cellLB")
		Dim lblGrid As ABMLabel
		lblGrid.Initialize(page, "Rgrid2C" & i & "Label", "" & i, ABM.SIZE_H6, True, "lblGrid")
		page.Cell(2,i).AddComponent(lblGrid)
	Next
	' add paragraph
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page, "par3", "To get a feel of how the grid is used in B4J, take a look at the code below which will produce a grid definition used in this page."))
	
	' add codeblock	
	Dim code As String
	code = $"// create the page grid
page.AddRows(1,True, "").AddCells12(1,"")	
page.AddRowsM(1,True,0,0, "").AddCellsOS(12,0,0,0,1,1,1,"")
page.AddRows(3,True, "").AddCells12(1,"")
page.AddRowsM(1,True,0,0, "").AddCellsOS(2,0,0,0,6,6,6,"")
page.AddRows(2,True, "").AddCells12(1,"")
page.AddRowsM(1,True,0,0, "").AddCellsOS(1,6,6,6,6,6,6,"")
page.AddRows(6,True, "").AddCells12(1,"")
page.BuildGrid //IMPORTANT once you loaded the complete grid AND before you start adding components"$
	
	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code))
	
	' add sub header
	page.Cell(4,1).AddComponent(ABMShared.BuildSubHeader(page, "shdr2", "Cells live inside rows"))	
	' add paragraph
	page.Cell(4,1).AddComponent(ABMShared.BuildParagraph(page, "par4", "You can create columns in a row by dividing the 12 cells into parts. For example here we use the 12 cells to create 2 columns, each 6 cells wide."))
		
	page.Cell(5,1).UseTheme("cellLB")
	Dim lblGrid As ABMLabel
	lblGrid.Initialize(page, "Rgrid5C1Label", "This row is 12-cells wide on all screen sizes", ABM.SIZE_H6, True, "lblGrid")
	page.Cell(5,1).AddComponent(lblGrid)
		
	page.Cell(6,1).UseTheme("cellLB")
	Dim lblGrid As ABMLabel
	lblGrid.Initialize(page, "Rgrid6C1Label", "6-cells (one-half)", ABM.SIZE_H6, True, "lblGrid")
	page.Cell(6,1).AddComponent(lblGrid)
	
	page.Cell(6,2).UseTheme("cellLB")
	Dim lblGrid As ABMLabel
	lblGrid.Initialize(page, "Rgrid6C2Label", "6-cells (one-half)", ABM.SIZE_H6, True, "lblGrid")
	page.Cell(6,2).AddComponent(lblGrid)
	
	' add sub header
	page.Cell(7,1).AddComponent(ABMShared.BuildSubHeader(page, "shdr3", "Offsets"))	
	' add paragraph
	page.Cell(7,1).AddComponent(ABMShared.BuildParagraph(page, "par5", "To offset use the offset parameters.  Offsets are {B}relative{/B} to the previous cell in the row (or 0 for the first one). This way you can create 'gabs' between cells. In the next example we create a 6-cell column with an offset by 6."))
		
	page.Cell(8,1).UseTheme("cellLB")
	Dim lblGrid As ABMLabel
	lblGrid.Initialize(page, "Rgrid8C1Label", "This row is 12-cells wide on all screen sizes", ABM.SIZE_H6, True, "lblGrid")
	page.Cell(8,1).AddComponent(lblGrid)
		
	page.Cell(9,1).UseTheme("cellLB")
	Dim lblGrid As ABMLabel
	lblGrid.Initialize(page, "Rgrid9C1Label", "6-cells (offset-by-6)", ABM.SIZE_H6, True, "lblGrid")
	page.Cell(9,1).AddComponent(lblGrid)
	
	' add sub header
	page.Cell(10,1).AddComponent(ABMShared.BuildSubHeader(page, "shdr4", "Screen sizes and cell offsets/sizes"))	
	' add paragraph
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page, "par6", "Some AddCellxxx() methods accept 6 extra parameters to set the offsets and sizes for small, medium and large screens so you can make your app adept to different device sizes (phone, tablet, desktop)."))
	' add paragraph
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page, "par7", "An overview of the different AddRowxx() methods"))
	
	' add paragraph	
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page, "par8", "{B}AddRows(numberOfRows, centerInRow, themeName){/B}"))
	' add param table
	Dim Headers, codes, Descriptions As List
	Headers.Initialize2(Array As String("Param", "Description"))
	codes.Initialize2(Array As String("numberOfRows", "centerInRow", "themeName"))
	Descriptions.Initialize2(Array As String("You can use this schortcut to add the same row multiple times. Instead of writing 3 times 'page.AddRows(1,True, """").AddCells12(1,"""")', you can write 'page.AddRows(3,True, """").AddCells12(1,"""")'. Uses a default marginTopPx and marginBottomPx of 20 pixels.", "If true, the row will use approx between 75% and 85% of the available screen width, creating some sort of border. (% depends on screen size)", "Optional name of the theme you have created.  Can be """"."))
	page.Cell(10,1).AddComponent(ABMShared.BuildParamTable(page, "param1", Headers, codes, Descriptions))
	
	' add paragraph	
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page, "par9", "{B}AddRowsM(numberOfRows, centerInRow, marginTopPx, marginBottomPx, themeName){/B}"))
		' add param table
	Dim Headers, codes, Descriptions As List
	Headers.Initialize2(Array As String("Param", "Description"))
	codes.Initialize2(Array As String("numberOfRows", "centerInRow", "marginTopPx", "marginBottomPx", "themeName"))
	Descriptions.Initialize2(Array As String("You can use this schortcut to add the same row multiple times. Instead of writing 3 times 'page.AddRows(1,True, """").AddCells12(1,"""")', you can write 'page.AddRows(3,True, """").AddCells12(1,"""")' ", "Tune the top margin of the row in pixels, can be negative.", "Tune the bottom margin of the row in pixels, can be negative.", "If true, the row will use approx 75% and 85% of the available screen width, creating some sort of border. (% depends on screen size)", "Optional name of the theme you have created.  Can be """"."))
	page.Cell(10,1).AddComponent(ABMShared.BuildParamTable(page, "param2", Headers, codes, Descriptions))
	
	' add paragraph
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page, "par10", "An overview of the different AddCellxx() methods"))
	
	' add paragraph	
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page, "par11", "{B}AddCells12(numberOfRows, themeName){/B}"))
	' add param table
	Dim Headers, codes, Descriptions As List
	Headers.Initialize2(Array As String("Param", "Description"))
	codes.Initialize2(Array As String("numberOfRows", "themeName"))
	Descriptions.Initialize2(Array As String("You can use this schortcut to add the same cell multiple times. Instead of writing 3 times 'page.AddRows(1,True, """").AddCells12(1,"""")', you can write 'page.AddRows(1,True, """").AddCells12(3,"""")'. In this method this has a certain side effect: As described above, one row can only have 12 cells.  So creating 3 x 12 Cells will 'wrap' them to the next line.", "Optional name of the theme you have created.  Can be """"."))
	page.Cell(10,1).AddComponent(ABMShared.BuildParamTable(page, "param3", Headers, codes, Descriptions))
	
	' add paragraph	
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page, "par12", "{B}AddCellsOS(numberOfCells, offsetSmall, offsetMedium, offsetLarge, sizeSmall, sizeMedium, sizeLarge, themeName){/B}"))
	' add param table
	Dim Headers, codes, Descriptions As List
	Headers.Initialize2(Array As String("Param", "Description"))
	codes.Initialize2(Array As String("numberOfRows", "offsetSmall", "offsetMedium", "offsetLarge", "sizeSmall", "sizeMedium", "sizeLarge", "themeName"))
	Descriptions.Initialize2(Array As String("You can use this schortcut to add the same cell multiple times.", "Offset of the cell on small screens.", "Offset of the cell on medium screens.", "Offset of the cell on large screens.", "Size of the cell on small screens.", "Size of the cell on medium screens.", "Size of the cell on large screens.", "Optional name of the theme you have created.  Can be """"."))
	page.Cell(10,1).AddComponent(ABMShared.BuildParamTable(page, "param4", Headers, codes, Descriptions))
	
	' add paragraph	
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page, "par13", "{B}AddCells12MP(numberOfCells, marginTopPx, marginBottomPx, paddingLeftPx, paddingRightPx, themeName){/B}"))
	' add param table
	Dim Headers, codes, Descriptions As List
	Headers.Initialize2(Array As String("Param", "Description"))
	codes.Initialize2(Array As String("numberOfRows", "marginTopPx", "marginBottomPx", "paddingLeftPx", "paddingRightPx", "themeName"))
	Descriptions.Initialize2(Array As String("You can use this schortcut to add the same cell multiple times.", "Tune the top margin of the cell in pixels, can be negative.", "Tune the bottom margin of the cell in pixels, can be negative.", "Tune the left padding of the cell in pixels.", "Tune the right padding of the cell in pixels.", "Optional name of the theme you have created.  Can be """"."))
	page.Cell(10,1).AddComponent(ABMShared.BuildParamTable(page, "param5", Headers, codes, Descriptions))
		
	' add paragraph	
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page, "par14", "{B}AddCellsOSMP(numberOfCells, offsetSmall, offsetMedium, offsetLarge, sizeSmall, sizeMedium, sizeLarge, marginTopPx, marginBottomPx, paddingLeftPx, paddingRightPx, themeName){/B}"))
	' add param table
	Dim Headers, codes, Descriptions As List
	Headers.Initialize2(Array As String("Param", "Description"))
	codes.Initialize2(Array As String("numberOfRows", "offsetSmall", "offsetMedium", "offsetLarge", "sizeSmall", "sizeMedium", "sizeLarge","marginTopPx", "marginBottomPx", "paddingLeftPx", "paddingRightPx", "themeName"))
	Descriptions.Initialize2(Array As String("You can use this schortcut to add the same cell multiple times.", "Offset of the cell on small screens.", "Offset of the cell on medium screens.", "Offset of the cell on large screens.", "Size of the cell on small screens.", "Size of the cell on medium screens.", "Size of the cell on large screens.", "Tune the top margin of the cell in pixels, can be negative.", "Tune the bottom margin of the cell in pixels, can be negative.", "Tune the left padding of the cell in pixels.", "Tune the right padding of the cell in pixels.", "Optional name of the theme you have created.  Can be """"."))
	page.Cell(10,1).AddComponent(ABMShared.BuildParamTable(page, "param6", Headers, codes, Descriptions))
	
	' add sub header
	page.Cell(11,1).AddComponent(ABMShared.BuildSubHeader(page, "shdr5", "Some guidelines"))	
	' add paragraph
	page.Cell(11,1).AddComponent(ABMShared.BuildParagraph(page, "par15", "I'm aware this is not an easy part to understand.  Start with simple layouts, and use the more advanced methods once you start understanding what is going on.  In the beginning I found it usefull to draw my Grid on paper to visualize it.  Knowing exactly how your page needs to look is an important part of the design. Further into the tutorial, we're going to meet controls (like ABMContainer) that allows to create grids within grids so again it's {B}VERY IMPORTANT{/B} you grab this concept.  If you have to start adding rows (or even cells) afterwards, you're in for some work going over your code making adjustments!"))
	' add paragraph
	page.Cell(11,1).AddComponent(ABMShared.BuildParagraph(page, "par16", "This is a representation of the grid of this page on paper. Compare this image with the code block at the beginning of the page."))
		
	Dim img As ABMImage
	img.Initialize(page, "img", "../images/grid.png", 1)	
	img.IsResponsive = True
	page.Cell(12,1).AddComponent(img)
	
	' add a header label
	page.Cell(13,1).AddComponent(ABMShared.BuildHeader(page,"grhdr1", "The ABMGridBuilder"))
	' add paragraph	
	page.Cell(13,1).AddComponent(ABMShared.BuildParagraph(page,"grpar1","The ABMGridBuilder is a tool to make grids easy.  It is based on the excellent system introduced by Shoelace.io.  I adapted the system so it is usefull for ABMaterial and added some specific functionalities like adding rows and cells before others.") )
	' add paragraph	
	page.Cell(13,1).AddComponent(ABMShared.BuildParagraph(page,"grpar2","With the tool, you can generate the needed AddRow and AddCell B4J methods described before.  Using the Clipboard, you can then paste it at the relevant place in your code.") )
	' add paragraph	
	page.Cell(13,1).AddComponent(ABMShared.BuildParagraph(page,"grpar3","{B}But even more!{/B} You can copy your AddRow and AddCell methods to the clipboard, and ABMGridBuilder can parse this code an 'rebuild' the visual representation. Cool, no?") )
	' add paragraph	
	page.Cell(13,1).AddComponent(ABMShared.BuildParagraph(page,"grpar4","Have a look at this video which demonstrates the whole story.") )
	
	' add Youtube video
	Dim video1b As ABMVideo
	video1b.InitializeYoutube(page, "video1b", "//www.youtube.com/embed/rQvbq9BVoTI", Origin, False, False, False, 100)
	page.Cell(14,1).AddComponent(video1b)
	
	page.Cell(15,1).AddComponent(ABMShared.BuildParagraph(page,"grpar5","Using the function buttons on the cells and the grid you can add/remove/move/resize the rows and cells.") )
	
	Dim img2a As ABMImage
	img2a.Initialize(page, "img2a", "../images/gridbuilder2.png", 1)	
	img2a.IsResponsive = True
	page.Cell(15,1).AddComponent(img2a)
	
	page.Cell(15,1).AddComponent(ABMShared.BuildParagraph(page,"grpar6","Using the clipboard, you can paste the generated code into your application.  You can select the AddRows lines in you code and 'rebuild' it to a visual representation of your grid.  This is particulary useful for grids you manually created in ABMaterial version before version 2.20.") )
	
	page.Cell(16,1).AddComponent(ABMShared.BuildParagraph(page,"grpar7","This is just a quick introduction, so make sure you also check the B4J forum for some more tutorials and tips & tricks on the ABMGridBuilder.") )
	
	' add paragraph
	page.Cell(17,1).AddComponent(ABMShared.BuildParagraph(page, "par17", "Next chapter to read should be the ABMPage object in the Helpers menu."))
	
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
	If Action = "Grids" Then Return
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


