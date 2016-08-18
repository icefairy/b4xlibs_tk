package com.zxdemo;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class cameraexclass extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.zxdemo.cameraexclass");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.zxdemo.cameraexclass.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public Object _nativecam = null;
public anywheresoftware.b4a.objects.CameraW _cam = null;
public anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
public Object _target = null;
public String _event = "";
public boolean _front = false;
public Object _parameters = null;
public com.zxdemo.main _main = null;
public com.zxdemo.actzxscanner _actzxscanner = null;
public static class _camerainfoandid{
public boolean IsInitialized;
public Object CameraInfo;
public int Id;
public void Initialize() {
IsInitialized = true;
CameraInfo = new Object();
Id = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _camerasize{
public boolean IsInitialized;
public int Width;
public int Height;
public void Initialize() {
IsInitialized = true;
Width = 0;
Height = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _camera_focusdone(boolean _success) throws Exception{
 //BA.debugLineNum = 275;BA.debugLine="Private Sub Camera_FocusDone (Success As Boolean)";
 //BA.debugLineNum = 276;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 277;BA.debugLine="TakePicture";
_takepicture();
 }else {
 //BA.debugLineNum = 279;BA.debugLine="Log(\"AutoFocus error.\")";
__c.Log("AutoFocus error.");
 };
 //BA.debugLineNum = 281;BA.debugLine="End Sub";
return "";
}
public String  _camera_picturetaken(byte[] _data) throws Exception{
 //BA.debugLineNum = 104;BA.debugLine="Private Sub Camera_PictureTaken (Data() As Byte)";
 //BA.debugLineNum = 105;BA.debugLine="CallSub2(target, event & \"_PictureTaken\", Data)";
__c.CallSubNew2(ba,_target,_event+"_PictureTaken",(Object)(_data));
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
public String  _camera_preview(byte[] _data) throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="Sub Camera_Preview (Data() As Byte)";
 //BA.debugLineNum = 96;BA.debugLine="If SubExists(target, event & \"_preview\") Then";
if (__c.SubExists(ba,_target,_event+"_preview")) { 
 //BA.debugLineNum = 97;BA.debugLine="CallSub2(target, event & \"_preview\", Data)";
__c.CallSubNew2(ba,_target,_event+"_preview",(Object)(_data));
 };
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public String  _camera_ready(boolean _success) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Private Sub Camera_Ready (Success As Boolean)";
 //BA.debugLineNum = 83;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 84;BA.debugLine="r.target = cam";
_r.Target = (Object)(_cam);
 //BA.debugLineNum = 85;BA.debugLine="nativeCam = r.GetField(\"camera\")";
_nativecam = _r.GetField("camera");
 //BA.debugLineNum = 86;BA.debugLine="r.target = nativeCam";
_r.Target = _nativecam;
 //BA.debugLineNum = 87;BA.debugLine="parameters = r.RunMethod(\"getParameters\")";
_parameters = _r.RunMethod("getParameters");
 //BA.debugLineNum = 88;BA.debugLine="SetDisplayOrientation";
_setdisplayorientation();
 }else {
 //BA.debugLineNum = 90;BA.debugLine="Log(\"success = false, \" & LastException)";
__c.Log("success = false, "+BA.ObjectToString(__c.LastException(ba)));
 };
 //BA.debugLineNum = 92;BA.debugLine="CallSub2(target, event & \"_ready\", Success)";
__c.CallSubNew2(ba,_target,_event+"_ready",(Object)(_success));
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private nativeCam As Object";
_nativecam = new Object();
 //BA.debugLineNum = 9;BA.debugLine="Private cam As Camera";
_cam = new anywheresoftware.b4a.objects.CameraW();
 //BA.debugLineNum = 10;BA.debugLine="Private r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 11;BA.debugLine="Private target As Object";
_target = new Object();
 //BA.debugLineNum = 12;BA.debugLine="Private event As String";
_event = "";
 //BA.debugLineNum = 13;BA.debugLine="Public Front As Boolean";
_front = false;
 //BA.debugLineNum = 14;BA.debugLine="Type CameraInfoAndId (CameraInfo As Object, Id As";
;
 //BA.debugLineNum = 15;BA.debugLine="Type CameraSize (Width As Int, Height As Int)";
;
 //BA.debugLineNum = 16;BA.debugLine="Private parameters As Object";
_parameters = new Object();
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _closenow() throws Exception{
 //BA.debugLineNum = 266;BA.debugLine="Public Sub CloseNow";
 //BA.debugLineNum = 267;BA.debugLine="cam.Release";
_cam.Release();
 //BA.debugLineNum = 268;BA.debugLine="r.target = cam";
_r.Target = (Object)(_cam);
 //BA.debugLineNum = 269;BA.debugLine="r.RunMethod2(\"releaseCameras\", True, \"java.lang.b";
_r.RunMethod2("releaseCameras",BA.ObjectToString(__c.True),"java.lang.boolean");
 //BA.debugLineNum = 270;BA.debugLine="End Sub";
return "";
}
public String  _commitparameters() throws Exception{
 //BA.debugLineNum = 137;BA.debugLine="Public Sub CommitParameters";
 //BA.debugLineNum = 138;BA.debugLine="Try";
try { //BA.debugLineNum = 139;BA.debugLine="r.target = nativeCam";
_r.Target = _nativecam;
 //BA.debugLineNum = 140;BA.debugLine="r.RunMethod4(\"setParameters\", Array As Object(pa";
_r.RunMethod4("setParameters",new Object[]{_parameters},new String[]{"android.hardware.Camera$Parameters"});
 } 
       catch (Exception e5) {
			ba.setLastException(e5); //BA.debugLineNum = 142;BA.debugLine="ToastMessageShow(\"Error setting parameters.\", Tr";
__c.ToastMessageShow("Error setting parameters.",__c.True);
 //BA.debugLineNum = 143;BA.debugLine="Log(LastException)";
__c.Log(BA.ObjectToString(__c.LastException(ba)));
 };
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return "";
}
public com.zxdemo.cameraexclass._camerainfoandid  _findcamera(boolean _frontcamera) throws Exception{
com.zxdemo.cameraexclass._camerainfoandid _ci = null;
Object _camerainfo = null;
int _cameravalue = 0;
int _numberofcameras = 0;
int _i = 0;
 //BA.debugLineNum = 36;BA.debugLine="Private Sub FindCamera (frontCamera As Boolean) As";
 //BA.debugLineNum = 37;BA.debugLine="Dim ci As CameraInfoAndId";
_ci = new com.zxdemo.cameraexclass._camerainfoandid();
 //BA.debugLineNum = 38;BA.debugLine="Dim cameraInfo As Object";
_camerainfo = new Object();
 //BA.debugLineNum = 39;BA.debugLine="Dim cameraValue As Int";
_cameravalue = 0;
 //BA.debugLineNum = 40;BA.debugLine="If frontCamera Then cameraValue = 1 Else cameraVa";
if (_frontcamera) { 
_cameravalue = (int) (1);}
else {
_cameravalue = (int) (0);};
 //BA.debugLineNum = 41;BA.debugLine="cameraInfo = r.CreateObject(\"android.hardware.Cam";
_camerainfo = _r.CreateObject("android.hardware.Camera$CameraInfo");
 //BA.debugLineNum = 42;BA.debugLine="Dim numberOfCameras As Int = r.RunStaticMethod(\"a";
_numberofcameras = (int)(BA.ObjectToNumber(_r.RunStaticMethod("android.hardware.Camera","getNumberOfCameras",(Object[])(__c.Null),(String[])(__c.Null))));
 //BA.debugLineNum = 43;BA.debugLine="For i = 0 To numberOfCameras - 1";
{
final int step7 = 1;
final int limit7 = (int) (_numberofcameras-1);
for (_i = (int) (0) ; (step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7); _i = ((int)(0 + _i + step7)) ) {
 //BA.debugLineNum = 44;BA.debugLine="r.RunStaticMethod(\"android.hardware.Camera\", \"ge";
_r.RunStaticMethod("android.hardware.Camera","getCameraInfo",new Object[]{(Object)(_i),_camerainfo},new String[]{"java.lang.int","android.hardware.Camera$CameraInfo"});
 //BA.debugLineNum = 46;BA.debugLine="r.target = cameraInfo";
_r.Target = _camerainfo;
 //BA.debugLineNum = 47;BA.debugLine="If r.GetField(\"facing\") = cameraValue Then";
if ((_r.GetField("facing")).equals((Object)(_cameravalue))) { 
 //BA.debugLineNum = 48;BA.debugLine="ci.cameraInfo = r.target";
_ci.CameraInfo = _r.Target;
 //BA.debugLineNum = 49;BA.debugLine="ci.Id = i";
_ci.Id = _i;
 //BA.debugLineNum = 50;BA.debugLine="Return ci";
if (true) return _ci;
 };
 }
};
 //BA.debugLineNum = 53;BA.debugLine="ci.id = -1";
_ci.Id = (int) (-1);
 //BA.debugLineNum = 54;BA.debugLine="Return ci";
if (true) return _ci;
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return null;
}
public String  _focusandtakepicture() throws Exception{
 //BA.debugLineNum = 272;BA.debugLine="Public Sub FocusAndTakePicture";
 //BA.debugLineNum = 273;BA.debugLine="cam.AutoFocus";
_cam.AutoFocus();
 //BA.debugLineNum = 274;BA.debugLine="End Sub";
return "";
}
public String  _getcoloreffect() throws Exception{
 //BA.debugLineNum = 147;BA.debugLine="Public Sub GetColorEffect As String";
 //BA.debugLineNum = 148;BA.debugLine="Return GetParameter(\"effect\")";
if (true) return _getparameter("effect");
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public String  _getflashmode() throws Exception{
 //BA.debugLineNum = 182;BA.debugLine="Public Sub GetFlashMode As String";
 //BA.debugLineNum = 183;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 184;BA.debugLine="Return r.RunMethod(\"getFlashMode\")";
if (true) return BA.ObjectToString(_r.RunMethod("getFlashMode"));
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return "";
}
public float[]  _getfocusdistances() throws Exception{
float[] _f = null;
 //BA.debugLineNum = 258;BA.debugLine="Public Sub GetFocusDistances As Float()";
 //BA.debugLineNum = 259;BA.debugLine="Dim F(3) As Float";
_f = new float[(int) (3)];
;
 //BA.debugLineNum = 260;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 261;BA.debugLine="r.RunMethod4(\"getFocusDistances\", Array As Object";
_r.RunMethod4("getFocusDistances",new Object[]{(Object)(_f)},new String[]{"[F"});
 //BA.debugLineNum = 262;BA.debugLine="Return F";
if (true) return _f;
 //BA.debugLineNum = 263;BA.debugLine="End Sub";
return null;
}
public String  _getparameter(String _key) throws Exception{
 //BA.debugLineNum = 132;BA.debugLine="Public Sub GetParameter(Key As String) As String";
 //BA.debugLineNum = 133;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 134;BA.debugLine="Return r.RunMethod2(\"get\", Key, \"java.lang.String";
if (true) return BA.ObjectToString(_r.RunMethod2("get",_key,"java.lang.String"));
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public com.zxdemo.cameraexclass._camerasize  _getpicturesize() throws Exception{
com.zxdemo.cameraexclass._camerasize _cs = null;
 //BA.debugLineNum = 206;BA.debugLine="Public Sub GetPictureSize As CameraSize";
 //BA.debugLineNum = 207;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 208;BA.debugLine="r.target = r.RunMethod(\"getPictureSize\")";
_r.Target = _r.RunMethod("getPictureSize");
 //BA.debugLineNum = 209;BA.debugLine="Dim cs As CameraSize";
_cs = new com.zxdemo.cameraexclass._camerasize();
 //BA.debugLineNum = 210;BA.debugLine="cs.Width = r.GetField(\"width\")";
_cs.Width = (int)(BA.ObjectToNumber(_r.GetField("width")));
 //BA.debugLineNum = 211;BA.debugLine="cs.Height = r.GetField(\"height\")";
_cs.Height = (int)(BA.ObjectToNumber(_r.GetField("height")));
 //BA.debugLineNum = 212;BA.debugLine="Return cs";
if (true) return _cs;
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return null;
}
public com.zxdemo.cameraexclass._camerasize  _getpreviewsize() throws Exception{
com.zxdemo.cameraexclass._camerasize _cs = null;
 //BA.debugLineNum = 197;BA.debugLine="Public Sub GetPreviewSize As CameraSize";
 //BA.debugLineNum = 198;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 199;BA.debugLine="r.target = r.RunMethod(\"getPreviewSize\")";
_r.Target = _r.RunMethod("getPreviewSize");
 //BA.debugLineNum = 200;BA.debugLine="Dim cs As CameraSize";
_cs = new com.zxdemo.cameraexclass._camerasize();
 //BA.debugLineNum = 201;BA.debugLine="cs.Width = r.GetField(\"width\")";
_cs.Width = (int)(BA.ObjectToNumber(_r.GetField("width")));
 //BA.debugLineNum = 202;BA.debugLine="cs.Height = r.GetField(\"height\")";
_cs.Height = (int)(BA.ObjectToNumber(_r.GetField("height")));
 //BA.debugLineNum = 203;BA.debugLine="Return cs";
if (true) return _cs;
 //BA.debugLineNum = 204;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedcoloreffects() throws Exception{
 //BA.debugLineNum = 192;BA.debugLine="Public Sub GetSupportedColorEffects As List";
 //BA.debugLineNum = 193;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 194;BA.debugLine="Return r.RunMethod(\"getSupportedColorEffects\")";
if (true) return (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_r.RunMethod("getSupportedColorEffects")));
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedflashmodes() throws Exception{
 //BA.debugLineNum = 187;BA.debugLine="Public Sub GetSupportedFlashModes As List";
 //BA.debugLineNum = 188;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 189;BA.debugLine="Return r.RunMethod(\"getSupportedFlashModes\")";
if (true) return (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_r.RunMethod("getSupportedFlashModes")));
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getsupportedfocusmodes() throws Exception{
 //BA.debugLineNum = 237;BA.debugLine="Public Sub GetSupportedFocusModes As List";
 //BA.debugLineNum = 238;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 239;BA.debugLine="Return r.RunMethod(\"getSupportedFocusModes\")";
if (true) return (anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_r.RunMethod("getSupportedFocusModes")));
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return null;
}
public com.zxdemo.cameraexclass._camerasize[]  _getsupportedpicturessizes() throws Exception{
anywheresoftware.b4a.objects.collections.List _list1 = null;
com.zxdemo.cameraexclass._camerasize[] _cs = null;
int _i = 0;
 //BA.debugLineNum = 155;BA.debugLine="Public Sub GetSupportedPicturesSizes As CameraSize";
 //BA.debugLineNum = 156;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 157;BA.debugLine="Dim list1 As List = r.RunMethod(\"getSupportedPict";
_list1 = new anywheresoftware.b4a.objects.collections.List();
_list1.setObject((java.util.List)(_r.RunMethod("getSupportedPictureSizes")));
 //BA.debugLineNum = 158;BA.debugLine="Dim cs(list1.Size) As CameraSize";
_cs = new com.zxdemo.cameraexclass._camerasize[_list1.getSize()];
{
int d0 = _cs.length;
for (int i0 = 0;i0 < d0;i0++) {
_cs[i0] = new com.zxdemo.cameraexclass._camerasize();
}
}
;
 //BA.debugLineNum = 159;BA.debugLine="For i = 0 To list1.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_list1.getSize()-1);
for (_i = (int) (0) ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
 //BA.debugLineNum = 160;BA.debugLine="r.target = list1.Get(i)";
_r.Target = _list1.Get(_i);
 //BA.debugLineNum = 161;BA.debugLine="cs(i).Width = r.GetField(\"width\")";
_cs[_i].Width = (int)(BA.ObjectToNumber(_r.GetField("width")));
 //BA.debugLineNum = 162;BA.debugLine="cs(i).Height = r.GetField(\"height\")";
_cs[_i].Height = (int)(BA.ObjectToNumber(_r.GetField("height")));
 }
};
 //BA.debugLineNum = 164;BA.debugLine="Return cs";
if (true) return _cs;
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _panel1,boolean _frontcamera,Object _targetmodule,String _eventname) throws Exception{
innerInitialize(_ba);
int _id = 0;
 //BA.debugLineNum = 19;BA.debugLine="Public Sub Initialize (Panel1 As Panel, FrontCamer";
 //BA.debugLineNum = 20;BA.debugLine="target = TargetModule";
_target = _targetmodule;
 //BA.debugLineNum = 21;BA.debugLine="event = EventName";
_event = _eventname;
 //BA.debugLineNum = 22;BA.debugLine="Front = FrontCamera";
_front = _frontcamera;
 //BA.debugLineNum = 23;BA.debugLine="Dim id As Int";
_id = 0;
 //BA.debugLineNum = 24;BA.debugLine="id = FindCamera(Front).id";
_id = _findcamera(_front).Id;
 //BA.debugLineNum = 25;BA.debugLine="If id = -1 Then";
if (_id==-1) { 
 //BA.debugLineNum = 26;BA.debugLine="Front = Not(Front) 'try different camera";
_front = __c.Not(_front);
 //BA.debugLineNum = 27;BA.debugLine="id = FindCamera(Front).id";
_id = _findcamera(_front).Id;
 //BA.debugLineNum = 28;BA.debugLine="If id = -1 Then";
if (_id==-1) { 
 //BA.debugLineNum = 29;BA.debugLine="ToastMessageShow(\"No camera found.\", True)";
__c.ToastMessageShow("No camera found.",__c.True);
 //BA.debugLineNum = 30;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 33;BA.debugLine="cam.Initialize2(Panel1, \"camera\", id)";
_cam.Initialize2(ba,(android.view.ViewGroup)(_panel1.getObject()),"camera",_id);
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public byte[]  _previewimagetojpeg(byte[] _data,int _quality) throws Exception{
Object _size = null;
Object _previewformat = null;
int _width = 0;
int _height = 0;
Object _yuvimage = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _rect1 = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 217;BA.debugLine="Public Sub PreviewImageToJpeg(data() As Byte, qual";
 //BA.debugLineNum = 218;BA.debugLine="Dim size, previewFormat As Object";
_size = new Object();
_previewformat = new Object();
 //BA.debugLineNum = 219;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 220;BA.debugLine="size = r.RunMethod(\"getPreviewSize\")";
_size = _r.RunMethod("getPreviewSize");
 //BA.debugLineNum = 221;BA.debugLine="previewFormat = r.RunMethod(\"getPreviewFormat\")";
_previewformat = _r.RunMethod("getPreviewFormat");
 //BA.debugLineNum = 222;BA.debugLine="r.target = size";
_r.Target = _size;
 //BA.debugLineNum = 223;BA.debugLine="Dim width = r.GetField(\"width\"), height = r.GetFi";
_width = (int)(BA.ObjectToNumber(_r.GetField("width")));
_height = (int)(BA.ObjectToNumber(_r.GetField("height")));
 //BA.debugLineNum = 224;BA.debugLine="Dim yuvImage As Object = r.CreateObject2(\"android";
_yuvimage = _r.CreateObject2("android.graphics.YuvImage",new Object[]{(Object)(_data),_previewformat,(Object)(_width),(Object)(_height),__c.Null},new String[]{"[B","java.lang.int","java.lang.int","java.lang.int","[I"});
 //BA.debugLineNum = 227;BA.debugLine="r.target = yuvImage";
_r.Target = _yuvimage;
 //BA.debugLineNum = 228;BA.debugLine="Dim rect1 As Rect";
_rect1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
 //BA.debugLineNum = 229;BA.debugLine="rect1.Initialize(0, 0, r.RunMethod(\"getWidth\"), r";
_rect1.Initialize((int) (0),(int) (0),(int)(BA.ObjectToNumber(_r.RunMethod("getWidth"))),(int)(BA.ObjectToNumber(_r.RunMethod("getHeight"))));
 //BA.debugLineNum = 230;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
 //BA.debugLineNum = 231;BA.debugLine="out.InitializeToBytesArray(100)";
_out.InitializeToBytesArray((int) (100));
 //BA.debugLineNum = 232;BA.debugLine="r.RunMethod4(\"compressToJpeg\", Array As Object(re";
_r.RunMethod4("compressToJpeg",new Object[]{(Object)(_rect1.getObject()),(Object)(_quality),(Object)(_out.getObject())},new String[]{"android.graphics.Rect","java.lang.int","java.io.OutputStream"});
 //BA.debugLineNum = 234;BA.debugLine="Return out.ToBytesArray";
if (true) return _out.ToBytesArray();
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return null;
}
public String  _release() throws Exception{
 //BA.debugLineNum = 116;BA.debugLine="Public Sub Release";
 //BA.debugLineNum = 117;BA.debugLine="cam.Release";
_cam.Release();
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return "";
}
public String  _savepicturetofile(byte[] _data,String _dir,String _filename) throws Exception{
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 121;BA.debugLine="Public Sub SavePictureToFile(Data() As Byte, Dir A";
 //BA.debugLineNum = 122;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Dir, Fi";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = __c.File.OpenOutput(_dir,_filename,__c.False);
 //BA.debugLineNum = 123;BA.debugLine="out.WriteBytes(Data, 0, Data.Length)";
_out.WriteBytes(_data,(int) (0),_data.length);
 //BA.debugLineNum = 124;BA.debugLine="out.Close";
_out.Close();
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public String  _setcoloreffect(String _effect) throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Public Sub SetColorEffect(Effect As String)";
 //BA.debugLineNum = 152;BA.debugLine="SetParameter(\"effect\", Effect)";
_setparameter("effect",_effect);
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return "";
}
public String  _setcontinuousautofocus() throws Exception{
anywheresoftware.b4a.objects.collections.List _modes = null;
 //BA.debugLineNum = 242;BA.debugLine="Public Sub SetContinuousAutoFocus";
 //BA.debugLineNum = 243;BA.debugLine="Dim modes As List = GetSupportedFocusModes";
_modes = new anywheresoftware.b4a.objects.collections.List();
_modes = _getsupportedfocusmodes();
 //BA.debugLineNum = 244;BA.debugLine="If modes.IndexOf(\"continuous-picture\") > -1 Th";
if (_modes.IndexOf((Object)("continuous-picture"))>-1) { 
 //BA.debugLineNum = 245;BA.debugLine="SetFocusMode(\"continuous-picture\")";
_setfocusmode("continuous-picture");
 }else if(_modes.IndexOf((Object)("continuous-video"))>-1) { 
 //BA.debugLineNum = 247;BA.debugLine="SetFocusMode(\"continuous-video\")";
_setfocusmode("continuous-video");
 }else {
 //BA.debugLineNum = 249;BA.debugLine="Log(\"Continuous focus mode is not availabl";
__c.Log("Continuous focus mode is not available");
 };
 //BA.debugLineNum = 251;BA.debugLine="End Sub";
return "";
}
public String  _setdisplayorientation() throws Exception{
int _previewresult = 0;
int _result = 0;
int _degrees = 0;
com.zxdemo.cameraexclass._camerainfoandid _ci = null;
int _orientation = 0;
 //BA.debugLineNum = 57;BA.debugLine="Private Sub SetDisplayOrientation";
 //BA.debugLineNum = 58;BA.debugLine="r.target = r.GetActivity";
_r.Target = (Object)(_r.GetActivity(ba));
 //BA.debugLineNum = 59;BA.debugLine="r.target = r.RunMethod(\"getWindowManager\")";
_r.Target = _r.RunMethod("getWindowManager");
 //BA.debugLineNum = 60;BA.debugLine="r.target = r.RunMethod(\"getDefaultDisplay\")";
_r.Target = _r.RunMethod("getDefaultDisplay");
 //BA.debugLineNum = 61;BA.debugLine="r.target = r.RunMethod(\"getRotation\")";
_r.Target = _r.RunMethod("getRotation");
 //BA.debugLineNum = 62;BA.debugLine="Dim previewResult, result, degrees As Int = r.tar";
_previewresult = 0;
_result = 0;
_degrees = (int) ((double)(BA.ObjectToNumber(_r.Target))*90);
 //BA.debugLineNum = 63;BA.debugLine="Dim ci As CameraInfoAndId = FindCamera(Front)";
_ci = _findcamera(_front);
 //BA.debugLineNum = 64;BA.debugLine="r.target = ci.CameraInfo";
_r.Target = _ci.CameraInfo;
 //BA.debugLineNum = 65;BA.debugLine="Dim orientation As Int = r.GetField(\"orientation\"";
_orientation = (int)(BA.ObjectToNumber(_r.GetField("orientation")));
 //BA.debugLineNum = 66;BA.debugLine="If Front Then";
if (_front) { 
 //BA.debugLineNum = 67;BA.debugLine="previewResult = (orientation + degrees) Mod 360";
_previewresult = (int) ((_orientation+_degrees)%360);
 //BA.debugLineNum = 68;BA.debugLine="result = previewResult";
_result = _previewresult;
 //BA.debugLineNum = 69;BA.debugLine="previewResult = (360 - previewResult) Mod 360";
_previewresult = (int) ((360-_previewresult)%360);
 }else {
 //BA.debugLineNum = 71;BA.debugLine="previewResult = (orientation - degrees + 360) Mo";
_previewresult = (int) ((_orientation-_degrees+360)%360);
 //BA.debugLineNum = 72;BA.debugLine="result = previewResult";
_result = _previewresult;
 //BA.debugLineNum = 73;BA.debugLine="Log(previewResult)";
__c.Log(BA.NumberToString(_previewresult));
 };
 //BA.debugLineNum = 75;BA.debugLine="r.target = nativeCam";
_r.Target = _nativecam;
 //BA.debugLineNum = 76;BA.debugLine="r.RunMethod2(\"setDisplayOrientation\", previewResu";
_r.RunMethod2("setDisplayOrientation",BA.NumberToString(_previewresult),"java.lang.int");
 //BA.debugLineNum = 77;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 78;BA.debugLine="r.RunMethod2(\"setRotation\", result, \"java.lang.in";
_r.RunMethod2("setRotation",BA.NumberToString(_result),"java.lang.int");
 //BA.debugLineNum = 79;BA.debugLine="CommitParameters";
_commitparameters();
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public String  _setflashmode(String _mode) throws Exception{
 //BA.debugLineNum = 177;BA.debugLine="Public Sub SetFlashMode(Mode As String)";
 //BA.debugLineNum = 178;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 179;BA.debugLine="r.RunMethod2(\"setFlashMode\", Mode, \"java.lang.Str";
_r.RunMethod2("setFlashMode",_mode,"java.lang.String");
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return "";
}
public String  _setfocusmode(String _mode) throws Exception{
 //BA.debugLineNum = 253;BA.debugLine="Public Sub SetFocusMode(Mode As String)";
 //BA.debugLineNum = 254;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 255;BA.debugLine="r.RunMethod2(\"setFocusMode\", Mode, \"java.lang.";
_r.RunMethod2("setFocusMode",_mode,"java.lang.String");
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
return "";
}
public String  _setjpegquality(int _quality) throws Exception{
 //BA.debugLineNum = 172;BA.debugLine="Public Sub SetJpegQuality(Quality As Int)";
 //BA.debugLineNum = 173;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 174;BA.debugLine="r.RunMethod2(\"setJpegQuality\", Quality, \"java.lan";
_r.RunMethod2("setJpegQuality",BA.NumberToString(_quality),"java.lang.int");
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public String  _setparameter(String _key,String _value) throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Public Sub SetParameter(Key As String, Value As St";
 //BA.debugLineNum = 128;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 129;BA.debugLine="r.RunMethod3(\"set\", Key, \"java.lang.String\", Valu";
_r.RunMethod3("set",_key,"java.lang.String",_value,"java.lang.String");
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public String  _setpicturesize(int _width,int _height) throws Exception{
 //BA.debugLineNum = 167;BA.debugLine="Public Sub SetPictureSize(Width As Int, Height As";
 //BA.debugLineNum = 168;BA.debugLine="r.target = parameters";
_r.Target = _parameters;
 //BA.debugLineNum = 169;BA.debugLine="r.RunMethod3(\"setPictureSize\", Width, \"java.lang.";
_r.RunMethod3("setPictureSize",BA.NumberToString(_width),"java.lang.int",BA.NumberToString(_height),"java.lang.int");
 //BA.debugLineNum = 170;BA.debugLine="End Sub";
return "";
}
public String  _startpreview() throws Exception{
 //BA.debugLineNum = 108;BA.debugLine="Public Sub StartPreview";
 //BA.debugLineNum = 109;BA.debugLine="cam.StartPreview";
_cam.StartPreview();
 //BA.debugLineNum = 110;BA.debugLine="End Sub";
return "";
}
public String  _stoppreview() throws Exception{
 //BA.debugLineNum = 112;BA.debugLine="Public Sub StopPreview";
 //BA.debugLineNum = 113;BA.debugLine="cam.StopPreview";
_cam.StopPreview();
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public String  _takepicture() throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="Public Sub TakePicture";
 //BA.debugLineNum = 101;BA.debugLine="cam.TakePicture";
_cam.TakePicture();
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
