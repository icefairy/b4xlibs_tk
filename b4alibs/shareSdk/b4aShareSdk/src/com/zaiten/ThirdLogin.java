package com.zaiten;

import java.util.HashMap;
import java.util.Iterator;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.collections.Map.MyMap;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;

@ShortName("ThirdLogin")
@Events(values={"onCancel(action as Int,Platform as Object)","onComplete(action as Int,platform as Object,res as Map)","onError(action as Int,platform as Object,errMsg as String)"})
public class ThirdLogin implements PlatformActionListener {
	private BA mBa;
	private String EN;
	public boolean sso;
	public void init(BA ba,String EventName,String appkey,List parms,boolean ssoEnable) {
		ShareSDK.initSDK(ba.context,appkey,true);
		mBa=ba;
		sso=ssoEnable;
		EN=EventName.toLowerCase();
		if (parms!=null&&parms.getSize()>0) {
			for (int i = 0; i < parms.getSize(); i++) {
				MyMap cfgmap=(MyMap) parms.Get(i);
				HashMap<String, Object> cfg=new HashMap<String, Object>();
				
				for (int j = 0; j < cfgmap.size(); j++) {
					if (cfgmap.getKey(j).toString().indexOf("pname")==-1) {
						cfg.put(cfgmap.getKey(j).toString(), cfgmap.getValue(j));
						//BA.Log("key:"+cfgmap.getKey(j).toString()+" Val:"+cfgmap.getValue(j));
					}
				}
				ShareSDK.setPlatformDevInfo(cfgmap.get("pname").toString(), cfg);
				//BA.Log("initPlatforms from code pname:"+cfgmap.get("pname").toString());
			}
		}
	}
	public void LoginByWeixin() {
		Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
		authorize(wechat);
	}
	public void LoginByQQZone(){
		Platform qzone = ShareSDK.getPlatform(QZone.NAME);
		authorize(qzone);
	}
	public void LogoutByWeixin() {
		Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
		wechat.removeAccount(true);
	}
	public void LogoutByQQZone(){
		Platform qzone = ShareSDK.getPlatform(QZone.NAME);
		qzone.removeAccount(true);
		
	}
	
	//执行授权,获取用户信息
	//文档：http://wiki.mob.com/Android_%E8%8E%B7%E5%8F%96%E7%94%A8%E6%88%B7%E8%B5%84%E6%96%99
	private void authorize(Platform plat) {
		plat.setPlatformActionListener(this);
		//关闭SSO授权
		plat.SSOSetting(!sso);
		plat.showUser(null);
	}
	@Override
	public void onCancel(Platform arg0, int action) {
		// TODO Auto-generated method stub
		mBa.raiseEventFromDifferentThread(this, null, 0, EN+"_oncancel", true, new Object[]{action,arg0});
	}
	@Override
	public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
		// TODO Auto-generated method stub
		BA.Log("onComplete");
		Map m=new Map();
		m.Initialize();
		Iterator<String> lst= arg2.keySet().iterator();
		while (lst.hasNext()) {
			String tString=lst.next();
			m.Put(tString, arg2.get(tString));
		}
		m.Put("token", arg0.getDb().getToken());
		m.Put("userid", arg0.getDb().getUserId());
		m.Put("username", arg0.getDb().getUserName());
		m.Put("pname", arg0.getDb().getPlatformNname());
		mBa.raiseEventFromDifferentThread(this, null, 0, EN+"_oncomplete", true, new Object[]{arg1,arg0,m});
	}
	@Override
	public void onError(Platform arg0, int arg1, Throwable arg2) {
		// TODO Auto-generated method stub
		mBa.raiseEventFromDifferentThread(this, null, 0, EN+"_onerror", true, new Object[]{arg1,arg0,arg2.getMessage()});
	}
}
