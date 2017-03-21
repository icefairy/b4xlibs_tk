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
	Public Name As String = "GettingStartedPage"
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
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "Getting Started"
	page.PageDescription = "Getting started with ABMaterial"	
	page.PageHTMLName = "abmaterial-getting-started.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "Getting Started", "../images/logo.png", "", "GettingStarted", "")
		
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
	
	' add a header label
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Setup"))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","In the ABMaterial folder you'll find some folders: {B}Library{/B} and some {B}Demo{/B} Projects. The source code of this app is one of them and a great resource to get started with ABMaterial.") )
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","First, copy all library files (like {B}ABMaterial.jar{/B} and {B}ABMaterial.xml{/B}) from the Library folder to your {B}B4J libraries folder{/B}. Congratulations, you've successfully installed ABMaterial for B4J!"))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par3","Next, make a {B}copy of the Templates{/B} folder and {B}rename{/B} it to the name of your new app. Go into the folder and rename both Template.b4j and Template.b4j.meta to your apps name. e.g. Template.b4j -> MyApp.b4j and Template.b4j.meta -> MyApp.b4j.meta.  Now you are ready to write your ABMaterial Web App!"))
	
	' add a header label
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr2", "The flow of a running ABMaterial WebApp"))

	Dim s1 As String = $"1.	You start compiled .jar file on your server (e.g. {B}java -jar MyApp.jar{/B}){BR}
2.	A user loads the app in his browser (e.g. http://localhost:51042/MyApp).{BR}
3.	The WebApp redirects the user to {B}InitialPage{/B} defined in ABMApplication.{BR}
4.	If no session exists for this user, it enters the {B}ABMSessionCreator{/B} class.{BR}  
5.	A new instance of your page class is created (Initialize is called, we call the {B}BuildPage(){/B} method containing the GRID structure of our page).{BR}
6.	WebSocket_Connected is called when the DOM of the page in the browser is fully loaded:{BR}
{NBSP}{NBSP}{NBSP}{NBSP}{NBSP}{NBSP}If it is a {B}new session{/B}, we initialize the page object, call {B}ConnectPage(){/B} and save everything in the {B}cache{/B}.{BR}
{NBSP}{NBSP}{NBSP}{NBSP}{NBSP}{NBSP}If it is an {B}existing session{/B}, the page and all global variables are restored from the {B}cache{/B}.{BR}
7.	Everything is send to the Browser.  We finish this method by doing a {B}page.Refresh{/B} and tell the browser we’re done by calling {B}page.FinishedLoading{/B}.{BR}
8.	When the user leaves the page, a {B}beforeunload{/B} event is raised.{BR}
9.	{B}WebSocket_Disconnected{/B} is called.{BR}
10.	If no reconnection happens after some time, the session is destroyed by the server.  De {B}cache scavenger{/B} will do some cleanup.{BR}
"$	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par4",s1))
	
	s1 = $"If a user comes back to the app while the page is still in cache, it will continue with the cached page.   If the cached page is gone, the user is redirected to the entry point of the app.  Note that while the user is still connected with the internet, the browser will periodically send a ‘heartbeat’ to the server to keep the session ‘Alive’."$

	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par5",s1))

	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr3", "The components of an ABMaterial WebApp"))
	page.Cell(1,1).AddComponent(ABMShared.BuildSubHeader2(page,"subhdr3", "{B}{U}Main{/U}{/B}"))
	
	s1 = $"The B4J app starting point.  Additional to normal B4J initializations, this is the place where you create the ABMApplication and add your own WebApp pages.  Finally, you start the Server."$
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par6",s1))
	
	Dim code As String = $"//Non-UI application (console / server application)
#Region  Project Attributes 
	#CommandLineArgs:
	#MergeLibraries: True 
#End Region"$
	page.Cell(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code))	
	
	code = $"Sub Process_Globals
	Public srvr As Server	
End Sub"$
	page.Cell(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code))	
	
	code = $"Sub AppStart (Args() As String)
	// the user needs to login
	ABMShared.NeedsAuthorization = True

	// Build the Theme
	ABMShared.BuildTheme("mytheme")
	
	// create the app
	Dim myApp As ABMApplication
	myApp.Initialize
		
	// create the pages
	Dim myPage As ABMPageTemplate
	myPage.Initialize	
	
	// add the pages to the app
	myApp.AddPage(myPage.Page)
	
	// start the server
	myApp.StartServer(srvr, "srvr", 51042)	

	// optional if you want to redirect the logs to a file in release mode 
	ABMShared.RedirectOutput(File.DirApp, "logs.txt")
	
	StartMessageLoop
End Sub"$
	page.Cell(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code3", code))	
	
	page.Cell(1,1).AddComponent(ABMShared.BuildSubHeader2(page,"subhdr4", "{B}{U}ABMApplication{/U}{/B}"))
	s1 = $"The ABMaterial application.  Here you can set general properties for the WebApp.  In general, this does not need much changes and can be left as is."$
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"para4",s1))
	s1 = $"{B}IMPORTANT{/B}{BR}
a.	Set the Initial starting page using the {B}InitialPage{/B} variable in Class_Globals{BR}
b.  Set the Application name ({U}do not use spaces or special characters!{/U}).  This is the entry point to your WebApp and all pages will be created under this.  You can use {B}ABMShared.AppName{/B} in the initialize() method."$
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraphBQ(page, "paraBQ4", s1))
	
	page.Cell(1,1).AddComponent(ABMShared.BuildSubHeader2(page,"subhdr5", "{B}{U}ABMSessionCreator{/U}{/B}"))
	s1 = $"The ABMSessionCreator is a B4J filter which regulates a new websocket connection. No need to change anything."$
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"para5",s1))
	
	page.Cell(1,1).AddComponent(ABMShared.BuildSubHeader2(page,"subhdr6", "{B}{U}ABMUploadHandler{/U}{/B}"))
	s1 = $"The ABMUploadHandler is a B4J Server Handler that handles the uploads from the user. No need to change anything."$
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"para6",s1))
	
	page.Cell(1,1).AddComponent(ABMShared.BuildSubHeader2(page,"subhdr7", "{B}{U}ABMCacheScavenger{/U}{/B}"))
	s1 = $"Its job is taking care of {B}scavenging the cached pages{/B} to preserve memory in the server app. No need to change anything."$
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"para7",s1))
	
	page.Cell(1,1).AddComponent(ABMShared.BuildSubHeader2(page,"subhdr8", "{B}{U}ABMShared{/U}{/B}"))
	s1 = $"A B4J module where code is shared between all users.  It can be useful to write general methods shortcuts to create a header, themes, or the navigation bar.  It also must contain the NavigateToPage method."$
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"para8",s1))
	
	page.Cell(1,1).AddComponent(ABMShared.BuildSubHeader2(page,"subhdr9", "{B}{U}ABMPages{/U}{/B}"))
	s1 = $"These are your actual WebApp pages containing your own ABMaterial components and logic.  Here is where you will spend most of your time. An ABM WebPage NEEDS a certain structure and methods.  You can use (copy) the {B}ABMPageTemplate{/B} or {B}ABMPageTemplateAlternative{/B} classes to get started with your own pages.{BR}Make sure you {B}give the Name of the page the same name as your class (case sensitive!){/B}"$
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"para9",s1))
	
	code = $"//Class module
Sub{NBSP}Class_Globals
	Private ws As WebSocket
	// will hold our page information
	Public page As ABMPage
	// page theme
	Private theme As ABMTheme
	// to access the constants
	Private ABM As ABMaterial
	// name of the page, must be the same as the class name (case sensitive!)
	Public Name As String = "ABMPageTemplateAlternative"
	// will hold the unique browsers window id
	Private ABMPageId As String = ""
	
End{NBSP}Sub"$
	page.Cell(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code4", code.Replace("{NBSP}", " ")))
	
	code = $"//Initializes the object. You can add parameters to this method if needed.
Public{NBSP}Sub Initialize
	// build the local structure IMPORTANT!
	// start with the base theme defined in ABMShared
	theme.Initialize("pagetheme")
	theme.AddABMTheme(ABMShared.MyTheme)
	
	// add additional themes specific for this page
	
	// initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.PageHTMLName = "index.html"
	page.PageTitle = ""
	page.PageDescription = ""
	page.PageKeywords = ""
	page.PageSiteMapPriority = ""
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_YEARLY
	
	page.ShowConnectedIndicator = True
		
	// adding a navigation bar
	
			
	// create the page grid
	page.AddRows(2,True, "").AddCells12(1,"")
	page.BuildGrid //IMPORTANT once you loaded the complete grid AND before you start adding components
End{NBSP}Sub"$
	page.Cell(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code5", code.Replace("{NBSP}", " ")))
	
	code = $"Private Sub{NBSP}WebSocket_Connected (WebSocket1 As WebSocket)
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
		// refresh the page
		page.Refresh
		// Tell the browser we finished loading
		page.FinishedLoading
	Else
		// Prepare the page 
		page.Prepare
		// load the dynamic content
		
		// connecting the navigation bar
		
		// init all your own variables (like a List, Map) and add your components
		//	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page, "lbl", "This is a test"))
		//	
		//	Dim btn As ABMButton
		//	btn.InitializeRaised(page, "btn", "", "", "Press me", "")
		//	page.Cell(2,1).AddComponent(btn)
		
		// refresh the page
		page.Refresh
		// Tell the browser we finished loading
		page.FinishedLoading
		// restoring the navigation bar position
		page.RestoreNavigationBarPosition
	End If
	Log(ABMPageId)
End{NBSP}Sub"$
	page.Cell(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code6", code.Replace("{NBSP}", " ")))
	
	code = $"Private{NBSP}Sub WebSocket_Disconnected
	Log("Disconnected")	
End{NBSP}Sub"$
	page.Cell(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code7", code.Replace("{NBSP}", " ")))

	code = $"Sub{NBSP}Page_ParseEvent(Params As Map) 
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
				// cannot be called directly, to many param
				CallSub2(Me, eventName, Params)				
		End Select
	End If
End{NBSP}Sub"$
	page.Cell(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code8", code.Replace("{NBSP}", " ")))

	code = $"// clicked on the navigation bar
Sub{NBSP}Page_NavigationbarClicked(Action As String, Value As String)
	// saving the navigation bar position
	page.SaveNavigationBarPosition
	If Action = "LogOff" Then
		ABMShared.LogOff(page)
		Return
	End If
	ABMShared.NavigateToPage(ws, ABMPageId, Value)
End{NBSP}Sub"$
	page.Cell(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code9", code.Replace("{NBSP}", " ")))

	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par12","{B}That is it.{/B}  You can start creating ABMaterial WebApps!"))
	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par13","Next, read the Themes section to get a basic understanding of how you can use themes to uniformize your WebApp!"))		
	
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
	If Action = "GettingStarted" Then Return
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
