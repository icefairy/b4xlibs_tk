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
	Public Name As String = "CompOAuthPage"
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
	page.PageTitle = "ABMOAuth"
	page.PageDescription = "The oauth component "	
	page.PageHTMLName = "abmaterial-oauth.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMSocialOAuth", "../images/logo.png", "", "Controls", "ABMSocialOAuth")
		
	' create the page grid
	page.AddRows(5,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","You can use ABMSocialOAuth to allow users to login in you app using social network identification. You must be familiar with Web App registrations on the social sites as this is out of the scope of ABMaterial. The following networks are supported:") )
	
	' via social network
	Dim sOAuth As ABMSocialOAuth
	sOAuth.Initialize(page, "sOAuth")
	sOAuth.AddFacebookButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Facebook")
	sOAuth.AddTwitterButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Twitter")
	sOAuth.AddGooglePlusButton("YOURKEY.COM", "Sign on with Google Plus")
	sOAuth.AddLinkedInButton("YOURKEY.COM", "Sign on with LinkedIn")
	sOAuth.AddWindowsLiveButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Windows Live")
	sOAuth.AddFourSquareButton("YOURDOMAIN.COM","YOURKEY", "Sign on with FourSquare")
	sOAuth.AddInstagramButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Instagram")
	sOAuth.AddSoundCloudButton("YOURDOMAIN.COM","YOURKEY", "Sign on with SoundCloud")
	sOAuth.AddYahooButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Yahoo")
	
	page.Cell(2,1).AddComponent(sOAuth)
	
	Dim code As String = $"// via social network
Dim sOAuth As ABMSocialOAuth
sOAuth.Initialize(page, "sOAuth")
sOAuth.AddFacebookButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Facebook")
sOAuth.AddTwitterButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Twitter")
sOAuth.AddGooglePlusButton("YOURKEY.COM", "Sign on with Google Plus")
sOAuth.AddLinkedInButton("YOURKEY.COM", "Sign on with LinkedIn")
sOAuth.AddWindowsLiveButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Windows Live")
sOAuth.AddFourSquareButton("YOURDOMAIN.COM","YOURKEY", "Sign on with FourSquare")
sOAuth.AddInstagramButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Instagram")
sOAuth.AddSoundCloudButton("YOURDOMAIN.COM","YOURKEY", "Sign on with SoundCloud")
sOAuth.AddYahooButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Yahoo")
	
page.Cell(2,1).AddComponent(sOAuth)"$

	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code", code))	
		
	' add paragraph	
	'page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par1b","To logout use the sOAuth.SignOff(network) method.  Note: If you use this on another page than the one you logged on, you'll need to recreate a new ABMSocialOAuth component and add the networks again.") )
		
	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par2","For every network you have to identify your app and set the domain (not for LinkedIn and Google Plus) and the key you get from their registration page.") )
	
	' add a header label
	page.Cell(3,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Some registration pages:"))
	
	' add paragraph	
	Dim s As String = "Facebook at {AL}https://developers.facebook.com/{AT}https://developers.facebook.com/{/AL}{BR}Twitter at {AL}https://apps.twitter.com/{AT}https://apps.twitter.com/{/AL}{BR}Google Plus at {AL}https://console.developers.google.com{AT}https://console.developers.google.com{/AL}{BR}Windows Live at {AL}http://manage.dev.live.com{AT}http://manage.dev.live.com{/AL}{BR}LinkedIn at {AL}https://www.linkedin.com/secure/developer{AT}https://www.linkedin.com/secure/developer{/AL}{BR}Yahoo at {AL}https://developer.yahoo.com/{AT}https://developer.yahoo.com/{/AL}{BR}SoundCloud at {AL}http://soundcloud.com/you/apps/{AT}http://soundcloud.com/you/apps/{/AL}{BR}FourSquare at {AL}https://foursquare.com/developers/apps{AT}https://foursquare.com/developers/apps{/AL}{BR}Instagram at {AL}http://instagram.com/developer/clients/manage/{AT}http://instagram.com/developer/clients/manage/{/AL}{BR}"
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par3",s) )
	
	' add a header label
	page.Cell(3,1).AddComponent(ABMShared.BuildHeader(page,"hdr2", "Note"))
	
	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par4","Some networks allow debugging on your localhost (Facebook, Twitter, Windows Live and maybe others).  Here is an example of the settings for facebook.  I'm not familiar enough with this subject for other networks, so questions about this could be asked on some gurus on the B4J forum.") )
	
	Dim img2 As ABMImage
	img2.Initialize(page, "img2", "../images/facebook.jpg", 1)
	img2.IsResponsive=True
	page.Cell(4,1).AddComponent(img2)
	
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
	If Action = "ABMSocialOAuth" Then Return
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
