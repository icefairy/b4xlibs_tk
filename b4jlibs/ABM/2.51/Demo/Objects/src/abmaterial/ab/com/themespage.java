package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class themespage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.themespage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.themespage.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.collections.List _colors = null;
public anywheresoftware.b4a.objects.collections.List _intensities = null;
public anywheresoftware.b4a.objects.collections.List _zdepths = null;
public int _rowteller = 0;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public com.ab.abmaterial.ABMTable  _buildcolortable12(String _col) throws Exception{
com.ab.abmaterial.ABMTable _tbl1 = null;
String _colstring = "";
int _i = 0;
anywheresoftware.b4a.objects.collections.List _r = null;
anywheresoftware.b4a.objects.collections.List _t = null;
com.ab.abmaterial.ABMLabel _lbl = null;
String _intensity = "";
 //BA.debugLineNum = 390;BA.debugLine="Sub BuildColorTable12(Col As String) As ABMTable";
 //BA.debugLineNum = 392;BA.debugLine="Dim tbl1 As ABMTable";
_tbl1 = new com.ab.abmaterial.ABMTable();
 //BA.debugLineNum = 393;BA.debugLine="tbl1.Initialize(page, \"tbl1\" & Col, False, False,";
_tbl1.Initialize(_page,"tbl1"+_col,__c.False,__c.False,__c.False,"ColorTable");
 //BA.debugLineNum = 395;BA.debugLine="Dim ColString As String = \"COLOR_\" & Col.ToUpperC";
_colstring = "COLOR_"+_col.toUpperCase();
 //BA.debugLineNum = 397;BA.debugLine="For i = 0 To 9";
{
final int step4 = 1;
final int limit4 = (int) (9);
for (_i = (int) (0) ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
 //BA.debugLineNum = 398;BA.debugLine="Dim r As List";
_r = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 399;BA.debugLine="Dim t As List";
_t = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 400;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 401;BA.debugLine="t.Initialize";
_t.Initialize();
 //BA.debugLineNum = 402;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 403;BA.debugLine="Dim Intensity As String = \"INTENSITY_\" & Intensi";
_intensity = "INTENSITY_"+BA.ObjectToString(_intensities.Get(_i));
 //BA.debugLineNum = 404;BA.debugLine="Intensity = Intensity.ToUpperCase";
_intensity = _intensity.toUpperCase();
 //BA.debugLineNum = 405;BA.debugLine="If i < 6 Then";
if (_i<6) { 
 //BA.debugLineNum = 406;BA.debugLine="lbl.Initialize(page, \"lbl\" & Col, ColString & \"";
_lbl.Initialize(_page,"lbl"+_col,_colstring+"{BR}"+_intensity,_abm.SIZE_PARAGRAPH,__c.False,"black");
 }else {
 //BA.debugLineNum = 408;BA.debugLine="lbl.Initialize(page, \"lbl\" & Col, ColString & \"";
_lbl.Initialize(_page,"lbl"+_col,_colstring+"{BR}"+_intensity,_abm.SIZE_PARAGRAPH,__c.False,"white");
 };
 //BA.debugLineNum = 410;BA.debugLine="r.Add(lbl)";
_r.Add((Object)(_lbl));
 //BA.debugLineNum = 411;BA.debugLine="t.Add(Col & i)";
_t.Add((Object)(_col+BA.NumberToString(_i)));
 //BA.debugLineNum = 412;BA.debugLine="RowTeller = RowTeller + 1";
_rowteller = (int) (_rowteller+1);
 //BA.debugLineNum = 413;BA.debugLine="tbl1.AddRow(\"uidct\" & RowTeller, r)";
_tbl1.AddRow("uidct"+BA.NumberToString(_rowteller),_r);
 //BA.debugLineNum = 414;BA.debugLine="tbl1.SetRowThemes(t)";
_tbl1.SetRowThemes(_t);
 }
};
 //BA.debugLineNum = 416;BA.debugLine="Return tbl1";
if (true) return _tbl1;
 //BA.debugLineNum = 417;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTable  _buildcolortable16(String _col) throws Exception{
com.ab.abmaterial.ABMTable _tbl1 = null;
String _colstring = "";
int _i = 0;
anywheresoftware.b4a.objects.collections.List _r = null;
anywheresoftware.b4a.objects.collections.List _t = null;
com.ab.abmaterial.ABMLabel _lbl = null;
String _intensity = "";
 //BA.debugLineNum = 361;BA.debugLine="Sub BuildColorTable16(Col As String) As ABMTable";
 //BA.debugLineNum = 363;BA.debugLine="Dim tbl1 As ABMTable";
_tbl1 = new com.ab.abmaterial.ABMTable();
 //BA.debugLineNum = 364;BA.debugLine="tbl1.Initialize(page, \"tbl1\" & Col, False, False,";
_tbl1.Initialize(_page,"tbl1"+_col,__c.False,__c.False,__c.False,"ColorTable");
 //BA.debugLineNum = 366;BA.debugLine="Dim ColString As String = \"COLOR_\" & Col.ToUpperC";
_colstring = "COLOR_"+_col.toUpperCase();
 //BA.debugLineNum = 368;BA.debugLine="For i = 0 To 13";
{
final int step4 = 1;
final int limit4 = (int) (13);
for (_i = (int) (0) ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
 //BA.debugLineNum = 369;BA.debugLine="Dim r As List";
_r = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 370;BA.debugLine="Dim t As List";
_t = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 371;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 372;BA.debugLine="t.Initialize";
_t.Initialize();
 //BA.debugLineNum = 373;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 374;BA.debugLine="Dim Intensity As String = \"INTENSITY_\" & Intensi";
_intensity = "INTENSITY_"+BA.ObjectToString(_intensities.Get(_i));
 //BA.debugLineNum = 375;BA.debugLine="Intensity = Intensity.ToUpperCase";
_intensity = _intensity.toUpperCase();
 //BA.debugLineNum = 376;BA.debugLine="If i < 6 Or i > 9 Then";
if (_i<6 || _i>9) { 
 //BA.debugLineNum = 377;BA.debugLine="lbl.Initialize(page, \"lbl\" & Col, ColString & \"";
_lbl.Initialize(_page,"lbl"+_col,_colstring+"{BR} "+_intensity,_abm.SIZE_PARAGRAPH,__c.False,"black");
 }else {
 //BA.debugLineNum = 379;BA.debugLine="lbl.Initialize(page, \"lbl\" & Col, ColString & \"";
_lbl.Initialize(_page,"lbl"+_col,_colstring+"{BR}"+_intensity,_abm.SIZE_PARAGRAPH,__c.False,"white");
 };
 //BA.debugLineNum = 381;BA.debugLine="r.Add(lbl)";
_r.Add((Object)(_lbl));
 //BA.debugLineNum = 382;BA.debugLine="t.Add(Col & i)";
_t.Add((Object)(_col+BA.NumberToString(_i)));
 //BA.debugLineNum = 383;BA.debugLine="RowTeller = RowTeller + 1";
_rowteller = (int) (_rowteller+1);
 //BA.debugLineNum = 384;BA.debugLine="tbl1.AddRow(\"uidct\" & RowTeller, r)";
_tbl1.AddRow("uidct"+BA.NumberToString(_rowteller),_r);
 //BA.debugLineNum = 385;BA.debugLine="tbl1.SetRowThemes(t)";
_tbl1.SetRowThemes(_t);
 }
};
 //BA.debugLineNum = 387;BA.debugLine="Return tbl1";
if (true) return _tbl1;
 //BA.debugLineNum = 388;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMTable  _buildcolortableother() throws Exception{
com.ab.abmaterial.ABMTable _tbl1 = null;
anywheresoftware.b4a.objects.collections.List _r = null;
anywheresoftware.b4a.objects.collections.List _t = null;
com.ab.abmaterial.ABMLabel _lbl1 = null;
 //BA.debugLineNum = 419;BA.debugLine="Sub BuildColorTableOther() As ABMTable";
 //BA.debugLineNum = 421;BA.debugLine="Dim tbl1 As ABMTable";
_tbl1 = new com.ab.abmaterial.ABMTable();
 //BA.debugLineNum = 422;BA.debugLine="tbl1.Initialize(page, \"tbl1\", False, False, False";
_tbl1.Initialize(_page,"tbl1",__c.False,__c.False,__c.False,"ColorTable");
 //BA.debugLineNum = 425;BA.debugLine="Dim r As List";
_r = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 426;BA.debugLine="Dim t As List";
_t = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 428;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 429;BA.debugLine="t.Initialize";
_t.Initialize();
 //BA.debugLineNum = 430;BA.debugLine="Dim lbl1 As ABMLabel";
_lbl1 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 431;BA.debugLine="lbl1.Initialize(page, \"lbl\", \"COLOR_BLACK{BR}{NBS";
_lbl1.Initialize(_page,"lbl","COLOR_BLACK{BR}{NBSP}",_abm.SIZE_PARAGRAPH,__c.False,"white");
 //BA.debugLineNum = 432;BA.debugLine="r.Add(lbl1)";
_r.Add((Object)(_lbl1));
 //BA.debugLineNum = 433;BA.debugLine="t.Add(\"black\")";
_t.Add((Object)("black"));
 //BA.debugLineNum = 434;BA.debugLine="RowTeller = RowTeller + 1";
_rowteller = (int) (_rowteller+1);
 //BA.debugLineNum = 435;BA.debugLine="tbl1.AddRow(\"uidcd\" & RowTeller, r)";
_tbl1.AddRow("uidcd"+BA.NumberToString(_rowteller),_r);
 //BA.debugLineNum = 436;BA.debugLine="tbl1.SetRowThemes(t)";
_tbl1.SetRowThemes(_t);
 //BA.debugLineNum = 438;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 439;BA.debugLine="t.Initialize";
_t.Initialize();
 //BA.debugLineNum = 440;BA.debugLine="Dim lbl1 As ABMLabel";
_lbl1 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 441;BA.debugLine="lbl1.Initialize(page, \"lbl\", \"COLOR_WHITE{BR}{NBS";
_lbl1.Initialize(_page,"lbl","COLOR_WHITE{BR}{NBSP}",_abm.SIZE_PARAGRAPH,__c.False,"black");
 //BA.debugLineNum = 442;BA.debugLine="r.Add(lbl1)";
_r.Add((Object)(_lbl1));
 //BA.debugLineNum = 443;BA.debugLine="t.Add(\"white\")";
_t.Add((Object)("white"));
 //BA.debugLineNum = 444;BA.debugLine="RowTeller = RowTeller + 1";
_rowteller = (int) (_rowteller+1);
 //BA.debugLineNum = 445;BA.debugLine="tbl1.AddRow(\"uidcd\" & RowTeller, r)";
_tbl1.AddRow("uidcd"+BA.NumberToString(_rowteller),_r);
 //BA.debugLineNum = 446;BA.debugLine="tbl1.SetRowThemes(t)";
_tbl1.SetRowThemes(_t);
 //BA.debugLineNum = 448;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 449;BA.debugLine="t.Initialize";
_t.Initialize();
 //BA.debugLineNum = 450;BA.debugLine="Dim lbl1 As ABMLabel";
_lbl1 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 451;BA.debugLine="lbl1.Initialize(page, \"lbl\", \"COLOR_TRANSPARENT{B";
_lbl1.Initialize(_page,"lbl","COLOR_TRANSPARENT{BR}{NBSP}",_abm.SIZE_PARAGRAPH,__c.False,"black");
 //BA.debugLineNum = 452;BA.debugLine="r.Add(lbl1)";
_r.Add((Object)(_lbl1));
 //BA.debugLineNum = 453;BA.debugLine="t.Add(\"transparent\")";
_t.Add((Object)("transparent"));
 //BA.debugLineNum = 454;BA.debugLine="RowTeller = RowTeller + 1";
_rowteller = (int) (_rowteller+1);
 //BA.debugLineNum = 455;BA.debugLine="tbl1.AddRow(\"uidcd\" & RowTeller, r)";
_tbl1.AddRow("uidcd"+BA.NumberToString(_rowteller),_r);
 //BA.debugLineNum = 456;BA.debugLine="tbl1.SetRowThemes(t)";
_tbl1.SetRowThemes(_t);
 //BA.debugLineNum = 458;BA.debugLine="Return tbl1";
if (true) return _tbl1;
 //BA.debugLineNum = 459;BA.debugLine="End Sub";
return null;
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 137;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 139;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 142;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 143;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 144;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 145;BA.debugLine="page.PageTitle = \"Themes\"";
_page.PageTitle = "Themes";
 //BA.debugLineNum = 146;BA.debugLine="page.PageDescription = \"The themes and colors in";
_page.PageDescription = "The themes and colors in ABMaterial";
 //BA.debugLineNum = 147;BA.debugLine="page.PageHTMLName = \"abmaterial-theme-color.html\"";
_page.PageHTMLName = "abmaterial-theme-color.html";
 //BA.debugLineNum = 148;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 149;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 150;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 151;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 153;BA.debugLine="ABMShared.BuildNavigationBar(page, \"Themes\", \"../";
_abmshared._buildnavigationbar(_page,"Themes","../images/logo.png","","Themes","");
 //BA.debugLineNum = 156;BA.debugLine="page.AddRows(5,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (5),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 157;BA.debugLine="page.AddRows(7,True, \"\").AddCellsOS(3,0,0,0,4,4,4";
_page.AddRows((int) (7),__c.True,"").AddCellsOS((int) (3),(int) (0),(int) (0),(int) (0),(int) (4),(int) (4),(int) (4),"");
 //BA.debugLineNum = 158;BA.debugLine="page.AddRows(4,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (4),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 159;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 165;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
int _i = 0;
int _j = 0;
 //BA.debugLineNum = 91;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 93;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 94;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 97;BA.debugLine="Colors.Initialize2(Array As String(ABM.COLOR_RED,";
_colors.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{_abm.COLOR_RED,_abm.COLOR_PINK,_abm.COLOR_PURPLE,_abm.COLOR_DEEPPURPLE,_abm.COLOR_INDIGO,_abm.COLOR_BLUE,_abm.COLOR_LIGHTBLUE,_abm.COLOR_CYAN,_abm.COLOR_TEAL,_abm.COLOR_GREEN,_abm.COLOR_LIGHTGREEN,_abm.COLOR_LIME,_abm.COLOR_YELLOW,_abm.COLOR_AMBER,_abm.COLOR_ORANGE,_abm.COLOR_DEEPORANGE,_abm.COLOR_BROWN,_abm.COLOR_GREY,_abm.COLOR_BLUEGREY}));
 //BA.debugLineNum = 98;BA.debugLine="Intensities.Initialize2(Array As String(ABM.INTEN";
_intensities.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{_abm.INTENSITY_LIGHTEN5,_abm.INTENSITY_LIGHTEN4,_abm.INTENSITY_LIGHTEN3,_abm.INTENSITY_LIGHTEN2,_abm.INTENSITY_LIGHTEN1,_abm.INTENSITY_NORMAL,_abm.INTENSITY_DARKEN1,_abm.INTENSITY_DARKEN2,_abm.INTENSITY_DARKEN3,_abm.INTENSITY_DARKEN4,_abm.INTENSITY_ACCENT1,_abm.INTENSITY_ACCENT2,_abm.INTENSITY_ACCENT3,_abm.INTENSITY_ACCENT4}));
 //BA.debugLineNum = 100;BA.debugLine="theme.AddTableTheme(\"ColorTable\")";
_theme.AddTableTheme("ColorTable");
 //BA.debugLineNum = 101;BA.debugLine="For i = 0 To 15";
{
final int step6 = 1;
final int limit6 = (int) (15);
for (_i = (int) (0) ; (step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6); _i = ((int)(0 + _i + step6)) ) {
 //BA.debugLineNum = 102;BA.debugLine="For j = 0 To 13";
{
final int step7 = 1;
final int limit7 = (int) (13);
for (_j = (int) (0) ; (step7 > 0 && _j <= limit7) || (step7 < 0 && _j >= limit7); _j = ((int)(0 + _j + step7)) ) {
 //BA.debugLineNum = 103;BA.debugLine="theme.Table(\"ColorTable\").AddCellTheme(Colors.G";
_theme.Table("ColorTable").AddCellTheme(BA.ObjectToString(_colors.Get(_i))+BA.NumberToString(_j));
 //BA.debugLineNum = 104;BA.debugLine="theme.Table(\"ColorTable\").Cell(Colors.Get(i) &";
_theme.Table("ColorTable").Cell(BA.ObjectToString(_colors.Get(_i))+BA.NumberToString(_j)).BackColor = BA.ObjectToString(_colors.Get(_i));
 //BA.debugLineNum = 105;BA.debugLine="theme.Table(\"ColorTable\").Cell(Colors.Get(i) &";
_theme.Table("ColorTable").Cell(BA.ObjectToString(_colors.Get(_i))+BA.NumberToString(_j)).BackColorIntensity = BA.ObjectToString(_intensities.Get(_j));
 }
};
 }
};
 //BA.debugLineNum = 108;BA.debugLine="For i = 16 To 18";
{
final int step13 = 1;
final int limit13 = (int) (18);
for (_i = (int) (16) ; (step13 > 0 && _i <= limit13) || (step13 < 0 && _i >= limit13); _i = ((int)(0 + _i + step13)) ) {
 //BA.debugLineNum = 109;BA.debugLine="For j = 0 To 9";
{
final int step14 = 1;
final int limit14 = (int) (9);
for (_j = (int) (0) ; (step14 > 0 && _j <= limit14) || (step14 < 0 && _j >= limit14); _j = ((int)(0 + _j + step14)) ) {
 //BA.debugLineNum = 110;BA.debugLine="theme.Table(\"ColorTable\").AddCellTheme(Colors.G";
_theme.Table("ColorTable").AddCellTheme(BA.ObjectToString(_colors.Get(_i))+BA.NumberToString(_j));
 //BA.debugLineNum = 111;BA.debugLine="theme.Table(\"ColorTable\").Cell(Colors.Get(i) &";
_theme.Table("ColorTable").Cell(BA.ObjectToString(_colors.Get(_i))+BA.NumberToString(_j)).BackColor = BA.ObjectToString(_colors.Get(_i));
 //BA.debugLineNum = 112;BA.debugLine="theme.Table(\"ColorTable\").Cell(Colors.Get(i) &";
_theme.Table("ColorTable").Cell(BA.ObjectToString(_colors.Get(_i))+BA.NumberToString(_j)).BackColorIntensity = BA.ObjectToString(_intensities.Get(_j));
 }
};
 }
};
 //BA.debugLineNum = 115;BA.debugLine="theme.Table(\"ColorTable\").AddCellTheme(\"black\")";
_theme.Table("ColorTable").AddCellTheme("black");
 //BA.debugLineNum = 116;BA.debugLine="theme.Table(\"ColorTable\").Cell(\"black\").BackColor";
_theme.Table("ColorTable").Cell("black").BackColor = _abm.COLOR_BLACK;
 //BA.debugLineNum = 117;BA.debugLine="theme.Table(\"ColorTable\").AddCellTheme(\"white\")";
_theme.Table("ColorTable").AddCellTheme("white");
 //BA.debugLineNum = 118;BA.debugLine="theme.Table(\"ColorTable\").Cell(\"white\").BackColor";
_theme.Table("ColorTable").Cell("white").BackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 119;BA.debugLine="theme.Table(\"ColorTable\").AddCellTheme(\"transpare";
_theme.Table("ColorTable").AddCellTheme("transparent");
 //BA.debugLineNum = 120;BA.debugLine="theme.Table(\"ColorTable\").Cell(\"transparent\").Bac";
_theme.Table("ColorTable").Cell("transparent").BackColor = _abm.COLOR_TRANSPARENT;
 //BA.debugLineNum = 122;BA.debugLine="theme.AddLabelTheme(\"black\")";
_theme.AddLabelTheme("black");
 //BA.debugLineNum = 123;BA.debugLine="theme.Label(\"black\").ForeColor = ABM.COLOR_BLACK";
_theme.Label("black").ForeColor = _abm.COLOR_BLACK;
 //BA.debugLineNum = 124;BA.debugLine="theme.AddLabelTheme(\"white\")";
_theme.AddLabelTheme("white");
 //BA.debugLineNum = 125;BA.debugLine="theme.Label(\"white\").ForeColor = ABM.COLOR_WHITE";
_theme.Label("white").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 127;BA.debugLine="Zdepths.Initialize2(Array As String(ABM.ZDEPTH_RE";
_zdepths.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{_abm.ZDEPTH_REMOVE,_abm.ZDEPTH_1,_abm.ZDEPTH_2,_abm.ZDEPTH_3,_abm.ZDEPTH_4,_abm.ZDEPTH_5}));
 //BA.debugLineNum = 129;BA.debugLine="For i = 0 To 5";
{
final int step31 = 1;
final int limit31 = (int) (5);
for (_i = (int) (0) ; (step31 > 0 && _i <= limit31) || (step31 < 0 && _i >= limit31); _i = ((int)(0 + _i + step31)) ) {
 //BA.debugLineNum = 130;BA.debugLine="theme.AddLabelTheme(\"zdepth\" & i)";
_theme.AddLabelTheme("zdepth"+BA.NumberToString(_i));
 //BA.debugLineNum = 131;BA.debugLine="theme.Label(\"zdepth\" & i).ZDepth = Zdepths.get(i";
_theme.Label("zdepth"+BA.NumberToString(_i)).ZDepth = BA.ObjectToString(_zdepths.Get(_i));
 //BA.debugLineNum = 132;BA.debugLine="theme.Label(\"zdepth\" & i).BackColor = ABM.COLOR_";
_theme.Label("zdepth"+BA.NumberToString(_i)).BackColor = _abm.COLOR_WHITE;
 }
};
 //BA.debugLineNum = 135;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"ThemesPage\"";
_name = "ThemesPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="Dim Colors As List";
_colors = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 18;BA.debugLine="Dim Intensities As List";
_intensities = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 19;BA.debugLine="Dim Zdepths As List";
_zdepths = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 20;BA.debugLine="Dim RowTeller As Int";
_rowteller = 0;
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
String _code = "";
com.ab.abmaterial.ABMLabel _lbl = null;
int _i = 0;
 //BA.debugLineNum = 168;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 170;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 173;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","ABMaterial makes use of 'Themes' to set properties like backcolors, text colors, Zdepths, etc... to ABMComponents.  Good practice is using a module (like ABMChared' in this demo) to create all the themes you'll need a lot in all your pages. You can set in each page the themes specifically needed for that page.")));
 //BA.debugLineNum = 175;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","Creating a theme is done using the Theme.AddxxxxxxTheme(\"Name\") methods.  The name you give the theme can then be used later in the ThemeName parameter of the ABMComponent. Next you use the Theme.xxxxxx(\"name\") methods to set properties like backcolors, zdepths, alignments etc...")));
 //BA.debugLineNum = 177;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","In this demo app, this is the code of the themes that are used accross the app. ")));
 //BA.debugLineNum = 179;BA.debugLine="Dim code As String";
_code = "";
 //BA.debugLineNum = 180;BA.debugLine="code = $\"Sub BuildTheme(themeName As String) 	MyT";
_code = ("Sub BuildTheme(themeName As String)\n"+"	MyTheme.Initialize(themeName)\n"+"	\n"+"	// the page theme\n"+"	MyTheme.Page.BackColor = ABM.COLOR_BLUEGREY\n"+"	MyTheme.Page.BackColorIntensity = ABM.INTENSITY_LIGHTEN4\n"+"	\n"+"	// the navbar theme\n"+"	MyTheme.AddNavigationBarTheme(\"nav1theme\")\n"+"	MyTheme.NavigationBar(\"nav1theme\").TopBarBackColor = ABM.COLOR_LIGHTBLUE\n"+"	\n"+"	// another navbar theme\n"+"	MyTheme.AddNavigationBarTheme(\"nav2theme\")\n"+"	MyTheme.NavigationBar(\"nav2theme\").TopBarBackColor = ABM.COLOR_RED\n"+"	\n"+"	// the footer theme\n"+"	MyTheme.AddContainerTheme(\"footertheme\")\n"+"	MyTheme.Container(\"footertheme\").BackColor = ABM.COLOR_LIGHTBLUE\n"+"	MyTheme.Container(\"footertheme\").BackColorIntensity = ABM.INTENSITY_DARKEN3\n"+"	\n"+"	// footer label theme\n"+"	MyTheme.AddLabelTheme(\"whitefc\")\n"+"	MyTheme.Label(\"whitefc\").ForeColor = ABM.COLOR_WHITE\n"+"		\n"+"	// a label header theme\n"+"	MyTheme.AddLabelTheme(\"lightblue\")\n"+"	MyTheme.Label(\"lightblue\").ForeColor = ABM.COLOR_LIGHTBLUE	\n"+"	MyTheme.Label(\"lightblue\").ForeColorIntensity = ABM.INTENSITY_DARKEN2\n"+"	\n"+"	// a table theme\n"+"	MyTheme.AddTableTheme(\"params\")\n"+"	MyTheme.Table(\"params\").ZDepth = ABM.ZDEPTH_2\n"+"	MyTheme.Table(\"params\").AddCellTheme(\"header\")\n"+"	MyTheme.Table(\"params\").Cell(\"header\").BackColor = ABM.COLOR_BLUEGREY\n"+"	MyTheme.Table(\"params\").Cell(\"header\").BackColorIntensity = ABM.INTENSITY_DARKEN2\n"+"	MyTheme.Table(\"params\").Cell(\"header\").ForeColor = ABM.COLOR_WHITE\n"+"	MyTheme.Table(\"params\").AddCellTheme(\"name\")\n"+"	MyTheme.Table(\"params\").Cell(\"name\").BackColor = ABM.COLOR_BLUEGREY\n"+"	MyTheme.Table(\"params\").Cell(\"name\").BackColorIntensity = ABM.INTENSITY_LIGHTEN2\n"+"	MyTheme.Table(\"params\").Cell(\"name\").VerticalAlign = ABM.TABLECELL_VERTICALALIGN_TOP\n"+"	MyTheme.Table(\"params\").AddCellTheme(\"description\")\n"+"	MyTheme.Table(\"params\").Cell(\"description\").BackColor = ABM.COLOR_WHITE	\n"+"	MyTheme.Table(\"params\").Cell(\"description\").VerticalAlign = ABM.TABLECELL_VERTICALALIGN_TOP	\n"+"	\n"+"	// a toast theme\n"+"	MyTheme.AddToastTheme(\"toast\")\n"+"	MyTheme.Toast(\"toast\").Rounded = True\n"+"	MyTheme.Toast(\"toast\").ActionForeColor = ABM.COLOR_ORANGE\n"+"	\n"+"	// another toast theme\n"+"	MyTheme.AddToastTheme(\"toastred\")\n"+"	MyTheme.Toast(\"toastred\").Rounded = True\n"+"	MyTheme.Toast(\"toastred\").ActionForeColor = ABM.COLOR_BLACK\n"+"	MyTheme.Toast(\"toastred\").BackColor = ABM.COLOR_RED\n"+"	\n"+"End Sub");
 //BA.debugLineNum = 237;BA.debugLine="page.Cell(2,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code)));
 //BA.debugLineNum = 240;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","And this is the code specific for the CompButtonPage")));
 //BA.debugLineNum = 242;BA.debugLine="code = $\"public Sub BuildTheme() 	// start with t";
_code = ("public Sub BuildTheme()\n"+"	// start with the base theme defined in ABMShared\n"+"	theme.Initialize(\"pagetheme\")\n"+"	theme.AddABMTheme(ABMShared.MyTheme)\n"+"	\n"+"	// add additional themes specific for this page\n"+"	\n"+"	// toast theme\n"+"	theme.AddToastTheme(\"toastgreen\")\n"+"	theme.Toast(\"toastgreen\").BackColor = ABM.COLOR_GREEN\n"+"	theme.Toast(\"toastgreen\").BackColorIntensity = ABM.INTENSITY_DARKEN2\n"+"	\n"+"	// bluegray button\n"+"	theme.AddButtonTheme(\"bluegrey\")\n"+"	theme.Button(\"bluegrey\").BackColor = ABM.COLOR_BLUEGREY\n"+"	theme.Button(\"bluegrey\").BackColorIntensity = ABM.INTENSITY_DARKEN1\n"+"	\n"+"	// darkred button\n"+"	theme.AddButtonTheme(\"darkred\")\n"+"	theme.Button(\"darkred\").BackColor = ABM.COLOR_RED\n"+"	theme.Button(\"darkred\").BackColorIntensity = ABM.INTENSITY_DARKEN1\n"+"	\n"+"	// transparent button\n"+"	theme.AddButtonTheme(\"transparent\")\n"+"	theme.Button(\"transparent\").BackColor = ABM.COLOR_TRANSPARENT	\n"+"	\n"+"	// darkgreen button\n"+"	theme.AddButtonTheme(\"darkgreen\")\n"+"	theme.Button(\"darkgreen\").BackColor = ABM.COLOR_GREEN\n"+"	theme.Button(\"darkgreen\").BackColorIntensity = ABM.INTENSITY_DARKEN1	\n"+"	\n"+"	// modal sheet\n"+"	theme.AddContainerTheme(\"modalcontent\")\n"+"	theme.Container(\"modalcontent\").BackColor = ABM.COLOR_WHITE	\n"+"End Sub");
 //BA.debugLineNum = 278;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code2",_code)));
 //BA.debugLineNum = 281;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Colors")));
 //BA.debugLineNum = 283;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","This is the color palette that can be used within ABMaterial.  Use the ABM.COLOR_XXXX and ABM.INTENSITY_XXXX constants!")));
 //BA.debugLineNum = 285;BA.debugLine="page.Cell(6,1).AddComponent(BuildColorTable16(ABM";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_RED)));
 //BA.debugLineNum = 286;BA.debugLine="page.Cell(6,2).AddComponent(BuildColorTable16(ABM";
_page.Cell((int) (6),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_PINK)));
 //BA.debugLineNum = 287;BA.debugLine="page.Cell(6,3).AddComponent(BuildColorTable16(ABM";
_page.Cell((int) (6),(int) (3)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_PURPLE)));
 //BA.debugLineNum = 289;BA.debugLine="page.Cell(7,1).AddComponent(BuildColorTable16(ABM";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_DEEPPURPLE)));
 //BA.debugLineNum = 290;BA.debugLine="page.Cell(7,2).AddComponent(BuildColorTable16(ABM";
_page.Cell((int) (7),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_INDIGO)));
 //BA.debugLineNum = 291;BA.debugLine="page.Cell(7,3).AddComponent(BuildColorTable16(ABM";
_page.Cell((int) (7),(int) (3)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_BLUE)));
 //BA.debugLineNum = 293;BA.debugLine="page.Cell(8,1).AddComponent(BuildColorTable16(ABM";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_LIGHTBLUE)));
 //BA.debugLineNum = 294;BA.debugLine="page.Cell(8,2).AddComponent(BuildColorTable16(ABM";
_page.Cell((int) (8),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_CYAN)));
 //BA.debugLineNum = 295;BA.debugLine="page.Cell(8,3).AddComponent(BuildColorTable16(ABM";
_page.Cell((int) (8),(int) (3)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_TEAL)));
 //BA.debugLineNum = 297;BA.debugLine="page.Cell(9,1).AddComponent(BuildColorTable16(ABM";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_GREEN)));
 //BA.debugLineNum = 298;BA.debugLine="page.Cell(9,2).AddComponent(BuildColorTable16(ABM";
_page.Cell((int) (9),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_LIGHTGREEN)));
 //BA.debugLineNum = 299;BA.debugLine="page.Cell(9,3).AddComponent(BuildColorTable16(ABM";
_page.Cell((int) (9),(int) (3)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_LIME)));
 //BA.debugLineNum = 301;BA.debugLine="page.Cell(10,1).AddComponent(BuildColorTable16(AB";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_YELLOW)));
 //BA.debugLineNum = 302;BA.debugLine="page.Cell(10,2).AddComponent(BuildColorTable16(AB";
_page.Cell((int) (10),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_AMBER)));
 //BA.debugLineNum = 303;BA.debugLine="page.Cell(10,3).AddComponent(BuildColorTable16(AB";
_page.Cell((int) (10),(int) (3)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_ORANGE)));
 //BA.debugLineNum = 305;BA.debugLine="page.Cell(11,1).AddComponent(BuildColorTable16(AB";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable16(_abm.COLOR_DEEPORANGE)));
 //BA.debugLineNum = 306;BA.debugLine="page.Cell(11,2).AddComponent(BuildColorTable12(AB";
_page.Cell((int) (11),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable12(_abm.COLOR_BROWN)));
 //BA.debugLineNum = 307;BA.debugLine="page.Cell(11,3).AddComponent(BuildColorTable12(AB";
_page.Cell((int) (11),(int) (3)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable12(_abm.COLOR_GREY)));
 //BA.debugLineNum = 309;BA.debugLine="page.Cell(12,1).AddComponent(BuildColorTable12(AB";
_page.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortable12(_abm.COLOR_BLUEGREY)));
 //BA.debugLineNum = 310;BA.debugLine="page.Cell(12,2).AddComponent(BuildColorTableOther";
_page.Cell((int) (12),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_buildcolortableother()));
 //BA.debugLineNum = 313;BA.debugLine="page.Cell(13,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","The ZDEPTH_ constans can be used to set the ZDepth of a component.")));
 //BA.debugLineNum = 315;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 316;BA.debugLine="lbl.Initialize(page, \"lbl0\", \"ZDEPTH_REMOVE\" ,ABM";
_lbl.Initialize(_page,"lbl0","ZDEPTH_REMOVE",_abm.SIZE_PARAGRAPH,__c.True,"zdepth0");
 //BA.debugLineNum = 317;BA.debugLine="page.Cell(14,1).AddComponent(lbl)";
_page.Cell((int) (14),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl));
 //BA.debugLineNum = 318;BA.debugLine="For i = 1 To 5";
{
final int step37 = 1;
final int limit37 = (int) (5);
for (_i = (int) (1) ; (step37 > 0 && _i <= limit37) || (step37 < 0 && _i >= limit37); _i = ((int)(0 + _i + step37)) ) {
 //BA.debugLineNum = 319;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 320;BA.debugLine="lbl.Initialize(page, \"lbl\" & i, \"ZDEPTH_\" & i ,A";
_lbl.Initialize(_page,"lbl"+BA.NumberToString(_i),"ZDEPTH_"+BA.NumberToString(_i),_abm.SIZE_PARAGRAPH,__c.True,"zdepth"+BA.NumberToString(_i));
 //BA.debugLineNum = 321;BA.debugLine="page.Cell(14,1).AddComponent(lbl)";
_page.Cell((int) (14),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl));
 }
};
 //BA.debugLineNum = 325;BA.debugLine="page.Cell(15,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (15),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","Now is a good time to start reading the Grids chapter and find out how layouts are designed in Googles Material Design.  Click the Grids section in the menu.")));
 //BA.debugLineNum = 328;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 330;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 333;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 335;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 336;BA.debugLine="End Sub";
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
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 339;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 340;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 341;BA.debugLine="If Action = \"Themes\" Then Return";
if ((_action).equals("Themes")) { 
if (true) return "";};
 //BA.debugLineNum = 342;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 343;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 344;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 345;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 347;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 348;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 349;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 351;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 352;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 61;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 62;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 63;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 64;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 65;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 66;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 67;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 69;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 70;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 71;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 72;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 74;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 76;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 78;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 79;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 80;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 82;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 86;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 354;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 355;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 356;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 357;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 358;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 359;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 57;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 58;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
