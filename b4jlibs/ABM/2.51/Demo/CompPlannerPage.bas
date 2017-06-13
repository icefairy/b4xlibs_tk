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
	Public Name As String = "CompPlannerPage"
	Private ABMPageId As String = ""
	
	' your own variables
	Dim FirstNames As List
	Dim LastNames As List
	Dim FirstDate As Long
	
	Dim cutTaskID As String
	Dim copyTask As ABMPlannerTask
	Dim IsCut As Boolean
	Dim counter As Int
	
	Dim myToastID As Int
	Dim ActiveDay As Int = -1

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
	theme.AddPlannerTheme("demo")
	theme.Planner("demo").MenuColor = ABM.COLOR_LIME
	theme.Planner("demo").MenuColorIntensity = ABM.INTENSITY_DARKEN3
	theme.Planner("demo").HourColor = ABM.COLOR_GREY
	theme.Planner("demo").HourColorIntensity = ABM.INTENSITY_LIGHTEN2
	theme.Planner("demo").HourTextColor = ABM.COLOR_BLACK
	theme.Planner("demo").HourAltColor = ABM.COLOR_GREY
	theme.Planner("demo").HourAltTextColor = ABM.COLOR_BLACK
	theme.Planner("demo").HourMinutesUsedColors(0,ABM.COLOR_BLUEGREY)
	theme.Planner("demo").HourMinutesUsedColorsIntensity(0,ABM.INTENSITY_DARKEN4)
	theme.Planner("demo").HourMinutesUsedColors(1,ABM.COLOR_BLUEGREY)
	theme.Planner("demo").HourMinutesUsedColorsIntensity(1,ABM.INTENSITY_DARKEN2)
	theme.Planner("demo").HourMinutesUsedColors(2,ABM.COLOR_BLUEGREY)
	theme.Planner("demo").HourMinutesUsedColorsIntensity(2,ABM.INTENSITY_NORMAL)
	theme.Planner("demo").HourMinutesUsedColors(3,ABM.COLOR_BLUEGREY)
	theme.Planner("demo").HourMinutesUsedColorsIntensity(3,ABM.INTENSITY_LIGHTEN2)
	theme.Planner("demo").HourMinutesNotAvailableColorIntensity = ABM.INTENSITY_DARKEN3
	
	theme.AddCellTheme("center")
	theme.Cell("center").Align = ABM.CELL_ALIGN_CENTER
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMPlannert"
	page.PageDescription = "The planner component "	
	page.PageHTMLName = "abmaterial-planner.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMPlanner", "../images/logo.png", "", "Controls", "ABMPlanner")

	' create the page grid
	page.AddRows(1,True, "").AddCells12(1,"")
	page.AddRows(1,True, "").AddCellsOSMP(1,0,0,0,2,2,1,18,0,0,0,"").AddCellsOSMP(1,0,0,0,8,8,10,0,0,0,0,"").AddCellsOSMP(1,0,0,0,2,2,1,18,0,0,0,"")
	page.AddRows(1,False, "").AddCells12MP(1,0,0,10,10,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	page.Cell(2,1).UseTheme("center")
	page.Cell(2,3).UseTheme("center")
	' You can use 'FromBottom' on pages that only take up one screen
	page.Cell(3,1).SetFixedHeightFromBottom(50,True)
	
	Dim prevWeek As ABMButton
	prevWeek.InitializeFloating(page, "prevWeek", "mdi-av-skip-previous", "")
	page.Cell(2,1).AddComponent(prevWeek)	
		
	Dim mydate3 As ABMDateTimePicker
    Dim NewDate As Long = DateTime.Now
    mydate3.Initialize(page, "mydate3", ABM.DATETIMEPICKER_TYPE_WEEK, NewDate, "Pick a week", "")	
    mydate3.CancelText = "Back"
    mydate3.PickText = "OK"
    mydate3.TodayText = "This week"
    mydate3.Language = "en"
	mydate3.ReturnDateFormat = "MM/DD/YYYY"   ' <--- see demo source code for settings
    mydate3.ReturnTimeFormat = "" ' <--- see demo source code for settings
    mydate3.FirstDayOfWeek = 1
    mydate3.WeekText = "Week"  
	mydate3.ClickThrough = True
	mydate3.IsTextSelectable = False
    page.Cell(2,2).AddComponent(mydate3) '    <---
	
	Dim nextWeek As ABMButton
	nextWeek.InitializeFloating(page, "nextWeek", "mdi-av-skip-next", "")
	page.Cell(2,3).AddComponent(nextWeek)
		
	Dim plan As ABMPlanner
	plan.Initialize(page, "plan", True, 6,20, 5, False,"demo")
	plan.UseHeatMap("1,3,6")
	page.Cell(3,1).AddComponent(plan)
	
	FirstNames.Initialize2(Array As String("Alain", "Jos", "Paul", "Bertrande", "Julie", "Stephanie", "Bert", "Charles", "James", "Walter", "Carine", "Geert", "Kristof", "Christophe", "Filip", "Irene", "Gilbert", "Walter", "Bert", "Bart"))
	LastNames.Initialize2(Array As String("Bailleul", "Rogiers", "Dougherty", "Rodrigues", "Ostrander", "Kenyon", "Grant", "Klinger", "Sheffield", "Poindexter","Casier", "Lacour", "Matton", "Desomer", "Creus", "Parmentier", "Tiberhein", "Declercq", "Verfaille", "Gadeyne"))

	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","ABMPlanner is a scheduling component.  In the demo, Long Tap on the minutes to the open the action menu."))
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","Note that in this demo the tasks are random, so changing weeks will always result in another schedule!"))
	
	'	init all your own variables (like a List, Map) and add your components
	Dim mydate3 As ABMDateTimePicker = page.Component("mydate3")
	Dim spl() As String = Regex.Split(";",mydate3.GetDateWeek)
	FirstDate = spl(1)
	LoadRandomWeek(FirstDate, False)		
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub NewTask(day As Int, taskID As String, startHour As Int, startMinutesPer5 As Int, lengthMinutesPer5 As Int, text As String, themeColorIndex As Int) As ABMPlannerTask
	Dim task As ABMPlannerTask
	task.Initialize(day, taskID, startHour, startMinutesPer5, lengthMinutesPer5, text, themeColorIndex)
	Return task
End Sub

Sub plan_ActiveDayChanged(day As Int)
	Log("New day: " & day)
	ActiveDay = day
	' important to sync the server with the browser!
	Dim plan As ABMPlanner = page.Component("plan")
	plan.SetActiveDay(ActiveDay)
End Sub

Sub plan_MinutesClicked(Value As String)
	Dim spl() As String = Regex.Split(";", Value)
	' spl(0) is here always 0, as this would contain the menu item clicked.  This is to be uniform with the MenuClicked Value param
	Log("Day: " & spl(1))
	Log("Hour: " & spl(2))
	Log("MinPer5: " & spl(3))
	' use the ABM.PLANNER_STATUS_ constants to check the status
	Log("Status: " & spl(4))
	Log("Task ID: " & spl(5))
	
	myToastID = myToastID + 1	
	page.ShowToast("toast" & myToastID, "toastred", "In a real app, here you could open a task editor.", 5000)
End Sub

Sub plan_MenuClicked(MenuType As String, Value As String)
	Dim spl() As String = Regex.Split(";", Value)
	Dim plan As ABMPlanner = page.Component("plan")
	Log("MenuType: " & MenuType)
	Log("Value: " & Value)
	Select Case MenuType
		Case ABM.PLANNER_MENUTYPE_DAY
			' update the database
			
			Log("Day: " & spl(1))
			
			Select Case spl(0)
				Case ABM.PLANNER_MENU_SETFREE
					plan.SetDayStatus(spl(1), True)
				Case ABM.PLANNER_MENU_SETNOTAVAILABLE
					plan.SetDayStatus(spl(1), False)
			End Select
			
			' IMPORTANT to perform the action in the browser	
			plan.PerfromDayHourMenuAction		
		Case ABM.PLANNER_MENUTYPE_HOUR
			' update the database
			
			Log("Day: " & spl(1))
			Log("Hour: " & spl(2))
			
			Select Case spl(0)
				Case ABM.PLANNER_MENU_SETFREE
					plan.SetHourStatus(spl(1), spl(2), True)
				Case ABM.PLANNER_MENU_SETNOTAVAILABLE
					plan.SetHourStatus(spl(1), spl(2), False)
			End Select
						
			' IMPORTANT to perform the action in the browser	
			plan.PerfromDayHourMenuAction			
		Case ABM.PLANNER_MENUTYPE_MIN	
			' update the database
			
			Log("Day: " & spl(1))
			Log("Hour: " & spl(2))
			Log("MinPer5: " & spl(3))
			' use the ABM.PLANNER_STATUS_ constants to check the status
			Log("Status: " & spl(4))
			Log("Task ID: " & spl(5))
			
			Select Case spl(0)
				Case ABM.PLANNER_MENU_CUT
					cutTaskID = spl(5)
					copyTask = plan.GetTask(spl(5))
					IsCut = True
					myToastID = myToastID + 1	
					page.ShowToast("toast" & myToastID, "toastred", "Move " & copyTask.Text & " to...", 5000)
				Case ABM.PLANNER_MENU_COPY
					copyTask = plan.GetTask(spl(5))
					IsCut = False
					myToastID = myToastID + 1	
					page.ShowToast("toast" & myToastID, "toastred", "Copy " & copyTask.Text & " to...", 5000)
				Case ABM.PLANNER_MENU_PASTE
					If IsCut Then
						plan.RemoveTask2(cutTaskID)
					Else
						counter = counter + 1
						copyTask = copyTask.Clone("T" & counter)
					End If
					copyTask.Day = spl(1)
					copyTask.StartHour = spl(2)					
					copyTask.StartMinututesPer = spl(3)
					plan.AddTask(copyTask)					
					plan.Refresh
					If IsCut Then
						myToastID = myToastID + 1	
						page.ShowToast("toast" & myToastID, "toastred", copyTask.Text & " moved!", 5000)
					Else
						myToastID = myToastID + 1	
						page.ShowToast("toast" & myToastID, "toastred", copyTask.Text & " copied!", 5000)
					End If
				Case ABM.PLANNER_MENU_DELETE
					plan.RemoveTask2(spl(5))
					plan.Refresh
			End Select	
		
			
	End Select
End Sub

Sub prevWeek_Clicked(Target As String)
	page.PauseDelayed(2000)
	
	Dim per As Period
	per.Initialize
	per.Days = -7
	
	FirstDate = DateUtils.AddPeriod(FirstDate, per)
	
	Dim mydate3 As ABMDateTimePicker = page.Component("mydate3")
	mydate3.SetDate(FirstDate)
		
	LoadRandomWeek(FirstDate, True)
	
	mydate3.Refresh
End Sub

Sub nextWeek_Clicked(Target As String)
	page.PauseDelayed(2000)
	
	Dim per As Period
	per.Initialize
	per.Days = 7
	
	FirstDate = DateUtils.AddPeriod(FirstDate, per)
	
	Dim mydate3 As ABMDateTimePicker = page.Component("mydate3")
	mydate3.SetDate(FirstDate)
	
	LoadRandomWeek(FirstDate, True)
	
	mydate3.Refresh
End Sub

Sub mydate3_ChangedWeek(Target As String, WeekString As String)
	page.PauseDelayed(2000)
	
	Dim spl() As String = Regex.Split(";",WeekString)
	FirstDate = spl(1)
	LoadRandomWeek(FirstDate, True)
End Sub

Sub LoadRandomWeek(StartDay As Long,doRefresh As Boolean)
	Dim plan As ABMPlanner = page.Component("plan")
	plan.ClearPlanner
	
	Dim Days(7) As String
	Dim Day As Int = DateTime.GetDayOfMonth(StartDay)
	Dim nextDay As Long = StartDay
	Dim perNext As Period
	perNext.Initialize
	perNext.Days = 1
	For i = 0 To 6
		If ActiveDay = -1 Then
			If DateTime.Date(nextDay) = DateTime.Date(DateTime.Now) Then
				ActiveDay = i
			End If
		End If
		Days(i)	= Day
		If Days(i).Length = 1 Then
			Days(i) = "0" & Days(i)
		End If		
		nextDay = DateUtils.AddPeriod(nextDay, perNext)
		Day = DateTime.GetDayOfMonth(nextDay)
	Next
	' the day is not visible
	If ActiveDay = -1 Then ActiveDay = 0
	
	Dim mins As List
	mins.Initialize
	mins.Add(1)
	mins.Add(3)
	mins.Add(6)
	mins.Add(12)
	plan.SetDayLabels("MO " & Days(0), "TU " & Days(1), "WE " & Days(2), "TH " & Days(3), "FR " & Days(4),  "SA " & Days(5),  "SU " & Days(6))
	Dim PerTotal As Int = 12
	
	For i = 0 To 4
		Dim u As Int = 6
		Dim m As Int = 0
		Dim l As Int = 0
		Dim lIndex As Int
		Do While u < 21 	
			Do While m < PerTotal				
				m = m + Rnd(1,3)							
				lIndex = Rnd(0,3)
				l = mins.Get(lIndex)
				If (u*PerTotal + m + l) < (21*PerTotal) And m < PerTotal And (i <> 2 Or u <=11 ) Then
					Dim patient As String = FirstNames.get(Rnd(0,19)) & " " & LastNames.get(Rnd(0,19))	
					counter = counter + 1
					plan.AddTask(NewTask(i, "T" & counter,u,m,l,patient,lIndex)) ' taskid must be a string!										
				End If
				m = m + l
			Loop
			m = m - PerTotal
			u = u + 1
		Loop
	Next	

	plan.SetActiveDay(ActiveDay)
	plan.SetDayStatus(5,False)
	plan.SetDayStatus(6,False)
	For i = 12 To 20
		plan.SetHourStatus(2,i,False)
	Next
	If doRefresh Then
		plan.Refresh
	End If
End Sub

Sub plan_Refreshed()
	page.Resume
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMPlanner" Then Return
	If Action = "Contact" Then		
		myToastID = myToastID + 1	
		page.ShowToast("toast" & myToastID, "toastred", "Hello to you too!", 5000)
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
