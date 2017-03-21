package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class donatebutton extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.donatebutton", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.donatebutton.class).invoke(this, new Object[] {null});
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
 //BA.debugLineNum = 23;BA.debugLine="Return $\"<a href=\"https://www.paypal.com/cgi-bin/";
if (true) return ("<a href=\"https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&amp;hosted_button_id=WZA72W4ZM9TDC\" target=\"_blank\">Click here to <img src=\"https://www.paypalobjects.com/en_US/BE/i/btn/btn_donateCC_LG.gif\" alt=\"Donation\" /> support ABMaterial</a>");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_cleanup(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Sub ABMComp_CleanUp(InternalPage As ABMPage, inter";
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_firstrun(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub ABMComp_FirstRun(InternalPage As ABMPage, inte";
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public String  _abmcomp_refresh(com.ab.abmaterial.ABMPage _internalpage,String _internalid) throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Sub ABMComp_Refresh(InternalPage As ABMPage, inter";
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Dim ABMComp As ABMCustomComponent";
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
