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
	Public Name As String = "HelperGeneratorPage"
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
	page.PageTitle = "ABMGenerator"
	page.PageDescription = "The genrator helper"	
	page.PageHTMLName = "abmaterial-generator.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
	
	ABMShared.BuildNavigationBar(page, "ABMGenerator","../images/logo.png", "", "Helpers", "ABMGenerator")
	
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
	page.CellR(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","The ABMGenerator helper is a tool to generate B4J code from a simple list of parameters.  Writing only a couple of lines will generate hundreds of lines of B4J code ready to use.") )
	page.CellR(0,1).AddComponent(ABMShared.BuildParagraph(page,"par2","It can currently generate code for CRUD modal sheets and MessageBoxes, but this will be expanded in future versions. The code is generated in the .txt files you specify, so you can then copy and paste it in your project.") )
	
	' add a header label
	page.CellR(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "The methods you can use:"))
	
	Dim Headers, codes, Descriptions As List
	Headers.Initialize2(Array As String("Method", "Description"))
	codes.Initialize2(Array As String("Set01FieldNames", "Set02RowOffsetSizes", "Set03LabelTexts", "Set04ComponentTypes", "Set05DefaultValue", "Set06ComboQueries", "Set07ComboLists", "Set08ValidationMethods", "Set09Enableds", "Set10UseInUpdates"))
	
	Dim desc1 As String = $"Array as String (real names in your database!){BR}
Very important! The order of the visible fields MUST be in the order they need to appear in the ModalSheet:{BR}
{BR}
Per row, Cells from left to right:{BR}
{BR}
e.g. |   field1   |  field2             |{BR}
     |   field3                         |{BR}
     |   field4   |  field5   | field6  |{BR}
     |   field7                         |{BR}
{BR}
Becomes: Array As String(notvisible1, notvisible2, field1, field2, field3, field4, field5, field6, field7)"$
	Dim desc2 As String = $"Array As String, allowed formats:{BR}
R:O:S where R=Row, O=offset, S=size (Row starts from 1, All O+S in one row must add-up To 12!){BR}
R:OS:OM:OL:SS:SM:SL where R=Row, OS=offsetSmall, OM=offsetMedium, OL=offsetLarge, SS=sizeSmall, SM=sizeMedium, SL=sizeLarge{BR}
Empty string if not visible, e.g. an ID field"$
	Dim desc3 As String = $"Array as string, labels on the component.{BR}
Note: in case of a switch the format is:{BR}
"OnText,offText""$
	Dim desc4 As String = $"Array as int, using CRUDTYPE constants"$
	Dim desc5 As String = $"Array as string, default value when the user creates a new record.{BR}
Notes: {BR}
    For Combos this must be the returnId (int, most of the time a database id, eg "123")!{BR}
    For Switches/Checkboxes this must be "true" or "false"{BR}
    For Dates must be a long (e.g. 145671250000), a date in the format you specified (e.g. '22-01-2016T10:20:00') or you can use "NOW""$
	Dim desc6 As String = $"Array of String, combo query in format: SELECT returnId, TextToShowInCombo FROM Table WHERE your_where ORDER BY order {BR}
where can contain variables that are other fields using '$', e.g. a combo that has other values depending on who was selected in the {BR}
person combo.{BR}
 {BR}
You have a combo prsId to pick a person:{BR}
 {BR}
SELECT tPersons.prsID, tPersons.prsName {BR}
    FROM tPersons {BR}
    ORDER BY tPersons.prsName;{BR}
{BR}
You have a combo comId to pick a command and depends on who the person is:{BR}
 {BR}
SELECT tCommands.comId, tCommands.comName {BR}
    FROM tCommands INNER JOIN tCommandsPersons ON tCommand.comId = tCommandPersons.comprsComId {BR}
    WHERE tCommandPersons.comprsPrsId=$prsId$ {BR}
    ORDER BY tCommands.comName{BR}
{BR}    
The value of what is in the prsId combo will be used in the query of the comId combo. "$
	Dim desc7 As String = $"Array of Maps, where key = returnId and value = TextToShowInCombo {BR}
Use Null if not applicable"$
	Dim desc8 As String = $"Array of strings, containing the Method names to validate an input field {BR}
Methods will be autogenerated as:{BR}
{BR}
MethodName(value as String) as Boolean"$
	Dim desc9 As String = $"Array of booleans, containing booleans with enabled or not"$
	Dim desc10 As String = $"Array of booleans, containing booleans if it should overwrite the field when updating a record	{BR} 
Note: the ID field will never be overwritten!"$
	
	Descriptions.Initialize2(Array As String(desc1, desc2, desc3, desc4, desc5, desc6, desc7, desc8, desc9, desc10))
	page.CellR(1,1).AddComponent(ABMShared.BuildParamTable2(page, "param2", Headers, codes, Descriptions))
	
	page.CellR(1,1).AddComponent(ABMShared.BuildParagraph(page,"par3","For example this code will generate all the code you can see in the pdf for a CRUD modal sheet. (Because it uses a DateTimeScroller, you can also define the localization here, e.g. here in Dutch). The yellow text marks the code I needed to change to modify it to the clients specific wishes.") )
	
	Dim code1 As String = $"Dim MyEventDef As ABMGeneratorCRUDDefinition
MyEventDef.Initialize("evID", "tEvent", "Vul alle velden van deze event in.", "Bewaren", "Annuleren", "Ja", "Nee", "Sluiten", "Ben je zeker dat je deze event wilt wissen?", "Gelieve eerst alle velden in te vullen!")
MyEventDef.DateTimeScroller.Mode = ABM.DATETIMESCROLLER_MODE_CLICKPICK
MyEventDef.DateTimeScroller.SQLSaveDateTimeFormat = "yyyy-MM-dd HH:mm:ss"	
MyEventDef.DateTimeScroller.TitleDateFormat = "DD" 
MyEventDef.DateTimeScroller.ReturnDateFormat = "dd/mm/yy" 
MyEventDef.DateTimeScroller.DateOrder = "ddMy" 
MyEventDef.DateTimeScroller.DateMonthNames = "['Januari','Februari','Maart','April','Mei','Juni', 'July','Augustus','September','Oktober','November','December']" 
MyEventDef.DateTimeScroller.DateMonthNamesShort = "['Jan', 'Feb', 'Maa', 'Apr', 'Mai', 'Jun', 'Jul', 'Aug', 'Sep', 'Okt', 'Nov', 'Dec']" 
MyEventDef.DateTimeScroller.DateDayNames = "['Zondag', 'Maandag', 'Dinsdag', 'Woensdag', 'Donderdag', 'Vrijdag', 'Zaterdag']" 
MyEventDef.DateTimeScroller.DateDayNamesShort = "['Zon', 'Maa', 'Din', 'Woe', 'Don', 'Vri', 'Zat']" 
MyEventDef.DateTimeScroller.DateMonthText = "Maand" 
MyEventDef.DateTimeScroller.DateDayText = "Dag" 
MyEventDef.DateTimeScroller.DateYearText = "Jaar" 
MyEventDef.DateTimeScroller.PickText = "Bewaar" 
MyEventDef.DateTimeScroller.CancelText = "Sluiten" 

Dim cmbStatus As String = "SELECT evstatID, evstatOms FROM tEventStatus ORDER BY evstatOms"
Dim cmbType As String = "SELECT tEventType.evtypID, tEventType.evtypOms FROM tEventType INNER JOIN tEventType_Persoon ON tEventType.evtypID = tEventType_Persoon.evtypprsEvtypID WHERE (((tEventType_Persoon.evtypprsPrsID)=1)) ORDER BY tEventType.evtypOms"
Dim cmbTodoBy As String = "SELECT prsID, prsNaam FROM tPersoon ORDER BY prsNaam"
	
MyEventDef.Set01FieldNames(       Array As String ("evID"           , "evCreator"           , "evContact"    , "evDatum"            , "evStatus"       , "evType"        , "evToDoBy"          , "evToDoDatum"      , "evOnderwerp", "evAandacht"   , "evHot"        , "evCommentaar"   , "evAfsluitDatum"    ))
MyEventDef.Set02RowOffsetSizes(   Array As String (""               , ""                    , ""             , ""                   , "1:0:12"         , "2:0:12"        , "3:0:12"            , "4:0:12"           , "5:0:12"     , "6:0:6"        , "6:0:6"        , "7:0:12"         , ""                  ))
MyEventDef.Set03LabelTexts(       Array As String (""               , ""                    , ""             , ""                   , "Status"               , "Actie"         , "Uit te voeren door", "Uitvoer datum"    , "Onderwerp"  , "Aandacht"     , "Hot,"         , "Commentaar"     , ""                  ))
MyEventDef.Set04ComponentTypes(   Array As Int    (ABM.GEN_NONE     , ABM.GEN_NUMBER        , ABM.GEN_NUMBER , ABM.GEN_DATE_SCROLL  , ABM.GEN_COMBOSQL , ABM.GEN_COMBOSQL, ABM.GEN_COMBOSQL    , ABM.GEN_DATE_SCROLL, ABM.GEN_TEXT , ABM.GEN_NUMBER , ABM.GEN_SWITCH , ABM.GEN_TEXTAREA , ABM.GEN_DATE_SCROLL ))
MyEventDef.Set05DefaultValues(    Array As String (""               , "1"                   , "1"            , "NOW"                , "2"              , "1"             , "1"                 , "NOW"              , ""           , "0"            , "false"        , ""               , "NOW"               ))	
MyEventDef.Set06ComboQueries(     Array As String (""               , ""                    , ""             , ""                   , cmbStatus        , cmbType         , cmbTodoBy           , ""                 , ""           , ""             , ""             , ""               , ""                  ))
MyEventDef.Set07ComboLists(       Array As Map    (null             , null                  , null           , null                 , null             , null            , null                , null               , null         , null           , null           , null             , null                ))
MyEventDef.Set08ValidationMethods(Array As String (""               , ""                    , ""             , ""                   , "NotMin1"        , "NotMin1"       , "NotMin1"           , ""                 , "NotEmpty"   , ""             , ""             , "NotEmpty"       , ""                  ))
MyEventDef.Set09Enableds(         Array As Boolean(False            , False                 , False          , False                , True             , True            , True                , True               , True         , True           , True           , True             , False               ))
MyEventDef.Set10UseInUpdates(     Array As Boolean(False            , False                 , False          , False                , True             , True            , True                , True               , True         , True           , True           , True             , False               ))
Generator.GenerateCRUDSheet(File.DirApp, "EventNotes", MyEventDef, ABM.MODALSHEET_SIZE_FULL)	"$

	page.CellR(0,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code1))

	page.CellR(1,1).AddComponent(ABMShared.BuildParagraph(page,"par4","The generated code: {AL}http://gorgeousapps.com/Generator.pdf{AT}Generated code{/AL}"))
	
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
	If Action = "ABMGenerator" Then Return
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

