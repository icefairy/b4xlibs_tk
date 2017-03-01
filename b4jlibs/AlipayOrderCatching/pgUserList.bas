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
	Public Name As String = "pgUserList"  '<-------------------------------------------------------- IMPORTANT
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	' your own variables		
	
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
		' Tell the browser we finished loading
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
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.PageHTMLName = "userlist.html"
	page.PageTitle = "用户列表"
	page.PageDescription = ""
	page.PageKeywords = ""
	page.PageSiteMapPriority = ""
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_YEARLY
	
	page.ShowConnectedIndicator = True
		
	' adding a navigation bar
	
			
	' create the page grid
	page.AddRows(2,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
End Sub

public Sub ConnectPage()
'	connecting the navigation bar
		
	
'	init all your own variables (like a List, Map) and add your components

'	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page, "lbl", "This is a test"))
'	
'	Dim btn As ABMButton
'	btn.InitializeRaised(page, "btn", "", "", "Press me", "")
'	page.Cell(2,1).AddComponent(btn)
	
	' refresh the page
	page.Refresh
	' Tell the browser we finished loading
	page.FinishedLoading
	' restoring the navigation bar position
	page.RestoreNavigationBarPosition
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	' saving the navigation bar position
	page.SaveNavigationBarPosition
	If Action = "LogOff" Then
		ABMShared.LogOff(page)
		Return
	End If
	ABMShared.NavigateToPage(ws, ABMPageId, Value)
End Sub

Sub Page_FileUploaded(FileName As String, success As Boolean)	
	
End Sub

Sub Page_ToastClicked(ToastId As String, Action As String)
		
End Sub

Sub Page_ToastDismissed(ToastId As String)	
	
End Sub

Sub Page_Authenticated(Params As Map)
	
End Sub

Sub Page_FirebaseAuthError(extra As String)
	
End Sub

Sub Page_FirebaseAuthStateChanged(IsLoggedIn As Boolean)
	
End Sub

Sub Page_FirebaseStorageError(jobID As String, extra As String)
	
End Sub

Sub Page_FirebaseStorageResult(jobID As String, extra As String)
	
End Sub

Sub Page_ModalSheetDismissed(ModalSheetName As String)
	
End Sub

Sub Page_NextContent(TriggerComponent As String)
	
End Sub

Sub Page_SignedOffSocialNetwork(Network As String, Extra As String)
	
End Sub