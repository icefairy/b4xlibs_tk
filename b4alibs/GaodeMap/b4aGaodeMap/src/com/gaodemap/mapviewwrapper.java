package com.gaodemap;

import java.util.ArrayList;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.AMap.OnCameraChangeListener;
import com.amap.api.maps2d.AMap.OnMapClickListener;
import com.amap.api.maps2d.AMap.OnMapLoadedListener;
import com.amap.api.maps2d.AMap.OnMapLongClickListener;
import com.amap.api.maps2d.AMap.OnMarkerClickListener;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.loc.*;

import android.os.Bundle;
import android.view.View;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.ViewWrapper;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;

@ShortName("GaodeMap2D")
@DependsOn(values={"android-support-v4","AMap_Location_core","Amap_2DMap_V5.2.0_20170627","AMap_Search_V5.3.0_20170814"})
@Permissions(values={"android.permission.INTERNET","android.permission.WRITE_EXTERNAL_STORAGE","android.permission.ACCESS_COARSE_LOCATION","android.permission.ACCESS_NETWORK_STATE","android.permission.ACCESS_FINE_LOCATION","android.permission.READ_PHONE_STATE","android.permission.CHANGE_WIFI_STATE","android.permission.ACCESS_WIFI_STATE","android.permission.CHANGE_CONFIGURATION","android.permission.WAKE_LOCK"})
@ActivityObject
@Version(1.31f)
@Events(values={"poiList(l as list)","onmaploadedlistener(x as double,y as double)","onmapclick(pos as LatLng)","onmaplongclick(pos as LatLng)","oncamerachangestart(pos as LatLng)","oncamerachangeover(pos as LatLng)","OnMarkerClick(markerid as String,markertitle as String,markerpos as Latlng) as Boolean"})
public class mapviewwrapper extends ViewWrapper<com.amap.api.maps2d.MapView> implements LocationSource, DesignerCustomView, AMapLocationListener {
	private String En;
	private BA mBa;
	public MapView mv;
	public AMap aMap;
	private OnMapClickListener omcl;
	private OnMapLongClickListener omlcl;
	private OnCameraChangeListener occl;
	private OnLocationChangedListener mListener;
	private AMapLocationClient mlocationClient;
	private AMapLocationClientOption mLocationOption;
	private OnMarkerClickListener mMarkerClickListener;
	@Override
	public void DesignerCreateView(PanelWrapper base, LabelWrapper arg1, Map arg2) {
		// TODO Auto-generated method stub
		base.AddView(mv, 0,0,base.getWidth(),base.getHeight());
		init();
		if (aMap!=null) {
			if (mBa.subExists(En+"_onmapclick")) {
				aMap.setOnMapClickListener(omcl);
			}
			if (mBa.subExists(En+"_onmaplongclick")) {
				aMap.setOnMapLongClickListener(omlcl);
			}
			if (mBa.subExists(En+"_oncamerachangestart")) {
				aMap.setOnCameraChangeListener(occl);
			}
			if (mBa.subExists(En+"_onmarkerclick")) {
				aMap.setOnMarkerClickListener(mMarkerClickListener);
			}
			if (mBa.subExists(En+"_oncamerachangeover")) {
				aMap.setOnCameraChangeListener(occl);
			}
		}
		
		
	}

	@Override
	public void _initialize(BA ba, Object activityClass, String eventname) {
		// TODO Auto-generated method stub
		En=eventname.toLowerCase();
		mBa=ba;
		mv=new MapView(ba.context);
		setObject(mv);
		omcl=new OnMapClickListener() {
			
			@Override
			public void onMapClick(LatLng paramLatLng) {
				// TODO Auto-generated method stub
				LatLngWraper llw=new LatLngWraper();
				llw.init(paramLatLng.latitude, paramLatLng.longitude);
				mBa.raiseEvent(this, En+"_onmapclick", new Object[]{llw});
			}
		};
		omlcl=new OnMapLongClickListener() {
			
			@Override
			public void onMapLongClick(LatLng paramLatLng) {
				// TODO Auto-generated method stub
				LatLngWraper llw=new LatLngWraper();
				llw.init(paramLatLng.latitude, paramLatLng.longitude);
				mBa.raiseEvent(this, En+"_onmaplongclick", new Object[]{llw});
			}
		};
		occl=new OnCameraChangeListener() {
			
			@Override
			public void onCameraChangeFinish(CameraPosition paramCameraPosition) {
				// TODO Auto-generated method stub
				LatLngWraper llw=new LatLngWraper();
				llw.init(paramCameraPosition.target.latitude, paramCameraPosition.target.longitude);
				mBa.raiseEvent(this, En+"_oncamerachangeover", new Object[]{llw});
			}
			
			@Override
			public void onCameraChange(CameraPosition paramCameraPosition) {
				// TODO Auto-generated method stub
				LatLngWraper llw=new LatLngWraper();
				llw.init(paramCameraPosition.target.latitude, paramCameraPosition.target.longitude);
		        mBa.raiseEvent(this, En+"_oncamerachangestart", new Object[]{llw});
			}
		};
		mMarkerClickListener=new OnMarkerClickListener() {
			
			@Override
			public boolean onMarkerClick(Marker marker) {
				// TODO Auto-generated method stub
				LatLngWraper llw=new LatLngWraper();
				llw.setObject(marker.getPosition());
				boolean ret= (boolean) mBa.raiseEvent(this, En+"_onmarkerclick", new Object[]{marker.getId(),marker.getTitle(),llw});
				return ret;
			}
		};
		
	}
	

	public boolean getCompassEnabled() {
		if (aMap!=null) {
			return aMap.getUiSettings().isCompassEnabled();
		}
		return false;
	}
	public void setCompassEnabled(boolean paramBoolean) {
		if (aMap!=null) {
			aMap.getUiSettings().setCompassEnabled(paramBoolean);
		}
	}
	public boolean getScaleControlsEnabled() {
		if (aMap!=null) {
			return aMap.getUiSettings().isScaleControlsEnabled();
		}
		return false;
	}
	public void setScaleControlsEnabled(boolean paramBoolean) {
		if (aMap!=null) {
			aMap.getUiSettings().setScaleControlsEnabled(paramBoolean);
		}
	}
	public boolean getScrollGesturesEnabled() {
		if (aMap!=null) {
			return aMap.getUiSettings().isScrollGesturesEnabled();
		}
		return false;
	}
	public void setScrollGesturesEnabled(boolean paramBoolean) {
		if (aMap!=null) {
			aMap.getUiSettings().setScrollGesturesEnabled(paramBoolean);
		}
	}
	public boolean getZoomGesturesEnabled() {
		if (aMap!=null) {
			return aMap.getUiSettings().isZoomGesturesEnabled();
		}
		return false;
	}
	public void setZoomGesturesEnabled(boolean paramBoolean) {
		if (aMap!=null) {
			aMap.getUiSettings().setZoomGesturesEnabled(paramBoolean);
		}
	}
	public boolean getZoomControlsEnabled() {
		if (aMap!=null) {
			return aMap.getUiSettings().isZoomControlsEnabled();
		}
		return false;
	}
	public void setZoomControlsEnabled(boolean paramBoolean) {
		if (aMap!=null) {
			aMap.getUiSettings().setZoomControlsEnabled(paramBoolean);
		}
	}
	public View asView() {
		return getObject();
	}
	public void onCreate(Bundle bundle) {
		getObject().onCreate(bundle);
	}
	public void onResume() {
		getObject().onResume();
	}
	public void onDestroy() {
		getObject().onDestroy();
	}
	public void onPause() {
		getObject().onPause();
	}
	private void init() {
		if (aMap == null) {
			aMap = getObject().getMap();
		}
		
	}
	public void ClearAllMarkerAndSoOn() {
		if (aMap!=null) {
			aMap.clear();
		}
			
	}	
	public Marker addMarker(MarkerOptionsWrap arg0) {
		
		return aMap.addMarker(arg0.getObject());
	}
	public void MarkerShowInfoWindow(Marker mark) {
		if (mark!=null) {
			mark.showInfoWindow();
		}
	}
	public LatLngWraper MarkerGetPosition(Marker mark) {
		if (mark!=null) {
			LatLngWraper llw=new LatLngWraper();
			llw.setObject(mark.getPosition());
			return llw;
		}
		return null;
	}
	public String MarkerGetTitle(Marker mark) {
		if (mark!=null) {
			return mark.getTitle();
		}
		return null;
	}
	public void onSaveInstanceState(Bundle arg0) {
		getObject().onSaveInstanceState(arg0);
	}
	public void changeCamera(CameraUpdate update,boolean withanimate) {
		if (withanimate) {
			aMap.animateCamera(update, 1000, null);
		} else {
			aMap.moveCamera(update);
		}
	}
	public void setTrafficEnabled(boolean paramBoolean) {
		aMap.setTrafficEnabled(paramBoolean);
	}
	public void invalidateMap() {
		aMap.invalidate();
		
	}
	public void setMyLocationEnabled(boolean paramBoolean) {
		if (paramBoolean) {
			aMap.setLocationSource(this);
		}
		aMap.setMyLocationEnabled(paramBoolean);
	}
	public void setMyLocationButtonEnabled(boolean paramBoolean){
		aMap.getUiSettings().setMyLocationButtonEnabled(paramBoolean);
	}
	public void setMyLocationRotateAngle(float paramFloat) {
		aMap.setMyLocationRotateAngle(paramFloat);
	}
	public void setMapType(int paramInt) {
		aMap.setMapType(paramInt);
	}
	public void setMyLocationStyle(MyLocationStyleWrapper paramMyLocationStyle) {
		aMap.setMyLocationStyle(paramMyLocationStyle.getObject());
	}
	public void addCircle(CircleOptionWrapper paramCircleOptions) {
		aMap.addCircle(paramCircleOptions.getObject());
	}
	public void addText(TextOptionWrapper paramTextOptions) {
		aMap.addText(paramTextOptions.getObject());
	}

	@Override
	public void activate(OnLocationChangedListener listener) {
		// TODO Auto-generated method stub
		mListener = listener;
		if (mlocationClient == null) {
			mlocationClient = new AMapLocationClient(mBa.context);
			mLocationOption = new AMapLocationClientOption();
			//设置定位监听
			mlocationClient.setLocationListener(this);
			//设置为高精度定位模式
			mLocationOption.setLocationMode(AMapLocationMode.Hight_Accuracy);
			//设置定位参数
			mlocationClient.setLocationOption(mLocationOption);
			// 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
			// 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
			// 在定位结束后，在合适的生命周期调用onDestroy()方法
			// 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
			mlocationClient.startLocation();
			
		}
	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub
		mListener = null;
		if (mlocationClient != null) {
			mlocationClient.stopLocation();
			mlocationClient.onDestroy();
		}
		mlocationClient = null;
	}

	@Override
	public void onLocationChanged(AMapLocation amapLocation) {
		// TODO Auto-generated method stub
		if (mListener != null && amapLocation != null) {
			if (amapLocation != null
					&& amapLocation.getErrorCode() == 0) {
				//BA.Log(amapLocation.toString());
				mListener.onLocationChanged(amapLocation);// 显示系统小蓝点
			
			} else {
				String errText = "定位失败," + amapLocation.getErrorCode()+ ": " + amapLocation.getErrorInfo();
				BA.LogError(errText);
			}
		}
	}

}
