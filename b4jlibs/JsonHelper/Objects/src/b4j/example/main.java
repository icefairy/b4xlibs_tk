package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class main extends javafx.application.Application{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.ShellBA("b4j.example", "b4j.example.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			anywheresoftware.b4a.ShellBA.delegateBA = new anywheresoftware.b4j.objects.FxBA("b4j.example", null, null);
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) {
    	launch(args);
    }
    public void start (javafx.stage.Stage stage) {
        try {
            anywheresoftware.b4j.objects.FxBA.application = this;
		    anywheresoftware.b4a.keywords.Common.setDensity(javafx.stage.Screen.getPrimary().getDpi());
            BA.Log("Program started.");
            initializeProcessGlobals();
            anywheresoftware.b4j.objects.Form frm = new anywheresoftware.b4j.objects.Form();
            frm.initWithStage(ba, stage, 1024, 768);
            ba.raiseEvent(null, "appstart", frm, (String[])getParameters().getRaw().toArray(new String[0]));
        } catch (Throwable t) {
            BA.printException(t, true);
            System.exit(1);
        }
    }


private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.objects.JFX _fx = null;
public static anywheresoftware.b4j.objects.Form _mainform = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper _edtjson = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper _edtcode = null;
public static String _sindent = "";
public static String  _appstart(anywheresoftware.b4j.objects.Form _form1,String[] _args) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "appstart"))
	return (String) Debug.delegate(ba, "appstart", new Object[] {_form1,_args});
RDebugUtils.currentLine=65536;
 //BA.debugLineNum = 65536;BA.debugLine="Sub AppStart (Form1 As Form, Args() As String)";
RDebugUtils.currentLine=65537;
 //BA.debugLineNum = 65537;BA.debugLine="MainForm = Form1";
_mainform = _form1;
RDebugUtils.currentLine=65538;
 //BA.debugLineNum = 65538;BA.debugLine="MainForm.SetFormStyle(\"UNIFIED\")";
_mainform.SetFormStyle("UNIFIED");
RDebugUtils.currentLine=65539;
 //BA.debugLineNum = 65539;BA.debugLine="MainForm.RootPane.LoadLayout(\"laymain\") 'Load the";
_mainform.getRootPane().LoadLayout(ba,"laymain");
RDebugUtils.currentLine=65540;
 //BA.debugLineNum = 65540;BA.debugLine="MainForm.Show";
_mainform.Show();
RDebugUtils.currentLine=65541;
 //BA.debugLineNum = 65541;BA.debugLine="DisableScrollBar(edtJson,True,False)";
_disablescrollbar(_edtjson,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=65542;
 //BA.debugLineNum = 65542;BA.debugLine="End Sub";
return "";
}
public static String  _disablescrollbar(anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper _ta,boolean _showvertical,boolean _showhorizontal) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "disablescrollbar"))
	return (String) Debug.delegate(ba, "disablescrollbar", new Object[] {_ta,_showvertical,_showhorizontal});
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _scrollbarver = null;
anywheresoftware.b4j.object.JavaObject _scrollbarhor = null;
double _d_d = 0;
double _d_e = 0;
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub DisableScrollBar(ta As TextArea,showvertical A";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Dim jo As JavaObject = ta";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_ta.getObject()));
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="Dim scrollbarver As JavaObject = jo.RunMethod(\"lo";
_scrollbarver = new anywheresoftware.b4j.object.JavaObject();
_scrollbarver.setObject((java.lang.Object)(_jo.RunMethod("lookup",new Object[]{(Object)(".scroll-bar:vertical")})));
RDebugUtils.currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="Dim scrollbarhor As JavaObject = jo.RunMethod(\"lo";
_scrollbarhor = new anywheresoftware.b4j.object.JavaObject();
_scrollbarhor.setObject((java.lang.Object)(_jo.RunMethod("lookup",new Object[]{(Object)(".scroll-bar:horizontal")})));
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="Dim d_d As Double = 1,d_e As Double=0";
_d_d = 1;
_d_e = 0;
RDebugUtils.currentLine=524293;
 //BA.debugLineNum = 524293;BA.debugLine="If showvertical Then";
if (_showvertical) { 
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="scrollbarver.RunMethod(\"setOpacity\", Array(d_";
_scrollbarver.RunMethod("setOpacity",new Object[]{(Object)(_d_e)});
 }else {
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="scrollbarver.RunMethod(\"setOpacity\", Array(d_d))";
_scrollbarver.RunMethod("setOpacity",new Object[]{(Object)(_d_d)});
 };
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="If showhorizontal Then";
if (_showhorizontal) { 
RDebugUtils.currentLine=524299;
 //BA.debugLineNum = 524299;BA.debugLine="scrollbarhor.RunMethod(\"setOpacity\", Array(d_e))";
_scrollbarhor.RunMethod("setOpacity",new Object[]{(Object)(_d_e)});
 }else {
RDebugUtils.currentLine=524301;
 //BA.debugLineNum = 524301;BA.debugLine="scrollbarhor.RunMethod(\"setOpacity\", Array(d_d))";
_scrollbarhor.RunMethod("setOpacity",new Object[]{(Object)(_d_d)});
 };
RDebugUtils.currentLine=524303;
 //BA.debugLineNum = 524303;BA.debugLine="End Sub";
return "";
}
public static boolean  _askexit() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "askexit"))
	return (Boolean) Debug.delegate(ba, "askexit", null);
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Private Sub askexit As Boolean";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="If fx.Msgbox2(MainForm,\"Sure to exit?\",\"exit\",\"Ye";
if (_fx.Msgbox2(_mainform,"Sure to exit?","exit","Yes","No","",_fx.MSGBOX_CONFIRMATION)==_fx.DialogResponse.POSITIVE) { 
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="End Sub";
return false;
}
public static String  _buildtree_b4x(Object _element,anywheresoftware.b4a.keywords.StringBuilderWrapper _code,String _parentname,String _getfrommap,boolean _buildlist,String _indent) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "buildtree_b4x"))
	return (String) Debug.delegate(ba, "buildtree_b4x", new Object[] {_element,_code,_parentname,_getfrommap,_buildlist,_indent});
anywheresoftware.b4a.objects.collections.Map _m = null;
String _k = "";
anywheresoftware.b4a.objects.collections.List _l = null;
int _index = 0;
Object _e = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _stubcode = null;
String _objecttype = "";
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub BuildTree_b4x(element As Object,code As String";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="code.Append(indent)";
_code.Append(_indent);
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="If element Is Map Then";
if (_element instanceof anywheresoftware.b4a.objects.collections.Map.MyMap) { 
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="indent = WriteCodeHelper_b4x(\"Map\", code, parent";
_indent = _writecodehelper_b4x("Map",_code,_parentname,_getfrommap,_buildlist,_indent);
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="Dim m As Map = element";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_element));
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="For Each k As String In m.Keys";
final anywheresoftware.b4a.BA.IterableList group5 = _m.Keys();
final int groupLen5 = group5.getSize();
for (int index5 = 0;index5 < groupLen5 ;index5++){
_k = BA.ObjectToString(group5.Get(index5));
RDebugUtils.currentLine=655369;
 //BA.debugLineNum = 655369;BA.debugLine="BuildTree_b4x(m.Get(k),  code, k, parentName &";
_buildtree_b4x(_m.Get((Object)(_k)),_code,_k,_parentname+".Get(\""+_k+"\")",anywheresoftware.b4a.keywords.Common.False,_indent);
 }
;
 }else 
{RDebugUtils.currentLine=655371;
 //BA.debugLineNum = 655371;BA.debugLine="Else If element Is List Then";
if (_element instanceof java.util.List) { 
RDebugUtils.currentLine=655372;
 //BA.debugLineNum = 655372;BA.debugLine="indent = WriteCodeHelper_b4x(\"List\", code, paren";
_indent = _writecodehelper_b4x("List",_code,_parentname,_getfrommap,_buildlist,_indent);
RDebugUtils.currentLine=655373;
 //BA.debugLineNum = 655373;BA.debugLine="Dim l As List = element";
_l = new anywheresoftware.b4a.objects.collections.List();
_l.setObject((java.util.List)(_element));
RDebugUtils.currentLine=655374;
 //BA.debugLineNum = 655374;BA.debugLine="Dim index As Int = 0";
_index = (int) (0);
RDebugUtils.currentLine=655375;
 //BA.debugLineNum = 655375;BA.debugLine="For Each e As Object In l";
final anywheresoftware.b4a.BA.IterableList group12 = _l;
final int groupLen12 = group12.getSize();
for (int index12 = 0;index12 < groupLen12 ;index12++){
_e = group12.Get(index12);
RDebugUtils.currentLine=655378;
 //BA.debugLineNum = 655378;BA.debugLine="Dim stubCode As StringBuilder";
_stubcode = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=655380;
 //BA.debugLineNum = 655380;BA.debugLine="If index = 0 Then stubCode = code Else stubCode";
if (_index==0) { 
_stubcode = _code;}
else {
_stubcode.Initialize();};
RDebugUtils.currentLine=655381;
 //BA.debugLineNum = 655381;BA.debugLine="BuildTree_b4x(e,  stubCode, \"col\" & parentName";
_buildtree_b4x(_e,_stubcode,"col"+_parentname,"",_index==0,_indent);
RDebugUtils.currentLine=655382;
 //BA.debugLineNum = 655382;BA.debugLine="index = index + 1";
_index = (int) (_index+1);
 }
;
 }else {
RDebugUtils.currentLine=655385;
 //BA.debugLineNum = 655385;BA.debugLine="Dim objectType As String";
_objecttype = "";
RDebugUtils.currentLine=655386;
 //BA.debugLineNum = 655386;BA.debugLine="If element Is Int Then";
if (_element instanceof Integer) { 
RDebugUtils.currentLine=655387;
 //BA.debugLineNum = 655387;BA.debugLine="objectType = \"Int\"";
_objecttype = "Int";
 }else 
{RDebugUtils.currentLine=655388;
 //BA.debugLineNum = 655388;BA.debugLine="Else If element Is Double Then";
if (_element instanceof Double) { 
RDebugUtils.currentLine=655389;
 //BA.debugLineNum = 655389;BA.debugLine="objectType = \"Double\"";
_objecttype = "Double";
 }else {
RDebugUtils.currentLine=655391;
 //BA.debugLineNum = 655391;BA.debugLine="objectType = \"String\"";
_objecttype = "String";
 }};
RDebugUtils.currentLine=655393;
 //BA.debugLineNum = 655393;BA.debugLine="indent = WriteCodeHelper_b4x(objectType, code, p";
_indent = _writecodehelper_b4x(_objecttype,_code,_parentname,_getfrommap,_buildlist,_indent);
 }};
RDebugUtils.currentLine=655396;
 //BA.debugLineNum = 655396;BA.debugLine="If BuildList Then";
if (_buildlist) { 
RDebugUtils.currentLine=655398;
 //BA.debugLineNum = 655398;BA.debugLine="code.Append(indent.SubString(sIndent.Length)).Ap";
_code.Append(_indent.substring(_sindent.length())).Append("Next").Append(" "+anywheresoftware.b4a.keywords.Common.CRLF);
 };
RDebugUtils.currentLine=655400;
 //BA.debugLineNum = 655400;BA.debugLine="End Sub";
return "";
}
public static String  _writecodehelper_b4x(String _objecttype,anywheresoftware.b4a.keywords.StringBuilderWrapper _code,String _parentname,String _getfrommap,boolean _buildlist,String _indent) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "writecodehelper_b4x"))
	return (String) Debug.delegate(ba, "writecodehelper_b4x", new Object[] {_objecttype,_code,_parentname,_getfrommap,_buildlist,_indent});
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub WriteCodeHelper_b4x (ObjectType As String, cod";
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="If GetFromMap.Length > 0 Then";
if (_getfrommap.length()>0) { 
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="Select ObjectType.ToLowerCase";
switch (BA.switchObjectToInt(_objecttype.toLowerCase(),"int","double","string")) {
case 0: {
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
_code.Append("Dim "+_parentname+" As "+_objecttype+" = "+_getfrommap.replace("Get","GetDefault").replace(")",",0)")).Append(" "+anywheresoftware.b4a.keywords.Common.CRLF);
 break; }
case 1: {
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
_code.Append("Dim "+_parentname+" As "+_objecttype+" = "+_getfrommap.replace("Get","GetDefault").replace(")",",0)")).Append(" "+anywheresoftware.b4a.keywords.Common.CRLF);
 break; }
case 2: {
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
_code.Append("Dim "+_parentname+" As "+_objecttype+" = "+_getfrommap.replace("Get","GetDefault").replace(")",",\"\")")).Append(" "+anywheresoftware.b4a.keywords.Common.CRLF);
 break; }
default: {
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
_code.Append("Dim "+_parentname+" As "+_objecttype+" = "+_getfrommap+" "+anywheresoftware.b4a.keywords.Common.CRLF);
 break; }
}
;
 }else 
{RDebugUtils.currentLine=720910;
 //BA.debugLineNum = 720910;BA.debugLine="Else If BuildList Then";
if (_buildlist) { 
RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="code.Append(\"For Each \" & parentName & \" As \" &";
_code.Append("For Each "+_parentname+" As "+_objecttype+" In "+_parentname.substring((int) (3))).Append(" "+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=720912;
 //BA.debugLineNum = 720912;BA.debugLine="indent = indent & sIndent";
_indent = _indent+_sindent;
 }};
RDebugUtils.currentLine=720914;
 //BA.debugLineNum = 720914;BA.debugLine="Return indent";
if (true) return _indent;
RDebugUtils.currentLine=720915;
 //BA.debugLineNum = 720915;BA.debugLine="End Sub";
return "";
}
public static String  _exit_action() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "exit_action"))
	return (String) Debug.delegate(ba, "exit_action", null);
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub exit_Action";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="If askexit Then ExitApplication";
if (_askexit()) { 
anywheresoftware.b4a.keywords.Common.ExitApplication();};
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _mainform_closerequest(anywheresoftware.b4j.objects.NodeWrapper.ConcreteEventWrapper _eventdata) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "mainform_closerequest"))
	return (String) Debug.delegate(ba, "mainform_closerequest", new Object[] {_eventdata});
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub MainForm_CloseRequest (EventData As Event)";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="If askexit=False Then EventData.Consume";
if (_askexit()==anywheresoftware.b4a.keywords.Common.False) { 
_eventdata.Consume();};
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="End Sub";
return "";
}
public static String  _parsetob4x(String _str) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "parsetob4x"))
	return (String) Debug.delegate(ba, "parsetob4x", new Object[] {_str});
String _text = "";
anywheresoftware.b4j.objects.collections.JSONParser _parser = null;
boolean _squarebracketfound = false;
int _i = 0;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code = null;
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub parsetob4x(str As String) As String";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Dim text As String = str";
_text = _str;
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4j.objects.collections.JSONParser();
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="parser.Initialize(text)";
_parser.Initialize(_text);
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="Dim squareBracketFound As Boolean";
_squarebracketfound = false;
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="For i = 0 To text.Length";
{
final int step5 = 1;
final int limit5 = _text.length();
for (_i = (int) (0) ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="If text.CharAt(i) = \"[\" Then";
if (_text.charAt(_i)==BA.ObjectToChar("[")) { 
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="squareBracketFound = True";
_squarebracketfound = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="Exit";
if (true) break;
 }else 
{RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="Else If text.CharAt(i) = \"{\" Then";
if (_text.charAt(_i)==BA.ObjectToChar("{")) { 
RDebugUtils.currentLine=589835;
 //BA.debugLineNum = 589835;BA.debugLine="Exit";
if (true) break;
 }};
 }
};
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="Dim code As StringBuilder";
_code = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="code.Initialize";
_code.Initialize();
RDebugUtils.currentLine=589840;
 //BA.debugLineNum = 589840;BA.debugLine="code.Append(\"Dim parser As JSONParser\").Append(\"";
_code.Append("Dim parser As JSONParser").Append(" "+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="code.Append(\"parser.Initialize(str)\").Append(\" \"";
_code.Append("parser.Initialize(str)").Append(" "+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=589842;
 //BA.debugLineNum = 589842;BA.debugLine="code.Append(\"Dim root As \")";
_code.Append("Dim root As ");
RDebugUtils.currentLine=589844;
 //BA.debugLineNum = 589844;BA.debugLine="If squareBracketFound Then";
if (_squarebracketfound) { 
RDebugUtils.currentLine=589845;
 //BA.debugLineNum = 589845;BA.debugLine="code.Append(\"List = parser.NextArray\").Append(\"";
_code.Append("List = parser.NextArray").Append(" "+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=589846;
 //BA.debugLineNum = 589846;BA.debugLine="BuildTree_b4x(parser.NextArray, code, \"root\", \"";
_buildtree_b4x((Object)(_parser.NextArray().getObject()),_code,"root","",anywheresoftware.b4a.keywords.Common.False,"");
 }else {
RDebugUtils.currentLine=589848;
 //BA.debugLineNum = 589848;BA.debugLine="code.Append(\"Map = parser.NextObject\").Append(\"";
_code.Append("Map = parser.NextObject").Append(" "+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=589849;
 //BA.debugLineNum = 589849;BA.debugLine="BuildTree_b4x(parser.NextObject,  code, \"root\",";
_buildtree_b4x((Object)(_parser.NextObject().getObject()),_code,"root","",anywheresoftware.b4a.keywords.Common.False,"");
 };
RDebugUtils.currentLine=589851;
 //BA.debugLineNum = 589851;BA.debugLine="Return code.ToString";
if (true) return _code.ToString();
RDebugUtils.currentLine=589852;
 //BA.debugLineNum = 589852;BA.debugLine="End Sub";
return "";
}
public static String  _reset_action() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "reset_action"))
	return (String) Debug.delegate(ba, "reset_action", null);
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub reset_Action";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="edtJson.Text=\"\"";
_edtjson.setText("");
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="edtcode.Text=\"\"";
_edtcode.setText("");
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="End Sub";
return "";
}
public static String  _tob4x_action() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "tob4x_action"))
	return (String) Debug.delegate(ba, "tob4x_action", null);
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub tob4x_Action";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Log(\"tob4x\")";
anywheresoftware.b4a.keywords.Common.Log("tob4x");
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="If edtJson.Text.Length<1 Then";
if (_edtjson.getText().length()<1) { 
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="fx.Msgbox(MainForm,\"JSON string is empty\",\"Empty";
_fx.Msgbox(_mainform,"JSON string is empty","Empty");
 }else {
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="edtcode.Text= parsetob4x(edtJson.Text)";
_edtcode.setText(_parsetob4x(_edtjson.getText()));
 };
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="End Sub";
return "";
}
public static String  _tojava_action() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "tojava_action"))
	return (String) Debug.delegate(ba, "tojava_action", null);
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub tojava_Action";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Log(\"tojava\")";
anywheresoftware.b4a.keywords.Common.Log("tojava");
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
}