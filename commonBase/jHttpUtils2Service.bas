Type=StaticCode
Version=2.2
B4J=true
@EndOfDesignText@
 
Sub Process_Globals
	Private hc As HttpClient
	Private TaskIdToJob As Map
	Public TempFolder As String
	Private taskCounter As Int
End Sub

Sub Initialize
	If hc.IsInitialized = False Then
		TempFolder = File.DirTemp
		hc.Initialize("hc")
		TaskIdToJob.Initialize
	End If
End Sub



Public Sub SubmitJob(job As HttpJob) As Int
	taskCounter = taskCounter + 1
	TaskIdToJob.Put(taskCounter, job)
	If job.Username <> "" AND job.Password <> "" Then
		hc.ExecuteCredentials(job.GetRequest, taskCounter, job.Username, job.Password)
	Else
		hc.Execute(job.GetRequest, taskCounter)
	End If
	Return taskCounter
End Sub

Sub hc_ResponseSuccess (Response As HttpResponse, TaskId As Int)
	Response.GetAsynchronously("response", File.OpenOutput(TempFolder, TaskId, False), _
		True, TaskId)
End Sub

Sub Response_StreamFinish (Success As Boolean, TaskId As Int)
	If Success Then
		CompleteJob(TaskId, Success, "")
	Else
		CompleteJob(TaskId, Success, LastException.Message)
	End If
End Sub

Sub hc_ResponseError (Response As HttpResponse, Reason As String, StatusCode As Int, TaskId As Int)
	If Response <> Null Then
		Try
			Log(Response.GetString("UTF8"))
		Catch
			Log("Failed to read error message.")
		End Try
		Response.Release
	End If
	CompleteJob(TaskId, False, Reason)
End Sub

Sub CompleteJob(TaskId As Int, success As Boolean, errorMessage As String)
	Dim job As HttpJob
	job = TaskIdToJob.Get(TaskId)
	TaskIdToJob.Remove(TaskId)
	job.success = success
	job.errorMessage = errorMessage
	job.Complete(TaskId)
End Sub

