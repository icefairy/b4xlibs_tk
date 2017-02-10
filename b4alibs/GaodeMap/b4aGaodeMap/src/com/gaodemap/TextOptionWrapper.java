package com.gaodemap;

import com.amap.api.maps2d.model.TextOptions;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;

@ShortName("TextOption")
public class TextOptionWrapper extends AbsObjectWrapper<TextOptions> {
	public void init() {
		setObject(new TextOptions());
	}
	public TextOptionWrapper align(int x, int y) {
		getObject().align(x, y);
		return this;
	}
	public TextOptionWrapper backgroundColor(int paramInt) {
		getObject().backgroundColor(paramInt);
		return this;
	}
	public TextOptionWrapper visible(boolean paramBoolean) {
		getObject().visible(paramBoolean);
		return this;
	}
	public TextOptionWrapper fontSize( int paramInt) {
		getObject().fontSize(paramInt);
		return this;
	}
	public TextOptionWrapper fontColor( int paramInt) {
		getObject().fontColor(paramInt);
		return this;
	}
	public TextOptionWrapper text(String paramString) {
		getObject().text(paramString);
		return this;
	}
	public TextOptionWrapper position(LatLngWraper paramLatLng) {
		getObject().position(paramLatLng.getObject());
		return this;
	}
	public TextOptionWrapper rotate(float paramFloat) {
		getObject().rotate(paramFloat);
		return this;
	}
	public String toString() {
		return getObject().toString();
		
	}
}
