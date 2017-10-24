package b4a.AutoScaleExample7;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class keyboard_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (keyboard) ","keyboard",7,keyboard.mostCurrent.activityBA,keyboard.mostCurrent,16);
if (RapidSub.canDelegate("activity_create")) return b4a.AutoScaleExample7.keyboard.remoteMe.runUserSub(false, "keyboard","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 16;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 17;BA.debugLine="InitKeyboard";
Debug.ShouldStop(65536);
_initkeyboard();
 BA.debugLineNum = 18;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Activity_Pause (keyboard) ","keyboard",7,keyboard.mostCurrent.activityBA,keyboard.mostCurrent,28);
if (RapidSub.canDelegate("activity_pause")) return b4a.AutoScaleExample7.keyboard.remoteMe.runUserSub(false, "keyboard","activity_pause", _userclosed);
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
		Debug.PushSubsStack("Activity_Resume (keyboard) ","keyboard",7,keyboard.mostCurrent.activityBA,keyboard.mostCurrent,20);
if (RapidSub.canDelegate("activity_resume")) return b4a.AutoScaleExample7.keyboard.remoteMe.runUserSub(false, "keyboard","activity_resume");
 BA.debugLineNum = 20;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="Scale.SetRate(0.5)";
Debug.ShouldStop(1048576);
keyboard.mostCurrent._scale.runVoidMethod ("_setrate",keyboard.mostCurrent.activityBA,(Object)(BA.numberCast(double.class, 0.5)));
 BA.debugLineNum = 22;BA.debugLine="Scale.ScaleAll(pnlKeyboard, True)";
Debug.ShouldStop(2097152);
keyboard.mostCurrent._scale.runVoidMethod ("_scaleall",keyboard.mostCurrent.activityBA,(Object)(keyboard.mostCurrent._pnlkeyboard),(Object)(keyboard.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 24;BA.debugLine="pnlKeyboard.Left = 50%x - pnlKeyboard.Width / 2";
Debug.ShouldStop(8388608);
keyboard.mostCurrent._pnlkeyboard.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {keyboard.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),keyboard.mostCurrent.activityBA),keyboard.mostCurrent._pnlkeyboard.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 25;BA.debugLine="pnlKeyboard.Top = 50%y - pnlKeyboard.Height / 2";
Debug.ShouldStop(16777216);
keyboard.mostCurrent._pnlkeyboard.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {keyboard.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 50)),keyboard.mostCurrent.activityBA),keyboard.mostCurrent._pnlkeyboard.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
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
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim pnlKeyboard As Panel";
keyboard.mostCurrent._pnlkeyboard = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initkeyboard() throws Exception{
try {
		Debug.PushSubsStack("InitKeyboard (keyboard) ","keyboard",7,keyboard.mostCurrent.activityBA,keyboard.mostCurrent,33);
if (RapidSub.canDelegate("initkeyboard")) return b4a.AutoScaleExample7.keyboard.remoteMe.runUserSub(false, "keyboard","initkeyboard");
RemoteObject _row = RemoteObject.createImmutable(0);
RemoteObject _col = RemoteObject.createImmutable(0);
RemoteObject _coln = RemoteObject.createImmutable(0);
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _x = RemoteObject.createImmutable(0);
RemoteObject _y = RemoteObject.createImmutable(0);
RemoteObject _space = RemoteObject.createImmutable(0);
RemoteObject _width = RemoteObject.createImmutable(0);
RemoteObject _btnkey = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
 BA.debugLineNum = 33;BA.debugLine="Sub InitKeyboard";
Debug.ShouldStop(1);
 BA.debugLineNum = 34;BA.debugLine="Dim row, col, coln, i As Int";
Debug.ShouldStop(2);
_row = RemoteObject.createImmutable(0);Debug.locals.put("row", _row);
_col = RemoteObject.createImmutable(0);Debug.locals.put("col", _col);
_coln = RemoteObject.createImmutable(0);Debug.locals.put("coln", _coln);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 35;BA.debugLine="Dim x, y, space, width As Int";
Debug.ShouldStop(4);
_x = RemoteObject.createImmutable(0);Debug.locals.put("x", _x);
_y = RemoteObject.createImmutable(0);Debug.locals.put("y", _y);
_space = RemoteObject.createImmutable(0);Debug.locals.put("space", _space);
_width = RemoteObject.createImmutable(0);Debug.locals.put("width", _width);
 BA.debugLineNum = 37;BA.debugLine="width = 60dip";
Debug.ShouldStop(16);
_width = keyboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)));Debug.locals.put("width", _width);
 BA.debugLineNum = 38;BA.debugLine="space = 4dip";
Debug.ShouldStop(32);
_space = keyboard.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)));Debug.locals.put("space", _space);
 BA.debugLineNum = 39;BA.debugLine="pnlKeyboard.Initialize(\"\")";
Debug.ShouldStop(64);
keyboard.mostCurrent._pnlkeyboard.runVoidMethod ("Initialize",keyboard.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 40;BA.debugLine="Activity.AddView(pnlKeyboard, 0, 0, 3 * width + 4";
Debug.ShouldStop(128);
keyboard.mostCurrent._activity.runVoidMethod ("AddView",(Object)((keyboard.mostCurrent._pnlkeyboard.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(3),_width,RemoteObject.createImmutable(4),_space}, "*+*",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(4),_width,RemoteObject.createImmutable(5),_space}, "*+*",1, 1)));
 BA.debugLineNum = 41;BA.debugLine="pnlKeyboard.Color = Colors.Gray";
Debug.ShouldStop(256);
keyboard.mostCurrent._pnlkeyboard.runVoidMethod ("setColor",keyboard.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 BA.debugLineNum = 42;BA.debugLine="i = -1";
Debug.ShouldStop(512);
_i = BA.numberCast(int.class, -(double) (0 + 1));Debug.locals.put("i", _i);
 BA.debugLineNum = 43;BA.debugLine="For row = 0 To 3";
Debug.ShouldStop(1024);
{
final int step9 = 1;
final int limit9 = 3;
_row = BA.numberCast(int.class, 0) ;
for (;(step9 > 0 && _row.<Integer>get().intValue() <= limit9) || (step9 < 0 && _row.<Integer>get().intValue() >= limit9) ;_row = RemoteObject.createImmutable((int)(0 + _row.<Integer>get().intValue() + step9))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 44;BA.debugLine="If row = 0 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_row,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 45;BA.debugLine="coln = 0";
Debug.ShouldStop(4096);
_coln = BA.numberCast(int.class, 0);Debug.locals.put("coln", _coln);
 }else {
 BA.debugLineNum = 47;BA.debugLine="coln = 2";
Debug.ShouldStop(16384);
_coln = BA.numberCast(int.class, 2);Debug.locals.put("coln", _coln);
 };
 BA.debugLineNum = 49;BA.debugLine="x = space";
Debug.ShouldStop(65536);
_x = _space;Debug.locals.put("x", _x);
 BA.debugLineNum = 50;BA.debugLine="y = pnlKeyboard.Height - (row + 1) * (width + sp";
Debug.ShouldStop(131072);
_y = RemoteObject.solve(new RemoteObject[] {keyboard.mostCurrent._pnlkeyboard.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {_row,RemoteObject.createImmutable(1)}, "+",1, 1)),(RemoteObject.solve(new RemoteObject[] {_width,_space}, "+",1, 1))}, "-*",1, 1);Debug.locals.put("y", _y);
 BA.debugLineNum = 51;BA.debugLine="For col = 0 To coln";
Debug.ShouldStop(262144);
{
final int step17 = 1;
final int limit17 = _coln.<Integer>get().intValue();
_col = BA.numberCast(int.class, 0) ;
for (;(step17 > 0 && _col.<Integer>get().intValue() <= limit17) || (step17 < 0 && _col.<Integer>get().intValue() >= limit17) ;_col = RemoteObject.createImmutable((int)(0 + _col.<Integer>get().intValue() + step17))  ) {
Debug.locals.put("col", _col);
 BA.debugLineNum = 52;BA.debugLine="i = i + 1";
Debug.ShouldStop(524288);
_i = RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("i", _i);
 BA.debugLineNum = 53;BA.debugLine="Dim btnKey As Button";
Debug.ShouldStop(1048576);
_btnkey = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("btnKey", _btnkey);
 BA.debugLineNum = 54;BA.debugLine="btnKey.Initialize(\"btnKey\")";
Debug.ShouldStop(2097152);
_btnkey.runVoidMethod ("Initialize",keyboard.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("btnKey")));
 BA.debugLineNum = 55;BA.debugLine="x = space + col *(width + space)";
Debug.ShouldStop(4194304);
_x = RemoteObject.solve(new RemoteObject[] {_space,_col,(RemoteObject.solve(new RemoteObject[] {_width,_space}, "+",1, 1))}, "+*",1, 1);Debug.locals.put("x", _x);
 BA.debugLineNum = 56;BA.debugLine="pnlKeyboard.AddView(btnKey, x, y, width, width)";
Debug.ShouldStop(8388608);
keyboard.mostCurrent._pnlkeyboard.runVoidMethod ("AddView",(Object)((_btnkey.getObject())),(Object)(_x),(Object)(_y),(Object)(_width),(Object)(_width));
 BA.debugLineNum = 57;BA.debugLine="btnKey.TextSize = 24";
Debug.ShouldStop(16777216);
_btnkey.runMethod(true,"setTextSize",BA.numberCast(float.class, 24));
 BA.debugLineNum = 58;BA.debugLine="btnKey.Text = i";
Debug.ShouldStop(33554432);
_btnkey.runMethod(true,"setText",BA.ObjectToCharSequence(_i));
 }
}Debug.locals.put("col", _col);
;
 }
}Debug.locals.put("row", _row);
;
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}