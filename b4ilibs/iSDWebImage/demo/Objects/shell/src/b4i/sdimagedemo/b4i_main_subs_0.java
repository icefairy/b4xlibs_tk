package b4i.sdimagedemo;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4i_main_subs_0 {


public static RemoteObject  _application_background() throws Exception{
try {
		Debug.PushSubsStack("Application_Background (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,57);
if (RapidSub.canDelegate("application_background")) return b4i_main.remoteMe.runUserSub(false, "main","application_background");
 BA.debugLineNum = 57;BA.debugLine="Private Sub Application_Background";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 59;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Application_Start (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,30);
if (RapidSub.canDelegate("application_start")) return b4i_main.remoteMe.runUserSub(false, "main","application_start", _nav);
RemoteObject _url = null;
RemoteObject _ivs = null;
int _i = 0;
Debug.locals.put("Nav", _nav);
 BA.debugLineNum = 30;BA.debugLine="Private Sub Application_Start (Nav As NavigationCo";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="NavControl = Nav";
Debug.ShouldStop(1073741824);
b4i_main._navcontrol = _nav;
 BA.debugLineNum = 32;BA.debugLine="Page1.Initialize(\"Page1\")";
Debug.ShouldStop(-2147483648);
b4i_main._page1.runVoidMethod ("Initialize::",b4i_main.ba,(Object)(RemoteObject.createImmutable("Page1")));
 BA.debugLineNum = 33;BA.debugLine="Page1.Title = \"Page 1\"";
Debug.ShouldStop(1);
b4i_main._page1.runMethod(true,"setTitle:",BA.ObjectToString("Page 1"));
 BA.debugLineNum = 34;BA.debugLine="Page1.RootPanel.LoadLayout(\"laytest\")";
Debug.ShouldStop(2);
b4i_main._page1.runMethod(false,"RootPanel").runMethodAndSync(false,"LoadLayout::",(Object)(RemoteObject.createImmutable("laytest")),b4i_main.ba);
 BA.debugLineNum = 35;BA.debugLine="NavControl.ShowPage(Page1)";
Debug.ShouldStop(4);
b4i_main._navcontrol.runVoidMethod ("ShowPage:",(Object)(((b4i_main._page1).getObject())));
 BA.debugLineNum = 37;BA.debugLine="Dim url() As String=Array As String(\"https://app.";
Debug.ShouldStop(16);
_url = RemoteObject.createNew("B4IArray").runMethod(false, "initObjectsWithData:", (Object)new RemoteObject[] {BA.ObjectToString("https://app.kaopuedu.com/Uploads/touxiang/2016-10-02/57f0cdbdee7f4.jpg"),BA.ObjectToString("https://app.kaopuedu.com/Uploads/touxiang/2016-10-17/5804b1b4114e5.jpg"),BA.ObjectToString("https://app.kaopuedu.com/Uploads/touxiang/2016-10-12/57fdbe355efbf.jpg"),RemoteObject.createImmutable("https://app.kaopuedu.com/Uploads/houduan/2016-10-15/58020cc774c3b.jpg")});Debug.locals.put("url", _url);Debug.locals.put("url", _url);
 BA.debugLineNum = 38;BA.debugLine="Dim ivs() As ImageView=Array As ImageView(ImageVi";
Debug.ShouldStop(32);
_ivs = RemoteObject.createNew("B4IArray").runMethod(false, "initObjectsWithData:", (Object)new RemoteObject[] {b4i_main._imageview1,b4i_main._imageview2,b4i_main._imageview3,b4i_main._imageview4,b4i_main._imageview5,b4i_main._imageview6});Debug.locals.put("ivs", _ivs);Debug.locals.put("ivs", _ivs);
 BA.debugLineNum = 40;BA.debugLine="bmpholder=LoadBitmap(File.DirAssets,\"test_tecbg.p";
Debug.ShouldStop(128);
b4i_main._bmpholder = b4i_main.__c.runMethod(false,"LoadBitmap::",(Object)(b4i_main.__c.runMethod(false,"File").runMethod(true,"DirAssets")),(Object)(RemoteObject.createImmutable("test_tecbg.png")));
 BA.debugLineNum = 41;BA.debugLine="For i=0 To url.Length-1";
Debug.ShouldStop(256);
{
final int step9 = 1;
final int limit9 = RemoteObject.solve(new RemoteObject[] {_url.getField(true,"Length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Number>get().intValue();
for (_i = 0 ; (step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9); _i = ((int)(0 + _i + step9)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 43;BA.debugLine="sdimgldr.setImageWithURL(\"img\",ivs(i),url(i),bmp";
Debug.ShouldStop(1024);
b4i_main._sdimgldr.runVoidMethod ("setImageWithURL:::::",b4i_main.ba,(Object)(BA.ObjectToString("img")),(Object)(((_ivs.runMethod(false,"getObjectFast:", BA.numberCast(int.class, _i))).getObject())),(Object)(_url.runMethod(true,"getObjectFast:", BA.numberCast(int.class, _i))),(Object)(((b4i_main._bmpholder).getObject())));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _img_sdcomplete(RemoteObject _m) throws Exception{
try {
		Debug.PushSubsStack("img_sdComplete (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,46);
if (RapidSub.canDelegate("img_sdcomplete")) return b4i_main.remoteMe.runUserSub(false, "main","img_sdcomplete", _m);
Debug.locals.put("m", _m);
 BA.debugLineNum = 46;BA.debugLine="Sub img_sdComplete(m As Map)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="Log(\"img_sdComplete\")";
Debug.ShouldStop(16384);
b4i_main.__c.runVoidMethod ("Log:",(Object)(RemoteObject.createImmutable("img_sdComplete")));
 BA.debugLineNum = 48;BA.debugLine="Log(m)";
Debug.ShouldStop(32768);
b4i_main.__c.runVoidMethod ("Log:",(Object)(BA.ObjectToString(_m)));
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
public static RemoteObject  _img_sdprogress(RemoteObject _nrec,RemoteObject _ntot,RemoteObject _sdurl) throws Exception{
try {
		Debug.PushSubsStack("img_sdProgress (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,50);
if (RapidSub.canDelegate("img_sdprogress")) return b4i_main.remoteMe.runUserSub(false, "main","img_sdprogress", _nrec, _ntot, _sdurl);
Debug.locals.put("nRec", _nrec);
Debug.locals.put("nTot", _ntot);
Debug.locals.put("sdUrl", _sdurl);
 BA.debugLineNum = 50;BA.debugLine="Sub img_sdProgress(nRec As Int,nTot As Int,sdUrl A";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="Log(nRec&\"/\"&nTot&\" \"&sdUrl)";
Debug.ShouldStop(262144);
b4i_main.__c.runVoidMethod ("Log:",(Object)(RemoteObject.concat(_nrec,RemoteObject.createImmutable("/"),_ntot,RemoteObject.createImmutable(" "),_sdurl)));
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
		Debug.PushSubsStack("Page1_Resize (main) ","main",0,b4i_main.ba,b4i_main.mostCurrent,53);
if (RapidSub.canDelegate("page1_resize")) return b4i_main.remoteMe.runUserSub(false, "main","page1_resize", _width, _height);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 53;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As I";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Public App As Application";
b4i_main._app = RemoteObject.createNew("B4IApplicationWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Public NavControl As NavigationController";
b4i_main._navcontrol = RemoteObject.createNew("B4INavigationControllerWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private Page1 As Page";
b4i_main._page1 = RemoteObject.createNew("B4IPage");
 //BA.debugLineNum = 20;BA.debugLine="Private ImageView1 As ImageView";
b4i_main._imageview1 = RemoteObject.createNew("B4IImageViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private ImageView2 As ImageView";
b4i_main._imageview2 = RemoteObject.createNew("B4IImageViewWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private ImageView3 As ImageView";
b4i_main._imageview3 = RemoteObject.createNew("B4IImageViewWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private ImageView4 As ImageView";
b4i_main._imageview4 = RemoteObject.createNew("B4IImageViewWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private ImageView6 As ImageView";
b4i_main._imageview6 = RemoteObject.createNew("B4IImageViewWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private ImageView5 As ImageView";
b4i_main._imageview5 = RemoteObject.createNew("B4IImageViewWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private sdimgldr As iSDWebImage";
b4i_main._sdimgldr = RemoteObject.createNew("iSDWebImage");
 //BA.debugLineNum = 27;BA.debugLine="Dim bmpholder As Bitmap";
b4i_main._bmpholder = RemoteObject.createNew("B4IBitmap");
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}