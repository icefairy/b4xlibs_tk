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
	Public Name As String = "CompChipPage"
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
		' toast theme
	theme.AddToastTheme("toastgreen")
	theme.Toast("toastgreen").BackColor = ABM.COLOR_GREEN
	theme.Toast("toastgreen").BackColorIntensity = ABM.INTENSITY_DARKEN2
	
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
	page.PageTitle = "ABMChip"
	page.PageDescription = "The chip component "	
	page.PageHTMLName = "abmaterial-chip.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMChip", "../images/logo.png", "", "Controls", "ABMChip")
		
	' create the page grid
	page.AddRows(11,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
		
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Chips can be used to represent small blocks of information. They are most commonly used either for contacts or for tags.") )
	
	' create the chips
	Dim ch1 As ABMChip
	ch1.Initialize(page, "ch1", "Dad", False, "")
	page.Cell(2,1).AddComponent(ch1)
	
	Dim ch2 As ABMChip
	ch2.Initialize(page, "ch2", "Mom", False, "")
	page.Cell(2,1).AddComponent(ch2)
	
	' add codeblock	
	Dim code1 As StringBuilder
	code1.Initialize
	code1.Append("// create the chips").Append(CRLF)
	code1.Append("Dim ch1 As ABMChip").Append(CRLF)
	code1.Append("ch1.Initialize(page, ""ch1"", ""Dad"", False, """")").Append(CRLF)
	code1.Append("page.Cell(2,1).AddComponent(ch1)").Append(CRLF)
	code1.Append("").Append(CRLF)
	code1.Append("Dim ch2 As ABMChip").Append(CRLF)
	code1.Append("ch2.Initialize(page, ""ch2"", ""Mom"", False, """")").Append(CRLF)
	code1.Append("page.Cell(2,1).AddComponent(ch2)").Append(CRLF)
	
	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlock(page, "code1", code1))
	
	
	' add paragraph	
	page.cell(4,1).AddComponent(ABMShared.BuildParagraph(page,"par2","Chips can have a little prefix image representing some kind of contact chip.") )
	
	' create the chips
	Dim ch3 As ABMChip
	ch3.Initialize(page, "ch3", "Dad", False, "")
	ch3.Image = "../images/dad.jpg"
	page.Cell(5,1).AddComponent(ch3)
	
	Dim ch4 As ABMChip
	ch4.Initialize(page, "ch4", "Mom", False, "")
	ch4.Image = "../images/mom.jpg"
	page.Cell(5,1).AddComponent(ch4)
	
	' add codeblock	
	Dim code2 As StringBuilder
	code2.Initialize
	code2.Append("// create the chips").Append(CRLF)
	code2.Append("Dim ch3 As ABMChip").Append(CRLF)
	code2.Append("ch3.Initialize(page, ""ch3"", ""Dad"", False, """")").Append(CRLF)
	code2.Append("ch3.Image = ""../images/dad.jpg""").Append(CRLF)
	code2.Append("page.Cell(5,1).AddComponent(ch3)").Append(CRLF)
	code2.Append("").Append(CRLF)
	code2.Append("Dim ch4 As ABMChip").Append(CRLF)
	code2.Append("ch4.Initialize(page, ""ch4"", ""Mom"", False, """")").Append(CRLF)
	code2.Append("ch4.Image = ""../images/mom.jpg""").Append(CRLF)
	code2.Append("page.Cell(5,1).AddComponent(ch4)").Append(CRLF)
	
	page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlock(page, "code2", code2))
	
	
	' add paragraph	
	page.cell(7,1).AddComponent(ABMShared.BuildParagraph(page,"par3","To create chips that can be closed, just set the 'CanBeClosed' parameter = true in the Initialize method. Brother and Sister are chips that can be closed.") )
	
	' create the chips
	' This time as array so we can catch the events in one method.
	' good practice is using giving the 'Array' components just the numeric part of the ID.
	' That way you can use the Event name as you would any other event.
	' e.g. here: 'mycheck' is the ArrayName, and '5', '6', '7', '8' are the IDs.
	' Now we can use mycheck_Clicked() and use the target to get our individual component
	Dim ch5 As ABMChip
	ch5.Initialize(page, "5", "Dad", False, "")
	ch5.Image = "../images/dad.jpg"
	page.Cell(8,1).AddArrayComponent(ch5, "mycheck")
	
	Dim ch6 As ABMChip
	ch6.Initialize(page, "6", "Mom", False, "")
	ch6.Image = "../images/mom.jpg"
	page.Cell(8,1).AddArrayComponent(ch6, "mycheck")
	
	Dim ch7 As ABMChip
	ch7.Initialize(page, "7", "Brother", True, "")
	ch7.Image = "../images/brother.jpg"
	page.Cell(8,1).AddArrayComponent(ch7, "mycheck")
	
	Dim ch8 As ABMChip
	ch8.Initialize(page, "8", "Sister", True, "")
	ch8.Image = "../images/sister.jpg"
	page.Cell(8,1).AddArrayComponent(ch8, "mycheck")
	
	' add codeblock	
	Dim code3 As StringBuilder
	code3.Initialize
	code3.Append("// create the chips").Append(CRLF)
	code3.Append("// This time As Array so we can Catch the events in one method.").Append(CRLF)
	code3.Append("// good practice Is using giving the 'Array' components just the numeric part of the ID.").Append(CRLF)
	code3.Append("// That way you can use the Event Name As you would any other event.").Append(CRLF)
	code3.Append("// e.g. here: 'mycheck' is the ArrayName, and '5', '6', '7', '8' are the IDs.").Append(CRLF)
	code3.Append("// Now we can use mycheck_Clicked() And use the target To get our individual component").Append(CRLF)
	code3.Append("Dim ch5 As ABMChip").Append(CRLF)
	code3.Append("ch5.Initialize(page, ""5"", ""Dad"", False, """")").Append(CRLF)
	code3.Append("ch5.Image = ""../images/dad.jpg""").Append(CRLF)
	code3.Append("page.Cell(8,1).AddArrayComponent(ch5, ""mycheck"")").Append(CRLF)
	code3.Append("").Append(CRLF)
	code3.Append("Dim ch6 As ABMChip").Append(CRLF)
	code3.Append("ch6.Initialize(page, ""6"", ""Mom"", False, """")").Append(CRLF)
	code3.Append("ch6.Image = ""../images/mom.jpg""").Append(CRLF)
	code3.Append("page.Cell(8,1).AddArrayComponent(ch6, ""mycheck"")").Append(CRLF)
	code3.Append("").Append(CRLF)
	code3.Append("Dim ch7 As ABMChip").Append(CRLF)
	code3.Append("ch7.Initialize(page, ""7"", ""Brother"", True, """")").Append(CRLF)
	code3.Append("ch7.Image = ""../images/brother.jpg""").Append(CRLF)
	code3.Append("page.Cell(8,1).AddArrayComponent(ch7, ""mycheck"")").Append(CRLF)
	code3.Append("").Append(CRLF)
	code3.Append("Dim ch8 As ABMChip").Append(CRLF)
	code3.Append("ch8.Initialize(page, ""8"", ""Sister"", True, """")").Append(CRLF)
	code3.Append("ch8.Image = ""../images/sister.jpg""").Append(CRLF)
	code3.Append("page.Cell(8,1).AddArrayComponent(ch8, ""mycheck"")").Append(CRLF)
	
	page.Cell(9,1).AddComponent(ABMShared.BuildCodeBlock(page, "code3", code3))	
	
	' add paragraph	
	page.cell(10,1).AddComponent(ABMShared.BuildParagraph(page,"par4","When the user clicks on a chip, the Clicked() event is raised.  When the close button is clicked, the Closed() event is raised.") )
	
	' add codeblock	
	Dim code4 As StringBuilder
	code4.Initialize
	code4.Append("Sub mycheck_Clicked(Target As String)").Append(CRLF)
	code4.Append("   Dim chip As ABMChip = page.Component(Target)").Append(CRLF)
	code4.Append("   Dim title As String = chip.Text").Append(CRLF)
	code4.Append("   Dim myTexts, myReturns As List").Append(CRLF)
	code4.Append("   myTexts.Initialize").Append(CRLF)
	code4.Append("   myReturns.Initialize").Append(CRLF)
	code4.Append("   myToastId = myToastId + 1").Append(CRLF)
	code4.Append("   page.ShowToast(""toast"" & myToastId, ""toastgreen"", ""Clicked "" & title, 5000, myTexts, myReturns)").Append(CRLF)
	code4.Append("End Sub").Append(CRLF)
	code4.Append("").Append(CRLF)
	code4.Append("Sub mycheck_Closed(Target As String)").Append(CRLF)
	code4.Append("   Dim chip As ABMChip = page.Component(Target)").Append(CRLF)
	code4.Append("   Dim title As String = chip.Text").Append(CRLF)
	code4.Append("   Dim myTexts, myReturns As List").Append(CRLF)
	code4.Append("   myTexts.Initialize").Append(CRLF)
	code4.Append("   myReturns.Initialize").Append(CRLF)
	code4.Append("   myToastId = myToastId + 1").Append(CRLF)
	code4.Append("   page.ShowToast(""toast"" & myToastId, ""toastgreen"", ""Closed "" & title, 5000, myTexts, myReturns)").Append(CRLF)
	code4.Append("End Sub").Append(CRLF)
	
	page.Cell(11,1).AddComponent(ABMShared.BuildCodeBlock(page, "code4", code4))
	
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
	If Action = "ABMChip" Then Return
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

Sub mycheck_Clicked(Target As String)
	Log(Target)
	Dim chip As ABMChip = page.Component(Target)
	Dim title As String = chip.Text
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastgreen", "Clicked " & title, 5000)
	
End Sub



Sub mycheck_Closed(Target As String)
	Dim chip As ABMChip = page.Component(Target)
	Dim title As String = chip.Text
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastgreen", "Closed " & title, 5000)
End Sub

