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
public static anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator _jsg = null;
public static anywheresoftware.b4a.objects.StringUtils _su = null;
public static b4j.example.main _main = null;
public static anywheresoftware.b4a.objects.collections.Map  _copymap(anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
anywheresoftware.b4a.objects.collections.Map _ret = null;
String _v = "";
 //BA.debugLineNum = 25;BA.debugLine="Public Sub copyMap(m As Map) As Map";
 //BA.debugLineNum = 26;BA.debugLine="Dim ret As Map";
_ret = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 27;BA.debugLine="ret.Initialize";
_ret.Initialize();
 //BA.debugLineNum = 28;BA.debugLine="If m.IsInitialized=False Then Return ret";
if (_m.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return _ret;};
 //BA.debugLineNum = 29;BA.debugLine="For Each v As String In m.Keys";
final anywheresoftware.b4a.BA.IterableList group4 = _m.Keys();
final int groupLen4 = group4.getSize();
for (int index4 = 0;index4 < groupLen4 ;index4++){
_v = BA.ObjectToString(group4.Get(index4));
 //BA.debugLineNum = 30;BA.debugLine="ret.Put(v,m.Get(v))";
_ret.Put((Object)(_v),_m.Get((Object)(_v)));
 }
;
 //BA.debugLineNum = 32;BA.debugLine="Return ret";
if (true) return _ret;
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return null;
}
public static String  _getdatetime() throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Public Sub getdatetime As String";
 //BA.debugLineNum = 59;BA.debugLine="DateTime.DateFormat=\"yyyy-MM-dd\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyy-MM-dd");
 //BA.debugLineNum = 60;BA.debugLine="Return DateTime.Date(DateTime.Now)&\" \"&DateTime.T";
if (true) return anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow())+" "+anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public static String  _gettext(String _str,String _signa,String _signb,boolean _strict) throws Exception{
int _a = 0;
int _b = 0;
 //BA.debugLineNum = 34;BA.debugLine="Public Sub getText(str As String,signa As String,s";
 //BA.debugLineNum = 35;BA.debugLine="Dim a,b As Int";
_a = 0;
_b = 0;
 //BA.debugLineNum = 36;BA.debugLine="a=str.IndexOf(signa)";
_a = _str.indexOf(_signa);
 //BA.debugLineNum = 37;BA.debugLine="If a<0 Then Return \"\"";
if (_a<0) { 
if (true) return "";};
 //BA.debugLineNum = 38;BA.debugLine="b=str.IndexOf2(signb,a+1)";
_b = _str.indexOf(_signb,(int) (_a+1));
 //BA.debugLineNum = 39;BA.debugLine="If strict Then";
if (_strict) { 
 //BA.debugLineNum = 40;BA.debugLine="If b<0 Then Return \"\" Else Return str.SubString2";
if (_b<0) { 
if (true) return "";}
else {
if (true) return _str.substring((int) (_a+_signa.length()),_b);};
 }else {
 //BA.debugLineNum = 42;BA.debugLine="If b<0 Then Return str.SubString(a) Else Return";
if (_b<0) { 
if (true) return _str.substring(_a);}
else {
if (true) return _str.substring(_a,(int) (_b+_signb.length()));};
 };
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public static String  _gettextrev(String _str,String _signa,String _signb,boolean _strict) throws Exception{
String[] _strs = null;
int _a = 0;
 //BA.debugLineNum = 47;BA.debugLine="Public Sub getTextRev(str As String,signa As Strin";
 //BA.debugLineNum = 48;BA.debugLine="Dim strs() As String=Regex.Split(signb,str)";
_strs = anywheresoftware.b4a.keywords.Common.Regex.Split(_signb,_str);
 //BA.debugLineNum = 49;BA.debugLine="If strs.Length>1 Then";
if (_strs.length>1) { 
 //BA.debugLineNum = 50;BA.debugLine="Dim a As Int";
_a = 0;
 //BA.debugLineNum = 51;BA.debugLine="a=strs(0).LastIndexOf(signa)";
_a = _strs[(int) (0)].lastIndexOf(_signa);
 //BA.debugLineNum = 52;BA.debugLine="If a>-1 Then";
if (_a>-1) { 
 //BA.debugLineNum = 53;BA.debugLine="Return strs(0).SubString(a+signa.Length)";
if (true) return _strs[(int) (0)].substring((int) (_a+_signa.length()));
 };
 };
 //BA.debugLineNum = 56;BA.debugLine="Return \"\"";
if (true) return "";
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public static String  _getuuid() throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 62;BA.debugLine="Public Sub getuuid As String";
 //BA.debugLineNum = 63;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 64;BA.debugLine="jo=Me";
_jo.setObject((java.lang.Object)(g.getObject()));
 //BA.debugLineNum = 65;BA.debugLine="jo.InitializeStatic(\"java.util.UUID\")";
_jo.InitializeStatic("java.util.UUID");
 //BA.debugLineNum = 66;BA.debugLine="Return jo.RunMethodJO(\"randomUUID\",Null).RunMetho";
if (true) return BA.ObjectToString(_jo.RunMethodJO("randomUUID",(Object[])(anywheresoftware.b4a.keywords.Common.Null)).RunMethod("toString",(Object[])(anywheresoftware.b4a.keywords.Common.Null)));
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _json(boolean _success,Object _data) throws Exception{
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 6;BA.debugLine="Public Sub Json(success As Boolean,data As Object)";
 //BA.debugLineNum = 7;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 8;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 9;BA.debugLine="If success Then";
if (_success) { 
 //BA.debugLineNum = 10;BA.debugLine="m.Put(\"code\",200)";
_m.Put((Object)("code"),(Object)(200));
 }else {
 //BA.debugLineNum = 12;BA.debugLine="m.Put(\"code\",500)";
_m.Put((Object)("code"),(Object)(500));
 };
 //BA.debugLineNum = 14;BA.debugLine="m.Put(\"data\",data)";
_m.Put((Object)("data"),_data);
 //BA.debugLineNum = 15;BA.debugLine="jsg.Initialize(m)";
_jsg.Initialize(_m);
 //BA.debugLineNum = 16;BA.debugLine="Return jsg.ToString";
if (true) return _jsg.ToString();
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private jsg As JSONGenerator";
_jsg = new anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 4;BA.debugLine="Private su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return "";
}
public static String  _urldecode(String _u) throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Public Sub urlDecode(u As String) As String";
 //BA.debugLineNum = 22;BA.debugLine="Return su.DecodeUrl(u,\"UTF-8\")";
if (true) return _su.DecodeUrl(_u,"UTF-8");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public static String  _urlencode(String _u) throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Public Sub urlEncode(u As String) As String";
 //BA.debugLineNum = 19;BA.debugLine="Return su.EncodeUrl(u,\"UTF-8\")";
if (true) return _su.EncodeUrl(_u,"UTF-8");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
}
