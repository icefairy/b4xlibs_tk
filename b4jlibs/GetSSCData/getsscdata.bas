Type=Class
Version=4.2
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Handler class
Sub Class_Globals
	Private cmd As String
End Sub

Public Sub Initialize
	
End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)
	cmd=req.GetParameter("cmd").ToLowerCase
	Select cmd
	Case "1"
		Dim num As String=req.GetParameter("num")
		If IsNumber(num) Then Main.num=num
		resp.Write(Main.getDataJson)
	End Select
	
End Sub
