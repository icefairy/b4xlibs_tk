Type=Class
Version=3.5
@EndOfDesignText@
'Class module
#Event: CheckedChange (Checked As Boolean)
#RaisesSynchronousEvents: setChecked
#RaisesSynchronousEvents: Checked
Sub Class_Globals
	Private EventName As String
	Private CallBack As Object
	Public Switch As View
	Private joSwitch As JavaObject
End Sub

Public Sub Initialize (vCallback As Object, vEventName As String)
	EventName = vEventName
	CallBack = vCallback
	Switch = createSwitch
	joSwitch = Switch
End Sub

Private Sub createSwitch As View
	Dim so, cbo, ctxt As JavaObject
	ctxt = Me	
	ctxt = ctxt.RunMethodJO("getBA", Null)
	so.InitializeNewInstance("android.widget.Switch", Array As Object(ctxt.GetField("activity")))
	cbo.InitializeNewInstance("anywheresoftware.b4a.objects.CompoundButtonWrapper", Null)
	cbo.RunMethod("setObject", Array As Object(so))
	cbo.RunMethod("innerInitialize", Array As Object(ctxt, "switch", True))
	Return so
End Sub

Public Sub DesignerCreateView(base As Panel, lbl As Label, props As Map)
	Dim jo As JavaObject = base
	Dim parent As Panel = jo.RunMethod("getParent", Null)
	parent.AddView(Switch, base.Left, base.Top, base.Width, base.Height)
	base.RemoveView
	Switch.Tag = base.Tag
End Sub

Sub switch_CheckedChange(Checked As Boolean)
	CallSub2(CallBack, EventName & "_CheckedChange", Checked)
End Sub

Public Sub getChecked As Boolean
	Return joSwitch.RunMethod("isChecked", Null)
End Sub

Public Sub setChecked(b As Boolean)
	joSwitch.RunMethod("setChecked", Array As Object(b))
End Sub
'Gets or sets the "on" text.
Public Sub getTextOn As String
	Return joSwitch.RunMethod("getTextOn", Null)
End Sub
Public Sub setTextOn(s As String)
	joSwitch.RunMethod("setTextOn", Array As Object(s))
End Sub
'Gets or sets the "off" text.
Public Sub getTextOff As String
	Return joSwitch.RunMethod("getTextOff", Null)
End Sub
Public Sub setTextOff(s As String)
	joSwitch.RunMethod("setTextOff", Array As Object(s))
End Sub



