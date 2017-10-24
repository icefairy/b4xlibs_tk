package b4a.AutoScaleExample7;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class about_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (about) ","about",2,about.mostCurrent.activityBA,about.mostCurrent,19);
if (RapidSub.canDelegate("activity_create")) return b4a.AutoScaleExample7.about.remoteMe.runUserSub(false, "about","activity_create", _firsttime);
RemoteObject _ph = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 19;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 20;BA.debugLine="Dim ph As Phone";
Debug.ShouldStop(524288);
_ph = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("ph", _ph);
 BA.debugLineNum = 21;BA.debugLine="If Scale.GetDevicePhysicalSize < 6 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("<",about.mostCurrent._scale.runMethod(true,"_getdevicephysicalsize",about.mostCurrent.activityBA),BA.numberCast(double.class, 6))) { 
 BA.debugLineNum = 22;BA.debugLine="ph.SetScreenOrientation(1)";
Debug.ShouldStop(2097152);
_ph.runVoidMethod ("SetScreenOrientation",about.processBA,(Object)(BA.numberCast(int.class, 1)));
 }else {
 BA.debugLineNum = 24;BA.debugLine="ph.SetScreenOrientation(-1)";
Debug.ShouldStop(8388608);
_ph.runVoidMethod ("SetScreenOrientation",about.processBA,(Object)(BA.numberCast(int.class, -(double) (0 + 1))));
 };
 BA.debugLineNum = 27;BA.debugLine="Activity.LoadLayout(\"about\")";
Debug.ShouldStop(67108864);
about.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("about")),about.mostCurrent.activityBA);
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("Activity_Pause (about) ","about",2,about.mostCurrent.activityBA,about.mostCurrent,41);
if (RapidSub.canDelegate("activity_pause")) return b4a.AutoScaleExample7.about.remoteMe.runUserSub(false, "about","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(256);
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("Activity_Resume (about) ","about",2,about.mostCurrent.activityBA,about.mostCurrent,30);
if (RapidSub.canDelegate("activity_resume")) return b4a.AutoScaleExample7.about.remoteMe.runUserSub(false, "about","activity_resume");
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="Activity.Title = Main.ProgName & \" About\"";
Debug.ShouldStop(1073741824);
about.mostCurrent._activity.runMethod(false,"setTitle",BA.ObjectToCharSequence(RemoteObject.concat(about.mostCurrent._main._progname,RemoteObject.createImmutable(" About"))));
 BA.debugLineNum = 32;BA.debugLine="lblAboutProgram.Text = Main.ProgName";
Debug.ShouldStop(-2147483648);
about.mostCurrent._lblaboutprogram.runMethod(true,"setText",BA.ObjectToCharSequence(about.mostCurrent._main._progname));
 BA.debugLineNum = 33;BA.debugLine="lblAboutVersion.Text = Main.ProgVersion";
Debug.ShouldStop(1);
about.mostCurrent._lblaboutversion.runMethod(true,"setText",BA.ObjectToCharSequence(about.mostCurrent._main._progversion));
 BA.debugLineNum = 34;BA.debugLine="lblAboutAuthor.Text = Main.ProgAuthor";
Debug.ShouldStop(2);
about.mostCurrent._lblaboutauthor.runMethod(true,"setText",BA.ObjectToCharSequence(about.mostCurrent._main._progauthor));
 BA.debugLineNum = 35;BA.debugLine="lblAboutDate.Text = Main.ProgDate";
Debug.ShouldStop(4);
about.mostCurrent._lblaboutdate.runMethod(true,"setText",BA.ObjectToCharSequence(about.mostCurrent._main._progdate));
 BA.debugLineNum = 36;BA.debugLine="lblAboutCopyRight.Text = Main.ProgCopyright";
Debug.ShouldStop(8);
about.mostCurrent._lblaboutcopyright.runMethod(true,"setText",BA.ObjectToCharSequence(about.mostCurrent._main._progcopyright));
 BA.debugLineNum = 37;BA.debugLine="lblAboutCountry.Text = Main.ProgCountry";
Debug.ShouldStop(16);
about.mostCurrent._lblaboutcountry.runMethod(true,"setText",BA.ObjectToCharSequence(about.mostCurrent._main._progcountry));
 BA.debugLineNum = 38;BA.debugLine="lblAboutEMail.Text = Main.ProgEMail";
Debug.ShouldStop(32);
about.mostCurrent._lblaboutemail.runMethod(true,"setText",BA.ObjectToCharSequence(about.mostCurrent._main._progemail));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
 //BA.debugLineNum = 13;BA.debugLine="Dim pnlAbout As Panel";
about.mostCurrent._pnlabout = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Dim lblAboutProgram, lblAboutVersion, lblAboutAut";
about.mostCurrent._lblaboutprogram = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
about.mostCurrent._lblaboutversion = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
about.mostCurrent._lblaboutauthor = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
about.mostCurrent._lblaboutemail = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Dim lblAboutDate, lblAboutCopyRight, lblAboutCoun";
about.mostCurrent._lblaboutdate = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
about.mostCurrent._lblaboutcopyright = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
about.mostCurrent._lblaboutcountry = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim lblAboutLanguage, lblAboutLanguage0, lblAbout";
about.mostCurrent._lblaboutlanguage = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
about.mostCurrent._lblaboutlanguage0 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
about.mostCurrent._lblaboutlanguage1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _lblaboutlanguage_click() throws Exception{
try {
		Debug.PushSubsStack("lblAboutLanguage_Click (about) ","about",2,about.mostCurrent.activityBA,about.mostCurrent,45);
if (RapidSub.canDelegate("lblaboutlanguage_click")) return b4a.AutoScaleExample7.about.remoteMe.runUserSub(false, "about","lblaboutlanguage_click");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.PhoneIntents");
 BA.debugLineNum = 45;BA.debugLine="Sub lblAboutLanguage_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="Dim p As PhoneIntents";
Debug.ShouldStop(8192);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.PhoneIntents");Debug.locals.put("p", _p);
 BA.debugLineNum = 47;BA.debugLine="StartActivity(p.OpenBrowser(\"http://www.basic4ppc";
Debug.ShouldStop(16384);
about.mostCurrent.__c.runVoidMethod ("StartActivity",about.processBA,(Object)((_p.runMethod(false,"OpenBrowser",(Object)(RemoteObject.createImmutable("http://www.basic4ppc.com"))))));
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
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