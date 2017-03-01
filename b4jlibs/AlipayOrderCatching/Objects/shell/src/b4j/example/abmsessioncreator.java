
package b4j.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class abmsessioncreator {
    public static RemoteObject myClass;
	public abmsessioncreator() {
	}
    public static PCBA staticBA = new PCBA(null, abmsessioncreator.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static b4j.example.main _main = null;
public static b4j.example.abmshared _abmshared = null;
public static b4j.example.dbm _dbm = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {};
}
}