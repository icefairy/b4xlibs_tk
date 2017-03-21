package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compoauthpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compoauthpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compoauthpage.class).invoke(this, new Object[] {null});
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
 //BA.debugLineNum = 104;BA.debugLine="page.PageTitle = \"ABMOAuth\"";
_page.PageTitle = "ABMOAuth";
 //BA.debugLineNum = 105;BA.debugLine="page.PageDescription = \"The oauth component \"";
_page.PageDescription = "The oauth component ";
 //BA.debugLineNum = 106;BA.debugLine="page.PageHTMLName = \"abmaterial-oauth.html\"";
_page.PageHTMLName = "abmaterial-oauth.html";
 //BA.debugLineNum = 107;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 108;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 109;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 110;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 112;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMSocialOAut";
_abmshared._buildnavigationbar(_page,"ABMSocialOAuth","../images/logo.png","","Controls","ABMSocialOAuth");
 //BA.debugLineNum = 115;BA.debugLine="page.AddRows(5,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (5),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 116;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 118;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompOAuthPage\"";
_name = "CompOAuthPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMSocialOAuth _soauth = null;
String _code = "";
String _s = "";
com.ab.abmaterial.ABMImage _img2 = null;
 //BA.debugLineNum = 121;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 123;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 126;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","You can use ABMSocialOAuth to allow users to login in you app using social network identification. You must be familiar with Web App registrations on the social sites as this is out of the scope of ABMaterial. The following networks are supported:")));
 //BA.debugLineNum = 129;BA.debugLine="Dim sOAuth As ABMSocialOAuth";
_soauth = new com.ab.abmaterial.ABMSocialOAuth();
 //BA.debugLineNum = 130;BA.debugLine="sOAuth.Initialize(page, \"sOAuth\")";
_soauth.Initialize(_page,"sOAuth");
 //BA.debugLineNum = 131;BA.debugLine="sOAuth.AddFacebookButton(\"YOURDOMAIN.COM\",\"YOURKE";
_soauth.AddFacebookButton("YOURDOMAIN.COM","YOURKEY","Sign on with Facebook");
 //BA.debugLineNum = 132;BA.debugLine="sOAuth.AddTwitterButton(\"YOURDOMAIN.COM\",\"YOURKEY";
_soauth.AddTwitterButton("YOURDOMAIN.COM","YOURKEY","Sign on with Twitter");
 //BA.debugLineNum = 133;BA.debugLine="sOAuth.AddGooglePlusButton(\"YOURKEY.COM\", \"Sign o";
_soauth.AddGooglePlusButton("YOURKEY.COM","Sign on with Google Plus");
 //BA.debugLineNum = 134;BA.debugLine="sOAuth.AddLinkedInButton(\"YOURKEY.COM\", \"Sign on";
_soauth.AddLinkedInButton("YOURKEY.COM","Sign on with LinkedIn");
 //BA.debugLineNum = 135;BA.debugLine="sOAuth.AddWindowsLiveButton(\"YOURDOMAIN.COM\",\"YOU";
_soauth.AddWindowsLiveButton("YOURDOMAIN.COM","YOURKEY","Sign on with Windows Live");
 //BA.debugLineNum = 136;BA.debugLine="sOAuth.AddFourSquareButton(\"YOURDOMAIN.COM\",\"YOUR";
_soauth.AddFourSquareButton("YOURDOMAIN.COM","YOURKEY","Sign on with FourSquare");
 //BA.debugLineNum = 137;BA.debugLine="sOAuth.AddInstagramButton(\"YOURDOMAIN.COM\",\"YOURK";
_soauth.AddInstagramButton("YOURDOMAIN.COM","YOURKEY","Sign on with Instagram");
 //BA.debugLineNum = 138;BA.debugLine="sOAuth.AddSoundCloudButton(\"YOURDOMAIN.COM\",\"YOUR";
_soauth.AddSoundCloudButton("YOURDOMAIN.COM","YOURKEY","Sign on with SoundCloud");
 //BA.debugLineNum = 139;BA.debugLine="sOAuth.AddYahooButton(\"YOURDOMAIN.COM\",\"YOURKEY\",";
_soauth.AddYahooButton("YOURDOMAIN.COM","YOURKEY","Sign on with Yahoo");
 //BA.debugLineNum = 141;BA.debugLine="page.Cell(2,1).AddComponent(sOAuth)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_soauth));
 //BA.debugLineNum = 143;BA.debugLine="Dim code As String = $\"// via social network Dim";
_code = ("// via social network\n"+"Dim sOAuth As ABMSocialOAuth\n"+"sOAuth.Initialize(page, \"sOAuth\")\n"+"sOAuth.AddFacebookButton(\"YOURDOMAIN.COM\",\"YOURKEY\", \"Sign on with Facebook\")\n"+"sOAuth.AddTwitterButton(\"YOURDOMAIN.COM\",\"YOURKEY\", \"Sign on with Twitter\")\n"+"sOAuth.AddGooglePlusButton(\"YOURKEY.COM\", \"Sign on with Google Plus\")\n"+"sOAuth.AddLinkedInButton(\"YOURKEY.COM\", \"Sign on with LinkedIn\")\n"+"sOAuth.AddWindowsLiveButton(\"YOURDOMAIN.COM\",\"YOURKEY\", \"Sign on with Windows Live\")\n"+"sOAuth.AddFourSquareButton(\"YOURDOMAIN.COM\",\"YOURKEY\", \"Sign on with FourSquare\")\n"+"sOAuth.AddInstagramButton(\"YOURDOMAIN.COM\",\"YOURKEY\", \"Sign on with Instagram\")\n"+"sOAuth.AddSoundCloudButton(\"YOURDOMAIN.COM\",\"YOURKEY\", \"Sign on with SoundCloud\")\n"+"sOAuth.AddYahooButton(\"YOURDOMAIN.COM\",\"YOURKEY\", \"Sign on with Yahoo\")\n"+"	\n"+"page.Cell(2,1).AddComponent(sOAuth)");
 //BA.debugLineNum = 158;BA.debugLine="page.Cell(2,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code",_code)));
 //BA.debugLineNum = 164;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","For every network you have to identify your app and set the domain (not for LinkedIn and Google Plus) and the key you get from their registration page.")));
 //BA.debugLineNum = 167;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Some registration pages:")));
 //BA.debugLineNum = 170;BA.debugLine="Dim s As String = \"Facebook at {AL}https://develo";
_s = "Facebook at {AL}https://developers.facebook.com/{AT}https://developers.facebook.com/{/AL}{BR}Twitter at {AL}https://apps.twitter.com/{AT}https://apps.twitter.com/{/AL}{BR}Google Plus at {AL}https://console.developers.google.com{AT}https://console.developers.google.com{/AL}{BR}Windows Live at {AL}http://manage.dev.live.com{AT}http://manage.dev.live.com{/AL}{BR}LinkedIn at {AL}https://www.linkedin.com/secure/developer{AT}https://www.linkedin.com/secure/developer{/AL}{BR}Yahoo at {AL}https://developer.yahoo.com/{AT}https://developer.yahoo.com/{/AL}{BR}SoundCloud at {AL}http://soundcloud.com/you/apps/{AT}http://soundcloud.com/you/apps/{/AL}{BR}FourSquare at {AL}https://foursquare.com/developers/apps{AT}https://foursquare.com/developers/apps{/AL}{BR}Instagram at {AL}http://instagram.com/developer/clients/manage/{AT}http://instagram.com/developer/clients/manage/{/AL}{BR}";
 //BA.debugLineNum = 171;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3",_s)));
 //BA.debugLineNum = 174;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr2","Note")));
 //BA.debugLineNum = 177;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","Some networks allow debugging on your localhost (Facebook, Twitter, Windows Live and maybe others).  Here is an example of the settings for facebook.  I'm not familiar enough with this subject for other networks, so questions about this could be asked on some gurus on the B4J forum.")));
 //BA.debugLineNum = 179;BA.debugLine="Dim img2 As ABMImage";
_img2 = new com.ab.abmaterial.ABMImage();
 //BA.debugLineNum = 180;BA.debugLine="img2.Initialize(page, \"img2\", \"../images/facebook";
_img2.Initialize(_page,"img2","../images/facebook.jpg",1);
 //BA.debugLineNum = 181;BA.debugLine="img2.IsResponsive=True";
_img2.IsResponsive = __c.True;
 //BA.debugLineNum = 182;BA.debugLine="page.Cell(4,1).AddComponent(img2)";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_img2));
 //BA.debugLineNum = 185;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 187;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 190;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 192;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 193;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 196;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 197;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 198;BA.debugLine="If Action = \"ABMSocialOAuth\" Then Return";
if ((_action).equals("ABMSocialOAuth")) { 
if (true) return "";};
 //BA.debugLineNum = 199;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 200;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 201;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 202;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 204;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 205;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 206;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 208;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 209;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 211;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 212;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 213;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 214;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 215;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
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
