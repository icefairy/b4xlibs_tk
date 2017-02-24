package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class abmshared_subs_0 {


public static RemoteObject  _buildfooterfixed(RemoteObject _page) throws Exception{
try {
		Debug.PushSubsStack("BuildFooterFixed (abmshared) ","abmshared",2,abmshared.ba,abmshared.mostCurrent,106);
if (RapidSub.canDelegate("buildfooterfixed")) return abmshared.remoteMe.runUserSub(false, "abmshared","buildfooterfixed", _page);
RemoteObject _lbl1 = RemoteObject.declareNull("com.ab.abmaterial.ABMLabel");
RemoteObject _lbl2 = RemoteObject.declareNull("com.ab.abmaterial.ABMLabel");
Debug.locals.put("page", _page);
 BA.debugLineNum = 106;BA.debugLine="Sub BuildFooterFixed(page As ABMPage)";
Debug.ShouldStop(512);
 BA.debugLineNum = 107;BA.debugLine="page.isFixedFooter= True";
Debug.ShouldStop(1024);
_page.setField ("IsFixedFooter",abmshared.__c.getField(true,"True"));
 BA.debugLineNum = 109;BA.debugLine="page.PaddingBottom = 150";
Debug.ShouldStop(4096);
_page.setField ("PaddingBottom",BA.numberCast(int.class, 150));
 BA.debugLineNum = 111;BA.debugLine="page.Footer.AddRows(1, True, \"\").AddCellsOS(2,0,0";
Debug.ShouldStop(16384);
_page.getField(false,"Footer").runMethod(false,"AddRows",(Object)(BA.numberCast(int.class, 1)),(Object)(abmshared.__c.getField(true,"True")),(Object)(RemoteObject.createImmutable(""))).runVoidMethod ("AddCellsOS",(Object)(BA.numberCast(int.class, 2)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 6)),(Object)(BA.numberCast(int.class, 6)),(Object)(BA.numberCast(int.class, 6)),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 112;BA.debugLine="page.Footer.BuildGrid '//IMPORTANT once you loade";
Debug.ShouldStop(32768);
_page.getField(false,"Footer").runVoidMethod ("BuildGrid");
 BA.debugLineNum = 114;BA.debugLine="page.Footer.UseTheme(\"footertheme\")";
Debug.ShouldStop(131072);
_page.getField(false,"Footer").runVoidMethod ("UseTheme",(Object)(RemoteObject.createImmutable("footertheme")));
 BA.debugLineNum = 116;BA.debugLine="Dim lbl1 As ABMLabel";
Debug.ShouldStop(524288);
_lbl1 = RemoteObject.createNew ("com.ab.abmaterial.ABMLabel");Debug.locals.put("lbl1", _lbl1);
 BA.debugLineNum = 117;BA.debugLine="lbl1.Initialize(page, \"footlbl1\", \"Blog: Alwaysbu";
Debug.ShouldStop(1048576);
_lbl1.runVoidMethod ("Initialize",(Object)(_page),(Object)(BA.ObjectToString("footlbl1")),(Object)(BA.ObjectToString("Blog: Alwaysbusy's Corner{BR}{BR}B4J by Anywhere Software{BR}Materialize CSS by students from Carnegie Mellon University")),(Object)(abmshared._abm.getField(true,"SIZE_PARAGRAPH")),(Object)(abmshared.__c.getField(true,"False")),(Object)(RemoteObject.createImmutable("whitefc")));
 BA.debugLineNum = 118;BA.debugLine="page.Footer.Cell(1,1).AddComponent(lbl1)";
Debug.ShouldStop(2097152);
_page.getField(false,"Footer").runMethod(false,"Cell",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 1))).runVoidMethod ("AddComponent",(Object)((_lbl1)));
 BA.debugLineNum = 120;BA.debugLine="Dim lbl2 As ABMLabel";
Debug.ShouldStop(8388608);
_lbl2 = RemoteObject.createNew ("com.ab.abmaterial.ABMLabel");Debug.locals.put("lbl2", _lbl2);
 BA.debugLineNum = 121;BA.debugLine="lbl2.Initialize(page, \"footlbl2\", \"ABMaterial Cop";
Debug.ShouldStop(16777216);
_lbl2.runVoidMethod ("Initialize",(Object)(_page),(Object)(BA.ObjectToString("footlbl2")),(Object)(BA.ObjectToString("ABMaterial Copyright @2015-2016{BR}By Alain Bailleul{BR}{BR}Email: alain.bailleul@telenet.be")),(Object)(abmshared._abm.getField(true,"SIZE_PARAGRAPH")),(Object)(abmshared.__c.getField(true,"False")),(Object)(RemoteObject.createImmutable("whitefc")));
 BA.debugLineNum = 122;BA.debugLine="page.Footer.Cell(1,2).AddComponent(lbl2)";
Debug.ShouldStop(33554432);
_page.getField(false,"Footer").runMethod(false,"Cell",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 2))).runVoidMethod ("AddComponent",(Object)((_lbl2)));
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buildnavigationbar(RemoteObject _page,RemoteObject _title,RemoteObject _logo,RemoteObject _activetopreturnname,RemoteObject _activesidereturnname,RemoteObject _activesidesubreturnname) throws Exception{
try {
		Debug.PushSubsStack("BuildNavigationBar (abmshared) ","abmshared",2,abmshared.ba,abmshared.mostCurrent,87);
if (RapidSub.canDelegate("buildnavigationbar")) return abmshared.remoteMe.runUserSub(false, "abmshared","buildnavigationbar", _page, _title, _logo, _activetopreturnname, _activesidereturnname, _activesidesubreturnname);
RemoteObject _sbtopimg = RemoteObject.declareNull("com.ab.abmaterial.ABMImage");
Debug.locals.put("page", _page);
Debug.locals.put("Title", _title);
Debug.locals.put("logo", _logo);
Debug.locals.put("ActiveTopReturnName", _activetopreturnname);
Debug.locals.put("ActiveSideReturnName", _activesidereturnname);
Debug.locals.put("ActiveSideSubReturnName", _activesidesubreturnname);
 BA.debugLineNum = 87;BA.debugLine="Sub BuildNavigationBar(page As ABMPage, Title As S";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 89;BA.debugLine="Dim sbtopimg As ABMImage";
Debug.ShouldStop(16777216);
_sbtopimg = RemoteObject.createNew ("com.ab.abmaterial.ABMImage");Debug.locals.put("sbtopimg", _sbtopimg);
 BA.debugLineNum = 90;BA.debugLine="sbtopimg.Initialize(page, \"sbtopimg\", logo, 1)";
Debug.ShouldStop(33554432);
_sbtopimg.runVoidMethod ("Initialize",(Object)(_page),(Object)(BA.ObjectToString("sbtopimg")),(Object)(_logo),(Object)(BA.numberCast(double.class, 1)));
 BA.debugLineNum = 91;BA.debugLine="sbtopimg.SetFixedSize(236, 49)";
Debug.ShouldStop(67108864);
_sbtopimg.runVoidMethod ("SetFixedSize",(Object)(BA.numberCast(int.class, 236)),(Object)(BA.numberCast(int.class, 49)));
 BA.debugLineNum = 93;BA.debugLine="page.NavigationBar.Initialize(page, \"nav1\", ABM.S";
Debug.ShouldStop(268435456);
_page.runMethod(false,"NavigationBar").runVoidMethod ("Initialize",(Object)(_page),(Object)(BA.ObjectToString("nav1")),(Object)(abmshared._abm.getField(true,"SIDEBAR_MANUAL_HIDEMEDIUMSMALL")),(Object)(_title),(Object)(abmshared.__c.getField(true,"True")),(Object)(abmshared.__c.getField(true,"True")),(Object)(BA.numberCast(int.class, 330)),(Object)(BA.numberCast(int.class, 48)),(Object)((_sbtopimg)),(Object)(abmshared._abm.getField(true,"COLLAPSE_ACCORDION")),(Object)(RemoteObject.createImmutable("nav1theme")));
 BA.debugLineNum = 95;BA.debugLine="page.NavigationBar.TopBarDropDownConstrainWidth =";
Debug.ShouldStop(1073741824);
_page.runMethod(false,"NavigationBar").setField ("TopBarDropDownConstrainWidth",abmshared.__c.getField(true,"False"));
 BA.debugLineNum = 96;BA.debugLine="page.NavigationBar.ActiveTopReturnName = ActiveTo";
Debug.ShouldStop(-2147483648);
_page.runMethod(false,"NavigationBar").setField ("ActiveTopReturnName",_activetopreturnname);
 BA.debugLineNum = 97;BA.debugLine="page.NavigationBar.ActiveSideReturnName = ActiveS";
Debug.ShouldStop(1);
_page.runMethod(false,"NavigationBar").setField ("ActiveSideReturnName",_activesidereturnname);
 BA.debugLineNum = 98;BA.debugLine="page.NavigationBar.ActiveSideSubReturnName = Acti";
Debug.ShouldStop(2);
_page.runMethod(false,"NavigationBar").setField ("ActiveSideSubReturnName",_activesidesubreturnname);
 BA.debugLineNum = 101;BA.debugLine="page.NavigationBar.AddTopItem(\"DUMMY\", \"DUMMY\", \"";
Debug.ShouldStop(16);
_page.runMethod(false,"NavigationBar").runVoidMethod ("AddTopItem",(Object)(BA.ObjectToString("DUMMY")),(Object)(BA.ObjectToString("DUMMY")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)(abmshared.__c.getField(true,"False")));
 BA.debugLineNum = 104;BA.debugLine="page.NavigationBar.AddSideBarItem(\"DUMMY\", \"DUMMY";
Debug.ShouldStop(128);
_page.runMethod(false,"NavigationBar").runVoidMethod ("AddSideBarItem",(Object)(BA.ObjectToString("DUMMY")),(Object)(BA.ObjectToString("DUMMY")),(Object)(BA.ObjectToString("")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buildparagraph(RemoteObject _page,RemoteObject _id,RemoteObject _text) throws Exception{
try {
		Debug.PushSubsStack("BuildParagraph (abmshared) ","abmshared",2,abmshared.ba,abmshared.mostCurrent,138);
if (RapidSub.canDelegate("buildparagraph")) return abmshared.remoteMe.runUserSub(false, "abmshared","buildparagraph", _page, _id, _text);
RemoteObject _lbl = RemoteObject.declareNull("com.ab.abmaterial.ABMLabel");
Debug.locals.put("page", _page);
Debug.locals.put("id", _id);
Debug.locals.put("Text", _text);
 BA.debugLineNum = 138;BA.debugLine="public Sub BuildParagraph(page As ABMPage, id As S";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="Dim lbl As ABMLabel";
Debug.ShouldStop(1024);
_lbl = RemoteObject.createNew ("com.ab.abmaterial.ABMLabel");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 140;BA.debugLine="lbl.Initialize(page, id, Text , ABM.SIZE_PARAGRAP";
Debug.ShouldStop(2048);
_lbl.runVoidMethod ("Initialize",(Object)(_page),(Object)(_id),(Object)(_text),(Object)(abmshared._abm.getField(true,"SIZE_PARAGRAPH")),(Object)(abmshared.__c.getField(true,"False")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 141;BA.debugLine="Return lbl";
Debug.ShouldStop(4096);
if (true) return _lbl;
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _buildtheme(RemoteObject _themename) throws Exception{
try {
		Debug.PushSubsStack("BuildTheme (abmshared) ","abmshared",2,abmshared.ba,abmshared.mostCurrent,79);
if (RapidSub.canDelegate("buildtheme")) return abmshared.remoteMe.runUserSub(false, "abmshared","buildtheme", _themename);
Debug.locals.put("themeName", _themename);
 BA.debugLineNum = 79;BA.debugLine="Sub BuildTheme(themeName As String)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="MyTheme.Initialize(themeName)";
Debug.ShouldStop(32768);
abmshared._mytheme.runVoidMethod ("Initialize",(Object)(_themename));
 BA.debugLineNum = 83;BA.debugLine="MyTheme.Page.BackColor = ABM.COLOR_WHITE";
Debug.ShouldStop(262144);
abmshared._mytheme.getField(false,"Page").setField ("BackColor",abmshared._abm.getField(true,"COLOR_WHITE"));
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _connectnavigationbar(RemoteObject _page) throws Exception{
try {
		Debug.PushSubsStack("ConnectNavigationBar (abmshared) ","abmshared",2,abmshared.ba,abmshared.mostCurrent,124);
if (RapidSub.canDelegate("connectnavigationbar")) return abmshared.remoteMe.runUserSub(false, "abmshared","connectnavigationbar", _page);
Debug.locals.put("page", _page);
 BA.debugLineNum = 124;BA.debugLine="Sub ConnectNavigationBar(page As ABMPage) 'ignore";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 126;BA.debugLine="page.NavigationBar.Clear";
Debug.ShouldStop(536870912);
_page.runMethod(false,"NavigationBar").runVoidMethod ("Clear");
 BA.debugLineNum = 135;BA.debugLine="page.NavigationBar.Refresh ' IMPORTANT";
Debug.ShouldStop(64);
_page.runMethod(false,"NavigationBar").runVoidMethod ("Refresh");
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _logoff(RemoteObject _page) throws Exception{
try {
		Debug.PushSubsStack("LogOff (abmshared) ","abmshared",2,abmshared.ba,abmshared.mostCurrent,71);
if (RapidSub.canDelegate("logoff")) return abmshared.remoteMe.runUserSub(false, "abmshared","logoff", _page);
Debug.locals.put("page", _page);
 BA.debugLineNum = 71;BA.debugLine="Sub LogOff(page As ABMPage)";
Debug.ShouldStop(64);
 BA.debugLineNum = 74;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
Debug.ShouldStop(512);
_page.getField(false,"ws").runMethod(false,"getSession").runVoidMethod ("SetAttribute",(Object)(BA.ObjectToString("IsAuthorized")),(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 75;BA.debugLine="NavigateToPage(page.ws, page.GetPageID, \"../\")";
Debug.ShouldStop(1024);
_navigatetopage(_page.getField(false,"ws"),_page.runMethod(true,"GetPageID"),RemoteObject.createImmutable("../"));
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mid(RemoteObject _text,RemoteObject _start,RemoteObject _length) throws Exception{
try {
		Debug.PushSubsStack("Mid (abmshared) ","abmshared",2,abmshared.ba,abmshared.mostCurrent,145);
if (RapidSub.canDelegate("mid")) return abmshared.remoteMe.runUserSub(false, "abmshared","mid", _text, _start, _length);
Debug.locals.put("Text", _text);
Debug.locals.put("Start", _start);
Debug.locals.put("Length", _length);
 BA.debugLineNum = 145;BA.debugLine="Sub Mid(Text As String, Start As Int, Length As In";
Debug.ShouldStop(65536);
 BA.debugLineNum = 146;BA.debugLine="Return Text.SubString2(Start-1,Start+Length-1)";
Debug.ShouldStop(131072);
if (true) return _text.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_start,RemoteObject.createImmutable(1)}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_start,_length,RemoteObject.createImmutable(1)}, "+-",2, 1)));
 BA.debugLineNum = 147;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mid2(RemoteObject _text,RemoteObject _start) throws Exception{
try {
		Debug.PushSubsStack("Mid2 (abmshared) ","abmshared",2,abmshared.ba,abmshared.mostCurrent,149);
if (RapidSub.canDelegate("mid2")) return abmshared.remoteMe.runUserSub(false, "abmshared","mid2", _text, _start);
Debug.locals.put("Text", _text);
Debug.locals.put("Start", _start);
 BA.debugLineNum = 149;BA.debugLine="Sub Mid2(Text As String, Start As Int) As String";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 150;BA.debugLine="Return Text.SubString(Start-1)";
Debug.ShouldStop(2097152);
if (true) return _text.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_start,RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _navigatetopage(RemoteObject _ws,RemoteObject _pageid,RemoteObject _targeturl) throws Exception{
try {
		Debug.PushSubsStack("NavigateToPage (abmshared) ","abmshared",2,abmshared.ba,abmshared.mostCurrent,15);
if (RapidSub.canDelegate("navigatetopage")) return abmshared.remoteMe.runUserSub(false, "abmshared","navigatetopage", _ws, _pageid, _targeturl);
Debug.locals.put("ws", _ws);
Debug.locals.put("PageId", _pageid);
Debug.locals.put("TargetUrl", _targeturl);
 BA.debugLineNum = 15;BA.debugLine="Public Sub NavigateToPage(ws As WebSocket, PageId";
Debug.ShouldStop(16384);
 BA.debugLineNum = 16;BA.debugLine="If AppVersion <> \"\" Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("!",abmshared._appversion,BA.ObjectToString(""))) { 
 BA.debugLineNum = 17;BA.debugLine="TargetUrl = TargetUrl & \"?\" & AppVersion";
Debug.ShouldStop(65536);
_targeturl = RemoteObject.concat(_targeturl,RemoteObject.createImmutable("?"),abmshared._appversion);Debug.locals.put("TargetUrl", _targeturl);
 };
 BA.debugLineNum = 19;BA.debugLine="ABM.RemoveMeFromCache(CachedPages, PageId)";
Debug.ShouldStop(262144);
abmshared._abm.runVoidMethod ("RemoveMeFromCache",(Object)(abmshared._cachedpages),(Object)(_pageid));
 BA.debugLineNum = 20;BA.debugLine="If ws.Open Then";
Debug.ShouldStop(524288);
if (_ws.runMethod(true,"getOpen").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 21;BA.debugLine="ws.Eval(\"window.location = arguments[0]\", Array";
Debug.ShouldStop(1048576);
_ws.runVoidMethod ("Eval",(Object)(BA.ObjectToString("window.location = arguments[0]")),(Object)(abmshared.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_targeturl)})))));
 BA.debugLineNum = 22;BA.debugLine="ws.Flush";
Debug.ShouldStop(2097152);
_ws.runVoidMethod ("Flush");
 };
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _navigatetopagenewtab(RemoteObject _ws,RemoteObject _pageid,RemoteObject _targeturl,RemoteObject _openinnewtab) throws Exception{
try {
		Debug.PushSubsStack("NavigateToPageNewTab (abmshared) ","abmshared",2,abmshared.ba,abmshared.mostCurrent,26);
if (RapidSub.canDelegate("navigatetopagenewtab")) return abmshared.remoteMe.runUserSub(false, "abmshared","navigatetopagenewtab", _ws, _pageid, _targeturl, _openinnewtab);
RemoteObject _s = RemoteObject.createImmutable("");
Debug.locals.put("ws", _ws);
Debug.locals.put("PageId", _pageid);
Debug.locals.put("TargetUrl", _targeturl);
Debug.locals.put("OpenInNewTab", _openinnewtab);
 BA.debugLineNum = 26;BA.debugLine="Public Sub NavigateToPageNewTab(ws As WebSocket, P";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="If AppVersion <> \"\" Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("!",abmshared._appversion,BA.ObjectToString(""))) { 
 BA.debugLineNum = 28;BA.debugLine="TargetUrl = TargetUrl & \"?\" & AppVersion";
Debug.ShouldStop(134217728);
_targeturl = RemoteObject.concat(_targeturl,RemoteObject.createImmutable("?"),abmshared._appversion);Debug.locals.put("TargetUrl", _targeturl);
 };
 BA.debugLineNum = 30;BA.debugLine="ABM.RemoveMeFromCache(CachedPages, PageId)";
Debug.ShouldStop(536870912);
abmshared._abm.runVoidMethod ("RemoveMeFromCache",(Object)(abmshared._cachedpages),(Object)(_pageid));
 BA.debugLineNum = 31;BA.debugLine="If ws.Open Then";
Debug.ShouldStop(1073741824);
if (_ws.runMethod(true,"getOpen").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 32;BA.debugLine="If OpenInNewTab Then";
Debug.ShouldStop(-2147483648);
if (_openinnewtab.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 33;BA.debugLine="Dim s As String";
Debug.ShouldStop(1);
_s = RemoteObject.createImmutable("");Debug.locals.put("s", _s);
 BA.debugLineNum = 44;BA.debugLine="s = $\"var check = false;   			(function(a){if(/";
Debug.ShouldStop(2048);
_s = (RemoteObject.concat(RemoteObject.createImmutable("var check = false;\n"),RemoteObject.createImmutable("  			(function(a){if(/(android|bb\\d+|meego).+mobile|avantgo|bada\\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|mobile.+firefox|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\\.(browser|link)|vodafone|wap|windows ce|xda|xiino|android|ipad|playbook|silk/i.test(a)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\\-(n|u)|c55\\/|capi|ccwa|cdm\\-|cell|chtm|cldc|cmd\\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\\-s|devi|dica|dmob|do(c|p)o|ds(12|\\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\\-|_)|g1 u|g560|gene|gf\\-5|g\\-mo|go(\\.w|od)|gr(ad|un)|haie|hcit|hd\\-(m|p|t)|hei\\-|hi(pt|ta)|hp( i|ip)|hs\\-c|ht(c(\\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\\-(20|go|ma)|i230|iac( |\\-|\\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\\/)|klon|kpt |kwc\\-|kyo(c|k)|le(no|xi)|lg( g|\\/(k|l|u)|50|54|\\-[a-w])|libw|lynx|m1\\-w|m3ga|m50\\/|ma(te|ui|xo)|mc(01|21|ca)|m\\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\\-2|po(ck|rt|se)|prox|psio|pt\\-g|qa\\-a|qc(07|12|21|32|60|\\-[2-7]|i\\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\\-|oo|p\\-)|sdk\\/|se(c(\\-|0|1)|47|mc|nd|ri)|sgh\\-|shar|sie(\\-|m)|sk\\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\\-|v\\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\\-|tdg\\-|tel(i|m)|tim\\-|t\\-mo|to(pl|sh)|ts(70|m\\-|m3|m5)|tx\\-9|up(\\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\\-|your|zeto|zte\\-/i.test(a.substr(0,4))) check = true;})(navigator.userAgent||navigator.vendor||window.opera);\n"),RemoteObject.createImmutable("   			if (check) {\n"),RemoteObject.createImmutable("  				window.location = arguments[0];\n"),RemoteObject.createImmutable("  			} else {\n"),RemoteObject.createImmutable("				window.open(arguments[0],'_blank');  				\n"),RemoteObject.createImmutable("  			}")));Debug.locals.put("s", _s);
 BA.debugLineNum = 51;BA.debugLine="ws.Eval(s, Array As Object(TargetUrl))";
Debug.ShouldStop(262144);
_ws.runVoidMethod ("Eval",(Object)(_s),(Object)(abmshared.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_targeturl)})))));
 }else {
 BA.debugLineNum = 53;BA.debugLine="ws.Eval(\"window.location = arguments[0]\", Array";
Debug.ShouldStop(1048576);
_ws.runVoidMethod ("Eval",(Object)(BA.ObjectToString("window.location = arguments[0]")),(Object)(abmshared.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_targeturl)})))));
 };
 BA.debugLineNum = 55;BA.debugLine="ws.Flush";
Debug.ShouldStop(4194304);
_ws.runVoidMethod ("Flush");
 };
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Public MyTheme As ABMTheme";
abmshared._mytheme = RemoteObject.createNew ("com.ab.abmaterial.ABMTheme");
 //BA.debugLineNum = 4;BA.debugLine="Private ABM As ABMaterial 'ignore";
abmshared._abm = RemoteObject.createNew ("com.ab.abmaterial.ABMaterial");
 //BA.debugLineNum = 5;BA.debugLine="Public NeedsAuthorization As Boolean = False";
abmshared._needsauthorization = abmshared.__c.getField(true,"False");
 //BA.debugLineNum = 6;BA.debugLine="Public AppVersion As String = DateTime.now ' NEW";
abmshared._appversion = BA.NumberToString(abmshared.__c.getField(false,"DateTime").runMethod(true,"getNow"));
 //BA.debugLineNum = 7;BA.debugLine="Public AppPublishedStartURL As String = \"\"";
abmshared._apppublishedstarturl = BA.ObjectToString("");
 //BA.debugLineNum = 8;BA.debugLine="Public AppName As String = \"zfbord\"";
abmshared._appname = BA.ObjectToString("zfbord");
 //BA.debugLineNum = 10;BA.debugLine="Public CachedPages As Map";
abmshared._cachedpages = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 11;BA.debugLine="Public CacheScavengePeriodSeconds As Int = 15*60";
abmshared._cachescavengeperiodseconds = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(15),RemoteObject.createImmutable(60)}, "*",0, 1);
 //BA.debugLineNum = 12;BA.debugLine="Public SessionMaxInactiveIntervalSeconds As Int =";
abmshared._sessionmaxinactiveintervalseconds = RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(30),RemoteObject.createImmutable(60)}, "*",0, 1);
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _redirectoutput(RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("RedirectOutput (abmshared) ","abmshared",2,abmshared.ba,abmshared.mostCurrent,59);
if (RapidSub.canDelegate("redirectoutput")) return abmshared.remoteMe.runUserSub(false, "abmshared","redirectoutput", _dir, _filename);
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 59;BA.debugLine="Sub RedirectOutput (Dir As String, FileName As Str";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _replaceall(RemoteObject _text,RemoteObject _pattern,RemoteObject _replacement) throws Exception{
try {
		Debug.PushSubsStack("ReplaceAll (abmshared) ","abmshared",2,abmshared.ba,abmshared.mostCurrent,153);
if (RapidSub.canDelegate("replaceall")) return abmshared.remoteMe.runUserSub(false, "abmshared","replaceall", _text, _pattern, _replacement);
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("Text", _text);
Debug.locals.put("Pattern", _pattern);
Debug.locals.put("Replacement", _replacement);
 BA.debugLineNum = 153;BA.debugLine="Sub ReplaceAll(Text As String, Pattern As String,";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 154;BA.debugLine="Dim jo As JavaObject = Regex.Matcher(Pattern, Te";
Debug.ShouldStop(33554432);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(abmshared.__c.getField(false,"Regex").runMethod(false,"Matcher",(Object)(_pattern),(Object)(_text)).getObject());Debug.locals.put("jo", _jo);
 BA.debugLineNum = 155;BA.debugLine="Return jo.RunMethod(\"replaceAll\", Array(Replacem";
Debug.ShouldStop(67108864);
if (true) return BA.ObjectToString(_jo.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("replaceAll")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_replacement)}))));
 BA.debugLineNum = 156;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}