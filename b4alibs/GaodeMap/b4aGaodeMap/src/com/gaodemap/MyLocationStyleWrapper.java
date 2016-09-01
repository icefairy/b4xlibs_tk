package com.gaodemap;

import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.MyLocationStyle;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper;

@ShortName("MyLocationStyle")
public class MyLocationStyleWrapper extends AbsObjectWrapper<MyLocationStyle> {
	public static final float HUE_RED = 0.0F;
	public static final float HUE_ORANGE = 30.0F;
	public static final float HUE_YELLOW = 60.0F;
	public static final float HUE_GREEN = 120.0F;
	public static final float HUE_CYAN = 180.0F;
	public static final float HUE_AZURE = 210.0F;
	public static final float HUE_BLUE = 240.0F;
	public static final float HUE_VIOLET = 270.0F;
	public static final float HUE_MAGENTA = 300.0F;
	public static final float HUE_ROSE = 330.0F;
	public void init() {
		setObject(new MyLocationStyle());
	}
	public MyLocationStyleWrapper iconfromasset(String fn) {
		getObject().myLocationIcon(BitmapDescriptorFactory.fromAsset(fn));
		return this;
	}
	public MyLocationStyleWrapper iconfrombmp(BitmapWrapper bw) {
		getObject().myLocationIcon(BitmapDescriptorFactory.fromBitmap(bw.getObject()));
		return this;
	}
	public MyLocationStyleWrapper icondefault2(float hue) {
		getObject().myLocationIcon(BitmapDescriptorFactory.defaultMarker(hue));
		return this;
	}
	public MyLocationStyleWrapper icondefault() {
		getObject().myLocationIcon(BitmapDescriptorFactory.defaultMarker());
		return this;
	}
	public MyLocationStyleWrapper icondefault2() {
		getObject().myLocationIcon(BitmapDescriptorFactory.defaultMarker());
		return this;
	}
	public MyLocationStyleWrapper iconfromfile(String paramString) {
		getObject().myLocationIcon(BitmapDescriptorFactory.fromFile(paramString));
		return this;
	}
	public MyLocationStyleWrapper strokeWidth(float strokeWidth) {
		getObject().strokeWidth(strokeWidth);
		return this;
	}
	public MyLocationStyleWrapper strokeColor(int paramInt) {
		getObject().strokeColor(paramInt);
		return this;
	}
	public MyLocationStyleWrapper radiusFillColor(int paramInt) {
		getObject().radiusFillColor(paramInt);
		return this;
	}
	public MyLocationStyleWrapper anchor(float paramFloat1, float paramFloat2) {
		getObject().anchor(paramFloat1, paramFloat2);
		return this;
	}
	public String toString() {
		return getObject().toString();
		
	}
}
