package com.zxdemo;


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

public class actzxscanner extends Activity implements B4AActivity{
	public static actzxscanner mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new BA(this.getApplicationContext(), null, null, "com.zxdemo", "com.zxdemo.actzxscanner");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (actzxscanner).");
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
		activityBA = new BA(this, layout, processBA, "com.zxdemo", "com.zxdemo.actzxscanner");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.zxdemo.actzxscanner", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (actzxscanner) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (actzxscanner) Resume **");
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
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return actzxscanner.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
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
        BA.LogInfo("** Activity (actzxscanner) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (actzxscanner) Resume **");
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
        Object[] o;
        if (permissions.length > 0)
            o = new Object[] {permissions[0], grantResults[0] == 0};
        else
            o = new Object[] {"", false};
        processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public com.zxdemo.cvcrzxing _pnlbarcode = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imglight = null;
public flm.b4a.animationplus.AnimationPlusWrapper _ap = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlfocus = null;
public com.zxdemo.main _main = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 23;BA.debugLine="Activity.LoadLayout(\"layscanner\")";
mostCurrent._activity.LoadLayout("layscanner",mostCurrent.activityBA);
 //BA.debugLineNum = 24;BA.debugLine="PnlBarCode.bScanOnce=False '设置只扫描一次";
mostCurrent._pnlbarcode._bscanonce = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 25;BA.debugLine="ap.InitializeTranslate(\"ap\",0,0,0,PnlFocus.Height";
mostCurrent._ap.InitializeTranslate(mostCurrent.activityBA,"ap",(float) (0),(float) (0),(float) (0),(float) (mostCurrent._pnlfocus.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))));
 //BA.debugLineNum = 26;BA.debugLine="ap.Duration=1500";
mostCurrent._ap.setDuration((long) (1500));
 //BA.debugLineNum = 27;BA.debugLine="ap.PersistAfter=True";
mostCurrent._ap.setPersistAfter(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 28;BA.debugLine="ap.StartOffset=0";
mostCurrent._ap.setStartOffset((long) (0));
 //BA.debugLineNum = 29;BA.debugLine="ap.RepeatMode=ap.REPEAT_REVERSE";
mostCurrent._ap.setRepeatMode(mostCurrent._ap.REPEAT_REVERSE);
 //BA.debugLineNum = 30;BA.debugLine="ap.RepeatCount=9999";
mostCurrent._ap.setRepeatCount((int) (9999));
 //BA.debugLineNum = 31;BA.debugLine="ap.Start(ImgLight)";
mostCurrent._ap.Start((android.view.View)(mostCurrent._imglight.getObject()));
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 34;BA.debugLine="If KeyCode==KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 35;BA.debugLine="stopscanner";
_stopscanner();
 };
 //BA.debugLineNum = 37;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 48;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 49;BA.debugLine="stopscanner";
_stopscanner();
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 40;BA.debugLine="PnlBarCode.startPreView";
mostCurrent._pnlbarcode._startpreview();
 //BA.debugLineNum = 41;BA.debugLine="ap.Start(ImgLight)";
mostCurrent._ap.Start((android.view.View)(mostCurrent._imglight.getObject()));
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private PnlBarCode As cvCRZxing";
mostCurrent._pnlbarcode = new com.zxdemo.cvcrzxing();
 //BA.debugLineNum = 16;BA.debugLine="Private ImgLight As ImageView";
mostCurrent._imglight = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private ap As AnimationPlus";
mostCurrent._ap = new flm.b4a.animationplus.AnimationPlusWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private PnlFocus As Panel";
mostCurrent._pnlfocus = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _pnlbarcode_oncamerror(String _errmsg) throws Exception{
 //BA.debugLineNum = 57;BA.debugLine="Sub PnlBarCode_onCamError (errMsg As String)";
 //BA.debugLineNum = 58;BA.debugLine="tl(\"Error:\"&errMsg)";
_tl("Error:"+_errmsg);
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public static String  _pnlbarcode_onzxdecresult(String _result) throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Sub PnlBarCode_onZxDecResult (result As String)";
 //BA.debugLineNum = 63;BA.debugLine="stopscanner";
_stopscanner();
 //BA.debugLineNum = 64;BA.debugLine="CallSubDelayed2(Main,\"gotzxresult\",result)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._main.getObject()),"gotzxresult",(Object)(_result));
 //BA.debugLineNum = 65;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _stopscanner() throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Sub stopscanner";
 //BA.debugLineNum = 44;BA.debugLine="PnlBarCode.stopPreView";
mostCurrent._pnlbarcode._stoppreview();
 //BA.debugLineNum = 45;BA.debugLine="ap.Stop(ImgLight)";
mostCurrent._ap.Stop((android.view.View)(mostCurrent._imglight.getObject()));
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public static String  _tl(String _str) throws Exception{
 //BA.debugLineNum = 52;BA.debugLine="public Sub tl(str As String)";
 //BA.debugLineNum = 53;BA.debugLine="ToastMessageShow(str,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(_str,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 54;BA.debugLine="Log(str)";
anywheresoftware.b4a.keywords.Common.Log(_str);
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
}
