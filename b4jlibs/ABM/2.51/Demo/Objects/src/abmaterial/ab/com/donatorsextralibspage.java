package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class donatorsextralibspage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.donatorsextralibspage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.donatorsextralibspage.class).invoke(this, new Object[] {null});
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
 //BA.debugLineNum = 95;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 97;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 100;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 101;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 102;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 103;BA.debugLine="page.PageTitle = \"Extra libraries\"";
_page.PageTitle = "Extra libraries";
 //BA.debugLineNum = 104;BA.debugLine="page.PageDescription = \"Extra librarries\"";
_page.PageDescription = "Extra librarries";
 //BA.debugLineNum = 105;BA.debugLine="page.PageHTMLName = \"abmaterial-extralibs.html\"";
_page.PageHTMLName = "abmaterial-extralibs.html";
 //BA.debugLineNum = 106;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 107;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 108;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 109;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 111;BA.debugLine="ABMShared.BuildNavigationBar(page, \"Extra librari";
_abmshared._buildnavigationbar(_page,"Extra libraries","../images/logo.png","","Donators","ExtraLibs");
 //BA.debugLineNum = 114;BA.debugLine="page.AddRows(10,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (10),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 116;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 121;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 88;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 89;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"DonatorsExtraLibsPage\"";
_name = "DonatorsExtraLibsPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
abmaterial.ab.com.donatebutton _donbutton = null;
String _code1 = "";
String _code2 = "";
String _code3 = "";
String _code4 = "";
String _code5 = "";
String _code6 = "";
String _code7 = "";
String _code8 = "";
String _code9 = "";
String _code10 = "";
String _code11 = "";
 //BA.debugLineNum = 124;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 126;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 129;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","As an extra thank you for those who want to support ABMaterial and made a donation, I give them some extra libraries.")));
 //BA.debugLineNum = 131;BA.debugLine="Dim donButton As DonateButton";
_donbutton = new abmaterial.ab.com.donatebutton();
 //BA.debugLineNum = 132;BA.debugLine="donButton.Initialize(page, \"donButton\")";
_donbutton._initialize(ba,_page,"donButton");
 //BA.debugLineNum = 133;BA.debugLine="page.Cell(1,1).AddComponent(donButton.ABMComp)";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_donbutton._abmcomp));
 //BA.debugLineNum = 135;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr2","ABExchange")));
 //BA.debugLineNum = 137;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","It can be used to sync the ABMCalendar control with your exchange server and outlook.")));
 //BA.debugLineNum = 139;BA.debugLine="Dim code1 As String = $\"Sub calendar1_FetchData(d";
_code1 = ("Sub calendar1_FetchData(dateStart As String, dateEnd As String)\n"+"    Log(\"from: \" & dateStart & \" - to: \" & dateEnd)\n"+"        \n"+"    If dateStart.Length < 11 Then\n"+"        dateStart = dateStart & \"T00:00:00\"        \n"+"        dateEnd = dateEnd & \"T00:00:00\"\n"+"    End If\n"+"    \n"+"    Dim eventList As List\n"+"    eventList.Initialize\n"+"    \n"+"    Dim exch As ABExchange\n"+"    exch.Initialize(\"https://xxxxxxxxx.one-two.com/EWS/Exchange.asmx\")\n"+"    If exch.Connect(Login, pwd) = False Then\n"+"        Log(\"NOT autohorized!\")\n"+"        Return\n"+"    Else\n"+"        Log(\"autohorized!\")\n"+"        Dim lst As List\n"+"        lst = exch.findAppointments(dateStart, dateEnd)\n"+"        For i = 0 To lst.Size-1\n"+"            Dim app As ABEAppointment = lst.Get(i)\n"+"            Dim ev As ABMCalendarEvent\n"+"            Dim starttime As String = app.StartTime\n"+"            Dim endtime As String = app.EndTime\n"+"                        \n"+"            ev.Initialize(app.EventId, app.Title, starttime)\n"+"            ev.EndTime = endtime\n"+"            ev.AllDay = app.AllDay\n"+"            // set a color IMPORTANT!\n"+"            ev.BackgroundColor = ABM.COLOR_ORANGE\n"+"            ev.BackgroundColorIntensity = ABM.INTENSITY_DARKEN4\n"+"            eventList.Add(ev)\n"+"        Next\n"+"    End If\n"+"    \n"+"    Dim cal1 As ABMCalendar = page.Component(\"calendar1\")\n"+"    Log(cal1.GetTitle)\n"+"    cal1.SetEvents(eventList)\n"+"    cal1.Refresh // IMPORTANT\n"+"End Sub");
 //BA.debugLineNum = 181;BA.debugLine="page.Cell(2,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code1)));
 //BA.debugLineNum = 183;BA.debugLine="Dim code2 As String = $\"Sub calendar1_EventClicke";
_code2 = ("Sub calendar1_EventClicked(eventId As String)\n"+"    Log(\"clicked on event: \" & eventId)\n"+"End Sub");
 //BA.debugLineNum = 187;BA.debugLine="page.Cell(2,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code2",_code2)));
 //BA.debugLineNum = 189;BA.debugLine="Dim code3 As String = $\"Sub calendar1_EventStartC";
_code3 = ("Sub calendar1_EventStartChanged(params As Map)\n"+"	// has more than 2 params (case sensitive!):\n"+"	// params.get(\"eventid\")\n"+"	// params.get(\"newstart\")\n"+"	// params.get(\"newend\")\n"+"	// params.get(\"allday\")\n"+"    Log(\"Start changed of event: \" & params.Get(\"eventid\") & \" newStart: \" & params.Get(\"newstart\") & \" newEnd: \" & params.Get(\"newend\") & \" AllDay: \" & params.Get(\"allday\"))\n"+"    Dim ev As ABEAppointment\n"+"    Dim exch As ABExchange\n"+"    exch.Initialize(\"https://xxxxxxxxxxxxxxx.one-two.com/EWS/Exchange.asmx\")\n"+"    If exch.Connect(Login, pwd) = False Then\n"+"        Log(\"NOT autohorized!\")\n"+"        Return\n"+"    Else\n"+"        ev = exch.GetAppointment(params.Get(\"eventid\"))\n"+"        ev.StartTime = params.Get(\"newstart\")\n"+"        // important, as the start ended, you must also set the new end!!!!!\n"+"        ev.endTime = params.Get(\"newend\")\n"+"        ev.AllDay = params.Get(\"allday\")\n"+"        exch.UpdateAppointment(ev)\n"+"    End If\n"+"    \n"+"End Sub");
 //BA.debugLineNum = 213;BA.debugLine="page.Cell(2,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code3",_code3)));
 //BA.debugLineNum = 215;BA.debugLine="Dim code4 As String = $\"Sub calendar1_EventEndCha";
_code4 = ("Sub calendar1_EventEndChanged(eventId As String, NewEnd As String)\n"+"    Log(\"End changed of event: \" & eventId & \" newEnd: \" & NewEnd)\n"+"    Dim ev As ABEAppointment\n"+"    Dim exch As ABExchange\n"+"    exch.Initialize(\"https://xxxxxxxxxxxxxxx.one-two.com/EWS/Exchange.asmx\")\n"+"    If exch.Connect(Login, pwd) = False Then\n"+"        Log(\"NOT autohorized!\")\n"+"        Return\n"+"    Else\n"+"        ev = exch.GetAppointment(eventId)\n"+"        ev.EndTime = NewEnd\n"+"        exch.UpdateAppointment(ev)\n"+"    End If\n"+"End Sub");
 //BA.debugLineNum = 230;BA.debugLine="page.Cell(2,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code4",_code4)));
 //BA.debugLineNum = 232;BA.debugLine="Dim code5 As String = $\"Sub switch1_Clicked()";
_code5 = ("Sub switch1_Clicked()\n"+"    Dim switch1 As ABMSwitch = page.Component(\"switch1\")\n"+"    Dim cal1 As ABMCalendar = page.Component(\"calendar1\")\n"+"    cal1.ChangeEventsEditable(switch1.State)    \n"+"    cal1.Refresh    \n"+"End Sub");
 //BA.debugLineNum = 239;BA.debugLine="page.Cell(2,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code5",_code5)));
 //BA.debugLineNum = 241;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","It can also send an email using your exchange server.")));
 //BA.debugLineNum = 243;BA.debugLine="Dim code6 As String = $\"Dim exch As ABExchange ex";
_code6 = ("Dim exch As ABExchange\n"+"exch.Initialize(\"https://xxxxxxxxxxxxxxxx.one-two.com/EWS/Exchange.asmx\")\n"+"If exch.Connect(login, password) = False Then\n"+"	Log(\"NOT autohorized!\")\n"+"    return\n"+"end if\n"+"        \n"+"Dim mail As ABEEmail\n"+"mail.Initialize\n"+"mail.Recipients.Add(\"alain.bailleul@pandora.be\")\n"+"mail.Subject = \"Test from alain\"\n"+"mail.Body = \"This is the body\"\n"+"mail.Attachments.Add(\"z:\\442124171115-210643608.pdf\")\n"+"Log(exch.SendEmail(mail))\n"+"exch.Disconnect");
 //BA.debugLineNum = 259;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code6",_code6)));
 //BA.debugLineNum = 261;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr4","ABJasperReports")));
 //BA.debugLineNum = 263;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","This is a little library that allows you to export reports created in Jasper Reports in your B4J applications. They can be exported to  pdf, html and xls.  You can use parameters defined in JasperReports.")));
 //BA.debugLineNum = 265;BA.debugLine="Dim code7 As String = $\"Sub AppStart (Args() As S";
_code7 = ("Sub AppStart (Args() As String)\n"+"    DBM.InitializeMySQLMaria(\"jdbc:mariadb://localhost:3306/sakila\", \"root\", \"1418\", 100)\n"+"    \n"+"    Dim SQL As SQL = DBM.GetSQL\n"+"    \n"+"    Dim jr As ABJasperReports\n"+"    jr.Initialize(\"YOURDONATORKEY\")\n"+"\n"+"    Dim Params As Map\n"+"    Params.Initialize\n"+"\n"+"    jr.ExportPDF(SQL, \"sakila.jrxml\", Params, \"sakila.pdf\")\n"+"    jr.ExportHTML(SQL, \"sakila.jrxml\", Params, \"sakila.html\")\n"+"    jr.ExportXLS(SQL, \"sakila.jrxml\", Params, \"sakila.xls\")\n"+"        \n"+"    Params.Put(\"myId\", 1)\n"+"    jr.ExportPDF(SQL, \"sakilaparam.jrxml\", Params, \"sakilaparam.pdf\")\n"+"        \n"+"    DBM.CloseSQL(SQL)\n"+"    StartMessageLoop\n"+"End Sub");
 //BA.debugLineNum = 287;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code7",_code7)));
 //BA.debugLineNum = 289;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr5","ABPDFBox")));
 //BA.debugLineNum = 291;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par5","With this library you can print PDF files (either by showing a dialogbox or directly to a specified printer).")));
 //BA.debugLineNum = 292;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par6","Usage in a Non UI App:")));
 //BA.debugLineNum = 294;BA.debugLine="Dim code8 As String = $\"Sub Process_Globals     D";
_code8 = ("Sub Process_Globals\n"+"    Dim PDF As ABPDFBox\n"+"End Sub");
 //BA.debugLineNum = 298;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code8",_code8)));
 //BA.debugLineNum = 300;BA.debugLine="Dim code9 As String = $\"Sub AppStart (Args() As S";
_code9 = ("Sub AppStart (Args() As String)\n"+"    PDF.Initialize(\"DONATORKEY\")\n"+"    // also check out PDF.PrintEx if you want to set margins, or the page size,...\n"+"    PDF.Print(\"Z:\\\", \"pi3.pdf\", \"3005ci\",2, True)\n"+"    StartMessageLoop\n"+"End Sub");
 //BA.debugLineNum = 307;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code9",_code9)));
 //BA.debugLineNum = 309;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par7","Usage in a UI App:")));
 //BA.debugLineNum = 311;BA.debugLine="Dim code10 As String = $\"Sub Process_Globals";
_code10 = ("Sub Process_Globals\n"+"    Private fx As JFX\n"+"    Private MainForm As Form\n"+"    Dim PDF As ABPDFBox\n"+"    Private Button1 As Button\n"+"End Sub");
 //BA.debugLineNum = 318;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code10",_code10)));
 //BA.debugLineNum = 320;BA.debugLine="Dim code11 As String = $\"Sub AppStart (Form1 As F";
_code11 = ("Sub AppStart (Form1 As Form, Args() As String)\n"+"    MainForm = Form1\n"+"    MainForm.RootPane.LoadLayout(\"1\") //Load the layout file.\n"+"    MainForm.Show\n"+"    \n"+"    PDF.Initialize(\"DONATORKEY\")\n"+"    PDF.PrintWithDialog(\"Z:\\\", \"pi3.pdf\") \n"+"End Sub");
 //BA.debugLineNum = 329;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code11",_code11)));
 //BA.debugLineNum = 332;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 334;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 337;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 339;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 340;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 19;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 21;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 343;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 344;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 345;BA.debugLine="If Action = \"FirebaseStor\" Then Return";
if ((_action).equals("FirebaseStor")) { 
if (true) return "";};
 //BA.debugLineNum = 346;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 347;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 348;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 349;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 351;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 352;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 353;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 355;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 356;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 56;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 57;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 58;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 59;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 60;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 61;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 62;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 64;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 65;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 66;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 67;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 69;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 71;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 73;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 74;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 75;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 77;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 81;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 358;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 359;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 360;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 361;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 362;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 363;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 24;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 25;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 26;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 27;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 28;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 30;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 31;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 32;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 33;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 37;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 38;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 40;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 42;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 45;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 47;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 49;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 52;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 53;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
