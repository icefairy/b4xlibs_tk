package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class pguserlist_subs_0 {


public static RemoteObject  _buildpage(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("BuildPage (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,96);
if (RapidSub.canDelegate("buildpage")) return __ref.runUserSub(false, "pguserlist","buildpage", __ref);
 BA.debugLineNum = 96;BA.debugLine="public Sub BuildPage()";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 98;BA.debugLine="BuildTheme";
Debug.ShouldStop(2);
__ref.runClassMethod (b4j.example.pguserlist.class, "_buildtheme");
 BA.debugLineNum = 101;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
Debug.ShouldStop(16);
__ref.getField(false,"_page").runVoidMethod ("InitializeWithTheme",(Object)(__ref.getField(true,"_name")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("/ws/"),pguserlist._abmshared._appname,RemoteObject.createImmutable("/"),__ref.getField(true,"_name"))),(Object)(pguserlist.__c.getField(true,"False")),(Object)(pguserlist._abmshared._sessionmaxinactiveintervalseconds),(Object)(__ref.getField(false,"_theme")));
 BA.debugLineNum = 102;BA.debugLine="page.ShowLoader=True";
Debug.ShouldStop(32);
__ref.getField(false,"_page").runMethod(true,"setShowLoader",pguserlist.__c.getField(true,"True"));
 BA.debugLineNum = 103;BA.debugLine="page.PageHTMLName = \"userlist.html\"";
Debug.ShouldStop(64);
__ref.getField(false,"_page").setField ("PageHTMLName",BA.ObjectToString("userlist.html"));
 BA.debugLineNum = 104;BA.debugLine="page.PageTitle = \"用户列表\"";
Debug.ShouldStop(128);
__ref.getField(false,"_page").setField ("PageTitle",BA.ObjectToString("用户列表"));
 BA.debugLineNum = 105;BA.debugLine="page.PageDescription = \"\"";
Debug.ShouldStop(256);
__ref.getField(false,"_page").setField ("PageDescription",BA.ObjectToString(""));
 BA.debugLineNum = 106;BA.debugLine="page.PageKeywords = \"\"";
Debug.ShouldStop(512);
__ref.getField(false,"_page").setField ("PageKeywords",BA.ObjectToString(""));
 BA.debugLineNum = 107;BA.debugLine="page.PageSiteMapPriority = \"\"";
Debug.ShouldStop(1024);
__ref.getField(false,"_page").setField ("PageSiteMapPriority",BA.ObjectToString(""));
 BA.debugLineNum = 108;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_YEAR";
Debug.ShouldStop(2048);
__ref.getField(false,"_page").setField ("PageSiteMapFrequency",__ref.getField(false,"_abm").getField(true,"SITEMAP_FREQ_YEARLY"));
 BA.debugLineNum = 110;BA.debugLine="page.ShowConnectedIndicator = True";
Debug.ShouldStop(8192);
__ref.getField(false,"_page").setField ("ShowConnectedIndicator",pguserlist.__c.getField(true,"True"));
 BA.debugLineNum = 116;BA.debugLine="page.AddRows(2,True, \"\").AddCells12(1,\"\")";
Debug.ShouldStop(524288);
__ref.getField(false,"_page").runMethod(false,"AddRows",(Object)(BA.numberCast(int.class, 2)),(Object)(pguserlist.__c.getField(true,"True")),(Object)(RemoteObject.createImmutable(""))).runVoidMethod ("AddCells12",(Object)(BA.numberCast(int.class, 1)),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 117;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
Debug.ShouldStop(1048576);
__ref.getField(false,"_page").runVoidMethod ("BuildGrid");
 BA.debugLineNum = 119;BA.debugLine="End Sub";
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
public static RemoteObject  _buildtheme(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("BuildTheme (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,87);
if (RapidSub.canDelegate("buildtheme")) return __ref.runUserSub(false, "pguserlist","buildtheme", __ref);
 BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
Debug.ShouldStop(16777216);
__ref.getField(false,"_theme").runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("pagetheme")));
 BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
Debug.ShouldStop(33554432);
__ref.getField(false,"_theme").runVoidMethod ("AddABMTheme",(Object)(pguserlist._abmshared._mytheme));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private ws As WebSocket 'ignore";
pguserlist._ws = RemoteObject.createNew ("anywheresoftware.b4j.object.WebSocket");__ref.setField("_ws",pguserlist._ws);
 //BA.debugLineNum = 5;BA.debugLine="Public page As ABMPage";
pguserlist._page = RemoteObject.createNew ("com.ab.abmaterial.ABMPage");__ref.setField("_page",pguserlist._page);
 //BA.debugLineNum = 7;BA.debugLine="Private theme As ABMTheme";
pguserlist._theme = RemoteObject.createNew ("com.ab.abmaterial.ABMTheme");__ref.setField("_theme",pguserlist._theme);
 //BA.debugLineNum = 9;BA.debugLine="Private ABM As ABMaterial 'ignore";
pguserlist._abm = RemoteObject.createNew ("com.ab.abmaterial.ABMaterial");__ref.setField("_abm",pguserlist._abm);
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"pgUserList\"  '<---------";
pguserlist._name = BA.ObjectToString("pgUserList");__ref.setField("_name",pguserlist._name);
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
pguserlist._abmpageid = BA.ObjectToString("");__ref.setField("_abmpageid",pguserlist._abmpageid);
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _connectpage(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("ConnectPage (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,121);
if (RapidSub.canDelegate("connectpage")) return __ref.runUserSub(false, "pguserlist","connectpage", __ref);
 BA.debugLineNum = 121;BA.debugLine="public Sub ConnectPage()";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 134;BA.debugLine="page.Refresh";
Debug.ShouldStop(32);
__ref.getField(false,"_page").runVoidMethod ("Refresh");
 BA.debugLineNum = 136;BA.debugLine="page.FinishedLoading";
Debug.ShouldStop(128);
__ref.getField(false,"_page").runVoidMethod ("FinishedLoading");
 BA.debugLineNum = 138;BA.debugLine="page.RestoreNavigationBarPosition";
Debug.ShouldStop(512);
__ref.getField(false,"_page").runVoidMethod ("RestoreNavigationBarPosition");
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,19);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "pguserlist","initialize", __ref, _ba);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 19;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(262144);
 BA.debugLineNum = 21;BA.debugLine="BuildPage";
Debug.ShouldStop(1048576);
__ref.runClassMethod (b4j.example.pguserlist.class, "_buildpage");
 BA.debugLineNum = 22;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_authenticated(RemoteObject __ref,RemoteObject _params) throws Exception{
try {
		Debug.PushSubsStack("Page_Authenticated (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,164);
if (RapidSub.canDelegate("page_authenticated")) return __ref.runUserSub(false, "pguserlist","page_authenticated", __ref, _params);
Debug.locals.put("Params", _params);
 BA.debugLineNum = 164;BA.debugLine="Sub Page_Authenticated(Params As Map)";
Debug.ShouldStop(8);
 BA.debugLineNum = 166;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_fileuploaded(RemoteObject __ref,RemoteObject _filename,RemoteObject _success) throws Exception{
try {
		Debug.PushSubsStack("Page_FileUploaded (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,152);
if (RapidSub.canDelegate("page_fileuploaded")) return __ref.runUserSub(false, "pguserlist","page_fileuploaded", __ref, _filename, _success);
Debug.locals.put("FileName", _filename);
Debug.locals.put("success", _success);
 BA.debugLineNum = 152;BA.debugLine="Sub Page_FileUploaded(FileName As String, success";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 154;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_firebaseautherror(RemoteObject __ref,RemoteObject _extra) throws Exception{
try {
		Debug.PushSubsStack("Page_FirebaseAuthError (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,168);
if (RapidSub.canDelegate("page_firebaseautherror")) return __ref.runUserSub(false, "pguserlist","page_firebaseautherror", __ref, _extra);
Debug.locals.put("extra", _extra);
 BA.debugLineNum = 168;BA.debugLine="Sub Page_FirebaseAuthError(extra As String)";
Debug.ShouldStop(128);
 BA.debugLineNum = 170;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_firebaseauthstatechanged(RemoteObject __ref,RemoteObject _isloggedin) throws Exception{
try {
		Debug.PushSubsStack("Page_FirebaseAuthStateChanged (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,172);
if (RapidSub.canDelegate("page_firebaseauthstatechanged")) return __ref.runUserSub(false, "pguserlist","page_firebaseauthstatechanged", __ref, _isloggedin);
Debug.locals.put("IsLoggedIn", _isloggedin);
 BA.debugLineNum = 172;BA.debugLine="Sub Page_FirebaseAuthStateChanged(IsLoggedIn As Bo";
Debug.ShouldStop(2048);
 BA.debugLineNum = 174;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_firebasestorageerror(RemoteObject __ref,RemoteObject _jobid,RemoteObject _extra) throws Exception{
try {
		Debug.PushSubsStack("Page_FirebaseStorageError (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,176);
if (RapidSub.canDelegate("page_firebasestorageerror")) return __ref.runUserSub(false, "pguserlist","page_firebasestorageerror", __ref, _jobid, _extra);
Debug.locals.put("jobID", _jobid);
Debug.locals.put("extra", _extra);
 BA.debugLineNum = 176;BA.debugLine="Sub Page_FirebaseStorageError(jobID As String, ext";
Debug.ShouldStop(32768);
 BA.debugLineNum = 178;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_firebasestorageresult(RemoteObject __ref,RemoteObject _jobid,RemoteObject _extra) throws Exception{
try {
		Debug.PushSubsStack("Page_FirebaseStorageResult (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,180);
if (RapidSub.canDelegate("page_firebasestorageresult")) return __ref.runUserSub(false, "pguserlist","page_firebasestorageresult", __ref, _jobid, _extra);
Debug.locals.put("jobID", _jobid);
Debug.locals.put("extra", _extra);
 BA.debugLineNum = 180;BA.debugLine="Sub Page_FirebaseStorageResult(jobID As String, ex";
Debug.ShouldStop(524288);
 BA.debugLineNum = 182;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_modalsheetdismissed(RemoteObject __ref,RemoteObject _modalsheetname) throws Exception{
try {
		Debug.PushSubsStack("Page_ModalSheetDismissed (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,184);
if (RapidSub.canDelegate("page_modalsheetdismissed")) return __ref.runUserSub(false, "pguserlist","page_modalsheetdismissed", __ref, _modalsheetname);
Debug.locals.put("ModalSheetName", _modalsheetname);
 BA.debugLineNum = 184;BA.debugLine="Sub Page_ModalSheetDismissed(ModalSheetName As Str";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 186;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_navigationbarclicked(RemoteObject __ref,RemoteObject _action,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("Page_NavigationbarClicked (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,142);
if (RapidSub.canDelegate("page_navigationbarclicked")) return __ref.runUserSub(false, "pguserlist","page_navigationbarclicked", __ref, _action, _value);
Debug.locals.put("Action", _action);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 142;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
Debug.ShouldStop(8192);
 BA.debugLineNum = 144;BA.debugLine="page.SaveNavigationBarPosition";
Debug.ShouldStop(32768);
__ref.getField(false,"_page").runVoidMethod ("SaveNavigationBarPosition");
 BA.debugLineNum = 145;BA.debugLine="If Action = \"LogOff\" Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_action,BA.ObjectToString("LogOff"))) { 
 BA.debugLineNum = 146;BA.debugLine="ABMShared.LogOff(page)";
Debug.ShouldStop(131072);
pguserlist._abmshared.runVoidMethod ("_logoff",(Object)(__ref.getField(false,"_page")));
 BA.debugLineNum = 147;BA.debugLine="Return";
Debug.ShouldStop(262144);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 149;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
Debug.ShouldStop(1048576);
pguserlist._abmshared.runVoidMethod ("_navigatetopage",(Object)(__ref.getField(false,"_ws")),(Object)(__ref.getField(true,"_abmpageid")),(Object)(_value));
 BA.debugLineNum = 150;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_nextcontent(RemoteObject __ref,RemoteObject _triggercomponent) throws Exception{
try {
		Debug.PushSubsStack("Page_NextContent (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,188);
if (RapidSub.canDelegate("page_nextcontent")) return __ref.runUserSub(false, "pguserlist","page_nextcontent", __ref, _triggercomponent);
Debug.locals.put("TriggerComponent", _triggercomponent);
 BA.debugLineNum = 188;BA.debugLine="Sub Page_NextContent(TriggerComponent As String)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 190;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_parseevent(RemoteObject __ref,RemoteObject _params) throws Exception{
try {
		Debug.PushSubsStack("Page_ParseEvent (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,57);
if (RapidSub.canDelegate("page_parseevent")) return __ref.runUserSub(false, "pguserlist","page_parseevent", __ref, _params);
RemoteObject _eventname = RemoteObject.createImmutable("");
RemoteObject _eventparams = null;
RemoteObject _passedtables = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("Params", _params);
 BA.debugLineNum = 57;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 58;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
Debug.ShouldStop(33554432);
_eventname = BA.ObjectToString(_params.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("eventname")))));Debug.locals.put("eventName", _eventname);Debug.locals.put("eventName", _eventname);
 BA.debugLineNum = 59;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
Debug.ShouldStop(67108864);
_eventparams = pguserlist.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(",")),(Object)(BA.ObjectToString(_params.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("eventparams")))))));Debug.locals.put("eventParams", _eventparams);Debug.locals.put("eventParams", _eventparams);
 BA.debugLineNum = 60;BA.debugLine="If eventName = \"beforeunload\" Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_eventname,BA.ObjectToString("beforeunload"))) { 
 BA.debugLineNum = 61;BA.debugLine="Log(\"preparing for url refresh\")";
Debug.ShouldStop(268435456);
pguserlist.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("preparing for url refresh")));
 BA.debugLineNum = 62;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
Debug.ShouldStop(536870912);
__ref.getField(false,"_abm").runVoidMethod ("RemoveMeFromCache",(Object)(pguserlist._abmshared._cachedpages),(Object)(__ref.getField(true,"_abmpageid")));
 BA.debugLineNum = 63;BA.debugLine="Return";
Debug.ShouldStop(1073741824);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 65;BA.debugLine="If SubExists(Me, eventName) Then";
Debug.ShouldStop(1);
if (pguserlist.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 66;BA.debugLine="Params.Remove(\"eventname\")";
Debug.ShouldStop(2);
_params.runVoidMethod ("Remove",(Object)((RemoteObject.createImmutable("eventname"))));
 BA.debugLineNum = 67;BA.debugLine="Params.Remove(\"eventparams\")";
Debug.ShouldStop(4);
_params.runVoidMethod ("Remove",(Object)((RemoteObject.createImmutable("eventparams"))));
 BA.debugLineNum = 68;BA.debugLine="Select Case Params.Size";
Debug.ShouldStop(8);
switch (BA.switchObjectToInt(_params.runMethod(true,"getSize"),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2))) {
case 0: {
 BA.debugLineNum = 70;BA.debugLine="CallSub(Me, eventName)";
Debug.ShouldStop(32);
pguserlist.__c.runMethodAndSync(false,"CallSubNew",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname));
 break; }
case 1: {
 BA.debugLineNum = 72;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
Debug.ShouldStop(128);
pguserlist.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname),(Object)(_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 0)))))));
 break; }
case 2: {
 BA.debugLineNum = 74;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 0))))),RemoteObject.createImmutable(("abmistable")))) { 
 BA.debugLineNum = 75;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
Debug.ShouldStop(1024);
_passedtables = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_passedtables = __ref.getField(false,"_abm").runMethod(false,"ProcessTablesFromTargetName",(Object)(BA.ObjectToString(_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 1))))))));Debug.locals.put("PassedTables", _passedtables);Debug.locals.put("PassedTables", _passedtables);
 BA.debugLineNum = 76;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
Debug.ShouldStop(2048);
pguserlist.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname),(Object)((_passedtables)));
 }else {
 BA.debugLineNum = 78;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
Debug.ShouldStop(8192);
pguserlist.__c.runMethodAndSync(false,"CallSubNew3",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname),(Object)(_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 0)))))),(Object)(_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 1)))))));
 };
 break; }
default: {
 BA.debugLineNum = 82;BA.debugLine="CallSub2(Me, eventName, Params)";
Debug.ShouldStop(131072);
pguserlist.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname),(Object)((_params)));
 break; }
}
;
 };
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
public static RemoteObject  _page_signedoffsocialnetwork(RemoteObject __ref,RemoteObject _network,RemoteObject _extra) throws Exception{
try {
		Debug.PushSubsStack("Page_SignedOffSocialNetwork (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,192);
if (RapidSub.canDelegate("page_signedoffsocialnetwork")) return __ref.runUserSub(false, "pguserlist","page_signedoffsocialnetwork", __ref, _network, _extra);
Debug.locals.put("Network", _network);
Debug.locals.put("Extra", _extra);
 BA.debugLineNum = 192;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 194;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_toastclicked(RemoteObject __ref,RemoteObject _toastid,RemoteObject _action) throws Exception{
try {
		Debug.PushSubsStack("Page_ToastClicked (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,156);
if (RapidSub.canDelegate("page_toastclicked")) return __ref.runUserSub(false, "pguserlist","page_toastclicked", __ref, _toastid, _action);
Debug.locals.put("ToastId", _toastid);
Debug.locals.put("Action", _action);
 BA.debugLineNum = 156;BA.debugLine="Sub Page_ToastClicked(ToastId As String, Action As";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page_toastdismissed(RemoteObject __ref,RemoteObject _toastid) throws Exception{
try {
		Debug.PushSubsStack("Page_ToastDismissed (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,160);
if (RapidSub.canDelegate("page_toastdismissed")) return __ref.runUserSub(false, "pguserlist","page_toastdismissed", __ref, _toastid);
Debug.locals.put("ToastId", _toastid);
 BA.debugLineNum = 160;BA.debugLine="Sub Page_ToastDismissed(ToastId As String)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 162;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _websocket_connected(RemoteObject __ref,RemoteObject _websocket1) throws Exception{
try {
		Debug.PushSubsStack("WebSocket_Connected (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,24);
if (RapidSub.canDelegate("websocket_connected")) return __ref.runUserSub(false, "pguserlist","websocket_connected", __ref, _websocket1);
RemoteObject _session = RemoteObject.declareNull("anywheresoftware.b4j.object.HttpSessionWrapper");
Debug.locals.put("WebSocket1", _websocket1);
 BA.debugLineNum = 24;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="Log(\"Connected\")";
Debug.ShouldStop(16777216);
pguserlist.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Connected")));
 BA.debugLineNum = 26;BA.debugLine="ws = WebSocket1";
Debug.ShouldStop(33554432);
__ref.setField ("_ws",_websocket1);
 BA.debugLineNum = 27;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
Debug.ShouldStop(67108864);
__ref.setField ("_abmpageid",__ref.getField(false,"_abm").runMethod(true,"GetPageID",(Object)(__ref.getField(false,"_page")),(Object)(__ref.getField(true,"_name")),(Object)(__ref.getField(false,"_ws"))));
 BA.debugLineNum = 28;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
Debug.ShouldStop(134217728);
_session = RemoteObject.createNew ("anywheresoftware.b4j.object.HttpSessionWrapper");
_session = __ref.getField(false,"_abm").runMethod(false,"GetSession",(Object)(__ref.getField(false,"_ws")),(Object)(pguserlist._abmshared._sessionmaxinactiveintervalseconds));Debug.locals.put("session", _session);Debug.locals.put("session", _session);
 BA.debugLineNum = 30;BA.debugLine="If ABMShared.NeedsAuthorization Then";
Debug.ShouldStop(536870912);
if (pguserlist._abmshared._needsauthorization.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 31;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_session.runMethod(false,"GetAttribute2",(Object)(BA.ObjectToString("IsAuthorized")),(Object)((RemoteObject.createImmutable("")))),RemoteObject.createImmutable(("")))) { 
 BA.debugLineNum = 32;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
Debug.ShouldStop(-2147483648);
pguserlist._abmshared.runVoidMethod ("_navigatetopage",(Object)(__ref.getField(false,"_ws")),(Object)(__ref.getField(true,"_abmpageid")),(Object)(RemoteObject.createImmutable("../")));
 BA.debugLineNum = 33;BA.debugLine="Return";
Debug.ShouldStop(1);
if (true) return RemoteObject.createImmutable("");
 };
 };
 BA.debugLineNum = 37;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
Debug.ShouldStop(16);
__ref.getField(false,"_abm").runVoidMethod ("UpdateFromCache",(Object)((__ref)),(Object)(pguserlist._abmshared._cachedpages),(Object)(__ref.getField(true,"_abmpageid")),(Object)(__ref.getField(false,"_ws")),__ref.getField(false, "ba"));
 BA.debugLineNum = 38;BA.debugLine="If page.ComesFromPageCache Then";
Debug.ShouldStop(32);
if (__ref.getField(false,"_page").getField(true,"ComesFromPageCache").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 40;BA.debugLine="page.Refresh";
Debug.ShouldStop(128);
__ref.getField(false,"_page").runVoidMethod ("Refresh");
 BA.debugLineNum = 42;BA.debugLine="page.FinishedLoading";
Debug.ShouldStop(512);
__ref.getField(false,"_page").runVoidMethod ("FinishedLoading");
 }else {
 BA.debugLineNum = 45;BA.debugLine="page.Prepare";
Debug.ShouldStop(4096);
__ref.getField(false,"_page").runVoidMethod ("Prepare");
 BA.debugLineNum = 47;BA.debugLine="ConnectPage";
Debug.ShouldStop(16384);
__ref.runClassMethod (b4j.example.pguserlist.class, "_connectpage");
 };
 BA.debugLineNum = 49;BA.debugLine="Log(ABMPageId)";
Debug.ShouldStop(65536);
pguserlist.__c.runVoidMethod ("Log",(Object)(__ref.getField(true,"_abmpageid")));
 BA.debugLineNum = 51;BA.debugLine="End Sub";
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
public static RemoteObject  _websocket_disconnected(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("WebSocket_Disconnected (pguserlist) ","pguserlist",9,__ref.getField(false, "ba"),__ref,53);
if (RapidSub.canDelegate("websocket_disconnected")) return __ref.runUserSub(false, "pguserlist","websocket_disconnected", __ref);
 BA.debugLineNum = 53;BA.debugLine="Private Sub WebSocket_Disconnected";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="Log(\"Disconnected\")";
Debug.ShouldStop(2097152);
pguserlist.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Disconnected")));
 BA.debugLineNum = 55;BA.debugLine="End Sub";
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
}