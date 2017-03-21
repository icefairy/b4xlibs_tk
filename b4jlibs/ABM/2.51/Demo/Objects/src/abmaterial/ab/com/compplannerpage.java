package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compplannerpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compplannerpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compplannerpage.class).invoke(this, new Object[] {null});
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
public anywheresoftware.b4a.objects.collections.List _firstnames = null;
public anywheresoftware.b4a.objects.collections.List _lastnames = null;
public long _firstdate = 0L;
public String _cuttaskid = "";
public com.ab.abmaterial.ABMPlannerTask _copytask = null;
public boolean _iscut = false;
public int _counter = 0;
public int _mytoastid = 0;
public int _activeday = 0;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _buildpage() throws Exception{
com.ab.abmaterial.ABMButton _prevweek = null;
com.ab.abmaterial.ABMDateTimePicker _mydate3 = null;
long _newdate = 0L;
com.ab.abmaterial.ABMButton _nextweek = null;
com.ab.abmaterial.ABMPlanner _plan = null;
 //BA.debugLineNum = 125;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 127;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 130;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 131;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 132;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 133;BA.debugLine="page.PageTitle = \"ABMPlannert\"";
_page.PageTitle = "ABMPlannert";
 //BA.debugLineNum = 134;BA.debugLine="page.PageDescription = \"The planner component \"";
_page.PageDescription = "The planner component ";
 //BA.debugLineNum = 135;BA.debugLine="page.PageHTMLName = \"abmaterial-planner.html\"";
_page.PageHTMLName = "abmaterial-planner.html";
 //BA.debugLineNum = 136;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 137;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 138;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 139;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 141;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMPlanner\",";
_abmshared._buildnavigationbar(_page,"ABMPlanner","../images/logo.png","","Controls","ABMPlanner");
 //BA.debugLineNum = 144;BA.debugLine="page.AddRows(1,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 145;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOSMP(1,0,0,0,2,2";
_page.AddRows((int) (1),__c.True,"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (2),(int) (2),(int) (1),(int) (18),(int) (0),(int) (0),(int) (0),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (8),(int) (8),(int) (10),(int) (0),(int) (0),(int) (0),(int) (0),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (2),(int) (2),(int) (1),(int) (18),(int) (0),(int) (0),(int) (0),"");
 //BA.debugLineNum = 146;BA.debugLine="page.AddRows(1,False, \"\").AddCells12MP(1,0,0,10,1";
_page.AddRows((int) (1),__c.False,"").AddCells12MP((int) (1),(int) (0),(int) (0),(int) (10),(int) (10),"");
 //BA.debugLineNum = 147;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 149;BA.debugLine="page.Cell(2,1).UseTheme(\"center\")";
_page.Cell((int) (2),(int) (1)).UseTheme("center");
 //BA.debugLineNum = 150;BA.debugLine="page.Cell(2,3).UseTheme(\"center\")";
_page.Cell((int) (2),(int) (3)).UseTheme("center");
 //BA.debugLineNum = 152;BA.debugLine="page.Cell(3,1).SetFixedHeightFromBottom(50,True)";
_page.Cell((int) (3),(int) (1)).SetFixedHeightFromBottom((int) (50),__c.True);
 //BA.debugLineNum = 154;BA.debugLine="Dim prevWeek As ABMButton";
_prevweek = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 155;BA.debugLine="prevWeek.InitializeFloating(page, \"prevWeek\", \"md";
_prevweek.InitializeFloating(_page,"prevWeek","mdi-av-skip-previous","");
 //BA.debugLineNum = 156;BA.debugLine="page.Cell(2,1).AddComponent(prevWeek)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_prevweek));
 //BA.debugLineNum = 158;BA.debugLine="Dim mydate3 As ABMDateTimePicker";
_mydate3 = new com.ab.abmaterial.ABMDateTimePicker();
 //BA.debugLineNum = 159;BA.debugLine="Dim NewDate As Long = DateTime.Now";
_newdate = __c.DateTime.getNow();
 //BA.debugLineNum = 160;BA.debugLine="mydate3.Initialize(page, \"mydate3\", ABM.DATETI";
_mydate3.Initialize(_page,"mydate3",_abm.DATETIMEPICKER_TYPE_WEEK,_newdate,"Pick a week","");
 //BA.debugLineNum = 161;BA.debugLine="mydate3.CancelText = \"Back\"";
_mydate3.CancelText = "Back";
 //BA.debugLineNum = 162;BA.debugLine="mydate3.PickText = \"OK\"";
_mydate3.PickText = "OK";
 //BA.debugLineNum = 163;BA.debugLine="mydate3.TodayText = \"This week\"";
_mydate3.TodayText = "This week";
 //BA.debugLineNum = 164;BA.debugLine="mydate3.Language = \"en\"";
_mydate3.Language = "en";
 //BA.debugLineNum = 165;BA.debugLine="mydate3.ReturnDateFormat = \"MM/DD/YYYY\"   ' <---";
_mydate3.ReturnDateFormat = "MM/DD/YYYY";
 //BA.debugLineNum = 166;BA.debugLine="mydate3.ReturnTimeFormat = \"\" ' <--- see demo";
_mydate3.ReturnTimeFormat = "";
 //BA.debugLineNum = 167;BA.debugLine="mydate3.FirstDayOfWeek = 1";
_mydate3.FirstDayOfWeek = (int) (1);
 //BA.debugLineNum = 168;BA.debugLine="mydate3.WeekText = \"Week\"";
_mydate3.WeekText = "Week";
 //BA.debugLineNum = 169;BA.debugLine="mydate3.ClickThrough = True";
_mydate3.ClickThrough = __c.True;
 //BA.debugLineNum = 170;BA.debugLine="mydate3.IsTextSelectable = False";
_mydate3.IsTextSelectable = __c.False;
 //BA.debugLineNum = 171;BA.debugLine="page.Cell(2,2).AddComponent(mydate3) '    <---";
_page.Cell((int) (2),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_mydate3));
 //BA.debugLineNum = 173;BA.debugLine="Dim nextWeek As ABMButton";
_nextweek = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 174;BA.debugLine="nextWeek.InitializeFloating(page, \"nextWeek\", \"md";
_nextweek.InitializeFloating(_page,"nextWeek","mdi-av-skip-next","");
 //BA.debugLineNum = 175;BA.debugLine="page.Cell(2,3).AddComponent(nextWeek)";
_page.Cell((int) (2),(int) (3)).AddComponent((com.ab.abmaterial.ABMComponent)(_nextweek));
 //BA.debugLineNum = 177;BA.debugLine="Dim plan As ABMPlanner";
_plan = new com.ab.abmaterial.ABMPlanner();
 //BA.debugLineNum = 178;BA.debugLine="plan.Initialize(page, \"plan\", True, 6,20, 5, Fals";
_plan.Initialize(_page,"plan",__c.True,(int) (6),(int) (20),(int) (5),__c.False,"demo");
 //BA.debugLineNum = 179;BA.debugLine="plan.UseHeatMap(\"1,3,6\")";
_plan.UseHeatMap("1,3,6");
 //BA.debugLineNum = 180;BA.debugLine="page.Cell(3,1).AddComponent(plan)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_plan));
 //BA.debugLineNum = 182;BA.debugLine="FirstNames.Initialize2(Array As String(\"Alain\", \"";
_firstnames.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Alain","Jos","Paul","Bertrande","Julie","Stephanie","Bert","Charles","James","Walter","Carine","Geert","Kristof","Christophe","Filip","Irene","Gilbert","Walter","Bert","Bart"}));
 //BA.debugLineNum = 183;BA.debugLine="LastNames.Initialize2(Array As String(\"Bailleul\",";
_lastnames.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Bailleul","Rogiers","Dougherty","Rodrigues","Ostrander","Kenyon","Grant","Klinger","Sheffield","Poindexter","Casier","Lacour","Matton","Desomer","Creus","Parmentier","Tiberhein","Declercq","Verfaille","Gadeyne"}));
 //BA.debugLineNum = 186;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 187;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 97;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 99;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 100;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 103;BA.debugLine="theme.AddPlannerTheme(\"demo\")";
_theme.AddPlannerTheme("demo");
 //BA.debugLineNum = 104;BA.debugLine="theme.Planner(\"demo\").MenuColor = ABM.COLOR_LIME";
_theme.Planner("demo").MenuColor = _abm.COLOR_LIME;
 //BA.debugLineNum = 105;BA.debugLine="theme.Planner(\"demo\").MenuColorIntensity = ABM.IN";
_theme.Planner("demo").MenuColorIntensity = _abm.INTENSITY_DARKEN3;
 //BA.debugLineNum = 106;BA.debugLine="theme.Planner(\"demo\").HourColor = ABM.COLOR_GREY";
_theme.Planner("demo").HourColor = _abm.COLOR_GREY;
 //BA.debugLineNum = 107;BA.debugLine="theme.Planner(\"demo\").HourColorIntensity = ABM.IN";
_theme.Planner("demo").HourColorIntensity = _abm.INTENSITY_LIGHTEN2;
 //BA.debugLineNum = 108;BA.debugLine="theme.Planner(\"demo\").HourTextColor = ABM.COLOR_B";
_theme.Planner("demo").HourTextColor = _abm.COLOR_BLACK;
 //BA.debugLineNum = 109;BA.debugLine="theme.Planner(\"demo\").HourAltColor = ABM.COLOR_GR";
_theme.Planner("demo").HourAltColor = _abm.COLOR_GREY;
 //BA.debugLineNum = 110;BA.debugLine="theme.Planner(\"demo\").HourAltTextColor = ABM.COLO";
_theme.Planner("demo").HourAltTextColor = _abm.COLOR_BLACK;
 //BA.debugLineNum = 111;BA.debugLine="theme.Planner(\"demo\").HourMinutesUsedColors(0,ABM";
_theme.Planner("demo").HourMinutesUsedColors((int) (0),_abm.COLOR_BLUEGREY);
 //BA.debugLineNum = 112;BA.debugLine="theme.Planner(\"demo\").HourMinutesUsedColorsIntens";
_theme.Planner("demo").HourMinutesUsedColorsIntensity((int) (0),_abm.INTENSITY_DARKEN4);
 //BA.debugLineNum = 113;BA.debugLine="theme.Planner(\"demo\").HourMinutesUsedColors(1,ABM";
_theme.Planner("demo").HourMinutesUsedColors((int) (1),_abm.COLOR_BLUEGREY);
 //BA.debugLineNum = 114;BA.debugLine="theme.Planner(\"demo\").HourMinutesUsedColorsIntens";
_theme.Planner("demo").HourMinutesUsedColorsIntensity((int) (1),_abm.INTENSITY_DARKEN2);
 //BA.debugLineNum = 115;BA.debugLine="theme.Planner(\"demo\").HourMinutesUsedColors(2,ABM";
_theme.Planner("demo").HourMinutesUsedColors((int) (2),_abm.COLOR_BLUEGREY);
 //BA.debugLineNum = 116;BA.debugLine="theme.Planner(\"demo\").HourMinutesUsedColorsIntens";
_theme.Planner("demo").HourMinutesUsedColorsIntensity((int) (2),_abm.INTENSITY_NORMAL);
 //BA.debugLineNum = 117;BA.debugLine="theme.Planner(\"demo\").HourMinutesUsedColors(3,ABM";
_theme.Planner("demo").HourMinutesUsedColors((int) (3),_abm.COLOR_BLUEGREY);
 //BA.debugLineNum = 118;BA.debugLine="theme.Planner(\"demo\").HourMinutesUsedColorsIntens";
_theme.Planner("demo").HourMinutesUsedColorsIntensity((int) (3),_abm.INTENSITY_LIGHTEN2);
 //BA.debugLineNum = 119;BA.debugLine="theme.Planner(\"demo\").HourMinutesNotAvailableColo";
_theme.Planner("demo").HourMinutesNotAvailableColorIntensity = _abm.INTENSITY_DARKEN3;
 //BA.debugLineNum = 121;BA.debugLine="theme.AddCellTheme(\"center\")";
_theme.AddCellTheme("center");
 //BA.debugLineNum = 122;BA.debugLine="theme.Cell(\"center\").Align = ABM.CELL_ALIGN_CENTE";
_theme.Cell("center").Align = _abm.CELL_ALIGN_CENTER;
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompPlannerPage\"";
_name = "CompPlannerPage";
 //BA.debugLineNum = 12;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 15;BA.debugLine="Dim FirstNames As List";
_firstnames = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 16;BA.debugLine="Dim LastNames As List";
_lastnames = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 17;BA.debugLine="Dim FirstDate As Long";
_firstdate = 0L;
 //BA.debugLineNum = 19;BA.debugLine="Dim cutTaskID As String";
_cuttaskid = "";
 //BA.debugLineNum = 20;BA.debugLine="Dim copyTask As ABMPlannerTask";
_copytask = new com.ab.abmaterial.ABMPlannerTask();
 //BA.debugLineNum = 21;BA.debugLine="Dim IsCut As Boolean";
_iscut = false;
 //BA.debugLineNum = 22;BA.debugLine="Dim counter As Int";
_counter = 0;
 //BA.debugLineNum = 24;BA.debugLine="Dim myToastID As Int";
_mytoastid = 0;
 //BA.debugLineNum = 25;BA.debugLine="Dim ActiveDay As Int = -1";
_activeday = (int) (-1);
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMDateTimePicker _mydate3 = null;
String[] _spl = null;
 //BA.debugLineNum = 189;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 191;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 194;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","ABMPlanner is a scheduling component.  In the demo, Long Tap on the minutes to the open the action menu.")));
 //BA.debugLineNum = 195;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","Note that in this demo the tasks are random, so changing weeks will always result in another schedule!")));
 //BA.debugLineNum = 198;BA.debugLine="Dim mydate3 As ABMDateTimePicker = page.Component";
_mydate3 = (com.ab.abmaterial.ABMDateTimePicker)(_page.Component("mydate3"));
 //BA.debugLineNum = 199;BA.debugLine="Dim spl() As String = Regex.Split(\";\",mydate3.Get";
_spl = __c.Regex.Split(";",_mydate3.GetDateWeek());
 //BA.debugLineNum = 200;BA.debugLine="FirstDate = spl(1)";
_firstdate = (long)(Double.parseDouble(_spl[(int) (1)]));
 //BA.debugLineNum = 201;BA.debugLine="LoadRandomWeek(FirstDate, False)";
_loadrandomweek(_firstdate,__c.False);
 //BA.debugLineNum = 204;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 206;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 209;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 211;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 212;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 30;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 32;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public String  _loadrandomweek(long _startday,boolean _dorefresh) throws Exception{
com.ab.abmaterial.ABMPlanner _plan = null;
String[] _days = null;
int _day = 0;
long _nextday = 0L;
b4j.example.dateutils._period _pernext = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.List _mins = null;
int _pertotal = 0;
int _u = 0;
int _m = 0;
int _l = 0;
int _lindex = 0;
String _patient = "";
 //BA.debugLineNum = 369;BA.debugLine="Sub LoadRandomWeek(StartDay As Long,doRefresh As B";
 //BA.debugLineNum = 370;BA.debugLine="Dim plan As ABMPlanner = page.Component(\"plan\")";
_plan = (com.ab.abmaterial.ABMPlanner)(_page.Component("plan"));
 //BA.debugLineNum = 371;BA.debugLine="plan.ClearPlanner";
_plan.ClearPlanner();
 //BA.debugLineNum = 373;BA.debugLine="Dim Days(7) As String";
_days = new String[(int) (7)];
java.util.Arrays.fill(_days,"");
 //BA.debugLineNum = 374;BA.debugLine="Dim Day As Int = DateTime.GetDayOfMonth(StartDay)";
_day = __c.DateTime.GetDayOfMonth(_startday);
 //BA.debugLineNum = 375;BA.debugLine="Dim nextDay As Long = StartDay";
_nextday = _startday;
 //BA.debugLineNum = 376;BA.debugLine="Dim perNext As Period";
_pernext = new b4j.example.dateutils._period();
 //BA.debugLineNum = 377;BA.debugLine="perNext.Initialize";
_pernext.Initialize();
 //BA.debugLineNum = 378;BA.debugLine="perNext.Days = 1";
_pernext.Days = (int) (1);
 //BA.debugLineNum = 379;BA.debugLine="For i = 0 To 6";
{
final int step9 = 1;
final int limit9 = (int) (6);
for (_i = (int) (0) ; (step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9); _i = ((int)(0 + _i + step9)) ) {
 //BA.debugLineNum = 380;BA.debugLine="If ActiveDay = -1 Then";
if (_activeday==-1) { 
 //BA.debugLineNum = 381;BA.debugLine="If DateTime.Date(nextDay) = DateTime.Date(DateT";
if ((__c.DateTime.Date(_nextday)).equals(__c.DateTime.Date(__c.DateTime.getNow()))) { 
 //BA.debugLineNum = 382;BA.debugLine="ActiveDay = i";
_activeday = _i;
 };
 };
 //BA.debugLineNum = 385;BA.debugLine="Days(i)	= Day";
_days[_i] = BA.NumberToString(_day);
 //BA.debugLineNum = 386;BA.debugLine="If Days(i).Length = 1 Then";
if (_days[_i].length()==1) { 
 //BA.debugLineNum = 387;BA.debugLine="Days(i) = \"0\" & Days(i)";
_days[_i] = "0"+_days[_i];
 };
 //BA.debugLineNum = 389;BA.debugLine="nextDay = DateUtils.AddPeriod(nextDay, perNext)";
_nextday = _dateutils._addperiod(_nextday,_pernext);
 //BA.debugLineNum = 390;BA.debugLine="Day = DateTime.GetDayOfMonth(nextDay)";
_day = __c.DateTime.GetDayOfMonth(_nextday);
 }
};
 //BA.debugLineNum = 393;BA.debugLine="If ActiveDay = -1 Then ActiveDay = 0";
if (_activeday==-1) { 
_activeday = (int) (0);};
 //BA.debugLineNum = 395;BA.debugLine="Dim mins As List";
_mins = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 396;BA.debugLine="mins.Initialize";
_mins.Initialize();
 //BA.debugLineNum = 397;BA.debugLine="mins.Add(1)";
_mins.Add((Object)(1));
 //BA.debugLineNum = 398;BA.debugLine="mins.Add(3)";
_mins.Add((Object)(3));
 //BA.debugLineNum = 399;BA.debugLine="mins.Add(6)";
_mins.Add((Object)(6));
 //BA.debugLineNum = 400;BA.debugLine="mins.Add(12)";
_mins.Add((Object)(12));
 //BA.debugLineNum = 401;BA.debugLine="plan.SetDayLabels(\"MO \" & Days(0), \"TU \" & Days(1";
_plan.SetDayLabels("MO "+_days[(int) (0)],"TU "+_days[(int) (1)],"WE "+_days[(int) (2)],"TH "+_days[(int) (3)],"FR "+_days[(int) (4)],"SA "+_days[(int) (5)],"SU "+_days[(int) (6)]);
 //BA.debugLineNum = 402;BA.debugLine="Dim PerTotal As Int = 12";
_pertotal = (int) (12);
 //BA.debugLineNum = 404;BA.debugLine="For i = 0 To 4";
{
final int step31 = 1;
final int limit31 = (int) (4);
for (_i = (int) (0) ; (step31 > 0 && _i <= limit31) || (step31 < 0 && _i >= limit31); _i = ((int)(0 + _i + step31)) ) {
 //BA.debugLineNum = 405;BA.debugLine="Dim u As Int = 6";
_u = (int) (6);
 //BA.debugLineNum = 406;BA.debugLine="Dim m As Int = 0";
_m = (int) (0);
 //BA.debugLineNum = 407;BA.debugLine="Dim l As Int = 0";
_l = (int) (0);
 //BA.debugLineNum = 408;BA.debugLine="Dim lIndex As Int";
_lindex = 0;
 //BA.debugLineNum = 409;BA.debugLine="Do While u < 21";
while (_u<21) {
 //BA.debugLineNum = 410;BA.debugLine="Do While m < PerTotal";
while (_m<_pertotal) {
 //BA.debugLineNum = 411;BA.debugLine="m = m + Rnd(1,3)";
_m = (int) (_m+__c.Rnd((int) (1),(int) (3)));
 //BA.debugLineNum = 412;BA.debugLine="lIndex = Rnd(0,3)";
_lindex = __c.Rnd((int) (0),(int) (3));
 //BA.debugLineNum = 413;BA.debugLine="l = mins.Get(lIndex)";
_l = (int)(BA.ObjectToNumber(_mins.Get(_lindex)));
 //BA.debugLineNum = 414;BA.debugLine="If (u*PerTotal + m + l) < (21*PerTotal) And m";
if ((_u*_pertotal+_m+_l)<(21*_pertotal) && _m<_pertotal && (_i!=2 || _u<=11)) { 
 //BA.debugLineNum = 415;BA.debugLine="Dim patient As String = FirstNames.get(Rnd(0,";
_patient = BA.ObjectToString(_firstnames.Get(__c.Rnd((int) (0),(int) (19))))+" "+BA.ObjectToString(_lastnames.Get(__c.Rnd((int) (0),(int) (19))));
 //BA.debugLineNum = 416;BA.debugLine="counter = counter + 1";
_counter = (int) (_counter+1);
 //BA.debugLineNum = 417;BA.debugLine="plan.AddTask(NewTask(i, \"T\" & counter,u,m,l,p";
_plan.AddTask(_newtask(_i,"T"+BA.NumberToString(_counter),_u,_m,_l,_patient,_lindex));
 };
 //BA.debugLineNum = 419;BA.debugLine="m = m + l";
_m = (int) (_m+_l);
 }
;
 //BA.debugLineNum = 421;BA.debugLine="m = m - PerTotal";
_m = (int) (_m-_pertotal);
 //BA.debugLineNum = 422;BA.debugLine="u = u + 1";
_u = (int) (_u+1);
 }
;
 }
};
 //BA.debugLineNum = 426;BA.debugLine="plan.SetActiveDay(ActiveDay)";
_plan.SetActiveDay(_activeday);
 //BA.debugLineNum = 427;BA.debugLine="plan.SetDayStatus(5,False)";
_plan.SetDayStatus((int) (5),__c.False);
 //BA.debugLineNum = 428;BA.debugLine="plan.SetDayStatus(6,False)";
_plan.SetDayStatus((int) (6),__c.False);
 //BA.debugLineNum = 429;BA.debugLine="For i = 12 To 20";
{
final int step55 = 1;
final int limit55 = (int) (20);
for (_i = (int) (12) ; (step55 > 0 && _i <= limit55) || (step55 < 0 && _i >= limit55); _i = ((int)(0 + _i + step55)) ) {
 //BA.debugLineNum = 430;BA.debugLine="plan.SetHourStatus(2,i,False)";
_plan.SetHourStatus((int) (2),_i,__c.False);
 }
};
 //BA.debugLineNum = 432;BA.debugLine="If doRefresh Then";
if (_dorefresh) { 
 //BA.debugLineNum = 433;BA.debugLine="plan.Refresh";
_plan.Refresh();
 };
 //BA.debugLineNum = 435;BA.debugLine="End Sub";
return "";
}
public String  _mydate3_changedweek(String _target,String _weekstring) throws Exception{
String[] _spl = null;
 //BA.debugLineNum = 361;BA.debugLine="Sub mydate3_ChangedWeek(Target As String, WeekStri";
 //BA.debugLineNum = 362;BA.debugLine="page.PauseDelayed(2000)";
_page.PauseDelayed((int) (2000));
 //BA.debugLineNum = 364;BA.debugLine="Dim spl() As String = Regex.Split(\";\",WeekString)";
_spl = __c.Regex.Split(";",_weekstring);
 //BA.debugLineNum = 365;BA.debugLine="FirstDate = spl(1)";
_firstdate = (long)(Double.parseDouble(_spl[(int) (1)]));
 //BA.debugLineNum = 366;BA.debugLine="LoadRandomWeek(FirstDate, True)";
_loadrandomweek(_firstdate,__c.True);
 //BA.debugLineNum = 367;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMPlannerTask  _newtask(int _day,String _taskid,int _starthour,int _startminutesper5,int _lengthminutesper5,String _text,int _themecolorindex) throws Exception{
com.ab.abmaterial.ABMPlannerTask _task = null;
 //BA.debugLineNum = 214;BA.debugLine="Sub NewTask(day As Int, taskID As String, startHou";
 //BA.debugLineNum = 215;BA.debugLine="Dim task As ABMPlannerTask";
_task = new com.ab.abmaterial.ABMPlannerTask();
 //BA.debugLineNum = 216;BA.debugLine="task.Initialize(day, taskID, startHour, startMinu";
_task.Initialize(_day,_taskid,_starthour,_startminutesper5,_lengthminutesper5,_text,_themecolorindex);
 //BA.debugLineNum = 217;BA.debugLine="Return task";
if (true) return _task;
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return null;
}
public String  _nextweek_clicked(String _target) throws Exception{
b4j.example.dateutils._period _per = null;
com.ab.abmaterial.ABMDateTimePicker _mydate3 = null;
 //BA.debugLineNum = 344;BA.debugLine="Sub nextWeek_Clicked(Target As String)";
 //BA.debugLineNum = 345;BA.debugLine="page.PauseDelayed(2000)";
_page.PauseDelayed((int) (2000));
 //BA.debugLineNum = 347;BA.debugLine="Dim per As Period";
_per = new b4j.example.dateutils._period();
 //BA.debugLineNum = 348;BA.debugLine="per.Initialize";
_per.Initialize();
 //BA.debugLineNum = 349;BA.debugLine="per.Days = 7";
_per.Days = (int) (7);
 //BA.debugLineNum = 351;BA.debugLine="FirstDate = DateUtils.AddPeriod(FirstDate, per)";
_firstdate = _dateutils._addperiod(_firstdate,_per);
 //BA.debugLineNum = 353;BA.debugLine="Dim mydate3 As ABMDateTimePicker = page.Component";
_mydate3 = (com.ab.abmaterial.ABMDateTimePicker)(_page.Component("mydate3"));
 //BA.debugLineNum = 354;BA.debugLine="mydate3.SetDate(FirstDate)";
_mydate3.SetDate(_firstdate);
 //BA.debugLineNum = 356;BA.debugLine="LoadRandomWeek(FirstDate, True)";
_loadrandomweek(_firstdate,__c.True);
 //BA.debugLineNum = 358;BA.debugLine="mydate3.Refresh";
_mydate3.Refresh();
 //BA.debugLineNum = 359;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 442;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 443;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 444;BA.debugLine="If Action = \"ABMPlanner\" Then Return";
if ((_action).equals("ABMPlanner")) { 
if (true) return "";};
 //BA.debugLineNum = 445;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 446;BA.debugLine="myToastID = myToastID + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 447;BA.debugLine="page.ShowToast(\"toast\" & myToastID, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 448;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 450;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 451;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 452;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 454;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 455;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 67;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 68;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 69;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 70;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 71;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 72;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 73;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 75;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 76;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 77;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 78;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 80;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 82;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 84;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 85;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 86;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 88;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 92;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 457;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 458;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 459;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 460;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 461;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 462;BA.debugLine="End Sub";
return "";
}
public String  _plan_activedaychanged(int _day) throws Exception{
com.ab.abmaterial.ABMPlanner _plan = null;
 //BA.debugLineNum = 220;BA.debugLine="Sub plan_ActiveDayChanged(day As Int)";
 //BA.debugLineNum = 221;BA.debugLine="Log(\"New day: \" & day)";
__c.Log("New day: "+BA.NumberToString(_day));
 //BA.debugLineNum = 222;BA.debugLine="ActiveDay = day";
_activeday = _day;
 //BA.debugLineNum = 224;BA.debugLine="Dim plan As ABMPlanner = page.Component(\"plan\")";
_plan = (com.ab.abmaterial.ABMPlanner)(_page.Component("plan"));
 //BA.debugLineNum = 225;BA.debugLine="plan.SetActiveDay(ActiveDay)";
_plan.SetActiveDay(_activeday);
 //BA.debugLineNum = 226;BA.debugLine="End Sub";
return "";
}
public String  _plan_menuclicked(String _menutype,String _value) throws Exception{
String[] _spl = null;
com.ab.abmaterial.ABMPlanner _plan = null;
 //BA.debugLineNum = 242;BA.debugLine="Sub plan_MenuClicked(MenuType As String, Value As";
 //BA.debugLineNum = 243;BA.debugLine="Dim spl() As String = Regex.Split(\";\", Value)";
_spl = __c.Regex.Split(";",_value);
 //BA.debugLineNum = 244;BA.debugLine="Dim plan As ABMPlanner = page.Component(\"plan\")";
_plan = (com.ab.abmaterial.ABMPlanner)(_page.Component("plan"));
 //BA.debugLineNum = 245;BA.debugLine="Log(\"MenuType: \" & MenuType)";
__c.Log("MenuType: "+_menutype);
 //BA.debugLineNum = 246;BA.debugLine="Log(\"Value: \" & Value)";
__c.Log("Value: "+_value);
 //BA.debugLineNum = 247;BA.debugLine="Select Case MenuType";
switch (BA.switchObjectToInt(_menutype,_abm.PLANNER_MENUTYPE_DAY,_abm.PLANNER_MENUTYPE_HOUR,_abm.PLANNER_MENUTYPE_MIN)) {
case 0: {
 //BA.debugLineNum = 251;BA.debugLine="Log(\"Day: \" & spl(1))";
__c.Log("Day: "+_spl[(int) (1)]);
 //BA.debugLineNum = 253;BA.debugLine="Select Case spl(0)";
switch (BA.switchObjectToInt(_spl[(int) (0)],BA.NumberToString(_abm.PLANNER_MENU_SETFREE),BA.NumberToString(_abm.PLANNER_MENU_SETNOTAVAILABLE))) {
case 0: {
 //BA.debugLineNum = 255;BA.debugLine="plan.SetDayStatus(spl(1), True)";
_plan.SetDayStatus((int)(Double.parseDouble(_spl[(int) (1)])),__c.True);
 break; }
case 1: {
 //BA.debugLineNum = 257;BA.debugLine="plan.SetDayStatus(spl(1), False)";
_plan.SetDayStatus((int)(Double.parseDouble(_spl[(int) (1)])),__c.False);
 break; }
}
;
 //BA.debugLineNum = 261;BA.debugLine="plan.PerfromDayHourMenuAction";
_plan.PerfromDayHourMenuAction();
 break; }
case 1: {
 //BA.debugLineNum = 265;BA.debugLine="Log(\"Day: \" & spl(1))";
__c.Log("Day: "+_spl[(int) (1)]);
 //BA.debugLineNum = 266;BA.debugLine="Log(\"Hour: \" & spl(2))";
__c.Log("Hour: "+_spl[(int) (2)]);
 //BA.debugLineNum = 268;BA.debugLine="Select Case spl(0)";
switch (BA.switchObjectToInt(_spl[(int) (0)],BA.NumberToString(_abm.PLANNER_MENU_SETFREE),BA.NumberToString(_abm.PLANNER_MENU_SETNOTAVAILABLE))) {
case 0: {
 //BA.debugLineNum = 270;BA.debugLine="plan.SetHourStatus(spl(1), spl(2), True)";
_plan.SetHourStatus((int)(Double.parseDouble(_spl[(int) (1)])),(int)(Double.parseDouble(_spl[(int) (2)])),__c.True);
 break; }
case 1: {
 //BA.debugLineNum = 272;BA.debugLine="plan.SetHourStatus(spl(1), spl(2), False)";
_plan.SetHourStatus((int)(Double.parseDouble(_spl[(int) (1)])),(int)(Double.parseDouble(_spl[(int) (2)])),__c.False);
 break; }
}
;
 //BA.debugLineNum = 276;BA.debugLine="plan.PerfromDayHourMenuAction";
_plan.PerfromDayHourMenuAction();
 break; }
case 2: {
 //BA.debugLineNum = 280;BA.debugLine="Log(\"Day: \" & spl(1))";
__c.Log("Day: "+_spl[(int) (1)]);
 //BA.debugLineNum = 281;BA.debugLine="Log(\"Hour: \" & spl(2))";
__c.Log("Hour: "+_spl[(int) (2)]);
 //BA.debugLineNum = 282;BA.debugLine="Log(\"MinPer5: \" & spl(3))";
__c.Log("MinPer5: "+_spl[(int) (3)]);
 //BA.debugLineNum = 284;BA.debugLine="Log(\"Status: \" & spl(4))";
__c.Log("Status: "+_spl[(int) (4)]);
 //BA.debugLineNum = 285;BA.debugLine="Log(\"Task ID: \" & spl(5))";
__c.Log("Task ID: "+_spl[(int) (5)]);
 //BA.debugLineNum = 287;BA.debugLine="Select Case spl(0)";
switch (BA.switchObjectToInt(_spl[(int) (0)],BA.NumberToString(_abm.PLANNER_MENU_CUT),BA.NumberToString(_abm.PLANNER_MENU_COPY),BA.NumberToString(_abm.PLANNER_MENU_PASTE),BA.NumberToString(_abm.PLANNER_MENU_DELETE))) {
case 0: {
 //BA.debugLineNum = 289;BA.debugLine="cutTaskID = spl(5)";
_cuttaskid = _spl[(int) (5)];
 //BA.debugLineNum = 290;BA.debugLine="copyTask = plan.GetTask(spl(5))";
_copytask = _plan.GetTask(_spl[(int) (5)]);
 //BA.debugLineNum = 291;BA.debugLine="IsCut = True";
_iscut = __c.True;
 //BA.debugLineNum = 292;BA.debugLine="myToastID = myToastID + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 293;BA.debugLine="page.ShowToast(\"toast\" & myToastID, \"toastred";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Move "+_copytask.getText()+" to...",(int) (5000));
 break; }
case 1: {
 //BA.debugLineNum = 295;BA.debugLine="copyTask = plan.GetTask(spl(5))";
_copytask = _plan.GetTask(_spl[(int) (5)]);
 //BA.debugLineNum = 296;BA.debugLine="IsCut = False";
_iscut = __c.False;
 //BA.debugLineNum = 297;BA.debugLine="myToastID = myToastID + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 298;BA.debugLine="page.ShowToast(\"toast\" & myToastID, \"toastred";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Copy "+_copytask.getText()+" to...",(int) (5000));
 break; }
case 2: {
 //BA.debugLineNum = 300;BA.debugLine="If IsCut Then";
if (_iscut) { 
 //BA.debugLineNum = 301;BA.debugLine="plan.RemoveTask2(cutTaskID)";
_plan.RemoveTask2(_cuttaskid);
 }else {
 //BA.debugLineNum = 303;BA.debugLine="counter = counter + 1";
_counter = (int) (_counter+1);
 //BA.debugLineNum = 304;BA.debugLine="copyTask = copyTask.Clone(\"T\" & counter)";
_copytask = _copytask.Clone("T"+BA.NumberToString(_counter));
 };
 //BA.debugLineNum = 306;BA.debugLine="copyTask.Day = spl(1)";
_copytask.setDay((int)(Double.parseDouble(_spl[(int) (1)])));
 //BA.debugLineNum = 307;BA.debugLine="copyTask.StartHour = spl(2)";
_copytask.setStartHour((int)(Double.parseDouble(_spl[(int) (2)])));
 //BA.debugLineNum = 308;BA.debugLine="copyTask.StartMinututesPer = spl(3)";
_copytask.setStartMinututesPer((int)(Double.parseDouble(_spl[(int) (3)])));
 //BA.debugLineNum = 309;BA.debugLine="plan.AddTask(copyTask)";
_plan.AddTask(_copytask);
 //BA.debugLineNum = 310;BA.debugLine="plan.Refresh";
_plan.Refresh();
 //BA.debugLineNum = 311;BA.debugLine="If IsCut Then";
if (_iscut) { 
 //BA.debugLineNum = 312;BA.debugLine="myToastID = myToastID + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 313;BA.debugLine="page.ShowToast(\"toast\" & myToastID, \"toastre";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred",_copytask.getText()+" moved!",(int) (5000));
 }else {
 //BA.debugLineNum = 315;BA.debugLine="myToastID = myToastID + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 316;BA.debugLine="page.ShowToast(\"toast\" & myToastID, \"toastre";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred",_copytask.getText()+" copied!",(int) (5000));
 };
 break; }
case 3: {
 //BA.debugLineNum = 319;BA.debugLine="plan.RemoveTask2(spl(5))";
_plan.RemoveTask2(_spl[(int) (5)]);
 //BA.debugLineNum = 320;BA.debugLine="plan.Refresh";
_plan.Refresh();
 break; }
}
;
 break; }
}
;
 //BA.debugLineNum = 325;BA.debugLine="End Sub";
return "";
}
public String  _plan_minutesclicked(String _value) throws Exception{
String[] _spl = null;
 //BA.debugLineNum = 228;BA.debugLine="Sub plan_MinutesClicked(Value As String)";
 //BA.debugLineNum = 229;BA.debugLine="Dim spl() As String = Regex.Split(\";\", Value)";
_spl = __c.Regex.Split(";",_value);
 //BA.debugLineNum = 231;BA.debugLine="Log(\"Day: \" & spl(1))";
__c.Log("Day: "+_spl[(int) (1)]);
 //BA.debugLineNum = 232;BA.debugLine="Log(\"Hour: \" & spl(2))";
__c.Log("Hour: "+_spl[(int) (2)]);
 //BA.debugLineNum = 233;BA.debugLine="Log(\"MinPer5: \" & spl(3))";
__c.Log("MinPer5: "+_spl[(int) (3)]);
 //BA.debugLineNum = 235;BA.debugLine="Log(\"Status: \" & spl(4))";
__c.Log("Status: "+_spl[(int) (4)]);
 //BA.debugLineNum = 236;BA.debugLine="Log(\"Task ID: \" & spl(5))";
__c.Log("Task ID: "+_spl[(int) (5)]);
 //BA.debugLineNum = 238;BA.debugLine="myToastID = myToastID + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 239;BA.debugLine="page.ShowToast(\"toast\" & myToastID, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","In a real app, here you could open a task editor.",(int) (5000));
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
return "";
}
public String  _plan_refreshed() throws Exception{
 //BA.debugLineNum = 437;BA.debugLine="Sub plan_Refreshed()";
 //BA.debugLineNum = 438;BA.debugLine="page.Resume";
_page.Resume();
 //BA.debugLineNum = 439;BA.debugLine="End Sub";
return "";
}
public String  _prevweek_clicked(String _target) throws Exception{
b4j.example.dateutils._period _per = null;
com.ab.abmaterial.ABMDateTimePicker _mydate3 = null;
 //BA.debugLineNum = 327;BA.debugLine="Sub prevWeek_Clicked(Target As String)";
 //BA.debugLineNum = 328;BA.debugLine="page.PauseDelayed(2000)";
_page.PauseDelayed((int) (2000));
 //BA.debugLineNum = 330;BA.debugLine="Dim per As Period";
_per = new b4j.example.dateutils._period();
 //BA.debugLineNum = 331;BA.debugLine="per.Initialize";
_per.Initialize();
 //BA.debugLineNum = 332;BA.debugLine="per.Days = -7";
_per.Days = (int) (-7);
 //BA.debugLineNum = 334;BA.debugLine="FirstDate = DateUtils.AddPeriod(FirstDate, per)";
_firstdate = _dateutils._addperiod(_firstdate,_per);
 //BA.debugLineNum = 336;BA.debugLine="Dim mydate3 As ABMDateTimePicker = page.Component";
_mydate3 = (com.ab.abmaterial.ABMDateTimePicker)(_page.Component("mydate3"));
 //BA.debugLineNum = 337;BA.debugLine="mydate3.SetDate(FirstDate)";
_mydate3.SetDate(_firstdate);
 //BA.debugLineNum = 339;BA.debugLine="LoadRandomWeek(FirstDate, True)";
_loadrandomweek(_firstdate,__c.True);
 //BA.debugLineNum = 341;BA.debugLine="mydate3.Refresh";
_mydate3.Refresh();
 //BA.debugLineNum = 342;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 35;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 36;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 37;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 38;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 39;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 41;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 42;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 43;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 44;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 48;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 49;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 51;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 53;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 56;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 58;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 60;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 61;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 64;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
