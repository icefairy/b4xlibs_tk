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
	Public Name As String = "CompAudioPlayerPage"
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
	page.PageTitle = "ABMAudioPlayer"
	page.PageDescription = "The audio player component "	
	page.PageHTMLName = "abmaterial-audioplayer.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMAudioPlayer", "../images/logo.png", "", "Controls", "ABMAudioPlayer")
		
	' create the page grid
	page.AddRows(8,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True
	
	ABMShared.BuildFooter(page)
End Sub

public Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","The ABMAudioPlayer component can be used to play mp3 files.  It can also use a playlist."))	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","You can initalize the player in two modes: narrow or full.  In narrow mode, a playlist is not supported and you can only load one song. Also note that on mobile devices, the autoPlay parameter has no effect!"))
	' add header	
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page, "hdr1", "LoadSingleSong()"))	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par3","With this method you can load one single song.  In this example, we also use the narrow version of the player."))
	
	Dim player1 As ABMAudioPlayer
	player1.Initialize(page, "player1", True, True, False, "")
	page.Cell(2,1).AddComponent(player1)
	
	Dim song As ABMAudioPlayerSong
	song.Initialize("../Audio/01 (Open) 00 00.mp3")
	song.ImageUrl = "../Audio/CoverMini.jpg"
	song.Author = "O∆"
	song.Title = "(Open) 00 00"
	
	player1.LoadSingleSong(song)
	
	Dim code1 As String = $"Dim player1 As ABMAudioPlayer
player1.Initialize(page, "player1", True, True, False, "")
page.Cell(2,1).AddComponent(player1)
	
Dim song As ABMAudioPlayerSong
song.Initialize("../Audio/01 (Open) 00 00.mp3")
song.ImageUrl = "../Audio/CoverMini.jpg"
song.Author = "O∆"
song.Title = "(Open) 00 00"
	
player1.LoadSingleSong(song)"$

	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code1))
	
	' add header	
	page.Cell(4,1).AddComponent(ABMShared.BuildHeader(page, "hdr2", "LoadPlaylist()"))	
	' add paragraph	
	page.Cell(4,1).AddComponent(ABMShared.BuildParagraph(page,"par4","With this method you can load a complete playlist (like an album). For this example we need to use the full version."))
	
	Dim player2 As ABMAudioPlayer
	player2.Initialize(page, "player2", False, True, False, "")
	page.Cell(5,1).AddComponent(player2)
	
	Dim playlist As List
	playlist.Initialize
	playlist.Add(loadSong("01 (Open) 00 00"))
	playlist.Add(loadSong("02 OATMEAL"))
	playlist.Add(loadSong("03 NATURAL"))
	playlist.Add(loadSong("04 Steal"))
	playlist.Add(loadSong("05 Nobody Hangs Out Anymore"))
	playlist.Add(loadSong("06 GUTS"))
	playlist.Add(loadSong("07 Coordinates 00 36"))
	playlist.Add(loadSong("08 Love Song"))
	playlist.Add(loadSong("09 09 87 (Where is your Home)"))
	playlist.Add(loadSong("10 SURVIVE"))
		
	player2.LoadPlaylist(playlist)
	
	Dim Code2 As String = $"Dim player2 As ABMAudioPlayer
player2.Initialize(page, "player2", False, True, False, "")
page.Cell(5,1).AddComponent(player2)
	
Dim playlist As List
playlist.Initialize
playlist.Add(loadSong("01 (Open) 00 00"))
playlist.Add(loadSong("02 OATMEAL"))
playlist.Add(loadSong("03 NATURAL"))
playlist.Add(loadSong("04 Steal"))
playlist.Add(loadSong("05 Nobody Hangs Out Anymore"))
playlist.Add(loadSong("06 GUTS"))
playlist.Add(loadSong("07 Coordinates 00 36"))
playlist.Add(loadSong("08 Love Song"))
playlist.Add(loadSong("09 09 87 (Where is your Home)"))
playlist.Add(loadSong("10 SURVIVE"))
		
player2.LoadPlaylist(playlist)"$

	page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", Code2))
	
	Dim Code3 As String = $"Sub loadSong(Title As String) As ABMAudioPlayerSong
	Dim song As ABMAudioPlayerSong
	song.Initialize("../Audio/" & Title & ".mp3")
	song.ImageUrl = "../Audio/CoverMini.jpg"
	song.Author = "O∆"
	song.Title = Title
	Return song
End Sub"$

	page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code3", Code3))
	
	
	' add header	
	page.Cell(7,1).AddComponent(ABMShared.BuildHeader(page, "hdr2", "Lyrics"))	
	' add paragraph	
	page.Cell(7,1).AddComponent(ABMShared.BuildParagraph(page,"par4","You can load Lyrics with the song if you want (full modus). It is a smple list of strings, but they have to be in a certain format. (Take special note to the time prefix: {B}[00:00.00]{/B}. Full specs of the lyrics format can be found here: {AL}https://en.wikipedia.org/wiki/LRC_(file_format){AT}LRC format{/AL}"))

	Dim Code4 As String = $"Dim song As ABMAudioPlayerSong = loadSong("02 OATMEAL")
song.Lyrics.AddAll(LoadLyrics)
playlist.add(song)"$

	page.Cell(8,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code4", Code4))

	Dim Code5 As String = $"Sub LoadLyrics() As List
	Dim l As List
	l.Initialize
	
	l.Add("[ar:Beatles]")
	l.Add("[ti:Hello goodbye]")
	l.Add("[la:uk]")
	l.Add("[00:00.00]You say yes, I say no.")
	l.Add("[00:04.00]You say stop And I say go go go, oh no.")
	l.Add("[00:17.00]You say goodbye And I say hello")
	l.Add("[00:22.00]Hello hello")
	l.Add("[00:25.00]I don't know why you say goodbye, Isay hello")
	l.Add("[00:30.00]Hello hello")
	l.Add("[00:32.00]I don't know why you say goodbye, I say hello.")
	l.Add("[00:38.00]I say high, you say low.")
	l.Add("[00:42.00]You say why And I say I don't know, oh no.")
	l.Add("[00:55.00]You say goodbye And I say hello")
	l.Add("[00:59.00]HELLO GOODBYE HELLO GOODBYE hello hello")
	l.Add("[01:02.00]HELLO GOODBYE I don't know why you say goodbye, I say hello")
	l.Add("[01:06.00]HELLO GOODBYE HELLO GOODBYE hello hello")
	l.Add("[01:09.00]HELLO GOODBYE I don't know why you say goodbye")
	l.Add("[01:12.00]HELLO GOODBYE I say goodbye.")
	l.Add("[01:20.00]Why why why why why why Do you say goodbye goodbye, oh no?")
	l.Add("[01:32.00]You say goodbye And I say hello")
	l.Add("[01:38.00]Hello hello")
	l.Add("[01:40.00]I don't know why you say goodbye, I say hello")
	l.Add("[01:45.00]Hello hello")
	l.Add("[01:47.00]I don't know why you say goodbye, I say hello.")
	l.Add("[01:53.00]You say yes I SAY YES I say no BUT I MAY MEAN NO.")
	l.Add("[01:58.00]You say stop I CAN STAY And I say go go go TILL IT'S TIME TO GO OH, oh no.")
	l.Add("[02:10.00]You say goodbye And I say hello")
	l.Add("[02:15.00]Hello hello")
	l.Add("[02:17.00]I don't know why you say goodbye, I say hello")
	l.Add("[02:22.00]Hello hello")
	l.Add("[02:24.00]I don't know why you say goodbye, I say hello")
	l.Add("[02:29.00]Hello hello")
	l.Add("[02:32.00]I don't know why you say goodbye, I say hello hello.")
	l.Add("[02:45.00]Hela heba helloa CHA CHA.................")
	
	Return l
End Sub"$

	page.Cell(8,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code5", Code5))
	
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
	If Action = "ABMAudioPlayer" Then Return
	If Action = "Contact" Then	
		myToastId = myToastId + 1	
		page.ShowToast("toast" & myToastId, "toastred", "Hello to you too!", 5000)
		Log(ws.Session.GetAttribute("test"))
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

Sub loadSong(Title As String) As ABMAudioPlayerSong
	Dim song As ABMAudioPlayerSong
	song.Initialize("../Audio/" & Title & ".mp3")
	song.ImageUrl = "../Audio/CoverMini.jpg"
	song.Author = "O∆"
	song.Title = Title
	Return song
End Sub

Sub LoadLyrics() As List 'ignore
	Dim l As List
	l.Initialize
	
	l.Add("[ar:Beatles]")
	l.Add("[ti:Hello goodbye]")
	l.Add("[la:uk]")
	l.Add("[00:00.00]You say yes, I say no.")
	l.Add("[00:04.00]You say stop And I say go go go, oh no.")
	l.Add("[00:17.00]You say goodbye And I say hello")
	l.Add("[00:22.00]Hello hello")
	l.Add("[00:25.00]I don't know why you say goodbye, Isay hello")
	l.Add("[00:30.00]Hello hello")
	l.Add("[00:32.00]I don't know why you say goodbye, I say hello.")
	l.Add("[00:38.00]I say high, you say low.")
	l.Add("[00:42.00]You say why And I say I don't know, oh no.")
	l.Add("[00:55.00]You say goodbye And I say hello")
	l.Add("[00:59.00]HELLO GOODBYE HELLO GOODBYE hello hello")
	l.Add("[01:02.00]HELLO GOODBYE I don't know why you say goodbye, I say hello")
	l.Add("[01:06.00]HELLO GOODBYE HELLO GOODBYE hello hello")
	l.Add("[01:09.00]HELLO GOODBYE I don't know why you say goodbye")
	l.Add("[01:12.00]HELLO GOODBYE I say goodbye.")
	l.Add("[01:20.00]Why why why why why why Do you say goodbye goodbye, oh no?")
	l.Add("[01:32.00]You say goodbye And I say hello")
	l.Add("[01:38.00]Hello hello")
	l.Add("[01:40.00]I don't know why you say goodbye, I say hello")
	l.Add("[01:45.00]Hello hello")
	l.Add("[01:47.00]I don't know why you say goodbye, I say hello.")
	l.Add("[01:53.00]You say yes I SAY YES I say no BUT I MAY MEAN NO.")
	l.Add("[01:58.00]You say stop I CAN STAY And I say go go go TILL IT'S TIME TO GO OH, oh no.")
	l.Add("[02:10.00]You say goodbye And I say hello")
	l.Add("[02:15.00]Hello hello")
	l.Add("[02:17.00]I don't know why you say goodbye, I say hello")
	l.Add("[02:22.00]Hello hello")
	l.Add("[02:24.00]I don't know why you say goodbye, I say hello")
	l.Add("[02:29.00]Hello hello")
	l.Add("[02:32.00]I don't know why you say goodbye, I say hello hello.")
	l.Add("[02:45.00]Hela heba helloa CHA CHA.................")
	
	Return l
End Sub