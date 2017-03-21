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
	Public Name As String = "ChatPage"  '<-------------------------------------------------------- IMPORTANT
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	' your own variables		
	Public ChatName As String
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
	If ABMPageId <> "" Then CallSubDelayed3(ChatShared, "Disconnected", Me, ABMPageId)
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
	theme.AddChatTheme("myChat")
	theme.Chat("myChat").AddBubble("server")
	theme.Chat("myChat").Bubble("server").Color = ABM.COLOR_BLACK
	theme.Chat("myChat").Bubble("server").TextColor = ABM.COLOR_WHITE
	
	theme.Chat("myChat").AddBubble("me")
	theme.Chat("myChat").Bubble("me").Color = ABM.COLOR_LIGHTBLUE
	theme.Chat("myChat").Bubble("me").TextColor = ABM.COLOR_WHITE
	
	theme.Chat("myChat").AddBubble("them")
	theme.Chat("myChat").Bubble("them").Color = ABM.COLOR_GREY
	theme.Chat("myChat").Bubble("them").ColorIntensity = ABM.INTENSITY_LIGHTEN2
	theme.Chat("myChat").Bubble("them").TextColor = ABM.COLOR_BLACK
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.PageHTMLName = "index.html"
	page.PageTitle = ""
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
	Dim chat As ABMChat
	chat.Initialize(page, "conversation",600, 450, 255, "mychat")
	chat.AddBubble("Server", "I'm Server, what is your name?", "The Server", "server", "server")
		
	page.Cell(1,1).AddComponent(chat)
		
	Dim ChatInput As ABMInput
	ChatInput.Initialize(page, "ChatInput", ABM.INPUT_TEXT, "", False, "")
	ChatInput.PlaceHolderText = "Type your message here...."
	ChatInput.RaiseChangedEvent = True
	page.Cell(2,1).AddComponent(ChatInput)
	
	' refresh the page
	page.Refresh
	' Tell the browser we finished loading
	page.FinishedLoading
	' restoring the navigation bar position
	page.RestoreNavigationBarPosition	
End Sub

Sub ChatInput_Changed(value As String)
	If ChatShared.HasIdentified(ABMPageId) Then
		CallSubDelayed3(ChatShared, "IsTyping", ABMPageId, value)	
	End If
End Sub

Sub ChatInput_EnterPressed(value As String)
	DateTime.TimeFormat = "HH:mm"
	
	If ChatShared.HasIdentified(ABMPageId) Then
		Dim bubble As ABMChatBubble
		bubble.Initialize(ChatName, value, ChatName & " " & DateTime.Time(DateTime.Now), "me", "them")
		CallSubDelayed3(ChatShared, "NewMessage", ABMPageId, bubble)
		CallSubDelayed3(ChatShared, "IsTyping", ABMPageId, "")	
	Else
		If value = "" Then Return
		If ChatShared.AvoidDuplicates.ContainsKey(value.ToLowerCase) Then
			Dim chat As ABMChat = page.Component("conversation")
			chat.AddBubble("Server", "Sorry, but " & value & " is already taken!", "The Server", "server", "server")
			chat.Refresh
		Else	
			ChatName = value
			ChatShared.AvoidDuplicates.Put(value.ToLowerCase, value)
			Dim chat As ABMChat = page.Component("conversation")
			chat.SetMyFrom(ChatName)
			chat.AddBubble("Server", "Welcome to ABMChat " & ChatName & "!", "The Server", "server", "server")
			chat.Refresh
			CallSubDelayed3(ChatShared, "NewConnection", Me, ABMPageId)
		End If
	End If
	
	Dim ChatInput As ABMInput = page.Component("ChatInput")
	ChatInput.Text = ""
	ChatInput.Refresh	
End Sub

public Sub NewMessage(bubble As ABMChatBubble)
	Dim chat As ABMChat = page.Component("conversation")
	chat.AddBubble2(bubble)
	chat.Refresh
	chat.ScrollToBottom	' scroll to the end of the chat
End Sub

public Sub IsTyping(pageID As String, typeBool As Boolean)
	Dim chat As ABMChat = page.Component("conversation")
	If pageID <> ABMPageId Then
		If typeBool = False Then
			chat.ThemAreTyping(False, "") 'hide the 'is typing' bubble
		Else
			chat.ThemAreTyping(True, "") ' show the 'is typing' bubble if not yet shown	
		End If
		chat.Refresh
		chat.ScrollToBottom	' scroll to the end of the chat	
	End If
End Sub

public Sub CurrentConversation(LastMessages As List)
	If LastMessages.Size > 0 Then
		Dim chat As ABMChat = page.Component("conversation")
		chat.SetConversation(LastMessages)
		chat.Refresh
		chat.ScrollToBottom	' scroll to the end of the chat
	End If
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
