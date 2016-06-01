package com.gaodemap;

import com.amap.api.maps2d.model.CircleOptions;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("CircleOption")
public class CircleOptionWrapper extends AbsObjectWrapper<CircleOptions> {
	public void init() {
		setObject(new CircleOptions());
	}
	public CircleOptionWrapper iconfromasset(LatLngWraper llw) {
		getObject().center(llw.getObject());
		return this;
	}
	public CircleOptionWrapper fillColor(int paramInt) {
		getObject().fillColor(paramInt);
		return this;
	}
	public CircleOptionWrapper visible(boolean paramBoolean) {
		getObject().visible(paramBoolean);
		return this;
	}
	public CircleOptionWrapper radius( double paramDouble) {
		getObject().radius(paramDouble);
		return this;
	}
	public CircleOptionWrapper strokeWidth(float strokeWidth) {
		getObject().strokeWidth(strokeWidth);
		return this;
	}
	public CircleOptionWrapper strokeColor(int paramInt) {
		getObject().strokeColor(paramInt);
		return this;
	}
	public String toString() {
		return getObject().toString();
		
	}
}
