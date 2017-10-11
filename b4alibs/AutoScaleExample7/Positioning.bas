Type=Activity
Version=7.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region Module Attributes
	#FullScreen: False
	#IncludeTitle: True
#End Region

'Activity module
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	Dim Button1, Button2, Button3, Button4, Button5 As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("positioning")
	
End Sub

Sub Activity_Resume
	Dim Space As Int
	
	Scale.SetRate(0.5)
	Scale.ScaleAll(Activity, True)
	Space = 10dip * Scale.GetScaleX
	
	Button1.Top = Space
	
	Button2.Left = Space
	Scale.SetRight(Button4, 100%x - Space)
	Scale.SetTopAndBottom2(Button4, Activity, Space, Activity, Space)
	Scale.SetLeftAndRight2(Button1, Activity, Space, Button4, Space)
	Scale.SetTopAndBottom2(Button2, Button1, Space, Activity, Space)
	Scale.SetBottom(Button5, 100%y - Space)
	Scale.HorizontalCenter(Button5)
	Scale.SetLeftAndRight2(Button3, Button2, Space, Button4, Space)
	Scale.SetTopAndBottom2(Button3, Button1, Space, Button5, Space)
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


