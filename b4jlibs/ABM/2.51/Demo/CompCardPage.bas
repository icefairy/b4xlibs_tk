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
	Public Name As String = "CompCardPage"
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
	
	' card themes
	theme.AddCardTheme("basiccard")
	theme.Card("basiccard").BackColor = ABM.COLOR_BLUEGREY
	theme.Card("basiccard").TitleForeColor = ABM.COLOR_WHITE
	theme.Card("basiccard").ContentForeColor = ABM.COLOR_WHITE
	theme.Card("basiccard").ActionForeColor = ABM.COLOR_ORANGE
	
	theme.AddCardTheme("whitetitle")
	theme.Card("whitetitle").TitleForeColor = ABM.COLOR_WHITE
	
	theme.AddCardTheme("redpanel")
	theme.Card("redpanel").ContentForeColor = ABM.COLOR_WHITE
	theme.Card("redpanel").BackColor = ABM.COLOR_RED
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMCard"
	page.PageDescription = "The card component "	
	page.PageHTMLName = "abmaterial-card.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
	
	ABMShared.BuildNavigationBar(page, "ABMCard", "../images/logo.png", "", "Controls", "ABMCard")
		
	' create the page grid
	page.AddRows(1,True, "").AddCells12(1,"")	
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,6,6,"")	
	page.AddRows(2,True, "").AddCells12(1,"")	
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,7,7,"")
	page.AddRows(2,True, "").AddCells12(1,"")		
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,7,7,"")
	page.AddRows(2,True, "").AddCells12(1,"")			
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,6,6,"")	
	page.AddRows(1,True, "").AddCells12(1,"")		
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,7,7,"")	
	page.AddRows(1,True, "").AddCells12(1,"")		
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,8,8,"")	
	page.AddRows(1,True, "").AddCells12(1,"")		
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,6,6,"")	
	page.AddRows(1,True, "").AddCells12(1,"")		
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Cards are a convenient means of displaying content composed of different types of objects. They’re also well-suited for presenting similar objects whose size or supported actions can vary considerably, like photos with captions of variable length.") )
	
	' add a header label
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Basic Card"))
	
	' basic card
	Dim card1 As ABMCard
	card1.InitializeAsCard(page, "card1", "Card Title", "I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.", ABM.CARD_NOTSPECIFIED,"basiccard")
	card1.AddAction("BUTTON 1")
	card1.AddAction("BUTTON 2")
	page.Cell(2,1).AddComponent(card1)
		
	' add codeblock	
	Dim code As StringBuilder
	code.Initialize
	code.Append("Dim card1 As ABMCard").Append(CRLF)
	code.Append("card1.InitializeAsCard(page, ""card1"", ""Card Title"", ""I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively."", ABM.CARD_NOTSPECIFIED,""basiccard"")").Append(CRLF)
	code.Append("card1.AddAction(""BUTTON 1"")").Append(CRLF)
	code.Append("card1.AddAction(""BUTTON 2"")").Append(CRLF)
	code.Append("page.Cell(2,1).AddComponent(card1)").Append(CRLF)
	
	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlock(page, "code", code))
	
	' add a header label
	page.Cell(4,1).AddComponent(ABMShared.BuildHeader(page,"hdr2", "Image Card"))
	
	' add paragraph	
	page.Cell(4,1).AddComponent(ABMShared.BuildParagraph(page,"par2","Here is the standard card with an image thumbnail.") )
	
	' image card
	Dim card2 As ABMCard
	card2.InitializeAsCard(page, "card2", "{I}Card Title{/I}", "I am a very {B}simple{/B} card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.", ABM.CARD_NOTSPECIFIED,"whitetitle")
	card2.Image = "../images/sample-1.jpg"
	card2.AddAction("BUTTON 1")
	page.Cell(5,1).AddComponent(card2)
	
	' add codeblock	
	Dim code2 As StringBuilder
	code2.Initialize
	code2.Append("Dim card2 As ABMCard").Append(CRLF)
	code2.Append("card2.InitializeAsCard(page, ""card2"", ""Card Title"", ""I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively."", ABM.CARD_NOTSPECIFIED,""whitetitle"")").Append(CRLF)
	code2.Append("card2.Image = ""../images/sample-1.jpg""").Append(CRLF)
	code2.Append("card2.AddAction(""BUTTON 1"")").Append(CRLF)
	code2.Append("page.Cell(5,1).AddComponent(card2)").Append(CRLF)
	
	page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlock(page, "code2", code2))
	
	' add a header label
	page.Cell(7,1).AddComponent(ABMShared.BuildHeader(page,"hdr3", "Card Reveal"))
	
	' add paragraph	
	page.Cell(7,1).AddComponent(ABMShared.BuildParagraph(page,"par3","Here you can add a card that reveals more information once clicked. Just add the line .IsReveal = true.") )
	
	' image card
	Dim card3 As ABMCard
	card3.InitializeAsCard(page, "card3", "{I}Card Title{/I}", "I am a very {B}simple{/B} card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.", ABM.CARD_NOTSPECIFIED,"")
	card3.Image = "../images/sample-2.jpg"
	card3.IsReveal = True
	card3.AddAction("BUTTON 1")
	page.Cell(8,1).AddComponent(card3)
	
	' add codeblock	
	Dim code3 As StringBuilder
	code3.Initialize
	code3.Append("Dim card3 As ABMCard").Append(CRLF)
	code3.Append("card3.InitializeAsCard(page, ""card3"", ""Card Title"", ""I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively."", ABM.CARD_NOTSPECIFIED,"""")").Append(CRLF)
	code3.Append("card3.Image = ""../images/sample-1.jpg""").Append(CRLF)
	code3.Append("card3.IsReveal = True").Append(CRLF)
	code3.Append("card2.AddAction(""BUTTON 1"")").Append(CRLF)
	code3.Append("page.Cell(8,1).AddComponent(card3)").Append(CRLF)
	
	page.Cell(9,1).AddComponent(ABMShared.BuildCodeBlock(page, "code3", code3))
	
	' add a header label
	page.Cell(10,1).AddComponent(ABMShared.BuildHeader(page,"hdr3b", "Card Sizes"))
	
	' add paragraph	
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page,"par3b","If you want to have uniformly sized cards, you can use our premade size types. Just add the size type in the Initialize method. The width is not affected by this parameter but is determined by your cell size.") )
	
	' add a sub header label
	page.Cell(10,1).AddComponent(ABMShared.BuildSubHeader(page,"hdr4b", "CARD_SMALL"))
	
	' add paragraph	
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page,"par4b","The Small Card limits the height of the card to 300px.") )
	
	' image card
	Dim card4 As ABMCard
	card4.InitializeAsCard(page, "card4", "Small", "Note: Because I have a fixed height, my text may not fit!", ABM.CARD_SMALL,"whitetitle")
	card4.Image = "../images/sample-1.jpg"
	card4.AddAction("BUTTON 1")
	card4.AddAction("BUTTON 2")
	page.Cell(11,1).AddComponent(card4)
	
	' add a sub header label
	page.Cell(12,1).AddComponent(ABMShared.BuildSubHeader(page,"hdr5", "CARD_MEDIUM"))
	
	' add paragraph	
	page.Cell(12,1).AddComponent(ABMShared.BuildParagraph(page,"par5","The Medium Card limits the height of the card to 400px.") )
	
	' image card
	Dim card5 As ABMCard
	card5.InitializeAsCard(page, "card5", "Medium", "Note: Because I have a fixed height, my text may not fit!", ABM.CARD_MEDIUM,"whitetitle")
	card5.Image = "../images/sample-1.jpg"
	card5.AddAction("BUTTON 1")
	card5.AddAction("BUTTON 2")
	page.Cell(13,1).AddComponent(card5)
	
	' add a sub header label
	page.Cell(14,1).AddComponent(ABMShared.BuildSubHeader(page,"hdr6", "CARD_LARGE"))
	
	' add paragraph	
	page.Cell(14,1).AddComponent(ABMShared.BuildParagraph(page,"par6","The Large Card limits the height of the card to 500px.") )
	
	' image card
	Dim card6 As ABMCard
	card6.InitializeAsCard(page, "card6", "Large", "Note: Because I have a fixed height, my text may not fit!", ABM.CARD_LARGE,"whitetitle")
	card6.Image = "../images/sample-1.jpg"
	card6.AddAction("BUTTON 1")
	card6.AddAction("BUTTON 2")
	page.Cell(15,1).AddComponent(card6)
	
	' add a header label
	page.Cell(16,1).AddComponent(ABMShared.BuildHeader(page,"hdr7", "Card Panel"))
	
	' add paragraph	
	page.Cell(16,1).AddComponent(ABMShared.BuildParagraph(page,"par7","For a simpler card with less markup, try using a card panel which just has padding and a shadow effect") )
	
	' image card
	Dim card7 As ABMCard
	card7.InitializeAsPanel(page, "card7", "I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively. I am similar to what is called a panel in other frameworks." ,"redpanel")
	page.Cell(17,1).AddComponent(card7)
	
	' add codeblock	
	Dim code4 As StringBuilder
	code4.Initialize
	code4.Append("Dim card4 As ABMCard").Append(CRLF)
	code4.Append("card7.InitializeAsPanel(page, ""card7"", ""I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively. I am similar to what is called a panel in other frameworks."" ,""redpanel""))").Append(CRLF)
	code4.Append("page.Cell(17,1).AddComponent(card7)").Append(CRLF)
	
	page.Cell(18,1).AddComponent(ABMShared.BuildCodeBlock(page, "code4", code4))
	
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
	If Action = "ABMCard" Then Return
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

Sub card1_LinkClicked(Card As String, Action As String)
	myToastId = myToastId + 1
	page.ShowToast("toast" & myToastId, "toastred", "Clicked on " & Action & "!", 5000)
End Sub

' example of containers in containers (question of Gabino)

''Class module
'Sub Class_Globals
'	Private ws As WebSocket 'ignore
'	' will hold our page information
'	Public page As ABMPage
'	' page theme
'	Private theme As ABMTheme
'	' to access the constants
'	Private ABM As ABMaterial 'ignore	
'	' name of the page, must be the same as the class name (case sensitive!)
'	Public Name As String = "CompCardPage"
'   will hold the unique browsers window id
'	Private ABMPageId As String = ""
'	
'	' your own variables
'	
'	Dim MyToastId As Int
'	
'	Dim NColumnas As Int = 1
'	Dim Pasada As Int = 1
'	Dim NRegistros As Int = 0
'	
'End Sub
'
''Initializes the object. You can add parameters to this method if needed.
'Public Sub Initialize
'	' build the local structure IMPORTANT!
'	BuildPage
'End Sub
'
'Private Sub WebSocket_Connected (WebSocket1 As WebSocket)
'   Log("Connected")
'	ws = WebSocket1	
'	ABMPageId = ABM.GetPageID(page, Name,ws)
'	Dim session As HttpSession = ABM.GetSession(ws, ABMShared.SessionMaxInactiveIntervalSeconds)
'	
'	If ABMShared.NeedsAuthorization Then
'		If session.GetAttribute2("IsAuthorized", "") = "" Then
'			ABMShared.NavigateToPage(ws, ABMPageId, "../")
'			Return
'		End If
'	End If		
'	
'	ABM.UpdateFromCache(Me, ABMShared.CachedPages, ABMPageId, ws)
'	If page.ComesFromPageCache Then
'		' refresh the page
'		page.Refresh
'		' because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
'		page.FinishedLoading
'	Else
'		' Prepare the page 
'		page.Prepare
'		' load the dynamic content
'		ConnectPage
'	End If
'	Log(ABMPageId)
'End Sub
'
'Private Sub WebSocket_Disconnected
'	Log("Disconnected")
'End Sub
'
'Sub Page_ParseEvent(Params As Map) 
'	Dim eventName As String = Params.Get("eventname")
'	Dim eventParams() As String = Regex.Split(",",Params.Get("eventparams"))
'	If eventName = "beforeunload" Then
'		Log("preparing for url refresh")	
'		ABM.RemoveMeFromCache(ABMShared.CachedPages, ABMPageId)	
'		Return
'	End If
'	If SubExists(Me, eventName) Then
'		Params.Remove("eventname")
'		Params.Remove("eventparams")
'		Select Case Params.Size
'			Case 0
'				CallSub(Me, eventName)
'			Case 1
'				CallSub2(Me, eventName, Params.Get(eventParams(0)))					
'			Case 2
'				If Params.get(eventParams(0)) = "abmistable" Then
'					Dim PassedTables As List = ABM.ProcessTablesFromTargetName(Params.get(eventParams(1)))
'					CallSub2(Me, eventName, PassedTables)
'				Else
'					CallSub3(Me, eventName, Params.Get(eventParams(0)), Params.Get(eventParams(1)))
'				End If
'			Case Else
'				' cannot be called directly, to many param
'				CallSub2(Me, eventName, Params)				
'		End Select
'	End If
'End Sub
'
'public Sub BuildTheme()
'	' start with the base theme defined in ABMShared
'	theme.Initialize("pagetheme")
'	theme.AddABMTheme(ABMShared.MyTheme)
'	
'	' add additional themes specific for this page
'	
'End Sub
'
'public Sub BuildPage()
'	' initialize the theme
'	BuildTheme
'	
'	' Para que muestre las cuadrículas
'	' page.ShowGridInfo = True
'	
'	' initialize this page using our theme
'	page.InitializeWithTheme(Name, "/ws/" & AppName & "/" & Name, False, theme)
'	page.ShowLoader=True
'	page.PageTitle = "ABMCard"
'	page.PageDescription = "The card component "	
'	page.PageHTMLName = "abmaterial-card.html"
'	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
'	page.PageSiteMapPriority = "0.50"
'	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
'	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
'	page.NeedsCards=True
'	
'	ABMShared.BuildNavigationBar(page, "ABMCard", "../images/logo.png", "", "Controls", "ABMCard")		
'	
'	' create the page grid
'	page.AddRows(2,True, "").AddCells12(1,"")
'	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
'	
'	' add paragraph	
'	page.Cell(1,1).AddComponent(ABMShared.BuildParagraphBQ(page,"par1b", "Visualiza fácilmente los artículos de tu almacén {B}filtrando{/B} por los campos principales.") )
'
'	Dim BtnPulsado As ABMButton
'	BtnPulsado.InitializeRaised(page, "BtnPulsado", "mdi-av-interested", "left", "Pulsar", "bluegrey")
'	page.Cell(1,1).AddComponent(BtnPulsado)
'	
'	Dim Cont1 As ABMContainer
'	Cont1.Initialize(page, "Cont1", "")
'	Cont1.AddRows(1, True, "").AddCellsOS(1,0,0,0,12,12,12,"")	
'	Cont1.BuildGrid ' IMPORTANT
'	page.Cell(2,1).AddComponent(Cont1)
'	
'End Sub
'
'' clicked on the navigation bar
'Sub Page_NavigationbarClicked(Action As String, Value As String)
'	page.SaveNavigationBarPosition
'	If Action = "Pruebas" Then Return
'	If Action = "Contact" Then	
'		MyToastId = MyToastId + 1	
'		page.ShowToast("toast" & MyToastId, "toastred", "Hola!", 5000)
'		Return
'	End If
'	ABMShared.NavigateToPage(ws, Value)
'End Sub
'	
'	
'Sub BtnPulsado_Clicked(ItemId As String)	
'	Dim ContAux As ABMContainer
'	Dim Cont1 As ABMContainer
'	If MyToastId = 0 Then
'		Cont1 = page.Component("Cont1")
'		ContAux.Initialize(page, "ContAux" & Pasada, "")
'		ContAux.AddRowsM(1, True, 0, 0, "").AddCellsOS(NColumnas, 0, 0, 0, 12/NColumnas, 12/NColumnas, 12/NColumnas, "")
'		ContAux.BuildGrid
'		Cont1.Cell(1,1).AddComponent(ContAux)
'	Else
'		Cont1 = page.Component("Cont1")
'		ContAux = Cont1.Component("ContAux" & Pasada)			
'	End If
'	
'	MyToastId = MyToastId + 1
'	NRegistros = NRegistros + 1
'		
'	ws.Session.SetAttribute("UnidadesEnCarrito", NRegistros)
'
'	' add a new container ContWithCard (with card, button and texts) to the container contAux
'	' note we use AddComponent, so we can give it a full name: "ContWithCard" & NRegistros
'	ContAux.Cell(1, MyToastId).AddComponent(BuildContainerWithCard("ContWithCard" & NRegistros))
'	
'	' this refresh should be sufficient
'	Cont1.Refresh
'	If MyToastId = NColumnas Then 
'		MyToastId = 0
'		Pasada = Pasada + 1
'		
'		If Pasada = 5 Then Pasada = 6 
'		If Pasada = 7 Then Pasada = 12
'		NColumnas = Pasada
'	End If
'End Sub
'
'Sub BuildContainerWithCard(id As String) As ABMContainer
'	Dim ContainerAux As ABMContainer
'	ContainerAux.Initialize(page, id, "")
'	ContainerAux.AddRows(1, True, "").AddCellsOS(1,0,0,0,11,11,11,"").AddCellsOS(1,0,0,0,1,1,1,"")
'	ContainerAux.AddRows(3, True, "").AddCellsOS(3,0,0,0,4,4,4,"")
'	ContainerAux.BuildGrid
'	
'	' We want to get the events of the card in one method as an array: Card_LinkClicked() so we use AddArrayComponent
'	' Note if we use AddArrayComponent, we do not use a prefix for the 'id', just NRegistros
'	' In the Card_LinkClicked(card,action) event we will receive Card + NRegistros in the card Param so we know on what has been clicked.
'	ContainerAux.Cell(1,1).AddArrayComponent(BuildCard(NRegistros,  "../images/list1.jpg", "Card" & NRegistros), "Card")
'	
'	Dim BtnTarjeta As ABMButton
'	BtnTarjeta.InitializeFloating(page, NRegistros, "mdi-image-exposure-plus-1", "darkred") 
'	' We want to get the events of the button in one method as an array: "BtnTarjeta_Clicked() so we use AddArrayComponent
'	' Note if we use AddArrayComponent, we do not use a prefix for the 'id', just NRegistros
'	' In the BtnTarjeta_Clicked(Target) event we will receive BtnTarjeta + NRegistros in the Target Param so we know on what has been clicked.
'	ContainerAux.Cell(1, 2).AddArrayComponent(BtnTarjeta, "BtnTarjeta")
'	
'	' just in case we want to change the texts later, I've added them also with AddArrayComponent so they are unique for sure.
'	ContainerAux.Cell(2, 1).AddArrayComponent(ABMShared.BuildParagraph(page, NRegistros, "{B}" & id & "{/B}"), "par1_")
'	ContainerAux.Cell(2, 2).AddArrayComponent(ABMShared.BuildParagraph(page, NRegistros, "{B}Stock:{/B}" & id & " {B}Art.{/B}"&id), "par2_")
'	ContainerAux.Cell(2, 3).AddArrayComponent(ABMShared.BuildParagraph(page, NRegistros, "{B}St.{/B}" & id), "par3_")
'	
'	Return ContainerAux	
'End Sub
'
'Sub BuildCard(id As String, image As String, title As String) As ABMCard
'	' image card
'	Dim card4 As ABMCard
'	card4.InitializeAsCard(page, id, title, "", ABM.CARD_NOTSPECIFIED,"whitetitle")
'	card4.Image = image
'	card4.AddAction("-")
'	Return card4
'End Sub	
'
'' card was added as an array component, so we need just prefix_LinkClicked
'Sub card_LinkClicked(Card As String, Action As String)
'	Log(Card & " " & Action) ' we get something like card1, card2, card3...	 in the card param
'End Sub
'
'' btntarjeta was added as an array component, so we need just prefix_Clicked
'Sub btntarjeta_clicked(Target As String)
'	Log(Target)  ' we get something like btntarjeta1, btntarjeta2, btntarjeta3...	 in the target param
'End Sub
'	
'Sub Page_FileUploaded(FileName As String, success As Boolean)	
'	
'End Sub
'
'Sub Page_ToastClicked(ToastId As String, Action As String)
'		
'End Sub
'
'Sub Page_ToastDismissed(ToastId As String)	
'	
'End Sub



