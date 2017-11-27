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
public static anywheresoftware.b4a.objects.collections.Map _mdata = null;
public static String _jqcdn = "";
public static String _vuecdn = "";
public static b4j.example.wpdbutils _wpdbutils = null;
public static b4j.example.g _g = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 119;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return false;
}
public static String  _appstart(String[] _args) throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Sub AppStart (Args() As String)";
 //BA.debugLineNum = 20;BA.debugLine="If Args=Null Or Args.Length<2 Then";
if (_args== null || _args.length<2) { 
 //BA.debugLineNum = 21;BA.debugLine="printUsage";
_printusage();
 //BA.debugLineNum = 22;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 24;BA.debugLine="mData.Initialize";
_mdata.Initialize();
 //BA.debugLineNum = 30;BA.debugLine="Select Args(0).ToLowerCase";
switch (BA.switchObjectToInt(_args[(int) (0)].toLowerCase(),"dbconfig","genhandler")) {
case 0: {
 //BA.debugLineNum = 32;BA.debugLine="dbconfig(Args)";
_dbconfig(_args);
 break; }
case 1: {
 //BA.debugLineNum = 34;BA.debugLine="gencode(Args)";
_gencode(_args);
 //BA.debugLineNum = 35;BA.debugLine="Log(\"gencode complete,please move gencode dir a";
anywheresoftware.b4a.keywords.Common.Log("gencode complete,please move gencode dir as your new project dir");
 break; }
}
;
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _dbconfig(String[] _args) throws Exception{
String _dbhost = "";
String _dbuser = "";
String _dbpass = "";
String _dbname = "";
 //BA.debugLineNum = 39;BA.debugLine="Public Sub dbconfig(args() As String)";
 //BA.debugLineNum = 40;BA.debugLine="Dim dbhost,dbuser,dbpass,dbname As String";
_dbhost = "";
_dbuser = "";
_dbpass = "";
_dbname = "";
 //BA.debugLineNum = 41;BA.debugLine="dbhost=args(1)";
_dbhost = _args[(int) (1)];
 //BA.debugLineNum = 42;BA.debugLine="dbname=args(2)";
_dbname = _args[(int) (2)];
 //BA.debugLineNum = 43;BA.debugLine="dbuser=args(3)";
_dbuser = _args[(int) (3)];
 //BA.debugLineNum = 44;BA.debugLine="dbpass=args(4)";
_dbpass = _args[(int) (4)];
 //BA.debugLineNum = 45;BA.debugLine="wpDBUtils.conpool.Initialize(\"com.mysql.jdbc.Driv";
_wpdbutils._conpool.Initialize("com.mysql.jdbc.Driver",("jdbc:mysql://"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_dbhost))+":3306/"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_dbname))+"?characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull"),_dbuser,_dbpass);
 //BA.debugLineNum = 46;BA.debugLine="G.db=wpDBUtils.conpool.GetConnection";
_g._db = _wpdbutils._conpool.GetConnection();
 //BA.debugLineNum = 47;BA.debugLine="mData.Put(\"dbname\",dbname)";
_mdata.Put((Object)("dbname"),(Object)(_dbname));
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public static String  _gencode(String[] _args) throws Exception{
String _uripath = "";
String _tablename = "";
String _viewdir = "";
String _handlerdir = "";
String _query = "";
anywheresoftware.b4a.objects.collections.List _lst = null;
String _key = "";
String _viewnamepre = "";
String _tplstr = "";
anywheresoftware.b4a.keywords.StringBuilderWrapper _tsb = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _tbody = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
String _handlername = "";
 //BA.debugLineNum = 49;BA.debugLine="Public Sub gencode(args() As String)";
 //BA.debugLineNum = 50;BA.debugLine="Dim uripath As String,tablename As String";
_uripath = "";
_tablename = "";
 //BA.debugLineNum = 51;BA.debugLine="uripath=args(1)";
_uripath = _args[(int) (1)];
 //BA.debugLineNum = 52;BA.debugLine="tablename=args(2)";
_tablename = _args[(int) (2)];
 //BA.debugLineNum = 53;BA.debugLine="If File.Exists(File.DirApp,\"codegen\") Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirApp(),"codegen")) { 
 //BA.debugLineNum = 54;BA.debugLine="Log(\"please remove codegen dir first\")";
anywheresoftware.b4a.keywords.Common.Log("please remove codegen dir first");
 };
 //BA.debugLineNum = 57;BA.debugLine="Dim viewdir As String=File.Combine(File.DirApp,\"c";
_viewdir = anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirApp(),"codegen/view");
 //BA.debugLineNum = 58;BA.debugLine="Dim handlerdir As String=File.Combine(File.DirApp";
_handlerdir = anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirApp(),"codegen/handler");
 //BA.debugLineNum = 59;BA.debugLine="File.MakeDir(File.DirApp,\"codegen/view\")";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirApp(),"codegen/view");
 //BA.debugLineNum = 60;BA.debugLine="File.MakeDir(File.DirApp,\"codegen/handler\")";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirApp(),"codegen/handler");
 //BA.debugLineNum = 62;BA.debugLine="Dim query As String=$\"select column_name colname,";
_query = ("select column_name colname,data_type datatype,ifnull(character_maximum_length,11) maxlength,column_comment comments from information_schema.columns\n"+"where table_schema = '"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",_mdata.GetDefault((Object)("dbname"),(Object)("webplus")))+"'  #表所在数据库\n"+"And table_name = '"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_tablename))+"' ; #你要查的表");
 //BA.debugLineNum = 65;BA.debugLine="Dim lst As List=wpDBUtils.ExecuteMemoryTable(G.db";
_lst = new anywheresoftware.b4a.objects.collections.List();
_lst = _wpdbutils._executememorytable(_g._db,_query,(Object[])(anywheresoftware.b4a.keywords.Common.Null),(int) (0));
 //BA.debugLineNum = 66;BA.debugLine="Dim key As String=getTableKey(tablename)";
_key = _gettablekey(_tablename);
 //BA.debugLineNum = 67;BA.debugLine="Dim viewnamepre As String=uripath.Replace(\"/\",\"_\"";
_viewnamepre = _uripath.replace("/","_").toLowerCase().substring((int) (1));
 //BA.debugLineNum = 69;BA.debugLine="Dim tplstr As String=File.ReadString(File.DirApp,";
_tplstr = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirApp(),"tpl/list.html");
 //BA.debugLineNum = 70;BA.debugLine="Dim tsb,tbody As StringBuilder";
_tsb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_tbody = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 71;BA.debugLine="tsb.Initialize";
_tsb.Initialize();
 //BA.debugLineNum = 72;BA.debugLine="tbody.Initialize";
_tbody.Initialize();
 //BA.debugLineNum = 73;BA.debugLine="For Each m As Map In lst";
_m = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group19 = _lst;
final int groupLen19 = group19.getSize()
;int index19 = 0;
;
for (; index19 < groupLen19;index19++){
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group19.Get(index19)));
 //BA.debugLineNum = 74;BA.debugLine="tsb.Append($\"<td>${m.GetDefault(\"colname\",\"\")}</";
_tsb.Append(("<td>"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",_m.GetDefault((Object)("colname"),(Object)("")))+"</td>"));
 //BA.debugLineNum = 75;BA.debugLine="tbody.Append($\"<td>{{ item.${m.GetDefault(\"colna";
_tbody.Append(("<td>{{ item."+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",_m.GetDefault((Object)("colname"),(Object)("key")))+" }}</td>"));
 }
};
 //BA.debugLineNum = 77;BA.debugLine="tplstr=G.ReplaceMap(tplstr,CreateMap(\"actionurl\":";
_tplstr = _g._replacemap(_tplstr,anywheresoftware.b4a.keywords.Common.createMap(new Object[] {(Object)("actionurl"),(Object)(_uripath),(Object)("table"),(Object)(_tablename),(Object)("vuecdn"),(Object)(_vuecdn),(Object)("jqcdn"),(Object)(_jqcdn),(Object)("thead"),(Object)(_tsb.ToString()),(Object)("tbody"),(Object)(_tbody.ToString())}));
 //BA.debugLineNum = 78;BA.debugLine="File.WriteString(viewdir,viewnamepre&\"list.html\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(_viewdir,_viewnamepre+"list.html",_tplstr);
 //BA.debugLineNum = 80;BA.debugLine="tplstr=File.ReadString(File.DirApp,\"tpl/edit.html";
_tplstr = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirApp(),"tpl/edit.html");
 //BA.debugLineNum = 81;BA.debugLine="tbody.Initialize";
_tbody.Initialize();
 //BA.debugLineNum = 82;BA.debugLine="tsb.Initialize";
_tsb.Initialize();
 //BA.debugLineNum = 83;BA.debugLine="For Each m As Map In lst";
_m = new anywheresoftware.b4a.objects.collections.Map();
{
final anywheresoftware.b4a.BA.IterableList group28 = _lst;
final int groupLen28 = group28.getSize()
;int index28 = 0;
;
for (; index28 < groupLen28;index28++){
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group28.Get(index28)));
 //BA.debugLineNum = 84;BA.debugLine="If key.EqualsIgnoreCase(m.GetDefault(\"colname\",\"";
if (_key.equalsIgnoreCase(BA.ObjectToString(_m.GetDefault((Object)("colname"),(Object)("id"))))) { 
 //BA.debugLineNum = 85;BA.debugLine="tsb.Append($\"<input type=\"hidden\" name=\"${m.Get";
_tsb.Append(("<input type=\"hidden\" name=\""+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",_m.GetDefault((Object)("colname"),(Object)("")))+"\">"));
 }else {
 //BA.debugLineNum = 87;BA.debugLine="tbody.Append($\"<tr><td>${m.GetDefault(\"colname\"";
_tbody.Append(("<tr><td>"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",_m.GetDefault((Object)("colname"),(Object)("")))+"</td><td><input type=\"text\" name=\"info."+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",_m.GetDefault((Object)("colname"),(Object)("")))+"\"></td></tr>"));
 };
 }
};
 //BA.debugLineNum = 91;BA.debugLine="tbody.Append($\"<tr><td><input type=\"submit\" value";
_tbody.Append(("<tr><td><input type=\"submit\" value=\"提交\"></td>\n"+"		<td><input type=\"reset\" value=\"重置\"></td></tr>"));
 //BA.debugLineNum = 93;BA.debugLine="tplstr=G.ReplaceMap(tplstr,CreateMap(\"actionurl\":";
_tplstr = _g._replacemap(_tplstr,anywheresoftware.b4a.keywords.Common.createMap(new Object[] {(Object)("actionurl"),(Object)(_uripath),(Object)("table"),(Object)(_tablename),(Object)("vuecdn"),(Object)(_vuecdn),(Object)("jqcdn"),(Object)(_jqcdn),(Object)("tbody"),(Object)(_tbody.ToString()),(Object)("hiddenarea"),(Object)(_tsb.ToString())}));
 //BA.debugLineNum = 94;BA.debugLine="File.Writestring(viewdir,viewnamepre&\"edit.html\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(_viewdir,_viewnamepre+"edit.html",_tplstr);
 //BA.debugLineNum = 96;BA.debugLine="tplstr=File.ReadString(File.DirApp,\"tpl/Handler.b";
_tplstr = anywheresoftware.b4a.keywords.Common.File.ReadString(anywheresoftware.b4a.keywords.Common.File.getDirApp(),"tpl/Handler.bas");
 //BA.debugLineNum = 97;BA.debugLine="tplstr=G.ReplaceMap(tplstr,CreateMap(\"uripath\":ur";
_tplstr = _g._replacemap(_tplstr,anywheresoftware.b4a.keywords.Common.createMap(new Object[] {(Object)("uripath"),(Object)(_uripath),(Object)("tablename"),(Object)(_tablename),(Object)("viewname"),(Object)(_viewnamepre)}));
 //BA.debugLineNum = 98;BA.debugLine="Dim handlername As String=G.arrUpperFirst(Regex.S";
_handlername = _g._arrupperfirst(anywheresoftware.b4a.keywords.Common.Regex.Split("/",_uripath));
 //BA.debugLineNum = 99;BA.debugLine="handlername=handlername.SubString2(handlername.La";
_handlername = _handlername.substring((int) (_handlername.lastIndexOf("/")+1),_handlername.length());
 //BA.debugLineNum = 100;BA.debugLine="File.WriteString(handlerdir,handlername&\"Handle.b";
anywheresoftware.b4a.keywords.Common.File.WriteString(_handlerdir,_handlername+"Handle.bas",_tplstr);
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public static String  _gettablekey(String _table) throws Exception{
String _query = "";
 //BA.debugLineNum = 102;BA.debugLine="Private Sub getTableKey(table As String) As String";
 //BA.debugLineNum = 103;BA.debugLine="Dim query As String=$\"select column_name keyname";
_query = ("select column_name keyname from information_schema.key_column_usage where table_schema='"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",_mdata.GetDefault((Object)("dbname"),(Object)("webplus")))+"' and `table_name`='"+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_table))+"'");
 //BA.debugLineNum = 104;BA.debugLine="Return wpDBUtils.ExecuteMap(G.db,query,Null).GetD";
if (true) return BA.ObjectToString(_wpdbutils._executemap(_g._db,_query,(Object[])(anywheresoftware.b4a.keywords.Common.Null)).GetDefault((Object)("keyname"),(Object)("id")));
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _printusage() throws Exception{
 //BA.debugLineNum = 106;BA.debugLine="Sub printUsage";
 //BA.debugLineNum = 107;BA.debugLine="Log($\"usage: 	\"java -jar codegen \" with: 	dbconfi";
anywheresoftware.b4a.keywords.Common.Log(("usage:\n"+"	\"java -jar codegen \" with:\n"+"	dbconfig dbhost dbname dbuser dbpass\n"+"	genhandler uripath tablename\n"+"for example:\n"+"	dbconfig localhost webplus root root\n"+"	genhandler /mgr/user/ wp_user\n"+"	"));
 //BA.debugLineNum = 115;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
wpdbutils._process_globals();
g._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 14;BA.debugLine="Dim mData As Map";
_mdata = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 15;BA.debugLine="Public jqCDN As String=\"https://ossweb-img.qq.com";
_jqcdn = "https://ossweb-img.qq.com/images/js/jquery/jquery-1.9.0.min.js";
 //BA.debugLineNum = 16;BA.debugLine="Public vueCDN As String=\"https://cdn.jsdelivr.net";
_vuecdn = "https://cdn.jsdelivr.net/npm/vue";
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
}
