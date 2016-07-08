Type=StaticCode
Version=6
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Code module
'this module use to exit all activity from anywhere,using this you must add
'comm.addthis(comm.getthis(Me)) in your each activity_oncreate sub
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private lstAct As List
End Sub

public Sub getthis(obj As Object) As Object
	Dim ref As Reflector
	ref.Target=obj
	Return ref.GetActivity
End Sub
Public Sub addthis(obj As Object)
	If lstAct.IsInitialized=False Then lstAct.Initialize
	lstAct.Add(obj)
End Sub
public Sub exitall
	Dim act As Reflector
	For i=0 To lstAct.Size-1
		act.Target=lstAct.Get(0)
		Try
		act.RunMethod("finish")
		Catch
			Log(LastException.Message)
		End Try
		lstAct.RemoveAt(0)
	Next
	StopService(Starter)
	ExitApplication
End Sub