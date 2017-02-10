Type=Class
Version=4.2
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	
	Private resMap As Map
	Private sIndent As String="    "
	Private mData As Map
End Sub

Public Sub Initialize
	
End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)
	resp.ContentType = "application/json"
	resp.CharacterEncoding="UTF-8"
	resMap.Initialize
	mData.Initialize
	Try
		Dim data() As Byte = Bit.InputStreamToBytes(req.InputStream)
		Dim text As String = BytesToString(data, 0, data.Length, "UTF8")
		Dim parser As JSONParser
		parser.Initialize(text)
		Dim squareBracketFound As Boolean
		'check whether we need to call NextArray or NextObject
		For i = 0 To text.Length
			If text.CharAt(i) = "[" Then
				squareBracketFound = True
				Exit
			Else If text.CharAt(i) = "{" Then
				Exit
			End If
		Next
		Dim code As StringBuilder
		code.Initialize
		code.Append("Dim parser As JSONParser").Append(" "&CRLF)
		code.Append("parser.Initialize(str)").Append(" "&CRLF)
		code.Append("Dim root As ")
		Dim root As TreeItem = CreateTreeItem ("")
		If squareBracketFound Then
			code.Append("List = parser.NextArray").Append(" "&CRLF)
			BuildTree(parser.NextArray, root, code, "root", "", False, "")
		Else
			code.Append("Map = parser.NextObject").Append(" "&CRLF)
			BuildTree(parser.NextObject, root, code, "root", "", False, "")
		End If
		Dim sb,sbCLS As StringBuilder
		sb.Initialize
		code.Initialize
		ConvertTreeToHtml(sb, root, True)
		sbCLS.Initialize
		For i=0 To mData.Size-1
			Dim m As Map=str2map(mData.Get(mData.GetKeyAt(i)))
			sbCLS.Append($"/**
 * Created by icefairy on ${getdate}.
 */
@Table(name = "tab_${mData.GetKeyAt(i)}")"$).Append(CRLF)
			sbCLS.Append("public class md"&mData.GetKeyAt(i)).Append("{").Append(CRLF)
			sbCLS.Append(map2code(m)).Append(CRLF)
			sbCLS.Append(sIndent&"public md"& mData.GetKeyAt(i)&"(){/* this is for xutils3 db module */}").Append(CRLF).Append($"${sIndent&"public md"& mData.GetKeyAt(i)}(String js){
		if (js==null||js.length()<1){
		        return;
		    }
		try {
			JSONObject jo=new JSONObject(js);
${map2code2(m)}
		} catch (JSONException e1) {
		    e1.printStackTrace();
		}
	}"$).Append(CRLF)
			sbCLS.Append("}").Append(CRLF).Append(CRLF)
		Next
		resMap.Put("tree", sb.ToString)
		resMap.Put("success", True)
		resMap.Put("code", sbCLS.ToString)
	Catch
		resMap.Put("success", False)
		resMap.Put("error", "Error parsing string:" & CRLF & LastException.Message)
	End Try
	Dim jg As JSONGenerator
	jg.Initialize(resMap)
	resp.Write(jg.ToString)
End Sub
Sub getdate As String
	DateTime.DateFormat="yyyy-MM-dd"
	Return DateTime.Date(DateTime.Now)
End Sub
Sub map2code(m As Map) As String
	If m.IsInitialized=False Then Return ""
	Dim sb As StringBuilder
	sb.Initialize
	For Each k As String In m.Keys
		sb.Append(sIndent)
		Dim obj As Object=m.Get(k)
		If obj Is Int Then
			If k.EqualsIgnoreCase("id") Then
				sb.Append("@Column(name = """&k&""",isId = true,autoGen = false)"&CRLF&sIndent&"private int "&k&";").Append(CRLF)
			Else
				sb.Append("@Column(name = """&k&""")"&CRLF&sIndent&"private int "&k&";").Append(CRLF)
			End If
			
		Else If obj Is Double Then
			sb.Append("@Column(name = """&k&""")"&CRLF&sIndent&"private double"&k&";").Append(CRLF)
		Else
			sb.Append("@Column(name = """&k&""")"&CRLF&sIndent&"private String "&k&";").Append(CRLF)
		End If	
	Next
	Return sb.ToString
End Sub
'生成模型构造器
Sub map2code2(m As Map) As String
	If m.IsInitialized=False Then Return ""
	Dim sb As StringBuilder
	sb.Initialize
	For Each k As String In m.Keys
		sb.Append(sIndent).Append(sIndent).Append(sIndent)
		Dim obj As Object=m.Get(k)
		If obj Is Int Then
			sb.Append("this."&k&"=jo.optInt("""&k&""",0);")
		Else If obj Is Double Then
			sb.Append("this."&k&"=jo.optDouble("""&k&""",0d);")
		Else
			sb.Append("this."&k&"=jo.optString("""&k&""","""");")
		End If	
		sb.Append(CRLF)
	Next
	Return sb.ToString
End Sub
Sub map2str(m As Map) As String
	Dim ret As String
	Dim jsg As JSONGenerator
	jsg.Initialize(m)
	ret=jsg.ToString
	Log(ret)
	Return ret
End Sub
Sub str2map(s As String) As Map
	Dim ret As Map
	Try
		Dim jsp As JSONParser
		jsp.Initialize(s)
		ret=jsp.NextObject
	Catch
		ret.Initialize
	End Try
	
	Return ret
End Sub
Sub BuildTree(element As Object, parent As TreeItem, code As StringBuilder, _
		parentName As String, GetFromMap As String, BuildList As Boolean, indent As String)
	code.Append(indent)
	If element Is Map Then
		indent = WriteCodeHelper("Map", code, parentName, GetFromMap, BuildList, indent)
		Dim m As Map = element
		 mData.Put(parentName,map2str(m))
		For Each k As String In m.Keys
			Dim ti As TreeItem = CreateTreeItem(k)
			parent.Children.Add(ti)
			BuildTree(m.Get(k), ti, code, k, parentName & ".Get(""" & k & """)", False, indent)
		Next
	Else If element Is List Then
		indent = WriteCodeHelper("List", code, parentName, GetFromMap, BuildList, indent)
		Dim l As List = element
		Dim index As Int = 0
		For Each e As Object In l
			Dim ti As TreeItem = CreateTreeItem(index)
			parent.Children.Add(ti)
			Dim stubCode As StringBuilder
			'only write the code for the first item
			If index = 0 Then stubCode = code Else stubCode.Initialize
			BuildTree(e, ti, stubCode, parentName ,"", index = 0, indent)
			index = index + 1
		Next
	Else
		Dim objectType As String
		If element Is Int Then
			objectType = "Int"
		Else If element Is Double Then
			objectType = "Double"
		Else
			objectType = "String"
		End If
		indent = WriteCodeHelper(objectType, code, parentName, GetFromMap, BuildList, indent)
		parent.Text = parent.Text & ": " & element
	End If
	If BuildList Then
		'Log(indent)
		code.Append(indent.SubString(sIndent.Length)).Append("Next").Append(" "&CRLF)
	End If
End Sub

Sub WriteCodeHelper (ObjectType As String, code As StringBuilder, _
	parentName As String, GetFromMap As String, BuildList As Boolean, indent As String) As String
	
	If GetFromMap.Length > 0 Then
		Select ObjectType.ToLowerCase
		Case "int"
			code.Append("Dim " & parentName & " As " & ObjectType & " = " & GetFromMap.Replace("Get","GetDefault").Replace(")",",0)")).Append(" "&CRLF)
		Case "double"
			code.Append("Dim " & parentName & " As " & ObjectType & " = " & GetFromMap.Replace("Get","GetDefault").Replace(")",",0)")).Append(" "&CRLF)
		Case "string"
			code.Append("Dim " & parentName & " As " & ObjectType & " = " & GetFromMap.Replace("Get","GetDefault").Replace(")",","""")")).Append(" "&CRLF)
		Case Else
			'Log(ObjectType)
			code.Append("Dim " & parentName & " As " & ObjectType & " = " & GetFromMap&" "&CRLF)
		End Select		
	Else If BuildList Then
		code.Append("For Each " & parentName & " As " & ObjectType & " In " & parentName.SubString(3)).Append(" "&CRLF)
		indent = indent & sIndent
	End If
	Return indent
End Sub

Private Sub ConvertTreeToHtml(sb As StringBuilder, parent As TreeItem, isRoot As Boolean)
	If isRoot = False Then sb.Append("<li>").Append(EscapeXml(parent.Text))
	If parent.Children.Size > 0 Then
		sb.Append("<ul>")
		For Each ti As TreeItem In parent.Children
			sb.Append(CRLF)
			ConvertTreeToHtml(sb, ti, False)
		Next
		sb.Append("</ul>")
	End If
	If isRoot = False Then sb.Append("</li>")
End Sub
Private Sub CreateTreeItem (text As String) As TreeItem
	Dim ti As TreeItem
	ti.Initialize
	ti.Children.Initialize
	ti.text = text
	Return ti
End Sub
Private Sub EscapeXml(Raw As String) As String
   Dim sb As StringBuilder
   sb.Initialize
   For i = 0 To Raw.Length - 1
     Dim C As Char = Raw.CharAt(i)
     Select C
       Case QUOTE
         sb.Append("&quot;")
       Case "'"
         sb.Append("&apos;")
       Case "<"
         sb.Append("&lt;")
       Case ">"
         sb.Append("&gt;")
       Case "&"
         sb.Append("&amp;")
       Case Else
         sb.Append(C)
     End Select
   Next
   Return sb.ToString
End Sub
