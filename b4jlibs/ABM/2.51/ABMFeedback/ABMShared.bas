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
	Public AppName As String = "feedback"
	
	Public CachedPages As Map
	Public CacheScavengePeriodSeconds As Int = 15*60 ' 15 minutes ' 10 minutes
	Public SessionMaxInactiveIntervalSeconds As Int = 30*60 ' 30 minutes '1*60*24 ' one hour ' -1 = immortal but beware! This means the cache is NEVER emptied!

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

Sub RedirectOutput (Dir As String, FileName As String)
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
	MyTheme.Page.BackColor = ABM.COLOR_BLUEGREY
	MyTheme.Page.BackColorIntensity = ABM.INTENSITY_LIGHTEN4
	
	' the navbar theme
	MyTheme.AddNavigationBarTheme("nav1theme")
	MyTheme.NavigationBar("nav1theme").TopBarBackColor = ABM.COLOR_LIGHTBLUE
		
	' a label header theme
	MyTheme.AddLabelTheme("lightblue")
	MyTheme.Label("lightblue").ForeColor = ABM.COLOR_LIGHTBLUE	
	MyTheme.Label("lightblue").ForeColorIntensity = ABM.INTENSITY_DARKEN2
		
	' another toast theme
	MyTheme.AddToastTheme("toastred")
	MyTheme.Toast("toastred").Rounded = True
	MyTheme.Toast("toastred").ActionForeColor = ABM.COLOR_BLACK
	MyTheme.Toast("toastred").BackColor = ABM.COLOR_RED
	
	MyTheme.AddToastTheme("toastgreen")
	MyTheme.Toast("toastgreen").Rounded = True
	MyTheme.Toast("toastgreen").ActionForeColor = ABM.COLOR_BLACK
	MyTheme.Toast("toastgreen").BackColor = ABM.COLOR_GREEN
	
	' input
	MyTheme.AddInputTheme("lightblue")
	MyTheme.Input("lightblue").FocusForeColor = ABM.COLOR_LIGHTBLUE
	MyTheme.Input("lightblue").FocusForeColorIntensity = ABM.INTENSITY_NORMAL
	
	' combo
	MyTheme.AddComboTheme("lightblue")
	MyTheme.Combo("lightblue").FocusForeColor = ABM.COLOR_LIGHTBLUE
	MyTheme.Combo("lightblue").FocusforeColorIntensity = ABM.INTENSITY_NORMAL
	
	' label	
	MyTheme.AddLabelTheme("lightblue")
	MyTheme.Label("lightblue").ForeColor = ABM.COLOR_LIGHTBLUE
	MyTheme.Label("lightblue").ForeColorIntensity = ABM.INTENSITY_DARKEN2
	
	
	' label zdepth	
	MyTheme.AddLabelTheme("lightbluezdepth")
	MyTheme.Label("lightbluezdepth").ForeColor = ABM.COLOR_LIGHTBLUE
	MyTheme.Label("lightbluezdepth").ZDepth = ABM.ZDEPTH_1
End Sub

Sub BuildNavigationBar(page As ABMPage, Title As String, logo As String, ActiveTopReturnName As String, ActiveSideReturnName As String, ActiveSideSubReturnName As String) 
	' page.SetFontStack("arial,sans-serif") is the default in 2.02+
	
	Dim sbtopimg As ABMImage
	sbtopimg.Initialize(page, "sbtopimg", logo, 1)
	sbtopimg.SetFixedSize(236, 49)

	page.NavigationBar.Initialize(page, "nav1", ABM.SIDEBAR_MANUAL_HIDEMEDIUMSMALL, Title, True, True, 300, 48, sbtopimg, ABM.COLLAPSE_ACCORDION, "nav1theme")
	page.PaddingBottom = 100
	
	page.NavigationBar.ActiveTopReturnName = ActiveTopReturnName
	page.NavigationBar.ActiveSideReturnName = ActiveSideReturnName
	page.NavigationBar.ActiveSideSubReturnName = ActiveSideSubReturnName
	
	page.NavigationBar.AddTopItem("LogOff", "", "mdi-action-exit-to-app", "", False)	
			
	page.NavigationBar.AddSideBarItem("Cases", "Overview Cases", "mdi-action-dashboard", "../OverviewCasesPage")	
	page.NavigationBar.AddSideBarDivider("")
	
	
End Sub

Sub LogOff(page As ABMPage, myAppName As String)
	Dim Network As String = page.ws.Session.GetAttribute("authType")
	Dim Name As String = page.ws.Session.GetAttribute("authName")
	Select Case Network
		Case "local"
			' do whatever you have to do to log off your user
			
			page.ws.Session.SetAttribute("authType", "")
			page.ws.Session.SetAttribute("authName", "")
			page.ws.Session.SetAttribute("IsAuthorized", "")	
			page.ws.Session.SetAttribute("UserType", "" )				
			'page.ws.Session.SetAttribute("UserID", "" ) 					
			ABM.DeleteLogin(page, myAppName)
			NavigateToPage(page.ws, page.GetPageID, "../")
		Case ABM.SOCIALOAUTH_FACEBOOK
			' the event SignedOffSocialNetwork will be raised on the page, do the rest there
			page.SignOffSocialNetwork(Network, "", Name)						
	End Select	
End Sub

Sub Mid(Text As String, Start As Int, Length As Int) As String
   Return Text.SubString2(Start-1,Start+Length-1)
End Sub

Sub Mid2(Text As String, Start As Int) As String
   Return Text.SubString(Start-1)
End Sub

Sub ReplaceAll(Text As String, Pattern As String, Replacement As String) As String
  Dim jo As JavaObject = Regex.Matcher(Pattern, Text)
  Return jo.RunMethod("replaceAll", Array(Replacement))
End Sub

public Sub BuildParagraph(page As ABMPage, id As String, Text As String) As ABMLabel
	Dim lbl As ABMLabel	
	lbl.Initialize(page, id, Text , ABM.SIZE_PARAGRAPH, False, "")
	Return lbl
End Sub

public Sub BuildParagraphBQ(page As ABMPage, id As String, Text As String) As ABMLabel
	Dim lbl As ABMLabel	
	lbl.Initialize(page, id, Text , ABM.SIZE_PARAGRAPH, False, "lightblue")
	lbl.IsBlockQuote = True
	Return lbl
End Sub

public Sub BuildParagraphBQWithZDepth(page As ABMPage, id As String, Text As String) As ABMLabel
	Dim lbl As ABMLabel	
	lbl.Initialize(page, id, Text , ABM.SIZE_PARAGRAPH, False, "lightbluezdepth")
	lbl.IsBlockQuote = True
	Return lbl
End Sub

public Sub BuildImage(page As ABMPage, id As String, image As String, opacity As Double, Caption As String) As ABMImage
	Dim img As ABMImage
	img.Initialize(page, id, image,opacity)
	img.IsMaterialBoxed = True
	img.IsResponsive = True
	img.Caption = Caption
	Return img
End Sub




