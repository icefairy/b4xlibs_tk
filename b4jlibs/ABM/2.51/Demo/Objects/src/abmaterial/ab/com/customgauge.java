package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class customgauge extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.customgauge", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.customgauge.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public com.ab.abmaterial.ABMCustomComponent _abmcomp = null;
public int _myvalue = 0;
public String _mylabel = "";
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _abmcomp_build(String _internalid) throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="Sub ABMComp_Build(internalID As String) As String";
 //BA.debugLineNum = 38;BA.debugLine="Return $\"<div id=\"${internalID}\"></div><script";
if (true) return ("<div id=\""+__c.SmartStringFormatter("",(Object)(_internalid))+"\"></div><script>var _"+__c.SmartStringFormatter("",(Object)(_internalid))+";</script>");
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_cleanup(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Sub ABMComp_CleanUp(InternalPage As ABMPage, inter";
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_firstrun(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
String _script = "";
 //BA.debugLineNum = 42;BA.debugLine="Sub ABMComp_FirstRun(InternalPage As ABMPage, inte";
 //BA.debugLineNum = 43;BA.debugLine="Dim script As String = $\"_${internalID} = new";
_script = ("_"+__c.SmartStringFormatter("",(Object)(_internalid))+" = new JustGage({\n"+"                             id: \""+__c.SmartStringFormatter("",(Object)(_internalid))+"\",\n"+"                             value: "+__c.SmartStringFormatter("",(Object)(_myvalue))+",\n"+"                             Min: 0,\n"+"                             Max: 100,\n"+"                             relativeGaugeSize: true,\n"+"                             title: \""+__c.SmartStringFormatter("",(Object)(_mylabel))+"\"\n"+"                           });");
 //BA.debugLineNum = 52;BA.debugLine="InternalPage.ws.Eval(script, Array As Object(";
_internalpage.ws.Eval(_script,anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_abmcomp.getID())}));
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_refresh(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
String _script = "";
 //BA.debugLineNum = 57;BA.debugLine="Sub ABMComp_Refresh(InternalPage As ABMPage, inter";
 //BA.debugLineNum = 58;BA.debugLine="Dim script As String = $\"_${internalID}.refresh";
_script = ("_"+__c.SmartStringFormatter("",(Object)(_internalid))+".refresh("+__c.SmartStringFormatter("",(Object)(_myvalue))+");");
 //BA.debugLineNum = 59;BA.debugLine="InternalPage.ws.Eval(script, Null)";
_internalpage.ws.Eval(_script,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 25;BA.debugLine="Public ABMComp As ABMCustomComponent";
_abmcomp = new com.ab.abmaterial.ABMCustomComponent();
 //BA.debugLineNum = 26;BA.debugLine="Public myValue As Int";
_myvalue = 0;
 //BA.debugLineNum = 27;BA.debugLine="Public myLabel As String";
_mylabel = "";
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,com.ab.abmaterial.ABMPage _internalpage,String _id,int _value,String _name) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 31;BA.debugLine="Public Sub Initialize(InternalPage As ABMPage, ID";
 //BA.debugLineNum = 32;BA.debugLine="ABMComp.Initialize(\"ABMComp\", Me, InternalPage";
_abmcomp.Initialize(ba,"ABMComp",this,_internalpage,_id);
 //BA.debugLineNum = 33;BA.debugLine="myValue = value";
_myvalue = _value;
 //BA.debugLineNum = 34;BA.debugLine="myLabel = name";
_mylabel = _name;
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
