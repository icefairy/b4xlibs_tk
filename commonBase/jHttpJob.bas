Type=Class
Version=2.2
B4J=true
@EndOfDesignText@

'HttpUtils2 version 1.00
'Class module
Sub Class_Globals
	Public JobName As String
	Public Success As Boolean
	Public Username, Password As String
	Public ErrorMessage As String
	Private target As Object
	Private taskId As String
	Private req As HttpRequest
	Public Tag As Object
#If UI
	Private fx As JFX
#End If
End Sub


'Initializes the Job.
'Name - The job's name. Note that the name doesn't need to be unique.
'TargetModule - The activity or service that will handle the JobDone event.
Public Sub Initialize (Name As String, TargetModule As Object)
	HttpUtils2Service.Initialize
	JobName = Name
	target = TargetModule
End Sub
'Sends a POST request with the given data as the post data.
Public Sub PostString(Link As String, Text As String)
	PostBytes(Link, Text.GetBytes("UTF8"))
End Sub

'Sends a POST request with the given string as the post data
Public Sub PostBytes(Link As String, Data() As Byte)
	req.InitializePost2(Link, Data)
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
End Sub

'Sends a PUT request with the given data as the post data.
Public Sub PutString(Link As String, Text As String)
	PutBytes(Link, Text.GetBytes("UTF8"))
End Sub

'Sends a PUT request with the given string as the post data
Public Sub PutBytes(Link As String, Data() As Byte)
	req.InitializePut2(Link, Data)
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
End Sub

'Sends a POST request with the given file as the post data.
'This method doesn't work with assets files.
Public Sub PostFile(Link As String, Dir As String, FileName As String)
	Dim length As Int
	If Dir = File.DirAssets Then
		Log("Cannot send files from the assets folder.")
		Return
	End If
	length = File.Size(Dir, FileName)
	Dim In As InputStream
	In = File.OpenInput(Dir, FileName)
	If length < 1000000 Then '1mb
		'There are advantages for sending the file as bytes array. It allows the Http library to resend the data
		'if it failed in the first time.
		Dim out As OutputStream
		out.InitializeToBytesArray(length)
		File.Copy2(In, out)
		PostBytes(Link, out.ToBytesArray)
	Else
		req.InitializePost(Link, In, length)
		CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
	End If
End Sub
'Submits a HTTP GET request.
'Consider using Download2 if the parameters should be escaped.
Public Sub Download(Link As String)
	req.InitializeGet(Link)
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
End Sub
'Submits a HTTP GET request.
'Encodes illegal parameter characters.
'<code>Example:
'job.Download2("http://www.example.com", _
'	Array As String("key1", "value1", "key2", "value2"))</code>
Public Sub Download2(Link As String, Parameters() As String)
	req.InitializeGet(escapeLink(Link, Parameters))
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)		
End Sub
Private Sub escapeLink(Link As String, Parameters() As String) As String
	Dim sb As StringBuilder
	sb.Initialize
	sb.Append(Link)
	If Parameters.Length > 0 Then sb.Append("?")
	Dim su As StringUtils
	For i = 0 To Parameters.Length - 1 Step 2
		If i > 0 Then sb.Append("&")
		sb.Append(su.EncodeUrl(Parameters(i), "UTF8")).Append("=")
		sb.Append(su.EncodeUrl(Parameters(i + 1), "UTF8"))
	Next
	Return sb.ToString
End Sub

Public Sub Delete(Link As String)
	req.InitializeDelete(Link)
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
End Sub

Public Sub Delete2(Link As String, Parameters() As String)
	req.InitializeDelete(escapeLink(Link, Parameters))
	CallSubDelayed2(HttpUtils2Service, "SubmitJob", Me)
End Sub

'Called by the service to get the request
Public Sub GetRequest As HttpRequest
	Return req
End Sub

'Called by the service when job completes
Public Sub Complete (id As Int)
	taskId = id
	CallSubDelayed2(target, "JobDone", Me)
End Sub

'Should be called to free resources held by this job.
Public Sub Release
	File.Delete(HttpUtils2Service.TempFolder, taskId)
End Sub

'Returns the response as a string encoded with UTF8.
Public Sub GetString As String
	Return GetString2("UTF8")
End Sub

'Returns the response as a string.
Public Sub GetString2(Encoding As String) As String
	Dim tr As TextReader
	tr.Initialize2(File.OpenInput(HttpUtils2Service.TempFolder, taskId), Encoding)
	Dim res As String
	res = tr.ReadAll
	tr.Close
	Return res
End Sub

#If UI
'Returns the response as a bitmap
Public Sub GetBitmap As Image
	Dim b As Image
	b = fx.LoadImage(HttpUtils2Service.TempFolder, taskId)
	Return b
End Sub
#End If
Public Sub GetInputStream As InputStream
	Dim In As InputStream
	In = File.OpenInput(HttpUtils2Service.TempFolder, taskId)
	Return In
End Sub
