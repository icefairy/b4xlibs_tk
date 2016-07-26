package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class main extends Object{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.ShellBA("b4j.example", "b4j.example.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			anywheresoftware.b4a.ShellBA.delegateBA = new anywheresoftware.b4a.StandardBA("b4j.example", null, null);
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


private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static class _typcolroot{
public boolean IsInitialized;
public String colroot_hm;
public String colroot_qh;
public void Initialize() {
IsInitialized = true;
colroot_hm = "";
colroot_qh = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.Timer _tmr = null;
public static anywheresoftware.b4a.keywords.StringBuilderWrapper _sb_code = null;
public static anywheresoftware.b4a.keywords.StringBuilderWrapper _sbcls = null;
public static int _flg = 0;
public static int _nfloor = 0;
public static String _stab = "";
public static String  _appstart(String[] _args) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "appstart"))
	return (String) Debug.delegate(ba, "appstart", new Object[] {_args});
RDebugUtils.currentLine=65536;
 //BA.debugLineNum = 65536;BA.debugLine="Sub AppStart (Args() As String)";
RDebugUtils.currentLine=65539;
 //BA.debugLineNum = 65539;BA.debugLine="parseJS($\"[{\"hm\":\"91303\",\"qh\":\"160722011\"},{\"hm\":";
_parsejs(("[{\"hm\":\"91303\",\"qh\":\"160722011\"},{\"hm\":\"53406\",\"qh\":\"160722010\"},{\"hm\":\"77068\",\"qh\":\"160722009\"},{\"hm\":\"90171\",\"qh\":\"160722008\"},{\"hm\":\"61654\",\"qh\":\"160722007\"},{\"hm\":\"62801\",\"qh\":\"160722006\"},{\"hm\":\"59684\",\"qh\":\"160722005\"},{\"hm\":\"54893\",\"qh\":\"160722004\"},{\"hm\":\"31088\",\"qh\":\"160722003\"},{\"hm\":\"89318\",\"qh\":\"160722002\"},{\"hm\":\"70477\",\"qh\":\"160722001\"},{\"hm\":\"88706\",\"qh\":\"160721120\"},{\"hm\":\"86000\",\"qh\":\"160721119\"},{\"hm\":\"79789\",\"qh\":\"160721118\"},{\"hm\":\"69259\",\"qh\":\"160721117\"},{\"hm\":\"96768\",\"qh\":\"160721116\"},{\"hm\":\"99474\",\"qh\":\"160721115\"},{\"hm\":\"46306\",\"qh\":\"160721114\"},{\"hm\":\"93003\",\"qh\":\"160721113\"},{\"hm\":\"59815\",\"qh\":\"160721112\"},{\"hm\":\"57466\",\"qh\":\"160721111\"},{\"hm\":\"72474\",\"qh\":\"160721110\"},{\"hm\":\"48415\",\"qh\":\"160721109\"},{\"hm\":\"53427\",\"qh\":\"160721108\"},{\"hm\":\"96927\",\"qh\":\"160721107\"},{\"hm\":\"47812\",\"qh\":\"160721106\"},{\"hm\":\"19450\",\"qh\":\"160721105\"},{\"hm\":\"13996\",\"qh\":\"160721104\"},{\"hm\":\"76800\",\"qh\":\"160721103\"},{\"hm\":\"70838\",\"qh\":\"160721102\"},{\"hm\":\"34749\",\"qh\":\"160721101\"},{\"hm\":\"31098\",\"qh\":\"160721100\"},{\"hm\":\"37343\",\"qh\":\"160721099\"},{\"hm\":\"44242\",\"qh\":\"160721098\"},{\"hm\":\"33339\",\"qh\":\"160721097\"},{\"hm\":\"46211\",\"qh\":\"160721096\"},{\"hm\":\"04961\",\"qh\":\"160721095\"},{\"hm\":\"58449\",\"qh\":\"160721094\"},{\"hm\":\"09489\",\"qh\":\"160721093\"},{\"hm\":\"45038\",\"qh\":\"160721092\"},{\"hm\":\"56327\",\"qh\":\"160721091\"},{\"hm\":\"75340\",\"qh\":\"160721090\"},{\"hm\":\"38417\",\"qh\":\"160721089\"},{\"hm\":\"25467\",\"qh\":\"160721088\"},{\"hm\":\"29947\",\"qh\":\"160721087\"},{\"hm\":\"52782\",\"qh\":\"160721086\"},{\"hm\":\"76322\",\"qh\":\"160721085\"},{\"hm\":\"15484\",\"qh\":\"160721084\"},{\"hm\":\"47466\",\"qh\":\"160721083\"},{\"hm\":\"51710\",\"qh\":\"160721082\"}]"));
RDebugUtils.currentLine=65545;
 //BA.debugLineNum = 65545;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
RDebugUtils.currentLine=65546;
 //BA.debugLineNum = 65546;BA.debugLine="End Sub";
return "";
}
public static String  _parsejs(String _jsonstr) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "parsejs"))
	return (String) Debug.delegate(ba, "parsejs", new Object[] {_jsonstr});
anywheresoftware.b4j.objects.collections.JSONParser _jsp = null;
boolean _islst = false;
boolean _ismap = false;
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub parseJS(jsonstr As String)";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="If jsonstr.Length<1 Then Return";
if (_jsonstr.length()<1) { 
if (true) return "";};
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="nFloor=1";
_nfloor = (int) (1);
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="flg=0";
_flg = (int) (0);
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="sbCLS.Initialize";
_sbcls.Initialize();
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="sb_code.Initialize";
_sb_code.Initialize();
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="Dim jsp As JSONParser";
_jsp = new anywheresoftware.b4j.objects.collections.JSONParser();
RDebugUtils.currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="Dim isLst As Boolean=False,isMap As Boolean=False";
_islst = anywheresoftware.b4a.keywords.Common.False;
_ismap = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=196616;
 //BA.debugLineNum = 196616;BA.debugLine="If jsonstr.CharAt(0)=\"[\" Then";
if (_jsonstr.charAt((int) (0))==BA.ObjectToChar("[")) { 
RDebugUtils.currentLine=196617;
 //BA.debugLineNum = 196617;BA.debugLine="isLst=True";
_islst = anywheresoftware.b4a.keywords.Common.True;
 }else 
{RDebugUtils.currentLine=196618;
 //BA.debugLineNum = 196618;BA.debugLine="Else if jsonstr.CharAt(0)=\"{\" Then";
if (_jsonstr.charAt((int) (0))==BA.ObjectToChar("{")) { 
RDebugUtils.currentLine=196619;
 //BA.debugLineNum = 196619;BA.debugLine="isMap=True";
_ismap = anywheresoftware.b4a.keywords.Common.True;
 }};
RDebugUtils.currentLine=196621;
 //BA.debugLineNum = 196621;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"Dim jsp As JSONPa";
_sb_code.Append(_gettabs(_nfloor)+"Dim jsp As JSONParser"+anywheresoftware.b4a.keywords.Common.CRLF+_gettabs(_nfloor)+"jsp.Initialize(str)"+anywheresoftware.b4a.keywords.Common.CRLF+_gettabs(_nfloor)+"Dim root As ");
RDebugUtils.currentLine=196622;
 //BA.debugLineNum = 196622;BA.debugLine="Try";
try {RDebugUtils.currentLine=196623;
 //BA.debugLineNum = 196623;BA.debugLine="jsp.Initialize(jsonstr)";
_jsp.Initialize(_jsonstr);
RDebugUtils.currentLine=196624;
 //BA.debugLineNum = 196624;BA.debugLine="If isLst Then";
if (_islst) { 
RDebugUtils.currentLine=196625;
 //BA.debugLineNum = 196625;BA.debugLine="sb_code.Append(\"List = jsp.NextArray\"&CRLF)";
_sb_code.Append("List = jsp.NextArray"+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=196626;
 //BA.debugLineNum = 196626;BA.debugLine="parseJSO(jsp.NextArray,\"root\")";
_parsejso((Object)(_jsp.NextArray().getObject()),(Object)("root"));
 }else {
RDebugUtils.currentLine=196628;
 //BA.debugLineNum = 196628;BA.debugLine="sb_code.Append(\"Map = jsp.NextObject\"&CRLF)";
_sb_code.Append("Map = jsp.NextObject"+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=196629;
 //BA.debugLineNum = 196629;BA.debugLine="parseJSO(jsp.NextObject,\"root\")";
_parsejso((Object)(_jsp.NextObject().getObject()),(Object)("root"));
 };
 } 
       catch (Exception e24) {
			ba.setLastException(e24);RDebugUtils.currentLine=196632;
 //BA.debugLineNum = 196632;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 };
RDebugUtils.currentLine=196634;
 //BA.debugLineNum = 196634;BA.debugLine="tmr_Tick";
_tmr_tick();
RDebugUtils.currentLine=196635;
 //BA.debugLineNum = 196635;BA.debugLine="End Sub";
return "";
}
public static String  _getjotype(Object _obj) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "getjotype"))
	return (String) Debug.delegate(ba, "getjotype", new Object[] {_obj});
String _ret = "";
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub getJOType(obj As Object) As String";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Dim ret As String";
_ret = "";
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="If obj Is Int Then";
if (_obj instanceof Integer) { 
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="ret=\"Int\"";
_ret = "Int";
 }else 
{RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="else if obj Is Double Then";
if (_obj instanceof Double) { 
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="ret=\"Double\"";
_ret = "Double";
 }else 
{RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="Else if obj Is Map Then";
if (_obj instanceof anywheresoftware.b4a.objects.collections.Map.MyMap) { 
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="ret=\"Map\"";
_ret = "Map";
 }else 
{RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="Else if obj Is String Then";
if (_obj instanceof String) { 
RDebugUtils.currentLine=393225;
 //BA.debugLineNum = 393225;BA.debugLine="ret=\"String\"";
_ret = "String";
 }else {
RDebugUtils.currentLine=393227;
 //BA.debugLineNum = 393227;BA.debugLine="ret=\"Object\"";
_ret = "Object";
 }}}};
RDebugUtils.currentLine=393229;
 //BA.debugLineNum = 393229;BA.debugLine="Return ret";
if (true) return _ret;
RDebugUtils.currentLine=393230;
 //BA.debugLineNum = 393230;BA.debugLine="End Sub";
return "";
}
public static String  _gettabs(int _n) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "gettabs"))
	return (String) Debug.delegate(ba, "gettabs", new Object[] {_n});
String _ret = "";
int _i = 0;
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub getTABS(n As Int) As String";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Dim ret As String=\"\"";
_ret = "";
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="If n>0 Then";
if (_n>0) { 
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="For i=0 To n";
{
final int step3 = 1;
final int limit3 = _n;
for (_i = (int) (0) ; (step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3); _i = ((int)(0 + _i + step3)) ) {
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="ret=ret&\"    \"";
_ret = _ret+"    ";
 }
};
 };
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="Return ret";
if (true) return _ret;
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="End Sub";
return "";
}
public static String  _parsejso(Object _obj,Object _parent) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "parsejso"))
	return (String) Debug.delegate(ba, "parsejso", new Object[] {_obj,_parent});
anywheresoftware.b4a.objects.collections.List _lst = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
Object _tobj2 = null;
String _k = "";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub parseJSO(obj As Object,parent As Object)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="If obj Is List Then";
if (_obj instanceof java.util.List) { 
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Dim lst As List=obj";
_lst = new anywheresoftware.b4a.objects.collections.List();
_lst.setObject((java.util.List)(_obj));
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="If lst.Size>0 Then";
if (_lst.getSize()>0) { 
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"For Each col\"&p";
_sb_code.Append(_gettabs(_nfloor)+"For Each col"+BA.ObjectToString(_parent)+" As "+_getjotype(_lst.Get((int) (0)))+" in "+BA.ObjectToString(_parent)+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="nFloor=nFloor+1";
_nfloor = (int) (_nfloor+1);
RDebugUtils.currentLine=262151;
 //BA.debugLineNum = 262151;BA.debugLine="parseJSO(lst.Get(0),\"col\"&parent)";
_parsejso(_lst.Get((int) (0)),(Object)("col"+BA.ObjectToString(_parent)));
RDebugUtils.currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="nFloor=nFloor-1";
_nfloor = (int) (_nfloor-1);
RDebugUtils.currentLine=262153;
 //BA.debugLineNum = 262153;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"Next\"&CRLF)";
_sb_code.Append(_gettabs(_nfloor)+"Next"+anywheresoftware.b4a.keywords.Common.CRLF);
 }else {
RDebugUtils.currentLine=262155;
 //BA.debugLineNum = 262155;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"'Empty List\"&CR";
_sb_code.Append(_gettabs(_nfloor)+"'Empty List"+anywheresoftware.b4a.keywords.Common.CRLF);
 };
 }else 
{RDebugUtils.currentLine=262157;
 //BA.debugLineNum = 262157;BA.debugLine="else if obj Is Map Then";
if (_obj instanceof anywheresoftware.b4a.objects.collections.Map.MyMap) { 
RDebugUtils.currentLine=262158;
 //BA.debugLineNum = 262158;BA.debugLine="flg=flg+1";
_flg = (int) (_flg+1);
RDebugUtils.currentLine=262160;
 //BA.debugLineNum = 262160;BA.debugLine="Dim m As Map=obj";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_obj));
RDebugUtils.currentLine=262161;
 //BA.debugLineNum = 262161;BA.debugLine="Dim tobj2 As Object";
_tobj2 = new Object();
RDebugUtils.currentLine=262162;
 //BA.debugLineNum = 262162;BA.debugLine="sbCLS.Append(getTABS(nFloor)&\"Type typ\"&parent&\"";
_sbcls.Append(_gettabs(_nfloor)+"Type typ"+BA.ObjectToString(_parent)+"(");
RDebugUtils.currentLine=262163;
 //BA.debugLineNum = 262163;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"Dim myItem As ty";
_sb_code.Append(_gettabs(_nfloor)+"Dim myItem As typ"+BA.ObjectToString(_parent)+anywheresoftware.b4a.keywords.Common.CRLF+_gettabs(_nfloor)+"myItem.Initialize"+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=262164;
 //BA.debugLineNum = 262164;BA.debugLine="For Each k As String In m.Keys";
final anywheresoftware.b4a.BA.IterableList group18 = _m.Keys();
final int groupLen18 = group18.getSize();
for (int index18 = 0;index18 < groupLen18 ;index18++){
_k = BA.ObjectToString(group18.Get(index18));
RDebugUtils.currentLine=262165;
 //BA.debugLineNum = 262165;BA.debugLine="tobj2=m.Get(k)";
_tobj2 = _m.Get((Object)(_k));
RDebugUtils.currentLine=262166;
 //BA.debugLineNum = 262166;BA.debugLine="sbCLS.Append(parent&\"_\"&k&\" as \"&getJOType(tobj";
_sbcls.Append(BA.ObjectToString(_parent)+"_"+_k+" as "+_getjotype(_tobj2)+",");
RDebugUtils.currentLine=262167;
 //BA.debugLineNum = 262167;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"myItem.\"&parent";
_sb_code.Append(_gettabs(_nfloor)+"myItem."+BA.ObjectToString(_parent)+"_"+_k+" = "+BA.ObjectToString(_parent)+".Get(\""+_k+"\")"+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=262169;
 //BA.debugLineNum = 262169;BA.debugLine="parseJSO(tobj2,parent&\"_\"&k)";
_parsejso(_tobj2,(Object)(BA.ObjectToString(_parent)+"_"+_k));
 }
;
RDebugUtils.currentLine=262172;
 //BA.debugLineNum = 262172;BA.debugLine="sbCLS.Remove(sbCLS.Length-1,sbCLS.Length)";
_sbcls.Remove((int) (_sbcls.getLength()-1),_sbcls.getLength());
RDebugUtils.currentLine=262173;
 //BA.debugLineNum = 262173;BA.debugLine="sbCLS.Append(\")\"&CRLF)";
_sbcls.Append(")"+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=262174;
 //BA.debugLineNum = 262174;BA.debugLine="flg=flg-1";
_flg = (int) (_flg-1);
RDebugUtils.currentLine=262176;
 //BA.debugLineNum = 262176;BA.debugLine="If flg=0 Then";
if (_flg==0) { 
RDebugUtils.currentLine=262177;
 //BA.debugLineNum = 262177;BA.debugLine="tmr.Initialize(\"tmr\",100)";
_tmr.Initialize(ba,"tmr",(long) (100));
RDebugUtils.currentLine=262178;
 //BA.debugLineNum = 262178;BA.debugLine="tmr.Enabled=True";
_tmr.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 };
 }};
RDebugUtils.currentLine=262184;
 //BA.debugLineNum = 262184;BA.debugLine="End Sub";
return "";
}
public static String  _tmr_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "tmr_tick"))
	return (String) Debug.delegate(ba, "tmr_tick", null);
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub tmr_Tick";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Log(\"----------\"&CRLF&sb_code.ToString&CRLF&\"----";
anywheresoftware.b4a.keywords.Common.Log("----------"+anywheresoftware.b4a.keywords.Common.CRLF+_sb_code.ToString()+anywheresoftware.b4a.keywords.Common.CRLF+"------------");
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Log(\"----------\"&CRLF&sbCLS.ToString&CRLF&\"------";
anywheresoftware.b4a.keywords.Common.Log("----------"+anywheresoftware.b4a.keywords.Common.CRLF+_sbcls.ToString()+anywheresoftware.b4a.keywords.Common.CRLF+"------------");
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="End Sub";
return "";
}
public static String  _test() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "test"))
	return (String) Debug.delegate(ba, "test", null);
anywheresoftware.b4j.objects.collections.JSONParser _jsp = null;
anywheresoftware.b4a.objects.collections.List _root = null;
anywheresoftware.b4a.objects.collections.Map _colroot = null;
b4j.example.main._typcolroot _myitem = null;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub test";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Dim jsp As JSONParser";
_jsp = new anywheresoftware.b4j.objects.collections.JSONParser();
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="jsp.Initialize(\"\")";
_jsp.Initialize("");
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="Dim root As List = jsp.NextArray";
_root = new anywheresoftware.b4a.objects.collections.List();
_root = _jsp.NextArray();
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="For Each colroot As Map In root";
_colroot = new anywheresoftware.b4a.objects.collections.Map();
final anywheresoftware.b4a.BA.IterableList group4 = _root;
final int groupLen4 = group4.getSize();
for (int index4 = 0;index4 < groupLen4 ;index4++){
_colroot.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group4.Get(index4)));
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="Dim myItem As typcolroot";
_myitem = new b4j.example.main._typcolroot();
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="myItem.Initialize";
_myitem.Initialize();
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="myItem.colroot_hm = colroot.Get(\"hm\")";
_myitem.colroot_hm = BA.ObjectToString(_colroot.Get((Object)("hm")));
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="myItem.colroot_qh = colroot.Get(\"qh\")";
_myitem.colroot_qh = BA.ObjectToString(_colroot.Get((Object)("qh")));
 }
;
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="End Sub";
return "";
}
}