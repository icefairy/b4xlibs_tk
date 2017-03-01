
package b4j.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class abmpagetemplatealternative {
    public static RemoteObject myClass;
	public abmpagetemplatealternative() {
	}
    public static PCBA staticBA = new PCBA(null, abmpagetemplatealternative.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _ws = RemoteObject.declareNull("anywheresoftware.b4j.object.WebSocket");
public static RemoteObject _page = RemoteObject.declareNull("com.ab.abmaterial.ABMPage");
public static RemoteObject _theme = RemoteObject.declareNull("com.ab.abmaterial.ABMTheme");
public static RemoteObject _abm = RemoteObject.declareNull("com.ab.abmaterial.ABMaterial");
public static RemoteObject _name = RemoteObject.createImmutable("");
public static RemoteObject _abmpageid = RemoteObject.createImmutable("");
public static b4j.example.main _main = null;
public static b4j.example.abmshared _abmshared = null;
public static b4j.example.dbm _dbm = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"ABM",_ref.getField(false, "_abm"),"ABMPageId",_ref.getField(false, "_abmpageid"),"Name",_ref.getField(false, "_name"),"page",_ref.getField(false, "_page"),"theme",_ref.getField(false, "_theme"),"ws",_ref.getField(false, "_ws")};
}
}