package com.zxdemo;

import java.io.File;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import android.graphics.Bitmap;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class cvcrzxing extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.zxdemo.cvcrzxing");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.zxdemo.cvcrzxing.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _eventname = "";
public Object _callback = null;
public anywheresoftware.b4j.object.JavaObject _jo = null;
public anywheresoftware.b4a.objects.PanelWrapper _mbase = null;
public com.zxdemo.cameraexclass _camex = null;
public boolean _bcamready = false;
public boolean _bprocessing = false;
public anywheresoftware.b4a.objects.MediaPlayerWrapper _mp = null;
public int _nscaninterval = 0;
public anywheresoftware.b4a.objects.Timer _tmr = null;
public boolean _bscanonce = false;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmptodecode = null;
public String _beepfilename = "";
public com.zxdemo.main _main = null;
public com.zxdemo.actzxscanner _actzxscanner = null;
public String  _cam_picturetaken(byte[] _data) throws Exception{
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _inp = null;
String _str = "";
 //BA.debugLineNum = 45;BA.debugLine="Sub cam_PictureTaken (Data() As Byte)";
 //BA.debugLineNum = 46;BA.debugLine="Dim inp As InputStream";
_inp = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 47;BA.debugLine="inp.InitializeFromBytesArray(Data,0,Data.Length)";
_inp.InitializeFromBytesArray(_data,(int) (0),_data.length);
 //BA.debugLineNum = 48;BA.debugLine="bmpToDecode=Null";
_bmptodecode.setObject((android.graphics.Bitmap)(__c.Null));
 //BA.debugLineNum = 49;BA.debugLine="bmpToDecode.Initialize2(inp)";
_bmptodecode.Initialize2((java.io.InputStream)(_inp.getObject()));
 //BA.debugLineNum = 50;BA.debugLine="Dim str As String";
_str = "";
 //BA.debugLineNum = 52;BA.debugLine="str=decodeBitmap(bmpToDecode)";
_str = _decodebitmap(_bmptodecode);
 //BA.debugLineNum = 53;BA.debugLine="If str<>Null And str<>\"null\" And str.Length>0 The";
if (_str!= null && (_str).equals("null") == false && _str.length()>0) { 
 //BA.debugLineNum = 54;BA.debugLine="CallSubDelayed2(CallBack,EventName&\"_onZxDecResu";
__c.CallSubDelayed2(ba,_callback,_eventname+"_onZxDecResult",(Object)(_str));
 //BA.debugLineNum = 55;BA.debugLine="mp.Play";
_mp.Play();
 //BA.debugLineNum = 56;BA.debugLine="If bScanOnce=False Then";
if (_bscanonce==__c.False) { 
 //BA.debugLineNum = 57;BA.debugLine="bProcessing=False";
_bprocessing = __c.False;
 //BA.debugLineNum = 58;BA.debugLine="stopPreView";
_stoppreview();
 };
 }else {
 //BA.debugLineNum = 61;BA.debugLine="bProcessing=False";
_bprocessing = __c.False;
 };
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public String  _cam_ready(boolean _success) throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub cam_Ready (Success As Boolean)";
 //BA.debugLineNum = 28;BA.debugLine="bCamReady=Success";
_bcamready = _success;
 //BA.debugLineNum = 29;BA.debugLine="If Success=False Then";
if (_success==__c.False) { 
 //BA.debugLineNum = 30;BA.debugLine="CallSub2(CallBack,EventName&\"_onCamError\",LastEx";
__c.CallSubNew2(ba,_callback,_eventname+"_onCamError",(Object)(__c.LastException(ba).getMessage()));
 }else {
 //BA.debugLineNum = 32;BA.debugLine="camex.StartPreview";
_camex._startpreview();
 //BA.debugLineNum = 33;BA.debugLine="tmr.Initialize(\"tmr\",nScanInterval)";
_tmr.Initialize(ba,"tmr",(long) (_nscaninterval));
 //BA.debugLineNum = 34;BA.debugLine="tmr.Enabled=True";
_tmr.setEnabled(__c.True);
 };
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Private EventName As String 'ignore";
_eventname = "";
 //BA.debugLineNum = 7;BA.debugLine="Private CallBack As Object 'ignore";
_callback = new Object();
 //BA.debugLineNum = 8;BA.debugLine="Private jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 9;BA.debugLine="Private mBase As Panel";
_mbase = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private camex As CameraExClass";
_camex = new com.zxdemo.cameraexclass();
 //BA.debugLineNum = 11;BA.debugLine="Private bCamReady=False,bProcessing As Boolean";
_bcamready = __c.False;
_bprocessing = false;
 //BA.debugLineNum = 12;BA.debugLine="Private mp As MediaPlayer";
_mp = new anywheresoftware.b4a.objects.MediaPlayerWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Public nScanInterval As Int=1000'ms";
_nscaninterval = (int) (1000);
 //BA.debugLineNum = 14;BA.debugLine="Public tmr As Timer,bScanOnce=True As Boolean";
_tmr = new anywheresoftware.b4a.objects.Timer();
_bscanonce = __c.True;
 //BA.debugLineNum = 15;BA.debugLine="Private bmpToDecode As Bitmap";
_bmptodecode = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Public beepfilename As String=\"scannerbeep.wav\"";
_beepfilename = "scannerbeep.wav";
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _closenow() throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Public Sub CloseNow";
 //BA.debugLineNum = 73;BA.debugLine="If bCamReady Then camex.CloseNow";
if (_bcamready) { 
_camex._closenow();};
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return "";
}
public String  _decodebitmap(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp) throws Exception{
 //BA.debugLineNum = 81;BA.debugLine="Public Sub decodeBitmap(bmp As Bitmap) As String";
 //BA.debugLineNum = 82;BA.debugLine="Return jo.RunMethod(\"decodeBitmap2\",Array As Obje";
if (true) return BA.ObjectToString(_jo.RunMethod("decodeBitmap2",new Object[]{(Object)(_bmp.getObject())}));
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(anywheresoftware.b4a.objects.PanelWrapper _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Public Sub DesignerCreateView (Base As Panel, Lbl";
 //BA.debugLineNum = 65;BA.debugLine="mBase = Base";
_mbase = _base;
 //BA.debugLineNum = 66;BA.debugLine="camex.Initialize(mBase,False,Me,\"cam\")";
_camex._initialize(ba,_mbase,__c.False,this,"cam");
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.PanelWrapper  _getbase() throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Public Sub GetBase As Panel";
 //BA.debugLineNum = 79;BA.debugLine="Return mBase";
if (true) return _mbase;
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _vcallback,String _veventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 19;BA.debugLine="Public Sub Initialize (vCallback As Object, vEvent";
 //BA.debugLineNum = 20;BA.debugLine="EventName = vEventName";
_eventname = _veventname;
 //BA.debugLineNum = 21;BA.debugLine="CallBack = vCallback";
_callback = _vcallback;
 //BA.debugLineNum = 22;BA.debugLine="jo=Me";
_jo.setObject((java.lang.Object)(this));
 //BA.debugLineNum = 23;BA.debugLine="mp.Initialize";
_mp.Initialize();
 //BA.debugLineNum = 24;BA.debugLine="mp.Load(File.DirAssets,beepfilename)";
_mp.Load(__c.File.getDirAssets(),_beepfilename);
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public String  _startpreview() throws Exception{
 //BA.debugLineNum = 68;BA.debugLine="Public Sub startPreView";
 //BA.debugLineNum = 69;BA.debugLine="If bCamReady Then camex.StartPreview";
if (_bcamready) { 
_camex._startpreview();};
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public String  _stoppreview() throws Exception{
 //BA.debugLineNum = 75;BA.debugLine="Public Sub stopPreView";
 //BA.debugLineNum = 76;BA.debugLine="If bCamReady Then camex.StopPreview";
if (_bcamready) { 
_camex._stoppreview();};
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public String  _tmr_tick() throws Exception{
 //BA.debugLineNum = 38;BA.debugLine="Sub tmr_Tick";
 //BA.debugLineNum = 39;BA.debugLine="If bCamReady And Not(bProcessing) Then";
if (_bcamready && __c.Not(_bprocessing)) { 
 //BA.debugLineNum = 40;BA.debugLine="bProcessing=True";
_bprocessing = __c.True;
 //BA.debugLineNum = 41;BA.debugLine="camex.FocusAndTakePicture";
_camex._focusandtakepicture();
 };
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}


	public String decodeBitmap2(Bitmap bMap) {
	    String contents = null;
		byte[] rawBytes=null;
	    int[] intArray = new int[bMap.getWidth() * bMap.getHeight()];
	    
	    //copy pixel data from the Bitmap into the 'intArray' array  
	    bMap.getPixels(intArray, 0, bMap.getWidth(), 0, 0, bMap.getWidth(), bMap.getHeight());  

	    LuminanceSource source = new RGBLuminanceSource(bMap.getWidth(), bMap.getHeight(), intArray);
	    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

	    Reader reader = new MultiFormatReader(); // use this otherwise ChecksumException
	    
	    try {
	        Result result = reader.decode(bitmap);
	        rawBytes = result.getRawBytes(); 
			if(rawBytes==null||rawBytes.length==0){
				contents="";
			}else {
				contents = result.getText(); 	
			}
	        //rawBytes = result.getRawBytes(); 
	        //BarcodeFormat format = result.getBarcodeFormat(); 
	        //ResultPoint[] points = result.getResultPoints();
	        
	    } catch (NotFoundException e) { e.printStackTrace(); } 
	    catch (ChecksumException e) { e.printStackTrace(); }
	    catch (FormatException e) { e.printStackTrace(); }
	    bitmap=null;
		bMap=null;
	    return contents;
	}
}
