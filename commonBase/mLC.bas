Type=Class
Version=3.15
@EndOfDesignText@
'LicenseChecker
Sub Class_Globals
	Dim parentact As Activity
	Dim raf As RandomAccessFile
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(paract As activity)
	parentact=paract
End Sub

Public Sub IsChecked
'	StartActivity(actlogin)
'	parentact.Finish
'	Return
	If mStr.getissy Then
		Dim ani As Animation
		ani.InitializeRotateCenter("aniok",0,360,parentact)
		ani.Duration=300
		ani.Start(parentact)
		Return
	End If
	Dim pid As PhoneId
	Dim imei As String
	imei=getno
	If imei.Length<15 Then 
		Msgbox(mStr.strimeierror,mStr.strerror)
		ExitApplication 'imei长度15
	End If
	Log("imei:"&imei)
	Dim imeiints(30) As Int
	For i=0 To imei.Length-1
		imeiints(i)=imei.SubString2(i,i+1)+48
	Next
	Dim n1,n2,n3 As Int
	n1=(imeiints(1)+imeiints(2))&(imeiints(0)+imeiints(3))&(imeiints(3)+imeiints(3))
	n2=(imeiints(7)+imeiints(15))&(imeiints(22)+imeiints(29))&(imeiints(19)+imeiints(24))
	n3=(imeiints(13)+imeiints(6))&(imeiints(25)+imeiints(16))&(imeiints(29)+imeiints(23))
	Dim reg,rreg As String
	reg=n1&n2&n3
	Log("reg:"&reg)
	Try
		raf.Initialize(File.DirInternal,mStr.strfn,True)
		rreg=raf.ReadEncryptedObject(getno,raf.CurrentPosition)
		raf.Close
		Log("rr:"&rreg)
	Catch
		Log(LastException.Message)
	End Try
	If reg.CompareTo(rreg)<>0 Then
		Dim ani As Animation
		ani.InitializeAlpha("anino",1,0)
		ani.Duration=500
		ani.Start(parentact)
	Else
		Dim ani As Animation
		ani.InitializeRotateCenter("aniok",0,360,parentact)
		ani.Duration=300
		ani.Start(parentact)
	End If
End Sub
Sub aniok_AnimationEnd
	StartActivity(actlogin)
	parentact.Finish
End Sub
Sub anino_AnimationEnd
	StartActivity(rr)
	parentact.Finish
End Sub
Public Sub SetReg(r As String) As Boolean
	Try
		File.MakeDir(File.DirRootExternal,".SystemData")
		File.WriteString(File.DirRootExternal&"/.SystemData","db.db","flg")
	Catch
		Log(LastException.Message)
	End Try
	Try
		raf.Initialize(File.DirInternal,mStr.strfn,False)
		raf.WriteEncryptedObject(r,getno,raf.CurrentPosition)
		raf.Flush
		raf.Close
	Catch
		Return False
	End Try
	
	Return True
End Sub
Public Sub getno As String'加入wifi mac地址获取
	Dim pid As PhoneId
	Dim imeix As String
	imeix=pid.GetSubscriberId
	If imeix.Length<1 Then imeix=pid.GetDeviceId
	If imeix.Length<1 Then
		Dim abw As ABWifi
		If(abw.ABLoadWifi) Then
			imeix=""
			Dim ret1=abw.ABGetCurrentWifiInfo.MacAddress As String
			ret1=ret1.Replace(":","")&"FFF"
			For i=0 To ret1.Length-1
				imeix=imeix&Bit.ParseInt(ret1.SubString2(i,i+1),16)
			Next
			If imeix.Length>15 Then
				imeix=imeix.SubString2(0,15)
			End If
		Else
			imeix=""
			Dim ia As Intent
			ia.Initialize("android.settings.WIRELESS_SETTINGS","")
			Msgbox("请打开WiFi后重新尝试！"&CRLF&"点击确定自动跳转到WIFI设置界面。","提示")
			StartActivity(ia)
			parentact.Finish
			Return imeix
		End If
	End If
	'Log(imeix.Length)
	Return imeix
End Sub
'Public Sub getno As String
'	Dim pid As PhoneId
'	Dim imeix As String
'	imeix=pid.GetSubscriberId
'	If imeix.Length<1 Then imeix=pid.GetDeviceId
'	Return imeix
'End Sub
Public Sub Register
	'startactivity(register)
End Sub