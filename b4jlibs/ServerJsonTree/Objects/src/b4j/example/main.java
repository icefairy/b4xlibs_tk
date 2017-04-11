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
public static int _nport = 0;
public static b4j.example.common _common = null;
public static String  _appstart(String[] _args) throws Exception{
String _ts = "";
 //BA.debugLineNum = 12;BA.debugLine="Sub AppStart (Args() As String)";
 //BA.debugLineNum = 15;BA.debugLine="If Args.Length>0 Then";
if (_args.length>0) { 
 //BA.debugLineNum = 16;BA.debugLine="If Args(0).IndexOf(\"port\")>-1 Then";
if (_args[(int) (0)].indexOf("port")>-1) { 
 //BA.debugLineNum = 17;BA.debugLine="Dim ts As String=Args(0).Replace(\"port=\",\"\").Re";
_ts = _args[(int) (0)].replace("port=","").replace("-","");
 //BA.debugLineNum = 18;BA.debugLine="If IsNumber(ts) Then nPort=ts";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_ts)) { 
_nport = (int)(Double.parseDouble(_ts));};
 };
 };
 //BA.debugLineNum = 21;BA.debugLine="srvr.Initialize(\"srvr\")";
_srvr.Initialize(ba,"srvr");
 //BA.debugLineNum = 22;BA.debugLine="srvr.Port = nPort";
_srvr.setPort(_nport);
 //BA.debugLineNum = 23;BA.debugLine="srvr.StaticFilesFolder=File.DirApp&\"/www\"";
_srvr.setStaticFilesFolder(anywheresoftware.b4a.keywords.Common.File.getDirApp()+"/www");
 //BA.debugLineNum = 25;BA.debugLine="srvr.LogsFileFolder=File.DirTemp&\"/logs\"";
_srvr.setLogsFileFolder(anywheresoftware.b4a.keywords.Common.File.getDirTemp()+"/logs");
 //BA.debugLineNum = 27;BA.debugLine="srvr.AddHandler(\"/jsonHelper\", \"JsonHelper\", Fals";
_srvr.AddHandler("/jsonHelper","JsonHelper",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 28;BA.debugLine="srvr.AddHandler(\"/json2type\", \"json2type\", False)";
_srvr.AddHandler("/json2type","json2type",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 30;BA.debugLine="srvr.AddHandler(\"/jsonHelper2java\", \"JsonHelper2J";
_srvr.AddHandler("/jsonHelper2java","JsonHelper2Java",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 31;BA.debugLine="srvr.AddHandler(\"/xml2code\",\"xml2code\",False)";
_srvr.AddHandler("/xml2code","xml2code",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 32;BA.debugLine="srvr.Start";
_srvr.Start();
 //BA.debugLineNum = 33;BA.debugLine="Log(\"Server started\")";
anywheresoftware.b4a.keywords.Common.Log("Server started");
 //BA.debugLineNum = 34;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
common._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Private srvr As Server";
_srvr = new anywheresoftware.b4j.object.ServerWrapper();
 //BA.debugLineNum = 9;BA.debugLine="Private nPort As Int=88";
_nport = (int) (88);
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
}
