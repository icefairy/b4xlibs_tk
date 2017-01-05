Type=Class
Version=3.48
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
Sub Class_Globals
	Dim tmr As Timer
	Private vv As View
	Private ncur As Int=0,mTime As Int
	Private sOldText As String
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(v As View,nTime As Int)
	vv=v
	mTime=nTime
	tmr.Initialize("tmr",1000)
	tmr.Enabled=True
	ncur=0
	sOldText=gettext
	comm.enablebtn(v,False)
End Sub
Private Sub settext(s As String)
	If vv Is Button Then
		Dim btn As Button=vv
		btn.Text=s
	Else if vv Is Label Then
		Dim lbl As Label=vv
		lbl.Text=s
	Else
		Log("unknow type:"&GetType(vv))
	End If
End Sub
Private Sub gettext As String
	If vv Is Button Then
		Dim btn As Button=vv
		Return btn.Text
	Else if vv Is Label Then
		Dim lbl As Label=vv
		Return lbl.Text
	Else
		Return "unknow type:"&GetType(vv)
	End If
	Return ""
End Sub
Sub tmr_Tick
	ncur=ncur+1
	'	Log("tmr_tick")
	If ncur >= mTime Then
		tmr.Enabled=False
		comm.enablebtn(vv,True)
		settext(sOldText)
	Else
		'		vv.UserInteractionEnabled=False
		'		Log((mTime-ncur)&"秒")
		settext((mTime-ncur)&"秒")
	End If
End Sub