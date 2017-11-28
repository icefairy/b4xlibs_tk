B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=5.9
@EndOfDesignText@
'version 1.01
Sub Process_Globals
	Type dbOptret (success As Boolean,msg As String)
	Public conpool As ConnectionPool
	Private curDbType As Int=0
	Public DB_REAL, DB_INTEGER, DB_BLOB, DB_TEXT As String
	DB_REAL = "REAL"
	DB_INTEGER = "INTEGER"
	DB_BLOB = "BLOB"
	DB_TEXT = "TEXT"
	Dim HtmlCSS As String = "table {width: 100%;border: 1px solid #cef;text-align: left; }" _
		& " th { font-weight: bold;	background-color: #acf;	border-bottom: 1px solid #cef; }" _ 
		& "td,th {	padding: 4px 5px; }" _
		& ".odd {background-color: #def; } .odd td {border-bottom: 1px solid #cef; }" _
		& "a { text-decoration:none; color: #000;}"
End Sub
'dbtype:0=mysql connstr:jdbc:mysql://127.0.0.1:3306/webplus?characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull
'1=mssql connstr:jdbc:jtds:sqlserver://localhost:1433/dbname;instance=sqlexpress
'2=oracle connstr:jdbc:oracle:thin:@127.0.0.1:1521:orcl
Public Sub initConnectionPool(dbtype As Int,connectionStr As String,dbUser As String,dbPass As String)
	curDbType=dbtype
	Dim conCls As String=""
	Select dbtype
		Case 0
			conCls="com.mysql.jdbc.Driver"
		Case 1
			conCls="net.sourceforge.jtds.jdbc.Driver"
		Case 2
			conCls="oracle.jdbc.driver.OracleDriver"
	End Select
	conpool.Initialize(conCls,connectionStr,dbUser,dbPass)
End Sub
'dbtype:0=mysql 1=mssql 2=oracle
Public Sub setDbType(dbt As Int)
	curDbType=dbt
End Sub
public Sub EscapeField(f As String) As String
	If curDbType=1 Then
		Return "[" & f & "]"
	Else
		Return "`" & f & "`"
	End If
End Sub
Public Sub ExecuteBaseMap(SQL As SQL, Query As String, StringArgs() As String) As Map
	Dim res As Map
	Dim cur As ResultSet
	If StringArgs <> Null Then
		cur = SQL.ExecQuery2(Query, StringArgs)
	Else
		cur = SQL.ExecQuery(Query)
	End If
	Log("ExecuteMap: " & Query)
	res.Initialize
	'	Log("cnt:"&cur.ColumnCount)
	Do While cur.NextRow
		res.Put(cur.GetString2(0).ToLowerCase,cur.GetString2(1))
	Loop
	cur.Close
	Return res
End Sub
'Creates a new table with the given name.
'FieldsAndTypes - A map with the fields names as keys and the types as values.
'You can use the DB_... constants for the types.
'PrimaryKey - The column that will be the primary key. Pass empty string if not needed.
Public Sub CreateTable(SQL As SQL, TableName As String, FieldsAndTypes As Map, PrimaryKey As String)
	Dim sb As StringBuilder
	sb.Initialize
	sb.Append("(")
	For i = 0 To FieldsAndTypes.Size - 1
		Dim field, ftype As String
		field = FieldsAndTypes.GetKeyAt(i)
		ftype = FieldsAndTypes.GetValueAt(i)
		If i > 0 Then sb.Append(", ")
		sb.Append(EscapeField(field)).Append(" ").Append(ftype)
		If field = PrimaryKey Then sb.Append(" PRIMARY KEY")
	Next
	sb.Append(")")
	Dim query As String
	query = "CREATE TABLE IF NOT EXISTS " & EscapeField(TableName) & " " & sb.ToString
	g.mLog("CreateTable: " & query)
	SQL.ExecNonQuery(query)
End Sub

'Deletes the given table.
Public Sub DropTable(SQL As SQL, TableName As String)
	Dim query As String
	query = "DROP TABLE IF EXISTS " & EscapeField(TableName)
	g.mLog("DropTable3: " & query)
	SQL.ExecNonQuery(query)
End Sub

'Inserts the data to the table.
'ListOfMaps - A list with maps as items. Each map represents a record where the map keys are the columns names
'and the maps values are the values.
'Note that you should create a new map for each record (this can be done by calling Dim to redim the map).
Public Sub InsertMaps(SQL As SQL, TableName As String, ListOfMaps As List) As dbOptret
	Dim sb, columns, values As StringBuilder
	Dim ret As dbOptret
	ret.Initialize
	'Small check for a common error where the same map is used in a loop
	If ListOfMaps.Size > 1 And ListOfMaps.Get(0) = ListOfMaps.Get(1) Then
		'		g.mLog("Same Map found twice in list. Each item in the list should include a different map object.")
		ret.success=False
		ret.msg="Same Map found twice in list. Each item in the list should include a different map object."
		Return ret
	End If
	SQL.BeginTransaction
	Try
		For i1 = 0 To ListOfMaps.Size - 1
			sb.Initialize
			columns.Initialize
			values.Initialize
			Dim listOfValues As List
			listOfValues.Initialize
			sb.Append("INSERT INTO " & EscapeField(TableName) & " (")
			Dim m As Map
			m = ListOfMaps.Get(i1)
			For i2 = 0 To m.Size - 1
				Dim col As String
				Dim value As Object
				col = m.GetKeyAt(i2)
				value = m.GetValueAt(i2)
				If i2 > 0 Then
					columns.Append(", ")
					values.Append(", ")
				End If
				columns.Append(EscapeField(col))
				
				values.Append("?")
				listOfValues.Add(value)
			Next
			sb.Append(columns.ToString)
			sb.Append(") VALUES (")
			sb.Append(values.ToString)
			sb.Append(")")
			If i1 = 0 Then Log("InsertMaps (first query out of " & ListOfMaps.Size & "): " & sb.ToString)
			SQL.ExecNonQuery2(sb.ToString, listOfValues)
		Next
		SQL.TransactionSuccessful
		ret.success=True
		ret.msg="成功"
	Catch
		g.mLog(LastException)
		ret.success=False
		ret.msg=LastException.Message
		SQL.Rollback
	End Try
	Return ret
	
End Sub

'Inserts the data to the table.
'ListOfMaps - A list with maps as items. Each map represents a record where the map keys are the columns names
'and the maps values are the values.
'Note that you should create a new map for each record (this can be done by calling Dim to redim the map).
Public Sub ReplaceMap(SQL As SQL, TableName As String, map As Map)  
	Dim sb,  values As StringBuilder
	'Small check for a common error where the same map is used in a loop
	sb.Initialize
'			columns.Initialize
	values.Initialize
	Dim listOfValues As List
	listOfValues.Initialize
	sb.Append("REPLACE INTO " & EscapeField(TableName) & " ")
	Dim m As Map=map
	
	For i2 = 0 To m.Size - 1
		Dim col As String
		Dim value As Object
		col = m.GetKeyAt(i2)
		value = m.GetValueAt(i2)
		If i2 > 0 Then
'					columns.Append(", ")
			values.Append(", ")
		End If
'				columns.Append(EscapeField(col))
		
		values.Append("?")
		listOfValues.Add(value)
	Next
'			sb.Append(columns.ToString)
	sb.Append(" VALUES (")
	sb.Append(values.ToString)
	sb.Append(")")
	Log("ReplaceMap: " & sb.ToString)
	SQL.ExecNonQuery2(sb.ToString, listOfValues)	
End Sub
Public Sub InsertMap(SQL As SQL, TableName As String, m As Map) As dbOptret
	Dim lst As List
	lst.Initialize
	lst.Add(m)
	Return InsertMaps(SQL,TableName,lst)
End Sub
' updates a single field in a record
' Field is the column name
Public Sub UpdateRecord(SQL As SQL, TableName As String, Field As String, NewValue As Object, _
	WhereFieldEquals As Map)
	Dim sb As StringBuilder
	sb.Initialize
	sb.Append("UPDATE ").Append(EscapeField(TableName)).Append(" SET ").Append(EscapeField(Field)) _
		.Append(" = ? WHERE ")
	If WhereFieldEquals.Size = 0 Then
		g.mLog("WhereFieldEquals map empty!")
		Return
	End If
	Dim args As List
	args.Initialize
	args.Add(NewValue)
	For i = 0 To WhereFieldEquals.Size - 1
		If i > 0 Then sb.Append(" AND ")
		sb.Append(EscapeField(WhereFieldEquals.GetKeyAt(i))).Append(" = ?")
		args.Add(WhereFieldEquals.GetValueAt(i))
	Next
	g.mLog("UpdateRecord: " & sb.ToString)
	SQL.ExecNonQuery2(sb.ToString, args)
End Sub

' updates multiple fields in a record
' in the Fields map the keys are the column names
Public Sub UpdateRecord2(SQL As SQL, TableName As String, Fields As Map, WhereFieldEquals As Map)
	If WhereFieldEquals.Size = 0 Then
		g.mLog("WhereFieldEquals map empty!")
		Return
	End If
	If Fields.Size = 0 Then
		g.mLog("Fields empty")
		Return
	End If
	Dim sb As StringBuilder
	sb.Initialize
	sb.Append("UPDATE ").Append(EscapeField(TableName)).Append(" SET ")
	Dim args As List
	args.Initialize
	For i=0 To Fields.Size-1
		If i<>Fields.Size-1 Then
			sb.Append(EscapeField(Fields.GetKeyAt(i))).Append("=?,")
		Else
			sb.Append(EscapeField(Fields.GetKeyAt(i))).Append("=?")
		End If
		args.Add(Fields.GetValueAt(i))
	Next
    
	sb.Append(" WHERE ")
	For i = 0 To WhereFieldEquals.Size - 1
		If i > 0 Then
			sb.Append(" AND ")
		End If
		sb.Append(EscapeField(WhereFieldEquals.GetKeyAt(i))).Append(" = ?")
		args.Add(WhereFieldEquals.GetValueAt(i))
	Next
	g.mLog("UpdateRecord: " & sb.ToString)
	SQL.ExecNonQuery2(sb.ToString, args)
End Sub

'Executes the query and returns the result as a list of arrays.
'Each item in the list is a strings array.
'StringArgs - Values to replace question marks in the query. Pass Null if not needed.
'Limit - Limits the results. Pass 0 for all results.
Public Sub ExecuteMemoryTable(SQL As SQL, Query As String, StringArgs() As Object, Limit As Int) As List
	Dim cur As ResultSet
'	Log(GetType(StringArgs)&" len:"&StringArgs.Length)
'	Dim params As List
'	params.Initialize
'	For Each v As Object In StringArgs
'		params.Add(v)
'	Next
	If StringArgs == Null Or StringArgs.Length<1 Then
		Dim StringArgs(0) As Object
	End If
	cur = SQL.ExecQuery2(Query, StringArgs)
	g.mLog("ExecuteMemoryTable: " & Query)
	Dim table As List
	table.Initialize
	Do While cur.NextRow
		Dim m As Map
		m.Initialize
		For col = 0 To cur.ColumnCount - 1
			m.Put(cur.GetColumnName(col).ToLowerCase,cur.GetString2(col))
		Next
		table.Add(m)
		If Limit > 0 And table.Size >= Limit Then Exit
	Loop
	cur.Close
	Return table
End Sub
'query list
Public Sub ExecuteMemoryTable2(SQL As SQL, tablename As String,fields As String,WhereFieldEquals As Map, Limit As Int) As List
	Dim cur As ResultSet
	Dim sb As StringBuilder
	sb.Initialize
	Dim args As List
	args.Initialize
	Dim table As List
	table.Initialize
	sb.Append("select "&fields&" from "&EscapeField(tablename)&" where 1=1")
	For i = 0 To WhereFieldEquals.Size - 1
		sb.Append(" AND ")
		sb.Append(EscapeField(WhereFieldEquals.GetKeyAt(i))).Append(" = ?")
		args.Add(WhereFieldEquals.GetValueAt(i))
	Next
	cur = SQL.ExecQuery2(sb.ToString,args)
	g.mLog("ExecuteMemoryTable: " & sb.ToString)
	
	Do While cur.NextRow
		Dim m As Map
		m.Initialize
		For col = 0 To cur.ColumnCount - 1
			m.Put(cur.GetColumnName(col).ToLowerCase,cur.GetString2(col))
		Next
		table.Add(m)
		If Limit > 0 And table.Size >= Limit Then Exit
	Loop
	cur.Close
	Return table
End Sub
'Executes the query and returns a Map with the column names as the keys 
'and the first record values As the entries values.
'The keys are lower cased.
'Returns an uninitialized map if there are no results.
Public Sub ExecuteMap(SQL As SQL, Query As String, StringArgs() As Object) As Map
	Dim res As Map
	Dim cur As ResultSet
	If StringArgs <> Null Then
		cur = SQL.ExecQuery2(Query, StringArgs)
	Else
		cur = SQL.ExecQuery(Query)
	End If
	res.Initialize
	g.mLog("ExecuteMap: " & Query)
	If cur.NextRow = False Then
		g.mLog("No records found.")
		Return res
	End If
	
	g.mLog("cnt:"&cur.ColumnCount)
	For i = 0 To cur.ColumnCount - 1
		res.Put(cur.GetColumnName(i).ToLowerCase, cur.GetString2(i))
	Next
	cur.Close
	Return res
End Sub


'Creates a html text that displays the data in a table.
'The style of the table can be changed by modifying HtmlCSS variable.
Public Sub ExecuteHtml(SQL As SQL, Query As String, StringArgs() As String, Limit As Int) As String
	Dim cur As ResultSet
	If StringArgs <> Null Then
		cur = SQL.ExecQuery2(Query, StringArgs)
	Else
		cur = SQL.ExecQuery(Query)
	End If
	g.mLog("ExecuteHtml: " & Query)
	Dim sb As StringBuilder
	sb.Initialize
	sb.Append("<html><body>").Append(CRLF)
	sb.Append("<style type='text/css'>").Append(HtmlCSS).Append("</style>").Append(CRLF)
	sb.Append("<table><thead><tr>").Append(CRLF)
	For i = 0 To cur.ColumnCount - 1
		sb.Append("<th>").Append(cur.GetColumnName(i)).Append("</th>")
	Next
	sb.Append("</thead>")
	
	'	For i = 0 To cur.ColumnCount - 1
	'		If i = 1 Then
	'			sb.Append("<th style='width:200px;'>").Append(cur.GetColumnName(i)).Append("</th>")
	'		Else
	'			sb.Append("<th>").Append(cur.GetColumnName(i)).Append("</th>")
	'		End If
	'	Next
		
	sb.Append("</tr>").Append(CRLF)
	Dim row As Int
	Do While cur.NextRow
		If row Mod 2 = 0 Then
			sb.Append("<tr>")
		Else
			sb.Append("<tr class='odd'>")
		End If
		For i = 0 To cur.ColumnCount - 1
			sb.Append("<td>")
			sb.Append(cur.GetString2(i))
			sb.Append("</td>")
		Next
		sb.Append("</tr>").Append(CRLF)
		row = row + 1
	Loop
	cur.Close
	sb.Append("</table></body></html>")
	Return sb.ToString
End Sub

Public Sub DeleteRecord(SQL As SQL, TableName As String, WhereFieldEquals As Map)
	Dim sb As StringBuilder
	sb.Initialize
	sb.Append("DELETE FROM ").Append(EscapeField(TableName)).Append(" WHERE ")
	If WhereFieldEquals.Size = 0 Then
		g.mLog("WhereFieldEquals map empty!")
		Return
	End If
	Dim args As List
	args.Initialize
	For i = 0 To WhereFieldEquals.Size - 1
		If i > 0 Then sb.Append(" AND ")
		sb.Append(EscapeField(WhereFieldEquals.GetKeyAt(i))).Append(" = ?")
		args.Add(WhereFieldEquals.GetValueAt(i))
	Next
	g.mLog("DeleteRecord: " & sb.ToString)
	SQL.ExecNonQuery2(sb.ToString, args)
End Sub
#Region Pagination
'support mysql only
'fromQuery:from wp_user
'whereQuery: username like '1%'
'orderby:username asc,nickname desc
'args:array(1,"123")
'pageno start from 0
Public Sub Pagination_TotalSize(SQL As SQL,fromQuery As String,whereQuery As String,args() As Object) As Int
	Dim qsb As StringBuilder
	qsb.Initialize
	qsb.Append("select count(1) cnt ")
	qsb.Append(fromQuery&" where 1=1 ")
	If whereQuery<>Null And whereQuery.Length>0 Then
		qsb.Append("and "&whereQuery&" ")
	End If
	Dim query As String=qsb.ToString
	G.mLog("PaginationTotalSize:"&query)
	Dim cur As ResultSet
	If args<>Null Then
		cur=SQL.ExecQuery2(query,args)
	Else
		cur=SQL.ExecQuery(query)
	End If
	Try
		cur.NextRow
		Return cur.GetInt("cnt")
	Catch
		Log(LastException)
		Return 0
	End Try
End Sub

'support mysql only
'selectQuery:select *
'fromQuery:from wp_user
'whereQuery: username like '1%'
'orderby:username asc,nickname desc
'args:array(1,"123")
'pageno start from 0
Public Sub Pagination(SQL As SQL,selectQuery As String,fromQuery As String,whereQuery As String,orderby As String,args() As Object,pageno As Int,pagesize As Int) As List
	Dim start As Int=pageno*pagesize
	Dim qsb As StringBuilder
	qsb.Initialize
	If selectQuery<>Null And selectQuery.Length>0 Then
		qsb.Append(selectQuery&" ")
	Else
		qsb.Append("select * ")
	End If
	qsb.Append(fromQuery&" where 1=1 ")
	If whereQuery<>Null And whereQuery.Length>0 Then
		qsb.Append("and "&whereQuery&" ")
	End If
	If orderby<>Null And orderby.Length>0 Then
		qsb.Append("order by "&orderby&" ")
	End If
	qsb.Append("limit "&start&","&pagesize)
	Dim query As String=qsb.ToString
	G.mLog("Pagination:"&query)
	Dim cur As ResultSet
	If args<>Null Then
		cur=SQL.ExecQuery2(query,args)
	Else
		cur=SQL.ExecQuery(query)
	End If
	Dim table As List
	table.Initialize
	Do While cur.NextRow
		Dim m As Map
		m.Initialize
		For col = 0 To cur.ColumnCount - 1
			m.Put(cur.GetColumnName(col).ToLowerCase,cur.GetString2(col))
		Next
		table.Add(m)
	Loop
	cur.Close
	Return table
End Sub
#End Region
#Region alias
Public Sub QueryOne(SQL As SQL, Query As String, StringArgs() As Object) As Map
	Return ExecuteMap(SQL,Query,StringArgs)
End Sub
Public Sub QueryList(SQL As SQL, Query As String, StringArgs() As Object, Limit As Int) As List
	Return ExecuteMemoryTable(SQL, Query, StringArgs, Limit)
End Sub
Public Sub QueryList2(SQL As SQL, tablename As String,fields As String,WhereFieldEquals As Map, Limit As Int) As List
	Return ExecuteMemoryTable2(SQL,tablename,fields,WhereFieldEquals,Limit)
End Sub
Public Sub InsertOne(SQL As SQL, TableName As String, m As Map) As dbOptret
	Return InsertMap(SQL,TableName,m)
End Sub
Public Sub InsertList(SQL As SQL, TableName As String, ListOfMaps As List) As dbOptret
	Return InsertMaps(SQL,TableName,ListOfMaps)
End Sub
#End Region