package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class pguserlist extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.ShellBA("b4j.example", "b4j.example.pguserlist", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.pguserlist.class).invoke(this, new Object[] {null});
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
public String  _buildpage(b4j.example.pguserlist __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "buildpage"))
	return (String) Debug.delegate(ba, "buildpage", null);
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="public Sub BuildPage()";
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="BuildTheme";
__ref._buildtheme(null);
RDebugUtils.currentLine=6356997;
 //BA.debugLineNum = 6356997;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
__ref._page.InitializeWithTheme(__ref._name,"/ws/"+_abmshared._appname+"/"+__ref._name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,__ref._theme);
RDebugUtils.currentLine=6356998;
 //BA.debugLineNum = 6356998;BA.debugLine="page.ShowLoader=True";
__ref._page.setShowLoader(__c.True);
RDebugUtils.currentLine=6356999;
 //BA.debugLineNum = 6356999;BA.debugLine="page.PageHTMLName = \"userlist.html\"";
__ref._page.PageHTMLName = "userlist.html";
RDebugUtils.currentLine=6357000;
 //BA.debugLineNum = 6357000;BA.debugLine="page.PageTitle = \"用户列表\"";
__ref._page.PageTitle = "用户列表";
RDebugUtils.currentLine=6357001;
 //BA.debugLineNum = 6357001;BA.debugLine="page.PageDescription = \"\"";
__ref._page.PageDescription = "";
RDebugUtils.currentLine=6357002;
 //BA.debugLineNum = 6357002;BA.debugLine="page.PageKeywords = \"\"";
__ref._page.PageKeywords = "";
RDebugUtils.currentLine=6357003;
 //BA.debugLineNum = 6357003;BA.debugLine="page.PageSiteMapPriority = \"\"";
__ref._page.PageSiteMapPriority = "";
RDebugUtils.currentLine=6357004;
 //BA.debugLineNum = 6357004;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_YEAR";
__ref._page.PageSiteMapFrequency = __ref._abm.SITEMAP_FREQ_YEARLY;
RDebugUtils.currentLine=6357006;
 //BA.debugLineNum = 6357006;BA.debugLine="page.ShowConnectedIndicator = True";
__ref._page.ShowConnectedIndicator = __c.True;
RDebugUtils.currentLine=6357012;
 //BA.debugLineNum = 6357012;BA.debugLine="page.AddRows(2,True, \"\").AddCells12(1,\"\")";
__ref._page.AddRows((int) (2),__c.True,"").AddCells12((int) (1),"");
RDebugUtils.currentLine=6357013;
 //BA.debugLineNum = 6357013;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
__ref._page.BuildGrid();
RDebugUtils.currentLine=6357015;
 //BA.debugLineNum = 6357015;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme(b4j.example.pguserlist __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "buildtheme"))
	return (String) Debug.delegate(ba, "buildtheme", null);
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="public Sub BuildTheme()";
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="theme.Initialize(\"pagetheme\")";
__ref._theme.Initialize("pagetheme");
RDebugUtils.currentLine=6291459;
 //BA.debugLineNum = 6291459;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
__ref._theme.AddABMTheme(_abmshared._mytheme);
RDebugUtils.currentLine=6291463;
 //BA.debugLineNum = 6291463;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4j.example.pguserlist __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="Private ws As WebSocket 'ignore";
_ws = new anywheresoftware.b4j.object.WebSocket();
RDebugUtils.currentLine=5963779;
 //BA.debugLineNum = 5963779;BA.debugLine="Public page As ABMPage";
_page = new com.ab.abmaterial.ABMPage();
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="Private theme As ABMTheme";
_theme = new com.ab.abmaterial.ABMTheme();
RDebugUtils.currentLine=5963783;
 //BA.debugLineNum = 5963783;BA.debugLine="Private ABM As ABMaterial 'ignore";
_abm = new com.ab.abmaterial.ABMaterial();
RDebugUtils.currentLine=5963785;
 //BA.debugLineNum = 5963785;BA.debugLine="Public Name As String = \"pgUserList\"  '<---------";
_name = "pgUserList";
RDebugUtils.currentLine=5963787;
 //BA.debugLineNum = 5963787;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
RDebugUtils.currentLine=5963790;
 //BA.debugLineNum = 5963790;BA.debugLine="End Sub";
return "";
}
public String  _connectpage(b4j.example.pguserlist __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "connectpage"))
	return (String) Debug.delegate(ba, "connectpage", null);
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="public Sub ConnectPage()";
RDebugUtils.currentLine=6422541;
 //BA.debugLineNum = 6422541;BA.debugLine="page.Refresh";
__ref._page.Refresh();
RDebugUtils.currentLine=6422543;
 //BA.debugLineNum = 6422543;BA.debugLine="page.FinishedLoading";
__ref._page.FinishedLoading();
RDebugUtils.currentLine=6422545;
 //BA.debugLineNum = 6422545;BA.debugLine="page.RestoreNavigationBarPosition";
__ref._page.RestoreNavigationBarPosition();
RDebugUtils.currentLine=6422546;
 //BA.debugLineNum = 6422546;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4j.example.pguserlist __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "initialize"))
	return (String) Debug.delegate(ba, "initialize", new Object[] {_ba});
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="BuildPage";
__ref._buildpage(null);
RDebugUtils.currentLine=6029315;
 //BA.debugLineNum = 6029315;BA.debugLine="End Sub";
return "";
}
public String  _page_authenticated(b4j.example.pguserlist __ref,anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "page_authenticated"))
	return (String) Debug.delegate(ba, "page_authenticated", new Object[] {_params});
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Sub Page_Authenticated(Params As Map)";
RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="End Sub";
return "";
}
public String  _page_fileuploaded(b4j.example.pguserlist __ref,String _filename,boolean _success) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "page_fileuploaded"))
	return (String) Debug.delegate(ba, "page_fileuploaded", new Object[] {_filename,_success});
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Sub Page_FileUploaded(FileName As String, success";
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="End Sub";
return "";
}
public String  _page_firebaseautherror(b4j.example.pguserlist __ref,String _extra) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "page_firebaseautherror"))
	return (String) Debug.delegate(ba, "page_firebaseautherror", new Object[] {_extra});
RDebugUtils.currentLine=6815744;
 //BA.debugLineNum = 6815744;BA.debugLine="Sub Page_FirebaseAuthError(extra As String)";
RDebugUtils.currentLine=6815746;
 //BA.debugLineNum = 6815746;BA.debugLine="End Sub";
return "";
}
public String  _page_firebaseauthstatechanged(b4j.example.pguserlist __ref,boolean _isloggedin) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "page_firebaseauthstatechanged"))
	return (String) Debug.delegate(ba, "page_firebaseauthstatechanged", new Object[] {_isloggedin});
RDebugUtils.currentLine=6881280;
 //BA.debugLineNum = 6881280;BA.debugLine="Sub Page_FirebaseAuthStateChanged(IsLoggedIn As Bo";
RDebugUtils.currentLine=6881282;
 //BA.debugLineNum = 6881282;BA.debugLine="End Sub";
return "";
}
public String  _page_firebasestorageerror(b4j.example.pguserlist __ref,String _jobid,String _extra) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "page_firebasestorageerror"))
	return (String) Debug.delegate(ba, "page_firebasestorageerror", new Object[] {_jobid,_extra});
RDebugUtils.currentLine=6946816;
 //BA.debugLineNum = 6946816;BA.debugLine="Sub Page_FirebaseStorageError(jobID As String, ext";
RDebugUtils.currentLine=6946818;
 //BA.debugLineNum = 6946818;BA.debugLine="End Sub";
return "";
}
public String  _page_firebasestorageresult(b4j.example.pguserlist __ref,String _jobid,String _extra) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "page_firebasestorageresult"))
	return (String) Debug.delegate(ba, "page_firebasestorageresult", new Object[] {_jobid,_extra});
RDebugUtils.currentLine=7012352;
 //BA.debugLineNum = 7012352;BA.debugLine="Sub Page_FirebaseStorageResult(jobID As String, ex";
RDebugUtils.currentLine=7012354;
 //BA.debugLineNum = 7012354;BA.debugLine="End Sub";
return "";
}
public String  _page_modalsheetdismissed(b4j.example.pguserlist __ref,String _modalsheetname) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "page_modalsheetdismissed"))
	return (String) Debug.delegate(ba, "page_modalsheetdismissed", new Object[] {_modalsheetname});
RDebugUtils.currentLine=7077888;
 //BA.debugLineNum = 7077888;BA.debugLine="Sub Page_ModalSheetDismissed(ModalSheetName As Str";
RDebugUtils.currentLine=7077890;
 //BA.debugLineNum = 7077890;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(b4j.example.pguserlist __ref,String _action,String _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "page_navigationbarclicked"))
	return (String) Debug.delegate(ba, "page_navigationbarclicked", new Object[] {_action,_value});
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
RDebugUtils.currentLine=6488066;
 //BA.debugLineNum = 6488066;BA.debugLine="page.SaveNavigationBarPosition";
__ref._page.SaveNavigationBarPosition();
RDebugUtils.currentLine=6488067;
 //BA.debugLineNum = 6488067;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
RDebugUtils.currentLine=6488068;
 //BA.debugLineNum = 6488068;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(__ref._page);
RDebugUtils.currentLine=6488069;
 //BA.debugLineNum = 6488069;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=6488071;
 //BA.debugLineNum = 6488071;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(__ref._ws,__ref._abmpageid,_value);
RDebugUtils.currentLine=6488072;
 //BA.debugLineNum = 6488072;BA.debugLine="End Sub";
return "";
}
public String  _page_nextcontent(b4j.example.pguserlist __ref,String _triggercomponent) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "page_nextcontent"))
	return (String) Debug.delegate(ba, "page_nextcontent", new Object[] {_triggercomponent});
RDebugUtils.currentLine=7143424;
 //BA.debugLineNum = 7143424;BA.debugLine="Sub Page_NextContent(TriggerComponent As String)";
RDebugUtils.currentLine=7143426;
 //BA.debugLineNum = 7143426;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(b4j.example.pguserlist __ref,anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "page_parseevent"))
	return (String) Debug.delegate(ba, "page_parseevent", new Object[] {_params});
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
RDebugUtils.currentLine=6225924;
 //BA.debugLineNum = 6225924;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
RDebugUtils.currentLine=6225925;
 //BA.debugLineNum = 6225925;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
__ref._abm.RemoveMeFromCache(_abmshared._cachedpages,__ref._abmpageid);
RDebugUtils.currentLine=6225926;
 //BA.debugLineNum = 6225926;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=6225928;
 //BA.debugLineNum = 6225928;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
RDebugUtils.currentLine=6225929;
 //BA.debugLineNum = 6225929;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
RDebugUtils.currentLine=6225930;
 //BA.debugLineNum = 6225930;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
RDebugUtils.currentLine=6225931;
 //BA.debugLineNum = 6225931;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
RDebugUtils.currentLine=6225933;
 //BA.debugLineNum = 6225933;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
RDebugUtils.currentLine=6225935;
 //BA.debugLineNum = 6225935;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
RDebugUtils.currentLine=6225937;
 //BA.debugLineNum = 6225937;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
RDebugUtils.currentLine=6225938;
 //BA.debugLineNum = 6225938;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = __ref._abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
RDebugUtils.currentLine=6225939;
 //BA.debugLineNum = 6225939;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
RDebugUtils.currentLine=6225941;
 //BA.debugLineNum = 6225941;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
RDebugUtils.currentLine=6225945;
 //BA.debugLineNum = 6225945;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
RDebugUtils.currentLine=6225948;
 //BA.debugLineNum = 6225948;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(b4j.example.pguserlist __ref,String _network,String _extra) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "page_signedoffsocialnetwork"))
	return (String) Debug.delegate(ba, "page_signedoffsocialnetwork", new Object[] {_network,_extra});
RDebugUtils.currentLine=7208960;
 //BA.debugLineNum = 7208960;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
RDebugUtils.currentLine=7208962;
 //BA.debugLineNum = 7208962;BA.debugLine="End Sub";
return "";
}
public String  _page_toastclicked(b4j.example.pguserlist __ref,String _toastid,String _action) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "page_toastclicked"))
	return (String) Debug.delegate(ba, "page_toastclicked", new Object[] {_toastid,_action});
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Sub Page_ToastClicked(ToastId As String, Action As";
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="End Sub";
return "";
}
public String  _page_toastdismissed(b4j.example.pguserlist __ref,String _toastid) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "page_toastdismissed"))
	return (String) Debug.delegate(ba, "page_toastdismissed", new Object[] {_toastid});
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Sub Page_ToastDismissed(ToastId As String)";
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(b4j.example.pguserlist __ref,anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "websocket_connected"))
	return (String) Debug.delegate(ba, "websocket_connected", new Object[] {_websocket1});
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="ws = WebSocket1";
__ref._ws = _websocket1;
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
__ref._abmpageid = __ref._abm.GetPageID(__ref._page,__ref._name,__ref._ws);
RDebugUtils.currentLine=6094852;
 //BA.debugLineNum = 6094852;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = __ref._abm.GetSession(__ref._ws,_abmshared._sessionmaxinactiveintervalseconds);
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
RDebugUtils.currentLine=6094855;
 //BA.debugLineNum = 6094855;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
RDebugUtils.currentLine=6094856;
 //BA.debugLineNum = 6094856;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(__ref._ws,__ref._abmpageid,"../");
RDebugUtils.currentLine=6094857;
 //BA.debugLineNum = 6094857;BA.debugLine="Return";
if (true) return "";
 };
 };
RDebugUtils.currentLine=6094861;
 //BA.debugLineNum = 6094861;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
__ref._abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,__ref._abmpageid,__ref._ws,ba);
RDebugUtils.currentLine=6094862;
 //BA.debugLineNum = 6094862;BA.debugLine="If page.ComesFromPageCache Then";
if (__ref._page.ComesFromPageCache) { 
RDebugUtils.currentLine=6094864;
 //BA.debugLineNum = 6094864;BA.debugLine="page.Refresh";
__ref._page.Refresh();
RDebugUtils.currentLine=6094866;
 //BA.debugLineNum = 6094866;BA.debugLine="page.FinishedLoading";
__ref._page.FinishedLoading();
 }else {
RDebugUtils.currentLine=6094869;
 //BA.debugLineNum = 6094869;BA.debugLine="page.Prepare";
__ref._page.Prepare();
RDebugUtils.currentLine=6094871;
 //BA.debugLineNum = 6094871;BA.debugLine="ConnectPage";
__ref._connectpage(null);
 };
RDebugUtils.currentLine=6094873;
 //BA.debugLineNum = 6094873;BA.debugLine="Log(ABMPageId)";
__c.Log(__ref._abmpageid);
RDebugUtils.currentLine=6094875;
 //BA.debugLineNum = 6094875;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected(b4j.example.pguserlist __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="pguserlist";
if (Debug.shouldDelegate(ba, "websocket_disconnected"))
	return (String) Debug.delegate(ba, "websocket_disconnected", null);
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Private Sub WebSocket_Disconnected";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="End Sub";
return "";
}
}