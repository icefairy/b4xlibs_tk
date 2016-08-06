Type=Service
Version=6
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
'	Private psh As Phone
	Public cpu As String="",cowPath,cfgPath As String
	Public bCowExist As Boolean=False,bCfgExist As Boolean=False
	Public cowVersion As String="0.98"
'	Dim nb As NotificationBuilder

End Sub

Sub Service_Create
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.
	cowPath=File.DirInternal&"/cow"
	cowPath=cowPath.Replace("/files","")
	cfgPath=cowPath.Replace("/cow","/core.txt")
	checkfilesexist
	
End Sub

Sub Service_Start (StartingIntent As Intent)
	getcpuversion
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub
Private Sub getcpuversion
	Dim sb As StringBuilder
	sb.Initialize
	sb.Append(comm.Shell("cat /proc/cpuinfo"))
	'Log(sb.ToString)
	Dim str As String=sb.ToString.ToLowerCase
	If sb.ToString.IndexOf("armv6")>-1 Then
		cpu="armv6"
	else if str.IndexOf("armv7")>-1 Then
		cpu="armv7"
	Else 
		cpu="unknow"
	End If
	Log("cpu="&cpu)
	Log(File.DirInternal)
End Sub
Private Sub checkfilesexist
	Log("cowPath:"&cowPath)
	bCowExist=File.Exists("",cowPath)
End Sub
Private Sub checkcfgfilesexist
	Log("cowPath:"&cowPath)
	bCowExist=File.Exists("",cowPath)
End Sub
Sub initenv
	If cpu.EqualsIgnoreCase("unknow") Then
		comm.TL("Sorry CPU:"&cpu&" not support")
		Return
	End If
	File.Copy(File.DirAssets,cpu,"",cowPath)
	File.Copy(File.DirAssets,"core.txt","",cfgPath)
	Dim ret As String=comm.shell("chmod 0777 "&cowPath)
	Log(ret)
	checkfilesexist
	CallSubDelayed(actmain,"initok")
End Sub



Sub Service_Destroy
	
End Sub
