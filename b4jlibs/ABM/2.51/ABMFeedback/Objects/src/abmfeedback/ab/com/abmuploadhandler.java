package abmfeedback.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class abmuploadhandler extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmfeedback.ab.com", "abmfeedback.ab.com.abmuploadhandler", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmfeedback.ab.com.abmuploadhandler.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public com.ab.abmaterial.ABMaterial _abm = null;
public anywheresoftware.b4a.objects.collections.List _downloadallowedfiles = null;
public abmfeedback.ab.com.main _main = null;
public abmfeedback.ab.com.abmshared _abmshared = null;
public abmfeedback.ab.com.dbm _dbm = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim ABM As ABMaterial";
_abm = new com.ab.abmaterial.ABMaterial();
 //BA.debugLineNum = 4;BA.debugLine="Public DownLoadAllowedfiles As List";
_downloadallowedfiles = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return "";
}
public String  _handle(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
Object _callback = null;
String _downloadfolder = "";
int _maxsize = 0;
String _activecasenumber = "";
anywheresoftware.b4a.objects.collections.Map _data = null;
String _filename = "";
String _tmpfilename = "";
anywheresoftware.b4j.object.JServlet.PartWrapper _filepart = null;
 //BA.debugLineNum = 11;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
 //BA.debugLineNum = 13;BA.debugLine="Dim callback As Object = req.GetSession.GetAttrib";
_callback = _req.GetSession().GetAttribute("abmcallback");
 //BA.debugLineNum = 14;BA.debugLine="Dim downloadfolder As String = File.Combine(File.";
_downloadfolder = __c.File.Combine(__c.File.getDirApp(),BA.ObjectToString(_req.GetSession().GetAttribute("abmdownloadfolder")));
 //BA.debugLineNum = 15;BA.debugLine="Dim MaxSize As Int";
_maxsize = 0;
 //BA.debugLineNum = 16;BA.debugLine="Dim ActiveCaseNumber As String";
_activecasenumber = "";
 //BA.debugLineNum = 17;BA.debugLine="Try";
try { //BA.debugLineNum = 18;BA.debugLine="MaxSize = req.GetSession.GetAttribute(\"abmmaxsiz";
_maxsize = (int)(BA.ObjectToNumber(_req.GetSession().GetAttribute("abmmaxsize")));
 } 
       catch (Exception e8) {
			ba.setLastException(e8); //BA.debugLineNum = 20;BA.debugLine="resp.SendError(500, LastException.Message)";
_resp.SendError((int) (500),__c.LastException(ba).getMessage());
 //BA.debugLineNum = 21;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 24;BA.debugLine="Try";
try { //BA.debugLineNum = 25;BA.debugLine="ActiveCaseNumber = req.GetSession.GetAttribute(\"";
_activecasenumber = BA.ObjectToString(_req.GetSession().GetAttribute("abmactivecasenumber"));
 } 
       catch (Exception e14) {
			ba.setLastException(e14); //BA.debugLineNum = 27;BA.debugLine="Log(\"no number\")";
__c.Log("no number");
 };
 //BA.debugLineNum = 30;BA.debugLine="Dim data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 31;BA.debugLine="Dim fileName As String";
_filename = "";
 //BA.debugLineNum = 32;BA.debugLine="Dim tmpFileName As String";
_tmpfilename = "";
 //BA.debugLineNum = 33;BA.debugLine="DownLoadAllowedfiles.Initialize2(Array As String(";
_downloadallowedfiles.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{".ZIP",".PNG",".JPG",".JPEG"}));
 //BA.debugLineNum = 34;BA.debugLine="Try";
try { //BA.debugLineNum = 35;BA.debugLine="data = req.GetMultipartData(downloadfolder, MaxS";
_data = _req.GetMultipartData(_downloadfolder,(long) (_maxsize));
 //BA.debugLineNum = 36;BA.debugLine="Dim filePart As Part = data.Get(\"upl\")";
_filepart = new anywheresoftware.b4j.object.JServlet.PartWrapper();
_filepart.setObject((org.eclipse.jetty.util.MultiPartInputStreamParser.MultiPart)(_data.Get((Object)("upl"))));
 //BA.debugLineNum = 37;BA.debugLine="If filePart.IsInitialized Then";
if (_filepart.IsInitialized()) { 
 //BA.debugLineNum = 38;BA.debugLine="fileName = 	filePart.SubmittedFilename";
_filename = _filepart.getSubmittedFilename();
 //BA.debugLineNum = 39;BA.debugLine="tmpFileName = filePart.TempFile";
_tmpfilename = _filepart.getTempFile();
 //BA.debugLineNum = 40;BA.debugLine="If IsAllowed(fileName) = False Then";
if (_isallowed(_filename)==__c.False) { 
 //BA.debugLineNum = 41;BA.debugLine="File.Delete(\"\", tmpFileName)";
__c.File.Delete("",_tmpfilename);
 //BA.debugLineNum = 42;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
 //BA.debugLineNum = 43;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(_filename),(Object)(__c.False));
 };
 //BA.debugLineNum = 46;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 49;BA.debugLine="If ABM.HandleUpload(downloadfolder, tmpFileName";
if (_abm.HandleUpload(_downloadfolder,_tmpfilename,_activecasenumber+_filename)) { 
 //BA.debugLineNum = 50;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
 //BA.debugLineNum = 51;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(_filename),(Object)(__c.True));
 };
 }else {
 //BA.debugLineNum = 54;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
 //BA.debugLineNum = 55;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(_filename),(Object)(__c.False));
 };
 };
 }else {
 //BA.debugLineNum = 59;BA.debugLine="Dim filePart As Part = data.Get(\"imageFromCanva";
_filepart = new anywheresoftware.b4j.object.JServlet.PartWrapper();
_filepart.setObject((org.eclipse.jetty.util.MultiPartInputStreamParser.MultiPart)(_data.Get((Object)("imageFromCanvas"))));
 //BA.debugLineNum = 60;BA.debugLine="fileName = filePart.SubmittedFilename";
_filename = _filepart.getSubmittedFilename();
 //BA.debugLineNum = 61;BA.debugLine="tmpFileName = filePart.TempFile";
_tmpfilename = _filepart.getTempFile();
 //BA.debugLineNum = 62;BA.debugLine="If IsAllowed(fileName) = False Then";
if (_isallowed(_filename)==__c.False) { 
 //BA.debugLineNum = 63;BA.debugLine="File.Delete(\"\", tmpFileName)";
__c.File.Delete("",_tmpfilename);
 //BA.debugLineNum = 64;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
 //BA.debugLineNum = 65;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(_filename),(Object)(__c.False));
 };
 //BA.debugLineNum = 68;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 70;BA.debugLine="If ABM.HandleUpload(downloadfolder, tmpFileName";
if (_abm.HandleUpload(_downloadfolder,_tmpfilename,_activecasenumber+_filename)) { 
 //BA.debugLineNum = 71;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
 //BA.debugLineNum = 72;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(_filename),(Object)(__c.True));
 };
 }else {
 //BA.debugLineNum = 75;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
 //BA.debugLineNum = 76;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(_filename),(Object)(__c.False));
 };
 };
 };
 } 
       catch (Exception e64) {
			ba.setLastException(e64); //BA.debugLineNum = 82;BA.debugLine="resp.SendError(500, LastException.Message)";
_resp.SendError((int) (500),__c.LastException(ba).getMessage());
 //BA.debugLineNum = 83;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Then";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
 //BA.debugLineNum = 84;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\",";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(__c.LastException(ba).getMessage()),(Object)(__c.False));
 };
 };
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 7;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public boolean  _isallowed(String _filename) throws Exception{
int _i = 0;
 //BA.debugLineNum = 89;BA.debugLine="Sub IsAllowed(fileName As String) As Boolean";
 //BA.debugLineNum = 90;BA.debugLine="If DownLoadAllowedfiles.Size = 0 Then Return True";
if (_downloadallowedfiles.getSize()==0) { 
if (true) return __c.True;};
 //BA.debugLineNum = 91;BA.debugLine="For i = 0 To DownLoadAllowedfiles.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_downloadallowedfiles.getSize()-1);
for (_i = (int) (0) ; (step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2); _i = ((int)(0 + _i + step2)) ) {
 //BA.debugLineNum = 92;BA.debugLine="If fileName.ToUpperCase.EndsWith(DownLoadAllowed";
if (_filename.toUpperCase().endsWith(BA.ObjectToString(_downloadallowedfiles.Get(_i)))) { 
 //BA.debugLineNum = 93;BA.debugLine="Return True";
if (true) return __c.True;
 };
 }
};
 //BA.debugLineNum = 96;BA.debugLine="Return False";
if (true) return __c.False;
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return false;
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
