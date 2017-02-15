package com.zaiten.amaplocation;
import com.amap.api.location.AMapLocation;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
@ShortName("AMapLocation")
public class AMapLocationWrapper extends AbsObjectWrapper<AMapLocation> {

	public float getAccuracy() {
	
		return getObject().getAccuracy();
	}

	public String getAdCode() {
	
		return getObject().getAdCode();
	}

	public String getAddress() {
	
		return getObject().getAddress();
	}

	public double getAltitude() {
	
		return getObject().getAltitude();
	}

	public String getAoiName() {
	
		return getObject().getAoiName();
	}

	public float getBearing() {
	
		return getObject().getBearing();
	}

	public String getCity() {
	
		return getObject().getCity();
	}

	public String getCityCode() {
	
		return getObject().getCityCode();
	}

	public String getCountry() {
	
		return getObject().getCountry();
	}

	public String getDistrict() {
	
		return getObject().getDistrict();
	}

	public int getErrorCode() {
	
		return getObject().getErrorCode();
	}

	public String getErrorInfo() {
	
		return getObject().getErrorInfo();
	}

	public double getLatitude() {
	
		return getObject().getLatitude();
	}

	public String getLocationDetail() {
	
		return getObject().getLocationDetail();
	}

	public int getLocationType() {
	
		return getObject().getLocationType();
	}

	public double getLongitude() {
	
		return getObject().getLongitude();
	}

	public String getPoiName() {
	
		return getObject().getPoiName();
	}

	public String getProvider() {
	
		return getObject().getProvider();
	}

	public String getProvince() {
	
		return getObject().getProvince();
	}

	@SuppressWarnings("deprecation")
	public String getRoad() {
	
		return getObject().getRoad();
	}

	public int getSatellites() {
	
		return getObject().getSatellites();
	}

	public float getSpeed() {
	
		return getObject().getSpeed();
	}

	public String getStreet() {
	
		return getObject().getStreet();
	}

	public String getStreetNum() {
	
		return getObject().getStreetNum();
	}

	public boolean isOffset() {
	
		return getObject().isOffset();
	}

	public void setAdCode(String arg0) {
	
		getObject().setAdCode(arg0);
	}

	public void setAddress(String arg0) {
	
		getObject().setAddress(arg0);
	}

	public void setAoiName(String arg0) {
	
		getObject().setAoiName(arg0);
	}

	public void setCity(String arg0) {
	
		getObject().setCity(arg0);
	}

	public void setCityCode(String arg0) {
	
		getObject().setCityCode(arg0);
	}

	public void setCountry(String arg0) {
	
		getObject().setCountry(arg0);
	}

	public void setDistrict(String arg0) {
	
		getObject().setDistrict(arg0);
	}

	public void setErrorCode(int arg0) {
	
		getObject().setErrorCode(arg0);
	}

	public void setErrorInfo(String arg0) {
	
		getObject().setErrorInfo(arg0);
	}

	public void setLatitude(double arg0) {
	
		getObject().setLatitude(arg0);
	}

	public void setLocationDetail(String arg0) {
	
		getObject().setLocationDetail(arg0);
	}

	public void setLocationType(int arg0) {
	
		getObject().setLocationType(arg0);
	}

	public void setLongitude(double arg0) {
	
		getObject().setLongitude(arg0);
	}

	public void setNumber(String arg0) {
	
		getObject().setNumber(arg0);
	}

	public void setOffset(boolean arg0) {
	
		getObject().setOffset(arg0);
	}

	public void setPoiName(String arg0) {
	
		getObject().setPoiName(arg0);
	}

	public void setProvince(String arg0) {
	
		getObject().setProvince(arg0);
	}

	@SuppressWarnings("deprecation")
	public void setRoad(String arg0) {
	
		getObject().setRoad(arg0);
	}

	public void setSatellites(int arg0) {
	
		getObject().setSatellites(arg0);
	}

	public void setStreet(String arg0) {
	
		getObject().setStreet(arg0);
	}

	public String toStr() {
	
		return getObject().toStr();
	}

	public String toString() {
	
		return getObject().toString();
	}
}
