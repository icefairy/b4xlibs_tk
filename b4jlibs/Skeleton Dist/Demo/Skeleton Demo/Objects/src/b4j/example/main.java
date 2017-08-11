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
public static anywheresoftware.b4j.object.ServerWrapper _srvr = null;
public static String  _appstart(String[] _args) throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub AppStart (Args() As String)";
 //BA.debugLineNum = 15;BA.debugLine="srvr.Initialize(\"\")";
_srvr.Initialize(ba,"");
 //BA.debugLineNum = 16;BA.debugLine="srvr.Port = 80";
_srvr.setPort((int) (80));
 //BA.debugLineNum = 18;BA.debugLine="srvr.AddHandler(\"/quick1\",\"QuickStart1\",True)";
_srvr.AddHandler("/quick1","QuickStart1",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 19;BA.debugLine="srvr.AddHandler(\"/quick2\",\"QuickStart2\",True)";
_srvr.AddHandler("/quick2","QuickStart2",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 20;BA.debugLine="srvr.AddHandler(\"/demo1\",\"Demo\",True)";
_srvr.AddHandler("/demo1","Demo",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 21;BA.debugLine="srvr.AddHandler(\"/demo2\",\"Demo2\",True)";
_srvr.AddHandler("/demo2","Demo2",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 23;BA.debugLine="srvr.LogsRetainDays = 7";
_srvr.setLogsRetainDays((int) (7));
 //BA.debugLineNum = 24;BA.debugLine="srvr.LogWaitingMessages = False";
_srvr.LogWaitingMessages = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 26;BA.debugLine="srvr.Start";
_srvr.Start();
 //BA.debugLineNum = 31;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Private srvr As Server";
_srvr = new anywheresoftware.b4j.object.ServerWrapper();
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
}
