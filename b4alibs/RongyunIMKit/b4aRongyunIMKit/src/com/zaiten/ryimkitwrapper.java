package com.zaiten;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import io.rong.imkit.RongIM;
import io.rong.imkit.RongIM.UserInfoProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.RongIMClient.ConnectCallback;
import io.rong.imlib.RongIMClient.ErrorCode;
import io.rong.imlib.model.Message;
import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import io.rong.message.ImageMessage;
import io.rong.message.RichContentMessage;
import io.rong.message.TextMessage;
import io.rong.message.VoiceMessage;

@ShortName("RongYunIMKit")
@DependsOn(values={"Rong_IMKit","android-support-v4"})
@Events(values={"onIMReceived(msg as String,nLeft as Int)","onSuccess(arg as String)","onError(code as int,msg as String)","onTokenIncorrect","reqUserInfo(userId as String) as UserInfo_ry"})
@Version(1.20f)
@Author("Icefairy333")
@Permissions(values={"android.permission.WRITE_EXTERNAL_STORAGE","android.permission.INTERNET","android.permission.ACCESS_COARSE_LOCATION","android.permission.READ_PHONE_STATE","android.permission.GET_TASKS","android.permission.INTERACT_ACROSS_USERS_FULL","android.permission.ACCESS_WIFI_STATE","android.permission.ACCESS_NETWORK_STATE","android.permission.CAMERA","android.permission.RECORD_AUDIO","android.permission.VIBRATE","android.permission.WAKE_LOCK","android.permission.WRITE_SETTINGS","android.permission.MODIFY_AUDIO_SETTINGS","android.permission.RECEIVE_BOOT_COMPLETED"})
public class ryimkitwrapper {
	private String en;
	private BA mba;
	public void init(BA ba,String EventStr) {
		en=EventStr.toLowerCase();
		mba=ba;

		BA.Log("RongIM Init");
		RongIM.init(BA.applicationContext);
		RongIM.setUserInfoProvider(new UserInfoProvider() {
			
			@Override
			public UserInfo getUserInfo(String userId) {
				// TODO Auto-generated method stub
				Method met= mba.htSubs.get(en+"_requserinfo");
				try {
					UserInfoWrapper uiInfo=(UserInfoWrapper) met.invoke(mba.getClass(), new Object[]{userId});
					if (uiInfo!=null) {
						return uiInfo.getObject();
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				UserInfoWrapper uiInfo= (UserInfoWrapper) mba.raiseEventFromDifferentThread(this, null, 0, en+"_requserinfo", true, new Object[]{userId});

				return null;
			}
		}, false);
//		RongIM.getInstance().setMessageAttachedUserInfo(true);
	}
	private static class myRec implements RongIMClient.OnReceiveMessageListener{
		BA ba1;
		String Eventname;
		public myRec(BA ba,String en) {
			super();
			ba1=ba;
			Eventname=en.toLowerCase();
			// TODO Auto-generated constructor stub
		}
		@Override
		public boolean onReceived(Message paramMessage, int paramInt) {
			// TODO Auto-generated method stub
			MessageContent mc= paramMessage.getContent();
			String msg="";
			if (mc instanceof TextMessage) {
				msg=((TextMessage)mc).getContent();
			}else if (mc instanceof ImageMessage) {
				msg="[图片]";
			}else if (mc instanceof VoiceMessage){
				msg="[语音]";
			}else if (mc instanceof RichContentMessage) {
				msg="[图文]";
			}else{
				msg="[其他]";
			}
			ba1.raiseEventFromDifferentThread(this, this, 0, Eventname+"_onIMReceived".toLowerCase(), false, new Object[]{
					msg,paramInt
			});
			return false;
		}

				
	}
	public void Connect(String token) {
		RongIM.setOnReceiveMessageListener(new myRec(mba,en));
		RongIM.connect(token, new ConnectCallback() {
			
			@Override
			public void onSuccess(String arg0) {
				// TODO Auto-generated method stub
				mba.LogInfo("success:"+arg0);
				if (!mba.subExists(en+"_onsuccess")) {
					BA.LogError("onSuccess sub not exist");
				}
				mba.raiseEvent(this, en+"_onsuccess", new Object[]{arg0});
			}
			
			@Override
			public void onError(ErrorCode arg0) {
				// TODO Auto-generated method stub
				mba.LogInfo("onError:"+arg0.getMessage());
				if (!mba.subExists(en+"_onerror")) {
					BA.LogError("onError sub not exist");
				}
				mba.raiseEvent(this, en+"_onerror", new Object[]{arg0.ordinal(),arg0.getMessage()});
			}
			
			@Override
			public void onTokenIncorrect() {
				// TODO Auto-generated method stub
				mba.LogInfo("onTokenIncorrect");
				mba.raiseEvent(this, en+"_ontokenincorrect", new Object[]{});
			}
		});
	}
	
	public void logout() {
		if(RongIM.getInstance()!=null){RongIM.getInstance().logout();}
	}
	public void disconnect() {
		if (RongIM.getInstance()!=null) {
			RongIM.getInstance().disconnect();
		}
	}

}
