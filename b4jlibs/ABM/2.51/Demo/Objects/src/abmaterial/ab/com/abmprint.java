package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class abmprint extends Object{
public static abmprint mostCurrent = new abmprint();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.abmprint", null);
		ba.loadHtSubs(abmprint.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "abmaterial.ab.com.abmprint", ba);
		}
	}
    public static Class<?> getObject() {
		return abmprint.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static b4j.example.dateutils _dateutils = null;
public static abmaterial.ab.com.main _main = null;
public static abmaterial.ab.com.abmshared _abmshared = null;
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
}
