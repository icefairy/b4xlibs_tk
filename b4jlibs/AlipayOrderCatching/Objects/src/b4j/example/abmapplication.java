package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class abmapplication extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.ShellBA("b4j.example", "b4j.example.abmapplication", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.abmapplication.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
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
public b4j.example.main _main = null;
public b4j.example.abmshared _abmshared = null;
public b4j.example.dbm _dbm = null;
public String  _initialize(b4j.example.abmapplication __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "initialize"))
	return (String) Debug.delegate(ba, "initialize", new Object[] {_ba});
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Pages.Initialize";
__ref._pages.Initialize();
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="PageNeedsUpload.Initialize";
__ref._pageneedsupload.Initialize();
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="ABM.AppVersion = ABMShared.AppVersion";
__ref._abm.AppVersion = _abmshared._appversion;
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="ABM.AppPublishedStartURL = ABMShared.AppPublished";
__ref._abm.AppPublishedStartURL = _abmshared._apppublishedstarturl;
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="ABMShared.AppName = \"\"   '<----------------------";
_abmshared._appname = "";
RDebugUtils.currentLine=196632;
 //BA.debugLineNum = 196632;BA.debugLine="BuildPage";
__ref._buildpage(null);
RDebugUtils.currentLine=196633;
 //BA.debugLineNum = 196633;BA.debugLine="End Sub";
return "";
}
public String  _addpage(b4j.example.abmapplication __ref,com.ab.abmaterial.ABMPage _page) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "addpage"))
	return (String) Debug.delegate(ba, "addpage", new Object[] {_page});
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="public Sub AddPage(Page As ABMPage)";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Pages.Add(Page.Name)";
__ref._pages.Add((Object)(_page.getName()));
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="PageNeedsUpload.Add(ABM.WritePageToDisk(Page, Fil";
__ref._pageneedsupload.Add((Object)(__ref._abm.WritePageToDisk(_page,__c.File.getDirApp()+"/www/"+_abmshared._appname+"/"+_page.getName()+"/",_page.PageHTMLName,_abmshared._needsauthorization)));
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="End Sub";
return "";
}
public String  _startserver(b4j.example.abmapplication __ref,anywheresoftware.b4j.object.ServerWrapper _srvr,String _srvrname,int _srvrport) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "startserver"))
	return (String) Debug.delegate(ba, "startserver", new Object[] {_srvr,_srvrname,_srvrport});
int _i = 0;
anywheresoftware.b4j.object.JavaObject _jo = null;
Object[] _connectors = null;
long _timeout = 0L;
anywheresoftware.b4j.object.JavaObject _c = null;
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="public Sub StartServer(srvr As Server, srvrName As";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="ABM.WriteAppLauchPageToDisk(AppPage, File.DirApp";
__ref._abm.WriteAppLauchPageToDisk(__ref._apppage,__c.File.getDirApp()+"/www/"+_abmshared._appname,"index.html",_abmshared._needsauthorization);
RDebugUtils.currentLine=524292;
 //BA.debugLineNum = 524292;BA.debugLine="srvr.Initialize(srvrName)";
_srvr.Initialize(ba,_srvrname);
RDebugUtils.currentLine=524294;
 //BA.debugLineNum = 524294;BA.debugLine="srvr.AddFilter(\"/js/b4j_ws.min.js\", \"ABMSessionCr";
_srvr.AddFilter("/js/b4j_ws.min.js","ABMSessionCreator",__c.False);
RDebugUtils.currentLine=524295;
 //BA.debugLineNum = 524295;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName, \"AB";
_srvr.AddWebSocket("/ws/"+_abmshared._appname,"ABMApplication");
RDebugUtils.currentLine=524296;
 //BA.debugLineNum = 524296;BA.debugLine="For i =0 To Pages.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (__ref._pages.getSize()-1);
for (_i = (int) (0) ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
RDebugUtils.currentLine=524297;
 //BA.debugLineNum = 524297;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName & \"";
_srvr.AddWebSocket("/ws/"+_abmshared._appname+"/"+BA.ObjectToString(__ref._pages.Get(_i)),BA.ObjectToString(__ref._pages.Get(_i)));
RDebugUtils.currentLine=524298;
 //BA.debugLineNum = 524298;BA.debugLine="If PageNeedsUpload.Get(i) Then";
if (BA.ObjectToBoolean(__ref._pageneedsupload.Get(_i))) { 
RDebugUtils.currentLine=524299;
 //BA.debugLineNum = 524299;BA.debugLine="srvr.AddHandler(\"/\" & ABMShared.AppName & \"/\" &";
_srvr.AddHandler("/"+_abmshared._appname+"/"+BA.ObjectToString(__ref._pages.Get(_i))+"/abmuploadhandler","ABMUploadHandler",__c.False);
 };
 }
};
RDebugUtils.currentLine=524302;
 //BA.debugLineNum = 524302;BA.debugLine="srvr.AddBackgroundWorker(\"ABMCacheScavenger\")";
_srvr.AddBackgroundWorker("ABMCacheScavenger");
RDebugUtils.currentLine=524303;
 //BA.debugLineNum = 524303;BA.debugLine="srvr.Port = srvrPort";
_srvr.setPort(_srvrport);
RDebugUtils.currentLine=524308;
 //BA.debugLineNum = 524308;BA.debugLine="srvr.SetStaticFilesOptions(CreateMap(\"cacheContr";
_srvr.SetStaticFilesOptions(__c.createMap(new Object[] {(Object)("cacheControl"),(Object)("max-age=604800,public"),(Object)("gzip"),(Object)(__c.False),(Object)("dirAllowed"),(Object)(__c.False)}));
RDebugUtils.currentLine=524310;
 //BA.debugLineNum = 524310;BA.debugLine="srvr.Start";
_srvr.Start();
RDebugUtils.currentLine=524311;
 //BA.debugLineNum = 524311;BA.debugLine="Dim jo As JavaObject = srvr";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_srvr));
RDebugUtils.currentLine=524312;
 //BA.debugLineNum = 524312;BA.debugLine="Dim connectors() As Object = jo.GetFieldJO(\"serve";
_connectors = (Object[])(_jo.GetFieldJO("server").RunMethod("getConnectors",(Object[])(__c.Null)));
RDebugUtils.currentLine=524313;
 //BA.debugLineNum = 524313;BA.debugLine="Dim timeout As Long = ABMShared.SessionMaxInactiv";
_timeout = (long) (_abmshared._sessionmaxinactiveintervalseconds*1000);
RDebugUtils.currentLine=524314;
 //BA.debugLineNum = 524314;BA.debugLine="For Each c As JavaObject In connectors";
_c = new anywheresoftware.b4j.object.JavaObject();
final Object[] group18 = _connectors;
final int groupLen18 = group18.length;
for (int index18 = 0;index18 < groupLen18 ;index18++){
_c.setObject((java.lang.Object)(group18[index18]));
RDebugUtils.currentLine=524315;
 //BA.debugLineNum = 524315;BA.debugLine="c.RunMethod(\"setIdleTimeout\", Array(timeout))";
_c.RunMethod("setIdleTimeout",new Object[]{(Object)(_timeout)});
 }
;
RDebugUtils.currentLine=524317;
 //BA.debugLineNum = 524317;BA.debugLine="ABMShared.CachedPages = srvr.CreateThreadSafeMap";
_abmshared._cachedpages = _srvr.CreateThreadSafeMap();
RDebugUtils.currentLine=524318;
 //BA.debugLineNum = 524318;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMModalSheet  _buildloginsheet(b4j.example.abmapplication __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "buildloginsheet"))
	return (com.ab.abmaterial.ABMModalSheet) Debug.delegate(ba, "buildloginsheet", null);
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMInput _inp2 = null;
com.ab.abmaterial.ABMButton _msbtn1 = null;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub BuildLoginSheet() As ABMModalSheet";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Dim myModal As ABMModalSheet";
_mymodal = new com.ab.abmaterial.ABMModalSheet();
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="myModal.Initialize(AppPage, \"login\", False, False";
_mymodal.Initialize(__ref._apppage,"login",__c.False,__c.False,"");
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="myModal.Content.UseTheme(\"modalcontent\")";
_mymodal.Content.UseTheme("modalcontent");
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="myModal.Footer.UseTheme(\"modalfooter\")";
_mymodal.Footer.UseTheme("modalfooter");
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="myModal.IsDismissible = False";
_mymodal.IsDismissible = __c.False;
RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="myModal.Content.AddRows(2,True, \"\").AddCells12(1,";
_mymodal.Content.AddRows((int) (2),__c.True,"").AddCells12((int) (1),"");
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="myModal.Content.BuildGrid 'IMPORTANT once you loa";
_mymodal.Content.BuildGrid();
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="myModal.Content.Cell(1,1).AddComponent(ABMShared.";
_mymodal.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(__ref._apppage,"par1","Please login: (login and password are 'demo')")));
RDebugUtils.currentLine=917519;
 //BA.debugLineNum = 917519;BA.debugLine="Dim inp1 As ABMInput";
_inp1 = new com.ab.abmaterial.ABMInput();
RDebugUtils.currentLine=917520;
 //BA.debugLineNum = 917520;BA.debugLine="inp1.Initialize(AppPage, \"inp1\", ABM.INPUT_TEXT,";
_inp1.Initialize(__ref._apppage,"inp1",__ref._abm.INPUT_TEXT,"Login",__c.False,"");
RDebugUtils.currentLine=917521;
 //BA.debugLineNum = 917521;BA.debugLine="myModal.Content.Cell(2,1).AddComponent(inp1)";
_mymodal.Content.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp1));
RDebugUtils.currentLine=917523;
 //BA.debugLineNum = 917523;BA.debugLine="Dim inp2 As ABMInput";
_inp2 = new com.ab.abmaterial.ABMInput();
RDebugUtils.currentLine=917524;
 //BA.debugLineNum = 917524;BA.debugLine="inp2.Initialize(AppPage, \"inp2\", ABM.INPUT_TEXT,";
_inp2.Initialize(__ref._apppage,"inp2",__ref._abm.INPUT_TEXT,"Password",__c.False,"");
RDebugUtils.currentLine=917525;
 //BA.debugLineNum = 917525;BA.debugLine="myModal.Content.Cell(2,1).AddComponent(inp2)";
_mymodal.Content.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp2));
RDebugUtils.currentLine=917529;
 //BA.debugLineNum = 917529;BA.debugLine="myModal.Footer.AddRowsM(1,True,0,0, \"\").AddCellsO";
_mymodal.Footer.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOS((int) (1),(int) (9),(int) (9),(int) (9),(int) (3),(int) (3),(int) (3),"");
RDebugUtils.currentLine=917530;
 //BA.debugLineNum = 917530;BA.debugLine="myModal.Footer.BuildGrid 'IMPORTANT once you load";
_mymodal.Footer.BuildGrid();
RDebugUtils.currentLine=917533;
 //BA.debugLineNum = 917533;BA.debugLine="Dim msbtn1 As ABMButton";
_msbtn1 = new com.ab.abmaterial.ABMButton();
RDebugUtils.currentLine=917534;
 //BA.debugLineNum = 917534;BA.debugLine="msbtn1.InitializeFlat(AppPage, \"msbtn1\", \"\", \"\",";
_msbtn1.InitializeFlat(__ref._apppage,"msbtn1","","","Login","transparent");
RDebugUtils.currentLine=917535;
 //BA.debugLineNum = 917535;BA.debugLine="myModal.Footer.Cell(1,1).AddComponent(msbtn1)";
_mymodal.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_msbtn1));
RDebugUtils.currentLine=917537;
 //BA.debugLineNum = 917537;BA.debugLine="Return myModal";
if (true) return _mymodal;
RDebugUtils.currentLine=917538;
 //BA.debugLineNum = 917538;BA.debugLine="End Sub";
return null;
}
public String  _buildpage(b4j.example.abmapplication __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "buildpage"))
	return (String) Debug.delegate(ba, "buildpage", null);
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="public Sub BuildPage()";
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="BuildTheme";
__ref._buildtheme(null);
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="AppPage.InitializeWithTheme(ABMShared.AppName, \"/";
__ref._apppage.InitializeWithTheme(_abmshared._appname,"/ws/"+_abmshared._appname,__c.False,_abmshared._sessionmaxinactiveintervalseconds,__ref._theme);
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="AppPage.ShowLoader=True";
__ref._apppage.setShowLoader(__c.True);
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="AppPage.PageTitle = \"Template\"";
__ref._apppage.PageTitle = "Template";
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="AppPage.PageDescription = \"Template for ABMateria";
__ref._apppage.PageDescription = "Template for ABMaterial, a Material UI Framework for B4J";
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="AppPage.PageHTMLName = \"index.html\"";
__ref._apppage.PageHTMLName = "index.html";
RDebugUtils.currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="AppPage.PageKeywords = \"\"";
__ref._apppage.PageKeywords = "";
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="AppPage.PageSiteMapPriority = \"0.00\"";
__ref._apppage.PageSiteMapPriority = "0.00";
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="AppPage.PageSiteMapFrequency = ABM.SITEMAP_FREQ_Y";
__ref._apppage.PageSiteMapFrequency = __ref._abm.SITEMAP_FREQ_YEARLY;
RDebugUtils.currentLine=720914;
 //BA.debugLineNum = 720914;BA.debugLine="AppPage.AddRows(1,True, \"\").AddCells12(1,\"\")";
__ref._apppage.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
RDebugUtils.currentLine=720915;
 //BA.debugLineNum = 720915;BA.debugLine="AppPage.BuildGrid 'IMPORTANT once you loaded the";
__ref._apppage.BuildGrid();
RDebugUtils.currentLine=720918;
 //BA.debugLineNum = 720918;BA.debugLine="AppPage.AddModalSheetTemplate(BuildLoginSheet)";
__ref._apppage.AddModalSheetTemplate(__ref._buildloginsheet(null));
RDebugUtils.currentLine=720921;
 //BA.debugLineNum = 720921;BA.debugLine="AppPage.AddModalSheetTemplate(BuildWrongInputModa";
__ref._apppage.AddModalSheetTemplate(__ref._buildwronginputmodalsheet(null));
RDebugUtils.currentLine=720923;
 //BA.debugLineNum = 720923;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme(b4j.example.abmapplication __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "buildtheme"))
	return (String) Debug.delegate(ba, "buildtheme", null);
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="public Sub BuildTheme()";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="theme.Initialize(\"pagetheme\")";
__ref._theme.Initialize("pagetheme");
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
__ref._theme.AddABMTheme(_abmshared._mytheme);
RDebugUtils.currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMModalSheet  _buildwronginputmodalsheet(b4j.example.abmapplication __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "buildwronginputmodalsheet"))
	return (com.ab.abmaterial.ABMModalSheet) Debug.delegate(ba, "buildwronginputmodalsheet", null);
com.ab.abmaterial.ABMModalSheet _mymodalerror = null;
com.ab.abmaterial.ABMLabel _lbl1 = null;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub BuildWrongInputModalSheet() As ABMModalSheet";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Dim myModalError As ABMModalSheet";
_mymodalerror = new com.ab.abmaterial.ABMModalSheet();
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="myModalError.Initialize(AppPage, \"wronginput\", Fa";
_mymodalerror.Initialize(__ref._apppage,"wronginput",__c.False,__c.False,"");
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="myModalError.Content.UseTheme(\"modalcontent\")";
_mymodalerror.Content.UseTheme("modalcontent");
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="myModalError.Footer.UseTheme(\"modalcontent\")";
_mymodalerror.Footer.UseTheme("modalcontent");
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="myModalError.IsDismissible = True";
_mymodalerror.IsDismissible = __c.True;
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="myModalError.Content.AddRows(1,True, \"\").AddCells";
_mymodalerror.Content.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="myModalError.Content.BuildGrid 'IMPORTANT once yo";
_mymodalerror.Content.BuildGrid();
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="Dim lbl1 As ABMLabel";
_lbl1 = new com.ab.abmaterial.ABMLabel();
RDebugUtils.currentLine=983052;
 //BA.debugLineNum = 983052;BA.debugLine="lbl1.Initialize(AppPage, \"contlbl1\", \"The login o";
_lbl1.Initialize(__ref._apppage,"contlbl1","The login or password are incorrect!",__ref._abm.SIZE_PARAGRAPH,__c.False,"");
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="myModalError.Content.Cell(1,1).AddComponent(lbl1)";
_mymodalerror.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl1));
RDebugUtils.currentLine=983055;
 //BA.debugLineNum = 983055;BA.debugLine="Return myModalError";
if (true) return _mymodalerror;
RDebugUtils.currentLine=983056;
 //BA.debugLineNum = 983056;BA.debugLine="End Sub";
return null;
}
public String  _class_globals(b4j.example.abmapplication __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Private InitialPage As String = \"pgUserList\"  '<-";
_initialpage = "pgUserList";
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="Private AppPage As ABMPage";
_apppage = new com.ab.abmaterial.ABMPage();
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="Private theme As ABMTheme";
_theme = new com.ab.abmaterial.ABMTheme();
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="Private ws As WebSocket 'ignore";
_ws = new anywheresoftware.b4j.object.WebSocket();
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="Private ABM As ABMaterial 'ignore";
_abm = new com.ab.abmaterial.ABMaterial();
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="Private Pages As List";
_pages = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="Private PageNeedsUpload As List";
_pageneedsupload = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="End Sub";
return "";
}
public String  _connectpage(b4j.example.abmapplication __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "connectpage"))
	return (String) Debug.delegate(ba, "connectpage", null);
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="public Sub ConnectPage()";
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="AppPage.Refresh ' IMPORTANT";
__ref._apppage.Refresh();
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="AppPage.FinishedLoading 'IMPORTANT";
__ref._apppage.FinishedLoading();
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="AppPage.RestoreNavigationBarPosition";
__ref._apppage.RestoreNavigationBarPosition();
RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="End Sub";
return "";
}
public String  _msbtn1_clicked(b4j.example.abmapplication __ref,String _target) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "msbtn1_clicked"))
	return (String) Debug.delegate(ba, "msbtn1_clicked", new Object[] {_target});
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMInput _inp2 = null;
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub msbtn1_Clicked(Target As String)";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Dim mymodal As ABMModalSheet = AppPage.ModalSheet";
_mymodal = __ref._apppage.ModalSheet("login");
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Dim inp1 As ABMInput = mymodal.Content.Component(";
_inp1 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("inp1"));
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="Dim inp2 As ABMInput = mymodal.Content.Component(";
_inp2 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("inp2"));
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="If inp1.Text <> \"demo\" Or inp2.Text <> \"demo\" The";
if ((_inp1.getText()).equals("demo") == false || (_inp2.getText()).equals("demo") == false) { 
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="AppPage.ShowModalSheet(\"wronginput\")";
__ref._apppage.ShowModalSheet("wronginput");
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="ws.Session.SetAttribute(\"IsAuthorized\", \"true\")";
__ref._ws.getSession().SetAttribute("IsAuthorized",(Object)("true"));
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="ABMShared.NavigateToPage(ws, \"\", \"./\" & InitialPa";
_abmshared._navigatetopage(__ref._ws,"","./"+__ref._initialpage);
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(b4j.example.abmapplication __ref,String _action,String _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "page_navigationbarclicked"))
	return (String) Debug.delegate(ba, "page_navigationbarclicked", new Object[] {_action,_value});
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="AppPage.SaveNavigationBarPosition";
__ref._apppage.SaveNavigationBarPosition();
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(b4j.example.abmapplication __ref,anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "page_parseevent"))
	return (String) Debug.delegate(ba, "page_parseevent", new Object[] {_params});
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
__ref._abm.RemoveMeFromCache(_abmshared._cachedpages,__ref._abmpageid);
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
RDebugUtils.currentLine=393225;
 //BA.debugLineNum = 393225;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
RDebugUtils.currentLine=393226;
 //BA.debugLineNum = 393226;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
RDebugUtils.currentLine=393227;
 //BA.debugLineNum = 393227;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
RDebugUtils.currentLine=393229;
 //BA.debugLineNum = 393229;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
RDebugUtils.currentLine=393231;
 //BA.debugLineNum = 393231;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
RDebugUtils.currentLine=393233;
 //BA.debugLineNum = 393233;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
RDebugUtils.currentLine=393234;
 //BA.debugLineNum = 393234;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = __ref._abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
RDebugUtils.currentLine=393235;
 //BA.debugLineNum = 393235;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
RDebugUtils.currentLine=393237;
 //BA.debugLineNum = 393237;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
RDebugUtils.currentLine=393241;
 //BA.debugLineNum = 393241;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
RDebugUtils.currentLine=393244;
 //BA.debugLineNum = 393244;BA.debugLine="End Sub";
return "";
}
public String  _startserverhttp2(b4j.example.abmapplication __ref,anywheresoftware.b4j.object.ServerWrapper _srvr,String _srvrname,int _srvrport,int _sslsvrport,String _sslkeystorefilename,String _sslkeystorepassword,String _sslkeymanagerpassword) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "startserverhttp2"))
	return (String) Debug.delegate(ba, "startserverhttp2", new Object[] {_srvr,_srvrname,_srvrport,_sslsvrport,_sslkeystorefilename,_sslkeystorepassword,_sslkeymanagerpassword});
anywheresoftware.b4j.object.ServerWrapper.SslContextFactoryWrapper _ssl = null;
int _i = 0;
anywheresoftware.b4j.object.JavaObject _jo = null;
Object[] _connectors = null;
long _timeout = 0L;
anywheresoftware.b4j.object.JavaObject _c = null;
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="public Sub StartServerHTTP2(srvr As Server, srvrNa";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="ABM.WriteAppLauchPageToDisk(AppPage, File.DirApp";
__ref._abm.WriteAppLauchPageToDisk(__ref._apppage,__c.File.getDirApp()+"/www/"+_abmshared._appname,"index.html",_abmshared._needsauthorization);
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Dim ssl As SslConfiguration";
_ssl = new anywheresoftware.b4j.object.ServerWrapper.SslContextFactoryWrapper();
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="ssl.Initialize";
_ssl.Initialize();
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="ssl.SetKeyStorePath(File.DirApp, SSLKeyStoreFileN";
_ssl.SetKeyStorePath(__c.File.getDirApp(),_sslkeystorefilename);
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="ssl.KeyStorePassword = SSLKeyStorePassword";
_ssl.setKeyStorePassword(_sslkeystorepassword);
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="ssl.KeyManagerPassword = SSLKeyManagerPassword";
_ssl.setKeyManagerPassword(_sslkeymanagerpassword);
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="srvr.SetSslConfiguration(ssl, SSLsvrPort)";
_srvr.SetSslConfiguration(_ssl,_sslsvrport);
RDebugUtils.currentLine=589835;
 //BA.debugLineNum = 589835;BA.debugLine="srvr.Initialize(srvrName)";
_srvr.Initialize(ba,_srvrname);
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="srvr.AddFilter(\"/js/b4j_ws.min.js\", \"ABMSessionCr";
_srvr.AddFilter("/js/b4j_ws.min.js","ABMSessionCreator",__c.False);
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName, \"AB";
_srvr.AddWebSocket("/ws/"+_abmshared._appname,"ABMApplication");
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="For i =0 To Pages.Size - 1";
{
final int step11 = 1;
final int limit11 = (int) (__ref._pages.getSize()-1);
for (_i = (int) (0) ; (step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11); _i = ((int)(0 + _i + step11)) ) {
RDebugUtils.currentLine=589840;
 //BA.debugLineNum = 589840;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName & \"";
_srvr.AddWebSocket("/ws/"+_abmshared._appname+"/"+BA.ObjectToString(__ref._pages.Get(_i)),BA.ObjectToString(__ref._pages.Get(_i)));
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="If PageNeedsUpload.Get(i) Then";
if (BA.ObjectToBoolean(__ref._pageneedsupload.Get(_i))) { 
RDebugUtils.currentLine=589842;
 //BA.debugLineNum = 589842;BA.debugLine="srvr.AddHandler(\"/\" & ABMShared.AppName & \"/\" &";
_srvr.AddHandler("/"+_abmshared._appname+"/"+BA.ObjectToString(__ref._pages.Get(_i))+"/abmuploadhandler","ABMUploadHandler",__c.False);
 };
 }
};
RDebugUtils.currentLine=589845;
 //BA.debugLineNum = 589845;BA.debugLine="srvr.AddBackgroundWorker(\"ABMCacheScavenger\")";
_srvr.AddBackgroundWorker("ABMCacheScavenger");
RDebugUtils.currentLine=589846;
 //BA.debugLineNum = 589846;BA.debugLine="srvr.Port = srvrPort";
_srvr.setPort(_srvrport);
RDebugUtils.currentLine=589847;
 //BA.debugLineNum = 589847;BA.debugLine="srvr.Http2Enabled = True";
_srvr.setHttp2Enabled(__c.True);
RDebugUtils.currentLine=589851;
 //BA.debugLineNum = 589851;BA.debugLine="srvr.SetStaticFilesOptions(CreateMap(\"cacheContr";
_srvr.SetStaticFilesOptions(__c.createMap(new Object[] {(Object)("cacheControl"),(Object)("max-age=604800,public"),(Object)("gzip"),(Object)(__c.False),(Object)("dirAllowed"),(Object)(__c.False)}));
RDebugUtils.currentLine=589853;
 //BA.debugLineNum = 589853;BA.debugLine="srvr.Start";
_srvr.Start();
RDebugUtils.currentLine=589854;
 //BA.debugLineNum = 589854;BA.debugLine="Dim jo As JavaObject = srvr";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_srvr));
RDebugUtils.currentLine=589855;
 //BA.debugLineNum = 589855;BA.debugLine="Dim connectors() As Object = jo.GetFieldJO(\"serve";
_connectors = (Object[])(_jo.GetFieldJO("server").RunMethod("getConnectors",(Object[])(__c.Null)));
RDebugUtils.currentLine=589856;
 //BA.debugLineNum = 589856;BA.debugLine="Dim timeout As Long = ABMShared.SessionMaxInactiv";
_timeout = (long) (_abmshared._sessionmaxinactiveintervalseconds*1000);
RDebugUtils.currentLine=589857;
 //BA.debugLineNum = 589857;BA.debugLine="For Each c As JavaObject In connectors";
_c = new anywheresoftware.b4j.object.JavaObject();
final Object[] group25 = _connectors;
final int groupLen25 = group25.length;
for (int index25 = 0;index25 < groupLen25 ;index25++){
_c.setObject((java.lang.Object)(group25[index25]));
RDebugUtils.currentLine=589858;
 //BA.debugLineNum = 589858;BA.debugLine="c.RunMethod(\"setIdleTimeout\", Array(timeout))";
_c.RunMethod("setIdleTimeout",new Object[]{(Object)(_timeout)});
 }
;
RDebugUtils.currentLine=589860;
 //BA.debugLineNum = 589860;BA.debugLine="ABMShared.CachedPages = srvr.CreateThreadSafeMap";
_abmshared._cachedpages = _srvr.CreateThreadSafeMap();
RDebugUtils.currentLine=589861;
 //BA.debugLineNum = 589861;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(b4j.example.abmapplication __ref,anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "websocket_connected"))
	return (String) Debug.delegate(ba, "websocket_connected", new Object[] {_websocket1});
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="ws = WebSocket1";
__ref._ws = _websocket1;
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="ABMPageId = ABM.GetPageID(AppPage, ABMShared.AppN";
__ref._abmpageid = __ref._abm.GetPageID(__ref._apppage,_abmshared._appname,__ref._ws);
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = __ref._abm.GetSession(__ref._ws,_abmshared._sessionmaxinactiveintervalseconds);
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="AppPage.Prepare";
__ref._apppage.Prepare();
RDebugUtils.currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="ConnectPage";
__ref._connectpage(null);
RDebugUtils.currentLine=262154;
 //BA.debugLineNum = 262154;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
RDebugUtils.currentLine=262155;
 //BA.debugLineNum = 262155;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
RDebugUtils.currentLine=262156;
 //BA.debugLineNum = 262156;BA.debugLine="AppPage.ShowModalSheet(\"login\")";
__ref._apppage.ShowModalSheet("login");
RDebugUtils.currentLine=262157;
 //BA.debugLineNum = 262157;BA.debugLine="Return";
if (true) return "";
 };
 };
RDebugUtils.currentLine=262160;
 //BA.debugLineNum = 262160;BA.debugLine="ABMShared.NavigateToPage(ws, \"\",\"./\" & InitialPag";
_abmshared._navigatetopage(__ref._ws,"","./"+__ref._initialpage);
RDebugUtils.currentLine=262161;
 //BA.debugLineNum = 262161;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected(b4j.example.abmapplication __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmapplication";
if (Debug.shouldDelegate(ba, "websocket_disconnected"))
	return (String) Debug.delegate(ba, "websocket_disconnected", null);
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Private Sub WebSocket_Disconnected";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return "";
}
}