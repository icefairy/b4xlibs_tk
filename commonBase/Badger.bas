Type=Class
Version=7.01
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'v1.00
Sub Class_Globals
	Private views As Map
	Private stub As Button 'ignore
	Private color As Int = Colors.Red
	Private textColor As Int = Colors.White
	Private radius As Int = 15dip
	Private animationDuration As Int = 500
End Sub

Public Sub Initialize
	views.Initialize
End Sub

Public Sub SetBadge(view As View, Badge As Int)
	If views.ContainsKey(view) Then
		If Badge = 0 Then
			RemoveBadge(view)
		Else
			ReplaceLabel(view, Badge)
		End If
	Else
		If Badge > 0 Then
			CreateNewBadge(view, Badge)
		End If
	End If
End Sub

Private Sub RemoveBadge(view As View)
	Dim pnl As Panel = views.Get(view)
	views.Remove(view)
	pnl.SetLayoutAnimated(animationDuration, pnl.Left + pnl.Width / 2, pnl.Top + pnl.Height / 2, 1dip, 1dip)
	Sleep(animationDuration)
	pnl.RemoveView
End Sub

Private Sub ReplaceLabel(view As View, Badge As Int)
	Dim pnl As Panel = views.Get(view)
	Dim lbl As Label = pnl.GetView(pnl.NumberOfViews - 1)
	lbl.SetLayoutAnimated(animationDuration, pnl.Width, 0, radius * 2, radius * 2)
	CreateLabel(pnl, Badge)
	Sleep(animationDuration)
	lbl.RemoveView
End Sub

Public Sub GetBadge(view As View) As Int
	If views.ContainsKey(view) Then
		Dim p As Panel = views.Get(view)
		Dim lbl As Label = p.GetView(p.NumberOfViews - 1)
		Return lbl.Text
	Else
		Return 0
	End If
End Sub

Private Sub CreateNewBadge(view As View, count As Int)
	Dim p As Panel
	p.Initialize("")
	Dim cd As ColorDrawable
	cd.Initialize2(color, 100dip, 0, 0)
	p.Background = cd
	Dim parent As Panel = view.Parent
	Dim right As Int = view.Left + view.Width
	Dim top As Int = view.Top
	parent.AddView(p, right, top, 0, 0)
	p.SetElevationAnimated(animationDuration, 8dip)
	CreateLabel(p, count)
	p.SetLayoutAnimated(animationDuration, right - radius, top - radius, radius * 2, radius * 2)
	views.Put(view, p)
End Sub

Private Sub CreateLabel(p As Panel, count As Int)
	Dim lbl As Label
	lbl.Initialize("")
	SetLabelText(lbl, count)
	p.AddView(lbl, radius, radius, 0, 0)
	lbl.Gravity = Gravity.CENTER
	lbl.SetLayoutAnimated(animationDuration, 0, 0, radius * 2, radius * 2)
End Sub

Private Sub SetLabelText(lbl As Label, count As Int)
	Dim cs As CSBuilder
	lbl.Text = cs.Initialize.Color(textColor).Bold.Size(16).Append(count).PopAll
End Sub