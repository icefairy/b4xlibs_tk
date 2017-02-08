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
	Public Name As String = "GettingStartedPage"
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
	
End Sub

public Sub BuildPage()
	' initialize the theme
	BuildTheme
	
	' initialize this page using our theme
	page.InitializeWithTheme(Name, "/ws/" & ABMshared.AppName & "/" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)
	page.ShowLoader=True
	page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW
	page.PageTitle = "Getting Started"
	page.PageDescription = "Getting started with ABMaterial"	
	page.PageHTMLName = "abmaterial-getting-started.html"
	page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization"
	page.PageSiteMapPriority = "0.50"
	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY
	page.UseGoogleAnalytics(ABMShared.TrackingID, Null) ' IMPORTANT Change this to your own TrackingID !!!!!!!
		
	ABMShared.BuildNavigationBar(page, "Getting Started", "../images/logo.png", "", "GettingStarted", "")
		
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
	
	' add a header label
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr1", "Setup"))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par1","In the ABMaterial folder you'll find three folders: {B}Library{/B}, {B}Demo{/B} and {B}Template{/B}. Demo is the source code of this app and a great resource to get started with ABMaterial.") )
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par2","First, copy both {B}ABMaterial.jar{/B} and {B}ABMaterial.xml{/B} from the Library folder to your {B}B4J libraries folder{/B}. Congratulations, you've successfully installed ABMaterial for B4J!"))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par3","Next, make a {B}copy of the Templates{/B} folder and {B}rename{/B} it to the name of your new app. Go into the folder and rename both Template.b4j and Template.b4j.meta to your apps name. e.g. Template.b4j -> MyApp.b4j and Template.b4j.meta -> MyApp.b4j.meta.  Now you are ready to write your ABMaterial Web App!"))
	
	' add a header label
	page.Cell(1,1).AddComponent(ABMShared.BuildHeader(page,"hdr2", "First things to do in B4J when you start a new App"))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par4","The first things you want to do is personalize your app.  There are a couple of things that are needed {B}(Nx){/B}, and some optional {B}(Ox){/B}.") )
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par5","{B}(N1){/B}: In B4J, Go to Project -> Build Configurations and {B}change the package name{/B}.") )
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par6","{B}(N2){/B}: In {B}ABMApplication{/B} change the variables {B}Title{/B} and {B}Description{/B} to describe your app.  They are the ones that will be shown in the browsers tab.") )
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par7","{B}(N3){/B}: Change the variable {B}AppName{/B} to the name of your app (case sensitive!).  Go into the {B}ABMPageTemplate class{/B} and set the {B}AppName{/B} variable to EXACTLY the same."))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par8","{B}(N4){/B}: Create a {B}new class{/B}: Project -> Add New Module -> Class Module -> Server WebSocket and name it (e.g. 'MyFirstPage').  {B}Copy all the code{/B} from {B}ABMTemplatePage{/B} into your newly created class and change the {B}Name{/B} variable to the name you gave the new class.  In our example 'MyFirstPage' (case sensitive!)."))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par9","{B}(N5){/B}: Go back to {B}ABMApplication{/B} and change the variable {B}InitialPage{/B} to your newly created page.  In our example 'MyFirstPage'."))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par9","{B}(O1){/B}: You can optionally set some Application icons with different sizes in the Initialize method of ABMApplication. Check the demo app for some examples."))
	' add paragraph	
	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page,"par10","{B}(N6){/B}: So all we have to do now is adding the new page to the App.  In the {B}Main module{/B}, create an instance of your new page, initialize it and add it to the app. (you can remove the example code lines talking about ABMPageTemplate)."))
	
	Dim code As String = $"// create the pages
Dim myPage As MyFirstPage
myPage.Initialize	
	
// add the pages to the app
myApp.AddPage(myPage.Page)"$
	
	page.Cell(2,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, "code1", code))
	
	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par11","{B}(O2){/B}: It is best to run the program now for the first time.  All needed folders will be created for you in the www folder.  E.g. the images folder where you can put all your images needed in your pages. Open up your file explorer and check the folder structure and files it created to get familiar with how ABMaterial apps are build. Note there is a file called {B}donotdelete.conn{/B}.  Well, do not delete this file.  It's an empty file that is used to {B}check your connection{/B} from the browser to your server.  If there is no connection (it cannot download this file), then the app can react in a more user friendly way."))
	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par12","{B}That is it.{/B}  You can start creating ABMaterial WebApps! For every new page you want to make, just repeat steps {B}(N4){/B} through {B}(N6){/B}. I explained this procedure in depth, but you will see this will come very naturally to do when you are building your own app."))
	' add paragraph	
	page.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page,"par13","Next, read the Themes section to get a basic understanding of how you can use themes to uniformize your WebApp!"))		
	
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
