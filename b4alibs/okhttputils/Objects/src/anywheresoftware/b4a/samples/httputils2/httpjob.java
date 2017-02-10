package anywheresoftware.b4a.samples.httputils2;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class httpjob extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "anywheresoftware.b4a.samples.httputils2.httpjob");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", anywheresoftware.b4a.samples.httputils2.httpjob.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _jobname = "";
public boolean _success = false;
public String _username = "";
public String _password = "";
public String _errormessage = "";
public Object _target = null;
public String _taskid = "";
public anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest _req = null;
public Object _tag = null;
public anywheresoftware.b4a.randomaccessfile.CountingStreams.CountingInput _ocis = null;
public anywheresoftware.b4a.randomaccessfile.CountingStreams.CountingOutput _ocos = null;
public anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse _response = null;
public boolean _cookieautoprocess = false;
public long _ltotalsize = 0L;
public anywheresoftware.b4a.samples.httputils2.main _main = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public static class _multipartfiledata{
public boolean IsInitialized;
public String Dir;
public String FileName;
public String KeyName;
public String ContentType;
public void Initialize() {
IsInitialized = true;
Dir = "";
FileName = "";
KeyName = "";
ContentType = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _canceldownload() throws Exception{
 //BA.debugLineNum = 206;BA.debugLine="Public Sub cancelDownload";
 //BA.debugLineNum = 207;BA.debugLine="If ocos<>Null And ocos.IsInitialized Then";
if (_ocos!= null && _ocos.IsInitialized()) { 
 //BA.debugLineNum = 208;BA.debugLine="ocos.Close";
_ocos.Close();
 };
 //BA.debugLineNum = 210;BA.debugLine="lTotalSize=-1";
_ltotalsize = (long) (-1);
 //BA.debugLineNum = 211;BA.debugLine="End Sub";
return "";
}
public String  _cancelupload() throws Exception{
 //BA.debugLineNum = 225;BA.debugLine="Public Sub cancelUpload";
 //BA.debugLineNum = 226;BA.debugLine="If ocis<>Null And ocis.IsInitialized Then";
if (_ocis!= null && _ocis.IsInitialized()) { 
 //BA.debugLineNum = 227;BA.debugLine="ocis.Close";
_ocis.Close();
 };
 //BA.debugLineNum = 229;BA.debugLine="lTotalSize=-1";
_ltotalsize = (long) (-1);
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Public JobName As String";
_jobname = "";
 //BA.debugLineNum = 7;BA.debugLine="Public Success As Boolean";
_success = false;
 //BA.debugLineNum = 8;BA.debugLine="Public Username, Password As String";
_username = "";
_password = "";
 //BA.debugLineNum = 9;BA.debugLine="Public ErrorMessage As String";
_errormessage = "";
 //BA.debugLineNum = 10;BA.debugLine="Private target As Object";
_target = new Object();
 //BA.debugLineNum = 11;BA.debugLine="Private taskId As String";
_taskid = "";
 //BA.debugLineNum = 12;BA.debugLine="Private req As OkHttpRequest";
_req = new anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest();
 //BA.debugLineNum = 13;BA.debugLine="Public Tag As Object";
_tag = new Object();
 //BA.debugLineNum = 14;BA.debugLine="Public ocis As CountingInputStream";
_ocis = new anywheresoftware.b4a.randomaccessfile.CountingStreams.CountingInput();
 //BA.debugLineNum = 15;BA.debugLine="Public ocos As CountingOutputStream";
_ocos = new anywheresoftware.b4a.randomaccessfile.CountingStreams.CountingOutput();
 //BA.debugLineNum = 16;BA.debugLine="Public response=Null As OkHttpResponse";
_response = (anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse)(__c.Null);
 //BA.debugLineNum = 17;BA.debugLine="Public CookieAutoProcess As Boolean=True";
_cookieautoprocess = __c.True;
 //BA.debugLineNum = 18;BA.debugLine="Private lTotalSize=-1 As Long";
_ltotalsize = (long) (-1);
 //BA.debugLineNum = 19;BA.debugLine="Type MultipartFileData (Dir As String, FileName A";
;
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return "";
}
public String  _complete(int _id) throws Exception{
 //BA.debugLineNum = 190;BA.debugLine="Public Sub Complete (id As Int)";
 //BA.debugLineNum = 191;BA.debugLine="taskId = id";
_taskid = BA.NumberToString(_id);
 //BA.debugLineNum = 192;BA.debugLine="CallSubDelayed2(target, \"JobDone\", Me)";
__c.CallSubDelayed2(getActivityBA(),_target,"JobDone",this);
 //BA.debugLineNum = 193;BA.debugLine="End Sub";
return "";
}
public String  _download(String _link) throws Exception{
 //BA.debugLineNum = 155;BA.debugLine="Public Sub Download(Link As String)";
 //BA.debugLineNum = 156;BA.debugLine="req.InitializeGet(Link)";
_req.InitializeGet(_link);
 //BA.debugLineNum = 157;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(getActivityBA(),(Object)(_httputils2service.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public String  _download2(String _link,String[] _parameters) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
int _i = 0;
 //BA.debugLineNum = 165;BA.debugLine="Public Sub Download2(Link As String, Parameters()";
 //BA.debugLineNum = 166;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 167;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 168;BA.debugLine="sb.Append(Link)";
_sb.Append(_link);
 //BA.debugLineNum = 169;BA.debugLine="If Parameters.Length > 0 Then sb.Append(\"?\")";
if (_parameters.length>0) { 
_sb.Append("?");};
 //BA.debugLineNum = 170;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 171;BA.debugLine="For i = 0 To Parameters.Length - 1 Step 2";
{
final int step6 = (int) (2);
final int limit6 = (int) (_parameters.length-1);
for (_i = (int) (0) ; (step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6); _i = ((int)(0 + _i + step6)) ) {
 //BA.debugLineNum = 172;BA.debugLine="If i > 0 Then sb.Append(\"&\")";
if (_i>0) { 
_sb.Append("&");};
 //BA.debugLineNum = 173;BA.debugLine="sb.Append(su.EncodeUrl(Parameters(i), \"UTF8\")).A";
_sb.Append(_su.EncodeUrl(_parameters[_i],"UTF8")).Append("=");
 //BA.debugLineNum = 174;BA.debugLine="sb.Append(su.EncodeUrl(Parameters(i + 1), \"UTF8\"";
_sb.Append(_su.EncodeUrl(_parameters[(int) (_i+1)],"UTF8"));
 }
};
 //BA.debugLineNum = 176;BA.debugLine="req.InitializeGet(sb.ToString)";
_req.InitializeGet(_sb.ToString());
 //BA.debugLineNum = 177;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(getActivityBA(),(Object)(_httputils2service.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _getbitmap() throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _b = null;
 //BA.debugLineNum = 247;BA.debugLine="Public Sub GetBitmap As Bitmap";
 //BA.debugLineNum = 248;BA.debugLine="Dim b As Bitmap";
_b = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 249;BA.debugLine="b = LoadBitmap(HttpUtils2Service.TempFolder, task";
_b = __c.LoadBitmap(_httputils2service._tempfolder,_taskid);
 //BA.debugLineNum = 250;BA.debugLine="Return b";
if (true) return _b;
 //BA.debugLineNum = 251;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _getbitmapsample(int _width,int _height) throws Exception{
 //BA.debugLineNum = 253;BA.debugLine="Public Sub GetBitmapSample(Width As Int, Height As";
 //BA.debugLineNum = 254;BA.debugLine="Return LoadBitmapSample(HttpUtils2Service.TempFol";
if (true) return __c.LoadBitmapSample(_httputils2service._tempfolder,_taskid,_width,_height);
 //BA.debugLineNum = 255;BA.debugLine="End Sub";
return null;
}
public long  _getcurrentcount() throws Exception{
 //BA.debugLineNum = 219;BA.debugLine="Public Sub GetCurrentCount As Long";
 //BA.debugLineNum = 220;BA.debugLine="If ocis<>Null And ocis.IsInitialized Then Return";
if (_ocis!= null && _ocis.IsInitialized()) { 
if (true) return _ocis.getCount();};
 //BA.debugLineNum = 221;BA.debugLine="If ocos<>Null And ocos.IsInitialized Then Return";
if (_ocos!= null && _ocos.IsInitialized()) { 
if (true) return _ocos.getCount();};
 //BA.debugLineNum = 222;BA.debugLine="Return -1";
if (true) return (long) (-1);
 //BA.debugLineNum = 223;BA.debugLine="End Sub";
return 0L;
}
public anywheresoftware.b4a.objects.collections.Map  _getheader() throws Exception{
 //BA.debugLineNum = 185;BA.debugLine="Public Sub GetHeader As Map";
 //BA.debugLineNum = 186;BA.debugLine="If response<>Null Then Return response.GetHeaders";
if (_response!= null) { 
if (true) return _response.GetHeaders();}
else {
if (true) return (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(__c.Null));};
 //BA.debugLineNum = 187;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.streams.File.InputStreamWrapper  _getinputstream() throws Exception{
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
 //BA.debugLineNum = 257;BA.debugLine="Public Sub GetInputStream As InputStream";
 //BA.debugLineNum = 258;BA.debugLine="Dim In As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 259;BA.debugLine="In = File.OpenInput(HttpUtils2Service.TempFolder,";
_in = __c.File.OpenInput(_httputils2service._tempfolder,_taskid);
 //BA.debugLineNum = 260;BA.debugLine="Return In";
if (true) return _in;
 //BA.debugLineNum = 261;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest  _getrequest() throws Exception{
 //BA.debugLineNum = 181;BA.debugLine="Public Sub GetRequest As OkHttpRequest";
 //BA.debugLineNum = 182;BA.debugLine="Return req";
if (true) return _req;
 //BA.debugLineNum = 183;BA.debugLine="End Sub";
return null;
}
public String  _getstring() throws Exception{
 //BA.debugLineNum = 233;BA.debugLine="Public Sub GetString As String";
 //BA.debugLineNum = 234;BA.debugLine="Return GetString2(\"UTF8\")";
if (true) return _getstring2("UTF8");
 //BA.debugLineNum = 235;BA.debugLine="End Sub";
return "";
}
public String  _getstring2(String _encoding) throws Exception{
anywheresoftware.b4a.objects.streams.File.TextReaderWrapper _tr = null;
String _res = "";
 //BA.debugLineNum = 238;BA.debugLine="Public Sub GetString2(Encoding As String) As Strin";
 //BA.debugLineNum = 239;BA.debugLine="Dim tr As TextReader";
_tr = new anywheresoftware.b4a.objects.streams.File.TextReaderWrapper();
 //BA.debugLineNum = 240;BA.debugLine="tr.Initialize2(File.OpenInput(HttpUtils2Service.T";
_tr.Initialize2((java.io.InputStream)(__c.File.OpenInput(_httputils2service._tempfolder,_taskid).getObject()),_encoding);
 //BA.debugLineNum = 241;BA.debugLine="Dim res As String";
_res = "";
 //BA.debugLineNum = 242;BA.debugLine="res = tr.ReadAll";
_res = _tr.ReadAll();
 //BA.debugLineNum = 243;BA.debugLine="tr.Close";
_tr.Close();
 //BA.debugLineNum = 244;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return "";
}
public long  _gettotalsize() throws Exception{
 //BA.debugLineNum = 213;BA.debugLine="Public Sub GetTotalSize As Long";
 //BA.debugLineNum = 214;BA.debugLine="If lTotalSize>0 Then Return lTotalSize";
if (_ltotalsize>0) { 
if (true) return _ltotalsize;};
 //BA.debugLineNum = 215;BA.debugLine="If response<>Null Then Return response.ContentLen";
if (_response!= null) { 
if (true) return _response.getContentLength();};
 //BA.debugLineNum = 216;BA.debugLine="Return -1";
if (true) return (long) (-1);
 //BA.debugLineNum = 217;BA.debugLine="End Sub";
return 0L;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,String _name,Object _targetmodule) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 25;BA.debugLine="Public Sub Initialize (Name As String, TargetModul";
 //BA.debugLineNum = 26;BA.debugLine="JobName = Name";
_jobname = _name;
 //BA.debugLineNum = 27;BA.debugLine="target = TargetModule";
_target = _targetmodule;
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return "";
}
public String  _postbytes(String _link,byte[] _data) throws Exception{
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _ins = null;
 //BA.debugLineNum = 40;BA.debugLine="Public Sub PostBytes(Link As String, Data() As Byt";
 //BA.debugLineNum = 41;BA.debugLine="Dim ins As InputStream";
_ins = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 42;BA.debugLine="ins.InitializeFromBytesArray(Data,0,Data.Length)";
_ins.InitializeFromBytesArray(_data,(int) (0),_data.length);
 //BA.debugLineNum = 43;BA.debugLine="lTotalSize=Data.Length";
_ltotalsize = (long) (_data.length);
 //BA.debugLineNum = 44;BA.debugLine="ocis.Initialize(ins)";
_ocis.Initialize((java.io.InputStream)(_ins.getObject()));
 //BA.debugLineNum = 45;BA.debugLine="req.InitializePost(Link, ocis,lTotalSize)";
_req.InitializePost(_link,(java.io.InputStream)(_ocis.getObject()),(int) (_ltotalsize));
 //BA.debugLineNum = 46;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(getActivityBA(),(Object)(_httputils2service.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public String  _postbytes2(String _link,byte[] _data) throws Exception{
 //BA.debugLineNum = 34;BA.debugLine="Public Sub PostBytes2(Link As String, Data() As By";
 //BA.debugLineNum = 35;BA.debugLine="req.InitializePost2(Link, Data)";
_req.InitializePost2(_link,_data);
 //BA.debugLineNum = 37;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(getActivityBA(),(Object)(_httputils2service.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public String  _postfile(String _link,String _dir,String _filename) throws Exception{
long _length = 0L;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
 //BA.debugLineNum = 114;BA.debugLine="Public Sub PostFile(Link As String, Dir As String,";
 //BA.debugLineNum = 115;BA.debugLine="Dim length As Long";
_length = 0L;
 //BA.debugLineNum = 116;BA.debugLine="If Dir = File.DirAssets Then";
if ((_dir).equals(__c.File.getDirAssets())) { 
 //BA.debugLineNum = 117;BA.debugLine="Log(\"Cannot send files from the assets folder";
__c.Log("Cannot send files from the assets folder.");
 //BA.debugLineNum = 118;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 120;BA.debugLine="length = File.Size(Dir, FileName)";
_length = __c.File.Size(_dir,_filename);
 //BA.debugLineNum = 121;BA.debugLine="lTotalSize=length";
_ltotalsize = _length;
 //BA.debugLineNum = 122;BA.debugLine="Dim In As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 123;BA.debugLine="In = File.OpenInput(Dir, FileName)";
_in = __c.File.OpenInput(_dir,_filename);
 //BA.debugLineNum = 124;BA.debugLine="ocis.Initialize(In)";
_ocis.Initialize((java.io.InputStream)(_in.getObject()));
 //BA.debugLineNum = 125;BA.debugLine="req.InitializePost(Link, ocis, length)";
_req.InitializePost(_link,(java.io.InputStream)(_ocis.getObject()),(int) (_length));
 //BA.debugLineNum = 126;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\",";
__c.CallSubDelayed2(getActivityBA(),(Object)(_httputils2service.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public String  _postfile2(String _link,String _dir,String _filename) throws Exception{
int _length = 0;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 130;BA.debugLine="Public Sub PostFile2(Link As String, Dir As String";
 //BA.debugLineNum = 131;BA.debugLine="Dim length As Int";
_length = 0;
 //BA.debugLineNum = 132;BA.debugLine="If Dir = File.DirAssets Then";
if ((_dir).equals(__c.File.getDirAssets())) { 
 //BA.debugLineNum = 133;BA.debugLine="Log(\"Cannot send files from the assets folder.\")";
__c.Log("Cannot send files from the assets folder.");
 //BA.debugLineNum = 134;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 136;BA.debugLine="length = File.Size(Dir, FileName)";
_length = (int) (__c.File.Size(_dir,_filename));
 //BA.debugLineNum = 137;BA.debugLine="lTotalSize=length";
_ltotalsize = (long) (_length);
 //BA.debugLineNum = 138;BA.debugLine="Dim In As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 139;BA.debugLine="In = File.OpenInput(Dir, FileName)";
_in = __c.File.OpenInput(_dir,_filename);
 //BA.debugLineNum = 141;BA.debugLine="If length < 1000000 Then '1mb";
if (_length<1000000) { 
 //BA.debugLineNum = 144;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
 //BA.debugLineNum = 145;BA.debugLine="out.InitializeToBytesArray(length)";
_out.InitializeToBytesArray(_length);
 //BA.debugLineNum = 146;BA.debugLine="File.Copy2(In, out)";
__c.File.Copy2((java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_out.getObject()));
 //BA.debugLineNum = 147;BA.debugLine="PostBytes(Link, out.ToBytesArray)";
_postbytes(_link,_out.ToBytesArray());
 }else {
 //BA.debugLineNum = 149;BA.debugLine="req.InitializePost(Link, In, length)";
_req.InitializePost(_link,(java.io.InputStream)(_in.getObject()),_length);
 //BA.debugLineNum = 150;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\",";
__c.CallSubDelayed2(getActivityBA(),(Object)(_httputils2service.getObject()),"SubmitJob",this);
 };
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return "";
}
public String  _postmultipart(String _link,anywheresoftware.b4a.objects.collections.Map _namevalues,anywheresoftware.b4a.objects.collections.List _files) throws Exception{
String _boundary = "";
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _stream = null;
byte[] _b = null;
String _eol = "";
String _key = "";
String _value = "";
String _s = "";
anywheresoftware.b4a.samples.httputils2.httpjob._multipartfiledata _fd = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
 //BA.debugLineNum = 68;BA.debugLine="public Sub PostMultipart(Link As String, NameValue";
 //BA.debugLineNum = 69;BA.debugLine="Dim boundary As String = \"-----------------------";
_boundary = "---------------------------1461124740692";
 //BA.debugLineNum = 70;BA.debugLine="Dim stream As OutputStream";
_stream = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
 //BA.debugLineNum = 71;BA.debugLine="stream.InitializeToBytesArray(0)";
_stream.InitializeToBytesArray((int) (0));
 //BA.debugLineNum = 72;BA.debugLine="Dim b() As Byte";
_b = new byte[(int) (0)];
;
 //BA.debugLineNum = 73;BA.debugLine="Dim eol As String = Chr(13) & Chr(10)";
_eol = BA.ObjectToString(__c.Chr((int) (13)))+BA.ObjectToString(__c.Chr((int) (10)));
 //BA.debugLineNum = 74;BA.debugLine="If NameValues <> Null And NameValues.IsInitialize";
if (_namevalues!= null && _namevalues.IsInitialized()) { 
 //BA.debugLineNum = 75;BA.debugLine="For Each key As String In NameValues.Keys";
final anywheresoftware.b4a.BA.IterableList group7 = _namevalues.Keys();
final int groupLen7 = group7.getSize();
for (int index7 = 0;index7 < groupLen7 ;index7++){
_key = BA.ObjectToString(group7.Get(index7));
 //BA.debugLineNum = 76;BA.debugLine="Dim value As String = NameValues.Get(key)";
_value = BA.ObjectToString(_namevalues.Get((Object)(_key)));
 //BA.debugLineNum = 77;BA.debugLine="Dim s As String = _ $\"--${boundary} Content-Dis";
_s = ("--"+__c.SmartStringFormatter("",(Object)(_boundary))+"\n"+"Content-Disposition: form-data; name=\""+__c.SmartStringFormatter("",(Object)(_key))+"\"\n"+"\n"+""+__c.SmartStringFormatter("",(Object)(_value))+"\n"+"");
 //BA.debugLineNum = 83;BA.debugLine="b = s.Replace(CRLF, eol).GetBytes(\"UTF8\")";
_b = _s.replace(__c.CRLF,_eol).getBytes("UTF8");
 //BA.debugLineNum = 84;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
 }
;
 };
 //BA.debugLineNum = 87;BA.debugLine="If Files <> Null And Files.IsInitialized Then";
if (_files!= null && _files.IsInitialized()) { 
 //BA.debugLineNum = 88;BA.debugLine="For Each fd As MultipartFileData In Files";
final anywheresoftware.b4a.BA.IterableList group15 = _files;
final int groupLen15 = group15.getSize();
for (int index15 = 0;index15 < groupLen15 ;index15++){
_fd = (anywheresoftware.b4a.samples.httputils2.httpjob._multipartfiledata)(group15.Get(index15));
 //BA.debugLineNum = 89;BA.debugLine="Dim s As String = _ $\"--${boundary} Content-Dis";
_s = ("--"+__c.SmartStringFormatter("",(Object)(_boundary))+"\n"+"Content-Disposition: form-data; name=\""+__c.SmartStringFormatter("",(Object)(_fd.KeyName))+"\"; filename=\""+__c.SmartStringFormatter("",(Object)(_fd.FileName))+"\"\n"+"Content-Type: "+__c.SmartStringFormatter("",(Object)(_fd.ContentType))+"\n"+"\n"+"");
 //BA.debugLineNum = 95;BA.debugLine="b = s.Replace(CRLF, eol).GetBytes(\"UTF8\")";
_b = _s.replace(__c.CRLF,_eol).getBytes("UTF8");
 //BA.debugLineNum = 96;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
 //BA.debugLineNum = 97;BA.debugLine="Dim in As InputStream = File.OpenInput(fd.Dir,";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
_in = __c.File.OpenInput(_fd.Dir,_fd.FileName);
 //BA.debugLineNum = 98;BA.debugLine="File.Copy2(in, stream)";
__c.File.Copy2((java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_stream.getObject()));
 //BA.debugLineNum = 99;BA.debugLine="stream.WriteBytes(eol.GetBytes(\"utf8\"), 0, 2)";
_stream.WriteBytes(_eol.getBytes("utf8"),(int) (0),(int) (2));
 }
;
 };
 //BA.debugLineNum = 102;BA.debugLine="s = _ $\" --${boundary}-- \"$";
_s = ("\n"+"--"+__c.SmartStringFormatter("",(Object)(_boundary))+"--\n"+"");
 //BA.debugLineNum = 106;BA.debugLine="b = s.Replace(CRLF, eol).GetBytes(\"UTF8\")";
_b = _s.replace(__c.CRLF,_eol).getBytes("UTF8");
 //BA.debugLineNum = 107;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
 //BA.debugLineNum = 108;BA.debugLine="PostBytes(Link, stream.ToBytesArray)";
_postbytes(_link,_stream.ToBytesArray());
 //BA.debugLineNum = 109;BA.debugLine="req.SetContentType(\"multipart/form-data; boundary";
_req.SetContentType("multipart/form-data; boundary="+_boundary);
 //BA.debugLineNum = 110;BA.debugLine="req.SetContentEncoding(\"UTF8\")";
_req.SetContentEncoding("UTF8");
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
return "";
}
public String  _poststring(String _link,String _text) throws Exception{
 //BA.debugLineNum = 30;BA.debugLine="Public Sub PostString(Link As String, Text As Stri";
 //BA.debugLineNum = 31;BA.debugLine="PostBytes(Link, Text.GetBytes(\"UTF8\"))";
_postbytes(_link,_text.getBytes("UTF8"));
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public String  _putbytes(String _link,byte[] _data) throws Exception{
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _ins = null;
 //BA.debugLineNum = 55;BA.debugLine="Public Sub PutBytes(Link As String, Data() As Byte";
 //BA.debugLineNum = 57;BA.debugLine="Dim ins As InputStream";
_ins = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 58;BA.debugLine="ins.InitializeFromBytesArray(Data,0,Data.Length)";
_ins.InitializeFromBytesArray(_data,(int) (0),_data.length);
 //BA.debugLineNum = 59;BA.debugLine="lTotalSize=Data.Length";
_ltotalsize = (long) (_data.length);
 //BA.debugLineNum = 60;BA.debugLine="ocis.Initialize(ins)";
_ocis.Initialize((java.io.InputStream)(_ins.getObject()));
 //BA.debugLineNum = 61;BA.debugLine="req.InitializePost(Link,ocis,Data.Length)";
_req.InitializePost(_link,(java.io.InputStream)(_ocis.getObject()),_data.length);
 //BA.debugLineNum = 62;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(getActivityBA(),(Object)(_httputils2service.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public String  _putstring(String _link,String _text) throws Exception{
 //BA.debugLineNum = 50;BA.debugLine="Public Sub PutString(Link As String, Text As Strin";
 //BA.debugLineNum = 51;BA.debugLine="PutBytes(Link, Text.GetBytes(\"UTF8\"))";
_putbytes(_link,_text.getBytes("UTF8"));
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public String  _release() throws Exception{
 //BA.debugLineNum = 196;BA.debugLine="Public Sub Release";
 //BA.debugLineNum = 197;BA.debugLine="File.Delete(HttpUtils2Service.TempFolder, taskId)";
__c.File.Delete(_httputils2service._tempfolder,_taskid);
 //BA.debugLineNum = 198;BA.debugLine="Try";
try { //BA.debugLineNum = 199;BA.debugLine="response=Null";
_response = (anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse)(__c.Null);
 //BA.debugLineNum = 200;BA.debugLine="lTotalSize=-1";
_ltotalsize = (long) (-1);
 } 
       catch (Exception e6) {
			ba.setLastException(e6); //BA.debugLineNum = 202;BA.debugLine="Log(LastException.Message)";
__c.Log(__c.LastException(getActivityBA()).getMessage());
 };
 //BA.debugLineNum = 204;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
