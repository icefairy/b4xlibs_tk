package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _appstart(RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("AppStart (main) ","main",0,main.ba,main.mostCurrent,11);
if (RapidSub.canDelegate("appstart")) return main.remoteMe.runUserSub(false, "main","appstart", _args);
RemoteObject _myapp = RemoteObject.declareNull("b4j.example.abmapplication");
RemoteObject _mypage = RemoteObject.declareNull("b4j.example.abmpagetemplate");
Debug.locals.put("Args", _args);
 BA.debugLineNum = 11;BA.debugLine="Sub AppStart (Args() As String)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 16;BA.debugLine="ABMShared.BuildTheme(\"mytheme\")";
Debug.ShouldStop(32768);
main._abmshared.runVoidMethod ("_buildtheme",(Object)(RemoteObject.createImmutable("mytheme")));
 BA.debugLineNum = 19;BA.debugLine="Dim myApp As ABMApplication";
Debug.ShouldStop(262144);
_myapp = RemoteObject.createNew ("b4j.example.abmapplication");Debug.locals.put("myApp", _myapp);
 BA.debugLineNum = 20;BA.debugLine="myApp.Initialize";
Debug.ShouldStop(524288);
_myapp.runClassMethod (b4j.example.abmapplication.class, "_initialize",main.ba);
 BA.debugLineNum = 21;BA.debugLine="DBM.InitializeMySQL(\"jdbc:mysql://127.0.0.1:3306/";
Debug.ShouldStop(1048576);
main._dbm.runVoidMethod ("_initializemysql",(Object)(BA.ObjectToString("jdbc:mysql://127.0.0.1:3306/zfbdb?characterEncoding=utf8")),(Object)(BA.ObjectToString("root")),(Object)(BA.ObjectToString("root")),(Object)(BA.numberCast(int.class, 100)));
 BA.debugLineNum = 24;BA.debugLine="Dim myPage As ABMPageTemplate";
Debug.ShouldStop(8388608);
_mypage = RemoteObject.createNew ("b4j.example.abmpagetemplate");Debug.locals.put("myPage", _mypage);
 BA.debugLineNum = 25;BA.debugLine="myPage.Initialize";
Debug.ShouldStop(16777216);
_mypage.runClassMethod (b4j.example.abmpagetemplate.class, "_initialize",main.ba);
 BA.debugLineNum = 28;BA.debugLine="myApp.AddPage(myPage.Page)";
Debug.ShouldStop(134217728);
_myapp.runClassMethod (b4j.example.abmapplication.class, "_addpage",(Object)(_mypage.getField(false,"_page")));
 BA.debugLineNum = 31;BA.debugLine="myApp.StartServer(srvr, \"srvr\", 51042)";
Debug.ShouldStop(1073741824);
_myapp.runClassMethod (b4j.example.abmapplication.class, "_startserver",(Object)(main._srvr),(Object)(BA.ObjectToString("srvr")),(Object)(BA.numberCast(int.class, 51042)));
 BA.debugLineNum = 33;BA.debugLine="ABMShared.RedirectOutput(File.DirApp, \"logs.txt\")";
Debug.ShouldStop(1);
main._abmshared.runVoidMethod ("_redirectoutput",(Object)(main.__c.getField(false,"File").runMethod(true,"getDirApp")),(Object)(RemoteObject.createImmutable("logs.txt")));
 BA.debugLineNum = 35;BA.debugLine="StartMessageLoop";
Debug.ShouldStop(4);
main.__c.runVoidMethod ("StartMessageLoop",main.ba);
 BA.debugLineNum = 36;BA.debugLine="End Sub";
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

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
abmshared_subs_0._process_globals();
dbm_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4j.example.main");
abmapplication.myClass = BA.getDeviceClass ("b4j.example.abmapplication");
abmshared.myClass = BA.getDeviceClass ("b4j.example.abmshared");
abmpagetemplate.myClass = BA.getDeviceClass ("b4j.example.abmpagetemplate");
abmpagetemplatealternative.myClass = BA.getDeviceClass ("b4j.example.abmpagetemplatealternative");
abmuploadhandler.myClass = BA.getDeviceClass ("b4j.example.abmuploadhandler");
abmsessioncreator.myClass = BA.getDeviceClass ("b4j.example.abmsessioncreator");
abmcachescavenger.myClass = BA.getDeviceClass ("b4j.example.abmcachescavenger");
dbm.myClass = BA.getDeviceClass ("b4j.example.dbm");
pguserlist.myClass = BA.getDeviceClass ("b4j.example.pguserlist");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Public srvr As Server";
main._srvr = RemoteObject.createNew ("anywheresoftware.b4j.object.ServerWrapper");
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}