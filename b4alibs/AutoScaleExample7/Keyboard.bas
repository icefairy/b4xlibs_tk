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
'This module uses the Scale module to scale views added in the code
Sub Process_Globals

End Sub

Sub Globals
	Dim pnlKeyboard As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	InitKeyboard
End Sub

Sub Activity_Resume
	Scale.SetRate(0.5)
	Scale.ScaleAll(pnlKeyboard, True)
	
	pnlKeyboard.Left = 50%x - pnlKeyboard.Width / 2
	pnlKeyboard.Top = 50%y - pnlKeyboard.Height / 2
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

'Initializes the keyboard
Sub InitKeyboard
	Dim row, col, coln, i As Int
	Dim x, y, space, width As Int
	
	width = 60dip
	space = 4dip
	pnlKeyboard.Initialize("")
	Activity.AddView(pnlKeyboard, 0, 0, 3 * width + 4 * space, 4 * width + 5 * space)
	pnlKeyboard.Color = Colors.Gray
	i = -1
	For row = 0 To 3
		If row = 0 Then
			coln = 0
		Else
			coln = 2
		End If
		x = space
		y = pnlKeyboard.Height - (row + 1) * (width + space)
		For col = 0 To coln
			i = i + 1
			Dim btnKey As Button
			btnKey.Initialize("btnKey")
			x = space + col *(width + space)
			pnlKeyboard.AddView(btnKey, x, y, width, width)
			btnKey.TextSize = 24
			btnKey.Text = i
		Next
	Next
End Sub
