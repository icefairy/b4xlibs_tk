package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compvideopage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compvideopage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compvideopage.class).invoke(this, new Object[] {null});
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
public String _origin = "";
public int _mytoastid = 0;
public boolean _isplaying = false;
public boolean _ismuted = false;
public int _volume = 0;
public boolean _initialvideo = false;
public boolean _isplaying5 = false;
public boolean _ismuted5 = false;
public int _volume5 = 0;
public boolean _initialvideo5 = false;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _btn_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMButton _button = null;
com.ab.abmaterial.ABMVideo _video = null;
 //BA.debugLineNum = 326;BA.debugLine="Sub btn_Clicked(Target As String)";
 //BA.debugLineNum = 327;BA.debugLine="Dim button As ABMButton = page.Component(\"btn\")";
_button = (com.ab.abmaterial.ABMButton)(_page.Component("btn"));
 //BA.debugLineNum = 328;BA.debugLine="Dim video As ABMVideo = page.Component(\"video1b\")";
_video = (com.ab.abmaterial.ABMVideo)(_page.Component("video1b"));
 //BA.debugLineNum = 329;BA.debugLine="If InitialVideo Then";
if (_initialvideo) { 
 //BA.debugLineNum = 330;BA.debugLine="button.Text = \"Load Original\"";
_button.Text = "Load Original";
 //BA.debugLineNum = 331;BA.debugLine="InitialVideo = False";
_initialvideo = __c.False;
 //BA.debugLineNum = 332;BA.debugLine="video.LoadVideoYouTube(\"rrT6v5sOwJg\")";
_video.LoadVideoYouTube("rrT6v5sOwJg");
 }else {
 //BA.debugLineNum = 334;BA.debugLine="button.Text = \"Load Other\"";
_button.Text = "Load Other";
 //BA.debugLineNum = 335;BA.debugLine="InitialVideo = True";
_initialvideo = __c.True;
 //BA.debugLineNum = 336;BA.debugLine="video.LoadVideoYouTube(\"Q8TXgCzxEnw\")";
_video.LoadVideoYouTube("Q8TXgCzxEnw");
 };
 //BA.debugLineNum = 338;BA.debugLine="button.refresh ' IMPORTANT";
_button.Refresh();
 //BA.debugLineNum = 339;BA.debugLine="End Sub";
return "";
}
public String  _btn5_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMButton _button = null;
com.ab.abmaterial.ABMButton _btnplay = null;
com.ab.abmaterial.ABMVideo _video = null;
 //BA.debugLineNum = 384;BA.debugLine="Sub btn5_Clicked(Target As String)";
 //BA.debugLineNum = 385;BA.debugLine="Dim button As ABMButton = page.Component(\"btn5\")";
_button = (com.ab.abmaterial.ABMButton)(_page.Component("btn5"));
 //BA.debugLineNum = 386;BA.debugLine="Dim btnPlay As ABMButton = page.Component(\"btnPla";
_btnplay = (com.ab.abmaterial.ABMButton)(_page.Component("btnPlay5"));
 //BA.debugLineNum = 387;BA.debugLine="Dim video As ABMVideo = page.Component(\"video2\")";
_video = (com.ab.abmaterial.ABMVideo)(_page.Component("video2"));
 //BA.debugLineNum = 388;BA.debugLine="If InitialVideo5 Then";
if (_initialvideo5) { 
 //BA.debugLineNum = 389;BA.debugLine="button.Text = \"Load Original\"";
_button.Text = "Load Original";
 //BA.debugLineNum = 390;BA.debugLine="InitialVideo5 = False";
_initialvideo5 = __c.False;
 //BA.debugLineNum = 391;BA.debugLine="video.LoadVideoHTML5(\"http://techslides.com/demo";
_video.LoadVideoHTML5("http://techslides.com/demos/sample-videos/small.mp4","video/mp4");
 }else {
 //BA.debugLineNum = 393;BA.debugLine="button.Text = \"Load Other\"";
_button.Text = "Load Other";
 //BA.debugLineNum = 394;BA.debugLine="InitialVideo5 = True";
_initialvideo5 = __c.True;
 //BA.debugLineNum = 395;BA.debugLine="video.LoadVideoHTML5(\"http://clips.vorwaerts-gmb";
_video.LoadVideoHTML5("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4","video/mp4");
 };
 //BA.debugLineNum = 397;BA.debugLine="IsPlaying5 = False";
_isplaying5 = __c.False;
 //BA.debugLineNum = 398;BA.debugLine="btnPlay.IconName = \"mdi-av-play-arrow\"";
_btnplay.IconName = "mdi-av-play-arrow";
 //BA.debugLineNum = 399;BA.debugLine="btnPlay.Refresh ' IMPORTANT";
_btnplay.Refresh();
 //BA.debugLineNum = 400;BA.debugLine="button.refresh ' IMPORTANT";
_button.Refresh();
 //BA.debugLineNum = 401;BA.debugLine="video.Refresh ' IMPORTANT";
_video.Refresh();
 //BA.debugLineNum = 402;BA.debugLine="End Sub";
return "";
}
public String  _btnmute_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMButton _btnmute = null;
com.ab.abmaterial.ABMVideo _video = null;
 //BA.debugLineNum = 369;BA.debugLine="Sub btnMute_Clicked(Target As String)";
 //BA.debugLineNum = 370;BA.debugLine="Dim btnMute As ABMButton = page.Component(\"btnMut";
_btnmute = (com.ab.abmaterial.ABMButton)(_page.Component("btnMute"));
 //BA.debugLineNum = 371;BA.debugLine="Dim video As ABMVideo = page.Component(\"video1b\")";
_video = (com.ab.abmaterial.ABMVideo)(_page.Component("video1b"));
 //BA.debugLineNum = 372;BA.debugLine="If IsMuted Then";
if (_ismuted) { 
 //BA.debugLineNum = 373;BA.debugLine="IsMuted = False";
_ismuted = __c.False;
 //BA.debugLineNum = 374;BA.debugLine="video.UnMute";
_video.UnMute();
 //BA.debugLineNum = 375;BA.debugLine="btnMute.IconName = \"mdi-av-volume-mute\"";
_btnmute.IconName = "mdi-av-volume-mute";
 }else {
 //BA.debugLineNum = 377;BA.debugLine="video.Mute";
_video.Mute();
 //BA.debugLineNum = 378;BA.debugLine="IsMuted = True";
_ismuted = __c.True;
 //BA.debugLineNum = 379;BA.debugLine="btnMute.IconName = \"mdi-av-volume-off\"";
_btnmute.IconName = "mdi-av-volume-off";
 };
 //BA.debugLineNum = 381;BA.debugLine="btnMute.Refresh ' IMPORTANT";
_btnmute.Refresh();
 //BA.debugLineNum = 382;BA.debugLine="End Sub";
return "";
}
public String  _btnmute5_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMButton _btnmute = null;
com.ab.abmaterial.ABMVideo _video = null;
 //BA.debugLineNum = 442;BA.debugLine="Sub btnMute5_Clicked(Target As String)";
 //BA.debugLineNum = 443;BA.debugLine="Dim btnMute As ABMButton = page.Component(\"btnMut";
_btnmute = (com.ab.abmaterial.ABMButton)(_page.Component("btnMute5"));
 //BA.debugLineNum = 444;BA.debugLine="Dim video As ABMVideo = page.Component(\"video2\")";
_video = (com.ab.abmaterial.ABMVideo)(_page.Component("video2"));
 //BA.debugLineNum = 445;BA.debugLine="If IsMuted5 Then";
if (_ismuted5) { 
 //BA.debugLineNum = 446;BA.debugLine="IsMuted5 = False";
_ismuted5 = __c.False;
 //BA.debugLineNum = 447;BA.debugLine="video.UnMute";
_video.UnMute();
 //BA.debugLineNum = 448;BA.debugLine="btnMute.IconName = \"mdi-av-volume-mute\"";
_btnmute.IconName = "mdi-av-volume-mute";
 }else {
 //BA.debugLineNum = 450;BA.debugLine="video.Mute";
_video.Mute();
 //BA.debugLineNum = 451;BA.debugLine="IsMuted5 = True";
_ismuted5 = __c.True;
 //BA.debugLineNum = 452;BA.debugLine="btnMute.IconName = \"mdi-av-volume-off\"";
_btnmute.IconName = "mdi-av-volume-off";
 };
 //BA.debugLineNum = 454;BA.debugLine="btnMute.Refresh ' IMPORTANT";
_btnmute.Refresh();
 //BA.debugLineNum = 455;BA.debugLine="End Sub";
return "";
}
public String  _btnplay_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMVideo _video = null;
 //BA.debugLineNum = 341;BA.debugLine="Sub btnPlay_Clicked(Target As String)";
 //BA.debugLineNum = 342;BA.debugLine="Dim video As ABMVideo = page.Component(\"video1b\")";
_video = (com.ab.abmaterial.ABMVideo)(_page.Component("video1b"));
 //BA.debugLineNum = 343;BA.debugLine="If IsPlaying Then";
if (_isplaying) { 
 //BA.debugLineNum = 344;BA.debugLine="video.Pause";
_video.Pause();
 }else {
 //BA.debugLineNum = 346;BA.debugLine="video.Play";
_video.Play();
 };
 //BA.debugLineNum = 348;BA.debugLine="End Sub";
return "";
}
public String  _btnplay5_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMVideo _video = null;
com.ab.abmaterial.ABMButton _btnplay = null;
 //BA.debugLineNum = 404;BA.debugLine="Sub btnPlay5_Clicked(Target As String)";
 //BA.debugLineNum = 405;BA.debugLine="Dim video As ABMVideo = page.Component(\"video2\")";
_video = (com.ab.abmaterial.ABMVideo)(_page.Component("video2"));
 //BA.debugLineNum = 406;BA.debugLine="Dim btnPlay As ABMButton = page.Component(\"btnPla";
_btnplay = (com.ab.abmaterial.ABMButton)(_page.Component("btnPlay5"));
 //BA.debugLineNum = 407;BA.debugLine="If IsPlaying5 Then";
if (_isplaying5) { 
 //BA.debugLineNum = 408;BA.debugLine="video.Pause";
_video.Pause();
 //BA.debugLineNum = 409;BA.debugLine="IsPlaying5 = False";
_isplaying5 = __c.False;
 //BA.debugLineNum = 410;BA.debugLine="btnPlay.IconName = \"mdi-av-play-arrow\"";
_btnplay.IconName = "mdi-av-play-arrow";
 //BA.debugLineNum = 411;BA.debugLine="btnPlay.Refresh ' IMPORTANT";
_btnplay.Refresh();
 }else {
 //BA.debugLineNum = 413;BA.debugLine="video.Play";
_video.Play();
 //BA.debugLineNum = 414;BA.debugLine="IsPlaying5 = True";
_isplaying5 = __c.True;
 //BA.debugLineNum = 415;BA.debugLine="btnPlay.IconName = \"mdi-av-pause\"";
_btnplay.IconName = "mdi-av-pause";
 //BA.debugLineNum = 416;BA.debugLine="btnPlay.Refresh ' IMPORTANT";
_btnplay.Refresh();
 };
 //BA.debugLineNum = 418;BA.debugLine="End Sub";
return "";
}
public String  _btnstop_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMVideo _video = null;
 //BA.debugLineNum = 350;BA.debugLine="Sub btnStop_Clicked(Target As String)";
 //BA.debugLineNum = 351;BA.debugLine="Dim video As ABMVideo = page.Component(\"video1b\")";
_video = (com.ab.abmaterial.ABMVideo)(_page.Component("video1b"));
 //BA.debugLineNum = 352;BA.debugLine="video.Stop";
_video.Stop();
 //BA.debugLineNum = 353;BA.debugLine="End Sub";
return "";
}
public String  _btnstop5_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMVideo _video = null;
com.ab.abmaterial.ABMButton _btnplay = null;
 //BA.debugLineNum = 420;BA.debugLine="Sub btnStop5_Clicked(Target As String)";
 //BA.debugLineNum = 421;BA.debugLine="Dim video As ABMVideo = page.Component(\"video2\")";
_video = (com.ab.abmaterial.ABMVideo)(_page.Component("video2"));
 //BA.debugLineNum = 422;BA.debugLine="video.Stop";
_video.Stop();
 //BA.debugLineNum = 423;BA.debugLine="Dim btnPlay As ABMButton = page.Component(\"btnPla";
_btnplay = (com.ab.abmaterial.ABMButton)(_page.Component("btnPlay5"));
 //BA.debugLineNum = 424;BA.debugLine="btnPlay.IconName = \"mdi-av-play-arrow\"";
_btnplay.IconName = "mdi-av-play-arrow";
 //BA.debugLineNum = 425;BA.debugLine="btnPlay.Refresh ' IMPORTANT";
_btnplay.Refresh();
 //BA.debugLineNum = 426;BA.debugLine="End Sub";
return "";
}
public String  _btnvolumedown_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMVideo _video = null;
 //BA.debugLineNum = 355;BA.debugLine="Sub btnVolumeDown_Clicked(Target As String)";
 //BA.debugLineNum = 356;BA.debugLine="Dim video As ABMVideo = page.Component(\"video1b\")";
_video = (com.ab.abmaterial.ABMVideo)(_page.Component("video1b"));
 //BA.debugLineNum = 357;BA.debugLine="Volume = Volume - 10";
_volume = (int) (_volume-10);
 //BA.debugLineNum = 358;BA.debugLine="If Volume < 0 Then Volume = 0";
if (_volume<0) { 
_volume = (int) (0);};
 //BA.debugLineNum = 359;BA.debugLine="video.SetVolume(Volume)";
_video.SetVolume(_volume);
 //BA.debugLineNum = 360;BA.debugLine="End Sub";
return "";
}
public String  _btnvolumedown5_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMVideo _video = null;
 //BA.debugLineNum = 428;BA.debugLine="Sub btnVolumeDown5_Clicked(Target As String)";
 //BA.debugLineNum = 429;BA.debugLine="Dim video As ABMVideo = page.Component(\"video2\")";
_video = (com.ab.abmaterial.ABMVideo)(_page.Component("video2"));
 //BA.debugLineNum = 430;BA.debugLine="Volume5 = Volume5 - 10";
_volume5 = (int) (_volume5-10);
 //BA.debugLineNum = 431;BA.debugLine="If Volume5 < 0 Then Volume5 = 0";
if (_volume5<0) { 
_volume5 = (int) (0);};
 //BA.debugLineNum = 432;BA.debugLine="video.SetVolume(Volume5)";
_video.SetVolume(_volume5);
 //BA.debugLineNum = 433;BA.debugLine="End Sub";
return "";
}
public String  _btnvolumeup_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMVideo _video = null;
 //BA.debugLineNum = 362;BA.debugLine="Sub btnVolumeUp_Clicked(Target As String)";
 //BA.debugLineNum = 363;BA.debugLine="Dim video As ABMVideo = page.Component(\"video1b\")";
_video = (com.ab.abmaterial.ABMVideo)(_page.Component("video1b"));
 //BA.debugLineNum = 364;BA.debugLine="Volume = Volume + 10";
_volume = (int) (_volume+10);
 //BA.debugLineNum = 365;BA.debugLine="If Volume > 100 Then Volume = 100";
if (_volume>100) { 
_volume = (int) (100);};
 //BA.debugLineNum = 366;BA.debugLine="video.SetVolume(Volume)";
_video.SetVolume(_volume);
 //BA.debugLineNum = 367;BA.debugLine="End Sub";
return "";
}
public String  _btnvolumeup5_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMVideo _video = null;
 //BA.debugLineNum = 435;BA.debugLine="Sub btnVolumeUp5_Clicked(Target As String)";
 //BA.debugLineNum = 436;BA.debugLine="Dim video As ABMVideo = page.Component(\"video2\")";
_video = (com.ab.abmaterial.ABMVideo)(_page.Component("video2"));
 //BA.debugLineNum = 437;BA.debugLine="Volume5 = Volume5 + 10";
_volume5 = (int) (_volume5+10);
 //BA.debugLineNum = 438;BA.debugLine="If Volume5 > 100 Then Volume5 = 100";
if (_volume5>100) { 
_volume5 = (int) (100);};
 //BA.debugLineNum = 439;BA.debugLine="video.SetVolume(Volume5)";
_video.SetVolume(_volume5);
 //BA.debugLineNum = 440;BA.debugLine="End Sub";
return "";
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 118;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 120;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 123;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 124;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 125;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 126;BA.debugLine="page.PageTitle = \"ABMVideo\"";
_page.PageTitle = "ABMVideo";
 //BA.debugLineNum = 127;BA.debugLine="page.PageDescription = \"The video component \"";
_page.PageDescription = "The video component ";
 //BA.debugLineNum = 128;BA.debugLine="page.PageHTMLName = \"abmaterial-video.html\"";
_page.PageHTMLName = "abmaterial-video.html";
 //BA.debugLineNum = 129;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 130;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 131;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 132;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 134;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMVideo\", \".";
_abmshared._buildnavigationbar(_page,"ABMVideo","../images/logo.png","","Controls","ABMVideo");
 //BA.debugLineNum = 137;BA.debugLine="page.AddRows(18,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (18),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 138;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 143;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 100;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 101;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 105;BA.debugLine="theme.AddButtonTheme(\"bluegrey\")";
_theme.AddButtonTheme("bluegrey");
 //BA.debugLineNum = 106;BA.debugLine="theme.Button(\"bluegrey\").BackColor = ABM.COLOR_BL";
_theme.Button("bluegrey").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 107;BA.debugLine="theme.Button(\"bluegrey\").BackColorIntensity = ABM";
_theme.Button("bluegrey").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 110;BA.debugLine="theme.AddButtonTheme(\"darkred\")";
_theme.AddButtonTheme("darkred");
 //BA.debugLineNum = 111;BA.debugLine="theme.Button(\"darkred\").BackColor = ABM.COLOR_RED";
_theme.Button("darkred").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 112;BA.debugLine="theme.Button(\"darkred\").BackColorIntensity = ABM.";
_theme.Button("darkred").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 114;BA.debugLine="theme.AddCellTheme(\"aligncenter\")";
_theme.AddCellTheme("aligncenter");
 //BA.debugLineNum = 115;BA.debugLine="theme.Cell(\"aligncenter\").Align = ABM.CELL_ALIGN_";
_theme.Cell("aligncenter").Align = _abm.CELL_ALIGN_CENTER;
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompVideoPage\"";
_name = "CompVideoPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim Origin As String = \"http://localhost:51042\" '";
_origin = "http://localhost:51042";
 //BA.debugLineNum = 17;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 19;BA.debugLine="Dim IsPlaying As Boolean = False";
_isplaying = __c.False;
 //BA.debugLineNum = 20;BA.debugLine="Dim IsMuted As Boolean = False";
_ismuted = __c.False;
 //BA.debugLineNum = 21;BA.debugLine="Dim Volume As Int = 100";
_volume = (int) (100);
 //BA.debugLineNum = 22;BA.debugLine="Dim InitialVideo As Boolean = True";
_initialvideo = __c.True;
 //BA.debugLineNum = 24;BA.debugLine="Dim IsPlaying5 As Boolean = False";
_isplaying5 = __c.False;
 //BA.debugLineNum = 25;BA.debugLine="Dim IsMuted5 As Boolean = False";
_ismuted5 = __c.False;
 //BA.debugLineNum = 26;BA.debugLine="Dim Volume5 As Int = 100";
_volume5 = (int) (100);
 //BA.debugLineNum = 27;BA.debugLine="Dim InitialVideo5 As Boolean = True";
_initialvideo5 = __c.True;
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMVideo _video1 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code1 = null;
com.ab.abmaterial.ABMVideo _video1b = null;
com.ab.abmaterial.ABMButton _btnplay = null;
com.ab.abmaterial.ABMButton _btnstop = null;
com.ab.abmaterial.ABMButton _btnmute = null;
com.ab.abmaterial.ABMButton _btnvolumedown = null;
com.ab.abmaterial.ABMButton _btnvolumeup = null;
com.ab.abmaterial.ABMButton _btn = null;
com.ab.abmaterial.ABMVideo _video2 = null;
com.ab.abmaterial.ABMButton _btnplay5 = null;
com.ab.abmaterial.ABMButton _btnstop5 = null;
com.ab.abmaterial.ABMButton _btnmute5 = null;
com.ab.abmaterial.ABMButton _btnvolumedown5 = null;
com.ab.abmaterial.ABMButton _btnvolumeup5 = null;
com.ab.abmaterial.ABMButton _btn5 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code2 = null;
com.ab.abmaterial.ABMVideo _video4 = null;
String _code4 = "";
com.ab.abmaterial.ABMVideo _video3 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code3 = null;
 //BA.debugLineNum = 146;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 148;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 151;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","ABMaterial can use three types of Video containers: HTML5 videos, Youtube videos and Vimeo videos. They have their own Initialize method.")));
 //BA.debugLineNum = 154;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Youtube videos")));
 //BA.debugLineNum = 157;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","For Youtube videos you have to specify if it has controls, a frameborder, if it allows to go full screen and the initial volume.")));
 //BA.debugLineNum = 160;BA.debugLine="Dim video1 As ABMVideo";
_video1 = new com.ab.abmaterial.ABMVideo();
 //BA.debugLineNum = 161;BA.debugLine="video1.InitializeYoutube(page, \"video1\", \"//www.y";
_video1.InitializeYouTube(_page,"video1","//www.youtube.com/embed/Q8TXgCzxEnw",_origin,__c.True,__c.False,__c.True,(int) (100));
 //BA.debugLineNum = 162;BA.debugLine="page.Cell(2,1).AddComponent(video1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_video1));
 //BA.debugLineNum = 165;BA.debugLine="Dim code1 As StringBuilder";
_code1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 166;BA.debugLine="code1.Initialize";
_code1.Initialize();
 //BA.debugLineNum = 167;BA.debugLine="code1.Append(\"// add Youtube video\").Append(CRLF)";
_code1.Append("// add Youtube video").Append(__c.CRLF);
 //BA.debugLineNum = 168;BA.debugLine="code1.Append(\"Dim video1 As ABMVideo\").Append(CRL";
_code1.Append("Dim video1 As ABMVideo").Append(__c.CRLF);
 //BA.debugLineNum = 169;BA.debugLine="code1.Append(\"video1.InitializeIframe(page, \"\"vid";
_code1.Append("video1.InitializeIframe(page, \"video1\", \"//www.youtube.com/embed/Q8TXgCzxEnw\", \"http://localhost:51042\", True, False, True, 100)").Append(__c.CRLF);
 //BA.debugLineNum = 170;BA.debugLine="code1.Append(\"page.Cell(2,1).AddComponent(video1)";
_code1.Append("page.Cell(2,1).AddComponent(video1)").Append(__c.CRLF);
 //BA.debugLineNum = 172;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code1",_code1)));
 //BA.debugLineNum = 175;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2b","If you disable the youtube controls, you have to write your own play, pause, stop etc controls.")));
 //BA.debugLineNum = 178;BA.debugLine="Dim video1b As ABMVideo";
_video1b = new com.ab.abmaterial.ABMVideo();
 //BA.debugLineNum = 179;BA.debugLine="video1b.InitializeYoutube(page, \"video1b\", \"//www";
_video1b.InitializeYouTube(_page,"video1b","//www.youtube.com/embed/Q8TXgCzxEnw",_origin,__c.False,__c.False,__c.False,(int) (100));
 //BA.debugLineNum = 180;BA.debugLine="page.Cell(5,1).AddComponent(video1b)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_video1b));
 //BA.debugLineNum = 183;BA.debugLine="Dim btnPlay As ABMButton";
_btnplay = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 184;BA.debugLine="btnPlay.Initializefloating(page, \"btnPlay\", \"mdi-";
_btnplay.InitializeFloating(_page,"btnPlay","mdi-av-play-arrow","darkred");
 //BA.debugLineNum = 185;BA.debugLine="page.Cell(6,1).AddComponent(btnPlay)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnplay));
 //BA.debugLineNum = 187;BA.debugLine="Dim btnStop As ABMButton";
_btnstop = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 188;BA.debugLine="btnStop.Initializefloating(page, \"btnStop\", \"mdi-";
_btnstop.InitializeFloating(_page,"btnStop","mdi-av-stop","darkred");
 //BA.debugLineNum = 189;BA.debugLine="page.Cell(6,1).AddComponent(btnStop)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnstop));
 //BA.debugLineNum = 191;BA.debugLine="Dim btnMute As ABMButton";
_btnmute = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 192;BA.debugLine="btnMute.Initializefloating(page, \"btnMute\", \"mdi-";
_btnmute.InitializeFloating(_page,"btnMute","mdi-av-volume-mute","darkred");
 //BA.debugLineNum = 193;BA.debugLine="page.Cell(6,1).AddComponent(btnMute)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnmute));
 //BA.debugLineNum = 195;BA.debugLine="Dim btnVolumeDown As ABMButton";
_btnvolumedown = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 196;BA.debugLine="btnVolumeDown.Initializefloating(page, \"btnVolume";
_btnvolumedown.InitializeFloating(_page,"btnVolumeDown","mdi-av-volume-down","darkred");
 //BA.debugLineNum = 197;BA.debugLine="page.Cell(6,1).AddComponent(btnVolumeDown)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnvolumedown));
 //BA.debugLineNum = 199;BA.debugLine="Dim btnVolumeUp As ABMButton";
_btnvolumeup = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 200;BA.debugLine="btnVolumeUp.Initializefloating(page, \"btnVolumeUp";
_btnvolumeup.InitializeFloating(_page,"btnVolumeUp","mdi-av-volume-up","darkred");
 //BA.debugLineNum = 201;BA.debugLine="page.Cell(6,1).AddComponent(btnVolumeUp)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnvolumeup));
 //BA.debugLineNum = 203;BA.debugLine="Dim btn As ABMButton";
_btn = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 204;BA.debugLine="btn.InitializeRaised(page, \"btn\", \"\", \"\", \"Load O";
_btn.InitializeRaised(_page,"btn","","","Load Other","bluegrey");
 //BA.debugLineNum = 205;BA.debugLine="page.Cell(6,1).AddComponent(btn)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn));
 //BA.debugLineNum = 208;BA.debugLine="page.Cell(8,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","HTML videos")));
 //BA.debugLineNum = 211;BA.debugLine="page.Cell(8,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","For HTML5 videos you have to specify if it has controls and what video type is used.")));
 //BA.debugLineNum = 214;BA.debugLine="Dim video2 As ABMVideo";
_video2 = new com.ab.abmaterial.ABMVideo();
 //BA.debugLineNum = 215;BA.debugLine="video2.InitializeHTML5(page, \"video2\", \"http://cl";
_video2.InitializeHTML5(_page,"video2","http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4",__c.False,"video/mp4");
 //BA.debugLineNum = 216;BA.debugLine="page.Cell(9,1).AddComponent(video2)";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_video2));
 //BA.debugLineNum = 219;BA.debugLine="Dim btnPlay5 As ABMButton";
_btnplay5 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 220;BA.debugLine="btnPlay5.Initializefloating(page, \"btnPlay5\", \"md";
_btnplay5.InitializeFloating(_page,"btnPlay5","mdi-av-play-arrow","darkred");
 //BA.debugLineNum = 221;BA.debugLine="page.Cell(10,1).AddComponent(btnPlay5)";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnplay5));
 //BA.debugLineNum = 223;BA.debugLine="Dim btnStop5 As ABMButton";
_btnstop5 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 224;BA.debugLine="btnStop5.Initializefloating(page, \"btnStop5\", \"md";
_btnstop5.InitializeFloating(_page,"btnStop5","mdi-av-stop","darkred");
 //BA.debugLineNum = 225;BA.debugLine="page.Cell(10,1).AddComponent(btnStop5)";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnstop5));
 //BA.debugLineNum = 227;BA.debugLine="Dim btnMute5 As ABMButton";
_btnmute5 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 228;BA.debugLine="btnMute5.Initializefloating(page, \"btnMute5\", \"md";
_btnmute5.InitializeFloating(_page,"btnMute5","mdi-av-volume-mute","darkred");
 //BA.debugLineNum = 229;BA.debugLine="page.Cell(10,1).AddComponent(btnMute5)";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnmute5));
 //BA.debugLineNum = 231;BA.debugLine="Dim btnVolumeDown5 As ABMButton";
_btnvolumedown5 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 232;BA.debugLine="btnVolumeDown5.Initializefloating(page, \"btnVolum";
_btnvolumedown5.InitializeFloating(_page,"btnVolumeDown5","mdi-av-volume-down","darkred");
 //BA.debugLineNum = 233;BA.debugLine="page.Cell(10,1).AddComponent(btnVolumeDown5)";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnvolumedown5));
 //BA.debugLineNum = 235;BA.debugLine="Dim btnVolumeUp5 As ABMButton";
_btnvolumeup5 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 236;BA.debugLine="btnVolumeUp5.Initializefloating(page, \"btnVolumeU";
_btnvolumeup5.InitializeFloating(_page,"btnVolumeUp5","mdi-av-volume-up","darkred");
 //BA.debugLineNum = 237;BA.debugLine="page.Cell(10,1).AddComponent(btnVolumeUp5)";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btnvolumeup5));
 //BA.debugLineNum = 239;BA.debugLine="Dim btn5 As ABMButton";
_btn5 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 240;BA.debugLine="btn5.InitializeRaised(page, \"btn5\", \"\", \"\", \"Load";
_btn5.InitializeRaised(_page,"btn5","","","Load Other","bluegrey");
 //BA.debugLineNum = 241;BA.debugLine="page.Cell(10,1).AddComponent(btn5)";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn5));
 //BA.debugLineNum = 244;BA.debugLine="Dim code2 As StringBuilder";
_code2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 245;BA.debugLine="code2.Initialize";
_code2.Initialize();
 //BA.debugLineNum = 246;BA.debugLine="code2.Append(\"// add HTML5 video\").Append(CRLF)";
_code2.Append("// add HTML5 video").Append(__c.CRLF);
 //BA.debugLineNum = 247;BA.debugLine="code2.Append(\"Dim video2 As ABMVideo\").Append(CRL";
_code2.Append("Dim video2 As ABMVideo").Append(__c.CRLF);
 //BA.debugLineNum = 248;BA.debugLine="code2.Append(\"video2.InitializeHTML5(page, \"\"vide";
_code2.Append("video2.InitializeHTML5(page, \"video2\", \"http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4\", false, \"video/mp4\")").Append(__c.CRLF);
 //BA.debugLineNum = 249;BA.debugLine="code2.Append(\"page.Cell(9,1).AddComponent(video2)";
_code2.Append("page.Cell(9,1).AddComponent(video2)").Append(__c.CRLF);
 //BA.debugLineNum = 251;BA.debugLine="page.Cell(11,1).AddComponent(ABMShared.BuildCodeB";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code2",_code2)));
 //BA.debugLineNum = 254;BA.debugLine="page.Cell(12,1).AddComponent(ABMShared.BuildHeade";
_page.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr4","Vimeo videos")));
 //BA.debugLineNum = 257;BA.debugLine="page.Cell(12,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","For Vimeo videos you have to specify frameborder and if it allows to go full screen. The vimeo API is very limited and does not allow custom controls.")));
 //BA.debugLineNum = 260;BA.debugLine="Dim video4 As ABMVideo";
_video4 = new com.ab.abmaterial.ABMVideo();
 //BA.debugLineNum = 261;BA.debugLine="video4.InitializeVimeo(page, \"video4\", \"https://p";
_video4.InitializeVimeo(_page,"video4","https://player.vimeo.com/video/76979871",__c.False,__c.True);
 //BA.debugLineNum = 262;BA.debugLine="page.Cell(13,1).AddComponent(video4)";
_page.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_video4));
 //BA.debugLineNum = 265;BA.debugLine="Dim code4 As String = $\"// add Vimeo video Dim vi";
_code4 = ("// add Vimeo video\n"+"Dim video4 As ABMVideo\n"+"video4.InitializeVimeo(page, \"video4\", \"https://player.vimeo.com/video/76979871\",False, True)\n"+"page.Cell(13,1).AddComponent(video4)");
 //BA.debugLineNum = 269;BA.debugLine="page.Cell(14,1).AddComponent(ABMShared.BuildCodeB";
_page.Cell((int) (14),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code4",_code4)));
 //BA.debugLineNum = 272;BA.debugLine="page.Cell(15,1).AddComponent(ABMShared.BuildHeade";
_page.Cell((int) (15),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr2","Video Size")));
 //BA.debugLineNum = 275;BA.debugLine="page.Cell(15,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (15),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","By default the videos are responsive and they will be sized automatically.  You can overrule this by specifying a fixed size.")));
 //BA.debugLineNum = 278;BA.debugLine="Dim video3 As ABMVideo";
_video3 = new com.ab.abmaterial.ABMVideo();
 //BA.debugLineNum = 279;BA.debugLine="video3.InitializeHTML5(page, \"video3\", \"http://cl";
_video3.InitializeHTML5(_page,"video3","http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4",__c.True,"video/mp4");
 //BA.debugLineNum = 280;BA.debugLine="video3.SetFixedSize(320, 200)";
_video3.SetFixedSize((int) (320),(int) (200));
 //BA.debugLineNum = 281;BA.debugLine="page.Cell(16,1).UseTheme(\"aligncenter\")";
_page.Cell((int) (16),(int) (1)).UseTheme("aligncenter");
 //BA.debugLineNum = 282;BA.debugLine="page.Cell(16,1).AddComponent(video3)";
_page.Cell((int) (16),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_video3));
 //BA.debugLineNum = 285;BA.debugLine="Dim code3 As StringBuilder";
_code3 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 286;BA.debugLine="code3.Initialize";
_code3.Initialize();
 //BA.debugLineNum = 287;BA.debugLine="code3.Append(\"// add HTML5 video\").Append(CRLF)";
_code3.Append("// add HTML5 video").Append(__c.CRLF);
 //BA.debugLineNum = 288;BA.debugLine="code3.Append(\"Dim video3 As ABMVideo\").Append(CRL";
_code3.Append("Dim video3 As ABMVideo").Append(__c.CRLF);
 //BA.debugLineNum = 289;BA.debugLine="code3.Append(\"video3.InitializeHTML5(page, \"\"vide";
_code3.Append("video3.InitializeHTML5(page, \"video3\", \"http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4\", True, \"video/mp4\")").Append(__c.CRLF);
 //BA.debugLineNum = 290;BA.debugLine="code3.Append(\"video3.SetFixedSize(320, 200)\").App";
_code3.Append("video3.SetFixedSize(320, 200)").Append(__c.CRLF);
 //BA.debugLineNum = 291;BA.debugLine="code3.Append(\"page.Cell(13,1).AddComponent(video3";
_code3.Append("page.Cell(13,1).AddComponent(video3)").Append(__c.CRLF);
 //BA.debugLineNum = 293;BA.debugLine="page.Cell(17,1).AddComponent(ABMShared.BuildCodeB";
_page.Cell((int) (17),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code3",_code3)));
 //BA.debugLineNum = 296;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 298;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 301;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 303;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 304;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 31;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 33;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 459;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 460;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 461;BA.debugLine="If Action = \"ABMVideo\" Then Return";
if ((_action).equals("ABMVideo")) { 
if (true) return "";};
 //BA.debugLineNum = 462;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 463;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 464;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 465;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 467;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 468;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 469;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 471;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 472;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 68;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 69;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 70;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 71;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 72;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 73;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 74;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 76;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 77;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 78;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 79;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 81;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 83;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 85;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 86;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 87;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 89;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 93;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 474;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 475;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 476;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 477;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 478;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 479;BA.debugLine="End Sub";
return "";
}
public String  _video1b_youtubestatechanged(int _state) throws Exception{
com.ab.abmaterial.ABMButton _btnplay = null;
com.ab.abmaterial.ABMVideo _video = null;
 //BA.debugLineNum = 306;BA.debugLine="Sub video1b_YouTubeStateChanged(State As Int)";
 //BA.debugLineNum = 307;BA.debugLine="Select Case State";
switch (BA.switchObjectToInt(_state,_abm.YOUTUBESTATE_PLAYING,_abm.YOUTUBESTATE_VIDEOCUED)) {
case 0: {
 //BA.debugLineNum = 309;BA.debugLine="IsPlaying = True";
_isplaying = __c.True;
 //BA.debugLineNum = 310;BA.debugLine="Dim btnPlay As ABMButton = page.Component(\"btnP";
_btnplay = (com.ab.abmaterial.ABMButton)(_page.Component("btnPlay"));
 //BA.debugLineNum = 311;BA.debugLine="btnPlay.IconName = \"mdi-av-pause\"";
_btnplay.IconName = "mdi-av-pause";
 //BA.debugLineNum = 312;BA.debugLine="btnPlay.Refresh ' IMPORTANT";
_btnplay.Refresh();
 break; }
case 1: {
 //BA.debugLineNum = 314;BA.debugLine="Dim video As ABMVideo = page.Component(\"video1b";
_video = (com.ab.abmaterial.ABMVideo)(_page.Component("video1b"));
 //BA.debugLineNum = 315;BA.debugLine="video.Play";
_video.Play();
 break; }
default: {
 //BA.debugLineNum = 317;BA.debugLine="If IsPlaying Then";
if (_isplaying) { 
 //BA.debugLineNum = 318;BA.debugLine="IsPlaying = False";
_isplaying = __c.False;
 //BA.debugLineNum = 319;BA.debugLine="Dim btnPlay As ABMButton = page.Component(\"btn";
_btnplay = (com.ab.abmaterial.ABMButton)(_page.Component("btnPlay"));
 //BA.debugLineNum = 320;BA.debugLine="btnPlay.IconName = \"mdi-av-play-arrow\"";
_btnplay.IconName = "mdi-av-play-arrow";
 //BA.debugLineNum = 321;BA.debugLine="btnPlay.Refresh ' IMPORTANT";
_btnplay.Refresh();
 };
 break; }
}
;
 //BA.debugLineNum = 324;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 36;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 37;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 38;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 39;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 40;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 42;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 43;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 44;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 45;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 49;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 50;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 52;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 54;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 57;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 59;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 61;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 65;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
