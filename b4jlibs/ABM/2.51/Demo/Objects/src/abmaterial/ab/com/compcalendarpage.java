package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compcalendarpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compcalendarpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compcalendarpage.class).invoke(this, new Object[] {null});
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
public int _evid = 0;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 100;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 103;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 104;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 105;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 106;BA.debugLine="page.PageTitle = \"ABMCalendar\"";
_page.PageTitle = "ABMCalendar";
 //BA.debugLineNum = 107;BA.debugLine="page.PageDescription = \"The calendar component \"";
_page.PageDescription = "The calendar component ";
 //BA.debugLineNum = 108;BA.debugLine="page.PageHTMLName = \"abmaterial-calendar.html\"";
_page.PageHTMLName = "abmaterial-calendar.html";
 //BA.debugLineNum = 109;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 110;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 111;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 112;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 114;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMCalendar\",";
_abmshared._buildnavigationbar(_page,"ABMCalendar","../images/logo.png","","Controls","ABMCalendar");
 //BA.debugLineNum = 117;BA.debugLine="page.AddRows(5,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (5),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 118;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 123;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 91;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 92;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public String  _calendar1_dayclicked(String _date) throws Exception{
com.ab.abmaterial.ABMCalendar _cal1 = null;
 //BA.debugLineNum = 176;BA.debugLine="Sub calendar1_DayClicked(date As String)";
 //BA.debugLineNum = 177;BA.debugLine="Log(\"day clicked: \" & date)";
__c.Log("day clicked: "+_date);
 //BA.debugLineNum = 178;BA.debugLine="Dim cal1 As ABMCalendar = page.Component(\"calenda";
_cal1 = (com.ab.abmaterial.ABMCalendar)(_page.Component("calendar1"));
 //BA.debugLineNum = 179;BA.debugLine="cal1.GotoDate(\"2015-12-31\")";
_cal1.GotoDate("2015-12-31");
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return "";
}
public String  _calendar1_eventclicked(String _eventid) throws Exception{
 //BA.debugLineNum = 231;BA.debugLine="Sub calendar1_EventClicked(eventId As String)";
 //BA.debugLineNum = 232;BA.debugLine="Log(\"clicked on event: \" & eventId)";
__c.Log("clicked on event: "+_eventid);
 //BA.debugLineNum = 233;BA.debugLine="End Sub";
return "";
}
public String  _calendar1_eventendchanged(String _eventid,String _newend) throws Exception{
 //BA.debugLineNum = 243;BA.debugLine="Sub calendar1_EventEndChanged(eventId As String, N";
 //BA.debugLineNum = 244;BA.debugLine="Log(\"End changed of event: \" & eventId & \" newEnd";
__c.Log("End changed of event: "+_eventid+" newEnd: "+_newend);
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return "";
}
public String  _calendar1_eventstartchanged(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
 //BA.debugLineNum = 239;BA.debugLine="Sub calendar1_EventStartChanged(params As Map)";
 //BA.debugLineNum = 240;BA.debugLine="Log(\"Start changed of event: \" & params.Get(\"even";
__c.Log("Start changed of event: "+BA.ObjectToString(_params.Get((Object)("eventid")))+" newStart: "+BA.ObjectToString(_params.Get((Object)("newstart")))+" AllDay: "+BA.ObjectToString(_params.Get((Object)("allday"))));
 //BA.debugLineNum = 241;BA.debugLine="End Sub";
return "";
}
public String  _calendar1_fetchdata(String _datestart,String _dateend) throws Exception{
long _fromdate = 0L;
anywheresoftware.b4a.objects.collections.List _cols = null;
anywheresoftware.b4a.objects.collections.List _eventlist = null;
int _i = 0;
com.ab.abmaterial.ABMCalendarEvent _ev = null;
b4j.example.dateutils._period _per = null;
long _newdate = 0L;
String _begin = "";
com.ab.abmaterial.ABMCalendar _cal1 = null;
 //BA.debugLineNum = 182;BA.debugLine="Sub calendar1_FetchData(dateStart As String, dateE";
 //BA.debugLineNum = 183;BA.debugLine="Log(\"from: \" & dateStart & \" - to: \" & dateEnd)";
__c.Log("from: "+_datestart+" - to: "+_dateend);
 //BA.debugLineNum = 184;BA.debugLine="Dim FromDate As Long = ABMShared.String2Date(date";
_fromdate = _abmshared._string2date(_datestart);
 //BA.debugLineNum = 186;BA.debugLine="evID=0";
_evid = (int) (0);
 //BA.debugLineNum = 188;BA.debugLine="Dim cols As List";
_cols = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 189;BA.debugLine="cols.Initialize2(Array As String(ABM.COLOR_DEEPOR";
_cols.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{_abm.COLOR_DEEPORANGE,_abm.COLOR_LIGHTBLUE,_abm.COLOR_GREEN,_abm.COLOR_RED,_abm.COLOR_BLACK}));
 //BA.debugLineNum = 191;BA.debugLine="Dim eventList As List";
_eventlist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 192;BA.debugLine="eventList.Initialize";
_eventlist.Initialize();
 //BA.debugLineNum = 195;BA.debugLine="For i = 0 To 15";
{
final int step8 = 1;
final int limit8 = (int) (15);
_i = (int) (0) ;
for (;(step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8) ;_i = ((int)(0 + _i + step8))  ) {
 //BA.debugLineNum = 196;BA.debugLine="Dim ev As ABMCalendarEvent";
_ev = new com.ab.abmaterial.ABMCalendarEvent();
 //BA.debugLineNum = 197;BA.debugLine="Dim per As Period";
_per = new b4j.example.dateutils._period();
 //BA.debugLineNum = 198;BA.debugLine="per.Initialize";
_per.Initialize();
 //BA.debugLineNum = 199;BA.debugLine="per.Days = Rnd(0,7)";
_per.Days = __c.Rnd((int) (0),(int) (7));
 //BA.debugLineNum = 200;BA.debugLine="Dim newDate As Long = DateUtils.AddPeriod(FromDa";
_newdate = _dateutils._addperiod(_fromdate,_per);
 //BA.debugLineNum = 201;BA.debugLine="evID=evID+1";
_evid = (int) (_evid+1);
 //BA.debugLineNum = 202;BA.debugLine="Dim Begin As String";
_begin = "";
 //BA.debugLineNum = 203;BA.debugLine="If Rnd(1,10) < 2 Then ' make some alldays";
if (__c.Rnd((int) (1),(int) (10))<2) { 
 //BA.debugLineNum = 204;BA.debugLine="Begin = ABMShared.Date2String(newDate, False)";
_begin = _abmshared._date2string(_newdate,__c.False);
 //BA.debugLineNum = 205;BA.debugLine="ev.Initialize(\"\" & evID, \"Event number: \" & evI";
_ev.Initialize(""+BA.NumberToString(_evid),"Event number: "+BA.NumberToString(_evid),_begin);
 //BA.debugLineNum = 206;BA.debugLine="ev.AllDay=True";
_ev.AllDay = __c.True;
 //BA.debugLineNum = 208;BA.debugLine="ev.BackgroundColor = cols.Get(Rnd(0,5))";
_ev.BackgroundColor = BA.ObjectToString(_cols.Get(__c.Rnd((int) (0),(int) (5))));
 }else {
 //BA.debugLineNum = 210;BA.debugLine="per.Days = 0";
_per.Days = (int) (0);
 //BA.debugLineNum = 211;BA.debugLine="per.Hours = Rnd(9,18)";
_per.Hours = __c.Rnd((int) (9),(int) (18));
 //BA.debugLineNum = 212;BA.debugLine="newDate = DateUtils.AddPeriod(newDate,per)";
_newdate = _dateutils._addperiod(_newdate,_per);
 //BA.debugLineNum = 213;BA.debugLine="Begin = ABMShared.Date2String(newDate, True)";
_begin = _abmshared._date2string(_newdate,__c.True);
 //BA.debugLineNum = 214;BA.debugLine="ev.Initialize(\"\" & evID, \"Event number: \" & evI";
_ev.Initialize(""+BA.NumberToString(_evid),"Event number: "+BA.NumberToString(_evid),_begin);
 //BA.debugLineNum = 216;BA.debugLine="ev.BackgroundColor = cols.Get(Rnd(0,5))";
_ev.BackgroundColor = BA.ObjectToString(_cols.Get(__c.Rnd((int) (0),(int) (5))));
 //BA.debugLineNum = 217;BA.debugLine="per.Hours = Rnd(1,4)";
_per.Hours = __c.Rnd((int) (1),(int) (4));
 //BA.debugLineNum = 218;BA.debugLine="newDate = DateUtils.AddPeriod(newDate,per)";
_newdate = _dateutils._addperiod(_newdate,_per);
 //BA.debugLineNum = 219;BA.debugLine="ev.EndTime = ABMShared.Date2String(newDate, Tru";
_ev.EndTime = _abmshared._date2string(_newdate,__c.True);
 };
 //BA.debugLineNum = 222;BA.debugLine="eventList.Add(ev)";
_eventlist.Add((Object)(_ev));
 }
};
 //BA.debugLineNum = 225;BA.debugLine="Dim cal1 As ABMCalendar = page.Component(\"calenda";
_cal1 = (com.ab.abmaterial.ABMCalendar)(_page.Component("calendar1"));
 //BA.debugLineNum = 226;BA.debugLine="Log(cal1.GetTitle)";
__c.Log(_cal1.GetTitle());
 //BA.debugLineNum = 227;BA.debugLine="cal1.SetEvents(eventList)";
_cal1.SetEvents(_eventlist);
 //BA.debugLineNum = 228;BA.debugLine="cal1.Refresh ' IMPORTANT";
_cal1.Refresh();
 //BA.debugLineNum = 229;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompCalendarPage\"";
_name = "CompCalendarPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="Dim evID As Int";
_evid = 0;
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMCalendar _cal1 = null;
 //BA.debugLineNum = 126;BA.debugLine="public Sub ConnectPage()";
 //BA.debugLineNum = 128;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 131;BA.debugLine="page.CellR(0,1).AddComponent(ABMShared.BuildParag";
_page.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Calendar is a drag-n-drop component for displaying events on a full-sized calendar.")));
 //BA.debugLineNum = 135;BA.debugLine="Dim cal1 As ABMCalendar";
_cal1 = new com.ab.abmaterial.ABMCalendar();
 //BA.debugLineNum = 136;BA.debugLine="cal1.Initialize(page, \"calendar1\", \"2015-11-18\",";
_cal1.Initialize(_page,"calendar1","2015-11-18",_abm.FIRSTDAYOFWEEK_MONDAY,"en",_abm.CALENDAR_DEFAULTVIEW_WEEK,"");
 //BA.debugLineNum = 137;BA.debugLine="cal1.Editable = True";
_cal1.Editable = __c.True;
 //BA.debugLineNum = 138;BA.debugLine="cal1.MinTime = \"06:00\"";
_cal1.MinTime = "06:00";
 //BA.debugLineNum = 139;BA.debugLine="cal1.MaxTime = \"22:00\"";
_cal1.MaxTime = "22:00";
 //BA.debugLineNum = 140;BA.debugLine="page.Cell(2,1).AddComponent(cal1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_cal1));
 //BA.debugLineNum = 143;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 145;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 148;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 150;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 154;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 155;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 156;BA.debugLine="If Action = \"ABMCalendar\" Then Return";
if ((_action).equals("ABMCalendar")) { 
if (true) return "";};
 //BA.debugLineNum = 157;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 158;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 159;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 160;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 162;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 163;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 164;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 166;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 169;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 170;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 171;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 172;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 173;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 174;BA.debugLine="End Sub";
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
