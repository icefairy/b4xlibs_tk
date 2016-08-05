﻿Type=Activity
Version=6
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private lvcmd As ListView
	Private edtFn As String
	Private edtcontent As EditText
	Private sv As ScrollView
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("laymain")
	Activity.Title=Application.LabelName
	sv.Panel.Height=100%y
	sv.Panel.LoadLayout("layedit")
	comm.SetPaddingCommon(edtcontent)
	lvcmd.SingleLineLayout.Label.Gravity=Gravity.CENTER
	If Starter.bCowExist=False Then
		If Starter.cpu.EqualsIgnoreCase("unknow") Then
			Msgbox("您的设备处理器类型:"&Starter.cpu&"不被支持,无法使用本软件。","不支持")
			Activity.Finish
			ExitApplication
			Return
		Else
			If Msgbox2("现在要初始化吗？","初始化","是","否","",Null)=DialogResponse.POSITIVE Then
				reinit
			Else
				Msgbox("不初始化无法使用","退出")
				Activity.Finish
				ExitApplication
			End If
		End If
		
	End If
	additem("启动","start")
	additem("停止","stop")
	additem("编辑核心配置","core")
	additem("编辑被拦截列表","blocked")
	additem("编辑直连列表","direct")
	additem("重新初始化","reinit")
End Sub
Sub additem(title As String,val As String)
	lvcmd.AddSingleLine2(title,val)
End Sub
Sub reinit
	ProgressDialogShow2("正在初始化请稍后",False)
	CallSubDelayed(Starter,"initenv")
End Sub
Sub initok
	ProgressDialogHide
	comm.TL("初始化成功")
End Sub
Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub lvcmd_ItemClick (Position As Int, Value As Object)
	Dim cmd As String=Value
	edtFn=cmd.ToLowerCase
	Select cmd.ToLowerCase
	Case "start"
		StartService(cowservice)
		comm.TL("已启动")
	Case "stop"
		CallSubDelayed(cowservice,"stopcow")
		comm.TL("已停止")
	Case "reinit"
		reinit
	Case Else
		showeditor
	End Select
End Sub
Sub showeditor
	sv.Visible=True
	sv.BringToFront
	If File.Exists("",Starter.cfgPath.Replace("core.txt",edtFn&".txt")) Then
		edtcontent.Text=File.ReadString("",Starter.cfgPath.Replace("core.txt",edtFn&".txt"))
	Else
		edtcontent.Text=File.ReadString(File.DirAssets,edtFn&".txt")
	End If
End Sub
Sub activity_KeyPress (KeyCode As Int) As Boolean 'Return True to consume the event
	If KeyCode==KeyCodes.KEYCODE_BACK Then
		If sv.Visible Then
			sv.Visible=False
			Return True
		End If
	End If
	Return False
End Sub
Sub btnreset_Click
	If File.Exists("",Starter.cfgPath.Replace("core.txt",edtFn&".txt")) Then
		edtcontent.Text=File.ReadString("",Starter.cfgPath.Replace("core.txt",edtFn&".txt"))
	Else
		edtcontent.Text=File.ReadString(File.DirAssets,edtFn&".txt")
	End If
End Sub

Sub btnsave_Click
	File.WriteString("",Starter.cfgPath.Replace("core.txt",edtFn&".txt"),edtcontent.Text.Trim)
	comm.TL("保存成功")
	sv.Visible=False
End Sub

Sub btnclose_Click
	sv.Visible=False
End Sub