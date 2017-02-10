package com.myuil;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper;

@ShortName("myUIL")
@Version(1.4f)
@Author("Icefairy333")
@DependsOn(values={"universal-image-loader-1.9.5"})
@Permissions(values={"android.permission.INTERNET","android.permission.ACCESS_NETWORK_STATE","android.permission.WRITE_EXTERNAL_STORAGE","android.permission.READ_EXTERNAL_STORAGE"})
@Events(values={"onLoadingFailed(url As String,Reason As String)","onLoadingComplete(url as String,bmp as Bitmap)"})
public class myUIL {
	private BA mba;
	private String EN;
	public boolean memcache=false;
	public boolean diskcache=true;
	public boolean resetViewBeforeLoading=false;
	public boolean ViewBGTransparent=true;
	public int delayBeforeLoading=0;
	public Drawable nLoadResId=null;
	public Drawable nFailResId=null;
	public ScaleType defScaleType=null;
	public ScaleType FIT_XY=ScaleType.FIT_XY;
	public ScaleType FIT_CENTER=ScaleType.FIT_CENTER;
	public ScaleType CENTER=ScaleType.CENTER;
	public ScaleType MATRIX=ScaleType.MATRIX;
	public ScaleType FIT_START=ScaleType.FIT_START;
	public ScaleType FIT_END=ScaleType.FIT_END;
	private ImageLoadingListener ill;
	public Config bitmapCFG_def=Config.RGB_565;
	public Config bitmapCFG_RGB_565=Config.RGB_565;
	public Config bitmapCFG_ARGB_4444=Config.ARGB_4444;
	public Config bitmapCFG_ARGB_8888=Config.ARGB_8888;
	public Config bitmapCFG_ALPHA_8=Config.ALPHA_8;
	
	public void init(BA ba,String eventname) {
		EN=eventname.toLowerCase();
		mba=ba;
		ToolImage.initImageLoader(ba.context);
		ill=new ImageLoadingListener() {
			
			@Override
			public void onLoadingStarted(String arg0, View arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLoadingFailed(String arg0, View arg1, FailReason arg2) {
				// TODO Auto-generated method stub
				mba.raiseEventFromDifferentThread(this, this, 0, EN+"_onLoadingFailed".toLowerCase(), false, new Object[]{arg0,arg2.toString()});
			}
			
			@Override
			public void onLoadingComplete(String arg0, View arg1, Bitmap arg2) {
				// TODO Auto-generated method stub
				BitmapWrapper bw=new BitmapWrapper();
				bw.setObject(arg2);
				mba.raiseEventFromDifferentThread(this, this, 0, EN+"_onLoadingComplete".toLowerCase(), false, new Object[]{arg0,bw});
			}
			
			@Override
			public void onLoadingCancelled(String arg0, View arg1) {
				// TODO Auto-generated method stub
				
			}
		};
		ToolImage.getImageLoader().setDefaultLoadingListener(ill);
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
			.decodingOptions(getimgdecopt())
			.bitmapConfig(bitmapCFG_def)
			.delayBeforeLoading(delayBeforeLoading)
			.resetViewBeforeLoading(resetViewBeforeLoading);
		if(nLoadResId!=null){
			dio.showImageOnLoading(nLoadResId);
		}
		if(nFailResId!=null){
			dio.showImageOnFail(nFailResId);
		}
		if (ViewBGTransparent) {
			iv.setBackgroundColor(0);
		}
		ToolImage.getImageLoader().displayImage(uri, iv,dio.build());
	}
    private BitmapFactory.Options getimgdecopt(){
        BitmapFactory.Options opt = new BitmapFactory.Options();
//        opt.inPreferredConfig = Bitmap.Config.ARGB_8888;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        return opt;
    }
	public void ShowCircleImage(ImageView iv,String uri,int strokeColor,int strokeWidth) {
		if (defScaleType!=null) {
			iv.setScaleType(defScaleType);
		}
		DisplayImageOptions.Builder dio=new DisplayImageOptions.Builder()
			.cacheOnDisk(diskcache)
			.cacheInMemory(memcache)
			.decodingOptions(getimgdecopt())
			.bitmapConfig(bitmapCFG_def)
			.delayBeforeLoading(delayBeforeLoading)
			.resetViewBeforeLoading(resetViewBeforeLoading);
		if(nLoadResId!=null){
			dio.showImageOnLoading(nLoadResId);
		}
		if(nFailResId!=null){
			dio.showImageOnFail(nFailResId);
		}
		if (ViewBGTransparent) {
			iv.setBackgroundColor(0);
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
				.decodingOptions(getimgdecopt())
				.bitmapConfig(bitmapCFG_def)
				.delayBeforeLoading(delayBeforeLoading)
				.resetViewBeforeLoading(resetViewBeforeLoading);
		if(nLoadResId!=null){
			dio.showImageOnLoading(nLoadResId);
		}
		if(nFailResId!=null){
			dio.showImageOnFail(nFailResId);
		}
		if (ViewBGTransparent) {
			iv.setBackgroundColor(0);
		}
		dio.displayer(new RoundedBitmapDisplayer(cornerRadiusPixels,marginPixels));
		ToolImage.getImageLoader().displayImage(uri, iv,dio.build());
	}
	public void DownloadPic(String url) {
		ToolImage.getImageLoader().loadImage(url,ill);
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
