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
	Public Name As String = "HelperModalSheetPage"
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
		' bluegray button
	theme.AddButtonTheme("bluegrey")
	theme.Button("bluegrey").BackColor = ABM.COLOR_BLUEGREY
	theme.Button("bluegrey").BackColorIntensity = ABM.INTENSITY_DARKEN1
	
	' modal sheet
	theme.AddContainerTheme("modalcontent")
	theme.Container("modalcontent").BackColor = ABM.COLOR_WHITE	
	
	' modal sheet
	theme.AddContainerTheme("modalfooter")
	theme.Container("modalfooter").BackColor = ABM.COLOR_LIGHTBLUE
	
	' another toast theme
	theme.AddToastTheme("toastgreen")
	theme.Toast("toastgreen").Rounded = True
	theme.Toast("toastgreen").BackColor = ABM.COLOR_GREEN
	theme.Toast("toastgreen").BackColorIntensity = ABM.INTENSITY_DARKEN2	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMShared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True	
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "ABMModalSheet"
	page.PageDescription = "The modal sheet helper"	
	page.PageHTMLName = "abmaterial-modal-sheet.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "ABMModalSheet", "../images/logo.png", "", "Helpers", "ABMModalSheet")
		
	' create the page grid
	page.AddRows(7,True, "").AddCells12(1,"")
	page.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	'page.NeedsGoogleMap = True
	page.GoogleMapsAPIExtras = "key=AIzaSyCXb4vvFQBYeZVydJ7HQo_I1_mpvOOUs38&libraries=places"
	
	page.AddCanvasImage("background", "../images/background.jpg")
		
	ABMShared.BuildFooter(page)
End Sub

Sub ConnectPage()
	'NEW
	ABMShared.ConnectNavigationBar(page)
	
	' add a modal sheet template to enter contact information
	page.AddModalSheetTemplate(BuildModalSheet)
	
	' add a error box template if the name is not entered
	page.AddModalSheetTemplate(BuildWrongInputModalSheet)
	
	' add a modal sheet with a fixed footer
	page.AddModalSheetTemplate(BuildFixedFooterSheet)
	
	' add a modal button sheet
	page.AddModalSheetTemplate(BuildBottomSheet)
	
	' add paragraph
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","An ABMModalSheet component is like a mini ABMPage helper, but it pops up over the existing page.  It has two ABMContainers, one that makes up the header and one for the footer section, so you can use everyting an ABMContainer can.") )
	
	' add paragraph
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","ABMModalSheets and itscomponents have to be added to the page in the PageBuild() method. You can the later load the sheet and modify the content before you open it."))
	
'		'	Dim combo1 As ABMCombo
'	Dim combo1 As ABMCombo
'	combo1.Initialize(page, "combo1", "Select a {B}person{/B}", 650, "")	
'	combo1.IconName = "mdi-action-account-circle"
'	
'	' add items
'	combo1.AddItem("combo1S1", "Mom", BuildSimpleItem("S1", "mdi-action-account-circle", "{NBSP}{NBSP}Mom"))
'	combo1.AddItem("combo1S2", "Dad", BuildSimpleItem("S2", "mdi-action-account-circle", "{NBSP}{NBSP}Dad"))
'	combo1.AddItem("combo1S3", "Brother", BuildSimpleItem("S3", "mdi-action-dashboard", "{NBSP}{NBSP}Brother"))
'	combo1.AddItem("combo1S4", "Sister", BuildSimpleItem("S4", "mdi-action-dashboard", "{NBSP}{NBSP}Sister"))
'	
'	page.Cell(1,1).AddComponent(combo1)
	
	' add button
	Dim btn1 As ABMButton
	btn1.InitializeRaised(page, "btn1", "", "", "Open Modal Sheet", "bluegrey")
	page.Cell(2,1).AddComponent(btn1)
	
	' add paragraph
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par3","If you were to hasty and did not enter your name when you pressed ok, you will have noticed two features of the ABMModalSheet with the Error box: cascading modal sheets and dismissable. Modal sheets can indeed come on top of each other. This is usefull for e.g. showing a message to the user when he/she did something wrong."))
	' add paragraph
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par4", "Depending on you setting the sheets property {B}IsDismissible{/B} to true or false, a sheet can be dismissed if the user clicks outside the box into the darkened area."))
	
	' add a sub header label
	page.Cell(4,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Modals with Fixed Footer"))
	' add paragraph
	page.Cell(4,1).AddComponent(ABMShared.BuildParagraph(page,"par5", "If you have content that is very long and you want the action buttons to be visible all the time, you can set the FixedFooter to true parameter in the Initialize to the modal."))
		
	' add button
	Dim btn2 As ABMButton
	btn2.InitializeRaised(page, "btn2", "", "", "Open Modal Sheet", "bluegrey")
	page.Cell(5,1).AddComponent(btn2)
	
	' add a sub header label
	page.Cell(6,1).AddComponent(ABMShared.BuildHeader(page,"hdr2", "Bottom Model Sheets"))
	' add paragraph
	page.Cell(6,1).AddComponent(ABMShared.BuildParagraph(page,"par6", "Bottom Sheet Modals are good for displaying actions to the user on the bottom of a screen. They still act the same as regular modals."))
		
	' add button
	Dim btn3 As ABMButton
	btn3.InitializeRaised(page, "btn3", "", "", "Open Modal Sheet", "bluegrey")
	page.Cell(7,1).AddComponent(btn3)
	
	
	
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
	If Action = "ABMModalSheet" Then Return
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
'	Dim combo1 As ABMCombo = page.Component("combo1")
'	combo1.Valid = ABM.VALID_FALSE
'	combo1.PlaceHolderText = "Test PlaceHolder test"
'	combo1.WrongMessage = "My Wrong Message"
'	combo1.Refresh 	
'	Return
	
	Dim myModal As ABMModalSheet = page.ModalSheet("myModal")
	Dim googleInp As ABMInput = myModal.Content.Component("googleInp")
	googleInp.Text = ""
	Dim Inp1 As ABMInput = myModal.Content.Component("Inp1")
	Inp1.Text = ""
	Dim Inp2 As ABMInput = myModal.Content.Component("Inp2")
	Inp2.Text = ""
	Dim Inp3 As ABMInput = myModal.Content.Component("Inp3")
	Inp3.Text = ""
	Dim Inp4 As ABMInput = myModal.Content.Component("Inp4")
	Inp4.Text = ""
	Dim Inp5 As ABMInput = myModal.Content.Component("Inp5")
	Inp5.Text = ""
	Dim Inp6 As ABMInput = myModal.Content.Component("Inp6")
	Inp6.Text = ""
	
	page.ShowModalSheet("myModal")	
End Sub

Sub btn2_Clicked(Target As String)	
	page.ShowModalSheet("fixedsheet")
End Sub

Sub btn3_Clicked(Target As String)	
	page.ShowModalSheet("bottomsheet")
End Sub

Sub BuildModalSheet() As ABMModalSheet
	Dim myModal As ABMModalSheet
	myModal.Initialize(page, "myModal", False, False, "")
	myModal.Content.UseTheme("modalcontent")
	myModal.Footer.UseTheme("modalfooter")
	myModal.IsDismissible = False
	
	' create the grid for the content
	myModal.Content.AddRows(1,True, "").AddCells12(1,"")
	myModal.Content.AddRows(2,True, "").AddCellsOS(2,0,0,0,6,6,6,"") 
	myModal.Content.AddRows(5,True, "").AddCells12(1,"")
	myModal.Content.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' add paragraph	
	myModal.Content.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","Enter your info so we can contact you later") )
	
	Dim googleInp As ABMInput
	googleInp.Initialize(page, "googleInp", ABM.INPUT_TEXT, "Search Address via Google", False, "")
	googleInp.AutoCompleteType = ABM.AUTOCOMPLETE_GOOGLE
	myModal.Content.Cell(1,1).AddComponent(googleInp)
	
	' create the input fields for the content
	Dim inp1 As ABMInput
	inp1.Initialize(page, "inp1", ABM.INPUT_TEXT, "Street", False, "")
	inp1.PlaceHolderText = "Streetname"
	myModal.Content.Cell(2,1).AddComponent(inp1)
	
	Dim inp2 As ABMInput
	inp2.Initialize(page, "inp2", ABM.INPUT_TEXT, "Number", False, "")
	myModal.Content.Cell(2,2).AddComponent(inp2)
	
	Dim inp3 As ABMInput
	inp3.Initialize(page, "inp3", ABM.INPUT_TEXT, "Postal Number", False, "")
	myModal.Content.Cell(3,1).AddComponent(inp3)
	
	Dim inp4 As ABMInput
	inp4.Initialize(page, "inp4", ABM.INPUT_TEXT, "City", False, "")
	myModal.Content.Cell(3,2).AddComponent(inp4)
	
	Dim inp5 As ABMInput
	inp5.Initialize(page, "inp5", ABM.INPUT_TEXT, "Country", False, "")
	myModal.Content.Cell(4,1).AddComponent(inp5)
	
	Dim inp6 As ABMInput
	inp6.Initialize(page, "inp6", ABM.INPUT_TEXT, "Location", False, "")
	myModal.Content.Cell(5,1).AddComponent(inp6)
	
	googleInp.SetGoogleAutocompleteResultInputComponent(inp1, ABM.GOOGLE_AUTOCOMLETE_RESULTTYPE_STREETNAME)
	googleInp.SetGoogleAutocompleteResultInputComponent(inp2, ABM.GOOGLE_AUTOCOMLETE_RESULTTYPE_STREETNUMBER)
	googleInp.SetGoogleAutocompleteResultInputComponent(inp3, ABM.GOOGLE_AUTOCOMLETE_RESULTTYPE_POSTALCODE)
	googleInp.SetGoogleAutocompleteResultInputComponent(inp4, ABM.GOOGLE_AUTOCOMLETE_RESULTTYPE_CITY)
	googleInp.SetGoogleAutocompleteResultInputComponent(inp5, ABM.GOOGLE_AUTOCOMLETE_RESULTTYPE_COUNTRY)
	googleInp.SetGoogleAutocompleteResultInputComponent(inp6, ABM.GOOGLE_AUTOCOMLETE_RESULTTYPE_LOCATION)
	
	' add a editor on the row
	Dim editor As ABMEditor
	editor.Initialize(page, "editor", True, True, "editor")
	myModal.Content.Cell(6,1).AddComponent(editor)
	
	Dim rbgroup As ABMRadioGroup
    rbgroup.Initialize( page, "rbgroup", "")
    rbgroup.AddRadioButton("Posibility 1", True)
    rbgroup.AddRadioButton("Posibility 2", True)
	rbgroup.SetActive(1)
	myModal.Content.Cell(1,1).AddComponent(rbgroup)
	
'	Dim combo1 As ABMCombo
'	combo1.Initialize(page, "combo1", "Select a {B}person{/B}", 650, "")		
'	combo1.IconName = "mdi-action-account-circle"
'	
'	' add items
'	combo1.AddItem("combo1S1", "Mom", BuildSimpleItem("S1", "mdi-action-account-circle", "{NBSP}{NBSP}Mom"))
'	combo1.AddItem("combo1S2", "Dad", BuildSimpleItem("S2", "mdi-action-account-circle", "{NBSP}{NBSP}Dad"))
'	combo1.AddItem("combo1S3", "Brother", BuildSimpleItem("S3", "mdi-action-dashboard", "{NBSP}{NBSP}Brother"))
'	combo1.AddItem("combo1S4", "Sister", BuildSimpleItem("S4", "mdi-action-dashboard", "{NBSP}{NBSP}Sister"))
'	
'	myModal.Content.Cell(1,1).AddComponent(combo1)
	
'	Dim fileinput As ABMFileInput
'    fileinput.Initialize(page,"fileinput","upload","select",False,"","")
'    myModal.Content.Cell(6,1).AddComponent(fileinput)	
	
	
	' create the grid for the footer
	' we add a row without the default 20px padding so we need to use AddRowsM().  If we do not use this method, a scrollbar will appear to the sheet.
	myModal.Footer.AddRowsM(1,True,0,0, "").AddCellsOS(1,6,6,6,3,3,3,"").AddCellsOS(1,0,0,0,3,3,3, "")
	myModal.Footer.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' create the buttons for the footer
	Dim msbtn1 As ABMButton
	msbtn1.InitializeFlat(page, "msbtn1", "", "", "OK", "transparent")
	myModal.Footer.Cell(1,1).AddComponent(msbtn1)
	
	Dim msbtn2 As ABMButton
	msbtn2.InitializeFlat(page, "msbtn2", "", "", "CANCEL", "transparent")
	myModal.Footer.Cell(1,2).AddComponent(msbtn2)
	
	Return myModal
End Sub

'Sub BuildSimpleItem(id As String, icon As String, Title As String) As ABMLabel
'	Dim lbl As ABMLabel
'	If icon <> "" Then
'		lbl.Initialize(page, id, Title, ABM.SIZE_H6, True, "header")
'	Else
'		lbl.Initialize(page, id, Title, ABM.SIZE_H6, True, "")
'	End If
'	lbl.VerticalAlign = True
'	lbl.IconName = icon
'	Return lbl
'End Sub

Sub canvas1_CanvasDown(x As Int, y As Int)
	Log("X: " & x & " y:" & y)
End Sub

Sub BuildWrongInputModalSheet() As ABMModalSheet
	Dim myModalError As ABMModalSheet
	myModalError.Initialize(page, "wronginput", False, False, "")
	myModalError.Content.UseTheme("modalcontent")
	myModalError.Footer.UseTheme("modalcontent")
	myModalError.IsDismissible = True
	
	' create the grid for the content
	myModalError.Content.AddRows(1,True, "").AddCells12(1,"")	
	myModalError.Content.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, "contlbl1", "errormessage",ABM.SIZE_PARAGRAPH, False, "")
	myModalError.Content.Cell(1,1).AddComponent(lbl1)
	
	Return myModalError
End Sub



Sub BuildBottomSheet() As ABMModalSheet
	Dim myBottomModal As ABMModalSheet
	myBottomModal.Initialize(page, "bottomsheet", False, True, "")
	myBottomModal.Content.UseTheme("modalcontent")
	myBottomModal.Footer.UseTheme("modalcontent")
	myBottomModal.IsDismissible = True
	
	' create the grid for the content
	myBottomModal.Content.AddRows(1,True, "").AddCells12(1,"")	
	myBottomModal.Content.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' create list
	Dim list1 As ABMList
	list1.Initialize(page, "list1", ABM.COLLAPSE_ACCORDION, "")
	
	' add items	
	list1.AddItem("S1", BuildItem("S1", "Mom", "2", False))
	list1.AddItem("S2", BuildItem("S2", "Dad", "7", True))
	list1.AddItem("S3", BuildItem("S3", "Brother", "", False))
	list1.AddItem("S4", BuildItem("S4", "Sister", "3", False))
	
	myBottomModal.Content.Cell(1,1).AddComponent(list1)
	
	Return myBottomModal	
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

Sub msbtn1_Clicked(Target As String)	
	Dim mymodal As ABMModalSheet = page.ModalSheet("myModal")
	
	Dim inp1 As ABMInput = mymodal.Content.Cell(2,1).Component("inp1")
	Dim YourName As String = inp1.Text
	If YourName = "" Then
		Dim mymodalError As ABMModalSheet = page.ModalSheet("wronginput")
		Dim myModalLbl As ABMLabel= mymodalError.Content.Component("contlbl1")
				
		myModalLbl.Text = "Enter at least your first name!"
				
		page.ShowModalsheet("wronginput")
		Return
	End If
	
	page.CloseModalSheet("myModal")
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastgreen", "We will contact you, " & YourName & "!", 5000)		
End Sub

Sub msbtn2_Clicked(Target As String)
	page.CloseModalSheet("myModal")
	myToastId = myToastId + 1	
	page.ShowToast("toast" & myToastId, "toastred", "You cancelled the contact form!", 5000)		
End Sub

Sub BuildFixedFooterSheet() As ABMModalSheet
	Dim myModal As ABMModalSheet
	myModal.Initialize(page, "fixedsheet", True, False, "")
	myModal.Content.UseTheme("modalcontent")
	myModal.Footer.UseTheme("modalfooter")
	myModal.IsDismissible = False
	
	' create the grid for the content
	myModal.Content.AddRows(1,True, "").AddCells12(1,"")	
	myModal.Content.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	Dim Message As String = $"HOW ROBIN HOOD BECAME AN OUTLAW{BR}
List and hearken, gentlemen,
That be of free-born blood,
I shall you tell of a good yeoman, His name was Robin Hood.{BR}
Robin was a proud outlaw,
While as he walked on the ground. So courteous an outlaw as he was one Was never none else found.{BR}
In the days of good King Harry the Second of England--he of the warring sons--there were certain forests in the north country set aside for the King's hunting, and no man might shoot deer therein under penalty of death. These forests were guarded by the King's Foresters, the chief of whom, in each wood, was no mean man but equal in authority to the Sheriff in his walled town, or even to my lord Bishop in his abbey.
One of the greatest of royal preserves was Sherwood and Barnesdale forests near the two towns of Nottingham and Barnesdale. Here for some years dwelt one Hugh Fitzooth as Head Forester, with his good wife and son Robert. The boy had been born in Lockesley town--in the year 1160, stern records say--and was often called Lockesley, or Rob of Lockesley. He was a comely, well-knit stripling, and as soon as he was strong enough to walk his chief delight was to go with his father into the forest. As soon as his right arm received thew and sinew he learned to draw the long bow and speed a true arrow. While on winter evenings his greatest joy was to hear his father tell of bold Will o' the Green, the outlaw, who for many summers defied the King's Foresters and feasted with his men upon King's deer. And on other stormy days the boy learned to whittle out a straight shaft for the long bow, and tip it with gray goose feathers.
The fond mother sighed when she saw the boy's face light up at these woodland tales. She was of gentle birth, and had hoped to see her son famous at court or abbey. She taught him to read and to write, to doff his cap without awkwardness and to answer directly and truthfully both lord and peasant. But the boy, although he took kindly to these lessons of breeding, was yet happiest when he had his beloved bow in hand and strolled at will, listening to the murmur of the trees.
Two playmates had Rob in these gladsome early days. One was Will Gamewell, his father's brother's son, who lived at Gamewell Lodge, hard by Nottingham town. The other was Marian Fitzwalter, only child of the Earl of Huntingdon. The castle of Huntingdon could be seen from the top of one of the tall trees in Sherwood; and on more than one bright day Rob's white signal from this tree told Marian that he awaited her there: for you must know that Rob did not visit her at the castle. His father and her father were enemies. Some people whispered that Hugh Fitzooth was the rightful Earl of Huntingdon, but that he had been defrauded out of his lands by Fitzwalter, who had won the King's favor by a crusade to the Holy Land. But little cared Rob or Marian for this enmity, however it had arisen. They knew that the great green--wood was open to them, and that the wide, wide world was full of the scent of flowers and the song of birds.
Days of youth speed all too swiftly, and troubled skies come all too soon. Rob's father had two other enemies besides Fitzwalter, in the persons of the lean Sheriff of Nottingham and the fat Bishop of Hereford. These three enemies one day got possession of the King's ear and whispered therein to such good--or evil--purpose that Hugh Fitzooth was removed from his post of King's Forester. He and his wife and Rob, then a youth of nineteen, were descended upon, during a cold winter's evening, and dispossessed without warning. The Sheriff arrested the Forester for treason--of which, poor man, he was as guiltless as you or I--and carried him to Nottingham jail. Rob and his mother were sheltered over night in the jail, also, but next morning were roughly bade to go about their business. Thereupon they turned for succor to their only kinsman, Squire George of Gamewell, who sheltered them in all kindness.
But the shock, and the winter night's journey, proved too much for Dame Fitzooth. She had not been strong for some time before leaving the forest. In less than two months she was no more. Rob felt as though his heart was broken at this loss. But scarcely had the first spring flowers begun to blossom upon her grave, when he met another crushing blow in the loss of his father. That stern man had died in prison before his accusers could agree upon the charges by which he was to be brought to trial.
Two years passed by. Rob's cousin Will was away at school; and Marian's father, who had learned of her friendship with Rob, had sent his daughter to the court of Queen Eleanor. So these years were lonely ones to the orphaned lad. The bluff old Squire was kind to him, but secretly could make nothing of one who went about brooding and as though seeking for something he had lost. The truth is that Rob missed his old life in the forest no less than his mother's gentleness, and his father's companionship. Every time he twanged the string of the long bow against his shoulder and heard the gray goose shaft sing, it told him of happy days that he could not recall.
One morning as Rob came in to breakfast, his uncle greeted him with, "I have news for you, Rob, my lad!" and the hearty old Squire finished his draught of ale and set his pewter tankard down with a crash.
"What may that be, Uncle Gamewell?" asked the young man.
"Here is a chance to exercise your good long bow and win a pretty prize. The Fair is on at Nottingham, and the Sheriff proclaims an archer's tournament. The best fellows are to have places with the King's Foresters, and the one who shoots straightest of all will win for prize a olden arrow--a useless bauble enough, but just the thing for your lady love, eh, Rob my boy?" Here the Squire laughed and whacked the table again with his tankard.
Rob's eyes sparkled. "'Twere indeed worth shooting for, uncle mine," he said. "I should dearly love to let arrow fly alongside another man. And a place among the Foresters is what I have long desired. Will you let me try?"
"To be sure," rejoined his uncle. "Well I know that your good mother would have had me make a clerk of you; but well I see that the greenwood is where you will pass your days. So, here's luck to you in the bout!" And the huge tankard came a third time into play.
The young man thanked his uncle for his good wishes, and set about making preparations for the journey. He traveled lightly; but his yew bow must needs have a new string, and his cloth-yard arrows must be of the straightest and soundest.
One fine morning, a few days after, Rob might have been seen passing by way of Lockesley through Sherwood Forest to Nottingham town. Briskly walked he and gaily, for his hopes were high and never an enemy had he in the wide world. But 'twas the very last morning in all his life when he was to lack an enemy! For, as he went his way through Sherwood, whistling a blithe tune, he came suddenly upon a group of Foresters, making merry beneath the spreading branches of an oak-tree. They had a huge meat pie before them and were washing down prodigious slices of it with nut brown ale.
One glance at the leader and Rob knew at once that he had found an enemy. 'Twas the man who had usurped his father's place as Head Forester, and who had roughly turned his mother out in the snow. But never a word said he for good or bad, and would have passed on his way, had not this man, clearing his throat with a huge gulp, bellowed out: "By my troth, here is a pretty little archer! Where go you, my lad, with that tupenny bow and toy arrows? Belike he would shoot at Nottingham Fair! Ho! Ho!"
A roar of laughter greeted this sally. Rob flushed, for he was mightily proud of his shooting.
"My bow is as good as yours," he retorted, "and my shafts will carry as straight and as far. So I'll not take lessons of any of ye"'
They laughed again loudly at this, and the leader said with frown:
"Show us some of your skill, and if you can hit the mark here's twenty silver pennies for you. But if you hit it not you are in for a sound drubbing for your pertness."
"Pick your own target," quoth Rob in a fine rage. "I'll lay my head against that purse that I can hit it."
"It shall be as you say," retorted the Forester angrily, "your head for your sauciness that you hit not my target."
Now at a little rise in the wood a herd of deer came grazing by, distant full fivescore yards. They were King's deer, but at that distance seemed safe from any harm. The Head Forester pointed to them.
"If your young arm could speed a shaft for half that distance, I'd shoot with you."
"Done!" cried Rob. "My head against twenty pennies I'll cause yon fine fellow in the lead of them to breathe his last."
And without more ado he tried the string of his long bow, placed a shaft thereon, and drew it to his ear. A moment, and the quivering string sang death as the shaft whistled across the glade. Another moment and the leader of the herd leaped high in his tracks and fell prone, dyeing the sward with his heart's blood.
A murmur of amazement swept through the Foresters, and then a growl of rage. He that had wagered was angriest of all.
"Know you what you have done, rash youth?" he said. "You have killed a King's deer, and by the laws of King Harry your head remains forfeit. Talk not to me of pennies but get ye gone straight, and let me not look upon your face again."
Rob's blood boiled within him, and he uttered a rash speech. "I have looked upon your face once too often already, my fine Forester. 'Tis you who wear my father's shoes."
And with this he turned upon his heel and strode away.
The Forester heard his parting thrust with an oath. Red with rage he seized his bow, strung an arrow, and without warning launched it full af' Rob. Well was it for the latter that the Forester's foot turned on a twig at the critical instant, for as it was the arrow whizzed by his ear so close as to take a stray strand of his hair with it. Rob turned upon his assailant, now twoscore yards away.
"Ha!" said he. "You shoot not so straight as I, for all your bravado. Take this from the tupenny bow!"
Straight flew his answering shaft. The Head Forester gave one cry, then fell face downward and lay still. His life had avenged Rob's father, but the son was outlawed. Forward he ran through the forest, before the band could gather their scattered wits--still forward into the great greenwood. The swaying trees seemed to open their arms to the wanderer, and to welcome him home.
Toward the close of the same day, Rob paused hungry and weary at the cottage of a poor widow who dwelt upon the outskirts of the forest. Now this widow had often greeted him kindly in his boyhood days, giving him to eat and drink. So he boldly entered her door. The old dame was right glad to see him, and baked him cakes in the ashes, and had him rest and tell her his story. Then she shook her head.
"'Tis an evil wind that blows through Sherwood," she said. "The poor are despoiled and the rich ride over their bodies. My three sons have been outlawed for shooting King's deer to keep us from starving, and now hide in the wood. And they tell me that twoscore of as good men as ever drew bow are in hiding with them."
"Where are they, good mother?" cried Rob. "By my faith, I will join them."
"Nay, nay," replied the old woman at first. But when she saw that there was no other way, she said: "My sons will visit me to-night. Stay you here and see them if you must."
So Rob stayed willingly to see the widow's sons that night, for they were men after his own heart. And when they found that his mood was with them, they made him swear an oath of fealty, and told him the haunt of the band--a place he knew right well. Finally one of them said:
"But the band lacks a leader--one who can use his head as well as his hand. So we have agreed that he who has skill enough to go to Nottingham, an outlaw, and win the prize at archery, shall be our chief."
Rob sprang to his feet. "Said in good time!" cried he, "for I had started to that self-same Fair, and all the Foresters, and all the Sheriff's men in Christendom shall not stand between me and the center of their target!"
And though he was but barely grown he stood so straight and his eye flashed with such fire that the three brothers seized his hand and shouted:
"A Lockesley! a Lockesley! if you win the golden arrow you shall be chief of outlaws in Sherwood Forest!"
So Rob fell to planning how he could disguise himself to go to Nottingham town; for he knew that the Foresters had even then set a price on his head in the market-place.
It was even as Rob had surmised. The Sheriff of Nottingham posted a reward of two hundred pounds for the capture, dead or alive, of one Robert Fitzooth, outlaw. And the crowds thronging the streets upon that busy Fair day often paused to read the notice and talk together about the death of the Head Forester.
But what with wrestling bouts and bouts with quarter-staves, and wandering minstrels, there came up so many other things to talk about, that the reward was forgotten for the nonce, and only the Foresters and Sheriff's men watched the gates with diligence, the Sheriff indeed spurring them to effort by offers of largess. His hatred of the father had descended to the son.
The great event of the day came in the afternoon. It was the archer's contest for the golden arrow, and twenty men stepped forth to shoot. Among them was a beggar-man, a sorry looking fellow with leggings of different colors, and brown scratched face and hands. Over a tawny shock of hair he had a hood drawn, much like that of a monk. Slowly he limped to his place in the line, while the mob shouted in derision. But the contest was open to all comers, so no man said him nay.
Side by side with Rob--for it was he--stood a muscular fellow of swarthy visage and with one eye hid by a green bandage. Him also the crowd jeered, but he passed them by with indifference while he tried his bow with practiced hand.
A great crowd had assembled in the amphitheater enclosing the lists. All the gentry and populace of the surrounding country were gathered there in eager expectancy. The central box contained the lean but pompous Sheriff, his bejeweled wife, and their daughter, a supercilious young woman enough, who, it was openly hinted, was hoping to receive the golden arrow from the victor and thus be crowned queen of the day.
Next to the Sheriff's box was one occupied by the fat Bishop of Hereford; while in the other side was a box wherein sat a girl whose dark hair, dark eyes, and fair features caused Rob's heart to leap. 'Twas Maid Marian! She had come up for a visit from the Queen's court at London town, and now sat demurely by her father the Earl of Huntingdon. If Rob had been grimly resolved to win the arrow before, the sight of her sweet face multiplied his determination an hundredfold. He felt his muscles tightening into bands of steel, tense and true. Yet withal his heart would throb, making him quake in a most unaccountable way.
Then the trumpet sounded, and the crowd became silent while the herald announced the terms of the contest. The lists were open to all comers. The first target was to be placed at thirty ells distance, and all those who hit its center were allowed to shoot at the second target, placed ten ells farther off. The third target was to be removed yet farther, until the winner was proved. The winner was to receive the golden arrow, and a place with the King's Foresters. He it was also who crowned the queen of the day.
The trumpet sounded again, and the archers prepared to shoot. Rob looked to his string, while the crowd smiled and whispered at the odd figure he cut, with his vari-colored legs and little cape. But as the first man shot, they grew silent.
The target was not so far but that twelve out of the twenty contestants reached its inner circle. Rob shot sixth in the line and landed fairly, being rewarded by an approving grunt from the man with the green blinder, who shot seventh, and with apparent carelessness, yet true to the bull's-eye.
The mob cheered and yelled themselves hoarse at this even marksmanship. The trumpet sounded again, and a new target was set up at forty ells.
The first three archers again struck true, amid the loud applause of the onlookers; for they were general favorites and expected to win. Indeed 'twas whispered that each was backed by one of the three dignitaries of the day. The fourth and fifth archers barely grazed the center. Rob fitted his arrow quietly and with some confidence sped it unerringly toward the shining circle.
"The beggar! the beggar!" yelled the crowd; "another bull for the beggar!" In truth his shaft was nearer the center than any of the others. But it was not so near that "Blinder," as the mob had promptly christened his neighbor, did not place his shaft just within the mark. Again the crowd cheered wildly. Such shooting as this was not seen every day in Nottingham town.
The other archers in this round were disconcerted by the preceding shots, or unable to keep the pace. They missed one after another and dropped moodily back, while the trumpet sounded for the third round, and the target was set up fifty ells distant.
"By my halidom you draw a good bow, young master," said Rob's queer comrade to him in the interval allowed for rest. "Do you wish me to shoot first on this trial?"
"Nay," said Rob, "but you are a good fellow by this token, and if I win not, I hope you may keep the prize from yon strutters." And he nodded scornfully to the three other archers who were surrounded by their admirers, and were being made much of by retainers of the Sheriff, the Bishop, and the Earl. From them his eye wandered toward Maid Marian's booth. She had been watching him, it seemed, for their eyes met; then hers were hastily averted.
"Blinder's" quick eye followed those of Rob. "A fair maid, that," he said smilingly, "and one more worthy the golden arrow than the Sheriff's haughty miss."
Rob looked at him swiftly, and saw naught but kindliness in his glance.
"You are a shrewd fellow and I like you well," was his only comment.
Now the archers prepared to shoot again, each with some little care. The target seemed hardly larger than the inner ring had looked, at the first trial. The first three sped their shafts, and while they were fair shots they did not more than graze the inner circle.
Rob took his stand with some misgiving. Some flecking clouds overhead made the light uncertain, and a handful of wind frolicked across the range in a way quite disturbing to a bowman's nerves. His eyes wandered for a brief moment to the box wherein sat the dark-eyed girl. His heart leaped! she met his glance and smiled at him reassuringly. And in that moment he felt that she knew him despite his disguise and looked to him to keep the honor of old Sherwood. He drew his bow firmly and, taking advantage of a momentary lull in the breeze, launched the arrow straight and true-singing across the range to the center of the target.
"The beggar! the beggar! a bull! a bull!" yelled the fickle mob, who from jeering him were now his warm friends. "Can you beat that, Blinder?"
The last archer smiled scornfully and made ready. He drew his bow with ease and grace and, without seeming to study the course, released the winged arrow. Forward it leaped toward the target, and all eyes followed its flight. A loud uproar broke forth when it alighted, just without the center and grazing the shaft sent by Rob. The stranger made a gesture of surprise when his own eyes announced the result to him, but saw his error. He had not allowed for the fickle gust of wind which seized the arrow and carried it to one side. But for all that he was the first to congratulate the victor.
"I hope we may shoot again," quoth he. "In truth I care not for the golden bauble and wished to win it in despite of the Sheriff for whom I have no love. Now crown the lady of your choice." And turning suddenly he was lost in the crowd, before Rob could utter what it was upon his lips to say, that he would shoot again with him.
And now the herald summoned Rob to the Sheriff's box to receive the prize.
"You are a curious fellow enough," said the Sheriff, biting his lip coldly; "yet you shoot well. What name go you by?"
Marian sat near and was listening intently.
"I am called Rob the Stroller, my Lord Sheriff," said the archer.
Marian leaned back and smiled.
"Well, Rob the Stroller, with a little attention to your skin and clothes you would not be so bad a man," said the Sheriff. "How like you the idea of entering my service.
"Rob the Stroller has ever been a free man, my Lord, and desires no service."
The Sheriff's brow darkened, yet for the sake of his daughter and the golden arrow, he dissembled.
"Rob the Stroller," said he, "here is the golden arrow which has been offered to the best of archers this day. You are awarded the prize. See that you bestow it worthily."
At this point the herald nudged Rob and half inclined his head toward the Sheriff's daughter, who sat with a thin smile upon her lips. But Rob heeded him not. He took the arrow and strode to the next box where sat Maid Marian.
"Lady," he said, "pray accept this little pledge from a poor stroller who would devote the best shafts in his quiver to serve you."
"My thanks to you, Rob in the Hood," replied she with a roguish twinkle in her eye; and she placed the gleaming arrow in her hair, while the people shouted, "The Queen! the Queen!"
The Sheriff glowered furiously upon this ragged archer who had refused his service, taken his prize without a word of thanks, and snubbed his daughter. He would have spoken, but his proud daughter restrained him. He called to his guard and bade them watch the beggar. But Rob had already turned swiftly, lost himself in the throng, and headed straight for the town gate.
That same evening within a forest glade a group of men--some twoscore clad in Lincoln green--sat round a fire roasting venison and making merry. Suddenly a twig crackled and they sprang to their feet and seized their weapons.
"I look for the widow's sons," a clear voice said, "and I come alone."
Instantly the three men stepped forward.
"Tis Rob!" they cried; "welcome to Sherwood Forest, Rob!" And all the men came and greeted him; for they had heard his story.
Then one of the widow's sons, Stout Will, stepped forth and said:
"Comrades all, ye know that our band has sadly lacked a leader--one of birth, breeding, and skill. Belike we have found that leader in this young man. And I and my brothers have told him that the band would choose that one who should bring the Sheriff to shame this day and capture his golden arrow. Is it not so?"
The band gave assent.
Will turned to Rob. "What news bring you from Nottingham town?" asked he.
Rob laughed. "In truth I brought the Sheriff to shame for mine own pleasure, and won his golden arrow to boot. But as to the prize ye must e'en take my word, for I bestowed it upon a maid."
And seeing the men stood in doubt at this, he continued: "But I'll gladly join your band, and you take me, as a common archer. For there are others older and mayhap more skilled than I."
Then stepped one forward from the rest, a tall swarthy man. And Rob recognized him as the man with the green blinder; only this was now removed, and his freed eye gleamed as stoutly as the other one.
"Rob in the Hood--for such the lady called you," said he, "I can vouch for your tale. You shamed the Sheriff e'en as I had hoped to do; and we can forego the golden arrow since it is in such fair hands. As to your shooting and mine, we must let future days decide. But here I, Will Stutely, declare that I will serve none other chief save only you."
Then good Will Stutely told the outlaws of Rob's deeds, and gave him his hand of fealty. And the widow's sons did likewise, and the other members every one, right gladly; because Will Stutely had heretofore been the truest bow in all the company. And they toasted him in nut brown ale, and hailed him as their leader, by the name of Robin Hood. And he accepted that name because Maid Marian had said it.
By the light of the camp-fire the band exchanged signs and passwords. They gave Robin Hood a horn upon which he was to blow to summon them. They swore, also, that while they might take money and goods from the unjust rich, they would aid and befriend the poor and the helpless; and that they would harm no woman, be she maid, wife, or widow. They swore all this with solemn oaths, while they feasted about the ruddy blaze, under the greenwood tree.
{BR}
And that is how Robin Hood became an outlaw."$
	
	Dim lbl1 As ABMLabel
	lbl1.Initialize(page, "contlbl1", Message,ABM.SIZE_PARAGRAPH, False, "")
	myModal.Content.Cell(1,1).AddComponent(lbl1)
	
	' create the grid for the footer
	' we add a row without the default 20px padding so we need to use AddRowsM().
	myModal.Footer.AddRowsM(1,True,0,0, "").AddCellsOS(1,9,9,9,3,3,3,"")
	myModal.Footer.BuildGrid 'IMPORTANT once you loaded the complete grid AND before you start adding components
	
	' create the buttons for the footer
	Dim msbtn3 As ABMButton
	msbtn3.InitializeFlat(page, "msbtn3", "", "", "Close", "transparent")
	myModal.Footer.Cell(1,1).AddComponent(msbtn3)	
	
	Return myModal
End Sub

Sub msbtn3_Clicked(Target As String)
	page.CloseModalSheet("fixedsheet")			
End Sub
