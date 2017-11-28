package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class g extends Object{
public static g mostCurrent = new g();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.g", null);
		ba.loadHtSubs(g.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.g", ba);
		}
	}
    public static Class<?> getObject() {
		return g.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static ice.jsonplus.jsonplus _jsg = null;
public static anywheresoftware.b4a.objects.StringUtils _su = null;
public static boolean _devmode = false;
public static String _action = "";
public static anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper _messagedigestobj = null;
public static anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
public static String _staticfilesfolder = "";
public static String _uploadfolder = "";
public static int _uploadmaxsize = 0;
public static anywheresoftware.b4a.objects.collections.Map _basecache = null;
public static anywheresoftware.b4a.objects.collections.Map _funcache = null;
public static anywheresoftware.b4a.objects.collections.Map _settings = null;
public static int _reloadbasemaptime = 0;
public static boolean _addfunctionauto = false;
public static String _allowuploadfileext = "";
public static anywheresoftware.b4j.objects.SQL _db = null;
public static b4j.example.main _main = null;
public static b4j.example.wpdbutils _wpdbutils = null;
public static String  _arrupperfirst(String[] _arr) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
String _s = "";
 //BA.debugLineNum = 166;BA.debugLine="Public Sub arrUpperFirst(arr() As String) As Strin";
 //BA.debugLineNum = 167;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 168;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 169;BA.debugLine="For Each s As String In arr";
{
final String[] group3 = _arr;
final int groupLen3 = group3.length
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_s = group3[index3];
 //BA.debugLineNum = 170;BA.debugLine="If s.Length>0 Then  sb.Append(s.SubString2(0,1).";
if (_s.length()>0) { 
_sb.Append(_s.substring((int) (0),(int) (1)).toUpperCase()+_s.substring((int) (1)));};
 }
};
 //BA.debugLineNum = 172;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 173;BA.debugLine="End Sub";
return "";
}
public static boolean  _checkmobilebyua(String _ua) throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Public Sub checkMobileByUA(ua As String) As Boolea";
 //BA.debugLineNum = 32;BA.debugLine="If ua.ToLowerCase.IndexOf(\"android\")>-1 Or ua.ToL";
if (_ua.toLowerCase().indexOf("android")>-1 || _ua.toLowerCase().indexOf("ios")>-1 || _ua.toLowerCase().indexOf("wap")>-1) { 
 //BA.debugLineNum = 33;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 35;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.Map  _copymap(anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
anywheresoftware.b4a.objects.collections.Map _ret = null;
String _v = "";
 //BA.debugLineNum = 70;BA.debugLine="Public Sub copyMap(m As Map) As Map";
 //BA.debugLineNum = 71;BA.debugLine="Dim ret As Map";
_ret = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 72;BA.debugLine="ret.Initialize";
_ret.Initialize();
 //BA.debugLineNum = 73;BA.debugLine="If m.IsInitialized=False Then Return ret";
if (_m.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return _ret;};
 //BA.debugLineNum = 74;BA.debugLine="For Each v As String In m.Keys";
{
final anywheresoftware.b4a.BA.IterableList group4 = _m.Keys();
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_v = BA.ObjectToString(group4.Get(index4));
 //BA.debugLineNum = 75;BA.debugLine="ret.Put(v,m.Get(v))";
_ret.Put((Object)(_v),_m.Get((Object)(_v)));
 }
};
 //BA.debugLineNum = 77;BA.debugLine="Return ret";
if (true) return _ret;
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return null;
}
public static String  _escapehtml(String _raw) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
char _c = '\0';
 //BA.debugLineNum = 174;BA.debugLine="Public Sub EscapeHtml(Raw As String) As String";
 //BA.debugLineNum = 175;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 176;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 177;BA.debugLine="For i = 0 To Raw.Length - 1";
{
final int step3 = 1;
final int limit3 = (int) (_raw.length()-1);
_i = (int) (0) ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
 //BA.debugLineNum = 178;BA.debugLine="Dim C As Char = Raw.CharAt(i)";
_c = _raw.charAt(_i);
 //BA.debugLineNum = 179;BA.debugLine="Select C";
switch (BA.switchObjectToInt(_c,BA.ObjectToChar(anywheresoftware.b4a.keywords.Common.QUOTE),BA.ObjectToChar("'"),BA.ObjectToChar("<"),BA.ObjectToChar(">"),BA.ObjectToChar("&"),BA.ObjectToChar(" "),BA.ObjectToChar(anywheresoftware.b4a.keywords.Common.CRLF))) {
case 0: {
 //BA.debugLineNum = 181;BA.debugLine="sb.Append(\"&quot;\")";
_sb.Append("&quot;");
 break; }
case 1: {
 //BA.debugLineNum = 183;BA.debugLine="sb.Append(\"&#39;\")";
_sb.Append("&#39;");
 break; }
case 2: {
 //BA.debugLineNum = 185;BA.debugLine="sb.Append(\"&lt;\")";
_sb.Append("&lt;");
 break; }
case 3: {
 //BA.debugLineNum = 187;BA.debugLine="sb.Append(\"&gt;\")";
_sb.Append("&gt;");
 break; }
case 4: {
 //BA.debugLineNum = 189;BA.debugLine="sb.Append(\"&amp;\")";
_sb.Append("&amp;");
 break; }
case 5: {
 //BA.debugLineNum = 191;BA.debugLine="sb.Append(\"&nbsp;\")";
_sb.Append("&nbsp;");
 break; }
case 6: {
 //BA.debugLineNum = 193;BA.debugLine="sb.Append(\"<br>\")";
_sb.Append("<br>");
 break; }
default: {
 //BA.debugLineNum = 195;BA.debugLine="sb.Append(C)";
_sb.Append(BA.ObjectToString(_c));
 break; }
}
;
 }
};
 //BA.debugLineNum = 198;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public static String  _formatdatetime(String _dt) throws Exception{
String[] _ts = null;
long _lts = 0L;
 //BA.debugLineNum = 132;BA.debugLine="Public Sub formatDateTime(dt As String) As String";
 //BA.debugLineNum = 133;BA.debugLine="DateTime.DateFormat=\"yyyy-MM-dd\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyy-MM-dd");
 //BA.debugLineNum = 134;BA.debugLine="DateTime.TimeFormat=\"HH:mm:ss\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm:ss");
 //BA.debugLineNum = 135;BA.debugLine="Try";
try { //BA.debugLineNum = 136;BA.debugLine="Dim ts() As String=Regex.Split(\" \",dt)";
_ts = anywheresoftware.b4a.keywords.Common.Regex.Split(" ",_dt);
 //BA.debugLineNum = 137;BA.debugLine="Dim lTs As Long=DateTime.DateTimeParse(ts(0),ts(";
_lts = anywheresoftware.b4a.keywords.Common.DateTime.DateTimeParse(_ts[(int) (0)],_ts[(int) (1)]);
 //BA.debugLineNum = 138;BA.debugLine="Return DateTime.Date(lTs)&\" \"&DateTime.Time(lTs)";
if (true) return anywheresoftware.b4a.keywords.Common.DateTime.Date(_lts)+" "+anywheresoftware.b4a.keywords.Common.DateTime.Time(_lts);
 } 
       catch (Exception e8) {
			ba.setLastException(e8); //BA.debugLineNum = 140;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 //BA.debugLineNum = 141;BA.debugLine="Return DateTime.Date(DateTime.Now)&\" \"&DateTime.";
if (true) return anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())+" "+anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 };
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public static int  _getaid(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req) throws Exception{
 //BA.debugLineNum = 222;BA.debugLine="Public Sub getAid(req As ServletRequest) As Int";
 //BA.debugLineNum = 223;BA.debugLine="Return req.GetSession.GetAttribute2(\"aid\",-1)";
if (true) return (int)(BA.ObjectToNumber(_req.GetSession().GetAttribute2("aid",(Object)(-1))));
 //BA.debugLineNum = 224;BA.debugLine="End Sub";
return 0;
}
public static String  _getdatetime() throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Public Sub getdatetime As String";
 //BA.debugLineNum = 128;BA.debugLine="DateTime.DateFormat=\"yyyy-MM-dd\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyy-MM-dd");
 //BA.debugLineNum = 129;BA.debugLine="DateTime.TimeFormat=\"HH:mm:ss\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm:ss");
 //BA.debugLineNum = 130;BA.debugLine="Return DateTime.Date(DateTime.Now)&\" \"&DateTime.T";
if (true) return anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())+" "+anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}
public static String  _getmd5(String _str) throws Exception{
byte[] _buf = null;
 //BA.debugLineNum = 112;BA.debugLine="Public Sub getMd5(str As String) As String";
 //BA.debugLineNum = 113;BA.debugLine="Dim buf() As Byte=MessageDigestObj.GetMessageDige";
_buf = _messagedigestobj.GetMessageDigest(_str.getBytes("UTF8"),"MD5");
 //BA.debugLineNum = 114;BA.debugLine="Return bc.HexFromBytes(buf).ToLowerCase";
if (true) return _bc.HexFromBytes(_buf).toLowerCase();
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public static String  _getrndsalt() throws Exception{
 //BA.debugLineNum = 124;BA.debugLine="Public Sub getRndSalt As String";
 //BA.debugLineNum = 125;BA.debugLine="Return Rnd(100000,999999)&\"\"";
if (true) return BA.NumberToString(anywheresoftware.b4a.keywords.Common.Rnd((int) (100000),(int) (999999)))+"";
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static String  _getsetting(String _key,String _def) throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Public Sub getSetting(key As String,def As String)";
 //BA.debugLineNum = 51;BA.debugLine="Return Settings.GetDefault(key,def)";
if (true) return BA.ObjectToString(_settings.GetDefault((Object)(_key),(Object)(_def)));
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static String  _getsql(String _tsqlname) throws Exception{
 //BA.debugLineNum = 117;BA.debugLine="Public Sub getSQL(tsqlname As String) As String";
 //BA.debugLineNum = 118;BA.debugLine="If File.Exists(File.Combine(File.DirApp,\"sqls\"),t";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirApp(),"sqls"),_tsqlname+".sql")) { 
 //BA.debugLineNum = 119;BA.debugLine="Return File.ReadString(File.Combine(File.DirApp,";
if (true) return anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirApp(),"sqls"),_tsqlname+".sql");
 }else {
 //BA.debugLineNum = 121;BA.debugLine="Return \"no sql file:\"&tsqlname&\" found\"";
if (true) return "no sql file:"+_tsqlname+" found";
 };
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public static String  _gettext(String _str,String _signa,String _signb,boolean _strict) throws Exception{
int _a = 0;
int _b = 0;
 //BA.debugLineNum = 80;BA.debugLine="Public Sub getText(str As String,signa As String,s";
 //BA.debugLineNum = 81;BA.debugLine="Dim a,b As Int";
_a = 0;
_b = 0;
 //BA.debugLineNum = 82;BA.debugLine="a=str.IndexOf(signa)";
_a = _str.indexOf(_signa);
 //BA.debugLineNum = 83;BA.debugLine="If a<0 Then Return \"\"";
if (_a<0) { 
if (true) return "";};
 //BA.debugLineNum = 84;BA.debugLine="b=str.IndexOf2(signb,a+1)";
_b = _str.indexOf(_signb,(int) (_a+1));
 //BA.debugLineNum = 85;BA.debugLine="If strict Then";
if (_strict) { 
 //BA.debugLineNum = 86;BA.debugLine="If b<0 Then Return \"\" Else Return str.SubString2";
if (_b<0) { 
if (true) return "";}
else {
if (true) return _str.substring((int) (_a+_signa.length()),_b);};
 }else {
 //BA.debugLineNum = 88;BA.debugLine="If b<0 Then Return str.SubString(a) Else Return";
if (_b<0) { 
if (true) return _str.substring(_a);}
else {
if (true) return _str.substring(_a,(int) (_b+_signb.length()));};
 };
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _gettext2(String _str,String _signa,String _signb) throws Exception{
int _a = 0;
int _b = 0;
 //BA.debugLineNum = 93;BA.debugLine="Public Sub getText2(str As String,signa As String,";
 //BA.debugLineNum = 94;BA.debugLine="Dim a,b As Int";
_a = 0;
_b = 0;
 //BA.debugLineNum = 95;BA.debugLine="a=str.IndexOf(signa)";
_a = _str.indexOf(_signa);
 //BA.debugLineNum = 96;BA.debugLine="If a<0 Then Return \"\"";
if (_a<0) { 
if (true) return "";};
 //BA.debugLineNum = 97;BA.debugLine="b=str.IndexOf2(signb,a+1)";
_b = _str.indexOf(_signb,(int) (_a+1));
 //BA.debugLineNum = 98;BA.debugLine="If b<0 Then Return \"\" Else Return str.SubString2(";
if (_b<0) { 
if (true) return "";}
else {
if (true) return _str.substring(_a,(int) (_b+_signb.length()));};
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public static String  _gettextrev(String _str,String _signa,String _signb,boolean _strict) throws Exception{
String[] _strs = null;
int _a = 0;
 //BA.debugLineNum = 101;BA.debugLine="Public Sub getTextRev(str As String,signa As Strin";
 //BA.debugLineNum = 102;BA.debugLine="Dim strs() As String=Regex.Split(signb,str)";
_strs = anywheresoftware.b4a.keywords.Common.Regex.Split(_signb,_str);
 //BA.debugLineNum = 103;BA.debugLine="If strs.Length>1 Then";
if (_strs.length>1) { 
 //BA.debugLineNum = 104;BA.debugLine="Dim a As Int";
_a = 0;
 //BA.debugLineNum = 105;BA.debugLine="a=strs(0).LastIndexOf(signa)";
_a = _strs[(int) (0)].lastIndexOf(_signa);
 //BA.debugLineNum = 106;BA.debugLine="If a>-1 Then";
if (_a>-1) { 
 //BA.debugLineNum = 107;BA.debugLine="Return strs(0).SubString(a+signa.Length)";
if (true) return _strs[(int) (0)].substring((int) (_a+_signa.length()));
 };
 };
 //BA.debugLineNum = 110;BA.debugLine="Return \"\"";
if (true) return "";
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public static int  _getuid(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req) throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="Public Sub getUid(req As ServletRequest) As Int";
 //BA.debugLineNum = 215;BA.debugLine="Return req.GetSession.GetAttribute2(\"uid\",-1)";
if (true) return (int)(BA.ObjectToNumber(_req.GetSession().GetAttribute2("uid",(Object)(-1))));
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return 0;
}
public static String  _getuuid() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 200;BA.debugLine="Public Sub getuuid As String";
 //BA.debugLineNum = 201;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 202;BA.debugLine="jo=Me";
_jo.setObject((java.lang.Object)(g.getObject()));
 //BA.debugLineNum = 203;BA.debugLine="jo.InitializeStatic(\"java.util.UUID\")";
_jo.InitializeStatic("java.util.UUID");
 //BA.debugLineNum = 204;BA.debugLine="Return jo.RunMethodJO(\"randomUUID\",Null).RunMetho";
if (true) return BA.ObjectToString(_jo.RunMethodJO("randomUUID",(Object[])(anywheresoftware.b4a.keywords.Common.Null)).RunMethod("toString",(Object[])(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 208;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _js2list(String _js) throws Exception{
anywheresoftware.b4j.objects.collections.JSONParser _jsp = null;
 //BA.debugLineNum = 226;BA.debugLine="Public Sub js2List(js As String) As List";
 //BA.debugLineNum = 227;BA.debugLine="Dim jsp As JSONParser";
_jsp = new anywheresoftware.b4j.objects.collections.JSONParser();
 //BA.debugLineNum = 228;BA.debugLine="jsp.Initialize(js)";
_jsp.Initialize(_js);
 //BA.debugLineNum = 229;BA.debugLine="Return jsp.NextArray";
if (true) return _jsp.NextArray();
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.Map  _js2map(String _js) throws Exception{
anywheresoftware.b4j.objects.collections.JSONParser _jsp = null;
 //BA.debugLineNum = 231;BA.debugLine="Public Sub js2Map(js As String) As Map";
 //BA.debugLineNum = 232;BA.debugLine="Dim jsp As JSONParser";
_jsp = new anywheresoftware.b4j.objects.collections.JSONParser();
 //BA.debugLineNum = 233;BA.debugLine="jsp.Initialize(js)";
_jsp.Initialize(_js);
 //BA.debugLineNum = 234;BA.debugLine="Return jsp.NextObject";
if (true) return _jsp.NextObject();
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return null;
}
public static String  _json(boolean _success,Object _data) throws Exception{
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 16;BA.debugLine="Public Sub Json(success As Boolean,data As Object)";
 //BA.debugLineNum = 17;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 18;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 19;BA.debugLine="If success Then";
if (_success) { 
 //BA.debugLineNum = 20;BA.debugLine="m.Put(\"code\",200)";
_m.Put((Object)("code"),(Object)(200));
 }else {
 //BA.debugLineNum = 22;BA.debugLine="m.Put(\"code\",500)";
_m.Put((Object)("code"),(Object)(500));
 };
 //BA.debugLineNum = 24;BA.debugLine="m.Put(\"data\",data)";
_m.Put((Object)("data"),_data);
 //BA.debugLineNum = 25;BA.debugLine="jsg.Initialize(m)";
_jsg.Initialize(_m);
 //BA.debugLineNum = 26;BA.debugLine="Return jsg.ToString";
if (true) return _jsg.ToString();
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static String  _mlog(String _msg) throws Exception{
 //BA.debugLineNum = 236;BA.debugLine="public Sub mLog(msg As String)";
 //BA.debugLineNum = 237;BA.debugLine="If devMode Then";
if (_devmode) { 
 //BA.debugLineNum = 238;BA.debugLine="Log(msg)";
anywheresoftware.b4a.keywords.Common.Log(_msg);
 };
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private jsg As JSONGenerator2";
_jsg = new ice.jsonplus.jsonplus();
 //BA.debugLineNum = 4;BA.debugLine="Private su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 5;BA.debugLine="Public devMode As Boolean";
_devmode = false;
 //BA.debugLineNum = 6;BA.debugLine="Public action As String=\"action\"";
_action = "action";
 //BA.debugLineNum = 7;BA.debugLine="Public MessageDigestObj  As MessageDigest";
_messagedigestobj = new anywheresoftware.b4a.agraham.encryption.CipherWrapper.MessageDigestWrapper();
 //BA.debugLineNum = 8;BA.debugLine="Private bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 9;BA.debugLine="Public staticFilesFolder As String=\"public\",uploa";
_staticfilesfolder = "public";
_uploadfolder = "upload";
_uploadmaxsize = (int) (20*1024*1024);
 //BA.debugLineNum = 10;BA.debugLine="Public baseCache,funCache,Settings As Map";
_basecache = new anywheresoftware.b4a.objects.collections.Map();
_funcache = new anywheresoftware.b4a.objects.collections.Map();
_settings = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 11;BA.debugLine="Public reloadbasemaptime As Int=60";
_reloadbasemaptime = (int) (60);
 //BA.debugLineNum = 12;BA.debugLine="Public addFunctionAuto As Boolean=True '是否自动添加接口";
_addfunctionauto = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 13;BA.debugLine="Public allowuploadfileext As String=\"jpg,png,pdf,";
_allowuploadfileext = "jpg,png,pdf,doc,docx,rar,xls,xlsx,zip,gif";
 //BA.debugLineNum = 14;BA.debugLine="Public db As SQL";
_db = new anywheresoftware.b4j.objects.SQL();
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public static String  _replacemap(String _base,anywheresoftware.b4a.objects.collections.Map _replacements) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _pattern = null;
String _k = "";
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _m = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _result = null;
int _lastindex = 0;
String _replace = "";
 //BA.debugLineNum = 145;BA.debugLine="Public Sub ReplaceMap(Base As String, Replacements";
 //BA.debugLineNum = 146;BA.debugLine="Dim pattern As StringBuilder";
_pattern = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 147;BA.debugLine="pattern.Initialize";
_pattern.Initialize();
 //BA.debugLineNum = 148;BA.debugLine="For Each k As String In Replacements.Keys";
{
final anywheresoftware.b4a.BA.IterableList group3 = _replacements.Keys();
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_k = BA.ObjectToString(group3.Get(index3));
 //BA.debugLineNum = 149;BA.debugLine="If pattern.Length > 0 Then pattern.Append(\"|\")";
if (_pattern.getLength()>0) { 
_pattern.Append("|");};
 //BA.debugLineNum = 150;BA.debugLine="pattern.Append(\"\\$\").Append(k).Append(\"\\$\")";
_pattern.Append("\\$").Append(_k).Append("\\$");
 }
};
 //BA.debugLineNum = 152;BA.debugLine="Dim m As Matcher = Regex.Matcher(pattern.ToString";
_m = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_m = anywheresoftware.b4a.keywords.Common.Regex.Matcher(_pattern.ToString(),_base);
 //BA.debugLineNum = 153;BA.debugLine="Dim result As StringBuilder";
_result = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 154;BA.debugLine="result.Initialize";
_result.Initialize();
 //BA.debugLineNum = 155;BA.debugLine="Dim lastIndex As Int";
_lastindex = 0;
 //BA.debugLineNum = 156;BA.debugLine="Do While m.Find";
while (_m.Find()) {
 //BA.debugLineNum = 157;BA.debugLine="result.Append(Base.SubString2(lastIndex, m.GetSt";
_result.Append(_base.substring(_lastindex,_m.GetStart((int) (0))));
 //BA.debugLineNum = 158;BA.debugLine="Dim replace As String = Replacements.Get(m.Match";
_replace = BA.ObjectToString(_replacements.Get((Object)(_m.getMatch().substring((int) (1),(int) (_m.getMatch().length()-1)))));
 //BA.debugLineNum = 159;BA.debugLine="If m.Match.ToLowerCase.StartsWith(\"$h_\") Then re";
if (_m.getMatch().toLowerCase().startsWith("$h_")) { 
_replace = _escapehtml(_replace);};
 //BA.debugLineNum = 160;BA.debugLine="result.Append(replace)";
_result.Append(_replace);
 //BA.debugLineNum = 161;BA.debugLine="lastIndex = m.GetEnd(0)";
_lastindex = _m.GetEnd((int) (0));
 }
;
 //BA.debugLineNum = 163;BA.debugLine="If lastIndex < Base.Length Then result.Append(Bas";
if (_lastindex<_base.length()) { 
_result.Append(_base.substring(_lastindex));};
 //BA.debugLineNum = 164;BA.debugLine="Return result.ToString";
if (true) return _result.ToString();
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
public static String  _setmgrlogined(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,int _uid) throws Exception{
 //BA.debugLineNum = 218;BA.debugLine="Public Sub setMgrLogined(req As ServletRequest,uid";
 //BA.debugLineNum = 219;BA.debugLine="req.GetSession.SetAttribute(\"aid\",uid)";
_req.GetSession().SetAttribute("aid",(Object)(_uid));
 //BA.debugLineNum = 220;BA.debugLine="End Sub";
return "";
}
public static String  _setsetting(String _key,String _value,anywheresoftware.b4j.objects.SQL _db1) throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Public Sub setSetting(key As String,value As Strin";
 //BA.debugLineNum = 54;BA.debugLine="Settings.Put(key,value)";
_settings.Put((Object)(_key),(Object)(_value));
 //BA.debugLineNum = 55;BA.debugLine="wpDBUtils.UpdateRecord2(db1,\"wp_setting\",CreateMa";
_wpdbutils._updaterecord2(_db1,"wp_setting",anywheresoftware.b4a.keywords.Common.createMap(new Object[] {(Object)("update"),(Object)(_getdatetime()),(Object)("val"),(Object)(_value)}),anywheresoftware.b4a.keywords.Common.createMap(new Object[] {(Object)("key"),(Object)(_key)}));
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static String  _setuserlogined(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,int _uid) throws Exception{
 //BA.debugLineNum = 210;BA.debugLine="Public Sub setUserLogined(req As ServletRequest,ui";
 //BA.debugLineNum = 211;BA.debugLine="req.GetSession.SetAttribute(\"uid\",uid)";
_req.GetSession().SetAttribute("uid",(Object)(_uid));
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public static int  _str2int(String _str,int _def) throws Exception{
int _ret = 0;
 //BA.debugLineNum = 241;BA.debugLine="Public Sub str2int(str As String,def As Int) As In";
 //BA.debugLineNum = 242;BA.debugLine="Dim ret As Int";
_ret = 0;
 //BA.debugLineNum = 243;BA.debugLine="Try";
try { //BA.debugLineNum = 244;BA.debugLine="ret=str";
_ret = (int)(Double.parseDouble(_str));
 } 
       catch (Exception e5) {
			ba.setLastException(e5); //BA.debugLineNum = 246;BA.debugLine="ret=def";
_ret = _def;
 //BA.debugLineNum = 247;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 };
 //BA.debugLineNum = 249;BA.debugLine="Return ret";
if (true) return _ret;
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return 0;
}
public static String  _tojson(Object _data) throws Exception{
 //BA.debugLineNum = 38;BA.debugLine="Public Sub toJson(data As Object) As String";
 //BA.debugLineNum = 39;BA.debugLine="If data Is Map Then";
if (_data instanceof anywheresoftware.b4a.objects.collections.Map.MyMap) { 
 //BA.debugLineNum = 40;BA.debugLine="jsg.Initialize(data)";
_jsg.Initialize((anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(_data)));
 //BA.debugLineNum = 41;BA.debugLine="Return jsg.ToString";
if (true) return _jsg.ToString();
 }else if(_data instanceof java.util.List) { 
 //BA.debugLineNum = 43;BA.debugLine="jsg.Initialize2(data)";
_jsg.Initialize2((anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(_data)));
 //BA.debugLineNum = 44;BA.debugLine="Return jsg.ToString";
if (true) return _jsg.ToString();
 }else {
 //BA.debugLineNum = 46;BA.debugLine="Return data";
if (true) return BA.ObjectToString(_data);
 };
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public static String[]  _url2array(String _u) throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Public Sub url2Array(u As String) As String()";
 //BA.debugLineNum = 65;BA.debugLine="If u.StartsWith(\"/\") Then u=u.SubString(1)";
if (_u.startsWith("/")) { 
_u = _u.substring((int) (1));};
 //BA.debugLineNum = 66;BA.debugLine="If u.EndsWith(\"/\") Then u=u&\"index\"";
if (_u.endsWith("/")) { 
_u = _u+"index";};
 //BA.debugLineNum = 67;BA.debugLine="Return Regex.Split(\"/\",u)";
if (true) return anywheresoftware.b4a.keywords.Common.Regex.Split("/",_u);
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return null;
}
public static String  _urldecode(String _u) throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Public Sub urlDecode(u As String) As String";
 //BA.debugLineNum = 61;BA.debugLine="Return su.DecodeUrl(u,\"UTF-8\")";
if (true) return _su.DecodeUrl(_u,"UTF-8");
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _urlencode(String _u) throws Exception{
 //BA.debugLineNum = 57;BA.debugLine="Public Sub urlEncode(u As String) As String";
 //BA.debugLineNum = 58;BA.debugLine="Return su.EncodeUrl(u,\"UTF-8\")";
if (true) return _su.EncodeUrl(_u,"UTF-8");
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public static String  _webdir2localdir(String _d) throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Public Sub webDir2LocalDir(d As String) As String";
 //BA.debugLineNum = 29;BA.debugLine="Return File.Combine(File.Combine(File.DirApp,stat";
if (true) return anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirApp(),_staticfilesfolder),_d);
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
}
