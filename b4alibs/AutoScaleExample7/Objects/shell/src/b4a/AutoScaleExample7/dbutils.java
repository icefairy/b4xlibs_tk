
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

public class dbutils implements IRemote{
	public static dbutils mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public dbutils() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, dbutils.class);
    static {
		mostCurrent = new dbutils();
        remoteMe = RemoteObject.declareNull("b4a.AutoScaleExample7.dbutils");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("dbutils"), "b4a.AutoScaleExample7.dbutils");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("b4a.AutoScaleExample7.dbutils"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _db_real = RemoteObject.createImmutable("");
public static RemoteObject _db_integer = RemoteObject.createImmutable("");
public static RemoteObject _db_blob = RemoteObject.createImmutable("");
public static RemoteObject _db_text = RemoteObject.createImmutable("");
public static RemoteObject _htmlcss = RemoteObject.createImmutable("");
public static b4a.AutoScaleExample7.main _main = null;
public static b4a.AutoScaleExample7.setup _setup = null;
public static b4a.AutoScaleExample7.about _about = null;
public static b4a.AutoScaleExample7.scale _scale = null;
public static b4a.AutoScaleExample7.dbwebview _dbwebview = null;
public static b4a.AutoScaleExample7.dbscrollview _dbscrollview = null;
public static b4a.AutoScaleExample7.keyboard _keyboard = null;
public static b4a.AutoScaleExample7.listview _listview = null;
public static b4a.AutoScaleExample7.calculator _calculator = null;
public static b4a.AutoScaleExample7.calculator1 _calculator1 = null;
public static b4a.AutoScaleExample7.positioning _positioning = null;
  public Object[] GetGlobals() {
		return new Object[] {"About",Debug.moduleToString(b4a.AutoScaleExample7.about.class),"Calculator",Debug.moduleToString(b4a.AutoScaleExample7.calculator.class),"Calculator1",Debug.moduleToString(b4a.AutoScaleExample7.calculator1.class),"DB_BLOB",dbutils._db_blob,"DB_INTEGER",dbutils._db_integer,"DB_REAL",dbutils._db_real,"DB_TEXT",dbutils._db_text,"DBScrollView",Debug.moduleToString(b4a.AutoScaleExample7.dbscrollview.class),"DBWebView",Debug.moduleToString(b4a.AutoScaleExample7.dbwebview.class),"HtmlCSS",dbutils._htmlcss,"Keyboard",Debug.moduleToString(b4a.AutoScaleExample7.keyboard.class),"ListView",Debug.moduleToString(b4a.AutoScaleExample7.listview.class),"Main",Debug.moduleToString(b4a.AutoScaleExample7.main.class),"Positioning",Debug.moduleToString(b4a.AutoScaleExample7.positioning.class),"Scale",Debug.moduleToString(b4a.AutoScaleExample7.scale.class),"Setup",Debug.moduleToString(b4a.AutoScaleExample7.setup.class)};
}
}