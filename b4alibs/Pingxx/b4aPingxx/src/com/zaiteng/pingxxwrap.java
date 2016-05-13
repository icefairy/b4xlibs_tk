package com.zaiteng;

import org.json.JSONException;
import org.json.JSONObject;

import com.pingplusplus.android.PaymentActivity;
import com.pingplusplus.android.PingppLog;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.IOnActivityResult;

@Permissions(values={"android.permission.INTERNET" ,"android.permission.ACCESS_NETWORK_STATE" ,"android.permission.ACCESS_WIFI_STATE" ,"android.permission.READ_PHONE_STATE" ,"android.permission.WRITE_EXTERNAL_STORAGE"})
@Version(1.00f)
@Author("Icefairy333")
@ShortName("Pingxx")
@ActivityObject
@DependsOn(values={"libpingpp-2.1.2","libpingppone-2.1.1","alipaySingle-20160111","libammsdk"})
@Events(values={"paymentresult(result as string,extramsg as string,errmsg as string)"})
public class pingxxwrap {
	private BA mba;
	private String en;
	private IOnActivityResult orl;
	public void init(BA ba,String EventName,boolean debuglog) {
		mba=ba;
		en=EventName.toLowerCase();
		PingppLog.DEBUG=debuglog;
		orl=new IOnActivityResult() {
			
			@Override
			public void ResultArrived(int resultCode, Intent data) {
				// TODO Auto-generated method stub
		        if (resultCode == Activity.RESULT_OK) {
		            String result = data.getExtras().getString("pay_result");
		            /* 处理返回值
		             * "success" - 支付成功
		             * "fail"    - 支付失败
		             * "cancel"  - 取消支付
		             * "invalid" - 支付插件未安装（一般是微信客户端未安装的情况）
		             */
		            
		        	String errorMsg = data.getExtras().getString("error_msg"); // 错误信息
		            String extraMsg = data.getExtras().getString("extra_msg"); // 额外信息
		            mba.raiseEventFromDifferentThread(this, null, 0, en+"_paymentresult", true, new Object[]{result,extraMsg,errorMsg});
		        }
			}
		};
	}
	/**
	 * give me a string(canbe parse to an jsonobject)
	 */
	public void createPayment(String data)
	  {
	    try
	    {
	      JSONObject localJSONObject = new JSONObject(data);
	      String str1 = localJSONObject.optString("channel");
	      if ("wx".equals(str1))
	      {
	        String str2 = BA.packageName;
	        Intent localIntent2 = new Intent();
	        ComponentName localComponentName = new ComponentName(str2, str2 + ".wxapi.WXPayEntryActivity");
	        localIntent2.setComponent(localComponentName);
	        localIntent2.putExtra("com.pingplusplus.android.PaymentActivity.CHARGE", data);
	        mba.startActivityForResult(orl, localIntent2);
	        //paramActivity.startActivityForResult(localIntent2, REQUEST_CODE_PAYMENT);
	        return;
	      }
	    }
	    catch (JSONException localJSONException)
	    {
	      localJSONException.printStackTrace();
	    }
	    Intent localIntent1 = new Intent(BA.applicationContext, PaymentActivity.class);
	    localIntent1.putExtra("com.pingplusplus.android.PaymentActivity.CHARGE", data);
	    if (orl==null) {
			BA.Log("orl=null");
		}
	    if (localIntent1==null) {
			BA.Log("localintent=null");
		}
	    mba.startActivityForResult(orl, localIntent1);
	  }
	  
}
