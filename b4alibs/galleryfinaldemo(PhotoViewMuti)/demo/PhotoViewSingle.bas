Type=Activity
Version=6.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Dim PhotoView1 As PhotoView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("2")
	PhotoView1.Color = Colors.Black
	PhotoView1.setUrlImageBitmap("http://ottmag.com/wp-content/uploads/2016/04/First-date-ideas-0-341x220.jpg",341,220)
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean
	'假如没有这段代码Activity_KeyPress，你点击了退出键，这就是交给系统处理
	If (KeyCode = KeyCodes.KEYCODE_BACK) Then
		Activity.Finish
		Return False	
	End If
End Sub