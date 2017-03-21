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
	Public Name As String = "CompInputPage"
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
		ws.session.SetAttribute("ABMNewSession", True)
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
				' cannot be called diretly, to many param
				CallSub2(Me, eventName, Params)				
		End Select
	End If
End Sub

public Sub BuildTheme()
	' start with the base theme defined in ABMShared
	theme.Initialize("pagetheme")
	theme.AddABMTheme(ABMShared.MyTheme)
	
	' add additional themes specific for this page
	' change the placeholder for input fields.  This is defined per page, not per input!
	theme.Page.PlaceHolderColorIntensity = ABM.INTENSITY_DARKEN2
	
	' bluegray button
	theme.AddButtonTheme("bluegrey")
	theme.Button("bluegrey").BackColor = ABM.COLOR_BLUEGREY
	theme.Button("bluegrey").BackColorIntensity = ABM.INTENSITY_DARKEN1
	
	' modal sheet
	theme.AddContainerTheme("modalcontent")
	theme.Container("modalcontent").BackColor = ABM.COLOR_WHITE	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True	
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMInput"
	page.PageDescription = "The input component "	
	page.PageHTMLName = "abmaterial-input.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMInput", "../images/logo.png", "", "Controls", "ABMInput")
	
	' create the grid
	page.AddRows(1,True, "").AddCells12(1,"")
	page.AddRows(1,True, "").AddCellsOS(2,0,0,0,12,6,6,"") 
	page.AddRows(8,True, "").AddCells12(1,"")
	page.AddRows(1,True, "").AddCellsOS(2,0,0,0,12,6,6,"") 
	page.AddRows(8,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	'page.ShowGridInfo = True	
		
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Text fields allow user input. The border should light up simply and clearly indicating which field the user is currently editing. If you don't want the Green and Red validation states, just set validate to false.") )
	
	' create the input fields
	Dim inp1 As ABMInput
	inp1.Initialize(page, "inp1", ABM.INPUT_TEXT, "First Name", False, "")
	inp1.PlaceHolderText = "or your call name"
	
	'Dim inp1 As ABMFileInput
	'inp1.Initialize(page, "inp1", "Select a file", "Open", "", "")
	
	
	
'	inp1.AutoCompleteType = ABM.AUTOCOMPLETE_STARTS
'	inp1.AddAutoComplete("Alain")
'	inp1.AddAutoComplete("Jos")
'	inp1.AddAutoComplete("Carine")
'	inp1.AddAutoComplete("Mams")
'	inp1.AddAutoComplete("Paps")
'	inp1.AddAutoComplete("Paul")
'	inp1.AddAutoComplete("Pauline")	
'	inp1.AddAutoComplete("Pandora")
'	inp1.AddAutoComplete("Pieter")
'	inp1.AddAutoComplete("Philip")
'	inp1.AddAutoComplete("Porter")
	page.Cell(2,1).AddComponent(inp1)
	
	Dim inp2 As ABMInput
	inp2.Initialize(page, "inp2", ABM.INPUT_TEXT, "Last Name", False, "")
	'inp2.Align = ABM.INPUT_TEXTALIGN_END
'	inp2.AutoCompleteType = ABM.AUTOCOMPLETE_CONTAINS
'	inp2.AddAutoComplete("Bailleul")
'	inp2.AddAutoComplete("Williams")
'	inp2.AddAutoComplete("Pauwels")
'	inp2.AddAutoComplete("Walkers")
'	inp2.AddAutoComplete("Jamesson")
'	inp2.AddAutoComplete("Who")
'	inp2.AddAutoComplete("Dekaasstekker")
	page.Cell(2,2).AddComponent(inp2)
	
	Dim inp3 As ABMInput
	inp3.Initialize(page, "inp3", ABM.INPUT_TEXT, "Disabled", False, "")
	inp3.Enabled = False
	inp3.PlaceHolderText = "I'm disabled!"
	page.Cell(3,1).AddComponent(inp3)
	
	Dim inp4 As ABMInput
	inp4.Initialize(page, "inp4", ABM.INPUT_PASSWORD, "Password", False, "")
	page.Cell(4,1).AddComponent(inp4)
	
	Dim inp5 As ABMInput
	inp5.Initialize(page, "inp5", ABM.INPUT_EMAIL, "Email", False, "")
	inp5.WrongMessage = "Wrong"
	inp5.SuccessMessage = "Correct"
	page.Cell(5,1).AddComponent(inp5)
	
	' add codeblock	
	Dim code1 As StringBuilder
	code1.Initialize
	code1.Append("Dim inp1 As ABMInput").Append(CRLF)
	code1.Append("inp1.Initialize(page, ""inp1"", ABM.INPUT_TEXT, ""First Name"" False, """")").Append(CRLF)
	code1.Append("inp1.PlaceHolderText = ""or your call name""").Append(CRLF)
	code1.Append("page.Cell(2,1).AddComponent(inp1)").Append(CRLF)
	code1.Append("").Append(CRLF)
	code1.Append("Dim inp2 As ABMInput").Append(CRLF)
	code1.Append("inp2.Initialize(page, ""inp2"", ABM.INPUT_TEXT, ""Last Name"", False, """")").Append(CRLF)
	code1.Append("page.Cell(2,2).AddComponent(inp2)").Append(CRLF)
	code1.Append("").Append(CRLF)
	code1.Append("Dim inp3 As ABMInput").Append(CRLF)
	code1.Append("inp3.Initialize(page, ""inp3"", ABM.INPUT_TEXT, ""Disabled"", False, """")").Append(CRLF)
	code1.Append("inp3.Disabled = True").Append(CRLF)
	code1.Append("inp3.PlaceHolderText = ""I'm disabled!""").Append(CRLF)
	code1.Append("page.Cell(3,1).AddComponent(inp3)").Append(CRLF)
	code1.Append("").Append(CRLF)
	code1.Append("Dim inp4 As ABMInput").Append(CRLF)
	code1.Append("inp4.Initialize(page, ""inp4"", ABM.INPUT_PASSWORD, ""Password"", False, """")").Append(CRLF)
	code1.Append("page.Cell(4,1).AddComponent(inp4)").Append(CRLF)
	code1.Append("").Append(CRLF)
	code1.Append("Dim inp5 As ABMInput").Append(CRLF)
	code1.Append("inp5.Initialize(page, ""inp5"", ABM.INPUT_EMAIL, ""Email"", False, """")").Append(CRLF)
	code1.Append("inp5.WrongMessage = ""Wrong""").Append(CRLF)
	code1.Append("inp5.SuccessMessage = ""Correct""").Append(CRLF)
	code1.Append("page.Cell(5,1).AddComponent(inp5)").Append(CRLF)
	
	page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlock(page, "code1", code1))
	
	' add a sub header label
	page.Cell(7,1).AddComponent(ABMShared.BuildSubHeader(page,"hdr1", "Prefilled Text Inputs"))
	
	' input
	Dim inp6 As ABMInput
	inp6.Initialize(page, "inp6", ABM.INPUT_TEXT, "First Name", False, "")
	inp6.Text = "Alain"
	page.Cell(8,1).AddComponent(inp6)
	
	' code block
	Dim code2 As StringBuilder
	code2.Initialize
	code2.Append("Dim inp6 As ABMInput").Append(CRLF)
	code2.Append("inp6.Initialize(page, ""inp6"", ABM.INPUT_TEXT, ""First Name"", False, """")").Append(CRLF)
	code2.Append("inp6.Text = ""Alain""").Append(CRLF)
	code2.Append("page.Cell(8,1).AddComponent(inp6)").Append(CRLF)
	
	page.Cell(9,1).AddComponent(ABMShared.BuildCodeBlock(page, "code2", code2))
	
	' add a sub header
	page.Cell(10,1).AddComponent(ABMShared.BuildSubHeader(page,"hdr2", "Icon Prefixes"))
	
	' add paragraph	
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page,"par1","You can add an icon prefix to make the form input label even more clear. ") )
	
	' input
	Dim inp7 As ABMInput
	inp7.Initialize(page, "inp7", ABM.INPUT_TEXT, "First Name", False, "")
	inp7.IconName = "mdi-action-account-circle"
	page.Cell(11,1).AddComponent(inp7)
	
	' input
	Dim inp8 As ABMInput
	inp8.Initialize(page, "inp8", ABM.INPUT_TEXT, "Telephone", False, "")
	inp8.IconName = "mdi-communication-phone"
	page.Cell(11,2).AddComponent(inp8)
	
'	' code block
	Dim code3 As StringBuilder
	code3.Initialize
	code3.Append("Dim inp7 As ABMInput").Append(CRLF)
	code3.Append("inp7.Initialize(page, ""inp7"", ABM.INPUT_TEXT, ""First Name"", False, """")").Append(CRLF)
	code3.Append("inp7.IconName = ""mdi-action-account-circle""").Append(CRLF)
	code3.Append("page.Cell(11,1).AddComponent(inp7)").Append(CRLF)
	code3.Append("").Append(CRLF)
	code3.Append("Dim inp8 As ABMInput").Append(CRLF)
	code3.Append("inp8.Initialize(page, ""inp8"", ABM.INPUT_TEXT, ""Telephone"", False, """")").Append(CRLF)
	code3.Append("inp8.IconName = ""mdi-communication-phone""").Append(CRLF)
	code3.Append("page.Cell(11,2).AddComponent(inp8)").Append(CRLF)
	
	page.Cell(12,1).AddComponent(ABMShared.BuildCodeBlock(page, "code3", code3))
	
	' add a header
	page.Cell(13,1).AddComponent(ABMShared.BuildHeader(page,"hdr3", "Text Area"))
	
	' add paragraph	
	page.Cell(13,1).AddComponent(ABMShared.BuildParagraph(page,"par2","Textareas allow larger expandable user input. The border should light up simply and clearly indicating which field the user is currently editing. ") )
		
	' input
	Dim inp9 As ABMInput
	inp9.Initialize(page, "inp9", ABM.INPUT_TEXT, "Comment", True, "")
	inp9.IconName = "mdi-communication-comment"
	page.Cell(14,1).AddComponent(inp9)	
		
	' add button
	Dim btn1 As ABMButton
	btn1.InitializeRaised(page, "btn1", "", "", "Get the text", "bluegrey")
	page.Cell(15,1).AddComponent(btn1)
	
	' add a date 
	Dim inp10 As ABMInput
	inp10.Initialize(page, "inp10", ABM.INPUT_TEXT, "With date mask", False, "")	
	' check out http://robinherbots.github.io/jquery.inputmask/ for more info how to build your masks
	inp10.inputMask = "'mask': 'd/m/y'"
	page.Cell(16,1).AddComponent(inp10)
	
	' add a popup window
	Dim myModal As ABMModalSheet
	myModal.Initialize(page, "myModal", False, False, "")
	myModal.Content.UseTheme("modalcontent")
	myModal.Footer.UseTheme("modalcontent")
	myModal.IsDismissible = True
	
	myModal.Content.AddRows(1, True, "").AddCells12(1,"")
	myModal.content.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
		
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, "contlbl1", "buttonmessages",ABM.SIZE_PARAGRAPH, False, "")
	myModal.content.Cell(1,1).AddComponent(lbl1)
	
	page.AddModalSheetTemplate(myModal)
	
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
	If Action = "GettingStarted" Then Return
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
	
	Dim inp1 As ABMInput = page.Component("inp1")
	'Dim inp1 As ABMFileInput = page.Component("inp1")
	Dim inp2 As ABMInput = page.Component("inp2")
	Dim inp3 As ABMInput = page.Component("inp3")
	Dim inp4 As ABMInput = page.Component("inp4")
	Dim inp5 As ABMInput = page.Component("inp5")
	Dim inp6 As ABMInput = page.Component("inp6")
	Dim inp7 As ABMInput = page.Component("inp7")
	Dim inp8 As ABMInput = page.Component("inp8")
	Dim inp9 As ABMInput = page.Component("inp9")
	Dim mymodal As ABMModalSheet = page.ModalSheet("myModal")
	Dim myModalLbl As ABMLabel= mymodal.Content.Component("contlbl1")
	myModalLbl.Text = inp1.Text & "{BR}" & inp2.Text & "{BR}" & inp3.Text & "{BR}" & inp4.Text & "{BR}" & inp5.Text & "{BR}" & inp6.Text & "{BR}" & inp7.Text & "{BR}" & inp8.Text & "{BR}" & inp9.Text

	'	Log("filename: " & inp1.GetFileName)		
	
	page.ShowModalSheet("myModal")
End Sub