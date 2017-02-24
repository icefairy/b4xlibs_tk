package com.bugly;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@ShortName("bugly")
@Author("icefairy333")
@Version(3.00f)
@DependsOn(values={"crashreport_upgrade-1.2.3","crashreport_upgrade-1.2.3.aar"})
@Permissions(values={"android.permission.WRITE_EXTERNAL_STORAGE","android.permission.READ_PHONE_STATE" ,"android.permission.INTERNET" ,"android.permission.ACCESS_NETWORK_STATE" ,"android.permission.ACCESS_WIFI_STATE" ,"android.permission.READ_LOGS" })
public class buglywrapper {
	public void startCatching(String appid) {
		Bugly.init(BA.applicationContext, appid, false);
	}
	public void testJavaCrash() {
		CrashReport.testJavaCrash();
	}
	public void checkUpgrade(boolean isManual,boolean isSilence ) {
		Beta.checkUpgrade(isManual, isSilence );
	}
}
