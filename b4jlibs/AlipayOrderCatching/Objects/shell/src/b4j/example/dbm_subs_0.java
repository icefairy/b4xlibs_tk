package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class dbm_subs_0 {


public static RemoteObject  _builddeletequery(RemoteObject _tablename,RemoteObject _wherefields) throws Exception{
try {
		Debug.PushSubsStack("BuildDeleteQuery (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,269);
if (RapidSub.canDelegate("builddeletequery")) return dbm.remoteMe.runUserSub(false, "dbm","builddeletequery", _tablename, _wherefields);
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i = 0;
RemoteObject _col = RemoteObject.createImmutable("");
RemoteObject _value = RemoteObject.createImmutable("");
Debug.locals.put("TableName", _tablename);
Debug.locals.put("WhereFields", _wherefields);
 BA.debugLineNum = 269;BA.debugLine="Sub BuildDeleteQuery(TableName As String, WhereFie";
Debug.ShouldStop(4096);
 BA.debugLineNum = 270;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(8192);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 271;BA.debugLine="sb.Initialize";
Debug.ShouldStop(16384);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 272;BA.debugLine="sb.Append(\"DELETE FROM \" & TableName)";
Debug.ShouldStop(32768);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM "),_tablename)));
 BA.debugLineNum = 273;BA.debugLine="If WhereFields.IsInitialized Then";
Debug.ShouldStop(65536);
if (_wherefields.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 274;BA.debugLine="sb.Append(\" WHERE \")";
Debug.ShouldStop(131072);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" WHERE ")));
 BA.debugLineNum = 275;BA.debugLine="For i = 0 To WhereFields.Size - 1";
Debug.ShouldStop(262144);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {_wherefields.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6); _i = ((int)(0 + _i + step6)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 276;BA.debugLine="Dim col As String = WhereFields.GetKeyAt(i)";
Debug.ShouldStop(524288);
_col = BA.ObjectToString(_wherefields.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("col", _col);Debug.locals.put("col", _col);
 BA.debugLineNum = 277;BA.debugLine="Dim value As String = WhereFields.GetValueAt(i)";
Debug.ShouldStop(1048576);
_value = BA.ObjectToString(_wherefields.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("value", _value);Debug.locals.put("value", _value);
 BA.debugLineNum = 278;BA.debugLine="If i > 0 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 279;BA.debugLine="sb.Append(\" AND \")";
Debug.ShouldStop(4194304);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" AND ")));
 };
 BA.debugLineNum = 281;BA.debugLine="sb.Append(col & \"=\" & value)";
Debug.ShouldStop(16777216);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.concat(_col,RemoteObject.createImmutable("="),_value)));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 284;BA.debugLine="Return sb.ToString";
Debug.ShouldStop(134217728);
if (true) return _sb.runMethod(true,"ToString");
 BA.debugLineNum = 285;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buildinsertquery(RemoteObject _tablename,RemoteObject _fields) throws Exception{
try {
		Debug.PushSubsStack("BuildInsertQuery (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,246);
if (RapidSub.canDelegate("buildinsertquery")) return dbm.remoteMe.runUserSub(false, "dbm","buildinsertquery", _tablename, _fields);
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i = 0;
RemoteObject _col = RemoteObject.createImmutable("");
Debug.locals.put("TableName", _tablename);
Debug.locals.put("Fields", _fields);
 BA.debugLineNum = 246;BA.debugLine="Sub BuildInsertQuery(TableName As String, Fields A";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 247;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(4194304);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 248;BA.debugLine="sb.Initialize";
Debug.ShouldStop(8388608);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 249;BA.debugLine="sb.Append(\"INSERT INTO \" & TableName & \"(\")";
Debug.ShouldStop(16777216);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO "),_tablename,RemoteObject.createImmutable("("))));
 BA.debugLineNum = 250;BA.debugLine="For i = 0 To Fields.Size - 1";
Debug.ShouldStop(33554432);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_fields.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 251;BA.debugLine="Dim col As String = Fields.GetKeyAt(i)";
Debug.ShouldStop(67108864);
_col = BA.ObjectToString(_fields.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("col", _col);Debug.locals.put("col", _col);
 BA.debugLineNum = 252;BA.debugLine="If i > 0 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 253;BA.debugLine="sb.Append(\", \")";
Debug.ShouldStop(268435456);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(", ")));
 };
 BA.debugLineNum = 255;BA.debugLine="sb.Append(col)";
Debug.ShouldStop(1073741824);
_sb.runVoidMethod ("Append",(Object)(_col));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 257;BA.debugLine="sb.Append(\") VALUES (\")";
Debug.ShouldStop(1);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(") VALUES (")));
 BA.debugLineNum = 258;BA.debugLine="For i = 0 To Fields.Size - 1";
Debug.ShouldStop(2);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {_fields.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12); _i = ((int)(0 + _i + step12)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 259;BA.debugLine="Dim col As String = Fields.GetValueAt(i)";
Debug.ShouldStop(4);
_col = BA.ObjectToString(_fields.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("col", _col);Debug.locals.put("col", _col);
 BA.debugLineNum = 260;BA.debugLine="If i > 0 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 261;BA.debugLine="sb.Append(\", \")";
Debug.ShouldStop(16);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(", ")));
 };
 BA.debugLineNum = 263;BA.debugLine="sb.Append(col)";
Debug.ShouldStop(64);
_sb.runVoidMethod ("Append",(Object)(_col));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 265;BA.debugLine="sb.Append(\")\")";
Debug.ShouldStop(256);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(")")));
 BA.debugLineNum = 266;BA.debugLine="Return sb.ToString";
Debug.ShouldStop(512);
if (true) return _sb.runMethod(true,"ToString");
 BA.debugLineNum = 267;BA.debugLine="End Sub";
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
public static RemoteObject  _buildselectquery(RemoteObject _tablename,RemoteObject _fields,RemoteObject _wherefields,RemoteObject _orderfields) throws Exception{
try {
		Debug.PushSubsStack("BuildSelectQuery (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,209);
if (RapidSub.canDelegate("buildselectquery")) return dbm.remoteMe.runUserSub(false, "dbm","buildselectquery", _tablename, _fields, _wherefields, _orderfields);
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i = 0;
RemoteObject _col = RemoteObject.createImmutable("");
RemoteObject _value = RemoteObject.createImmutable("");
Debug.locals.put("TableName", _tablename);
Debug.locals.put("Fields", _fields);
Debug.locals.put("WhereFields", _wherefields);
Debug.locals.put("OrderFields", _orderfields);
 BA.debugLineNum = 209;BA.debugLine="Sub BuildSelectQuery(TableName As String, Fields A";
Debug.ShouldStop(65536);
 BA.debugLineNum = 210;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(131072);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 211;BA.debugLine="sb.Initialize";
Debug.ShouldStop(262144);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 212;BA.debugLine="sb.Append(\"SELECT \")";
Debug.ShouldStop(524288);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("SELECT ")));
 BA.debugLineNum = 213;BA.debugLine="For i = 0 To Fields.Size - 1";
Debug.ShouldStop(1048576);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_fields.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 214;BA.debugLine="Dim col As String = Fields.GetKeyAt(i)";
Debug.ShouldStop(2097152);
_col = BA.ObjectToString(_fields.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("col", _col);Debug.locals.put("col", _col);
 BA.debugLineNum = 215;BA.debugLine="If i > 0 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 216;BA.debugLine="sb.Append(\", \")";
Debug.ShouldStop(8388608);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(", ")));
 };
 BA.debugLineNum = 218;BA.debugLine="sb.Append(col)";
Debug.ShouldStop(33554432);
_sb.runVoidMethod ("Append",(Object)(_col));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 220;BA.debugLine="sb.Append(\" FROM \" & TableName)";
Debug.ShouldStop(134217728);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable(" FROM "),_tablename)));
 BA.debugLineNum = 221;BA.debugLine="If WhereFields.IsInitialized Then";
Debug.ShouldStop(268435456);
if (_wherefields.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 222;BA.debugLine="sb.Append(\" WHERE \")";
Debug.ShouldStop(536870912);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" WHERE ")));
 BA.debugLineNum = 223;BA.debugLine="For i = 0 To WhereFields.Size - 1";
Debug.ShouldStop(1073741824);
{
final int step14 = 1;
final int limit14 = RemoteObject.solve(new RemoteObject[] {_wherefields.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14); _i = ((int)(0 + _i + step14)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 224;BA.debugLine="Dim col As String = WhereFields.GetKeyAt(i)";
Debug.ShouldStop(-2147483648);
_col = BA.ObjectToString(_wherefields.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("col", _col);Debug.locals.put("col", _col);
 BA.debugLineNum = 225;BA.debugLine="Dim value As String = WhereFields.GetValueAt(i)";
Debug.ShouldStop(1);
_value = BA.ObjectToString(_wherefields.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("value", _value);Debug.locals.put("value", _value);
 BA.debugLineNum = 226;BA.debugLine="If i > 0 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 227;BA.debugLine="sb.Append(\" AND \")";
Debug.ShouldStop(4);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" AND ")));
 };
 BA.debugLineNum = 229;BA.debugLine="sb.Append(col & \"=\" & value)";
Debug.ShouldStop(16);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.concat(_col,RemoteObject.createImmutable("="),_value)));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 232;BA.debugLine="If OrderFields.IsInitialized Then";
Debug.ShouldStop(128);
if (_orderfields.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 233;BA.debugLine="sb.Append(\" ORDER BY \")";
Debug.ShouldStop(256);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" ORDER BY ")));
 BA.debugLineNum = 234;BA.debugLine="For i = 0 To WhereFields.Size - 1";
Debug.ShouldStop(512);
{
final int step25 = 1;
final int limit25 = RemoteObject.solve(new RemoteObject[] {_wherefields.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step25 > 0 && _i <= limit25) || (step25 < 0 && _i >= limit25); _i = ((int)(0 + _i + step25)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 235;BA.debugLine="Dim col As String = OrderFields.GetKeyAt(i)";
Debug.ShouldStop(1024);
_col = BA.ObjectToString(_orderfields.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("col", _col);Debug.locals.put("col", _col);
 BA.debugLineNum = 236;BA.debugLine="If i > 0 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 237;BA.debugLine="sb.Append(\", \")";
Debug.ShouldStop(4096);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(", ")));
 };
 BA.debugLineNum = 239;BA.debugLine="sb.Append(col)";
Debug.ShouldStop(16384);
_sb.runVoidMethod ("Append",(Object)(_col));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 243;BA.debugLine="Return sb.ToString";
Debug.ShouldStop(262144);
if (true) return _sb.runMethod(true,"ToString");
 BA.debugLineNum = 244;BA.debugLine="End Sub";
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
public static RemoteObject  _buildupdatequery(RemoteObject _tablename,RemoteObject _fields,RemoteObject _wherefields) throws Exception{
try {
		Debug.PushSubsStack("BuildUpdateQuery (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,287);
if (RapidSub.canDelegate("buildupdatequery")) return dbm.remoteMe.runUserSub(false, "dbm","buildupdatequery", _tablename, _fields, _wherefields);
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i = 0;
RemoteObject _col = RemoteObject.createImmutable("");
RemoteObject _value = RemoteObject.createImmutable("");
Debug.locals.put("TableName", _tablename);
Debug.locals.put("Fields", _fields);
Debug.locals.put("WhereFields", _wherefields);
 BA.debugLineNum = 287;BA.debugLine="Sub BuildUpdateQuery(TableName As String, Fields A";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 288;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(-2147483648);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 289;BA.debugLine="sb.Initialize";
Debug.ShouldStop(1);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 290;BA.debugLine="sb.Append(\"UPDATE \" & TableName & \" SET \")";
Debug.ShouldStop(2);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE "),_tablename,RemoteObject.createImmutable(" SET "))));
 BA.debugLineNum = 291;BA.debugLine="For i = 0 To Fields.Size - 1";
Debug.ShouldStop(4);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_fields.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 292;BA.debugLine="Dim col As String = Fields.GetKeyAt(i)";
Debug.ShouldStop(8);
_col = BA.ObjectToString(_fields.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("col", _col);Debug.locals.put("col", _col);
 BA.debugLineNum = 293;BA.debugLine="Dim value As String = Fields.GetValueAt(i)";
Debug.ShouldStop(16);
_value = BA.ObjectToString(_fields.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("value", _value);Debug.locals.put("value", _value);
 BA.debugLineNum = 294;BA.debugLine="If i > 0 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 295;BA.debugLine="sb.Append(\", \")";
Debug.ShouldStop(64);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(", ")));
 };
 BA.debugLineNum = 297;BA.debugLine="sb.Append(col & \"=\" & value)";
Debug.ShouldStop(256);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.concat(_col,RemoteObject.createImmutable("="),_value)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 299;BA.debugLine="If WhereFields.IsInitialized Then";
Debug.ShouldStop(1024);
if (_wherefields.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 300;BA.debugLine="sb.Append(\" WHERE \")";
Debug.ShouldStop(2048);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" WHERE ")));
 BA.debugLineNum = 301;BA.debugLine="For i = 0 To WhereFields.Size - 1";
Debug.ShouldStop(4096);
{
final int step14 = 1;
final int limit14 = RemoteObject.solve(new RemoteObject[] {_wherefields.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14); _i = ((int)(0 + _i + step14)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 302;BA.debugLine="Dim col As String = WhereFields.GetKeyAt(i)";
Debug.ShouldStop(8192);
_col = BA.ObjectToString(_wherefields.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("col", _col);Debug.locals.put("col", _col);
 BA.debugLineNum = 303;BA.debugLine="Dim value As String = WhereFields.GetValueAt(i)";
Debug.ShouldStop(16384);
_value = BA.ObjectToString(_wherefields.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("value", _value);Debug.locals.put("value", _value);
 BA.debugLineNum = 304;BA.debugLine="If i > 0 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 305;BA.debugLine="sb.Append(\" AND \")";
Debug.ShouldStop(65536);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" AND ")));
 };
 BA.debugLineNum = 307;BA.debugLine="sb.Append(col & \"=\" & value)";
Debug.ShouldStop(262144);
_sb.runVoidMethod ("Append",(Object)(RemoteObject.concat(_col,RemoteObject.createImmutable("="),_value)));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 310;BA.debugLine="Return sb.ToString";
Debug.ShouldStop(2097152);
if (true) return _sb.runMethod(true,"ToString");
 BA.debugLineNum = 311;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _closesql(RemoteObject _mysql) throws Exception{
try {
		Debug.PushSubsStack("CloseSQL (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,35);
if (RapidSub.canDelegate("closesql")) return dbm.remoteMe.runUserSub(false, "dbm","closesql", _mysql);
Debug.locals.put("mySQL", _mysql);
 BA.debugLineNum = 35;BA.debugLine="Sub CloseSQL(mySQL As SQL)";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="If UsePool Then";
Debug.ShouldStop(8);
if (dbm._usepool.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 37;BA.debugLine="mySQL.Close";
Debug.ShouldStop(16);
_mysql.runVoidMethod ("Close");
 };
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createtablesifneeded() throws Exception{
try {
		Debug.PushSubsStack("CreateTablesIfNeeded (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,41);
if (RapidSub.canDelegate("createtablesifneeded")) return dbm.remoteMe.runUserSub(false, "dbm","createtablesifneeded");
RemoteObject _sql = RemoteObject.declareNull("anywheresoftware.b4j.objects.SQL");
RemoteObject _sql_str = RemoteObject.createImmutable("");
 BA.debugLineNum = 41;BA.debugLine="Sub CreateTablesIfNeeded()";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="Dim SQL As SQL = GetSQL";
Debug.ShouldStop(512);
_sql = _getsql();Debug.locals.put("SQL", _sql);Debug.locals.put("SQL", _sql);
 BA.debugLineNum = 43;BA.debugLine="Dim SQL_str As String";
Debug.ShouldStop(1024);
_sql_str = RemoteObject.createImmutable("");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 46;BA.debugLine="If UsePool Then";
Debug.ShouldStop(8192);
if (dbm._usepool.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 47;BA.debugLine="SQL_str = \"SELECT COUNT(*) FROM information_sche";
Debug.ShouldStop(16384);
_sql_str = BA.ObjectToString("SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'abmfeedback' And table_name = 'cases';");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 48;BA.debugLine="If SQLSelectSingleResult(SQL, SQL_str) = 0 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_sqlselectsingleresult(_sql,_sql_str),BA.NumberToString(0))) { 
 BA.debugLineNum = 49;BA.debugLine="SQL_str = \"CREATE TABLE cases (CaseID INT NOT N";
Debug.ShouldStop(65536);
_sql_str = BA.ObjectToString("CREATE TABLE cases (CaseID INT NOT NULL AUTO_INCREMENT, CaseNumber VARCHAR(100), CaseType INT, CaseSummary VARCHAR(255), CaseDescription TEXT , CaseStatus INT, CaseUserID INT, CaseCreationDate VARCHAR(50), CaseFixedVersion VARCHAR(10), PRIMARY KEY (CaseID))");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 50;BA.debugLine="SQLCreate(SQL, SQL_str)";
Debug.ShouldStop(131072);
_sqlcreate(_sql,_sql_str);
 BA.debugLineNum = 55;BA.debugLine="SQL_str = \"CREATE TABLE caseattachments(CaseAID";
Debug.ShouldStop(4194304);
_sql_str = BA.ObjectToString("CREATE TABLE caseattachments(CaseAID INT NOT NULL AUTO_INCREMENT, CaseACaseID INT, CaseAType INT, CaseAValue VARCHAR(255), PRIMARY KEY (CaseAID))");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 56;BA.debugLine="SQLCreate(SQL, SQL_str)";
Debug.ShouldStop(8388608);
_sqlcreate(_sql,_sql_str);
 BA.debugLineNum = 58;BA.debugLine="SQL_str = \"CREATE TABLE casenotes (CaseNID INT";
Debug.ShouldStop(33554432);
_sql_str = BA.ObjectToString("CREATE TABLE casenotes (CaseNID INT NOT NULL AUTO_INCREMENT, CaseNCaseID INT, CaseNUserID INT, CaseNDescription TEXT, CaseNCreationDate VARCHAR(50), PRIMARY KEY (CaseNID))");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 59;BA.debugLine="SQLCreate(SQL, SQL_str)";
Debug.ShouldStop(67108864);
_sqlcreate(_sql,_sql_str);
 BA.debugLineNum = 61;BA.debugLine="SQL_str = \"CREATE TABLE caseread (CaseRID INT N";
Debug.ShouldStop(268435456);
_sql_str = BA.ObjectToString("CREATE TABLE caseread (CaseRID INT NOT NULL AUTO_INCREMENT, CaseRCaseID INT, CaseRUserID INT, CaseRStatus INT, PRIMARY KEY (CaseRID))");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 62;BA.debugLine="SQLCreate(SQL, SQL_str)";
Debug.ShouldStop(536870912);
_sqlcreate(_sql,_sql_str);
 BA.debugLineNum = 64;BA.debugLine="SQL_str = \"CREATE TABLE users (UserID INT NOT N";
Debug.ShouldStop(-2147483648);
_sql_str = BA.ObjectToString("CREATE TABLE users (UserID INT NOT NULL AUTO_INCREMENT, UserName VARCHAR(255), UserLogin VARCHAR(255), UserPassword VARCHAR(100), UserType INT, UserActive INT, PRIMARY KEY (UserID))");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 65;BA.debugLine="SQLCreate(SQL, SQL_str)";
Debug.ShouldStop(1);
_sqlcreate(_sql,_sql_str);
 BA.debugLineNum = 68;BA.debugLine="SQL_str = \"INSERT INTO users (UserName, UserLog";
Debug.ShouldStop(8);
_sql_str = BA.ObjectToString("INSERT INTO users (UserName, UserLogin, UserPassword, UserType, UserActive) VALUES ('Admin', 'Admin', 'Admin', 1, 0)");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 69;BA.debugLine="SQLCreate(SQL, SQL_str)";
Debug.ShouldStop(16);
_sqlcreate(_sql,_sql_str);
 };
 }else {
 BA.debugLineNum = 73;BA.debugLine="SQL_str = \"SELECT count(name) FROM sqlite_master";
Debug.ShouldStop(256);
_sql_str = BA.ObjectToString("SELECT count(name) FROM sqlite_master WHERE type='table' AND name='Cases'");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 74;BA.debugLine="If SQLSelectSingleResult(SQL, SQL_str) = 0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_sqlselectsingleresult(_sql,_sql_str),BA.NumberToString(0))) { 
 BA.debugLineNum = 75;BA.debugLine="SQL_str = \"PRAGMA journal_mode = wal\" 'best mod";
Debug.ShouldStop(1024);
_sql_str = BA.ObjectToString("PRAGMA journal_mode = wal");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 76;BA.debugLine="SQLCreate(SQL, SQL_str)";
Debug.ShouldStop(2048);
_sqlcreate(_sql,_sql_str);
 BA.debugLineNum = 78;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [cases] (";
Debug.ShouldStop(8192);
_sql_str = BA.ObjectToString("CREATE TABLE IF NOT EXISTS [cases] ([CaseID] INTEGER PRIMARY KEY, [CaseNumber] TEXT, [CaseType] INTEGER, [CaseSummary] TEXT, [CaseDescription] TEXT, [CaseStatus] INTEGER, [CaseUserID] INTEGER, [CaseCreationDate] TEXT, [CaseFixedVersion] TEXT)");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 79;BA.debugLine="SQLCreate(SQL, SQL_str)";
Debug.ShouldStop(16384);
_sqlcreate(_sql,_sql_str);
 BA.debugLineNum = 84;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [caseatta";
Debug.ShouldStop(524288);
_sql_str = BA.ObjectToString("CREATE TABLE IF NOT EXISTS [caseattachments]([CaseAID] INTEGER PRIMARY KEY, [CaseACaseID] INTEGER, [CaseAType] INTEGER, [CaseAValue] TEXT)");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 85;BA.debugLine="SQLCreate(SQL, SQL_str)";
Debug.ShouldStop(1048576);
_sqlcreate(_sql,_sql_str);
 BA.debugLineNum = 87;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [casenote";
Debug.ShouldStop(4194304);
_sql_str = BA.ObjectToString("CREATE TABLE IF NOT EXISTS [casenotes]([CaseNID] INTEGER PRIMARY KEY, [CaseNCaseID] INTEGER, [CaseNUserID] INTEGER, [CaseNDescription] TEXT, [CaseNCreationDate] TEXT)");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 88;BA.debugLine="SQLCreate(SQL, SQL_str)";
Debug.ShouldStop(8388608);
_sqlcreate(_sql,_sql_str);
 BA.debugLineNum = 90;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [caseread";
Debug.ShouldStop(33554432);
_sql_str = BA.ObjectToString("CREATE TABLE IF NOT EXISTS [caseread]([CaseRID] INTEGER PRIMARY KEY, [CaseRCaseID] INTEGER, [CaseRUserID] INTEGER, [CaseRStatus] INTEGER)");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 91;BA.debugLine="SQLCreate(SQL, SQL_str)";
Debug.ShouldStop(67108864);
_sqlcreate(_sql,_sql_str);
 BA.debugLineNum = 93;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [users] (";
Debug.ShouldStop(268435456);
_sql_str = BA.ObjectToString("CREATE TABLE IF NOT EXISTS [users] ([UserID] INTEGER PRIMARY KEY, [UserName] TEXT, [UserLogin] TEXT, [UserPassword] TEXT, [UserType] INTEGER, [UserActive] INTEGER)");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 94;BA.debugLine="SQLCreate(SQL, SQL_str)";
Debug.ShouldStop(536870912);
_sqlcreate(_sql,_sql_str);
 BA.debugLineNum = 97;BA.debugLine="SQL_str = \"INSERT INTO [users] (UserID, UserNam";
Debug.ShouldStop(1);
_sql_str = BA.ObjectToString("INSERT INTO [users] (UserID, UserName, UserLogin, UserPassword, UserType, UserActive) VALUES (null, 'Admin', 'Admin', 'Admin', 1, 0)");Debug.locals.put("SQL_str", _sql_str);
 BA.debugLineNum = 98;BA.debugLine="SQLCreate(SQL, SQL_str)";
Debug.ShouldStop(2);
_sqlcreate(_sql,_sql_str);
 };
 };
 BA.debugLineNum = 101;BA.debugLine="CloseSQL(SQL)";
Debug.ShouldStop(16);
_closesql(_sql);
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getsql() throws Exception{
try {
		Debug.PushSubsStack("GetSQL (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,27);
if (RapidSub.canDelegate("getsql")) return dbm.remoteMe.runUserSub(false, "dbm","getsql");
 BA.debugLineNum = 27;BA.debugLine="Sub GetSQL() As SQL";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="If UsePool Then";
Debug.ShouldStop(134217728);
if (dbm._usepool.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 29;BA.debugLine="Return pool.GetConnection";
Debug.ShouldStop(268435456);
if (true) return dbm._pool.runMethod(false,"GetConnection");
 }else {
 BA.debugLineNum = 31;BA.debugLine="Return SQLite";
Debug.ShouldStop(1073741824);
if (true) return dbm._sqlite;
 };
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initializemysql(RemoteObject _jdbcurl,RemoteObject _login,RemoteObject _password,RemoteObject _poolsize) throws Exception{
try {
		Debug.PushSubsStack("InitializeMySQL (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,13);
if (RapidSub.canDelegate("initializemysql")) return dbm.remoteMe.runUserSub(false, "dbm","initializemysql", _jdbcurl, _login, _password, _poolsize);
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("jdbcUrl", _jdbcurl);
Debug.locals.put("login", _login);
Debug.locals.put("password", _password);
Debug.locals.put("poolSize", _poolsize);
 BA.debugLineNum = 13;BA.debugLine="Sub InitializeMySQL(jdbcUrl As String ,login As St";
Debug.ShouldStop(4096);
 BA.debugLineNum = 14;BA.debugLine="Log(\"init mysql\")";
Debug.ShouldStop(8192);
dbm.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("init mysql")));
 BA.debugLineNum = 15;BA.debugLine="UsePool = True";
Debug.ShouldStop(16384);
dbm._usepool = dbm.__c.getField(true,"True");
 BA.debugLineNum = 16;BA.debugLine="Try";
Debug.ShouldStop(32768);
try { BA.debugLineNum = 17;BA.debugLine="pool.Initialize(\"com.mysql.jdbc.Driver\", jd";
Debug.ShouldStop(65536);
dbm._pool.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("com.mysql.jdbc.Driver")),(Object)(_jdbcurl),(Object)(_login),(Object)(_password));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",dbm.ba, e6.toString()); BA.debugLineNum = 19;BA.debugLine="Log(\"Last Pool Init Except: \"&LastException";
Debug.ShouldStop(262144);
dbm.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Last Pool Init Except: "),dbm.__c.runMethod(false,"LastException",dbm.ba).runMethod(true,"getMessage"))));
 };
 BA.debugLineNum = 23;BA.debugLine="Dim jo As JavaObject = pool";
Debug.ShouldStop(4194304);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(dbm._pool.getObject());Debug.locals.put("jo", _jo);
 BA.debugLineNum = 24;BA.debugLine="jo.RunMethod(\"setMaxPoolSize\", Array(poolSize)";
Debug.ShouldStop(8388608);
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setMaxPoolSize")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_poolsize)})));
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
public static RemoteObject  _initializesqlite(RemoteObject _dir,RemoteObject _filename,RemoteObject _createifneeded) throws Exception{
try {
		Debug.PushSubsStack("InitializeSQLite (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,7);
if (RapidSub.canDelegate("initializesqlite")) return dbm.remoteMe.runUserSub(false, "dbm","initializesqlite", _dir, _filename, _createifneeded);
Debug.locals.put("Dir", _dir);
Debug.locals.put("fileName", _filename);
Debug.locals.put("createIfNeeded", _createifneeded);
 BA.debugLineNum = 7;BA.debugLine="Sub InitializeSQLite(Dir As String, fileName As St";
Debug.ShouldStop(64);
 BA.debugLineNum = 8;BA.debugLine="Log(\"init sqlite\")";
Debug.ShouldStop(128);
dbm.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("init sqlite")));
 BA.debugLineNum = 9;BA.debugLine="SQLite.InitializeSQLite(Dir, fileName, createIfNe";
Debug.ShouldStop(256);
dbm._sqlite.runVoidMethod ("InitializeSQLite",(Object)(_dir),(Object)(_filename),(Object)(_createifneeded));
 BA.debugLineNum = 10;BA.debugLine="UsePool = False";
Debug.ShouldStop(512);
dbm._usepool = dbm.__c.getField(true,"False");
 BA.debugLineNum = 11;BA.debugLine="End Sub";
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private pool As ConnectionPool";
dbm._pool = RemoteObject.createNew ("anywheresoftware.b4j.object.ConnectionPool");
 //BA.debugLineNum = 3;BA.debugLine="Private SQLite As SQL";
dbm._sqlite = RemoteObject.createNew ("anywheresoftware.b4j.objects.SQL");
 //BA.debugLineNum = 4;BA.debugLine="Public UsePool As Boolean";
dbm._usepool = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setquotes(RemoteObject _str) throws Exception{
try {
		Debug.PushSubsStack("SetQuotes (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,313);
if (RapidSub.canDelegate("setquotes")) return dbm.remoteMe.runUserSub(false, "dbm","setquotes", _str);
Debug.locals.put("str", _str);
 BA.debugLineNum = 313;BA.debugLine="Sub SetQuotes(str As String) As String";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 314;BA.debugLine="str = ABMShared.ReplaceAll(str, \"'\", \"''\")";
Debug.ShouldStop(33554432);
_str = dbm._abmshared.runMethod(true,"_replaceall",(Object)(_str),(Object)(BA.ObjectToString("'")),(Object)(RemoteObject.createImmutable("''")));Debug.locals.put("str", _str);
 BA.debugLineNum = 315;BA.debugLine="Return \"'\" & str & \"'\"";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.concat(RemoteObject.createImmutable("'"),_str,RemoteObject.createImmutable("'"));
 BA.debugLineNum = 316;BA.debugLine="End Sub";
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
public static RemoteObject  _sqlcreate(RemoteObject _sql,RemoteObject _query) throws Exception{
try {
		Debug.PushSubsStack("SQLCreate (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,126);
if (RapidSub.canDelegate("sqlcreate")) return dbm.remoteMe.runUserSub(false, "dbm","sqlcreate", _sql, _query);
RemoteObject _res = RemoteObject.createImmutable(0);
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
 BA.debugLineNum = 126;BA.debugLine="Sub SQLCreate(SQL As SQL, Query As String) As Int";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 127;BA.debugLine="Dim res As Int";
Debug.ShouldStop(1073741824);
_res = RemoteObject.createImmutable(0);Debug.locals.put("res", _res);
 BA.debugLineNum = 128;BA.debugLine="Try";
Debug.ShouldStop(-2147483648);
try { BA.debugLineNum = 129;BA.debugLine="SQL.ExecNonQuery(Query)";
Debug.ShouldStop(1);
_sql.runVoidMethod ("ExecNonQuery",(Object)(_query));
 BA.debugLineNum = 130;BA.debugLine="res = 0";
Debug.ShouldStop(2);
_res = BA.numberCast(int.class, 0);Debug.locals.put("res", _res);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",dbm.ba, e6.toString()); BA.debugLineNum = 132;BA.debugLine="Log(LastException)";
Debug.ShouldStop(8);
dbm.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(dbm.__c.runMethod(false,"LastException",dbm.ba))));
 BA.debugLineNum = 133;BA.debugLine="res = -99999999";
Debug.ShouldStop(16);
_res = BA.numberCast(int.class, -(double) (0 + 99999999));Debug.locals.put("res", _res);
 };
 BA.debugLineNum = 135;BA.debugLine="Return res";
Debug.ShouldStop(64);
if (true) return _res;
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sqldelete(RemoteObject _sql,RemoteObject _query) throws Exception{
try {
		Debug.PushSubsStack("SQLDelete (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,166);
if (RapidSub.canDelegate("sqldelete")) return dbm.remoteMe.runUserSub(false, "dbm","sqldelete", _sql, _query);
RemoteObject _res = RemoteObject.createImmutable(0);
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
 BA.debugLineNum = 166;BA.debugLine="Sub SQLDelete(SQL As SQL, Query As String) As Int";
Debug.ShouldStop(32);
 BA.debugLineNum = 167;BA.debugLine="Dim res As Int";
Debug.ShouldStop(64);
_res = RemoteObject.createImmutable(0);Debug.locals.put("res", _res);
 BA.debugLineNum = 168;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 169;BA.debugLine="SQL.ExecNonQuery(Query)";
Debug.ShouldStop(256);
_sql.runVoidMethod ("ExecNonQuery",(Object)(_query));
 BA.debugLineNum = 170;BA.debugLine="res = 0";
Debug.ShouldStop(512);
_res = BA.numberCast(int.class, 0);Debug.locals.put("res", _res);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",dbm.ba, e6.toString()); BA.debugLineNum = 172;BA.debugLine="Log(LastException)";
Debug.ShouldStop(2048);
dbm.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(dbm.__c.runMethod(false,"LastException",dbm.ba))));
 BA.debugLineNum = 173;BA.debugLine="res = -99999999";
Debug.ShouldStop(4096);
_res = BA.numberCast(int.class, -(double) (0 + 99999999));Debug.locals.put("res", _res);
 };
 BA.debugLineNum = 175;BA.debugLine="Return res";
Debug.ShouldStop(16384);
if (true) return _res;
 BA.debugLineNum = 176;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sqlinsert(RemoteObject _sql,RemoteObject _query) throws Exception{
try {
		Debug.PushSubsStack("SQLInsert (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,138);
if (RapidSub.canDelegate("sqlinsert")) return dbm.remoteMe.runUserSub(false, "dbm","sqlinsert", _sql, _query);
RemoteObject _res = RemoteObject.createImmutable(0);
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
 BA.debugLineNum = 138;BA.debugLine="Sub SQLInsert(SQL As SQL, Query As String) As Int";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="Dim res As Int";
Debug.ShouldStop(1024);
_res = RemoteObject.createImmutable(0);Debug.locals.put("res", _res);
 BA.debugLineNum = 140;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 141;BA.debugLine="SQL.ExecNonQuery(Query)";
Debug.ShouldStop(4096);
_sql.runVoidMethod ("ExecNonQuery",(Object)(_query));
 BA.debugLineNum = 142;BA.debugLine="If UsePool Then";
Debug.ShouldStop(8192);
if (dbm._usepool.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 143;BA.debugLine="res = SQLSelectSingleResult(SQL, \"SELECT LAST_I";
Debug.ShouldStop(16384);
_res = BA.numberCast(int.class, _sqlselectsingleresult(_sql,RemoteObject.createImmutable("SELECT LAST_INSERT_ID()")));Debug.locals.put("res", _res);
 }else {
 BA.debugLineNum = 145;BA.debugLine="res = SQLSelectSingleResult(SQL, \"SELECT last_i";
Debug.ShouldStop(65536);
_res = BA.numberCast(int.class, _sqlselectsingleresult(_sql,RemoteObject.createImmutable("SELECT last_insert_rowid()")));Debug.locals.put("res", _res);
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e10) {
			BA.rdebugUtils.runVoidMethod("setLastException",dbm.ba, e10.toString()); BA.debugLineNum = 148;BA.debugLine="Log(LastException)";
Debug.ShouldStop(524288);
dbm.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(dbm.__c.runMethod(false,"LastException",dbm.ba))));
 BA.debugLineNum = 149;BA.debugLine="res = -99999999";
Debug.ShouldStop(1048576);
_res = BA.numberCast(int.class, -(double) (0 + 99999999));Debug.locals.put("res", _res);
 };
 BA.debugLineNum = 151;BA.debugLine="Return res";
Debug.ShouldStop(4194304);
if (true) return _res;
 BA.debugLineNum = 152;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sqlinsertorupdate(RemoteObject _sql,RemoteObject _selectquery,RemoteObject _insertquery,RemoteObject _updatequery) throws Exception{
try {
		Debug.PushSubsStack("SQLInsertOrUpdate (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,192);
if (RapidSub.canDelegate("sqlinsertorupdate")) return dbm.remoteMe.runUserSub(false, "dbm","sqlinsertorupdate", _sql, _selectquery, _insertquery, _updatequery);
RemoteObject _foundres = RemoteObject.createImmutable(0);
RemoteObject _res = RemoteObject.createImmutable(0);
Debug.locals.put("SQL", _sql);
Debug.locals.put("SelectQuery", _selectquery);
Debug.locals.put("InsertQuery", _insertquery);
Debug.locals.put("UpdateQuery", _updatequery);
 BA.debugLineNum = 192;BA.debugLine="Sub SQLInsertOrUpdate(SQL As SQL, SelectQuery As S";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 193;BA.debugLine="Dim foundres As Int = SQLSelectSingleResult(SQL,";
Debug.ShouldStop(1);
_foundres = BA.numberCast(int.class, _sqlselectsingleresult(_sql,_selectquery));Debug.locals.put("foundres", _foundres);Debug.locals.put("foundres", _foundres);
 BA.debugLineNum = 194;BA.debugLine="If foundres = -99999999 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_foundres,BA.numberCast(double.class, -(double) (0 + 99999999)))) { 
 BA.debugLineNum = 195;BA.debugLine="Return foundres";
Debug.ShouldStop(4);
if (true) return _foundres;
 };
 BA.debugLineNum = 197;BA.debugLine="Dim res As Int";
Debug.ShouldStop(16);
_res = RemoteObject.createImmutable(0);Debug.locals.put("res", _res);
 BA.debugLineNum = 198;BA.debugLine="If foundres = 0 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_foundres,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 199;BA.debugLine="res = SQLInsert(SQL, InsertQuery)";
Debug.ShouldStop(64);
_res = _sqlinsert(_sql,_insertquery);Debug.locals.put("res", _res);
 }else {
 BA.debugLineNum = 201;BA.debugLine="res = SQLUpdate(SQL, UpdateQuery)";
Debug.ShouldStop(256);
_res = _sqlupdate(_sql,_updatequery);Debug.locals.put("res", _res);
 BA.debugLineNum = 202;BA.debugLine="If res = 0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_res,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 203;BA.debugLine="res = foundres";
Debug.ShouldStop(1024);
_res = _foundres;Debug.locals.put("res", _res);
 };
 };
 BA.debugLineNum = 206;BA.debugLine="Return res";
Debug.ShouldStop(8192);
if (true) return _res;
 BA.debugLineNum = 207;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sqlselect(RemoteObject _sql,RemoteObject _query,RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("SQLSelect (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,104);
if (RapidSub.canDelegate("sqlselect")) return dbm.remoteMe.runUserSub(false, "dbm","sqlselect", _sql, _query, _args);
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4j.objects.SQL.ResultSetWrapper");
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("Args", _args);
 BA.debugLineNum = 104;BA.debugLine="Sub SQLSelect(SQL As SQL, Query As String, Args As";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="Dim l As List";
Debug.ShouldStop(256);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("l", _l);
 BA.debugLineNum = 106;BA.debugLine="l.Initialize";
Debug.ShouldStop(512);
_l.runVoidMethod ("Initialize");
 BA.debugLineNum = 107;BA.debugLine="Dim cur As ResultSet";
Debug.ShouldStop(1024);
_cur = RemoteObject.createNew ("anywheresoftware.b4j.objects.SQL.ResultSetWrapper");Debug.locals.put("cur", _cur);
 BA.debugLineNum = 108;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 109;BA.debugLine="cur = SQL.ExecQuery2(Query, Args)";
Debug.ShouldStop(4096);
_cur = _sql.runMethod(false,"ExecQuery2",(Object)(_query),(Object)(_args));Debug.locals.put("cur", _cur);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e7) {
			BA.rdebugUtils.runVoidMethod("setLastException",dbm.ba, e7.toString()); BA.debugLineNum = 111;BA.debugLine="Log(LastException)";
Debug.ShouldStop(16384);
dbm.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(dbm.__c.runMethod(false,"LastException",dbm.ba))));
 BA.debugLineNum = 112;BA.debugLine="Return l";
Debug.ShouldStop(32768);
if (true) return _l;
 };
 BA.debugLineNum = 114;BA.debugLine="Do While cur.NextRow";
Debug.ShouldStop(131072);
while (_cur.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 115;BA.debugLine="Dim res As Map";
Debug.ShouldStop(262144);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("res", _res);
 BA.debugLineNum = 116;BA.debugLine="res.Initialize";
Debug.ShouldStop(524288);
_res.runVoidMethod ("Initialize");
 BA.debugLineNum = 117;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
Debug.ShouldStop(1048576);
{
final int step13 = 1;
final int limit13 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step13 > 0 && _i <= limit13) || (step13 < 0 && _i >= limit13); _i = ((int)(0 + _i + step13)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 118;BA.debugLine="res.Put(cur.GetColumnName(i).ToLowerCase, cur.G";
Debug.ShouldStop(2097152);
_res.runVoidMethod ("Put",(Object)((_cur.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _i))).runMethod(true,"toLowerCase"))),(Object)((_cur.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _i))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 120;BA.debugLine="l.Add(res)";
Debug.ShouldStop(8388608);
_l.runVoidMethod ("Add",(Object)((_res.getObject())));
 }
;
 BA.debugLineNum = 122;BA.debugLine="cur.Close";
Debug.ShouldStop(33554432);
_cur.runVoidMethod ("Close");
 BA.debugLineNum = 123;BA.debugLine="Return l";
Debug.ShouldStop(67108864);
if (true) return _l;
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sqlselectsingleresult(RemoteObject _sql,RemoteObject _query) throws Exception{
try {
		Debug.PushSubsStack("SQLSelectSingleResult (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,178);
if (RapidSub.canDelegate("sqlselectsingleresult")) return dbm.remoteMe.runUserSub(false, "dbm","sqlselectsingleresult", _sql, _query);
RemoteObject _res = RemoteObject.createImmutable("");
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
 BA.debugLineNum = 178;BA.debugLine="Sub SQLSelectSingleResult(SQL As SQL, Query As Str";
Debug.ShouldStop(131072);
 BA.debugLineNum = 179;BA.debugLine="Dim res As String";
Debug.ShouldStop(262144);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 180;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 181;BA.debugLine="res = SQL.ExecQuerySingleResult(Query)";
Debug.ShouldStop(1048576);
_res = _sql.runMethod(true,"ExecQuerySingleResult",(Object)(_query));Debug.locals.put("res", _res);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e5) {
			BA.rdebugUtils.runVoidMethod("setLastException",dbm.ba, e5.toString()); BA.debugLineNum = 183;BA.debugLine="Log(LastException)";
Debug.ShouldStop(4194304);
dbm.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(dbm.__c.runMethod(false,"LastException",dbm.ba))));
 BA.debugLineNum = 184;BA.debugLine="res = -99999999";
Debug.ShouldStop(8388608);
_res = BA.NumberToString(-(double) (0 + 99999999));Debug.locals.put("res", _res);
 };
 BA.debugLineNum = 186;BA.debugLine="If res = Null Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("n",_res)) { 
 BA.debugLineNum = 187;BA.debugLine="Return \"0\"";
Debug.ShouldStop(67108864);
if (true) return BA.ObjectToString("0");
 };
 BA.debugLineNum = 189;BA.debugLine="Return res";
Debug.ShouldStop(268435456);
if (true) return _res;
 BA.debugLineNum = 190;BA.debugLine="End Sub";
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
public static RemoteObject  _sqlupdate(RemoteObject _sql,RemoteObject _query) throws Exception{
try {
		Debug.PushSubsStack("SQLUpdate (dbm) ","dbm",8,dbm.ba,dbm.mostCurrent,154);
if (RapidSub.canDelegate("sqlupdate")) return dbm.remoteMe.runUserSub(false, "dbm","sqlupdate", _sql, _query);
RemoteObject _res = RemoteObject.createImmutable(0);
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
 BA.debugLineNum = 154;BA.debugLine="Sub SQLUpdate(SQL As SQL, Query As String) As Int";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 155;BA.debugLine="Dim res As Int";
Debug.ShouldStop(67108864);
_res = RemoteObject.createImmutable(0);Debug.locals.put("res", _res);
 BA.debugLineNum = 156;BA.debugLine="Try";
Debug.ShouldStop(134217728);
try { BA.debugLineNum = 157;BA.debugLine="SQL.ExecNonQuery(Query)";
Debug.ShouldStop(268435456);
_sql.runVoidMethod ("ExecNonQuery",(Object)(_query));
 BA.debugLineNum = 158;BA.debugLine="res = 0";
Debug.ShouldStop(536870912);
_res = BA.numberCast(int.class, 0);Debug.locals.put("res", _res);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",dbm.ba, e6.toString()); BA.debugLineNum = 160;BA.debugLine="Log(LastException)";
Debug.ShouldStop(-2147483648);
dbm.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(dbm.__c.runMethod(false,"LastException",dbm.ba))));
 BA.debugLineNum = 161;BA.debugLine="res = -99999999";
Debug.ShouldStop(1);
_res = BA.numberCast(int.class, -(double) (0 + 99999999));Debug.locals.put("res", _res);
 };
 BA.debugLineNum = 163;BA.debugLine="Return res";
Debug.ShouldStop(4);
if (true) return _res;
 BA.debugLineNum = 164;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}