package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class comptimelinepage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.comptimelinepage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.comptimelinepage.class).invoke(this, new Object[] {null});
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
public int _counter = 0;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _btn1_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMTimeLine _timeline = null;
com.ab.abmaterial.ABMTimeLineSlide _date3 = null;
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMInput _inp2 = null;
com.ab.abmaterial.ABMCombo _combo1 = null;
com.ab.abmaterial.ABMInput _inp4 = null;
com.ab.abmaterial.ABMInput _inp5 = null;
 //BA.debugLineNum = 284;BA.debugLine="Sub btn1_Clicked(Target As String)";
 //BA.debugLineNum = 285;BA.debugLine="Dim timeline As ABMTimeLine = page.Component(\"tim";
_timeline = (com.ab.abmaterial.ABMTimeLine)(_page.Component("timeline"));
 //BA.debugLineNum = 286;BA.debugLine="Dim date3 As ABMTimeLineSlide";
_date3 = new com.ab.abmaterial.ABMTimeLineSlide();
 //BA.debugLineNum = 287;BA.debugLine="date3.Initialize(\"id\" & counter, \"2016\", \"\")";
_date3.Initialize("id"+BA.NumberToString(_counter),(int)(Double.parseDouble("2016")),"");
 //BA.debugLineNum = 288;BA.debugLine="date3.StartDate.Month = Rnd(1,13)";
_date3.StartDate.Month = __c.Rnd((int) (1),(int) (13));
 //BA.debugLineNum = 289;BA.debugLine="date3.Text.Text = \"An input form\"";
_date3.Text.Text = "An input form";
 //BA.debugLineNum = 290;BA.debugLine="date3.Container.Initialize(page, \"cont\" & counter";
_date3.Container.Initialize(_page,"cont"+BA.NumberToString(_counter),"");
 //BA.debugLineNum = 293;BA.debugLine="date3.Container.AddRows(1,True, \"\").AddCells12(1,";
_date3.Container.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 294;BA.debugLine="date3.Container.AddRows(1,True, \"\").AddCellsOS(2,";
_date3.Container.AddRows((int) (1),__c.True,"").AddCellsOS((int) (2),(int) (0),(int) (0),(int) (0),(int) (6),(int) (6),(int) (6),"");
 //BA.debugLineNum = 295;BA.debugLine="date3.Container.AddRows(3,True, \"\").AddCells12(1,";
_date3.Container.AddRows((int) (3),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 296;BA.debugLine="date3.Container.BuildGrid 'IMPORTANT once you loa";
_date3.Container.BuildGrid();
 //BA.debugLineNum = 299;BA.debugLine="date3.Container.Cell(1,1).AddComponent(ABMShared";
_date3.Container.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Enter your info so we can contact you later")));
 //BA.debugLineNum = 302;BA.debugLine="Dim inp1 As ABMInput";
_inp1 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 303;BA.debugLine="inp1.Initialize(page, \"inp1\", ABM.INPUT_TEXT, \"F";
_inp1.Initialize(_page,"inp1",_abm.INPUT_TEXT,"First Name",__c.False,"");
 //BA.debugLineNum = 304;BA.debugLine="inp1.PlaceHolderText = \"or your call name\"";
_inp1.PlaceHolderText = "or your call name";
 //BA.debugLineNum = 305;BA.debugLine="date3.Container.Cell(2,1).AddComponent(inp1)";
_date3.Container.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp1));
 //BA.debugLineNum = 307;BA.debugLine="Dim inp2 As ABMInput";
_inp2 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 308;BA.debugLine="inp2.Initialize(page, \"inp2\", ABM.INPUT_TEXT, \"L";
_inp2.Initialize(_page,"inp2",_abm.INPUT_TEXT,"Last Name",__c.False,"");
 //BA.debugLineNum = 309;BA.debugLine="date3.Container.Cell(2,2).AddComponent(inp2)";
_date3.Container.Cell((int) (2),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp2));
 //BA.debugLineNum = 313;BA.debugLine="Dim combo1 As ABMCombo";
_combo1 = new com.ab.abmaterial.ABMCombo();
 //BA.debugLineNum = 314;BA.debugLine="combo1.Initialize(page, \"combo1\", \"Select a pers";
_combo1.Initialize(_page,"combo1","Select a person",(int) (650),"");
 //BA.debugLineNum = 317;BA.debugLine="combo1.AddItem(\"combo1S1\", \"Mom\", BuildSimpleIte";
_combo1.AddItem("combo1S1","Mom",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S1","mdi-action-account-circle","{NBSP}{NBSP}Mom")));
 //BA.debugLineNum = 318;BA.debugLine="combo1.AddItem(\"combo1S2\", \"Dad\", BuildSimpleIte";
_combo1.AddItem("combo1S2","Dad",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S2","mdi-action-account-circle","{NBSP}{NBSP}Dad")));
 //BA.debugLineNum = 319;BA.debugLine="combo1.AddItem(\"combo1S3\", \"Brother\", BuildSimpl";
_combo1.AddItem("combo1S3","Brother",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S3","mdi-action-dashboard","{NBSP}{NBSP}Brother")));
 //BA.debugLineNum = 320;BA.debugLine="combo1.AddItem(\"combo1S4\", \"Sister\", BuildSimple";
_combo1.AddItem("combo1S4","Sister",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("S4","mdi-action-dashboard","{NBSP}{NBSP}Sister")));
 //BA.debugLineNum = 322;BA.debugLine="date3.Container.Cell(3,1).AddComponent(combo1)";
_date3.Container.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_combo1));
 //BA.debugLineNum = 324;BA.debugLine="Dim inp4 As ABMInput";
_inp4 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 325;BA.debugLine="inp4.Initialize(page, \"inp4\", ABM.INPUT_PASSWORD";
_inp4.Initialize(_page,"inp4",_abm.INPUT_PASSWORD,"Password",__c.False,"");
 //BA.debugLineNum = 326;BA.debugLine="date3.Container.Cell(4,1).AddComponent(inp4)";
_date3.Container.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp4));
 //BA.debugLineNum = 328;BA.debugLine="Dim inp5 As ABMInput";
_inp5 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 329;BA.debugLine="inp5.Initialize(page, \"inp5\", ABM.INPUT_EMAIL, \"";
_inp5.Initialize(_page,"inp5",_abm.INPUT_EMAIL,"Email",__c.False,"");
 //BA.debugLineNum = 330;BA.debugLine="inp5.WrongMessage = \"Wrong\"";
_inp5.WrongMessage = "Wrong";
 //BA.debugLineNum = 331;BA.debugLine="inp5.SuccessMessage = \"Correct\"";
_inp5.SuccessMessage = "Correct";
 //BA.debugLineNum = 332;BA.debugLine="date3.Container.Cell(5,1).AddComponent(inp5)";
_date3.Container.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp5));
 //BA.debugLineNum = 334;BA.debugLine="timeline.AddSlideRunTime(date3)";
_timeline.AddSlideRunTime(_date3);
 //BA.debugLineNum = 336;BA.debugLine="counter = counter + 1";
_counter = (int) (_counter+1);
 //BA.debugLineNum = 337;BA.debugLine="End Sub";
return "";
}
public String  _btn2_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMTimeLine _timeline = null;
 //BA.debugLineNum = 351;BA.debugLine="Sub btn2_Clicked(Target As String)";
 //BA.debugLineNum = 352;BA.debugLine="Dim timeline As ABMTimeLine = page.Component(\"tim";
_timeline = (com.ab.abmaterial.ABMTimeLine)(_page.Component("timeline"));
 //BA.debugLineNum = 353;BA.debugLine="timeline.RemoveSlideRunTime(\"id\" & (counter - 1))";
_timeline.RemoveSlideRunTime("id"+BA.NumberToString((_counter-1)));
 //BA.debugLineNum = 354;BA.debugLine="End Sub";
return "";
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 132;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 134;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 137;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 138;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 139;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 140;BA.debugLine="page.PageTitle = \"ABMTimeLine\"";
_page.PageTitle = "ABMTimeLine";
 //BA.debugLineNum = 141;BA.debugLine="page.PageDescription = \"The Timeline component \"";
_page.PageDescription = "The Timeline component ";
 //BA.debugLineNum = 142;BA.debugLine="page.PageHTMLName = \"abmaterial-timeline.html\"";
_page.PageHTMLName = "abmaterial-timeline.html";
 //BA.debugLineNum = 143;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 144;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 145;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 146;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 148;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMTimeLine\",";
_abmshared._buildnavigationbar(_page,"ABMTimeLine","../images/logo.png","","Controls","ABMTimeLine");
 //BA.debugLineNum = 151;BA.debugLine="page.AddRows(4,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (4),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 152;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 154;BA.debugLine="page.Cell(2,1).SetFixedHeight(800,True) ' IMPORTA";
_page.Cell((int) (2),(int) (1)).SetFixedHeight((int) (800),__c.True);
 //BA.debugLineNum = 156;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMLabel  _buildsimpleitem(String _id,String _icon,String _title) throws Exception{
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 339;BA.debugLine="Sub BuildSimpleItem(id As String, icon As String,";
 //BA.debugLineNum = 340;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 341;BA.debugLine="If icon <> \"\" Then";
if ((_icon).equals("") == false) { 
 //BA.debugLineNum = 342;BA.debugLine="lbl.Initialize(page, id, Title, ABM.SIZE_H6, Tru";
_lbl.Initialize(_page,_id,_title,_abm.SIZE_H6,__c.True,"header");
 }else {
 //BA.debugLineNum = 344;BA.debugLine="lbl.Initialize(page, id, Title, ABM.SIZE_H6, Tru";
_lbl.Initialize(_page,_id,_title,_abm.SIZE_H6,__c.True,"");
 };
 //BA.debugLineNum = 346;BA.debugLine="lbl.VerticalAlign = True";
_lbl.VerticalAlign = __c.True;
 //BA.debugLineNum = 347;BA.debugLine="lbl.IconName = icon";
_lbl.IconName = _icon;
 //BA.debugLineNum = 348;BA.debugLine="Return lbl";
if (true) return _lbl;
 //BA.debugLineNum = 349;BA.debugLine="End Sub";
return null;
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 90;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 91;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 94;BA.debugLine="theme.AddDividerTheme(\"lightblue\")";
_theme.AddDividerTheme("lightblue");
 //BA.debugLineNum = 95;BA.debugLine="theme.Divider(\"lightblue\").ForeColor = ABM.COLOR_";
_theme.Divider("lightblue").ForeColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 98;BA.debugLine="theme.AddTableTheme(\"tbl1theme\")";
_theme.AddTableTheme("tbl1theme");
 //BA.debugLineNum = 99;BA.debugLine="theme.Table(\"tbl1theme\").ZDepth = ABM.ZDEPTH_1";
_theme.Table("tbl1theme").ZDepth = _abm.ZDEPTH_1;
 //BA.debugLineNum = 101;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"headerfoot";
_theme.Table("tbl1theme").AddCellTheme("headerfooter");
 //BA.debugLineNum = 102;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooter\").Bac";
_theme.Table("tbl1theme").Cell("headerfooter").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 103;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooter\").For";
_theme.Table("tbl1theme").Cell("headerfooter").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 105;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"headerfoot";
_theme.Table("tbl1theme").AddCellTheme("headerfooterright");
 //BA.debugLineNum = 106;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooterright\"";
_theme.Table("tbl1theme").Cell("headerfooterright").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 107;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooterright\"";
_theme.Table("tbl1theme").Cell("headerfooterright").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 108;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"headerfooterright\"";
_theme.Table("tbl1theme").Cell("headerfooterright").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 110;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"nocolor\")";
_theme.Table("tbl1theme").AddCellTheme("nocolor");
 //BA.debugLineNum = 111;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"nocolor\").ActiveBa";
_theme.Table("tbl1theme").Cell("nocolor").ActiveBackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 112;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"nocolor\").ActiveBa";
_theme.Table("tbl1theme").Cell("nocolor").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 114;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"positive\")";
_theme.Table("tbl1theme").AddCellTheme("positive");
 //BA.debugLineNum = 115;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").BackCol";
_theme.Table("tbl1theme").Cell("positive").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 116;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").BackCol";
_theme.Table("tbl1theme").Cell("positive").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 117;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").ActiveB";
_theme.Table("tbl1theme").Cell("positive").ActiveBackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 118;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").ActiveB";
_theme.Table("tbl1theme").Cell("positive").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 119;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"positive\").Align =";
_theme.Table("tbl1theme").Cell("positive").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 121;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"negative\")";
_theme.Table("tbl1theme").AddCellTheme("negative");
 //BA.debugLineNum = 122;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").BackCol";
_theme.Table("tbl1theme").Cell("negative").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 123;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").BackCol";
_theme.Table("tbl1theme").Cell("negative").BackColorIntensity = _abm.INTENSITY_LIGHTEN3;
 //BA.debugLineNum = 124;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").ActiveB";
_theme.Table("tbl1theme").Cell("negative").ActiveBackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 125;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").ActiveB";
_theme.Table("tbl1theme").Cell("negative").ActiveBackColorIntensity = _abm.INTENSITY_LIGHTEN1;
 //BA.debugLineNum = 126;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"negative\").Align =";
_theme.Table("tbl1theme").Cell("negative").Align = _abm.TABLECELL_HORIZONTALALIGN_RIGHT;
 //BA.debugLineNum = 128;BA.debugLine="theme.Table(\"tbl1theme\").AddCellTheme(\"aligntop\")";
_theme.Table("tbl1theme").AddCellTheme("aligntop");
 //BA.debugLineNum = 129;BA.debugLine="theme.Table(\"tbl1theme\").Cell(\"aligntop\").Vertica";
_theme.Table("tbl1theme").Cell("aligntop").VerticalAlign = _abm.TABLECELL_VERTICALALIGN_TOP;
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompTimeLinePage\"";
_name = "CompTimeLinePage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="Dim counter As Int = 4";
_counter = (int) (4);
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMTimeLine _timeline = null;
com.ab.abmaterial.ABMTimeLineSlide _date1 = null;
com.ab.abmaterial.ABMTable _tbl1 = null;
anywheresoftware.b4a.objects.collections.List _firstnames = null;
anywheresoftware.b4a.objects.collections.List _lastnames = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.List _r = null;
anywheresoftware.b4a.objects.collections.List _rcellthemes = null;
int _neg = 0;
com.ab.abmaterial.ABMTimeLineSlide _date2 = null;
com.ab.abmaterial.ABMPDFViewer _pdf = null;
com.ab.abmaterial.ABMTimeLineSlide _date4 = null;
com.ab.abmaterial.ABMGoogleMap _gm2 = null;
com.ab.abmaterial.ABMButton _btn1 = null;
com.ab.abmaterial.ABMButton _btn2 = null;
 //BA.debugLineNum = 159;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 161;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 164;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","ABMTimeline is a component to present a time line of events. Using the ABMTimeLineSlide you can create events, with some assets like images, and event other ABMComponents!.")));
 //BA.debugLineNum = 169;BA.debugLine="Dim timeline As ABMTimeLine";
_timeline = new com.ab.abmaterial.ABMTimeLine();
 //BA.debugLineNum = 170;BA.debugLine="timeline.Initialize(page, \"timeline\", \"H1\", \"\", \"";
_timeline.Initialize(_page,"timeline","H1","","alain.json","");
 //BA.debugLineNum = 171;BA.debugLine="timeline.Language = \"nl\"";
_timeline.Language = "nl";
 //BA.debugLineNum = 172;BA.debugLine="timeline.StartAtSlideNumber = 1";
_timeline.StartAtSlideNumber = (int) (1);
 //BA.debugLineNum = 173;BA.debugLine="timeline.HideSwipeMessage = True";
_timeline.HideSwipeMessage = __c.True;
 //BA.debugLineNum = 176;BA.debugLine="Dim date1 As ABMTimeLineSlide";
_date1 = new com.ab.abmaterial.ABMTimeLineSlide();
 //BA.debugLineNum = 177;BA.debugLine="date1.Initialize(\"id1\", \"2016\", \"\")";
_date1.Initialize("id1",(int)(Double.parseDouble("2016")),"");
 //BA.debugLineNum = 178;BA.debugLine="date1.Text.Text = \"A table overview\"";
_date1.Text.Text = "A table overview";
 //BA.debugLineNum = 179;BA.debugLine="date1.Container.Initialize(page, \"cont1\", \"\")";
_date1.Container.Initialize(_page,"cont1","");
 //BA.debugLineNum = 182;BA.debugLine="Dim tbl1 As ABMTable";
_tbl1 = new com.ab.abmaterial.ABMTable();
 //BA.debugLineNum = 183;BA.debugLine="tbl1.Initialize(page, \"tbl1\", True, False, True,";
_tbl1.Initialize(_page,"tbl1",__c.True,__c.False,__c.True,"tbl1theme");
 //BA.debugLineNum = 184;BA.debugLine="tbl1.SetHeaders(Array As String(\"First Name\", \"L";
_tbl1.SetHeaders(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"First Name","Last Name","Sales Profit"}));
 //BA.debugLineNum = 185;BA.debugLine="tbl1.SetColumnDataFields(Array As String(\"FirstN";
_tbl1.SetColumnDataFields(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"FirstName","LastName","SalesProfit"}));
 //BA.debugLineNum = 186;BA.debugLine="tbl1.SetHeaderThemes(Array As String(\"headerfoot";
_tbl1.SetHeaderThemes(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"headerfooter","headerfooter","headerfooterright"}));
 //BA.debugLineNum = 188;BA.debugLine="Dim FirstNames As List";
_firstnames = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 189;BA.debugLine="Dim LastNames As List";
_lastnames = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 191;BA.debugLine="FirstNames.Initialize2(Array As String(\"Alain\",";
_firstnames.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Alain","Jos","Paul","Bertrande","Julie","Stephanie","Bert","Charles","James","Walter"}));
 //BA.debugLineNum = 192;BA.debugLine="LastNames.Initialize2(Array As String(\"Bailleul\"";
_lastnames.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Bailleul","Rogiers","Dougherty","Rodrigues","Ostrander","Kenyon","Grant","Klinger","Sheffield","Pointdexter"}));
 //BA.debugLineNum = 195;BA.debugLine="For i = 0 To 9";
{
final int step21 = 1;
final int limit21 = (int) (9);
for (_i = (int) (0) ; (step21 > 0 && _i <= limit21) || (step21 < 0 && _i >= limit21); _i = ((int)(0 + _i + step21)) ) {
 //BA.debugLineNum = 196;BA.debugLine="Dim r As List";
_r = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 197;BA.debugLine="Dim rCellThemes As List";
_rcellthemes = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 198;BA.debugLine="r.Initialize";
_r.Initialize();
 //BA.debugLineNum = 199;BA.debugLine="rCellThemes.Initialize";
_rcellthemes.Initialize();
 //BA.debugLineNum = 200;BA.debugLine="r.Add(FirstNames.get(Rnd(0,9)))";
_r.Add(_firstnames.Get(__c.Rnd((int) (0),(int) (9))));
 //BA.debugLineNum = 201;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 202;BA.debugLine="r.Add(LastNames.get(Rnd(0,9)))";
_r.Add(_lastnames.Get(__c.Rnd((int) (0),(int) (9))));
 //BA.debugLineNum = 203;BA.debugLine="rCellThemes.Add(\"nocolor\")";
_rcellthemes.Add((Object)("nocolor"));
 //BA.debugLineNum = 204;BA.debugLine="Dim Neg As Int = Rnd(0,100)";
_neg = __c.Rnd((int) (0),(int) (100));
 //BA.debugLineNum = 205;BA.debugLine="If Neg > 50 Then";
if (_neg>50) { 
 //BA.debugLineNum = 206;BA.debugLine="r.Add(\"$\" & Rnd(1000, 15000))";
_r.Add((Object)("$"+BA.NumberToString(__c.Rnd((int) (1000),(int) (15000)))));
 //BA.debugLineNum = 207;BA.debugLine="rCellThemes.Add(\"positive\")";
_rcellthemes.Add((Object)("positive"));
 }else {
 //BA.debugLineNum = 209;BA.debugLine="r.Add(\"$-\" & Rnd(1000, 15000))";
_r.Add((Object)("$-"+BA.NumberToString(__c.Rnd((int) (1000),(int) (15000)))));
 //BA.debugLineNum = 210;BA.debugLine="rCellThemes.Add(\"negative\")";
_rcellthemes.Add((Object)("negative"));
 };
 //BA.debugLineNum = 212;BA.debugLine="tbl1.AddRow(\"uid\" & i, r)";
_tbl1.AddRow("uid"+BA.NumberToString(_i),_r);
 //BA.debugLineNum = 213;BA.debugLine="tbl1.SetRowThemes(rCellThemes) ' make sure you";
_tbl1.SetRowThemes(_rcellthemes);
 }
};
 //BA.debugLineNum = 216;BA.debugLine="tbl1.SetFooter(\"This is a footer that appears on";
_tbl1.SetFooter((Object)("This is a footer that appears on the bottom of the table."),(int) (12),"headerfooter");
 //BA.debugLineNum = 218;BA.debugLine="date1.Container.AddRows(1,True, \"\").AddCells12(1,";
_date1.Container.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 219;BA.debugLine="date1.Container.BuildGrid 'IMPORTANT once you loa";
_date1.Container.BuildGrid();
 //BA.debugLineNum = 220;BA.debugLine="date1.Container.Cell(1,1).AddComponent(tbl1)";
_date1.Container.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_tbl1));
 //BA.debugLineNum = 223;BA.debugLine="timeline.AddSlide(date1)";
_timeline.AddSlide(_date1);
 //BA.debugLineNum = 225;BA.debugLine="Dim date2 As ABMTimeLineSlide";
_date2 = new com.ab.abmaterial.ABMTimeLineSlide();
 //BA.debugLineNum = 226;BA.debugLine="date2.Initialize(\"id2\", \"2018\", \"\")";
_date2.Initialize("id2",(int)(Double.parseDouble("2018")),"");
 //BA.debugLineNum = 227;BA.debugLine="date2.StartDate.Month = 12";
_date2.StartDate.Month = (int) (12);
 //BA.debugLineNum = 228;BA.debugLine="date2.Text.Text = \"A PDF report\"";
_date2.Text.Text = "A PDF report";
 //BA.debugLineNum = 230;BA.debugLine="date2.Container.Initialize(page, \"cont2\", \"\")";
_date2.Container.Initialize(_page,"cont2","");
 //BA.debugLineNum = 231;BA.debugLine="date2.Container.AddRows(1,True, \"\").AddCells12(1,";
_date2.Container.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 232;BA.debugLine="date2.Container.BuildGrid 'IMPORTANT once you loa";
_date2.Container.BuildGrid();
 //BA.debugLineNum = 234;BA.debugLine="Dim pdf As ABMPDFViewer";
_pdf = new com.ab.abmaterial.ABMPDFViewer();
 //BA.debugLineNum = 235;BA.debugLine="pdf.Initialize(page, \"pdf\", 400, \"../PDF/1.pdf\",";
_pdf.Initialize(_page,"pdf",(int) (400),"../PDF/1.pdf","");
 //BA.debugLineNum = 236;BA.debugLine="pdf.PreparePrintingText = \"Preparing to print...";
_pdf.PreparePrintingText = "Preparing to print...";
 //BA.debugLineNum = 237;BA.debugLine="pdf.ReadDirection = ABM.PDF_READDIRECTION_LTR";
_pdf.ReadDirection = _abm.PDF_READDIRECTION_LTR;
 //BA.debugLineNum = 238;BA.debugLine="pdf.AllowDownload = True";
_pdf.AllowDownload = __c.True;
 //BA.debugLineNum = 239;BA.debugLine="pdf.AllowOpen = False";
_pdf.AllowOpen = __c.False;
 //BA.debugLineNum = 240;BA.debugLine="pdf.AllowPrint = True";
_pdf.AllowPrint = __c.True;
 //BA.debugLineNum = 241;BA.debugLine="pdf.AllowSideBar = True";
_pdf.AllowSideBar = __c.True;
 //BA.debugLineNum = 242;BA.debugLine="pdf.AllowViewBookmark = False";
_pdf.AllowViewBookmark = __c.False;
 //BA.debugLineNum = 244;BA.debugLine="date2.Container.Cell(1,1).AddComponent(pdf)";
_date2.Container.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_pdf));
 //BA.debugLineNum = 245;BA.debugLine="timeline.AddSlide(date2)";
_timeline.AddSlide(_date2);
 //BA.debugLineNum = 247;BA.debugLine="Dim date4 As ABMTimeLineSlide";
_date4 = new com.ab.abmaterial.ABMTimeLineSlide();
 //BA.debugLineNum = 248;BA.debugLine="date4.Initialize(\"id3\", \"2016\", \"\")";
_date4.Initialize("id3",(int)(Double.parseDouble("2016")),"");
 //BA.debugLineNum = 249;BA.debugLine="date4.StartDate.Month = 5";
_date4.StartDate.Month = (int) (5);
 //BA.debugLineNum = 250;BA.debugLine="date4.Text.Text = \"A panorama view\"";
_date4.Text.Text = "A panorama view";
 //BA.debugLineNum = 252;BA.debugLine="date4.Container.Initialize(page, \"cont4\", \"\")";
_date4.Container.Initialize(_page,"cont4","");
 //BA.debugLineNum = 253;BA.debugLine="date4.Container.AddRows(1,True, \"\").AddCells12(1,";
_date4.Container.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 254;BA.debugLine="date4.Container.BuildGrid 'IMPORTANT once you loa";
_date4.Container.BuildGrid();
 //BA.debugLineNum = 257;BA.debugLine="Dim gm2 As ABMGoogleMap";
_gm2 = new com.ab.abmaterial.ABMGoogleMap();
 //BA.debugLineNum = 258;BA.debugLine="gm2.InitializeAsPanorama(page, \"gm2\", 50.8500, 2";
_gm2.InitializeAsPanorama(_page,"gm2",50.8500,2.8833,(int) (1),(int) (300),(int) (45),(int) (0));
 //BA.debugLineNum = 260;BA.debugLine="date4.Container.Cell(1,1).AddComponent(gm2)";
_date4.Container.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_gm2));
 //BA.debugLineNum = 261;BA.debugLine="timeline.AddSlide(date4)";
_timeline.AddSlide(_date4);
 //BA.debugLineNum = 263;BA.debugLine="page.Cell(2,1).AddComponent(timeline)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_timeline));
 //BA.debugLineNum = 265;BA.debugLine="Dim btn1 As ABMButton";
_btn1 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 266;BA.debugLine="btn1.InitializeFlat(page, \"btn1\", \"\", \"\", \"Add\",";
_btn1.InitializeFlat(_page,"btn1","","","Add","");
 //BA.debugLineNum = 267;BA.debugLine="page.Cell(3,1).AddComponent(btn1)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn1));
 //BA.debugLineNum = 269;BA.debugLine="Dim btn2 As ABMButton";
_btn2 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 270;BA.debugLine="btn2.InitializeFlat(page, \"btn2\", \"\", \"\", \"Remove";
_btn2.InitializeFlat(_page,"btn2","","","Remove last added","");
 //BA.debugLineNum = 271;BA.debugLine="page.Cell(3,1).AddComponent(btn2)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn2));
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
 //BA.debugLineNum = 21;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 23;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 382;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 383;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 384;BA.debugLine="If Action = \"ABMTimeLine\" Then Return";
if ((_action).equals("ABMTimeLine")) { 
if (true) return "";};
 //BA.debugLineNum = 385;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 386;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 387;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 388;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 390;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 391;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 392;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 394;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 395;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 397;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 398;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 399;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 400;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 401;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 402;BA.debugLine="End Sub";
return "";
}
public String  _timeline_added(String _uniqueid) throws Exception{
com.ab.abmaterial.ABMTimeLine _timeline = null;
 //BA.debugLineNum = 362;BA.debugLine="Sub timeline_Added(uniqueID As String)";
 //BA.debugLineNum = 363;BA.debugLine="Log(\"added \" & uniqueID)";
__c.Log("added "+_uniqueid);
 //BA.debugLineNum = 364;BA.debugLine="Dim timeline As ABMTimeLine = page.Component(\"tim";
_timeline = (com.ab.abmaterial.ABMTimeLine)(_page.Component("timeline"));
 //BA.debugLineNum = 365;BA.debugLine="timeline.Goto(uniqueID, True)";
_timeline.Goto(_uniqueid,__c.True);
 //BA.debugLineNum = 366;BA.debugLine="timeline.PrepareComponentsForSlide(uniqueID) ' IM";
_timeline.PrepareComponentsForSlide(_uniqueid);
 //BA.debugLineNum = 367;BA.debugLine="End Sub";
return "";
}
public String  _timeline_backtostart() throws Exception{
 //BA.debugLineNum = 369;BA.debugLine="Sub timeline_BackToStart()";
 //BA.debugLineNum = 370;BA.debugLine="Log(\"back to start\")";
__c.Log("back to start");
 //BA.debugLineNum = 371;BA.debugLine="End Sub";
return "";
}
public String  _timeline_dataloaded() throws Exception{
com.ab.abmaterial.ABMTimeLine _timeline = null;
 //BA.debugLineNum = 356;BA.debugLine="Sub timeline_DataLoaded()";
 //BA.debugLineNum = 357;BA.debugLine="Log(\"Data loaded\")";
__c.Log("Data loaded");
 //BA.debugLineNum = 358;BA.debugLine="Dim timeline As ABMTimeLine = page.Component(\"tim";
_timeline = (com.ab.abmaterial.ABMTimeLine)(_page.Component("timeline"));
 //BA.debugLineNum = 359;BA.debugLine="timeline.PrepareComponentsForAllSlides ' IMPORTAN";
_timeline.PrepareComponentsForAllSlides();
 //BA.debugLineNum = 360;BA.debugLine="End Sub";
return "";
}
public String  _timeline_movedtoslide(String _uniqueid) throws Exception{
 //BA.debugLineNum = 373;BA.debugLine="Sub timeline_MovedToSlide(uniqueID As String)";
 //BA.debugLineNum = 374;BA.debugLine="Log(\"Changed: \" & uniqueID)";
__c.Log("Changed: "+_uniqueid);
 //BA.debugLineNum = 375;BA.debugLine="End Sub";
return "";
}
public String  _timeline_removed(String _uniqueid) throws Exception{
 //BA.debugLineNum = 377;BA.debugLine="Sub timeline_Removed(uniqueID As String)";
 //BA.debugLineNum = 378;BA.debugLine="Log(\"Removed\")";
__c.Log("Removed");
 //BA.debugLineNum = 379;BA.debugLine="End Sub";
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
