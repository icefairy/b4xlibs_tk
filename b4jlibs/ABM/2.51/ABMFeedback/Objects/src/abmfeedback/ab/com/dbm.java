package abmfeedback.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class dbm extends Object{
public static dbm mostCurrent = new dbm();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.StandardBA("abmfeedback.ab.com", "abmfeedback.ab.com.dbm", null);
		ba.loadHtSubs(dbm.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "abmfeedback.ab.com.dbm", ba);
		}
	}
    public static Class<?> getObject() {
		return dbm.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.object.ConnectionPool _pool = null;
public static anywheresoftware.b4j.objects.SQL _sqlite = null;
public static boolean _usepool = false;
public static abmfeedback.ab.com.main _main = null;
public static abmfeedback.ab.com.abmshared _abmshared = null;
public static String  _builddeletequery(String _tablename,anywheresoftware.b4a.objects.collections.Map _wherefields) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
String _col = "";
String _value = "";
 //BA.debugLineNum = 269;BA.debugLine="Sub BuildDeleteQuery(TableName As String, WhereFie";
 //BA.debugLineNum = 270;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 271;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 272;BA.debugLine="sb.Append(\"DELETE FROM \" & TableName)";
_sb.Append("DELETE FROM "+_tablename);
 //BA.debugLineNum = 273;BA.debugLine="If WhereFields.IsInitialized Then";
if (_wherefields.IsInitialized()) { 
 //BA.debugLineNum = 274;BA.debugLine="sb.Append(\" WHERE \")";
_sb.Append(" WHERE ");
 //BA.debugLineNum = 275;BA.debugLine="For i = 0 To WhereFields.Size - 1";
{
final int step6 = 1;
final int limit6 = (int) (_wherefields.getSize()-1);
for (_i = (int) (0) ; (step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6); _i = ((int)(0 + _i + step6)) ) {
 //BA.debugLineNum = 276;BA.debugLine="Dim col As String = WhereFields.GetKeyAt(i)";
_col = BA.ObjectToString(_wherefields.GetKeyAt(_i));
 //BA.debugLineNum = 277;BA.debugLine="Dim value As String = WhereFields.GetValueAt(i)";
_value = BA.ObjectToString(_wherefields.GetValueAt(_i));
 //BA.debugLineNum = 278;BA.debugLine="If i > 0 Then";
if (_i>0) { 
 //BA.debugLineNum = 279;BA.debugLine="sb.Append(\" AND \")";
_sb.Append(" AND ");
 };
 //BA.debugLineNum = 281;BA.debugLine="sb.Append(col & \"=\" & value)";
_sb.Append(_col+"="+_value);
 }
};
 };
 //BA.debugLineNum = 284;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 285;BA.debugLine="End Sub";
return "";
}
public static String  _buildinsertquery(String _tablename,anywheresoftware.b4a.objects.collections.Map _fields) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
String _col = "";
 //BA.debugLineNum = 246;BA.debugLine="Sub BuildInsertQuery(TableName As String, Fields A";
 //BA.debugLineNum = 247;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 248;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 249;BA.debugLine="sb.Append(\"INSERT INTO \" & TableName & \"(\")";
_sb.Append("INSERT INTO "+_tablename+"(");
 //BA.debugLineNum = 250;BA.debugLine="For i = 0 To Fields.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_fields.getSize()-1);
for (_i = (int) (0) ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
 //BA.debugLineNum = 251;BA.debugLine="Dim col As String = Fields.GetKeyAt(i)";
_col = BA.ObjectToString(_fields.GetKeyAt(_i));
 //BA.debugLineNum = 252;BA.debugLine="If i > 0 Then";
if (_i>0) { 
 //BA.debugLineNum = 253;BA.debugLine="sb.Append(\", \")";
_sb.Append(", ");
 };
 //BA.debugLineNum = 255;BA.debugLine="sb.Append(col)";
_sb.Append(_col);
 }
};
 //BA.debugLineNum = 257;BA.debugLine="sb.Append(\") VALUES (\")";
_sb.Append(") VALUES (");
 //BA.debugLineNum = 258;BA.debugLine="For i = 0 To Fields.Size - 1";
{
final int step12 = 1;
final int limit12 = (int) (_fields.getSize()-1);
for (_i = (int) (0) ; (step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12); _i = ((int)(0 + _i + step12)) ) {
 //BA.debugLineNum = 259;BA.debugLine="Dim col As String = Fields.GetValueAt(i)";
_col = BA.ObjectToString(_fields.GetValueAt(_i));
 //BA.debugLineNum = 260;BA.debugLine="If i > 0 Then";
if (_i>0) { 
 //BA.debugLineNum = 261;BA.debugLine="sb.Append(\", \")";
_sb.Append(", ");
 };
 //BA.debugLineNum = 263;BA.debugLine="sb.Append(col)";
_sb.Append(_col);
 }
};
 //BA.debugLineNum = 265;BA.debugLine="sb.Append(\")\")";
_sb.Append(")");
 //BA.debugLineNum = 266;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 267;BA.debugLine="End Sub";
return "";
}
public static String  _buildselectquery(String _tablename,anywheresoftware.b4a.objects.collections.Map _fields,anywheresoftware.b4a.objects.collections.Map _wherefields,anywheresoftware.b4a.objects.collections.Map _orderfields) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
String _col = "";
String _value = "";
 //BA.debugLineNum = 209;BA.debugLine="Sub BuildSelectQuery(TableName As String, Fields A";
 //BA.debugLineNum = 210;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 211;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 212;BA.debugLine="sb.Append(\"SELECT \")";
_sb.Append("SELECT ");
 //BA.debugLineNum = 213;BA.debugLine="For i = 0 To Fields.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_fields.getSize()-1);
for (_i = (int) (0) ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
 //BA.debugLineNum = 214;BA.debugLine="Dim col As String = Fields.GetKeyAt(i)";
_col = BA.ObjectToString(_fields.GetKeyAt(_i));
 //BA.debugLineNum = 215;BA.debugLine="If i > 0 Then";
if (_i>0) { 
 //BA.debugLineNum = 216;BA.debugLine="sb.Append(\", \")";
_sb.Append(", ");
 };
 //BA.debugLineNum = 218;BA.debugLine="sb.Append(col)";
_sb.Append(_col);
 }
};
 //BA.debugLineNum = 220;BA.debugLine="sb.Append(\" FROM \" & TableName)";
_sb.Append(" FROM "+_tablename);
 //BA.debugLineNum = 221;BA.debugLine="If WhereFields.IsInitialized Then";
if (_wherefields.IsInitialized()) { 
 //BA.debugLineNum = 222;BA.debugLine="sb.Append(\" WHERE \")";
_sb.Append(" WHERE ");
 //BA.debugLineNum = 223;BA.debugLine="For i = 0 To WhereFields.Size - 1";
{
final int step14 = 1;
final int limit14 = (int) (_wherefields.getSize()-1);
for (_i = (int) (0) ; (step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14); _i = ((int)(0 + _i + step14)) ) {
 //BA.debugLineNum = 224;BA.debugLine="Dim col As String = WhereFields.GetKeyAt(i)";
_col = BA.ObjectToString(_wherefields.GetKeyAt(_i));
 //BA.debugLineNum = 225;BA.debugLine="Dim value As String = WhereFields.GetValueAt(i)";
_value = BA.ObjectToString(_wherefields.GetValueAt(_i));
 //BA.debugLineNum = 226;BA.debugLine="If i > 0 Then";
if (_i>0) { 
 //BA.debugLineNum = 227;BA.debugLine="sb.Append(\" AND \")";
_sb.Append(" AND ");
 };
 //BA.debugLineNum = 229;BA.debugLine="sb.Append(col & \"=\" & value)";
_sb.Append(_col+"="+_value);
 }
};
 };
 //BA.debugLineNum = 232;BA.debugLine="If OrderFields.IsInitialized Then";
if (_orderfields.IsInitialized()) { 
 //BA.debugLineNum = 233;BA.debugLine="sb.Append(\" ORDER BY \")";
_sb.Append(" ORDER BY ");
 //BA.debugLineNum = 234;BA.debugLine="For i = 0 To WhereFields.Size - 1";
{
final int step25 = 1;
final int limit25 = (int) (_wherefields.getSize()-1);
for (_i = (int) (0) ; (step25 > 0 && _i <= limit25) || (step25 < 0 && _i >= limit25); _i = ((int)(0 + _i + step25)) ) {
 //BA.debugLineNum = 235;BA.debugLine="Dim col As String = OrderFields.GetKeyAt(i)";
_col = BA.ObjectToString(_orderfields.GetKeyAt(_i));
 //BA.debugLineNum = 236;BA.debugLine="If i > 0 Then";
if (_i>0) { 
 //BA.debugLineNum = 237;BA.debugLine="sb.Append(\", \")";
_sb.Append(", ");
 };
 //BA.debugLineNum = 239;BA.debugLine="sb.Append(col)";
_sb.Append(_col);
 }
};
 };
 //BA.debugLineNum = 243;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 244;BA.debugLine="End Sub";
return "";
}
public static String  _buildupdatequery(String _tablename,anywheresoftware.b4a.objects.collections.Map _fields,anywheresoftware.b4a.objects.collections.Map _wherefields) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
String _col = "";
String _value = "";
 //BA.debugLineNum = 287;BA.debugLine="Sub BuildUpdateQuery(TableName As String, Fields A";
 //BA.debugLineNum = 288;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 289;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 290;BA.debugLine="sb.Append(\"UPDATE \" & TableName & \" SET \")";
_sb.Append("UPDATE "+_tablename+" SET ");
 //BA.debugLineNum = 291;BA.debugLine="For i = 0 To Fields.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_fields.getSize()-1);
for (_i = (int) (0) ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
 //BA.debugLineNum = 292;BA.debugLine="Dim col As String = Fields.GetKeyAt(i)";
_col = BA.ObjectToString(_fields.GetKeyAt(_i));
 //BA.debugLineNum = 293;BA.debugLine="Dim value As String = Fields.GetValueAt(i)";
_value = BA.ObjectToString(_fields.GetValueAt(_i));
 //BA.debugLineNum = 294;BA.debugLine="If i > 0 Then";
if (_i>0) { 
 //BA.debugLineNum = 295;BA.debugLine="sb.Append(\", \")";
_sb.Append(", ");
 };
 //BA.debugLineNum = 297;BA.debugLine="sb.Append(col & \"=\" & value)";
_sb.Append(_col+"="+_value);
 }
};
 //BA.debugLineNum = 299;BA.debugLine="If WhereFields.IsInitialized Then";
if (_wherefields.IsInitialized()) { 
 //BA.debugLineNum = 300;BA.debugLine="sb.Append(\" WHERE \")";
_sb.Append(" WHERE ");
 //BA.debugLineNum = 301;BA.debugLine="For i = 0 To WhereFields.Size - 1";
{
final int step14 = 1;
final int limit14 = (int) (_wherefields.getSize()-1);
for (_i = (int) (0) ; (step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14); _i = ((int)(0 + _i + step14)) ) {
 //BA.debugLineNum = 302;BA.debugLine="Dim col As String = WhereFields.GetKeyAt(i)";
_col = BA.ObjectToString(_wherefields.GetKeyAt(_i));
 //BA.debugLineNum = 303;BA.debugLine="Dim value As String = WhereFields.GetValueAt(i)";
_value = BA.ObjectToString(_wherefields.GetValueAt(_i));
 //BA.debugLineNum = 304;BA.debugLine="If i > 0 Then";
if (_i>0) { 
 //BA.debugLineNum = 305;BA.debugLine="sb.Append(\" AND \")";
_sb.Append(" AND ");
 };
 //BA.debugLineNum = 307;BA.debugLine="sb.Append(col & \"=\" & value)";
_sb.Append(_col+"="+_value);
 }
};
 };
 //BA.debugLineNum = 310;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 311;BA.debugLine="End Sub";
return "";
}
public static String  _closesql(anywheresoftware.b4j.objects.SQL _mysql) throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Sub CloseSQL(mySQL As SQL)";
 //BA.debugLineNum = 36;BA.debugLine="If UsePool Then";
if (_usepool) { 
 //BA.debugLineNum = 37;BA.debugLine="mySQL.Close";
_mysql.Close();
 };
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public static String  _createtablesifneeded() throws Exception{
anywheresoftware.b4j.objects.SQL _sql = null;
String _sql_str = "";
 //BA.debugLineNum = 41;BA.debugLine="Sub CreateTablesIfNeeded()";
 //BA.debugLineNum = 42;BA.debugLine="Dim SQL As SQL = GetSQL";
_sql = _getsql();
 //BA.debugLineNum = 43;BA.debugLine="Dim SQL_str As String";
_sql_str = "";
 //BA.debugLineNum = 46;BA.debugLine="If UsePool Then";
if (_usepool) { 
 //BA.debugLineNum = 47;BA.debugLine="SQL_str = \"SELECT COUNT(*) FROM information_sche";
_sql_str = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'abmfeedback' And table_name = 'cases';";
 //BA.debugLineNum = 48;BA.debugLine="If SQLSelectSingleResult(SQL, SQL_str) = 0 Then";
if ((_sqlselectsingleresult(_sql,_sql_str)).equals(BA.NumberToString(0))) { 
 //BA.debugLineNum = 49;BA.debugLine="SQL_str = \"CREATE TABLE cases (CaseID INT NOT N";
_sql_str = "CREATE TABLE cases (CaseID INT NOT NULL AUTO_INCREMENT, CaseNumber VARCHAR(100), CaseType INT, CaseSummary VARCHAR(255), CaseDescription TEXT , CaseStatus INT, CaseUserID INT, CaseCreationDate VARCHAR(50), CaseFixedVersion VARCHAR(10), PRIMARY KEY (CaseID))";
 //BA.debugLineNum = 50;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 //BA.debugLineNum = 55;BA.debugLine="SQL_str = \"CREATE TABLE caseattachments(CaseAID";
_sql_str = "CREATE TABLE caseattachments(CaseAID INT NOT NULL AUTO_INCREMENT, CaseACaseID INT, CaseAType INT, CaseAValue VARCHAR(255), PRIMARY KEY (CaseAID))";
 //BA.debugLineNum = 56;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 //BA.debugLineNum = 58;BA.debugLine="SQL_str = \"CREATE TABLE casenotes (CaseNID INT";
_sql_str = "CREATE TABLE casenotes (CaseNID INT NOT NULL AUTO_INCREMENT, CaseNCaseID INT, CaseNUserID INT, CaseNDescription TEXT, CaseNCreationDate VARCHAR(50), PRIMARY KEY (CaseNID))";
 //BA.debugLineNum = 59;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 //BA.debugLineNum = 61;BA.debugLine="SQL_str = \"CREATE TABLE caseread (CaseRID INT N";
_sql_str = "CREATE TABLE caseread (CaseRID INT NOT NULL AUTO_INCREMENT, CaseRCaseID INT, CaseRUserID INT, CaseRStatus INT, PRIMARY KEY (CaseRID))";
 //BA.debugLineNum = 62;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 //BA.debugLineNum = 64;BA.debugLine="SQL_str = \"CREATE TABLE users (UserID INT NOT N";
_sql_str = "CREATE TABLE users (UserID INT NOT NULL AUTO_INCREMENT, UserName VARCHAR(255), UserLogin VARCHAR(255), UserPassword VARCHAR(100), UserType INT, UserActive INT, PRIMARY KEY (UserID))";
 //BA.debugLineNum = 65;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 //BA.debugLineNum = 68;BA.debugLine="SQL_str = \"INSERT INTO users (UserName, UserLog";
_sql_str = "INSERT INTO users (UserName, UserLogin, UserPassword, UserType, UserActive) VALUES ('Admin', 'Admin', 'Admin', 1, 0)";
 //BA.debugLineNum = 69;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 };
 }else {
 //BA.debugLineNum = 73;BA.debugLine="SQL_str = \"SELECT count(name) FROM sqlite_master";
_sql_str = "SELECT count(name) FROM sqlite_master WHERE type='table' AND name='Cases'";
 //BA.debugLineNum = 74;BA.debugLine="If SQLSelectSingleResult(SQL, SQL_str) = 0 Then";
if ((_sqlselectsingleresult(_sql,_sql_str)).equals(BA.NumberToString(0))) { 
 //BA.debugLineNum = 75;BA.debugLine="SQL_str = \"PRAGMA journal_mode = wal\" 'best mod";
_sql_str = "PRAGMA journal_mode = wal";
 //BA.debugLineNum = 76;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 //BA.debugLineNum = 78;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [cases] (";
_sql_str = "CREATE TABLE IF NOT EXISTS [cases] ([CaseID] INTEGER PRIMARY KEY, [CaseNumber] TEXT, [CaseType] INTEGER, [CaseSummary] TEXT, [CaseDescription] TEXT, [CaseStatus] INTEGER, [CaseUserID] INTEGER, [CaseCreationDate] TEXT, [CaseFixedVersion] TEXT)";
 //BA.debugLineNum = 79;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 //BA.debugLineNum = 84;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [caseatta";
_sql_str = "CREATE TABLE IF NOT EXISTS [caseattachments]([CaseAID] INTEGER PRIMARY KEY, [CaseACaseID] INTEGER, [CaseAType] INTEGER, [CaseAValue] TEXT)";
 //BA.debugLineNum = 85;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 //BA.debugLineNum = 87;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [casenote";
_sql_str = "CREATE TABLE IF NOT EXISTS [casenotes]([CaseNID] INTEGER PRIMARY KEY, [CaseNCaseID] INTEGER, [CaseNUserID] INTEGER, [CaseNDescription] TEXT, [CaseNCreationDate] TEXT)";
 //BA.debugLineNum = 88;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 //BA.debugLineNum = 90;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [caseread";
_sql_str = "CREATE TABLE IF NOT EXISTS [caseread]([CaseRID] INTEGER PRIMARY KEY, [CaseRCaseID] INTEGER, [CaseRUserID] INTEGER, [CaseRStatus] INTEGER)";
 //BA.debugLineNum = 91;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 //BA.debugLineNum = 93;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [users] (";
_sql_str = "CREATE TABLE IF NOT EXISTS [users] ([UserID] INTEGER PRIMARY KEY, [UserName] TEXT, [UserLogin] TEXT, [UserPassword] TEXT, [UserType] INTEGER, [UserActive] INTEGER)";
 //BA.debugLineNum = 94;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 //BA.debugLineNum = 97;BA.debugLine="SQL_str = \"INSERT INTO [users] (UserID, UserNam";
_sql_str = "INSERT INTO [users] (UserID, UserName, UserLogin, UserPassword, UserType, UserActive) VALUES (null, 'Admin', 'Admin', 'Admin', 1, 0)";
 //BA.debugLineNum = 98;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 };
 };
 //BA.debugLineNum = 101;BA.debugLine="CloseSQL(SQL)";
_closesql(_sql);
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4j.objects.SQL  _getsql() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub GetSQL() As SQL";
 //BA.debugLineNum = 28;BA.debugLine="If UsePool Then";
if (_usepool) { 
 //BA.debugLineNum = 29;BA.debugLine="Return pool.GetConnection";
if (true) return _pool.GetConnection();
 }else {
 //BA.debugLineNum = 31;BA.debugLine="Return SQLite";
if (true) return _sqlite;
 };
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return null;
}
public static String  _initializemysql(String _jdbcurl,String _login,String _password,int _poolsize) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 13;BA.debugLine="Sub InitializeMySQL(jdbcUrl As String ,login As St";
 //BA.debugLineNum = 14;BA.debugLine="Log(\"init mysql\")";
anywheresoftware.b4a.keywords.Common.Log("init mysql");
 //BA.debugLineNum = 15;BA.debugLine="UsePool = True";
_usepool = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 16;BA.debugLine="Try";
try { //BA.debugLineNum = 17;BA.debugLine="pool.Initialize(\"com.mysql.jdbc.Driver\", jd";
_pool.Initialize("com.mysql.jdbc.Driver",_jdbcurl,_login,_password);
 } 
       catch (Exception e6) {
			ba.setLastException(e6); //BA.debugLineNum = 19;BA.debugLine="Log(\"Last Pool Init Except: \"&LastException";
anywheresoftware.b4a.keywords.Common.Log("Last Pool Init Except: "+anywheresoftware.b4a.keywords.Common.LastException(ba).getMessage());
 };
 //BA.debugLineNum = 23;BA.debugLine="Dim jo As JavaObject = pool";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_pool.getObject()));
 //BA.debugLineNum = 24;BA.debugLine="jo.RunMethod(\"setMaxPoolSize\", Array(poolSize)";
_jo.RunMethod("setMaxPoolSize",new Object[]{(Object)(_poolsize)});
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _initializesqlite(String _dir,String _filename,boolean _createifneeded) throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub InitializeSQLite(Dir As String, fileName As St";
 //BA.debugLineNum = 8;BA.debugLine="Log(\"init sqlite\")";
anywheresoftware.b4a.keywords.Common.Log("init sqlite");
 //BA.debugLineNum = 9;BA.debugLine="SQLite.InitializeSQLite(Dir, fileName, createIfNe";
_sqlite.InitializeSQLite(_dir,_filename,_createifneeded);
 //BA.debugLineNum = 10;BA.debugLine="UsePool = False";
_usepool = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private pool As ConnectionPool";
_pool = new anywheresoftware.b4j.object.ConnectionPool();
 //BA.debugLineNum = 3;BA.debugLine="Private SQLite As SQL";
_sqlite = new anywheresoftware.b4j.objects.SQL();
 //BA.debugLineNum = 4;BA.debugLine="Public UsePool As Boolean";
_usepool = false;
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return "";
}
public static String  _setquotes(String _str) throws Exception{
 //BA.debugLineNum = 313;BA.debugLine="Sub SetQuotes(str As String) As String";
 //BA.debugLineNum = 314;BA.debugLine="str = ABMShared.ReplaceAll(str, \"'\", \"''\")";
_str = _abmshared._replaceall(_str,"'","''");
 //BA.debugLineNum = 315;BA.debugLine="Return \"'\" & str & \"'\"";
if (true) return "'"+_str+"'";
 //BA.debugLineNum = 316;BA.debugLine="End Sub";
return "";
}
public static int  _sqlcreate(anywheresoftware.b4j.objects.SQL _sql,String _query) throws Exception{
int _res = 0;
 //BA.debugLineNum = 126;BA.debugLine="Sub SQLCreate(SQL As SQL, Query As String) As Int";
 //BA.debugLineNum = 127;BA.debugLine="Dim res As Int";
_res = 0;
 //BA.debugLineNum = 128;BA.debugLine="Try";
try { //BA.debugLineNum = 129;BA.debugLine="SQL.ExecNonQuery(Query)";
_sql.ExecNonQuery(_query);
 //BA.debugLineNum = 130;BA.debugLine="res = 0";
_res = (int) (0);
 } 
       catch (Exception e6) {
			ba.setLastException(e6); //BA.debugLineNum = 132;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 //BA.debugLineNum = 133;BA.debugLine="res = -99999999";
_res = (int) (-99999999);
 };
 //BA.debugLineNum = 135;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return 0;
}
public static int  _sqldelete(anywheresoftware.b4j.objects.SQL _sql,String _query) throws Exception{
int _res = 0;
 //BA.debugLineNum = 166;BA.debugLine="Sub SQLDelete(SQL As SQL, Query As String) As Int";
 //BA.debugLineNum = 167;BA.debugLine="Dim res As Int";
_res = 0;
 //BA.debugLineNum = 168;BA.debugLine="Try";
try { //BA.debugLineNum = 169;BA.debugLine="SQL.ExecNonQuery(Query)";
_sql.ExecNonQuery(_query);
 //BA.debugLineNum = 170;BA.debugLine="res = 0";
_res = (int) (0);
 } 
       catch (Exception e6) {
			ba.setLastException(e6); //BA.debugLineNum = 172;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 //BA.debugLineNum = 173;BA.debugLine="res = -99999999";
_res = (int) (-99999999);
 };
 //BA.debugLineNum = 175;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 176;BA.debugLine="End Sub";
return 0;
}
public static int  _sqlinsert(anywheresoftware.b4j.objects.SQL _sql,String _query) throws Exception{
int _res = 0;
 //BA.debugLineNum = 138;BA.debugLine="Sub SQLInsert(SQL As SQL, Query As String) As Int";
 //BA.debugLineNum = 139;BA.debugLine="Dim res As Int";
_res = 0;
 //BA.debugLineNum = 140;BA.debugLine="Try";
try { //BA.debugLineNum = 141;BA.debugLine="SQL.ExecNonQuery(Query)";
_sql.ExecNonQuery(_query);
 //BA.debugLineNum = 142;BA.debugLine="If UsePool Then";
if (_usepool) { 
 //BA.debugLineNum = 143;BA.debugLine="res = SQLSelectSingleResult(SQL, \"SELECT LAST_I";
_res = (int)(Double.parseDouble(_sqlselectsingleresult(_sql,"SELECT LAST_INSERT_ID()")));
 }else {
 //BA.debugLineNum = 145;BA.debugLine="res = SQLSelectSingleResult(SQL, \"SELECT last_i";
_res = (int)(Double.parseDouble(_sqlselectsingleresult(_sql,"SELECT last_insert_rowid()")));
 };
 } 
       catch (Exception e10) {
			ba.setLastException(e10); //BA.debugLineNum = 148;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 //BA.debugLineNum = 149;BA.debugLine="res = -99999999";
_res = (int) (-99999999);
 };
 //BA.debugLineNum = 151;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return 0;
}
public static int  _sqlinsertorupdate(anywheresoftware.b4j.objects.SQL _sql,String _selectquery,String _insertquery,String _updatequery) throws Exception{
int _foundres = 0;
int _res = 0;
 //BA.debugLineNum = 192;BA.debugLine="Sub SQLInsertOrUpdate(SQL As SQL, SelectQuery As S";
 //BA.debugLineNum = 193;BA.debugLine="Dim foundres As Int = SQLSelectSingleResult(SQL,";
_foundres = (int)(Double.parseDouble(_sqlselectsingleresult(_sql,_selectquery)));
 //BA.debugLineNum = 194;BA.debugLine="If foundres = -99999999 Then";
if (_foundres==-99999999) { 
 //BA.debugLineNum = 195;BA.debugLine="Return foundres";
if (true) return _foundres;
 };
 //BA.debugLineNum = 197;BA.debugLine="Dim res As Int";
_res = 0;
 //BA.debugLineNum = 198;BA.debugLine="If foundres = 0 Then";
if (_foundres==0) { 
 //BA.debugLineNum = 199;BA.debugLine="res = SQLInsert(SQL, InsertQuery)";
_res = _sqlinsert(_sql,_insertquery);
 }else {
 //BA.debugLineNum = 201;BA.debugLine="res = SQLUpdate(SQL, UpdateQuery)";
_res = _sqlupdate(_sql,_updatequery);
 //BA.debugLineNum = 202;BA.debugLine="If res = 0 Then";
if (_res==0) { 
 //BA.debugLineNum = 203;BA.debugLine="res = foundres";
_res = _foundres;
 };
 };
 //BA.debugLineNum = 206;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _sqlselect(anywheresoftware.b4j.objects.SQL _sql,String _query,anywheresoftware.b4a.objects.collections.List _args) throws Exception{
anywheresoftware.b4a.objects.collections.List _l = null;
anywheresoftware.b4j.objects.SQL.ResultSetWrapper _cur = null;
anywheresoftware.b4a.objects.collections.Map _res = null;
int _i = 0;
 //BA.debugLineNum = 104;BA.debugLine="Sub SQLSelect(SQL As SQL, Query As String, Args As";
 //BA.debugLineNum = 105;BA.debugLine="Dim l As List";
_l = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 106;BA.debugLine="l.Initialize";
_l.Initialize();
 //BA.debugLineNum = 107;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4j.objects.SQL.ResultSetWrapper();
 //BA.debugLineNum = 108;BA.debugLine="Try";
try { //BA.debugLineNum = 109;BA.debugLine="cur = SQL.ExecQuery2(Query, Args)";
_cur = _sql.ExecQuery2(_query,_args);
 } 
       catch (Exception e7) {
			ba.setLastException(e7); //BA.debugLineNum = 111;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 //BA.debugLineNum = 112;BA.debugLine="Return l";
if (true) return _l;
 };
 //BA.debugLineNum = 114;BA.debugLine="Do While cur.NextRow";
while (_cur.NextRow()) {
 //BA.debugLineNum = 115;BA.debugLine="Dim res As Map";
_res = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 116;BA.debugLine="res.Initialize";
_res.Initialize();
 //BA.debugLineNum = 117;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
{
final int step13 = 1;
final int limit13 = (int) (_cur.getColumnCount()-1);
for (_i = (int) (0) ; (step13 > 0 && _i <= limit13) || (step13 < 0 && _i >= limit13); _i = ((int)(0 + _i + step13)) ) {
 //BA.debugLineNum = 118;BA.debugLine="res.Put(cur.GetColumnName(i).ToLowerCase, cur.G";
_res.Put((Object)(_cur.GetColumnName(_i).toLowerCase()),(Object)(_cur.GetString2(_i)));
 }
};
 //BA.debugLineNum = 120;BA.debugLine="l.Add(res)";
_l.Add((Object)(_res.getObject()));
 }
;
 //BA.debugLineNum = 122;BA.debugLine="cur.Close";
_cur.Close();
 //BA.debugLineNum = 123;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return null;
}
public static String  _sqlselectsingleresult(anywheresoftware.b4j.objects.SQL _sql,String _query) throws Exception{
String _res = "";
 //BA.debugLineNum = 178;BA.debugLine="Sub SQLSelectSingleResult(SQL As SQL, Query As Str";
 //BA.debugLineNum = 179;BA.debugLine="Dim res As String";
_res = "";
 //BA.debugLineNum = 180;BA.debugLine="Try";
try { //BA.debugLineNum = 181;BA.debugLine="res = SQL.ExecQuerySingleResult(Query)";
_res = _sql.ExecQuerySingleResult(_query);
 } 
       catch (Exception e5) {
			ba.setLastException(e5); //BA.debugLineNum = 183;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 //BA.debugLineNum = 184;BA.debugLine="res = -99999999";
_res = BA.NumberToString(-99999999);
 };
 //BA.debugLineNum = 186;BA.debugLine="If res = Null Then";
if (_res== null) { 
 //BA.debugLineNum = 187;BA.debugLine="Return \"0\"";
if (true) return "0";
 };
 //BA.debugLineNum = 189;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return "";
}
public static int  _sqlupdate(anywheresoftware.b4j.objects.SQL _sql,String _query) throws Exception{
int _res = 0;
 //BA.debugLineNum = 154;BA.debugLine="Sub SQLUpdate(SQL As SQL, Query As String) As Int";
 //BA.debugLineNum = 155;BA.debugLine="Dim res As Int";
_res = 0;
 //BA.debugLineNum = 156;BA.debugLine="Try";
try { //BA.debugLineNum = 157;BA.debugLine="SQL.ExecNonQuery(Query)";
_sql.ExecNonQuery(_query);
 //BA.debugLineNum = 158;BA.debugLine="res = 0";
_res = (int) (0);
 } 
       catch (Exception e6) {
			ba.setLastException(e6); //BA.debugLineNum = 160;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 //BA.debugLineNum = 161;BA.debugLine="res = -99999999";
_res = (int) (-99999999);
 };
 //BA.debugLineNum = 163;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return 0;
}
}
