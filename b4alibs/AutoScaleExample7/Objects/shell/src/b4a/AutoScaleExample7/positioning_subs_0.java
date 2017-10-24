package b4a.AutoScaleExample7;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class positioning_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (positioning) ","positioning",11,positioning.mostCurrent.activityBA,positioning.mostCurrent,17);
if (RapidSub.canDelegate("activity_create")) return b4a.AutoScaleExample7.positioning.remoteMe.runUserSub(false, "positioning","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 17;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 18;BA.debugLine="Activity.LoadLayout(\"positioning\")";
Debug.ShouldStop(131072);
positioning.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("positioning")),positioning.mostCurrent.activityBA);
 BA.debugLineNum = 20;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Pause (positioning) ","positioning",11,positioning.mostCurrent.activityBA,positioning.mostCurrent,42);
if (RapidSub.canDelegate("activity_pause")) return b4a.AutoScaleExample7.positioning.remoteMe.runUserSub(false, "positioning","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(512);
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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
		Debug.PushSubsStack("Activity_Resume (positioning) ","positioning",11,positioning.mostCurrent.activityBA,positioning.mostCurrent,22);
if (RapidSub.canDelegate("activity_resume")) return b4a.AutoScaleExample7.positioning.remoteMe.runUserSub(false, "positioning","activity_resume");
RemoteObject _space = RemoteObject.createImmutable(0);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="Dim Space As Int";
Debug.ShouldStop(4194304);
_space = RemoteObject.createImmutable(0);Debug.locals.put("Space", _space);
 BA.debugLineNum = 25;BA.debugLine="Scale.SetRate(0.5)";
Debug.ShouldStop(16777216);
positioning.mostCurrent._scale.runVoidMethod ("_setrate",positioning.mostCurrent.activityBA,(Object)(BA.numberCast(double.class, 0.5)));
 BA.debugLineNum = 26;BA.debugLine="Scale.ScaleAll(Activity, True)";
Debug.ShouldStop(33554432);
positioning.mostCurrent._scale.runVoidMethod ("_scaleall",positioning.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), positioning.mostCurrent._activity.getObject()),(Object)(positioning.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 27;BA.debugLine="Space = 10dip * Scale.GetScaleX";
Debug.ShouldStop(67108864);
_space = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {positioning.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),positioning.mostCurrent._scale.runMethod(true,"_getscalex",positioning.mostCurrent.activityBA)}, "*",0, 0));Debug.locals.put("Space", _space);
 BA.debugLineNum = 29;BA.debugLine="Button1.Top = Space";
Debug.ShouldStop(268435456);
positioning.mostCurrent._button1.runMethod(true,"setTop",_space);
 BA.debugLineNum = 31;BA.debugLine="Button2.Left = Space";
Debug.ShouldStop(1073741824);
positioning.mostCurrent._button2.runMethod(true,"setLeft",_space);
 BA.debugLineNum = 32;BA.debugLine="Scale.SetRight(Button4, 100%x - Space)";
Debug.ShouldStop(-2147483648);
positioning.mostCurrent._scale.runVoidMethod ("_setright",positioning.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button4.getObject()),(Object)(RemoteObject.solve(new RemoteObject[] {positioning.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),positioning.mostCurrent.activityBA),_space}, "-",1, 1)));
 BA.debugLineNum = 33;BA.debugLine="Scale.SetTopAndBottom2(Button4, Activity, Space,";
Debug.ShouldStop(1);
positioning.mostCurrent._scale.runVoidMethod ("_settopandbottom2",positioning.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button4.getObject()),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._activity.getObject()),(Object)(_space),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._activity.getObject()),(Object)(_space));
 BA.debugLineNum = 34;BA.debugLine="Scale.SetLeftAndRight2(Button1, Activity, Space,";
Debug.ShouldStop(2);
positioning.mostCurrent._scale.runVoidMethod ("_setleftandright2",positioning.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button1.getObject()),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._activity.getObject()),(Object)(_space),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button4.getObject()),(Object)(_space));
 BA.debugLineNum = 35;BA.debugLine="Scale.SetTopAndBottom2(Button2, Button1, Space, A";
Debug.ShouldStop(4);
positioning.mostCurrent._scale.runVoidMethod ("_settopandbottom2",positioning.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button2.getObject()),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button1.getObject()),(Object)(_space),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._activity.getObject()),(Object)(_space));
 BA.debugLineNum = 36;BA.debugLine="Scale.SetBottom(Button5, 100%y - Space)";
Debug.ShouldStop(8);
positioning.mostCurrent._scale.runVoidMethod ("_setbottom",positioning.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button5.getObject()),(Object)(RemoteObject.solve(new RemoteObject[] {positioning.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),positioning.mostCurrent.activityBA),_space}, "-",1, 1)));
 BA.debugLineNum = 37;BA.debugLine="Scale.HorizontalCenter(Button5)";
Debug.ShouldStop(16);
positioning.mostCurrent._scale.runVoidMethod ("_horizontalcenter",positioning.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button5.getObject()));
 BA.debugLineNum = 38;BA.debugLine="Scale.SetLeftAndRight2(Button3, Button2, Space, B";
Debug.ShouldStop(32);
positioning.mostCurrent._scale.runVoidMethod ("_setleftandright2",positioning.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button3.getObject()),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button2.getObject()),(Object)(_space),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button4.getObject()),(Object)(_space));
 BA.debugLineNum = 39;BA.debugLine="Scale.SetTopAndBottom2(Button3, Button1, Space, B";
Debug.ShouldStop(64);
positioning.mostCurrent._scale.runVoidMethod ("_settopandbottom2",positioning.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button3.getObject()),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button1.getObject()),(Object)(_space),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), positioning.mostCurrent._button5.getObject()),(Object)(_space));
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
 //BA.debugLineNum = 14;BA.debugLine="Dim Button1, Button2, Button3, Button4, Button5 A";
positioning.mostCurrent._button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
positioning.mostCurrent._button2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
positioning.mostCurrent._button3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
positioning.mostCurrent._button4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
positioning.mostCurrent._button5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}