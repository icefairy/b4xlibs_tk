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
	Public Name As String = "CompButtonPage"
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
	
	' toast theme
	theme.AddToastTheme("toastgreen")
	theme.Toast("toastgreen").BackColor = ABM.COLOR_GREEN
	theme.Toast("toastgreen").BackColorIntensity = ABM.INTENSITY_DARKEN2
	
	' bluegray button
	theme.AddButtonTheme("bluegrey")
	theme.Button("bluegrey").BackColor = ABM.COLOR_BLUEGREY
	theme.Button("bluegrey").BackColorIntensity = ABM.INTENSITY_DARKEN1
	
	' darkred button
	theme.AddButtonTheme("darkred")
	theme.Button("darkred").BackColor = ABM.COLOR_RED
	theme.Button("darkred").BackColorIntensity = ABM.INTENSITY_DARKEN1
	
	' transparent button
	theme.AddButtonTheme("transparent")
	theme.Button("transparent").BackColor = ABM.COLOR_TRANSPARENT	
	
	' darkgreen button
	theme.AddButtonTheme("darkgreen")
	theme.Button("darkgreen").BackColor = ABM.COLOR_GREEN
	theme.Button("darkgreen").BackColorIntensity = ABM.INTENSITY_DARKEN1	
	
	' modal sheet
	theme.AddContainerTheme("modalcontent")
	theme.Container("modalcontent").BackColor = ABM.COLOR_WHITE	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True	
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMButton"
	page.PageDescription = "The button component "	
	page.PageHTMLName = "abmaterial-button.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
	
	ABMShared.BuildNavigationBar(page, "ABMButton","../images/logo.png", "", "Controls", "ABMButton")
	
	' create the page grid
	page.AddRows(1,True, "").AddCells12(1,"")
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,9,10,"")
	page.AddRows(13,True, "").AddCells12(1,"")	
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True	
	
	page.AddFXToast("hdr1", 0,"passingtoast", "toastgreen", "You're scrolling!", 5000)
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","There are 3 main button types described in ABMaterial. The raised button is a standard button that signify actions and seek to give depth to a mostly flat page. The floating circular action button is meant for very important functions. Flat buttons are usually used within elements that already have depth like cards or modals.") )
	' add a header label
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Raised"))
	
	' add buttons
	Dim btn1 As ABMButton
	btn1.InitializeRaised(page, "btn1", "picture_as_pdf", ABM.ICONALIGN_LEFT, "BUTTON", "bluegrey")
	page.Cell(2,1).AddComponent(btn1)
	
	Dim btn2 As ABMButton
	btn2.InitializeRaised(page, "btn2", "fa fa-home", ABM.ICONALIGN_LEFT, "BUTTON", "bluegrey")
	page.Cell(2,1).AddComponent(btn2)
	
	Dim btn3 As ABMButton
	btn3.InitializeRaised(page, "btn3", "mdi-image-palette", ABM.ICONALIGN_RIGHT, "BUTTON", "bluegrey")
	page.Cell(2,1).AddComponent(btn3)
	
	' add codeblock	
	Dim code As StringBuilder
	code.Initialize
	code.Append("Dim btn1 As ABMButton").Append(CRLF)
	code.Append("btn1.InitializeRaised(page, ""btn1"", """", """", ""BUTTON"", ""bluegrey"")").Append(CRLF)
	code.Append("page.Cell(2,1).AddComponent(btn1)").Append(CRLF)
	code.Append("").Append(CRLF)
	code.Append("Dim btn2 As ABMButton").Append(CRLF)
	code.Append("btn2.InitializeRaised(page, ""btn2"", ""mdi-image-palette"", ABM.ICONALIGN_LEFT, ""BUTTON"", ""bluegrey"")").Append(CRLF)
	code.Append("page.Cell(2,1).AddComponent(btn2)").Append(CRLF)
	code.Append("").Append(CRLF)
	code.Append("Dim btn3 As ABMButton").Append(CRLF)
	code.Append("btn3.InitializeRaised(page, ""btn3"", ""mdi-image-palette"", ABM.ICONALIGN_RIGHT, ""BUTTON"", ""bluegrey"")").Append(CRLF)
	code.Append("page.Cell(2,1).AddComponent(btn3)").Append(CRLF)	
	
	page.Cell(3,1).AddComponent(ABMShared.BuildCodeBlock(page, "code1", code))
	
	' add a header label
	page.Cell(4,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Floating"))
	
	Dim btn4 As ABMButton
	btn4.Initializefloating(page, "btn4", "mdi-image-palette", "darkred")
	btn4.size = ABM.BUTTONSIZE_LARGE
	page.Cell(5,1).AddComponent(btn4)
	
	' add codeblock	
	Dim code2 As StringBuilder
	code2.Initialize
	code2.Append("Dim btn4 As ABMButton").Append(CRLF)
	code2.Append("btn4.Initializefloating(page, ""btn4"", ""mdi-image-palette"", ""darkred"")").Append(CRLF)
	code2.Append("btn4..size = ABM.BUTTONSIZE_LARGE").Append(CRLF)
	code2.Append("page.Cell(5,1).AddComponent(btn4)").Append(CRLF)
	
	page.Cell(6,1).AddComponent(ABMShared.BuildCodeBlock(page, "code2", code2))
	
	' add a header label
	page.Cell(7,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Flat"))
	
	Dim btn5 As ABMButton
	btn5.InitializeFlat(page, "btn5", "", "", "FLAT BUTTON", "transparent")
	page.Cell(8,1).AddComponent(btn5)
	
	' add codeblock	
	Dim code3 As StringBuilder
	code3.Initialize
	code3.Append("Dim btn5 As ABMButton").Append(CRLF)
	code3.Append("btn5.InitializeFlat(page, ""btn5"", """", """", ""FLAT BUTTON"", ""transparent"")").Append(CRLF)
	code3.Append("page.AddComponent(""Rgrid8C1"", btn5)").Append(CRLF)
	
	page.Cell(9,1).AddComponent(ABMShared.BuildCodeBlock(page, "code3", code3))
		
	' add a header label
	page.Cell(10,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Size"))
	' add paragraph	
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Buttons can vary in size if they need more/less attention.") )
	
	Dim btn6 As ABMButton
	btn6.InitializeRaised(page, "btn6", "mdi-image-palette", ABM.ICONALIGN_RIGHT, "BUTTON", "darkgreen")
	btn6.size = ABM.BUTTONSIZE_SMALL
	page.Cell(11,1).AddComponent(btn6)
	
	Dim btn6b As ABMButton
	btn6b.InitializeRaised(page, "btn6b", "mdi-image-palette", ABM.ICONALIGN_RIGHT, "BUTTON", "darkgreen")
	btn6b.size = ABM.BUTTONSIZE_NORMAL
	page.Cell(11,1).AddComponent(btn6b)
	
	Dim btn6c As ABMButton
	btn6c.InitializeRaised(page, "btn6c", "mdi-image-palette", ABM.ICONALIGN_RIGHT, "BUTTON", "darkgreen")
	btn6c.size = ABM.BUTTONSIZE_LARGE
	page.Cell(11,1).AddComponent(btn6c)
	
	' add codeblock	
	Dim code4 As StringBuilder
	code4.Initialize
	code4.Append("Dim btn6 As ABMButton").Append(CRLF)
	code4.Append("btn6.InitializeRaised(page, ""btn6"", ""mdi-image-palette"", ABM.ICONALIGN_RIGHT, ""BUTTON"", ""darkgreen"")").Append(CRLF)
	code4.Append("btn6.Size = ABM.BUTTONSIZE_SMALL").Append(CRLF)
	code4.Append("page.Cell(11,1).AddComponent(btn6)").Append(CRLF)
	
	page.Cell(12,1).AddComponent(ABMShared.BuildCodeBlock(page, "code4", code4))
	
	' add a header label
	page.Cell(13,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Enabled/Disabled"))
	' add paragraph	
	page.Cell(13,1).AddComponent(ABMShared.BuildParagraph(page,"par1","This can be applied to all button types.") )
	
	Dim btn7 As ABMButton
	btn7.InitializeRaised(page, "btn7", "mdi-image-palette", ABM.ICONALIGN_RIGHT, "BUTTON", "")
	btn7.size = ABM.BUTTONSIZE_LARGE
	btn7.Enabled = False
	page.Cell(14,1).AddComponent(btn7)
	
	' add codeblock	
	Dim code5 As StringBuilder
	code5.Initialize
	code5.Append("Dim btn7 As ABMButton").Append(CRLF)
	code5.Append("btn7.InitializeRaised(page, ""btn7"", ""mdi-image-palette"", ABM.ICONALIGN_RIGHT, ""BUTTON"", """")").Append(CRLF)
	code5.Append("btn7.size = ABM.BUTTONSIZE_LARGE").Append(CRLF)
	code5.Append("btn7.Enabled = False").Append(CRLF)
	code5.Append("page.Cell(14,1).AddComponent(btn7)").Append(CRLF)
	
	page.Cell(15,1).AddComponent(ABMShared.BuildCodeBlock(page, "code5", code5))
	
	' add a popup window
	page.AddModalSheetTemplate(ConnectModal)	
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
	
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub ConnectModal()  As ABMModalSheet
	Dim myModal As ABMModalSheet
	myModal.Initialize(page, "myModal", False, False, "")
	myModal.Content.UseTheme("modalcontent")
	myModal.Footer.UseTheme("modalcontent")
	myModal.IsDismissible = True
	
	myModal.Content.AddRows(1, True, "").AddCells12(1,"")
	myModal.Content.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, "contlbl1", "buttonmessages",ABM.SIZE_PARAGRAPH, False, "")
	myModal.Content.Cell(1,1).AddComponent(lbl1)
	
	Return myModal
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition
	If Action = "ABMButton" Then Return
	If Action = "Contact" Then		
		myToastId = myToastId + 1
		page.ShowToast("toast" & myToastId, "toastred", "Hello to you too!", 5000)
		Return
	End If
	ABMShared.NavigateToPage(ws, ABMPageId, Value)
End Sub

Sub btn1_Clicked(Target As String)
	Dim myTexts, myReturns As List
	myTexts.Initialize
	myTexts.Add("READ IT")
	myReturns.Initialize
	myReturns.Add("READIT")
	myToastId = myToastId + 1
	page.ShowToastWithReturns("toast" & myToastId, "toast", "First raised button! (" & myToastId & ")", 5000, myTexts, myReturns)	
End Sub

Sub btn2_Clicked(Target As String)
	Dim myTexts, myReturns As List
	myTexts.Initialize
	myTexts.Add("READ IT")
	myReturns.Initialize
	myReturns.Add("READIT")
	myToastId = myToastId + 1
	page.ShowToastWithReturns("toast" & myToastId, "toastred", "Second raised button! (" & myToastId & ")", 5000, myTexts, myReturns)
End Sub

Sub btn3_Clicked(Target As String)
	Dim myTexts, myReturns As List
	myTexts.Initialize
	myTexts.Add("READ IT")
	myReturns.Initialize
	myReturns.Add("READIT")
	myToastId = myToastId + 1
	page.ShowToastWithReturns("toast" & myToastId, "toast", "Third raised button! (" & myToastId & ")", 5000, myTexts, myReturns)
End Sub

Sub Page_ToastClicked(ToastId As String, Action As String)
	Log("Toast " & ToastId & " clicked on " & Action)
	page.DismissToast(ToastId)
End Sub

Sub Page_ToastDismissed(ToastId As String)
	Log("Toast " & ToastId & " dismissed!")
End Sub

Sub btn4_Clicked(Target As String)
	Dim mymodal As ABMModalSheet = page.ModalSheet("myModal")
	Dim myModalLbl As ABMLabel= mymodal.Content.Component("contlbl1")
	myModalLbl.Text = "You clicked on the floating button!"
	page.ShowModalSheet("myModal")
End Sub

Sub btn5_Clicked(Target As String)
	Dim mymodal As ABMModalSheet = page.ModalSheet("myModal")
	Dim myModalLbl As ABMLabel= mymodal.Content.Component("contlbl1")
	myModalLbl.Text = "You clicked on the flat button!"
	page.ShowModalSheet("myModal")
End Sub

Sub btn6_Clicked(Target As String)
	Dim mymodal As ABMModalSheet = page.ModalSheet("myModal")
	Dim myModalLbl As ABMLabel= mymodal.Content.Component("contlbl1")
	myModalLbl.Text = "You clicked on the small raised button!"
	page.ShowModalSheet("myModal")
End Sub

Sub btn6b_Clicked(Target As String)
	Dim mymodal As ABMModalSheet = page.ModalSheet("myModal")
	Dim myModalLbl As ABMLabel= mymodal.Content.Component("contlbl1")
	myModalLbl.Text = "You clicked on the normal sized raised button!"
	page.ShowModalSheet("myModal")
End Sub

Sub btn6c_Clicked(Target As String)
	Dim mymodal As ABMModalSheet = page.ModalSheet("myModal")
	Dim myModalLbl As ABMLabel= mymodal.Content.Component("contlbl1")
	myModalLbl.Text = "You clicked on the large raised button!"
	page.ShowModalSheet("myModal")
End Sub