package b4a.AutoScaleExample7;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class setup extends Activity implements B4AActivity{
	public static setup mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.AutoScaleExample7", "b4a.AutoScaleExample7.setup");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (setup).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, true))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.AutoScaleExample7", "b4a.AutoScaleExample7.setup");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.AutoScaleExample7.setup", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (setup) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (setup) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return setup.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (setup) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (setup) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlsetupgps = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlgpspathunits = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlmapdefaultlocation = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlgpssetup = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlmapsetup = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlmapline = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlmapmarkers = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlsetup = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxmapdraggable = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxdispmaptypecontrol = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxdispmapzoomcontrol = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxdispmapscalecontrol = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxdispmapcentermarker = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxdispmapmarkers = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxdispmappolyline = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxmapmarkersclickable = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxmapmarkersdragable = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxshowgpsonmap = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxdrawgpspath = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxsavegpspath = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxgpsdispspeed = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxgpsdispbearing = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _cbxgpsdispwindrose = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtmapdefaultlocationlng = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtmapdefaultlocationlat = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtgpsmintime = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtgpsmindistance = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spnmapzoomlevel = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spnmaplinewidth = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spnmaplinecolor = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spnmaplineopacity = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spnmaptypecontrolid = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spnmapzoomcontroltype = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spnaltitudeunit = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spnspeedunit = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spndistanceunit = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scvsetup = null;
public b4a.AutoScaleExample7.main _main = null;
public b4a.AutoScaleExample7.about _about = null;
public b4a.AutoScaleExample7.scale _scale = null;
public b4a.AutoScaleExample7.dbwebview _dbwebview = null;
public b4a.AutoScaleExample7.dbutils _dbutils = null;
public b4a.AutoScaleExample7.dbscrollview _dbscrollview = null;
public b4a.AutoScaleExample7.keyboard _keyboard = null;
public b4a.AutoScaleExample7.listview _listview = null;
public b4a.AutoScaleExample7.calculator _calculator = null;
public b4a.AutoScaleExample7.calculator1 _calculator1 = null;
public b4a.AutoScaleExample7.positioning _positioning = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
int _left = 0;
int _width = 0;
int _width1 = 0;
int _space = 0;
 //BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 31;BA.debugLine="Dim Left, Width, Width1, Space As Int";
_left = 0;
_width = 0;
_width1 = 0;
_space = 0;
 //BA.debugLineNum = 33;BA.debugLine="Scale.SetRate(0.5)";
mostCurrent._scale._setrate(mostCurrent.activityBA,0.5);
 //BA.debugLineNum = 35;BA.debugLine="Width = 312dip * Scale.GetScaleX";
_width = (int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (312))*mostCurrent._scale._getscalex(mostCurrent.activityBA));
 //BA.debugLineNum = 36;BA.debugLine="Width1 = 320dip * Scale.GetScaleX";
_width1 = (int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (320))*mostCurrent._scale._getscalex(mostCurrent.activityBA));
 //BA.debugLineNum = 37;BA.debugLine="Space = 4dip * Scale.GetScaleX";
_space = (int) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))*mostCurrent._scale._getscalex(mostCurrent.activityBA));
 //BA.debugLineNum = 39;BA.debugLine="scvSetup.Initialize(0)";
mostCurrent._scvsetup.Initialize(mostCurrent.activityBA,(int) (0));
 //BA.debugLineNum = 40;BA.debugLine="Activity.AddView(scvSetup, (100%x - Width1) / 2,";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._scvsetup.getObject()),(int) ((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-_width1)/(double)2),(int) (0),_width1,anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 41;BA.debugLine="scvSetup.Color = Colors.RGB(255, 205, 250)";
mostCurrent._scvsetup.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (255),(int) (205),(int) (250)));
 //BA.debugLineNum = 42;BA.debugLine="scvSetup.Panel.LoadLayout(\"setup\")";
mostCurrent._scvsetup.getPanel().LoadLayout("setup",mostCurrent.activityBA);
 //BA.debugLineNum = 44;BA.debugLine="Scale.ScaleAll(Activity, True)";
mostCurrent._scale._scaleall(mostCurrent.activityBA,(anywheresoftware.b4a.objects.PanelWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.PanelWrapper(), (android.view.ViewGroup)(mostCurrent._activity.getObject())),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 46;BA.debugLine="scvSetup.Height = 100%y";
mostCurrent._scvsetup.setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 47;BA.debugLine="If 100%x < 2 * Width + 3 * Space Then";
if (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)<2*_width+3*_space) { 
 //BA.debugLineNum = 49;BA.debugLine="scvSetup.Width = Width1";
mostCurrent._scvsetup.setWidth(_width1);
 //BA.debugLineNum = 50;BA.debugLine="scvSetup.Left = 50%x - Width1 / 2";
mostCurrent._scvsetup.setLeft((int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA)-_width1/(double)2));
 //BA.debugLineNum = 51;BA.debugLine="pnlSetup.Width = scvSetup.Width";
mostCurrent._pnlsetup.setWidth(mostCurrent._scvsetup.getWidth());
 //BA.debugLineNum = 52;BA.debugLine="scvSetup.Panel.Width = pnlSetup.Width";
mostCurrent._scvsetup.getPanel().setWidth(mostCurrent._pnlsetup.getWidth());
 //BA.debugLineNum = 53;BA.debugLine="pnlSetup.Height = pnlMapMarkers.Top + pnlMapMark";
mostCurrent._pnlsetup.setHeight((int) (mostCurrent._pnlmapmarkers.getTop()+mostCurrent._pnlmapmarkers.getHeight()+_space));
 //BA.debugLineNum = 54;BA.debugLine="scvSetup.Panel.Height = pnlSetup.Height";
mostCurrent._scvsetup.getPanel().setHeight(mostCurrent._pnlsetup.getHeight());
 //BA.debugLineNum = 55;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
 }else {
 //BA.debugLineNum = 58;BA.debugLine="Left = Width + 2 * Space";
_left = (int) (_width+2*_space);
 //BA.debugLineNum = 60;BA.debugLine="scvSetup.Width = 2 * Width + 3 * Space";
mostCurrent._scvsetup.setWidth((int) (2*_width+3*_space));
 //BA.debugLineNum = 61;BA.debugLine="scvSetup.Panel.Width = scvSetup.Width";
mostCurrent._scvsetup.getPanel().setWidth(mostCurrent._scvsetup.getWidth());
 //BA.debugLineNum = 62;BA.debugLine="pnlSetup.Width = scvSetup.Width";
mostCurrent._pnlsetup.setWidth(mostCurrent._scvsetup.getWidth());
 //BA.debugLineNum = 63;BA.debugLine="scvSetup.Left = 50%x - scvSetup.Width / 2";
mostCurrent._scvsetup.setLeft((int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA)-mostCurrent._scvsetup.getWidth()/(double)2));
 //BA.debugLineNum = 65;BA.debugLine="pnlMapSetup.Top = Space";
mostCurrent._pnlmapsetup.setTop(_space);
 //BA.debugLineNum = 66;BA.debugLine="pnlMapSetup.Left = Left";
mostCurrent._pnlmapsetup.setLeft(_left);
 //BA.debugLineNum = 68;BA.debugLine="pnlMapLine.Top = pnlMapSetup.Top + pnlMapSetup.H";
mostCurrent._pnlmapline.setTop((int) (mostCurrent._pnlmapsetup.getTop()+mostCurrent._pnlmapsetup.getHeight()+_space));
 //BA.debugLineNum = 69;BA.debugLine="pnlMapLine.Left = Left";
mostCurrent._pnlmapline.setLeft(_left);
 //BA.debugLineNum = 71;BA.debugLine="pnlMapMarkers.Top = pnlMapLine.Top + pnlMapLine.";
mostCurrent._pnlmapmarkers.setTop((int) (mostCurrent._pnlmapline.getTop()+mostCurrent._pnlmapline.getHeight()+_space));
 //BA.debugLineNum = 72;BA.debugLine="pnlMapMarkers.Left = Left";
mostCurrent._pnlmapmarkers.setLeft(_left);
 //BA.debugLineNum = 73;BA.debugLine="scvSetup.Panel.Height = pnlGPSSetup.Top + pnlGPS";
mostCurrent._scvsetup.getPanel().setHeight((int) (mostCurrent._pnlgpssetup.getTop()+mostCurrent._pnlgpssetup.getHeight()+_space));
 };
 //BA.debugLineNum = 75;BA.debugLine="FillSpinners";
_fillspinners();
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public static String  _fillspinners() throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="Sub FillSpinners";
 //BA.debugLineNum = 87;BA.debugLine="spnMapZoomLevel.Add(\"15\")";
mostCurrent._spnmapzoomlevel.Add("15");
 //BA.debugLineNum = 88;BA.debugLine="spnMapLineWidth.Add(\"5\")";
mostCurrent._spnmaplinewidth.Add("5");
 //BA.debugLineNum = 89;BA.debugLine="spnMapLineColor.Add(\"Red\")";
mostCurrent._spnmaplinecolor.Add("Red");
 //BA.debugLineNum = 90;BA.debugLine="spnMapLineOpacity.Add(\"1\")";
mostCurrent._spnmaplineopacity.Add("1");
 //BA.debugLineNum = 91;BA.debugLine="spnMapTypeControlID.Add(\"MAP\")";
mostCurrent._spnmaptypecontrolid.Add("MAP");
 //BA.debugLineNum = 92;BA.debugLine="spnMapZoomControlType.Add(\"15\")";
mostCurrent._spnmapzoomcontroltype.Add("15");
 //BA.debugLineNum = 93;BA.debugLine="spnAltitudeUnit.Add(\"m\")";
mostCurrent._spnaltitudeunit.Add("m");
 //BA.debugLineNum = 94;BA.debugLine="spnSpeedUnit.Add(\"km/h\")";
mostCurrent._spnspeedunit.Add("km/h");
 //BA.debugLineNum = 95;BA.debugLine="spnDistanceUnit.Add(\"km\")";
mostCurrent._spndistanceunit.Add("km");
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim pnlSetupGPS, pnlGPSPathUnits, pnlMapDefaultLo";
mostCurrent._pnlsetupgps = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._pnlgpspathunits = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._pnlmapdefaultlocation = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._pnlgpssetup = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._pnlmapsetup = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._pnlmapline = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._pnlmapmarkers = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Dim pnlSetup As Panel";
mostCurrent._pnlsetup = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Dim cbxMapDraggable, cbxDispMapTypeControl, cbxDi";
mostCurrent._cbxmapdraggable = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
mostCurrent._cbxdispmaptypecontrol = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
mostCurrent._cbxdispmapzoomcontrol = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
mostCurrent._cbxdispmapscalecontrol = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Dim cbxDispMapCenterMarker, cbxDispMapMarkers, cb";
mostCurrent._cbxdispmapcentermarker = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
mostCurrent._cbxdispmapmarkers = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
mostCurrent._cbxdispmappolyline = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Dim cbxMapMarkersClickable, cbxMapMarkersDragable";
mostCurrent._cbxmapmarkersclickable = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
mostCurrent._cbxmapmarkersdragable = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
mostCurrent._cbxshowgpsonmap = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Dim cbxDrawGPSPath, cbxSaveGPSPath, cbxGPSDispSpe";
mostCurrent._cbxdrawgpspath = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
mostCurrent._cbxsavegpspath = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
mostCurrent._cbxgpsdispspeed = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
mostCurrent._cbxgpsdispbearing = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
mostCurrent._cbxgpsdispwindrose = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Dim edtMapDefaultLocationLng, edtMapDefaultLocati";
mostCurrent._edtmapdefaultlocationlng = new anywheresoftware.b4a.objects.EditTextWrapper();
mostCurrent._edtmapdefaultlocationlat = new anywheresoftware.b4a.objects.EditTextWrapper();
mostCurrent._edtgpsmintime = new anywheresoftware.b4a.objects.EditTextWrapper();
mostCurrent._edtgpsmindistance = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Dim spnMapZoomLevel, spnMapLineWidth, spnMapLineC";
mostCurrent._spnmapzoomlevel = new anywheresoftware.b4a.objects.SpinnerWrapper();
mostCurrent._spnmaplinewidth = new anywheresoftware.b4a.objects.SpinnerWrapper();
mostCurrent._spnmaplinecolor = new anywheresoftware.b4a.objects.SpinnerWrapper();
mostCurrent._spnmaplineopacity = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Dim spnMapTypeControlID, spnMapZoomControlType As";
mostCurrent._spnmaptypecontrolid = new anywheresoftware.b4a.objects.SpinnerWrapper();
mostCurrent._spnmapzoomcontroltype = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Dim spnAltitudeUnit, spnSpeedUnit, spnDistanceUni";
mostCurrent._spnaltitudeunit = new anywheresoftware.b4a.objects.SpinnerWrapper();
mostCurrent._spnspeedunit = new anywheresoftware.b4a.objects.SpinnerWrapper();
mostCurrent._spndistanceunit = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Dim scvSetup As ScrollView";
mostCurrent._scvsetup = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
