
package b4j.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class abmcachescavenger {
    public static RemoteObject myClass;
	public abmcachescavenger() {
	}
    public static PCBA staticBA = new PCBA(null, abmcachescavenger.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _scavengetimer = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _abm = RemoteObject.declareNull("com.ab.abmaterial.ABMaterial");
public static b4j.example.main _main = null;
public static b4j.example.abmshared _abmshared = null;
public static b4j.example.dbm _dbm = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"ABM",_ref.getField(false, "_abm"),"scavengeTimer",_ref.getField(false, "_scavengetimer")};
}
}