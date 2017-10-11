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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.AutoScaleExample7", "b4a.AutoScaleExample7.main");
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
		activityBA = new BA(this, layout, processBA, "b4a.AutoScaleExample7", "b4a.AutoScaleExample7.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.AutoScaleExample7.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
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
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static String _progname = "";
public static String _progversion = "";
public static String _progauthor = "";
public static String _progdate = "";
public static String _progcopyright = "";
public static String _progcountry = "";
public static String _progemail = "";
public static anywheresoftware.b4a.sql.SQL _sql1 = null;
public static String _dbfilename = "";
public static String _dbfiledir = "";
public static String _dbtablename = "";
public anywheresoftware.b4a.objects.ButtonWrapper _btndbscrollview = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btndbwebview = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnkeyboard = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsetup = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnabout = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnlistview = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncalculator = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncalculator1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnpositionning = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlmainbackground = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnltoolbox = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnltoolbox1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbltitle = null;
public b4a.AutoScaleExample7.setup _setup = null;
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

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (setup.mostCurrent != null);
vis = vis | (about.mostCurrent != null);
vis = vis | (dbwebview.mostCurrent != null);
vis = vis | (dbscrollview.mostCurrent != null);
vis = vis | (keyboard.mostCurrent != null);
vis = vis | (listview.mostCurrent != null);
vis = vis | (calculator.mostCurrent != null);
vis = vis | (calculator1.mostCurrent != null);
vis = vis | (positioning.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.phone.Phone _ph = null;
 //BA.debugLineNum = 38;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 40;BA.debugLine="Scale.SetRate(0.5)";
mostCurrent._scale._setrate(mostCurrent.activityBA,0.5);
 //BA.debugLineNum = 42;BA.debugLine="Dim ph As Phone";
_ph = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 43;BA.debugLine="If Scale.GetDevicePhysicalSize < 6 Then";
if (mostCurrent._scale._getdevicephysicalsize(mostCurrent.activityBA)<6) { 
 //BA.debugLineNum = 44;BA.debugLine="ph.SetScreenOrientation(1)";
_ph.SetScreenOrientation(processBA,(int) (1));
 }else {
 //BA.debugLineNum = 46;BA.debugLine="ph.SetScreenOrientation(-1)";
_ph.SetScreenOrientation(processBA,(int) (-1));
 };
 //BA.debugLineNum = 49;BA.debugLine="Activity.LoadLayout(\"Main\")";
mostCurrent._activity.LoadLayout("Main",mostCurrent.activityBA);
 //BA.debugLineNum = 51;BA.debugLine="Scale.ScaleView(lblTitle)";
mostCurrent._scale._scaleview(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbltitle.getObject())));
 //BA.debugLineNum = 52;BA.debugLine="Scale.HorizontalCenter(pnlToolBox)";
mostCurrent._scale._horizontalcenter(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._pnltoolbox.getObject())));
 //BA.debugLineNum = 53;BA.debugLine="Scale.HorizontalCenter(pnlToolBox1)";
mostCurrent._scale._horizontalcenter(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._pnltoolbox1.getObject())));
 //BA.debugLineNum = 54;BA.debugLine="Scale.ScaleView(pnlMainBackground)";
mostCurrent._scale._scaleview(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._pnlmainbackground.getObject())));
 //BA.debugLineNum = 55;BA.debugLine="Scale.HorizontalCenter(pnlMainBackground)";
mostCurrent._scale._horizontalcenter(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._pnlmainbackground.getObject())));
 //BA.debugLineNum = 57;BA.debugLine="pnlToolBox.Top = 100%y - pnlToolBox.Height";
mostCurrent._pnltoolbox.setTop((int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._pnltoolbox.getHeight()));
 //BA.debugLineNum = 59;BA.debugLine="If 100%x >= 8 * btnAbout.Width Then";
if (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)>=8*mostCurrent._btnabout.getWidth()) { 
 //BA.debugLineNum = 60;BA.debugLine="pnlToolBox.Left = 50%x - 4 * btnAbout.Width";
mostCurrent._pnltoolbox.setLeft((int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (50),mostCurrent.activityBA)-4*mostCurrent._btnabout.getWidth()));
 //BA.debugLineNum = 61;BA.debugLine="pnlToolBox1.Left = pnlToolBox.Left + pnlToolBox.";
mostCurrent._pnltoolbox1.setLeft((int) (mostCurrent._pnltoolbox.getLeft()+mostCurrent._pnltoolbox.getWidth()));
 //BA.debugLineNum = 62;BA.debugLine="pnlToolBox1.Top = pnlToolBox.Top";
mostCurrent._pnltoolbox1.setTop(mostCurrent._pnltoolbox.getTop());
 }else {
 //BA.debugLineNum = 64;BA.debugLine="pnlToolBox.Left = (100%x - pnlToolBox.Width) / 2";
mostCurrent._pnltoolbox.setLeft((int) ((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._pnltoolbox.getWidth())/(double)2));
 //BA.debugLineNum = 65;BA.debugLine="pnlToolBox1.Left = (100%x - pnlToolBox1.Width) /";
mostCurrent._pnltoolbox1.setLeft((int) ((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._pnltoolbox1.getWidth())/(double)2));
 //BA.debugLineNum = 66;BA.debugLine="pnlToolBox1.Top = pnlToolBox.Top - pnlToolBox1.H";
mostCurrent._pnltoolbox1.setTop((int) (mostCurrent._pnltoolbox.getTop()-mostCurrent._pnltoolbox1.getHeight()));
 };
 //BA.debugLineNum = 69;BA.debugLine="Scale.VerticalCenter2(pnlMainBackground, lblTitle";
mostCurrent._scale._verticalcenter2(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._pnlmainbackground.getObject())),(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._lbltitle.getObject())),(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._pnltoolbox1.getObject())));
 //BA.debugLineNum = 71;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 72;BA.debugLine="DBFileDir = DBUtils.CopyDBFromAssets(DBFileName)";
_dbfiledir = mostCurrent._dbutils._copydbfromassets(mostCurrent.activityBA,_dbfilename);
 };
 //BA.debugLineNum = 75;BA.debugLine="SQL1.Initialize(DBFileDir, DBFileName, True)";
_sql1.Initialize(_dbfiledir,_dbfilename,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 79;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public static String  _btnabout_click() throws Exception{
 //BA.debugLineNum = 103;BA.debugLine="Sub btnAbout_Click";
 //BA.debugLineNum = 104;BA.debugLine="StartActivity(\"About\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("About"));
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _btncalculator_click() throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Sub btnCalculator_Click";
 //BA.debugLineNum = 112;BA.debugLine="StartActivity(\"Calculator\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Calculator"));
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public static String  _btncalculator1_click() throws Exception{
 //BA.debugLineNum = 115;BA.debugLine="Sub btnCalculator1_Click";
 //BA.debugLineNum = 116;BA.debugLine="StartActivity(\"Calculator1\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Calculator1"));
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return "";
}
public static String  _btndbscrollview_click() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Sub btnDBScrollView_Click";
 //BA.debugLineNum = 88;BA.debugLine="StartActivity(\"DBScrollView\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("DBScrollView"));
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public static String  _btndbwebview_click() throws Exception{
 //BA.debugLineNum = 91;BA.debugLine="Sub btnDBWebView_Click";
 //BA.debugLineNum = 92;BA.debugLine="StartActivity(\"DBWebView\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("DBWebView"));
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public static String  _btnkeyboard_click() throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="Sub btnKeyboard_Click";
 //BA.debugLineNum = 96;BA.debugLine="StartActivity(\"Keyboard\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Keyboard"));
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return "";
}
public static String  _btnlistview_click() throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Sub btnListView_Click";
 //BA.debugLineNum = 108;BA.debugLine="StartActivity(\"ListView\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("ListView"));
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public static String  _btnpositionning_click() throws Exception{
 //BA.debugLineNum = 119;BA.debugLine="Sub btnPositionning_Click";
 //BA.debugLineNum = 120;BA.debugLine="StartActivity(\"Positioning\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Positioning"));
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public static String  _btnsetup_click() throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Sub btnSetup_Click";
 //BA.debugLineNum = 100;BA.debugLine="StartActivity(\"Setup\")";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)("Setup"));
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 32;BA.debugLine="Private btnDBScrollView, btnDBWebView, btnKeyboar";
mostCurrent._btndbscrollview = new anywheresoftware.b4a.objects.ButtonWrapper();
mostCurrent._btndbwebview = new anywheresoftware.b4a.objects.ButtonWrapper();
mostCurrent._btnkeyboard = new anywheresoftware.b4a.objects.ButtonWrapper();
mostCurrent._btnsetup = new anywheresoftware.b4a.objects.ButtonWrapper();
mostCurrent._btnabout = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private btnListView, btnCalculator, btnCalculator";
mostCurrent._btnlistview = new anywheresoftware.b4a.objects.ButtonWrapper();
mostCurrent._btncalculator = new anywheresoftware.b4a.objects.ButtonWrapper();
mostCurrent._btncalculator1 = new anywheresoftware.b4a.objects.ButtonWrapper();
mostCurrent._btnpositionning = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private pnlMainBackground, pnlToolBox, pnlToolBox";
mostCurrent._pnlmainbackground = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._pnltoolbox = new anywheresoftware.b4a.objects.PanelWrapper();
mostCurrent._pnltoolbox1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 35;BA.debugLine="Private lblTitle As Label";
mostCurrent._lbltitle = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
setup._process_globals();
about._process_globals();
scale._process_globals();
dbwebview._process_globals();
dbutils._process_globals();
dbscrollview._process_globals();
keyboard._process_globals();
listview._process_globals();
calculator._process_globals();
calculator1._process_globals();
positioning._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 17;BA.debugLine="Public ProgName = \"AutoScale Example 6\" As String";
_progname = "AutoScale Example 6";
 //BA.debugLineNum = 18;BA.debugLine="Public ProgVersion = \"2.1\" As String";
_progversion = "2.1";
 //BA.debugLineNum = 19;BA.debugLine="Public ProgAuthor = \"klaus\" As String";
_progauthor = "klaus";
 //BA.debugLineNum = 20;BA.debugLine="Public ProgDate = \"feb 2013\" As String";
_progdate = "feb 2013";
 //BA.debugLineNum = 21;BA.debugLine="Public ProgCopyright = \"©  2012, 2013 Anywhere So";
_progcopyright = "©  2012, 2013 Anywhere Software";
 //BA.debugLineNum = 22;BA.debugLine="Public ProgCountry = \"Switzerland\" As String";
_progcountry = "Switzerland";
 //BA.debugLineNum = 23;BA.debugLine="Public ProgEMail = \"e-mail address\" As String";
_progemail = "e-mail address";
 //BA.debugLineNum = 25;BA.debugLine="Public SQL1 As SQL";
_sql1 = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 26;BA.debugLine="Public DBFileName = \"persons.db\" As String";
_dbfilename = "persons.db";
 //BA.debugLineNum = 27;BA.debugLine="Public DBFileDir  = File.DirInternal As String";
_dbfiledir = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
 //BA.debugLineNum = 28;BA.debugLine="Public DBTableName = \"persons\" As String";
_dbtablename = "persons";
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
}
