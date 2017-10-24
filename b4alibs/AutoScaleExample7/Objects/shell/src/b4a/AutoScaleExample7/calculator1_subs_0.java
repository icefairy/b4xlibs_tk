package b4a.AutoScaleExample7;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class calculator1_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (calculator1) ","calculator1",10,calculator1.mostCurrent.activityBA,calculator1.mostCurrent,20);
if (RapidSub.canDelegate("activity_create")) return b4a.AutoScaleExample7.calculator1.remoteMe.runUserSub(false, "calculator1","activity_create", _firsttime);
RemoteObject _ph = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 20;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="Activity.LoadLayout(\"calc1_main\")";
Debug.ShouldStop(1048576);
calculator1.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("calc1_main")),calculator1.mostCurrent.activityBA);
 BA.debugLineNum = 22;BA.debugLine="Activity.Title = \"Calculator1\"";
Debug.ShouldStop(2097152);
calculator1.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence("Calculator1"));
 BA.debugLineNum = 24;BA.debugLine="pnlCalculator.LoadLayout(\"calc1_calculator\")";
Debug.ShouldStop(8388608);
calculator1.mostCurrent._pnlcalculator.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("calc1_calculator")),calculator1.mostCurrent.activityBA);
 BA.debugLineNum = 25;BA.debugLine="pnlFunctions.LoadLayout(\"calc1_functions\")";
Debug.ShouldStop(16777216);
calculator1.mostCurrent._pnlfunctions.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("calc1_functions")),calculator1.mostCurrent.activityBA);
 BA.debugLineNum = 27;BA.debugLine="pnlFunctions.BringToFront";
Debug.ShouldStop(67108864);
calculator1.mostCurrent._pnlfunctions.runVoidMethod ("BringToFront");
 BA.debugLineNum = 29;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(268435456);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 30;BA.debugLine="Dim ph As Phone";
Debug.ShouldStop(536870912);
_ph = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("ph", _ph);
 BA.debugLineNum = 32;BA.debugLine="If pnlCalculator.Height > (Min(Activity.Width, A";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean(">",calculator1.mostCurrent._pnlcalculator.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {calculator1.mostCurrent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, calculator1.mostCurrent._activity.runMethod(true,"getWidth"))),(Object)(BA.numberCast(double.class, calculator1.mostCurrent._activity.runMethod(true,"getHeight")))),calculator1.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 0)))) { 
 BA.debugLineNum = 34;BA.debugLine="ph.SetScreenOrientation(1)";
Debug.ShouldStop(2);
_ph.runVoidMethod ("SetScreenOrientation",calculator1.processBA,(Object)(BA.numberCast(int.class, 1)));
 }else {
 BA.debugLineNum = 37;BA.debugLine="ph.SetScreenOrientation(-1)";
Debug.ShouldStop(16);
_ph.runVoidMethod ("SetScreenOrientation",calculator1.processBA,(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 };
 };
 BA.debugLineNum = 42;BA.debugLine="If Activity.Width > pnlCalculator.Width + pnlFunc";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean(">",calculator1.mostCurrent._activity.runMethod(true,"getWidth"),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {calculator1.mostCurrent._pnlcalculator.runMethod(true,"getWidth"),calculator1.mostCurrent._pnlfunctions.runMethod(true,"getWidth")}, "+",1, 1)))) { 
 BA.debugLineNum = 44;BA.debugLine="pnlCalculator.Left = 50%x - pnlCalculator.Width";
Debug.ShouldStop(2048);
calculator1.mostCurrent._pnlcalculator.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {calculator1.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),calculator1.mostCurrent.activityBA),calculator1.mostCurrent._pnlcalculator.runMethod(true,"getWidth")}, "-",1, 1));
 BA.debugLineNum = 45;BA.debugLine="pnlFunctions.Left = 50%x";
Debug.ShouldStop(4096);
calculator1.mostCurrent._pnlfunctions.runMethod(true,"setLeft",calculator1.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),calculator1.mostCurrent.activityBA));
 BA.debugLineNum = 46;BA.debugLine="pnlFunctions.Visible = True";
Debug.ShouldStop(8192);
calculator1.mostCurrent._pnlfunctions.runMethod(true,"setVisible",calculator1.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 47;BA.debugLine="btnFunc.Visible = False";
Debug.ShouldStop(16384);
calculator1.mostCurrent._btnfunc.runMethod(true,"setVisible",calculator1.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 50;BA.debugLine="pnlCalculator.Left = (100%x - pnlCalculator.Widt";
Debug.ShouldStop(131072);
calculator1.mostCurrent._pnlcalculator.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {calculator1.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),calculator1.mostCurrent.activityBA),calculator1.mostCurrent._pnlcalculator.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 51;BA.debugLine="pnlCalculator.Top = (100%y - pnlCalculator.Heigh";
Debug.ShouldStop(262144);
calculator1.mostCurrent._pnlcalculator.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {calculator1.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),calculator1.mostCurrent.activityBA),calculator1.mostCurrent._pnlcalculator.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 52;BA.debugLine="pnlFunctions.Left = pnlCalculator.Left";
Debug.ShouldStop(524288);
calculator1.mostCurrent._pnlfunctions.runMethod(true,"setLeft",calculator1.mostCurrent._pnlcalculator.runMethod(true,"getLeft"));
 BA.debugLineNum = 53;BA.debugLine="pnlFunctions.Top = pnlCalculator.Top + pnlCalcul";
Debug.ShouldStop(1048576);
calculator1.mostCurrent._pnlfunctions.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {calculator1.mostCurrent._pnlcalculator.runMethod(true,"getTop"),calculator1.mostCurrent._pnlcalculator.runMethod(true,"getHeight"),calculator1.mostCurrent._pnlfunctions.runMethod(true,"getHeight")}, "+-",2, 1));
 BA.debugLineNum = 54;BA.debugLine="pnlFunctions.Visible = False";
Debug.ShouldStop(2097152);
calculator1.mostCurrent._pnlfunctions.runMethod(true,"setVisible",calculator1.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("Activity_Pause (calculator1) ","calculator1",10,calculator1.mostCurrent.activityBA,calculator1.mostCurrent,62);
if (RapidSub.canDelegate("activity_pause")) return b4a.AutoScaleExample7.calculator1.remoteMe.runUserSub(false, "calculator1","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 62;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Resume (calculator1) ","calculator1",10,calculator1.mostCurrent.activityBA,calculator1.mostCurrent,58);
if (RapidSub.canDelegate("activity_resume")) return b4a.AutoScaleExample7.calculator1.remoteMe.runUserSub(false, "calculator1","activity_resume");
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnfunc_click() throws Exception{
try {
		Debug.PushSubsStack("btnFunc_Click (calculator1) ","calculator1",10,calculator1.mostCurrent.activityBA,calculator1.mostCurrent,66);
if (RapidSub.canDelegate("btnfunc_click")) return b4a.AutoScaleExample7.calculator1.remoteMe.runUserSub(false, "calculator1","btnfunc_click");
 BA.debugLineNum = 66;BA.debugLine="Sub btnFunc_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="pnlFunctions.Visible = Not(pnlFunctions.Visible)";
Debug.ShouldStop(4);
calculator1.mostCurrent._pnlfunctions.runMethod(true,"setVisible",calculator1.mostCurrent.__c.runMethod(true,"Not",(Object)(calculator1.mostCurrent._pnlfunctions.runMethod(true,"getVisible"))));
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Dim pnlCalculator, pnlFunctions As Panel";
calculator1.mostCurrent._pnlcalculator = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
calculator1.mostCurrent._pnlfunctions = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim btnFunc As Button";
calculator1.mostCurrent._btnfunc = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}