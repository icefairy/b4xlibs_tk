package com.luweichen.b4agif;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.ant.liao.GifView;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.ViewWrapper;
import anywheresoftware.b4a.objects.collections.Map;


@ShortName("b4agif")
@Version(1.0f)
@Author("luweichen")
@Events(values={"Click","LongClick As Boolean"})
public class b4agifwrapper extends ViewWrapper<GifView> implements DesignerCustomView {
	@Hide
	private String En;
	protected InputStream inStream;
	@Hide
	public static BA mBa;
	private GifView gif;
//	public static final ImageView.ScaleType SCALETYPE_CENTER = ImageView.ScaleType.CENTER;
//	public static final ImageView.ScaleType SCALETYPE_CENTER_CROP = ImageView.ScaleType.CENTER_CROP;
//	public static final ImageView.ScaleType SCALETYPE_CENTER_INSIDE = ImageView.ScaleType.CENTER_INSIDE;
//	public static final ImageView.ScaleType SCALETYPE_FIT_CENTER = ImageView.ScaleType.FIT_CENTER;
//	public static final ImageView.ScaleType SCALETYPE_FIT_END = ImageView.ScaleType.FIT_END;
//	public static final ImageView.ScaleType SCALETYPE_FIT_START = ImageView.ScaleType.FIT_START;
//	public static final ImageView.ScaleType SCALETYPE_FIT_XY = ImageView.ScaleType.FIT_XY;
//	public static final ImageView.ScaleType SCALETYPE_MATRIX = ImageView.ScaleType.MATRIX;

	@Override
	public void DesignerCreateView(PanelWrapper base, LabelWrapper lw,Map map) {
		// TODO Auto-generated method stub
		base.AddView(gif,0,0,base.getWidth(),base.getHeight());
		
	}
	
	public void Initialize(BA ba, String EventName) {
		_initialize(ba, null, EventName);
	}

	
	@Hide
	public void _initialize(BA ba, Object activityClass, String EventName) {
		// TODO Auto-generated method stub
		En=EventName.toLowerCase();
		mBa=ba;
		gif=new GifView(mBa.context);
		if(mBa.subExists(En+"_click")){
			gif.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					mBa.raiseEvent(this, En+"_click", new Object[]{});
				}
			});
		}
		if(mBa.subExists(En+"_longclick")){
			gif.setOnLongClickListener(new OnLongClickListener() {
				
				@Override
				public boolean onLongClick(View arg0) {
					// TODO Auto-generated method stub
					
					return (Boolean) mBa.raiseEvent(this, En+"_longclick", new Object[]{});
				}
			});
		}
		setObject(gif);
	}
	/**
	 * 加载图片
	 * @param dir
	 * @param gifname
	 */
	public void Load(String dir, String gifname){
		InputStream is = null;
	    if (dir == "AssetsDir") {
	    	try {
	    		BA.Log("图片："+dir+gifname);
	    		is = BA.applicationContext.getAssets().open(gifname.toLowerCase(BA.cul));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } else {
		    try {
				is = new BufferedInputStream(new FileInputStream(new File(dir, gifname)), 4096);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    BA.Log("内容："+is);
	    if(is != null ){
	    	gif.setGifImage(is);
	    }
	    
	}
	/**
	 * 以流方式加载
	 * @param is gif InputStream
	 */
	public void LoadStream(InputStream is) {
		BA.Log("内容："+is);
	    if(is != null ){
	    	gif.setGifImage(is);
	    }
	}
	/**
	 * 只显示第一张
	 * @return
	 */
	public void showfirst(){
		gif.showCover();
	}
	
	/**
     * 继续显示动画<br>
     * 本方法在调用showCover后，会让动画继续显示，如果没有调用showCover方法，则没有任何效果
     */
	public void showAnimation() {
		gif.showAnimation();
	}
	/**
     * 设置要显示的图片的大小<br>
     * 当设置了图片大小 之后，会按照设置的大小来显示gif（按设置后的大小来进行拉伸或压缩）
     * @param width 要显示的图片宽
     * @param height 要显示的图片高
     */
	public void setShowDimension(int width,int height){
		gif.setShowDimension(width, height);
	}
	/**
	 * gif解码观察者
	 * @param parseStatus 解码是否成功，成功会为true
	 * @param frameIndex 当前解码的第几帧，当全部解码成功后，这里为-1
	 */
	public void parseOk(boolean parseStatus,int frameIndex) {
		gif.parseOk(parseStatus,frameIndex);
	}
	/**
	 * Returns the number of frames in the last GIF loaded.
	 * @return
	 */
	public int getframeCount() {
		return gif.getframeCount();
	}
	/**
	 * 返回对象
	 * @return
	 */
	public View asView(){
		return gif;
	}

}
