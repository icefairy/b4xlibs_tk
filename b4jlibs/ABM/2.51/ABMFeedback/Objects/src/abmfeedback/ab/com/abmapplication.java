package abmfeedback.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class abmapplication extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmfeedback.ab.com", "abmfeedback.ab.com.abmapplication", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmfeedback.ab.com.abmapplication.class).invoke(this, new Object[] {null});
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
public abmfeedback.ab.com.main _main = null;
public abmfeedback.ab.com.abmshared _abmshared = null;
public abmfeedback.ab.com.dbm _dbm = null;
public String  _addpage(com.ab.abmaterial.ABMPage _page) throws Exception{
 //BA.debugLineNum = 139;BA.debugLine="public Sub AddPage(page As ABMPage)";
 //BA.debugLineNum = 140;BA.debugLine="Pages.Add(page.Name)";
_pages.Add((Object)(_page.getName()));
 //BA.debugLineNum = 141;BA.debugLine="PageNeedsUpload.Add(ABM.WritePageToDisk(page, Fil";
_pageneedsupload.Add((Object)(_abm.WritePageToDisk(_page,__c.File.getDirApp()+"/www/"+_abmshared._appname+"/"+_page.getName()+"/","index.html",_abmshared._needsauthorization)));
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMModalSheet  _buildloginsheet() throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMInput _inp2 = null;
com.ab.abmaterial.ABMSocialOAuth _soauth = null;
com.ab.abmaterial.ABMButton _msbtn1 = null;
 //BA.debugLineNum = 274;BA.debugLine="Sub BuildLoginSheet() As ABMModalSheet";
 //BA.debugLineNum = 275;BA.debugLine="Dim myModal As ABMModalSheet";
_mymodal = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 276;BA.debugLine="myModal.Initialize(AppPage, \"login\", False, False";
_mymodal.Initialize(_apppage,"login",__c.False,__c.False,"");
 //BA.debugLineNum = 277;BA.debugLine="myModal.Content.UseTheme(\"modalcontent\")";
_mymodal.Content.UseTheme("modalcontent");
 //BA.debugLineNum = 278;BA.debugLine="myModal.Footer.UseTheme(\"modalfooter\")";
_mymodal.Footer.UseTheme("modalfooter");
 //BA.debugLineNum = 279;BA.debugLine="myModal.IsDismissible = False";
_mymodal.IsDismissible = __c.False;
 //BA.debugLineNum = 282;BA.debugLine="myModal.Content.AddRows(3,True, \"\").AddCells12(1,";
_mymodal.Content.AddRows((int) (3),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 283;BA.debugLine="myModal.Content.BuildGrid 'IMPORTANT once you loa";
_mymodal.Content.BuildGrid();
 //BA.debugLineNum = 286;BA.debugLine="myModal.Content.Cell(1,1).AddComponent(ABMShared.";
_mymodal.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_apppage,"par1","Donators, use your login and password.  Others, request one from alain.bailleul@pandora.be.")));
 //BA.debugLineNum = 289;BA.debugLine="Dim inp1 As ABMInput";
_inp1 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 290;BA.debugLine="inp1.Initialize(AppPage, \"inp1\", ABM.INPUT_TEXT,";
_inp1.Initialize(_apppage,"inp1",_abm.INPUT_TEXT,"Login",__c.False,"lightblue");
 //BA.debugLineNum = 291;BA.debugLine="myModal.Content.Cell(2,1).AddComponent(inp1)";
_mymodal.Content.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp1));
 //BA.debugLineNum = 293;BA.debugLine="Dim inp2 As ABMInput";
_inp2 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 294;BA.debugLine="inp2.Initialize(AppPage, \"inp2\", ABM.INPUT_PASSWO";
_inp2.Initialize(_apppage,"inp2",_abm.INPUT_PASSWORD,"Password",__c.False,"lightblue");
 //BA.debugLineNum = 295;BA.debugLine="myModal.Content.Cell(2,1).AddComponent(inp2)";
_mymodal.Content.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp2));
 //BA.debugLineNum = 298;BA.debugLine="Dim sOAuth As ABMSocialOAuth";
_soauth = new com.ab.abmaterial.ABMSocialOAuth();
 //BA.debugLineNum = 299;BA.debugLine="sOAuth.Initialize(AppPage, \"sOAuth\")";
_soauth.Initialize(_apppage,"sOAuth");
 //BA.debugLineNum = 318;BA.debugLine="myModal.Footer.AddRowsM(1,True,0,0, \"\").AddCellsO";
_mymodal.Footer.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOS((int) (1),(int) (9),(int) (9),(int) (9),(int) (3),(int) (3),(int) (3),"");
 //BA.debugLineNum = 319;BA.debugLine="myModal.Footer.BuildGrid 'IMPORTANT once you load";
_mymodal.Footer.BuildGrid();
 //BA.debugLineNum = 322;BA.debugLine="Dim msbtn1 As ABMButton";
_msbtn1 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 323;BA.debugLine="msbtn1.InitializeFlat(AppPage, \"msbtn1\", \"\", \"\",";
_msbtn1.InitializeFlat(_apppage,"msbtn1","","","Login","transparent");
 //BA.debugLineNum = 324;BA.debugLine="myModal.Footer.Cell(1,1).AddComponent(msbtn1)";
_mymodal.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_msbtn1));
 //BA.debugLineNum = 326;BA.debugLine="Return myModal";
if (true) return _mymodal;
 //BA.debugLineNum = 327;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMModalSheet  _buildwronginputmodalsheet() throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodalerror = null;
com.ab.abmaterial.ABMLabel _lbl1 = null;
 //BA.debugLineNum = 329;BA.debugLine="Sub BuildWrongInputModalSheet() As ABMModalSheet";
 //BA.debugLineNum = 330;BA.debugLine="Dim myModalError As ABMModalSheet";
_mymodalerror = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 331;BA.debugLine="myModalError.Initialize(AppPage, \"wronginput\", Fa";
_mymodalerror.Initialize(_apppage,"wronginput",__c.False,__c.False,"");
 //BA.debugLineNum = 332;BA.debugLine="myModalError.Content.UseTheme(\"modalcontent\")";
_mymodalerror.Content.UseTheme("modalcontent");
 //BA.debugLineNum = 333;BA.debugLine="myModalError.Footer.UseTheme(\"modalcontent\")";
_mymodalerror.Footer.UseTheme("modalcontent");
 //BA.debugLineNum = 334;BA.debugLine="myModalError.IsDismissible = True";
_mymodalerror.IsDismissible = __c.True;
 //BA.debugLineNum = 337;BA.debugLine="myModalError.Content.AddRows(1,True, \"\").AddCells";
_mymodalerror.Content.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 338;BA.debugLine="myModalError.Content.BuildGrid 'IMPORTANT once yo";
_mymodalerror.Content.BuildGrid();
 //BA.debugLineNum = 340;BA.debugLine="Dim lbl1 As ABMLabel";
_lbl1 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 341;BA.debugLine="lbl1.Initialize(AppPage, \"contlbl1\", \"The login o";
_lbl1.Initialize(_apppage,"contlbl1","The login or password are incorrect!",_abm.SIZE_PARAGRAPH,__c.False,"");
 //BA.debugLineNum = 342;BA.debugLine="myModalError.Content.Cell(1,1).AddComponent(lbl1)";
_mymodalerror.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl1));
 //BA.debugLineNum = 344;BA.debugLine="Return myModalError";
if (true) return _mymodalerror;
 //BA.debugLineNum = 345;BA.debugLine="End Sub";
return null;
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Private InitialPage As String = \"OverviewCasesPag";
_initialpage = "OverviewCasesPage";
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
 //BA.debugLineNum = 12;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
anywheresoftware.b4a.objects.collections.List _folders = null;
 //BA.debugLineNum = 15;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 16;BA.debugLine="Pages.Initialize";
_pages.Initialize();
 //BA.debugLineNum = 17;BA.debugLine="PageNeedsUpload.Initialize";
_pageneedsupload.Initialize();
 //BA.debugLineNum = 19;BA.debugLine="ABM.AddAppleTouchIcon(\"apple-touch-icon-152x152.p";
_abm.AddAppleTouchIcon("apple-touch-icon-152x152.png","152x152");
 //BA.debugLineNum = 20;BA.debugLine="ABM.AddMSTileIcon(\"mstile-144x144.png\", \"144x144\"";
_abm.AddMSTileIcon("mstile-144x144.png","144x144");
 //BA.debugLineNum = 21;BA.debugLine="ABM.AddFavorityIcon(\"favicon-32x32.png\", \"32x32\")";
_abm.AddFavorityIcon("favicon-32x32.png","32x32");
 //BA.debugLineNum = 22;BA.debugLine="ABM.AppVersion=ABMShared.AppVersion";
_abm.AppVersion = _abmshared._appversion;
 //BA.debugLineNum = 23;BA.debugLine="ABM.AppPublishedStartURL = ABM.AppPublishedStartU";
_abm.AppPublishedStartURL = _abm.AppPublishedStartURL;
 //BA.debugLineNum = 24;BA.debugLine="ABM.PreloadAllJavascriptAndCSSFiles=True	' NEW";
_abm.PreloadAllJavascriptAndCSSFiles = __c.True;
 //BA.debugLineNum = 26;BA.debugLine="ABM.ActivateGZip(\"YOURDONATORKEY\", 1000) ' NEW";
_abm.ActivateGZip("YOURDONATORKEY",(int) (1000));
 //BA.debugLineNum = 27;BA.debugLine="ABM.AppDefaultPageCSSInline=True ' NEW";
_abm.AppDefaultPageCSSInline = __c.True;
 //BA.debugLineNum = 28;BA.debugLine="ABM.AppDefaultPageJSInline=True ' NEW";
_abm.AppDefaultPageJSInline = __c.True;
 //BA.debugLineNum = 30;BA.debugLine="Dim folders As List ' NEW";
_folders = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 31;BA.debugLine="folders.Initialize";
_folders.Initialize();
 //BA.debugLineNum = 32;BA.debugLine="folders.Add(File.DirApp & \"/www/\" & ABMShared.Ap";
_folders.Add((Object)(__c.File.getDirApp()+"/www/"+_abmshared._appname+"/images"));
 //BA.debugLineNum = 33;BA.debugLine="ABM.ActivatePNGOptimize(\"YOURDONATORKEY\", folder";
_abm.ActivatePNGOptimize("YOURDONATORKEY",_folders,__c.False,(int) (9),__c.False,__c.False);
 //BA.debugLineNum = 36;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 37;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 42;BA.debugLine="AppPage.InitializeWithTheme(ABMShared.AppName, \"/";
_apppage.InitializeWithTheme(_abmshared._appname,"/ws/"+_abmshared._appname,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 43;BA.debugLine="AppPage.ShowLoader=True";
_apppage.setShowLoader(__c.True);
 //BA.debugLineNum = 44;BA.debugLine="AppPage.PageTitle = \"ABMFeedback\"";
_apppage.PageTitle = "ABMFeedback";
 //BA.debugLineNum = 45;BA.debugLine="AppPage.PageDescription = \"Feedback App for the A";
_apppage.PageDescription = "Feedback App for the ABMaterial Framework for B4J";
 //BA.debugLineNum = 52;BA.debugLine="AppPage.AddRows(1,True, \"\").AddCells12(1,\"\")";
_apppage.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 53;BA.debugLine="AppPage.BuildGrid 'IMPORTANT once you loaded the";
_apppage.BuildGrid();
 //BA.debugLineNum = 56;BA.debugLine="AppPage.AddModalSheetTemplate(BuildLoginSheet)";
_apppage.AddModalSheetTemplate(_buildloginsheet());
 //BA.debugLineNum = 59;BA.debugLine="AppPage.AddModalSheetTemplate(BuildWrongInputModa";
_apppage.AddModalSheetTemplate(_buildwronginputmodalsheet());
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public String  _inp2_enterpressed(String _value) throws Exception{
anywheresoftware.b4j.objects.SQL _sql = null;
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMInput _inp2 = null;
anywheresoftware.b4a.objects.collections.List _vars = null;
anywheresoftware.b4a.objects.collections.List _users = null;
anywheresoftware.b4a.objects.collections.Map _user = null;
 //BA.debugLineNum = 246;BA.debugLine="Sub inp2_EnterPressed(value As String)";
 //BA.debugLineNum = 247;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 248;BA.debugLine="Dim mymodal As ABMModalSheet = AppPage.ModalSheet";
_mymodal = _apppage.ModalSheet("login");
 //BA.debugLineNum = 249;BA.debugLine="Dim inp1 As ABMInput = mymodal.Content.Component(";
_inp1 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("inp1"));
 //BA.debugLineNum = 250;BA.debugLine="Dim inp2 As ABMInput = mymodal.Content.Component(";
_inp2 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("inp2"));
 //BA.debugLineNum = 252;BA.debugLine="Dim vars As List";
_vars = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 253;BA.debugLine="vars.Initialize";
_vars.Initialize();
 //BA.debugLineNum = 254;BA.debugLine="vars.Add(inp1.Text)";
_vars.Add((Object)(_inp1.getText()));
 //BA.debugLineNum = 255;BA.debugLine="vars.Add(inp2.Text)";
_vars.Add((Object)(_inp2.getText()));
 //BA.debugLineNum = 256;BA.debugLine="Dim users As List = DBM.SQLSelect(SQL, \"SELECT *";
_users = new anywheresoftware.b4a.objects.collections.List();
_users = _dbm._sqlselect(_sql,"SELECT * FROM users WHERE UserLogin=? AND UserPassword=?",_vars);
 //BA.debugLineNum = 257;BA.debugLine="If users.Size = 0 Then";
if (_users.getSize()==0) { 
 //BA.debugLineNum = 258;BA.debugLine="inp2.Text = \"\"";
_inp2.setText("");
 //BA.debugLineNum = 260;BA.debugLine="AppPage.ShowModalSheet(\"wronginput\")";
_apppage.ShowModalSheet("wronginput");
 //BA.debugLineNum = 261;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 263;BA.debugLine="Dim user As Map = users.Get(0)";
_user = new anywheresoftware.b4a.objects.collections.Map();
_user.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_users.Get((int) (0))));
 //BA.debugLineNum = 264;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 265;BA.debugLine="ABM.SaveLogin(AppPage, ABMShared.AppName, inp1.Te";
_abm.SaveLogin(_apppage,_abmshared._appname,_inp1.getText(),_inp2.getText());
 //BA.debugLineNum = 266;BA.debugLine="ws.Session.SetAttribute(\"authType\", \"local\")";
_ws.getSession().SetAttribute("authType",(Object)("local"));
 //BA.debugLineNum = 267;BA.debugLine="ws.Session.SetAttribute(\"authName\", inp1.Text)";
_ws.getSession().SetAttribute("authName",(Object)(_inp1.getText()));
 //BA.debugLineNum = 268;BA.debugLine="ws.Session.SetAttribute(\"IsAuthorized\", \"true\")";
_ws.getSession().SetAttribute("IsAuthorized",(Object)("true"));
 //BA.debugLineNum = 269;BA.debugLine="ws.Session.SetAttribute(\"UserType\", \"\" & user.Get";
_ws.getSession().SetAttribute("UserType",(Object)(""+BA.ObjectToString(_user.Get((Object)("usertype")))));
 //BA.debugLineNum = 270;BA.debugLine="ws.Session.SetAttribute(\"UserID\", \"\" & user.Get(\"";
_ws.getSession().SetAttribute("UserID",(Object)(""+BA.ObjectToString(_user.Get((Object)("userid")))));
 //BA.debugLineNum = 271;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"./\" & In";
_abmshared._navigatetopage(_ws,_abmpageid,"./"+_initialpage);
 //BA.debugLineNum = 272;BA.debugLine="End Sub";
return "";
}
public String  _msbtn1_clicked(String _target) throws Exception{
anywheresoftware.b4j.objects.SQL _sql = null;
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMInput _inp2 = null;
anywheresoftware.b4a.objects.collections.List _vars = null;
anywheresoftware.b4a.objects.collections.List _users = null;
anywheresoftware.b4a.objects.collections.Map _user = null;
 //BA.debugLineNum = 217;BA.debugLine="Sub msbtn1_Clicked(Target As String)";
 //BA.debugLineNum = 218;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 219;BA.debugLine="Dim mymodal As ABMModalSheet = AppPage.ModalSheet";
_mymodal = _apppage.ModalSheet("login");
 //BA.debugLineNum = 220;BA.debugLine="Dim inp1 As ABMInput = mymodal.Content.Component(";
_inp1 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("inp1"));
 //BA.debugLineNum = 221;BA.debugLine="Dim inp2 As ABMInput = mymodal.Content.Component(";
_inp2 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("inp2"));
 //BA.debugLineNum = 224;BA.debugLine="Dim vars As List";
_vars = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 225;BA.debugLine="vars.Initialize";
_vars.Initialize();
 //BA.debugLineNum = 226;BA.debugLine="vars.Add(inp1.Text)";
_vars.Add((Object)(_inp1.getText()));
 //BA.debugLineNum = 227;BA.debugLine="vars.Add(inp2.Text)";
_vars.Add((Object)(_inp2.getText()));
 //BA.debugLineNum = 228;BA.debugLine="Dim users As List = DBM.SQLSelect(SQL, \"SELECT *";
_users = new anywheresoftware.b4a.objects.collections.List();
_users = _dbm._sqlselect(_sql,"SELECT * FROM users WHERE UserLogin=? AND UserPassword=?",_vars);
 //BA.debugLineNum = 229;BA.debugLine="If users.Size = 0 Then";
if (_users.getSize()==0) { 
 //BA.debugLineNum = 230;BA.debugLine="inp2.Text = \"\"";
_inp2.setText("");
 //BA.debugLineNum = 232;BA.debugLine="AppPage.ShowModalSheet(\"wronginput\")";
_apppage.ShowModalSheet("wronginput");
 //BA.debugLineNum = 233;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 235;BA.debugLine="Dim user As Map = users.Get(0)";
_user = new anywheresoftware.b4a.objects.collections.Map();
_user.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_users.Get((int) (0))));
 //BA.debugLineNum = 236;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 237;BA.debugLine="ABM.SaveLogin(AppPage, ABMShared.AppName, inp1.Te";
_abm.SaveLogin(_apppage,_abmshared._appname,_inp1.getText(),_inp2.getText());
 //BA.debugLineNum = 238;BA.debugLine="ws.Session.SetAttribute(\"authType\", \"local\")";
_ws.getSession().SetAttribute("authType",(Object)("local"));
 //BA.debugLineNum = 239;BA.debugLine="ws.Session.SetAttribute(\"authName\", inp1.Text)";
_ws.getSession().SetAttribute("authName",(Object)(_inp1.getText()));
 //BA.debugLineNum = 240;BA.debugLine="ws.Session.SetAttribute(\"IsAuthorized\", \"true\")";
_ws.getSession().SetAttribute("IsAuthorized",(Object)("true"));
 //BA.debugLineNum = 241;BA.debugLine="ws.Session.SetAttribute(\"UserType\", \"\" & user.Get";
_ws.getSession().SetAttribute("UserType",(Object)(""+BA.ObjectToString(_user.Get((Object)("usertype")))));
 //BA.debugLineNum = 242;BA.debugLine="ws.Session.SetAttribute(\"UserID\", \"\" & user.Get(\"";
_ws.getSession().SetAttribute("UserID",(Object)(""+BA.ObjectToString(_user.Get((Object)("userid")))));
 //BA.debugLineNum = 243;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"./\" & In";
_abmshared._navigatetopage(_ws,_abmpageid,"./"+_initialpage);
 //BA.debugLineNum = 244;BA.debugLine="End Sub";
return "";
}
public String  _page_authenticated(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _name = "";
anywheresoftware.b4a.objects.collections.Map _currentfields = null;
anywheresoftware.b4a.objects.collections.Map _wherefields = null;
anywheresoftware.b4j.objects.SQL _sql = null;
String _sql_select = "";
String _sql_insert = "";
String _sql_update = "";
int _newid = 0;
 //BA.debugLineNum = 374;BA.debugLine="Sub Page_Authenticated(Params As Map)";
 //BA.debugLineNum = 375;BA.debugLine="Dim Name As String = Params.Get(\"name\")";
_name = BA.ObjectToString(_params.Get((Object)("name")));
 //BA.debugLineNum = 376;BA.debugLine="Log(\"Authenticated \" & Name)";
__c.Log("Authenticated "+_name);
 //BA.debugLineNum = 378;BA.debugLine="Dim CurrentFields, WhereFields As Map";
_currentfields = new anywheresoftware.b4a.objects.collections.Map();
_wherefields = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 379;BA.debugLine="CurrentFields.Initialize";
_currentfields.Initialize();
 //BA.debugLineNum = 380;BA.debugLine="WhereFields.Initialize";
_wherefields.Initialize();
 //BA.debugLineNum = 382;BA.debugLine="CurrentFields.Put(\"UserType\", 0)";
_currentfields.Put((Object)("UserType"),(Object)(0));
 //BA.debugLineNum = 383;BA.debugLine="CurrentFields.Put(\"UserName\", DBM.SetQuotes(Name)";
_currentfields.Put((Object)("UserName"),(Object)(_dbm._setquotes(_name)));
 //BA.debugLineNum = 384;BA.debugLine="CurrentFields.Put(\"UserLogin\", DBM.SetQuotes(Name";
_currentfields.Put((Object)("UserLogin"),(Object)(_dbm._setquotes(_name)));
 //BA.debugLineNum = 385;BA.debugLine="CurrentFields.Put(\"UserPassword\", DBM.SetQuotes(\"";
_currentfields.Put((Object)("UserPassword"),(Object)(_dbm._setquotes("")));
 //BA.debugLineNum = 386;BA.debugLine="CurrentFields.Put(\"UserActive\", 0)";
_currentfields.Put((Object)("UserActive"),(Object)(0));
 //BA.debugLineNum = 389;BA.debugLine="WhereFields.Put(\"UserLogin\", DBM.SetQuotes(Name))";
_wherefields.Put((Object)("UserLogin"),(Object)(_dbm._setquotes(_name)));
 //BA.debugLineNum = 391;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 393;BA.debugLine="Dim SQL_Select As String = \"SELECT UserID FROM us";
_sql_select = "SELECT UserID FROM users WHERE UserLogin='"+_name+"'";
 //BA.debugLineNum = 394;BA.debugLine="Dim SQL_Insert As String = DBM.BuildInsertQuery(\"";
_sql_insert = _dbm._buildinsertquery("users",_currentfields);
 //BA.debugLineNum = 395;BA.debugLine="Dim SQL_Update As String = DBM.BuildUpdateQuery(\"";
_sql_update = _dbm._buildupdatequery("users",_currentfields,_wherefields);
 //BA.debugLineNum = 396;BA.debugLine="Dim newID As Int = DBM.SQLInsertOrUpdate(SQL, SQL";
_newid = _dbm._sqlinsertorupdate(_sql,_sql_select,_sql_insert,_sql_update);
 //BA.debugLineNum = 399;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 401;BA.debugLine="ws.Session.SetAttribute(\"authType\", Params.Get(\"n";
_ws.getSession().SetAttribute("authType",_params.Get((Object)("network")));
 //BA.debugLineNum = 402;BA.debugLine="ws.Session.SetAttribute(\"authName\", Name)";
_ws.getSession().SetAttribute("authName",(Object)(_name));
 //BA.debugLineNum = 403;BA.debugLine="ws.Session.SetAttribute(\"IsAuthorized\", \"true\")";
_ws.getSession().SetAttribute("IsAuthorized",(Object)("true"));
 //BA.debugLineNum = 404;BA.debugLine="ws.Session.SetAttribute(\"UserType\", \"0\" )";
_ws.getSession().SetAttribute("UserType",(Object)("0"));
 //BA.debugLineNum = 405;BA.debugLine="ws.Session.SetAttribute(\"UserID\", \"\" & newID )";
_ws.getSession().SetAttribute("UserID",(Object)(""+BA.NumberToString(_newid)));
 //BA.debugLineNum = 406;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"./\" & In";
_abmshared._navigatetopage(_ws,_abmpageid,"./"+_initialpage);
 //BA.debugLineNum = 407;BA.debugLine="End Sub";
return "";
}
public String  _page_fileuploaded(String _filename,boolean _success) throws Exception{
 //BA.debugLineNum = 353;BA.debugLine="Sub Page_FileUploaded(FileName As String, success";
 //BA.debugLineNum = 355;BA.debugLine="End Sub";
return "";
}
public String  _page_modalsheetdismissed(String _modalsheetname) throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMInput _inp1 = null;
 //BA.debugLineNum = 365;BA.debugLine="Sub Page_ModalSheetDismissed(ModalSheetName As Str";
 //BA.debugLineNum = 366;BA.debugLine="If ModalSheetName = \"wronginput\" Then";
if ((_modalsheetname).equals("wronginput")) { 
 //BA.debugLineNum = 367;BA.debugLine="AppPage.ShowModalSheet(\"login\")";
_apppage.ShowModalSheet("login");
 //BA.debugLineNum = 368;BA.debugLine="Dim mymodal As ABMModalSheet = AppPage.ModalShee";
_mymodal = _apppage.ModalSheet("login");
 //BA.debugLineNum = 369;BA.debugLine="Dim inp1 As ABMInput = mymodal.Content.Component";
_inp1 = (com.ab.abmaterial.ABMInput)(_mymodal.Content.Component("inp1"));
 //BA.debugLineNum = 370;BA.debugLine="inp1.SetFocus";
_inp1.SetFocus();
 };
 //BA.debugLineNum = 372;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 349;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 350;BA.debugLine="AppPage.SaveNavigationBarPosition";
_apppage.SaveNavigationBarPosition();
 //BA.debugLineNum = 351;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 109;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 110;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 111;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 112;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 113;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 114;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 115;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 117;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 118;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 119;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 120;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 122;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 124;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 126;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 127;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 128;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 130;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 134;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public String  _page_toastclicked(String _toastid,String _action) throws Exception{
 //BA.debugLineNum = 357;BA.debugLine="Sub Page_ToastClicked(ToastId As String, Action As";
 //BA.debugLineNum = 359;BA.debugLine="End Sub";
return "";
}
public String  _page_toastdismissed(String _toastid) throws Exception{
 //BA.debugLineNum = 361;BA.debugLine="Sub Page_ToastDismissed(ToastId As String)";
 //BA.debugLineNum = 363;BA.debugLine="End Sub";
return "";
}
public String  _startserver(anywheresoftware.b4j.object.ServerWrapper _srvr,String _srvrname,int _srvrport) throws Exception{
int _i = 0;
anywheresoftware.b4j.object.JavaObject _jo = null;
Object[] _connectors = null;
long _timeout = 0L;
anywheresoftware.b4j.object.JavaObject _c = null;
 //BA.debugLineNum = 144;BA.debugLine="public Sub StartServer(srvr As Server, srvrName As";
 //BA.debugLineNum = 145;BA.debugLine="ABM.WriteAppLauchPageToDisk(AppPage, File.DirApp";
_abm.WriteAppLauchPageToDisk(_apppage,__c.File.getDirApp()+"/www/"+_abmshared._appname,"index.html",_abmshared._needsauthorization);
 //BA.debugLineNum = 148;BA.debugLine="srvr.Initialize(srvrName)";
_srvr.Initialize(ba,_srvrname);
 //BA.debugLineNum = 150;BA.debugLine="srvr.AddFilter(\"/js/b4j_ws.min.js\", \"ABMSessionCr";
_srvr.AddFilter("/js/b4j_ws.min.js","ABMSessionCreator",__c.False);
 //BA.debugLineNum = 151;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName, \"AB";
_srvr.AddWebSocket("/ws/"+_abmshared._appname,"ABMApplication");
 //BA.debugLineNum = 152;BA.debugLine="For i =0 To Pages.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_pages.getSize()-1);
for (_i = (int) (0) ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
 //BA.debugLineNum = 153;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName & \"";
_srvr.AddWebSocket("/ws/"+_abmshared._appname+"/"+BA.ObjectToString(_pages.Get(_i)),BA.ObjectToString(_pages.Get(_i)));
 //BA.debugLineNum = 154;BA.debugLine="If PageNeedsUpload.Get(i) Then";
if (BA.ObjectToBoolean(_pageneedsupload.Get(_i))) { 
 //BA.debugLineNum = 155;BA.debugLine="srvr.AddHandler(\"/\" & ABMShared.AppName & \"/\" &";
_srvr.AddHandler("/"+_abmshared._appname+"/"+BA.ObjectToString(_pages.Get(_i))+"/abmuploadhandler","ABMUploadHandler",__c.False);
 };
 }
};
 //BA.debugLineNum = 158;BA.debugLine="srvr.AddBackgroundWorker(\"ABMCacheScavenger\")";
_srvr.AddBackgroundWorker("ABMCacheScavenger");
 //BA.debugLineNum = 159;BA.debugLine="srvr.Port = srvrPort";
_srvr.setPort(_srvrport);
 //BA.debugLineNum = 162;BA.debugLine="srvr.SetStaticFilesOptions(CreateMap(\"cacheContr";
_srvr.SetStaticFilesOptions(__c.createMap(new Object[] {(Object)("cacheControl"),(Object)("max-age=604800,public"),(Object)("gzip"),(Object)(__c.True),(Object)("dirAllowed"),(Object)(__c.False)}));
 //BA.debugLineNum = 166;BA.debugLine="srvr.Start";
_srvr.Start();
 //BA.debugLineNum = 167;BA.debugLine="Dim jo As JavaObject = srvr";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_srvr));
 //BA.debugLineNum = 168;BA.debugLine="Dim connectors() As Object = jo.GetFieldJO(\"serve";
_connectors = (Object[])(_jo.GetFieldJO("server").RunMethod("getConnectors",(Object[])(__c.Null)));
 //BA.debugLineNum = 169;BA.debugLine="Dim timeout As Long = ABMShared.SessionMaxInactiv";
_timeout = (long) (_abmshared._sessionmaxinactiveintervalseconds*1000);
 //BA.debugLineNum = 170;BA.debugLine="For Each c As JavaObject In connectors";
_c = new anywheresoftware.b4j.object.JavaObject();
final Object[] group18 = _connectors;
final int groupLen18 = group18.length;
for (int index18 = 0;index18 < groupLen18 ;index18++){
_c.setObject((java.lang.Object)(group18[index18]));
 //BA.debugLineNum = 171;BA.debugLine="c.RunMethod(\"setIdleTimeout\", Array(timeout))";
_c.RunMethod("setIdleTimeout",new Object[]{(Object)(_timeout)});
 }
;
 //BA.debugLineNum = 174;BA.debugLine="ABMShared.CachedPages = srvr.CreateThreadSafeMap";
_abmshared._cachedpages = _srvr.CreateThreadSafeMap();
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public String  _startserverhttp2(anywheresoftware.b4j.object.ServerWrapper _srvr,String _srvrname,int _srvrport,int _sslsvrport,String _sslkeystorefilename,String _sslkeystorepassword,String _sslkeymanagerpassword) throws Exception{
anywheresoftware.b4j.object.ServerWrapper.SslContextFactoryWrapper _ssl = null;
int _i = 0;
anywheresoftware.b4j.object.JavaObject _jo = null;
Object[] _connectors = null;
long _timeout = 0L;
anywheresoftware.b4j.object.JavaObject _c = null;
 //BA.debugLineNum = 177;BA.debugLine="public Sub StartServerHTTP2(srvr As Server, srvrNa";
 //BA.debugLineNum = 178;BA.debugLine="ABM.WriteAppLauchPageToDisk(AppPage, File.DirApp";
_abm.WriteAppLauchPageToDisk(_apppage,__c.File.getDirApp()+"/www/"+_abmshared._appname,"index.html",_abmshared._needsauthorization);
 //BA.debugLineNum = 180;BA.debugLine="Dim ssl As SslConfiguration";
_ssl = new anywheresoftware.b4j.object.ServerWrapper.SslContextFactoryWrapper();
 //BA.debugLineNum = 181;BA.debugLine="ssl.Initialize";
_ssl.Initialize();
 //BA.debugLineNum = 182;BA.debugLine="ssl.SetKeyStorePath(File.DirApp, SSLKeyStoreFileN";
_ssl.SetKeyStorePath(__c.File.getDirApp(),_sslkeystorefilename);
 //BA.debugLineNum = 183;BA.debugLine="ssl.KeyStorePassword = SSLKeyStorePassword";
_ssl.setKeyStorePassword(_sslkeystorepassword);
 //BA.debugLineNum = 184;BA.debugLine="ssl.KeyManagerPassword = SSLKeyManagerPassword";
_ssl.setKeyManagerPassword(_sslkeymanagerpassword);
 //BA.debugLineNum = 185;BA.debugLine="srvr.SetSslConfiguration(ssl, SSLsvrPort)";
_srvr.SetSslConfiguration(_ssl,_sslsvrport);
 //BA.debugLineNum = 188;BA.debugLine="srvr.Initialize(srvrName)";
_srvr.Initialize(ba,_srvrname);
 //BA.debugLineNum = 190;BA.debugLine="srvr.AddFilter(\"/js/b4j_ws.min.js\", \"ABMSessionCr";
_srvr.AddFilter("/js/b4j_ws.min.js","ABMSessionCreator",__c.False);
 //BA.debugLineNum = 191;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName, \"AB";
_srvr.AddWebSocket("/ws/"+_abmshared._appname,"ABMApplication");
 //BA.debugLineNum = 192;BA.debugLine="For i =0 To Pages.Size - 1";
{
final int step11 = 1;
final int limit11 = (int) (_pages.getSize()-1);
for (_i = (int) (0) ; (step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11); _i = ((int)(0 + _i + step11)) ) {
 //BA.debugLineNum = 193;BA.debugLine="srvr.AddWebSocket(\"/ws/\" & ABMShared.AppName & \"";
_srvr.AddWebSocket("/ws/"+_abmshared._appname+"/"+BA.ObjectToString(_pages.Get(_i)),BA.ObjectToString(_pages.Get(_i)));
 //BA.debugLineNum = 194;BA.debugLine="If PageNeedsUpload.Get(i) Then";
if (BA.ObjectToBoolean(_pageneedsupload.Get(_i))) { 
 //BA.debugLineNum = 195;BA.debugLine="srvr.AddHandler(\"/\" & ABMShared.AppName & \"/\" &";
_srvr.AddHandler("/"+_abmshared._appname+"/"+BA.ObjectToString(_pages.Get(_i))+"/abmuploadhandler","ABMUploadHandler",__c.False);
 };
 }
};
 //BA.debugLineNum = 198;BA.debugLine="srvr.AddBackgroundWorker(\"ABMCacheScavenger\")";
_srvr.AddBackgroundWorker("ABMCacheScavenger");
 //BA.debugLineNum = 199;BA.debugLine="srvr.Port = srvrPort";
_srvr.setPort(_srvrport);
 //BA.debugLineNum = 200;BA.debugLine="srvr.Http2Enabled = True";
_srvr.setHttp2Enabled(__c.True);
 //BA.debugLineNum = 202;BA.debugLine="srvr.SetStaticFilesOptions(CreateMap(\"cacheContr";
_srvr.SetStaticFilesOptions(__c.createMap(new Object[] {(Object)("cacheControl"),(Object)("max-age=604800,public"),(Object)("gzip"),(Object)(__c.True),(Object)("dirAllowed"),(Object)(__c.False)}));
 //BA.debugLineNum = 206;BA.debugLine="srvr.Start";
_srvr.Start();
 //BA.debugLineNum = 207;BA.debugLine="Dim jo As JavaObject = srvr";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_srvr));
 //BA.debugLineNum = 208;BA.debugLine="Dim connectors() As Object = jo.GetFieldJO(\"serve";
_connectors = (Object[])(_jo.GetFieldJO("server").RunMethod("getConnectors",(Object[])(__c.Null)));
 //BA.debugLineNum = 209;BA.debugLine="Dim timeout As Long = ABMShared.SessionMaxInactiv";
_timeout = (long) (_abmshared._sessionmaxinactiveintervalseconds*1000);
 //BA.debugLineNum = 210;BA.debugLine="For Each c As JavaObject In connectors";
_c = new anywheresoftware.b4j.object.JavaObject();
final Object[] group25 = _connectors;
final int groupLen25 = group25.length;
for (int index25 = 0;index25 < groupLen25 ;index25++){
_c.setObject((java.lang.Object)(group25[index25]));
 //BA.debugLineNum = 211;BA.debugLine="c.RunMethod(\"setIdleTimeout\", Array(timeout))";
_c.RunMethod("setIdleTimeout",new Object[]{(Object)(_timeout)});
 }
;
 //BA.debugLineNum = 214;BA.debugLine="ABMShared.CachedPages = srvr.CreateThreadSafeMap";
_abmshared._cachedpages = _srvr.CreateThreadSafeMap();
 //BA.debugLineNum = 215;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
String _loginpwd = "";
anywheresoftware.b4j.objects.SQL _sql = null;
String[] _split = null;
anywheresoftware.b4a.objects.collections.List _vars = null;
anywheresoftware.b4a.objects.collections.List _users = null;
anywheresoftware.b4a.objects.collections.Map _user = null;
 //BA.debugLineNum = 62;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 63;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 64;BA.debugLine="ABMPageId = ABM.GetPageID(AppPage, ABMShared.AppN";
_abmpageid = _abm.GetPageID(_apppage,_abmshared._appname,_ws);
 //BA.debugLineNum = 65;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 68;BA.debugLine="AppPage.Prepare";
_apppage.Prepare();
 //BA.debugLineNum = 71;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 72;BA.debugLine="If ws.Session.GetAttribute2(\"IsAuthorized\", \"\")";
if ((_ws.getSession().GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 73;BA.debugLine="Dim loginpwd As String = ABM.LoadLogin(AppPage,";
_loginpwd = _abm.LoadLogin(_apppage,_abmshared._appname);
 //BA.debugLineNum = 74;BA.debugLine="If loginpwd <> \"\" Then";
if ((_loginpwd).equals("") == false) { 
 //BA.debugLineNum = 75;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 76;BA.debugLine="Dim split() As String = Regex.Split(\";\", login";
_split = __c.Regex.Split(";",_loginpwd);
 //BA.debugLineNum = 78;BA.debugLine="Dim vars As List";
_vars = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 79;BA.debugLine="vars.Initialize";
_vars.Initialize();
 //BA.debugLineNum = 80;BA.debugLine="vars.Add(split(0))";
_vars.Add((Object)(_split[(int) (0)]));
 //BA.debugLineNum = 81;BA.debugLine="vars.Add(split(1))";
_vars.Add((Object)(_split[(int) (1)]));
 //BA.debugLineNum = 82;BA.debugLine="Dim users As List = DBM.SQLSelect(SQL, \"SELECT";
_users = new anywheresoftware.b4a.objects.collections.List();
_users = _dbm._sqlselect(_sql,"SELECT * FROM users WHERE UserLogin=? AND UserPassword=?",_vars);
 //BA.debugLineNum = 85;BA.debugLine="If users.Size > 0 Then";
if (_users.getSize()>0) { 
 //BA.debugLineNum = 86;BA.debugLine="Dim user As Map = users.Get(0)";
_user = new anywheresoftware.b4a.objects.collections.Map();
_user.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_users.Get((int) (0))));
 //BA.debugLineNum = 87;BA.debugLine="ws.Session.SetAttribute(\"authType\", \"local\")";
_ws.getSession().SetAttribute("authType",(Object)("local"));
 //BA.debugLineNum = 88;BA.debugLine="ws.Session.SetAttribute(\"authName\", split(0))";
_ws.getSession().SetAttribute("authName",(Object)(_split[(int) (0)]));
 //BA.debugLineNum = 89;BA.debugLine="ws.Session.SetAttribute(\"IsAuthorized\", \"true";
_ws.getSession().SetAttribute("IsAuthorized",(Object)("true"));
 //BA.debugLineNum = 90;BA.debugLine="ws.Session.SetAttribute(\"UserType\", \"\" & user";
_ws.getSession().SetAttribute("UserType",(Object)(""+BA.ObjectToString(_user.Get((Object)("usertype")))));
 //BA.debugLineNum = 91;BA.debugLine="ws.Session.SetAttribute(\"UserID\", \"\" & user.G";
_ws.getSession().SetAttribute("UserID",(Object)(""+BA.ObjectToString(_user.Get((Object)("userid")))));
 //BA.debugLineNum = 92;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"./\"";
_abmshared._navigatetopage(_ws,_abmpageid,"./"+_initialpage);
 //BA.debugLineNum = 93;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 94;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 96;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 };
 //BA.debugLineNum = 98;BA.debugLine="AppPage.ShowModalSheet(\"login\")";
_apppage.ShowModalSheet("login");
 //BA.debugLineNum = 99;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 102;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"./\" & In";
_abmshared._navigatetopage(_ws,_abmpageid,"./"+_initialpage);
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 105;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 106;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "PAGE_FILEUPLOADED"))
	return _page_fileuploaded((String) args[0], (Boolean) args[1]);
return BA.SubDelegator.SubNotFound;
}
}
