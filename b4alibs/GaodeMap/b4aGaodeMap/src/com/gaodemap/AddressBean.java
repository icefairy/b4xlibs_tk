package com.gaodemap;

import anywheresoftware.b4a.BA.ShortName;

@ShortName("AddressBean")
public class AddressBean {
    private double longitude;//经度
    private double latitude;//纬度
    private String title;//信息标题
    private String text;//信息内容
    private String ProvinceName;// 省/自治区/直辖市/特别行政区名称 
   /* public AddressBean(double lon, double lat, String title, String text,String PName){
        this.longitude = lon;
        this.latitude = lat;
        this.title = title;
        this.text = text;
        this.ProvinceName = PName;
    }*/
    public void init(double lon, double lat, String title, String text,String PName){
    	this.longitude = lon;
        this.latitude = lat;
        this.title = title;
        this.text = text;
        this.ProvinceName = PName;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude){
    	this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude){
    	this.latitude = latitude;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
    	this.title = title;
    }
    public String getText(){
        return text;
    }
    public void setText(String text){
    	this.text = text;
    }
    public void clear(){
    	this.longitude = 0;
        this.latitude = 0;
        this.title = "";
        this.text = "";
        this.ProvinceName = "";
    }
    public String getProvinceName(){
        return ProvinceName;
    }
}