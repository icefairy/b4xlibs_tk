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
	Public Name As String = "HelperContainerPage"
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
	' cell theme
	theme.AddCellTheme("cellLB")
	theme.Cell("cellLB").BackColor = ABM.COLOR_LIGHTBLUE
	theme.Cell("cellLB").BorderColor = ABM.COLOR_WHITE
	theme.Cell("cellLB").BorderWidth = 1
	
	' grid label
	theme.AddLabelTheme("lblGrid")
	theme.Label("lblGrid").ForeColor = ABM.COLOR_WHITE
	theme.Label("lblGrid").Align = ABM.TEXTALIGN_CENTER
	
	' bluegray button
	theme.AddButtonTheme("bluegrey")
	theme.Button("bluegrey").BackColor = ABM.COLOR_BLUEGREY
	theme.Button("bluegrey").BackColorIntensity = ABM.INTENSITY_DARKEN1
	
	theme.AddCardTheme("whitetitle")
	theme.Card("whitetitle").TitleForeColor = ABM.COLOR_WHITE
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMContainer"
	page.PageDescription = "The container helper"	
	page.PageHTMLName = "abmaterial-container.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
	'page.ShowGridInfo = True
	
		
	ABMShared.BuildNavigationBar(page, "ABMContainer", "../images/logo.png", "", "Helpers", "ABMContainer")
		
	' create the page grid
	page.AddRows(1,True, "").AddCells12(1,"")
	page.AddRows(1,True, "").AddCellsOS(1,0,0,0,12,8,6,"").AddCellsOS(1,0,0,0,12,4,6,"")
	page.AddRows(16,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	

	' because we use an ABMCodeLabel, but it is not defined in this class but in ABMShared, we have to tell it manually to the page
	'page.NeedsCodeLabel = True		
	
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add paragraph
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","The best way to look at a ABMContainer component is like it is a mini ABMPage helper.  It has less options but the flow is almost the same.  You can add Rows, Cells and other components.") )
	' add paragraph
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","ABMContainers are mosly used to further drill down a cell defined in the page.  With an ABMContainer control, you get again a grid of 12 cells so you can do exactly as it was a page.") )
	' add paragraph
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par3","Lets show an example.  We have a page with a row split into two columns of each 6 cells.  In the left cell we've added a container with the grid example from the ABMPage chapter.") )
	
	' create the container
	Dim cont1 As ABMContainer
	cont1.Initialize(page, "cont1", "")
	
	'PHONE
'╔═══════════════════════════════════════════════════════════════════════════════════╗
'║ 1,1                                                                               ║
'╠═══════════════════════════════════════════════════════════════════════════════════╣
'║ 2,1                       | 2,2                       | 2,3                       ║
'║-----------------------------------------------------------------------------------║
'║ 2,4                       | 2,5                       | 2,6                       ║
'║-----------------------------------------------------------------------------------║
'║ 2,7                       | 2,8                       | 2,9                       ║
'║-----------------------------------------------------------------------------------║
'║ 2,10                      | 2,11                      | 2,12                      ║
'╠═══════════════════════════════════════════════════════════════════════════════════╣
'║ 3,1                                                                               ║
'╠═══════════════════════════════════════════════════════════════════════════════════╣
'║ 4,1                                                                               ║
'╚═══════════════════════════════════════════════════════════════════════════════════╝

'TABLET
'╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════╗
'║ 1,1                                                                                                       ║
'╠═══════════════════════════════════════════════════════════════════════════════════════════════════════════╣
'║ 2,1                      | 2,2                      | 2,3                      | 2,4                      ║
'║-----------------------------------------------------------------------------------------------------------║
'║ 2,5                      | 2,6                      | 2,7                      | 2,8                      ║
'║-----------------------------------------------------------------------------------------------------------║
'║ 2,9                      | 2,10                     | 2,11                     | 2,12                     ║
'╠═══════════════════════════════════════════════════════════════════════════════════════════════════════════╣
'║ 3,1                                                                                                       ║
'╠═══════════════════════════════════════════════════════════════════════════════════════════════════════════╣
'║ 4,1                                                                                                       ║
'╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════╝

'DESKTOP
'╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
'║ 1,1                                                                                                                               ║
'╠═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣
'║ 2,1      | 2,2      | 2,3      | 2,4      | 2,5      | 2,6      | 2,7      | 2,8      | 2,9      | 2,10     | 2,11     | 2,12     ║
'╠═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣
'║ 3,1                                                                                                                               ║
'╠═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣
'║ 4,1                                                                                                                               ║
'╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

	cont1.AddRows(1, True,"").AddCells12(1,"")
	cont1.AddRows(1, True,"").AddCellsOS(12,0,0,0,4,3,1,"")
	cont1.AddRows(2, True,"").AddCells12(1,"")
	cont1.BuildGrid ' IMPORTANT!
	
	' add sub header
	cont1.Cell(1,1).AddComponent(ABMShared.BuildSubHeader(page, "shdr1", "12 Cells"))
	
	' add paragraph
	cont1.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page, "par2","Our standard grid has 12 cells. No matter the size of the browser, each of these cells will always have an equal width."))
	' add 12 cells
	For i=1 To 12
		cont1.Cell(2,i).UseTheme("cellLB")
		Dim lblGrid As ABMLabel
		lblGrid.Initialize(page, "Rgrid2C" & i & "Label", "" & i, ABM.SIZE_H6, True, "lblGrid")
		cont1.Cell(2,i).AddComponent(lblGrid)
	Next
	
	' add paragraph
	cont1.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page, "par3", "To get a feel of how the grid is used ..."))
		
	page.Cell(2,1).AddComponent(cont1)
	
	Dim code As String = $"// create the container
Dim cont1 As ABMContainer
cont1.Initialize(page, "cont1", "")
cont1.AddRows(1,True, "").AddCells12(1,"")	
cont1.AddRowsM(1,True,0,0, "").AddCellsOS(12,0,0,0,1,1,1,"")
cont1.AddRows(1,True, "").AddCells12(1,"")	
cont1.BuildGrid // IMPORTANT
	
// add sub header
cont1.Cell(1,1).AddComponent(ABMShared.BuildSubHeader(page, "shdr1", "12 Cells"))
// add paragraph
cont1.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page, "par2","Our standard grid has 12 cells. No matter the size of the browser, each of these cells will always have an equal width."))
// add 12 cells
For i=1 To 12
	cont1.Cell(2,i).UseTheme("cellLB")
	Dim lblGrid As ABMLabel
	lblGrid.Initialize(page, "Rgrid2C" & i & "Label", "" & i, ABM.SIZE_H6, True, "lblGrid")
	cont1.Cell(2,i).AddComponent(lblGrid)
Next
	
// add paragraph
cont1.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page, "par3", "To get a feel of how the grid is used ..."))
	
page.Cell(2,1).AddComponent(cont1)"$
	
	page.Cell(2,2).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code))
	
	' add paragraph
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par4","As you can see, this code is almost exactly the same as the beginning of the code in the ABMPage chapter, except we changed page.Add... to cont1.Add... and added the components accordingly."))
	
	' add paragraph
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par5","This is a very powerful component and if you take your time to think about how the grid of your page must look like, a real time saver."))
	
	' add paragraph
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par6","For further information on how the container works, check out the ABMPage and the Grids chapter (but I'm sure you know that one by heart by now)."))
	
	page.Cell(4,1).AddComponent(ABMShared.BuildSubHeader(page, "shdr2", "Animations"))
	
	page.Cell(4,1).AddComponent(ABMShared.BuildParagraph(page,"par7","ABMContainers (and ergo all it's children) can be animated with scaling, rotating, moving, blurring and transparancies. This can be done with InitializeAnimated() and creating ABMAnimation objects.  See the blur demo to see how it is done!"))
	
	Dim btn1 As ABMButton
	btn1.InitializeRaised(page, "btn1", "", "", "Slide card IN", "bluegrey")
	btn1.Tag = "animin"
	page.Cell(6,1).AddComponent(btn1)
		
	' create the container with animation	
	
	' you ALWAYS need an Initial state, duration should be 0 for the initial state
	Dim myAnim1 As ABMAnimation
	myAnim1.Initialize("initial", 0, ABM.TWEEN_EASEINQUAD)
	myAnim1.SlideLeft ' move it a screen to the left so it is out of view
	myAnim1.ScaleX(0)
	myAnim1.ScaleY(0)
	myAnim1.RotateY(-180)
	page.AddAnimation(myAnim1)
	
	' we create an animation to 'fade in'
	Dim myAnim2 As ABMAnimation
	myAnim2.Initialize("animin", 500, ABM.TWEEN_EASEINQUAD)
	myAnim2.SlideInPositionX ' sliding in the 'normal' position where it would be if no animation was used
	myAnim2.ScaleX(1)
	myAnim2.ScaleY(1)
	myAnim2.RotateY(0)
	page.AddAnimation(myAnim2)	
	
	' we create an animation to 'fade out'
	Dim myAnim3 As ABMAnimation
	myAnim3.Initialize("animout", 500, ABM.TWEEN_EASEINQUAD)
	myAnim3.SlideRight ' move it a screen to the right so it is out of view.  We later ae going to set it left again withthe 'initial' animation.
	myAnim3.ScaleX(0)
	myAnim3.ScaleY(0)
	myAnim3.RotateY(-180)
	page.AddAnimation(myAnim3)
	
	Dim cont2 As ABMContainer
	' new initialize method where you have to set your initial animation
	cont2.InitializeAnimated(page, "cont2", "initial", "")
	cont2.AddRowsM(1,False,0,0, "").AddCells12(1,"")
	cont2.BuildGrid ' IMPORTANT	
	
	' we can put anything in the container, so for the demo, let's use an ABMCard
	Dim tmpCard As ABMCard
	tmpCard.InitializeAsCard(page, "card1", DateTime.Date(DateTime.Now) & " " & DateTime.Time(DateTime.now), "This is a new animated card", ABM.CARD_LARGE, "whitetitle")
	tmpCard.Image = "../images2/16.jpg"
	tmpCard.AddAction("BUTTON 1")	
	' add the card
	cont2.Cell(1,1).AddComponent(tmpCard)
	
	page.Cell(7,1).AddComponent(cont2)
	
	' the blur effect	
	Dim btn2 As ABMButton
	btn2.InitializeRaised(page, "btn2", "", "", "Unblur", "bluegrey")
	btn2.Tag = "unblur"
	page.Cell(8,1).AddComponent(btn2)
		
	' create the container with animation	
	
	' you ALWAYS need an Initial state, duration should be 0 for the initial state
	Dim myAnim4 As ABMAnimation
	myAnim4.Initialize("initialblur", 0, ABM.TWEEN_EASEINQUAD)
	myAnim4.Opacity(0.0)
	myAnim4.Blur(20)
	page.AddAnimation(myAnim4)
	
	' we create an animation to 'unblur'
	Dim myAnim5 As ABMAnimation
	myAnim5.Initialize("unblur", 500, ABM.TWEEN_EASEINQUAD)
	myAnim5.Opacity(1)
	myAnim5.Blur(0)
	page.AddAnimation(myAnim5)	
	
	' we create an animation to 'blur'
	Dim myAnim6 As ABMAnimation
	myAnim6.Initialize("blur", 500, ABM.TWEEN_EASEINQUAD)
	myAnim6.Opacity(0.0)
	myAnim6.Blur(20)
	page.AddAnimation(myAnim6)
	
	Dim cont3 As ABMContainer
	' new initialize method where you have to set your initial animation
	cont3.InitializeAnimated(page, "cont3", "initialblur", "")
	cont3.AddRowsM(1,False,0,0, "").AddCells12(1,"")
	cont3.BuildGrid ' IMPORTANT	
	
	Dim codeBlock As String = $"// the blur effect	
Dim btn2 As ABMButton
btn2.InitializeRaised(page, "btn2", "", "", "Unblur", "bluegrey")
btn2.Tag = "unblur"
page.Cell(8,1).AddComponent(btn2)
	
// create the container with animation	

// you ALWAYS need an Initial state, duration should be 0 for the initial state
Dim myAnim4 As ABMAnimation
myAnim4.Initialize("initialblur", 0, ABM.TWEEN_EASEINQUAD)
myAnim4.Opacity(0.0)
myAnim4.Blur(20)
page.AddAnimation(myAnim4)

// we create an animation to 'unblur'
Dim myAnim5 As ABMAnimation
myAnim5.Initialize("unblur", 500, ABM.TWEEN_EASEINQUAD)
myAnim5.Opacity(1)
myAnim5.Blur(0)
page.AddAnimation(myAnim5)	

// we create an animation to 'blur'
Dim myAnim6 As ABMAnimation
myAnim6.Initialize("blur", 500, ABM.TWEEN_EASEINQUAD)
myAnim6.Opacity(0.0)
myAnim6.Blur(20)
page.AddAnimation(myAnim6)

Dim cont3 As ABMContainer
// new initialize method where you have to set your initial animation
cont3.InitializeAnimated(page, "cont3", "initialblur", "")
cont3.AddRowsM(1,False,0,0, "").AddCells12(1,"")
cont3.BuildGrid // IMPORTANT	

Dim codeBlock As String = "..."

cont3.Cell(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "codeblock", codeBlock))

page.Cell(9,1).AddComponent(cont3)"$

	cont3.Cell(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "codeblock", codeBlock))
	
	page.Cell(9,1).AddComponent(cont3)
	
	page.Cell(10,1).AddComponent(ABMShared.BuildParagraph(page,"par8","Using the AnimationFinished event and the RunAnimation method, you can control what must be animated:"))
	
	Dim codeBlock2 As String = $"Sub cont3_AnimationFinished(Target As String, lastAnimation As String)
	Log("Animation finished: " & lastAnimation)
	Select Case lastAnimation
		Case "unblur"
			Dim btn2 As ABMButton = page.Component("btn2")	
			btn2.Tag = "blur"		
			btn2.Text = "Blur"
			btn2.Refresh	
		Case "blur"
			Dim btn2 As ABMButton = page.Component("btn2")
			btn2.Tag = "unblur"
			btn2.Text = "Unblur"
			btn2.Refresh
			// reset to start position
			Dim cont3 As ABMContainer = page.Component("cont3")
			cont3.RunAnimation("initialblur")
	End Select
End Sub"$
	
	page.Cell(11,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "codeblock2", codeBlock2))
		
	Dim codeBlock3 As String = $"Sub btn2_Clicked(Target As String)
	Dim btn2 As ABMButton = page.Component("btn2")	
	Dim cont3 As ABMContainer = page.Component("cont3")
	
	Select Case btn2.Tag
		Case "unblur"
			cont3.RunAnimation("unblur")			
		Case "blur"		
			cont3.RunAnimation("blur")	
	End Select	
End Sub"$
	
	page.Cell(12,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "codeblock3", codeBlock3))	
	
	' also add the components to the footer
	ABMShared.ConnectFooter(page)
	
	page.Refresh ' IMPORTANT
		
	' NEW, because we use ShowLoaderType=ABM.LOADER_TYPE_MANUAL
	page.FinishedLoading 'IMPORTANT
	
	page.RestoreNavigationBarPosition
End Sub

Sub cont2_AnimationFinished(Target As String, lastAnimation As String)
	Log("Animation finished: " & lastAnimation)
	Select Case lastAnimation
		Case "animin"
			Dim btn1 As ABMButton = page.Component("btn1")	
			btn1.Tag = "animout"		
			btn1.Text = "Slide card OUT"
			btn1.Refresh	
		Case "animout"
			Dim btn1 As ABMButton = page.Component("btn1")
			btn1.Tag = "animin"
			btn1.Text = "Slide card IN"
			btn1.Refresh
			' reset to start position
			Dim cont2 As ABMContainer = page.Component("cont2")
			cont2.RunAnimation("initial")
	End Select
End Sub

Sub btn1_Clicked(Target As String)
	Dim btn1 As ABMButton = page.Component("btn1")	
	Dim cont2 As ABMContainer = page.Component("cont2")
	
	Select Case btn1.Tag
		Case "animin"
			cont2.RunAnimation("animin")			
		Case "animout"		
			cont2.RunAnimation("animout")	
	End Select	
End Sub

Sub cont3_AnimationFinished(Target As String, lastAnimation As String)
	Log("Animation finished: " & lastAnimation)
	Select Case lastAnimation
		Case "unblur"
			Dim btn2 As ABMButton = page.Component("btn2")	
			btn2.Tag = "blur"		
			btn2.Text = "Blur"
			btn2.Refresh	
		Case "blur"
			Dim btn2 As ABMButton = page.Component("btn2")
			btn2.Tag = "unblur"
			btn2.Text = "Unblur"
			btn2.Refresh
			' reset to start position
			Dim cont3 As ABMContainer = page.Component("cont3")
			cont3.RunAnimation("initialblur")
	End Select
End Sub

Sub btn2_Clicked(Target As String)
	Dim btn2 As ABMButton = page.Component("btn2")	
	Dim cont3 As ABMContainer = page.Component("cont3")
	
	Select Case btn2.Tag
		Case "unblur"
			cont3.RunAnimation("unblur")			
		Case "blur"		
			cont3.RunAnimation("blur")	
	End Select	
End Sub

Sub btn3_Clicked(Target As String)
	'Dim contIN As ABMContainer = page.Component("contIN")
	
	'contIN.BringMeIn
End Sub

' clicked on the navigation bar
Sub Page_NavigationbarClicked(Action As String, Value As String)
	page.SaveNavigationBarPosition	
	If Action = "ABMContainer" Then Return
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
