package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class main extends Object{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.ShellBA("b4j.example", "b4j.example.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			anywheresoftware.b4a.ShellBA.delegateBA = new anywheresoftware.b4a.StandardBA("b4j.example", null, null);
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.main", ba);
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


private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.object.ServerWrapper _srvr = null;
public static b4j.example.abmshared _abmshared = null;
public static b4j.example.dbm _dbm = null;
public static String  _appstart(String[] _args) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "appstart"))
	return (String) Debug.delegate(ba, "appstart", new Object[] {_args});
b4j.example.abmapplication _myapp = null;
b4j.example.abmpagetemplate _mypage = null;
RDebugUtils.currentLine=65536;
 //BA.debugLineNum = 65536;BA.debugLine="Sub AppStart (Args() As String)";
RDebugUtils.currentLine=65541;
 //BA.debugLineNum = 65541;BA.debugLine="ABMShared.BuildTheme(\"mytheme\")";
_abmshared._buildtheme("mytheme");
RDebugUtils.currentLine=65544;
 //BA.debugLineNum = 65544;BA.debugLine="Dim myApp As ABMApplication";
_myapp = new b4j.example.abmapplication();
RDebugUtils.currentLine=65545;
 //BA.debugLineNum = 65545;BA.debugLine="myApp.Initialize";
_myapp._initialize(null,ba);
RDebugUtils.currentLine=65546;
 //BA.debugLineNum = 65546;BA.debugLine="DBM.InitializeMySQL(\"jdbc:mysql://127.0.0.1:3306/";
_dbm._initializemysql("jdbc:mysql://127.0.0.1:3306/zfbdb?characterEncoding=utf8","root","root",(int) (100));
RDebugUtils.currentLine=65549;
 //BA.debugLineNum = 65549;BA.debugLine="Dim myPage As ABMPageTemplate";
_mypage = new b4j.example.abmpagetemplate();
RDebugUtils.currentLine=65550;
 //BA.debugLineNum = 65550;BA.debugLine="myPage.Initialize";
_mypage._initialize(null,ba);
RDebugUtils.currentLine=65553;
 //BA.debugLineNum = 65553;BA.debugLine="myApp.AddPage(myPage.Page)";
_myapp._addpage(null,_mypage._page);
RDebugUtils.currentLine=65556;
 //BA.debugLineNum = 65556;BA.debugLine="myApp.StartServer(srvr, \"srvr\", 51042)";
_myapp._startserver(null,_srvr,"srvr",(int) (51042));
RDebugUtils.currentLine=65558;
 //BA.debugLineNum = 65558;BA.debugLine="ABMShared.RedirectOutput(File.DirApp, \"logs.txt\")";
_abmshared._redirectoutput(anywheresoftware.b4a.keywords.Common.File.getDirApp(),"logs.txt");
RDebugUtils.currentLine=65560;
 //BA.debugLineNum = 65560;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
RDebugUtils.currentLine=65561;
 //BA.debugLineNum = 65561;BA.debugLine="End Sub";
return "";
}
}