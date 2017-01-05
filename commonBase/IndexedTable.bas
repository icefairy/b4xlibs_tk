Type=Class
Version=5.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
#Event: ItemClick (Position As Int, Value As Object)
Sub Class_Globals
	Public tv As ListView
	Private pnlIndex As Panel
	Private mTarget As Object
	Private mEventName As String
	Private hoverLabel As Label
	Private const pnlIndexWidth As Float = 40dip
	Private CharsMap As Map
End Sub

Public Sub Initialize (vCallback As Object, vEventName As String)
	mTarget = vCallback
	mEventName = vEventName
	tv.Initialize("tv")
	pnlIndex.Initialize("pnlIndex")
	hoverLabel.Initialize("")
	Dim cd As ColorDrawable
	cd.Initialize2(Colors.White, 2dip, 2dip, Colors.Black)
	hoverLabel.Background = cd
	hoverLabel.Visible = False
	hoverLabel.Gravity = Gravity.CENTER
	hoverLabel.TextSize = 17
End Sub

Public Sub DesignerCreateView(base As Panel, lbl As Label, props As Map)
	
	base.AddView(tv, 0, 0, base.Width - pnlIndexWidth, base.Height)
	base.AddView(hoverLabel, base.Width - 100dip, 0, 40dip, 40dip)
	base.AddView(pnlIndex, base.Width - pnlIndexWidth, 0, pnlIndexWidth, base.Height)
	Dim lblHeight As Float = (pnlIndex.Height - 2dip) / 26
	For i = 0 To 26 - 1
		Dim lbl As Label
		lbl.Initialize("lbl")
		lbl.Text = Chr(Asc("A") +i)
		lbl.TextColor = Colors.Blue
		lbl.Gravity = Gravity.CENTER
		pnlIndex.AddView(lbl, 0, 2dip + i * lblHeight, pnlIndexWidth, 20dip)
	Next
	base.Color = Colors.Transparent
	
End Sub

Private Sub pnlIndex_Touch(Action As Int, X As Float, Y As Float)
	Dim item As Int = Y / pnlIndex.Height * pnlIndex.NumberOfViews
	item = Min(item, pnlIndex.NumberOfViews - 1)
	Dim lbl As Label = pnlIndex.GetView(item)
	If Action = pnlIndex.ACTION_UP Then
		hoverLabel.Visible = False
		If CharsMap.IsInitialized = False Then BuildIndex
		Dim charToLookFor As String = lbl.Text
		Do While Asc(charToLookFor) <= Asc("Z")
			If CharsMap.ContainsKey(charToLookFor) Then
				tv.SetSelection(CharsMap.Get(charToLookFor))
				Exit
			End If
			charToLookFor = Chr(Asc(charToLookFor) + 1)
		Loop
	Else
		hoverLabel.Visible = True
		hoverLabel.Top = lbl.Top - 15dip
		hoverLabel.Text = lbl.Text
	End If
End Sub

Private Sub BuildIndex
	CharsMap.Initialize
	Dim lastAddedChar As String
	For index = 0 To tv.Size - 1
		Dim raw As String = tv.GetItem(index)
		Dim firstLetter As String = raw.CharAt(0)
		firstLetter = firstLetter.ToUpperCase
		If firstLetter <> lastAddedChar Then
			lastAddedChar = firstLetter
			CharsMap.Put(lastAddedChar, index)
		End If
	Next
End Sub

Private Sub tv_ItemClick (Position As Int, Value As Object)
	CallSub3(mTarget, mEventName & "_ItemClick", Position, Value)
End Sub
