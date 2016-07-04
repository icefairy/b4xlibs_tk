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
public static anywheresoftware.b4a.objects.Timer _tmr = null;
public static int _nshouttmr = 0;
public static int _nlongtmr = 0;
public static String _surl163 = "";
public static int _num = 0;
public static String _slastqh = "";
public static boolean _bloading = false;
public static anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator _jsg = null;
public static b4j.example.httputils2service _httputils2service = null;
public static String  _appstart(String[] _args) throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Sub AppStart (Args() As String)";
 //BA.debugLineNum = 20;BA.debugLine="initdata";
_initdata();
 //BA.debugLineNum = 21;BA.debugLine="ser.Initialize(\"ser\")";
_ser.Initialize(ba,"ser");
 //BA.debugLineNum = 22;BA.debugLine="ser.StaticFilesFolder=File.DirApp&\"/www\"";
_ser.setStaticFilesFolder(anywheresoftware.b4a.keywords.Common.File.getDirApp()+"/www");
 //BA.debugLineNum = 23;BA.debugLine="ser.LogsFileFolder=File.DirTemp";
_ser.setLogsFileFolder(anywheresoftware.b4a.keywords.Common.File.getDirTemp());
 //BA.debugLineNum = 24;BA.debugLine="ser.Port=888";
_ser.setPort((int) (888));
 //BA.debugLineNum = 25;BA.debugLine="ser.AddHandler(\"/getsscdata\",\"getsscdata\",False)";
_ser.AddHandler("/getsscdata","getsscdata",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 26;BA.debugLine="ser.Start";
_ser.Start();
 //BA.debugLineNum = 27;BA.debugLine="tmr.Initialize(\"getdata\",60000)";
_tmr.Initialize(ba,"getdata",(long) (60000));
 //BA.debugLineNum = 28;BA.debugLine="tmr.Enabled=True";
_tmr.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 29;BA.debugLine="getdata_Tick";
_getdata_tick();
 //BA.debugLineNum = 30;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public static String  _getdata_tick() throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Sub getdata_Tick";
 //BA.debugLineNum = 37;BA.debugLine="getsscdata163";
_getsscdata163();
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _getdatajson() throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Public Sub getDataJson As String";
 //BA.debugLineNum = 90;BA.debugLine="jsg.Initialize2(mData)";
_jsg.Initialize2(_mdata);
 //BA.debugLineNum = 91;BA.debugLine="Return jsg.ToString";
if (true) return _jsg.ToString();
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return "";
}
public static String  _getsscdata163() throws Exception{
b4j.example.httpjob _hj = null;
 //BA.debugLineNum = 81;BA.debugLine="Public Sub getsscdata163";
 //BA.debugLineNum = 82;BA.debugLine="Log(\"get once\")";
anywheresoftware.b4a.keywords.Common.Log("get once");
 //BA.debugLineNum = 83;BA.debugLine="bLoading=True";
_bloading = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 84;BA.debugLine="Dim hj As HttpJob";
_hj = new b4j.example.httpjob();
 //BA.debugLineNum = 85;BA.debugLine="hj.Initialize(\"getdata\",Me)";
_hj._initialize(ba,"getdata",main.getObject());
 //BA.debugLineNum = 86;BA.debugLine="If num<>30 And num<>50 And num<>100 Then num=30";
if (_num!=30 && _num!=50 && _num!=100) { 
_num = (int) (30);};
 //BA.debugLineNum = 87;BA.debugLine="hj.Download($\"http://trend.caipiao.163.com/cqssc/";
_hj._download(("http://trend.caipiao.163.com/cqssc/jiben-5xing.html?periodNumber="+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_num))+""));
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public static String  _initdata() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Private Sub initdata";
 //BA.debugLineNum = 33;BA.debugLine="mData.Initialize";
_mdata.Initialize();
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4j.example.httpjob _thj) throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Sub JobDone(thj As HttpJob)";
 //BA.debugLineNum = 40;BA.debugLine="Log(\"Job:\"&thj.Success)";
anywheresoftware.b4a.keywords.Common.Log("Job:"+BA.ObjectToString(_thj._success));
 //BA.debugLineNum = 41;BA.debugLine="If thj.Success Then";
if (_thj._success) { 
 //BA.debugLineNum = 42;BA.debugLine="mData=ParseSSC_163(thj.GetString)";
_mdata = _parsessc_163(_thj._getstring());
 //BA.debugLineNum = 43;BA.debugLine="Log(\"load ok once\")";
anywheresoftware.b4a.keywords.Common.Log("load ok once");
 }else {
 //BA.debugLineNum = 45;BA.debugLine="Log(\"joberror:\"&thj.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("joberror:"+_thj._errormessage);
 };
 //BA.debugLineNum = 47;BA.debugLine="thj.Release";
_thj._release();
 //BA.debugLineNum = 48;BA.debugLine="bLoading=False";
_bloading = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _parsessc_163(String _str) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _mc = null;
String _str1 = "";
anywheresoftware.b4a.objects.collections.Map _s1 = null;
String _qh = "";
String _hm = "";
 //BA.debugLineNum = 50;BA.debugLine="Private Sub ParseSSC_163(str As String) As List";
 //BA.debugLineNum = 51;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 52;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 53;BA.debugLine="Dim mc As Matcher=Regex.Matcher($\"\\d{9}\">\\d{5} </";
_mc = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_mc = anywheresoftware.b4a.keywords.Common.Regex.Matcher(("\\d{9}\">\\d{5} </span>"),_str);
 //BA.debugLineNum = 54;BA.debugLine="Dim str1 As String";
_str1 = "";
 //BA.debugLineNum = 55;BA.debugLine="Do While mc.Find";
while (_mc.Find()) {
 //BA.debugLineNum = 56;BA.debugLine="str1=mc.Match";
_str1 = _mc.getMatch();
 //BA.debugLineNum = 57;BA.debugLine="Dim s1 As Map,qh As String,hm As String";
_s1 = new anywheresoftware.b4a.objects.collections.Map();
_qh = "";
_hm = "";
 //BA.debugLineNum = 58;BA.debugLine="qh=str1.SubString2(0,str1.IndexOf(\"\"\"\"))";
_qh = _str1.substring((int) (0),_str1.indexOf("\""));
 //BA.debugLineNum = 59;BA.debugLine="hm=str1.SubString2(str1.IndexOf(\">\")+1,str1.Last";
_hm = _str1.substring((int) (_str1.indexOf(">")+1),(int) (_str1.lastIndexOf("<")-1));
 //BA.debugLineNum = 60;BA.debugLine="s1.Initialize";
_s1.Initialize();
 //BA.debugLineNum = 61;BA.debugLine="s1.Put(\"qh\",qh)";
_s1.Put((Object)("qh"),(Object)(_qh));
 //BA.debugLineNum = 62;BA.debugLine="s1.Put(\"hm\",hm)";
_s1.Put((Object)("hm"),(Object)(_hm));
 //BA.debugLineNum = 63;BA.debugLine="lst.InsertAt(0,s1)";
_lst.InsertAt((int) (0),(Object)(_s1.getObject()));
 //BA.debugLineNum = 64;BA.debugLine="str1=qh";
_str1 = _qh;
 }
;
 //BA.debugLineNum = 66;BA.debugLine="If sLastQH.Length>0 And sLastQH.CompareTo(str1)=0";
if (_slastqh.length()>0 && _slastqh.compareTo(_str1)==0 && _str1.length()>0) { 
 //BA.debugLineNum = 68;BA.debugLine="tmr.Interval=nLongTmr";
_tmr.setInterval((long) (_nlongtmr));
 //BA.debugLineNum = 69;BA.debugLine="sLastQH=str1";
_slastqh = _str1;
 }else if(_slastqh.length()<1) { 
 //BA.debugLineNum = 71;BA.debugLine="sLastQH=str1";
_slastqh = _str1;
 }else {
 //BA.debugLineNum = 73;BA.debugLine="tmr.Interval=nShoutTmr";
_tmr.setInterval((long) (_nshouttmr));
 };
 //BA.debugLineNum = 75;BA.debugLine="Log(tmr.Interval)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_tmr.getInterval()));
 //BA.debugLineNum = 76;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return null;
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
 //BA.debugLineNum = 10;BA.debugLine="Public tmr As Timer";
_tmr = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 11;BA.debugLine="Public nShoutTmr As Int=60000,nLongTmr As Int=300";
_nshouttmr = (int) (60000);
_nlongtmr = (int) (300000);
 //BA.debugLineNum = 12;BA.debugLine="Public sUrl163 As String=\"http://trend.caipiao.16";
_surl163 = "http://trend.caipiao.163.com/cqssc/jiben-5xing.html";
 //BA.debugLineNum = 13;BA.debugLine="Public num As Int=30";
_num = (int) (30);
 //BA.debugLineNum = 14;BA.debugLine="Public sLastQH as String=\"\"";
_slastqh = "";
 //BA.debugLineNum = 15;BA.debugLine="Public bLoading As Boolean";
_bloading = false;
 //BA.debugLineNum = 16;BA.debugLine="Public jsg As JSONGenerator";
_jsg = new anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
}
