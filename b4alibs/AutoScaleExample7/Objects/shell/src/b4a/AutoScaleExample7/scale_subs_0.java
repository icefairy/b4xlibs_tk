package b4a.AutoScaleExample7;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class scale_subs_0 {


public static RemoteObject  _bottom(RemoteObject _ba,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("Bottom (scale) ","scale",3,_ba,scale.mostCurrent,663);
if (RapidSub.canDelegate("bottom")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","bottom", _ba, _v);
;
Debug.locals.put("v", _v);
 BA.debugLineNum = 663;BA.debugLine="Public Sub Bottom(v As View) As Int";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 664;BA.debugLine="Return v.Top + v.Height";
Debug.ShouldStop(8388608);
if (true) return RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getTop"),_v.runMethod(true,"getHeight")}, "+",1, 1);
 BA.debugLineNum = 665;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getdevicephysicalsize(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("GetDevicePhysicalSize (scale) ","scale",3,_ba,scale.mostCurrent,154);
if (RapidSub.canDelegate("getdevicephysicalsize")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","getdevicephysicalsize", _ba);
RemoteObject _lv = RemoteObject.declareNull("anywheresoftware.b4a.keywords.LayoutValues");
;
 BA.debugLineNum = 154;BA.debugLine="Public Sub GetDevicePhysicalSize As Float";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 155;BA.debugLine="Dim lv As LayoutValues";
Debug.ShouldStop(67108864);
_lv = RemoteObject.createNew ("anywheresoftware.b4a.keywords.LayoutValues");Debug.locals.put("lv", _lv);
 BA.debugLineNum = 157;BA.debugLine="lv = GetDeviceLayoutValues";
Debug.ShouldStop(268435456);
_lv = scale.mostCurrent.__c.runMethod(false,"GetDeviceLayoutValues",_ba);Debug.locals.put("lv", _lv);
 BA.debugLineNum = 158;BA.debugLine="Return Sqrt(Power(lv.Height / lv.Scale / 160, 2)";
Debug.ShouldStop(536870912);
if (true) return BA.numberCast(float.class, scale.mostCurrent.__c.runMethod(true,"Sqrt",(Object)(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"Power",(Object)(RemoteObject.solve(new RemoteObject[] {_lv.getField(true,"Height"),_lv.getField(true,"Scale"),RemoteObject.createImmutable(160)}, "//",0, 0)),(Object)(BA.numberCast(double.class, 2))),scale.mostCurrent.__c.runMethod(true,"Power",(Object)(RemoteObject.solve(new RemoteObject[] {_lv.getField(true,"Width"),_lv.getField(true,"Scale"),RemoteObject.createImmutable(160)}, "//",0, 0)),(Object)(BA.numberCast(double.class, 2)))}, "+",1, 0))));
 BA.debugLineNum = 159;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getparent(RemoteObject _ba,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("GetParent (scale) ","scale",3,_ba,scale.mostCurrent,709);
if (RapidSub.canDelegate("getparent")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","getparent", _ba, _v);
RemoteObject _jobj = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
;
Debug.locals.put("v", _v);
 BA.debugLineNum = 709;BA.debugLine="Sub GetParent(v As View) As Object";
Debug.ShouldStop(16);
 BA.debugLineNum = 710;BA.debugLine="Dim jobj = v As JavaObject";
Debug.ShouldStop(32);
_jobj = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jobj.setObject(_v.getObject());Debug.locals.put("jobj", _jobj);
 BA.debugLineNum = 711;BA.debugLine="Return jobj.RunMethod(\"getParent\", Null)";
Debug.ShouldStop(64);
if (true) return _jobj.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getParent")),(Object)((scale.mostCurrent.__c.getField(false,"Null"))));
 BA.debugLineNum = 712;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getscaleds(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("GetScaleDS (scale) ","scale",3,_ba,scale.mostCurrent,138);
if (RapidSub.canDelegate("getscaleds")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","getscaleds", _ba);
;
 BA.debugLineNum = 138;BA.debugLine="Public Sub GetScaleDS As Double";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="Return cScaleDS";
Debug.ShouldStop(1024);
if (true) return scale._cscaleds;
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getscalex(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("GetScaleX (scale) ","scale",3,_ba,scale.mostCurrent,77);
if (RapidSub.canDelegate("getscalex")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","getscalex", _ba);
;
 BA.debugLineNum = 77;BA.debugLine="Public Sub GetScaleX As Double";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="Return cScaleX";
Debug.ShouldStop(8192);
if (true) return scale._cscalex;
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getscalex_l(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("GetScaleX_L (scale) ","scale",3,_ba,scale.mostCurrent,115);
if (RapidSub.canDelegate("getscalex_l")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","getscalex_l", _ba);
;
 BA.debugLineNum = 115;BA.debugLine="Public Sub GetScaleX_L As Double";
Debug.ShouldStop(262144);
 BA.debugLineNum = 116;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("<",_getdevicephysicalsize(_ba),BA.numberCast(double.class, 6))) { 
 BA.debugLineNum = 117;BA.debugLine="Return (100%y / (cRefWidth - 50dip) / cRefScale)";
Debug.ShouldStop(1048576);
if (true) return (RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),(RemoteObject.solve(new RemoteObject[] {scale._crefwidth,scale.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),scale._crefscale}, "//",0, 0));
 }else {
 BA.debugLineNum = 119;BA.debugLine="Return (1 + Rate * (100%y / (cRefWidth - 50dip)";
Debug.ShouldStop(4194304);
if (true) return (RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1),scale._rate,(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),(RemoteObject.solve(new RemoteObject[] {scale._crefwidth,scale.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),scale._crefscale,RemoteObject.createImmutable(1)}, "//-",1, 0))}, "+*",1, 0));
 };
 BA.debugLineNum = 121;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getscalex_p(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("GetScaleX_P (scale) ","scale",3,_ba,scale.mostCurrent,127);
if (RapidSub.canDelegate("getscalex_p")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","getscalex_p", _ba);
;
 BA.debugLineNum = 127;BA.debugLine="Public Sub GetScaleX_P As Double";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 128;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("<",_getdevicephysicalsize(_ba),BA.numberCast(double.class, 6))) { 
 BA.debugLineNum = 129;BA.debugLine="Return (100%y / cRefWidth / cRefScale)";
Debug.ShouldStop(1);
if (true) return (RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),scale._crefwidth,scale._crefscale}, "//",0, 0));
 }else {
 BA.debugLineNum = 131;BA.debugLine="Return (1 + Rate * (100%y / (cRefWidth - 50dip)";
Debug.ShouldStop(4);
if (true) return (RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1),scale._rate,(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),(RemoteObject.solve(new RemoteObject[] {scale._crefwidth,scale.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),scale._crefscale,RemoteObject.createImmutable(1)}, "//-",1, 0))}, "+*",1, 0));
 };
 BA.debugLineNum = 133;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getscaley(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("GetScaleY (scale) ","scale",3,_ba,scale.mostCurrent,83);
if (RapidSub.canDelegate("getscaley")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","getscaley", _ba);
;
 BA.debugLineNum = 83;BA.debugLine="Public Sub GetScaleY As Double";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="Return cScaleY";
Debug.ShouldStop(524288);
if (true) return scale._cscaley;
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getscaley_l(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("GetScaleY_L (scale) ","scale",3,_ba,scale.mostCurrent,91);
if (RapidSub.canDelegate("getscaley_l")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","getscaley_l", _ba);
;
 BA.debugLineNum = 91;BA.debugLine="Public Sub GetScaleY_L As Double";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 92;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("<",_getdevicephysicalsize(_ba),BA.numberCast(double.class, 6))) { 
 BA.debugLineNum = 93;BA.debugLine="Return (100%y / (cRefWidth - 50dip) / cRefScale)";
Debug.ShouldStop(268435456);
if (true) return (RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),(RemoteObject.solve(new RemoteObject[] {scale._crefwidth,scale.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),scale._crefscale}, "//",0, 0));
 }else {
 BA.debugLineNum = 95;BA.debugLine="Return (1 + Rate * (100%y / (cRefWidth - 50dip)";
Debug.ShouldStop(1073741824);
if (true) return (RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1),scale._rate,(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),(RemoteObject.solve(new RemoteObject[] {scale._crefwidth,scale.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),scale._crefscale,RemoteObject.createImmutable(1)}, "//-",1, 0))}, "+*",1, 0));
 };
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getscaley_p(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("GetScaleY_P (scale) ","scale",3,_ba,scale.mostCurrent,103);
if (RapidSub.canDelegate("getscaley_p")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","getscaley_p", _ba);
;
 BA.debugLineNum = 103;BA.debugLine="Public Sub GetScaleY_P As Double";
Debug.ShouldStop(64);
 BA.debugLineNum = 104;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("<",_getdevicephysicalsize(_ba),BA.numberCast(double.class, 6))) { 
 BA.debugLineNum = 105;BA.debugLine="Return (100%y / (cRefHeight - 50dip) / cRefScale";
Debug.ShouldStop(256);
if (true) return (RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),(RemoteObject.solve(new RemoteObject[] {scale._crefheight,scale.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),scale._crefscale}, "//",0, 0));
 }else {
 BA.debugLineNum = 107;BA.debugLine="Return (1 + Rate * (100%y / (cRefHeight - 50dip)";
Debug.ShouldStop(1024);
if (true) return (RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1),scale._rate,(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),(RemoteObject.solve(new RemoteObject[] {scale._crefheight,scale.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),scale._crefscale,RemoteObject.createImmutable(1)}, "//-",1, 0))}, "+*",1, 0));
 };
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _horizontalcenter(RemoteObject _ba,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("HorizontalCenter (scale) ","scale",3,_ba,scale.mostCurrent,497);
if (RapidSub.canDelegate("horizontalcenter")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","horizontalcenter", _ba, _v);
;
Debug.locals.put("v", _v);
 BA.debugLineNum = 497;BA.debugLine="Public Sub HorizontalCenter(v As View)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 498;BA.debugLine="v.Left = (100%x - v.Width) / 2";
Debug.ShouldStop(131072);
_v.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_v.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 499;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _horizontalcenter2(RemoteObject _ba,RemoteObject _v,RemoteObject _vleft,RemoteObject _vright) throws Exception{
try {
		Debug.PushSubsStack("HorizontalCenter2 (scale) ","scale",3,_ba,scale.mostCurrent,503);
if (RapidSub.canDelegate("horizontalcenter2")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","horizontalcenter2", _ba, _v, _vleft, _vright);
;
Debug.locals.put("v", _v);
Debug.locals.put("vLeft", _vleft);
Debug.locals.put("vRight", _vright);
 BA.debugLineNum = 503;BA.debugLine="Public Sub HorizontalCenter2(v As View, vLeft As V";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 504;BA.debugLine="v.Left = vLeft.Left + vLeft.Width + (vRight.Left";
Debug.ShouldStop(8388608);
_v.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_vleft.runMethod(true,"getLeft"),_vleft.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_vright.runMethod(true,"getLeft"),(RemoteObject.solve(new RemoteObject[] {_vleft.runMethod(true,"getLeft"),_vleft.runMethod(true,"getWidth")}, "+",1, 1)),_v.runMethod(true,"getWidth")}, "--",2, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 BA.debugLineNum = 505;BA.debugLine="If IsActivity(v) Then";
Debug.ShouldStop(16777216);
if (_isactivity(_ba,_v).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 506;BA.debugLine="ToastMessageShow(\"The view is an Activity !\", Fa";
Debug.ShouldStop(33554432);
scale.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("The view is an Activity !")),(Object)(scale.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 507;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 }else {
 BA.debugLineNum = 509;BA.debugLine="If IsActivity(vLeft) Then";
Debug.ShouldStop(268435456);
if (_isactivity(_ba,_vleft).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 510;BA.debugLine="If IsActivity(vRight) Then";
Debug.ShouldStop(536870912);
if (_isactivity(_ba,_vright).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 511;BA.debugLine="v.Left = (100%x - v.Width) / 2";
Debug.ShouldStop(1073741824);
_v.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_v.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 }else {
 BA.debugLineNum = 513;BA.debugLine="v.Left = (vRight.Left - v.Width) / 2";
Debug.ShouldStop(1);
_v.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_vright.runMethod(true,"getLeft"),_v.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 };
 }else {
 BA.debugLineNum = 516;BA.debugLine="If IsActivity(vRight) Then";
Debug.ShouldStop(8);
if (_isactivity(_ba,_vright).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 517;BA.debugLine="v.Left = vLeft.Left + vLeft.Width + (100%x - (";
Debug.ShouldStop(16);
_v.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_vleft.runMethod(true,"getLeft"),_vleft.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),(RemoteObject.solve(new RemoteObject[] {_vleft.runMethod(true,"getLeft"),_vleft.runMethod(true,"getWidth")}, "+",1, 1)),_v.runMethod(true,"getWidth")}, "--",2, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 }else {
 BA.debugLineNum = 519;BA.debugLine="v.Left = vLeft.Left + vLeft.Width + (vRight.Le";
Debug.ShouldStop(64);
_v.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_vleft.runMethod(true,"getLeft"),_vleft.runMethod(true,"getWidth"),(RemoteObject.solve(new RemoteObject[] {_vright.runMethod(true,"getLeft"),(RemoteObject.solve(new RemoteObject[] {_vleft.runMethod(true,"getLeft"),_vleft.runMethod(true,"getWidth")}, "+",1, 1)),_v.runMethod(true,"getWidth")}, "--",2, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 };
 };
 };
 BA.debugLineNum = 523;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (scale) ","scale",3,_ba,scale.mostCurrent,35);
if (RapidSub.canDelegate("initialize")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","initialize", _ba);
RemoteObject _devicescale = RemoteObject.createImmutable(0);
;
 BA.debugLineNum = 35;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="Dim DeviceScale As Double";
Debug.ShouldStop(8);
_devicescale = RemoteObject.createImmutable(0);Debug.locals.put("DeviceScale", _devicescale);
 BA.debugLineNum = 37;BA.debugLine="DeviceScale = 100dip / 100";
Debug.ShouldStop(16);
_devicescale = RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 100))),RemoteObject.createImmutable(100)}, "/",0, 0);Debug.locals.put("DeviceScale", _devicescale);
 BA.debugLineNum = 39;BA.debugLine="If cRefHeight <> 480 Or cRefWidth <> 320 Or cRefS";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("!",scale._crefheight,BA.numberCast(double.class, 480)) || RemoteObject.solveBoolean("!",scale._crefwidth,BA.numberCast(double.class, 320)) || RemoteObject.solveBoolean("!",scale._crefscale,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 40;BA.debugLine="If 100%x > 100%y Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean(">",scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),BA.numberCast(double.class, scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba)))) { 
 BA.debugLineNum = 42;BA.debugLine="cScaleX = 100%x / DeviceScale / (cRefHeight / c";
Debug.ShouldStop(512);
scale._cscalex = RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_devicescale,(RemoteObject.solve(new RemoteObject[] {scale._crefheight,scale._crefscale}, "/",0, 0))}, "//",0, 0);
 BA.debugLineNum = 43;BA.debugLine="cScaleY = 100%y / DeviceScale / ((cRefWidth - 5";
Debug.ShouldStop(1024);
scale._cscaley = RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_devicescale,(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {scale._crefwidth,RemoteObject.createImmutable(50),scale._crefscale}, "-*",1, 0)),scale._crefscale}, "/",0, 0))}, "//",0, 0);
 }else {
 BA.debugLineNum = 46;BA.debugLine="cScaleX = 100%x / DeviceScale / (cRefWidth / cR";
Debug.ShouldStop(8192);
scale._cscalex = RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_devicescale,(RemoteObject.solve(new RemoteObject[] {scale._crefwidth,scale._crefscale}, "/",0, 0))}, "//",0, 0);
 BA.debugLineNum = 47;BA.debugLine="cScaleY = 100%y / DeviceScale / ((cRefHeight -";
Debug.ShouldStop(16384);
scale._cscaley = RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_devicescale,(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {scale._crefheight,RemoteObject.createImmutable(50),scale._crefscale}, "-*",1, 0)),scale._crefscale}, "/",0, 0))}, "//",0, 0);
 };
 }else {
 BA.debugLineNum = 50;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("<",_getdevicephysicalsize(_ba),BA.numberCast(double.class, 6))) { 
 BA.debugLineNum = 51;BA.debugLine="If 100%x > 100%y Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean(">",scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),BA.numberCast(double.class, scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba)))) { 
 BA.debugLineNum = 53;BA.debugLine="cScaleX = 100%x / DeviceScale / (cRefHeight /";
Debug.ShouldStop(1048576);
scale._cscalex = RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_devicescale,(RemoteObject.solve(new RemoteObject[] {scale._crefheight,scale._crefscale}, "/",0, 0))}, "//",0, 0);
 BA.debugLineNum = 54;BA.debugLine="cScaleY = 100%y / DeviceScale / ((cRefWidth -";
Debug.ShouldStop(2097152);
scale._cscaley = RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_devicescale,(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {scale._crefwidth,RemoteObject.createImmutable(50),scale._crefscale}, "-*",1, 0)),scale._crefscale}, "/",0, 0))}, "//",0, 0);
 }else {
 BA.debugLineNum = 57;BA.debugLine="cScaleX = 100%x / DeviceScale / (cRefWidth / c";
Debug.ShouldStop(16777216);
scale._cscalex = RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_devicescale,(RemoteObject.solve(new RemoteObject[] {scale._crefwidth,scale._crefscale}, "/",0, 0))}, "//",0, 0);
 BA.debugLineNum = 58;BA.debugLine="cScaleY = 100%y / DeviceScale / ((cRefHeight -";
Debug.ShouldStop(33554432);
scale._cscaley = RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_devicescale,(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {scale._crefheight,RemoteObject.createImmutable(50),scale._crefscale}, "-*",1, 0)),scale._crefscale}, "/",0, 0))}, "//",0, 0);
 };
 }else {
 BA.debugLineNum = 61;BA.debugLine="If 100%x > 100%y Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean(">",scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),BA.numberCast(double.class, scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba)))) { 
 BA.debugLineNum = 63;BA.debugLine="cScaleX = 1 + Rate * (100%x / DeviceScale / (c";
Debug.ShouldStop(1073741824);
scale._cscalex = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1),scale._rate,(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_devicescale,(RemoteObject.solve(new RemoteObject[] {scale._crefheight,scale._crefscale}, "/",0, 0)),RemoteObject.createImmutable(1)}, "//-",1, 0))}, "+*",1, 0);
 BA.debugLineNum = 64;BA.debugLine="cScaleY = 1 + Rate * (100%y / DeviceScale / ((";
Debug.ShouldStop(-2147483648);
scale._cscaley = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1),scale._rate,(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_devicescale,(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {scale._crefwidth,RemoteObject.createImmutable(50),scale._crefscale}, "-*",1, 0)),scale._crefscale}, "/",0, 0)),RemoteObject.createImmutable(1)}, "//-",1, 0))}, "+*",1, 0);
 }else {
 BA.debugLineNum = 67;BA.debugLine="cScaleX = 1 + Rate * (100%x / DeviceScale / (c";
Debug.ShouldStop(4);
scale._cscalex = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1),scale._rate,(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_devicescale,(RemoteObject.solve(new RemoteObject[] {scale._crefwidth,scale._crefscale}, "/",0, 0)),RemoteObject.createImmutable(1)}, "//-",1, 0))}, "+*",1, 0);
 BA.debugLineNum = 68;BA.debugLine="cScaleY = 1 + Rate * (100%y / DeviceScale / ((";
Debug.ShouldStop(8);
scale._cscaley = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1),scale._rate,(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_devicescale,(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {scale._crefheight,scale.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50))),scale._crefscale}, "-*",1, 0)),scale._crefscale}, "/",0, 0)),RemoteObject.createImmutable(1)}, "//-",1, 0))}, "+*",1, 0);
 };
 };
 BA.debugLineNum = 71;BA.debugLine="cScaleDS = 1 + Rate * ((100%x + 100%y) / DeviceS";
Debug.ShouldStop(64);
scale._cscaleds = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(1),scale._rate,(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba)}, "+",1, 1)),_devicescale,(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {scale._crefwidth,scale._crefheight,RemoteObject.createImmutable(50),scale._crefscale}, "+-*",2, 0)),scale._crefscale}, "/",0, 0)),RemoteObject.createImmutable(1)}, "//-",1, 0))}, "+*",1, 0);
 };
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _isactivity(RemoteObject _ba,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("IsActivity (scale) ","scale",3,_ba,scale.mostCurrent,685);
if (RapidSub.canDelegate("isactivity")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","isactivity", _ba, _v);
RemoteObject _obj = RemoteObject.declareNull("Object");
;
Debug.locals.put("v", _v);
 BA.debugLineNum = 685;BA.debugLine="Public Sub IsActivity(v As View) As Boolean";
Debug.ShouldStop(4096);
 BA.debugLineNum = 686;BA.debugLine="Dim obj As Object";
Debug.ShouldStop(8192);
_obj = RemoteObject.createNew ("Object");Debug.locals.put("obj", _obj);
 BA.debugLineNum = 687;BA.debugLine="obj = GetParent(v)";
Debug.ShouldStop(16384);
_obj = _getparent(_ba,_v);Debug.locals.put("obj", _obj);
 BA.debugLineNum = 688;BA.debugLine="If GetType(obj) = \"android.widget.FrameLayout\" Th";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)(_obj)),BA.ObjectToString("android.widget.FrameLayout"))) { 
 BA.debugLineNum = 689;BA.debugLine="Return True";
Debug.ShouldStop(65536);
if (true) return scale.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 691;BA.debugLine="Return False";
Debug.ShouldStop(262144);
if (true) return scale.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 693;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ispanel(RemoteObject _ba,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("IsPanel (scale) ","scale",3,_ba,scale.mostCurrent,669);
if (RapidSub.canDelegate("ispanel")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","ispanel", _ba, _v);
RemoteObject _obj = RemoteObject.declareNull("Object");
;
Debug.locals.put("v", _v);
 BA.debugLineNum = 669;BA.debugLine="Public Sub IsPanel(v As View) As Boolean";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 670;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.BALayout\" T";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.BALayout"))) { 
 BA.debugLineNum = 671;BA.debugLine="Dim obj As Object";
Debug.ShouldStop(1073741824);
_obj = RemoteObject.createNew ("Object");Debug.locals.put("obj", _obj);
 BA.debugLineNum = 672;BA.debugLine="obj = GetParent(v)";
Debug.ShouldStop(-2147483648);
_obj = _getparent(_ba,_v);Debug.locals.put("obj", _obj);
 BA.debugLineNum = 673;BA.debugLine="If GetType(obj) = \"android.widget.FrameLayout\" T";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)(_obj)),BA.ObjectToString("android.widget.FrameLayout"))) { 
 BA.debugLineNum = 674;BA.debugLine="Return False";
Debug.ShouldStop(2);
if (true) return scale.mostCurrent.__c.getField(true,"False");
 }else {
 BA.debugLineNum = 676;BA.debugLine="Return True";
Debug.ShouldStop(8);
if (true) return scale.mostCurrent.__c.getField(true,"True");
 };
 }else {
 BA.debugLineNum = 679;BA.debugLine="Return False";
Debug.ShouldStop(64);
if (true) return scale.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 681;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 26;BA.debugLine="Public Rate As Double";
scale._rate = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 27;BA.debugLine="Rate = 0.3 'value between 0 to 1.";
scale._rate = BA.numberCast(double.class, 0.3);
 //BA.debugLineNum = 28;BA.debugLine="Private cScaleX, cScaleY, cScaleDS As Double";
scale._cscalex = RemoteObject.createImmutable(0);
scale._cscaley = RemoteObject.createImmutable(0);
scale._cscaleds = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 29;BA.debugLine="Private cRefWidth = 320 As Int";
scale._crefwidth = BA.numberCast(int.class, 320);
 //BA.debugLineNum = 30;BA.debugLine="Private cRefHeight = 480 As Int";
scale._crefheight = BA.numberCast(int.class, 480);
 //BA.debugLineNum = 31;BA.debugLine="Private cRefScale = 1 As Double";
scale._crefscale = BA.numberCast(double.class, 1);
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _right(RemoteObject _ba,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("Right (scale) ","scale",3,_ba,scale.mostCurrent,658);
if (RapidSub.canDelegate("right")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","right", _ba, _v);
;
Debug.locals.put("v", _v);
 BA.debugLineNum = 658;BA.debugLine="Public Sub Right(v As View) As Int";
Debug.ShouldStop(131072);
 BA.debugLineNum = 659;BA.debugLine="Return v.Left + v.Width";
Debug.ShouldStop(262144);
if (true) return RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getLeft"),_v.runMethod(true,"getWidth")}, "+",1, 1);
 BA.debugLineNum = 660;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scaleall(RemoteObject _ba,RemoteObject _pnl,RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("ScaleAll (scale) ","scale",3,_ba,scale.mostCurrent,271);
if (RapidSub.canDelegate("scaleall")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","scaleall", _ba, _pnl, _firsttime);
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
;
Debug.locals.put("pnl", _pnl);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 271;BA.debugLine="Public Sub ScaleAll(pnl As Panel, FirstTime As Boo";
Debug.ShouldStop(16384);
 BA.debugLineNum = 272;BA.debugLine="Dim I As Int";
Debug.ShouldStop(32768);
_i = RemoteObject.createImmutable(0);Debug.locals.put("I", _i);
 BA.debugLineNum = 275;BA.debugLine="If IsPanel(pnl) And FirstTime = True Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean(".",_ispanel(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _pnl.getObject()))) && RemoteObject.solveBoolean("=",_firsttime,scale.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 277;BA.debugLine="ScaleView(pnl)";
Debug.ShouldStop(1048576);
_scaleview(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _pnl.getObject()));
 }else {
 BA.debugLineNum = 279;BA.debugLine="For I = 0 To pnl.NumberOfViews - 1";
Debug.ShouldStop(4194304);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_pnl.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
for (;(step5 > 0 && _i.<Integer>get().intValue() <= limit5) || (step5 < 0 && _i.<Integer>get().intValue() >= limit5) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step5))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 280;BA.debugLine="Dim v As View";
Debug.ShouldStop(8388608);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");Debug.locals.put("v", _v);
 BA.debugLineNum = 281;BA.debugLine="v = pnl.GetView(I)";
Debug.ShouldStop(16777216);
_v = _pnl.runMethod(false,"GetView",(Object)(_i));Debug.locals.put("v", _v);
 BA.debugLineNum = 282;BA.debugLine="ScaleView(v)";
Debug.ShouldStop(33554432);
_scaleview(_ba,_v);
 }
}Debug.locals.put("I", _i);
;
 };
 BA.debugLineNum = 285;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scaleallds(RemoteObject _ba,RemoteObject _pnl,RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("ScaleAllDS (scale) ","scale",3,_ba,scale.mostCurrent,371);
if (RapidSub.canDelegate("scaleallds")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","scaleallds", _ba, _pnl, _firsttime);
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
;
Debug.locals.put("pnl", _pnl);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 371;BA.debugLine="Public Sub ScaleAllDS(pnl As Panel, FirstTime As B";
Debug.ShouldStop(262144);
 BA.debugLineNum = 372;BA.debugLine="Dim I As Int";
Debug.ShouldStop(524288);
_i = RemoteObject.createImmutable(0);Debug.locals.put("I", _i);
 BA.debugLineNum = 375;BA.debugLine="If IsPanel(pnl) AND FirstTime = True Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean(".",_ispanel(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _pnl.getObject()))) && RemoteObject.solveBoolean("=",_firsttime,scale.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 377;BA.debugLine="ScaleViewDS(pnl)";
Debug.ShouldStop(16777216);
_scaleviewds(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _pnl.getObject()));
 }else {
 BA.debugLineNum = 379;BA.debugLine="For I = 0 To pnl.NumberOfViews - 1";
Debug.ShouldStop(67108864);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_pnl.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
for (;(step5 > 0 && _i.<Integer>get().intValue() <= limit5) || (step5 < 0 && _i.<Integer>get().intValue() >= limit5) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step5))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 380;BA.debugLine="Dim v As View";
Debug.ShouldStop(134217728);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");Debug.locals.put("v", _v);
 BA.debugLineNum = 381;BA.debugLine="v = pnl.GetView(I)";
Debug.ShouldStop(268435456);
_v = _pnl.runMethod(false,"GetView",(Object)(_i));Debug.locals.put("v", _v);
 BA.debugLineNum = 382;BA.debugLine="ScaleViewDS(v)";
Debug.ShouldStop(536870912);
_scaleviewds(_ba,_v);
 }
}Debug.locals.put("I", _i);
;
 };
 BA.debugLineNum = 385;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scaleallx(RemoteObject _ba,RemoteObject _pnl,RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("ScaleAllX (scale) ","scale",3,_ba,scale.mostCurrent,395);
if (RapidSub.canDelegate("scaleallx")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","scaleallx", _ba, _pnl, _firsttime);
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
;
Debug.locals.put("pnl", _pnl);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 395;BA.debugLine="Public Sub ScaleAllX(pnl As Panel, FirstTime As Bo";
Debug.ShouldStop(1024);
 BA.debugLineNum = 396;BA.debugLine="Dim I As Int";
Debug.ShouldStop(2048);
_i = RemoteObject.createImmutable(0);Debug.locals.put("I", _i);
 BA.debugLineNum = 399;BA.debugLine="If IsPanel(pnl) AND FirstTime = True Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean(".",_ispanel(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _pnl.getObject()))) && RemoteObject.solveBoolean("=",_firsttime,scale.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 401;BA.debugLine="ScaleViewX(pnl)";
Debug.ShouldStop(65536);
_scaleviewx(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _pnl.getObject()));
 }else {
 BA.debugLineNum = 403;BA.debugLine="For I = 0 To pnl.NumberOfViews - 1";
Debug.ShouldStop(262144);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_pnl.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
for (;(step5 > 0 && _i.<Integer>get().intValue() <= limit5) || (step5 < 0 && _i.<Integer>get().intValue() >= limit5) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step5))  ) {
Debug.locals.put("I", _i);
 BA.debugLineNum = 404;BA.debugLine="Dim v As View";
Debug.ShouldStop(524288);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");Debug.locals.put("v", _v);
 BA.debugLineNum = 405;BA.debugLine="v = pnl.GetView(I)";
Debug.ShouldStop(1048576);
_v = _pnl.runMethod(false,"GetView",(Object)(_i));Debug.locals.put("v", _v);
 BA.debugLineNum = 406;BA.debugLine="ScaleViewX(v)";
Debug.ShouldStop(2097152);
_scaleviewx(_ba,_v);
 }
}Debug.locals.put("I", _i);
;
 };
 BA.debugLineNum = 409;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scaleview(RemoteObject _ba,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("ScaleView (scale) ","scale",3,_ba,scale.mostCurrent,164);
if (RapidSub.canDelegate("scaleview")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","scaleview", _ba, _v);
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _scv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
RemoteObject _hcv = RemoteObject.declareNull("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");
RemoteObject _ltv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
RemoteObject _spn = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
;
Debug.locals.put("v", _v);
 BA.debugLineNum = 164;BA.debugLine="Public Sub ScaleView(v As View)";
Debug.ShouldStop(8);
 BA.debugLineNum = 165;BA.debugLine="If IsActivity(v) Then";
Debug.ShouldStop(16);
if (_isactivity(_ba,_v).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 166;BA.debugLine="Return";
Debug.ShouldStop(32);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 169;BA.debugLine="v.Left = v.Left * cScaleX";
Debug.ShouldStop(256);
_v.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getLeft"),scale._cscalex}, "*",0, 0)));
 BA.debugLineNum = 170;BA.debugLine="v.Top = v.Top * cScaleY";
Debug.ShouldStop(512);
_v.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getTop"),scale._cscaley}, "*",0, 0)));
 BA.debugLineNum = 171;BA.debugLine="If IsPanel(v) Then";
Debug.ShouldStop(1024);
if (_ispanel(_ba,_v).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 172;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(2048);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 173;BA.debugLine="pnl = v";
Debug.ShouldStop(4096);
_pnl.setObject(_v.getObject());
 BA.debugLineNum = 174;BA.debugLine="If pnl.Background Is BitmapDrawable Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("i",_pnl.runMethod(false,"getBackground"), RemoteObject.createImmutable("android.graphics.drawable.BitmapDrawable"))) { 
 BA.debugLineNum = 177;BA.debugLine="If v.Width > 0 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getWidth"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 178;BA.debugLine="v.Width = v.Width * Min(cScaleX, cScaleY)";
Debug.ShouldStop(131072);
_v.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getWidth"),scale.mostCurrent.__c.runMethod(true,"Min",(Object)(scale._cscalex),(Object)(scale._cscaley))}, "*",0, 0)));
 };
 BA.debugLineNum = 180;BA.debugLine="If v.Height > 0 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getHeight"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 181;BA.debugLine="v.Height = v.Height * Min(cScaleX, cScaleY)";
Debug.ShouldStop(1048576);
_v.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getHeight"),scale.mostCurrent.__c.runMethod(true,"Min",(Object)(scale._cscalex),(Object)(scale._cscaley))}, "*",0, 0)));
 };
 }else {
 BA.debugLineNum = 184;BA.debugLine="If v.Width > 0 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getWidth"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 185;BA.debugLine="v.Width = v.Width * cScaleX";
Debug.ShouldStop(16777216);
_v.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getWidth"),scale._cscalex}, "*",0, 0)));
 };
 BA.debugLineNum = 187;BA.debugLine="If v.Height > 0 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getHeight"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 188;BA.debugLine="v.Height = v.Height * cScaleY";
Debug.ShouldStop(134217728);
_v.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getHeight"),scale._cscaley}, "*",0, 0)));
 };
 };
 BA.debugLineNum = 191;BA.debugLine="ScaleAll(pnl, False)";
Debug.ShouldStop(1073741824);
_scaleall(_ba,_pnl,scale.mostCurrent.__c.getField(true,"False"));
 }else 
{ BA.debugLineNum = 192;BA.debugLine="Else If v Is ImageView Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.ImageView"))) { 
 BA.debugLineNum = 195;BA.debugLine="If v.Width > 0 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getWidth"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 196;BA.debugLine="v.Width = v.Width * Min(cScaleX, cScaleY)";
Debug.ShouldStop(8);
_v.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getWidth"),scale.mostCurrent.__c.runMethod(true,"Min",(Object)(scale._cscalex),(Object)(scale._cscaley))}, "*",0, 0)));
 };
 BA.debugLineNum = 198;BA.debugLine="If v.Height > 0 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getHeight"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 199;BA.debugLine="v.Height = v.Height * Min(cScaleX, cScaleY)";
Debug.ShouldStop(64);
_v.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getHeight"),scale.mostCurrent.__c.runMethod(true,"Min",(Object)(scale._cscalex),(Object)(scale._cscaley))}, "*",0, 0)));
 };
 }else {
 BA.debugLineNum = 202;BA.debugLine="If v.Width > 0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getWidth"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 203;BA.debugLine="v.Width = v.Width * cScaleX";
Debug.ShouldStop(1024);
_v.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getWidth"),scale._cscalex}, "*",0, 0)));
 };
 BA.debugLineNum = 205;BA.debugLine="If v.Height > 0 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getHeight"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 206;BA.debugLine="v.Height = v.Height * cScaleY";
Debug.ShouldStop(8192);
_v.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getHeight"),scale._cscaley}, "*",0, 0)));
 };
 }}
;
 BA.debugLineNum = 210;BA.debugLine="If v Is Label Then 'this will catch ALL views wit";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TextView"))) { 
 BA.debugLineNum = 211;BA.debugLine="Dim lbl As Label = v";
Debug.ShouldStop(262144);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_lbl.setObject(_v.getObject());Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 212;BA.debugLine="lbl.TextSize = lbl.TextSize * cScaleX";
Debug.ShouldStop(524288);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_lbl.runMethod(true,"getTextSize"),scale._cscalex}, "*",0, 0)));
 };
 BA.debugLineNum = 215;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Scr";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.ScrollViewWrapper$MyScrollView"))) { 
 BA.debugLineNum = 218;BA.debugLine="Dim scv As ScrollView";
Debug.ShouldStop(33554432);
_scv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");Debug.locals.put("scv", _scv);
 BA.debugLineNum = 219;BA.debugLine="scv = v";
Debug.ShouldStop(67108864);
_scv.setObject(_v.getObject());
 BA.debugLineNum = 220;BA.debugLine="ScaleAll(scv.Panel, False)";
Debug.ShouldStop(134217728);
_scaleall(_ba,_scv.runMethod(false,"getPanel"),scale.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 221;BA.debugLine="scv.Panel.Height = scv.Panel.Height * cScaleY";
Debug.ShouldStop(268435456);
_scv.runMethod(false,"getPanel").runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_scv.runMethod(false,"getPanel").runMethod(true,"getHeight"),scale._cscaley}, "*",0, 0)));
 }else 
{ BA.debugLineNum = 222;BA.debugLine="Else If GetType(v) = \"anywheresoftware.b4a.object";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper$MyHScrollView"))) { 
 BA.debugLineNum = 225;BA.debugLine="Dim hcv As HorizontalScrollView";
Debug.ShouldStop(1);
_hcv = RemoteObject.createNew ("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");Debug.locals.put("hcv", _hcv);
 BA.debugLineNum = 226;BA.debugLine="hcv = v";
Debug.ShouldStop(2);
_hcv.setObject(_v.getObject());
 BA.debugLineNum = 227;BA.debugLine="ScaleAll(hcv.Panel, False)";
Debug.ShouldStop(4);
_scaleall(_ba,_hcv.runMethod(false,"getPanel"),scale.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 228;BA.debugLine="hcv.Panel.Width = hcv.Panel.Width * cScaleX";
Debug.ShouldStop(8);
_hcv.runMethod(false,"getPanel").runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_hcv.runMethod(false,"getPanel").runMethod(true,"getWidth"),scale._cscalex}, "*",0, 0)));
 }else 
{ BA.debugLineNum = 229;BA.debugLine="Else If GetType(v) = \"flm.b4a.scrollview2d.Scroll";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("flm.b4a.scrollview2d.ScrollView2DWrapper$MyScrollView"))) { 
 }else 
{ BA.debugLineNum = 237;BA.debugLine="Else If GetType(v) = \"anywheresoftware.b4a.object";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.ListViewWrapper$SimpleListView"))) { 
 BA.debugLineNum = 240;BA.debugLine="Dim ltv As ListView";
Debug.ShouldStop(32768);
_ltv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");Debug.locals.put("ltv", _ltv);
 BA.debugLineNum = 241;BA.debugLine="ltv = v";
Debug.ShouldStop(65536);
_ltv.setObject(_v.getObject());
 BA.debugLineNum = 242;BA.debugLine="ScaleView(ltv.SingleLineLayout.Label)";
Debug.ShouldStop(131072);
_scaleview(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getSingleLineLayout").getField(false,"Label").getObject()));
 BA.debugLineNum = 243;BA.debugLine="ltv.SingleLineLayout.ItemHeight = ltv.SingleLine";
Debug.ShouldStop(262144);
_ltv.runMethod(false,"getSingleLineLayout").runMethod(true,"setItemHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_ltv.runMethod(false,"getSingleLineLayout").runMethod(true,"getItemHeight"),scale._cscaley}, "*",0, 0)));
 BA.debugLineNum = 245;BA.debugLine="ScaleView(ltv.TwoLinesLayout.Label)";
Debug.ShouldStop(1048576);
_scaleview(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesLayout").getField(false,"Label").getObject()));
 BA.debugLineNum = 246;BA.debugLine="ScaleView(ltv.TwoLinesLayout.SecondLabel)";
Debug.ShouldStop(2097152);
_scaleview(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesLayout").getField(false,"SecondLabel").getObject()));
 BA.debugLineNum = 247;BA.debugLine="ltv.TwoLinesLayout.ItemHeight = ltv.TwoLinesLayo";
Debug.ShouldStop(4194304);
_ltv.runMethod(false,"getTwoLinesLayout").runMethod(true,"setItemHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_ltv.runMethod(false,"getTwoLinesLayout").runMethod(true,"getItemHeight"),scale._cscaley}, "*",0, 0)));
 BA.debugLineNum = 249;BA.debugLine="ScaleView(ltv.TwoLinesAndBitmap.Label)";
Debug.ShouldStop(16777216);
_scaleview(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"Label").getObject()));
 BA.debugLineNum = 250;BA.debugLine="ScaleView(ltv.TwoLinesAndBitmap.SecondLabel)";
Debug.ShouldStop(33554432);
_scaleview(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"SecondLabel").getObject()));
 BA.debugLineNum = 251;BA.debugLine="ScaleView(ltv.TwoLinesAndBitmap.ImageView)";
Debug.ShouldStop(67108864);
_scaleview(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").getObject()));
 BA.debugLineNum = 252;BA.debugLine="ltv.TwoLinesAndBitmap.ItemHeight = ltv.TwoLinesA";
Debug.ShouldStop(134217728);
_ltv.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"setItemHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_ltv.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"getItemHeight"),scale._cscaley}, "*",0, 0)));
 BA.debugLineNum = 254;BA.debugLine="ltv.TwoLinesAndBitmap.ImageView.Top = (ltv.TwoLi";
Debug.ShouldStop(536870912);
_ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_ltv.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"getItemHeight"),_ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 }else 
{ BA.debugLineNum = 255;BA.debugLine="Else If GetType(v) = \"anywheresoftware.b4a.object";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner"))) { 
 BA.debugLineNum = 258;BA.debugLine="Dim spn As Spinner";
Debug.ShouldStop(2);
_spn = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");Debug.locals.put("spn", _spn);
 BA.debugLineNum = 259;BA.debugLine="spn = v";
Debug.ShouldStop(4);
_spn.setObject(_v.getObject());
 BA.debugLineNum = 260;BA.debugLine="spn.TextSize = spn.TextSize * cScaleX";
Debug.ShouldStop(8);
_spn.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_spn.runMethod(true,"getTextSize"),scale._cscalex}, "*",0, 0)));
 }}}}}
;
 BA.debugLineNum = 262;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scaleviewds(RemoteObject _ba,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("ScaleViewDS (scale) ","scale",3,_ba,scale.mostCurrent,290);
if (RapidSub.canDelegate("scaleviewds")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","scaleviewds", _ba, _v);
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _scv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
RemoteObject _hcv = RemoteObject.declareNull("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");
RemoteObject _ltv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
RemoteObject _spn = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
;
Debug.locals.put("v", _v);
 BA.debugLineNum = 290;BA.debugLine="Public Sub ScaleViewDS(v As View)";
Debug.ShouldStop(2);
 BA.debugLineNum = 291;BA.debugLine="If IsActivity(v) Then";
Debug.ShouldStop(4);
if (_isactivity(_ba,_v).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 292;BA.debugLine="Return";
Debug.ShouldStop(8);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 295;BA.debugLine="v.Left = v.Left * cScaleDS";
Debug.ShouldStop(64);
_v.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getLeft"),scale._cscaleds}, "*",0, 0)));
 BA.debugLineNum = 296;BA.debugLine="v.Top = v.Top * cScaleDS";
Debug.ShouldStop(128);
_v.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getTop"),scale._cscaleds}, "*",0, 0)));
 BA.debugLineNum = 297;BA.debugLine="If v.Width > 0 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getWidth"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 298;BA.debugLine="v.Width = v.Width * cScaleDS";
Debug.ShouldStop(512);
_v.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getWidth"),scale._cscaleds}, "*",0, 0)));
 };
 BA.debugLineNum = 300;BA.debugLine="If v.Height > 0 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getHeight"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 301;BA.debugLine="v.Height = v.Height * cScaleDS";
Debug.ShouldStop(4096);
_v.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getHeight"),scale._cscaleds}, "*",0, 0)));
 };
 BA.debugLineNum = 304;BA.debugLine="If IsPanel(v) Then";
Debug.ShouldStop(32768);
if (_ispanel(_ba,_v).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 305;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(65536);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 306;BA.debugLine="pnl = v";
Debug.ShouldStop(131072);
_pnl.setObject(_v.getObject());
 BA.debugLineNum = 307;BA.debugLine="ScaleAllDS(pnl, False)";
Debug.ShouldStop(262144);
_scaleallds(_ba,_pnl,scale.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 310;BA.debugLine="If v Is Label Then 'this will catch ALL views wit";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TextView"))) { 
 BA.debugLineNum = 311;BA.debugLine="Dim lbl As Label = v";
Debug.ShouldStop(4194304);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_lbl.setObject(_v.getObject());Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 312;BA.debugLine="lbl.TextSize = lbl.TextSize * cScaleDS";
Debug.ShouldStop(8388608);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_lbl.runMethod(true,"getTextSize"),scale._cscaleds}, "*",0, 0)));
 };
 BA.debugLineNum = 315;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Scr";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.ScrollViewWrapper$MyScrollView"))) { 
 BA.debugLineNum = 318;BA.debugLine="Dim scv As ScrollView";
Debug.ShouldStop(536870912);
_scv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");Debug.locals.put("scv", _scv);
 BA.debugLineNum = 319;BA.debugLine="scv = v";
Debug.ShouldStop(1073741824);
_scv.setObject(_v.getObject());
 BA.debugLineNum = 320;BA.debugLine="ScaleAllDS(scv.Panel, False)";
Debug.ShouldStop(-2147483648);
_scaleallds(_ba,_scv.runMethod(false,"getPanel"),scale.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 321;BA.debugLine="scv.Panel.Height = scv.Panel.Height * cScaleDS";
Debug.ShouldStop(1);
_scv.runMethod(false,"getPanel").runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_scv.runMethod(false,"getPanel").runMethod(true,"getHeight"),scale._cscaleds}, "*",0, 0)));
 }else 
{ BA.debugLineNum = 322;BA.debugLine="Else If GetType(v) = \"anywheresoftware.b4a.object";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper$MyHScrollView"))) { 
 BA.debugLineNum = 325;BA.debugLine="Dim hcv As HorizontalScrollView";
Debug.ShouldStop(16);
_hcv = RemoteObject.createNew ("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");Debug.locals.put("hcv", _hcv);
 BA.debugLineNum = 326;BA.debugLine="hcv = v";
Debug.ShouldStop(32);
_hcv.setObject(_v.getObject());
 BA.debugLineNum = 327;BA.debugLine="ScaleAllDS(hcv.Panel, False)";
Debug.ShouldStop(64);
_scaleallds(_ba,_hcv.runMethod(false,"getPanel"),scale.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 328;BA.debugLine="hcv.Panel.Width = hcv.Panel.Width * cScaleDS";
Debug.ShouldStop(128);
_hcv.runMethod(false,"getPanel").runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_hcv.runMethod(false,"getPanel").runMethod(true,"getWidth"),scale._cscaleds}, "*",0, 0)));
 }else 
{ BA.debugLineNum = 329;BA.debugLine="Else If GetType(v) = \"flm.b4a.scrollview2d.Scroll";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("flm.b4a.scrollview2d.ScrollView2DWrapper$MyScrollView"))) { 
 }else 
{ BA.debugLineNum = 337;BA.debugLine="Else If GetType(v) = \"anywheresoftware.b4a.object";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.ListViewWrapper$SimpleListView"))) { 
 BA.debugLineNum = 340;BA.debugLine="Dim ltv As ListView";
Debug.ShouldStop(524288);
_ltv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");Debug.locals.put("ltv", _ltv);
 BA.debugLineNum = 341;BA.debugLine="ltv = v";
Debug.ShouldStop(1048576);
_ltv.setObject(_v.getObject());
 BA.debugLineNum = 342;BA.debugLine="ScaleViewDS(ltv.SingleLineLayout.Label)";
Debug.ShouldStop(2097152);
_scaleviewds(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getSingleLineLayout").getField(false,"Label").getObject()));
 BA.debugLineNum = 343;BA.debugLine="ltv.SingleLineLayout.ItemHeight = ltv.SingleLine";
Debug.ShouldStop(4194304);
_ltv.runMethod(false,"getSingleLineLayout").runMethod(true,"setItemHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_ltv.runMethod(false,"getSingleLineLayout").runMethod(true,"getItemHeight"),scale._cscaleds}, "*",0, 0)));
 BA.debugLineNum = 345;BA.debugLine="ScaleViewDS(ltv.TwoLinesLayout.Label)";
Debug.ShouldStop(16777216);
_scaleviewds(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesLayout").getField(false,"Label").getObject()));
 BA.debugLineNum = 346;BA.debugLine="ScaleViewDS(ltv.TwoLinesLayout.SecondLabel)";
Debug.ShouldStop(33554432);
_scaleviewds(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesLayout").getField(false,"SecondLabel").getObject()));
 BA.debugLineNum = 347;BA.debugLine="ltv.TwoLinesLayout.ItemHeight = ltv.TwoLinesLayo";
Debug.ShouldStop(67108864);
_ltv.runMethod(false,"getTwoLinesLayout").runMethod(true,"setItemHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_ltv.runMethod(false,"getTwoLinesLayout").runMethod(true,"getItemHeight"),scale._cscaleds}, "*",0, 0)));
 BA.debugLineNum = 349;BA.debugLine="ScaleViewDS(ltv.TwoLinesAndBitmap.Label)";
Debug.ShouldStop(268435456);
_scaleviewds(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"Label").getObject()));
 BA.debugLineNum = 350;BA.debugLine="ScaleViewDS(ltv.TwoLinesAndBitmap.SecondLabel)";
Debug.ShouldStop(536870912);
_scaleviewds(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"SecondLabel").getObject()));
 BA.debugLineNum = 351;BA.debugLine="ScaleViewDS(ltv.TwoLinesAndBitmap.ImageView)";
Debug.ShouldStop(1073741824);
_scaleviewds(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").getObject()));
 BA.debugLineNum = 352;BA.debugLine="ltv.TwoLinesAndBitmap.ItemHeight = ltv.TwoLinesA";
Debug.ShouldStop(-2147483648);
_ltv.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"setItemHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_ltv.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"getItemHeight"),scale._cscaleds}, "*",0, 0)));
 BA.debugLineNum = 354;BA.debugLine="ltv.TwoLinesAndBitmap.ImageView.Top = (ltv.TwoLi";
Debug.ShouldStop(2);
_ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_ltv.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"getItemHeight"),_ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 }else 
{ BA.debugLineNum = 355;BA.debugLine="Else If GetType(v) = \"anywheresoftware.b4a.object";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner"))) { 
 BA.debugLineNum = 358;BA.debugLine="Dim spn As Spinner";
Debug.ShouldStop(32);
_spn = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");Debug.locals.put("spn", _spn);
 BA.debugLineNum = 359;BA.debugLine="spn = v";
Debug.ShouldStop(64);
_spn.setObject(_v.getObject());
 BA.debugLineNum = 360;BA.debugLine="spn.TextSize = spn.TextSize * cScaleDS";
Debug.ShouldStop(128);
_spn.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_spn.runMethod(true,"getTextSize"),scale._cscaleds}, "*",0, 0)));
 }}}}}
;
 BA.debugLineNum = 362;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scaleviewx(RemoteObject _ba,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("ScaleViewX (scale) ","scale",3,_ba,scale.mostCurrent,415);
if (RapidSub.canDelegate("scaleviewx")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","scaleviewx", _ba, _v);
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _scv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
RemoteObject _hcv = RemoteObject.declareNull("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");
RemoteObject _ltv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
RemoteObject _spn = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
;
Debug.locals.put("v", _v);
 BA.debugLineNum = 415;BA.debugLine="Public Sub ScaleViewX(v As View)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 416;BA.debugLine="If IsActivity(v) Then";
Debug.ShouldStop(-2147483648);
if (_isactivity(_ba,_v).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 417;BA.debugLine="Return";
Debug.ShouldStop(1);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 420;BA.debugLine="v.Left = v.Left * cScaleX";
Debug.ShouldStop(8);
_v.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getLeft"),scale._cscalex}, "*",0, 0)));
 BA.debugLineNum = 421;BA.debugLine="v.Top = v.Top * cScaleX";
Debug.ShouldStop(16);
_v.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getTop"),scale._cscalex}, "*",0, 0)));
 BA.debugLineNum = 423;BA.debugLine="If IsPanel(v) Then";
Debug.ShouldStop(64);
if (_ispanel(_ba,_v).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 424;BA.debugLine="Dim pnl As Panel";
Debug.ShouldStop(128);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 425;BA.debugLine="pnl = v";
Debug.ShouldStop(256);
_pnl.setObject(_v.getObject());
 BA.debugLineNum = 426;BA.debugLine="If v.Width > 0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getWidth"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 427;BA.debugLine="v.Width = v.Width * cScaleX";
Debug.ShouldStop(1024);
_v.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getWidth"),scale._cscalex}, "*",0, 0)));
 };
 BA.debugLineNum = 429;BA.debugLine="If v.Height > 0 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getHeight"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 430;BA.debugLine="v.Height = v.Height * cScaleX";
Debug.ShouldStop(8192);
_v.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getHeight"),scale._cscalex}, "*",0, 0)));
 };
 BA.debugLineNum = 432;BA.debugLine="ScaleAllX(pnl, False)";
Debug.ShouldStop(32768);
_scaleallx(_ba,_pnl,scale.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 434;BA.debugLine="If v.Width > 0 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getWidth"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 435;BA.debugLine="v.Width = v.Width * cScaleX";
Debug.ShouldStop(262144);
_v.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getWidth"),scale._cscalex}, "*",0, 0)));
 };
 BA.debugLineNum = 437;BA.debugLine="If v.Height > 0 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean(">",_v.runMethod(true,"getHeight"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 438;BA.debugLine="v.Height = v.Height * cScaleX";
Debug.ShouldStop(2097152);
_v.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_v.runMethod(true,"getHeight"),scale._cscalex}, "*",0, 0)));
 };
 };
 BA.debugLineNum = 442;BA.debugLine="If v Is Label Then 'this will catch ALL views wit";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TextView"))) { 
 BA.debugLineNum = 443;BA.debugLine="Dim lbl As Label = v";
Debug.ShouldStop(67108864);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
_lbl.setObject(_v.getObject());Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 444;BA.debugLine="lbl.TextSize = lbl.TextSize * cScaleX";
Debug.ShouldStop(134217728);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_lbl.runMethod(true,"getTextSize"),scale._cscalex}, "*",0, 0)));
 };
 BA.debugLineNum = 447;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Scr";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.ScrollViewWrapper$MyScrollView"))) { 
 BA.debugLineNum = 450;BA.debugLine="Dim scv As ScrollView";
Debug.ShouldStop(2);
_scv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");Debug.locals.put("scv", _scv);
 BA.debugLineNum = 451;BA.debugLine="scv = v";
Debug.ShouldStop(4);
_scv.setObject(_v.getObject());
 BA.debugLineNum = 452;BA.debugLine="ScaleAllX(scv.Panel, False)";
Debug.ShouldStop(8);
_scaleallx(_ba,_scv.runMethod(false,"getPanel"),scale.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 453;BA.debugLine="scv.Panel.Height = scv.Panel.Height * cScaleX";
Debug.ShouldStop(16);
_scv.runMethod(false,"getPanel").runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_scv.runMethod(false,"getPanel").runMethod(true,"getHeight"),scale._cscalex}, "*",0, 0)));
 }else 
{ BA.debugLineNum = 454;BA.debugLine="Else If GetType(v) = \"anywheresoftware.b4a.object";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper$MyHScrollView"))) { 
 BA.debugLineNum = 457;BA.debugLine="Dim hcv As HorizontalScrollView";
Debug.ShouldStop(256);
_hcv = RemoteObject.createNew ("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");Debug.locals.put("hcv", _hcv);
 BA.debugLineNum = 458;BA.debugLine="hcv = v";
Debug.ShouldStop(512);
_hcv.setObject(_v.getObject());
 BA.debugLineNum = 459;BA.debugLine="ScaleAllX(hcv.Panel, False)";
Debug.ShouldStop(1024);
_scaleallx(_ba,_hcv.runMethod(false,"getPanel"),scale.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 460;BA.debugLine="hcv.Panel.Width = hcv.Panel.Width * cScaleX";
Debug.ShouldStop(2048);
_hcv.runMethod(false,"getPanel").runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_hcv.runMethod(false,"getPanel").runMethod(true,"getWidth"),scale._cscalex}, "*",0, 0)));
 }else 
{ BA.debugLineNum = 461;BA.debugLine="Else If GetType(v) = \"flm.b4a.scrollview2d.Scroll";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("flm.b4a.scrollview2d.ScrollView2DWrapper$MyScrollView"))) { 
 }else 
{ BA.debugLineNum = 469;BA.debugLine="Else If GetType(v) = \"anywheresoftware.b4a.object";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.ListViewWrapper$SimpleListView"))) { 
 BA.debugLineNum = 472;BA.debugLine="Dim ltv As ListView";
Debug.ShouldStop(8388608);
_ltv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");Debug.locals.put("ltv", _ltv);
 BA.debugLineNum = 473;BA.debugLine="ltv = v";
Debug.ShouldStop(16777216);
_ltv.setObject(_v.getObject());
 BA.debugLineNum = 474;BA.debugLine="ScaleViewX(ltv.SingleLineLayout.Label)";
Debug.ShouldStop(33554432);
_scaleviewx(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getSingleLineLayout").getField(false,"Label").getObject()));
 BA.debugLineNum = 475;BA.debugLine="ltv.SingleLineLayout.ItemHeight = ltv.SingleLine";
Debug.ShouldStop(67108864);
_ltv.runMethod(false,"getSingleLineLayout").runMethod(true,"setItemHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_ltv.runMethod(false,"getSingleLineLayout").runMethod(true,"getItemHeight"),scale._cscalex}, "*",0, 0)));
 BA.debugLineNum = 477;BA.debugLine="ScaleViewX(ltv.TwoLinesLayout.Label)";
Debug.ShouldStop(268435456);
_scaleviewx(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesLayout").getField(false,"Label").getObject()));
 BA.debugLineNum = 478;BA.debugLine="ScaleViewX(ltv.TwoLinesLayout.SecondLabel)";
Debug.ShouldStop(536870912);
_scaleviewx(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesLayout").getField(false,"SecondLabel").getObject()));
 BA.debugLineNum = 479;BA.debugLine="ltv.TwoLinesLayout.ItemHeight = ltv.TwoLinesLayo";
Debug.ShouldStop(1073741824);
_ltv.runMethod(false,"getTwoLinesLayout").runMethod(true,"setItemHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_ltv.runMethod(false,"getTwoLinesLayout").runMethod(true,"getItemHeight"),scale._cscalex}, "*",0, 0)));
 BA.debugLineNum = 481;BA.debugLine="ScaleViewX(ltv.TwoLinesAndBitmap.Label)";
Debug.ShouldStop(1);
_scaleviewx(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"Label").getObject()));
 BA.debugLineNum = 482;BA.debugLine="ScaleViewX(ltv.TwoLinesAndBitmap.SecondLabel)";
Debug.ShouldStop(2);
_scaleviewx(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"SecondLabel").getObject()));
 BA.debugLineNum = 483;BA.debugLine="ScaleViewX(ltv.TwoLinesAndBitmap.ImageView)";
Debug.ShouldStop(4);
_scaleviewx(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").getObject()));
 BA.debugLineNum = 484;BA.debugLine="ltv.TwoLinesAndBitmap.ItemHeight = ltv.TwoLinesA";
Debug.ShouldStop(8);
_ltv.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"setItemHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_ltv.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"getItemHeight"),scale._cscalex}, "*",0, 0)));
 BA.debugLineNum = 486;BA.debugLine="ltv.TwoLinesAndBitmap.ImageView.Top = (ltv.TwoLi";
Debug.ShouldStop(32);
_ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_ltv.runMethod(false,"getTwoLinesAndBitmap").runMethod(true,"getItemHeight"),_ltv.runMethod(false,"getTwoLinesAndBitmap").getField(false,"ImageView").runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 }else 
{ BA.debugLineNum = 487;BA.debugLine="Else If GetType(v) = \"anywheresoftware.b4a.object";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",scale.mostCurrent.__c.runMethod(true,"GetType",(Object)((_v.getObject()))),BA.ObjectToString("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner"))) { 
 BA.debugLineNum = 490;BA.debugLine="Dim spn As Spinner";
Debug.ShouldStop(512);
_spn = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");Debug.locals.put("spn", _spn);
 BA.debugLineNum = 491;BA.debugLine="spn = v";
Debug.ShouldStop(1024);
_spn.setObject(_v.getObject());
 BA.debugLineNum = 492;BA.debugLine="spn.TextSize = spn.TextSize * cScaleX";
Debug.ShouldStop(2048);
_spn.runMethod(true,"setTextSize",BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {_spn.runMethod(true,"getTextSize"),scale._cscalex}, "*",0, 0)));
 }}}}}
;
 BA.debugLineNum = 494;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setbottom(RemoteObject _ba,RemoteObject _v,RemoteObject _ybottom) throws Exception{
try {
		Debug.PushSubsStack("SetBottom (scale) ","scale",3,_ba,scale.mostCurrent,561);
if (RapidSub.canDelegate("setbottom")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","setbottom", _ba, _v, _ybottom);
;
Debug.locals.put("v", _v);
Debug.locals.put("yBottom", _ybottom);
 BA.debugLineNum = 561;BA.debugLine="Sub SetBottom(v As View, yBottom As Int)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 562;BA.debugLine="v.Top = yBottom - v.Height";
Debug.ShouldStop(131072);
_v.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_ybottom,_v.runMethod(true,"getHeight")}, "-",1, 1));
 BA.debugLineNum = 563;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setleftandright(RemoteObject _ba,RemoteObject _v,RemoteObject _xleft,RemoteObject _xright) throws Exception{
try {
		Debug.PushSubsStack("SetLeftAndRight (scale) ","scale",3,_ba,scale.mostCurrent,567);
if (RapidSub.canDelegate("setleftandright")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","setleftandright", _ba, _v, _xleft, _xright);
;
Debug.locals.put("v", _v);
Debug.locals.put("xLeft", _xleft);
Debug.locals.put("xRight", _xright);
 BA.debugLineNum = 567;BA.debugLine="Public Sub SetLeftAndRight(v As View, xLeft As Int";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 569;BA.debugLine="v.Left = Min(xLeft, xRight)";
Debug.ShouldStop(16777216);
_v.runMethod(true,"setLeft",BA.numberCast(int.class, scale.mostCurrent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, _xleft)),(Object)(BA.numberCast(double.class, _xright)))));
 BA.debugLineNum = 570;BA.debugLine="v.Width = Max(xLeft, xRight) - v.Left";
Debug.ShouldStop(33554432);
_v.runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, _xleft)),(Object)(BA.numberCast(double.class, _xright))),_v.runMethod(true,"getLeft")}, "-",1, 0)));
 BA.debugLineNum = 571;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setleftandright2(RemoteObject _ba,RemoteObject _v,RemoteObject _vleft,RemoteObject _dxl,RemoteObject _vright,RemoteObject _dxr) throws Exception{
try {
		Debug.PushSubsStack("SetLeftAndRight2 (scale) ","scale",3,_ba,scale.mostCurrent,577);
if (RapidSub.canDelegate("setleftandright2")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","setleftandright2", _ba, _v, _vleft, _dxl, _vright, _dxr);
RemoteObject _v1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
;
Debug.locals.put("v", _v);
Debug.locals.put("vLeft", _vleft);
Debug.locals.put("dxL", _dxl);
Debug.locals.put("vRight", _vright);
Debug.locals.put("dxR", _dxr);
 BA.debugLineNum = 577;BA.debugLine="Public Sub SetLeftAndRight2(v As View, vLeft As Vi";
Debug.ShouldStop(1);
 BA.debugLineNum = 579;BA.debugLine="If IsActivity(v) Then";
Debug.ShouldStop(4);
if (_isactivity(_ba,_v).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 580;BA.debugLine="ToastMessageShow(\"The view is an Activity !\", Fa";
Debug.ShouldStop(8);
scale.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("The view is an Activity !")),(Object)(scale.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 581;BA.debugLine="Return";
Debug.ShouldStop(16);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 585;BA.debugLine="If IsActivity(vLeft) = False AND IsActivity(vRigh";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_isactivity(_ba,_vleft),scale.mostCurrent.__c.getField(true,"False")) && RemoteObject.solveBoolean("=",_isactivity(_ba,_vright),scale.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 586;BA.debugLine="If vLeft.Left > vRight.Left Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean(">",_vleft.runMethod(true,"getLeft"),BA.numberCast(double.class, _vright.runMethod(true,"getLeft")))) { 
 BA.debugLineNum = 587;BA.debugLine="Dim v1 As View";
Debug.ShouldStop(1024);
_v1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");Debug.locals.put("v1", _v1);
 BA.debugLineNum = 588;BA.debugLine="v1 = vLeft";
Debug.ShouldStop(2048);
_v1 = _vleft;Debug.locals.put("v1", _v1);
 BA.debugLineNum = 589;BA.debugLine="vLeft = vRight";
Debug.ShouldStop(4096);
_vleft = _vright;Debug.locals.put("vLeft", _vleft);
 BA.debugLineNum = 590;BA.debugLine="vRight = v1";
Debug.ShouldStop(8192);
_vright = _v1;Debug.locals.put("vRight", _vright);
 };
 };
 BA.debugLineNum = 594;BA.debugLine="If IsActivity(vLeft) Then";
Debug.ShouldStop(131072);
if (_isactivity(_ba,_vleft).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 595;BA.debugLine="v.Left = dxL";
Debug.ShouldStop(262144);
_v.runMethod(true,"setLeft",_dxl);
 BA.debugLineNum = 596;BA.debugLine="If IsActivity(vRight) Then";
Debug.ShouldStop(524288);
if (_isactivity(_ba,_vright).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 597;BA.debugLine="v.Width = 100%x - dxL - dxR";
Debug.ShouldStop(1048576);
_v.runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_dxl,_dxr}, "--",2, 1));
 }else {
 BA.debugLineNum = 599;BA.debugLine="v.Width = vRight.Left - dxL - dxR";
Debug.ShouldStop(4194304);
_v.runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {_vright.runMethod(true,"getLeft"),_dxl,_dxr}, "--",2, 1));
 };
 }else {
 BA.debugLineNum = 602;BA.debugLine="v.Left = vLeft.Left + vLeft.Width + dxL";
Debug.ShouldStop(33554432);
_v.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {_vleft.runMethod(true,"getLeft"),_vleft.runMethod(true,"getWidth"),_dxl}, "++",2, 1));
 BA.debugLineNum = 603;BA.debugLine="If IsActivity(vRight) Then";
Debug.ShouldStop(67108864);
if (_isactivity(_ba,_vright).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 604;BA.debugLine="v.Width = 100%x - v.Left";
Debug.ShouldStop(134217728);
_v.runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_v.runMethod(true,"getLeft")}, "-",1, 1));
 }else {
 BA.debugLineNum = 606;BA.debugLine="v.Width = vRight.Left - v.Left - dxR";
Debug.ShouldStop(536870912);
_v.runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {_vright.runMethod(true,"getLeft"),_v.runMethod(true,"getLeft"),_dxr}, "--",2, 1));
 };
 };
 BA.debugLineNum = 609;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setrate(RemoteObject _ba,RemoteObject _crate) throws Exception{
try {
		Debug.PushSubsStack("SetRate (scale) ","scale",3,_ba,scale.mostCurrent,146);
if (RapidSub.canDelegate("setrate")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","setrate", _ba, _crate);
;
Debug.locals.put("cRate", _crate);
 BA.debugLineNum = 146;BA.debugLine="Public Sub SetRate(cRate As Double)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="Rate = cRate";
Debug.ShouldStop(262144);
scale._rate = _crate;
 BA.debugLineNum = 148;BA.debugLine="Initialize";
Debug.ShouldStop(524288);
_initialize(_ba);
 BA.debugLineNum = 149;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setreferencelayout(RemoteObject _ba,RemoteObject _width,RemoteObject _height,RemoteObject _scale) throws Exception{
try {
		Debug.PushSubsStack("SetReferenceLayout (scale) ","scale",3,_ba,scale.mostCurrent,697);
if (RapidSub.canDelegate("setreferencelayout")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","setreferencelayout", _ba, _width, _height, _scale);
;
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
Debug.locals.put("Scale", _scale);
 BA.debugLineNum = 697;BA.debugLine="Public Sub SetReferenceLayout(Width As Int, Height";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 698;BA.debugLine="If Width < Height Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("<",_width,BA.numberCast(double.class, _height))) { 
 BA.debugLineNum = 699;BA.debugLine="cRefWidth = Width";
Debug.ShouldStop(67108864);
scale._crefwidth = _width;
 BA.debugLineNum = 700;BA.debugLine="cRefHeight = Height";
Debug.ShouldStop(134217728);
scale._crefheight = _height;
 }else {
 BA.debugLineNum = 702;BA.debugLine="cRefWidth = Height";
Debug.ShouldStop(536870912);
scale._crefwidth = _height;
 BA.debugLineNum = 703;BA.debugLine="cRefHeight = Width";
Debug.ShouldStop(1073741824);
scale._crefheight = _width;
 };
 BA.debugLineNum = 705;BA.debugLine="cRefScale = Scale";
Debug.ShouldStop(1);
scale._crefscale = _scale;
 BA.debugLineNum = 706;BA.debugLine="Initialize";
Debug.ShouldStop(2);
_initialize(_ba);
 BA.debugLineNum = 707;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setright(RemoteObject _ba,RemoteObject _v,RemoteObject _xright) throws Exception{
try {
		Debug.PushSubsStack("SetRight (scale) ","scale",3,_ba,scale.mostCurrent,555);
if (RapidSub.canDelegate("setright")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","setright", _ba, _v, _xright);
;
Debug.locals.put("v", _v);
Debug.locals.put("xRight", _xright);
 BA.debugLineNum = 555;BA.debugLine="Sub SetRight(v As View, xRight As Int)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 556;BA.debugLine="v.Left = xRight - v.Width";
Debug.ShouldStop(2048);
_v.runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {_xright,_v.runMethod(true,"getWidth")}, "-",1, 1));
 BA.debugLineNum = 557;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _settopandbottom(RemoteObject _ba,RemoteObject _v,RemoteObject _ytop,RemoteObject _ybottom) throws Exception{
try {
		Debug.PushSubsStack("SetTopAndBottom (scale) ","scale",3,_ba,scale.mostCurrent,613);
if (RapidSub.canDelegate("settopandbottom")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","settopandbottom", _ba, _v, _ytop, _ybottom);
;
Debug.locals.put("v", _v);
Debug.locals.put("yTop", _ytop);
Debug.locals.put("yBottom", _ybottom);
 BA.debugLineNum = 613;BA.debugLine="Public Sub SetTopAndBottom(v As View, yTop As Int,";
Debug.ShouldStop(16);
 BA.debugLineNum = 615;BA.debugLine="v.Top = Min(yTop, yBottom)";
Debug.ShouldStop(64);
_v.runMethod(true,"setTop",BA.numberCast(int.class, scale.mostCurrent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, _ytop)),(Object)(BA.numberCast(double.class, _ybottom)))));
 BA.debugLineNum = 616;BA.debugLine="v.Height = Max(yTop, yBottom) - v.Top";
Debug.ShouldStop(128);
_v.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, _ytop)),(Object)(BA.numberCast(double.class, _ybottom))),_v.runMethod(true,"getTop")}, "-",1, 0)));
 BA.debugLineNum = 617;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _settopandbottom2(RemoteObject _ba,RemoteObject _v,RemoteObject _vtop,RemoteObject _dyt,RemoteObject _vbottom,RemoteObject _dyb) throws Exception{
try {
		Debug.PushSubsStack("SetTopAndBottom2 (scale) ","scale",3,_ba,scale.mostCurrent,623);
if (RapidSub.canDelegate("settopandbottom2")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","settopandbottom2", _ba, _v, _vtop, _dyt, _vbottom, _dyb);
RemoteObject _v1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
;
Debug.locals.put("v", _v);
Debug.locals.put("vTop", _vtop);
Debug.locals.put("dyT", _dyt);
Debug.locals.put("vBottom", _vbottom);
Debug.locals.put("dyB", _dyb);
 BA.debugLineNum = 623;BA.debugLine="Public Sub SetTopAndBottom2(v As View, vTop As Vie";
Debug.ShouldStop(16384);
 BA.debugLineNum = 625;BA.debugLine="If IsActivity(v) Then";
Debug.ShouldStop(65536);
if (_isactivity(_ba,_v).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 626;BA.debugLine="ToastMessageShow(\"The view is an Activity !\", Fa";
Debug.ShouldStop(131072);
scale.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("The view is an Activity !")),(Object)(scale.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 627;BA.debugLine="Return";
Debug.ShouldStop(262144);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 630;BA.debugLine="If IsActivity(vTop) = False AND IsActivity(vBotto";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_isactivity(_ba,_vtop),scale.mostCurrent.__c.getField(true,"False")) && RemoteObject.solveBoolean("=",_isactivity(_ba,_vbottom),scale.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 632;BA.debugLine="If vTop.Top > vBottom.Top Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean(">",_vtop.runMethod(true,"getTop"),BA.numberCast(double.class, _vbottom.runMethod(true,"getTop")))) { 
 BA.debugLineNum = 633;BA.debugLine="Dim v1 As View";
Debug.ShouldStop(16777216);
_v1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");Debug.locals.put("v1", _v1);
 BA.debugLineNum = 634;BA.debugLine="v1 = vTop";
Debug.ShouldStop(33554432);
_v1 = _vtop;Debug.locals.put("v1", _v1);
 BA.debugLineNum = 635;BA.debugLine="vTop = vBottom";
Debug.ShouldStop(67108864);
_vtop = _vbottom;Debug.locals.put("vTop", _vtop);
 BA.debugLineNum = 636;BA.debugLine="vBottom = v1";
Debug.ShouldStop(134217728);
_vbottom = _v1;Debug.locals.put("vBottom", _vbottom);
 };
 };
 BA.debugLineNum = 640;BA.debugLine="If IsActivity(vTop) Then";
Debug.ShouldStop(-2147483648);
if (_isactivity(_ba,_vtop).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 641;BA.debugLine="v.Top = dyT";
Debug.ShouldStop(1);
_v.runMethod(true,"setTop",_dyt);
 BA.debugLineNum = 642;BA.debugLine="If IsActivity(vBottom) Then";
Debug.ShouldStop(2);
if (_isactivity(_ba,_vbottom).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 643;BA.debugLine="v.Height = 100%y - dyT - dyB";
Debug.ShouldStop(4);
_v.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_dyt,_dyb}, "--",2, 1));
 }else {
 BA.debugLineNum = 645;BA.debugLine="v.Height = vBottom.Top - dyT - dyB";
Debug.ShouldStop(16);
_v.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_vbottom.runMethod(true,"getTop"),_dyt,_dyb}, "--",2, 1));
 };
 }else {
 BA.debugLineNum = 648;BA.debugLine="v.Top = vTop.Top + vTop.Height + dyT";
Debug.ShouldStop(128);
_v.runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_vtop.runMethod(true,"getTop"),_vtop.runMethod(true,"getHeight"),_dyt}, "++",2, 1));
 BA.debugLineNum = 649;BA.debugLine="If IsActivity(vBottom) Then";
Debug.ShouldStop(256);
if (_isactivity(_ba,_vbottom).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 650;BA.debugLine="v.Height = 100%y - v.Top - dyB";
Debug.ShouldStop(512);
_v.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_v.runMethod(true,"getTop"),_dyb}, "--",2, 1));
 }else {
 BA.debugLineNum = 652;BA.debugLine="v.Height = vBottom.Top - v.Top - dyB";
Debug.ShouldStop(2048);
_v.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_vbottom.runMethod(true,"getTop"),_v.runMethod(true,"getTop"),_dyb}, "--",2, 1));
 };
 };
 BA.debugLineNum = 655;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _verticalcenter(RemoteObject _ba,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("VerticalCenter (scale) ","scale",3,_ba,scale.mostCurrent,526);
if (RapidSub.canDelegate("verticalcenter")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","verticalcenter", _ba, _v);
;
Debug.locals.put("v", _v);
 BA.debugLineNum = 526;BA.debugLine="Public Sub VerticalCenter(v As View)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 527;BA.debugLine="v.Top = (100%y - v.Height) / 2";
Debug.ShouldStop(16384);
_v.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_v.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 528;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _verticalcenter2(RemoteObject _ba,RemoteObject _v,RemoteObject _vtop,RemoteObject _vbottom) throws Exception{
try {
		Debug.PushSubsStack("VerticalCenter2 (scale) ","scale",3,_ba,scale.mostCurrent,532);
if (RapidSub.canDelegate("verticalcenter2")) return b4a.AutoScaleExample7.scale.remoteMe.runUserSub(false, "scale","verticalcenter2", _ba, _v, _vtop, _vbottom);
;
Debug.locals.put("v", _v);
Debug.locals.put("vTop", _vtop);
Debug.locals.put("vBottom", _vbottom);
 BA.debugLineNum = 532;BA.debugLine="Public Sub VerticalCenter2(v As View, vTop As View";
Debug.ShouldStop(524288);
 BA.debugLineNum = 533;BA.debugLine="If IsActivity(v) Then";
Debug.ShouldStop(1048576);
if (_isactivity(_ba,_v).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 534;BA.debugLine="ToastMessageShow(\"The view is an Activity !\", Fa";
Debug.ShouldStop(2097152);
scale.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("The view is an Activity !")),(Object)(scale.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 535;BA.debugLine="Return";
Debug.ShouldStop(4194304);
if (true) return RemoteObject.createImmutable("");
 }else {
 BA.debugLineNum = 537;BA.debugLine="If IsActivity(vTop) Then";
Debug.ShouldStop(16777216);
if (_isactivity(_ba,_vtop).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 538;BA.debugLine="If IsActivity(vBottom) Then";
Debug.ShouldStop(33554432);
if (_isactivity(_ba,_vbottom).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 539;BA.debugLine="v.Top = (100%y - v.Height) / 2";
Debug.ShouldStop(67108864);
_v.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),_v.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 }else {
 BA.debugLineNum = 541;BA.debugLine="v.Top = (vBottom.Top - v.Height) / 2";
Debug.ShouldStop(268435456);
_v.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_vbottom.runMethod(true,"getTop"),_v.runMethod(true,"getHeight")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 };
 }else {
 BA.debugLineNum = 544;BA.debugLine="If IsActivity(vBottom) Then";
Debug.ShouldStop(-2147483648);
if (_isactivity(_ba,_vbottom).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 545;BA.debugLine="v.Top = vTop.Top + vTop.Height + (100%y - (vTo";
Debug.ShouldStop(1);
_v.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_vtop.runMethod(true,"getTop"),_vtop.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {scale.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),_ba),(RemoteObject.solve(new RemoteObject[] {_vtop.runMethod(true,"getTop"),_vtop.runMethod(true,"getHeight")}, "+",1, 1)),_v.runMethod(true,"getHeight")}, "--",2, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 }else {
 BA.debugLineNum = 547;BA.debugLine="v.Top = vTop.Top + vTop.Height + (vBottom.Top";
Debug.ShouldStop(4);
_v.runMethod(true,"setTop",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_vtop.runMethod(true,"getTop"),_vtop.runMethod(true,"getHeight"),(RemoteObject.solve(new RemoteObject[] {_vbottom.runMethod(true,"getTop"),(RemoteObject.solve(new RemoteObject[] {_vtop.runMethod(true,"getTop"),_vtop.runMethod(true,"getHeight")}, "+",1, 1)),_v.runMethod(true,"getHeight")}, "--",2, 1)),RemoteObject.createImmutable(2)}, "++/",2, 0)));
 };
 };
 };
 BA.debugLineNum = 551;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}