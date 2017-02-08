Type=Class
Version=4.7
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	Private ws As WebSocket 'ignore
	' will hold our page information
	Public page As ABMPage
	' page theme
	Private theme As ABMTheme
	' to access the constants
	Private ABM As ABMaterial 'ignore	
	' name of the page, must be the same as the class name (case sensitive!)
	Public Name As String = "CompSwitchPage"
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	' build the local structure IMPORTANT!
	BuildPage
End Sub

Private Sub WebSocket_Connected (WebSocket1 As WebSocket)
	Log("Connected")
	ws = WebSocket1	
	ABMPageId = ABM.GetPageID(page, Name,ws)
	Dim session As HttpSession = ABM.GetSession(ws, ABMShared.SessionMaxInactiveIntervalSeconds)
	
	If ABMShared.NeedsAuthorization Then
		If session.GetAttribute2("IsAuthorized", "") = "" Then
			ABMShared.NavigateToPage(ws, ABMPageId, "../")
			Return
		End If
	End If		
	
	ABM.UpdateFromCache(Me, ABMShared.CachedPages, ABMPageId, ws)
	If page.ComesFromPageCache Then
		' refresh the page
		page.Refresh
		' because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
		page.FinishedLoading
	Else
		' Prepare the page 
		page.Prepare
		' load the dynamic content
		ConnectPage
	End If
	Log(ABMPageId)
End Sub

Private Sub WebSocket_Disconnected
	Log("Disconnected")		
End Sub

Sub Page_ParseEvent(Params As Map) 
	Dim eventName As String = Params.Get("eventname")
	Dim eventParams() As String = Regex.Split(",",Params.Get("eventparams"))
	If eventName = "beforeunload" Then
		Log("preparing for url refresh")	
		ABM.RemoveMeFromCache(ABMShared.CachedPages, ABMPageId)	
		Return
	End If
	If SubExists(Me, eventName) Then
		Params.Remove("eventname")
		Params.Remove("eventparams")
		Select Case Params.Size
			Case 0
				CallSub(Me, eventName)
			Case 1
				CallSub2(Me, eventName, Params.Get(eventParams(0)))					
			Case 2
				If Params.get(eventParams(0)) = "abmistable" Then
					Dim PassedTables As List = ABM.ProcessTablesFromTargetName(Params.get(eventParams(1)))
					CallSub2(Me, eventName, PassedTables)
				Else
					CallSub3(Me, eventName, Params.Get(eventParams(0)), Params.Get(eventParams(1)))
				End If
			Case Else
				' cannot be called directly, to many param
				CallSub2(Me, eventName, Params)				
		End Select
	End If
End Sub

public Sub BuildTheme()
	' start with the base theme defined in ABMShared
	theme.Initialize("pagetheme")
	theme.AddABMTheme(ABMShared.MyTheme)
	
	' add additional themes specific for this page
	theme.AddSwitchTheme("switchtheme")
	theme.Switch("switchtheme").LabelFontSize = "1rem"
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMSwitch"
	page.PageDescription = "The switch component "	
	page.PageHTMLName = "abmaterial-switch.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMSwitch", "../images/logo.png", "", "Controls", "ABMSwitch")
	
	' create the page grid
	page.AddRows(5,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Switches are a modern alternative to a checkbox.") )
	
	Dim switch1 As ABMSwitch
	switch1.Initialize(page, "switch1","On", "Off", True, "switchtheme")
	page.Cell(2,1).AddComponent(switch1)
	
	Dim switch2 As ABMSwitch
	switch2.Initialize(page, "switch2","On", "Off", False, "switchtheme")
	switch2.Enabled=False
	page.Cell(3,1).AddComponent(switch2)
	
	' add codeblock	
	Dim code As StringBuilder
	code.Initialize
	code.Append("Dim switch1 As ABMSwitch").Append(CRLF)
	code.Append("switch1.Initialize(page, ""switch1"",""On"", ""Off"", True, """")").Append(CRLF)
	code.Append("page.Cell(2,1).AddComponent(switch1)").Append(CRLF)
	code.Append("").Append(CRLF)
	code.Append("Dim switch2 As ABMSwitch").Append(CRLF)
	code.Append("switch2.Initialize(page, ""switch2"",""On"", ""Off"", false, """")").Append(CRLF)
	code.Append("switch2.Enabled=False").Append(CRLF)
	code.Append("page.Cell(3,1).AddComponent(switch2)").Append(CRLF)
		
	page.Cell(4,1).AddComponent(ABMShared.BuildCodeBlock(page, "code", code))
	
	' add codeblock	
	Dim code2 As StringBuilder
	code2.Initialize
	code2.Append("Sub switch1_Clicked(Target as String)").Append(CRLF)
	code2.Append("   Dim checked As String").Append(CRLF)
	code2.Append("   Dim switch1 As ABMSwitch = page.Component(""switch1"")").Append(CRLF)
	code2.Append("   If switch1.State Then").Append(CRLF)
	code2.Append("      checked= ""On""").Append(CRLF)
	code2.Append("   Else").Append(CRLF)
	code2.Append("      checked= ""Off""").Append(CRLF)
	code2.Append("   End If").Append(CRLF)
	code2.Append("   Dim myTexts, myReturns As List").Append(CRLF)
	code2.Append("   myTexts.Initialize").Append(CRLF)
	code2.Append("   myReturns.Initialize").Append(CRLF)
	code2.Append("   myToastId = myToastId + 1").Append(CRLF)
	code2.Append("   page.ShowToast(""toast"" & myToastId, ""toastred"", ""Switch is "" & checked, 5000, myTexts, myReturns)").Append(CRLF)
	code2.Append("End Sub").Append(CRLF)
	
	page.Cell(5,1).AddComponent(ABMShared.BuildCodeBlock(page, "code2", code2))	
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	Page.RestoreNavigationBarPosition
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMSwitch" Then Return
	If Action = "Contact" Then		
		myToastId = myToastId + 1	
		page.ShowToast("toast" & myToastId, "toastred", "Hello to you too!", 5000)
		Return
	End If
	If Action = "LogOff" Then
		ABMShared.LogOff(page)
		Return
	End If
	ABMShared.NavigateToPage(ws, ABMPageId, Value)
End Sub

Sub Page_SignedOffSocialNetwork(Network As String, Extra As String)
	page.ws.Session.SetAttribute("authType", "")
	page.ws.Session.SetAttribute("authName", "")
	page.ws.Session.SetAttribute("IsAuthorized", "")			
	ABMShared.NavigateToPage(ws, ABMPageId, "../")
End Sub


Sub switch1_Clicked(Target As String)
	Dim checked As String
	Dim switch1 As ABMSwitch = page.Component("switch1")
	If switch1.State Then
		checked= "On"	
	Else
		checked= "Off"
	End If	
	myToastId = myToastId + 1
	page.ShowToast("toast" & myToastId, "toastred", "Switch is " & checked, 5000)
End Sub