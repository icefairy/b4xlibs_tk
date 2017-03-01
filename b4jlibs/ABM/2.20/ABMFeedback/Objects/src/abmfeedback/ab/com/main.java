package abmfeedback.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class main extends Object{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.StandardBA("abmfeedback.ab.com", "abmfeedback.ab.com.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "abmfeedback.ab.com.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) throws Exception{
        try {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program started.");
            initializeProcessGlobals();
            ba.raiseEvent(null, "appstart", (Object)args);
        } catch (Throwable t) {
			BA.printException(t, true);
		
        } finally {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program terminated (StartMessageLoop was not called).");
        }
    }
public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.object.ServerWrapper _srvr = null;
public static abmfeedback.ab.com.abmshared _abmshared = null;
public static abmfeedback.ab.com.dbm _dbm = null;
public static String  _appstart(String[] _args) throws Exception{
abmfeedback.ab.com.abmapplication _myapp = null;
abmfeedback.ab.com.overviewcasespage _overviewcasesp = null;
abmfeedback.ab.com.userspage _usersp = null;
 //BA.debugLineNum = 16;BA.debugLine="Sub AppStart (Args() As String)";
 //BA.debugLineNum = 18;BA.debugLine="ABMShared.BuildTheme(\"mytheme\")";
_abmshared._buildtheme("mytheme");
 //BA.debugLineNum = 20;BA.debugLine="ABMShared.NeedsAuthorization = True";
_abmshared._needsauthorization = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 26;BA.debugLine="DBM.InitializeMySQL(\"jdbc:mysql://81.165.232.188:";
_dbm._initializemysql("jdbc:mysql://81.165.232.188:8082/abmfeedback?characterEncoding=utf8","ubuntu","thunder",(int) (100));
 //BA.debugLineNum = 29;BA.debugLine="DBM.CreateTablesIfNeeded";
_dbm._createtablesifneeded();
 //BA.debugLineNum = 32;BA.debugLine="Dim myApp As ABMApplication";
_myapp = new abmfeedback.ab.com.abmapplication();
 //BA.debugLineNum = 33;BA.debugLine="myApp.Initialize";
_myapp._initialize(ba);
 //BA.debugLineNum = 36;BA.debugLine="Dim overviewcasesp As OverviewCasesPage";
_overviewcasesp = new abmfeedback.ab.com.overviewcasespage();
 //BA.debugLineNum = 37;BA.debugLine="overviewcasesp.Initialize";
_overviewcasesp._initialize(ba);
 //BA.debugLineNum = 38;BA.debugLine="Dim usersp As UsersPage";
_usersp = new abmfeedback.ab.com.userspage();
 //BA.debugLineNum = 39;BA.debugLine="usersp.Initialize";
_usersp._initialize(ba);
 //BA.debugLineNum = 42;BA.debugLine="myApp.AddPage(overviewcasesp.Page)";
_myapp._addpage(_overviewcasesp._page);
 //BA.debugLineNum = 43;BA.debugLine="myApp.AddPage(usersp.Page)";
_myapp._addpage(_usersp._page);
 //BA.debugLineNum = 46;BA.debugLine="myApp.StartServer(srvr, \"srvr\", 51044)";
_myapp._startserver(_srvr,"srvr",(int) (51044));
 //BA.debugLineNum = 51;BA.debugLine="ABMShared.RedirectOutput(File.DirApp, \"logs.txt\")";
_abmshared._redirectoutput(anywheresoftware.b4a.keywords.Common.File.getDirApp(),"logs.txt");
 //BA.debugLineNum = 53;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
abmshared._process_globals();
dbm._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 13;BA.debugLine="Public srvr As Server";
_srvr = new anywheresoftware.b4j.object.ServerWrapper();
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
}
