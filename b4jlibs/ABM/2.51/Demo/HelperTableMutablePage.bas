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
	Public Name As String = "HelperTableMutablePage"
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
	page.PageTitle = "ABMTableMutable"
	page.PageDescription = "The mutable table helper"	
	page.PageHTMLName = "abmaterial-table-mutable.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
	
	ABMShared.BuildNavigationBar(page, "ABMTableMutable","../images/logo.png", "", "Helpers", "ABMTableMutable")
	
	' create the page grid
	page.AddRows(4,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","ABMTableMutable is an alternative for the ABMTable (it is 90% compatible).  As requested a couple of times, it can do stuff like InsertRowBefore() and RemoveRow().  All methods have to use UniqueId As String everywhere instead of row As integer:"))	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","{B}Note:{/B} ABMTableMutable can {B}NOT{/B} be scrollable!  It is not possible to have both."))	
	
	Dim code1 As String = $"UseCellTheme(UniqueId as String, Column as Integer, ThemeName as String)
GetCellTheme(UniqueId as String, Column as Integer) as String
SetCellTag(UniqueId as String, Column as Integer, Tag as Object)
GetCellTag(UniqueId as String, Column as Integer) as Object
GetComponent(UniqueId as String, String componentId) as ABMComponent
SetString(UniqueId as String, Column as Integer, Value as String)
GetString(UniqueId as String, Column as Integer) as String"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code1))	
	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par3","ABMTableCell as used in event Table_Clicked(PassedRowsAndColumns As List) has a also a row 'Uniqueid'."))	
	page.Cell(3,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Example usage:"))	
	
	Dim code2 As String = $"// create the TableItemProduced1 table
Dim TableItemProduced1 As ABMTableMutable
	
TableItemProduced1.Initialize(page, "TableItemProduced1", False, False, True, "tbltheme") 

TableItemProduced1.SetHeaders(         Array As String ("regID","Date","Person","Client"       ,"Article"  ,"Number"   ,"Edit"     ,"Delete"))
TableItemProduced1.SetHeaderThemes(    Array As String (""     ,""    ,""      ,""             ,""         ,""         ,"hc"       ,"hc"    ))
TableItemProduced1.SetHeaderHeights(   Array As int    (0      ,0     ,0       ,0              ,0          ,0          ,0          ,0       ))
TableItemProduced1.SetColumnWidths(    Array As int   (0      ,0     ,0       ,0              ,0          ,0          ,70         ,70      ))
TableItemProduced1.SetColumnVisible(   Array As Boolean(False  ,True  ,True    ,True           ,True       ,True       ,True       ,True    ))
TableItemProduced1.SetColumnSortable(  Array As Boolean(False  ,False ,False   ,False          ,False      ,False      ,False      ,False   ))
TableItemProduced1.SetColumnDataFields(Array As String (""     ,""    ,""      ,""             ,""         ,""         ,""         ,""      ))
TableItemProduced1.SetFooter("Number added: 0", 12,"")
TableItemProduced1.Visibility = ABM.VISIBILITY_HIDE_ALL
	
page.CellR(2,1).AddComponent(TableItemProduced1)"$
	
	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code2", code2))	
	
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
	If Action = "ABMTableMutable" Then Return
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

