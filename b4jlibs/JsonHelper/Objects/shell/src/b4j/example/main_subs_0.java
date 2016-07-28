package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _appstart(RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("AppStart (main) ","main",0,main.ba,main.mostCurrent,15);
if (RapidSub.canDelegate("appstart")) return main.remoteMe.runUserSub(false, "main","appstart", _args);
Debug.locals.put("Args", _args);
 BA.debugLineNum = 15;BA.debugLine="Sub AppStart (Args() As String)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 18;BA.debugLine="parseJS($\"[{\"hm\":\"91303\",\"qh\":\"160722011\"},{\"hm\":";
Debug.ShouldStop(131072);
_parsejs((RemoteObject.createImmutable("[{\"hm\":\"91303\",\"qh\":\"160722011\"},{\"hm\":\"53406\",\"qh\":\"160722010\"},{\"hm\":\"77068\",\"qh\":\"160722009\"},{\"hm\":\"90171\",\"qh\":\"160722008\"},{\"hm\":\"61654\",\"qh\":\"160722007\"},{\"hm\":\"62801\",\"qh\":\"160722006\"},{\"hm\":\"59684\",\"qh\":\"160722005\"},{\"hm\":\"54893\",\"qh\":\"160722004\"},{\"hm\":\"31088\",\"qh\":\"160722003\"},{\"hm\":\"89318\",\"qh\":\"160722002\"},{\"hm\":\"70477\",\"qh\":\"160722001\"},{\"hm\":\"88706\",\"qh\":\"160721120\"},{\"hm\":\"86000\",\"qh\":\"160721119\"},{\"hm\":\"79789\",\"qh\":\"160721118\"},{\"hm\":\"69259\",\"qh\":\"160721117\"},{\"hm\":\"96768\",\"qh\":\"160721116\"},{\"hm\":\"99474\",\"qh\":\"160721115\"},{\"hm\":\"46306\",\"qh\":\"160721114\"},{\"hm\":\"93003\",\"qh\":\"160721113\"},{\"hm\":\"59815\",\"qh\":\"160721112\"},{\"hm\":\"57466\",\"qh\":\"160721111\"},{\"hm\":\"72474\",\"qh\":\"160721110\"},{\"hm\":\"48415\",\"qh\":\"160721109\"},{\"hm\":\"53427\",\"qh\":\"160721108\"},{\"hm\":\"96927\",\"qh\":\"160721107\"},{\"hm\":\"47812\",\"qh\":\"160721106\"},{\"hm\":\"19450\",\"qh\":\"160721105\"},{\"hm\":\"13996\",\"qh\":\"160721104\"},{\"hm\":\"76800\",\"qh\":\"160721103\"},{\"hm\":\"70838\",\"qh\":\"160721102\"},{\"hm\":\"34749\",\"qh\":\"160721101\"},{\"hm\":\"31098\",\"qh\":\"160721100\"},{\"hm\":\"37343\",\"qh\":\"160721099\"},{\"hm\":\"44242\",\"qh\":\"160721098\"},{\"hm\":\"33339\",\"qh\":\"160721097\"},{\"hm\":\"46211\",\"qh\":\"160721096\"},{\"hm\":\"04961\",\"qh\":\"160721095\"},{\"hm\":\"58449\",\"qh\":\"160721094\"},{\"hm\":\"09489\",\"qh\":\"160721093\"},{\"hm\":\"45038\",\"qh\":\"160721092\"},{\"hm\":\"56327\",\"qh\":\"160721091\"},{\"hm\":\"75340\",\"qh\":\"160721090\"},{\"hm\":\"38417\",\"qh\":\"160721089\"},{\"hm\":\"25467\",\"qh\":\"160721088\"},{\"hm\":\"29947\",\"qh\":\"160721087\"},{\"hm\":\"52782\",\"qh\":\"160721086\"},{\"hm\":\"76322\",\"qh\":\"160721085\"},{\"hm\":\"15484\",\"qh\":\"160721084\"},{\"hm\":\"47466\",\"qh\":\"160721083\"},{\"hm\":\"51710\",\"qh\":\"160721082\"}]")));
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getjotype(RemoteObject _obj) throws Exception{
try {
		Debug.PushSubsStack("getJOType (main) ","main",0,main.ba,main.mostCurrent,123);
if (RapidSub.canDelegate("getjotype")) return main.remoteMe.runUserSub(false, "main","getjotype", _obj);
RemoteObject _ret = RemoteObject.createImmutable("");
Debug.locals.put("obj", _obj);
 BA.debugLineNum = 123;BA.debugLine="Sub getJOType(obj As Object) As String";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 124;BA.debugLine="Dim ret As String";
Debug.ShouldStop(134217728);
_ret = RemoteObject.createImmutable("");Debug.locals.put("ret", _ret);
 BA.debugLineNum = 125;BA.debugLine="If obj Is Int Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("i",_obj, RemoteObject.createImmutable("Integer"))) { 
 BA.debugLineNum = 126;BA.debugLine="ret=\"Int\"";
Debug.ShouldStop(536870912);
_ret = BA.ObjectToString("Int");Debug.locals.put("ret", _ret);
 }else 
{ BA.debugLineNum = 127;BA.debugLine="else if obj Is Double Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("i",_obj, RemoteObject.createImmutable("Double"))) { 
 BA.debugLineNum = 128;BA.debugLine="ret=\"Double\"";
Debug.ShouldStop(-2147483648);
_ret = BA.ObjectToString("Double");Debug.locals.put("ret", _ret);
 }else 
{ BA.debugLineNum = 129;BA.debugLine="Else if obj Is Map Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("i",_obj, RemoteObject.createImmutable("anywheresoftware.b4a.objects.collections.Map.MyMap"))) { 
 BA.debugLineNum = 130;BA.debugLine="ret=\"Map\"";
Debug.ShouldStop(2);
_ret = BA.ObjectToString("Map");Debug.locals.put("ret", _ret);
 }else 
{ BA.debugLineNum = 131;BA.debugLine="Else if obj Is String Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("i",_obj, RemoteObject.createImmutable("String"))) { 
 BA.debugLineNum = 132;BA.debugLine="ret=\"String\"";
Debug.ShouldStop(8);
_ret = BA.ObjectToString("String");Debug.locals.put("ret", _ret);
 }else {
 BA.debugLineNum = 134;BA.debugLine="ret=\"Object\"";
Debug.ShouldStop(32);
_ret = BA.ObjectToString("Object");Debug.locals.put("ret", _ret);
 }}}};
 BA.debugLineNum = 136;BA.debugLine="Return ret";
Debug.ShouldStop(128);
if (true) return _ret;
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _gettabs(RemoteObject _n) throws Exception{
try {
		Debug.PushSubsStack("getTABS (main) ","main",0,main.ba,main.mostCurrent,114);
if (RapidSub.canDelegate("gettabs")) return main.remoteMe.runUserSub(false, "main","gettabs", _n);
RemoteObject _ret = RemoteObject.createImmutable("");
int _i = 0;
Debug.locals.put("n", _n);
 BA.debugLineNum = 114;BA.debugLine="Sub getTABS(n As Int) As String";
Debug.ShouldStop(131072);
 BA.debugLineNum = 115;BA.debugLine="Dim ret As String=\"\"";
Debug.ShouldStop(262144);
_ret = BA.ObjectToString("");Debug.locals.put("ret", _ret);Debug.locals.put("ret", _ret);
 BA.debugLineNum = 116;BA.debugLine="If n>0 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean(">",_n,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 117;BA.debugLine="For i=0 To n";
Debug.ShouldStop(1048576);
{
final int step3 = 1;
final int limit3 = _n.<Integer>get().intValue();
for (_i = 0 ; (step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3); _i = ((int)(0 + _i + step3)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 118;BA.debugLine="ret=ret&\"    \"";
Debug.ShouldStop(2097152);
_ret = RemoteObject.concat(_ret,RemoteObject.createImmutable("    "));Debug.locals.put("ret", _ret);
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 121;BA.debugLine="Return ret";
Debug.ShouldStop(16777216);
if (true) return _ret;
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _parsejs(RemoteObject _jsonstr) throws Exception{
try {
		Debug.PushSubsStack("parseJS (main) ","main",0,main.ba,main.mostCurrent,46);
if (RapidSub.canDelegate("parsejs")) return main.remoteMe.runUserSub(false, "main","parsejs", _jsonstr);
RemoteObject _jsp = RemoteObject.declareNull("anywheresoftware.b4j.objects.collections.JSONParser");
RemoteObject _islst = RemoteObject.createImmutable(false);
RemoteObject _ismap = RemoteObject.createImmutable(false);
RemoteObject _obj = RemoteObject.declareNull("Object");
Debug.locals.put("jsonstr", _jsonstr);
 BA.debugLineNum = 46;BA.debugLine="Sub parseJS(jsonstr As String)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="If jsonstr.Length<1 Then Return";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("<",_jsonstr.runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 48;BA.debugLine="nFloor=1";
Debug.ShouldStop(32768);
main._nfloor = BA.numberCast(int.class, 1);
 BA.debugLineNum = 49;BA.debugLine="flg=0";
Debug.ShouldStop(65536);
main._flg = BA.numberCast(int.class, 0);
 BA.debugLineNum = 50;BA.debugLine="sbCLS.Initialize";
Debug.ShouldStop(131072);
main._sbcls.runVoidMethod ("Initialize");
 BA.debugLineNum = 51;BA.debugLine="sb_code.Initialize";
Debug.ShouldStop(262144);
main._sb_code.runVoidMethod ("Initialize");
 BA.debugLineNum = 52;BA.debugLine="Dim jsp As JSONParser";
Debug.ShouldStop(524288);
_jsp = RemoteObject.createNew ("anywheresoftware.b4j.objects.collections.JSONParser");Debug.locals.put("jsp", _jsp);
 BA.debugLineNum = 53;BA.debugLine="Dim isLst As Boolean=False,isMap As Boolean=False";
Debug.ShouldStop(1048576);
_islst = main.__c.getField(true,"False");Debug.locals.put("isLst", _islst);Debug.locals.put("isLst", _islst);
_ismap = main.__c.getField(true,"False");Debug.locals.put("isMap", _ismap);Debug.locals.put("isMap", _ismap);
 BA.debugLineNum = 54;BA.debugLine="If jsonstr.CharAt(0)=\"[\" Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_jsonstr.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, 0))),BA.ObjectToChar("["))) { 
 BA.debugLineNum = 55;BA.debugLine="isLst=True";
Debug.ShouldStop(4194304);
_islst = main.__c.getField(true,"True");Debug.locals.put("isLst", _islst);
 }else 
{ BA.debugLineNum = 56;BA.debugLine="Else if jsonstr.CharAt(0)=\"{\" Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_jsonstr.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, 0))),BA.ObjectToChar("{"))) { 
 BA.debugLineNum = 57;BA.debugLine="isMap=True";
Debug.ShouldStop(16777216);
_ismap = main.__c.getField(true,"True");Debug.locals.put("isMap", _ismap);
 }};
 BA.debugLineNum = 59;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"Dim jsp As JSONPa";
Debug.ShouldStop(67108864);
main._sb_code.runVoidMethod ("Append",(Object)(RemoteObject.concat(_gettabs(main._nfloor),RemoteObject.createImmutable("Dim jsp As JSONParser"),main.__c.getField(true,"CRLF"),_gettabs(main._nfloor),RemoteObject.createImmutable("jsp.Initialize(str)"),main.__c.getField(true,"CRLF"),_gettabs(main._nfloor),RemoteObject.createImmutable("Dim root As "))));
 BA.debugLineNum = 60;BA.debugLine="Try";
Debug.ShouldStop(134217728);
try { BA.debugLineNum = 61;BA.debugLine="jsp.Initialize(jsonstr)";
Debug.ShouldStop(268435456);
_jsp.runVoidMethod ("Initialize",(Object)(_jsonstr));
 BA.debugLineNum = 62;BA.debugLine="If isLst Then";
Debug.ShouldStop(536870912);
if (_islst.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 63;BA.debugLine="sb_code.Append(\"List = jsp.NextArray\"&CRLF)";
Debug.ShouldStop(1073741824);
main._sb_code.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("List = jsp.NextArray"),main.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 64;BA.debugLine="For Each obj As Object In jsp.NextArray";
Debug.ShouldStop(-2147483648);
final RemoteObject group18 = _jsp.runMethod(false,"NextArray");
final int groupLen18 = group18.runMethod(true,"getSize").<Integer>get();
for (int index18 = 0;index18 < groupLen18 ;index18++){
_obj = group18.runMethod(false,"Get",index18);Debug.locals.put("obj", _obj);
Debug.locals.put("obj", _obj);
 BA.debugLineNum = 65;BA.debugLine="parseJSO(obj,obj)";
Debug.ShouldStop(1);
_parsejso(_obj,_obj);
 }
Debug.locals.put("obj", _obj);
;
 BA.debugLineNum = 67;BA.debugLine="parseJSO(jsp.NextArray,\"root\")";
Debug.ShouldStop(4);
_parsejso((_jsp.runMethod(false,"NextArray").getObject()),(RemoteObject.createImmutable("root")));
 }else {
 BA.debugLineNum = 69;BA.debugLine="sb_code.Append(\"Map = jsp.NextObject\"&CRLF)";
Debug.ShouldStop(16);
main._sb_code.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Map = jsp.NextObject"),main.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 70;BA.debugLine="parseJSO(jsp.NextObject,\"root\")";
Debug.ShouldStop(32);
_parsejso((_jsp.runMethod(false,"NextObject").getObject()),(RemoteObject.createImmutable("root")));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e27) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.ba, e27.toString()); BA.debugLineNum = 73;BA.debugLine="Log(LastException)";
Debug.ShouldStop(256);
main.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(main.__c.runMethod(false,"LastException",main.ba))));
 };
 BA.debugLineNum = 75;BA.debugLine="Log(\"----------\"&CRLF&sb_code.ToString&CRLF&\"----";
Debug.ShouldStop(1024);
main.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("----------"),main.__c.getField(true,"CRLF"),main._sb_code.runMethod(true,"ToString"),main.__c.getField(true,"CRLF"),RemoteObject.createImmutable("------------"))));
 BA.debugLineNum = 76;BA.debugLine="Log(\"----------\"&CRLF&sbCLS.ToString&CRLF&\"------";
Debug.ShouldStop(2048);
main.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("----------"),main.__c.getField(true,"CRLF"),main._sbcls.runMethod(true,"ToString"),main.__c.getField(true,"CRLF"),RemoteObject.createImmutable("------------"))));
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _parsejso(RemoteObject _obj,RemoteObject _parent) throws Exception{
try {
		Debug.PushSubsStack("parseJSO (main) ","main",0,main.ba,main.mostCurrent,78);
if (RapidSub.canDelegate("parsejso")) return main.remoteMe.runUserSub(false, "main","parsejso", _obj, _parent);
RemoteObject _lst = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _tobj2 = RemoteObject.declareNull("Object");
RemoteObject _k = RemoteObject.createImmutable("");
Debug.locals.put("obj", _obj);
Debug.locals.put("parent", _parent);
 BA.debugLineNum = 78;BA.debugLine="Sub parseJSO(obj As Object,parent As Object)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 80;BA.debugLine="If obj Is List Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("i",_obj, RemoteObject.createImmutable("java.util.List"))) { 
 BA.debugLineNum = 81;BA.debugLine="Dim lst As List=obj";
Debug.ShouldStop(65536);
_lst = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_lst.setObject(_obj);Debug.locals.put("lst", _lst);
 BA.debugLineNum = 82;BA.debugLine="If lst.Size>0 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean(">",_lst.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 83;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"For Each col\"&p";
Debug.ShouldStop(262144);
main._sb_code.runVoidMethod ("Append",(Object)(RemoteObject.concat(_gettabs(main._nfloor),RemoteObject.createImmutable("For Each col"),_parent,RemoteObject.createImmutable(" As "),_getjotype(_lst.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))),RemoteObject.createImmutable(" in "),_parent,main.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 84;BA.debugLine="nFloor=nFloor+1";
Debug.ShouldStop(524288);
main._nfloor = RemoteObject.solve(new RemoteObject[] {main._nfloor,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 85;BA.debugLine="parseJSO(lst.Get(0),\"col\"&parent)";
Debug.ShouldStop(1048576);
_parsejso(_lst.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),(RemoteObject.concat(RemoteObject.createImmutable("col"),_parent)));
 BA.debugLineNum = 86;BA.debugLine="nFloor=nFloor-1";
Debug.ShouldStop(2097152);
main._nfloor = RemoteObject.solve(new RemoteObject[] {main._nfloor,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 87;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"Next\"&CRLF)";
Debug.ShouldStop(4194304);
main._sb_code.runVoidMethod ("Append",(Object)(RemoteObject.concat(_gettabs(main._nfloor),RemoteObject.createImmutable("Next"),main.__c.getField(true,"CRLF"))));
 }else {
 BA.debugLineNum = 89;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"'Empty List\"&CR";
Debug.ShouldStop(16777216);
main._sb_code.runVoidMethod ("Append",(Object)(RemoteObject.concat(_gettabs(main._nfloor),RemoteObject.createImmutable("'Empty List"),main.__c.getField(true,"CRLF"))));
 };
 }else 
{ BA.debugLineNum = 91;BA.debugLine="else if obj Is Map Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("i",_obj, RemoteObject.createImmutable("anywheresoftware.b4a.objects.collections.Map.MyMap"))) { 
 BA.debugLineNum = 92;BA.debugLine="flg=flg+1";
Debug.ShouldStop(134217728);
main._flg = RemoteObject.solve(new RemoteObject[] {main._flg,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 94;BA.debugLine="Dim m As Map=obj";
Debug.ShouldStop(536870912);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_m.setObject(_obj);Debug.locals.put("m", _m);
 BA.debugLineNum = 95;BA.debugLine="Dim tobj2 As Object";
Debug.ShouldStop(1073741824);
_tobj2 = RemoteObject.createNew ("Object");Debug.locals.put("tobj2", _tobj2);
 BA.debugLineNum = 96;BA.debugLine="sbCLS.Append(getTABS(nFloor)&\"Type typ\"&parent&\"";
Debug.ShouldStop(-2147483648);
main._sbcls.runVoidMethod ("Append",(Object)(RemoteObject.concat(_gettabs(main._nfloor),RemoteObject.createImmutable("Type typ"),_parent,RemoteObject.createImmutable("("))));
 BA.debugLineNum = 97;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"Dim myItem As ty";
Debug.ShouldStop(1);
main._sb_code.runVoidMethod ("Append",(Object)(RemoteObject.concat(_gettabs(main._nfloor),RemoteObject.createImmutable("Dim myItem As typ"),_parent,main.__c.getField(true,"CRLF"),_gettabs(main._nfloor),RemoteObject.createImmutable("myItem.Initialize"),main.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 98;BA.debugLine="For Each k As String In m.Keys";
Debug.ShouldStop(2);
final RemoteObject group18 = _m.runMethod(false,"Keys");
final int groupLen18 = group18.runMethod(true,"getSize").<Integer>get();
for (int index18 = 0;index18 < groupLen18 ;index18++){
_k = BA.ObjectToString(group18.runMethod(false,"Get",index18));Debug.locals.put("k", _k);
Debug.locals.put("k", _k);
 BA.debugLineNum = 99;BA.debugLine="tobj2=m.Get(k)";
Debug.ShouldStop(4);
_tobj2 = _m.runMethod(false,"Get",(Object)((_k)));Debug.locals.put("tobj2", _tobj2);
 BA.debugLineNum = 100;BA.debugLine="sbCLS.Append(parent&\"_\"&k&\" as \"&getJOType(tobj";
Debug.ShouldStop(8);
main._sbcls.runVoidMethod ("Append",(Object)(RemoteObject.concat(_parent,RemoteObject.createImmutable("_"),_k,RemoteObject.createImmutable(" as "),_getjotype(_tobj2),RemoteObject.createImmutable(","))));
 BA.debugLineNum = 101;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"myItem.\"&parent";
Debug.ShouldStop(16);
main._sb_code.runVoidMethod ("Append",(Object)(RemoteObject.concat(_gettabs(main._nfloor),RemoteObject.createImmutable("myItem."),_parent,RemoteObject.createImmutable("_"),_k,RemoteObject.createImmutable(" = "),_parent,RemoteObject.createImmutable(".Get(\""),_k,RemoteObject.createImmutable("\")"),main.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 103;BA.debugLine="parseJSO(tobj2,parent&\"_\"&k)";
Debug.ShouldStop(64);
_parsejso(_tobj2,(RemoteObject.concat(_parent,RemoteObject.createImmutable("_"),_k)));
 }
Debug.locals.put("k", _k);
;
 BA.debugLineNum = 106;BA.debugLine="sbCLS.Remove(sbCLS.Length-1,sbCLS.Length)";
Debug.ShouldStop(512);
main._sbcls.runVoidMethod ("Remove",(Object)(RemoteObject.solve(new RemoteObject[] {main._sbcls.runMethod(true,"getLength"),RemoteObject.createImmutable(1)}, "-",1, 1)),(Object)(main._sbcls.runMethod(true,"getLength")));
 BA.debugLineNum = 107;BA.debugLine="sbCLS.Append(\")\"&CRLF)";
Debug.ShouldStop(1024);
main._sbcls.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(")"),main.__c.getField(true,"CRLF"))));
 BA.debugLineNum = 108;BA.debugLine="flg=flg-1";
Debug.ShouldStop(2048);
main._flg = RemoteObject.solve(new RemoteObject[] {main._flg,RemoteObject.createImmutable(1)}, "-",1, 1);
 }};
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Dim sb_code As StringBuilder,sbCLS As StringBuild";
main._sb_code = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");
main._sbcls = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");
 //BA.debugLineNum = 9;BA.debugLine="Dim flg As Int,nFloor As Int";
main._flg = RemoteObject.createImmutable(0);
main._nfloor = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 10;BA.debugLine="Dim sTAB As String=\"    \"";
main._stab = BA.ObjectToString("    ");
 //BA.debugLineNum = 11;BA.debugLine="Type typroot(root_code As String,root_data As Map";
;
 //BA.debugLineNum = 12;BA.debugLine="Type typroot_data(root_data_id As Int,root_data_to";
;
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _test() throws Exception{
try {
		Debug.PushSubsStack("test (main) ","main",0,main.ba,main.mostCurrent,26);
if (RapidSub.canDelegate("test")) return main.remoteMe.runUserSub(false, "main","test");
 BA.debugLineNum = 26;BA.debugLine="Sub test";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
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