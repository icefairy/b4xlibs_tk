package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class helpergeneratorpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.helpergeneratorpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.helpergeneratorpage.class).invoke(this, new Object[] {null});
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
 //BA.debugLineNum = 103;BA.debugLine="page.PageTitle = \"ABMGenerator\"";
_page.PageTitle = "ABMGenerator";
 //BA.debugLineNum = 104;BA.debugLine="page.PageDescription = \"The genrator helper\"";
_page.PageDescription = "The genrator helper";
 //BA.debugLineNum = 105;BA.debugLine="page.PageHTMLName = \"abmaterial-generator.html\"";
_page.PageHTMLName = "abmaterial-generator.html";
 //BA.debugLineNum = 106;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 107;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 108;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 109;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 111;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMGenerator\"";
_abmshared._buildnavigationbar(_page,"ABMGenerator","../images/logo.png","","Helpers","ABMGenerator");
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"HelperGeneratorPage\"";
_name = "HelperGeneratorPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
anywheresoftware.b4a.objects.collections.List _headers = null;
anywheresoftware.b4a.objects.collections.List _codes = null;
anywheresoftware.b4a.objects.collections.List _descriptions = null;
String _desc1 = "";
String _desc2 = "";
String _desc3 = "";
String _desc4 = "";
String _desc5 = "";
String _desc6 = "";
String _desc7 = "";
String _desc8 = "";
String _desc9 = "";
String _desc10 = "";
String _code1 = "";
 //BA.debugLineNum = 123;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 125;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 128;BA.debugLine="page.CellR(1,1).AddComponent(ABMShared.BuildParag";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","The ABMGenerator helper is a tool to generate B4J code from a simple list of parameters.  Writing only a couple of lines will generate hundreds of lines of B4J code ready to use.")));
 //BA.debugLineNum = 129;BA.debugLine="page.CellR(0,1).AddComponent(ABMShared.BuildParag";
_page.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","It can currently generate code for CRUD modal sheets and MessageBoxes, but this will be expanded in future versions. The code is generated in the .txt files you specify, so you can then copy and paste it in your project.")));
 //BA.debugLineNum = 132;BA.debugLine="page.CellR(1,1).AddComponent(ABMShared.BuildHeade";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","The methods you can use:")));
 //BA.debugLineNum = 134;BA.debugLine="Dim Headers, codes, Descriptions As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
_codes = new anywheresoftware.b4a.objects.collections.List();
_descriptions = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 135;BA.debugLine="Headers.Initialize2(Array As String(\"Method\", \"De";
_headers.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Method","Description"}));
 //BA.debugLineNum = 136;BA.debugLine="codes.Initialize2(Array As String(\"Set01FieldName";
_codes.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Set01FieldNames","Set02RowOffsetSizes","Set03LabelTexts","Set04ComponentTypes","Set05DefaultValue","Set06ComboQueries","Set07ComboLists","Set08ValidationMethods","Set09Enableds","Set10UseInUpdates"}));
 //BA.debugLineNum = 138;BA.debugLine="Dim desc1 As String = $\"Array as String (real nam";
_desc1 = ("Array as String (real names in your database!){BR}\n"+"Very important! The order of the visible fields MUST be in the order they need to appear in the ModalSheet:{BR}\n"+"{BR}\n"+"Per row, Cells from left to right:{BR}\n"+"{BR}\n"+"e.g. |   field1   |  field2             |{BR}\n"+"     |   field3                         |{BR}\n"+"     |   field4   |  field5   | field6  |{BR}\n"+"     |   field7                         |{BR}\n"+"{BR}\n"+"Becomes: Array As String(notvisible1, notvisible2, field1, field2, field3, field4, field5, field6, field7)");
 //BA.debugLineNum = 149;BA.debugLine="Dim desc2 As String = $\"Array As String, allowed";
_desc2 = ("Array As String, allowed formats:{BR}\n"+"R:O:S where R=Row, O=offset, S=size (Row starts from 1, All O+S in one row must add-up To 12!){BR}\n"+"R:OS:OM:OL:SS:SM:SL where R=Row, OS=offsetSmall, OM=offsetMedium, OL=offsetLarge, SS=sizeSmall, SM=sizeMedium, SL=sizeLarge{BR}\n"+"Empty string if not visible, e.g. an ID field");
 //BA.debugLineNum = 153;BA.debugLine="Dim desc3 As String = $\"Array as string, labels o";
_desc3 = ("Array as string, labels on the component.{BR}\n"+"Note: in case of a switch the format is:{BR}\n"+"\"OnText,offText\"");
 //BA.debugLineNum = 156;BA.debugLine="Dim desc4 As String = $\"Array as int, using CRUDT";
_desc4 = ("Array as int, using CRUDTYPE constants");
 //BA.debugLineNum = 157;BA.debugLine="Dim desc5 As String = $\"Array as string, default";
_desc5 = ("Array as string, default value when the user creates a new record.{BR}\n"+"Notes: {BR}\n"+"    For Combos this must be the returnId (int, most of the time a database id, eg \"123\")!{BR}\n"+"    For Switches/Checkboxes this must be \"true\" or \"false\"{BR}\n"+"    For Dates must be a long (e.g. 145671250000), a date in the format you specified (e.g. '22-01-2016T10:20:00') or you can use \"NOW\"");
 //BA.debugLineNum = 162;BA.debugLine="Dim desc6 As String = $\"Array of String, combo qu";
_desc6 = ("Array of String, combo query in format: SELECT returnId, TextToShowInCombo FROM Table WHERE your_where ORDER BY order {BR}\n"+"where can contain variables that are other fields using '$', e.g. a combo that has other values depending on who was selected in the {BR}\n"+"person combo.{BR}\n"+" {BR}\n"+"You have a combo prsId to pick a person:{BR}\n"+" {BR}\n"+"SELECT tPersons.prsID, tPersons.prsName {BR}\n"+"    FROM tPersons {BR}\n"+"    ORDER BY tPersons.prsName;{BR}\n"+"{BR}\n"+"You have a combo comId to pick a command and depends on who the person is:{BR}\n"+" {BR}\n"+"SELECT tCommands.comId, tCommands.comName {BR}\n"+"    FROM tCommands INNER JOIN tCommandsPersons ON tCommand.comId = tCommandPersons.comprsComId {BR}\n"+"    WHERE tCommandPersons.comprsPrsId=$prsId$ {BR}\n"+"    ORDER BY tCommands.comName{BR}\n"+"{BR}    \n"+"The value of what is in the prsId combo will be used in the query of the comId combo. ");
 //BA.debugLineNum = 180;BA.debugLine="Dim desc7 As String = $\"Array of Maps, where key";
_desc7 = ("Array of Maps, where key = returnId and value = TextToShowInCombo {BR}\n"+"Use Null if not applicable");
 //BA.debugLineNum = 182;BA.debugLine="Dim desc8 As String = $\"Array of strings, contain";
_desc8 = ("Array of strings, containing the Method names to validate an input field {BR}\n"+"Methods will be autogenerated as:{BR}\n"+"{BR}\n"+"MethodName(value as String) as Boolean");
 //BA.debugLineNum = 186;BA.debugLine="Dim desc9 As String = $\"Array of booleans, contai";
_desc9 = ("Array of booleans, containing booleans with enabled or not");
 //BA.debugLineNum = 187;BA.debugLine="Dim desc10 As String = $\"Array of booleans, conta";
_desc10 = ("Array of booleans, containing booleans if it should overwrite the field when updating a record	{BR} \n"+"Note: the ID field will never be overwritten!");
 //BA.debugLineNum = 190;BA.debugLine="Descriptions.Initialize2(Array As String(desc1, d";
_descriptions.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{_desc1,_desc2,_desc3,_desc4,_desc5,_desc6,_desc7,_desc8,_desc9,_desc10}));
 //BA.debugLineNum = 191;BA.debugLine="page.CellR(1,1).AddComponent(ABMShared.BuildParam";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparamtable2(_page,"param2",_headers,_codes,_descriptions)));
 //BA.debugLineNum = 193;BA.debugLine="page.CellR(1,1).AddComponent(ABMShared.BuildParag";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","For example this code will generate all the code you can see in the pdf for a CRUD modal sheet. (Because it uses a DateTimeScroller, you can also define the localization here, e.g. here in Dutch). The yellow text marks the code I needed to change to modify it to the clients specific wishes.")));
 //BA.debugLineNum = 195;BA.debugLine="Dim code1 As String = $\"Dim MyEventDef As ABMGene";
_code1 = ("Dim MyEventDef As ABMGeneratorCRUDDefinition\n"+"MyEventDef.Initialize(\"evID\", \"tEvent\", \"Vul alle velden van deze event in.\", \"Bewaren\", \"Annuleren\", \"Ja\", \"Nee\", \"Sluiten\", \"Ben je zeker dat je deze event wilt wissen?\", \"Gelieve eerst alle velden in te vullen!\")\n"+"MyEventDef.DateTimeScroller.Mode = ABM.DATETIMESCROLLER_MODE_CLICKPICK\n"+"MyEventDef.DateTimeScroller.SQLSaveDateTimeFormat = \"yyyy-MM-dd HH:mm:ss\"	\n"+"MyEventDef.DateTimeScroller.TitleDateFormat = \"DD\" \n"+"MyEventDef.DateTimeScroller.ReturnDateFormat = \"dd/mm/yy\" \n"+"MyEventDef.DateTimeScroller.DateOrder = \"ddMy\" \n"+"MyEventDef.DateTimeScroller.DateMonthNames = \"['Januari','Februari','Maart','April','Mei','Juni', 'July','Augustus','September','Oktober','November','December']\" \n"+"MyEventDef.DateTimeScroller.DateMonthNamesShort = \"['Jan', 'Feb', 'Maa', 'Apr', 'Mai', 'Jun', 'Jul', 'Aug', 'Sep', 'Okt', 'Nov', 'Dec']\" \n"+"MyEventDef.DateTimeScroller.DateDayNames = \"['Zondag', 'Maandag', 'Dinsdag', 'Woensdag', 'Donderdag', 'Vrijdag', 'Zaterdag']\" \n"+"MyEventDef.DateTimeScroller.DateDayNamesShort = \"['Zon', 'Maa', 'Din', 'Woe', 'Don', 'Vri', 'Zat']\" \n"+"MyEventDef.DateTimeScroller.DateMonthText = \"Maand\" \n"+"MyEventDef.DateTimeScroller.DateDayText = \"Dag\" \n"+"MyEventDef.DateTimeScroller.DateYearText = \"Jaar\" \n"+"MyEventDef.DateTimeScroller.PickText = \"Bewaar\" \n"+"MyEventDef.DateTimeScroller.CancelText = \"Sluiten\" \n"+"\n"+"Dim cmbStatus As String = \"SELECT evstatID, evstatOms FROM tEventStatus ORDER BY evstatOms\"\n"+"Dim cmbType As String = \"SELECT tEventType.evtypID, tEventType.evtypOms FROM tEventType INNER JOIN tEventType_Persoon ON tEventType.evtypID = tEventType_Persoon.evtypprsEvtypID WHERE (((tEventType_Persoon.evtypprsPrsID)=1)) ORDER BY tEventType.evtypOms\"\n"+"Dim cmbTodoBy As String = \"SELECT prsID, prsNaam FROM tPersoon ORDER BY prsNaam\"\n"+"	\n"+"MyEventDef.Set01FieldNames(       Array As String (\"evID\"           , \"evCreator\"           , \"evContact\"    , \"evDatum\"            , \"evStatus\"       , \"evType\"        , \"evToDoBy\"          , \"evToDoDatum\"      , \"evOnderwerp\", \"evAandacht\"   , \"evHot\"        , \"evCommentaar\"   , \"evAfsluitDatum\"    ))\n"+"MyEventDef.Set02RowOffsetSizes(   Array As String (\"\"               , \"\"                    , \"\"             , \"\"                   , \"1:0:12\"         , \"2:0:12\"        , \"3:0:12\"            , \"4:0:12\"           , \"5:0:12\"     , \"6:0:6\"        , \"6:0:6\"        , \"7:0:12\"         , \"\"                  ))\n"+"MyEventDef.Set03LabelTexts(       Array As String (\"\"               , \"\"                    , \"\"             , \"\"                   , \"Status\"               , \"Actie\"         , \"Uit te voeren door\", \"Uitvoer datum\"    , \"Onderwerp\"  , \"Aandacht\"     , \"Hot,\"         , \"Commentaar\"     , \"\"                  ))\n"+"MyEventDef.Set04ComponentTypes(   Array As Int    (ABM.GEN_NONE     , ABM.GEN_NUMBER        , ABM.GEN_NUMBER , ABM.GEN_DATE_SCROLL  , ABM.GEN_COMBOSQL , ABM.GEN_COMBOSQL, ABM.GEN_COMBOSQL    , ABM.GEN_DATE_SCROLL, ABM.GEN_TEXT , ABM.GEN_NUMBER , ABM.GEN_SWITCH , ABM.GEN_TEXTAREA , ABM.GEN_DATE_SCROLL ))\n"+"MyEventDef.Set05DefaultValues(    Array As String (\"\"               , \"1\"                   , \"1\"            , \"NOW\"                , \"2\"              , \"1\"             , \"1\"                 , \"NOW\"              , \"\"           , \"0\"            , \"false\"        , \"\"               , \"NOW\"               ))	\n"+"MyEventDef.Set06ComboQueries(     Array As String (\"\"               , \"\"                    , \"\"             , \"\"                   , cmbStatus        , cmbType         , cmbTodoBy           , \"\"                 , \"\"           , \"\"             , \"\"             , \"\"               , \"\"                  ))\n"+"MyEventDef.Set07ComboLists(       Array As Map    (null             , null                  , null           , null                 , null             , null            , null                , null               , null         , null           , null           , null             , null                ))\n"+"MyEventDef.Set08ValidationMethods(Array As String (\"\"               , \"\"                    , \"\"             , \"\"                   , \"NotMin1\"        , \"NotMin1\"       , \"NotMin1\"           , \"\"                 , \"NotEmpty\"   , \"\"             , \"\"             , \"NotEmpty\"       , \"\"                  ))\n"+"MyEventDef.Set09Enableds(         Array As Boolean(False            , False                 , False          , False                , True             , True            , True                , True               , True         , True           , True           , True             , False               ))\n"+"MyEventDef.Set10UseInUpdates(     Array As Boolean(False            , False                 , False          , False                , True             , True            , True                , True               , True         , True           , True           , True             , False               ))\n"+"Generator.GenerateCRUDSheet(File.DirApp, \"EventNotes\", MyEventDef, ABM.MODALSHEET_SIZE_FULL)	");
 //BA.debugLineNum = 228;BA.debugLine="page.CellR(0,1).AddComponent(ABMShared.BuildCodeB";
_page.CellR((int) (0),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code1)));
 //BA.debugLineNum = 230;BA.debugLine="page.CellR(1,1).AddComponent(ABMShared.BuildParag";
_page.CellR((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","The generated code: {AL}http://gorgeousapps.com/Generator.pdf{AT}Generated code{/AL}")));
 //BA.debugLineNum = 233;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 235;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 238;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 240;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 241;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 244;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 245;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 246;BA.debugLine="If Action = \"ABMGenerator\" Then Return";
if ((_action).equals("ABMGenerator")) { 
if (true) return "";};
 //BA.debugLineNum = 247;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 248;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 249;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 250;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 252;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 253;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 254;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 256;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 259;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 260;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 261;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 262;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 263;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 264;BA.debugLine="End Sub";
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
