package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class comppercentsliderpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.comppercentsliderpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.comppercentsliderpage.class).invoke(this, new Object[] {null});
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
public String  _btn_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMPercentSlider _duration = null;
int _res = 0;
anywheresoftware.b4a.objects.collections.List _choices = null;
 //BA.debugLineNum = 191;BA.debugLine="Sub btn_Clicked(Target As String)";
 //BA.debugLineNum = 192;BA.debugLine="Dim duration As ABMPercentSlider = page.Component";
_duration = (com.ab.abmaterial.ABMPercentSlider)(_page.Component("duration"));
 //BA.debugLineNum = 193;BA.debugLine="Dim res As Int = duration.GetActiveUntilBlock";
_res = _duration.GetActiveUntilBlock();
 //BA.debugLineNum = 195;BA.debugLine="Dim choices As List";
_choices = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 196;BA.debugLine="choices.Initialize2(Array As String(\"Monthly\", \"Q";
_choices.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Monthly","Quarterly","Half-Yearly","Yearly"}));
 //BA.debugLineNum = 198;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 199;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","You picked "+BA.ObjectToString(_choices.Get(_res)),(int) (5000));
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 102;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 105;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 106;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 107;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 108;BA.debugLine="page.PageTitle = \"ABMPercentSlider\"";
_page.PageTitle = "ABMPercentSlider";
 //BA.debugLineNum = 109;BA.debugLine="page.PageDescription = \"The percent slider compon";
_page.PageDescription = "The percent slider component ";
 //BA.debugLineNum = 110;BA.debugLine="page.PageHTMLName = \"abmaterial-percentslider.htm";
_page.PageHTMLName = "abmaterial-percentslider.html";
 //BA.debugLineNum = 111;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 112;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 113;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 114;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 116;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMPercentSli";
_abmshared._buildnavigationbar(_page,"ABMPercentSlider","../images/logo.png","","Controls","ABMPercentSlider");
 //BA.debugLineNum = 119;BA.debugLine="page.AddRows(6,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (6),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 120;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 125;BA.debugLine="ABMShared.BuildFooterFixed(page)";
_abmshared._buildfooterfixed(_page);
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 93;BA.debugLine="theme.AddPercentSliderTheme(\"demo\")";
_theme.AddPercentSliderTheme("demo");
 //BA.debugLineNum = 94;BA.debugLine="theme.PercentSlider(\"demo\").BlockColor(0,ABM.COLO";
_theme.PercentSlider("demo").BlockColor((int) (0),_abm.COLOR_LIGHTBLUE);
 //BA.debugLineNum = 95;BA.debugLine="theme.PercentSlider(\"demo\").BlockColor(1, ABM.COL";
_theme.PercentSlider("demo").BlockColor((int) (1),_abm.COLOR_GREEN);
 //BA.debugLineNum = 96;BA.debugLine="theme.PercentSlider(\"demo\").BlockColor(2, ABM.COL";
_theme.PercentSlider("demo").BlockColor((int) (2),_abm.COLOR_ORANGE);
 //BA.debugLineNum = 97;BA.debugLine="theme.PercentSlider(\"demo\").BlockColor(3, ABM.COL";
_theme.PercentSlider("demo").BlockColor((int) (3),_abm.COLOR_RED);
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompPercentSliderPage\"";
_name = "CompPercentSliderPage";
 //BA.debugLineNum = 12;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 15;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMLabel _label = null;
com.ab.abmaterial.ABMPercentSlider _duration = null;
com.ab.abmaterial.ABMButton _btn = null;
String _code = "";
 //BA.debugLineNum = 128;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 130;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 133;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","ABMPercentSlider is a slider bar that acts like a radiogroup.  It comes in handy if for input that is time based.")));
 //BA.debugLineNum = 134;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","The width of each bar is set in increments of 5% and ranges from 5% to 100%.")));
 //BA.debugLineNum = 137;BA.debugLine="Dim label As ABMLabel";
_label = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 138;BA.debugLine="label.Initialize(page, \"label\", \"Choose Your Paym";
_label.Initialize(_page,"label","Choose Your Payment Schedule",_abm.SIZE_H4,__c.False,"");
 //BA.debugLineNum = 139;BA.debugLine="page.Cell(2,1).AddComponent(label)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_label));
 //BA.debugLineNum = 141;BA.debugLine="Dim duration As ABMPercentSlider";
_duration = new com.ab.abmaterial.ABMPercentSlider();
 //BA.debugLineNum = 142;BA.debugLine="duration.Initialize(page, \"duration\", \"demo\")";
_duration.Initialize(_page,"duration","demo");
 //BA.debugLineNum = 143;BA.debugLine="duration.AddBlock(\"Monthly\", \"awesome!\", 10)";
_duration.AddBlock("Monthly","awesome!",(int) (10));
 //BA.debugLineNum = 144;BA.debugLine="duration.AddBlock(\"Quarterly\", \"great\", 25)";
_duration.AddBlock("Quarterly","great",(int) (25));
 //BA.debugLineNum = 145;BA.debugLine="duration.AddBlock(\"Half-Yearly\", \"half is good\",";
_duration.AddBlock("Half-Yearly","half is good",(int) (55));
 //BA.debugLineNum = 146;BA.debugLine="duration.AddBlock(\"Yearly\", \"too long!\", 100)";
_duration.AddBlock("Yearly","too long!",(int) (100));
 //BA.debugLineNum = 147;BA.debugLine="duration.SetActiveUntilBlock(1)";
_duration.SetActiveUntilBlock((int) (1));
 //BA.debugLineNum = 149;BA.debugLine="page.Cell(3,1).AddComponent(duration)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_duration));
 //BA.debugLineNum = 151;BA.debugLine="Dim btn As ABMButton";
_btn = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 152;BA.debugLine="btn.InitializeFlat(page, \"btn\", \"\", \"\", \"What was";
_btn.InitializeFlat(_page,"btn","","","What was picked?","");
 //BA.debugLineNum = 153;BA.debugLine="page.Cell(4,1).AddComponent(btn)";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn));
 //BA.debugLineNum = 156;BA.debugLine="Dim code As String";
_code = "";
 //BA.debugLineNum = 157;BA.debugLine="code = $\"Dim duration As ABMPercentSlider duratio";
_code = ("Dim duration As ABMPercentSlider\n"+"duration.Initialize(page, \"duration\", \"demo\")\n"+"duration.AddBlock(\"Monthly\", \"awesome!\", 10)\n"+"duration.AddBlock(\"Quarterly\", \"great\", 25)\n"+"duration.AddBlock(\"Half-Yearly\", \"half is good\", 55)\n"+"duration.AddBlock(\"Yearly\", \"too long!\", 100)\n"+"duration.SetActiveUntilBlock(1)");
 //BA.debugLineNum = 165;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code",_code)));
 //BA.debugLineNum = 167;BA.debugLine="code = $\"Sub btn_Clicked(Target As String) 	Dim d";
_code = ("Sub btn_Clicked(Target As String)\n"+"	Dim duration As ABMPercentSlider = page.Component(\"duration\")\n"+"	Dim res As Int = duration.GetActiveUntilBlock\n"+"	\n"+"	Dim choices As List\n"+"	choices.Initialize2(Array As String(\"Monthly\", \"Quarterly\", \"Half-Yearly\", \"Yearly\"))\n"+"	\n"+"	myToastId = myToastId + 1		\n"+"	page.ShowToast(\"toast\" & myToastId, \"toastred\", \"You picked \" & choices.get(res), 5000)\n"+"End Sub");
 //BA.debugLineNum = 178;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code2",_code)));
 //BA.debugLineNum = 181;BA.debugLine="ABMShared.ConnectFooterFixed(page)";
_abmshared._connectfooterfixed(_page);
 //BA.debugLineNum = 183;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 186;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 188;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 189;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 203;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 204;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 205;BA.debugLine="If Action = \"ABMPercentSlider\" Then Return";
if ((_action).equals("ABMPercentSlider")) { 
if (true) return "";};
 //BA.debugLineNum = 206;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 207;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 208;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 209;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 211;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 212;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 213;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 215;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 216;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 218;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 219;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 220;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 221;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 222;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 223;BA.debugLine="End Sub";
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
