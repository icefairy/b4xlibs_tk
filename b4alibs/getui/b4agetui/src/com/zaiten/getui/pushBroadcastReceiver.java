package com.zaiten.getui;

import com.igexin.sdk.PushConsts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import anywheresoftware.b4a.BA;

public class pushBroadcastReceiver extends BroadcastReceiver{

	public static StringBuilder payloadData = new StringBuilder();
	@Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        BA.Log("onReceive() action=" + bundle.getInt("action"));
        switch (bundle.getInt(PushConsts.CMD_ACTION)) {
	        case PushConsts.GET_CLIENTID:
	        	// 获取ClientID(CID)
	            // 第三方应用需要将CID上传到第三方服务器，并且将当前用户帐号和CID进行关联，以便日后通过用户帐号查找CID进行消息推送
	            String cid = bundle.getString("clientid");
	            //BA.Log( "receiver clientid : " + cid);
	            // TODO:处理cid返回
	            getuiwrapper.mBa.raiseEventFromDifferentThread(this, null, 0, getuiwrapper.EN+"_onclickid", false, new Object[]{cid});
	            break;
	        case PushConsts.GET_MSG_DATA:
	        	// 获取透传数据
	            // String appid = bundle.getString("appid");
	        	
//	        	BA.Log( "-----------"+bundle.toString());
	            String taskid = bundle.getString("taskid");
	            String messageid = bundle.getString("messageid");
	            
	            byte[] payload = bundle.getByteArray("payload");
	        	// 处理事件smartPush第三方回执调用接口，actionid范围为90000-90999，可根据业务场景执行
                //发送自定义回执
	            //boolean result = PushManager.getInstance().sendFeedbackMessage(context, taskid, messageid, 90001);
//                System.out.println("第三方回执接口调用" + (result ? "成功" : "失败"));
	            if (payload != null) {
	                String data = new String(payload);
//	                data = data.substring(0, data.length()-1)+",\"taskid\":"+"\""+taskid+"\",\"messageid\":"+"\""+messageid+"\"}";
//	                getuiwrapper.mBa.raiseEventFromDifferentThread(this, null, 0, getuiwrapper.EN+"_onrec", true, new Object[]{data});

	                getuiwrapper.mBa.raiseEventFromDifferentThread(this, null, 0, getuiwrapper.EN+"_onrec", true, new Object[]{data,messageid,taskid});
	                
	            }
	            break;
	        case PushConsts.THIRDPART_FEEDBACK:
                /*
                 * String appid = bundle.getString("appid"); String taskid =
                 * bundle.getString("taskid"); String actionid = bundle.getString("actionid");
                 * String result = bundle.getString("result"); long timestamp =
                 * bundle.getLong("timestamp");
                 * 
                 * Log.d("GetuiSdkDemo", "appid = " + appid); Log.d("GetuiSdkDemo", "taskid = " +
                 * taskid); Log.d("GetuiSdkDemo", "actionid = " + actionid); Log.d("GetuiSdkDemo",
                 * "result = " + result); Log.d("GetuiSdkDemo", "timestamp = " + timestamp);
                 */
                break;
	        default:
	            break;
        }
    }

}

