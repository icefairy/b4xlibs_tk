package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class json2type extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.json2type", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.json2type.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.collections.Map _resmap = null;
public anywheresoftware.b4a.keywords.StringBuilderWrapper _code = null;
public anywheresoftware.b4a.keywords.StringBuilderWrapper _convertcode = null;
public b4j.example.main _main = null;
public b4j.example.common _common = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private resMap As Map";
_resmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 4;BA.debugLine="Private code,convertCode As StringBuilder";
_code = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_convertcode = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return "";
}
public String  _getfirstupper(String _str) throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="Private Sub getFirstUpper(str As String) As String";
 //BA.debugLineNum = 110;BA.debugLine="If str.Length>0 Then";
if (_str.length()>0) { 
 //BA.debugLineNum = 111;BA.debugLine="Return str.SubString2(0,1).ToUpperCase&str.SubSt";
if (true) return _str.substring((int) (0),(int) (1)).toUpperCase()+_str.substring((int) (1));
 }else {
 //BA.debugLineNum = 113;BA.debugLine="Return \"\"";
if (true) return "";
 };
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}
public String  _handle(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
byte[] _data = null;
String _text = "";
anywheresoftware.b4j.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator _jg = null;
 //BA.debugLineNum = 11;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
 //BA.debugLineNum = 12;BA.debugLine="resp.ContentType = \"application/json\"";
_resp.setContentType("application/json");
 //BA.debugLineNum = 13;BA.debugLine="resp.CharacterEncoding=\"UTF-8\"";
_resp.setCharacterEncoding("UTF-8");
 //BA.debugLineNum = 14;BA.debugLine="resMap.Initialize";
_resmap.Initialize();
 //BA.debugLineNum = 15;BA.debugLine="Try";
try { //BA.debugLineNum = 16;BA.debugLine="Dim data() As Byte = Bit.InputStreamToBytes(req.";
_data = __c.Bit.InputStreamToBytes((java.io.InputStream)(_req.getInputStream().getObject()));
 //BA.debugLineNum = 17;BA.debugLine="Dim text As String = BytesToString(data, 0, data";
_text = __c.BytesToString(_data,(int) (0),_data.length,"UTF8");
 //BA.debugLineNum = 18;BA.debugLine="If Not(text.StartsWith(\"{\")) Then";
if (__c.Not(_text.startsWith("{"))) { 
 //BA.debugLineNum = 19;BA.debugLine="resMap.Put(\"success\", False)";
_resmap.Put((Object)("success"),(Object)(__c.False));
 //BA.debugLineNum = 20;BA.debugLine="resMap.Put(\"error\",\"I can parse JsonObject(map)";
_resmap.Put((Object)("error"),(Object)("I can parse JsonObject(map) only"));
 }else {
 //BA.debugLineNum = 22;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4j.objects.collections.JSONParser();
 //BA.debugLineNum = 23;BA.debugLine="parser.Initialize(text)";
_parser.Initialize(_text);
 //BA.debugLineNum = 24;BA.debugLine="Dim m As Map=parser.NextObject";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = _parser.NextObject();
 //BA.debugLineNum = 26;BA.debugLine="code.Initialize";
_code.Initialize();
 //BA.debugLineNum = 27;BA.debugLine="convertCode.Initialize";
_convertcode.Initialize();
 //BA.debugLineNum = 28;BA.debugLine="map2typecode(m,\"root\")";
_map2typecode(_m,"root");
 //BA.debugLineNum = 29;BA.debugLine="resMap.Put(\"success\", True)";
_resmap.Put((Object)("success"),(Object)(__c.True));
 //BA.debugLineNum = 30;BA.debugLine="resMap.Put(\"code\", code.ToString&CRLF&convertCo";
_resmap.Put((Object)("code"),(Object)(_code.ToString()+__c.CRLF+_convertcode.ToString()));
 };
 } 
       catch (Exception e21) {
			ba.setLastException(e21); //BA.debugLineNum = 33;BA.debugLine="resMap.Put(\"success\", False)";
_resmap.Put((Object)("success"),(Object)(__c.False));
 //BA.debugLineNum = 34;BA.debugLine="resMap.Put(\"error\", \"Error parsing string:\" & CR";
_resmap.Put((Object)("error"),(Object)("Error parsing string:"+__c.CRLF+__c.LastException(ba).getMessage()));
 };
 //BA.debugLineNum = 36;BA.debugLine="Dim jg As JSONGenerator";
_jg = new anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 37;BA.debugLine="jg.Initialize(resMap)";
_jg.Initialize(_resmap);
 //BA.debugLineNum = 38;BA.debugLine="resp.Write(jg.ToString)";
_resp.Write(_jg.ToString());
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 7;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public String  _map2typecode(anywheresoftware.b4a.objects.collections.Map _m,String _keyname) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _convertsb = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _convertsb2 = null;
int _i = 0;
String _k = "";
Object _valobj = null;
String _typ = "";
 //BA.debugLineNum = 41;BA.debugLine="Private Sub map2typecode(m As Map,keyname As Strin";
 //BA.debugLineNum = 42;BA.debugLine="Dim sb,convertSb,convertSb2 As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_convertsb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_convertsb2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 43;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 44;BA.debugLine="convertSb.Initialize";
_convertsb.Initialize();
 //BA.debugLineNum = 45;BA.debugLine="convertSb2.Initialize";
_convertsb2.Initialize();
 //BA.debugLineNum = 46;BA.debugLine="If keyname=Null Or keyname.Length<1 Then keyname=";
if (_keyname== null || _keyname.length()<1) { 
_keyname = "root";};
 //BA.debugLineNum = 47;BA.debugLine="keyname=\"typ\"&getFirstUpper(keyname)";
_keyname = "typ"+_getfirstupper(_keyname);
 //BA.debugLineNum = 48;BA.debugLine="sb.Append(\"Type \"&keyname&\"(\")";
_sb.Append("Type "+_keyname+"(");
 //BA.debugLineNum = 49;BA.debugLine="convertSb.Append(\"Public Sub parseStr2\"&keyname&\"";
_convertsb.Append("Public Sub parseStr2"+_keyname+"(str As String) As "+_keyname).Append(__c.CRLF);
 //BA.debugLineNum = 50;BA.debugLine="convertSb.Append(TAB&\"Dim parser As JSONParser\"&C";
_convertsb.Append(__c.TAB+"Dim parser As JSONParser"+__c.CRLF+__c.TAB+"parser.Initialize(str)"+__c.CRLF+__c.TAB+"Return map2"+_keyname+"(parser.NextObject)"+__c.CRLF+"End Sub"+__c.CRLF);
 //BA.debugLineNum = 51;BA.debugLine="convertSb2.Append(\"Public Sub \"&keyname&\"2Map(typ";
_convertsb2.Append("Public Sub "+_keyname+"2Map(typ As "+_keyname+") As Map"+__c.CRLF);
 //BA.debugLineNum = 52;BA.debugLine="convertSb.Append(\"Public Sub map2\"&keyname&\"(m As";
_convertsb.Append("Public Sub map2"+_keyname+"(m As Map) As "+_keyname).Append(__c.CRLF);
 //BA.debugLineNum = 53;BA.debugLine="convertSb.Append(TAB&\"Dim ret As \"&keyname).Appen";
_convertsb.Append(__c.TAB+"Dim ret As "+_keyname).Append(__c.CRLF).Append(__c.TAB+"ret.Initialize").Append(__c.CRLF);
 //BA.debugLineNum = 54;BA.debugLine="convertSb2.Append(TAB&\"Dim ret As Map\").Append(CR";
_convertsb2.Append(__c.TAB+"Dim ret As Map").Append(__c.CRLF).Append(__c.TAB+"ret.Initialize").Append(__c.CRLF);
 //BA.debugLineNum = 55;BA.debugLine="For i=0 To m.Size-1";
{
final int step14 = 1;
final int limit14 = (int) (_m.getSize()-1);
for (_i = (int) (0) ; (step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14); _i = ((int)(0 + _i + step14)) ) {
 //BA.debugLineNum = 56;BA.debugLine="Dim k As String=m.GetKeyAt(i)";
_k = BA.ObjectToString(_m.GetKeyAt(_i));
 //BA.debugLineNum = 57;BA.debugLine="Dim valobj As Object=m.GetValueAt(i)";
_valobj = _m.GetValueAt(_i);
 //BA.debugLineNum = 58;BA.debugLine="Dim typ As String=GetType(valobj).Replace(\"java.";
_typ = __c.GetType(_valobj).replace("java.lang.","");
 //BA.debugLineNum = 60;BA.debugLine="Select typ";
switch (BA.switchObjectToInt(_typ,"String","Double","Integer","anywheresoftware.b4a.objects.collections.Map$MyMap","java.util.ArrayList")) {
case 0: {
 //BA.debugLineNum = 62;BA.debugLine="sb.Append(k&\" As \"&typ)";
_sb.Append(_k+" As "+_typ);
 //BA.debugLineNum = 63;BA.debugLine="If k.EqualsIgnoreCase(\"id\") Then";
if (_k.equalsIgnoreCase("id")) { 
 //BA.debugLineNum = 64;BA.debugLine="convertSb.Append(TAB&$\"ret.${k}=m.GetDefault(";
_convertsb.Append(__c.TAB+("ret."+__c.SmartStringFormatter("",(Object)(_k))+"=m.GetDefault(\"_"+__c.SmartStringFormatter("",(Object)(_k))+"\",\"\")")+__c.CRLF);
 //BA.debugLineNum = 65;BA.debugLine="convertSb2.Append(TAB&$\"ret.Put(\"_${k}\",typ.$";
_convertsb2.Append(__c.TAB+("ret.Put(\"_"+__c.SmartStringFormatter("",(Object)(_k))+"\",typ."+__c.SmartStringFormatter("",(Object)(_k))+")")+__c.CRLF);
 }else {
 //BA.debugLineNum = 67;BA.debugLine="convertSb.Append(TAB&$\"ret.${k}=m.GetDefault(";
_convertsb.Append(__c.TAB+("ret."+__c.SmartStringFormatter("",(Object)(_k))+"=m.GetDefault(\""+__c.SmartStringFormatter("",(Object)(_k))+"\",\"\")")+__c.CRLF);
 //BA.debugLineNum = 68;BA.debugLine="convertSb2.Append(TAB&$\"ret.Put(\"${k}\",typ.${";
_convertsb2.Append(__c.TAB+("ret.Put(\""+__c.SmartStringFormatter("",(Object)(_k))+"\",typ."+__c.SmartStringFormatter("",(Object)(_k))+")")+__c.CRLF);
 };
 break; }
case 1: {
 //BA.debugLineNum = 72;BA.debugLine="sb.Append(k&\" As \"&typ)";
_sb.Append(_k+" As "+_typ);
 //BA.debugLineNum = 73;BA.debugLine="convertSb.Append(TAB&$\"ret.${k}=m.GetDefault(\"";
_convertsb.Append(__c.TAB+("ret."+__c.SmartStringFormatter("",(Object)(_k))+"=m.GetDefault(\""+__c.SmartStringFormatter("",(Object)(_k))+"\",0)")+__c.CRLF);
 //BA.debugLineNum = 74;BA.debugLine="convertSb2.Append(TAB&$\"ret.Put(\"${k}\",typ.${k";
_convertsb2.Append(__c.TAB+("ret.Put(\""+__c.SmartStringFormatter("",(Object)(_k))+"\",typ."+__c.SmartStringFormatter("",(Object)(_k))+")")+__c.CRLF);
 break; }
case 2: {
 //BA.debugLineNum = 76;BA.debugLine="sb.Append(k&\" As Int\")";
_sb.Append(_k+" As Int");
 //BA.debugLineNum = 77;BA.debugLine="convertSb.Append(TAB&$\"ret.${k}=m.GetDefault(\"";
_convertsb.Append(__c.TAB+("ret."+__c.SmartStringFormatter("",(Object)(_k))+"=m.GetDefault(\""+__c.SmartStringFormatter("",(Object)(_k))+"\",0)")+__c.CRLF);
 //BA.debugLineNum = 78;BA.debugLine="convertSb2.Append(TAB&$\"ret.Put(\"${k}\",typ.${k";
_convertsb2.Append(__c.TAB+("ret.Put(\""+__c.SmartStringFormatter("",(Object)(_k))+"\",typ."+__c.SmartStringFormatter("",(Object)(_k))+")")+__c.CRLF);
 break; }
case 3: {
 //BA.debugLineNum = 80;BA.debugLine="map2typecode(m.Get(k),k)";
_map2typecode((anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(_m.Get((Object)(_k)))),_k);
 //BA.debugLineNum = 81;BA.debugLine="sb.Append(k&\" As typ\"&getFirstUpper(k))";
_sb.Append(_k+" As typ"+_getfirstupper(_k));
 //BA.debugLineNum = 82;BA.debugLine="convertSb.Append(TAB&$\"ret.${k}=map2typ${getFi";
_convertsb.Append(__c.TAB+("ret."+__c.SmartStringFormatter("",(Object)(_k))+"=map2typ"+__c.SmartStringFormatter("",(Object)(_getfirstupper(_k)))+"(m.Get(\""+__c.SmartStringFormatter("",(Object)(_k))+"\"))")+__c.CRLF);
 //BA.debugLineNum = 83;BA.debugLine="convertSb2.Append(TAB&$\"ret.Put(\"${k}\",typ.${k";
_convertsb2.Append(__c.TAB+("ret.Put(\""+__c.SmartStringFormatter("",(Object)(_k))+"\",typ."+__c.SmartStringFormatter("",(Object)(_k))+")")+__c.CRLF);
 break; }
case 4: {
 //BA.debugLineNum = 85;BA.debugLine="sb.Append(k&\" As List\")";
_sb.Append(_k+" As List");
 //BA.debugLineNum = 86;BA.debugLine="convertSb.Append(TAB&$\"ret.${k}=m.Get(\"${k}\")\"";
_convertsb.Append(__c.TAB+("ret."+__c.SmartStringFormatter("",(Object)(_k))+"=m.Get(\""+__c.SmartStringFormatter("",(Object)(_k))+"\")")+__c.CRLF);
 //BA.debugLineNum = 87;BA.debugLine="convertSb2.Append(TAB&$\"ret.Put(\"${k}\",typ.${k";
_convertsb2.Append(__c.TAB+("ret.Put(\""+__c.SmartStringFormatter("",(Object)(_k))+"\",typ."+__c.SmartStringFormatter("",(Object)(_k))+")")+__c.CRLF);
 break; }
default: {
 //BA.debugLineNum = 89;BA.debugLine="sb.Append(k&\" As UnknowType_\"&typ)";
_sb.Append(_k+" As UnknowType_"+_typ);
 //BA.debugLineNum = 90;BA.debugLine="convertSb.Append(TAB&$\"ret.${k}=m.Get(\"${k}\")\"";
_convertsb.Append(__c.TAB+("ret."+__c.SmartStringFormatter("",(Object)(_k))+"=m.Get(\""+__c.SmartStringFormatter("",(Object)(_k))+"\")")+__c.CRLF);
 //BA.debugLineNum = 91;BA.debugLine="convertSb2.Append(TAB&$\"ret.Put(\"${k}\",typ.${k";
_convertsb2.Append(__c.TAB+("ret.Put(\""+__c.SmartStringFormatter("",(Object)(_k))+"\",typ."+__c.SmartStringFormatter("",(Object)(_k))+")")+__c.CRLF);
 break; }
}
;
 //BA.debugLineNum = 93;BA.debugLine="sb.Append(\",\")";
_sb.Append(",");
 }
};
 //BA.debugLineNum = 95;BA.debugLine="If sb.Length>0 Then";
if (_sb.getLength()>0) { 
 //BA.debugLineNum = 96;BA.debugLine="sb.Remove(sb.Length-1,sb.Length)";
_sb.Remove((int) (_sb.getLength()-1),_sb.getLength());
 //BA.debugLineNum = 97;BA.debugLine="sb.Append(\")\")";
_sb.Append(")");
 //BA.debugLineNum = 98;BA.debugLine="code.Append(sb.ToString).Append(CRLF)";
_code.Append(_sb.ToString()).Append(__c.CRLF);
 };
 //BA.debugLineNum = 100;BA.debugLine="If convertSb.Length>0 Then";
if (_convertsb.getLength()>0) { 
 //BA.debugLineNum = 101;BA.debugLine="convertSb.Append(TAB&\"Return ret\"&CRLF&\"End Sub\"";
_convertsb.Append(__c.TAB+"Return ret"+__c.CRLF+"End Sub");
 //BA.debugLineNum = 102;BA.debugLine="convertCode.Append(convertSb&CRLF)";
_convertcode.Append(BA.ObjectToString(_convertsb)+__c.CRLF);
 };
 //BA.debugLineNum = 104;BA.debugLine="If convertSb2.Length>0 Then";
if (_convertsb2.getLength()>0) { 
 //BA.debugLineNum = 105;BA.debugLine="convertSb2.Append(TAB&\"Return ret\"&CRLF&\"End Sub";
_convertsb2.Append(__c.TAB+"Return ret"+__c.CRLF+"End Sub");
 //BA.debugLineNum = 106;BA.debugLine="convertCode.Append(convertSb2.ToString&CRLF)";
_convertcode.Append(_convertsb2.ToString()+__c.CRLF);
 };
 //BA.debugLineNum = 108;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
