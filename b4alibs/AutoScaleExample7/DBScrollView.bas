Type=Activity
Version=7.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region Module Attributes
	#FullScreen: False
	#IncludeTitle: True
#End Region

'DBScrollView Activity module
'This module uses the Scale module to scale the internal views of a ScrollView2D.
Sub Process_Globals
' variables from the ScrollviewExample	
	Dim NumberOfColumns = 5 As Int
	Dim NumberOfRows = 0 As Int
	Dim RowHeight = 30dip As Int
	Dim RowLineWidth = 1dip As Int
	Dim RowHeight_1 As Int					: RowHeight_1 = RowHeight - RowLineWidth
	Dim ColLineWidth = 1dip As Int
	Dim ColumnWidth(NumberOfColumns) As Int
		ColumnWidth(0) = 60dip
		ColumnWidth(1) = 120dip
		ColumnWidth(2) = 120dip
		ColumnWidth(3) = 180dip
		ColumnWidth(4) = 120dip
	Dim ColumnWidth_1(NumberOfColumns) As Int
	Dim TotalColumnWidth(NumberOfColumns + 1) As Int

' variables for SQLExamle
	Dim ColumnName(NumberOfColumns) As String	' names of the columns
		ColumnName(0) = "ID"
		ColumnName(1) = "FirstName"
		ColumnName(2) = "LastName"
		ColumnName(3) = "Address"
		ColumnName(4) = "City"
	
' variables from the ScrollviewExample	
	Dim HeaderColor As Int					: HeaderColor = Colors.Blue
	Dim HeaderFontColor As Int			: HeaderFontColor = Colors.Yellow
	Dim HeaderLineColor As Int			: HeaderLineColor = Colors.Yellow
	Dim CellColor As Int						: CellColor = Colors.RGB(255,255,220)
	Dim FontColor As Int						: FontColor = Colors.Black
	Dim FontSize As Float						: FontSize = 14
	Dim Alignment As Int						: Alignment = Gravity.CENTER

	Type RowCol (Row As Int, Col As Int)
	
End Sub

Sub Globals
	Dim scvPersons As ScrollView2D
	Dim pnlHeader As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Dim i As Int
	
	' scale the different dimension variables
	If FirstTime = True Then
		ColLineWidth = ColLineWidth * Scale.GetScaleX
		RowLineWidth = RowLineWidth * Scale.GetScaleX
		RowHeight = RowHeight * Scale.GetScaleY
		RowHeight_1 = RowHeight - RowLineWidth
		FontSize = FontSize * Scale.GetScaleX
		For i = 0 To NumberOfColumns - 1
			ColumnWidth(i) = ColumnWidth(i) * Scale.GetScaleX
		Next
	End If
	
	' initialze the internal column width and left coordinates
	TotalColumnWidth(0) = ColLineWidth
	For i = 0 To NumberOfColumns - 1
		ColumnWidth_1(i) = ColumnWidth(i) - ColLineWidth
		TotalColumnWidth(i + 1) = TotalColumnWidth(i) + ColumnWidth(i)
	Next
	
	' initialize the ScrollView2D
	scvPersons.Initialize(100,100, "scvPersons")
	Activity.AddView(scvPersons, 0, RowHeight, 100%x, 100%y - RowHeight)

	' initialize the ScrollView width
	scvPersons.Panel.Width = TotalColumnWidth(NumberOfColumns)
End Sub

Sub Activity_Resume
	SQLTableRead
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub SQLTableRead
' Reads the SQL data base
	Dim i As Int
	Dim Cursor1 As Cursor
	Dim txt As String

	txt = "SELECT * FROM " & Main.DBTableName

	Cursor1 = Main.SQL1.ExecQuery(txt)

	Dim Col(NumberOfColumns) As String
	
	SetHeader(ColumnName)
	NumberOfRows = 0
	
	For i = 0 To Cursor1.RowCount - 1
		Dim Col(NumberOfColumns) As String
		Cursor1.Position = i
		For j = 0 To NumberOfColumns - 1
			Col(j) = Cursor1.GetString(ColumnName(j))
		Next
		AddRow(Col)
	Next
	Cursor1.Close
End Sub

Sub AddRow(Values() As String)
	'Adds a row to the table
	If Values.Length <> NumberOfColumns Then
		Return
	End If

	For i = 0 To NumberOfColumns - 1
		Dim l As Label
		l.Initialize("cell")
		l.Text = Values(i)
		l.Gravity = Alignment
		l.TextSize = FontSize
		l.TextColor = FontColor
		l.Color = CellColor
		Dim rc As RowCol
		rc.Initialize
		rc.Col = i
		rc.Row = NumberOfRows
		l.Tag = rc
		scvPersons.Panel.AddView(l, TotalColumnWidth(i), RowHeight * NumberOfRows, _
		ColumnWidth_1(i), RowHeight_1)
	Next
	NumberOfRows = NumberOfRows + 1
	scvPersons.Panel.Height = NumberOfRows * RowHeight
End Sub

Sub SetHeader(Values() As String)
	'Set the headers values
	If pnlHeader.IsInitialized Then 'should only be called once
		Return
	End If
	
	pnlHeader.Initialize("")
	pnlHeader.Color = HeaderLineColor

	For i = 0 To NumberOfColumns - 1
		Dim l As Label
		l.Initialize("Header")
		l.Text = Values(i)
		l.Gravity = Gravity.CENTER
		l.TextSize = FontSize
		l.Color = HeaderColor
		l.TextColor = HeaderFontColor
		l.Tag = i
		pnlHeader.AddView(l, TotalColumnWidth(i), 0, ColumnWidth_1(i), RowHeight_1)
	Next
	Activity.AddView(pnlHeader, scvPersons.Left, 0, TotalColumnWidth(NumberOfColumns), RowHeight)
End Sub

Sub scvPersons_ScrollChanged(PosX As Int, PosY As Int)
	pnlHeader.Left = -PosX
End Sub