package com.jpush;

import java.util.Set;

import android.content.IntentFilter;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

@BA.ShortName("JPush")
@BA.Version(3.09f)
@BA.Author("IceFairy333")
@Events(values= {"msg(title as String,msgbody as String)","notify(title as String,msgbody as String)","initok(RegID as String)","onclick","connect(isconnect as Boolean)"})
@DependsOn(values= {"jcore-android-1.1.7","jpush-android-3.0.9"})
public class b4ajpush
{
  private MyReceiver mMessageReceiver;
  public static final String MESSAGE_RECEIVED_ACTION = BA.applicationContext.getPackageName() + ".MESSAGE_RECEIVED_ACTION";
  public static final String KEY_TITLE = "title";
  public static final String KEY_MESSAGE = "message";
  public static final String KEY_EXTRAS = "extras";
  @BA.Hide
  public static BA myba = null;
  @BA.Hide
  public static String EN = null;
  
  public static void InitSdk(BA ba, String EventName, boolean TestMode)
  {
    myba = ba;
    EN = EventName.toLowerCase();
    BA.Log("Jpush init with applicationcontext");
    JPushInterface.setDebugMode(TestMode);
    JPushInterface.init(BA.applicationContext);
  }
  public static String getDeviceId() {
      return JPushInterface.getUdid(BA.applicationContext);
  }
  public void registerMessageReceiver()
  {
    this.mMessageReceiver = new MyReceiver();
    IntentFilter filter = new IntentFilter();
    filter.addCategory(BA.applicationContext.getPackageName());
    filter.setPriority(1000);
    filter.addAction(MESSAGE_RECEIVED_ACTION);
    filter.addAction("cn.jpush.android.intent.REGISTRATION");
    filter.addAction("cn.jpush.android.intent.UNREGISTRATION");
    filter.addAction("cn.jpush.android.intent.MESSAGE_RECEIVED");
    filter.addAction("cn.jpush.android.intent.NOTIFICATION_RECEIVED");
    filter.addAction("cn.jpush.android.intent.NOTIFICATION_OPENED");
    filter.addAction("cn.jpush.android.intent.ACTION_RICHPUSH_CALLBACK");
    filter.addAction("cn.jpush.android.intent.CONNECTION");
    BA.applicationContext.registerReceiver(this.mMessageReceiver, filter);
  }
  
  public void onResume(BA ba1)
  {
    JPushInterface.onResume(ba1.context);
  }
  
  public void onPause(BA ba1)
  {
    JPushInterface.onPause(ba1.context);
  }
  
  public void setAliasAndTags(String Alias)
  {
    JPushInterface.setAliasAndTags(BA.applicationContext,Alias, null, new TagAliasCallback() {
		
		@Override
		public void gotResult(int arg0, String arg1, Set<String> arg2) {
			// TODO Auto-generated method stub
			
		}
	});
  }
  
  public String getUdid()
  {
    return JPushInterface.getUdid(BA.applicationContext);
  }
  
  public String GetLibVer()
  {
    return "3.0.9";
  }
}
