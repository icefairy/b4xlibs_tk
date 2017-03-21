Hi all!

Here is the new version 1.03 of ABMaterial

NOTE:
----- 
Take a backup of your existing version.  This zip contains the library files AND the new javascript/css files.
1. Copy the library files to your b4j library folder
2. Copy the www folder to your project www folder and overwrite the files

NEW in 1.03:
------------
[FIX]: combo refresh now working
--------------------------------------------------------------------------------------------------------------------------------
Refresh happened on the wrong id so nothing did happen :-)

[NEW]: Input controls can use input masks
-----------------------------------------
I've noticed it's best to use them on ABM.INPUT_TEXT types:

e.g.

	' add a date 
	Dim inp10 As ABMInput
	inp10.Initialize(page, "inp10", ABM.INPUT_TEXT, "With date mask", False, "")	
	' check out http://robinherbots.github.io/jquery.inputmask/ for more info how to build your masks
	inp10.inputMask = "'mask': 'd/m/y'"
	page.Cell(16,1).AddComponent(inp10)

[NEW]: ABMCalendar control.  This is a basic calendar control where you can show and edit events.  Day, Week and Month view.
--------------------------------------------------------------------------------------------------------------------------------

It uses an event called _FetchData(dateStart As String, dateEnd As String) to get the data from your server.
It's rather smart so it can give a bigger range than expected but this is because there would be less traffic.

example use (from the demo): (IMPORTANT, you have to set a color for an event.  If not, it is transparent ergo not visible!)

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

A couple of events can happen on the calendar control. These events are raised when the user 'moves' the event, or changes the duration (changing the height of the event).

Sub calendar1_EventClicked(eventId As String)
	Log("clicked on event: " & eventId)
End Sub

' has more than 2 params (case sensitive!):
' params.get("eventid")
' params.get("newstart")
' params.get("newend")
' params.get("allday")
Sub calendar1_EventStartChanged(params As Map)
	Log("Start changed of event: " & params.Get("eventid") & " newStart: " & params.Get("newstart") & " newEnd: " & params.Get("newend") & " AllDay: " & params.Get("allday"))
	'Dim cal1 As ABMCalendar = page.Component("calendar1")
	Dim ev As ABEAppointment
	...
	
End Sub

Sub calendar1_EventEndChanged(eventId As String, NewEnd As String)
	Log("End changed of event: " & eventId & " newEnd: " & NewEnd)
	Dim ev As ABEAppointment
	...
End Sub

' handy method to 'lock' the calendar from editing
Sub switch1_Clicked()
	Dim switch1 As ABMSwitch = page.Component("switch1")
	Dim cal1 As ABMCalendar = page.Component("calendar1")
	cal1.ChangeEventsEditable(switch1.State)	
	cal1.Refresh	
End Sub

[NEW]: ABMSocialOAuth control. Let users login to your app using their social accounts.  As this is out of the scope of ABMaterial (and frankly I'm not that familiar with it either), I suggest you share your experiences/questions and setups on the forum.
--------------------------------------------------------------------------------------------------------------------------------

Setup:

	' via social network
	Dim sOAuth As ABMSocialOAuth
	sOAuth.Initialize(AppPage, "sOAuth")
	sOAuth.AddFacebookButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Facebook")
	sOAuth.AddTwitterButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Twitter")
	sOAuth.AddGooglePlusButton("YOURKEY", "Sign on with Google Plus")
	sOAuth.AddLinkedInButton("YOURKEY", "Sign on with LinkedIn")
	sOAuth.AddWindowsLiveButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Windows Live")
	sOAuth.AddFourSquareButton("YOURDOMAIN.COM","YOURKEY", "Sign on with FourSquare")
	sOAuth.AddInstagramButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Instagram")
	sOAuth.AddSoundCloudButton("YOURDOMAIN.COM","YOURKEY", "Sign on with SoundCloud")
	sOAuth.AddYahooButton("YOURDOMAIN.COM","YOURKEY", "Sign on with Yahoo")
	
	myModal.Content.Cell(3,1).AddComponent(sOAuth)

Look into the demo example how to login/logoff.

e.g. my logoff method:

Sub LogOff(page As ABMPage, appName As String)
	Dim Network As String = page.ws.Session.GetAttribute("authType")
	Dim Name As String = page.ws.Session.GetAttribute("authName")
	Select Case Network
		Case "local"
			' do whatever you have to do to log off your user
			page.ws.Session.SetAttribute("authType", "")
			page.ws.Session.SetAttribute("authName", "")
			page.ws.Session.SetAttribute("IsAuthorized", "")	
			NavigateToPage(page.ws, "../")
		Case ABM.SOCIALOAUTH_FACEBOOK
			' the event SignedOffSocialNetwork will be raised on the page, do the rest there
			page.SignOffSocialNetwork(Network, "", Name)						
	End Select	
End Sub

ABMaterial has some helper methods to keep the user logged in if you are not using social logins (this is not needed for social logins as it happens automatically:

1. 
ABM.SaveLogin(AppPage, AppName, login, password) <-------- saves the login info into the browsers HTML5 storage

2.
Dim loginpwd As String = ABM.LoadLogin(AppPage, AppName) <------- loads the login info from the browsers HTML5 storage
If loginpwd <> "" Then
	Dim split() As String = Regex.Split(";", loginpwd)
	dim login as string = split(0)
	dim pwd as string = split(1)
	' check the login and password 
end if

3.
ABM.DeleteLogin(page, appName) ' <--- This deletes this login from the browsers HTML5 storage

[NEW]: ABMTable can hide columns using the SetColumnVisible() method.
--------------------------------------------------------------------------------------------------------------------------------
Make sure you add as many 'boolean' values as there are columns!

[NEW]: ABMTable themes (body string elements only for the moment) have a property Editable.  When true, the user can edit the text in the cells.  
--------------------------------------------------------------------------------------------------------------------------------
NOTE: this is rather experimental, as I'm not really sure which browsers to support this!

e.g.

theme.Table("tbl1theme").AddCellTheme("cellleftedit")
theme.Table("tbl1theme").Cell("cellleftedit").Align = ABM.TABLECELL_HORIZONTALALIGN_LEFT
theme.Table("tbl1theme").Cell("cellleftedit").IsEditable = True

NOTE: when using 'editable, you should avoid using the IsIntractive property in Initialize. It may work, but is untested.

You can retrieve the new values in two ways:

1. The user clicks a button and you get the values back. Important is you call PrepareTableForRetrieval BEFORE trying use GetString().  This is because ABMaterial uses Futures so the traffic between the browser and Server is minimal.

Sub btn1_Clicked(Target As String)
	Dim tbl As ABMTable = page.Component("tbl")
	tbl.PrepareTableForRetrieval
	Log(tbl.GetString(1,1))
	Log(tbl.GetString(2,1))
	Log(tbl.GetString(3,1))
	
	Dim total1 As Int = tbl.GetString(1,1) * 1290
	tbl.SetString(1,2, "" & total1)
	tbl.Refresh
End Sub

2. When a user changes a value, an event is raised called yourtablename_Changes().  This can be useful e.g. if you have to do a calculation with the entered value and update the table.
You'll notice we do have to set the 'changed' value ourself in this case.  (Refresh would still use the old value).

' 3 params (case sensitive!)
' row
' column
' value
Sub tbl_Changed(Params As Map)
	Dim row As Int = Params.Get("row")
	Dim column As Int = Params.Get("column")
		
	Dim tbl As ABMTable = page.Component("tbl")
	
	If row = 1 And column = 1 Then
		Dim value As Int = Params.Get("value")
		Dim total1 As Int = value * 1290
		' you have to set the new value yourself!
		tbl.SetString(1,1,value)
		tbl.SetString(1,2, "" & total1)
		tbl.Refresh
	End If
End Sub

[NEW] ABM has some new header properties that can be useful for e.g. icons: note all these files must be in the /images folder!
--------------------------------------------------------------------------------------------------------------------------------

ABM.Manifest = "manifest.json"
ABM.MaskIcon = "safari-pinned-tab.svg"
ABM.MaskIconColor = ABM.COLOR_ORANGE
ABM.MaskIconColorIntensity = ABM.INTENSITY_LIGHTEN1
ABM.MSTileColor = ABM.COLOR_ORANGE
ABM.MSTileColorIntensity = ABM.INTENSITY_LIGHTEN1
ABM.AndroidChromeThemeColor = ABM.COLOR_ORANGE
ABM.AndroidChromeThemeColorIntensity = ABM.INTENSITY_LIGHTEN1
ABM.BrowserConfig = "browserconfig.xml"

Some pages to generate icons and these files are:
http://realfavicongenerator.net/
http://iconifier.net/

If you know more (or better) ones, please share!

Happy programming!

Alain
Alwaysbusy's Corner



