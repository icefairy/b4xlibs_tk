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
public anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _mresp = null;
public b4j.example.httputils2service _httputils2service = null;
public b4j.example.main _main = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private cmd As String";
_cmd = "";
 //BA.debugLineNum = 4;BA.debugLine="Private mResp As ServletResponse";
_mresp = new anywheresoftware.b4j.object.JServlet.ServletResponseWrapper();
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return "";
}
public String  _getsscdata163() throws Exception{
b4j.example.httpjob _hj = null;
 //BA.debugLineNum = 75;BA.debugLine="Public Sub getsscdata163";
 //BA.debugLineNum = 76;BA.debugLine="Log(\"get once\")";
__c.Log("get once");
 //BA.debugLineNum = 77;BA.debugLine="Main.bLoading=True";
_main._bloading = __c.True;
 //BA.debugLineNum = 78;BA.debugLine="Dim hj As HttpJob";
_hj = new b4j.example.httpjob();
 //BA.debugLineNum = 79;BA.debugLine="hj.Initialize(\"getdata\",Me)";
_hj._initialize(ba,"getdata",this);
 //BA.debugLineNum = 80;BA.debugLine="If Main.num<>30 And Main.num<>50 And Main.num<>10";
if (_main._num!=30 && _main._num!=50 && _main._num!=100) { 
_main._num = (int) (30);};
 //BA.debugLineNum = 81;BA.debugLine="hj.Download($\"http://trend.caipiao.163.com/cqssc/";
_hj._download(("http://trend.caipiao.163.com/cqssc/jiben-5xing.html?periodNumber="+__c.SmartStringFormatter("",(Object)(_main._num))+""));
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public String  _handle(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
String _num = "";
 //BA.debugLineNum = 11;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
 //BA.debugLineNum = 12;BA.debugLine="mResp=resp";
_mresp = _resp;
 //BA.debugLineNum = 13;BA.debugLine="cmd=req.GetParameter(\"cmd\").ToLowerCase";
_cmd = _req.GetParameter("cmd").toLowerCase();
 //BA.debugLineNum = 14;BA.debugLine="Select cmd";
switch (BA.switchObjectToInt(_cmd,"1")) {
case 0: {
 //BA.debugLineNum = 16;BA.debugLine="Dim num As String=req.GetParameter(\"num\")";
_num = _req.GetParameter("num");
 //BA.debugLineNum = 17;BA.debugLine="If num=Null Or num.Length<1 Then num=\"30\"";
if (_num== null || _num.length()<1) { 
_num = "30";};
 //BA.debugLineNum = 18;BA.debugLine="If needrefush(num) Then";
if (_needrefush((int)(Double.parseDouble(_num)))) { 
 //BA.debugLineNum = 19;BA.debugLine="getsscdata163";
_getsscdata163();
 //BA.debugLineNum = 20;BA.debugLine="StartMessageLoop";
__c.StartMessageLoop(ba);
 }else {
 //BA.debugLineNum = 22;BA.debugLine="outputs";
_outputs();
 };
 break; }
}
;
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 7;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public String  _jobdone(b4j.example.httpjob _thj) throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="Sub JobDone(thj As HttpJob)";
 //BA.debugLineNum = 38;BA.debugLine="Log(\"Job:\"&thj.Success)";
__c.Log("Job:"+BA.ObjectToString(_thj._success));
 //BA.debugLineNum = 39;BA.debugLine="Main.tLastTickets=DateTime.Now";
_main._tlasttickets = __c.DateTime.getNow();
 //BA.debugLineNum = 40;BA.debugLine="If thj.Success Then";
if (_thj._success) { 
 //BA.debugLineNum = 41;BA.debugLine="Main.mData=ParseSSC_163(thj.GetString)";
_main._mdata = _parsessc_163(_thj._getstring());
 //BA.debugLineNum = 42;BA.debugLine="Log(\"load ok once\")";
__c.Log("load ok once");
 }else {
 //BA.debugLineNum = 44;BA.debugLine="Log(\"joberror:\"&thj.ErrorMessage)";
__c.Log("joberror:"+_thj._errormessage);
 };
 //BA.debugLineNum = 46;BA.debugLine="thj.Release";
_thj._release();
 //BA.debugLineNum = 47;BA.debugLine="Main.bLoading=False";
_main._bloading = __c.False;
 //BA.debugLineNum = 48;BA.debugLine="StopMessageLoop";
__c.StopMessageLoop(ba);
 //BA.debugLineNum = 49;BA.debugLine="outputs";
_outputs();
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public boolean  _needrefush(int _num) throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Private Sub needrefush(num As Int) As Boolean";
 //BA.debugLineNum = 29;BA.debugLine="If (DateTime.Now-Main.tLastTickets)>(Main.nReqMin";
if ((__c.DateTime.getNow()-_main._tlasttickets)>(_main._nreqminsecond*1000) || _main._num<_num) { 
 //BA.debugLineNum = 30;BA.debugLine="Main.num=num";
_main._num = _num;
 //BA.debugLineNum = 31;BA.debugLine="Return True";
if (true) return __c.True;
 }else {
 //BA.debugLineNum = 33;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 35;BA.debugLine="End Sub";
return false;
}
public String  _outputs() throws Exception{
 //BA.debugLineNum = 51;BA.debugLine="Private Sub outputs";
 //BA.debugLineNum = 52;BA.debugLine="mResp.Write(Main.getDataJson)";
_mresp.Write(_main._getdatajson());
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _parsessc_163(String _str) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.keywords.Regex.MatcherWrapper _mc = null;
String _str1 = "";
anywheresoftware.b4a.objects.collections.Map _s1 = null;
String _qh = "";
String _hm = "";
 //BA.debugLineNum = 54;BA.debugLine="Private Sub ParseSSC_163(str As String) As List";
 //BA.debugLineNum = 55;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 56;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 57;BA.debugLine="Dim mc As Matcher=Regex.Matcher($\"\\d{9}\">\\d{5} </";
_mc = new anywheresoftware.b4a.keywords.Regex.MatcherWrapper();
_mc = __c.Regex.Matcher(("\\d{9}\">\\d{5} </span>"),_str);
 //BA.debugLineNum = 58;BA.debugLine="Dim str1 As String";
_str1 = "";
 //BA.debugLineNum = 59;BA.debugLine="Do While mc.Find";
while (_mc.Find()) {
 //BA.debugLineNum = 60;BA.debugLine="str1=mc.Match";
_str1 = _mc.getMatch();
 //BA.debugLineNum = 61;BA.debugLine="Dim s1 As Map,qh As String,hm As String";
_s1 = new anywheresoftware.b4a.objects.collections.Map();
_qh = "";
_hm = "";
 //BA.debugLineNum = 62;BA.debugLine="qh=str1.SubString2(0,str1.IndexOf(\"\"\"\"))";
_qh = _str1.substring((int) (0),_str1.indexOf("\""));
 //BA.debugLineNum = 63;BA.debugLine="hm=str1.SubString2(str1.IndexOf(\">\")+1,str1.Last";
_hm = _str1.substring((int) (_str1.indexOf(">")+1),(int) (_str1.lastIndexOf("<")-1));
 //BA.debugLineNum = 64;BA.debugLine="s1.Initialize";
_s1.Initialize();
 //BA.debugLineNum = 65;BA.debugLine="s1.Put(\"hm\",hm)";
_s1.Put((Object)("hm"),(Object)(_hm));
 //BA.debugLineNum = 66;BA.debugLine="s1.Put(\"qh\",qh)";
_s1.Put((Object)("qh"),(Object)(_qh));
 //BA.debugLineNum = 67;BA.debugLine="lst.InsertAt(0,s1)";
_lst.InsertAt((int) (0),(Object)(_s1.getObject()));
 //BA.debugLineNum = 68;BA.debugLine="str1=qh";
_str1 = _qh;
 }
;
 //BA.debugLineNum = 70;BA.debugLine="Return lst";
if (true) return _lst;
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return null;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
