
package b4a.AutoScaleExample7;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "b4a.AutoScaleExample7.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _progname = RemoteObject.createImmutable("");
public static RemoteObject _progversion = RemoteObject.createImmutable("");
public static RemoteObject _progauthor = RemoteObject.createImmutable("");
public static RemoteObject _progdate = RemoteObject.createImmutable("");
public static RemoteObject _progcopyright = RemoteObject.createImmutable("");
public static RemoteObject _progcountry = RemoteObject.createImmutable("");
public static RemoteObject _progemail = RemoteObject.createImmutable("");
public static RemoteObject _sql1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _dbfilename = RemoteObject.createImmutable("");
public static RemoteObject _dbfiledir = RemoteObject.createImmutable("");
public static RemoteObject _dbtablename = RemoteObject.createImmutable("");
public static RemoteObject _btndbscrollview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btndbwebview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnkeyboard = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnsetup = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnabout = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnlistview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btncalculator = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btncalculator1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnpositionning = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _pnlmainbackground = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnltoolbox = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnltoolbox1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _lbltitle = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static b4a.AutoScaleExample7.setup _setup = null;
public static b4a.AutoScaleExample7.about _about = null;
public static b4a.AutoScaleExample7.scale _scale = null;
public static b4a.AutoScaleExample7.dbwebview _dbwebview = null;
public static b4a.AutoScaleExample7.dbutils _dbutils = null;
public static b4a.AutoScaleExample7.dbscrollview _dbscrollview = null;
public static b4a.AutoScaleExample7.keyboard _keyboard = null;
public static b4a.AutoScaleExample7.listview _listview = null;
public static b4a.AutoScaleExample7.calculator _calculator = null;
public static b4a.AutoScaleExample7.calculator1 _calculator1 = null;
public static b4a.AutoScaleExample7.positioning _positioning = null;
  public Object[] GetGlobals() {
		return new Object[] {"About",Debug.moduleToString(b4a.AutoScaleExample7.about.class),"Activity",main.mostCurrent._activity,"btnAbout",main.mostCurrent._btnabout,"btnCalculator",main.mostCurrent._btncalculator,"btnCalculator1",main.mostCurrent._btncalculator1,"btnDBScrollView",main.mostCurrent._btndbscrollview,"btnDBWebView",main.mostCurrent._btndbwebview,"btnKeyboard",main.mostCurrent._btnkeyboard,"btnListView",main.mostCurrent._btnlistview,"btnPositionning",main.mostCurrent._btnpositionning,"btnSetup",main.mostCurrent._btnsetup,"Calculator",Debug.moduleToString(b4a.AutoScaleExample7.calculator.class),"Calculator1",Debug.moduleToString(b4a.AutoScaleExample7.calculator1.class),"DBFileDir",main._dbfiledir,"DBFileName",main._dbfilename,"DBScrollView",Debug.moduleToString(b4a.AutoScaleExample7.dbscrollview.class),"DBTableName",main._dbtablename,"DBUtils",Debug.moduleToString(b4a.AutoScaleExample7.dbutils.class),"DBWebView",Debug.moduleToString(b4a.AutoScaleExample7.dbwebview.class),"Keyboard",Debug.moduleToString(b4a.AutoScaleExample7.keyboard.class),"lblTitle",main.mostCurrent._lbltitle,"ListView",Debug.moduleToString(b4a.AutoScaleExample7.listview.class),"pnlMainBackground",main.mostCurrent._pnlmainbackground,"pnlToolBox",main.mostCurrent._pnltoolbox,"pnlToolBox1",main.mostCurrent._pnltoolbox1,"Positioning",Debug.moduleToString(b4a.AutoScaleExample7.positioning.class),"ProgAuthor",main._progauthor,"ProgCopyright",main._progcopyright,"ProgCountry",main._progcountry,"ProgDate",main._progdate,"ProgEMail",main._progemail,"ProgName",main._progname,"ProgVersion",main._progversion,"Scale",Debug.moduleToString(b4a.AutoScaleExample7.scale.class),"Setup",Debug.moduleToString(b4a.AutoScaleExample7.setup.class),"SQL1",main._sql1};
}
}