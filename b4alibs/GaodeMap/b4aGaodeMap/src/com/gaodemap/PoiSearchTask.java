package com.gaodemap;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.poisearch.PoiSearch.SearchBound;

import java.util.ArrayList;
@ShortName("PoiSearchTask")
@ActivityObject
@DependsOn(values={"android-support-v4","AMap_Location_core","Amap_2DMap_V5.2.0_20170627","AMap_Search_V5.3.0_20170814"})
@Permissions(values={"android.permission.INTERNET","android.permission.WRITE_EXTERNAL_STORAGE","android.permission.ACCESS_COARSE_LOCATION","android.permission.ACCESS_NETWORK_STATE","android.permission.ACCESS_FINE_LOCATION","android.permission.READ_PHONE_STATE","android.permission.CHANGE_WIFI_STATE","android.permission.ACCESS_WIFI_STATE","android.permission.CHANGE_CONFIGURATION","android.permission.WAKE_LOCK"})
@Events(values={"poilist(l As List)"})

public class PoiSearchTask implements PoiSearch.OnPoiSearchListener {
    private PoiSearch mSearch;
    private BA mba;
    private String en;
    /*
     * demo:
      	sub demo
      		Dim poiType As String = "汽车服务|汽车销售|汽车维修|摩托车服务|餐饮服务|购物服务|生活服务|体育休闲服务|医疗保健服务|住宿服务|风景名胜|商务住宅|政府机构及社会团体|科教文化服务|交通设施服务|金融保险服务|公司企业|道路附属设施|地名地址信息|公共设施"
     		dim pst as PoiSearchTask
      		pst.init("youname")
     		
      		pst.onSearch("",poiType,"",100,100)
      	end sub	
      
      '回调函数
      sub youname_poilist(l as list)
      		if l.size = 0 then return 
      		for i = 0 to l.size - 1
      			dim addr as AddressBean = l.get(i)
     			log($"title:${addr.title},text:${addr.text},lon:${addr.lon},lat:${addr.lat}"$)
      		next
      
      end sub
     */
    public void init(BA ba,String EN){
    	mba = ba;
    	en = EN.toLowerCase();
    }
/*
* pioName:搜索字符串
* poitype:poi搜索类型
* city:搜索城市
* lat:纬度
* lng:经度
* 
	POI搜索类型共分为以下20种：汽车服务|汽车销售|
	汽车维修|摩托车服务|餐饮服务|购物服务|生活服务|体育休闲服务|医疗保健服务|
	住宿服务|风景名胜|商务住宅|政府机构及社会团体|科教文化服务|交通设施服务|
	金融保险服务|公司企业|道路附属设施|地名地址信息|公共设施

*/
    
    public void onSearch(String pioName,String poiType, String city,double lat,double lng){
        // 第一个参数表示搜索字符串，第二个参数表示poi搜索类型，第三个参数表示poi搜索区域（空字符串代表全国）
        PoiSearch.Query query = new PoiSearch.Query(pioName, poiType, city);
        mSearch = new PoiSearch(mba.context, query);
        mSearch.setBound(new SearchBound(new LatLonPoint(lat, lng), 500));//设置周边搜索的中心点以及半径
        //设置异步监听
        mSearch.setOnPoiSearchListener(this);
        //查询POI异步接口
        mSearch.searchPOIAsyn();
    }
    @Override
    @Hide()public void onPoiSearched(PoiResult poiResult, int rCode) {
        if(rCode == 1000) {
            if (poiResult != null && poiResult.getQuery() != null) {
                List datas = new List();
                datas.Initialize();
                ArrayList<PoiItem> items = poiResult.getPois();
                for(PoiItem item : items) {
                    //获取经纬度对象
                    LatLonPoint llp = item.getLatLonPoint();
                    double lon = llp.getLongitude();
                    double lat = llp.getLatitude();
                    //获取标题
                    String title = item.getTitle();
                    //获取内容
                    String text = item.getSnippet();
                    String PName = item.getProvinceName();
                    AddressBean adds = new AddressBean();
                    adds.init(lon, lat, title, text, PName);
                    datas.Add(adds);
                }
	            if(mba.subExists(en + "_poilist")){
	            	mba.raiseEvent(this, en + "_poilist", new Object[]{datas});
	            }
            }
        }
    }
    @Override
    @Hide()public void onPoiItemSearched(PoiItem poiItem, int i) {

    }
}