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
	Public Name As String = "CompComboPage"
	' will hold the unique browsers window id
	Private ABMPageId As String = ""
	
	' your own variables
	Dim myToastId As Int
	Dim combocounter As Int = 4
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
	theme.AddLabelTheme("lightblue")
	theme.Label("lightblue").ForeColor = ABM.COLOR_LIGHTBLUE
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMCombo"
	page.PageDescription = "The combo component "	
	page.PageHTMLName = "abmaterial-combo.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMCombo", "../images/logo.png", "", "Controls", "ABMCombo")
		
	' create the page grid
	page.AddRows(5,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True		
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Combos allows user input through specified options.") )
	
	' create combo
	Dim combo1 As ABMCombo
	combo1.Initialize(page, "combo1", "Select a {B}person{/B}", 650, "")
	combo1.Valid = ABM.VALID_FALSE
	combo1.PlaceHolderText = "{NBSP}"
	combo1.WrongMessage = "My Wrong Message"
	combo1.IconName = "mdi-action-account-circle"
	
	' add items
	combo1.AddItem("combo1S1", "Mom", BuildSimpleItem("S1", "mdi-action-account-circle", "{NBSP}{NBSP}Mom"))
	combo1.AddItem("combo1S2", "Dad", BuildSimpleItem("S2", "mdi-action-account-circle", "{NBSP}{NBSP}Dad"))
	combo1.AddItem("combo1S3", "Brother", BuildSimpleItem("S3", "mdi-action-dashboard", "{NBSP}{NBSP}Brother"))
	combo1.AddItem("combo1S4", "Sister", BuildSimpleItem("S4", "mdi-action-dashboard", "{NBSP}{NBSP}Sister"))
	
	page.cell(2,1).AddComponent(combo1)
	
	Dim btn As ABMButton
	btn.InitializeRaised(page , "btn", "", "", "Add item" ,"")
	page.Cell(3,1).AddComponent(btn)
	
	
	' add codeblock	
	Dim code As StringBuilder
	code.Initialize	
	code.Append("// create combo").Append(CRLF)
	code.Append("Dim combo1 As ABMCombo").Append(CRLF)
	code.Append("combo1.Initialize(page, ""combo1"", ""Select a person"", 650, """")").Append(CRLF)
	code.Append("combo1.IconName = ""mdi-action-account-circle""").Append(CRLF)
	code.Append("").Append(CRLF)
	code.Append("// add items").Append(CRLF)
	code.Append("combo1.AddItem(""combo1S1"", ""Mom"", BuildSimpleItem(""S1"", ""mdi-action-account-circle"", ""{NBSP}{NBSP}Mom""))").Append(CRLF)
	code.Append("combo1.AddItem(""combo1S2"", ""Dad"", BuildSimpleItem(""S2"", ""mdi-action-account-circle"", ""{NBSP}{NBSP}Dad""))").Append(CRLF)
	code.Append("combo1.AddItem(""combo1S3"", ""Brother"", BuildSimpleItem(""S3"", ""mdi-action-dashboard"", ""{NBSP}{NBSP}Brother""))").Append(CRLF)
	code.Append("combo1.AddItem(""combo1S4"", ""Sister"", BuildSimpleItem(""S4"", ""mdi-action-dashboard"", ""{NBSP}{NBSP}Sister""))").Append(CRLF)
	code.Append("").Append(CRLF)
	code.Append("page.cell(2,1).AddComponent(combo1)").Append(CRLF)
	
	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlock(page, "code1", code))
	
	' add paragraph	
	page.cell(4,1).AddComponent(ABMShared.BuildParagraph(page,"par2","Combos can also have more complex layouts.") )
	
	' create combo
	Dim combo2 As ABMCombo
	combo2.Initialize(page, "combo2", "Select a person", 650, "")
	combo2.IconName = "mdi-action-account-circle"
	
	' add items
	combo2.AddItem("combo2S1", "Mom", BuildItem("S1", "../images/mom.jpg", "Mom", "The loving one"))
	combo2.AddItem("combo2S2", "Dad", BuildItem("S2", "../images/dad.jpg", "Dad", "The strong one"))
	combo2.AddItem("combo2S3", "Brother", BuildItem("S3", "../images/brother.jpg", "Brother", "My best friend"))
	combo2.AddItem("combo2S4", "Sister", BuildItem("S4", "../images/sister.jpg", "Sister", "The annoying one"))
	
	page.cell(5,1).AddComponent(combo2)
	
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
		lbl.Initialize(page, id, Title, ABM.SIZE_H6, True, "header")
	Else
		lbl.Initialize(page, id, Title, ABM.SIZE_H6, True, "")
	End If
	lbl.VerticalAlign = True
	lbl.IconName = icon
	Return lbl
End Sub

Sub BuildItem(id As String, image As String, Title As String, Subtitle As String) As ABMContainer
	Dim ItemCont As ABMContainer
	ItemCont.Initialize(page, id, "")	
	ItemCont.AddRowsM(1,False,6,0, "").AddCellsOSMP(1,0,0,0,3,2,2,0,0,16,0,"").AddCellsOS(1,0,0,0,9,10,10,"")
	ItemCont.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	Dim SubItemCont As ABMContainer
	SubItemCont.Initialize(page, id & "SubItemCont", "")	
	SubItemCont.AddRowsM(1,False, 0,0,"").AddCells12MP(1,-6,0,0,0,"").AddCells12(1,"")
	SubItemCont.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	ItemCont.Cell(1,2).AddComponent(SubItemCont)
	
	Dim img As ABMImage
	img.Initialize(page, id & "img", image, 1)
	img.SetFixedSize(48,48)
	img.IsCircular = True
	img.IsResponsive = True
	
	ItemCont.Cell(1,1).AddComponent(img)
	
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, id & "lbl1", Title, ABM.SIZE_H6, False, "lightblue")
	lbl1.VerticalAlign = True
	
	SubItemCont.Cell(1,1).AddComponent(lbl1)
	
	Dim lbl2 As ABMLabel
	lbl2.Initialize(page, id & "lbl2", Subtitle, ABM.SIZE_H6, False, "")
	lbl2.VerticalAlign = True
	
	SubItemCont.Cell(1,2).AddComponent(lbl2)
	
	Return ItemCont
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMCombo" Then Return
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

Sub btn_Clicked(Target As String)
	Dim combo1 As ABMCombo = page.Component("combo1")
	combocounter = combocounter + 1
	combo1.AddItem("combo1S" & combocounter, "NewItem" & combocounter, BuildSimpleItem("S" & combocounter, "mdi-action-dashboard", "{NBSP}{NBSP}New Item " & combocounter))
	combo1.SetActiveItemId("combo1S" & combocounter)
	combo1.Refresh
End Sub

Sub combo1_Clicked(itemId As String)
	Log(itemId)
	Dim combo1 As ABMCombo = page.Component("combo1")
	Log(combo1.GetActiveItemId)
End Sub