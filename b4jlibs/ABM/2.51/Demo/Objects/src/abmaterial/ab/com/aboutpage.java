package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class aboutpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.aboutpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.aboutpage.class).invoke(this, new Object[] {null});
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
 //BA.debugLineNum = 107;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 109;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 112;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 113;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 114;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 115;BA.debugLine="page.PageTitle = \"ABMaterial\"";
_page.PageTitle = "ABMaterial";
 //BA.debugLineNum = 116;BA.debugLine="page.PageDescription = \"About material design wit";
_page.PageDescription = "About material design with ABMaterial ";
 //BA.debugLineNum = 117;BA.debugLine="page.PageHTMLName = \"abmaterial-about.html\"";
_page.PageHTMLName = "abmaterial-about.html";
 //BA.debugLineNum = 118;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 119;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 120;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 121;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 122;BA.debugLine="page.ShowConnectedIndicator = True";
_page.ShowConnectedIndicator = __c.True;
 //BA.debugLineNum = 124;BA.debugLine="ABMShared.BuildNavigationBar(page, \"About\",\"../im";
_abmshared._buildnavigationbar(_page,"About","../images/logo.png","","About","");
 //BA.debugLineNum = 127;BA.debugLine="page.AddRows(3,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (3),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 128;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,12,3,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (3),(int) (3),"").AddCellsOS((int) (1),(int) (0),(int) (1),(int) (1),(int) (12),(int) (3),(int) (3),"").AddCellsOS((int) (1),(int) (0),(int) (1),(int) (1),(int) (12),(int) (3),(int) (3),"");
 //BA.debugLineNum = 129;BA.debugLine="page.AddRows(7,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (7),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 130;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 132;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 90;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 91;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 96;BA.debugLine="theme.Page.BackColor = ABM.COLOR_GREY";
_theme.Page.BackColor = _abm.COLOR_GREY;
 //BA.debugLineNum = 97;BA.debugLine="theme.Page.BackColorIntensity = ABM.INTENSITY_LIG";
_theme.Page.BackColorIntensity = _abm.INTENSITY_LIGHTEN5;
 //BA.debugLineNum = 99;BA.debugLine="theme.AddImageSliderTheme(\"myslider\")";
_theme.AddImageSliderTheme("myslider");
 //BA.debugLineNum = 100;BA.debugLine="theme.ImageSlider(\"myslider\").Interval = 3000";
_theme.ImageSlider("myslider").Interval = (int) (3000);
 //BA.debugLineNum = 101;BA.debugLine="theme.ImageSlider(\"myslider\").ZDepth = ABM.ZDEPTH";
_theme.ImageSlider("myslider").ZDepth = _abm.ZDEPTH_1;
 //BA.debugLineNum = 102;BA.debugLine="theme.ImageSlider(\"myslider\").ActiveBulletColor=";
_theme.ImageSlider("myslider").ActiveBulletColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 103;BA.debugLine="theme.ImageSlider(\"myslider\").InactiveBulletColor";
_theme.ImageSlider("myslider").InactiveBulletColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 104;BA.debugLine="theme.ImageSlider(\"myslider\").InactiveBulletColor";
_theme.ImageSlider("myslider").InactiveBulletColorIntensity = _abm.INTENSITY_LIGHTEN4;
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"AboutPage\"";
_name = "AboutPage";
 //BA.debugLineNum = 12;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 15;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMImageSlider _slider = null;
com.ab.abmaterial.ABMImage _img = null;
abmaterial.ab.com.donatebutton _donbutton = null;
 //BA.debugLineNum = 135;BA.debugLine="public Sub ConnectPage()";
 //BA.debugLineNum = 137;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 140;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Welcome to ABMaterial!")));
 //BA.debugLineNum = 142;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","ABMaterial is a new framework created by {AL}http://alwaysbusycorner.com/{AT}Alain Bailleul{/AL} combining a tuned Materialize CSS with the free programming tool {AL}https://www.idevaffiliate.com/33168/13-2.html{AT}B4J{/AL}.  It allows creating WebApps that not only look great thanks to Googles Material Design, but can be programmed with the powerful free tool from Anywhere Software. ")));
 //BA.debugLineNum = 145;BA.debugLine="Dim slider As ABMImageSlider";
_slider = new com.ab.abmaterial.ABMImageSlider();
 //BA.debugLineNum = 146;BA.debugLine="slider.Initialize(page, \"slider\", \"myslider\")";
_slider.Initialize(_page,"slider","myslider");
 //BA.debugLineNum = 149;BA.debugLine="slider.AddSlideImage(\"../images/about1.png\", \"No";
_slider.AddSlideImage("../images/about1.png","No knowledge of HTML or CSS required","Over 35 Material controls!",_abm.IMAGESLIDER_RIGHT);
 //BA.debugLineNum = 150;BA.debugLine="slider.AddSlideImage(\"../images/about2.png\", \"All";
_slider.AddSlideImage("../images/about2.png","All controlable with pure B4J code","Over 35 Material controls!",_abm.IMAGESLIDER_RIGHT);
 //BA.debugLineNum = 151;BA.debugLine="slider.AddSlideImage(\"../images/about3.png\", \"Con";
_slider.AddSlideImage("../images/about3.png","Controls are animated","Over 35 Material controls!",_abm.IMAGESLIDER_RIGHT);
 //BA.debugLineNum = 152;BA.debugLine="slider.AddSlideImage(\"../images/about4.png\", \"Int";
_slider.AddSlideImage("../images/about4.png","Interact with the controls","Over 35 Material controls!",_abm.IMAGESLIDER_CENTER);
 //BA.debugLineNum = 153;BA.debugLine="slider.AddSlideImage(\"../images/about5.png\", \"Hel";
_slider.AddSlideImage("../images/about5.png","Helpers create effects like Parallax","Over 35 Material controls!",_abm.IMAGESLIDER_RIGHT);
 //BA.debugLineNum = 154;BA.debugLine="slider.AddSlideImage(\"../images/about6.png\", \"Mod";
_slider.AddSlideImage("../images/about6.png","Modern looking controls","Over 35 Material controls!",_abm.IMAGESLIDER_RIGHT);
 //BA.debugLineNum = 155;BA.debugLine="slider.AddSlideImage(\"../images/about7.png\", \"Adv";
_slider.AddSlideImage("../images/about7.png","Advanced easy to implement upload files","Over 35 Material controls!",_abm.IMAGESLIDER_RIGHT);
 //BA.debugLineNum = 156;BA.debugLine="slider.AddSlideImage(\"../images/about8.png\", \"Cre";
_slider.AddSlideImage("../images/about8.png","Create you own controls with the canvas","Over 35 Material controls!",_abm.IMAGESLIDER_CENTER);
 //BA.debugLineNum = 158;BA.debugLine="page.Cell(2,1).AddComponent(slider)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_slider));
 //BA.debugLineNum = 161;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","{B}{I}This site you are now exploring is written completely in B4J without having to write a single line of HTML or CSS code!{/I}{/B} All this code is automatically generated while you can program your WebApp in an object oriented way like you are used to in the other Anywhere products like B4A, B4i and B4J.  ABMaterial controls can be themed and have events you can use in B4J to manipulate the app. Using jQueryelement in ABMaterial, you do not have to worry about Futures etc, as all is taken care of in the library. ")));
 //BA.debugLineNum = 163;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","ABMaterial WebApps are Desktop, Tablet and Phone aware. Depending on the size of the screen, your app can appear different.  For example when you resize this site on a desktop, you'll notice the SideBar on the left will disappear and a 'hamburger' button will appear in the TopBar.  See layouts for more information on how to do this. Click on the images for a larger view.")));
 //BA.debugLineNum = 166;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildImage(";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildimage(_page,"img1","../images/Desktop.jpg",1,"ABMaterial in a desktop webbrowser")));
 //BA.debugLineNum = 167;BA.debugLine="page.Cell(4,2).AddComponent(ABMShared.BuildImage(";
_page.Cell((int) (4),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildimage(_page,"img2","../images/Tablet.png",1,"ABMaterial on a tablet")));
 //BA.debugLineNum = 168;BA.debugLine="page.Cell(4,3).AddComponent(ABMShared.BuildImage(";
_page.Cell((int) (4),(int) (3)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildimage(_page,"img3","../images/Phone.png",1,"ABMaterial on a phone")));
 //BA.debugLineNum = 171;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr2","So how does it work?")));
 //BA.debugLineNum = 173;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","ABMaterial is split into two parts: Grids/Components and Themes. Grids/Components define the structure and components within your page.  Themes can be used to define the look of the components in your app.")));
 //BA.debugLineNum = 175;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par5","A good place to start is reading the Getting started section.")));
 //BA.debugLineNum = 177;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par13","I hope you'll enjoy programming with ABMaterial.  Check out the {AL}http://www.b4x.com/android/forum/{AT}B4J forum{/AL} for questions, bugs or suggestions. I spend a lot of time in there...")));
 //BA.debugLineNum = 179;BA.debugLine="Dim img As ABMImage";
_img = new com.ab.abmaterial.ABMImage();
 //BA.debugLineNum = 180;BA.debugLine="img.Initialize(page, \"img\", \"../images/alainbaill";
_img.Initialize(_page,"img","../images/alainbailleul.png",1);
 //BA.debugLineNum = 181;BA.debugLine="page.Cell(6,1).AddComponent(img)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_img));
 //BA.debugLineNum = 183;BA.debugLine="Dim donButton As DonateButton";
_donbutton = new abmaterial.ab.com.donatebutton();
 //BA.debugLineNum = 184;BA.debugLine="donButton.Initialize(page, \"donButton\")";
_donbutton._initialize(ba,_page,"donButton");
 //BA.debugLineNum = 185;BA.debugLine="page.Cell(6,1).AddComponent(donButton.ABMComp)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_donbutton._abmcomp));
 //BA.debugLineNum = 188;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 190;BA.debugLine="page.Refresh ' IMPORTANT!";
_page.Refresh();
 //BA.debugLineNum = 193;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 195;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 196;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Welcome to ABMaterial "+_abm.Version+"!",(int) (5000));
 //BA.debugLineNum = 198;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 203;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 19;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 22;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 206;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 207;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 208;BA.debugLine="If Action = \"About\" Then Return";
if ((_action).equals("About")) { 
if (true) return "";};
 //BA.debugLineNum = 209;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 210;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 211;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 212;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 214;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 215;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 216;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 218;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 219;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 58;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 59;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 60;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 61;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 62;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 63;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 64;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 66;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 67;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 68;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 69;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 71;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 73;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 75;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 76;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 77;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 79;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 83;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 221;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 222;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 223;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 224;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 225;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 226;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 26;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 27;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 28;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 29;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 30;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 32;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 33;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 34;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 35;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 39;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 40;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 42;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 44;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 47;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 49;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 51;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 55;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
