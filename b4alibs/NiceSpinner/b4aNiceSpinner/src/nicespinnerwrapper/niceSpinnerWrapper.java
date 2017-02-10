package nicespinnerwrapper;

import java.util.List;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.Pixel;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.TextViewWrapper;
import main.java.org.angmarch.views.NiceSpinner;

@Author("Johan Schoeman")
@Version(2.10f)
@ShortName("NiceSpinner")
@DependsOn(values={"android-support-v4"})
@Events(values={"item_clicked"})
public class niceSpinnerWrapper extends TextViewWrapper<NiceSpinner> implements DesignerCustomView {


	private BA ba;
	private String eventName;
        private NiceSpinner cv;
        @Hide
        public static int ddlTextColor;
	
	
	public void Initialize(BA ba, String EventName) {
		_initialize(ba, null, EventName);
	}

	@Hide
	public void _initialize(BA ba, Object activityClass, String EventName) {
		this.eventName = EventName.toLowerCase(BA.cul);
		this.ba = ba;
		cv = new NiceSpinner(ba.context, null);
                this.setObject(cv);
                addListener();
 	}




    @Hide
    public void addListener(){
        cv.setCallback(new NiceSpinner.Callback() {
//            @Override
            public void item_clicked() {

              if (ba.subExists(eventName + "_item_clicked")) {
                ba.raiseEvent2(ba, false, eventName + "_item_clicked", true, new Object[0]);
              }
            }

//            @Override
//            public void bottom_clicked() {
//
//              if (ba.subExists(eventName + "_bottom_clicked")) {
//                ba.raiseEvent2(ba, false, eventName + "_bottom_clicked", true, new Object[0]);
//              }
//            }

        });
    }


	
	//programmatically add view
        @Hide
	public void AddToParent(ViewGroup Parent, @Pixel int left, @Pixel int top, @Pixel int width, @Pixel int height) {
		Parent.addView(cv, new BALayout.LayoutParams(left, top, width, height));
	}
	
	//this method cannot be hidden.
  
        
	public void DesignerCreateView(PanelWrapper base, LabelWrapper lw, anywheresoftware.b4a.objects.collections.Map props) {
		ViewGroup vg = (ViewGroup) base.getObject().getParent();
		AddToParent(vg, base.getLeft(), base.getTop(), base.getWidth(), base.getHeight());
		base.RemoveView();
		//set text properties
	}



	public void setLeft(int left)	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)cv.getLayoutParams();
		lp.left = left;
		cv.getParent().requestLayout();
	}

	public int getLeft()	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)cv.getLayoutParams();
		return lp.left;
	}
	public void setTop(int top)	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)cv.getLayoutParams();
		lp.top = top;
		cv.getParent().requestLayout();
	}
 
	public int getTop()	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)cv.getLayoutParams();
		return lp.top;
	}
	
	public void setWidth(int Width)	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)cv.getLayoutParams();
		lp.width = Width;
		cv.getParent().requestLayout();
	}

	public int getWidth()	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)cv.getLayoutParams();
		return lp.width;
	}
	
	public void setHeight(int height)	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)cv.getLayoutParams();
		lp.height = height;
		cv.getParent().requestLayout();
	}

	public int getHeight()	{
		BALayout.LayoutParams lp = (BALayout.LayoutParams)cv.getLayoutParams();
		return lp.height;
	}

    public <T> void attachDataSource(@NonNull List<T> dataset) {
        cv.attachDataSource(dataset);
        cv.invalidate();
    }

//    public void setArrowColor(int color) {
//        cv.setTintColor(color);
//        cv.invalidate();
//    }

    public void setDividerColor(int[] divcolor){
        cv.setDividerColor(divcolor);
        cv.invalidate();
    }

    public void setDividerHeight(int height){
        cv.setDividerHeight(height);
        cv.invalidate();
    }

    public void setDropdownListBackgroundColor(int color){
        cv.setDropdownListBackgroundColor(color);                //this changes the background color of the dropdown list but not that of the selected item
        cv.invalidate();
    }

    public void setDropdownListTextColor(int color){
        ddlTextColor = color;                                   //this changes the background color of the dropdown list but not that of the selected item
        cv.setDropdownListTextColor(color);
        cv.invalidate();
    }
    public void setDropdownListTextSize(int size){
        cv.setDropdownListTextSize(size);
        cv.invalidate();
    }
    public void setTextSize(int size){
        cv.setTextSize(size);
        cv.invalidate();
    }
    public int getSelectedIndex() {
        return cv.getSelectedIndex();
    }

    /**
     * Get or Set the default spinner item using its index
     * 
     */
    public void setSelectedIndex(int position) {
       cv.setSelectedIndex(position);
       cv.invalidate();
    }

    public void dismissDropDown() {
        cv.dismissDropDown();
        cv.invalidate();
    }

    public void showDropDown() {
        cv.showDropDown();
        cv.invalidate();
    }

    public void setSelectedTextColor(int color){
        cv.setSelectedTextColor(color);
        cv.invalidate();            
    }

    public void setSelectedTextBackgroundColor(int color){
        cv.setSelectedTextBackgroundColor(color);
        cv.invalidate();            
    }


}
