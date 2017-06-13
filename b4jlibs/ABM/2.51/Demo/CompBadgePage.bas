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
	Public Name As String = "CompBadgePage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
	Dim NewMsg As Int
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
	page.PageTitle = "ABMBadge"
	page.PageDescription = "The badge component "	
	page.PageHTMLName = "abmaterial-badge.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMBadge", "../images/logo.png", "", "Controls", "ABMBadge")
		
	' create the page grid
	page.AddRows(9,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True
		
	ABMShared.BuildFooter(page)
End Sub

public Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Badges can notify you that there are new or unread messages or notifications.") )
	
	' create list
	Dim list1 As ABMList
	list1.Initialize(page, "list1", ABM.COLLAPSE_ACCORDION, "")
	
	' add items	
	list1.AddItem("S1", BuildItem("S1", "Mom", "2", False))
	list1.AddItem("S2", BuildItem("S2", "Dad", "7", True))
	list1.AddItem("S3", BuildItem("S3", "Brother", "", False))
	list1.AddItem("S4", BuildItem("S4", "Sister", "3", False))
	
	page.Cell(2,1).AddComponent(list1)
	
	' add paragraph	
	page.cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par2","Click on the list item to 'read' the messages.  You'll notice the badge changing from 'new' to 'normal' state. Click on the button below to add 'new' messages to Brother.  You'll notice the badge state changing from 'normal' to 'new'.") )
		
	' add buttons
	Dim btn1 As ABMButton
	btn1.InitializeRaised(page, "btn1", "", "", "Add message to brother", "bluegrey")
	page.Cell(4,1).AddComponent(btn1)
	
	' add codeblock	
	Dim code1 As StringBuilder
	code1.Initialize	
	code1.Append("// create list").Append(CRLF)
	code1.Append("Dim list1 As ABMList").Append(CRLF)
	code1.Append("list1.Initialize(page, ""list1"", ABM.COLLAPSE_ACCORDION, """")").Append(CRLF)
	code1.Append("").Append(CRLF)
	code1.Append("// add items").Append(CRLF)
	code1.Append("list1.AddItem(""S1"", BuildItem(""S1"", ""Mom"", ""2"", False))").Append(CRLF)
	code1.Append("list1.AddItem(""S2"", BuildItem(""S2"", ""Dad"", ""7"", True))").Append(CRLF)
	code1.Append("list1.AddItem(""S3"", BuildItem(""S3"", ""Brother"", """", False))").Append(CRLF)
	code1.Append("list1.AddItem(""S4"", BuildItem(""S4"", ""Sister"", ""3"", False))").Append(CRLF)
	
	page.Cell(5,1).AddComponent(ABMShared.BuildCodeBlock(page, "code1", code1))
	
	' add codeblock	
	Dim code2 As StringBuilder
	code2.Initialize	
	code2.Append("Sub BuildItem(id As String, text As String, messages As String, isnew As Boolean) As ABMContainer").Append(CRLF)
	code2.Append("   Dim ItemCont As ABMContainer").Append(CRLF)
	code2.Append("   ItemCont.Initialize(page, id, "")	").Append(CRLF)
	code2.Append("   ItemCont.AddRowsM(1,False,0,0, "").AddCellsOSMP(1,0,0,0,10,10,10,6,0,0,0,"").AddCellsOSMP(1,0,0,0,2,2,2,6,0,0,0,"")").Append(CRLF)
	code2.Append("   ItemCont.BuildGrid //IMPORTANT once you loaded the complete grid AND before you start adding components").Append(CRLF)
	code2.Append("").Append(CRLF)
	code2.Append("   Dim lbl As ABMLabel").Append(CRLF)
	code2.Append("   lbl.Initialize(page, id & ""lbl"", text, ABM.SIZE_PARAGRAPH, False, """")").Append(CRLF)
	code2.Append("   ItemCont.Cell(1,1).AddComponent(lbl)").Append(CRLF)
	code2.Append("").Append(CRLF)
	code2.Append("   Dim badge As ABMBadge").Append(CRLF)
	code2.Append("   badge.Initialize(page, id & ""badge"", messages, isnew, """")").Append(CRLF)
	code2.Append("   ItemCont.Cell(1,2).AddComponent(badge)").Append(CRLF)
	code2.Append("").Append(CRLF)
	code2.Append("   Return ItemCont").Append(CRLF)
	code2.Append("End Sub").Append(CRLF)

	page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlock(page, "code2", code2))
	
	' add paragraph	
	page.cell(7,1).AddComponent(ABMShared.BuildParagraph(page,"par3","The events when someone clicks on the list item to 'read' the messages and the button code to add a new message to brother.") )
	
	' add codeblock	
	Dim code3 As StringBuilder
	code3.Initialize	
	code3.Append("Sub list1_Clicked(ItemId As String)").Append(CRLF)
	code3.Append("   // get the list component from the page").Append(CRLF)
	code3.Append("   Dim list1 As ABMList = page.Component(""List1"")").Append(CRLF)
	code3.Append("   // get the item").Append(CRLF)
	code3.Append("   Dim cont As ABMContainer = list1.Item(ItemId)").Append(CRLF)
	code3.Append("   // get the badge control").Append(CRLF)
	code3.Append("   Dim badge As ABMBadge = cont.Component(ItemId & ""Badge"")").Append(CRLF)
	code3.Append("   badge.IsNew = False	").Append(CRLF)
	code3.Append("").Append(CRLF)
	code3.Append("   badge.Refresh ' IMPORTANT").Append(CRLF)
	code3.Append("End Sub").Append(CRLF)
	
	page.Cell(8,1).AddComponent(ABMShared.BuildCodeBlock(page, "code3", code3))
	
	' add codeblock	
	Dim code4 As StringBuilder
	code4.Initialize	
	code4.Append("Sub btn1_Clicked(Target As String)").Append(CRLF)
	code4.Append("   // get the list component from the page").Append(CRLF)
	code4.Append("   Dim list1 As ABMList = page.Component(""List1"")").Append(CRLF)
	code4.Append("   // get the third item (brother)").Append(CRLF)
	code4.Append("   Dim cont As ABMContainer = list1.Item(""S3"")").Append(CRLF)
	code4.Append("   // get the badge control").Append(CRLF)
	code4.Append("   Dim badge As ABMBadge = cont.Component(""S3Badge"")").Append(CRLF)
	code4.Append("   badge.IsNew = True").Append(CRLF)
	code4.Append("   NewMsg = NewMsg + 1").Append(CRLF)
	code4.Append("   badge.Text = NewMsg").Append(CRLF)
	code4.Append("   badge.Refresh ' IMPORTANT").Append(CRLF)
    code4.Append("End Sub").Append(CRLF)
	
	page.Cell(9,1).AddComponent(ABMShared.BuildCodeBlock(page, "code4", code4))
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub BuildItem(id As String, text As String, messages As String, isnew As Boolean) As ABMContainer
	Dim ItemCont As ABMContainer
	ItemCont.Initialize(page, id, "")	
	ItemCont.AddRowsM(1,False,0,0, "").AddCellsOSMP(1,0,0,0,10,10,10,6,0,0,0,"").AddCellsOSMP(1,0,0,0,2,2,2,6,0,0,0,"")
	ItemCont.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	Dim lbl As ABMLabel
	lbl.Initialize(page, id & "lbl", text, ABM.SIZE_PARAGRAPH, False, "")
	ItemCont.Cell(1,1).AddComponent(lbl)
	
	Dim badge As ABMBadge
	badge.Initialize(page, id & "badge", messages, isnew, "")
	ItemCont.Cell(1,2).AddComponent(badge)
	
	Return ItemCont
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition
	If Action = "ABMBadge" Then Return
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

Sub btn1_Clicked(Target As String)
	' get the list component from the page
	Dim list1 As ABMList = page.Component("List1")
	' get the third item (brother)
	Dim cont As ABMContainer = list1.Item("S3")
	' get the badge control
	Dim badge As ABMBadge = cont.Component("S3Badge")
	badge.IsNew = True
	NewMsg = NewMsg + 1
	badge.Text = NewMsg
	badge.Refresh ' IMPORTANT
End Sub

Sub list1_Clicked(ItemId As String)
	' get the list component from the page
	Dim list1 As ABMList = page.Component("List1")
	' get the item
	Dim cont As ABMContainer = list1.Item(ItemId)
	' get the badge control
	Dim badge As ABMBadge = cont.Component(ItemId & "Badge")
	badge.IsNew = False	
	
	badge.Refresh ' IMPORTANT
End Sub