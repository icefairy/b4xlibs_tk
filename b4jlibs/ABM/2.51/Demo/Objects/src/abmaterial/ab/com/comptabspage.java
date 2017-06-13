package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class comptabspage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.comptabspage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.comptabspage.class).invoke(this, new Object[] {null});
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
public String  _btn1_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMTabs _tabs = null;
 //BA.debugLineNum = 333;BA.debugLine="Sub btn1_Clicked(Target As String)";
 //BA.debugLineNum = 334;BA.debugLine="Dim tabs As ABMTabs = page.Component(\"tabs\")";
_tabs = (com.ab.abmaterial.ABMTabs)(_page.Component("tabs"));
 //BA.debugLineNum = 335;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 336;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toast\", tabs";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toast",_tabs.GetActive()+" is active!",(int) (5000));
 //BA.debugLineNum = 337;BA.debugLine="End Sub";
return "";
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 145;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 147;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 150;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 151;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 152;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 153;BA.debugLine="page.PageTitle = \"ABMTabs\"";
_page.PageTitle = "ABMTabs";
 //BA.debugLineNum = 154;BA.debugLine="page.PageDescription = \"The tabs component \"";
_page.PageDescription = "The tabs component ";
 //BA.debugLineNum = 155;BA.debugLine="page.PageHTMLName = \"abmaterial-tabs.html\"";
_page.PageHTMLName = "abmaterial-tabs.html";
 //BA.debugLineNum = 156;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 157;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 158;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 159;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 161;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMTabs\", \"..";
_abmshared._buildnavigationbar(_page,"ABMTabs","../images/logo.png","","Controls","ABMTabs");
 //BA.debugLineNum = 164;BA.debugLine="page.AddRows(5,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (5),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 165;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 167;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 168;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMContainer  _buildtabcontainer(String _id,String _text) throws Exception{
com.ab.abmaterial.ABMContainer _tabc = null;
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 296;BA.debugLine="Sub BuildTabContainer(id As String, Text As String";
 //BA.debugLineNum = 297;BA.debugLine="Dim Tabc As ABMContainer";
_tabc = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 298;BA.debugLine="Tabc.Initialize(page, id,\"tabpagewhite\")";
_tabc.Initialize(_page,_id,"tabpagewhite");
 //BA.debugLineNum = 300;BA.debugLine="Tabc.AddRows(1,True, \"\").AddCells12(1,\"\")";
_tabc.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 301;BA.debugLine="Tabc.BuildGrid 'IMPORTANT once you loaded the com";
_tabc.BuildGrid();
 //BA.debugLineNum = 303;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 304;BA.debugLine="lbl.Initialize(page, id & \"lbl\", Text, ABM.SIZE_H";
_lbl.Initialize(_page,_id+"lbl",_text,_abm.SIZE_H5,__c.True,"");
 //BA.debugLineNum = 305;BA.debugLine="Tabc.Cell(1,1).AddComponent(lbl)";
_tabc.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl));
 //BA.debugLineNum = 306;BA.debugLine="Return Tabc";
if (true) return _tabc;
 //BA.debugLineNum = 307;BA.debugLine="End Sub";
return null;
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 95;BA.debugLine="theme.AddButtonTheme(\"bluegrey\")";
_theme.AddButtonTheme("bluegrey");
 //BA.debugLineNum = 96;BA.debugLine="theme.Button(\"bluegrey\").BackColor = ABM.COLOR_BL";
_theme.Button("bluegrey").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 97;BA.debugLine="theme.Button(\"bluegrey\").BackColorIntensity = ABM";
_theme.Button("bluegrey").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 100;BA.debugLine="theme.AddTabsTheme(\"tabsgreen\")";
_theme.AddTabsTheme("tabsgreen");
 //BA.debugLineNum = 101;BA.debugLine="theme.Tabs(\"tabsgreen\").ForeColor = ABM.COLOR_AMB";
_theme.Tabs("tabsgreen").ForeColor = _abm.COLOR_AMBER;
 //BA.debugLineNum = 102;BA.debugLine="theme.Tabs(\"tabsgreen\").HoverForeColor = ABM.COLO";
_theme.Tabs("tabsgreen").HoverForeColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 103;BA.debugLine="theme.Tabs(\"tabsgreen\").IndicatorColor = ABM.COLO";
_theme.Tabs("tabsgreen").IndicatorColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 106;BA.debugLine="theme.AddContainerTheme(\"tabpagewhite\")";
_theme.AddContainerTheme("tabpagewhite");
 //BA.debugLineNum = 107;BA.debugLine="theme.Container(\"tabpagewhite\").BackColor = ABM.C";
_theme.Container("tabpagewhite").BackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 108;BA.debugLine="theme.Container(\"tabpagewhite\").ZDepth = ABM.ZDEP";
_theme.Container("tabpagewhite").ZDepth = _abm.ZDEPTH_1;
 //BA.debugLineNum = 111;BA.debugLine="theme.AddTableTheme(\"tbl1theme\")";
_theme.AddTableTheme("tbl1theme");
 //BA.debugLineNum = 112;BA.debugLine="theme.Table(\"tbl1theme\").ZDepth = ABM.ZDEPTH_1";
_theme.Table("tbl1theme").ZDepth = _abm.ZDEPTH_1;
 //BA.debugLineNum = 114;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"headerfoot";
_theme.Table("tbl1theme").AddCellTheme("headerfooter");
 //BA.debugLineNum = 115;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooter\").Bac";
_theme.Table("tbl1theme").Cell("headerfooter").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 116;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooter\").For";
_theme.Table("tbl1theme").Cell("headerfooter").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 118;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"headerfoot";
_theme.Table("tbl1theme").AddCellTheme("headerfooterright");
 //BA.debugLineNum = 119;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooterright\"";
_theme.Table("tbl1theme").Cell("headerfooterright").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 120;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooterright\"";
_theme.Table("tbl1theme").Cell("headerfooterright").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 121;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooterright\"";
_theme.Table("tbl1theme").Cell("headerfooterright").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 123;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"nocolor\")";
_theme.Table("tbl1theme").AddCellTheme("nocolor");
 //BA.debugLineNum = 124;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"nocolor\").ActiveBa";
_theme.Table("tbl1theme").Cell("nocolor").ActiveBackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 125;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"nocolor\").ActiveBa";
_theme.Table("tbl1theme").Cell("nocolor").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 127;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"positive\")";
_theme.Table("tbl1theme").AddCellTheme("positive");
 //BA.debugLineNum = 128;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").BackCol";
_theme.Table("tbl1theme").Cell("positive").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 129;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").BackCol";
_theme.Table("tbl1theme").Cell("positive").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 130;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").ActiveB";
_theme.Table("tbl1theme").Cell("positive").ActiveBackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 131;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").ActiveB";
_theme.Table("tbl1theme").Cell("positive").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 132;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").Align =";
_theme.Table("tbl1theme").Cell("positive").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 134;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"negative\")";
_theme.Table("tbl1theme").AddCellTheme("negative");
 //BA.debugLineNum = 135;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").BackCol";
_theme.Table("tbl1theme").Cell("negative").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 136;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").BackCol";
_theme.Table("tbl1theme").Cell("negative").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 137;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").ActiveB";
_theme.Table("tbl1theme").Cell("negative").ActiveBackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 138;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").ActiveB";
_theme.Table("tbl1theme").Cell("negative").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 139;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").Align =";
_theme.Table("tbl1theme").Cell("negative").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 141;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"aligntop\")";
_theme.Table("tbl1theme").AddCellTheme("aligntop");
 //BA.debugLineNum = 142;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"aligntop\").Vertica";
_theme.Table("tbl1theme").Cell("aligntop").VerticalAlign = _abm.TABLECELL_VERTICALALIGN_TOP;
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompTabsPage\"";
_name = "CompTabsPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMTabs _tabs = null;
com.ab.abmaterial.ABMTable _tbl1 = null;
anywheresoftware.b4a.objects.collections.List _firstnames = null;
anywheresoftware.b4a.objects.collections.List _lastnames = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.List _r = null;
anywheresoftware.b4a.objects.collections.List _rcellthemes = null;
int _neg = 0;
com.ab.abmaterial.ABMContainer _tbl1cont = null;
com.ab.abmaterial.ABMButton _btn1 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code2 = null;
 //BA.debugLineNum = 170;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 172;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 175;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Introduction")));
 //BA.debugLineNum = 177;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","The tabs structure consists of an unordered list of tabs. Then when you click on each tab, only the container with the corresponding tab id will become visible. You can set disabled to make a tab inaccessible.")));
 //BA.debugLineNum = 180;BA.debugLine="Dim tabs As ABMTabs";
_tabs = new com.ab.abmaterial.ABMTabs();
 //BA.debugLineNum = 181;BA.debugLine="tabs.Initialize(page, \"tabs\", \"\")";
_tabs.Initialize(_page,"tabs","");
 //BA.debugLineNum = 184;BA.debugLine="tabs.AddTab(\"tab1\", \"Demo TAB 1 Text\", BuildTabCo";
_tabs.AddTab("tab1","Demo TAB 1 Text",_buildtabcontainer("tab1","Demo tab text TAB1"),(int) (3),(int) (3),(int) (3),(int) (12),(int) (12),(int) (12),__c.True,__c.False,"","");
 //BA.debugLineNum = 185;BA.debugLine="tabs.AddTab(\"tab2\", \"Demo TAB 2 Text\", BuildTabCo";
_tabs.AddTab("tab2","Demo TAB 2 Text",_buildtabcontainer("tab2","Demo tab text TAB2"),(int) (3),(int) (3),(int) (3),(int) (12),(int) (12),(int) (12),__c.True,__c.True,"mdi-action-account-circle","");
 //BA.debugLineNum = 186;BA.debugLine="tabs.AddTab(\"tab3\", \"Demo TAB 3 Text\", BuildTabCo";
_tabs.AddTab("tab3","Demo TAB 3 Text",_buildtabcontainer("tab3","Demo tab text TAB3"),(int) (3),(int) (3),(int) (3),(int) (12),(int) (12),(int) (12),__c.False,__c.False,"","");
 //BA.debugLineNum = 190;BA.debugLine="Dim tbl1 As ABMTable";
_tbl1 = new com.ab.abmaterial.ABMTable();
 //BA.debugLineNum = 191;BA.debugLine="tbl1.Initialize(page, \"tbl1\", True, False, True,";
_tbl1.Initialize(_page,"tbl1",__c.True,__c.False,__c.True,"tbl1theme");
 //BA.debugLineNum = 192;BA.debugLine="tbl1.SetHeaders(Array As String(\"First Name\", \"La";
_tbl1.SetHeaders(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"First Name","Last Name","Sales Profit"}));
 //BA.debugLineNum = 193;BA.debugLine="tbl1.SetHeaderThemes(Array As String(\"headerfoote";
_tbl1.SetHeaderThemes(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"headerfooter","headerfooter","headerfooterright"}));
 //BA.debugLineNum = 195;BA.debugLine="Dim FirstNames As List";
_firstnames = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 196;BA.debugLine="Dim LastNames As List";
_lastnames = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 198;BA.debugLine="FirstNames.Initialize2(Array As String(\"Alain\", \"";
_firstnames.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Alain","Jos","Paul","Bertrande","Julie","Stephanie","Bert","Charles","James","Walter"}));
 //BA.debugLineNum = 199;BA.debugLine="LastNames.Initialize2(Array As String(\"Bailleul\",";
_lastnames.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Bailleul","Rogiers","Dougherty","Rodrigues","Ostrander","Kenyon","Grant","Klinger","Sheffield","Pointdexter"}));
 //BA.debugLineNum = 202;BA.debugLine="For i = 0 To 9";
{
final int step17 = 1;
final int limit17 = (int) (9);
_i = (int) (0) ;
for (;(step17 > 0 && _i <= limit17) || (step17 < 0 && _i >= limit17) ;_i = ((int)(0 + _i + step17))  ) {
 //BA.debugLineNum = 203;BA.debugLine="Dim r As List";
_r = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 204;BA.debugLine="Dim rCellThemes As List";
_rcellthemes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 205;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 206;BA.debugLine="rCellThemes.Initialize";
_rcellthemes.Initialize();
 //BA.debugLineNum = 207;BA.debugLine="r.Add(FirstNames.get(Rnd(0,9)))";
_r.Add(_firstnames.Get(__c.Rnd((int) (0),(int) (9))));
 //BA.debugLineNum = 208;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 209;BA.debugLine="r.Add(LastNames.get(Rnd(0,9)))";
_r.Add(_lastnames.Get(__c.Rnd((int) (0),(int) (9))));
 //BA.debugLineNum = 210;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 211;BA.debugLine="Dim Neg As Int = Rnd(0,100)";
_neg = __c.Rnd((int) (0),(int) (100));
 //BA.debugLineNum = 212;BA.debugLine="If Neg > 50 Then";
if (_neg>50) { 
 //BA.debugLineNum = 213;BA.debugLine="r.Add(\"$\" & Rnd(1000, 15000))";
_r.Add((Object)("$"+BA.NumberToString(__c.Rnd((int) (1000),(int) (15000)))));
 //BA.debugLineNum = 214;BA.debugLine="rCellThemes.Add(\"positive\")";
_rcellthemes.Add((Object)("positive"));
 }else {
 //BA.debugLineNum = 216;BA.debugLine="r.Add(\"$-\" & Rnd(1000, 15000))";
_r.Add((Object)("$-"+BA.NumberToString(__c.Rnd((int) (1000),(int) (15000)))));
 //BA.debugLineNum = 217;BA.debugLine="rCellThemes.Add(\"negative\")";
_rcellthemes.Add((Object)("negative"));
 };
 //BA.debugLineNum = 219;BA.debugLine="tbl1.AddRow(\"uid\" & i, r)";
_tbl1.AddRow("uid"+BA.NumberToString(_i),_r);
 //BA.debugLineNum = 220;BA.debugLine="tbl1.SetRowThemes(rCellThemes) ' make sure you h";
_tbl1.SetRowThemes(_rcellthemes);
 }
};
 //BA.debugLineNum = 223;BA.debugLine="tbl1.SetFooter(\"This is a footer that appears on";
_tbl1.SetFooter((Object)("This is a footer that appears on the bottom of the table."),(int) (12),"headerfooter");
 //BA.debugLineNum = 225;BA.debugLine="Dim tbl1cont As ABMContainer";
_tbl1cont = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 226;BA.debugLine="tbl1cont.Initialize(page, \"tblcont\",\"tabpagewhite";
_tbl1cont.Initialize(_page,"tblcont","tabpagewhite");
 //BA.debugLineNum = 228;BA.debugLine="tbl1cont.AddRows(1,True, \"\").AddCells12(1,\"\")";
_tbl1cont.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 229;BA.debugLine="tbl1cont.BuildGrid 'IMPORTANT once you loaded the";
_tbl1cont.BuildGrid();
 //BA.debugLineNum = 230;BA.debugLine="tbl1cont.Cell(1,1).AddComponent(tbl1)";
_tbl1cont.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_tbl1));
 //BA.debugLineNum = 232;BA.debugLine="tabs.AddTab(\"tab4\", \"Demo TAB 4 Text\", tbl1cont,3";
_tabs.AddTab("tab4","Demo TAB 4 Text",_tbl1cont,(int) (3),(int) (3),(int) (3),(int) (12),(int) (12),(int) (12),__c.True,__c.False,"","");
 //BA.debugLineNum = 236;BA.debugLine="page.Cell(2,1).AddComponent(tabs)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_tabs));
 //BA.debugLineNum = 239;BA.debugLine="Dim btn1 As ABMButton";
_btn1 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 240;BA.debugLine="btn1.InitializeRaised(page, \"btn1\", \"\", \"\", \"Get";
_btn1.InitializeRaised(_page,"btn1","","","Get active","bluegrey");
 //BA.debugLineNum = 241;BA.debugLine="page.Cell(3,1).AddComponent(btn1)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn1));
 //BA.debugLineNum = 244;BA.debugLine="Dim code As StringBuilder";
_code = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 245;BA.debugLine="code.Initialize";
_code.Initialize();
 //BA.debugLineNum = 246;BA.debugLine="code.Append(\"Dim tabs As ABMTabs\").Append(CRLF)";
_code.Append("Dim tabs As ABMTabs").Append(__c.CRLF);
 //BA.debugLineNum = 247;BA.debugLine="code.Append(\"tabs.Initialize(page, \"\"tabs\"\", \"\"\"\"";
_code.Append("tabs.Initialize(page, \"tabs\", \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 248;BA.debugLine="code.Append(\"\").Append(CRLF)";
_code.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 249;BA.debugLine="code.Append(\"// create the tabs As ABMContainer.\"";
_code.Append("// create the tabs As ABMContainer.").Append(__c.CRLF);
 //BA.debugLineNum = 250;BA.debugLine="code.Append(\"tabs.AddTab(\"\"tab1\"\", \"\"TAB 1\"\", Bui";
_code.Append("tabs.AddTab(\"tab1\", \"TAB 1\", BuildTabContainer(page, \"tab1\", \"Demo TAB text\"),3,3,3,12,12,12,True,False)").Append(__c.CRLF);
 //BA.debugLineNum = 251;BA.debugLine="code.Append(\"tabs.AddTab(\"\"tab2\"\", \"\"TAB 2\"\", Bui";
_code.Append("tabs.AddTab(\"tab2\", \"TAB 2\", BuildTabContainer(page, \"tab2\", \"Demo TAB text\"),3,3,3,12,12,12,True,True)").Append(__c.CRLF);
 //BA.debugLineNum = 252;BA.debugLine="code.Append(\"tabs.AddTab(\"\"tab3\"\", \"\"TAB 3\"\", Bui";
_code.Append("tabs.AddTab(\"tab3\", \"TAB 3\", BuildTabContainer(page, \"tab3\", \"Demo TAB text\"),3,3,3,12,12,12,False,False)").Append(__c.CRLF);
 //BA.debugLineNum = 253;BA.debugLine="code.Append(\"tabs.AddTab(\"\"tab4\"\", \"\"TAB 4\"\", Bui";
_code.Append("tabs.AddTab(\"tab4\", \"TAB 4\", BuildTabContainer(page, \"tab4\", \"Demo TAB text\"),3,3,3,12,12,12,True,False)").Append(__c.CRLF);
 //BA.debugLineNum = 254;BA.debugLine="code.Append(\"\").Append(CRLF)";
_code.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 255;BA.debugLine="code.Append(\"// add to row\").Append(CRLF)";
_code.Append("// add to row").Append(__c.CRLF);
 //BA.debugLineNum = 256;BA.debugLine="code.Append(\"page.Cell(2,1).AddComponent(tabs)\").";
_code.Append("page.Cell(2,1).AddComponent(tabs)").Append(__c.CRLF);
 //BA.debugLineNum = 258;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code",_code)));
 //BA.debugLineNum = 261;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","The code for BuildTabContainer:")));
 //BA.debugLineNum = 264;BA.debugLine="Dim code2 As StringBuilder";
_code2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 265;BA.debugLine="code2.Initialize";
_code2.Initialize();
 //BA.debugLineNum = 266;BA.debugLine="code2.Append(\"public Sub BuildTabContainer(page A";
_code2.Append("public Sub BuildTabContainer(page As ABMPage, id As String, Text As String) As ABMContainer").Append(__c.CRLF);
 //BA.debugLineNum = 267;BA.debugLine="code2.Append(\"  Dim Tabc As ABMContainer\").Append";
_code2.Append("  Dim Tabc As ABMContainer").Append(__c.CRLF);
 //BA.debugLineNum = 268;BA.debugLine="code2.Append(\"  Tabc.Initialize(page, id, \"\"tabpa";
_code2.Append("  Tabc.Initialize(page, id, \"tabpagewhite\")").Append(__c.CRLF);
 //BA.debugLineNum = 269;BA.debugLine="code2.Append(\"\").Append(CRLF)";
_code2.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 270;BA.debugLine="code2.Append(\"  tabc.AddRows(1,True, \"\"\"\").AddCel";
_code2.Append("  tabc.AddRows(1,True, \"\").AddCells12(1,\"\")").Append(__c.CRLF);
 //BA.debugLineNum = 271;BA.debugLine="code2.Append(\"  Dim lbl As ABMLabel\").Append(CRLF";
_code2.Append("  Dim lbl As ABMLabel").Append(__c.CRLF);
 //BA.debugLineNum = 272;BA.debugLine="code2.Append(\"  lbl.Initialize(page, id & \"\"lbl\"\"";
_code2.Append("  lbl.Initialize(page, id & \"lbl\", Text, ABM.SIZE_H5, True, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 273;BA.debugLine="code2.Append(\"  Tabc.Cell(1,1).AddComponent(lbl)\"";
_code2.Append("  Tabc.Cell(1,1).AddComponent(lbl)").Append(__c.CRLF);
 //BA.debugLineNum = 274;BA.debugLine="code2.Append(\"  Return Tabc\").Append(CRLF)";
_code2.Append("  Return Tabc").Append(__c.CRLF);
 //BA.debugLineNum = 275;BA.debugLine="code2.Append(\"End Sub\").Append(CRLF)";
_code2.Append("End Sub").Append(__c.CRLF);
 //BA.debugLineNum = 277;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code2",_code2)));
 //BA.debugLineNum = 280;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 282;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 285;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 287;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 288;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 311;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 312;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 313;BA.debugLine="If Action = \"ABMTabs\" Then Return";
if ((_action).equals("ABMTabs")) { 
if (true) return "";};
 //BA.debugLineNum = 314;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 315;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 316;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 317;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 319;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 320;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 321;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 323;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 324;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 326;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 327;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 328;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 329;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 330;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 331;BA.debugLine="End Sub";
return "";
}
public String  _tbl1_clicked(anywheresoftware.b4a.objects.collections.List _passedrowsandcolumns) throws Exception{
com.ab.abmaterial.ABMTableCell _tblcellinfo = null;
 //BA.debugLineNum = 290;BA.debugLine="Sub tbl1_Clicked(PassedRowsAndColumns As List)";
 //BA.debugLineNum = 292;BA.debugLine="Dim tblCellInfo As ABMTableCell = PassedRowsAndCo";
_tblcellinfo = (com.ab.abmaterial.ABMTableCell)(_passedrowsandcolumns.Get((int) (0)));
 //BA.debugLineNum = 293;BA.debugLine="Log(tblCellInfo.TableName)";
__c.Log(_tblcellinfo.TableName);
 //BA.debugLineNum = 294;BA.debugLine="End Sub";
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
