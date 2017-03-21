package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class comptreetablepage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.comptreetablepage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.comptreetablepage.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.collections.Map _plusparents = null;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public static class _plusstructure{
public boolean IsInitialized;
public String Prefix;
public int NextValue;
public void Initialize() {
IsInitialized = true;
Prefix = "";
NextValue = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _btndelete_clicked(String _target) throws Exception{
String _currrow = "";
com.ab.abmaterial.ABMTreeTable _view1 = null;
 //BA.debugLineNum = 592;BA.debugLine="Sub btnDelete_Clicked(Target As String)";
 //BA.debugLineNum = 594;BA.debugLine="Dim currRow As String = ABMShared.Mid2(Target, 10";
_currrow = _abmshared._mid2(_target,(int) (10));
 //BA.debugLineNum = 595;BA.debugLine="Log(\"btnDelete: \" & currRow)";
__c.Log("btnDelete: "+_currrow);
 //BA.debugLineNum = 601;BA.debugLine="Dim view1 As ABMTreeTable = page.Component(\"view1";
_view1 = (com.ab.abmaterial.ABMTreeTable)(_page.Component("view1"));
 //BA.debugLineNum = 602;BA.debugLine="view1.RemoveRow(currRow)";
_view1.RemoveRow(_currrow);
 //BA.debugLineNum = 604;BA.debugLine="view1.Refresh";
_view1.Refresh();
 //BA.debugLineNum = 605;BA.debugLine="End Sub";
return "";
}
public String  _btnedit_clicked(String _target) throws Exception{
String _currrow = "";
com.ab.abmaterial.ABMTreeTable _view1 = null;
 //BA.debugLineNum = 577;BA.debugLine="Sub btnEdit_Clicked(Target As String)";
 //BA.debugLineNum = 579;BA.debugLine="Dim currRow As String = ABMShared.Mid2(Target, 8)";
_currrow = _abmshared._mid2(_target,(int) (8));
 //BA.debugLineNum = 580;BA.debugLine="Log(\"btnEdit: \" & currRow)";
__c.Log("btnEdit: "+_currrow);
 //BA.debugLineNum = 585;BA.debugLine="Dim view1 As ABMTreeTable = page.Component(\"view1";
_view1 = (com.ab.abmaterial.ABMTreeTable)(_page.Component("view1"));
 //BA.debugLineNum = 586;BA.debugLine="DateTime.timeFormat = \"HH:mm:ss\"";
__c.DateTime.setTimeFormat("HH:mm:ss");
 //BA.debugLineNum = 587;BA.debugLine="view1.SetString(currRow, 2, DateTime.time(DateTim";
_view1.SetString(_currrow,(int) (2),__c.DateTime.Time(__c.DateTime.getNow()));
 //BA.debugLineNum = 589;BA.debugLine="view1.Refresh";
_view1.Refresh();
 //BA.debugLineNum = 590;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMTreeTableRow  _buildlev1footer(int _depth,String _treerowid,String _treerowparentid,String _isfooterforid) throws Exception{
com.ab.abmaterial.ABMTreeTableRow _l = null;
com.ab.abmaterial.ABMTreeTableCell _cell1 = null;
 //BA.debugLineNum = 336;BA.debugLine="Sub BuildLev1Footer(depth As Int, treeRowId As Str";
 //BA.debugLineNum = 337;BA.debugLine="Dim l As ABMtreeTableRow";
_l = new com.ab.abmaterial.ABMTreeTableRow();
 //BA.debugLineNum = 338;BA.debugLine="l.Initialize(depth, treeRowId, treeRowParentId, I";
_l.Initialize(_depth,_treerowid,_treerowparentid,_isfooterforid,"","white","");
 //BA.debugLineNum = 339;BA.debugLine="Dim cell1 As ABMTreeTableCell";
_cell1 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 340;BA.debugLine="cell1.InitalizeAsIcon(\"v1_\" & treeRowId & \"c1\", \"";
_cell1.InitalizeAsIcon("v1_"+_treerowid+"c1","","",(int) (3),(int) (3),"");
 //BA.debugLineNum = 341;BA.debugLine="l.addcell(cell1)";
_l.AddCell(_cell1);
 //BA.debugLineNum = 342;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 343;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTreeTableRow  _buildlev1header(int _depth,String _treerowid,String _treerowparentid,String _isfooterforid,String _stad) throws Exception{
com.ab.abmaterial.ABMTreeTableRow _l = null;
com.ab.abmaterial.ABMTreeTableCell _cell1 = null;
 //BA.debugLineNum = 327;BA.debugLine="Sub BuildLev1Header(depth As Int, treeRowId As Str";
 //BA.debugLineNum = 328;BA.debugLine="Dim l As ABMtreeTableRow";
_l = new com.ab.abmaterial.ABMTreeTableRow();
 //BA.debugLineNum = 329;BA.debugLine="l.Initialize(depth, treeRowId, treeRowParentId, I";
_l.Initialize(_depth,_treerowid,_treerowparentid,_isfooterforid,"","white","");
 //BA.debugLineNum = 330;BA.debugLine="Dim cell1 As ABMTreeTableCell";
_cell1 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 331;BA.debugLine="cell1.Initalize(\"v1_\" & treeRowId & \"c1\", Stad, 1";
_cell1.Initalize("v1_"+_treerowid+"c1",_stad,(int) (1),(int) (24),__c.False,"");
 //BA.debugLineNum = 332;BA.debugLine="l.Addcell(cell1)";
_l.AddCell(_cell1);
 //BA.debugLineNum = 333;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 334;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTreeTableRow  _buildlev2footer(int _depth,String _treerowid,String _treerowparentid,String _isfooterforid) throws Exception{
com.ab.abmaterial.ABMTreeTableRow _l = null;
com.ab.abmaterial.ABMTreeTableCell _cell1 = null;
 //BA.debugLineNum = 357;BA.debugLine="Sub BuildLev2Footer(depth As Int, treeRowId As Str";
 //BA.debugLineNum = 358;BA.debugLine="Dim l As ABMtreeTableRow";
_l = new com.ab.abmaterial.ABMTreeTableRow();
 //BA.debugLineNum = 359;BA.debugLine="l.Initialize(depth, treeRowId, treeRowParentId, I";
_l.Initialize(_depth,_treerowid,_treerowparentid,_isfooterforid,"","","");
 //BA.debugLineNum = 360;BA.debugLine="Dim cell1 As ABMTreeTableCell";
_cell1 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 361;BA.debugLine="cell1.InitalizeAsIcon(\"v1_\" & treeRowId & \"c1\", \"";
_cell1.InitalizeAsIcon("v1_"+_treerowid+"c1","mdi-content-add","",(int) (4),(int) (3),"");
 //BA.debugLineNum = 362;BA.debugLine="l.addcell(cell1)";
_l.AddCell(_cell1);
 //BA.debugLineNum = 363;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 364;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTreeTableRow  _buildlev2header1(int _depth,String _treerowid,String _treerowparentid,String _isfooterforid,String _straat,String _datum) throws Exception{
com.ab.abmaterial.ABMTreeTableRow _l = null;
com.ab.abmaterial.ABMTreeTableCell _cell1 = null;
com.ab.abmaterial.ABMTreeTableCell _cell2 = null;
 //BA.debugLineNum = 345;BA.debugLine="Sub BuildLev2Header1(depth As Int, treeRowId As St";
 //BA.debugLineNum = 346;BA.debugLine="Dim l As ABMtreeTableRow";
_l = new com.ab.abmaterial.ABMTreeTableRow();
 //BA.debugLineNum = 347;BA.debugLine="l.Initialize(depth, treeRowId, treeRowParentId, I";
_l.Initialize(_depth,_treerowid,_treerowparentid,_isfooterforid,"","","");
 //BA.debugLineNum = 348;BA.debugLine="Dim cell1 As ABMTreeTableCell";
_cell1 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 349;BA.debugLine="cell1.Initalize(\"v1_\" & treeRowId & \"c1\", Straat,";
_cell1.Initalize("v1_"+_treerowid+"c1",_straat,(int) (2),(int) (12),__c.False,"");
 //BA.debugLineNum = 350;BA.debugLine="l.addcell(cell1)";
_l.AddCell(_cell1);
 //BA.debugLineNum = 351;BA.debugLine="Dim cell2 As ABMTreeTableCell";
_cell2 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 352;BA.debugLine="cell2.Initalize(\"v1_\" & treeRowId & \"c2\", Datum,";
_cell2.Initalize("v1_"+_treerowid+"c2",_datum,(int) (14),(int) (10),__c.False,"");
 //BA.debugLineNum = 353;BA.debugLine="l.addcell(cell2)";
_l.AddCell(_cell2);
 //BA.debugLineNum = 354;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 355;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTreeTableRow  _buildlev3footer1(int _depth,String _treerowid,String _treerowparentid,String _isfooterforid,String _pers,String _time,String _overruletheme) throws Exception{
com.ab.abmaterial.ABMTreeTableRow _l = null;
com.ab.abmaterial.ABMTreeTableCell _cell1 = null;
com.ab.abmaterial.ABMTreeTableCell _cell2 = null;
 //BA.debugLineNum = 379;BA.debugLine="Sub BuildLev3Footer1(depth As Int, treeRowId As St";
 //BA.debugLineNum = 380;BA.debugLine="Dim l As ABMtreeTableRow";
_l = new com.ab.abmaterial.ABMTreeTableRow();
 //BA.debugLineNum = 381;BA.debugLine="l.Initialize(depth, treeRowId, treeRowParentId, I";
_l.Initialize(_depth,_treerowid,_treerowparentid,_isfooterforid,"","",_overruletheme);
 //BA.debugLineNum = 382;BA.debugLine="Dim cell1 As ABMTreeTableCell";
_cell1 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 383;BA.debugLine="cell1.Initalize(\"v1_\" & treeRowId & \"c1\", pers, 4";
_cell1.Initalize("v1_"+_treerowid+"c1",_pers,(int) (4),(int) (3),__c.False,"");
 //BA.debugLineNum = 384;BA.debugLine="l.Addcell(cell1)";
_l.AddCell(_cell1);
 //BA.debugLineNum = 385;BA.debugLine="Dim cell2 As ABMTreeTableCell";
_cell2 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 386;BA.debugLine="cell2.Initalize(\"v1_\" & treeRowId & \"c2\", time, 1";
_cell2.Initalize("v1_"+_treerowid+"c2",_time,(int) (16),(int) (4),__c.False,"");
 //BA.debugLineNum = 387;BA.debugLine="l.Addcell(cell2)";
_l.AddCell(_cell2);
 //BA.debugLineNum = 388;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 389;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTreeTableRow  _buildlev3footer2(int _depth,String _treerowid,String _treerowparentid,String _isfooterforid,String _overruletheme) throws Exception{
com.ab.abmaterial.ABMTreeTableRow _l = null;
com.ab.abmaterial.ABMTreeTableCell _cell1 = null;
 //BA.debugLineNum = 391;BA.debugLine="Sub BuildLev3Footer2(depth As Int, treeRowId As St";
 //BA.debugLineNum = 392;BA.debugLine="Dim l As ABMtreeTableRow";
_l = new com.ab.abmaterial.ABMTreeTableRow();
 //BA.debugLineNum = 393;BA.debugLine="l.Initialize(depth, treeRowId, treeRowParentId, I";
_l.Initialize(_depth,_treerowid,_treerowparentid,_isfooterforid,"","",_overruletheme);
 //BA.debugLineNum = 394;BA.debugLine="Dim cell1 As ABMTreeTableCell";
_cell1 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 395;BA.debugLine="cell1.Initalize(\"v1_\" & treeRowId & \"c1\", \"\", 4,3";
_cell1.Initalize("v1_"+_treerowid+"c1","",(int) (4),(int) (3),__c.False,"");
 //BA.debugLineNum = 396;BA.debugLine="l.Addcell(cell1)";
_l.AddCell(_cell1);
 //BA.debugLineNum = 397;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTreeTableRow  _buildlev3header(int _depth,String _treerowid,String _treerowparentid,String _isfooterforid,String _soort,anywheresoftware.b4a.objects.collections.List _dragdropnames,String _overruletheme,int _sortindex) throws Exception{
com.ab.abmaterial.ABMTreeTableRow _l = null;
com.ab.abmaterial.ABMTreeTableCell _cell1 = null;
 //BA.debugLineNum = 366;BA.debugLine="Sub BuildLev3Header(depth As Int, treeRowId As Str";
 //BA.debugLineNum = 367;BA.debugLine="Dim l As ABMtreeTableRow";
_l = new com.ab.abmaterial.ABMTreeTableRow();
 //BA.debugLineNum = 368;BA.debugLine="l.Initialize(depth, treeRowId, treeRowParentId, I";
_l.Initialize(_depth,_treerowid,_treerowparentid,_isfooterforid,"","",_overruletheme);
 //BA.debugLineNum = 369;BA.debugLine="If sortIndex > 0 Then";
if (_sortindex>0) { 
 //BA.debugLineNum = 370;BA.debugLine="l.SortChildrenOn(sortIndex)";
_l.SortChildrenOn(_sortindex);
 };
 //BA.debugLineNum = 372;BA.debugLine="l.SetCanReceiveDropsFrom(DragDropNames)";
_l.SetCanReceiveDropsFrom(_dragdropnames);
 //BA.debugLineNum = 373;BA.debugLine="Dim cell1 As ABMTreeTableCell";
_cell1 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 374;BA.debugLine="cell1.Initalize(\"v1_\" & treeRowId & \"c1\", soort,";
_cell1.Initalize("v1_"+_treerowid+"c1",_soort,(int) (3),(int) (21),__c.False,"");
 //BA.debugLineNum = 375;BA.debugLine="l.Addcell(cell1)";
_l.AddCell(_cell1);
 //BA.debugLineNum = 376;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 377;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTreeTableRow  _buildlev4body1(int _depth,String _treerowid,String _treerowparentid,String _isfooterforid,String _code,String _naam,String _hours) throws Exception{
com.ab.abmaterial.ABMTreeTableRow _l = null;
com.ab.abmaterial.ABMTreeTableCell _cell1 = null;
com.ab.abmaterial.ABMTreeTableCell _cell2 = null;
com.ab.abmaterial.ABMTreeTableCell _cell3 = null;
com.ab.abmaterial.ABMTreeTableCell _cell4 = null;
com.ab.abmaterial.ABMButton _btnedit = null;
com.ab.abmaterial.ABMTreeTableCell _cell5 = null;
com.ab.abmaterial.ABMButton _btndelete = null;
 //BA.debugLineNum = 401;BA.debugLine="Sub BuildLev4Body1(depth As Int, treeRowId As Stri";
 //BA.debugLineNum = 402;BA.debugLine="Dim l As ABMtreeTableRow";
_l = new com.ab.abmaterial.ABMTreeTableRow();
 //BA.debugLineNum = 403;BA.debugLine="l.Initialize(depth, treeRowId, treeRowParentId, I";
_l.Initialize(_depth,_treerowid,_treerowparentid,_isfooterforid,"HOUR","","");
 //BA.debugLineNum = 404;BA.debugLine="Dim cell1 As ABMTreeTableCell";
_cell1 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 405;BA.debugLine="cell1.Initalize(\"v1_\" & treeRowId & \"c1\", Code, 4";
_cell1.Initalize("v1_"+_treerowid+"c1",_code,(int) (4),(int) (3),__c.False,"");
 //BA.debugLineNum = 406;BA.debugLine="l.Addcell(cell1)";
_l.AddCell(_cell1);
 //BA.debugLineNum = 407;BA.debugLine="Dim cell2 As ABMTreeTableCell";
_cell2 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 408;BA.debugLine="cell2.Initalize(\"v1_\" & treeRowId & \"c2\", Naam, 8";
_cell2.Initalize("v1_"+_treerowid+"c2",_naam,(int) (8),(int) (6),__c.False,"");
 //BA.debugLineNum = 409;BA.debugLine="l.Addcell(cell2)";
_l.AddCell(_cell2);
 //BA.debugLineNum = 410;BA.debugLine="Dim cell3 As ABMTreeTableCell";
_cell3 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 411;BA.debugLine="cell3.Initalize(\"v1_\" & treeRowId & \"c3\", Hours,";
_cell3.Initalize("v1_"+_treerowid+"c3",_hours,(int) (15),(int) (2),__c.False,"");
 //BA.debugLineNum = 412;BA.debugLine="l.Addcell(cell3)";
_l.AddCell(_cell3);
 //BA.debugLineNum = 414;BA.debugLine="Dim cell4 As ABMTreeTableCell";
_cell4 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 415;BA.debugLine="Dim btnEdit As ABMButton";
_btnedit = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 416;BA.debugLine="btnEdit.InitializeFloating(page, treeRowId, \"mdi-";
_btnedit.InitializeFloating(_page,_treerowid,"mdi-action-visibility","");
 //BA.debugLineNum = 417;BA.debugLine="btnEdit.size = ABM.BUTTONSIZE_SMALL";
_btnedit.Size = _abm.BUTTONSIZE_SMALL;
 //BA.debugLineNum = 418;BA.debugLine="cell4.InitalizeAsComponent(\"v1_\" & treeRowId & \"c";
_cell4.InitalizeAsComponent("v1_"+_treerowid+"cEdit",(com.ab.abmaterial.ABMComponent)(_btnedit),"btnEdit",(int) (18),(int) (1),"");
 //BA.debugLineNum = 419;BA.debugLine="l.Addcell(cell4)";
_l.AddCell(_cell4);
 //BA.debugLineNum = 421;BA.debugLine="Dim cell5 As ABMTreeTableCell";
_cell5 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 422;BA.debugLine="Dim btnDelete As ABMButton";
_btndelete = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 423;BA.debugLine="btnDelete.InitializeFloating(page, treeRowId, \"md";
_btndelete.InitializeFloating(_page,_treerowid,"mdi-action-delete","");
 //BA.debugLineNum = 424;BA.debugLine="btnDelete.size = ABM.BUTTONSIZE_SMALL";
_btndelete.Size = _abm.BUTTONSIZE_SMALL;
 //BA.debugLineNum = 425;BA.debugLine="cell5.InitalizeAsComponent(\"v1_\" & treeRowId & \"c";
_cell5.InitalizeAsComponent("v1_"+_treerowid+"cDelete",(com.ab.abmaterial.ABMComponent)(_btndelete),"btnDelete",(int) (19),(int) (1),"");
 //BA.debugLineNum = 426;BA.debugLine="l.Addcell(cell5)";
_l.AddCell(_cell5);
 //BA.debugLineNum = 428;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 429;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTreeTableRow  _buildlev4body2(int _depth,String _treerowid,String _treerowparentid,String _isfooterforid,String _artikel) throws Exception{
com.ab.abmaterial.ABMTreeTableRow _l = null;
com.ab.abmaterial.ABMTreeTableCell _cell1 = null;
 //BA.debugLineNum = 431;BA.debugLine="Sub BuildLev4Body2(depth As Int, treeRowId As Stri";
 //BA.debugLineNum = 432;BA.debugLine="Dim l As ABMtreeTableRow";
_l = new com.ab.abmaterial.ABMTreeTableRow();
 //BA.debugLineNum = 433;BA.debugLine="l.Initialize(depth, treeRowId, treeRowParentId, I";
_l.Initialize(_depth,_treerowid,_treerowparentid,_isfooterforid,"DONE","","");
 //BA.debugLineNum = 434;BA.debugLine="Dim cell1 As ABMTreeTableCell";
_cell1 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 435;BA.debugLine="cell1.Initalize(\"v1_\" & treeRowId & \"c1\", Artikel";
_cell1.Initalize("v1_"+_treerowid+"c1",_artikel,(int) (4),(int) (19),__c.False,"");
 //BA.debugLineNum = 436;BA.debugLine="l.Addcell(cell1)";
_l.AddCell(_cell1);
 //BA.debugLineNum = 437;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 438;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTreeTableRow  _buildlev4body3(int _depth,String _treerowid,String _treerowparentid,String _isfooterforid,String _artikel,String _aantal,String _eenheid) throws Exception{
com.ab.abmaterial.ABMTreeTableRow _l = null;
com.ab.abmaterial.ABMTreeTableCell _cell1 = null;
com.ab.abmaterial.ABMTreeTableCell _cell2 = null;
com.ab.abmaterial.ABMTreeTableCell _cell3 = null;
 //BA.debugLineNum = 440;BA.debugLine="Sub BuildLev4Body3(depth As Int, treeRowId As Stri";
 //BA.debugLineNum = 441;BA.debugLine="Dim l As ABMtreeTableRow";
_l = new com.ab.abmaterial.ABMTreeTableRow();
 //BA.debugLineNum = 442;BA.debugLine="l.Initialize(depth, treeRowId, treeRowParentId, I";
_l.Initialize(_depth,_treerowid,_treerowparentid,_isfooterforid,"","","");
 //BA.debugLineNum = 443;BA.debugLine="Dim cell1 As ABMTreeTableCell";
_cell1 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 444;BA.debugLine="cell1.Initalize(\"v1_\" & treeRowId & \"c1\", Artikel";
_cell1.Initalize("v1_"+_treerowid+"c1",_artikel,(int) (4),(int) (9),__c.False,"");
 //BA.debugLineNum = 445;BA.debugLine="l.Addcell(cell1)";
_l.AddCell(_cell1);
 //BA.debugLineNum = 446;BA.debugLine="Dim cell2 As ABMTreeTableCell";
_cell2 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 447;BA.debugLine="cell2.Initalize(\"v1_\" & treeRowId & \"c2\", aantal,";
_cell2.Initalize("v1_"+_treerowid+"c2",_aantal,(int) (15),(int) (2),__c.False,"lev4right");
 //BA.debugLineNum = 448;BA.debugLine="l.Addcell(cell2)";
_l.AddCell(_cell2);
 //BA.debugLineNum = 449;BA.debugLine="Dim cell3 As ABMTreeTableCell";
_cell3 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 450;BA.debugLine="cell3.Initalize(\"v1_\" & treeRowId & \"c3\", eenheid";
_cell3.Initalize("v1_"+_treerowid+"c3",_eenheid,(int) (17),(int) (3),__c.False,"lev4orange");
 //BA.debugLineNum = 451;BA.debugLine="l.Addcell(cell3)";
_l.AddCell(_cell3);
 //BA.debugLineNum = 452;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 453;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTreeTableRow  _buildlev4body4(int _depth,String _treerowid,String _treerowparentid,String _isfooterforid,anywheresoftware.b4a.objects.collections.List _values1,anywheresoftware.b4a.objects.collections.List _values2) throws Exception{
com.ab.abmaterial.ABMChart _chart1 = null;
com.ab.abmaterial.ABMChartSerie _seriea = null;
com.ab.abmaterial.ABMChartSerie _seriec = null;
com.ab.abmaterial.ABMTreeTableRow _l = null;
com.ab.abmaterial.ABMTreeTableCell _cell1 = null;
 //BA.debugLineNum = 455;BA.debugLine="Sub BuildLev4Body4(depth As Int, treeRowId As Stri";
 //BA.debugLineNum = 457;BA.debugLine="Dim chart1 As ABMChart";
_chart1 = new com.ab.abmaterial.ABMChart();
 //BA.debugLineNum = 458;BA.debugLine="chart1.Initialize(page, treeRowId, ABM.CHART_TYPE";
_chart1.Initialize(_page,_treerowid,_abm.CHART_TYPELINE,_abm.CHART_RATIO_GOLDENSECTION,"chart1theme");
 //BA.debugLineNum = 461;BA.debugLine="chart1.AddLabels(Array As String(\"Mon\", \"The\", \"W";
_chart1.AddLabels(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Mon","The","Wed","Thu","Fri","Sat","Sun"}));
 //BA.debugLineNum = 463;BA.debugLine="chart1.OptionsLine.FullWidth=True";
_chart1.OptionsLine().FullWidth = __c.True;
 //BA.debugLineNum = 464;BA.debugLine="chart1.OptionsLine.ChartPaddingRight=60 ' because";
_chart1.OptionsLine().ChartPaddingRight = (int) (60);
 //BA.debugLineNum = 465;BA.debugLine="chart1.OptionsLine.Serie(ABM.CHART_SERIEINDEX_A).";
_chart1.OptionsLine().Serie(_abm.CHART_SERIEINDEX_A).LineSmooth = _abm.CHART_LINESMOOTH_NONE;
 //BA.debugLineNum = 466;BA.debugLine="chart1.OptionsLine.Serie(ABM.CHART_SERIEINDEX_C).";
_chart1.OptionsLine().Serie(_abm.CHART_SERIEINDEX_C).LineSmooth = _abm.CHART_LINESMOOTH_SIMPLE;
 //BA.debugLineNum = 467;BA.debugLine="chart1.OptionsLine.Serie(ABM.CHART_SERIEINDEX_C).";
_chart1.OptionsLine().Serie(_abm.CHART_SERIEINDEX_C).ShowArea = __c.True;
 //BA.debugLineNum = 470;BA.debugLine="Dim SerieA As ABMChartSerie";
_seriea = new com.ab.abmaterial.ABMChartSerie();
 //BA.debugLineNum = 471;BA.debugLine="SerieA.InitializeForLine(ABM.CHART_SERIEINDEX_A)";
_seriea.InitializeForLine(_abm.CHART_SERIEINDEX_A);
 //BA.debugLineNum = 472;BA.debugLine="SerieA.SetValues(values1)";
_seriea.SetValues(_values1);
 //BA.debugLineNum = 473;BA.debugLine="chart1.AddSerie(SerieA)";
_chart1.AddSerie(_seriea);
 //BA.debugLineNum = 475;BA.debugLine="Dim SerieC As ABMChartSerie";
_seriec = new com.ab.abmaterial.ABMChartSerie();
 //BA.debugLineNum = 476;BA.debugLine="SerieC.InitializeForLine(ABM.CHART_SERIEINDEX_C)";
_seriec.InitializeForLine(_abm.CHART_SERIEINDEX_C);
 //BA.debugLineNum = 477;BA.debugLine="SerieC.SetValues(values2)";
_seriec.SetValues(_values2);
 //BA.debugLineNum = 478;BA.debugLine="chart1.AddSerie(SerieC)";
_chart1.AddSerie(_seriec);
 //BA.debugLineNum = 480;BA.debugLine="Dim l As ABMtreeTableRow";
_l = new com.ab.abmaterial.ABMTreeTableRow();
 //BA.debugLineNum = 481;BA.debugLine="l.Initialize(depth, treeRowId, treeRowParentId, I";
_l.Initialize(_depth,_treerowid,_treerowparentid,_isfooterforid,"","","");
 //BA.debugLineNum = 482;BA.debugLine="Dim cell1 As ABMTreeTableCell";
_cell1 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 483;BA.debugLine="cell1.InitalizeAsComponent(\"v1_\" & treeRowId & \"c";
_cell1.InitalizeAsComponent("v1_"+_treerowid+"c1",(com.ab.abmaterial.ABMComponent)(_chart1),"chart1",(int) (4),(int) (19),"");
 //BA.debugLineNum = 484;BA.debugLine="l.Addcell(cell1)";
_l.AddCell(_cell1);
 //BA.debugLineNum = 485;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 486;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTreeTableRow  _buildlev4body5(int _depth,String _treerowid,String _treerowparentid,String _isfooterforid,double _lat,double _lng) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
com.ab.abmaterial.ABMTreeTableRow _l = null;
com.ab.abmaterial.ABMTreeTableCell _cell1 = null;
 //BA.debugLineNum = 488;BA.debugLine="Sub BuildLev4Body5(depth As Int, treeRowId As Stri";
 //BA.debugLineNum = 490;BA.debugLine="Dim gm1 As ABMGoogleMap";
_gm1 = new com.ab.abmaterial.ABMGoogleMap();
 //BA.debugLineNum = 491;BA.debugLine="gm1.Initialize(page, treeRowId, lat, lng, 15, 350";
_gm1.Initialize(_page,_treerowid,_lat,_lng,(int) (15),(int) (350),_abm.GOOGLEMAPTYPE_ROADMAP);
 //BA.debugLineNum = 492;BA.debugLine="gm1.Draggable = False";
_gm1.Draggable = __c.False;
 //BA.debugLineNum = 493;BA.debugLine="gm1.HasMapTypeControl = True";
_gm1.HasMapTypeControl = __c.True;
 //BA.debugLineNum = 494;BA.debugLine="gm1.HasStreetViewControl = True";
_gm1.HasStreetViewControl = __c.True;
 //BA.debugLineNum = 495;BA.debugLine="gm1.HasZoomControl = True";
_gm1.HasZoomControl = __c.True;
 //BA.debugLineNum = 496;BA.debugLine="gm1.AddMapType(ABM.GOOGLEMAPTYPE_ROADMAP)";
_gm1.AddMapType(_abm.GOOGLEMAPTYPE_ROADMAP);
 //BA.debugLineNum = 497;BA.debugLine="gm1.AddMapType(ABM.GOOGLEMAPTYPE_TERRAIN)";
_gm1.AddMapType(_abm.GOOGLEMAPTYPE_TERRAIN);
 //BA.debugLineNum = 498;BA.debugLine="gm1.AddMapType(ABM.GOOGLEMAPTYPE_HYBRID)";
_gm1.AddMapType(_abm.GOOGLEMAPTYPE_HYBRID);
 //BA.debugLineNum = 499;BA.debugLine="gm1.AddMapType(ABM.GOOGLEMAPTYPE_SATELLITE)";
_gm1.AddMapType(_abm.GOOGLEMAPTYPE_SATELLITE);
 //BA.debugLineNum = 501;BA.debugLine="Dim l As ABMtreeTableRow";
_l = new com.ab.abmaterial.ABMTreeTableRow();
 //BA.debugLineNum = 502;BA.debugLine="l.Initialize(depth, treeRowId, treeRowParentId, I";
_l.Initialize(_depth,_treerowid,_treerowparentid,_isfooterforid,"","","");
 //BA.debugLineNum = 503;BA.debugLine="Dim cell1 As ABMTreeTableCell";
_cell1 = new com.ab.abmaterial.ABMTreeTableCell();
 //BA.debugLineNum = 504;BA.debugLine="cell1.InitalizeAsComponent(\"v1_\" & treeRowId & \"g";
_cell1.InitalizeAsComponent("v1_"+_treerowid+"g1",(com.ab.abmaterial.ABMComponent)(_gm1),"gm1",(int) (4),(int) (19),"");
 //BA.debugLineNum = 505;BA.debugLine="l.Addcell(cell1)";
_l.AddCell(_cell1);
 //BA.debugLineNum = 506;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 507;BA.debugLine="End Sub";
return null;
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 258;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 260;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 263;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 264;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 265;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 266;BA.debugLine="page.PageTitle = \"ABMTreeTable\"";
_page.PageTitle = "ABMTreeTable";
 //BA.debugLineNum = 267;BA.debugLine="page.PageDescription = \"The tree table component";
_page.PageDescription = "The tree table component ";
 //BA.debugLineNum = 268;BA.debugLine="page.PageHTMLName = \"abmaterial-tree-table.html\"";
_page.PageHTMLName = "abmaterial-tree-table.html";
 //BA.debugLineNum = 269;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 270;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 271;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 274;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 277;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMTreeTable\"";
_abmshared._buildnavigationbar(_page,"ABMTreeTable","../images/logo.png","","Controls","ABMTreeTable");
 //BA.debugLineNum = 280;BA.debugLine="page.AddRows(6,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (6),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 281;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 286;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 287;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 200;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 202;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 203;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 206;BA.debugLine="theme.AddTreeTableTheme(\"view1\")";
_theme.AddTreeTableTheme("view1");
 //BA.debugLineNum = 207;BA.debugLine="theme.TreeTable(\"view1\").AddCellTheme(\"lev1defaul";
_theme.TreeTable("view1").AddCellTheme("lev1default");
 //BA.debugLineNum = 209;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev1default\").Back";
_theme.TreeTable("view1").Cell("lev1default").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 210;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev1default\").Back";
_theme.TreeTable("view1").Cell("lev1default").BackColorIntensity = _abm.INTENSITY_DARKEN3;
 //BA.debugLineNum = 211;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev1default\").Fore";
_theme.TreeTable("view1").Cell("lev1default").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 212;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev1default\").IsEd";
_theme.TreeTable("view1").Cell("lev1default").IsEditable = __c.True;
 //BA.debugLineNum = 214;BA.debugLine="theme.TreeTable(\"view1\").AddCellTheme(\"lev2defaul";
_theme.TreeTable("view1").AddCellTheme("lev2default");
 //BA.debugLineNum = 215;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev2default\").Back";
_theme.TreeTable("view1").Cell("lev2default").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 216;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev2default\").Back";
_theme.TreeTable("view1").Cell("lev2default").BackColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 218;BA.debugLine="theme.TreeTable(\"view1\").AddCellTheme(\"lev3defaul";
_theme.TreeTable("view1").AddCellTheme("lev3default");
 //BA.debugLineNum = 219;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev3default\").Back";
_theme.TreeTable("view1").Cell("lev3default").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 220;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev3default\").Back";
_theme.TreeTable("view1").Cell("lev3default").BackColorIntensity = _abm.INTENSITY_LIGHTEN4;
 //BA.debugLineNum = 222;BA.debugLine="theme.TreeTable(\"view1\").AddCellTheme(\"lev3hour\")";
_theme.TreeTable("view1").AddCellTheme("lev3hour");
 //BA.debugLineNum = 223;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev3hour\").BackCol";
_theme.TreeTable("view1").Cell("lev3hour").BackColor = _abm.COLOR_LIGHTGREEN;
 //BA.debugLineNum = 224;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev3hour\").BackCol";
_theme.TreeTable("view1").Cell("lev3hour").BackColorIntensity = _abm.INTENSITY_LIGHTEN4;
 //BA.debugLineNum = 226;BA.debugLine="theme.TreeTable(\"view1\").AddCellTheme(\"lev3done\")";
_theme.TreeTable("view1").AddCellTheme("lev3done");
 //BA.debugLineNum = 227;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev3done\").BackCol";
_theme.TreeTable("view1").Cell("lev3done").BackColor = _abm.COLOR_ORANGE;
 //BA.debugLineNum = 228;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev3done\").BackCol";
_theme.TreeTable("view1").Cell("lev3done").BackColorIntensity = _abm.INTENSITY_LIGHTEN4;
 //BA.debugLineNum = 230;BA.debugLine="theme.TreeTable(\"view1\").AddCellTheme(\"lev3device";
_theme.TreeTable("view1").AddCellTheme("lev3devices");
 //BA.debugLineNum = 231;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev3devices\").Back";
_theme.TreeTable("view1").Cell("lev3devices").BackColor = _abm.COLOR_PURPLE;
 //BA.debugLineNum = 232;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev3devices\").Back";
_theme.TreeTable("view1").Cell("lev3devices").BackColorIntensity = _abm.INTENSITY_LIGHTEN4;
 //BA.debugLineNum = 234;BA.debugLine="theme.TreeTable(\"view1\").AddCellTheme(\"lev4defaul";
_theme.TreeTable("view1").AddCellTheme("lev4default");
 //BA.debugLineNum = 235;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev4default\").Back";
_theme.TreeTable("view1").Cell("lev4default").BackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 237;BA.debugLine="theme.TreeTable(\"view1\").AddCellTheme(\"lev4right\"";
_theme.TreeTable("view1").AddCellTheme("lev4right");
 //BA.debugLineNum = 238;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev4right\").BackCo";
_theme.TreeTable("view1").Cell("lev4right").BackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 239;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev4right\").Align";
_theme.TreeTable("view1").Cell("lev4right").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 241;BA.debugLine="theme.TreeTable(\"view1\").AddCellTheme(\"lev4orange";
_theme.TreeTable("view1").AddCellTheme("lev4orange");
 //BA.debugLineNum = 242;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev4orange\").BackC";
_theme.TreeTable("view1").Cell("lev4orange").BackColor = _abm.COLOR_AMBER;
 //BA.debugLineNum = 243;BA.debugLine="theme.TreeTable(\"view1\").Cell(\"lev4orange\").BackC";
_theme.TreeTable("view1").Cell("lev4orange").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 245;BA.debugLine="theme.TreeTable(\"view1\").AddTreeIconColorTheme(\"w";
_theme.TreeTable("view1").AddTreeIconColorTheme("white");
 //BA.debugLineNum = 246;BA.debugLine="theme.TreeTable(\"view1\").TreeIconColor(\"white\").F";
_theme.TreeTable("view1").TreeIconColor("white").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 248;BA.debugLine="theme.AddChartTheme(\"chart1theme\")";
_theme.AddChartTheme("chart1theme");
 //BA.debugLineNum = 249;BA.debugLine="theme.Chart(\"chart1theme\").Serie(ABM.CHART_SERIEI";
_theme.Chart("chart1theme").Serie(_abm.CHART_SERIEINDEX_C).LinePointStrokeWidthPx = (int) (8);
 //BA.debugLineNum = 250;BA.debugLine="theme.Chart(\"chart1theme\").Serie(ABM.CHART_SERIEI";
_theme.Chart("chart1theme").Serie(_abm.CHART_SERIEINDEX_C).LineStrokeWidthPx = (int) (5);
 //BA.debugLineNum = 253;BA.debugLine="theme.AddButtonTheme(\"bluegrey\")";
_theme.AddButtonTheme("bluegrey");
 //BA.debugLineNum = 254;BA.debugLine="theme.Button(\"bluegrey\").BackColor = ABM.COLOR_BL";
_theme.Button("bluegrey").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 255;BA.debugLine="theme.Button(\"bluegrey\").BackColorIntensity = ABM";
_theme.Button("bluegrey").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompTreeTablePage\"  '<--";
_name = "CompTreeTablePage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 18;BA.debugLine="Dim PlusParents As Map";
_plusparents = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 20;BA.debugLine="Type PlusStructure (Prefix As String, NextValue A";
;
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMTreeTable _view1 = null;
 //BA.debugLineNum = 289;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 290;BA.debugLine="PlusParents.Initialize";
_plusparents.Initialize();
 //BA.debugLineNum = 292;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 295;BA.debugLine="page.CellR(1,1).AddComponent(ABMShared.BuildParag";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","With the ABMTreeTable component you can build collapsable tree structures.  You can even use them to create simple reports (see the ABMPrint module).")));
 //BA.debugLineNum = 297;BA.debugLine="page.CellR(0,1).AddComponent(ABMShared.BuildParag";
_page.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","The tree is dynamic so you add, change, delete and move (try dragging an 'hour' detail line to another 'hour' block for example).")));
 //BA.debugLineNum = 300;BA.debugLine="Dim view1 As ABMTreeTable";
_view1 = new com.ab.abmaterial.ABMTreeTable();
 //BA.debugLineNum = 301;BA.debugLine="view1.Initialize(page, \"view1\", False, \"view1\", 2";
_view1.Initialize(_page,"view1",__c.False,"view1",(int) (20),anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"lev1default","lev2default","lev3default","lev4default"}),(int) (24));
 //BA.debugLineNum = 302;BA.debugLine="view1.CollapseTooltip = \"Close\"";
_view1.CollapseTooltip = "Close";
 //BA.debugLineNum = 303;BA.debugLine="view1.ExpandTooltip = \"Open\"";
_view1.ExpandTooltip = "Open";
 //BA.debugLineNum = 305;BA.debugLine="page.CellR(1,1).AddComponent(view1)";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_view1));
 //BA.debugLineNum = 312;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 314;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 317;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 319;BA.debugLine="LoadTree";
_loadtree();
 //BA.debugLineNum = 321;BA.debugLine="Dim view1 As ABMTreeTable = page.Component(\"view1";
_view1 = (com.ab.abmaterial.ABMTreeTable)(_page.Component("view1"));
 //BA.debugLineNum = 322;BA.debugLine="view1.Expand(\"1\")";
_view1.Expand("1");
 //BA.debugLineNum = 324;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 325;BA.debugLine="End Sub";
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
public String  _loadtree() throws Exception{
com.ab.abmaterial.ABMTreeTable _view1 = null;
 //BA.debugLineNum = 59;BA.debugLine="Sub LoadTree()";
 //BA.debugLineNum = 61;BA.debugLine="DateTime.DateFormat = \"EEEE d MMMM yyyy\"";
__c.DateTime.setDateFormat("EEEE d MMMM yyyy");
 //BA.debugLineNum = 62;BA.debugLine="Dim view1 As ABMTreeTable = page.Component(\"view1";
_view1 = (com.ab.abmaterial.ABMTreeTable)(_page.Component("view1"));
 //BA.debugLineNum = 63;BA.debugLine="view1.Clear";
_view1.Clear();
 //BA.debugLineNum = 64;BA.debugLine="view1.AddRow(BuildLev1Header(1, \"1\", \"\", \"\", \"Ypr";
_view1.AddRow(_buildlev1header((int) (1),"1","","","Ypres"));
 //BA.debugLineNum = 65;BA.debugLine="view1.AddRow(BuildLev2Header1(2, \"1_1\", \"1\", \"\",";
_view1.AddRow(_buildlev2header1((int) (2),"1_1","1","","Menin Gate",__c.DateTime.Date(__c.DateTime.getNow())));
 //BA.debugLineNum = 66;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_1_1\", \"1_1\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_1_1","1_1","","Hours",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"HOUR"}),"lev3hour",(int) (1)));
 //BA.debugLineNum = 67;BA.debugLine="view1.AddRow(BuildLev4Body1(4, \"1_1_1_1\", \"1_1_1\"";
_view1.AddRow(_buildlev4body1((int) (4),"1_1_1_1","1_1_1","","JSM","Jones Smith","03:00"));
 //BA.debugLineNum = 68;BA.debugLine="view1.AddRow(BuildLev4Body1(4, \"1_1_1_3\", \"1_1_1\"";
_view1.AddRow(_buildlev4body1((int) (4),"1_1_1_3","1_1_1","","SBF","Sindy Belfast","03:00"));
 //BA.debugLineNum = 69;BA.debugLine="view1.AddRow(BuildLev4Body1(4, \"1_1_1_2\", \"1_1_1\"";
_view1.AddRow(_buildlev4body1((int) (4),"1_1_1_2","1_1_1","","ABA","Alain Bailleul","05:00"));
 //BA.debugLineNum = 70;BA.debugLine="view1.AddRow(BuildLev3Footer1(3, \"1_1_2\", \"1_1\",";
_view1.AddRow(_buildlev3footer1((int) (3),"1_1_2","1_1","1_1_1","3 pers.","11 hours","lev3hour"));
 //BA.debugLineNum = 71;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_1_3\", \"1_1\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_1_3","1_1","","Done",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"DONE"}),"lev3done",(int) (0)));
 //BA.debugLineNum = 72;BA.debugLine="view1.AddRow(BuildLev4Body2(4, \"1_1_3_1\", \"1_1_3\"";
_view1.AddRow(_buildlev4body2((int) (4),"1_1_3_1","1_1_3","","First floor - swept"));
 //BA.debugLineNum = 73;BA.debugLine="view1.AddRow(BuildLev4Body2(4, \"1_1_3_2\", \"1_1_3\"";
_view1.AddRow(_buildlev4body2((int) (4),"1_1_3_2","1_1_3","","Second floor - vacuum-cleaned"));
 //BA.debugLineNum = 74;BA.debugLine="view1.AddRow(BuildLev3Footer2(3, \"1_1_4\", \"1_1\",";
_view1.AddRow(_buildlev3footer2((int) (3),"1_1_4","1_1","1_1_3","lev3done"));
 //BA.debugLineNum = 75;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_1_5\", \"1_1\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_1_5","1_1","","Used devices",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{}),"lev3devices",(int) (0)));
 //BA.debugLineNum = 76;BA.debugLine="view1.AddRow(BuildLev4Body3(4, \"1_1_5_1\", \"1_1_5\"";
_view1.AddRow(_buildlev4body3((int) (4),"1_1_5_1","1_1_5","","Vacuum Cleaner","2","half a day"));
 //BA.debugLineNum = 77;BA.debugLine="view1.AddRow(BuildLev3Footer2(3, \"1_1_6\", \"1_1\",";
_view1.AddRow(_buildlev3footer2((int) (3),"1_1_6","1_1","1_1_5","lev3devices"));
 //BA.debugLineNum = 78;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_1_7\", \"1_1\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_1_7","1_1","","Result",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{}),"",(int) (0)));
 //BA.debugLineNum = 79;BA.debugLine="view1.AddRow(BuildLev4Body3(4, \"1_1_7_1\", \"1_1_7\"";
_view1.AddRow(_buildlev4body3((int) (4),"1_1_7_1","1_1_7","","2 dust bins full","2","ton"));
 //BA.debugLineNum = 80;BA.debugLine="view1.AddRow(BuildLev3Footer2(3, \"1_1_8\", \"1_1\",";
_view1.AddRow(_buildlev3footer2((int) (3),"1_1_8","1_1","1_1_7",""));
 //BA.debugLineNum = 81;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_1_9\", \"1_1\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_1_9","1_1","","Extra info",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{}),"",(int) (0)));
 //BA.debugLineNum = 82;BA.debugLine="view1.AddRow(BuildLev4Body2(4, \"1_1_9_1\", \"1_1_9\"";
_view1.AddRow(_buildlev4body2((int) (4),"1_1_9_1","1_1_9","","Everything cleaned, vacuum cleaner needs to be repaired"));
 //BA.debugLineNum = 83;BA.debugLine="view1.AddRow(BuildLev3Footer2(3, \"1_1_10\", \"1_1\",";
_view1.AddRow(_buildlev3footer2((int) (3),"1_1_10","1_1","1_1_9",""));
 //BA.debugLineNum = 84;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_1_11\", \"1_1\",";
_view1.AddRow(_buildlev3header((int) (3),"1_1_11","1_1","","Overview",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{}),"",(int) (0)));
 //BA.debugLineNum = 85;BA.debugLine="view1.AddRow(BuildLev4Body4(4, \"1_1_11_1\", \"1_1_1";
_view1.AddRow(_buildlev4body4((int) (4),"1_1_11_1","1_1_11","",anywheresoftware.b4a.keywords.Common.ArrayToList(new int[]{(int) (30),(int) (50),(int) (70),(int) (80),(int) (100),(int) (140),(int) (170)}),anywheresoftware.b4a.keywords.Common.ArrayToList(new int[]{(int) (100),(int) (120),(int) (180),(int) (150),(int) (190),(int) (100),(int) (70)})));
 //BA.debugLineNum = 86;BA.debugLine="view1.AddRow(BuildLev3Footer2(3, \"1_1_12\", \"1_1\",";
_view1.AddRow(_buildlev3footer2((int) (3),"1_1_12","1_1","1_1_11",""));
 //BA.debugLineNum = 87;BA.debugLine="view1.AddRow(BuildLev2Footer(2, \"1_2\", \"1\", \"1_1\"";
_view1.AddRow(_buildlev2footer((int) (2),"1_2","1","1_1"));
 //BA.debugLineNum = 89;BA.debugLine="PlusParents.Put(\"1_2\", NewPlusStructure(\"1_1_1\",";
_plusparents.Put((Object)("1_2"),(Object)(_newplusstructure("1_1_1",(int) (4))));
 //BA.debugLineNum = 91;BA.debugLine="view1.AddRow(BuildLev2Header1(2, \"1_3\", \"1\", \"\",";
_view1.AddRow(_buildlev2header1((int) (2),"1_3","1","","Big Square",__c.DateTime.Date(__c.DateTime.getNow())));
 //BA.debugLineNum = 92;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_3_1\", \"1_3\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_3_1","1_3","","Hours",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"HOUR"}),"lev3hour",(int) (1)));
 //BA.debugLineNum = 93;BA.debugLine="view1.AddRow(BuildLev4Body1(4, \"1_3_1_1\", \"1_3_1\"";
_view1.AddRow(_buildlev4body1((int) (4),"1_3_1_1","1_3_1","","SBF","Sindy Belfast","04:00"));
 //BA.debugLineNum = 94;BA.debugLine="view1.AddRow(BuildLev3Footer1(3, \"1_3_2\", \"1_3\",";
_view1.AddRow(_buildlev3footer1((int) (3),"1_3_2","1_3","1_3_1","1 pers.","4 hours","lev3hour"));
 //BA.debugLineNum = 95;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_3_3\", \"1_3\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_3_3","1_3","","Done",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"DONE"}),"lev3done",(int) (0)));
 //BA.debugLineNum = 96;BA.debugLine="view1.AddRow(BuildLev4Body2(4, \"1_3_3_1\", \"1_3_3\"";
_view1.AddRow(_buildlev4body2((int) (4),"1_3_3_1","1_3_3","","First floor - swept"));
 //BA.debugLineNum = 97;BA.debugLine="view1.AddRow(BuildLev4Body2(4, \"1_3_3_2\", \"1_3_3\"";
_view1.AddRow(_buildlev4body2((int) (4),"1_3_3_2","1_3_3","","Second floor - vacuum-cleaned"));
 //BA.debugLineNum = 98;BA.debugLine="view1.AddRow(BuildLev3Footer2(3, \"1_3_4\", \"1_3\",";
_view1.AddRow(_buildlev3footer2((int) (3),"1_3_4","1_3","1_3_3","lev3done"));
 //BA.debugLineNum = 99;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_3_5\", \"1_3\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_3_5","1_3","","On map",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{}),"",(int) (0)));
 //BA.debugLineNum = 100;BA.debugLine="view1.AddRow(BuildLev4Body5(4, \"1_3_5_1\", \"1_3_5\"";
_view1.AddRow(_buildlev4body5((int) (4),"1_3_5_1","1_3_5","",50.8500,2.8833));
 //BA.debugLineNum = 101;BA.debugLine="view1.AddRow(BuildLev3Footer2(3, \"1_3_6\", \"1_3\",";
_view1.AddRow(_buildlev3footer2((int) (3),"1_3_6","1_3","1_3_5",""));
 //BA.debugLineNum = 102;BA.debugLine="view1.AddRow(BuildLev2Footer(2, \"1_4\", \"1\", \"1_3\"";
_view1.AddRow(_buildlev2footer((int) (2),"1_4","1","1_3"));
 //BA.debugLineNum = 104;BA.debugLine="PlusParents.Put(\"1_4\", NewPlusStructure(\"1_3_1\",";
_plusparents.Put((Object)("1_4"),(Object)(_newplusstructure("1_3_1",(int) (2))));
 //BA.debugLineNum = 106;BA.debugLine="view1.AddRow(BuildLev2Header1(2, \"1_5\", \"1\", \"\",";
_view1.AddRow(_buildlev2header1((int) (2),"1_5","1","","Swimming pool",__c.DateTime.Date(__c.DateTime.getNow())));
 //BA.debugLineNum = 107;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_5_1\", \"1_5\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_5_1","1_5","","Hours",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"HOUR"}),"lev3hour",(int) (1)));
 //BA.debugLineNum = 108;BA.debugLine="view1.AddRow(BuildLev4Body1(4, \"1_5_1_1\", \"1_5_1\"";
_view1.AddRow(_buildlev4body1((int) (4),"1_5_1_1","1_5_1","","SBF","Sindy Belfast","04:00"));
 //BA.debugLineNum = 109;BA.debugLine="view1.AddRow(BuildLev3Footer1(3, \"1_5_2\", \"1_5\",";
_view1.AddRow(_buildlev3footer1((int) (3),"1_5_2","1_5","1_5_1","1 pers.","4 hours","lev3hour"));
 //BA.debugLineNum = 110;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_5_3\", \"1_5\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_5_3","1_5","","Done",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"DONE"}),"lev3done",(int) (0)));
 //BA.debugLineNum = 111;BA.debugLine="view1.AddRow(BuildLev4Body2(4, \"1_5_3_1\", \"1_5_3\"";
_view1.AddRow(_buildlev4body2((int) (4),"1_5_3_1","1_5_3","","First floor - swept"));
 //BA.debugLineNum = 112;BA.debugLine="view1.AddRow(BuildLev3Footer2(3, \"1_5_4\", \"1_5\",";
_view1.AddRow(_buildlev3footer2((int) (3),"1_5_4","1_5","1_5_3","lev3done"));
 //BA.debugLineNum = 113;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_5_5\", \"1_5\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_5_5","1_5","","Used devices",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{}),"lev3devices",(int) (0)));
 //BA.debugLineNum = 114;BA.debugLine="view1.AddRow(BuildLev4Body3(4, \"1_5_5_1\", \"1_5_5\"";
_view1.AddRow(_buildlev4body3((int) (4),"1_5_5_1","1_5_5","","Vacuum Cleaner","2","half a day"));
 //BA.debugLineNum = 115;BA.debugLine="view1.AddRow(BuildLev3Footer2(3, \"1_5_6\", \"1_5\",";
_view1.AddRow(_buildlev3footer2((int) (3),"1_5_6","1_5","1_5_5","lev3devices"));
 //BA.debugLineNum = 116;BA.debugLine="view1.AddRow(BuildLev2Footer(2, \"1_6\", \"1\", \"1_5\"";
_view1.AddRow(_buildlev2footer((int) (2),"1_6","1","1_5"));
 //BA.debugLineNum = 118;BA.debugLine="PlusParents.Put(\"1_6\", NewPlusStructure(\"1_5_1\",";
_plusparents.Put((Object)("1_6"),(Object)(_newplusstructure("1_5_1",(int) (1))));
 //BA.debugLineNum = 120;BA.debugLine="view1.AddRow(BuildLev2Header1(2, \"1_7\", \"1\", \"\",";
_view1.AddRow(_buildlev2header1((int) (2),"1_7","1","","Parking lot",__c.DateTime.Date(__c.DateTime.getNow())));
 //BA.debugLineNum = 121;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_7_1\", \"1_7\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_7_1","1_7","","Hours",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"HOUR"}),"lev3hour",(int) (1)));
 //BA.debugLineNum = 122;BA.debugLine="view1.AddRow(BuildLev4Body1(4, \"1_7_1_1\", \"1_7_1\"";
_view1.AddRow(_buildlev4body1((int) (4),"1_7_1_1","1_7_1","","ABA","Alain Bailleul","05:00"));
 //BA.debugLineNum = 123;BA.debugLine="view1.AddRow(BuildLev4Body1(4, \"1_7_1_2\", \"1_7_1\"";
_view1.AddRow(_buildlev4body1((int) (4),"1_7_1_2","1_7_1","","JSM","Jones Smith","03:00"));
 //BA.debugLineNum = 124;BA.debugLine="view1.AddRow(BuildLev4Body1(4, \"1_7_1_3\", \"1_7_1\"";
_view1.AddRow(_buildlev4body1((int) (4),"1_7_1_3","1_7_1","","SBF","Sindy Belfast","03:00"));
 //BA.debugLineNum = 125;BA.debugLine="view1.AddRow(BuildLev3Footer1(3, \"1_7_2\", \"1_7\",";
_view1.AddRow(_buildlev3footer1((int) (3),"1_7_2","1_7","1_7_1","3 pers.","11 hours","lev3hour"));
 //BA.debugLineNum = 126;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_7_3\", \"1_7\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_7_3","1_7","","Done",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"DONE"}),"lev3done",(int) (0)));
 //BA.debugLineNum = 127;BA.debugLine="view1.AddRow(BuildLev4Body2(4, \"1_7_3_1\", \"1_7_3\"";
_view1.AddRow(_buildlev4body2((int) (4),"1_7_3_1","1_7_3","","First floor - swept"));
 //BA.debugLineNum = 128;BA.debugLine="view1.AddRow(BuildLev3Footer2(3, \"1_7_4\", \"1_7\",";
_view1.AddRow(_buildlev3footer2((int) (3),"1_7_4","1_7","1_7_3","lev3done"));
 //BA.debugLineNum = 129;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"1_7_5\", \"1_7\", \"";
_view1.AddRow(_buildlev3header((int) (3),"1_7_5","1_7","","Result",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{}),"",(int) (0)));
 //BA.debugLineNum = 130;BA.debugLine="view1.AddRow(BuildLev4Body3(4, \"1_7_5_1\", \"1_7_5\"";
_view1.AddRow(_buildlev4body3((int) (4),"1_7_5_1","1_7_5","","2 dust bins full","2","ton"));
 //BA.debugLineNum = 131;BA.debugLine="view1.AddRow(BuildLev3Footer2(3, \"1_7_6\", \"1_7\",";
_view1.AddRow(_buildlev3footer2((int) (3),"1_7_6","1_7","1_7_5",""));
 //BA.debugLineNum = 132;BA.debugLine="view1.AddRow(BuildLev2Footer(2, \"1_8\", \"1\", \"1_7\"";
_view1.AddRow(_buildlev2footer((int) (2),"1_8","1","1_7"));
 //BA.debugLineNum = 134;BA.debugLine="PlusParents.Put(\"1_8\", NewPlusStructure(\"1_7_1\",";
_plusparents.Put((Object)("1_8"),(Object)(_newplusstructure("1_7_1",(int) (4))));
 //BA.debugLineNum = 136;BA.debugLine="view1.AddRow(BuildLev1Footer(1, \"2\", \"\", \"1\"))";
_view1.AddRow(_buildlev1footer((int) (1),"2","","1"));
 //BA.debugLineNum = 138;BA.debugLine="view1.AddRow(BuildLev1Header(1, \"3\", \"\", \"\", \"Bru";
_view1.AddRow(_buildlev1header((int) (1),"3","","","Brussels"));
 //BA.debugLineNum = 139;BA.debugLine="view1.AddRow(BuildLev2Header1(2, \"3_1\", \"3\", \"\",";
_view1.AddRow(_buildlev2header1((int) (2),"3_1","3","","Palace",__c.DateTime.Date(__c.DateTime.getNow())));
 //BA.debugLineNum = 140;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"3_1_1\", \"3_1\", \"";
_view1.AddRow(_buildlev3header((int) (3),"3_1_1","3_1","","Hours",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"HOUR"}),"lev3hour",(int) (1)));
 //BA.debugLineNum = 141;BA.debugLine="view1.AddRow(BuildLev4Body1(4, \"3_1_1_1\", \"3_1_1\"";
_view1.AddRow(_buildlev4body1((int) (4),"3_1_1_1","3_1_1","","ABA","Alain Bailleul","05:00"));
 //BA.debugLineNum = 142;BA.debugLine="view1.AddRow(BuildLev4Body1(4, \"3_1_1_2\", \"3_1_1\"";
_view1.AddRow(_buildlev4body1((int) (4),"3_1_1_2","3_1_1","","SBF","Sindy Belfast","03:00"));
 //BA.debugLineNum = 143;BA.debugLine="view1.AddRow(BuildLev3Footer1(3, \"3_1_2\", \"3_1\",";
_view1.AddRow(_buildlev3footer1((int) (3),"3_1_2","3_1","3_1_1","2 pers.","8 hours","lev3hour"));
 //BA.debugLineNum = 144;BA.debugLine="view1.AddRow(BuildLev3Header(3, \"3_1_3\", \"3_1\", \"";
_view1.AddRow(_buildlev3header((int) (3),"3_1_3","3_1","","Done",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"DONE"}),"lev3done",(int) (0)));
 //BA.debugLineNum = 145;BA.debugLine="view1.AddRow(BuildLev4Body2(4, \"3_1_3_1\", \"3_1_3\"";
_view1.AddRow(_buildlev4body2((int) (4),"3_1_3_1","3_1_3","","First floor - swept"));
 //BA.debugLineNum = 146;BA.debugLine="view1.AddRow(BuildLev4Body2(4, \"3_1_3_2\", \"3_1_3\"";
_view1.AddRow(_buildlev4body2((int) (4),"3_1_3_2","3_1_3","","Second floor - vacuum-cleaned"));
 //BA.debugLineNum = 147;BA.debugLine="view1.AddRow(BuildLev3Footer2(3, \"3_1_4\", \"3_1\",";
_view1.AddRow(_buildlev3footer2((int) (3),"3_1_4","3_1","3_1_3","lev3done"));
 //BA.debugLineNum = 149;BA.debugLine="view1.AddRow(BuildLev2Footer(2, \"3_2\", \"3\", \"3_1\"";
_view1.AddRow(_buildlev2footer((int) (2),"3_2","3","3_1"));
 //BA.debugLineNum = 151;BA.debugLine="PlusParents.Put(\"3_2\", NewPlusStructure(\"3_1_1\",";
_plusparents.Put((Object)("3_2"),(Object)(_newplusstructure("3_1_1",(int) (3))));
 //BA.debugLineNum = 153;BA.debugLine="view1.AddRow(BuildLev1Footer(1, \"4\", \"\", \"3\"))";
_view1.AddRow(_buildlev1footer((int) (1),"4","","3"));
 //BA.debugLineNum = 155;BA.debugLine="view1.Refresh";
_view1.Refresh();
 //BA.debugLineNum = 156;BA.debugLine="End Sub";
return "";
}
public abmaterial.ab.com.comptreetablepage._plusstructure  _newplusstructure(String _prefix,int _nextvalue) throws Exception{
abmaterial.ab.com.comptreetablepage._plusstructure _ps = null;
 //BA.debugLineNum = 158;BA.debugLine="Sub NewPlusStructure(Prefix As String, NextValue A";
 //BA.debugLineNum = 159;BA.debugLine="Dim ps As PlusStructure";
_ps = new abmaterial.ab.com.comptreetablepage._plusstructure();
 //BA.debugLineNum = 160;BA.debugLine="ps.Initialize";
_ps.Initialize();
 //BA.debugLineNum = 161;BA.debugLine="ps.Prefix = Prefix";
_ps.Prefix = _prefix;
 //BA.debugLineNum = 162;BA.debugLine="ps.NextValue = NextValue";
_ps.NextValue = _nextvalue;
 //BA.debugLineNum = 163;BA.debugLine="Return ps";
if (true) return _ps;
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return null;
}
public String  _page_fileuploaded(String _filename,boolean _success) throws Exception{
 //BA.debugLineNum = 525;BA.debugLine="Sub Page_FileUploaded(FileName As String, success";
 //BA.debugLineNum = 527;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 510;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 511;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 512;BA.debugLine="If Action = \"ABMTreeTable\" Then Return";
if ((_action).equals("ABMTreeTable")) { 
if (true) return "";};
 //BA.debugLineNum = 513;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 514;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 515;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 516;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 518;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 519;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 520;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 522;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 523;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 170;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 171;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 172;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 173;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 174;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 175;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 176;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 178;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 179;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 180;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 181;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 183;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 185;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 187;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 188;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 189;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 191;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 195;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 198;BA.debugLine="End Sub";
return "";
}
public String  _page_toastclicked(String _toastid,String _action) throws Exception{
 //BA.debugLineNum = 529;BA.debugLine="Sub Page_ToastClicked(ToastId As String, Action As";
 //BA.debugLineNum = 531;BA.debugLine="End Sub";
return "";
}
public String  _page_toastdismissed(String _toastid) throws Exception{
 //BA.debugLineNum = 533;BA.debugLine="Sub Page_ToastDismissed(ToastId As String)";
 //BA.debugLineNum = 535;BA.debugLine="End Sub";
return "";
}
public String  _view1_clicked(String _treerowid,String _treecellid) throws Exception{
abmaterial.ab.com.comptreetablepage._plusstructure _ps = null;
com.ab.abmaterial.ABMTreeTable _view1 = null;
 //BA.debugLineNum = 544;BA.debugLine="Sub view1_Clicked(TreeRowId As String, TreeCellId";
 //BA.debugLineNum = 547;BA.debugLine="If PlusParents.ContainsKey(TreeRowId) Then";
if (_plusparents.ContainsKey((Object)(_treerowid))) { 
 //BA.debugLineNum = 548;BA.debugLine="Dim ps As PlusStructure = PlusParents.Get(TreeRo";
_ps = (abmaterial.ab.com.comptreetablepage._plusstructure)(_plusparents.Get((Object)(_treerowid)));
 //BA.debugLineNum = 553;BA.debugLine="Log(\"The user added a new row: \" & ps.Prefix & \"";
__c.Log("The user added a new row: "+_ps.Prefix+"_"+BA.NumberToString(_ps.NextValue));
 //BA.debugLineNum = 555;BA.debugLine="Dim view1 As ABMTreeTable = page.Component(\"view";
_view1 = (com.ab.abmaterial.ABMTreeTable)(_page.Component("view1"));
 //BA.debugLineNum = 556;BA.debugLine="DateTime.timeFormat = \"HH:mm:ss\"";
__c.DateTime.setTimeFormat("HH:mm:ss");
 //BA.debugLineNum = 557;BA.debugLine="view1.AddRow(BuildLev4Body1(4, ps.Prefix & \"_\" &";
_view1.AddRow(_buildlev4body1((int) (4),_ps.Prefix+"_"+BA.NumberToString(_ps.NextValue),_ps.Prefix,"","NEW",__c.DateTime.Time(__c.DateTime.getNow()),"01:00"));
 //BA.debugLineNum = 558;BA.debugLine="ps.NextValue = ps.NextValue + 1";
_ps.NextValue = (int) (_ps.NextValue+1);
 //BA.debugLineNum = 559;BA.debugLine="PlusParents.Put(TreeRowId, ps)";
_plusparents.Put((Object)(_treerowid),(Object)(_ps));
 //BA.debugLineNum = 560;BA.debugLine="view1.Refresh";
_view1.Refresh();
 };
 //BA.debugLineNum = 563;BA.debugLine="End Sub";
return "";
}
public String  _view1_dropped(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
boolean _success = false;
String _treerowid = "";
String _fromtreerowid = "";
String _ontreerowid = "";
com.ab.abmaterial.ABMTreeTable _view1 = null;
 //BA.debugLineNum = 565;BA.debugLine="Sub view1_Dropped(Params As Map)";
 //BA.debugLineNum = 566;BA.debugLine="Dim Success As Boolean = Params.Get(\"success\")";
_success = BA.ObjectToBoolean(_params.Get((Object)("success")));
 //BA.debugLineNum = 567;BA.debugLine="Dim TreeRowId As String = Params.Get(\"treerowid\")";
_treerowid = BA.ObjectToString(_params.Get((Object)("treerowid")));
 //BA.debugLineNum = 568;BA.debugLine="Dim FromTreeRowID As String = Params.get(\"fromtre";
_fromtreerowid = BA.ObjectToString(_params.Get((Object)("fromtreerowid")));
 //BA.debugLineNum = 569;BA.debugLine="Dim OnTreeRowID As String = Params.get(\"ontreerow";
_ontreerowid = BA.ObjectToString(_params.Get((Object)("ontreerowid")));
 //BA.debugLineNum = 570;BA.debugLine="Log(\"TreeRowId: \" & TreeRowId & \"from: \" & FromTr";
__c.Log("TreeRowId: "+_treerowid+"from: "+_fromtreerowid+" dropped on: "+_ontreerowid+" Success: "+BA.ObjectToString(_success));
 //BA.debugLineNum = 572;BA.debugLine="Dim view1 As ABMTreeTable = page.Component(\"view1";
_view1 = (com.ab.abmaterial.ABMTreeTable)(_page.Component("view1"));
 //BA.debugLineNum = 573;BA.debugLine="view1.Sync(TreeRowId, FromTreeRowID, OnTreeRowID)";
_view1.Sync(_treerowid,_fromtreerowid,_ontreerowid);
 //BA.debugLineNum = 574;BA.debugLine="End Sub";
return "";
}
public String  _view1_needsrefreshchildren(String _rowid) throws Exception{
com.ab.abmaterial.ABMTreeTable _view1 = null;
 //BA.debugLineNum = 538;BA.debugLine="Sub View1_NeedsRefreshChildren(rowId As String)";
 //BA.debugLineNum = 539;BA.debugLine="Dim view1 As ABMTreeTable = page.Component(\"view1";
_view1 = (com.ab.abmaterial.ABMTreeTable)(_page.Component("view1"));
 //BA.debugLineNum = 540;BA.debugLine="view1.RefreshChildren(rowId)";
_view1.RefreshChildren(_rowid);
 //BA.debugLineNum = 541;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 166;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 167;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 168;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "PAGE_FILEUPLOADED"))
	return _page_fileuploaded((String) args[0], (Boolean) args[1]);
return BA.SubDelegator.SubNotFound;
}
}
