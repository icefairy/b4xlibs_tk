Type=Class
Version=4.2
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Handler class
Sub Class_Globals
	Private cmd As String
	Private mResp As ServletResponse
End Sub

Public Sub Initialize
	
End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)
	mResp=resp
	cmd=req.GetParameter("cmd").ToLowerCase
	Select cmd
	Case "1"
		Dim num As String=req.GetParameter("num")
		If num=Null Or num.Length<1 Then num="30"
		If needrefush(num) Then
			getsscdata163
			StartMessageLoop
		Else
			outputs
		End If
		
	End Select
	
End Sub
Private Sub needrefush(num As Int) As Boolean
	If (DateTime.Now-Main.tLastTickets)>(Main.nReqMinSecond*1000) Or Main.num<num Then
		Main.num=num
		Return True
	Else
		Return False
	End If
End Sub

Sub JobDone(thj As HttpJob)
	Log("Job:"&thj.Success)
	Main.tLastTickets=DateTime.Now
	If thj.Success Then
		Main.mData=ParseSSC_163(thj.GetString)
		Log("load ok once")
	Else
		Log("joberror:"&thj.ErrorMessage)
	End If	
	thj.Release
	Main.bLoading=False
	StopMessageLoop
	outputs
End Sub
Private Sub outputs
	mResp.Write(Main.getDataJson)
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
		s1.Initialize
		s1.Put("hm",hm)
		s1.Put("qh",qh)
		lst.InsertAt(0,s1)
		str1=qh
	Loop
	Return lst
End Sub
'regex:\d{5} </span>
'regex:\d{9}">\d{5} </span>
'url:http://trend.caipiao.163.com/cqssc/jiben-5xing.html
Public Sub getsscdata163
	Log("get once")
	Main.bLoading=True
	Dim hj As HttpJob
	hj.Initialize("getdata",Me)
	If Main.num<>30 And Main.num<>50 And Main.num<>100 Then Main.num=30
	hj.Download($"http://trend.caipiao.163.com/cqssc/jiben-5xing.html?periodNumber=${Main.num}"$)
End Sub
