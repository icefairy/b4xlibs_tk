package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compsignaturepage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compsignaturepage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compsignaturepage.class).invoke(this, new Object[] {null});
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
public String _downloadfolder = "";
public String _downloadmaxsize = "";
public int _mytoastid = 0;
public int _signcounter = 0;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _btnclear_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMSignaturePad _sign1 = null;
 //BA.debugLineNum = 258;BA.debugLine="Sub btnClear_Clicked(Target As String)";
 //BA.debugLineNum = 259;BA.debugLine="Dim sign1 As ABMSignaturePad = page.Cell(2,1).Com";
_sign1 = (com.ab.abmaterial.ABMSignaturePad)(_page.Cell((int) (2),(int) (1)).Component("sign1"));
 //BA.debugLineNum = 260;BA.debugLine="sign1.Clear";
_sign1.Clear();
 //BA.debugLineNum = 261;BA.debugLine="End Sub";
return "";
}
public String  _btngetsign_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMSignaturePad _sign1 = null;
 //BA.debugLineNum = 263;BA.debugLine="Sub btnGetSign_Clicked(Target As String)";
 //BA.debugLineNum = 264;BA.debugLine="Dim sign1 As ABMSignaturePad = page.Cell(2,1).Com";
_sign1 = (com.ab.abmaterial.ABMSignaturePad)(_page.Cell((int) (2),(int) (1)).Component("sign1"));
 //BA.debugLineNum = 265;BA.debugLine="SignCounter =SignCounter + 1";
_signcounter = (int) (_signcounter+1);
 //BA.debugLineNum = 266;BA.debugLine="sign1.GetDrawingURI(\"Signature\" & SignCounter & \"";
_sign1.GetDrawingURI("Signature"+BA.NumberToString(_signcounter)+".jpg");
 //BA.debugLineNum = 267;BA.debugLine="End Sub";
return "";
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 120;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 122;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 125;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 126;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 127;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 128;BA.debugLine="page.PageTitle = \"ABMSignature\"";
_page.PageTitle = "ABMSignature";
 //BA.debugLineNum = 129;BA.debugLine="page.PageDescription = \"The signature component \"";
_page.PageDescription = "The signature component ";
 //BA.debugLineNum = 130;BA.debugLine="page.PageHTMLName = \"abmaterial-signature.html\"";
_page.PageHTMLName = "abmaterial-signature.html";
 //BA.debugLineNum = 131;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 132;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 133;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 134;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 136;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMSignatureP";
_abmshared._buildnavigationbar(_page,"ABMSignaturePad","../images/logo.png","","Controls","ABMSignaturePad");
 //BA.debugLineNum = 139;BA.debugLine="page.AddRows(7,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (7),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 140;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 145;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 146;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 104;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 105;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 109;BA.debugLine="theme.AddButtonTheme(\"bluegrey\")";
_theme.AddButtonTheme("bluegrey");
 //BA.debugLineNum = 110;BA.debugLine="theme.Button(\"bluegrey\").BackColor = ABM.COLOR_BL";
_theme.Button("bluegrey").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 111;BA.debugLine="theme.Button(\"bluegrey\").BackColorIntensity = ABM";
_theme.Button("bluegrey").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 114;BA.debugLine="theme.AddToastTheme(\"toastgreen\")";
_theme.AddToastTheme("toastgreen");
 //BA.debugLineNum = 115;BA.debugLine="theme.Toast(\"toastgreen\").Rounded = True";
_theme.Toast("toastgreen").Rounded = __c.True;
 //BA.debugLineNum = 116;BA.debugLine="theme.Toast(\"toastgreen\").ActionForeColor = ABM.C";
_theme.Toast("toastgreen").ActionForeColor = _abm.COLOR_BLACK;
 //BA.debugLineNum = 117;BA.debugLine="theme.Toast(\"toastgreen\").BackColor = ABM.COLOR_G";
_theme.Toast("toastgreen").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompSignaturePage\"";
_name = "CompSignaturePage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 15;BA.debugLine="Public DownloadFolder As String = \"/www/\" & ABMSh";
_downloadfolder = "/www/"+_abmshared._appname+"/uploads/";
 //BA.debugLineNum = 16;BA.debugLine="Public DownloadMaxSize As String = 2*1024*1024";
_downloadmaxsize = BA.NumberToString(2*1024*1024);
 //BA.debugLineNum = 19;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 20;BA.debugLine="Dim SignCounter As Int";
_signcounter = 0;
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMSignaturePad _sign1 = null;
com.ab.abmaterial.ABMButton _btnclear = null;
com.ab.abmaterial.ABMButton _btngetsign = null;
String _code1 = "";
String _code2 = "";
String _code3 = "";
String _code = "";
 //BA.debugLineNum = 148;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 150;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 153;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","ABMSignaturePad can be used to draw simple sketches like signatures from a client.")));
 //BA.debugLineNum = 156;BA.debugLine="Dim sign1 As ABMSignaturePad";
_sign1 = new com.ab.abmaterial.ABMSignaturePad();
 //BA.debugLineNum = 157;BA.debugLine="sign1.Initialize(page, \"sign1\", 640, 360, ABM.COL";
_sign1.Initialize(_page,"sign1",(int) (640),(int) (360),_abm.COLOR_WHITE,_abm.INTENSITY_NORMAL,_abm.COLOR_BLUEGREY,_abm.INTENSITY_DARKEN2,_abm.ZDEPTH_1);
 //BA.debugLineNum = 158;BA.debugLine="page.Cell(2,1).AddComponent(sign1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_sign1));
 //BA.debugLineNum = 161;BA.debugLine="Dim btnClear As ABMButton";
_btnclear = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 162;BA.debugLine="btnClear.InitializeRaised(page, \"btnClear\", \"\", \"";
_btnclear.InitializeRaised(_page,"btnClear","","","Clear","bluegrey");
 //BA.debugLineNum = 163;BA.debugLine="page.Cell(3,1).AddComponent(btnClear)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnclear));
 //BA.debugLineNum = 165;BA.debugLine="Dim btnGetSign As ABMButton";
_btngetsign = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 166;BA.debugLine="btnGetSign.InitializeRaised(page, \"btnGetSign\", \"";
_btngetsign.InitializeRaised(_page,"btnGetSign","","","Get Signature","bluegrey");
 //BA.debugLineNum = 167;BA.debugLine="page.Cell(3,1).AddComponent(btnGetSign)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btngetsign));
 //BA.debugLineNum = 170;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","You can Clear() the Pad or retrieve the drawing with GetDrawingAsJpeg().")));
 //BA.debugLineNum = 173;BA.debugLine="Dim code1 As String = $\"Sub btnClear_Clicked(Targ";
_code1 = ("Sub btnClear_Clicked(Target As String)\n"+"	Dim sign1 As ABMSignaturePad = page.Cell(2,1).Component(\"sign1\")\n"+"	sign1.Clear\n"+"End Sub");
 //BA.debugLineNum = 178;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code1)));
 //BA.debugLineNum = 181;BA.debugLine="Dim code2 As String = $\"Sub btnGetSign_Clicked(Ta";
_code2 = ("Sub btnGetSign_Clicked(Target As String)\n"+"	Dim sign1 As ABMSignaturePad = page.Cell(2,1).Component(\"sign1\")\n"+"	SignCounter =SignCounter + 1\n"+"	sign1.GetDrawingURI(\"Signature\" & SignCounter & \".jpg\")	\n"+"End Sub");
 //BA.debugLineNum = 187;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code2",_code2)));
 //BA.debugLineNum = 190;BA.debugLine="Dim code3 As String = $\"Sub Page_FileUploaded(Fil";
_code3 = ("Sub Page_FileUploaded(FileName As String, success As Boolean)\n"+"	myToastId = myToastId + 1	\n"+"	If success Then\n"+"		page.ShowToast(\"toast\" & myToastId, \"toastgreen\", \"File \" & FileName & \" uploaded!\", 5000)\n"+"	Else\n"+"		page.ShowToast(\"toast\" & myToastId, \"toastred\", \"File \" & FileName & \" uploaded!\", 5000)\n"+"	End If\n"+"	page.ws.Flush // IMPORTANT\n"+"End Sub");
 //BA.debugLineNum = 200;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code3",_code3)));
 //BA.debugLineNum = 203;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","Additionally, you have to add the following lines of code to WebSocket_Connected() and WebSocket_Disconnected()!")));
 //BA.debugLineNum = 206;BA.debugLine="Dim code As String = $\"// In WebSocket_Connected(";
_code = ("// In WebSocket_Connected()\n"+"ws.Session.SetAttribute(\"abmcallback\", Me)	\n"+"ws.Session.SetAttribute(\"abmdownloadfolder\", DownloadFolder)\n"+"ws.Session.SetAttribute(\"abmmaxsize\", DownloadMaxSize)");
 //BA.debugLineNum = 211;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code4",_code)));
 //BA.debugLineNum = 213;BA.debugLine="code = $\"// In WebSocket_Disconnected() Try 	ws.S";
_code = ("// In WebSocket_Disconnected()\n"+"Try\n"+"	ws.Session.RemoveAttribute(\"abmcallback\")	\n"+"	ws.Session.RemoveAttribute(\"abmdownloadfolder\")\n"+"	ws.Session.RemoveAttribute(\"abmmaxsize\")\n"+"Catch\n"+"	Log(LastException.Message)\n"+"End Try");
 //BA.debugLineNum = 222;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code5",_code)));
 //BA.debugLineNum = 225;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 227;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 230;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 232;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 233;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 24;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 26;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public String  _page_fileuploaded(String _filename,boolean _success) throws Exception{
 //BA.debugLineNum = 269;BA.debugLine="Sub Page_FileUploaded(FileName As String, success";
 //BA.debugLineNum = 270;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 271;BA.debugLine="If success Then";
if (_success) { 
 //BA.debugLineNum = 272;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastgreen\"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastgreen","File "+_filename+" uploaded!",(int) (5000));
 }else {
 //BA.debugLineNum = 274;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","File "+_filename+" not uploaded (Exists?)",(int) (5000));
 };
 //BA.debugLineNum = 276;BA.debugLine="page.ws.Flush ' IMPORTANT";
_page.ws.Flush();
 //BA.debugLineNum = 277;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 236;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 237;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 238;BA.debugLine="If Action = \"ABMSignaturePad\" Then Return";
if ((_action).equals("ABMSignaturePad")) { 
if (true) return "";};
 //BA.debugLineNum = 239;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 240;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 241;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 242;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 244;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 245;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 246;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 248;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 249;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 72;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 73;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 74;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 75;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 76;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 77;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 78;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 80;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 81;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 82;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 83;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 85;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 87;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 89;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 90;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 91;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 93;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 97;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 251;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 252;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 253;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 254;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 255;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 29;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 30;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 31;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 32;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 33;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 35;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 36;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 37;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 38;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 42;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 43;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 45;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 47;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 50;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 52;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 54;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 56;BA.debugLine="ws.Session.SetAttribute(\"abmcallback\", Me)";
_ws.getSession().SetAttribute("abmcallback",this);
 //BA.debugLineNum = 57;BA.debugLine="ws.Session.SetAttribute(\"abmdownloadfolder\", Down";
_ws.getSession().SetAttribute("abmdownloadfolder",(Object)(_downloadfolder));
 //BA.debugLineNum = 58;BA.debugLine="ws.Session.SetAttribute(\"abmmaxsize\", DownloadMax";
_ws.getSession().SetAttribute("abmmaxsize",(Object)(_downloadmaxsize));
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 61;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 62;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 63;BA.debugLine="Try";
try { //BA.debugLineNum = 64;BA.debugLine="ws.Session.RemoveAttribute(\"abmcallback\")";
_ws.getSession().RemoveAttribute("abmcallback");
 //BA.debugLineNum = 65;BA.debugLine="ws.Session.RemoveAttribute(\"abmdownloadfolder\")";
_ws.getSession().RemoveAttribute("abmdownloadfolder");
 //BA.debugLineNum = 66;BA.debugLine="ws.Session.RemoveAttribute(\"abmmaxsize\")";
_ws.getSession().RemoveAttribute("abmmaxsize");
 } 
       catch (Exception e7) {
			ba.setLastException(e7); //BA.debugLineNum = 68;BA.debugLine="Log(LastException.Message)";
__c.Log(__c.LastException(ba).getMessage());
 };
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "PAGE_FILEUPLOADED"))
	return _page_fileuploaded((String) args[0], (Boolean) args[1]);
return BA.SubDelegator.SubNotFound;
}
}
