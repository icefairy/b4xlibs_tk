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
	Public Name As String = "CompCodeLabelPage"
	' will hold the unique browsers window id
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
	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMCodeLabel"
	page.PageDescription = "The code label component "	
	page.PageHTMLName = "abmaterial-code-label.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMCodeLabel", "../images/logo.png", "", "Controls", "ABMCodeLabel")
		
	' create the page grid
	page.AddRows(5,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","ABMCodeLabels are blocks that represent source programming code within your page.  It can be used, like for this app, to make a help website or tutorial that explains your library.") )	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","There are two methods to setup your source code string: Using a B4J List object or using the B4J Smart Strings.  An example of both, you can use the one you feel most comfortable with.  Note, Smart Strings cannon show everything: Using as code Sub Name() ... End Sub ... Sub Name2() ... End Sub will not work with Smart Strings!") )	
	
	' add codeblock	
	Dim code1 As StringBuilder
	code1.Initialize
	code1.Append("// add codeblock").Append(CRLF)	
	code1.Append("Dim code2 As StringBuilder").Append(CRLF)
	code1.Append("code2.Initialize").Append(CRLF)
	code1.Append("code2.Append(""Dim btn4 As ABMButton"").Append(CRLF)").Append(CRLF)
	code1.Append("code2.Append(""btn4.Initializefloating(page, ""btn4"", ""mdi-image-palette"", ""darkred"")"").Append(CRLF)").Append(CRLF)
	code1.Append("code2.Append(""btn4.size = ABM.BUTTONSIZE_LARGE"").Append(CRLF)").Append(CRLF)
	code1.Append("code2.Append(""page.Cell(5,1).AddComponent(btn4)"").Append(CRLF)").Append(CRLF)
	code1.Append("page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlock(page, ""code2"", code2))").Append(CRLF)
		
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlock(page, "code1", code1))
	
	' add codeblock	
	Dim code4 As StringBuilder
	code4.Initialize
	code4.Append("// add codeblock").Append(CRLF)	
	code4.Append("Dim code3 As String = $""Dim btn4 As ABMButton").Append(CRLF)
	code4.Append("btn4.Initializefloating(page, ""btn4"", ""mdi-image-palette"", ""darkred"")").Append(CRLF)
	code4.Append("btn4.size = ABM.BUTTONSIZE_LARGE").Append(CRLF)
	code4.Append("page.Cell(5,1).AddComponent(btn4)""$").Append(CRLF)
	code4.Append("page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, ""code3"", code3))").Append(CRLF)
			
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code4", code4))
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMCodeLabel" Then Return
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
