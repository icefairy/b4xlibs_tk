package com.zaiten;

import java.util.HashMap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.DynamicBuilder;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.ViewWrapper;
import anywheresoftware.b4a.objects.collections.Map;

@ActivityObject
@ShortName("ScrollViewEx")
@Events(values={"ScrollChanged(Position As Int)"})
@Author("icefairy333")
@Version(1.00f)
public class ScrollViewWrapper
  extends ViewWrapper<ScrollView> implements DesignerCustomView
{
	public static final String[] checkChild=new String[]{"AbsListView",};
	private String innerEventname="";
	private BA innerba;
  private PanelWrapper pw = new PanelWrapper();
  
  public void Initialize(BA ba, int Height)
  {
    Initialize2(ba, Height, "");
  }
  
  public void Initialize2(BA ba, int Height, String EventName)
  {
    super.Initialize(ba, EventName);
    PanelWrapper p = new PanelWrapper();
    p.Initialize(ba, "");
    ((ScrollView)getObject()).addView((View)p.getObject(), -1, Height);
  }
  
  @BA.Hide
  public void innerInitialize(BA ba, String EventName, boolean keepOldObject)
  {
    if (!keepOldObject) {
      setObject(new MyScrollView(ba.context){

		@Override
		public boolean onInterceptTouchEvent(MotionEvent ev) {
			// TODO Auto-generated method stub
			//Webview,scrollview,abslistview
			return false;
//			BA.Log("onInterceptTouchEvent:"+pw.getNumberOfViews());
//			for(int i=0;i<pw.getNumberOfViews();i++)
//			{
//				ConcreteViewWrapper view=pw.GetView(i);
//				BA.Log(view.getClass().toString());
//				return checkArea(view.getObject(), ev);
//			}
//			
//			return super.onInterceptTouchEvent(ev);
		}
    	  
      });
    }
    super.innerInitialize(ba, EventName, true);
    if ((ba.subExists(EventName + "_scrollchanged")) && 
      ((getObject() instanceof MyScrollView)))
    {
      MyScrollView m = (MyScrollView)getObject();
      m.ba = ba;
      m.eventName = EventName;
    }
  }
  
  public PanelWrapper getPanel()
  {
    this.pw.setObject((ViewGroup)((ScrollView)getObject()).getChildAt(0));
    return this.pw;
  }
  
  public void FullScroll(boolean Bottom)
  {
    ((ScrollView)getObject()).fullScroll(Bottom ? 130 : 33);
  }
  
  public int getScrollPosition()
  {
    return ((ScrollView)getObject()).getScrollY();
  }
  
  public void setScrollPosition(int Scroll)
  {
    ((ScrollView)getObject()).smoothScrollTo(0, Scroll);
  }
  
  public void ScrollToNow(int Scroll)
  {
    ((ScrollView)getObject()).scrollTo(0, Scroll);
  }
  
  @BA.Hide
  public static View build(Object prev, HashMap<String, Object> props, boolean designer, Object tag)
    throws Exception
  {
    if (prev == null) {
      prev = ViewWrapper.buildNativeView((Context)tag, MyScrollView.class, props, designer);
    }
    ScrollView v = (ScrollView)ViewWrapper.build(prev, props, designer);
    if (v.getChildCount() > 0) {
      v.removeAllViews();
    }
    HashMap<String, Object> drawProps = (HashMap)props.get("drawable");
    Drawable d = (Drawable)DynamicBuilder.build(prev, drawProps, designer, null);
    if (props.containsKey("innerHeight"))
    {
      BALayout b = new BALayout((Context)tag);
      v.addView(b, -1, (int)(BALayout.getDeviceScale() * ((Integer)props.get("innerHeight")).intValue()));
      
      b.setBackgroundDrawable(d);
    }
    else
    {
      v.setBackgroundDrawable(d);
    }
    return v;
  }
  
  @BA.Hide
  public static class MyScrollView
    extends ScrollView
  {
    public String eventName;
    public BA ba;
    
    public MyScrollView(Context context)
    {
      super(context);
    }
    


	protected void onScrollChanged(int l, int t, int oldl, int oldt)
    {
      super.onScrollChanged(l, t, oldl, oldt);
      if (this.ba != null) {
        this.ba.raiseEventFromUI(this, this.eventName + "_scrollchanged", new Object[] { Integer.valueOf(t) });
      }
    }
  }

	@Override
	public void DesignerCreateView(PanelWrapper arg0, LabelWrapper arg1, Map arg2) {
		// TODO Auto-generated method stub
		Initialize2(innerba, arg0.getHeight(), innerEventname);
		PanelWrapper vg=(PanelWrapper) arg0.getParent();
		vg.AddView(getObject(), arg0.getLeft(), arg0.getTop(), arg0.getWidth(), arg0.getHeight());
		arg0.RemoveView();
	}
	
	@Override
	public void _initialize(BA arg0, Object arg1, String arg2) {
		// TODO Auto-generated method stub
		innerEventname=arg2.toLowerCase();
		innerba=arg0;
	}
	private boolean checkArea(View v, MotionEvent event){  
        float x = event.getRawX();  
        float y = event.getRawY();  
        int[] locate = new int[2];  
        v.getLocationOnScreen(locate);  
        int l = locate[0];  
        int r = l + v.getWidth();  
        int t = locate[1];  
        int b = t + v.getHeight();  
        if (l < x && x < r && t < y && y < b) {  
            return true;  
        }  
        return false;  
    }  
}
