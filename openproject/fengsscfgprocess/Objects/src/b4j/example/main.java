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
public static String  _appstart(String[] _args) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "appstart"))
	return (String) Debug.delegate(ba, "appstart", new Object[] {_args});
String _js = "";
RDebugUtils.currentLine=65536;
 //BA.debugLineNum = 65536;BA.debugLine="Sub AppStart (Args() As String)";
RDebugUtils.currentLine=65537;
 //BA.debugLineNum = 65537;BA.debugLine="Dim js As String=$\"{\"index\":0,\"random\":false,\"glo";
_js = ("{\"index\":0,\"random\":false,\"global\":false,\"enabled\":true,\"shareOverLan\":false,\"isDefault\":false,\"localPort\":1080,\"pacUrl\":null,\"useOnlinePac\":false,\"reconnectTimes\":3,\"randomAlgorithm\":0,\"TTL\":0,\"proxyEnable\":false,\"proxyType\":0,\"proxyHost\":null,\"proxyPort\":0,\"proxyAuthUser\":null,\"proxyAuthPass\":null,\"authUser\":null,\"authPass\":null,\"autoban\":false,\"configs\":[{\"remarks\":\"\\u7f8e\\u56fd\\u6d1b\\u6749\\u77f6-SS\",\"server\":\"45.63.50.100\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"576O5Zu95rSb5p2J55+2LVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u7f8e\\u56fd\\u897f\\u96c5\\u56fe-SS\",\"server\":\"45.32.226.152\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"576O5Zu96KW\\/6ZuF5Zu+LVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u7f8e\\u56fd\\u7845\\u8c37-SS\",\"server\":\"104.207.148.199\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"576O5Zu956GF6LC3LVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u65e5\\u672c\\u4e1c\\u4eac-SS\",\"server\":\"108.61.186.221\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"5pel5pys5Lic5LqsLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u65b0\\u52a0\\u5761-SS\",\"server\":\"128.199.209.89\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"5paw5Yqg5Z2hLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u65b0\\u52a0\\u57611-SS\",\"server\":\"128.199.70.72\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"5paw5Yqg5Z2hMS1TUw==\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u7f8e\\u56fd\\u65e7\\u91d1\\u5c71-SS\",\"server\":\"138.68.0.27\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"576O5Zu95pen6YeR5bGxLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u65e5\\u672c\\u4e1c\\u4eac1-SS\",\"server\":\"45.63.124.213\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"5pel5pys5Lic5LqsMS1TUw==\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u97e9\\u56fdKT-SS\",\"server\":\"45.249.90.12\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6Z+p5Zu9S1QtU1M=\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u65e5\\u672c\\u5927\\u962a-SS\",\"server\":\"103.204.172.20\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"5pel5pys5aSn6ZiqLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u97e9\\u56fdBGP-SS\",\"server\":\"103.214.68.116\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6Z+p5Zu9QkdQLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u7f8e\\u56fdCN2-SS\",\"server\":\"107.151.139.226\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"576O5Zu9Q04yLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u9999\\u6e2f\\u6c99\\u7530-SS\",\"server\":\"103.214.195.87\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6aaZ5riv5rKZ55SwLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u7f8e\\u56fdC3-SS\",\"server\":\"103.219.193.37\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"576O5Zu9QzMtU1M=\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u9999\\u6e2f\\u65b0\\u4e16\\u754c-SS\",\"server\":\"198.44.190.50\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6aaZ5riv5paw5LiW55WMLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u82f1\\u56fd\\u4f26\\u6566-SS\",\"server\":\"104.238.185.74 \",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6Iux5Zu95Lym5pWmLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u9999\\u6e2f\\u963f\\u91cc\\u4e91-SS\",\"server\":\"47.90.48.169\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6aaZ5riv6Zi\\/6YeM5LqRLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u97e9\\u56fd\\u4f18\\u5316KT\\uff0c\\u6700\\u597d\\u7684\\u97e9\\u56fd\\u7ebf\\u8def-SS\",\"server\":\"183.110.233.242\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6Z+p5Zu95LyY5YyWS1TvvIzmnIDlpb3nmoTpn6nlm73nur\\/ot68tU1M=\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true}]}");
RDebugUtils.currentLine=65538;
 //BA.debugLineNum = 65538;BA.debugLine="processdata(js)";
_processdata(_js);
RDebugUtils.currentLine=65539;
 //BA.debugLineNum = 65539;BA.debugLine="End Sub";
return "";
}
public static String  _processdata(String _js) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "processdata"))
	return (String) Debug.delegate(ba, "processdata", new Object[] {_js});
anywheresoftware.b4j.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
String _shareoverlan = "";
anywheresoftware.b4a.objects.collections.List _configs = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.collections.Map _colconfigs = null;
String _server = "";
String _method = "";
String _udp_over_tcp = "";
String _tcp_over_udp = "";
String _password = "";
String _protocol = "";
String _obfs = "";
String _remarks_base64 = "";
String _obfs_udp = "";
String _enable = "";
int _server_port = 0;
String _obfsparam = "";
String _remarks = "";
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Private Sub processdata(js As String)";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4j.objects.collections.JSONParser();
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="parser.Initialize(js)";
_parser.Initialize(_js);
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="Dim shareOverLan As String = root.GetDefault(\"sha";
_shareoverlan = BA.ObjectToString(_root.GetDefault((Object)("shareOverLan"),(Object)("")));
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="Dim configs As List = root.Get(\"configs\")";
_configs = new anywheresoftware.b4a.objects.collections.List();
_configs.setObject((java.util.List)(_root.Get((Object)("configs"))));
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="For Each colconfigs As Map In configs";
_colconfigs = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group8 = _configs;
final int groupLen8 = group8.getSize();
for (int index8 = 0;index8 < groupLen8 ;index8++){
_colconfigs.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group8.Get(index8)));
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="Dim server As String = colconfigs.GetDefault(";
_server = BA.ObjectToString(_colconfigs.GetDefault((Object)("server"),(Object)("")));
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="Dim method As String = colconfigs.GetDefault(";
_method = BA.ObjectToString(_colconfigs.GetDefault((Object)("method"),(Object)("")));
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="Dim udp_over_tcp As String = colconfigs.GetDe";
_udp_over_tcp = BA.ObjectToString(_colconfigs.GetDefault((Object)("udp_over_tcp"),(Object)("")));
RDebugUtils.currentLine=851980;
 //BA.debugLineNum = 851980;BA.debugLine="Dim tcp_over_udp As String = colconfigs.GetDe";
_tcp_over_udp = BA.ObjectToString(_colconfigs.GetDefault((Object)("tcp_over_udp"),(Object)("")));
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="Dim password As String = colconfigs.GetDefaul";
_password = BA.ObjectToString(_colconfigs.GetDefault((Object)("password"),(Object)("")));
RDebugUtils.currentLine=851982;
 //BA.debugLineNum = 851982;BA.debugLine="Dim protocol As String = colconfigs.GetDefaul";
_protocol = BA.ObjectToString(_colconfigs.GetDefault((Object)("protocol"),(Object)("")));
RDebugUtils.currentLine=851983;
 //BA.debugLineNum = 851983;BA.debugLine="Dim obfs As String = colconfigs.GetDefault(\"o";
_obfs = BA.ObjectToString(_colconfigs.GetDefault((Object)("obfs"),(Object)("")));
RDebugUtils.currentLine=851984;
 //BA.debugLineNum = 851984;BA.debugLine="Dim remarks_base64 As String = colconfigs.Get";
_remarks_base64 = BA.ObjectToString(_colconfigs.GetDefault((Object)("remarks_base64"),(Object)("")));
RDebugUtils.currentLine=851985;
 //BA.debugLineNum = 851985;BA.debugLine="Dim obfs_udp As String = colconfigs.GetDefaul";
_obfs_udp = BA.ObjectToString(_colconfigs.GetDefault((Object)("obfs_udp"),(Object)("")));
RDebugUtils.currentLine=851986;
 //BA.debugLineNum = 851986;BA.debugLine="Dim enable As String = colconfigs.GetDefault(";
_enable = BA.ObjectToString(_colconfigs.GetDefault((Object)("enable"),(Object)("")));
RDebugUtils.currentLine=851987;
 //BA.debugLineNum = 851987;BA.debugLine="Dim server_port As Int = colconfigs.GetDefaul";
_server_port = (int)(BA.ObjectToNumber(_colconfigs.GetDefault((Object)("server_port"),(Object)(0))));
RDebugUtils.currentLine=851988;
 //BA.debugLineNum = 851988;BA.debugLine="Dim obfsparam As String = colconfigs.GetDefau";
_obfsparam = BA.ObjectToString(_colconfigs.GetDefault((Object)("obfsparam"),(Object)("")));
RDebugUtils.currentLine=851989;
 //BA.debugLineNum = 851989;BA.debugLine="Dim remarks As String = colconfigs.GetDefault";
_remarks = BA.ObjectToString(_colconfigs.GetDefault((Object)("remarks"),(Object)("")));
RDebugUtils.currentLine=851990;
 //BA.debugLineNum = 851990;BA.debugLine="sb.Append(\"proxy = ss://\"&method&\":\"&password&\"@";
_sb.Append("proxy = ss://"+_method+":"+_password+"@"+_server+":"+BA.NumberToString(_server_port)+anywheresoftware.b4a.keywords.Common.CRLF);
 }
;
RDebugUtils.currentLine=851992;
 //BA.debugLineNum = 851992;BA.debugLine="Log(sb.ToString)";
anywheresoftware.b4a.keywords.Common.Log(_sb.ToString());
RDebugUtils.currentLine=851993;
 //BA.debugLineNum = 851993;BA.debugLine="End Sub";
return "";
}
}