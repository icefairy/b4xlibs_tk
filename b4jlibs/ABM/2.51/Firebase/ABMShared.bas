Type=StaticCode
Version=4.7
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Static code module
Sub Process_Globals
	Public MyTheme As ABMTheme	
	Private ABM As ABMaterial 'ignore	
	Public NeedsAuthorization As Boolean = False
	Public AppVersion As String = DateTime.now
	Public AppPublishedStartURL As String = ""
	' name of the app, same as in ABMApplication
	Public AppName As String = "Firebase"          '<-------------------------------------------------------- IMPORTANT
	
	Public CachedPages As Map
	Public CacheScavengePeriodSeconds As Int = 15*60 ' 15 minutes ' 10 minutes
	Public SessionMaxInactiveIntervalSeconds As Int = 30*60 ' 30 minutes 
'1*60*24 ' one hour ' -1 = immortal but beware! This means the cache is NEVER emptied!

End Sub

Public Sub NavigateToPage(ws As WebSocket, PageId As String, TargetUrl As String)	
	If AppVersion <> "" Then
		TargetUrl = TargetUrl & "?" & AppVersion
	End If
	ABM.RemoveMeFromCache(CachedPages, PageId)
	If ws.Open Then
		ws.Eval("window.location = arguments[0]", Array As Object(TargetUrl))			
		ws.Flush
	End If
End Sub	

Sub RedirectOutput (Dir As String, FileName As String) 'ignore
   #if RELEASE
   Dim out As OutputStream = File.OpenOutput(Dir, FileName, False) 'Set to True to append the logs
   Dim ps As JavaObject
   ps.InitializeNewInstance("java.io.PrintStream", Array(out, True, "utf8"))
   Dim jo As JavaObject
   jo.InitializeStatic("java.lang.System")
   jo.RunMethod("setOut", Array(ps))
   jo.RunMethod("setErr", Array(ps))
   #end if
End Sub

' build methods for ABM objects
Sub BuildTheme(themeName As String)
	MyTheme.Initialize(themeName)
	
	' the page theme
	MyTheme.Page.BackColor = ABM.COLOR_WHITE	
	
End Sub

public Sub BuildParagraph(page As ABMPage, id As String, Text As String) As ABMLabel
	Dim lbl As ABMLabel	
	lbl.Initialize(page, id, Text , ABM.SIZE_PARAGRAPH, False, "")
	Return lbl
End Sub

