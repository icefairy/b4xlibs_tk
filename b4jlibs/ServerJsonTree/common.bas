Type=StaticCode
Version=4.2
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@

Sub Process_Globals
	Type TreeItem (Children As List, Text As String)
	Type caller(element As Object, parent As TreeItem, code As StringBuilder, _
		parentName As String, GetFromMap As String, BuildList As Boolean, indent As String)
	Type parseJSOOBJ(obj As Object,par As Object)
End Sub