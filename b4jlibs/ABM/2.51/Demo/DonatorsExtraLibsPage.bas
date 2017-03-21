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
	Public Name As String = "DonatorsExtraLibsPage"
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
	page.PageTitle = "Extra libraries"
	page.PageDescription = "Extra librarries"	
	page.PageHTMLName = "abmaterial-extralibs.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
	
	ABMShared.BuildNavigationBar(page, "Extra libraries","../images/logo.png", "", "Donators", "ExtraLibs")
	
	' create the page grid
	page.AddRows(10,True, "").AddCells12(1,"")
	
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","As an extra thank you for those who want to support ABMaterial and made a donation, I give them some extra libraries."))	
	
	Dim donButton As DonateButton
	donButton.Initialize(page, "donButton")
	page.Cell(1,1).AddComponent(donButton.ABMComp)
		
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr2", "ABExchange"))	
	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","It can be used to sync the ABMCalendar control with your exchange server and outlook."))	
	
	Dim code1 As String = $"Sub calendar1_FetchData(dateStart As String, dateEnd As String)
    Log("from: " & dateStart & " - to: " & dateEnd)
        
    If dateStart.Length < 11 Then
        dateStart = dateStart & "T00:00:00"        
        dateEnd = dateEnd & "T00:00:00"
    End If
    
    Dim eventList As List
    eventList.Initialize
    
    Dim exch As ABExchange
    exch.Initialize("https://xxxxxxxxx.one-two.com/EWS/Exchange.asmx")
    If exch.Connect(Login, pwd) = False Then
        Log("NOT autohorized!")
        Return
    Else
        Log("autohorized!")
        Dim lst As List
        lst = exch.findAppointments(dateStart, dateEnd)
        For i = 0 To lst.Size-1
            Dim app As ABEAppointment = lst.Get(i)
            Dim ev As ABMCalendarEvent
            Dim starttime As String = app.StartTime
            Dim endtime As String = app.EndTime
                        
            ev.Initialize(app.EventId, app.Title, starttime)
            ev.EndTime = endtime
            ev.AllDay = app.AllDay
            // set a color IMPORTANT!
            ev.BackgroundColor = ABM.COLOR_ORANGE
            ev.BackgroundColorIntensity = ABM.INTENSITY_DARKEN4
            eventList.Add(ev)
        Next
    End If
    
    Dim cal1 As ABMCalendar = page.Component("calendar1")
    Log(cal1.GetTitle)
    cal1.SetEvents(eventList)
    cal1.Refresh // IMPORTANT
End Sub"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code1))
	
	Dim code2 As String = $"Sub calendar1_EventClicked(eventId As String)
    Log("clicked on event: " & eventId)
End Sub"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code2))
	
	Dim code3 As String = $"Sub calendar1_EventStartChanged(params As Map)
	// has more than 2 params (case sensitive!):
	// params.get("eventid")
	// params.get("newstart")
	// params.get("newend")
	// params.get("allday")
    Log("Start changed of event: " & params.Get("eventid") & " newStart: " & params.Get("newstart") & " newEnd: " & params.Get("newend") & " AllDay: " & params.Get("allday"))
    Dim ev As ABEAppointment
    Dim exch As ABExchange
    exch.Initialize("https://xxxxxxxxxxxxxxx.one-two.com/EWS/Exchange.asmx")
    If exch.Connect(Login, pwd) = False Then
        Log("NOT autohorized!")
        Return
    Else
        ev = exch.GetAppointment(params.Get("eventid"))
        ev.StartTime = params.Get("newstart")
        // important, as the start ended, you must also set the new end!!!!!
        ev.endTime = params.Get("newend")
        ev.AllDay = params.Get("allday")
        exch.UpdateAppointment(ev)
    End If
    
End Sub"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code3", code3))
	
	Dim code4 As String = $"Sub calendar1_EventEndChanged(eventId As String, NewEnd As String)
    Log("End changed of event: " & eventId & " newEnd: " & NewEnd)
    Dim ev As ABEAppointment
    Dim exch As ABExchange
    exch.Initialize("https://xxxxxxxxxxxxxxx.one-two.com/EWS/Exchange.asmx")
    If exch.Connect(Login, pwd) = False Then
        Log("NOT autohorized!")
        Return
    Else
        ev = exch.GetAppointment(eventId)
        ev.EndTime = NewEnd
        exch.UpdateAppointment(ev)
    End If
End Sub"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code4", code4))
	
	Dim code5 As String = $"Sub switch1_Clicked()
    Dim switch1 As ABMSwitch = page.Component("switch1")
    Dim cal1 As ABMCalendar = page.Component("calendar1")
    cal1.ChangeEventsEditable(switch1.State)    
    cal1.Refresh    
End Sub"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code5", code5))
	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par3","It can also send an email using your exchange server."))		
	
	Dim code6 As String = $"Dim exch As ABExchange
exch.Initialize("https://xxxxxxxxxxxxxxxx.one-two.com/EWS/Exchange.asmx")
If exch.Connect(login, password) = False Then
	Log("NOT autohorized!")
    return
end if
        
Dim mail As ABEEmail
mail.Initialize
mail.Recipients.Add("alain.bailleul@pandora.be")
mail.Subject = "Test from alain"
mail.Body = "This is the body"
mail.Attachments.Add("z:\442124171115-210643608.pdf")
Log(exch.SendEmail(mail))
exch.Disconnect"$
	
	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code6", code6))
	
	page.Cell(4,1).AddComponent(ABMShared.BuildHeader(page,"hdr4", "ABJasperReports"))	
	
	page.Cell(4,1).AddComponent(ABMShared.BuildParagraph(page,"par4","This is a little library that allows you to export reports created in Jasper Reports in your B4J applications. They can be exported to  pdf, html and xls.  You can use parameters defined in JasperReports."))	
	
	Dim code7 As String = $"Sub AppStart (Args() As String)
    DBM.InitializeMySQLMaria("jdbc:mariadb://localhost:3306/sakila", "root", "1418", 100)
    
    Dim SQL As SQL = DBM.GetSQL
    
    Dim jr As ABJasperReports
    jr.Initialize("YOURDONATORKEY")

    Dim Params As Map
    Params.Initialize

    jr.ExportPDF(SQL, "sakila.jrxml", Params, "sakila.pdf")
    jr.ExportHTML(SQL, "sakila.jrxml", Params, "sakila.html")
    jr.ExportXLS(SQL, "sakila.jrxml", Params, "sakila.xls")
        
    Params.Put("myId", 1)
    jr.ExportPDF(SQL, "sakilaparam.jrxml", Params, "sakilaparam.pdf")
        
    DBM.CloseSQL(SQL)
    StartMessageLoop
End Sub"$
	
	page.Cell(4,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code7", code7))
	
	page.Cell(5,1).AddComponent(ABMShared.BuildHeader(page,"hdr5", "ABPDFBox"))	
	
	page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par5","With this library you can print PDF files (either by showing a dialogbox or directly to a specified printer)."))	
	page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par6","Usage in a Non UI App:"))
	
	Dim code8 As String = $"Sub Process_Globals
    Dim PDF As ABPDFBox
End Sub"$
	
	page.Cell(5,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code8", code8))
	
	Dim code9 As String = $"Sub AppStart (Args() As String)
    PDF.Initialize("DONATORKEY")
    // also check out PDF.PrintEx if you want to set margins, or the page size,...
    PDF.Print("Z:\", "pi3.pdf", "3005ci",2, True)
    StartMessageLoop
End Sub"$
	
	page.Cell(5,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code9", code9))
	
	page.Cell(6,1).AddComponent(ABMShared.BuildParagraph(page,"par7","Usage in a UI App:"))
	
	Dim code10 As String = $"Sub Process_Globals
    Private fx As JFX
    Private MainForm As Form
    Dim PDF As ABPDFBox
    Private Button1 As Button
End Sub"$
	
	page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code10", code10))
	
	Dim code11 As String = $"Sub AppStart (Form1 As Form, Args() As String)
    MainForm = Form1
    MainForm.RootPane.LoadLayout("1") //Load the layout file.
    MainForm.Show
    
    PDF.Initialize("DONATORKEY")
    PDF.PrintWithDialog("Z:\", "pi3.pdf") 
End Sub"$
	
	page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code11", code11))
	
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
	If Action = "FirebaseStor" Then Return
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

