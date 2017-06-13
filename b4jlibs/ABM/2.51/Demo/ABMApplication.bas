Type=Class
Version=5.45
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Main application
Sub Class_Globals
	' change to match you app
	Private InitialPage As String = "AboutPage/abmaterial-about.html"
	' other variables needed
	Private AppPage As ABMPage
	Private theme As ABMTheme
	Private ws As WebSocket 'ignore
	Private ABM As ABMaterial 'ignore	
	Private Pages As List	
	Private PageNeedsUpload As List
	
	Private ABMPageId As String
End Sub

Public Sub Initialize
	Pages.Initialize	
	PageNeedsUpload.Initialize
	' add your icons
	ABM.AddAppleTouchIcon("apple-touch-icon-152x152.png", "152x152")
	ABM.AddMSTileIcon("mstile-144x144.png", "144x144")
	ABM.AddFavorityIcon("favicon-32x32.png", "32x32")	
	ABM.AppVersion = ABMShared.AppVersion
	ABM.AppPublishedStartURL = ABMShared.AppPublishedStartURL
		
	#If RELEASE
		ABM.PreloadAllJavascriptAndCSSFiles=True	' NEW
		ABM.ActivateGZip("DONATORKEY", 1000) ' NEW
		ABM.AppDefaultPageCSSInline=True ' NEW
		ABM.AppDefaultPageJSInline=True ' NEW
	
		Dim folders As List ' NEW
		folders.Initialize
		folders.Add(File.DirApp & "/www/" & ABMShared.AppName & "/images")	
		ABM.ActivatePNGOptimize("DONATORKEY", folders, False , 9, False, True)
	#End If
	
	BuildPage
End Sub

Private Sub WebSocket_Connected (WebSocket1 As WebSocket)
	Log("Connected")
	ws = WebSocket1
	ABMPageId = ABM.GetPageID(AppPage, ABMShared.AppName,ws)
	Dim session As HttpSession = ABM.GetSession(ws, ABMShared.SessionMaxInactiveIntervalSeconds) 'ignore

	AppPage.Prepare	
	
	'AppPage.CookieSet("test", "testvalue", "expires: '01/01/2017'") ' set the cookie
	'Log(AppPage.CookieGet("test")) ' get the cookie
	'AppPage.CookieExpire("test", "") ' remove the cookie
	
	' NEW 1.09 has to be done on every page
	AppPage.SetAcceptedLanguages(Array As String("en", "fr", "de", "nl"), "en")
	Dim ActiveFoundLanguage As String = AppPage.DetectLanguage(ws.UpgradeRequest.GetHeader("Accept-Language"))
	Log("Users browser language: " & ActiveFoundLanguage)
	' for the login use the users browser language
	AppPage.SetActiveLanguage(ActiveFoundLanguage, "" )
	
	' NEW
	ConnectPage	
	
	' navigate to the first page
	If ABMShared.NeedsAuthorization Then
		
		' if you start the app as: http://localhost:51042/demo/index.html?login=demo&pwd=demo
		Dim params As Map = ws.UpgradeRequest.ParameterMap
		Dim login(0), pwd(0) As String
		If params.IsInitialized Then
			login = params.GetDefault("login", Array As String(""))
			pwd = params.GetDefault("pwd", Array As String(""))
		End If	
		Log(login(0) & " " & pwd(0))
'		If login(0) = "demo" And pwd(0) = "demo" Then
'			ws.Session.SetAttribute("authType", "local")
'			ws.Session.SetAttribute("authName", "demo")
'			ws.Session.SetAttribute("IsAuthorized", "true")			
'		End If
		
		If ws.Session.GetAttribute2("IsAuthorized", "") = "" Then
			AppPage.ShowModalSheet("login")
			Return
		End If
	End If
	
	' NEW 1.09 
	' but you can of course overrule this (e.g. because the user can choose)
	AppPage.SetActiveLanguage("en", "")
	
	ABMShared.NavigateToPage(ws, ABMPageId, "./" & InitialPage)
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
				' cannot be called diretly, to many param
				CallSub2(Me, eventName, Params)				
		End Select
	End If
End Sub

public Sub AddPage(page As ABMPage)
	Pages.Add(page.Name)	
	PageNeedsUpload.Add(ABM.WritePageToDisk(page, File.DirApp & "/www/" & ABMShared.AppName & "/" & page.Name & "/", page.PageHTMLName, ABMShared.NeedsAuthorization))
End Sub

public Sub StartServer(srvr As Server, srvrName As String, srvrPort As Int)		
	ABM.WriteAppLauchPageToDisk(AppPage, File.DirApp & "/www/" & ABMShared.AppName, "index.html", ABMShared.NeedsAuthorization)

	' start the server
	srvr.Initialize(srvrName)

	srvr.AddFilter("/js/b4j_ws.min.js", "ABMSessionCreator", False)
	srvr.AddWebSocket("/ws/" & ABMShared.AppName, "ABMApplication")
	For i =0 To Pages.Size - 1
		srvr.AddWebSocket("/ws/" & ABMShared.AppName & "/" & Pages.Get(i) , Pages.Get(i))
		If PageNeedsUpload.Get(i) Then			
			srvr.AddHandler("/" & ABMShared.AppName & "/" & Pages.Get(i) & "/abmuploadhandler", "ABMUploadHandler", False)
		End If
	Next	
	srvr.AddBackgroundWorker("ABMCacheScavenger")
	srvr.Port = srvrPort

	#If RELEASE
		srvr.SetStaticFilesOptions(CreateMap("cacheControl": "max-age=604800,public","gzip":True,"dirAllowed":False))
	#Else
		srvr.SetStaticFilesOptions(CreateMap("cacheControl": "max-age=604800,public","gzip":False,"dirAllowed":False))
	#End If
	srvr.Start			
	Dim jo As JavaObject = srvr
	Dim connectors() As Object = jo.GetFieldJO("server").RunMethod("getConnectors", Null)
	Dim timeout As Long = ABMShared.SessionMaxInactiveIntervalSeconds*1000
	For Each c As JavaObject In connectors
		c.RunMethod("setIdleTimeout", Array(timeout))
	Next

	ABMShared.CachedPages = srvr.CreateThreadSafeMap
End Sub

public Sub StartServerHTTP2(srvr As Server, srvrName As String, srvrPort As Int, SSLsvrPort As Int,  SSLKeyStoreFileName As String, SSLKeyStorePassword As String, SSLKeyManagerPassword As String)
	ABM.WriteAppLauchPageToDisk(AppPage, File.DirApp & "/www/" & ABMShared.AppName, "index.html", ABMShared.NeedsAuthorization)

	Dim ssl As SslConfiguration
	ssl.Initialize
	ssl.SetKeyStorePath(File.DirApp, SSLKeyStoreFileName) 'path to keystore file
	ssl.KeyStorePassword = SSLKeyStorePassword
	ssl.KeyManagerPassword = SSLKeyManagerPassword
	srvr.SetSslConfiguration(ssl, SSLsvrPort)

	' start the server
	srvr.Initialize(srvrName)

	srvr.AddFilter("/js/b4j_ws.min.js", "ABMSessionCreator", False)
	srvr.AddWebSocket("/ws/" & ABMShared.AppName, "ABMApplication")
	For i =0 To Pages.Size - 1
		srvr.AddWebSocket("/ws/" & ABMShared.AppName & "/" & Pages.Get(i) , Pages.Get(i))
		If PageNeedsUpload.Get(i) Then			
			srvr.AddHandler("/" & ABMShared.AppName & "/" & Pages.Get(i) & "/abmuploadhandler", "ABMUploadHandler", False)
		End If
	Next	
	srvr.AddBackgroundWorker("ABMCacheScavenger")
	srvr.Port = srvrPort
	srvr.Http2Enabled = True
	#If RELEASE
		srvr.SetStaticFilesOptions(CreateMap("cacheControl": "max-age=604800,public","gzip":True,"dirAllowed":False))
	#Else
		srvr.SetStaticFilesOptions(CreateMap("cacheControl": "max-age=604800,public","gzip":False,"dirAllowed":False))
	#End If
	srvr.Start	
	Dim jo As JavaObject = srvr
	Dim connectors() As Object = jo.GetFieldJO("server").RunMethod("getConnectors", Null)
	Dim timeout As Long = ABMShared.SessionMaxInactiveIntervalSeconds*1000
	For Each c As JavaObject In connectors
		c.RunMethod("setIdleTimeout", Array(timeout))
	Next

	ABMShared.CachedPages = srvr.CreateThreadSafeMap
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
	AppPage.InitializeWithTheme(ABMShared.AppName, "/ws/" & ABMShared.AppName, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	AppPage.ShowLoader=True
	AppPage.ShowLoaderType= ABM.LOADER_TYPE_MANUAL ' NEW
	AppPage.PageTitle = "ABMaterial"
	AppPage.PageDescription = "ABMaterial, a Material UI Framework for B4J"	
	AppPage.PageHTMLName = "index.html"
	AppPage.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	AppPage.PageSiteMapPriority = "0.25"
	AppPage.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	AppPage.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
			
	' create the page grid
	AppPage.AddRows(1,True, "").AddCells12(1,"")
	AppPage.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components	
	
	
End Sub

Public Sub ConnectPage()
	' add a modal sheet template to enter contact information
	AppPage.AddModalSheetTemplate(ConnectLoginSheet)
	
	' add a error box template if the name is not entered
	AppPage.AddModalSheetTemplate(ConnectWrongInputModalSheet)	
	
	AppPage.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	AppPage.FinishedLoading 'IMPORTANT
	
	AppPage.RestoreNavigationBarPosition
End Sub

Sub msbtn1_Clicked(Target As String)
	Dim mymodal As ABMModalSheet = AppPage.ModalSheet("login")	
	Dim inp1 As ABMInput = mymodal.Content.Component("inp1")
	Dim inp2 As ABMInput = mymodal.Content.Component("inp2")
	' here check the login a page against your login database
	If inp1.Text <> "demo" Or inp2.Text <> "demo" Then
		AppPage.ShowModalSheet("wronginput")				
		Return
	End If
	ws.Session.SetAttribute("authType", "local")
	ws.Session.SetAttribute("authName", inp1.Text)
	ws.Session.SetAttribute("IsAuthorized", "true")
	ABMShared.NavigateToPage(ws, ABMPageId, "./" & InitialPage)
End Sub

Sub inp2_EnterPressed(value As String)
	Dim mymodal As ABMModalSheet = AppPage.ModalSheet("login")	
	Dim inp1 As ABMInput = mymodal.Content.Component("inp1")
	Dim inp2 As ABMInput = mymodal.Content.Component("inp2")
	' here check the login a page against your login database
	If inp1.Text <> "demo" Or inp2.Text <> "demo" Then
		AppPage.ShowModalSheet("wronginput")				
		Return
	End If
	ws.Session.SetAttribute("authType", "local")
	ws.Session.SetAttribute("authName", inp1.Text)
	ws.Session.SetAttribute("IsAuthorized", "true")
	ABMShared.NavigateToPage(ws, ABMPageId, "./" & InitialPage)
End Sub

Sub ConnectLoginSheet() As ABMModalSheet
	Dim myModal As ABMModalSheet
	myModal.Initialize(AppPage, "login", False, False, "")
	myModal.Content.UseTheme("modalcontent")
	myModal.Footer.UseTheme("modalfooter")
	myModal.IsDismissible = False
	
	' create the grid for the content
	myModal.Content.AddRows(3,True, "").AddCells12(1,"")	
	myModal.Content.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	' create the grid for the footer
	' we add a row without the default 20px padding so we need to use AddRowsM().  If we do not use this method, a scrollbar will appear to the sheet.
	myModal.Footer.AddRowsM(1,True,0,0, "").AddCellsOS(1,9,9,9,3,3,3, "")
	myModal.Footer.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	' add paragraph	
	myModal.Content.Cell(1,1).AddComponent(ABMShared.BuildParagraph(AppPage,"par1","Please login: (login and password are 'demo')") )
	
	' create the input fields for the content
	Dim inp1 As ABMInput
	inp1.Initialize(AppPage, "inp1", ABM.INPUT_TEXT, "Login", False, "")	
	myModal.Content.Cell(2,1).AddComponent(inp1)
	
	Dim inp2 As ABMInput
	inp2.Initialize(AppPage, "inp2", ABM.INPUT_PASSWORD, "Password", False, "")
	myModal.Content.Cell(2,1).AddComponent(inp2)
	
	' via social network
	Dim sOAuth As ABMSocialOAuth
	sOAuth.Initialize(AppPage, "sOAuth")
	sOAuth.AddFacebookButton("gorgeousapps.com","868438219937606", "Sign on with Facebook")
	'sOAuth.AddFacebookButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Facebook")
	sOAuth.AddTwitterButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Twitter")
	sOAuth.AddGooglePlusButton("YOURKEY", "Sign on with Google Plus")
	sOAuth.AddLinkedInButton("YOURKEY", "Sign on with LinkedIn")
	sOAuth.AddWindowsLiveButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Windows Live")
	sOAuth.AddFourSquareButton("YOURDOMAIN.COM","YOURKEY", "Sign on with FourSquare")
	sOAuth.AddInstagramButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Instagram")
	sOAuth.AddSoundCloudButton("YOURDOMAIN.COM","YOURKEY", "Sign on with SoundCloud")
	sOAuth.AddYahooButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Yahoo")
	
	myModal.Content.Cell(3,1).AddComponent(sOAuth)
	
	' create the button for the footer
	Dim msbtn1 As ABMButton
	msbtn1.InitializeFlat(AppPage, "msbtn1", "", "", "Login", "transparent")
	myModal.Footer.Cell(1,1).AddComponent(msbtn1)
	
	Return myModal
End Sub

Sub ConnectWrongInputModalSheet()  As ABMModalSheet
	Dim myModalError As ABMModalSheet
	myModalError.Initialize(AppPage, "wronginput", False, False, "")
	myModalError.Content.UseTheme("modalcontent")
	myModalError.Footer.UseTheme("modalcontent")
	myModalError.IsDismissible = True
	
	' create the grid for the content
	myModalError.Content.AddRows(1,True, "").AddCells12(1,"")	
	myModalError.Content.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	Dim lbl1 As ABMLabel
	lbl1.Initialize(AppPage, "contlbl1", "The login or password are incorrect!",ABM.SIZE_PARAGRAPH, False, "")
	myModalError.Content.Cell(1,1).AddComponent(lbl1)
	
	Return myModalError
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	AppPage.SaveNavigationBarPosition	
End Sub

Sub Page_FileUploaded(FileName As String, success As Boolean)	
	
End Sub

Sub Page_ToastClicked(ToastId As String, Action As String)
		
End Sub

Sub Page_ToastDismissed(ToastId As String)
	
End Sub

Sub Page_Authenticated(Params As Map)
	Log("Authenticated " & Params.Get("name"))
	
	ws.Session.SetAttribute("authType", Params.Get("network"))
	ws.Session.SetAttribute("authName", Params.Get("name"))
	ws.Session.SetAttribute("IsAuthorized", "true")
	ABMShared.NavigateToPage(ws, ABMPageId, "./" & InitialPage)
End Sub
