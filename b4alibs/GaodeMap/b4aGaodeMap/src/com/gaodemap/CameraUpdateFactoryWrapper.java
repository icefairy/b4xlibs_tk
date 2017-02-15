package com.gaodemap;

import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.CameraUpdateFactory;

import anywheresoftware.b4a.BA.ShortName;

@ShortName("CameraUpdateFactory")
public class CameraUpdateFactoryWrapper {
	public CameraUpdate changeLatLng(LatLngWraper paramLatLng) {
		return CameraUpdateFactory.changeLatLng(paramLatLng.getObject());
	}
	public CameraUpdate newLatLng(LatLngWraper paramLatLng) {
		return CameraUpdateFactory.newLatLng(paramLatLng.getObject());
	}
	public CameraUpdate newLatLngZoom(LatLngWraper paramLatLng, float paramFloat) {
		return CameraUpdateFactory.newLatLngZoom(paramLatLng.getObject(), paramFloat);
	}
	public CameraUpdate newLatLng(float paramFloat2, float paramFloat1) {
		return CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2);
	}
	public CameraUpdate zoomIn() {
		return CameraUpdateFactory.zoomIn();
	}
	public CameraUpdate zoomOut() {
		return CameraUpdateFactory.zoomOut();
	}
	public CameraUpdate zoomTo(float paramFloat) {
		return CameraUpdateFactory.zoomTo(paramFloat);
	}
}
