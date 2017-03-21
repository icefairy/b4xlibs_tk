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
	Public Name As String = "OtherFirebasePage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
End Sub

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
	page.PageTitle = "Firebase Auth"
	page.PageDescription = "Firebase Auth support"	
	page.PageHTMLName = "abmaterial-firebase.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
	
	ABMShared.BuildNavigationBar(page, "Firebase Auth","../images/logo.png", "", "Firebase", "Firebase")
	
	' create the page grid
	page.AddRows(1,True, "").AddCells12(1,"")
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,6,6,"")
	page.AddRows(1,True, "").AddCells12(1,"")
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,6,6,"")
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
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Just like Erel has added the Firebase Auth Service to B4A ({AL}https://www.b4x.com/android/forum/threads/firebaseauth-authenticate-your-users.67875/{AT}see B4X forum{/AL}) you can also use it to login with your ABMaterial (1.20) WebApp. For WebApps, the procedure Is quite simple."))	
	
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Setup"))	
	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","1. In the Firebase console create a new Project: {AL}https://console.firebase.google.com/{AT}https://console.firebase.google.com/{/AL}"))	
		
	page.Cell(2,1).AddComponent(ABMShared.BuildImage(page, "img1", "../images/firebase1.png",1, "Create a project in the Google Console" ))
	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par3","2. Click 'Add Firebase to your web app'."))	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par4","3. You get all the keys needed For ABMaterial."))	
	
	page.Cell(4,1).AddComponent(ABMShared.BuildImage(page, "img2", "../images/firebase3.png",1, "Getting the keys" ))

	page.Cell(5,1).AddComponent(ABMShared.BuildHeader(page,"hdr2", "Usage in ABMaterial"))		
	page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par5","1. In BuildPage() initialize the Firebase API:"))
	
	Dim code1 As String = $"page.Firebase.ApiKey = "AIzaSyCS5-xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
page.Firebase.AuthDomain = "project-xxxxxxxxxxxxxxxxxxxxxxxxxxx.firebaseapp.com"
page.Firebase.DatabaseURL = "https://project-xxxxxxxxxxxxxxxxxxxxxxxx.firebaseio.com" 
page.Firebase.StorageBucket = "project-xxxxxxxxxxxxxxxxxxxxxxx.appspot.com""$
	
	page.Cell(5,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code1))
	
	page.Cell(6,1).AddComponent(ABMShared.BuildParagraph(page,"par6","2. In Websocket_Connected() use one of the Firebase connection methods. You can also create buttons and then in the Clicked_Event call the one you want (Google, Facebook, ...)"))
	
	Dim code2 As String = $"page.Firebase.CheckAuthorized"$	
	page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code2))
	
	page.Cell(7,1).AddComponent(ABMShared.BuildParagraph(page,"par7","3. The events:"))
	
	Dim code3 As String = $"Sub Page_FirebaseAuthStateChanged(IsLoggedIn As Boolean)   
  Log(IsLoggedIn)
   If IsLoggedIn Then     
     page.Firebase.Auth.CurrentUser.UpdateFromBrowser // IMPORTANT
     Log("ProviderId: " & page.Firebase.Auth.CurrentUser.ProviderId)
     Log("ProviderData: " & page.Firebase.Auth.CurrentUser.ProviderData.Size)
   Else
     Log("Authorizing...")     
     page.Firebase.Auth.SignInWithGoogle(False)   
   End If
End Sub"$	
	page.Cell(7,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code3", code3))
	
	Dim code4 As String = $"Sub Page_FirebaseAuthError(extra As String)
    Log(extra)
End Sub"$	
	page.Cell(7,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code4", code4))
	
	page.Cell(8,1).AddComponent(ABMShared.BuildParagraph(page,"par8","4. You can sign out by using page.Firebase.Auth.SignOut(). Depending on the result, one of the above events will be raised."))
	
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
	If Action = "Firebase" Then Return
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

