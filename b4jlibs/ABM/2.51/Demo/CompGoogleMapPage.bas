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
	Public Name As String = "CompGoogleMapPage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
	Dim counter As Int
	Dim Markers As List
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	' build the local structure IMPORTANT!
	BuildPage
	Markers.Initialize
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
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMGoogleMap"
	page.PageDescription = "The google map component "	
	page.PageHTMLName = "abmaterial-google-map.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMGoogleMap", "../images/logo.png", "", "Controls", "ABMGoogleMap")
		
	' create the page grid
	page.AddRows(13,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","ABMaterial allows you to use the potential of Google Maps in a simple way.") )
		
	' create the google map
	Dim gm1 As ABMGoogleMap
	gm1.Initialize(page, "gm1", 50.8500, 2.8833, 15, 350, ABM.GOOGLEMAPTYPE_ROADMAP)
	gm1.Draggable = True
	gm1.HasMapTypeControl = True	
	gm1.HasStreetViewControl = True
	gm1.HasZoomControl = True
	gm1.AddMapType(ABM.GOOGLEMAPTYPE_ROADMAP)
	gm1.AddMapType(ABM.GOOGLEMAPTYPE_TERRAIN)
	gm1.AddMapType(ABM.GOOGLEMAPTYPE_HYBRID)
	gm1.AddMapType(ABM.GOOGLEMAPTYPE_SATELLITE)
	
	page.Cell(2,1).AddComponent(gm1)
		
	Dim btn As ABMButton
	btn.InitializeRaised(page, "btn", "", "", "Add Marker", "bluegrey")
	page.Cell(3,1).AddComponent(btn)
	
	Dim btn2 As ABMButton
	btn2.InitializeRaised(page, "btn2", "", "", "Remove Markers", "bluegrey")
	page.Cell(3,1).AddComponent(btn2)
	
	Dim btn3 As ABMButton
	btn3.InitializeRaised(page, "btn3", "", "", "Get location", "bluegrey")
	page.Cell(4,1).AddComponent(btn3)
	
	Dim btn4 As ABMButton
	btn4.InitializeRaised(page, "btn4", "", "", "Fit zoom all markers", "bluegrey")
	page.Cell(4,1).AddComponent(btn4)
	
	' create the input field
	Dim inp1 As ABMInput
	inp1.Initialize(page, "inp1", ABM.INPUT_TEXT, "Address", False, "")
	page.Cell(5,1).AddComponent(inp1)
	
	Dim btn5 As ABMButton
	btn5.InitializeRaised(page, "btn5", "", "", "Get Geocode", "bluegrey")
	page.Cell(5,1).AddComponent(btn5)
	
	Dim btn12 As ABMButton
	btn12.InitializeRaised(page, "btn12", "", "", "Reverse Geocode", "bluegrey")
	page.Cell(5,1).AddComponent(btn12)
	
	Dim btn6 As ABMButton
	btn6.InitializeRaised(page, "btn6", "", "", "Build PolyLine", "bluegrey")
	page.Cell(6,1).AddComponent(btn6)
	
	Dim btn7 As ABMButton
	btn7.InitializeRaised(page, "btn7", "", "", "Remove Polylines", "bluegrey")
	page.Cell(6,1).AddComponent(btn7)
	
	Dim btn8 As ABMButton
	btn8.InitializeRaised(page, "btn8", "", "", "Build Polygon", "bluegrey")
	page.Cell(7,1).AddComponent(btn8)
	
	Dim btn9 As ABMButton
	btn9.InitializeRaised(page, "btn9", "", "", "Remove Polygons", "bluegrey")
	page.Cell(7,1).AddComponent(btn9)
	
	Dim btn10 As ABMButton
	btn10.InitializeRaised(page, "btn10", "", "", "Add Route", "bluegrey")
	page.Cell(8,1).AddComponent(btn10)
	
	Dim btn11 As ABMButton
	btn11.InitializeRaised(page, "btn11", "", "", "Remove routes", "bluegrey")
	page.Cell(8,1).AddComponent(btn11)
	
	' add codeblock	
	Dim code As StringBuilder
	code.Initialize	
	code.Append("// create the google map").Append(CRLF)
	code.Append("Dim gm1 As ABMGoogleMap").Append(CRLF)
	code.Append("gm1.Initialize(page, ""gm1"", 50.8500, 2.8833, 15, 350, ABM.GOOGLEMAPTYPE_ROADMAP)").Append(CRLF)
	code.Append("gm1.Draggable = True").Append(CRLF)
	code.Append("gm1.HasMapTypeControl = True").Append(CRLF)
	code.Append("gm1.HasStreetViewControl = True").Append(CRLF)
	code.Append("gm1.HasZoomControl = True").Append(CRLF)
	code.Append("gm1.AddMapType(ABM.GOOGLEMAPTYPE_ROADMAP)").Append(CRLF)
	code.Append("gm1.AddMapType(ABM.GOOGLEMAPTYPE_TERRAIN)").Append(CRLF)
	code.Append("gm1.AddMapType(ABM.GOOGLEMAPTYPE_HYBRID)").Append(CRLF)
	code.Append("gm1.AddMapType(ABM.GOOGLEMAPTYPE_SATELLITE)").Append(CRLF)
	code.Append("").Append(CRLF)
	code.Append("page.Cell(2,1).AddComponent(gm1)").Append(CRLF)
	
	page.Cell(9,1).AddComponent(ABMShared.BuildCodeBlock(page, "code", code))
	
	' add paragraph	
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page,"par1","You can also create a 'panorama' view.") )
	
	' create the panorama
	Dim gm2 As ABMGoogleMap
	gm2.InitializeAsPanorama(page, "gm2", 50.8500, 2.8833, 1, 300, 45, 0)
	page.Cell(11,1).AddComponent(gm2)
		
	' add codeblock	
	Dim code2 As StringBuilder
	code2.Initialize	
	code2.Append("// create the panorama").Append(CRLF)
	code2.Append("Dim gm2 As ABMGoogleMap").Append(CRLF)
	code2.Append("gm2.InitializeAsPanorama(page, ""gm2"", 50.8500, 2.8833, 1, 300, 45, 0)").Append(CRLF)
	code2.Append("").Append(CRLF)
	code2.Append("page.Cell(11,1).AddComponent(gm2)").Append(CRLF)
	
	page.Cell(12,1).AddComponent(ABMShared.BuildCodeBlock(page, "code2", code2))
	
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
	If Action = "ABMGoogleMap" Then Return
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

Sub btn_Clicked(Target As String)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	gm1.AddMarker("mymarker1", 50.8500, 2.8833, ABM.COLOR_RED, "Hello", "Ypres, the town I live in!")
	gm1.refresh ' IMPORTANT
End Sub

Sub btn2_Clicked(Target As String)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	gm1.RemoveMarkers
	Markers.Clear
	gm1.refresh ' IMPORTANT
End Sub

Sub btn3_Clicked(Target As String)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	gm1.GeoLocate	
End Sub

Sub btn4_Clicked(Target As String)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	gm1.FitZoom
End Sub

Sub btn5_Clicked(Target As String)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	Dim inp1 As ABMInput = page.Component("inp1")
	gm1.GeoCode(inp1.Text)
End Sub

Sub btn6_Clicked(Target As String)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	gm1.AddPolyLine(Markers, ABM.COLOR_DEEPORANGE, ABM.INTENSITY_NORMAL, 0.6, 5)
	gm1.refresh ' IMPORTANT
End Sub

Sub btn7_Clicked(Target As String)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	gm1.RemovePolylines	
	gm1.refresh ' IMPORTANT
End Sub

Sub btn8_Clicked(Target As String)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	gm1.AddPolygon(Markers, ABM.COLOR_DEEPPURPLE, ABM.INTENSITY_NORMAL, 0.6, 5, ABM.COLOR_CYAN, ABM.INTENSITY_NORMAL, 0.3)
	gm1.refresh ' IMPORTANT
End Sub

Sub btn9_Clicked(Target As String)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	gm1.RemovePolygons
	gm1.refresh ' IMPORTANT
End Sub

Sub btn10_Clicked(Target As String)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	gm1.AddMarker("start", 50.8500, 2.8833, ABM.COLOR_RED, "", "")
	gm1.AddMarker("stop", 50.9333, 3.1167, ABM.COLOR_RED, "", "")
	gm1.AddRoute(50.8500, 2.8833, 50.9333, 3.1167, ABM.GOOGLEMAP_TRAVELMODE_DRIVING, ABM.COLOR_DEEPPURPLE, ABM.INTENSITY_NORMAL, 0.6, 5)
	gm1.FitZoom
	gm1.refresh ' IMPORTANT
End Sub

Sub btn11_Clicked(Target As String)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	gm1.RemoveRoutes
	gm1.refresh ' IMPORTANT
End Sub

Sub btn12_Clicked(Target As String)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	gm1.ReverseGeoCode(50.8500, 2.8833)
	gm1.refresh ' IMPORTANT	
End Sub

Sub gm1_Ready()
	Log("Google map loaded!")
End Sub

Sub gm1_Clicked(Latitude As Double, Longitude As Double)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	counter = counter + 1
	' to use to build our poly objects
	Markers.Add(Latitude)
	Markers.Add(Longitude)
	gm1.AddMarker("newmarker" & counter, Latitude, Longitude, ABM.COLOR_BLUE, "New", "")
	gm1.refresh ' IMPORTANT
End Sub

Sub gm1_CurrentLocation(Latitude As Double, Longitude As Double)	
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastred", "Got current location!", 5000)	
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	gm1.SetLocation(Latitude, Longitude)
	gm1.Refresh ' IMPORTANT
End Sub

Sub gm1_GeoCodeResult(Latitude As Double, Longitude As Double)
	Dim gm1 As ABMGoogleMap = page.Component("gm1")
	counter = counter + 1
	gm1.AddMarker("newmarker" & counter, Latitude, Longitude, ABM.COLOR_GREEN, "New", "")
	gm1.SetLocation(Latitude, Longitude)
	gm1.refresh ' IMPORTANT	
End Sub

Sub gm1_Error(ErrorMessage As String)
	If ErrorMessage <> "" Then		
		myToastId = myToastId + 1	
		page.ShowToast("toast" & myToastId, "toastred", ErrorMessage, 5000)	
	End If	
End Sub

Sub gm1_MarkerClicked(MarkerId As String)
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastred", "Clicked on marker " & MarkerId, 5000)	
End Sub

Sub gm1_ReverseGeoCodeResult(Address As String)
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastred", Address, 5000)	
End Sub