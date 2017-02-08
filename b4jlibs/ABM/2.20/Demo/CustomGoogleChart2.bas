Type=Class
Version=4.7
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	Dim ABM As ABMaterial 'ignore
	Dim ABMComp As ABMCustomComponent	
	Dim Title As String
	Dim Subtitle As String 'ignore 'only used for a google material chart
	Dim Columns As List
	Dim Rows As List
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(InternalPage As ABMPage, ID As String)
	ABMComp.Initialize("ABMComp", Me, InternalPage, ID)
	ABMComp.Visibility = ABM.VISIBILITY_HIDE_ALL ' hide the chart while loading
	' the automatic events will be raised on the page e.g. if the id = "mycomp" then the event will be mycomp_Click(params as Map)
	' future: we'll see if some other mechanisme is needed for non automatic events 
	Columns.Initialize
	Rows.Initialize
End Sub

public Sub AddColumn(varType As String, text As String)
	Columns.add($"data.addColumn('${varType}', '${text}');"$)
End Sub

public Sub AddRow(Day As Int, Guardians As Double, Avengers As Double, Transformers As Double)
	If Rows.Size > 0 Then ' with comma
		Rows.Add($",[${Day}, ${Guardians}, ${Avengers}, ${Transformers}]"$)
	Else ' first one, does not need a comma
		Rows.Add($"[${Day}, ${Guardians}, ${Avengers}, ${Transformers}]"$)
	End If
End Sub

private Sub GetColumns() As String 
	Dim s As String
	For i = 0 To Columns.Size-1
		s = s & Columns.Get(i)
	Next
	Return s
End Sub

private Sub GetRows() As String
	Dim s As String
	For i = 0 To Rows.Size-1
		s = s & Rows.Get(i)
	Next
	Return s
End Sub

' runs when an object is created for the first time. Expects a valid html string
Sub ABMComp_Build(internalID As String) As String
	Return $"<div id="${internalID}"></div>"$	
End Sub

' Is useful to run some initalisation script. 
Sub ABMComp_FirstRun(InternalPage As ABMPage, internalID As String)
	' this is for a classic google chart
	Dim script As String = $"google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);
	
    function drawChart() {
     	// Define the chart to be drawn.
     	var data = new google.visualization.DataTable();
	 	${GetColumns}
   	  
      	data.addRows([${GetRows}]);
	  
	  	var options = {   
			title: '${Title}',     	
        	width: '100%',
        	height: 500,
			vAxis: {title: "Visitors", minValue:30, maxValue:50},
      		hAxis: {title: "Day"},			
			explorer: { 
            	actions: ['dragToZoom', 'rightClickToReset'],
            	axis: 'horizontal',
            	keepInBounds: true,
            	maxZoomIn: 100.0
			},			
          	legend: { position: 'bottom' }
      	};

      	// Instantiate and draw the chart.
      	var chart = new google.visualization.LineChart(document.getElementById('${internalID}'));
	  	chart.draw(data, options);	  
	  
	  	// added this because on firefox google charts can give errors
	  	google.visualization.events.addListener(chart, 'error', function (err) {
             google.visualization.errors.removeError(err.id);
      	});
	  
	  	// added this so the chart becomes visible
	  	document.getElementById('${internalID}').className="";	
	  	// I force a second redraw by calling chart.draw(data, options); again (forces the width to fit)	   
	  	chart.draw(data, options);
	 }
	 
	 // make it resposive on resize
	 $(window).resize(function(){
  		drawChart();  
	 });
	 "$
	
	' this is for a google material chart
'	Dim script As String = $"google.charts.load('current', {'packages':['line']});
'    google.charts.setOnLoadCallback(drawChart);
'	
'    function drawChart() {
'     	// Define the chart to be drawn.
'     	var data = new google.visualization.DataTable();
'	 	${GetColumns}
'   	  
'      	data.addRows([${GetRows}]);
'	  
'	  	var options = {
'        	chart: {
'          		title: '${Title}',
'          		subtitle: '${Subtitle}'
'        	},
'        	width: '100%',
'        	height: 500
'      	};
'
'      	// Instantiate and draw the chart.
'      	var chart = new google.charts.Line(document.getElementById('${internalID}'));
'	  	chart.draw(data, options);	  
'	  
'	  	// added this because on firefox google charts can give errors
'	  	google.visualization.events.addListener(chart, 'error', function (err) {
'             google.visualization.errors.removeError(err.id);
'      	});
'	  
'	  	// added this so the chart becomes visible
'	  	document.getElementById('${internalID}').className="";	
'	  	// I force a second redraw by calling chart.draw(data, options); again (forces the width to fit)	   
'	  	chart.draw(data, options);
'	 }
'	 
'	 // make it resposive on resize
'	 $(window).resize(function(){
'  		drawChart();  
'	 });
'	 "$
	
	 InternalPage.ws.Eval(script, Array As Object(ABMComp.ID))
	' flush not needed, it's done in the refresh method in the lib
End Sub

' runs when a refresh is called
Sub ABMComp_Refresh(InternalPage As ABMPage, internalID As String)
	' use these methods to adjust the object
	' ABM.HasClass
	' ABM.AddClass
	' ABM.RemoveClass
	
	' ABM.AddHTML
	' ABM.InsertHTMLAfter
	' ABM.RemoveHTML
	
	' ABM.GetProperty
	' ABM.SetProperty
	' ABM.RemoveProperty
	
	' ABM.GetStyleProperty
	' ABM.SetStyleProperty
	
	' do some script stuff like you do in RunJavaScript	
	'Dim script As String = $""$	
	'InternalPage.ws.Eval(script, Null)	
End Sub

' do the stuff needed when the object is removed
Sub ABMComp_CleanUp(InternalPage As ABMPage, internalID As String)
	
End Sub




