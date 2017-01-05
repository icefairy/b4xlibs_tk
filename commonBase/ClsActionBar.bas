Type=Class
Version=2.22
@EndOfDesignText@
'Class module
'Version 1.43
Sub Class_Globals
	Public Title As Label

	Private ActionBar As Panel
	Private abParent As Panel
	Private abDarkTheme As Boolean
	Private abLeftStack As List
	Private abRightStack As List
	Private abModule As Object
	Private abCanvas As Canvas
	Private abDividerWidth As Byte
	Private abSameWidthForAll As Int
	Private abIconAsWideAsText As Boolean

	' Drawables
	Private abPressedDrawable As Object
	Private abSelectedDrawable As Object
	Private abDefaultDividerDrawable As Object
	Private abDividerDrawable As Object

	' Drag&Drop
	Private abStartX As Int
	Private abPlaceHolder As Panel
	Private abDraggedBtn As View
	Private abViewToBlock As Object
	Private abOnAfterDropSub As String

	Type typAction(Module As Object, OnClickSub As String, OnLongClickSub As String, Tag As Object)
End Sub

'Initializes the action bar
'Parent = activity or panel holding the action bar
'TopMost = if True, the action bar is placed at the very top of its parent; if False, it is placed at the very bottom
'DarkTheme = if True, the action bar has a dark background and bright texts; if False, it has a bright background and dark texts
'Module = Me
Public Sub Initialize(Parent As Panel, TopMost As Boolean, DarkTheme As Boolean, Height As Int, Module As Object)
	Dim pnl As Panel
	pnl = Parent
	If Not(pnl.IsInitialized) Then
		Log("'Parent' must be the current activity or an initialized panel")
		Return
	End If
	abParent = Parent

	ActionBar.Initialize("")
	Dim w, h As Int
	w = pnl.Width
	h = pnl.Height
	Dim r As Reflector
	r.Target = pnl
	If w = -1 Then w = r.RunMethod("getWidth")
	If h = -1 Then h =  r.RunMethod("getHeight")
	If TopMost Then
		pnl.AddView(ActionBar, 0, 0, w, Height)
	Else
		pnl.AddView(ActionBar, 0, h - Height, w, Height)
	End If

	Title.Initialize("")
	If DarkTheme Then
		ActionBar.Background = LoadDrawable("dark_header")
		Title.TextColor = Colors.White
		abDefaultDividerDrawable = LoadDrawable("divider_vertical_dark")
	Else
		ActionBar.Background = LoadDrawable("light_header")
		Title.TextColor = Colors.Black
		abDefaultDividerDrawable = LoadDrawable("divider_vertical_bright")
	End If
	abDarkTheme = DarkTheme
	Title.Gravity = Gravity.LEFT + Gravity.CENTER_VERTICAL
	Title.Typeface = Typeface.DEFAULT_BOLD
	ActionBar.AddView(Title, 0, 0, ActionBar.Width, Height)

	abLeftStack.Initialize
	abRightStack.Initialize
	abModule = Module
	abDividerWidth = 0
	abSameWidthForAll = 0
	abIconAsWideAsText = False
	abPressedDrawable = LoadDrawable("list_selector_background_pressed")
	abSelectedDrawable = LoadDrawable("list_selector_background_focus")
	abDividerDrawable = Null
End Sub

'Gets a drawable from the Android system resources
Public Sub LoadDrawable(Name As String) As Object
	Dim r As Reflector
	r.Target = r.GetContext
	r.Target = r.RunMethod("getResources")
	r.Target = r.RunMethod("getSystem")
	Dim ID_Drawable As Int
	ID_Drawable = r.RunMethod4("getIdentifier", Array As Object(Name, "drawable", "android"), _
	                                            Array As String("java.lang.String", "java.lang.String", "java.lang.String"))
	r.Target = r.GetContext
	r.Target = r.RunMethod("getResources")
	Return r.RunMethod2("getDrawable", ID_Drawable, "java.lang.int")
End Sub

Private Sub ReorderViews
	' We reorder the views from the left to the right
	Dim v As View, Left As Int
	For i = 0 To abLeftStack.Size - 1
		v = abLeftStack.Get(i)
		v.Left = Left
		Left = Left + v.Width
	Next

	' We reorder the views from the right to the left
	Left = ActionBar.Width
	For i = 0 To abRightStack.Size - 1
		v = abRightStack.Get(i)
		v.Left = Left - v.Width
		Left = Left - v.Width
	Next
End Sub

Private Sub ResizeButton(ivIcon As ImageView, lblText As Label, TextPosition As Byte, RightStack As Boolean, ForceWidth As Int) As Int
	Dim Left, IconSize As Int
	If RightStack Then Left = abDividerWidth
	If ivIcon.IsInitialized Then IconSize = ActionBar.Height
	ForceWidth = ForceWidth - abDividerWidth

	Dim TextWidth, TextHeight As Int
	If lblText.Text <> "" Then
		abCanvas.Initialize(ActionBar)
		TextWidth = abCanvas.MeasureStringWidth(";" & lblText.Text & ";", lblText.Typeface, lblText.TextSize)
		TextHeight = abCanvas.MeasureStringHeight(lblText.Text & "y_Î", lblText.Typeface, lblText.TextSize) * 1.3
	End If
	If TextPosition < 3 AND ivIcon.IsInitialized Then 'Icon reduction
		IconSize = ActionBar.Height - TextHeight
	End If
	If TextPosition < 6 Then
		If TextWidth < IconSize Then TextWidth = IconSize 'Text smaller than icon
		If ForceWidth > 0 Then
			TextWidth = ForceWidth
			IconSize = Min(IconSize, ForceWidth)
		End If
	Else
		If ForceWidth > 0 Then
			TextWidth = ForceWidth - IconSize
			If TextWidth < 0 Then
				IconSize = IconSize + TextWidth
				TextWidth = 0
			End If
		End If
	End If
	Select TextPosition
		Case 1, 3 'at the very top (icon is reduced) / over the icon top
			lblText.SetLayout(Left, 0, TextWidth, TextHeight)
		Case 2, 4 'at the very bottom (icon is reduced) / over the icon bottom
			lblText.SetLayout(Left, ActionBar.Height - TextHeight, TextWidth, TextHeight)
		Case 5, 6 'centered / on the left
			lblText.SetLayout(Left, (ActionBar.Height - TextHeight) / 2, TextWidth, TextHeight)
		Case 7 'on the right
			lblText.SetLayout(Left + IconSize, (ActionBar.Height - TextHeight) / 2, TextWidth, TextHeight)
	End Select

	If ivIcon.IsInitialized Then
		Dim IconWidth As Int
		If TextPosition < 6 AND abIconAsWideAsText AND TextWidth > 0 Then
			IconWidth = TextWidth
		Else
			IconWidth = IconSize
		End If
		Select TextPosition
			Case 1
				ivIcon.SetLayout(Left + Floor((TextWidth - IconWidth) / 2), TextHeight, IconWidth, IconSize)
			Case 6
				ivIcon.SetLayout(Left + TextWidth, 0,IconWidth, IconSize)
			Case 7
				ivIcon.SetLayout(Left, 0, IconWidth, IconSize)
			Case Else
				ivIcon.SetLayout(Left + Floor((TextWidth - IconWidth) / 2), 0, IconWidth, IconSize)
		End Select
	End If

	If TextPosition < 6 Then
		Return Max(TextWidth, IconSize) + abDividerWidth
	Else
		Return TextWidth + IconSize + abDividerWidth
	End If
End Sub

Private Sub UpdateBackground(pnlBtn As Panel, RightStack As Boolean)
	abCanvas.Initialize(pnlBtn)
	abCanvas.DrawColor(Colors.Transparent)
	If abDividerWidth > 0 Then 
		Dim divDrawable As Object
		If abDividerDrawable = Null Then
			divDrawable = abDefaultDividerDrawable
		Else
			divDrawable = abDividerDrawable
		End If
		Dim divRect As Rect
		If RightStack Then
			divRect.Initialize(0, 0, abDividerWidth, pnlBtn.Height)
		Else
			divRect.Initialize(pnlBtn.Width - abDividerWidth, 0, pnlBtn.Width, pnlBtn.Height)
		End If
		abCanvas.DrawDrawable(divDrawable, divRect)
	End If

	Dim sd As StateListDrawable
	sd.Initialize
	sd.AddState(sd.State_Pressed, abPressedDrawable)
	sd.AddState(sd.State_Selected, abSelectedDrawable)
	sd.AddCatchAllState(pnlBtn.Background)
	pnlBtn.Background = sd
End Sub

'Adds a button to the action bar (its width is automatically computed)
'Icon = optional bitmap or drawable (if Null, Text must be set)
'Text = optional text (if "", Icon must be set)
'TextPosition:
' 1 = at the very top (icon is reduced)
' 2 = at the very bottom (icon is reduced)
' 3 = over the icon top
' 4 = over the icon bottom
' 5 = centered
' 6 = on the left
' 7 = on the right
'ButtonPosition = position in the action bar, starting from the left if positive (1 = leftmost position) or from the right if negative (-1 = rightmost position)
'OnClickSub = name of the sub to call in your module when the button is pressed
'OnLongClickSub = name of the sub to call in your module after a long click
'Returns the new button
Public Sub AddButton(Icon As Object, Text As String, TextPosition As Byte, ButtonPosition As Short, OnClickSub As String, OnLongClickSub As String) As View
	If Icon = Null AND Text = "" Then
		Log("Icon and Text are both null")
		Return Null
	End If
	If TextPosition < 1 OR TextPosition > 7 Then
		Log("Invalid TextPosition")
		Return Null
	End If

	Dim pnl As Panel
	pnl.Initialize("Button")

	Dim IV As ImageView
	If Icon <> Null Then
		IV.Initialize("")
		If Icon Is Bitmap Then
			IV.Bitmap = Icon
			IV.Gravity = Gravity.FILL
		Else
			IV.Background = Icon
		End If
		pnl.AddView(IV, 0, 0, 0, 0)
	End If

	Dim lbl As Label
	lbl.Initialize("")
	lbl.Gravity = Gravity.CENTER_HORIZONTAL + Gravity.CENTER_VERTICAL
	lbl.Text = Text
	If abDarkTheme Then
		lbl.TextColor = Colors.White
	Else
		lbl.TextColor = Colors.Black
	End If
	lbl.TextSize = Round(ActionBar.Height / Density / 2.8)
	lbl.Typeface = Typeface.DEFAULT_BOLD
	If ButtonPosition < 0 Then
		lbl.Tag = -TextPosition
	Else
		lbl.Tag = TextPosition
	End If
	pnl.AddView(lbl, 0, 0, 0, 0)

	ActionBar.AddView(pnl, 0, 0, ResizeButton(IV, lbl, TextPosition, ButtonPosition < 0, abSameWidthForAll), ActionBar.Height)
	UpdateBackground(pnl, ButtonPosition < 0)

	If ButtonPosition < 0 Then
		abRightStack.InsertAt(Abs(ButtonPosition) - 1, pnl)
	Else If ButtonPosition > 0 Then
		abLeftStack.InsertAt(ButtonPosition - 1, pnl)
	Else
		abLeftStack.Add(pnl)
	End If
	If abSameWidthForAll > 0 Then
		SameWidthForAll(True)
	Else
		ReorderViews
	End If

	Dim Action As typAction
	Action.Initialize
	Action.Module = abModule
	Action.OnClickSub = OnClickSub
	Action.OnLongClickSub = OnLongClickSub
	pnl.Tag = Action
	Dim r As Reflector
	r.Target = pnl
	r.SetOnTouchListener("Btn_Touch")
	If OnLongClickSub = "" Then r.SetOnLongClickListener("")
	Return pnl
End Sub

'Replaces icon of the given button
'Icon = bitmap or drawable
'You can set Icon to Null to remove the icon.
Public Sub ReplaceIcon(Btn As View, Icon As Object)
	Dim pnl As Panel, v As View, IV As ImageView, lbl As Label
	pnl = Btn
	For i = 0 To pnl.NumberOfViews - 1
		v = pnl.GetView(i)
		If v Is ImageView Then IV = v
		If v Is Label Then lbl = v
	Next
	If IV.IsInitialized Then
		If Icon = Null Then
			IV.RemoveView
			IV = Null
		End If
	Else If Icon <> Null Then
		IV.Initialize("")
		pnl.AddView(IV, 0, 0, 0, 0)
	End If
	If Icon <> Null Then
		If Icon Is Bitmap Then
			IV.Bitmap = Icon
			IV.Gravity = Gravity.FILL
		Else
			IV.Background = Icon
		End If
	End If
	pnl.Width = ResizeButton(IV, lbl, Abs(lbl.Tag), lbl.Tag < 0, abSameWidthForAll)
	UpdateBackground(pnl, lbl.Tag < 0)
	ReorderViews
End Sub

'Replaces the drawable for the pressed state
'Drawable = a valid bitmap or drawable
Public Sub ReplacePressedDrawable(Drawable As Object)
	If Drawable <> Null Then
		If Drawable Is Bitmap Then
			Dim bd As BitmapDrawable
			bd.Initialize(Drawable)
			Drawable = bd
		End If
	End If
	abPressedDrawable = Drawable
End Sub

'Replaces the drawable for dividers
'Drawable = a valid bitmap or drawable
Public Sub ReplaceDividerDrawable(Drawable As Object)
	If Drawable <> Null Then
		If Drawable Is Bitmap Then
			Dim bd As BitmapDrawable
			bd.Initialize(Drawable)
			Drawable = bd
		End If
	End If
	abDividerDrawable = Drawable
	Invalidate
End Sub

'Sets text of the given button
'You can set TextColor and TextSize to -1 to left them unchanged
Public Sub SetText(Btn As View, Text As String, TextColor As Int, TextSize As Int)
	Dim pnl As Panel, v As View, IV As ImageView, lbl As Label
	pnl = Btn
	For i = 0 To pnl.NumberOfViews - 1
		v = pnl.GetView(i)
		If v Is ImageView Then IV = v
		If v Is Label Then lbl = v
	Next
	lbl.Text = Text
	If TextColor <> -1 Then lbl.TextColor = TextColor
	If TextSize <> -1 Then lbl.TextSize = TextSize
	pnl.Width = ResizeButton(IV, lbl, Abs(lbl.Tag), lbl.Tag < 0, abSameWidthForAll)
	UpdateBackground(pnl, lbl.Tag < 0)
	ReorderViews
End Sub

'Sets the divider width
Public Sub SetDividerWidth(NewWidth As Byte)
	abDividerWidth = NewWidth
	Invalidate
End Sub

'Redraws the action bar
'You must call this function if you change the action bar width (all buttons will be resized accordingly).
Public Sub Invalidate
	Dim pnl As Panel
	For P = 0 To ActionBar.NumberOfViews - 1
		If ActionBar.GetView(P) Is Panel Then
			pnl = ActionBar.GetView(P)
			Dim v As View, IV As ImageView, lbl As Label
			For i = 0 To pnl.NumberOfViews - 1
				v = pnl.GetView(i)
				If v Is ImageView Then IV = v
				If v Is Label Then lbl = v
			Next
			pnl.Width = ResizeButton(IV, lbl, Abs(lbl.Tag), lbl.Tag < 0, abSameWidthForAll)
			UpdateBackground(pnl, lbl.Tag < 0)
		End If
	Next
	ReorderViews
End Sub

Private Sub LeftPosition(Btn As Panel) As Int
	For i = 0 To abLeftStack.Size - 1
		If abLeftStack.Get(i) = Btn Then Return i
	Next
	Return -1
End Sub

'Returns the button position in the left stack
'0 = not found
Public Sub getLeftPosition(Btn As View) As Int
	Return LeftPosition(Btn) + 1
End Sub

Private Sub RightPosition(Btn As Panel) As Int
	For i = 0 To abRightStack.Size - 1
		If abRightStack.Get(i) = Btn Then Return i
	Next
	Return -1
End Sub

'Returns the button position in the right stack
'0 = not found
Public Sub getRightPosition(Btn As View) As Int
	Return -(RightPosition(Btn) + 1)
End Sub

#Region Drag&Drop
'Starts a drag&drop operation
'Btn = the button to move
'ViewToBlock = if your button is in a scrollable container (ScrollView, AHViewPager, etc.), set ViewToBlock to this container to prevents it from intercepting the Touch events
'OnAfterDropSub = name of the sub handling the AfterDrop event
'This function should be called after a long click event.
Public Sub StartDragAndDrop(Btn As View, ViewToBlock As Object, OnAfterDropSub As String)
	If Not(abPlaceHolder.IsInitialized) Then
		abDraggedBtn = Btn
		abViewToBlock = ViewToBlock
		abOnAfterDropSub = OnAfterDropSub

		' The placeholder panel replaces the button to drag in the stack
		abPlaceHolder.Initialize("")
		ActionBar.AddView(abPlaceHolder, Btn.Left, Btn.Top, Btn.Width, Btn.Height)
		Dim P As Int
		P = LeftPosition(Btn)
		If P >= 0 Then
			abLeftStack.Set(P, abPlaceHolder)
			UpdateBackground(abPlaceHolder, False)
		Else
			P = RightPosition(Btn)
			If P >= 0 Then
				abRightStack.Set(P, abPlaceHolder)
				UpdateBackground(abPlaceHolder, True)
			End If
		End If
	End If
End Sub

'Aborts the drag&drop operation
Public Sub AbortDragAndDrop
	If abPlaceHolder.IsInitialized Then
		Dim P As Int
		P = LeftPosition(abPlaceHolder)
		If P >= 0 Then
			abLeftStack.Set(P, abDraggedBtn)
			UpdateSignOfTag(abDraggedBtn, False)
		Else
			P = RightPosition(abPlaceHolder)
			If P >= 0 Then
				abRightStack.Set(P, abDraggedBtn)
				UpdateSignOfTag(abDraggedBtn, True)
			End If
		End If
		abDraggedBtn.Background = abPlaceHolder.Background
		abPlaceHolder.RemoveView
		abPlaceHolder = Null
		ReorderViews
	End If
End Sub

Private Sub Btn_Touch(ViewTag As Object, Action As Int, X As Float, Y As Float, MotionEvent As Object) As Boolean
	If Action = 0 Then		'= DOWN
		abStartX = X
		Dim TouchedBtn As View = Sender
		TouchedBtn.BringToFront
	Else If Action = 1 Then	'= UP
		If abPlaceHolder.IsInitialized Then
			AbortDragAndDrop
			Dim BtnAction As typAction
			BtnAction = abDraggedBtn.Tag
			If SubExists(BtnAction.Module, abOnAfterDropSub) Then CallSub3(BtnAction.Module, abOnAfterDropSub, Me, abDraggedBtn)
		End If
	Else If Action = 2 Then '= MOVE
		If abPlaceHolder.IsInitialized Then
			' Blocks the interception of Touch events
			If abViewToBlock <> Null Then
				Dim r As Reflector
				r.Target = abViewToBlock
				r.RunMethod2("requestDisallowInterceptTouchEvent", True, "java.lang.boolean")
			End If

			' Moves the button to follow the finger move
			abDraggedBtn.Left = Min(Max(0, abDraggedBtn.Left + X - abStartX), ActionBar.Width - abDraggedBtn.Width)
			Dim Btn As View
			For i = 0 To GetLeftCount - 1
				Btn = abLeftStack.Get(i)
				If Btn = abPlaceHolder Then Continue
				' If the dragged button recovers more than 50% of another button, it moves it
				If (abDraggedBtn.Left + abDraggedBtn.Width > Btn.Left + Round(Btn.Width / 2) AND _
				    abDraggedBtn.Left + abDraggedBtn.Width <= Btn.Left + Btn.Width) OR _
					(abDraggedBtn.Left < Btn.Left + Round(Btn.Width / 2) AND _
				    abDraggedBtn.Left >= Btn.Left) Then
					MoveButtonTo(abPlaceHolder, i + 1)
					Return True
				End If
			Next
			For i = 0 To GetRightCount - 1
				Btn = abRightStack.Get(i)
				If Btn = abPlaceHolder Then Continue
				' If the dragged button recovers more than 50% of another button, it moves it
				If (abDraggedBtn.Left + abDraggedBtn.Width > Btn.Left + Round(Btn.Width / 2) AND _
				    abDraggedBtn.Left + abDraggedBtn.Width <= Btn.Left + Btn.Width) OR _
					(abDraggedBtn.Left < Btn.Left + Round(Btn.Width / 2) AND _
				    abDraggedBtn.Left >= Btn.Left) Then
					MoveButtonTo(abPlaceHolder, -(i + 1))
					Return True
				End If
			Next
		End If
	End If
	Return abPlaceHolder.IsInitialized
End Sub
#End Region

Private Sub UpdateSignOfTag(pnlBtn As Panel, RightStack As Boolean)
	' Updates the sign of the tag storing the TextPosition
	Dim v As View
	For i = 0 To pnlBtn.NumberOfViews - 1
		v = pnlBtn.GetView(i)
		If v Is Label Then
			If RightStack Then
				v.Tag = -Abs(v.Tag)
			Else
				v.Tag = Abs(v.Tag)
			End If
			Return
		End If
	Next
End Sub

'Moves a button to another position
'NewPosition = position in the action bar, starting from the left if positive (1 = leftmost position) or from the right if negative (-1 = rightmost position)
Public Sub MoveButtonTo(Btn As View, NewPosition As Int)
	Dim StackChange As Boolean
	Dim P As Int
	P = LeftPosition(Btn)
	If P >= 0 Then
		abLeftStack.RemoveAt(P)
		StackChange = (NewPosition < 0)
	Else
		P = RightPosition(Btn)
		If P >= 0 Then
			abRightStack.RemoveAt(P)
			StackChange = Not(NewPosition < 0)
		End If
	End If
	If NewPosition < 0 Then
		abRightStack.InsertAt(Min(Abs(NewPosition) - 1, GetRightCount), Btn)
	Else
		abLeftStack.InsertAt(Min(NewPosition - 1, GetLeftCount), Btn)
	End If
	If StackChange Then
		UpdateSignOfTag(Btn, NewPosition < 0)
		If abDividerWidth > 0 Then UpdateBackground(Btn, NewPosition < 0)
	End If
	ReorderViews
End Sub

'Removes a button from the action bar
Public Sub RemoveButton(Btn As View)
	Dim P As Int
	P = LeftPosition(Btn)
	If P >= 0 Then
		abLeftStack.RemoveAt(P)
	Else
		P = RightPosition(Btn)
		If P >= 0 Then abRightStack.RemoveAt(P)
	End If
	Btn.RemoveView
	If abSameWidthForAll > 0 Then
		SameWidthForAll(True)
	Else
		ReorderViews
	End If
End Sub

'Removes all buttons
Public Sub RemoveAllButtons
	abLeftStack.Clear
	abRightStack.Clear
	Dim v As View
	For i = ActionBar.NumberOfViews - 1 To 0 Step -1
		v = ActionBar.GetView(i)
		If Not(v Is Label) Then v.RemoveView
	Next
End Sub

'Sets the button width and centers its content
'This new width is temporary. It will be reset if you call Invalidate or a function modifying the button content.
'This function is ignored if SameWidthForAll has been enabled.
Public Sub SetFixedWidth(Btn As View, NewWidth As Int)
	If abSameWidthForAll > 0 OR NewWidth = 0 Then Return
	Dim pnl As Panel, v As View, IV As ImageView, lbl As Label
	pnl = Btn
	For i = 0 To pnl.NumberOfViews - 1
		v = pnl.GetView(i)
		If v Is ImageView Then IV = v
		If v Is Label Then lbl = v
	Next
	Dim Delta As Int
	Delta = NewWidth - pnl.Width
	If IV.IsInitialized Then IV.Left = IV.Left + Floor(Delta / 2)
	lbl.Left = lbl.Left + Floor(Delta / 2)
	pnl.Width = pnl.Width + Delta
	UpdateBackground(pnl, lbl.Tag < 0)
	ReorderViews
End Sub

'Sets the same width for all buttons
'New width = width of action bar / number of buttons (minimum = 10dip)
Public Sub SameWidthForAll(Enabled As Boolean)
	If Enabled Then
		If GetTotalCount = 0 Then
			abSameWidthForAll = 10dip
		Else
			abSameWidthForAll = Max(Round((ActionBar.Width + abDividerWidth) / GetTotalCount), 10dip)
		End If
	Else
		abSameWidthForAll = 0
	End If
	Invalidate
End Sub

'Enlarges the icon to fit the text width
'This function is ignored by buttons with no text and buttons with a text on the left/right side.
Public Sub SetIconAsWideAsText(Enabled As Boolean)
	abIconAsWideAsText = Enabled
	Invalidate
End Sub

'Sets the background of the action bar
'NewBackground = a valid drawable
Public Sub SetBackground(NewBackground As Object)
	ActionBar.Background = NewBackground
End Sub

'Gets the action bar panel
Public Sub AsPanel As Panel
	Return ActionBar
End Sub

Private Sub Button_Click
	' We call the sub associated to the button
	Dim v As View, Action As typAction
	v = Sender
	Action = v.Tag
	If SubExists(Action.Module, Action.OnClickSub) Then CallSub3(Action.Module, Action.OnClickSub, Me, v)
End Sub

Private Sub Button_LongClick
	' We call the sub associated to the button
	Dim v As View, Action As typAction
	v = Sender
	Action = v.Tag
	If SubExists(Action.Module, Action.OnLongClickSub) Then CallSub3(Action.Module, Action.OnLongClickSub, Me, v)
End Sub

'Gets the number of buttons stacked to the right
Public Sub GetRightCount As Int
	Return abRightStack.Size
End Sub

'Gets the number of buttons stacked to the left
Public Sub GetLeftCount As Int
	Return abLeftStack.Size
End Sub

'Gets the total number of buttons
Public Sub GetTotalCount As Int
	Return abLeftStack.Size + abRightStack.Size
End Sub

'Changes the dimensions of the action bar to fill completely its parent.
Public Sub FillParent
	ActionBar.Width = abParent.Width
	ActionBar.Height = abParent.Height
	Invalidate
End Sub
