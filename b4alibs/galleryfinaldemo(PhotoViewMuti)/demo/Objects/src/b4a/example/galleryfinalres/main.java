package b4a.example.galleryfinalres;


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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example.galleryfinalres", "b4a.example.galleryfinalres.main");
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
		activityBA = new BA(this, layout, processBA, "b4a.example.galleryfinalres", "b4a.example.galleryfinalres.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.galleryfinalres.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
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
public cn.finalteam.galleryfinal.gfWrapper _gf = null;
public de.donmanfred.uilOptions _dispopt = null;
public de.donmanfred.UniversalImageLoader _uil = null;
public anywheresoftware.b4a.objects.ButtonWrapper _button2 = null;
public cn.finalteam.galleryfinal.FCWrapper _gffc = null;
public static String[] _simgurl = null;
public b4a.example.galleryfinalres.starter _starter = null;
public b4a.example.galleryfinalres.photoviewsingle _photoviewsingle = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (photoviewsingle.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 35;BA.debugLine="dispopt.Initialize";
mostCurrent._dispopt.Initialize(processBA);
 //BA.debugLineNum = 36;BA.debugLine="dispopt.cacheInMemory(False).cacheOnDisc(False).r";
mostCurrent._dispopt.cacheInMemory(anywheresoftware.b4a.keywords.Common.False).cacheOnDisc(anywheresoftware.b4a.keywords.Common.False).resetViewBeforeLoading(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 37;BA.debugLine="uil.Initialize(\"uil\",dispopt.build)";
mostCurrent._uil.Initialize(processBA,"uil",mostCurrent._dispopt.build());
 //BA.debugLineNum = 38;BA.debugLine="Activity.LoadLayout(\"1\")";
mostCurrent._activity.LoadLayout("1",mostCurrent.activityBA);
 //BA.debugLineNum = 42;BA.debugLine="simgurl(1) = \"http://ottmag.com/wp-content/upload";
mostCurrent._simgurl[(int) (1)] = "http://ottmag.com/wp-content/uploads/2016/04/First-date-ideas-0-341x220.jpg";
 //BA.debugLineNum = 43;BA.debugLine="simgurl(2) = \"http://ottmag.com/wp-content/upload";
mostCurrent._simgurl[(int) (2)] = "http://ottmag.com/wp-content/uploads/2016/09/Women-Empowerment-Quotes-300x194.jpg";
 //BA.debugLineNum = 44;BA.debugLine="simgurl(3) = \"http://ottmag.com/wp-content/upload";
mostCurrent._simgurl[(int) (3)] = "http://ottmag.com/wp-content/uploads/2016/07/wedding-hairstyles-15-300x194.jpg";
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public static String  _button1_click() throws Exception{
 //BA.debugLineNum = 116;BA.debugLine="Sub Button1_Click";
 //BA.debugLineNum = 117;BA.debugLine="showPicker(3)";
_showpicker((int) (3));
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return "";
}
public static String  _button2_click() throws Exception{
 //BA.debugLineNum = 120;BA.debugLine="Sub Button2_Click";
 //BA.debugLineNum = 121;BA.debugLine="showPicker(5)";
_showpicker((int) (5));
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public static String  _button3_click() throws Exception{
 //BA.debugLineNum = 124;BA.debugLine="Sub Button3_Click";
 //BA.debugLineNum = 125;BA.debugLine="StartActivity(PhotoViewSingle)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._photoviewsingle.getObject()));
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static String  _gf_onhanlderfailure(int _requestcode,String _errormsg) throws Exception{
 //BA.debugLineNum = 91;BA.debugLine="Sub gf_onHanlderFailure(requestCode As Int,errorMs";
 //BA.debugLineNum = 92;BA.debugLine="ToastMessageShow(\"SelectPicErr:\"&errorMsg,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("SelectPicErr:"+_errormsg,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public static String  _gf_onhanldersuccess(int _reqeustcode,anywheresoftware.b4a.objects.collections.List _resultlist) throws Exception{
int _i = 0;
cn.finalteam.galleryfinal.model.PhotoInfo _tp = null;
 //BA.debugLineNum = 94;BA.debugLine="Sub gf_onHanlderSuccess(reqeustCode As Int,resultL";
 //BA.debugLineNum = 95;BA.debugLine="If resultList.Size>0 Then";
if (_resultlist.getSize()>0) { 
 //BA.debugLineNum = 96;BA.debugLine="For i=0 To resultList.Size-1";
{
final int step2 = 1;
final int limit2 = (int) (_resultlist.getSize()-1);
for (_i = (int) (0) ; (step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2); _i = ((int)(0 + _i + step2)) ) {
 //BA.debugLineNum = 97;BA.debugLine="Dim tp As PhotoInfo=resultList.Get(i)";
_tp = (cn.finalteam.galleryfinal.model.PhotoInfo)(_resultlist.Get(_i));
 //BA.debugLineNum = 98;BA.debugLine="TL(\"Selected:\"&tp.PhotoPath)";
_tl("Selected:"+_tp.getPhotoPath());
 }
};
 };
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 24;BA.debugLine="Private gf As GalleryFinal";
mostCurrent._gf = new cn.finalteam.galleryfinal.gfWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private dispopt As uilOptions";
mostCurrent._dispopt = new de.donmanfred.uilOptions();
 //BA.debugLineNum = 26;BA.debugLine="Private uil As UniversalImageLoader";
mostCurrent._uil = new de.donmanfred.UniversalImageLoader();
 //BA.debugLineNum = 27;BA.debugLine="Private Button2 As Button";
mostCurrent._button2 = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Dim gffc As FunctionConfig_gf";
mostCurrent._gffc = new cn.finalteam.galleryfinal.FCWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Public simgurl(4) As String";
mostCurrent._simgurl = new String[(int) (4)];
java.util.Arrays.fill(mostCurrent._simgurl,"");
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
photoviewsingle._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _showpicker(int _num) throws Exception{
cn.finalteam.galleryfinal.ThemeConfig.Builder _tfc = null;
cn.finalteam.galleryfinal.model.PhotoInfo[] _photoinfo = null;
anywheresoftware.b4a.objects.collections.List _lsts = null;
 //BA.debugLineNum = 46;BA.debugLine="Private Sub showPicker(num As Int)";
 //BA.debugLineNum = 47;BA.debugLine="If gffc.IsInitialized = False Then gffc.init";
if (mostCurrent._gffc.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
mostCurrent._gffc.init();};
 //BA.debugLineNum = 48;BA.debugLine="gffc.CropHeight=300";
mostCurrent._gffc.setCropHeight((int) (300));
 //BA.debugLineNum = 49;BA.debugLine="gffc.CropWidth=300";
mostCurrent._gffc.setCropWidth((int) (300));
 //BA.debugLineNum = 50;BA.debugLine="gffc.RotateReplaceSource=True";
mostCurrent._gffc.setRotateReplaceSource(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 51;BA.debugLine="gffc.CropSquare=True";
mostCurrent._gffc.setCropSquare(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 52;BA.debugLine="gffc.EnableCamera=True";
mostCurrent._gffc.setEnableCamera(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 53;BA.debugLine="gffc.EnableCrop=True";
mostCurrent._gffc.setEnableCrop(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 54;BA.debugLine="gffc.EnableEdit=True";
mostCurrent._gffc.setEnableEdit(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 55;BA.debugLine="gffc.ForceCrop=True";
mostCurrent._gffc.setForceCrop(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 56;BA.debugLine="gffc.ForceCropEdit=True";
mostCurrent._gffc.setForceCropEdit(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 57;BA.debugLine="gffc.EnablePreview=True";
mostCurrent._gffc.setEnablePreview(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 58;BA.debugLine="gffc.MutiSelect=True";
mostCurrent._gffc.setMutiSelect(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 59;BA.debugLine="gffc.MutiSelectMaxSize=10";
mostCurrent._gffc.setMutiSelectMaxSize((int) (10));
 //BA.debugLineNum = 60;BA.debugLine="gffc.EnableRotate=True";
mostCurrent._gffc.setEnableRotate(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 62;BA.debugLine="Dim tfc As ThemeConfig_gf";
_tfc = new cn.finalteam.galleryfinal.ThemeConfig.Builder();
 //BA.debugLineNum = 63;BA.debugLine="tfc.setCheckSelectedColor(Colors.LightGray)";
_tfc.setCheckSelectedColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
 //BA.debugLineNum = 64;BA.debugLine="tfc.setCheckNornalColor(Colors.Gray)";
_tfc.setCheckNornalColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 //BA.debugLineNum = 65;BA.debugLine="gf.Init(\"gf\",tfc.build)";
mostCurrent._gf.Init(processBA,"gf",_tfc.build());
 //BA.debugLineNum = 67;BA.debugLine="If num = 1 Then";
if (_num==1) { 
 //BA.debugLineNum = 68;BA.debugLine="gf.openGalleryMuti(1,num)";
mostCurrent._gf.openGalleryMuti((int) (1),_num);
 }else if(_num==5) { 
 //BA.debugLineNum = 70;BA.debugLine="Dim photoinfo(3) As PhotoInfo";
_photoinfo = new cn.finalteam.galleryfinal.model.PhotoInfo[(int) (3)];
{
int d0 = _photoinfo.length;
for (int i0 = 0;i0 < d0;i0++) {
_photoinfo[i0] = new cn.finalteam.galleryfinal.model.PhotoInfo();
}
}
;
 //BA.debugLineNum = 71;BA.debugLine="Dim lsts As List";
_lsts = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 72;BA.debugLine="lsts.Initialize";
_lsts.Initialize();
 //BA.debugLineNum = 73;BA.debugLine="photoinfo(0).PhotoPath = simgurl(1)";
_photoinfo[(int) (0)].setPhotoPath(mostCurrent._simgurl[(int) (1)]);
 //BA.debugLineNum = 74;BA.debugLine="photoinfo(0).PhotoId = Rnd(11111,99999)";
_photoinfo[(int) (0)].setPhotoId(anywheresoftware.b4a.keywords.Common.Rnd((int) (11111),(int) (99999)));
 //BA.debugLineNum = 75;BA.debugLine="photoinfo(1).PhotoPath = simgurl(2)";
_photoinfo[(int) (1)].setPhotoPath(mostCurrent._simgurl[(int) (2)]);
 //BA.debugLineNum = 76;BA.debugLine="photoinfo(1).PhotoId = Rnd(11111,99999)";
_photoinfo[(int) (1)].setPhotoId(anywheresoftware.b4a.keywords.Common.Rnd((int) (11111),(int) (99999)));
 //BA.debugLineNum = 77;BA.debugLine="photoinfo(2).PhotoPath = simgurl(3)";
_photoinfo[(int) (2)].setPhotoPath(mostCurrent._simgurl[(int) (3)]);
 //BA.debugLineNum = 81;BA.debugLine="Log(photoinfo(2).PhotoPath)";
anywheresoftware.b4a.keywords.Common.Log(_photoinfo[(int) (2)].getPhotoPath());
 //BA.debugLineNum = 82;BA.debugLine="photoinfo(2).PhotoId = Rnd(11111,99999)";
_photoinfo[(int) (2)].setPhotoId(anywheresoftware.b4a.keywords.Common.Rnd((int) (11111),(int) (99999)));
 //BA.debugLineNum = 83;BA.debugLine="lsts.Add(photoinfo(0))";
_lsts.Add((Object)(_photoinfo[(int) (0)]));
 //BA.debugLineNum = 84;BA.debugLine="lsts.Add(photoinfo(1))";
_lsts.Add((Object)(_photoinfo[(int) (1)]));
 //BA.debugLineNum = 85;BA.debugLine="lsts.Add(photoinfo(2))";
_lsts.Add((Object)(_photoinfo[(int) (2)]));
 //BA.debugLineNum = 86;BA.debugLine="gf.PhotoViewMuti(5,lsts,gffc)";
mostCurrent._gf.PhotoViewMuti((int) (5),(java.util.ArrayList)(_lsts.getObject()),mostCurrent._gffc);
 }else {
 //BA.debugLineNum = 88;BA.debugLine="gf.openGallerySingle(1)";
mostCurrent._gf.openGallerySingle((int) (1));
 };
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public static String  _tl(String _msg) throws Exception{
 //BA.debugLineNum = 103;BA.debugLine="Private Sub TL(msg As String)";
 //BA.debugLineNum = 104;BA.debugLine="Log(msg)";
anywheresoftware.b4a.keywords.Common.Log(_msg);
 //BA.debugLineNum = 105;BA.debugLine="ToastMessageShow(msg,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(_msg,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
return "";
}
}
