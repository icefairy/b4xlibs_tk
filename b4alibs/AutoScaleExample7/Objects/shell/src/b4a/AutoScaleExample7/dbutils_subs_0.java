package b4a.AutoScaleExample7;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class dbutils_subs_0 {


public static RemoteObject  _copydbfromassets(RemoteObject _ba,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("CopyDBFromAssets (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,30);
if (RapidSub.canDelegate("copydbfromassets")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","copydbfromassets", _ba, _filename);
RemoteObject _targetdir = RemoteObject.createImmutable("");
;
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 30;BA.debugLine="Sub CopyDBFromAssets (FileName As String) As Strin";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="Dim TargetDir As String";
Debug.ShouldStop(1073741824);
_targetdir = RemoteObject.createImmutable("");Debug.locals.put("TargetDir", _targetdir);
 BA.debugLineNum = 32;BA.debugLine="If File.ExternalWritable Then TargetDir = File.Di";
Debug.ShouldStop(-2147483648);
if (dbutils.mostCurrent.__c.getField(false,"File").runMethod(true,"getExternalWritable").<Boolean>get().booleanValue()) { 
_targetdir = dbutils.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal");Debug.locals.put("TargetDir", _targetdir);}
else {
_targetdir = dbutils.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");Debug.locals.put("TargetDir", _targetdir);};
 BA.debugLineNum = 33;BA.debugLine="If File.Exists(TargetDir, FileName) = False Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",dbutils.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(_targetdir),(Object)(_filename)),dbutils.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 34;BA.debugLine="File.Copy(File.DirAssets, FileName, TargetDir, F";
Debug.ShouldStop(2);
dbutils.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(dbutils.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_filename),(Object)(_targetdir),(Object)(_filename));
 };
 BA.debugLineNum = 36;BA.debugLine="Return TargetDir";
Debug.ShouldStop(8);
if (true) return _targetdir;
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createtable(RemoteObject _ba,RemoteObject _sql,RemoteObject _tablename,RemoteObject _fieldsandtypes,RemoteObject _primarykey) throws Exception{
try {
		Debug.PushSubsStack("CreateTable (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,43);
if (RapidSub.canDelegate("createtable")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","createtable", _ba, _sql, _tablename, _fieldsandtypes, _primarykey);
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i = 0;
RemoteObject _field = RemoteObject.createImmutable("");
RemoteObject _ftype = RemoteObject.createImmutable("");
RemoteObject _query = RemoteObject.createImmutable("");
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("TableName", _tablename);
Debug.locals.put("FieldsAndTypes", _fieldsandtypes);
Debug.locals.put("PrimaryKey", _primarykey);
 BA.debugLineNum = 43;BA.debugLine="Sub CreateTable(SQL As SQL, TableName As String, F";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(2048);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 45;BA.debugLine="sb.Initialize";
Debug.ShouldStop(4096);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 46;BA.debugLine="sb.Append(\"(\")";
Debug.ShouldStop(8192);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("(")));
 BA.debugLineNum = 47;BA.debugLine="For i = 0 To FieldsAndTypes.Size - 1";
Debug.ShouldStop(16384);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_fieldsandtypes.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 48;BA.debugLine="Dim field, ftype As String";
Debug.ShouldStop(32768);
_field = RemoteObject.createImmutable("");Debug.locals.put("field", _field);
_ftype = RemoteObject.createImmutable("");Debug.locals.put("ftype", _ftype);
 BA.debugLineNum = 49;BA.debugLine="field = FieldsAndTypes.GetKeyAt(i)";
Debug.ShouldStop(65536);
_field = BA.ObjectToString(_fieldsandtypes.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("field", _field);
 BA.debugLineNum = 50;BA.debugLine="ftype = FieldsAndTypes.GetValueAt(i)";
Debug.ShouldStop(131072);
_ftype = BA.ObjectToString(_fieldsandtypes.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("ftype", _ftype);
 BA.debugLineNum = 51;BA.debugLine="If i > 0 Then sb.Append(\", \")";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(", ")));};
 BA.debugLineNum = 52;BA.debugLine="sb.Append(\"[\").Append(field).Append(\"] \").Append";
Debug.ShouldStop(524288);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("["))).runMethod(false,"Append",(Object)(_field)).runMethod(false,"Append",(Object)(RemoteObject.createImmutable("] "))).runVoidMethod ("Append",(Object)(_ftype));
 BA.debugLineNum = 53;BA.debugLine="If field = PrimaryKey Then sb.Append(\" PRIMARY K";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_field,_primarykey)) { 
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" PRIMARY KEY")));};
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 55;BA.debugLine="sb.Append(\")\")";
Debug.ShouldStop(4194304);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(")")));
 BA.debugLineNum = 56;BA.debugLine="Dim query As String";
Debug.ShouldStop(8388608);
_query = RemoteObject.createImmutable("");Debug.locals.put("query", _query);
 BA.debugLineNum = 57;BA.debugLine="query = \"CREATE TABLE IF NOT EXISTS [\" & TableNam";
Debug.ShouldStop(16777216);
_query = RemoteObject.concat(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS ["),_tablename,RemoteObject.createImmutable("] "),_sb.runMethod(true,"ToString"));Debug.locals.put("query", _query);
 BA.debugLineNum = 58;BA.debugLine="Log(\"CreateTable: \" & query)";
Debug.ShouldStop(33554432);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("CreateTable: "),_query)));
 BA.debugLineNum = 59;BA.debugLine="SQL.ExecNonQuery(query)";
Debug.ShouldStop(67108864);
_sql.runVoidMethod ("ExecNonQuery",(Object)(_query));
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _deleterecord(RemoteObject _ba,RemoteObject _sql,RemoteObject _tablename,RemoteObject _wherefieldequals) throws Exception{
try {
		Debug.PushSubsStack("DeleteRecord (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,456);
if (RapidSub.canDelegate("deleterecord")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","deleterecord", _ba, _sql, _tablename, _wherefieldequals);
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _args = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("TableName", _tablename);
Debug.locals.put("WhereFieldEquals", _wherefieldequals);
 BA.debugLineNum = 456;BA.debugLine="Sub DeleteRecord(SQL As SQL, TableName As String,";
Debug.ShouldStop(128);
 BA.debugLineNum = 457;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(256);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 458;BA.debugLine="sb.Initialize";
Debug.ShouldStop(512);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 459;BA.debugLine="sb.Append(\"DELETE FROM [\").Append(TableName).A";
Debug.ShouldStop(1024);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("DELETE FROM ["))).runMethod(false,"Append",(Object)(_tablename)).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("] WHERE ")));
 BA.debugLineNum = 460;BA.debugLine="If WhereFieldEquals.Size = 0 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_wherefieldequals.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 461;BA.debugLine="Log(\"WhereFieldEquals map empty!\")";
Debug.ShouldStop(4096);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("WhereFieldEquals map empty!")));
 BA.debugLineNum = 462;BA.debugLine="Return";
Debug.ShouldStop(8192);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 464;BA.debugLine="Dim args As List";
Debug.ShouldStop(32768);
_args = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("args", _args);
 BA.debugLineNum = 465;BA.debugLine="args.Initialize";
Debug.ShouldStop(65536);
_args.runVoidMethod ("Initialize");
 BA.debugLineNum = 466;BA.debugLine="For i = 0 To WhereFieldEquals.Size - 1";
Debug.ShouldStop(131072);
{
final int step10 = 1;
final int limit10 = RemoteObject.solve(new RemoteObject[] {_wherefieldequals.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 467;BA.debugLine="If i > 0 Then sb.Append(\" AND \")";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" AND ")));};
 BA.debugLineNum = 468;BA.debugLine="sb.Append(\"[\").Append(WhereFieldEquals.Get";
Debug.ShouldStop(524288);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("["))).runMethod(false,"Append",(Object)(BA.ObjectToString(_wherefieldequals.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("] = ?")));
 BA.debugLineNum = 469;BA.debugLine="args.Add(WhereFieldEquals.GetValueAt(i))";
Debug.ShouldStop(1048576);
_args.runVoidMethod ("Add",(Object)(_wherefieldequals.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 471;BA.debugLine="Log(\"DeleteRecord: \" & sb.ToString)";
Debug.ShouldStop(4194304);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DeleteRecord: "),_sb.runMethod(true,"ToString"))));
 BA.debugLineNum = 472;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, args)";
Debug.ShouldStop(8388608);
_sql.runVoidMethod ("ExecNonQuery2",(Object)(_sb.runMethod(true,"ToString")),(Object)(_args));
 BA.debugLineNum = 473;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _droptable(RemoteObject _ba,RemoteObject _sql,RemoteObject _tablename) throws Exception{
try {
		Debug.PushSubsStack("DropTable (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,63);
if (RapidSub.canDelegate("droptable")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","droptable", _ba, _sql, _tablename);
RemoteObject _query = RemoteObject.createImmutable("");
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("TableName", _tablename);
 BA.debugLineNum = 63;BA.debugLine="Sub DropTable(SQL As SQL, TableName As String)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 64;BA.debugLine="Dim query As String";
Debug.ShouldStop(-2147483648);
_query = RemoteObject.createImmutable("");Debug.locals.put("query", _query);
 BA.debugLineNum = 65;BA.debugLine="query = \"DROP TABLE IF EXISTS [\" & TableName & \"]";
Debug.ShouldStop(1);
_query = RemoteObject.concat(RemoteObject.createImmutable("DROP TABLE IF EXISTS ["),_tablename,RemoteObject.createImmutable("]"));Debug.locals.put("query", _query);
 BA.debugLineNum = 66;BA.debugLine="Log(\"DropTable: \" & query)";
Debug.ShouldStop(2);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DropTable: "),_query)));
 BA.debugLineNum = 67;BA.debugLine="SQL.ExecNonQuery(query)";
Debug.ShouldStop(4);
_sql.runVoidMethod ("ExecNonQuery",(Object)(_query));
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executehtml(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs,RemoteObject _limit,RemoteObject _clickable) throws Exception{
try {
		Debug.PushSubsStack("ExecuteHtml (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,311);
if (RapidSub.canDelegate("executehtml")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","executehtml", _ba, _sql, _query, _stringargs, _limit, _clickable);
RemoteObject _table = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i = 0;
int _row = 0;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
Debug.locals.put("Limit", _limit);
Debug.locals.put("Clickable", _clickable);
 BA.debugLineNum = 311;BA.debugLine="Sub ExecuteHtml(SQL As SQL, Query As String, Strin";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 312;BA.debugLine="Dim Table As List";
Debug.ShouldStop(8388608);
_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("Table", _table);
 BA.debugLineNum = 313;BA.debugLine="Dim cur As Cursor";
Debug.ShouldStop(16777216);
_cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cur", _cur);
 BA.debugLineNum = 314;BA.debugLine="If StringArgs <> Null Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("N",_stringargs)) { 
 BA.debugLineNum = 315;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
Debug.ShouldStop(67108864);
_cur.setObject(_sql.runMethod(false,"ExecQuery2",(Object)(_query),(Object)(_stringargs)));
 }else {
 BA.debugLineNum = 317;BA.debugLine="cur = SQL.ExecQuery(Query)";
Debug.ShouldStop(268435456);
_cur.setObject(_sql.runMethod(false,"ExecQuery",(Object)(_query)));
 };
 BA.debugLineNum = 319;BA.debugLine="Log(\"ExecuteHtml: \" & Query)";
Debug.ShouldStop(1073741824);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("ExecuteHtml: "),_query)));
 BA.debugLineNum = 320;BA.debugLine="If Limit > 0 Then Limit = Min(Limit, cur.RowCount";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean(">",_limit,BA.numberCast(double.class, 0))) { 
_limit = BA.numberCast(int.class, dbutils.mostCurrent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, _limit)),(Object)(BA.numberCast(double.class, _cur.runMethod(true,"getRowCount")))));Debug.locals.put("Limit", _limit);}
else {
_limit = _cur.runMethod(true,"getRowCount");Debug.locals.put("Limit", _limit);};
 BA.debugLineNum = 321;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(1);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 322;BA.debugLine="sb.Initialize";
Debug.ShouldStop(2);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 323;BA.debugLine="sb.Append(\"<html><body>\").Append(CRLF)";
Debug.ShouldStop(4);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<html><body>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 324;BA.debugLine="sb.Append(\"<style type='text/css'>\").Append(HtmlC";
Debug.ShouldStop(8);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<style type='text/css'>"))).runMethod(false,"Append",(Object)(dbutils._htmlcss)).runMethod(false,"Append",(Object)(RemoteObject.createImmutable("</style>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 325;BA.debugLine="sb.Append(\"<table><tr>\").Append(CRLF)";
Debug.ShouldStop(16);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<table><tr>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 326;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
Debug.ShouldStop(32);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 327;BA.debugLine="sb.Append(\"<th>\").Append(cur.GetColumnName(i)).A";
Debug.ShouldStop(64);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<th>"))).runMethod(false,"Append",(Object)(_cur.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _i))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</th>")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 338;BA.debugLine="sb.Append(\"</tr>\").Append(CRLF)";
Debug.ShouldStop(131072);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("</tr>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 339;BA.debugLine="For row = 0 To Limit - 1";
Debug.ShouldStop(262144);
{
final int step19 = 1;
final int limit19 = RemoteObject.solve(new RemoteObject[] {_limit,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_row = 0 ;
for (;(step19 > 0 && _row <= limit19) || (step19 < 0 && _row >= limit19) ;_row = ((int)(0 + _row + step19))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 340;BA.debugLine="cur.Position = row";
Debug.ShouldStop(524288);
_cur.runMethod(true,"setPosition",BA.numberCast(int.class, _row));
 BA.debugLineNum = 341;BA.debugLine="If row Mod 2 = 0 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_row),RemoteObject.createImmutable(2)}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 342;BA.debugLine="sb.Append(\"<tr>\")";
Debug.ShouldStop(2097152);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr>")));
 }else {
 BA.debugLineNum = 344;BA.debugLine="sb.Append(\"<tr class='odd'>\")";
Debug.ShouldStop(8388608);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr class='odd'>")));
 };
 BA.debugLineNum = 346;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
Debug.ShouldStop(33554432);
{
final int step26 = 1;
final int limit26 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step26 > 0 && _i <= limit26) || (step26 < 0 && _i >= limit26) ;_i = ((int)(0 + _i + step26))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 347;BA.debugLine="sb.Append(\"<td>\")";
Debug.ShouldStop(67108864);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td>")));
 BA.debugLineNum = 348;BA.debugLine="If Clickable Then";
Debug.ShouldStop(134217728);
if (_clickable.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 349;BA.debugLine="sb.Append(\"<a href='http://\").Append(i).Append";
Debug.ShouldStop(268435456);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<a href='http://"))).runMethod(false,"Append",(Object)(BA.NumberToString(_i))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(".")));
 BA.debugLineNum = 350;BA.debugLine="sb.Append(row)";
Debug.ShouldStop(536870912);
_sb.runVoidMethod ("Append",(Object)(BA.NumberToString(_row)));
 BA.debugLineNum = 351;BA.debugLine="sb.Append(\".com'>\").Append(cur.GetString2(i)).";
Debug.ShouldStop(1073741824);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable(".com'>"))).runMethod(false,"Append",(Object)(_cur.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _i))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</a>")));
 }else {
 BA.debugLineNum = 353;BA.debugLine="sb.Append(cur.GetString2(i))";
Debug.ShouldStop(1);
_sb.runVoidMethod ("Append",(Object)(_cur.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _i)))));
 };
 BA.debugLineNum = 355;BA.debugLine="sb.Append(\"</td>\")";
Debug.ShouldStop(4);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 357;BA.debugLine="sb.Append(\"</tr>\").Append(CRLF)";
Debug.ShouldStop(16);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("</tr>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 }
}Debug.locals.put("row", _row);
;
 BA.debugLineNum = 359;BA.debugLine="cur.Close";
Debug.ShouldStop(64);
_cur.runVoidMethod ("Close");
 BA.debugLineNum = 360;BA.debugLine="sb.Append(\"</table></body></html>\")";
Debug.ShouldStop(128);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</table></body></html>")));
 BA.debugLineNum = 361;BA.debugLine="Return sb.ToString";
Debug.ShouldStop(256);
if (true) return _sb.runMethod(true,"ToString");
 BA.debugLineNum = 362;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executehtml2(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs,RemoteObject _limit,RemoteObject _clickable,RemoteObject _textsize) throws Exception{
try {
		Debug.PushSubsStack("ExecuteHtml2 (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,367);
if (RapidSub.canDelegate("executehtml2")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","executehtml2", _ba, _sql, _query, _stringargs, _limit, _clickable, _textsize);
RemoteObject _table = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _htmlcss2 = RemoteObject.createImmutable("");
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i = 0;
int _row = 0;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
Debug.locals.put("Limit", _limit);
Debug.locals.put("Clickable", _clickable);
Debug.locals.put("TextSize", _textsize);
 BA.debugLineNum = 367;BA.debugLine="Sub ExecuteHtml2(SQL As SQL, Query As String, Stri";
Debug.ShouldStop(16384);
 BA.debugLineNum = 368;BA.debugLine="Dim Table As List";
Debug.ShouldStop(32768);
_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("Table", _table);
 BA.debugLineNum = 369;BA.debugLine="Dim cur As Cursor";
Debug.ShouldStop(65536);
_cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cur", _cur);
 BA.debugLineNum = 370;BA.debugLine="Dim HtmlCSS2 As String";
Debug.ShouldStop(131072);
_htmlcss2 = RemoteObject.createImmutable("");Debug.locals.put("HtmlCSS2", _htmlcss2);
 BA.debugLineNum = 372;BA.debugLine="HtmlCSS2 = \"table {width: 100%;border: 1px solid";
Debug.ShouldStop(524288);
_htmlcss2 = RemoteObject.concat(RemoteObject.createImmutable("table {width: 100%;border: 1px solid #cef;text-align: left; }"),RemoteObject.createImmutable(" th { font-size:"),_textsize,RemoteObject.createImmutable("px; font-weight: bold;	background-color: #acf;	border-bottom: 1px solid #cef; }"),RemoteObject.createImmutable("td,th {	padding: 4px 5px; }"),RemoteObject.createImmutable(".odd {background-color: #def; } .odd td {border-bottom: 1px solid #cef; }"),RemoteObject.createImmutable("a { font-size:"),_textsize,RemoteObject.createImmutable("px; text-decoration:none; color: #000;}"));Debug.locals.put("HtmlCSS2", _htmlcss2);
 BA.debugLineNum = 378;BA.debugLine="If StringArgs <> Null Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("N",_stringargs)) { 
 BA.debugLineNum = 379;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
Debug.ShouldStop(67108864);
_cur.setObject(_sql.runMethod(false,"ExecQuery2",(Object)(_query),(Object)(_stringargs)));
 }else {
 BA.debugLineNum = 381;BA.debugLine="cur = SQL.ExecQuery(Query)";
Debug.ShouldStop(268435456);
_cur.setObject(_sql.runMethod(false,"ExecQuery",(Object)(_query)));
 };
 BA.debugLineNum = 383;BA.debugLine="Log(\"ExecuteHtml: \" & Query)";
Debug.ShouldStop(1073741824);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("ExecuteHtml: "),_query)));
 BA.debugLineNum = 384;BA.debugLine="If Limit > 0 Then Limit = Min(Limit, cur.RowCount";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean(">",_limit,BA.numberCast(double.class, 0))) { 
_limit = BA.numberCast(int.class, dbutils.mostCurrent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, _limit)),(Object)(BA.numberCast(double.class, _cur.runMethod(true,"getRowCount")))));Debug.locals.put("Limit", _limit);}
else {
_limit = _cur.runMethod(true,"getRowCount");Debug.locals.put("Limit", _limit);};
 BA.debugLineNum = 385;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(1);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 386;BA.debugLine="sb.Initialize";
Debug.ShouldStop(2);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 387;BA.debugLine="sb.Append(\"<html><body>\").Append(CRLF)";
Debug.ShouldStop(4);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<html><body>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 388;BA.debugLine="sb.Append(\"<style type='text/css'>\").Append(HtmlC";
Debug.ShouldStop(8);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<style type='text/css'>"))).runMethod(false,"Append",(Object)(_htmlcss2)).runMethod(false,"Append",(Object)(RemoteObject.createImmutable("</style>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 389;BA.debugLine="sb.Append(\"<table><tr>\").Append(CRLF)";
Debug.ShouldStop(16);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<table><tr>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 390;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
Debug.ShouldStop(32);
{
final int step17 = 1;
final int limit17 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step17 > 0 && _i <= limit17) || (step17 < 0 && _i >= limit17) ;_i = ((int)(0 + _i + step17))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 391;BA.debugLine="sb.Append(\"<th>\").Append(cur.GetColumnName(i)).A";
Debug.ShouldStop(64);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<th>"))).runMethod(false,"Append",(Object)(_cur.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _i))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</th>")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 402;BA.debugLine="sb.Append(\"</tr>\").Append(CRLF)";
Debug.ShouldStop(131072);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("</tr>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 403;BA.debugLine="For row = 0 To Limit - 1";
Debug.ShouldStop(262144);
{
final int step21 = 1;
final int limit21 = RemoteObject.solve(new RemoteObject[] {_limit,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_row = 0 ;
for (;(step21 > 0 && _row <= limit21) || (step21 < 0 && _row >= limit21) ;_row = ((int)(0 + _row + step21))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 404;BA.debugLine="cur.Position = row";
Debug.ShouldStop(524288);
_cur.runMethod(true,"setPosition",BA.numberCast(int.class, _row));
 BA.debugLineNum = 405;BA.debugLine="If row Mod 2 = 0 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_row),RemoteObject.createImmutable(2)}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 406;BA.debugLine="sb.Append(\"<tr>\")";
Debug.ShouldStop(2097152);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr>")));
 }else {
 BA.debugLineNum = 408;BA.debugLine="sb.Append(\"<tr class='odd'>\")";
Debug.ShouldStop(8388608);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr class='odd'>")));
 };
 BA.debugLineNum = 410;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
Debug.ShouldStop(33554432);
{
final int step28 = 1;
final int limit28 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step28 > 0 && _i <= limit28) || (step28 < 0 && _i >= limit28) ;_i = ((int)(0 + _i + step28))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 411;BA.debugLine="sb.Append(\"<td>\")";
Debug.ShouldStop(67108864);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td>")));
 BA.debugLineNum = 412;BA.debugLine="If Clickable Then";
Debug.ShouldStop(134217728);
if (_clickable.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 413;BA.debugLine="sb.Append(\"<a href='http://\").Append(i).Append";
Debug.ShouldStop(268435456);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<a href='http://"))).runMethod(false,"Append",(Object)(BA.NumberToString(_i))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(".")));
 BA.debugLineNum = 414;BA.debugLine="sb.Append(row)";
Debug.ShouldStop(536870912);
_sb.runVoidMethod ("Append",(Object)(BA.NumberToString(_row)));
 BA.debugLineNum = 415;BA.debugLine="sb.Append(\".com'>\").Append(cur.GetString2(i)).";
Debug.ShouldStop(1073741824);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable(".com'>"))).runMethod(false,"Append",(Object)(_cur.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _i))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</a>")));
 }else {
 BA.debugLineNum = 417;BA.debugLine="sb.Append(cur.GetString2(i))";
Debug.ShouldStop(1);
_sb.runVoidMethod ("Append",(Object)(_cur.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _i)))));
 };
 BA.debugLineNum = 419;BA.debugLine="sb.Append(\"</td>\")";
Debug.ShouldStop(4);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 421;BA.debugLine="sb.Append(\"</tr>\").Append(CRLF)";
Debug.ShouldStop(16);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("</tr>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 }
}Debug.locals.put("row", _row);
;
 BA.debugLineNum = 423;BA.debugLine="cur.Close";
Debug.ShouldStop(64);
_cur.runVoidMethod ("Close");
 BA.debugLineNum = 424;BA.debugLine="sb.Append(\"</table></body></html>\")";
Debug.ShouldStop(128);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</table></body></html>")));
 BA.debugLineNum = 425;BA.debugLine="Return sb.ToString";
Debug.ShouldStop(256);
if (true) return _sb.runMethod(true,"ToString");
 BA.debugLineNum = 426;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executejson(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs,RemoteObject _limit,RemoteObject _dbtypes) throws Exception{
try {
		Debug.PushSubsStack("ExecuteJSON (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,272);
if (RapidSub.canDelegate("executejson")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","executejson", _ba, _sql, _query, _stringargs, _limit, _dbtypes);
RemoteObject _table = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _row = 0;
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
Debug.locals.put("Limit", _limit);
Debug.locals.put("DBTypes", _dbtypes);
 BA.debugLineNum = 272;BA.debugLine="Sub ExecuteJSON (SQL As SQL, Query As String, Stri";
Debug.ShouldStop(32768);
 BA.debugLineNum = 273;BA.debugLine="Dim table As List";
Debug.ShouldStop(65536);
_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("table", _table);
 BA.debugLineNum = 274;BA.debugLine="Dim cur As Cursor";
Debug.ShouldStop(131072);
_cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cur", _cur);
 BA.debugLineNum = 275;BA.debugLine="If StringArgs <> Null Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("N",_stringargs)) { 
 BA.debugLineNum = 276;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
Debug.ShouldStop(524288);
_cur.setObject(_sql.runMethod(false,"ExecQuery2",(Object)(_query),(Object)(_stringargs)));
 }else {
 BA.debugLineNum = 278;BA.debugLine="cur = SQL.ExecQuery(Query)";
Debug.ShouldStop(2097152);
_cur.setObject(_sql.runMethod(false,"ExecQuery",(Object)(_query)));
 };
 BA.debugLineNum = 280;BA.debugLine="Log(\"ExecuteJSON: \" & Query)";
Debug.ShouldStop(8388608);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("ExecuteJSON: "),_query)));
 BA.debugLineNum = 281;BA.debugLine="Dim table As List";
Debug.ShouldStop(16777216);
_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("table", _table);
 BA.debugLineNum = 282;BA.debugLine="table.Initialize";
Debug.ShouldStop(33554432);
_table.runVoidMethod ("Initialize");
 BA.debugLineNum = 283;BA.debugLine="If Limit > 0 Then Limit = Min(Limit, cur.RowCount";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean(">",_limit,BA.numberCast(double.class, 0))) { 
_limit = BA.numberCast(int.class, dbutils.mostCurrent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, _limit)),(Object)(BA.numberCast(double.class, _cur.runMethod(true,"getRowCount")))));Debug.locals.put("Limit", _limit);}
else {
_limit = _cur.runMethod(true,"getRowCount");Debug.locals.put("Limit", _limit);};
 BA.debugLineNum = 284;BA.debugLine="For row = 0 To Limit - 1";
Debug.ShouldStop(134217728);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {_limit,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_row = 0 ;
for (;(step12 > 0 && _row <= limit12) || (step12 < 0 && _row >= limit12) ;_row = ((int)(0 + _row + step12))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 285;BA.debugLine="cur.Position = row";
Debug.ShouldStop(268435456);
_cur.runMethod(true,"setPosition",BA.numberCast(int.class, _row));
 BA.debugLineNum = 286;BA.debugLine="Dim m As Map";
Debug.ShouldStop(536870912);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 287;BA.debugLine="m.Initialize";
Debug.ShouldStop(1073741824);
_m.runVoidMethod ("Initialize");
 BA.debugLineNum = 288;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
Debug.ShouldStop(-2147483648);
{
final int step16 = 1;
final int limit16 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step16 > 0 && _i <= limit16) || (step16 < 0 && _i >= limit16) ;_i = ((int)(0 + _i + step16))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 289;BA.debugLine="Select DBTypes.Get(i)";
Debug.ShouldStop(1);
switch (BA.switchObjectToInt(_dbtypes.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))),(dbutils._db_text),(dbutils._db_integer),(dbutils._db_real))) {
case 0: {
 BA.debugLineNum = 291;BA.debugLine="m.Put(cur.GetColumnName(i), cur.GetString2(i)";
Debug.ShouldStop(4);
_m.runVoidMethod ("Put",(Object)((_cur.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _i))))),(Object)((_cur.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _i))))));
 break; }
case 1: {
 BA.debugLineNum = 293;BA.debugLine="m.Put(cur.GetColumnName(i), cur.GetLong2(i))";
Debug.ShouldStop(16);
_m.runVoidMethod ("Put",(Object)((_cur.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _i))))),(Object)((_cur.runMethod(true,"GetLong2",(Object)(BA.numberCast(int.class, _i))))));
 break; }
case 2: {
 BA.debugLineNum = 295;BA.debugLine="m.Put(cur.GetColumnName(i), cur.GetDouble2(i)";
Debug.ShouldStop(64);
_m.runVoidMethod ("Put",(Object)((_cur.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _i))))),(Object)((_cur.runMethod(true,"GetDouble2",(Object)(BA.numberCast(int.class, _i))))));
 break; }
default: {
 BA.debugLineNum = 297;BA.debugLine="Log(\"Invalid type: \" & DBTypes.Get(i))";
Debug.ShouldStop(256);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Invalid type: "),_dbtypes.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))));
 break; }
}
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 300;BA.debugLine="table.Add(m)";
Debug.ShouldStop(2048);
_table.runVoidMethod ("Add",(Object)((_m.getObject())));
 }
}Debug.locals.put("row", _row);
;
 BA.debugLineNum = 302;BA.debugLine="cur.Close";
Debug.ShouldStop(8192);
_cur.runVoidMethod ("Close");
 BA.debugLineNum = 303;BA.debugLine="Dim root As Map";
Debug.ShouldStop(16384);
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("root", _root);
 BA.debugLineNum = 304;BA.debugLine="root.Initialize";
Debug.ShouldStop(32768);
_root.runVoidMethod ("Initialize");
 BA.debugLineNum = 305;BA.debugLine="root.Put(\"root\", table)";
Debug.ShouldStop(65536);
_root.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("root"))),(Object)((_table.getObject())));
 BA.debugLineNum = 306;BA.debugLine="Return root";
Debug.ShouldStop(131072);
if (true) return _root;
 BA.debugLineNum = 307;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executelistview(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs,RemoteObject _limit,RemoteObject _listview1,RemoteObject _twolines) throws Exception{
try {
		Debug.PushSubsStack("ExecuteListView (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,247);
if (RapidSub.canDelegate("executelistview")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","executelistview", _ba, _sql, _query, _stringargs, _limit, _listview1, _twolines);
RemoteObject _table = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cols = null;
int _i = 0;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
Debug.locals.put("Limit", _limit);
Debug.locals.put("ListView1", _listview1);
Debug.locals.put("TwoLines", _twolines);
 BA.debugLineNum = 247;BA.debugLine="Sub ExecuteListView(SQL As SQL, Query As String, S";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 249;BA.debugLine="ListView1.Clear";
Debug.ShouldStop(16777216);
_listview1.runVoidMethod ("Clear");
 BA.debugLineNum = 250;BA.debugLine="Dim Table As List";
Debug.ShouldStop(33554432);
_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("Table", _table);
 BA.debugLineNum = 251;BA.debugLine="Table = ExecuteMemoryTable(SQL, Query, StringArgs";
Debug.ShouldStop(67108864);
_table = _executememorytable(_ba,_sql,_query,_stringargs,_limit);Debug.locals.put("Table", _table);
 BA.debugLineNum = 252;BA.debugLine="Dim Cols() As String";
Debug.ShouldStop(134217728);
_cols = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("Cols", _cols);
 BA.debugLineNum = 253;BA.debugLine="For i = 0 To Table.Size - 1";
Debug.ShouldStop(268435456);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_table.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 254;BA.debugLine="Cols = Table.Get(i)";
Debug.ShouldStop(536870912);
_cols = (_table.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("Cols", _cols);
 BA.debugLineNum = 255;BA.debugLine="If TwoLines Then";
Debug.ShouldStop(1073741824);
if (_twolines.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 256;BA.debugLine="ListView1.AddTwoLines2(Cols(0), Cols(1), Cols)";
Debug.ShouldStop(-2147483648);
_listview1.runVoidMethod ("AddTwoLines2",(Object)(BA.ObjectToCharSequence(_cols.getArrayElement(true,BA.numberCast(int.class, 0)))),(Object)(BA.ObjectToCharSequence(_cols.getArrayElement(true,BA.numberCast(int.class, 1)))),(Object)((_cols)));
 }else {
 BA.debugLineNum = 258;BA.debugLine="ListView1.AddSingleLine2(Cols(0), Cols)";
Debug.ShouldStop(2);
_listview1.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(_cols.getArrayElement(true,BA.numberCast(int.class, 0)))),(Object)((_cols)));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 261;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executemap(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs) throws Exception{
try {
		Debug.PushSubsStack("ExecuteMap (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,209);
if (RapidSub.canDelegate("executemap")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","executemap", _ba, _sql, _query, _stringargs);
RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
 BA.debugLineNum = 209;BA.debugLine="Sub ExecuteMap(SQL As SQL, Query As String, String";
Debug.ShouldStop(65536);
 BA.debugLineNum = 210;BA.debugLine="Dim cur As Cursor";
Debug.ShouldStop(131072);
_cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cur", _cur);
 BA.debugLineNum = 211;BA.debugLine="If StringArgs <> Null Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("N",_stringargs)) { 
 BA.debugLineNum = 212;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
Debug.ShouldStop(524288);
_cur.setObject(_sql.runMethod(false,"ExecQuery2",(Object)(_query),(Object)(_stringargs)));
 }else {
 BA.debugLineNum = 214;BA.debugLine="cur = SQL.ExecQuery(Query)";
Debug.ShouldStop(2097152);
_cur.setObject(_sql.runMethod(false,"ExecQuery",(Object)(_query)));
 };
 BA.debugLineNum = 216;BA.debugLine="Log(\"ExecuteMap: \" & Query)";
Debug.ShouldStop(8388608);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("ExecuteMap: "),_query)));
 BA.debugLineNum = 217;BA.debugLine="If cur.RowCount = 0 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_cur.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 218;BA.debugLine="Log(\"No records found.\")";
Debug.ShouldStop(33554432);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("No records found.")));
 BA.debugLineNum = 219;BA.debugLine="Return Null";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), dbutils.mostCurrent.__c.getField(false,"Null"));
 };
 BA.debugLineNum = 221;BA.debugLine="Dim res As Map";
Debug.ShouldStop(268435456);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("res", _res);
 BA.debugLineNum = 222;BA.debugLine="res.Initialize";
Debug.ShouldStop(536870912);
_res.runVoidMethod ("Initialize");
 BA.debugLineNum = 223;BA.debugLine="cur.Position = 0";
Debug.ShouldStop(1073741824);
_cur.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 224;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
Debug.ShouldStop(-2147483648);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15) ;_i = ((int)(0 + _i + step15))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 225;BA.debugLine="res.Put(cur.GetColumnName(i).ToLowerCase, cur.Ge";
Debug.ShouldStop(1);
_res.runVoidMethod ("Put",(Object)((_cur.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _i))).runMethod(true,"toLowerCase"))),(Object)((_cur.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _i))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 227;BA.debugLine="cur.Close";
Debug.ShouldStop(4);
_cur.runVoidMethod ("Close");
 BA.debugLineNum = 228;BA.debugLine="Return res";
Debug.ShouldStop(8);
if (true) return _res;
 BA.debugLineNum = 229;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executememorytable(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs,RemoteObject _limit) throws Exception{
try {
		Debug.PushSubsStack("ExecuteMemoryTable (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,182);
if (RapidSub.canDelegate("executememorytable")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","executememorytable", _ba, _sql, _query, _stringargs, _limit);
RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _table = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _row = 0;
RemoteObject _values = null;
int _col = 0;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
Debug.locals.put("Limit", _limit);
 BA.debugLineNum = 182;BA.debugLine="Sub ExecuteMemoryTable(SQL As SQL, Query As String";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 183;BA.debugLine="Dim cur As Cursor";
Debug.ShouldStop(4194304);
_cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("cur", _cur);
 BA.debugLineNum = 184;BA.debugLine="If StringArgs <> Null Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("N",_stringargs)) { 
 BA.debugLineNum = 185;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
Debug.ShouldStop(16777216);
_cur.setObject(_sql.runMethod(false,"ExecQuery2",(Object)(_query),(Object)(_stringargs)));
 }else {
 BA.debugLineNum = 187;BA.debugLine="cur = SQL.ExecQuery(Query)";
Debug.ShouldStop(67108864);
_cur.setObject(_sql.runMethod(false,"ExecQuery",(Object)(_query)));
 };
 BA.debugLineNum = 189;BA.debugLine="Log(\"ExecuteMemoryTable: \" & Query)";
Debug.ShouldStop(268435456);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("ExecuteMemoryTable: "),_query)));
 BA.debugLineNum = 190;BA.debugLine="Dim table As List";
Debug.ShouldStop(536870912);
_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("table", _table);
 BA.debugLineNum = 191;BA.debugLine="table.Initialize";
Debug.ShouldStop(1073741824);
_table.runVoidMethod ("Initialize");
 BA.debugLineNum = 192;BA.debugLine="If Limit > 0 Then Limit = Min(Limit, cur.RowCount";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean(">",_limit,BA.numberCast(double.class, 0))) { 
_limit = BA.numberCast(int.class, dbutils.mostCurrent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, _limit)),(Object)(BA.numberCast(double.class, _cur.runMethod(true,"getRowCount")))));Debug.locals.put("Limit", _limit);}
else {
_limit = _cur.runMethod(true,"getRowCount");Debug.locals.put("Limit", _limit);};
 BA.debugLineNum = 193;BA.debugLine="For row = 0 To Limit - 1";
Debug.ShouldStop(1);
{
final int step11 = 1;
final int limit11 = RemoteObject.solve(new RemoteObject[] {_limit,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_row = 0 ;
for (;(step11 > 0 && _row <= limit11) || (step11 < 0 && _row >= limit11) ;_row = ((int)(0 + _row + step11))  ) {
Debug.locals.put("row", _row);
 BA.debugLineNum = 194;BA.debugLine="cur.Position = row";
Debug.ShouldStop(2);
_cur.runMethod(true,"setPosition",BA.numberCast(int.class, _row));
 BA.debugLineNum = 195;BA.debugLine="Dim values(cur.ColumnCount) As String";
Debug.ShouldStop(4);
_values = RemoteObject.createNewArray ("String", new int[] {_cur.runMethod(true,"getColumnCount").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("values", _values);
 BA.debugLineNum = 196;BA.debugLine="For col = 0 To cur.ColumnCount - 1";
Debug.ShouldStop(8);
{
final int step14 = 1;
final int limit14 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_col = 0 ;
for (;(step14 > 0 && _col <= limit14) || (step14 < 0 && _col >= limit14) ;_col = ((int)(0 + _col + step14))  ) {
Debug.locals.put("col", _col);
 BA.debugLineNum = 197;BA.debugLine="values(col) = cur.GetString2(col)";
Debug.ShouldStop(16);
_values.setArrayElement (_cur.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _col))),BA.numberCast(int.class, _col));
 }
}Debug.locals.put("col", _col);
;
 BA.debugLineNum = 199;BA.debugLine="table.Add(values)";
Debug.ShouldStop(64);
_table.runVoidMethod ("Add",(Object)((_values)));
 }
}Debug.locals.put("row", _row);
;
 BA.debugLineNum = 201;BA.debugLine="cur.Close";
Debug.ShouldStop(256);
_cur.runVoidMethod ("Close");
 BA.debugLineNum = 202;BA.debugLine="Return table";
Debug.ShouldStop(512);
if (true) return _table;
 BA.debugLineNum = 203;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executespinner(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs,RemoteObject _limit,RemoteObject _spinner1) throws Exception{
try {
		Debug.PushSubsStack("ExecuteSpinner (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,232);
if (RapidSub.canDelegate("executespinner")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","executespinner", _ba, _sql, _query, _stringargs, _limit, _spinner1);
RemoteObject _table = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cols = null;
int _i = 0;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
Debug.locals.put("Limit", _limit);
Debug.locals.put("Spinner1", _spinner1);
 BA.debugLineNum = 232;BA.debugLine="Sub ExecuteSpinner(SQL As SQL, Query As String, St";
Debug.ShouldStop(128);
 BA.debugLineNum = 233;BA.debugLine="Spinner1.Clear";
Debug.ShouldStop(256);
_spinner1.runVoidMethod ("Clear");
 BA.debugLineNum = 234;BA.debugLine="Dim Table As List";
Debug.ShouldStop(512);
_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("Table", _table);
 BA.debugLineNum = 235;BA.debugLine="Table = ExecuteMemoryTable(SQL, Query, StringArgs";
Debug.ShouldStop(1024);
_table = _executememorytable(_ba,_sql,_query,_stringargs,_limit);Debug.locals.put("Table", _table);
 BA.debugLineNum = 236;BA.debugLine="Dim Cols() As String";
Debug.ShouldStop(2048);
_cols = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("Cols", _cols);
 BA.debugLineNum = 237;BA.debugLine="For i = 0 To Table.Size - 1";
Debug.ShouldStop(4096);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_table.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 238;BA.debugLine="Cols = Table.Get(i)";
Debug.ShouldStop(8192);
_cols = (_table.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("Cols", _cols);
 BA.debugLineNum = 239;BA.debugLine="Spinner1.Add(Cols(0))";
Debug.ShouldStop(16384);
_spinner1.runVoidMethod ("Add",(Object)(_cols.getArrayElement(true,BA.numberCast(int.class, 0))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 241;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getdbversion(RemoteObject _ba,RemoteObject _sql) throws Exception{
try {
		Debug.PushSubsStack("GetDBVersion (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,430);
if (RapidSub.canDelegate("getdbversion")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","getdbversion", _ba, _sql);
RemoteObject _count = RemoteObject.createImmutable(0);
RemoteObject _version = RemoteObject.createImmutable(0);
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
;
Debug.locals.put("SQL", _sql);
 BA.debugLineNum = 430;BA.debugLine="Sub GetDBVersion (SQL As SQL) As Int";
Debug.ShouldStop(8192);
 BA.debugLineNum = 431;BA.debugLine="Dim count, version As Int";
Debug.ShouldStop(16384);
_count = RemoteObject.createImmutable(0);Debug.locals.put("count", _count);
_version = RemoteObject.createImmutable(0);Debug.locals.put("version", _version);
 BA.debugLineNum = 432;BA.debugLine="count = SQL.ExecQuerySingleResult(\"SELECT count(*";
Debug.ShouldStop(32768);
_count = BA.numberCast(int.class, _sql.runMethod(true,"ExecQuerySingleResult",(Object)(RemoteObject.createImmutable("SELECT count(*) FROM sqlite_master WHERE Type='table' AND name='DBVersion'"))));Debug.locals.put("count", _count);
 BA.debugLineNum = 433;BA.debugLine="If count > 0 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean(">",_count,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 434;BA.debugLine="version = SQL.ExecQuerySingleResult(\"SELECT vers";
Debug.ShouldStop(131072);
_version = BA.numberCast(int.class, _sql.runMethod(true,"ExecQuerySingleResult",(Object)(RemoteObject.createImmutable("SELECT version FROM DBVersion"))));Debug.locals.put("version", _version);
 }else {
 BA.debugLineNum = 437;BA.debugLine="Dim m As Map";
Debug.ShouldStop(1048576);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 438;BA.debugLine="m.Initialize";
Debug.ShouldStop(2097152);
_m.runVoidMethod ("Initialize");
 BA.debugLineNum = 439;BA.debugLine="m.Put(\"version\", DB_INTEGER)";
Debug.ShouldStop(4194304);
_m.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("version"))),(Object)((dbutils._db_integer)));
 BA.debugLineNum = 440;BA.debugLine="CreateTable(SQL, \"DBVersion\", m, \"version\")";
Debug.ShouldStop(8388608);
_createtable(_ba,_sql,BA.ObjectToString("DBVersion"),_m,RemoteObject.createImmutable("version"));
 BA.debugLineNum = 442;BA.debugLine="SQL.ExecNonQuery(\"INSERT INTO DBVersion VALUES (";
Debug.ShouldStop(33554432);
_sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO DBVersion VALUES (1)")));
 BA.debugLineNum = 444;BA.debugLine="version = 1";
Debug.ShouldStop(134217728);
_version = BA.numberCast(int.class, 1);Debug.locals.put("version", _version);
 };
 BA.debugLineNum = 447;BA.debugLine="Return version";
Debug.ShouldStop(1073741824);
if (true) return _version;
 BA.debugLineNum = 448;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _insertmaps(RemoteObject _ba,RemoteObject _sql,RemoteObject _tablename,RemoteObject _listofmaps) throws Exception{
try {
		Debug.PushSubsStack("InsertMaps (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,74);
if (RapidSub.canDelegate("insertmaps")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","insertmaps", _ba, _sql, _tablename, _listofmaps);
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _columns = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _values = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i1 = 0;
RemoteObject _listofvalues = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i2 = 0;
RemoteObject _col = RemoteObject.createImmutable("");
RemoteObject _value = RemoteObject.declareNull("Object");
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("TableName", _tablename);
Debug.locals.put("ListOfMaps", _listofmaps);
 BA.debugLineNum = 74;BA.debugLine="Sub InsertMaps(SQL As SQL, TableName As String, Li";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="Dim sb, columns, values As StringBuilder";
Debug.ShouldStop(1024);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
_columns = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("columns", _columns);
_values = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("values", _values);
 BA.debugLineNum = 77;BA.debugLine="If ListOfMaps.Size > 1 AND ListOfMaps.Get(0) = Li";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean(">",_listofmaps.runMethod(true,"getSize"),BA.numberCast(double.class, 1)) && RemoteObject.solveBoolean("=",_listofmaps.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),_listofmaps.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))) { 
 BA.debugLineNum = 78;BA.debugLine="Log(\"Same Map found twice in list. Each item in";
Debug.ShouldStop(8192);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Same Map found twice in list. Each item in the list should include a different map object.")));
 BA.debugLineNum = 79;BA.debugLine="ToastMessageShow(\"Same Map found twice in list.";
Debug.ShouldStop(16384);
dbutils.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Same Map found twice in list. Each item in the list should include a different map object.")),(Object)(dbutils.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 80;BA.debugLine="Return";
Debug.ShouldStop(32768);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 82;BA.debugLine="SQL.BeginTransaction";
Debug.ShouldStop(131072);
_sql.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 83;BA.debugLine="Try";
Debug.ShouldStop(262144);
try { BA.debugLineNum = 84;BA.debugLine="For i1 = 0 To ListOfMaps.Size - 1";
Debug.ShouldStop(524288);
{
final int step9 = 1;
final int limit9 = RemoteObject.solve(new RemoteObject[] {_listofmaps.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i1 = 0 ;
for (;(step9 > 0 && _i1 <= limit9) || (step9 < 0 && _i1 >= limit9) ;_i1 = ((int)(0 + _i1 + step9))  ) {
Debug.locals.put("i1", _i1);
 BA.debugLineNum = 85;BA.debugLine="sb.Initialize";
Debug.ShouldStop(1048576);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 86;BA.debugLine="columns.Initialize";
Debug.ShouldStop(2097152);
_columns.runVoidMethod ("Initialize");
 BA.debugLineNum = 87;BA.debugLine="values.Initialize";
Debug.ShouldStop(4194304);
_values.runVoidMethod ("Initialize");
 BA.debugLineNum = 88;BA.debugLine="Dim listOfValues As List";
Debug.ShouldStop(8388608);
_listofvalues = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("listOfValues", _listofvalues);
 BA.debugLineNum = 89;BA.debugLine="listOfValues.Initialize";
Debug.ShouldStop(16777216);
_listofvalues.runVoidMethod ("Initialize");
 BA.debugLineNum = 90;BA.debugLine="sb.Append(\"INSERT INTO [\" & TableName & \"] (\")";
Debug.ShouldStop(33554432);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO ["),_tablename,RemoteObject.createImmutable("] ("))));
 BA.debugLineNum = 91;BA.debugLine="Dim m As Map";
Debug.ShouldStop(67108864);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 92;BA.debugLine="m = ListOfMaps.Get(i1)";
Debug.ShouldStop(134217728);
_m.setObject(_listofmaps.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i1))));
 BA.debugLineNum = 93;BA.debugLine="For i2 = 0 To m.Size - 1";
Debug.ShouldStop(268435456);
{
final int step18 = 1;
final int limit18 = RemoteObject.solve(new RemoteObject[] {_m.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i2 = 0 ;
for (;(step18 > 0 && _i2 <= limit18) || (step18 < 0 && _i2 >= limit18) ;_i2 = ((int)(0 + _i2 + step18))  ) {
Debug.locals.put("i2", _i2);
 BA.debugLineNum = 94;BA.debugLine="Dim col As String";
Debug.ShouldStop(536870912);
_col = RemoteObject.createImmutable("");Debug.locals.put("col", _col);
 BA.debugLineNum = 95;BA.debugLine="Dim value As Object";
Debug.ShouldStop(1073741824);
_value = RemoteObject.createNew ("Object");Debug.locals.put("value", _value);
 BA.debugLineNum = 96;BA.debugLine="col = m.GetKeyAt(i2)";
Debug.ShouldStop(-2147483648);
_col = BA.ObjectToString(_m.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i2))));Debug.locals.put("col", _col);
 BA.debugLineNum = 97;BA.debugLine="value = m.GetValueAt(i2)";
Debug.ShouldStop(1);
_value = _m.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i2)));Debug.locals.put("value", _value);
 BA.debugLineNum = 98;BA.debugLine="If i2 > 0 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i2),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 99;BA.debugLine="columns.Append(\", \")";
Debug.ShouldStop(4);
_columns.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(", ")));
 BA.debugLineNum = 100;BA.debugLine="values.Append(\", \")";
Debug.ShouldStop(8);
_values.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(", ")));
 };
 BA.debugLineNum = 102;BA.debugLine="columns.Append(\"[\").Append(col).Append(\"]\")";
Debug.ShouldStop(32);
_columns.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("["))).runMethod(false,"Append",(Object)(_col)).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("]")));
 BA.debugLineNum = 103;BA.debugLine="values.Append(\"?\")";
Debug.ShouldStop(64);
_values.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("?")));
 BA.debugLineNum = 104;BA.debugLine="listOfValues.Add(value)";
Debug.ShouldStop(128);
_listofvalues.runVoidMethod ("Add",(Object)(_value));
 }
}Debug.locals.put("i2", _i2);
;
 BA.debugLineNum = 106;BA.debugLine="sb.Append(columns.ToString).Append(\") VALUES (\"";
Debug.ShouldStop(512);
_sb.runMethod(false,"Append",(Object)(_columns.runMethod(true,"ToString"))).runMethod(false,"Append",(Object)(RemoteObject.createImmutable(") VALUES ("))).runMethod(false,"Append",(Object)(_values.runMethod(true,"ToString"))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(")")));
 BA.debugLineNum = 107;BA.debugLine="If i1 = 0 Then Log(\"InsertMaps (first query out";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",RemoteObject.createImmutable(_i1),BA.numberCast(double.class, 0))) { 
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("InsertMaps (first query out of "),_listofmaps.runMethod(true,"getSize"),RemoteObject.createImmutable("): "),_sb.runMethod(true,"ToString"))));};
 BA.debugLineNum = 108;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, listOfValues)";
Debug.ShouldStop(2048);
_sql.runVoidMethod ("ExecNonQuery2",(Object)(_sb.runMethod(true,"ToString")),(Object)(_listofvalues));
 }
}Debug.locals.put("i1", _i1);
;
 BA.debugLineNum = 110;BA.debugLine="SQL.TransactionSuccessful";
Debug.ShouldStop(8192);
_sql.runVoidMethod ("TransactionSuccessful");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e37) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e37.toString()); BA.debugLineNum = 112;BA.debugLine="ToastMessageShow(LastException.Message, True)";
Debug.ShouldStop(32768);
dbutils.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(dbutils.mostCurrent.__c.runMethod(false,"LastException",_ba).runMethod(true,"getMessage"))),(Object)(dbutils.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 113;BA.debugLine="Log(LastException)";
Debug.ShouldStop(65536);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(dbutils.mostCurrent.__c.runMethod(false,"LastException",_ba))));
 };
 BA.debugLineNum = 115;BA.debugLine="SQL.EndTransaction";
Debug.ShouldStop(262144);
_sql.runVoidMethod ("EndTransaction");
 BA.debugLineNum = 116;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim DB_REAL, DB_INTEGER, DB_BLOB, DB_TEXT As Stri";
dbutils._db_real = RemoteObject.createImmutable("");
dbutils._db_integer = RemoteObject.createImmutable("");
dbutils._db_blob = RemoteObject.createImmutable("");
dbutils._db_text = RemoteObject.createImmutable("");
 //BA.debugLineNum = 14;BA.debugLine="DB_REAL = \"REAL\"";
dbutils._db_real = BA.ObjectToString("REAL");
 //BA.debugLineNum = 15;BA.debugLine="DB_INTEGER = \"INTEGER\"";
dbutils._db_integer = BA.ObjectToString("INTEGER");
 //BA.debugLineNum = 16;BA.debugLine="DB_BLOB = \"BLOB\"";
dbutils._db_blob = BA.ObjectToString("BLOB");
 //BA.debugLineNum = 17;BA.debugLine="DB_TEXT = \"TEXT\"";
dbutils._db_text = BA.ObjectToString("TEXT");
 //BA.debugLineNum = 18;BA.debugLine="Dim HtmlCSS As String";
dbutils._htmlcss = RemoteObject.createImmutable("");
 //BA.debugLineNum = 19;BA.debugLine="HtmlCSS = \"table {width: 100%;border: 1px solid #";
dbutils._htmlcss = RemoteObject.concat(RemoteObject.createImmutable("table {width: 100%;border: 1px solid #cef;text-align: left; }"),RemoteObject.createImmutable(" th { font-weight: bold;	background-color: #acf;	border-bottom: 1px solid #cef; }"),RemoteObject.createImmutable("td,th {	padding: 4px 5px; }"),RemoteObject.createImmutable(".odd {background-color: #def; } .odd td {border-bottom: 1px solid #cef; }"),RemoteObject.createImmutable("a { text-decoration:none; color: #000;}"));
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setdbversion(RemoteObject _ba,RemoteObject _sql,RemoteObject _version) throws Exception{
try {
		Debug.PushSubsStack("SetDBVersion (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,451);
if (RapidSub.canDelegate("setdbversion")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","setdbversion", _ba, _sql, _version);
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Version", _version);
 BA.debugLineNum = 451;BA.debugLine="Sub SetDBVersion (SQL As SQL, Version As Int)";
Debug.ShouldStop(4);
 BA.debugLineNum = 452;BA.debugLine="SQL.ExecNonQuery2(\"UPDATE DBVersion set version =";
Debug.ShouldStop(8);
_sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE DBVersion set version = ?")),(Object)(dbutils.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_version)})))));
 BA.debugLineNum = 453;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _updaterecord(RemoteObject _ba,RemoteObject _sql,RemoteObject _tablename,RemoteObject _field,RemoteObject _newvalue,RemoteObject _wherefieldequals) throws Exception{
try {
		Debug.PushSubsStack("UpdateRecord (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,120);
if (RapidSub.canDelegate("updaterecord")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","updaterecord", _ba, _sql, _tablename, _field, _newvalue, _wherefieldequals);
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _args = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("TableName", _tablename);
Debug.locals.put("Field", _field);
Debug.locals.put("NewValue", _newvalue);
Debug.locals.put("WhereFieldEquals", _wherefieldequals);
 BA.debugLineNum = 120;BA.debugLine="Sub UpdateRecord(SQL As SQL, TableName As String,";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 122;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(33554432);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 123;BA.debugLine="sb.Initialize";
Debug.ShouldStop(67108864);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 124;BA.debugLine="sb.Append(\"UPDATE [\").Append(TableName).Append(\"]";
Debug.ShouldStop(134217728);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("UPDATE ["))).runMethod(false,"Append",(Object)(_tablename)).runMethod(false,"Append",(Object)(RemoteObject.createImmutable("] SET ["))).runMethod(false,"Append",(Object)(_field)).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("] = ? WHERE ")));
 BA.debugLineNum = 125;BA.debugLine="If WhereFieldEquals.Size = 0 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",_wherefieldequals.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 126;BA.debugLine="Log(\"WhereFieldEquals map empty!\")";
Debug.ShouldStop(536870912);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("WhereFieldEquals map empty!")));
 BA.debugLineNum = 127;BA.debugLine="Return";
Debug.ShouldStop(1073741824);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 129;BA.debugLine="Dim args As List";
Debug.ShouldStop(1);
_args = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("args", _args);
 BA.debugLineNum = 130;BA.debugLine="args.Initialize";
Debug.ShouldStop(2);
_args.runVoidMethod ("Initialize");
 BA.debugLineNum = 131;BA.debugLine="args.Add(NewValue)";
Debug.ShouldStop(4);
_args.runVoidMethod ("Add",(Object)(_newvalue));
 BA.debugLineNum = 132;BA.debugLine="For i = 0 To WhereFieldEquals.Size - 1";
Debug.ShouldStop(8);
{
final int step11 = 1;
final int limit11 = RemoteObject.solve(new RemoteObject[] {_wherefieldequals.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11) ;_i = ((int)(0 + _i + step11))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 133;BA.debugLine="If i > 0 Then sb.Append(\" AND \")";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" AND ")));};
 BA.debugLineNum = 134;BA.debugLine="sb.Append(\"[\").Append(WhereFieldEquals.GetKeyAt(";
Debug.ShouldStop(32);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("["))).runMethod(false,"Append",(Object)(BA.ObjectToString(_wherefieldequals.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("] = ?")));
 BA.debugLineNum = 135;BA.debugLine="args.Add(WhereFieldEquals.GetValueAt(i))";
Debug.ShouldStop(64);
_args.runVoidMethod ("Add",(Object)(_wherefieldequals.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 137;BA.debugLine="Log(\"UpdateRecord: \" & sb.ToString)";
Debug.ShouldStop(256);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UpdateRecord: "),_sb.runMethod(true,"ToString"))));
 BA.debugLineNum = 138;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, args)";
Debug.ShouldStop(512);
_sql.runVoidMethod ("ExecNonQuery2",(Object)(_sb.runMethod(true,"ToString")),(Object)(_args));
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _updaterecord2(RemoteObject _ba,RemoteObject _sql,RemoteObject _tablename,RemoteObject _fields,RemoteObject _wherefieldequals) throws Exception{
try {
		Debug.PushSubsStack("UpdateRecord2 (dbutils) ","dbutils",5,_ba,dbutils.mostCurrent,143);
if (RapidSub.canDelegate("updaterecord2")) return b4a.AutoScaleExample7.dbutils.remoteMe.runUserSub(false, "dbutils","updaterecord2", _ba, _sql, _tablename, _fields, _wherefieldequals);
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _args = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("TableName", _tablename);
Debug.locals.put("Fields", _fields);
Debug.locals.put("WhereFieldEquals", _wherefieldequals);
 BA.debugLineNum = 143;BA.debugLine="Sub UpdateRecord2(SQL As SQL, TableName As String,";
Debug.ShouldStop(16384);
 BA.debugLineNum = 144;BA.debugLine="If WhereFieldEquals.Size = 0 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_wherefieldequals.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 145;BA.debugLine="Log(\"WhereFieldEquals map empty!\")";
Debug.ShouldStop(65536);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("WhereFieldEquals map empty!")));
 BA.debugLineNum = 146;BA.debugLine="Return";
Debug.ShouldStop(131072);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 148;BA.debugLine="If Fields.Size = 0 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_fields.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 149;BA.debugLine="Log(\"Fields empty\")";
Debug.ShouldStop(1048576);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Fields empty")));
 BA.debugLineNum = 150;BA.debugLine="Return";
Debug.ShouldStop(2097152);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 152;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(8388608);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 153;BA.debugLine="sb.Initialize";
Debug.ShouldStop(16777216);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 154;BA.debugLine="sb.Append(\"UPDATE [\").Append(TableName).Append(\"]";
Debug.ShouldStop(33554432);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("UPDATE ["))).runMethod(false,"Append",(Object)(_tablename)).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("] SET ")));
 BA.debugLineNum = 155;BA.debugLine="Dim args As List";
Debug.ShouldStop(67108864);
_args = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("args", _args);
 BA.debugLineNum = 156;BA.debugLine="args.Initialize";
Debug.ShouldStop(134217728);
_args.runVoidMethod ("Initialize");
 BA.debugLineNum = 157;BA.debugLine="For i=0 To Fields.Size-1";
Debug.ShouldStop(268435456);
{
final int step14 = 1;
final int limit14 = RemoteObject.solve(new RemoteObject[] {_fields.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14) ;_i = ((int)(0 + _i + step14))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 158;BA.debugLine="If i<>Fields.Size-1 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("!",RemoteObject.createImmutable(_i),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_fields.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
 BA.debugLineNum = 159;BA.debugLine="sb.Append(\"[\").Append(Fields.GetKeyAt(i)).Appen";
Debug.ShouldStop(1073741824);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("["))).runMethod(false,"Append",(Object)(BA.ObjectToString(_fields.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("]=?,")));
 }else {
 BA.debugLineNum = 161;BA.debugLine="sb.Append(\"[\").Append(Fields.GetKeyAt(i)).Appen";
Debug.ShouldStop(1);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("["))).runMethod(false,"Append",(Object)(BA.ObjectToString(_fields.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("]=?")));
 };
 BA.debugLineNum = 163;BA.debugLine="args.Add(Fields.GetValueAt(i))";
Debug.ShouldStop(4);
_args.runVoidMethod ("Add",(Object)(_fields.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 166;BA.debugLine="sb.Append(\" WHERE \")";
Debug.ShouldStop(32);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" WHERE ")));
 BA.debugLineNum = 167;BA.debugLine="For i = 0 To WhereFieldEquals.Size - 1";
Debug.ShouldStop(64);
{
final int step23 = 1;
final int limit23 = RemoteObject.solve(new RemoteObject[] {_wherefieldequals.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step23 > 0 && _i <= limit23) || (step23 < 0 && _i >= limit23) ;_i = ((int)(0 + _i + step23))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 168;BA.debugLine="If i > 0 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 169;BA.debugLine="sb.Append(\" AND \")";
Debug.ShouldStop(256);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" AND ")));
 };
 BA.debugLineNum = 171;BA.debugLine="sb.Append(\"[\").Append(WhereFieldEquals.GetKeyAt(";
Debug.ShouldStop(1024);
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("["))).runMethod(false,"Append",(Object)(BA.ObjectToString(_wherefieldequals.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i)))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("] = ?")));
 BA.debugLineNum = 172;BA.debugLine="args.Add(WhereFieldEquals.GetValueAt(i))";
Debug.ShouldStop(2048);
_args.runVoidMethod ("Add",(Object)(_wherefieldequals.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 174;BA.debugLine="Log(\"UpdateRecord: \" & sb.ToString)";
Debug.ShouldStop(8192);
dbutils.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UpdateRecord: "),_sb.runMethod(true,"ToString"))));
 BA.debugLineNum = 175;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, args)";
Debug.ShouldStop(16384);
_sql.runVoidMethod ("ExecNonQuery2",(Object)(_sb.runMethod(true,"ToString")),(Object)(_args));
 BA.debugLineNum = 176;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}