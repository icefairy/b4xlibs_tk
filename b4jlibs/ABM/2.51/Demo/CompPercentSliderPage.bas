Type=Class
Version=5.45
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
	Public Name As String = "CompPercentSliderPage"
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
	theme.AddPercentSliderTheme("demo")
	theme.PercentSlider("demo").BlockColor(0,ABM.COLOR_LIGHTBLUE)
	theme.PercentSlider("demo").BlockColor(1, ABM.COLOR_GREEN)
	theme.PercentSlider("demo").BlockColor(2, ABM.COLOR_ORANGE)
	theme.PercentSlider("demo").BlockColor(3, ABM.COLOR_RED)	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMPercentSlider"
	page.PageDescription = "The percent slider component "	
	page.PageHTMLName = "abmaterial-percentslider.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMPercentSlider", "../images/logo.png", "", "Controls", "ABMPercentSlider")
	
	' create the page grid
	page.AddRows(6,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooterFixed(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","ABMPercentSlider is a slider bar that acts like a radiogroup.  It comes in handy if for input that is time based."))
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","The width of each bar is set in increments of 5% and ranges from 5% to 100%."))
	
	
	Dim label As ABMLabel
	label.Initialize(page, "label", "Choose Your Payment Schedule", ABM.SIZE_H4, False, "")
	page.Cell(2,1).AddComponent(label)
	
	Dim duration As ABMPercentSlider
	duration.Initialize(page, "duration", "demo")
	duration.AddBlock("Monthly", "awesome!", 10)
	duration.AddBlock("Quarterly", "great", 25)
	duration.AddBlock("Half-Yearly", "half is good", 55)
	duration.AddBlock("Yearly", "too long!", 100)
	duration.SetActiveUntilBlock(1)
	
	page.Cell(3,1).AddComponent(duration)
	
	Dim btn As ABMButton
	btn.InitializeFlat(page, "btn", "", "", "What was picked?", "")
	page.Cell(4,1).AddComponent(btn)
	
	' add codeblock	
	Dim code As String
	code = $"Dim duration As ABMPercentSlider
duration.Initialize(page, "duration", "demo")
duration.AddBlock("Monthly", "awesome!", 10)
duration.AddBlock("Quarterly", "great", 25)
duration.AddBlock("Half-Yearly", "half is good", 55)
duration.AddBlock("Yearly", "too long!", 100)
duration.SetActiveUntilBlock(1)"$	
		
	page.Cell(5,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code", code))
	
	code = $"Sub btn_Clicked(Target As String)
	Dim duration As ABMPercentSlider = page.Component("duration")
	Dim res As Int = duration.GetActiveUntilBlock
	
	Dim choices As List
	choices.Initialize2(Array As String("Monthly", "Quarterly", "Half-Yearly", "Yearly"))
	
	myToastId = myToastId + 1		
	page.ShowToast("toast" & myToastId, "toastred", "You picked " & choices.get(res), 5000)
End Sub"$

	page.Cell(5,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code))
	
	' also add the components to the footer
	ABMShared.ConnectFooterFixed(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub btn_Clicked(Target As String)
	Dim duration As ABMPercentSlider = page.Component("duration")
	Dim res As Int = duration.GetActiveUntilBlock
	
	Dim choices As List
	choices.Initialize2(Array As String("Monthly", "Quarterly", "Half-Yearly", "Yearly"))
	
	myToastId = myToastId + 1		
	page.ShowToast("toast" & myToastId, "toastred", "You picked " & choices.get(res), 5000)
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMPercentSlider" Then Return
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
