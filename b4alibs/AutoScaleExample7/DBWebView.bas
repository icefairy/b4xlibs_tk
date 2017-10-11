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
'This module uses the Scale module to scale the TextSize of a WebView Table.
'The DBUtils has been modified for this
Sub Process_Globals

End Sub

Sub Globals
	Dim wbwTable As WebView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	wbwTable.Initialize("wbwTable")
	Activity.AddView(wbwTable, 0, 0, 100%x, 100%y)
	
	ShowTableInWebView
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub ShowTableInWebView
	Dim txt As String
	
	txt = "SELECT ID, FirstName As [First name], LastName As Name, Address, City FROM " & Main.DBTableName

	'[First Name] || ' ' || [Last Name] As Name => 
	'Creates a column named Name which is made of the First Name AND Last Name fields (with a space between them).
'	txt = "SELECT ID, [FirstName] || ' ' || [LastName] As Name, Address As Address, City As City FROM " & DBTableName

	wbwTable.LoadHtml(DBUtils.ExecuteHtml2(Main.SQL1, txt, Null, 0, True, 16 * Scale.GetScaleX))
End Sub
