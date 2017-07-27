package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class demo extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.demo", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.demo.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public nz.ope.skeleton.sk_helper _h = null;
public nz.ope.skeleton.sk_fontawesomeicon _f = null;
public b4j.example.main _main = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim h As SK_Helper";
_h = new nz.ope.skeleton.sk_helper();
 //BA.debugLineNum = 4;BA.debugLine="Dim f As SK_FontAwesomeIcon";
_f = new nz.ope.skeleton.sk_fontawesomeicon();
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return "";
}
public String  _handle(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
nz.ope.skeleton.sk_column _skc1 = null;
nz.ope.skeleton.skeletonpage._sk_row _row1 = null;
nz.ope.skeleton.sk_column _skc2a = null;
nz.ope.skeleton.sk_column _skc2b = null;
nz.ope.skeleton.sk_column _skc2c = null;
nz.ope.skeleton.skeletonpage._sk_row _row2 = null;
nz.ope.skeleton.sk_container _c1 = null;
nz.ope.skeleton.sk_container _c2 = null;
nz.ope.skeleton.skeletonpage _s = null;
 //BA.debugLineNum = 12;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
 //BA.debugLineNum = 13;BA.debugLine="Dim skc1 As SK_Column";
_skc1 = new nz.ope.skeleton.sk_column();
 //BA.debugLineNum = 14;BA.debugLine="skc1.Initialize(12)";
_skc1._initialize(ba,(int) (12));
 //BA.debugLineNum = 15;BA.debugLine="skc1.AddHeader(2,\"A dead simple, responsive boile";
_skc1._addheader((int) (2),"A dead simple, responsive boilerplate.");
 //BA.debugLineNum = 16;BA.debugLine="skc1.AddAnchorButton(\"Download\",True,\"https://git";
_skc1._addanchorbutton("Download",__c.True,"https://github.com/dhg/Skeleton/releases/download/2.0.4/Skeleton-2.0.4.zip");
 //BA.debugLineNum = 18;BA.debugLine="Dim row1 As SK_Row";
_row1 = new nz.ope.skeleton.skeletonpage._sk_row();
 //BA.debugLineNum = 19;BA.debugLine="row1.Initialize";
_row1.Initialize();
 //BA.debugLineNum = 20;BA.debugLine="row1.Columns.Initialize";
_row1.Columns.Initialize();
 //BA.debugLineNum = 21;BA.debugLine="row1.Columns.Add(skc1)";
_row1.Columns.Add((Object)(_skc1));
 //BA.debugLineNum = 23;BA.debugLine="Dim skc2a As SK_Column";
_skc2a = new nz.ope.skeleton.sk_column();
 //BA.debugLineNum = 24;BA.debugLine="Dim skc2b As SK_Column";
_skc2b = new nz.ope.skeleton.sk_column();
 //BA.debugLineNum = 25;BA.debugLine="Dim skc2c As SK_Column";
_skc2c = new nz.ope.skeleton.sk_column();
 //BA.debugLineNum = 27;BA.debugLine="skc2a.Initialize(4)";
_skc2a._initialize(ba,(int) (4));
 //BA.debugLineNum = 28;BA.debugLine="skc2b.Initialize(4)";
_skc2b._initialize(ba,(int) (4));
 //BA.debugLineNum = 29;BA.debugLine="skc2c.Initialize(4)";
_skc2c._initialize(ba,(int) (4));
 //BA.debugLineNum = 31;BA.debugLine="skc2a.AddImage(\"images/feather.svg\")";
_skc2a._addimage("images/feather.svg");
 //BA.debugLineNum = 32;BA.debugLine="skc2a.AddContent(\"Light as a feather at ~400 line";
_skc2a._addcontent("Light as a feather at ~400 lines & built with mobile in mind.");
 //BA.debugLineNum = 34;BA.debugLine="skc2b.AddImage(\"images/pens.svg\")";
_skc2b._addimage("images/pens.svg");
 //BA.debugLineNum = 35;BA.debugLine="skc2b.AddContent(\"Styles designed to be a startin";
_skc2b._addcontent("Styles designed to be a starting point, not a UI framework.");
 //BA.debugLineNum = 37;BA.debugLine="skc2c.AddImage(\"images/watch.svg\")";
_skc2c._addimage("images/watch.svg");
 //BA.debugLineNum = 38;BA.debugLine="skc2c.AddContent(\"Quick to start with zero compil";
_skc2c._addcontent("Quick to start with zero compiling or installing necessary.");
 //BA.debugLineNum = 40;BA.debugLine="Dim row2 As SK_Row";
_row2 = new nz.ope.skeleton.skeletonpage._sk_row();
 //BA.debugLineNum = 41;BA.debugLine="row2.Initialize";
_row2.Initialize();
 //BA.debugLineNum = 42;BA.debugLine="row2.Columns.Initialize";
_row2.Columns.Initialize();
 //BA.debugLineNum = 43;BA.debugLine="row2.Columns.Add(skc2a)";
_row2.Columns.Add((Object)(_skc2a));
 //BA.debugLineNum = 44;BA.debugLine="row2.Columns.Add(skc2b)";
_row2.Columns.Add((Object)(_skc2b));
 //BA.debugLineNum = 45;BA.debugLine="row2.Columns.Add(skc2c)";
_row2.Columns.Add((Object)(_skc2c));
 //BA.debugLineNum = 47;BA.debugLine="Dim c1 As SK_Container";
_c1 = new nz.ope.skeleton.sk_container();
 //BA.debugLineNum = 48;BA.debugLine="c1.Initialize";
_c1._initialize(ba);
 //BA.debugLineNum = 49;BA.debugLine="c1.Align = \"center\"";
_c1._setalign("center");
 //BA.debugLineNum = 50;BA.debugLine="c1.MarginTop = 18";
_c1._setmargintop((int) (18));
 //BA.debugLineNum = 51;BA.debugLine="c1.Rows.Initialize";
_c1._rows().Initialize();
 //BA.debugLineNum = 52;BA.debugLine="c1.Rows.Add(row1)";
_c1._rows().Add((Object)(_row1));
 //BA.debugLineNum = 54;BA.debugLine="Dim c2 As SK_Container";
_c2 = new nz.ope.skeleton.sk_container();
 //BA.debugLineNum = 55;BA.debugLine="c2.Initialize";
_c2._initialize(ba);
 //BA.debugLineNum = 56;BA.debugLine="c2.Align = \"center\"";
_c2._setalign("center");
 //BA.debugLineNum = 57;BA.debugLine="c2.MarginTop = 3";
_c2._setmargintop((int) (3));
 //BA.debugLineNum = 58;BA.debugLine="c2.Padding = 1";
_c2._setpadding((int) (1));
 //BA.debugLineNum = 59;BA.debugLine="c2.Rows.Initialize";
_c2._rows().Initialize();
 //BA.debugLineNum = 60;BA.debugLine="c2.Rows.Add(row2)";
_c2._rows().Add((Object)(_row2));
 //BA.debugLineNum = 62;BA.debugLine="Dim S As SkeletonPage";
_s = new nz.ope.skeleton.skeletonpage();
 //BA.debugLineNum = 63;BA.debugLine="S.Initialize";
_s._initialize(ba);
 //BA.debugLineNum = 65;BA.debugLine="S.AddContainer(c1)";
_s._addcontainer(_c1);
 //BA.debugLineNum = 66;BA.debugLine="S.AddContainer(c2)";
_s._addcontainer(_c2);
 //BA.debugLineNum = 67;BA.debugLine="resp.Write(S.Render)";
_resp.Write(_s._render());
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 7;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 8;BA.debugLine="h.Initialize";
_h._initialize(ba);
 //BA.debugLineNum = 9;BA.debugLine="f.Initialize";
_f._initialize(ba);
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
