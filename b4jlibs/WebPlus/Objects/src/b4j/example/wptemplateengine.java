package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class wptemplateengine extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.wptemplateengine", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.wptemplateengine.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _themename = "";
public String _viewbasepath = "";
public String _tplfileext = "";
public anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
public anywheresoftware.b4a.objects.collections.Map _gmap = null;
public boolean _devmode = false;
public anywheresoftware.b4a.objects.collections.Map _mapdata = null;
public anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _res = null;
public anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator _jsg = null;
public b4j.example.main _main = null;
public b4j.example.g _g = null;
public String  _bindresponse(anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Public Sub bindResponse(resp As ServletResponse)";
 //BA.debugLineNum = 54;BA.debugLine="res=resp";
_res = _resp;
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Public ThemeName,ViewBasePath,TPLFileExt As Strin";
_themename = "";
_viewbasepath = "";
_tplfileext = "";
 //BA.debugLineNum = 4;BA.debugLine="Private bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 6;BA.debugLine="Public gMap As Map";
_gmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 7;BA.debugLine="Public devMode As Boolean";
_devmode = false;
 //BA.debugLineNum = 8;BA.debugLine="Private mapData As Map '用于存储将要应用到本页面的各种变量数据";
_mapdata = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 9;BA.debugLine="Private res As ServletResponse";
_res = new anywheresoftware.b4j.object.JServlet.ServletResponseWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private jsg As JSONGenerator";
_jsg = new anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public String  _clearmapdata() throws Exception{
 //BA.debugLineNum = 41;BA.debugLine="Public Sub clearMapData";
 //BA.debugLineNum = 42;BA.debugLine="mapData.Clear";
_mapdata.Clear();
 //BA.debugLineNum = 43;BA.debugLine="mapData=G.copyMap(gMap)";
_mapdata = _g._copymap(_gmap);
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return "";
}
public String  _escapehtml(String _raw) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
char _c = '\0';
 //BA.debugLineNum = 215;BA.debugLine="Public Sub EscapeHtml(Raw As String) As String";
 //BA.debugLineNum = 216;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 217;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 218;BA.debugLine="For i = 0 To Raw.Length - 1";
{
final int step3 = 1;
final int limit3 = (int) (_raw.length()-1);
for (_i = (int) (0) ; (step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3); _i = ((int)(0 + _i + step3)) ) {
 //BA.debugLineNum = 219;BA.debugLine="Dim C As Char = Raw.CharAt(i)";
_c = _raw.charAt(_i);
 //BA.debugLineNum = 220;BA.debugLine="Select C";
switch (BA.switchObjectToInt(_c,BA.ObjectToChar(__c.QUOTE),BA.ObjectToChar("'"),BA.ObjectToChar("<"),BA.ObjectToChar(">"),BA.ObjectToChar("&"),BA.ObjectToChar(" "),BA.ObjectToChar(__c.CRLF))) {
case 0: {
 //BA.debugLineNum = 222;BA.debugLine="sb.Append(\"&quot;\")";
_sb.Append("&quot;");
 break; }
case 1: {
 //BA.debugLineNum = 224;BA.debugLine="sb.Append(\"&#39;\")";
_sb.Append("&#39;");
 break; }
case 2: {
 //BA.debugLineNum = 226;BA.debugLine="sb.Append(\"&lt;\")";
_sb.Append("&lt;");
 break; }
case 3: {
 //BA.debugLineNum = 228;BA.debugLine="sb.Append(\"&gt;\")";
_sb.Append("&gt;");
 break; }
case 4: {
 //BA.debugLineNum = 230;BA.debugLine="sb.Append(\"&amp;\")";
_sb.Append("&amp;");
 break; }
case 5: {
 //BA.debugLineNum = 232;BA.debugLine="sb.Append(\"&nbsp;\")";
_sb.Append("&nbsp;");
 break; }
case 6: {
 //BA.debugLineNum = 234;BA.debugLine="sb.Append(\"<br>\")";
_sb.Append("<br>");
 break; }
default: {
 //BA.debugLineNum = 236;BA.debugLine="sb.Append(C)";
_sb.Append(BA.ObjectToString(_c));
 break; }
}
;
 }
};
 //BA.debugLineNum = 239;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public Object  _getdata(String _key) throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Public Sub getData(key As String) As Object";
 //BA.debugLineNum = 51;BA.debugLine="If mapData.ContainsKey(key) Then Return mapData.G";
if (_mapdata.ContainsKey((Object)(_key))) { 
if (true) return _mapdata.Get((Object)(_key));}
else {
if (true) return (Object)("");};
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return null;
}
public String  _gettplcontent(String _tplfilepath) throws Exception{
String _tmp0 = "";
String _tplpath = "";
 //BA.debugLineNum = 83;BA.debugLine="Private Sub getTPLContent(TPLFilePath As String) A";
 //BA.debugLineNum = 85;BA.debugLine="Dim tmp0 As String";
_tmp0 = "";
 //BA.debugLineNum = 86;BA.debugLine="If TPLFilePath.EndsWith(TPLFileExt)=False Then TP";
if (_tplfilepath.endsWith(_tplfileext)==__c.False) { 
_tplfilepath = _tplfilepath+_tplfileext;};
 //BA.debugLineNum = 87;BA.debugLine="Dim tplpath As String=getTPLPath";
_tplpath = _gettplpath();
 //BA.debugLineNum = 89;BA.debugLine="If File.Exists(tplpath,TPLFilePath) Then";
if (__c.File.Exists(_tplpath,_tplfilepath)) { 
 //BA.debugLineNum = 90;BA.debugLine="tmp0=File.ReadString(tplpath,TPLFilePath)";
_tmp0 = __c.File.ReadString(_tplpath,_tplfilepath);
 //BA.debugLineNum = 91;BA.debugLine="tmp0=processIncludes(tmp0)";
_tmp0 = _processincludes(_tmp0);
 //BA.debugLineNum = 92;BA.debugLine="tmp0=processIF(tmp0)";
_tmp0 = _processif(_tmp0);
 //BA.debugLineNum = 93;BA.debugLine="tmp0=processFOR(tmp0)";
_tmp0 = _processfor(_tmp0);
 //BA.debugLineNum = 94;BA.debugLine="tmp0=processMapVar(tmp0)";
_tmp0 = _processmapvar(_tmp0);
 //BA.debugLineNum = 95;BA.debugLine="tmp0=processVar(tmp0)";
_tmp0 = _processvar(_tmp0);
 }else {
 //BA.debugLineNum = 98;BA.debugLine="Log(\"Error:TPLFile:\"&getTPLPath& TPLFilePath&\" N";
__c.Log("Error:TPLFile:"+_gettplpath()+_tplfilepath+" Not exist!");
 };
 //BA.debugLineNum = 100;BA.debugLine="Return tmp0";
if (true) return _tmp0;
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public String  _gettplpath() throws Exception{
String _tplpath = "";
 //BA.debugLineNum = 205;BA.debugLine="Private Sub getTPLPath As String";
 //BA.debugLineNum = 206;BA.debugLine="Dim tplpath As String=File.Combine(File.DirApp,Vi";
_tplpath = __c.File.Combine(__c.File.getDirApp(),_viewbasepath);
 //BA.debugLineNum = 207;BA.debugLine="If ThemeName.Length>0 Then";
if (_themename.length()>0) { 
 //BA.debugLineNum = 208;BA.debugLine="tplpath=File.Combine(tplpath,ThemeName)";
_tplpath = __c.File.Combine(_tplpath,_themename);
 //BA.debugLineNum = 209;BA.debugLine="If File.Exists(tplpath,ThemeName)=False Or File.";
if (__c.File.Exists(_tplpath,_themename)==__c.False || __c.File.IsDirectory(_tplpath,_themename)==__c.False) { 
 //BA.debugLineNum = 210;BA.debugLine="File.MakeDir(tplpath,ThemeName)";
__c.File.MakeDir(_tplpath,_themename);
 };
 };
 //BA.debugLineNum = 213;BA.debugLine="Return tplpath";
if (true) return _tplpath;
 //BA.debugLineNum = 214;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 21;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 22;BA.debugLine="bc.LittleEndian = True";
_bc.setLittleEndian(__c.True);
 //BA.debugLineNum = 23;BA.debugLine="devMode=True";
_devmode = __c.True;
 //BA.debugLineNum = 24;BA.debugLine="mapData.Initialize";
_mapdata.Initialize();
 //BA.debugLineNum = 25;BA.debugLine="ThemeName=\"default\"";
_themename = "default";
 //BA.debugLineNum = 26;BA.debugLine="ViewBasePath=\"view\"";
_viewbasepath = "view";
 //BA.debugLineNum = 27;BA.debugLine="TPLFileExt=\".html\"";
_tplfileext = ".html";
 //BA.debugLineNum = 28;BA.debugLine="If File.Exists(File.DirApp,\"view\")=False Or File.";
if (__c.File.Exists(__c.File.getDirApp(),"view")==__c.False || __c.File.IsDirectory(__c.File.getDirApp(),"File.DirApp")==__c.False) { 
 //BA.debugLineNum = 30;BA.debugLine="File.MakeDir(File.DirApp,\"view\")";
__c.File.MakeDir(__c.File.getDirApp(),"view");
 };
 //BA.debugLineNum = 32;BA.debugLine="If File.Exists(File.Combine(File.DirApp,\"view\"),T";
if (__c.File.Exists(__c.File.Combine(__c.File.getDirApp(),"view"),_themename)==__c.False) { 
 //BA.debugLineNum = 33;BA.debugLine="File.MakeDir(File.Combine(File.DirApp,\"view\"),Th";
__c.File.MakeDir(__c.File.Combine(__c.File.getDirApp(),"view"),_themename);
 };
 //BA.debugLineNum = 35;BA.debugLine="gMap.Initialize";
_gmap.Initialize();
 //BA.debugLineNum = 36;BA.debugLine="gMap.Put(\"headertitle\",\"WebPlus演示\")";
_gmap.Put((Object)("headertitle"),(Object)("WebPlus演示"));
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public String  _mlog(String _msg) throws Exception{
 //BA.debugLineNum = 244;BA.debugLine="Private Sub mLog(msg As String)";
 //BA.debugLineNum = 245;BA.debugLine="If devMode Then";
if (_devmode) { 
 //BA.debugLineNum = 246;BA.debugLine="Log(msg)";
__c.Log(_msg);
 };
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return "";
}
public String  _processfor(String _tmp0) throws Exception{
 //BA.debugLineNum = 103;BA.debugLine="Private Sub processFOR(tmp0 As String) As String";
 //BA.debugLineNum = 104;BA.debugLine="Return tmp0";
if (true) return _tmp0;
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public String  _processif(String _tmp0) throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Private Sub processIF(tmp0 As String) As String";
 //BA.debugLineNum = 108;BA.debugLine="Return tmp0";
if (true) return _tmp0;
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public String  _processincludes(String _tmp0) throws Exception{
String _regsign0 = "";
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _tplincludes = null;
String _match0 = "";
String _matchpath = "";
String _matchcontent = "";
 //BA.debugLineNum = 110;BA.debugLine="Private Sub processIncludes(tmp0 As String) As Str";
 //BA.debugLineNum = 112;BA.debugLine="Dim regsign0 As String=$\"\\{#\\s*include.*?\\s*#\\}\"$";
_regsign0 = ("\\{#\\s*include.*?\\s*#\\}");
 //BA.debugLineNum = 113;BA.debugLine="Dim tplincludes As Matcher= Regex.Matcher(regsign";
_tplincludes = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_tplincludes = __c.Regex.Matcher(_regsign0,_tmp0);
 //BA.debugLineNum = 114;BA.debugLine="Do While tplincludes.Find";
while (_tplincludes.Find()) {
 //BA.debugLineNum = 115;BA.debugLine="Dim match0 As String=tplincludes.Match&\"\"";
_match0 = _tplincludes.getMatch()+"";
 //BA.debugLineNum = 116;BA.debugLine="Dim matchpath As String=match0";
_matchpath = _match0;
 //BA.debugLineNum = 117;BA.debugLine="matchpath=G.getText(matchpath,QUOTE,QUOTE,True)'";
_matchpath = _g._gettext(_matchpath,__c.QUOTE,__c.QUOTE,__c.True);
 //BA.debugLineNum = 118;BA.debugLine="Dim matchcontent As String= getTPLContent(matchp";
_matchcontent = _gettplcontent(_matchpath);
 //BA.debugLineNum = 119;BA.debugLine="match0=replaceRegexSpecal(match0)";
_match0 = _replaceregexspecal(_match0);
 //BA.debugLineNum = 120;BA.debugLine="tmp0=Regex.Replace(match0,tmp0,replaceRegexSpeca";
_tmp0 = __c.Regex.Replace(_match0,_tmp0,_replaceregexspecal(_matchcontent));
 }
;
 //BA.debugLineNum = 123;BA.debugLine="Return tmp0";
if (true) return _tmp0;
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public String  _processmapvar(String _tmp0) throws Exception{
String _regsign0 = "";
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _tplvars = null;
String _match0 = "";
boolean _needhtml = false;
String _matchedvarname = "";
String _varcontent = "";
String[] _matchedvarnames = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 126;BA.debugLine="Private Sub processMapVar(tmp0 As String) As Strin";
 //BA.debugLineNum = 128;BA.debugLine="Dim regsign0 As String=$\"{#\\s*[a-zA-z]+\\.+[^\\s]*\\";
_regsign0 = ("{#\\s*[a-zA-z]+\\.+[^\\s]*\\s*#}");
 //BA.debugLineNum = 129;BA.debugLine="regsign0=replaceRegexSpecal(regsign0)";
_regsign0 = _replaceregexspecal(_regsign0);
 //BA.debugLineNum = 130;BA.debugLine="Dim tplvars As Matcher=Regex.Matcher(regsign0,tmp";
_tplvars = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_tplvars = __c.Regex.Matcher(_regsign0,_tmp0);
 //BA.debugLineNum = 131;BA.debugLine="Do While tplvars.Find";
while (_tplvars.Find()) {
 //BA.debugLineNum = 132;BA.debugLine="Dim match0 As String=tplvars.Match";
_match0 = _tplvars.getMatch();
 //BA.debugLineNum = 133;BA.debugLine="mLog(match0)";
_mlog(_match0);
 //BA.debugLineNum = 134;BA.debugLine="Dim needhtml As Boolean=False";
_needhtml = __c.False;
 //BA.debugLineNum = 135;BA.debugLine="Dim matchedvarname As String=match0.Replace(\"{\",";
_matchedvarname = _match0.replace("{","").replace("}","").replace("#","").replace("$","").trim();
 //BA.debugLineNum = 136;BA.debugLine="needhtml=matchedvarname.StartsWith(\"h_\")'如果变量名以h";
_needhtml = _matchedvarname.startsWith("h_");
 //BA.debugLineNum = 137;BA.debugLine="matchedvarname=matchedvarname.Replace(\"h_\",\"\")";
_matchedvarname = _matchedvarname.replace("h_","");
 //BA.debugLineNum = 138;BA.debugLine="Dim varcontent As String";
_varcontent = "";
 //BA.debugLineNum = 139;BA.debugLine="Dim matchedvarnames() As String=Regex.Split(\"\\.\"";
_matchedvarnames = __c.Regex.Split("\\.",_matchedvarname);
 //BA.debugLineNum = 140;BA.debugLine="If matchedvarnames.Length>0 Then";
if (_matchedvarnames.length>0) { 
 //BA.debugLineNum = 141;BA.debugLine="If mapData.ContainsKey(matchedvarnames(0)) Then";
if (_mapdata.ContainsKey((Object)(_matchedvarnames[(int) (0)]))) { 
 //BA.debugLineNum = 142;BA.debugLine="Dim m As Map=mapData.Get(matchedvarnames(0))";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_mapdata.Get((Object)(_matchedvarnames[(int) (0)]))));
 //BA.debugLineNum = 143;BA.debugLine="varcontent=m.GetDefault(matchedvarnames(1),mat";
_varcontent = BA.ObjectToString(_m.GetDefault((Object)(_matchedvarnames[(int) (1)]),(Object)(_matchedvarnames[(int) (1)])));
 }else {
 //BA.debugLineNum = 145;BA.debugLine="varcontent=\"map:\"&matchedvarnames(0)&\" not exi";
_varcontent = "map:"+_matchedvarnames[(int) (0)]+" not exist";
 };
 }else {
 //BA.debugLineNum = 148;BA.debugLine="If mapData.ContainsKey(matchedvarname) Then";
if (_mapdata.ContainsKey((Object)(_matchedvarname))) { 
 //BA.debugLineNum = 150;BA.debugLine="varcontent= mapData.GetDefault(matchedvarname,";
_varcontent = BA.ObjectToString(_mapdata.GetDefault((Object)(_matchedvarname),(Object)(_matchedvarname)));
 //BA.debugLineNum = 151;BA.debugLine="If needhtml Then varcontent=EscapeHtml(varcont";
if (_needhtml) { 
_varcontent = _escapehtml(_varcontent);};
 }else {
 //BA.debugLineNum = 154;BA.debugLine="varcontent=\"unknown var:\"&matchedvarname";
_varcontent = "unknown var:"+_matchedvarname;
 };
 };
 //BA.debugLineNum = 157;BA.debugLine="match0=replaceRegexSpecal(match0)";
_match0 = _replaceregexspecal(_match0);
 //BA.debugLineNum = 158;BA.debugLine="tmp0=Regex.Replace(match0,tmp0,replaceRegexSpeca";
_tmp0 = __c.Regex.Replace(_match0,_tmp0,_replaceregexspecal(_varcontent));
 }
;
 //BA.debugLineNum = 160;BA.debugLine="Return tmp0";
if (true) return _tmp0;
 //BA.debugLineNum = 161;BA.debugLine="End Sub";
return "";
}
public String  _processvar(String _tmp0) throws Exception{
String _regsign0 = "";
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _tplvars = null;
String _match0 = "";
boolean _needhtml = false;
String _matchedvarname = "";
String _varcontent = "";
String[] _matchedvarnames = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 163;BA.debugLine="Private Sub processVar(tmp0 As String) As String";
 //BA.debugLineNum = 165;BA.debugLine="Dim regsign0 As String=$\"{#\\s*$.*?\\s*#}\"$";
_regsign0 = ("{#\\s*$.*?\\s*#}");
 //BA.debugLineNum = 166;BA.debugLine="regsign0=replaceRegexSpecal(regsign0)";
_regsign0 = _replaceregexspecal(_regsign0);
 //BA.debugLineNum = 167;BA.debugLine="Dim tplvars As Matcher=Regex.Matcher(regsign0,tmp";
_tplvars = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_tplvars = __c.Regex.Matcher(_regsign0,_tmp0);
 //BA.debugLineNum = 168;BA.debugLine="Do While tplvars.Find";
while (_tplvars.Find()) {
 //BA.debugLineNum = 169;BA.debugLine="Dim match0 As String=tplvars.Match";
_match0 = _tplvars.getMatch();
 //BA.debugLineNum = 170;BA.debugLine="mLog(match0)";
_mlog(_match0);
 //BA.debugLineNum = 171;BA.debugLine="Dim needhtml As Boolean=False";
_needhtml = __c.False;
 //BA.debugLineNum = 172;BA.debugLine="Dim matchedvarname As String=match0.Replace(\"{\",";
_matchedvarname = _match0.replace("{","").replace("}","").replace("#","").replace("$","").trim();
 //BA.debugLineNum = 173;BA.debugLine="needhtml=matchedvarname.StartsWith(\"h_\")'如果变量名以h";
_needhtml = _matchedvarname.startsWith("h_");
 //BA.debugLineNum = 174;BA.debugLine="matchedvarname=matchedvarname.Replace(\"h_\",\"\")";
_matchedvarname = _matchedvarname.replace("h_","");
 //BA.debugLineNum = 175;BA.debugLine="Dim varcontent As String";
_varcontent = "";
 //BA.debugLineNum = 176;BA.debugLine="Dim matchedvarnames() As String=Regex.Split(\".\",";
_matchedvarnames = __c.Regex.Split(".",_matchedvarname);
 //BA.debugLineNum = 177;BA.debugLine="If matchedvarnames.Length>0 Then";
if (_matchedvarnames.length>0) { 
 //BA.debugLineNum = 178;BA.debugLine="If mapData.ContainsKey(matchedvarnames(0)) Then";
if (_mapdata.ContainsKey((Object)(_matchedvarnames[(int) (0)]))) { 
 //BA.debugLineNum = 179;BA.debugLine="Dim m As Map=mapData.Get(matchedvarnames(0))";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_mapdata.Get((Object)(_matchedvarnames[(int) (0)]))));
 //BA.debugLineNum = 180;BA.debugLine="varcontent=m.GetDefault(matchedvarnames(1),mat";
_varcontent = BA.ObjectToString(_m.GetDefault((Object)(_matchedvarnames[(int) (1)]),(Object)(_matchedvarnames[(int) (1)])));
 }else {
 //BA.debugLineNum = 182;BA.debugLine="varcontent=\"map:\"&matchedvarnames(0)&\" not exi";
_varcontent = "map:"+_matchedvarnames[(int) (0)]+" not exist";
 };
 }else {
 //BA.debugLineNum = 185;BA.debugLine="If mapData.ContainsKey(matchedvarname) Then";
if (_mapdata.ContainsKey((Object)(_matchedvarname))) { 
 //BA.debugLineNum = 187;BA.debugLine="varcontent= mapData.GetDefault(matchedvarname,";
_varcontent = BA.ObjectToString(_mapdata.GetDefault((Object)(_matchedvarname),(Object)(_matchedvarname)));
 //BA.debugLineNum = 188;BA.debugLine="If needhtml Then varcontent=EscapeHtml(varcont";
if (_needhtml) { 
_varcontent = _escapehtml(_varcontent);};
 //BA.debugLineNum = 189;BA.debugLine="match0=replaceRegexSpecal(match0)";
_match0 = _replaceregexspecal(_match0);
 }else {
 //BA.debugLineNum = 193;BA.debugLine="varcontent=\"unknown var:\"&matchedvarname";
_varcontent = "unknown var:"+_matchedvarname;
 };
 };
 //BA.debugLineNum = 196;BA.debugLine="tmp0=Regex.Replace(match0,tmp0,replaceRegexSpeca";
_tmp0 = __c.Regex.Replace(_match0,_tmp0,_replaceregexspecal(_varcontent));
 }
;
 //BA.debugLineNum = 198;BA.debugLine="Return tmp0";
if (true) return _tmp0;
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public String  _putdata(String _key,Object _val) throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Public Sub putData(key As String,val As Object)";
 //BA.debugLineNum = 47;BA.debugLine="mapData.Put(key,val)";
_mapdata.Put((Object)(_key),_val);
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public String  _renderjson(boolean _success,Object _data) throws Exception{
anywheresoftware.b4a.objects.collections.Map _ret = null;
 //BA.debugLineNum = 63;BA.debugLine="Public Sub renderJson(success As Boolean,data As O";
 //BA.debugLineNum = 64;BA.debugLine="res.ContentType=\"application/json\"";
_res.setContentType("application/json");
 //BA.debugLineNum = 65;BA.debugLine="res.CharacterEncoding=\"UTF-8\"";
_res.setCharacterEncoding("UTF-8");
 //BA.debugLineNum = 66;BA.debugLine="Dim ret As Map";
_ret = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 67;BA.debugLine="ret.Initialize";
_ret.Initialize();
 //BA.debugLineNum = 68;BA.debugLine="If success Then ret.Put(\"code\",200) Else ret.Put(";
if (_success) { 
_ret.Put((Object)("code"),(Object)(200));}
else {
_ret.Put((Object)("code"),(Object)(500));};
 //BA.debugLineNum = 69;BA.debugLine="ret.Put(\"data\",data)";
_ret.Put((Object)("data"),_data);
 //BA.debugLineNum = 70;BA.debugLine="jsg.Initialize(ret)";
_jsg.Initialize(_ret);
 //BA.debugLineNum = 71;BA.debugLine="res.Write(jsg.ToPrettyString(1))";
_res.Write(_jsg.ToPrettyString((int) (1)));
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public String  _rendertext(String _htmlsrc) throws Exception{
 //BA.debugLineNum = 57;BA.debugLine="Public Sub renderText(htmlsrc As String)";
 //BA.debugLineNum = 58;BA.debugLine="res.ContentType=\"text/html\"";
_res.setContentType("text/html");
 //BA.debugLineNum = 59;BA.debugLine="res.CharacterEncoding=\"UTF-8\"";
_res.setCharacterEncoding("UTF-8");
 //BA.debugLineNum = 60;BA.debugLine="res.Write(htmlsrc)";
_res.Write(_htmlsrc);
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public String  _rendertpl(String _tplfilepath) throws Exception{
long _begints = 0L;
String _htmlsrc = "";
 //BA.debugLineNum = 75;BA.debugLine="Public Sub renderTPL(TPLFilePath As String)";
 //BA.debugLineNum = 76;BA.debugLine="Log(\"rending:\"&TPLFilePath)";
__c.Log("rending:"+_tplfilepath);
 //BA.debugLineNum = 77;BA.debugLine="Dim begints As Long=DateTime.Now";
_begints = __c.DateTime.getNow();
 //BA.debugLineNum = 78;BA.debugLine="Dim htmlsrc As String= getTPLContent(TPLFilePath)";
_htmlsrc = _gettplcontent(_tplfilepath);
 //BA.debugLineNum = 79;BA.debugLine="Log(\"rending:\"&TPLFilePath&\" complete within:\"&(D";
__c.Log("rending:"+_tplfilepath+" complete within:"+BA.NumberToString((__c.DateTime.getNow()-_begints))+"ms");
 //BA.debugLineNum = 80;BA.debugLine="renderText(htmlsrc)";
_rendertext(_htmlsrc);
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public String  _replaceregexspecal(String _str) throws Exception{
 //BA.debugLineNum = 201;BA.debugLine="Private Sub replaceRegexSpecal(str As String) As S";
 //BA.debugLineNum = 202;BA.debugLine="Return str.Replace(\"{\",\"\\{\").Replace(\"}\",\"\\}\").Re";
if (true) return _str.replace("{","\\{").replace("}","\\}").replace("$","\\$").replace("<","\\<").replace(">","\\>").replace("/","\\/");
 //BA.debugLineNum = 203;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}