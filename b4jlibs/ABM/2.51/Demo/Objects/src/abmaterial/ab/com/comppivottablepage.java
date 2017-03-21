package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class comppivottablepage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.comppivottablepage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.comppivottablepage.class).invoke(this, new Object[] {null});
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
 //BA.debugLineNum = 102;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 103;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 104;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 105;BA.debugLine="page.PageTitle = \"ABMPivotTable\"";
_page.PageTitle = "ABMPivotTable";
 //BA.debugLineNum = 106;BA.debugLine="page.PageDescription = \"The Pivot table component";
_page.PageDescription = "The Pivot table component ";
 //BA.debugLineNum = 107;BA.debugLine="page.PageHTMLName = \"abmaterial-pivottable.html\"";
_page.PageHTMLName = "abmaterial-pivottable.html";
 //BA.debugLineNum = 108;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 109;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 110;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 111;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 113;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMPivotTable";
_abmshared._buildnavigationbar(_page,"ABMPivotTable","../images/logo.png","","Controls","ABMPivotTable");
 //BA.debugLineNum = 116;BA.debugLine="page.AddRows(8,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (8),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 117;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 122;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 93;BA.debugLine="theme.AddPivotTable(\"pivot\")";
_theme.AddPivotTable("pivot");
 //BA.debugLineNum = 94;BA.debugLine="theme.PivotTable(\"pivot\").BackColor = ABM.COLOR_W";
_theme.PivotTable("pivot").BackColor = _abm.COLOR_WHITE;
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompPivotTablePage\"";
_name = "CompPivotTablePage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMPivotTable _pivot = null;
com.ab.abmaterial.ABMButton _exportbtn = null;
String _code1 = "";
String _code2 = "";
 //BA.debugLineNum = 125;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 127;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 130;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","In data processing, a pivot table is a data summarization tool found in data visualization programs such as spreadsheets or business intelligence software. ABMPivotTable is such a component where the user can drag/drop data elements to generate their own overview for analysis.")));
 //BA.debugLineNum = 132;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","You have to provide it with a .csv file and which data elements the user can use. {B}NOTE:{/B} As all this data has to be send over and processed in the users browser, you better 'pre-filter' the data you send in the .csv file!")));
 //BA.debugLineNum = 134;BA.debugLine="Dim pivot As ABMPivotTable";
_pivot = new com.ab.abmaterial.ABMPivotTable();
 //BA.debugLineNum = 135;BA.debugLine="pivot.Initialize(page, \"pivot\", 500, \"../pivots/P";
_pivot.Initialize(_page,"pivot",(int) (500),"../pivots/Pivot.csv","Person code,Person name","Project code,Project name","Decimal,Price",__c.False,"pivot");
 //BA.debugLineNum = 136;BA.debugLine="pivot.UsesSubTotals = True";
_pivot.UsesSubTotals = __c.True;
 //BA.debugLineNum = 137;BA.debugLine="pivot.UsesGoogleCharts = True";
_pivot.UsesGoogleCharts = __c.True;
 //BA.debugLineNum = 139;BA.debugLine="page.Cell(2,1).AddComponent(pivot)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_pivot));
 //BA.debugLineNum = 141;BA.debugLine="Dim exportBtn As ABMButton";
_exportbtn = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 142;BA.debugLine="exportBtn.InitializeFlat(page, \"exportBtn\", \"\", \"";
_exportbtn.InitializeFlat(_page,"exportBtn","","","Export","");
 //BA.debugLineNum = 143;BA.debugLine="page.Cell(3,1).AddComponent(exportBtn)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_exportbtn));
 //BA.debugLineNum = 145;BA.debugLine="Dim code1 As String = $\"Dim pivot As ABMPivotTabl";
_code1 = ("Dim pivot As ABMPivotTable\n"+"pivot.Initialize(page, \"pivot\", 500, \"../pivots/Pivot.csv\", \"Person code,Person name\", \"Project code,Project name\", \"Decimal,Price\", \"pivot\")\n"+"page.Cell(2,1).AddComponent(pivot)");
 //BA.debugLineNum = 149;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code1)));
 //BA.debugLineNum = 151;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","Make sure the field names used in the axes and hidden field params are the same!  Here is a snippit of how the CSV in the above Pivot table looks like.")));
 //BA.debugLineNum = 153;BA.debugLine="Dim code2 As String = $\"Person code,Person name,P";
_code2 = ("Person code,Person name,Project code,Project name,Activity code,Activity name,Decimal,Price,Year,Month\n"+"Piet,Piet Van Dender,VDP,VDP INTERIEUR BVBA,Z Opkuisen atelier,Z Opkuisen atelier,3.6,0,2096,8\n"+"Piet,Piet Van Dender,VDP,VDP INTERIEUR BVBA,Z Opkuisen atelier,Z Opkuisen atelier,3.78,0,2096,8\n"+"Piet,Piet Van Dender,150090b Van Gasse,150090b Van Gasse,Maatwerk PLAATSEN,Maatwerk PLAATSEN,3.25,126.75,2096,8\n"+"Piet,Piet Van Dender,150090b Van Gasse,150090b Van Gasse,Maatwerk PLAATSEN,Maatwerk PLAATSEN,3.15,122.85,2096,8\n"+"Piet,Piet Van Dender,,,X Extra werk allerlei,X Extra werk allerlei,0.92,35.75,2096,8\n"+"Piet,Piet Van Dender,150104 Bogaert,150104 Bogaert,X Extra werk allerlei,X Extra werk allerlei,1.02,39.65,2096,8\n"+"Piet,Piet Van Dender,VDP,VDP INTERIEUR BVBA,Administratie,Administratie,1.37,0,2096,8\n"+"Piet,Piet Van Dender,140040b KNOP,140040b KNOP,Maatwerk MAKEN,Maatwerk MAKEN,0.53,20.8,2096,8\n"+"Piet,Piet Van Dender,VDP,VDP INTERIEUR BVBA,Z Opkuisen atelier,Z Opkuisen atelier,18.82,0,2096,8\n"+"Piet,Piet Van Dender,150040 Knop ,150040 Knop ,Maatwerk PLAATSEN,Maatwerk PLAATSEN,2.7,105.3,2096,8\n"+"Piet,Piet Van Dender,150104 Bogaert,150104 Bogaert,X Extra werk allerlei,X Extra werk allerlei,0.97,37.7,2096,8\n"+"Piet,Piet Van Dender,150040 Knop ,150040 Knop ,Maatwerk PLAATSEN,Maatwerk PLAATSEN,3.97,154.7,2096,8\n"+"Piet,Piet Van Dender,150040 Knop ,150040 Knop ,Maatwerk PLAATSEN,Maatwerk PLAATSEN,4.15,161.85,2096,8\n"+"Piet,Piet Van Dender,150040 Knop ,150040 Knop ,Maatwerk PLAATSEN,Maatwerk PLAATSEN,3.97,154.7,2096,8\n"+"Piet,Piet Van Dender,VDP,VDP INTERIEUR BVBA,Administratie,Administratie,0.65,0,2096,8\n"+"...");
 //BA.debugLineNum = 171;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code2",_code2)));
 //BA.debugLineNum = 174;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 176;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 179;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 181;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 182;BA.debugLine="End Sub";
return "";
}
public String  _exportbtn_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMPivotTable _pivot = null;
 //BA.debugLineNum = 184;BA.debugLine="Sub exportbtn_Clicked(Target As String)";
 //BA.debugLineNum = 185;BA.debugLine="Dim pivot As ABMPivotTable = page.Component(\"pivo";
_pivot = (com.ab.abmaterial.ABMPivotTable)(_page.Component("pivot"));
 //BA.debugLineNum = 186;BA.debugLine="pivot.ExportToXLS(\"alainTest\", \".\",\",\",\".\",\"\")";
_pivot.ExportToXLS("alainTest",".",",",".","");
 //BA.debugLineNum = 187;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 190;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 191;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 192;BA.debugLine="If Action = \"ABMPivotTable\" Then Return";
if ((_action).equals("ABMPivotTable")) { 
if (true) return "";};
 //BA.debugLineNum = 193;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 194;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 195;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 196;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 198;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 199;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 200;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 202;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 203;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 205;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 206;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 207;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 208;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 209;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 210;BA.debugLine="End Sub";
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
