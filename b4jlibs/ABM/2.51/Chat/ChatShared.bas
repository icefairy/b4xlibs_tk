Type=StaticCode
Version=4.7
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@

Sub Process_Globals
	Public AvoidDuplicates As Map
	Private connections As Map
	Public LastMessages As List
	Private IsTypingMap As Map
End Sub

public Sub Init
	AvoidDuplicates = Main.srvr.CreateThreadSafeMap
	connections.Initialize
	LastMessages.Initialize
	IsTypingMap.Initialize
End Sub

public Sub NewConnection(page As ChatPage, pageID As String) 
	DateTime.TimeFormat = "HH:mm"
	
	Dim IdentifyBubble As ABMChatBubble
	IdentifyBubble.Initialize("Server", page.ChatName & " has joined the chat...", "Server " & DateTime.Time(DateTime.Now), "server", "server")
	JoinLeftMessage(pageID, IdentifyBubble)
	connections.Put(pageID, page)
	CallSubDelayed2(page, "CurrentConversation", LastMessages)
End Sub

public Sub NewMessage(pageID As String, Message As ABMChatBubble)
	LastMessages.Add(Message)
	For Each page As ChatPage In connections.Values
		CallSubDelayed2(page, "NewMessage", Message)
	Next
End Sub

public Sub JoinLeftMessage(pageID As String, Message As ABMChatBubble)
	For Each page As ChatPage In connections.Values
		CallSubDelayed2(page, "NewMessage", Message)
	Next
End Sub

public Sub IsTyping(pageID As String, Value As String)
	Dim typeBool As Boolean
	If Value = "" Then
		IsTypingMap.Remove(pageID.ToLowerCase)
	Else
		IsTypingMap.put(pageID.ToLowerCase, "true")
	End If
	If IsTypingMap.Size > 0 Then
		typeBool = True
	End If
	For Each page As ChatPage In connections.Values		
		CallSubDelayed3(page, "IsTyping", pageID, typeBool)
	Next
End Sub

public Sub Disconnected(page As ChatPage, pageID As String)
	If connections.ContainsKey(pageID) = False Or connections.Get(pageID) <> page Then Return
	Dim LeaveBubble As ABMChatBubble
	LeaveBubble.Initialize("Server", page.ChatName & " has left the chat...", "Server " & DateTime.Time(DateTime.Now), "server","server")
	JoinLeftMessage(pageID, LeaveBubble)
	connections.Remove(pageID)
	AvoidDuplicates.Remove(pageID.ToLowerCase)
End Sub

Public Sub HasIdentified(pageID As String) As Boolean
	Return connections.ContainsKey(pageID)
End Sub