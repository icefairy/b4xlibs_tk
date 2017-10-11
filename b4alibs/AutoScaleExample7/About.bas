Type=Activity
Version=7.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region Module Attributes
	#FullScreen: False
	#IncludeTitle: True
#End Region

'About Activity module
'This module uses the Scale module to scale an About layout.
Sub Process_Globals

End Sub

Sub Globals
	Dim pnlAbout As Panel
	Dim lblAboutProgram, lblAboutVersion, lblAboutAuthor, lblAboutEMail As Label
	Dim lblAboutDate, lblAboutCopyRight, lblAboutCountry As Label
	Dim lblAboutLanguage, lblAboutLanguage0, lblAboutLanguage1 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Dim ph As Phone
	If Scale.GetDevicePhysicalSize < 6 Then
		ph.SetScreenOrientation(1)
	Else
		ph.SetScreenOrientation(-1)
	End If

	Activity.LoadLayout("about")
End Sub

Sub Activity_Resume
	Activity.Title = Main.ProgName & " About"
	lblAboutProgram.Text = Main.ProgName
	lblAboutVersion.Text = Main.ProgVersion
	lblAboutAuthor.Text = Main.ProgAuthor
	lblAboutDate.Text = Main.ProgDate
	lblAboutCopyRight.Text = Main.ProgCopyright
	lblAboutCountry.Text = Main.ProgCountry
	lblAboutEMail.Text = Main.ProgEMail
End Sub

Sub Activity_Pause (UserClosed As Boolean)
	
End Sub

Sub lblAboutLanguage_Click
	Dim p As PhoneIntents
	StartActivity(p.OpenBrowser("http://www.basic4ppc.com"))	
End Sub
