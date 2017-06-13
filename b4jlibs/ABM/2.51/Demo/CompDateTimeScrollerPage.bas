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
	Public Name As String = "CompDateTimeScrollerPage"
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
	page.PageTitle = "ABMDateTimeScroller"
	page.PageDescription = "The date/time scroller component "	
	page.PageHTMLName = "abmaterial-date-time-scroller.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMDateTimeScroller", "../images/logo.png", "", "Controls", "ABMDateTimeScroller")
		
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
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par1","The date time scroller component is an alternative way to input a date, a time or both using the DATETIMESCROLLER_TYPE_TIME, DATETIMESCROLLER_TYPE_DATE and DATETIMESCROLLER_TYPE_DATETIME constants.") )	
	
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par2","Setting the dtsMode param to one of the constants DATETIMESCROLLER_MODE_SCROLLER, DATETIMESCROLLER_MODE_CLICKPICK and DATETIMESCROLLER_MODE_MIXED, you can modify the look and feel even further.") )	
	
	
'	 DateFormat:
'	 -----------	
'    m - month of year (no leading zero)
'    mm - month of year (two digit)
'    M - month Name short
'    MM - month Name long
'    d - day of month (no leading zero)
'    dd - day of month (two digit)
'    D - day of week (short)
'    DD - day of week (long)
'    y - year (two digit)
'    yy - year (four digit)
'    '...' - literal text
'    '' - single quote
'    anything Else - literal text

'	 TimeFormat:
'	 -----------	
'    h - 12 hour format (no leading zero)
'    hh - 12 hour format (leading zero)
'    H - 24 hour format (no leading zero)
'    HH - 24 hour format (leading zero)
'    i - minutes (no leading zero)
'    ii - minutes (leading zero)
'    s - seconds (no leading zero)
'    ss - seconds (leading zero)
'    a - lowercase am/pm
'    A - uppercase AM/PM
'    '...' - literal text
'    '' - single quote
'    anything Else - literal text
	
	Dim mydate As ABMDateTimeScroller
	Dim NewDate As Long = DateTime.Now
	mydate.Initialize(page, "mydate", ABM.DATETIMESCROLLER_TYPE_DATETIME, ABM.DATETIMESCROLLER_MODE_MIXED, NewDate, "Pick a date and a time", "")
	mydate.DateDayNames = "['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']"
	mydate.DateMonthNamesShort = "['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']"
	mydate.TitleDateFormat = "DDD"
	mydate.ReturnDateFormat = "mm/dd/yy" ' <--- see demo source code for settings
	mydate.TitleTimeFormat = ""          ' <--- see demo source code for settings
	mydate.ReturnTimeFormat = "HH:ii"    ' <--- see demo source code for settings  
	mydate.DateOrder = "Mddyy"           ' <--- see demo source code for settings
	mydate.TimeShowAMPM = False
	mydate.CancelText = "Close"
	mydate.PickText = "OK"	
	page.CellR(1,1).AddComponent(mydate)	
	
		
	' code block
	Dim code1 As String = $"Dim mydate As ABMDateTimeScroller
Dim NewDate As Long = DateTime.Now
mydate.Initialize(page, "mydate", ABM.DATETIMESCROLLER_TYPE_DATETIME, ABM.DATETIMESCROLLER_MODE_MIXED, NewDate, "Pick a date and a time", "")
mydate.DateDayNames = "['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']"
mydate.DateMonthNamesShort = "['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']"
mydate.TitleDateFormat = "DDD"
mydate.ReturnDateFormat = "mm/dd/yy" // <--- see demo source code for settings
mydate.TitleTimeFormat = ""          // <--- see demo source code for settings
mydate.ReturnTimeFormat = "HH:ii"    // <--- see demo source code for settings  
mydate.DateOrder = "Mddyy"           // <--- see demo source code for settings
mydate.TimeShowAMPM = False
mydate.CancelText = "Close"
mydate.PickText = "OK"
page.CellR(1,1).AddComponent(mydate)	"$
	
	page.CellR(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code1))
	
	' add paragraph	
	page.CellR(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","When changed, an event will be raised: YourComp_Changed(dataMilliseconds as String).  The param is a string but can easily be converted to a long and a date.") )	
	
		' code block
	Dim code2 As String = $"Sub mydate_Changed(dateMilliseconds As String)
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
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub mydate_Changed(dateMilliseconds As String)
	Dim mydate As ABMDateTimeScroller = page.Component("mydate")
	Log(mydate.GetDate & "<->" & dateMilliseconds)
	' convert to a B4J date
	Dim BackDate As Long = dateMilliseconds
	DateTime.DateFormat = "MM/dd/yyyy"
	DateTime.TimeFormat = "HH:mm"
	
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastred", "Date/time: " & DateTime.Date(BackDate) & " " & DateTime.Time(BackDate), 5000)
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMDateTimeScroller" Then Return
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
