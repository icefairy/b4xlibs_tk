package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class abmapplication_subs_0 {


public static RemoteObject  _addpage(RemoteObject __ref,RemoteObject _page) throws Exception{
try {
		Debug.PushSubsStack("AddPage (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,104);
if (RapidSub.canDelegate("addpage")) return __ref.runUserSub(false, "abmapplication","addpage", __ref, _page);
Debug.locals.put("Page", _page);
 BA.debugLineNum = 104;BA.debugLine="public Sub AddPage(Page As ABMPage)";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="Pages.Add(Page.Name)";
Debug.ShouldStop(256);
__ref.getField(false,"_pages").runVoidMethod ("Add",(Object)((_page.runMethod(true,"getName"))));
 BA.debugLineNum = 106;BA.debugLine="PageNeedsUpload.Add(ABM.WritePageToDisk(Page, Fil";
Debug.ShouldStop(512);
__ref.getField(false,"_pageneedsupload").runVoidMethod ("Add",(Object)((__ref.getField(false,"_abm").runMethodAndSync(true,"WritePageToDisk",(Object)(_page),(Object)(RemoteObject.concat(abmapplication.__c.getField(false,"File").runMethod(true,"getDirApp"),RemoteObject.createImmutable("/www/"),abmapplication._abmshared._appname,RemoteObject.createImmutable("/"),_page.runMethod(true,"getName"),RemoteObject.createImmutable("/"))),(Object)(_page.getField(true,"PageHTMLName")),(Object)(abmapplication._abmshared._needsauthorization)))));
 BA.debugLineNum = 107;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buildloginsheet(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("BuildLoginSheet (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,242);
if (RapidSub.canDelegate("buildloginsheet")) return __ref.runUserSub(false, "abmapplication","buildloginsheet", __ref);
RemoteObject _mymodal = RemoteObject.declareNull("com.ab.abmaterial.ABMModalSheet");
RemoteObject _inp1 = RemoteObject.declareNull("com.ab.abmaterial.ABMInput");
RemoteObject _inp2 = RemoteObject.declareNull("com.ab.abmaterial.ABMInput");
RemoteObject _msbtn1 = RemoteObject.declareNull("com.ab.abmaterial.ABMButton");
 BA.debugLineNum = 242;BA.debugLine="Sub BuildLoginSheet() As ABMModalSheet";
Debug.ShouldStop(131072);
 BA.debugLineNum = 243;BA.debugLine="Dim myModal As ABMModalSheet";
Debug.ShouldStop(262144);
_mymodal = RemoteObject.createNew ("com.ab.abmaterial.ABMModalSheet");Debug.locals.put("myModal", _mymodal);
 BA.debugLineNum = 244;BA.debugLine="myModal.Initialize(AppPage, \"login\", False, False";
Debug.ShouldStop(524288);
_mymodal.runVoidMethod ("Initialize",(Object)(__ref.getField(false,"_apppage")),(Object)(BA.ObjectToString("login")),(Object)(abmapplication.__c.getField(true,"False")),(Object)(abmapplication.__c.getField(true,"False")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 245;BA.debugLine="myModal.Content.UseTheme(\"modalcontent\")";
Debug.ShouldStop(1048576);
_mymodal.getField(false,"Content").runVoidMethod ("UseTheme",(Object)(RemoteObject.createImmutable("modalcontent")));
 BA.debugLineNum = 246;BA.debugLine="myModal.Footer.UseTheme(\"modalfooter\")";
Debug.ShouldStop(2097152);
_mymodal.getField(false,"Footer").runVoidMethod ("UseTheme",(Object)(RemoteObject.createImmutable("modalfooter")));
 BA.debugLineNum = 247;BA.debugLine="myModal.IsDismissible = False";
Debug.ShouldStop(4194304);
_mymodal.setField ("IsDismissible",abmapplication.__c.getField(true,"False"));
 BA.debugLineNum = 250;BA.debugLine="myModal.Content.AddRows(2,True, \"\").AddCells12(1,";
Debug.ShouldStop(33554432);
_mymodal.getField(false,"Content").runMethod(false,"AddRows",(Object)(BA.numberCast(int.class, 2)),(Object)(abmapplication.__c.getField(true,"True")),(Object)(RemoteObject.createImmutable(""))).runVoidMethod ("AddCells12",(Object)(BA.numberCast(int.class, 1)),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 251;BA.debugLine="myModal.Content.BuildGrid 'IMPORTANT once you loa";
Debug.ShouldStop(67108864);
_mymodal.getField(false,"Content").runVoidMethod ("BuildGrid");
 BA.debugLineNum = 254;BA.debugLine="myModal.Content.Cell(1,1).AddComponent(ABMShared.";
Debug.ShouldStop(536870912);
_mymodal.getField(false,"Content").runMethod(false,"Cell",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))).runVoidMethod ("AddComponent",(Object)((abmapplication._abmshared.runMethod(false,"_buildparagraph",(Object)(__ref.getField(false,"_apppage")),(Object)(BA.ObjectToString("par1")),(Object)(RemoteObject.createImmutable("Please login: (login and password are 'demo')"))))));
 BA.debugLineNum = 257;BA.debugLine="Dim inp1 As ABMInput";
Debug.ShouldStop(1);
_inp1 = RemoteObject.createNew ("com.ab.abmaterial.ABMInput");Debug.locals.put("inp1", _inp1);
 BA.debugLineNum = 258;BA.debugLine="inp1.Initialize(AppPage, \"inp1\", ABM.INPUT_TEXT,";
Debug.ShouldStop(2);
_inp1.runVoidMethod ("Initialize",(Object)(__ref.getField(false,"_apppage")),(Object)(BA.ObjectToString("inp1")),(Object)(__ref.getField(false,"_abm").getField(true,"INPUT_TEXT")),(Object)(BA.ObjectToString("Login")),(Object)(abmapplication.__c.getField(true,"False")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 259;BA.debugLine="myModal.Content.Cell(2,1).AddComponent(inp1)";
Debug.ShouldStop(4);
_mymodal.getField(false,"Content").runMethod(false,"Cell",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 1))).runVoidMethod ("AddComponent",(Object)((_inp1)));
 BA.debugLineNum = 261;BA.debugLine="Dim inp2 As ABMInput";
Debug.ShouldStop(16);
_inp2 = RemoteObject.createNew ("com.ab.abmaterial.ABMInput");Debug.locals.put("inp2", _inp2);
 BA.debugLineNum = 262;BA.debugLine="inp2.Initialize(AppPage, \"inp2\", ABM.INPUT_TEXT,";
Debug.ShouldStop(32);
_inp2.runVoidMethod ("Initialize",(Object)(__ref.getField(false,"_apppage")),(Object)(BA.ObjectToString("inp2")),(Object)(__ref.getField(false,"_abm").getField(true,"INPUT_TEXT")),(Object)(BA.ObjectToString("Password")),(Object)(abmapplication.__c.getField(true,"False")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 263;BA.debugLine="myModal.Content.Cell(2,1).AddComponent(inp2)";
Debug.ShouldStop(64);
_mymodal.getField(false,"Content").runMethod(false,"Cell",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 1))).runVoidMethod ("AddComponent",(Object)((_inp2)));
 BA.debugLineNum = 267;BA.debugLine="myModal.Footer.AddRowsM(1,True,0,0, \"\").AddCellsO";
Debug.ShouldStop(1024);
_mymodal.getField(false,"Footer").runMethod(false,"AddRowsM",(Object)(BA.numberCast(int.class, 1)),(Object)(abmapplication.__c.getField(true,"True")),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.createImmutable(""))).runVoidMethod ("AddCellsOS",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 9)),(Object)(BA.numberCast(int.class, 9)),(Object)(BA.numberCast(int.class, 9)),(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 3)),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 268;BA.debugLine="myModal.Footer.BuildGrid 'IMPORTANT once you load";
Debug.ShouldStop(2048);
_mymodal.getField(false,"Footer").runVoidMethod ("BuildGrid");
 BA.debugLineNum = 271;BA.debugLine="Dim msbtn1 As ABMButton";
Debug.ShouldStop(16384);
_msbtn1 = RemoteObject.createNew ("com.ab.abmaterial.ABMButton");Debug.locals.put("msbtn1", _msbtn1);
 BA.debugLineNum = 272;BA.debugLine="msbtn1.InitializeFlat(AppPage, \"msbtn1\", \"\", \"\",";
Debug.ShouldStop(32768);
_msbtn1.runVoidMethod ("InitializeFlat",(Object)(__ref.getField(false,"_apppage")),(Object)(BA.ObjectToString("msbtn1")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("Login")),(Object)(RemoteObject.createImmutable("transparent")));
 BA.debugLineNum = 273;BA.debugLine="myModal.Footer.Cell(1,1).AddComponent(msbtn1)";
Debug.ShouldStop(65536);
_mymodal.getField(false,"Footer").runMethod(false,"Cell",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))).runVoidMethod ("AddComponent",(Object)((_msbtn1)));
 BA.debugLineNum = 275;BA.debugLine="Return myModal";
Debug.ShouldStop(262144);
if (true) return _mymodal;
 BA.debugLineNum = 276;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buildpage(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("BuildPage (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,189);
if (RapidSub.canDelegate("buildpage")) return __ref.runUserSub(false, "abmapplication","buildpage", __ref);
 BA.debugLineNum = 189;BA.debugLine="public Sub BuildPage()";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 191;BA.debugLine="BuildTheme";
Debug.ShouldStop(1073741824);
__ref.runClassMethod (b4j.example.abmapplication.class, "_buildtheme");
 BA.debugLineNum = 194;BA.debugLine="AppPage.InitializeWithTheme(ABMShared.AppName, \"/";
Debug.ShouldStop(2);
__ref.getField(false,"_apppage").runVoidMethod ("InitializeWithTheme",(Object)(abmapplication._abmshared._appname),(Object)(RemoteObject.concat(RemoteObject.createImmutable("/ws/"),abmapplication._abmshared._appname)),(Object)(abmapplication.__c.getField(true,"False")),(Object)(abmapplication._abmshared._sessionmaxinactiveintervalseconds),(Object)(__ref.getField(false,"_theme")));
 BA.debugLineNum = 195;BA.debugLine="AppPage.ShowLoader=True";
Debug.ShouldStop(4);
__ref.getField(false,"_apppage").runMethod(true,"setShowLoader",abmapplication.__c.getField(true,"True"));
 BA.debugLineNum = 196;BA.debugLine="AppPage.PageTitle = \"Template\"";
Debug.ShouldStop(8);
__ref.getField(false,"_apppage").setField ("PageTitle",BA.ObjectToString("Template"));
 BA.debugLineNum = 197;BA.debugLine="AppPage.PageDescription = \"Template for ABMateria";
Debug.ShouldStop(16);
__ref.getField(false,"_apppage").setField ("PageDescription",BA.ObjectToString("Template for ABMaterial, a Material UI Framework for B4J"));
 BA.debugLineNum = 198;BA.debugLine="AppPage.PageHTMLName = \"index.html\"";
Debug.ShouldStop(32);
__ref.getField(false,"_apppage").setField ("PageHTMLName",BA.ObjectToString("index.html"));
 BA.debugLineNum = 199;BA.debugLine="AppPage.PageKeywords = \"\"";
Debug.ShouldStop(64);
__ref.getField(false,"_apppage").setField ("PageKeywords",BA.ObjectToString(""));
 BA.debugLineNum = 200;BA.debugLine="AppPage.PageSiteMapPriority = \"0.00\"";
Debug.ShouldStop(128);
__ref.getField(false,"_apppage").setField ("PageSiteMapPriority",BA.ObjectToString("0.00"));
 BA.debugLineNum = 201;BA.debugLine="AppPage.PageSiteMapFrequency = ABM.SITEMAP_FREQ_Y";
Debug.ShouldStop(256);
__ref.getField(false,"_apppage").setField ("PageSiteMapFrequency",__ref.getField(false,"_abm").getField(true,"SITEMAP_FREQ_YEARLY"));
 BA.debugLineNum = 207;BA.debugLine="AppPage.AddRows(1,True, \"\").AddCells12(1,\"\")";
Debug.ShouldStop(16384);
__ref.getField(false,"_apppage").runMethod(false,"AddRows",(Object)(BA.numberCast(int.class, 1)),(Object)(abmapplication.__c.getField(true,"True")),(Object)(RemoteObject.createImmutable(""))).runVoidMethod ("AddCells12",(Object)(BA.numberCast(int.class, 1)),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 208;BA.debugLine="AppPage.BuildGrid 'IMPORTANT once you loaded the";
Debug.ShouldStop(32768);
__ref.getField(false,"_apppage").runVoidMethod ("BuildGrid");
 BA.debugLineNum = 211;BA.debugLine="AppPage.AddModalSheetTemplate(BuildLoginSheet)";
Debug.ShouldStop(262144);
__ref.getField(false,"_apppage").runVoidMethod ("AddModalSheetTemplate",(Object)(__ref.runClassMethod (b4j.example.abmapplication.class, "_buildloginsheet")));
 BA.debugLineNum = 214;BA.debugLine="AppPage.AddModalSheetTemplate(BuildWrongInputModa";
Debug.ShouldStop(2097152);
__ref.getField(false,"_apppage").runVoidMethod ("AddModalSheetTemplate",(Object)(__ref.runClassMethod (b4j.example.abmapplication.class, "_buildwronginputmodalsheet")));
 BA.debugLineNum = 216;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buildtheme(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("BuildTheme (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,180);
if (RapidSub.canDelegate("buildtheme")) return __ref.runUserSub(false, "abmapplication","buildtheme", __ref);
 BA.debugLineNum = 180;BA.debugLine="public Sub BuildTheme()";
Debug.ShouldStop(524288);
 BA.debugLineNum = 182;BA.debugLine="theme.Initialize(\"pagetheme\")";
Debug.ShouldStop(2097152);
__ref.getField(false,"_theme").runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("pagetheme")));
 BA.debugLineNum = 183;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
Debug.ShouldStop(4194304);
__ref.getField(false,"_theme").runVoidMethod ("AddABMTheme",(Object)(abmapplication._abmshared._mytheme));
 BA.debugLineNum = 187;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buildwronginputmodalsheet(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("BuildWrongInputModalSheet (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,278);
if (RapidSub.canDelegate("buildwronginputmodalsheet")) return __ref.runUserSub(false, "abmapplication","buildwronginputmodalsheet", __ref);
RemoteObject _mymodalerror = RemoteObject.declareNull("com.ab.abmaterial.ABMModalSheet");
RemoteObject _lbl1 = RemoteObject.declareNull("com.ab.abmaterial.ABMLabel");
 BA.debugLineNum = 278;BA.debugLine="Sub BuildWrongInputModalSheet() As ABMModalSheet";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 279;BA.debugLine="Dim myModalError As ABMModalSheet";
Debug.ShouldStop(4194304);
_mymodalerror = RemoteObject.createNew ("com.ab.abmaterial.ABMModalSheet");Debug.locals.put("myModalError", _mymodalerror);
 BA.debugLineNum = 280;BA.debugLine="myModalError.Initialize(AppPage, \"wronginput\", Fa";
Debug.ShouldStop(8388608);
_mymodalerror.runVoidMethod ("Initialize",(Object)(__ref.getField(false,"_apppage")),(Object)(BA.ObjectToString("wronginput")),(Object)(abmapplication.__c.getField(true,"False")),(Object)(abmapplication.__c.getField(true,"False")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 281;BA.debugLine="myModalError.Content.UseTheme(\"modalcontent\")";
Debug.ShouldStop(16777216);
_mymodalerror.getField(false,"Content").runVoidMethod ("UseTheme",(Object)(RemoteObject.createImmutable("modalcontent")));
 BA.debugLineNum = 282;BA.debugLine="myModalError.Footer.UseTheme(\"modalcontent\")";
Debug.ShouldStop(33554432);
_mymodalerror.getField(false,"Footer").runVoidMethod ("UseTheme",(Object)(RemoteObject.createImmutable("modalcontent")));
 BA.debugLineNum = 283;BA.debugLine="myModalError.IsDismissible = True";
Debug.ShouldStop(67108864);
_mymodalerror.setField ("IsDismissible",abmapplication.__c.getField(true,"True"));
 BA.debugLineNum = 286;BA.debugLine="myModalError.Content.AddRows(1,True, \"\").AddCells";
Debug.ShouldStop(536870912);
_mymodalerror.getField(false,"Content").runMethod(false,"AddRows",(Object)(BA.numberCast(int.class, 1)),(Object)(abmapplication.__c.getField(true,"True")),(Object)(RemoteObject.createImmutable(""))).runVoidMethod ("AddCells12",(Object)(BA.numberCast(int.class, 1)),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 287;BA.debugLine="myModalError.Content.BuildGrid 'IMPORTANT once yo";
Debug.ShouldStop(1073741824);
_mymodalerror.getField(false,"Content").runVoidMethod ("BuildGrid");
 BA.debugLineNum = 289;BA.debugLine="Dim lbl1 As ABMLabel";
Debug.ShouldStop(1);
_lbl1 = RemoteObject.createNew ("com.ab.abmaterial.ABMLabel");Debug.locals.put("lbl1", _lbl1);
 BA.debugLineNum = 290;BA.debugLine="lbl1.Initialize(AppPage, \"contlbl1\", \"The login o";
Debug.ShouldStop(2);
_lbl1.runVoidMethod ("Initialize",(Object)(__ref.getField(false,"_apppage")),(Object)(BA.ObjectToString("contlbl1")),(Object)(BA.ObjectToString("The login or password are incorrect!")),(Object)(__ref.getField(false,"_abm").getField(true,"SIZE_PARAGRAPH")),(Object)(abmapplication.__c.getField(true,"False")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 291;BA.debugLine="myModalError.Content.Cell(1,1).AddComponent(lbl1)";
Debug.ShouldStop(4);
_mymodalerror.getField(false,"Content").runMethod(false,"Cell",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))).runVoidMethod ("AddComponent",(Object)((_lbl1)));
 BA.debugLineNum = 293;BA.debugLine="Return myModalError";
Debug.ShouldStop(16);
if (true) return _mymodalerror;
 BA.debugLineNum = 294;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Private InitialPage As String = \"pgUserList\"  '<-";
abmapplication._initialpage = BA.ObjectToString("pgUserList");__ref.setField("_initialpage",abmapplication._initialpage);
 //BA.debugLineNum = 14;BA.debugLine="Private AppPage As ABMPage";
abmapplication._apppage = RemoteObject.createNew ("com.ab.abmaterial.ABMPage");__ref.setField("_apppage",abmapplication._apppage);
 //BA.debugLineNum = 15;BA.debugLine="Private theme As ABMTheme";
abmapplication._theme = RemoteObject.createNew ("com.ab.abmaterial.ABMTheme");__ref.setField("_theme",abmapplication._theme);
 //BA.debugLineNum = 16;BA.debugLine="Private ws As WebSocket 'ignore";
abmapplication._ws = RemoteObject.createNew ("anywheresoftware.b4j.object.WebSocket");__ref.setField("_ws",abmapplication._ws);
 //BA.debugLineNum = 17;BA.debugLine="Private ABM As ABMaterial 'ignore";
abmapplication._abm = RemoteObject.createNew ("com.ab.abmaterial.ABMaterial");__ref.setField("_abm",abmapplication._abm);
 //BA.debugLineNum = 18;BA.debugLine="Private Pages As List";
abmapplication._pages = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");__ref.setField("_pages",abmapplication._pages);
 //BA.debugLineNum = 19;BA.debugLine="Private PageNeedsUpload As List";
abmapplication._pageneedsupload = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");__ref.setField("_pageneedsupload",abmapplication._pageneedsupload);
 //BA.debugLineNum = 21;BA.debugLine="Private ABMPageId As String = \"\"";
abmapplication._abmpageid = BA.ObjectToString("");__ref.setField("_abmpageid",abmapplication._abmpageid);
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _connectpage(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("ConnectPage (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,218);
if (RapidSub.canDelegate("connectpage")) return __ref.runUserSub(false, "abmapplication","connectpage", __ref);
 BA.debugLineNum = 218;BA.debugLine="public Sub ConnectPage()";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 221;BA.debugLine="AppPage.Refresh ' IMPORTANT";
Debug.ShouldStop(268435456);
__ref.getField(false,"_apppage").runVoidMethod ("Refresh");
 BA.debugLineNum = 224;BA.debugLine="AppPage.FinishedLoading 'IMPORTANT";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_apppage").runVoidMethod ("FinishedLoading");
 BA.debugLineNum = 226;BA.debugLine="AppPage.RestoreNavigationBarPosition";
Debug.ShouldStop(2);
__ref.getField(false,"_apppage").runVoidMethod ("RestoreNavigationBarPosition");
 BA.debugLineNum = 227;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,24);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "abmapplication","initialize", __ref, _ba);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 24;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="Pages.Initialize";
Debug.ShouldStop(16777216);
__ref.getField(false,"_pages").runVoidMethod ("Initialize");
 BA.debugLineNum = 26;BA.debugLine="PageNeedsUpload.Initialize";
Debug.ShouldStop(33554432);
__ref.getField(false,"_pageneedsupload").runVoidMethod ("Initialize");
 BA.debugLineNum = 27;BA.debugLine="ABM.AppVersion = ABMShared.AppVersion";
Debug.ShouldStop(67108864);
__ref.getField(false,"_abm").setField ("AppVersion",abmapplication._abmshared._appversion);
 BA.debugLineNum = 28;BA.debugLine="ABM.AppPublishedStartURL = ABMShared.AppPublished";
Debug.ShouldStop(134217728);
__ref.getField(false,"_abm").setField ("AppPublishedStartURL",abmapplication._abmshared._apppublishedstarturl);
 BA.debugLineNum = 29;BA.debugLine="ABMShared.AppName = \"\"   '<----------------------";
Debug.ShouldStop(268435456);
abmapplication._abmshared._appname = BA.ObjectToString("");
 BA.debugLineNum = 48;BA.debugLine="BuildPage";
Debug.ShouldStop(32768);
__ref.runClassMethod (b4j.example.abmapplication.class, "_buildpage");
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _msbtn1_clicked(RemoteObject __ref,RemoteObject _target) throws Exception{
try {
		Debug.PushSubsStack("msbtn1_Clicked (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,229);
if (RapidSub.canDelegate("msbtn1_clicked")) return __ref.runUserSub(false, "abmapplication","msbtn1_clicked", __ref, _target);
RemoteObject _mymodal = RemoteObject.declareNull("com.ab.abmaterial.ABMModalSheet");
RemoteObject _inp1 = RemoteObject.declareNull("com.ab.abmaterial.ABMInput");
RemoteObject _inp2 = RemoteObject.declareNull("com.ab.abmaterial.ABMInput");
Debug.locals.put("Target", _target);
 BA.debugLineNum = 229;BA.debugLine="Sub msbtn1_Clicked(Target As String)";
Debug.ShouldStop(16);
 BA.debugLineNum = 230;BA.debugLine="Dim mymodal As ABMModalSheet = AppPage.ModalSheet";
Debug.ShouldStop(32);
_mymodal = __ref.getField(false,"_apppage").runMethod(false,"ModalSheet",(Object)(RemoteObject.createImmutable("login")));Debug.locals.put("mymodal", _mymodal);Debug.locals.put("mymodal", _mymodal);
 BA.debugLineNum = 231;BA.debugLine="Dim inp1 As ABMInput = mymodal.Content.Component(";
Debug.ShouldStop(64);
_inp1 = (_mymodal.getField(false,"Content").runMethod(false,"Component",(Object)(RemoteObject.createImmutable("inp1"))));Debug.locals.put("inp1", _inp1);Debug.locals.put("inp1", _inp1);
 BA.debugLineNum = 232;BA.debugLine="Dim inp2 As ABMInput = mymodal.Content.Component(";
Debug.ShouldStop(128);
_inp2 = (_mymodal.getField(false,"Content").runMethod(false,"Component",(Object)(RemoteObject.createImmutable("inp2"))));Debug.locals.put("inp2", _inp2);Debug.locals.put("inp2", _inp2);
 BA.debugLineNum = 234;BA.debugLine="If inp1.Text <> \"demo\" Or inp2.Text <> \"demo\" The";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("!",_inp1.runMethod(true,"getText"),BA.ObjectToString("demo")) || RemoteObject.solveBoolean("!",_inp2.runMethod(true,"getText"),BA.ObjectToString("demo"))) { 
 BA.debugLineNum = 235;BA.debugLine="AppPage.ShowModalSheet(\"wronginput\")";
Debug.ShouldStop(1024);
__ref.getField(false,"_apppage").runVoidMethod ("ShowModalSheet",(Object)(RemoteObject.createImmutable("wronginput")));
 BA.debugLineNum = 236;BA.debugLine="Return";
Debug.ShouldStop(2048);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 238;BA.debugLine="ws.Session.SetAttribute(\"IsAuthorized\", \"true\")";
Debug.ShouldStop(8192);
__ref.getField(false,"_ws").runMethod(false,"getSession").runVoidMethod ("SetAttribute",(Object)(BA.ObjectToString("IsAuthorized")),(Object)((RemoteObject.createImmutable("true"))));
 BA.debugLineNum = 239;BA.debugLine="ABMShared.NavigateToPage(ws, \"\", \"./\" & InitialPa";
Debug.ShouldStop(16384);
abmapplication._abmshared.runVoidMethod ("_navigatetopage",(Object)(__ref.getField(false,"_ws")),(Object)(BA.ObjectToString("")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("./"),__ref.getField(true,"_initialpage"))));
 BA.debugLineNum = 240;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_navigationbarclicked(RemoteObject __ref,RemoteObject _action,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("Page_NavigationbarClicked (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,297);
if (RapidSub.canDelegate("page_navigationbarclicked")) return __ref.runUserSub(false, "abmapplication","page_navigationbarclicked", __ref, _action, _value);
Debug.locals.put("Action", _action);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 297;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
Debug.ShouldStop(256);
 BA.debugLineNum = 298;BA.debugLine="AppPage.SaveNavigationBarPosition";
Debug.ShouldStop(512);
__ref.getField(false,"_apppage").runVoidMethod ("SaveNavigationBarPosition");
 BA.debugLineNum = 299;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_parseevent(RemoteObject __ref,RemoteObject _params) throws Exception{
try {
		Debug.PushSubsStack("Page_ParseEvent (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,74);
if (RapidSub.canDelegate("page_parseevent")) return __ref.runUserSub(false, "abmapplication","page_parseevent", __ref, _params);
RemoteObject _eventname = RemoteObject.createImmutable("");
RemoteObject _eventparams = null;
RemoteObject _passedtables = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("Params", _params);
 BA.debugLineNum = 74;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
Debug.ShouldStop(1024);
_eventname = BA.ObjectToString(_params.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("eventname")))));Debug.locals.put("eventName", _eventname);Debug.locals.put("eventName", _eventname);
 BA.debugLineNum = 76;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
Debug.ShouldStop(2048);
_eventparams = abmapplication.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(",")),(Object)(BA.ObjectToString(_params.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("eventparams")))))));Debug.locals.put("eventParams", _eventparams);Debug.locals.put("eventParams", _eventparams);
 BA.debugLineNum = 77;BA.debugLine="If eventName = \"beforeunload\" Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_eventname,BA.ObjectToString("beforeunload"))) { 
 BA.debugLineNum = 78;BA.debugLine="Log(\"preparing for url refresh\")";
Debug.ShouldStop(8192);
abmapplication.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("preparing for url refresh")));
 BA.debugLineNum = 79;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
Debug.ShouldStop(16384);
__ref.getField(false,"_abm").runVoidMethod ("RemoveMeFromCache",(Object)(abmapplication._abmshared._cachedpages),(Object)(__ref.getField(true,"_abmpageid")));
 BA.debugLineNum = 80;BA.debugLine="Return";
Debug.ShouldStop(32768);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 82;BA.debugLine="If SubExists(Me, eventName) Then";
Debug.ShouldStop(131072);
if (abmapplication.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 83;BA.debugLine="Params.Remove(\"eventname\")";
Debug.ShouldStop(262144);
_params.runVoidMethod ("Remove",(Object)((RemoteObject.createImmutable("eventname"))));
 BA.debugLineNum = 84;BA.debugLine="Params.Remove(\"eventparams\")";
Debug.ShouldStop(524288);
_params.runVoidMethod ("Remove",(Object)((RemoteObject.createImmutable("eventparams"))));
 BA.debugLineNum = 85;BA.debugLine="Select Case Params.Size";
Debug.ShouldStop(1048576);
switch (BA.switchObjectToInt(_params.runMethod(true,"getSize"),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2))) {
case 0: {
 BA.debugLineNum = 87;BA.debugLine="CallSub(Me, eventName)";
Debug.ShouldStop(4194304);
abmapplication.__c.runMethodAndSync(false,"CallSubNew",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname));
 break; }
case 1: {
 BA.debugLineNum = 89;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
Debug.ShouldStop(16777216);
abmapplication.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname),(Object)(_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 0)))))));
 break; }
case 2: {
 BA.debugLineNum = 91;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 0))))),RemoteObject.createImmutable(("abmistable")))) { 
 BA.debugLineNum = 92;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
Debug.ShouldStop(134217728);
_passedtables = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_passedtables = __ref.getField(false,"_abm").runMethod(false,"ProcessTablesFromTargetName",(Object)(BA.ObjectToString(_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 1))))))));Debug.locals.put("PassedTables", _passedtables);Debug.locals.put("PassedTables", _passedtables);
 BA.debugLineNum = 93;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
Debug.ShouldStop(268435456);
abmapplication.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname),(Object)((_passedtables)));
 }else {
 BA.debugLineNum = 95;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
Debug.ShouldStop(1073741824);
abmapplication.__c.runMethodAndSync(false,"CallSubNew3",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname),(Object)(_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 0)))))),(Object)(_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 1)))))));
 };
 break; }
default: {
 BA.debugLineNum = 99;BA.debugLine="CallSub2(Me, eventName, Params)";
Debug.ShouldStop(4);
abmapplication.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname),(Object)((_params)));
 break; }
}
;
 };
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _startserver(RemoteObject __ref,RemoteObject _srvr,RemoteObject _srvrname,RemoteObject _srvrport) throws Exception{
try {
		Debug.PushSubsStack("StartServer (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,109);
if (RapidSub.canDelegate("startserver")) return __ref.runUserSub(false, "abmapplication","startserver", __ref, _srvr, _srvrname, _srvrport);
int _i = 0;
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _connectors = null;
RemoteObject _timeout = RemoteObject.createImmutable(0L);
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("srvr", _srvr);
Debug.locals.put("srvrName", _srvrname);
Debug.locals.put("srvrPort", _srvrport);
 BA.debugLineNum = 109;BA.debugLine="public Sub StartServer(srvr As Server, srvrName As";
Debug.ShouldStop(4096);
 BA.debugLineNum = 110;BA.debugLine="ABM.WriteAppLauchPageToDisk(AppPage, File.DirApp";
Debug.ShouldStop(8192);
__ref.getField(false,"_abm").runVoidMethod ("WriteAppLauchPageToDisk",(Object)(__ref.getField(false,"_apppage")),(Object)(RemoteObject.concat(abmapplication.__c.getField(false,"File").runMethod(true,"getDirApp"),RemoteObject.createImmutable("/www/"),abmapplication._abmshared._appname)),(Object)(BA.ObjectToString("index.html")),(Object)(abmapplication._abmshared._needsauthorization));
 BA.debugLineNum = 113;BA.debugLine="srvr.Initialize(srvrName)";
Debug.ShouldStop(65536);
_srvr.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(_srvrname));
 BA.debugLineNum = 115;BA.debugLine="srvr.AddFilter(\"/js/b4j_ws.min.js\", \"ABMSessionCr";
Debug.ShouldStop(262144);
_srvr.runVoidMethod ("AddFilter",(Object)(BA.ObjectToString("/js/b4j_ws.min.js")),(Object)(BA.ObjectToString("ABMSessionCreator")),(Object)(abmapplication.__c.getField(true,"False")));
 BA.debugLineNum = 116;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName, \"AB";
Debug.ShouldStop(524288);
_srvr.runVoidMethod ("AddWebSocket",(Object)(RemoteObject.concat(RemoteObject.createImmutable("/ws/"),abmapplication._abmshared._appname)),(Object)(RemoteObject.createImmutable("ABMApplication")));
 BA.debugLineNum = 117;BA.debugLine="For i =0 To Pages.Size - 1";
Debug.ShouldStop(1048576);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_pages").runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 118;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName & \"";
Debug.ShouldStop(2097152);
_srvr.runVoidMethod ("AddWebSocket",(Object)(RemoteObject.concat(RemoteObject.createImmutable("/ws/"),abmapplication._abmshared._appname,RemoteObject.createImmutable("/"),__ref.getField(false,"_pages").runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))),(Object)(BA.ObjectToString(__ref.getField(false,"_pages").runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))));
 BA.debugLineNum = 119;BA.debugLine="If PageNeedsUpload.Get(i) Then";
Debug.ShouldStop(4194304);
if (BA.ObjectToBoolean(__ref.getField(false,"_pageneedsupload").runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 120;BA.debugLine="srvr.AddHandler(\"/\" & ABMShared.AppName & \"/\" &";
Debug.ShouldStop(8388608);
_srvr.runVoidMethod ("AddHandler",(Object)(RemoteObject.concat(RemoteObject.createImmutable("/"),abmapplication._abmshared._appname,RemoteObject.createImmutable("/"),__ref.getField(false,"_pages").runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))),RemoteObject.createImmutable("/abmuploadhandler"))),(Object)(BA.ObjectToString("ABMUploadHandler")),(Object)(abmapplication.__c.getField(true,"False")));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 123;BA.debugLine="srvr.AddBackgroundWorker(\"ABMCacheScavenger\")";
Debug.ShouldStop(67108864);
_srvr.runVoidMethod ("AddBackgroundWorker",(Object)(RemoteObject.createImmutable("ABMCacheScavenger")));
 BA.debugLineNum = 124;BA.debugLine="srvr.Port = srvrPort";
Debug.ShouldStop(134217728);
_srvr.runMethod(true,"setPort",_srvrport);
 BA.debugLineNum = 129;BA.debugLine="srvr.SetStaticFilesOptions(CreateMap(\"cacheContr";
Debug.ShouldStop(1);
_srvr.runVoidMethod ("SetStaticFilesOptions",(Object)(abmapplication.__c.runMethod(false, "createMap", (Object)(new RemoteObject[] {RemoteObject.createImmutable(("cacheControl")),RemoteObject.createImmutable(("max-age=604800,public")),RemoteObject.createImmutable(("gzip")),(abmapplication.__c.getField(true,"False")),RemoteObject.createImmutable(("dirAllowed")),(abmapplication.__c.getField(true,"False"))}))));
 BA.debugLineNum = 131;BA.debugLine="srvr.Start";
Debug.ShouldStop(4);
_srvr.runVoidMethod ("Start");
 BA.debugLineNum = 132;BA.debugLine="Dim jo As JavaObject = srvr";
Debug.ShouldStop(8);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(_srvr);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 133;BA.debugLine="Dim connectors() As Object = jo.GetFieldJO(\"serve";
Debug.ShouldStop(16);
_connectors = (_jo.runMethod(false,"GetFieldJO",(Object)(RemoteObject.createImmutable("server"))).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getConnectors")),(Object)((abmapplication.__c.getField(false,"Null")))));Debug.locals.put("connectors", _connectors);Debug.locals.put("connectors", _connectors);
 BA.debugLineNum = 134;BA.debugLine="Dim timeout As Long = ABMShared.SessionMaxInactiv";
Debug.ShouldStop(32);
_timeout = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {abmapplication._abmshared._sessionmaxinactiveintervalseconds,RemoteObject.createImmutable(1000)}, "*",0, 1));Debug.locals.put("timeout", _timeout);Debug.locals.put("timeout", _timeout);
 BA.debugLineNum = 135;BA.debugLine="For Each c As JavaObject In connectors";
Debug.ShouldStop(64);
_c = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
final RemoteObject group18 = _connectors;
final int groupLen18 = group18.getField(true,"length").<Integer>get();
for (int index18 = 0;index18 < groupLen18 ;index18++){
_c.setObject(group18.getArrayElement(false,RemoteObject.createImmutable(index18)));
Debug.locals.put("c", _c);
 BA.debugLineNum = 136;BA.debugLine="c.RunMethod(\"setIdleTimeout\", Array(timeout))";
Debug.ShouldStop(128);
_c.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setIdleTimeout")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_timeout)})));
 }
Debug.locals.put("c", _c);
;
 BA.debugLineNum = 138;BA.debugLine="ABMShared.CachedPages = srvr.CreateThreadSafeMap";
Debug.ShouldStop(512);
abmapplication._abmshared._cachedpages = _srvr.runMethod(false,"CreateThreadSafeMap");
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _startserverhttp2(RemoteObject __ref,RemoteObject _srvr,RemoteObject _srvrname,RemoteObject _srvrport,RemoteObject _sslsvrport,RemoteObject _sslkeystorefilename,RemoteObject _sslkeystorepassword,RemoteObject _sslkeymanagerpassword) throws Exception{
try {
		Debug.PushSubsStack("StartServerHTTP2 (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,141);
if (RapidSub.canDelegate("startserverhttp2")) return __ref.runUserSub(false, "abmapplication","startserverhttp2", __ref, _srvr, _srvrname, _srvrport, _sslsvrport, _sslkeystorefilename, _sslkeystorepassword, _sslkeymanagerpassword);
RemoteObject _ssl = RemoteObject.declareNull("anywheresoftware.b4j.object.ServerWrapper.SslContextFactoryWrapper");
int _i = 0;
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _connectors = null;
RemoteObject _timeout = RemoteObject.createImmutable(0L);
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("srvr", _srvr);
Debug.locals.put("srvrName", _srvrname);
Debug.locals.put("srvrPort", _srvrport);
Debug.locals.put("SSLsvrPort", _sslsvrport);
Debug.locals.put("SSLKeyStoreFileName", _sslkeystorefilename);
Debug.locals.put("SSLKeyStorePassword", _sslkeystorepassword);
Debug.locals.put("SSLKeyManagerPassword", _sslkeymanagerpassword);
 BA.debugLineNum = 141;BA.debugLine="public Sub StartServerHTTP2(srvr As Server, srvrNa";
Debug.ShouldStop(4096);
 BA.debugLineNum = 142;BA.debugLine="ABM.WriteAppLauchPageToDisk(AppPage, File.DirApp";
Debug.ShouldStop(8192);
__ref.getField(false,"_abm").runVoidMethod ("WriteAppLauchPageToDisk",(Object)(__ref.getField(false,"_apppage")),(Object)(RemoteObject.concat(abmapplication.__c.getField(false,"File").runMethod(true,"getDirApp"),RemoteObject.createImmutable("/www/"),abmapplication._abmshared._appname)),(Object)(BA.ObjectToString("index.html")),(Object)(abmapplication._abmshared._needsauthorization));
 BA.debugLineNum = 144;BA.debugLine="Dim ssl As SslConfiguration";
Debug.ShouldStop(32768);
_ssl = RemoteObject.createNew ("anywheresoftware.b4j.object.ServerWrapper.SslContextFactoryWrapper");Debug.locals.put("ssl", _ssl);
 BA.debugLineNum = 145;BA.debugLine="ssl.Initialize";
Debug.ShouldStop(65536);
_ssl.runVoidMethod ("Initialize");
 BA.debugLineNum = 146;BA.debugLine="ssl.SetKeyStorePath(File.DirApp, SSLKeyStoreFileN";
Debug.ShouldStop(131072);
_ssl.runVoidMethod ("SetKeyStorePath",(Object)(abmapplication.__c.getField(false,"File").runMethod(true,"getDirApp")),(Object)(_sslkeystorefilename));
 BA.debugLineNum = 147;BA.debugLine="ssl.KeyStorePassword = SSLKeyStorePassword";
Debug.ShouldStop(262144);
_ssl.runVoidMethod ("setKeyStorePassword",_sslkeystorepassword);
 BA.debugLineNum = 148;BA.debugLine="ssl.KeyManagerPassword = SSLKeyManagerPassword";
Debug.ShouldStop(524288);
_ssl.runVoidMethod ("setKeyManagerPassword",_sslkeymanagerpassword);
 BA.debugLineNum = 149;BA.debugLine="srvr.SetSslConfiguration(ssl, SSLsvrPort)";
Debug.ShouldStop(1048576);
_srvr.runVoidMethod ("SetSslConfiguration",(Object)(_ssl),(Object)(_sslsvrport));
 BA.debugLineNum = 152;BA.debugLine="srvr.Initialize(srvrName)";
Debug.ShouldStop(8388608);
_srvr.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(_srvrname));
 BA.debugLineNum = 154;BA.debugLine="srvr.AddFilter(\"/js/b4j_ws.min.js\", \"ABMSessionCr";
Debug.ShouldStop(33554432);
_srvr.runVoidMethod ("AddFilter",(Object)(BA.ObjectToString("/js/b4j_ws.min.js")),(Object)(BA.ObjectToString("ABMSessionCreator")),(Object)(abmapplication.__c.getField(true,"False")));
 BA.debugLineNum = 155;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName, \"AB";
Debug.ShouldStop(67108864);
_srvr.runVoidMethod ("AddWebSocket",(Object)(RemoteObject.concat(RemoteObject.createImmutable("/ws/"),abmapplication._abmshared._appname)),(Object)(RemoteObject.createImmutable("ABMApplication")));
 BA.debugLineNum = 156;BA.debugLine="For i =0 To Pages.Size - 1";
Debug.ShouldStop(134217728);
{
final int step11 = 1;
final int limit11 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_pages").runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11); _i = ((int)(0 + _i + step11)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 157;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName & \"";
Debug.ShouldStop(268435456);
_srvr.runVoidMethod ("AddWebSocket",(Object)(RemoteObject.concat(RemoteObject.createImmutable("/ws/"),abmapplication._abmshared._appname,RemoteObject.createImmutable("/"),__ref.getField(false,"_pages").runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))),(Object)(BA.ObjectToString(__ref.getField(false,"_pages").runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))))));
 BA.debugLineNum = 158;BA.debugLine="If PageNeedsUpload.Get(i) Then";
Debug.ShouldStop(536870912);
if (BA.ObjectToBoolean(__ref.getField(false,"_pageneedsupload").runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 159;BA.debugLine="srvr.AddHandler(\"/\" & ABMShared.AppName & \"/\" &";
Debug.ShouldStop(1073741824);
_srvr.runVoidMethod ("AddHandler",(Object)(RemoteObject.concat(RemoteObject.createImmutable("/"),abmapplication._abmshared._appname,RemoteObject.createImmutable("/"),__ref.getField(false,"_pages").runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))),RemoteObject.createImmutable("/abmuploadhandler"))),(Object)(BA.ObjectToString("ABMUploadHandler")),(Object)(abmapplication.__c.getField(true,"False")));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 162;BA.debugLine="srvr.AddBackgroundWorker(\"ABMCacheScavenger\")";
Debug.ShouldStop(2);
_srvr.runVoidMethod ("AddBackgroundWorker",(Object)(RemoteObject.createImmutable("ABMCacheScavenger")));
 BA.debugLineNum = 163;BA.debugLine="srvr.Port = srvrPort";
Debug.ShouldStop(4);
_srvr.runMethod(true,"setPort",_srvrport);
 BA.debugLineNum = 164;BA.debugLine="srvr.Http2Enabled = True";
Debug.ShouldStop(8);
_srvr.runMethod(true,"setHttp2Enabled",abmapplication.__c.getField(true,"True"));
 BA.debugLineNum = 168;BA.debugLine="srvr.SetStaticFilesOptions(CreateMap(\"cacheContr";
Debug.ShouldStop(128);
_srvr.runVoidMethod ("SetStaticFilesOptions",(Object)(abmapplication.__c.runMethod(false, "createMap", (Object)(new RemoteObject[] {RemoteObject.createImmutable(("cacheControl")),RemoteObject.createImmutable(("max-age=604800,public")),RemoteObject.createImmutable(("gzip")),(abmapplication.__c.getField(true,"False")),RemoteObject.createImmutable(("dirAllowed")),(abmapplication.__c.getField(true,"False"))}))));
 BA.debugLineNum = 170;BA.debugLine="srvr.Start";
Debug.ShouldStop(512);
_srvr.runVoidMethod ("Start");
 BA.debugLineNum = 171;BA.debugLine="Dim jo As JavaObject = srvr";
Debug.ShouldStop(1024);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(_srvr);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 172;BA.debugLine="Dim connectors() As Object = jo.GetFieldJO(\"serve";
Debug.ShouldStop(2048);
_connectors = (_jo.runMethod(false,"GetFieldJO",(Object)(RemoteObject.createImmutable("server"))).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getConnectors")),(Object)((abmapplication.__c.getField(false,"Null")))));Debug.locals.put("connectors", _connectors);Debug.locals.put("connectors", _connectors);
 BA.debugLineNum = 173;BA.debugLine="Dim timeout As Long = ABMShared.SessionMaxInactiv";
Debug.ShouldStop(4096);
_timeout = BA.numberCast(long.class, RemoteObject.solve(new RemoteObject[] {abmapplication._abmshared._sessionmaxinactiveintervalseconds,RemoteObject.createImmutable(1000)}, "*",0, 1));Debug.locals.put("timeout", _timeout);Debug.locals.put("timeout", _timeout);
 BA.debugLineNum = 174;BA.debugLine="For Each c As JavaObject In connectors";
Debug.ShouldStop(8192);
_c = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
final RemoteObject group25 = _connectors;
final int groupLen25 = group25.getField(true,"length").<Integer>get();
for (int index25 = 0;index25 < groupLen25 ;index25++){
_c.setObject(group25.getArrayElement(false,RemoteObject.createImmutable(index25)));
Debug.locals.put("c", _c);
 BA.debugLineNum = 175;BA.debugLine="c.RunMethod(\"setIdleTimeout\", Array(timeout))";
Debug.ShouldStop(16384);
_c.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setIdleTimeout")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_timeout)})));
 }
Debug.locals.put("c", _c);
;
 BA.debugLineNum = 177;BA.debugLine="ABMShared.CachedPages = srvr.CreateThreadSafeMap";
Debug.ShouldStop(65536);
abmapplication._abmshared._cachedpages = _srvr.runMethod(false,"CreateThreadSafeMap");
 BA.debugLineNum = 178;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _websocket_connected(RemoteObject __ref,RemoteObject _websocket1) throws Exception{
try {
		Debug.PushSubsStack("WebSocket_Connected (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,51);
if (RapidSub.canDelegate("websocket_connected")) return __ref.runUserSub(false, "abmapplication","websocket_connected", __ref, _websocket1);
RemoteObject _session = RemoteObject.declareNull("anywheresoftware.b4j.object.HttpSessionWrapper");
Debug.locals.put("WebSocket1", _websocket1);
 BA.debugLineNum = 51;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
Debug.ShouldStop(262144);
 BA.debugLineNum = 52;BA.debugLine="Log(\"Connected\")";
Debug.ShouldStop(524288);
abmapplication.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Connected")));
 BA.debugLineNum = 53;BA.debugLine="ws = WebSocket1";
Debug.ShouldStop(1048576);
__ref.setField ("_ws",_websocket1);
 BA.debugLineNum = 54;BA.debugLine="ABMPageId = ABM.GetPageID(AppPage, ABMShared.AppN";
Debug.ShouldStop(2097152);
__ref.setField ("_abmpageid",__ref.getField(false,"_abm").runMethod(true,"GetPageID",(Object)(__ref.getField(false,"_apppage")),(Object)(abmapplication._abmshared._appname),(Object)(__ref.getField(false,"_ws"))));
 BA.debugLineNum = 55;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
Debug.ShouldStop(4194304);
_session = RemoteObject.createNew ("anywheresoftware.b4j.object.HttpSessionWrapper");
_session = __ref.getField(false,"_abm").runMethod(false,"GetSession",(Object)(__ref.getField(false,"_ws")),(Object)(abmapplication._abmshared._sessionmaxinactiveintervalseconds));Debug.locals.put("session", _session);Debug.locals.put("session", _session);
 BA.debugLineNum = 57;BA.debugLine="AppPage.Prepare";
Debug.ShouldStop(16777216);
__ref.getField(false,"_apppage").runVoidMethod ("Prepare");
 BA.debugLineNum = 59;BA.debugLine="ConnectPage";
Debug.ShouldStop(67108864);
__ref.runClassMethod (b4j.example.abmapplication.class, "_connectpage");
 BA.debugLineNum = 61;BA.debugLine="If ABMShared.NeedsAuthorization Then";
Debug.ShouldStop(268435456);
if (abmapplication._abmshared._needsauthorization.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 62;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_session.runMethod(false,"GetAttribute2",(Object)(BA.ObjectToString("IsAuthorized")),(Object)((RemoteObject.createImmutable("")))),RemoteObject.createImmutable(("")))) { 
 BA.debugLineNum = 63;BA.debugLine="AppPage.ShowModalSheet(\"login\")";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_apppage").runVoidMethod ("ShowModalSheet",(Object)(RemoteObject.createImmutable("login")));
 BA.debugLineNum = 64;BA.debugLine="Return";
Debug.ShouldStop(-2147483648);
if (true) return RemoteObject.createImmutable("");
 };
 };
 BA.debugLineNum = 67;BA.debugLine="ABMShared.NavigateToPage(ws, \"\",\"./\" & InitialPag";
Debug.ShouldStop(4);
abmapplication._abmshared.runVoidMethod ("_navigatetopage",(Object)(__ref.getField(false,"_ws")),(Object)(BA.ObjectToString("")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("./"),__ref.getField(true,"_initialpage"))));
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _websocket_disconnected(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("WebSocket_Disconnected (abmapplication) ","abmapplication",1,__ref.getField(false, "ba"),__ref,70);
if (RapidSub.canDelegate("websocket_disconnected")) return __ref.runUserSub(false, "abmapplication","websocket_disconnected", __ref);
 BA.debugLineNum = 70;BA.debugLine="Private Sub WebSocket_Disconnected";
Debug.ShouldStop(32);
 BA.debugLineNum = 71;BA.debugLine="Log(\"Disconnected\")";
Debug.ShouldStop(64);
abmapplication.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Disconnected")));
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}