package com.icefairy;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4i_main_subs_0 {


public static RemoteObject  _application_background() throws Exception{
try {
		Debug.PushSubsStack("Application_Background (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,35);
if (RapidSub.canDelegate("application_background")) return b4i_main.remoteMe.runUserSub(false, "main","application_background");
 BA.debugLineNum = 35;BA.debugLine="Private Sub Application_Background";
Debug.ShouldStop(4);
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _application_start(RemoteObject _nav) throws Exception{
try {
		Debug.PushSubsStack("Application_Start (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,21);
if (RapidSub.canDelegate("application_start")) return b4i_main.remoteMe.runUserSub(false, "main","application_start", _nav);
Debug.locals.put("Nav", _nav);
 BA.debugLineNum = 21;BA.debugLine="Private Sub Application_Start (Nav As NavigationCo";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 22;BA.debugLine="NavControl = Nav";
Debug.ShouldStop(2097152);
b4i_main._navcontrol = _nav;
 BA.debugLineNum = 23;BA.debugLine="Page1.Initialize(\"firstlib\")";
Debug.ShouldStop(4194304);
b4i_main._page1.runVoidMethod ("Initialize::",b4i_main.ba,(Object)(RemoteObject.createImmutable("firstlib")));
 BA.debugLineNum = 24;BA.debugLine="Page1.Title = \"第一个库\"";
Debug.ShouldStop(8388608);
b4i_main._page1.runMethod(true,"setTitle:",BA.ObjectToString("第一个库"));
 BA.debugLineNum = 25;BA.debugLine="Page1.RootPanel.LoadLayout(\"layfirst\")";
Debug.ShouldStop(16777216);
b4i_main._page1.runMethod(false,"RootPanel").runMethodAndSync(false,"LoadLayout::",(Object)(RemoteObject.createImmutable("layfirst")),b4i_main.ba);
 BA.debugLineNum = 26;BA.debugLine="NavControl.ShowPage(Page1)";
Debug.ShouldStop(33554432);
b4i_main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_main._page1).getObject())));
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncalllib_click() throws Exception{
try {
		Debug.PushSubsStack("btncalllib_Click (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,40);
if (RapidSub.canDelegate("btncalllib_click")) return b4i_main.remoteMe.runUserSub(false, "main","btncalllib_click");
 BA.debugLineNum = 40;BA.debugLine="Sub btncalllib_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="Log(\"btncalllib_Click\")";
Debug.ShouldStop(256);
b4i_main.__c.runVoidMethod ("Log:",(Object)(RemoteObject.createImmutable("btncalllib_Click")));
 BA.debugLineNum = 42;BA.debugLine="fb.Initialize(\"fb\",\"testparam\")";
Debug.ShouldStop(512);
b4i_main._fb.runVoidMethod ("Initialize:::",b4i_main.ba,(Object)(BA.ObjectToString("fb")),(Object)(RemoteObject.createImmutable("testparam")));
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fb_gotmsg(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("fb_gotmsg (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,50);
if (RapidSub.canDelegate("fb_gotmsg")) return b4i_main.remoteMe.runUserSub(false, "main","fb_gotmsg", _msg);
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 50;BA.debugLine="Sub fb_gotmsg(msg As String)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="Log(\"fb_gotmsg:\"&msg)";
Debug.ShouldStop(262144);
b4i_main.__c.runVoidMethod ("Log:",(Object)(RemoteObject.concat(RemoteObject.createImmutable("fb_gotmsg:"),_msg)));
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fb_gotmsg2(RemoteObject _msg,RemoteObject _code) throws Exception{
try {
		Debug.PushSubsStack("fb_gotmsg2 (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,47);
if (RapidSub.canDelegate("fb_gotmsg2")) return b4i_main.remoteMe.runUserSub(false, "main","fb_gotmsg2", _msg, _code);
Debug.locals.put("msg", _msg);
Debug.locals.put("code", _code);
 BA.debugLineNum = 47;BA.debugLine="Sub fb_gotmsg2(msg As String,code As Int)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Log(\"fb_gotmsg2:\"&msg&\" code:\"&code)";
Debug.ShouldStop(32768);
b4i_main.__c.runVoidMethod ("Log:",(Object)(RemoteObject.concat(RemoteObject.createImmutable("fb_gotmsg2:"),_msg,RemoteObject.createImmutable(" code:"),_code)));
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fb_noparam() throws Exception{
try {
		Debug.PushSubsStack("fb_noparam (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,44);
if (RapidSub.canDelegate("fb_noparam")) return b4i_main.remoteMe.runUserSub(false, "main","fb_noparam");
 BA.debugLineNum = 44;BA.debugLine="Sub fb_noparam";
Debug.ShouldStop(2048);
 BA.debugLineNum = 45;BA.debugLine="Log(\"fb_noparam\")";
Debug.ShouldStop(4096);
b4i_main.__c.runVoidMethod ("Log:",(Object)(RemoteObject.createImmutable("fb_noparam")));
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _firstlib_barbuttonclick(RemoteObject _tag) throws Exception{
try {
		Debug.PushSubsStack("firstlib_BarButtonClick (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,28);
if (RapidSub.canDelegate("firstlib_barbuttonclick")) return b4i_main.remoteMe.runUserSub(false, "main","firstlib_barbuttonclick", _tag);
Debug.locals.put("Tag", _tag);
 BA.debugLineNum = 28;BA.debugLine="Sub firstlib_BarButtonClick (Tag As String)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 29;BA.debugLine="Log(\"tag:\"&Tag)";
Debug.ShouldStop(268435456);
b4i_main.__c.runVoidMethod ("Log:",(Object)(RemoteObject.concat(RemoteObject.createImmutable("tag:"),_tag)));
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _page1_resize(RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("Page1_Resize (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,31);
if (RapidSub.canDelegate("page1_resize")) return b4i_main.remoteMe.runUserSub(false, "main","page1_resize", _width, _height);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 31;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As I";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 15;BA.debugLine="Public App As Application";
b4i_main._app = RemoteObject.createNew("B4IApplicationWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Public NavControl As NavigationController";
b4i_main._navcontrol = RemoteObject.createNew("B4INavigationControllerWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private Page1 As Page";
b4i_main._page1 = RemoteObject.createNew("B4IPage");
 //BA.debugLineNum = 18;BA.debugLine="Dim fb As firstlib";
b4i_main._fb = RemoteObject.createNew("firstlib");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}