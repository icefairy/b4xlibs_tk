B4J=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=5.9
@EndOfDesignText@

Sub Process_Globals
	Private jsg As JSONGenerator2
	Private su As StringUtils
	Public devMode As Boolean
	Public action As String="action"
	Public MessageDigestObj  As MessageDigest
	Private bc As ByteConverter
	Public staticFilesFolder As String="public",uploadFolder As String="upload",uploadMaxSize As Int=20*1024*1024 '20mb
	Public baseCache,funCache,Settings As Map
	Public reloadbasemaptime As Int=60
	Public addFunctionAuto As Boolean=True '是否自动添加接口
	Public allowuploadfileext As String="jpg,png,pdf,doc,docx,rar,xls,xlsx,zip,gif"
	Public db As SQL
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
Public Sub webDir2LocalDir(d As String) As String
	Return File.Combine(File.Combine(File.DirApp,staticFilesFolder),d)
End Sub
Public Sub checkMobileByUA(ua As String) As Boolean
	If ua.ToLowerCase.IndexOf("android")>-1 Or ua.ToLowerCase.IndexOf("ios")>-1 Or ua.ToLowerCase.IndexOf("wap")>-1 Then
		Return True
	Else
		Return False
	End If
End Sub
Public Sub toJson(data As Object) As String
	If data Is Map Then
		jsg.Initialize(data)
		Return jsg.ToString
	else if data Is List Then
		jsg.Initialize2(data)
		Return jsg.ToString
	Else
		Return data
	End If
	
End Sub
Public Sub getSetting(key As String,def As String) As String
	Return Settings.GetDefault(key,def)
End Sub
Public Sub setSetting(key As String,value As String,db1 As SQL)
	Settings.Put(key,value)
	wpDBUtils.UpdateRecord2(db1,"wp_setting",CreateMap("update":getdatetime,"val":value),CreateMap("key":key))
End Sub
Public Sub urlEncode(u As String) As String
	Return su.EncodeUrl(u,"UTF-8")
End Sub
Public Sub urlDecode(u As String) As String
	Return su.DecodeUrl(u,"UTF-8")
End Sub
'用/拆分url
Public Sub url2Array(u As String) As String()
	If u.StartsWith("/") Then u=u.SubString(1)
	If u.EndsWith("/") Then u=u&"index"
	Return Regex.Split("/",u)
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
Public Sub getMd5(str As String) As String
	Dim buf() As Byte=MessageDigestObj.GetMessageDigest(str.GetBytes("UTF8"),"MD5")
	Return bc.HexFromBytes(buf).ToLowerCase
End Sub
'从sql模板文件夹中(objects\sqls\xxx.sql)读取sql语句
Public Sub getSQL(tsqlname As String) As String
	If File.Exists(File.Combine(File.DirApp,"sqls"),tsqlname&".sql") Then
		Return File.ReadString(File.Combine(File.DirApp,"sqls"),tsqlname&".sql")
	Else
		Return "no sql file:"&tsqlname&" found"
	End If
End Sub
Public Sub getRndSalt As String
	Return Rnd(100000,999999)&""
End Sub
Public Sub getdatetime As String
	DateTime.DateFormat="yyyy-MM-dd"
	DateTime.TimeFormat="HH:mm:ss"
	Return DateTime.Date(DateTime.Now)&" "&DateTime.Time(DateTime.Now)
End Sub
Public Sub formatDateTime(dt As String) As String
	DateTime.DateFormat="yyyy-MM-dd"
	DateTime.TimeFormat="HH:mm:ss"
	Try
		Dim ts() As String=Regex.Split(" ",dt)
		Dim lTs As Long=DateTime.DateTimeParse(ts(0),ts(1))
		Return DateTime.Date(lTs)&" "&DateTime.Time(lTs)
	Catch
		Log(LastException)
		Return DateTime.Date(DateTime.Now)&" "&DateTime.Time(DateTime.Now)
	End Try
	
End Sub
Public Sub ReplaceMap(Base As String, Replacements As Map) As String
	Dim pattern As StringBuilder
	pattern.Initialize
	For Each k As String In Replacements.Keys
		If pattern.Length > 0 Then pattern.Append("|")
		pattern.Append("\$").Append(k).Append("\$")
	Next
	Dim m As Matcher = Regex.Matcher(pattern.ToString, Base)
	Dim result As StringBuilder
	result.Initialize
	Dim lastIndex As Int
	Do While m.Find
		result.Append(Base.SubString2(lastIndex, m.GetStart(0)))
		Dim replace As String = Replacements.Get(m.Match.SubString2(1, m.Match.Length - 1))
		If m.Match.ToLowerCase.StartsWith("$h_") Then replace = EscapeHtml(replace)
		result.Append(replace)
		lastIndex = m.GetEnd(0)
	Loop
	If lastIndex < Base.Length Then result.Append(Base.SubString(lastIndex))
	Return result.ToString
End Sub
Public Sub arrUpperFirst(arr() As String) As String
	Dim sb As StringBuilder
	sb.Initialize
	For Each s As String In arr
		If s.Length>0 Then  sb.Append(s.SubString2(0,1).ToUpperCase&s.SubString(1))
	Next
	Return sb.ToString
End Sub
Public Sub EscapeHtml(Raw As String) As String
	Dim sb As StringBuilder
	sb.Initialize
	For i = 0 To Raw.Length - 1
		Dim C As Char = Raw.CharAt(i)
		Select C
			Case QUOTE
				sb.Append("&quot;")
			Case "'"
				sb.Append("&#39;")
			Case "<"
				sb.Append("&lt;")
			Case ">"
				sb.Append("&gt;")
			Case "&"
				sb.Append("&amp;")
			Case " "
				sb.Append("&nbsp;")
			Case CRLF
				sb.Append("<br>")
			Case Else
				sb.Append(C)
		End Select
	Next
	Return sb.ToString
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
'uid=-1 is logout
Public Sub setUserLogined(req As ServletRequest,uid As Int)
	req.GetSession.SetAttribute("uid",uid)
End Sub
'-1=未登录
Public Sub getUid(req As ServletRequest) As Int
	Return req.GetSession.GetAttribute2("uid",-1)
End Sub
'uid=-1 is logout
Public Sub setMgrLogined(req As ServletRequest,uid As Int)
	req.GetSession.SetAttribute("aid",uid)
End Sub
'-1=未登录
Public Sub getAid(req As ServletRequest) As Int
	Return req.GetSession.GetAttribute2("aid",-1)
End Sub
#Region utils
Public Sub js2List(js As String) As List
	Dim jsp As JSONParser
	jsp.Initialize(js)
	Return jsp.NextArray
End Sub
Public Sub js2Map(js As String) As Map
	Dim jsp As JSONParser
	jsp.Initialize(js)
	Return jsp.NextObject
End Sub
public Sub mLog(msg As String)
	If devMode Then
		Log(msg)
	End If
End Sub
Public Sub str2int(str As String,def As Int) As Int
	Dim ret As Int
	Try
		ret=str
	Catch
		ret=def
		Log(LastException)
	End Try
	Return ret
End Sub

#End region