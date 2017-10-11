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

public class dbscrollview extends Activity implements B4AActivity{
	public static dbscrollview mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.AutoScaleExample7", "b4a.AutoScaleExample7.dbscrollview");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (dbscrollview).");
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
		activityBA = new BA(this, layout, processBA, "b4a.AutoScaleExample7", "b4a.AutoScaleExample7.dbscrollview");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.AutoScaleExample7.dbscrollview", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (dbscrollview) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (dbscrollview) Resume **");
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
		return dbscrollview.class;
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
        BA.LogInfo("** Activity (dbscrollview) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (dbscrollview) Resume **");
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
public static int _numberofcolumns = 0;
public static int _numberofrows = 0;
public static int _rowheight = 0;
public static int _rowlinewidth = 0;
public static int _rowheight_1 = 0;
public static int _collinewidth = 0;
public static int[] _columnwidth = null;
public static int[] _columnwidth_1 = null;
public static int[] _totalcolumnwidth = null;
public static String[] _columnname = null;
public static int _headercolor = 0;
public static int _headerfontcolor = 0;
public static int _headerlinecolor = 0;
public static int _cellcolor = 0;
public static int _fontcolor = 0;
public static float _fontsize = 0f;
public static int _alignment = 0;
public flm.b4a.scrollview2d.ScrollView2DWrapper _scvpersons = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlheader = null;
public b4a.AutoScaleExample7.main _main = null;
public b4a.AutoScaleExample7.setup _setup = null;
public b4a.AutoScaleExample7.about _about = null;
public b4a.AutoScaleExample7.scale _scale = null;
public b4a.AutoScaleExample7.dbwebview _dbwebview = null;
public b4a.AutoScaleExample7.dbutils _dbutils = null;
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
public static class _rowcol{
public boolean IsInitialized;
public int Row;
public int Col;
public void Initialize() {
IsInitialized = true;
Row = 0;
Col = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static String  _activity_create(boolean _firsttime) throws Exception{
int _i = 0;
 //BA.debugLineNum = 51;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 52;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 55;BA.debugLine="If FirstTime = True Then";
if (_firsttime==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 56;BA.debugLine="ColLineWidth = ColLineWidth * Scale.GetScaleX";
_collinewidth = (int) (_collinewidth*mostCurrent._scale._getscalex(mostCurrent.activityBA));
 //BA.debugLineNum = 57;BA.debugLine="RowLineWidth = RowLineWidth * Scale.GetScaleX";
_rowlinewidth = (int) (_rowlinewidth*mostCurrent._scale._getscalex(mostCurrent.activityBA));
 //BA.debugLineNum = 58;BA.debugLine="RowHeight = RowHeight * Scale.GetScaleY";
_rowheight = (int) (_rowheight*mostCurrent._scale._getscaley(mostCurrent.activityBA));
 //BA.debugLineNum = 59;BA.debugLine="RowHeight_1 = RowHeight - RowLineWidth";
_rowheight_1 = (int) (_rowheight-_rowlinewidth);
 //BA.debugLineNum = 60;BA.debugLine="FontSize = FontSize * Scale.GetScaleX";
_fontsize = (float) (_fontsize*mostCurrent._scale._getscalex(mostCurrent.activityBA));
 //BA.debugLineNum = 61;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step8 = 1;
final int limit8 = (int) (_numberofcolumns-1);
_i = (int) (0) ;
for (;(step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8) ;_i = ((int)(0 + _i + step8))  ) {
 //BA.debugLineNum = 62;BA.debugLine="ColumnWidth(i) = ColumnWidth(i) * Scale.GetScal";
_columnwidth[_i] = (int) (_columnwidth[_i]*mostCurrent._scale._getscalex(mostCurrent.activityBA));
 }
};
 };
 //BA.debugLineNum = 67;BA.debugLine="TotalColumnWidth(0) = ColLineWidth";
_totalcolumnwidth[(int) (0)] = _collinewidth;
 //BA.debugLineNum = 68;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step13 = 1;
final int limit13 = (int) (_numberofcolumns-1);
_i = (int) (0) ;
for (;(step13 > 0 && _i <= limit13) || (step13 < 0 && _i >= limit13) ;_i = ((int)(0 + _i + step13))  ) {
 //BA.debugLineNum = 69;BA.debugLine="ColumnWidth_1(i) = ColumnWidth(i) - ColLineWidth";
_columnwidth_1[_i] = (int) (_columnwidth[_i]-_collinewidth);
 //BA.debugLineNum = 70;BA.debugLine="TotalColumnWidth(i + 1) = TotalColumnWidth(i) +";
_totalcolumnwidth[(int) (_i+1)] = (int) (_totalcolumnwidth[_i]+_columnwidth[_i]);
 }
};
 //BA.debugLineNum = 74;BA.debugLine="scvPersons.Initialize(100,100, \"scvPersons\")";
mostCurrent._scvpersons.Initialize(mostCurrent.activityBA,(int) (100),(int) (100),"scvPersons");
 //BA.debugLineNum = 75;BA.debugLine="Activity.AddView(scvPersons, 0, RowHeight, 100%x,";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._scvpersons.getObject()),(int) (0),_rowheight,anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-_rowheight));
 //BA.debugLineNum = 78;BA.debugLine="scvPersons.Panel.Width = TotalColumnWidth(NumberO";
mostCurrent._scvpersons.getPanel().setWidth(_totalcolumnwidth[_numberofcolumns]);
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 81;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 82;BA.debugLine="SQLTableRead";
_sqltableread();
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public static String  _addrow(String[] _values) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
b4a.AutoScaleExample7.dbscrollview._rowcol _rc = null;
 //BA.debugLineNum = 115;BA.debugLine="Sub AddRow(Values() As String)";
 //BA.debugLineNum = 117;BA.debugLine="If Values.Length <> NumberOfColumns Then";
if (_values.length!=_numberofcolumns) { 
 //BA.debugLineNum = 118;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 121;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step4 = 1;
final int limit4 = (int) (_numberofcolumns-1);
_i = (int) (0) ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
 //BA.debugLineNum = 122;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 123;BA.debugLine="l.Initialize(\"cell\")";
_l.Initialize(mostCurrent.activityBA,"cell");
 //BA.debugLineNum = 124;BA.debugLine="l.Text = Values(i)";
_l.setText(BA.ObjectToCharSequence(_values[_i]));
 //BA.debugLineNum = 125;BA.debugLine="l.Gravity = Alignment";
_l.setGravity(_alignment);
 //BA.debugLineNum = 126;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(_fontsize);
 //BA.debugLineNum = 127;BA.debugLine="l.TextColor = FontColor";
_l.setTextColor(_fontcolor);
 //BA.debugLineNum = 128;BA.debugLine="l.Color = CellColor";
_l.setColor(_cellcolor);
 //BA.debugLineNum = 129;BA.debugLine="Dim rc As RowCol";
_rc = new b4a.AutoScaleExample7.dbscrollview._rowcol();
 //BA.debugLineNum = 130;BA.debugLine="rc.Initialize";
_rc.Initialize();
 //BA.debugLineNum = 131;BA.debugLine="rc.Col = i";
_rc.Col = _i;
 //BA.debugLineNum = 132;BA.debugLine="rc.Row = NumberOfRows";
_rc.Row = _numberofrows;
 //BA.debugLineNum = 133;BA.debugLine="l.Tag = rc";
_l.setTag((Object)(_rc));
 //BA.debugLineNum = 134;BA.debugLine="scvPersons.Panel.AddView(l, TotalColumnWidth(i),";
mostCurrent._scvpersons.getPanel().AddView((android.view.View)(_l.getObject()),_totalcolumnwidth[_i],(int) (_rowheight*_numberofrows),_columnwidth_1[_i],_rowheight_1);
 }
};
 //BA.debugLineNum = 137;BA.debugLine="NumberOfRows = NumberOfRows + 1";
_numberofrows = (int) (_numberofrows+1);
 //BA.debugLineNum = 138;BA.debugLine="scvPersons.Panel.Height = NumberOfRows * RowHeigh";
mostCurrent._scvpersons.getPanel().setHeight((int) (_numberofrows*_rowheight));
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 47;BA.debugLine="Dim scvPersons As ScrollView2D";
mostCurrent._scvpersons = new flm.b4a.scrollview2d.ScrollView2DWrapper();
 //BA.debugLineNum = 48;BA.debugLine="Dim pnlHeader As Panel";
mostCurrent._pnlheader = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Dim NumberOfColumns = 5 As Int";
_numberofcolumns = (int) (5);
 //BA.debugLineNum = 11;BA.debugLine="Dim NumberOfRows = 0 As Int";
_numberofrows = (int) (0);
 //BA.debugLineNum = 12;BA.debugLine="Dim RowHeight = 30dip As Int";
_rowheight = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30));
 //BA.debugLineNum = 13;BA.debugLine="Dim RowLineWidth = 1dip As Int";
_rowlinewidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1));
 //BA.debugLineNum = 14;BA.debugLine="Dim RowHeight_1 As Int					: RowHeight_1 = RowHei";
_rowheight_1 = 0;
 //BA.debugLineNum = 14;BA.debugLine="Dim RowHeight_1 As Int					: RowHeight_1 = RowHei";
_rowheight_1 = (int) (_rowheight-_rowlinewidth);
 //BA.debugLineNum = 15;BA.debugLine="Dim ColLineWidth = 1dip As Int";
_collinewidth = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1));
 //BA.debugLineNum = 16;BA.debugLine="Dim ColumnWidth(NumberOfColumns) As Int";
_columnwidth = new int[_numberofcolumns];
;
 //BA.debugLineNum = 17;BA.debugLine="ColumnWidth(0) = 60dip";
_columnwidth[(int) (0)] = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60));
 //BA.debugLineNum = 18;BA.debugLine="ColumnWidth(1) = 120dip";
_columnwidth[(int) (1)] = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120));
 //BA.debugLineNum = 19;BA.debugLine="ColumnWidth(2) = 120dip";
_columnwidth[(int) (2)] = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120));
 //BA.debugLineNum = 20;BA.debugLine="ColumnWidth(3) = 180dip";
_columnwidth[(int) (3)] = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (180));
 //BA.debugLineNum = 21;BA.debugLine="ColumnWidth(4) = 120dip";
_columnwidth[(int) (4)] = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120));
 //BA.debugLineNum = 22;BA.debugLine="Dim ColumnWidth_1(NumberOfColumns) As Int";
_columnwidth_1 = new int[_numberofcolumns];
;
 //BA.debugLineNum = 23;BA.debugLine="Dim TotalColumnWidth(NumberOfColumns + 1) As Int";
_totalcolumnwidth = new int[(int) (_numberofcolumns+1)];
;
 //BA.debugLineNum = 26;BA.debugLine="Dim ColumnName(NumberOfColumns) As String	' names";
_columnname = new String[_numberofcolumns];
java.util.Arrays.fill(_columnname,"");
 //BA.debugLineNum = 27;BA.debugLine="ColumnName(0) = \"ID\"";
_columnname[(int) (0)] = "ID";
 //BA.debugLineNum = 28;BA.debugLine="ColumnName(1) = \"FirstName\"";
_columnname[(int) (1)] = "FirstName";
 //BA.debugLineNum = 29;BA.debugLine="ColumnName(2) = \"LastName\"";
_columnname[(int) (2)] = "LastName";
 //BA.debugLineNum = 30;BA.debugLine="ColumnName(3) = \"Address\"";
_columnname[(int) (3)] = "Address";
 //BA.debugLineNum = 31;BA.debugLine="ColumnName(4) = \"City\"";
_columnname[(int) (4)] = "City";
 //BA.debugLineNum = 34;BA.debugLine="Dim HeaderColor As Int					: HeaderColor = Colors";
_headercolor = 0;
 //BA.debugLineNum = 34;BA.debugLine="Dim HeaderColor As Int					: HeaderColor = Colors";
_headercolor = anywheresoftware.b4a.keywords.Common.Colors.Blue;
 //BA.debugLineNum = 35;BA.debugLine="Dim HeaderFontColor As Int			: HeaderFontColor =";
_headerfontcolor = 0;
 //BA.debugLineNum = 35;BA.debugLine="Dim HeaderFontColor As Int			: HeaderFontColor =";
_headerfontcolor = anywheresoftware.b4a.keywords.Common.Colors.Yellow;
 //BA.debugLineNum = 36;BA.debugLine="Dim HeaderLineColor As Int			: HeaderLineColor =";
_headerlinecolor = 0;
 //BA.debugLineNum = 36;BA.debugLine="Dim HeaderLineColor As Int			: HeaderLineColor =";
_headerlinecolor = anywheresoftware.b4a.keywords.Common.Colors.Yellow;
 //BA.debugLineNum = 37;BA.debugLine="Dim CellColor As Int						: CellColor = Colors.RG";
_cellcolor = 0;
 //BA.debugLineNum = 37;BA.debugLine="Dim CellColor As Int						: CellColor = Colors.RG";
_cellcolor = anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (255),(int) (255),(int) (220));
 //BA.debugLineNum = 38;BA.debugLine="Dim FontColor As Int						: FontColor = Colors.Bl";
_fontcolor = 0;
 //BA.debugLineNum = 38;BA.debugLine="Dim FontColor As Int						: FontColor = Colors.Bl";
_fontcolor = anywheresoftware.b4a.keywords.Common.Colors.Black;
 //BA.debugLineNum = 39;BA.debugLine="Dim FontSize As Float						: FontSize = 14";
_fontsize = 0f;
 //BA.debugLineNum = 39;BA.debugLine="Dim FontSize As Float						: FontSize = 14";
_fontsize = (float) (14);
 //BA.debugLineNum = 40;BA.debugLine="Dim Alignment As Int						: Alignment = Gravity.C";
_alignment = 0;
 //BA.debugLineNum = 40;BA.debugLine="Dim Alignment As Int						: Alignment = Gravity.C";
_alignment = anywheresoftware.b4a.keywords.Common.Gravity.CENTER;
 //BA.debugLineNum = 42;BA.debugLine="Type RowCol (Row As Int, Col As Int)";
;
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public static String  _scvpersons_scrollchanged(int _posx,int _posy) throws Exception{
 //BA.debugLineNum = 164;BA.debugLine="Sub scvPersons_ScrollChanged(PosX As Int, PosY As";
 //BA.debugLineNum = 165;BA.debugLine="pnlHeader.Left = -PosX";
mostCurrent._pnlheader.setLeft((int) (-_posx));
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public static String  _setheader(String[] _values) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.LabelWrapper _l = null;
 //BA.debugLineNum = 141;BA.debugLine="Sub SetHeader(Values() As String)";
 //BA.debugLineNum = 143;BA.debugLine="If pnlHeader.IsInitialized Then 'should only be c";
if (mostCurrent._pnlheader.IsInitialized()) { 
 //BA.debugLineNum = 144;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 147;BA.debugLine="pnlHeader.Initialize(\"\")";
mostCurrent._pnlheader.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 148;BA.debugLine="pnlHeader.Color = HeaderLineColor";
mostCurrent._pnlheader.setColor(_headerlinecolor);
 //BA.debugLineNum = 150;BA.debugLine="For i = 0 To NumberOfColumns - 1";
{
final int step6 = 1;
final int limit6 = (int) (_numberofcolumns-1);
_i = (int) (0) ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
 //BA.debugLineNum = 151;BA.debugLine="Dim l As Label";
_l = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 152;BA.debugLine="l.Initialize(\"Header\")";
_l.Initialize(mostCurrent.activityBA,"Header");
 //BA.debugLineNum = 153;BA.debugLine="l.Text = Values(i)";
_l.setText(BA.ObjectToCharSequence(_values[_i]));
 //BA.debugLineNum = 154;BA.debugLine="l.Gravity = Gravity.CENTER";
_l.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 155;BA.debugLine="l.TextSize = FontSize";
_l.setTextSize(_fontsize);
 //BA.debugLineNum = 156;BA.debugLine="l.Color = HeaderColor";
_l.setColor(_headercolor);
 //BA.debugLineNum = 157;BA.debugLine="l.TextColor = HeaderFontColor";
_l.setTextColor(_headerfontcolor);
 //BA.debugLineNum = 158;BA.debugLine="l.Tag = i";
_l.setTag((Object)(_i));
 //BA.debugLineNum = 159;BA.debugLine="pnlHeader.AddView(l, TotalColumnWidth(i), 0, Col";
mostCurrent._pnlheader.AddView((android.view.View)(_l.getObject()),_totalcolumnwidth[_i],(int) (0),_columnwidth_1[_i],_rowheight_1);
 }
};
 //BA.debugLineNum = 161;BA.debugLine="Activity.AddView(pnlHeader, scvPersons.Left, 0, T";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._pnlheader.getObject()),mostCurrent._scvpersons.getLeft(),(int) (0),_totalcolumnwidth[_numberofcolumns],_rowheight);
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public static String  _sqltableread() throws Exception{
int _i = 0;
anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor1 = null;
String _txt = "";
String[] _col = null;
int _j = 0;
 //BA.debugLineNum = 89;BA.debugLine="Sub SQLTableRead";
 //BA.debugLineNum = 91;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 92;BA.debugLine="Dim Cursor1 As Cursor";
_cursor1 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 93;BA.debugLine="Dim txt As String";
_txt = "";
 //BA.debugLineNum = 95;BA.debugLine="txt = \"SELECT * FROM \" & Main.DBTableName";
_txt = "SELECT * FROM "+mostCurrent._main._dbtablename;
 //BA.debugLineNum = 97;BA.debugLine="Cursor1 = Main.SQL1.ExecQuery(txt)";
_cursor1.setObject((android.database.Cursor)(mostCurrent._main._sql1.ExecQuery(_txt)));
 //BA.debugLineNum = 99;BA.debugLine="Dim Col(NumberOfColumns) As String";
_col = new String[_numberofcolumns];
java.util.Arrays.fill(_col,"");
 //BA.debugLineNum = 101;BA.debugLine="SetHeader(ColumnName)";
_setheader(_columnname);
 //BA.debugLineNum = 102;BA.debugLine="NumberOfRows = 0";
_numberofrows = (int) (0);
 //BA.debugLineNum = 104;BA.debugLine="For i = 0 To Cursor1.RowCount - 1";
{
final int step9 = 1;
final int limit9 = (int) (_cursor1.getRowCount()-1);
_i = (int) (0) ;
for (;(step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9) ;_i = ((int)(0 + _i + step9))  ) {
 //BA.debugLineNum = 105;BA.debugLine="Dim Col(NumberOfColumns) As String";
_col = new String[_numberofcolumns];
java.util.Arrays.fill(_col,"");
 //BA.debugLineNum = 106;BA.debugLine="Cursor1.Position = i";
_cursor1.setPosition(_i);
 //BA.debugLineNum = 107;BA.debugLine="For j = 0 To NumberOfColumns - 1";
{
final int step12 = 1;
final int limit12 = (int) (_numberofcolumns-1);
_j = (int) (0) ;
for (;(step12 > 0 && _j <= limit12) || (step12 < 0 && _j >= limit12) ;_j = ((int)(0 + _j + step12))  ) {
 //BA.debugLineNum = 108;BA.debugLine="Col(j) = Cursor1.GetString(ColumnName(j))";
_col[_j] = _cursor1.GetString(_columnname[_j]);
 }
};
 //BA.debugLineNum = 110;BA.debugLine="AddRow(Col)";
_addrow(_col);
 }
};
 //BA.debugLineNum = 112;BA.debugLine="Cursor1.Close";
_cursor1.Close();
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
return "";
}
}
