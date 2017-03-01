package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class abmuploadhandler extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.ShellBA("b4j.example", "b4j.example.abmuploadhandler", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.abmuploadhandler.class).invoke(this, new Object[] {null});
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
public com.ab.abmaterial.ABMaterial _abm = null;
public b4j.example.main _main = null;
public b4j.example.abmshared _abmshared = null;
public b4j.example.dbm _dbm = null;
public String  _class_globals(b4j.example.abmuploadhandler __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmuploadhandler";
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="Dim ABM As ABMaterial";
_abm = new com.ab.abmaterial.ABMaterial();
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="End Sub";
return "";
}
public String  _handle(b4j.example.abmuploadhandler __ref,anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
__ref = this;
RDebugUtils.currentModule="abmuploadhandler";
if (Debug.shouldDelegate(ba, "handle"))
	return (String) Debug.delegate(ba, "handle", new Object[] {_req,_resp});
Object _callback = null;
String _downloadfolder = "";
int _maxsize = 0;
anywheresoftware.b4a.objects.collections.Map _data = null;
String _filename = "";
String _tmpfilename = "";
anywheresoftware.b4j.object.JServlet.PartWrapper _filepart = null;
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="Dim callback As Object = req.GetSession.GetAttrib";
_callback = _req.GetSession().GetAttribute("abmcallback");
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="Dim downloadfolder As String = File.Combine(File.";
_downloadfolder = __c.File.Combine(__c.File.getDirApp(),BA.ObjectToString(_req.GetSession().GetAttribute("abmdownloadfolder")));
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="Dim MaxSize As Int";
_maxsize = 0;
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="Try";
try {RDebugUtils.currentLine=4325382;
 //BA.debugLineNum = 4325382;BA.debugLine="MaxSize = req.GetSession.GetAttribute(\"abmmaxsiz";
_maxsize = (int)(BA.ObjectToNumber(_req.GetSession().GetAttribute("abmmaxsize")));
 } 
       catch (Exception e7) {
			ba.setLastException(e7);RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="resp.SendError(500, LastException.Message)";
_resp.SendError((int) (500),__c.LastException(ba).getMessage());
RDebugUtils.currentLine=4325385;
 //BA.debugLineNum = 4325385;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=4325387;
 //BA.debugLineNum = 4325387;BA.debugLine="Dim data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=4325388;
 //BA.debugLineNum = 4325388;BA.debugLine="Dim fileName As String";
_filename = "";
RDebugUtils.currentLine=4325389;
 //BA.debugLineNum = 4325389;BA.debugLine="Dim tmpFileName As String";
_tmpfilename = "";
RDebugUtils.currentLine=4325391;
 //BA.debugLineNum = 4325391;BA.debugLine="Try";
try {RDebugUtils.currentLine=4325392;
 //BA.debugLineNum = 4325392;BA.debugLine="data = req.GetMultipartData(downloadfolder, MaxS";
_data = _req.GetMultipartData(_downloadfolder,(long) (_maxsize));
RDebugUtils.currentLine=4325393;
 //BA.debugLineNum = 4325393;BA.debugLine="Dim filePart As Part = data.Get(\"upl\")";
_filepart = new anywheresoftware.b4j.object.JServlet.PartWrapper();
_filepart.setObject((org.eclipse.jetty.util.MultiPartInputStreamParser.MultiPart)(_data.Get((Object)("upl"))));
RDebugUtils.currentLine=4325394;
 //BA.debugLineNum = 4325394;BA.debugLine="If filePart.IsInitialized Then";
if (_filepart.IsInitialized()) { 
RDebugUtils.currentLine=4325395;
 //BA.debugLineNum = 4325395;BA.debugLine="fileName = 	filePart.SubmittedFilename";
_filename = _filepart.getSubmittedFilename();
RDebugUtils.currentLine=4325396;
 //BA.debugLineNum = 4325396;BA.debugLine="tmpFileName = filePart.TempFile";
_tmpfilename = _filepart.getTempFile();
RDebugUtils.currentLine=4325397;
 //BA.debugLineNum = 4325397;BA.debugLine="If ABM.HandleUpload(downloadfolder, tmpFileName";
if (__ref._abm.HandleUpload(_downloadfolder,_tmpfilename,_filename)) { 
RDebugUtils.currentLine=4325398;
 //BA.debugLineNum = 4325398;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
RDebugUtils.currentLine=4325399;
 //BA.debugLineNum = 4325399;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(_filename),(Object)(__c.True));
 };
 }else {
RDebugUtils.currentLine=4325402;
 //BA.debugLineNum = 4325402;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
RDebugUtils.currentLine=4325403;
 //BA.debugLineNum = 4325403;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(_filename),(Object)(__c.False));
 };
 };
 }else {
RDebugUtils.currentLine=4325407;
 //BA.debugLineNum = 4325407;BA.debugLine="Dim filePart As Part = data.Get(\"imageFromCanva";
_filepart = new anywheresoftware.b4j.object.JServlet.PartWrapper();
_filepart.setObject((org.eclipse.jetty.util.MultiPartInputStreamParser.MultiPart)(_data.Get((Object)("imageFromCanvas"))));
RDebugUtils.currentLine=4325408;
 //BA.debugLineNum = 4325408;BA.debugLine="fileName = filePart.SubmittedFilename";
_filename = _filepart.getSubmittedFilename();
RDebugUtils.currentLine=4325409;
 //BA.debugLineNum = 4325409;BA.debugLine="tmpFileName = filePart.TempFile";
_tmpfilename = _filepart.getTempFile();
RDebugUtils.currentLine=4325410;
 //BA.debugLineNum = 4325410;BA.debugLine="If ABM.HandleUpload(downloadfolder, tmpFileName";
if (__ref._abm.HandleUpload(_downloadfolder,_tmpfilename,_filename)) { 
RDebugUtils.currentLine=4325411;
 //BA.debugLineNum = 4325411;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
RDebugUtils.currentLine=4325412;
 //BA.debugLineNum = 4325412;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(_filename),(Object)(__c.True));
 };
 }else {
RDebugUtils.currentLine=4325415;
 //BA.debugLineNum = 4325415;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
RDebugUtils.currentLine=4325416;
 //BA.debugLineNum = 4325416;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(_filename),(Object)(__c.False));
 };
 };
 };
 } 
       catch (Exception e43) {
			ba.setLastException(e43);RDebugUtils.currentLine=4325422;
 //BA.debugLineNum = 4325422;BA.debugLine="resp.SendError(500, LastException.Message)";
_resp.SendError((int) (500),__c.LastException(ba).getMessage());
RDebugUtils.currentLine=4325423;
 //BA.debugLineNum = 4325423;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Then";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
RDebugUtils.currentLine=4325424;
 //BA.debugLineNum = 4325424;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\",";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(__c.LastException(ba).getMessage()),(Object)(__c.False));
 };
 };
RDebugUtils.currentLine=4325427;
 //BA.debugLineNum = 4325427;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4j.example.abmuploadhandler __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="abmuploadhandler";
if (Debug.shouldDelegate(ba, "initialize"))
	return (String) Debug.delegate(ba, "initialize", new Object[] {_ba});
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="End Sub";
return "";
}
}