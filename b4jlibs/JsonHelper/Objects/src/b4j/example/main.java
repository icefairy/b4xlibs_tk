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
}public static class _typroot{
public boolean IsInitialized;
public String root_code;
public anywheresoftware.b4a.objects.collections.Map root_data;
public String root_message;
public void Initialize() {
IsInitialized = true;
root_code = "";
root_data = new anywheresoftware.b4a.objects.collections.Map();
root_message = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _typroot_data{
public boolean IsInitialized;
public int root_data_id;
public String root_data_token;
public void Initialize() {
IsInitialized = true;
root_data_id = 0;
root_data_token = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static anywheresoftware.b4a.keywords.Common __c = null;
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
Object _obj = null;
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub parseJS(jsonstr As String)";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="If jsonstr.Length<1 Then Return";
if (_jsonstr.length()<1) { 
if (true) return "";};
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="nFloor=1";
_nfloor = (int) (1);
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="flg=0";
_flg = (int) (0);
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="sbCLS.Initialize";
_sbcls.Initialize();
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="sb_code.Initialize";
_sb_code.Initialize();
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="Dim jsp As JSONParser";
_jsp = new anywheresoftware.b4j.objects.collections.JSONParser();
RDebugUtils.currentLine=262151;
 //BA.debugLineNum = 262151;BA.debugLine="Dim isLst As Boolean=False,isMap As Boolean=False";
_islst = anywheresoftware.b4a.keywords.Common.False;
_ismap = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="If jsonstr.CharAt(0)=\"[\" Then";
if (_jsonstr.charAt((int) (0))==BA.ObjectToChar("[")) { 
RDebugUtils.currentLine=262153;
 //BA.debugLineNum = 262153;BA.debugLine="isLst=True";
_islst = anywheresoftware.b4a.keywords.Common.True;
 }else 
{RDebugUtils.currentLine=262154;
 //BA.debugLineNum = 262154;BA.debugLine="Else if jsonstr.CharAt(0)=\"{\" Then";
if (_jsonstr.charAt((int) (0))==BA.ObjectToChar("{")) { 
RDebugUtils.currentLine=262155;
 //BA.debugLineNum = 262155;BA.debugLine="isMap=True";
_ismap = anywheresoftware.b4a.keywords.Common.True;
 }};
RDebugUtils.currentLine=262157;
 //BA.debugLineNum = 262157;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"Dim jsp As JSONPa";
_sb_code.Append(_gettabs(_nfloor)+"Dim jsp As JSONParser"+anywheresoftware.b4a.keywords.Common.CRLF+_gettabs(_nfloor)+"jsp.Initialize(str)"+anywheresoftware.b4a.keywords.Common.CRLF+_gettabs(_nfloor)+"Dim root As ");
RDebugUtils.currentLine=262158;
 //BA.debugLineNum = 262158;BA.debugLine="Try";
try {RDebugUtils.currentLine=262159;
 //BA.debugLineNum = 262159;BA.debugLine="jsp.Initialize(jsonstr)";
_jsp.Initialize(_jsonstr);
RDebugUtils.currentLine=262160;
 //BA.debugLineNum = 262160;BA.debugLine="If isLst Then";
if (_islst) { 
RDebugUtils.currentLine=262161;
 //BA.debugLineNum = 262161;BA.debugLine="sb_code.Append(\"List = jsp.NextArray\"&CRLF)";
_sb_code.Append("List = jsp.NextArray"+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=262162;
 //BA.debugLineNum = 262162;BA.debugLine="For Each obj As Object In jsp.NextArray";
final anywheresoftware.b4a.BA.IterableList group18 = _jsp.NextArray();
final int groupLen18 = group18.getSize();
for (int index18 = 0;index18 < groupLen18 ;index18++){
_obj = group18.Get(index18);
RDebugUtils.currentLine=262163;
 //BA.debugLineNum = 262163;BA.debugLine="parseJSO(obj,obj)";
_parsejso(_obj,_obj);
 }
;
RDebugUtils.currentLine=262165;
 //BA.debugLineNum = 262165;BA.debugLine="parseJSO(jsp.NextArray,\"root\")";
_parsejso((Object)(_jsp.NextArray().getObject()),(Object)("root"));
 }else {
RDebugUtils.currentLine=262167;
 //BA.debugLineNum = 262167;BA.debugLine="sb_code.Append(\"Map = jsp.NextObject\"&CRLF)";
_sb_code.Append("Map = jsp.NextObject"+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=262168;
 //BA.debugLineNum = 262168;BA.debugLine="parseJSO(jsp.NextObject,\"root\")";
_parsejso((Object)(_jsp.NextObject().getObject()),(Object)("root"));
 };
 } 
       catch (Exception e27) {
			ba.setLastException(e27);RDebugUtils.currentLine=262171;
 //BA.debugLineNum = 262171;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 };
RDebugUtils.currentLine=262173;
 //BA.debugLineNum = 262173;BA.debugLine="Log(\"----------\"&CRLF&sb_code.ToString&CRLF&\"----";
anywheresoftware.b4a.keywords.Common.Log("----------"+anywheresoftware.b4a.keywords.Common.CRLF+_sb_code.ToString()+anywheresoftware.b4a.keywords.Common.CRLF+"------------");
RDebugUtils.currentLine=262174;
 //BA.debugLineNum = 262174;BA.debugLine="Log(\"----------\"&CRLF&sbCLS.ToString&CRLF&\"------";
anywheresoftware.b4a.keywords.Common.Log("----------"+anywheresoftware.b4a.keywords.Common.CRLF+_sbcls.ToString()+anywheresoftware.b4a.keywords.Common.CRLF+"------------");
RDebugUtils.currentLine=262175;
 //BA.debugLineNum = 262175;BA.debugLine="End Sub";
return "";
}
public static String  _getjotype(Object _obj) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "getjotype"))
	return (String) Debug.delegate(ba, "getjotype", new Object[] {_obj});
String _ret = "";
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub getJOType(obj As Object) As String";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Dim ret As String";
_ret = "";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="If obj Is Int Then";
if (_obj instanceof Integer) { 
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="ret=\"Int\"";
_ret = "Int";
 }else 
{RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="else if obj Is Double Then";
if (_obj instanceof Double) { 
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="ret=\"Double\"";
_ret = "Double";
 }else 
{RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="Else if obj Is Map Then";
if (_obj instanceof anywheresoftware.b4a.objects.collections.Map.MyMap) { 
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="ret=\"Map\"";
_ret = "Map";
 }else 
{RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="Else if obj Is String Then";
if (_obj instanceof String) { 
RDebugUtils.currentLine=458761;
 //BA.debugLineNum = 458761;BA.debugLine="ret=\"String\"";
_ret = "String";
 }else {
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="ret=\"Object\"";
_ret = "Object";
 }}}};
RDebugUtils.currentLine=458765;
 //BA.debugLineNum = 458765;BA.debugLine="Return ret";
if (true) return _ret;
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="End Sub";
return "";
}
public static String  _gettabs(int _n) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "gettabs"))
	return (String) Debug.delegate(ba, "gettabs", new Object[] {_n});
String _ret = "";
int _i = 0;
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub getTABS(n As Int) As String";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Dim ret As String=\"\"";
_ret = "";
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="If n>0 Then";
if (_n>0) { 
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="For i=0 To n";
{
final int step3 = 1;
final int limit3 = _n;
for (_i = (int) (0) ; (step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3); _i = ((int)(0 + _i + step3)) ) {
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="ret=ret&\"    \"";
_ret = _ret+"    ";
 }
};
 };
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="Return ret";
if (true) return _ret;
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub parseJSO(obj As Object,parent As Object)";
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="If obj Is List Then";
if (_obj instanceof java.util.List) { 
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="Dim lst As List=obj";
_lst = new anywheresoftware.b4a.objects.collections.List();
_lst.setObject((java.util.List)(_obj));
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="If lst.Size>0 Then";
if (_lst.getSize()>0) { 
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"For Each col\"&p";
_sb_code.Append(_gettabs(_nfloor)+"For Each col"+BA.ObjectToString(_parent)+" As "+_getjotype(_lst.Get((int) (0)))+" in "+BA.ObjectToString(_parent)+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="nFloor=nFloor+1";
_nfloor = (int) (_nfloor+1);
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="parseJSO(lst.Get(0),\"col\"&parent)";
_parsejso(_lst.Get((int) (0)),(Object)("col"+BA.ObjectToString(_parent)));
RDebugUtils.currentLine=327688;
 //BA.debugLineNum = 327688;BA.debugLine="nFloor=nFloor-1";
_nfloor = (int) (_nfloor-1);
RDebugUtils.currentLine=327689;
 //BA.debugLineNum = 327689;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"Next\"&CRLF)";
_sb_code.Append(_gettabs(_nfloor)+"Next"+anywheresoftware.b4a.keywords.Common.CRLF);
 }else {
RDebugUtils.currentLine=327691;
 //BA.debugLineNum = 327691;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"'Empty List\"&CR";
_sb_code.Append(_gettabs(_nfloor)+"'Empty List"+anywheresoftware.b4a.keywords.Common.CRLF);
 };
 }else 
{RDebugUtils.currentLine=327693;
 //BA.debugLineNum = 327693;BA.debugLine="else if obj Is Map Then";
if (_obj instanceof anywheresoftware.b4a.objects.collections.Map.MyMap) { 
RDebugUtils.currentLine=327694;
 //BA.debugLineNum = 327694;BA.debugLine="flg=flg+1";
_flg = (int) (_flg+1);
RDebugUtils.currentLine=327696;
 //BA.debugLineNum = 327696;BA.debugLine="Dim m As Map=obj";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_obj));
RDebugUtils.currentLine=327697;
 //BA.debugLineNum = 327697;BA.debugLine="Dim tobj2 As Object";
_tobj2 = new Object();
RDebugUtils.currentLine=327698;
 //BA.debugLineNum = 327698;BA.debugLine="sbCLS.Append(getTABS(nFloor)&\"Type typ\"&parent&\"";
_sbcls.Append(_gettabs(_nfloor)+"Type typ"+BA.ObjectToString(_parent)+"(");
RDebugUtils.currentLine=327699;
 //BA.debugLineNum = 327699;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"Dim myItem As ty";
_sb_code.Append(_gettabs(_nfloor)+"Dim myItem As typ"+BA.ObjectToString(_parent)+anywheresoftware.b4a.keywords.Common.CRLF+_gettabs(_nfloor)+"myItem.Initialize"+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=327700;
 //BA.debugLineNum = 327700;BA.debugLine="For Each k As String In m.Keys";
final anywheresoftware.b4a.BA.IterableList group18 = _m.Keys();
final int groupLen18 = group18.getSize();
for (int index18 = 0;index18 < groupLen18 ;index18++){
_k = BA.ObjectToString(group18.Get(index18));
RDebugUtils.currentLine=327701;
 //BA.debugLineNum = 327701;BA.debugLine="tobj2=m.Get(k)";
_tobj2 = _m.Get((Object)(_k));
RDebugUtils.currentLine=327702;
 //BA.debugLineNum = 327702;BA.debugLine="sbCLS.Append(parent&\"_\"&k&\" as \"&getJOType(tobj";
_sbcls.Append(BA.ObjectToString(_parent)+"_"+_k+" as "+_getjotype(_tobj2)+",");
RDebugUtils.currentLine=327703;
 //BA.debugLineNum = 327703;BA.debugLine="sb_code.Append(getTABS(nFloor)&\"myItem.\"&parent";
_sb_code.Append(_gettabs(_nfloor)+"myItem."+BA.ObjectToString(_parent)+"_"+_k+" = "+BA.ObjectToString(_parent)+".Get(\""+_k+"\")"+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=327705;
 //BA.debugLineNum = 327705;BA.debugLine="parseJSO(tobj2,parent&\"_\"&k)";
_parsejso(_tobj2,(Object)(BA.ObjectToString(_parent)+"_"+_k));
 }
;
RDebugUtils.currentLine=327708;
 //BA.debugLineNum = 327708;BA.debugLine="sbCLS.Remove(sbCLS.Length-1,sbCLS.Length)";
_sbcls.Remove((int) (_sbcls.getLength()-1),_sbcls.getLength());
RDebugUtils.currentLine=327709;
 //BA.debugLineNum = 327709;BA.debugLine="sbCLS.Append(\")\"&CRLF)";
_sbcls.Append(")"+anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=327710;
 //BA.debugLineNum = 327710;BA.debugLine="flg=flg-1";
_flg = (int) (_flg-1);
 }};
RDebugUtils.currentLine=327715;
 //BA.debugLineNum = 327715;BA.debugLine="End Sub";
return "";
}
public static String  _test() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "test"))
	return (String) Debug.delegate(ba, "test", null);
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub test";
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="End Sub";
return "";
}
}