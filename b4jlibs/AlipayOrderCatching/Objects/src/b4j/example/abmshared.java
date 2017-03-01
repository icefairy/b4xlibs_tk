package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class abmshared extends Object{
public static abmshared mostCurrent = new abmshared();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.ShellBA("b4j.example", "b4j.example.abmshared", null);
		ba.loadHtSubs(abmshared.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.abmshared", ba);
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
public static b4j.example.main _main = null;
public static b4j.example.dbm _dbm = null;
public static String  _buildtheme(String _themename) throws Exception{
RDebugUtils.currentModule="abmshared";
if (Debug.shouldDelegate(ba, "buildtheme"))
	return (String) Debug.delegate(ba, "buildtheme", new Object[] {_themename});
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub BuildTheme(themeName As String)";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="MyTheme.Initialize(themeName)";
_mytheme.Initialize(_themename);
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="MyTheme.Page.BackColor = ABM.COLOR_WHITE";
_mytheme.Page.BackColor = _abm.COLOR_WHITE;
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="End Sub";
return "";
}
public static String  _redirectoutput(String _dir,String _filename) throws Exception{
RDebugUtils.currentModule="abmshared";
if (Debug.shouldDelegate(ba, "redirectoutput"))
	return (String) Debug.delegate(ba, "redirectoutput", new Object[] {_dir,_filename});
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub RedirectOutput (Dir As String, FileName As Str";
RDebugUtils.currentLine=1310730;
 //BA.debugLineNum = 1310730;BA.debugLine="End Sub";
return "";
}
public static com.ab.abmaterial.ABMLabel  _buildparagraph(com.ab.abmaterial.ABMPage _page,String _id,String _text) throws Exception{
RDebugUtils.currentModule="abmshared";
if (Debug.shouldDelegate(ba, "buildparagraph"))
	return (com.ab.abmaterial.ABMLabel) Debug.delegate(ba, "buildparagraph", new Object[] {_page,_id,_text});
com.ab.abmaterial.ABMLabel _lbl = null;
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="public Sub BuildParagraph(page As ABMPage, id As S";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="lbl.Initialize(page, id, Text , ABM.SIZE_PARAGRAP";
_lbl.Initialize(_page,_id,_text,_abm.SIZE_PARAGRAPH,anywheresoftware.b4a.keywords.Common.False,"");
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="Return lbl";
if (true) return _lbl;
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="End Sub";
return null;
}
public static String  _navigatetopage(anywheresoftware.b4j.object.WebSocket _ws,String _pageid,String _targeturl) throws Exception{
RDebugUtils.currentModule="abmshared";
if (Debug.shouldDelegate(ba, "navigatetopage"))
	return (String) Debug.delegate(ba, "navigatetopage", new Object[] {_ws,_pageid,_targeturl});
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Public Sub NavigateToPage(ws As WebSocket, PageId";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="If AppVersion <> \"\" Then";
if ((_appversion).equals("") == false) { 
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="TargetUrl = TargetUrl & \"?\" & AppVersion";
_targeturl = _targeturl+"?"+_appversion;
 };
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="ABM.RemoveMeFromCache(CachedPages, PageId)";
_abm.RemoveMeFromCache(_cachedpages,_pageid);
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="If ws.Open Then";
if (_ws.getOpen()) { 
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="ws.Eval(\"window.location = arguments[0]\", Array";
_ws.Eval("window.location = arguments[0]",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_targeturl)}));
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="ws.Flush";
_ws.Flush();
 };
RDebugUtils.currentLine=1179657;
 //BA.debugLineNum = 1179657;BA.debugLine="End Sub";
return "";
}
public static String  _buildfooterfixed(com.ab.abmaterial.ABMPage _page) throws Exception{
RDebugUtils.currentModule="abmshared";
if (Debug.shouldDelegate(ba, "buildfooterfixed"))
	return (String) Debug.delegate(ba, "buildfooterfixed", new Object[] {_page});
com.ab.abmaterial.ABMLabel _lbl1 = null;
com.ab.abmaterial.ABMLabel _lbl2 = null;
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub BuildFooterFixed(page As ABMPage)";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="page.isFixedFooter= True";
_page.IsFixedFooter = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="page.PaddingBottom = 150";
_page.PaddingBottom = (int) (150);
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="page.Footer.AddRows(1, True, \"\").AddCellsOS(2,0,0";
_page.Footer.AddRows((int) (1),anywheresoftware.b4a.keywords.Common.True,"").AddCellsOS((int) (2),(int) (0),(int) (0),(int) (0),(int) (6),(int) (6),(int) (6),"");
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="page.Footer.BuildGrid '//IMPORTANT once you loade";
_page.Footer.BuildGrid();
RDebugUtils.currentLine=1572872;
 //BA.debugLineNum = 1572872;BA.debugLine="page.Footer.UseTheme(\"footertheme\")";
_page.Footer.UseTheme("footertheme");
RDebugUtils.currentLine=1572874;
 //BA.debugLineNum = 1572874;BA.debugLine="Dim lbl1 As ABMLabel";
_lbl1 = new com.ab.abmaterial.ABMLabel();
RDebugUtils.currentLine=1572875;
 //BA.debugLineNum = 1572875;BA.debugLine="lbl1.Initialize(page, \"footlbl1\", \"Blog: Alwaysbu";
_lbl1.Initialize(_page,"footlbl1","Blog: Alwaysbusy's Corner{BR}{BR}B4J by Anywhere Software{BR}Materialize CSS by students from Carnegie Mellon University",_abm.SIZE_PARAGRAPH,anywheresoftware.b4a.keywords.Common.False,"whitefc");
RDebugUtils.currentLine=1572876;
 //BA.debugLineNum = 1572876;BA.debugLine="page.Footer.Cell(1,1).AddComponent(lbl1)";
_page.Footer.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl1));
RDebugUtils.currentLine=1572878;
 //BA.debugLineNum = 1572878;BA.debugLine="Dim lbl2 As ABMLabel";
_lbl2 = new com.ab.abmaterial.ABMLabel();
RDebugUtils.currentLine=1572879;
 //BA.debugLineNum = 1572879;BA.debugLine="lbl2.Initialize(page, \"footlbl2\", \"ABMaterial Cop";
_lbl2.Initialize(_page,"footlbl2","ABMaterial Copyright @2015-2016{BR}By Alain Bailleul{BR}{BR}Email: alain.bailleul@telenet.be",_abm.SIZE_PARAGRAPH,anywheresoftware.b4a.keywords.Common.False,"whitefc");
RDebugUtils.currentLine=1572880;
 //BA.debugLineNum = 1572880;BA.debugLine="page.Footer.Cell(1,2).AddComponent(lbl2)";
_page.Footer.Cell((int) (1),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl2));
RDebugUtils.currentLine=1572881;
 //BA.debugLineNum = 1572881;BA.debugLine="End Sub";
return "";
}
public static String  _buildnavigationbar(com.ab.abmaterial.ABMPage _page,String _title,String _logo,String _activetopreturnname,String _activesidereturnname,String _activesidesubreturnname) throws Exception{
RDebugUtils.currentModule="abmshared";
if (Debug.shouldDelegate(ba, "buildnavigationbar"))
	return (String) Debug.delegate(ba, "buildnavigationbar", new Object[] {_page,_title,_logo,_activetopreturnname,_activesidereturnname,_activesidesubreturnname});
com.ab.abmaterial.ABMImage _sbtopimg = null;
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub BuildNavigationBar(page As ABMPage, Title As S";
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="Dim sbtopimg As ABMImage";
_sbtopimg = new com.ab.abmaterial.ABMImage();
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="sbtopimg.Initialize(page, \"sbtopimg\", logo, 1)";
_sbtopimg.Initialize(_page,"sbtopimg",_logo,1);
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="sbtopimg.SetFixedSize(236, 49)";
_sbtopimg.SetFixedSize((int) (236),(int) (49));
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="page.NavigationBar.Initialize(page, \"nav1\", ABM.S";
_page.NavigationBar().Initialize(_page,"nav1",_abm.SIDEBAR_MANUAL_HIDEMEDIUMSMALL,_title,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.True,(int) (330),(int) (48),(com.ab.abmaterial.ABMComponent)(_sbtopimg),_abm.COLLAPSE_ACCORDION,"nav1theme");
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="page.NavigationBar.TopBarDropDownConstrainWidth =";
_page.NavigationBar().TopBarDropDownConstrainWidth = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=1507337;
 //BA.debugLineNum = 1507337;BA.debugLine="page.NavigationBar.ActiveTopReturnName = ActiveTo";
_page.NavigationBar().ActiveTopReturnName = _activetopreturnname;
RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="page.NavigationBar.ActiveSideReturnName = ActiveS";
_page.NavigationBar().ActiveSideReturnName = _activesidereturnname;
RDebugUtils.currentLine=1507339;
 //BA.debugLineNum = 1507339;BA.debugLine="page.NavigationBar.ActiveSideSubReturnName = Acti";
_page.NavigationBar().ActiveSideSubReturnName = _activesidesubreturnname;
RDebugUtils.currentLine=1507342;
 //BA.debugLineNum = 1507342;BA.debugLine="page.NavigationBar.AddTopItem(\"DUMMY\", \"DUMMY\", \"";
_page.NavigationBar().AddTopItem("DUMMY","DUMMY","","",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1507345;
 //BA.debugLineNum = 1507345;BA.debugLine="page.NavigationBar.AddSideBarItem(\"DUMMY\", \"DUMMY";
_page.NavigationBar().AddSideBarItem("DUMMY","DUMMY","","");
RDebugUtils.currentLine=1507346;
 //BA.debugLineNum = 1507346;BA.debugLine="End Sub";
return "";
}
public static String  _connectnavigationbar(com.ab.abmaterial.ABMPage _page) throws Exception{
RDebugUtils.currentModule="abmshared";
if (Debug.shouldDelegate(ba, "connectnavigationbar"))
	return (String) Debug.delegate(ba, "connectnavigationbar", new Object[] {_page});
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub ConnectNavigationBar(page As ABMPage) 'ignore";
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="page.NavigationBar.Clear";
_page.NavigationBar().Clear();
RDebugUtils.currentLine=1638411;
 //BA.debugLineNum = 1638411;BA.debugLine="page.NavigationBar.Refresh ' IMPORTANT";
_page.NavigationBar().Refresh();
RDebugUtils.currentLine=1638412;
 //BA.debugLineNum = 1638412;BA.debugLine="End Sub";
return "";
}
public static String  _logoff(com.ab.abmaterial.ABMPage _page) throws Exception{
RDebugUtils.currentModule="abmshared";
if (Debug.shouldDelegate(ba, "logoff"))
	return (String) Debug.delegate(ba, "logoff", new Object[] {_page});
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub LogOff(page As ABMPage)";
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="NavigateToPage(page.ws, page.GetPageID, \"../\")";
_navigatetopage(_page.ws,_page.GetPageID(),"../");
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="End Sub";
return "";
}
public static String  _mid(String _text,int _start,int _length) throws Exception{
RDebugUtils.currentModule="abmshared";
if (Debug.shouldDelegate(ba, "mid"))
	return (String) Debug.delegate(ba, "mid", new Object[] {_text,_start,_length});
RDebugUtils.currentLine=7274496;
 //BA.debugLineNum = 7274496;BA.debugLine="Sub Mid(Text As String, Start As Int, Length As In";
RDebugUtils.currentLine=7274497;
 //BA.debugLineNum = 7274497;BA.debugLine="Return Text.SubString2(Start-1,Start+Length-1)";
if (true) return _text.substring((int) (_start-1),(int) (_start+_length-1));
RDebugUtils.currentLine=7274498;
 //BA.debugLineNum = 7274498;BA.debugLine="End Sub";
return "";
}
public static String  _mid2(String _text,int _start) throws Exception{
RDebugUtils.currentModule="abmshared";
if (Debug.shouldDelegate(ba, "mid2"))
	return (String) Debug.delegate(ba, "mid2", new Object[] {_text,_start});
RDebugUtils.currentLine=7340032;
 //BA.debugLineNum = 7340032;BA.debugLine="Sub Mid2(Text As String, Start As Int) As String";
RDebugUtils.currentLine=7340033;
 //BA.debugLineNum = 7340033;BA.debugLine="Return Text.SubString(Start-1)";
if (true) return _text.substring((int) (_start-1));
RDebugUtils.currentLine=7340034;
 //BA.debugLineNum = 7340034;BA.debugLine="End Sub";
return "";
}
public static String  _navigatetopagenewtab(anywheresoftware.b4j.object.WebSocket _ws,String _pageid,String _targeturl,boolean _openinnewtab) throws Exception{
RDebugUtils.currentModule="abmshared";
if (Debug.shouldDelegate(ba, "navigatetopagenewtab"))
	return (String) Debug.delegate(ba, "navigatetopagenewtab", new Object[] {_ws,_pageid,_targeturl,_openinnewtab});
String _s = "";
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Public Sub NavigateToPageNewTab(ws As WebSocket, P";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="If AppVersion <> \"\" Then";
if ((_appversion).equals("") == false) { 
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="TargetUrl = TargetUrl & \"?\" & AppVersion";
_targeturl = _targeturl+"?"+_appversion;
 };
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="ABM.RemoveMeFromCache(CachedPages, PageId)";
_abm.RemoveMeFromCache(_cachedpages,_pageid);
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="If ws.Open Then";
if (_ws.getOpen()) { 
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="If OpenInNewTab Then";
if (_openinnewtab) { 
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="Dim s As String";
_s = "";
RDebugUtils.currentLine=1245202;
 //BA.debugLineNum = 1245202;BA.debugLine="s = $\"var check = false;   			(function(a){if(/";
_s = ("var check = false;\n"+"  			(function(a){if(/(android|bb\\d+|meego).+mobile|avantgo|bada\\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|mobile.+firefox|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\\.(browser|link)|vodafone|wap|windows ce|xda|xiino|android|ipad|playbook|silk/i.test(a)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\\-(n|u)|c55\\/|capi|ccwa|cdm\\-|cell|chtm|cldc|cmd\\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\\-s|devi|dica|dmob|do(c|p)o|ds(12|\\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\\-|_)|g1 u|g560|gene|gf\\-5|g\\-mo|go(\\.w|od)|gr(ad|un)|haie|hcit|hd\\-(m|p|t)|hei\\-|hi(pt|ta)|hp( i|ip)|hs\\-c|ht(c(\\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\\-(20|go|ma)|i230|iac( |\\-|\\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\\/)|klon|kpt |kwc\\-|kyo(c|k)|le(no|xi)|lg( g|\\/(k|l|u)|50|54|\\-[a-w])|libw|lynx|m1\\-w|m3ga|m50\\/|ma(te|ui|xo)|mc(01|21|ca)|m\\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\\-2|po(ck|rt|se)|prox|psio|pt\\-g|qa\\-a|qc(07|12|21|32|60|\\-[2-7]|i\\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\\-|oo|p\\-)|sdk\\/|se(c(\\-|0|1)|47|mc|nd|ri)|sgh\\-|shar|sie(\\-|m)|sk\\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\\-|v\\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\\-|tdg\\-|tel(i|m)|tim\\-|t\\-mo|to(pl|sh)|ts(70|m\\-|m3|m5)|tx\\-9|up(\\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\\-|your|zeto|zte\\-/i.test(a.substr(0,4))) check = true;})(navigator.userAgent||navigator.vendor||window.opera);\n"+"   			if (check) {\n"+"  				window.location = arguments[0];\n"+"  			} else {\n"+"				window.open(arguments[0],'_blank');  				\n"+"  			}");
RDebugUtils.currentLine=1245209;
 //BA.debugLineNum = 1245209;BA.debugLine="ws.Eval(s, Array As Object(TargetUrl))";
_ws.Eval(_s,anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_targeturl)}));
 }else {
RDebugUtils.currentLine=1245211;
 //BA.debugLineNum = 1245211;BA.debugLine="ws.Eval(\"window.location = arguments[0]\", Array";
_ws.Eval("window.location = arguments[0]",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_targeturl)}));
 };
RDebugUtils.currentLine=1245213;
 //BA.debugLineNum = 1245213;BA.debugLine="ws.Flush";
_ws.Flush();
 };
RDebugUtils.currentLine=1245215;
 //BA.debugLineNum = 1245215;BA.debugLine="End Sub";
return "";
}
public static String  _replaceall(String _text,String _pattern,String _replacement) throws Exception{
RDebugUtils.currentModule="abmshared";
if (Debug.shouldDelegate(ba, "replaceall"))
	return (String) Debug.delegate(ba, "replaceall", new Object[] {_text,_pattern,_replacement});
anywheresoftware.b4j.object.JavaObject _jo = null;
RDebugUtils.currentLine=7405568;
 //BA.debugLineNum = 7405568;BA.debugLine="Sub ReplaceAll(Text As String, Pattern As String,";
RDebugUtils.currentLine=7405569;
 //BA.debugLineNum = 7405569;BA.debugLine="Dim jo As JavaObject = Regex.Matcher(Pattern, Te";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(anywheresoftware.b4a.keywords.Common.Regex.Matcher(_pattern,_text).getObject()));
RDebugUtils.currentLine=7405570;
 //BA.debugLineNum = 7405570;BA.debugLine="Return jo.RunMethod(\"replaceAll\", Array(Replacem";
if (true) return BA.ObjectToString(_jo.RunMethod("replaceAll",new Object[]{(Object)(_replacement)}));
RDebugUtils.currentLine=7405571;
 //BA.debugLineNum = 7405571;BA.debugLine="End Sub";
return "";
}
}