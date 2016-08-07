package xyz.czhuan.fangniuwa;


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

public class actmain extends Activity implements B4AActivity{
	public static actmain mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "xyz.czhuan.fangniuwa", "xyz.czhuan.fangniuwa.actmain");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (actmain).");
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
		activityBA = new BA(this, layout, processBA, "xyz.czhuan.fangniuwa", "xyz.czhuan.fangniuwa.actmain");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "xyz.czhuan.fangniuwa.actmain", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (actmain) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (actmain) Resume **");
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
		return actmain.class;
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
        BA.LogInfo("** Activity (actmain) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (actmain) Resume **");
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
public anywheresoftware.b4a.objects.ListViewWrapper _lvcmd = null;
public static String _edtfn = "";
public anywheresoftware.b4a.objects.EditTextWrapper _edtcontent = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
public xyz.czhuan.fangniuwa.main _main = null;
public xyz.czhuan.fangniuwa.starter _starter = null;
public xyz.czhuan.fangniuwa.comm _comm = null;
public xyz.czhuan.fangniuwa.cowservice _cowservice = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 24;BA.debugLine="Activity.LoadLayout(\"laymain\")";
mostCurrent._activity.LoadLayout("laymain",mostCurrent.activityBA);
 //BA.debugLineNum = 25;BA.debugLine="Activity.Title=Application.LabelName";
mostCurrent._activity.setTitle((Object)(anywheresoftware.b4a.keywords.Common.Application.getLabelName()));
 //BA.debugLineNum = 26;BA.debugLine="sv.Panel.Height=100%y";
mostCurrent._sv.getPanel().setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 27;BA.debugLine="sv.Panel.LoadLayout(\"layedit\")";
mostCurrent._sv.getPanel().LoadLayout("layedit",mostCurrent.activityBA);
 //BA.debugLineNum = 28;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 29;BA.debugLine="jo=edtcontent";
_jo.setObject((java.lang.Object)(mostCurrent._edtcontent.getObject()));
 //BA.debugLineNum = 30;BA.debugLine="jo.RunMethod(\"setHorizontallyScrolling\",Array As";
_jo.RunMethod("setHorizontallyScrolling",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.True)});
 //BA.debugLineNum = 31;BA.debugLine="comm.SetPaddingCommon(edtcontent)";
mostCurrent._comm._setpaddingcommon(mostCurrent.activityBA,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(mostCurrent._edtcontent.getObject())));
 //BA.debugLineNum = 32;BA.debugLine="lvcmd.SingleLineLayout.Label.Gravity=Gravity.CENT";
mostCurrent._lvcmd.getSingleLineLayout().Label.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 33;BA.debugLine="If Starter.bCowExist=False Then";
if (mostCurrent._starter._bcowexist==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 34;BA.debugLine="If Starter.cpu.EqualsIgnoreCase(\"unknow\") Then";
if (mostCurrent._starter._cpu.equalsIgnoreCase("unknow")) { 
 //BA.debugLineNum = 35;BA.debugLine="Msgbox(\"您的设备处理器类型:\"&Starter.cpu&\"不被支持,无法使用本软件。\"";
anywheresoftware.b4a.keywords.Common.Msgbox("您的设备处理器类型:"+mostCurrent._starter._cpu+"不被支持,无法使用本软件。","不支持",mostCurrent.activityBA);
 //BA.debugLineNum = 36;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 37;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 //BA.debugLineNum = 38;BA.debugLine="Return";
if (true) return "";
 }else {
 //BA.debugLineNum = 40;BA.debugLine="If Msgbox2(\"现在要初始化吗？\",\"初始化\",\"是\",\"否\",\"\",Null)=Di";
if (anywheresoftware.b4a.keywords.Common.Msgbox2("现在要初始化吗？","初始化","是","否","",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 41;BA.debugLine="reinit";
_reinit();
 }else {
 //BA.debugLineNum = 43;BA.debugLine="Msgbox(\"不初始化无法使用\",\"退出\")";
anywheresoftware.b4a.keywords.Common.Msgbox("不初始化无法使用","退出",mostCurrent.activityBA);
 //BA.debugLineNum = 44;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 45;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 };
 };
 };
 //BA.debugLineNum = 50;BA.debugLine="additem(\"启动\",\"start\")";
_additem("启动","start");
 //BA.debugLineNum = 51;BA.debugLine="additem(\"停止\",\"stop\")";
_additem("停止","stop");
 //BA.debugLineNum = 52;BA.debugLine="additem(\"编辑核心配置\",\"core\")";
_additem("编辑核心配置","core");
 //BA.debugLineNum = 53;BA.debugLine="additem(\"编辑被拦截列表\",\"blocked\")";
_additem("编辑被拦截列表","blocked");
 //BA.debugLineNum = 54;BA.debugLine="additem(\"编辑直连列表\",\"direct\")";
_additem("编辑直连列表","direct");
 //BA.debugLineNum = 55;BA.debugLine="additem(\"重新初始化\",\"reinit\")";
_additem("重新初始化","reinit");
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="Sub activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 103;BA.debugLine="If KeyCode==KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 104;BA.debugLine="If sv.Visible Then";
if (mostCurrent._sv.getVisible()) { 
 //BA.debugLineNum = 105;BA.debugLine="sv.Visible=False";
mostCurrent._sv.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 106;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 };
 //BA.debugLineNum = 109;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 110;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 68;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _additem(String _title,String _val) throws Exception{
 //BA.debugLineNum = 57;BA.debugLine="Sub additem(title As String,val As String)";
 //BA.debugLineNum = 58;BA.debugLine="lvcmd.AddSingleLine2(title,val)";
mostCurrent._lvcmd.AddSingleLine2(_title,(Object)(_val));
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public static String  _btnclose_click() throws Exception{
 //BA.debugLineNum = 126;BA.debugLine="Sub btnclose_Click";
 //BA.debugLineNum = 127;BA.debugLine="sv.Visible=False";
mostCurrent._sv.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return "";
}
public static String  _btnreset_click() throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Sub btnreset_Click";
 //BA.debugLineNum = 112;BA.debugLine="If File.Exists(\"\",Starter.cfgPath.Replace(\"core.t";
if (anywheresoftware.b4a.keywords.Common.File.Exists("",mostCurrent._starter._cfgpath.replace("core.txt",mostCurrent._edtfn+".txt"))) { 
 //BA.debugLineNum = 113;BA.debugLine="edtcontent.Text=File.ReadString(\"\",Starter.cfgPa";
mostCurrent._edtcontent.setText((Object)(anywheresoftware.b4a.keywords.Common.File.ReadString("",mostCurrent._starter._cfgpath.replace("core.txt",mostCurrent._edtfn+".txt"))));
 }else {
 //BA.debugLineNum = 115;BA.debugLine="edtcontent.Text=File.ReadString(File.DirAssets,e";
mostCurrent._edtcontent.setText((Object)(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._edtfn+".txt")));
 };
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return "";
}
public static String  _btnsave_click() throws Exception{
 //BA.debugLineNum = 120;BA.debugLine="Sub btnsave_Click";
 //BA.debugLineNum = 121;BA.debugLine="File.WriteString(\"\",Starter.cfgPath.Replace(\"core";
anywheresoftware.b4a.keywords.Common.File.WriteString("",mostCurrent._starter._cfgpath.replace("core.txt",mostCurrent._edtfn+".txt"),mostCurrent._edtcontent.getText().trim());
 //BA.debugLineNum = 122;BA.debugLine="comm.TL(\"保存成功\")";
mostCurrent._comm._tl(mostCurrent.activityBA,"保存成功");
 //BA.debugLineNum = 123;BA.debugLine="sv.Visible=False";
mostCurrent._sv.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private lvcmd As ListView";
mostCurrent._lvcmd = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private edtFn As String";
mostCurrent._edtfn = "";
 //BA.debugLineNum = 18;BA.debugLine="Private edtcontent As EditText";
mostCurrent._edtcontent = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private sv As ScrollView";
mostCurrent._sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public static String  _initok() throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Sub initok";
 //BA.debugLineNum = 65;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 66;BA.debugLine="comm.TL(\"初始化成功\")";
mostCurrent._comm._tl(mostCurrent.activityBA,"初始化成功");
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _lvcmd_itemclick(int _position,Object _value) throws Exception{
String _cmd = "";
 //BA.debugLineNum = 77;BA.debugLine="Sub lvcmd_ItemClick (Position As Int, Value As Obj";
 //BA.debugLineNum = 78;BA.debugLine="Dim cmd As String=Value";
_cmd = BA.ObjectToString(_value);
 //BA.debugLineNum = 79;BA.debugLine="edtFn=cmd.ToLowerCase";
mostCurrent._edtfn = _cmd.toLowerCase();
 //BA.debugLineNum = 80;BA.debugLine="Select cmd.ToLowerCase";
switch (BA.switchObjectToInt(_cmd.toLowerCase(),"start","stop","reinit")) {
case 0: {
 //BA.debugLineNum = 82;BA.debugLine="StartService(cowservice)";
anywheresoftware.b4a.keywords.Common.StartService(mostCurrent.activityBA,(Object)(mostCurrent._cowservice.getObject()));
 //BA.debugLineNum = 83;BA.debugLine="comm.TL(\"已启动\")";
mostCurrent._comm._tl(mostCurrent.activityBA,"已启动");
 break; }
case 1: {
 //BA.debugLineNum = 85;BA.debugLine="CallSubDelayed(cowservice,\"stopcow\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(mostCurrent.activityBA,(Object)(mostCurrent._cowservice.getObject()),"stopcow");
 //BA.debugLineNum = 86;BA.debugLine="comm.TL(\"已停止\")";
mostCurrent._comm._tl(mostCurrent.activityBA,"已停止");
 break; }
case 2: {
 //BA.debugLineNum = 88;BA.debugLine="reinit";
_reinit();
 break; }
default: {
 //BA.debugLineNum = 90;BA.debugLine="showeditor";
_showeditor();
 break; }
}
;
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _reinit() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Sub reinit";
 //BA.debugLineNum = 61;BA.debugLine="ProgressDialogShow2(\"正在初始化请稍后\",False)";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,"正在初始化请稍后",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 62;BA.debugLine="CallSubDelayed(Starter,\"initenv\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"initenv");
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public static String  _showeditor() throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Sub showeditor";
 //BA.debugLineNum = 94;BA.debugLine="sv.Visible=True";
mostCurrent._sv.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 95;BA.debugLine="sv.BringToFront";
mostCurrent._sv.BringToFront();
 //BA.debugLineNum = 96;BA.debugLine="If File.Exists(\"\",Starter.cfgPath.Replace(\"core.t";
if (anywheresoftware.b4a.keywords.Common.File.Exists("",mostCurrent._starter._cfgpath.replace("core.txt",mostCurrent._edtfn+".txt"))) { 
 //BA.debugLineNum = 97;BA.debugLine="edtcontent.Text=File.ReadString(\"\",Starter.cfgPa";
mostCurrent._edtcontent.setText((Object)(anywheresoftware.b4a.keywords.Common.File.ReadString("",mostCurrent._starter._cfgpath.replace("core.txt",mostCurrent._edtfn+".txt"))));
 }else {
 //BA.debugLineNum = 99;BA.debugLine="edtcontent.Text=File.ReadString(File.DirAssets,e";
mostCurrent._edtcontent.setText((Object)(anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),mostCurrent._edtfn+".txt")));
 };
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
}
