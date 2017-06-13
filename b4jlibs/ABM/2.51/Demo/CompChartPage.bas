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
	Public Name As String = "CompChartPage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
	Dim CurrentValues As List
	Dim CurrentLabels As List
	Dim TemperatureTimer As Timer
	
	Dim ATest As TestClassForAlain 'ignore
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	' build the local structure IMPORTANT!
	CurrentLabels.Initialize
	CurrentValues.Initialize
	
	BuildPage
End Sub

Private Sub WebSocket_Connected (WebSocket1 As WebSocket)
	Log("Connected")
	ws = WebSocket1	
	ABMPageId = ABM.GetPageID(page, Name,ws)
	Dim session As HttpSession = ABM.GetSession(ws, ABMShared.SessionMaxInactiveIntervalSeconds)
	
	If ABMShared.NeedsAuthorization Then
		If session.GetAttribute2("IsAuthorized", "") = "" Then
			ABMShared.NavigateToPage(ws, ABMPageId,"../")
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
	
	TemperatureTimer.Initialize("TemperatureTimer", 1000)
	TemperatureTimer.Enabled = True
End Sub

Private Sub WebSocket_Disconnected
	TemperatureTimer.Enabled = False		
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
	theme.AddChartTheme("chart1theme")
	theme.Chart("chart1theme").Serie(ABM.CHART_SERIEINDEX_C).LinePointStrokeWidthPx=8
	theme.Chart("chart1theme").Serie(ABM.CHART_SERIEINDEX_C).LineStrokeWidthPx=5	
	
	theme.AddChartTheme("chart2theme")
	theme.Chart("chart2theme").ZDepth = ABM.ZDEPTH_1
	theme.Chart("chart2theme").BackColor = ABM.COLOR_WHITE
	
	theme.AddChartTheme("chart4theme")
	theme.Chart("chart4theme").ZDepth = ABM.ZDEPTH_1
	theme.Chart("chart4theme").BackColor = ABM.COLOR_WHITE
	theme.Chart("chart4theme").Serie(ABM.CHART_SERIEINDEX_A).BarStrokeWidthPx = 25
	theme.Chart("chart4theme").Serie(ABM.CHART_SERIEINDEX_A).Color = ABM.COLOR_AMBER
	theme.Chart("chart4theme").Serie(ABM.CHART_SERIEINDEX_B).BarStrokeWidthPx = 25
	theme.Chart("chart4theme").Serie(ABM.CHART_SERIEINDEX_B).Color = ABM.COLOR_ORANGE
	
	theme.AddChartTheme("chart5theme")
	theme.Chart("chart5theme").LabelColor = ABM.COLOR_WHITE
	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True	
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMChart"
	page.PageDescription = "The chart component "	
	page.PageHTMLName = "abmaterial-chart.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
	page.ShowConnectedIndicator = True
	
	' we are using a plugin for chartist.  Make sure the js is in the www/js/ and the css in the www/css/ folder!
	page.AddExtraJavaScriptFile("chartist-plugin-axistitle.min.js")
	page.AddExtraJavaScriptFile("chartist-plugin-legend.js")
	page.AddExtraJavaScriptFile("chartist-plugin-pointlabels.min.js")
	page.AddExtraJavaScriptFile("chartist-plugin-zoom.min.js")
	page.AddExtraCSSFile("chartist-plugin-tooltip.css")
	page.AddExtraJavaScriptFile("chartist-plugin-tooltip.min.js")
			
	ABMShared.BuildNavigationBar(page, "ABMChart", "../images/logo.png", "", "Controls", "ABMChart")
		
	' create the page grid
	page.AddRows(9,True, "").AddCells12(1,"")
	page.AddRows(1,True, "").AddCellsOS(2,1,1,1,8,4,4,"")
	page.AddRows(2,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components	
				
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	
	' using the new cellR() methods (R stands for Relative).  First param is the number of rows to move relative to the the previous CellR() call.
	' Starts at 1! So here me do not have to move any rows
	' add paragraph	
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par1","ABMaterial can create several types of charts. Because of the nature of responsive design it's important to understand that blocks in design like images, videos and similar content need to be able to scale and adapt to the media. In order for an element to scale, you need to rely on a certain aspect ratios (like 4:3, 3:2, 16:9 etc.) rather than specifying a fixed width and height.") )
	' add paragraph	
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par5","To designers this Idea is absolutely not new, but to developers this might be at first. However, when a designer talks to a developer about the images being 320x240 on this page and 300x200 on that element, he actually just translated his idea of using 4:3 and 3:2 images into pixels.{BR}{BR}With ABMaterial you can specify those ratios directly on charts without the need To calculate any fixed dimensions. In order To create a chart that Is using the aspect ratio of a golden section you can just use the constant ABM.CHART_RATIO_GOLDENSECTION in the Initialize.") )
	' add header	
	page.CellR(0,1).AddComponent(ABMShared.BuildHeader(page, "hdr1", "Line Charts"))	
	' add paragraph	
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par6","The ABMaterial line chart can be used to draw Line or Scatter charts. Use the constant ABM.CHART_NULLVALUE when you want to make holes in the data.") )
	
	
	' create a line chart
	Dim chart1 As ABMChart
	chart1.Initialize(page, "chart1", ABM.CHART_TYPELINE, ABM.CHART_RATIO_GOLDENSECTION, "chart1theme")
		
	' add the labels
	chart1.AddLabels(Array As String("Mon", "The", "Wed", "Thu", "Fri", "Sat", "Sun"))
	' set some options
	chart1.OptionsLine.FullWidth=True
	chart1.OptionsLine.ChartPaddingRight=60 ' because we set fullwidth, we have to adjust so the final label also fits
	chart1.OptionsLine.Serie(ABM.CHART_SERIEINDEX_A).LineSmooth = ABM.CHART_LINESMOOTH_NONE
	chart1.OptionsLine.Serie(ABM.CHART_SERIEINDEX_C).LineSmooth = ABM.CHART_LINESMOOTH_SIMPLE
	chart1.OptionsLine.Serie(ABM.CHART_SERIEINDEX_C).ShowArea = True
	chart1.AddPluginDefinition("Chartist.plugins.ctPointLabels({textAnchor: 'middle'})")
	
	' add some series	
	Dim SerieA As ABMChartSerie
	SerieA.InitializeForLine(ABM.CHART_SERIEINDEX_A)
	SerieA.SetValues(Array As Int(30,50,70,80,ABM.CHART_NULLVALUE,140,170))
	chart1.AddSerie(SerieA)
	
	Dim SerieC As ABMChartSerie
	SerieC.InitializeForLine(ABM.CHART_SERIEINDEX_C)
	SerieC.SetValues(Array As Int(100,120,180,150,190,100,70))
	chart1.AddSerie(SerieC)
	
	' add the chart to the cell	
	' move one row , first param = 1
	page.CellR(1,1).AddComponent(chart1)
	
	' add paragraph	
	' move one row , first param = 1
	page.CellR(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","Line Charts are very tunable through Theme and OptionsLine. You can modify the look and feel on the chart and on individual lines.  Charts can use up to 15 'Series' of data values. A line chart is the only one where you can pick a 'Serie'.  This is due to a hack in the underlying Chartist.js library which does not provide this option.") )
	
	' create a line chart
	Dim chart2 As ABMChart
	chart2.Initialize(page, "chart2", ABM.CHART_TYPELINE, ABM.CHART_RATIO_GOLDENSECTION, "chart2theme")
	' set some options
	chart2.OptionsLine.ChartPaddingBottom = 30
	chart2.OptionsLine.ChartPaddingTop = 30
	chart2.OptionsLine.ChartPaddingRight = 130
	chart2.OptionsLine.AxisYLow=-3 ' must be set if you use 'Chartist.AutoScaleAxis' as type
	chart2.OptionsLine.AxisYHigh=3 ' must be set if you use 'Chartist.AutoScaleAxis' as type
	chart2.OptionsLine.AxisYOnlyInteger=True
	chart2.OptionsLine.AxisYAxisType = "Chartist.AutoScaleAxis" ' must be set if you want to use the zoom plugin
	chart2.OptionsLine.AxisXLow=10 ' must be set if you use 'Chartist.AutoScaleAxis' as type
	chart2.OptionsLine.AxisXHigh=80 ' must be set if you use 'Chartist.AutoScaleAxis' as type
	chart2.OptionsLine.AxisXAxisType = "Chartist.AutoScaleAxis" ' must be set if you want to use the zoom plugin
	chart2.OptionsLine.AxisXOnlyInteger=True
	chart2.OptionsLine.FullWidth=True
	chart2.OptionsLine.AxisXShowGrid = True
	chart2.OptionsLine.AxisXShowLabel = True
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_A).LineSmooth = ABM.CHART_LINESMOOTH_SIMPLE
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_A).ShowArea = True
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_A).ShowLine = False
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_A).ShowPoint = False
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_B).LineSmooth = ABM.CHART_LINESMOOTH_SIMPLE
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_B).ShowArea = True
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_B).ShowLine = False
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_B).ShowPoint = False
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_C).LineSmooth = ABM.CHART_LINESMOOTH_SIMPLE
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_C).ShowArea = True
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_C).ShowLine = False
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_C).ShowPoint = False
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_D).LineSmooth = ABM.CHART_LINESMOOTH_SIMPLE
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_D).ShowArea = True
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_D).ShowLine = True
	chart2.OptionsLine.Serie(ABM.CHART_SERIEINDEX_D).ShowPoint = True ' we want to use the ctPointLabels plugin so we need to show the points
	chart2.AddPluginDefinition($"Chartist.plugins.ctAxisTitle({
      axisX: {
        axisTitle: 'Time (mins)',
        axisClass: 'ct-axis-title',
        offset: {
          x: 0,
          y: 45
        },
        textAnchor: 'middle'
      },
      axisY: {
        axisTitle: 'Goals',
        axisClass: 'ct-axis-title',
        offset: {
          x: 0,
          y: -12
        },
        textAnchor: 'middle',
        flipTitle: false
      }
    })"$)
	chart2.AddPluginDefinition("Chartist.plugins.legend({legendNames: ['Blue pill', 'Red pill', 'Green pill', 'Yellow pill'],})") ' you must set the names here!
	chart2.AddPluginDefinition("Chartist.plugins.tooltip()")
	chart2.AddPluginDefinition("Chartist.plugins.zoom({ onZoom : onZoom })") ' cannot be changed, must be like this
		
	' add some series	
	Dim Serie2A As ABMChartSerie
	Serie2A.InitializeForLine(ABM.CHART_SERIEINDEX_A)
	Serie2A.Name = "Blue pill"
	Serie2A.SetValuesXY(Array As Int(10,20,30,40,50,60,70,80), Array As Int(1,2,3,1,-2,0,1,0))
	chart2.AddSerie(Serie2A)
	
	Dim Serie2B As ABMChartSerie
	Serie2B.InitializeForLine(ABM.CHART_SERIEINDEX_B)
	Serie2B.Name = "Red pill"
	Serie2B.SetValuesXY(Array As Int(10,20,30,40,50,60,70,80), Array As Int(-2,-1,-2,-1,-2.5,-1,-2,-1))
	chart2.AddSerie(Serie2B)
	
	Dim Serie2C As ABMChartSerie
	Serie2C.InitializeforLine(ABM.CHART_SERIEINDEX_C)
	Serie2C.Name = "Green pill"
	Serie2C.SetValuesXY(Array As Int(10,20,30,40,50,60,70,80), Array As Int(0,0,0,1,2,2.5,2.,1))
	chart2.AddSerie(Serie2C)
	
	Dim Serie2D As ABMChartSerie
	Serie2D.InitializeforLine(ABM.CHART_SERIEINDEX_D)
	Serie2D.Name = "Yellow pill"
	Serie2D.SetValuesXY(Array As Int(10,20,30,40,50,60,70,80), Array As Int(2.5, 2, 1, 0.5, 1, 0.5, -1, -2.5))
	chart2.AddSerie(Serie2D)
	
	' add the chart to the cell
	' move one row , first param = 1
	page.CellR(1,1).AddComponent(chart2)
	
	Dim btn1 As ABMButton
	btn1.InitializeFlat(page, "btn1", "", "", "Reset zoom", "")
	page.CellR(0,1).AddComponent(btn1)
	
	' add header	
	' move one row , first param = 1
	page.CellR(1,1).AddComponent(ABMShared.BuildHeader(page, "hdr2", "Bar Charts"))	
	' add paragraph	
	' stay on the same row, first param = 0
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par7","A bar chart or bar graph is a chart that presents Grouped data with rectangular bars with lengths proportional to the values that they represent. The bars can be plotted vertically or horizontally. A vertical bar chart is sometimes called a column bar chart.") )
	
	
	' create a bar chart
	Dim chart3 As ABMChart
	chart3.Initialize(page, "chart3", ABM.CHART_TYPEBAR, ABM.CHART_RATIO_GOLDENSECTION, "")
	' set some options
	chart3.OptionsBar.AxisYOnlyInteger=True
	chart3.OptionsBar.ChartPaddingRight=60
		
	' add the labels
	chart3.AddLabels(Array As String("Mon", "The", "Wed", "Thu", "Fri", "Sat", "Sun"))
	
	' add some series	
	Dim Serie3A As ABMChartSerie
	Serie3A.InitializeForBar
	Serie3A.SetValues(Array As Int(30,50,70,80,100,140,170))
	chart3.AddSerie(Serie3A)
	
	Dim Serie3B As ABMChartSerie
	Serie3B.InitializeForBar
	Serie3B.SetValues(Array As Int(100,120,180,150,190,100,70))
	chart3.AddSerie(Serie3B)
	
	' add the chart to the cell
	' move one row , first param = 1
	page.CellR(1,1).AddComponent(chart3)
	
	' add paragraph	
	' move one row , first param = 1
	page.CellR(1,1).AddComponent(ABMShared.BuildParagraph(page,"par22","Bar Charts can also be tuned using Theme and OptionsBar.") )
	
	' create a bar chart
	Dim chart4 As ABMChart
	chart4.Initialize(page, "chart4", ABM.CHART_TYPEBAR, ABM.CHART_RATIO_GOLDENSECTION, "chart4theme")
	' set some options
	chart4.OptionsBar.AxisXOnlyInteger=True
	chart4.OptionsBar.StackBars = True
	chart4.OptionsBar.HorizontalBars = True
	chart4.OptionsBar.ChartPaddingRight=60
		
	' add the labels
	chart4.AddLabels(Array As String("Mon", "The", "Wed", "Thu", "Fri", "Sat", "Sun"))
	
	' add some series	
	Dim Serie4A As ABMChartSerie
	Serie4A.InitializeForBar
	Serie4A.SetValues(Array As Int(30,50,70,80,100,140,170))
	chart4.AddSerie(Serie4A)
	
	Dim Serie4B As ABMChartSerie
	Serie4B.InitializeForBar
	Serie4B.SetValues(Array As Int(100,120,180,150,190,100,70))
	chart4.AddSerie(Serie4B)
	
	' add the chart to the cell
	' move one row , first param = 1
	page.CellR(1,1).AddComponent(chart4)
	
	' add header		
	' move one row , first param = 1
	page.CellR(1,1).AddComponent(ABMShared.BuildHeader(page, "hdr3", "Pie and Donut Charts"))	
	' add paragraph	
	' stay in the same row, first param = 0
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par8","A pie chart (or a circle chart) is a circular statistical graphic, which is divided into slices to illustrate numerical proportion. In a pie chart, the arc length of each slice (and consequently its central angle and area), is proportional to the quantity it represents. While it is named for its resemblance to a pie which has been sliced, there are variations on the way it can be presented. Pie Charts be transformed to Donut charts through the Theme and OptionsPie.") )
	
	' create a pie chart
	Dim chart5 As ABMChart
	chart5.Initialize(page, "chart5", ABM.CHART_TYPEPIE, ABM.CHART_RATIO_SQUARE, "chart5theme")
	' Something special, Label interpolation.  the value will transformed into a percentage format (This is Javascript!)
	Dim SumValues As Int = 30+50+70+80+100+140+170
	chart5.OptionsPie.LabelInterpolation = "Math.round(value / " & SumValues  & " * 100) + '%'"
		
	' we do not add labels, as they will be generated them through the LabelInterpolation function we just declared!
	
	' add ONE serie
	Dim Serie5A As ABMChartSerie
	Serie5A.InitializeForPie
	Serie5A.SetValues(Array As Int(30,50,70,80,100,140,170))
	chart5.AddSerie(Serie5A)	
	
	' add the chart to the cell
	' move one row , first param = 1
	page.CellR(1,1).AddComponent(chart5)
	
	' create a donut/gauge chart
	Dim chart6 As ABMChart
	chart6.Initialize(page, "chart6", ABM.CHART_TYPEPIE, ABM.CHART_RATIO_SQUARE, "chart5theme")
	chart6.OptionsPie.IsDonut = True
	chart6.OptionsPie.DonutWidth = 80
	chart6.OptionsPie.StartAngle = 270
	chart6.OptionsPie.Total = 200
	' Something special, Label interpolation.  the value will transformed into a percentage format (This is Javascript!)
	Dim SumValues As Int = 20+10+30+40
	chart6.OptionsPie.LabelInterpolation = "Math.round(value / " & SumValues  & " * 100) + '%'"
		
	' we do not add labels, as they will be generated them through the LabelInterpolation function we just declared!
	
	' add ONE serie
	Dim Serie6A As ABMChartSerie
	Serie6A.InitializeForPie
	Serie6A.SetValues(Array As Int(20,10,30,40))
	chart6.AddSerie(Serie6A)	
	
	' add the chart to the cell
	' stay in the same row , first param = 0
	page.CellR(0,2).AddComponent(chart6)	
	
	' add header		
	' move one row , first param = 1
	page.CellR(1,1).AddComponent(ABMShared.BuildHeader(page, "hdr4", "Update chart with new values"))	
	' add paragraph	
	' stay in the same row, first param = 0
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par3","You can update the charts with new values.  E.g. you can use this to update the chart with real-time telemetry data, like the temperature of a machine.") )
	
	' create a line chart
	Dim chart7 As ABMChart
	chart7.Initialize(page, "chart7", ABM.CHART_TYPELINE, ABM.CHART_RATIO_GOLDENSECTION, "")
	' set some options
	chart7.OptionsLine.FixedHeightPx = 300
	chart7.OptionsLine.AxisYLow=-10
	chart7.OptionsLine.AxisYHigh=10
	chart7.OptionsLine.AxisYOnlyInteger=True
	chart7.OptionsLine.FullWidth=True
	chart7.OptionsLine.ChartPaddingRight=60 ' because we set fullwidth, we have to adjust so the final label also fits
	chart7.OptionsLine.Serie(ABM.CHART_SERIEINDEX_A).LineSmooth = ABM.CHART_LINESMOOTH_SIMPLE
	chart7.OptionsLine.Serie(ABM.CHART_SERIEINDEX_A).ShowPoint=False
	' add the labels
	CurrentLabels.addAll(Array As String("0", "0", "0", "0", "0", "0", "0","0", "0", "0"))
	chart7.AddLabels(CurrentLabels)
	
	' add some series	
	CurrentValues.AddAll(Array As Int(0,0,0,0,0,0,0,0,0,0))
	Dim Serie7A As ABMChartSerie
	Serie7A.InitializeForBar
	Serie7A.SetValues(CurrentValues)
	chart7.AddSerie(Serie7A)
	
	' add the chart to the cell
	' move one row , first param = 1
	page.CellR(1,1).AddComponent(chart7)
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition			
End Sub

Sub btn1_Clicked(Target As String)
	Dim chart2 As ABMChart = page.Component("chart2")
	chart2.ResetZoom
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMChart" Then Return
	If Action = "Contact" Then	
		myToastId = myToastId + 1	
		page.ShowToast("toast" & myToastId, "toastred", "Hello to you too!", 5000)
		Return
	End If
	If Action = "LogOff" Then
		ABMShared.LogOff(page)
		Return
	End If
	ABMShared.NavigateToPage(ws,ABMPageId, Value)
End Sub

Sub Page_SignedOffSocialNetwork(Network As String, Extra As String)
	page.ws.Session.SetAttribute("authType", "")
	page.ws.Session.SetAttribute("authName", "")
	page.ws.Session.SetAttribute("IsAuthorized", "")			
	ABMShared.NavigateToPage(ws,ABMPageId, "../")
End Sub

Sub TemperatureTimer_Tick
	Dim chart7 As ABMChart = page.Component("chart7")
	If chart7 <> Null Then
		CurrentLabels.RemoveAt(0)
		CurrentValues.RemoveAt(0)
		Dim newValue As Int = Rnd(-10,11)
		CurrentValues.Add(newValue)
		CurrentLabels.Add("" & newValue)
		chart7.SetLabels(CurrentLabels)
		chart7.GetSerie(ABM.CHART_SERIEINDEX_A).SetValues(CurrentValues)
		chart7.Refresh
	End If
End Sub