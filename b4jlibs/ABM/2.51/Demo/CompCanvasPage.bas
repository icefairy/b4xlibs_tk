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
	Public Name As String = "CompCanvasPage"
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
	Dim kyleTeller As Int
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
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMCanvas"
	page.PageDescription = "The canvas component "	
	page.PageHTMLName = "abmaterial-canvas.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMCanvas", "../images/logo.png", "", "Controls", "ABMCanvas")
		
	' create the page grid
	page.AddRows(11,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components	
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True
	
	' load images we will need in the canvases, needs to be done in BuildPage as they are pre-loaded
	page.AddCanvasImage("background", "../images/background.jpg")
	page.AddCanvasImage("kyle", "../images/kyle.png")
	page.AddCanvasImage("kenny", "../images/kenny.png")
	page.AddCanvasImage("eric", "../images/eric.png")
		
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","ABMCanvas is a HTML5 Canvas with Dragging possibilities.  All drawing is done with ABMVCanvasObjects and supports almost all methods described in {AL}http://www.w3schools.com/tags/ref_canvas.asp{AT}W3Schools{/AL}.") )
		
	' create canvas
	Dim canvas1 As ABMCanvas
	canvas1.Initialize(page, "canvas1", ABM.COLOR_BLACK, ABM.INTENSITY_NORMAL,1024,569, True)
	
	' create background
	Dim bg As ABMCanvasObject
	bg.InitializeAsRectangle(page, "bg",0,0,1024,569,False)
	bg.drawImage("background", 0,0)
	canvas1.AddObject(bg)
	
	page.Cell(2,1).AddComponent(canvas1)
	
	Dim btn As ABMButton
	btn.InitializeRaised(page, "btn", "", "", "Add Kyle", "bluegrey")
	page.Cell(3,1).AddComponent(btn)
	
	' add codeblock	
	Dim code1 As StringBuilder
	code1.Initialize
	code1.Append("// load images we will need in the canvases").Append(CRLF)
	code1.Append("page.AddCanvasImage(""background"", ""../images/background.jpg"")").Append(CRLF)
	code1.Append("page.AddCanvasImage(""kyle"", ""../images/kyle.png"")").Append(CRLF)
	code1.Append("page.AddCanvasImage(""kenny"", ""../images/kenny.png"")").Append(CRLF)
	code1.Append("").Append(CRLF)
	code1.Append("// create canvas").Append(CRLF)
	code1.Append("Dim canvas1 As ABMCanvas").Append(CRLF)
	code1.Append("canvas1.Initialize(page, ""canvas1"", ABM.COLOR_BLACK, ABM.INTENSITY_NORMAL,1024,569, True)").Append(CRLF)
	code1.Append("").Append(CRLF)
	code1.Append("// create background").Append(CRLF)
	code1.Append("Dim bg As ABMCanvasObject").Append(CRLF)
	code1.Append("bg.InitializeAsRectangle(page, ""bg"",0,0,1024,569,False)").Append(CRLF)
	code1.Append("bg.drawImage(""background"", 0,0)").Append(CRLF)
	code1.Append("canvas1.AddObject(bg)").Append(CRLF)
	
	page.Cell(4,1).AddComponent(ABMShared.BuildCodeBlock(page, "code1", code1))
	
	' add codeblock	
	Dim code2 As StringBuilder
	code2.Initialize
	code2.Append("Sub btn_Clicked(Target As String)").Append(CRLF)
	code2.Append("   Dim canvas1 As ABMCanvas = page.Component(""canvas1"")").Append(CRLF)
	code2.Append("   Dim Kyle As ABMCanvasObject").Append(CRLF)
	code2.Append("   Dim x As Int = Rnd(0,1024-109)").Append(CRLF)
	code2.Append("   Dim y As Int = Rnd(0,569-136)").Append(CRLF)
	code2.Append("   kyleTeller=kyleTeller+1").Append(CRLF)
	code2.Append("   Kyle.InitializeAsRectangle(page, ""kyle"" & kyleTeller, x, y, 109,136, True)").Append(CRLF)
	code2.Append("   Kyle.drawImage(""kyle"", 0,0)").Append(CRLF)
	code2.Append("   canvas1.AddObject(Kyle)").Append(CRLF)
	code2.Append("   canvas1.refresh // IMPORTANT").Append(CRLF)
    code2.Append("End Sub").Append(CRLF)
	code2.Append("").Append(CRLF)
	code2.Append("Sub canvas1_ObjectUp(objectId As String)").Append(CRLF)
	code2.Append("   myToastId = myToastId + 1	").Append(CRLF)
	code2.Append("   Dim ChangedTo As String").Append(CRLF)
	code2.Append("   Dim canvas1 As ABMCanvas = page.Component(""canvas1"")").Append(CRLF)
	code2.Append("   Dim Kyle As ABMCanvasObject = canvas1.GetObject(objectId)").Append(CRLF)
	code2.Append("   If Kyle.Width = 109 Then").Append(CRLF)
	code2.Append("   	//changing the size to the new picture").Append(CRLF)
	code2.Append("   	Kyle.SetSize(98,129)").Append(CRLF)
	code2.Append("   	Kyle.Clear").Append(CRLF)
	code2.Append("   	Kyle.drawImage(""kenny"",0,0)").Append(CRLF)
	code2.Append("   	Kyle.Refresh // IMPORTANT").Append(CRLF)
	code2.Append("   	ChangedTo = ""Kenny""").Append(CRLF)
	code2.Append("   Else").Append(CRLF)
	code2.Append("   	// changing the size to the new picture").Append(CRLF)
	code2.Append("   	Kyle.SetSize(109,136)").Append(CRLF)
	code2.Append("   	Kyle.Clear").Append(CRLF)
	code2.Append("   	Kyle.drawImage(""kyle"",0,0)").Append(CRLF)
	code2.Append("   	Kyle.Refresh // IMPORTANT").Append(CRLF)
	code2.Append("   	ChangedTo = ""Kyle""").Append(CRLF)
	code2.Append("   End If").Append(CRLF)
	code2.Append("").Append(CRLF)
	code2.Append("   canvas1.Refresh // IMPORTANT!").Append(CRLF)
	code2.Append("").Append(CRLF)
	code2.Append("   page.ShowToast(""toast"" & myToastId, ""toastred"", objectId & "" changed to "" & ChangedTo & ""!"", 5000)").Append(CRLF)
	code2.Append("   End Sub").Append(CRLF)
	
	page.Cell(4,1).AddComponent(ABMShared.BuildCodeBlock(page, "code2", code2))
	
	' add paragraph	
	page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par2","An example of the basic drawing functionalities on the ABMCanvas.") )
	
	' the clock canvas
	Dim canvas2 As ABMCanvas
	canvas2.Initialize(page, "canvas2", ABM.COLOR_BLACK, ABM.INTENSITY_NORMAL, 300,300, False)
	
	Dim clock As ABMCanvasObject = BuildClock
	canvas2.AddObject(clock)
	
	page.Cell(6,1).AddComponent(canvas2)
	
	' add codeblock	
	Dim code3 As StringBuilder
	code3.Initialize
	code3.Append("// the clock canvas").Append(CRLF)
	code3.Append("Dim canvas2 As ABMCanvas").Append(CRLF)
	code3.Append("canvas2.Initialize(page, ""canvas2"", ABM.COLOR_BLACK, ABM.INTENSITY_NORMAL, 300,300, False)").Append(CRLF)
	code3.Append("").Append(CRLF)
	code3.Append("Dim clock As ABMCanvasObject = BuildClock").Append(CRLF)
	code3.Append("canvas2.AddObject(clock)").Append(CRLF)
	code3.Append("").Append(CRLF)
	code3.Append("page.Cell(6,1).AddComponent(canvas2)").Append(CRLF)
	
	page.Cell(7,1).AddComponent(ABMShared.BuildCodeBlock(page, "code3", code3))
	
	' add codeblock	
	Dim code4 As StringBuilder
	code4.Initialize
	code4.Append("// check out the tutorial on W3Schools.com: http://www.w3schools.com/canvas/canvas_clock.asp").Append(CRLF)
	code4.Append("Sub BuildClock() As ABMCanvasObject").Append(CRLF)
	code4.Append("   Dim clock As ABMCanvasObject").Append(CRLF)
	code4.Append("   Dim Radius As Double = 150").Append(CRLF)
	code4.Append("").Append(CRLF)
	code4.Append("   clock.InitializeAsRectangle(page, ""clock"", 0,0,300,300, True)").Append(CRLF)
	code4.Append("").Append(CRLF)
	code4.Append("   Radius = Radius * 0.9").Append(CRLF)
	code4.Append("").Append(CRLF)
	code4.Append("   // draw face").Append(CRLF)
	code4.Append("   clock.translate(150,150)").Append(CRLF)
	code4.Append("   clock.beginPath").Append(CRLF)
	code4.Append("   clock.arc(0,0,Radius, 0, 2*cPI)").Append(CRLF)
	code4.Append("   clock.fillStyleColor(""#FFFFFF"")").Append(CRLF)
	code4.Append("   clock.fill").Append(CRLF)
	code4.Append("   clock.strokeStyleRadialGradient(0,0,Radius*0.95,0,0,Radius*1.05, Array As Double(0,0.5,1), Array As String(""#333"", ""white"", ""#333""))").Append(CRLF)
    code4.Append("   clock.lineWidth(Radius*0.1)").Append(CRLF)
  	code4.Append("   clock.stroke()").Append(CRLF)
	code4.Append("").Append(CRLF)
  	code4.Append("   clock.beginPath").Append(CRLF)
  	code4.Append("   clock.arc(0, 0, Radius*0.1, 0, 2*cPI)").Append(CRLF)
  	code4.Append("   clock.fillStyleColor(""#333"")").Append(CRLF)
  	code4.Append("   clock.fill").Append(CRLF)
	code4.Append("").Append(CRLF)
	code4.Append("   //draw numbers").Append(CRLF)
	code4.Append("   clock.font(""arial"", Radius*0.15)").Append(CRLF)
  	code4.Append("   clock.textBaseline(ABM.CANVAS_TEXTBASELINE_MIDDLE)").Append(CRLF)
  	code4.Append("   clock.textAlign(ABM.CANVAS_TEXTALIGN_CENTER)").Append(CRLF)
	code4.Append("   Dim ang As Double").Append(CRLF)
  	code4.Append("   For num = 1 To 12").Append(CRLF)
    code4.Append("   	ang = num * cPI / 6").Append(CRLF)
    code4.Append("   	clock.rotate(ang)").Append(CRLF)
    code4.Append("   	clock.translate(0, -Radius*0.85)").Append(CRLF)
    code4.Append("   	clock.rotate(-ang)").Append(CRLF)
    code4.Append("   	clock.fillText("""" & num, 0, 0)").Append(CRLF)
    code4.Append("   	clock.rotate(ang)").Append(CRLF)
    code4.Append("   	clock.translate(0, Radius*0.85)").Append(CRLF)
    code4.Append("   	clock.rotate(-ang)").Append(CRLF)
  	code4.Append("   Next").Append(CRLF)
	code4.Append("").Append(CRLF)
	code4.Append("   // draw time").Append(CRLF)
	code4.Append("   Dim hour As Double = DateTime.GetHour(DateTime.Now)").Append(CRLF)
	code4.Append("   Dim minute As Double = DateTime.GetMinute(DateTime.Now)").Append(CRLF)
	code4.Append("   Dim second As Double = DateTime.GetSecond(DateTime.Now)").Append(CRLF)
	code4.Append("   hour = hour mod 12").Append(CRLF)
	code4.Append("   hour = (hour*cPI/6)+(minute*cPI/(6*60))+(second*cPI/(360*60))").Append(CRLF)
	code4.Append("   BuildHand(clock, hour, Radius*0.5, Radius*0.07)").Append(CRLF)
	code4.Append("   minute=(minute*cPI/30)+(second*cPI/(30*60))").Append(CRLF)
	code4.Append("   BuildHand(clock, minute, Radius*0.8, Radius*0.07)").Append(CRLF)
	code4.Append("   second=(second*cPI/30)").Append(CRLF)
	code4.Append("   BuildHand(clock, second, Radius*0.9, Radius*0.02)").Append(CRLF)
	code4.Append("").Append(CRLF)
	code4.Append("   Return clock").Append(CRLF)
	code4.Append("End Sub").Append(CRLF)
	code4.Append("").Append(CRLF)
	code4.Append("Sub BuildHand(clock As ABMCanvasObject, pos As Int, length As Double, width As Double)").Append(CRLF)
	code4.Append("   clock.beginPath").Append(CRLF)
    code4.Append("   clock.lineWidth(width)").Append(CRLF)
    code4.Append("   clock.lineCap(ABM.CANVAS_LINECAP_ROUND)").Append(CRLF)
    code4.Append("   clock.moveTo(0,0)").Append(CRLF)
    code4.Append("   clock.rotate(pos)").Append(CRLF)
    code4.Append("   clock.lineTo(0, -length)").Append(CRLF)
    code4.Append("   clock.stroke").Append(CRLF)
    code4.Append("   clock.rotate(-pos)").Append(CRLF)
    code4.Append("End Sub").Append(CRLF)
	
	page.Cell(7,1).AddComponent(ABMShared.BuildCodeBlock(page, "code4", code4))
	
	' add paragraph	
	page.Cell(8,1).AddComponent(ABMShared.BuildParagraph(page,"par3","ABMCanvas can be used to build your own controls.") )
	
	' the control canvas
	Dim canvas3 As ABMCanvas
	canvas3.Initialize(page, "canvas3", ABM.COLOR_TRANSPARENT, ABM.INTENSITY_NORMAL, 1024,100, True)
	
	Dim controlBar As ABMCanvasObject = BuildControlBar
	canvas3.AddObject(controlBar)
	
	Dim controlCircle As ABMCanvasObject = BuildControlCircle
	canvas3.AddObject(controlCircle)
	
	page.Cell(9,1).AddComponent(canvas3)
	
	' add codeblock	
	Dim code5 As StringBuilder
	code5.Initialize
	code5.Append("// the control canvas").Append(CRLF)
	code5.Append("Dim canvas3 As ABMCanvas").Append(CRLF)
	code5.Append("canvas3.Initialize(page, ""canvas3"", ABM.COLOR_TRANSPARENT, ABM.INTENSITY_NORMAL, 1024,100, True)").Append(CRLF)
	code5.Append("").Append(CRLF)
	code5.Append("Dim controlBar As ABMCanvasObject = BuildControlBar").Append(CRLF)
	code5.Append("canvas3.AddObject(controlBar)").Append(CRLF)
	code5.Append("").Append(CRLF)
	code5.Append("Dim controlCircle As ABMCanvasObject = BuildControlCircle").Append(CRLF)
	code5.Append("canvas3.AddObject(controlCircle)").Append(CRLF)
	
	page.Cell(10,1).AddComponent(ABMShared.BuildCodeBlock(page, "code5", code5))
	
	' add codeblock	
	Dim code6 As StringBuilder
	code6.Initialize
	code6.Append("// the control canvas").Append(CRLF)
	code6.Append("Sub BuildControlBar() As ABMCanvasObject").Append(CRLF)
	code6.Append("   Dim cont As ABMCanvasObject").Append(CRLF)
	code6.Append("   cont.InitializeAsRectangle(page, ""contbar"", 0,0,1024,100,False)").Append(CRLF)
	code6.Append("   cont.beginPath").Append(CRLF)
	code6.Append("   cont.lineWidth(5)").Append(CRLF)
	code6.Append("   cont.lineCap(ABM.CANVAS_LINECAP_ROUND)").Append(CRLF)
	code6.Append("   cont.strokeStyleColor(""#888888"")").Append(CRLF)
	code6.Append("   cont.moveTo(20,47)").Append(CRLF)
	code6.Append("   cont.lineTo(1004,47)").Append(CRLF)
	code6.Append("   cont.stroke").Append(CRLF)
	code6.Append("   Return cont").Append(CRLF)
	code6.Append("End Sub").Append(CRLF)
	code6.Append("").Append(CRLF)
	code6.Append("Sub BuildControlCircle() As ABMCanvasObject").Append(CRLF)
	code6.Append("   Dim cont As ABMCanvasObject").Append(CRLF)
	code6.Append("   cont.InitializeAsCircle(page, ""contcirc"", 50,48,40, True)").Append(CRLF)
	code6.Append("   // here we restrict the movement of the control so it only can me moved on the X-Axis ").Append(CRLF)
	code6.Append("   cont.SetDragZone(50,48,924,1)").Append(CRLF)
	code6.Append("").Append(CRLF)
	code6.Append("   cont.beginPath").Append(CRLF)
	code6.Append("   cont.arc(0,0,40, 0, 2*cPI)").Append(CRLF)
	code6.Append("   cont.fillStyleColor(""#000000"")").Append(CRLF)
	code6.Append("   cont.fill").Append(CRLF)
	code6.Append("   cont.save").Append(CRLF)
	code6.Append("   cont.translate(-40,-40)").Append(CRLF)
	code6.Append("   cont.drawImage3(""eric"", 0,0,147,135,5,5, 70,64)").Append(CRLF)
	code6.Append("   cont.closePath").Append(CRLF)
	code6.Append("   cont.restore").Append(CRLF)
	code6.Append("   Return cont").Append(CRLF)
	code6.Append("End Sub").Append(CRLF)
	code6.Append("").Append(CRLF)   
	code6.Append("Sub canvas3_ObjectUp(objectId As String)").Append(CRLF)
	code6.Append("   // calculate value from position").Append(CRLF)
	code6.Append("   Dim canvas1 As ABMCanvas = page.Component(""canvas3"")").Append(CRLF)
	code6.Append("   Dim Eric As ABMCanvasObject = canvas1.GetObject(objectId)").Append(CRLF)
	code6.Append("   Dim Pos As ABMPoint = Eric.GetPosition").Append(CRLF)
	code6.Append("   If Pos <> Null Then").Append(CRLF)
	code6.Append("     // map to 0 to 100: (our position - the dragzone left)/(dragzone width)*100").Append(CRLF)
	code6.Append("   	Dim value As Int = (Pos.x-50)/924*100").Append(CRLF)
	code6.Append("   	myToastId = myToastId + 1").Append(CRLF)	
	code6.Append("   	page.ShowToast(""toast"" & myToastId, ""toastred"", ""Eric is at value "" & value, 5000)").Append(CRLF)
	code6.Append("   End If").Append(CRLF)
	code6.Append("End Sub").Append(CRLF)
	
	page.Cell(11,1).AddComponent(ABMShared.BuildCodeBlock(page, "code6", code6))
	
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
	If Action = "ABMCanvas" Then Return
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
	Dim canvas1 As ABMCanvas = page.Component("canvas1")
	Dim Kyle As ABMCanvasObject
	Dim x As Int = Rnd(0,1024-109)
	Dim y As Int = Rnd(0,569-136)
	kyleTeller=kyleTeller+1
	Kyle.InitializeAsRectangle(page, "kyle" & kyleTeller, x, y, 109,136, True)
	Kyle.drawImage("kyle", 0,0)
	canvas1.AddObject(Kyle)
	canvas1.refresh ' IMPORTANT
End Sub

Sub canvas1_ObjectUp(objectId As String)
	myToastId = myToastId + 1	
	
	Dim ChangedTo As String
	
	Dim canvas1 As ABMCanvas = page.Component("canvas1")
	Dim Kyle As ABMCanvasObject = canvas1.GetObject(objectId)
	If Kyle.Width = 109 Then
		' changing the size to the new picture
		Kyle.SetSize(98,129)
		Kyle.Clear
		Kyle.drawImage("kenny",0,0)
		Kyle.Refresh ' IMPORTANT
		ChangedTo = "Kenny"
	Else
		' changing the size to the new picture
		Kyle.SetSize(109,136)
		Kyle.Clear
		Kyle.drawImage("kyle",0,0)
		Kyle.Refresh ' IMPORTANT
		ChangedTo = "Kyle"
	End If
	
	canvas1.Refresh ' IMPORTANT!
	
	page.ShowToast("toast" & myToastId, "toastred", objectId & " changed to " & ChangedTo & "!", 5000)	
End Sub

Sub canvas1_CanvasDown(x As Int, y As Int)
	Log("canvas down: " & x & " - " & y)
End Sub

' check out the tutorial on W3Schools.com: http://www.w3schools.com/canvas/canvas_clock.asp
Sub BuildClock() As ABMCanvasObject
	Dim clock As ABMCanvasObject
	Dim Radius As Double = 150
	
	clock.InitializeAsRectangle(page, "clock", 0,0,300,300, True)
	
	Radius = Radius * 0.9
	
	' draw face
	clock.translate(150,150)
	clock.beginPath
	clock.arc(0,0,Radius, 0, 2*cPI)
	clock.fillStyleColor("#FFFFFF")
	clock.fill
	clock.strokeStyleRadialGradient(0,0,Radius*0.95,0,0,Radius*1.05, Array As Double(0,0.5,1), Array As String("#333", "white", "#333"))
    clock.lineWidth(Radius*0.1)
  	clock.stroke()
	
  	clock.beginPath
  	clock.arc(0, 0, Radius*0.1, 0, 2*cPI)
  	clock.fillStyleColor("#333")
  	clock.fill
	
	'draw numbers
	 clock.font("arial", Radius*0.15)
  	 clock.textBaseline(ABM.CANVAS_TEXTBASELINE_MIDDLE)
  	 clock.textAlign(ABM.CANVAS_TEXTALIGN_CENTER)
	 Dim ang As Double
  	 For num = 1 To 12
    	ang = num * cPI / 6
    	clock.rotate(ang)
    	clock.translate(0, -Radius*0.85)
    	clock.rotate(-ang)
    	clock.fillText("" & num, 0, 0)
    	clock.rotate(ang)
    	clock.translate(0, Radius*0.85)
    	clock.rotate(-ang)
  	Next
	
	' draw time
	Dim hour As Double = DateTime.GetHour(DateTime.Now)
	Dim minute As Double = DateTime.GetMinute(DateTime.Now)
	Dim second As Double = DateTime.GetSecond(DateTime.Now)
	hour = hour Mod 12
	hour = (hour*cPI/6)+(minute*cPI/(6*60))+(second*cPI/(360*60))	
	BuildHand(clock, hour, Radius*0.5, Radius*0.07)
	minute=(minute*cPI/30)+(second*cPI/(30*60))
	BuildHand(clock, minute, Radius*0.8, Radius*0.07)
	second=(second*cPI/30)
	BuildHand(clock, second, Radius*0.9, Radius*0.02)
	
	Return clock
End Sub

Sub BuildHand(clock As ABMCanvasObject, pos As Int, length As Double, width As Double)
	clock.beginPath
    clock.lineWidth(width)
    clock.lineCap(ABM.CANVAS_LINECAP_ROUND)
    clock.moveTo(0,0)
    clock.rotate(pos)
    clock.lineTo(0, -length)
    clock.stroke
    clock.rotate(-pos)
End Sub

Sub BuildControlBar() As ABMCanvasObject
	Dim cont As ABMCanvasObject	
	cont.InitializeAsRectangle(page, "contbar", 0,0,1024,100,False)
	cont.beginPath
	cont.lineWidth(5)
	cont.lineCap(ABM.CANVAS_LINECAP_ROUND)
	cont.strokeStyleColor("#888888")
	cont.moveTo(20,47)
	cont.lineTo(1004,47)
	cont.stroke	
	Return cont
End Sub

Sub BuildControlCircle() As ABMCanvasObject
	Dim cont As ABMCanvasObject
	cont.InitializeAsCircle(page, "contcirc", 50,48,40, True)
	' here we restrict the movement of the control so it only can me moved on the X-Axis
	cont.SetDragZone(50,48,924,1)
	
	cont.beginPath
	cont.arc(0,0,40, 0, 2*cPI)
	cont.fillStyleColor("#000000")	
	cont.fill
	cont.save
	cont.translate(-40,-40)
	cont.drawImage3("eric", 0,0,147,135,5,5, 70,64)
	cont.closePath
	cont.restore
	Return cont
End Sub

Sub canvas3_ObjectUp(objectId As String)
	' calculate value from position
	Dim canvas1 As ABMCanvas = page.Component("canvas3")
	Dim Eric As ABMCanvasObject = canvas1.GetObject(objectId)
	Dim Pos As ABMPoint = Eric.GetPosition
	If Pos <> Null Then
		' map to 0 to 100: (our position - the dragzone left)/(dragzone width)*100
		Dim value As Int = (Pos.x-50)/924*100
		myToastId = myToastId + 1	
		page.ShowToast("toast" & myToastId, "toastred", "Eric is at value " & value, 5000)
	End If
End Sub

