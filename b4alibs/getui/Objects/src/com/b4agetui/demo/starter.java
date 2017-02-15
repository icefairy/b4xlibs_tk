package com.b4agetui.demo;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends android.app.Service {
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "com.b4agetui.demo", "com.b4agetui.demo.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        processBA.setActivityPaused(false);
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "com.b4agetui.demo.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            BA.LogInfo("** Service (starter) Create **");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			if (ServiceHelper.StarterHelper.waitForLayout != null)
				BA.handler.post(ServiceHelper.StarterHelper.waitForLayout);
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA))
			handleStart(intent);
		else {
			ServiceHelper.StarterHelper.waitForLayout = new Runnable() {
				public void run() {
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
				}
			};
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = new anywheresoftware.b4a.objects.IntentWrapper();
    			if (intent != null) {
    				if (intent.hasExtra("b4a_internal_intent"))
    					iw.setObject((android.content.Intent) intent.getParcelableExtra("b4a_internal_intent"));
    				else
    					iw.setObject(intent);
    			}
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
	@Override
	public void onDestroy() {
        BA.LogInfo("** Service (starter) Destroy **");
		processBA.raiseEvent(null, "service_destroy");
        processBA.service = null;
		mostCurrent = null;
		processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static com.zaiten.getui.getuiwrapper _getui = null;
public com.b4agetui.demo.main _main = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 24;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return false;
}
public static String  _gt_onclickid(String _cid) throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Sub gt_onClickid(cid As String)";
 //BA.debugLineNum = 33;BA.debugLine="Log(\"cid:\"&cid)";
anywheresoftware.b4a.keywords.Common.Log("cid:"+_cid);
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _gt_onrec(String _str) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
String _messageid = "";
String _taskid = "";
String _action = "";
 //BA.debugLineNum = 36;BA.debugLine="Sub gt_onRec(str As String)";
 //BA.debugLineNum = 38;BA.debugLine="Log(\"gotStr:\"&str)";
anywheresoftware.b4a.keywords.Common.Log("gotStr:"+_str);
 //BA.debugLineNum = 39;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 40;BA.debugLine="parser.Initialize(str)";
_parser.Initialize(_str);
 //BA.debugLineNum = 41;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 42;BA.debugLine="Dim messageid As String = root.Get(\"messageid\")";
_messageid = BA.ObjectToString(_root.Get((Object)("messageid")));
 //BA.debugLineNum = 43;BA.debugLine="Dim taskid As String = root.Get(\"taskid\")";
_taskid = BA.ObjectToString(_root.Get((Object)("taskid")));
 //BA.debugLineNum = 44;BA.debugLine="Try";
try { //BA.debugLineNum = 46;BA.debugLine="Dim action As String = root.Get(\"actionid\")";
_action = BA.ObjectToString(_root.Get((Object)("actionid")));
 //BA.debugLineNum = 47;BA.debugLine="If action <> \"\" Then";
if ((_action).equals("") == false) { 
 //BA.debugLineNum = 48;BA.debugLine="CallSubDelayed(Main,\"cttest\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._main.getObject()),"cttest");
 };
 } 
       catch (Exception e13) {
			processBA.setLastException(e13); //BA.debugLineNum = 51;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)));
 };
 //BA.debugLineNum = 54;BA.debugLine="getui.sendFeedbackMessage(taskid,messageid,90001)";
_getui.sendFeedbackMessage(_taskid,_messageid,(int) (90001));
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Public getui As b4agetui";
_getui = new com.zaiten.getui.getuiwrapper();
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 19;BA.debugLine="getui.Init(\"gt\")";
_getui.Init(processBA,"gt");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
}
