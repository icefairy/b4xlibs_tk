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
public static anywheresoftware.b4a.objects.collections.List _mdata = null;
public static String _surl163 = "";
public static int _num = 0;
public static long _tlasttickets = 0L;
public static int _nreqminsecond = 0;
public static boolean _bloading = false;
public static anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator _jsg = null;
public static int _napiidx = 0;
public static b4j.example.httputils2service _httputils2service = null;
public static String  _appstart(String[] _args) throws Exception{
 //BA.debugLineNum = 22;BA.debugLine="Sub AppStart (Args() As String)";
 //BA.debugLineNum = 23;BA.debugLine="initdata";
_initdata();
 //BA.debugLineNum = 24;BA.debugLine="ser.Initialize(\"ser\")";
_ser.Initialize(ba,"ser");
 //BA.debugLineNum = 25;BA.debugLine="ser.StaticFilesFolder=File.DirApp&\"/www\"";
_ser.setStaticFilesFolder(anywheresoftware.b4a.keywords.Common.File.getDirApp()+"/www");
 //BA.debugLineNum = 26;BA.debugLine="ser.LogsFileFolder=File.DirTemp";
_ser.setLogsFileFolder(anywheresoftware.b4a.keywords.Common.File.getDirTemp());
 //BA.debugLineNum = 27;BA.debugLine="ser.Port=888";
_ser.setPort((int) (888));
 //BA.debugLineNum = 28;BA.debugLine="ser.AddHandler(\"/getsscdata\",\"getsscdata\",False)";
_ser.AddHandler("/getsscdata","getsscdata",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 29;BA.debugLine="ser.Start";
_ser.Start();
 //BA.debugLineNum = 30;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public static String  _getdatajson() throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Public Sub getDataJson As String";
 //BA.debugLineNum = 36;BA.debugLine="jsg.Initialize2(mData)";
_jsg.Initialize2(_mdata);
 //BA.debugLineNum = 37;BA.debugLine="Return jsg.ToString";
if (true) return _jsg.ToString();
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _initdata() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Private Sub initdata";
 //BA.debugLineNum = 33;BA.debugLine="mData.Initialize";
_mdata.Initialize();
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4j.example.httputils2service._process_globals();
main._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Public ser As Server";
_ser = new anywheresoftware.b4j.object.ServerWrapper();
 //BA.debugLineNum = 9;BA.debugLine="Public mData As List";
_mdata = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 12;BA.debugLine="Public sUrl163 As String=\"http://trend.caipiao.16";
_surl163 = "http://trend.caipiao.163.com/cqssc/jiben-5xing.html";
 //BA.debugLineNum = 13;BA.debugLine="Public num As Int=30";
_num = (int) (30);
 //BA.debugLineNum = 15;BA.debugLine="Public tLastTickets As Long=1";
_tlasttickets = (long) (1);
 //BA.debugLineNum = 16;BA.debugLine="Public nReqMinSecond As Int=30";
_nreqminsecond = (int) (30);
 //BA.debugLineNum = 17;BA.debugLine="Public bLoading As Boolean";
_bloading = false;
 //BA.debugLineNum = 18;BA.debugLine="Public jsg As JSONGenerator";
_jsg = new anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 19;BA.debugLine="Public nApiIdx As Int=0";
_napiidx = (int) (0);
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
}
