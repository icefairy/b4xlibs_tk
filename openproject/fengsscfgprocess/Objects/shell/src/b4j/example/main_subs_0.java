package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _appstart(RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("AppStart (main) ","main",0,main.ba,main.mostCurrent,11);
if (RapidSub.canDelegate("appstart")) return main.remoteMe.runUserSub(false, "main","appstart", _args);
RemoteObject _js = RemoteObject.createImmutable("");
Debug.locals.put("Args", _args);
 BA.debugLineNum = 11;BA.debugLine="Sub AppStart (Args() As String)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 12;BA.debugLine="Dim js As String=$\"{\"index\":0,\"random\":false,\"glo";
Debug.ShouldStop(2048);
_js = (RemoteObject.createImmutable("{\"index\":0,\"random\":false,\"global\":false,\"enabled\":true,\"shareOverLan\":false,\"isDefault\":false,\"localPort\":1080,\"pacUrl\":null,\"useOnlinePac\":false,\"reconnectTimes\":3,\"randomAlgorithm\":0,\"TTL\":0,\"proxyEnable\":false,\"proxyType\":0,\"proxyHost\":null,\"proxyPort\":0,\"proxyAuthUser\":null,\"proxyAuthPass\":null,\"authUser\":null,\"authPass\":null,\"autoban\":false,\"configs\":[{\"remarks\":\"\\u7f8e\\u56fd\\u6d1b\\u6749\\u77f6-SS\",\"server\":\"45.63.50.100\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"576O5Zu95rSb5p2J55+2LVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u7f8e\\u56fd\\u897f\\u96c5\\u56fe-SS\",\"server\":\"45.32.226.152\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"576O5Zu96KW\\/6ZuF5Zu+LVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u7f8e\\u56fd\\u7845\\u8c37-SS\",\"server\":\"104.207.148.199\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"576O5Zu956GF6LC3LVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u65e5\\u672c\\u4e1c\\u4eac-SS\",\"server\":\"108.61.186.221\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"5pel5pys5Lic5LqsLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u65b0\\u52a0\\u5761-SS\",\"server\":\"128.199.209.89\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"5paw5Yqg5Z2hLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u65b0\\u52a0\\u57611-SS\",\"server\":\"128.199.70.72\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"5paw5Yqg5Z2hMS1TUw==\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u7f8e\\u56fd\\u65e7\\u91d1\\u5c71-SS\",\"server\":\"138.68.0.27\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"576O5Zu95pen6YeR5bGxLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u65e5\\u672c\\u4e1c\\u4eac1-SS\",\"server\":\"45.63.124.213\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"5pel5pys5Lic5LqsMS1TUw==\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u97e9\\u56fdKT-SS\",\"server\":\"45.249.90.12\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6Z+p5Zu9S1QtU1M=\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u65e5\\u672c\\u5927\\u962a-SS\",\"server\":\"103.204.172.20\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"5pel5pys5aSn6ZiqLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u97e9\\u56fdBGP-SS\",\"server\":\"103.214.68.116\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6Z+p5Zu9QkdQLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u7f8e\\u56fdCN2-SS\",\"server\":\"107.151.139.226\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"576O5Zu9Q04yLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u9999\\u6e2f\\u6c99\\u7530-SS\",\"server\":\"103.214.195.87\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6aaZ5riv5rKZ55SwLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u7f8e\\u56fdC3-SS\",\"server\":\"103.219.193.37\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"576O5Zu9QzMtU1M=\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u9999\\u6e2f\\u65b0\\u4e16\\u754c-SS\",\"server\":\"198.44.190.50\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6aaZ5riv5paw5LiW55WMLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u82f1\\u56fd\\u4f26\\u6566-SS\",\"server\":\"104.238.185.74 \",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6Iux5Zu95Lym5pWmLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u9999\\u6e2f\\u963f\\u91cc\\u4e91-SS\",\"server\":\"47.90.48.169\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6aaZ5riv6Zi\\/6YeM5LqRLVNT\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true},{\"remarks\":\"\\u97e9\\u56fd\\u4f18\\u5316KT\\uff0c\\u6700\\u597d\\u7684\\u97e9\\u56fd\\u7ebf\\u8def-SS\",\"server\":\"183.110.233.242\",\"server_port\":11057,\"method\":\"rc4-md5\",\"obfs\":\"plain\",\"obfsparam\":\"\",\"remarks_base64\":\"6Z+p5Zu95LyY5YyWS1TvvIzmnIDlpb3nmoTpn6nlm73nur\\/ot68tU1M=\",\"password\":\"Z0hRHl\",\"tcp_over_udp\":false,\"udp_over_tcp\":false,\"protocol\":\"origin\",\"obfs_udp\":false,\"enable\":true}]}"));Debug.locals.put("js", _js);Debug.locals.put("js", _js);
 BA.debugLineNum = 13;BA.debugLine="processdata(js)";
Debug.ShouldStop(4096);
_processdata(_js);
 BA.debugLineNum = 14;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4j.example.main");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _processdata(RemoteObject _js) throws Exception{
try {
		Debug.PushSubsStack("processdata (main) ","main",0,main.ba,main.mostCurrent,15);
if (RapidSub.canDelegate("processdata")) return main.remoteMe.runUserSub(false, "main","processdata", _js);
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4j.objects.collections.JSONParser");
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _shareoverlan = RemoteObject.createImmutable("");
RemoteObject _configs = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _colconfigs = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _server = RemoteObject.createImmutable("");
RemoteObject _method = RemoteObject.createImmutable("");
RemoteObject _udp_over_tcp = RemoteObject.createImmutable("");
RemoteObject _tcp_over_udp = RemoteObject.createImmutable("");
RemoteObject _password = RemoteObject.createImmutable("");
RemoteObject _protocol = RemoteObject.createImmutable("");
RemoteObject _obfs = RemoteObject.createImmutable("");
RemoteObject _remarks_base64 = RemoteObject.createImmutable("");
RemoteObject _obfs_udp = RemoteObject.createImmutable("");
RemoteObject _enable = RemoteObject.createImmutable("");
RemoteObject _server_port = RemoteObject.createImmutable(0);
RemoteObject _obfsparam = RemoteObject.createImmutable("");
RemoteObject _remarks = RemoteObject.createImmutable("");
Debug.locals.put("js", _js);
 BA.debugLineNum = 15;BA.debugLine="Private Sub processdata(js As String)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 16;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(32768);
_parser = RemoteObject.createNew ("anywheresoftware.b4j.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 17;BA.debugLine="parser.Initialize(js)";
Debug.ShouldStop(65536);
_parser.runVoidMethod ("Initialize",(Object)(_js));
 BA.debugLineNum = 18;BA.debugLine="Dim root As Map = parser.NextObject";
Debug.ShouldStop(131072);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_root = _parser.runMethod(false,"NextObject");Debug.locals.put("root", _root);Debug.locals.put("root", _root);
 BA.debugLineNum = 19;BA.debugLine="Dim shareOverLan As String = root.GetDefault(\"sha";
Debug.ShouldStop(262144);
_shareoverlan = BA.ObjectToString(_root.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("shareOverLan"))),(Object)((RemoteObject.createImmutable("")))));Debug.locals.put("shareOverLan", _shareoverlan);Debug.locals.put("shareOverLan", _shareoverlan);
 BA.debugLineNum = 20;BA.debugLine="Dim configs As List = root.Get(\"configs\")";
Debug.ShouldStop(524288);
_configs = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_configs.setObject(_root.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("configs")))));Debug.locals.put("configs", _configs);
 BA.debugLineNum = 21;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(1048576);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 22;BA.debugLine="sb.Initialize";
Debug.ShouldStop(2097152);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 23;BA.debugLine="For Each colconfigs As Map In configs";
Debug.ShouldStop(4194304);
_colconfigs = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
final RemoteObject group8 = _configs;
final int groupLen8 = group8.runMethod(true,"getSize").<Integer>get();
for (int index8 = 0;index8 < groupLen8 ;index8++){
_colconfigs.setObject(group8.runMethod(false,"Get",index8));
Debug.locals.put("colconfigs", _colconfigs);
 BA.debugLineNum = 24;BA.debugLine="Dim server As String = colconfigs.GetDefault(";
Debug.ShouldStop(8388608);
_server = BA.ObjectToString(_colconfigs.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("server"))),(Object)((RemoteObject.createImmutable("")))));Debug.locals.put("server", _server);Debug.locals.put("server", _server);
 BA.debugLineNum = 25;BA.debugLine="Dim method As String = colconfigs.GetDefault(";
Debug.ShouldStop(16777216);
_method = BA.ObjectToString(_colconfigs.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("method"))),(Object)((RemoteObject.createImmutable("")))));Debug.locals.put("method", _method);Debug.locals.put("method", _method);
 BA.debugLineNum = 26;BA.debugLine="Dim udp_over_tcp As String = colconfigs.GetDe";
Debug.ShouldStop(33554432);
_udp_over_tcp = BA.ObjectToString(_colconfigs.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("udp_over_tcp"))),(Object)((RemoteObject.createImmutable("")))));Debug.locals.put("udp_over_tcp", _udp_over_tcp);Debug.locals.put("udp_over_tcp", _udp_over_tcp);
 BA.debugLineNum = 27;BA.debugLine="Dim tcp_over_udp As String = colconfigs.GetDe";
Debug.ShouldStop(67108864);
_tcp_over_udp = BA.ObjectToString(_colconfigs.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("tcp_over_udp"))),(Object)((RemoteObject.createImmutable("")))));Debug.locals.put("tcp_over_udp", _tcp_over_udp);Debug.locals.put("tcp_over_udp", _tcp_over_udp);
 BA.debugLineNum = 28;BA.debugLine="Dim password As String = colconfigs.GetDefaul";
Debug.ShouldStop(134217728);
_password = BA.ObjectToString(_colconfigs.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("password"))),(Object)((RemoteObject.createImmutable("")))));Debug.locals.put("password", _password);Debug.locals.put("password", _password);
 BA.debugLineNum = 29;BA.debugLine="Dim protocol As String = colconfigs.GetDefaul";
Debug.ShouldStop(268435456);
_protocol = BA.ObjectToString(_colconfigs.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("protocol"))),(Object)((RemoteObject.createImmutable("")))));Debug.locals.put("protocol", _protocol);Debug.locals.put("protocol", _protocol);
 BA.debugLineNum = 30;BA.debugLine="Dim obfs As String = colconfigs.GetDefault(\"o";
Debug.ShouldStop(536870912);
_obfs = BA.ObjectToString(_colconfigs.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("obfs"))),(Object)((RemoteObject.createImmutable("")))));Debug.locals.put("obfs", _obfs);Debug.locals.put("obfs", _obfs);
 BA.debugLineNum = 31;BA.debugLine="Dim remarks_base64 As String = colconfigs.Get";
Debug.ShouldStop(1073741824);
_remarks_base64 = BA.ObjectToString(_colconfigs.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("remarks_base64"))),(Object)((RemoteObject.createImmutable("")))));Debug.locals.put("remarks_base64", _remarks_base64);Debug.locals.put("remarks_base64", _remarks_base64);
 BA.debugLineNum = 32;BA.debugLine="Dim obfs_udp As String = colconfigs.GetDefaul";
Debug.ShouldStop(-2147483648);
_obfs_udp = BA.ObjectToString(_colconfigs.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("obfs_udp"))),(Object)((RemoteObject.createImmutable("")))));Debug.locals.put("obfs_udp", _obfs_udp);Debug.locals.put("obfs_udp", _obfs_udp);
 BA.debugLineNum = 33;BA.debugLine="Dim enable As String = colconfigs.GetDefault(";
Debug.ShouldStop(1);
_enable = BA.ObjectToString(_colconfigs.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("enable"))),(Object)((RemoteObject.createImmutable("")))));Debug.locals.put("enable", _enable);Debug.locals.put("enable", _enable);
 BA.debugLineNum = 34;BA.debugLine="Dim server_port As Int = colconfigs.GetDefaul";
Debug.ShouldStop(2);
_server_port = BA.numberCast(int.class, _colconfigs.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("server_port"))),(Object)(RemoteObject.createImmutable((0)))));Debug.locals.put("server_port", _server_port);Debug.locals.put("server_port", _server_port);
 BA.debugLineNum = 35;BA.debugLine="Dim obfsparam As String = colconfigs.GetDefau";
Debug.ShouldStop(4);
_obfsparam = BA.ObjectToString(_colconfigs.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("obfsparam"))),(Object)((RemoteObject.createImmutable("")))));Debug.locals.put("obfsparam", _obfsparam);Debug.locals.put("obfsparam", _obfsparam);
 BA.debugLineNum = 36;BA.debugLine="Dim remarks As String = colconfigs.GetDefault";
Debug.ShouldStop(8);
_remarks = BA.ObjectToString(_colconfigs.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("remarks"))),(Object)((RemoteObject.createImmutable("")))));Debug.locals.put("remarks", _remarks);Debug.locals.put("remarks", _remarks);
 BA.debugLineNum = 37;BA.debugLine="sb.Append(\"proxy = ss://\"&method&\":\"&password&\"@";
Debug.ShouldStop(16);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("proxy = ss://"),_method,RemoteObject.createImmutable(":"),_password,RemoteObject.createImmutable("@"),_server,RemoteObject.createImmutable(":"),_server_port,main.__c.getField(true,"CRLF"))));
 }
Debug.locals.put("colconfigs", _colconfigs);
;
 BA.debugLineNum = 39;BA.debugLine="Log(sb.ToString)";
Debug.ShouldStop(64);
main.__c.runVoidMethod ("Log",(Object)(_sb.runMethod(true,"ToString")));
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}