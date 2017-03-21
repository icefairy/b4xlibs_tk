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
	Public Name As String = "CompDateTimePickerPage"
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
	page.PageTitle = "ABMDateTimePicker"
	page.PageDescription = "The date/time picker component "	
	page.PageHTMLName = "abmaterial-date-time-picker.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMDateTimePicker", "../images/logo.png", "", "Controls", "ABMDateTimePicker")
		
	' create the page grid
	page.AddRows(7,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True		
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par1","The date time picker component can be used to input a date, a time or both using the DATETIMEPICKER_TYPE_TIME, DATETIMEPICKER_TYPE_DATE and DATETIMEPICKER_TYPE_DATETIME constants.") )	
	
	
'	Input		Example				Description
'	YYYY		2014				4 Or 2 digit year
'	YY			14					2 digit year
'	Q			1..4				Quarter of year. Sets month To first month in quarter.
'	M MM		1..12				Month number
'	MMM MMMM	Jan..December		Month Name in locale set by moment.locale()
'	D DD		1..31				Day of month
'	Do			1st..31st			Day of month with ordinal
'	DDD DDDD	1..365				Day of year
'	X			1410715640.579		Unix timestamp
'	x			1410715640579		Unix ms timestamp
'
'	gggg		2014				Locale 4 digit week year
'	gg			14					Locale 2 digit week year
'	w ww		1..53				Locale week of year
'	e			1..7				Locale day of week
'	ddd dddd	Mon...Sunday		Day Name in locale set by moment.locale()
'	GGGG		2014				ISO 4 digit week year
'	GG			14					ISO 2 digit week year
'	W WW		1..53				ISO week of year
'	E			1..7				ISO day of week
'
'	H HH		0..23				24 hour time
'	h hh		1..12				12 hour time used with a A.
'	a A			am pm				Post Or ante meridiem
'	m mm		0..59				Minutes
'	s ss		0..59				Seconds
'	S SS SSS	0..999				Fractional seconds
'	Z ZZ		+12:00				Offset from UTC As +-HH:mm, +-HHmm, Or Z
	
	' uses moment format notations
	Dim mydate3 As ABMDateTimePicker
	Dim NewDate As Long = DateTime.Now
	mydate3.Initialize(page, "1", ABM.DATETIMEPICKER_TYPE_DATETIME, NewDate, "Pick a date and time", "")
	mydate3.CancelText = "Back"
	mydate3.PickText = "OK"
	mydate3.TodayText = "Today"
	mydate3.Language = "en"
	mydate3.ReturnDateFormat = "MM/DD/YYYY"   ' <--- see demo source code for settings
	mydate3.ReturnTimeFormat = "HH:mm"        ' <--- see demo source code for settings
	mydate3.FirstDayOfWeek = 1
	'mydate3.ClickThrough = True  <--- set to true if, when the user makes a selection, the ok action should be triggered.
	page.CellR(1,1).AddArrayComponent(mydate3, "arrdate") '	<--- showing adding as an array

		
	' code block
	Dim code1 As String = $"Dim mydate3 As ABMDateTimePicker
Dim NewDate As Long = DateTime.Now
mydate3.Initialize(page, "mydate3", ABM.DATETIMEPICKER_TYPE_DATETIME, NewDate, "Pick a date and time", "")
mydate3.CancelText = "Back"
mydate3.PickText = "OK"
mydate3.TodayText = "Today"
mydate3.Language = "en"
mydate3.ReturnDateFormat = "MM/DD/YYYY"   // <--- see demo source code for settings
mydate3.ReturnTimeFormat = "HH:mm"        // <--- see demo source code for settings
mydate3.FirstDayOfWeek = 0
//mydate3.ClickThrough = True  <--- set to true if, when the user makes a selection, the ok action should be triggered.
page.CellR(1,1).AddComponent(mydate3)	"$
	
	page.CellR(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code1))
	
	' add paragraph	
	page.CellR(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","When changed, an event will be raised: YourComp_Changed(dataMilliseconds as String).  The param is a string but can easily be converted to a long and a date.") )	
	
		' code block
	Dim code2 As String = $"Sub mydate3_Changed(Target As String, dateMilliseconds As String)
	// convert to a B4J date
	Dim BackDate As Long = dateMilliseconds
	DateTime.DateFormat = "MM/dd/yyyy"
	DateTime.TimeFormat = "HH:mm"
	
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastred", "Date/time: " & DateTime.Date(BackDate) & " " & DateTime.Time(BackDate), 5000)
End Sub"$

	page.CellR(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code2))
	
	' add paragraph	
	page.CellR(1,1).AddComponent(ABMShared.BuildParagraph(page,"par3","You can also set or get the components date/time using SetDate(date as long) and GetDate() as long methods.") )	
	
	'Dim tmpbtn As ABMButton
	'tmpbtn.InitializeRaised(page, "tmpbtn", "", "", "test", "")
	'page.CellR(1,1).AddComponent(tmpbtn)
	
		
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
'	DateTime.DateFormat= "MM/dd/yyyy"
'	DateTime.TimeFormat = "HH:mm"
'	NewDate = DateTime.DateTimeParse("04/15/2016", "23:59")
'	mydate3.SetDate(NewDate)
'	mydate3.Refresh
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	Page.RestoreNavigationBarPosition
End Sub

Sub arrDate_Changed(Target As String, dateMilliseconds As String)
	Dim mydate3 As ABMDateTimePicker = page.Component(Target)
	Log(mydate3.GetDate & "<->" & dateMilliseconds)
	' convert to a B4J date
	Dim BackDate As Long = dateMilliseconds
	DateTime.DateFormat = "MM/dd/yyyy"
	DateTime.TimeFormat = "HH:mm"
	
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastred", "Date/time: " & DateTime.Date(BackDate) & " " & DateTime.Time(BackDate), 5000)
End Sub

Sub arrDate_ChangedWeek(Target As String, WeekString As String)
	Log(WeekString)
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMDateTimePicker" Then Return
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
