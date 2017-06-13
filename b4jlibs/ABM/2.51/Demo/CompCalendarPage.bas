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
	Public Name As String = "CompCalendarPage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
	Dim evID As Int
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
	page.PageTitle = "ABMCalendar"
	page.PageDescription = "The calendar component "	
	page.PageHTMLName = "abmaterial-calendar.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMCalendar", "../images/logo.png", "", "Controls", "ABMCalendar")
		
	' create the page grid
	page.AddRows(5,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True

	ABMShared.BuildFooter(page)
End Sub

public Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Calendar is a drag-n-drop component for displaying events on a full-sized calendar.") )
	
	' NOTE id MUST be 'calendar' (lowercase) + a number! IMPORTANT
	' NOTE You cannot use AddArrayComponent() and cannot be added to a control that is an ArrayComponent! IMPORTANT
	Dim cal1 As ABMCalendar 
	cal1.Initialize(page, "calendar1", "2015-11-18", ABM.FIRSTDAYOFWEEK_MONDAY, "en", ABM.CALENDAR_DEFAULTVIEW_WEEK, "")
	cal1.Editable = True
	cal1.MinTime = "06:00"
	cal1.MaxTime = "22:00"
	page.Cell(2,1).AddComponent(cal1)	
	
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
	If Action = "ABMCalendar" Then Return
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

Sub calendar1_DayClicked(date As String)
	Log("day clicked: " & date)
	Dim cal1 As ABMCalendar = page.Component("calendar1")
	cal1.GotoDate("2015-12-31")
End Sub

Sub calendar1_FetchData(dateStart As String, dateEnd As String)
	Log("from: " & dateStart & " - to: " & dateEnd)
	Dim FromDate As Long = ABMShared.String2Date(dateStart)
	
	evID=0
	
	Dim cols As List 
	cols.Initialize2(Array As String(ABM.COLOR_DEEPORANGE, ABM.COLOR_LIGHTBLUE, ABM.COLOR_GREEN, ABM.COLOR_RED, ABM.COLOR_BLACK))
	
	Dim eventList As List
	eventList.Initialize
	
	' add some random events
	For i = 0 To 15
		Dim ev As ABMCalendarEvent
		Dim per As Period
		per.Initialize
		per.Days = Rnd(0,7)
		Dim newDate As Long = DateUtils.AddPeriod(FromDate,per)
		evID=evID+1
		Dim Begin As String
		If Rnd(1,10) < 2 Then ' make some alldays
		 	Begin = ABMShared.Date2String(newDate, False)
			ev.Initialize("" & evID, "Event number: " & evID, Begin)
			ev.AllDay=True
			' set a color IMPORTANT!
			ev.BackgroundColor = cols.Get(Rnd(0,5))			
		Else ' make some normal ones
			per.Days = 0
			per.Hours = Rnd(9,18)
			newDate = DateUtils.AddPeriod(newDate,per)
			Begin = ABMShared.Date2String(newDate, True)
			ev.Initialize("" & evID, "Event number: " & evID, Begin)
			' set a color IMPORTANT!
			ev.BackgroundColor = cols.Get(Rnd(0,5))
			per.Hours = Rnd(1,4)
			newDate = DateUtils.AddPeriod(newDate,per)
			ev.EndTime = ABMShared.Date2String(newDate, True)
		End If
		
		eventList.Add(ev)
	Next
	
	Dim cal1 As ABMCalendar = page.Component("calendar1")
	Log(cal1.GetTitle)
	cal1.SetEvents(eventList)
	cal1.Refresh ' IMPORTANT
End Sub

Sub calendar1_EventClicked(eventId As String)
	Log("clicked on event: " & eventId)
End Sub

' has more than 2 params (case sensitive!):
' params.get("eventid")
' params.get("newstart")
' params.get("allday")
Sub calendar1_EventStartChanged(params As Map)
	Log("Start changed of event: " & params.Get("eventid") & " newStart: " & params.Get("newstart") & " AllDay: " & params.Get("allday"))
End Sub

Sub calendar1_EventEndChanged(eventId As String, NewEnd As String)
	Log("End changed of event: " & eventId & " newEnd: " & NewEnd)
End Sub
