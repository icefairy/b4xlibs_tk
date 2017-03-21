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
	Public Name As String = "CompSliderPage"
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
	' bluegray button
	theme.AddButtonTheme("bluegrey")
	theme.Button("bluegrey").BackColor = ABM.COLOR_BLUEGREY
	theme.Button("bluegrey").BackColorIntensity = ABM.INTENSITY_DARKEN1
	
	theme.AddImageSliderTheme("slider300")
	theme.ImageSlider("slider300").Height = 300
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMImageSlider"
	page.PageDescription = "The image slider/carousel component "	
	page.PageHTMLName = "abmaterial-image-slider-carousel.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMImageSlider", "../images/logo.png", "", "Controls", "ABMImageSlider")

	' create the page grid
	page.AddRows(1,True, "").AddCells12(1,"")
	page.AddRows(1,True, "").AddCellsOS(1,0,2,2,12,8,8, "")
	page.AddRows(4,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","the image slider is a simple and elegant image carousel. You can also have captions that will be transitioned on their own depending on their alignment. You can also have indicators that show up on the bottom of the slider.") )	
	
	' create slider
	Dim slider As ABMImageSlider
	slider.Initialize(page, "slider", "slider300")
	
	' add images
	slider.AddSlideImage("../images/slider1.jpg","This is our big Title!", "Here's a small slogan.", ABM.IMAGESLIDER_LEFT)
	slider.AddSlideImage("../images/slider2.jpg","This is our big Title!", "Here's a small slogan.", ABM.IMAGESLIDER_CENTER)
	slider.AddSlideImage("../images/slider3.jpg","This Is our big Title!", "Here's a small slogan.", ABM.IMAGESLIDER_RIGHT)
	slider.AddSlideImage("../images/slider4.jpg","This is our big Title!", "Here's a small slogan.", ABM.IMAGESLIDER_CENTER)
	
	page.Cell(2,1).AddComponent(slider)
	
	' add codeblock	
	Dim code As StringBuilder
	code.Initialize
	code.Append("// create slider").Append(CRLF)
	code.Append("Dim slider As ABMImageSlider").Append(CRLF)
	code.Append("slider.Initialize(page, ""slider"", """")").Append(CRLF)
	code.Append("").Append(CRLF)
	code.Append("// add images").Append(CRLF)
	code.Append("slider.AddSlideImage(""../images/slider1.jpg"",""This Is our big Title!"", ""Here's a small slogan."", ABM.IMAGESLIDER_LEFT)").Append(CRLF)
	code.Append("slider.AddSlideImage(""../images/slider2.jpg"",""This Is our big Title!"", ""Here's a small slogan."", ABM.IMAGESLIDER_CENTER)").Append(CRLF)
	code.Append("slider.AddSlideImage(""../images/slider3.jpg"",""This Is our big Title!"", ""Here's a small slogan."", ABM.IMAGESLIDER_RIGHT)").Append(CRLF)
	code.Append("slider.AddSlideImage(""../images/slider4.jpg"",""This Is our big Title!"", ""Here's a small slogan."", ABM.IMAGESLIDER_CENTER)").Append(CRLF)
	code.Append("").Append(CRLF)
	code.Append("page.Cell(2,1).AddComponent(slider)").Append(CRLF)
	
	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlock(page, "code", code))
	
	' add button
	Dim btn1 As ABMButton
	btn1.InitializeRaised(page, "btn1", "", "", "Load other images", "bluegrey")
	page.Cell(4,1).AddComponent(btn1)
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub btn1_Clicked(Target As String)
	Dim slider As ABMImageSlider = page.Component("slider")
	slider.Clear
	slider.AddSlideImage("../images/slider5.jpg","This is our big Title!", "Here's a small slogan.", ABM.IMAGESLIDER_LEFT)
	slider.AddSlideImage("../images/slider6.jpg","This is our big Title!", "Here's a small slogan.", ABM.IMAGESLIDER_CENTER)
	slider.AddSlideImage("../images/slider7.jpg","This Is our big Title!", "Here's a small slogan.", ABM.IMAGESLIDER_RIGHT)
	slider.AddSlideImage("../images/slider8.jpg","This is our big Title!", "Here's a small slogan.", ABM.IMAGESLIDER_CENTER)
	slider.AddSlideImage("../images/slider9.jpg","This is our big Title!", "Here's a small slogan.", ABM.IMAGESLIDER_LEFT)
	slider.AddSlideImage("../images/slider10.jpg","This is our big Title!", "Here's a small slogan.", ABM.IMAGESLIDER_CENTER)
	slider.Refresh
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
