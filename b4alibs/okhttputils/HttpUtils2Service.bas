Type=Service
Version=6
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region Module Attributes
	#StartAtBoot: False
#End Region

'HttpUtils2 version 2.10 (based on OkHttp library)
'Service module
Sub Process_Globals
	Private hc As OkHttpClient
	Private TaskIdToJob As Map
	Public TempFolder As String
	Private taskCounter As Int
End Sub

Sub Service_Create
	TempFolder = File.DirInternalCache
	hc.Initialize("hc")
	TaskIdToJob.Initialize
End Sub

Sub Service_Start (StartingIntent As Intent)
End Sub

Sub Service_Destroy

End Sub

Public Sub SubmitJob(job As HttpJob) As Int
	taskCounter = taskCounter + 1
	If job.CookieAutoProcess Then'还原header
		Dim ckm As Map
		Try
		ckm=File.ReadMap(File.DirInternal,"mycookie")
		Catch
			ckm.Initialize
		End Try
		For i=0 To ckm.Size-1
			Dim key As String=ckm.GetKeyAt(i)
			If key.ToLowerCase.IndexOf("set-cookie")>-1 Then 
				job.GetRequest.SetHeader("Cookie",ckm.GetValueAt(i))	
			Else
				job.GetRequest.SetHeader(ckm.GetKeyAt(i),ckm.GetValueAt(i))
			End If
		Next
	End If
	TaskIdToJob.Put(taskCounter, job)
	If job.Username <> "" And job.Password <> "" Then
		hc.ExecuteCredentials(job.GetRequest, taskCounter, job.Username, job.Password)
	Else
		hc.Execute(job.GetRequest, taskCounter)
	End If
	Return taskCounter
End Sub

Sub hc_ResponseSuccess (Response As OkHttpResponse, TaskId As Int)
	Log("hc_ResponseSuccess")
	If Response.ContentLength=0 Then
		CompleteJob(TaskId, True, "")
	Else
		Dim job As HttpJob=TaskIdToJob.Get(TaskId)
		job.response=Response
		If job.CookieAutoProcess Then
			'直接存储cookie
			File.WriteMap(File.DirInternal,"mycookie",Response.GetHeaders)
		End If
		job.ocos.Initialize(File.OpenOutput(TempFolder, TaskId, False))
		Response.GetAsynchronously("response", job.ocos, _
			True, TaskId)
		TaskIdToJob.Put(TaskId,job)
	End If
	
End Sub

Sub Response_StreamFinish (Success As Boolean, TaskId As Int)
	Log("Response_StreamFinish")
	If Success Then
		CompleteJob(TaskId, Success, "")
	Else
		CompleteJob(TaskId, Success, LastException.Message)
	End If
	
End Sub

Sub hc_ResponseError (Response As OkHttpResponse, Reason As String, StatusCode As Int, TaskId As Int)
	Log("hc_ResponseError:"&Reason&" "&StatusCode)
	If Response <> Null Then
		Log(Response.ErrorResponse)
		Response.Release
	End If
	CompleteJob(TaskId, False, Reason)
End Sub
'Sub hc_writeProgress(current As Long,Total As Long)
'	Log("progress:"&current&"/"&Total)
'End Sub
Sub CompleteJob(TaskId As Int, success As Boolean, errorMessage As String)
	Dim job As HttpJob = TaskIdToJob.Get(TaskId)
	TaskIdToJob.Remove(TaskId)
	job.success = success
	job.errorMessage = errorMessage
	job.Complete(TaskId)
End Sub

