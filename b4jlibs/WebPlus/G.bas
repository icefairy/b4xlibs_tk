Type=StaticCode
Version=5
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@

Sub Process_Globals
	Private jsg As JSONGenerator
	Private su As StringUtils
End Sub
Public Sub Json(success As Boolean,data As Object) As  String
	Dim m As Map
	m.Initialize
	If success Then
		m.Put("code",200)
	Else
		m.Put("code",500)
	End If
	m.Put("data",data)
	jsg.Initialize(m)
	Return jsg.ToString
End Sub
Public Sub urlEncode(u As String) As String
	Return su.EncodeUrl(u,"UTF-8")
End Sub
Public Sub urlDecode(u As String) As String
	Return su.DecodeUrl(u,"UTF-8")
End Sub
'将只读map转换成可读写map
Public Sub copyMap(m As Map) As Map
	Dim ret As Map
	ret.Initialize
	If m.IsInitialized=False Then Return ret
	For Each v As String In m.Keys
		ret.Put(v,m.Get(v))
	Next
	Return ret
End Sub
'严格模式下没找到特征就返回空文本
Public Sub getText(str As String,signa As String,signb As String,strict As Boolean) As String
	Dim a,b As Int
	a=str.IndexOf(signa)
	If a<0 Then Return ""
	b=str.IndexOf2(signb,a+1)
	If strict Then
		If b<0 Then Return "" Else Return str.SubString2(a+signa.Length,b)
	Else
		If b<0 Then Return str.SubString(a) Else Return str.SubString2(a,b+signb.Length)
	End If
	
End Sub
'根据标志返回文本（包括标志本身)
Public Sub getText2(str As String,signa As String,signb As String) As String
	Dim a,b As Int
	a=str.IndexOf(signa)
	If a<0 Then Return ""
	b=str.IndexOf2(signb,a+1)
	If b<0 Then Return "" Else Return str.SubString2(a,b+signb.Length)
End Sub
'反向查找,先找尾部的再根据尾部的index找首部
Public Sub getTextRev(str As String,signa As String,signb As String,strict As Boolean) As String
	Dim strs() As String=Regex.Split(signb,str)
	If strs.Length>1 Then
		Dim a As Int
		a=strs(0).LastIndexOf(signa)
		If a>-1 Then
			Return strs(0).SubString(a+signa.Length)
		End If
	End If
	Return ""
End Sub
Public Sub getdatetime As String
	DateTime.DateFormat="yyyy-MM-dd"
	Return DateTime.Date(DateTime.Now)&" "&DateTime.Time(DateTime.Now)
End Sub
Public Sub getuuid As String
	Dim jo As JavaObject
	jo=Me
	jo.InitializeStatic("java.util.UUID")
	Return jo.RunMethodJO("randomUUID",Null).RunMethod("toString",Null)
	'	Dim r As Reflector
	'	r.Target = r.RunStaticMethod("java.util.UUID", "randomUUID", Null, Null)
	'	Return r.RunMethod("toString")
End Sub

