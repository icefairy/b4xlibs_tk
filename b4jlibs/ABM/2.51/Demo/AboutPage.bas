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
	Public Name As String = "AboutPage"
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
	
	' the page theme, we override the default one
	theme.Page.BackColor = ABM.COLOR_GREY
	theme.Page.BackColorIntensity = ABM.INTENSITY_LIGHTEN5
	
	theme.AddImageSliderTheme("myslider")
	theme.ImageSlider("myslider").Interval = 3000
	theme.ImageSlider("myslider").ZDepth = ABM.ZDEPTH_1
	theme.ImageSlider("myslider").ActiveBulletColor= ABM.COLOR_LIGHTBLUE
	theme.ImageSlider("myslider").InactiveBulletColor = ABM.COLOR_BLUEGREY
	theme.ImageSlider("myslider").InactiveBulletColorIntensity = ABM.INTENSITY_LIGHTEN4		
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True	
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMaterial"
	page.PageDescription = "About material design with ABMaterial "	
	page.PageHTMLName = "abmaterial-about.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY	
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
	page.ShowConnectedIndicator = True
				
	ABMShared.BuildNavigationBar(page, "About","../images/logo.png", "", "About", "")		
			
	' create the page grid
	page.AddRows(3,True, "").AddCells12(1,"")
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,3,3,"").AddCellsOS(1,0,1,1,12,3,3,"").AddCellsOS(1,0,1,1,12,3,3,"")
	page.AddRows(7,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	ABMShared.BuildFooter(page)
End Sub

public Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)	
	
'	' add header	
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page, "hdr1", "Welcome to ABMaterial!"))	
'	' add paragraph
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page, "par1", "ABMaterial is a new framework created by {AL}http://alwaysbusycorner.com/{AT}Alain Bailleul{/AL} combining a tuned Materialize CSS with the free programming tool {AL}https://www.idevaffiliate.com/33168/13-2.html{AT}B4J{/AL}.  It allows creating WebApps that not only look great thanks to Googles Material Design, but can be programmed with the powerful free tool from Anywhere Software. "))
	
	' create slider
	Dim slider As ABMImageSlider
	slider.Initialize(page, "slider", "myslider")
	
	' add images
	slider.AddSlideImage("../images/about1.png", "No knowledge of HTML or CSS required","Over 35 Material controls!", ABM.IMAGESLIDER_RIGHT)
	slider.AddSlideImage("../images/about2.png", "All controlable with pure B4J code","Over 35 Material controls!", ABM.IMAGESLIDER_RIGHT)
	slider.AddSlideImage("../images/about3.png", "Controls are animated","Over 35 Material controls!", ABM.IMAGESLIDER_RIGHT)
	slider.AddSlideImage("../images/about4.png", "Interact with the controls","Over 35 Material controls!", ABM.IMAGESLIDER_CENTER)
	slider.AddSlideImage("../images/about5.png", "Helpers create effects like Parallax","Over 35 Material controls!", ABM.IMAGESLIDER_RIGHT)
	slider.AddSlideImage("../images/about6.png", "Modern looking controls","Over 35 Material controls!", ABM.IMAGESLIDER_RIGHT)
	slider.AddSlideImage("../images/about7.png", "Advanced easy to implement upload files","Over 35 Material controls!", ABM.IMAGESLIDER_RIGHT)
	slider.AddSlideImage("../images/about8.png", "Create you own controls with the canvas","Over 35 Material controls!", ABM.IMAGESLIDER_CENTER)
	
	page.Cell(2,1).AddComponent(slider)
		
	' add paragraph
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page, "par2", "{B}{I}This site you are now exploring is written completely in B4J without having to write a single line of HTML or CSS code!{/I}{/B} All this code is automatically generated while you can program your WebApp in an object oriented way like you are used to in the other Anywhere products like B4A, B4i and B4J.  ABMaterial controls can be themed and have events you can use in B4J to manipulate the app. Using jQueryelement in ABMaterial, you do not have to worry about Futures etc, as all is taken care of in the library. "))
	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page, "par3", "ABMaterial WebApps are Desktop, Tablet and Phone aware. Depending on the size of the screen, your app can appear different.  For example when you resize this site on a desktop, you'll notice the SideBar on the left will disappear and a 'hamburger' button will appear in the TopBar.  See layouts for more information on how to do this. Click on the images for a larger view."))
	
	' add the images	
	page.Cell(4,1).AddComponent(ABMShared.BuildImage(page, "img1", "../images/Desktop.jpg",1, "ABMaterial in a desktop webbrowser" ))
	page.Cell(4,2).AddComponent(ABMShared.BuildImage(page, "img2", "../images/Tablet.png",1, "ABMaterial on a tablet"))
	page.Cell(4,3).AddComponent(ABMShared.BuildImage(page, "img3", "../images/Phone.png",1, "ABMaterial on a phone" ))	
	
	' add header
	page.Cell(5,1).AddComponent(ABMShared.BuildHeader(page, "hdr2", "So how does it work?" ))	
	' add paragraph
	page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page, "par4", "ABMaterial is split into two parts: Grids/Components and Themes. Grids/Components define the structure and components within your page.  Themes can be used to define the look of the components in your app."))
	' add paragraph
	page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page, "par5", "A good place to start is reading the Getting started section." ))	
	' add paragraph	
	page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par13","I hope you'll enjoy programming with ABMaterial.  Check out the {AL}http://www.b4x.com/android/forum/{AT}B4J forum{/AL} for questions, bugs or suggestions. I spend a lot of time in there..."))
	
	Dim img As ABMImage
	img.Initialize(page, "img", "../images/alainbailleul.png", 1)	
	page.Cell(6,1).AddComponent(img)
	
	Dim donButton As DonateButton
	donButton.Initialize(page, "donButton")
	page.Cell(6,1).AddComponent(donButton.ABMComp)	
				
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
		
	page.Refresh ' IMPORTANT!
		
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT	
	
	myToastId = myToastId + 1
	page.ShowToast("toast" & myToastId, "toastred", "Welcome to ABMaterial " & ABM.Version & "!", 5000)	
	
	page.RestoreNavigationBarPosition
	
'	Dim script As String = $"$("body").animate({ scrollTop: $('#${img.ID}').offset().top }, 1000);"$
'	page.ws.Eval(script, Null)
'	page.ws.Flush
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "About" Then Return
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

