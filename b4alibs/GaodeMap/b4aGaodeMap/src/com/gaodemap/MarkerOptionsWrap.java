package com.gaodemap;

import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.MarkerOptions;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("MarkerOptions")
public class MarkerOptionsWrap extends AbsObjectWrapper<MarkerOptions> {
	public void init() {
		setObject(new MarkerOptions());
	}
	public MarkerOptionsWrap iconfromasset(String fn) {
		getObject().icon(BitmapDescriptorFactory.fromAsset(fn));
		return this;
	}
	public MarkerOptionsWrap icondefault() {
		getObject().icon(BitmapDescriptorFactory.defaultMarker());
		return this;
	}
	public MarkerOptionsWrap iconfromfile(String paramString) {
		getObject().icon(BitmapDescriptorFactory.fromFile(paramString));
		return this;
	}
	public MarkerOptionsWrap draggable(boolean paramBoolean) {
		getObject().draggable(paramBoolean);
		return this;
	}
	public MarkerOptionsWrap position(LatLngWraper paramLatLng) {
		getObject().position(paramLatLng.getObject());
		return this;
	}
	public MarkerOptionsWrap title(String paramString) {
		getObject().title(paramString);
		return this;
	}
	public MarkerOptionsWrap snippet(String paramString) {
		getObject().snippet(paramString);
		return this;
	}
	public MarkerOptionsWrap anchor(float paramFloat1, float paramFloat2) {
		getObject().anchor(paramFloat1, paramFloat2);
		return this;
	}
	public MarkerOptionsWrap setGps(boolean paramBoolean) {
		getObject().setGps(paramBoolean);
		return this;
	}
	public MarkerOptionsWrap visible(boolean paramBoolean) {
		getObject().visible(paramBoolean);
		return this;
	}
	public MarkerOptionsWrap period(int paramInt) {
		getObject().period(paramInt);
		return this;
	}
	public String toString() {
		return getObject().toString();
		
	}
}
