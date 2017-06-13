package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class customgooglechart2 extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.customgooglechart2", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.customgooglechart2.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public com.ab.abmaterial.ABMaterial _abm = null;
public com.ab.abmaterial.ABMCustomComponent _abmcomp = null;
public String _title = "";
public String _subtitle = "";
public anywheresoftware.b4a.objects.collections.List _columns = null;
public anywheresoftware.b4a.objects.collections.List _rows = null;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _abmcomp_build(String _internalid) throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Sub ABMComp_Build(internalID As String) As String";
 //BA.debugLineNum = 51;BA.debugLine="Return $\"<div id=\"${internalID}\"></div>\"$";
if (true) return ("<div id=\""+__c.SmartStringFormatter("",(Object)(_internalid))+"\"></div>");
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_cleanup(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
 //BA.debugLineNum = 172;BA.debugLine="Sub ABMComp_CleanUp(InternalPage As ABMPage, inter";
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_firstrun(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
String _script = "";
 //BA.debugLineNum = 55;BA.debugLine="Sub ABMComp_FirstRun(InternalPage As ABMPage, inte";
 //BA.debugLineNum = 57;BA.debugLine="Dim script As String = $\"google.charts.load('curr";
_script = ("google.charts.load('current', {'packages':['corechart']});\n"+"    google.charts.setOnLoadCallback(drawChart);\n"+"	\n"+"    function drawChart() {\n"+"     	// Define the chart to be drawn.\n"+"     	var data = new google.visualization.DataTable();\n"+"	 	"+__c.SmartStringFormatter("",(Object)(_getcolumns()))+"\n"+"   	  \n"+"      	data.addRows(["+__c.SmartStringFormatter("",(Object)(_getrows()))+"]);\n"+"	  \n"+"	  	var options = {   \n"+"			title: '"+__c.SmartStringFormatter("",(Object)(_title))+"',     	\n"+"        	width: '100%',\n"+"        	height: 500,\n"+"			vAxis: {title: \"Visitors\", minValue:30, maxValue:50},\n"+"      		hAxis: {title: \"Day\"},			\n"+"			explorer: { \n"+"            	actions: ['dragToZoom', 'rightClickToReset'],\n"+"            	axis: 'horizontal',\n"+"            	keepInBounds: true,\n"+"            	maxZoomIn: 100.0\n"+"			},			\n"+"          	legend: { position: 'bottom' }\n"+"      	};\n"+"\n"+"      	// Instantiate and draw the chart.\n"+"      	var chart = new google.visualization.LineChart(document.getElementById('"+__c.SmartStringFormatter("",(Object)(_internalid))+"'));\n"+"	  	chart.draw(data, options);	  \n"+"	  \n"+"	  	// added this because on firefox google charts can give errors\n"+"	  	google.visualization.events.addListener(chart, 'error', function (err) {\n"+"             google.visualization.errors.removeError(err.id);\n"+"      	});\n"+"	  \n"+"	  	// added this so the chart becomes visible\n"+"	  	document.getElementById('"+__c.SmartStringFormatter("",(Object)(_internalid))+"').className=\"\";	\n"+"	  	// I force a second redraw by calling chart.draw(data, options); again (forces the width to fit)	   \n"+"	  	chart.draw(data, options);\n"+"	 }\n"+"	 \n"+"	 // make it resposive on resize\n"+"	 $(window).resize(function(){\n"+"  		drawChart();  \n"+"	 });\n"+"	 ");
 //BA.debugLineNum = 144;BA.debugLine="InternalPage.ws.Eval(script, Array As Object(ABM";
_internalpage.ws.Eval(_script,anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_abmcomp.getID())}));
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_refresh(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
 //BA.debugLineNum = 149;BA.debugLine="Sub ABMComp_Refresh(InternalPage As ABMPage, inter";
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public String  _addcolumn(String _vartype,String _text) throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="public Sub AddColumn(varType As String, text As St";
 //BA.debugLineNum = 22;BA.debugLine="Columns.add($\"data.addColumn('${varType}', '${tex";
_columns.Add((Object)(("data.addColumn('"+__c.SmartStringFormatter("",(Object)(_vartype))+"', '"+__c.SmartStringFormatter("",(Object)(_text))+"');")));
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public String  _addrow(int _day,double _guardians,double _avengers,double _transformers) throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="public Sub AddRow(Day As Int, Guardians As Double,";
 //BA.debugLineNum = 26;BA.debugLine="If Rows.Size > 0 Then ' with comma";
if (_rows.getSize()>0) { 
 //BA.debugLineNum = 27;BA.debugLine="Rows.Add($\",[${Day}, ${Guardians}, ${Avengers},";
_rows.Add((Object)((",["+__c.SmartStringFormatter("",(Object)(_day))+", "+__c.SmartStringFormatter("",(Object)(_guardians))+", "+__c.SmartStringFormatter("",(Object)(_avengers))+", "+__c.SmartStringFormatter("",(Object)(_transformers))+"]")));
 }else {
 //BA.debugLineNum = 29;BA.debugLine="Rows.Add($\"[${Day}, ${Guardians}, ${Avengers}, $";
_rows.Add((Object)(("["+__c.SmartStringFormatter("",(Object)(_day))+", "+__c.SmartStringFormatter("",(Object)(_guardians))+", "+__c.SmartStringFormatter("",(Object)(_avengers))+", "+__c.SmartStringFormatter("",(Object)(_transformers))+"]")));
 };
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim ABM As ABMaterial 'ignore";
_abm = new com.ab.abmaterial.ABMaterial();
 //BA.debugLineNum = 4;BA.debugLine="Dim ABMComp As ABMCustomComponent";
_abmcomp = new com.ab.abmaterial.ABMCustomComponent();
 //BA.debugLineNum = 5;BA.debugLine="Dim Title As String";
_title = "";
 //BA.debugLineNum = 6;BA.debugLine="Dim Subtitle As String 'ignore 'only used for a g";
_subtitle = "";
 //BA.debugLineNum = 7;BA.debugLine="Dim Columns As List";
_columns = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 8;BA.debugLine="Dim Rows As List";
_rows = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public String  _getcolumns() throws Exception{
String _s = "";
int _i = 0;
 //BA.debugLineNum = 33;BA.debugLine="private Sub GetColumns() As String";
 //BA.debugLineNum = 34;BA.debugLine="Dim s As String";
_s = "";
 //BA.debugLineNum = 35;BA.debugLine="For i = 0 To Columns.Size-1";
{
final int step2 = 1;
final int limit2 = (int) (_columns.getSize()-1);
_i = (int) (0) ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
 //BA.debugLineNum = 36;BA.debugLine="s = s & Columns.Get(i)";
_s = _s+BA.ObjectToString(_columns.Get(_i));
 }
};
 //BA.debugLineNum = 38;BA.debugLine="Return s";
if (true) return _s;
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public String  _getrows() throws Exception{
String _s = "";
int _i = 0;
 //BA.debugLineNum = 41;BA.debugLine="private Sub GetRows() As String";
 //BA.debugLineNum = 42;BA.debugLine="Dim s As String";
_s = "";
 //BA.debugLineNum = 43;BA.debugLine="For i = 0 To Rows.Size-1";
{
final int step2 = 1;
final int limit2 = (int) (_rows.getSize()-1);
_i = (int) (0) ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
 //BA.debugLineNum = 44;BA.debugLine="s = s & Rows.Get(i)";
_s = _s+BA.ObjectToString(_rows.Get(_i));
 }
};
 //BA.debugLineNum = 46;BA.debugLine="Return s";
if (true) return _s;
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,com.ab.abmaterial.ABMPage _internalpage,String _id) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 12;BA.debugLine="Public Sub Initialize(InternalPage As ABMPage, ID";
 //BA.debugLineNum = 13;BA.debugLine="ABMComp.Initialize(\"ABMComp\", Me, InternalPage, I";
_abmcomp.Initialize(ba,"ABMComp",this,_internalpage,_id);
 //BA.debugLineNum = 14;BA.debugLine="ABMComp.Visibility = ABM.VISIBILITY_HIDE_ALL ' hi";
_abmcomp.Visibility = _abm.VISIBILITY_HIDE_ALL;
 //BA.debugLineNum = 17;BA.debugLine="Columns.Initialize";
_columns.Initialize();
 //BA.debugLineNum = 18;BA.debugLine="Rows.Initialize";
_rows.Initialize();
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
