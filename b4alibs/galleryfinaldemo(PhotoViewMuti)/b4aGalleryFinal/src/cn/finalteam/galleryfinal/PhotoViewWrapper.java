package cn.finalteam.galleryfinal;

import android.R.string;
import android.graphics.Bitmap;
import android.support.v4.media.MediaBrowserCompat.MediaItem.Flags;
import android.widget.ImageView.ScaleType;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.ViewWrapper;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper;
import cn.finalteam.galleryfinal.widget.zoonview.PhotoView;

@ShortName("PhotoView")
public class PhotoViewWrapper extends ViewWrapper<PhotoView> implements DesignerCustomView {
	private PhotoView pv;
	@Override
	public void DesignerCreateView(PanelWrapper base, LabelWrapper lw, Map arg2) {
		// TODO Auto-generated method stub
		base.AddView(pv, 0, 0, base.getWidth(), base.getHeight());
	}

	@Override
	public void _initialize(BA ba, Object cb, String en) {
		// TODO Auto-generated method stub
		pv=new PhotoView(ba.context);
		setObject(pv);
	}
	public void setImageBitmap(Bitmap bm) {
		getObject().setImageBitmap(bm);
	}
	/**
	 * 预览URL图片
	 * @param url
	 * @param width
	 * @param height
	 */
	public void setUrlImageBitmap(String url,int width, int height) {
		UILImageLoader uli=new UILImageLoader();
		uli.loadSizedImg(url, getObject(), width, height);
	}
	public void setMinimumScale(float minimumScale){
		getObject().setMinimumScale(minimumScale);
	}
	public void setMaximumScale(float maximumScale){
		getObject().setMaximumScale(maximumScale);
	}
	public float getMinimumScale(){
		return getObject().getMinimumScale();
	}
	public float getMaximumScale(){
		return getObject().getMaximumScale();
	}
	public float getMediumScale(){
		return getObject().getMediumScale();
	}
	public void setMediumScale(float mediumScale){
		getObject().setMediumScale(mediumScale);
	}
	public boolean getcanZoom() {
		return getObject().canZoom();
	}
	public void setScale(float scale, boolean animate) {
		getObject().setScale(scale, animate);;
	}
	public float getScale(float scale, boolean animate) {
		return getObject().getScale();
	}
	public void setScaleType(ScaleType scaleType) {
		getObject().setScaleType(scaleType);
	}
	public ScaleType getScaleType() {
		return getObject().getScaleType();
	}
	public void setRotationBy(float rotationDegree) {
		getObject().setRotationBy(rotationDegree);
	}
	public void setRotationTo(float rotationDegree) {
		getObject().setRotationTo(rotationDegree);
	}
	public BitmapWrapper getVisibleRectangleBitmap() {
		BitmapWrapper bw=new BitmapWrapper();
		bw.setObject(getObject().getVisibleRectangleBitmap());
		return bw;
	}
}
