Type=Activity
Version=6.25
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private PnlBarCode As cvCRZxing
	Private ImgLight As ImageView
	Private ap As AnimationPlus
	Private PnlFocus As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("layscanner")
	PnlBarCode.bScanOnce=False '设置只扫描一次
	ap.InitializeTranslate("ap",0,0,0,PnlFocus.Height-20dip)
	ap.Duration=1500
	ap.PersistAfter=True
	ap.StartOffset=0
	ap.RepeatMode=ap.REPEAT_REVERSE
	ap.RepeatCount=9999
	ap.Start(ImgLight)
End Sub
Sub Activity_KeyPress (KeyCode As Int) As Boolean 'Return True to consume the event
	If KeyCode==KeyCodes.KEYCODE_BACK Then
		stopscanner
	End If
	Return False
End Sub
Sub Activity_Resume
	PnlBarCode.startPreView
	ap.Start(ImgLight)
End Sub
Sub stopscanner
	PnlBarCode.stopPreView
	ap.Stop(ImgLight)
	'Log("stop scanner")
End Sub
Sub Activity_Pause (UserClosed As Boolean)
	stopscanner
End Sub

public Sub tl(str As String)
	ToastMessageShow(str,False)
	Log(str)
End Sub

Sub PnlBarCode_onCamError (errMsg As String)
	tl("Error:"&errMsg)
End Sub

Sub PnlBarCode_onZxDecResult (result As String)
	'tl(result)
	stopscanner
	CallSubDelayed2(Main,"gotzxresult",result)
	Activity.Finish
End Sub
