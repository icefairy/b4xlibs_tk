package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class dbm extends Object{
public static dbm mostCurrent = new dbm();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.ShellBA("b4j.example", "b4j.example.dbm", null);
		ba.loadHtSubs(dbm.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.dbm", ba);
		}
	}
    public static Class<?> getObject() {
		return dbm.class;
	}

 
public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.object.ConnectionPool _pool = null;
public static anywheresoftware.b4j.objects.SQL _sqlite = null;
public static boolean _usepool = false;
public static b4j.example.main _main = null;
public static b4j.example.abmshared _abmshared = null;
public static String  _initializemysql(String _jdbcurl,String _login,String _password,int _poolsize) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "initializemysql"))
	return (String) Debug.delegate(ba, "initializemysql", new Object[] {_jdbcurl,_login,_password,_poolsize});
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Sub InitializeMySQL(jdbcUrl As String ,login As St";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="Log(\"init mysql\")";
anywheresoftware.b4a.keywords.Common.Log("init mysql");
RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="UsePool = True";
_usepool = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="Try";
try {RDebugUtils.currentLine=4915204;
 //BA.debugLineNum = 4915204;BA.debugLine="pool.Initialize(\"com.mysql.jdbc.Driver\", jd";
_pool.Initialize("com.mysql.jdbc.Driver",_jdbcurl,_login,_password);
 } 
       catch (Exception e6) {
			ba.setLastException(e6);RDebugUtils.currentLine=4915206;
 //BA.debugLineNum = 4915206;BA.debugLine="Log(\"Last Pool Init Except: \"&LastException";
anywheresoftware.b4a.keywords.Common.Log("Last Pool Init Except: "+anywheresoftware.b4a.keywords.Common.LastException(ba).getMessage());
 };
RDebugUtils.currentLine=4915210;
 //BA.debugLineNum = 4915210;BA.debugLine="Dim jo As JavaObject = pool";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_pool.getObject()));
RDebugUtils.currentLine=4915211;
 //BA.debugLineNum = 4915211;BA.debugLine="jo.RunMethod(\"setMaxPoolSize\", Array(poolSize)";
_jo.RunMethod("setMaxPoolSize",new Object[]{(Object)(_poolsize)});
RDebugUtils.currentLine=4915212;
 //BA.debugLineNum = 4915212;BA.debugLine="End Sub";
return "";
}
public static String  _builddeletequery(String _tablename,anywheresoftware.b4a.objects.collections.Map _wherefields) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "builddeletequery"))
	return (String) Debug.delegate(ba, "builddeletequery", new Object[] {_tablename,_wherefields});
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
String _col = "";
String _value = "";
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub BuildDeleteQuery(TableName As String, WhereFie";
RDebugUtils.currentLine=5767169;
 //BA.debugLineNum = 5767169;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=5767171;
 //BA.debugLineNum = 5767171;BA.debugLine="sb.Append(\"DELETE FROM \" & TableName)";
_sb.Append("DELETE FROM "+_tablename);
RDebugUtils.currentLine=5767172;
 //BA.debugLineNum = 5767172;BA.debugLine="If WhereFields.IsInitialized Then";
if (_wherefields.IsInitialized()) { 
RDebugUtils.currentLine=5767173;
 //BA.debugLineNum = 5767173;BA.debugLine="sb.Append(\" WHERE \")";
_sb.Append(" WHERE ");
RDebugUtils.currentLine=5767174;
 //BA.debugLineNum = 5767174;BA.debugLine="For i = 0 To WhereFields.Size - 1";
{
final int step6 = 1;
final int limit6 = (int) (_wherefields.getSize()-1);
for (_i = (int) (0) ; (step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6); _i = ((int)(0 + _i + step6)) ) {
RDebugUtils.currentLine=5767175;
 //BA.debugLineNum = 5767175;BA.debugLine="Dim col As String = WhereFields.GetKeyAt(i)";
_col = BA.ObjectToString(_wherefields.GetKeyAt(_i));
RDebugUtils.currentLine=5767176;
 //BA.debugLineNum = 5767176;BA.debugLine="Dim value As String = WhereFields.GetValueAt(i)";
_value = BA.ObjectToString(_wherefields.GetValueAt(_i));
RDebugUtils.currentLine=5767177;
 //BA.debugLineNum = 5767177;BA.debugLine="If i > 0 Then";
if (_i>0) { 
RDebugUtils.currentLine=5767178;
 //BA.debugLineNum = 5767178;BA.debugLine="sb.Append(\" AND \")";
_sb.Append(" AND ");
 };
RDebugUtils.currentLine=5767180;
 //BA.debugLineNum = 5767180;BA.debugLine="sb.Append(col & \"=\" & value)";
_sb.Append(_col+"="+_value);
 }
};
 };
RDebugUtils.currentLine=5767183;
 //BA.debugLineNum = 5767183;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
RDebugUtils.currentLine=5767184;
 //BA.debugLineNum = 5767184;BA.debugLine="End Sub";
return "";
}
public static String  _buildinsertquery(String _tablename,anywheresoftware.b4a.objects.collections.Map _fields) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "buildinsertquery"))
	return (String) Debug.delegate(ba, "buildinsertquery", new Object[] {_tablename,_fields});
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
String _col = "";
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Sub BuildInsertQuery(TableName As String, Fields A";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=5701635;
 //BA.debugLineNum = 5701635;BA.debugLine="sb.Append(\"INSERT INTO \" & TableName & \"(\")";
_sb.Append("INSERT INTO "+_tablename+"(");
RDebugUtils.currentLine=5701636;
 //BA.debugLineNum = 5701636;BA.debugLine="For i = 0 To Fields.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_fields.getSize()-1);
for (_i = (int) (0) ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
RDebugUtils.currentLine=5701637;
 //BA.debugLineNum = 5701637;BA.debugLine="Dim col As String = Fields.GetKeyAt(i)";
_col = BA.ObjectToString(_fields.GetKeyAt(_i));
RDebugUtils.currentLine=5701638;
 //BA.debugLineNum = 5701638;BA.debugLine="If i > 0 Then";
if (_i>0) { 
RDebugUtils.currentLine=5701639;
 //BA.debugLineNum = 5701639;BA.debugLine="sb.Append(\", \")";
_sb.Append(", ");
 };
RDebugUtils.currentLine=5701641;
 //BA.debugLineNum = 5701641;BA.debugLine="sb.Append(col)";
_sb.Append(_col);
 }
};
RDebugUtils.currentLine=5701643;
 //BA.debugLineNum = 5701643;BA.debugLine="sb.Append(\") VALUES (\")";
_sb.Append(") VALUES (");
RDebugUtils.currentLine=5701644;
 //BA.debugLineNum = 5701644;BA.debugLine="For i = 0 To Fields.Size - 1";
{
final int step12 = 1;
final int limit12 = (int) (_fields.getSize()-1);
for (_i = (int) (0) ; (step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12); _i = ((int)(0 + _i + step12)) ) {
RDebugUtils.currentLine=5701645;
 //BA.debugLineNum = 5701645;BA.debugLine="Dim col As String = Fields.GetValueAt(i)";
_col = BA.ObjectToString(_fields.GetValueAt(_i));
RDebugUtils.currentLine=5701646;
 //BA.debugLineNum = 5701646;BA.debugLine="If i > 0 Then";
if (_i>0) { 
RDebugUtils.currentLine=5701647;
 //BA.debugLineNum = 5701647;BA.debugLine="sb.Append(\", \")";
_sb.Append(", ");
 };
RDebugUtils.currentLine=5701649;
 //BA.debugLineNum = 5701649;BA.debugLine="sb.Append(col)";
_sb.Append(_col);
 }
};
RDebugUtils.currentLine=5701651;
 //BA.debugLineNum = 5701651;BA.debugLine="sb.Append(\")\")";
_sb.Append(")");
RDebugUtils.currentLine=5701652;
 //BA.debugLineNum = 5701652;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
RDebugUtils.currentLine=5701653;
 //BA.debugLineNum = 5701653;BA.debugLine="End Sub";
return "";
}
public static String  _buildselectquery(String _tablename,anywheresoftware.b4a.objects.collections.Map _fields,anywheresoftware.b4a.objects.collections.Map _wherefields,anywheresoftware.b4a.objects.collections.Map _orderfields) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "buildselectquery"))
	return (String) Debug.delegate(ba, "buildselectquery", new Object[] {_tablename,_fields,_wherefields,_orderfields});
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
String _col = "";
String _value = "";
RDebugUtils.currentLine=5636096;
 //BA.debugLineNum = 5636096;BA.debugLine="Sub BuildSelectQuery(TableName As String, Fields A";
RDebugUtils.currentLine=5636097;
 //BA.debugLineNum = 5636097;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=5636098;
 //BA.debugLineNum = 5636098;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=5636099;
 //BA.debugLineNum = 5636099;BA.debugLine="sb.Append(\"SELECT \")";
_sb.Append("SELECT ");
RDebugUtils.currentLine=5636100;
 //BA.debugLineNum = 5636100;BA.debugLine="For i = 0 To Fields.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_fields.getSize()-1);
for (_i = (int) (0) ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
RDebugUtils.currentLine=5636101;
 //BA.debugLineNum = 5636101;BA.debugLine="Dim col As String = Fields.GetKeyAt(i)";
_col = BA.ObjectToString(_fields.GetKeyAt(_i));
RDebugUtils.currentLine=5636102;
 //BA.debugLineNum = 5636102;BA.debugLine="If i > 0 Then";
if (_i>0) { 
RDebugUtils.currentLine=5636103;
 //BA.debugLineNum = 5636103;BA.debugLine="sb.Append(\", \")";
_sb.Append(", ");
 };
RDebugUtils.currentLine=5636105;
 //BA.debugLineNum = 5636105;BA.debugLine="sb.Append(col)";
_sb.Append(_col);
 }
};
RDebugUtils.currentLine=5636107;
 //BA.debugLineNum = 5636107;BA.debugLine="sb.Append(\" FROM \" & TableName)";
_sb.Append(" FROM "+_tablename);
RDebugUtils.currentLine=5636108;
 //BA.debugLineNum = 5636108;BA.debugLine="If WhereFields.IsInitialized Then";
if (_wherefields.IsInitialized()) { 
RDebugUtils.currentLine=5636109;
 //BA.debugLineNum = 5636109;BA.debugLine="sb.Append(\" WHERE \")";
_sb.Append(" WHERE ");
RDebugUtils.currentLine=5636110;
 //BA.debugLineNum = 5636110;BA.debugLine="For i = 0 To WhereFields.Size - 1";
{
final int step14 = 1;
final int limit14 = (int) (_wherefields.getSize()-1);
for (_i = (int) (0) ; (step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14); _i = ((int)(0 + _i + step14)) ) {
RDebugUtils.currentLine=5636111;
 //BA.debugLineNum = 5636111;BA.debugLine="Dim col As String = WhereFields.GetKeyAt(i)";
_col = BA.ObjectToString(_wherefields.GetKeyAt(_i));
RDebugUtils.currentLine=5636112;
 //BA.debugLineNum = 5636112;BA.debugLine="Dim value As String = WhereFields.GetValueAt(i)";
_value = BA.ObjectToString(_wherefields.GetValueAt(_i));
RDebugUtils.currentLine=5636113;
 //BA.debugLineNum = 5636113;BA.debugLine="If i > 0 Then";
if (_i>0) { 
RDebugUtils.currentLine=5636114;
 //BA.debugLineNum = 5636114;BA.debugLine="sb.Append(\" AND \")";
_sb.Append(" AND ");
 };
RDebugUtils.currentLine=5636116;
 //BA.debugLineNum = 5636116;BA.debugLine="sb.Append(col & \"=\" & value)";
_sb.Append(_col+"="+_value);
 }
};
 };
RDebugUtils.currentLine=5636119;
 //BA.debugLineNum = 5636119;BA.debugLine="If OrderFields.IsInitialized Then";
if (_orderfields.IsInitialized()) { 
RDebugUtils.currentLine=5636120;
 //BA.debugLineNum = 5636120;BA.debugLine="sb.Append(\" ORDER BY \")";
_sb.Append(" ORDER BY ");
RDebugUtils.currentLine=5636121;
 //BA.debugLineNum = 5636121;BA.debugLine="For i = 0 To WhereFields.Size - 1";
{
final int step25 = 1;
final int limit25 = (int) (_wherefields.getSize()-1);
for (_i = (int) (0) ; (step25 > 0 && _i <= limit25) || (step25 < 0 && _i >= limit25); _i = ((int)(0 + _i + step25)) ) {
RDebugUtils.currentLine=5636122;
 //BA.debugLineNum = 5636122;BA.debugLine="Dim col As String = OrderFields.GetKeyAt(i)";
_col = BA.ObjectToString(_orderfields.GetKeyAt(_i));
RDebugUtils.currentLine=5636123;
 //BA.debugLineNum = 5636123;BA.debugLine="If i > 0 Then";
if (_i>0) { 
RDebugUtils.currentLine=5636124;
 //BA.debugLineNum = 5636124;BA.debugLine="sb.Append(\", \")";
_sb.Append(", ");
 };
RDebugUtils.currentLine=5636126;
 //BA.debugLineNum = 5636126;BA.debugLine="sb.Append(col)";
_sb.Append(_col);
 }
};
 };
RDebugUtils.currentLine=5636130;
 //BA.debugLineNum = 5636130;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
RDebugUtils.currentLine=5636131;
 //BA.debugLineNum = 5636131;BA.debugLine="End Sub";
return "";
}
public static String  _buildupdatequery(String _tablename,anywheresoftware.b4a.objects.collections.Map _fields,anywheresoftware.b4a.objects.collections.Map _wherefields) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "buildupdatequery"))
	return (String) Debug.delegate(ba, "buildupdatequery", new Object[] {_tablename,_fields,_wherefields});
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
String _col = "";
String _value = "";
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub BuildUpdateQuery(TableName As String, Fields A";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=5832707;
 //BA.debugLineNum = 5832707;BA.debugLine="sb.Append(\"UPDATE \" & TableName & \" SET \")";
_sb.Append("UPDATE "+_tablename+" SET ");
RDebugUtils.currentLine=5832708;
 //BA.debugLineNum = 5832708;BA.debugLine="For i = 0 To Fields.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_fields.getSize()-1);
for (_i = (int) (0) ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
RDebugUtils.currentLine=5832709;
 //BA.debugLineNum = 5832709;BA.debugLine="Dim col As String = Fields.GetKeyAt(i)";
_col = BA.ObjectToString(_fields.GetKeyAt(_i));
RDebugUtils.currentLine=5832710;
 //BA.debugLineNum = 5832710;BA.debugLine="Dim value As String = Fields.GetValueAt(i)";
_value = BA.ObjectToString(_fields.GetValueAt(_i));
RDebugUtils.currentLine=5832711;
 //BA.debugLineNum = 5832711;BA.debugLine="If i > 0 Then";
if (_i>0) { 
RDebugUtils.currentLine=5832712;
 //BA.debugLineNum = 5832712;BA.debugLine="sb.Append(\", \")";
_sb.Append(", ");
 };
RDebugUtils.currentLine=5832714;
 //BA.debugLineNum = 5832714;BA.debugLine="sb.Append(col & \"=\" & value)";
_sb.Append(_col+"="+_value);
 }
};
RDebugUtils.currentLine=5832716;
 //BA.debugLineNum = 5832716;BA.debugLine="If WhereFields.IsInitialized Then";
if (_wherefields.IsInitialized()) { 
RDebugUtils.currentLine=5832717;
 //BA.debugLineNum = 5832717;BA.debugLine="sb.Append(\" WHERE \")";
_sb.Append(" WHERE ");
RDebugUtils.currentLine=5832718;
 //BA.debugLineNum = 5832718;BA.debugLine="For i = 0 To WhereFields.Size - 1";
{
final int step14 = 1;
final int limit14 = (int) (_wherefields.getSize()-1);
for (_i = (int) (0) ; (step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14); _i = ((int)(0 + _i + step14)) ) {
RDebugUtils.currentLine=5832719;
 //BA.debugLineNum = 5832719;BA.debugLine="Dim col As String = WhereFields.GetKeyAt(i)";
_col = BA.ObjectToString(_wherefields.GetKeyAt(_i));
RDebugUtils.currentLine=5832720;
 //BA.debugLineNum = 5832720;BA.debugLine="Dim value As String = WhereFields.GetValueAt(i)";
_value = BA.ObjectToString(_wherefields.GetValueAt(_i));
RDebugUtils.currentLine=5832721;
 //BA.debugLineNum = 5832721;BA.debugLine="If i > 0 Then";
if (_i>0) { 
RDebugUtils.currentLine=5832722;
 //BA.debugLineNum = 5832722;BA.debugLine="sb.Append(\" AND \")";
_sb.Append(" AND ");
 };
RDebugUtils.currentLine=5832724;
 //BA.debugLineNum = 5832724;BA.debugLine="sb.Append(col & \"=\" & value)";
_sb.Append(_col+"="+_value);
 }
};
 };
RDebugUtils.currentLine=5832727;
 //BA.debugLineNum = 5832727;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
RDebugUtils.currentLine=5832728;
 //BA.debugLineNum = 5832728;BA.debugLine="End Sub";
return "";
}
public static String  _closesql(anywheresoftware.b4j.objects.SQL _mysql) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "closesql"))
	return (String) Debug.delegate(ba, "closesql", new Object[] {_mysql});
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Sub CloseSQL(mySQL As SQL)";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="If UsePool Then";
if (_usepool) { 
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="mySQL.Close";
_mysql.Close();
 };
RDebugUtils.currentLine=5046276;
 //BA.debugLineNum = 5046276;BA.debugLine="End Sub";
return "";
}
public static String  _createtablesifneeded() throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "createtablesifneeded"))
	return (String) Debug.delegate(ba, "createtablesifneeded", null);
anywheresoftware.b4j.objects.SQL _sql = null;
String _sql_str = "";
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Sub CreateTablesIfNeeded()";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="Dim SQL As SQL = GetSQL";
_sql = _getsql();
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="Dim SQL_str As String";
_sql_str = "";
RDebugUtils.currentLine=5111813;
 //BA.debugLineNum = 5111813;BA.debugLine="If UsePool Then";
if (_usepool) { 
RDebugUtils.currentLine=5111814;
 //BA.debugLineNum = 5111814;BA.debugLine="SQL_str = \"SELECT COUNT(*) FROM information_sche";
_sql_str = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'abmfeedback' And table_name = 'cases';";
RDebugUtils.currentLine=5111815;
 //BA.debugLineNum = 5111815;BA.debugLine="If SQLSelectSingleResult(SQL, SQL_str) = 0 Then";
if ((_sqlselectsingleresult(_sql,_sql_str)).equals(BA.NumberToString(0))) { 
RDebugUtils.currentLine=5111816;
 //BA.debugLineNum = 5111816;BA.debugLine="SQL_str = \"CREATE TABLE cases (CaseID INT NOT N";
_sql_str = "CREATE TABLE cases (CaseID INT NOT NULL AUTO_INCREMENT, CaseNumber VARCHAR(100), CaseType INT, CaseSummary VARCHAR(255), CaseDescription TEXT , CaseStatus INT, CaseUserID INT, CaseCreationDate VARCHAR(50), CaseFixedVersion VARCHAR(10), PRIMARY KEY (CaseID))";
RDebugUtils.currentLine=5111817;
 //BA.debugLineNum = 5111817;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
RDebugUtils.currentLine=5111822;
 //BA.debugLineNum = 5111822;BA.debugLine="SQL_str = \"CREATE TABLE caseattachments(CaseAID";
_sql_str = "CREATE TABLE caseattachments(CaseAID INT NOT NULL AUTO_INCREMENT, CaseACaseID INT, CaseAType INT, CaseAValue VARCHAR(255), PRIMARY KEY (CaseAID))";
RDebugUtils.currentLine=5111823;
 //BA.debugLineNum = 5111823;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
RDebugUtils.currentLine=5111825;
 //BA.debugLineNum = 5111825;BA.debugLine="SQL_str = \"CREATE TABLE casenotes (CaseNID INT";
_sql_str = "CREATE TABLE casenotes (CaseNID INT NOT NULL AUTO_INCREMENT, CaseNCaseID INT, CaseNUserID INT, CaseNDescription TEXT, CaseNCreationDate VARCHAR(50), PRIMARY KEY (CaseNID))";
RDebugUtils.currentLine=5111826;
 //BA.debugLineNum = 5111826;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
RDebugUtils.currentLine=5111828;
 //BA.debugLineNum = 5111828;BA.debugLine="SQL_str = \"CREATE TABLE caseread (CaseRID INT N";
_sql_str = "CREATE TABLE caseread (CaseRID INT NOT NULL AUTO_INCREMENT, CaseRCaseID INT, CaseRUserID INT, CaseRStatus INT, PRIMARY KEY (CaseRID))";
RDebugUtils.currentLine=5111829;
 //BA.debugLineNum = 5111829;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
RDebugUtils.currentLine=5111831;
 //BA.debugLineNum = 5111831;BA.debugLine="SQL_str = \"CREATE TABLE users (UserID INT NOT N";
_sql_str = "CREATE TABLE users (UserID INT NOT NULL AUTO_INCREMENT, UserName VARCHAR(255), UserLogin VARCHAR(255), UserPassword VARCHAR(100), UserType INT, UserActive INT, PRIMARY KEY (UserID))";
RDebugUtils.currentLine=5111832;
 //BA.debugLineNum = 5111832;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
RDebugUtils.currentLine=5111835;
 //BA.debugLineNum = 5111835;BA.debugLine="SQL_str = \"INSERT INTO users (UserName, UserLog";
_sql_str = "INSERT INTO users (UserName, UserLogin, UserPassword, UserType, UserActive) VALUES ('Admin', 'Admin', 'Admin', 1, 0)";
RDebugUtils.currentLine=5111836;
 //BA.debugLineNum = 5111836;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 };
 }else {
RDebugUtils.currentLine=5111840;
 //BA.debugLineNum = 5111840;BA.debugLine="SQL_str = \"SELECT count(name) FROM sqlite_master";
_sql_str = "SELECT count(name) FROM sqlite_master WHERE type='table' AND name='Cases'";
RDebugUtils.currentLine=5111841;
 //BA.debugLineNum = 5111841;BA.debugLine="If SQLSelectSingleResult(SQL, SQL_str) = 0 Then";
if ((_sqlselectsingleresult(_sql,_sql_str)).equals(BA.NumberToString(0))) { 
RDebugUtils.currentLine=5111842;
 //BA.debugLineNum = 5111842;BA.debugLine="SQL_str = \"PRAGMA journal_mode = wal\" 'best mod";
_sql_str = "PRAGMA journal_mode = wal";
RDebugUtils.currentLine=5111843;
 //BA.debugLineNum = 5111843;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
RDebugUtils.currentLine=5111845;
 //BA.debugLineNum = 5111845;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [cases] (";
_sql_str = "CREATE TABLE IF NOT EXISTS [cases] ([CaseID] INTEGER PRIMARY KEY, [CaseNumber] TEXT, [CaseType] INTEGER, [CaseSummary] TEXT, [CaseDescription] TEXT, [CaseStatus] INTEGER, [CaseUserID] INTEGER, [CaseCreationDate] TEXT, [CaseFixedVersion] TEXT)";
RDebugUtils.currentLine=5111846;
 //BA.debugLineNum = 5111846;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
RDebugUtils.currentLine=5111851;
 //BA.debugLineNum = 5111851;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [caseatta";
_sql_str = "CREATE TABLE IF NOT EXISTS [caseattachments]([CaseAID] INTEGER PRIMARY KEY, [CaseACaseID] INTEGER, [CaseAType] INTEGER, [CaseAValue] TEXT)";
RDebugUtils.currentLine=5111852;
 //BA.debugLineNum = 5111852;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
RDebugUtils.currentLine=5111854;
 //BA.debugLineNum = 5111854;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [casenote";
_sql_str = "CREATE TABLE IF NOT EXISTS [casenotes]([CaseNID] INTEGER PRIMARY KEY, [CaseNCaseID] INTEGER, [CaseNUserID] INTEGER, [CaseNDescription] TEXT, [CaseNCreationDate] TEXT)";
RDebugUtils.currentLine=5111855;
 //BA.debugLineNum = 5111855;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
RDebugUtils.currentLine=5111857;
 //BA.debugLineNum = 5111857;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [caseread";
_sql_str = "CREATE TABLE IF NOT EXISTS [caseread]([CaseRID] INTEGER PRIMARY KEY, [CaseRCaseID] INTEGER, [CaseRUserID] INTEGER, [CaseRStatus] INTEGER)";
RDebugUtils.currentLine=5111858;
 //BA.debugLineNum = 5111858;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
RDebugUtils.currentLine=5111860;
 //BA.debugLineNum = 5111860;BA.debugLine="SQL_str = \"CREATE TABLE IF NOT EXISTS [users] (";
_sql_str = "CREATE TABLE IF NOT EXISTS [users] ([UserID] INTEGER PRIMARY KEY, [UserName] TEXT, [UserLogin] TEXT, [UserPassword] TEXT, [UserType] INTEGER, [UserActive] INTEGER)";
RDebugUtils.currentLine=5111861;
 //BA.debugLineNum = 5111861;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
RDebugUtils.currentLine=5111864;
 //BA.debugLineNum = 5111864;BA.debugLine="SQL_str = \"INSERT INTO [users] (UserID, UserNam";
_sql_str = "INSERT INTO [users] (UserID, UserName, UserLogin, UserPassword, UserType, UserActive) VALUES (null, 'Admin', 'Admin', 'Admin', 1, 0)";
RDebugUtils.currentLine=5111865;
 //BA.debugLineNum = 5111865;BA.debugLine="SQLCreate(SQL, SQL_str)";
_sqlcreate(_sql,_sql_str);
 };
 };
RDebugUtils.currentLine=5111868;
 //BA.debugLineNum = 5111868;BA.debugLine="CloseSQL(SQL)";
_closesql(_sql);
RDebugUtils.currentLine=5111869;
 //BA.debugLineNum = 5111869;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4j.objects.SQL  _getsql() throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "getsql"))
	return (anywheresoftware.b4j.objects.SQL) Debug.delegate(ba, "getsql", null);
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Sub GetSQL() As SQL";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="If UsePool Then";
if (_usepool) { 
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="Return pool.GetConnection";
if (true) return _pool.GetConnection();
 }else {
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="Return SQLite";
if (true) return _sqlite;
 };
RDebugUtils.currentLine=4980742;
 //BA.debugLineNum = 4980742;BA.debugLine="End Sub";
return null;
}
public static String  _sqlselectsingleresult(anywheresoftware.b4j.objects.SQL _sql,String _query) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "sqlselectsingleresult"))
	return (String) Debug.delegate(ba, "sqlselectsingleresult", new Object[] {_sql,_query});
String _res = "";
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Sub SQLSelectSingleResult(SQL As SQL, Query As Str";
RDebugUtils.currentLine=5505025;
 //BA.debugLineNum = 5505025;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=5505026;
 //BA.debugLineNum = 5505026;BA.debugLine="Try";
try {RDebugUtils.currentLine=5505027;
 //BA.debugLineNum = 5505027;BA.debugLine="res = SQL.ExecQuerySingleResult(Query)";
_res = _sql.ExecQuerySingleResult(_query);
 } 
       catch (Exception e5) {
			ba.setLastException(e5);RDebugUtils.currentLine=5505029;
 //BA.debugLineNum = 5505029;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
RDebugUtils.currentLine=5505030;
 //BA.debugLineNum = 5505030;BA.debugLine="res = -99999999";
_res = BA.NumberToString(-99999999);
 };
RDebugUtils.currentLine=5505032;
 //BA.debugLineNum = 5505032;BA.debugLine="If res = Null Then";
if (_res== null) { 
RDebugUtils.currentLine=5505033;
 //BA.debugLineNum = 5505033;BA.debugLine="Return \"0\"";
if (true) return "0";
 };
RDebugUtils.currentLine=5505035;
 //BA.debugLineNum = 5505035;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=5505036;
 //BA.debugLineNum = 5505036;BA.debugLine="End Sub";
return "";
}
public static int  _sqlcreate(anywheresoftware.b4j.objects.SQL _sql,String _query) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "sqlcreate"))
	return (Integer) Debug.delegate(ba, "sqlcreate", new Object[] {_sql,_query});
int _res = 0;
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Sub SQLCreate(SQL As SQL, Query As String) As Int";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="Dim res As Int";
_res = 0;
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="Try";
try {RDebugUtils.currentLine=5242883;
 //BA.debugLineNum = 5242883;BA.debugLine="SQL.ExecNonQuery(Query)";
_sql.ExecNonQuery(_query);
RDebugUtils.currentLine=5242884;
 //BA.debugLineNum = 5242884;BA.debugLine="res = 0";
_res = (int) (0);
 } 
       catch (Exception e6) {
			ba.setLastException(e6);RDebugUtils.currentLine=5242886;
 //BA.debugLineNum = 5242886;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
RDebugUtils.currentLine=5242887;
 //BA.debugLineNum = 5242887;BA.debugLine="res = -99999999";
_res = (int) (-99999999);
 };
RDebugUtils.currentLine=5242889;
 //BA.debugLineNum = 5242889;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=5242890;
 //BA.debugLineNum = 5242890;BA.debugLine="End Sub";
return 0;
}
public static String  _initializesqlite(String _dir,String _filename,boolean _createifneeded) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "initializesqlite"))
	return (String) Debug.delegate(ba, "initializesqlite", new Object[] {_dir,_filename,_createifneeded});
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Sub InitializeSQLite(Dir As String, fileName As St";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="Log(\"init sqlite\")";
anywheresoftware.b4a.keywords.Common.Log("init sqlite");
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="SQLite.InitializeSQLite(Dir, fileName, createIfNe";
_sqlite.InitializeSQLite(_dir,_filename,_createifneeded);
RDebugUtils.currentLine=4849667;
 //BA.debugLineNum = 4849667;BA.debugLine="UsePool = False";
_usepool = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4849668;
 //BA.debugLineNum = 4849668;BA.debugLine="End Sub";
return "";
}
public static String  _setquotes(String _str) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "setquotes"))
	return (String) Debug.delegate(ba, "setquotes", new Object[] {_str});
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub SetQuotes(str As String) As String";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="str = ABMShared.ReplaceAll(str, \"'\", \"''\")";
_str = _abmshared._replaceall(_str,"'","''");
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="Return \"'\" & str & \"'\"";
if (true) return "'"+_str+"'";
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="End Sub";
return "";
}
public static int  _sqldelete(anywheresoftware.b4j.objects.SQL _sql,String _query) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "sqldelete"))
	return (Integer) Debug.delegate(ba, "sqldelete", new Object[] {_sql,_query});
int _res = 0;
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Sub SQLDelete(SQL As SQL, Query As String) As Int";
RDebugUtils.currentLine=5439489;
 //BA.debugLineNum = 5439489;BA.debugLine="Dim res As Int";
_res = 0;
RDebugUtils.currentLine=5439490;
 //BA.debugLineNum = 5439490;BA.debugLine="Try";
try {RDebugUtils.currentLine=5439491;
 //BA.debugLineNum = 5439491;BA.debugLine="SQL.ExecNonQuery(Query)";
_sql.ExecNonQuery(_query);
RDebugUtils.currentLine=5439492;
 //BA.debugLineNum = 5439492;BA.debugLine="res = 0";
_res = (int) (0);
 } 
       catch (Exception e6) {
			ba.setLastException(e6);RDebugUtils.currentLine=5439494;
 //BA.debugLineNum = 5439494;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
RDebugUtils.currentLine=5439495;
 //BA.debugLineNum = 5439495;BA.debugLine="res = -99999999";
_res = (int) (-99999999);
 };
RDebugUtils.currentLine=5439497;
 //BA.debugLineNum = 5439497;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=5439498;
 //BA.debugLineNum = 5439498;BA.debugLine="End Sub";
return 0;
}
public static int  _sqlinsert(anywheresoftware.b4j.objects.SQL _sql,String _query) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "sqlinsert"))
	return (Integer) Debug.delegate(ba, "sqlinsert", new Object[] {_sql,_query});
int _res = 0;
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="Sub SQLInsert(SQL As SQL, Query As String) As Int";
RDebugUtils.currentLine=5308417;
 //BA.debugLineNum = 5308417;BA.debugLine="Dim res As Int";
_res = 0;
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="Try";
try {RDebugUtils.currentLine=5308419;
 //BA.debugLineNum = 5308419;BA.debugLine="SQL.ExecNonQuery(Query)";
_sql.ExecNonQuery(_query);
RDebugUtils.currentLine=5308420;
 //BA.debugLineNum = 5308420;BA.debugLine="If UsePool Then";
if (_usepool) { 
RDebugUtils.currentLine=5308421;
 //BA.debugLineNum = 5308421;BA.debugLine="res = SQLSelectSingleResult(SQL, \"SELECT LAST_I";
_res = (int)(Double.parseDouble(_sqlselectsingleresult(_sql,"SELECT LAST_INSERT_ID()")));
 }else {
RDebugUtils.currentLine=5308423;
 //BA.debugLineNum = 5308423;BA.debugLine="res = SQLSelectSingleResult(SQL, \"SELECT last_i";
_res = (int)(Double.parseDouble(_sqlselectsingleresult(_sql,"SELECT last_insert_rowid()")));
 };
 } 
       catch (Exception e10) {
			ba.setLastException(e10);RDebugUtils.currentLine=5308426;
 //BA.debugLineNum = 5308426;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
RDebugUtils.currentLine=5308427;
 //BA.debugLineNum = 5308427;BA.debugLine="res = -99999999";
_res = (int) (-99999999);
 };
RDebugUtils.currentLine=5308429;
 //BA.debugLineNum = 5308429;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=5308430;
 //BA.debugLineNum = 5308430;BA.debugLine="End Sub";
return 0;
}
public static int  _sqlinsertorupdate(anywheresoftware.b4j.objects.SQL _sql,String _selectquery,String _insertquery,String _updatequery) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "sqlinsertorupdate"))
	return (Integer) Debug.delegate(ba, "sqlinsertorupdate", new Object[] {_sql,_selectquery,_insertquery,_updatequery});
int _foundres = 0;
int _res = 0;
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Sub SQLInsertOrUpdate(SQL As SQL, SelectQuery As S";
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="Dim foundres As Int = SQLSelectSingleResult(SQL,";
_foundres = (int)(Double.parseDouble(_sqlselectsingleresult(_sql,_selectquery)));
RDebugUtils.currentLine=5570562;
 //BA.debugLineNum = 5570562;BA.debugLine="If foundres = -99999999 Then";
if (_foundres==-99999999) { 
RDebugUtils.currentLine=5570563;
 //BA.debugLineNum = 5570563;BA.debugLine="Return foundres";
if (true) return _foundres;
 };
RDebugUtils.currentLine=5570565;
 //BA.debugLineNum = 5570565;BA.debugLine="Dim res As Int";
_res = 0;
RDebugUtils.currentLine=5570566;
 //BA.debugLineNum = 5570566;BA.debugLine="If foundres = 0 Then";
if (_foundres==0) { 
RDebugUtils.currentLine=5570567;
 //BA.debugLineNum = 5570567;BA.debugLine="res = SQLInsert(SQL, InsertQuery)";
_res = _sqlinsert(_sql,_insertquery);
 }else {
RDebugUtils.currentLine=5570569;
 //BA.debugLineNum = 5570569;BA.debugLine="res = SQLUpdate(SQL, UpdateQuery)";
_res = _sqlupdate(_sql,_updatequery);
RDebugUtils.currentLine=5570570;
 //BA.debugLineNum = 5570570;BA.debugLine="If res = 0 Then";
if (_res==0) { 
RDebugUtils.currentLine=5570571;
 //BA.debugLineNum = 5570571;BA.debugLine="res = foundres";
_res = _foundres;
 };
 };
RDebugUtils.currentLine=5570574;
 //BA.debugLineNum = 5570574;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=5570575;
 //BA.debugLineNum = 5570575;BA.debugLine="End Sub";
return 0;
}
public static int  _sqlupdate(anywheresoftware.b4j.objects.SQL _sql,String _query) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "sqlupdate"))
	return (Integer) Debug.delegate(ba, "sqlupdate", new Object[] {_sql,_query});
int _res = 0;
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Sub SQLUpdate(SQL As SQL, Query As String) As Int";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="Dim res As Int";
_res = 0;
RDebugUtils.currentLine=5373954;
 //BA.debugLineNum = 5373954;BA.debugLine="Try";
try {RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="SQL.ExecNonQuery(Query)";
_sql.ExecNonQuery(_query);
RDebugUtils.currentLine=5373956;
 //BA.debugLineNum = 5373956;BA.debugLine="res = 0";
_res = (int) (0);
 } 
       catch (Exception e6) {
			ba.setLastException(e6);RDebugUtils.currentLine=5373958;
 //BA.debugLineNum = 5373958;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
RDebugUtils.currentLine=5373959;
 //BA.debugLineNum = 5373959;BA.debugLine="res = -99999999";
_res = (int) (-99999999);
 };
RDebugUtils.currentLine=5373961;
 //BA.debugLineNum = 5373961;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=5373962;
 //BA.debugLineNum = 5373962;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _sqlselect(anywheresoftware.b4j.objects.SQL _sql,String _query,anywheresoftware.b4a.objects.collections.List _args) throws Exception{
RDebugUtils.currentModule="dbm";
if (Debug.shouldDelegate(ba, "sqlselect"))
	return (anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "sqlselect", new Object[] {_sql,_query,_args});
anywheresoftware.b4a.objects.collections.List _l = null;
anywheresoftware.b4j.objects.SQL.ResultSetWrapper _cur = null;
anywheresoftware.b4a.objects.collections.Map _res = null;
int _i = 0;
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Sub SQLSelect(SQL As SQL, Query As String, Args As";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="Dim l As List";
_l = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="l.Initialize";
_l.Initialize();
RDebugUtils.currentLine=5177347;
 //BA.debugLineNum = 5177347;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4j.objects.SQL.ResultSetWrapper();
RDebugUtils.currentLine=5177348;
 //BA.debugLineNum = 5177348;BA.debugLine="Try";
try {RDebugUtils.currentLine=5177349;
 //BA.debugLineNum = 5177349;BA.debugLine="cur = SQL.ExecQuery2(Query, Args)";
_cur = _sql.ExecQuery2(_query,_args);
 } 
       catch (Exception e7) {
			ba.setLastException(e7);RDebugUtils.currentLine=5177351;
 //BA.debugLineNum = 5177351;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
RDebugUtils.currentLine=5177352;
 //BA.debugLineNum = 5177352;BA.debugLine="Return l";
if (true) return _l;
 };
RDebugUtils.currentLine=5177354;
 //BA.debugLineNum = 5177354;BA.debugLine="Do While cur.NextRow";
while (_cur.NextRow()) {
RDebugUtils.currentLine=5177355;
 //BA.debugLineNum = 5177355;BA.debugLine="Dim res As Map";
_res = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=5177356;
 //BA.debugLineNum = 5177356;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=5177357;
 //BA.debugLineNum = 5177357;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
{
final int step13 = 1;
final int limit13 = (int) (_cur.getColumnCount()-1);
for (_i = (int) (0) ; (step13 > 0 && _i <= limit13) || (step13 < 0 && _i >= limit13); _i = ((int)(0 + _i + step13)) ) {
RDebugUtils.currentLine=5177358;
 //BA.debugLineNum = 5177358;BA.debugLine="res.Put(cur.GetColumnName(i).ToLowerCase, cur.G";
_res.Put((Object)(_cur.GetColumnName(_i).toLowerCase()),(Object)(_cur.GetString2(_i)));
 }
};
RDebugUtils.currentLine=5177360;
 //BA.debugLineNum = 5177360;BA.debugLine="l.Add(res)";
_l.Add((Object)(_res.getObject()));
 }
;
RDebugUtils.currentLine=5177362;
 //BA.debugLineNum = 5177362;BA.debugLine="cur.Close";
_cur.Close();
RDebugUtils.currentLine=5177363;
 //BA.debugLineNum = 5177363;BA.debugLine="Return l";
if (true) return _l;
RDebugUtils.currentLine=5177364;
 //BA.debugLineNum = 5177364;BA.debugLine="End Sub";
return null;
}
}