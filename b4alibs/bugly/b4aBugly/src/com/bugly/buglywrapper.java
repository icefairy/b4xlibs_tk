package com.bugly;

import com.tencent.bugly.crashreport.CrashReport;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@ShortName("bugly")
@Author("icefairy333")
@Version(1.00f)
@DependsOn(values={"bugly_crash_release__2.1.1"})
@Permissions(values={"android.permission.READ_PHONE_STATE" ,"android.permission.INTERNET" ,"android.permission.ACCESS_NETWORK_STATE" ,"android.permission.ACCESS_WIFI_STATE" ,"android.permission.READ_LOGS" })
public class buglywrapper {
	public void startCatching(String appid) {
		if(appid.length()>0){
			CrashReport.initCrashReport(BA.applicationContext,appid,false);
		}else{
			CrashReport.initCrashReport(BA.applicationContext);
		}
	}
	public void testJavaCrash() {
		CrashReport.testJavaCrash();
	}
}
