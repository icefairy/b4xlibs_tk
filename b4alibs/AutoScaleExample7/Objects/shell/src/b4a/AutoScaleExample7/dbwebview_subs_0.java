package b4a.AutoScaleExample7;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class dbwebview_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (dbwebview) ","dbwebview",4,dbwebview.mostCurrent.activityBA,dbwebview.mostCurrent,17);
if (RapidSub.canDelegate("activity_create")) return b4a.AutoScaleExample7.dbwebview.remoteMe.runUserSub(false, "dbwebview","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 17;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 18;BA.debugLine="wbwTable.Initialize(\"wbwTable\")";
Debug.ShouldStop(131072);
dbwebview.mostCurrent._wbwtable.runVoidMethod ("Initialize",dbwebview.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("wbwTable")));
 BA.debugLineNum = 19;BA.debugLine="Activity.AddView(wbwTable, 0, 0, 100%x, 100%y)";
Debug.ShouldStop(262144);
dbwebview.mostCurrent._activity.runVoidMethod ("AddView",(Object)((dbwebview.mostCurrent._wbwtable.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(dbwebview.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),dbwebview.mostCurrent.activityBA)),(Object)(dbwebview.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),dbwebview.mostCurrent.activityBA)));
 BA.debugLineNum = 21;BA.debugLine="ShowTableInWebView";
Debug.ShouldStop(1048576);
_showtableinwebview();
 BA.debugLineNum = 22;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (dbwebview) ","dbwebview",4,dbwebview.mostCurrent.activityBA,dbwebview.mostCurrent,28);
if (RapidSub.canDelegate("activity_pause")) return b4a.AutoScaleExample7.dbwebview.remoteMe.runUserSub(false, "dbwebview","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 28;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (dbwebview) ","dbwebview",4,dbwebview.mostCurrent.activityBA,dbwebview.mostCurrent,24);
if (RapidSub.canDelegate("activity_resume")) return b4a.AutoScaleExample7.dbwebview.remoteMe.runUserSub(false, "dbwebview","activity_resume");
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 14;BA.debugLine="Dim wbwTable As WebView";
dbwebview.mostCurrent._wbwtable = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _showtableinwebview() throws Exception{
try {
		Debug.PushSubsStack("ShowTableInWebView (dbwebview) ","dbwebview",4,dbwebview.mostCurrent.activityBA,dbwebview.mostCurrent,32);
if (RapidSub.canDelegate("showtableinwebview")) return b4a.AutoScaleExample7.dbwebview.remoteMe.runUserSub(false, "dbwebview","showtableinwebview");
RemoteObject _txt = RemoteObject.createImmutable("");
 BA.debugLineNum = 32;BA.debugLine="Sub ShowTableInWebView";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="Dim txt As String";
Debug.ShouldStop(1);
_txt = RemoteObject.createImmutable("");Debug.locals.put("txt", _txt);
 BA.debugLineNum = 35;BA.debugLine="txt = \"SELECT ID, FirstName As [First name], Last";
Debug.ShouldStop(4);
_txt = RemoteObject.concat(RemoteObject.createImmutable("SELECT ID, FirstName As [First name], LastName As Name, Address, City FROM "),dbwebview.mostCurrent._main._dbtablename);Debug.locals.put("txt", _txt);
 BA.debugLineNum = 41;BA.debugLine="wbwTable.LoadHtml(DBUtils.ExecuteHtml2(Main.SQL1,";
Debug.ShouldStop(256);
dbwebview.mostCurrent._wbwtable.runVoidMethod ("LoadHtml",(Object)(dbwebview.mostCurrent._dbutils.runMethod(true,"_executehtml2",dbwebview.mostCurrent.activityBA,(Object)(dbwebview.mostCurrent._main._sql1),(Object)(_txt),(Object)((dbwebview.mostCurrent.__c.getField(false,"Null"))),(Object)(BA.numberCast(int.class, 0)),(Object)(dbwebview.mostCurrent.__c.getField(true,"True")),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(16),dbwebview.mostCurrent._scale.runMethod(true,"_getscalex",dbwebview.mostCurrent.activityBA)}, "*",0, 0))))));
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}