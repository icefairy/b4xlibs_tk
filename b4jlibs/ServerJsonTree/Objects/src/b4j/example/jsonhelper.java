package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class jsonhelper extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.jsonhelper", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.jsonhelper.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.collections.Map _resmap = null;
public String _sindent = "";
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
 //BA.debugLineNum = 60;BA.debugLine="Sub BuildTree(element As Object, parent As TreeIte";
 //BA.debugLineNum = 62;BA.debugLine="code.Append(indent)";
_code.Append(_indent);
 //BA.debugLineNum = 63;BA.debugLine="If element Is Map Then";
if (_element instanceof anywheresoftware.b4a.objects.collections.Map.MyMap) { 
 //BA.debugLineNum = 64;BA.debugLine="indent = WriteCodeHelper(\"Map\", code, parentName";
_indent = _writecodehelper("Map",_code,_parentname,_getfrommap,_buildlist,_indent);
 //BA.debugLineNum = 65;BA.debugLine="Dim m As Map = element";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_element));
 //BA.debugLineNum = 66;BA.debugLine="For Each k As String In m.Keys";
final anywheresoftware.b4a.BA.IterableList group5 = _m.Keys();
final int groupLen5 = group5.getSize();
for (int index5 = 0;index5 < groupLen5 ;index5++){
_k = BA.ObjectToString(group5.Get(index5));
 //BA.debugLineNum = 67;BA.debugLine="Dim ti As TreeItem = CreateTreeItem(k)";
_ti = _createtreeitem(_k);
 //BA.debugLineNum = 68;BA.debugLine="parent.Children.Add(ti)";
_parent.Children.Add((Object)(_ti));
 //BA.debugLineNum = 69;BA.debugLine="BuildTree(m.Get(k), ti, code, k, parentName & \"";
_buildtree(_m.Get((Object)(_k)),_ti,_code,_k,_parentname+".Get(\""+_k+"\")",__c.False,_indent);
 }
;
 }else if(_element instanceof java.util.List) { 
 //BA.debugLineNum = 72;BA.debugLine="indent = WriteCodeHelper(\"List\", code, parentNam";
_indent = _writecodehelper("List",_code,_parentname,_getfrommap,_buildlist,_indent);
 //BA.debugLineNum = 73;BA.debugLine="Dim l As List = element";
_l = new anywheresoftware.b4a.objects.collections.List();
_l.setObject((java.util.List)(_element));
 //BA.debugLineNum = 74;BA.debugLine="Dim index As Int = 0";
_index = (int) (0);
 //BA.debugLineNum = 75;BA.debugLine="For Each e As Object In l";
final anywheresoftware.b4a.BA.IterableList group14 = _l;
final int groupLen14 = group14.getSize();
for (int index14 = 0;index14 < groupLen14 ;index14++){
_e = group14.Get(index14);
 //BA.debugLineNum = 76;BA.debugLine="Dim ti As TreeItem = CreateTreeItem(index)";
_ti = _createtreeitem(BA.NumberToString(_index));
 //BA.debugLineNum = 77;BA.debugLine="parent.Children.Add(ti)";
_parent.Children.Add((Object)(_ti));
 //BA.debugLineNum = 78;BA.debugLine="Dim stubCode As StringBuilder";
_stubcode = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 80;BA.debugLine="If index = 0 Then stubCode = code Else stubCode";
if (_index==0) { 
_stubcode = _code;}
else {
_stubcode.Initialize();};
 //BA.debugLineNum = 81;BA.debugLine="BuildTree(e, ti, stubCode, \"col\" & parentName ,";
_buildtree(_e,_ti,_stubcode,"col"+_parentname,"",_index==0,_indent);
 //BA.debugLineNum = 82;BA.debugLine="index = index + 1";
_index = (int) (_index+1);
 }
;
 }else {
 //BA.debugLineNum = 85;BA.debugLine="Dim objectType As String";
_objecttype = "";
 //BA.debugLineNum = 86;BA.debugLine="If element Is Int Then";
if (_element instanceof Integer) { 
 //BA.debugLineNum = 87;BA.debugLine="objectType = \"Int\"";
_objecttype = "Int";
 }else if(_element instanceof Double) { 
 //BA.debugLineNum = 89;BA.debugLine="objectType = \"Double\"";
_objecttype = "Double";
 }else {
 //BA.debugLineNum = 91;BA.debugLine="objectType = \"String\"";
_objecttype = "String";
 };
 //BA.debugLineNum = 93;BA.debugLine="indent = WriteCodeHelper(objectType, code, paren";
_indent = _writecodehelper(_objecttype,_code,_parentname,_getfrommap,_buildlist,_indent);
 //BA.debugLineNum = 94;BA.debugLine="parent.Text = parent.Text & \": \" & element";
_parent.Text = _parent.Text+": "+BA.ObjectToString(_element);
 };
 //BA.debugLineNum = 96;BA.debugLine="If BuildList Then";
if (_buildlist) { 
 //BA.debugLineNum = 98;BA.debugLine="code.Append(indent.SubString(sIndent.Length)).Ap";
_code.Append(_indent.substring(_sindent.length())).Append("Next").Append(" "+__c.CRLF);
 };
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Private resMap As Map";
_resmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 5;BA.debugLine="Private sIndent As String=\"    \"";
_sindent = "    ";
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public String  _converttreetohtml(anywheresoftware.b4a.keywords.StringBuilderWrapper _sb,b4j.example.common._treeitem _parent,boolean _isroot) throws Exception{
b4j.example.common._treeitem _ti = null;
 //BA.debugLineNum = 124;BA.debugLine="Private Sub ConvertTreeToHtml(sb As StringBuilder,";
 //BA.debugLineNum = 125;BA.debugLine="If isRoot = False Then sb.Append(\"<li>\").Append(E";
if (_isroot==__c.False) { 
_sb.Append("<li>").Append(_escapexml(_parent.Text));};
 //BA.debugLineNum = 126;BA.debugLine="If parent.Children.Size > 0 Then";
if (_parent.Children.getSize()>0) { 
 //BA.debugLineNum = 127;BA.debugLine="sb.Append(\"<ul>\")";
_sb.Append("<ul>");
 //BA.debugLineNum = 128;BA.debugLine="For Each ti As TreeItem In parent.Children";
final anywheresoftware.b4a.BA.IterableList group4 = _parent.Children;
final int groupLen4 = group4.getSize();
for (int index4 = 0;index4 < groupLen4 ;index4++){
_ti = (b4j.example.common._treeitem)(group4.Get(index4));
 //BA.debugLineNum = 129;BA.debugLine="sb.Append(CRLF)";
_sb.Append(__c.CRLF);
 //BA.debugLineNum = 130;BA.debugLine="ConvertTreeToHtml(sb, ti, False)";
_converttreetohtml(_sb,_ti,__c.False);
 }
;
 //BA.debugLineNum = 132;BA.debugLine="sb.Append(\"</ul>\")";
_sb.Append("</ul>");
 };
 //BA.debugLineNum = 134;BA.debugLine="If isRoot = False Then sb.Append(\"</li>\")";
if (_isroot==__c.False) { 
_sb.Append("</li>");};
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
return "";
}
public b4j.example.common._treeitem  _createtreeitem(String _text) throws Exception{
b4j.example.common._treeitem _ti = null;
 //BA.debugLineNum = 136;BA.debugLine="Private Sub CreateTreeItem (text As String) As Tre";
 //BA.debugLineNum = 137;BA.debugLine="Dim ti As TreeItem";
_ti = new b4j.example.common._treeitem();
 //BA.debugLineNum = 138;BA.debugLine="ti.Initialize";
_ti.Initialize();
 //BA.debugLineNum = 139;BA.debugLine="ti.Children.Initialize";
_ti.Children.Initialize();
 //BA.debugLineNum = 140;BA.debugLine="ti.text = text";
_ti.Text = _text;
 //BA.debugLineNum = 141;BA.debugLine="Return ti";
if (true) return _ti;
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return null;
}
public String  _escapexml(String _raw) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
char _c = '\0';
 //BA.debugLineNum = 143;BA.debugLine="Private Sub EscapeXml(Raw As String) As String";
 //BA.debugLineNum = 144;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 145;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 146;BA.debugLine="For i = 0 To Raw.Length - 1";
{
final int step3 = 1;
final int limit3 = (int) (_raw.length()-1);
for (_i = (int) (0) ; (step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3); _i = ((int)(0 + _i + step3)) ) {
 //BA.debugLineNum = 147;BA.debugLine="Dim C As Char = Raw.CharAt(i)";
_c = _raw.charAt(_i);
 //BA.debugLineNum = 148;BA.debugLine="Select C";
switch (BA.switchObjectToInt(_c,BA.ObjectToChar(__c.QUOTE),BA.ObjectToChar("'"),BA.ObjectToChar("<"),BA.ObjectToChar(">"),BA.ObjectToChar("&"))) {
case 0: {
 //BA.debugLineNum = 150;BA.debugLine="sb.Append(\"&quot;\")";
_sb.Append("&quot;");
 break; }
case 1: {
 //BA.debugLineNum = 152;BA.debugLine="sb.Append(\"&apos;\")";
_sb.Append("&apos;");
 break; }
case 2: {
 //BA.debugLineNum = 154;BA.debugLine="sb.Append(\"&lt;\")";
_sb.Append("&lt;");
 break; }
case 3: {
 //BA.debugLineNum = 156;BA.debugLine="sb.Append(\"&gt;\")";
_sb.Append("&gt;");
 break; }
case 4: {
 //BA.debugLineNum = 158;BA.debugLine="sb.Append(\"&amp;\")";
_sb.Append("&amp;");
 break; }
default: {
 //BA.debugLineNum = 160;BA.debugLine="sb.Append(C)";
_sb.Append(BA.ObjectToString(_c));
 break; }
}
;
 }
};
 //BA.debugLineNum = 163;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
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
anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator _jg = null;
 //BA.debugLineNum = 13;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
 //BA.debugLineNum = 14;BA.debugLine="resp.ContentType = \"application/json\"";
_resp.setContentType("application/json");
 //BA.debugLineNum = 15;BA.debugLine="resp.CharacterEncoding=\"UTF-8\"";
_resp.setCharacterEncoding("UTF-8");
 //BA.debugLineNum = 16;BA.debugLine="resMap.Initialize";
_resmap.Initialize();
 //BA.debugLineNum = 17;BA.debugLine="Try";
try { //BA.debugLineNum = 18;BA.debugLine="Dim data() As Byte = Bit.InputStreamToBytes(req.";
_data = __c.Bit.InputStreamToBytes((java.io.InputStream)(_req.getInputStream().getObject()));
 //BA.debugLineNum = 19;BA.debugLine="Dim text As String = BytesToString(data, 0, data";
_text = __c.BytesToString(_data,(int) (0),_data.length,"UTF8");
 //BA.debugLineNum = 20;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4j.objects.collections.JSONParser();
 //BA.debugLineNum = 21;BA.debugLine="parser.Initialize(text)";
_parser.Initialize(_text);
 //BA.debugLineNum = 22;BA.debugLine="Dim squareBracketFound As Boolean";
_squarebracketfound = false;
 //BA.debugLineNum = 24;BA.debugLine="For i = 0 To text.Length";
{
final int step10 = 1;
final int limit10 = _text.length();
for (_i = (int) (0) ; (step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10); _i = ((int)(0 + _i + step10)) ) {
 //BA.debugLineNum = 25;BA.debugLine="If text.CharAt(i) = \"[\" Then";
if (_text.charAt(_i)==BA.ObjectToChar("[")) { 
 //BA.debugLineNum = 26;BA.debugLine="squareBracketFound = True";
_squarebracketfound = __c.True;
 //BA.debugLineNum = 27;BA.debugLine="Exit";
if (true) break;
 }else if(_text.charAt(_i)==BA.ObjectToChar("{")) { 
 //BA.debugLineNum = 29;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 //BA.debugLineNum = 32;BA.debugLine="Dim code As StringBuilder";
_code = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 33;BA.debugLine="code.Initialize";
_code.Initialize();
 //BA.debugLineNum = 34;BA.debugLine="code.Append(\"Dim parser As JSONParser\").Append(\"";
_code.Append("Dim parser As JSONParser").Append(" "+__c.CRLF);
 //BA.debugLineNum = 35;BA.debugLine="code.Append(\"parser.Initialize(str)\").Append(\" \"";
_code.Append("parser.Initialize(str)").Append(" "+__c.CRLF);
 //BA.debugLineNum = 36;BA.debugLine="code.Append(\"Dim root As \")";
_code.Append("Dim root As ");
 //BA.debugLineNum = 37;BA.debugLine="Dim root As TreeItem = CreateTreeItem (\"\")";
_root = _createtreeitem("");
 //BA.debugLineNum = 38;BA.debugLine="If squareBracketFound Then";
if (_squarebracketfound) { 
 //BA.debugLineNum = 39;BA.debugLine="code.Append(\"List = parser.NextArray\").Append(\"";
_code.Append("List = parser.NextArray").Append(" "+__c.CRLF);
 //BA.debugLineNum = 40;BA.debugLine="BuildTree(parser.NextArray, root, code, \"root\",";
_buildtree((Object)(_parser.NextArray().getObject()),_root,_code,"root","",__c.False,"");
 }else {
 //BA.debugLineNum = 42;BA.debugLine="code.Append(\"Map = parser.NextObject\").Append(\"";
_code.Append("Map = parser.NextObject").Append(" "+__c.CRLF);
 //BA.debugLineNum = 43;BA.debugLine="BuildTree(parser.NextObject, root, code, \"root\"";
_buildtree((Object)(_parser.NextObject().getObject()),_root,_code,"root","",__c.False,"");
 };
 //BA.debugLineNum = 45;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 46;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 47;BA.debugLine="ConvertTreeToHtml(sb, root, True)";
_converttreetohtml(_sb,_root,__c.True);
 //BA.debugLineNum = 48;BA.debugLine="resMap.Put(\"tree\", sb.ToString)";
_resmap.Put((Object)("tree"),(Object)(_sb.ToString()));
 //BA.debugLineNum = 49;BA.debugLine="resMap.Put(\"success\", True)";
_resmap.Put((Object)("success"),(Object)(__c.True));
 //BA.debugLineNum = 50;BA.debugLine="resMap.Put(\"code\", code.ToString)";
_resmap.Put((Object)("code"),(Object)(_code.ToString()));
 } 
       catch (Exception e38) {
			ba.setLastException(e38); //BA.debugLineNum = 52;BA.debugLine="resMap.Put(\"success\", False)";
_resmap.Put((Object)("success"),(Object)(__c.False));
 //BA.debugLineNum = 53;BA.debugLine="resMap.Put(\"error\", \"Error parsing string:\" & CR";
_resmap.Put((Object)("error"),(Object)("Error parsing string:"+__c.CRLF+__c.LastException(ba).getMessage()));
 };
 //BA.debugLineNum = 55;BA.debugLine="Dim jg As JSONGenerator";
_jg = new anywheresoftware.b4j.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 56;BA.debugLine="jg.Initialize(resMap)";
_jg.Initialize(_resmap);
 //BA.debugLineNum = 57;BA.debugLine="resp.Write(jg.ToString)";
_resp.Write(_jg.ToString());
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public String  _writecodehelper(String _objecttype,anywheresoftware.b4a.keywords.StringBuilderWrapper _code,String _parentname,String _getfrommap,boolean _buildlist,String _indent) throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="Sub WriteCodeHelper (ObjectType As String, code As";
 //BA.debugLineNum = 105;BA.debugLine="If GetFromMap.Length > 0 Then";
if (_getfrommap.length()>0) { 
 //BA.debugLineNum = 106;BA.debugLine="Select ObjectType.ToLowerCase";
switch (BA.switchObjectToInt(_objecttype.toLowerCase(),"int","double","string")) {
case 0: {
 //BA.debugLineNum = 108;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
_code.Append("Dim "+_parentname+" As "+_objecttype+" = "+_getfrommap.replace("Get","GetDefault").replace(")",",0)")).Append(" "+__c.CRLF);
 break; }
case 1: {
 //BA.debugLineNum = 110;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
_code.Append("Dim "+_parentname+" As "+_objecttype+" = "+_getfrommap.replace("Get","GetDefault").replace(")",",0)")).Append(" "+__c.CRLF);
 break; }
case 2: {
 //BA.debugLineNum = 112;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
_code.Append("Dim "+_parentname+" As "+_objecttype+" = "+_getfrommap.replace("Get","GetDefault").replace(")",",\"\")")).Append(" "+__c.CRLF);
 break; }
default: {
 //BA.debugLineNum = 115;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
_code.Append("Dim "+_parentname+" As "+_objecttype+" = "+_getfrommap+" "+__c.CRLF);
 break; }
}
;
 }else if(_buildlist) { 
 //BA.debugLineNum = 118;BA.debugLine="code.Append(\"For Each \" & parentName & \" As \" &";
_code.Append("For Each "+_parentname+" As "+_objecttype+" In "+_parentname.substring((int) (3))).Append(" "+__c.CRLF);
 //BA.debugLineNum = 119;BA.debugLine="indent = indent & sIndent";
_indent = _indent+_sindent;
 };
 //BA.debugLineNum = 121;BA.debugLine="Return indent";
if (true) return _indent;
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
