package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class abmpagetemplatealternative_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private ws As WebSocket 'ignore";
abmpagetemplatealternative._ws = RemoteObject.createNew ("anywheresoftware.b4j.object.WebSocket");__ref.setField("_ws",abmpagetemplatealternative._ws);
 //BA.debugLineNum = 5;BA.debugLine="Public page As ABMPage";
abmpagetemplatealternative._page = RemoteObject.createNew ("com.ab.abmaterial.ABMPage");__ref.setField("_page",abmpagetemplatealternative._page);
 //BA.debugLineNum = 7;BA.debugLine="Private theme As ABMTheme";
abmpagetemplatealternative._theme = RemoteObject.createNew ("com.ab.abmaterial.ABMTheme");__ref.setField("_theme",abmpagetemplatealternative._theme);
 //BA.debugLineNum = 9;BA.debugLine="Private ABM As ABMaterial 'ignore";
abmpagetemplatealternative._abm = RemoteObject.createNew ("com.ab.abmaterial.ABMaterial");__ref.setField("_abm",abmpagetemplatealternative._abm);
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"ABMPageTemplateAlternati";
abmpagetemplatealternative._name = BA.ObjectToString("ABMPageTemplateAlternative");__ref.setField("_name",abmpagetemplatealternative._name);
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
abmpagetemplatealternative._abmpageid = BA.ObjectToString("");__ref.setField("_abmpageid",abmpagetemplatealternative._abmpageid);
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,18);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "abmpagetemplatealternative","initialize", __ref, _ba);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 18;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(131072);
 BA.debugLineNum = 21;BA.debugLine="theme.Initialize(\"pagetheme\")";
Debug.ShouldStop(1048576);
__ref.getField(false,"_theme").runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("pagetheme")));
 BA.debugLineNum = 22;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
Debug.ShouldStop(2097152);
__ref.getField(false,"_theme").runVoidMethod ("AddABMTheme",(Object)(abmpagetemplatealternative._abmshared._mytheme));
 BA.debugLineNum = 27;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
Debug.ShouldStop(67108864);
__ref.getField(false,"_page").runVoidMethod ("InitializeWithTheme",(Object)(__ref.getField(true,"_name")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("/ws/"),abmpagetemplatealternative._abmshared._appname,RemoteObject.createImmutable("/"),__ref.getField(true,"_name"))),(Object)(abmpagetemplatealternative.__c.getField(true,"False")),(Object)(abmpagetemplatealternative._abmshared._sessionmaxinactiveintervalseconds),(Object)(__ref.getField(false,"_theme")));
 BA.debugLineNum = 28;BA.debugLine="page.ShowLoader=True";
Debug.ShouldStop(134217728);
__ref.getField(false,"_page").runMethod(true,"setShowLoader",abmpagetemplatealternative.__c.getField(true,"True"));
 BA.debugLineNum = 29;BA.debugLine="page.PageHTMLName = \"index2.html\"";
Debug.ShouldStop(268435456);
__ref.getField(false,"_page").setField ("PageHTMLName",BA.ObjectToString("index2.html"));
 BA.debugLineNum = 30;BA.debugLine="page.PageTitle = \"\"";
Debug.ShouldStop(536870912);
__ref.getField(false,"_page").setField ("PageTitle",BA.ObjectToString(""));
 BA.debugLineNum = 31;BA.debugLine="page.PageDescription = \"\"";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_page").setField ("PageDescription",BA.ObjectToString(""));
 BA.debugLineNum = 32;BA.debugLine="page.PageKeywords = \"\"";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_page").setField ("PageKeywords",BA.ObjectToString(""));
 BA.debugLineNum = 33;BA.debugLine="page.PageSiteMapPriority = \"\"";
Debug.ShouldStop(1);
__ref.getField(false,"_page").setField ("PageSiteMapPriority",BA.ObjectToString(""));
 BA.debugLineNum = 34;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_YEAR";
Debug.ShouldStop(2);
__ref.getField(false,"_page").setField ("PageSiteMapFrequency",__ref.getField(false,"_abm").getField(true,"SITEMAP_FREQ_YEARLY"));
 BA.debugLineNum = 36;BA.debugLine="page.ShowConnectedIndicator = True";
Debug.ShouldStop(8);
__ref.getField(false,"_page").setField ("ShowConnectedIndicator",abmpagetemplatealternative.__c.getField(true,"True"));
 BA.debugLineNum = 42;BA.debugLine="page.AddRows(2,True, \"\").AddCells12(1,\"\")";
Debug.ShouldStop(512);
__ref.getField(false,"_page").runMethod(false,"AddRows",(Object)(BA.numberCast(int.class, 2)),(Object)(abmpagetemplatealternative.__c.getField(true,"True")),(Object)(RemoteObject.createImmutable(""))).runVoidMethod ("AddCells12",(Object)(BA.numberCast(int.class, 1)),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 43;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
Debug.ShouldStop(1024);
__ref.getField(false,"_page").runVoidMethod ("BuildGrid");
 BA.debugLineNum = 44;BA.debugLine="End Sub";
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
public static RemoteObject  _page_authenticated(RemoteObject __ref,RemoteObject _params) throws Exception{
try {
		Debug.PushSubsStack("Page_Authenticated (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,147);
if (RapidSub.canDelegate("page_authenticated")) return __ref.runUserSub(false, "abmpagetemplatealternative","page_authenticated", __ref, _params);
Debug.locals.put("Params", _params);
 BA.debugLineNum = 147;BA.debugLine="Sub Page_Authenticated(Params As Map)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 149;BA.debugLine="End Sub";
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
public static RemoteObject  _page_fileuploaded(RemoteObject __ref,RemoteObject _filename,RemoteObject _success) throws Exception{
try {
		Debug.PushSubsStack("Page_FileUploaded (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,135);
if (RapidSub.canDelegate("page_fileuploaded")) return __ref.runUserSub(false, "abmpagetemplatealternative","page_fileuploaded", __ref, _filename, _success);
Debug.locals.put("FileName", _filename);
Debug.locals.put("success", _success);
 BA.debugLineNum = 135;BA.debugLine="Sub Page_FileUploaded(FileName As String, success";
Debug.ShouldStop(64);
 BA.debugLineNum = 137;BA.debugLine="End Sub";
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
public static RemoteObject  _page_firebaseautherror(RemoteObject __ref,RemoteObject _extra) throws Exception{
try {
		Debug.PushSubsStack("Page_FirebaseAuthError (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,151);
if (RapidSub.canDelegate("page_firebaseautherror")) return __ref.runUserSub(false, "abmpagetemplatealternative","page_firebaseautherror", __ref, _extra);
Debug.locals.put("extra", _extra);
 BA.debugLineNum = 151;BA.debugLine="Sub Page_FirebaseAuthError(extra As String)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 153;BA.debugLine="End Sub";
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
public static RemoteObject  _page_firebaseauthstatechanged(RemoteObject __ref,RemoteObject _isloggedin) throws Exception{
try {
		Debug.PushSubsStack("Page_FirebaseAuthStateChanged (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,155);
if (RapidSub.canDelegate("page_firebaseauthstatechanged")) return __ref.runUserSub(false, "abmpagetemplatealternative","page_firebaseauthstatechanged", __ref, _isloggedin);
Debug.locals.put("IsLoggedIn", _isloggedin);
 BA.debugLineNum = 155;BA.debugLine="Sub Page_FirebaseAuthStateChanged(IsLoggedIn As Bo";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 157;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("Page_FirebaseStorageError (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,159);
if (RapidSub.canDelegate("page_firebasestorageerror")) return __ref.runUserSub(false, "abmpagetemplatealternative","page_firebasestorageerror", __ref, _jobid, _extra);
Debug.locals.put("jobID", _jobid);
Debug.locals.put("extra", _extra);
 BA.debugLineNum = 159;BA.debugLine="Sub Page_FirebaseStorageError(jobID As String, ext";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 161;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("Page_FirebaseStorageResult (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,163);
if (RapidSub.canDelegate("page_firebasestorageresult")) return __ref.runUserSub(false, "abmpagetemplatealternative","page_firebasestorageresult", __ref, _jobid, _extra);
Debug.locals.put("jobID", _jobid);
Debug.locals.put("extra", _extra);
 BA.debugLineNum = 163;BA.debugLine="Sub Page_FirebaseStorageResult(jobID As String, ex";
Debug.ShouldStop(4);
 BA.debugLineNum = 165;BA.debugLine="End Sub";
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
public static RemoteObject  _page_modalsheetdismissed(RemoteObject __ref,RemoteObject _modalsheetname) throws Exception{
try {
		Debug.PushSubsStack("Page_ModalSheetDismissed (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,167);
if (RapidSub.canDelegate("page_modalsheetdismissed")) return __ref.runUserSub(false, "abmpagetemplatealternative","page_modalsheetdismissed", __ref, _modalsheetname);
Debug.locals.put("ModalSheetName", _modalsheetname);
 BA.debugLineNum = 167;BA.debugLine="Sub Page_ModalSheetDismissed(ModalSheetName As Str";
Debug.ShouldStop(64);
 BA.debugLineNum = 169;BA.debugLine="End Sub";
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
public static RemoteObject  _page_navigationbarclicked(RemoteObject __ref,RemoteObject _action,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("Page_NavigationbarClicked (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,124);
if (RapidSub.canDelegate("page_navigationbarclicked")) return __ref.runUserSub(false, "abmpagetemplatealternative","page_navigationbarclicked", __ref, _action, _value);
Debug.locals.put("Action", _action);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 124;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 126;BA.debugLine="page.SaveNavigationBarPosition";
Debug.ShouldStop(536870912);
__ref.getField(false,"_page").runVoidMethod ("SaveNavigationBarPosition");
 BA.debugLineNum = 127;BA.debugLine="If Action = \"LogOff\" Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_action,BA.ObjectToString("LogOff"))) { 
 BA.debugLineNum = 128;BA.debugLine="ABMShared.LogOff(page)";
Debug.ShouldStop(-2147483648);
abmpagetemplatealternative._abmshared.runVoidMethod ("_logoff",(Object)(__ref.getField(false,"_page")));
 BA.debugLineNum = 129;BA.debugLine="Return";
Debug.ShouldStop(1);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 131;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
Debug.ShouldStop(4);
abmpagetemplatealternative._abmshared.runVoidMethod ("_navigatetopage",(Object)(__ref.getField(false,"_ws")),(Object)(__ref.getField(true,"_abmpageid")),(Object)(_value));
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
		Debug.PushSubsStack("Page_NextContent (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,171);
if (RapidSub.canDelegate("page_nextcontent")) return __ref.runUserSub(false, "abmpagetemplatealternative","page_nextcontent", __ref, _triggercomponent);
Debug.locals.put("TriggerComponent", _triggercomponent);
 BA.debugLineNum = 171;BA.debugLine="Sub Page_NextContent(TriggerComponent As String)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 173;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Page_ParseEvent (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,93);
if (RapidSub.canDelegate("page_parseevent")) return __ref.runUserSub(false, "abmpagetemplatealternative","page_parseevent", __ref, _params);
RemoteObject _eventname = RemoteObject.createImmutable("");
RemoteObject _eventparams = null;
RemoteObject _passedtables = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("Params", _params);
 BA.debugLineNum = 93;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 94;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
Debug.ShouldStop(536870912);
_eventname = BA.ObjectToString(_params.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("eventname")))));Debug.locals.put("eventName", _eventname);Debug.locals.put("eventName", _eventname);
 BA.debugLineNum = 95;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
Debug.ShouldStop(1073741824);
_eventparams = abmpagetemplatealternative.__c.getField(false,"Regex").runMethod(false,"Split",(Object)(BA.ObjectToString(",")),(Object)(BA.ObjectToString(_params.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("eventparams")))))));Debug.locals.put("eventParams", _eventparams);Debug.locals.put("eventParams", _eventparams);
 BA.debugLineNum = 96;BA.debugLine="If eventName = \"beforeunload\" Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_eventname,BA.ObjectToString("beforeunload"))) { 
 BA.debugLineNum = 97;BA.debugLine="Log(\"preparing for url refresh\")";
Debug.ShouldStop(1);
abmpagetemplatealternative.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("preparing for url refresh")));
 BA.debugLineNum = 98;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
Debug.ShouldStop(2);
__ref.getField(false,"_abm").runVoidMethod ("RemoveMeFromCache",(Object)(abmpagetemplatealternative._abmshared._cachedpages),(Object)(__ref.getField(true,"_abmpageid")));
 BA.debugLineNum = 99;BA.debugLine="Return";
Debug.ShouldStop(4);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 101;BA.debugLine="If SubExists(Me, eventName) Then";
Debug.ShouldStop(16);
if (abmpagetemplatealternative.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 102;BA.debugLine="Params.Remove(\"eventname\")";
Debug.ShouldStop(32);
_params.runVoidMethod ("Remove",(Object)((RemoteObject.createImmutable("eventname"))));
 BA.debugLineNum = 103;BA.debugLine="Params.Remove(\"eventparams\")";
Debug.ShouldStop(64);
_params.runVoidMethod ("Remove",(Object)((RemoteObject.createImmutable("eventparams"))));
 BA.debugLineNum = 104;BA.debugLine="Select Case Params.Size";
Debug.ShouldStop(128);
switch (BA.switchObjectToInt(_params.runMethod(true,"getSize"),BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2))) {
case 0: {
 BA.debugLineNum = 106;BA.debugLine="CallSub(Me, eventName)";
Debug.ShouldStop(512);
abmpagetemplatealternative.__c.runMethodAndSync(false,"CallSubNew",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname));
 break; }
case 1: {
 BA.debugLineNum = 108;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
Debug.ShouldStop(2048);
abmpagetemplatealternative.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname),(Object)(_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 0)))))));
 break; }
case 2: {
 BA.debugLineNum = 110;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 0))))),RemoteObject.createImmutable(("abmistable")))) { 
 BA.debugLineNum = 111;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
Debug.ShouldStop(16384);
_passedtables = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_passedtables = __ref.getField(false,"_abm").runMethod(false,"ProcessTablesFromTargetName",(Object)(BA.ObjectToString(_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 1))))))));Debug.locals.put("PassedTables", _passedtables);Debug.locals.put("PassedTables", _passedtables);
 BA.debugLineNum = 112;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
Debug.ShouldStop(32768);
abmpagetemplatealternative.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname),(Object)((_passedtables)));
 }else {
 BA.debugLineNum = 114;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
Debug.ShouldStop(131072);
abmpagetemplatealternative.__c.runMethodAndSync(false,"CallSubNew3",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname),(Object)(_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 0)))))),(Object)(_params.runMethod(false,"Get",(Object)((_eventparams.getArrayElement(true,BA.numberCast(int.class, 1)))))));
 };
 break; }
default: {
 BA.debugLineNum = 118;BA.debugLine="CallSub2(Me, eventName, Params)";
Debug.ShouldStop(2097152);
abmpagetemplatealternative.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref),(Object)(_eventname),(Object)((_params)));
 break; }
}
;
 };
 BA.debugLineNum = 121;BA.debugLine="End Sub";
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
public static RemoteObject  _page_signedoffsocialnetwork(RemoteObject __ref,RemoteObject _network,RemoteObject _extra) throws Exception{
try {
		Debug.PushSubsStack("Page_SignedOffSocialNetwork (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,175);
if (RapidSub.canDelegate("page_signedoffsocialnetwork")) return __ref.runUserSub(false, "abmpagetemplatealternative","page_signedoffsocialnetwork", __ref, _network, _extra);
Debug.locals.put("Network", _network);
Debug.locals.put("Extra", _extra);
 BA.debugLineNum = 175;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
Debug.ShouldStop(16384);
 BA.debugLineNum = 177;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Page_ToastClicked (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,139);
if (RapidSub.canDelegate("page_toastclicked")) return __ref.runUserSub(false, "abmpagetemplatealternative","page_toastclicked", __ref, _toastid, _action);
Debug.locals.put("ToastId", _toastid);
Debug.locals.put("Action", _action);
 BA.debugLineNum = 139;BA.debugLine="Sub Page_ToastClicked(ToastId As String, Action As";
Debug.ShouldStop(1024);
 BA.debugLineNum = 141;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Page_ToastDismissed (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,143);
if (RapidSub.canDelegate("page_toastdismissed")) return __ref.runUserSub(false, "abmpagetemplatealternative","page_toastdismissed", __ref, _toastid);
Debug.locals.put("ToastId", _toastid);
 BA.debugLineNum = 143;BA.debugLine="Sub Page_ToastDismissed(ToastId As String)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 145;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("WebSocket_Connected (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,46);
if (RapidSub.canDelegate("websocket_connected")) return __ref.runUserSub(false, "abmpagetemplatealternative","websocket_connected", __ref, _websocket1);
RemoteObject _session = RemoteObject.declareNull("anywheresoftware.b4j.object.HttpSessionWrapper");
Debug.locals.put("WebSocket1", _websocket1);
 BA.debugLineNum = 46;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="Log(\"Connected\")";
Debug.ShouldStop(16384);
abmpagetemplatealternative.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Connected")));
 BA.debugLineNum = 48;BA.debugLine="ws = WebSocket1";
Debug.ShouldStop(32768);
__ref.setField ("_ws",_websocket1);
 BA.debugLineNum = 49;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
Debug.ShouldStop(65536);
__ref.setField ("_abmpageid",__ref.getField(false,"_abm").runMethod(true,"GetPageID",(Object)(__ref.getField(false,"_page")),(Object)(__ref.getField(true,"_name")),(Object)(__ref.getField(false,"_ws"))));
 BA.debugLineNum = 50;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
Debug.ShouldStop(131072);
_session = RemoteObject.createNew ("anywheresoftware.b4j.object.HttpSessionWrapper");
_session = __ref.getField(false,"_abm").runMethod(false,"GetSession",(Object)(__ref.getField(false,"_ws")),(Object)(abmpagetemplatealternative._abmshared._sessionmaxinactiveintervalseconds));Debug.locals.put("session", _session);Debug.locals.put("session", _session);
 BA.debugLineNum = 52;BA.debugLine="If ABMShared.NeedsAuthorization Then";
Debug.ShouldStop(524288);
if (abmpagetemplatealternative._abmshared._needsauthorization.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 53;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_session.runMethod(false,"GetAttribute2",(Object)(BA.ObjectToString("IsAuthorized")),(Object)((RemoteObject.createImmutable("")))),RemoteObject.createImmutable(("")))) { 
 BA.debugLineNum = 54;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
Debug.ShouldStop(2097152);
abmpagetemplatealternative._abmshared.runVoidMethod ("_navigatetopage",(Object)(__ref.getField(false,"_ws")),(Object)(__ref.getField(true,"_abmpageid")),(Object)(RemoteObject.createImmutable("../")));
 BA.debugLineNum = 55;BA.debugLine="Return";
Debug.ShouldStop(4194304);
if (true) return RemoteObject.createImmutable("");
 };
 };
 BA.debugLineNum = 59;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
Debug.ShouldStop(67108864);
__ref.getField(false,"_abm").runVoidMethod ("UpdateFromCache",(Object)((__ref)),(Object)(abmpagetemplatealternative._abmshared._cachedpages),(Object)(__ref.getField(true,"_abmpageid")),(Object)(__ref.getField(false,"_ws")),__ref.getField(false, "ba"));
 BA.debugLineNum = 60;BA.debugLine="If page.ComesFromPageCache Then";
Debug.ShouldStop(134217728);
if (__ref.getField(false,"_page").getField(true,"ComesFromPageCache").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 62;BA.debugLine="page.Refresh";
Debug.ShouldStop(536870912);
__ref.getField(false,"_page").runVoidMethod ("Refresh");
 BA.debugLineNum = 64;BA.debugLine="page.FinishedLoading";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_page").runVoidMethod ("FinishedLoading");
 }else {
 BA.debugLineNum = 67;BA.debugLine="page.Prepare";
Debug.ShouldStop(4);
__ref.getField(false,"_page").runVoidMethod ("Prepare");
 BA.debugLineNum = 80;BA.debugLine="page.Refresh";
Debug.ShouldStop(32768);
__ref.getField(false,"_page").runVoidMethod ("Refresh");
 BA.debugLineNum = 82;BA.debugLine="page.FinishedLoading";
Debug.ShouldStop(131072);
__ref.getField(false,"_page").runVoidMethod ("FinishedLoading");
 BA.debugLineNum = 84;BA.debugLine="page.RestoreNavigationBarPosition";
Debug.ShouldStop(524288);
__ref.getField(false,"_page").runVoidMethod ("RestoreNavigationBarPosition");
 };
 BA.debugLineNum = 86;BA.debugLine="Log(ABMPageId)";
Debug.ShouldStop(2097152);
abmpagetemplatealternative.__c.runVoidMethod ("Log",(Object)(__ref.getField(true,"_abmpageid")));
 BA.debugLineNum = 87;BA.debugLine="End Sub";
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
public static RemoteObject  _websocket_disconnected(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("WebSocket_Disconnected (abmpagetemplatealternative) ","abmpagetemplatealternative",4,__ref.getField(false, "ba"),__ref,89);
if (RapidSub.canDelegate("websocket_disconnected")) return __ref.runUserSub(false, "abmpagetemplatealternative","websocket_disconnected", __ref);
 BA.debugLineNum = 89;BA.debugLine="Private Sub WebSocket_Disconnected";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="Log(\"Disconnected\")";
Debug.ShouldStop(33554432);
abmpagetemplatealternative.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Disconnected")));
 BA.debugLineNum = 91;BA.debugLine="End Sub";
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
}