package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class getsscdata extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.getsscdata", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.getsscdata.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _cmd = "";
public String _typ = "";
public anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _mresp = null;
public anywheresoftware.b4a.objects.collections.Map _mextra = null;
public b4j.example.httputils2service _httputils2service = null;
public b4j.example.main _main = null;
public String  _checkver(String _ver,String _app) throws Exception{
anywheresoftware.b4j.objects.collections.JSONParser _jsp = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 101;BA.debugLine="Private Sub checkver(ver As String,app As String)";
 //BA.debugLineNum = 102;BA.debugLine="Dim jsp As JSONParser";
_jsp = new anywheresoftware.b4j.objects.collections.JSONParser();
 //BA.debugLineNum = 103;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 104;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 105;BA.debugLine="jsp.Initialize(File.ReadString(\"\",File.DirApp&\"/w";
_jsp.Initialize(__c.File.ReadString("",__c.File.getDirApp()+"/www/version.json"));
 //BA.debugLineNum = 106;BA.debugLine="Dim m As Map=jsp.NextObject";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = _jsp.NextObject();
 //BA.debugLineNum = 107;BA.debugLine="If ver.EqualsIgnoreCase(m.GetDefault(\"release\",\"\"";
if (_ver.equalsIgnoreCase(BA.ObjectToString(_m.GetDefault((Object)("release"),(Object)("")))) || _ver.length()==0) { 
 }else {
 //BA.debugLineNum = 110;BA.debugLine="sb.Append(\"<div id='update' class='update'>\")";
_sb.Append("<div id='update' class='update'>");
 //BA.debugLineNum = 111;BA.debugLine="sb.Append(\"最新版本:\"&m.GetDefault(\"release\",\"\")&\"<b";
_sb.Append("最新版本:"+BA.ObjectToString(_m.GetDefault((Object)("release"),(Object)("")))+"<br>");
 //BA.debugLineNum = 112;BA.debugLine="sb.Append(\"你的版本:\"&ver&\"<br>\")";
_sb.Append("你的版本:"+_ver+"<br>");
 //BA.debugLineNum = 113;BA.debugLine="sb.Append(\"更新内容:\"&m.GetDefault(\"update\",\"\")&\"<br";
_sb.Append("更新内容:"+BA.ObjectToString(_m.GetDefault((Object)("update"),(Object)("")))+"<br>");
 //BA.debugLineNum = 114;BA.debugLine="sb.Append(\"下载地址:<a href='\"&m.GetDefault(\"url\",\"\"";
_sb.Append("下载地址:<a href='"+BA.ObjectToString(_m.GetDefault((Object)("url"),(Object)("")))+"'>点击下载</a></div>");
 };
 //BA.debugLineNum = 116;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private cmd As String,typ As String";
_cmd = "";
_typ = "";
 //BA.debugLineNum = 4;BA.debugLine="Private mResp As ServletResponse";
_mresp = new anywheresoftware.b4j.object.JServlet.ServletResponseWrapper();
 //BA.debugLineNum = 5;BA.debugLine="Private mExtra As Map";
_mextra = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return "";
}
public String  _donetrefush() throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Private Sub donetRefush";
 //BA.debugLineNum = 44;BA.debugLine="getsscdata163";
_getsscdata163();
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public int  _getcurmin() throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Private Sub getcurmin As Int";
 //BA.debugLineNum = 62;BA.debugLine="Return DateTime.GetMinute(DateTime.Now) mod 10";
if (true) return (int) (__c.DateTime.GetMinute(__c.DateTime.getNow())%10);
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return 0;
}
public String  _getsscdata163() throws Exception{
b4j.example.httpjob _hj = null;
 //BA.debugLineNum = 246;BA.debugLine="Public Sub getsscdata163";
 //BA.debugLineNum = 247;BA.debugLine="Log(\"get once by 163\")";
__c.Log("get once by 163");
 //BA.debugLineNum = 248;BA.debugLine="Main.bLoading=True";
_main._bloading = __c.True;
 //BA.debugLineNum = 249;BA.debugLine="Dim hj As HttpJob";
_hj = new b4j.example.httpjob();
 //BA.debugLineNum = 250;BA.debugLine="hj.Initialize(\"163\",Me)";
_hj._initialize(ba,"163",this);
 //BA.debugLineNum = 251;BA.debugLine="If Main.num<>30 And Main.num<>50 And Main.num<>10";
if (_main._num!=30 && _main._num!=50 && _main._num!=100) { 
_main._num = (int) (30);};
 //BA.debugLineNum = 252;BA.debugLine="hj.Download($\"http://trend.caipiao.163.com/cqssc/";
_hj._download(("http://trend.caipiao.163.com/cqssc/jiben-5xing.html?periodNumber="+__c.SmartStringFormatter("",(Object)(_main._num))+""));
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
public String  _getsscdata360() throws Exception{
b4j.example.httpjob _hj = null;
 //BA.debugLineNum = 267;BA.debugLine="Public Sub getsscdata360";
 //BA.debugLineNum = 268;BA.debugLine="Log(\"get once by 360\")";
__c.Log("get once by 360");
 //BA.debugLineNum = 269;BA.debugLine="Main.bLoading=True";
_main._bloading = __c.True;
 //BA.debugLineNum = 270;BA.debugLine="Dim hj As HttpJob";
_hj = new b4j.example.httpjob();
 //BA.debugLineNum = 271;BA.debugLine="hj.Initialize(\"360\",Me)";
_hj._initialize(ba,"360",this);
 //BA.debugLineNum = 272;BA.debugLine="If Main.num<>30 And Main.num<>50 And Main.num<>10";
if (_main._num!=30 && _main._num!=50 && _main._num!=100) { 
_main._num = (int) (30);};
 //BA.debugLineNum = 273;BA.debugLine="hj.Download($\"http://chart.cp.360.cn/zst/getchart";
_hj._download(("http://chart.cp.360.cn/zst/getchartdata?lotId=255401&chartType=x5&spanType=0&span="+__c.SmartStringFormatter("",(Object)(_main._num))+""));
 //BA.debugLineNum = 274;BA.debugLine="End Sub";
return "";
}
public String  _getsscdatacjcp() throws Exception{
b4j.example.httpjob _hj = null;
 //BA.debugLineNum = 277;BA.debugLine="Public Sub getsscdatacjcp";
 //BA.debugLineNum = 278;BA.debugLine="Log(\"get once by cjcp\")";
__c.Log("get once by cjcp");
 //BA.debugLineNum = 279;BA.debugLine="Main.bLoading=True";
_main._bloading = __c.True;
 //BA.debugLineNum = 280;BA.debugLine="Dim hj As HttpJob";
_hj = new b4j.example.httpjob();
 //BA.debugLineNum = 281;BA.debugLine="hj.Initialize(\"cjcp\",Me)";
_hj._initialize(ba,"cjcp",this);
 //BA.debugLineNum = 282;BA.debugLine="If Main.num<>30 And Main.num<>50 And Main.num<>10";
if (_main._num!=30 && _main._num!=50 && _main._num!=100) { 
_main._num = (int) (30);};
 //BA.debugLineNum = 283;BA.debugLine="hj.Download($\"http://zst.cjcp.com.cn/cjwssc/view/";
_hj._download(("http://zst.cjcp.com.cn/cjwssc/view/ssc_zonghe-zonghe-5-chongqinssc-0-3-"+__c.SmartStringFormatter("",(Object)(_main._num))+".html"));
 //BA.debugLineNum = 284;BA.debugLine="End Sub";
return "";
}
public String  _getsscdatajw() throws Exception{
b4j.example.httpjob _hj = null;
 //BA.debugLineNum = 257;BA.debugLine="Public Sub getsscdatajw";
 //BA.debugLineNum = 258;BA.debugLine="Log(\"get once by jw\")";
__c.Log("get once by jw");
 //BA.debugLineNum = 259;BA.debugLine="Main.bLoading=True";
_main._bloading = __c.True;
 //BA.debugLineNum = 260;BA.debugLine="Dim hj As HttpJob";
_hj = new b4j.example.httpjob();
 //BA.debugLineNum = 261;BA.debugLine="hj.Initialize(\"jw\",Me)";
_hj._initialize(ba,"jw",this);
 //BA.debugLineNum = 262;BA.debugLine="If Main.num<>30 And Main.num<>50 And Main.num<>10";
if (_main._num!=30 && _main._num!=50 && _main._num!=100) { 
_main._num = (int) (30);};
 //BA.debugLineNum = 263;BA.debugLine="hj.Download($\"http://web.jw909.com:1688/cpp/ic?op";
_hj._download(("http://web.jw909.com:1688/cpp/ic?op=0&lottery_id=1&n="+__c.SmartStringFormatter("",(Object)(_main._num))+""));
 //BA.debugLineNum = 264;BA.debugLine="End Sub";
return "";
}
public String  _handle(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
String _num = "";
 //BA.debugLineNum = 12;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
 //BA.debugLineNum = 13;BA.debugLine="mResp=resp";
_mresp = _resp;
 //BA.debugLineNum = 14;BA.debugLine="mResp.CharacterEncoding=\"UTF-8\"";
_mresp.setCharacterEncoding("UTF-8");
 //BA.debugLineNum = 15;BA.debugLine="mExtra.Initialize";
_mextra.Initialize();
 //BA.debugLineNum = 16;BA.debugLine="mExtra.Put(\"app\",req.GetParameter(\"apptyp\"))";
_mextra.Put((Object)("app"),(Object)(_req.GetParameter("apptyp")));
 //BA.debugLineNum = 17;BA.debugLine="mExtra.Put(\"ver\",req.GetParameter(\"ver\"))";
_mextra.Put((Object)("ver"),(Object)(_req.GetParameter("ver")));
 //BA.debugLineNum = 18;BA.debugLine="cmd=req.GetParameter(\"cmd\").ToLowerCase";
_cmd = _req.GetParameter("cmd").toLowerCase();
 //BA.debugLineNum = 19;BA.debugLine="typ=req.GetParameter(\"typ\").ToLowerCase";
_typ = _req.GetParameter("typ").toLowerCase();
 //BA.debugLineNum = 20;BA.debugLine="If typ.Length<1 Then typ=\"json\"";
if (_typ.length()<1) { 
_typ = "json";};
 //BA.debugLineNum = 21;BA.debugLine="Select cmd";
switch (BA.switchObjectToInt(_cmd,"1")) {
case 0: {
 //BA.debugLineNum = 23;BA.debugLine="Dim num As String=req.GetParameter(\"num\")";
_num = _req.GetParameter("num");
 //BA.debugLineNum = 24;BA.debugLine="If num=Null Or num.Length<1 Then num=\"30\"";
if (_num== null || _num.length()<1) { 
_num = "30";};
 //BA.debugLineNum = 25;BA.debugLine="If needrefush(num) Then";
if (_needrefush((int)(Double.parseDouble(_num)))) { 
 //BA.debugLineNum = 26;BA.debugLine="donetRefush";
_donetrefush();
 //BA.debugLineNum = 27;BA.debugLine="StartMessageLoop";
__c.StartMessageLoop(ba);
 }else {
 //BA.debugLineNum = 29;BA.debugLine="outputs";
_outputs();
 };
 break; }
}
;
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 8;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public String  _jobdone(b4j.example.httpjob _thj) throws Exception{
String _str = "";
anywheresoftware.b4a.objects.collections.List _lst = null;
 //BA.debugLineNum = 64;BA.debugLine="Sub JobDone(thj As HttpJob)";
 //BA.debugLineNum = 65;BA.debugLine="Log(\"Job:\"&thj.JobName&\" \"&thj.Success)";
__c.Log("Job:"+_thj._jobname+" "+BA.ObjectToString(_thj._success));
 //BA.debugLineNum = 66;BA.debugLine="Main.tLastTickets=DateTime.Now";
_main._tlasttickets = __c.DateTime.getNow();
 //BA.debugLineNum = 67;BA.debugLine="If thj.Success Then";
if (_thj._success) { 
 //BA.debugLineNum = 68;BA.debugLine="Dim str As String=thj.GetString";
_str = _thj._getstring();
 //BA.debugLineNum = 69;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 70;BA.debugLine="Select thj.JobName.ToLowerCase";
switch (BA.switchObjectToInt(_thj._jobname.toLowerCase(),"163","jw","cjcp","360")) {
case 0: {
 //BA.debugLineNum = 72;BA.debugLine="lst=ParseSSC_163(str)";
_lst = _parsessc_163(_str);
 //BA.debugLineNum = 73;BA.debugLine="Main.mData=lst";
_main._mdata = _lst;
 break; }
case 1: {
 //BA.debugLineNum = 76;BA.debugLine="lst=ParseSSC_jw(str)";
_lst = _parsessc_jw(_str);
 //BA.debugLineNum = 77;BA.debugLine="Main.mData=lst";
_main._mdata = _lst;
 break; }
case 2: {
 //BA.debugLineNum = 80;BA.debugLine="lst=ParseSSC_cjcp(str)";
_lst = _parsessc_cjcp(_str);
 //BA.debugLineNum = 81;BA.debugLine="Main.mData=lst";
_main._mdata = _lst;
 break; }
case 3: {
 //BA.debugLineNum = 83;BA.debugLine="lst=ParseSSC_360(str)";
_lst = _parsessc_360(_str);
 //BA.debugLineNum = 84;BA.debugLine="Main.mData=lst";
_main._mdata = _lst;
 break; }
}
;
 //BA.debugLineNum = 87;BA.debugLine="Log(\"load ok once\")";
__c.Log("load ok once");
 }else {
 //BA.debugLineNum = 89;BA.debugLine="Log(\"joberror:\"&thj.ErrorMessage)";
__c.Log("joberror:"+_thj._errormessage);
 };
 //BA.debugLineNum = 91;BA.debugLine="thj.Release";
_thj._release();
 //BA.debugLineNum = 92;BA.debugLine="Main.bLoading=False";
_main._bloading = __c.False;
 //BA.debugLineNum = 98;BA.debugLine="StopMessageLoop";
__c.StopMessageLoop(ba);
 //BA.debugLineNum = 99;BA.debugLine="outputs";
_outputs();
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return "";
}
public boolean  _needrefush(int _num) throws Exception{
 //BA.debugLineNum = 49;BA.debugLine="Private Sub needrefush(num As Int) As Boolean";
 //BA.debugLineNum = 50;BA.debugLine="If Main.mData.IsInitialized=False Or Main.mData.S";
if (_main._mdata.IsInitialized()==__c.False || _main._mdata.getSize()==0) { 
if (true) return __c.True;};
 //BA.debugLineNum = 51;BA.debugLine="If getcurmin=3 Or getcurmin=4 Or getcurmin=5 Or g";
if (_getcurmin()==3 || _getcurmin()==4 || _getcurmin()==5 || _getcurmin()==8 || _getcurmin()==9 || _getcurmin()==0) { 
if (true) return __c.False;};
 //BA.debugLineNum = 52;BA.debugLine="If (DateTime.Now-Main.tLastTickets)>(Main.nReqMin";
if ((__c.DateTime.getNow()-_main._tlasttickets)>(_main._nreqminsecond*1000) || _main._num<_num) { 
 //BA.debugLineNum = 53;BA.debugLine="Main.num=num";
_main._num = _num;
 //BA.debugLineNum = 54;BA.debugLine="Log(\"loadfromnet\")";
__c.Log("loadfromnet");
 //BA.debugLineNum = 55;BA.debugLine="Return True";
if (true) return __c.True;
 }else {
 //BA.debugLineNum = 57;BA.debugLine="Log(\"loadfromloc\")";
__c.Log("loadfromloc");
 //BA.debugLineNum = 58;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return false;
}
public String  _outputs() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
String _hm = "";
String _qh = "";
int _i = 0;
int _j = 0;
 //BA.debugLineNum = 118;BA.debugLine="Private Sub outputs";
 //BA.debugLineNum = 119;BA.debugLine="If typ.EqualsIgnoreCase(\"json\") Then";
if (_typ.equalsIgnoreCase("json")) { 
 //BA.debugLineNum = 120;BA.debugLine="mResp.Write(Main.getDataJson)";
_mresp.Write(_main._getdatajson());
 }else {
 //BA.debugLineNum = 122;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 123;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 124;BA.debugLine="sb.Append(File.ReadString(\"\",File.DirApp&\"/www/h";
_sb.Append(__c.File.ReadString("",__c.File.getDirApp()+"/www/header.tpl"));
 //BA.debugLineNum = 125;BA.debugLine="sb.Append(checkver(mExtra.GetDefault(\"ver\",\"\"),m";
_sb.Append(_checkver(BA.ObjectToString(_mextra.GetDefault((Object)("ver"),(Object)(""))),BA.ObjectToString(_mextra.GetDefault((Object)("app"),(Object)("")))));
 //BA.debugLineNum = 126;BA.debugLine="sb.Append($\"<table><tr class='border_bottom'><td";
_sb.Append(("<table><tr class='border_bottom'><td>期号</td><td class='tdwxshui'>万</td><td class='tdwxhuo'>千</td><td class='tdwxmu'>百</td><td class='tdwxjin'>十</td><td class='tdwxtu'>个</td></tr>"));
 //BA.debugLineNum = 127;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 128;BA.debugLine="Dim hm,qh As String";
_hm = "";
_qh = "";
 //BA.debugLineNum = 129;BA.debugLine="For i=0 To Main.mData.Size-1";
{
final int step11 = 1;
final int limit11 = (int) (_main._mdata.getSize()-1);
for (_i = (int) (0) ; (step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11); _i = ((int)(0 + _i + step11)) ) {
 //BA.debugLineNum = 130;BA.debugLine="m=Main.mData.Get(i)";
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_main._mdata.Get(_i)));
 //BA.debugLineNum = 131;BA.debugLine="qh=m.Get(\"qh\")";
_qh = BA.ObjectToString(_m.Get((Object)("qh")));
 //BA.debugLineNum = 132;BA.debugLine="hm=m.Get(\"hm\")";
_hm = BA.ObjectToString(_m.Get((Object)("hm")));
 //BA.debugLineNum = 134;BA.debugLine="If qh.Length>0 And hm.Length=5 Then";
if (_qh.length()>0 && _hm.length()==5) { 
 //BA.debugLineNum = 135;BA.debugLine="sb.Append($\"<tr><td>${qh}</td>\"$)";
_sb.Append(("<tr><td>"+__c.SmartStringFormatter("",(Object)(_qh))+"</td>"));
 //BA.debugLineNum = 136;BA.debugLine="For j=0 To 4";
{
final int step17 = 1;
final int limit17 = (int) (4);
for (_j = (int) (0) ; (step17 > 0 && _j <= limit17) || (step17 < 0 && _j >= limit17); _j = ((int)(0 + _j + step17)) ) {
 //BA.debugLineNum = 137;BA.debugLine="sb.Append(withcolor(hm.SubString2(j,j+1)))";
_sb.Append(_withcolor(_hm.substring(_j,(int) (_j+1))));
 }
};
 //BA.debugLineNum = 139;BA.debugLine="sb.Append(\"</tr>\")";
_sb.Append("</tr>");
 };
 }
};
 //BA.debugLineNum = 143;BA.debugLine="sb.Append(File.ReadString(\"\",File.DirApp&\"/www/f";
_sb.Append(__c.File.ReadString("",__c.File.getDirApp()+"/www/footer.tpl"));
 //BA.debugLineNum = 144;BA.debugLine="mResp.Write(sb.ToString)";
_mresp.Write(_sb.ToString());
 };
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _parsessc_163(String _str) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _mc = null;
String _str1 = "";
anywheresoftware.b4a.objects.collections.Map _s1 = null;
String _qh = "";
String _hm = "";
 //BA.debugLineNum = 163;BA.debugLine="Private Sub ParseSSC_163(str As String) As List";
 //BA.debugLineNum = 164;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 165;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 166;BA.debugLine="Dim mc As Matcher=Regex.Matcher($\"\\d{9}\">\\d{5} </";
_mc = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_mc = __c.Regex.Matcher(("\\d{9}\">\\d{5} </span>"),_str);
 //BA.debugLineNum = 167;BA.debugLine="Dim str1 As String";
_str1 = "";
 //BA.debugLineNum = 168;BA.debugLine="Do While mc.Find";
while (_mc.Find()) {
 //BA.debugLineNum = 169;BA.debugLine="str1=mc.Match";
_str1 = _mc.getMatch();
 //BA.debugLineNum = 170;BA.debugLine="Dim s1 As Map,qh As String,hm As String";
_s1 = new anywheresoftware.b4a.objects.collections.Map();
_qh = "";
_hm = "";
 //BA.debugLineNum = 171;BA.debugLine="qh=str1.SubString2(0,str1.IndexOf(\"\"\"\"))";
_qh = _str1.substring((int) (0),_str1.indexOf("\""));
 //BA.debugLineNum = 172;BA.debugLine="hm=str1.SubString2(str1.IndexOf(\">\")+1,str1.Last";
_hm = _str1.substring((int) (_str1.indexOf(">")+1),(int) (_str1.lastIndexOf("<")-1));
 //BA.debugLineNum = 173;BA.debugLine="qh=qh.SubString(qh.Length-3)";
_qh = _qh.substring((int) (_qh.length()-3));
 //BA.debugLineNum = 174;BA.debugLine="s1.Initialize";
_s1.Initialize();
 //BA.debugLineNum = 175;BA.debugLine="s1.Put(\"hm\",hm)";
_s1.Put((Object)("hm"),(Object)(_hm));
 //BA.debugLineNum = 176;BA.debugLine="s1.Put(\"qh\",qh)";
_s1.Put((Object)("qh"),(Object)(_qh));
 //BA.debugLineNum = 177;BA.debugLine="lst.InsertAt(0,s1)";
_lst.InsertAt((int) (0),(Object)(_s1.getObject()));
 //BA.debugLineNum = 178;BA.debugLine="str1=qh";
_str1 = _qh;
 }
;
 //BA.debugLineNum = 180;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 181;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _parsessc_360(String _str) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _mc = null;
String _str1 = "";
anywheresoftware.b4a.objects.collections.Map _s1 = null;
String _qh = "";
String _hm = "";
 //BA.debugLineNum = 222;BA.debugLine="Private Sub ParseSSC_360(str As String) As List";
 //BA.debugLineNum = 223;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 224;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 225;BA.debugLine="Dim mc As Matcher=Regex.Matcher($\"\\d{6}-\\d{3}</td";
_mc = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_mc = __c.Regex.Matcher(("\\d{6}-\\d{3}</td><td class='tdbdr'></td><td class='tdbg_1' ><strong class='num'>\\d{5}"),_str);
 //BA.debugLineNum = 226;BA.debugLine="Dim str1 As String";
_str1 = "";
 //BA.debugLineNum = 227;BA.debugLine="Do While mc.Find";
while (_mc.Find()) {
 //BA.debugLineNum = 228;BA.debugLine="str1=mc.Match";
_str1 = _mc.getMatch();
 //BA.debugLineNum = 229;BA.debugLine="Dim s1 As Map,qh As String,hm As String";
_s1 = new anywheresoftware.b4a.objects.collections.Map();
_qh = "";
_hm = "";
 //BA.debugLineNum = 230;BA.debugLine="qh=str1.SubString2(0,str1.IndexOf(\"<\"))";
_qh = _str1.substring((int) (0),_str1.indexOf("<"));
 //BA.debugLineNum = 231;BA.debugLine="qh=qh.Replace(\"-\",\"\")";
_qh = _qh.replace("-","");
 //BA.debugLineNum = 232;BA.debugLine="hm=str1.SubString2(str1.LastIndexOf(\">\")+1,str1.";
_hm = _str1.substring((int) (_str1.lastIndexOf(">")+1),_str1.length());
 //BA.debugLineNum = 233;BA.debugLine="qh=qh.SubString(qh.Length-3)";
_qh = _qh.substring((int) (_qh.length()-3));
 //BA.debugLineNum = 234;BA.debugLine="s1.Initialize";
_s1.Initialize();
 //BA.debugLineNum = 235;BA.debugLine="s1.Put(\"hm\",hm)";
_s1.Put((Object)("hm"),(Object)(_hm));
 //BA.debugLineNum = 236;BA.debugLine="s1.Put(\"qh\",qh)";
_s1.Put((Object)("qh"),(Object)(_qh));
 //BA.debugLineNum = 237;BA.debugLine="lst.InsertAt(0,s1)";
_lst.InsertAt((int) (0),(Object)(_s1.getObject()));
 //BA.debugLineNum = 238;BA.debugLine="str1=qh";
_str1 = _qh;
 //BA.debugLineNum = 239;BA.debugLine="Log(qh&\" \"&hm)";
__c.Log(_qh+" "+_hm);
 }
;
 //BA.debugLineNum = 241;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 242;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _parsessc_cjcp(String _str) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _mc = null;
String _str1 = "";
anywheresoftware.b4a.objects.collections.Map _s1 = null;
String _qh = "";
String _hm = "";
 //BA.debugLineNum = 203;BA.debugLine="Private Sub ParseSSC_cjcp(str As String) As List";
 //BA.debugLineNum = 204;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 205;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 206;BA.debugLine="Dim mc As Matcher=Regex.Matcher($\"\\d{11}</td><td";
_mc = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_mc = __c.Regex.Matcher(("\\d{11}</td><td class='z_bg_13'>\\d{5}"),_str);
 //BA.debugLineNum = 207;BA.debugLine="Dim str1 As String";
_str1 = "";
 //BA.debugLineNum = 208;BA.debugLine="Do While mc.Find";
while (_mc.Find()) {
 //BA.debugLineNum = 209;BA.debugLine="str1=mc.Match";
_str1 = _mc.getMatch();
 //BA.debugLineNum = 210;BA.debugLine="Dim s1 As Map,qh As String,hm As String";
_s1 = new anywheresoftware.b4a.objects.collections.Map();
_qh = "";
_hm = "";
 //BA.debugLineNum = 211;BA.debugLine="qh=str1.SubString2(0,str1.IndexOf(\"<\"))";
_qh = _str1.substring((int) (0),_str1.indexOf("<"));
 //BA.debugLineNum = 212;BA.debugLine="hm=str1.SubString2(str1.LastIndexOf(\">\")+1,str1.";
_hm = _str1.substring((int) (_str1.lastIndexOf(">")+1),_str1.length());
 //BA.debugLineNum = 213;BA.debugLine="qh=qh.SubString(qh.Length-3)";
_qh = _qh.substring((int) (_qh.length()-3));
 //BA.debugLineNum = 214;BA.debugLine="s1.Initialize";
_s1.Initialize();
 //BA.debugLineNum = 215;BA.debugLine="s1.Put(\"hm\",hm)";
_s1.Put((Object)("hm"),(Object)(_hm));
 //BA.debugLineNum = 216;BA.debugLine="s1.Put(\"qh\",qh)";
_s1.Put((Object)("qh"),(Object)(_qh));
 //BA.debugLineNum = 217;BA.debugLine="lst.InsertAt(0,s1)";
_lst.InsertAt((int) (0),(Object)(_s1.getObject()));
 //BA.debugLineNum = 218;BA.debugLine="str1=qh";
_str1 = _qh;
 }
;
 //BA.debugLineNum = 220;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 221;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _parsessc_jw(String _str) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4j.objects.collections.JSONParser _jsp = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.Map _response = null;
anywheresoftware.b4a.objects.collections.List _lstarray = null;
anywheresoftware.b4a.objects.collections.Map _colroot_response_array = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
String _hm = "";
String _qh = "";
 //BA.debugLineNum = 182;BA.debugLine="Private Sub ParseSSC_jw(str As String) As List";
 //BA.debugLineNum = 183;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 184;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 185;BA.debugLine="Dim jsp As JSONParser";
_jsp = new anywheresoftware.b4j.objects.collections.JSONParser();
 //BA.debugLineNum = 186;BA.debugLine="jsp.Initialize(str)";
_jsp.Initialize(_str);
 //BA.debugLineNum = 187;BA.debugLine="Dim root As Map = jsp.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _jsp.NextObject();
 //BA.debugLineNum = 188;BA.debugLine="Dim response As Map= root.Get(\"response\")";
_response = new anywheresoftware.b4a.objects.collections.Map();
_response.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_root.Get((Object)("response"))));
 //BA.debugLineNum = 189;BA.debugLine="Dim lstarray As List=response.Get(\"array\")";
_lstarray = new anywheresoftware.b4a.objects.collections.List();
_lstarray.setObject((java.util.List)(_response.Get((Object)("array"))));
 //BA.debugLineNum = 190;BA.debugLine="For Each colroot_response_array As Map In lsta";
_colroot_response_array = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group8 = _lstarray;
final int groupLen8 = group8.getSize();
for (int index8 = 0;index8 < groupLen8 ;index8++){
_colroot_response_array.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group8.Get(index8)));
 //BA.debugLineNum = 191;BA.debugLine="Dim m As Map,hm As String,qh As String";
_m = new anywheresoftware.b4a.objects.collections.Map();
_hm = "";
_qh = "";
 //BA.debugLineNum = 192;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 193;BA.debugLine="hm=colroot_response_array.Get(\"code\")";
_hm = BA.ObjectToString(_colroot_response_array.Get((Object)("code")));
 //BA.debugLineNum = 194;BA.debugLine="hm=hm.Replace(\",\",\"\")";
_hm = _hm.replace(",","");
 //BA.debugLineNum = 195;BA.debugLine="m.Put(\"hm\",hm)";
_m.Put((Object)("hm"),(Object)(_hm));
 //BA.debugLineNum = 196;BA.debugLine="qh=colroot_response_array.Get(\"sn\")";
_qh = BA.ObjectToString(_colroot_response_array.Get((Object)("sn")));
 //BA.debugLineNum = 197;BA.debugLine="qh=qh.SubString(qh.Length-3)";
_qh = _qh.substring((int) (_qh.length()-3));
 //BA.debugLineNum = 198;BA.debugLine="m.Put(\"qh\",qh)";
_m.Put((Object)("qh"),(Object)(_qh));
 //BA.debugLineNum = 199;BA.debugLine="lst.Add(m)";
_lst.Add((Object)(_m.getObject()));
 }
;
 //BA.debugLineNum = 201;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 202;BA.debugLine="End Sub";
return null;
}
public String  _withcolor(String _n) throws Exception{
String _ret = "";
 //BA.debugLineNum = 147;BA.debugLine="Private Sub withcolor(n As String) As String";
 //BA.debugLineNum = 148;BA.debugLine="Dim ret As String";
_ret = "";
 //BA.debugLineNum = 149;BA.debugLine="Select n";
switch (BA.switchObjectToInt(_n,"0","5","1","6","2","7","3","8","4","9")) {
case 0: 
case 1: {
 //BA.debugLineNum = 151;BA.debugLine="ret=\"<td class='tdwxtu'>\"&n&\"</td>\"";
_ret = "<td class='tdwxtu'>"+_n+"</td>";
 break; }
case 2: 
case 3: {
 //BA.debugLineNum = 153;BA.debugLine="ret=\"<td class='tdwxshui'>\"&n&\"</td>\"";
_ret = "<td class='tdwxshui'>"+_n+"</td>";
 break; }
case 4: 
case 5: {
 //BA.debugLineNum = 155;BA.debugLine="ret=\"<td class='tdwxhuo'>\"&n&\"</td>\"";
_ret = "<td class='tdwxhuo'>"+_n+"</td>";
 break; }
case 6: 
case 7: {
 //BA.debugLineNum = 157;BA.debugLine="ret=\"<td class='tdwxmu'>\"&n&\"</td>\"";
_ret = "<td class='tdwxmu'>"+_n+"</td>";
 break; }
case 8: 
case 9: {
 //BA.debugLineNum = 159;BA.debugLine="ret=\"<td class='tdwxjin'>\"&n&\"</td>\"";
_ret = "<td class='tdwxjin'>"+_n+"</td>";
 break; }
}
;
 //BA.debugLineNum = 161;BA.debugLine="Return ret";
if (true) return _ret;
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
