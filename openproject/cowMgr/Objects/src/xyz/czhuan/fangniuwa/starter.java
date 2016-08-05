package xyz.czhuan.fangniuwa;


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
		    processBA = new BA(this, null, null, "xyz.czhuan.fangniuwa", "xyz.czhuan.fangniuwa.starter");
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
			processBA.raiseEvent2(null, true, "CREATE", true, "xyz.czhuan.fangniuwa.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
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
                    processBA.setActivityPaused(false);
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
public static String _cpu = "";
public static String _cowpath = "";
public static String _cfgpath = "";
public static boolean _bcowexist = false;
public static boolean _bcfgexist = false;
public static String _cowversion = "";
public xyz.czhuan.fangniuwa.main _main = null;
public xyz.czhuan.fangniuwa.comm _comm = null;
public xyz.czhuan.fangniuwa.actmain _actmain = null;
public xyz.czhuan.fangniuwa.cowservice _cowservice = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 33;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return false;
}
public static String  _checkcfgfilesexist() throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Private Sub checkcfgfilesexist";
 //BA.debugLineNum = 56;BA.debugLine="Log(\"cowPath:\"&cowPath)";
anywheresoftware.b4a.keywords.Common.Log("cowPath:"+_cowpath);
 //BA.debugLineNum = 57;BA.debugLine="bCowExist=File.Exists(\"\",cowPath)";
_bcowexist = anywheresoftware.b4a.keywords.Common.File.Exists("",_cowpath);
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _checkfilesexist() throws Exception{
 //BA.debugLineNum = 51;BA.debugLine="Private Sub checkfilesexist";
 //BA.debugLineNum = 52;BA.debugLine="Log(\"cowPath:\"&cowPath)";
anywheresoftware.b4a.keywords.Common.Log("cowPath:"+_cowpath);
 //BA.debugLineNum = 53;BA.debugLine="bCowExist=File.Exists(\"\",cowPath)";
_bcowexist = anywheresoftware.b4a.keywords.Common.File.Exists("",_cowpath);
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public static String  _getcpuversion() throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
String _str = "";
 //BA.debugLineNum = 35;BA.debugLine="Private Sub getcpuversion";
 //BA.debugLineNum = 36;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 37;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 38;BA.debugLine="sb.Append(comm.Shell(\"cat /proc/cpuinfo\"))";
_sb.Append(mostCurrent._comm._shell(processBA,"cat /proc/cpuinfo"));
 //BA.debugLineNum = 40;BA.debugLine="Dim str As String=sb.ToString.ToLowerCase";
_str = _sb.ToString().toLowerCase();
 //BA.debugLineNum = 41;BA.debugLine="If sb.ToString.IndexOf(\"armv6\")>-1 Then";
if (_sb.ToString().indexOf("armv6")>-1) { 
 //BA.debugLineNum = 42;BA.debugLine="cpu=\"armv6\"";
_cpu = "armv6";
 }else if(_str.indexOf("armv7")>-1) { 
 //BA.debugLineNum = 44;BA.debugLine="cpu=\"armv7\"";
_cpu = "armv7";
 }else {
 //BA.debugLineNum = 46;BA.debugLine="cpu=\"unknow\"";
_cpu = "unknow";
 };
 //BA.debugLineNum = 48;BA.debugLine="Log(\"cpu=\"&cpu)";
anywheresoftware.b4a.keywords.Common.Log("cpu="+_cpu);
 //BA.debugLineNum = 49;BA.debugLine="Log(File.DirInternal)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.File.getDirInternal());
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public static String  _initenv() throws Exception{
String _ret = "";
 //BA.debugLineNum = 59;BA.debugLine="Sub initenv";
 //BA.debugLineNum = 60;BA.debugLine="If cpu.EqualsIgnoreCase(\"unknow\") Then";
if (_cpu.equalsIgnoreCase("unknow")) { 
 //BA.debugLineNum = 61;BA.debugLine="comm.TL(\"Sorry CPU:\"&cpu&\" not support\")";
mostCurrent._comm._tl(processBA,"Sorry CPU:"+_cpu+" not support");
 //BA.debugLineNum = 62;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 64;BA.debugLine="File.Copy(File.DirAssets,cpu,\"\",cowPath)";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_cpu,"",_cowpath);
 //BA.debugLineNum = 65;BA.debugLine="File.Copy(File.DirAssets,\"core.txt\",\"\",cfgPath)";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"core.txt","",_cfgpath);
 //BA.debugLineNum = 66;BA.debugLine="Dim ret As String=comm.shell(\"chmod 0777 \"&cowPat";
_ret = mostCurrent._comm._shell(processBA,"chmod 0777 "+_cowpath);
 //BA.debugLineNum = 67;BA.debugLine="Log(ret)";
anywheresoftware.b4a.keywords.Common.Log(_ret);
 //BA.debugLineNum = 68;BA.debugLine="checkfilesexist";
_checkfilesexist();
 //BA.debugLineNum = 69;BA.debugLine="CallSubDelayed(actmain,\"initok\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._actmain.getObject()),"initok");
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Public cpu As String=\"\",cowPath,cfgPath As String";
_cpu = "";
_cowpath = "";
_cfgpath = "";
 //BA.debugLineNum = 11;BA.debugLine="Public bCowExist As Boolean=False,bCfgExist As Bo";
_bcowexist = anywheresoftware.b4a.keywords.Common.False;
_bcfgexist = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 12;BA.debugLine="Public cowVersion As String=\"0.98\"";
_cowversion = "0.98";
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 20;BA.debugLine="cowPath=File.DirInternal&\"/cow\"";
_cowpath = anywheresoftware.b4a.keywords.Common.File.getDirInternal()+"/cow";
 //BA.debugLineNum = 21;BA.debugLine="cowPath=cowPath.Replace(\"/files\",\"\")";
_cowpath = _cowpath.replace("/files","");
 //BA.debugLineNum = 22;BA.debugLine="cfgPath=cowPath.Replace(\"/cow\",\"/core.txt\")";
_cfgpath = _cowpath.replace("/cow","/core.txt");
 //BA.debugLineNum = 23;BA.debugLine="checkfilesexist";
_checkfilesexist();
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 74;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 28;BA.debugLine="getcpuversion";
_getcpuversion();
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
}
