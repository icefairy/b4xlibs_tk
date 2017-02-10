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
	Public Name As String = "CompVideoPage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim Origin As String = "http://localhost:51042" '<--- IMPORTANT for youtube videos.  Set here your website address
	Dim myToastId As Int
	
	Dim IsPlaying As Boolean = False
	Dim IsMuted As Boolean = False
	Dim Volume As Int = 100
	Dim InitialVideo As Boolean = True
	
	Dim IsPlaying5 As Boolean = False
	Dim IsMuted5 As Boolean = False
	Dim Volume5 As Int = 100
	Dim InitialVideo5 As Boolean = True
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
	' bluegray button
	theme.AddButtonTheme("bluegrey")
	theme.Button("bluegrey").BackColor = ABM.COLOR_BLUEGREY
	theme.Button("bluegrey").BackColorIntensity = ABM.INTENSITY_DARKEN1
	
	' darkred button
	theme.AddButtonTheme("darkred")
	theme.Button("darkred").BackColor = ABM.COLOR_RED
	theme.Button("darkred").BackColorIntensity = ABM.INTENSITY_DARKEN1
	
	theme.AddCellTheme("aligncenter")
	theme.Cell("aligncenter").Align = ABM.CELL_ALIGN_CENTER
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMVideo"
	page.PageDescription = "The video component "	
	page.PageHTMLName = "abmaterial-video.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMVideo", "../images/logo.png", "", "Controls", "ABMVideo")
		
	' create the page grid
	page.AddRows(18,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page, "par1", "ABMaterial can use three types of Video containers: HTML5 videos, Youtube videos and Vimeo videos. They have their own Initialize method."))
	
	' add header	
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page, "hdr1", "Youtube videos"))	
	
	' add paragraph
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page, "par2", "For Youtube videos you have to specify if it has controls, a frameborder, if it allows to go full screen and the initial volume."))
		
	' add Youtube video
	Dim video1 As ABMVideo
	video1.InitializeYoutube(page, "video1", "//www.youtube.com/embed/Q8TXgCzxEnw", Origin, True, False, True,100)
	page.Cell(2,1).AddComponent(video1)
	
	' add codeblock	
	Dim code1 As StringBuilder
	code1.Initialize
	code1.Append("// add Youtube video").Append(CRLF)
	code1.Append("Dim video1 As ABMVideo").Append(CRLF)
	code1.Append("video1.InitializeIframe(page, ""video1"", ""//www.youtube.com/embed/Q8TXgCzxEnw"", ""http://localhost:51042"", True, False, True, 100)").Append(CRLF)
	code1.Append("page.Cell(2,1).AddComponent(video1)").Append(CRLF)
	
	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlock(page, "code1", code1))
	
	' add paragraph
	page.Cell(4,1).AddComponent(ABMShared.BuildParagraph(page, "par2b", "If you disable the youtube controls, you have to write your own play, pause, stop etc controls."))
	
	' add Youtube video
	Dim video1b As ABMVideo
	video1b.InitializeYoutube(page, "video1b", "//www.youtube.com/embed/Q8TXgCzxEnw", Origin, False, False, False, 100)
	page.Cell(5,1).AddComponent(video1b)
	
	' add youtube controls
	Dim btnPlay As ABMButton
	btnPlay.Initializefloating(page, "btnPlay", "mdi-av-play-arrow", "darkred")
	page.Cell(6,1).AddComponent(btnPlay)
	
	Dim btnStop As ABMButton
	btnStop.Initializefloating(page, "btnStop", "mdi-av-stop", "darkred")
	page.Cell(6,1).AddComponent(btnStop)
	
	Dim btnMute As ABMButton
	btnMute.Initializefloating(page, "btnMute", "mdi-av-volume-mute", "darkred")
	page.Cell(6,1).AddComponent(btnMute)
	
	Dim btnVolumeDown As ABMButton
	btnVolumeDown.Initializefloating(page, "btnVolumeDown", "mdi-av-volume-down", "darkred")
	page.Cell(6,1).AddComponent(btnVolumeDown)
	
	Dim btnVolumeUp As ABMButton
	btnVolumeUp.Initializefloating(page, "btnVolumeUp", "mdi-av-volume-up", "darkred")
	page.Cell(6,1).AddComponent(btnVolumeUp)
	
	Dim btn As ABMButton
	btn.InitializeRaised(page, "btn", "", "", "Load Other", "bluegrey")
	page.Cell(6,1).AddComponent(btn)
	
	' add header	
	page.Cell(8,1).AddComponent(ABMShared.BuildHeader(page, "hdr1", "HTML videos"))	
	
	' add paragraph
	page.Cell(8,1).AddComponent(ABMShared.BuildParagraph(page, "par2", "For HTML5 videos you have to specify if it has controls and what video type is used."))
	
	' add HTML5 video
	Dim video2 As ABMVideo
	video2.InitializeHTML5(page, "video2", "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4", False, "video/mp4")
	page.Cell(9,1).AddComponent(video2)
	
	' add youtube controls
	Dim btnPlay5 As ABMButton
	btnPlay5.Initializefloating(page, "btnPlay5", "mdi-av-play-arrow", "darkred")
	page.Cell(10,1).AddComponent(btnPlay5)
	
	Dim btnStop5 As ABMButton
	btnStop5.Initializefloating(page, "btnStop5", "mdi-av-stop", "darkred")
	page.Cell(10,1).AddComponent(btnStop5)
	
	Dim btnMute5 As ABMButton
	btnMute5.Initializefloating(page, "btnMute5", "mdi-av-volume-mute", "darkred")
	page.Cell(10,1).AddComponent(btnMute5)
	
	Dim btnVolumeDown5 As ABMButton
	btnVolumeDown5.Initializefloating(page, "btnVolumeDown5", "mdi-av-volume-down", "darkred")
	page.Cell(10,1).AddComponent(btnVolumeDown5)
	
	Dim btnVolumeUp5 As ABMButton
	btnVolumeUp5.Initializefloating(page, "btnVolumeUp5", "mdi-av-volume-up", "darkred")
	page.Cell(10,1).AddComponent(btnVolumeUp5)	
	
	Dim btn5 As ABMButton
	btn5.InitializeRaised(page, "btn5", "", "", "Load Other", "bluegrey")
	page.Cell(10,1).AddComponent(btn5)
	
	' add codeblock	
	Dim code2 As StringBuilder
	code2.Initialize
	code2.Append("// add HTML5 video").Append(CRLF)
	code2.Append("Dim video2 As ABMVideo").Append(CRLF)
	code2.Append("video2.InitializeHTML5(page, ""video2"", ""http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"", false, ""video/mp4"")").Append(CRLF)
	code2.Append("page.Cell(9,1).AddComponent(video2)").Append(CRLF)
	
	page.Cell(11,1).AddComponent(ABMShared.BuildCodeBlock(page, "code2", code2))	
	
	' add header	
	page.Cell(12,1).AddComponent(ABMShared.BuildHeader(page, "hdr4", "Vimeo videos"))	
	
	' add paragraph
	page.Cell(12,1).AddComponent(ABMShared.BuildParagraph(page, "par4", "For Vimeo videos you have to specify frameborder and if it allows to go full screen. The vimeo API is very limited and does not allow custom controls."))
		
	' add Vimeo video
	Dim video4 As ABMVideo
	video4.InitializeVimeo(page, "video4", "https://player.vimeo.com/video/76979871",False, True)
	page.Cell(13,1).AddComponent(video4)
	
	' add codeblock	
	Dim code4 As String = $"// add Vimeo video
Dim video4 As ABMVideo
video4.InitializeVimeo(page, "video4", "https://player.vimeo.com/video/76979871",False, True)
page.Cell(13,1).AddComponent(video4)"$
	page.Cell(14,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code4", code4))	
	
	' add header	
	page.Cell(15,1).AddComponent(ABMShared.BuildHeader(page, "hdr2", "Video Size"))	
	
	' add paragraph
	page.Cell(15,1).AddComponent(ABMShared.BuildParagraph(page, "par2", "By default the videos are responsive and they will be sized automatically.  You can overrule this by specifying a fixed size."))
	
	' add HTML5 video
	Dim video3 As ABMVideo
	video3.InitializeHTML5(page, "video3", "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4", True, "video/mp4")
	video3.SetFixedSize(320, 200)
	page.Cell(16,1).UseTheme("aligncenter")
	page.Cell(16,1).AddComponent(video3)
	
	' add codeblock	
	Dim code3 As StringBuilder
	code3.Initialize
	code3.Append("// add HTML5 video").Append(CRLF)
	code3.Append("Dim video3 As ABMVideo").Append(CRLF)
	code3.Append("video3.InitializeHTML5(page, ""video3"", ""http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"", True, ""video/mp4"")").Append(CRLF)
	code3.Append("video3.SetFixedSize(320, 200)").Append(CRLF)
	code3.Append("page.Cell(13,1).AddComponent(video3)").Append(CRLF)
	
	page.Cell(17,1).AddComponent(ABMShared.BuildCodeBlock(page, "code3", code3))	
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub video1b_YouTubeStateChanged(State As Int)	
	Select Case State
		Case ABM.YOUTUBESTATE_PLAYING
			IsPlaying = True
			Dim btnPlay As ABMButton = page.Component("btnPlay")
			btnPlay.IconName = "mdi-av-pause"	
			btnPlay.Refresh ' IMPORTANT			
		Case ABM.YOUTUBESTATE_VIDEOCUED
			Dim video As ABMVideo = page.Component("video1b")
			video.Play
		Case Else
			If IsPlaying Then
				IsPlaying = False
				Dim btnPlay As ABMButton = page.Component("btnPlay")
				btnPlay.IconName = "mdi-av-play-arrow"			
				btnPlay.Refresh ' IMPORTANT
			End If
	End Select
End Sub

Sub btn_Clicked(Target As String)
	Dim button As ABMButton = page.Component("btn")
	Dim video As ABMVideo = page.Component("video1b")
	If InitialVideo Then
		button.Text = "Load Original"	
		InitialVideo = False
		video.LoadVideoYouTube("rrT6v5sOwJg")	
	Else
		button.Text = "Load Other"	
		InitialVideo = True
		video.LoadVideoYouTube("Q8TXgCzxEnw")
	End If
	button.refresh ' IMPORTANT
End Sub

Sub btnPlay_Clicked(Target As String)
	Dim video As ABMVideo = page.Component("video1b")
	If IsPlaying Then
		video.Pause				
	Else
		video.Play						
	End If	
End Sub

Sub btnStop_Clicked(Target As String)
	Dim video As ABMVideo = page.Component("video1b")
	video.Stop
End Sub

Sub btnVolumeDown_Clicked(Target As String)
	Dim video As ABMVideo = page.Component("video1b")	
	Volume = Volume - 10
	If Volume < 0 Then Volume = 0
	video.SetVolume(Volume)
End Sub

Sub btnVolumeUp_Clicked(Target As String)
	Dim video As ABMVideo = page.Component("video1b")
	Volume = Volume + 10
	If Volume > 100 Then Volume = 100	
	video.SetVolume(Volume)	
End Sub

Sub btnMute_Clicked(Target As String)
	Dim btnMute As ABMButton = page.Component("btnMute")				
	Dim video As ABMVideo = page.Component("video1b")
	If IsMuted Then
		IsMuted = False		
		video.UnMute	
		btnMute.IconName = "mdi-av-volume-mute"			
	Else
		video.Mute			
		IsMuted = True
		btnMute.IconName = "mdi-av-volume-off"
	End If	
	btnMute.Refresh ' IMPORTANT
End Sub

Sub btn5_Clicked(Target As String)
	Dim button As ABMButton = page.Component("btn5")
	Dim btnPlay As ABMButton = page.Component("btnPlay5")
	Dim video As ABMVideo = page.Component("video2")
	If InitialVideo5 Then
		button.Text = "Load Original"	
		InitialVideo5 = False
		video.LoadVideoHTML5("http://techslides.com/demos/sample-videos/small.mp4", "video/mp4")	
	Else
		button.Text = "Load Other"	
		InitialVideo5 = True
		video.LoadVideoHTML5("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4", "video/mp4")
	End If
	IsPlaying5 = False
	btnPlay.IconName = "mdi-av-play-arrow"	
	btnPlay.Refresh ' IMPORTANT		
	button.refresh ' IMPORTANT
	video.Refresh ' IMPORTANT
End Sub

Sub btnPlay5_Clicked(Target As String)
	Dim video As ABMVideo = page.Component("video2")
	Dim btnPlay As ABMButton = page.Component("btnPlay5")
	If IsPlaying5 Then
		video.Pause		
		IsPlaying5 = False
		btnPlay.IconName = "mdi-av-play-arrow"			
		btnPlay.Refresh ' IMPORTANT		
	Else
		video.Play	
		IsPlaying5 = True	
		btnPlay.IconName = "mdi-av-pause"	
		btnPlay.Refresh ' IMPORTANT	
	End If	
End Sub

Sub btnStop5_Clicked(Target As String)
	Dim video As ABMVideo = page.Component("video2")
	video.Stop
	Dim btnPlay As ABMButton = page.Component("btnPlay5")
	btnPlay.IconName = "mdi-av-play-arrow"			
	btnPlay.Refresh ' IMPORTANT	
End Sub

Sub btnVolumeDown5_Clicked(Target As String)
	Dim video As ABMVideo = page.Component("video2")	
	Volume5 = Volume5 - 10
	If Volume5 < 0 Then Volume5 = 0
	video.SetVolume(Volume5)
End Sub

Sub btnVolumeUp5_Clicked(Target As String)
	Dim video As ABMVideo = page.Component("video2")
	Volume5 = Volume5 + 10
	If Volume5 > 100 Then Volume5 = 100	
	video.SetVolume(Volume5)	
End Sub

Sub btnMute5_Clicked(Target As String)
	Dim btnMute As ABMButton = page.Component("btnMute5")				
	Dim video As ABMVideo = page.Component("video2")
	If IsMuted5 Then
		IsMuted5 = False
		video.UnMute	
		btnMute.IconName = "mdi-av-volume-mute"			
	Else
		video.Mute			
		IsMuted5 = True
		btnMute.IconName = "mdi-av-volume-off"
	End If	
	btnMute.Refresh ' IMPORTANT
End Sub


' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMVideo" Then Return
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
