Type=Service
Version=5.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Public getui As b4agetui
End Sub

Sub Service_Create
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.

End Sub

Sub Service_Start (StartingIntent As Intent)
	getui.Init("gt")
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub


Sub gt_onClickid(cid As String)
	Log("cid:"&cid)
End Sub
'
Sub gt_onRec(str As String,messageid As String,taskid As String)
	'gotStr:{"a":"b","cc":"bb","taskid":"GT_0507_219bc14e97f7eb3515c7e6c065eef877"}
	Log("gotStr:"&str)
	Dim parser As JSONParser
	parser.Initialize(str)
	Dim root As Map = parser.NextObject
	Try
		'透传测试
		Dim action As String = root.Get("actionid")
		If action <> "" Then
			CallSubDelayed(Main,"cttest")
		End If
	Catch
		Log(LastException)
	End Try
	'回执调用，如果不需要直接去掉
	getui.sendFeedbackMessage(taskid,messageid,90001)
End Sub