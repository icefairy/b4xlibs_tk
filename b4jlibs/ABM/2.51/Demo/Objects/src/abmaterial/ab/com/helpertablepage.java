package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class helpertablepage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.helpertablepage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.helpertablepage.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.collections.List _firstnames = null;
public anywheresoftware.b4a.objects.collections.List _lastnames = null;
public int _tbl1counter = 0;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public com.ab.abmaterial.ABMCard  _buildcard(String _id,String _image,String _title) throws Exception{
com.ab.abmaterial.ABMCard _card4 = null;
 //BA.debugLineNum = 343;BA.debugLine="Sub BuildCard(id As String, image As String, title";
 //BA.debugLineNum = 345;BA.debugLine="Dim card4 As ABMCard";
_card4 = new com.ab.abmaterial.ABMCard();
 //BA.debugLineNum = 346;BA.debugLine="card4.InitializeAsCard(page, \"card\", title, \"This";
_card4.InitializeAsCard(_page,"card",_title,"This is my card content...",_abm.CARD_NOTSPECIFIED,"whitetitle");
 //BA.debugLineNum = 347;BA.debugLine="card4.Image = image";
_card4.Image = _image;
 //BA.debugLineNum = 348;BA.debugLine="Return card4";
if (true) return _card4;
 //BA.debugLineNum = 349;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTable  _buildothertable(String _id) throws Exception{
com.ab.abmaterial.ABMTable _tblinner = null;
int _rand = 0;
int _i = 0;
anywheresoftware.b4a.objects.collections.List _r = null;
anywheresoftware.b4a.objects.collections.List _rcellthemes = null;
int _neg = 0;
 //BA.debugLineNum = 318;BA.debugLine="Sub BuildOtherTable(id As String) As ABMTable";
 //BA.debugLineNum = 320;BA.debugLine="Dim tblinner As ABMTable";
_tblinner = new com.ab.abmaterial.ABMTable();
 //BA.debugLineNum = 321;BA.debugLine="tblinner.Initialize(page, id, True, False, True,";
_tblinner.Initialize(_page,_id,__c.True,__c.False,__c.True,"tbl1theme");
 //BA.debugLineNum = 323;BA.debugLine="Dim rand As Int = Rnd(1,20)";
_rand = __c.Rnd((int) (1),(int) (20));
 //BA.debugLineNum = 324;BA.debugLine="For i = 0 To rand";
{
final int step4 = 1;
final int limit4 = _rand;
_i = (int) (0) ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
 //BA.debugLineNum = 325;BA.debugLine="Dim r As List";
_r = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 326;BA.debugLine="Dim rCellThemes As List";
_rcellthemes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 327;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 328;BA.debugLine="rCellThemes.Initialize";
_rcellthemes.Initialize();
 //BA.debugLineNum = 329;BA.debugLine="Dim Neg As Int = Rnd(0,100)";
_neg = __c.Rnd((int) (0),(int) (100));
 //BA.debugLineNum = 330;BA.debugLine="If Neg > 50 Then";
if (_neg>50) { 
 //BA.debugLineNum = 331;BA.debugLine="r.Add(\"$\" & Rnd(1000, 15000))";
_r.Add((Object)("$"+BA.NumberToString(__c.Rnd((int) (1000),(int) (15000)))));
 //BA.debugLineNum = 332;BA.debugLine="rCellThemes.Add(\"positive\")";
_rcellthemes.Add((Object)("positive"));
 }else {
 //BA.debugLineNum = 334;BA.debugLine="r.Add(\"$-\" & Rnd(1000, 15000))";
_r.Add((Object)("$-"+BA.NumberToString(__c.Rnd((int) (1000),(int) (15000)))));
 //BA.debugLineNum = 335;BA.debugLine="rCellThemes.Add(\"negative\")";
_rcellthemes.Add((Object)("negative"));
 };
 //BA.debugLineNum = 337;BA.debugLine="tblinner.AddRow(id & \"uid\" & i, r)";
_tblinner.AddRow(_id+"uid"+BA.NumberToString(_i),_r);
 //BA.debugLineNum = 338;BA.debugLine="tblinner.SetRowThemes(rCellThemes) ' make sure y";
_tblinner.SetRowThemes(_rcellthemes);
 }
};
 //BA.debugLineNum = 340;BA.debugLine="Return tblinner";
if (true) return _tblinner;
 //BA.debugLineNum = 341;BA.debugLine="End Sub";
return null;
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 141;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 143;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 146;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 147;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 148;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 149;BA.debugLine="page.PageTitle = \"ABMTable\"";
_page.PageTitle = "ABMTable";
 //BA.debugLineNum = 150;BA.debugLine="page.PageDescription = \"The table helper\"";
_page.PageDescription = "The table helper";
 //BA.debugLineNum = 151;BA.debugLine="page.PageHTMLName = \"abmaterial-table.html\"";
_page.PageHTMLName = "abmaterial-table.html";
 //BA.debugLineNum = 152;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 153;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 154;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 155;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 157;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMTable\", \".";
_abmshared._buildnavigationbar(_page,"ABMTable","../images/logo.png","","Helpers","ABMTable");
 //BA.debugLineNum = 160;BA.debugLine="page.AddRows(7,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (7),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 161;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 163;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 164;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 91;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 92;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 95;BA.debugLine="theme.AddTableTheme(\"tbl1theme\")";
_theme.AddTableTheme("tbl1theme");
 //BA.debugLineNum = 96;BA.debugLine="theme.Table(\"tbl1theme\").ZDepth = ABM.ZDEPTH_1";
_theme.Table("tbl1theme").ZDepth = _abm.ZDEPTH_1;
 //BA.debugLineNum = 98;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"headerfoot";
_theme.Table("tbl1theme").AddCellTheme("headerfooter");
 //BA.debugLineNum = 99;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooter\").Bac";
_theme.Table("tbl1theme").Cell("headerfooter").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 100;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooter\").For";
_theme.Table("tbl1theme").Cell("headerfooter").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 102;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"headerfoot";
_theme.Table("tbl1theme").AddCellTheme("headerfooterright");
 //BA.debugLineNum = 103;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooterright\"";
_theme.Table("tbl1theme").Cell("headerfooterright").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 104;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooterright\"";
_theme.Table("tbl1theme").Cell("headerfooterright").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 105;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooterright\"";
_theme.Table("tbl1theme").Cell("headerfooterright").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 107;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"nocolor\")";
_theme.Table("tbl1theme").AddCellTheme("nocolor");
 //BA.debugLineNum = 108;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"nocolor\").ActiveBa";
_theme.Table("tbl1theme").Cell("nocolor").ActiveBackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 109;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"nocolor\").ActiveBa";
_theme.Table("tbl1theme").Cell("nocolor").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 111;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"nocoloredi";
_theme.Table("tbl1theme").AddCellTheme("nocoloredit");
 //BA.debugLineNum = 112;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"nocoloredit\").Acti";
_theme.Table("tbl1theme").Cell("nocoloredit").ActiveBackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 113;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"nocoloredit\").Acti";
_theme.Table("tbl1theme").Cell("nocoloredit").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 114;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"nocoloredit\").IsEd";
_theme.Table("tbl1theme").Cell("nocoloredit").IsEditable = __c.True;
 //BA.debugLineNum = 115;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"nocoloredit\").Inpu";
_theme.Table("tbl1theme").Cell("nocoloredit").InputMask = "'alias':'decimal', 'digits': 2";
 //BA.debugLineNum = 116;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"nocoloredit\").Allo";
_theme.Table("tbl1theme").Cell("nocoloredit").AllowEnterKey = __c.False;
 //BA.debugLineNum = 118;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"positive\")";
_theme.Table("tbl1theme").AddCellTheme("positive");
 //BA.debugLineNum = 119;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").BackCol";
_theme.Table("tbl1theme").Cell("positive").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 120;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").BackCol";
_theme.Table("tbl1theme").Cell("positive").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 121;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").ActiveB";
_theme.Table("tbl1theme").Cell("positive").ActiveBackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 122;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").ActiveB";
_theme.Table("tbl1theme").Cell("positive").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 123;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").Align =";
_theme.Table("tbl1theme").Cell("positive").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 125;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"negative\")";
_theme.Table("tbl1theme").AddCellTheme("negative");
 //BA.debugLineNum = 126;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").BackCol";
_theme.Table("tbl1theme").Cell("negative").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 127;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").BackCol";
_theme.Table("tbl1theme").Cell("negative").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 128;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").ActiveB";
_theme.Table("tbl1theme").Cell("negative").ActiveBackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 129;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").ActiveB";
_theme.Table("tbl1theme").Cell("negative").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 130;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").Align =";
_theme.Table("tbl1theme").Cell("negative").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 132;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"aligntop\")";
_theme.Table("tbl1theme").AddCellTheme("aligntop");
 //BA.debugLineNum = 133;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"aligntop\").Vertica";
_theme.Table("tbl1theme").Cell("aligntop").VerticalAlign = _abm.TABLECELL_VERTICALALIGN_TOP;
 //BA.debugLineNum = 135;BA.debugLine="theme.AddCardTheme(\"whitetitle\")";
_theme.AddCardTheme("whitetitle");
 //BA.debugLineNum = 136;BA.debugLine="theme.Card(\"whitetitle\").TitleForeColor = ABM.COL";
_theme.Card("whitetitle").TitleForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"HelperTablePage\"";
_name = "HelperTablePage";
 //BA.debugLineNum = 12;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 15;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 16;BA.debugLine="Dim FirstNames As List";
_firstnames = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 17;BA.debugLine="Dim LastNames As List";
_lastnames = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 18;BA.debugLine="Dim tbl1Counter As Int = 1";
_tbl1counter = (int) (1);
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMTable _tbl1 = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.List _r = null;
anywheresoftware.b4a.objects.collections.List _rcellthemes = null;
int _neg = 0;
com.ab.abmaterial.ABMPagination _pagination = null;
com.ab.abmaterial.ABMTable _tbl2 = null;
com.ab.abmaterial.ABMTable _tbl3 = null;
String _fname = "";
String _lname = "";
 //BA.debugLineNum = 166;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 168;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 170;BA.debugLine="FirstNames.Initialize2(Array As String(\"Alain\", \"";
_firstnames.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Alain","Jos","Paul","Bertrande","Julie","Stephanie","Bert","Charles","James","Walter"}));
 //BA.debugLineNum = 171;BA.debugLine="LastNames.Initialize2(Array As String(\"Bailleul\",";
_lastnames.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Bailleul","Rogiers","Dougherty","Rodrigues","Ostrander","Kenyon","Grant","Klinger","Sheffield","Poindexter"}));
 //BA.debugLineNum = 174;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","With tables you can create data grids. Tables have build-in goodies like being sortable. Click on the headers for a demo.")));
 //BA.debugLineNum = 177;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraphbq(_page,"par1b","The Id of a table {B}MAY NOT CONTAIN A _ CHARACTER!{/B}.  This is because of the inner working of nested table and the _ character is reserved.")));
 //BA.debugLineNum = 180;BA.debugLine="Dim tbl1 As ABMTable";
_tbl1 = new com.ab.abmaterial.ABMTable();
 //BA.debugLineNum = 181;BA.debugLine="tbl1.Initialize(page, \"tbl1\", True, False, True,";
_tbl1.Initialize(_page,"tbl1",__c.True,__c.False,__c.True,"tbl1theme");
 //BA.debugLineNum = 182;BA.debugLine="tbl1.SetHeaders(Array As String(\"First Name\", \"La";
_tbl1.SetHeaders(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"First Name","Last Name","Sales Profit"}));
 //BA.debugLineNum = 183;BA.debugLine="tbl1.SetColumnDataFields(Array As String(\"FirstNa";
_tbl1.SetColumnDataFields(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"FirstName","LastName","SalesProfit"}));
 //BA.debugLineNum = 184;BA.debugLine="tbl1.SetHeaderThemes(Array As String(\"headerfoote";
_tbl1.SetHeaderThemes(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"headerfooter","headerfooter","headerfooterright"}));
 //BA.debugLineNum = 187;BA.debugLine="For i = 0 To 9";
{
final int step11 = 1;
final int limit11 = (int) (9);
_i = (int) (0) ;
for (;(step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11) ;_i = ((int)(0 + _i + step11))  ) {
 //BA.debugLineNum = 188;BA.debugLine="Dim r As List";
_r = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 189;BA.debugLine="Dim rCellThemes As List";
_rcellthemes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 190;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 191;BA.debugLine="rCellThemes.Initialize";
_rcellthemes.Initialize();
 //BA.debugLineNum = 192;BA.debugLine="r.Add(FirstNames.get(Rnd(0,9)))";
_r.Add(_firstnames.Get(__c.Rnd((int) (0),(int) (9))));
 //BA.debugLineNum = 193;BA.debugLine="rCellThemes.Add(\"nocolor\") ' nocoloredit";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 194;BA.debugLine="r.Add(LastNames.get(Rnd(0,9)))";
_r.Add(_lastnames.Get(__c.Rnd((int) (0),(int) (9))));
 //BA.debugLineNum = 195;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 196;BA.debugLine="Dim Neg As Int = Rnd(0,100)";
_neg = __c.Rnd((int) (0),(int) (100));
 //BA.debugLineNum = 197;BA.debugLine="If Neg > 50 Then";
if (_neg>50) { 
 //BA.debugLineNum = 198;BA.debugLine="r.Add(\"$\" & Rnd(1000, 15000))";
_r.Add((Object)("$"+BA.NumberToString(__c.Rnd((int) (1000),(int) (15000)))));
 //BA.debugLineNum = 199;BA.debugLine="rCellThemes.Add(\"positive\")";
_rcellthemes.Add((Object)("positive"));
 }else {
 //BA.debugLineNum = 201;BA.debugLine="r.Add(\"$-\" & Rnd(1000, 15000))";
_r.Add((Object)("$-"+BA.NumberToString(__c.Rnd((int) (1000),(int) (15000)))));
 //BA.debugLineNum = 202;BA.debugLine="rCellThemes.Add(\"negative\")";
_rcellthemes.Add((Object)("negative"));
 };
 //BA.debugLineNum = 204;BA.debugLine="tbl1.AddRow(\"uid\" & i, r)";
_tbl1.AddRow("uid"+BA.NumberToString(_i),_r);
 //BA.debugLineNum = 205;BA.debugLine="tbl1.SetRowThemes(rCellThemes) ' make sure you h";
_tbl1.SetRowThemes(_rcellthemes);
 }
};
 //BA.debugLineNum = 208;BA.debugLine="tbl1.SetFooter(\"This is a footer that appears on";
_tbl1.SetFooter((Object)("This is a footer that appears on the bottom of the table."),(int) (12),"headerfooter");
 //BA.debugLineNum = 210;BA.debugLine="page.Cell(2,1).AddComponent(tbl1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_tbl1));
 //BA.debugLineNum = 212;BA.debugLine="Dim pagination As ABMPagination";
_pagination = new com.ab.abmaterial.ABMPagination();
 //BA.debugLineNum = 213;BA.debugLine="pagination.Initialize(page, \"pagination\", 10, Tru";
_pagination.Initialize(_page,"pagination",(int) (10),__c.True,__c.True,"");
 //BA.debugLineNum = 214;BA.debugLine="pagination.SetTotalNumberOfPages(20)";
_pagination.SetTotalNumberOfPages((int) (20));
 //BA.debugLineNum = 216;BA.debugLine="page.Cell(3,1).AddComponent(pagination)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_pagination));
 //BA.debugLineNum = 219;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","Tables can be scrollable.  You'll need to set the height of the parent cell and specify the column widths.")));
 //BA.debugLineNum = 222;BA.debugLine="Dim tbl2 As ABMTable";
_tbl2 = new com.ab.abmaterial.ABMTable();
 //BA.debugLineNum = 223;BA.debugLine="tbl2.InitializeScrollable(page, \"tbl2\", True, Fal";
_tbl2.InitializeScrollable(_page,"tbl2",__c.True,__c.False,__c.False,anywheresoftware.b4a.keywords.Common.ArrayToList(new int[]{(int) (300),(int) (300),(int) (150)}),"tbl1theme");
 //BA.debugLineNum = 224;BA.debugLine="tbl2.SetHeaders(Array As String(\"First Name\", \"La";
_tbl2.SetHeaders(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"First Name","Last Name","Sales Profit"}));
 //BA.debugLineNum = 225;BA.debugLine="tbl2.SetHeaderThemes(Array As String(\"headerfoote";
_tbl2.SetHeaderThemes(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"headerfooter","headerfooter","headerfooterright"}));
 //BA.debugLineNum = 227;BA.debugLine="tbl2.SetFooter(\"This is a footer that appears on";
_tbl2.SetFooter((Object)("This is a footer that appears on the bottom of the table."),(int) (12),"headerfooter");
 //BA.debugLineNum = 230;BA.debugLine="page.Cell(5,1).SetFixedHeight(360,True)";
_page.Cell((int) (5),(int) (1)).SetFixedHeight((int) (360),__c.True);
 //BA.debugLineNum = 231;BA.debugLine="page.Cell(5,1).AddComponent(tbl2)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_tbl2));
 //BA.debugLineNum = 234;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","Tables can contain all kind of ABM components.  In the example below we have Cards and even another table (the profits) as a column. Also, it is made interactive so we receive a clicked() event when we click into a cell. Check the source code of this page on how it is done.")));
 //BA.debugLineNum = 237;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraphbq(_page,"par4","Because the profits are random created, the value it reutrns will not match the one you clicked.  This is because when the page was build other values were saved in the html than the ones shown.  In a real world app you would get the values from a database for example so they would match.")));
 //BA.debugLineNum = 240;BA.debugLine="Dim tbl3 As ABMTable";
_tbl3 = new com.ab.abmaterial.ABMTable();
 //BA.debugLineNum = 241;BA.debugLine="tbl3.InitializeScrollable(page, \"tbl3\", False, Fa";
_tbl3.InitializeScrollable(_page,"tbl3",__c.False,__c.False,__c.True,anywheresoftware.b4a.keywords.Common.ArrayToList(new int[]{(int) (300),(int) (200),(int) (200),(int) (150)}),"tbl1theme");
 //BA.debugLineNum = 242;BA.debugLine="tbl3.SetHeaders(Array As String(\"Card\", \"First Na";
_tbl3.SetHeaders(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Card","First Name","Last Name","Sales Profit"}));
 //BA.debugLineNum = 243;BA.debugLine="tbl3.SetHeaderThemes(Array As String(\"headerfoote";
_tbl3.SetHeaderThemes(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"headerfooter","headerfooter","headerfooter","headerfooterright"}));
 //BA.debugLineNum = 245;BA.debugLine="Dim fName, lName As String";
_fname = "";
_lname = "";
 //BA.debugLineNum = 248;BA.debugLine="For i = 0 To 9";
{
final int step52 = 1;
final int limit52 = (int) (9);
_i = (int) (0) ;
for (;(step52 > 0 && _i <= limit52) || (step52 < 0 && _i >= limit52) ;_i = ((int)(0 + _i + step52))  ) {
 //BA.debugLineNum = 249;BA.debugLine="Dim r As List";
_r = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 250;BA.debugLine="Dim rCellThemes As List";
_rcellthemes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 251;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 252;BA.debugLine="rCellThemes.Initialize";
_rcellthemes.Initialize();
 //BA.debugLineNum = 253;BA.debugLine="fName = FirstNames.get(Rnd(0,9))";
_fname = BA.ObjectToString(_firstnames.Get(__c.Rnd((int) (0),(int) (9))));
 //BA.debugLineNum = 254;BA.debugLine="lName = LastNames.get(Rnd(0,9))";
_lname = BA.ObjectToString(_lastnames.Get(__c.Rnd((int) (0),(int) (9))));
 //BA.debugLineNum = 255;BA.debugLine="r.Add(BuildCard(\"card\",\"../images/list\" & (i+1)";
_r.Add((Object)(_buildcard("card","../images/list"+BA.NumberToString((_i+1))+".jpg",_fname+" "+_lname)));
 //BA.debugLineNum = 256;BA.debugLine="rCellThemes.Add(\"aligntop\")";
_rcellthemes.Add((Object)("aligntop"));
 //BA.debugLineNum = 257;BA.debugLine="r.Add(fName)";
_r.Add((Object)(_fname));
 //BA.debugLineNum = 258;BA.debugLine="rCellThemes.Add(\"aligntop\")";
_rcellthemes.Add((Object)("aligntop"));
 //BA.debugLineNum = 259;BA.debugLine="r.Add(lName)";
_r.Add((Object)(_lname));
 //BA.debugLineNum = 260;BA.debugLine="rCellThemes.Add(\"aligntop\")";
_rcellthemes.Add((Object)("aligntop"));
 //BA.debugLineNum = 261;BA.debugLine="r.Add(BuildOtherTable(\"innertable\")) ' <--- note";
_r.Add((Object)(_buildothertable("innertable")));
 //BA.debugLineNum = 262;BA.debugLine="rCellThemes.Add(\"aligntop\")";
_rcellthemes.Add((Object)("aligntop"));
 //BA.debugLineNum = 263;BA.debugLine="tbl3.AddRow(\"uid\" & i, r)";
_tbl3.AddRow("uid"+BA.NumberToString(_i),_r);
 //BA.debugLineNum = 264;BA.debugLine="tbl3.SetRowThemes(rCellThemes) ' make sure you h";
_tbl3.SetRowThemes(_rcellthemes);
 }
};
 //BA.debugLineNum = 267;BA.debugLine="tbl3.SetFooter(\"This is a footer that appears on";
_tbl3.SetFooter((Object)("This is a footer that appears on the bottom of the table."),(int) (12),"headerfooter");
 //BA.debugLineNum = 270;BA.debugLine="page.Cell(7,1).SetFixedHeight(500,True)";
_page.Cell((int) (7),(int) (1)).SetFixedHeight((int) (500),__c.True);
 //BA.debugLineNum = 271;BA.debugLine="page.Cell(7,1).AddComponent(tbl3)";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_tbl3));
 //BA.debugLineNum = 274;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 276;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 279;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 281;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 282;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 22;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 24;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public String  _innertable_clicked(anywheresoftware.b4a.objects.collections.List _passedrowsandcolumns) throws Exception{
com.ab.abmaterial.ABMTableCell _tblcellinfo = null;
com.ab.abmaterial.ABMTable _tbl = null;
com.ab.abmaterial.ABMTableCell _innertblcellinfo = null;
com.ab.abmaterial.ABMTable _innertbl = null;
String _profit = "";
 //BA.debugLineNum = 368;BA.debugLine="Sub innertable_Clicked(PassedRowsAndColumns As Lis";
 //BA.debugLineNum = 371;BA.debugLine="Dim tblCellInfo As ABMTableCell = PassedRowsAndCo";
_tblcellinfo = (com.ab.abmaterial.ABMTableCell)(_passedrowsandcolumns.Get((int) (0)));
 //BA.debugLineNum = 372;BA.debugLine="Dim tbl As ABMTable = page.Cell(6,1).Component(tb";
_tbl = (com.ab.abmaterial.ABMTable)(_page.Cell((int) (6),(int) (1)).Component(_tblcellinfo.TableName));
 //BA.debugLineNum = 374;BA.debugLine="Dim innerTblCellInfo As ABMTableCell = PassedRows";
_innertblcellinfo = (com.ab.abmaterial.ABMTableCell)(_passedrowsandcolumns.Get((int) (1)));
 //BA.debugLineNum = 375;BA.debugLine="Dim innerTbl As ABMTable = tbl.GetComponent(tblCe";
_innertbl = (com.ab.abmaterial.ABMTable)(_tbl.GetComponent(_tblcellinfo.Row,_innertblcellinfo.TableName));
 //BA.debugLineNum = 378;BA.debugLine="Dim profit As String = innerTbl.GetString(innerTb";
_profit = _innertbl.GetString(_innertblcellinfo.Row,_innertblcellinfo.Column);
 //BA.debugLineNum = 379;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 380;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Clicked row "+BA.NumberToString(_innertblcellinfo.Row)+" column "+BA.NumberToString(_innertblcellinfo.Column)+" value="+_profit,(int) (5000));
 //BA.debugLineNum = 381;BA.debugLine="Return";
if (true) return "";
 //BA.debugLineNum = 382;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 296;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 297;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 298;BA.debugLine="If Action = \"ABMTable\" Then Return";
if ((_action).equals("ABMTable")) { 
if (true) return "";};
 //BA.debugLineNum = 299;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 300;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 301;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 302;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 304;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 305;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 306;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 308;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 309;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 59;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 60;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 61;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 62;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 63;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 64;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 65;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 67;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 68;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 69;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 70;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 72;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 74;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 76;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 77;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 78;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 80;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 84;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 311;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 312;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 313;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 314;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 315;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 316;BA.debugLine="End Sub";
return "";
}
public String  _pagination_pagechanged(int _oldpage,int _newpage) throws Exception{
com.ab.abmaterial.ABMPagination _pagination = null;
com.ab.abmaterial.ABMTable _tbl = null;
 //BA.debugLineNum = 426;BA.debugLine="Sub pagination_PageChanged(OldPage As Int, NewPage";
 //BA.debugLineNum = 428;BA.debugLine="Dim pagination As ABMPagination = page.Component(";
_pagination = (com.ab.abmaterial.ABMPagination)(_page.Component("pagination"));
 //BA.debugLineNum = 429;BA.debugLine="pagination.SetActivePage(NewPage) ' IMPORTANT!";
_pagination.SetActivePage(_newpage);
 //BA.debugLineNum = 430;BA.debugLine="pagination.Refresh ' IMPORTANT!";
_pagination.Refresh();
 //BA.debugLineNum = 431;BA.debugLine="Dim tbl As ABMTable = page.Cell(2,1).Component(\"t";
_tbl = (com.ab.abmaterial.ABMTable)(_page.Cell((int) (2),(int) (1)).Component("tbl1"));
 //BA.debugLineNum = 432;BA.debugLine="tbl.SetActiveRow(\"\")";
_tbl.SetActiveRow("");
 //BA.debugLineNum = 433;BA.debugLine="tbl.Refresh";
_tbl.Refresh();
 //BA.debugLineNum = 434;BA.debugLine="End Sub";
return "";
}
public String  _tbl1_clicked(anywheresoftware.b4a.objects.collections.List _passedrowsandcolumns) throws Exception{
com.ab.abmaterial.ABMTableCell _tblcellinfo = null;
com.ab.abmaterial.ABMTable _tbl = null;
String _str = "";
int _value = 0;
com.ab.abmaterial.ABMTable _tbl2 = null;
anywheresoftware.b4a.objects.collections.List _r = null;
anywheresoftware.b4a.objects.collections.List _rcellthemes = null;
int _neg = 0;
com.ab.abmaterial.ABMTable _tbl3 = null;
 //BA.debugLineNum = 384;BA.debugLine="Sub tbl1_Clicked(PassedRowsAndColumns As List)";
 //BA.debugLineNum = 386;BA.debugLine="Dim tblCellInfo As ABMTableCell = PassedRowsAndCo";
_tblcellinfo = (com.ab.abmaterial.ABMTableCell)(_passedrowsandcolumns.Get((int) (0)));
 //BA.debugLineNum = 387;BA.debugLine="Dim tbl As ABMTable = page.Cell(2,1).Component(tb";
_tbl = (com.ab.abmaterial.ABMTable)(_page.Cell((int) (2),(int) (1)).Component(_tblcellinfo.TableName));
 //BA.debugLineNum = 388;BA.debugLine="Dim str As String = tbl.GetString(tblCellInfo.row";
_str = _tbl.GetString(_tblcellinfo.Row,(int) (2));
 //BA.debugLineNum = 389;BA.debugLine="Dim value As Int = ABMShared.Mid(str,2,str.Length";
_value = (int)(Double.parseDouble(_abmshared._mid(_str,(int) (2),(int) (_str.length()-1))));
 //BA.debugLineNum = 393;BA.debugLine="value = value + 10";
_value = (int) (_value+10);
 //BA.debugLineNum = 394;BA.debugLine="tbl.SetString(tblCellInfo.row, 2,\"$\" & value)";
_tbl.SetString(_tblcellinfo.Row,(int) (2),"$"+BA.NumberToString(_value));
 //BA.debugLineNum = 395;BA.debugLine="tbl.RefreshCell(tblCellInfo.Row, 2)";
_tbl.RefreshCell(_tblcellinfo.Row,(int) (2));
 //BA.debugLineNum = 397;BA.debugLine="Dim tbl2 As ABMTable = page.Cell(5,1).Component(\"";
_tbl2 = (com.ab.abmaterial.ABMTable)(_page.Cell((int) (5),(int) (1)).Component("tbl2"));
 //BA.debugLineNum = 398;BA.debugLine="Dim r As List";
_r = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 399;BA.debugLine="Dim rCellThemes As List";
_rcellthemes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 400;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 401;BA.debugLine="rCellThemes.Initialize";
_rcellthemes.Initialize();
 //BA.debugLineNum = 402;BA.debugLine="r.Add(FirstNames.get(Rnd(0,9)))";
_r.Add(_firstnames.Get(__c.Rnd((int) (0),(int) (9))));
 //BA.debugLineNum = 403;BA.debugLine="rCellThemes.Add(\"\")";
_rcellthemes.Add((Object)(""));
 //BA.debugLineNum = 404;BA.debugLine="r.Add(LastNames.get(Rnd(0,9)))";
_r.Add(_lastnames.Get(__c.Rnd((int) (0),(int) (9))));
 //BA.debugLineNum = 405;BA.debugLine="rCellThemes.Add(\"\")";
_rcellthemes.Add((Object)(""));
 //BA.debugLineNum = 406;BA.debugLine="Dim Neg As Int = Rnd(0,100)";
_neg = __c.Rnd((int) (0),(int) (100));
 //BA.debugLineNum = 407;BA.debugLine="If Neg > 50 Then";
if (_neg>50) { 
 //BA.debugLineNum = 408;BA.debugLine="r.Add(\"$\" & Rnd(1000, 15000))";
_r.Add((Object)("$"+BA.NumberToString(__c.Rnd((int) (1000),(int) (15000)))));
 //BA.debugLineNum = 409;BA.debugLine="rCellThemes.Add(\"positive\")";
_rcellthemes.Add((Object)("positive"));
 }else {
 //BA.debugLineNum = 411;BA.debugLine="r.Add(\"$-\" & Rnd(1000, 15000))";
_r.Add((Object)("$-"+BA.NumberToString(__c.Rnd((int) (1000),(int) (15000)))));
 //BA.debugLineNum = 412;BA.debugLine="rCellThemes.Add(\"negative\")";
_rcellthemes.Add((Object)("negative"));
 };
 //BA.debugLineNum = 414;BA.debugLine="tbl1Counter = tbl1Counter + 1";
_tbl1counter = (int) (_tbl1counter+1);
 //BA.debugLineNum = 415;BA.debugLine="tbl2.AddRow(\"uid\" & tbl1Counter, r)";
_tbl2.AddRow("uid"+BA.NumberToString(_tbl1counter),_r);
 //BA.debugLineNum = 416;BA.debugLine="tbl2.SetRowThemes(rCellThemes) ' make sure you h";
_tbl2.SetRowThemes(_rcellthemes);
 //BA.debugLineNum = 420;BA.debugLine="Dim tbl3 As ABMTable = page.Cell(7,1).Component(\"";
_tbl3 = (com.ab.abmaterial.ABMTable)(_page.Cell((int) (7),(int) (1)).Component("tbl3"));
 //BA.debugLineNum = 421;BA.debugLine="tbl3.ScrollTo(\"uid9\", False)";
_tbl3.ScrollTo("uid9",__c.False);
 //BA.debugLineNum = 423;BA.debugLine="tbl2.refresh";
_tbl2.Refresh();
 //BA.debugLineNum = 424;BA.debugLine="End Sub";
return "";
}
public String  _tbl3_clicked(anywheresoftware.b4a.objects.collections.List _passedrowsandcolumns) throws Exception{
com.ab.abmaterial.ABMTableCell _tblcellinfo = null;
com.ab.abmaterial.ABMTable _tbl = null;
com.ab.abmaterial.ABMCard _card = null;
 //BA.debugLineNum = 352;BA.debugLine="Sub tbl3_Clicked(PassedRowsAndColumns As List)";
 //BA.debugLineNum = 354;BA.debugLine="Dim tblCellInfo As ABMTableCell = PassedRowsAndCo";
_tblcellinfo = (com.ab.abmaterial.ABMTableCell)(_passedrowsandcolumns.Get((int) (0)));
 //BA.debugLineNum = 355;BA.debugLine="Dim tbl As ABMTable = page.Cell(7,1).Component(tb";
_tbl = (com.ab.abmaterial.ABMTable)(_page.Cell((int) (7),(int) (1)).Component(_tblcellinfo.TableName));
 //BA.debugLineNum = 356;BA.debugLine="If tblCellInfo.Column = 0 Then";
if (_tblcellinfo.Column==0) { 
 //BA.debugLineNum = 357;BA.debugLine="Dim card As ABMCard = tbl.GetComponent(tblCellIn";
_card = (com.ab.abmaterial.ABMCard)(_tbl.GetComponent(_tblcellinfo.Row,"card"));
 //BA.debugLineNum = 358;BA.debugLine="If card <> Null Then";
if (_card!= null) { 
 //BA.debugLineNum = 359;BA.debugLine="Log(\"We've got the card in row \" & tblCellInfo.";
__c.Log("We've got the card in row "+BA.NumberToString(_tblcellinfo.Row)+" column "+BA.NumberToString(_tblcellinfo.Column)+"!");
 };
 };
 //BA.debugLineNum = 362;BA.debugLine="tbl.Refresh";
_tbl.Refresh();
 //BA.debugLineNum = 363;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 364;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Clicked "+_tblcellinfo.TableName+" row "+BA.NumberToString(_tblcellinfo.Row)+" column "+BA.NumberToString(_tblcellinfo.Column),(int) (5000));
 //BA.debugLineNum = 365;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 27;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 28;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 29;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 30;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 31;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 33;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 34;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 35;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 36;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 40;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 41;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 43;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 45;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 48;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 50;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 52;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 56;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
