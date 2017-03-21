package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compcheckboxpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compcheckboxpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compcheckboxpage.class).invoke(this, new Object[] {null});
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
 //BA.debugLineNum = 104;BA.debugLine="page.PageTitle = \"ABMCheckbox\"";
_page.PageTitle = "ABMCheckbox";
 //BA.debugLineNum = 105;BA.debugLine="page.PageDescription = \"The checkbox component \"";
_page.PageDescription = "The checkbox component ";
 //BA.debugLineNum = 106;BA.debugLine="page.PageHTMLName = \"abmaterial-checkbox.html\"";
_page.PageHTMLName = "abmaterial-checkbox.html";
 //BA.debugLineNum = 107;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 108;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 109;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 110;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 112;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMCheckbox\",";
_abmshared._buildnavigationbar(_page,"ABMCheckbox","../images/logo.png","","Controls","ABMCheckbox");
 //BA.debugLineNum = 115;BA.debugLine="page.AddRows(7,True,\"\").AddCells12(1,\"\")";
_page.AddRows((int) (7),__c.True,"").AddCells12((int) (1),"");
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
public String  _chk1_clicked(String _target) throws Exception{
String _checked = "";
com.ab.abmaterial.ABMCheckbox _chk1 = null;
 //BA.debugLineNum = 228;BA.debugLine="Sub chk1_Clicked(Target As String)";
 //BA.debugLineNum = 229;BA.debugLine="Dim checked As String";
_checked = "";
 //BA.debugLineNum = 230;BA.debugLine="Dim chk1 As ABMCheckbox = page.Component(\"chk1\")";
_chk1 = (com.ab.abmaterial.ABMCheckbox)(_page.Component("chk1"));
 //BA.debugLineNum = 231;BA.debugLine="If chk1.State Then";
if (_chk1.getState()) { 
 //BA.debugLineNum = 232;BA.debugLine="checked= \"checked\"";
_checked = "checked";
 }else {
 //BA.debugLineNum = 234;BA.debugLine="checked= \"unchecked\"";
_checked = "unchecked";
 };
 //BA.debugLineNum = 236;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 237;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Checkbox is "+_checked,(int) (5000));
 //BA.debugLineNum = 238;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompCheckboxPage\"";
_name = "CompCheckboxPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMCheckbox _chk1 = null;
com.ab.abmaterial.ABMCheckbox _chk2 = null;
com.ab.abmaterial.ABMCheckbox _chk3 = null;
com.ab.abmaterial.ABMCheckbox _chk4 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code2 = null;
 //BA.debugLineNum = 124;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 126;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 129;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Use checkboxes when looking for yes or no answers.")));
 //BA.debugLineNum = 132;BA.debugLine="Dim chk1 As ABMCheckbox";
_chk1 = new com.ab.abmaterial.ABMCheckbox();
 //BA.debugLineNum = 133;BA.debugLine="chk1.Initialize(page, \"chk1\", \"Checkbox starting";
_chk1.Initialize(_page,"chk1","Checkbox starting unchecked",__c.False,"");
 //BA.debugLineNum = 134;BA.debugLine="page.Cell(2,1).AddComponent(chk1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_chk1));
 //BA.debugLineNum = 136;BA.debugLine="Dim chk2 As ABMCheckbox";
_chk2 = new com.ab.abmaterial.ABMCheckbox();
 //BA.debugLineNum = 137;BA.debugLine="chk2.Initialize(page, \"chk2\", \"Checkbox starting";
_chk2.Initialize(_page,"chk2","Checkbox starting checked",__c.True,"");
 //BA.debugLineNum = 138;BA.debugLine="page.Cell(3,1).AddComponent(chk2)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_chk2));
 //BA.debugLineNum = 140;BA.debugLine="Dim chk3 As ABMCheckbox";
_chk3 = new com.ab.abmaterial.ABMCheckbox();
 //BA.debugLineNum = 141;BA.debugLine="chk3.Initialize(page, \"chk3\", \"Checkbox disabled\"";
_chk3.Initialize(_page,"chk3","Checkbox disabled",__c.True,"");
 //BA.debugLineNum = 142;BA.debugLine="chk3.Enabled = False";
_chk3.Enabled = __c.False;
 //BA.debugLineNum = 143;BA.debugLine="page.Cell(4,1).AddComponent(chk3)";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_chk3));
 //BA.debugLineNum = 145;BA.debugLine="Dim chk4 As ABMCheckbox";
_chk4 = new com.ab.abmaterial.ABMCheckbox();
 //BA.debugLineNum = 146;BA.debugLine="chk4.Initialize(page, \"chk4\", \"Checkbox filled in";
_chk4.Initialize(_page,"chk4","Checkbox filled in",__c.True,"");
 //BA.debugLineNum = 147;BA.debugLine="chk4.IsFilled = True";
_chk4.IsFilled = __c.True;
 //BA.debugLineNum = 148;BA.debugLine="page.Cell(5,1).AddComponent(chk4)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_chk4));
 //BA.debugLineNum = 151;BA.debugLine="Dim code As StringBuilder";
_code = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 152;BA.debugLine="code.Initialize";
_code.Initialize();
 //BA.debugLineNum = 153;BA.debugLine="code.Append(\"//create checkboxes\").Append(CRLF)";
_code.Append("//create checkboxes").Append(__c.CRLF);
 //BA.debugLineNum = 154;BA.debugLine="code.Append(\"Dim chk1 As ABMCheckbox\").Append(CRL";
_code.Append("Dim chk1 As ABMCheckbox").Append(__c.CRLF);
 //BA.debugLineNum = 155;BA.debugLine="code.Append(\"chk1.Initialize(page, \"\"chk1\"\", \"\"Ch";
_code.Append("chk1.Initialize(page, \"chk1\", \"Checkbox starting unchecked\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 156;BA.debugLine="code.Append(\"page.Cell(2,1).AddComponent(chk1)\").";
_code.Append("page.Cell(2,1).AddComponent(chk1)").Append(__c.CRLF);
 //BA.debugLineNum = 157;BA.debugLine="code.Append(\"\").Append(CRLF)";
_code.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 158;BA.debugLine="code.Append(\"Dim chk2 As ABMCheckbox\").Append(CRL";
_code.Append("Dim chk2 As ABMCheckbox").Append(__c.CRLF);
 //BA.debugLineNum = 159;BA.debugLine="code.Append(\"chk2.Initialize(page, \"\"chk2\"\", \"\"Ch";
_code.Append("chk2.Initialize(page, \"chk2\", \"Checkbox starting checked\", True, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 160;BA.debugLine="code.Append(\"page.Cell(3,1).AddComponent(chk2)\").";
_code.Append("page.Cell(3,1).AddComponent(chk2)").Append(__c.CRLF);
 //BA.debugLineNum = 161;BA.debugLine="code.Append(\"\").Append(CRLF)";
_code.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 162;BA.debugLine="code.Append(\"Dim chk3 As ABMCheckbox\").Append(CRL";
_code.Append("Dim chk3 As ABMCheckbox").Append(__c.CRLF);
 //BA.debugLineNum = 163;BA.debugLine="code.Append(\"chk3.Initialize(page, \"\"chk3\"\", \"\"Ch";
_code.Append("chk3.Initialize(page, \"chk3\", \"Checkbox disabled\", True, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 164;BA.debugLine="code.Append(\"chk3.Disabled = True\").Append(CRLF)";
_code.Append("chk3.Disabled = True").Append(__c.CRLF);
 //BA.debugLineNum = 165;BA.debugLine="code.Append(\"page.Cell(4,1).AddComponent(chk3)\").";
_code.Append("page.Cell(4,1).AddComponent(chk3)").Append(__c.CRLF);
 //BA.debugLineNum = 166;BA.debugLine="code.Append(\"\").Append(CRLF)";
_code.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 167;BA.debugLine="code.Append(\"Dim chk4 As ABMCheckbox\").Append(CRL";
_code.Append("Dim chk4 As ABMCheckbox").Append(__c.CRLF);
 //BA.debugLineNum = 168;BA.debugLine="code.Append(\"chk4.Initialize(page, \"\"chk4\"\", \"\"Ch";
_code.Append("chk4.Initialize(page, \"chk4\", \"Checkbox filled in\", True, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 169;BA.debugLine="code.Append(\"chk4.IsFilled = True\").Append(CRLF)";
_code.Append("chk4.IsFilled = True").Append(__c.CRLF);
 //BA.debugLineNum = 170;BA.debugLine="code.Append(\"page.Cell(5,1).AddComponent(chk4)\").";
_code.Append("page.Cell(5,1).AddComponent(chk4)").Append(__c.CRLF);
 //BA.debugLineNum = 172;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code",_code)));
 //BA.debugLineNum = 175;BA.debugLine="Dim code2 As StringBuilder";
_code2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 176;BA.debugLine="code2.Initialize";
_code2.Initialize();
 //BA.debugLineNum = 177;BA.debugLine="code2.Append(\"Sub chk1_Clicked(Target as String)\"";
_code2.Append("Sub chk1_Clicked(Target as String)").Append(__c.CRLF);
 //BA.debugLineNum = 178;BA.debugLine="code2.Append(\"   Dim checked As String\").Append(C";
_code2.Append("   Dim checked As String").Append(__c.CRLF);
 //BA.debugLineNum = 179;BA.debugLine="code2.Append(\"   Dim chk1 As ABMCheckbox = page.C";
_code2.Append("   Dim chk1 As ABMCheckbox = page.Component(\"chk1\")").Append(__c.CRLF);
 //BA.debugLineNum = 180;BA.debugLine="code2.Append(\"   If chk1.State Then\").Append(CRLF";
_code2.Append("   If chk1.State Then").Append(__c.CRLF);
 //BA.debugLineNum = 181;BA.debugLine="code2.Append(\"      checked= \"\"checked\"\"\").Append";
_code2.Append("      checked= \"checked\"").Append(__c.CRLF);
 //BA.debugLineNum = 182;BA.debugLine="code2.Append(\"   Else\").Append(CRLF)";
_code2.Append("   Else").Append(__c.CRLF);
 //BA.debugLineNum = 183;BA.debugLine="code2.Append(\"      checked= \"\"unchecked\"\"\").Appe";
_code2.Append("      checked= \"unchecked\"").Append(__c.CRLF);
 //BA.debugLineNum = 184;BA.debugLine="code2.Append(\"   End If\").Append(CRLF)";
_code2.Append("   End If").Append(__c.CRLF);
 //BA.debugLineNum = 185;BA.debugLine="code2.Append(\"   Dim myTexts, myReturns As List\")";
_code2.Append("   Dim myTexts, myReturns As List").Append(__c.CRLF);
 //BA.debugLineNum = 186;BA.debugLine="code2.Append(\"   myTexts.Initialize\").Append(CRLF";
_code2.Append("   myTexts.Initialize").Append(__c.CRLF);
 //BA.debugLineNum = 187;BA.debugLine="code2.Append(\"   myReturns.Initialize\").Append(CR";
_code2.Append("   myReturns.Initialize").Append(__c.CRLF);
 //BA.debugLineNum = 188;BA.debugLine="code2.Append(\"   myToastId = myToastId + 1\").Appe";
_code2.Append("   myToastId = myToastId + 1").Append(__c.CRLF);
 //BA.debugLineNum = 189;BA.debugLine="code2.Append(\"   page.ShowToast(\"\"toast\"\" & myToa";
_code2.Append("   page.ShowToast(\"toast\" & myToastId, \"toastred\", \"Checkbox is \" & checked, 5000, myTexts, myReturns)").Append(__c.CRLF);
 //BA.debugLineNum = 190;BA.debugLine="code2.Append(\"End Sub\").Append(CRLF)";
_code2.Append("End Sub").Append(__c.CRLF);
 //BA.debugLineNum = 192;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code2",_code2)));
 //BA.debugLineNum = 195;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 197;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 200;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 202;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 203;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 206;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 207;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 208;BA.debugLine="If Action = \"ABMCheckbox\" Then Return";
if ((_action).equals("ABMCheckbox")) { 
if (true) return "";};
 //BA.debugLineNum = 209;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 210;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 211;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 212;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 214;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 215;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 216;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 218;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 219;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 221;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 222;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 223;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 224;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 225;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 226;BA.debugLine="End Sub";
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
