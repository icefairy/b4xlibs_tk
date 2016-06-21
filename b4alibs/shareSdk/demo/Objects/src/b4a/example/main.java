package b4a.example;


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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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
public cn.sharesdk.onekeyshare.OnekeyShare _oks1 = null;
public static String _s_website = "";
public static String _s_sharetext = "";
public b4a.example.starter _starter = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 32;BA.debugLine="Activity.LoadLayout(\"1\")";
mostCurrent._activity.LoadLayout("1",mostCurrent.activityBA);
 //BA.debugLineNum = 34;BA.debugLine="oks1.init(\"oks\",\"appkey\",getShareSdkCfgList,True)";
mostCurrent._oks1.init(mostCurrent.activityBA,"oks","appkey",_getsharesdkcfglist(),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 35;BA.debugLine="oks1.addHiddenPlatform(\"SinaWeibo\")'隐藏悄悄出来的微博";
mostCurrent._oks1.addHiddenPlatform("SinaWeibo");
 //BA.debugLineNum = 36;BA.debugLine="oks1.setCustomerLogo(LoadBitmap(File.DirAssets,\"i";
mostCurrent._oks1.setCustomerLogo((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"ico_copy.png").getObject()),"复制");
 //BA.debugLineNum = 37;BA.debugLine="oks1.Text=S_SHARETEXT";
mostCurrent._oks1.setText(mostCurrent._s_sharetext);
 //BA.debugLineNum = 38;BA.debugLine="oks1.Title=Application.LabelName";
mostCurrent._oks1.setTitle(anywheresoftware.b4a.keywords.Common.Application.getLabelName());
 //BA.debugLineNum = 39;BA.debugLine="oks1.TitleUrl=S_WEBSITE";
mostCurrent._oks1.setTitleUrl(mostCurrent._s_website);
 //BA.debugLineNum = 40;BA.debugLine="oks1.Url=S_WEBSITE";
mostCurrent._oks1.setUrl(mostCurrent._s_website);
 //BA.debugLineNum = 41;BA.debugLine="oks1.ImageUrl=S_WEBSITE&\"icon.png\"";
mostCurrent._oks1.setImageUrl(mostCurrent._s_website+"icon.png");
 //BA.debugLineNum = 42;BA.debugLine="oks1.ShareType=oks1.SHARE_WEBPAGE";
mostCurrent._oks1.setShareType(mostCurrent._oks1.SHARE_WEBPAGE);
 //BA.debugLineNum = 43;BA.debugLine="oks1.setDialogMode";
mostCurrent._oks1.setDialogMode();
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 108;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 110;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 104;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
 //BA.debugLineNum = 113;BA.debugLine="Sub Button1_Click";
 //BA.debugLineNum = 114;BA.debugLine="oks1.show";
mostCurrent._oks1.show();
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _getsharesdkcfglist() throws Exception{
anywheresoftware.b4a.objects.collections.List _lstsharesdkcfg = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 45;BA.debugLine="Public Sub getShareSdkCfgList As List";
 //BA.debugLineNum = 46;BA.debugLine="Dim lstShareSdkCfg As List";
_lstsharesdkcfg = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 47;BA.debugLine="lstShareSdkCfg.Initialize";
_lstsharesdkcfg.Initialize();
 //BA.debugLineNum = 48;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 49;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 50;BA.debugLine="m.Put(\"pname\",\"Wechat\")";
_m.Put((Object)("pname"),(Object)("Wechat"));
 //BA.debugLineNum = 51;BA.debugLine="m.Put(\"Id\",\"1\")";
_m.Put((Object)("Id"),(Object)("1"));
 //BA.debugLineNum = 52;BA.debugLine="m.Put(\"SortId\",1)";
_m.Put((Object)("SortId"),(Object)(1));
 //BA.debugLineNum = 53;BA.debugLine="m.Put(\"AppId\",\"id\")'这里填写你自己申请的key和id ，下同";
_m.Put((Object)("AppId"),(Object)("id"));
 //BA.debugLineNum = 54;BA.debugLine="m.Put(\"AppSecret\",\"sec\")";
_m.Put((Object)("AppSecret"),(Object)("sec"));
 //BA.debugLineNum = 55;BA.debugLine="m.Put(\"BypassApproval\",\"false\")";
_m.Put((Object)("BypassApproval"),(Object)("false"));
 //BA.debugLineNum = 56;BA.debugLine="m.Put(\"Enable\",\"true\")";
_m.Put((Object)("Enable"),(Object)("true"));
 //BA.debugLineNum = 57;BA.debugLine="lstShareSdkCfg.Add(m)";
_lstsharesdkcfg.Add((Object)(_m.getObject()));
 //BA.debugLineNum = 58;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 59;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 60;BA.debugLine="m.Put(\"pname\",\"WechatMoments\")";
_m.Put((Object)("pname"),(Object)("WechatMoments"));
 //BA.debugLineNum = 61;BA.debugLine="m.Put(\"Id\",\"2\")";
_m.Put((Object)("Id"),(Object)("2"));
 //BA.debugLineNum = 62;BA.debugLine="m.Put(\"SortId\",2)";
_m.Put((Object)("SortId"),(Object)(2));
 //BA.debugLineNum = 63;BA.debugLine="m.Put(\"AppId\",\"id\")";
_m.Put((Object)("AppId"),(Object)("id"));
 //BA.debugLineNum = 64;BA.debugLine="m.Put(\"AppSecret\",\"sec\")";
_m.Put((Object)("AppSecret"),(Object)("sec"));
 //BA.debugLineNum = 65;BA.debugLine="m.Put(\"BypassApproval\",\"false\")";
_m.Put((Object)("BypassApproval"),(Object)("false"));
 //BA.debugLineNum = 66;BA.debugLine="m.Put(\"Enable\",\"true\")";
_m.Put((Object)("Enable"),(Object)("true"));
 //BA.debugLineNum = 67;BA.debugLine="lstShareSdkCfg.Add(m)";
_lstsharesdkcfg.Add((Object)(_m.getObject()));
 //BA.debugLineNum = 68;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 69;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 70;BA.debugLine="m.Put(\"pname\",\"WechatFavorite\")";
_m.Put((Object)("pname"),(Object)("WechatFavorite"));
 //BA.debugLineNum = 71;BA.debugLine="m.Put(\"Id\",\"3\")";
_m.Put((Object)("Id"),(Object)("3"));
 //BA.debugLineNum = 72;BA.debugLine="m.Put(\"SortId\",3)";
_m.Put((Object)("SortId"),(Object)(3));
 //BA.debugLineNum = 73;BA.debugLine="m.Put(\"AppId\",\"id\")";
_m.Put((Object)("AppId"),(Object)("id"));
 //BA.debugLineNum = 74;BA.debugLine="m.Put(\"AppSecret\",\"sec\")";
_m.Put((Object)("AppSecret"),(Object)("sec"));
 //BA.debugLineNum = 75;BA.debugLine="m.Put(\"Enable\",\"true\")";
_m.Put((Object)("Enable"),(Object)("true"));
 //BA.debugLineNum = 76;BA.debugLine="lstShareSdkCfg.Add(m)";
_lstsharesdkcfg.Add((Object)(_m.getObject()));
 //BA.debugLineNum = 77;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 78;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 79;BA.debugLine="m.Put(\"pname\",\"QQ\")";
_m.Put((Object)("pname"),(Object)("QQ"));
 //BA.debugLineNum = 80;BA.debugLine="m.Put(\"Id\",\"4\")";
_m.Put((Object)("Id"),(Object)("4"));
 //BA.debugLineNum = 81;BA.debugLine="m.Put(\"SortId\",4)";
_m.Put((Object)("SortId"),(Object)(4));
 //BA.debugLineNum = 82;BA.debugLine="m.Put(\"AppId\",\"id\")";
_m.Put((Object)("AppId"),(Object)("id"));
 //BA.debugLineNum = 83;BA.debugLine="m.Put(\"AppKey\",\"key\")";
_m.Put((Object)("AppKey"),(Object)("key"));
 //BA.debugLineNum = 84;BA.debugLine="m.Put(\"ShareByAppClient\",\"true\")";
_m.Put((Object)("ShareByAppClient"),(Object)("true"));
 //BA.debugLineNum = 85;BA.debugLine="m.Put(\"Enable\",\"true\")";
_m.Put((Object)("Enable"),(Object)("true"));
 //BA.debugLineNum = 86;BA.debugLine="lstShareSdkCfg.Add(m)";
_lstsharesdkcfg.Add((Object)(_m.getObject()));
 //BA.debugLineNum = 87;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 88;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 89;BA.debugLine="m.Put(\"pname\",\"ShortMessage\")";
_m.Put((Object)("pname"),(Object)("ShortMessage"));
 //BA.debugLineNum = 90;BA.debugLine="m.Put(\"Id\",\"5\")";
_m.Put((Object)("Id"),(Object)("5"));
 //BA.debugLineNum = 91;BA.debugLine="m.Put(\"SortId\",5)";
_m.Put((Object)("SortId"),(Object)(5));
 //BA.debugLineNum = 92;BA.debugLine="m.Put(\"Enable\",\"true\")";
_m.Put((Object)("Enable"),(Object)("true"));
 //BA.debugLineNum = 93;BA.debugLine="lstShareSdkCfg.Add(m)";
_lstsharesdkcfg.Add((Object)(_m.getObject()));
 //BA.debugLineNum = 94;BA.debugLine="Return lstShareSdkCfg";
if (true) return _lstsharesdkcfg;
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return null;
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="Private oks1 As OKS";
mostCurrent._oks1 = new cn.sharesdk.onekeyshare.OnekeyShare();
 //BA.debugLineNum = 26;BA.debugLine="Private S_WEBSITE As String=\"https://b4xlibs.tk/\"";
mostCurrent._s_website = "https://b4xlibs.tk/";
 //BA.debugLineNum = 27;BA.debugLine="Private S_SHARETEXT As String=\"哈哈哈哈https://b4xlib";
mostCurrent._s_sharetext = "哈哈哈哈https://b4xlibs.tk/";
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public static String  _oks_logoclick(String _title) throws Exception{
b4a.util.BClipboard _clip = null;
 //BA.debugLineNum = 96;BA.debugLine="Sub oks_logoclick(title As String)";
 //BA.debugLineNum = 97;BA.debugLine="Select title.ToLowerCase";
switch (BA.switchObjectToInt(_title.toLowerCase(),"复制")) {
case 0: {
 //BA.debugLineNum = 99;BA.debugLine="Dim clip As BClipboard";
_clip = new b4a.util.BClipboard();
 //BA.debugLineNum = 100;BA.debugLine="clip.setText(S_SHARETEXT)";
_clip.setText(mostCurrent.activityBA,mostCurrent._s_sharetext);
 //BA.debugLineNum = 101;BA.debugLine="ToastMessageShow(\"已复制\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("已复制",anywheresoftware.b4a.keywords.Common.False);
 break; }
}
;
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
}
