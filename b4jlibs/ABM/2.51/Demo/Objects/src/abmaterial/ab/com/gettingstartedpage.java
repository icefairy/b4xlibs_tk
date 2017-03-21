package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class gettingstartedpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.gettingstartedpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.gettingstartedpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.object.WebSocket _ws = null;
public com.ab.abmaterial.ABMPage _page = null;
public com.ab.abmaterial.ABMTheme _theme = null;
public com.ab.abmaterial.ABMaterial _abm = null;
public String _name = "";
public String _abmpageid = "";
public int _mytoastid = 0;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 96;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 98;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 101;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 102;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 103;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 104;BA.debugLine="page.PageTitle = \"Getting Started\"";
_page.PageTitle = "Getting Started";
 //BA.debugLineNum = 105;BA.debugLine="page.PageDescription = \"Getting started with ABMa";
_page.PageDescription = "Getting started with ABMaterial";
 //BA.debugLineNum = 106;BA.debugLine="page.PageHTMLName = \"abmaterial-getting-started.h";
_page.PageHTMLName = "abmaterial-getting-started.html";
 //BA.debugLineNum = 107;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 108;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 109;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 110;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 112;BA.debugLine="ABMShared.BuildNavigationBar(page, \"Getting Start";
_abmshared._buildnavigationbar(_page,"Getting Started","../images/logo.png","","GettingStarted","");
 //BA.debugLineNum = 115;BA.debugLine="page.AddRows(5,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (5),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 116;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 121;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private ws As WebSocket 'ignore";
_ws = new anywheresoftware.b4j.object.WebSocket();
 //BA.debugLineNum = 5;BA.debugLine="Public page As ABMPage";
_page = new com.ab.abmaterial.ABMPage();
 //BA.debugLineNum = 7;BA.debugLine="Private theme As ABMTheme";
_theme = new com.ab.abmaterial.ABMTheme();
 //BA.debugLineNum = 9;BA.debugLine="Private ABM As ABMaterial 'ignore";
_abm = new com.ab.abmaterial.ABMaterial();
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"GettingStartedPage\"";
_name = "GettingStartedPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
String _s1 = "";
String _code = "";
 //BA.debugLineNum = 124;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 126;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 129;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Setup")));
 //BA.debugLineNum = 131;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","In the ABMaterial folder you'll find some folders: {B}Library{/B} and some {B}Demo{/B} Projects. The source code of this app is one of them and a great resource to get started with ABMaterial.")));
 //BA.debugLineNum = 133;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","First, copy all library files (like {B}ABMaterial.jar{/B} and {B}ABMaterial.xml{/B}) from the Library folder to your {B}B4J libraries folder{/B}. Congratulations, you've successfully installed ABMaterial for B4J!")));
 //BA.debugLineNum = 135;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","Next, make a {B}copy of the Templates{/B} folder and {B}rename{/B} it to the name of your new app. Go into the folder and rename both Template.b4j and Template.b4j.meta to your apps name. e.g. Template.b4j -> MyApp.b4j and Template.b4j.meta -> MyApp.b4j.meta.  Now you are ready to write your ABMaterial Web App!")));
 //BA.debugLineNum = 138;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr2","The flow of a running ABMaterial WebApp")));
 //BA.debugLineNum = 140;BA.debugLine="Dim s1 As String = $\"1.	You start compiled .jar f";
_s1 = ("1.	You start compiled .jar file on your server (e.g. {B}java -jar MyApp.jar{/B}){BR}\n"+"2.	A user loads the app in his browser (e.g. http://localhost:51042/MyApp).{BR}\n"+"3.	The WebApp redirects the user to {B}InitialPage{/B} defined in ABMApplication.{BR}\n"+"4.	If no session exists for this user, it enters the {B}ABMSessionCreator{/B} class.{BR}  \n"+"5.	A new instance of your page class is created (Initialize is called, we call the {B}BuildPage(){/B} method containing the GRID structure of our page).{BR}\n"+"6.	WebSocket_Connected is called when the DOM of the page in the browser is fully loaded:{BR}\n"+"{NBSP}{NBSP}{NBSP}{NBSP}{NBSP}{NBSP}If it is a {B}new session{/B}, we initialize the page object, call {B}ConnectPage(){/B} and save everything in the {B}cache{/B}.{BR}\n"+"{NBSP}{NBSP}{NBSP}{NBSP}{NBSP}{NBSP}If it is an {B}existing session{/B}, the page and all global variables are restored from the {B}cache{/B}.{BR}\n"+"7.	Everything is send to the Browser.  We finish this method by doing a {B}page.Refresh{/B} and tell the browser we’re done by calling {B}page.FinishedLoading{/B}.{BR}\n"+"8.	When the user leaves the page, a {B}beforeunload{/B} event is raised.{BR}\n"+"9.	{B}WebSocket_Disconnected{/B} is called.{BR}\n"+"10.	If no reconnection happens after some time, the session is destroyed by the server.  De {B}cache scavenger{/B} will do some cleanup.{BR}\n"+"");
 //BA.debugLineNum = 153;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4",_s1)));
 //BA.debugLineNum = 155;BA.debugLine="s1 = $\"If a user comes back to the app while the";
_s1 = ("If a user comes back to the app while the page is still in cache, it will continue with the cached page.   If the cached page is gone, the user is redirected to the entry point of the app.  Note that while the user is still connected with the internet, the browser will periodically send a ‘heartbeat’ to the server to keep the session ‘Alive’.");
 //BA.debugLineNum = 157;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par5",_s1)));
 //BA.debugLineNum = 159;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr3","The components of an ABMaterial WebApp")));
 //BA.debugLineNum = 160;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildSubHea";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader2(_page,"subhdr3","{B}{U}Main{/U}{/B}")));
 //BA.debugLineNum = 162;BA.debugLine="s1 = $\"The B4J app starting point.  Additional to";
_s1 = ("The B4J app starting point.  Additional to normal B4J initializations, this is the place where you create the ABMApplication and add your own WebApp pages.  Finally, you start the Server.");
 //BA.debugLineNum = 163;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par6",_s1)));
 //BA.debugLineNum = 165;BA.debugLine="Dim code As String = $\"//Non-UI application (cons";
_code = ("//Non-UI application (console / server application)\n"+"#Region  Project Attributes \n"+"	#CommandLineArgs:\n"+"	#MergeLibraries: True \n"+"#End Region");
 //BA.debugLineNum = 170;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code)));
 //BA.debugLineNum = 172;BA.debugLine="code = $\"Sub Process_Globals 	Public srvr As Serv";
_code = ("Sub Process_Globals\n"+"	Public srvr As Server	\n"+"End Sub");
 //BA.debugLineNum = 175;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code2",_code)));
 //BA.debugLineNum = 177;BA.debugLine="code = $\"Sub AppStart (Args() As String) 	// the";
_code = ("Sub AppStart (Args() As String)\n"+"	// the user needs to login\n"+"	ABMShared.NeedsAuthorization = True\n"+"\n"+"	// Build the Theme\n"+"	ABMShared.BuildTheme(\"mytheme\")\n"+"	\n"+"	// create the app\n"+"	Dim myApp As ABMApplication\n"+"	myApp.Initialize\n"+"		\n"+"	// create the pages\n"+"	Dim myPage As ABMPageTemplate\n"+"	myPage.Initialize	\n"+"	\n"+"	// add the pages to the app\n"+"	myApp.AddPage(myPage.Page)\n"+"	\n"+"	// start the server\n"+"	myApp.StartServer(srvr, \"srvr\", 51042)	\n"+"\n"+"	// optional if you want to redirect the logs to a file in release mode \n"+"	ABMShared.RedirectOutput(File.DirApp, \"logs.txt\")\n"+"	\n"+"	StartMessageLoop\n"+"End Sub");
 //BA.debugLineNum = 203;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code3",_code)));
 //BA.debugLineNum = 205;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildSubHea";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader2(_page,"subhdr4","{B}{U}ABMApplication{/U}{/B}")));
 //BA.debugLineNum = 206;BA.debugLine="s1 = $\"The ABMaterial application.  Here you can";
_s1 = ("The ABMaterial application.  Here you can set general properties for the WebApp.  In general, this does not need much changes and can be left as is.");
 //BA.debugLineNum = 207;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"para4",_s1)));
 //BA.debugLineNum = 208;BA.debugLine="s1 = $\"{B}IMPORTANT{/B}{BR} a.	Set the Initial st";
_s1 = ("{B}IMPORTANT{/B}{BR}\n"+"a.	Set the Initial starting page using the {B}InitialPage{/B} variable in Class_Globals{BR}\n"+"b.  Set the Application name ({U}do not use spaces or special characters!{/U}).  This is the entry point to your WebApp and all pages will be created under this.  You can use {B}ABMShared.AppName{/B} in the initialize() method.");
 //BA.debugLineNum = 211;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraphbq(_page,"paraBQ4",_s1)));
 //BA.debugLineNum = 213;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildSubHea";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader2(_page,"subhdr5","{B}{U}ABMSessionCreator{/U}{/B}")));
 //BA.debugLineNum = 214;BA.debugLine="s1 = $\"The ABMSessionCreator is a B4J filter whic";
_s1 = ("The ABMSessionCreator is a B4J filter which regulates a new websocket connection. No need to change anything.");
 //BA.debugLineNum = 215;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"para5",_s1)));
 //BA.debugLineNum = 217;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildSubHea";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader2(_page,"subhdr6","{B}{U}ABMUploadHandler{/U}{/B}")));
 //BA.debugLineNum = 218;BA.debugLine="s1 = $\"The ABMUploadHandler is a B4J Server Handl";
_s1 = ("The ABMUploadHandler is a B4J Server Handler that handles the uploads from the user. No need to change anything.");
 //BA.debugLineNum = 219;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"para6",_s1)));
 //BA.debugLineNum = 221;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildSubHea";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader2(_page,"subhdr7","{B}{U}ABMCacheScavenger{/U}{/B}")));
 //BA.debugLineNum = 222;BA.debugLine="s1 = $\"Its job is taking care of {B}scavenging th";
_s1 = ("Its job is taking care of {B}scavenging the cached pages{/B} to preserve memory in the server app. No need to change anything.");
 //BA.debugLineNum = 223;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"para7",_s1)));
 //BA.debugLineNum = 225;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildSubHea";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader2(_page,"subhdr8","{B}{U}ABMShared{/U}{/B}")));
 //BA.debugLineNum = 226;BA.debugLine="s1 = $\"A B4J module where code is shared between";
_s1 = ("A B4J module where code is shared between all users.  It can be useful to write general methods shortcuts to create a header, themes, or the navigation bar.  It also must contain the NavigateToPage method.");
 //BA.debugLineNum = 227;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"para8",_s1)));
 //BA.debugLineNum = 229;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildSubHea";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader2(_page,"subhdr9","{B}{U}ABMPages{/U}{/B}")));
 //BA.debugLineNum = 230;BA.debugLine="s1 = $\"These are your actual WebApp pages contain";
_s1 = ("These are your actual WebApp pages containing your own ABMaterial components and logic.  Here is where you will spend most of your time. An ABM WebPage NEEDS a certain structure and methods.  You can use (copy) the {B}ABMPageTemplate{/B} or {B}ABMPageTemplateAlternative{/B} classes to get started with your own pages.{BR}Make sure you {B}give the Name of the page the same name as your class (case sensitive!){/B}");
 //BA.debugLineNum = 231;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"para9",_s1)));
 //BA.debugLineNum = 233;BA.debugLine="code = $\"//Class module Sub{NBSP}Class_Globals 	P";
_code = ("//Class module\n"+"Sub{NBSP}Class_Globals\n"+"	Private ws As WebSocket\n"+"	// will hold our page information\n"+"	Public page As ABMPage\n"+"	// page theme\n"+"	Private theme As ABMTheme\n"+"	// to access the constants\n"+"	Private ABM As ABMaterial\n"+"	// name of the page, must be the same as the class name (case sensitive!)\n"+"	Public Name As String = \"ABMPageTemplateAlternative\"\n"+"	// will hold the unique browsers window id\n"+"	Private ABMPageId As String = \"\"\n"+"	\n"+"End{NBSP}Sub");
 //BA.debugLineNum = 248;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code4",_code.replace("{NBSP}"," "))));
 //BA.debugLineNum = 250;BA.debugLine="code = $\"//Initializes the object. You can add pa";
_code = ("//Initializes the object. You can add parameters to this method if needed.\n"+"Public{NBSP}Sub Initialize\n"+"	// build the local structure IMPORTANT!\n"+"	// start with the base theme defined in ABMShared\n"+"	theme.Initialize(\"pagetheme\")\n"+"	theme.AddABMTheme(ABMShared.MyTheme)\n"+"	\n"+"	// add additional themes specific for this page\n"+"	\n"+"	// initialize this page using our theme\n"+"	page.InitializeWithTheme(Name, \"/ws/\" & ABMShared.AppName & \"/\" & Name, False, ABMShared.SessionMaxInactiveIntervalSeconds, theme)\n"+"	page.ShowLoader=True\n"+"	page.PageHTMLName = \"index.html\"\n"+"	page.PageTitle = \"\"\n"+"	page.PageDescription = \"\"\n"+"	page.PageKeywords = \"\"\n"+"	page.PageSiteMapPriority = \"\"\n"+"	page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_YEARLY\n"+"	\n"+"	page.ShowConnectedIndicator = True\n"+"		\n"+"	// adding a navigation bar\n"+"	\n"+"			\n"+"	// create the page grid\n"+"	page.AddRows(2,True, \"\").AddCells12(1,\"\")\n"+"	page.BuildGrid //IMPORTANT once you loaded the complete grid AND before you start adding components\n"+"End{NBSP}Sub");
 //BA.debugLineNum = 278;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code5",_code.replace("{NBSP}"," "))));
 //BA.debugLineNum = 280;BA.debugLine="code = $\"Private Sub{NBSP}WebSocket_Connected (We";
_code = ("Private Sub{NBSP}WebSocket_Connected (WebSocket1 As WebSocket)\n"+"	Log(\"Connected\")		\n"+"	ws = WebSocket1	\n"+"	ABMPageId = ABM.GetPageID(page, Name,ws)\n"+"	Dim session As HttpSession = ABM.GetSession(ws, ABMShared.SessionMaxInactiveIntervalSeconds)\n"+"	\n"+"	If ABMShared.NeedsAuthorization Then\n"+"		If session.GetAttribute2(\"IsAuthorized\", \"\") = \"\" Then\n"+"			ABMShared.NavigateToPage(ws, ABMPageId, \"../\")\n"+"			Return\n"+"		End If\n"+"	End If\n"+"	\n"+"	ABM.UpdateFromCache(Me, ABMShared.CachedPages, ABMPageId, ws)\n"+"	If page.ComesFromPageCache Then\n"+"		// refresh the page\n"+"		page.Refresh\n"+"		// Tell the browser we finished loading\n"+"		page.FinishedLoading\n"+"	Else\n"+"		// Prepare the page \n"+"		page.Prepare\n"+"		// load the dynamic content\n"+"		\n"+"		// connecting the navigation bar\n"+"		\n"+"		// init all your own variables (like a List, Map) and add your components\n"+"		//	page.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page, \"lbl\", \"This is a test\"))\n"+"		//	\n"+"		//	Dim btn As ABMButton\n"+"		//	btn.InitializeRaised(page, \"btn\", \"\", \"\", \"Press me\", \"\")\n"+"		//	page.Cell(2,1).AddComponent(btn)\n"+"		\n"+"		// refresh the page\n"+"		page.Refresh\n"+"		// Tell the browser we finished loading\n"+"		page.FinishedLoading\n"+"		// restoring the navigation bar position\n"+"		page.RestoreNavigationBarPosition\n"+"	End If\n"+"	Log(ABMPageId)\n"+"End{NBSP}Sub");
 //BA.debugLineNum = 322;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code6",_code.replace("{NBSP}"," "))));
 //BA.debugLineNum = 324;BA.debugLine="code = $\"Private{NBSP}Sub WebSocket_Disconnected";
_code = ("Private{NBSP}Sub WebSocket_Disconnected\n"+"	Log(\"Disconnected\")	\n"+"End{NBSP}Sub");
 //BA.debugLineNum = 327;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code7",_code.replace("{NBSP}"," "))));
 //BA.debugLineNum = 329;BA.debugLine="code = $\"Sub{NBSP}Page_ParseEvent(Params As Map)";
_code = ("Sub{NBSP}Page_ParseEvent(Params As Map) \n"+"	Dim eventName As String = Params.Get(\"eventname\")\n"+"	Dim eventParams() As String = Regex.Split(\",\",Params.Get(\"eventparams\"))\n"+"	If eventName = \"beforeunload\" Then\n"+"		Log(\"preparing for url refresh\")	\n"+"		ABM.RemoveMeFromCache(ABMShared.CachedPages, ABMPageId)	\n"+"		Return\n"+"	End If\n"+"	If SubExists(Me, eventName) Then\n"+"		Params.Remove(\"eventname\")\n"+"		Params.Remove(\"eventparams\")\n"+"		Select Case Params.Size\n"+"			Case 0\n"+"				CallSub(Me, eventName)\n"+"			Case 1\n"+"				CallSub2(Me, eventName, Params.Get(eventParams(0)))					\n"+"			Case 2\n"+"				If Params.get(eventParams(0)) = \"abmistable\" Then\n"+"					Dim PassedTables As List = ABM.ProcessTablesFromTargetName(Params.get(eventParams(1)))\n"+"					CallSub2(Me, eventName, PassedTables)\n"+"				Else\n"+"					CallSub3(Me, eventName, Params.Get(eventParams(0)), Params.Get(eventParams(1)))\n"+"				End If\n"+"			Case Else\n"+"				// cannot be called directly, to many param\n"+"				CallSub2(Me, eventName, Params)				\n"+"		End Select\n"+"	End If\n"+"End{NBSP}Sub");
 //BA.debugLineNum = 358;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code8",_code.replace("{NBSP}"," "))));
 //BA.debugLineNum = 360;BA.debugLine="code = $\"// clicked on the navigation bar Sub{NBS";
_code = ("// clicked on the navigation bar\n"+"Sub{NBSP}Page_NavigationbarClicked(Action As String, Value As String)\n"+"	// saving the navigation bar position\n"+"	page.SaveNavigationBarPosition\n"+"	If Action = \"LogOff\" Then\n"+"		ABMShared.LogOff(page)\n"+"		Return\n"+"	End If\n"+"	ABMShared.NavigateToPage(ws, ABMPageId, Value)\n"+"End{NBSP}Sub");
 //BA.debugLineNum = 370;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code9",_code.replace("{NBSP}"," "))));
 //BA.debugLineNum = 373;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par12","{B}That is it.{/B}  You can start creating ABMaterial WebApps!")));
 //BA.debugLineNum = 375;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par13","Next, read the Themes section to get a basic understanding of how you can use themes to uniformize your WebApp!")));
 //BA.debugLineNum = 378;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 380;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 383;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 385;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 386;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 20;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 22;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 389;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 390;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 391;BA.debugLine="If Action = \"GettingStarted\" Then Return";
if ((_action).equals("GettingStarted")) { 
if (true) return "";};
 //BA.debugLineNum = 392;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 393;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 394;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 395;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 397;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 398;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 399;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 401;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 402;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 57;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 58;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 59;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 60;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 61;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 62;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 63;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 65;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 66;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 67;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 68;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 70;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 72;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 74;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 75;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 76;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 78;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 82;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 404;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 405;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 406;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 407;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 408;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 409;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 25;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 26;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 27;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 28;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 29;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 31;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 32;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 33;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 34;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 38;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 39;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 41;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 43;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 46;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 48;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 50;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 54;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
