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
	Public Name As String = "TestPage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables

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
	
	theme.AddContainerTheme("menu")
	theme.Container("menu").BackColor = ABM.COLOR_TEAL
	theme.Container("menu").BackColorIntensity = ABM.INTENSITY_ACCENT3
	
	theme.AddLabelTheme("white")
	theme.Label("white").ForeColor = ABM.COLOR_WHITE
	
	' add additional themes specific for this page
	theme.AddButtonTheme("bigblue")
	theme.Button("bigblue").BackColor = ABM.COLOR_LIGHTBLUE
	
	theme.AddButtonTheme("sub1")
	theme.Button("sub1").BackColor = ABM.COLOR_RED
	
	theme.AddButtonTheme("sub2")
	theme.Button("sub2").BackColor = ABM.COLOR_GREEN
	
	theme.AddButtonTheme("sub3")
	theme.Button("sub3").BackColor = ABM.COLOR_YELLOW
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
	page.PageHTMLName = "index.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY	
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
			
	' create the page grid
	page.AddRows(3,True, "").AddCells12(1,"")	
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	
	
	Dim table As ABMTable
	table.Initialize(page,"table",True,False,True,"")
	table.SetHeaders(Array As String("song"))

	Dim player As ABMAudioPlayer
	player.Initialize(page,"player",True,False,False,"")

	Dim list As List
	list.Initialize
	list.Add(player)

	Dim song As ABMAudioPlayerSong
	song.Initialize("../Audio/01 (Open) 00 00.mp3")
	player.LoadSingleSong(song)

	table.AddRow("tb",list)
	
	page.Cell(1,1).AddComponent(table)	
	
	' create a floating container MUST be added in BuildPage!
	Dim floatingcont1 As ABMContainer
	floatingcont1.Initialize(page, "floatingcont1", "")
	floatingcont1.AddRowsM(1,False,0,0, "").AddCellsOSMP(1,0,0,0,12,12,12,0,0,0,0,"")
	floatingcont1.BuildGrid ' IMPORTANT
	page.AddFloatingContainer(floatingcont1, ABM.FLOATING_FROMTOP, "0px")
	
	Dim floatingcont2 As ABMContainer
	floatingcont2.Initialize(page, "floatingcont2", "")
	floatingcont2.AddRowsM(1,False,0,0, "").AddCellsOSMP(1,0,0,0,12,12,12,0,0,0,0,"")
	floatingcont2.BuildGrid ' IMPORTANT
	page.AddFloatingContainerHideOnScroll(floatingcont2, ABM.FLOATING_FROMBOTTOM, "110px",0.2,1.0)
	
	ABMShared.BuildFooterFixed(page)
End Sub

public Sub ConnectPage()
	' get the floating container
	Dim floatingcont1 As ABMContainer
	floatingcont1 = page.FloatingContainer("floatingcont1")

	' create menu container
	Dim cont2 As ABMContainer
	cont2.Initialize(page, "cont2", "menu")
	cont2.AddRows(1,False,"").AddCellsOS(1,0,0,0,6,2,1,"").AddCellsOS(1,0,0,0,1,7,9,"").AddCellsOS(1,0,0,0,5,3,2,"")
	cont2.BuildGrid	
	
	cont2.Cell(1,1).MarginLeft = "6px"
	cont2.Cell(1,1).Margintop = "6px"
	
	cont2.Cell(1,2).MarginLeft = "-6px"	' to compensate for the +5px in cell 1
	
	cont2.Cell(1,3).Margintop = "16px"

	Dim img As ABMImage
	img.Initialize(page, "img", "../images/paulo.png",1)
	cont2.Cell(1,1).AddComponent(img)
	
	Dim lbl As ABMLabel
	lbl.Initialize(page, "lbl", "{NBSP}{I}Paulo Gomez{/I}", ABM.SIZE_H4, False, "white")
	lbl.Visibility = ABM.VISIBILITY_HIDE_ON_SMALL_ONLY
	cont2.Cell(1,2).AddComponent(lbl)
	
	Dim img2 As ABMImage
	img2.Initialize(page, "img2", "../images/france_round_256.png",1)
	img2.SetFixedSize(48,36)
	cont2.Cell(1,3).AddComponent(img2)
	
	Dim img3 As ABMImage
	img3.Initialize(page, "img3", "../images/united_kingdom_round_icon_256.png",1)
	img3.SetFixedSize(48,36)
	cont2.Cell(1,3).AddComponent(img3)
	
	Dim img4 As ABMImage
	img4.Initialize(page, "img4", "../images/hungary_round_icon_256.png",1)
	img4.SetFixedSize(48,36)
	cont2.Cell(1,3).AddComponent(img4)
	
	' add it to the floating container
	floatingcont1.Cell(1,1).AddComponent(cont2)
	
	page.Cell(1,1).PaddingTop = "50px"
		
	Dim biglabel As ABMLabel
	biglabel.Initialize(page, "biglabel", ABM.Util.paragraphs(50,True), ABM.SIZE_PARAGRAPH, True, "")
	page.Cell(2,1).AddComponent(biglabel)
	
	Dim floatingcont2 As ABMContainer
	floatingcont2 = page.FloatingContainer("floatingcont2")

	Dim cont3 As ABMContainer
	cont3.Initialize(page, "cont3", "")
	cont3.AddRows(1,False,"").AddCellsOS(1,10,10,10,2,2,2,"")
	cont3.BuildGrid	
	
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
	
	' add to cell
	cont3.Cell(1,1).AddComponent(acb1)
	
	' add it to the floating container
	floatingcont2.Cell(1,1).AddComponent(cont3)
				
	' also add the components to the footer
	ABMShared.ConnectFooterFixed(page)
	
	page.Refresh ' IMPORTANT!
		
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT	
	
	page.RestoreNavigationBarPosition
	
'	Dim script As String = $"$("body").animate({ scrollTop: $('#${img.ID}').offset().top }, 1000);"$
'	page.ws.Eval(script, Null)
'	page.ws.Flush
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition		
	
	ABMShared.NavigateToPage(ws, ABMPageId, Value)
End Sub

Sub Page_SignedOffSocialNetwork(Network As String, Extra As String)
	page.ws.Session.SetAttribute("authType", "")
	page.ws.Session.SetAttribute("authName", "")
	page.ws.Session.SetAttribute("IsAuthorized", "")			
	ABMShared.NavigateToPage(ws, ABMPageId, "../")
End Sub

