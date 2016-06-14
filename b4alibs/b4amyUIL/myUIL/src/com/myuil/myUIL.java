package com.myuil;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.objects.ImageViewWrapper;

@ShortName("myUIL")
@Version(1.10f)
@Author("Icefairy333")
@DependsOn(values={"universal-image-loader-1.9.5"})
@Permissions(values={"android.permission.INTERNET","android.permission.ACCESS_NETWORK_STATE","android.permission.WRITE_EXTERNAL_STORAGE","android.permission.READ_EXTERNAL_STORAGE"})
public class myUIL {
	private BA mba;
	private String EN;
	public boolean memcache=false;
	public boolean diskcache=true;
	public boolean resetViewBeforeLoading=false;
	public int delayBeforeLoading=0;
	public int nLoadResId=0;
	public int nFailResId=0;
	public ScaleType defScaleType=null;
	public ScaleType FIT_XY=ScaleType.FIT_XY;
	public ScaleType FIT_CENTER=ScaleType.FIT_CENTER;
	public ScaleType CENTER=ScaleType.CENTER;
	public ScaleType MATRIX=ScaleType.MATRIX;
	public ScaleType FIT_START=ScaleType.FIT_START;
	public ScaleType FIT_END=ScaleType.FIT_END;
	public void init(BA ba,String eventname) {
		EN=eventname.toLowerCase();
		mba=ba;
		ToolImage.initImageLoader(ba.context);
	}
	/**
	 * Acceptable URIs examples
	 * "http://site.com/image.png" // from Web
	 * "file:///mnt/sdcard/image.png" // from SD card
	 * "file:///mnt/sdcard/video.mp4" // from SD card (video thumbnail)
	 * "content://media/external/images/media/13" // from content provider
	 * "content://media/external/video/media/13" // from content provider (video thumbnail)
	 * "assets://image.png" // from assets
	 * "drawable://" + R.drawable.img // from drawables (non-9patch images)
	 */
	public void ShowImage(ImageView iv,String uri) {
		if (defScaleType!=null) {
			iv.setScaleType(defScaleType);
		}
		DisplayImageOptions.Builder dio=new DisplayImageOptions.Builder()
			.cacheOnDisk(diskcache)
			.cacheInMemory(memcache)
			.delayBeforeLoading(delayBeforeLoading)
			.resetViewBeforeLoading(resetViewBeforeLoading);
		if(nLoadResId>0){
			dio.showImageOnLoading(nLoadResId);
		}
		if(nFailResId>0){
			dio.showImageOnFail(nFailResId);
		}
		ImageViewWrapper ivw;
		ToolImage.getImageLoader().displayImage(uri, iv,dio.build());
	}
	public void ShowCircleImage(ImageView iv,String uri,int strokeColor,int strokeWidth) {
		if (defScaleType!=null) {
			iv.setScaleType(defScaleType);
		}
		DisplayImageOptions.Builder dio=new DisplayImageOptions.Builder()
			.cacheOnDisk(diskcache)
			.cacheInMemory(memcache)
			.delayBeforeLoading(delayBeforeLoading)
			.resetViewBeforeLoading(resetViewBeforeLoading);
		if(nLoadResId>0){
			dio.showImageOnLoading(nLoadResId);
		}
		if(nFailResId>0){
			dio.showImageOnFail(nFailResId);
		}
		dio.displayer(new CircleBitmapDisplayer(strokeColor,strokeWidth));
		ToolImage.getImageLoader().displayImage(uri, iv,dio.build());
	}
	public void ShowRoundCornImage(ImageView iv,String uri,int cornerRadiusPixels,int marginPixels) {
		if (defScaleType!=null) {
			iv.setScaleType(defScaleType);
		}
		DisplayImageOptions.Builder dio=new DisplayImageOptions.Builder()
				.cacheOnDisk(diskcache)
				.cacheInMemory(memcache)
				.delayBeforeLoading(delayBeforeLoading)
				.resetViewBeforeLoading(resetViewBeforeLoading);
		if(nLoadResId>0){
			dio.showImageOnLoading(nLoadResId);
		}
		if(nFailResId>0){
			dio.showImageOnFail(nFailResId);
		}
		dio.displayer(new RoundedBitmapDisplayer(cornerRadiusPixels,marginPixels));
		ToolImage.getImageLoader().displayImage(uri, iv,dio.build());
	}
	public void ClearCache() {
		ToolImage.clearCache();
	}
	public String getfilePath(String uri) {
		return ToolImage.getImageLoader().getDiskCache().get(uri).getAbsolutePath();
	}
	public void cancelDisplayTask(ImageView iv) {
		ToolImage.getImageLoader().cancelDisplayTask(iv);
	}
}
