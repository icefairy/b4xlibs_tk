package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class main extends Object{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) throws Exception{
        try {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program started.");
            initializeProcessGlobals();
            ba.raiseEvent(null, "appstart", (Object)args);
        } catch (Throwable t) {
			BA.printException(t, true);
		
        } finally {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program terminated (StartMessageLoop was not called).");
        }
    }
public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.Timer _tmr = null;
public static anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
public static int _flg = 0;
public static int _nfloor = 0;
public static String _stab = "";
public static String  _appstart(String[] _args) throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub AppStart (Args() As String)";
 //BA.debugLineNum = 17;BA.debugLine="parseJS($\"[{\"hm\":\"91303\",\"qh\":\"160722011\"},{\"hm\":";
_parsejs(("[{\"hm\":\"91303\",\"qh\":\"160722011\"},{\"hm\":\"53406\",\"qh\":\"160722010\"},{\"hm\":\"77068\",\"qh\":\"160722009\"},{\"hm\":\"90171\",\"qh\":\"160722008\"},{\"hm\":\"61654\",\"qh\":\"160722007\"},{\"hm\":\"62801\",\"qh\":\"160722006\"},{\"hm\":\"59684\",\"qh\":\"160722005\"},{\"hm\":\"54893\",\"qh\":\"160722004\"},{\"hm\":\"31088\",\"qh\":\"160722003\"},{\"hm\":\"89318\",\"qh\":\"160722002\"},{\"hm\":\"70477\",\"qh\":\"160722001\"},{\"hm\":\"88706\",\"qh\":\"160721120\"},{\"hm\":\"86000\",\"qh\":\"160721119\"},{\"hm\":\"79789\",\"qh\":\"160721118\"},{\"hm\":\"69259\",\"qh\":\"160721117\"},{\"hm\":\"96768\",\"qh\":\"160721116\"},{\"hm\":\"99474\",\"qh\":\"160721115\"},{\"hm\":\"46306\",\"qh\":\"160721114\"},{\"hm\":\"93003\",\"qh\":\"160721113\"},{\"hm\":\"59815\",\"qh\":\"160721112\"},{\"hm\":\"57466\",\"qh\":\"160721111\"},{\"hm\":\"72474\",\"qh\":\"160721110\"},{\"hm\":\"48415\",\"qh\":\"160721109\"},{\"hm\":\"53427\",\"qh\":\"160721108\"},{\"hm\":\"96927\",\"qh\":\"160721107\"},{\"hm\":\"47812\",\"qh\":\"160721106\"},{\"hm\":\"19450\",\"qh\":\"160721105\"},{\"hm\":\"13996\",\"qh\":\"160721104\"},{\"hm\":\"76800\",\"qh\":\"160721103\"},{\"hm\":\"70838\",\"qh\":\"160721102\"},{\"hm\":\"34749\",\"qh\":\"160721101\"},{\"hm\":\"31098\",\"qh\":\"160721100\"},{\"hm\":\"37343\",\"qh\":\"160721099\"},{\"hm\":\"44242\",\"qh\":\"160721098\"},{\"hm\":\"33339\",\"qh\":\"160721097\"},{\"hm\":\"46211\",\"qh\":\"160721096\"},{\"hm\":\"04961\",\"qh\":\"160721095\"},{\"hm\":\"58449\",\"qh\":\"160721094\"},{\"hm\":\"09489\",\"qh\":\"160721093\"},{\"hm\":\"45038\",\"qh\":\"160721092\"},{\"hm\":\"56327\",\"qh\":\"160721091\"},{\"hm\":\"75340\",\"qh\":\"160721090\"},{\"hm\":\"38417\",\"qh\":\"160721089\"},{\"hm\":\"25467\",\"qh\":\"160721088\"},{\"hm\":\"29947\",\"qh\":\"160721087\"},{\"hm\":\"52782\",\"qh\":\"160721086\"},{\"hm\":\"76322\",\"qh\":\"160721085\"},{\"hm\":\"15484\",\"qh\":\"160721084\"},{\"hm\":\"47466\",\"qh\":\"160721083\"},{\"hm\":\"51710\",\"qh\":\"160721082\"}]"));
 //BA.debugLineNum = 18;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _getjotype(Object _obj) throws Exception{
String _ret = "";
 //BA.debugLineNum = 96;BA.debugLine="Sub getJOType(obj As Object) As String";
 //BA.debugLineNum = 97;BA.debugLine="Dim ret As String";
_ret = "";
 //BA.debugLineNum = 98;BA.debugLine="If obj Is Int Then";
if (_obj instanceof Integer) { 
 //BA.debugLineNum = 99;BA.debugLine="ret=\"Int\"";
_ret = "Int";
 }else if(_obj instanceof Double) { 
 //BA.debugLineNum = 101;BA.debugLine="ret=\"Double\"";
_ret = "Double";
 }else if(_obj instanceof anywheresoftware.b4a.objects.collections.Map.MyMap) { 
 //BA.debugLineNum = 103;BA.debugLine="ret=\"Map\"";
_ret = "Map";
 }else if(_obj instanceof String) { 
 //BA.debugLineNum = 105;BA.debugLine="ret=\"String\"";
_ret = "String";
 }else {
 //BA.debugLineNum = 107;BA.debugLine="ret=\"Object\"";
_ret = "Object";
 };
 //BA.debugLineNum = 109;BA.debugLine="Return ret";
if (true) return _ret;
 //BA.debugLineNum = 110;BA.debugLine="End Sub";
return "";
}
public static String  _gettabs(int _n) throws Exception{
String _ret = "";
int _i = 0;
 //BA.debugLineNum = 87;BA.debugLine="Sub getTABS(n As Int) As String";
 //BA.debugLineNum = 88;BA.debugLine="Dim ret As String=\"\"";
_ret = "";
 //BA.debugLineNum = 89;BA.debugLine="If n>0 Then";
if (_n>0) { 
 //BA.debugLineNum = 90;BA.debugLine="For i=0 To n";
{
final int step3 = 1;
final int limit3 = _n;
for (_i = (int) (0) ; (step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3); _i = ((int)(0 + _i + step3)) ) {
 //BA.debugLineNum = 91;BA.debugLine="ret=ret&\"    \"";
_ret = _ret+"    ";
 }
};
 };
 //BA.debugLineNum = 94;BA.debugLine="Return ret";
if (true) return _ret;
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public static String  _parsejs(String _jsonstr) throws Exception{
anywheresoftware.b4j.objects.collections.JSONParser _jsp = null;
boolean _islst = false;
boolean _ismap = false;
 //BA.debugLineNum = 26;BA.debugLine="Sub parseJS(jsonstr As String)";
 //BA.debugLineNum = 27;BA.debugLine="If jsonstr.Length<1 Then Return";
if (_jsonstr.length()<1) { 
if (true) return "";};
 //BA.debugLineNum = 28;BA.debugLine="nFloor=1";
_nfloor = (int) (1);
 //BA.debugLineNum = 29;BA.debugLine="flg=0";
_flg = (int) (0);
 //BA.debugLineNum = 30;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 31;BA.debugLine="Dim jsp As JSONParser";
_jsp = new anywheresoftware.b4j.objects.collections.JSONParser();
 //BA.debugLineNum = 32;BA.debugLine="Dim isLst As Boolean=False,isMap As Boolean=False";
_islst = anywheresoftware.b4a.keywords.Common.False;
_ismap = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 33;BA.debugLine="If jsonstr.CharAt(0)=\"[\" Then";
if (_jsonstr.charAt((int) (0))==BA.ObjectToChar("[")) { 
 //BA.debugLineNum = 34;BA.debugLine="isLst=True";
_islst = anywheresoftware.b4a.keywords.Common.True;
 }else if(_jsonstr.charAt((int) (0))==BA.ObjectToChar("{")) { 
 //BA.debugLineNum = 36;BA.debugLine="isMap=True";
_ismap = anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 38;BA.debugLine="sb.Append(getTABS(nFloor)&\"Dim jsp As JSONParser\"";
_sb.Append(_gettabs(_nfloor)+"Dim jsp As JSONParser"+anywheresoftware.b4a.keywords.Common.CRLF+_gettabs(_nfloor)+"jsp.Initialize(str)"+anywheresoftware.b4a.keywords.Common.CRLF+_gettabs(_nfloor)+"Dim root As ");
 //BA.debugLineNum = 39;BA.debugLine="Try";
try { //BA.debugLineNum = 40;BA.debugLine="jsp.Initialize(jsonstr)";
_jsp.Initialize(_jsonstr);
 //BA.debugLineNum = 41;BA.debugLine="If isLst Then";
if (_islst) { 
 //BA.debugLineNum = 42;BA.debugLine="sb.Append(\"List = jsp.NextArray\"&CRLF)";
_sb.Append("List = jsp.NextArray"+anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 43;BA.debugLine="parseJSO(jsp.NextArray,\"root\")";
_parsejso((Object)(_jsp.NextArray().getObject()),(Object)("root"));
 }else {
 //BA.debugLineNum = 45;BA.debugLine="sb.Append(\"Map = jsp.NextObject\"&CRLF)";
_sb.Append("Map = jsp.NextObject"+anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 46;BA.debugLine="parseJSO(jsp.NextObject,\"root\")";
_parsejso((Object)(_jsp.NextObject().getObject()),(Object)("root"));
 };
 } 
       catch (Exception e23) {
			ba.setLastException(e23); //BA.debugLineNum = 49;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 };
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public static String  _parsejso(Object _obj,Object _parent) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
Object _tobj2 = null;
String _k = "";
 //BA.debugLineNum = 53;BA.debugLine="Sub parseJSO(obj As Object,parent As Object)";
 //BA.debugLineNum = 55;BA.debugLine="If obj Is List Then";
if (_obj instanceof java.util.List) { 
 //BA.debugLineNum = 56;BA.debugLine="Dim lst As List=obj";
_lst = new anywheresoftware.b4a.objects.collections.List();
_lst.setObject((java.util.List)(_obj));
 //BA.debugLineNum = 57;BA.debugLine="If lst.Size>0 Then";
if (_lst.getSize()>0) { 
 //BA.debugLineNum = 58;BA.debugLine="sb.Append(getTABS(nFloor)&\"For Each col\"&parent";
_sb.Append(_gettabs(_nfloor)+"For Each col"+BA.ObjectToString(_parent)+" As "+_getjotype(_lst.Get((int) (0)))+" in "+BA.ObjectToString(_parent)+anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 59;BA.debugLine="nFloor=nFloor+1";
_nfloor = (int) (_nfloor+1);
 //BA.debugLineNum = 60;BA.debugLine="parseJSO(lst.Get(0),\"col\"&parent)";
_parsejso(_lst.Get((int) (0)),(Object)("col"+BA.ObjectToString(_parent)));
 //BA.debugLineNum = 61;BA.debugLine="nFloor=nFloor-1";
_nfloor = (int) (_nfloor-1);
 //BA.debugLineNum = 62;BA.debugLine="sb.Append(getTABS(nFloor)&\"Next\"&CRLF)";
_sb.Append(_gettabs(_nfloor)+"Next"+anywheresoftware.b4a.keywords.Common.CRLF);
 }else {
 //BA.debugLineNum = 64;BA.debugLine="sb.Append(getTABS(nFloor)&\"'Empty List\"&CRLF)";
_sb.Append(_gettabs(_nfloor)+"'Empty List"+anywheresoftware.b4a.keywords.Common.CRLF);
 };
 }else if(_obj instanceof anywheresoftware.b4a.objects.collections.Map.MyMap) { 
 //BA.debugLineNum = 67;BA.debugLine="flg=flg+1";
_flg = (int) (_flg+1);
 //BA.debugLineNum = 69;BA.debugLine="Dim m As Map=obj";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_obj));
 //BA.debugLineNum = 70;BA.debugLine="Dim tobj2 As Object";
_tobj2 = new Object();
 //BA.debugLineNum = 71;BA.debugLine="For Each k As String In m.Keys";
final anywheresoftware.b4a.BA.IterableList group16 = _m.Keys();
final int groupLen16 = group16.getSize();
for (int index16 = 0;index16 < groupLen16 ;index16++){
_k = BA.ObjectToString(group16.Get(index16));
 //BA.debugLineNum = 72;BA.debugLine="tobj2=m.Get(k)";
_tobj2 = _m.Get((Object)(_k));
 //BA.debugLineNum = 73;BA.debugLine="sb.Append(getTABS(nFloor)&\"Dim \"&parent&\"_\"&k&\"";
_sb.Append(_gettabs(_nfloor)+"Dim "+BA.ObjectToString(_parent)+"_"+_k+" as "+_getjotype(_tobj2)+" = "+BA.ObjectToString(_parent)+".Get(\""+_k+"\")"+anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 74;BA.debugLine="CallSubDelayed3(Me,\"parseJSO\",tobj2,parent&\"_\"&";
anywheresoftware.b4a.keywords.Common.CallSubDelayed3(ba,main.getObject(),"parseJSO",_tobj2,(Object)(BA.ObjectToString(_parent)+"_"+_k));
 }
;
 //BA.debugLineNum = 76;BA.debugLine="flg=flg-1";
_flg = (int) (_flg-1);
 //BA.debugLineNum = 78;BA.debugLine="If flg=0 Then";
if (_flg==0) { 
 //BA.debugLineNum = 79;BA.debugLine="tmr.Initialize(\"tmr\",100)";
_tmr.Initialize(ba,"tmr",(long) (100));
 //BA.debugLineNum = 80;BA.debugLine="tmr.Enabled=True";
_tmr.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 };
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Dim tmr As Timer";
_tmr = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 9;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Dim flg As Int,nFloor As Int";
_flg = 0;
_nfloor = 0;
 //BA.debugLineNum = 11;BA.debugLine="Dim sTAB As String=\"    \"";
_stab = "    ";
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public static String  _tmr_tick() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub tmr_Tick";
 //BA.debugLineNum = 21;BA.debugLine="Log(\"----------\"&CRLF&sb.ToString&CRLF&\"---------";
anywheresoftware.b4a.keywords.Common.Log("----------"+anywheresoftware.b4a.keywords.Common.CRLF+_sb.ToString()+anywheresoftware.b4a.keywords.Common.CRLF+"------------");
 //BA.debugLineNum = 22;BA.debugLine="StopMessageLoop";
anywheresoftware.b4a.keywords.Common.StopMessageLoop(ba);
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
}
