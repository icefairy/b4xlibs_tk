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
	Public Name As String = "CompActionButtonPage"
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
	theme.AddButtonTheme("bigblue")
	theme.Button("bigblue").BackColor = ABM.COLOR_LIGHTBLUE
	
	theme.AddButtonTheme("sub1")
	theme.Button("sub1").BackColor = ABM.COLOR_RED
	
	theme.AddButtonTheme("sub2")
	theme.Button("sub2").BackColor = ABM.COLOR_GREEN
	
	theme.AddButtonTheme("sub3")
	theme.Button("sub3").BackColor = ABM.COLOR_YELLOW
	
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
	page.PageTitle = "ABMActionButton"
	page.PageDescription = "The action button component "	
	page.PageHTMLName = "abmaterial-action-button.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMActionButton", "../images/logo.png", "", "Controls", "ABMActionButton")
	
	' create the page grid
	page.AddRows(3,True, "").AddCells12(1,"")
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,8,6,"")
	page.AddRows(1,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True
			
	ABMShared.BuildFooter(page)
End Sub

public Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	Dim acb1 As ABMActionButton
	acb1.Initialize(page, "acb1", "mdi-action-shop", "", "bigblue")
	acb1.MainButton.size = ABM.BUTTONSIZE_LARGE
	
	' the sub buttons
	Dim btn1 As ABMButton
	btn1.InitializeFloating(page, "btn1", "mdi-social-share", "sub1")
	acb1.AddMenuButton(btn1)
	Dim btn2 As ABMButton
	btn2.InitializeFloating(page, "btn2", "mdi-social-whatshot", "sub2")
	acb1.AddMenuButton(btn2)
	Dim btn3 As ABMButton
	btn3.InitializeFloating(page, "btn3", "mdi-social-notifications", "sub3")
	acb1.AddMenuButton(btn3)
	
	' add to page
	page.AddActionButton(acb1)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Action buttons are buttons that can open a sub menu of buttons. They are generaly used on page level, but they can also be set at cell level.") )
	' add a header label
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Page Level"))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","The big blue button on the bottom right is an example of a page ActionButton.") )
	
	' code block
	Dim code As StringBuilder
	code.Initialize
	code.Append("// create the action button").Append(CRLF)
	code.Append("Dim acb1 As ABMActionButton").Append(CRLF)
	code.Append("acb1.Initialize(page, ""acb1"", ""mdi-action-shop"", "", ""bigblue"")").Append(CRLF)
	code.Append("acb1.MainButton.size = ABM.BUTTONSIZE_LARGE").Append(CRLF)
	code.Append("").Append(CRLF)
	code.Append("// the sub buttons").Append(CRLF)
	code.Append("Dim btn1 As ABMButton").Append(CRLF)
	code.Append("btn1.InitializeFloating(page, ""btn1"", ""mdi-social-share"", ""sub1"")").Append(CRLF)
	code.Append("acb1.AddMenuButton(btn1)").Append(CRLF)
	code.Append("Dim btn2 As ABMButton").Append(CRLF)
	code.Append("btn2.InitializeFloating(page, ""btn2"", ""mdi-social-whatshot"", ""sub2"")").Append(CRLF)
	code.Append("acb1.AddMenuButton(btn2)").Append(CRLF)
	code.Append("Dim btn3 As ABMButton").Append(CRLF)
	code.Append("btn3.InitializeFloating(page, ""btn3"", ""mdi-social-notifications"", ""sub3"")").Append(CRLF)
	code.Append("acb1.AddMenuButton(btn3)").Append(CRLF)
	code.Append("").Append(CRLF)
	code.Append("// add To page").Append(CRLF)
	code.Append("page.AddActionButton(acb1)").Append(CRLF)
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlock(page, "code", code))
	
	' add a header label
	page.Cell(3,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Cell Level"))
	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par2","You can also add an action button to a cell.") )
	
	' image card
	Dim card2 As ABMCard
	card2.InitializeAsCard(page, "card2", "Card Title", "I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.", ABM.CARD_NOTSPECIFIED,"whitetitle")
	card2.Image = "../images/sample-1.jpg"
	card2.AddAction("BUTTON 1")
	page.Cell(4,1).AddComponent(card2)
	
	' create the action button
	Dim acb2 As ABMActionButton
	acb2.Initialize(page, "acb2", "mdi-action-shop", "", "sub1")
			
	' the sub buttons	
	Dim btn4 As ABMButton
	btn4.InitializeFloating(page, "btn4", "mdi-social-whatshot", "sub2")
	acb2.AddMenuButton(btn4)
	Dim btn5 As ABMButton
	btn5.InitializeFloating(page, "btn5", "mdi-social-notifications", "sub3")
	acb2.AddMenuButton(btn5)	
	
	' add to cell
	page.Cell(4,1).AddComponent(acb2)
	
	' add paragraph	
	page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par3","The only difference with the page ActionButton is we've added it to the cell as a normal control.") )
	
	' code block
	Dim code2 As StringBuilder
	code2.Initialize
	code2.Append("acb2.Initialize(page, ""acb2"", ""mdi-action-shop"", ""sub1"")").Append(CRLF)
	code2.Append("...").Append(CRLF)
	code2.Append("page.AddComponent(4,1, acb2)").Append(CRLF)
	
	page.Cell(5,1).AddComponent(ABMShared.BuildCodeBlock(page, "code2", code2))
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT!
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMActionButton" Then Return
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

Sub acb1_Clicked(Target As String, SubTarget As String)
	If SubTarget="" Then 
		Log("clicked main button")
		Return
	End If
	Dim myTexts, myReturns As List
	myTexts.Initialize
	myReturns.Initialize
	myToastId = myToastId + 1
	page.ShowToast("toast" & myToastId, "toastred", "Clicked on " & SubTarget, 5000)
	Return
End Sub

Sub acb2_Clicked(Target As String, SubTarget As String)
	If SubTarget="" Then 
		Log("clicked main button")
		Return
	End If
	Dim myTexts, myReturns As List
	myTexts.Initialize
	myReturns.Initialize
	myToastId = myToastId + 1
	page.ShowToast("toast" & myToastId, "toastred", "Clicked on " & SubTarget, 5000)
	Return
End Sub