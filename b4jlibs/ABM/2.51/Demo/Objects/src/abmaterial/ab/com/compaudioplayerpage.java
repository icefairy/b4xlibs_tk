package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compaudioplayerpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compaudioplayerpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compaudioplayerpage.class).invoke(this, new Object[] {null});
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
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 96;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 98;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 101;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 102;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 103;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 104;BA.debugLine="page.PageTitle = \"ABMAudioPlayer\"";
_page.PageTitle = "ABMAudioPlayer";
 //BA.debugLineNum = 105;BA.debugLine="page.PageDescription = \"The audio player componen";
_page.PageDescription = "The audio player component ";
 //BA.debugLineNum = 106;BA.debugLine="page.PageHTMLName = \"abmaterial-audioplayer.html\"";
_page.PageHTMLName = "abmaterial-audioplayer.html";
 //BA.debugLineNum = 107;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 108;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 109;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 110;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 112;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMAudioPlaye";
_abmshared._buildnavigationbar(_page,"ABMAudioPlayer","../images/logo.png","","Controls","ABMAudioPlayer");
 //BA.debugLineNum = 115;BA.debugLine="page.AddRows(8,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (8),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 116;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 121;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompAudioPlayerPage\"";
_name = "CompAudioPlayerPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMAudioPlayer _player1 = null;
com.ab.abmaterial.ABMAudioPlayerSong _song = null;
String _code1 = "";
com.ab.abmaterial.ABMAudioPlayer _player2 = null;
anywheresoftware.b4a.objects.collections.List _playlist = null;
String _code2 = "";
String _code3 = "";
String _code4 = "";
String _code5 = "";
 //BA.debugLineNum = 124;BA.debugLine="public Sub ConnectPage()";
 //BA.debugLineNum = 126;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 129;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","The ABMAudioPlayer component can be used to play mp3 files.  It can also use a playlist.")));
 //BA.debugLineNum = 130;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","You can initalize the player in two modes: narrow or full.  In narrow mode, a playlist is not supported and you can only load one song. Also note that on mobile devices, the autoPlay parameter has no effect!")));
 //BA.debugLineNum = 132;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","LoadSingleSong()")));
 //BA.debugLineNum = 134;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","With this method you can load one single song.  In this example, we also use the narrow version of the player.")));
 //BA.debugLineNum = 136;BA.debugLine="Dim player1 As ABMAudioPlayer";
_player1 = new com.ab.abmaterial.ABMAudioPlayer();
 //BA.debugLineNum = 137;BA.debugLine="player1.Initialize(page, \"player1\", True, True, F";
_player1.Initialize(_page,"player1",__c.True,__c.True,__c.False,"");
 //BA.debugLineNum = 138;BA.debugLine="page.Cell(2,1).AddComponent(player1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_player1));
 //BA.debugLineNum = 140;BA.debugLine="Dim song As ABMAudioPlayerSong";
_song = new com.ab.abmaterial.ABMAudioPlayerSong();
 //BA.debugLineNum = 141;BA.debugLine="song.Initialize(\"../Audio/01 (Open) 00 00.mp3\")";
_song.Initialize("../Audio/01 (Open) 00 00.mp3");
 //BA.debugLineNum = 142;BA.debugLine="song.ImageUrl = \"../Audio/CoverMini.jpg\"";
_song.ImageUrl = "../Audio/CoverMini.jpg";
 //BA.debugLineNum = 143;BA.debugLine="song.Author = \"O∆\"";
_song.Author = "O∆";
 //BA.debugLineNum = 144;BA.debugLine="song.Title = \"(Open) 00 00\"";
_song.Title = "(Open) 00 00";
 //BA.debugLineNum = 146;BA.debugLine="player1.LoadSingleSong(song)";
_player1.LoadSingleSong(_song);
 //BA.debugLineNum = 148;BA.debugLine="Dim code1 As String = $\"Dim player1 As ABMAudioPl";
_code1 = ("Dim player1 As ABMAudioPlayer\n"+"player1.Initialize(page, \"player1\", True, True, False, \"\")\n"+"page.Cell(2,1).AddComponent(player1)\n"+"	\n"+"Dim song As ABMAudioPlayerSong\n"+"song.Initialize(\"../Audio/01 (Open) 00 00.mp3\")\n"+"song.ImageUrl = \"../Audio/CoverMini.jpg\"\n"+"song.Author = \"O∆\"\n"+"song.Title = \"(Open) 00 00\"\n"+"	\n"+"player1.LoadSingleSong(song)");
 //BA.debugLineNum = 160;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code1)));
 //BA.debugLineNum = 163;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr2","LoadPlaylist()")));
 //BA.debugLineNum = 165;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","With this method you can load a complete playlist (like an album). For this example we need to use the full version.")));
 //BA.debugLineNum = 167;BA.debugLine="Dim player2 As ABMAudioPlayer";
_player2 = new com.ab.abmaterial.ABMAudioPlayer();
 //BA.debugLineNum = 168;BA.debugLine="player2.Initialize(page, \"player2\", False, True,";
_player2.Initialize(_page,"player2",__c.False,__c.True,__c.False,"");
 //BA.debugLineNum = 169;BA.debugLine="page.Cell(5,1).AddComponent(player2)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_player2));
 //BA.debugLineNum = 171;BA.debugLine="Dim playlist As List";
_playlist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 172;BA.debugLine="playlist.Initialize";
_playlist.Initialize();
 //BA.debugLineNum = 173;BA.debugLine="playlist.Add(loadSong(\"01 (Open) 00 00\"))";
_playlist.Add((Object)(_loadsong("01 (Open) 00 00")));
 //BA.debugLineNum = 174;BA.debugLine="playlist.Add(loadSong(\"02 OATMEAL\"))";
_playlist.Add((Object)(_loadsong("02 OATMEAL")));
 //BA.debugLineNum = 175;BA.debugLine="playlist.Add(loadSong(\"03 NATURAL\"))";
_playlist.Add((Object)(_loadsong("03 NATURAL")));
 //BA.debugLineNum = 176;BA.debugLine="playlist.Add(loadSong(\"04 Steal\"))";
_playlist.Add((Object)(_loadsong("04 Steal")));
 //BA.debugLineNum = 177;BA.debugLine="playlist.Add(loadSong(\"05 Nobody Hangs Out Anymor";
_playlist.Add((Object)(_loadsong("05 Nobody Hangs Out Anymore")));
 //BA.debugLineNum = 178;BA.debugLine="playlist.Add(loadSong(\"06 GUTS\"))";
_playlist.Add((Object)(_loadsong("06 GUTS")));
 //BA.debugLineNum = 179;BA.debugLine="playlist.Add(loadSong(\"07 Coordinates 00 36\"))";
_playlist.Add((Object)(_loadsong("07 Coordinates 00 36")));
 //BA.debugLineNum = 180;BA.debugLine="playlist.Add(loadSong(\"08 Love Song\"))";
_playlist.Add((Object)(_loadsong("08 Love Song")));
 //BA.debugLineNum = 181;BA.debugLine="playlist.Add(loadSong(\"09 09 87 (Where is your Ho";
_playlist.Add((Object)(_loadsong("09 09 87 (Where is your Home)")));
 //BA.debugLineNum = 182;BA.debugLine="playlist.Add(loadSong(\"10 SURVIVE\"))";
_playlist.Add((Object)(_loadsong("10 SURVIVE")));
 //BA.debugLineNum = 184;BA.debugLine="player2.LoadPlaylist(playlist)";
_player2.LoadPlaylist(_playlist);
 //BA.debugLineNum = 186;BA.debugLine="Dim Code2 As String = $\"Dim player2 As ABMAudioPl";
_code2 = ("Dim player2 As ABMAudioPlayer\n"+"player2.Initialize(page, \"player2\", False, True, False, \"\")\n"+"page.Cell(5,1).AddComponent(player2)\n"+"	\n"+"Dim playlist As List\n"+"playlist.Initialize\n"+"playlist.Add(loadSong(\"01 (Open) 00 00\"))\n"+"playlist.Add(loadSong(\"02 OATMEAL\"))\n"+"playlist.Add(loadSong(\"03 NATURAL\"))\n"+"playlist.Add(loadSong(\"04 Steal\"))\n"+"playlist.Add(loadSong(\"05 Nobody Hangs Out Anymore\"))\n"+"playlist.Add(loadSong(\"06 GUTS\"))\n"+"playlist.Add(loadSong(\"07 Coordinates 00 36\"))\n"+"playlist.Add(loadSong(\"08 Love Song\"))\n"+"playlist.Add(loadSong(\"09 09 87 (Where is your Home)\"))\n"+"playlist.Add(loadSong(\"10 SURVIVE\"))\n"+"		\n"+"player2.LoadPlaylist(playlist)");
 //BA.debugLineNum = 205;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code2",_code2)));
 //BA.debugLineNum = 207;BA.debugLine="Dim Code3 As String = $\"Sub loadSong(Title As Str";
_code3 = ("Sub loadSong(Title As String) As ABMAudioPlayerSong\n"+"	Dim song As ABMAudioPlayerSong\n"+"	song.Initialize(\"../Audio/\" & Title & \".mp3\")\n"+"	song.ImageUrl = \"../Audio/CoverMini.jpg\"\n"+"	song.Author = \"O∆\"\n"+"	song.Title = Title\n"+"	Return song\n"+"End Sub");
 //BA.debugLineNum = 216;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code3",_code3)));
 //BA.debugLineNum = 220;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr2","Lyrics")));
 //BA.debugLineNum = 222;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","You can load Lyrics with the song if you want (full modus). It is a smple list of strings, but they have to be in a certain format. (Take special note to the time prefix: {B}[00:00.00]{/B}. Full specs of the lyrics format can be found here: {AL}https://en.wikipedia.org/wiki/LRC_(file_format){AT}LRC format{/AL}")));
 //BA.debugLineNum = 224;BA.debugLine="Dim Code4 As String = $\"Dim song As ABMAudioPlaye";
_code4 = ("Dim song As ABMAudioPlayerSong = loadSong(\"02 OATMEAL\")\n"+"song.Lyrics.AddAll(LoadLyrics)\n"+"playlist.add(song)");
 //BA.debugLineNum = 228;BA.debugLine="page.Cell(8,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code4",_code4)));
 //BA.debugLineNum = 230;BA.debugLine="Dim Code5 As String = $\"Sub LoadLyrics() As List";
_code5 = ("Sub LoadLyrics() As List\n"+"	Dim l As List\n"+"	l.Initialize\n"+"	\n"+"	l.Add(\"[ar:Beatles]\")\n"+"	l.Add(\"[ti:Hello goodbye]\")\n"+"	l.Add(\"[la:uk]\")\n"+"	l.Add(\"[00:00.00]You say yes, I say no.\")\n"+"	l.Add(\"[00:04.00]You say stop And I say go go go, oh no.\")\n"+"	l.Add(\"[00:17.00]You say goodbye And I say hello\")\n"+"	l.Add(\"[00:22.00]Hello hello\")\n"+"	l.Add(\"[00:25.00]I don't know why you say goodbye, Isay hello\")\n"+"	l.Add(\"[00:30.00]Hello hello\")\n"+"	l.Add(\"[00:32.00]I don't know why you say goodbye, I say hello.\")\n"+"	l.Add(\"[00:38.00]I say high, you say low.\")\n"+"	l.Add(\"[00:42.00]You say why And I say I don't know, oh no.\")\n"+"	l.Add(\"[00:55.00]You say goodbye And I say hello\")\n"+"	l.Add(\"[00:59.00]HELLO GOODBYE HELLO GOODBYE hello hello\")\n"+"	l.Add(\"[01:02.00]HELLO GOODBYE I don't know why you say goodbye, I say hello\")\n"+"	l.Add(\"[01:06.00]HELLO GOODBYE HELLO GOODBYE hello hello\")\n"+"	l.Add(\"[01:09.00]HELLO GOODBYE I don't know why you say goodbye\")\n"+"	l.Add(\"[01:12.00]HELLO GOODBYE I say goodbye.\")\n"+"	l.Add(\"[01:20.00]Why why why why why why Do you say goodbye goodbye, oh no?\")\n"+"	l.Add(\"[01:32.00]You say goodbye And I say hello\")\n"+"	l.Add(\"[01:38.00]Hello hello\")\n"+"	l.Add(\"[01:40.00]I don't know why you say goodbye, I say hello\")\n"+"	l.Add(\"[01:45.00]Hello hello\")\n"+"	l.Add(\"[01:47.00]I don't know why you say goodbye, I say hello.\")\n"+"	l.Add(\"[01:53.00]You say yes I SAY YES I say no BUT I MAY MEAN NO.\")\n"+"	l.Add(\"[01:58.00]You say stop I CAN STAY And I say go go go TILL IT'S TIME TO GO OH, oh no.\")\n"+"	l.Add(\"[02:10.00]You say goodbye And I say hello\")\n"+"	l.Add(\"[02:15.00]Hello hello\")\n"+"	l.Add(\"[02:17.00]I don't know why you say goodbye, I say hello\")\n"+"	l.Add(\"[02:22.00]Hello hello\")\n"+"	l.Add(\"[02:24.00]I don't know why you say goodbye, I say hello\")\n"+"	l.Add(\"[02:29.00]Hello hello\")\n"+"	l.Add(\"[02:32.00]I don't know why you say goodbye, I say hello hello.\")\n"+"	l.Add(\"[02:45.00]Hela heba helloa CHA CHA.................\")\n"+"	\n"+"	Return l\n"+"End Sub");
 //BA.debugLineNum = 272;BA.debugLine="page.Cell(8,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code5",_code5)));
 //BA.debugLineNum = 275;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 277;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 280;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 282;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 283;BA.debugLine="End Sub";
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
public anywheresoftware.b4a.objects.collections.List  _loadlyrics() throws Exception{
anywheresoftware.b4a.objects.collections.List _l = null;
 //BA.debugLineNum = 318;BA.debugLine="Sub LoadLyrics() As List 'ignore";
 //BA.debugLineNum = 319;BA.debugLine="Dim l As List";
_l = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 320;BA.debugLine="l.Initialize";
_l.Initialize();
 //BA.debugLineNum = 322;BA.debugLine="l.Add(\"[ar:Beatles]\")";
_l.Add((Object)("[ar:Beatles]"));
 //BA.debugLineNum = 323;BA.debugLine="l.Add(\"[ti:Hello goodbye]\")";
_l.Add((Object)("[ti:Hello goodbye]"));
 //BA.debugLineNum = 324;BA.debugLine="l.Add(\"[la:uk]\")";
_l.Add((Object)("[la:uk]"));
 //BA.debugLineNum = 325;BA.debugLine="l.Add(\"[00:00.00]You say yes, I say no.\")";
_l.Add((Object)("[00:00.00]You say yes, I say no."));
 //BA.debugLineNum = 326;BA.debugLine="l.Add(\"[00:04.00]You say stop And I say go go go,";
_l.Add((Object)("[00:04.00]You say stop And I say go go go, oh no."));
 //BA.debugLineNum = 327;BA.debugLine="l.Add(\"[00:17.00]You say goodbye And I say hello\"";
_l.Add((Object)("[00:17.00]You say goodbye And I say hello"));
 //BA.debugLineNum = 328;BA.debugLine="l.Add(\"[00:22.00]Hello hello\")";
_l.Add((Object)("[00:22.00]Hello hello"));
 //BA.debugLineNum = 329;BA.debugLine="l.Add(\"[00:25.00]I don't know why you say goodbye";
_l.Add((Object)("[00:25.00]I don't know why you say goodbye, Isay hello"));
 //BA.debugLineNum = 330;BA.debugLine="l.Add(\"[00:30.00]Hello hello\")";
_l.Add((Object)("[00:30.00]Hello hello"));
 //BA.debugLineNum = 331;BA.debugLine="l.Add(\"[00:32.00]I don't know why you say goodbye";
_l.Add((Object)("[00:32.00]I don't know why you say goodbye, I say hello."));
 //BA.debugLineNum = 332;BA.debugLine="l.Add(\"[00:38.00]I say high, you say low.\")";
_l.Add((Object)("[00:38.00]I say high, you say low."));
 //BA.debugLineNum = 333;BA.debugLine="l.Add(\"[00:42.00]You say why And I say I don't kn";
_l.Add((Object)("[00:42.00]You say why And I say I don't know, oh no."));
 //BA.debugLineNum = 334;BA.debugLine="l.Add(\"[00:55.00]You say goodbye And I say hello\"";
_l.Add((Object)("[00:55.00]You say goodbye And I say hello"));
 //BA.debugLineNum = 335;BA.debugLine="l.Add(\"[00:59.00]HELLO GOODBYE HELLO GOODBYE hell";
_l.Add((Object)("[00:59.00]HELLO GOODBYE HELLO GOODBYE hello hello"));
 //BA.debugLineNum = 336;BA.debugLine="l.Add(\"[01:02.00]HELLO GOODBYE I don't know why y";
_l.Add((Object)("[01:02.00]HELLO GOODBYE I don't know why you say goodbye, I say hello"));
 //BA.debugLineNum = 337;BA.debugLine="l.Add(\"[01:06.00]HELLO GOODBYE HELLO GOODBYE hell";
_l.Add((Object)("[01:06.00]HELLO GOODBYE HELLO GOODBYE hello hello"));
 //BA.debugLineNum = 338;BA.debugLine="l.Add(\"[01:09.00]HELLO GOODBYE I don't know why y";
_l.Add((Object)("[01:09.00]HELLO GOODBYE I don't know why you say goodbye"));
 //BA.debugLineNum = 339;BA.debugLine="l.Add(\"[01:12.00]HELLO GOODBYE I say goodbye.\")";
_l.Add((Object)("[01:12.00]HELLO GOODBYE I say goodbye."));
 //BA.debugLineNum = 340;BA.debugLine="l.Add(\"[01:20.00]Why why why why why why Do you s";
_l.Add((Object)("[01:20.00]Why why why why why why Do you say goodbye goodbye, oh no?"));
 //BA.debugLineNum = 341;BA.debugLine="l.Add(\"[01:32.00]You say goodbye And I say hello\"";
_l.Add((Object)("[01:32.00]You say goodbye And I say hello"));
 //BA.debugLineNum = 342;BA.debugLine="l.Add(\"[01:38.00]Hello hello\")";
_l.Add((Object)("[01:38.00]Hello hello"));
 //BA.debugLineNum = 343;BA.debugLine="l.Add(\"[01:40.00]I don't know why you say goodbye";
_l.Add((Object)("[01:40.00]I don't know why you say goodbye, I say hello"));
 //BA.debugLineNum = 344;BA.debugLine="l.Add(\"[01:45.00]Hello hello\")";
_l.Add((Object)("[01:45.00]Hello hello"));
 //BA.debugLineNum = 345;BA.debugLine="l.Add(\"[01:47.00]I don't know why you say goodbye";
_l.Add((Object)("[01:47.00]I don't know why you say goodbye, I say hello."));
 //BA.debugLineNum = 346;BA.debugLine="l.Add(\"[01:53.00]You say yes I SAY YES I say no B";
_l.Add((Object)("[01:53.00]You say yes I SAY YES I say no BUT I MAY MEAN NO."));
 //BA.debugLineNum = 347;BA.debugLine="l.Add(\"[01:58.00]You say stop I CAN STAY And I sa";
_l.Add((Object)("[01:58.00]You say stop I CAN STAY And I say go go go TILL IT'S TIME TO GO OH, oh no."));
 //BA.debugLineNum = 348;BA.debugLine="l.Add(\"[02:10.00]You say goodbye And I say hello\"";
_l.Add((Object)("[02:10.00]You say goodbye And I say hello"));
 //BA.debugLineNum = 349;BA.debugLine="l.Add(\"[02:15.00]Hello hello\")";
_l.Add((Object)("[02:15.00]Hello hello"));
 //BA.debugLineNum = 350;BA.debugLine="l.Add(\"[02:17.00]I don't know why you say goodbye";
_l.Add((Object)("[02:17.00]I don't know why you say goodbye, I say hello"));
 //BA.debugLineNum = 351;BA.debugLine="l.Add(\"[02:22.00]Hello hello\")";
_l.Add((Object)("[02:22.00]Hello hello"));
 //BA.debugLineNum = 352;BA.debugLine="l.Add(\"[02:24.00]I don't know why you say goodbye";
_l.Add((Object)("[02:24.00]I don't know why you say goodbye, I say hello"));
 //BA.debugLineNum = 353;BA.debugLine="l.Add(\"[02:29.00]Hello hello\")";
_l.Add((Object)("[02:29.00]Hello hello"));
 //BA.debugLineNum = 354;BA.debugLine="l.Add(\"[02:32.00]I don't know why you say goodbye";
_l.Add((Object)("[02:32.00]I don't know why you say goodbye, I say hello hello."));
 //BA.debugLineNum = 355;BA.debugLine="l.Add(\"[02:45.00]Hela heba helloa CHA CHA........";
_l.Add((Object)("[02:45.00]Hela heba helloa CHA CHA................."));
 //BA.debugLineNum = 357;BA.debugLine="Return l";
if (true) return _l;
 //BA.debugLineNum = 358;BA.debugLine="End Sub";
return null;
}
public com.ab.abmaterial.ABMAudioPlayerSong  _loadsong(String _title) throws Exception{
com.ab.abmaterial.ABMAudioPlayerSong _song = null;
 //BA.debugLineNum = 309;BA.debugLine="Sub loadSong(Title As String) As ABMAudioPlayerSon";
 //BA.debugLineNum = 310;BA.debugLine="Dim song As ABMAudioPlayerSong";
_song = new com.ab.abmaterial.ABMAudioPlayerSong();
 //BA.debugLineNum = 311;BA.debugLine="song.Initialize(\"../Audio/\" & Title & \".mp3\")";
_song.Initialize("../Audio/"+_title+".mp3");
 //BA.debugLineNum = 312;BA.debugLine="song.ImageUrl = \"../Audio/CoverMini.jpg\"";
_song.ImageUrl = "../Audio/CoverMini.jpg";
 //BA.debugLineNum = 313;BA.debugLine="song.Author = \"O∆\"";
_song.Author = "O∆";
 //BA.debugLineNum = 314;BA.debugLine="song.Title = Title";
_song.Title = _title;
 //BA.debugLineNum = 315;BA.debugLine="Return song";
if (true) return _song;
 //BA.debugLineNum = 316;BA.debugLine="End Sub";
return null;
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 286;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 287;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 288;BA.debugLine="If Action = \"ABMAudioPlayer\" Then Return";
if ((_action).equals("ABMAudioPlayer")) { 
if (true) return "";};
 //BA.debugLineNum = 289;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 290;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 291;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 292;BA.debugLine="Log(ws.Session.GetAttribute(\"test\"))";
__c.Log(BA.ObjectToString(_ws.getSession().GetAttribute("test")));
 //BA.debugLineNum = 293;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 295;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 296;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 297;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 299;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 300;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 302;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 303;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 304;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 305;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 306;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 307;BA.debugLine="End Sub";
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
