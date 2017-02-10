package anywheresoftware.b4a.samples.httputils2;


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
			processBA = new BA(this.getApplicationContext(), null, null, "anywheresoftware.b4a.samples.httputils2", "anywheresoftware.b4a.samples.httputils2.main");
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
		activityBA = new BA(this, layout, processBA, "anywheresoftware.b4a.samples.httputils2", "anywheresoftware.b4a.samples.httputils2.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "anywheresoftware.b4a.samples.httputils2.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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
public static String _surldownload = "";
public static String _surlupload = "";
public anywheresoftware.b4a.objects.Timer _tmr = null;
public anywheresoftware.b4a.samples.httputils2.httpjob _job1 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edittext1 = null;
public anywheresoftware.b4a.objects.ListViewWrapper _cmd = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
 //BA.debugLineNum = 28;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"1\")";
mostCurrent._activity.LoadLayout("1",mostCurrent.activityBA);
 //BA.debugLineNum = 30;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 31;BA.debugLine="cd.Initialize(Colors.White,10dip)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.White,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
 //BA.debugLineNum = 32;BA.debugLine="cmd.SingleLineLayout.Background=cd";
mostCurrent._cmd.getSingleLineLayout().Background = (android.graphics.drawable.Drawable)(_cd.getObject());
 //BA.debugLineNum = 33;BA.debugLine="cmd.SingleLineLayout.Label.TextColor=Colors.Black";
mostCurrent._cmd.getSingleLineLayout().Label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 34;BA.debugLine="cmd.SingleLineLayout.Label.Gravity=Gravity.CENTER";
mostCurrent._cmd.getSingleLineLayout().Label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 35;BA.debugLine="cmd.AddSingleLine2(\"download\",\"down\")";
mostCurrent._cmd.AddSingleLine2("download",(Object)("down"));
 //BA.debugLineNum = 36;BA.debugLine="cmd.AddSingleLine2(\"cancelDownload\",\"cdown\")";
mostCurrent._cmd.AddSingleLine2("cancelDownload",(Object)("cdown"));
 //BA.debugLineNum = 37;BA.debugLine="cmd.AddSingleLine2(\"upload\",\"upload\")";
mostCurrent._cmd.AddSingleLine2("upload",(Object)("upload"));
 //BA.debugLineNum = 38;BA.debugLine="cmd.AddSingleLine2(\"upload2\",\"upload2\")";
mostCurrent._cmd.AddSingleLine2("upload2",(Object)("upload2"));
 //BA.debugLineNum = 39;BA.debugLine="cmd.AddSingleLine2(\"cancel Upload\",\"cupload\")";
mostCurrent._cmd.AddSingleLine2("cancel Upload",(Object)("cupload"));
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 137;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 133;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public static String  _btn_click() throws Exception{
 //BA.debugLineNum = 42;BA.debugLine="Sub btn_Click";
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public static String  _cmd_itemclick(int _position,Object _value) throws Exception{
 //BA.debugLineNum = 141;BA.debugLine="Sub cmd_ItemClick (Position As Int, Value As Objec";
 //BA.debugLineNum = 142;BA.debugLine="Select Value";
switch (BA.switchObjectToInt(_value,(Object)("down"),(Object)("cdown"),(Object)("upload"),(Object)("upload2"),(Object)("cupload"))) {
case 0: {
 //BA.debugLineNum = 144;BA.debugLine="job1=doDown(\"job1\",sUrlDownload)";
mostCurrent._job1 = _dodown("job1",mostCurrent._surldownload);
 break; }
case 1: {
 //BA.debugLineNum = 146;BA.debugLine="job1.cancelDownload";
mostCurrent._job1._canceldownload();
 break; }
case 2: {
 //BA.debugLineNum = 149;BA.debugLine="TL(\"upload\")";
_tl("upload");
 //BA.debugLineNum = 150;BA.debugLine="sUrlUpload=\"http://app.kaopuedu.com/down/t2.php";
mostCurrent._surlupload = "http://app.kaopuedu.com/down/t2.php";
 //BA.debugLineNum = 151;BA.debugLine="job1=doUpload(\"job3\",sUrlUpload,File.Combine(Fi";
mostCurrent._job1 = _doupload("job3",mostCurrent._surlupload,anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"test.bin"));
 break; }
case 3: {
 //BA.debugLineNum = 153;BA.debugLine="TL(\"upload2\")";
_tl("upload2");
 //BA.debugLineNum = 154;BA.debugLine="sUrlUpload=\"http://app.kaopuedu.com/down/t3.php";
mostCurrent._surlupload = "http://app.kaopuedu.com/down/t3.php";
 //BA.debugLineNum = 155;BA.debugLine="job1=doUpload2(\"job3\",sUrlUpload,File.Combine(F";
mostCurrent._job1 = _doupload2("job3",mostCurrent._surlupload,anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"test.bin"));
 break; }
case 4: {
 //BA.debugLineNum = 157;BA.debugLine="job1.cancelUpload";
mostCurrent._job1._cancelupload();
 break; }
}
;
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.samples.httputils2.httpjob  _dodown(String _job,String _url) throws Exception{
anywheresoftware.b4a.samples.httputils2.httpjob _hj = null;
 //BA.debugLineNum = 67;BA.debugLine="Sub doDown(job As String,url As String) As HttpJob";
 //BA.debugLineNum = 68;BA.debugLine="Dim hj As HttpJob";
_hj = new anywheresoftware.b4a.samples.httputils2.httpjob();
 //BA.debugLineNum = 69;BA.debugLine="hj.Initialize(job,Me)";
_hj._initialize(processBA,_job,main.getObject());
 //BA.debugLineNum = 70;BA.debugLine="hj.Download(url)";
_hj._download(_url);
 //BA.debugLineNum = 71;BA.debugLine="tmr.Initialize(\"tmr\",1000)";
mostCurrent._tmr.Initialize(processBA,"tmr",(long) (1000));
 //BA.debugLineNum = 72;BA.debugLine="tmr.Enabled=True";
mostCurrent._tmr.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 73;BA.debugLine="Return hj";
if (true) return _hj;
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.samples.httputils2.httpjob  _doupload(String _job,String _url,String _fn) throws Exception{
anywheresoftware.b4a.samples.httputils2.httpjob _hj = null;
 //BA.debugLineNum = 95;BA.debugLine="Sub doUpload(job As String,url As String,fn As Str";
 //BA.debugLineNum = 96;BA.debugLine="Dim hj As HttpJob";
_hj = new anywheresoftware.b4a.samples.httputils2.httpjob();
 //BA.debugLineNum = 97;BA.debugLine="hj.Initialize(job,Me)";
_hj._initialize(processBA,_job,main.getObject());
 //BA.debugLineNum = 98;BA.debugLine="hj.PostFile(url,\"\",fn)";
_hj._postfile(_url,"",_fn);
 //BA.debugLineNum = 100;BA.debugLine="hj.GetRequest.SetHeader(\"Cookie\",\"kaopu_cookienam";
_hj._getrequest().SetHeader("Cookie","kaopu_cookiename=f5cd41fbVZ09w1QC8h8sM8LYh0d8OJBZ57pgZVDF4Ru8Bk6j369liE9U3LDOkBmFMWu3vJaWDs53hlMu9CNuoHKF%2FWsgzIozmpvbOwbK%2F%2BFkGF7rXG0NSmI4;");
 //BA.debugLineNum = 101;BA.debugLine="tmr.Initialize(\"tmr\",1000)";
mostCurrent._tmr.Initialize(processBA,"tmr",(long) (1000));
 //BA.debugLineNum = 102;BA.debugLine="tmr.Enabled=True";
mostCurrent._tmr.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 103;BA.debugLine="Return hj";
if (true) return _hj;
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.samples.httputils2.httpjob  _doupload2(String _job,String _url,String _fn) throws Exception{
anywheresoftware.b4a.samples.httputils2.httpjob _hj = null;
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.samples.httputils2.httpjob._multipartfiledata _md = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 75;BA.debugLine="Sub doUpload2(job As String,url As String,fn As St";
 //BA.debugLineNum = 76;BA.debugLine="Dim hj As HttpJob";
_hj = new anywheresoftware.b4a.samples.httputils2.httpjob();
 //BA.debugLineNum = 77;BA.debugLine="hj.Initialize(job,Me)";
_hj._initialize(processBA,_job,main.getObject());
 //BA.debugLineNum = 78;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 79;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 80;BA.debugLine="Dim md As MultipartFileData";
_md = new anywheresoftware.b4a.samples.httputils2.httpjob._multipartfiledata();
 //BA.debugLineNum = 81;BA.debugLine="md.Initialize";
_md.Initialize();
 //BA.debugLineNum = 82;BA.debugLine="md.FileName=fn";
_md.FileName = _fn;
 //BA.debugLineNum = 83;BA.debugLine="md.Dir=\"\"";
_md.Dir = "";
 //BA.debugLineNum = 84;BA.debugLine="md.KeyName=\"upfile\"";
_md.KeyName = "upfile";
 //BA.debugLineNum = 85;BA.debugLine="lst.Add(md)";
_lst.Add((Object)(_md));
 //BA.debugLineNum = 86;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 87;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 88;BA.debugLine="hj.PostMultipart(url,m,lst)";
_hj._postmultipart(_url,_m,_lst);
 //BA.debugLineNum = 90;BA.debugLine="hj.GetRequest.SetHeader(\"Cookie\",\"kaopu_cookienam";
_hj._getrequest().SetHeader("Cookie","kaopu_cookiename=f5cd41fbVZ09w1QC8h8sM8LYh0d8OJBZ57pgZVDF4Ru8Bk6j369liE9U3LDOkBmFMWu3vJaWDs53hlMu9CNuoHKF%2FWsgzIozmpvbOwbK%2F%2BFkGF7rXG0NSmI4;");
 //BA.debugLineNum = 91;BA.debugLine="tmr.Initialize(\"tmr\",1000)";
mostCurrent._tmr.Initialize(processBA,"tmr",(long) (1000));
 //BA.debugLineNum = 92;BA.debugLine="tmr.Enabled=True";
mostCurrent._tmr.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 93;BA.debugLine="Return hj";
if (true) return _hj;
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return null;
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 19;BA.debugLine="Private sUrlDownload As String=\"http://kpjj.xjwan";
mostCurrent._surldownload = "http://kpjj.xjwanwei.com/down/kpjj.apk";
 //BA.debugLineNum = 20;BA.debugLine="Private sUrlUpload As String";
mostCurrent._surlupload = "";
 //BA.debugLineNum = 21;BA.debugLine="Private tmr As Timer";
mostCurrent._tmr = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 22;BA.debugLine="Private job1 As HttpJob";
mostCurrent._job1 = new anywheresoftware.b4a.samples.httputils2.httpjob();
 //BA.debugLineNum = 23;BA.debugLine="Private EditText1 As EditText";
mostCurrent._edittext1 = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private cmd As ListView";
mostCurrent._cmd = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _ots = null;
 //BA.debugLineNum = 109;BA.debugLine="Sub JobDone (job As HttpJob)";
 //BA.debugLineNum = 110;BA.debugLine="Log(\"JobName = \" & job.JobName & \", Success = \" &";
anywheresoftware.b4a.keywords.Common.Log("JobName = "+_job._jobname+", Success = "+BA.ObjectToString(_job._success));
 //BA.debugLineNum = 111;BA.debugLine="If job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 112;BA.debugLine="Select job.JobName.ToLowerCase";
switch (BA.switchObjectToInt(_job._jobname.toLowerCase(),"job1","job2","job3")) {
case 0: {
 //BA.debugLineNum = 114;BA.debugLine="Dim ots As OutputStream=File.OpenOutput(File.D";
_ots = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_ots = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirRootExternal(),"test.bin",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 115;BA.debugLine="File.Copy2(job.GetInputStream,ots)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(_job._getinputstream().getObject()),(java.io.OutputStream)(_ots.getObject()));
 //BA.debugLineNum = 116;BA.debugLine="ots.Flush";
_ots.Flush();
 //BA.debugLineNum = 117;BA.debugLine="ots.Close";
_ots.Close();
 //BA.debugLineNum = 118;BA.debugLine="TL(\"download complete\")";
_tl("download complete");
 break; }
case 1: 
case 2: {
 //BA.debugLineNum = 122;BA.debugLine="TL(\"upload complete：\"&job.GetString)";
_tl("upload complete："+_job._getstring());
 break; }
}
;
 }else if(_job._errormessage.indexOf("closed")>-1) { 
 //BA.debugLineNum = 125;BA.debugLine="TL(\"任务已取消1\") 'canceled";
_tl("任务已取消1");
 }else {
 //BA.debugLineNum = 127;BA.debugLine="Log(\"Error: \" & job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_job._errormessage);
 //BA.debugLineNum = 128;BA.debugLine="ToastMessageShow(\"Error: \" & job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Error: "+_job._errormessage,anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 130;BA.debugLine="job.Release";
_job._release();
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
httputils2service._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public static String  _tl(String _str) throws Exception{
 //BA.debugLineNum = 105;BA.debugLine="Sub TL(str As String)";
 //BA.debugLineNum = 106;BA.debugLine="Log(str)";
anywheresoftware.b4a.keywords.Common.Log(_str);
 //BA.debugLineNum = 107;BA.debugLine="ToastMessageShow(str,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(_str,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 108;BA.debugLine="End Sub";
return "";
}
public static String  _tmr_tick() throws Exception{
long _t = 0L;
long _c = 0L;
String _st = "";
 //BA.debugLineNum = 45;BA.debugLine="Sub tmr_Tick";
 //BA.debugLineNum = 46;BA.debugLine="Dim t As Long,c As Long";
_t = 0L;
_c = 0L;
 //BA.debugLineNum = 47;BA.debugLine="t=job1.GetTotalSize";
_t = mostCurrent._job1._gettotalsize();
 //BA.debugLineNum = 48;BA.debugLine="c=job1.GetCurrentCount";
_c = mostCurrent._job1._getcurrentcount();
 //BA.debugLineNum = 49;BA.debugLine="Log(c&\"/\"&t)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_c)+"/"+BA.NumberToString(_t));
 //BA.debugLineNum = 50;BA.debugLine="If t<0 Or c<0 Then";
if (_t<0 || _c<0) { 
 //BA.debugLineNum = 51;BA.debugLine="tmr.Enabled=False";
mostCurrent._tmr.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 52;BA.debugLine="TL(\"任务已完成\")";
_tl("任务已完成");
 //BA.debugLineNum = 53;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 55;BA.debugLine="Dim st As String=$\"$1.1{c/t*100}% $1.1{c/1024}kb/";
_st = (""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("1.1",(Object)(_c/(double)_t*100))+"% "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("1.1",(Object)(_c/(double)1024))+"kb/"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("1.1",(Object)(_t/(double)1024))+"kb"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(anywheresoftware.b4a.keywords.Common.CRLF))+"");
 //BA.debugLineNum = 56;BA.debugLine="Log(st)";
anywheresoftware.b4a.keywords.Common.Log(_st);
 //BA.debugLineNum = 57;BA.debugLine="EditText1.Text=st&EditText1.Text";
mostCurrent._edittext1.setText((Object)(_st+mostCurrent._edittext1.getText()));
 //BA.debugLineNum = 58;BA.debugLine="If t=c Then";
if (_t==_c) { 
 //BA.debugLineNum = 59;BA.debugLine="tmr.Enabled=False";
mostCurrent._tmr.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 60;BA.debugLine="TL(\"任务已完成\")";
_tl("任务已完成");
 //BA.debugLineNum = 61;BA.debugLine="Return";
if (true) return "";
 }else if(_t==-1) { 
 //BA.debugLineNum = 63;BA.debugLine="tmr.Enabled=False";
mostCurrent._tmr.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 64;BA.debugLine="TL(\"任务已取消2\")";
_tl("任务已取消2");
 };
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
}
