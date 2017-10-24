package com.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import cn.jpush.android.api.JPushInterface;

@BA.Hide
public class MyReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context context, Intent intent)
  {
    Bundle bundle = intent.getExtras();
    if ("cn.jpush.android.intent.REGISTRATION".equals(intent.getAction()))
    {
      b4ajpush.myba.raiseEvent(this, b4ajpush.EN + "_initok", new Object[] { bundle.getString("cn.jpush.android.REGISTRATION_ID") });
    }
    else if ("cn.jpush.android.intent.MESSAGE_RECEIVED".equals(intent.getAction()))
    {
      b4ajpush.myba.raiseEvent(this, b4ajpush.EN + "_msg", new Object[] { bundle.getString("cn.jpush.android.TITLE"), bundle.getString("cn.jpush.android.MESSAGE") });
    }
    else if ("cn.jpush.android.intent.NOTIFICATION_RECEIVED".equals(intent.getAction()))
    {
      b4ajpush.myba.raiseEvent(this, b4ajpush.EN + "_notify", new Object[] { bundle.getString("cn.jpush.android.NOTIFICATION_CONTENT_TITLE"), bundle.getString("cn.jpush.android.ALERT") });
    }
    else if ("cn.jpush.android.intent.NOTIFICATION_OPENED".equals(intent.getAction()))
    {
      b4ajpush.myba.raiseEvent(this, b4ajpush.EN + "_onclick", new Object[0]);
    }
    else if ("cn.jpush.android.intent.CONNECTION".equals(intent.getAction()))
    {
      boolean connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
      b4ajpush.myba.raiseEvent(this, b4ajpush.EN + "_connect", new Object[] { Boolean.valueOf(connected) });
    }
    else
    {
      Log.d("B4A", "Unhandled intent - " + intent.getAction());
    }
    BA.Log(printBundle(intent.getExtras()));
  }
  
  private static String printBundle(Bundle bundle)
  {
    StringBuilder sb = new StringBuilder();
    for (String key : bundle.keySet()) {
      if (key.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
        sb.append("\nkey:" + key + ", value:" + bundle.getInt(key));
      } else if (key.equals(JPushInterface.EXTRA_CONNECTION_CHANGE)) {
        sb.append("\nkey:" + key + ", value:" + bundle.getBoolean(key));
      } else {
        sb.append("\nkey:" + key + ", value:" + bundle.getString(key));
      }
    }
    return sb.toString();
  }
}
