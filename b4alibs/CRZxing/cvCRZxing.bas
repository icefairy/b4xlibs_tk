Type=Class
Version=6
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@

#Event: onCamError (errMsg as String)
#Event: onZxDecResult (result as String)
Sub Class_Globals
	'dependson lastest release zxing 3.2.1,you need to down load it from:http://repo1.maven.org/maven2/com/google/zxing/
	Private EventName As String 'ignore
	Private CallBack As Object 'ignore
	Private jo As JavaObject
	Private mBase As Panel
	Private camex As CameraExClass
	Private bCamReady=False,bProcessing As Boolean
	Private mp As MediaPlayer
	Public nScanInterval As Int=1000'ms
	Public tmr As Timer,bScanOnce=True As Boolean
	Private bmpToDecode As Bitmap
	Public beepfilename As String="scannerbeep.wav"
End Sub

Public Sub Initialize (vCallback As Object, vEventName As String)
	EventName = vEventName
	CallBack = vCallback
	jo=Me
	mp.Initialize
	mp.Load(File.DirAssets,beepfilename)

End Sub
Sub cam_Ready (Success As Boolean)
	bCamReady=Success
	If Success=False Then
		CallSub2(CallBack,EventName&"_onCamError",LastException.Message)
	Else
		camex.StartPreview
		tmr.Initialize("tmr",nScanInterval)
		tmr.Enabled=True
	End If
End Sub
'扫描定时器
Sub tmr_Tick
	If bCamReady And Not(bProcessing) Then
		bProcessing=True
		camex.FocusAndTakePicture
	End If
End Sub

Sub cam_PictureTaken (Data() As Byte)
	Dim inp As InputStream
	inp.InitializeFromBytesArray(Data,0,Data.Length)
	bmpToDecode=Null
	bmpToDecode.Initialize2(inp)
	Dim str As String
	
	str=decodeBitmap(bmpToDecode)
	If str<>Null And str<>"null" And str.Length>0 Then
		CallSubDelayed2(CallBack,EventName&"_onZxDecResult",str)
		mp.Play
		If bScanOnce=False Then
			bProcessing=False
			stopPreView
		End If
	Else
		bProcessing=False
	End If
End Sub
Public Sub DesignerCreateView (Base As Panel, Lbl As Label, Props As Map)
	mBase = Base
    camex.Initialize(mBase,False,Me,"cam")
End Sub
Public Sub startPreView
	If bCamReady Then camex.StartPreview
End Sub
'same as release
Public Sub CloseNow
	If bCamReady Then camex.CloseNow
End Sub
Public Sub stopPreView
	If bCamReady Then camex.StopPreview
End Sub
Public Sub GetBase As Panel
	Return mBase
End Sub
Public Sub decodeBitmap(bmp As Bitmap) As String
	Return jo.RunMethod("decodeBitmap2",Array As Object(bmp))
End Sub
#If java
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
#end if