package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class abmcachescavenger extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.abmcachescavenger", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.abmcachescavenger.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.Timer _scavengetimer = null;
public com.ab.abmaterial.ABMaterial _abm = null;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private scavengeTimer As Timer";
_scavengetimer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 4;BA.debugLine="Private ABM As ABMaterial";
_abm = new com.ab.abmaterial.ABMaterial();
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 7;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 8;BA.debugLine="scavengeTimer.Initialize(\"ScavengeTimer\", ABMSha";
_scavengetimer.Initialize(ba,"ScavengeTimer",(long) (_abmshared._cachescavengeperiodseconds*1000));
 //BA.debugLineNum = 9;BA.debugLine="scavengeTimer.Enabled = True";
_scavengetimer.setEnabled(__c.True);
 //BA.debugLineNum = 10;BA.debugLine="StartMessageLoop '<- don't forget!";
__c.StartMessageLoop(ba);
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public String  _scavengetimer_tick() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub ScavengeTimer_Tick";
 //BA.debugLineNum = 15;BA.debugLine="ABM.ScavengeCache(ABMShared.CachedPages)";
_abm.ScavengeCache(_abmshared._cachedpages);
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
