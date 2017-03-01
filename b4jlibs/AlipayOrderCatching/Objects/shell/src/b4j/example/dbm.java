
package b4j.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class dbm implements IRemote{
	public static dbm mostCurrent;
	public static RemoteObject ba;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public dbm() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
		mostCurrent = new dbm();
		remoteMe = RemoteObject.declareNull("b4j.example.dbm");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("dbm"), "b4j.example.dbm");
	}
    public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    private static PCBA pcBA = new PCBA(null, dbm.class);
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
    public static RemoteObject getObject() {
		return myClass;
	 }
	public PCBA create(Object[] args) throws ClassNotFoundException{
		ba = (RemoteObject) args[1];
		pcBA = new PCBA(this, dbm.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _pool = RemoteObject.declareNull("anywheresoftware.b4j.object.ConnectionPool");
public static RemoteObject _sqlite = RemoteObject.declareNull("anywheresoftware.b4j.objects.SQL");
public static RemoteObject _usepool = RemoteObject.createImmutable(false);
public static b4j.example.main _main = null;
public static b4j.example.abmshared _abmshared = null;
  public Object[] GetGlobals() {
		return new Object[] {"ABMShared",Debug.moduleToString(b4j.example.abmshared.class),"Main",Debug.moduleToString(b4j.example.main.class),"pool",dbm._pool,"SQLite",dbm._sqlite,"UsePool",dbm._usepool};
}
}