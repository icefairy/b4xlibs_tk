package abmfeedback.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class overviewcasespage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmfeedback.ab.com", "abmfeedback.ab.com.overviewcasespage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmfeedback.ab.com.overviewcasespage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.object.WebSocket _ws = null;
public com.ab.abmaterial.ABMPage _page = null;
public com.ab.abmaterial.ABMTheme _theme = null;
public com.ab.abmaterial.ABMaterial _abm = null;
public String _name = "";
public int _mytoastid = 0;
public int _activecaseid = 0;
public String _activecasenumber = "";
public int _activecaseuserid = 0;
public int _activecasenoteid = 0;
public String _filter = "";
public String _filtercount = "";
public String _lastsort = "";
public String _usertype = "";
public int _userid = 0;
public String _username = "";
public anywheresoftware.b4a.objects.collections.Map _attachments = null;
public anywheresoftware.b4a.objects.collections.Map _removeattachments = null;
public String _typedelete = "";
public String _downloadfolder = "";
public String _downloadmaxsize = "";
public int _maxrows = 0;
public String _abmpageid = "";
public abmfeedback.ab.com.main _main = null;
public abmfeedback.ab.com.abmshared _abmshared = null;
public abmfeedback.ab.com.dbm _dbm = null;
public String  _addcasebtn_clicked(String _target,String _subtarget) throws Exception{
com.ab.abmaterial.ABMModalSheet _inp = null;
com.ab.abmaterial.ABMLabel _lblcasecreator = null;
com.ab.abmaterial.ABMCombo _casetype = null;
com.ab.abmaterial.ABMInput _casesummary = null;
com.ab.abmaterial.ABMInput _casedescription = null;
com.ab.abmaterial.ABMCombo _casestatus = null;
com.ab.abmaterial.ABMInput _caseversion = null;
com.ab.abmaterial.ABMButton _savebtn = null;
com.ab.abmaterial.ABMButton _attbtn = null;
com.ab.abmaterial.ABMButton _notebtn = null;
 //BA.debugLineNum = 723;BA.debugLine="Sub AddCaseBtn_Clicked(Target As String, SubTarget";
 //BA.debugLineNum = 725;BA.debugLine="ActiveCaseId = 0";
_activecaseid = (int) (0);
 //BA.debugLineNum = 726;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp\")";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 728;BA.debugLine="Dim lblCaseCreator As ABMLabel =  inp.Content.Com";
_lblcasecreator = (com.ab.abmaterial.ABMLabel)(_inp.Content.Component("lblCaseCreator"));
 //BA.debugLineNum = 729;BA.debugLine="lblCaseCreator.Text = UserName";
_lblcasecreator.Text = _username;
 //BA.debugLineNum = 731;BA.debugLine="Dim casetype As ABMCombo = inp.Content.Component(";
_casetype = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("casetype"));
 //BA.debugLineNum = 732;BA.debugLine="casetype.SetActiveItemId(\"\")";
_casetype.SetActiveItemId("");
 //BA.debugLineNum = 733;BA.debugLine="casetype.Enabled = True";
_casetype.Enabled = __c.True;
 //BA.debugLineNum = 735;BA.debugLine="Dim casesummary As ABMInput = inp.Content.Compone";
_casesummary = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("casesummary"));
 //BA.debugLineNum = 736;BA.debugLine="casesummary.Text = \"\"";
_casesummary.setText("");
 //BA.debugLineNum = 737;BA.debugLine="casesummary.Enabled = True";
_casesummary.Enabled = __c.True;
 //BA.debugLineNum = 739;BA.debugLine="Dim casedescription As ABMInput = inp.Content.Com";
_casedescription = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("casedescription"));
 //BA.debugLineNum = 740;BA.debugLine="casedescription.Text = \"\"";
_casedescription.setText("");
 //BA.debugLineNum = 741;BA.debugLine="casedescription.Enabled = True";
_casedescription.Enabled = __c.True;
 //BA.debugLineNum = 743;BA.debugLine="Dim casestatus As ABMCombo = inp.Content.Componen";
_casestatus = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("casestatus"));
 //BA.debugLineNum = 744;BA.debugLine="casestatus.Visibility = ABM.VISIBILITY_HIDE_ALL";
_casestatus.Visibility = _abm.VISIBILITY_HIDE_ALL;
 //BA.debugLineNum = 745;BA.debugLine="casestatus.SetActiveItemId(\"stat0\")";
_casestatus.SetActiveItemId("stat0");
 //BA.debugLineNum = 746;BA.debugLine="Dim caseversion As ABMInput = inp.Content.Compone";
_caseversion = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("caseversion"));
 //BA.debugLineNum = 747;BA.debugLine="caseversion.Visibility = ABM.VISIBILITY_HIDE_ALL";
_caseversion.Visibility = _abm.VISIBILITY_HIDE_ALL;
 //BA.debugLineNum = 748;BA.debugLine="caseversion.Text = \"\"";
_caseversion.setText("");
 //BA.debugLineNum = 750;BA.debugLine="Dim savebtn As ABMButton = inp.Footer.Component(\"";
_savebtn = (com.ab.abmaterial.ABMButton)(_inp.Footer.Component("SaveBtn"));
 //BA.debugLineNum = 751;BA.debugLine="savebtn.Visibility = ABM.VISIBILITY_ALL";
_savebtn.Visibility = _abm.VISIBILITY_ALL;
 //BA.debugLineNum = 753;BA.debugLine="Dim attbtn As ABMButton = inp.Footer.Component(\"A";
_attbtn = (com.ab.abmaterial.ABMButton)(_inp.Footer.Component("AttBtn"));
 //BA.debugLineNum = 754;BA.debugLine="attbtn.Visibility = ABM.VISIBILITY_ALL";
_attbtn.Visibility = _abm.VISIBILITY_ALL;
 //BA.debugLineNum = 757;BA.debugLine="Dim notebtn As ABMButton = inp.Footer.Component(\"";
_notebtn = (com.ab.abmaterial.ABMButton)(_inp.Footer.Component("NoteBtn"));
 //BA.debugLineNum = 758;BA.debugLine="notebtn.Visibility = ABM.VISIBILITY_HIDE_ALL";
_notebtn.Visibility = _abm.VISIBILITY_HIDE_ALL;
 //BA.debugLineNum = 760;BA.debugLine="If UserType = \"1\" Then ' admin, we're allowed to";
if ((_usertype).equals("1")) { 
 //BA.debugLineNum = 761;BA.debugLine="Dim casestatus As ABMCombo = inp.Content.Compone";
_casestatus = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("casestatus"));
 //BA.debugLineNum = 762;BA.debugLine="casestatus.Visibility = ABM.VISIBILITY_ALL";
_casestatus.Visibility = _abm.VISIBILITY_ALL;
 //BA.debugLineNum = 763;BA.debugLine="casestatus.SetActiveItemId(\"stat0\")";
_casestatus.SetActiveItemId("stat0");
 //BA.debugLineNum = 765;BA.debugLine="Dim caseversion As ABMInput = inp.Content.Compon";
_caseversion = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("caseversion"));
 //BA.debugLineNum = 766;BA.debugLine="caseversion.Visibility = ABM.VISIBILITY_ALL";
_caseversion.Visibility = _abm.VISIBILITY_ALL;
 //BA.debugLineNum = 767;BA.debugLine="caseversion.Text = \"\"";
_caseversion.setText("");
 }else {
 //BA.debugLineNum = 769;BA.debugLine="Dim casestatus As ABMCombo = inp.Content.Compone";
_casestatus = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("casestatus"));
 //BA.debugLineNum = 770;BA.debugLine="casestatus.Visibility = ABM.VISIBILITY_HIDE_ALL";
_casestatus.Visibility = _abm.VISIBILITY_HIDE_ALL;
 //BA.debugLineNum = 771;BA.debugLine="casestatus.SetActiveItemId(\"stat0\")";
_casestatus.SetActiveItemId("stat0");
 //BA.debugLineNum = 773;BA.debugLine="Dim caseversion As ABMInput = inp.Content.Compon";
_caseversion = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("caseversion"));
 //BA.debugLineNum = 774;BA.debugLine="caseversion.Visibility = ABM.VISIBILITY_HIDE_ALL";
_caseversion.Visibility = _abm.VISIBILITY_HIDE_ALL;
 //BA.debugLineNum = 775;BA.debugLine="caseversion.Text = \"\"";
_caseversion.setText("");
 };
 //BA.debugLineNum = 821;BA.debugLine="inp.Content.Cell(5,1).RemoveAllComponents";
_inp.Content.Cell((int) (5),(int) (1)).RemoveAllComponents();
 //BA.debugLineNum = 824;BA.debugLine="inp.Content.Cell(6,1).RemoveAllComponents";
_inp.Content.Cell((int) (6),(int) (1)).RemoveAllComponents();
 //BA.debugLineNum = 830;BA.debugLine="Attachments.Initialize";
_attachments.Initialize();
 //BA.debugLineNum = 831;BA.debugLine="RemoveAttachments.Initialize";
_removeattachments.Initialize();
 //BA.debugLineNum = 833;BA.debugLine="DateTime.DateFormat = \"yyyyMMdd\"";
__c.DateTime.setDateFormat("yyyyMMdd");
 //BA.debugLineNum = 834;BA.debugLine="DateTime.TimeFormat = \"HHmmss\"";
__c.DateTime.setTimeFormat("HHmmss");
 //BA.debugLineNum = 836;BA.debugLine="ActiveCaseNumber = DateTime.Date(DateTime.Now) &";
_activecasenumber = __c.DateTime.Date(__c.DateTime.getNow())+__c.DateTime.Time(__c.DateTime.getNow())+BA.NumberToString(__c.Rnd((int) (1),(int) (50000)));
 //BA.debugLineNum = 837;BA.debugLine="ws.Session.SetAttribute(\"abmactivecasenumber\", Ac";
_ws.getSession().SetAttribute("abmactivecasenumber",(Object)(_activecasenumber));
 //BA.debugLineNum = 838;BA.debugLine="page.ShowModalSheet(\"inp\")";
_page.ShowModalSheet("inp");
 //BA.debugLineNum = 841;BA.debugLine="End Sub";
return "";
}
public String  _attbtn_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _msgbox = null;
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 1353;BA.debugLine="Sub AttBtn_Clicked(Target As String)";
 //BA.debugLineNum = 1354;BA.debugLine="If CheckInput = False Then";
if (_checkinput()==__c.False) { 
 //BA.debugLineNum = 1355;BA.debugLine="Dim msgbox As ABMModalSheet = page.ModalSheet(\"m";
_msgbox = _page.ModalSheet("msgbox");
 //BA.debugLineNum = 1356;BA.debugLine="Dim lbl As ABMLabel = msgbox.Content.Component(\"";
_lbl = (com.ab.abmaterial.ABMLabel)(_msgbox.Content.Component("par1"));
 //BA.debugLineNum = 1357;BA.debugLine="lbl.Text = \"Please fill in all fields!\"";
_lbl.Text = "Please fill in all fields!";
 //BA.debugLineNum = 1358;BA.debugLine="page.ShowModalSheet(\"msgbox\")";
_page.ShowModalSheet("msgbox");
 //BA.debugLineNum = 1359;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 1361;BA.debugLine="page.ShowModalSheet(\"att\")";
_page.ShowModalSheet("att");
 //BA.debugLineNum = 1362;BA.debugLine="End Sub";
return "";
}
public String  _attclosebtn_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _inp = null;
boolean _canbeclosed = false;
String _attlocation = "";
int _attcounter = 0;
int _i = 0;
String _filename = "";
int _caseaid = 0;
com.ab.abmaterial.ABMChip _chip = null;
 //BA.debugLineNum = 1419;BA.debugLine="Sub AttCloseBtn_Clicked(Target As String)";
 //BA.debugLineNum = 1420;BA.debugLine="page.CloseModalSheet(\"att\")";
_page.CloseModalSheet("att");
 //BA.debugLineNum = 1423;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp\")";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 1426;BA.debugLine="inp.Content.Cell(5,1).RemoveAllComponents";
_inp.Content.Cell((int) (5),(int) (1)).RemoveAllComponents();
 //BA.debugLineNum = 1428;BA.debugLine="Dim CanBeclosed As Boolean = (UserType = \"1\" Or p";
_canbeclosed = ((_usertype).equals("1") || (_page.ws.getSession().GetAttribute("UserID")).equals((Object)(_activecaseuserid)));
 //BA.debugLineNum = 1430;BA.debugLine="Dim attLocation As String = \"../uploads/\"";
_attlocation = "../uploads/";
 //BA.debugLineNum = 1432;BA.debugLine="Dim attcounter As Int = 0";
_attcounter = (int) (0);
 //BA.debugLineNum = 1433;BA.debugLine="For i = 0 To Attachments.Size - 1";
{
final int step7 = 1;
final int limit7 = (int) (_attachments.getSize()-1);
for (_i = (int) (0) ; (step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7); _i = ((int)(0 + _i + step7)) ) {
 //BA.debugLineNum = 1434;BA.debugLine="Dim fileName As String	= Attachments.GetValueAt(";
_filename = BA.ObjectToString(_attachments.GetValueAt(_i));
 //BA.debugLineNum = 1435;BA.debugLine="Dim CaseAID As Int = Attachments.GetKeyAt(i)";
_caseaid = (int)(BA.ObjectToNumber(_attachments.GetKeyAt(_i)));
 //BA.debugLineNum = 1436;BA.debugLine="If RemoveAttachments.ContainsKey(CaseAID) = Fals";
if (_removeattachments.ContainsKey((Object)(_caseaid))==__c.False) { 
 //BA.debugLineNum = 1437;BA.debugLine="attcounter = attcounter + 1";
_attcounter = (int) (_attcounter+1);
 //BA.debugLineNum = 1438;BA.debugLine="Dim chip As ABMChip";
_chip = new com.ab.abmaterial.ABMChip();
 //BA.debugLineNum = 1439;BA.debugLine="chip.Initialize(page, attcounter, \"{AL}\" & attL";
_chip.Initialize(_page,BA.NumberToString(_attcounter),"{AL}"+_attlocation+_filename+"{AT}"+_abmshared._mid2(_filename,(int) (_activecasenumber.length()+1))+"{/AL}",_canbeclosed,"chip");
 //BA.debugLineNum = 1440;BA.debugLine="chip.Tag = CaseAID";
_chip.Tag = BA.NumberToString(_caseaid);
 //BA.debugLineNum = 1441;BA.debugLine="inp.Content.Cell(5,1).AddArrayComponent(chip, \"";
_inp.Content.Cell((int) (5),(int) (1)).AddArrayComponent((com.ab.abmaterial.ABMComponent)(_chip),"Chip");
 };
 }
};
 //BA.debugLineNum = 1445;BA.debugLine="inp.Refresh";
_inp.Refresh();
 //BA.debugLineNum = 1446;BA.debugLine="End Sub";
return "";
}
public String  _btnnotecancel_clicked(String _target) throws Exception{
 //BA.debugLineNum = 1668;BA.debugLine="Sub btnNoteCancel_Clicked(Target As String)";
 //BA.debugLineNum = 1669;BA.debugLine="page.CloseModalSheet(\"inpNote\")";
_page.CloseModalSheet("inpNote");
 //BA.debugLineNum = 1670;BA.debugLine="End Sub";
return "";
}
public String  _btnnotedelete_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _inp = null;
com.ab.abmaterial.ABMContainer _note = null;
com.ab.abmaterial.ABMInput _casenotedescription = null;
com.ab.abmaterial.ABMModalSheet _msg = null;
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 1616;BA.debugLine="Sub btnNoteDelete_Clicked(Target As String)";
 //BA.debugLineNum = 1618;BA.debugLine="TypeDelete = \"Note\"";
_typedelete = "Note";
 //BA.debugLineNum = 1620;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp\")";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 1623;BA.debugLine="Target = ABMShared.replaceAll(Target, \"btnnotedel";
_target = _abmshared._replaceall(_target,"btnnotedelete","");
 //BA.debugLineNum = 1624;BA.debugLine="ActiveCaseNoteID = ABMShared.Mid2(Target, \"notes\"";
_activecasenoteid = (int)(Double.parseDouble(_abmshared._mid2(_target,(int) ("notes".length()+1))));
 //BA.debugLineNum = 1626;BA.debugLine="Dim note As ABMContainer = inp.Content.Component(";
_note = (com.ab.abmaterial.ABMContainer)(_inp.Content.Component("notes"+BA.NumberToString(_activecasenoteid)));
 //BA.debugLineNum = 1627;BA.debugLine="Dim casenotedescription As ABMInput = note.Compon";
_casenotedescription = (com.ab.abmaterial.ABMInput)(_note.Component("casenotedescription"));
 //BA.debugLineNum = 1629;BA.debugLine="Dim msg As ABMModalSheet = page.ModalSheet(\"msg\")";
_msg = _page.ModalSheet("msg");
 //BA.debugLineNum = 1631;BA.debugLine="Dim lbl As ABMLabel = msg.Content.Component(\"par1";
_lbl = (com.ab.abmaterial.ABMLabel)(_msg.Content.Component("par1"));
 //BA.debugLineNum = 1632;BA.debugLine="lbl.Text = \"Are you sure you want to delete '\" &";
_lbl.Text = "Are you sure you want to delete '"+_casenotedescription.getText()+"'?";
 //BA.debugLineNum = 1633;BA.debugLine="page.ShowModalSheet(\"msg\")";
_page.ShowModalSheet("msg");
 //BA.debugLineNum = 1635;BA.debugLine="Log(Target)";
__c.Log(_target);
 //BA.debugLineNum = 1636;BA.debugLine="End Sub";
return "";
}
public String  _btnnoteedit_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _inp = null;
com.ab.abmaterial.ABMContainer _note = null;
com.ab.abmaterial.ABMInput _casenotedescription = null;
com.ab.abmaterial.ABMModalSheet _inpnote = null;
com.ab.abmaterial.ABMInput _notedescription = null;
 //BA.debugLineNum = 1599;BA.debugLine="Sub btnNoteEdit_Clicked(Target As String)";
 //BA.debugLineNum = 1600;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp\")";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 1603;BA.debugLine="Target = ABMShared.replaceAll(Target, \"btnnoteedi";
_target = _abmshared._replaceall(_target,"btnnoteedit","");
 //BA.debugLineNum = 1604;BA.debugLine="ActiveCaseNoteID = ABMShared.Mid2(Target, \"notes\"";
_activecasenoteid = (int)(Double.parseDouble(_abmshared._mid2(_target,(int) ("notes".length()+1))));
 //BA.debugLineNum = 1606;BA.debugLine="Dim note As ABMContainer = inp.Content.Component(";
_note = (com.ab.abmaterial.ABMContainer)(_inp.Content.Component("notes"+BA.NumberToString(_activecasenoteid)));
 //BA.debugLineNum = 1607;BA.debugLine="Dim casenotedescription As ABMInput = note.Compon";
_casenotedescription = (com.ab.abmaterial.ABMInput)(_note.Component("casenotedescription"));
 //BA.debugLineNum = 1609;BA.debugLine="Dim inpNote As ABMModalSheet = page.ModalSheet(\"i";
_inpnote = _page.ModalSheet("inpNote");
 //BA.debugLineNum = 1610;BA.debugLine="Dim Notedescription As ABMInput = inpNote.Content";
_notedescription = (com.ab.abmaterial.ABMInput)(_inpnote.Content.Component("notedescription"));
 //BA.debugLineNum = 1611;BA.debugLine="Notedescription.Text = casenotedescription.Text";
_notedescription.setText(_casenotedescription.getText());
 //BA.debugLineNum = 1613;BA.debugLine="page.ShowModalSheet(\"inpNote\")";
_page.ShowModalSheet("inpNote");
 //BA.debugLineNum = 1614;BA.debugLine="End Sub";
return "";
}
public String  _btnnotesave_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _inpnote = null;
com.ab.abmaterial.ABMInput _notedescription = null;
anywheresoftware.b4a.objects.collections.Map _currentfields = null;
anywheresoftware.b4a.objects.collections.Map _wherefields = null;
anywheresoftware.b4j.objects.SQL _sql = null;
String _sql_select = "";
String _sql_insert = "";
String _sql_update = "";
com.ab.abmaterial.ABMModalSheet _inp = null;
anywheresoftware.b4a.objects.collections.List _vars = null;
String _sql_str = "";
anywheresoftware.b4a.objects.collections.List _notes = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _note = null;
com.ab.abmaterial.ABMContainer _notecont = null;
 //BA.debugLineNum = 1672;BA.debugLine="Sub btnNoteSave_Clicked(Target As String)";
 //BA.debugLineNum = 1673;BA.debugLine="Dim inpNote As ABMModalSheet = page.ModalSheet(\"i";
_inpnote = _page.ModalSheet("inpNote");
 //BA.debugLineNum = 1675;BA.debugLine="Dim Notedescription As ABMInput = inpNote.Content";
_notedescription = (com.ab.abmaterial.ABMInput)(_inpnote.Content.Component("notedescription"));
 //BA.debugLineNum = 1677;BA.debugLine="Dim CurrentFields, WhereFields As Map";
_currentfields = new anywheresoftware.b4a.objects.collections.Map();
_wherefields = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 1678;BA.debugLine="CurrentFields.Initialize";
_currentfields.Initialize();
 //BA.debugLineNum = 1679;BA.debugLine="WhereFields.Initialize";
_wherefields.Initialize();
 //BA.debugLineNum = 1681;BA.debugLine="CurrentFields.Put(\"CaseNCaseID\", ActiveCaseId)";
_currentfields.Put((Object)("CaseNCaseID"),(Object)(_activecaseid));
 //BA.debugLineNum = 1682;BA.debugLine="CurrentFields.Put(\"CaseNUserID\", UserID)";
_currentfields.Put((Object)("CaseNUserID"),(Object)(_userid));
 //BA.debugLineNum = 1683;BA.debugLine="CurrentFields.Put(\"CaseNDescription\", DBM.SetQuot";
_currentfields.Put((Object)("CaseNDescription"),(Object)(_dbm._setquotes(_notedescription.getText())));
 //BA.debugLineNum = 1684;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\"";
__c.DateTime.setDateFormat("yyyy-MM-dd");
 //BA.debugLineNum = 1685;BA.debugLine="CurrentFields.Put(\"CaseNCreationDate\", DBM.SetQuo";
_currentfields.Put((Object)("CaseNCreationDate"),(Object)(_dbm._setquotes(__c.DateTime.Date(__c.DateTime.getNow()))));
 //BA.debugLineNum = 1688;BA.debugLine="WhereFields.Put(\"CaseNId\", ActiveCaseNoteID)";
_wherefields.Put((Object)("CaseNId"),(Object)(_activecasenoteid));
 //BA.debugLineNum = 1691;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 1693;BA.debugLine="Dim SQL_Select As String = \"SELECT CaseNId FROM c";
_sql_select = "SELECT CaseNId FROM casenotes WHERE CaseNID="+BA.NumberToString(_activecasenoteid);
 //BA.debugLineNum = 1694;BA.debugLine="Dim SQL_Insert As String = DBM.BuildInsertQuery(\"";
_sql_insert = _dbm._buildinsertquery("casenotes",_currentfields);
 //BA.debugLineNum = 1695;BA.debugLine="Dim SQL_Update As String = DBM.BuildUpdateQuery(\"";
_sql_update = _dbm._buildupdatequery("casenotes",_currentfields,_wherefields);
 //BA.debugLineNum = 1696;BA.debugLine="ActiveCaseNoteID = DBM.SQLInsertOrUpdate(SQL, SQL";
_activecasenoteid = _dbm._sqlinsertorupdate(_sql,_sql_select,_sql_insert,_sql_update);
 //BA.debugLineNum = 1698;BA.debugLine="page.CloseModalSheet(\"inpNote\")";
_page.CloseModalSheet("inpNote");
 //BA.debugLineNum = 1701;BA.debugLine="DBM.SQLDelete(SQL, \"DELETE FROM caseread WHERE Ca";
_dbm._sqldelete(_sql,"DELETE FROM caseread WHERE CaseRCaseID="+BA.NumberToString(_activecaseid));
 //BA.debugLineNum = 1704;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp\")";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 1706;BA.debugLine="Dim vars As List";
_vars = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 1707;BA.debugLine="vars.initialize";
_vars.Initialize();
 //BA.debugLineNum = 1708;BA.debugLine="vars.Add(ActiveCaseId)";
_vars.Add((Object)(_activecaseid));
 //BA.debugLineNum = 1709;BA.debugLine="Dim SQL_str As String = \"SELECT casenotes.*, user";
_sql_str = "SELECT casenotes.*, users.UserName FROM casenotes INNER JOIN users ON casenotes.CaseNUserID = users.UserID WHERE CaseNCaseID=? ORDER BY CaseNCreationDate DESC, CaseNID DESC";
 //BA.debugLineNum = 1710;BA.debugLine="Dim notes As List = DBM.SQLSelect(SQL, SQL_str, v";
_notes = new anywheresoftware.b4a.objects.collections.List();
_notes = _dbm._sqlselect(_sql,_sql_str,_vars);
 //BA.debugLineNum = 1713;BA.debugLine="inp.Content.Cell(6,1).RemoveAllComponents";
_inp.Content.Cell((int) (6),(int) (1)).RemoveAllComponents();
 //BA.debugLineNum = 1715;BA.debugLine="For i = 0 To notes.Size - 1";
{
final int step26 = 1;
final int limit26 = (int) (_notes.getSize()-1);
for (_i = (int) (0) ; (step26 > 0 && _i <= limit26) || (step26 < 0 && _i >= limit26); _i = ((int)(0 + _i + step26)) ) {
 //BA.debugLineNum = 1716;BA.debugLine="Dim note As Map = notes.Get(i)";
_note = new anywheresoftware.b4a.objects.collections.Map();
_note.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_notes.Get(_i)));
 //BA.debugLineNum = 1717;BA.debugLine="Dim notecont As ABMContainer = BuildNoteContaine";
_notecont = _buildnotecontainer(("notes"+BA.ObjectToString(_note.Get((Object)("casenid")))),BA.ObjectToString(_note.Get((Object)("casendescription"))),BA.ObjectToString(_note.Get((Object)("username"))),BA.ObjectToString(_note.Get((Object)("casencreationdate"))),(int)(BA.ObjectToNumber(_note.Get((Object)("casenuserid")))));
 //BA.debugLineNum = 1718;BA.debugLine="inp.Content.Cell(6,1).AddComponent(notecont)";
_inp.Content.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_notecont));
 }
};
 //BA.debugLineNum = 1721;BA.debugLine="inp.Refresh";
_inp.Refresh();
 //BA.debugLineNum = 1723;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 1724;BA.debugLine="End Sub";
return "";
}
public String  _btnsearch_clicked(String _target) throws Exception{
 //BA.debugLineNum = 665;BA.debugLine="Sub btnSearch_Clicked(Target As String)";
 //BA.debugLineNum = 666;BA.debugLine="DoSearch";
_dosearch();
 //BA.debugLineNum = 667;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMModalSheet  _buildattachmentsheet() throws Exception{
com.ab.abmaterial.ABMModalSheet _att = null;
com.ab.abmaterial.ABMUpload _upload1 = null;
com.ab.abmaterial.ABMButton _attclosebtn = null;
 //BA.debugLineNum = 1367;BA.debugLine="Sub BuildAttachmentSheet() As ABMModalSheet";
 //BA.debugLineNum = 1368;BA.debugLine="Dim att As ABMModalSheet";
_att = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 1369;BA.debugLine="att.Initialize(page, \"att\", False, False, \"\")";
_att.Initialize(_page,"att",__c.False,__c.False,"");
 //BA.debugLineNum = 1370;BA.debugLine="att.IsDismissible = False";
_att.IsDismissible = __c.False;
 //BA.debugLineNum = 1372;BA.debugLine="att.Content.AddRowsM(2, True,0,0, \"\").AddCells12(";
_att.Content.AddRowsM((int) (2),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 1373;BA.debugLine="att.Content.BuildGrid";
_att.Content.BuildGrid();
 //BA.debugLineNum = 1376;BA.debugLine="att.Content.CellR(0,1).AddComponent(ABMShared.Bui";
_att.Content.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraphbq(_page,"par1","Maximum 500K, images and zip files only.")));
 //BA.debugLineNum = 1379;BA.debugLine="Dim upload1 As ABMUpload";
_upload1 = new com.ab.abmaterial.ABMUpload();
 //BA.debugLineNum = 1380;BA.debugLine="upload1.Initialize(page, \"upload1\", \"Drop Here\",";
_upload1.Initialize(_page,"upload1","Drop Here","Browse","");
 //BA.debugLineNum = 1381;BA.debugLine="att.Content.CellR(1,1).AddComponent(upload1)";
_att.Content.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_upload1));
 //BA.debugLineNum = 1384;BA.debugLine="att.Footer.AddRowsM(1,True,0,0, \"\").AddCells12(1,";
_att.Footer.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 1385;BA.debugLine="att.Footer.BuildGrid 'IMPORTANT once you loaded t";
_att.Footer.BuildGrid();
 //BA.debugLineNum = 1388;BA.debugLine="Dim AttCloseBtn As ABMButton";
_attclosebtn = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 1389;BA.debugLine="AttCloseBtn.InitializeFlat(page, \"AttCloseBtn\", \"";
_attclosebtn.InitializeFlat(_page,"AttCloseBtn","","","CLOSE","transparent");
 //BA.debugLineNum = 1390;BA.debugLine="att.Footer.Cell(1,1).AddComponent(AttCloseBtn)";
_att.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_attclosebtn));
 //BA.debugLineNum = 1392;BA.debugLine="Return att";
if (true) return _att;
 //BA.debugLineNum = 1393;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMModalSheet  _buildinputsheet() throws Exception{
com.ab.abmaterial.ABMModalSheet _inp = null;
com.ab.abmaterial.ABMLabel _lblcasecreator = null;
com.ab.abmaterial.ABMCombo _casetype = null;
com.ab.abmaterial.ABMInput _casesummary = null;
com.ab.abmaterial.ABMInput _casedescription = null;
com.ab.abmaterial.ABMCombo _casestatus = null;
com.ab.abmaterial.ABMInput _caseversion = null;
com.ab.abmaterial.ABMButton _cancelbtn = null;
com.ab.abmaterial.ABMButton _savebtn = null;
com.ab.abmaterial.ABMButton _attbtn = null;
com.ab.abmaterial.ABMButton _notebtn = null;
 //BA.debugLineNum = 1073;BA.debugLine="Sub BuildInputSheet() As ABMModalSheet";
 //BA.debugLineNum = 1074;BA.debugLine="Dim inp As ABMModalSheet";
_inp = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 1075;BA.debugLine="inp.Initialize(page, \"inp\", True, False, \"\")";
_inp.Initialize(_page,"inp",__c.True,__c.False,"");
 //BA.debugLineNum = 1076;BA.debugLine="inp.IsDismissible = False";
_inp.IsDismissible = __c.False;
 //BA.debugLineNum = 1077;BA.debugLine="inp.Size = ABM.MODALSHEET_SIZE_LARGE";
_inp.Size = _abm.MODALSHEET_SIZE_LARGE;
 //BA.debugLineNum = 1079;BA.debugLine="inp.Content.AddRowsM(1, True,0,0, \"\").AddCells12(";
_inp.Content.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 1080;BA.debugLine="inp.Content.AddRowsM(1, True,0,0, \"\").AddCellsOS(";
_inp.Content.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (3),(int) (3),(int) (3),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (9),(int) (9),(int) (9),"");
 //BA.debugLineNum = 1081;BA.debugLine="inp.Content.AddRowsM(1, True,0,0, \"\").AddCells12(";
_inp.Content.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 1082;BA.debugLine="inp.Content.AddRowsM(1, True,0,0, \"\").AddCellsOS(";
_inp.Content.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (3),(int) (3),(int) (3),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (9),(int) (9),(int) (9),"");
 //BA.debugLineNum = 1083;BA.debugLine="inp.Content.AddRowsM(6, True,0,0, \"\").AddCells12(";
_inp.Content.AddRowsM((int) (6),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 1084;BA.debugLine="inp.Content.BuildGrid";
_inp.Content.BuildGrid();
 //BA.debugLineNum = 1087;BA.debugLine="inp.Content.CellR(0,1).AddComponent(ABMShared.Bui";
_inp.Content.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraphbqwithzdepth(_page,"par1","Enter the information for this case.")));
 //BA.debugLineNum = 1089;BA.debugLine="Dim lblCaseCreator As ABMLabel";
_lblcasecreator = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 1090;BA.debugLine="lblCaseCreator.Initialize(page, \"lblCaseCreator\",";
_lblcasecreator.Initialize(_page,"lblCaseCreator",_username,_abm.SIZE_PARAGRAPH,__c.False,"lightblue");
 //BA.debugLineNum = 1091;BA.debugLine="inp.Content.CellR(0,1).AddComponent(lblCaseCreato";
_inp.Content.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblcasecreator));
 //BA.debugLineNum = 1093;BA.debugLine="Dim casetype As ABMCombo";
_casetype = new com.ab.abmaterial.ABMCombo();
 //BA.debugLineNum = 1094;BA.debugLine="casetype.Initialize(page, \"casetype\", \"Case Type\"";
_casetype.Initialize(_page,"casetype","Case Type",(int) (650),"lightblue");
 //BA.debugLineNum = 1097;BA.debugLine="casetype.AddItem(\"combo1S0\", \"[BUG]\", BuildSimple";
_casetype.AddItem("combo1S0","[BUG]",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S1","mdi-action-bug-report","{NBSP}{NBSP}[BUG]")));
 //BA.debugLineNum = 1098;BA.debugLine="casetype.AddItem(\"combo1S1\", \"[WISH]\", BuildSimpl";
_casetype.AddItem("combo1S1","[WISH]",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S2","mdi-action-alarm-add","{NBSP}{NBSP}[WISH]")));
 //BA.debugLineNum = 1099;BA.debugLine="casetype.AddItem(\"combo1S2\", \"[NEW]\", BuildSimple";
_casetype.AddItem("combo1S2","[NEW]",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S3","mdi-av-new-releases","{NBSP}{NBSP}[NEW]")));
 //BA.debugLineNum = 1101;BA.debugLine="inp.Content.CellR(1,1).AddComponent(casetype)";
_inp.Content.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_casetype));
 //BA.debugLineNum = 1103;BA.debugLine="Dim casesummary As ABMInput";
_casesummary = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 1104;BA.debugLine="casesummary.Initialize(page, \"casesummary\", ABM.I";
_casesummary.Initialize(_page,"casesummary",_abm.INPUT_TEXT,"Summary",__c.False,"lightblue");
 //BA.debugLineNum = 1105;BA.debugLine="inp.Content.CellR(0,2).AddComponent(casesummary)";
_inp.Content.CellR((int) (0),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_casesummary));
 //BA.debugLineNum = 1130;BA.debugLine="Dim casedescription As ABMInput";
_casedescription = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 1131;BA.debugLine="casedescription.Initialize(page, \"casedescription";
_casedescription.Initialize(_page,"casedescription",_abm.INPUT_TEXT,"Description",__c.True,"lightblue");
 //BA.debugLineNum = 1132;BA.debugLine="inp.Content.CellR(1,1).AddComponent(casedescripti";
_inp.Content.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_casedescription));
 //BA.debugLineNum = 1134;BA.debugLine="Dim casestatus As ABMCombo";
_casestatus = new com.ab.abmaterial.ABMCombo();
 //BA.debugLineNum = 1135;BA.debugLine="casestatus.Initialize(page, \"casestatus\", \"Status";
_casestatus.Initialize(_page,"casestatus","Status",(int) (650),"lightblue");
 //BA.debugLineNum = 1146;BA.debugLine="casestatus.AddItem(\"stat0\", \"0 - Submitted\", Buil";
_casestatus.AddItem("stat0","0 - Submitted",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("ST0","","{NBSP}{NBSP}0 - Submitted")));
 //BA.debugLineNum = 1147;BA.debugLine="casestatus.AddItem(\"stat1\", \"1 - Closed, no actio";
_casestatus.AddItem("stat1","1 - Closed, no action",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("ST1","","{NBSP}{NBSP}1 - Closed, no action")));
 //BA.debugLineNum = 1148;BA.debugLine="casestatus.AddItem(\"stat2\", \"2 - Fixed\", BuildSim";
_casestatus.AddItem("stat2","2 - Fixed",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("ST2","","{NBSP}{NBSP}2 - Fixed")));
 //BA.debugLineNum = 1149;BA.debugLine="casestatus.AddItem(\"stat3\", \"3 - Implemented\", Bu";
_casestatus.AddItem("stat3","3 - Implemented",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("ST3","","{NBSP}{NBSP}3 - Implemented")));
 //BA.debugLineNum = 1150;BA.debugLine="casestatus.AddItem(\"stat4\", \"4 - More info needed";
_casestatus.AddItem("stat4","4 - More info needed",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("ST4","","{NBSP}{NBSP}4 - More info needed")));
 //BA.debugLineNum = 1151;BA.debugLine="casestatus.AddItem(\"stat5\", \"5 - Confirmed\", Buil";
_casestatus.AddItem("stat5","5 - Confirmed",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("ST5","","{NBSP}{NBSP}5 - Confirmed")));
 //BA.debugLineNum = 1152;BA.debugLine="casestatus.AddItem(\"stat6\", \"6 - On hold\", BuildS";
_casestatus.AddItem("stat6","6 - On hold",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("ST6","","{NBSP}{NBSP}6 - On hold")));
 //BA.debugLineNum = 1153;BA.debugLine="casestatus.AddItem(\"stat7\", \"7 - Expired, missing";
_casestatus.AddItem("stat7","7 - Expired, missing feedback",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("ST7","","{NBSP}{NBSP}7 - Expired, missing feedback")));
 //BA.debugLineNum = 1154;BA.debugLine="casestatus.AddItem(\"stat8\", \"8 - Closed, ask in f";
_casestatus.AddItem("stat8","8 - Closed, ask in forum",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("ST8","","{NBSP}{NBSP}8 - Closed, ask in forum")));
 //BA.debugLineNum = 1155;BA.debugLine="casestatus.AddItem(\"stat9\", \"9 - Solved, no actio";
_casestatus.AddItem("stat9","9 - Solved, no action",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("ST8","","{NBSP}{NBSP}9 - Solved, no action")));
 //BA.debugLineNum = 1157;BA.debugLine="inp.Content.CellR(1,1).AddComponent(casestatus)";
_inp.Content.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_casestatus));
 //BA.debugLineNum = 1159;BA.debugLine="Dim caseversion As ABMInput";
_caseversion = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 1160;BA.debugLine="caseversion.Initialize(page, \"caseversion\", ABM.I";
_caseversion.Initialize(_page,"caseversion",_abm.INPUT_TEXT,"Fixed version",__c.False,"lightblue");
 //BA.debugLineNum = 1161;BA.debugLine="inp.Content.CellR(0,2).AddComponent(caseversion)";
_inp.Content.CellR((int) (0),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_caseversion));
 //BA.debugLineNum = 1165;BA.debugLine="inp.Footer.AddRowsM(1,True,0,0, \"\").AddCells12(1,";
_inp.Footer.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 1166;BA.debugLine="inp.Footer.BuildGrid 'IMPORTANT once you loaded t";
_inp.Footer.BuildGrid();
 //BA.debugLineNum = 1169;BA.debugLine="Dim CancelBtn As ABMButton";
_cancelbtn = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 1170;BA.debugLine="CancelBtn.InitializeFlat(page, \"CancelBtn\", \"\", \"";
_cancelbtn.InitializeFlat(_page,"CancelBtn","","","CANCEL","transparent");
 //BA.debugLineNum = 1171;BA.debugLine="inp.Footer.Cell(1,1).AddComponent(CancelBtn)";
_inp.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_cancelbtn));
 //BA.debugLineNum = 1173;BA.debugLine="Dim SaveBtn As ABMButton";
_savebtn = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 1174;BA.debugLine="SaveBtn.InitializeFlat(page, \"SaveBtn\", \"\", \"\", \"";
_savebtn.InitializeFlat(_page,"SaveBtn","","","SAVE","transparent");
 //BA.debugLineNum = 1175;BA.debugLine="inp.Footer.Cell(1,1).AddComponent(SaveBtn)";
_inp.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_savebtn));
 //BA.debugLineNum = 1177;BA.debugLine="Dim AttBtn As ABMButton";
_attbtn = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 1178;BA.debugLine="AttBtn.InitializeFlat(page, \"AttBtn\", \"\", \"\", \"AT";
_attbtn.InitializeFlat(_page,"AttBtn","","","ATTACHMENT","transparent");
 //BA.debugLineNum = 1179;BA.debugLine="inp.Footer.Cell(1,1).AddComponent(AttBtn)";
_inp.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_attbtn));
 //BA.debugLineNum = 1181;BA.debugLine="Dim NoteBtn As ABMButton";
_notebtn = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 1182;BA.debugLine="NoteBtn.InitializeFlat(page, \"NoteBtn\", \"\", \"\", \"";
_notebtn.InitializeFlat(_page,"NoteBtn","","","ADD NOTE","transparent");
 //BA.debugLineNum = 1183;BA.debugLine="inp.Footer.Cell(1,1).AddComponent(NoteBtn)";
_inp.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_notebtn));
 //BA.debugLineNum = 1185;BA.debugLine="Return inp";
if (true) return _inp;
 //BA.debugLineNum = 1186;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMModalSheet  _buildmsgbox() throws Exception{
com.ab.abmaterial.ABMModalSheet _msgbox = null;
com.ab.abmaterial.ABMButton _msgok = null;
 //BA.debugLineNum = 1530;BA.debugLine="Sub BuildMsgBox() As ABMModalSheet";
 //BA.debugLineNum = 1531;BA.debugLine="Dim msgbox As ABMModalSheet";
_msgbox = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 1532;BA.debugLine="msgbox.Initialize(page, \"msgbox\", False, False, \"";
_msgbox.Initialize(_page,"msgbox",__c.False,__c.False,"");
 //BA.debugLineNum = 1533;BA.debugLine="msgbox.IsDismissible = False";
_msgbox.IsDismissible = __c.False;
 //BA.debugLineNum = 1535;BA.debugLine="msgbox.Content.AddRowsM(1, True,0,0, \"\").AddCells";
_msgbox.Content.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 1536;BA.debugLine="msgbox.Content.BuildGrid";
_msgbox.Content.BuildGrid();
 //BA.debugLineNum = 1539;BA.debugLine="msgbox.Content.CellR(0,1).AddComponent(ABMShared.";
_msgbox.Content.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","message")));
 //BA.debugLineNum = 1541;BA.debugLine="msgbox.Footer.AddRowsM(1,True,0,0, \"\").AddCellsOS";
_msgbox.Footer.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOS((int) (1),(int) (6),(int) (6),(int) (6),(int) (3),(int) (3),(int) (3),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (3),(int) (3),(int) (3),"");
 //BA.debugLineNum = 1542;BA.debugLine="msgbox.Footer.BuildGrid 'IMPORTANT once you loade";
_msgbox.Footer.BuildGrid();
 //BA.debugLineNum = 1545;BA.debugLine="Dim msgok As ABMButton";
_msgok = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 1546;BA.debugLine="msgok.InitializeFlat(page, \"msgok\", \"\", \"\", \"CLOS";
_msgok.InitializeFlat(_page,"msgok","","","CLOSE","transparent");
 //BA.debugLineNum = 1547;BA.debugLine="msgbox.Footer.Cell(1,1).AddComponent(msgok)";
_msgbox.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_msgok));
 //BA.debugLineNum = 1549;BA.debugLine="Return msgbox";
if (true) return _msgbox;
 //BA.debugLineNum = 1550;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMModalSheet  _buildmsgboxyesno() throws Exception{
com.ab.abmaterial.ABMModalSheet _msg = null;
com.ab.abmaterial.ABMButton _msgyes = null;
com.ab.abmaterial.ABMButton _msgno = null;
 //BA.debugLineNum = 1450;BA.debugLine="Sub BuildMsgBoxYesNo() As ABMModalSheet";
 //BA.debugLineNum = 1451;BA.debugLine="Dim msg As ABMModalSheet";
_msg = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 1452;BA.debugLine="msg.Initialize(page, \"msg\", False, False, \"\")";
_msg.Initialize(_page,"msg",__c.False,__c.False,"");
 //BA.debugLineNum = 1453;BA.debugLine="msg.IsDismissible = False";
_msg.IsDismissible = __c.False;
 //BA.debugLineNum = 1455;BA.debugLine="msg.Content.AddRowsM(1, True,0,0, \"\").AddCells12(";
_msg.Content.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 1456;BA.debugLine="msg.Content.BuildGrid";
_msg.Content.BuildGrid();
 //BA.debugLineNum = 1459;BA.debugLine="msg.Content.CellR(0,1).AddComponent(ABMShared.Bui";
_msg.Content.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Are you sure you want to delete this case?")));
 //BA.debugLineNum = 1461;BA.debugLine="msg.Footer.AddRowsM(1,True,0,0, \"\").AddCellsOS(1,";
_msg.Footer.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOS((int) (1),(int) (6),(int) (6),(int) (6),(int) (3),(int) (3),(int) (3),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (3),(int) (3),(int) (3),"");
 //BA.debugLineNum = 1462;BA.debugLine="msg.Footer.BuildGrid 'IMPORTANT once you loaded t";
_msg.Footer.BuildGrid();
 //BA.debugLineNum = 1465;BA.debugLine="Dim msgyes As ABMButton";
_msgyes = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 1466;BA.debugLine="msgyes.InitializeFlat(page, \"msgyes\", \"\", \"\", \"YE";
_msgyes.InitializeFlat(_page,"msgyes","","","YES","transparent");
 //BA.debugLineNum = 1467;BA.debugLine="msg.Footer.Cell(1,1).AddComponent(msgyes)";
_msg.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_msgyes));
 //BA.debugLineNum = 1469;BA.debugLine="Dim msgno As ABMButton";
_msgno = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 1470;BA.debugLine="msgno.InitializeFlat(page, \"msgno\", \"\", \"\", \"NO\",";
_msgno.InitializeFlat(_page,"msgno","","","NO","transparent");
 //BA.debugLineNum = 1471;BA.debugLine="msg.Footer.Cell(1,2).AddComponent(msgno)";
_msg.Footer.Cell((int) (1),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_msgno));
 //BA.debugLineNum = 1473;BA.debugLine="Return msg";
if (true) return _msg;
 //BA.debugLineNum = 1474;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMContainer  _buildnotecontainer(String _casenoteid,String _description,String _creator,String _creationdate,int _creatorid) throws Exception{
com.ab.abmaterial.ABMContainer _casenote = null;
com.ab.abmaterial.ABMLabel _lblcreationdate = null;
com.ab.abmaterial.ABMLabel _lblcreator = null;
com.ab.abmaterial.ABMInput _casenotedescription = null;
com.ab.abmaterial.ABMButton _btnnoteedit = null;
com.ab.abmaterial.ABMButton _btnnotedelete = null;
 //BA.debugLineNum = 1559;BA.debugLine="Sub BuildNoteContainer(CaseNoteID As String, Descr";
 //BA.debugLineNum = 1561;BA.debugLine="Dim caseNote As ABMContainer";
_casenote = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 1562;BA.debugLine="caseNote.Initialize(page, CaseNoteID, \"notetheme\"";
_casenote.Initialize(_page,_casenoteid,"notetheme");
 //BA.debugLineNum = 1564;BA.debugLine="caseNote.AddRowsM(1, True, 10,0,\"\").AddCellsOS(2,";
_casenote.AddRowsM((int) (1),__c.True,(int) (10),(int) (0),"").AddCellsOS((int) (2),(int) (0),(int) (0),(int) (0),(int) (6),(int) (6),(int) (6),"");
 //BA.debugLineNum = 1565;BA.debugLine="caseNote.AddRowsM(2, True, 0,0,\"\").AddCells12(1,";
_casenote.AddRowsM((int) (2),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 1566;BA.debugLine="caseNote.AddRows(2, True,\"\").AddCells12(1, \"\")";
_casenote.AddRows((int) (2),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 1568;BA.debugLine="caseNote.BuildGrid";
_casenote.BuildGrid();
 //BA.debugLineNum = 1570;BA.debugLine="Dim lblCreationDate As ABMLabel";
_lblcreationdate = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 1571;BA.debugLine="lblCreationDate.Initialize(page, \"lblCreationDate";
_lblcreationdate.Initialize(_page,"lblCreationDate",_creationdate,_abm.SIZE_PARAGRAPH,__c.False,"lightblue");
 //BA.debugLineNum = 1572;BA.debugLine="caseNote.CellR(0,1).AddComponent(lblCreationDate)";
_casenote.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblcreationdate));
 //BA.debugLineNum = 1574;BA.debugLine="Dim lblCreator As ABMLabel";
_lblcreator = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 1575;BA.debugLine="lblCreator.Initialize(page, \"lblCreator\", Creator";
_lblcreator.Initialize(_page,"lblCreator",_creator,_abm.SIZE_PARAGRAPH,__c.False,"lightblue");
 //BA.debugLineNum = 1576;BA.debugLine="caseNote.CellR(0,2).AddComponent(lblCreator)";
_casenote.CellR((int) (0),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblcreator));
 //BA.debugLineNum = 1578;BA.debugLine="Dim casenotedescription As ABMInput";
_casenotedescription = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 1579;BA.debugLine="casenotedescription.Initialize(page, \"casenotedes";
_casenotedescription.Initialize(_page,"casenotedescription",_abm.INPUT_TEXT,"Description",__c.True,"lightblue");
 //BA.debugLineNum = 1580;BA.debugLine="casenotedescription.Enabled = False";
_casenotedescription.Enabled = __c.False;
 //BA.debugLineNum = 1581;BA.debugLine="casenotedescription.Text = Description";
_casenotedescription.setText(_description);
 //BA.debugLineNum = 1582;BA.debugLine="caseNote.CellR(1,1).AddComponent(casenotedescript";
_casenote.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_casenotedescription));
 //BA.debugLineNum = 1584;BA.debugLine="If UserID = CreatorID Or UserType = \"1\" Then ' ad";
if (_userid==_creatorid || (_usertype).equals("1")) { 
 //BA.debugLineNum = 1585;BA.debugLine="Dim btnNoteEdit As ABMButton";
_btnnoteedit = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 1586;BA.debugLine="btnNoteEdit.InitializeFloating(page, CaseNoteID,";
_btnnoteedit.InitializeFloating(_page,_casenoteid,"mdi-editor-mode-edit","");
 //BA.debugLineNum = 1587;BA.debugLine="caseNote.Cell(3,1).AddArrayComponent(btnNoteEdit";
_casenote.Cell((int) (3),(int) (1)).AddArrayComponent((com.ab.abmaterial.ABMComponent)(_btnnoteedit),"btnNoteEdit");
 };
 //BA.debugLineNum = 1590;BA.debugLine="If UserType = \"1\" Then";
if ((_usertype).equals("1")) { 
 //BA.debugLineNum = 1591;BA.debugLine="Dim btnNoteDelete As ABMButton";
_btnnotedelete = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 1592;BA.debugLine="btnNoteDelete.InitializeFloating(page, CaseNoteI";
_btnnotedelete.InitializeFloating(_page,_casenoteid,"mdi-action-delete","");
 //BA.debugLineNum = 1593;BA.debugLine="caseNote.Cell(3,1).AddArrayComponent(btnNoteDele";
_casenote.Cell((int) (3),(int) (1)).AddArrayComponent((com.ab.abmaterial.ABMComponent)(_btnnotedelete),"btnNoteDelete");
 };
 //BA.debugLineNum = 1596;BA.debugLine="Return caseNote";
if (true) return _casenote;
 //BA.debugLineNum = 1597;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMModalSheet  _buildnoteinputsheet() throws Exception{
com.ab.abmaterial.ABMModalSheet _inpnote = null;
com.ab.abmaterial.ABMInput _notedescription = null;
com.ab.abmaterial.ABMButton _btnnotecancel = null;
com.ab.abmaterial.ABMButton _btnnotesave = null;
 //BA.debugLineNum = 1638;BA.debugLine="Sub BuildNoteInputSheet() As ABMModalSheet";
 //BA.debugLineNum = 1639;BA.debugLine="Dim inpNote As ABMModalSheet";
_inpnote = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 1640;BA.debugLine="inpNote.Initialize(page, \"inpNote\", False, False,";
_inpnote.Initialize(_page,"inpNote",__c.False,__c.False,"");
 //BA.debugLineNum = 1641;BA.debugLine="inpNote.IsDismissible = False";
_inpnote.IsDismissible = __c.False;
 //BA.debugLineNum = 1643;BA.debugLine="inpNote.Content.AddRowsM(2, True,0,0, \"\").AddCell";
_inpnote.Content.AddRowsM((int) (2),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 1644;BA.debugLine="inpNote.Content.BuildGrid";
_inpnote.Content.BuildGrid();
 //BA.debugLineNum = 1647;BA.debugLine="inpNote.Content.CellR(0,1).AddComponent(ABMShared";
_inpnote.Content.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraphbqwithzdepth(_page,"par1","Enter the information for this note.")));
 //BA.debugLineNum = 1649;BA.debugLine="Dim Notedescription As ABMInput";
_notedescription = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 1650;BA.debugLine="Notedescription.Initialize(page, \"notedescription";
_notedescription.Initialize(_page,"notedescription",_abm.INPUT_TEXT,"Description",__c.True,"lightblue");
 //BA.debugLineNum = 1651;BA.debugLine="inpNote.Content.CellR(1,1).AddComponent(Notedescr";
_inpnote.Content.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_notedescription));
 //BA.debugLineNum = 1653;BA.debugLine="inpNote.Footer.AddRowsM(1,True,0,0, \"\").AddCells1";
_inpnote.Footer.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 1654;BA.debugLine="inpNote.Footer.BuildGrid 'IMPORTANT once you load";
_inpnote.Footer.BuildGrid();
 //BA.debugLineNum = 1657;BA.debugLine="Dim btnNoteCancel As ABMButton";
_btnnotecancel = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 1658;BA.debugLine="btnNoteCancel.InitializeFlat(page, \"btnNoteCancel";
_btnnotecancel.InitializeFlat(_page,"btnNoteCancel","","","CANCEL","transparent");
 //BA.debugLineNum = 1659;BA.debugLine="inpNote.Footer.Cell(1,1).AddComponent(btnNoteCanc";
_inpnote.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnnotecancel));
 //BA.debugLineNum = 1661;BA.debugLine="Dim BtnNoteSave As ABMButton";
_btnnotesave = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 1662;BA.debugLine="BtnNoteSave.InitializeFlat(page, \"btnNoteSave\", \"";
_btnnotesave.InitializeFlat(_page,"btnNoteSave","","","SAVE","transparent");
 //BA.debugLineNum = 1663;BA.debugLine="inpNote.Footer.Cell(1,1).AddComponent(BtnNoteSave";
_inpnote.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnnotesave));
 //BA.debugLineNum = 1665;BA.debugLine="Return inpNote";
if (true) return _inpnote;
 //BA.debugLineNum = 1666;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMLabel  _buildsimpleitem(String _id,String _icon,String _title) throws Exception{
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 1188;BA.debugLine="Sub BuildSimpleItem(id As String, icon As String,";
 //BA.debugLineNum = 1189;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 1190;BA.debugLine="If icon <> \"\" Then";
if ((_icon).equals("") == false) { 
 //BA.debugLineNum = 1191;BA.debugLine="lbl.Initialize(page, id, Title, ABM.SIZE_H6, Tru";
_lbl.Initialize(_page,_id,_title,_abm.SIZE_H6,__c.True,"header");
 }else {
 //BA.debugLineNum = 1193;BA.debugLine="lbl.Initialize(page, id, Title, ABM.SIZE_H6, Tru";
_lbl.Initialize(_page,_id,_title,_abm.SIZE_H6,__c.True,"");
 };
 //BA.debugLineNum = 1195;BA.debugLine="lbl.VerticalAlign = True";
_lbl.VerticalAlign = __c.True;
 //BA.debugLineNum = 1196;BA.debugLine="lbl.IconName = icon";
_lbl.IconName = _icon;
 //BA.debugLineNum = 1197;BA.debugLine="Return lbl";
if (true) return _lbl;
 //BA.debugLineNum = 1198;BA.debugLine="End Sub";
return null;
}
public String  _cancelbtn_clicked(String _target) throws Exception{
 //BA.debugLineNum = 1349;BA.debugLine="Sub CancelBtn_Clicked(Target As String)";
 //BA.debugLineNum = 1350;BA.debugLine="page.CloseModalSheet(\"inp\")";
_page.CloseModalSheet("inp");
 //BA.debugLineNum = 1351;BA.debugLine="End Sub";
return "";
}
public boolean  _checkinput() throws Exception{
com.ab.abmaterial.ABMModalSheet _inp = null;
com.ab.abmaterial.ABMCombo _casetype = null;
com.ab.abmaterial.ABMInput _casesummary = null;
com.ab.abmaterial.ABMInput _casedescription = null;
 //BA.debugLineNum = 1337;BA.debugLine="Sub CheckInput() As Boolean";
 //BA.debugLineNum = 1338;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp\")";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 1340;BA.debugLine="Dim casetype As ABMCombo = inp.Content.Component(";
_casetype = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("casetype"));
 //BA.debugLineNum = 1341;BA.debugLine="Dim casesummary As ABMInput = inp.Content.Compone";
_casesummary = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("casesummary"));
 //BA.debugLineNum = 1342;BA.debugLine="Dim casedescription As ABMInput = inp.Content.Com";
_casedescription = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("casedescription"));
 //BA.debugLineNum = 1343;BA.debugLine="If casetype.GetActiveItemId = \"\" Or casesummary.T";
if ((_casetype.GetActiveItemId()).equals("") || (_casesummary.getText()).equals("") || (_casedescription.getText()).equals("")) { 
 //BA.debugLineNum = 1344;BA.debugLine="Return False";
if (true) return __c.False;
 };
 //BA.debugLineNum = 1346;BA.debugLine="Return True";
if (true) return __c.True;
 //BA.debugLineNum = 1347;BA.debugLine="End Sub";
return false;
}
public String  _chip_closed(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _inp = null;
com.ab.abmaterial.ABMChip _ch = null;
int _inttag = 0;
 //BA.debugLineNum = 1051;BA.debugLine="Sub Chip_Closed(Target As String)";
 //BA.debugLineNum = 1052;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp\")";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 1053;BA.debugLine="Dim ch As ABMChip = inp.Content.Component(Target)";
_ch = (com.ab.abmaterial.ABMChip)(_inp.Content.Component(_target));
 //BA.debugLineNum = 1054;BA.debugLine="Dim intTag As Int = ch.Tag";
_inttag = (int)(Double.parseDouble(_ch.Tag));
 //BA.debugLineNum = 1055;BA.debugLine="RemoveAttachments.put(intTag, ch.Tag)";
_removeattachments.Put((Object)(_inttag),(Object)(_ch.Tag));
 //BA.debugLineNum = 1056;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"OverviewCasesPage\"";
_name = "OverviewCasesPage";
 //BA.debugLineNum = 14;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 15;BA.debugLine="Dim ActiveCaseId As Int";
_activecaseid = 0;
 //BA.debugLineNum = 16;BA.debugLine="Dim ActiveCaseNumber As String";
_activecasenumber = "";
 //BA.debugLineNum = 17;BA.debugLine="Dim ActiveCaseUserID As Int";
_activecaseuserid = 0;
 //BA.debugLineNum = 19;BA.debugLine="Dim ActiveCaseNoteID As Int";
_activecasenoteid = 0;
 //BA.debugLineNum = 20;BA.debugLine="Dim Filter As String";
_filter = "";
 //BA.debugLineNum = 21;BA.debugLine="Dim FilterCount As String";
_filtercount = "";
 //BA.debugLineNum = 22;BA.debugLine="Dim LastSort As String = \" ORDER BY CaseCreationD";
_lastsort = " ORDER BY CaseCreationDate DESC, CaseId ";
 //BA.debugLineNum = 25;BA.debugLine="Dim UserType As String";
_usertype = "";
 //BA.debugLineNum = 26;BA.debugLine="Dim UserID As Int";
_userid = 0;
 //BA.debugLineNum = 27;BA.debugLine="Dim UserName As String";
_username = "";
 //BA.debugLineNum = 28;BA.debugLine="Dim Attachments As Map";
_attachments = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 29;BA.debugLine="Dim RemoveAttachments As Map";
_removeattachments = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 30;BA.debugLine="Dim TypeDelete As String";
_typedelete = "";
 //BA.debugLineNum = 32;BA.debugLine="Public DownloadFolder As String = \"/www/\" & ABMSh";
_downloadfolder = "/www/"+_abmshared._appname+"/uploads/";
 //BA.debugLineNum = 33;BA.debugLine="Public DownloadMaxSize As String = 500*1024";
_downloadmaxsize = BA.NumberToString(500*1024);
 //BA.debugLineNum = 34;BA.debugLine="Public MaxRows As Int = 10";
_maxrows = (int) (10);
 //BA.debugLineNum = 35;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public String  _dosearch() throws Exception{
com.ab.abmaterial.ABMInput _searchcase = null;
com.ab.abmaterial.ABMCombo _casestatussearch = null;
String _extra = "";
 //BA.debugLineNum = 673;BA.debugLine="Sub DoSearch()";
 //BA.debugLineNum = 674;BA.debugLine="Dim searchCase As ABMInput = page.Component(\"sear";
_searchcase = (com.ab.abmaterial.ABMInput)(_page.Component("searchCase"));
 //BA.debugLineNum = 675;BA.debugLine="Dim casestatussearch As ABMCombo = page.Component";
_casestatussearch = (com.ab.abmaterial.ABMCombo)(_page.Component("CaseStatusSearch"));
 //BA.debugLineNum = 676;BA.debugLine="FilterCount=\"\";";
_filtercount = "";
 //BA.debugLineNum = 677;BA.debugLine="Filter = searchCase.Text";
_filter = _searchcase.getText();
 //BA.debugLineNum = 678;BA.debugLine="Dim extra As String";
_extra = "";
 //BA.debugLineNum = 679;BA.debugLine="Select Case casestatussearch.GetActiveItemId";
switch (BA.switchObjectToInt(_casestatussearch.GetActiveItemId(),"statsearch","statsearch0","statsearch1","statsearch2","statsearch3","statsearch4","statsearch5","statsearch6","statsearch7","statsearch8","statsearch9","statsearchmycases")) {
case 0: {
 //BA.debugLineNum = 681;BA.debugLine="extra = \"\"";
_extra = "";
 break; }
case 1: {
 //BA.debugLineNum = 683;BA.debugLine="extra = \"CaseStatus=0 \"";
_extra = "CaseStatus=0 ";
 break; }
case 2: {
 //BA.debugLineNum = 685;BA.debugLine="extra = \"CaseStatus=1 \"";
_extra = "CaseStatus=1 ";
 break; }
case 3: {
 //BA.debugLineNum = 687;BA.debugLine="extra = \"CaseStatus=2 \"";
_extra = "CaseStatus=2 ";
 break; }
case 4: {
 //BA.debugLineNum = 689;BA.debugLine="extra = \"CaseStatus=3 \"";
_extra = "CaseStatus=3 ";
 break; }
case 5: {
 //BA.debugLineNum = 691;BA.debugLine="extra = \"CaseStatus=4 \"";
_extra = "CaseStatus=4 ";
 break; }
case 6: {
 //BA.debugLineNum = 693;BA.debugLine="extra = \"CaseStatus=5 \"";
_extra = "CaseStatus=5 ";
 break; }
case 7: {
 //BA.debugLineNum = 695;BA.debugLine="extra = \"CaseStatus=6 \"";
_extra = "CaseStatus=6 ";
 break; }
case 8: {
 //BA.debugLineNum = 697;BA.debugLine="extra = \"CaseStatus=7 \"";
_extra = "CaseStatus=7 ";
 break; }
case 9: {
 //BA.debugLineNum = 699;BA.debugLine="extra = \"CaseStatus=8 \"";
_extra = "CaseStatus=8 ";
 break; }
case 10: {
 //BA.debugLineNum = 701;BA.debugLine="extra = \"CaseStatus=9 \"";
_extra = "CaseStatus=9 ";
 break; }
case 11: {
 //BA.debugLineNum = 703;BA.debugLine="extra = \"CaseUserId=\" & UserID & \" \"";
_extra = "CaseUserId="+BA.NumberToString(_userid)+" ";
 break; }
}
;
 //BA.debugLineNum = 705;BA.debugLine="If Filter <> \"\" Then";
if ((_filter).equals("") == false) { 
 //BA.debugLineNum = 706;BA.debugLine="If extra <> \"\" Then";
if ((_extra).equals("") == false) { 
 //BA.debugLineNum = 707;BA.debugLine="FilterCount = \" WHERE (\" & extra & \" AND CaseSu";
_filtercount = " WHERE ("+_extra+" AND CaseSummary LIKE '%"+_filter+"%') ";
 //BA.debugLineNum = 708;BA.debugLine="Filter = \" HAVING (\" & extra & \" AND CaseSummar";
_filter = " HAVING ("+_extra+" AND CaseSummary LIKE '%"+_filter+"%') ";
 }else {
 //BA.debugLineNum = 710;BA.debugLine="FilterCount = \" WHERE (CaseSummary LIKE '%\" & F";
_filtercount = " WHERE (CaseSummary LIKE '%"+_filter+"%') ";
 //BA.debugLineNum = 711;BA.debugLine="Filter = \" HAVING (CaseSummary LIKE '%\" & Filte";
_filter = " HAVING (CaseSummary LIKE '%"+_filter+"%') ";
 };
 }else {
 //BA.debugLineNum = 714;BA.debugLine="If extra <> \"\" Then";
if ((_extra).equals("") == false) { 
 //BA.debugLineNum = 715;BA.debugLine="FilterCount = \" WHERE (\" & extra & \") \"";
_filtercount = " WHERE ("+_extra+") ";
 //BA.debugLineNum = 716;BA.debugLine="Filter = \" HAVING (\" & extra & \") \"";
_filter = " HAVING ("+_extra+") ";
 };
 };
 //BA.debugLineNum = 720;BA.debugLine="LoadCases(1)";
_loadcases((int) (1));
 //BA.debugLineNum = 721;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
com.ab.abmaterial.ABMActionButton _addcasebtn = null;
 //BA.debugLineNum = 39;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 42;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 43;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 46;BA.debugLine="theme.AddTableTheme(\"tbltheme\")";
_theme.AddTableTheme("tbltheme");
 //BA.debugLineNum = 47;BA.debugLine="theme.Table(\"tbltheme\").ZDepth = ABM.ZDEPTH_1";
_theme.Table("tbltheme").ZDepth = _abm.ZDEPTH_1;
 //BA.debugLineNum = 49;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"bg\")";
_theme.Table("tbltheme").AddCellTheme("bg");
 //BA.debugLineNum = 50;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bg\").BackColor = AB";
_theme.Table("tbltheme").Cell("bg").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 51;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bg\").ForeColor = AB";
_theme.Table("tbltheme").Cell("bg").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 53;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"bgr\")";
_theme.Table("tbltheme").AddCellTheme("bgr");
 //BA.debugLineNum = 54;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bgr\").BackColor = A";
_theme.Table("tbltheme").Cell("bgr").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 55;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bgr\").ForeColor = A";
_theme.Table("tbltheme").Cell("bgr").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 56;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bgr\").Align = ABM.T";
_theme.Table("tbltheme").Cell("bgr").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 58;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"bgc\")";
_theme.Table("tbltheme").AddCellTheme("bgc");
 //BA.debugLineNum = 59;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bgc\").BackColor = A";
_theme.Table("tbltheme").Cell("bgc").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 60;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bgc\").ForeColor = A";
_theme.Table("tbltheme").Cell("bgc").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 61;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"bgc\").Align = ABM.T";
_theme.Table("tbltheme").Cell("bgc").Align = _abm.TABLECELL_HORIZONTALALIGN_CENTER;
 //BA.debugLineNum = 63;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"nocolor\")";
_theme.Table("tbltheme").AddCellTheme("nocolor");
 //BA.debugLineNum = 64;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"nocolor\").ActiveBac";
_theme.Table("tbltheme").Cell("nocolor").ActiveBackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 65;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"nocolor\").ActiveBac";
_theme.Table("tbltheme").Cell("nocolor").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 67;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"positive\")";
_theme.Table("tbltheme").AddCellTheme("positive");
 //BA.debugLineNum = 68;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"positive\").BackColo";
_theme.Table("tbltheme").Cell("positive").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 69;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"positive\").BackColo";
_theme.Table("tbltheme").Cell("positive").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 70;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"positive\").ActiveBa";
_theme.Table("tbltheme").Cell("positive").ActiveBackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 71;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"positive\").ActiveBa";
_theme.Table("tbltheme").Cell("positive").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 74;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"caseorange\"";
_theme.Table("tbltheme").AddCellTheme("caseorange");
 //BA.debugLineNum = 75;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"caseorange\").BackCo";
_theme.Table("tbltheme").Cell("caseorange").BackColor = _abm.COLOR_ORANGE;
 //BA.debugLineNum = 76;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"caseorange\").BackCo";
_theme.Table("tbltheme").Cell("caseorange").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 77;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"caseorange\").Active";
_theme.Table("tbltheme").Cell("caseorange").ActiveBackColor = _abm.COLOR_ORANGE;
 //BA.debugLineNum = 78;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"caseorange\").Active";
_theme.Table("tbltheme").Cell("caseorange").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 80;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"casegrey\")";
_theme.Table("tbltheme").AddCellTheme("casegrey");
 //BA.debugLineNum = 81;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"casegrey\").BackColo";
_theme.Table("tbltheme").Cell("casegrey").BackColor = _abm.COLOR_GREY;
 //BA.debugLineNum = 82;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"casegrey\").BackColo";
_theme.Table("tbltheme").Cell("casegrey").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 83;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"casegrey\").ActiveBa";
_theme.Table("tbltheme").Cell("casegrey").ActiveBackColor = _abm.COLOR_GREY;
 //BA.debugLineNum = 84;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"casegrey\").ActiveBa";
_theme.Table("tbltheme").Cell("casegrey").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 86;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"caseyellow\"";
_theme.Table("tbltheme").AddCellTheme("caseyellow");
 //BA.debugLineNum = 87;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"caseyellow\").BackCo";
_theme.Table("tbltheme").Cell("caseyellow").BackColor = _abm.COLOR_YELLOW;
 //BA.debugLineNum = 88;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"caseyellow\").BackCo";
_theme.Table("tbltheme").Cell("caseyellow").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 89;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"caseyellow\").Active";
_theme.Table("tbltheme").Cell("caseyellow").ActiveBackColor = _abm.COLOR_YELLOW;
 //BA.debugLineNum = 90;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"caseyellow\").Active";
_theme.Table("tbltheme").Cell("caseyellow").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 92;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"negative\")";
_theme.Table("tbltheme").AddCellTheme("negative");
 //BA.debugLineNum = 93;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"negative\").BackColo";
_theme.Table("tbltheme").Cell("negative").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 94;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"negative\").BackColo";
_theme.Table("tbltheme").Cell("negative").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 95;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"negative\").ActiveBa";
_theme.Table("tbltheme").Cell("negative").ActiveBackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 96;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"negative\").ActiveBa";
_theme.Table("tbltheme").Cell("negative").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 99;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"unread\")";
_theme.Table("tbltheme").AddCellTheme("unread");
 //BA.debugLineNum = 100;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"unread\").ActiveBack";
_theme.Table("tbltheme").Cell("unread").ActiveBackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 101;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"unread\").ActiveBack";
_theme.Table("tbltheme").Cell("unread").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 102;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"unread\").BorderColo";
_theme.Table("tbltheme").Cell("unread").BorderColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 103;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"unread\").BorderWidt";
_theme.Table("tbltheme").Cell("unread").BorderWidth = (int) (1);
 //BA.debugLineNum = 104;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"unread\").Align = AB";
_theme.Table("tbltheme").Cell("unread").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 106;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"points\")";
_theme.Table("tbltheme").AddCellTheme("points");
 //BA.debugLineNum = 107;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"points\").ActiveBack";
_theme.Table("tbltheme").Cell("points").ActiveBackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 108;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"points\").ActiveBack";
_theme.Table("tbltheme").Cell("points").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 109;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"points\").Align = AB";
_theme.Table("tbltheme").Cell("points").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 111;BA.debugLine="theme.Table(\"tbltheme\").AddCellTheme(\"openedit\")";
_theme.Table("tbltheme").AddCellTheme("openedit");
 //BA.debugLineNum = 112;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"openedit\").ActiveBa";
_theme.Table("tbltheme").Cell("openedit").ActiveBackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 113;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"openedit\").ActiveBa";
_theme.Table("tbltheme").Cell("openedit").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 114;BA.debugLine="theme.Table(\"tbltheme\").Cell(\"openedit\").Align =";
_theme.Table("tbltheme").Cell("openedit").Align = _abm.TABLECELL_HORIZONTALALIGN_CENTER;
 //BA.debugLineNum = 117;BA.debugLine="theme.AddButtonTheme(\"bigblue\")";
_theme.AddButtonTheme("bigblue");
 //BA.debugLineNum = 118;BA.debugLine="theme.Button(\"bigblue\").BackColor = ABM.COLOR_LIG";
_theme.Button("bigblue").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 121;BA.debugLine="theme.AddContainerTheme(\"modalcontent\")";
_theme.AddContainerTheme("modalcontent");
 //BA.debugLineNum = 122;BA.debugLine="theme.Container(\"modalcontent\").BackColor = ABM.C";
_theme.Container("modalcontent").BackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 125;BA.debugLine="theme.AddContainerTheme(\"modalfooter\")";
_theme.AddContainerTheme("modalfooter");
 //BA.debugLineNum = 126;BA.debugLine="theme.Container(\"modalfooter\").BackColor = ABM.CO";
_theme.Container("modalfooter").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 129;BA.debugLine="theme.AddChipTheme(\"chip\")";
_theme.AddChipTheme("chip");
 //BA.debugLineNum = 130;BA.debugLine="theme.Chip(\"chip\").BackColorIntensity = ABM.INTEN";
_theme.Chip("chip").BackColorIntensity = _abm.INTENSITY_LIGHTEN4;
 //BA.debugLineNum = 133;BA.debugLine="theme.AddContainerTheme(\"notetheme\")";
_theme.AddContainerTheme("notetheme");
 //BA.debugLineNum = 134;BA.debugLine="theme.Container(\"notetheme\").BackColor = ABM.COLO";
_theme.Container("notetheme").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 135;BA.debugLine="theme.Container(\"notetheme\").BackColorIntensity =";
_theme.Container("notetheme").BackColorIntensity = _abm.INTENSITY_LIGHTEN5;
 //BA.debugLineNum = 136;BA.debugLine="theme.Container(\"notetheme\").ZDepth = ABM.ZDEPTH_";
_theme.Container("notetheme").ZDepth = _abm.ZDEPTH_1;
 //BA.debugLineNum = 139;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 140;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 144;BA.debugLine="page.NeedsChips = True";
_page.NeedsChips = __c.True;
 //BA.debugLineNum = 145;BA.debugLine="page.PageTitle = \"ABMFeedback\"";
_page.PageTitle = "ABMFeedback";
 //BA.debugLineNum = 146;BA.debugLine="page.PageDescription = \"Feedback App for the ABMa";
_page.PageDescription = "Feedback App for the ABMaterial Framework for B4J";
 //BA.debugLineNum = 147;BA.debugLine="page.PageHTMLName = \"index.html\"";
_page.PageHTMLName = "index.html";
 //BA.debugLineNum = 148;BA.debugLine="page.PageKeywords = \"\"";
_page.PageKeywords = "";
 //BA.debugLineNum = 149;BA.debugLine="page.PageSiteMapPriority = \"\"";
_page.PageSiteMapPriority = "";
 //BA.debugLineNum = 150;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_YEAR";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_YEARLY;
 //BA.debugLineNum = 151;BA.debugLine="page.DisableBackButton = True";
_page.DisableBackButton = __c.True;
 //BA.debugLineNum = 152;BA.debugLine="page.ShowConnectedIndicator = True";
_page.ShowConnectedIndicator = __c.True;
 //BA.debugLineNum = 154;BA.debugLine="ABMShared.BuildNavigationBar(page, \"Overview Case";
_abmshared._buildnavigationbar(_page,"Overview Cases","../images/logo.png","Cases","","");
 //BA.debugLineNum = 157;BA.debugLine="page.AddRowsM(2,True,0,0, \"\").AddCells12(1,\"\")";
_page.AddRowsM((int) (2),__c.True,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 158;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,6,6,8";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (6),(int) (6),(int) (8),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (4),(int) (4),(int) (2),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (2),(int) (2),(int) (1),(int) (14),(int) (0),(int) (0),(int) (0),"");
 //BA.debugLineNum = 159;BA.debugLine="page.AddRows(4,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (4),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 160;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 163;BA.debugLine="page.AddModalSheetTemplate(BuildInputSheet)";
_page.AddModalSheetTemplate(_buildinputsheet());
 //BA.debugLineNum = 165;BA.debugLine="page.AddModalSheetTemplate(BuildMsgBoxYesNo)";
_page.AddModalSheetTemplate(_buildmsgboxyesno());
 //BA.debugLineNum = 167;BA.debugLine="page.AddModalSheetTemplate(BuildMsgBox)";
_page.AddModalSheetTemplate(_buildmsgbox());
 //BA.debugLineNum = 169;BA.debugLine="page.AddModalSheetTemplate(BuildAttachmentSheet)";
_page.AddModalSheetTemplate(_buildattachmentsheet());
 //BA.debugLineNum = 171;BA.debugLine="page.AddModalSheetTemplate(BuildNoteInputSheet)";
_page.AddModalSheetTemplate(_buildnoteinputsheet());
 //BA.debugLineNum = 174;BA.debugLine="Dim AddCaseBtn As ABMActionButton";
_addcasebtn = new com.ab.abmaterial.ABMActionButton();
 //BA.debugLineNum = 175;BA.debugLine="AddCaseBtn.Initialize(page, \"AddCaseBtn\", \"mdi-co";
_addcasebtn.Initialize(_page,"AddCaseBtn","mdi-content-add","","bigblue");
 //BA.debugLineNum = 176;BA.debugLine="AddCaseBtn.MainButton.Size = ABM.BUTTONSIZE_LARGE";
_addcasebtn.MainButton().Size = _abm.BUTTONSIZE_LARGE;
 //BA.debugLineNum = 179;BA.debugLine="page.AddActionButton(AddCaseBtn)";
_page.AddActionButton(_addcasebtn);
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return "";
}
public String  _loadcases(int _frompage) throws Exception{
com.ab.abmaterial.ABMTable _tblcases = null;
anywheresoftware.b4j.objects.SQL _sql = null;
String _sql_str = "";
int _numcases = 0;
anywheresoftware.b4a.objects.collections.List _cases = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _tblfields = null;
anywheresoftware.b4a.objects.collections.List _rcellvalues = null;
anywheresoftware.b4a.objects.collections.List _rcellthemes = null;
String _numnotes = "";
String _numnotestheme = "";
com.ab.abmaterial.ABMButton _btnedit = null;
com.ab.abmaterial.ABMButton _btndelete = null;
com.ab.abmaterial.ABMPagination _pagination = null;
 //BA.debugLineNum = 392;BA.debugLine="private Sub LoadCases(fromPage As Int)";
 //BA.debugLineNum = 393;BA.debugLine="Dim tblCases As ABMTable = page.Component(\"tblCas";
_tblcases = (com.ab.abmaterial.ABMTable)(_page.Component("tblCases"));
 //BA.debugLineNum = 395;BA.debugLine="If UserType = \"1\" Then ' if andministrator, show";
if ((_usertype).equals("1")) { 
 //BA.debugLineNum = 396;BA.debugLine="tblCases.SetColumnVisible(Array As Boolean(False";
_tblcases.SetColumnVisible(anywheresoftware.b4a.keywords.Common.ArrayToList(new boolean[]{__c.False,__c.True,__c.True,__c.True,__c.True,__c.True,__c.True,__c.True,__c.True,__c.True}));
 }else {
 //BA.debugLineNum = 398;BA.debugLine="tblCases.SetColumnVisible(Array As Boolean(False";
_tblcases.SetColumnVisible(anywheresoftware.b4a.keywords.Common.ArrayToList(new boolean[]{__c.False,__c.True,__c.True,__c.True,__c.True,__c.True,__c.True,__c.True,__c.True,__c.False}));
 };
 //BA.debugLineNum = 401;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 403;BA.debugLine="Dim SQL_str As String";
_sql_str = "";
 //BA.debugLineNum = 404;BA.debugLine="SQL_str = \"SELECT Count(CaseId) as IDS FROM cases";
_sql_str = "SELECT Count(CaseId) as IDS FROM cases "+_filtercount;
 //BA.debugLineNum = 405;BA.debugLine="Dim numcases As Int = DBM.SQLSelectSingleResult(S";
_numcases = (int)(Double.parseDouble(_dbm._sqlselectsingleresult(_sql,_sql_str)));
 //BA.debugLineNum = 410;BA.debugLine="SQL_str = $\"Select   abmfeedback.cases.CaseID,";
_sql_str = ("Select\n"+"  abmfeedback.cases.CaseID,\n"+"  abmfeedback.cases.CaseType,\n"+"  abmfeedback.cases.CaseSummary,\n"+"  abmfeedback.cases.CaseStatus,\n"+"  abmfeedback.cases.CaseFixedVersion,\n"+"  abmfeedback.cases.CaseCreationDate,\n"+"  Count(abmfeedback.casenotes.CaseNID) As countofcasenid,\n"+"  SubQuery.CaseRStatus\n"+"From\n"+"  abmfeedback.cases Left Join\n"+"  abmfeedback.casenotes\n"+"    On abmfeedback.cases.CaseID = abmfeedback.casenotes.CaseNCaseID Left Join\n"+"  (Select\n"+"    abmfeedback.caseread.CaseRCaseID,\n"+"    abmfeedback.caseread.CaseRStatus\n"+"  From\n"+"    abmfeedback.caseread\n"+"  Where\n"+"    abmfeedback.caseread.CaseRUserID = "+__c.SmartStringFormatter("",(Object)(_userid))+") As SubQuery\n"+"    On SubQuery.CaseRCaseID = abmfeedback.cases.CaseID\n"+"Group By\n"+"  abmfeedback.cases.CaseID, abmfeedback.cases.CaseType,\n"+"  abmfeedback.cases.CaseSummary, abmfeedback.cases.CaseStatus,\n"+"  abmfeedback.cases.CaseFixedVersion, abmfeedback.cases.CaseCreationDate,\n"+"  SubQuery.CaseRStatus "+__c.SmartStringFormatter("",(Object)(_filter))+" "+__c.SmartStringFormatter("",(Object)(_lastsort))+" LIMIT "+__c.SmartStringFormatter("",(Object)((_frompage-1)*_maxrows))+","+__c.SmartStringFormatter("",(Object)(_maxrows))+"");
 //BA.debugLineNum = 437;BA.debugLine="Dim cases As List = DBM.SQLSelect(SQL, SQL_str, N";
_cases = new anywheresoftware.b4a.objects.collections.List();
_cases = _dbm._sqlselect(_sql,_sql_str,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 438;BA.debugLine="If cases.Size = 0 And fromPage > 1 Then";
if (_cases.getSize()==0 && _frompage>1) { 
 //BA.debugLineNum = 440;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 441;BA.debugLine="fromPage = fromPage - 1";
_frompage = (int) (_frompage-1);
 //BA.debugLineNum = 442;BA.debugLine="LoadCases(fromPage)";
_loadcases(_frompage);
 //BA.debugLineNum = 443;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 445;BA.debugLine="tblCases.SetFooter(\"Total number of cases: \" & nu";
_tblcases.SetFooter((Object)("Total number of cases: "+BA.NumberToString(_numcases)),(int) (12),"bg");
 //BA.debugLineNum = 446;BA.debugLine="tblCases.Clear";
_tblcases.Clear();
 //BA.debugLineNum = 447;BA.debugLine="For i = 0 To cases.Size - 1";
{
final int step21 = 1;
final int limit21 = (int) (_cases.getSize()-1);
for (_i = (int) (0) ; (step21 > 0 && _i <= limit21) || (step21 < 0 && _i >= limit21); _i = ((int)(0 + _i + step21)) ) {
 //BA.debugLineNum = 448;BA.debugLine="Dim tblFields As Map = cases.Get(i)";
_tblfields = new anywheresoftware.b4a.objects.collections.Map();
_tblfields.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_cases.Get(_i)));
 //BA.debugLineNum = 449;BA.debugLine="Dim rCellValues As List";
_rcellvalues = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 450;BA.debugLine="Dim rCellThemes As List";
_rcellthemes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 451;BA.debugLine="rCellValues.Initialize";
_rcellvalues.Initialize();
 //BA.debugLineNum = 452;BA.debugLine="rCellThemes.Initialize";
_rcellthemes.Initialize();
 //BA.debugLineNum = 454;BA.debugLine="rCellValues.Add(tblFields.Get(\"caseid\"))";
_rcellvalues.Add(_tblfields.Get((Object)("caseid")));
 //BA.debugLineNum = 455;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 458;BA.debugLine="Select Case tblFields.Get(\"casetype\")";
switch (BA.switchObjectToInt(_tblfields.Get((Object)("casetype")),(Object)("0"),(Object)("1"),(Object)("2"))) {
case 0: {
 //BA.debugLineNum = 460;BA.debugLine="rCellValues.Add(\"[ICON]mdi-action-bug-report\")";
_rcellvalues.Add((Object)("[ICON]mdi-action-bug-report"));
 break; }
case 1: {
 //BA.debugLineNum = 462;BA.debugLine="rCellValues.Add(\"[ICON]mdi-action-alarm-add\")";
_rcellvalues.Add((Object)("[ICON]mdi-action-alarm-add"));
 break; }
case 2: {
 //BA.debugLineNum = 464;BA.debugLine="rCellValues.Add(\"[ICON]mdi-av-new-releases\")";
_rcellvalues.Add((Object)("[ICON]mdi-av-new-releases"));
 break; }
}
;
 //BA.debugLineNum = 466;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 468;BA.debugLine="Select Case tblFields.Get(\"casetype\")";
switch (BA.switchObjectToInt(_tblfields.Get((Object)("casetype")),(Object)("0"),(Object)("1"),(Object)("2"))) {
case 0: {
 //BA.debugLineNum = 470;BA.debugLine="rCellValues.Add(\"[BUG]\")";
_rcellvalues.Add((Object)("[BUG]"));
 break; }
case 1: {
 //BA.debugLineNum = 472;BA.debugLine="rCellValues.Add(\"[WISH]\")";
_rcellvalues.Add((Object)("[WISH]"));
 break; }
case 2: {
 //BA.debugLineNum = 474;BA.debugLine="rCellValues.Add(\"[NEW]\")";
_rcellvalues.Add((Object)("[NEW]"));
 break; }
}
;
 //BA.debugLineNum = 476;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 478;BA.debugLine="rCellValues.Add(tblFields.Get(\"casesummary\"))";
_rcellvalues.Add(_tblfields.Get((Object)("casesummary")));
 //BA.debugLineNum = 479;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 481;BA.debugLine="Select Case tblFields.Get(\"casestatus\")";
switch (BA.switchObjectToInt(_tblfields.Get((Object)("casestatus")),(Object)("0"),(Object)("1"),(Object)("2"),(Object)("3"),(Object)("4"),(Object)("5"),(Object)("6"),(Object)("7"),(Object)("8"),(Object)("9"))) {
case 0: {
 //BA.debugLineNum = 483;BA.debugLine="rCellValues.Add(\"0 - Submitted\")";
_rcellvalues.Add((Object)("0 - Submitted"));
 //BA.debugLineNum = 484;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 break; }
case 1: {
 //BA.debugLineNum = 486;BA.debugLine="rCellValues.Add(\"1 - Closed, no action\")";
_rcellvalues.Add((Object)("1 - Closed, no action"));
 //BA.debugLineNum = 487;BA.debugLine="rCellThemes.Add(\"negative\")";
_rcellthemes.Add((Object)("negative"));
 break; }
case 2: {
 //BA.debugLineNum = 489;BA.debugLine="rCellValues.Add(\"2 - Fixed\")";
_rcellvalues.Add((Object)("2 - Fixed"));
 //BA.debugLineNum = 490;BA.debugLine="rCellThemes.Add(\"positive\")";
_rcellthemes.Add((Object)("positive"));
 break; }
case 3: {
 //BA.debugLineNum = 492;BA.debugLine="rCellValues.Add(\"3 - Implemented\")";
_rcellvalues.Add((Object)("3 - Implemented"));
 //BA.debugLineNum = 493;BA.debugLine="rCellThemes.Add(\"positive\")";
_rcellthemes.Add((Object)("positive"));
 break; }
case 4: {
 //BA.debugLineNum = 495;BA.debugLine="rCellValues.Add(\"4 - More info needed\")";
_rcellvalues.Add((Object)("4 - More info needed"));
 //BA.debugLineNum = 496;BA.debugLine="rCellThemes.Add(\"caseorange\")";
_rcellthemes.Add((Object)("caseorange"));
 break; }
case 5: {
 //BA.debugLineNum = 498;BA.debugLine="rCellValues.Add(\"5 - Confirmed\")";
_rcellvalues.Add((Object)("5 - Confirmed"));
 //BA.debugLineNum = 499;BA.debugLine="rCellThemes.Add(\"caseyellow\")";
_rcellthemes.Add((Object)("caseyellow"));
 break; }
case 6: {
 //BA.debugLineNum = 501;BA.debugLine="rCellValues.Add(\"6 - On hold\")";
_rcellvalues.Add((Object)("6 - On hold"));
 //BA.debugLineNum = 502;BA.debugLine="rCellThemes.Add(\"casegrey\")";
_rcellthemes.Add((Object)("casegrey"));
 break; }
case 7: {
 //BA.debugLineNum = 504;BA.debugLine="rCellValues.Add(\"7 - Expired, no info given\")";
_rcellvalues.Add((Object)("7 - Expired, no info given"));
 //BA.debugLineNum = 505;BA.debugLine="rCellThemes.Add(\"negative\")";
_rcellthemes.Add((Object)("negative"));
 break; }
case 8: {
 //BA.debugLineNum = 507;BA.debugLine="rCellValues.Add(\"8 - Closed, forum question\")";
_rcellvalues.Add((Object)("8 - Closed, forum question"));
 //BA.debugLineNum = 508;BA.debugLine="rCellThemes.Add(\"negative\")";
_rcellthemes.Add((Object)("negative"));
 break; }
case 9: {
 //BA.debugLineNum = 510;BA.debugLine="rCellValues.Add(\"9 - Solved, no action\")";
_rcellvalues.Add((Object)("9 - Solved, no action"));
 //BA.debugLineNum = 511;BA.debugLine="rCellthemes.Add(\"positive\")";
_rcellthemes.Add((Object)("positive"));
 break; }
}
;
 //BA.debugLineNum = 514;BA.debugLine="If tblFields.Get(\"casefixedversion\") =\"\" Then";
if ((_tblfields.Get((Object)("casefixedversion"))).equals((Object)(""))) { 
 //BA.debugLineNum = 515;BA.debugLine="rCellValues.Add(\"{NBSP}\")";
_rcellvalues.Add((Object)("{NBSP}"));
 }else {
 //BA.debugLineNum = 517;BA.debugLine="rCellValues.Add(tblFields.Get(\"casefixedversion";
_rcellvalues.Add(_tblfields.Get((Object)("casefixedversion")));
 };
 //BA.debugLineNum = 519;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 521;BA.debugLine="rCellValues.Add(tblFields.Get(\"casecreationdate\"";
_rcellvalues.Add(_tblfields.Get((Object)("casecreationdate")));
 //BA.debugLineNum = 522;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 572;BA.debugLine="If tblFields.Get(\"countofcasenid\") <> Null Then";
if (_tblfields.Get((Object)("countofcasenid"))!= null) { 
 //BA.debugLineNum = 573;BA.debugLine="Dim numNotes As String = tblFields.Get(\"countof";
_numnotes = BA.ObjectToString(_tblfields.Get((Object)("countofcasenid")));
 //BA.debugLineNum = 574;BA.debugLine="rCellValues.Add(numNotes)";
_rcellvalues.Add((Object)(_numnotes));
 //BA.debugLineNum = 575;BA.debugLine="Dim numNotesTheme As String = \"unread\"";
_numnotestheme = "unread";
 //BA.debugLineNum = 576;BA.debugLine="If tblFields.Get(\"caserstatus\") <> Null Then";
if (_tblfields.Get((Object)("caserstatus"))!= null) { 
 //BA.debugLineNum = 577;BA.debugLine="If tblFields.Get(\"caserstatus\") = \"1\" Then";
if ((_tblfields.Get((Object)("caserstatus"))).equals((Object)("1"))) { 
 //BA.debugLineNum = 578;BA.debugLine="numNotesTheme = \"points\"";
_numnotestheme = "points";
 };
 };
 //BA.debugLineNum = 581;BA.debugLine="rCellThemes.Add(numNotesTheme)";
_rcellthemes.Add((Object)(_numnotestheme));
 }else {
 //BA.debugLineNum = 583;BA.debugLine="rCellValues.Add(\"{NBSP}\")";
_rcellvalues.Add((Object)("{NBSP}"));
 //BA.debugLineNum = 584;BA.debugLine="rCellThemes.Add(\"points\")";
_rcellthemes.Add((Object)("points"));
 };
 //BA.debugLineNum = 587;BA.debugLine="Dim btnEdit As ABMButton";
_btnedit = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 588;BA.debugLine="btnEdit.InitializeFloating(page, \"btnEdit\", \"mdi";
_btnedit.InitializeFloating(_page,"btnEdit","mdi-action-visibility","");
 //BA.debugLineNum = 589;BA.debugLine="rCellValues.Add(btnEdit)";
_rcellvalues.Add((Object)(_btnedit));
 //BA.debugLineNum = 590;BA.debugLine="rCellThemes.Add(\"openedit\")";
_rcellthemes.Add((Object)("openedit"));
 //BA.debugLineNum = 592;BA.debugLine="If UserType = \"1\" Then";
if ((_usertype).equals("1")) { 
 //BA.debugLineNum = 593;BA.debugLine="Dim btnDelete As ABMButton";
_btndelete = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 594;BA.debugLine="btnDelete.InitializeFloating(page, \"btnDelete\",";
_btndelete.InitializeFloating(_page,"btnDelete","mdi-action-delete","");
 //BA.debugLineNum = 595;BA.debugLine="rCellValues.Add(btnDelete)";
_rcellvalues.Add((Object)(_btndelete));
 //BA.debugLineNum = 596;BA.debugLine="rCellThemes.Add(\"openedit\")";
_rcellthemes.Add((Object)("openedit"));
 };
 //BA.debugLineNum = 599;BA.debugLine="tblCases.AddRow(\"uid\" & i, rCellValues)";
_tblcases.AddRow("uid"+BA.NumberToString(_i),_rcellvalues);
 //BA.debugLineNum = 600;BA.debugLine="tblCases.SetRowThemes(rCellThemes) ' make sure y";
_tblcases.SetRowThemes(_rcellthemes);
 }
};
 //BA.debugLineNum = 602;BA.debugLine="tblCases.Refresh";
_tblcases.Refresh();
 //BA.debugLineNum = 604;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 606;BA.debugLine="Dim pagination As ABMPagination = page.Component(";
_pagination = (com.ab.abmaterial.ABMPagination)(_page.Component("pagination"));
 //BA.debugLineNum = 607;BA.debugLine="If (numcases Mod MaxRows > 0) Or (numcases = 0) T";
if ((_numcases%_maxrows>0) || (_numcases==0)) { 
 //BA.debugLineNum = 608;BA.debugLine="numcases = numcases/MaxRows + 1";
_numcases = (int) (_numcases/(double)_maxrows+1);
 }else {
 //BA.debugLineNum = 610;BA.debugLine="numcases = numcases/MaxRows";
_numcases = (int) (_numcases/(double)_maxrows);
 };
 //BA.debugLineNum = 612;BA.debugLine="pagination.SetTotalNumberOfPages(numcases)";
_pagination.SetTotalNumberOfPages(_numcases);
 //BA.debugLineNum = 613;BA.debugLine="pagination.SetActivePage(fromPage)";
_pagination.SetActivePage(_frompage);
 //BA.debugLineNum = 614;BA.debugLine="pagination.Refresh";
_pagination.Refresh();
 //BA.debugLineNum = 615;BA.debugLine="End Sub";
return "";
}
public String  _msgno_clicked(String _target) throws Exception{
 //BA.debugLineNum = 1524;BA.debugLine="Sub msgno_Clicked(Target As String)";
 //BA.debugLineNum = 1525;BA.debugLine="page.CloseModalSheet(\"msg\")";
_page.CloseModalSheet("msg");
 //BA.debugLineNum = 1526;BA.debugLine="End Sub";
return "";
}
public String  _msgok_clicked(String _target) throws Exception{
 //BA.debugLineNum = 1552;BA.debugLine="Sub msgok_Clicked(Target As String)";
 //BA.debugLineNum = 1553;BA.debugLine="page.CloseModalSheet(\"msgbox\")";
_page.CloseModalSheet("msgbox");
 //BA.debugLineNum = 1554;BA.debugLine="End Sub";
return "";
}
public String  _msgyes_clicked(String _target) throws Exception{
anywheresoftware.b4j.objects.SQL _sql = null;
com.ab.abmaterial.ABMModalSheet _inp = null;
String _sql_str = "";
anywheresoftware.b4a.objects.collections.List _notes = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _note = null;
com.ab.abmaterial.ABMContainer _notecont = null;
com.ab.abmaterial.ABMPagination _pagination = null;
 //BA.debugLineNum = 1476;BA.debugLine="Sub msgyes_Clicked(Target As String)";
 //BA.debugLineNum = 1477;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 1479;BA.debugLine="Select Case TypeDelete";
switch (BA.switchObjectToInt(_typedelete,"Note","Case")) {
case 0: {
 //BA.debugLineNum = 1482;BA.debugLine="DBM.SQLDelete(SQL, \"DELETE FROM casenotes WHERE";
_dbm._sqldelete(_sql,"DELETE FROM casenotes WHERE CaseNID="+BA.NumberToString(_activecasenoteid));
 //BA.debugLineNum = 1485;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 1488;BA.debugLine="Dim SQL_Str As String = \"SELECT casenotes.*, us";
_sql_str = "SELECT casenotes.*, users.UserName FROM casenotes INNER JOIN users ON casenotes.CaseNUserID = users.UserID WHERE CaseNCaseID="+BA.NumberToString(_activecaseid)+" ORDER BY CaseNCreationDate DESC, CaseNID DESC";
 //BA.debugLineNum = 1489;BA.debugLine="Dim notes As List = DBM.SQLSelect(SQL, SQL_Str,";
_notes = new anywheresoftware.b4a.objects.collections.List();
_notes = _dbm._sqlselect(_sql,_sql_str,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 1492;BA.debugLine="inp.Content.Cell(6,1).RemoveAllComponents";
_inp.Content.Cell((int) (6),(int) (1)).RemoveAllComponents();
 //BA.debugLineNum = 1494;BA.debugLine="For i = 0 To notes.Size - 1";
{
final int step9 = 1;
final int limit9 = (int) (_notes.getSize()-1);
for (_i = (int) (0) ; (step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9); _i = ((int)(0 + _i + step9)) ) {
 //BA.debugLineNum = 1495;BA.debugLine="Dim note As Map = notes.Get(i)";
_note = new anywheresoftware.b4a.objects.collections.Map();
_note.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_notes.Get(_i)));
 //BA.debugLineNum = 1496;BA.debugLine="Dim notecont As ABMContainer = BuildNoteContai";
_notecont = _buildnotecontainer(("notes"+BA.ObjectToString(_note.Get((Object)("casenid")))),BA.ObjectToString(_note.Get((Object)("casendescription"))),BA.ObjectToString(_note.Get((Object)("username"))),BA.ObjectToString(_note.Get((Object)("casencreationdate"))),(int)(BA.ObjectToNumber(_note.Get((Object)("casenuserid")))));
 //BA.debugLineNum = 1497;BA.debugLine="inp.Content.Cell(6,1).AddComponent(notecont)";
_inp.Content.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_notecont));
 }
};
 //BA.debugLineNum = 1500;BA.debugLine="inp.Refresh";
_inp.Refresh();
 break; }
case 1: {
 //BA.debugLineNum = 1503;BA.debugLine="DBM.SQLDelete(SQL, \"DELETE FROM casenotes WHERE";
_dbm._sqldelete(_sql,"DELETE FROM casenotes WHERE CaseNCaseID="+BA.NumberToString(_activecaseid));
 //BA.debugLineNum = 1506;BA.debugLine="DBM.SQLDelete(SQL, \"DELETE FROM caseattachments";
_dbm._sqldelete(_sql,"DELETE FROM caseattachments WHERE CaseACaseID="+BA.NumberToString(_activecaseid));
 //BA.debugLineNum = 1512;BA.debugLine="DBM.SQLDelete(SQL, \"DELETE FROM cases WHERE Cas";
_dbm._sqldelete(_sql,"DELETE FROM cases WHERE CaseID="+BA.NumberToString(_activecaseid));
 //BA.debugLineNum = 1515;BA.debugLine="Dim pagination As ABMPagination = page.Componen";
_pagination = (com.ab.abmaterial.ABMPagination)(_page.Component("pagination"));
 //BA.debugLineNum = 1516;BA.debugLine="LoadCases(pagination.GetActivePage())";
_loadcases(_pagination.GetActivePage());
 break; }
}
;
 //BA.debugLineNum = 1519;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 1521;BA.debugLine="page.CloseModalSheet(\"msg\")";
_page.CloseModalSheet("msg");
 //BA.debugLineNum = 1522;BA.debugLine="End Sub";
return "";
}
public String  _notebtn_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _inpnote = null;
com.ab.abmaterial.ABMInput _notedescription = null;
 //BA.debugLineNum = 1200;BA.debugLine="Sub NoteBtn_Clicked(Target As String)";
 //BA.debugLineNum = 1201;BA.debugLine="ActiveCaseNoteID = 0";
_activecasenoteid = (int) (0);
 //BA.debugLineNum = 1203;BA.debugLine="Dim inpNote As ABMModalSheet = page.ModalSheet(\"i";
_inpnote = _page.ModalSheet("inpNote");
 //BA.debugLineNum = 1204;BA.debugLine="Dim Notedescription As ABMInput = inpNote.Content";
_notedescription = (com.ab.abmaterial.ABMInput)(_inpnote.Content.Component("notedescription"));
 //BA.debugLineNum = 1205;BA.debugLine="Notedescription.Text = \"\"";
_notedescription.setText("");
 //BA.debugLineNum = 1207;BA.debugLine="page.ShowModalSheet(\"inpNote\")";
_page.ShowModalSheet("inpNote");
 //BA.debugLineNum = 1208;BA.debugLine="End Sub";
return "";
}
public String  _page_fileuploaded(String _filename,boolean _success) throws Exception{
anywheresoftware.b4j.objects.SQL _sql = null;
anywheresoftware.b4a.objects.collections.List _attachs = null;
anywheresoftware.b4a.objects.collections.Map _attach = null;
 //BA.debugLineNum = 1395;BA.debugLine="Sub Page_FileUploaded(FileName As String, success";
 //BA.debugLineNum = 1396;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 1398;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 1400;BA.debugLine="Dim attachs As List = DBM.SQLSelect(SQL, \"SELECT";
_attachs = new anywheresoftware.b4a.objects.collections.List();
_attachs = _dbm._sqlselect(_sql,"SELECT CaseAID FROM caseattachments WHERE CaseAValue='"+_activecasenumber+_filename+"'",(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 1402;BA.debugLine="If attachs.Size = 0 Then";
if (_attachs.getSize()==0) { 
 //BA.debugLineNum = 1403;BA.debugLine="Attachments.put(Attachments.Size-1000, ActiveCas";
_attachments.Put((Object)(_attachments.getSize()-1000),(Object)(_activecasenumber+_filename));
 }else {
 //BA.debugLineNum = 1405;BA.debugLine="Dim attach As Map = attachs.Get(0)";
_attach = new anywheresoftware.b4a.objects.collections.Map();
_attach.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_attachs.Get((int) (0))));
 //BA.debugLineNum = 1406;BA.debugLine="Attachments.put(attach.Get(\"caseaid\"), ActiveCas";
_attachments.Put(_attach.Get((Object)("caseaid")),(Object)(_activecasenumber+_filename));
 };
 //BA.debugLineNum = 1409;BA.debugLine="If success Then";
if (_success) { 
 //BA.debugLineNum = 1410;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastgreen\"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastgreen","File "+_filename+" uploaded!",(int) (5000));
 }else {
 //BA.debugLineNum = 1412;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","File "+_filename+" not uploaded!",(int) (5000));
 };
 //BA.debugLineNum = 1415;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 1416;BA.debugLine="page.ws.Flush ' IMPORTANT";
_page.ws.Flush();
 //BA.debugLineNum = 1417;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 641;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 642;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 644;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 645;BA.debugLine="ABMShared.LogOff(page, ABMShared.AppName)";
_abmshared._logoff(_page,_abmshared._appname);
 //BA.debugLineNum = 646;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 648;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 649;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 362;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 363;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 364;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 365;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 366;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 367;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 368;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 370;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 371;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 372;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 373;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 375;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 377;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 379;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 380;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 381;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 383;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 387;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 390;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 651;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 652;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 653;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 654;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 655;BA.debugLine="page.ws.Session.SetAttribute(\"UserType\", \"\" )";
_page.ws.getSession().SetAttribute("UserType",(Object)(""));
 //BA.debugLineNum = 656;BA.debugLine="page.ws.Session.SetAttribute(\"UserID\", \"\" )";
_page.ws.getSession().SetAttribute("UserID",(Object)(""));
 //BA.debugLineNum = 657;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 658;BA.debugLine="End Sub";
return "";
}
public String  _pagination_pagechanged(int _oldpage,int _newpage) throws Exception{
 //BA.debugLineNum = 660;BA.debugLine="Sub pagination_PageChanged(OldPage As Int, NewPage";
 //BA.debugLineNum = 662;BA.debugLine="LoadCases(NewPage)";
_loadcases(_newpage);
 //BA.debugLineNum = 663;BA.debugLine="End Sub";
return "";
}
public String  _savebtn_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _msgbox = null;
com.ab.abmaterial.ABMLabel _lbl = null;
com.ab.abmaterial.ABMModalSheet _inp = null;
anywheresoftware.b4a.objects.collections.Map _currentfields = null;
anywheresoftware.b4a.objects.collections.Map _wherefields = null;
com.ab.abmaterial.ABMCombo _casetype = null;
com.ab.abmaterial.ABMInput _casesummary = null;
com.ab.abmaterial.ABMInput _casedescription = null;
com.ab.abmaterial.ABMCombo _casestatus = null;
com.ab.abmaterial.ABMInput _caseversion = null;
anywheresoftware.b4j.objects.SQL _sql = null;
String _sql_select = "";
String _sql_insert = "";
String _sql_update = "";
int _i = 0;
String _filename = "";
int _caseaid = 0;
com.ab.abmaterial.ABMPagination _pagination = null;
 //BA.debugLineNum = 1210;BA.debugLine="Sub SaveBtn_Clicked(Target As String)";
 //BA.debugLineNum = 1211;BA.debugLine="If CheckInput = False Then";
if (_checkinput()==__c.False) { 
 //BA.debugLineNum = 1212;BA.debugLine="Dim msgbox As ABMModalSheet = page.ModalSheet(\"m";
_msgbox = _page.ModalSheet("msgbox");
 //BA.debugLineNum = 1213;BA.debugLine="Dim lbl As ABMLabel = msgbox.Content.Component(\"";
_lbl = (com.ab.abmaterial.ABMLabel)(_msgbox.Content.Component("par1"));
 //BA.debugLineNum = 1214;BA.debugLine="lbl.Text = \"Please fill in all fields!\"";
_lbl.Text = "Please fill in all fields!";
 //BA.debugLineNum = 1215;BA.debugLine="page.ShowModalSheet(\"msgbox\")";
_page.ShowModalSheet("msgbox");
 //BA.debugLineNum = 1216;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 1219;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp\")";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 1221;BA.debugLine="Dim CurrentFields, WhereFields As Map";
_currentfields = new anywheresoftware.b4a.objects.collections.Map();
_wherefields = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 1222;BA.debugLine="CurrentFields.Initialize";
_currentfields.Initialize();
 //BA.debugLineNum = 1223;BA.debugLine="WhereFields.Initialize";
_wherefields.Initialize();
 //BA.debugLineNum = 1225;BA.debugLine="Dim casetype As ABMCombo = inp.Content.Component(";
_casetype = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("casetype"));
 //BA.debugLineNum = 1226;BA.debugLine="Dim casesummary As ABMInput = inp.Content.Compone";
_casesummary = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("casesummary"));
 //BA.debugLineNum = 1227;BA.debugLine="Dim casedescription As ABMInput = inp.Content.Com";
_casedescription = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("casedescription"));
 //BA.debugLineNum = 1228;BA.debugLine="Dim casestatus As ABMCombo = inp.Content.Componen";
_casestatus = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("casestatus"));
 //BA.debugLineNum = 1229;BA.debugLine="Dim caseversion As ABMInput = inp.Content.Compone";
_caseversion = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("caseversion"));
 //BA.debugLineNum = 1232;BA.debugLine="CurrentFields.Put(\"CaseType\", ABMShared.Mid(caset";
_currentfields.Put((Object)("CaseType"),(Object)(_abmshared._mid(_casetype.GetActiveItemId(),(int) (8),(int) (1))));
 //BA.debugLineNum = 1233;BA.debugLine="CurrentFields.Put(\"CaseSummary\", DBM.SetQuotes(ca";
_currentfields.Put((Object)("CaseSummary"),(Object)(_dbm._setquotes(_casesummary.getText())));
 //BA.debugLineNum = 1234;BA.debugLine="CurrentFields.Put(\"CaseDescription\", DBM.SetQuote";
_currentfields.Put((Object)("CaseDescription"),(Object)(_dbm._setquotes(_casedescription.getText())));
 //BA.debugLineNum = 1235;BA.debugLine="CurrentFields.Put(\"CaseStatus\", ABMShared.Mid(cas";
_currentfields.Put((Object)("CaseStatus"),(Object)(_abmshared._mid(_casestatus.GetActiveItemId(),(int) (5),(int) (1))));
 //BA.debugLineNum = 1236;BA.debugLine="CurrentFields.Put(\"CaseUserID\", page.ws.Session.G";
_currentfields.Put((Object)("CaseUserID"),_page.ws.getSession().GetAttribute2("UserID",(Object)("0")));
 //BA.debugLineNum = 1237;BA.debugLine="DateTime.DateFormat = \"yyyy-MM-dd\"";
__c.DateTime.setDateFormat("yyyy-MM-dd");
 //BA.debugLineNum = 1238;BA.debugLine="CurrentFields.Put(\"CaseCreationDate\", DBM.SetQuot";
_currentfields.Put((Object)("CaseCreationDate"),(Object)(_dbm._setquotes(__c.DateTime.Date(__c.DateTime.getNow()))));
 //BA.debugLineNum = 1239;BA.debugLine="CurrentFields.Put(\"CaseFixedVersion\", DBM.SetQuot";
_currentfields.Put((Object)("CaseFixedVersion"),(Object)(_dbm._setquotes(_caseversion.getText())));
 //BA.debugLineNum = 1240;BA.debugLine="CurrentFields.Put(\"CaseNumber\", DBM.SetQuotes(Act";
_currentfields.Put((Object)("CaseNumber"),(Object)(_dbm._setquotes(_activecasenumber)));
 //BA.debugLineNum = 1251;BA.debugLine="WhereFields.Put(\"CaseId\", ActiveCaseId)";
_wherefields.Put((Object)("CaseId"),(Object)(_activecaseid));
 //BA.debugLineNum = 1254;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 1256;BA.debugLine="Dim SQL_Select As String = \"SELECT CaseID FROM ca";
_sql_select = "SELECT CaseID FROM cases WHERE CaseID="+BA.NumberToString(_activecaseid);
 //BA.debugLineNum = 1257;BA.debugLine="Dim SQL_Insert As String = DBM.BuildInsertQuery(\"";
_sql_insert = _dbm._buildinsertquery("cases",_currentfields);
 //BA.debugLineNum = 1259;BA.debugLine="CurrentFields.Remove(\"CaseUserID\")";
_currentfields.Remove((Object)("CaseUserID"));
 //BA.debugLineNum = 1260;BA.debugLine="CurrentFields.Remove(\"CaseCreationDate\")";
_currentfields.Remove((Object)("CaseCreationDate"));
 //BA.debugLineNum = 1262;BA.debugLine="Dim SQL_Update As String = DBM.BuildUpdateQuery(\"";
_sql_update = _dbm._buildupdatequery("cases",_currentfields,_wherefields);
 //BA.debugLineNum = 1263;BA.debugLine="ActiveCaseId = DBM.SQLInsertOrUpdate(SQL, SQL_Sel";
_activecaseid = _dbm._sqlinsertorupdate(_sql,_sql_select,_sql_insert,_sql_update);
 //BA.debugLineNum = 1289;BA.debugLine="For i = 0 To Attachments.Size - 1";
{
final int step34 = 1;
final int limit34 = (int) (_attachments.getSize()-1);
for (_i = (int) (0) ; (step34 > 0 && _i <= limit34) || (step34 < 0 && _i >= limit34); _i = ((int)(0 + _i + step34)) ) {
 //BA.debugLineNum = 1290;BA.debugLine="Dim fileName As String = Attachments.GetValueAt(";
_filename = BA.ObjectToString(_attachments.GetValueAt(_i));
 //BA.debugLineNum = 1291;BA.debugLine="Dim CaseAID As Int = Attachments.GetKeyAt(i)";
_caseaid = (int)(BA.ObjectToNumber(_attachments.GetKeyAt(_i)));
 //BA.debugLineNum = 1292;BA.debugLine="If RemoveAttachments.ContainsKey(CaseAID) = Fals";
if (_removeattachments.ContainsKey((Object)(_caseaid))==__c.False) { 
 //BA.debugLineNum = 1293;BA.debugLine="Dim CurrentFields, WhereFields As Map";
_currentfields = new anywheresoftware.b4a.objects.collections.Map();
_wherefields = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 1294;BA.debugLine="CurrentFields.Initialize";
_currentfields.Initialize();
 //BA.debugLineNum = 1295;BA.debugLine="WhereFields.Initialize";
_wherefields.Initialize();
 //BA.debugLineNum = 1296;BA.debugLine="CurrentFields.Clear";
_currentfields.Clear();
 //BA.debugLineNum = 1297;BA.debugLine="WhereFields.Clear";
_wherefields.Clear();
 //BA.debugLineNum = 1299;BA.debugLine="CurrentFields.Put(\"CaseACaseID\", ActiveCaseId)";
_currentfields.Put((Object)("CaseACaseID"),(Object)(_activecaseid));
 //BA.debugLineNum = 1300;BA.debugLine="If fileName.ToUpperCase.EndsWith(\".ZIP\") Then";
if (_filename.toUpperCase().endsWith(".ZIP")) { 
 //BA.debugLineNum = 1301;BA.debugLine="CurrentFields.Put(\"CaseAType\", 0)";
_currentfields.Put((Object)("CaseAType"),(Object)(0));
 }else {
 //BA.debugLineNum = 1303;BA.debugLine="CurrentFields.Put(\"CaseAType\", 1)";
_currentfields.Put((Object)("CaseAType"),(Object)(1));
 };
 //BA.debugLineNum = 1305;BA.debugLine="CurrentFields.Put(\"CaseAValue\", DBM.SetQuotes(f";
_currentfields.Put((Object)("CaseAValue"),(Object)(_dbm._setquotes(_filename)));
 //BA.debugLineNum = 1308;BA.debugLine="WhereFields.Put(\"CaseAID\", CaseAID)";
_wherefields.Put((Object)("CaseAID"),(Object)(_caseaid));
 //BA.debugLineNum = 1310;BA.debugLine="Dim SQL_Select As String = \"SELECT CaseAID FROM";
_sql_select = "SELECT CaseAID FROM caseattachments WHERE CaseAID="+BA.NumberToString(_caseaid);
 //BA.debugLineNum = 1311;BA.debugLine="Dim SQL_Insert As String = DBM.BuildInsertQuery";
_sql_insert = _dbm._buildinsertquery("caseattachments",_currentfields);
 //BA.debugLineNum = 1312;BA.debugLine="Dim SQL_Update As String = DBM.BuildUpdateQuery";
_sql_update = _dbm._buildupdatequery("caseattachments",_currentfields,_wherefields);
 //BA.debugLineNum = 1313;BA.debugLine="DBM.SQLInsertOrUpdate(SQL, SQL_Select, SQL_Inse";
_dbm._sqlinsertorupdate(_sql,_sql_select,_sql_insert,_sql_update);
 };
 }
};
 //BA.debugLineNum = 1317;BA.debugLine="For Each CaseAID As Int In RemoveAttachments.Keys";
final anywheresoftware.b4a.BA.IterableList group57 = _removeattachments.Keys();
final int groupLen57 = group57.getSize();
for (int index57 = 0;index57 < groupLen57 ;index57++){
_caseaid = (int)(BA.ObjectToNumber(group57.Get(index57)));
 //BA.debugLineNum = 1318;BA.debugLine="DBM.SQLDelete(SQL, \"DELETE FROM caseattachments";
_dbm._sqldelete(_sql,"DELETE FROM caseattachments WHERE CaseAID="+BA.NumberToString(_caseaid));
 //BA.debugLineNum = 1319;BA.debugLine="Dim fileName As String = Attachments.GetDefault(";
_filename = BA.ObjectToString(_attachments.GetDefault((Object)(_caseaid),(Object)("")));
 //BA.debugLineNum = 1320;BA.debugLine="If fileName <> \"\" Then";
if ((_filename).equals("") == false) { 
 //BA.debugLineNum = 1321;BA.debugLine="File.Delete(File.DirApp, \"/www/\" & ABMShared.Ap";
__c.File.Delete(__c.File.getDirApp(),"/www/"+_abmshared._appname+"/uploads/"+_filename);
 };
 }
;
 //BA.debugLineNum = 1325;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 1331;BA.debugLine="Dim pagination As ABMPagination = page.Component(";
_pagination = (com.ab.abmaterial.ABMPagination)(_page.Component("pagination"));
 //BA.debugLineNum = 1332;BA.debugLine="LoadCases(pagination.GetActivePage())";
_loadcases(_pagination.GetActivePage());
 //BA.debugLineNum = 1334;BA.debugLine="page.CloseModalSheet(\"inp\")";
_page.CloseModalSheet("inp");
 //BA.debugLineNum = 1335;BA.debugLine="End Sub";
return "";
}
public String  _searchcase_enterpressed(String _value) throws Exception{
 //BA.debugLineNum = 669;BA.debugLine="Sub searchCase_EnterPressed(value As String)";
 //BA.debugLineNum = 670;BA.debugLine="DoSearch";
_dosearch();
 //BA.debugLineNum = 671;BA.debugLine="End Sub";
return "";
}
public String  _tblcases_clicked(anywheresoftware.b4a.objects.collections.List _passedrowsandcolumns) throws Exception{
com.ab.abmaterial.ABMTableCell _tblcellinfo = null;
com.ab.abmaterial.ABMTable _tblcases = null;
com.ab.abmaterial.ABMModalSheet _inp = null;
anywheresoftware.b4j.objects.SQL _sql = null;
anywheresoftware.b4a.objects.collections.List _cases = null;
anywheresoftware.b4a.objects.collections.Map _cas = null;
int _attcounter = 0;
boolean _canbeclosed = false;
String _sql_str = "";
anywheresoftware.b4a.objects.collections.List _attachs = null;
String _attlocation = "";
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _attach = null;
String _filename = "";
com.ab.abmaterial.ABMChip _chip = null;
com.ab.abmaterial.ABMLabel _lblcasecreator = null;
com.ab.abmaterial.ABMCombo _casetype = null;
com.ab.abmaterial.ABMInput _casesummary = null;
com.ab.abmaterial.ABMInput _casedescription = null;
com.ab.abmaterial.ABMButton _savebtn = null;
com.ab.abmaterial.ABMButton _attbtn = null;
com.ab.abmaterial.ABMButton _notebtn = null;
com.ab.abmaterial.ABMCombo _casestatus = null;
com.ab.abmaterial.ABMInput _caseversion = null;
anywheresoftware.b4a.objects.collections.List _notes = null;
anywheresoftware.b4a.objects.collections.Map _note = null;
com.ab.abmaterial.ABMContainer _notecont = null;
anywheresoftware.b4a.objects.collections.Map _currentfields = null;
anywheresoftware.b4a.objects.collections.Map _wherefields = null;
String _sql_select = "";
String _sql_insert = "";
String _sql_update = "";
com.ab.abmaterial.ABMModalSheet _msg = null;
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 843;BA.debugLine="Sub tblCases_Clicked(PassedRowsAndColumns As List)";
 //BA.debugLineNum = 845;BA.debugLine="Dim tblCellInfo As ABMTableCell = PassedRowsAndCo";
_tblcellinfo = (com.ab.abmaterial.ABMTableCell)(_passedrowsandcolumns.Get((int) (0)));
 //BA.debugLineNum = 846;BA.debugLine="Dim tblCases As ABMTable = page.Component(tblCell";
_tblcases = (com.ab.abmaterial.ABMTable)(_page.Component(_tblcellinfo.TableName));
 //BA.debugLineNum = 847;BA.debugLine="If tblCellInfo.Column = 8 Then ' edit";
if (_tblcellinfo.Column==8) { 
 //BA.debugLineNum = 848;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp\"";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 849;BA.debugLine="ActiveCaseId = tblCases.GetString(tblCellInfo.Ro";
_activecaseid = (int)(Double.parseDouble(_tblcases.GetString(_tblcellinfo.Row,(int) (0))));
 //BA.debugLineNum = 851;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 853;BA.debugLine="Dim cases As List = DBM.SQLSelect(SQL, \"SELECT c";
_cases = new anywheresoftware.b4a.objects.collections.List();
_cases = _dbm._sqlselect(_sql,"SELECT cases.*, users.UserName FROM cases INNER JOIN users ON cases.CaseUserID = users.UserID WHERE caseId="+BA.NumberToString(_activecaseid),(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 854;BA.debugLine="If cases.Size = 0 Then";
if (_cases.getSize()==0) { 
 //BA.debugLineNum = 855;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 856;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 859;BA.debugLine="Dim cas As Map = cases.Get(0)";
_cas = new anywheresoftware.b4a.objects.collections.Map();
_cas.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_cases.Get((int) (0))));
 //BA.debugLineNum = 861;BA.debugLine="ActiveCaseNumber = cas.Get(\"casenumber\")";
_activecasenumber = BA.ObjectToString(_cas.Get((Object)("casenumber")));
 //BA.debugLineNum = 863;BA.debugLine="ws.Session.SetAttribute(\"abmactivecasenumber\", A";
_ws.getSession().SetAttribute("abmactivecasenumber",(Object)(_activecasenumber));
 //BA.debugLineNum = 865;BA.debugLine="Attachments.Initialize";
_attachments.Initialize();
 //BA.debugLineNum = 867;BA.debugLine="RemoveAttachments.Initialize";
_removeattachments.Initialize();
 //BA.debugLineNum = 869;BA.debugLine="Dim attCounter As Int = 0";
_attcounter = (int) (0);
 //BA.debugLineNum = 871;BA.debugLine="ActiveCaseUserID = cas.Get(\"caseuserid\")";
_activecaseuserid = (int)(BA.ObjectToNumber(_cas.Get((Object)("caseuserid"))));
 //BA.debugLineNum = 873;BA.debugLine="Dim CanBeclosed As Boolean = (UserType = \"1\" Or";
_canbeclosed = ((_usertype).equals("1") || (_page.ws.getSession().GetAttribute("UserID")).equals((Object)(_activecaseuserid)));
 //BA.debugLineNum = 875;BA.debugLine="Dim SQL_str As String = \"SELECT * FROM caseattac";
_sql_str = "SELECT * FROM caseattachments WHERE caseACaseID="+BA.NumberToString(_activecaseid);
 //BA.debugLineNum = 876;BA.debugLine="Dim attachs As List = DBM.SQLSelect(SQL,SQL_str,";
_attachs = new anywheresoftware.b4a.objects.collections.List();
_attachs = _dbm._sqlselect(_sql,_sql_str,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 878;BA.debugLine="Dim attLocation As String = \"../uploads/\"";
_attlocation = "../uploads/";
 //BA.debugLineNum = 881;BA.debugLine="inp.Content.Cell(5,1).RemoveAllComponents";
_inp.Content.Cell((int) (5),(int) (1)).RemoveAllComponents();
 //BA.debugLineNum = 883;BA.debugLine="For i=0 To attachs.Size - 1";
{
final int step24 = 1;
final int limit24 = (int) (_attachs.getSize()-1);
for (_i = (int) (0) ; (step24 > 0 && _i <= limit24) || (step24 < 0 && _i >= limit24); _i = ((int)(0 + _i + step24)) ) {
 //BA.debugLineNum = 884;BA.debugLine="Dim attach As Map = attachs.Get(i)";
_attach = new anywheresoftware.b4a.objects.collections.Map();
_attach.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_attachs.Get(_i)));
 //BA.debugLineNum = 885;BA.debugLine="Dim fileName As String = attach.Get(\"caseavalue";
_filename = BA.ObjectToString(_attach.Get((Object)("caseavalue")));
 //BA.debugLineNum = 886;BA.debugLine="Attachments.Put(attach.Get(\"caseaid\"), fileName";
_attachments.Put(_attach.Get((Object)("caseaid")),(Object)(_filename));
 //BA.debugLineNum = 888;BA.debugLine="Dim chip As ABMChip";
_chip = new com.ab.abmaterial.ABMChip();
 //BA.debugLineNum = 889;BA.debugLine="attCounter = attCounter + 1";
_attcounter = (int) (_attcounter+1);
 //BA.debugLineNum = 890;BA.debugLine="chip.Initialize(page, attCounter, \"{AL}\" & attL";
_chip.Initialize(_page,BA.NumberToString(_attcounter),"{AL}"+_attlocation+_filename+"{AT}"+_abmshared._mid2(_filename,(int) (_activecasenumber.length()+1))+"{/AL}",_canbeclosed,"chip");
 //BA.debugLineNum = 891;BA.debugLine="chip.Tag = attach.Get(\"caseaid\")";
_chip.Tag = BA.ObjectToString(_attach.Get((Object)("caseaid")));
 //BA.debugLineNum = 892;BA.debugLine="inp.Content.Cell(5,1).AddArrayComponent(chip, \"";
_inp.Content.Cell((int) (5),(int) (1)).AddArrayComponent((com.ab.abmaterial.ABMComponent)(_chip),"Chip");
 }
};
 //BA.debugLineNum = 895;BA.debugLine="Dim lblCaseCreator As ABMLabel =  inp.Content.Co";
_lblcasecreator = (com.ab.abmaterial.ABMLabel)(_inp.Content.Component("lblCaseCreator"));
 //BA.debugLineNum = 896;BA.debugLine="lblCaseCreator.Text = cas.Get(\"username\")";
_lblcasecreator.Text = BA.ObjectToString(_cas.Get((Object)("username")));
 //BA.debugLineNum = 899;BA.debugLine="Dim casetype As ABMCombo = inp.Content.Component";
_casetype = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("casetype"));
 //BA.debugLineNum = 900;BA.debugLine="casetype.SetActiveItemId(\"combo1S\" & cas.Get(\"ca";
_casetype.SetActiveItemId("combo1S"+BA.ObjectToString(_cas.Get((Object)("casetype"))));
 //BA.debugLineNum = 901;BA.debugLine="casetype.Enabled = True";
_casetype.Enabled = __c.True;
 //BA.debugLineNum = 903;BA.debugLine="Dim casesummary As ABMInput = inp.Content.Compon";
_casesummary = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("casesummary"));
 //BA.debugLineNum = 904;BA.debugLine="casesummary.Text = cas.Get(\"casesummary\")";
_casesummary.setText(BA.ObjectToString(_cas.Get((Object)("casesummary"))));
 //BA.debugLineNum = 905;BA.debugLine="casesummary.Enabled = True";
_casesummary.Enabled = __c.True;
 //BA.debugLineNum = 907;BA.debugLine="Dim casedescription As ABMInput = inp.Content.Co";
_casedescription = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("casedescription"));
 //BA.debugLineNum = 908;BA.debugLine="casedescription.Text = cas.Get(\"casedescription\"";
_casedescription.setText(BA.ObjectToString(_cas.Get((Object)("casedescription"))));
 //BA.debugLineNum = 909;BA.debugLine="casedescription.Enabled = True";
_casedescription.Enabled = __c.True;
 //BA.debugLineNum = 961;BA.debugLine="Dim savebtn As ABMButton = inp.Footer.Component(";
_savebtn = (com.ab.abmaterial.ABMButton)(_inp.Footer.Component("SaveBtn"));
 //BA.debugLineNum = 962;BA.debugLine="savebtn.Visibility = ABM.VISIBILITY_ALL";
_savebtn.Visibility = _abm.VISIBILITY_ALL;
 //BA.debugLineNum = 964;BA.debugLine="Dim attbtn As ABMButton = inp.Footer.Component(\"";
_attbtn = (com.ab.abmaterial.ABMButton)(_inp.Footer.Component("AttBtn"));
 //BA.debugLineNum = 965;BA.debugLine="attbtn.Visibility = ABM.VISIBILITY_ALL";
_attbtn.Visibility = _abm.VISIBILITY_ALL;
 //BA.debugLineNum = 967;BA.debugLine="Dim notebtn As ABMButton = inp.Footer.Component(";
_notebtn = (com.ab.abmaterial.ABMButton)(_inp.Footer.Component("NoteBtn"));
 //BA.debugLineNum = 968;BA.debugLine="notebtn.Visibility = ABM.VISIBILITY_ALL";
_notebtn.Visibility = _abm.VISIBILITY_ALL;
 //BA.debugLineNum = 970;BA.debugLine="If UserType = \"1\" Then ' admin, we're allowed to";
if ((_usertype).equals("1")) { 
 //BA.debugLineNum = 971;BA.debugLine="Dim casestatus As ABMCombo = inp.Content.Compon";
_casestatus = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("casestatus"));
 //BA.debugLineNum = 972;BA.debugLine="casestatus.Visibility = ABM.VISIBILITY_ALL";
_casestatus.Visibility = _abm.VISIBILITY_ALL;
 //BA.debugLineNum = 973;BA.debugLine="casestatus.SetActiveItemId(\"stat\" & cas.Get(\"ca";
_casestatus.SetActiveItemId("stat"+BA.ObjectToString(_cas.Get((Object)("casestatus"))));
 //BA.debugLineNum = 975;BA.debugLine="Dim caseversion As ABMInput = inp.Content.Compo";
_caseversion = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("caseversion"));
 //BA.debugLineNum = 976;BA.debugLine="caseversion.Visibility = ABM.VISIBILITY_ALL";
_caseversion.Visibility = _abm.VISIBILITY_ALL;
 //BA.debugLineNum = 977;BA.debugLine="caseversion.Text = cas.Get(\"casefixedversion\")";
_caseversion.setText(BA.ObjectToString(_cas.Get((Object)("casefixedversion"))));
 }else {
 //BA.debugLineNum = 980;BA.debugLine="Dim casestatus As ABMCombo = inp.Content.Compon";
_casestatus = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("casestatus"));
 //BA.debugLineNum = 981;BA.debugLine="casestatus.Visibility = ABM.VISIBILITY_HIDE_ALL";
_casestatus.Visibility = _abm.VISIBILITY_HIDE_ALL;
 //BA.debugLineNum = 982;BA.debugLine="casestatus.SetActiveItemId(\"stat\" & cas.Get(\"ca";
_casestatus.SetActiveItemId("stat"+BA.ObjectToString(_cas.Get((Object)("casestatus"))));
 //BA.debugLineNum = 984;BA.debugLine="Dim caseversion As ABMInput = inp.Content.Compo";
_caseversion = (com.ab.abmaterial.ABMInput)(_inp.Content.Component("caseversion"));
 //BA.debugLineNum = 985;BA.debugLine="caseversion.Visibility = ABM.VISIBILITY_HIDE_AL";
_caseversion.Visibility = _abm.VISIBILITY_HIDE_ALL;
 //BA.debugLineNum = 986;BA.debugLine="caseversion.Text = cas.Get(\"casefixedversion\")";
_caseversion.setText(BA.ObjectToString(_cas.Get((Object)("casefixedversion"))));
 //BA.debugLineNum = 988;BA.debugLine="If page.ws.Session.GetAttribute(\"UserID\") <> Ac";
if ((_page.ws.getSession().GetAttribute("UserID")).equals((Object)(_activecaseuserid)) == false) { 
 //BA.debugLineNum = 989;BA.debugLine="casetype.Enabled = False";
_casetype.Enabled = __c.False;
 //BA.debugLineNum = 990;BA.debugLine="casesummary.Enabled = False";
_casesummary.Enabled = __c.False;
 //BA.debugLineNum = 991;BA.debugLine="casedescription.Enabled = False";
_casedescription.Enabled = __c.False;
 //BA.debugLineNum = 992;BA.debugLine="attbtn.Visibility = ABM.VISIBILITY_HIDE_ALL";
_attbtn.Visibility = _abm.VISIBILITY_HIDE_ALL;
 };
 };
 //BA.debugLineNum = 998;BA.debugLine="SQL_str = \"SELECT casenotes.*, users.UserName FR";
_sql_str = "SELECT casenotes.*, users.UserName FROM casenotes INNER JOIN users ON casenotes.CaseNUserID = users.UserID WHERE CaseNCaseID="+BA.NumberToString(_activecaseid)+" ORDER BY CaseNCreationDate DESC, CaseNID DESC";
 //BA.debugLineNum = 999;BA.debugLine="Dim notes As List = DBM.SQLSelect(SQL, SQL_str,";
_notes = new anywheresoftware.b4a.objects.collections.List();
_notes = _dbm._sqlselect(_sql,_sql_str,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 1002;BA.debugLine="inp.Content.Cell(6,1).RemoveAllComponents";
_inp.Content.Cell((int) (6),(int) (1)).RemoveAllComponents();
 //BA.debugLineNum = 1004;BA.debugLine="For i = 0 To notes.Size - 1";
{
final int step75 = 1;
final int limit75 = (int) (_notes.getSize()-1);
for (_i = (int) (0) ; (step75 > 0 && _i <= limit75) || (step75 < 0 && _i >= limit75); _i = ((int)(0 + _i + step75)) ) {
 //BA.debugLineNum = 1005;BA.debugLine="Dim note As Map = notes.Get(i)";
_note = new anywheresoftware.b4a.objects.collections.Map();
_note.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_notes.Get(_i)));
 //BA.debugLineNum = 1006;BA.debugLine="Dim notecont As ABMContainer = BuildNoteContain";
_notecont = _buildnotecontainer(("notes"+BA.ObjectToString(_note.Get((Object)("casenid")))),BA.ObjectToString(_note.Get((Object)("casendescription"))),BA.ObjectToString(_note.Get((Object)("username"))),BA.ObjectToString(_note.Get((Object)("casencreationdate"))),(int)(BA.ObjectToNumber(_note.Get((Object)("casenuserid")))));
 //BA.debugLineNum = 1007;BA.debugLine="inp.Content.Cell(6,1).AddComponent(notecont)";
_inp.Content.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_notecont));
 }
};
 //BA.debugLineNum = 1012;BA.debugLine="tblCases.UseCellTheme(tblCellInfo.Row, 7, \"point";
_tblcases.UseCellTheme(_tblcellinfo.Row,(int) (7),"points");
 //BA.debugLineNum = 1013;BA.debugLine="tblCases.Refresh";
_tblcases.Refresh();
 //BA.debugLineNum = 1015;BA.debugLine="Dim CurrentFields, WhereFields As Map";
_currentfields = new anywheresoftware.b4a.objects.collections.Map();
_wherefields = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 1016;BA.debugLine="CurrentFields.Initialize";
_currentfields.Initialize();
 //BA.debugLineNum = 1017;BA.debugLine="WhereFields.Initialize";
_wherefields.Initialize();
 //BA.debugLineNum = 1018;BA.debugLine="CurrentFields.Clear";
_currentfields.Clear();
 //BA.debugLineNum = 1019;BA.debugLine="WhereFields.Clear";
_wherefields.Clear();
 //BA.debugLineNum = 1021;BA.debugLine="CurrentFields.Put(\"CaseRCaseID\", ActiveCaseId)";
_currentfields.Put((Object)("CaseRCaseID"),(Object)(_activecaseid));
 //BA.debugLineNum = 1022;BA.debugLine="CurrentFields.Put(\"CaseRUserID\", UserID)";
_currentfields.Put((Object)("CaseRUserID"),(Object)(_userid));
 //BA.debugLineNum = 1023;BA.debugLine="CurrentFields.Put(\"CaseRStatus\", 1)";
_currentfields.Put((Object)("CaseRStatus"),(Object)(1));
 //BA.debugLineNum = 1026;BA.debugLine="WhereFields.Put(\"CaseRCaseID\", ActiveCaseId)";
_wherefields.Put((Object)("CaseRCaseID"),(Object)(_activecaseid));
 //BA.debugLineNum = 1027;BA.debugLine="WhereFields.Put(\"CaseRUserID\", UserID)";
_wherefields.Put((Object)("CaseRUserID"),(Object)(_userid));
 //BA.debugLineNum = 1029;BA.debugLine="Dim SQL_Select As String = DBM.BuildSelectQuery(";
_sql_select = _dbm._buildselectquery("caseread",_currentfields,_wherefields,(anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(__c.Null)));
 //BA.debugLineNum = 1030;BA.debugLine="Dim SQL_Insert As String = DBM.BuildInsertQuery(";
_sql_insert = _dbm._buildinsertquery("caseread",_currentfields);
 //BA.debugLineNum = 1031;BA.debugLine="Dim SQL_Update As String = DBM.BuildUpdateQuery(";
_sql_update = _dbm._buildupdatequery("caseread",_currentfields,_wherefields);
 //BA.debugLineNum = 1032;BA.debugLine="DBM.SQLInsertOrUpdate(SQL, SQL_Select, SQL_Inser";
_dbm._sqlinsertorupdate(_sql,_sql_select,_sql_insert,_sql_update);
 //BA.debugLineNum = 1034;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 1037;BA.debugLine="page.ShowModalSheet(\"inp\")";
_page.ShowModalSheet("inp");
 //BA.debugLineNum = 1038;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 1040;BA.debugLine="If tblCellInfo.Column = 9 Then ' delete";
if (_tblcellinfo.Column==9) { 
 //BA.debugLineNum = 1041;BA.debugLine="TypeDelete = \"Case\"";
_typedelete = "Case";
 //BA.debugLineNum = 1042;BA.debugLine="Dim msg As ABMModalSheet = page.ModalSheet(\"msg\"";
_msg = _page.ModalSheet("msg");
 //BA.debugLineNum = 1043;BA.debugLine="ActiveCaseId = tblCases.GetString(tblCellInfo.Ro";
_activecaseid = (int)(Double.parseDouble(_tblcases.GetString(_tblcellinfo.Row,(int) (0))));
 //BA.debugLineNum = 1044;BA.debugLine="Dim lbl As ABMLabel = msg.Content.Component(\"par";
_lbl = (com.ab.abmaterial.ABMLabel)(_msg.Content.Component("par1"));
 //BA.debugLineNum = 1045;BA.debugLine="lbl.Text = \"Are you sure you want to delete '\" &";
_lbl.Text = "Are you sure you want to delete '"+_tblcases.GetString(_tblcellinfo.Row,(int) (3))+"'?";
 //BA.debugLineNum = 1046;BA.debugLine="page.ShowModalSheet(\"msg\")";
_page.ShowModalSheet("msg");
 //BA.debugLineNum = 1047;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 1049;BA.debugLine="End Sub";
return "";
}
public String  _tblcases_sortchanged(String _datafield,String _order) throws Exception{
com.ab.abmaterial.ABMPagination _pagination = null;
 //BA.debugLineNum = 1058;BA.debugLine="Sub tblCases_SortChanged(DataField As String, Orde";
 //BA.debugLineNum = 1059;BA.debugLine="Select Case DataField";
switch (BA.switchObjectToInt(_datafield,"CaseType","CaseSummary","CaseStatus","CaseFixedVersion","CaseCreationDate")) {
case 0: 
case 1: 
case 2: 
case 3: 
case 4: {
 //BA.debugLineNum = 1061;BA.debugLine="LastSort = \" ORDER BY \" & DataField & \" \" & Ord";
_lastsort = " ORDER BY "+_datafield+" "+_order+" ,CaseCreationDate DESC, CaseId ";
 break; }
default: {
 //BA.debugLineNum = 1065;BA.debugLine="LastSort = \" ORDER BY CaseCreationDate DESC, Ca";
_lastsort = " ORDER BY CaseCreationDate DESC, CaseId ";
 break; }
}
;
 //BA.debugLineNum = 1068;BA.debugLine="Dim pagination As ABMPagination = page.Component(";
_pagination = (com.ab.abmaterial.ABMPagination)(_page.Component("pagination"));
 //BA.debugLineNum = 1069;BA.debugLine="LoadCases(pagination.GetActivePage())";
_loadcases(_pagination.GetActivePage());
 //BA.debugLineNum = 1070;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
com.ab.abmaterial.ABMInput _searchcase = null;
com.ab.abmaterial.ABMCombo _casestatussearch = null;
com.ab.abmaterial.ABMButton _btnsearch = null;
com.ab.abmaterial.ABMPagination _pagination = null;
com.ab.abmaterial.ABMTable _tblcases = null;
anywheresoftware.b4j.objects.SQL _sql = null;
String _nowwh = "";
String[] _split = null;
int _newh = 0;
anywheresoftware.b4a.objects.collections.List _users = null;
anywheresoftware.b4a.objects.collections.Map _user = null;
com.ab.abmaterial.ABMModalSheet _inp = null;
com.ab.abmaterial.ABMCombo _casetype = null;
 //BA.debugLineNum = 182;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 183;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 184;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 185;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 186;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 188;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 189;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 190;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 191;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 195;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 196;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 198;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 200;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 203;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 209;BA.debugLine="page.CellR(1,1).AddComponent(ABMShared.BuildPara";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraphbq(_page,"par1","Before submitting a new case, please check if it is not in the Feedback already!")));
 //BA.debugLineNum = 211;BA.debugLine="Dim searchCase As ABMInput";
_searchcase = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 212;BA.debugLine="searchCase.Initialize(page, \"searchCase\", ABM.IN";
_searchcase.Initialize(_page,"searchCase",_abm.INPUT_TEXT,"Search case",__c.False,"lightblue");
 //BA.debugLineNum = 213;BA.debugLine="page.CellR(1,1).AddComponent(searchCase)";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_searchcase));
 //BA.debugLineNum = 215;BA.debugLine="Dim casestatussearch As ABMCombo";
_casestatussearch = new com.ab.abmaterial.ABMCombo();
 //BA.debugLineNum = 216;BA.debugLine="casestatussearch.Initialize(page, \"casestatussea";
_casestatussearch.Initialize(_page,"casestatussearch","Status",(int) (650),"lightblue");
 //BA.debugLineNum = 229;BA.debugLine="casestatussearch.AddItem(\"statsearch\", \"All\", Bu";
_casestatussearch.AddItem("statsearch","All",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("SST","","{NBSP}{NBSP}All")));
 //BA.debugLineNum = 230;BA.debugLine="casestatussearch.AddItem(\"statsearch0\", \"0 - Sub";
_casestatussearch.AddItem("statsearch0","0 - Submitted",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("SST0","","{NBSP}{NBSP}0 - Submitted")));
 //BA.debugLineNum = 231;BA.debugLine="casestatussearch.AddItem(\"statsearch1\", \"1 - Clo";
_casestatussearch.AddItem("statsearch1","1 - Closed, no action",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("SST1","","{NBSP}{NBSP}1 - Closed, no action")));
 //BA.debugLineNum = 232;BA.debugLine="casestatussearch.AddItem(\"statsearch2\", \"2 - Fix";
_casestatussearch.AddItem("statsearch2","2 - Fixed",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("SST2","","{NBSP}{NBSP}2 - Fixed")));
 //BA.debugLineNum = 233;BA.debugLine="casestatussearch.AddItem(\"statsearch3\", \"3 - Imp";
_casestatussearch.AddItem("statsearch3","3 - Implemented",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("SST3","","{NBSP}{NBSP}3 - Implemented")));
 //BA.debugLineNum = 234;BA.debugLine="casestatussearch.AddItem(\"statsearch4\", \"4 - Mor";
_casestatussearch.AddItem("statsearch4","4 - More info needed",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("SST4","","{NBSP}{NBSP}4 - More info needed")));
 //BA.debugLineNum = 235;BA.debugLine="casestatussearch.AddItem(\"statsearch5\", \"5 - Con";
_casestatussearch.AddItem("statsearch5","5 - Confirmed",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("SST5","","{NBSP}{NBSP}5 - Confirmed")));
 //BA.debugLineNum = 236;BA.debugLine="casestatussearch.AddItem(\"statsearch6\", \"6 - On";
_casestatussearch.AddItem("statsearch6","6 - On hold",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("SST6","","{NBSP}{NBSP}6 - On hold")));
 //BA.debugLineNum = 237;BA.debugLine="casestatussearch.AddItem(\"statsearch7\", \"7 - Exp";
_casestatussearch.AddItem("statsearch7","7 - Expired, missing feedback",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("SST7","","{NBSP}{NBSP}7 - Expired, missing feedback")));
 //BA.debugLineNum = 238;BA.debugLine="casestatussearch.AddItem(\"statsearch8\", \"8 - Clo";
_casestatussearch.AddItem("statsearch8","8 - Closed, ask in forum",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("SST8","","{NBSP}{NBSP}8 - Closed, ask in forum")));
 //BA.debugLineNum = 239;BA.debugLine="casestatussearch.AddItem(\"statsearch9\", \"9 - Sol";
_casestatussearch.AddItem("statsearch9","9 - Solved, no action",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("SST8","","{NBSP}{NBSP}9 - Solved, no action")));
 //BA.debugLineNum = 240;BA.debugLine="casestatussearch.AddItem(\"statsearchmycases\", \"M";
_casestatussearch.AddItem("statsearchmycases","My cases",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("SSTMC","","{NBSP}{NBSP}My cases")));
 //BA.debugLineNum = 244;BA.debugLine="casestatussearch.SetActiveItemId(\"statsearch\")";
_casestatussearch.SetActiveItemId("statsearch");
 //BA.debugLineNum = 246;BA.debugLine="page.CellR(0,2).AddComponent(casestatussearch)";
_page.CellR((int) (0),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_casestatussearch));
 //BA.debugLineNum = 248;BA.debugLine="Dim btnSearch As ABMButton";
_btnsearch = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 249;BA.debugLine="btnSearch.InitializeFloating(page, \"btnSearch\",";
_btnsearch.InitializeFloating(_page,"btnSearch","mdi-action-search","");
 //BA.debugLineNum = 250;BA.debugLine="page.CellR(0,3).AddComponent(btnSearch)";
_page.CellR((int) (0),(int) (3)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnsearch));
 //BA.debugLineNum = 252;BA.debugLine="Dim pagination As ABMPagination";
_pagination = new com.ab.abmaterial.ABMPagination();
 //BA.debugLineNum = 253;BA.debugLine="pagination.Initialize(page, \"pagination\", 10, Tr";
_pagination.Initialize(_page,"pagination",(int) (10),__c.True,__c.True,"");
 //BA.debugLineNum = 254;BA.debugLine="pagination.SetTotalNumberOfPages(20)";
_pagination.SetTotalNumberOfPages((int) (20));
 //BA.debugLineNum = 256;BA.debugLine="page.CellR(1,1).AddComponent(pagination)";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_pagination));
 //BA.debugLineNum = 259;BA.debugLine="Dim tblCases As ABMTable";
_tblcases = new com.ab.abmaterial.ABMTable();
 //BA.debugLineNum = 260;BA.debugLine="tblCases.IsResponsive = True";
_tblcases.IsResponsive = __c.True;
 //BA.debugLineNum = 272;BA.debugLine="tblCases.Initialize(page, \"tblCases\", True, True";
_tblcases.Initialize(_page,"tblCases",__c.True,__c.True,__c.True,"tbltheme");
 //BA.debugLineNum = 273;BA.debugLine="tblCases.SetHeaders(         Array As String (\"I";
_tblcases.SetHeaders(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"ID","{NBSP}","Type","Summary","Status","New/Fixed in","Submit date","Notes","Open/Edit","Delete"}));
 //BA.debugLineNum = 274;BA.debugLine="tblCases.SetHeaderThemes(    Array As String (\"b";
_tblcases.SetHeaderThemes(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"bg","bg","bg","bg","bg","bg","bg","bgr","bgc","bgc"}));
 //BA.debugLineNum = 275;BA.debugLine="tblCases.SetHeaderHeights(   Array As Int    (0";
_tblcases.SetHeaderHeights(anywheresoftware.b4a.keywords.Common.ArrayToList(new int[]{(int) (0),(int) (51),(int) (0),(int) (0),(int) (0),(int) (0),(int) (0),(int) (0),(int) (48),(int) (48)}));
 //BA.debugLineNum = 276;BA.debugLine="tblCases.SetColumnVisible(   Array As Boolean(Fa";
_tblcases.SetColumnVisible(anywheresoftware.b4a.keywords.Common.ArrayToList(new boolean[]{__c.False,__c.True,__c.True,__c.True,__c.True,__c.True,__c.True,__c.True,__c.True,__c.True}));
 //BA.debugLineNum = 277;BA.debugLine="tblCases.SetColumnSortable(  Array As Boolean(Fa";
_tblcases.SetColumnSortable(anywheresoftware.b4a.keywords.Common.ArrayToList(new boolean[]{__c.False,__c.False,__c.True,__c.True,__c.True,__c.True,__c.True,__c.False,__c.False,__c.False}));
 //BA.debugLineNum = 278;BA.debugLine="tblCases.SetColumnDataFields(Array As String (\"\"";
_tblcases.SetColumnDataFields(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"","","CaseType","CaseSummary","CaseStatus","CaseFixedVersion","CaseCreationDate","","",""}));
 //BA.debugLineNum = 280;BA.debugLine="tblCases.SetFooter(\"Total number of cases: 0\", 1";
_tblcases.SetFooter((Object)("Total number of cases: 0"),(int) (12),"bg");
 //BA.debugLineNum = 282;BA.debugLine="page.CellR(1,1).AddComponent(tblCases)";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_tblcases));
 //BA.debugLineNum = 284;BA.debugLine="UserType = page.ws.Session.GetAttribute2(\"UserTy";
_usertype = BA.ObjectToString(_page.ws.getSession().GetAttribute2("UserType",(Object)("0")));
 //BA.debugLineNum = 285;BA.debugLine="UserID = page.ws.Session.GetAttribute2(\"UserID\",";
_userid = (int)(BA.ObjectToNumber(_page.ws.getSession().GetAttribute2("UserID",(Object)("0"))));
 //BA.debugLineNum = 287;BA.debugLine="Dim SQL As SQL = DBM.GetSQL";
_sql = _dbm._getsql();
 //BA.debugLineNum = 289;BA.debugLine="Dim NowWH As String = ABM.GetBrowserWidthHeight(";
_nowwh = _abm.GetBrowserWidthHeight(_page);
 //BA.debugLineNum = 290;BA.debugLine="If NowWH <> \"\" And NowWH <> \";\" Then";
if ((_nowwh).equals("") == false && (_nowwh).equals(";") == false) { 
 //BA.debugLineNum = 291;BA.debugLine="Dim split() As String = Regex.Split(\";\", NowWH)";
_split = __c.Regex.Split(";",_nowwh);
 //BA.debugLineNum = 292;BA.debugLine="Dim NewH As Int = split(1) - 350";
_newh = (int) ((double)(Double.parseDouble(_split[(int) (1)]))-350);
 //BA.debugLineNum = 293;BA.debugLine="NewH = NewH / 50";
_newh = (int) (_newh/(double)50);
 //BA.debugLineNum = 294;BA.debugLine="NewH = NewH / 5";
_newh = (int) (_newh/(double)5);
 //BA.debugLineNum = 295;BA.debugLine="NewH = NewH * 5";
_newh = (int) (_newh*5);
 //BA.debugLineNum = 296;BA.debugLine="If NewH >= 10 Then";
if (_newh>=10) { 
 //BA.debugLineNum = 297;BA.debugLine="MaxRows = NewH";
_maxrows = _newh;
 };
 };
 //BA.debugLineNum = 302;BA.debugLine="Dim users As List = DBM.SQLSelect(SQL, \"SELECT U";
_users = new anywheresoftware.b4a.objects.collections.List();
_users = _dbm._sqlselect(_sql,"SELECT UserName FROM users WHERE userId="+BA.NumberToString(_userid),(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 303;BA.debugLine="If users.Size > 0 Then";
if (_users.getSize()>0) { 
 //BA.debugLineNum = 304;BA.debugLine="Dim user As Map = users.Get(0)";
_user = new anywheresoftware.b4a.objects.collections.Map();
_user.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_users.Get((int) (0))));
 //BA.debugLineNum = 305;BA.debugLine="UserName = user.GetDefault(\"username\", \"\")";
_username = BA.ObjectToString(_user.GetDefault((Object)("username"),(Object)("")));
 };
 //BA.debugLineNum = 308;BA.debugLine="DBM.CloseSQL(SQL)";
_dbm._closesql(_sql);
 //BA.debugLineNum = 312;BA.debugLine="Dim inp As ABMModalSheet = page.ModalSheet(\"inp\"";
_inp = _page.ModalSheet("inp");
 //BA.debugLineNum = 313;BA.debugLine="Dim casetype As ABMCombo = inp.Content.Component";
_casetype = (com.ab.abmaterial.ABMCombo)(_inp.Content.Component("casetype"));
 //BA.debugLineNum = 315;BA.debugLine="casetype.Clear";
_casetype.Clear();
 //BA.debugLineNum = 317;BA.debugLine="If UserType = \"1\" Then ' administrators can acce";
if ((_usertype).equals("1")) { 
 //BA.debugLineNum = 318;BA.debugLine="page.NavigationBar.AddSideBarItem(\"Users\", \"Use";
_page.NavigationBar().AddSideBarItem("Users","Users","mdi-action-account-child","../UsersPage");
 //BA.debugLineNum = 319;BA.debugLine="casetype.AddItem(\"combo1S0\", \"[BUG]\", BuildSimp";
_casetype.AddItem("combo1S0","[BUG]",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S1","mdi-action-bug-report","{NBSP}{NBSP}[BUG]")));
 //BA.debugLineNum = 320;BA.debugLine="casetype.AddItem(\"combo1S1\", \"[WISH]\", BuildSim";
_casetype.AddItem("combo1S1","[WISH]",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S2","mdi-action-alarm-add","{NBSP}{NBSP}[WISH]")));
 //BA.debugLineNum = 321;BA.debugLine="casetype.AddItem(\"combo1S2\", \"[NEW]\", BuildSimp";
_casetype.AddItem("combo1S2","[NEW]",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S3","mdi-av-new-releases","{NBSP}{NBSP}[NEW]")));
 }else {
 //BA.debugLineNum = 323;BA.debugLine="casetype.AddItem(\"combo1S0\", \"[BUG]\", BuildSimp";
_casetype.AddItem("combo1S0","[BUG]",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S1","mdi-action-bug-report","{NBSP}{NBSP}[BUG]")));
 //BA.debugLineNum = 324;BA.debugLine="casetype.AddItem(\"combo1S1\", \"[WISH]\", BuildSim";
_casetype.AddItem("combo1S1","[WISH]",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S2","mdi-action-alarm-add","{NBSP}{NBSP}[WISH]")));
 };
 //BA.debugLineNum = 327;BA.debugLine="casetype.Refresh";
_casetype.Refresh();
 //BA.debugLineNum = 329;BA.debugLine="page.NavigationBar.Refresh";
_page.NavigationBar().Refresh();
 //BA.debugLineNum = 332;BA.debugLine="page.ws.session.SetAttribute(\"abmcallback\", Me)";
_page.ws.getSession().SetAttribute("abmcallback",this);
 //BA.debugLineNum = 333;BA.debugLine="page.ws.session.SetAttribute(\"abmdownloadfolder\"";
_page.ws.getSession().SetAttribute("abmdownloadfolder",(Object)(_downloadfolder));
 //BA.debugLineNum = 334;BA.debugLine="page.ws.session.SetAttribute(\"abmmaxsize\", Downl";
_page.ws.getSession().SetAttribute("abmmaxsize",(Object)(_downloadmaxsize));
 //BA.debugLineNum = 336;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 339;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 342;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 345;BA.debugLine="LoadCases(1)";
_loadcases((int) (1));
 };
 //BA.debugLineNum = 347;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 348;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 350;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 351;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 352;BA.debugLine="Try";
try { //BA.debugLineNum = 354;BA.debugLine="ws.Session.RemoveAttribute(\"abmcallback\")";
_ws.getSession().RemoveAttribute("abmcallback");
 //BA.debugLineNum = 355;BA.debugLine="ws.Session.RemoveAttribute(\"abmdownloadfolder\")";
_ws.getSession().RemoveAttribute("abmdownloadfolder");
 //BA.debugLineNum = 356;BA.debugLine="ws.Session.RemoveAttribute(\"abmmaxsize\")";
_ws.getSession().RemoveAttribute("abmmaxsize");
 } 
       catch (Exception e7) {
			ba.setLastException(e7); //BA.debugLineNum = 358;BA.debugLine="Log(LastException.Message)";
__c.Log(__c.LastException(ba).getMessage());
 };
 //BA.debugLineNum = 360;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "PAGE_FILEUPLOADED"))
	return _page_fileuploaded((String) args[0], (Boolean) args[1]);
return BA.SubDelegator.SubNotFound;
}
}
