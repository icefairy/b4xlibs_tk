package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _appstart(RemoteObject _form1,RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("AppStart (main) ","main",0,main.ba,main.mostCurrent,14);
if (RapidSub.canDelegate("appstart")) return main.remoteMe.runUserSub(false, "main","appstart", _form1, _args);
Debug.locals.put("Form1", _form1);
Debug.locals.put("Args", _args);
 BA.debugLineNum = 14;BA.debugLine="Sub AppStart (Form1 As Form, Args() As String)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 15;BA.debugLine="MainForm = Form1";
Debug.ShouldStop(16384);
main._mainform = _form1;
 BA.debugLineNum = 16;BA.debugLine="MainForm.SetFormStyle(\"UNIFIED\")";
Debug.ShouldStop(32768);
main._mainform.runVoidMethod ("SetFormStyle",(Object)(RemoteObject.createImmutable("UNIFIED")));
 BA.debugLineNum = 17;BA.debugLine="MainForm.RootPane.LoadLayout(\"laymain\") 'Load the";
Debug.ShouldStop(65536);
main._mainform.runMethod(false,"getRootPane").runMethodAndSync(false,"LoadLayout",main.ba,(Object)(RemoteObject.createImmutable("laymain")));
 BA.debugLineNum = 18;BA.debugLine="MainForm.Show";
Debug.ShouldStop(131072);
main._mainform.runVoidMethodAndSync ("Show");
 BA.debugLineNum = 19;BA.debugLine="DisableScrollBar(edtJson,True,False)";
Debug.ShouldStop(262144);
_disablescrollbar(main._edtjson,main.__c.getField(true,"True"),main.__c.getField(true,"False"));
 BA.debugLineNum = 20;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _askexit() throws Exception{
try {
		Debug.PushSubsStack("askexit (main) ","main",0,main.ba,main.mostCurrent,35);
if (RapidSub.canDelegate("askexit")) return main.remoteMe.runUserSub(false, "main","askexit");
 BA.debugLineNum = 35;BA.debugLine="Private Sub askexit As Boolean";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="If fx.Msgbox2(MainForm,\"Sure to exit?\",\"exit\",\"Ye";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",main._fx.runMethodAndSync(true,"Msgbox2",(Object)(main._mainform),(Object)(BA.ObjectToString("Sure to exit?")),(Object)(BA.ObjectToString("exit")),(Object)(BA.ObjectToString("Yes")),(Object)(BA.ObjectToString("No")),(Object)(BA.ObjectToString("")),(Object)(main._fx.getField(false,"MSGBOX_CONFIRMATION"))),BA.numberCast(double.class, main._fx.getField(false,"DialogResponse").getField(true,"POSITIVE")))) { 
 BA.debugLineNum = 37;BA.debugLine="Return True";
Debug.ShouldStop(16);
if (true) return main.__c.getField(true,"True");
 };
 BA.debugLineNum = 39;BA.debugLine="Return False";
Debug.ShouldStop(64);
if (true) return main.__c.getField(true,"False");
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buildtree_b4x(RemoteObject _element,RemoteObject _code,RemoteObject _parentname,RemoteObject _getfrommap,RemoteObject _buildlist,RemoteObject _indent) throws Exception{
try {
		Debug.PushSubsStack("BuildTree_b4x (main) ","main",0,main.ba,main.mostCurrent,96);
if (RapidSub.canDelegate("buildtree_b4x")) return main.remoteMe.runUserSub(false, "main","buildtree_b4x", _element, _code, _parentname, _getfrommap, _buildlist, _indent);
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _k = RemoteObject.createImmutable("");
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _index = RemoteObject.createImmutable(0);
RemoteObject _e = RemoteObject.declareNull("Object");
RemoteObject _stubcode = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _objecttype = RemoteObject.createImmutable("");
Debug.locals.put("element", _element);
Debug.locals.put("code", _code);
Debug.locals.put("parentName", _parentname);
Debug.locals.put("GetFromMap", _getfrommap);
Debug.locals.put("BuildList", _buildlist);
Debug.locals.put("indent", _indent);
 BA.debugLineNum = 96;BA.debugLine="Sub BuildTree_b4x(element As Object,code As String";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 98;BA.debugLine="code.Append(indent)";
Debug.ShouldStop(2);
_code.runVoidMethod ("Append",(Object)(_indent));
 BA.debugLineNum = 99;BA.debugLine="If element Is Map Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("i",_element, RemoteObject.createImmutable("anywheresoftware.b4a.objects.collections.Map.MyMap"))) { 
 BA.debugLineNum = 100;BA.debugLine="indent = WriteCodeHelper_b4x(\"Map\", code, parent";
Debug.ShouldStop(8);
_indent = _writecodehelper_b4x(BA.ObjectToString("Map"),_code,_parentname,_getfrommap,_buildlist,_indent);Debug.locals.put("indent", _indent);
 BA.debugLineNum = 101;BA.debugLine="Dim m As Map = element";
Debug.ShouldStop(16);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_m.setObject(_element);Debug.locals.put("m", _m);
 BA.debugLineNum = 102;BA.debugLine="For Each k As String In m.Keys";
Debug.ShouldStop(32);
final RemoteObject group5 = _m.runMethod(false,"Keys");
final int groupLen5 = group5.runMethod(true,"getSize").<Integer>get();
for (int index5 = 0;index5 < groupLen5 ;index5++){
_k = BA.ObjectToString(group5.runMethod(false,"Get",index5));Debug.locals.put("k", _k);
Debug.locals.put("k", _k);
 BA.debugLineNum = 105;BA.debugLine="BuildTree_b4x(m.Get(k),  code, k, parentName &";
Debug.ShouldStop(256);
_buildtree_b4x(_m.runMethod(false,"Get",(Object)((_k))),_code,_k,RemoteObject.concat(_parentname,RemoteObject.createImmutable(".Get(\""),_k,RemoteObject.createImmutable("\")")),main.__c.getField(true,"False"),_indent);
 }
Debug.locals.put("k", _k);
;
 }else 
{ BA.debugLineNum = 107;BA.debugLine="Else If element Is List Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("i",_element, RemoteObject.createImmutable("java.util.List"))) { 
 BA.debugLineNum = 108;BA.debugLine="indent = WriteCodeHelper_b4x(\"List\", code, paren";
Debug.ShouldStop(2048);
_indent = _writecodehelper_b4x(BA.ObjectToString("List"),_code,_parentname,_getfrommap,_buildlist,_indent);Debug.locals.put("indent", _indent);
 BA.debugLineNum = 109;BA.debugLine="Dim l As List = element";
Debug.ShouldStop(4096);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_l.setObject(_element);Debug.locals.put("l", _l);
 BA.debugLineNum = 110;BA.debugLine="Dim index As Int = 0";
Debug.ShouldStop(8192);
_index = BA.numberCast(int.class, 0);Debug.locals.put("index", _index);Debug.locals.put("index", _index);
 BA.debugLineNum = 111;BA.debugLine="For Each e As Object In l";
Debug.ShouldStop(16384);
final RemoteObject group12 = _l;
final int groupLen12 = group12.runMethod(true,"getSize").<Integer>get();
for (int index12 = 0;index12 < groupLen12 ;index12++){
_e = group12.runMethod(false,"Get",index12);Debug.locals.put("e", _e);
Debug.locals.put("e", _e);
 BA.debugLineNum = 114;BA.debugLine="Dim stubCode As StringBuilder";
Debug.ShouldStop(131072);
_stubcode = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("stubCode", _stubcode);
 BA.debugLineNum = 116;BA.debugLine="If index = 0 Then stubCode = code Else stubCode";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_index,BA.numberCast(double.class, 0))) { 
_stubcode = _code;Debug.locals.put("stubCode", _stubcode);}
else {
_stubcode.runVoidMethod ("Initialize");};
 BA.debugLineNum = 117;BA.debugLine="BuildTree_b4x(e,  stubCode, \"col\" & parentName";
Debug.ShouldStop(1048576);
_buildtree_b4x(_e,_stubcode,RemoteObject.concat(RemoteObject.createImmutable("col"),_parentname),BA.ObjectToString(""),BA.ObjectToBoolean(RemoteObject.solveBoolean("=",_index,BA.numberCast(double.class, 0))),_indent);
 BA.debugLineNum = 118;BA.debugLine="index = index + 1";
Debug.ShouldStop(2097152);
_index = RemoteObject.solve(new RemoteObject[] {_index,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("index", _index);
 }
Debug.locals.put("e", _e);
;
 }else {
 BA.debugLineNum = 121;BA.debugLine="Dim objectType As String";
Debug.ShouldStop(16777216);
_objecttype = RemoteObject.createImmutable("");Debug.locals.put("objectType", _objecttype);
 BA.debugLineNum = 122;BA.debugLine="If element Is Int Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("i",_element, RemoteObject.createImmutable("Integer"))) { 
 BA.debugLineNum = 123;BA.debugLine="objectType = \"Int\"";
Debug.ShouldStop(67108864);
_objecttype = BA.ObjectToString("Int");Debug.locals.put("objectType", _objecttype);
 }else 
{ BA.debugLineNum = 124;BA.debugLine="Else If element Is Double Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("i",_element, RemoteObject.createImmutable("Double"))) { 
 BA.debugLineNum = 125;BA.debugLine="objectType = \"Double\"";
Debug.ShouldStop(268435456);
_objecttype = BA.ObjectToString("Double");Debug.locals.put("objectType", _objecttype);
 }else {
 BA.debugLineNum = 127;BA.debugLine="objectType = \"String\"";
Debug.ShouldStop(1073741824);
_objecttype = BA.ObjectToString("String");Debug.locals.put("objectType", _objecttype);
 }};
 BA.debugLineNum = 129;BA.debugLine="indent = WriteCodeHelper_b4x(objectType, code, p";
Debug.ShouldStop(1);
_indent = _writecodehelper_b4x(_objecttype,_code,_parentname,_getfrommap,_buildlist,_indent);Debug.locals.put("indent", _indent);
 }};
 BA.debugLineNum = 132;BA.debugLine="If BuildList Then";
Debug.ShouldStop(8);
if (_buildlist.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 134;BA.debugLine="code.Append(indent.SubString(sIndent.Length)).Ap";
Debug.ShouldStop(32);
_code.runMethod(false,"Append",(Object)(_indent.runMethod(true,"substring",(Object)(main._sindent.runMethod(true,"length"))))).runMethod(false,"Append",(Object)(RemoteObject.createImmutable("Next"))).runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),main.__c.getField(true,"CRLF"))));
 };
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _disablescrollbar(RemoteObject _ta,RemoteObject _showvertical,RemoteObject _showhorizontal) throws Exception{
try {
		Debug.PushSubsStack("DisableScrollBar (main) ","main",0,main.ba,main.mostCurrent,48);
if (RapidSub.canDelegate("disablescrollbar")) return main.remoteMe.runUserSub(false, "main","disablescrollbar", _ta, _showvertical, _showhorizontal);
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _scrollbarver = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _scrollbarhor = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _d_d = RemoteObject.createImmutable(0);
RemoteObject _d_e = RemoteObject.createImmutable(0);
Debug.locals.put("ta", _ta);
Debug.locals.put("showvertical", _showvertical);
Debug.locals.put("showhorizontal", _showhorizontal);
 BA.debugLineNum = 48;BA.debugLine="Sub DisableScrollBar(ta As TextArea,showvertical A";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="Dim jo As JavaObject = ta";
Debug.ShouldStop(65536);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(_ta.getObject());Debug.locals.put("jo", _jo);
 BA.debugLineNum = 50;BA.debugLine="Dim scrollbarver As JavaObject = jo.RunMethod(\"lo";
Debug.ShouldStop(131072);
_scrollbarver = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_scrollbarver.setObject(_jo.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("lookup")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable(".scroll-bar:vertical"))}))));Debug.locals.put("scrollbarver", _scrollbarver);
 BA.debugLineNum = 51;BA.debugLine="Dim scrollbarhor As JavaObject = jo.RunMethod(\"lo";
Debug.ShouldStop(262144);
_scrollbarhor = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_scrollbarhor.setObject(_jo.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("lookup")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable(".scroll-bar:horizontal"))}))));Debug.locals.put("scrollbarhor", _scrollbarhor);
 BA.debugLineNum = 52;BA.debugLine="Dim d_d As Double = 1,d_e As Double=0";
Debug.ShouldStop(524288);
_d_d = BA.numberCast(double.class, 1);Debug.locals.put("d_d", _d_d);Debug.locals.put("d_d", _d_d);
_d_e = BA.numberCast(double.class, 0);Debug.locals.put("d_e", _d_e);Debug.locals.put("d_e", _d_e);
 BA.debugLineNum = 53;BA.debugLine="If showvertical Then";
Debug.ShouldStop(1048576);
if (_showvertical.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 54;BA.debugLine="scrollbarver.RunMethod(\"setOpacity\", Array(d_";
Debug.ShouldStop(2097152);
_scrollbarver.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setOpacity")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_d_e)})));
 }else {
 BA.debugLineNum = 56;BA.debugLine="scrollbarver.RunMethod(\"setOpacity\", Array(d_d))";
Debug.ShouldStop(8388608);
_scrollbarver.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setOpacity")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_d_d)})));
 };
 BA.debugLineNum = 58;BA.debugLine="If showhorizontal Then";
Debug.ShouldStop(33554432);
if (_showhorizontal.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 59;BA.debugLine="scrollbarhor.RunMethod(\"setOpacity\", Array(d_e))";
Debug.ShouldStop(67108864);
_scrollbarhor.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setOpacity")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_d_e)})));
 }else {
 BA.debugLineNum = 61;BA.debugLine="scrollbarhor.RunMethod(\"setOpacity\", Array(d_d))";
Debug.ShouldStop(268435456);
_scrollbarhor.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setOpacity")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_d_d)})));
 };
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _exit_action() throws Exception{
try {
		Debug.PushSubsStack("exit_Action (main) ","main",0,main.ba,main.mostCurrent,32);
if (RapidSub.canDelegate("exit_action")) return main.remoteMe.runUserSub(false, "main","exit_action");
 BA.debugLineNum = 32;BA.debugLine="Sub exit_Action";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="If askexit Then ExitApplication";
Debug.ShouldStop(1);
if (_askexit().<Boolean>get().booleanValue()) { 
main.__c.runVoidMethod ("ExitApplication");};
 BA.debugLineNum = 34;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mainform_closerequest(RemoteObject _eventdata) throws Exception{
try {
		Debug.PushSubsStack("MainForm_CloseRequest (main) ","main",0,main.ba,main.mostCurrent,41);
if (RapidSub.canDelegate("mainform_closerequest")) return main.remoteMe.runUserSub(false, "main","mainform_closerequest", _eventdata);
Debug.locals.put("EventData", _eventdata);
 BA.debugLineNum = 41;BA.debugLine="Sub MainForm_CloseRequest (EventData As Event)";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="If askexit=False Then EventData.Consume";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_askexit(),main.__c.getField(true,"False"))) { 
_eventdata.runVoidMethod ("Consume");};
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _parsetob4x(RemoteObject _str) throws Exception{
try {
		Debug.PushSubsStack("parsetob4x (main) ","main",0,main.ba,main.mostCurrent,66);
if (RapidSub.canDelegate("parsetob4x")) return main.remoteMe.runUserSub(false, "main","parsetob4x", _str);
RemoteObject _text = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4j.objects.collections.JSONParser");
RemoteObject _squarebracketfound = RemoteObject.createImmutable(false);
int _i = 0;
RemoteObject _code = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
Debug.locals.put("str", _str);
 BA.debugLineNum = 66;BA.debugLine="Sub parsetob4x(str As String) As String";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="Dim text As String = str";
Debug.ShouldStop(4);
_text = _str;Debug.locals.put("text", _text);Debug.locals.put("text", _text);
 BA.debugLineNum = 68;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(8);
_parser = RemoteObject.createNew ("anywheresoftware.b4j.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 69;BA.debugLine="parser.Initialize(text)";
Debug.ShouldStop(16);
_parser.runVoidMethod ("Initialize",(Object)(_text));
 BA.debugLineNum = 70;BA.debugLine="Dim squareBracketFound As Boolean";
Debug.ShouldStop(32);
_squarebracketfound = RemoteObject.createImmutable(false);Debug.locals.put("squareBracketFound", _squarebracketfound);
 BA.debugLineNum = 72;BA.debugLine="For i = 0 To text.Length";
Debug.ShouldStop(128);
{
final int step5 = 1;
final int limit5 = _text.runMethod(true,"length").<Integer>get().intValue();
for (_i = 0 ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 73;BA.debugLine="If text.CharAt(i) = \"[\" Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _i))),BA.ObjectToChar("["))) { 
 BA.debugLineNum = 74;BA.debugLine="squareBracketFound = True";
Debug.ShouldStop(512);
_squarebracketfound = main.__c.getField(true,"True");Debug.locals.put("squareBracketFound", _squarebracketfound);
 BA.debugLineNum = 75;BA.debugLine="Exit";
Debug.ShouldStop(1024);
if (true) break;
 }else 
{ BA.debugLineNum = 76;BA.debugLine="Else If text.CharAt(i) = \"{\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_text.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, _i))),BA.ObjectToChar("{"))) { 
 BA.debugLineNum = 77;BA.debugLine="Exit";
Debug.ShouldStop(4096);
if (true) break;
 }};
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 80;BA.debugLine="Dim code As StringBuilder";
Debug.ShouldStop(32768);
_code = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("code", _code);
 BA.debugLineNum = 81;BA.debugLine="code.Initialize";
Debug.ShouldStop(65536);
_code.runVoidMethod ("Initialize");
 BA.debugLineNum = 82;BA.debugLine="code.Append(\"Dim parser As JSONParser\").Append(\"";
Debug.ShouldStop(131072);
_code.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("Dim parser As JSONParser"))).runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),main.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 83;BA.debugLine="code.Append(\"parser.Initialize(str)\").Append(\" \"";
Debug.ShouldStop(262144);
_code.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("parser.Initialize(str)"))).runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),main.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 84;BA.debugLine="code.Append(\"Dim root As \")";
Debug.ShouldStop(524288);
_code.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("Dim root As ")));
 BA.debugLineNum = 86;BA.debugLine="If squareBracketFound Then";
Debug.ShouldStop(2097152);
if (_squarebracketfound.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 87;BA.debugLine="code.Append(\"List = parser.NextArray\").Append(\"";
Debug.ShouldStop(4194304);
_code.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("List = parser.NextArray"))).runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),main.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 88;BA.debugLine="BuildTree_b4x(parser.NextArray, code, \"root\", \"";
Debug.ShouldStop(8388608);
_buildtree_b4x((_parser.runMethod(false,"NextArray").getObject()),_code,BA.ObjectToString("root"),BA.ObjectToString(""),main.__c.getField(true,"False"),RemoteObject.createImmutable(""));
 }else {
 BA.debugLineNum = 90;BA.debugLine="code.Append(\"Map = parser.NextObject\").Append(\"";
Debug.ShouldStop(33554432);
_code.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("Map = parser.NextObject"))).runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),main.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 91;BA.debugLine="BuildTree_b4x(parser.NextObject,  code, \"root\",";
Debug.ShouldStop(67108864);
_buildtree_b4x((_parser.runMethod(false,"NextObject").getObject()),_code,BA.ObjectToString("root"),BA.ObjectToString(""),main.__c.getField(true,"False"),RemoteObject.createImmutable(""));
 };
 BA.debugLineNum = 93;BA.debugLine="Return code.ToString";
Debug.ShouldStop(268435456);
if (true) return _code.runMethod(true,"ToString");
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4j.example.main");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private fx As JFX";
main._fx = RemoteObject.createNew ("anywheresoftware.b4j.objects.JFX");
 //BA.debugLineNum = 8;BA.debugLine="Private MainForm As Form";
main._mainform = RemoteObject.createNew ("anywheresoftware.b4j.objects.Form");
 //BA.debugLineNum = 9;BA.debugLine="Private edtJson As TextArea";
main._edtjson = RemoteObject.createNew ("anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper");
 //BA.debugLineNum = 10;BA.debugLine="Private edtcode As TextArea";
main._edtcode = RemoteObject.createNew ("anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper");
 //BA.debugLineNum = 11;BA.debugLine="Private sIndent As String=\"    \"";
main._sindent = BA.ObjectToString("    ");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _reset_action() throws Exception{
try {
		Debug.PushSubsStack("reset_Action (main) ","main",0,main.ba,main.mostCurrent,44);
if (RapidSub.canDelegate("reset_action")) return main.remoteMe.runUserSub(false, "main","reset_action");
 BA.debugLineNum = 44;BA.debugLine="Sub reset_Action";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="edtJson.Text=\"\"";
Debug.ShouldStop(4096);
main._edtjson.runMethod(true,"setText",BA.ObjectToString(""));
 BA.debugLineNum = 46;BA.debugLine="edtcode.Text=\"\"";
Debug.ShouldStop(8192);
main._edtcode.runMethod(true,"setText",BA.ObjectToString(""));
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tob4x_action() throws Exception{
try {
		Debug.PushSubsStack("tob4x_Action (main) ","main",0,main.ba,main.mostCurrent,21);
if (RapidSub.canDelegate("tob4x_action")) return main.remoteMe.runUserSub(false, "main","tob4x_action");
 BA.debugLineNum = 21;BA.debugLine="Sub tob4x_Action";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 22;BA.debugLine="Log(\"tob4x\")";
Debug.ShouldStop(2097152);
main.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("tob4x")));
 BA.debugLineNum = 23;BA.debugLine="If edtJson.Text.Length<1 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("<",main._edtjson.runMethod(true,"getText").runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 24;BA.debugLine="fx.Msgbox(MainForm,\"JSON string is empty\",\"Empty";
Debug.ShouldStop(8388608);
main._fx.runVoidMethodAndSync ("Msgbox",(Object)(main._mainform),(Object)(BA.ObjectToString("JSON string is empty")),(Object)(RemoteObject.createImmutable("Empty")));
 }else {
 BA.debugLineNum = 26;BA.debugLine="edtcode.Text= parsetob4x(edtJson.Text)";
Debug.ShouldStop(33554432);
main._edtcode.runMethod(true,"setText",_parsetob4x(main._edtjson.runMethod(true,"getText")));
 };
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tojava_action() throws Exception{
try {
		Debug.PushSubsStack("tojava_Action (main) ","main",0,main.ba,main.mostCurrent,29);
if (RapidSub.canDelegate("tojava_action")) return main.remoteMe.runUserSub(false, "main","tojava_action");
 BA.debugLineNum = 29;BA.debugLine="Sub tojava_Action";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="Log(\"tojava\")";
Debug.ShouldStop(536870912);
main.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("tojava")));
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _writecodehelper_b4x(RemoteObject _objecttype,RemoteObject _code,RemoteObject _parentname,RemoteObject _getfrommap,RemoteObject _buildlist,RemoteObject _indent) throws Exception{
try {
		Debug.PushSubsStack("WriteCodeHelper_b4x (main) ","main",0,main.ba,main.mostCurrent,137);
if (RapidSub.canDelegate("writecodehelper_b4x")) return main.remoteMe.runUserSub(false, "main","writecodehelper_b4x", _objecttype, _code, _parentname, _getfrommap, _buildlist, _indent);
Debug.locals.put("ObjectType", _objecttype);
Debug.locals.put("code", _code);
Debug.locals.put("parentName", _parentname);
Debug.locals.put("GetFromMap", _getfrommap);
Debug.locals.put("BuildList", _buildlist);
Debug.locals.put("indent", _indent);
 BA.debugLineNum = 137;BA.debugLine="Sub WriteCodeHelper_b4x (ObjectType As String, cod";
Debug.ShouldStop(256);
 BA.debugLineNum = 139;BA.debugLine="If GetFromMap.Length > 0 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean(">",_getfrommap.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 140;BA.debugLine="Select ObjectType.ToLowerCase";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(_objecttype.runMethod(true,"toLowerCase"),BA.ObjectToString("int"),BA.ObjectToString("double"),BA.ObjectToString("string"))) {
case 0: {
 BA.debugLineNum = 142;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
Debug.ShouldStop(8192);
_code.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Dim "),_parentname,RemoteObject.createImmutable(" As "),_objecttype,RemoteObject.createImmutable(" = "),_getfrommap.runMethod(true,"replace",(Object)(BA.ObjectToString("Get")),(Object)(RemoteObject.createImmutable("GetDefault"))).runMethod(true,"replace",(Object)(BA.ObjectToString(")")),(Object)(RemoteObject.createImmutable(",0)")))))).runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),main.__c.getField(true,"CRLF"))));
 break; }
case 1: {
 BA.debugLineNum = 144;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
Debug.ShouldStop(32768);
_code.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Dim "),_parentname,RemoteObject.createImmutable(" As "),_objecttype,RemoteObject.createImmutable(" = "),_getfrommap.runMethod(true,"replace",(Object)(BA.ObjectToString("Get")),(Object)(RemoteObject.createImmutable("GetDefault"))).runMethod(true,"replace",(Object)(BA.ObjectToString(")")),(Object)(RemoteObject.createImmutable(",0)")))))).runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),main.__c.getField(true,"CRLF"))));
 break; }
case 2: {
 BA.debugLineNum = 146;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
Debug.ShouldStop(131072);
_code.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Dim "),_parentname,RemoteObject.createImmutable(" As "),_objecttype,RemoteObject.createImmutable(" = "),_getfrommap.runMethod(true,"replace",(Object)(BA.ObjectToString("Get")),(Object)(RemoteObject.createImmutable("GetDefault"))).runMethod(true,"replace",(Object)(BA.ObjectToString(")")),(Object)(RemoteObject.createImmutable(",\"\")")))))).runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),main.__c.getField(true,"CRLF"))));
 break; }
default: {
 BA.debugLineNum = 149;BA.debugLine="code.Append(\"Dim \" & parentName & \" As \" & Obje";
Debug.ShouldStop(1048576);
_code.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Dim "),_parentname,RemoteObject.createImmutable(" As "),_objecttype,RemoteObject.createImmutable(" = "),_getfrommap,RemoteObject.createImmutable(" "),main.__c.getField(true,"CRLF"))));
 break; }
}
;
 }else 
{ BA.debugLineNum = 151;BA.debugLine="Else If BuildList Then";
Debug.ShouldStop(4194304);
if (_buildlist.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 152;BA.debugLine="code.Append(\"For Each \" & parentName & \" As \" &";
Debug.ShouldStop(8388608);
_code.runMethod(false,"Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("For Each "),_parentname,RemoteObject.createImmutable(" As "),_objecttype,RemoteObject.createImmutable(" In "),_parentname.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 3)))))).runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" "),main.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 153;BA.debugLine="indent = indent & sIndent";
Debug.ShouldStop(16777216);
_indent = RemoteObject.concat(_indent,main._sindent);Debug.locals.put("indent", _indent);
 }};
 BA.debugLineNum = 155;BA.debugLine="Return indent";
Debug.ShouldStop(67108864);
if (true) return _indent;
 BA.debugLineNum = 156;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}