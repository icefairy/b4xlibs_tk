package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class testpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.testpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.testpage.class).invoke(this, new Object[] {null});
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
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _buildpage() throws Exception{
com.ab.abmaterial.ABMTable _table = null;
com.ab.abmaterial.ABMAudioPlayer _player = null;
anywheresoftware.b4a.objects.collections.List _list = null;
com.ab.abmaterial.ABMAudioPlayerSong _song = null;
com.ab.abmaterial.ABMContainer _floatingcont1 = null;
com.ab.abmaterial.ABMContainer _floatingcont2 = null;
 //BA.debugLineNum = 115;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 117;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 120;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 121;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 122;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 123;BA.debugLine="page.PageTitle = \"ABMaterial\"";
_page.PageTitle = "ABMaterial";
 //BA.debugLineNum = 124;BA.debugLine="page.PageDescription = \"About material design wit";
_page.PageDescription = "About material design with ABMaterial ";
 //BA.debugLineNum = 125;BA.debugLine="page.PageHTMLName = \"index.html\"";
_page.PageHTMLName = "index.html";
 //BA.debugLineNum = 126;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 127;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 128;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 129;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 132;BA.debugLine="page.AddRows(3,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (3),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 133;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 137;BA.debugLine="Dim table As ABMTable";
_table = new com.ab.abmaterial.ABMTable();
 //BA.debugLineNum = 138;BA.debugLine="table.Initialize(page,\"table\",True,False,True,\"\")";
_table.Initialize(_page,"table",__c.True,__c.False,__c.True,"");
 //BA.debugLineNum = 139;BA.debugLine="table.SetHeaders(Array As String(\"song\"))";
_table.SetHeaders(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"song"}));
 //BA.debugLineNum = 141;BA.debugLine="Dim player As ABMAudioPlayer";
_player = new com.ab.abmaterial.ABMAudioPlayer();
 //BA.debugLineNum = 142;BA.debugLine="player.Initialize(page,\"player\",True,False,False,";
_player.Initialize(_page,"player",__c.True,__c.False,__c.False,"");
 //BA.debugLineNum = 144;BA.debugLine="Dim list As List";
_list = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 145;BA.debugLine="list.Initialize";
_list.Initialize();
 //BA.debugLineNum = 146;BA.debugLine="list.Add(player)";
_list.Add((Object)(_player));
 //BA.debugLineNum = 148;BA.debugLine="Dim song As ABMAudioPlayerSong";
_song = new com.ab.abmaterial.ABMAudioPlayerSong();
 //BA.debugLineNum = 149;BA.debugLine="song.Initialize(\"../Audio/01 (Open) 00 00.mp3\")";
_song.Initialize("../Audio/01 (Open) 00 00.mp3");
 //BA.debugLineNum = 150;BA.debugLine="player.LoadSingleSong(song)";
_player.LoadSingleSong(_song);
 //BA.debugLineNum = 152;BA.debugLine="table.AddRow(\"tb\",list)";
_table.AddRow("tb",_list);
 //BA.debugLineNum = 154;BA.debugLine="page.Cell(1,1).AddComponent(table)";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_table));
 //BA.debugLineNum = 157;BA.debugLine="Dim floatingcont1 As ABMContainer";
_floatingcont1 = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 158;BA.debugLine="floatingcont1.Initialize(page, \"floatingcont1\", \"";
_floatingcont1.Initialize(_page,"floatingcont1","");
 //BA.debugLineNum = 159;BA.debugLine="floatingcont1.AddRowsM(1,False,0,0, \"\").AddCellsO";
_floatingcont1.AddRowsM((int) (1),__c.False,(int) (0),(int) (0),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (12),(int) (12),(int) (0),(int) (0),(int) (0),(int) (0),"");
 //BA.debugLineNum = 160;BA.debugLine="floatingcont1.BuildGrid ' IMPORTANT";
_floatingcont1.BuildGrid();
 //BA.debugLineNum = 161;BA.debugLine="page.AddFloatingContainer(floatingcont1, ABM.FLOA";
_page.AddFloatingContainer(_floatingcont1,_abm.FLOATING_FROMTOP,"0px");
 //BA.debugLineNum = 163;BA.debugLine="Dim floatingcont2 As ABMContainer";
_floatingcont2 = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 164;BA.debugLine="floatingcont2.Initialize(page, \"floatingcont2\", \"";
_floatingcont2.Initialize(_page,"floatingcont2","");
 //BA.debugLineNum = 165;BA.debugLine="floatingcont2.AddRowsM(1,False,0,0, \"\").AddCellsO";
_floatingcont2.AddRowsM((int) (1),__c.False,(int) (0),(int) (0),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (12),(int) (12),(int) (0),(int) (0),(int) (0),(int) (0),"");
 //BA.debugLineNum = 166;BA.debugLine="floatingcont2.BuildGrid ' IMPORTANT";
_floatingcont2.BuildGrid();
 //BA.debugLineNum = 167;BA.debugLine="page.AddFloatingContainerHideOnScroll(floatingcon";
_page.AddFloatingContainerHideOnScroll(_floatingcont2,_abm.FLOATING_FROMBOTTOM,"110px",0.2,1.0);
 //BA.debugLineNum = 169;BA.debugLine="ABMShared.BuildFooterFixed(page)";
_abmshared._buildfooterfixed(_page);
 //BA.debugLineNum = 170;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 91;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 92;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 94;BA.debugLine="theme.AddContainerTheme(\"menu\")";
_theme.AddContainerTheme("menu");
 //BA.debugLineNum = 95;BA.debugLine="theme.Container(\"menu\").BackColor = ABM.COLOR_TEA";
_theme.Container("menu").BackColor = _abm.COLOR_TEAL;
 //BA.debugLineNum = 96;BA.debugLine="theme.Container(\"menu\").BackColorIntensity = ABM.";
_theme.Container("menu").BackColorIntensity = _abm.INTENSITY_ACCENT3;
 //BA.debugLineNum = 98;BA.debugLine="theme.AddLabelTheme(\"white\")";
_theme.AddLabelTheme("white");
 //BA.debugLineNum = 99;BA.debugLine="theme.Label(\"white\").ForeColor = ABM.COLOR_WHITE";
_theme.Label("white").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 102;BA.debugLine="theme.AddButtonTheme(\"bigblue\")";
_theme.AddButtonTheme("bigblue");
 //BA.debugLineNum = 103;BA.debugLine="theme.Button(\"bigblue\").BackColor = ABM.COLOR_LIG";
_theme.Button("bigblue").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 105;BA.debugLine="theme.AddButtonTheme(\"sub1\")";
_theme.AddButtonTheme("sub1");
 //BA.debugLineNum = 106;BA.debugLine="theme.Button(\"sub1\").BackColor = ABM.COLOR_RED";
_theme.Button("sub1").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 108;BA.debugLine="theme.AddButtonTheme(\"sub2\")";
_theme.AddButtonTheme("sub2");
 //BA.debugLineNum = 109;BA.debugLine="theme.Button(\"sub2\").BackColor = ABM.COLOR_GREEN";
_theme.Button("sub2").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 111;BA.debugLine="theme.AddButtonTheme(\"sub3\")";
_theme.AddButtonTheme("sub3");
 //BA.debugLineNum = 112;BA.debugLine="theme.Button(\"sub3\").BackColor = ABM.COLOR_YELLOW";
_theme.Button("sub3").BackColor = _abm.COLOR_YELLOW;
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"TestPage\"";
_name = "TestPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMContainer _floatingcont1 = null;
com.ab.abmaterial.ABMContainer _cont2 = null;
com.ab.abmaterial.ABMImage _img = null;
com.ab.abmaterial.ABMLabel _lbl = null;
com.ab.abmaterial.ABMImage _img2 = null;
com.ab.abmaterial.ABMImage _img3 = null;
com.ab.abmaterial.ABMImage _img4 = null;
com.ab.abmaterial.ABMLabel _biglabel = null;
com.ab.abmaterial.ABMContainer _floatingcont2 = null;
com.ab.abmaterial.ABMContainer _cont3 = null;
com.ab.abmaterial.ABMActionButton _acb1 = null;
com.ab.abmaterial.ABMButton _btn1 = null;
com.ab.abmaterial.ABMButton _btn2 = null;
com.ab.abmaterial.ABMButton _btn3 = null;
 //BA.debugLineNum = 172;BA.debugLine="public Sub ConnectPage()";
 //BA.debugLineNum = 174;BA.debugLine="Dim floatingcont1 As ABMContainer";
_floatingcont1 = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 175;BA.debugLine="floatingcont1 = page.FloatingContainer(\"floatingc";
_floatingcont1 = _page.FloatingContainer("floatingcont1");
 //BA.debugLineNum = 178;BA.debugLine="Dim cont2 As ABMContainer";
_cont2 = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 179;BA.debugLine="cont2.Initialize(page, \"cont2\", \"menu\")";
_cont2.Initialize(_page,"cont2","menu");
 //BA.debugLineNum = 180;BA.debugLine="cont2.AddRows(1,False,\"\").AddCellsOS(1,0,0,0,6,2,";
_cont2.AddRows((int) (1),__c.False,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (6),(int) (2),(int) (1),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (1),(int) (7),(int) (9),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (5),(int) (3),(int) (2),"");
 //BA.debugLineNum = 181;BA.debugLine="cont2.BuildGrid";
_cont2.BuildGrid();
 //BA.debugLineNum = 183;BA.debugLine="cont2.Cell(1,1).MarginLeft = \"6px\"";
_cont2.Cell((int) (1),(int) (1)).MarginLeft = "6px";
 //BA.debugLineNum = 184;BA.debugLine="cont2.Cell(1,1).Margintop = \"6px\"";
_cont2.Cell((int) (1),(int) (1)).MarginTop = "6px";
 //BA.debugLineNum = 186;BA.debugLine="cont2.Cell(1,2).MarginLeft = \"-6px\"	' to compensa";
_cont2.Cell((int) (1),(int) (2)).MarginLeft = "-6px";
 //BA.debugLineNum = 188;BA.debugLine="cont2.Cell(1,3).Margintop = \"16px\"";
_cont2.Cell((int) (1),(int) (3)).MarginTop = "16px";
 //BA.debugLineNum = 190;BA.debugLine="Dim img As ABMImage";
_img = new com.ab.abmaterial.ABMImage();
 //BA.debugLineNum = 191;BA.debugLine="img.Initialize(page, \"img\", \"../images/paulo.png\"";
_img.Initialize(_page,"img","../images/paulo.png",1);
 //BA.debugLineNum = 192;BA.debugLine="cont2.Cell(1,1).AddComponent(img)";
_cont2.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_img));
 //BA.debugLineNum = 194;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 195;BA.debugLine="lbl.Initialize(page, \"lbl\", \"{NBSP}{I}Paulo Gomez";
_lbl.Initialize(_page,"lbl","{NBSP}{I}Paulo Gomez{/I}",_abm.SIZE_H4,__c.False,"white");
 //BA.debugLineNum = 196;BA.debugLine="lbl.Visibility = ABM.VISIBILITY_HIDE_ON_SMALL_ONL";
_lbl.Visibility = _abm.VISIBILITY_HIDE_ON_SMALL_ONLY;
 //BA.debugLineNum = 197;BA.debugLine="cont2.Cell(1,2).AddComponent(lbl)";
_cont2.Cell((int) (1),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl));
 //BA.debugLineNum = 199;BA.debugLine="Dim img2 As ABMImage";
_img2 = new com.ab.abmaterial.ABMImage();
 //BA.debugLineNum = 200;BA.debugLine="img2.Initialize(page, \"img2\", \"../images/france_r";
_img2.Initialize(_page,"img2","../images/france_round_256.png",1);
 //BA.debugLineNum = 201;BA.debugLine="img2.SetFixedSize(48,36)";
_img2.SetFixedSize((int) (48),(int) (36));
 //BA.debugLineNum = 202;BA.debugLine="cont2.Cell(1,3).AddComponent(img2)";
_cont2.Cell((int) (1),(int) (3)).AddComponent((com.ab.abmaterial.ABMComponent)(_img2));
 //BA.debugLineNum = 204;BA.debugLine="Dim img3 As ABMImage";
_img3 = new com.ab.abmaterial.ABMImage();
 //BA.debugLineNum = 205;BA.debugLine="img3.Initialize(page, \"img3\", \"../images/united_k";
_img3.Initialize(_page,"img3","../images/united_kingdom_round_icon_256.png",1);
 //BA.debugLineNum = 206;BA.debugLine="img3.SetFixedSize(48,36)";
_img3.SetFixedSize((int) (48),(int) (36));
 //BA.debugLineNum = 207;BA.debugLine="cont2.Cell(1,3).AddComponent(img3)";
_cont2.Cell((int) (1),(int) (3)).AddComponent((com.ab.abmaterial.ABMComponent)(_img3));
 //BA.debugLineNum = 209;BA.debugLine="Dim img4 As ABMImage";
_img4 = new com.ab.abmaterial.ABMImage();
 //BA.debugLineNum = 210;BA.debugLine="img4.Initialize(page, \"img4\", \"../images/hungary_";
_img4.Initialize(_page,"img4","../images/hungary_round_icon_256.png",1);
 //BA.debugLineNum = 211;BA.debugLine="img4.SetFixedSize(48,36)";
_img4.SetFixedSize((int) (48),(int) (36));
 //BA.debugLineNum = 212;BA.debugLine="cont2.Cell(1,3).AddComponent(img4)";
_cont2.Cell((int) (1),(int) (3)).AddComponent((com.ab.abmaterial.ABMComponent)(_img4));
 //BA.debugLineNum = 215;BA.debugLine="floatingcont1.Cell(1,1).AddComponent(cont2)";
_floatingcont1.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_cont2));
 //BA.debugLineNum = 217;BA.debugLine="page.Cell(1,1).PaddingTop = \"50px\"";
_page.Cell((int) (1),(int) (1)).PaddingTop = "50px";
 //BA.debugLineNum = 219;BA.debugLine="Dim biglabel As ABMLabel";
_biglabel = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 220;BA.debugLine="biglabel.Initialize(page, \"biglabel\", ABM.Util.pa";
_biglabel.Initialize(_page,"biglabel",_abm.Util.paragraphs((int) (50),__c.True),_abm.SIZE_PARAGRAPH,__c.True,"");
 //BA.debugLineNum = 221;BA.debugLine="page.Cell(2,1).AddComponent(biglabel)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_biglabel));
 //BA.debugLineNum = 223;BA.debugLine="Dim floatingcont2 As ABMContainer";
_floatingcont2 = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 224;BA.debugLine="floatingcont2 = page.FloatingContainer(\"floatingc";
_floatingcont2 = _page.FloatingContainer("floatingcont2");
 //BA.debugLineNum = 226;BA.debugLine="Dim cont3 As ABMContainer";
_cont3 = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 227;BA.debugLine="cont3.Initialize(page, \"cont3\", \"\")";
_cont3.Initialize(_page,"cont3","");
 //BA.debugLineNum = 228;BA.debugLine="cont3.AddRows(1,False,\"\").AddCellsOS(1,10,10,10,2";
_cont3.AddRows((int) (1),__c.False,"").AddCellsOS((int) (1),(int) (10),(int) (10),(int) (10),(int) (2),(int) (2),(int) (2),"");
 //BA.debugLineNum = 229;BA.debugLine="cont3.BuildGrid";
_cont3.BuildGrid();
 //BA.debugLineNum = 231;BA.debugLine="Dim acb1 As ABMActionButton";
_acb1 = new com.ab.abmaterial.ABMActionButton();
 //BA.debugLineNum = 232;BA.debugLine="acb1.Initialize(page, \"acb1\", \"mdi-action-shop\",";
_acb1.Initialize(_page,"acb1","mdi-action-shop","","bigblue");
 //BA.debugLineNum = 233;BA.debugLine="acb1.MainButton.size = ABM.BUTTONSIZE_LARGE";
_acb1.MainButton().Size = _abm.BUTTONSIZE_LARGE;
 //BA.debugLineNum = 236;BA.debugLine="Dim btn1 As ABMButton";
_btn1 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 237;BA.debugLine="btn1.InitializeFloating(page, \"btn1\", \"mdi-social";
_btn1.InitializeFloating(_page,"btn1","mdi-social-share","sub1");
 //BA.debugLineNum = 238;BA.debugLine="acb1.AddMenuButton(btn1)";
_acb1.AddMenuButton(_btn1);
 //BA.debugLineNum = 239;BA.debugLine="Dim btn2 As ABMButton";
_btn2 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 240;BA.debugLine="btn2.InitializeFloating(page, \"btn2\", \"mdi-social";
_btn2.InitializeFloating(_page,"btn2","mdi-social-whatshot","sub2");
 //BA.debugLineNum = 241;BA.debugLine="acb1.AddMenuButton(btn2)";
_acb1.AddMenuButton(_btn2);
 //BA.debugLineNum = 242;BA.debugLine="Dim btn3 As ABMButton";
_btn3 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 243;BA.debugLine="btn3.InitializeFloating(page, \"btn3\", \"mdi-social";
_btn3.InitializeFloating(_page,"btn3","mdi-social-notifications","sub3");
 //BA.debugLineNum = 244;BA.debugLine="acb1.AddMenuButton(btn3)";
_acb1.AddMenuButton(_btn3);
 //BA.debugLineNum = 247;BA.debugLine="cont3.Cell(1,1).AddComponent(acb1)";
_cont3.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_acb1));
 //BA.debugLineNum = 250;BA.debugLine="floatingcont2.Cell(1,1).AddComponent(cont3)";
_floatingcont2.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_cont3));
 //BA.debugLineNum = 253;BA.debugLine="ABMShared.ConnectFooterFixed(page)";
_abmshared._connectfooterfixed(_page);
 //BA.debugLineNum = 255;BA.debugLine="page.Refresh ' IMPORTANT!";
_page.Refresh();
 //BA.debugLineNum = 258;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 260;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 265;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 20;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 23;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 268;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 269;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 271;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 272;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 274;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 275;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 276;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 277;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 278;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 279;BA.debugLine="End Sub";
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
