package org.xlzbw.xunfei;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@ShortName("xunfei")
@Version(1.00f)
@Author("icefairy333")
@Permissions(values={"android.permission.INTERNET","android.permission.RECORD_AUDIO","android.permission.ACCESS_NETWORK_STATE","android.permission.ACCESS_WIFI_STATE","android.permission.CHANGE_NETWORK_STATE","android.permission.READ_PHONE_STATE","android.permission.READ_CONTACTS","android.permission.WRITE_EXTERNAL_STORAGE","android.permission.READ_EXTERNAL_STORAGE","android.permission.WRITE_SETTINGS","android.permission.ACCESS_FINE_LOCATION","android.permission.CAMERA" })
@DependsOn(values={"Msc","Sunflower"})
@ActivityObject
@Events(values={"xfiniterror(errCode as int)","onxfResult(resultStr as String)","onxfError(errcode as int,errDesc as String)"})
public class xunfeiwrapper {
	private BA mba;
	private String en;
	private InitListener mInitListener;
	private RecognizerDialogListener mRecognizerDialogListener;
	
	public void init(BA ba,String eventname,String appid) {
		SpeechUtility.createUtility(ba.context, SpeechConstant.APPID +"="+appid);
		en=eventname.toLowerCase();
		mba=ba;	
	}
	public void start(BA ba) {
		mInitListener=new InitListener() {
			
			@Override
			public void onInit(int arg0) {
				// TODO Auto-generated method stub
				if (arg0 != ErrorCode.SUCCESS) {
					mba.raiseEvent(this, en+"_xfiniterror", new Object[]{arg0});
				}
			}
		};
		mRecognizerDialogListener=new RecognizerDialogListener() {
			
			@Override
			public void onResult(RecognizerResult result, boolean isLast) {
				// TODO Auto-generated method stub
				mba.raiseEvent(this, en+"_onxfresult", new Object[]{result.getResultString()});
			}
			
			@Override
			public void onError(SpeechError err) {
				// TODO Auto-generated method stub
				mba.raiseEvent(this, en+"_onxferror", new Object[]{err.getErrorCode(),err.getErrorDescription()});
			}
		};
		RecognizerDialog mDialog = new RecognizerDialog(mba.activity, mInitListener);
		mDialog.setListener( mRecognizerDialogListener );
		mDialog.show();
	}
}
