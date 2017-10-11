Type=StaticCode
Version=7.01
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'SizeToFit - Routines to adjust label width, height or fontsize to fit label text + routines to measure text height/width
Sub Process_Globals
	Type SizeToFit_Metrics (Width As Float, Height As Float, Fontsize As Float)
End Sub

'Adjusts the height of a label to fit the label's font and width as follows:
'  If width = 0, uses label width as-is and adjusts height
'  If width > 0, sets label width to given width then adjusts height
'  If width < 0, sets label width to (0 - width), adjusts height, then brings width and height "tight" around the text
'NOTE: To work under Android, the label MUST already have been added to a parent view (e.g. Activity or Panel)
public Sub SizeToFitWidth(aLabel As Label, Width As Float)
	If Not(aLabel.IsInitialized) Then Log("*** ERROR: Label is not initialized")
	If aLabel.Parent = Null Then  Log("*** ERROR: Label does not have a Parent (to be able to size it properly)")
	If Not(aLabel.IsInitialized) Or aLabel.Parent = Null Then Return
	
	If Width <> 0 Then aLabel.Width = Abs(Width)
#If B4i
	aLabel.SizeToFit
#Else
	Private su As StringUtils
	aLabel.Height = su.MeasureMultilineTextHeight(aLabel, aLabel.Text)
	If Width < 0 Then
		'Search for a solution with same height but narrower width
		Dim Height As Float = aLabel.Height
		Dim OKWidth As Float = aLabel.Width
		Dim maxWidth As Float = aLabel.Width
		aLabel.Width = aLabel.Width * 2 / 3
		Do While su.MeasureMultilineTextHeight(aLabel, aLabel.text) = Height And aLabel.width > 1
			maxWidth = aLabel.Width
			aLabel.Width = aLabel.Width * 2 / 3
		Loop
		Dim minWidth As Float = aLabel.Width
		Dim i As Int = 0
		Do While Floor(minWidth) <= Floor(maxWidth) And i <= 20
			aLabel.Width = minWidth + ((maxWidth - minWidth) / 2)
			If su.MeasureMultilineTextHeight(aLabel, aLabel.text) > Height Then
				minWidth = aLabel.Width + 1
			Else
				OKWidth = aLabel.Width 'Keep track of a width that worked
				maxWidth = aLabel.Width - 1
			End If
			i = i + 1
		Loop
		If i > 20 Then Log($"WARNING: Exceeded 20 iterations: ${minWidth} <= ${aLabel.Width} <= ${maxWidth} == ${aLabel.Height} (${Height})"$)
		aLabel.Width = OKWidth
	End If
#End If
End Sub

'Adjusts the width of a label to fit the label's font and height as follows:
'  If height = 0, uses label height as-is and adjusts width
'  If height > 0, sets label height to given height then adjusts width
'  If height < 0, sets label height to (0 - height), adjusts width, then brings width and height "tight" around the text
'NOTE: To work under Android, the label MUST already have been added to a parent view (e.g. Activity or Panel)
public Sub SizeToFitHeight(aLabel As Label, Height As Float)
	If Not(aLabel.IsInitialized) Then Log("*** ERROR: Label is not initialized")
	If aLabel.Parent = Null Then  Log("*** ERROR: Label does not have a Parent (to be able to size it properly)")
	If Not(aLabel.IsInitialized) Or aLabel.Parent = Null Then Return
	
	Dim bShowDetail As Boolean = False
	If Height = 0 Then Height = aLabel.Height
	Dim absHeight As Float = Abs(Height)
	'Find unconstrained Width & Height
	SizeToFitWidth(aLabel, -30000)
	If aLabel.Height < absHeight Then 'If label height is less than height, we can try decreasing width to increase height further
		'Decrease width until Height goes above target
		Dim MaxWidth, TryWidth As Float
		Dim OKWidth As Float = aLabel.Width
		Dim MinWidth As Float = Ceil(aLabel.Width)
		If bShowDetail Then Log($"${MinWidth} <= ${TryWidth} <= ${MaxWidth} == ${aLabel.Height} (${Height}) - increase width"$)
		Do While aLabel.Height < absHeight And MinWidth > 1
			MaxWidth = Ceil(MinWidth)
			MinWidth = MinWidth / 2
			SizeToFitWidth(aLabel, MinWidth)
			If bShowDetail Then Log($"${MinWidth} <= ${TryWidth} <= ${MaxWidth} == ${aLabel.Height} (${Height})"$)
		Loop
		If MinWidth > 1 Then
			'Now we have minWidth and maxWidth surrounding the optimum width for the given height
			Dim i As Int = 0
			Do While Floor(MinWidth) <= Floor(MaxWidth) And i <= 20
				TryWidth = MinWidth + ((MaxWidth - MinWidth) / 2)
				SizeToFitWidth(aLabel, TryWidth)
				If bShowDetail Then Log($"${MinWidth} <= ${TryWidth} <= ${MaxWidth} [${OKWidth}] == ${aLabel.Height} (${Height})"$)
				If aLabel.Height = absHeight Then
					Exit
				Else If aLabel.Height < absHeight Then
					'Too short, make it narrower
					OKWidth = TryWidth 'Keep track of a width that worked
					MaxWidth = TryWidth - 1
				Else
					'Too tall, make it wider
					MinWidth = TryWidth + 1
				End If
				i = i + 1
			Loop
		End If
		If i > 20 Then Log($"WARNING: Exceeded 20 iterations: ${MinWidth} <= ${TryWidth} <= ${MaxWidth} == ${aLabel.Height} (${Height})"$)
		'Make sure label is returned sized using OKWidth
		If Height < 0 Then OKWidth = 0 - OKWidth
		SizeToFitWidth(aLabel, OKWidth)
	End If
End Sub

'Adjusts a label's font size to fit the given text within the label's width/height.
'Text is any object that can be assigned to label.text (e.g. String, CSbuilder)
'NOTE: To work under Android, the label MUST already have been added to a parent view (e.g. Activity or Panel)
public Sub SizeFontToFit(aLabel As Label, Text As Object)
	If Not(aLabel.IsInitialized) Then Log("*** ERROR: Label is not initialized")
	If aLabel.Parent = Null Then  Log("*** ERROR: Label does not have a Parent (to be able to size it properly)")
	If Not(aLabel.IsInitialized) Or aLabel.Parent = Null Then Return
	
	Dim bShowDetail As Boolean = False
	Dim Width As Float = aLabel.Width
	Dim Height As Float = aLabel.Height
	Dim TrySize As Float
	aLabel.Text = Text
	SizeToFitWidth(aLabel, Width)
	If aLabel.Height = Height Then
		Return
	Else If aLabel.Height > Height Then
		'Need to adjust font size smaller
		Dim MinSize As Float = getFontSize(aLabel)
		Do While aLabel.Height >= Height And MinSize > 1
			Dim MaxSize As Float = MinSize
			MinSize = MinSize / 3 * 2
			setFontSize(aLabel, MinSize)
			SizeToFitWidth(aLabel, Width)
			If bShowDetail Then Log($"${MinSize} <= ${TrySize} <= ${MaxSize} vvv ${MinSize})"$)
		Loop
	Else
		'Need to adjust font size larger
		Dim MaxSize As Float = getFontSize(aLabel)
		Do While aLabel.Height <= Height And MaxSize < 500
			Dim MinSize As Float = MaxSize
			MaxSize = MaxSize * 3 / 2
			setFontSize(aLabel, MaxSize)
			SizeToFitWidth(aLabel, Width)
			If bShowDetail Then Log($"${MinSize} <= ${TrySize} <= ${MaxSize} ^^^ ${MaxSize})"$)
		Loop
	End If
	If MinSize > 1 And MaxSize < 500 Then
		'We have MinSize and MaxSize surrounding the optimum size - use binary partitioning to find size where text fits into the given height/width
		Dim i As Int = 0
		Do While Floor(MinSize * 10) <= Floor(MaxSize * 10) And i <= 20
			TrySize = MinSize + ((MaxSize - MinSize) / 2)
			setFontSize(aLabel, TrySize)
			SizeToFitWidth(aLabel, Width)
			If bShowDetail Then Log($"${MinSize} <= ${TrySize} <= ${MaxSize} ... ${TrySize})"$)
			If aLabel.Height >= Height Then
				MaxSize = TrySize - 0.1
			Else
				MinSize = TrySize + 0.1
			End If
			i = i + 1
		Loop
		If i > 20 Then Log($"WARNING: Exceeded 20 iterations: ${MinSize} <= ${TrySize} <= ${MaxSize})"$)
	End If
End Sub

'Given a label with Text, Font/size and Multiline (IOS) set, return Width/Height/Fontsize that will ensure the text fits within the label
'  If Width > 0, Height will be adjusted to fit the text into a label
'  If Height > 0, Width will be adjusted to fit the text into a label
'  If Width > 0 and Height > 0, Fontsize will be adjusted to fit the text into a label
'NOTE: Will work under Android or IOS *without* the label being added to a parent view (e.g. Activity or Panel)
Public Sub MeasureExpectedSize(aLabel As Label, Width As Float, Height As Float) As SizeToFit_Metrics
	Dim myLabel As Label
	Dim myMetrics As SizeToFit_Metrics
	myLabel.Initialize("")
	myLabel.Text = aLabel.Text
	myLabel.Visible = False
#If B4i
	myLabel.Font = aLabel.Font
	myLabel.Multiline = aLabel.Multiline
#Else
	myLabel.Typeface = aLabel.Typeface
	myLabel.TextSize = aLabel.TextSize
	myLabel.Padding = aLabel.Padding
	myLabel.Enabled = False
	getCurrentActivity.AddView(myLabel, 0, 0, 1dip, 1dip)
#End If
	If Width <> 0 And Height <> 0 Then
		myLabel.Width = Abs(Width)
		myLabel.Height = Abs(Height)
		SizeFontToFit(myLabel, myLabel.Text)
	Else if Width <> 0 Then
		SizeToFitWidth(myLabel, Width)
	Else
		SizeToFitHeight(myLabel, Height)
	End If
	myMetrics.Width = myLabel.Width
	myMetrics.Height = myLabel.Height
	myMetrics.Fontsize = getFontSize(myLabel)
#If B4a
	myLabel.RemoveView
#End If
	Return myMetrics
End Sub

'Platform independent way to get Font Size
Public Sub getFontSize(aLabel As Label) As Float
#If B4i
	Return aLabel.Font.Size
#Else
	Return aLabel.TextSize
#End If	
End Sub

'Platform independent way to set Font Size
Public Sub setFontSize(aLabel As Label, Size As Float)
#If B4i
	aLabel.Font = Font.CreateNew2(aLabel.Font.Name, Size)
#Else
	aLabel.TextSize = Size
#End If	
End Sub

#If B4a
Sub getCurrentActivity As Activity
   Dim r As Reflector
   r.Target = r.GetActivityBA
   Return r.GetField("vg")   
End Sub
#End If