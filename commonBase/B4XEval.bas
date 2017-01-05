Type=Class
Version=3
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'version 1.01
Sub Class_Globals
	Private Const NUMBER_TYPE = 1, OPERATOR_TYPE = 2 As Int
	Type ParsedNode (Operator As String, Left As ParsedNode, Right As ParsedNode, _
		NodeType As Int, Value As Double)
	Type OrderData (Index As Int, Level As Int, Added As Int)
	Private root As ParsedNode
	Private ParseIndex As Int
	Private Nodes As List
	Private OperatorLevel As Map
End Sub

Public Sub Initialize
	OperatorLevel = CreateMap("+": 1, "-": 1, "*":2, "/": 2)
End Sub

Public Sub Eval(Expression As String) As Double
	ParseIndex = 0
	Dim root As ParsedNode
	root.Initialize
	Dim expr As String = "(" & Expression.Replace(" ", "").ToLowerCase & ")"
	'normalize the expression
	expr = expr.Replace("-(", "-1*(")
	Dim m As Matcher = Regex.Matcher("\(|\)|[\.\d]+", expr)
	Nodes.Initialize
	Dim orderStack As List
	orderStack.Initialize
	Dim lastIndex As Int = 0
	Do While m.Find
		Dim Operator As String = expr.SubString2(lastIndex, m.GetStart(0))
		Dim rawNumber As String = m.Match
		If Operator.EndsWith("-") Then
			Dim lastNode As ParsedNode = Nodes.Get(Nodes.Size - 1)
			If lastNode.Operator = "(" Or Operator.Length > 1 Then 
			'handle negative numbers: (-2 + 1, 1/-2
				Operator = Operator.SubString2(0, Operator.Length - 1)
				rawNumber = "-" & rawNumber
			End If
		End If
		lastIndex = m.GetEnd(0)
		If Operator.Length > 0 Then
			Dim currentOrderData As OrderData = orderStack.Get(orderStack.Size - 1)
			Dim level As Int = OperatorLevel.Get(Operator)
			If currentOrderData.Level > 0 Then
				If currentOrderData.Level < level Then
					Nodes.InsertAt(currentOrderData.Index, CreateOperatorNode("("))
					currentOrderData.Added = currentOrderData.Added + 1
				Else if currentOrderData.Level > level Then
					If currentOrderData.Added > 0 Then
						Nodes.Add(CreateOperatorNode(")"))
						currentOrderData.Added = currentOrderData.Added - 1 
					End If
				End If
			End If
			currentOrderData.Level = level
			currentOrderData.Index = Nodes.Size + 1
			Nodes.Add(CreateOperatorNode(Operator))
		End If
		If m.Match = "(" Or m.Match = ")" Then
			If m.Match = "(" Then 
				Dim data As OrderData
				data.Initialize
				orderStack.Add(data) 
			Else
				Dim currentOrderData As OrderData = orderStack.Get(orderStack.Size - 1)
				For i = 1 To currentOrderData.Added
					Nodes.Add(CreateOperatorNode(")"))
				Next
				orderStack.RemoveAt(orderStack.Size - 1)
			End If
			Nodes.Add(CreateOperatorNode(m.Match))
		Else
			Dim d As Double = rawNumber
			Nodes.Add(CreateNumberNode(d))
		End If
	Loop
	root = BuildTree
	Return EvalNode(root)
End Sub

private Sub BuildTree As ParsedNode
	Dim rt As ParsedNode
	Do While ParseIndex < Nodes.Size
		Dim pn As ParsedNode = TakeNextNode
		Dim built As Boolean
		If pn.Operator = ")" Then 
			Exit
		Else If pn.Operator = "(" Then 
			pn = BuildTree
			built = True
		End If
		If pn.NodeType = NUMBER_TYPE Or built Then
			If rt.IsInitialized Then
				rt.Right = pn
			Else
				rt = pn
			End If
		Else if pn.NodeType = OPERATOR_TYPE Then
			pn.Left = rt
			rt = pn
		End If
	Loop
	If rt.IsInitialized = False Then rt = pn
	Return rt
End Sub

Private Sub EvalNode (pn As ParsedNode) As Double
	If pn.NodeType = NUMBER_TYPE Then Return pn.Value
	Dim left As Double = EvalNode(pn.Left)
	Dim right As Double = EvalNode(pn.Right)
	Select pn.Operator
		Case "+"
			Return left + right
		Case "-"
			Return left - right
		Case "*"
			Return left * right
		Case "/"
			Return left / right
		Case Else
			Log("Syntax error: " & pn.Operator)
			Return "error"
	End Select
End Sub

private Sub TakeNextNode As ParsedNode
	Dim pn As ParsedNode = Nodes.Get(ParseIndex)
	ParseIndex = ParseIndex + 1
	Return pn
End Sub

Private Sub CreateOperatorNode(operator As String) As ParsedNode
	Dim pn As ParsedNode
	pn.Initialize
	pn.NodeType = OPERATOR_TYPE
	pn.Operator = operator
	Return pn
End Sub

Private Sub CreateNumberNode (d As Double) As ParsedNode
	Dim pn As ParsedNode
	pn.Initialize
	pn.NodeType = NUMBER_TYPE
	pn.Value = d
	Return pn
End Sub
