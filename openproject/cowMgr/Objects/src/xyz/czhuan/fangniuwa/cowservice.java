package xyz.czhuan.fangniuwa;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class cowservice extends android.app.Service {
	public static class cowservice_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, cowservice.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static cowservice mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return cowservice.class;
	}
	@Override
	public void onCreate() {
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "xyz.czhuan.fangniuwa", "xyz.czhuan.fangniuwa.cowservice");
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
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "xyz.czhuan.fangniuwa.cowservice", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("** Service (cowservice) Create **");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
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
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (cowservice) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
				}
			};
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (cowservice) Start **");
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
        BA.LogInfo("** Service (cowservice) Destroy **");
		processBA.raiseEvent(null, "service_destroy");
        processBA.service = null;
		mostCurrent = null;
		processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.NotificationWrapper _noti = null;
public static int _notiid = 0;
public static anywheresoftware.b4a.agraham.threading.Threading _thd = null;
public xyz.czhuan.fangniuwa.main _main = null;
public xyz.czhuan.fangniuwa.starter _starter = null;
public xyz.czhuan.fangniuwa.comm _comm = null;
public xyz.czhuan.fangniuwa.actmain _actmain = null;
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private noti As Notification";
_noti = new anywheresoftware.b4a.objects.NotificationWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Public notiid As Int=3956";
_notiid = (int) (3956);
 //BA.debugLineNum = 11;BA.debugLine="Private thd As Thread";
_thd = new anywheresoftware.b4a.agraham.threading.Threading();
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 41;BA.debugLine="thd.Initialise(\"thd\")";
_thd.Initialise(processBA,"thd");
 //BA.debugLineNum = 42;BA.debugLine="thd.Start(Me,\"startcow\",Null)";
_thd.Start(cowservice.getObject(),"startcow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public static String  _showmsg(String _msg) throws Exception{
 //BA.debugLineNum = 30;BA.debugLine="Sub showmsg(msg As String)";
 //BA.debugLineNum = 31;BA.debugLine="If msg<>Null And msg.Length>0 Then 	comm.TL(msg)";
if (_msg!= null && _msg.length()>0) { 
mostCurrent._comm._tl(processBA,_msg);};
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static String  _startcow() throws Exception{
String _ret = "";
 //BA.debugLineNum = 17;BA.debugLine="Sub startcow";
 //BA.debugLineNum = 18;BA.debugLine="noti.Initialize";
_noti.Initialize();
 //BA.debugLineNum = 19;BA.debugLine="noti.Icon=\"icon\"";
_noti.setIcon("icon");
 //BA.debugLineNum = 20;BA.debugLine="noti.OnGoingEvent=True";
_noti.setOnGoingEvent(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 21;BA.debugLine="noti.Vibrate=False";
_noti.setVibrate(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 22;BA.debugLine="noti.Sound=True";
_noti.setSound(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 23;BA.debugLine="noti.Light=False";
_noti.setLight(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 24;BA.debugLine="noti.SetInfo(Application.LabelName,\"牛儿正在吃草\",actma";
_noti.SetInfo(processBA,anywheresoftware.b4a.keywords.Common.Application.getLabelName(),"牛儿正在吃草",(Object)(mostCurrent._actmain.getObject()));
 //BA.debugLineNum = 25;BA.debugLine="Service.StartForeground(notiid,noti)";
mostCurrent._service.StartForeground(_notiid,(android.app.Notification)(_noti.getObject()));
 //BA.debugLineNum = 26;BA.debugLine="Dim ret As String =comm.shell(Starter.cowPath&\" -";
_ret = mostCurrent._comm._shell(processBA,mostCurrent._starter._cowpath+" -rc "+mostCurrent._starter._cfgpath+" -logFile "+mostCurrent._starter._cfgpath.replace("core.txt","logfile.log")+" &");
 //BA.debugLineNum = 28;BA.debugLine="CallSubDelayed2(Me,\"showmsg\",ret)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,cowservice.getObject(),"showmsg",(Object)(_ret));
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _stopcow() throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Sub stopcow";
 //BA.debugLineNum = 34;BA.debugLine="Service.StopForeground(notiid)";
mostCurrent._service.StopForeground(_notiid);
 //BA.debugLineNum = 35;BA.debugLine="comm.shell(\"killall cow\")";
mostCurrent._comm._shell(processBA,"killall cow");
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static String  _thd_ended(boolean _endedok,String _error) throws Exception{
 //BA.debugLineNum = 44;BA.debugLine="Sub thd_Ended(endedOK As Boolean, error As String)";
 //BA.debugLineNum = 45;BA.debugLine="If endedOK Then";
if (_endedok) { 
 //BA.debugLineNum = 46;BA.debugLine="Log(\"thd ended\")";
anywheresoftware.b4a.keywords.Common.Log("thd ended");
 }else {
 //BA.debugLineNum = 48;BA.debugLine="Log(\"thd error:\"&error)";
anywheresoftware.b4a.keywords.Common.Log("thd error:"+_error);
 };
 //BA.debugLineNum = 51;BA.debugLine="comm.TL(\"核心配置文件可能错误，请仔细检查后再尝试\")";
mostCurrent._comm._tl(processBA,"核心配置文件可能错误，请仔细检查后再尝试");
 //BA.debugLineNum = 52;BA.debugLine="stopcow";
_stopcow();
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
}
