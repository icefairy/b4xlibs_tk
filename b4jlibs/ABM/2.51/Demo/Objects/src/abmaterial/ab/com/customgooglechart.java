package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class customgooglechart extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.customgooglechart", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.customgooglechart.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public com.ab.abmaterial.ABMCustomComponent _abmcomp = null;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _abmcomp_build(String _internalid) throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub ABMComp_Build(internalID As String) As String";
 //BA.debugLineNum = 23;BA.debugLine="Return $\"<div id=\"myPieChart\"></div>\"$";
if (true) return ("<div id=\"myPieChart\"></div>");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_cleanup(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Sub ABMComp_CleanUp(InternalPage As ABMPage, inter";
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_firstrun(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
String _script = "";
 //BA.debugLineNum = 27;BA.debugLine="Sub ABMComp_FirstRun(InternalPage As ABMPage, inte";
 //BA.debugLineNum = 28;BA.debugLine="Dim script As String = $\"google.charts.load('curr";
_script = ("google.charts.load('current', {packages: ['corechart']});\n"+"    google.charts.setOnLoadCallback(drawChart);\n"+"\n"+"    function drawChart() {\n"+"      // Define the chart to be drawn.\n"+"      var data = new google.visualization.DataTable();\n"+"      data.addColumn('string', 'Element');\n"+"      data.addColumn('number', 'Percentage');\n"+"      data.addRows([\n"+"        ['Nitrogen', 0.78],\n"+"        ['Oxygen', 0.21],\n"+"        ['Other', 0.01]\n"+"      ]);\n"+"\n"+"      // Instantiate and draw the chart.\n"+"      var chart = new google.visualization.PieChart(document.getElementById('myPieChart'));\n"+"      chart.draw(data, null);\n"+"	  }\n"+"");
 //BA.debugLineNum = 48;BA.debugLine="InternalPage.ws.Eval(script, Array As Object(ABM";
_internalpage.ws.Eval(_script,anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_abmcomp.getID())}));
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_refresh(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Sub ABMComp_Refresh(InternalPage As ABMPage, inter";
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Dim ABMComp As ABMCustomComponent";
_abmcomp = new com.ab.abmaterial.ABMCustomComponent();
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,com.ab.abmaterial.ABMPage _internalpage,String _id) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize(InternalPage As ABMPage, ID";
 //BA.debugLineNum = 10;BA.debugLine="ABMComp.Initialize(\"ABMComp\", Me, InternalPage, I";
_abmcomp.Initialize(ba,"ABMComp",this,_internalpage,_id);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
