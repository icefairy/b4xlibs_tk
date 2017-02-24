package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class abmpagetemplatealternative extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.ShellBA("b4j.example", "b4j.example.abmpagetemplatealternative", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.abmpagetemplatealternative.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.object.WebSocket _ws = null;
public com.ab.abmaterial.ABMPage _page = null;
public com.ab.abmaterial.ABMTheme _theme = null;
public com.ab.abmaterial.ABMaterial _abm = null;
public String _name = "";
public String _abmpageid = "";
public b4j.example.main _main = null;
public b4j.example.abmshared _abmshared = null;
public b4j.example.dbm _dbm = null;
public String  _class_globals(b4j.example.abmpagetemplatealternative __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="Private ws As WebSocket 'ignore";
_ws = new anywheresoftware.b4j.object.WebSocket();
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="Public page As ABMPage";
_page = new com.ab.abmaterial.ABMPage();
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="Private theme As ABMTheme";
_theme = new com.ab.abmaterial.ABMTheme();
RDebugUtils.currentLine=3080199;
 //BA.debugLineNum = 3080199;BA.debugLine="Private ABM As ABMaterial 'ignore";
_abm = new com.ab.abmaterial.ABMaterial();
RDebugUtils.currentLine=3080201;
 //BA.debugLineNum = 3080201;BA.debugLine="Public Name As String = \"ABMPageTemplateAlternati";
_name = "ABMPageTemplateAlternative";
RDebugUtils.currentLine=3080203;
 //BA.debugLineNum = 3080203;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
RDebugUtils.currentLine=3080205;
 //BA.debugLineNum = 3080205;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4j.example.abmpagetemplatealternative __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "initialize"))
	return (String) Debug.delegate(ba, "initialize", new Object[] {_ba});
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="theme.Initialize(\"pagetheme\")";
__ref._theme.Initialize("pagetheme");
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
__ref._theme.AddABMTheme(_abmshared._mytheme);
RDebugUtils.currentLine=3145737;
 //BA.debugLineNum = 3145737;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
__ref._page.InitializeWithTheme(__ref._name,"/ws/"+_abmshared._appname+"/"+__ref._name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,__ref._theme);
RDebugUtils.currentLine=3145738;
 //BA.debugLineNum = 3145738;BA.debugLine="page.ShowLoader=True";
__ref._page.setShowLoader(__c.True);
RDebugUtils.currentLine=3145739;
 //BA.debugLineNum = 3145739;BA.debugLine="page.PageHTMLName = \"index2.html\"";
__ref._page.PageHTMLName = "index2.html";
RDebugUtils.currentLine=3145740;
 //BA.debugLineNum = 3145740;BA.debugLine="page.PageTitle = \"\"";
__ref._page.PageTitle = "";
RDebugUtils.currentLine=3145741;
 //BA.debugLineNum = 3145741;BA.debugLine="page.PageDescription = \"\"";
__ref._page.PageDescription = "";
RDebugUtils.currentLine=3145742;
 //BA.debugLineNum = 3145742;BA.debugLine="page.PageKeywords = \"\"";
__ref._page.PageKeywords = "";
RDebugUtils.currentLine=3145743;
 //BA.debugLineNum = 3145743;BA.debugLine="page.PageSiteMapPriority = \"\"";
__ref._page.PageSiteMapPriority = "";
RDebugUtils.currentLine=3145744;
 //BA.debugLineNum = 3145744;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_YEAR";
__ref._page.PageSiteMapFrequency = __ref._abm.SITEMAP_FREQ_YEARLY;
RDebugUtils.currentLine=3145746;
 //BA.debugLineNum = 3145746;BA.debugLine="page.ShowConnectedIndicator = True";
__ref._page.ShowConnectedIndicator = __c.True;
RDebugUtils.currentLine=3145752;
 //BA.debugLineNum = 3145752;BA.debugLine="page.AddRows(2,True, \"\").AddCells12(1,\"\")";
__ref._page.AddRows((int) (2),__c.True,"").AddCells12((int) (1),"");
RDebugUtils.currentLine=3145753;
 //BA.debugLineNum = 3145753;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
__ref._page.BuildGrid();
RDebugUtils.currentLine=3145754;
 //BA.debugLineNum = 3145754;BA.debugLine="End Sub";
return "";
}
public String  _page_authenticated(b4j.example.abmpagetemplatealternative __ref,anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "page_authenticated"))
	return (String) Debug.delegate(ba, "page_authenticated", new Object[] {_params});
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub Page_Authenticated(Params As Map)";
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="End Sub";
return "";
}
public String  _page_fileuploaded(b4j.example.abmpagetemplatealternative __ref,String _filename,boolean _success) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "page_fileuploaded"))
	return (String) Debug.delegate(ba, "page_fileuploaded", new Object[] {_filename,_success});
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub Page_FileUploaded(FileName As String, success";
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="End Sub";
return "";
}
public String  _page_firebaseautherror(b4j.example.abmpagetemplatealternative __ref,String _extra) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "page_firebaseautherror"))
	return (String) Debug.delegate(ba, "page_firebaseautherror", new Object[] {_extra});
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub Page_FirebaseAuthError(extra As String)";
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="End Sub";
return "";
}
public String  _page_firebaseauthstatechanged(b4j.example.abmpagetemplatealternative __ref,boolean _isloggedin) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "page_firebaseauthstatechanged"))
	return (String) Debug.delegate(ba, "page_firebaseauthstatechanged", new Object[] {_isloggedin});
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub Page_FirebaseAuthStateChanged(IsLoggedIn As Bo";
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="End Sub";
return "";
}
public String  _page_firebasestorageerror(b4j.example.abmpagetemplatealternative __ref,String _jobid,String _extra) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "page_firebasestorageerror"))
	return (String) Debug.delegate(ba, "page_firebasestorageerror", new Object[] {_jobid,_extra});
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub Page_FirebaseStorageError(jobID As String, ext";
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="End Sub";
return "";
}
public String  _page_firebasestorageresult(b4j.example.abmpagetemplatealternative __ref,String _jobid,String _extra) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "page_firebasestorageresult"))
	return (String) Debug.delegate(ba, "page_firebasestorageresult", new Object[] {_jobid,_extra});
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub Page_FirebaseStorageResult(jobID As String, ex";
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="End Sub";
return "";
}
public String  _page_modalsheetdismissed(b4j.example.abmpagetemplatealternative __ref,String _modalsheetname) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "page_modalsheetdismissed"))
	return (String) Debug.delegate(ba, "page_modalsheetdismissed", new Object[] {_modalsheetname});
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub Page_ModalSheetDismissed(ModalSheetName As Str";
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(b4j.example.abmpagetemplatealternative __ref,String _action,String _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "page_navigationbarclicked"))
	return (String) Debug.delegate(ba, "page_navigationbarclicked", new Object[] {_action,_value});
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="page.SaveNavigationBarPosition";
__ref._page.SaveNavigationBarPosition();
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(__ref._page);
RDebugUtils.currentLine=3407877;
 //BA.debugLineNum = 3407877;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(__ref._ws,__ref._abmpageid,_value);
RDebugUtils.currentLine=3407880;
 //BA.debugLineNum = 3407880;BA.debugLine="End Sub";
return "";
}
public String  _page_nextcontent(b4j.example.abmpagetemplatealternative __ref,String _triggercomponent) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "page_nextcontent"))
	return (String) Debug.delegate(ba, "page_nextcontent", new Object[] {_triggercomponent});
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub Page_NextContent(TriggerComponent As String)";
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(b4j.example.abmpagetemplatealternative __ref,anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "page_parseevent"))
	return (String) Debug.delegate(ba, "page_parseevent", new Object[] {_params});
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
RDebugUtils.currentLine=3342341;
 //BA.debugLineNum = 3342341;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
__ref._abm.RemoveMeFromCache(_abmshared._cachedpages,__ref._abmpageid);
RDebugUtils.currentLine=3342342;
 //BA.debugLineNum = 3342342;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=3342344;
 //BA.debugLineNum = 3342344;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
RDebugUtils.currentLine=3342345;
 //BA.debugLineNum = 3342345;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
RDebugUtils.currentLine=3342346;
 //BA.debugLineNum = 3342346;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
RDebugUtils.currentLine=3342347;
 //BA.debugLineNum = 3342347;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
RDebugUtils.currentLine=3342349;
 //BA.debugLineNum = 3342349;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
RDebugUtils.currentLine=3342351;
 //BA.debugLineNum = 3342351;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
RDebugUtils.currentLine=3342353;
 //BA.debugLineNum = 3342353;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
RDebugUtils.currentLine=3342354;
 //BA.debugLineNum = 3342354;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = __ref._abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
RDebugUtils.currentLine=3342355;
 //BA.debugLineNum = 3342355;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
RDebugUtils.currentLine=3342357;
 //BA.debugLineNum = 3342357;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
RDebugUtils.currentLine=3342361;
 //BA.debugLineNum = 3342361;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
RDebugUtils.currentLine=3342364;
 //BA.debugLineNum = 3342364;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(b4j.example.abmpagetemplatealternative __ref,String _network,String _extra) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "page_signedoffsocialnetwork"))
	return (String) Debug.delegate(ba, "page_signedoffsocialnetwork", new Object[] {_network,_extra});
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="End Sub";
return "";
}
public String  _page_toastclicked(b4j.example.abmpagetemplatealternative __ref,String _toastid,String _action) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "page_toastclicked"))
	return (String) Debug.delegate(ba, "page_toastclicked", new Object[] {_toastid,_action});
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub Page_ToastClicked(ToastId As String, Action As";
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="End Sub";
return "";
}
public String  _page_toastdismissed(b4j.example.abmpagetemplatealternative __ref,String _toastid) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "page_toastdismissed"))
	return (String) Debug.delegate(ba, "page_toastdismissed", new Object[] {_toastid});
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub Page_ToastDismissed(ToastId As String)";
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(b4j.example.abmpagetemplatealternative __ref,anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "websocket_connected"))
	return (String) Debug.delegate(ba, "websocket_connected", new Object[] {_websocket1});
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="ws = WebSocket1";
__ref._ws = _websocket1;
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
__ref._abmpageid = __ref._abm.GetPageID(__ref._page,__ref._name,__ref._ws);
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = __ref._abm.GetSession(__ref._ws,_abmshared._sessionmaxinactiveintervalseconds);
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
RDebugUtils.currentLine=3211272;
 //BA.debugLineNum = 3211272;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(__ref._ws,__ref._abmpageid,"../");
RDebugUtils.currentLine=3211273;
 //BA.debugLineNum = 3211273;BA.debugLine="Return";
if (true) return "";
 };
 };
RDebugUtils.currentLine=3211277;
 //BA.debugLineNum = 3211277;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
__ref._abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,__ref._abmpageid,__ref._ws,ba);
RDebugUtils.currentLine=3211278;
 //BA.debugLineNum = 3211278;BA.debugLine="If page.ComesFromPageCache Then";
if (__ref._page.ComesFromPageCache) { 
RDebugUtils.currentLine=3211280;
 //BA.debugLineNum = 3211280;BA.debugLine="page.Refresh";
__ref._page.Refresh();
RDebugUtils.currentLine=3211282;
 //BA.debugLineNum = 3211282;BA.debugLine="page.FinishedLoading";
__ref._page.FinishedLoading();
 }else {
RDebugUtils.currentLine=3211285;
 //BA.debugLineNum = 3211285;BA.debugLine="page.Prepare";
__ref._page.Prepare();
RDebugUtils.currentLine=3211298;
 //BA.debugLineNum = 3211298;BA.debugLine="page.Refresh";
__ref._page.Refresh();
RDebugUtils.currentLine=3211300;
 //BA.debugLineNum = 3211300;BA.debugLine="page.FinishedLoading";
__ref._page.FinishedLoading();
RDebugUtils.currentLine=3211302;
 //BA.debugLineNum = 3211302;BA.debugLine="page.RestoreNavigationBarPosition";
__ref._page.RestoreNavigationBarPosition();
 };
RDebugUtils.currentLine=3211304;
 //BA.debugLineNum = 3211304;BA.debugLine="Log(ABMPageId)";
__c.Log(__ref._abmpageid);
RDebugUtils.currentLine=3211305;
 //BA.debugLineNum = 3211305;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected(b4j.example.abmpagetemplatealternative __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplatealternative";
if (Debug.shouldDelegate(ba, "websocket_disconnected"))
	return (String) Debug.delegate(ba, "websocket_disconnected", null);
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Private Sub WebSocket_Disconnected";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="End Sub";
return "";
}
}