package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class abmpagetemplate extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.ShellBA("b4j.example", "b4j.example.abmpagetemplate", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.abmpagetemplate.class).invoke(this, new Object[] {null});
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
public String  _initialize(b4j.example.abmpagetemplate __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "initialize"))
	return (String) Debug.delegate(ba, "initialize", new Object[] {_ba});
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="BuildPage";
__ref._buildpage(null);
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="End Sub";
return "";
}
public String  _buildpage(b4j.example.abmpagetemplate __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "buildpage"))
	return (String) Debug.delegate(ba, "buildpage", null);
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="public Sub BuildPage()";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="BuildTheme";
__ref._buildtheme(null);
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
__ref._page.InitializeWithTheme(__ref._name,"/ws/"+_abmshared._appname+"/"+__ref._name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,__ref._theme);
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="page.ShowLoader=True";
__ref._page.setShowLoader(__c.True);
RDebugUtils.currentLine=2162695;
 //BA.debugLineNum = 2162695;BA.debugLine="page.PageHTMLName = \"index0.html\"";
__ref._page.PageHTMLName = "index0.html";
RDebugUtils.currentLine=2162696;
 //BA.debugLineNum = 2162696;BA.debugLine="page.PageTitle = \"Index\"";
__ref._page.PageTitle = "Index";
RDebugUtils.currentLine=2162697;
 //BA.debugLineNum = 2162697;BA.debugLine="page.PageDescription = \"\"";
__ref._page.PageDescription = "";
RDebugUtils.currentLine=2162698;
 //BA.debugLineNum = 2162698;BA.debugLine="page.PageKeywords = \"\"";
__ref._page.PageKeywords = "";
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="page.PageSiteMapPriority = \"\"";
__ref._page.PageSiteMapPriority = "";
RDebugUtils.currentLine=2162700;
 //BA.debugLineNum = 2162700;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_YEAR";
__ref._page.PageSiteMapFrequency = __ref._abm.SITEMAP_FREQ_YEARLY;
RDebugUtils.currentLine=2162702;
 //BA.debugLineNum = 2162702;BA.debugLine="page.ShowConnectedIndicator = False";
__ref._page.ShowConnectedIndicator = __c.False;
RDebugUtils.currentLine=2162708;
 //BA.debugLineNum = 2162708;BA.debugLine="page.AddRows(2,True, \"\").AddCells12(1,\"\")";
__ref._page.AddRows((int) (2),__c.True,"").AddCells12((int) (1),"");
RDebugUtils.currentLine=2162709;
 //BA.debugLineNum = 2162709;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
__ref._page.BuildGrid();
RDebugUtils.currentLine=2162711;
 //BA.debugLineNum = 2162711;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme(b4j.example.abmpagetemplate __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "buildtheme"))
	return (String) Debug.delegate(ba, "buildtheme", null);
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="public Sub BuildTheme()";
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="theme.Initialize(\"pagetheme\")";
__ref._theme.Initialize("pagetheme");
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
__ref._theme.AddABMTheme(_abmshared._mytheme);
RDebugUtils.currentLine=2097159;
 //BA.debugLineNum = 2097159;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4j.example.abmpagetemplate __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Private ws As WebSocket 'ignore";
_ws = new anywheresoftware.b4j.object.WebSocket();
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="Public page As ABMPage";
_page = new com.ab.abmaterial.ABMPage();
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="Private theme As ABMTheme";
_theme = new com.ab.abmaterial.ABMTheme();
RDebugUtils.currentLine=1769479;
 //BA.debugLineNum = 1769479;BA.debugLine="Private ABM As ABMaterial 'ignore";
_abm = new com.ab.abmaterial.ABMaterial();
RDebugUtils.currentLine=1769481;
 //BA.debugLineNum = 1769481;BA.debugLine="Public Name As String = \"ABMPageTemplate\"  '<----";
_name = "ABMPageTemplate";
RDebugUtils.currentLine=1769483;
 //BA.debugLineNum = 1769483;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
RDebugUtils.currentLine=1769486;
 //BA.debugLineNum = 1769486;BA.debugLine="End Sub";
return "";
}
public String  _connectpage(b4j.example.abmpagetemplate __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "connectpage"))
	return (String) Debug.delegate(ba, "connectpage", null);
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="public Sub ConnectPage()";
RDebugUtils.currentLine=2228237;
 //BA.debugLineNum = 2228237;BA.debugLine="page.Refresh";
__ref._page.Refresh();
RDebugUtils.currentLine=2228239;
 //BA.debugLineNum = 2228239;BA.debugLine="page.FinishedLoading";
__ref._page.FinishedLoading();
RDebugUtils.currentLine=2228241;
 //BA.debugLineNum = 2228241;BA.debugLine="page.RestoreNavigationBarPosition";
__ref._page.RestoreNavigationBarPosition();
RDebugUtils.currentLine=2228242;
 //BA.debugLineNum = 2228242;BA.debugLine="End Sub";
return "";
}
public String  _page_authenticated(b4j.example.abmpagetemplate __ref,anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "page_authenticated"))
	return (String) Debug.delegate(ba, "page_authenticated", new Object[] {_params});
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub Page_Authenticated(Params As Map)";
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="End Sub";
return "";
}
public String  _page_fileuploaded(b4j.example.abmpagetemplate __ref,String _filename,boolean _success) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "page_fileuploaded"))
	return (String) Debug.delegate(ba, "page_fileuploaded", new Object[] {_filename,_success});
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub Page_FileUploaded(FileName As String, success";
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public String  _page_firebaseautherror(b4j.example.abmpagetemplate __ref,String _extra) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "page_firebaseautherror"))
	return (String) Debug.delegate(ba, "page_firebaseautherror", new Object[] {_extra});
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub Page_FirebaseAuthError(extra As String)";
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="End Sub";
return "";
}
public String  _page_firebaseauthstatechanged(b4j.example.abmpagetemplate __ref,boolean _isloggedin) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "page_firebaseauthstatechanged"))
	return (String) Debug.delegate(ba, "page_firebaseauthstatechanged", new Object[] {_isloggedin});
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub Page_FirebaseAuthStateChanged(IsLoggedIn As Bo";
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="End Sub";
return "";
}
public String  _page_firebasestorageerror(b4j.example.abmpagetemplate __ref,String _jobid,String _extra) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "page_firebasestorageerror"))
	return (String) Debug.delegate(ba, "page_firebasestorageerror", new Object[] {_jobid,_extra});
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub Page_FirebaseStorageError(jobID As String, ext";
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="End Sub";
return "";
}
public String  _page_firebasestorageresult(b4j.example.abmpagetemplate __ref,String _jobid,String _extra) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "page_firebasestorageresult"))
	return (String) Debug.delegate(ba, "page_firebasestorageresult", new Object[] {_jobid,_extra});
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub Page_FirebaseStorageResult(jobID As String, ex";
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="End Sub";
return "";
}
public String  _page_modalsheetdismissed(b4j.example.abmpagetemplate __ref,String _modalsheetname) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "page_modalsheetdismissed"))
	return (String) Debug.delegate(ba, "page_modalsheetdismissed", new Object[] {_modalsheetname});
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub Page_ModalSheetDismissed(ModalSheetName As Str";
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(b4j.example.abmpagetemplate __ref,String _action,String _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "page_navigationbarclicked"))
	return (String) Debug.delegate(ba, "page_navigationbarclicked", new Object[] {_action,_value});
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="page.SaveNavigationBarPosition";
__ref._page.SaveNavigationBarPosition();
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(__ref._page);
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2293767;
 //BA.debugLineNum = 2293767;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(__ref._ws,__ref._abmpageid,_value);
RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="End Sub";
return "";
}
public String  _page_nextcontent(b4j.example.abmpagetemplate __ref,String _triggercomponent) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "page_nextcontent"))
	return (String) Debug.delegate(ba, "page_nextcontent", new Object[] {_triggercomponent});
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub Page_NextContent(TriggerComponent As String)";
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(b4j.example.abmpagetemplate __ref,anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "page_parseevent"))
	return (String) Debug.delegate(ba, "page_parseevent", new Object[] {_params});
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
__ref._abm.RemoveMeFromCache(_abmshared._cachedpages,__ref._abmpageid);
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
RDebugUtils.currentLine=2031627;
 //BA.debugLineNum = 2031627;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
RDebugUtils.currentLine=2031629;
 //BA.debugLineNum = 2031629;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
RDebugUtils.currentLine=2031631;
 //BA.debugLineNum = 2031631;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
RDebugUtils.currentLine=2031633;
 //BA.debugLineNum = 2031633;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
RDebugUtils.currentLine=2031634;
 //BA.debugLineNum = 2031634;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = __ref._abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
RDebugUtils.currentLine=2031635;
 //BA.debugLineNum = 2031635;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
RDebugUtils.currentLine=2031637;
 //BA.debugLineNum = 2031637;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
RDebugUtils.currentLine=2031641;
 //BA.debugLineNum = 2031641;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
RDebugUtils.currentLine=2031644;
 //BA.debugLineNum = 2031644;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(b4j.example.abmpagetemplate __ref,String _network,String _extra) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "page_signedoffsocialnetwork"))
	return (String) Debug.delegate(ba, "page_signedoffsocialnetwork", new Object[] {_network,_extra});
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="End Sub";
return "";
}
public String  _page_toastclicked(b4j.example.abmpagetemplate __ref,String _toastid,String _action) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "page_toastclicked"))
	return (String) Debug.delegate(ba, "page_toastclicked", new Object[] {_toastid,_action});
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub Page_ToastClicked(ToastId As String, Action As";
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="End Sub";
return "";
}
public String  _page_toastdismissed(b4j.example.abmpagetemplate __ref,String _toastid) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "page_toastdismissed"))
	return (String) Debug.delegate(ba, "page_toastdismissed", new Object[] {_toastid});
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub Page_ToastDismissed(ToastId As String)";
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(b4j.example.abmpagetemplate __ref,anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "websocket_connected"))
	return (String) Debug.delegate(ba, "websocket_connected", new Object[] {_websocket1});
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="ws = WebSocket1";
__ref._ws = _websocket1;
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
__ref._abmpageid = __ref._abm.GetPageID(__ref._page,__ref._name,__ref._ws);
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = __ref._abm.GetSession(__ref._ws,_abmshared._sessionmaxinactiveintervalseconds);
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
RDebugUtils.currentLine=1900551;
 //BA.debugLineNum = 1900551;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(__ref._ws,__ref._abmpageid,"../");
RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="Return";
if (true) return "";
 };
 };
RDebugUtils.currentLine=1900557;
 //BA.debugLineNum = 1900557;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
__ref._abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,__ref._abmpageid,__ref._ws,ba);
RDebugUtils.currentLine=1900558;
 //BA.debugLineNum = 1900558;BA.debugLine="If page.ComesFromPageCache Then";
if (__ref._page.ComesFromPageCache) { 
RDebugUtils.currentLine=1900560;
 //BA.debugLineNum = 1900560;BA.debugLine="page.Refresh";
__ref._page.Refresh();
RDebugUtils.currentLine=1900562;
 //BA.debugLineNum = 1900562;BA.debugLine="page.FinishedLoading";
__ref._page.FinishedLoading();
 }else {
RDebugUtils.currentLine=1900565;
 //BA.debugLineNum = 1900565;BA.debugLine="page.Prepare";
__ref._page.Prepare();
RDebugUtils.currentLine=1900567;
 //BA.debugLineNum = 1900567;BA.debugLine="ConnectPage";
__ref._connectpage(null);
 };
RDebugUtils.currentLine=1900569;
 //BA.debugLineNum = 1900569;BA.debugLine="Log(ABMPageId)";
__c.Log(__ref._abmpageid);
RDebugUtils.currentLine=1900571;
 //BA.debugLineNum = 1900571;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected(b4j.example.abmpagetemplate __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmpagetemplate";
if (Debug.shouldDelegate(ba, "websocket_disconnected"))
	return (String) Debug.delegate(ba, "websocket_disconnected", null);
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Private Sub WebSocket_Disconnected";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="End Sub";
return "";
}
}