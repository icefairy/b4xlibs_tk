Type=Class
Version=3.48
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'Class module depends on KeyValueStore
Sub Class_Globals
	
	Public kvscache As KeyValueStore
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(dir As String,filename As String)
	If dir=Null Or dir.Length=0 Or filename=Null Or filename.Length=0 Then
		kvscache.Initialize(comm.DIR_CACHES,"test.tmp")
	Else
		If kvscache.IsInitialized Then kvscache.Close
		kvscache.Initialize(dir,filename)
	End If
	Log("init kvs")
End Sub
'will encode the key to md5
Public Sub ContainsKey(key As String) As Boolean
	key=comm.getMD5(key)
	Return kvscache.ContainsKey(key)
End Sub

Public Sub getString(key As String,def As String) As String
	key=comm.getMD5(key)
	Return kvscache.GetDefault(key,def)
End Sub
Public Sub putString(key As String,val As String)
	key=comm.getMD5(key)
	kvscache.Put(key,val)
End Sub
Public Sub getDef(key As String,def As Object) As Object
	key=comm.getMD5(key)
	Return kvscache.GetDefault(key,def)
End Sub
Public Sub putObj(key As String,val As Object)
	key=comm.getMD5(key)
	kvscache.Put(key,val)
End Sub
Public Sub put(key As String,val As Object)
	putObj(key,val)
End Sub
Public Sub getObjEnc(key As String,pass As String) As Object
	Return getObjEncDef(key,pass,Null)
End Sub
Public Sub getObjEncDef(key As String,pass As String,def As Object) As Object
	key=comm.getMD5(key)
	If kvscache.ContainsKey(key) Then Return kvscache.GetEncrypted(key,pass) Else Return def
End Sub
Public Sub putObjEnc(key As String,val As Object,pass As String)
	key=comm.getMD5(key)
	kvscache.PutEncrypted(key,val,pass)
End Sub
Public Sub close
	kvscache.Close
End Sub
Public Sub getBitmap(key As String) As Bitmap
	key=comm.getMD5(key)
'	Dim bmp As Bitmap
'	bmp.Initialize(File.DirTemp,key)
'	Return bmp
	Return kvscache.GetBitmap(key)
End Sub
Public Sub putBitmap(key As String,bmp As Bitmap)
	key=comm.getMD5(key)
'	kvscache.PutSimple(key,File.Combine(File.DirTemp,key))
'	Dim ops As OutputStream= File.OpenOutput(File.DirTemp,key,False)
'	bmp.WriteToStream(ops,100,"PNG")
'	ops.Close
	kvscache.PutBitmap(key,bmp)
End Sub
Public Sub get(key As String) As Object
	key=comm.getMD5(key)
	Return kvscache.Get(key)
End Sub
Public Sub remove(key As String)
	key=comm.getMD5(key)
	kvscache.Remove(key)
End Sub
Public Sub clearAllCache
	kvscache.DeleteAll
End Sub
