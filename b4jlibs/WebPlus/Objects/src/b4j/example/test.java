package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class test extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.test", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.test.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public b4j.example.wptemplateengine _te = null;
public b4j.example.main _main = null;
public b4j.example.g _g = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private te As WPTemplateEngine";
_te = new b4j.example.wptemplateengine();
 //BA.debugLineNum = 4;BA.debugLine="End Sub";
return "";
}
public String  _handle(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
 //BA.debugLineNum = 11;BA.debugLine="te.bindResponse(resp)";
_te._bindresponse(_resp);
 //BA.debugLineNum = 12;BA.debugLine="te.putData(\"headertitle\",\"WebPlusTitle\")";
_te._putdata("headertitle",(Object)("WebPlusTitle"));
 //BA.debugLineNum = 13;BA.debugLine="te.putData(\"title\",\"网页中的标题\")";
_te._putdata("title",(Object)("网页中的标题"));
 //BA.debugLineNum = 14;BA.debugLine="te.putData(\"bodyhtml\",\"<script>alert('test');</sc";
_te._putdata("bodyhtml",(Object)("<script>alert('test');</script>"));
 //BA.debugLineNum = 15;BA.debugLine="te.putData(\"bodytext\",\"普通的￥文本<br>$3331'\")";
_te._putdata("bodytext",(Object)("普通的￥文本<br>$3331'"));
 //BA.debugLineNum = 16;BA.debugLine="te.putData(\"my\",CreateMap(\"username\":\"icefairy\",\"";
_te._putdata("my",(Object)(__c.createMap(new Object[] {(Object)("username"),(Object)("icefairy"),(Object)("comefrom"),(Object)("China")}).getObject()));
 //BA.debugLineNum = 17;BA.debugLine="te.putData(\"footertext\",\"关于我们（尾部）\")";
_te._putdata("footertext",(Object)("关于我们（尾部）"));
 //BA.debugLineNum = 18;BA.debugLine="te.renderTPL(\"/live/live\")";
_te._rendertpl("/live/live");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 6;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 7;BA.debugLine="te.Initialize";
_te._initialize(ba);
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
