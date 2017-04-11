package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class jsonhelper2java extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.jsonhelper2java", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.jsonhelper2java.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.collections.Map _resmap = null;
public String _sindent = "";
public anywheresoftware.b4a.objects.collections.Map _mdata = null;
public b4j.example.main _main = null;
public b4j.example.common _common = null;
public String  _buildtree(Object _element,b4j.example.common._treeitem _parent,anywheresoftware.b4a.keywords.StringBuilderWrapper _code,String _parentname,String _getfrommap,boolean _buildlist,String _indent) throws Exception{
anywheresoftware.b4a.objects.collections.Map _m = null;
String _k = "";
b4j.example.common._treeitem _ti = null;
anywheresoftware.b4a.objects.collections.List _l = null;
int _index = 0;
Object _e = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _stubcode = null;
String _objecttype = "";
 //BA.debugLineNum = 148;BA.debugLine="Sub BuildTree(element As Object, parent As TreeIte";
 //BA.debugLineNum = 150;BA.debugLine="code.Append(indent)";
_code.Append(_indent);
 //BA.debugLineNum = 151;BA.debugLine="If element Is Map Then";
if (_element instanceof anywheresoftware.b4a.objects.collections.Map.MyMap) { 
 //BA.debugLineNum = 152;BA.debugLine="indent = WriteCodeHelper(\"Map\", code, parentName";
_indent = _writecodehelper("Map",_code,_parentname,_getfrommap,_buildlist,_indent);
 //BA.debugLineNum = 153;BA.debugLine="Dim m As Map = element";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_element));
 //BA.debugLineNum = 154;BA.debugLine="mData.Put(parentName,map2str(m))";
_mdata.Put((Object)(_parentname),(Object)(_map2str(_m)));
 //BA.debugLineNum = 155;BA.debugLine="For Each k As String In m.Keys";
final anywheresoftware.b4a.BA.IterableList group6 = _m.Keys();
final int groupLen6 = group6.getSize();
for (int index6 = 0;index6 < groupLen6 ;index6++){
_k = BA.ObjectToString(group6.Get(index6));
 //BA.debugLineNum = 156;BA.debugLine="Dim ti As TreeItem = CreateTreeItem(k)";
_ti = _createtreeitem(_k);
 //BA.debugLineNum = 157;BA.debugLine="parent.Children.Add(ti)";
_parent.Children.Add((Object)(_ti));
 //BA.debugLineNum = 158;BA.debugLine="BuildTree(m.Get(k), ti, code, k, parentName & \"";
_buildtree(_m.Get((Object)(_k)),_ti,_code,_k,_parentname+".Get(\""+_k+"\")",__c.False,_indent);
 }
;
 }else if(_element instanceof java.util.List) { 
 //BA.debugLineNum = 161;BA.debugLine="indent = WriteCodeHelper(\"List\", code, parentNam";
_indent = _writecodehelper("List",_code,_parentname,_getfrommap,_buildlist,_indent);
 //BA.debugLineNum = 162;BA.debugLine="Dim l As List = element";
_l = new anywheresoftware.b4a.objects.collections.List();
_l.setObject((java.util.List)(_element));
 //BA.debugLineNum = 163;BA.debugLine="Dim index As Int = 0";
_index = (int) (0);
 //BA.debugLineNum = 164;BA.debugLine="For Each e As Object In l";
final anywheresoftware.b4a.BA.IterableList group15 = _l;
final int groupLen15 = group15.getSize();
for (int index15 = 0;index15 < groupLen15 ;index15++){
_e = group15.Get(index15);
 //BA.debugLineNum = 165;BA.debugLine="Dim ti As TreeItem = CreateTreeItem(index)";
_ti = _createtreeitem(BA.NumberToString(_index));
 //BA.debugLineNum = 166;BA.debugLine="parent.Children.Add(ti)";
_parent.Children.Add((Object)(_ti));
 //BA.debugLineNum = 167;BA.debugLine="Dim stubCode As StringBuilder";
_stubcode = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 169;BA.debugLine="If index = 0 Then stubCode = code Else stubCode";
if (_index==0) { 
_stubcode = _code;}
else {
_stubcode.Initialize();};
 //BA.debugLineNum = 170;BA.debugLine="BuildTree(e, ti, stubCode, parentName ,\"\", inde";
_buildtree(_e,_ti,_stubcode,_parentname,"",_index==0,_indent);
 //BA.debugLineNum = 171;BA.debugLine="index = index + 1";
_index = (int) (_index+1);
 }
;
 }else {
 //BA.debugLineNum = 174;BA.debugLine="Dim objectType As String";
_objecttype = "";
 //BA.debugLineNum = 175;BA.debugLine="If element Is Int Then";
if (_element instanceof Integer) { 
 //BA.debugLineNum = 176;BA.debugLine="objectType = \"Int\"";
_objecttype = "Int";
 }else if(_element instanceof Double) { 
 //BA.debugLineNum = 178;BA.debugLine="objectType = \"Double\"";
_objecttype = "Double";
 }else {
 //BA.debugLineNum = 180;BA.debugLine="objectType = \"String\"";
_objecttype = "String";
 };
 //BA.debugLineNum = 182;BA.debugLine="indent = WriteCodeHelper(objectType, code, paren";
_indent = _writecodehelper(_objecttype,_code,_parentname,_getfrommap,_buildlist,_indent);
 //BA.debugLineNum = 183;BA.debugLine="parent.Text = parent.Text & \": \" & element";
_parent.Text = _parent.Text+": "+BA.ObjectToString(_element);
 };
 //BA.debugLineNum = 185;BA.debugLine="If BuildList Then";
if (_buildlist) { 
 //BA.debugLineNum = 187;BA.debugLine="code.Append(indent.SubString(sIndent.Length)).Ap";
_code.Append(_indent.substring(_sindent.length())).Append("Next").Append(" "+__c.CRLF);
 };
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Private resMap As Map";
_resmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 5;BA.debugLine="Private sIndent As String=\"    \"";
_sindent = "    ";
 //BA.debugLineNum = 6;BA.debugLine="Private mData As Map";
_mdata = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public String  _converttreetohtml(anywheresoftware.b4a.keywords.StringBuilderWrapper _sb,b4j.example.common._treeitem _parent,boolean _isroot) throws Exception{
b4j.example.common._treeitem _ti = null;
 //BA.debugLineNum = 213;BA.debugLine="Private Sub ConvertTreeToHtml(sb As StringBuilder,";
 //BA.debugLineNum = 214;BA.debugLine="If isRoot = False Then sb.Append(\"<li>\").Append(E";
if (_isroot==__c.False) { 
_sb.Append("<li>").Append(_escapexml(_parent.Text));};
 //BA.debugLineNum = 215;BA.debugLine="If parent.Children.Size > 0 Then";
if (_parent.Children.getSize()>0) { 
 //BA.debugLineNum = 216;BA.debugLine="sb.Append(\"<ul>\")";
_sb.Append("<ul>");
 //BA.debugLineNum = 217;BA.debugLine="For Each ti As TreeItem In parent.Children";
final anywheresoftware.b4a.BA.IterableList group4 = _parent.Children;
final int groupLen4 = group4.getSize();
for (int index4 = 0;index4 < groupLen4 ;index4++){
_ti = (b4j.example.common._treeitem)(group4.Get(index4));
 //BA.debugLineNum = 218;BA.debugLine="sb.Append(CRLF)";
_sb.Append(__c.CRLF);
 //BA.debugLineNum = 219;BA.debugLine="ConvertTreeToHtml(sb, ti, False)";
_converttreetohtml(_sb,_ti,__c.False);
 }
;
 //BA.debugLineNum = 221;BA.debugLine="sb.Append(\"</ul>\")";
_sb.Append("</ul>");
 };
 //BA.debugLineNum = 223;BA.debugLine="If isRoot = False Then sb.Append(\"</li>\")";
if (_isroot==__c.False) { 
_sb.Append("</li>");};
 //BA.debugLineNum = 224;BA.debugLine="End Sub";
return "";
}
public b4j.example.common._treeitem  _createtreeitem(String _text) throws Exception{
b4j.example.common._treeitem _ti = null;
 //BA.debugLineNum = 225;BA.debugLine="Private Sub CreateTreeItem (text As String) As Tre";
 //BA.debugLineNum = 226;BA.debugLine="Dim ti As TreeItem";
_ti = new b4j.example.common._treeitem();
 //BA.debugLineNum = 227;BA.debugLine="ti.Initialize";
_ti.Initialize();
 //BA.debugLineNum = 228;BA.debugLine="ti.Children.Initialize";
_ti.Children.Initialize();
 //BA.debugLineNum = 229;BA.debugLine="ti.text = text";
_ti.Text = _text;
 //BA.debugLineNum = 230;BA.debugLine="Return ti";
if (true) return _ti;
 //BA.debugLineNum = 231;BA.debugLine="End Sub";
return null;
}
public String  _escapexml(String _raw) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
char _c = '\0';
 //BA.debugLineNum = 232;BA.debugLine="Private Sub EscapeXml(Raw As String) As String";
 //BA.debugLineNum = 233;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 234;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 235;BA.debugLine="For i = 0 To Raw.Length - 1";
{
final int step3 = 1;
final int limit3 = (int) (_raw.length()-1);
for (_i = (int) (0) ; (step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3); _i = ((int)(0 + _i + step3)) ) {
 //BA.debugLineNum = 236;BA.debugLine="Dim C As Char = Raw.CharAt(i)";
_c = _raw.charAt(_i);
 //BA.debugLineNum = 237;BA.debugLine="Select C";
switch (BA.switchObjectToInt(_c,BA.ObjectToChar(__c.QUOTE),BA.ObjectToChar("'"),BA.ObjectToChar("<"),BA.ObjectToChar(">"),BA.ObjectToChar("&"))) {
case 0: {
 //BA.debugLineNum = 239;BA.debugLine="sb.Append(\"&quot;\")";
_sb.Append("&quot;");
 break; }
case 1: {
 //BA.debugLineNum = 241;BA.debugLine="sb.Append(\"&apos;\")";
_sb.Append("&apos;");
 break; }
case 2: {
 //BA.debugLineNum = 243;BA.debugLine="sb.Append(\"&lt;\")";
_sb.Append("&lt;");
 break; }
case 3: {
 //BA.debugLineNum = 245;BA.debugLine="sb.Append(\"&gt;\")";
_sb.Append("&gt;");
 break; }
case 4: {
 //BA.debugLineNum = 247;BA.debugLine="sb.Append(\"&amp;\")";
_sb.Append("&amp;");
 break; }
default: {
 //BA.debugLineNum = 249;BA.debugLine="sb.Append(C)";
_sb.Append(BA.ObjectToString(_c));
 break; }
}
;
 }
};
 //BA.debugLineNum = 252;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
public String  _getdate() throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Sub getdate As String";
 //BA.debugLineNum = 84;BA.debugLine="DateTime.DateFormat=\"yyyy-MM-dd\"";
__c.DateTime.setDateFormat("yyyy-MM-dd");
 //BA.debugLineNum = 85;BA.debugLine="Return DateTime.Date(DateTime.Now)";
if (true) return __c.DateTime.Date(__c.DateTime.getNow());
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public String  _handle(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
byte[] _data = null;
String _text = "";
anywheresoftware.b4j.objects.collections.JSONParser _parser = null;
boolean _squarebracketfound = false;
int _i = 0;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code = null;
b4j.example.common._treeitem _root = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sbcls = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator _jg = null;
 //BA.debugLineNum = 13;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
 //BA.debugLineNum = 14;BA.debugLine="resp.ContentType = \"application/json\"";
_resp.setContentType("application/json");
 //BA.debugLineNum = 15;BA.debugLine="resp.CharacterEncoding=\"UTF-8\"";
_resp.setCharacterEncoding("UTF-8");
 //BA.debugLineNum = 16;BA.debugLine="resMap.Initialize";
_resmap.Initialize();
 //BA.debugLineNum = 17;BA.debugLine="mData.Initialize";
_mdata.Initialize();
 //BA.debugLineNum = 18;BA.debugLine="Try";
try { //BA.debugLineNum = 19;BA.debugLine="Dim data() As Byte = Bit.InputStreamToBytes(req.";
_data = __c.Bit.InputStreamToBytes((java.io.InputStream)(_req.getInputStream().getObject()));
 //BA.debugLineNum = 20;BA.debugLine="Dim text As String = BytesToString(data, 0, data";
_text = __c.BytesToString(_data,(int) (0),_data.length,"UTF8");
 //BA.debugLineNum = 21;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4j.objects.collections.JSONParser();
 //BA.debugLineNum = 22;BA.debugLine="parser.Initialize(text)";
_parser.Initialize(_text);
 //BA.debugLineNum = 23;BA.debugLine="Dim squareBracketFound As Boolean";
_squarebracketfound = false;
 //BA.debugLineNum = 25;BA.debugLine="For i = 0 To text.Length";
{
final int step11 = 1;
final int limit11 = _text.length();
for (_i = (int) (0) ; (step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11); _i = ((int)(0 + _i + step11)) ) {
 //BA.debugLineNum = 26;BA.debugLine="If text.CharAt(i) = \"[\" Then";
if (_text.charAt(_i)==BA.ObjectToChar("[")) { 
 //BA.debugLineNum = 27;BA.debugLine="squareBracketFound = True";
_squarebracketfound = __c.True;
 //BA.debugLineNum = 28;BA.debugLine="Exit";
if (true) break;
 }else if(_text.charAt(_i)==BA.ObjectToChar("{")) { 
 //BA.debugLineNum = 30;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 33;BA.debugLine="Dim code As StringBuilder";
_code = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 34;BA.debugLine="code.Initialize";
_code.Initialize();
 //BA.debugLineNum = 35;BA.debugLine="code.Append(\"Dim parser As JSONParser\").Append(\"";
_code.Append("Dim parser As JSONParser").Append(" "+__c.CRLF);
 //BA.debugLineNum = 36;BA.debugLine="code.Append(\"parser.Initialize(str)\").Append(\" \"";
_code.Append("parser.Initialize(str)").Append(" "+__c.CRLF);
 //BA.debugLineNum = 37;BA.debugLine="code.Append(\"Dim root As \")";
_code.Append("Dim root As ");
 //BA.debugLineNum = 38;BA.debugLine="Dim root As TreeItem = CreateTreeItem (\"\")";
_root = _createtreeitem("");
 //BA.debugLineNum = 39;BA.debugLine="If squareBracketFound Then";
if (_squarebracketfound) { 
 //BA.debugLineNum = 40;BA.debugLine="code.Append(\"List = parser.NextArray\").Append(\"";
_code.Append("List = parser.NextArray").Append(" "+__c.CRLF);
 //BA.debugLineNum = 41;BA.debugLine="BuildTree(parser.NextArray, root, code, \"root\",";
_buildtree((Object)(_parser.NextArray().getObject()),_root,_code,"root","",__c.False,"");
 }else {
 //BA.debugLineNum = 43;BA.debugLine="code.Append(\"Map = parser.NextObject\").Append(\"";
_code.Append("Map = parser.NextObject").Append(" "+__c.CRLF);
 //BA.debugLineNum = 44;BA.debugLine="BuildTree(parser.NextObject, root, code, \"root\"";
_buildtree((Object)(_parser.NextObject().getObject()),_root,_code,"root","",__c.False,"");
 };
 //BA.debugLineNum = 46;BA.debugLine="Dim sb,sbCLS As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_sbcls = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 47;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 48;BA.debugLine="code.Initialize";
_code.Initialize();
 //BA.debugLineNum = 49;BA.debugLine="ConvertTreeToHtml(sb, root, True)";
_converttreetohtml(_sb,_root,__c.True);
 //BA.debugLineNum = 50;BA.debugLine="sbCLS.Initialize";
_sbcls.Initialize();
 //BA.debugLineNum = 51;BA.debugLine="For i=0 To mData.Size-1";
{
final int step37 = 1;
final int limit37 = (int) (_mdata.getSize()-1);
for (_i = (int) (0) ; (step37 > 0 && _i <= limit37) || (step37 < 0 && _i >= limit37); _i = ((int)(0 + _i + step37)) ) {
 //BA.debugLineNum = 52;BA.debugLine="Dim m As Map=str2map(mData.Get(mData.GetKeyAt(i";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = _str2map(BA.ObjectToString(_mdata.Get(_mdata.GetKeyAt(_i))));
 //BA.debugLineNum = 53;BA.debugLine="sbCLS.Append($\"/**  * Created by icefairy on ${";
_sbcls.Append(("/**\n"+" * Created by icefairy on "+__c.SmartStringFormatter("",(Object)(_getdate()))+".\n"+" */\n"+"@Table(name = \"tab_"+__c.SmartStringFormatter("",_mdata.GetKeyAt(_i))+"\")")).Append(__c.CRLF);
 //BA.debugLineNum = 57;BA.debugLine="sbCLS.Append(\"public class md\"&mData.GetKeyAt(i";
_sbcls.Append("public class md"+BA.ObjectToString(_mdata.GetKeyAt(_i))).Append("{").Append(__c.CRLF);
 //BA.debugLineNum = 58;BA.debugLine="sbCLS.Append(map2code(m)).Append(CRLF)";
_sbcls.Append(_map2code(_m)).Append(__c.CRLF);
 //BA.debugLineNum = 59;BA.debugLine="sbCLS.Append(sIndent&\"public md\"& mData.GetKeyA";
_sbcls.Append(_sindent+"public md"+BA.ObjectToString(_mdata.GetKeyAt(_i))+"(){/* this is for xutils3 db module */}").Append(__c.CRLF).Append((""+__c.SmartStringFormatter("",(Object)(_sindent+"public md"+BA.ObjectToString(_mdata.GetKeyAt(_i))))+"(String js){\n"+"		if (js==null||js.length()<1){\n"+"		        return;\n"+"		    }\n"+"		try {\n"+"			JSONObject jo=new JSONObject(js);\n"+""+__c.SmartStringFormatter("",(Object)(_map2code2(_m)))+"\n"+"		} catch (JSONException e1) {\n"+"		    e1.printStackTrace();\n"+"		}\n"+"	}")).Append(__c.CRLF);
 //BA.debugLineNum = 70;BA.debugLine="sbCLS.Append(\"}\").Append(CRLF).Append(CRLF)";
_sbcls.Append("}").Append(__c.CRLF).Append(__c.CRLF);
 }
};
 //BA.debugLineNum = 72;BA.debugLine="resMap.Put(\"tree\", sb.ToString)";
_resmap.Put((Object)("tree"),(Object)(_sb.ToString()));
 //BA.debugLineNum = 73;BA.debugLine="resMap.Put(\"success\", True)";
_resmap.Put((Object)("success"),(Object)(__c.True));
 //BA.debugLineNum = 74;BA.debugLine="resMap.Put(\"code\", sbCLS.ToString)";
_resmap.Put((Object)("code"),(Object)(_sbcls.ToString()));
 } 
       catch (Exception e49) {
			ba.setLastException(e49); //BA.debugLineNum = 76;BA.debugLine="resMap.Put(\"success\", False)";
_resmap.Put((Object)("success"),(Object)(__c.False));
 //BA.debugLineNum = 77;BA.debugLine="resMap.Put(\"error\", \"Error parsing string:\" & CR";
_resmap.Put((Object)("error"),(Object)("Error parsing string:"+__c.CRLF+__c.LastException(ba).getMessage()));
 };
 //BA.debugLineNum = 79;BA.debugLine="Dim jg As JSONGenerator";
_jg = new anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 80;BA.debugLine="jg.Initialize(resMap)";
_jg.Initialize(_resmap);
 //BA.debugLineNum = 81;BA.debugLine="resp.Write(jg.ToString)";
_resp.Write(_jg.ToString());
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public String  _map2code(anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
String _k = "";
Object _obj = null;
 //BA.debugLineNum = 87;BA.debugLine="Sub map2code(m As Map) As String";
 //BA.debugLineNum = 88;BA.debugLine="If m.IsInitialized=False Then Return \"\"";
if (_m.IsInitialized()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 89;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 90;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 91;BA.debugLine="For Each k As String In m.Keys";
final anywheresoftware.b4a.BA.IterableList group4 = _m.Keys();
final int groupLen4 = group4.getSize();
for (int index4 = 0;index4 < groupLen4 ;index4++){
_k = BA.ObjectToString(group4.Get(index4));
 //BA.debugLineNum = 92;BA.debugLine="sb.Append(sIndent)";
_sb.Append(_sindent);
 //BA.debugLineNum = 93;BA.debugLine="Dim obj As Object=m.Get(k)";
_obj = _m.Get((Object)(_k));
 //BA.debugLineNum = 94;BA.debugLine="If obj Is Int Then";
if (_obj instanceof Integer) { 
 //BA.debugLineNum = 95;BA.debugLine="If k.EqualsIgnoreCase(\"id\") Then";
if (_k.equalsIgnoreCase("id")) { 
 //BA.debugLineNum = 96;BA.debugLine="sb.Append(\"@Column(name = \"\"\"&k&\"\"\",isId = tru";
_sb.Append("@Column(name = \""+_k+"\",isId = true,autoGen = false)"+__c.CRLF+_sindent+"private int "+_k+";").Append(__c.CRLF);
 }else {
 //BA.debugLineNum = 98;BA.debugLine="sb.Append(\"@Column(name = \"\"\"&k&\"\"\")\"&CRLF&sIn";
_sb.Append("@Column(name = \""+_k+"\")"+__c.CRLF+_sindent+"private int "+_k+";").Append(__c.CRLF);
 };
 }else if(_obj instanceof Double) { 
 //BA.debugLineNum = 102;BA.debugLine="sb.Append(\"@Column(name = \"\"\"&k&\"\"\")\"&CRLF&sInd";
_sb.Append("@Column(name = \""+_k+"\")"+__c.CRLF+_sindent+"private double"+_k+";").Append(__c.CRLF);
 }else {
 //BA.debugLineNum = 104;BA.debugLine="sb.Append(\"@Column(name = \"\"\"&k&\"\"\")\"&CRLF&sInd";
_sb.Append("@Column(name = \""+_k+"\")"+__c.CRLF+_sindent+"private String "+_k+";").Append(__c.CRLF);
 };
 }
;
 //BA.debugLineNum = 107;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 108;BA.debugLine="End Sub";
return "";
}
public String  _map2code2(anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
String _k = "";
Object _obj = null;
 //BA.debugLineNum = 110;BA.debugLine="Sub map2code2(m As Map) As String";
 //BA.debugLineNum = 111;BA.debugLine="If m.IsInitialized=False Then Return \"\"";
if (_m.IsInitialized()==__c.False) { 
if (true) return "";};
 //BA.debugLineNum = 112;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 113;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 114;BA.debugLine="For Each k As String In m.Keys";
final anywheresoftware.b4a.BA.IterableList group4 = _m.Keys();
final int groupLen4 = group4.getSize();
for (int index4 = 0;index4 < groupLen4 ;index4++){
_k = BA.ObjectToString(group4.Get(index4));
 //BA.debugLineNum = 115;BA.debugLine="sb.Append(sIndent).Append(sIndent).Append(sInden";
_sb.Append(_sindent).Append(_sindent).Append(_sindent);
 //BA.debugLineNum = 116;BA.debugLine="Dim obj As Object=m.Get(k)";
_obj = _m.Get((Object)(_k));
 //BA.debugLineNum = 117;BA.debugLine="If obj Is Int Then";
if (_obj instanceof Integer) { 
 //BA.debugLineNum = 118;BA.debugLine="sb.Append(\"this.\"&k&\"=jo.optInt(\"\"\"&k&\"\"\",0);\")";
_sb.Append("this."+_k+"=jo.optInt(\""+_k+"\",0);");
 }else if(_obj instanceof Double) { 
 //BA.debugLineNum = 120;BA.debugLine="sb.Append(\"this.\"&k&\"=jo.optDouble(\"\"\"&k&\"\"\",0d";
_sb.Append("this."+_k+"=jo.optDouble(\""+_k+"\",0d);");
 }else {
 //BA.debugLineNum = 122;BA.debugLine="sb.Append(\"this.\"&k&\"=jo.optString(\"\"\"&k&\"\"\",\"\"";
_sb.Append("this."+_k+"=jo.optString(\""+_k+"\",\"\");");
 };
 //BA.debugLineNum = 124;BA.debugLine="sb.Append(CRLF)";
_sb.Append(__c.CRLF);
 }
;
 //BA.debugLineNum = 126;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public String  _map2str(anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
String _ret = "";
anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator _jsg = null;
 //BA.debugLineNum = 128;BA.debugLine="Sub map2str(m As Map) As String";
 //BA.debugLineNum = 129;BA.debugLine="Dim ret As String";
_ret = "";
 //BA.debugLineNum = 130;BA.debugLine="Dim jsg As JSONGenerator";
_jsg = new anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 131;BA.debugLine="jsg.Initialize(m)";
_jsg.Initialize(_m);
 //BA.debugLineNum = 132;BA.debugLine="ret=jsg.ToString";
_ret = _jsg.ToString();
 //BA.debugLineNum = 133;BA.debugLine="Log(ret)";
__c.Log(_ret);
 //BA.debugLineNum = 134;BA.debugLine="Return ret";
if (true) return _ret;
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.Map  _str2map(String _s) throws Exception{
anywheresoftware.b4a.objects.collections.Map _ret = null;
anywheresoftware.b4j.objects.collections.JSONParser _jsp = null;
 //BA.debugLineNum = 136;BA.debugLine="Sub str2map(s As String) As Map";
 //BA.debugLineNum = 137;BA.debugLine="Dim ret As Map";
_ret = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 138;BA.debugLine="Try";
try { //BA.debugLineNum = 139;BA.debugLine="Dim jsp As JSONParser";
_jsp = new anywheresoftware.b4j.objects.collections.JSONParser();
 //BA.debugLineNum = 140;BA.debugLine="jsp.Initialize(s)";
_jsp.Initialize(_s);
 //BA.debugLineNum = 141;BA.debugLine="ret=jsp.NextObject";
_ret = _jsp.NextObject();
 } 
       catch (Exception e7) {
			ba.setLastException(e7); //BA.debugLineNum = 143;BA.debugLine="ret.Initialize";
_ret.Initialize();
 };
 //BA.debugLineNum = 146;BA.debugLine="Return ret";
if (true) return _ret;
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return null;
}
public String  _writecodehelper(String _objecttype,anywheresoftware.b4a.keywords.StringBuilderWrapper _code,String _parentname,String _getfrommap,boolean _buildlist,String _indent) throws Exception{
 //BA.debugLineNum = 191;BA.debugLine="Sub WriteCodeHelper (ObjectType As String, code As";
 //BA.debugLineNum = 194;BA.debugLine="If GetFromMap.Length > 0 Then";
if (_getfrommap.length()>0) { 
 //BA.debugLineNum = 195;BA.debugLine="Select ObjectType.ToLowerCase";
switch (BA.switchObjectToInt(_objecttype.toLowerCase(),"int","double","string")) {
case 0: {
 //BA.debugLineNum = 197;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
_code.Append("Dim "+_parentname+" As "+_objecttype+" = "+_getfrommap.replace("Get","GetDefault").replace(")",",0)")).Append(" "+__c.CRLF);
 break; }
case 1: {
 //BA.debugLineNum = 199;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
_code.Append("Dim "+_parentname+" As "+_objecttype+" = "+_getfrommap.replace("Get","GetDefault").replace(")",",0)")).Append(" "+__c.CRLF);
 break; }
case 2: {
 //BA.debugLineNum = 201;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
_code.Append("Dim "+_parentname+" As "+_objecttype+" = "+_getfrommap.replace("Get","GetDefault").replace(")",",\"\")")).Append(" "+__c.CRLF);
 break; }
default: {
 //BA.debugLineNum = 204;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
_code.Append("Dim "+_parentname+" As "+_objecttype+" = "+_getfrommap+" "+__c.CRLF);
 break; }
}
;
 }else if(_buildlist) { 
 //BA.debugLineNum = 207;BA.debugLine="code.Append(\"For Each \" & parentName & \" As \" &";
_code.Append("For Each "+_parentname+" As "+_objecttype+" In "+_parentname.substring((int) (3))).Append(" "+__c.CRLF);
 //BA.debugLineNum = 208;BA.debugLine="indent = indent & sIndent";
_indent = _indent+_sindent;
 };
 //BA.debugLineNum = 210;BA.debugLine="Return indent";
if (true) return _indent;
 //BA.debugLineNum = 211;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
