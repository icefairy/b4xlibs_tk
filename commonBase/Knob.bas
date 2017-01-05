Type=Class
Version=3.5
@EndOfDesignText@
'Class module
#Event: AngleChanged (Delta As Int)
Sub Class_Globals
	Private EventName As String
	Private CallBack As Object
	Private radius As Float
	Private cvs As Canvas
	Private bmp As Bitmap
	Private startAngle As Float
	Private currentAngle As Float
	Private destRect As Rect
	Private pnl As Panel
End Sub

Public Sub Initialize (vCallback As Object, vEventName As String)
	EventName = vEventName
	CallBack = vCallback
End Sub

Public Sub DesignerCreateView(base As Panel, lbl As Label, props As Map)
	base.Width = Max(base.Width, base.Height)
	base.Height = base.Width
	pnl.Initialize("")
	Dim r As Reflector
	r.Target = pnl
	r.SetOnTouchListener("pnl_Touch")
	base.AddView(pnl, 0, 0, base.Width, base.Height)
	radius = base.Width / 2
	Dim bd As BitmapDrawable = base.Background
	cvs.Initialize(base)
	bmp = bd.Bitmap
	destRect.Initialize(0, 0, radius * 2, radius * 2)
End Sub

Sub pnl_Touch  (viewtag As Object, action As Int, X As Float, Y As Float, motionevent As Object) As Boolean
	If action = 0 Then 'ACTION_DOWN
		startAngle = ATan2(X - radius, Y - radius)
	Else If action = 2 Then 'ACTION_MOVE
		Dim angle As Float = ATan2(X - radius, Y - radius)
		currentAngle = currentAngle - angle + startAngle
		Dim delta As Int = (startAngle - angle) * 180 / cPI
		If delta > 180 Then 
			delta = delta - 360
		Else If delta < -180 Then
			delta = delta + 360
		End If
		CallSubDelayed2(CallBack, EventName & "_AngleChanged", delta)
		startAngle = angle
		cvs.DrawBitmapRotated(bmp, Null, destRect, currentAngle * 180 / cPI)
		pnl.Invalidate
	End If
	Return True
End Sub
