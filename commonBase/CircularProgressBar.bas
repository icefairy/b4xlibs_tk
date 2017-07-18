Type=Class
Version=4.01
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'Custom View class
'version: 1.00
#DesignerProperty: Key: ColorFull, DisplayName: Color Full, FieldType: Color, DefaultValue: 0xFF06F96B, Description:
#DesignerProperty: Key: ColorEmpty, DisplayName: Color Empty, FieldType: Color, DefaultValue: 0xFF868686, Description:
#DesignerProperty: Key: StrokeWidth, DisplayName: Stroke Width, FieldType: Int, DefaultValue: 10, Description:
#DesignerProperty: Key: Duration, DisplayName: Duration From 0 To 100, FieldType: Int, DefaultValue: 3000, Description: Milliseconds

Sub Class_Globals
	Private mEventName As String 'ignore
	Private mCallBack As Object 'ignore
	Private cvs As Canvas
	
	Private mLbl As Label
	Private cx, cy, radius As Float
	Private stroke As Float
#if B4A
	Private ArcRect As JavaObject
	Private clrFull, clrEmpty As Int
	Private mBase As Panel
#else If B4J
	Private mBase As Pane
	Private fx As JFX
	Private clrFull, clrEmpty As Paint
#else If B4i
	Private clrFull, clrEmpty As Int
	Private mBase As WeakRef
#End If
	Private currentValue As Float
	Private DurationFromZeroTo100 As Int
End Sub

Public Sub Initialize (Callback As Object, EventName As String)
	mEventName = EventName
	mCallBack = Callback
End Sub

#if B4J
Public Sub DesignerCreateView (Base As Pane, Lbl As Label, Props As Map)
	mBase = Base
	Base.SetLayoutAnimated(0, Base.Left, Base.Top,  Min(Base.Width, Base.Height), Min(Base.Width, Base.Height))
#else if B4A
Public Sub DesignerCreateView (Base As Panel, Lbl As Label, Props As Map)
	mBase = Base
	Base.SetLayoutAnimated(0, Base.Left, Base.Top,  Min(Base.Width, Base.Height), Min(Base.Width, Base.Height))
#else if B4i
Public Sub DesignerCreateView (Base As Panel, Lbl As Label, Props As Map)
	mBase.Value = Base
	Base.SetLayoutAnimated(0, 0, Base.Left, Base.Top,  Min(Base.Width, Base.Height), Min(Base.Width, Base.Height))
#end if
	clrFull = Props.Get("ColorFull")
	clrEmpty = Props.Get("ColorEmpty")
	stroke = DipToCurrent(Props.Get("StrokeWidth"))
	DurationFromZeroTo100 = Props.Get("Duration")
	mLbl = Lbl
	cx = Base.Width / 2
	cy = Base.Height / 2
	radius = cx - 10dip
#if B4J
	Base.AddNode(mLbl, 0, cy - 20dip, Base.Width, 40dip)
	cvs.Initialize("")
	Base.AddNode(cvs, 0, 0, Base.Width, Base.Height)
#else if B4A
	Dim r As Rect
	r.Initialize(0, 0, Base.Width, Base.Height)
	ArcRect.InitializeNewInstance("android.graphics.RectF", Array(r))
	mLbl.Gravity = Gravity.CENTER
	Base.AddView(mLbl, 0, cy - 20dip, Base.Width, 40dip)
	cvs.Initialize(Base)
	'set antialias
	SetAntiAlias
#else if B4i
	Base.AddView(mLbl, 0, cy - 20dip, Base.Width, 40dip)
	cvs.Initialize(Base)
#End If
	DrawValue(currentValue)
End Sub

#if B4J or B4i
Private Sub Base_Resize (Width As Double, Height As Double)
	cx = Width / 2
	cy = Height / 2
	radius = cx - 10dip
	#if B4J
	GetBase.SetLayoutAnimated(0, GetBase.Left, GetBase.Top,  Min(Width,Height), Min(Width, Height))
	cvs.SetSize(Width, Height)
	mLbl.SetLayoutAnimated(0, 0, cy - 20dip, Width, 40dip)
	#else
	GetBase.SetLayoutAnimated(0, 0, GetBase.Left, GetBase.Top,  Min(Width,Height), Min(Width, Height))
	cvs.Release
	cvs.Initialize(GetBase)
	mLbl.SetLayoutAnimated(0, 0, 0, cy - 20dip, Width, 40dip)
	#end if
	DrawValue(currentValue)
End Sub
#End If

Public Sub setValue(NewValue As Float)
	AnimateValueTo(NewValue)
End Sub

Public Sub getValue As Float
	Return currentValue
End Sub

Private Sub AnimateValueTo(NewValue As Float)
	Dim n As Long = DateTime.Now
	Dim duration As Int = Abs(currentValue - NewValue) / 100 * DurationFromZeroTo100 + 1000
	Dim start As Float = currentValue
	currentValue = NewValue
	Dim tempValue As Float
	Do While DateTime.Now < n + duration
		tempValue = ValueFromTimeEaseInOut(DateTime.Now - n, start, NewValue - start, duration)
		DrawValue(tempValue)
		Sleep(10)
		If NewValue <> currentValue Then Return 'will happen if another update has started
	Loop
	DrawValue(currentValue)
End Sub

'quartic easing in/out from http://gizma.com/easing/
Private Sub ValueFromTimeEaseInOut(Time As Float, Start As Float, ChangeInValue As Float, Duration As Int) As Float
	Time = Time / (Duration / 2)
	If Time < 1 Then
		Return ChangeInValue / 2 * Time * Time * Time * Time + Start
	Else
		Time = Time - 2
		Return -ChangeInValue / 2 * (Time * Time * Time * Time - 2) + Start
	End If
End Sub

Private Sub ValueFromTimeLinear(Time As Int, Start As Float, ChangeInValue As Float, Duration As Int) As Float 'ignore
	Return ChangeInValue * Time / Duration + Start
End Sub

Private Sub DrawValue(Value As Float)
#if B4J
	cvs.ClearRect(0, 0, cvs.Width, cvs.Height)
#else if B4A or B4i
	cvs.DrawColor(Colors.Transparent)
#end if
	cvs.DrawCircle(cx, cy, radius, clrEmpty, False, stroke)
	mLbl.Text = $"$1.0{Value}"$
	Dim startAngle = -90, sweepAngle = Value / 100 * 360 As Float

	If Value < 100 Then
		ClipArcPath(startAngle, sweepAngle)
		cvs.DrawCircle(cx, cy, radius - 0.5dip, clrFull, False, stroke + 1dip)
		cvs.RemoveClip
	Else
		cvs.DrawCircle(cx, cy, radius - 0.5dip, clrFull, False, stroke + 1dip)
	End If
#if B4A
	GetBase.Invalidate
#Else If B4i
	cvs.Refresh
#End If
End Sub

#if B4J

Private Sub ClipArcPath(Start As Double, Degrees As Double)
	Start = Start + 180
	Degrees = -Degrees
	Dim gc As JavaObject = cvs
	gc = gc.RunMethod("getGraphicsContext2D", Null)
	gc.RunMethod("save", Null)
	gc.RunMethod("beginPath", Null)
	Dim x = cx, y = cy, r = radius + stroke * 2 As Double
	gc.RunMethod("moveTo", Array(x, y))
	gc.RunMethod("arc", Array(x, y, r, r, Start, Degrees))
	gc.RunMethod("closePath", Null)
	gc.RunMethod("clip", Null)
End Sub

Public Sub GetBase As Pane
	Return mBase
End Sub

#else if B4A
Private Sub ClipArcPath(Start As Float, Degrees As Float)
	Dim p As Path
	p.Initialize(cx, cy)
	Dim jo As JavaObject = p
	jo.RunMethod("arcTo", Array(ArcRect, Start, Degrees))
	cvs.ClipPath(p)
End Sub

Public Sub GetBase As Panel
	Return mBase
End Sub

Private Sub SetAntiAlias
	Dim Obj1 As Reflector
	Obj1.Target = cvs
	Obj1.Target = Obj1.GetField("paint")
	Obj1.RunMethod2("setAntiAlias", True, "java.lang.boolean")
End Sub
#else if B4i
Private Sub ClipArcPath(Start As Float, Degrees As Float)
	Dim p As Path
	p.Initialize(cx, cy)
	Dim no As NativeObject = p
	no.RunMethod("addArcWithCenter:radius:startAngle:endAngle:clockwise:", Array(no.MakePoint(cx, cy), _
		radius + 100dip, Start * cPI / 180, (Degrees - 90) * cPI / 180, True))
	cvs.ClipPath(p)
End Sub

Public Sub GetBase As Panel
	Return mBase.Value
End Sub

#end if

