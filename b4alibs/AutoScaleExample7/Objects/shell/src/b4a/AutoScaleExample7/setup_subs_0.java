package b4a.AutoScaleExample7;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class setup_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (setup) ","setup",1,setup.mostCurrent.activityBA,setup.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) return b4a.AutoScaleExample7.setup.remoteMe.runUserSub(false, "setup","activity_create", _firsttime);
RemoteObject _left = RemoteObject.createImmutable(0);
RemoteObject _width = RemoteObject.createImmutable(0);
RemoteObject _width1 = RemoteObject.createImmutable(0);
RemoteObject _space = RemoteObject.createImmutable(0);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="Dim Left, Width, Width1, Space As Int";
Debug.ShouldStop(1073741824);
_left = RemoteObject.createImmutable(0);Debug.locals.put("Left", _left);
_width = RemoteObject.createImmutable(0);Debug.locals.put("Width", _width);
_width1 = RemoteObject.createImmutable(0);Debug.locals.put("Width1", _width1);
_space = RemoteObject.createImmutable(0);Debug.locals.put("Space", _space);
 BA.debugLineNum = 33;BA.debugLine="Scale.SetRate(0.5)";
Debug.ShouldStop(1);
setup.mostCurrent._scale.runVoidMethod ("_setrate",setup.mostCurrent.activityBA,(Object)(BA.numberCast(double.class, 0.5)));
 BA.debugLineNum = 35;BA.debugLine="Width = 312dip * Scale.GetScaleX";
Debug.ShouldStop(4);
_width = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {setup.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 312))),setup.mostCurrent._scale.runMethod(true,"_getscalex",setup.mostCurrent.activityBA)}, "*",0, 0));Debug.locals.put("Width", _width);
 BA.debugLineNum = 36;BA.debugLine="Width1 = 320dip * Scale.GetScaleX";
Debug.ShouldStop(8);
_width1 = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {setup.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 320))),setup.mostCurrent._scale.runMethod(true,"_getscalex",setup.mostCurrent.activityBA)}, "*",0, 0));Debug.locals.put("Width1", _width1);
 BA.debugLineNum = 37;BA.debugLine="Space = 4dip * Scale.GetScaleX";
Debug.ShouldStop(16);
_space = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {setup.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4))),setup.mostCurrent._scale.runMethod(true,"_getscalex",setup.mostCurrent.activityBA)}, "*",0, 0));Debug.locals.put("Space", _space);
 BA.debugLineNum = 39;BA.debugLine="scvSetup.Initialize(0)";
Debug.ShouldStop(64);
setup.mostCurrent._scvsetup.runVoidMethod ("Initialize",setup.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 40;BA.debugLine="Activity.AddView(scvSetup, (100%x - Width1) / 2,";
Debug.ShouldStop(128);
setup.mostCurrent._activity.runVoidMethod ("AddView",(Object)((setup.mostCurrent._scvsetup.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {setup.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),setup.mostCurrent.activityBA),_width1}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0))),(Object)(BA.numberCast(int.class, 0)),(Object)(_width1),(Object)(setup.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),setup.mostCurrent.activityBA)));
 BA.debugLineNum = 41;BA.debugLine="scvSetup.Color = Colors.RGB(255, 205, 250)";
Debug.ShouldStop(256);
setup.mostCurrent._scvsetup.runVoidMethod ("setColor",setup.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 205)),(Object)(BA.numberCast(int.class, 250))));
 BA.debugLineNum = 42;BA.debugLine="scvSetup.Panel.LoadLayout(\"setup\")";
Debug.ShouldStop(512);
setup.mostCurrent._scvsetup.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("setup")),setup.mostCurrent.activityBA);
 BA.debugLineNum = 44;BA.debugLine="Scale.ScaleAll(Activity, True)";
Debug.ShouldStop(2048);
setup.mostCurrent._scale.runVoidMethod ("_scaleall",setup.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), setup.mostCurrent._activity.getObject()),(Object)(setup.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 46;BA.debugLine="scvSetup.Height = 100%y";
Debug.ShouldStop(8192);
setup.mostCurrent._scvsetup.runMethod(true,"setHeight",setup.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),setup.mostCurrent.activityBA));
 BA.debugLineNum = 47;BA.debugLine="If 100%x < 2 * Width + 3 * Space Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("<",setup.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),setup.mostCurrent.activityBA),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(2),_width,RemoteObject.createImmutable(3),_space}, "*+*",1, 1)))) { 
 BA.debugLineNum = 49;BA.debugLine="scvSetup.Width = Width1";
Debug.ShouldStop(65536);
setup.mostCurrent._scvsetup.runMethod(true,"setWidth",_width1);
 BA.debugLineNum = 50;BA.debugLine="scvSetup.Left = 50%x - Width1 / 2";
Debug.ShouldStop(131072);
setup.mostCurrent._scvsetup.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {setup.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),setup.mostCurrent.activityBA),_width1,RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 51;BA.debugLine="pnlSetup.Width = scvSetup.Width";
Debug.ShouldStop(262144);
setup.mostCurrent._pnlsetup.runMethod(true,"setWidth",setup.mostCurrent._scvsetup.runMethod(true,"getWidth"));
 BA.debugLineNum = 52;BA.debugLine="scvSetup.Panel.Width = pnlSetup.Width";
Debug.ShouldStop(524288);
setup.mostCurrent._scvsetup.runMethod(false,"getPanel").runMethod(true,"setWidth",setup.mostCurrent._pnlsetup.runMethod(true,"getWidth"));
 BA.debugLineNum = 53;BA.debugLine="pnlSetup.Height = pnlMapMarkers.Top + pnlMapMark";
Debug.ShouldStop(1048576);
setup.mostCurrent._pnlsetup.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {setup.mostCurrent._pnlmapmarkers.runMethod(true,"getTop"),setup.mostCurrent._pnlmapmarkers.runMethod(true,"getHeight"),_space}, "++",2, 1));
 BA.debugLineNum = 54;BA.debugLine="scvSetup.Panel.Height = pnlSetup.Height";
Debug.ShouldStop(2097152);
setup.mostCurrent._scvsetup.runMethod(false,"getPanel").runMethod(true,"setHeight",setup.mostCurrent._pnlsetup.runMethod(true,"getHeight"));
 BA.debugLineNum = 55;BA.debugLine="DoEvents";
Debug.ShouldStop(4194304);
setup.mostCurrent.__c.runVoidMethodAndSync ("DoEvents");
 }else {
 BA.debugLineNum = 58;BA.debugLine="Left = Width + 2 * Space";
Debug.ShouldStop(33554432);
_left = RemoteObject.solve(new RemoteObject[] {_width,RemoteObject.createImmutable(2),_space}, "+*",1, 1);Debug.locals.put("Left", _left);
 BA.debugLineNum = 60;BA.debugLine="scvSetup.Width = 2 * Width + 3 * Space";
Debug.ShouldStop(134217728);
setup.mostCurrent._scvsetup.runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(2),_width,RemoteObject.createImmutable(3),_space}, "*+*",1, 1));
 BA.debugLineNum = 61;BA.debugLine="scvSetup.Panel.Width = scvSetup.Width";
Debug.ShouldStop(268435456);
setup.mostCurrent._scvsetup.runMethod(false,"getPanel").runMethod(true,"setWidth",setup.mostCurrent._scvsetup.runMethod(true,"getWidth"));
 BA.debugLineNum = 62;BA.debugLine="pnlSetup.Width = scvSetup.Width";
Debug.ShouldStop(536870912);
setup.mostCurrent._pnlsetup.runMethod(true,"setWidth",setup.mostCurrent._scvsetup.runMethod(true,"getWidth"));
 BA.debugLineNum = 63;BA.debugLine="scvSetup.Left = 50%x - scvSetup.Width / 2";
Debug.ShouldStop(1073741824);
setup.mostCurrent._scvsetup.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {setup.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 50)),setup.mostCurrent.activityBA),setup.mostCurrent._scvsetup.runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "-/",1, 0)));
 BA.debugLineNum = 65;BA.debugLine="pnlMapSetup.Top = Space";
Debug.ShouldStop(1);
setup.mostCurrent._pnlmapsetup.runMethod(true,"setTop",_space);
 BA.debugLineNum = 66;BA.debugLine="pnlMapSetup.Left = Left";
Debug.ShouldStop(2);
setup.mostCurrent._pnlmapsetup.runMethod(true,"setLeft",_left);
 BA.debugLineNum = 68;BA.debugLine="pnlMapLine.Top = pnlMapSetup.Top + pnlMapSetup.H";
Debug.ShouldStop(8);
setup.mostCurrent._pnlmapline.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {setup.mostCurrent._pnlmapsetup.runMethod(true,"getTop"),setup.mostCurrent._pnlmapsetup.runMethod(true,"getHeight"),_space}, "++",2, 1));
 BA.debugLineNum = 69;BA.debugLine="pnlMapLine.Left = Left";
Debug.ShouldStop(16);
setup.mostCurrent._pnlmapline.runMethod(true,"setLeft",_left);
 BA.debugLineNum = 71;BA.debugLine="pnlMapMarkers.Top = pnlMapLine.Top + pnlMapLine.";
Debug.ShouldStop(64);
setup.mostCurrent._pnlmapmarkers.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {setup.mostCurrent._pnlmapline.runMethod(true,"getTop"),setup.mostCurrent._pnlmapline.runMethod(true,"getHeight"),_space}, "++",2, 1));
 BA.debugLineNum = 72;BA.debugLine="pnlMapMarkers.Left = Left";
Debug.ShouldStop(128);
setup.mostCurrent._pnlmapmarkers.runMethod(true,"setLeft",_left);
 BA.debugLineNum = 73;BA.debugLine="scvSetup.Panel.Height = pnlGPSSetup.Top + pnlGPS";
Debug.ShouldStop(256);
setup.mostCurrent._scvsetup.runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {setup.mostCurrent._pnlgpssetup.runMethod(true,"getTop"),setup.mostCurrent._pnlgpssetup.runMethod(true,"getHeight"),_space}, "++",2, 1));
 };
 BA.debugLineNum = 75;BA.debugLine="FillSpinners";
Debug.ShouldStop(1024);
_fillspinners();
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (setup) ","setup",1,setup.mostCurrent.activityBA,setup.mostCurrent,82);
if (RapidSub.canDelegate("activity_pause")) return b4a.AutoScaleExample7.setup.remoteMe.runUserSub(false, "setup","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 82;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Activity_Resume (setup) ","setup",1,setup.mostCurrent.activityBA,setup.mostCurrent,78);
if (RapidSub.canDelegate("activity_resume")) return b4a.AutoScaleExample7.setup.remoteMe.runUserSub(false, "setup","activity_resume");
 BA.debugLineNum = 78;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(8192);
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fillspinners() throws Exception{
try {
		Debug.PushSubsStack("FillSpinners (setup) ","setup",1,setup.mostCurrent.activityBA,setup.mostCurrent,86);
if (RapidSub.canDelegate("fillspinners")) return b4a.AutoScaleExample7.setup.remoteMe.runUserSub(false, "setup","fillspinners");
 BA.debugLineNum = 86;BA.debugLine="Sub FillSpinners";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="spnMapZoomLevel.Add(\"15\")";
Debug.ShouldStop(4194304);
setup.mostCurrent._spnmapzoomlevel.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("15")));
 BA.debugLineNum = 88;BA.debugLine="spnMapLineWidth.Add(\"5\")";
Debug.ShouldStop(8388608);
setup.mostCurrent._spnmaplinewidth.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("5")));
 BA.debugLineNum = 89;BA.debugLine="spnMapLineColor.Add(\"Red\")";
Debug.ShouldStop(16777216);
setup.mostCurrent._spnmaplinecolor.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("Red")));
 BA.debugLineNum = 90;BA.debugLine="spnMapLineOpacity.Add(\"1\")";
Debug.ShouldStop(33554432);
setup.mostCurrent._spnmaplineopacity.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("1")));
 BA.debugLineNum = 91;BA.debugLine="spnMapTypeControlID.Add(\"MAP\")";
Debug.ShouldStop(67108864);
setup.mostCurrent._spnmaptypecontrolid.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("MAP")));
 BA.debugLineNum = 92;BA.debugLine="spnMapZoomControlType.Add(\"15\")";
Debug.ShouldStop(134217728);
setup.mostCurrent._spnmapzoomcontroltype.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("15")));
 BA.debugLineNum = 93;BA.debugLine="spnAltitudeUnit.Add(\"m\")";
Debug.ShouldStop(268435456);
setup.mostCurrent._spnaltitudeunit.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("m")));
 BA.debugLineNum = 94;BA.debugLine="spnSpeedUnit.Add(\"km/h\")";
Debug.ShouldStop(536870912);
setup.mostCurrent._spnspeedunit.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("km/h")));
 BA.debugLineNum = 95;BA.debugLine="spnDistanceUnit.Add(\"km\")";
Debug.ShouldStop(1073741824);
setup.mostCurrent._spndistanceunit.runVoidMethod ("Add",(Object)(RemoteObject.createImmutable("km")));
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
 //BA.debugLineNum = 13;BA.debugLine="Dim pnlSetupGPS, pnlGPSPathUnits, pnlMapDefaultLo";
setup.mostCurrent._pnlsetupgps = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
setup.mostCurrent._pnlgpspathunits = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
setup.mostCurrent._pnlmapdefaultlocation = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
setup.mostCurrent._pnlgpssetup = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
setup.mostCurrent._pnlmapsetup = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
setup.mostCurrent._pnlmapline = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
setup.mostCurrent._pnlmapmarkers = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Dim pnlSetup As Panel";
setup.mostCurrent._pnlsetup = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Dim cbxMapDraggable, cbxDispMapTypeControl, cbxDi";
setup.mostCurrent._cbxmapdraggable = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
setup.mostCurrent._cbxdispmaptypecontrol = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
setup.mostCurrent._cbxdispmapzoomcontrol = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
setup.mostCurrent._cbxdispmapscalecontrol = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim cbxDispMapCenterMarker, cbxDispMapMarkers, cb";
setup.mostCurrent._cbxdispmapcentermarker = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
setup.mostCurrent._cbxdispmapmarkers = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
setup.mostCurrent._cbxdispmappolyline = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim cbxMapMarkersClickable, cbxMapMarkersDragable";
setup.mostCurrent._cbxmapmarkersclickable = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
setup.mostCurrent._cbxmapmarkersdragable = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
setup.mostCurrent._cbxshowgpsonmap = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim cbxDrawGPSPath, cbxSaveGPSPath, cbxGPSDispSpe";
setup.mostCurrent._cbxdrawgpspath = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
setup.mostCurrent._cbxsavegpspath = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
setup.mostCurrent._cbxgpsdispspeed = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
setup.mostCurrent._cbxgpsdispbearing = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
setup.mostCurrent._cbxgpsdispwindrose = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Dim edtMapDefaultLocationLng, edtMapDefaultLocati";
setup.mostCurrent._edtmapdefaultlocationlng = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
setup.mostCurrent._edtmapdefaultlocationlat = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
setup.mostCurrent._edtgpsmintime = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
setup.mostCurrent._edtgpsmindistance = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim spnMapZoomLevel, spnMapLineWidth, spnMapLineC";
setup.mostCurrent._spnmapzoomlevel = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
setup.mostCurrent._spnmaplinewidth = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
setup.mostCurrent._spnmaplinecolor = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
setup.mostCurrent._spnmaplineopacity = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim spnMapTypeControlID, spnMapZoomControlType As";
setup.mostCurrent._spnmaptypecontrolid = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
setup.mostCurrent._spnmapzoomcontroltype = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim spnAltitudeUnit, spnSpeedUnit, spnDistanceUni";
setup.mostCurrent._spnaltitudeunit = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
setup.mostCurrent._spnspeedunit = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
setup.mostCurrent._spndistanceunit = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Dim scvSetup As ScrollView";
setup.mostCurrent._scvsetup = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}