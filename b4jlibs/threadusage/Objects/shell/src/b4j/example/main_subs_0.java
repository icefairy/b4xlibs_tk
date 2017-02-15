package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _appstart(RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("AppStart (main) ","main",0,main.ba,main.mostCurrent,13);
if (RapidSub.canDelegate("appstart")) return main.remoteMe.runUserSub(false, "main","appstart", _args);
Debug.locals.put("Args", _args);
 BA.debugLineNum = 13;BA.debugLine="Sub AppStart (Args() As String)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 14;BA.debugLine="thd1.Initialise(\"thd1\")";
Debug.ShouldStop(8192);
main._thd1.runVoidMethod ("Initialise",main.ba,(Object)(RemoteObject.createImmutable("thd1")));
 BA.debugLineNum = 15;BA.debugLine="thd1.Name=\"A\"";
Debug.ShouldStop(16384);
main._thd1.runMethod(true,"setName",BA.ObjectToString("A"));
 BA.debugLineNum = 16;BA.debugLine="thd2.Initialise(\"thd2\")";
Debug.ShouldStop(32768);
main._thd2.runVoidMethod ("Initialise",main.ba,(Object)(RemoteObject.createImmutable("thd2")));
 BA.debugLineNum = 17;BA.debugLine="thd2.Name=\"B\"";
Debug.ShouldStop(65536);
main._thd2.runMethod(true,"setName",BA.ObjectToString("B"));
 BA.debugLineNum = 20;BA.debugLine="printint";
Debug.ShouldStop(524288);
_printint();
 BA.debugLineNum = 21;BA.debugLine="thd2.Start(Me,\"printint\",Null)";
Debug.ShouldStop(1048576);
main._thd2.runVoidMethod ("Start",(Object)(main.getObject()),(Object)(BA.ObjectToString("printint")),(Object)((main.__c.getField(false,"Null"))));
 BA.debugLineNum = 22;BA.debugLine="StartMessageLoop";
Debug.ShouldStop(2097152);
main.__c.runVoidMethod ("StartMessageLoop",main.ba);
 BA.debugLineNum = 23;BA.debugLine="End Sub";
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
public static RemoteObject  _endall() throws Exception{
try {
		Debug.PushSubsStack("endall (main) ","main",0,main.ba,main.mostCurrent,38);
if (RapidSub.canDelegate("endall")) return main.remoteMe.runUserSub(false, "main","endall");
 BA.debugLineNum = 38;BA.debugLine="Sub endall";
Debug.ShouldStop(32);
 BA.debugLineNum = 39;BA.debugLine="StopMessageLoop";
Debug.ShouldStop(64);
main.__c.runVoidMethod ("StopMessageLoop",main.ba);
 BA.debugLineNum = 40;BA.debugLine="End Sub";
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
public static RemoteObject  _printint() throws Exception{
try {
		Debug.PushSubsStack("printint (main) ","main",0,main.ba,main.mostCurrent,24);
if (RapidSub.canDelegate("printint")) return main.remoteMe.runUserSub(false, "main","printint");
 BA.debugLineNum = 24;BA.debugLine="Sub printint";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="Do While a>0";
Debug.ShouldStop(16777216);
while (RemoteObject.solveBoolean(">",main._a,BA.numberCast(double.class, 0))) {
 BA.debugLineNum = 26;BA.debugLine="Log(a)";
Debug.ShouldStop(33554432);
main.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(main._a)));
 BA.debugLineNum = 29;BA.debugLine="a=a+1";
Debug.ShouldStop(268435456);
main._a = RemoteObject.solve(new RemoteObject[] {main._a,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 31;BA.debugLine="If a>99 Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean(">",main._a,BA.numberCast(double.class, 99))) { 
 BA.debugLineNum = 32;BA.debugLine="Exit";
Debug.ShouldStop(-2147483648);
if (true) break;
 };
 }
;
 BA.debugLineNum = 35;BA.debugLine="CallSubDelayed(Me,\"endall\")";
Debug.ShouldStop(4);
main.__c.runVoidMethod ("CallSubDelayed",main.ba,(Object)(main.getObject()),(Object)(RemoteObject.createImmutable("endall")));
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4j.example.main");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Dim thd1,thd2 As Thread";
main._thd1 = RemoteObject.createNew ("anywheresoftware.b4a.agraham.threading.Threading");
main._thd2 = RemoteObject.createNew ("anywheresoftware.b4a.agraham.threading.Threading");
 //BA.debugLineNum = 9;BA.debugLine="Dim a=1 As Int";
main._a = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 10;BA.debugLine="Private lck As Lock";
main._lck = RemoteObject.createNew ("anywheresoftware.b4a.agraham.threading.Threading.SemaphoreWrapper");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}