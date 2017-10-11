Type=StaticCode
Version=7.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#ExcludeFromLibrary : True
'Scale Code module
' Version 1.4		2013.11.29
' amended error with height and width <0
'
' Version 1.3		2013.11.16
' added ScaleAllX and ScaleViewX
' this scaling uses only the X scale factor
'
' Version 1.2 	2013.09.18
' added HorizontalScrollView
'
' Version 1.1 
' added other reference layouts
' the original AutoScale the reference screen is 320/480/160
' in the new version you can set any other screen like 800/1280/160
'
' Version 1.0 orginal

Sub Process_Globals
' Designer Scripts AutoScale formula
'	Delta = ((100%x + 100%y) / (320dip + 430dip) - 1)
'	Rate = 0.5 'value between 0 to 1. 
'	Scale = 1 + Rate * Delta

	Public Rate As Double
	Rate = 0.3 'value between 0 to 1. 
	Private cScaleX, cScaleY, cScaleDS As Double
	Private cRefWidth = 320 As Int 
	Private cRefHeight = 480 As Int 
	Private cRefScale = 1 As Double
End Sub

'Initializes the Scale factors
Public Sub Initialize
	Dim DeviceScale As Double
	DeviceScale = 100dip / 100
	
	If cRefHeight <> 480 Or cRefWidth <> 320 Or cRefScale <> 1 Then
		If 100%x > 100%y Then
			' landscape
			cScaleX = 100%x / DeviceScale / (cRefHeight / cRefScale)
			cScaleY = 100%y / DeviceScale / ((cRefWidth - 50 * cRefScale) / cRefScale)
		Else
			' portrait
			cScaleX = 100%x / DeviceScale / (cRefWidth / cRefScale)
			cScaleY = 100%y / DeviceScale / ((cRefHeight - 50 * cRefScale) / cRefScale)
		End If
	Else
		If GetDevicePhysicalSize < 6 Then
			If 100%x > 100%y Then
				' landscape
				cScaleX = 100%x / DeviceScale / (cRefHeight / cRefScale)  
				cScaleY = 100%y / DeviceScale / ((cRefWidth - 50 * cRefScale) / cRefScale)
			Else
				' portrait
				cScaleX = 100%x / DeviceScale / (cRefWidth / cRefScale)
				cScaleY = 100%y / DeviceScale / ((cRefHeight - 50 * cRefScale) / cRefScale)
			End If
		Else
			If 100%x > 100%y Then
				' landscape
				cScaleX = 1 + Rate * (100%x / DeviceScale / (cRefHeight / cRefScale) - 1)
				cScaleY = 1 + Rate * (100%y / DeviceScale / ((cRefWidth - 50 * cRefScale) / cRefScale) - 1) 
			Else
				' portrait
				cScaleX = 1 + Rate * (100%x / DeviceScale / (cRefWidth / cRefScale) - 1)
				cScaleY = 1 + Rate * (100%y / DeviceScale / ((cRefHeight - 50dip * cRefScale) / cRefScale) - 1) 
			End If
		End If
		cScaleDS = 1 + Rate * ((100%x + 100%y) / DeviceScale / ((cRefWidth  + cRefHeight - 50 * cRefScale) / cRefScale) - 1) 
	End If
End Sub

'Gets the current X scale with the Rate set with SetRate 
'or with the default Rate value of 0.3
Public Sub GetScaleX As Double
	Return cScaleX
End Sub

'Gets the current Y scale with the Rate set with SetRate 
'or with the default Rate value of 0.3
Public Sub GetScaleY As Double
	Return cScaleY
End Sub

'Gets the Y scale in landscape orientation
'with the Rate set with SetRate 
'or with the default Rate value of 0.3
'independant of the current orientation
Public Sub GetScaleY_L As Double
	If GetDevicePhysicalSize < 6 Then
		Return (100%y / (cRefWidth - 50dip) / cRefScale)
	Else
		Return (1 + Rate * (100%y / (cRefWidth - 50dip) / cRefScale - 1))
	End If
End Sub

'Gets the Y scale in portrait orientation
'with the Rate set with SetRate 
'or with the default Rate value of 0.3
'independant of the current orientation
Public Sub GetScaleY_P As Double
	If GetDevicePhysicalSize < 6 Then
		Return (100%y / (cRefHeight - 50dip) / cRefScale)
	Else
		Return (1 + Rate * (100%y / (cRefHeight - 50dip) / cRefScale - 1))
	End If
End Sub

'Gets the X scale in landscape orientation
'with the Rate set with SetRate 
'or with the default Rate value of 0.3
'independant of the current orientation
Public Sub GetScaleX_L As Double
	If GetDevicePhysicalSize < 6 Then
		Return (100%y / (cRefWidth - 50dip) / cRefScale)
	Else
		Return (1 + Rate * (100%y / (cRefWidth - 50dip) / cRefScale - 1))
	End If
End Sub

'Gets the X scale in portrait orientation
'with the Rate set with SetRate 
'or with the default Rate value of 0.3
'independant of the current orientation
Public Sub GetScaleX_P As Double
	If GetDevicePhysicalSize < 6 Then
		Return (100%y / cRefWidth / cRefScale)
	Else
		Return (1 + Rate * (100%y / (cRefWidth - 50dip) / cRefScale - 1))
	End If
End Sub

'Gets the standard Designer Scripts sacle
'with the Rate set with SetRate 
'or with the default Rate value of 0.3
Public Sub GetScaleDS As Double
	Return cScaleDS
End Sub

'Sets the scale rate
'Exemple:
'Set the value to 0.5
'<code>Scale.SetRate(0.5)</code>
Public Sub SetRate(cRate As Double)
	Rate = cRate
	Initialize
End Sub

'Gets the approximate phyiscal screen size in inches
'Exemple:
'<code>DeviceSize = Scale.GetDevicePhysicalSize</code>
Public Sub GetDevicePhysicalSize As Float
	Dim lv As LayoutValues

	lv = GetDeviceLayoutValues
	Return Sqrt(Power(lv.Height / lv.Scale / 160, 2) + Power(lv.Width / lv.Scale / 160, 2))
End Sub

'Scales the view v with the Rate set with SetRate
'or with the default Rate value of 0.3
'v must not be an Activity
Public Sub ScaleView(v As View)
	If IsActivity(v) Then
		Return
	End If
	
	v.Left = v.Left * cScaleX
	v.Top = v.Top * cScaleY
	If IsPanel(v) Then
		Dim pnl As Panel
		pnl = v
		If pnl.Background Is BitmapDrawable Then
			' maintain the width/height ratio
			' uses the min value of the scales 
			If v.Width > 0 Then
				v.Width = v.Width * Min(cScaleX, cScaleY)
			End If
			If v.Height > 0 Then
				v.Height = v.Height * Min(cScaleX, cScaleY)
			End If
		Else
			If v.Width > 0 Then
				v.Width = v.Width * cScaleX
			End If
			If v.Height > 0 Then
				v.Height = v.Height * cScaleY
			End If
		End If
		ScaleAll(pnl, False)
	Else If v Is ImageView Then
		' maintain the width/height ratio
		' uses the min value of the scales 
		If v.Width > 0 Then
			v.Width = v.Width * Min(cScaleX, cScaleY)
		End If
		If v.Height > 0 Then
			v.Height = v.Height * Min(cScaleX, cScaleY)
		End If
	Else
		If v.Width > 0 Then
			v.Width = v.Width * cScaleX
		End If
		If v.Height > 0 Then
			v.Height = v.Height * cScaleY
		End If
	End If

	If v Is Label Then 'this will catch ALL views with text (EditText, Button, ...)
		Dim lbl As Label = v
		lbl.TextSize = lbl.TextSize * cScaleX
	End If

	If GetType(v) = "anywheresoftware.b4a.objects.ScrollViewWrapper$MyScrollView" Then
		' test if the view is a ScrollView
		' if yes calls the ScaleAll routine with ScrollView.Panel
		Dim scv As ScrollView
		scv = v
		ScaleAll(scv.Panel, False)
		scv.Panel.Height = scv.Panel.Height * cScaleY
	Else If GetType(v) = "anywheresoftware.b4a.objects.HorizontalScrollViewWrapper$MyHScrollView" Then
		' test if the view is a HorizontalScrollView
		' if yes calls the ScaleAll routine with HorizontalScrollView.Panel
		Dim hcv As HorizontalScrollView
		hcv = v
		ScaleAll(hcv.Panel, False)
		hcv.Panel.Width = hcv.Panel.Width * cScaleX
	Else If GetType(v) = "flm.b4a.scrollview2d.ScrollView2DWrapper$MyScrollView" Then
		' test if the view is a ScrollView2D
		' if yes calls the ScaleAll routine with ScrollView2D.Panel
'		Dim scv2d As ScrollView2D
'		scv2d = v
'		ScaleAll(scv2d.Panel, False)
'		scv2d.Panel.Width = scv2d.Panel.Width * cScaleX
'		scv2d.Panel.Height = scv2d.Panel.Height * cScaleY
	Else If GetType(v) = "anywheresoftware.b4a.objects.ListViewWrapper$SimpleListView" Then
		' test if the view is a ListView
		' if yes scales the internal views
		Dim ltv As ListView
		ltv = v
		ScaleView(ltv.SingleLineLayout.Label)
		ltv.SingleLineLayout.ItemHeight = ltv.SingleLineLayout.ItemHeight * cScaleY
		
		ScaleView(ltv.TwoLinesLayout.Label)
		ScaleView(ltv.TwoLinesLayout.SecondLabel)
		ltv.TwoLinesLayout.ItemHeight = ltv.TwoLinesLayout.ItemHeight * cScaleY
		
		ScaleView(ltv.TwoLinesAndBitmap.Label)
		ScaleView(ltv.TwoLinesAndBitmap.SecondLabel)
		ScaleView(ltv.TwoLinesAndBitmap.ImageView)
		ltv.TwoLinesAndBitmap.ItemHeight = ltv.TwoLinesAndBitmap.ItemHeight * cScaleY
		' center the image vertically
		ltv.TwoLinesAndBitmap.ImageView.Top = (ltv.TwoLinesAndBitmap.ItemHeight - ltv.TwoLinesAndBitmap.ImageView.Height) / 2
	Else If GetType(v) = "anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner" Then
		' test if the view is a Spinner
		' if yes scales the internal text size
		Dim spn As Spinner
		spn = v 
		spn.TextSize = spn.TextSize * cScaleX
	End If
End Sub

'Scales all views in the given Activity or Panel with all its child views
'with the Rate set with SetRate
'or with the default Rate value of 0.3
'FirstTime must be True
'Example:
'<code>Sub ScaleAll(Activity, True)</code>
'Public Sub ScaleAll(act As Activity, FirstTime As Boolean)
Public Sub ScaleAll(pnl As Panel, FirstTime As Boolean)	
	Dim I As Int
	
	' test if the activity object is a Panel
	If IsPanel(pnl) And FirstTime = True Then
		' if yes scale it
		ScaleView(pnl)
	Else
		For I = 0 To pnl.NumberOfViews - 1
			Dim v As View
			v = pnl.GetView(I)
			ScaleView(v)
		Next
	End If
End Sub

'Scales the view v with the Rate set with SetRate
'scaling like the Designer Scripts
'or with the default Rate value of 0.3
Public Sub ScaleViewDS(v As View)
	If IsActivity(v) Then
		Return
	End If
	
	v.Left = v.Left * cScaleDS
	v.Top = v.Top * cScaleDS
	If v.Width > 0 Then
		v.Width = v.Width * cScaleDS
	End If
	If v.Height > 0 Then
		v.Height = v.Height * cScaleDS
	End If

	If IsPanel(v) Then
		Dim pnl As Panel
		pnl = v
		ScaleAllDS(pnl, False)
	End If
	
	If v Is Label Then 'this will catch ALL views with text (EditText, Button, ...)
		Dim lbl As Label = v
		lbl.TextSize = lbl.TextSize * cScaleDS
	End If

	If GetType(v) = "anywheresoftware.b4a.objects.ScrollViewWrapper$MyScrollView" Then
		' test if the view is a ScrollView
		' if yes calls the ScaleAll routine with ScrollView.Panel
		Dim scv As ScrollView
		scv = v
		ScaleAllDS(scv.Panel, False)
		scv.Panel.Height = scv.Panel.Height * cScaleDS
	Else If GetType(v) = "anywheresoftware.b4a.objects.HorizontalScrollViewWrapper$MyHScrollView" Then
		' test if the view is a HorizontalScrollView
		' if yes calls the ScaleAll routine with HorizontalScrollView.Panel
		Dim hcv As HorizontalScrollView
		hcv = v
		ScaleAllDS(hcv.Panel, False)
		hcv.Panel.Width = hcv.Panel.Width * cScaleDS
	Else If GetType(v) = "flm.b4a.scrollview2d.ScrollView2DWrapper$MyScrollView" Then
		' test if the view is a ScrollView2D
		' if yes calls the ScaleAll routine with ScrollView2D.Panel
'		Dim scv2d As ScrollView2D
'		scv2d = v
'		ScaleAllDS(scv2d.Panel, False)
'		scv2d.Panel.Width = scv2d.Panel.Width * cScaleDS
'		scv2d.Panel.Height = scv2d.Panel.Height * cScaleDS
	Else If GetType(v) = "anywheresoftware.b4a.objects.ListViewWrapper$SimpleListView" Then
		' test if the view is a ListView
		' if yes scales the internal views
		Dim ltv As ListView
		ltv = v
		ScaleViewDS(ltv.SingleLineLayout.Label)
		ltv.SingleLineLayout.ItemHeight = ltv.SingleLineLayout.ItemHeight * cScaleDS
		
		ScaleViewDS(ltv.TwoLinesLayout.Label)
		ScaleViewDS(ltv.TwoLinesLayout.SecondLabel)
		ltv.TwoLinesLayout.ItemHeight = ltv.TwoLinesLayout.ItemHeight * cScaleDS
		
		ScaleViewDS(ltv.TwoLinesAndBitmap.Label)
		ScaleViewDS(ltv.TwoLinesAndBitmap.SecondLabel)
		ScaleViewDS(ltv.TwoLinesAndBitmap.ImageView)
		ltv.TwoLinesAndBitmap.ItemHeight = ltv.TwoLinesAndBitmap.ItemHeight * cScaleDS
		' center the image vertically
		ltv.TwoLinesAndBitmap.ImageView.Top = (ltv.TwoLinesAndBitmap.ItemHeight - ltv.TwoLinesAndBitmap.ImageView.Height) / 2
	Else If GetType(v) = "anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner" Then
		' test if the view is a Spinner
		' if yes scales the internal text size
		Dim spn As Spinner
		spn = v 
		spn.TextSize = spn.TextSize * cScaleDS
	End If
End Sub

'Scales all views in the given Activity or Panel with all its child views
'scaling like the Designer Scripts
'with the Rate set with SetRate
'or with the default Rate value of 0.3
'FirstTime must be True
'Example:
'<code>Sub ScaleAllDS(Activity, True)</code>
Public Sub ScaleAllDS(pnl As Panel, FirstTime As Boolean)
	Dim I As Int
	
	' test if the activity object is a Panel
	If IsPanel(pnl) AND FirstTime = True Then
		' if yes scale it
		ScaleViewDS(pnl)
	Else
		For I = 0 To pnl.NumberOfViews - 1
			Dim v As View
			v = pnl.GetView(I)
			ScaleViewDS(v)
		Next
	End If
End Sub

'Scales all views in the given Activity or Panel with all its child views
'with the Rate set with SetRate
'or with the default Rate value of 0.3
'only the X scale is used, the vertical scale is the same as the horizontal scale
'FirstTime must be True
'Example:
'<code>Sub ScaleAll(Activity, True)</code>
'Public Sub ScaleAll(act As Activity, FirstTime As Boolean)
Public Sub ScaleAllX(pnl As Panel, FirstTime As Boolean)	
	Dim I As Int
	
	' test if the activity object is a Panel
	If IsPanel(pnl) AND FirstTime = True Then
		' if yes scale it
		ScaleViewX(pnl)
	Else
		For I = 0 To pnl.NumberOfViews - 1
			Dim v As View
			v = pnl.GetView(I)
			ScaleViewX(v)
		Next
	End If
End Sub

'Scales the view v with the Rate set with SetRate
'or with the default Rate value of 0.3
'only the X scale is used, the vertical scale is the same as the horizontal scale
'v must not be an Activity
Public Sub ScaleViewX(v As View)
	If IsActivity(v) Then
		Return
	End If
	
	v.Left = v.Left * cScaleX
	v.Top = v.Top * cScaleX

	If IsPanel(v) Then
		Dim pnl As Panel
		pnl = v
		If v.Width > 0 Then
			v.Width = v.Width * cScaleX
		End If
		If v.Height > 0 Then
			v.Height = v.Height * cScaleX
		End If
		ScaleAllX(pnl, False)
	Else
		If v.Width > 0 Then
			v.Width = v.Width * cScaleX
		End If
		If v.Height > 0 Then
			v.Height = v.Height * cScaleX
		End If
	End If
	
	If v Is Label Then 'this will catch ALL views with text (EditText, Button, ...)
		Dim lbl As Label = v
		lbl.TextSize = lbl.TextSize * cScaleX
	End If

	If GetType(v) = "anywheresoftware.b4a.objects.ScrollViewWrapper$MyScrollView" Then
		' test if the view is a ScrollView
		' if yes calls the ScaleAll routine with ScrollView.Panel
		Dim scv As ScrollView
		scv = v
		ScaleAllX(scv.Panel, False)
		scv.Panel.Height = scv.Panel.Height * cScaleX
	Else If GetType(v) = "anywheresoftware.b4a.objects.HorizontalScrollViewWrapper$MyHScrollView" Then
		' test if the view is a HorizontalScrollView
		' if yes calls the ScaleAll routine with HorizontalScrollView.Panel
		Dim hcv As HorizontalScrollView
		hcv = v
		ScaleAllX(hcv.Panel, False)
		hcv.Panel.Width = hcv.Panel.Width * cScaleX
	Else If GetType(v) = "flm.b4a.scrollview2d.ScrollView2DWrapper$MyScrollView" Then
		' test if the view is a ScrollView2D
		' if yes calls the ScaleAll routine with ScrollView2D.Panel
'		Dim scv2d As ScrollView2D
'		scv2d = v
'		ScaleAllX(scv2d.Panel, False)
'		scv2d.Panel.Width = scv2d.Panel.Width * cScaleX
'		scv2d.Panel.Height = scv2d.Panel.Height * cScaleX
	Else If GetType(v) = "anywheresoftware.b4a.objects.ListViewWrapper$SimpleListView" Then
		' test if the view is a ListView
		' if yes scales the internal views
		Dim ltv As ListView
		ltv = v
		ScaleViewX(ltv.SingleLineLayout.Label)
		ltv.SingleLineLayout.ItemHeight = ltv.SingleLineLayout.ItemHeight * cScaleX
		
		ScaleViewX(ltv.TwoLinesLayout.Label)
		ScaleViewX(ltv.TwoLinesLayout.SecondLabel)
		ltv.TwoLinesLayout.ItemHeight = ltv.TwoLinesLayout.ItemHeight * cScaleX
		
		ScaleViewX(ltv.TwoLinesAndBitmap.Label)
		ScaleViewX(ltv.TwoLinesAndBitmap.SecondLabel)
		ScaleViewX(ltv.TwoLinesAndBitmap.ImageView)
		ltv.TwoLinesAndBitmap.ItemHeight = ltv.TwoLinesAndBitmap.ItemHeight * cScaleX
		' center the image vertically
		ltv.TwoLinesAndBitmap.ImageView.Top = (ltv.TwoLinesAndBitmap.ItemHeight - ltv.TwoLinesAndBitmap.ImageView.Height) / 2
	Else If GetType(v) = "anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner" Then
		' test if the view is a Spinner
		' if yes scales the internal text size
		Dim spn As Spinner
		spn = v 
		spn.TextSize = spn.TextSize * cScaleX
	End If
End Sub

'Centers horizontally the given view on the screen
Public Sub HorizontalCenter(v As View)
	v.Left = (100%x - v.Width) / 2
End Sub

'Centers horizontally the given view on the screen
'between vLeft and vRight
Public Sub HorizontalCenter2(v As View, vLeft As View, vRight As View)
	v.Left = vLeft.Left + vLeft.Width + (vRight.Left - (vLeft.Left + vLeft.Width) - v.Width) / 2
	If IsActivity(v) Then
		ToastMessageShow("The view is an Activity !", False)
		Return
	Else	
		If IsActivity(vLeft) Then
			If IsActivity(vRight) Then
				v.Left = (100%x - v.Width) / 2
			Else
				v.Left = (vRight.Left - v.Width) / 2
			End If
		Else
			If IsActivity(vRight) Then
				v.Left = vLeft.Left + vLeft.Width + (100%x - (vLeft.Left + vLeft.Width) - v.Width) / 2
			Else
				v.Left = vLeft.Left + vLeft.Width + (vRight.Left - (vLeft.Left + vLeft.Width) - v.Width) / 2
			End If
		End If
	End If
End Sub

'Centers vertically the given view on the screen
Public Sub VerticalCenter(v As View)
	v.Top = (100%y - v.Height) / 2
End Sub

'Centers vertically the given view on the screen
'between vTop and vBottom
Public Sub VerticalCenter2(v As View, vTop As View, vBottom As View)
	If IsActivity(v) Then
		ToastMessageShow("The view is an Activity !", False)
		Return
	Else	
		If IsActivity(vTop) Then
			If IsActivity(vBottom) Then
				v.Top = (100%y - v.Height) / 2
			Else
				v.Top = (vBottom.Top - v.Height) / 2
			End If
		Else
			If IsActivity(vBottom) Then
				v.Top = vTop.Top + vTop.Height + (100%y - (vTop.Top + vTop.Height) - v.Height) / 2
			Else
				v.Top = vTop.Top + vTop.Height + (vBottom.Top - (vTop.Top + vTop.Height) - v.Height) / 2
			End If
		End If
	End If
End Sub

'Set the Left property of the given view 
'according to the given xRight coordinate and the views Width property
Sub SetRight(v As View, xRight As Int)
	v.Left = xRight - v.Width
End Sub

'Set the Top property of the given view 
'according to the given yBottom coordinate and the views Height property
Sub SetBottom(v As View, yBottom As Int)
	v.Top = yBottom - v.Height
End Sub

'Set the view Left and Width properties to fill the space 
'between the two coordinates xLeft and xRight
Public Sub SetLeftAndRight(v As View, xLeft As Int, xRight As Int)
	' take the correct coordinates event if they are permuted
	v.Left = Min(xLeft, xRight)
	v.Width = Max(xLeft, xRight) - v.Left 
End Sub

'Set the view Left and Width properties to fill the space 
'between the two views vLeft and vRight
'if the Left coordinate should be 0 set vLeft to the Activity
'if the Right coordinate should be 100%x set vRight to the Activity
Public Sub SetLeftAndRight2(v As View, vLeft As View, dxL As Int, vRight As View, dxR As Int)
	' return if v is an Activity
	If IsActivity(v) Then
		ToastMessageShow("The view is an Activity !", False)
		Return
	End If
	
	' if vLeft is on the right of vRight pernutates the two views
	If IsActivity(vLeft) = False AND IsActivity(vRight) = False Then
		If vLeft.Left > vRight.Left Then
			Dim v1 As View
			v1 = vLeft
			vLeft = vRight
			vRight = v1
		End If
	End If
	
	If IsActivity(vLeft) Then
		v.Left = dxL
		If IsActivity(vRight) Then
			v.Width = 100%x - dxL - dxR
		Else
			v.Width = vRight.Left - dxL - dxR
		End If
	Else
		v.Left = vLeft.Left + vLeft.Width + dxL
		If IsActivity(vRight) Then
			v.Width = 100%x - v.Left
		Else
			v.Width = vRight.Left - v.Left - dxR
		End If
	End If
End Sub

'Set the view Top and Height properties to fill the space 
'between  the two coordinates yTop and yBottom
Public Sub SetTopAndBottom(v As View, yTop As Int, yBottom As Int)
	' take the correct coordinates event if they are permuted
	v.Top = Min(yTop, yBottom)
	v.Height = Max(yTop, yBottom) - v.Top 
End Sub

'Set the view Top and Height properties to fill the space 
'between the two views vTop and vBottom
'if the Top coordinate should be 0 set vTop to the Activity
'if the Bottom coordinate should be 100%y set vBottom to the Activity
Public Sub SetTopAndBottom2(v As View, vTop As View, dyT As Int, vBottom As View, dyB As Int)
	' return if v is an Activity
	If IsActivity(v) Then
		ToastMessageShow("The view is an Activity !", False)
		Return
	End If
	
	If IsActivity(vTop) = False AND IsActivity(vBottom) = False Then
		' if vTop is below vBottom.Top permutes the two views
		If vTop.Top > vBottom.Top Then
			Dim v1 As View
			v1 = vTop
			vTop = vBottom
			vBottom = v1
		End If
	End If
	
	If IsActivity(vTop) Then
		v.Top = dyT
		If IsActivity(vBottom) Then
			v.Height = 100%y - dyT - dyB
		Else
			v.Height = vBottom.Top - dyT - dyB
		End If
	Else
		v.Top = vTop.Top + vTop.Height + dyT
		If IsActivity(vBottom) Then
			v.Height = 100%y - v.Top - dyB
		Else
			v.Height = vBottom.Top - v.Top - dyB
		End If
	End If
End Sub

'Returns the Right coordinate of the given view
Public Sub Right(v As View) As Int
	Return v.Left + v.Width
End Sub

'Returns the Bottom coordinate of the given view
Public Sub Bottom(v As View) As Int
	Return v.Top + v.Height
End Sub

'Returns True if the view v is a Panel otherwise False
'Needed to check if the view is a Panel or an Activity
Public Sub IsPanel(v As View) As Boolean
	If GetType(v) = "anywheresoftware.b4a.BALayout" Then
		Dim obj As Object
		obj = GetParent(v)
		If GetType(obj) = "android.widget.FrameLayout" Then
			Return False
		Else
			Return True
		End If	
	Else
		Return False
	End If
End Sub

'Returns True If the View v Is an Activity otherwise False
'Needed to check if the view is a Panel or an Activity
Public Sub IsActivity(v As View) As Boolean
	Dim obj As Object
	obj = GetParent(v)
	If GetType(obj) = "android.widget.FrameLayout" Then
		Return True
	Else
		Return False
	End If
End Sub

'Sets new reference screen values
'Default values are Width = 320, Height = 480 Scale = 1
Public Sub SetReferenceLayout(Width As Int, Height As Int, Scale As Double)
	If Width < Height Then
		cRefWidth = Width
		cRefHeight = Height
	Else
		cRefWidth = Height
		cRefHeight = Width
	End If
	cRefScale = Scale
	Initialize
End Sub

Sub GetParent(v As View) As Object
	Dim jobj = v As JavaObject
	Return jobj.RunMethod("getParent", Null)
End Sub