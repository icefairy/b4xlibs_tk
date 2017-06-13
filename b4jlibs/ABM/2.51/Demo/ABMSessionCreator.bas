Type=Class
Version=5.45
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Filter class
Sub Class_Globals
	
End Sub

Public Sub Initialize
	
End Sub

'Return True to allow the request to proceed.
Public Sub Filter(req As ServletRequest, resp As ServletResponse) As Boolean
	DateTime.DateFormat = "dd/MM/yyyy"
	DateTime.TimeFormat = "HH:mm"
	
	Log("In filter: " & DateTime.Date(DateTime.Now) & " " & DateTime.Time(DateTime.now))
		
	req.GetSession  'a new session will be created if a session doesn't exist.			
	Return True
End Sub
