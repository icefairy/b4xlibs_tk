Type=Class
Version=5.8
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Handler class
Sub Class_Globals
	Dim h As SK_Helper
	Dim f As SK_FontAwesomeIcon
End Sub

Public Sub Initialize
	
End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)
	h.Initialize
	f.Initialize
	
	Dim skc1 As SK_Column
	Dim skc2 As SK_Column
	
	Dim S As SkeletonPage
	S.Initialize
	S.Author = "Author"
	S.Description = "Description"
	S.Title = "Title"
	
	skc1.Initialize(6)
	
	skc1.AddHeader(1,"Column 1")
	skc1.AddContent("This page is a placeholder.")
	skc1.AddAlert("Error","Help help","error")
	skc1.AddAlert("Success","Win Win","success")
	skc1.AddContent("Some normal content")
	
	skc1.AddHTML(h.HTMLFontAwesome(f.fa_camera,0,False,""))
	skc1.AddHTML(h.HTMLFontAwesome(f.fa_camera,1,False,""))
	skc1.AddHTML(h.HTMLFontAwesome(f.fa_camera,2,False,""))
	skc1.AddHTML(h.HTMLFontAwesome(f.fa_camera,3,False,""))
	skc1.AddHTML(h.HTMLFontAwesome(f.fa_camera,4,False,""))
	skc1.AddHTML(h.HTMLFontAwesome(f.fa_camera,5,False,"#33C3F0"))
	
	skc1.AddBreak
	
	skc1.AddHTML(h.HTMLFontAwesome(f.fa_address_book,0,True,""))
	skc1.AddHTML(h.HTMLFontAwesome(f.fa_address_book,1,True,""))
	skc1.AddHTML(h.HTMLFontAwesome(f.fa_address_book,2,True,""))
	skc1.AddHTML(h.HTMLFontAwesome(f.fa_address_book,3,True,""))
	skc1.AddHTML(h.HTMLFontAwesome(f.fa_address_book,4,True,""))
	skc1.AddHTML(h.HTMLFontAwesome(f.fa_address_book,5,True,"blue"))
	
	skc1.AddCode(".some-class {  background-color: red;}")
	
	skc2.Initialize(6)
	skc2.Size = 6
	skc2.AddHeader(4,"Column 2")
	skc2.AddContent("This page is a placeholder.")

	skc2.AddButton("Test",True,"")
	skc2.AddInputButton("Test",True,True)
	skc2.AddInputButton("Test",True,False)
	skc2.AddAnchorButton("Test",True,"#")
	
	skc2.AddBreak
	
	skc2.AddButton("Test",False,"")
	skc2.AddInputButton("Test",False,True)
	skc2.AddInputButton("Test",False,False)
	skc2.AddAnchorButton("Test",False,"#")
	
	Dim l As List = Array("List item 1","List item 2","List item 3","List item 4")
	
	skc2.AddList(l,False)
	skc2.AddList(l,True)
	
	Dim skc3 As SK_Column
	skc3.Initialize(12)
	skc3.Size = 12
	
	Dim skTable As SK_Table
	skTable.Initialize
	
	Dim Header As List = Array("Name", "Age", "Sex", "Location")
	Dim Row1 As List = Array("Dave Gamache", "26", "Male", "San Francisco")
	Dim Row2 As List = Array("Dwayne Johnson", "42", "Male", "Hayward")
	
	skTable.Header = Header
	
	skTable.Rows.Initialize
	skTable.Rows.Add(Row1)
	skTable.Rows.Add(Row2)
	
	skc3.AddHeader(1,"Tables")
	
	'<Header>
	'<div class="container">
	'  <!-- menu bar goes here -->
	'</div>
	'</Header>

	skc3.AddContent("Be sure to use properly formed table markup with <thead> and <tbody> when building a table")
	skc3.AddTable(skTable)
	
	Dim r1 As SK_Row
	r1.Initialize
	r1.Columns.Initialize
	r1.Columns.Add(skc1)
	r1.Columns.Add(skc2)
	
	Dim r2 As SK_Row
	r2.Initialize
	r2.Columns.Initialize
	r2.Columns.Add(skc3)
	
	Dim c1 As SK_Container
	c1.Initialize
	c1.Align = "right"
	c1.Padding = 6
	c1.Rows.Initialize
	c1.Rows.Add(r1)
	
	Dim c2 As SK_Container
	c2.Initialize
	c2.Background = "http://getskeleton.com/examples/landing/images/values-bg.jpg"
	'c2.Background = "#33C3F0"
	c2.Color = "#FFFFFF"
	c2.Align = "center"
	c2.Padding = 6
	c2.Rows.Initialize
	c2.Rows.Add(r2)
	
	S.AddContainer(c1)
	S.AddContainer(c2)
	
	'S.IncludeCSSFontRaleway = False
	'S.IncludeCSSSkeleton = False
	'S.IncludeCSSNormalize = False
	'S.IncludeCSSSkeletonAlerts = False
	'S.IncludeCSSFontawesome = False
	
	resp.Write(S.Render)
End Sub