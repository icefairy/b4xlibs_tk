
package b4j.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class abmapplication {
    public static RemoteObject myClass;
	public abmapplication() {
	}
    public static PCBA staticBA = new PCBA(null, abmapplication.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _initialpage = RemoteObject.createImmutable("");
public static RemoteObject _apppage = RemoteObject.declareNull("com.ab.abmaterial.ABMPage");
public static RemoteObject _theme = RemoteObject.declareNull("com.ab.abmaterial.ABMTheme");
public static RemoteObject _ws = RemoteObject.declareNull("anywheresoftware.b4j.object.WebSocket");
public static RemoteObject _abm = RemoteObject.declareNull("com.ab.abmaterial.ABMaterial");
public static RemoteObject _pages = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _pageneedsupload = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _abmpageid = RemoteObject.createImmutable("");
public static b4j.example.main _main = null;
public static b4j.example.abmshared _abmshared = null;
public static b4j.example.dbm _dbm = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"ABM",_ref.getField(false, "_abm"),"ABMPageId",_ref.getField(false, "_abmpageid"),"AppPage",_ref.getField(false, "_apppage"),"InitialPage",_ref.getField(false, "_initialpage"),"PageNeedsUpload",_ref.getField(false, "_pageneedsupload"),"Pages",_ref.getField(false, "_pages"),"theme",_ref.getField(false, "_theme"),"ws",_ref.getField(false, "_ws")};
}
}