package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class getsscdata extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.getsscdata", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.getsscdata.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _cmd = "";
public b4j.example.httputils2service _httputils2service = null;
public b4j.example.main _main = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private cmd As String";
_cmd = "";
 //BA.debugLineNum = 4;BA.debugLine="End Sub";
return "";
}
public String  _handle(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
String _num = "";
 //BA.debugLineNum = 10;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
 //BA.debugLineNum = 11;BA.debugLine="cmd=req.GetParameter(\"cmd\").ToLowerCase";
_cmd = _req.GetParameter("cmd").toLowerCase();
 //BA.debugLineNum = 12;BA.debugLine="Select cmd";
switch (BA.switchObjectToInt(_cmd,"1")) {
case 0: {
 //BA.debugLineNum = 14;BA.debugLine="Dim num As String=req.GetParameter(\"num\")";
_num = _req.GetParameter("num");
 //BA.debugLineNum = 15;BA.debugLine="If IsNumber(num) Then Main.num=num";
if (__c.IsNumber(_num)) { 
_main._num = (int)(Double.parseDouble(_num));};
 //BA.debugLineNum = 16;BA.debugLine="resp.Write(Main.getDataJson)";
_resp.Write(_main._getdatajson());
 break; }
}
;
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 6;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
