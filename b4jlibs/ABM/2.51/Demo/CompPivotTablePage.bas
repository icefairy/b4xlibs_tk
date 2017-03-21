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
	Public Name As String = "CompPivotTablePage"
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
	theme.AddPivotTable("pivot")
	theme.PivotTable("pivot").BackColor = ABM.COLOR_WHITE
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMPivotTable"
	page.PageDescription = "The Pivot table component "	
	page.PageHTMLName = "abmaterial-pivottable.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMPivotTable", "../images/logo.png", "", "Controls", "ABMPivotTable")
		
	' create the page grid
	page.AddRows(8,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","In data processing, a pivot table is a data summarization tool found in data visualization programs such as spreadsheets or business intelligence software. ABMPivotTable is such a component where the user can drag/drop data elements to generate their own overview for analysis."))	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","You have to provide it with a .csv file and which data elements the user can use. {B}NOTE:{/B} As all this data has to be send over and processed in the users browser, you better 'pre-filter' the data you send in the .csv file!"))	
	
	Dim pivot As ABMPivotTable
	pivot.Initialize(page, "pivot", 500, "../pivots/Pivot.csv", "Person code,Person name", "Project code,Project name", "Decimal,Price",False, "pivot")
	pivot.UsesSubTotals = True
	pivot.UsesGoogleCharts = True
	'pivot.ForcedLanguage = "es"
	page.Cell(2,1).AddComponent(pivot)
	
	Dim exportBtn As ABMButton
	exportBtn.InitializeFlat(page, "exportBtn", "", "", "Export", "")
	page.Cell(3,1).AddComponent(exportBtn)
	
	Dim code1 As String = $"Dim pivot As ABMPivotTable
pivot.Initialize(page, "pivot", 500, "../pivots/Pivot.csv", "Person code,Person name", "Project code,Project name", "Decimal,Price", "pivot")
page.Cell(2,1).AddComponent(pivot)"$

	page.Cell(4,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code1))	
	
	page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par3","Make sure the field names used in the axes and hidden field params are the same!  Here is a snippit of how the CSV in the above Pivot table looks like."))	
	
	Dim code2 As String = $"Person code,Person name,Project code,Project name,Activity code,Activity name,Decimal,Price,Year,Month
Piet,Piet Van Dender,VDP,VDP INTERIEUR BVBA,Z Opkuisen atelier,Z Opkuisen atelier,3.6,0,2096,8
Piet,Piet Van Dender,VDP,VDP INTERIEUR BVBA,Z Opkuisen atelier,Z Opkuisen atelier,3.78,0,2096,8
Piet,Piet Van Dender,150090b Van Gasse,150090b Van Gasse,Maatwerk PLAATSEN,Maatwerk PLAATSEN,3.25,126.75,2096,8
Piet,Piet Van Dender,150090b Van Gasse,150090b Van Gasse,Maatwerk PLAATSEN,Maatwerk PLAATSEN,3.15,122.85,2096,8
Piet,Piet Van Dender,,,X Extra werk allerlei,X Extra werk allerlei,0.92,35.75,2096,8
Piet,Piet Van Dender,150104 Bogaert,150104 Bogaert,X Extra werk allerlei,X Extra werk allerlei,1.02,39.65,2096,8
Piet,Piet Van Dender,VDP,VDP INTERIEUR BVBA,Administratie,Administratie,1.37,0,2096,8
Piet,Piet Van Dender,140040b KNOP,140040b KNOP,Maatwerk MAKEN,Maatwerk MAKEN,0.53,20.8,2096,8
Piet,Piet Van Dender,VDP,VDP INTERIEUR BVBA,Z Opkuisen atelier,Z Opkuisen atelier,18.82,0,2096,8
Piet,Piet Van Dender,150040 Knop ,150040 Knop ,Maatwerk PLAATSEN,Maatwerk PLAATSEN,2.7,105.3,2096,8
Piet,Piet Van Dender,150104 Bogaert,150104 Bogaert,X Extra werk allerlei,X Extra werk allerlei,0.97,37.7,2096,8
Piet,Piet Van Dender,150040 Knop ,150040 Knop ,Maatwerk PLAATSEN,Maatwerk PLAATSEN,3.97,154.7,2096,8
Piet,Piet Van Dender,150040 Knop ,150040 Knop ,Maatwerk PLAATSEN,Maatwerk PLAATSEN,4.15,161.85,2096,8
Piet,Piet Van Dender,150040 Knop ,150040 Knop ,Maatwerk PLAATSEN,Maatwerk PLAATSEN,3.97,154.7,2096,8
Piet,Piet Van Dender,VDP,VDP INTERIEUR BVBA,Administratie,Administratie,0.65,0,2096,8
..."$
	
	page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code2))	
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub exportbtn_Clicked(Target As String)
	Dim pivot As ABMPivotTable = page.Component("pivot")
	pivot.ExportToXLS("alainTest", ".",",",".","")
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMPivotTable" Then Return
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
