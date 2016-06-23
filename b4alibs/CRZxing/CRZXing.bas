Type=Class
Version=6
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'dependson lastest release zxing 3.2.1,you need to down load it from:http://repo1.maven.org/maven2/com/google/zxing/
Sub Class_Globals
	Private jo As JavaObject
End Sub
'下面这两句放到main里面
'#AdditionalJar:zxcore-3.2.1.jar
'#AdditionalJar:zxjavase-3.2.1.jar
'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	jo=Me
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