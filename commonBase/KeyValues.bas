Type=Class
Version=5.95
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'KeyValues: v1.00
Sub Class_Globals
	Private sql1 As SQL
	Private tempFolder = File.DirInternalCache, tempFile = "key_value_temp.dat" As String
	Private D As Int

End Sub

'Initializes the store and sets the store file.
'Dimension is the number of values of each key.
Public Sub Initialize (Dir As String, FileName As String, Dimension As Int)
	If sql1.IsInitialized Then sql1.Close
	sql1.Initialize(Dir, FileName, True)
	D = Dimension
	CreateTable
End Sub

'Puts a simple value in the store.
'The index sets where the value is stored (start from 0 for the first value).
'Strings, number types and booleans are considered "simple" values.
Public Sub PutSimple1(Key As String, index As Int, Value As Object) As Boolean
	Try
		sql1.BeginTransaction
		insertQuery1(Key,index, Value)
		Return complete(True)
	Catch
		Return complete(False)
	End Try
End Sub

'Puts simple values as object array in the store.
'Strings, number types and booleans are considered "simple" values.
Public Sub PutSimple2(Key As String, Value() As Object) As Boolean
	Try
		sql1.BeginTransaction
		insertQuery2(Key, Value)
		Return complete(True)
	Catch
		Return complete(False)
	End Try
End Sub

'Puts an object in the store in the index defeigned value. This method uses RandomAccessFile.WriteObject to save the object in the store.
'It is capable of writing the following types of objects: Lists, Arrays, Maps, Strings, primitive types and user defined types.
'Combinations of these types are also supported. For example, a Map with several lists of arrays can be written.
'The element type inside a collection must be a String OR primitive Type.
Public Sub PutObject1(Key As String,index As Int, Value As Object) As Boolean
	Return putObjectInternal1(Key, index, Value, False, "")
End Sub

'Puts an array of objects in the store. This method uses RandomAccessFile.WriteObject to save the object in the store.
'It is capable of writing the following types of objects: Lists, Arrays, Maps, Strings, primitive types and user defined types.
'Combinations of these types are also supported. For example, a Map with several lists of arrays can be written.
'The element type inside a collection must be a String OR primitive Type.
Public Sub PutObject2(Key As String, Value() As Object) As Boolean
	Return putObjectInternal2(Key, Value, False, "")
End Sub

'Similar to PutObject1. Encrypts the object before writing it. Note that you can use it to store "simple" types as well.
Public Sub PutEncyptedObject1(Key As String,index As Int, Value As Object, Password As String) As Boolean
	Return putObjectInternal1(Key,index, Value, True, Password)
End Sub

'Similar to PutObject2. Encrypts the objects before writing them. Note that you can use it to store "simple" types as well.
Public Sub PutEncyptedObject2(Key As String, Value() As Object, Password As String) As Boolean
	Return  putObjectInternal2(Key, Value, True, Password)
End Sub

'Puts a bitmap in the store in the index value.
Public Sub PutBitmap1(Key As String,Index As Int, Value As Bitmap) As Boolean
	Try
		sql1.BeginTransaction
		Dim out As OutputStream
		out.InitializeToBytesArray(100)
		Dim b As Bitmap = Value
		b.WriteToStream(out, 100, "PNG")
		insertQuery1(Key,Index, out.ToBytesArray)
		out.Close
		Return complete(True)
	Catch
		Return complete(False)
	End Try
End Sub

'Puts array of bitmaps in the store.
Public Sub PutBitmap2(Key As String, Value() As Object) As Boolean
	Try
		sql1.BeginTransaction
		Dim objarr(D) As Object
		For i = 0 To D-1
			Dim out As OutputStream
			out.InitializeToBytesArray(100)
			Dim b As Bitmap = Value(i)
			b.WriteToStream(out, 100, "PNG")
			objarr(i) = out.ToBytesArray
			out.Close
		Next
		insertQuery2(Key, objarr)
		Return complete(True)
	Catch
		Return complete(False)
	End Try
End Sub

'Reads the data from the input stream and saves it in the store in the index value.
Public Sub PutInputStream1(Key As String, index As Int, Value As InputStream) As Boolean
	Try
		sql1.BeginTransaction
		Dim out As OutputStream
		out.InitializeToBytesArray(100)
		File.Copy2(Value, out)
		Value.Close
		insertQuery1(Key,index, out.ToBytesArray)
		out.Close
		Return complete(True)
	Catch
		Return complete(False)
	End Try
End Sub

'Reads the data from the input stream array and saves it in the store.
Public Sub PutInputStream2(Key As String, Value() As InputStream) As Boolean
	Try
		sql1.BeginTransaction
		Dim out As OutputStream
		Dim objarr() As Object
		For i = 0 To D-1
			out.InitializeToBytesArray(100)
			File.Copy2(Value(i), out)
			Value(i).Close
			objarr(i) = out.ToBytesArray 
			out.Close
		Next
		insertQuery2(Key,objarr )
		Return complete(True)
	Catch
		Return complete(False)
	End Try
End Sub

'Removes the key and values mapped to this key.
Public Sub Remove(Key As String)
	sql1.ExecNonQuery2("DELETE FROM main WHERE key = ?", Array As Object(Key))
End Sub

'Returns a list with all the keys.
Public Sub ListKeys As List
	Dim c As Cursor = sql1.ExecQuery("SELECT key FROM main")
	Dim res As List
	res.Initialize
	For row = 0 To c.RowCount - 1
		c.Position = row
		res.Add(c.GetString2(0))
	Next
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

'Returns a "simple" value of the index value. See PutSimple1.
Public Sub GetSimple1(Key As String, index As Int) As String
	Dim c As Cursor = getCursor1(Key, index)
	If c.RowCount = 0 Then Return ""
	c.Position = 0
	Dim res As String = c.GetString2(0)
	c.Close
	Return res
End Sub

'Returns an array of all values. See PutSimple2.
Public Sub GetSimple2(Key As String) As Object()
	Dim c As Cursor = getCursor2(Key)
	If c.RowCount = 0 Then Return Null
	c.Position = 0
	Dim res(D) As Object 
	For i = 1 To D
		res(i-1) = c.GetString2(i)
	Next
	c.Close
	Return res
End Sub

'Returns the index InputStream from the store. See PutInputStream1.
Public Sub GetInputStream1(Key As String, index As Int) As InputStream
	Dim c As Cursor = getCursor1(Key, index)
	If c.RowCount = 0 Then Return Null
	c.Position = 0
	Dim buffer() As Byte = c.GetBlob2(0)
	Dim In As InputStream
	In.InitializeFromBytesArray(buffer, 0, buffer.Length)
	c.Close
	Return In
End Sub

'Returns an array of InputStreams from the store. See PutInputStream2.
Public Sub GetInputStream2(Key As String) As InputStream()
	Dim buffer() As Byte
	Dim inarr(D) As InputStream
	Dim c As Cursor = getCursor2(Key)
	If c.RowCount = 0 Then Return Null
	c.Position = 0
	For i = 0 To D-1
		buffer = c.GetBlob2(i+1)
		inarr(i).InitializeFromBytesArray(buffer, 0, buffer.Length)
	Next
	c.Close
	Return inarr
End Sub

'Returns the index bitmap from the store. See PutBitmap1.
Public Sub GetBitmap1(Key As String, index As Int) As Bitmap
	Dim c As Cursor = getCursor1(Key, index)
	Dim b As Bitmap
	If c.RowCount = 0 Then Return b
	c.Position = 0
	Dim buffer() As Byte = c.GetBlob2(0)
	Dim In As InputStream
	In.InitializeFromBytesArray(buffer, 0, buffer.Length)
	b.Initialize2(In)
	In.Close
	c.Close
	Return b
End Sub

'Returns array of bitmaps from the store. See PutBitmap2.
Public Sub GetBitmap2(Key As String) As Bitmap()
	Dim c As Cursor = getCursor2(Key)
	Dim b As Bitmap
	Dim buffer() As Byte
	Dim In As InputStream
	Dim bmparr(D) As Bitmap
	If c.RowCount = 0 Then Return Null
	c.Position = 0
	For i = 0 To D-1
		buffer = c.GetBlob2(i+1)
		In.InitializeFromBytesArray(buffer, 0, buffer.Length)
		b.Initialize2(In)
		bmparr(i) = b
		In.Close
	Next
	c.Close
	Return bmparr
End Sub

'Returns the index object from the store. See PutObject1.
Public Sub GetObject1(Key As String, index As Int) As Object
	Return getObjectInternal1(Key,index, False, "")
End Sub

Public Sub GetObject2(Key As String) As Object()
	Return getObjectInternal2(Key, False, "")
End Sub

'Returns the index decrypted object from the store. See PutEncryptedObject1.
Public Sub GetEncryptedObject1(Key As String,Index As Int, Password As String) As Object
	Return getObjectInternal1(Key,Index, True, Password)
End Sub

'Returns an array of decrypted objects from the store. See PutEncryptedObject1.
Public Sub GetEncryptedObject2(Key As String,Password As String) As Object()
	Return getObjectInternal2(Key, True, Password)
End Sub

'Finds the Key of a simple value.
Public Sub GetKeyBySimpleValue(index As Int, value As String) As String
Dim st As String = "value" & index
Dim c As Cursor = sql1.ExecQuery2("SELECT key FROM main WHERE typeof(" & st & ") != 'blob' AND typeof(" & st & ") != 'null' AND " & st &" = ?", Array As String(value))
If c.RowCount = 0 Then Return ""
c.Position = 0
Return c.GetString2(0)
End Sub

'Closes the store.
Public Sub Close
	sql1.Close
End Sub

Private Sub getObjectInternal1(Key As String,Index As Int, decrypt As Boolean, password As String) As Object
	Dim c As Cursor = getCursor1(Key,Index)
	If c.RowCount = 0 Then Return Null
	c.Position = 0
	Dim buffer() As Byte = c.GetBlob2(0)
	Dim raf As RandomAccessFile
	raf.Initialize3(buffer, False)
	Dim res As Object
	If decrypt Then
		res = raf.ReadEncryptedObject(password, raf.CurrentPosition)
	Else
		res = raf.ReadObject(raf.CurrentPosition)
	End If
	raf.Close
	c.Close
	Return res
End Sub

Private Sub getObjectInternal2(Key As String, decrypt As Boolean, password As String) As Object()
	Dim c As Cursor = getCursor2(Key)
	If c.RowCount = 0 Then Return Null
	c.Position = 0
	Dim res(D) As Object
	Dim raf As RandomAccessFile
	Dim buffer() As Byte
	For i = 0 To D-1
		buffer = c.GetBlob2(i+1)
		raf.Initialize3(buffer, False)
		If decrypt Then
			res(i) = raf.ReadEncryptedObject(password, raf.CurrentPosition)
		Else
			res(i) = raf.ReadObject(raf.CurrentPosition)
		End If
	Next
	raf.Close
	c.Close
	Return res
End Sub

Private Sub getCursor1(Key As String, index As Int) As Cursor
	Return sql1.ExecQuery2("SELECT value" & index & " FROM main WHERE key = ?", Array As String(Key))
End Sub

Private Sub getCursor2(Key As String) As Cursor
	Return sql1.ExecQuery2("SELECT * FROM main WHERE key = ?", Array As String(Key))
End Sub

Private Sub insertQuery1(Key As String,index As Int, Value As Object)
If ContainsKey(Key) Then
	sql1.ExecNonQuery2("UPDATE main SET value" & index & " = ? WHERE key = ? ", Array As Object( Value, Key))
Else
	Dim obarr(D+1) As Object
	Dim st As String = ""
	obarr(0) = Key
	For i = 0 To D-1
		st = st &  "?,"
		obarr(i+1) = Null
	Next
	obarr(index+1) = Value
	sql1.ExecNonQuery2("INSERT INTO main VALUES(" & st & "?)", obarr)
End If
End Sub

Private Sub insertQuery2(Key As String, Value() As Object)
	Remove(Key)
	Dim st As String  = ""
	Dim obarr(D+1) As Object
	obarr(0) = Key
	For i = 0 To D-1
		st = st &  "?,"
		obarr(i+1) = Value(i)
	Next
	sql1.ExecNonQuery2("INSERT INTO main VALUES(" & st & "?)", obarr)
End Sub

'creates the main table (if it does not exist)
Private Sub CreateTable
	Dim st As String = "CREATE TABLE If Not EXISTS main(key TEXT PRIMARY KEY,"
	Dim st1 As String = ""
	For i = 0 To D-1
		st1 = st1 & " value" & i & " NONE,"
	Next
	sql1.ExecNonQuery( st & st1.SubString2(0,st1.Length-2) & ")" )
End Sub

Private Sub complete(success As Boolean) As Boolean
	If success Then
		sql1.TransactionSuccessful
	Else
		Log("Error saving object: " & LastException)
	End If
	sql1.EndTransaction
	Return success
End Sub

Private Sub putObjectInternal1(Key As String, index As Int, Value As Object, encrypt As Boolean, password As String) As Boolean
	Try
		sql1.BeginTransaction
		Dim buffer() As Byte = CommonPutObjectInternal(Value, encrypt, password )
		insertQuery1(Key, index, buffer)
		Return complete(True)
	Catch
		Return complete(False)
	End Try
End Sub

Private Sub putObjectInternal2(Key As String, Value() As Object, encrypt As Boolean, password As String) As Boolean
	Dim buf(D) As Object
	Dim buffer() As Byte
	Try
		sql1.BeginTransaction
		For i = 0 To D-1
			buffer = CommonPutObjectInternal(Value(i), encrypt, password )
			buf(i) = buffer
		Next
		insertQuery2(Key, buf)
		Return complete(True)
	Catch
		Return complete(False)
	End Try
End Sub

Private Sub CommonPutObjectInternal(Value As Object, encrypt As Boolean, password As String) As Byte()
	Dim raf As RandomAccessFile
	File.Delete(tempFolder, tempFile)
	raf.Initialize(tempFolder, tempFile, False)
	If encrypt Then
		raf.WriteEncryptedObject(Value, password, raf.CurrentPosition)
	Else
		raf.WriteObject(Value, True, raf.CurrentPosition)
	End If
	raf.Flush
	Dim buffer(raf.CurrentPosition) As Byte
	raf.ReadBytes(buffer, 0, buffer.Length, 0)
	raf.Close
	Return buffer
End Sub


