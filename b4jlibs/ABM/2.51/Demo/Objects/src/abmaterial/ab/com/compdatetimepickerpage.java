package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compdatetimepickerpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compdatetimepickerpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compdatetimepickerpage.class).invoke(this, new Object[] {null});
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
public String  _arrdate_changed(String _target,String _datemilliseconds) throws Exception{
com.ab.abmaterial.ABMDateTimePicker _mydate3 = null;
long _backdate = 0L;
 //BA.debugLineNum = 233;BA.debugLine="Sub arrDate_Changed(Target As String, dateMillisec";
 //BA.debugLineNum = 234;BA.debugLine="Dim mydate3 As ABMDateTimePicker = page.Component";
_mydate3 = (com.ab.abmaterial.ABMDateTimePicker)(_page.Component(_target));
 //BA.debugLineNum = 235;BA.debugLine="Log(mydate3.GetDate & \"<->\" & dateMilliseconds)";
__c.Log(BA.NumberToString(_mydate3.GetDate())+"<->"+_datemilliseconds);
 //BA.debugLineNum = 237;BA.debugLine="Dim BackDate As Long = dateMilliseconds";
_backdate = (long)(Double.parseDouble(_datemilliseconds));
 //BA.debugLineNum = 238;BA.debugLine="DateTime.DateFormat = \"MM/dd/yyyy\"";
__c.DateTime.setDateFormat("MM/dd/yyyy");
 //BA.debugLineNum = 239;BA.debugLine="DateTime.TimeFormat = \"HH:mm\"";
__c.DateTime.setTimeFormat("HH:mm");
 //BA.debugLineNum = 241;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 242;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Date/time: "+__c.DateTime.Date(_backdate)+" "+__c.DateTime.Time(_backdate),(int) (5000));
 //BA.debugLineNum = 243;BA.debugLine="End Sub";
return "";
}
public String  _arrdate_changedweek(String _target,String _weekstring) throws Exception{
 //BA.debugLineNum = 245;BA.debugLine="Sub arrDate_ChangedWeek(Target As String, WeekStri";
 //BA.debugLineNum = 246;BA.debugLine="Log(WeekString)";
__c.Log(_weekstring);
 //BA.debugLineNum = 247;BA.debugLine="End Sub";
return "";
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 97;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 100;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 101;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 102;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 103;BA.debugLine="page.PageTitle = \"ABMDateTimePicker\"";
_page.PageTitle = "ABMDateTimePicker";
 //BA.debugLineNum = 104;BA.debugLine="page.PageDescription = \"The date/time picker comp";
_page.PageDescription = "The date/time picker component ";
 //BA.debugLineNum = 105;BA.debugLine="page.PageHTMLName = \"abmaterial-date-time-picker.";
_page.PageHTMLName = "abmaterial-date-time-picker.html";
 //BA.debugLineNum = 106;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 107;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 108;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 109;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 111;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMDateTimePi";
_abmshared._buildnavigationbar(_page,"ABMDateTimePicker","../images/logo.png","","Controls","ABMDateTimePicker");
 //BA.debugLineNum = 114;BA.debugLine="page.AddRows(7,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (7),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 115;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 120;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompDateTimePickerPage\"";
_name = "CompDateTimePickerPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMDateTimePicker _mydate3 = null;
long _newdate = 0L;
String _code1 = "";
String _code2 = "";
 //BA.debugLineNum = 123;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 125;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 128;BA.debugLine="page.CellR(0,1).AddComponent(ABMShared.BuildParag";
_page.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","The date time picker component can be used to input a date, a time or both using the DATETIMEPICKER_TYPE_TIME, DATETIMEPICKER_TYPE_DATE and DATETIMEPICKER_TYPE_DATETIME constants.")));
 //BA.debugLineNum = 162;BA.debugLine="Dim mydate3 As ABMDateTimePicker";
_mydate3 = new com.ab.abmaterial.ABMDateTimePicker();
 //BA.debugLineNum = 163;BA.debugLine="Dim NewDate As Long = DateTime.Now";
_newdate = __c.DateTime.getNow();
 //BA.debugLineNum = 164;BA.debugLine="mydate3.Initialize(page, \"1\", ABM.DATETIMEPICKER_";
_mydate3.Initialize(_page,"1",_abm.DATETIMEPICKER_TYPE_DATETIME,_newdate,"Pick a date and time","");
 //BA.debugLineNum = 165;BA.debugLine="mydate3.CancelText = \"Back\"";
_mydate3.CancelText = "Back";
 //BA.debugLineNum = 166;BA.debugLine="mydate3.PickText = \"OK\"";
_mydate3.PickText = "OK";
 //BA.debugLineNum = 167;BA.debugLine="mydate3.TodayText = \"Today\"";
_mydate3.TodayText = "Today";
 //BA.debugLineNum = 168;BA.debugLine="mydate3.Language = \"en\"";
_mydate3.Language = "en";
 //BA.debugLineNum = 169;BA.debugLine="mydate3.ReturnDateFormat = \"MM/DD/YYYY\"   ' <---";
_mydate3.ReturnDateFormat = "MM/DD/YYYY";
 //BA.debugLineNum = 170;BA.debugLine="mydate3.ReturnTimeFormat = \"HH:mm\"        ' <---";
_mydate3.ReturnTimeFormat = "HH:mm";
 //BA.debugLineNum = 171;BA.debugLine="mydate3.FirstDayOfWeek = 1";
_mydate3.FirstDayOfWeek = (int) (1);
 //BA.debugLineNum = 173;BA.debugLine="page.CellR(1,1).AddArrayComponent(mydate3, \"arrda";
_page.CellR((int) (1),(int) (1)).AddArrayComponent((com.ab.abmaterial.ABMComponent)(_mydate3),"arrdate");
 //BA.debugLineNum = 177;BA.debugLine="Dim code1 As String = $\"Dim mydate3 As ABMDateTim";
_code1 = ("Dim mydate3 As ABMDateTimePicker\n"+"Dim NewDate As Long = DateTime.Now\n"+"mydate3.Initialize(page, \"mydate3\", ABM.DATETIMEPICKER_TYPE_DATETIME, NewDate, \"Pick a date and time\", \"\")\n"+"mydate3.CancelText = \"Back\"\n"+"mydate3.PickText = \"OK\"\n"+"mydate3.TodayText = \"Today\"\n"+"mydate3.Language = \"en\"\n"+"mydate3.ReturnDateFormat = \"MM/DD/YYYY\"   // <--- see demo source code for settings\n"+"mydate3.ReturnTimeFormat = \"HH:mm\"        // <--- see demo source code for settings\n"+"mydate3.FirstDayOfWeek = 0\n"+"//mydate3.ClickThrough = True  <--- set to true if, when the user makes a selection, the ok action should be triggered.\n"+"page.CellR(1,1).AddComponent(mydate3)	");
 //BA.debugLineNum = 190;BA.debugLine="page.CellR(1,1).AddComponent(ABMShared.BuildCodeB";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code1)));
 //BA.debugLineNum = 193;BA.debugLine="page.CellR(1,1).AddComponent(ABMShared.BuildParag";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","When changed, an event will be raised: YourComp_Changed(dataMilliseconds as String).  The param is a string but can easily be converted to a long and a date.")));
 //BA.debugLineNum = 196;BA.debugLine="Dim code2 As String = $\"Sub mydate3_Changed(Targe";
_code2 = ("Sub mydate3_Changed(Target As String, dateMilliseconds As String)\n"+"	// convert to a B4J date\n"+"	Dim BackDate As Long = dateMilliseconds\n"+"	DateTime.DateFormat = \"MM/dd/yyyy\"\n"+"	DateTime.TimeFormat = \"HH:mm\"\n"+"	\n"+"	myToastId = myToastId + 1	\n"+"	page.ShowToast(\"toast\" & myToastId, \"toastred\", \"Date/time: \" & DateTime.Date(BackDate) & \" \" & DateTime.Time(BackDate), 5000)\n"+"End Sub");
 //BA.debugLineNum = 206;BA.debugLine="page.CellR(1,1).AddComponent(ABMShared.BuildCodeB";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code2",_code2)));
 //BA.debugLineNum = 209;BA.debugLine="page.CellR(1,1).AddComponent(ABMShared.BuildParag";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","You can also set or get the components date/time using SetDate(date as long) and GetDate() as long methods.")));
 //BA.debugLineNum = 217;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 219;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 228;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 230;BA.debugLine="Page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 231;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 250;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 251;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 252;BA.debugLine="If Action = \"ABMDateTimePicker\" Then Return";
if ((_action).equals("ABMDateTimePicker")) { 
if (true) return "";};
 //BA.debugLineNum = 253;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 254;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 255;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 256;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 258;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 259;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 260;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 262;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 263;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 265;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 266;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 267;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 268;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 269;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 270;BA.debugLine="End Sub";
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