package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class abmsessioncreator_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _filter(RemoteObject __ref,RemoteObject _req,RemoteObject _resp) throws Exception{
try {
		Debug.PushSubsStack("Filter (abmsessioncreator) ","abmsessioncreator",6,__ref.getField(false, "ba"),__ref,11);
if (RapidSub.canDelegate("filter")) return __ref.runUserSub(false, "abmsessioncreator","filter", __ref, _req, _resp);
Debug.locals.put("req", _req);
Debug.locals.put("resp", _resp);
 BA.debugLineNum = 11;BA.debugLine="Public Sub Filter(req As ServletRequest, resp As S";
Debug.ShouldStop(1024);
 BA.debugLineNum = 12;BA.debugLine="DateTime.DateFormat = \"dd/MM/yyyy\"";
Debug.ShouldStop(2048);
abmsessioncreator.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("dd/MM/yyyy"));
 BA.debugLineNum = 13;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
Debug.ShouldStop(4096);
abmsessioncreator.__c.getField(false,"DateTime").runMethod(true,"setTimeFormat",BA.ObjectToString("HH:mm"));
 BA.debugLineNum = 15;BA.debugLine="Log(\"In filter: \" & DateTime.Date(DateTime.Now) &";
Debug.ShouldStop(16384);
abmsessioncreator.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("In filter: "),abmsessioncreator.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(abmsessioncreator.__c.getField(false,"DateTime").runMethod(true,"getNow"))),RemoteObject.createImmutable(" "),abmsessioncreator.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(abmsessioncreator.__c.getField(false,"DateTime").runMethod(true,"getNow"))))));
 BA.debugLineNum = 17;BA.debugLine="req.GetSession  'a new session will be created if";
Debug.ShouldStop(65536);
_req.runVoidMethod ("GetSession");
 BA.debugLineNum = 18;BA.debugLine="Return True";
Debug.ShouldStop(131072);
if (true) return abmsessioncreator.__c.getField(true,"True");
 BA.debugLineNum = 19;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (abmsessioncreator) ","abmsessioncreator",6,__ref.getField(false, "ba"),__ref,6);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "abmsessioncreator","initialize", __ref, _ba);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 6;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(32);
 BA.debugLineNum = 8;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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