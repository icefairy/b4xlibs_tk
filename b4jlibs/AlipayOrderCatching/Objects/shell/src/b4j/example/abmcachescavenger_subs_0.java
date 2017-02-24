package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class abmcachescavenger_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private scavengeTimer As Timer";
abmcachescavenger._scavengetimer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");__ref.setField("_scavengetimer",abmcachescavenger._scavengetimer);
 //BA.debugLineNum = 4;BA.debugLine="Private ABM As ABMaterial";
abmcachescavenger._abm = RemoteObject.createNew ("com.ab.abmaterial.ABMaterial");__ref.setField("_abm",abmcachescavenger._abm);
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (abmcachescavenger) ","abmcachescavenger",7,__ref.getField(false, "ba"),__ref,7);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "abmcachescavenger","initialize", __ref, _ba);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 7;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(64);
 BA.debugLineNum = 8;BA.debugLine="scavengeTimer.Initialize(\"ScavengeTimer\", ABMSha";
Debug.ShouldStop(128);
__ref.getField(false,"_scavengetimer").runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("ScavengeTimer")),(Object)(BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {abmcachescavenger._abmshared._cachescavengeperiodseconds,RemoteObject.createImmutable(1000)}, "*",0, 1))));
 BA.debugLineNum = 9;BA.debugLine="scavengeTimer.Enabled = True";
Debug.ShouldStop(256);
__ref.getField(false,"_scavengetimer").runMethod(true,"setEnabled",abmcachescavenger.__c.getField(true,"True"));
 BA.debugLineNum = 10;BA.debugLine="StartMessageLoop '<- don't forget!";
Debug.ShouldStop(512);
abmcachescavenger.__c.runVoidMethod ("StartMessageLoop",__ref.getField(false, "ba"));
 BA.debugLineNum = 11;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scavengetimer_tick(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("ScavengeTimer_Tick (abmcachescavenger) ","abmcachescavenger",7,__ref.getField(false, "ba"),__ref,13);
if (RapidSub.canDelegate("scavengetimer_tick")) return __ref.runUserSub(false, "abmcachescavenger","scavengetimer_tick", __ref);
 BA.debugLineNum = 13;BA.debugLine="Sub ScavengeTimer_Tick";
Debug.ShouldStop(4096);
 BA.debugLineNum = 15;BA.debugLine="ABM.ScavengeCache(ABMShared.CachedPages)";
Debug.ShouldStop(16384);
__ref.getField(false,"_abm").runVoidMethod ("ScavengeCache",(Object)(abmcachescavenger._abmshared._cachedpages));
 BA.debugLineNum = 16;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}