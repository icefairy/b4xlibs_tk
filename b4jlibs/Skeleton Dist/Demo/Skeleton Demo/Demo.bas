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
	h.Initialize
	f.Initialize
End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)	
	Dim skc1 As SK_Column	
	skc1.Initialize(12)
	skc1.AddHeader(2,"A dead simple, responsive boilerplate.")
	skc1.AddAnchorButton("Download",True,"https://github.com/dhg/Skeleton/releases/download/2.0.4/Skeleton-2.0.4.zip")
	
	Dim row1 As SK_Row
	row1.Initialize
	row1.Columns.Initialize
	row1.Columns.Add(skc1)
	
	Dim skc2a As SK_Column
	Dim skc2b As SK_Column
	Dim skc2c As SK_Column
	
	skc2a.Initialize(4)
	skc2b.Initialize(4)
	skc2c.Initialize(4)
	
	skc2a.AddImage("images/feather.svg")
	skc2a.AddContent("Light as a feather at ~400 lines & built with mobile in mind.")
	
	skc2b.AddImage("images/pens.svg")
	skc2b.AddContent("Styles designed to be a starting point, not a UI framework.")
	
	skc2c.AddImage("images/watch.svg")
	skc2c.AddContent("Quick to start with zero compiling or installing necessary.")
	
	Dim row2 As SK_Row
	row2.Initialize
	row2.Columns.Initialize
	row2.Columns.Add(skc2a)
	row2.Columns.Add(skc2b)
	row2.Columns.Add(skc2c)
	
	Dim c1 As SK_Container
	c1.Initialize
	c1.Align = "center"
	c1.MarginTop = 18
	c1.Rows.Initialize
	c1.Rows.Add(row1)

	Dim c2 As SK_Container
	c2.Initialize
	c2.Align = "center"
	c2.MarginTop = 3
	c2.Padding = 1
	c2.Rows.Initialize
	c2.Rows.Add(row2)
	
	Dim S As SkeletonPage	
	S.Initialize
	'S.AddScript("<link rel=""stylesheet"" href=""css/custom.css"">",True)
	S.AddContainer(c1)
	S.AddContainer(c2)
	resp.Write(S.Render)	
End Sub