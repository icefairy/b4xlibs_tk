package com.zaiten.getui;

import com.igexin.sdk.PushManager;
import com.igexin.sdk.Tag;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@ShortName("b4agetui")
@Version(2.0F)
@Author("luweichen+Icefairy333")
@DependsOn(values={"GetuiSDK2.7.0.0","json_simple-1.1","GetuiExt-2.0.3","android-support-v4"})
@Events(values={"onRec(str as String,messageid as String,taskid as String)","onClickid(str as String)"})
@Permissions(values={"android.permission.INTERNET","android.permission.READ_PHONE_STATE","android.permission.ACCESS_NETWORK_STATE","android.permission.CHANGE_WIFI_STATE","android.permission.ACCESS_WIFI_STATE","android.permission.WAKE_LOCK","android.permission.RECEIVE_BOOT_COMPLETED","android.permission.WRITE_EXTERNAL_STORAGE","android.permission.VIBRATE","android.permission.GET_TASKS","android.permission.SYSTEM_ALERT_WINDOW"})
public class getuiwrapper {
	@Hide
	public static BA mBa;
	@Hide
	public static String EN;
	public void Init(BA ba, String EventName)
	{
	    EN = EventName.toLowerCase(BA.cul);
	    mBa = ba;	
	    PushManager.getInstance().initialize(BA.applicationContext);
	  }
	  
	  public void OnStart()
	  {
	    BA.Log("启动个推推送");
	    PushManager.getInstance().turnOnPush(BA.applicationContext);
	  }
	  
	  public void OnStop()
	  {
	    BA.Log("停止个推推送");
	    PushManager.getInstance().turnOffPush(BA.applicationContext);
	  }
	  
	  public void OnStopService()
	  {
	    BA.Log("停止个推服务");
	    PushManager.getInstance().stopService(BA.applicationContext);
	  }
	  
	  public boolean setSilentTime(int beginHour, int duration)
	  {
	    BA.Log("设置静默时间");
	    boolean result = PushManager.getInstance().setSilentTime(BA.applicationContext, beginHour, duration);
	    return result;
	  }
	  
	  public boolean isPushTurnedOn()
	  {
	    BA.Log("获取服务状态");
	    return PushManager.getInstance().isPushTurnedOn(BA.applicationContext);
	  }
	  
	  public String getVersion()
	  {
	    BA.Log("获取SDK版本号");
	    return PushManager.getInstance().getVersion(BA.applicationContext);
	  }
	  
	  public String getClientid()
	  {
	    BA.Log("获取Clientid");
	    return PushManager.getInstance().getClientid(BA.applicationContext);
	  }
	  
	  public boolean sendFeedbackMessage(String taskid, String messageid, int actionid)
	  {
	    boolean result = PushManager.getInstance().sendFeedbackMessage(BA.applicationContext, taskid, messageid, actionid);
	    BA.Log("回执:" + result);
	    return result;
	  }
	  
	  public boolean bindAlias(String alias)
	  {
	    if ((alias != null) && (alias.length() > 0))
	    {
	      boolean result = PushManager.getInstance().bindAlias(BA.applicationContext, alias);
	      BA.Log("别名:" + result);
	      return result;
	    }
	    return false;
	  }
	  
	  public boolean unBindAlias(String alias)
	  {
	    if ((alias != null) && (alias.length() > 0))
	    {
	      boolean result = PushManager.getInstance().unBindAlias(BA.applicationContext, alias, true);
	      BA.Log("解绑别名:" + result);
	      return result;
	    }
	    return false;
	  }
	  
	  public int setTag(String tagst)
	  {
	    if (tagst != null)
	    {
	      String[] tags = tagst.split(",");
	      Tag[] tagParam = new Tag[tags.length];
	      for (int i = 0; i < tags.length; i++)
	      {
	        Tag t = new Tag();
	        t.setName(tags[i]);
	        tagParam[i] = t;
	      }
	      int i = PushManager.getInstance().setTag(BA.applicationContext, tagParam);
	      BA.Log("设置标签:" + i);
	      return i;
	    }
	    return 20006;
	  }
	}