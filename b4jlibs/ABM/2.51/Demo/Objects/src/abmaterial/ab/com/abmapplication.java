package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class abmapplication extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.abmapplication", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.abmapplication.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _initialpage = "";
public com.ab.abmaterial.ABMPage _apppage = null;
public com.ab.abmaterial.ABMTheme _theme = null;
public anywheresoftware.b4j.object.WebSocket _ws = null;
public com.ab.abmaterial.ABMaterial _abm = null;
public anywheresoftware.b4a.objects.collections.List _pages = null;
public anywheresoftware.b4a.objects.collections.List _pageneedsupload = null;
public String _abmpageid = "";
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _addpage(com.ab.abmaterial.ABMPage _page) throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="public Sub AddPage(page As ABMPage)";
 //BA.debugLineNum = 128;BA.debugLine="Pages.Add(page.Name)";
_pages.Add((Object)(_page.getName()));
 //BA.debugLineNum = 129;BA.debugLine="PageNeedsUpload.Add(ABM.WritePageToDisk(page, Fil";
_pageneedsupload.Add((Object)(_abm.WritePageToDisk(_page,__c.File.getDirApp()+"/www/"+_abmshared._appname+"/"+_page.getName()+"/",_page.PageHTMLName,_abmshared._needsauthorization)));
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 214;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 216;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 219;BA.debugLine="AppPage.InitializeWithTheme(ABMShared.AppName, \"/";
_apppage.InitializeWithTheme(_abmshared._appname,"/ws/"+_abmshared._appname,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 220;BA.debugLine="AppPage.ShowLoader=True";
_apppage.setShowLoader(__c.True);
 //BA.debugLineNum = 221;BA.debugLine="AppPage.ShowLoaderType= ABM.LOADER_TYPE_MANUAL '";
_apppage.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 222;BA.debugLine="AppPage.PageTitle = \"ABMaterial\"";
_apppage.PageTitle = "ABMaterial";
 //BA.debugLineNum = 223;BA.debugLine="AppPage.PageDescription = \"ABMaterial, a Material";
_apppage.PageDescription = "ABMaterial, a Material UI Framework for B4J";
 //BA.debugLineNum = 224;BA.debugLine="AppPage.PageHTMLName = \"index.html\"";
_apppage.PageHTMLName = "index.html";
 //BA.debugLineNum = 225;BA.debugLine="AppPage.PageKeywords = \"ABMaterial, material desi";
_apppage.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 226;BA.debugLine="AppPage.PageSiteMapPriority = \"0.25\"";
_apppage.PageSiteMapPriority = "0.25";
 //BA.debugLineNum = 227;BA.debugLine="AppPage.PageSiteMapFrequency = ABM.SITEMAP_FREQ_M";
_apppage.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 228;BA.debugLine="AppPage.UseGoogleAnalytics(ABMShared.TrackingID,";
_apppage.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 231;BA.debugLine="AppPage.AddRows(1,True, \"\").AddCells12(1,\"\")";
_apppage.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 232;BA.debugLine="AppPage.BuildGrid 'IMPORTANT once you loaded the";
_apppage.BuildGrid();
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 205;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 207;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 208;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Private InitialPage As String = \"AboutPage/abmate";
_initialpage = "AboutPage/abmaterial-about.html";
 //BA.debugLineNum = 6;BA.debugLine="Private AppPage As ABMPage";
_apppage = new com.ab.abmaterial.ABMPage();
 //BA.debugLineNum = 7;BA.debugLine="Private theme As ABMTheme";
_theme = new com.ab.abmaterial.ABMTheme();
 //BA.debugLineNum = 8;BA.debugLine="Private ws As WebSocket 'ignore";
_ws = new anywheresoftware.b4j.object.WebSocket();
 //BA.debugLineNum = 9;BA.debugLine="Private ABM As ABMaterial 'ignore";
_abm = new com.ab.abmaterial.ABMaterial();
 //BA.debugLineNum = 10;BA.debugLine="Private Pages As List";
_pages = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 11;BA.debugLine="Private PageNeedsUpload As List";
_pageneedsupload = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String";
_abmpageid = "";
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMModalSheet  _connectloginsheet() throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMInput _inp2 = null;
com.ab.abmaterial.ABMSocialOAuth _soauth = null;
com.ab.abmaterial.ABMButton _msbtn1 = null;
 //BA.debugLineNum = 282;BA.debugLine="Sub ConnectLoginSheet() As ABMModalSheet";
 //BA.debugLineNum = 283;BA.debugLine="Dim myModal As ABMModalSheet";
_mymodal = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 284;BA.debugLine="myModal.Initialize(AppPage, \"login\", False, False";
_mymodal.Initialize(_apppage,"login",__c.False,BA.ObjectToString(__c.False),"");
 //BA.debugLineNum = 285;BA.debugLine="myModal.Content.UseTheme(\"modalcontent\")";
_mymodal.Content.UseTheme("modalcontent");
 //BA.debugLineNum = 286;BA.debugLine="myModal.Footer.UseTheme(\"modalfooter\")";
_mymodal.Footer.UseTheme("modalfooter");
 //BA.debugLineNum = 287;BA.debugLine="myModal.IsDismissible = False";
_mymodal.IsDismissible = __c.False;
 //BA.debugLineNum = 290;BA.debugLine="myModal.Content.AddRows(3,True, \"\").AddCells12(1,";
_mymodal.Content.AddRows((int) (3),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 291;BA.debugLine="myModal.Content.BuildGrid 'IMPORTANT once you loa";
_mymodal.Content.BuildGrid();
 //BA.debugLineNum = 295;BA.debugLine="myModal.Footer.AddRowsM(1,True,0,0, \"\").AddCellsO";
_mymodal.Footer.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOS((int) (1),(int) (9),(int) (9),(int) (9),(int) (3),(int) (3),(int) (3),"");
 //BA.debugLineNum = 296;BA.debugLine="myModal.Footer.BuildGrid 'IMPORTANT once you load";
_mymodal.Footer.BuildGrid();
 //BA.debugLineNum = 298;BA.debugLine="myModal.Content.Cell(1,1).AddComponent(ABMShared.";
_mymodal.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_apppage,"par1","Please login: (login and password are 'demo')")));
 //BA.debugLineNum = 301;BA.debugLine="Dim inp1 As ABMInput";
_inp1 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 302;BA.debugLine="inp1.Initialize(AppPage, \"inp1\", ABM.INPUT_TEXT,";
_inp1.Initialize(_apppage,"inp1",_abm.INPUT_TEXT,"Login",__c.False,"");
 //BA.debugLineNum = 303;BA.debugLine="myModal.Content.Cell(2,1).AddComponent(inp1)";
_mymodal.Content.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp1));
 //BA.debugLineNum = 305;BA.debugLine="Dim inp2 As ABMInput";
_inp2 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 306;BA.debugLine="inp2.Initialize(AppPage, \"inp2\", ABM.INPUT_PASSWO";
_inp2.Initialize(_apppage,"inp2",_abm.INPUT_PASSWORD,"Password",__c.False,"");
 //BA.debugLineNum = 307;BA.debugLine="myModal.Content.Cell(2,1).AddComponent(inp2)";
_mymodal.Content.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp2));
 //BA.debugLineNum = 310;BA.debugLine="Dim sOAuth As ABMSocialOAuth";
_soauth = new com.ab.abmaterial.ABMSocialOAuth();
 //BA.debugLineNum = 311;BA.debugLine="sOAuth.Initialize(AppPage, \"sOAuth\")";
_soauth.Initialize(_apppage,"sOAuth");
 //BA.debugLineNum = 312;BA.debugLine="sOAuth.AddFacebookButton(\"gorgeousapps.com\",\"8684";
_soauth.AddFacebookButton("gorgeousapps.com","868438219937606","Sign on with Facebook");
 //BA.debugLineNum = 314;BA.debugLine="sOAuth.AddTwitterButton(\"YOURDOMAIN.COM\",\"YOURKEY";
_soauth.AddTwitterButton("YOURDOMAIN.COM","YOURKEY","Sign on with Twitter");
 //BA.debugLineNum = 315;BA.debugLine="sOAuth.AddGooglePlusButton(\"YOURKEY\", \"Sign on wi";
_soauth.AddGooglePlusButton("YOURKEY","Sign on with Google Plus");
 //BA.debugLineNum = 316;BA.debugLine="sOAuth.AddLinkedInButton(\"YOURKEY\", \"Sign on with";
_soauth.AddLinkedInButton("YOURKEY","Sign on with LinkedIn");
 //BA.debugLineNum = 317;BA.debugLine="sOAuth.AddWindowsLiveButton(\"YOURDOMAIN.COM\",\"YOU";
_soauth.AddWindowsLiveButton("YOURDOMAIN.COM","YOURKEY","Sign on with Windows Live");
 //BA.debugLineNum = 318;BA.debugLine="sOAuth.AddFourSquareButton(\"YOURDOMAIN.COM\",\"YOUR";
_soauth.AddFourSquareButton("YOURDOMAIN.COM","YOURKEY","Sign on with FourSquare");
 //BA.debugLineNum = 319;BA.debugLine="sOAuth.AddInstagramButton(\"YOURDOMAIN.COM\",\"YOURK";
_soauth.AddInstagramButton("YOURDOMAIN.COM","YOURKEY","Sign on with Instagram");
 //BA.debugLineNum = 320;BA.debugLine="sOAuth.AddSoundCloudButton(\"YOURDOMAIN.COM\",\"YOUR";
_soauth.AddSoundCloudButton("YOURDOMAIN.COM","YOURKEY","Sign on with SoundCloud");
 //BA.debugLineNum = 321;BA.debugLine="sOAuth.AddYahooButton(\"YOURDOMAIN.COM\",\"YOURKEY\",";
_soauth.AddYahooButton("YOURDOMAIN.COM","YOURKEY","Sign on with Yahoo");
 //BA.debugLineNum = 323;BA.debugLine="myModal.Content.Cell(3,1).AddComponent(sOAuth)";
_mymodal.Content.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_soauth));
 //BA.debugLineNum = 326;BA.debugLine="Dim msbtn1 As ABMButton";
_msbtn1 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 327;BA.debugLine="msbtn1.InitializeFlat(AppPage, \"msbtn1\", \"\", \"\",";
_msbtn1.InitializeFlat(_apppage,"msbtn1","","","Login","transparent");
 //BA.debugLineNum = 328;BA.debugLine="myModal.Footer.Cell(1,1).AddComponent(msbtn1)";
_mymodal.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_msbtn1));
 //BA.debugLineNum = 330;BA.debugLine="Return myModal";
if (true) return _mymodal;
 //BA.debugLineNum = 331;BA.debugLine="End Sub";
return null;
}
public String  _connectpage() throws Exception{
 //BA.debugLineNum = 237;BA.debugLine="Public Sub ConnectPage()";
 //BA.debugLineNum = 239;BA.debugLine="AppPage.AddModalSheetTemplate(ConnectLoginSheet)";
_apppage.AddModalSheetTemplate(_connectloginsheet());
 //BA.debugLineNum = 242;BA.debugLine="AppPage.AddModalSheetTemplate(ConnectWrongInputMo";
_apppage.AddModalSheetTemplate(_connectwronginputmodalsheet());
 //BA.debugLineNum = 244;BA.debugLine="AppPage.Refresh ' IMPORTANT";
_apppage.Refresh();
 //BA.debugLineNum = 247;BA.debugLine="AppPage.FinishedLoading 'IMPORTANT";
_apppage.FinishedLoading();
 //BA.debugLineNum = 249;BA.debugLine="AppPage.RestoreNavigationBarPosition";
_apppage.RestoreNavigationBarPosition();
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMModalSheet  _connectwronginputmodalsheet() throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodalerror = null;
com.ab.abmaterial.ABMLabel _lbl1 = null;
 //BA.debugLineNum = 333;BA.debugLine="Sub ConnectWrongInputModalSheet()  As ABMModalShee";
 //BA.debugLineNum = 334;BA.debugLine="Dim myModalError As ABMModalSheet";
_mymodalerror = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 335;BA.debugLine="myModalError.Initialize(AppPage, \"wronginput\", Fa";
_mymodalerror.Initialize(_apppage,"wronginput",__c.False,BA.ObjectToString(__c.False),"");
 //BA.debugLineNum = 336;BA.debugLine="myModalError.Content.UseTheme(\"modalcontent\")";
_mymodalerror.Content.UseTheme("modalcontent");
 //BA.debugLineNum = 337;BA.debugLine="myModalError.Footer.UseTheme(\"modalcontent\")";
_mymodalerror.Footer.UseTheme("modalcontent");
 //BA.debugLineNum = 338;BA.debugLine="myModalError.IsDismissible = True";
_mymodalerror.IsDismissible = __c.True;
 //BA.debugLineNum = 341;BA.debugLine="myModalError.Content.AddRows(1,True, \"\").AddCells";
_mymodalerror.Content.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 342;BA.debugLine="myModalError.Content.BuildGrid 'IMPORTANT once yo";
_mymodalerror.Content.BuildGrid();
 //BA.debugLineNum = 344;BA.debugLine="Dim lbl1 As ABMLabel";
_lbl1 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 345;BA.debugLine="lbl1.Initialize(AppPage, \"contlbl1\", \"The login o";
_lbl1.Initialize(_apppage,"contlbl1","The login or password are incorrect!",_abm.SIZE_PARAGRAPH,__c.False,"");
 //BA.debugLineNum = 346;BA.debugLine="myModalError.Content.Cell(1,1).AddComponent(lbl1)";
_mymodalerror.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl1));
 //BA.debugLineNum = 348;BA.debugLine="Return myModalError";
if (true) return _mymodalerror;
 //BA.debugLineNum = 349;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
anywheresoftware.b4a.objects.collections.List _folders = null;
 //BA.debugLineNum = 16;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 17;BA.debugLine="Pages.Initialize";
_pages.Initialize();
 //BA.debugLineNum = 18;BA.debugLine="PageNeedsUpload.Initialize";
_pageneedsupload.Initialize();
 //BA.debugLineNum = 20;BA.debugLine="ABM.AddAppleTouchIcon(\"apple-touch-icon-152x152.p";
_abm.AddAppleTouchIcon("apple-touch-icon-152x152.png","152x152");
 //BA.debugLineNum = 21;BA.debugLine="ABM.AddMSTileIcon(\"mstile-144x144.png\", \"144x144\"";
_abm.AddMSTileIcon("mstile-144x144.png","144x144");
 //BA.debugLineNum = 22;BA.debugLine="ABM.AddFavorityIcon(\"favicon-32x32.png\", \"32x32\")";
_abm.AddFavorityIcon("favicon-32x32.png","32x32");
 //BA.debugLineNum = 23;BA.debugLine="ABM.AppVersion = ABMShared.AppVersion";
_abm.AppVersion = _abmshared._appversion;
 //BA.debugLineNum = 24;BA.debugLine="ABM.AppPublishedStartURL = ABMShared.AppPublished";
_abm.AppPublishedStartURL = _abmshared._apppublishedstarturl;
 //BA.debugLineNum = 27;BA.debugLine="ABM.PreloadAllJavascriptAndCSSFiles=True	' NEW";
_abm.PreloadAllJavascriptAndCSSFiles = __c.True;
 //BA.debugLineNum = 28;BA.debugLine="ABM.ActivateGZip(\"DONATORKEY\", 1000) ' NEW";
_abm.ActivateGZip("DONATORKEY",(int) (1000));
 //BA.debugLineNum = 29;BA.debugLine="ABM.AppDefaultPageCSSInline=True ' NEW";
_abm.AppDefaultPageCSSInline = __c.True;
 //BA.debugLineNum = 30;BA.debugLine="ABM.AppDefaultPageJSInline=True ' NEW";
_abm.AppDefaultPageJSInline = __c.True;
 //BA.debugLineNum = 32;BA.debugLine="Dim folders As List ' NEW";
_folders = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 33;BA.debugLine="folders.Initialize";
_folders.Initialize();
 //BA.debugLineNum = 34;BA.debugLine="folders.Add(File.DirApp & \"/www/\" & ABMShared.Ap";
_folders.Add((Object)(__c.File.getDirApp()+"/www/"+_abmshared._appname+"/images"));
 //BA.debugLineNum = 35;BA.debugLine="ABM.ActivatePNGOptimize(\"DONATORKEY\", folders, F";
_abm.ActivatePNGOptimize("DONATORKEY",_folders,__c.False,(int) (9),__c.False,__c.True);
 //BA.debugLineNum = 38;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public String  _inp2_enterpressed(String _value) throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMInput _inp2 = null;
 //BA.debugLineNum = 267;BA.debugLine="Sub inp2_EnterPressed(value As String)";
 //BA.debugLineNum = 268;BA.debugLine="Dim mymodal As ABMModalSheet = AppPage.ModalSheet";
_mymodal = _apppage.ModalSheet("login");
 //BA.debugLineNum = 269;BA.debugLine="Dim inp1 As ABMInput = mymodal.Content.Component(";
_inp1 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("inp1"));
 //BA.debugLineNum = 270;BA.debugLine="Dim inp2 As ABMInput = mymodal.Content.Component(";
_inp2 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("inp2"));
 //BA.debugLineNum = 272;BA.debugLine="If inp1.Text <> \"demo\" Or inp2.Text <> \"demo\" The";
if ((_inp1.getText()).equals("demo") == false || (_inp2.getText()).equals("demo") == false) { 
 //BA.debugLineNum = 273;BA.debugLine="AppPage.ShowModalSheet(\"wronginput\")";
_apppage.ShowModalSheet("wronginput");
 //BA.debugLineNum = 274;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 276;BA.debugLine="ws.Session.SetAttribute(\"authType\", \"local\")";
_ws.getSession().SetAttribute("authType",(Object)("local"));
 //BA.debugLineNum = 277;BA.debugLine="ws.Session.SetAttribute(\"authName\", inp1.Text)";
_ws.getSession().SetAttribute("authName",(Object)(_inp1.getText()));
 //BA.debugLineNum = 278;BA.debugLine="ws.Session.SetAttribute(\"IsAuthorized\", \"true\")";
_ws.getSession().SetAttribute("IsAuthorized",(Object)("true"));
 //BA.debugLineNum = 279;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"./\" & In";
_abmshared._navigatetopage(_ws,_abmpageid,"./"+_initialpage);
 //BA.debugLineNum = 280;BA.debugLine="End Sub";
return "";
}
public String  _msbtn1_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMInput _inp2 = null;
 //BA.debugLineNum = 252;BA.debugLine="Sub msbtn1_Clicked(Target As String)";
 //BA.debugLineNum = 253;BA.debugLine="Dim mymodal As ABMModalSheet = AppPage.ModalSheet";
_mymodal = _apppage.ModalSheet("login");
 //BA.debugLineNum = 254;BA.debugLine="Dim inp1 As ABMInput = mymodal.Content.Component(";
_inp1 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("inp1"));
 //BA.debugLineNum = 255;BA.debugLine="Dim inp2 As ABMInput = mymodal.Content.Component(";
_inp2 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("inp2"));
 //BA.debugLineNum = 257;BA.debugLine="If inp1.Text <> \"demo\" Or inp2.Text <> \"demo\" The";
if ((_inp1.getText()).equals("demo") == false || (_inp2.getText()).equals("demo") == false) { 
 //BA.debugLineNum = 258;BA.debugLine="AppPage.ShowModalSheet(\"wronginput\")";
_apppage.ShowModalSheet("wronginput");
 //BA.debugLineNum = 259;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 261;BA.debugLine="ws.Session.SetAttribute(\"authType\", \"local\")";
_ws.getSession().SetAttribute("authType",(Object)("local"));
 //BA.debugLineNum = 262;BA.debugLine="ws.Session.SetAttribute(\"authName\", inp1.Text)";
_ws.getSession().SetAttribute("authName",(Object)(_inp1.getText()));
 //BA.debugLineNum = 263;BA.debugLine="ws.Session.SetAttribute(\"IsAuthorized\", \"true\")";
_ws.getSession().SetAttribute("IsAuthorized",(Object)("true"));
 //BA.debugLineNum = 264;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"./\" & In";
_abmshared._navigatetopage(_ws,_abmpageid,"./"+_initialpage);
 //BA.debugLineNum = 265;BA.debugLine="End Sub";
return "";
}
public String  _page_authenticated(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
 //BA.debugLineNum = 368;BA.debugLine="Sub Page_Authenticated(Params As Map)";
 //BA.debugLineNum = 369;BA.debugLine="Log(\"Authenticated \" & Params.Get(\"name\"))";
__c.Log("Authenticated "+BA.ObjectToString(_params.Get((Object)("name"))));
 //BA.debugLineNum = 371;BA.debugLine="ws.Session.SetAttribute(\"authType\", Params.Get(\"n";
_ws.getSession().SetAttribute("authType",_params.Get((Object)("network")));
 //BA.debugLineNum = 372;BA.debugLine="ws.Session.SetAttribute(\"authName\", Params.Get(\"n";
_ws.getSession().SetAttribute("authName",_params.Get((Object)("name")));
 //BA.debugLineNum = 373;BA.debugLine="ws.Session.SetAttribute(\"IsAuthorized\", \"true\")";
_ws.getSession().SetAttribute("IsAuthorized",(Object)("true"));
 //BA.debugLineNum = 374;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"./\" & In";
_abmshared._navigatetopage(_ws,_abmpageid,"./"+_initialpage);
 //BA.debugLineNum = 375;BA.debugLine="End Sub";
return "";
}
public String  _page_fileuploaded(String _filename,boolean _success) throws Exception{
 //BA.debugLineNum = 356;BA.debugLine="Sub Page_FileUploaded(FileName As String, success";
 //BA.debugLineNum = 358;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 352;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 353;BA.debugLine="AppPage.SaveNavigationBarPosition";
_apppage.SaveNavigationBarPosition();
 //BA.debugLineNum = 354;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 97;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 98;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 99;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 100;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 101;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 102;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 103;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 105;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 106;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 107;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 108;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 110;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 112;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 114;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 115;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 116;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 118;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 122;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 125;BA.debugLine="End Sub";
return "";
}
public String  _page_toastclicked(String _toastid,String _action) throws Exception{
 //BA.debugLineNum = 360;BA.debugLine="Sub Page_ToastClicked(ToastId As String, Action As";
 //BA.debugLineNum = 362;BA.debugLine="End Sub";
return "";
}
public String  _page_toastdismissed(String _toastid) throws Exception{
 //BA.debugLineNum = 364;BA.debugLine="Sub Page_ToastDismissed(ToastId As String)";
 //BA.debugLineNum = 366;BA.debugLine="End Sub";
return "";
}
public String  _startserver(anywheresoftware.b4j.object.ServerWrapper _srvr,String _srvrname,int _srvrport) throws Exception{
int _i = 0;
anywheresoftware.b4j.object.JavaObject _jo = null;
Object[] _connectors = null;
long _timeout = 0L;
anywheresoftware.b4j.object.JavaObject _c = null;
 //BA.debugLineNum = 132;BA.debugLine="public Sub StartServer(srvr As Server, srvrName As";
 //BA.debugLineNum = 133;BA.debugLine="ABM.WriteAppLauchPageToDisk(AppPage, File.DirApp";
_abm.WriteAppLauchPageToDisk(_apppage,__c.File.getDirApp()+"/www/"+_abmshared._appname,"index.html",_abmshared._needsauthorization);
 //BA.debugLineNum = 136;BA.debugLine="srvr.Initialize(srvrName)";
_srvr.Initialize(ba,_srvrname);
 //BA.debugLineNum = 138;BA.debugLine="srvr.AddFilter(\"/js/b4j_ws.min.js\", \"ABMSessionCr";
_srvr.AddFilter("/js/b4j_ws.min.js","ABMSessionCreator",__c.False);
 //BA.debugLineNum = 139;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName, \"AB";
_srvr.AddWebSocket("/ws/"+_abmshared._appname,"ABMApplication");
 //BA.debugLineNum = 140;BA.debugLine="For i =0 To Pages.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_pages.getSize()-1);
for (_i = (int) (0) ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
 //BA.debugLineNum = 141;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName & \"";
_srvr.AddWebSocket("/ws/"+_abmshared._appname+"/"+BA.ObjectToString(_pages.Get(_i)),BA.ObjectToString(_pages.Get(_i)));
 //BA.debugLineNum = 142;BA.debugLine="If PageNeedsUpload.Get(i) Then";
if (BA.ObjectToBoolean(_pageneedsupload.Get(_i))) { 
 //BA.debugLineNum = 143;BA.debugLine="srvr.AddHandler(\"/\" & ABMShared.AppName & \"/\" &";
_srvr.AddHandler("/"+_abmshared._appname+"/"+BA.ObjectToString(_pages.Get(_i))+"/abmuploadhandler","ABMUploadHandler",__c.False);
 };
 }
};
 //BA.debugLineNum = 146;BA.debugLine="srvr.AddBackgroundWorker(\"ABMCacheScavenger\")";
_srvr.AddBackgroundWorker("ABMCacheScavenger");
 //BA.debugLineNum = 147;BA.debugLine="srvr.Port = srvrPort";
_srvr.setPort(_srvrport);
 //BA.debugLineNum = 150;BA.debugLine="srvr.SetStaticFilesOptions(CreateMap(\"cacheContr";
_srvr.SetStaticFilesOptions(__c.createMap(new Object[] {(Object)("cacheControl"),(Object)("max-age=604800,public"),(Object)("gzip"),(Object)(__c.True),(Object)("dirAllowed"),(Object)(__c.False)}));
 //BA.debugLineNum = 154;BA.debugLine="srvr.Start";
_srvr.Start();
 //BA.debugLineNum = 155;BA.debugLine="Dim jo As JavaObject = srvr";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_srvr));
 //BA.debugLineNum = 156;BA.debugLine="Dim connectors() As Object = jo.GetFieldJO(\"serve";
_connectors = (Object[])(_jo.GetFieldJO("server").RunMethod("getConnectors",(Object[])(__c.Null)));
 //BA.debugLineNum = 157;BA.debugLine="Dim timeout As Long = ABMShared.SessionMaxInactiv";
_timeout = (long) (_abmshared._sessionmaxinactiveintervalseconds*1000);
 //BA.debugLineNum = 158;BA.debugLine="For Each c As JavaObject In connectors";
_c = new anywheresoftware.b4j.object.JavaObject();
final Object[] group18 = _connectors;
final int groupLen18 = group18.length;
for (int index18 = 0;index18 < groupLen18 ;index18++){
_c.setObject((java.lang.Object)(group18[index18]));
 //BA.debugLineNum = 159;BA.debugLine="c.RunMethod(\"setIdleTimeout\", Array(timeout))";
_c.RunMethod("setIdleTimeout",new Object[]{(Object)(_timeout)});
 }
;
 //BA.debugLineNum = 162;BA.debugLine="ABMShared.CachedPages = srvr.CreateThreadSafeMap";
_abmshared._cachedpages = _srvr.CreateThreadSafeMap();
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return "";
}
public String  _startserverhttp2(anywheresoftware.b4j.object.ServerWrapper _srvr,String _srvrname,int _srvrport,int _sslsvrport,String _sslkeystorefilename,String _sslkeystorepassword,String _sslkeymanagerpassword) throws Exception{
anywheresoftware.b4j.object.ServerWrapper.SslContextFactoryWrapper _ssl = null;
int _i = 0;
anywheresoftware.b4j.object.JavaObject _jo = null;
Object[] _connectors = null;
long _timeout = 0L;
anywheresoftware.b4j.object.JavaObject _c = null;
 //BA.debugLineNum = 165;BA.debugLine="public Sub StartServerHTTP2(srvr As Server, srvrNa";
 //BA.debugLineNum = 166;BA.debugLine="ABM.WriteAppLauchPageToDisk(AppPage, File.DirApp";
_abm.WriteAppLauchPageToDisk(_apppage,__c.File.getDirApp()+"/www/"+_abmshared._appname,"index.html",_abmshared._needsauthorization);
 //BA.debugLineNum = 168;BA.debugLine="Dim ssl As SslConfiguration";
_ssl = new anywheresoftware.b4j.object.ServerWrapper.SslContextFactoryWrapper();
 //BA.debugLineNum = 169;BA.debugLine="ssl.Initialize";
_ssl.Initialize();
 //BA.debugLineNum = 170;BA.debugLine="ssl.SetKeyStorePath(File.DirApp, SSLKeyStoreFileN";
_ssl.SetKeyStorePath(__c.File.getDirApp(),_sslkeystorefilename);
 //BA.debugLineNum = 171;BA.debugLine="ssl.KeyStorePassword = SSLKeyStorePassword";
_ssl.setKeyStorePassword(_sslkeystorepassword);
 //BA.debugLineNum = 172;BA.debugLine="ssl.KeyManagerPassword = SSLKeyManagerPassword";
_ssl.setKeyManagerPassword(_sslkeymanagerpassword);
 //BA.debugLineNum = 173;BA.debugLine="srvr.SetSslConfiguration(ssl, SSLsvrPort)";
_srvr.SetSslConfiguration(_ssl,_sslsvrport);
 //BA.debugLineNum = 176;BA.debugLine="srvr.Initialize(srvrName)";
_srvr.Initialize(ba,_srvrname);
 //BA.debugLineNum = 178;BA.debugLine="srvr.AddFilter(\"/js/b4j_ws.min.js\", \"ABMSessionCr";
_srvr.AddFilter("/js/b4j_ws.min.js","ABMSessionCreator",__c.False);
 //BA.debugLineNum = 179;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName, \"AB";
_srvr.AddWebSocket("/ws/"+_abmshared._appname,"ABMApplication");
 //BA.debugLineNum = 180;BA.debugLine="For i =0 To Pages.Size - 1";
{
final int step11 = 1;
final int limit11 = (int) (_pages.getSize()-1);
for (_i = (int) (0) ; (step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11); _i = ((int)(0 + _i + step11)) ) {
 //BA.debugLineNum = 181;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName & \"";
_srvr.AddWebSocket("/ws/"+_abmshared._appname+"/"+BA.ObjectToString(_pages.Get(_i)),BA.ObjectToString(_pages.Get(_i)));
 //BA.debugLineNum = 182;BA.debugLine="If PageNeedsUpload.Get(i) Then";
if (BA.ObjectToBoolean(_pageneedsupload.Get(_i))) { 
 //BA.debugLineNum = 183;BA.debugLine="srvr.AddHandler(\"/\" & ABMShared.AppName & \"/\" &";
_srvr.AddHandler("/"+_abmshared._appname+"/"+BA.ObjectToString(_pages.Get(_i))+"/abmuploadhandler","ABMUploadHandler",__c.False);
 };
 }
};
 //BA.debugLineNum = 186;BA.debugLine="srvr.AddBackgroundWorker(\"ABMCacheScavenger\")";
_srvr.AddBackgroundWorker("ABMCacheScavenger");
 //BA.debugLineNum = 187;BA.debugLine="srvr.Port = srvrPort";
_srvr.setPort(_srvrport);
 //BA.debugLineNum = 188;BA.debugLine="srvr.Http2Enabled = True";
_srvr.setHttp2Enabled(__c.True);
 //BA.debugLineNum = 190;BA.debugLine="srvr.SetStaticFilesOptions(CreateMap(\"cacheContr";
_srvr.SetStaticFilesOptions(__c.createMap(new Object[] {(Object)("cacheControl"),(Object)("max-age=604800,public"),(Object)("gzip"),(Object)(__c.True),(Object)("dirAllowed"),(Object)(__c.False)}));
 //BA.debugLineNum = 194;BA.debugLine="srvr.Start";
_srvr.Start();
 //BA.debugLineNum = 195;BA.debugLine="Dim jo As JavaObject = srvr";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_srvr));
 //BA.debugLineNum = 196;BA.debugLine="Dim connectors() As Object = jo.GetFieldJO(\"serve";
_connectors = (Object[])(_jo.GetFieldJO("server").RunMethod("getConnectors",(Object[])(__c.Null)));
 //BA.debugLineNum = 197;BA.debugLine="Dim timeout As Long = ABMShared.SessionMaxInactiv";
_timeout = (long) (_abmshared._sessionmaxinactiveintervalseconds*1000);
 //BA.debugLineNum = 198;BA.debugLine="For Each c As JavaObject In connectors";
_c = new anywheresoftware.b4j.object.JavaObject();
final Object[] group25 = _connectors;
final int groupLen25 = group25.length;
for (int index25 = 0;index25 < groupLen25 ;index25++){
_c.setObject((java.lang.Object)(group25[index25]));
 //BA.debugLineNum = 199;BA.debugLine="c.RunMethod(\"setIdleTimeout\", Array(timeout))";
_c.RunMethod("setIdleTimeout",new Object[]{(Object)(_timeout)});
 }
;
 //BA.debugLineNum = 202;BA.debugLine="ABMShared.CachedPages = srvr.CreateThreadSafeMap";
_abmshared._cachedpages = _srvr.CreateThreadSafeMap();
 //BA.debugLineNum = 203;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
String _activefoundlanguage = "";
anywheresoftware.b4a.objects.collections.Map _params = null;
String[] _login = null;
String[] _pwd = null;
 //BA.debugLineNum = 41;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 42;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 43;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 44;BA.debugLine="ABMPageId = ABM.GetPageID(AppPage, ABMShared.AppN";
_abmpageid = _abm.GetPageID(_apppage,_abmshared._appname,_ws);
 //BA.debugLineNum = 45;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 47;BA.debugLine="AppPage.Prepare";
_apppage.Prepare();
 //BA.debugLineNum = 54;BA.debugLine="AppPage.SetAcceptedLanguages(Array As String(\"en\"";
_apppage.SetAcceptedLanguages(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"en","fr","de","nl"}),"en");
 //BA.debugLineNum = 55;BA.debugLine="Dim ActiveFoundLanguage As String = AppPage.Detec";
_activefoundlanguage = _apppage.DetectLanguage(_ws.getUpgradeRequest().GetHeader("Accept-Language"));
 //BA.debugLineNum = 56;BA.debugLine="Log(\"Users browser language: \" & ActiveFoundLangu";
__c.Log("Users browser language: "+_activefoundlanguage);
 //BA.debugLineNum = 58;BA.debugLine="AppPage.SetActiveLanguage(ActiveFoundLanguage, \"\"";
_apppage.SetActiveLanguage(_activefoundlanguage,"");
 //BA.debugLineNum = 61;BA.debugLine="ConnectPage";
_connectpage();
 //BA.debugLineNum = 64;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 67;BA.debugLine="Dim params As Map = ws.UpgradeRequest.ParameterM";
_params = new anywheresoftware.b4a.objects.collections.Map();
_params = _ws.getUpgradeRequest().getParameterMap();
 //BA.debugLineNum = 68;BA.debugLine="Dim login(0), pwd(0) As String";
_login = new String[(int) (0)];
java.util.Arrays.fill(_login,"");
_pwd = new String[(int) (0)];
java.util.Arrays.fill(_pwd,"");
 //BA.debugLineNum = 69;BA.debugLine="If params.IsInitialized Then";
if (_params.IsInitialized()) { 
 //BA.debugLineNum = 70;BA.debugLine="login = params.GetDefault(\"login\", Array As Str";
_login = (String[])(_params.GetDefault((Object)("login"),(Object)(new String[]{""})));
 //BA.debugLineNum = 71;BA.debugLine="pwd = params.GetDefault(\"pwd\", Array As String(";
_pwd = (String[])(_params.GetDefault((Object)("pwd"),(Object)(new String[]{""})));
 };
 //BA.debugLineNum = 73;BA.debugLine="Log(login(0) & \" \" & pwd(0))";
__c.Log(_login[(int) (0)]+" "+_pwd[(int) (0)]);
 //BA.debugLineNum = 80;BA.debugLine="If ws.Session.GetAttribute2(\"IsAuthorized\", \"\")";
if ((_ws.getSession().GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 81;BA.debugLine="AppPage.ShowModalSheet(\"login\")";
_apppage.ShowModalSheet("login");
 //BA.debugLineNum = 82;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 88;BA.debugLine="AppPage.SetActiveLanguage(\"en\", \"\")";
_apppage.SetActiveLanguage("en","");
 //BA.debugLineNum = 90;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"./\" & In";
_abmshared._navigatetopage(_ws,_abmpageid,"./"+_initialpage);
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 94;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "PAGE_FILEUPLOADED"))
	return _page_fileuploaded((String) args[0], (Boolean) args[1]);
return BA.SubDelegator.SubNotFound;
}
}
