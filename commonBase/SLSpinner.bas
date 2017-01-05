Type=Class
Version=3
@EndOfDesignText@
'Class module
Private Sub Class_Globals

	'Working Vars
	Private BackgroundPanel As Panel
	Private mTarget As Object
    Private mEventName As String
	Private mAct As Activity
	Private mBase As Panel
	Private DesignerCVCalled As Boolean
	Private Initialized As Boolean
	Private mSelectedIndex As Int = -1
	Private TotalItemHeight As Int
	Private BtnTouchSelect As Boolean
	Private BackingList As List
	Private ABSButtonTop,ABSButtonLeft As Int
	Private UserSetListWidth As Boolean
	Private UserSetListHeight As Boolean
	Private SpinnerPadding As Int = 5Dip
	Private SPListBorder As Int = 5Dip
	
	'View Vars
	Private SelectedBtn As Button				'Use a button not a label as a button already handles focus correctly
	Private SPList As ListView					'Contains the data added to the spinner
	Private SPListPnl As Panel					'Panel only provides the border/shadow for the list


End Sub
#Region Initialize used for Designer and manually added SLSpinner
'Initializes the object.
'Required for both designer and code setup. 
'Provides callback {EventName}_ItemClick(Position As Int,Value As Object)
Public Sub Initialize (TargetModule As Object, EventName As String)
	mTarget = TargetModule
	mEventName = EventName
	BackgroundPanel.Initialize("BackgroundPanel")
	SPListPnl.Initialize("")
	SPList.Initialize("SPList")
	BackingList.Initialize
End Sub
#End Region Initialize
#Region DesignerCreateView used to create view for designer
'Used by the designer when added there do not use manually Use Initialize and Setup!
Public Sub DesignerCreateView(Base As Panel, Lbl As Label, Props As Map)
	'Check this is not called from setup
	If Not(Props.GetDefault("SLfromsetup",False)) Then DesignerCVCalled = True
	
	'Assign vars to globals
	mBase = Base
	'This is passed from either the designer or setup
	mAct = Props.get("activity")
	
	'Add a panel that allows us to close the list when touched anywhere but the button and list and make it full screen size
	mAct.AddView(BackgroundPanel,0,0,100%x,100%y)
	BackgroundPanel.Visible = False
	
	'Setup onTouch on the background panel
	Dim R As Reflector
	R.Target = BackgroundPanel
	R.SetOnTouchListener("BackgroundPanel_Touch")
	
		
	'Add the Button that we are going to display the selected item on which is
	'permanently displayed
	SelectedBtn.Initialize("SelectedBtn")
	mBase.AddView(SelectedBtn,0,0,mBase.Width,mBase.Height)
		
	'Setup Button with current theme from Spinner in case they are different and a few other things
	SetUpButton
	
	'Add the ListView Object panel directly to the Activity so it is not constrained by any parent panels
	'Default values for Left, Top and Height, the position will be set in SetListPosition and SetListHeight
	
	mAct.AddView(SPListPnl,mBase.Left,0,60dip,50%y) 
	'Add the Listview object
	SPListPnl.AddView(SPList,SPListBorder,0,50dip,50%y + SPListBorder) 
	
	'Setup the list display attributes, pass the label as it has text attributes as defined in the designer
	'Or defaults from the manual entry
	SetUpList(Lbl)
	
	'Hide list until it's needed
	SPListPnl.Visible = False
	
	Initialized = True

End Sub
#End Region
#Region Setup used to create View manually
'Use when setting up the CustomView manually. Pass an initialized panel to add the Spinner to or Null to add to the Activity
Sub Setup(Act As Activity,Pnl As Panel,Left As Int,Top As Int,Width As Int,Height As Int)
	'Check if DesignerCreateView has been called
	If DesignerCVCalled Then
		LogColor("You should not call setup if you have defined this view in the designer",Colors.Red)
		Return
	End If
	
	mAct = Act
	
	'Create our own base panel
	Dim Base As Panel
	Base.Initialize("")
	
	'If Null was passed, a Panel wii be created by casting, but it won't be initialized
	If Pnl.IsInitialized Then
		Pnl.AddView(Base,Left,Top,Width,Height)
	Else
		Act.AddView(Base,Left,Top,Width,Height)
	End If
		
	'Set up vars to pass to DesignerCreateView so we don't have to maintain two identical subs
	Dim M As Map
	M.Initialize
	M.Put("activity",mAct)
	'As we are passing a map, we can use it to pass an additional flag for our own use 
	'with an ID unlikely To be used by B4a In the future
	M.Put("SLfromsetup",True)
	
	'We need a label to pass to DesignerCreateView
	Dim L As Label
	L.Initialize("")
	'Default text size
	'Default size for custom view text in designer is 14
	'Default For a Spinner Is 16, I didn't want to enforce this as you wouldn't then be able to change the size in the designer
	'and a default SLSpinner added in designer would look different to one added in code.
	L.TextSize = 14						
	L.Typeface = Typeface.DEFAULT
	L.Gravity = Gravity.CENTER_VERTICAL
	'Leave TextColor as default. Color is write only so we can't copy it, don't bother setting it
	
	DesignerCreateView(Base,L,M)
	
End Sub
#End Region
#Region Working Subs
'Measure the total height of an item
Private Sub GetListMetrics
	Dim JO As JavaObject = SPList
	TotalItemHeight = SPList.SingleLineLayout.ItemHeight + JO.RunMethod("getDividerHeight",Null)
	'Force Recalculation of the height of the list
	CalcListHeight
End Sub
'Set height of displayed List
Private Sub CalcListHeight
	'Don't set the height if the user has specified a height
	If UserSetListHeight Then Return
	SPList.Height = SPList.Size * TotalItemHeight
	SPListPnl.Height = SPList.Height + SPListBorder
End Sub
'Position the DropDown based on the position of the button and size of list
Private Sub SetListPosition
	'Find the absolute position of the view on the screen as it could be embeded in a panel or two. 
	ABSButtonTop = GetRelativeTop(mBase)
	ABSButtonLeft = GetRelativeLeft(mBase)
	'If the Button and List fit's on the screen the always draw the list below the button
	If ABSButtonTop + mBase.Height + SPListPnl.Height < mAct.Height - 5Dip Then
		SPListPnl.Top = ABSButtonTop + mBase.Height
		SPList.Top = 0
	Else
		'Otherwise, if the Midpoint of the Button is below the Midpoint of the screen the draw the list above the button
		If ABSButtonTop + (mBase.Height/2) > mAct.Height/2 Then
			If SPListPnl.Height > ABSButtonTop - 5Dip Then
				SPListPnl.Height = ABSButtonTop - 5Dip
				SPList.Height = SPListPnl.Height - SPListBorder
			End If
			SPListPnl.Top = ABSButtonTop - SPListPnl.Height
			SPList.Top = SPListBorder
		Else
			'Otherwise draw the list below the button
			SPListPnl.Top = ABSButtonTop + mBase.Height
			SPList.Top = 0
			If SPListPnl.Height > 100%y - ABSButtonTop - mBase.Height - 5Dip Then
				SPListPnl.Height = 100%y - ABSButtonTop - mBase.Height - 5Dip
				SPList.Height = SPListPnl.Height - SPListBorder
			End If
		End If
	End If
	SPListPnl.Left = ABSButtonLeft
End Sub
'SetUp the Text attibutes of the list items from the Label passed from the designer or manually added view
Private Sub SetUpList(Lbl As Label)
	setTypeFace(Lbl.Typeface)
	setGravity(Lbl.Gravity)
	setTextSize(Lbl.TextSize)
	setTextColor(Lbl.TextColor)
	setDropDownTextColor(Colors.White)
	'Standard height for Spinner items
	SPList.SingleLineLayout.ItemHeight = 48Dip
	SPListPnl.Color = Colors.ARGB(120,35,35,35)
	GetListMetrics
	setListColor(Colors.RGB(50,50,50))
End Sub
'Set up the Button view and StateListDrawable
Private Sub SetUpButton
	Dim JO As JavaObject = SelectedBtn
	JO.RunMethod("setPadding", Array As Object(10,5,5,5))
	SelectedBtn.Gravity = Gravity.LEFT
	'Set the state list drawable for the button
	SetStateListDrawable(Colors.RGB(130,130,130),Colors.RGB(50,50,50))
End Sub
'Process a selection, pass it back to the calling module
Private Sub SPList_ItemClick (Position As Int, Value As Object)
	SPListPnl.Visible = False
	BackgroundPanel.Visible = False
	SelectedBtn.Text = SPList.GetItem(Position)
	mSelectedIndex = Position
	If SubExists(mTarget,mEventName & "_ItemClick") Then
		CallSub3(mTarget,mEventName & "_ItemClick",Position ,Value)
	End If
End Sub
'Capture a touch on the Button and show the list and Background panel
Private Sub SelectedBtn_Click

	If SPListPnl.Visible Then
		SPListPnl.Visible = False
		BackgroundPanel.Visible = False
		If BtnTouchSelect Then
			If mSelectedIndex > -1 Then SPList_ItemClick (mSelectedIndex , SPList.GetItem(mSelectedIndex))
		End If
	Else
		'Check if the textsize or layout has been changed since the last display or initilization
		If SelectedBtn.TextSize <> SPList.SingleLineLayout.Label.TextSize OR SelectedBtn.Width <> SPList.Width  Then
			setTextSize(SelectedBtn.TextSize)
			setWidth(SelectedBtn.Width)
		End If
		'Recalculate the list position as it may have been moved since the last display
		SetListPosition
		SPListPnl.Visible = True
		BackgroundPanel.Visible = True
		BringToFront
	End If
End Sub
'Capture a touch on the background panel and hide the Drop Down List and Background panel
Private Sub BackgroundPanel_Touch (ViewTag As Object,Action As Int, X As Float, Y As Float,MotionEvent As Object) As Boolean

	'If we want to return a click that is on the button
	If BtnTouchSelect Then
		'Test if the click was on the button. the absolute location values have been calculated in SetListPosition before it was displayed
		'This is used if the button is set on a panel, if on the activity then SelectedBtn_Click will be called directly.
		If X >= ABSButtonLeft AND Y >= ABSButtonTop AND X <= ABSButtonLeft + SelectedBtn.Width AND Y <= ABSButtonTop + SelectedBtn .Height Then
			'Pass the click Through
			SelectedBtn_Click
			'SelectedBtn_Click has managed the closing of the list so just exit and consume the event
			Return True
		End If
	End If
	SPListPnl.Visible = False
	BackgroundPanel.Visible = False
	Return True
End Sub
#End Region Working Subs Ends
#Region Create Standard Spinner Functions
'Add an item to the spinner
Sub Add(Item As String)
	SPList.AddSingleLine(Item)
	BackingList.Add(Item)
	setSelectedIndex(0)
	'Force recalculation of the height of the list
	CalcListHeight
End Sub
'Add all items from a List of Strings to the spinner
Sub AddAll(List As List)
	For Each Item As String In List
		SPList.AddSingleLine(Item)
		BackingList.Add(Item)
	Next
	setSelectedIndex(0)
	'Force recalculation of the height of the list
	CalcListHeight
End Sub
'Get or Set the background for the visible Button. Can be one of: BitmapDrawable, ColorDrawable, GradientDrawable or StateListDrawable
'Returns a drawable of the type that was initially or subsequently set
Sub setBackground(BG As Object)
	If Not(BG Is BitmapDrawable OR BG Is ColorDrawable OR BG Is GradientDrawable OR BG Is StateListDrawable) Then
		LogColor("SLSpinner: setBackground failed : Not a drawable Object",Colors.Red)
		Return
	End If
	SelectedBtn.Background = BG
End Sub
Sub getBackground As Object
	Return SelectedBtn.Background
End Sub
'Changes the Z order of this view and brings it to the front.
Sub BringToFront
	BackgroundPanel.BringToFront
	mBase.BringToFront
	SPListPnl.BringToFront
End Sub
'Sets the background of the Button to be a ColorDrawable with the given color.
Sub setColor(Color As Int)
	mBase.Color = Color
End Sub
'Clear all items from the Spinner
Sub Clear
	SPList.Clear
	BackingList.Clear
End Sub
'Get or set the DropDownTextColor
Sub setDropDownTextColor(color As Int)
	SPList.SingleLineLayout.Label.TextColor = color
End Sub
Sub getDropDownTextColor As Int
	Return SPList.SingleLineLayout.Label.TextColor
End Sub
'Enable / Disable the spinner
Sub setEnabled(Enabled As Boolean)
	SelectedBtn.Enabled = Enabled
	SPList.Enabled = Enabled
End Sub
Sub getEnabled As Boolean
	Return SelectedBtn.Enabled
End Sub
'Get Item at index from the list
Sub GetItem(Index As Int) As String
	Return SPList.GetItem(Index)
End Sub
''Gets or sets the height of the displayed View
Sub setHeight(Height As Int)
	mBase.Height = Height
	SelectedBtn.Height = Height
	SetListPosition
End Sub
Sub getHeight As Int
	Return mBase.Height
End Sub
'Returns the index of Value in the Spinner or -1 if not found
Sub IndexOf(Value As String) As Int
	Return BackingList.IndexOf(Value)
End Sub
' Invalidates the view, forcing it to redraw itself.
Sub Invalidate
	mBase.Invalidate
	SPList.Invalidate
End Sub
'Returns True if the View has been initialized.  For a manually added Spinner, setup must have also been called
Sub IsInitialized As Boolean
	Return Initialized
End Sub
'Gets or sets the ItemHeight. Default height is 48Dip
Sub setItemHeight(Height As Int)
	SPList.SingleLineLayout.ItemHeight = Height
	'Force recalculation of the list metrics
	GetListMetrics
End Sub
Sub getItemHeight As Int
	Return SPList.SingleLineLayout.ItemHeight
End Sub
'Gets or sets the view's left position.
Sub setLeft(Left As Int)
	mBase.Left = Left
	SetListPosition
End Sub
Sub getLeft As Int
	Return mBase.Left
End Sub
'Removes the item at the specified index.
Sub RemoveAt(Index As Int)
	SPList.RemoveAt(Index)
	BackingList.RemoveAt(Index)
End Sub
'Removes this view from its parent.
Sub RemoveView
	mBase.RemoveView
	SPListPnl.RemoveView
End Sub
'Tries To set the focus To this View.
'Returns True If the focus was set.
Sub RequestFocus As Boolean
	Return SelectedBtn.RequestFocus
End Sub
'Gets or sets the index of the selected item. Returns -1 if no item is selected.
Sub setSelectedIndex(Index As Int)
	SPList.SetSelection(Index)
	mSelectedIndex = Index
	SelectedBtn.Text = SPList.GetItem(Index)
End Sub
Sub getSelectedIndex As Int
	Return mSelectedIndex
End Sub
'Returns the value of the selected item. Returns an empty string if no item is selected.
Sub getSelectedItem As String
	If mSelectedIndex > -1 Then
		Return SPList.GetItem(mSelectedIndex)
	Else
		Return ""
	End If
End Sub
'Changes the Z order of this view and sends it to the back.
Sub SendToBack
	BackgroundPanel.SendToBack
	mBase.SendToBack
	SPList.SendToBack
End Sub
'Set the Spinner Buttons background image
Sub SetBackgroundImage(Image As Bitmap)
	mBase.SetBackgroundImage(Image)
End Sub
'Changes the view position and size.
Sub SetLayout(Left As Int,Top As Int,Width As Int,Height As Int)
	mBase.SetLayout(Left,Top,Width,Height)
	SetListPosition
End Sub
'Returns the number of items in the list.
Sub getSize As Int
	Return SPList.Size
End Sub
'Gets or sets the Tag value. This is a place holder which can used to store additional data.
Sub setTag(Tag As Object)
	mBase.Tag = Tag
End Sub
Sub getTag As Object
	Return mBase.Tag
End Sub
'Gets or sets the Buttons text color.
Sub setTextColor(Color As Int)
	SelectedBtn.TextColor = Color
End Sub
Sub getTextColor As Int
	Return SelectedBtn.TextColor
End Sub
'Get or sets the text size. Default for a customview is 14, default for a Spinner is 16
Sub setTextSize(Size As Float)
	SelectedBtn.TextSize = Size
	SPList.SingleLineLayout.Label.TextSize = Size
End Sub
Sub getTextSize As Float
	Return SelectedBtn.TextSize
End Sub
'Gets or sets the view's top position.
Sub getTop As Int
	Return mBase.Top
End Sub
Sub setTop(Top As Int)
	mBase.Top = Top
	SetListPosition
End Sub
'Gets or sets the spinners Visibility
Sub setVisible(Visible As Boolean)
	mBase.Visible = Visible
	If Visible = False Then	
		SPListPnl.Visible = Visible
		BackgroundPanel.Visible = Visible
	End If
End Sub
Sub getVisible As Boolean
	Return mBase.Visible
End Sub
'Gets or sets the view's width. If you have set listwidth, setting this will only effect the Button width
Sub setWidth(Width As Int)
	mBase.Width = Width
	If Not(UserSetListWidth) Then 
		'Mimic the width display of the Android spinner
		If Width > 62Dip Then 
			Width = SelectedBtn.Width - 12DIP
		Else
			Width = 50Dip
		End If
		SPListPnl.Width = Width + (SPListBorder * 2)
		SPList.Width = Width
	End If
	'Won't move the list position so no need to call SetListPosition
End Sub
Sub getWidth As Int
	Return mBase.Width
End Sub
#End Region Create Standard Spinner Functions Ends
#Region Added Features
'Gets or sets whether a touch on the button passes the currently selected item as a selection
'Default is False
Sub setButtonTouchSelect(Enable As Boolean)
	BtnTouchSelect = Enable
End Sub
Sub getButtonTouchSelect As Boolean
	Return BtnTouchSelect
End Sub
'Gets or sets the Gravity for the displayed Button and drop down List
Sub setGravity(Grav As Int)
	SPList.SingleLineLayout.Label.Gravity = Grav
	SelectedBtn.Gravity = Grav
End Sub
Sub getGravity As Int
	Return SelectedBtn.Gravity
End Sub
'Sets the background of the List to be a ColorDrawable with the given color.
Sub setListColor(Color As Int)
	SPList.Color = Color
End Sub
'Sets the List Border Color . Default = Colors.ARGB(120,35,35,35) and gives a shadow effect
Sub setListBorderColor(Color As Int)
	SPListPnl.Color = Color
End Sub
'Set the List Border Size. Default = 5Dip Set to '0' to hide the border
Sub setListBorderSize(Size As Int)
	SPListBorder = Size
	SPListPnl.Width = SPList.Width + (2 * Size)
	SPListPnl.Height = SPList.Height + Size
	SPList.Left = Size
End Sub
'Gets or sets the lists width excluding any border
Sub setListWidth(Width As Int)
	UserSetListWidth = True
	SPListPnl.Width = Width + (SPListBorder * 2)
	SPList.Width = Width
End Sub
Sub getListWidth As Int
	Return SPList.Width
End Sub
'Gets or sets the list height excluding any border
'Seting this will be ignored if it would make the list larger than the available screen size, so that the list can scroll fully.
'Setting this is only really useful to limit the size of the list, as setting ItemHeight automatically adjusts the List height.
'the list will scroll if it cannot be displayed in the size available.
Sub setListHeight(Height As Int)
	UserSetListHeight = True
	SPListPnl.Height = Height +SPListBorder
	SPList.Height = Height
End Sub
Sub getListHeight As Int
	Return SPList.Height
End Sub
'SLSPinner tries to use the Drawables that is standard for the device and API level.
'You can set your own colors for the statelist Drawable, The Icon is drawn to match the android 4.0 Spinner Icon
Private Sub SetStateListDrawable(FGEnabledColor As Int,FGDisabledColor As Int)
	
	'Create State List Drawable
	Dim BMEnabled,BMDisabled,BMPressed,BMFocused As Bitmap
	Dim Enabled,Disabled,Pressed,Focused As BitmapDrawable
	Dim CEnabled,CDisabled,CPressed,CFocused As Canvas
	BMEnabled.InitializeMutable(SelectedBtn.Width,SelectedBtn.Height)
	CEnabled.Initialize2(BMEnabled)
	BMDisabled.InitializeMutable(SelectedBtn.Width,SelectedBtn.Height)
	CDisabled.Initialize2(BMDisabled)
	BMPressed.InitializeMutable(SelectedBtn.Width,SelectedBtn.Height)
	CPressed.Initialize2(BMPressed)
	BMFocused.InitializeMutable(SelectedBtn.Width,SelectedBtn.Height)
	CFocused.Initialize2(BMFocused)
	
	'This replicates the Android 4 look for the spinner button.  You can change this here.
	Dim P As Path
	P.Initialize(SpinnerPadding,SelectedBtn.Height - SpinnerPadding)
	P.LineTo(SelectedBtn.Width - SpinnerPadding,SelectedBtn.Height- SpinnerPadding)
	P.LineTo(SelectedBtn.Width - SpinnerPadding,SelectedBtn.Height - 12Dip - SpinnerPadding)
	P.LineTo(SelectedBtn.Width - SpinnerPadding -12Dip,SelectedBtn.Height - 1 - SpinnerPadding)
	P.LineTo(0,SelectedBtn.Height - SpinnerPadding - 1)
	
	'Enabled Button
	CEnabled.DrawPath(P,FGEnabledColor,True,1)
	Enabled.Initialize(CEnabled.Bitmap)
	
	'Disabled Button
	CDisabled.DrawPath(P,FGDisabledColor,True,1)
	Disabled.Initialize(CDisabled.Bitmap)
	
	Dim DestRect As Rect
	DestRect.Initialize(0,0,SelectedBtn.Width,SelectedBtn.Height)
	
	'Try to match the focused color relevant for the API
	'Focused Button
	Try
		'Get the holo light Focused color which appears to be the default on 4+
		CFocused.DrawDrawable(GetAndroidResourceBitmapDrawable("btn_default_focused_holo_light"),DestRect)
	Catch
		Try
			'Get the standard Focused color for < Android 4
			CFocused.DrawDrawable(GetAndroidResourceBitmapDrawable("btn_default_normal_disable_focused"),DestRect)
		Catch
			'Draw our own as default in case a version of android in a device has neither of the above.
			CFocused.DrawBitmap(GetBorderedDrawable(SelectedBtn.Width,SelectedBtn.Height,Colors.RGB(0x33,0xb5,0xe5),Colors.RGB(0x00,0x66,0xff),0,0,5Dip),Null,DestRect)	
		End Try
	End Try
		
	CFocused.DrawPath(P,FGEnabledColor,True,1)
	Focused.Initialize(CFocused.Bitmap)
	
	'Pressed Button
	Try
		'Get the holo light Pressed color which appears to be the default on 4+
		CPressed.DrawDrawable(GetAndroidResourceBitmapDrawable("list_pressed_holo_light"),DestRect)
	Catch
		Try
			'Get the standard Pressed color for < Android 4
			CPressed.DrawDrawable(GetAndroidResourceBitmapDrawable("btn_default_pressed"),DestRect)
		Catch
			'Draw our own as default in case a version of android in a device has neither of the above
			CPressed.DrawBitmap(GetBorderedDrawable(SelectedBtn.Width,SelectedBtn.Height,Colors.RGB(50,50,50),Colors.RGB(50,50,50),5,5,1Dip),Null,DestRect)
		End Try
	End Try
	
	CPressed.DrawPath(P,FGEnabledColor,True,1)
	Pressed.Initialize(CPressed.Bitmap)
	
	Dim SLD As StateListDrawable
	SLD.Initialize
	SLD.AddState(SLD.State_Pressed,Pressed)
	SLD.AddState(SLD.State_Focused,Focused)
	SLD.AddState(SLD.State_Enabled,Enabled)
	SLD.AddState(SLD.State_Disabled,Disabled)
	SLD.AddCatchAllState(Enabled)
	
	'Set the background
	setBackground(SLD) 
End Sub
'Show / Hide the drop down list
Sub ToggleList
	SelectedBtn_Click
End Sub
'Get or set the Typeface used by the spinner
Sub setTypeFace(TFace As Typeface)
	SelectedBtn.Typeface = TFace
	SPList.SingleLineLayout.Label.Typeface = TFace
End Sub
Sub getTypeFace As Typeface
	Return SelectedBtn.Typeface
End Sub
#End Region Added Features Ends
#Region Utilities
Private Sub GetBorderedDrawable (Width As Int, Height As Int,FillColor As Int, StrokeColor As Int, rx As Float, ry As Float, SWidth As Float) As Bitmap

	Dim BM As Bitmap
	Dim Cnv As Canvas
	'We need to draw on the bitmap with a canvas
	BM.InitializeMutable(Width,Height)
	Cnv.Initialize2(BM)
	'Sizing Variables need to be cast to floats to enable the constructor to be found.
	Dim l,t,r,b As Float
	l = 0
	t = 0
	r = Width
	b = Height
	'Needs a RectF object not just a Rect
	Dim rect1 As JavaObject
	rect1.InitializeNewInstance("android.graphics.RectF",Array As Object(l,t,r,b))
	'Create a Paint.Style object
	Dim PS As JavaObject
	PS.InitializeStatic("android.graphics.Paint.Style")
	'Create and setup a Paint object
	Dim Paint,Paint1 As JavaObject
	Paint.InitializeNewInstance("android.graphics.Paint",Null)
	Paint.RunMethod("setStrokeWidth",Array As Object(SWidth))
	Paint.RunMethod("setColor",Array As Object(StrokeColor))
	Paint.RunMethod("setStyle",Array As Object(PS.GetField("STROKE")))
	Paint.RunMethod("setAntiAlias",Array As Object(True))
	
	Paint1.InitializeNewInstance("android.graphics.Paint",Null)
	Paint1.RunMethod("setColor",Array As Object(FillColor))
	Paint1.RunMethod("setAntiAlias",Array As Object(True))
	Paint1.RunMethod("setStyle",Array As Object(PS.GetField("FILL")))
	
	'Get the canvas object from the wrapper
	Dim CnvJO As JavaObject = Cnv
	CnvJO = CnvJO.GetField("canvas")
	'Draw the filled round rect on the bitmap using the canvas
	CnvJO.RunMethod("drawRoundRect",Array As Object(rect1,rx,ry,Paint1))
	'Draw the border round rect on the bitmap using the canvas
	CnvJO.RunMethod("drawRoundRect",Array As Object(rect1,rx,ry,Paint))
	'Cast the Bitmap to a BitmapDrawable
	Return BM

End Sub
'Iterative sub to get the views Top relative to the activity window
Private Sub GetRelativeTop(V As JavaObject) As Int
	'I tried several methods to do this, this was the only one that worked across API's and devices
	
	'This will always be the last parent
	If GetType(V) = "android.view.ViewRoot" OR GetType(V) = "android.view.ViewRootImpl" Then
		Return 0
	Else
		'If V.Top is valid for this view returns a value then add it, else skip to the next parent
		Try
			Dim VW As View = V
			Return VW.Top + GetRelativeTop(V.RunMethod("getParent",Null))
		Catch
			Return GetRelativeTop(V.RunMethod("getParent",Null))
		End Try
	End If
End Sub
'Iterative sub to get the views Left relative to the activity window
Private Sub GetRelativeLeft(V As JavaObject) As Int
	'I tried several methods to do this, this was the only one that worked across API's and devices
	
	'This will always be the last parent
	If GetType(V) = "android.view.ViewRoot" OR GetType(V) = "android.view.ViewRootImpl" Then
		Return 0
	Else
		'If V.Left is valid for this view returns a value then add it, else skip to the next parent
		Try
			Dim VW As View = V
			Return VW.Left + GetRelativeLeft(V.RunMethod("getParent",Null))
		Catch
			Return GetRelativeLeft(V.RunMethod("getParent",Null))
		End Try
	End If
End Sub
'Gets an image as a BitmapDrawable from resources that is stored in res\drawable res\drawable-hdpi or res\drawable-xhdpi
'ImageName should not include the filetype i.e. .png .jpg etc
Private Sub GetAndroidResourceBitmapDrawable(ImageName As String) As Object
   	Dim r As Reflector
   	Dim JO As JavaObject = r.GetContext
   	Dim id As Int
   	JO = JO.RunMethod("getResources",Null)
	JO = JO.RunMethod("getSystem",Null)
	id = JO.RunMethod("getIdentifier",Array As Object(ImageName,"drawable","android"))
	'Return null so our try catch fails if no resource found
	If id = 0 Then
		Return Null
	Else
	   	r.Target = r.GetContext
	   	r.Target = r.RunMethod("getResources")
	   	Return r.RunMethod2("getDrawable", id, "java.lang.int")
	End If
End Sub
'Gets an image as a BitmapDrawable from resources that is stored in res\drawable res\drawable-hdpi or res\drawable-xhdpi
'ImageName should not include the filetype i.e. .png .jpg etc
Private Sub GetPackageResourceBitmapDrawable(ImageName As String) As BitmapDrawable
	'Not used in this implementation but here in case you implement your own themes and want to get
	'the resource from the package
   	Dim r As Reflector
   	Dim package As String
   	Dim id As Int
   	package = r.GetStaticField("anywheresoftware.b4a.BA", "packageName")
   	id = r.GetStaticField(package & ".R$drawable", ImageName)
	'Return null so our try catch fails if no resource found
	If id = 0 Then
		Return Null
	Else
	   	r.Target = r.GetContext
	   	r.Target = r.RunMethod("getResources")
	   	Return r.RunMethod2("getDrawable", id, "java.lang.int")
	End If
End Sub
#End Region Utilities Ends