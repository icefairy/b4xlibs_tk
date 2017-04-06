package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class main extends Object{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
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
public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.object.ServerWrapper _ser = null;
public static b4j.example.g _g = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 23;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return false;
}
public static String  _appstart(String[] _args) throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub AppStart (Args() As String)";
 //BA.debugLineNum = 13;BA.debugLine="ser.Initialize(\"ser\")";
_ser.Initialize(ba,"ser");
 //BA.debugLineNum = 14;BA.debugLine="ser.Port=888";
_ser.setPort((int) (888));
 //BA.debugLineNum = 15;BA.debugLine="ser.StaticFilesFolder=\"www\"";
_ser.setStaticFilesFolder("www");
 //BA.debugLineNum = 16;BA.debugLine="ser.AddHandler(\"/test\",\"test\",False)";
_ser.AddHandler("/test","test",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 17;BA.debugLine="ser.Start";
_ser.Start();
 //BA.debugLineNum = 18;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
g._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Dim ser As Server";
_ser = new anywheresoftware.b4j.object.ServerWrapper();
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
}
