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
'This module uses the Scale module to scale the layout af a calculator.
'The calculator doesn't work it's code is left out.
Sub Process_Globals

End Sub

Sub Globals
	Dim pnlCalculator, pnlFunctions As Panel
	Dim lblRegT As Label
	Dim btnFunc As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("calc_main")
	Activity.Title = "Calculator"
	
	pnlCalculator.LoadLayout("calc_calculator")
	pnlFunctions.LoadLayout("calc_functions")
	
	pnlFunctions.BringToFront
	
	If FirstTime Then
		Scale.SetRate(0.4)
'		Scale.SetRate(0.8)
'		Scale.SetRate(1)
	
		Dim ph As Phone
		'check if pnlCalculator.Height with portrait scaling is higher than the screen height in landscape
		If Scale.GetDevicePhysicalSize < 6 Or pnlCalculator.Height * Scale.GetScaleY_P > (Min(Activity.Height, Activity.Width) - 50dip) Then
			' if yes set only portrait orientation
			ph.SetScreenOrientation(1)
		Else
			' if no authorize both orientations
			ph.SetScreenOrientation(-1)
		End If
	End If
	
	Scale.SetRate(0.4)
'	Scale.SetRate(0.8)
'	Scale.SetRate(1)
	Scale.ScaleAll(Activity, True)
	
	' check if the pnlCalculator.Width + pnlFunctions.Width smaller than the screen width
	If pnlCalculator.Width + pnlFunctions.Width < Activity.Width Then
		' if yes, put pnlCalculator and pnlFunctions side by side and hide btnFunc
		pnlCalculator.Left = 50%x - pnlCalculator.Width
		pnlFunctions.Left = 50%x
		pnlFunctions.Visible = True
		btnFunc.Visible = False
	Else
		' if no, show only pnlCalculator hide pnlFunctions and leave btnFunc visible 
		pnlCalculator.Left = (100%x - pnlCalculator.Width) / 2
		pnlCalculator.Top = (100%y - pnlCalculator.Height) / 2
		pnlFunctions.Left = pnlCalculator.Left
		pnlFunctions.Top = pnlCalculator.Top + pnlCalculator.Height - pnlFunctions.Height
		pnlFunctions.Visible = False
	End If
End Sub	

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub btnFunc_Click
	pnlFunctions.Visible = Not(pnlFunctions.Visible)
End Sub
