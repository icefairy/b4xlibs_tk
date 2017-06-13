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
	Public Name As String = "CompLabelPage"
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
	theme.AddContainerTheme("white")
	theme.Container("White").BackColor = ABM.COLOR_WHITE
	theme.Container("White").ZDepth = ABM.ZDEPTH_1
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMLabel"
	page.PageDescription = "The label component "	
	page.PageHTMLName = "abmaterial-label.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMLabel", "../images/logo.png", "", "Controls", "ABMLabel")
		
	' create the page grid
	page.AddRows(12,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True		
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add a header label
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Roboto 2.0"))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Labels are the main 'text' objects you can use within ABMaterial. The standard font Material Design uses is Roboto. The font files are included in the framework.") )
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","ABMaterial has 6 heading sizes and 2 special ones: PARAGRAPH and SPAN.  They are the same as in HTML using <h1>, <h2>, <h3>, <h4>, <h5>, <h6>, <p> and <span>.  The size and weight of PARAGRAPH and SPAN is the same as H6, but behave like <p> and <span> tags.  You can find them as constants in ABMMaterial starting with 'SIZE_'.") )
	
	Dim lblH1 As ABMLabel
	lblH1.Initialize(page, "lblH1", "SIZE_H1", ABM.SIZE_H1, False, "")
	page.Cell(2,1).AddComponent(lblH1)
	
	Dim lblH2 As ABMLabel
	lblH2.Initialize(page, "lblH2", "SIZE_H2", ABM.SIZE_H2, False, "")
	page.Cell(2,1).AddComponent(lblH2)
	
	Dim lblH3 As ABMLabel
	lblH3.Initialize(page, "lblH3", "SIZE_H3", ABM.SIZE_H3, False, "")
	page.Cell(2,1).AddComponent(lblH3)
	
	Dim lblH4 As ABMLabel
	lblH4.Initialize(page, "lblH4", "SIZE_H4", ABM.SIZE_H4, False, "")
	page.Cell(2,1).AddComponent(lblH4)
	
	Dim lblH5 As ABMLabel
	lblH5.Initialize(page, "lblH5", "SIZE_H5", ABM.SIZE_H5, False, "")
	page.Cell(2,1).AddComponent(lblH5)
	
	Dim lblH6 As ABMLabel
	lblH6.Initialize(page, "lblH6", "SIZE_H6", ABM.SIZE_H6, False, "")
	page.Cell(2,1).AddComponent(lblH6)
	
	Dim lblPar As ABMLabel
	lblPar.Initialize(page, "lblPar", "SIZE_PARAGRAPH", ABM.SIZE_PARAGRAPH, False, "")
	page.Cell(2,1).AddComponent(lblPar)
	
	Dim lblSpan As ABMLabel
	lblSpan.Initialize(page, "lblSpan", "SIZE_SPAN", ABM.SIZE_SPAN, False, "")
	page.Cell(2,1).AddComponent(lblSpan)
	
	' add a header label
	page.Cell(3,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Blockquotes"))
	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Blockquotes are mainly used to give emphasis to a quote or citation. You can also use these for some extra text hierarchy and emphasis. A little colored block will appear next to the text.") )
	
	Dim lblBlockquote As ABMLabel
	lblBlockquote.Initialize(page, "Blockquote", "This is an example quotation that uses the blockquote setting.{BR}Here is another line to make it look bigger.", ABM.SIZE_SPAN, False, "")
	lblBlockquote.IsBlockQuote = True
	page.Cell(4,1).AddComponent(lblBlockquote)
	
	' add a header label
	page.Cell(5,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Flow Text"))
	
	' create a container with a white background
	Dim cont1 As ABMContainer
	cont1.Initialize(page, "cont1", "white")
	cont1.AddRows(1, True, "").AddCells12(1, "")
	cont1.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	Dim lblTextFlowNo As ABMLabel
	lblTextFlowNo.Initialize(page, "textflowno", "NOT USING TEXTFLOW{BR}{BR}One common flaw we've seen in many frameworks is a lack of support for truly responsive text. While elements on the page resize fluidly, text still resizes on a fixed basis. To ameliorate this problem, for text heavy pages, we've created a property that fluidly scales text size and line-height to optimize readability for the user. Line length stays between 45-80 characters and line height scales to be larger on smaller screens.{BR}{BR}To see Flow Text in action, slowly resize your browser And watch the size of this text body change! Watch the differrence with the text below to see the difference!", ABM.SIZE_SPAN, True, "")
	cont1.Cell(1,1).AddComponent(lblTextFlowNo)
	page.Cell(6,1).AddComponent(cont1)
	
	' create a another container with a white background
	Dim cont2 As ABMContainer
	cont2.Initialize(page, "cont2", "white")
	cont2.AddRows(1, True, "").AddCells12(1, "")
	cont2.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	Dim lblTextFlow As ABMLabel
	lblTextFlow.Initialize(page, "textflow", "USING TEXTFLOW{BR}{BR}One common flaw we've seen in many frameworks is a lack of support for truly responsive text. While elements on the page resize fluidly, text still resizes on a fixed basis. To ameliorate this problem, for text heavy pages, we've created a property that fluidly scales text size and line-height to optimize readability for the user. Line length stays between 45-80 characters and line height scales to be larger on smaller screens.{BR}{BR}To see Flow Text in action, slowly resize your browser And watch the size of this text body change! Watch the differrence with the text below to see the difference!", ABM.SIZE_SPAN, True, "")
	lblTextFlow.IsFlowText = True
	cont2.Cell(1,1).AddComponent(lblTextFlow)
	page.Cell(7,1).AddComponent(cont2)
	
	' add a header label
	page.Cell(8,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Inline Formatting"))
	' add paragraph	
	page.Cell(8,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Labels can have some basic inline formatting using some 'RichtString' codes {B}(Case sensitive!){/B}. Note: They can have to be paired (except the AT, BR and NBSP tags)!") )
	
	' add param table
	Dim Headers, codes, Descriptions As List
	Headers.Initialize2(Array As String("Code", "Description"))
	codes.Initialize2(Array As String("{B} and {/B}", "{I} and {/I}", "{U} and {/U}", "{SUB} and {/SUB}", "{SUP} and {/SUP}", "{BR}", "{NBSP}", "{AL}{AT}{/AL}"))
	Descriptions.Initialize2(Array As String("Bold","Italic", "Underlined", "Subscript", "Superscript", "Line Break", "Non breakable space", "Hyperlink e.g. {AL}http://alwaysbusyscorner.com{AT}Alwaysbusy's Corner{/AL}"))
	page.Cell(9,1).AddComponent(ABMShared.BuildParamTable(page, "param1", Headers, codes, Descriptions))
	
	' add a header label
	page.Cell(10,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Truncate"))
	' add paragraph	
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Labels can be truncated if they do not fit.  Three dot (...) are added to show there is more.") )
	
	Dim lblTruncate As ABMLabel
	lblTruncate.Initialize(page, "truncate", "This text will be truncated if it does not fit on one line anymore instead of wrapping. Resize the browser window to see this effect.", ABM.SIZE_SPAN, False, "")
	lblTruncate.Truncate = True
	page.Cell(11,1).AddComponent(lblTruncate)
	
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
	If Action = "ABMLabel" Then Return
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
