
package b4i.sdimagedemo;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;

public class b4i_main implements IRemote{
	public static b4i_main mostCurrent;
    public static RemoteObject ba;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
		mostCurrent = new b4i_main();
        remoteMe = RemoteObject.declareNull("b4i.sdimagedemo.b4i_main");
        //anywheresoftware.b4a.pc.RapidSub.moduleToObject.put("b4i.sdimagedemo.b4i_main", "b4i.sdimagedemo.b4i_main");
	}
    public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		RDebug.INSTANCE.waitForTask();

	}
    private static PCBA pcBA = new PCBA(null, b4i_main.class);
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public static RemoteObject getObject() {
		return remoteMe;
	 }
	public PCBA create(Object[] args) throws ClassNotFoundException{
		ba = (RemoteObject) args[1];
        remoteMe = (RemoteObject) args[2];
        __c = (RemoteObject)args[3];
		pcBA = new PCBA(this, b4i_main.class);
        try {
            BA.init();
            b4i_main_subs_0._process_globals();

        } catch(Exception e) {
            throw new RuntimeException(e);
        }
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("B4ICommon");
public static RemoteObject _app = RemoteObject.declareNull("B4IApplicationWrapper");
public static RemoteObject _navcontrol = RemoteObject.declareNull("B4INavigationControllerWrapper");
public static RemoteObject _page1 = RemoteObject.declareNull("B4IPage");
public static RemoteObject _imageview1 = RemoteObject.declareNull("B4IImageViewWrapper");
public static RemoteObject _imageview2 = RemoteObject.declareNull("B4IImageViewWrapper");
public static RemoteObject _imageview3 = RemoteObject.declareNull("B4IImageViewWrapper");
public static RemoteObject _imageview4 = RemoteObject.declareNull("B4IImageViewWrapper");
public static RemoteObject _imageview6 = RemoteObject.declareNull("B4IImageViewWrapper");
public static RemoteObject _imageview5 = RemoteObject.declareNull("B4IImageViewWrapper");
public static RemoteObject _sdimgldr = RemoteObject.declareNull("iSDWebImage");
public static RemoteObject _bmpholder = RemoteObject.declareNull("B4IBitmap");
  public Object[] GetGlobals() {
		return new Object[] {"App",b4i_main._app,"bmpholder",b4i_main._bmpholder,"ImageView1",b4i_main._imageview1,"ImageView2",b4i_main._imageview2,"ImageView3",b4i_main._imageview3,"ImageView4",b4i_main._imageview4,"ImageView5",b4i_main._imageview5,"ImageView6",b4i_main._imageview6,"NavControl",b4i_main._navcontrol,"Page1",b4i_main._page1,"sdimgldr",b4i_main._sdimgldr};
}
}