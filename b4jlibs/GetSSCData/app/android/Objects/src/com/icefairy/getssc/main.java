package com.icefairy.getssc;


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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "com.icefairy.getssc", "com.icefairy.getssc.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
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
		activityBA = new BA(this, layout, processBA, "com.icefairy.getssc", "com.icefairy.getssc.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.icefairy.getssc.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (main) Resume **");
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
public com.zaiten.QQMTA _qqmta = null;
public anywheresoftware.b4a.objects.WebViewWrapper _web = null;
public uk.co.martinpearman.b4a.webviewextras.WebViewExtras _wve = null;
public static String _surl = "";
public static boolean _bexit = false;
public anywheresoftware.b4a.objects.Timer _tmr = null;
public de.amberhome.strefresh.AHSwipeToRefresh _ahstr = null;
public anywheresoftware.b4a.objects.ProgressBarWrapper _pbar = null;
public com.icefairy.getssc.starter _starter = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 36;BA.debugLine="Activity.LoadLayout(\"main\")";
mostCurrent._activity.LoadLayout("main",mostCurrent.activityBA);
 //BA.debugLineNum = 37;BA.debugLine="web.RemoveView";
mostCurrent._web.RemoveView();
 //BA.debugLineNum = 38;BA.debugLine="ahstr.AddView(web)";
mostCurrent._ahstr.AddView((android.view.View)(mostCurrent._web.getObject()));
 //BA.debugLineNum = 39;BA.debugLine="wve.addWebChromeClient(web,\"web\")";
mostCurrent._wve.addWebChromeClient(mostCurrent.activityBA,(android.webkit.WebView)(mostCurrent._web.getObject()),"web");
 //BA.debugLineNum = 40;BA.debugLine="web.LoadUrl(geturl)";
mostCurrent._web.LoadUrl(_geturl());
 //BA.debugLineNum = 41;BA.debugLine="Activity.AddMenuItem(\"分享给朋友\",\"share\")";
mostCurrent._activity.AddMenuItem("分享给朋友","share");
 //BA.debugLineNum = 42;BA.debugLine="Activity.AddMenuItem(\"版本说明\",\"version\")";
mostCurrent._activity.AddMenuItem("版本说明","version");
 //BA.debugLineNum = 43;BA.debugLine="Activity.AddMenuItem(\"帮助信息\",\"help\")";
mostCurrent._activity.AddMenuItem("帮助信息","help");
 //BA.debugLineNum = 45;BA.debugLine="qqmta.Initialize(\"mta\")";
mostCurrent._qqmta.Initialize(processBA,"mta");
 //BA.debugLineNum = 46;BA.debugLine="qqmta.initNativeCrashReport(\"init so\")";
mostCurrent._qqmta.initNativeCrashReport("init so");
 //BA.debugLineNum = 47;BA.debugLine="qqmta.DebugEnable=False";
mostCurrent._qqmta.setDebugEnable(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 48;BA.debugLine="qqmta.trackCustomEvent(\"onCreate\")";
mostCurrent._qqmta.trackCustomEvent("onCreate");
 //BA.debugLineNum = 49;BA.debugLine="qqmta.AutoExceptionCaught=True";
mostCurrent._qqmta.setAutoExceptionCaught(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 50;BA.debugLine="qqmta.StatSendStrategy=qqmta.SR_APP_LAUNCH";
mostCurrent._qqmta.setStatSendStrategy(mostCurrent._qqmta.SR_APP_LAUNCH);
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 75;BA.debugLine="If KeyCode=KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 76;BA.debugLine="If bExit Then";
if (_bexit) { 
 //BA.debugLineNum = 77;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 }else {
 //BA.debugLineNum = 79;BA.debugLine="bExit=True";
_bexit = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 80;BA.debugLine="tmr.Initialize(\"tmr\",3000)";
mostCurrent._tmr.Initialize(processBA,"tmr",(long) (3000));
 //BA.debugLineNum = 81;BA.debugLine="tmr.Enabled=True";
mostCurrent._tmr.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 82;BA.debugLine="ToastMessageShow(\"再按一次返回键退出程序\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("再按一次返回键退出程序",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 83;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 };
 //BA.debugLineNum = 86;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 96;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 97;BA.debugLine="qqmta.onPause";
mostCurrent._qqmta.onPause();
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 92;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 93;BA.debugLine="qqmta.onResume";
mostCurrent._qqmta.onResume();
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public static String  _ahstr_refresh() throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="Sub ahstr_Refresh";
 //BA.debugLineNum = 101;BA.debugLine="web.LoadUrl(\"javascript:window.location.reload( t";
mostCurrent._web.LoadUrl("javascript:window.location.reload( true );");
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public static String  _geturl() throws Exception{
 //BA.debugLineNum = 57;BA.debugLine="Private Sub geturl As String";
 //BA.debugLineNum = 58;BA.debugLine="Return sUrl&\"&ver=\"&Application.VersionName&\"&app";
if (true) return mostCurrent._surl+"&ver="+anywheresoftware.b4a.keywords.Common.Application.getVersionName()+"&apptyp=android";
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 24;BA.debugLine="Private qqmta As QQMTA";
mostCurrent._qqmta = new com.zaiten.QQMTA();
 //BA.debugLineNum = 25;BA.debugLine="Private web As WebView";
mostCurrent._web = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private wve As WebViewExtras";
mostCurrent._wve = new uk.co.martinpearman.b4a.webviewextras.WebViewExtras();
 //BA.debugLineNum = 27;BA.debugLine="Private sUrl As String=\"http://www.dwhjb.com:888/";
mostCurrent._surl = "http://www.dwhjb.com:888/getsscdata?cmd=1&typ=html&num=50";
 //BA.debugLineNum = 28;BA.debugLine="Private bExit As Boolean=False";
_bexit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 29;BA.debugLine="Private tmr As Timer";
mostCurrent._tmr = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 30;BA.debugLine="Private ahstr As AHSwipeToRefresh";
mostCurrent._ahstr = new de.amberhome.strefresh.AHSwipeToRefresh();
 //BA.debugLineNum = 31;BA.debugLine="Private pbar As ProgressBar";
mostCurrent._pbar = new anywheresoftware.b4a.objects.ProgressBarWrapper();
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static String  _help_click() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Sub help_Click";
 //BA.debugLineNum = 61;BA.debugLine="Msgbox(\"如果偶尔因为网络原因没有自动刷新你可以自己下拉刷新\",\"使用帮助)\")";
anywheresoftware.b4a.keywords.Common.Msgbox("如果偶尔因为网络原因没有自动刷新你可以自己下拉刷新","使用帮助)",mostCurrent.activityBA);
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _share_click() throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _in = null;
 //BA.debugLineNum = 63;BA.debugLine="Sub share_Click";
 //BA.debugLineNum = 64;BA.debugLine="Dim in As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 65;BA.debugLine="in.Initialize(in.ACTION_SEND, \"\")";
_in.Initialize(_in.ACTION_SEND,"");
 //BA.debugLineNum = 66;BA.debugLine="in.PutExtra(\"android.intent.extra.TEXT\", \"最新数据App";
_in.PutExtra("android.intent.extra.TEXT",(Object)("最新数据App分享给你:https://www.3956cc.com/zxsj.apk"));
 //BA.debugLineNum = 67;BA.debugLine="in.SetType(\"text/plain\")";
_in.SetType("text/plain");
 //BA.debugLineNum = 68;BA.debugLine="in.WrapAsIntentChooser(\"分享给朋友\")";
_in.WrapAsIntentChooser("分享给朋友");
 //BA.debugLineNum = 69;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(_in.getObject()));
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _tmr_tick() throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="Sub tmr_Tick";
 //BA.debugLineNum = 89;BA.debugLine="tmr.Enabled=False";
mostCurrent._tmr.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 90;BA.debugLine="bExit=False";
_bexit = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _version_click() throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Sub version_Click";
 //BA.debugLineNum = 72;BA.debugLine="Msgbox(\"当期程序版本:\"&Application.VersionName&\" 开发者QQ:";
anywheresoftware.b4a.keywords.Common.Msgbox("当期程序版本:"+anywheresoftware.b4a.keywords.Common.Application.getVersionName()+" 开发者QQ:860668820欢迎提意见以及发红包^_^","版本信息",mostCurrent.activityBA);
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public static String  _web_progresschanged(int _newprogress) throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Sub web_ProgressChanged(NewProgress As Int)";
 //BA.debugLineNum = 54;BA.debugLine="pbar.Progress=NewProgress";
mostCurrent._pbar.setProgress(_newprogress);
 //BA.debugLineNum = 55;BA.debugLine="If NewProgress>90 Then ahstr.Refreshing=False";
if (_newprogress>90) { 
mostCurrent._ahstr.setRefreshing(anywheresoftware.b4a.keywords.Common.False);};
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
}
