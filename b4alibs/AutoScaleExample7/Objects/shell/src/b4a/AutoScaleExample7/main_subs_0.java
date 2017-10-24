package b4a.AutoScaleExample7;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,38);
if (RapidSub.canDelegate("activity_create")) return b4a.AutoScaleExample7.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
RemoteObject _ph = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 40;BA.debugLine="Scale.SetRate(0.5)";
Debug.ShouldStop(128);
main.mostCurrent._scale.runVoidMethod ("_setrate",main.mostCurrent.activityBA,(Object)(BA.numberCast(double.class, 0.5)));
 BA.debugLineNum = 42;BA.debugLine="Dim ph As Phone";
Debug.ShouldStop(512);
_ph = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("ph", _ph);
 BA.debugLineNum = 43;BA.debugLine="If Scale.GetDevicePhysicalSize < 6 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("<",main.mostCurrent._scale.runMethod(true,"_getdevicephysicalsize",main.mostCurrent.activityBA),BA.numberCast(double.class, 6))) { 
 BA.debugLineNum = 44;BA.debugLine="ph.SetScreenOrientation(1)";
Debug.ShouldStop(2048);
_ph.runVoidMethod ("SetScreenOrientation",main.processBA,(Object)(BA.numberCast(int.class, 1)));
 }else {
 BA.debugLineNum = 46;BA.debugLine="ph.SetScreenOrientation(-1)";
Debug.ShouldStop(8192);
_ph.runVoidMethod ("SetScreenOrientation",main.processBA,(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 };
 BA.debugLineNum = 49;BA.debugLine="Activity.LoadLayout(\"Main\")";
Debug.ShouldStop(65536);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("Main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 51;BA.debugLine="Scale.ScaleView(lblTitle)";
Debug.ShouldStop(262144);
main.mostCurrent._scale.runVoidMethod ("_scaleview",main.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), main.mostCurrent._lbltitle.getObject()));
 BA.debugLineNum = 52;BA.debugLine="Scale.HorizontalCenter(pnlToolBox)";
Debug.ShouldStop(524288);
main.mostCurrent._scale.runVoidMethod ("_horizontalcenter",main.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), main.mostCurrent._pnltoolbox.getObject()));
 BA.debugLineNum = 53;BA.debugLine="Scale.HorizontalCenter(pnlToolBox1)";
Debug.ShouldStop(1048576);
main.mostCurrent._scale.runVoidMethod ("_horizontalcenter",main.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), main.mostCurrent._pnltoolbox1.getObject()));
 BA.debugLineNum = 54;BA.debugLine="Scale.ScaleView(pnlMainBackground)";
Debug.ShouldStop(2097152);
main.mostCurrent._scale.runVoidMethod ("_scaleview",main.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), main.mostCurrent._pnlmainbackground.getObject()));
 BA.debugLineNum = 55;BA.debugLine="Scale.HorizontalCenter(pnlMainBackground)";
Debug.ShouldStop(4194304);
main.mostCurrent._scale.runVoidMethod ("_horizontalcenter",main.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), main.mostCurrent._pnlmainbackground.getObject()));
 BA.debugLineNum = 57;BA.debugLine="pnlToolBox.Top = 100%y - pnlToolBox.Height";
Debug.ShouldStop(16777216);
main.mostCurrent._pnltoolbox.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA),main.mostCurrent._pnltoolbox.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 59;BA.debugLine="If 100%x >= 8 * btnAbout.Width Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("g",main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(8),main.mostCurrent._btnabout.runMethod(true,"getWidth")}, "*",0, 1)))) { 
 BA.debugLineNum = 60;BA.debugLine="pnlToolBox.Left = 50%x - 4 * btnAbout.Width";
Debug.ShouldStop(134217728);
main.mostCurrent._pnltoolbox.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),main.mostCurrent.activityBA),RemoteObject.createImmutable(4),main.mostCurrent._btnabout.runMethod(true,"getWidth")}, "-*",1, 1));
 BA.debugLineNum = 61;BA.debugLine="pnlToolBox1.Left = pnlToolBox.Left + pnlToolBox.";
Debug.ShouldStop(268435456);
main.mostCurrent._pnltoolbox1.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnltoolbox.runMethod(true,"getLeft"),main.mostCurrent._pnltoolbox.runMethod(true,"getWidth")}, "+",1, 1));
 BA.debugLineNum = 62;BA.debugLine="pnlToolBox1.Top = pnlToolBox.Top";
Debug.ShouldStop(536870912);
main.mostCurrent._pnltoolbox1.runMethod(true,"setTop",main.mostCurrent._pnltoolbox.runMethod(true,"getTop"));
 }else {
 BA.debugLineNum = 64;BA.debugLine="pnlToolBox.Left = (100%x - pnlToolBox.Width) / 2";
Debug.ShouldStop(-2147483648);
main.mostCurrent._pnltoolbox.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA),main.mostCurrent._pnltoolbox.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 65;BA.debugLine="pnlToolBox1.Left = (100%x - pnlToolBox1.Width) /";
Debug.ShouldStop(1);
main.mostCurrent._pnltoolbox1.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA),main.mostCurrent._pnltoolbox1.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 66;BA.debugLine="pnlToolBox1.Top = pnlToolBox.Top - pnlToolBox1.H";
Debug.ShouldStop(2);
main.mostCurrent._pnltoolbox1.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._pnltoolbox.runMethod(true,"getTop"),main.mostCurrent._pnltoolbox1.runMethod(true,"getHeight")}, "-",1, 1));
 };
 BA.debugLineNum = 69;BA.debugLine="Scale.VerticalCenter2(pnlMainBackground, lblTitle";
Debug.ShouldStop(16);
main.mostCurrent._scale.runVoidMethod ("_verticalcenter2",main.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), main.mostCurrent._pnlmainbackground.getObject()),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), main.mostCurrent._lbltitle.getObject()),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), main.mostCurrent._pnltoolbox1.getObject()));
 BA.debugLineNum = 71;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(64);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 72;BA.debugLine="DBFileDir = DBUtils.CopyDBFromAssets(DBFileName)";
Debug.ShouldStop(128);
main._dbfiledir = main.mostCurrent._dbutils.runMethod(true,"_copydbfromassets",main.mostCurrent.activityBA,(Object)(main._dbfilename));
 };
 BA.debugLineNum = 75;BA.debugLine="SQL1.Initialize(DBFileDir, DBFileName, True)";
Debug.ShouldStop(1024);
main._sql1.runVoidMethod ("Initialize",(Object)(main._dbfiledir),(Object)(main._dbfilename),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,83);
if (RapidSub.canDelegate("activity_pause")) return b4a.AutoScaleExample7.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 83;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,79);
if (RapidSub.canDelegate("activity_resume")) return b4a.AutoScaleExample7.main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 79;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16384);
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnabout_click() throws Exception{
try {
		Debug.PushSubsStack("btnAbout_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,103);
if (RapidSub.canDelegate("btnabout_click")) return b4a.AutoScaleExample7.main.remoteMe.runUserSub(false, "main","btnabout_click");
 BA.debugLineNum = 103;BA.debugLine="Sub btnAbout_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 104;BA.debugLine="StartActivity(\"About\")";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("About"))));
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncalculator_click() throws Exception{
try {
		Debug.PushSubsStack("btnCalculator_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,111);
if (RapidSub.canDelegate("btncalculator_click")) return b4a.AutoScaleExample7.main.remoteMe.runUserSub(false, "main","btncalculator_click");
 BA.debugLineNum = 111;BA.debugLine="Sub btnCalculator_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="StartActivity(\"Calculator\")";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("Calculator"))));
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncalculator1_click() throws Exception{
try {
		Debug.PushSubsStack("btnCalculator1_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,115);
if (RapidSub.canDelegate("btncalculator1_click")) return b4a.AutoScaleExample7.main.remoteMe.runUserSub(false, "main","btncalculator1_click");
 BA.debugLineNum = 115;BA.debugLine="Sub btnCalculator1_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="StartActivity(\"Calculator1\")";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("Calculator1"))));
 BA.debugLineNum = 117;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btndbscrollview_click() throws Exception{
try {
		Debug.PushSubsStack("btnDBScrollView_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,87);
if (RapidSub.canDelegate("btndbscrollview_click")) return b4a.AutoScaleExample7.main.remoteMe.runUserSub(false, "main","btndbscrollview_click");
 BA.debugLineNum = 87;BA.debugLine="Sub btnDBScrollView_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="StartActivity(\"DBScrollView\")";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("DBScrollView"))));
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btndbwebview_click() throws Exception{
try {
		Debug.PushSubsStack("btnDBWebView_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,91);
if (RapidSub.canDelegate("btndbwebview_click")) return b4a.AutoScaleExample7.main.remoteMe.runUserSub(false, "main","btndbwebview_click");
 BA.debugLineNum = 91;BA.debugLine="Sub btnDBWebView_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 92;BA.debugLine="StartActivity(\"DBWebView\")";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("DBWebView"))));
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnkeyboard_click() throws Exception{
try {
		Debug.PushSubsStack("btnKeyboard_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,95);
if (RapidSub.canDelegate("btnkeyboard_click")) return b4a.AutoScaleExample7.main.remoteMe.runUserSub(false, "main","btnkeyboard_click");
 BA.debugLineNum = 95;BA.debugLine="Sub btnKeyboard_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 96;BA.debugLine="StartActivity(\"Keyboard\")";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("Keyboard"))));
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnlistview_click() throws Exception{
try {
		Debug.PushSubsStack("btnListView_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,107);
if (RapidSub.canDelegate("btnlistview_click")) return b4a.AutoScaleExample7.main.remoteMe.runUserSub(false, "main","btnlistview_click");
 BA.debugLineNum = 107;BA.debugLine="Sub btnListView_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 108;BA.debugLine="StartActivity(\"ListView\")";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("ListView"))));
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnpositionning_click() throws Exception{
try {
		Debug.PushSubsStack("btnPositionning_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,119);
if (RapidSub.canDelegate("btnpositionning_click")) return b4a.AutoScaleExample7.main.remoteMe.runUserSub(false, "main","btnpositionning_click");
 BA.debugLineNum = 119;BA.debugLine="Sub btnPositionning_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 120;BA.debugLine="StartActivity(\"Positioning\")";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("Positioning"))));
 BA.debugLineNum = 121;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnsetup_click() throws Exception{
try {
		Debug.PushSubsStack("btnSetup_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,99);
if (RapidSub.canDelegate("btnsetup_click")) return b4a.AutoScaleExample7.main.remoteMe.runUserSub(false, "main","btnsetup_click");
 BA.debugLineNum = 99;BA.debugLine="Sub btnSetup_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="StartActivity(\"Setup\")";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((RemoteObject.createImmutable("Setup"))));
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 32;BA.debugLine="Private btnDBScrollView, btnDBWebView, btnKeyboar";
main.mostCurrent._btndbscrollview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
main.mostCurrent._btndbwebview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
main.mostCurrent._btnkeyboard = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
main.mostCurrent._btnsetup = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
main.mostCurrent._btnabout = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private btnListView, btnCalculator, btnCalculator";
main.mostCurrent._btnlistview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
main.mostCurrent._btncalculator = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
main.mostCurrent._btncalculator1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
main.mostCurrent._btnpositionning = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private pnlMainBackground, pnlToolBox, pnlToolBox";
main.mostCurrent._pnlmainbackground = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._pnltoolbox = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
main.mostCurrent._pnltoolbox1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private lblTitle As Label";
main.mostCurrent._lbltitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
setup_subs_0._process_globals();
about_subs_0._process_globals();
scale_subs_0._process_globals();
dbwebview_subs_0._process_globals();
dbutils_subs_0._process_globals();
dbscrollview_subs_0._process_globals();
keyboard_subs_0._process_globals();
listview_subs_0._process_globals();
calculator_subs_0._process_globals();
calculator1_subs_0._process_globals();
positioning_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.AutoScaleExample7.main");
setup.myClass = BA.getDeviceClass ("b4a.AutoScaleExample7.setup");
about.myClass = BA.getDeviceClass ("b4a.AutoScaleExample7.about");
scale.myClass = BA.getDeviceClass ("b4a.AutoScaleExample7.scale");
dbwebview.myClass = BA.getDeviceClass ("b4a.AutoScaleExample7.dbwebview");
dbutils.myClass = BA.getDeviceClass ("b4a.AutoScaleExample7.dbutils");
dbscrollview.myClass = BA.getDeviceClass ("b4a.AutoScaleExample7.dbscrollview");
keyboard.myClass = BA.getDeviceClass ("b4a.AutoScaleExample7.keyboard");
listview.myClass = BA.getDeviceClass ("b4a.AutoScaleExample7.listview");
calculator.myClass = BA.getDeviceClass ("b4a.AutoScaleExample7.calculator");
calculator1.myClass = BA.getDeviceClass ("b4a.AutoScaleExample7.calculator1");
positioning.myClass = BA.getDeviceClass ("b4a.AutoScaleExample7.positioning");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 17;BA.debugLine="Public ProgName = \"AutoScale Example 6\" As String";
main._progname = BA.ObjectToString("AutoScale Example 6");
 //BA.debugLineNum = 18;BA.debugLine="Public ProgVersion = \"2.1\" As String";
main._progversion = BA.ObjectToString("2.1");
 //BA.debugLineNum = 19;BA.debugLine="Public ProgAuthor = \"klaus\" As String";
main._progauthor = BA.ObjectToString("klaus");
 //BA.debugLineNum = 20;BA.debugLine="Public ProgDate = \"feb 2013\" As String";
main._progdate = BA.ObjectToString("feb 2013");
 //BA.debugLineNum = 21;BA.debugLine="Public ProgCopyright = \"©  2012, 2013 Anywhere So";
main._progcopyright = BA.ObjectToString("©  2012, 2013 Anywhere Software");
 //BA.debugLineNum = 22;BA.debugLine="Public ProgCountry = \"Switzerland\" As String";
main._progcountry = BA.ObjectToString("Switzerland");
 //BA.debugLineNum = 23;BA.debugLine="Public ProgEMail = \"e-mail address\" As String";
main._progemail = BA.ObjectToString("e-mail address");
 //BA.debugLineNum = 25;BA.debugLine="Public SQL1 As SQL";
main._sql1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 26;BA.debugLine="Public DBFileName = \"persons.db\" As String";
main._dbfilename = BA.ObjectToString("persons.db");
 //BA.debugLineNum = 27;BA.debugLine="Public DBFileDir  = File.DirInternal As String";
main._dbfiledir = main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");
 //BA.debugLineNum = 28;BA.debugLine="Public DBTableName = \"persons\" As String";
main._dbtablename = BA.ObjectToString("persons");
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}