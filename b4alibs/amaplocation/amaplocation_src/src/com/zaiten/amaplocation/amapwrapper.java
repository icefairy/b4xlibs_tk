package com.zaiten.amaplocation;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationListener;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@ShortName("AMapLocationClient")
@Version(2.4f)
@Author("icefairy333")
@Events(values={"onLocationChanged(loc as AMapLocation)"})
@DependsOn(values={"AMap_Location_core"})
@Permissions(values={"android.permission.INTERNET","android.permission.WRITE_EXTERNAL_STORAGE","android.permission.ACCESS_COARSE_LOCATION","android.permission.ACCESS_NETWORK_STATE","android.permission.ACCESS_FINE_LOCATION","android.permission.READ_PHONE_STATE","android.permission.CHANGE_WIFI_STATE","android.permission.ACCESS_WIFI_STATE","android.permission.CHANGE_CONFIGURATION","android.permission.WAKE_LOCK","android.permission.WRITE_SETTINGS"})
public class amapwrapper {
	private BA mBa;
	private String EN;
	private AMapLocationClient cli=null;
	private AMapLocation curloc=null;
	private boolean isLocing=false;
	/*
	 * MiniSdk=8
	 * add this to your manifest editor(under application):
	 * <meta-data
            android:name="com.amap.api.v2.apikey"
            android:value="Your key" />
        <service android:name="com.amap.api.location.APSService" >
        </service>
	 */
	public void Init(BA ba,String EventName) {
		EN=EventName.toLowerCase(BA.cul);
		mBa=ba;
		cli=new AMapLocationClient(BA.applicationContext);
		cli.setLocationListener(new AMapLocationListener() {
			
			@Override
			public void onLocationChanged(AMapLocation arg0) {
				// TODO Auto-generated method stub
				BA.Log(arg0.toStr());
				curloc=arg0;
				AMapLocationWrapper amlw=new AMapLocationWrapper();
				amlw.setObject(curloc);
				if (mBa.subExists(EN+"_onLocationChanged".toLowerCase())) {
					mBa.raiseEvent(this, EN+"_onLocationChanged".toLowerCase(), new Object[]{amlw});
				}else {
					BA.LogError("sub not exist:"+EN+"_onLocationChanged".toLowerCase());
				}
				
			}
		});
	}
	public void setLocationOption(locationOptionWrapper arg0) {
		if (cli==null) {
			BA.LogError("Not Init");
			return;
		}
		cli.setLocationOption(arg0.getObject());
	}
	public void StartLocation() {
		if (cli==null) {
			BA.LogError("Not Init");
			return;
		}
		if (!isLocing) {
			isLocing=true;
			cli.startLocation();
		}else{
			BA.Log("isLocating Alread");
		}
		
	}
	public void StopLocation() {
		if (cli==null) {
			BA.LogError("Not Init");
			return;
		}
		if (isLocing) {
			isLocing=false;
			cli.stopLocation();
		}else{
			BA.Log("NotLocating");
		}
	}
	public void OnDestory() {
		if (cli==null) {
			BA.LogError("Not Init");
			return;
		}
		cli.onDestroy();
		cli=null;
	}
	
}
