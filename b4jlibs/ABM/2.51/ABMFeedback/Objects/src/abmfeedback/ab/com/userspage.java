package abmfeedback.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class userspage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmfeedback.ab.com", "abmfeedback.ab.com.userspage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmfeedback.ab.com.userspage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.object.WebSocket _ws = null;
public com.ab.abmaterial.ABMPage _page = null;
public com.ab.abmaterial.ABMTheme _theme = null;
public com.ab.abmaterial.ABMaterial _abm = null;
public String _name = "";
public int _activeuserid = 0;
public String _filter = "";
public String _lastsort = "";
public String _abmpageid = "";
public abmfeedback.ab.com.main _main = null;
public abmfeedback.ab.com.abmshared _abmshared = null;
public abmfeedback.ab.com.dbm _dbm = null;
public String  _adduserbtn_clicked(String _target,String _subtarget) throws Exception{
com.ab.abmaterial.ABMModalSheet _inp = null;
com.ab.abmaterial.ABMCombo _combo1 = null;
com.ab.abmaterial.ABMInput _inpname = null;
com.ab.abmaterial.ABMInput _inplogin = null;
com.ab.abmaterial.ABMInput _inppwd = null;
 //BA.debugLineNum = 329;BA.debugLine="Sub AddUserbtn_Clicked(Target As String, SubTarget";
 //BA.debugLineNum = 331;BA.debugLine="ActiveUserId = 0";
_activeuserid = (int) (0);
 //BA.debugLineNum = 332;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp\")";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 333;BA.debugLine="Dim combo1 As ABMCombo = inp.Content.Component(\"c";
_combo1 = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("combo1"));
 //BA.debugLineNum = 334;BA.debugLine="combo1.SetActiveItemId(\"\")";
_combo1.SetActiveItemId("");
 //BA.debugLineNum = 335;BA.debugLine="Dim inpName As ABMInput = inp.Content.Component(\"";
_inpname = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("inpName"));
 //BA.debugLineNum = 336;BA.debugLine="inpName.Text = \"\"";
_inpname.setText("");
 //BA.debugLineNum = 337;BA.debugLine="Dim inpLogin As ABMInput = inp.Content.Component(";
_inplogin = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("inpLogin"));
 //BA.debugLineNum = 338;BA.debugLine="inpLogin.Text = \"\"";
_inplogin.setText("");
 //BA.debugLineNum = 339;BA.debugLine="Dim inpPwd As ABMInput = inp.Content.Component(\"i";
_inppwd = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("inpPwd"));
 //BA.debugLineNum = 340;BA.debugLine="inpPwd.Text = \"\"";
_inppwd.setText("");
 //BA.debugLineNum = 342;BA.debugLine="page.ShowModalSheet(\"inp\")";
_page.ShowModalSheet("inp");
 //BA.debugLineNum = 343;BA.debugLine="End Sub";
return "";
}
public String  _btnsearch_clicked(String _target) throws Exception{
 //BA.debugLineNum = 562;BA.debugLine="Sub btnSearch_Clicked(Target As String)";
 //BA.debugLineNum = 563;BA.debugLine="DoSearch";
_dosearch();
 //BA.debugLineNum = 564;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMModalSheet  _buildinputsheet() throws Exception{
com.ab.abmaterial.ABMModalSheet _inp = null;
com.ab.abmaterial.ABMCombo _combo1 = null;
com.ab.abmaterial.ABMInput _inpname = null;
com.ab.abmaterial.ABMInput _inplogin = null;
com.ab.abmaterial.ABMInput _inppwd = null;
com.ab.abmaterial.ABMButton _cancelbtn = null;
com.ab.abmaterial.ABMButton _savebtn = null;
 //BA.debugLineNum = 399;BA.debugLine="Sub BuildInputSheet() As ABMModalSheet";
 //BA.debugLineNum = 400;BA.debugLine="Dim inp As ABMModalSheet";
_inp = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 401;BA.debugLine="inp.Initialize(page, \"inp\", False, False, \"\")";
_inp.Initialize(_page,"inp",__c.False,__c.False,"");
 //BA.debugLineNum = 402;BA.debugLine="inp.IsDismissible = False";
_inp.IsDismissible = __c.False;
 //BA.debugLineNum = 404;BA.debugLine="inp.Content.AddRowsM(5, True,0,0, \"\").AddCells12(";
_inp.Content.AddRowsM((int) (5),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 405;BA.debugLine="inp.Content.BuildGrid";
_inp.Content.BuildGrid();
 //BA.debugLineNum = 408;BA.debugLine="inp.Content.CellR(0,1).AddComponent(ABMShared.Bui";
_inp.Content.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Enter the information for this user.")));
 //BA.debugLineNum = 410;BA.debugLine="Dim combo1 As ABMCombo";
_combo1 = new com.ab.abmaterial.ABMCombo();
 //BA.debugLineNum = 411;BA.debugLine="combo1.Initialize(page, \"combo1\", \"User Type\", 65";
_combo1.Initialize(_page,"combo1","User Type",(int) (650),"lightblue");
 //BA.debugLineNum = 414;BA.debugLine="combo1.AddItem(\"combo1S1\", \"Admin\", BuildSimpleIt";
_combo1.AddItem("combo1S1","Admin",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S1","mdi-action-account-circle","{NBSP}{NBSP}Admin")));
 //BA.debugLineNum = 415;BA.debugLine="combo1.AddItem(\"combo1S2\", \"Donator\", BuildSimple";
_combo1.AddItem("combo1S2","Donator",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S2","mdi-action-account-circle","{NBSP}{NBSP}Donator")));
 //BA.debugLineNum = 416;BA.debugLine="combo1.AddItem(\"combo1S0\", \"Guest\", BuildSimpleIt";
_combo1.AddItem("combo1S0","Guest",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S3","mdi-action-dashboard","{NBSP}{NBSP}Guest")));
 //BA.debugLineNum = 418;BA.debugLine="inp.Content.CellR(1,1).AddComponent(combo1)";
_inp.Content.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_combo1));
 //BA.debugLineNum = 420;BA.debugLine="Dim inpName As ABMInput";
_inpname = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 421;BA.debugLine="inpName.Initialize(page, \"inpName\", ABM.INPUT_TEX";
_inpname.Initialize(_page,"inpName",_abm.INPUT_TEXT,"Name",__c.False,"lightblue");
 //BA.debugLineNum = 422;BA.debugLine="inp.Content.CellR(1,1).AddComponent(inpName)";
_inp.Content.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inpname));
 //BA.debugLineNum = 424;BA.debugLine="Dim inpLogin As ABMInput";
_inplogin = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 425;BA.debugLine="inpLogin.Initialize(page, \"inpLogin\", ABM.INPUT_T";
_inplogin.Initialize(_page,"inpLogin",_abm.INPUT_TEXT,"Login",__c.False,"lightblue");
 //BA.debugLineNum = 426;BA.debugLine="inp.Content.CellR(1,1).AddComponent(inpLogin)";
_inp.Content.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inplogin));
 //BA.debugLineNum = 428;BA.debugLine="Dim inpPwd As ABMInput";
_inppwd = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 429;BA.debugLine="inpPwd.Initialize(page, \"inpPwd\", ABM.INPUT_TEXT,";
_inppwd.Initialize(_page,"inpPwd",_abm.INPUT_TEXT,"Password",__c.False,"lightblue");
 //BA.debugLineNum = 430;BA.debugLine="inp.Content.CellR(1,1).AddComponent(inpPwd)";
_inp.Content.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inppwd));
 //BA.debugLineNum = 432;BA.debugLine="inp.Footer.AddRowsM(1,True,0,0, \"\").AddCells12(1,";
_inp.Footer.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 433;BA.debugLine="inp.Footer.BuildGrid 'IMPORTANT once you loaded t";
_inp.Footer.BuildGrid();
 //BA.debugLineNum = 436;BA.debugLine="Dim CancelBtn As ABMButton";
_cancelbtn = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 437;BA.debugLine="CancelBtn.InitializeFlat(page, \"CancelBtn\", \"\", \"";
_cancelbtn.InitializeFlat(_page,"CancelBtn","","","CANCEL","transparent");
 //BA.debugLineNum = 438;BA.debugLine="inp.Footer.Cell(1,1).AddComponent(CancelBtn)";
_inp.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_cancelbtn));
 //BA.debugLineNum = 440;BA.debugLine="Dim SaveBtn As ABMButton";
_savebtn = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 441;BA.debugLine="SaveBtn.InitializeFlat(page, \"SaveBtn\", \"\", \"\", \"";
_savebtn.InitializeFlat(_page,"SaveBtn","","","SAVE","transparent");
 //BA.debugLineNum = 442;BA.debugLine="inp.Footer.Cell(1,1).AddComponent(SaveBtn)";
_inp.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_savebtn));
 //BA.debugLineNum = 444;BA.debugLine="Return inp";
if (true) return _inp;
 //BA.debugLineNum = 445;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMModalSheet  _buildmsgboxyesno() throws Exception{
com.ab.abmaterial.ABMModalSheet _msg = null;
com.ab.abmaterial.ABMButton _msgyes = null;
com.ab.abmaterial.ABMButton _msgno = null;
 //BA.debugLineNum = 447;BA.debugLine="Sub BuildMsgBoxYesNo() As ABMModalSheet";
 //BA.debugLineNum = 448;BA.debugLine="Dim msg As ABMModalSheet";
_msg = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 449;BA.debugLine="msg.Initialize(page, \"msg\", False, False, \"\")";
_msg.Initialize(_page,"msg",__c.False,__c.False,"");
 //BA.debugLineNum = 450;BA.debugLine="msg.IsDismissible = False";
_msg.IsDismissible = __c.False;
 //BA.debugLineNum = 452;BA.debugLine="msg.Content.AddRowsM(1, True,0,0, \"\").AddCells12(";
_msg.Content.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 453;BA.debugLine="msg.Content.BuildGrid";
_msg.Content.BuildGrid();
 //BA.debugLineNum = 456;BA.debugLine="msg.Content.CellR(0,1).AddComponent(ABMShared.Bui";
_msg.Content.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Are you sure you want to delete this user?")));
 //BA.debugLineNum = 458;BA.debugLine="msg.Footer.AddRowsM(1,True,0,0, \"\").AddCellsOS(1,";
_msg.Footer.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOS((int) (1),(int) (6),(int) (6),(int) (6),(int) (3),(int) (3),(int) (3),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (3),(int) (3),(int) (3),"");
 //BA.debugLineNum = 459;BA.debugLine="msg.Footer.BuildGrid 'IMPORTANT once you loaded t";
_msg.Footer.BuildGrid();
 //BA.debugLineNum = 462;BA.debugLine="Dim msgyes As ABMButton";
_msgyes = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 463;BA.debugLine="msgyes.InitializeFlat(page, \"msgyes\", \"\", \"\", \"YE";
_msgyes.InitializeFlat(_page,"msgyes","","","YES","transparent");
 //BA.debugLineNum = 464;BA.debugLine="msg.Footer.Cell(1,1).AddComponent(msgyes)";
_msg.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_msgyes));
 //BA.debugLineNum = 466;BA.debugLine="Dim msgno As ABMButton";
_msgno = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 467;BA.debugLine="msgno.InitializeFlat(page, \"msgno\", \"\", \"\", \"NO\",";
_msgno.InitializeFlat(_page,"msgno","","","NO","transparent");
 //BA.debugLineNum = 468;BA.debugLine="msg.Footer.Cell(1,2).AddComponent(msgno)";
_msg.Footer.Cell((int) (1),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_msgno));
 //BA.debugLineNum = 470;BA.debugLine="Return msg";
if (true) return _msg;
 //BA.debugLineNum = 471;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMLabel  _buildsimpleitem(String _id,String _icon,String _title) throws Exception{
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 473;BA.debugLine="Sub BuildSimpleItem(id As String, icon As String,";
 //BA.debugLineNum = 474;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 475;BA.debugLine="If icon <> \"\" Then";
if ((_icon).equals("") == false) { 
 //BA.debugLineNum = 476;BA.debugLine="lbl.Initialize(page, id, Title, ABM.SIZE_H6, Tru";
_lbl.Initialize(_page,_id,_title,_abm.SIZE_H6,__c.True,"header");
 }else {
 //BA.debugLineNum = 478;BA.debugLine="lbl.Initialize(page, id, Title, ABM.SIZE_H6, Tru";
_lbl.Initialize(_page,_id,_title,_abm.SIZE_H6,__c.True,"");
 };
 //BA.debugLineNum = 480;BA.debugLine="lbl.VerticalAlign = True";
_lbl.VerticalAlign = __c.True;
 //BA.debugLineNum = 481;BA.debugLine="lbl.IconName = icon";
_lbl.IconName = _icon;
 //BA.debugLineNum = 482;BA.debugLine="Return lbl";
if (true) return _lbl;
 //BA.debugLineNum = 483;BA.debugLine="End Sub";
return null;
}
public String  _cancelbtn_clicked(String _target) throws Exception{
 //BA.debugLineNum = 526;BA.debugLine="Sub CancelBtn_Clicked(Target As String)";
 //BA.debugLineNum = 527;BA.debugLine="page.CloseModalSheet(\"inp\")";
_page.CloseModalSheet("inp");
 //BA.debugLineNum = 528;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"UsersPage\"";
_name = "UsersPage";
 //BA.debugLineNum = 14;BA.debugLine="Dim ActiveUserId As Int";
_activeuserid = 0;
 //BA.debugLineNum = 15;BA.debugLine="Dim Filter As String = \" WHERE UserActive<>99 \"";
_filter = " WHERE UserActive<>99 ";
 //BA.debugLineNum = 16;BA.debugLine="Dim LastSort As String";
_lastsort = "";
 //BA.debugLineNum = 17;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public String  _dosearch() throws Exception{
com.ab.abmaterial.ABMInput _searchuser = null;
 //BA.debugLineNum = 570;BA.debugLine="Sub DoSearch()";
 //BA.debugLineNum = 571;BA.debugLine="Dim searchUser As ABMInput = page.Component(\"sear";
_searchuser = (com.ab.abmaterial.ABMInput)(_page.Component("searchUser"));
 //BA.debugLineNum = 572;BA.debugLine="Filter = searchUser.Text";
_filter = _searchuser.getText();
 //BA.debugLineNum = 573;BA.debugLine="If Filter <> \"\" Then";
if ((_filter).equals("") == false) { 
 //BA.debugLineNum = 574;BA.debugLine="Filter = \" WHERE UserActive<>99 AND (userLogin L";
_filter = " WHERE UserActive<>99 AND (userLogin LIKE '%"+_filter+"%' OR userName LIKE '%"+_filter+"%') ";
 }else {
 //BA.debugLineNum = 576;BA.debugLine="Filter = \" WHERE UserActive<>99 \"";
_filter = " WHERE UserActive<>99 ";
 };
 //BA.debugLineNum = 579;BA.debugLine="LoadUsers(1)";
_loadusers((int) (1));
 //BA.debugLineNum = 580;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
com.ab.abmaterial.ABMActionButton _adduserbtn = null;
 //BA.debugLineNum = 21;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 24;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 25;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 28;BA.debugLine="theme.AddTableTheme(\"tbltheme\")";
_theme.AddTableTheme("tbltheme");
 //BA.debugLineNum = 29;BA.debugLine="theme.Table(\"tbltheme\").ZDepth = ABM.ZDEPTH_1";
_theme.Table("tbltheme").ZDepth = _abm.ZDEPTH_1;
 //BA.debugLineNum = 31;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"bg\")";
_theme.Table("tbltheme").AddCellTheme("bg");
 //BA.debugLineNum = 32;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bg\").BackColor = AB";
_theme.Table("tbltheme").Cell("bg").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 33;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bg\").ForeColor = AB";
_theme.Table("tbltheme").Cell("bg").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 35;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"bgr\")";
_theme.Table("tbltheme").AddCellTheme("bgr");
 //BA.debugLineNum = 36;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bgr\").BackColor = A";
_theme.Table("tbltheme").Cell("bgr").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 37;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bgr\").ForeColor = A";
_theme.Table("tbltheme").Cell("bgr").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 38;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bgr\").Align = ABM.T";
_theme.Table("tbltheme").Cell("bgr").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 40;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"bgc\")";
_theme.Table("tbltheme").AddCellTheme("bgc");
 //BA.debugLineNum = 41;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bgc\").BackColor = A";
_theme.Table("tbltheme").Cell("bgc").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 42;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bgc\").ForeColor = A";
_theme.Table("tbltheme").Cell("bgc").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 43;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bgc\").Align = ABM.T";
_theme.Table("tbltheme").Cell("bgc").Align = _abm.TABLECELL_HORIZONTALALIGN_CENTER;
 //BA.debugLineNum = 45;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"nocolor\")";
_theme.Table("tbltheme").AddCellTheme("nocolor");
 //BA.debugLineNum = 46;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"nocolor\").ActiveBac";
_theme.Table("tbltheme").Cell("nocolor").ActiveBackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 47;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"nocolor\").ActiveBac";
_theme.Table("tbltheme").Cell("nocolor").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 49;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"positive\")";
_theme.Table("tbltheme").AddCellTheme("positive");
 //BA.debugLineNum = 50;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"positive\").BackColo";
_theme.Table("tbltheme").Cell("positive").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 51;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"positive\").BackColo";
_theme.Table("tbltheme").Cell("positive").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 52;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"positive\").ActiveBa";
_theme.Table("tbltheme").Cell("positive").ActiveBackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 53;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"positive\").ActiveBa";
_theme.Table("tbltheme").Cell("positive").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 56;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"negative\")";
_theme.Table("tbltheme").AddCellTheme("negative");
 //BA.debugLineNum = 57;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"negative\").BackColo";
_theme.Table("tbltheme").Cell("negative").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 58;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"negative\").BackColo";
_theme.Table("tbltheme").Cell("negative").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 59;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"negative\").ActiveBa";
_theme.Table("tbltheme").Cell("negative").ActiveBackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 60;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"negative\").ActiveBa";
_theme.Table("tbltheme").Cell("negative").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 63;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"points\")";
_theme.Table("tbltheme").AddCellTheme("points");
 //BA.debugLineNum = 64;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"points\").ActiveBack";
_theme.Table("tbltheme").Cell("points").ActiveBackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 65;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"points\").ActiveBack";
_theme.Table("tbltheme").Cell("points").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 66;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"points\").Align = AB";
_theme.Table("tbltheme").Cell("points").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 68;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"openedit\")";
_theme.Table("tbltheme").AddCellTheme("openedit");
 //BA.debugLineNum = 69;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"openedit\").ActiveBa";
_theme.Table("tbltheme").Cell("openedit").ActiveBackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 70;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"openedit\").ActiveBa";
_theme.Table("tbltheme").Cell("openedit").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 71;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"openedit\").Align =";
_theme.Table("tbltheme").Cell("openedit").Align = _abm.TABLECELL_HORIZONTALALIGN_CENTER;
 //BA.debugLineNum = 74;BA.debugLine="theme.AddButtonTheme(\"bigblue\")";
_theme.AddButtonTheme("bigblue");
 //BA.debugLineNum = 75;BA.debugLine="theme.Button(\"bigblue\").BackColor = ABM.COLOR_LIG";
_theme.Button("bigblue").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 78;BA.debugLine="theme.AddContainerTheme(\"modalcontent\")";
_theme.AddContainerTheme("modalcontent");
 //BA.debugLineNum = 79;BA.debugLine="theme.Container(\"modalcontent\").BackColor = ABM.C";
_theme.Container("modalcontent").BackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 82;BA.debugLine="theme.AddContainerTheme(\"modalfooter\")";
_theme.AddContainerTheme("modalfooter");
 //BA.debugLineNum = 83;BA.debugLine="theme.Container(\"modalfooter\").BackColor = ABM.CO";
_theme.Container("modalfooter").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 86;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 87;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 88;BA.debugLine="page.PageTitle = \"ABMFeedback\"";
_page.PageTitle = "ABMFeedback";
 //BA.debugLineNum = 89;BA.debugLine="page.PageDescription = \"Feedback App for the ABMa";
_page.PageDescription = "Feedback App for the ABMaterial Framework for B4J";
 //BA.debugLineNum = 90;BA.debugLine="page.PageHTMLName = \"index.html\"";
_page.PageHTMLName = "index.html";
 //BA.debugLineNum = 91;BA.debugLine="page.PageKeywords = \"\"";
_page.PageKeywords = "";
 //BA.debugLineNum = 92;BA.debugLine="page.PageSiteMapPriority = \"\"";
_page.PageSiteMapPriority = "";
 //BA.debugLineNum = 93;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_YEAR";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_YEARLY;
 //BA.debugLineNum = 94;BA.debugLine="page.DisableBackButton = True";
_page.DisableBackButton = __c.True;
 //BA.debugLineNum = 95;BA.debugLine="page.ShowConnectedIndicator = True";
_page.ShowConnectedIndicator = __c.True;
 //BA.debugLineNum = 97;BA.debugLine="ABMShared.BuildNavigationBar(page, \"Users\", \"../i";
_abmshared._buildnavigationbar(_page,"Users","../images/logo.png","Users","","");
 //BA.debugLineNum = 100;BA.debugLine="page.AddRowsM(1,True,0,0, \"\").AddCells12(1,\"\")";
_page.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 101;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,10,10";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (10),(int) (10),(int) (11),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (2),(int) (2),(int) (1),(int) (14),(int) (0),(int) (0),(int) (0),"");
 //BA.debugLineNum = 103;BA.debugLine="page.AddRows(4,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (4),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 104;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 107;BA.debugLine="page.AddModalSheetTemplate(BuildInputSheet)";
_page.AddModalSheetTemplate(_buildinputsheet());
 //BA.debugLineNum = 109;BA.debugLine="page.AddModalSheetTemplate(BuildMsgBoxYesNo)";
_page.AddModalSheetTemplate(_buildmsgboxyesno());
 //BA.debugLineNum = 112;BA.debugLine="Dim AddUserbtn As ABMActionButton";
_adduserbtn = new com.ab.abmaterial.ABMActionButton();
 //BA.debugLineNum = 113;BA.debugLine="AddUserbtn.Initialize(page, \"AddUserbtn\", \"mdi-co";
_adduserbtn.Initialize(_page,"AddUserbtn","mdi-content-add","","bigblue");
 //BA.debugLineNum = 114;BA.debugLine="AddUserbtn.MainButton.Size = ABM.BUTTONSIZE_LARGE";
_adduserbtn.MainButton().Size = _abm.BUTTONSIZE_LARGE;
 //BA.debugLineNum = 117;BA.debugLine="page.AddActionButton(AddUserbtn)";
_page.AddActionButton(_adduserbtn);
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
return "";
}
public String  _loadusers(int _frompage) throws Exception{
com.ab.abmaterial.ABMTable _tblusers = null;
anywheresoftware.b4j.objects.SQL _sql = null;
int _numusers = 0;
anywheresoftware.b4a.objects.collections.List _users = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _tblfields = null;
anywheresoftware.b4a.objects.collections.List _rcellvalues = null;
anywheresoftware.b4a.objects.collections.List _rcellthemes = null;
com.ab.abmaterial.ABMButton _btnedit = null;
com.ab.abmaterial.ABMButton _btndelete = null;
com.ab.abmaterial.ABMPagination _pagination = null;
 //BA.debugLineNum = 250;BA.debugLine="private Sub LoadUsers(fromPage As Int)";
 //BA.debugLineNum = 251;BA.debugLine="Dim tblUsers As ABMTable = page.Component(\"tblUse";
_tblusers = (com.ab.abmaterial.ABMTable)(_page.Component("tblUsers"));
 //BA.debugLineNum = 253;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 255;BA.debugLine="Dim numusers As Int = DBM.SQLSelectSingleResult(S";
_numusers = (int)(Double.parseDouble(_dbm._sqlselectsingleresult(_sql,"SELECT Count(UserId) as IDS FROM users "+_filter)));
 //BA.debugLineNum = 256;BA.debugLine="Dim users As List = DBM.SQLSelect(SQL, \"SELECT *";
_users = new anywheresoftware.b4a.objects.collections.List();
_users = _dbm._sqlselect(_sql,"SELECT * FROM users "+_filter+" "+_lastsort+" LIMIT "+BA.NumberToString(((_frompage-1)*10))+", 10",(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 257;BA.debugLine="If users.Size = 0 And fromPage > 1 Then";
if (_users.getSize()==0 && _frompage>1) { 
 //BA.debugLineNum = 259;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 260;BA.debugLine="fromPage = fromPage - 1";
_frompage = (int) (_frompage-1);
 //BA.debugLineNum = 261;BA.debugLine="LoadUsers(fromPage)";
_loadusers(_frompage);
 //BA.debugLineNum = 262;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 264;BA.debugLine="tblUsers.SetFooter(\"Total number of users: \" & nu";
_tblusers.SetFooter((Object)("Total number of users: "+BA.NumberToString(_numusers)),(int) (12),"bg");
 //BA.debugLineNum = 265;BA.debugLine="tblUsers.Clear";
_tblusers.Clear();
 //BA.debugLineNum = 267;BA.debugLine="For i = 0 To users.Size - 1";
{
final int step13 = 1;
final int limit13 = (int) (_users.getSize()-1);
for (_i = (int) (0) ; (step13 > 0 && _i <= limit13) || (step13 < 0 && _i >= limit13); _i = ((int)(0 + _i + step13)) ) {
 //BA.debugLineNum = 268;BA.debugLine="Dim tblFields As Map = users.Get(i)";
_tblfields = new anywheresoftware.b4a.objects.collections.Map();
_tblfields.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_users.Get(_i)));
 //BA.debugLineNum = 269;BA.debugLine="Dim rCellValues As List";
_rcellvalues = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 270;BA.debugLine="Dim rCellThemes As List";
_rcellthemes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 271;BA.debugLine="rCellValues.Initialize";
_rcellvalues.Initialize();
 //BA.debugLineNum = 272;BA.debugLine="rCellThemes.Initialize";
_rcellthemes.Initialize();
 //BA.debugLineNum = 274;BA.debugLine="rCellValues.Add(tblFields.Get(\"userid\"))";
_rcellvalues.Add(_tblfields.Get((Object)("userid")));
 //BA.debugLineNum = 275;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 277;BA.debugLine="Select Case tblFields.Get(\"usertype\")";
switch (BA.switchObjectToInt(_tblfields.Get((Object)("usertype")),(Object)("0"),(Object)("1"),(Object)("2"))) {
case 0: {
 //BA.debugLineNum = 279;BA.debugLine="rCellValues.Add(\"Guest\")";
_rcellvalues.Add((Object)("Guest"));
 break; }
case 1: {
 //BA.debugLineNum = 281;BA.debugLine="rCellValues.Add(\"Admin\")";
_rcellvalues.Add((Object)("Admin"));
 break; }
case 2: {
 //BA.debugLineNum = 283;BA.debugLine="rCellValues.Add(\"Donator\")";
_rcellvalues.Add((Object)("Donator"));
 break; }
}
;
 //BA.debugLineNum = 285;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 287;BA.debugLine="rCellValues.Add(tblFields.Get(\"username\"))";
_rcellvalues.Add(_tblfields.Get((Object)("username")));
 //BA.debugLineNum = 288;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 290;BA.debugLine="rCellValues.Add(tblFields.Get(\"userlogin\"))";
_rcellvalues.Add(_tblfields.Get((Object)("userlogin")));
 //BA.debugLineNum = 291;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 293;BA.debugLine="rCellValues.Add(tblFields.Get(\"userpassword\"))";
_rcellvalues.Add(_tblfields.Get((Object)("userpassword")));
 //BA.debugLineNum = 294;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 296;BA.debugLine="Dim btnEdit As ABMButton";
_btnedit = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 297;BA.debugLine="btnEdit.InitializeFloating(page, \"btnEdit\", \"mdi";
_btnedit.InitializeFloating(_page,"btnEdit","mdi-action-visibility","");
 //BA.debugLineNum = 298;BA.debugLine="rCellValues.Add(btnEdit)";
_rcellvalues.Add((Object)(_btnedit));
 //BA.debugLineNum = 299;BA.debugLine="rCellThemes.Add(\"openedit\")";
_rcellthemes.Add((Object)("openedit"));
 //BA.debugLineNum = 301;BA.debugLine="Dim btnDelete As ABMButton";
_btndelete = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 302;BA.debugLine="btnDelete.InitializeFloating(page, \"btnDelete\",";
_btndelete.InitializeFloating(_page,"btnDelete","mdi-action-delete","");
 //BA.debugLineNum = 303;BA.debugLine="rCellValues.Add(btnDelete)";
_rcellvalues.Add((Object)(_btndelete));
 //BA.debugLineNum = 304;BA.debugLine="rCellThemes.Add(\"openedit\")";
_rcellthemes.Add((Object)("openedit"));
 //BA.debugLineNum = 306;BA.debugLine="tblUsers.AddRow(\"uid\" & i, rCellValues)";
_tblusers.AddRow("uid"+BA.NumberToString(_i),_rcellvalues);
 //BA.debugLineNum = 307;BA.debugLine="tblUsers.SetRowThemes(rCellThemes) ' make sure y";
_tblusers.SetRowThemes(_rcellthemes);
 }
};
 //BA.debugLineNum = 309;BA.debugLine="tblUsers.Refresh";
_tblusers.Refresh();
 //BA.debugLineNum = 311;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 313;BA.debugLine="Dim pagination As ABMPagination = page.Component(";
_pagination = (com.ab.abmaterial.ABMPagination)(_page.Component("pagination"));
 //BA.debugLineNum = 314;BA.debugLine="If (numusers Mod 10 > 0) Or (numusers = 0) Then";
if ((_numusers%10>0) || (_numusers==0)) { 
 //BA.debugLineNum = 315;BA.debugLine="numusers = numusers/10 + 1";
_numusers = (int) (_numusers/(double)10+1);
 }else {
 //BA.debugLineNum = 317;BA.debugLine="numusers = numusers/10";
_numusers = (int) (_numusers/(double)10);
 };
 //BA.debugLineNum = 319;BA.debugLine="pagination.SetTotalNumberOfPages(numusers)";
_pagination.SetTotalNumberOfPages(_numusers);
 //BA.debugLineNum = 320;BA.debugLine="pagination.SetActivePage(fromPage)";
_pagination.SetActivePage(_frompage);
 //BA.debugLineNum = 321;BA.debugLine="pagination.Refresh";
_pagination.Refresh();
 //BA.debugLineNum = 322;BA.debugLine="End Sub";
return "";
}
public String  _msgno_clicked(String _target) throws Exception{
 //BA.debugLineNum = 558;BA.debugLine="Sub msgno_Clicked(Target As String)";
 //BA.debugLineNum = 559;BA.debugLine="page.CloseModalSheet(\"msg\")";
_page.CloseModalSheet("msg");
 //BA.debugLineNum = 560;BA.debugLine="End Sub";
return "";
}
public String  _msgyes_clicked(String _target) throws Exception{
anywheresoftware.b4a.objects.collections.Map _currentfields = null;
anywheresoftware.b4a.objects.collections.Map _wherefields = null;
anywheresoftware.b4j.objects.SQL _sql = null;
String _sql_update = "";
com.ab.abmaterial.ABMPagination _pagination = null;
 //BA.debugLineNum = 530;BA.debugLine="Sub msgyes_Clicked(Target As String)";
 //BA.debugLineNum = 531;BA.debugLine="Dim Currentfields, Wherefields As Map";
_currentfields = new anywheresoftware.b4a.objects.collections.Map();
_wherefields = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 532;BA.debugLine="Currentfields.Initialize";
_currentfields.Initialize();
 //BA.debugLineNum = 533;BA.debugLine="Wherefields.Initialize";
_wherefields.Initialize();
 //BA.debugLineNum = 535;BA.debugLine="Currentfields.Put(\"UserActive\", 99)";
_currentfields.Put((Object)("UserActive"),(Object)(99));
 //BA.debugLineNum = 538;BA.debugLine="Wherefields.Put(\"UserId\", ActiveUserId)";
_wherefields.Put((Object)("UserId"),(Object)(_activeuserid));
 //BA.debugLineNum = 540;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 543;BA.debugLine="Dim SQL_Update As String = DBM.BuildUpdateQuery(\"";
_sql_update = _dbm._buildupdatequery("users",_currentfields,_wherefields);
 //BA.debugLineNum = 544;BA.debugLine="DBM.SQLUpdate(SQL, SQL_Update)";
_dbm._sqlupdate(_sql,_sql_update);
 //BA.debugLineNum = 549;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 552;BA.debugLine="Dim pagination As ABMPagination = page.Component(";
_pagination = (com.ab.abmaterial.ABMPagination)(_page.Component("pagination"));
 //BA.debugLineNum = 553;BA.debugLine="LoadUsers(pagination.GetActivePage())";
_loadusers(_pagination.GetActivePage());
 //BA.debugLineNum = 555;BA.debugLine="page.CloseModalSheet(\"msg\")";
_page.CloseModalSheet("msg");
 //BA.debugLineNum = 556;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 231;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 232;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 234;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 235;BA.debugLine="ABMShared.LogOff(page, ABMShared.AppName)";
_abmshared._logoff(_page,_abmshared._appname);
 //BA.debugLineNum = 236;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 238;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 239;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 200;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 201;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 202;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 203;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 204;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 205;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 206;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 208;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 209;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 210;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 211;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 213;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 215;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 217;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 218;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 219;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 221;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 225;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 228;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 241;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 242;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 243;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 244;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 245;BA.debugLine="page.ws.Session.SetAttribute(\"UserType\", \"\" )";
_page.ws.getSession().SetAttribute("UserType",(Object)(""));
 //BA.debugLineNum = 246;BA.debugLine="page.ws.Session.SetAttribute(\"UserID\", \"\" )";
_page.ws.getSession().SetAttribute("UserID",(Object)(""));
 //BA.debugLineNum = 247;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return "";
}
public String  _pagination_pagechanged(int _oldpage,int _newpage) throws Exception{
 //BA.debugLineNum = 324;BA.debugLine="Sub pagination_PageChanged(OldPage As Int, NewPage";
 //BA.debugLineNum = 326;BA.debugLine="LoadUsers(NewPage)";
_loadusers(_newpage);
 //BA.debugLineNum = 327;BA.debugLine="End Sub";
return "";
}
public String  _savebtn_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _inp = null;
anywheresoftware.b4a.objects.collections.Map _currentfields = null;
anywheresoftware.b4a.objects.collections.Map _wherefields = null;
com.ab.abmaterial.ABMCombo _combo1 = null;
com.ab.abmaterial.ABMInput _inpname = null;
com.ab.abmaterial.ABMInput _inplogin = null;
com.ab.abmaterial.ABMInput _inppwd = null;
anywheresoftware.b4j.objects.SQL _sql = null;
String _sql_select = "";
String _sql_insert = "";
String _sql_update = "";
com.ab.abmaterial.ABMPagination _pagination = null;
 //BA.debugLineNum = 485;BA.debugLine="Sub SaveBtn_Clicked(Target As String)";
 //BA.debugLineNum = 486;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp\")";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 488;BA.debugLine="Dim CurrentFields, WhereFields As Map";
_currentfields = new anywheresoftware.b4a.objects.collections.Map();
_wherefields = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 489;BA.debugLine="CurrentFields.Initialize";
_currentfields.Initialize();
 //BA.debugLineNum = 490;BA.debugLine="WhereFields.Initialize";
_wherefields.Initialize();
 //BA.debugLineNum = 493;BA.debugLine="Dim combo1 As ABMCombo = inp.Content.Component(\"c";
_combo1 = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("combo1"));
 //BA.debugLineNum = 494;BA.debugLine="CurrentFields.Put(\"UserType\", ABMShared.Mid(combo";
_currentfields.Put((Object)("UserType"),(Object)(_abmshared._mid(_combo1.GetActiveItemId(),(int) (8),(int) (1))));
 //BA.debugLineNum = 496;BA.debugLine="Dim inpName As ABMInput = inp.Content.Component(\"";
_inpname = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("inpName"));
 //BA.debugLineNum = 497;BA.debugLine="CurrentFields.Put(\"UserName\", DBM.SetQuotes(inpNa";
_currentfields.Put((Object)("UserName"),(Object)(_dbm._setquotes(_inpname.getText())));
 //BA.debugLineNum = 499;BA.debugLine="Dim inpLogin As ABMInput = inp.Content.Component(";
_inplogin = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("inpLogin"));
 //BA.debugLineNum = 500;BA.debugLine="CurrentFields.Put(\"UserLogin\", DBM.SetQuotes(inpL";
_currentfields.Put((Object)("UserLogin"),(Object)(_dbm._setquotes(_inplogin.getText())));
 //BA.debugLineNum = 502;BA.debugLine="Dim inpPwd As ABMInput = inp.Content.Component(\"i";
_inppwd = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("inpPwd"));
 //BA.debugLineNum = 503;BA.debugLine="CurrentFields.Put(\"UserPassword\", DBM.SetQuotes(i";
_currentfields.Put((Object)("UserPassword"),(Object)(_dbm._setquotes(_inppwd.getText())));
 //BA.debugLineNum = 505;BA.debugLine="CurrentFields.Put(\"UserActive\", 0)";
_currentfields.Put((Object)("UserActive"),(Object)(0));
 //BA.debugLineNum = 508;BA.debugLine="WhereFields.Put(\"UserId\", ActiveUserId)";
_wherefields.Put((Object)("UserId"),(Object)(_activeuserid));
 //BA.debugLineNum = 510;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 512;BA.debugLine="Dim SQL_Select As String = \"SELECT UserID FROM us";
_sql_select = "SELECT UserID FROM users WHERE UserID="+BA.NumberToString(_activeuserid);
 //BA.debugLineNum = 513;BA.debugLine="Dim SQL_Insert As String = DBM.BuildInsertQuery(\"";
_sql_insert = _dbm._buildinsertquery("users",_currentfields);
 //BA.debugLineNum = 514;BA.debugLine="Dim SQL_Update As String = DBM.BuildUpdateQuery(\"";
_sql_update = _dbm._buildupdatequery("users",_currentfields,_wherefields);
 //BA.debugLineNum = 515;BA.debugLine="DBM.SQLInsertOrUpdate(SQL, SQL_Select, SQL_Insert";
_dbm._sqlinsertorupdate(_sql,_sql_select,_sql_insert,_sql_update);
 //BA.debugLineNum = 517;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 520;BA.debugLine="Dim pagination As ABMPagination = page.Component(";
_pagination = (com.ab.abmaterial.ABMPagination)(_page.Component("pagination"));
 //BA.debugLineNum = 521;BA.debugLine="LoadUsers(pagination.GetActivePage())";
_loadusers(_pagination.GetActivePage());
 //BA.debugLineNum = 523;BA.debugLine="page.CloseModalSheet(\"inp\")";
_page.CloseModalSheet("inp");
 //BA.debugLineNum = 524;BA.debugLine="End Sub";
return "";
}
public String  _searchuser_enterpressed(String _value) throws Exception{
 //BA.debugLineNum = 566;BA.debugLine="Sub searchUser_EnterPressed(value As String)";
 //BA.debugLineNum = 567;BA.debugLine="DoSearch";
_dosearch();
 //BA.debugLineNum = 568;BA.debugLine="End Sub";
return "";
}
public String  _tblusers_clicked(anywheresoftware.b4a.objects.collections.List _passedrowsandcolumns) throws Exception{
com.ab.abmaterial.ABMTableCell _tblcellinfo = null;
com.ab.abmaterial.ABMTable _tblusers = null;
anywheresoftware.b4j.objects.SQL _sql = null;
com.ab.abmaterial.ABMModalSheet _inp = null;
anywheresoftware.b4a.objects.collections.List _users = null;
anywheresoftware.b4a.objects.collections.Map _user = null;
com.ab.abmaterial.ABMCombo _combo1 = null;
com.ab.abmaterial.ABMInput _inpname = null;
com.ab.abmaterial.ABMInput _inplogin = null;
com.ab.abmaterial.ABMInput _inppwd = null;
com.ab.abmaterial.ABMModalSheet _msg = null;
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 345;BA.debugLine="Sub tblUsers_Clicked(PassedRowsAndColumns As List)";
 //BA.debugLineNum = 347;BA.debugLine="Dim tblCellInfo As ABMTableCell = PassedRowsAndCo";
_tblcellinfo = (com.ab.abmaterial.ABMTableCell)(_passedrowsandcolumns.Get((int) (0)));
 //BA.debugLineNum = 348;BA.debugLine="Dim tblUsers As ABMTable = page.Component(tblCell";
_tblusers = (com.ab.abmaterial.ABMTable)(_page.Component(_tblcellinfo.TableName));
 //BA.debugLineNum = 349;BA.debugLine="If tblCellInfo.Column = 5 Then ' edit";
if (_tblcellinfo.Column==5) { 
 //BA.debugLineNum = 350;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 352;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp\"";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 353;BA.debugLine="ActiveUserId = tblUsers.GetString(tblCellInfo.Ro";
_activeuserid = (int)(Double.parseDouble(_tblusers.GetString(_tblcellinfo.Row,(int) (0))));
 //BA.debugLineNum = 354;BA.debugLine="Dim users As List = DBM.SQLSelect(SQL, \"SELECT *";
_users = new anywheresoftware.b4a.objects.collections.List();
_users = _dbm._sqlselect(_sql,"SELECT * FROM users WHERE userId="+BA.NumberToString(_activeuserid),(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 355;BA.debugLine="If users.Size > 0 Then";
if (_users.getSize()>0) { 
 //BA.debugLineNum = 356;BA.debugLine="Dim user As Map = users.Get(0)";
_user = new anywheresoftware.b4a.objects.collections.Map();
_user.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_users.Get((int) (0))));
 //BA.debugLineNum = 357;BA.debugLine="Dim combo1 As ABMCombo = inp.Content.Component(";
_combo1 = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("combo1"));
 //BA.debugLineNum = 358;BA.debugLine="combo1.SetActiveItemId(\"combo1S\" & user.Get(\"us";
_combo1.SetActiveItemId("combo1S"+BA.ObjectToString(_user.Get((Object)("usertype"))));
 //BA.debugLineNum = 360;BA.debugLine="Dim inpName As ABMInput = inp.Content.Component";
_inpname = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("inpName"));
 //BA.debugLineNum = 361;BA.debugLine="inpName.Text =  user.Get(\"username\")";
_inpname.setText(BA.ObjectToString(_user.Get((Object)("username"))));
 //BA.debugLineNum = 363;BA.debugLine="Dim inpLogin As ABMInput = inp.Content.Componen";
_inplogin = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("inpLogin"));
 //BA.debugLineNum = 364;BA.debugLine="inpLogin.Text =  user.Get(\"userlogin\")";
_inplogin.setText(BA.ObjectToString(_user.Get((Object)("userlogin"))));
 //BA.debugLineNum = 366;BA.debugLine="Dim inpPwd As ABMInput = inp.Content.Component(";
_inppwd = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("inpPwd"));
 //BA.debugLineNum = 367;BA.debugLine="inpPwd.Text =  user.Get(\"userpassword\")";
_inppwd.setText(BA.ObjectToString(_user.Get((Object)("userpassword"))));
 };
 //BA.debugLineNum = 370;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 373;BA.debugLine="page.ShowModalSheet(\"inp\")";
_page.ShowModalSheet("inp");
 //BA.debugLineNum = 375;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 377;BA.debugLine="If tblCellInfo.Column = 6 Then ' delete";
if (_tblcellinfo.Column==6) { 
 //BA.debugLineNum = 378;BA.debugLine="Dim msg As ABMModalSheet = page.ModalSheet(\"msg\"";
_msg = _page.ModalSheet("msg");
 //BA.debugLineNum = 379;BA.debugLine="ActiveUserId = tblUsers.GetString(tblCellInfo.Ro";
_activeuserid = (int)(Double.parseDouble(_tblusers.GetString(_tblcellinfo.Row,(int) (0))));
 //BA.debugLineNum = 380;BA.debugLine="Dim lbl As ABMLabel = msg.Content.Component(\"par";
_lbl = (com.ab.abmaterial.ABMLabel)(_msg.Content.Component("par1"));
 //BA.debugLineNum = 381;BA.debugLine="lbl.Text = \"Are you sure you want to delete '\" &";
_lbl.Text = "Are you sure you want to delete '"+_tblusers.GetString(_tblcellinfo.Row,(int) (2))+"'?";
 //BA.debugLineNum = 382;BA.debugLine="page.ShowModalSheet(\"msg\")";
_page.ShowModalSheet("msg");
 //BA.debugLineNum = 383;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 385;BA.debugLine="End Sub";
return "";
}
public String  _tblusers_sortchanged(String _datafield,String _order) throws Exception{
com.ab.abmaterial.ABMPagination _pagination = null;
 //BA.debugLineNum = 387;BA.debugLine="Sub tblUsers_SortChanged(DataField As String, Orde";
 //BA.debugLineNum = 388;BA.debugLine="Select Case DataField";
switch (BA.switchObjectToInt(_datafield,"UserType","UserName","UserLogin","UserPassword")) {
case 0: 
case 1: 
case 2: 
case 3: {
 //BA.debugLineNum = 390;BA.debugLine="LastSort = \" ORDER BY \" & DataField & \" \" & Ord";
_lastsort = " ORDER BY "+_datafield+" "+_order+" ";
 break; }
default: {
 //BA.debugLineNum = 392;BA.debugLine="LastSort = \"\"";
_lastsort = "";
 break; }
}
;
 //BA.debugLineNum = 395;BA.debugLine="Dim pagination As ABMPagination = page.Component(";
_pagination = (com.ab.abmaterial.ABMPagination)(_page.Component("pagination"));
 //BA.debugLineNum = 396;BA.debugLine="LoadUsers(pagination.GetActivePage())";
_loadusers(_pagination.GetActivePage());
 //BA.debugLineNum = 397;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
com.ab.abmaterial.ABMInput _searchuser = null;
com.ab.abmaterial.ABMButton _btnsearch = null;
com.ab.abmaterial.ABMPagination _pagination = null;
com.ab.abmaterial.ABMTable _tblusers = null;
 //BA.debugLineNum = 121;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 122;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 123;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 124;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 125;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 127;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 128;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 129;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 130;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 134;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 135;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 137;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 139;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 142;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 146;BA.debugLine="Dim searchUser As ABMInput";
_searchuser = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 147;BA.debugLine="searchUser.Initialize(page, \"searchUser\", ABM.IN";
_searchuser.Initialize(_page,"searchUser",_abm.INPUT_TEXT,"Search user",__c.False,"lightblue");
 //BA.debugLineNum = 148;BA.debugLine="page.CellR(1,1).AddComponent(searchUser)";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_searchuser));
 //BA.debugLineNum = 150;BA.debugLine="Dim btnSearch As ABMButton";
_btnsearch = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 151;BA.debugLine="btnSearch.InitializeFloating(page, \"btnSearch\",";
_btnsearch.InitializeFloating(_page,"btnSearch","mdi-action-search","");
 //BA.debugLineNum = 152;BA.debugLine="page.CellR(0,2).AddComponent(btnSearch)";
_page.CellR((int) (0),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnsearch));
 //BA.debugLineNum = 154;BA.debugLine="Dim pagination As ABMPagination";
_pagination = new com.ab.abmaterial.ABMPagination();
 //BA.debugLineNum = 155;BA.debugLine="pagination.Initialize(page, \"pagination\", 10, Tr";
_pagination.Initialize(_page,"pagination",(int) (10),__c.True,__c.True,"");
 //BA.debugLineNum = 156;BA.debugLine="pagination.SetTotalNumberOfPages(0)";
_pagination.SetTotalNumberOfPages((int) (0));
 //BA.debugLineNum = 158;BA.debugLine="page.CellR(1,1).AddComponent(pagination)";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_pagination));
 //BA.debugLineNum = 161;BA.debugLine="Dim tblUsers As ABMTable";
_tblusers = new com.ab.abmaterial.ABMTable();
 //BA.debugLineNum = 162;BA.debugLine="tblUsers.IsResponsive = True";
_tblusers.IsResponsive = __c.True;
 //BA.debugLineNum = 166;BA.debugLine="tblUsers.Initialize(page, \"tblUsers\", True, True";
_tblusers.Initialize(_page,"tblUsers",__c.True,__c.True,__c.True,"tbltheme");
 //BA.debugLineNum = 167;BA.debugLine="tblUsers.SetHeaders(         Array As String (\"I";
_tblusers.SetHeaders(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"ID","Type","Name","Login","Password","Open/Edit","Delete"}));
 //BA.debugLineNum = 168;BA.debugLine="tblUsers.SetHeaderThemes(    Array As String (\"b";
_tblusers.SetHeaderThemes(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"bg","bg","bg","bg","bg","bgc","bgc"}));
 //BA.debugLineNum = 169;BA.debugLine="tblUsers.SetHeaderHeights(   Array As Int    (0";
_tblusers.SetHeaderHeights(anywheresoftware.b4a.keywords.Common.ArrayToList(new int[]{(int) (0),(int) (0),(int) (0),(int) (0),(int) (0),(int) (48),(int) (48)}));
 //BA.debugLineNum = 170;BA.debugLine="tblUsers.SetColumnVisible(   Array As Boolean(Fa";
_tblusers.SetColumnVisible(anywheresoftware.b4a.keywords.Common.ArrayToList(new boolean[]{__c.False,__c.True,__c.True,__c.True,__c.True,__c.True,__c.True}));
 //BA.debugLineNum = 171;BA.debugLine="tblUsers.SetColumnSortable(  Array As Boolean(Fa";
_tblusers.SetColumnSortable(anywheresoftware.b4a.keywords.Common.ArrayToList(new boolean[]{__c.False,__c.True,__c.True,__c.True,__c.True,__c.False,__c.False}));
 //BA.debugLineNum = 172;BA.debugLine="tblUsers.SetColumnDataFields(Array As String (\"\"";
_tblusers.SetColumnDataFields(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"","UserType","UserName","UserLogin","UserPassword","",""}));
 //BA.debugLineNum = 174;BA.debugLine="tblUsers.SetFooter(\"Total number of users: 0\", 1";
_tblusers.SetFooter((Object)("Total number of users: 0"),(int) (12),"bg");
 //BA.debugLineNum = 176;BA.debugLine="page.CellR(1,1).AddComponent(tblUsers)";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_tblusers));
 //BA.debugLineNum = 178;BA.debugLine="If page.ws.Session.GetAttribute2(\"UserType\", \"0\"";
if ((_page.ws.getSession().GetAttribute2("UserType",(Object)("0"))).equals((Object)("1"))) { 
 //BA.debugLineNum = 179;BA.debugLine="page.NavigationBar.AddSideBarItem(\"Users\", \"Use";
_page.NavigationBar().AddSideBarItem("Users","Users","mdi-action-dashboard","../UsersPage");
 };
 //BA.debugLineNum = 182;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 185;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 188;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 191;BA.debugLine="LoadUsers(1)";
_loadusers((int) (1));
 };
 //BA.debugLineNum = 193;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 194;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 196;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 197;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 198;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
