Type=Class
Version=3
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'Implementation of a ComboBox object written by Derek Johnson - Oct 2015 
'If you find this useful please 'Like' the posting.
'Feel free to modify or add features - please post any enhancements etc to the forum
'The main aim of this class is to make it possible to define a set of layouts including Combo boxes in Designer
'TextFields are used as place holders for the Combo boxes that use their properties

private Sub Class_Globals
	
	Private objAnchor As TextField 'Used to position dropdown and arrow
	Private c_objParentPanel As Panel 'Needed when working out how many dropdown rows will fit on textboxes's panel

	Private p_TableView As TableView 'Used as the dropdown
	Private p_imgArrow As ImageView 'Used to display Up/Down arrow
	Private p_bm_arrow As Bitmap 'Copy of bit map passed to init
	
	Private c_DropDownRows As Int
	Private c_RelDropHeight As Float
	Private c_DropHeight As Int  'Actual height to be used by the dropbox
	Private c_Dropped As Boolean = False 'Indicated whether the dropbox is shown
	Private c_TextTag As String ="Not set" 'Used to save the previous tag from the textbox
	Private c_Font As Font 'Font used in TextField

	Private h_Colorlist As List
	Private h_TextColor As  Colors
	Private h_RowHeight As Int
	Private h_Font As Font 'Subtitle font
	
	Private h_SectionList As List 'Listy of section headers - needed when device is rotated
	
	Dim myList As List
End Sub

	
'The combo object consists of a Textfield box, a dropdown bitmap, and a TableView.
'<b>myText</b> is the pre-existing Textfield used to display the results of the selection and acts as an anchor and size reference for the dropdown
'<b>RelativeDropDownRowHeight</b> is the factor by which rows in the dropdown are bigger than that of the text box height
'<b>DropDownRows</b> is the number of rows to display when the combo box is dropped down

Public Sub Initialize(myText As TextField,RelativeDropDownRowHeight As Float, DropDownRows As Int,ArrowBitMap As Bitmap) 
	
	'The text box is used as an anchor to set the position etc of the Tableview etc
	objAnchor=myText
	c_Font=objAnchor.Font
	
	h_Font=objAnchor.Font
	
	h_RowHeight=objAnchor.Height
	h_TextColor=Colors.Black
	
	h_Colorlist.Initialize
	h_Colorlist.Clear
	'default Colors - h_Colorlist - A list containing color values
	h_Colorlist.Add(Colors.RGB(240,240,240))
	'h_Colorlist.Add(Colors.RGB(180,180,180))
	
	h_SectionList.Initialize
	h_SectionList.Clear
	
	c_DropDownRows=DropDownRows
	c_RelDropHeight=RelativeDropDownRowHeight
	'In the event that the object is re-initialised , the saved object will be re-extracted from the text view
	'This rather odd looking code is used to save/restore the class objects p_tableview and p_imgArrow
	'to/from a list object in the MyText tag
	If myText.IsInitialized=False Then
		Log("TextField is not initialised")
		Return
	End If 

	If myText.tag Is List Then 'Have already created the objects so get back references to them
		myList=myText.tag
		p_TableView=myList.Get(1)
		p_imgArrow=myList.Get(2)
	Else 'Initialise the objects and save them in the textboxes's tag field
		'Note that the events for the tableview and imageview are processed WITHIN the Class Module 
		p_TableView.Initialize("Table",False)
		p_TableView.SetBorder(1,Colors.black,5)
		p_TableView.Visible=False
		p_imgArrow.Initialize("Arrow")
		'Save the original tag - should contain the name of the combo box (if set in Designer)
		c_TextTag=myText.tag
		'Save the class object in the external object
		myList.Initialize
		myList.Add(myText.Tag) 'Save the original tag as item 0
		myList.Add(p_TableView)
		myList.Add(p_imgArrow)
		myText.Tag=myList
	End If
	
	Dim vTop=objAnchor.Top As Int
	Dim vLeft=objAnchor.left As Int
	Dim vWidth=objAnchor.Width As Int
	Dim vHeight=objAnchor.height As Int
	p_imgArrow.SetBorder(1,Colors.Transparent,5)
	
	p_bm_arrow=ArrowBitMap
	p_imgArrow.Bitmap=p_bm_arrow
	
	Dim no As NativeObject = objAnchor
	Dim Parent = no.GetField("superview")	As View
	c_objParentPanel= Parent
	'Arrow needs to be a bit smaller than the text height 
	c_objParentPanel.Addview(p_imgArrow,vLeft+vWidth-objAnchor.height+3,vTop+2,vHeight-4,vHeight-4)
	'c_objParentPanel.Addview(p_imgArrow2,vLeft+vWidth-objAnchor.height+200,vTop+2,vHeight-4,vHeight-4)
	
	p_imgArrow.BringToFront

	'Add the tableview
	c_objParentPanel.AddView(p_TableView,vLeft,vTop+objAnchor.Height,vWidth,vHeight)
	Return
End Sub


private Sub LoadImage(im As ImageView,bm As Bitmap,Angle As Int)                                                                        
    Dim Rect1 As Rect
	Dim canvas1 As Canvas
    canvas1.Initialize(im)
    Rect1.Initialize(0, 0, im.Width, im.Height )
    canvas1.DrawBitmapRotated(bm, Rect1, Angle)   
    canvas1.Refresh
	canvas1.Release
End Sub

'Set/Get the font used for the dropdown items
public Sub setFont(NewFont As Font)
	c_Font=NewFont
	
End Sub


public Sub getFont As Font
	Return c_Font
End Sub
	
'This returns the original tag of the text object on which the combo box is based
Public Sub getTag As String
	Return c_TextTag
End Sub
	
	
'This resizes the combo box according to the dimensions of the text anchor object
'You should call this in the Page_Resize event for the page containing the combo box
Sub ReSize
	'Calculate how many rows would fit to the bottom of the parent from where the anchor is now, and adjust if necessary
	Dim no As NativeObject = objAnchor
	Dim Parent = no.GetField("superview")	As View
	c_objParentPanel= Parent
	'Prevent dropdown extending beyond the bottom of the screen/panel - it must be possible to select the last item!
	Dim i As Int
	For i =1 To 2
		Dim Space As Int = c_objParentPanel.Height-objAnchor.Top
		Dim RowHeight As Int = objAnchor.height*c_RelDropHeight
		Dim PossRows As Int =Floor(Space/RowHeight)-1 
		Dim dropdownrows=Max(1,Min(PossRows,c_DropDownRows)) As Int
		
'		Log($"==================
'	Item: ${c_TextTag} Pass: ${i} Requested Rows: ${c_DropDownRows}
'	
'	Parent Panel Height: ${c_objParentPanel.Height}
'	Top of TextBox: ${objAnchor.Top}
'	Space:  	${Space}
'	RowHeight:	${RowHeight}
'	PossRows:	${PossRows}
'	Final Rows:	${dropdownrows}
'		"$)

		If dropdownrows<3 Then
			'Log("	Reduced height of " &  c_TextTag & " dropdown to standard ")
			c_RelDropHeight=Min(c_RelDropHeight,1.0)
		Else
			Exit 
		End If
	Next 
	c_DropHeight=dropdownrows*RowHeight

	p_TableView.RowHeight=RowHeight
	h_RowHeight=RowHeight
	
	
	p_TableView.Visible=False
	p_TableView.Width=objAnchor.width
	p_TableView.left=objAnchor.left
	p_TableView.top=objAnchor.top+objAnchor.height
	p_TableView.height=dropdownrows*objAnchor.height
	p_TableView.BringToFront
	
	p_imgArrow.SetBorder(1,Colors.Transparent,5)
	p_imgArrow.Bitmap=p_bm_arrow
	p_imgArrow.BringToFront
	p_imgArrow.Top=objAnchor.top+2
	p_imgArrow.Height=objAnchor.Height-4
	p_imgArrow.width=objAnchor.Height-4
	p_imgArrow.left=objAnchor.Left+objAnchor.Width-p_imgArrow.width-2
	
	'Resize the SectionHeaders
	Dim s As Int
	For s=0 To h_SectionList.Size-1 Step 2
		Dim p As Panel, lbl As Label
		p=h_SectionList.Get(s)
		lbl=h_SectionList.Get(s+1)
		p.Width=objAnchor.width
		p.Height=RowHeight
		lbl.Width=p.Width
		lbl.Height=p.Height
			
	Next


End Sub

'Returns the TableView object associated with this combo box
'You can then set the properties etc directly eg Alpha
Public Sub getTableView As TableView
	Return p_TableView
End Sub


'Event handler for 
private Sub Table_SelectedChanged (SectionIndex As Int, Cell As TableCell)
	'Dim v As TableView
	'v=Sender
	'This also gets the selected item
	'log("Sender: Text " & v.SelectedRow.Text.tostring)
	
	'Log("Selected Changed: " & Cell.Text.tostring)
	objAnchor.Text=Cell.Text.tostring
	Arrow_Click
	'Can call subs in main here if you want
	Main.ComboSelected(Cell.Text.tostring,objAnchor)
	
End Sub

'This will add a list of items with a section header
'If the StdIcon bitmap is initialised this bitmap will be added to all the list items
Sub AddSection(SectionHeader As String,items As List,IndentLevel As Int,StdIcon As Bitmap)
	
	InsertHeader(SectionHeader)

	Dim i As Int
	'Log("========= Adding Section " & p_TableView.NumberOfSections & " " & SectionHeader & "=================")
	If items Is List Then
		For i = 0 To items.Size-1
			Dim Item As String=items.Get(i)
			Dim tc As TableCell = p_TableView.AddSingleLine(Item)
			
			Dim AttString As AttributedString
			AttString.Initialize(Item,c_Font,objAnchor.TextColor)
			tc.Text=AttString
			tc.IndentationLevel=IndentLevel
			tc.Tag=""
			Try
				If StdIcon.IsInitialized Then tc.Bitmap = StdIcon
			Catch
				rLog("Image not found: "  & LastException.Description)
			End Try	
		Next
	End If
	p_TableView.ReloadAll
End Sub

'Splits up a color into its components
private Sub GetARGB(Color As Int) As Int()
    Dim res(4) As Int
    res(0) = Bit.UnsignedShiftRight(Bit.And(Color, 0xff000000), 24)
    res(1) = Bit.UnsignedShiftRight(Bit.And(Color, 0xff0000), 16)
    res(2) = Bit.UnsignedShiftRight(Bit.And(Color, 0xff00), 8)
    res(3) = Bit.And(Color, 0xff)
    Return res
End Sub

'Returns a darker (or lighter) shade of the specified colour  (+40 seems to work nicely)
'The shift amount is subtracted from each of the existing R G B values, making it darker for positive shift values
private Sub DarkerShade(BaseColor As Colors,shift As Int) As Colors
	
    Dim i, argb() As Int
    argb = GetARGB(BaseColor)
	For i=1 To 3
		argb(i)=Max(0,Min(255,argb(i)-shift))
	Next
	Return Colors.RGB(argb(1),argb(2),argb(3))
End Sub


private Sub SetGradient(pnl As Panel,ColorList As List)
	'Log("Setting Gradient in " & c_TextTag  & 	" using " & ColorList.Size & " colors")
	If ColorList.Size=0 Then Return
	If ColorList.size=1 Then
		pnl.Color=ColorList.Get(0)
		Return
	End If
    Dim cv As Canvas
    cv.Initialize(pnl)
    cv.FillGradient(pnl.width/2,0,pnl.width/2,pnl.height,ColorList)
    cv.Refresh
End Sub

private Sub InsertHeader(SectionHeader As String)
	
	'This creates an invisible section divider and increments the section number
	p_TableView.AddSection("","")
	
	Dim tc As TableCell = p_TableView.AddSingleLine("")
	tc.Bitmap=Null
	tc.ShowSelection = False
	
	Dim p As Panel
	p.Initialize("")
	p.Width = objAnchor.Width
	p.Height = h_RowHeight
	p.Tag="Header"
	p.Color=Colors.white
	SetGradient(p,h_Colorlist)


	Dim lblSection As Label 
	'Can set these as required
	'lblSection.Initialize("Header")
	lblSection.Initialize("")
	lblSection.Text=SectionHeader

	lblSection.Color=Colors.Transparent
	lblSection.Height=h_RowHeight
	lblSection.TextColor=h_TextColor
	lblSection.Font=h_Font
	
	p.AddView(lblSection,10dip,0,p.Width,p.Height)
	tc.CustomView = p
	
	'Keep copies of these so that they can be resized if the combo ir rotated/moved
	h_SectionList.Add(p)
	h_SectionList.Add(lblSection)
	
End Sub
	
'private Sub Header_Click
'	Dim Hdr As Label = Sender
'	Log("Header clicked: " & Hdr.Text & " in "  & c_TextTag)
'
'End Sub


'Sets the Font used in Section Headers (see also 
public Sub setSectionHeaderFont(Myfont As Font)
	h_Font=Myfont
End Sub

public Sub setSectionTextColor(TextColor As Colors)
	h_TextColor=TextColor
End Sub

public Sub setSectionHeaderColors(ColorList As List)

'	Dim i As Int
'	For i=0 To ColorList.Size-1
'		Log("Color " & i & " Value " & ColorList.Get(i))
'	Next
 	
	h_Colorlist.Initialize
	h_Colorlist.clear
	h_Colorlist=ColorList

End Sub

'This will add (or replace) the existing images in the specified SectionIndex with the bitmaps in the specified list
'SectionIndex is the number of the section to which the Images will be added
'Bitmaps is a list containing preloaded bitmaps. You can use Null elements to prevent the corresponding item from being changed
Sub AddBitMapsToSection(SectionIndex As Int,Bitmaps As List)
	Dim i As Int,  SectionList As List
		
	SectionList=p_TableView.GetItems(SectionIndex)
	For i = 0 To Min(Bitmaps.Size-1,SectionList.Size-2)
		Try
			Dim bm = Bitmaps.Get(i)  As Bitmap
			If bm Is Bitmap Then
				Dim tc As TableCell =  SectionList.Get(i+1)
				If tc.Tag<>"Header" Then tc.Bitmap=bm
			End If
		Catch
			rLog("BitMap "  & i  & " not found: "  & LastException.Description)
		End Try	
	Next
	p_TableView.ReloadAll
	
End Sub


'This will add (or replace) the existing images in the specified SectionIndex with the files from the specified list
'SectionIndex is the number of the section to which the Images will be added
'Dir is the folder in which the files reside e.g. Files.DirAssets etc
'FileNames is a list containing filenames eg array("abc.png","pqr.png").  You can use Null or Empty elements to prevent the corresponding item from being changed
Sub AddBitMapsFromFileList(SectionIndex As Int,Dir As String,FileNames As List)
	Dim i As Int,  SectionList As List
		
	SectionList=p_TableView.GetItems(SectionIndex)
	For i = 0 To Min(FileNames.Size-1,SectionList.Size-2)
		Try
			Dim FileName As String = FileNames.Get(i)
			'Log("Filename: " & FileName)
			If FileName<>"" And FileName<>"null" Then 
				If  File.Exists(Dir,FileName) Then
					Dim bm As Bitmap = LoadBitmap(Dir,FileNames.Get(i))
					Dim tc As TableCell =  SectionList.Get(i+1)
					If tc.Tag<>"Header" Then tc.Bitmap=bm
				Else 
					rLog("Error loading files from list File '" & FileNames.Get(i) & "' not found.")
				End If
				
			End If	
		Catch
			rLog("BitMap "  & i  & " not loaded: "  & LastException.Description)
		End Try	
	Next
	p_TableView.ReloadAll
	
End Sub



'Section numbers start at Zero
'NB This will NOT change the section numbering - the same section will exist but will just be invisible
Sub RemoveSectionData(SectionNumber As Int)
	Log("Removing data from section number " & SectionNumber & " from " & c_TextTag)
	If SectionNumber>p_TableView.NumberOfSections-1 Then
		Log("Section number " & SectionNumber & " greater than number of sections " & p_TableView.NumberOfSections)
		Return
	End If
	Try
		'This removes the section data (but not the Section Header)
		Dim SectionList = p_TableView.GetItems(SectionNumber) As List
		SectionList.Clear
		'p_TableView.ReloadSection(SectionNumber)
		p_TableView.ReloadAll
	Catch
		Log(LastException)
	End Try
	
End Sub

'This will add a one line item to the end of the combo-box
'If the image is initialised with a bitmap, then it will be added to the element
Sub AddSingleLine(itemtext As String,image As Bitmap)
	Dim tc As TableCell = p_TableView.AddSingleLine(itemtext)
	If image.IsInitialized Then
		tc.Bitmap = image
	End If
	p_TableView.ReloadSection(p_TableView.NumberOfSections-1)
End Sub

'This will add a two line item to the end of the combo-box
'If the image is initialised with a bitmap, then it will be added to the element
Sub AddTwoLines(itemtext1 As String,itemtext2 As String,image As Bitmap)
	Dim tc As TableCell = p_TableView.AddTwoLines(itemtext1,itemtext2)
	If image.IsInitialized Then
		tc.Bitmap = image
	End If
	p_TableView.ReloadSection(p_TableView.NumberOfSections-1)
End Sub

private Sub Arrow_Click
	c_Dropped=Not(c_Dropped)
	objAnchor.ResignFocus
	
	p_imgArrow.Bitmap=p_bm_arrow
	
	If c_Dropped Then
		ReSize
		p_TableView.Visible=True
		p_TableView.Height=c_DropHeight
		p_TableView.BringToFront
		p_imgArrow.Bitmap=Null
		LoadImage(p_imgArrow,p_bm_arrow,180)
	Else
 		p_TableView.Visible=False
	End If	
End Sub

'The entire combobox elements are either displayed or hidden 
public Sub setVisible(IsVisible As Boolean)
	objAnchor.ResignFocus
	objAnchor.Visible=IsVisible
	p_imgArrow.Visible=IsVisible
	
	If IsVisible =False Then
		p_TableView.Visible=False
	Else
		If c_Dropped Then
			p_TableView.Visible=True
		Else	
			p_TableView.Visible=False
		End If
	End If

End Sub
	
public Sub getVisible  As Boolean
	Return objAnchor.Visible 
End Sub

'Returns the currently selected string associated with the combobox
public Sub Selection As String
	Return p_TableView.SelectedRow.Text.ToString
End Sub

'This clears everything including the headers from the tableview
Sub Clear
	p_TableView.Clear
	'Log("Cleared. No of sections left: " & p_TableView.NumberOfSections)
	objAnchor.Text=""
	objAnchor.ResignFocus
	If c_Dropped Then Arrow_Click
	'Log("Cleared All")
End Sub


private Sub rLog(msg As String)
	LogColor(msg,Colors.red)
End Sub

'Sub GetTopItem(Table As TableView) As Int()
'   Dim no As NativeObject = Table
'   no = no.RunMethod("indexPathsForVisibleRows", Null).RunMethod("objectAtIndex:", Array(0))
'   Return Array As Int(no.GetField("section").AsNumber, no.GetField("row").AsNumber)
'End Sub

