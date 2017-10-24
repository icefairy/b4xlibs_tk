package b4a.AutoScaleExample7;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class calculator_subs_1 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (calculator) ","calculator",9,calculator.mostCurrent.activityBA,calculator.mostCurrent,19);
if (RapidSub.canDelegate("activity_create")) return b4a.AutoScaleExample7.calculator.remoteMe.runUserSub(false, "calculator","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 19;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 20;BA.debugLine="Activity.LoadLayout(\"calc_main\")";
Debug.ShouldStop(524288);
calculator.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("calc_main")),calculator.mostCurrent.activityBA);
 BA.debugLineNum = 21;BA.debugLine="Activity.Title = \"Calculator\"";
Debug.ShouldStop(1048576);
calculator.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence("Calculator"));
 BA.debugLineNum = 23;BA.debugLine="pnlCalculator.LoadLayout(\"calc_calculator\")";
Debug.ShouldStop(4194304);
calculator.mostCurrent._pnlcalculator.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("calc_calculator")),calculator.mostCurrent.activityBA);
 BA.debugLineNum = 24;BA.debugLine="pnlFunctions.LoadLayout(\"calc_functions\")";
Debug.ShouldStop(8388608);
calculator.mostCurrent._pnlfunctions.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("calc_functions")),calculator.mostCurrent.activityBA);
 BA.debugLineNum = 26;BA.debugLine="pnlFunctions.BringToFront";
Debug.ShouldStop(33554432);
calculator.mostCurrent._pnlfunctions.runVoidMethod ("BringToFront");
 BA.debugLineNum = 45;BA.debugLine="Scale.SetRate(0.8)";
Debug.ShouldStop(4096);
calculator.mostCurrent._scale.runVoidMethod ("_setrate",calculator.mostCurrent.activityBA,(Object)(BA.numberCast(double.class, 0.8)));
 BA.debugLineNum = 50;BA.debugLine="If pnlCalculator.Width + pnlFunctions.Width < Act";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("<",RemoteObject.solve(new RemoteObject[] {calculator.mostCurrent._pnlcalculator.runMethod(true,"getWidth"),calculator.mostCurrent._pnlfunctions.runMethod(true,"getWidth")}, "+",1, 1),BA.numberCast(double.class, calculator.mostCurrent._activity.runMethod(true,"getWidth")))) { 
 BA.debugLineNum = 52;BA.debugLine="pnlCalculator.Left = 50%x - pnlCalculator.Width";
Debug.ShouldStop(524288);
calculator.mostCurrent._pnlcalculator.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {calculator.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),calculator.mostCurrent.activityBA),calculator.mostCurrent._pnlcalculator.runMethod(true,"getWidth")}, "-",1, 1));
 BA.debugLineNum = 53;BA.debugLine="pnlFunctions.Left = 50%x";
Debug.ShouldStop(1048576);
calculator.mostCurrent._pnlfunctions.runMethod(true,"setLeft",calculator.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),calculator.mostCurrent.activityBA));
 BA.debugLineNum = 54;BA.debugLine="pnlFunctions.Visible = True";
Debug.ShouldStop(2097152);
calculator.mostCurrent._pnlfunctions.runMethod(true,"setVisible",calculator.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 55;BA.debugLine="btnFunc.Visible = False";
Debug.ShouldStop(4194304);
calculator.mostCurrent._btnfunc.runMethod(true,"setVisible",calculator.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 58;BA.debugLine="pnlCalculator.Left = (100%x - pnlCalculator.Widt";
Debug.ShouldStop(33554432);
calculator.mostCurrent._pnlcalculator.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {calculator.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),calculator.mostCurrent.activityBA),calculator.mostCurrent._pnlcalculator.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 59;BA.debugLine="pnlCalculator.Top = (100%y - pnlCalculator.Heigh";
Debug.ShouldStop(67108864);
calculator.mostCurrent._pnlcalculator.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {calculator.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),calculator.mostCurrent.activityBA),calculator.mostCurrent._pnlcalculator.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 60;BA.debugLine="pnlFunctions.Left = pnlCalculator.Left";
Debug.ShouldStop(134217728);
calculator.mostCurrent._pnlfunctions.runMethod(true,"setLeft",calculator.mostCurrent._pnlcalculator.runMethod(true,"getLeft"));
 BA.debugLineNum = 61;BA.debugLine="pnlFunctions.Top = pnlCalculator.Top + pnlCalcul";
Debug.ShouldStop(268435456);
calculator.mostCurrent._pnlfunctions.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {calculator.mostCurrent._pnlcalculator.runMethod(true,"getTop"),calculator.mostCurrent._pnlcalculator.runMethod(true,"getHeight"),calculator.mostCurrent._pnlfunctions.runMethod(true,"getHeight")}, "+-",2, 1));
 BA.debugLineNum = 62;BA.debugLine="pnlFunctions.Visible = False";
Debug.ShouldStop(536870912);
calculator.mostCurrent._pnlfunctions.runMethod(true,"setVisible",calculator.mostCurrent.__c.getField(true,"False"));
 };
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (calculator) ","calculator",9,calculator.mostCurrent.activityBA,calculator.mostCurrent,70);
if (RapidSub.canDelegate("activity_pause")) return b4a.AutoScaleExample7.calculator.remoteMe.runUserSub(false, "calculator","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 70;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Activity_Resume (calculator) ","calculator",9,calculator.mostCurrent.activityBA,calculator.mostCurrent,66);
if (RapidSub.canDelegate("activity_resume")) return b4a.AutoScaleExample7.calculator.remoteMe.runUserSub(false, "calculator","activity_resume");
 BA.debugLineNum = 66;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2);
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
public static RemoteObject  _btnfunc_click() throws Exception{
try {
		Debug.PushSubsStack("btnFunc_Click (calculator) ","calculator",9,calculator.mostCurrent.activityBA,calculator.mostCurrent,74);
if (RapidSub.canDelegate("btnfunc_click")) return b4a.AutoScaleExample7.calculator.remoteMe.runUserSub(false, "calculator","btnfunc_click");
 BA.debugLineNum = 74;BA.debugLine="Sub btnFunc_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="pnlFunctions.Visible = Not(pnlFunctions.Visible)";
Debug.ShouldStop(1024);
calculator.mostCurrent._pnlfunctions.runMethod(true,"setVisible",calculator.mostCurrent.__c.runMethod(true,"Not",(Object)(calculator.mostCurrent._pnlfunctions.runMethod(true,"getVisible"))));
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
 //BA.debugLineNum = 14;BA.debugLine="Dim pnlCalculator, pnlFunctions As Panel";
calculator.mostCurrent._pnlcalculator = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
calculator.mostCurrent._pnlfunctions = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Dim lblRegT As Label";
calculator.mostCurrent._lblregt = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim btnFunc As Button";
calculator.mostCurrent._btnfunc = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}