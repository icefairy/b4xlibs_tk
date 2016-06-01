package com.gaodemap;

import com.amap.api.maps2d.model.LatLng;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("LatLng")
public class LatLngWraper extends AbsObjectWrapper<LatLng> {
	public void init(double lat, double lng) {
		setObject(new LatLng(lat, lng));
	}
	public double getlat() {
		return getObject().latitude;
	}
	public double getlng() {
		return getObject().longitude;
	}
}
