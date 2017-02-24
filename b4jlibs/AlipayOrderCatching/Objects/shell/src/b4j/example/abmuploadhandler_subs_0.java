package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class abmuploadhandler_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim ABM As ABMaterial";
abmuploadhandler._abm = RemoteObject.createNew ("com.ab.abmaterial.ABMaterial");__ref.setField("_abm",abmuploadhandler._abm);
 //BA.debugLineNum = 4;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _handle(RemoteObject __ref,RemoteObject _req,RemoteObject _resp) throws Exception{
try {
		Debug.PushSubsStack("Handle (abmuploadhandler) ","abmuploadhandler",5,__ref.getField(false, "ba"),__ref,10);
if (RapidSub.canDelegate("handle")) return __ref.runUserSub(false, "abmuploadhandler","handle", __ref, _req, _resp);
RemoteObject _callback = RemoteObject.declareNull("Object");
RemoteObject _downloadfolder = RemoteObject.createImmutable("");
RemoteObject _maxsize = RemoteObject.createImmutable(0);
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _filename = RemoteObject.createImmutable("");
RemoteObject _tmpfilename = RemoteObject.createImmutable("");
RemoteObject _filepart = RemoteObject.declareNull("anywheresoftware.b4j.object.JServlet.PartWrapper");
Debug.locals.put("req", _req);
Debug.locals.put("resp", _resp);
 BA.debugLineNum = 10;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
Debug.ShouldStop(512);
 BA.debugLineNum = 12;BA.debugLine="Dim callback As Object = req.GetSession.GetAttrib";
Debug.ShouldStop(2048);
_callback = _req.runMethod(false,"GetSession").runMethod(false,"GetAttribute",(Object)(RemoteObject.createImmutable("abmcallback")));Debug.locals.put("callback", _callback);Debug.locals.put("callback", _callback);
 BA.debugLineNum = 13;BA.debugLine="Dim downloadfolder As String = File.Combine(File.";
Debug.ShouldStop(4096);
_downloadfolder = abmuploadhandler.__c.getField(false,"File").runMethod(true,"Combine",(Object)(abmuploadhandler.__c.getField(false,"File").runMethod(true,"getDirApp")),(Object)(BA.ObjectToString(_req.runMethod(false,"GetSession").runMethod(false,"GetAttribute",(Object)(RemoteObject.createImmutable("abmdownloadfolder"))))));Debug.locals.put("downloadfolder", _downloadfolder);Debug.locals.put("downloadfolder", _downloadfolder);
 BA.debugLineNum = 14;BA.debugLine="Dim MaxSize As Int";
Debug.ShouldStop(8192);
_maxsize = RemoteObject.createImmutable(0);Debug.locals.put("MaxSize", _maxsize);
 BA.debugLineNum = 15;BA.debugLine="Try";
Debug.ShouldStop(16384);
try { BA.debugLineNum = 16;BA.debugLine="MaxSize = req.GetSession.GetAttribute(\"abmmaxsiz";
Debug.ShouldStop(32768);
_maxsize = BA.numberCast(int.class, _req.runMethod(false,"GetSession").runMethod(false,"GetAttribute",(Object)(RemoteObject.createImmutable("abmmaxsize"))));Debug.locals.put("MaxSize", _maxsize);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e7) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e7.toString()); BA.debugLineNum = 18;BA.debugLine="resp.SendError(500, LastException.Message)";
Debug.ShouldStop(131072);
_resp.runVoidMethodAndSync ("SendError",(Object)(BA.numberCast(int.class, 500)),(Object)(abmuploadhandler.__c.runMethod(false,"LastException",__ref.getField(false, "ba")).runMethod(true,"getMessage")));
 BA.debugLineNum = 19;BA.debugLine="Return";
Debug.ShouldStop(262144);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 21;BA.debugLine="Dim data As Map";
Debug.ShouldStop(1048576);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("data", _data);
 BA.debugLineNum = 22;BA.debugLine="Dim fileName As String";
Debug.ShouldStop(2097152);
_filename = RemoteObject.createImmutable("");Debug.locals.put("fileName", _filename);
 BA.debugLineNum = 23;BA.debugLine="Dim tmpFileName As String";
Debug.ShouldStop(4194304);
_tmpfilename = RemoteObject.createImmutable("");Debug.locals.put("tmpFileName", _tmpfilename);
 BA.debugLineNum = 25;BA.debugLine="Try";
Debug.ShouldStop(16777216);
try { BA.debugLineNum = 26;BA.debugLine="data = req.GetMultipartData(downloadfolder, MaxS";
Debug.ShouldStop(33554432);
_data = _req.runMethod(false,"GetMultipartData",(Object)(_downloadfolder),(Object)(BA.numberCast(long.class, _maxsize)));Debug.locals.put("data", _data);
 BA.debugLineNum = 27;BA.debugLine="Dim filePart As Part = data.Get(\"upl\")";
Debug.ShouldStop(67108864);
_filepart = RemoteObject.createNew ("anywheresoftware.b4j.object.JServlet.PartWrapper");
_filepart.setObject(_data.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("upl")))));Debug.locals.put("filePart", _filepart);
 BA.debugLineNum = 28;BA.debugLine="If filePart.IsInitialized Then";
Debug.ShouldStop(134217728);
if (_filepart.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 29;BA.debugLine="fileName = 	filePart.SubmittedFilename";
Debug.ShouldStop(268435456);
_filename = _filepart.runMethod(true,"getSubmittedFilename");Debug.locals.put("fileName", _filename);
 BA.debugLineNum = 30;BA.debugLine="tmpFileName = filePart.TempFile";
Debug.ShouldStop(536870912);
_tmpfilename = _filepart.runMethod(true,"getTempFile");Debug.locals.put("tmpFileName", _tmpfilename);
 BA.debugLineNum = 31;BA.debugLine="If ABM.HandleUpload(downloadfolder, tmpFileName";
Debug.ShouldStop(1073741824);
if (__ref.getField(false,"_abm").runMethod(true,"HandleUpload",(Object)(_downloadfolder),(Object)(_tmpfilename),(Object)(_filename)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 32;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
Debug.ShouldStop(-2147483648);
if (abmuploadhandler.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(_callback),(Object)(RemoteObject.createImmutable("Page_FileUploaded"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 33;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
Debug.ShouldStop(1);
abmuploadhandler.__c.runVoidMethod ("CallSubDelayed3",__ref.getField(false, "ba"),(Object)(_callback),(Object)(BA.ObjectToString("Page_FileUploaded")),(Object)((_filename)),(Object)((abmuploadhandler.__c.getField(true,"True"))));
 };
 }else {
 BA.debugLineNum = 36;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
Debug.ShouldStop(8);
if (abmuploadhandler.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(_callback),(Object)(RemoteObject.createImmutable("Page_FileUploaded"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 37;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
Debug.ShouldStop(16);
abmuploadhandler.__c.runVoidMethod ("CallSubDelayed3",__ref.getField(false, "ba"),(Object)(_callback),(Object)(BA.ObjectToString("Page_FileUploaded")),(Object)((_filename)),(Object)((abmuploadhandler.__c.getField(true,"False"))));
 };
 };
 }else {
 BA.debugLineNum = 41;BA.debugLine="Dim filePart As Part = data.Get(\"imageFromCanva";
Debug.ShouldStop(256);
_filepart = RemoteObject.createNew ("anywheresoftware.b4j.object.JServlet.PartWrapper");
_filepart.setObject(_data.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("imageFromCanvas")))));Debug.locals.put("filePart", _filepart);
 BA.debugLineNum = 42;BA.debugLine="fileName = filePart.SubmittedFilename";
Debug.ShouldStop(512);
_filename = _filepart.runMethod(true,"getSubmittedFilename");Debug.locals.put("fileName", _filename);
 BA.debugLineNum = 43;BA.debugLine="tmpFileName = filePart.TempFile";
Debug.ShouldStop(1024);
_tmpfilename = _filepart.runMethod(true,"getTempFile");Debug.locals.put("tmpFileName", _tmpfilename);
 BA.debugLineNum = 44;BA.debugLine="If ABM.HandleUpload(downloadfolder, tmpFileName";
Debug.ShouldStop(2048);
if (__ref.getField(false,"_abm").runMethod(true,"HandleUpload",(Object)(_downloadfolder),(Object)(_tmpfilename),(Object)(_filename)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 45;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
Debug.ShouldStop(4096);
if (abmuploadhandler.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(_callback),(Object)(RemoteObject.createImmutable("Page_FileUploaded"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 46;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
Debug.ShouldStop(8192);
abmuploadhandler.__c.runVoidMethod ("CallSubDelayed3",__ref.getField(false, "ba"),(Object)(_callback),(Object)(BA.ObjectToString("Page_FileUploaded")),(Object)((_filename)),(Object)((abmuploadhandler.__c.getField(true,"True"))));
 };
 }else {
 BA.debugLineNum = 49;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
Debug.ShouldStop(65536);
if (abmuploadhandler.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(_callback),(Object)(RemoteObject.createImmutable("Page_FileUploaded"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 50;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
Debug.ShouldStop(131072);
abmuploadhandler.__c.runVoidMethod ("CallSubDelayed3",__ref.getField(false, "ba"),(Object)(_callback),(Object)(BA.ObjectToString("Page_FileUploaded")),(Object)((_filename)),(Object)((abmuploadhandler.__c.getField(true,"False"))));
 };
 };
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e43) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e43.toString()); BA.debugLineNum = 56;BA.debugLine="resp.SendError(500, LastException.Message)";
Debug.ShouldStop(8388608);
_resp.runVoidMethodAndSync ("SendError",(Object)(BA.numberCast(int.class, 500)),(Object)(abmuploadhandler.__c.runMethod(false,"LastException",__ref.getField(false, "ba")).runMethod(true,"getMessage")));
 BA.debugLineNum = 57;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Then";
Debug.ShouldStop(16777216);
if (abmuploadhandler.__c.runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(_callback),(Object)(RemoteObject.createImmutable("Page_FileUploaded"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 58;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\",";
Debug.ShouldStop(33554432);
abmuploadhandler.__c.runVoidMethod ("CallSubDelayed3",__ref.getField(false, "ba"),(Object)(_callback),(Object)(BA.ObjectToString("Page_FileUploaded")),(Object)((abmuploadhandler.__c.runMethod(false,"LastException",__ref.getField(false, "ba")).runMethod(true,"getMessage"))),(Object)((abmuploadhandler.__c.getField(true,"False"))));
 };
 };
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (abmuploadhandler) ","abmuploadhandler",5,__ref.getField(false, "ba"),__ref,6);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "abmuploadhandler","initialize", __ref, _ba);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 6;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(32);
 BA.debugLineNum = 8;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}