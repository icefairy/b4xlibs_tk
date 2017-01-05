Type=StaticCode
Version=5.18
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

	Type typViewCmnProp(LeftPerc As Float, _
						TopPerc As Float, _
						WidthPerc As Float, _
						HeightPerc As Float)


	Type typViewProp(ViewName As String, _
					 ViewType As String, _
					 CmnProp As typViewCmnProp)
	
	Private mWriter As TextWriter
	
	Private mPath As String

End Sub

Public Sub Init(Path As String, FileName As String)
	If mWriter.IsInitialized Then Return
	mPath = Path
	mWriter.Initialize(File.OpenOutput(mPath, FileName, False))
End Sub

Sub GeneratePercLayoutCode(Parent As Panel, ParentName As String)

	Dim SetLayoutCodeLines As List
	SetLayoutCodeLines.Initialize

	' In fact, it writes the intial Activity devider line
	SetLayoutCodeLines.Add(CRLF & "@@@@@@@@@@@@@@@@@@@@@     " & ParentName & "     @@@@@@@@@@@@@@@@@@@@@" & CRLF)

	SetLayoutCodeLines.Add("#Region  * SET VIEWS LAYOUTS  ")

	Gencode(Parent, ParentName, SetLayoutCodeLines)
	
	SetLayoutCodeLines.Add(CRLF & "#End Region" & CRLF)

	SavePercLayout(SetLayoutCodeLines)
End Sub


Sub Gencode(Parent As Panel, ParentName As String, SetLayoutCodeLines As List)
	Dim vw As View
	Dim ViewType As String
	Dim TypeString As String
	
	SetLayoutCodeLines.Add(CRLF & TAB & "' " & ParentName & " content.")
	Dim LastDotPos As Int

	For I = 0 To Parent.NumberOfViews-1
		Dim ViewProp As typViewProp
		ViewProp.Initialize

		vw = Parent.GetView(I)

		If vw Is Panel Then
			ViewType = "Panel"
		Else
			TypeString = GetType(vw)
			LastDotPos = TypeString.LastIndexOf(".")
			ViewType = TypeString.SubString(LastDotPos + 1)
		End If
		ViewProp.ViewType = ViewType

		' Name - shuld be used reflection!
		ViewProp.ViewName = vw.tag
		
		CalcPerc(vw, ViewProp, Parent.Width, Parent.Height)
		AddCodeLine(ViewProp, ParentName, SetLayoutCodeLines)

		If vw Is Panel Then
			Gencode(vw, ViewProp.ViewName, SetLayoutCodeLines)
		End If
	Next
	
End Sub

Sub CalcPerc(vw As View, ViewProp As typViewProp, ActWidth As Int, ActHeight As Int)
	' - Left
	ViewProp.CmnProp.LeftPerc = (vw.Left / 100%x) * 100
	' - Top
	ViewProp.CmnProp.TopPerc = (vw.Top / 100%y) * 100
	' - Width
	ViewProp.CmnProp.WidthPerc = (vw.Width / 100%x) * 100
	' - Height
	ViewProp.CmnProp.HeightPerc = (vw.Height / 100%y) * 100
End Sub

Sub AddCodeLine(ViewProp As typViewProp, ParentName As String, SetLayoutCodeLines As List)

	Dim CodeLine As String

	If ParentName = "Main" Then ParentName = "Activity"
	CodeLine = TAB
	CodeLine = CodeLine & ViewProp.ViewName & ".SetLayout(" _
																  & NumberFormat(ViewProp.CmnProp.LeftPerc, 1, 3) & "%x" _
																  & ", " & NumberFormat(ViewProp.CmnProp.TopPerc, 1, 3) & "%y" _
																  & ", " & NumberFormat(ViewProp.CmnProp.WidthPerc, 1, 3) & "%x" _
																  & ", " & NumberFormat(ViewProp.CmnProp.HeightPerc, 1, 3) & "%y" _
																  & ")"
	SetLayoutCodeLines.Add(CodeLine)
End Sub


Sub SavePercLayout(CodeLines As List)
	Log("Generated code:")
	Dim CodeLine As String
	For j = 0 To CodeLines.Size-1
		CodeLine = CodeLines.Get(j)
		Log(CodeLine)
		mWriter.WriteLine(CodeLine)
	Next
End Sub


Public Sub Close
	mWriter.Flush
	mWriter.Close
End Sub