
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

public class abmshared implements IRemote{
	public static abmshared mostCurrent;
	public static RemoteObject ba;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public abmshared() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
		mostCurrent = new abmshared();
		remoteMe = RemoteObject.declareNull("b4j.example.abmshared");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("abmshared"), "b4j.example.abmshared");
	}
    public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    private static PCBA pcBA = new PCBA(null, abmshared.class);
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
		pcBA = new PCBA(this, abmshared.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _mytheme = RemoteObject.declareNull("com.ab.abmaterial.ABMTheme");
public static RemoteObject _abm = RemoteObject.declareNull("com.ab.abmaterial.ABMaterial");
public static RemoteObject _needsauthorization = RemoteObject.createImmutable(false);
public static RemoteObject _appversion = RemoteObject.createImmutable("");
public static RemoteObject _apppublishedstarturl = RemoteObject.createImmutable("");
public static RemoteObject _appname = RemoteObject.createImmutable("");
public static RemoteObject _cachedpages = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _cachescavengeperiodseconds = RemoteObject.createImmutable(0);
public static RemoteObject _sessionmaxinactiveintervalseconds = RemoteObject.createImmutable(0);
public static b4j.example.main _main = null;
public static b4j.example.dbm _dbm = null;
  public Object[] GetGlobals() {
		return new Object[] {"ABM",abmshared._abm,"AppName",abmshared._appname,"AppPublishedStartURL",abmshared._apppublishedstarturl,"AppVersion",abmshared._appversion,"CachedPages",abmshared._cachedpages,"CacheScavengePeriodSeconds",abmshared._cachescavengeperiodseconds,"DBM",Debug.moduleToString(b4j.example.dbm.class),"Main",Debug.moduleToString(b4j.example.main.class),"MyTheme",abmshared._mytheme,"NeedsAuthorization",abmshared._needsauthorization,"SessionMaxInactiveIntervalSeconds",abmshared._sessionmaxinactiveintervalseconds};
}
}