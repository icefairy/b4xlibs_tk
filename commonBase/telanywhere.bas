Type=Class
Version=3.48
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'需要定义为持续化变量或者全局变量，否则类会被自动销毁，导致事件无法触发
Sub Class_Globals
	Dim ptelany As Panel
	Dim iv_telanywhere As ImageView
	Dim nW As Int=70dip,nH As Int=70dip
	Dim ol,ot,newl,newt As Int
	Dim tmr As Timer
	Dim tClick As Long=0
	Dim nt As Int
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(pg As Page)
	ptelany.Initialize("ptelany")
	tmr.Initialize("tmr",500)
	tmr.Enabled=True
	iv_telanywhere.Initialize("")
	ptelany.AddView(iv_telanywhere,0,0,nW,nH)
	iv_telanywhere.Bitmap=comm.bmpTelAnyWhere
	iv_telanywhere.ContentMode=iv_telanywhere.MODE_FIT
	pg.RootPanel.AddView(ptelany,90%x-nW,80%y,nW,nH)
	ptelany.BringToFront
	Log("ptelany added")
End Sub
Sub tmr_Tick
	Log("telanywhere tmr_tick")
	If tmr.Interval=1500 Then
		tmr.Interval=1000
	Else
		tmr.Enabled=False
	End If
	ptelany.BringToFront
End Sub
Sub ptelany_Click
	Log("ptelany_click")
	Msgbox2("gotel","确定要拨打:"&comm.KEFU_PHONE&"吗？","拨打电话",Array ("是","否"))
End Sub
Sub gotel_Click(it As String)
	If it.EqualsIgnoreCase("gotel") Then comm.makecall(comm.KEFU_PHONE)
End Sub
private Sub ptelany_Touch (Action As Int, X As Float, Y As Float)
'	Log("Action:"&Action&" x:"&X&" y:"&y)
	Select Action
		Case ptelany.ACTION_DOWN'按下
			tClick=DateTime.Now
			ol=ptelany.Left
			ot=ptelany.Top
		Case ptelany.ACTION_MOVE'移动
			'		ptelany.Left=X-nWH/2
			'		ptelany.Top=y-nWH/2

		Case ptelany.ACTION_UP'放开
			'		ptelany.Left=(X+ol)
			'		ptelany.top=(y+ot)
			newl=X+ol-nW/2
			newt=Y+ot-nH/2
			ptelany.SetLayoutAnimated(0,500,newl,newt,nW,nH)
			nt=DateTime.Now-tClick
			'		Log("nt:"&nt&" x:"&Abs(newl-ol)&" Y:"&Abs(newt-ot))
			If nt<200 And (Abs(newl-ol)<20 Or Abs(newt-ot)<20) Then
				'如果按下到放开之间小于200ms钟则视为点击
				ptelany_Click
			End If
	End Select
End Sub