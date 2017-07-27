package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class quickstart1 extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.quickstart1", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.quickstart1.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public b4j.example.main _main = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="End Sub";
return "";
}
public String  _handle(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
nz.ope.skeleton.skeletonpage _s = null;
nz.ope.skeleton.sk_column _skc1 = null;
nz.ope.skeleton.skeletonpage._sk_row _r = null;
nz.ope.skeleton.sk_container _c = null;
 //BA.debugLineNum = 10;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
 //BA.debugLineNum = 11;BA.debugLine="Dim S As SkeletonPage";
_s = new nz.ope.skeleton.skeletonpage();
 //BA.debugLineNum = 13;BA.debugLine="Dim skc1 As SK_Column";
_skc1 = new nz.ope.skeleton.sk_column();
 //BA.debugLineNum = 15;BA.debugLine="skc1.Initialize(12)";
_skc1._initialize(ba,(int) (12));
 //BA.debugLineNum = 16;BA.debugLine="skc1.AddHeader(1,\"Header 1\")";
_skc1._addheader((int) (1),"Header 1");
 //BA.debugLineNum = 17;BA.debugLine="skc1.AddHeader(2,\"Header 2\")";
_skc1._addheader((int) (2),"Header 2");
 //BA.debugLineNum = 18;BA.debugLine="skc1.AddHeader(3,\"Header 3\")";
_skc1._addheader((int) (3),"Header 3");
 //BA.debugLineNum = 19;BA.debugLine="skc1.AddHeader(4,\"Header 4\")";
_skc1._addheader((int) (4),"Header 4");
 //BA.debugLineNum = 20;BA.debugLine="skc1.AddContent(\"Lorem Ipsum is simply dummy text";
_skc1._addcontent("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
 //BA.debugLineNum = 22;BA.debugLine="Dim r As SK_Row";
_r = new nz.ope.skeleton.skeletonpage._sk_row();
 //BA.debugLineNum = 23;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 24;BA.debugLine="r.Columns.Initialize";
_r.Columns.Initialize();
 //BA.debugLineNum = 25;BA.debugLine="r.Columns.Add(skc1)";
_r.Columns.Add((Object)(_skc1));
 //BA.debugLineNum = 27;BA.debugLine="Dim c As SK_Container";
_c = new nz.ope.skeleton.sk_container();
 //BA.debugLineNum = 28;BA.debugLine="c.Initialize";
_c._initialize(ba);
 //BA.debugLineNum = 29;BA.debugLine="c.Rows.Initialize";
_c._rows().Initialize();
 //BA.debugLineNum = 30;BA.debugLine="c.Rows.Add(r)";
_c._rows().Add((Object)(_r));
 //BA.debugLineNum = 32;BA.debugLine="S.Initialize";
_s._initialize(ba);
 //BA.debugLineNum = 33;BA.debugLine="S.AddContainer(c)";
_s._addcontainer(_c);
 //BA.debugLineNum = 35;BA.debugLine="resp.Write(S.Render)";
_resp.Write(_s._render());
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
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
