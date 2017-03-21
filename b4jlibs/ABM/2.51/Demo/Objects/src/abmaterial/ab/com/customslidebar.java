package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class customslidebar extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.customslidebar", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.customslidebar.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public com.ab.abmaterial.ABMCustomComponent _abmcomp = null;
public double _myvalue = 0;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _abmcomp_build(String _internalid) throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub ABMComp_Build(internalID As String) As String";
 //BA.debugLineNum = 24;BA.debugLine="Return $\"<div id=\"mycustomslider\" style=\"height:2";
if (true) return ("<div id=\"mycustomslider\" style=\"height:200px\" ></div>");
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_cleanup(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
 //BA.debugLineNum = 76;BA.debugLine="Sub ABMComp_CleanUp(InternalPage As ABMPage, inter";
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_firstrun(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
String _script = "";
 //BA.debugLineNum = 28;BA.debugLine="Sub ABMComp_FirstRun(InternalPage As ABMPage, inte";
 //BA.debugLineNum = 29;BA.debugLine="Dim script As String = $\"var mycustomslider = doc";
_script = ("var mycustomslider = document.getElementById('mycustomslider');\n"+"	                         noUiSlider.create(mycustomslider, {\n"+"							    start: ["+__c.SmartStringFormatter("",(Object)(_myvalue))+"],\n"+"								connect: false,\n"+"								step: 1.0,\n"+"								orientation: 'vertical',\n"+"								direction: 'ltr',\n"+"								range: {\n"+"								  'min': 0.0,\n"+"								  'max':100.0\n"+"								},\n"+"								format: wNumb({ decimals: 0 }\n"+"							 )});\n"+"							 mycustomslider.noUiSlider.on('change', function( values, handle ){\n"+"							    b4j_raiseEvent('"+__c.SmartStringFormatter("",(Object)(_abmcomp.getID()))+"_changed', {'value':values[handle]});\n"+"						  	 });");
 //BA.debugLineNum = 46;BA.debugLine="InternalPage.ws.Eval(script, Array As Object(ABM";
_internalpage.ws.Eval(_script,anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_abmcomp.getID())}));
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_refresh(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
String _script = "";
 //BA.debugLineNum = 51;BA.debugLine="Sub ABMComp_Refresh(InternalPage As ABMPage, inter";
 //BA.debugLineNum = 70;BA.debugLine="Dim script As String = $\"var mycustomslider = doc";
_script = ("var mycustomslider = document.getElementById('mycustomslider');\n"+"						     mycustomslider.noUiSlider.set("+__c.SmartStringFormatter("",(Object)(_myvalue))+");");
 //BA.debugLineNum = 72;BA.debugLine="InternalPage.ws.Eval(script, Null)";
_internalpage.ws.Eval(_script,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Dim ABMComp As ABMCustomComponent";
_abmcomp = new com.ab.abmaterial.ABMCustomComponent();
 //BA.debugLineNum = 6;BA.debugLine="Private myValue As Double";
_myvalue = 0;
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,com.ab.abmaterial.ABMPage _internalpage,String _id,double _value) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 10;BA.debugLine="Public Sub Initialize(InternalPage As ABMPage, ID";
 //BA.debugLineNum = 11;BA.debugLine="ABMComp.Initialize(\"ABMComp\", Me, InternalPage, I";
_abmcomp.Initialize(ba,"ABMComp",this,_internalpage,_id);
 //BA.debugLineNum = 14;BA.debugLine="myValue = value";
_myvalue = _value;
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(double _value) throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Public Sub SetValue(Value As Double)";
 //BA.debugLineNum = 81;BA.debugLine="myValue = Value";
_myvalue = _value;
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
