package abmfeedback.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class abmshared extends Object{
public static abmshared mostCurrent = new abmshared();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.StandardBA("abmfeedback.ab.com", "abmfeedback.ab.com.abmshared", null);
		ba.loadHtSubs(abmshared.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "abmfeedback.ab.com.abmshared", ba);
		}
	}
    public static Class<?> getObject() {
		return abmshared.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static com.ab.abmaterial.ABMTheme _mytheme = null;
public static com.ab.abmaterial.ABMaterial _abm = null;
public static boolean _needsauthorization = false;
public static String _appversion = "";
public static String _apppublishedstarturl = "";
public static String _appname = "";
public static anywheresoftware.b4a.objects.collections.Map _cachedpages = null;
public static int _cachescavengeperiodseconds = 0;
public static int _sessionmaxinactiveintervalseconds = 0;
public static abmfeedback.ab.com.main _main = null;
public static abmfeedback.ab.com.dbm _dbm = null;
public static com.ab.abmaterial.ABMImage  _buildimage(com.ab.abmaterial.ABMPage _page,String _id,String _image,double _opacity,String _caption) throws Exception{
com.ab.abmaterial.ABMImage _img = null;
 //BA.debugLineNum = 164;BA.debugLine="public Sub BuildImage(page As ABMPage, id As Strin";
 //BA.debugLineNum = 165;BA.debugLine="Dim img As ABMImage";
_img = new com.ab.abmaterial.ABMImage();
 //BA.debugLineNum = 166;BA.debugLine="img.Initialize(page, id, image,opacity)";
_img.Initialize(_page,_id,_image,_opacity);
 //BA.debugLineNum = 167;BA.debugLine="img.IsMaterialBoxed = True";
_img.IsMaterialBoxed = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 168;BA.debugLine="img.IsResponsive = True";
_img.IsResponsive = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 169;BA.debugLine="img.Caption = Caption";
_img.Caption = _caption;
 //BA.debugLineNum = 170;BA.debugLine="Return img";
if (true) return _img;
 //BA.debugLineNum = 171;BA.debugLine="End Sub";
return null;
}
public static String  _buildnavigationbar(com.ab.abmaterial.ABMPage _page,String _title,String _logo,String _activetopreturnname,String _activesidereturnname,String _activesidesubreturnname) throws Exception{
com.ab.abmaterial.ABMImage _sbtopimg = null;
 //BA.debugLineNum = 89;BA.debugLine="Sub BuildNavigationBar(page As ABMPage, Title As S";
 //BA.debugLineNum = 92;BA.debugLine="Dim sbtopimg As ABMImage";
_sbtopimg = new com.ab.abmaterial.ABMImage();
 //BA.debugLineNum = 93;BA.debugLine="sbtopimg.Initialize(page, \"sbtopimg\", logo, 1)";
_sbtopimg.Initialize(_page,"sbtopimg",_logo,1);
 //BA.debugLineNum = 94;BA.debugLine="sbtopimg.SetFixedSize(236, 49)";
_sbtopimg.SetFixedSize((int) (236),(int) (49));
 //BA.debugLineNum = 96;BA.debugLine="page.NavigationBar.Initialize(page, \"nav1\", ABM.S";
_page.NavigationBar().Initialize(_page,"nav1",_abm.SIDEBAR_MANUAL_HIDEMEDIUMSMALL,_title,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.True,(int) (300),(int) (48),(com.ab.abmaterial.ABMComponent)(_sbtopimg),_abm.COLLAPSE_ACCORDION,"nav1theme");
 //BA.debugLineNum = 97;BA.debugLine="page.PaddingBottom = 100";
_page.PaddingBottom = (int) (100);
 //BA.debugLineNum = 99;BA.debugLine="page.NavigationBar.ActiveTopReturnName = ActiveTo";
_page.NavigationBar().ActiveTopReturnName = _activetopreturnname;
 //BA.debugLineNum = 100;BA.debugLine="page.NavigationBar.ActiveSideReturnName = ActiveS";
_page.NavigationBar().ActiveSideReturnName = _activesidereturnname;
 //BA.debugLineNum = 101;BA.debugLine="page.NavigationBar.ActiveSideSubReturnName = Acti";
_page.NavigationBar().ActiveSideSubReturnName = _activesidesubreturnname;
 //BA.debugLineNum = 103;BA.debugLine="page.NavigationBar.AddTopItem(\"LogOff\", \"\", \"mdi-";
_page.NavigationBar().AddTopItem("LogOff","","mdi-action-exit-to-app","",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 105;BA.debugLine="page.NavigationBar.AddSideBarItem(\"Cases\", \"Overv";
_page.NavigationBar().AddSideBarItem("Cases","Overview Cases","mdi-action-dashboard","../OverviewCasesPage");
 //BA.debugLineNum = 106;BA.debugLine="page.NavigationBar.AddSideBarDivider(\"\")";
_page.NavigationBar().AddSideBarDivider("");
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public static com.ab.abmaterial.ABMLabel  _buildparagraph(com.ab.abmaterial.ABMPage _page,String _id,String _text) throws Exception{
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 144;BA.debugLine="public Sub BuildParagraph(page As ABMPage, id As S";
 //BA.debugLineNum = 145;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 146;BA.debugLine="lbl.Initialize(page, id, Text , ABM.SIZE_PARAGRAP";
_lbl.Initialize(_page,_id,_text,_abm.SIZE_PARAGRAPH,anywheresoftware.b4a.keywords.Common.False,"");
 //BA.debugLineNum = 147;BA.debugLine="Return lbl";
if (true) return _lbl;
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
return null;
}
public static com.ab.abmaterial.ABMLabel  _buildparagraphbq(com.ab.abmaterial.ABMPage _page,String _id,String _text) throws Exception{
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 150;BA.debugLine="public Sub BuildParagraphBQ(page As ABMPage, id As";
 //BA.debugLineNum = 151;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 152;BA.debugLine="lbl.Initialize(page, id, Text , ABM.SIZE_PARAGRAP";
_lbl.Initialize(_page,_id,_text,_abm.SIZE_PARAGRAPH,anywheresoftware.b4a.keywords.Common.False,"lightblue");
 //BA.debugLineNum = 153;BA.debugLine="lbl.IsBlockQuote = True";
_lbl.IsBlockQuote = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 154;BA.debugLine="Return lbl";
if (true) return _lbl;
 //BA.debugLineNum = 155;BA.debugLine="End Sub";
return null;
}
public static com.ab.abmaterial.ABMLabel  _buildparagraphbqwithzdepth(com.ab.abmaterial.ABMPage _page,String _id,String _text) throws Exception{
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 157;BA.debugLine="public Sub BuildParagraphBQWithZDepth(page As ABMP";
 //BA.debugLineNum = 158;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 159;BA.debugLine="lbl.Initialize(page, id, Text , ABM.SIZE_PARAGRAP";
_lbl.Initialize(_page,_id,_text,_abm.SIZE_PARAGRAPH,anywheresoftware.b4a.keywords.Common.False,"lightbluezdepth");
 //BA.debugLineNum = 160;BA.debugLine="lbl.IsBlockQuote = True";
_lbl.IsBlockQuote = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 161;BA.debugLine="Return lbl";
if (true) return _lbl;
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return null;
}
public static String  _buildtheme(String _themename) throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Sub BuildTheme(themeName As String)";
 //BA.debugLineNum = 41;BA.debugLine="MyTheme.Initialize(themeName)";
_mytheme.Initialize(_themename);
 //BA.debugLineNum = 44;BA.debugLine="MyTheme.Page.BackColor = ABM.COLOR_BLUEGREY";
_mytheme.Page.BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 45;BA.debugLine="MyTheme.Page.BackColorIntensity = ABM.INTENSITY_L";
_mytheme.Page.BackColorIntensity = _abm.INTENSITY_LIGHTEN4;
 //BA.debugLineNum = 48;BA.debugLine="MyTheme.AddNavigationBarTheme(\"nav1theme\")";
_mytheme.AddNavigationBarTheme("nav1theme");
 //BA.debugLineNum = 49;BA.debugLine="MyTheme.NavigationBar(\"nav1theme\").TopBarBackColo";
_mytheme.NavigationBar("nav1theme").TopBarBackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 52;BA.debugLine="MyTheme.AddLabelTheme(\"lightblue\")";
_mytheme.AddLabelTheme("lightblue");
 //BA.debugLineNum = 53;BA.debugLine="MyTheme.Label(\"lightblue\").ForeColor = ABM.COLOR_";
_mytheme.Label("lightblue").ForeColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 54;BA.debugLine="MyTheme.Label(\"lightblue\").ForeColorIntensity = A";
_mytheme.Label("lightblue").ForeColorIntensity = _abm.INTENSITY_DARKEN2;
 //BA.debugLineNum = 57;BA.debugLine="MyTheme.AddToastTheme(\"toastred\")";
_mytheme.AddToastTheme("toastred");
 //BA.debugLineNum = 58;BA.debugLine="MyTheme.Toast(\"toastred\").Rounded = True";
_mytheme.Toast("toastred").Rounded = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 59;BA.debugLine="MyTheme.Toast(\"toastred\").ActionForeColor = ABM.C";
_mytheme.Toast("toastred").ActionForeColor = _abm.COLOR_BLACK;
 //BA.debugLineNum = 60;BA.debugLine="MyTheme.Toast(\"toastred\").BackColor = ABM.COLOR_R";
_mytheme.Toast("toastred").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 62;BA.debugLine="MyTheme.AddToastTheme(\"toastgreen\")";
_mytheme.AddToastTheme("toastgreen");
 //BA.debugLineNum = 63;BA.debugLine="MyTheme.Toast(\"toastgreen\").Rounded = True";
_mytheme.Toast("toastgreen").Rounded = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 64;BA.debugLine="MyTheme.Toast(\"toastgreen\").ActionForeColor = ABM";
_mytheme.Toast("toastgreen").ActionForeColor = _abm.COLOR_BLACK;
 //BA.debugLineNum = 65;BA.debugLine="MyTheme.Toast(\"toastgreen\").BackColor = ABM.COLOR";
_mytheme.Toast("toastgreen").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 68;BA.debugLine="MyTheme.AddInputTheme(\"lightblue\")";
_mytheme.AddInputTheme("lightblue");
 //BA.debugLineNum = 69;BA.debugLine="MyTheme.Input(\"lightblue\").FocusForeColor = ABM.C";
_mytheme.Input("lightblue").FocusForeColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 70;BA.debugLine="MyTheme.Input(\"lightblue\").FocusForeColorIntensit";
_mytheme.Input("lightblue").FocusForeColorIntensity = _abm.INTENSITY_NORMAL;
 //BA.debugLineNum = 73;BA.debugLine="MyTheme.AddComboTheme(\"lightblue\")";
_mytheme.AddComboTheme("lightblue");
 //BA.debugLineNum = 74;BA.debugLine="MyTheme.Combo(\"lightblue\").FocusForeColor = ABM.C";
_mytheme.Combo("lightblue").FocusForeColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 75;BA.debugLine="MyTheme.Combo(\"lightblue\").FocusforeColorIntensit";
_mytheme.Combo("lightblue").FocusForeColorIntensity = _abm.INTENSITY_NORMAL;
 //BA.debugLineNum = 78;BA.debugLine="MyTheme.AddLabelTheme(\"lightblue\")";
_mytheme.AddLabelTheme("lightblue");
 //BA.debugLineNum = 79;BA.debugLine="MyTheme.Label(\"lightblue\").ForeColor = ABM.COLOR_";
_mytheme.Label("lightblue").ForeColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 80;BA.debugLine="MyTheme.Label(\"lightblue\").ForeColorIntensity = A";
_mytheme.Label("lightblue").ForeColorIntensity = _abm.INTENSITY_DARKEN2;
 //BA.debugLineNum = 84;BA.debugLine="MyTheme.AddLabelTheme(\"lightbluezdepth\")";
_mytheme.AddLabelTheme("lightbluezdepth");
 //BA.debugLineNum = 85;BA.debugLine="MyTheme.Label(\"lightbluezdepth\").ForeColor = ABM.";
_mytheme.Label("lightbluezdepth").ForeColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 86;BA.debugLine="MyTheme.Label(\"lightbluezdepth\").ZDepth = ABM.ZDE";
_mytheme.Label("lightbluezdepth").ZDepth = _abm.ZDEPTH_1;
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static String  _logoff(com.ab.abmaterial.ABMPage _page,String _myappname) throws Exception{
String _network = "";
String _name = "";
 //BA.debugLineNum = 111;BA.debugLine="Sub LogOff(page As ABMPage, myAppName As String)";
 //BA.debugLineNum = 112;BA.debugLine="Dim Network As String = page.ws.Session.GetAttrib";
_network = BA.ObjectToString(_page.ws.getSession().GetAttribute("authType"));
 //BA.debugLineNum = 113;BA.debugLine="Dim Name As String = page.ws.Session.GetAttribute";
_name = BA.ObjectToString(_page.ws.getSession().GetAttribute("authName"));
 //BA.debugLineNum = 114;BA.debugLine="Select Case Network";
switch (BA.switchObjectToInt(_network,"local",_abm.SOCIALOAUTH_FACEBOOK)) {
case 0: {
 //BA.debugLineNum = 118;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 119;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 120;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\"";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 121;BA.debugLine="page.ws.Session.SetAttribute(\"UserType\", \"\" )";
_page.ws.getSession().SetAttribute("UserType",(Object)(""));
 //BA.debugLineNum = 123;BA.debugLine="ABM.DeleteLogin(page, myAppName)";
_abm.DeleteLogin(_page,_myappname);
 //BA.debugLineNum = 124;BA.debugLine="NavigateToPage(page.ws, page.GetPageID, \"../\")";
_navigatetopage(_page.ws,_page.GetPageID(),"../");
 break; }
case 1: {
 //BA.debugLineNum = 127;BA.debugLine="page.SignOffSocialNetwork(Network, \"\", Name)";
_page.SignOffSocialNetwork(_network,"",_name);
 break; }
}
;
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return "";
}
public static String  _mid(String _text,int _start,int _length) throws Exception{
 //BA.debugLineNum = 131;BA.debugLine="Sub Mid(Text As String, Start As Int, Length As In";
 //BA.debugLineNum = 132;BA.debugLine="Return Text.SubString2(Start-1,Start+Length-1)";
if (true) return _text.substring((int) (_start-1),(int) (_start+_length-1));
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public static String  _mid2(String _text,int _start) throws Exception{
 //BA.debugLineNum = 135;BA.debugLine="Sub Mid2(Text As String, Start As Int) As String";
 //BA.debugLineNum = 136;BA.debugLine="Return Text.SubString(Start-1)";
if (true) return _text.substring((int) (_start-1));
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public static String  _navigatetopage(anywheresoftware.b4j.object.WebSocket _ws,String _pageid,String _targeturl) throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Public Sub NavigateToPage(ws As WebSocket, PageId";
 //BA.debugLineNum = 17;BA.debugLine="If AppVersion <> \"\" Then";
if ((_appversion).equals("") == false) { 
 //BA.debugLineNum = 18;BA.debugLine="TargetUrl = TargetUrl & \"?\" & AppVersion";
_targeturl = _targeturl+"?"+_appversion;
 };
 //BA.debugLineNum = 20;BA.debugLine="ABM.RemoveMeFromCache(CachedPages, PageId)";
_abm.RemoveMeFromCache(_cachedpages,_pageid);
 //BA.debugLineNum = 21;BA.debugLine="If ws.Open Then";
if (_ws.getOpen()) { 
 //BA.debugLineNum = 22;BA.debugLine="ws.Eval(\"window.location = arguments[0]\", Array";
_ws.Eval("window.location = arguments[0]",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_targeturl)}));
 //BA.debugLineNum = 23;BA.debugLine="ws.Flush";
_ws.Flush();
 };
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Public MyTheme As ABMTheme";
_mytheme = new com.ab.abmaterial.ABMTheme();
 //BA.debugLineNum = 4;BA.debugLine="Private ABM As ABMaterial 'ignore";
_abm = new com.ab.abmaterial.ABMaterial();
 //BA.debugLineNum = 5;BA.debugLine="Public NeedsAuthorization As Boolean = False";
_needsauthorization = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 6;BA.debugLine="Public AppVersion As String = DateTime.now";
_appversion = BA.NumberToString(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 7;BA.debugLine="Public AppPublishedStartURL As String = \"\"";
_apppublishedstarturl = "";
 //BA.debugLineNum = 8;BA.debugLine="Public AppName As String = \"feedback\"";
_appname = "feedback";
 //BA.debugLineNum = 10;BA.debugLine="Public CachedPages As Map";
_cachedpages = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 11;BA.debugLine="Public CacheScavengePeriodSeconds As Int = 15*60";
_cachescavengeperiodseconds = (int) (15*60);
 //BA.debugLineNum = 12;BA.debugLine="Public SessionMaxInactiveIntervalSeconds As Int =";
_sessionmaxinactiveintervalseconds = (int) (30*60);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return "";
}
public static String  _redirectoutput(String _dir,String _filename) throws Exception{
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
anywheresoftware.b4j.object.JavaObject _ps = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 27;BA.debugLine="Sub RedirectOutput (Dir As String, FileName As Str";
 //BA.debugLineNum = 29;BA.debugLine="Dim out As OutputStream = File.OpenOutput(Dir,";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(_dir,_filename,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 30;BA.debugLine="Dim ps As JavaObject";
_ps = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 31;BA.debugLine="ps.InitializeNewInstance(\"java.io.PrintStream\",";
_ps.InitializeNewInstance("java.io.PrintStream",new Object[]{(Object)(_out.getObject()),(Object)(anywheresoftware.b4a.keywords.Common.True),(Object)("utf8")});
 //BA.debugLineNum = 32;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 33;BA.debugLine="jo.InitializeStatic(\"java.lang.System\")";
_jo.InitializeStatic("java.lang.System");
 //BA.debugLineNum = 34;BA.debugLine="jo.RunMethod(\"setOut\", Array(ps))";
_jo.RunMethod("setOut",new Object[]{(Object)(_ps.getObject())});
 //BA.debugLineNum = 35;BA.debugLine="jo.RunMethod(\"setErr\", Array(ps))";
_jo.RunMethod("setErr",new Object[]{(Object)(_ps.getObject())});
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public static String  _replaceall(String _text,String _pattern,String _replacement) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 139;BA.debugLine="Sub ReplaceAll(Text As String, Pattern As String,";
 //BA.debugLineNum = 140;BA.debugLine="Dim jo As JavaObject = Regex.Matcher(Pattern, Te";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(anywheresoftware.b4a.keywords.Common.Regex.Matcher(_pattern,_text).getObject()));
 //BA.debugLineNum = 141;BA.debugLine="Return jo.RunMethod(\"replaceAll\", Array(Replacem";
if (true) return BA.ObjectToString(_jo.RunMethod("replaceAll",new Object[]{(Object)(_replacement)}));
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return "";
}
}
