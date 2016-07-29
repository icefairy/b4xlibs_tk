package anywheresoftware.b4a.samples.httputils2;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class httputils2service extends android.app.Service {
	public static class httputils2service_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, httputils2service.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static httputils2service mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return httputils2service.class;
	}
	@Override
	public void onCreate() {
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "anywheresoftware.b4a.samples.httputils2", "anywheresoftware.b4a.samples.httputils2.httputils2service");
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
			processBA.raiseEvent2(null, true, "CREATE", true, "anywheresoftware.b4a.samples.httputils2.httputils2service", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, true) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("** Service (httputils2service) Create **");
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
                    BA.LogInfo("** Service (httputils2service) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
				}
			};
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (httputils2service) Start **");
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
        BA.LogInfo("** Service (httputils2service) Destroy **");
		processBA.raiseEvent(null, "service_destroy");
        processBA.service = null;
		mostCurrent = null;
		processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4h.okhttp.OkHttpClientWrapper _hc = null;
public static anywheresoftware.b4a.objects.collections.Map _taskidtojob = null;
public static String _tempfolder = "";
public static int _taskcounter = 0;
public anywheresoftware.b4a.samples.httputils2.main _main = null;
public static String  _completejob(int _taskid,boolean _success,String _errormessage) throws Exception{
anywheresoftware.b4a.samples.httputils2.httpjob _job = null;
 //BA.debugLineNum = 94;BA.debugLine="Sub CompleteJob(TaskId As Int, success As Boolean,";
 //BA.debugLineNum = 95;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
_job = (anywheresoftware.b4a.samples.httputils2.httpjob)(_taskidtojob.Get((Object)(_taskid)));
 //BA.debugLineNum = 96;BA.debugLine="TaskIdToJob.Remove(TaskId)";
_taskidtojob.Remove((Object)(_taskid));
 //BA.debugLineNum = 97;BA.debugLine="job.success = success";
_job._success = _success;
 //BA.debugLineNum = 98;BA.debugLine="job.errorMessage = errorMessage";
_job._errormessage = _errormessage;
 //BA.debugLineNum = 99;BA.debugLine="job.Complete(TaskId)";
_job._complete(_taskid);
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responseerror(anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse _response,String _reason,int _statuscode,int _taskid) throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Sub hc_ResponseError (Response As OkHttpResponse,";
 //BA.debugLineNum = 84;BA.debugLine="Log(\"hc_ResponseError:\"&Reason&\" \"&StatusCode)";
anywheresoftware.b4a.keywords.Common.Log("hc_ResponseError:"+_reason+" "+BA.NumberToString(_statuscode));
 //BA.debugLineNum = 85;BA.debugLine="If Response <> Null Then";
if (_response!= null) { 
 //BA.debugLineNum = 86;BA.debugLine="Log(Response.ErrorResponse)";
anywheresoftware.b4a.keywords.Common.Log(_response.getErrorResponse());
 //BA.debugLineNum = 87;BA.debugLine="Response.Release";
_response.Release();
 };
 //BA.debugLineNum = 89;BA.debugLine="CompleteJob(TaskId, False, Reason)";
_completejob(_taskid,anywheresoftware.b4a.keywords.Common.False,_reason);
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responsesuccess(anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse _response,int _taskid) throws Exception{
anywheresoftware.b4a.samples.httputils2.httpjob _job = null;
 //BA.debugLineNum = 54;BA.debugLine="Sub hc_ResponseSuccess (Response As OkHttpResponse";
 //BA.debugLineNum = 55;BA.debugLine="Log(\"hc_ResponseSuccess\")";
anywheresoftware.b4a.keywords.Common.Log("hc_ResponseSuccess");
 //BA.debugLineNum = 56;BA.debugLine="If Response.ContentLength=0 Then";
if (_response.getContentLength()==0) { 
 //BA.debugLineNum = 57;BA.debugLine="CompleteJob(TaskId, True, \"\")";
_completejob(_taskid,anywheresoftware.b4a.keywords.Common.True,"");
 }else {
 //BA.debugLineNum = 59;BA.debugLine="Dim job As HttpJob=TaskIdToJob.Get(TaskId)";
_job = (anywheresoftware.b4a.samples.httputils2.httpjob)(_taskidtojob.Get((Object)(_taskid)));
 //BA.debugLineNum = 60;BA.debugLine="job.response=Response";
_job._response = _response;
 //BA.debugLineNum = 61;BA.debugLine="If job.CookieAutoProcess Then";
if (_job._cookieautoprocess) { 
 //BA.debugLineNum = 63;BA.debugLine="File.WriteMap(File.DirInternal,\"mycookie\",Respo";
anywheresoftware.b4a.keywords.Common.File.WriteMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"mycookie",_response.GetHeaders());
 };
 //BA.debugLineNum = 65;BA.debugLine="job.ocos.Initialize(File.OpenOutput(TempFolder,";
_job._ocos.Initialize((java.io.OutputStream)(anywheresoftware.b4a.keywords.Common.File.OpenOutput(_tempfolder,BA.NumberToString(_taskid),anywheresoftware.b4a.keywords.Common.False).getObject()));
 //BA.debugLineNum = 66;BA.debugLine="Response.GetAsynchronously(\"response\", job.ocos,";
_response.GetAsynchronously(processBA,"response",(java.io.OutputStream)(_job._ocos.getObject()),anywheresoftware.b4a.keywords.Common.True,_taskid);
 //BA.debugLineNum = 68;BA.debugLine="TaskIdToJob.Put(TaskId,job)";
_taskidtojob.Put((Object)(_taskid),(Object)(_job));
 };
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Private hc As OkHttpClient";
_hc = new anywheresoftware.b4h.okhttp.OkHttpClientWrapper();
 //BA.debugLineNum = 9;BA.debugLine="Private TaskIdToJob As Map";
_taskidtojob = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 10;BA.debugLine="Public TempFolder As String";
_tempfolder = "";
 //BA.debugLineNum = 11;BA.debugLine="Private taskCounter As Int";
_taskcounter = 0;
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public static String  _response_streamfinish(boolean _success,int _taskid) throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Sub Response_StreamFinish (Success As Boolean, Tas";
 //BA.debugLineNum = 74;BA.debugLine="Log(\"Response_StreamFinish\")";
anywheresoftware.b4a.keywords.Common.Log("Response_StreamFinish");
 //BA.debugLineNum = 75;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 76;BA.debugLine="CompleteJob(TaskId, Success, \"\")";
_completejob(_taskid,_success,"");
 }else {
 //BA.debugLineNum = 78;BA.debugLine="CompleteJob(TaskId, Success, LastException.Messa";
_completejob(_taskid,_success,anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
 //BA.debugLineNum = 81;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 15;BA.debugLine="TempFolder = File.DirInternalCache";
_tempfolder = anywheresoftware.b4a.keywords.Common.File.getDirInternalCache();
 //BA.debugLineNum = 16;BA.debugLine="hc.Initialize(\"hc\")";
_hc.Initialize("hc");
 //BA.debugLineNum = 17;BA.debugLine="TaskIdToJob.Initialize";
_taskidtojob.Initialize();
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public static int  _submitjob(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
anywheresoftware.b4a.objects.collections.Map _ckm = null;
int _i = 0;
String _key = "";
 //BA.debugLineNum = 27;BA.debugLine="Public Sub SubmitJob(job As HttpJob) As Int";
 //BA.debugLineNum = 28;BA.debugLine="taskCounter = taskCounter + 1";
_taskcounter = (int) (_taskcounter+1);
 //BA.debugLineNum = 29;BA.debugLine="If job.CookieAutoProcess Then'还原header";
if (_job._cookieautoprocess) { 
 //BA.debugLineNum = 30;BA.debugLine="Dim ckm As Map";
_ckm = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 31;BA.debugLine="Try";
try { //BA.debugLineNum = 32;BA.debugLine="ckm=File.ReadMap(File.DirInternal,\"mycookie\")";
_ckm = anywheresoftware.b4a.keywords.Common.File.ReadMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"mycookie");
 } 
       catch (Exception e7) {
			processBA.setLastException(e7); //BA.debugLineNum = 34;BA.debugLine="ckm.Initialize";
_ckm.Initialize();
 };
 //BA.debugLineNum = 36;BA.debugLine="For i=0 To ckm.Size-1";
{
final int step9 = 1;
final int limit9 = (int) (_ckm.getSize()-1);
for (_i = (int) (0) ; (step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9); _i = ((int)(0 + _i + step9)) ) {
 //BA.debugLineNum = 37;BA.debugLine="Dim key As String=ckm.GetKeyAt(i)";
_key = BA.ObjectToString(_ckm.GetKeyAt(_i));
 //BA.debugLineNum = 38;BA.debugLine="If key.ToLowerCase.IndexOf(\"set-cookie\")>-1 The";
if (_key.toLowerCase().indexOf("set-cookie")>-1) { 
 //BA.debugLineNum = 39;BA.debugLine="job.GetRequest.SetHeader(\"Cookie\",ckm.GetValue";
_job._getrequest().SetHeader("Cookie",BA.ObjectToString(_ckm.GetValueAt(_i)));
 }else {
 //BA.debugLineNum = 41;BA.debugLine="job.GetRequest.SetHeader(ckm.GetKeyAt(i),ckm.G";
_job._getrequest().SetHeader(BA.ObjectToString(_ckm.GetKeyAt(_i)),BA.ObjectToString(_ckm.GetValueAt(_i)));
 };
 }
};
 };
 //BA.debugLineNum = 45;BA.debugLine="TaskIdToJob.Put(taskCounter, job)";
_taskidtojob.Put((Object)(_taskcounter),(Object)(_job));
 //BA.debugLineNum = 46;BA.debugLine="If job.Username <> \"\" And job.Password <> \"\" Then";
if ((_job._username).equals("") == false && (_job._password).equals("") == false) { 
 //BA.debugLineNum = 47;BA.debugLine="hc.ExecuteCredentials(job.GetRequest, taskCounte";
_hc.ExecuteCredentials(processBA,_job._getrequest(),_taskcounter,_job._username,_job._password);
 }else {
 //BA.debugLineNum = 49;BA.debugLine="hc.Execute(job.GetRequest, taskCounter)";
_hc.Execute(processBA,_job._getrequest(),_taskcounter);
 };
 //BA.debugLineNum = 51;BA.debugLine="Return taskCounter";
if (true) return _taskcounter;
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return 0;
}
}
