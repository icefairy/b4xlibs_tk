Type=Class
Version=4.7
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Handler class
Sub Class_Globals
	Dim ABM As ABMaterial
	Public DownLoadAllowedfiles As List
End Sub

Public Sub Initialize
	
End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)	
	'get the callback page from the session (multiple modules can use this handler)
	Dim callback As Object = req.GetSession.GetAttribute("abmcallback")	
	Dim downloadfolder As String = File.Combine(File.DirApp, req.GetSession.GetAttribute("abmdownloadfolder"))
	Dim MaxSize As Int
	Dim ActiveCaseNumber As String
	Try
		MaxSize = req.GetSession.GetAttribute("abmmaxsize")
	Catch			
		resp.SendError(500, LastException.Message)
		Return
	End Try
	
	Try
		ActiveCaseNumber = req.GetSession.GetAttribute("abmactivecasenumber")
	Catch			
		Log("no number")
	End Try
	
	Dim data As Map	
	Dim fileName As String
	Dim tmpFileName As String
	DownLoadAllowedfiles.Initialize2(Array As String(".ZIP", ".PNG", ".JPG", ".JPEG"))
	Try
		data = req.GetMultipartData(downloadfolder, MaxSize)	
		Dim filePart As Part = data.Get("upl")			
		If filePart.IsInitialized Then
			fileName = 	filePart.SubmittedFilename
			tmpFileName = filePart.TempFile		
			If IsAllowed(fileName) = False Then
				File.Delete("", tmpFileName)
				If SubExists(callback, "Page_FileUploaded") Then			
					CallSubDelayed3(callback, "Page_FileUploaded", fileName, False)
				End If
				'resp.SendError(500, "Not allowed")
				Return	
			End If			
			
			If ABM.HandleUpload(downloadfolder, tmpFileName, ActiveCaseNumber & fileName) Then	
				If SubExists(callback, "Page_FileUploaded") Then
					CallSubDelayed3(callback, "Page_FileUploaded", fileName, True)
				End If
			Else
				If SubExists(callback, "Page_FileUploaded") Then			
					CallSubDelayed3(callback, "Page_FileUploaded", fileName, False)
				End If
			End If			
		Else ' try image
			Dim filePart As Part = data.Get("imageFromCanvas")
			fileName = filePart.SubmittedFilename		
			tmpFileName = filePart.TempFile		
			If IsAllowed(fileName) = False Then
				File.Delete("", tmpFileName)
				If SubExists(callback, "Page_FileUploaded") Then			
					CallSubDelayed3(callback, "Page_FileUploaded", fileName, False)
				End If
				'resp.SendError(500, "Not allowed")
				Return	
			End If			
			If ABM.HandleUpload(downloadfolder, tmpFileName, ActiveCaseNumber & fileName) Then	
				If SubExists(callback, "Page_FileUploaded") Then
					CallSubDelayed3(callback, "Page_FileUploaded", fileName, True)
				End If
			Else
				If SubExists(callback, "Page_FileUploaded") Then			
					CallSubDelayed3(callback, "Page_FileUploaded", fileName, False)
				End If
			End If	
		End If
		
	Catch		
		resp.SendError(500, LastException.Message)
		If SubExists(callback, "Page_FileUploaded") Then
			CallSubDelayed3(callback, "Page_FileUploaded", LastException.Message , False)
		End If		
	End Try		
End Sub

Sub IsAllowed(fileName As String) As Boolean
	If DownLoadAllowedfiles.Size = 0 Then Return True
	For i = 0 To DownLoadAllowedfiles.Size - 1
		If fileName.ToUpperCase.EndsWith(DownLoadAllowedfiles.Get(i)) Then
			Return True
		End If
	Next
	Return False
End Sub