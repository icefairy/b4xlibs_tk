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
	Public Name As String = "CompSVGSurfacePage"
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
	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMSVGSurface"
	page.PageDescription = "The SVG component "	
	page.PageHTMLName = "abmaterial-svgsurface.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMSVGSurface", "../images/logo.png", "", "Controls", "ABMSVGSurface")
		
	' create the page grid
	page.AddRows(9,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","ABMSVGSurface and ABMSVGElement make it possible to make interactive and animated SVG images. This can be useful to build custom lightweight graphics like charts that do not need the full ABMChart library.") )	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","{B}Note{/B}: although the attribute strings look very much like CSS, they are not. Check out {AL}https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute{AT}https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute{/AL} For more info."))	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par3","Here are some examples of such SVG components. E.g. an animated bar chart:"))	
	
	
	
	' build some values
	Dim values As List
	values.initialize
	For i = 1 To 10		
		Dim value As Double = Rnd(20,100)
		values.Add(value)
	Next
	For i = 1 To 10		
		Dim value As Double = values.Get(i-1)
		AddBarRow(2, "per" & i, "Person " & i, value, 75, (value < 40))
	Next	
	
	' add codeblock	
	Dim code1 As String = $"Sub AddBarRow(PageRow As Int, id As String, Text As String, perc As Double, WeekToDoPerc As Double, IsBad As Boolean)
	Dim cnt As ABMContainer
	cnt.Initialize(page , "cnt_" & id, "")
	
	cnt.AddRowsM(1, False,0,0,"").AddCellsOSMP(1,0,0,0,12,6,6,0,0,10,10,"").AddCellsOSMP(1,0,0,0,12,6,6,0,0,10,10,"")
	cnt.BuildGrid
	
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, "lbl1_" & id, Text, ABM.SIZE_H6, True, "")
		
	cnt.Cell(1,1).AddComponent(lbl1)
	
	// make sure the container is added BEFORE adding an SVGsurface
	page.Cell(PageRow,1).AddComponent(cnt)
	
	Dim svg As ABMSVGSurface
	svg.Initialize(page, "svg_" & id, "0 0 400 50", "none", "400px", "50px")
	cnt.Cell(1,2).AddComponent(svg)
	cnt.Cell(1,2).MarginBottom = "-28px"
		
	Dim rect1 As ABMSVGElement = svg.Rect("rect" & id, 0,0,perc*4,50,0,0)
		
	If perc >= WeekToDoPerc Then
		rect1.SetAttributes("{fill: '#e6ee9c'}")
	Else
		rect1.SetAttributes("{fill: '#ffcc80'}")
		If perc < (WeekToDoPerc - 10) Then
			rect1.AddAnimationContinuousRun("{fill: '#e65100'}", 1500, "", "{fill: '#ffcc80'}", 500, "")
		End If
	End If
	
	Dim line2 As ABMSVGElement = svg.Line("line2_" & id, WeekToDoPerc*4,0,WeekToDoPerc*4,50)
	line2.SetAttributes("{fill: '#b71c1c', stroke: '#b71c1c', strokeWidth: 1}")	
End Sub"$
		
	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code1))
	
	' add paragraph	
	page.Cell(4,1).AddComponent(ABMShared.BuildParagraph(page,"par3","An interactive Pie chart (hover to see the effect, click on the Pie part see interactivity)."))	
	
	For i = 1 To 10
		Dim perc As Double = Rnd(10, 100)
		AddPieRow(5, i, "Pie in row " & i, perc)
		
	Next
		
	Dim code2 As String = $"Sub AddPieRow(RowNum As Int, id As Int, text2 As String, perc As Double)
	Dim cnt As ABMContainer
	cnt.Initialize(page , "pcnt_" & id, "")
	
	cnt.AddRowsM(1, False,0,0,"").AddCellsOS(1,0,0,0,4,4,4,"").AddCellsOS(1,0,0,0,8,8,8,"")
	cnt.BuildGrid
	
	Dim cnt2 As ABMContainer
	cnt2.Initialize(page , "pcnt2_" & id, "")
	
	cnt2.AddRowsM(1, False,0,0,"").AddCellsOSMP(1, 0,0,0,12,12,12,0,0,0,0,"")
	cnt2.BuildGrid	
	
	Dim lbl2 As ABMLabel
	lbl2.Initialize(page, "plbl2_" & id, text2, ABM.SIZE_H6, True, "")	

	cnt.cell(1,1).addcomponent(cnt2)
	cnt.Cell(1,2).AddComponent(lbl2)
	
	page.Cell(RowNum,1).AddComponent(cnt)
	
	Dim svg As ABMSVGSurface
	svg.Initialize(page, id, "0 0 80 80", "none", "80px", "80px")
	cnt.Cell(1,1).AddArrayComponent(svg, "psvg")
	cnt.Cell(1,1).MarginBottom = "-20px"
		
	Dim cir1 As ABMSVGElement = svg.circle("pcir" & id, 40,40,30)
	cir1.SetAttributes("{fill: '#e6ee9c'}")

	Dim pie1 As ABMSVGElement = svg.Pie("ppie" & id, 40,40,0,30, -90, 0)
	
	Dim pie1Group As ABMSVGElement = svg.Group("ppie" & id & "Group", Array As String("ppie" & id))  ' <- Needed for the pointer cursor, can only be set to a group
	pie1Group.SetAttributes("{cursor: 'pointer'}")
	
	pie1.SetAttributes("{fill: '#ffcc80'}")
	Dim EndVal As Int = (360*perc/100)-90
	pie1.AddHoverINAnimation("{r2: 40}",250,"")
	pie1.AddHoverOUTAnimation("{r2: 30}",250,"")
	//pie1.AddAnimationContinuousRun("{start: -90, end: " & EndVal & "}", 3000, "mina.bounce", "{start: -90, end: -90}", 3000, "mina.bounce")
	pie1.AddAnimationSingleRun("{start: -90, end: " & EndVal & "}", 3000, "mina.bounce")
	pie1.HasEvents = True
	
	If perc < 40 Then
		pie1.AddAnimationContinuousRun("{fill: '#e65100'}", 1500, "", "{fill: '#ffcc80'}", 500, "")
	End If	
			
	Dim txt1 As ABMSVGElement = svg.Text("txt" & id, 40,40, perc & "%")
	txt1.SetAttributes("{fill: '#000000', 'text-anchor': 'middle', 'alignment-baseline': 'middle'}")
End Sub"$
	page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code2))
	
	Dim code3 As String = $"Sub psvg_SVGClicked(elementID As String)
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastred", "Clicked on SVGelement " & elementID, 2000)
End Sub"$
	
	page.Cell(7,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code3", code3))
	
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
	If Action = "ABMSVGSurface" Then Return
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

Sub AddBarRow(PageRow As Int, id As String, Text As String, perc As Double, WeekToDoPerc As Double, IsBad As Boolean)
	Dim cnt As ABMContainer
	cnt.Initialize(page , "cnt_" & id, "")
	
	cnt.AddRowsM(1, False,0,0,"").AddCellsOSMP(1,0,0,0,12,6,6,0,0,10,10,"").AddCellsOSMP(1,0,0,0,12,6,6,0,0,10,10,"")
	cnt.BuildGrid
	
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, "lbl1_" & id, Text, ABM.SIZE_H6, True, "")
		
	cnt.Cell(1,1).AddComponent(lbl1)
	
	' make sure the container is added BEFORE adding an SVGsurface
	page.Cell(PageRow,1).AddComponent(cnt)
	
	Dim svg As ABMSVGSurface
	svg.Initialize(page, "svg_" & id, "0 0 400 50", "none", "400px", "50px")
	cnt.Cell(1,2).AddComponent(svg)
	cnt.Cell(1,2).MarginBottom = "-28px"
		
	Dim rect1 As ABMSVGElement = svg.Rect("rect" & id, 0,0,perc*4,50,0,0)
		
	If perc >= WeekToDoPerc Then
		rect1.SetAttributes($"{fill: "#e6ee9c"}"$)
	Else
		rect1.SetAttributes($"{fill: "#ffcc80"}"$)
		If perc < (WeekToDoPerc - 10) Then
			rect1.AddAnimationContinuousRun($"{fill: "#e65100"}"$, 1500, "", $"{fill: "#ffcc80"}"$, 500, "")
		End If
	End If
	
	Dim line2 As ABMSVGElement = svg.Line("line2_" & id, WeekToDoPerc*4,0,WeekToDoPerc*4,50)
	line2.SetAttributes($"{fill: "#b71c1c", stroke: "#b71c1c", strokeWidth: 1}"$)	
End Sub

Sub AddPieRow(RowNum As Int, id As Int, text2 As String, perc As Double)
	Dim cnt As ABMContainer
	cnt.Initialize(page , "pcnt_" & id, "")
	
	cnt.AddRowsM(1, False,0,0,"").AddCellsOS(1,0,0,0,4,4,4,"").AddCellsOS(1,0,0,0,8,8,8,"")
	cnt.BuildGrid
	
	Dim cnt2 As ABMContainer
	cnt2.Initialize(page , "pcnt2_" & id, "")
	
	cnt2.AddRowsM(1, False,0,0,"").AddCellsOSMP(1, 0,0,0,12,12,12,0,0,0,0,"")
	cnt2.BuildGrid	
	
	Dim lbl2 As ABMLabel
	lbl2.Initialize(page, "plbl2_" & id, text2, ABM.SIZE_H6, True, "")	

	cnt.cell(1,1).addcomponent(cnt2)
	cnt.Cell(1,2).AddComponent(lbl2)
	
	page.Cell(RowNum,1).AddComponent(cnt)
	
	Dim svg As ABMSVGSurface
	svg.Initialize(page, id, "0 0 80 80", "none", "80px", "80px")
	cnt.Cell(1,1).AddArrayComponent(svg, "psvg")
	cnt.Cell(1,1).MarginBottom = "-20px"
		
	Dim cir1 As ABMSVGElement = svg.circle("pcir" & id, 40,40,30)
	cir1.SetAttributes("{fill: '#e6ee9c'}")

	Dim pie1 As ABMSVGElement = svg.Pie("ppie" & id, 40,40,0,30, -90, 0)
	
	Dim pie1Group As ABMSVGElement = svg.Group("ppie" & id & "Group", Array As String("ppie" & id))  ' <- Needed for the pointer cursor, can only be set to a group
	pie1Group.SetAttributes("{cursor: 'pointer'}")
	
	pie1.SetAttributes("{fill: '#ffcc80'}")
	Dim EndVal As Int = (360*perc/100)-90
	pie1.AddHoverINAnimation("{r2: 40}",250,"")
	pie1.AddHoverOUTAnimation("{r2: 30}",250,"")
	'pie1.AddAnimationContinuousRun("{start: -90, end: " & EndVal & "}", 3000, "mina.bounce", "{start: -90, end: -90}", 3000, "mina.bounce")
	pie1.AddAnimationSingleRun("{start: -90, end: " & EndVal & "}", 3000, "mina.bounce")
	pie1.HasEvents = True
	
	If perc < 40 Then
		pie1.AddAnimationContinuousRun("{fill: '#e65100'}", 1500, "", "{fill: '#ffcc80'}", 500, "")
	End If	
			
	Dim txt1 As ABMSVGElement = svg.Text("txt" & id, 40,40, perc & "%")
	txt1.SetAttributes("{fill: '#000000', 'text-anchor': 'middle', 'alignment-baseline': 'middle'}")
End Sub

Sub psvg_SVGClicked(elementID As String)
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastred", "Clicked on SVGelement " & elementID, 2000)
End Sub