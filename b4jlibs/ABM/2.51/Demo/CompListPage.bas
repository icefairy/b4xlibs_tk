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
	Public Name As String = "CompListPage"
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
	theme.AddListTheme("list1theme")
	theme.List("list1theme").ItemBackColor = ABM.COLOR_BLUEGREY
	theme.List("list1theme").SubItemBackColor = ABM.COLOR_WHITE	
	theme.List("list1theme").BackColor = ABM.COLOR_WHITE	
	
	theme.AddListTheme("list3theme")
	theme.List("list3theme").ItemBackColor = ABM.COLOR_LIME
	theme.List("list3theme").SubItemBackColor = ABM.COLOR_WHITE	
	theme.List("list3theme").SubItemDividerColor = ABM.COLOR_WHITE	
	theme.List("list3theme").BackColor = ABM.COLOR_WHITE	
	
	theme.AddLabelTheme("header")
	theme.Label("header").ForeColor = ABM.COLOR_BLACK
	
	theme.AddCardTheme("whitetitle")
	theme.Card("whitetitle").TitleForeColor = ABM.COLOR_WHITE
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMList"
	page.PageDescription = "The list component "	
	page.PageHTMLName = "abmaterial-list.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMList", "../images/logo.png", "", "Controls", "ABMList")	
	
	' create the page grid
	page.AddRows(8,True, "").AddCells12(1,"")	
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,6,6,"")	
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
		
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Lists allow you to group list objects together. The items are collapsibles that expand when clicked on. They allow you to hide content that is not immediately relevant to the user.") )
	
	' add a header label
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "In Page Lists"))
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","In Page Lists are lists that grow inside your page.  They do not have a seperate scrollbar.") )
	
	' create list
	Dim list1 As ABMList
	list1.Initialize(page, "list1", ABM.COLLAPSE_ACCORDION, "list1theme")
	
	' add items
	list1.AddItem("H1", BuildSimpleItem("L1H1","mdi-action-account-circle","Family"))
	list1.AddSubItem("H1", "S1", BuildSimpleItem("L1H1S1","", "Mom"))
	list1.AddSubItem("H1", "S2", BuildSimpleItem("L1H1S2","", "Dad"))
	list1.AddSubItem("H1", "S3", BuildSimpleItem("L1H1S3","", "Brother"))
	list1.AddSubItem("H1", "S4", BuildSimpleItem("L1H1S4","", "Sister"))
	list1.AddItem("H2", BuildSimpleItem("L1H2","mdi-action-dashboard","Colleagues"))
	list1.AddSubItem("H2", "S5", BuildSimpleItem("L1H2S5","", "Boss"))
	list1.AddSubItem("H2", "S6", BuildSimpleItem("L1H2S6","", "Secretary"))
	list1.AddItem("H3", BuildSimpleItem("L1H3","mdi-editor-border-all","Friends"))
	list1.AddSubItem("H3", "S7", BuildSimpleItem("L1H3S7","", "Jean"))
	list1.AddSubItem("H3", "S8", BuildSimpleItem("L1H3S8","", "Walter"))
	list1.AddSubItem("H3", "S9", BuildSimpleItem("L1H3S9","", "Betty"))
	list1.AddSubItem("H3", "S10", BuildSimpleItem("L1H3S10","", "Thomas"))
	list1.AddSubItem("H3", "S11", BuildSimpleItem("L1H3S11","", "Jones"))
	list1.AddSubItem("H3", "S12", BuildSimpleItem("L1H3S12","", "Steven"))
	list1.AddSubItem("H3", "S13", BuildSimpleItem("L1H3S13","", "Andrea"))
	list1.AddSubItem("H3", "S14", BuildSimpleItem("L1H3S14","", "Julie"))
	list1.AddItem("H4", BuildSimpleItem("L1H4","mdi-editor-border-all","Others"))
	
	page.Cell(2,1).AddComponent(list1)
	
	' code block
	Dim code1 As StringBuilder
	code1.Initialize
	
	code1.Append("' create list").Append(CRLF)
	code1.Append("Dim list1 As ABMList").Append(CRLF)
	code1.Append("list1.Initialize(page, ""list1"", ABM.COLLAPSE_ACCORDION, ""list1theme"")").Append(CRLF)
	code1.Append("").Append(CRLF)
	code1.Append("' add items").Append(CRLF)
	code1.Append("list1.AddItem(""H1"", BuildSimpleItem(""L1H1"",""mdi-action-account-circle"",""Family""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H1"", ""S1"", BuildSimpleItem(""L1H1S1"","""", ""Mom""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H1"", ""S2"", BuildSimpleItem(""L1H1S2"","""", ""Dad""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H1"", ""S3"", BuildSimpleItem(""L1H1S3"","""", ""Brother""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H1"", ""S4"", BuildSimpleItem(""L1H1S4"","""", ""Sister""))").Append(CRLF)
	code1.Append("list1.AddItem(""H2"", BuildSimpleItem(""L1H2"",""mdi-action-dashboard"",""Colleagues""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H2"", ""S5"", BuildSimpleItem(""L1H2S5"","""", ""Boss""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H2"", ""S6"", BuildSimpleItem(""L1H2S6"","""", ""Secretary""))").Append(CRLF)
	code1.Append("list1.AddItem(""H3"", BuildSimpleItem(""L1H3"",""mdi-editor-border-all"",""Friends""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H3"", ""S7"", BuildSimpleItem(""L1H3S7"","""", ""Jean""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H3"", ""S8"", BuildSimpleItem(""L1H3S8"","""", ""Walter""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H3"", ""S9"", BuildSimpleItem(""L1H3S9"","""", ""Betty""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H3"", ""S10"", BuildSimpleItem(""L1H3S10"","""", ""Thomas""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H3"", ""S11"", BuildSimpleItem(""L1H3S11"","""", ""Jones""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H3"", ""S12"", BuildSimpleItem(""L1H3S12"","""", ""Steven""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H3"", ""S13"", BuildSimpleItem(""L1H3S13"","""", ""Andrea""))").Append(CRLF)
	code1.Append("list1.AddSubItem(""H3"", ""S14"", BuildSimpleItem(""L1H3S14"","""", ""Julie""))").Append(CRLF)
	code1.Append("").Append(CRLF)
	code1.Append("page.Cell(2,1).AddComponent(list1)").Append(CRLF)
	
	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlock(page, "code1", code1))
	
	' code block
	Dim code1a As StringBuilder
	code1a.Initialize
	code1a.Append("// the list clicked event").Append(CRLF)
	code1a.Append("Sub List1_Clicked(ItemId As String)").Append(CRLF)
	code1a.Append("   If ItemId.StartsWith(""H"") Then Return").Append(CRLF)
	code1a.Append("   Dim list1 As ABMList = page.Component(""list1"")").Append(CRLF)
	code1a.Append("   Dim lbl As ABMLabel = list1.Item(ItemId)").Append(CRLF)
	code1a.Append("   Dim myTexts, myReturns As List").Append(CRLF)
	code1a.Append("   myTexts.Initialize").Append(CRLF)
	code1a.Append("   myReturns.Initialize").Append(CRLF)
	code1a.Append("   myToastId = myToastId + 1").Append(CRLF)
	code1a.Append("   page.ShowToast(""toast"" & myToastId, ""toastred"", ""Clicked on "" & lbl.Text, 5000, myTexts, myReturns)").Append(CRLF)
	code1a.Append("End Sub").Append(CRLF)
		
	page.Cell(4,1).AddComponent(ABMShared.BuildCodeBlock(page, "code1a", code1a))
	
	' add a header label
	page.Cell(5,1).AddComponent(ABMShared.BuildHeader(page,"hdr2", "Lists with scrollbar"))
	
	' add paragraph	
	page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,"par3","Lists with a scrollbar have a maximum height. In this example we also use another collapsing method: ABM.COLLAPSE_EXPANDABLE.") )
	
	' create list
	Dim list2 As ABMList
	list2.InitializeWithMaxHeight(page, "list2", ABM.COLLAPSE_EXPANDABLE, 310, "list1theme")
	
	' add items
	list2.AddItem("H1", BuildSimpleItem("L2H1","mdi-action-account-circle","Family"))
	list2.AddSubItem("H1", "S1", BuildSimpleItem("L2H1S1","", "Mom"))
	list2.AddSubItem("H1", "S2", BuildSimpleItem("L2H1S2","", "Dad"))
	list2.AddSubItem("H1", "S3", BuildSimpleItem("L2H1S3","", "Brother"))
	list2.AddSubItem("H1", "S4", BuildSimpleItem("L2H1S4","", "Sister"))
	list2.AddItem("H2", BuildSimpleItem("L2H2","mdi-action-dashboard","Colleagues"))
	list2.AddSubItem("H2", "S5", BuildSimpleItem("L2H2S5","", "Boss"))
	list2.AddSubItem("H2", "S6", BuildSimpleItem("L2H2S6","", "Secretary"))
	list2.AddItem("H3", BuildSimpleItem("L2H3","mdi-editor-border-all","Friends"))
	list2.AddSubItem("H3", "S7", BuildSimpleItem("L2H3S7","", "Jean"))
	list2.AddSubItem("H3", "S8", BuildSimpleItem("L2H3S8","", "Walter"))
	list2.AddSubItem("H3", "S9", BuildSimpleItem("L2H3S9","", "Betty"))
	list2.AddSubItem("H3", "S10", BuildSimpleItem("L2H3S10","", "Thomas"))
	list2.AddSubItem("H3", "S11", BuildSimpleItem("L2H3S11","", "Jones"))
	list2.AddSubItem("H3", "S12", BuildSimpleItem("L2H3S12","", "Steven"))
	list2.AddSubItem("H3", "S13", BuildSimpleItem("L2H3S13","", "Andrea"))
	list2.AddSubItem("H3", "S14", BuildSimpleItem("L2H3S14","", "Julie"))
	
	page.Cell(6,1).AddComponent(list2)
	
	' code block
	Dim code2 As StringBuilder
	code2.Initialize
	code2.Append("list2.InitializeWithMaxHeight(page, ""list2"", ABM.COLLAPSE_EXPANDABLE, 310, ""list1theme"")").Append(CRLF)
	code2.Append("...").Append(CRLF)
		
	page.Cell(7,1).AddComponent(ABMShared.BuildCodeBlock(page, "code2", code2))
	
	' add a header label
	page.Cell(8,1).AddComponent(ABMShared.BuildHeader(page,"hdr2", "Complex list layout"))
	
	' add paragraph	
	page.Cell(8,1).AddComponent(ABMShared.BuildParagraph(page,"par3","The layouts of the items in a list can be complex. For example this list has ABMCards as items.") )
	
	' create list
	Dim list3 As ABMList
	list3.InitializeWithMaxHeight(page, "list3", ABM.COLLAPSE_ACCORDION, 620, "list3theme")
	
	' add items
	list3.AddItem("H1", BuildSimpleItem("L3H1","mdi-action-account-circle","Family"))
	list3.AddSubItem("H1", "S1", BuildItem("L3H1S1","../images/list1.jpg", "Mom"))
	list3.AddSubItem("H1", "S2", BuildItem("L3H1S2","../images/list2.jpg", "Dad"))
	list3.AddSubItem("H1", "S3", BuildItem("L3H1S3","../images/list3.jpg", "Brother"))
	list3.AddSubItem("H1", "S4", BuildItem("L3H1S4","../images/list4.jpg", "Sister"))
	list3.AddItem("H2", BuildSimpleItem("L3H2","mdi-action-dashboard","Colleagues"))
	list3.AddSubItem("H2", "S5", BuildItem("L3H2S5","../images/list5.jpg", "Boss"))
	list3.AddSubItem("H2", "S6", BuildItem("L3H2S6","../images/list6.jpg", "Secretary"))
	list3.AddItem("H3", BuildSimpleItem("L3H3","mdi-editor-border-all","Friends"))
	list3.AddSubItem("H3", "S7", BuildItem("L3H3S7","../images/list7.jpg", "Jean"))
	list3.AddSubItem("H3", "S8", BuildItem("L3H3S8","../images/list8.jpg", "Walter"))
	list3.AddSubItem("H3", "S9", BuildItem("L3H3S9","../images/list9.jpg", "Betty"))
	list3.AddSubItem("H3", "S10", BuildItem("L3H3S10","../images/list10.jpg", "Thomas"))
	list3.AddSubItem("H3", "S11", BuildItem("L3H3S11","../images/list11.jpg", "Jones"))
	list3.AddSubItem("H3", "S12", BuildItem("L3H3S12","../images/list12.jpg", "Steven"))
	list3.AddSubItem("H3", "S13", BuildItem("L3H3S13","../images/list13.jpg", "Andrea"))
	list3.AddSubItem("H3", "S14", BuildItem("L3H3S14","../images/list14.jpg", "Julie"))
	
	page.Cell(9,1).AddComponent(list3)
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub BuildSimpleItem(id As String, icon As String, Title As String) As ABMLabel
	Dim lbl As ABMLabel
	If icon <> "" Then
		lbl.Initialize(page, id, Title, ABM.SIZE_H6, False, "header")
	Else
		lbl.Initialize(page, id, Title, ABM.SIZE_H6, True, "")
	End If
	lbl.VerticalAlign = True
	lbl.IconName = icon
	Return lbl
End Sub


Sub BuildItem(id As String, image As String, title As String) As ABMCard
	' image card
	Dim card4 As ABMCard
	card4.InitializeAsCard(page, "card4", title, "This is my card content...", ABM.CARD_NOTSPECIFIED,"whitetitle")
	card4.Image = image
	Return card4
End Sub


' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "GettingStarted" Then Return
	If Action = "Contact" Then		
		myToastId = myToastId + 1		
		page.ShowToast("toast" & myToastId, "toastred", "Hello to you too! ", 5000)
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

' clicked on an item in the list
Sub List1_Clicked(ItemId As String)
	If ItemId.StartsWith("H") Then Return
	Dim list1 As ABMList = page.Component("list1")
	list1.AddSubItem("H4", "S" & (1000+myToastId), BuildSimpleItem("L1H4S" & (1000+myToastId),"", "Item" & (1000+myToastId)))
	list1.Refresh
	Dim lbl As ABMLabel = list1.Item(ItemId)
	myToastId = myToastId + 1
	page.ShowToast("toast" & myToastId, "toastred", "Clicked on " & lbl.Text, 5000)
End Sub