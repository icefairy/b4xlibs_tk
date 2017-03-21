package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class abmuploadhandler extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.abmuploadhandler", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.abmuploadhandler.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public com.ab.abmaterial.ABMaterial _abm = null;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim ABM As ABMaterial";
_abm = new com.ab.abmaterial.ABMaterial();
 //BA.debugLineNum = 4;BA.debugLine="End Sub";
return "";
}
public String  _handle(anywheresoftware.b4j.object.JServlet.ServletRequestWrapper _req,anywheresoftware.b4j.object.JServlet.ServletResponseWrapper _resp) throws Exception{
Object _callback = null;
String _downloadfolder = "";
int _maxsize = 0;
anywheresoftware.b4a.objects.collections.Map _data = null;
String _filename = "";
String _tmpfilename = "";
anywheresoftware.b4j.object.JServlet.PartWrapper _filepart = null;
 //BA.debugLineNum = 10;BA.debugLine="Sub Handle(req As ServletRequest, resp As ServletR";
 //BA.debugLineNum = 12;BA.debugLine="Dim callback As Object = req.GetSession.GetAttrib";
_callback = _req.GetSession().GetAttribute("abmcallback");
 //BA.debugLineNum = 13;BA.debugLine="Dim downloadfolder As String = File.Combine(File.";
_downloadfolder = __c.File.Combine(__c.File.getDirApp(),BA.ObjectToString(_req.GetSession().GetAttribute("abmdownloadfolder")));
 //BA.debugLineNum = 14;BA.debugLine="Dim MaxSize As Int";
_maxsize = 0;
 //BA.debugLineNum = 15;BA.debugLine="Try";
try { //BA.debugLineNum = 16;BA.debugLine="MaxSize = req.GetSession.GetAttribute(\"abmmaxsiz";
_maxsize = (int)(BA.ObjectToNumber(_req.GetSession().GetAttribute("abmmaxsize")));
 } 
       catch (Exception e7) {
			ba.setLastException(e7); //BA.debugLineNum = 18;BA.debugLine="resp.SendError(500, LastException.Message)";
_resp.SendError((int) (500),__c.LastException(ba).getMessage());
 //BA.debugLineNum = 19;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 21;BA.debugLine="Dim data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 22;BA.debugLine="Dim fileName As String";
_filename = "";
 //BA.debugLineNum = 23;BA.debugLine="Dim tmpFileName As String";
_tmpfilename = "";
 //BA.debugLineNum = 25;BA.debugLine="Try";
try { //BA.debugLineNum = 26;BA.debugLine="data = req.GetMultipartData(downloadfolder, MaxS";
_data = _req.GetMultipartData(_downloadfolder,(long) (_maxsize));
 //BA.debugLineNum = 27;BA.debugLine="Dim filePart As Part = data.Get(\"upl\")";
_filepart = new anywheresoftware.b4j.object.JServlet.PartWrapper();
_filepart.setObject((org.eclipse.jetty.util.MultiPartInputStreamParser.MultiPart)(_data.Get((Object)("upl"))));
 //BA.debugLineNum = 28;BA.debugLine="If filePart.IsInitialized Then";
if (_filepart.IsInitialized()) { 
 //BA.debugLineNum = 29;BA.debugLine="fileName = 	filePart.SubmittedFilename";
_filename = _filepart.getSubmittedFilename();
 //BA.debugLineNum = 30;BA.debugLine="tmpFileName = filePart.TempFile";
_tmpfilename = _filepart.getTempFile();
 //BA.debugLineNum = 31;BA.debugLine="If ABM.HandleUpload(downloadfolder, tmpFileName";
if (_abm.HandleUpload(_downloadfolder,_tmpfilename,_filename)) { 
 //BA.debugLineNum = 32;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
 //BA.debugLineNum = 33;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(_filename),(Object)(__c.True));
 };
 }else {
 //BA.debugLineNum = 36;BA.debugLine="resp.SendError(500, \"Error\")";
_resp.SendError((int) (500),"Error");
 };
 }else {
 //BA.debugLineNum = 42;BA.debugLine="Dim filePart As Part = data.Get(\"imageFromCanva";
_filepart = new anywheresoftware.b4j.object.JServlet.PartWrapper();
_filepart.setObject((org.eclipse.jetty.util.MultiPartInputStreamParser.MultiPart)(_data.Get((Object)("imageFromCanvas"))));
 //BA.debugLineNum = 43;BA.debugLine="fileName = filePart.SubmittedFilename";
_filename = _filepart.getSubmittedFilename();
 //BA.debugLineNum = 44;BA.debugLine="tmpFileName = filePart.TempFile";
_tmpfilename = _filepart.getTempFile();
 //BA.debugLineNum = 45;BA.debugLine="If ABM.HandleUpload(downloadfolder, tmpFileName";
if (_abm.HandleUpload(_downloadfolder,_tmpfilename,_filename)) { 
 //BA.debugLineNum = 46;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
 //BA.debugLineNum = 47;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(_filename),(Object)(__c.True));
 };
 }else {
 //BA.debugLineNum = 50;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Th";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
 //BA.debugLineNum = 51;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\"";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(_filename),(Object)(__c.False));
 };
 };
 };
 } 
       catch (Exception e41) {
			ba.setLastException(e41); //BA.debugLineNum = 57;BA.debugLine="resp.SendError(500, LastException.Message)";
_resp.SendError((int) (500),__c.LastException(ba).getMessage());
 //BA.debugLineNum = 58;BA.debugLine="If SubExists(callback, \"Page_FileUploaded\") Then";
if (__c.SubExists(ba,_callback,"Page_FileUploaded")) { 
 //BA.debugLineNum = 59;BA.debugLine="CallSubDelayed3(callback, \"Page_FileUploaded\",";
__c.CallSubDelayed3(ba,_callback,"Page_FileUploaded",(Object)(__c.LastException(ba).getMessage()),(Object)(__c.False));
 };
 };
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 6;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
