package com.zxdemo;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="jo=Me";
Debug.ShouldStop(1073741824);
main.mostCurrent._jo.setObject(main.getObject());
 BA.debugLineNum = 32;BA.debugLine="btn.Initialize(\"btn\")";
Debug.ShouldStop(-2147483648);
main.mostCurrent._btn.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("btn")));
 BA.debugLineNum = 33;BA.debugLine="btn.Text=\"scan\"";
Debug.ShouldStop(1);
main.mostCurrent._btn.runMethod(true,"setText",RemoteObject.createImmutable(("scan")));
 BA.debugLineNum = 34;BA.debugLine="edt.Initialize(\"\")";
Debug.ShouldStop(2);
main.mostCurrent._edt.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 35;BA.debugLine="edt.SingleLine=False";
Debug.ShouldStop(4);
main.mostCurrent._edt.runVoidMethod ("setSingleLine",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 36;BA.debugLine="edt.Gravity=Bit.Xor(Gravity.LEFT,Gravity.TOP)";
Debug.ShouldStop(8);
main.mostCurrent._edt.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Xor",(Object)(main.mostCurrent.__c.getField(false,"Gravity").getField(true,"LEFT")),(Object)(main.mostCurrent.__c.getField(false,"Gravity").getField(true,"TOP"))));
 BA.debugLineNum = 37;BA.debugLine="Activity.AddView(btn,10%x,10%y,80%x,15%y)";
Debug.ShouldStop(16);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._btn.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 15)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 38;BA.debugLine="Activity.AddView(edt,5%x,30%y,90%x,65%y)";
Debug.ShouldStop(32);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._edt.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 5)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 30)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 90)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 65)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,57);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 57;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,53);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 53;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btn_click() throws Exception{
try {
		Debug.PushSubsStack("btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,40);
if (RapidSub.canDelegate("btn_click")) return main.remoteMe.runUserSub(false, "main","btn_click");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _ret = RemoteObject.createImmutable("");
 BA.debugLineNum = 40;BA.debugLine="Sub btn_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 43;BA.debugLine="Dim bmp As Bitmap=LoadBitmap(File.DirAssets,\"ewm.";
Debug.ShouldStop(1024);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp = main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("ewm.png")));Debug.locals.put("bmp", _bmp);Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 44;BA.debugLine="Dim ret As String=jo.RunMethod(\"readQRCode\",Array";
Debug.ShouldStop(2048);
_ret = BA.ObjectToString(main.mostCurrent._jo.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("readQRCode")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_bmp.getObject())}))));Debug.locals.put("ret", _ret);Debug.locals.put("ret", _ret);
 BA.debugLineNum = 45;BA.debugLine="Log(ret)";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(_ret));
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 22;BA.debugLine="Dim btn As Button";
main.mostCurrent._btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim edt As EditText";
main.mostCurrent._edt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim b4azx As Zxing_B4A";
main.mostCurrent._b4azx = RemoteObject.createNew ("ice.zxing.b4aZXingLib");
 //BA.debugLineNum = 25;BA.debugLine="Dim jo As JavaObject";
main.mostCurrent._jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _gotzxresult(RemoteObject _str) throws Exception{
try {
		Debug.PushSubsStack("gotzxresult (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,50);
if (RapidSub.canDelegate("gotzxresult")) return main.remoteMe.runUserSub(false, "main","gotzxresult", _str);
Debug.locals.put("str", _str);
 BA.debugLineNum = 50;BA.debugLine="Sub gotzxresult(str As String)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="edt.Text=str&CRLF&edt.Text";
Debug.ShouldStop(262144);
main.mostCurrent._edt.runMethodAndSync(true,"setText",(RemoteObject.concat(_str,main.mostCurrent.__c.getField(true,"CRLF"),main.mostCurrent._edt.runMethod(true,"getText"))));
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("com.zxdemo.main");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _zx_result(RemoteObject _atype,RemoteObject _values,RemoteObject _bts) throws Exception{
try {
		Debug.PushSubsStack("zx_result (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,47);
if (RapidSub.canDelegate("zx_result")) return main.remoteMe.runUserSub(false, "main","zx_result", _atype, _values, _bts);
Debug.locals.put("atype", _atype);
Debug.locals.put("Values", _values);
Debug.locals.put("bts", _bts);
 BA.debugLineNum = 47;BA.debugLine="Sub zx_result(atype As String,Values As String,bts";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Log(Values)";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(_values));
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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