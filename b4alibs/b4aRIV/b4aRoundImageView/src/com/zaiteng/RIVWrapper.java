package com.zaiteng;


import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.ViewWrapper;
import anywheresoftware.b4a.objects.collections.Map;

@ShortName("RIV")
@Version(1.20f)
@Author("Icefairy333")
@Events(values={"Click","LongClick As Boolean"})
public class RIVWrapper extends ViewWrapper<RoundImageView> implements DesignerCustomView {
	private String En;
	private BA mBa;
	private RoundImageView riv;
	public static final ImageView.ScaleType SCALETYPE_CENTER = ImageView.ScaleType.CENTER;
	public static final ImageView.ScaleType SCALETYPE_CENTER_CROP = ImageView.ScaleType.CENTER_CROP;
	public static final ImageView.ScaleType SCALETYPE_CENTER_INSIDE = ImageView.ScaleType.CENTER_INSIDE;
	public static final ImageView.ScaleType SCALETYPE_FIT_CENTER = ImageView.ScaleType.FIT_CENTER;
	public static final ImageView.ScaleType SCALETYPE_FIT_END = ImageView.ScaleType.FIT_END;
	public static final ImageView.ScaleType SCALETYPE_FIT_START = ImageView.ScaleType.FIT_START;
	public static final ImageView.ScaleType SCALETYPE_FIT_XY = ImageView.ScaleType.FIT_XY;
	public static final ImageView.ScaleType SCALETYPE_MATRIX = ImageView.ScaleType.MATRIX;
	@Override
	public void DesignerCreateView(PanelWrapper base, LabelWrapper lw, Map map) {
		// TODO Auto-generated method stub
		base.AddView(riv, 0,0,base.getWidth(),base.getHeight());
	}

	@Override
	public void _initialize(BA ba, Object activityClass, String eventname) {
		// TODO Auto-generated method stub
		En=eventname.toLowerCase();
		mBa=ba;
		riv=new RoundImageView(mBa.context);
		if(mBa.subExists(En+"_click")){
			riv.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					mBa.raiseEvent(this, En+"_click", new Object[]{});
				}
			});
		}
		if(mBa.subExists(En+"_longclick")){
			riv.setOnLongClickListener(new OnLongClickListener() {
				
				@Override
				public boolean onLongClick(View arg0) {
					// TODO Auto-generated method stub
					
					return (Boolean) mBa.raiseEvent(this, En+"_longclick", new Object[]{});
				}
			});
		}
		setObject(riv);
	}
	public View asView(){
		return riv;
	}
	public String getScaleType() {
		return riv.getScaleType().toString();
	}
	
	public void setScaleType(ScaleType scaleType) {
		riv.setScaleType(scaleType);
	}
	
	public void setImageBitmap(Bitmap bm) {
		riv.setImageBitmap(bm);
	}
	
	public Bitmap getCroppedRoundBitmap(Bitmap bmp, int radius) {
		return riv.getCroppedRoundBitmap(bmp, radius);
	}
	
	public int getBorderThickness() {
        return riv.mBorderThickness;
    }

  
    public void setBorderThickness(int borderThickness) {
        riv.mBorderThickness = borderThickness;
    }

  
    public int getBorderOutsideColor() {
        return riv.mBorderOutsideColor;
    }

 
    public void setBorderOutsideColor(int borderOutsideColor) {
        riv.mBorderOutsideColor = borderOutsideColor;
    }


    public int getBorderInsideColor() {
        return riv.mBorderInsideColor;
    }


    public void setBorderInsideColor(int borderInsideColor) {
        riv.mBorderInsideColor = borderInsideColor;
    }
}
