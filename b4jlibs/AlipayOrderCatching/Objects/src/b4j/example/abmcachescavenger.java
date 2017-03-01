package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class abmcachescavenger extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.ShellBA("b4j.example", "b4j.example.abmcachescavenger", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.abmcachescavenger.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.Timer _scavengetimer = null;
public com.ab.abmaterial.ABMaterial _abm = null;
public b4j.example.main _main = null;
public b4j.example.abmshared _abmshared = null;
public b4j.example.dbm _dbm = null;
public String  _class_globals(b4j.example.abmcachescavenger __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmcachescavenger";
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="Private scavengeTimer As Timer";
_scavengetimer = new anywheresoftware.b4a.objects.Timer();
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="Private ABM As ABMaterial";
_abm = new com.ab.abmaterial.ABMaterial();
RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4j.example.abmcachescavenger __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="abmcachescavenger";
if (Debug.shouldDelegate(ba, "initialize"))
	return (String) Debug.delegate(ba, "initialize", new Object[] {_ba});
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="scavengeTimer.Initialize(\"ScavengeTimer\", ABMSha";
__ref._scavengetimer.Initialize(ba,"ScavengeTimer",(long) (_abmshared._cachescavengeperiodseconds*1000));
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="scavengeTimer.Enabled = True";
__ref._scavengetimer.setEnabled(__c.True);
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="StartMessageLoop '<- don't forget!";
__c.StartMessageLoop(ba);
RDebugUtils.currentLine=4653060;
 //BA.debugLineNum = 4653060;BA.debugLine="End Sub";
return "";
}
public String  _scavengetimer_tick(b4j.example.abmcachescavenger __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmcachescavenger";
if (Debug.shouldDelegate(ba, "scavengetimer_tick"))
	return (String) Debug.delegate(ba, "scavengetimer_tick", null);
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub ScavengeTimer_Tick";
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="ABM.ScavengeCache(ABMShared.CachedPages)";
__ref._abm.ScavengeCache(_abmshared._cachedpages);
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="End Sub";
return "";
}
}