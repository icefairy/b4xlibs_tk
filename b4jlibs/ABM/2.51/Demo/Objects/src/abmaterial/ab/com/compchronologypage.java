package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compchronologypage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compchronologypage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compchronologypage.class).invoke(this, new Object[] {null});
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
public String  _btn_clicked(String _target) throws Exception{
String _slidenr = "";
com.ab.abmaterial.ABMChronologyList _chrono = null;
 //BA.debugLineNum = 319;BA.debugLine="Sub btn_Clicked(Target As String)";
 //BA.debugLineNum = 320;BA.debugLine="Log(Target)";
__c.Log(_target);
 //BA.debugLineNum = 321;BA.debugLine="Dim slideNr As String = ABMShared.Mid2(Target,4)";
_slidenr = _abmshared._mid2(_target,(int) (4));
 //BA.debugLineNum = 322;BA.debugLine="Log(slideNr)";
__c.Log(_slidenr);
 //BA.debugLineNum = 323;BA.debugLine="Dim chrono As ABMChronologyList = page.Component(";
_chrono = (com.ab.abmaterial.ABMChronologyList)(_page.Component("chrono"));
 //BA.debugLineNum = 324;BA.debugLine="chrono.SetSlideTheme(\"Slide\" & slideNr, \"green\")";
_chrono.SetSlideTheme("Slide"+_slidenr,"green");
 //BA.debugLineNum = 325;BA.debugLine="chrono.GetSlideContainer(\"Slide\" & slideNr).Cell(";
_chrono.GetSlideContainer("Slide"+_slidenr).Cell((int) (3),(int) (1)).RemoveAllComponents();
 //BA.debugLineNum = 326;BA.debugLine="chrono.GetSlideContainer(\"Slide\" & slideNr).Row(1";
_chrono.GetSlideContainer("Slide"+_slidenr).Row((int) (1)).UseTheme("green");
 //BA.debugLineNum = 327;BA.debugLine="chrono.Refresh";
_chrono.Refresh();
 //BA.debugLineNum = 328;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMContainer  _buildfiche(String _id,String _title,String _pic,String _themename) throws Exception{
com.ab.abmaterial.ABMContainer _fiche = null;
com.ab.abmaterial.ABMLabel _titlabel = null;
com.ab.abmaterial.ABMLabel _titlabel2 = null;
com.ab.abmaterial.ABMTable _tbl1 = null;
anywheresoftware.b4a.objects.collections.List _firstnames = null;
anywheresoftware.b4a.objects.collections.List _lastnames = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.List _r = null;
anywheresoftware.b4a.objects.collections.List _rcellthemes = null;
int _neg = 0;
com.ab.abmaterial.ABMLabel _body = null;
com.ab.abmaterial.ABMButton _btn = null;
 //BA.debugLineNum = 231;BA.debugLine="Sub BuildFiche(id As String, Title As String, pic";
 //BA.debugLineNum = 232;BA.debugLine="Dim Fiche As ABMContainer";
_fiche = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 233;BA.debugLine="Fiche.Initialize(page, \"fiche\" & id, \"\")";
_fiche.Initialize(_page,"fiche"+_id,"");
 //BA.debugLineNum = 235;BA.debugLine="Fiche.AddRowsM(1, False,0,0, themeName).AddCellsO";
_fiche.AddRowsM((int) (1),__c.False,(int) (0),(int) (0),_themename).AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (12),(int) (12),(int) (0),(int) (12),(int) (10),(int) (10),"");
 //BA.debugLineNum = 236;BA.debugLine="If themeName = \"black\" Then";
if ((_themename).equals("black")) { 
 //BA.debugLineNum = 237;BA.debugLine="Fiche.AddRowsM(1, False,0,0, \"\").AddCellsOSMP(1,";
_fiche.AddRowsM((int) (1),__c.False,(int) (0),(int) (0),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (12),(int) (12),(int) (0),(int) (0),(int) (0),(int) (0),"");
 }else {
 //BA.debugLineNum = 239;BA.debugLine="Fiche.AddRowsM(1, True,0,0, \"\").AddCellsOSMP(1,0";
_fiche.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (12),(int) (12),(int) (0),(int) (0),(int) (0),(int) (0),"");
 };
 //BA.debugLineNum = 241;BA.debugLine="If themeName = \"red\" Then";
if ((_themename).equals("red")) { 
 //BA.debugLineNum = 242;BA.debugLine="Fiche.AddRowsM(1, True,0,10, \"\").AddCellsOSMP(1,";
_fiche.AddRowsM((int) (1),__c.True,(int) (0),(int) (10),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (12),(int) (12),(int) (0),(int) (0),(int) (0),(int) (0),"");
 };
 //BA.debugLineNum = 245;BA.debugLine="Fiche.BuildGrid";
_fiche.BuildGrid();
 //BA.debugLineNum = 246;BA.debugLine="If themeName = \"black\" Then";
if ((_themename).equals("black")) { 
 //BA.debugLineNum = 247;BA.debugLine="Fiche.Row(2).MarginLeft = \"auto\"";
_fiche.Row((int) (2)).MarginLeft = "auto";
 //BA.debugLineNum = 248;BA.debugLine="Fiche.Row(2).MarginRight = \"auto\"";
_fiche.Row((int) (2)).MarginRight = "auto";
 };
 //BA.debugLineNum = 251;BA.debugLine="Fiche.Row(1).MarginLeft = \"0\"";
_fiche.Row((int) (1)).MarginLeft = "0";
 //BA.debugLineNum = 252;BA.debugLine="Fiche.Row(1).MarginRight = \"0\"";
_fiche.Row((int) (1)).MarginRight = "0";
 //BA.debugLineNum = 254;BA.debugLine="Dim titLabel As ABMLabel";
_titlabel = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 255;BA.debugLine="titLabel.Initialize(page, \"titlabel\" & id, Title,";
_titlabel.Initialize(_page,"titlabel"+_id,_title,_abm.SIZE_H5,__c.False,"white");
 //BA.debugLineNum = 256;BA.debugLine="Fiche.Cell(1,1).AddComponent(titLabel)";
_fiche.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_titlabel));
 //BA.debugLineNum = 257;BA.debugLine="Dim titLabel2 As ABMLabel";
_titlabel2 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 258;BA.debugLine="titLabel2.Initialize(page, \"titlabel2_\" & id, ABM";
_titlabel2.Initialize(_page,"titlabel2_"+_id,_abm.Util.words(__c.Rnd((int) (1),(int) (5))),_abm.SIZE_H6,__c.False,"white");
 //BA.debugLineNum = 259;BA.debugLine="Fiche.Cell(1,1).AddComponent(titLabel2)";
_fiche.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_titlabel2));
 //BA.debugLineNum = 261;BA.debugLine="If pic <> \"\" Then";
if ((_pic).equals("") == false) { 
 //BA.debugLineNum = 262;BA.debugLine="Fiche.Cell(2,1).AddComponent(ABMShared.BuildImag";
_fiche.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildimage(_page,"ficheimg"+_id,_pic,1,"Garden")));
 };
 //BA.debugLineNum = 265;BA.debugLine="If themeName = \"black\" Then";
if ((_themename).equals("black")) { 
 //BA.debugLineNum = 267;BA.debugLine="Dim tbl1 As ABMTable";
_tbl1 = new com.ab.abmaterial.ABMTable();
 //BA.debugLineNum = 268;BA.debugLine="tbl1.Initialize(page, \"tbl1\", True, False, True,";
_tbl1.Initialize(_page,"tbl1",__c.True,__c.False,__c.True,"tbl1theme");
 //BA.debugLineNum = 269;BA.debugLine="tbl1.SetHeaders(Array As String(\"First Name\", \"L";
_tbl1.SetHeaders(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"First Name","Last Name","Sales Profit"}));
 //BA.debugLineNum = 270;BA.debugLine="tbl1.SetHeaderThemes(Array As String(\"headerfoot";
_tbl1.SetHeaderThemes(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"headerfooter","headerfooter","headerfooterright"}));
 //BA.debugLineNum = 272;BA.debugLine="Dim FirstNames As List";
_firstnames = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 273;BA.debugLine="Dim LastNames As List";
_lastnames = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 275;BA.debugLine="FirstNames.Initialize2(Array As String(\"Alain\",";
_firstnames.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Alain","Jos","Paul","Bertrande","Julie","Stephanie","Bert","Charles","James","Walter"}));
 //BA.debugLineNum = 276;BA.debugLine="LastNames.Initialize2(Array As String(\"Bailleul\"";
_lastnames.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Bailleul","Rogiers","Dougherty","Rodrigues","Ostrander","Kenyon","Grant","Klinger","Sheffield","Pointdexter"}));
 //BA.debugLineNum = 279;BA.debugLine="For i = 0 To 9";
{
final int step37 = 1;
final int limit37 = (int) (9);
for (_i = (int) (0) ; (step37 > 0 && _i <= limit37) || (step37 < 0 && _i >= limit37); _i = ((int)(0 + _i + step37)) ) {
 //BA.debugLineNum = 280;BA.debugLine="Dim r As List";
_r = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 281;BA.debugLine="Dim rCellThemes As List";
_rcellthemes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 282;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 283;BA.debugLine="rCellThemes.Initialize";
_rcellthemes.Initialize();
 //BA.debugLineNum = 284;BA.debugLine="r.Add(FirstNames.get(Rnd(0,9)))";
_r.Add(_firstnames.Get(__c.Rnd((int) (0),(int) (9))));
 //BA.debugLineNum = 285;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 286;BA.debugLine="r.Add(LastNames.get(Rnd(0,9)))";
_r.Add(_lastnames.Get(__c.Rnd((int) (0),(int) (9))));
 //BA.debugLineNum = 287;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 288;BA.debugLine="Dim Neg As Int = Rnd(0,100)";
_neg = __c.Rnd((int) (0),(int) (100));
 //BA.debugLineNum = 289;BA.debugLine="If Neg > 50 Then";
if (_neg>50) { 
 //BA.debugLineNum = 290;BA.debugLine="r.Add(\"$\" & Rnd(1000, 15000))";
_r.Add((Object)("$"+BA.NumberToString(__c.Rnd((int) (1000),(int) (15000)))));
 //BA.debugLineNum = 291;BA.debugLine="rCellThemes.Add(\"positive\")";
_rcellthemes.Add((Object)("positive"));
 }else {
 //BA.debugLineNum = 293;BA.debugLine="r.Add(\"$-\" & Rnd(1000, 15000))";
_r.Add((Object)("$-"+BA.NumberToString(__c.Rnd((int) (1000),(int) (15000)))));
 //BA.debugLineNum = 294;BA.debugLine="rCellThemes.Add(\"negative\")";
_rcellthemes.Add((Object)("negative"));
 };
 //BA.debugLineNum = 296;BA.debugLine="tbl1.AddRow(\"uid\" & i, r)";
_tbl1.AddRow("uid"+BA.NumberToString(_i),_r);
 //BA.debugLineNum = 297;BA.debugLine="tbl1.SetRowThemes(rCellThemes) ' make sure you";
_tbl1.SetRowThemes(_rcellthemes);
 }
};
 //BA.debugLineNum = 300;BA.debugLine="tbl1.SetFooter(\"This is a footer that appears on";
_tbl1.SetFooter((Object)("This is a footer that appears on the bottom of the table."),(int) (12),"headerfooter");
 //BA.debugLineNum = 302;BA.debugLine="Fiche.Cell(2,1).AddComponent(tbl1)";
_fiche.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_tbl1));
 }else {
 //BA.debugLineNum = 305;BA.debugLine="Dim body As ABMLabel";
_body = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 306;BA.debugLine="body.Initialize(page, \"body\" & id, ABM.Util.sent";
_body.Initialize(_page,"body"+_id,_abm.Util.sentences(__c.Rnd((int) (1),(int) (10))),_abm.SIZE_PARAGRAPH,__c.True,"");
 //BA.debugLineNum = 307;BA.debugLine="Fiche.Cell(2,1).AddComponent(body)";
_fiche.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_body));
 };
 //BA.debugLineNum = 310;BA.debugLine="If themeName = \"red\" Then";
if ((_themename).equals("red")) { 
 //BA.debugLineNum = 311;BA.debugLine="Dim btn As ABMButton";
_btn = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 312;BA.debugLine="btn.InitializeFlat(page, id, \"\", \"\", \"Validate\",";
_btn.InitializeFlat(_page,_id,"","","Validate","");
 //BA.debugLineNum = 313;BA.debugLine="Fiche.Cell(3,1).AddArrayComponent(btn, \"btn\")";
_fiche.Cell((int) (3),(int) (1)).AddArrayComponent((com.ab.abmaterial.ABMComponent)(_btn),"btn");
 };
 //BA.debugLineNum = 316;BA.debugLine="Return Fiche";
if (true) return _fiche;
 //BA.debugLineNum = 317;BA.debugLine="End Sub";
return null;
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 172;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 174;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 177;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 178;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 179;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 180;BA.debugLine="page.PageTitle = \"ABMaterial\"";
_page.PageTitle = "ABMaterial";
 //BA.debugLineNum = 181;BA.debugLine="page.PageDescription = \"About material design wit";
_page.PageDescription = "About material design with ABMaterial ";
 //BA.debugLineNum = 182;BA.debugLine="page.PageHTMLName = \"abmaterial-chronology.html\"";
_page.PageHTMLName = "abmaterial-chronology.html";
 //BA.debugLineNum = 183;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 184;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 185;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 186;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 188;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMChronology";
_abmshared._buildnavigationbar(_page,"ABMChronologyList","../images/logo.png","","Controls","ABMChronologyList");
 //BA.debugLineNum = 191;BA.debugLine="page.AddRows(3,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (3),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 192;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 194;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 92;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 94;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 95;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 100;BA.debugLine="theme.AddCardTheme(\"whitetitle\")";
_theme.AddCardTheme("whitetitle");
 //BA.debugLineNum = 101;BA.debugLine="theme.Card(\"whitetitle\").TitleForeColor = ABM.COL";
_theme.Card("whitetitle").TitleForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 103;BA.debugLine="theme.AddChronologyList(\"chrono\")";
_theme.AddChronologyList("chrono");
 //BA.debugLineNum = 104;BA.debugLine="theme.ChronologyList(\"chrono\").AddChronologyBadge";
_theme.ChronologyList("chrono").AddChronologyBadgeTheme("blue");
 //BA.debugLineNum = 105;BA.debugLine="theme.ChronologyList(\"chrono\").ChronologyBadge(\"b";
_theme.ChronologyList("chrono").ChronologyBadge("blue").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 106;BA.debugLine="theme.ChronologyList(\"chrono\").ChronologyBadge(\"b";
_theme.ChronologyList("chrono").ChronologyBadge("blue").ColorizePointer = __c.True;
 //BA.debugLineNum = 107;BA.debugLine="theme.ChronologyList(\"chrono\").ChronologyBadge(\"b";
_theme.ChronologyList("chrono").ChronologyBadge("blue").IconName = "mdi-maps-directions-car";
 //BA.debugLineNum = 109;BA.debugLine="theme.ChronologyList(\"chrono\").AddChronologyBadge";
_theme.ChronologyList("chrono").AddChronologyBadgeTheme("red");
 //BA.debugLineNum = 110;BA.debugLine="theme.ChronologyList(\"chrono\").ChronologyBadge(\"r";
_theme.ChronologyList("chrono").ChronologyBadge("red").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 111;BA.debugLine="theme.ChronologyList(\"chrono\").ChronologyBadge(\"r";
_theme.ChronologyList("chrono").ChronologyBadge("red").ColorizePointer = __c.True;
 //BA.debugLineNum = 112;BA.debugLine="theme.ChronologyList(\"chrono\").ChronologyBadge(\"r";
_theme.ChronologyList("chrono").ChronologyBadge("red").IconName = "mdi-action-report-problem";
 //BA.debugLineNum = 114;BA.debugLine="theme.ChronologyList(\"chrono\").AddChronologyBadge";
_theme.ChronologyList("chrono").AddChronologyBadgeTheme("green");
 //BA.debugLineNum = 115;BA.debugLine="theme.ChronologyList(\"chrono\").ChronologyBadge(\"g";
_theme.ChronologyList("chrono").ChronologyBadge("green").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 116;BA.debugLine="theme.ChronologyList(\"chrono\").ChronologyBadge(\"g";
_theme.ChronologyList("chrono").ChronologyBadge("green").ColorizePointer = __c.True;
 //BA.debugLineNum = 117;BA.debugLine="theme.ChronologyList(\"chrono\").ChronologyBadge(\"g";
_theme.ChronologyList("chrono").ChronologyBadge("green").IconName = "mdi-action-assignment-turned-in";
 //BA.debugLineNum = 119;BA.debugLine="theme.ChronologyList(\"chrono\").AddChronologyBadge";
_theme.ChronologyList("chrono").AddChronologyBadgeTheme("black");
 //BA.debugLineNum = 120;BA.debugLine="theme.ChronologyList(\"chrono\").ChronologyBadge(\"b";
_theme.ChronologyList("chrono").ChronologyBadge("black").BackColor = _abm.COLOR_BLACK;
 //BA.debugLineNum = 121;BA.debugLine="theme.ChronologyList(\"chrono\").ChronologyBadge(\"b";
_theme.ChronologyList("chrono").ChronologyBadge("black").ColorizePointer = __c.True;
 //BA.debugLineNum = 122;BA.debugLine="theme.ChronologyList(\"chrono\").ChronologyBadge(\"b";
_theme.ChronologyList("chrono").ChronologyBadge("black").IconName = "mdi-action-dashboard";
 //BA.debugLineNum = 124;BA.debugLine="theme.AddRowTheme(\"blue\")";
_theme.AddRowTheme("blue");
 //BA.debugLineNum = 125;BA.debugLine="theme.Row(\"blue\").BackColor = ABM.COLOR_LIGHTBLUE";
_theme.Row("blue").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 126;BA.debugLine="theme.AddRowTheme(\"green\")";
_theme.AddRowTheme("green");
 //BA.debugLineNum = 127;BA.debugLine="theme.Row(\"green\").BackColor = ABM.COLOR_GREEN";
_theme.Row("green").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 128;BA.debugLine="theme.AddRowTheme(\"red\")";
_theme.AddRowTheme("red");
 //BA.debugLineNum = 129;BA.debugLine="theme.Row(\"red\").BackColor = ABM.COLOR_RED";
_theme.Row("red").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 130;BA.debugLine="theme.AddRowTheme(\"black\")";
_theme.AddRowTheme("black");
 //BA.debugLineNum = 131;BA.debugLine="theme.Row(\"black\").BackColor = ABM.COLOR_BLACK";
_theme.Row("black").BackColor = _abm.COLOR_BLACK;
 //BA.debugLineNum = 134;BA.debugLine="theme.AddTableTheme(\"tbl1theme\")";
_theme.AddTableTheme("tbl1theme");
 //BA.debugLineNum = 135;BA.debugLine="theme.Table(\"tbl1theme\").ZDepth = ABM.ZDEPTH_1";
_theme.Table("tbl1theme").ZDepth = _abm.ZDEPTH_1;
 //BA.debugLineNum = 137;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"headerfoot";
_theme.Table("tbl1theme").AddCellTheme("headerfooter");
 //BA.debugLineNum = 138;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooter\").Bac";
_theme.Table("tbl1theme").Cell("headerfooter").BackColor = _abm.COLOR_BLACK;
 //BA.debugLineNum = 139;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooter\").For";
_theme.Table("tbl1theme").Cell("headerfooter").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 141;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"headerfoot";
_theme.Table("tbl1theme").AddCellTheme("headerfooterright");
 //BA.debugLineNum = 142;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooterright\"";
_theme.Table("tbl1theme").Cell("headerfooterright").BackColor = _abm.COLOR_BLACK;
 //BA.debugLineNum = 143;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooterright\"";
_theme.Table("tbl1theme").Cell("headerfooterright").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 144;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooterright\"";
_theme.Table("tbl1theme").Cell("headerfooterright").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 146;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"nocolor\")";
_theme.Table("tbl1theme").AddCellTheme("nocolor");
 //BA.debugLineNum = 147;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"nocolor\").ActiveBa";
_theme.Table("tbl1theme").Cell("nocolor").ActiveBackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 148;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"nocolor\").ActiveBa";
_theme.Table("tbl1theme").Cell("nocolor").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 150;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"positive\")";
_theme.Table("tbl1theme").AddCellTheme("positive");
 //BA.debugLineNum = 151;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").BackCol";
_theme.Table("tbl1theme").Cell("positive").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 152;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").BackCol";
_theme.Table("tbl1theme").Cell("positive").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 153;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").ActiveB";
_theme.Table("tbl1theme").Cell("positive").ActiveBackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 154;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").ActiveB";
_theme.Table("tbl1theme").Cell("positive").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 155;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").Align =";
_theme.Table("tbl1theme").Cell("positive").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 157;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"negative\")";
_theme.Table("tbl1theme").AddCellTheme("negative");
 //BA.debugLineNum = 158;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").BackCol";
_theme.Table("tbl1theme").Cell("negative").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 159;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").BackCol";
_theme.Table("tbl1theme").Cell("negative").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 160;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").ActiveB";
_theme.Table("tbl1theme").Cell("negative").ActiveBackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 161;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").ActiveB";
_theme.Table("tbl1theme").Cell("negative").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 162;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").Align =";
_theme.Table("tbl1theme").Cell("negative").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 164;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"aligntop\")";
_theme.Table("tbl1theme").AddCellTheme("aligntop");
 //BA.debugLineNum = 165;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"aligntop\").Vertica";
_theme.Table("tbl1theme").Cell("aligntop").VerticalAlign = _abm.TABLECELL_VERTICALALIGN_TOP;
 //BA.debugLineNum = 167;BA.debugLine="theme.AddLabelTheme(\"white\")";
_theme.AddLabelTheme("white");
 //BA.debugLineNum = 168;BA.debugLine="theme.Label(\"white\").ForeColor = ABM.COLOR_WHITE";
_theme.Label("white").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 170;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompChronologyPage\"";
_name = "CompChronologyPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMChronologyList _chrono = null;
 //BA.debugLineNum = 197;BA.debugLine="public Sub ConnectPage()";
 //BA.debugLineNum = 199;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 202;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","The ABMChronologyList is a vertical timeline component.  Useful to give an overview of a limited period.")));
 //BA.debugLineNum = 205;BA.debugLine="Dim chrono As ABMChronologyList";
_chrono = new com.ab.abmaterial.ABMChronologyList();
 //BA.debugLineNum = 206;BA.debugLine="chrono.Initialize(page, \"chrono\", \"chrono\")";
_chrono.Initialize(_page,"chrono","chrono");
 //BA.debugLineNum = 207;BA.debugLine="chrono.AddSlide(\"Slide1\", BuildFiche(1, \"08:05 -";
_chrono.AddSlide("Slide1",_buildfiche(BA.NumberToString(1),"08:05 - 08:29","","blue"),"blue");
 //BA.debugLineNum = 208;BA.debugLine="chrono.AddSlide(\"Slide2\", BuildFiche(2, \"08:29 -";
_chrono.AddSlide("Slide2",_buildfiche(BA.NumberToString(2),"08:29 - 10:05","../images/gardenbefore.jpg","green"),"green");
 //BA.debugLineNum = 209;BA.debugLine="chrono.AddSlide(\"Slide3\", BuildFiche(3, \"10:05 -";
_chrono.AddSlide("Slide3",_buildfiche(BA.NumberToString(3),"10:05 - 10:12","","green"),"green");
 //BA.debugLineNum = 210;BA.debugLine="chrono.AddSlide(\"Slide4\", BuildFiche(4, \"10:12 -";
_chrono.AddSlide("Slide4",_buildfiche(BA.NumberToString(4),"10:12 - 11:59","","red"),"red");
 //BA.debugLineNum = 211;BA.debugLine="chrono.AddSlide(\"Slide5\", BuildFiche(5, \"Used Mat";
_chrono.AddSlide("Slide5",_buildfiche(BA.NumberToString(5),"Used Material","","black"),"black");
 //BA.debugLineNum = 212;BA.debugLine="chrono.AddSlide(\"Slide6\", BuildFiche(6, \"11:59 -";
_chrono.AddSlide("Slide6",_buildfiche(BA.NumberToString(6),"11:59 - 12:25","","green"),"green");
 //BA.debugLineNum = 213;BA.debugLine="chrono.AddSlide(\"Slide7\", BuildFiche(7, \"12:25 -";
_chrono.AddSlide("Slide7",_buildfiche(BA.NumberToString(7),"12:25 - 15:02","","green"),"green");
 //BA.debugLineNum = 214;BA.debugLine="chrono.AddSlide(\"Slide8\", BuildFiche(8, \"15:02 -";
_chrono.AddSlide("Slide8",_buildfiche(BA.NumberToString(8),"15:02 - 15:17","","green"),"green");
 //BA.debugLineNum = 215;BA.debugLine="chrono.AddSlide(\"Slide9\", BuildFiche(9, \"15:17 -";
_chrono.AddSlide("Slide9",_buildfiche(BA.NumberToString(9),"15:17 - 16:32","","red"),"red");
 //BA.debugLineNum = 216;BA.debugLine="chrono.AddSlide(\"Slide10\", BuildFiche(10, \"16:32";
_chrono.AddSlide("Slide10",_buildfiche(BA.NumberToString(10),"16:32 - 17:43","../images/gardenafter.jpg","green"),"green");
 //BA.debugLineNum = 217;BA.debugLine="chrono.AddSlide(\"Slide11\", BuildFiche(11, \"17:43";
_chrono.AddSlide("Slide11",_buildfiche(BA.NumberToString(11),"17:43 - 18:07","","blue"),"blue");
 //BA.debugLineNum = 218;BA.debugLine="page.Cell(2,1).AddComponent(chrono)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_chrono));
 //BA.debugLineNum = 221;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 223;BA.debugLine="page.Refresh ' IMPORTANT!";
_page.Refresh();
 //BA.debugLineNum = 226;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 228;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 229;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 23;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 26;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 331;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 332;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 333;BA.debugLine="If Action = \"About\" Then Return";
if ((_action).equals("About")) { 
if (true) return "";};
 //BA.debugLineNum = 334;BA.debugLine="If Action = \"ABMChronologyList\" Then";
if ((_action).equals("ABMChronologyList")) { 
 //BA.debugLineNum = 335;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 336;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 337;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 339;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 340;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 341;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 343;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 344;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 62;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 63;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 64;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 65;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 66;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 67;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 68;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 70;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 71;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 72;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 73;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 75;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 77;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 79;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 80;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 81;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 83;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 87;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 346;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 347;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 348;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 349;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 350;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 351;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 30;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 31;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 32;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 33;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 34;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 36;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 37;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 38;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 39;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 43;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 44;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 46;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 48;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 51;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 53;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 55;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 58;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 59;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
