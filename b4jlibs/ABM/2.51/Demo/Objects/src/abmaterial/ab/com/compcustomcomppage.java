package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compcustomcomppage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compcustomcomppage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compcustomcomppage.class).invoke(this, new Object[] {null});
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
 //BA.debugLineNum = 97;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 99;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 102;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 103;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 104;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 105;BA.debugLine="page.PageTitle = \"ABMCustomComponent\"";
_page.PageTitle = "ABMCustomComponent";
 //BA.debugLineNum = 106;BA.debugLine="page.PageDescription = \"The custom component \"";
_page.PageDescription = "The custom component ";
 //BA.debugLineNum = 107;BA.debugLine="page.PageHTMLName = \"abmaterial-custom-component.";
_page.PageHTMLName = "abmaterial-custom-component.html";
 //BA.debugLineNum = 108;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 109;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 110;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 111;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 113;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMCustomComp";
_abmshared._buildnavigationbar(_page,"ABMCustomComponent","../images/logo.png","","Controls","ABMCustomComponent");
 //BA.debugLineNum = 116;BA.debugLine="page.AddRows(1,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 117;BA.debugLine="page.AddRows(1,True, \"\").AddCells12(1,\"aligncente";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"aligncenter");
 //BA.debugLineNum = 118;BA.debugLine="page.AddRows(14,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (14),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 119;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 122;BA.debugLine="page.AddExtraJavaScriptFile(\"custom/nouislider.mi";
_page.AddExtraJavaScriptFile("custom/nouislider.min.js");
 //BA.debugLineNum = 123;BA.debugLine="page.AddExtraJavaScriptFile(\"custom/wNumb.js\")";
_page.AddExtraJavaScriptFile("custom/wNumb.js");
 //BA.debugLineNum = 124;BA.debugLine="page.AddExtraCSSFile(\"custom/nouislider.css\")";
_page.AddExtraCSSFile("custom/nouislider.css");
 //BA.debugLineNum = 126;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 93;BA.debugLine="theme.AddCellTheme(\"aligncenter\")";
_theme.AddCellTheme("aligncenter");
 //BA.debugLineNum = 94;BA.debugLine="theme.Cell(\"aligncenter\").Align = ABM.CELL_ALIGN_";
_theme.Cell("aligncenter").Align = _abm.CELL_ALIGN_CENTER;
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompCustomCompPage\"";
_name = "CompCustomCompPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
abmaterial.ab.com.customslidebar _custslider = null;
String _code1 = "";
String _code3 = "";
anywheresoftware.b4a.objects.collections.List _headers = null;
anywheresoftware.b4a.objects.collections.List _codes = null;
anywheresoftware.b4a.objects.collections.List _descriptions = null;
String _code2 = "";
 //BA.debugLineNum = 129;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 131;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 134;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","The ABMCustomComponent is a component for advanced users with good knowledge on Javascript/HTML/CSS and wants to add their own components to the ABMaterial framework.")));
 //BA.debugLineNum = 136;BA.debugLine="Dim custSlider As CustomSlidebar";
_custslider = new abmaterial.ab.com.customslidebar();
 //BA.debugLineNum = 137;BA.debugLine="custSlider.Initialize(page, \"custSlider\", 25)";
_custslider._initialize(ba,_page,"custSlider",25);
 //BA.debugLineNum = 138;BA.debugLine="page.Cell(2,1).AddComponent(custSlider.ABMComp)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_custslider._abmcomp));
 //BA.debugLineNum = 141;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","This is an example where we add a vertical noUISlider component to the framework.")));
 //BA.debugLineNum = 143;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","First we have to add our javascript and css files to the page:")));
 //BA.debugLineNum = 145;BA.debugLine="Dim code1 As String = $\"page.AddExtraJavaScriptFi";
_code1 = ("page.AddExtraJavaScriptFile(\"custom/nouislider.min.js\")\n"+"page.AddExtraJavaScriptFile(\"custom/wNumb.js\")\n"+"page.AddExtraCSSFile(\"custom/nouislider.css\")");
 //BA.debugLineNum = 149;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code1)));
 //BA.debugLineNum = 152;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","Create a new standard class. Here we call it CustomSlidebar.  Add two variables to the global: ")));
 //BA.debugLineNum = 154;BA.debugLine="Dim code3 As String = $\"Dim ABM As ABMaterial //";
_code3 = ("Dim ABM As ABMaterial // used for the modification methods.\n"+"Dim ABMComp As ABMCustomComponent // the component that holds the object.");
 //BA.debugLineNum = 157;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code3",_code3)));
 //BA.debugLineNum = 160;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par5","The ABMComp object has 4 events: ")));
 //BA.debugLineNum = 162;BA.debugLine="Dim Headers, codes, Descriptions As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
_codes = new anywheresoftware.b4a.objects.collections.List();
_descriptions = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 163;BA.debugLine="Headers.Initialize2(Array As String(\"Event\", \"Des";
_headers.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Event","Description"}));
 //BA.debugLineNum = 164;BA.debugLine="codes.Initialize2(Array As String(\"Build\", \"First";
_codes.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Build","FirstRun","Refresh","CleanUp"}));
 //BA.debugLineNum = 165;BA.debugLine="Descriptions.Initialize2(Array As String(\"Runs wh";
_descriptions.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Runs when an object is created for the first time.","Is useful to run some initialisation script.","runs when a refresh is called.","Do the stuff needed when the object is removed."}));
 //BA.debugLineNum = 166;BA.debugLine="page.Cell(8,1).AddComponent(ABMShared.BuildParamT";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparamtable(_page,"param2",_headers,_codes,_descriptions)));
 //BA.debugLineNum = 169;BA.debugLine="page.Cell(9,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par6","Check out the full source code of the CustomSlidebar class for more info.")));
 //BA.debugLineNum = 171;BA.debugLine="page.Cell(9,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par7","We're ready to add our new component to the page.")));
 //BA.debugLineNum = 173;BA.debugLine="Dim code2 As String = $\"Dim custSlider As CustomS";
_code2 = ("Dim custSlider As CustomSlidebar\n"+"custSlider.Initialize(page, \"custSlider\", 25)\n"+"page.CellR(2,1).AddComponent(custSlider.ABMComp)");
 //BA.debugLineNum = 177;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildCodeB";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code2",_code2)));
 //BA.debugLineNum = 180;BA.debugLine="page.Cell(11, 1).AddComponent(ABMShared.BuildPara";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par8","In the Refresh() event you can use some helper methods to modify the object.")));
 //BA.debugLineNum = 182;BA.debugLine="Headers.Initialize2(Array As String(\"Method\", \"De";
_headers.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Method","Description"}));
 //BA.debugLineNum = 183;BA.debugLine="codes.Initialize2(Array As String(\"HasClass\", \"Ad";
_codes.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"HasClass","AddClass","RemoveClass","AddHTML","InsertHTMLAfter","RemoveHTML","GetProperty","SetProperty","RemoveProperty","GetStyleProperty","SetStyleProperty"}));
 //BA.debugLineNum = 184;BA.debugLine="Descriptions.Initialize2(Array As String(\"Checks";
_descriptions.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Checks if a class is set on a tag","Adds a class to a tag","Removes a class from a tag","Appends HTML to a tag","Finds the parent of the tag and adds the HTML at the end of it","Removes the HTML from the tag","Gets a property of a tag","Sets a property of a tag","Removes a property from a tag","Gets the value of a style property of a tag","Sets the value of a style property of a tag"}));
 //BA.debugLineNum = 185;BA.debugLine="page.Cell(12,1).AddComponent(ABMShared.BuildParam";
_page.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparamtable(_page,"param3",_headers,_codes,_descriptions)));
 //BA.debugLineNum = 188;BA.debugLine="page.Cell(13, 1).AddComponent(ABMShared.BuildPara";
_page.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par9","All the Automatic events (clicked, mousemove, etc) will be automatically generated thanks to B4J.  For specific events, you'll have to program them yourself using the b4j_raiseEvent() method in javascript.  It will return the event on the page in the format: comp_event(params as Map).")));
 //BA.debugLineNum = 191;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 193;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 196;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 198;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public String  _custslider_changed(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
 //BA.debugLineNum = 201;BA.debugLine="Sub custSlider_Changed(Params As Map)";
 //BA.debugLineNum = 202;BA.debugLine="Log(\"changed\")";
__c.Log("changed");
 //BA.debugLineNum = 203;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 204;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","New value:"+BA.ObjectToString(_params.Get((Object)("value"))),(int) (5000));
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 208;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 209;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 210;BA.debugLine="If Action = \"ABMCustomComponent\" Then Return";
if ((_action).equals("ABMCustomComponent")) { 
if (true) return "";};
 //BA.debugLineNum = 211;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 212;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 213;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 214;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 216;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 217;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 218;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 220;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 221;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 223;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 224;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 225;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 226;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 227;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
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
