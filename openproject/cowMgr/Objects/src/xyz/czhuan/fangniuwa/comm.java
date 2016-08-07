package xyz.czhuan.fangniuwa;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class comm {
private static comm mostCurrent = new comm();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.StringUtils _su = null;
public xyz.czhuan.fangniuwa.main _main = null;
public xyz.czhuan.fangniuwa.starter _starter = null;
public xyz.czhuan.fangniuwa.actmain _actmain = null;
public xyz.czhuan.fangniuwa.cowservice _cowservice = null;
public static String  _l(anywheresoftware.b4a.BA _ba,String _msg) throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Public Sub L(msg As String)";
 //BA.debugLineNum = 84;BA.debugLine="Log(msg)";
anywheresoftware.b4a.keywords.Common.Log(_msg);
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public static String  _long2datestr(anywheresoftware.b4a.BA _ba,long _l1) throws Exception{
 //BA.debugLineNum = 86;BA.debugLine="Public Sub long2datestr(l1 As Long) As String";
 //BA.debugLineNum = 87;BA.debugLine="DateTime.DateFormat=\"yyyy/MM/dd\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("yyyy/MM/dd");
 //BA.debugLineNum = 88;BA.debugLine="Return DateTime.Date(l1)&\" \"&DateTime.Time(l1)";
if (true) return anywheresoftware.b4a.keywords.Common.DateTime.Date(_l1)+" "+anywheresoftware.b4a.keywords.Common.DateTime.Time(_l1);
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public static float  _measuretextheight(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,String _str) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cav = null;
anywheresoftware.b4a.keywords.constants.TypefaceWrapper _tf = null;
float _ts = 0f;
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 42;BA.debugLine="Sub MeasureTextHeight(v As View,str As String) As";
 //BA.debugLineNum = 43;BA.debugLine="Dim cav As Canvas";
_cav = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 44;BA.debugLine="cav.Initialize(v)";
_cav.Initialize((android.view.View)(_v.getObject()));
 //BA.debugLineNum = 45;BA.debugLine="Dim tf As Typeface";
_tf = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Dim ts As Float";
_ts = 0f;
 //BA.debugLineNum = 47;BA.debugLine="If v Is Button Then";
if (_v.getObjectOrNull() instanceof android.widget.Button) { 
 //BA.debugLineNum = 48;BA.debugLine="Dim btn As Button=v";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn.setObject((android.widget.Button)(_v.getObject()));
 //BA.debugLineNum = 49;BA.debugLine="tf=btn.Typeface";
_tf.setObject((android.graphics.Typeface)(_btn.getTypeface()));
 //BA.debugLineNum = 50;BA.debugLine="ts=btn.TextSize";
_ts = _btn.getTextSize();
 }else {
 //BA.debugLineNum = 52;BA.debugLine="Dim lbl As Label=v";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl.setObject((android.widget.TextView)(_v.getObject()));
 //BA.debugLineNum = 53;BA.debugLine="tf=lbl.Typeface";
_tf.setObject((android.graphics.Typeface)(_lbl.getTypeface()));
 //BA.debugLineNum = 54;BA.debugLine="ts=lbl.TextSize";
_ts = _lbl.getTextSize();
 };
 //BA.debugLineNum = 56;BA.debugLine="Return cav.MeasureStringHeight(str,tf,ts)+5dip";
if (true) return (float) (_cav.MeasureStringHeight(_str,(android.graphics.Typeface)(_tf.getObject()),_ts)+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)));
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return 0f;
}
public static float  _measuretextwidth(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,String _str) throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper _cav = null;
anywheresoftware.b4a.keywords.constants.TypefaceWrapper _tf = null;
float _ts = 0f;
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 25;BA.debugLine="Sub MeasureTextWidth(v As View,str As String) As F";
 //BA.debugLineNum = 26;BA.debugLine="Dim cav As Canvas";
_cav = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
 //BA.debugLineNum = 27;BA.debugLine="cav.Initialize(v)";
_cav.Initialize((android.view.View)(_v.getObject()));
 //BA.debugLineNum = 28;BA.debugLine="Dim tf As Typeface";
_tf = new anywheresoftware.b4a.keywords.constants.TypefaceWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Dim ts As Float";
_ts = 0f;
 //BA.debugLineNum = 30;BA.debugLine="If v Is Button Then";
if (_v.getObjectOrNull() instanceof android.widget.Button) { 
 //BA.debugLineNum = 31;BA.debugLine="Dim btn As Button=v";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn.setObject((android.widget.Button)(_v.getObject()));
 //BA.debugLineNum = 32;BA.debugLine="tf=btn.Typeface";
_tf.setObject((android.graphics.Typeface)(_btn.getTypeface()));
 //BA.debugLineNum = 33;BA.debugLine="ts=btn.TextSize";
_ts = _btn.getTextSize();
 }else {
 //BA.debugLineNum = 35;BA.debugLine="Dim lbl As Label=v";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl.setObject((android.widget.TextView)(_v.getObject()));
 //BA.debugLineNum = 36;BA.debugLine="tf=lbl.Typeface";
_tf.setObject((android.graphics.Typeface)(_lbl.getTypeface()));
 //BA.debugLineNum = 37;BA.debugLine="ts=lbl.TextSize";
_ts = _lbl.getTextSize();
 };
 //BA.debugLineNum = 40;BA.debugLine="Return cav.MeasureStringWidth(str,tf,ts)";
if (true) return _cav.MeasureStringWidth(_str,(android.graphics.Typeface)(_tf.getObject()),_ts);
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return 0f;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Public su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public static String  _setcommonpadding(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
int _pl = 0;
int _pt = 0;
 //BA.debugLineNum = 73;BA.debugLine="Public Sub setcommonpadding(v As View)";
 //BA.debugLineNum = 74;BA.debugLine="Dim pl,pt As Int :pt=1dip :pl=5dip";
_pl = 0;
_pt = 0;
 //BA.debugLineNum = 74;BA.debugLine="Dim pl,pt As Int :pt=1dip :pl=5dip";
_pt = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1));
 //BA.debugLineNum = 74;BA.debugLine="Dim pl,pt As Int :pt=1dip :pl=5dip";
_pl = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5));
 //BA.debugLineNum = 75;BA.debugLine="SetPadding(v,pl,pt,pl,pt)";
_setpadding(_ba,_v,_pl,_pt,_pl,_pt);
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public static String  _setpadding(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,int _left,int _top,int _right,int _bottom) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
 //BA.debugLineNum = 16;BA.debugLine="Sub SetPadding(v As View, Left As Int, Top As Int,";
 //BA.debugLineNum = 17;BA.debugLine="Dim jo As JavaObject = v";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_v.getObject()));
 //BA.debugLineNum = 18;BA.debugLine="jo.RunMethod(\"setPadding\", Array As Object(Left,";
_jo.RunMethod("setPadding",new Object[]{(Object)(_left),(Object)(_top),(Object)(_right),(Object)(_bottom)});
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _setpaddingcommon(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
int _np = 0;
 //BA.debugLineNum = 20;BA.debugLine="Sub SetPaddingCommon(v As View)";
 //BA.debugLineNum = 21;BA.debugLine="Dim jo As JavaObject = v";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_v.getObject()));
 //BA.debugLineNum = 22;BA.debugLine="Dim np As Int=10dip";
_np = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10));
 //BA.debugLineNum = 23;BA.debugLine="jo.RunMethod(\"setPadding\", Array As Object(np,np";
_jo.RunMethod("setPadding",new Object[]{(Object)(_np),(Object)(_np),(Object)(_np),(Object)(_np)});
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public static String  _setviewwrapcontent(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 58;BA.debugLine="Sub setViewWrapContent(v As View)";
 //BA.debugLineNum = 59;BA.debugLine="Try";
try { //BA.debugLineNum = 60;BA.debugLine="If v Is Button Then";
if (_v.getObjectOrNull() instanceof android.widget.Button) { 
 //BA.debugLineNum = 61;BA.debugLine="Dim btn As Button=v";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
_btn.setObject((android.widget.Button)(_v.getObject()));
 //BA.debugLineNum = 62;BA.debugLine="btn.Width=MeasureTextWidth(btn,btn.Text)";
_btn.setWidth((int) (_measuretextwidth(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_btn.getObject())),_btn.getText())));
 //BA.debugLineNum = 63;BA.debugLine="btn.Height=MeasureTextHeight(btn,btn.Text)";
_btn.setHeight((int) (_measuretextheight(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_btn.getObject())),_btn.getText())));
 }else {
 //BA.debugLineNum = 65;BA.debugLine="Dim lbl As Label=v";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl.setObject((android.widget.TextView)(_v.getObject()));
 //BA.debugLineNum = 66;BA.debugLine="lbl.Width=MeasureTextWidth(lbl,lbl.Text)";
_lbl.setWidth((int) (_measuretextwidth(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_lbl.getObject())),_lbl.getText())));
 };
 } 
       catch (Exception e11) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e11); //BA.debugLineNum = 70;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)));
 };
 //BA.debugLineNum = 72;BA.debugLine="End Sub";
return "";
}
public static String  _sharestr(anywheresoftware.b4a.BA _ba,String _str) throws Exception{
anywheresoftware.b4a.objects.IntentWrapper _i = null;
 //BA.debugLineNum = 111;BA.debugLine="Public Sub sharestr(str As String)";
 //BA.debugLineNum = 112;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
 //BA.debugLineNum = 113;BA.debugLine="i.Initialize(i.ACTION_SEND,\"\")";
_i.Initialize(_i.ACTION_SEND,"");
 //BA.debugLineNum = 114;BA.debugLine="i.PutExtra(\"android.intent.extra.TEXT\",str)";
_i.PutExtra("android.intent.extra.TEXT",(Object)(_str));
 //BA.debugLineNum = 115;BA.debugLine="i.SetType(\"text/plain\")";
_i.SetType("text/plain");
 //BA.debugLineNum = 116;BA.debugLine="i.WrapAsIntentChooser(\"分享\")";
_i.WrapAsIntentChooser("分享");
 //BA.debugLineNum = 117;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(_ba,(Object)(_i.getObject()));
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
return "";
}
public static String  _shell(anywheresoftware.b4a.BA _ba,String _cmd) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _err = null;
anywheresoftware.b4a.phone.Phone _sh = null;
 //BA.debugLineNum = 94;BA.debugLine="public Sub shell(cmd As String) As String";
 //BA.debugLineNum = 95;BA.debugLine="Log(\"exec:\"&CRLF&cmd)";
anywheresoftware.b4a.keywords.Common.Log("exec:"+anywheresoftware.b4a.keywords.Common.CRLF+_cmd);
 //BA.debugLineNum = 98;BA.debugLine="Dim sb,err As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_err = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 99;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 100;BA.debugLine="err.Initialize";
_err.Initialize();
 //BA.debugLineNum = 101;BA.debugLine="Dim sh As Phone";
_sh = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 102;BA.debugLine="sh.Shell(cmd,Null,sb,err)";
_sh.Shell(_cmd,(String[])(anywheresoftware.b4a.keywords.Common.Null),(java.lang.StringBuilder)(_sb.getObject()),(java.lang.StringBuilder)(_err.getObject()));
 //BA.debugLineNum = 105;BA.debugLine="If err.Length>0 Then";
if (_err.getLength()>0) { 
 //BA.debugLineNum = 106;BA.debugLine="Log(err.ToString)";
anywheresoftware.b4a.keywords.Common.Log(_err.ToString());
 //BA.debugLineNum = 107;BA.debugLine="Return err.ToString";
if (true) return _err.ToString();
 };
 //BA.debugLineNum = 109;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 110;BA.debugLine="End Sub";
return "";
}
public static String  _showprogress(anywheresoftware.b4a.BA _ba,String _msg) throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Public Sub showProgress(msg As String)";
 //BA.debugLineNum = 81;BA.debugLine="ProgressDialogShow(msg)";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(_ba,_msg);
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static String  _t(anywheresoftware.b4a.BA _ba,String _msg) throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="public Sub T(msg As String)";
 //BA.debugLineNum = 78;BA.debugLine="ToastMessageShow(msg,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(_msg,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public static String  _tl(anywheresoftware.b4a.BA _ba,String _msg) throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="public Sub TL(msg As String)";
 //BA.debugLineNum = 91;BA.debugLine="ToastMessageShow(msg,False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(_msg,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 92;BA.debugLine="Log(msg)";
anywheresoftware.b4a.keywords.Common.Log(_msg);
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public static String  _urldecode(anywheresoftware.b4a.BA _ba,String _str) throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="public Sub urldecode(str As String) As String";
 //BA.debugLineNum = 14;BA.debugLine="Return su.DecodeUrl(str,\"UTF8\")";
if (true) return _su.DecodeUrl(_str,"UTF8");
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
public static String  _urlencode(anywheresoftware.b4a.BA _ba,String _str) throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Public Sub urlencode(str As String) As String";
 //BA.debugLineNum = 11;BA.debugLine="Return su.EncodeUrl(str,\"UTF8\")";
if (true) return _su.EncodeUrl(_str,"UTF8");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
}
