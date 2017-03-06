package b4a.example.giftest;


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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example.giftest", "b4a.example.giftest.main");
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
		activityBA = new BA(this, layout, processBA, "b4a.example.giftest", "b4a.example.giftest.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.giftest.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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
        Object[] o;
        if (permissions.length > 0)
            o = new Object[] {permissions[0], grantResults[0] == 0};
        else
            o = new Object[] {"", false};
        processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.Timer _timer1 = null;
public static int _frame = 0;
public anywheresoftware.b4a.agraham.gifdecoder.GifDecoder _gif = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnload = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview2 = null;
public flm.b4a.animationplus.AnimationDrawable _animatedandroid = null;
public com.luweichen.b4agif.b4agifwrapper _b4agif1 = null;
public com.luweichen.b4agif.b4agifwrapper _b4agif2 = null;
public b4a.example.giftest.starter _starter = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 39;BA.debugLine="Activity.LoadLayout(\"giftest\")";
mostCurrent._activity.LoadLayout("giftest",mostCurrent.activityBA);
 //BA.debugLineNum = 41;BA.debugLine="b4agif1.setShowDimension(60dip,60dip)";
mostCurrent._b4agif1.setShowDimension(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)));
 //BA.debugLineNum = 43;BA.debugLine="b4agif1.LoadStream(File.OpenInput(File.DirAssets,";
mostCurrent._b4agif1.LoadStream((java.io.InputStream)(anywheresoftware.b4a.keywords.Common.File.OpenInput(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"7.gif").getObject()));
 //BA.debugLineNum = 48;BA.debugLine="b4agif2.Initialize(\"\")";
mostCurrent._b4agif2.Initialize(processBA,"");
 //BA.debugLineNum = 49;BA.debugLine="b4agif2.LoadStream(File.OpenInput(File.DirAssets,";
mostCurrent._b4agif2.LoadStream((java.io.InputStream)(anywheresoftware.b4a.keywords.Common.File.OpenInput(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"clonesheep.gif").getObject()));
 //BA.debugLineNum = 50;BA.debugLine="Activity.AddView(b4agif2,60%x,73%y,100dip,100dip)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._b4agif2.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (60),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (73),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100)));
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 59;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public static String  _btnload_click() throws Exception{
int _i = 0;
 //BA.debugLineNum = 62;BA.debugLine="Sub btnLoad_Click";
 //BA.debugLineNum = 66;BA.debugLine="AnimatedAndroid.Initialize";
mostCurrent._animatedandroid.Initialize();
 //BA.debugLineNum = 67;BA.debugLine="AnimatedAndroid.OneShot = False";
mostCurrent._animatedandroid.setOneShot(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 69;BA.debugLine="gif.DisposeFrames";
mostCurrent._gif.DisposeFrames();
 //BA.debugLineNum = 70;BA.debugLine="gif.Load(File.DirAssets, \"7.gif\")";
mostCurrent._gif.Load(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"7.gif");
 //BA.debugLineNum = 71;BA.debugLine="ToastMessageShow(gif.FrameCount & \" frames\", True";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.NumberToString(mostCurrent._gif.getFrameCount())+" frames",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 72;BA.debugLine="Frame = 0";
_frame = (int) (0);
 //BA.debugLineNum = 74;BA.debugLine="Timer1.Interval = gif.Delay(Frame)";
_timer1.setInterval((long) (mostCurrent._gif.Delay(_frame)));
 //BA.debugLineNum = 75;BA.debugLine="ImageView1.Bitmap = gif.Frame(Frame)";
mostCurrent._imageview1.setBitmap(mostCurrent._gif.Frame(_frame));
 //BA.debugLineNum = 76;BA.debugLine="ImageView1.Gravity = Gravity.FILL";
mostCurrent._imageview1.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
 //BA.debugLineNum = 77;BA.debugLine="Timer1.Enabled = True";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 79;BA.debugLine="Log(File.DirRootExternal)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal());
 //BA.debugLineNum = 80;BA.debugLine="For i=0 To gif.FrameCount-1";
{
final int step12 = 1;
final int limit12 = (int) (mostCurrent._gif.getFrameCount()-1);
for (_i = (int) (0) ; (step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12); _i = ((int)(0 + _i + step12)) ) {
 //BA.debugLineNum = 81;BA.debugLine="gif.SaveFrame(i, File.DirRootExternal, \"测试gif动画\"";
mostCurrent._gif.SaveFrame(_i,anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"测试gif动画"+BA.NumberToString(_i)+".jpg","j",(int) (85));
 //BA.debugLineNum = 82;BA.debugLine="AnimatedAndroid.AddFrame(LoadBitmap(File.DirRoot";
mostCurrent._animatedandroid.AddFrame((Object)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"测试gif动画"+BA.NumberToString(_i)+".jpg").getObject()),(int) (50));
 //BA.debugLineNum = 83;BA.debugLine="Log(i)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_i));
 }
};
 //BA.debugLineNum = 86;BA.debugLine="ImageView2.Gravity = Gravity.NO_GRAVITY";
mostCurrent._imageview2.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.NO_GRAVITY);
 //BA.debugLineNum = 87;BA.debugLine="ImageView2.Background = AnimatedAndroid";
mostCurrent._imageview2.setBackground((android.graphics.drawable.Drawable)(mostCurrent._animatedandroid.getObject()));
 //BA.debugLineNum = 89;BA.debugLine="AnimatedAndroid.Start";
mostCurrent._animatedandroid.Start();
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 27;BA.debugLine="Private gif As GifDecoder";
mostCurrent._gif = new anywheresoftware.b4a.agraham.gifdecoder.GifDecoder();
 //BA.debugLineNum = 29;BA.debugLine="Dim btnLoad As Button";
mostCurrent._btnload = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Dim ImageView1 As ImageView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Dim ImageView2 As ImageView";
mostCurrent._imageview2 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Dim AnimatedAndroid As AnimationDrawable";
mostCurrent._animatedandroid = new flm.b4a.animationplus.AnimationDrawable();
 //BA.debugLineNum = 34;BA.debugLine="Private b4agif1,b4agif2 As b4agif";
mostCurrent._b4agif1 = new com.luweichen.b4agif.b4agifwrapper();
mostCurrent._b4agif2 = new com.luweichen.b4agif.b4agifwrapper();
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 19;BA.debugLine="Dim Timer1 As Timer";
_timer1 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 20;BA.debugLine="Timer1.Initialize(\"Timer1\",0)";
_timer1.Initialize(processBA,"Timer1",(long) (0));
 //BA.debugLineNum = 21;BA.debugLine="Dim Frame As Int";
_frame = 0;
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _timer1_tick() throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Sub Timer1_Tick";
 //BA.debugLineNum = 99;BA.debugLine="Timer1.Enabled = False";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 100;BA.debugLine="Frame = Frame + 1";
_frame = (int) (_frame+1);
 //BA.debugLineNum = 101;BA.debugLine="If Frame >= gif.FrameCount Then";
if (_frame>=mostCurrent._gif.getFrameCount()) { 
 //BA.debugLineNum = 102;BA.debugLine="Frame = 0";
_frame = (int) (0);
 };
 //BA.debugLineNum = 104;BA.debugLine="Timer1.Interval = gif.Delay(Frame)";
_timer1.setInterval((long) (mostCurrent._gif.Delay(_frame)));
 //BA.debugLineNum = 105;BA.debugLine="ImageView1.Bitmap = gif.Frame(Frame)";
mostCurrent._imageview1.setBitmap(mostCurrent._gif.Frame(_frame));
 //BA.debugLineNum = 106;BA.debugLine="Timer1.Enabled = True";
_timer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
}
