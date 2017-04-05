Type=Class
Version=5
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'WPTemplateEngine Class module
Sub Class_Globals
	Public ThemeName,ViewBasePath,TPLFileExt As String
	Private bc As ByteConverter
	'一个全局的map适用于放置通用的参数集
	Public gMap As Map
	Public devMode As Boolean
	Private mapData As Map '用于存储将要应用到本页面的各种变量数据
	Private res As ServletResponse
	Private jsg As JSONGenerator
End Sub

'Version:1.00
'LastUpdate:2017-4-5 12:25:42
'this class modify by WebUtils
'using library:ByteConverter
'模版变量使用说明(以代码设置的为主，如果代码没有设置，模版中的就不会被替换):
'代码中设置变量:putData("test","teststr123") 其中变量名不应包含"."否则会影响模版中对于map的正常解析
'TPL模版中调用变量{# $test #}将替换{# $test #}为:teststr123 提示:模版中"amap.title"表示获取名为amap的map对象中的title的值
'TPL模版中引用其他模版:{# include "/header" #} 引用的模版路径加文件名可以不用带后缀（带上也可以）
Public Sub Initialize
	bc.LittleEndian = True
	devMode=True
	mapData.Initialize
	ThemeName="default"
	ViewBasePath="view"
	TPLFileExt=".html"
	If File.Exists(File.DirApp,"view")=False Or File.IsDirectory(File.DirApp,"File.DirApp")=False Then
		'如果模版目录不存在就自动创建
		File.MakeDir(File.DirApp,"view")
	End If
	If File.Exists(File.Combine(File.DirApp,"view"),ThemeName)=False Then
		File.MakeDir(File.Combine(File.DirApp,"view"),ThemeName)
	End If
	gMap.Initialize
	gMap.Put("headertitle","WebPlus演示")
	
End Sub
#Region methods
'清理模版数据
Public Sub clearMapData
	mapData.Clear
	mapData=G.copyMap(gMap)
End Sub
'填充模版数据（填充完成后调用render进行渲染）
Public Sub putData(key As String,val As Object)
	mapData.Put(key,val)
End Sub
'获取已经填充的数据，不存在返回空文本""
Public Sub getData(key As String) As Object
	If mapData.ContainsKey(key) Then Return mapData.Get(key) Else Return ""
End Sub
Public Sub bindResponse(resp As ServletResponse)
	res=resp
End Sub
'直接返回网页文本(需要html编码的请自行调用EscapeHtml),调用之前确保已经绑定了response对象
Public Sub renderText(htmlsrc As String)
	res.ContentType="text/html"
	res.CharacterEncoding="UTF-8"
	res.Write(htmlsrc)
End Sub
'直接返回json对象，格式为:{code:200,data:"msg"}其中data中可能是对象、列表、值,调用之前确保已经绑定了response对象
Public Sub renderJson(success As Boolean,data As Object)
	res.ContentType="application/json"
	res.CharacterEncoding="UTF-8"
	Dim ret As Map
	ret.Initialize
	If success Then ret.Put("code",200) Else ret.Put("code",500)
	ret.Put("data",data)
	jsg.Initialize(ret)
	res.Write(jsg.ToPrettyString(1))
End Sub
'渲染模版并返回给客户端,确保调用之前绑定了response对象
'传入模版文件路径（不包括主题名称）
Public Sub renderTPL(TPLFilePath As String)
	Log("rending:"&TPLFilePath)
	Dim begints As Long=DateTime.Now
	Dim htmlsrc As String= getTPLContent(TPLFilePath)
	Log("rending:"&TPLFilePath&" complete within:"&(DateTime.Now-begints)&"ms")
	renderText(htmlsrc)
End Sub
'流程：1、解析include；2、解析if条件；3、解析for循环；、4.解析变量（2,3中的变量已经被处理不会反复解析）
Private Sub getTPLContent(TPLFilePath As String) As String
	'判断文件路径是否是模版后缀结束
	Dim tmp0 As String
	If TPLFilePath.EndsWith(TPLFileExt)=False Then TPLFilePath=TPLFilePath&TPLFileExt
	Dim tplpath As String=getTPLPath
	'读入第一级模版内容
	If File.Exists(tplpath,TPLFilePath) Then
		tmp0=File.ReadString(tplpath,TPLFilePath)
		tmp0=processIncludes(tmp0)
		tmp0=processIF(tmp0)
		tmp0=processFOR(tmp0)
		tmp0=processVar(tmp0)
		
	Else
		Log("Error:TPLFile:"&getTPLPath& TPLFilePath&" Not exist!")
	End If
	Return tmp0
End Sub
'解析FOR循环
Private Sub processFOR(tmp0 As String) As String
	Return tmp0
End Sub
'解析IF条件语句
Private Sub processIF(tmp0 As String) As String
	Return tmp0
End Sub
Private Sub processIncludes(tmp0 As String) As String
	'开始解析嵌入模版，regex:{#\s*include.*?\s*#}
	Dim regsign0 As String=$"\{#\s*include.*?\s*#\}"$
	Dim tplincludes As Matcher= Regex.Matcher(regsign0,tmp0)
	Do While tplincludes.Find
		Dim match0 As String=tplincludes.Match&""
		Dim matchpath As String=match0
		matchpath=G.getText(matchpath,QUOTE,QUOTE,True)'替换双引号为单引号
		Dim matchcontent As String= getTPLContent(matchpath)
		match0=replaceRegexSpecal(match0)
		tmp0=Regex.Replace(match0,tmp0,replaceRegexSpecal(matchcontent))
		'			mLog("替换引入:"&match0)
	Loop
	Return tmp0
End Sub
'解析变量
Private Sub processVar(tmp0 As String) As String
	'开始解析变量，regex:{#\s*\$.*?\s*#}
	Dim regsign0 As String=$"\{#\s*\$.*?\.+*?\s*#\}"$
	Dim tplvars As Matcher=Regex.Matcher(regsign0,tmp0)
	Do While tplvars.Find
		Dim match0 As String=tplvars.Match
		mLog(match0)
		Dim needhtml As Boolean=False
		Dim matchedvarname As String=match0.Replace("{","").Replace("}","").Replace("#","").Replace("$","").Trim
		needhtml=matchedvarname.StartsWith("h_")'如果变量名以h_开头则自动进行html编码后输出
		matchedvarname=matchedvarname.Replace("h_","")
		Dim varcontent As String
		Dim matchedvarnames() As String=Regex.Split(".",matchedvarname)
		If matchedvarnames.Length>0 Then
			If mapData.ContainsKey(matchedvarnames(0)) Then
				Dim m As Map=mapData.Get(matchedvarnames(0))
				varcontent=m.GetDefault(matchedvarnames(1),matchedvarnames(1))
			Else
				varcontent="map:"&matchedvarnames(0)&" not exist"
			End If
		Else
			If mapData.ContainsKey(matchedvarname) Then
				
				varcontent= mapData.GetDefault(matchedvarname,matchedvarname)
				If needhtml Then varcontent=EscapeHtml(varcontent)
				match0=replaceRegexSpecal(match0)
				
			Else
				'					mLog("未知变量:"&matchedvarname)
				varcontent="unknown var:"&matchedvarname
			End If
		End If
		tmp0=Regex.Replace(match0,tmp0,replaceRegexSpecal(varcontent))
	Loop
	Return tmp0
End Sub
'对正则表达式特殊字符进行转义
Private Sub replaceRegexSpecal(str As String) As String
	Return str.Replace("{","\{").Replace("}","\}").Replace("$","\$").Replace("<","\<").Replace(">","\>").Replace("/","\/")
End Sub
'根据主题名称获取模版目录
Private Sub getTPLPath As String
	Dim tplpath As String=File.Combine(File.DirApp,ViewBasePath)
	If ThemeName.Length>0 Then
		tplpath=File.Combine(tplpath,ThemeName)
		If File.Exists(tplpath,ThemeName)=False Or File.IsDirectory(tplpath,ThemeName)=False Then
			File.MakeDir(tplpath,ThemeName)
		End If
	End If
	Return tplpath
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

#End Region
#Region utils
Private Sub mLog(msg As String)
	If devMode Then
		Log(msg)
	End If
End Sub
#End region