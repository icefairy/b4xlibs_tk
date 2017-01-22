Type=Class
Version=4.2
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	Private resMap As Map
	Private code,convertCode As StringBuilder
End Sub

Public Sub Initialize
	
End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)
	resp.ContentType = "application/json"
	resp.CharacterEncoding="UTF-8"
	resMap.Initialize
	Try
		Dim data() As Byte = Bit.InputStreamToBytes(req.InputStream)
		Dim text As String = BytesToString(data, 0, data.Length, "UTF8")
		If Not(text.StartsWith("{")) Then
			resMap.Put("success", False)
			resMap.Put("error","I can parse JsonObject(map) only")
		Else
			Dim parser As JSONParser
			parser.Initialize(text)
			Dim m As Map=parser.NextObject
'			Dim code As StringBuilder
			code.Initialize
			convertCode.Initialize
			map2typecode(m,"root")
			resMap.Put("success", True)
			resMap.Put("code", code.ToString&CRLF&convertCode.ToString)
		End If
	Catch
		resMap.Put("success", False)
		resMap.Put("error", "Error parsing string:" & CRLF & LastException.Message)
	End Try
	Dim jg As JSONGenerator
	jg.Initialize(resMap)
	resp.Write(jg.ToString)
End Sub
'递归调用
Private Sub map2typecode(m As Map,keyname As String)
	Dim sb,convertSb As StringBuilder
	sb.Initialize
	convertSb.Initialize
	If keyname=Null Or keyname.Length<1 Then keyname="root"
	keyname="typ"&getFirstUpper(keyname)
	sb.Append("Type "&keyname&"(")
	convertSb.Append("Sub parseStr2"&keyname&"(str As String) As "&keyname).Append(CRLF)
	convertSb.Append(TAB&"Dim parser As JSONParser"&CRLF&TAB&"parser.Initialize(str)"&CRLF&TAB&"Return map2"&keyname&"(parser.NextObject)"&CRLF&"End Sub"&CRLF)
	convertSb.Append("Sub map2"&keyname&"(m As Map) As "&keyname).Append(CRLF)
	convertSb.Append(TAB&"Dim ret As "&keyname).Append(CRLF).Append(TAB&"ret.Initialize").Append(CRLF)
	For i=0 To m.Size-1
		Dim k As String=m.GetKeyAt(i)
		Dim valobj As Object=m.GetValueAt(i)
		Dim typ As String=GetType(valobj).Replace("java.lang.","")
'		Log("key:"&k&" valtype:"&typ)
		Select typ
		Case "String"
			sb.Append(k&" As "&typ)
			convertSb.Append(TAB&$"ret.${k}=m.GetDefault("${k}","")"$&CRLF)
		Case "Double"
			sb.Append(k&" As "&typ)
			convertSb.Append(TAB&$"ret.${k}=m.GetDefault("${k}",0)"$&CRLF)
		Case "Integer"
			sb.Append(k&" As Int")
			convertSb.Append(TAB&$"ret.${k}=m.GetDefault("${k}",0)"$&CRLF)
		Case "anywheresoftware.b4a.objects.collections.Map$MyMap"
			map2typecode(m.Get(k),k)
			sb.Append(k&" As typ"&getFirstUpper(k))
			convertSb.Append(TAB&$"ret.${k}=map2typ${getFirstUpper(k)}(m.Get("${k}"))"$&CRLF)
		Case "java.util.ArrayList"
			sb.Append(k&" As List")
			convertSb.Append(TAB&$"ret.${k}=m.Get("${k}")"$&CRLF)
		Case Else
			sb.Append(k&" As UnknowType_"&typ)
			convertSb.Append(TAB&$"ret.${k}=m.Get("${k}")"$&CRLF)
		End Select
		sb.Append(",")
	Next
	If sb.Length>0 Then
		sb.Remove(sb.Length-1,sb.Length)
		sb.Append(")")
		code.Append(sb.ToString).Append(CRLF)
	End If
	If convertSb.Length>0 Then
		convertSb.Append(TAB&"Return ret"&CRLF&"End Sub")
		convertCode.Append(convertSb&CRLF)
	End If
End Sub
Private Sub getFirstUpper(str As String) As String
	If str.Length>0 Then
		Return str.SubString2(0,1).ToUpperCase&str.SubString(1)
	Else
		Return ""	
	End If
End Sub