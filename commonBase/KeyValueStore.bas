Type=Class
Version=3.48
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'KeyValueStore: v2.00
'The supported types of objects are:
'
'Lists, Maps, Strings, primitives (numbers), user defined types And arrays (only arrays of bytes And arrays of objects are supported).
'Custom types should be declared in the Main module.
Sub Class_Globals
	Private sql1 As SQL
	Private ser As B4XSerializator
End Sub

'Initializes the store and sets the store file.
Public Sub Initialize (Dir As String, FileName As String)
	If sql1.IsInitialized Then sql1.Close
#if B4J
	sql1.InitializeSQLite(Dir, FileName, True)
#else
	sql1.Initialize(Dir, FileName, True)
#end if
	CreateTable
End Sub
'do not support string array
Public Sub Put(Key As String, Value As Object)
	sql1.ExecNonQuery2("INSERT OR REPLACE INTO main VALUES(?, ?)", Array As Object(Key, ser.ConvertObjectToBytes(Value)))
End Sub

Public Sub Get(Key As String) As Object
	Dim rs As ResultSet = sql1.ExecQuery2("SELECT value FROM main WHERE key = ?", Array As String(Key))
	Dim result As Object = Null
	If rs.NextRow Then
		result = ser.ConvertBytesToObject(rs.GetBlob2(0))
	End If
	rs.Close
	Return result
End Sub

Public Sub GetDefault(Key As String, DefaultValue As Object) As Object
	Dim res As Object = Get(Key)
	If res = Null Then Return DefaultValue
	Return res
End Sub

Public Sub PutEncrypted (Key As String, Value As Object, Password As String)
#if B4I
	Dim cipher As Cipher
#else
	Dim cipher As B4XCipher
#end if
	Put(Key, cipher.Encrypt(ser.ConvertObjectToBytes(Value), Password))
End Sub


Public Sub GetEncrypted (Key As String, Password As String) As Object
#if B4I
	Dim cipher As Cipher
#else
	Dim cipher As B4XCipher
#end if
	Dim b() As Byte = Get(Key)
	If b = Null Then Return Null
	Return ser.ConvertBytesToObject(cipher.Decrypt(b, Password))
End Sub

#if not(B4J)
Public Sub PutBitmap(Key As String, Value As Bitmap)
	Dim out As OutputStream
	out.InitializeToBytesArray(0)
	Value.WriteToStream(out, 100, "PNG")
	Put(Key, out.ToBytesArray)
	out.Close
End Sub

Public Sub GetBitmap(Key As String) As Bitmap
	Dim b() As Byte = Get(Key)
	If b = Null Then Return Null
	Dim in As InputStream
	in.InitializeFromBytesArray(b, 0, b.Length)
	Dim bmp As Bitmap
	bmp.Initialize2(in)
	in.Close
	Return bmp
End Sub
#End If

'Removes the key and value mapped to this key.
Public Sub Remove(Key As String)
	sql1.ExecNonQuery2("DELETE FROM main WHERE key = ?", Array As Object(Key))
End Sub

'Returns a list with all the keys.
Public Sub ListKeys As List
	Dim c As ResultSet = sql1.ExecQuery("SELECT key FROM main")
	Dim res As List
	res.Initialize
	Do While c.NextRow
		res.Add(c.GetString2(0))
	Loop
	c.Close
	Return res
End Sub

'Tests whether a key is available in the store.
Public Sub ContainsKey(Key As String) As Boolean
	Return sql1.ExecQuerySingleResult2("SELECT count(key) FROM main WHERE key = ?", _
		Array As String(Key)) > 0
End Sub

'Deletes all data from the store.
Public Sub DeleteAll
	sql1.ExecNonQuery("DROP TABLE main")
	CreateTable
End Sub


'Closes the store.
Public Sub Close
	sql1.Close
End Sub


'creates the main table (if it does not exist)
Private Sub CreateTable
	sql1.ExecNonQuery("CREATE TABLE IF NOT EXISTS main(key TEXT PRIMARY KEY, value NONE)")
End Sub



