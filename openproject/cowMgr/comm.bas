Type=StaticCode
Version=6
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	'Public uil,uilnocache,uilround,rilroundcorn As UniversalImageLoader
	
	Public su As StringUtils
End Sub
Public Sub urlencode(str As String) As String
	Return su.EncodeUrl(str,"UTF8")
End Sub
public Sub urldecode(str As String) As String
	Return su.DecodeUrl(str,"UTF8")
End Sub
Sub SetPadding(v As View, Left As Int, Top As Int, Right As Int, Bottom As Int)
	 Dim jo As JavaObject = v
	 jo.RunMethod("setPadding", Array As Object(Left, Top, Right, Bottom))
End Sub
Sub SetPaddingCommon(v As View)
	 Dim jo As JavaObject = v
	 Dim np As Int=10dip
	 jo.RunMethod("setPadding", Array As Object(np,np,np,np))
End Sub
Sub MeasureTextWidth(v As View,str As String) As Float
	Dim cav As Canvas
	cav.Initialize(v)
	Dim tf As Typeface
	Dim ts As Float
	If v Is Button Then
		Dim btn As Button=v
		tf=btn.Typeface
		ts=btn.TextSize
	Else 
		Dim lbl As Label=v
		tf=lbl.Typeface
		ts=lbl.TextSize
	End If
	
	Return cav.MeasureStringWidth(str,tf,ts)
End Sub
Sub MeasureTextHeight(v As View,str As String) As Float
	Dim cav As Canvas
	cav.Initialize(v)
	Dim tf As Typeface
	Dim ts As Float
	If v Is Button Then
		Dim btn As Button=v
		tf=btn.Typeface
		ts=btn.TextSize
	Else 
		Dim lbl As Label=v
		tf=lbl.Typeface
		ts=lbl.TextSize
	End If
	Return cav.MeasureStringHeight(str,tf,ts)+5dip
End Sub
Sub setViewWrapContent(v As View)
	Try
		If v Is Button Then
		Dim btn As Button=v
		btn.Width=MeasureTextWidth(btn,btn.Text)
		btn.Height=MeasureTextHeight(btn,btn.Text)
	Else 
		Dim lbl As Label=v
		lbl.Width=MeasureTextWidth(lbl,lbl.Text)
'		lbl.Height=MeasureTextHeight(lbl,lbl.Text)
	End If
	Catch
		Log(LastException)
	End Try
End Sub
Public Sub setcommonpadding(v As View)
	Dim pl,pt As Int :pt=1dip :pl=5dip
	SetPadding(v,pl,pt,pl,pt)
End Sub
public Sub T(msg As String)
	ToastMessageShow(msg,False)
End Sub
Public Sub showProgress(msg As String)
	ProgressDialogShow(msg)
End Sub
Public Sub L(msg As String)
	Log(msg)
End Sub
Public Sub long2datestr(l1 As Long) As String
	DateTime.DateFormat="yyyy/MM/dd"
	Return DateTime.Date(l1)&" "&DateTime.Time(l1)
End Sub
public Sub TL(msg As String)
	ToastMessageShow(msg,False)
	Log(msg)
End Sub
public Sub shell(cmd As String) As String
	Log("exec:"&CRLF&cmd)
'	Dim sus As SuShell
'	sus.Execute(cmd)
	Dim sb,err As StringBuilder
	sb.Initialize
	err.Initialize
	Dim sh As Phone
	sh.Shell(cmd,Null,sb,err)
'	Dim sh As shell
'	sh.exec(cmd,sb,err,wait)
	If err.Length>0 Then
		Log(err.ToString)
		Return err.ToString
	End If
	Return sb.ToString
End Sub
Public Sub sharestr(str As String)
	Dim i As Intent
	i.Initialize(i.ACTION_SEND,"")
	i.PutExtra("android.intent.extra.TEXT",str)
	i.SetType("text/plain")
	i.WrapAsIntentChooser("分享")
	StartActivity(i)
End Sub
