
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

public class keyboard implements IRemote{
	public static keyboard mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public keyboard() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("keyboard"), "b4a.AutoScaleExample7.keyboard");
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
		pcBA = new PCBA(this, keyboard.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _pnlkeyboard = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static b4a.AutoScaleExample7.main _main = null;
public static b4a.AutoScaleExample7.setup _setup = null;
public static b4a.AutoScaleExample7.about _about = null;
public static b4a.AutoScaleExample7.scale _scale = null;
public static b4a.AutoScaleExample7.dbwebview _dbwebview = null;
public static b4a.AutoScaleExample7.dbutils _dbutils = null;
public static b4a.AutoScaleExample7.dbscrollview _dbscrollview = null;
public static b4a.AutoScaleExample7.listview _listview = null;
public static b4a.AutoScaleExample7.calculator _calculator = null;
public static b4a.AutoScaleExample7.calculator1 _calculator1 = null;
public static b4a.AutoScaleExample7.positioning _positioning = null;
  public Object[] GetGlobals() {
		return new Object[] {"About",Debug.moduleToString(b4a.AutoScaleExample7.about.class),"Activity",keyboard.mostCurrent._activity,"Calculator",Debug.moduleToString(b4a.AutoScaleExample7.calculator.class),"Calculator1",Debug.moduleToString(b4a.AutoScaleExample7.calculator1.class),"DBScrollView",Debug.moduleToString(b4a.AutoScaleExample7.dbscrollview.class),"DBUtils",Debug.moduleToString(b4a.AutoScaleExample7.dbutils.class),"DBWebView",Debug.moduleToString(b4a.AutoScaleExample7.dbwebview.class),"ListView",Debug.moduleToString(b4a.AutoScaleExample7.listview.class),"Main",Debug.moduleToString(b4a.AutoScaleExample7.main.class),"pnlKeyboard",keyboard.mostCurrent._pnlkeyboard,"Positioning",Debug.moduleToString(b4a.AutoScaleExample7.positioning.class),"Scale",Debug.moduleToString(b4a.AutoScaleExample7.scale.class),"Setup",Debug.moduleToString(b4a.AutoScaleExample7.setup.class)};
}
}