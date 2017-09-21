Type=Class
Version=7.01
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'version: 1.76 - modified version
#Event: ItemClick (Index As Int, Value As Object)
#Event: ReachEnd
#DesignerProperty: Key: DividerColor, DisplayName: Divider Color, FieldType: Color, DefaultValue: 0xFFD9D7DE
#DesignerProperty: Key: DividerHeight, DisplayName: Divider Height, FieldType: Int, DefaultValue: 2
#DesignerProperty: Key: PressedColor, DisplayName: Pressed Color, FieldType: Color, DefaultValue: 0xFF7EB4FA
#DesignerProperty: Key: InsertAnimationDuration, DisplayName: Insert Animation Duration, FieldType: Int, DefaultValue: 300
Sub Class_Globals
	Public sv As ScrollView
	Private items As List
	Private panels As List
	Private heights As List
	Private dividerHeight As Float
	Private EventName As String
	Private CallBack As Object
	Private su As StringUtils
	Public DefaultTextSize As Int
	Public DefaultTextColor As Int
	Public DefaultTextBackgroundColor As Int
	Private DefaultTextBackground As Object
	Private PressedDrawable As ColorDrawable
	Public AnimationDuration As Int = 300
	Private LastReachEndEvent As Long
End Sub


Public Sub Initialize (vCallback As Object, vEventName As String)
	EventName = vEventName
	CallBack = vCallback
	sv.Initialize2(0, "sv")
	items.Initialize
	panels.Initialize
	heights.Initialize
	'these defaults will be used when the view is added by code
	dividerHeight = 2dip
	sv.Color = 0xFFD9D7DE
	DefaultTextColor = Colors.White
	DefaultTextSize = 16
	DefaultTextBackgroundColor = Colors.Black
	DefaultTextBackground = Null
	PressedDrawable.Initialize(0xFF7EB4FA, 2dip)
End Sub

'Returns a view object that holds the list.
Public Sub AsView As View
	Return sv
End Sub

Private Sub sv_ScrollChanged(Position As Int)
	If Position + sv.Height >= sv.Panel.Height - 5dip And DateTime.Now > LastReachEndEvent + 100 Then
		If SubExists(CallBack, EventName & "_ReachEnd") Then
			LastReachEndEvent = DateTime.Now
			CallSubDelayed(CallBack, EventName & "_ReachEnd")
		Else
			LastReachEndEvent = DateTime.Now + 1000 * DateTime.TicksPerDay 'disable
		End If
	End If
End Sub
Public Sub DesignerCreateView(base As Panel, lbl As Label, props As Map)
	ReplaceBasePanelWithView(base, sv)
	sv.Color = props.Get("DividerColor")
	dividerHeight = DipToCurrent(props.Get("DividerHeight")) 'need to scale the value
	PressedDrawable.Initialize(props.Get("PressedColor"), 2dip)
	AnimationDuration = props.GetDefault("InsertAnimationDuration", AnimationDuration)
	DefaultTextSize = lbl.TextSize
	DefaultTextColor = lbl.TextColor
	DefaultTextBackground = base.Background
End Sub

Private Sub ReplaceBasePanelWithView(base As Panel, view As View)
	Dim parent As Panel = base.Parent
	parent.AddView(view, base.Left, base.Top, base.Width, base.Height)
	base.RemoveView
End Sub


'Clears all items.
Public Sub Clear
	items.Clear
	panels.Clear
	heights.Clear
	sv.Panel.Height = 0
	For i = sv.Panel.NumberOfViews - 1 To 0 Step -1
		sv.Panel.RemoveViewAt(i)
	Next
End Sub

'Smoothly scrolls the list to the specified item.
Public Sub ScrollToItem(Index As Int)
	sv.ScrollPosition = FindItemTop(Index)	
End Sub
Private Sub FindItemTop(Index As Int) As Int
	Dim top As Int
	For i = 0 To Min(Index - 1, items.Size - 1)
		top = top + heights.Get(i) + dividerHeight
	Next
	Return top
End Sub
'Gets the index of the first visible item.
Public Sub getFirstVisibleIndex As Int
	Dim bottom As Int
	For i = 0 To items.Size - 1
		bottom = bottom + heights.Get(i) + dividerHeight
		If bottom > sv.ScrollPosition Then Return i		
	Next
	Return items.Size - 1
End Sub

'Gets the index of the last visible item.
Public Sub getLastVisibleIndex As Int
	Dim first As Int = getFirstVisibleIndex
	Dim bottom As Int
	For i = 0 To items.Size - 1
		bottom = bottom + heights.Get(i) + dividerHeight
		If i >= first And bottom >= sv.ScrollPosition  + sv.Height Then Return Max(i - 1, first)
	Next
	Return items.Size - 1
End Sub


'Returns the number of items.
Public Sub GetSize As Int
	Return items.Size
End Sub

'Returns the Panel stored at the specified index.
Public Sub GetPanel(Index As Int) As Panel
	Dim p As Panel
	p = panels.Get(Index) 'this is the parent panel
	Return p.GetView(0)
End Sub

'Returns the value stored at the specified index.
Public Sub GetValue(Index As Int) As Object
	Return items.Get(Index)
End Sub

'Removes the item at the specified index.
Public Sub RemoveAt(Index As Int)
	Dim removePanel, p As Panel
	removePanel = panels.Get(Index)
	For i = Index + 1 To items.Size - 1
		p = panels.Get(i)
		p.Tag = i - 1
		Dim NewTop As Int = p.Top - heights.Get(Index) - dividerHeight
		p.top = NewTop
	Next
	sv.Panel.Height = sv.Panel.Height - heights.Get(Index) - dividerHeight
	items.RemoveAt(Index)
	panels.RemoveAt(Index)
	heights.RemoveAt(Index)
	removePanel.RemoveView
End Sub



'Adds a text item. The item height will be adjusted based on the text.
Public Sub AddTextItem(Text As Object, Value As Object)
	InsertAtTextItem(items.Size, Text, Value)
End Sub

'Inserts a text item at the specified index.
Public Sub InsertAtTextItem(Index As Int, Text As Object, Value As Object)
	Dim pnl As Panel
	pnl.Initialize("")
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Gravity = Bit.Or(Gravity.CENTER_VERTICAL, Gravity.LEFT)
	pnl.AddView(lbl, 5dip, 2dip, sv.Width - 5dip, 20dip)
	lbl.Text = Text
	lbl.TextSize = DefaultTextSize
	lbl.TextColor = DefaultTextColor
	If DefaultTextBackground <> Null Then
		pnl.Background = DefaultTextBackground
	Else
		pnl.Color = DefaultTextBackgroundColor
	End If
	Dim minHeight As Int = su.MeasureMultilineTextHeight(lbl, Text)
	lbl.Height = Max(50dip, minHeight)
	InsertAt(Index, pnl, lbl.Height + 2dip, Value)
End Sub

'Changes the height of an existing item.
Public Sub ResizeItem(Index As Int, ItemHeight As Int)
	Dim p As Panel = GetPanel(Index)
	Dim value As Object = items.Get(Index)
	Dim parent As Panel = p.Parent
	p.Background = parent.Background
	p.RemoveView
	ReplaceAt(Index, p, ItemHeight, value)
End Sub


'Replaces the item at the specified index with a new item.
Public Sub ReplaceAt(Index As Int, pnl As Panel, ItemHeight As Int, Value As Object)
	Dim removePanel As Panel = panels.Get(Index)
	Dim height As Int = heights.Get(Index)
	items.RemoveAt(Index)
	panels.RemoveAt(Index)
	heights.RemoveAt(Index)
	removePanel.RemoveView
	InsertAtImpl(Index, pnl, ItemHeight, Value, height)
End Sub

'Adds a custom item at the specified index.
Public Sub InsertAt(Index As Int, pnl As Panel, ItemHeight As Int, Value As Object)
	InsertAtImpl(Index, pnl, ItemHeight, Value, 0)
End Sub

	
Private Sub InsertAtImpl(Index As Int, Pnl As Panel, ItemHeight As Int, Value As Object, InitialHeight As Int)
	Dim sd As StateListDrawable
	If Not(Pnl.Background Is StateListDrawable) Then
		sd.Initialize
		sd.AddState(sd.State_Pressed, PressedDrawable)
		sd.AddCatchAllState(Pnl.Background)
	Else
		sd = Pnl.Background
	End If
	
	'create another panel to handle the click event
	Dim p As Panel
	p.Initialize("panel")
	p.Background = sd
	Dim cd As ColorDrawable
	cd.Initialize(Colors.Transparent, 0)
	Pnl.Background = cd
	p.AddView(Pnl, 0, 0, sv.Width, ItemHeight)
	p.Tag = Index
	Dim IncludeDividierHeight As Int
	If InitialHeight = 0 Then IncludeDividierHeight = dividerHeight Else IncludeDividierHeight = 0
	
	If Index = items.Size And InitialHeight = 0 Then
		items.Add(Value)
		panels.Add(p)
		heights.Add(ItemHeight)
		Dim top As Int
		If Index = 0 Then top = dividerHeight Else top = sv.Panel.Height
		sv.Panel.AddView(p, 0, top, sv.Width, ItemHeight)
	Else
		Dim top As Int
		If Index = 0 Then
			top = dividerHeight
		Else
			Dim previousPanel As Panel = panels.Get(Index - 1)
			top = previousPanel.top + heights.Get(Index - 1) + dividerHeight
		End If
		Dim p2 As Panel
		For i = Index To panels.Size - 1
			p2 = panels.Get(i)
			Dim NewTop As Int = p2.top + ItemHeight - InitialHeight + IncludeDividierHeight
			If  Min(NewTop, p2.Top) - sv.ScrollPosition < sv.Height Then
				p2.SetLayoutAnimated(AnimationDuration, 0, NewTop, p2.Width, heights.Get(i))
			Else
				p2.top = NewTop
			End If
			p2.Tag = i + 1
		Next
		items.InsertAt(Index, Value)
		panels.InsertAt(Index, p)
		heights.InsertAt(Index, ItemHeight)
		Dim ShouldSetPanelHeight As Boolean
		If InitialHeight > ItemHeight Then
			sv.Panel.AddView(p, 0, top, sv.Width, InitialHeight)
			Pnl.Height = InitialHeight
			ShouldSetPanelHeight = True
		Else
			sv.Panel.AddView(p, 0, top, sv.Width, ItemHeight)
			
		End If
		p.SendToBack
	End If
	Dim NewSvHeight As Int = sv.Panel.Height + ItemHeight - InitialHeight + IncludeDividierHeight
	sv.Panel.Height = NewSvHeight
	If items.Size = 1 Then sv.Panel.Height = sv.Panel.Height + IncludeDividierHeight
	If ShouldSetPanelHeight Then
		Sleep(AnimationDuration)
		If p.Parent <> Null Then
			'this can happen if the user clicks on the item while it is being animated
			p.Height = ItemHeight
			Pnl.Height = ItemHeight
		End If
	End If
End Sub


'Adds a custom item.
Public Sub Add(Pnl As Panel, ItemHeight As Int, Value As Object)
	InsertAt(items.Size, Pnl, ItemHeight, Value)
End Sub

'Scrolls the list to the specified item.
Public Sub JumpToItem(Index As Int)
	Dim top As Int
	For i = 0 To Min(Index - 1, items.Size - 1)
		top = top + heights.Get(i) + dividerHeight
	Next
	sv.ScrollToNow(top)
End Sub

Private Sub Panel_Click
	If SubExists(CallBack, EventName & "_ItemClick") Then
		Dim v As View
		v = Sender
		CallSub3(CallBack, EventName & "_ItemClick", v.Tag, items.Get(v.Tag))
	End If
End Sub

'Returns the index of the item that holds the given view.
Public Sub GetItemFromView(v As View) As Int
	Dim parent = v As Object, current As View
	Do While (parent Is Panel) = False Or sv.Panel <> parent
		current = parent
		parent = current.Parent
	Loop
	v = current
	Return v.Tag
End Sub
