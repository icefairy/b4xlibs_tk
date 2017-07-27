Type=Class
Version=5.8
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Handler class
Sub Class_Globals
	
End Sub

Public Sub Initialize
	
End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)
	Dim S As SkeletonPage

	Dim skc1 As SK_Column
	
	skc1.Initialize(7)
	skc1.AddHeader(1,"Header 1")
	skc1.AddHeader(2,"Header 2")
	skc1.AddHeader(3,"Header 3")
	skc1.AddHeader(4,"Header 4")
	skc1.AddContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")

	Dim skc2 As SK_Column
	
	skc2.Initialize(5)
	skc2.AddHeader(1,"Header 1")
	skc2.AddHeader(2,"Header 2")
	skc2.AddHeader(3,"Header 3")
	skc2.AddHeader(4,"Header 4")
	skc2.AddContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
		
	Dim r As SK_Row
	r.Initialize
	r.Columns.Initialize
	r.Columns.Add(skc1)
	r.Columns.Add(skc2)
	
	Dim c As SK_Container
	c.Initialize
	c.Rows.Initialize
	c.Rows.Add(r)
	
	S.Initialize
	S.AddContainer(c)
	
	resp.Write(S.Render)
End Sub