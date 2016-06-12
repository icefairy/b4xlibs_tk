package com.zaiten.amaplocation;

import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("locationOption")
public class locationOptionWrapper extends AbsObjectWrapper<AMapLocationClientOption> {
	public static AMapLocationMode Battery_Saving=AMapLocationMode.Battery_Saving;
	public static AMapLocationMode Device_Sensors=AMapLocationMode.Device_Sensors;
	public static AMapLocationMode Hight_Accuracy=AMapLocationMode.Hight_Accuracy;
	public void init() {
		setObject(new AMapLocationClientOption());
		setLocationMode(Battery_Saving);
	}
	/*
	 * default Battery_Saving
	 */
	public AMapLocationMode getLocationMode() {
		return getObject().getLocationMode();
	}
	public void setLocationMode(AMapLocationMode locationMode) {
		getObject().setLocationMode(locationMode);
	}
	/*
	 * min=1000
	 */
	public void setInterval(long val) {
		getObject().setInterval(val);
		
	}
	public long getInterval() {
		return getObject().getInterval();
	}
	public boolean getGPSFirst() {
		return getObject().isGpsFirst();
	}
	public void setGPSFirst(boolean gPSFirst) {
		getObject().setGpsFirst(gPSFirst);
		
	}
	public boolean getOnceLocation() {
		return getObject().isOnceLocation();
	}
	public void setOnceLocation(boolean onceLocation) {
		getObject().setOnceLocation(onceLocation);
	}
	public boolean getMockEnable() {
		return getObject().isMockEnable();
	}
	public void setMockEnable(boolean mockEnable) {
		getObject().setMockEnable(mockEnable);
	}
	public boolean getNeedAddress() {
		return getObject().isNeedAddress();
	}
	public void setNeedAddress(boolean needAddress) {
		getObject().setNeedAddress(needAddress);
	}
	
	
}
