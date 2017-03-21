package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compcombopage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compcombopage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compcombopage.class).invoke(this, new Object[] {null});
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
public int _combocounter = 0;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _btn_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMCombo _combo1 = null;
 //BA.debugLineNum = 270;BA.debugLine="Sub btn_Clicked(Target As String)";
 //BA.debugLineNum = 271;BA.debugLine="Dim combo1 As ABMCombo = page.Component(\"combo1\")";
_combo1 = (com.ab.abmaterial.ABMCombo)(_page.Component("combo1"));
 //BA.debugLineNum = 272;BA.debugLine="combocounter = combocounter + 1";
_combocounter = (int) (_combocounter+1);
 //BA.debugLineNum = 273;BA.debugLine="combo1.AddItem(\"combo1S\" & combocounter, \"NewItem";
_combo1.AddItem("combo1S"+BA.NumberToString(_combocounter),"NewItem"+BA.NumberToString(_combocounter),(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S"+BA.NumberToString(_combocounter),"mdi-action-dashboard","{NBSP}{NBSP}New Item "+BA.NumberToString(_combocounter))));
 //BA.debugLineNum = 274;BA.debugLine="combo1.SetActiveItemId(\"combo1S\" & combocounter)";
_combo1.SetActiveItemId("combo1S"+BA.NumberToString(_combocounter));
 //BA.debugLineNum = 275;BA.debugLine="combo1.Refresh";
_combo1.Refresh();
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMContainer  _builditem(String _id,String _image,String _title,String _subtitle) throws Exception{
com.ab.abmaterial.ABMContainer _itemcont = null;
com.ab.abmaterial.ABMContainer _subitemcont = null;
com.ab.abmaterial.ABMImage _img = null;
com.ab.abmaterial.ABMLabel _lbl1 = null;
com.ab.abmaterial.ABMLabel _lbl2 = null;
 //BA.debugLineNum = 211;BA.debugLine="Sub BuildItem(id As String, image As String, Title";
 //BA.debugLineNum = 212;BA.debugLine="Dim ItemCont As ABMContainer";
_itemcont = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 213;BA.debugLine="ItemCont.Initialize(page, id, \"\")";
_itemcont.Initialize(_page,_id,"");
 //BA.debugLineNum = 214;BA.debugLine="ItemCont.AddRowsM(1,False,6,0, \"\").AddCellsOSMP(1";
_itemcont.AddRowsM((int) (1),__c.False,(int) (6),(int) (0),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (3),(int) (2),(int) (2),(int) (0),(int) (0),(int) (16),(int) (0),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (9),(int) (10),(int) (10),"");
 //BA.debugLineNum = 215;BA.debugLine="ItemCont.BuildGrid 'IMPORTANT once you loaded the";
_itemcont.BuildGrid();
 //BA.debugLineNum = 217;BA.debugLine="Dim SubItemCont As ABMContainer";
_subitemcont = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 218;BA.debugLine="SubItemCont.Initialize(page, id & \"SubItemCont\",";
_subitemcont.Initialize(_page,_id+"SubItemCont","");
 //BA.debugLineNum = 219;BA.debugLine="SubItemCont.AddRowsM(1,False, 0,0,\"\").AddCells12M";
_subitemcont.AddRowsM((int) (1),__c.False,(int) (0),(int) (0),"").AddCells12MP((int) (1),(int) (-6),(int) (0),(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 220;BA.debugLine="SubItemCont.BuildGrid 'IMPORTANT once you loaded";
_subitemcont.BuildGrid();
 //BA.debugLineNum = 222;BA.debugLine="ItemCont.Cell(1,2).AddComponent(SubItemCont)";
_itemcont.Cell((int) (1),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_subitemcont));
 //BA.debugLineNum = 224;BA.debugLine="Dim img As ABMImage";
_img = new com.ab.abmaterial.ABMImage();
 //BA.debugLineNum = 225;BA.debugLine="img.Initialize(page, id & \"img\", image, 1)";
_img.Initialize(_page,_id+"img",_image,1);
 //BA.debugLineNum = 226;BA.debugLine="img.SetFixedSize(48,48)";
_img.SetFixedSize((int) (48),(int) (48));
 //BA.debugLineNum = 227;BA.debugLine="img.IsCircular = True";
_img.IsCircular = __c.True;
 //BA.debugLineNum = 228;BA.debugLine="img.IsResponsive = True";
_img.IsResponsive = __c.True;
 //BA.debugLineNum = 230;BA.debugLine="ItemCont.Cell(1,1).AddComponent(img)";
_itemcont.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_img));
 //BA.debugLineNum = 232;BA.debugLine="Dim lbl1 As ABMLabel";
_lbl1 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 233;BA.debugLine="lbl1.Initialize(page, id & \"lbl1\", Title, ABM.SIZ";
_lbl1.Initialize(_page,_id+"lbl1",_title,_abm.SIZE_H6,__c.False,"lightblue");
 //BA.debugLineNum = 234;BA.debugLine="lbl1.VerticalAlign = True";
_lbl1.VerticalAlign = __c.True;
 //BA.debugLineNum = 236;BA.debugLine="SubItemCont.Cell(1,1).AddComponent(lbl1)";
_subitemcont.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl1));
 //BA.debugLineNum = 238;BA.debugLine="Dim lbl2 As ABMLabel";
_lbl2 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 239;BA.debugLine="lbl2.Initialize(page, id & \"lbl2\", Subtitle, ABM.";
_lbl2.Initialize(_page,_id+"lbl2",_subtitle,_abm.SIZE_H6,__c.False,"");
 //BA.debugLineNum = 240;BA.debugLine="lbl2.VerticalAlign = True";
_lbl2.VerticalAlign = __c.True;
 //BA.debugLineNum = 242;BA.debugLine="SubItemCont.Cell(1,2).AddComponent(lbl2)";
_subitemcont.Cell((int) (1),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl2));
 //BA.debugLineNum = 244;BA.debugLine="Return ItemCont";
if (true) return _itemcont;
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return null;
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 100;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 103;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 104;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 105;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 106;BA.debugLine="page.PageTitle = \"ABMCombo\"";
_page.PageTitle = "ABMCombo";
 //BA.debugLineNum = 107;BA.debugLine="page.PageDescription = \"The combo component \"";
_page.PageDescription = "The combo component ";
 //BA.debugLineNum = 108;BA.debugLine="page.PageHTMLName = \"abmaterial-combo.html\"";
_page.PageHTMLName = "abmaterial-combo.html";
 //BA.debugLineNum = 109;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 110;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 111;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 112;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 114;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMCombo\", \".";
_abmshared._buildnavigationbar(_page,"ABMCombo","../images/logo.png","","Controls","ABMCombo");
 //BA.debugLineNum = 117;BA.debugLine="page.AddRows(5,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (5),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 118;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 123;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMLabel  _buildsimpleitem(String _id,String _icon,String _title) throws Exception{
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 199;BA.debugLine="Sub BuildSimpleItem(id As String, icon As String,";
 //BA.debugLineNum = 200;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 201;BA.debugLine="If icon <> \"\" Then";
if ((_icon).equals("") == false) { 
 //BA.debugLineNum = 202;BA.debugLine="lbl.Initialize(page, id, Title, ABM.SIZE_H6, Tru";
_lbl.Initialize(_page,_id,_title,_abm.SIZE_H6,__c.True,"header");
 }else {
 //BA.debugLineNum = 204;BA.debugLine="lbl.Initialize(page, id, Title, ABM.SIZE_H6, Tru";
_lbl.Initialize(_page,_id,_title,_abm.SIZE_H6,__c.True,"");
 };
 //BA.debugLineNum = 206;BA.debugLine="lbl.VerticalAlign = True";
_lbl.VerticalAlign = __c.True;
 //BA.debugLineNum = 207;BA.debugLine="lbl.IconName = icon";
_lbl.IconName = _icon;
 //BA.debugLineNum = 208;BA.debugLine="Return lbl";
if (true) return _lbl;
 //BA.debugLineNum = 209;BA.debugLine="End Sub";
return null;
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 90;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 91;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 94;BA.debugLine="theme.AddLabelTheme(\"lightblue\")";
_theme.AddLabelTheme("lightblue");
 //BA.debugLineNum = 95;BA.debugLine="theme.Label(\"lightblue\").ForeColor = ABM.COLOR_LI";
_theme.Label("lightblue").ForeColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompComboPage\"";
_name = "CompComboPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="Dim combocounter As Int = 4";
_combocounter = (int) (4);
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public String  _combo1_clicked(String _itemid) throws Exception{
com.ab.abmaterial.ABMCombo _combo1 = null;
 //BA.debugLineNum = 278;BA.debugLine="Sub combo1_Clicked(itemId As String)";
 //BA.debugLineNum = 279;BA.debugLine="Log(itemId)";
__c.Log(_itemid);
 //BA.debugLineNum = 280;BA.debugLine="Dim combo1 As ABMCombo = page.Component(\"combo1\")";
_combo1 = (com.ab.abmaterial.ABMCombo)(_page.Component("combo1"));
 //BA.debugLineNum = 281;BA.debugLine="Log(combo1.GetActiveItemId)";
__c.Log(_combo1.GetActiveItemId());
 //BA.debugLineNum = 282;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMCombo _combo1 = null;
com.ab.abmaterial.ABMButton _btn = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code = null;
com.ab.abmaterial.ABMCombo _combo2 = null;
 //BA.debugLineNum = 126;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 128;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 131;BA.debugLine="page.cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Combos allows user input through specified options.")));
 //BA.debugLineNum = 134;BA.debugLine="Dim combo1 As ABMCombo";
_combo1 = new com.ab.abmaterial.ABMCombo();
 //BA.debugLineNum = 135;BA.debugLine="combo1.Initialize(page, \"combo1\", \"Select a {B}pe";
_combo1.Initialize(_page,"combo1","Select a {B}person{/B}",(int) (650),"");
 //BA.debugLineNum = 136;BA.debugLine="combo1.Valid = ABM.VALID_FALSE";
_combo1.setValid(_abm.VALID_FALSE);
 //BA.debugLineNum = 137;BA.debugLine="combo1.PlaceHolderText = \"{NBSP}\"";
_combo1.PlaceHolderText = "{NBSP}";
 //BA.debugLineNum = 138;BA.debugLine="combo1.WrongMessage = \"My Wrong Message\"";
_combo1.WrongMessage = "My Wrong Message";
 //BA.debugLineNum = 139;BA.debugLine="combo1.IconName = \"mdi-action-account-circle\"";
_combo1.IconName = "mdi-action-account-circle";
 //BA.debugLineNum = 142;BA.debugLine="combo1.AddItem(\"combo1S1\", \"Mom\", BuildSimpleItem";
_combo1.AddItem("combo1S1","Mom",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S1","mdi-action-account-circle","{NBSP}{NBSP}Mom")));
 //BA.debugLineNum = 143;BA.debugLine="combo1.AddItem(\"combo1S2\", \"Dad\", BuildSimpleItem";
_combo1.AddItem("combo1S2","Dad",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S2","mdi-action-account-circle","{NBSP}{NBSP}Dad")));
 //BA.debugLineNum = 144;BA.debugLine="combo1.AddItem(\"combo1S3\", \"Brother\", BuildSimple";
_combo1.AddItem("combo1S3","Brother",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S3","mdi-action-dashboard","{NBSP}{NBSP}Brother")));
 //BA.debugLineNum = 145;BA.debugLine="combo1.AddItem(\"combo1S4\", \"Sister\", BuildSimpleI";
_combo1.AddItem("combo1S4","Sister",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S4","mdi-action-dashboard","{NBSP}{NBSP}Sister")));
 //BA.debugLineNum = 147;BA.debugLine="page.cell(2,1).AddComponent(combo1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_combo1));
 //BA.debugLineNum = 149;BA.debugLine="Dim btn As ABMButton";
_btn = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 150;BA.debugLine="btn.InitializeRaised(page , \"btn\", \"\", \"\", \"Add i";
_btn.InitializeRaised(_page,"btn","","","Add item","");
 //BA.debugLineNum = 151;BA.debugLine="page.Cell(3,1).AddComponent(btn)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn));
 //BA.debugLineNum = 155;BA.debugLine="Dim code As StringBuilder";
_code = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 156;BA.debugLine="code.Initialize";
_code.Initialize();
 //BA.debugLineNum = 157;BA.debugLine="code.Append(\"// create combo\").Append(CRLF)";
_code.Append("// create combo").Append(__c.CRLF);
 //BA.debugLineNum = 158;BA.debugLine="code.Append(\"Dim combo1 As ABMCombo\").Append(CRLF";
_code.Append("Dim combo1 As ABMCombo").Append(__c.CRLF);
 //BA.debugLineNum = 159;BA.debugLine="code.Append(\"combo1.Initialize(page, \"\"combo1\"\",";
_code.Append("combo1.Initialize(page, \"combo1\", \"Select a person\", 650, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 160;BA.debugLine="code.Append(\"combo1.IconName = \"\"mdi-action-accou";
_code.Append("combo1.IconName = \"mdi-action-account-circle\"").Append(__c.CRLF);
 //BA.debugLineNum = 161;BA.debugLine="code.Append(\"\").Append(CRLF)";
_code.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 162;BA.debugLine="code.Append(\"// add items\").Append(CRLF)";
_code.Append("// add items").Append(__c.CRLF);
 //BA.debugLineNum = 163;BA.debugLine="code.Append(\"combo1.AddItem(\"\"combo1S1\"\", \"\"Mom\"\"";
_code.Append("combo1.AddItem(\"combo1S1\", \"Mom\", BuildSimpleItem(\"S1\", \"mdi-action-account-circle\", \"{NBSP}{NBSP}Mom\"))").Append(__c.CRLF);
 //BA.debugLineNum = 164;BA.debugLine="code.Append(\"combo1.AddItem(\"\"combo1S2\"\", \"\"Dad\"\"";
_code.Append("combo1.AddItem(\"combo1S2\", \"Dad\", BuildSimpleItem(\"S2\", \"mdi-action-account-circle\", \"{NBSP}{NBSP}Dad\"))").Append(__c.CRLF);
 //BA.debugLineNum = 165;BA.debugLine="code.Append(\"combo1.AddItem(\"\"combo1S3\"\", \"\"Broth";
_code.Append("combo1.AddItem(\"combo1S3\", \"Brother\", BuildSimpleItem(\"S3\", \"mdi-action-dashboard\", \"{NBSP}{NBSP}Brother\"))").Append(__c.CRLF);
 //BA.debugLineNum = 166;BA.debugLine="code.Append(\"combo1.AddItem(\"\"combo1S4\"\", \"\"Siste";
_code.Append("combo1.AddItem(\"combo1S4\", \"Sister\", BuildSimpleItem(\"S4\", \"mdi-action-dashboard\", \"{NBSP}{NBSP}Sister\"))").Append(__c.CRLF);
 //BA.debugLineNum = 167;BA.debugLine="code.Append(\"\").Append(CRLF)";
_code.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 168;BA.debugLine="code.Append(\"page.cell(2,1).AddComponent(combo1)\"";
_code.Append("page.cell(2,1).AddComponent(combo1)").Append(__c.CRLF);
 //BA.debugLineNum = 170;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code1",_code)));
 //BA.debugLineNum = 173;BA.debugLine="page.cell(4,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","Combos can also have more complex layouts.")));
 //BA.debugLineNum = 176;BA.debugLine="Dim combo2 As ABMCombo";
_combo2 = new com.ab.abmaterial.ABMCombo();
 //BA.debugLineNum = 177;BA.debugLine="combo2.Initialize(page, \"combo2\", \"Select a perso";
_combo2.Initialize(_page,"combo2","Select a person",(int) (650),"");
 //BA.debugLineNum = 178;BA.debugLine="combo2.IconName = \"mdi-action-account-circle\"";
_combo2.IconName = "mdi-action-account-circle";
 //BA.debugLineNum = 181;BA.debugLine="combo2.AddItem(\"combo2S1\", \"Mom\", BuildItem(\"S1\",";
_combo2.AddItem("combo2S1","Mom",(com.ab.abmaterial.ABMComponent)(_builditem("S1","../images/mom.jpg","Mom","The loving one")));
 //BA.debugLineNum = 182;BA.debugLine="combo2.AddItem(\"combo2S2\", \"Dad\", BuildItem(\"S2\",";
_combo2.AddItem("combo2S2","Dad",(com.ab.abmaterial.ABMComponent)(_builditem("S2","../images/dad.jpg","Dad","The strong one")));
 //BA.debugLineNum = 183;BA.debugLine="combo2.AddItem(\"combo2S3\", \"Brother\", BuildItem(\"";
_combo2.AddItem("combo2S3","Brother",(com.ab.abmaterial.ABMComponent)(_builditem("S3","../images/brother.jpg","Brother","My best friend")));
 //BA.debugLineNum = 184;BA.debugLine="combo2.AddItem(\"combo2S4\", \"Sister\", BuildItem(\"S";
_combo2.AddItem("combo2S4","Sister",(com.ab.abmaterial.ABMComponent)(_builditem("S4","../images/sister.jpg","Sister","The annoying one")));
 //BA.debugLineNum = 186;BA.debugLine="page.cell(5,1).AddComponent(combo2)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_combo2));
 //BA.debugLineNum = 189;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 191;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 194;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 196;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 197;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 21;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 23;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 248;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 249;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 250;BA.debugLine="If Action = \"ABMCombo\" Then Return";
if ((_action).equals("ABMCombo")) { 
if (true) return "";};
 //BA.debugLineNum = 251;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 252;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 253;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 254;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 256;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 257;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 258;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 260;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 261;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 58;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 59;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 60;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 61;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 62;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 63;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 64;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 66;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 67;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 68;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 69;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 71;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 73;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 75;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 76;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 77;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 79;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 83;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 263;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 264;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 265;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 266;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 267;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 268;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 26;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 27;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 28;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 29;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 30;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 32;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 33;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 34;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 35;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 39;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 40;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 42;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 44;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 47;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 49;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 51;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 55;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
