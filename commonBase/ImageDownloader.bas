Type=Class
Version=3.48
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'depends on iCache,HttpUtils2
Sub Class_Globals
	'	Public gravitymode As Object=Null
	Private taskobjs,taskkeys As List
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	taskkeys.Initialize
	taskobjs.Initialize
	
End Sub
Public Sub addJob2(url As String,iv As ImageView,usingcache As Boolean)
	Dim m As Map
	m.Initialize
	m.Put("url",url)
	m.Put("iv",iv)
	Dim key As String=comm.getMD5(url)
	m.Put("key",key)
	m.Put("cache",usingcache)
	If usingcache And comm.cache.ContainsKey(key) Then
		iv.Bitmap=comm.cache.getBitmap(key)
		'		If gravitymode<>Null Then iv.ContentMode=gravitymode
	Else
		If taskkeys.IndexOf(key)>-1 Then
			Log("on going:"&url)
		Else
			taskobjs.Add(m)
			taskkeys.Add(key)
			Dim j As HttpJob
			j.Initialize(key, Me)
			j.Download(url)
		End If
	End If
End Sub
Public Sub addJob3(url As String,cb As Int)
	Dim m As Map
	m.Initialize
	m.Put("url",url)
	m.Put("cb",cb)
	Dim key As String=comm.getMD5(url)
	m.Put("key",key)
	If comm.cache.ContainsKey(key) Then
		passimg(cb,comm.cache.getBitmap(key))
	Else
		If taskkeys.IndexOf(key)>-1 Then
			Log("on going:"&url)
		Else
			taskobjs.Add(m)
			taskkeys.Add(key)
			Dim j As HttpJob
			j.Initialize(key, Me)
			j.Download(url)
		End If
	End If
End Sub
Public Sub addJob(url As String,iv As ImageView)
	addJob2(url,iv,True)
End Sub
Sub JobDone(Job As HttpJob)
	If Job.Success Then
		Log("jd:"&Job.JobName)
		Dim bmp As Bitmap = Job.GetBitmap
		Dim idx As Int=taskkeys.IndexOf(Job.JobName)
		Dim m As Map=taskobjs.Get(idx)
		If m.GetDefault("cache",False) Then comm.cache.putBitmap(Job.JobName,bmp)
		Dim cb As Int=m.GetDefault("cb",-1)
		If cb<>-1 Then
			passimg(cb,bmp)
		Else
			Dim iv As ImageView=m.Get("iv")
			iv.Bitmap=bmp
		End If
		taskkeys.RemoveAt(idx)
		taskobjs.RemoveAt(idx)
		'		If gravitymode<>Null Then iv.ContentMode=gravitymode
	Else
		Log("Error downloading image: " & Job.JobName & CRLF & Job.ErrorMessage)
	End If
	Job.Release
End Sub
Private Sub passimg(cb As Int,img As Bitmap)
	Select cb
		Case 0
			modmain.gotheaderimg(img)
		Case 1
			modPicViewer.imgLoaded(img)
		Case Else
			Log("passimg unknow flg:"&cb)
	End Select
End Sub
