package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class xml2code extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.xml2code", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.xml2code.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _mresp = null;
public anywheresoftware.b4a.objects.collections.Map _resmap = null;
public anywheresoftware.b4a.keywords.StringBuilderWrapper _sb_code = null;
public anywheresoftware.b4a.keywords.StringBuilderWrapper _sb_findcode = null;
public anywheresoftware.b4a.keywords.StringBuilderWrapper _sb_findcode2 = null;
public anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator _jsg = null;
public b4j.example.main _main = null;
public b4j.example.common _common = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private mResp As ServletResponse";
_mresp = new anywheresoftware.b4j.object.JServlet.ServletResponseWrapper();
 //BA.debugLineNum = 4;BA.debugLine="Private resMap As Map";
_resmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 5;BA.debugLine="Dim sb_code,sb_findcode,sb_findcode2 As StringBui";
_sb_code = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_sb_findcode = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_sb_findcode2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 6;BA.debugLine="Dim jsg As JSONGenerator";
_jsg = new anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public String  _handle(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
byte[] _data = null;
String _text = "";
 //BA.debugLineNum = 13;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
 //BA.debugLineNum = 14;BA.debugLine="resp.ContentType = \"application/json\"";
_resp.setContentType("application/json");
 //BA.debugLineNum = 15;BA.debugLine="resp.CharacterEncoding=\"UTF-8\"";
_resp.setCharacterEncoding("UTF-8");
 //BA.debugLineNum = 16;BA.debugLine="mResp=resp";
_mresp = _resp;
 //BA.debugLineNum = 17;BA.debugLine="Dim data() As Byte = Bit.InputStreamToBytes(req.I";
_data = __c.Bit.InputStreamToBytes((java.io.InputStream)(_req.getInputStream().getObject()));
 //BA.debugLineNum = 18;BA.debugLine="Dim text As String = BytesToString(data, 0, data.";
_text = __c.BytesToString(_data,(int) (0),_data.length,"UTF8");
 //BA.debugLineNum = 19;BA.debugLine="sb_code.Initialize";
_sb_code.Initialize();
 //BA.debugLineNum = 20;BA.debugLine="sb_code.Append(\"//Views\").Append(CRLF)";
_sb_code.Append("//Views").Append(__c.CRLF);
 //BA.debugLineNum = 21;BA.debugLine="sb_findcode.Initialize";
_sb_findcode.Initialize();
 //BA.debugLineNum = 22;BA.debugLine="sb_findcode.Append($\"/* add this to your base cla";
_sb_findcode.Append(("/* add this to your base class\n"+"	public <T> T mFindView(int resId) {\n"+"        Return (T)getActivity().findViewById(resId);\n"+"    }\n"+"\n"+"    Public <T> T mFindView(View v, int resId) {\n"+"        Return (T) v.findViewById(resId);\n"+"    } */")).Append(__c.CRLF).Append("//find view type1 for activity").Append(__c.CRLF);
 //BA.debugLineNum = 30;BA.debugLine="sb_findcode2.Initialize";
_sb_findcode2.Initialize();
 //BA.debugLineNum = 31;BA.debugLine="sb_findcode2.Append(\"//find view type2 for fragme";
_sb_findcode2.Append("//find view type2 for fragment or adapter ").Append(__c.CRLF);
 //BA.debugLineNum = 32;BA.debugLine="parseViews(text)";
_parseviews(_text);
 //BA.debugLineNum = 33;BA.debugLine="resMap.Initialize";
_resmap.Initialize();
 //BA.debugLineNum = 34;BA.debugLine="resMap.Put(\"code\",sb_code.ToString&CRLF&CRLF&sb_f";
_resmap.Put((Object)("code"),(Object)(_sb_code.ToString()+__c.CRLF+__c.CRLF+_sb_findcode.ToString()+__c.CRLF+__c.CRLF+_sb_findcode2.ToString()));
 //BA.debugLineNum = 35;BA.debugLine="resMap.Put(\"tree\",\"\")";
_resmap.Put((Object)("tree"),(Object)(""));
 //BA.debugLineNum = 36;BA.debugLine="resMap.Put(\"success\", True)";
_resmap.Put((Object)("success"),(Object)(__c.True));
 //BA.debugLineNum = 38;BA.debugLine="jsg.Initialize(resMap)";
_jsg.Initialize(_resmap);
 //BA.debugLineNum = 39;BA.debugLine="mResp.Write(jsg.ToString)";
_mresp.Write(_jsg.ToString());
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public String  _parseviews(String _str) throws Exception{
String[] _strs = null;
int _i = 0;
int _a = 0;
String _typname = "";
String[] _ids = null;
String _idname = "";
 //BA.debugLineNum = 41;BA.debugLine="Public Sub parseViews(str As String)";
 //BA.debugLineNum = 42;BA.debugLine="Dim strs() As String=Regex.Split(\"<\",str)";
_strs = __c.Regex.Split("<",_str);
 //BA.debugLineNum = 43;BA.debugLine="Try";
try { //BA.debugLineNum = 44;BA.debugLine="For i=0 To strs.Length-1";
{
final int step3 = 1;
final int limit3 = (int) (_strs.length-1);
for (_i = (int) (0) ; (step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3); _i = ((int)(0 + _i + step3)) ) {
 //BA.debugLineNum = 45;BA.debugLine="If strs(i).Length>2 Then";
if (_strs[_i].length()>2) { 
 //BA.debugLineNum = 47;BA.debugLine="Dim a As Int=strs(i).IndexOf(\" \")";
_a = _strs[_i].indexOf(" ");
 //BA.debugLineNum = 48;BA.debugLine="If a>-1 Then";
if (_a>-1) { 
 //BA.debugLineNum = 49;BA.debugLine="Dim typName As String=strs(i).SubString2(0,a-";
_typname = _strs[_i].substring((int) (0),(int) (_a-1));
 //BA.debugLineNum = 50;BA.debugLine="Dim ids() As String=Regex.Split(\"@\\+id/\",strs";
_ids = __c.Regex.Split("@\\+id/",_strs[_i]);
 //BA.debugLineNum = 51;BA.debugLine="Dim idname As String";
_idname = "";
 //BA.debugLineNum = 53;BA.debugLine="If ids.Length>1 Then";
if (_ids.length>1) { 
 //BA.debugLineNum = 54;BA.debugLine="idname=ids(1).SubString2(0,ids(1).IndexOf(\"\"";
_idname = _ids[(int) (1)].substring((int) (0),_ids[(int) (1)].indexOf("\""));
 //BA.debugLineNum = 55;BA.debugLine="sb_code.Append(\"private \"&typName&\" \"&idname";
_sb_code.Append("private "+_typname+" "+_idname+";").Append(__c.CRLF);
 //BA.debugLineNum = 56;BA.debugLine="sb_findcode.Append(idname&\" = mFindView(R.id";
_sb_findcode.Append(_idname+" = mFindView(R.id."+_idname+");").Append(__c.CRLF);
 //BA.debugLineNum = 57;BA.debugLine="sb_findcode.Append(idname&\".setOnClickListen";
_sb_findcode.Append(_idname+".setOnClickListener(this);").Append(__c.CRLF);
 //BA.debugLineNum = 58;BA.debugLine="sb_findcode2.Append(idname&\" = mFindView(v,R";
_sb_findcode2.Append(_idname+" = mFindView(v,R.id."+_idname+");").Append(__c.CRLF);
 //BA.debugLineNum = 59;BA.debugLine="sb_findcode2.Append(idname&\".setOnClickListe";
_sb_findcode2.Append(_idname+".setOnClickListener(this);").Append(__c.CRLF);
 };
 };
 };
 }
};
 } 
       catch (Exception e22) {
			ba.setLastException(e22); //BA.debugLineNum = 66;BA.debugLine="Log(LastException.Message)";
__c.Log(__c.LastException(ba).getMessage());
 };
 //BA.debugLineNum = 69;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
