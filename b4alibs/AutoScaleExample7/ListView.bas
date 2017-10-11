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
'This module uses the Scale module to scale the internal views of a ListView.
Sub Process_Globals

End Sub

Sub Globals
	Dim pnlListView As Panel
	Dim lblListViewTitle As Label
	Dim ltvTest As ListView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("listview")
	
	Scale.SetRate(0.5)
	Scale.ScaleAll(Activity, True)
	
	pnlListView.Left = (100%x - pnlListView.Width) / 2
	pnlListView.Height = 100%y
	ltvTest.Height = pnlListView.Height - ltvTest.Top - 10dip * Scale.GetScaleY
End Sub

Sub Activity_Resume
	FillListView
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub FillListView
	Dim i As Int
	Dim bmp As Bitmap
	
	bmp.Initialize(File.DirAssets, "rose.png")
	
	For i = 0 To 30
		ltvTest.AddSingleLine("One line " & i)
		ltvTest.AddTwoLines("First line " & i, "Second line " & i)
		ltvTest.AddTwoLinesAndBitmap("First line " & i, "Second line " & i, bmp)
	Next
End Sub

