﻿Type=Class
Version=4.7
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Handler class
Sub Class_Globals
	Dim ABM As ABMaterial
End Sub

Public Sub Initialize
	
End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)	
	'get the callback page from the session (multiple modules can use this handler)
	Dim callback As Object = req.GetSession.GetAttribute("abmcallback")	
	Dim downloadfolder As String = File.Combine(File.DirApp, req.GetSession.GetAttribute("abmdownloadfolder"))
	Dim MaxSize As Int
	Try
		MaxSize = req.GetSession.GetAttribute("abmmaxsize")
	Catch			
		resp.SendError(500, LastException.Message)
		Return
	End Try
	Dim data As Map	
	Dim fileName As String
	Dim tmpFileName As String
	
	Try
		data = req.GetMultipartData(downloadfolder, MaxSize)	
		Dim filePart As Part = data.Get("upl")			
		If filePart.IsInitialized Then
			fileName = 	filePart.SubmittedFilename		
			tmpFileName = filePart.TempFile		
			If ABM.HandleUpload(downloadfolder, tmpFileName, fileName) Then	
				If SubExists(callback, "Page_FileUploaded") Then
					CallSubDelayed3(callback, "Page_FileUploaded", fileName, True)
				End If
			Else
				resp.SendError(500, "Error")	
				'If SubExists(callback, "Page_FileUploaded") Then
				'	CallSubDelayed3(callback, "Page_FileUploaded", fileName, False)
				'End If
			End If			
		Else ' try image
			Dim filePart As Part = data.Get("imageFromCanvas")
			fileName = filePart.SubmittedFilename		
			tmpFileName = filePart.TempFile	
			If ABM.HandleUpload(downloadfolder, tmpFileName, fileName) Then	
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