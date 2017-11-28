package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class wpdbutils extends Object{
public static wpdbutils mostCurrent = new wpdbutils();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.wpdbutils", null);
		ba.loadHtSubs(wpdbutils.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.wpdbutils", ba);
		}
	}
    public static Class<?> getObject() {
		return wpdbutils.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.object.ConnectionPool _conpool = null;
public static int _curdbtype = 0;
public static String _db_real = "";
public static String _db_integer = "";
public static String _db_blob = "";
public static String _db_text = "";
public static String _htmlcss = "";
public static b4j.example.main _main = null;
public static b4j.example.g _g = null;
public static class _dboptret{
public boolean IsInitialized;
public boolean success;
public String msg;
public void Initialize() {
IsInitialized = true;
success = false;
msg = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static String  _createtable(anywheresoftware.b4j.objects.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.Map _fieldsandtypes,String _primarykey) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
String _field = "";
String _ftype = "";
String _query = "";
 //BA.debugLineNum = 65;BA.debugLine="Public Sub CreateTable(SQL As SQL, TableName As St";
 //BA.debugLineNum = 66;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 67;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 68;BA.debugLine="sb.Append(\"(\")";
_sb.Append("(");
 //BA.debugLineNum = 69;BA.debugLine="For i = 0 To FieldsAndTypes.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_fieldsandtypes.getSize()-1);
_i = (int) (0) ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
 //BA.debugLineNum = 70;BA.debugLine="Dim field, ftype As String";
_field = "";
_ftype = "";
 //BA.debugLineNum = 71;BA.debugLine="field = FieldsAndTypes.GetKeyAt(i)";
_field = BA.ObjectToString(_fieldsandtypes.GetKeyAt(_i));
 //BA.debugLineNum = 72;BA.debugLine="ftype = FieldsAndTypes.GetValueAt(i)";
_ftype = BA.ObjectToString(_fieldsandtypes.GetValueAt(_i));
 //BA.debugLineNum = 73;BA.debugLine="If i > 0 Then sb.Append(\", \")";
if (_i>0) { 
_sb.Append(", ");};
 //BA.debugLineNum = 74;BA.debugLine="sb.Append(EscapeField(field)).Append(\" \").Append";
_sb.Append(_escapefield(_field)).Append(" ").Append(_ftype);
 //BA.debugLineNum = 75;BA.debugLine="If field = PrimaryKey Then sb.Append(\" PRIMARY K";
if ((_field).equals(_primarykey)) { 
_sb.Append(" PRIMARY KEY");};
 }
};
 //BA.debugLineNum = 77;BA.debugLine="sb.Append(\")\")";
_sb.Append(")");
 //BA.debugLineNum = 78;BA.debugLine="Dim query As String";
_query = "";
 //BA.debugLineNum = 79;BA.debugLine="query = \"CREATE TABLE IF NOT EXISTS \" & EscapeFie";
_query = "CREATE TABLE IF NOT EXISTS "+_escapefield(_tablename)+" "+_sb.ToString();
 //BA.debugLineNum = 80;BA.debugLine="g.mLog(\"CreateTable: \" & query)";
_g._mlog("CreateTable: "+_query);
 //BA.debugLineNum = 81;BA.debugLine="SQL.ExecNonQuery(query)";
_sql.ExecNonQuery(_query);
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static String  _deleterecord(anywheresoftware.b4j.objects.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.Map _wherefieldequals) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.collections.List _args = null;
int _i = 0;
 //BA.debugLineNum = 393;BA.debugLine="Public Sub DeleteRecord(SQL As SQL, TableName As S";
 //BA.debugLineNum = 394;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 395;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 396;BA.debugLine="sb.Append(\"DELETE FROM \").Append(EscapeField(Tabl";
_sb.Append("DELETE FROM ").Append(_escapefield(_tablename)).Append(" WHERE ");
 //BA.debugLineNum = 397;BA.debugLine="If WhereFieldEquals.Size = 0 Then";
if (_wherefieldequals.getSize()==0) { 
 //BA.debugLineNum = 398;BA.debugLine="g.mLog(\"WhereFieldEquals map empty!\")";
_g._mlog("WhereFieldEquals map empty!");
 //BA.debugLineNum = 399;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 401;BA.debugLine="Dim args As List";
_args = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 402;BA.debugLine="args.Initialize";
_args.Initialize();
 //BA.debugLineNum = 403;BA.debugLine="For i = 0 To WhereFieldEquals.Size - 1";
{
final int step10 = 1;
final int limit10 = (int) (_wherefieldequals.getSize()-1);
_i = (int) (0) ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
 //BA.debugLineNum = 404;BA.debugLine="If i > 0 Then sb.Append(\" AND \")";
if (_i>0) { 
_sb.Append(" AND ");};
 //BA.debugLineNum = 405;BA.debugLine="sb.Append(EscapeField(WhereFieldEquals.GetKeyAt(";
_sb.Append(_escapefield(BA.ObjectToString(_wherefieldequals.GetKeyAt(_i)))).Append(" = ?");
 //BA.debugLineNum = 406;BA.debugLine="args.Add(WhereFieldEquals.GetValueAt(i))";
_args.Add(_wherefieldequals.GetValueAt(_i));
 }
};
 //BA.debugLineNum = 408;BA.debugLine="g.mLog(\"DeleteRecord: \" & sb.ToString)";
_g._mlog("DeleteRecord: "+_sb.ToString());
 //BA.debugLineNum = 409;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, args)";
_sql.ExecNonQuery2(_sb.ToString(),_args);
 //BA.debugLineNum = 410;BA.debugLine="End Sub";
return "";
}
public static String  _droptable(anywheresoftware.b4j.objects.SQL _sql,String _tablename) throws Exception{
String _query = "";
 //BA.debugLineNum = 85;BA.debugLine="Public Sub DropTable(SQL As SQL, TableName As Stri";
 //BA.debugLineNum = 86;BA.debugLine="Dim query As String";
_query = "";
 //BA.debugLineNum = 87;BA.debugLine="query = \"DROP TABLE IF EXISTS \" & EscapeField(Tab";
_query = "DROP TABLE IF EXISTS "+_escapefield(_tablename);
 //BA.debugLineNum = 88;BA.debugLine="g.mLog(\"DropTable3: \" & query)";
_g._mlog("DropTable3: "+_query);
 //BA.debugLineNum = 89;BA.debugLine="SQL.ExecNonQuery(query)";
_sql.ExecNonQuery(_query);
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public static String  _escapefield(String _f) throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="public Sub EscapeField(f As String) As String";
 //BA.debugLineNum = 38;BA.debugLine="If curDbType=1 Then";
if (_curdbtype==1) { 
 //BA.debugLineNum = 39;BA.debugLine="Return \"[\" & f & \"]\"";
if (true) return "["+_f+"]";
 }else {
 //BA.debugLineNum = 41;BA.debugLine="Return \"`\" & f & \"`\"";
if (true) return "`"+_f+"`";
 };
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.Map  _executebasemap(anywheresoftware.b4j.objects.SQL _sql,String _query,String[] _stringargs) throws Exception{
anywheresoftware.b4a.objects.collections.Map _res = null;
anywheresoftware.b4j.objects.SQL.ResultSetWrapper _cur = null;
 //BA.debugLineNum = 44;BA.debugLine="Public Sub ExecuteBaseMap(SQL As SQL, Query As Str";
 //BA.debugLineNum = 45;BA.debugLine="Dim res As Map";
_res = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 46;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4j.objects.SQL.ResultSetWrapper();
 //BA.debugLineNum = 47;BA.debugLine="If StringArgs <> Null Then";
if (_stringargs!= null) { 
 //BA.debugLineNum = 48;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
_cur = _sql.ExecQuery2(_query,anywheresoftware.b4a.keywords.Common.ArrayToList(_stringargs));
 }else {
 //BA.debugLineNum = 50;BA.debugLine="cur = SQL.ExecQuery(Query)";
_cur = _sql.ExecQuery(_query);
 };
 //BA.debugLineNum = 52;BA.debugLine="Log(\"ExecuteMap: \" & Query)";
anywheresoftware.b4a.keywords.Common.Log("ExecuteMap: "+_query);
 //BA.debugLineNum = 53;BA.debugLine="res.Initialize";
_res.Initialize();
 //BA.debugLineNum = 55;BA.debugLine="Do While cur.NextRow";
while (_cur.NextRow()) {
 //BA.debugLineNum = 56;BA.debugLine="res.Put(cur.GetString2(0).ToLowerCase,cur.GetStr";
_res.Put((Object)(_cur.GetString2((int) (0)).toLowerCase()),(Object)(_cur.GetString2((int) (1))));
 }
;
 //BA.debugLineNum = 58;BA.debugLine="cur.Close";
_cur.Close();
 //BA.debugLineNum = 59;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return null;
}
public static String  _executehtml(anywheresoftware.b4j.objects.SQL _sql,String _query,String[] _stringargs,int _limit) throws Exception{
anywheresoftware.b4j.objects.SQL.ResultSetWrapper _cur = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
int _row = 0;
 //BA.debugLineNum = 346;BA.debugLine="Public Sub ExecuteHtml(SQL As SQL, Query As String";
 //BA.debugLineNum = 347;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4j.objects.SQL.ResultSetWrapper();
 //BA.debugLineNum = 348;BA.debugLine="If StringArgs <> Null Then";
if (_stringargs!= null) { 
 //BA.debugLineNum = 349;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
_cur = _sql.ExecQuery2(_query,anywheresoftware.b4a.keywords.Common.ArrayToList(_stringargs));
 }else {
 //BA.debugLineNum = 351;BA.debugLine="cur = SQL.ExecQuery(Query)";
_cur = _sql.ExecQuery(_query);
 };
 //BA.debugLineNum = 353;BA.debugLine="g.mLog(\"ExecuteHtml: \" & Query)";
_g._mlog("ExecuteHtml: "+_query);
 //BA.debugLineNum = 354;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 355;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 356;BA.debugLine="sb.Append(\"<html><body>\").Append(CRLF)";
_sb.Append("<html><body>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 357;BA.debugLine="sb.Append(\"<style type='text/css'>\").Append(HtmlC";
_sb.Append("<style type='text/css'>").Append(_htmlcss).Append("</style>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 358;BA.debugLine="sb.Append(\"<table><thead><tr>\").Append(CRLF)";
_sb.Append("<table><thead><tr>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 359;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
{
final int step13 = 1;
final int limit13 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;(step13 > 0 && _i <= limit13) || (step13 < 0 && _i >= limit13) ;_i = ((int)(0 + _i + step13))  ) {
 //BA.debugLineNum = 360;BA.debugLine="sb.Append(\"<th>\").Append(cur.GetColumnName(i)).A";
_sb.Append("<th>").Append(_cur.GetColumnName(_i)).Append("</th>");
 }
};
 //BA.debugLineNum = 362;BA.debugLine="sb.Append(\"</thead>\")";
_sb.Append("</thead>");
 //BA.debugLineNum = 372;BA.debugLine="sb.Append(\"</tr>\").Append(CRLF)";
_sb.Append("</tr>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 373;BA.debugLine="Dim row As Int";
_row = 0;
 //BA.debugLineNum = 374;BA.debugLine="Do While cur.NextRow";
while (_cur.NextRow()) {
 //BA.debugLineNum = 375;BA.debugLine="If row Mod 2 = 0 Then";
if (_row%2==0) { 
 //BA.debugLineNum = 376;BA.debugLine="sb.Append(\"<tr>\")";
_sb.Append("<tr>");
 }else {
 //BA.debugLineNum = 378;BA.debugLine="sb.Append(\"<tr class='odd'>\")";
_sb.Append("<tr class='odd'>");
 };
 //BA.debugLineNum = 380;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
{
final int step25 = 1;
final int limit25 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;(step25 > 0 && _i <= limit25) || (step25 < 0 && _i >= limit25) ;_i = ((int)(0 + _i + step25))  ) {
 //BA.debugLineNum = 381;BA.debugLine="sb.Append(\"<td>\")";
_sb.Append("<td>");
 //BA.debugLineNum = 382;BA.debugLine="sb.Append(cur.GetString2(i))";
_sb.Append(_cur.GetString2(_i));
 //BA.debugLineNum = 383;BA.debugLine="sb.Append(\"</td>\")";
_sb.Append("</td>");
 }
};
 //BA.debugLineNum = 385;BA.debugLine="sb.Append(\"</tr>\").Append(CRLF)";
_sb.Append("</tr>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 386;BA.debugLine="row = row + 1";
_row = (int) (_row+1);
 }
;
 //BA.debugLineNum = 388;BA.debugLine="cur.Close";
_cur.Close();
 //BA.debugLineNum = 389;BA.debugLine="sb.Append(\"</table></body></html>\")";
_sb.Append("</table></body></html>");
 //BA.debugLineNum = 390;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 391;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.Map  _executemap(anywheresoftware.b4j.objects.SQL _sql,String _query,Object[] _stringargs) throws Exception{
anywheresoftware.b4a.objects.collections.Map _res = null;
anywheresoftware.b4j.objects.SQL.ResultSetWrapper _cur = null;
int _i = 0;
 //BA.debugLineNum = 320;BA.debugLine="Public Sub ExecuteMap(SQL As SQL, Query As String,";
 //BA.debugLineNum = 321;BA.debugLine="Dim res As Map";
_res = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 322;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4j.objects.SQL.ResultSetWrapper();
 //BA.debugLineNum = 323;BA.debugLine="If StringArgs <> Null Then";
if (_stringargs!= null) { 
 //BA.debugLineNum = 324;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
_cur = _sql.ExecQuery2(_query,anywheresoftware.b4a.keywords.Common.ArrayToList(_stringargs));
 }else {
 //BA.debugLineNum = 326;BA.debugLine="cur = SQL.ExecQuery(Query)";
_cur = _sql.ExecQuery(_query);
 };
 //BA.debugLineNum = 328;BA.debugLine="res.Initialize";
_res.Initialize();
 //BA.debugLineNum = 329;BA.debugLine="g.mLog(\"ExecuteMap: \" & Query)";
_g._mlog("ExecuteMap: "+_query);
 //BA.debugLineNum = 330;BA.debugLine="If cur.NextRow = False Then";
if (_cur.NextRow()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 331;BA.debugLine="g.mLog(\"No records found.\")";
_g._mlog("No records found.");
 //BA.debugLineNum = 332;BA.debugLine="Return res";
if (true) return _res;
 };
 //BA.debugLineNum = 335;BA.debugLine="g.mLog(\"cnt:\"&cur.ColumnCount)";
_g._mlog("cnt:"+BA.NumberToString(_cur.getColumnCount()));
 //BA.debugLineNum = 336;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
{
final int step15 = 1;
final int limit15 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
 //BA.debugLineNum = 337;BA.debugLine="res.Put(cur.GetColumnName(i).ToLowerCase, cur.Ge";
_res.Put((Object)(_cur.GetColumnName(_i).toLowerCase()),(Object)(_cur.GetString2(_i)));
 }
};
 //BA.debugLineNum = 339;BA.debugLine="cur.Close";
_cur.Close();
 //BA.debugLineNum = 340;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 341;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _executememorytable(anywheresoftware.b4j.objects.SQL _sql,String _query,Object[] _stringargs,int _limit) throws Exception{
anywheresoftware.b4j.objects.SQL.ResultSetWrapper _cur = null;
anywheresoftware.b4a.objects.collections.List _table = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
int _col = 0;
 //BA.debugLineNum = 259;BA.debugLine="Public Sub ExecuteMemoryTable(SQL As SQL, Query As";
 //BA.debugLineNum = 260;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4j.objects.SQL.ResultSetWrapper();
 //BA.debugLineNum = 267;BA.debugLine="If StringArgs == Null Or StringArgs.Length<1 Then";
if (_stringargs== null || _stringargs.length<1) { 
 //BA.debugLineNum = 268;BA.debugLine="Dim StringArgs(0) As Object";
_stringargs = new Object[(int) (0)];
{
int d0 = _stringargs.length;
for (int i0 = 0;i0 < d0;i0++) {
_stringargs[i0] = new Object();
}
}
;
 };
 //BA.debugLineNum = 270;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
_cur = _sql.ExecQuery2(_query,anywheresoftware.b4a.keywords.Common.ArrayToList(_stringargs));
 //BA.debugLineNum = 271;BA.debugLine="g.mLog(\"ExecuteMemoryTable: \" & Query)";
_g._mlog("ExecuteMemoryTable: "+_query);
 //BA.debugLineNum = 272;BA.debugLine="Dim table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 273;BA.debugLine="table.Initialize";
_table.Initialize();
 //BA.debugLineNum = 274;BA.debugLine="Do While cur.NextRow";
while (_cur.NextRow()) {
 //BA.debugLineNum = 275;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 276;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 277;BA.debugLine="For col = 0 To cur.ColumnCount - 1";
{
final int step12 = 1;
final int limit12 = (int) (_cur.getColumnCount()-1);
_col = (int) (0) ;
for (;(step12 > 0 && _col <= limit12) || (step12 < 0 && _col >= limit12) ;_col = ((int)(0 + _col + step12))  ) {
 //BA.debugLineNum = 278;BA.debugLine="m.Put(cur.GetColumnName(col).ToLowerCase,cur.Ge";
_m.Put((Object)(_cur.GetColumnName(_col).toLowerCase()),(Object)(_cur.GetString2(_col)));
 }
};
 //BA.debugLineNum = 280;BA.debugLine="table.Add(m)";
_table.Add((Object)(_m.getObject()));
 //BA.debugLineNum = 281;BA.debugLine="If Limit > 0 And table.Size >= Limit Then Exit";
if (_limit>0 && _table.getSize()>=_limit) { 
if (true) break;};
 }
;
 //BA.debugLineNum = 283;BA.debugLine="cur.Close";
_cur.Close();
 //BA.debugLineNum = 284;BA.debugLine="Return table";
if (true) return _table;
 //BA.debugLineNum = 285;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _executememorytable2(anywheresoftware.b4j.objects.SQL _sql,String _tablename,String _fields,anywheresoftware.b4a.objects.collections.Map _wherefieldequals,int _limit) throws Exception{
anywheresoftware.b4j.objects.SQL.ResultSetWrapper _cur = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.collections.List _args = null;
anywheresoftware.b4a.objects.collections.List _table = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _m = null;
int _col = 0;
 //BA.debugLineNum = 287;BA.debugLine="Public Sub ExecuteMemoryTable2(SQL As SQL, tablena";
 //BA.debugLineNum = 288;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4j.objects.SQL.ResultSetWrapper();
 //BA.debugLineNum = 289;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 290;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 291;BA.debugLine="Dim args As List";
_args = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 292;BA.debugLine="args.Initialize";
_args.Initialize();
 //BA.debugLineNum = 293;BA.debugLine="Dim table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 294;BA.debugLine="table.Initialize";
_table.Initialize();
 //BA.debugLineNum = 295;BA.debugLine="sb.Append(\"select \"&fields&\" from \"&EscapeField(t";
_sb.Append("select "+_fields+" from "+_escapefield(_tablename)+" where 1=1");
 //BA.debugLineNum = 296;BA.debugLine="For i = 0 To WhereFieldEquals.Size - 1";
{
final int step9 = 1;
final int limit9 = (int) (_wherefieldequals.getSize()-1);
_i = (int) (0) ;
for (;(step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9) ;_i = ((int)(0 + _i + step9))  ) {
 //BA.debugLineNum = 297;BA.debugLine="sb.Append(\" AND \")";
_sb.Append(" AND ");
 //BA.debugLineNum = 298;BA.debugLine="sb.Append(EscapeField(WhereFieldEquals.GetKeyAt(";
_sb.Append(_escapefield(BA.ObjectToString(_wherefieldequals.GetKeyAt(_i)))).Append(" = ?");
 //BA.debugLineNum = 299;BA.debugLine="args.Add(WhereFieldEquals.GetValueAt(i))";
_args.Add(_wherefieldequals.GetValueAt(_i));
 }
};
 //BA.debugLineNum = 301;BA.debugLine="cur = SQL.ExecQuery2(sb.ToString,args)";
_cur = _sql.ExecQuery2(_sb.ToString(),_args);
 //BA.debugLineNum = 302;BA.debugLine="g.mLog(\"ExecuteMemoryTable: \" & sb.ToString)";
_g._mlog("ExecuteMemoryTable: "+_sb.ToString());
 //BA.debugLineNum = 304;BA.debugLine="Do While cur.NextRow";
while (_cur.NextRow()) {
 //BA.debugLineNum = 305;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 306;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 307;BA.debugLine="For col = 0 To cur.ColumnCount - 1";
{
final int step19 = 1;
final int limit19 = (int) (_cur.getColumnCount()-1);
_col = (int) (0) ;
for (;(step19 > 0 && _col <= limit19) || (step19 < 0 && _col >= limit19) ;_col = ((int)(0 + _col + step19))  ) {
 //BA.debugLineNum = 308;BA.debugLine="m.Put(cur.GetColumnName(col).ToLowerCase,cur.Ge";
_m.Put((Object)(_cur.GetColumnName(_col).toLowerCase()),(Object)(_cur.GetString2(_col)));
 }
};
 //BA.debugLineNum = 310;BA.debugLine="table.Add(m)";
_table.Add((Object)(_m.getObject()));
 //BA.debugLineNum = 311;BA.debugLine="If Limit > 0 And table.Size >= Limit Then Exit";
if (_limit>0 && _table.getSize()>=_limit) { 
if (true) break;};
 }
;
 //BA.debugLineNum = 313;BA.debugLine="cur.Close";
_cur.Close();
 //BA.debugLineNum = 314;BA.debugLine="Return table";
if (true) return _table;
 //BA.debugLineNum = 315;BA.debugLine="End Sub";
return null;
}
public static String  _initconnectionpool(int _dbtype,String _connectionstr,String _dbuser,String _dbpass) throws Exception{
String _concls = "";
 //BA.debugLineNum = 20;BA.debugLine="Public Sub initConnectionPool(dbtype As Int,connec";
 //BA.debugLineNum = 21;BA.debugLine="curDbType=dbtype";
_curdbtype = _dbtype;
 //BA.debugLineNum = 22;BA.debugLine="Dim conCls As String=\"\"";
_concls = "";
 //BA.debugLineNum = 23;BA.debugLine="Select dbtype";
switch (_dbtype) {
case 0: {
 //BA.debugLineNum = 25;BA.debugLine="conCls=\"com.mysql.jdbc.Driver\"";
_concls = "com.mysql.jdbc.Driver";
 break; }
case 1: {
 //BA.debugLineNum = 27;BA.debugLine="conCls=\"net.sourceforge.jtds.jdbc.Driver\"";
_concls = "net.sourceforge.jtds.jdbc.Driver";
 break; }
case 2: {
 //BA.debugLineNum = 29;BA.debugLine="conCls=\"oracle.jdbc.driver.OracleDriver\"";
_concls = "oracle.jdbc.driver.OracleDriver";
 break; }
}
;
 //BA.debugLineNum = 31;BA.debugLine="conpool.Initialize(conCls,connectionStr,dbUser,db";
_conpool.Initialize(_concls,_connectionstr,_dbuser,_dbpass);
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static b4j.example.wpdbutils._dboptret  _insertlist(anywheresoftware.b4j.objects.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.List _listofmaps) throws Exception{
 //BA.debugLineNum = 502;BA.debugLine="Public Sub InsertList(SQL As SQL, TableName As Str";
 //BA.debugLineNum = 503;BA.debugLine="Return InsertMaps(SQL,TableName,ListOfMaps)";
if (true) return _insertmaps(_sql,_tablename,_listofmaps);
 //BA.debugLineNum = 504;BA.debugLine="End Sub";
return null;
}
public static b4j.example.wpdbutils._dboptret  _insertmap(anywheresoftware.b4j.objects.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
anywheresoftware.b4a.objects.collections.List _lst = null;
 //BA.debugLineNum = 188;BA.debugLine="Public Sub InsertMap(SQL As SQL, TableName As Stri";
 //BA.debugLineNum = 189;BA.debugLine="Dim lst As List";
_lst = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 190;BA.debugLine="lst.Initialize";
_lst.Initialize();
 //BA.debugLineNum = 191;BA.debugLine="lst.Add(m)";
_lst.Add((Object)(_m.getObject()));
 //BA.debugLineNum = 192;BA.debugLine="Return InsertMaps(SQL,TableName,lst)";
if (true) return _insertmaps(_sql,_tablename,_lst);
 //BA.debugLineNum = 193;BA.debugLine="End Sub";
return null;
}
public static b4j.example.wpdbutils._dboptret  _insertmaps(anywheresoftware.b4j.objects.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.List _listofmaps) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _columns = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _values = null;
b4j.example.wpdbutils._dboptret _ret = null;
int _i1 = 0;
anywheresoftware.b4a.objects.collections.List _listofvalues = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
int _i2 = 0;
String _col = "";
Object _value = null;
 //BA.debugLineNum = 96;BA.debugLine="Public Sub InsertMaps(SQL As SQL, TableName As Str";
 //BA.debugLineNum = 97;BA.debugLine="Dim sb, columns, values As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_columns = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_values = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 98;BA.debugLine="Dim ret As dbOptret";
_ret = new b4j.example.wpdbutils._dboptret();
 //BA.debugLineNum = 99;BA.debugLine="ret.Initialize";
_ret.Initialize();
 //BA.debugLineNum = 101;BA.debugLine="If ListOfMaps.Size > 1 And ListOfMaps.Get(0) = Li";
if (_listofmaps.getSize()>1 && (_listofmaps.Get((int) (0))).equals(_listofmaps.Get((int) (1)))) { 
 //BA.debugLineNum = 103;BA.debugLine="ret.success=False";
_ret.success = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 104;BA.debugLine="ret.msg=\"Same Map found twice in list. Each item";
_ret.msg = "Same Map found twice in list. Each item in the list should include a different map object.";
 //BA.debugLineNum = 105;BA.debugLine="Return ret";
if (true) return _ret;
 };
 //BA.debugLineNum = 107;BA.debugLine="SQL.BeginTransaction";
_sql.BeginTransaction();
 //BA.debugLineNum = 108;BA.debugLine="Try";
try { //BA.debugLineNum = 109;BA.debugLine="For i1 = 0 To ListOfMaps.Size - 1";
{
final int step11 = 1;
final int limit11 = (int) (_listofmaps.getSize()-1);
_i1 = (int) (0) ;
for (;(step11 > 0 && _i1 <= limit11) || (step11 < 0 && _i1 >= limit11) ;_i1 = ((int)(0 + _i1 + step11))  ) {
 //BA.debugLineNum = 110;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 111;BA.debugLine="columns.Initialize";
_columns.Initialize();
 //BA.debugLineNum = 112;BA.debugLine="values.Initialize";
_values.Initialize();
 //BA.debugLineNum = 113;BA.debugLine="Dim listOfValues As List";
_listofvalues = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 114;BA.debugLine="listOfValues.Initialize";
_listofvalues.Initialize();
 //BA.debugLineNum = 115;BA.debugLine="sb.Append(\"INSERT INTO \" & EscapeField(TableNam";
_sb.Append("INSERT INTO "+_escapefield(_tablename)+" (");
 //BA.debugLineNum = 116;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 117;BA.debugLine="m = ListOfMaps.Get(i1)";
_m.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_listofmaps.Get(_i1)));
 //BA.debugLineNum = 118;BA.debugLine="For i2 = 0 To m.Size - 1";
{
final int step20 = 1;
final int limit20 = (int) (_m.getSize()-1);
_i2 = (int) (0) ;
for (;(step20 > 0 && _i2 <= limit20) || (step20 < 0 && _i2 >= limit20) ;_i2 = ((int)(0 + _i2 + step20))  ) {
 //BA.debugLineNum = 119;BA.debugLine="Dim col As String";
_col = "";
 //BA.debugLineNum = 120;BA.debugLine="Dim value As Object";
_value = new Object();
 //BA.debugLineNum = 121;BA.debugLine="col = m.GetKeyAt(i2)";
_col = BA.ObjectToString(_m.GetKeyAt(_i2));
 //BA.debugLineNum = 122;BA.debugLine="value = m.GetValueAt(i2)";
_value = _m.GetValueAt(_i2);
 //BA.debugLineNum = 123;BA.debugLine="If i2 > 0 Then";
if (_i2>0) { 
 //BA.debugLineNum = 124;BA.debugLine="columns.Append(\", \")";
_columns.Append(", ");
 //BA.debugLineNum = 125;BA.debugLine="values.Append(\", \")";
_values.Append(", ");
 };
 //BA.debugLineNum = 127;BA.debugLine="columns.Append(EscapeField(col))";
_columns.Append(_escapefield(_col));
 //BA.debugLineNum = 129;BA.debugLine="values.Append(\"?\")";
_values.Append("?");
 //BA.debugLineNum = 130;BA.debugLine="listOfValues.Add(value)";
_listofvalues.Add(_value);
 }
};
 //BA.debugLineNum = 132;BA.debugLine="sb.Append(columns.ToString)";
_sb.Append(_columns.ToString());
 //BA.debugLineNum = 133;BA.debugLine="sb.Append(\") VALUES (\")";
_sb.Append(") VALUES (");
 //BA.debugLineNum = 134;BA.debugLine="sb.Append(values.ToString)";
_sb.Append(_values.ToString());
 //BA.debugLineNum = 135;BA.debugLine="sb.Append(\")\")";
_sb.Append(")");
 //BA.debugLineNum = 136;BA.debugLine="If i1 = 0 Then Log(\"InsertMaps (first query out";
if (_i1==0) { 
anywheresoftware.b4a.keywords.Common.Log("InsertMaps (first query out of "+BA.NumberToString(_listofmaps.getSize())+"): "+_sb.ToString());};
 //BA.debugLineNum = 137;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, listOfValues)";
_sql.ExecNonQuery2(_sb.ToString(),_listofvalues);
 }
};
 //BA.debugLineNum = 139;BA.debugLine="SQL.TransactionSuccessful";
_sql.TransactionSuccessful();
 //BA.debugLineNum = 140;BA.debugLine="ret.success=True";
_ret.success = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 141;BA.debugLine="ret.msg=\"成功\"";
_ret.msg = "成功";
 } 
       catch (Exception e44) {
			ba.setLastException(e44); //BA.debugLineNum = 143;BA.debugLine="g.mLog(LastException)";
_g._mlog(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 //BA.debugLineNum = 144;BA.debugLine="ret.success=False";
_ret.success = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 145;BA.debugLine="ret.msg=LastException.Message";
_ret.msg = anywheresoftware.b4a.keywords.Common.LastException(ba).getMessage();
 //BA.debugLineNum = 146;BA.debugLine="SQL.Rollback";
_sql.Rollback();
 };
 //BA.debugLineNum = 148;BA.debugLine="Return ret";
if (true) return _ret;
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return null;
}
public static b4j.example.wpdbutils._dboptret  _insertone(anywheresoftware.b4j.objects.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.Map _m) throws Exception{
 //BA.debugLineNum = 499;BA.debugLine="Public Sub InsertOne(SQL As SQL, TableName As Stri";
 //BA.debugLineNum = 500;BA.debugLine="Return InsertMap(SQL,TableName,m)";
if (true) return _insertmap(_sql,_tablename,_m);
 //BA.debugLineNum = 501;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _pagination(anywheresoftware.b4j.objects.SQL _sql,String _selectquery,String _fromquery,String _wherequery,String _orderby,Object[] _args,int _pageno,int _pagesize) throws Exception{
int _start = 0;
anywheresoftware.b4a.keywords.StringBuilderWrapper _qsb = null;
String _query = "";
anywheresoftware.b4j.objects.SQL.ResultSetWrapper _cur = null;
anywheresoftware.b4a.objects.collections.List _table = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
int _col = 0;
 //BA.debugLineNum = 450;BA.debugLine="Public Sub Pagination(SQL As SQL,selectQuery As St";
 //BA.debugLineNum = 451;BA.debugLine="Dim start As Int=pageno*pagesize";
_start = (int) (_pageno*_pagesize);
 //BA.debugLineNum = 452;BA.debugLine="Dim qsb As StringBuilder";
_qsb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 453;BA.debugLine="qsb.Initialize";
_qsb.Initialize();
 //BA.debugLineNum = 454;BA.debugLine="If selectQuery<>Null And selectQuery.Length>0 The";
if (_selectquery!= null && _selectquery.length()>0) { 
 //BA.debugLineNum = 455;BA.debugLine="qsb.Append(selectQuery&\" \")";
_qsb.Append(_selectquery+" ");
 }else {
 //BA.debugLineNum = 457;BA.debugLine="qsb.Append(\"select * \")";
_qsb.Append("select * ");
 };
 //BA.debugLineNum = 459;BA.debugLine="qsb.Append(fromQuery&\" where 1=1 \")";
_qsb.Append(_fromquery+" where 1=1 ");
 //BA.debugLineNum = 460;BA.debugLine="If whereQuery<>Null And whereQuery.Length>0 Then";
if (_wherequery!= null && _wherequery.length()>0) { 
 //BA.debugLineNum = 461;BA.debugLine="qsb.Append(\"and \"&whereQuery&\" \")";
_qsb.Append("and "+_wherequery+" ");
 };
 //BA.debugLineNum = 463;BA.debugLine="If orderby<>Null And orderby.Length>0 Then";
if (_orderby!= null && _orderby.length()>0) { 
 //BA.debugLineNum = 464;BA.debugLine="qsb.Append(\"order by \"&orderby&\" \")";
_qsb.Append("order by "+_orderby+" ");
 };
 //BA.debugLineNum = 466;BA.debugLine="qsb.Append(\"limit \"&start&\",\"&pagesize)";
_qsb.Append("limit "+BA.NumberToString(_start)+","+BA.NumberToString(_pagesize));
 //BA.debugLineNum = 467;BA.debugLine="Dim query As String=qsb.ToString";
_query = _qsb.ToString();
 //BA.debugLineNum = 468;BA.debugLine="G.mLog(\"Pagination:\"&query)";
_g._mlog("Pagination:"+_query);
 //BA.debugLineNum = 469;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4j.objects.SQL.ResultSetWrapper();
 //BA.debugLineNum = 470;BA.debugLine="If args<>Null Then";
if (_args!= null) { 
 //BA.debugLineNum = 471;BA.debugLine="cur=SQL.ExecQuery2(query,args)";
_cur = _sql.ExecQuery2(_query,anywheresoftware.b4a.keywords.Common.ArrayToList(_args));
 }else {
 //BA.debugLineNum = 473;BA.debugLine="cur=SQL.ExecQuery(query)";
_cur = _sql.ExecQuery(_query);
 };
 //BA.debugLineNum = 475;BA.debugLine="Dim table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 476;BA.debugLine="table.Initialize";
_table.Initialize();
 //BA.debugLineNum = 477;BA.debugLine="Do While cur.NextRow";
while (_cur.NextRow()) {
 //BA.debugLineNum = 478;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 479;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 480;BA.debugLine="For col = 0 To cur.ColumnCount - 1";
{
final int step30 = 1;
final int limit30 = (int) (_cur.getColumnCount()-1);
_col = (int) (0) ;
for (;(step30 > 0 && _col <= limit30) || (step30 < 0 && _col >= limit30) ;_col = ((int)(0 + _col + step30))  ) {
 //BA.debugLineNum = 481;BA.debugLine="m.Put(cur.GetColumnName(col).ToLowerCase,cur.Ge";
_m.Put((Object)(_cur.GetColumnName(_col).toLowerCase()),(Object)(_cur.GetString2(_col)));
 }
};
 //BA.debugLineNum = 483;BA.debugLine="table.Add(m)";
_table.Add((Object)(_m.getObject()));
 }
;
 //BA.debugLineNum = 485;BA.debugLine="cur.Close";
_cur.Close();
 //BA.debugLineNum = 486;BA.debugLine="Return table";
if (true) return _table;
 //BA.debugLineNum = 487;BA.debugLine="End Sub";
return null;
}
public static int  _pagination_totalsize(anywheresoftware.b4j.objects.SQL _sql,String _fromquery,String _wherequery,Object[] _args) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _qsb = null;
String _query = "";
anywheresoftware.b4j.objects.SQL.ResultSetWrapper _cur = null;
 //BA.debugLineNum = 418;BA.debugLine="Public Sub Pagination_TotalSize(SQL As SQL,fromQue";
 //BA.debugLineNum = 419;BA.debugLine="Dim qsb As StringBuilder";
_qsb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 420;BA.debugLine="qsb.Initialize";
_qsb.Initialize();
 //BA.debugLineNum = 421;BA.debugLine="qsb.Append(\"select count(1) cnt \")";
_qsb.Append("select count(1) cnt ");
 //BA.debugLineNum = 422;BA.debugLine="qsb.Append(fromQuery&\" where 1=1 \")";
_qsb.Append(_fromquery+" where 1=1 ");
 //BA.debugLineNum = 423;BA.debugLine="If whereQuery<>Null And whereQuery.Length>0 Then";
if (_wherequery!= null && _wherequery.length()>0) { 
 //BA.debugLineNum = 424;BA.debugLine="qsb.Append(\"and \"&whereQuery&\" \")";
_qsb.Append("and "+_wherequery+" ");
 };
 //BA.debugLineNum = 426;BA.debugLine="Dim query As String=qsb.ToString";
_query = _qsb.ToString();
 //BA.debugLineNum = 427;BA.debugLine="G.mLog(\"PaginationTotalSize:\"&query)";
_g._mlog("PaginationTotalSize:"+_query);
 //BA.debugLineNum = 428;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4j.objects.SQL.ResultSetWrapper();
 //BA.debugLineNum = 429;BA.debugLine="If args<>Null Then";
if (_args!= null) { 
 //BA.debugLineNum = 430;BA.debugLine="cur=SQL.ExecQuery2(query,args)";
_cur = _sql.ExecQuery2(_query,anywheresoftware.b4a.keywords.Common.ArrayToList(_args));
 }else {
 //BA.debugLineNum = 432;BA.debugLine="cur=SQL.ExecQuery(query)";
_cur = _sql.ExecQuery(_query);
 };
 //BA.debugLineNum = 434;BA.debugLine="Try";
try { //BA.debugLineNum = 435;BA.debugLine="cur.NextRow";
_cur.NextRow();
 //BA.debugLineNum = 436;BA.debugLine="Return cur.GetInt(\"cnt\")";
if (true) return _cur.GetInt("cnt");
 } 
       catch (Exception e20) {
			ba.setLastException(e20); //BA.debugLineNum = 438;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 //BA.debugLineNum = 439;BA.debugLine="Return 0";
if (true) return (int) (0);
 };
 //BA.debugLineNum = 441;BA.debugLine="End Sub";
return 0;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Type dbOptret (success As Boolean,msg As String)";
;
 //BA.debugLineNum = 4;BA.debugLine="Public conpool As ConnectionPool";
_conpool = new anywheresoftware.b4j.object.ConnectionPool();
 //BA.debugLineNum = 5;BA.debugLine="Private curDbType As Int=0";
_curdbtype = (int) (0);
 //BA.debugLineNum = 6;BA.debugLine="Public DB_REAL, DB_INTEGER, DB_BLOB, DB_TEXT As S";
_db_real = "";
_db_integer = "";
_db_blob = "";
_db_text = "";
 //BA.debugLineNum = 7;BA.debugLine="DB_REAL = \"REAL\"";
_db_real = "REAL";
 //BA.debugLineNum = 8;BA.debugLine="DB_INTEGER = \"INTEGER\"";
_db_integer = "INTEGER";
 //BA.debugLineNum = 9;BA.debugLine="DB_BLOB = \"BLOB\"";
_db_blob = "BLOB";
 //BA.debugLineNum = 10;BA.debugLine="DB_TEXT = \"TEXT\"";
_db_text = "TEXT";
 //BA.debugLineNum = 11;BA.debugLine="Dim HtmlCSS As String = \"table {width: 100%;borde";
_htmlcss = "table {width: 100%;border: 1px solid #cef;text-align: left; }"+" th { font-weight: bold;	background-color: #acf;	border-bottom: 1px solid #cef; }"+"td,th {	padding: 4px 5px; }"+".odd {background-color: #def; } .odd td {border-bottom: 1px solid #cef; }"+"a { text-decoration:none; color: #000;}";
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.List  _querylist(anywheresoftware.b4j.objects.SQL _sql,String _query,Object[] _stringargs,int _limit) throws Exception{
 //BA.debugLineNum = 493;BA.debugLine="Public Sub QueryList(SQL As SQL, Query As String,";
 //BA.debugLineNum = 494;BA.debugLine="Return ExecuteMemoryTable(SQL, Query, StringArgs,";
if (true) return _executememorytable(_sql,_query,_stringargs,_limit);
 //BA.debugLineNum = 495;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _querylist2(anywheresoftware.b4j.objects.SQL _sql,String _tablename,String _fields,anywheresoftware.b4a.objects.collections.Map _wherefieldequals,int _limit) throws Exception{
 //BA.debugLineNum = 496;BA.debugLine="Public Sub QueryList2(SQL As SQL, tablename As Str";
 //BA.debugLineNum = 497;BA.debugLine="Return ExecuteMemoryTable2(SQL,tablename,fields,W";
if (true) return _executememorytable2(_sql,_tablename,_fields,_wherefieldequals,_limit);
 //BA.debugLineNum = 498;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.Map  _queryone(anywheresoftware.b4j.objects.SQL _sql,String _query,Object[] _stringargs) throws Exception{
 //BA.debugLineNum = 490;BA.debugLine="Public Sub QueryOne(SQL As SQL, Query As String, S";
 //BA.debugLineNum = 491;BA.debugLine="Return ExecuteMap(SQL,Query,StringArgs)";
if (true) return _executemap(_sql,_query,_stringargs);
 //BA.debugLineNum = 492;BA.debugLine="End Sub";
return null;
}
public static String  _replacemap(anywheresoftware.b4j.objects.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.Map _map) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _values = null;
anywheresoftware.b4a.objects.collections.List _listofvalues = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
int _i2 = 0;
String _col = "";
Object _value = null;
 //BA.debugLineNum = 156;BA.debugLine="Public Sub ReplaceMap(SQL As SQL, TableName As Str";
 //BA.debugLineNum = 157;BA.debugLine="Dim sb,  values As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_values = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 159;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 161;BA.debugLine="values.Initialize";
_values.Initialize();
 //BA.debugLineNum = 162;BA.debugLine="Dim listOfValues As List";
_listofvalues = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 163;BA.debugLine="listOfValues.Initialize";
_listofvalues.Initialize();
 //BA.debugLineNum = 164;BA.debugLine="sb.Append(\"REPLACE INTO \" & EscapeField(TableName";
_sb.Append("REPLACE INTO "+_escapefield(_tablename)+" ");
 //BA.debugLineNum = 165;BA.debugLine="Dim m As Map=map";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = _map;
 //BA.debugLineNum = 167;BA.debugLine="For i2 = 0 To m.Size - 1";
{
final int step8 = 1;
final int limit8 = (int) (_m.getSize()-1);
_i2 = (int) (0) ;
for (;(step8 > 0 && _i2 <= limit8) || (step8 < 0 && _i2 >= limit8) ;_i2 = ((int)(0 + _i2 + step8))  ) {
 //BA.debugLineNum = 168;BA.debugLine="Dim col As String";
_col = "";
 //BA.debugLineNum = 169;BA.debugLine="Dim value As Object";
_value = new Object();
 //BA.debugLineNum = 170;BA.debugLine="col = m.GetKeyAt(i2)";
_col = BA.ObjectToString(_m.GetKeyAt(_i2));
 //BA.debugLineNum = 171;BA.debugLine="value = m.GetValueAt(i2)";
_value = _m.GetValueAt(_i2);
 //BA.debugLineNum = 172;BA.debugLine="If i2 > 0 Then";
if (_i2>0) { 
 //BA.debugLineNum = 174;BA.debugLine="values.Append(\", \")";
_values.Append(", ");
 };
 //BA.debugLineNum = 178;BA.debugLine="values.Append(\"?\")";
_values.Append("?");
 //BA.debugLineNum = 179;BA.debugLine="listOfValues.Add(value)";
_listofvalues.Add(_value);
 }
};
 //BA.debugLineNum = 182;BA.debugLine="sb.Append(\" VALUES (\")";
_sb.Append(" VALUES (");
 //BA.debugLineNum = 183;BA.debugLine="sb.Append(values.ToString)";
_sb.Append(_values.ToString());
 //BA.debugLineNum = 184;BA.debugLine="sb.Append(\")\")";
_sb.Append(")");
 //BA.debugLineNum = 185;BA.debugLine="Log(\"ReplaceMap: \" & sb.ToString)";
anywheresoftware.b4a.keywords.Common.Log("ReplaceMap: "+_sb.ToString());
 //BA.debugLineNum = 186;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, listOfValues)";
_sql.ExecNonQuery2(_sb.ToString(),_listofvalues);
 //BA.debugLineNum = 187;BA.debugLine="End Sub";
return "";
}
public static String  _setdbtype(int _dbt) throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Public Sub setDbType(dbt As Int)";
 //BA.debugLineNum = 35;BA.debugLine="curDbType=dbt";
_curdbtype = _dbt;
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static String  _updaterecord(anywheresoftware.b4j.objects.SQL _sql,String _tablename,String _field,Object _newvalue,anywheresoftware.b4a.objects.collections.Map _wherefieldequals) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.collections.List _args = null;
int _i = 0;
 //BA.debugLineNum = 196;BA.debugLine="Public Sub UpdateRecord(SQL As SQL, TableName As S";
 //BA.debugLineNum = 198;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 199;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 200;BA.debugLine="sb.Append(\"UPDATE \").Append(EscapeField(TableName";
_sb.Append("UPDATE ").Append(_escapefield(_tablename)).Append(" SET ").Append(_escapefield(_field)).Append(" = ? WHERE ");
 //BA.debugLineNum = 202;BA.debugLine="If WhereFieldEquals.Size = 0 Then";
if (_wherefieldequals.getSize()==0) { 
 //BA.debugLineNum = 203;BA.debugLine="g.mLog(\"WhereFieldEquals map empty!\")";
_g._mlog("WhereFieldEquals map empty!");
 //BA.debugLineNum = 204;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 206;BA.debugLine="Dim args As List";
_args = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 207;BA.debugLine="args.Initialize";
_args.Initialize();
 //BA.debugLineNum = 208;BA.debugLine="args.Add(NewValue)";
_args.Add(_newvalue);
 //BA.debugLineNum = 209;BA.debugLine="For i = 0 To WhereFieldEquals.Size - 1";
{
final int step11 = 1;
final int limit11 = (int) (_wherefieldequals.getSize()-1);
_i = (int) (0) ;
for (;(step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11) ;_i = ((int)(0 + _i + step11))  ) {
 //BA.debugLineNum = 210;BA.debugLine="If i > 0 Then sb.Append(\" AND \")";
if (_i>0) { 
_sb.Append(" AND ");};
 //BA.debugLineNum = 211;BA.debugLine="sb.Append(EscapeField(WhereFieldEquals.GetKeyAt(";
_sb.Append(_escapefield(BA.ObjectToString(_wherefieldequals.GetKeyAt(_i)))).Append(" = ?");
 //BA.debugLineNum = 212;BA.debugLine="args.Add(WhereFieldEquals.GetValueAt(i))";
_args.Add(_wherefieldequals.GetValueAt(_i));
 }
};
 //BA.debugLineNum = 214;BA.debugLine="g.mLog(\"UpdateRecord: \" & sb.ToString)";
_g._mlog("UpdateRecord: "+_sb.ToString());
 //BA.debugLineNum = 215;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, args)";
_sql.ExecNonQuery2(_sb.ToString(),_args);
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
return "";
}
public static String  _updaterecord2(anywheresoftware.b4j.objects.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.Map _fields,anywheresoftware.b4a.objects.collections.Map _wherefieldequals) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.collections.List _args = null;
int _i = 0;
 //BA.debugLineNum = 220;BA.debugLine="Public Sub UpdateRecord2(SQL As SQL, TableName As";
 //BA.debugLineNum = 221;BA.debugLine="If WhereFieldEquals.Size = 0 Then";
if (_wherefieldequals.getSize()==0) { 
 //BA.debugLineNum = 222;BA.debugLine="g.mLog(\"WhereFieldEquals map empty!\")";
_g._mlog("WhereFieldEquals map empty!");
 //BA.debugLineNum = 223;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 225;BA.debugLine="If Fields.Size = 0 Then";
if (_fields.getSize()==0) { 
 //BA.debugLineNum = 226;BA.debugLine="g.mLog(\"Fields empty\")";
_g._mlog("Fields empty");
 //BA.debugLineNum = 227;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 229;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 230;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 231;BA.debugLine="sb.Append(\"UPDATE \").Append(EscapeField(TableName";
_sb.Append("UPDATE ").Append(_escapefield(_tablename)).Append(" SET ");
 //BA.debugLineNum = 232;BA.debugLine="Dim args As List";
_args = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 233;BA.debugLine="args.Initialize";
_args.Initialize();
 //BA.debugLineNum = 234;BA.debugLine="For i=0 To Fields.Size-1";
{
final int step14 = 1;
final int limit14 = (int) (_fields.getSize()-1);
_i = (int) (0) ;
for (;(step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14) ;_i = ((int)(0 + _i + step14))  ) {
 //BA.debugLineNum = 235;BA.debugLine="If i<>Fields.Size-1 Then";
if (_i!=_fields.getSize()-1) { 
 //BA.debugLineNum = 236;BA.debugLine="sb.Append(EscapeField(Fields.GetKeyAt(i))).Appe";
_sb.Append(_escapefield(BA.ObjectToString(_fields.GetKeyAt(_i)))).Append("=?,");
 }else {
 //BA.debugLineNum = 238;BA.debugLine="sb.Append(EscapeField(Fields.GetKeyAt(i))).Appe";
_sb.Append(_escapefield(BA.ObjectToString(_fields.GetKeyAt(_i)))).Append("=?");
 };
 //BA.debugLineNum = 240;BA.debugLine="args.Add(Fields.GetValueAt(i))";
_args.Add(_fields.GetValueAt(_i));
 }
};
 //BA.debugLineNum = 243;BA.debugLine="sb.Append(\" WHERE \")";
_sb.Append(" WHERE ");
 //BA.debugLineNum = 244;BA.debugLine="For i = 0 To WhereFieldEquals.Size - 1";
{
final int step23 = 1;
final int limit23 = (int) (_wherefieldequals.getSize()-1);
_i = (int) (0) ;
for (;(step23 > 0 && _i <= limit23) || (step23 < 0 && _i >= limit23) ;_i = ((int)(0 + _i + step23))  ) {
 //BA.debugLineNum = 245;BA.debugLine="If i > 0 Then";
if (_i>0) { 
 //BA.debugLineNum = 246;BA.debugLine="sb.Append(\" AND \")";
_sb.Append(" AND ");
 };
 //BA.debugLineNum = 248;BA.debugLine="sb.Append(EscapeField(WhereFieldEquals.GetKeyAt(";
_sb.Append(_escapefield(BA.ObjectToString(_wherefieldequals.GetKeyAt(_i)))).Append(" = ?");
 //BA.debugLineNum = 249;BA.debugLine="args.Add(WhereFieldEquals.GetValueAt(i))";
_args.Add(_wherefieldequals.GetValueAt(_i));
 }
};
 //BA.debugLineNum = 251;BA.debugLine="g.mLog(\"UpdateRecord: \" & sb.ToString)";
_g._mlog("UpdateRecord: "+_sb.ToString());
 //BA.debugLineNum = 252;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, args)";
_sql.ExecNonQuery2(_sb.ToString(),_args);
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
}
