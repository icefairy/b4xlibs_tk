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
	Public Name As String = "HelperPagePage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
	Dim tmpCardId As Int
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
	theme.AddContainerTheme("bluegrey")
	theme.Container("bluegrey").BackColor = ABM.COLOR_BLUEGREY
	theme.Container("bluegrey").BackColorIntensity = ABM.INTENSITY_LIGHTEN4
	
	theme.AddCardTheme("whitetitle")
	theme.Card("whitetitle").TitleForeColor = ABM.COLOR_WHITE
	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMPage"
	page.PageDescription = "The page helper"	
	page.PageHTMLName = "abmaterial-page.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
	
	' experimental, may not work on some devices
	page.SetBackgroundVideo("../images/webm.webm", "../images/mp4.mp4", "../images/ogv.ogv", True, 0, True, "../images/poster.jpg")
	' just setting a background image
	' page.SetBackgroundImage("../images/poster.jpg")
		
	ABMShared.BuildNavigationBar(page, "ABMPage", "../images/logo.png", "", "Helpers", "ABMPage")	
		
	' create the page grid
	page.AddRows(1,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	ABMShared.BuildFooterFixed(page)	
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' because we have an animated background, we'll put everything into a ABMContainer
	Dim pagecont As ABMContainer
	pagecont.Initialize(page, "cont", "bluegrey")
	pagecont.AddRows(17,True, "bluegrey").AddCells12(1,"")
	pagecont.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	' add paragraph	
	pagecont.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","ABMPage is the main entrypoint to your webpage in a B4J Server WebSocket class. If you've copied the ABMPageTemplate, page and all its events will be declared for you.") )
	
	' add paragraph	
	pagecont.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","It is good practice to have to methods in your page class: BuildTheme() and BuildPage().  BuildTheme() can be used to set up all your themes you are going to use in this page. You can inherit all the themes you declared in ABMShared using the AddABMTheme() method, and create additional themes for this page specific.") )
	
	Dim code As String = $"public Sub BuildTheme()
	// start with the base theme defined in ABMShared
	theme.Initialize("pagetheme")
	theme.AddABMTheme(ABMShared.MyTheme)
	
	// add additional themes specific for this page
	theme.AddContainerTheme("white")
	theme.Container("White").BackColor = ABM.COLOR_WHITE
	theme.Container("White").ZDepth = ABM.ZDEPTH_1
End Sub"$
	
	pagecont.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code))
	
	' add paragraph	
	pagecont.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par3","BuildPage() has to be setup in a certain way before you can start adding controls. First, load your themes. Next Initialize the Page object and add a navigation bar if you need one. Before we can add components, we have to desing our page grid.  If you have not read the part on Grids, this is now a good time.") )
	' add paragraph	
	pagecont.Cell(3,1).AddComponent(ABMShared.BuildParagraphBQ(page,"par4","Once you have added all your rows and cells you must use the BuildGrid command {B}BEFORE{/B} you start adding components!") )
	
	code = $"public Sub BuildPage()
	// initialize the theme
	BuildTheme
	
	// initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & AppName & "/" & Name, False, theme)
	page.ShowLoader=True
		
	ABMShared.BuildNavigationBar(page, "ABMPage", "../images/logo.png", "", "Helpers", "ABMPage")
		
	// create the page grid
	page.AddRows(5,True, "").AddCells12(1,"")
	page.BuildGrid //IMPORTANT once you loaded the complete grid AND before you start adding components
End Sub"$
	
	pagecont.Cell(4,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code))
	
	' add a header label
	pagecont.Cell(5,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Start adding components"))
	' add paragraph	
	pagecont.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par5","You can add components to a cell with two methods: AddComponent() or AddArrayComponent(). To add a component to a specific cell, 'navigate' to the cell width Page.cell(rowIndex,cellIndex). RowIndex and cellIndex are One-Based: meaning, the first row = 1, the first cell within a row = 1. Because you have to use Page.Cell() to position yourself within you page, you can see how important it is you've designed your grid well before adding components.  If you have to 'insert' a row, you will have to go change the all the Page.Cell() lines after it to correct them.  I'm thinking of a way to avoid this problem so that you can add components 'relative' to the previous row. (work in progress).") )
	' add paragraph	
	pagecont.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par6","The code to add this line label looks like this (adding it to row 5, cell 1)") )
	
	code = $"// add paragraph	
page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par6","The code to add this line label looks like this (adding it to row 5, cell 1)") )"$
	
	pagecont.Cell(6,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code3", code))
	
	' add paragraph	
	pagecont.Cell(7,1).AddComponent(ABMShared.BuildParagraphBQ(page,"par7","When you go through the code, you will see several components are added to the same row and cell. Therefor it is important you give each component {B}a unique ID{/B}.  Internally, ABMaterial uses a Map() object to organize the components, and the same IDs will overwrite each other.  One exception you may overlook this rule is: 1. You do not need to access the control anywhere in your code (like a static label) AND 2. the components are in different rows.  But generally, just give them all a unique id, and you do not have to worry about this.") )
	
	' add paragraph
	pagecont.Cell(8,1).AddComponent(ABMShared.BuildHeader(page, "par8", "How about AddArrayComponent()?"))
	
	' add paragraph	
	pagecont.Cell(8,1).AddComponent(ABMShared.BuildParagraph(page, "par9", "AddArrayComponent is a shortcut function to add several components that will share the same event code. For example, on the ABMChip page, we add the chips with AddArrayComponent() because we do not know how many chips there are going to be and we can't write a click event for each of them seperately."))
	
	' add paragraph	
	pagecont.Cell(8,1).AddComponent(ABMShared.BuildParagraph(page, "par10", "I found it practical giving the 'Array' components just the numeric part of the ID. This way you can use the Event name as you would any other event. e.g. here: 'mycheck' is the ArrayName, and '5', '6', '7', '8' are the IDs.  Now we can use mycheck_Clicked() and use the target to get our individual component."))
	
	' add codeblock	
	Dim code3 As StringBuilder
	code3.Initialize
	code3.Append("// create the chips").Append(CRLF)	
	code3.Append("Dim ch5 As ABMChip").Append(CRLF)
	code3.Append("ch5.Initialize(page, ""5"", ""Dad"", False, """")").Append(CRLF)
	code3.Append("ch5.Image = ""../images/dad.jpg""").Append(CRLF)
	code3.Append("page.Cell(8,1).AddArrayComponent(ch5, ""mycheck"")").Append(CRLF)
	code3.Append("").Append(CRLF)
	code3.Append("Dim ch6 As ABMChip").Append(CRLF)
	code3.Append("ch6.Initialize(page, ""6"", ""Mom"", False, """")").Append(CRLF)
	code3.Append("ch6.Image = ""../images/mom.jpg""").Append(CRLF)
	code3.Append("page.Cell(8,1).AddArrayComponent(ch6, ""mycheck"")").Append(CRLF)
	code3.Append("").Append(CRLF)
	code3.Append("Dim ch7 As ABMChip").Append(CRLF)
	code3.Append("ch7.Initialize(page, ""7"", ""Brother"", True, """")").Append(CRLF)
	code3.Append("ch7.Image = ""../images/brother.jpg""").Append(CRLF)
	code3.Append("page.Cell(8,1).AddArrayComponent(ch7, ""mycheck"")").Append(CRLF)
	code3.Append("").Append(CRLF)
	code3.Append("Dim ch8 As ABMChip").Append(CRLF)
	code3.Append("ch8.Initialize(page, ""8"", ""Sister"", True, """")").Append(CRLF)
	code3.Append("ch8.Image = ""../images/sister.jpg""").Append(CRLF)
	code3.Append("page.Cell(8,1).AddArrayComponent(ch8, ""mycheck"")").Append(CRLF)
	
	pagecont.Cell(8,1).AddComponent(ABMShared.BuildCodeBlock(page, "code3", code3))	
	
	' add codeblock	
	Dim code4 As StringBuilder
	code4.Initialize
	code4.Append("Sub mycheck_Clicked(Target As String)").Append(CRLF)
	code4.Append("   Dim chip As ABMChip = page.Component(Target)").Append(CRLF)
	code4.Append("   Dim title As String = chip.Text").Append(CRLF)
	code4.Append("   Dim myTexts, myReturns As List").Append(CRLF)
	code4.Append("   myTexts.Initialize").Append(CRLF)
	code4.Append("   myReturns.Initialize").Append(CRLF)
	code4.Append("   myToastId = myToastId + 1").Append(CRLF)
	code4.Append("   page.ShowToast(""toast"" & myToastId, ""toastgreen"", ""Clicked "" & title, 5000, myTexts, myReturns)").Append(CRLF)
	code4.Append("End Sub").Append(CRLF)	
	
	pagecont.Cell(8,1).AddComponent(ABMShared.BuildCodeBlock(page, "code4", code4))
	
	' add paragraph
	pagecont.Cell(9,1).AddComponent(ABMShared.BuildHeader(page, "par10", "Adding a footer to your page"))
	
	' add paragraph	
	pagecont.Cell(9,1).AddComponent(ABMShared.BuildParagraph(page, "par11", "Each page can have a footer.  You have floating and fixed footers.  The footers on all the pages in this app are floating (they scroll with the page), except the one on this page which is fixed (it is always on the bottom of your screen, no mather how you scroll the body).  This can be handy if you want to have e.g. buttons on the bottom of your app that should be accessible at all time. Footer is an ABMContainer, so you can put whatever ABMComponent into it, making it a powerful taskbar."))
	
	' add paragraph	
	pagecont.Cell(9,1).AddComponent(ABMShared.BuildParagraphBQ(page,"par12","When you use a fixed footer, you need to set the padding in pixels of the bottom of the page!") )
	
	code = $"Sub BuildFooterFixed(page As ABMPage)	
	page.isFixedFooter= True
	// because we have a fixed footer at the bottom, we have to adjust the padding of the body in pixels
	page.PaddingBottom = 150
	
	page.Footer.AddRows(1, True, "").AddCellsOS(2,0,0,0,6,6,6, "") 
	page.Footer.BuildGrid //IMPORTANT once you loaded the complete grid AND before you start adding components	
	
	page.Footer.UseTheme("footertheme")
	
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, "footlbl1", "Blog: Alwaysbusy's Corner{BR}{BR}B4J by Anywhere Software{BR}Materialize CSS by students from Carnegie Mellon University",ABM.SIZE_PARAGRAPH, False, "whitefc")
	page.Footer.Cell(1,1).AddComponent(lbl1)
	
	Dim lbl2 As ABMLabel
	lbl2.Initialize(page, "footlbl2", "ABMaterial Copyright @2015-2016{BR}By Alain Bailleul{BR}{BR}Email: alain.bailleul@telenet.be",ABM.SIZE_PARAGRAPH, False, "whitefc")
	page.Footer.Cell(1,2).AddComponent(lbl2)	
End Sub"$
	
	pagecont.Cell(10,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code5", code))
	
	' add a header label
	pagecont.Cell(11,1).AddComponent(ABMShared.BuildHeader(page,"hdr10", "Pausing/Resuming your Page"))
	' add paragraph	
	pagecont.Cell(11,1).AddComponent(ABMShared.BuildParagraph(page,"par15","With Page.Pause you can pause your app.  This can be useful if you have to do something very time consuming on your server and the user has to wait some time. A black transparent overlay with 'loading' animation will be shown over the page.  IMPORTANT! You have to resume the action with Page.Resume. ") )
	
	
	' add paragraph	
	pagecont.Cell(11,1).AddComponent(ABMShared.BuildParagraph(page,"par13","A good next read would be the ABMNavigationBar section in the Helpers menu.") )
	
	
	pagecont.Cell(12,1).AddComponent(ABMShared.BuildHeader(page,"hdr19", "Google Analytics and SEO (Search Engine Optimisation)"))
	pagecont.Cell(12,1).AddComponent(ABMShared.BuildParagraph(page,"par19", "Unlike many other WebApp tools, ABMaterial allows you to use SEO and Google Analytics in your WebApps.  This can be done by adding just a couple of extra lines in the BuildPage method!") )

	Dim code8 As String = $"page.InitializeWithTheme(Name, "/ws/" & AppName & "/" & Name, False, theme)
page.ShowLoader=True
page.PageTitle = "ABMPage"
page.PageDescription = "The page helper"	
page.PageHTMLName = "abmaterial-page.html"
page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
page.PageSiteMapPriority = "0.50"
page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
page.UseGoogleAnalytics("UA-73003715-6", Null)
page.RunGoogleAnalyticsCommand("'send', 'event', 'link', 'click', 'http://example.com', {nonInteraction: True}")"$

	pagecont.Cell(13,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code8", code8))
	
	
	' add a header label
	pagecont.Cell(14,1).AddComponent(ABMShared.BuildHeader(page,"hdr18", "Infinite Scrolling Pages"))
	
	' add paragraph	
	pagecont.Cell(14,1).AddComponent(ABMShared.BuildParagraph(page,"par18","Using the 'page.RaiseNextContentOnComponent()' method you can create infinite pages. Keep scrollong down and new cards will be added!") )
	
	Dim code6 As String = $"Sub Page_NextContent(TriggerComponent As String)
	LoadNewCard
End Sub"$
	
	pagecont.Cell(16,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code6", code6))
	
	Dim code6 As String = $"Sub Page_NextContent(TriggerComponent As String)
	LoadNewCard
End Sub"$

	Dim code7 As String = $"Sub LoadNewCard() 
	Dim pagecont As ABMContainer = page.Component("cont")
	// build the card
	Dim tmpCard As ABMCard
	tmpCardId = tmpCardId + 1
	DateTime.TimeFormat = "HH:mm:ss"
	tmpCard.InitializeAsCard(page, "card" & tmpCardId, DateTime.Date(DateTime.Now) & " " & DateTime.Time(DateTime.now), "This is a new card from an infinite page", ABM.CARD_LARGE, "whitetitle")
	Dim picNr As Int = Rnd(1,96)
	tmpCard.Image = "../images2/" & picNr & ".jpg"
	tmpCard.AddAction("BUTTON 1")	
	// add the card and refresh
	pagecont.Cell(15,1).AddComponent(tmpCard)
	pagecont.cell(15,1).Refresh
	// set this card as the new trigger
	page.RaiseNextContentOnComponent(tmpCard,200)
End Sub"$
	
	pagecont.Cell(16,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code7", code7))
	
	page.Cell(1,1).AddComponent(pagecont)
	
	' also add the components to the footer
	ABMShared.ConnectFooterFixed(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	LoadNewCard
	
	page.RestoreNavigationBarPosition
End Sub

Sub Page_NextContent(TriggerComponent As String)
	LoadNewCard
End Sub

Sub LoadNewCard() 
	Dim pagecont As ABMContainer = page.Component("cont")
	' build the card
	Dim tmpCard As ABMCard
	tmpCardId = tmpCardId + 1
	DateTime.TimeFormat = "HH:mm:ss"
	tmpCard.InitializeAsCard(page, "card" & tmpCardId, DateTime.Date(DateTime.Now) & " " & DateTime.Time(DateTime.now), "This is a new card from an infinite page", ABM.CARD_LARGE, "whitetitle")
	Dim picNr As Int = Rnd(1,96)
	tmpCard.Image = "../images2/" & picNr & ".jpg"
	tmpCard.AddAction("BUTTON 1")	
	' add the card and refresh
	pagecont.Cell(17,1).AddComponent(tmpCard)
	pagecont.cell(17,1).Refresh
	' set this card as the new trigger
	page.RaiseNextContentOnComponent(tmpCard,200)
End Sub


' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition
	If Action = "ABMPage" Then Return
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
