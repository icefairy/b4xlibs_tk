Type=Class
Version=4.2
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Handler class
Sub Class_Globals
	Private cmd As String,typ As String
	Private mResp As ServletResponse
	Private mExtra As Map
End Sub

Public Sub Initialize
	
End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)
	mResp=resp
	mResp.CharacterEncoding="UTF-8"
	mExtra.Initialize
	mExtra.Put("app",req.GetParameter("apptyp"))
	mExtra.Put("ver",req.GetParameter("ver"))
	cmd=req.GetParameter("cmd").ToLowerCase
	typ=req.GetParameter("typ").ToLowerCase
	If typ.Length<1 Then typ="json"
	Select cmd
	Case "1"
		Dim num As String=req.GetParameter("num")
		If num=Null Or num.Length<1 Then num="30"
		If needrefush(num) Then
			donetRefush
			StartMessageLoop
		Else
			outputs
		End If
		
	End Select
	
End Sub
Private Sub donetRefush
'	Select Main.nApiIdx
'	Case 0
'		getsscdata163
'	Case 1
'		getsscdatajw
'	End Select
	getsscdata163
	Main.nApiIdx=Main.nApiIdx+1
	If Main.nApiIdx=2 Then Main.nApiIdx=0
End Sub
Private Sub needrefush(num As Int) As Boolean
	If Main.mData.IsInitialized=False Or Main.mData.Size=0 Then Return True
	If getcurmin=3 Or getcurmin=4 Or getcurmin=5 Or getcurmin=8 Or getcurmin=9 Or getcurmin=0 Then Return False '只要1 2 6 7获取数据
	If (DateTime.Now-Main.tLastTickets)>(Main.nReqMinSecond*1000) Or Main.num<num Then
		Main.num=num
		Return True
	Else
		Return False
	End If
End Sub
Private Sub getcurmin As Int
	Return DateTime.GetMinute(DateTime.Now) mod 10
End Sub
Sub JobDone(thj As HttpJob)
	Log("Job:"&thj.Success)
	Main.tLastTickets=DateTime.Now
	If thj.Success Then
		Select thj.JobName.ToLowerCase
		Case "163"
			Main.mData=ParseSSC_163(thj.GetString)
		Case "jw"
			Main.mData=ParseSSC_jw(thj.GetString)
		End Select
		
		Log("load ok once")
	Else
		Log("joberror:"&thj.ErrorMessage)
	End If	
	thj.Release
	Main.bLoading=False
	StopMessageLoop
	outputs
End Sub
Private Sub checkver(ver As String,app As String) As String
	Dim jsp As JSONParser
	Dim sb As StringBuilder
	sb.Initialize
	jsp.Initialize(File.ReadString("",File.DirApp&"/www/version.json"))
	Dim m As Map=jsp.NextObject
	If ver.EqualsIgnoreCase(m.GetDefault("release","")) Or ver.Length=0 Then
		'最新了
	Else
		sb.Append("<div id='update' class='update'>")
		sb.Append("最新版本:"&m.GetDefault("release","")&"<br>")
		sb.Append("你的版本:"&ver&"<br>")
		sb.Append("更新内容:"&m.GetDefault("update","")&"<br>")
		sb.Append("下载地址:<a href='"&m.GetDefault("url","")&"'>点击下载</a></div>")
	End If
	Return sb.ToString
End Sub
Private Sub outputs
	If typ.EqualsIgnoreCase("json") Then
		mResp.Write(Main.getDataJson)
	Else
		Dim sb As StringBuilder
		sb.Initialize
		sb.Append(File.ReadString("",File.DirApp&"/www/header.tpl"))
		sb.Append(checkver(mExtra.GetDefault("ver",""),mExtra.GetDefault("app","")))
		sb.Append($"<table><tr class='border_bottom'><td>期号</td><td class='tdwxshui'>万</td><td class='tdwxhuo'>千</td><td class='tdwxmu'>百</td><td class='tdwxjin'>十</td><td class='tdwxtu'>个</td></tr>"$)
		Dim m As Map
		Dim hm,qh As String
		For i=0 To Main.mData.Size-1
			m=Main.mData.Get(i)
			qh=m.Get("qh")
			hm=m.Get("hm")
			'Log(qh&" "&hm)
			If qh.Length>0 And hm.Length=5 Then
				sb.Append($"<tr><td>${qh}</td>"$)
				For j=0 To 4
					sb.Append(withcolor(hm.SubString2(j,j+1)))
				Next
				sb.Append("</tr>")
			End If
			
		Next
		sb.Append(File.ReadString("",File.DirApp&"/www/footer.tpl"))
		mResp.Write(sb.ToString)
	End If
End Sub
Private Sub withcolor(n As String) As String
	Dim ret As String
	Select n
	Case "0","5"
		ret="<td class='tdwxtu'>"&n&"</td>"
	Case "1","6"
		ret="<td class='tdwxshui'>"&n&"</td>"
	Case "2","7"
		ret="<td class='tdwxhuo'>"&n&"</td>"
	Case "3","8"
		ret="<td class='tdwxmu'>"&n&"</td>"
	Case "4","9"
		ret="<td class='tdwxjin'>"&n&"</td>"
	End Select
	Return ret
End Sub
Private Sub ParseSSC_163(str As String) As List
	Dim lst As List
	lst.Initialize
	Dim mc As Matcher=Regex.Matcher($"\d{9}">\d{5} </span>"$,str)
	Dim str1 As String
	Do While mc.Find
		str1=mc.Match
		Dim s1 As Map,qh As String,hm As String
		qh=str1.SubString2(0,str1.IndexOf(""""))
		hm=str1.SubString2(str1.IndexOf(">")+1,str1.LastIndexOf("<")-1)
		qh=qh.SubString(qh.Length-3)
		s1.Initialize
		s1.Put("hm",hm)
		s1.Put("qh",qh)
		lst.InsertAt(0,s1)
		str1=qh
	Loop
	Return lst
End Sub
Private Sub ParseSSC_jw(str As String) As List
	Dim lst As List
	lst.Initialize
	Dim jsp As JSONParser
	jsp.Initialize(str)
	Dim root As Map = jsp.NextObject
	Dim response As Map= root.Get("response")
	Dim lstarray As List=response.Get("array")
    For Each colroot_response_array As Map In lstarray
	   Dim m As Map,hm As String,qh As String
	   m.Initialize
	   hm=colroot_response_array.Get("code")
	   hm=hm.Replace(",","")
	   m.Put("hm",hm)
	   qh=colroot_response_array.Get("sn")
	   qh=qh.SubString(qh.Length-3)
	   m.Put("qh",qh)
	   lst.Add(m)
    Next
	Return lst
End Sub
'regex:\d{5} </span>
'regex:\d{9}">\d{5} </span>
'url:http://trend.caipiao.163.com/cqssc/jiben-5xing.html
Public Sub getsscdata163
	Log("get once by 163")
	Main.bLoading=True
	Dim hj As HttpJob
	hj.Initialize("163",Me)
	If Main.num<>30 And Main.num<>50 And Main.num<>100 Then Main.num=30
	hj.Download($"http://trend.caipiao.163.com/cqssc/jiben-5xing.html?periodNumber=${Main.num}"$)
End Sub
'regex:\d{5} </span>
'regex:\d{9}">\d{5} </span>
'url:http://trend.caipiao.163.com/cqssc/jiben-5xing.html
Public Sub getsscdatajw
	Log("get once by jw")
	Main.bLoading=True
	Dim hj As HttpJob
	hj.Initialize("jw",Me)
	If Main.num<>30 And Main.num<>50 And Main.num<>100 Then Main.num=30
	hj.Download($"http://web.jw909.com:1688/cpp/ic?op=0&lottery_id=1&n=${Main.num}"$)
End Sub
