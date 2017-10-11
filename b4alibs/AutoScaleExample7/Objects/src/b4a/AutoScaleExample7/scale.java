package b4a.AutoScaleExample7;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class scale {
private static scale mostCurrent = new scale();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static double _rate = 0;
public static double _cscalex = 0;
public static double _cscaley = 0;
public static double _cscaleds = 0;
public static int _crefwidth = 0;
public static int _crefheight = 0;
public static double _crefscale = 0;
public b4a.AutoScaleExample7.main _main = null;
public b4a.AutoScaleExample7.setup _setup = null;
public b4a.AutoScaleExample7.about _about = null;
public b4a.AutoScaleExample7.dbwebview _dbwebview = null;
public b4a.AutoScaleExample7.dbutils _dbutils = null;
public b4a.AutoScaleExample7.dbscrollview _dbscrollview = null;
public b4a.AutoScaleExample7.keyboard _keyboard = null;
public b4a.AutoScaleExample7.listview _listview = null;
public b4a.AutoScaleExample7.calculator _calculator = null;
public b4a.AutoScaleExample7.calculator1 _calculator1 = null;
public b4a.AutoScaleExample7.positioning _positioning = null;
public static int  _bottom(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
 //BA.debugLineNum = 663;BA.debugLine="Public Sub Bottom(v As View) As Int";
 //BA.debugLineNum = 664;BA.debugLine="Return v.Top + v.Height";
if (true) return (int) (_v.getTop()+_v.getHeight());
 //BA.debugLineNum = 665;BA.debugLine="End Sub";
return 0;
}
public static float  _getdevicephysicalsize(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.keywords.LayoutValues _lv = null;
 //BA.debugLineNum = 154;BA.debugLine="Public Sub GetDevicePhysicalSize As Float";
 //BA.debugLineNum = 155;BA.debugLine="Dim lv As LayoutValues";
_lv = new anywheresoftware.b4a.keywords.LayoutValues();
 //BA.debugLineNum = 157;BA.debugLine="lv = GetDeviceLayoutValues";
_lv = anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(_ba);
 //BA.debugLineNum = 158;BA.debugLine="Return Sqrt(Power(lv.Height / lv.Scale / 160, 2)";
if (true) return (float) (anywheresoftware.b4a.keywords.Common.Sqrt(anywheresoftware.b4a.keywords.Common.Power(_lv.Height/(double)_lv.Scale/(double)160,2)+anywheresoftware.b4a.keywords.Common.Power(_lv.Width/(double)_lv.Scale/(double)160,2)));
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return 0f;
}
public static Object  _getparent(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
anywheresoftware.b4j.object.JavaObject _jobj = null;
 //BA.debugLineNum = 709;BA.debugLine="Sub GetParent(v As View) As Object";
 //BA.debugLineNum = 710;BA.debugLine="Dim jobj = v As JavaObject";
_jobj = new anywheresoftware.b4j.object.JavaObject();
_jobj.setObject((java.lang.Object)(_v.getObject()));
 //BA.debugLineNum = 711;BA.debugLine="Return jobj.RunMethod(\"getParent\", Null)";
if (true) return _jobj.RunMethod("getParent",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 712;BA.debugLine="End Sub";
return null;
}
public static double  _getscaleds(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 138;BA.debugLine="Public Sub GetScaleDS As Double";
 //BA.debugLineNum = 139;BA.debugLine="Return cScaleDS";
if (true) return _cscaleds;
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return 0;
}
public static double  _getscalex(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Public Sub GetScaleX As Double";
 //BA.debugLineNum = 78;BA.debugLine="Return cScaleX";
if (true) return _cscalex;
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return 0;
}
public static double  _getscalex_l(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 115;BA.debugLine="Public Sub GetScaleX_L As Double";
 //BA.debugLineNum = 116;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
if (_getdevicephysicalsize(_ba)<6) { 
 //BA.debugLineNum = 117;BA.debugLine="Return (100%y / (cRefWidth - 50dip) / cRefScale)";
if (true) return (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale);
 }else {
 //BA.debugLineNum = 119;BA.debugLine="Return (1 + Rate * (100%y / (cRefWidth - 50dip)";
if (true) return (1+_rate*(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale-1));
 };
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
return 0;
}
public static double  _getscalex_p(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 127;BA.debugLine="Public Sub GetScaleX_P As Double";
 //BA.debugLineNum = 128;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
if (_getdevicephysicalsize(_ba)<6) { 
 //BA.debugLineNum = 129;BA.debugLine="Return (100%y / cRefWidth / cRefScale)";
if (true) return (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)_crefwidth/(double)_crefscale);
 }else {
 //BA.debugLineNum = 131;BA.debugLine="Return (1 + Rate * (100%y / (cRefWidth - 50dip)";
if (true) return (1+_rate*(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale-1));
 };
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return 0;
}
public static double  _getscaley(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 83;BA.debugLine="Public Sub GetScaleY As Double";
 //BA.debugLineNum = 84;BA.debugLine="Return cScaleY";
if (true) return _cscaley;
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return 0;
}
public static double  _getscaley_l(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 91;BA.debugLine="Public Sub GetScaleY_L As Double";
 //BA.debugLineNum = 92;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
if (_getdevicephysicalsize(_ba)<6) { 
 //BA.debugLineNum = 93;BA.debugLine="Return (100%y / (cRefWidth - 50dip) / cRefScale)";
if (true) return (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale);
 }else {
 //BA.debugLineNum = 95;BA.debugLine="Return (1 + Rate * (100%y / (cRefWidth - 50dip)";
if (true) return (1+_rate*(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefwidth-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale-1));
 };
 //BA.debugLineNum = 97;BA.debugLine="End Sub";
return 0;
}
public static double  _getscaley_p(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 103;BA.debugLine="Public Sub GetScaleY_P As Double";
 //BA.debugLineNum = 104;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
if (_getdevicephysicalsize(_ba)<6) { 
 //BA.debugLineNum = 105;BA.debugLine="Return (100%y / (cRefHeight - 50dip) / cRefScale";
if (true) return (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale);
 }else {
 //BA.debugLineNum = 107;BA.debugLine="Return (1 + Rate * (100%y / (cRefHeight - 50dip)";
if (true) return (1+_rate*(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)(_crefheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)))/(double)_crefscale-1));
 };
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return 0;
}
public static String  _horizontalcenter(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
 //BA.debugLineNum = 497;BA.debugLine="Public Sub HorizontalCenter(v As View)";
 //BA.debugLineNum = 498;BA.debugLine="v.Left = (100%x - v.Width) / 2";
_v.setLeft((int) ((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-_v.getWidth())/(double)2));
 //BA.debugLineNum = 499;BA.debugLine="End Sub";
return "";
}
public static String  _horizontalcenter2(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.ConcreteViewWrapper _vleft,anywheresoftware.b4a.objects.ConcreteViewWrapper _vright) throws Exception{
 //BA.debugLineNum = 503;BA.debugLine="Public Sub HorizontalCenter2(v As View, vLeft As V";
 //BA.debugLineNum = 504;BA.debugLine="v.Left = vLeft.Left + vLeft.Width + (vRight.Left";
_v.setLeft((int) (_vleft.getLeft()+_vleft.getWidth()+(_vright.getLeft()-(_vleft.getLeft()+_vleft.getWidth())-_v.getWidth())/(double)2));
 //BA.debugLineNum = 505;BA.debugLine="If IsActivity(v) Then";
if (_isactivity(_ba,_v)) { 
 //BA.debugLineNum = 506;BA.debugLine="ToastMessageShow(\"The view is an Activity !\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("The view is an Activity !"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 507;BA.debugLine="Return";
if (true) return "";
 }else {
 //BA.debugLineNum = 509;BA.debugLine="If IsActivity(vLeft) Then";
if (_isactivity(_ba,_vleft)) { 
 //BA.debugLineNum = 510;BA.debugLine="If IsActivity(vRight) Then";
if (_isactivity(_ba,_vright)) { 
 //BA.debugLineNum = 511;BA.debugLine="v.Left = (100%x - v.Width) / 2";
_v.setLeft((int) ((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-_v.getWidth())/(double)2));
 }else {
 //BA.debugLineNum = 513;BA.debugLine="v.Left = (vRight.Left - v.Width) / 2";
_v.setLeft((int) ((_vright.getLeft()-_v.getWidth())/(double)2));
 };
 }else {
 //BA.debugLineNum = 516;BA.debugLine="If IsActivity(vRight) Then";
if (_isactivity(_ba,_vright)) { 
 //BA.debugLineNum = 517;BA.debugLine="v.Left = vLeft.Left + vLeft.Width + (100%x - (";
_v.setLeft((int) (_vleft.getLeft()+_vleft.getWidth()+(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-(_vleft.getLeft()+_vleft.getWidth())-_v.getWidth())/(double)2));
 }else {
 //BA.debugLineNum = 519;BA.debugLine="v.Left = vLeft.Left + vLeft.Width + (vRight.Le";
_v.setLeft((int) (_vleft.getLeft()+_vleft.getWidth()+(_vright.getLeft()-(_vleft.getLeft()+_vleft.getWidth())-_v.getWidth())/(double)2));
 };
 };
 };
 //BA.debugLineNum = 523;BA.debugLine="End Sub";
return "";
}
public static String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
double _devicescale = 0;
 //BA.debugLineNum = 35;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 36;BA.debugLine="Dim DeviceScale As Double";
_devicescale = 0;
 //BA.debugLineNum = 37;BA.debugLine="DeviceScale = 100dip / 100";
_devicescale = anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (100))/(double)100;
 //BA.debugLineNum = 39;BA.debugLine="If cRefHeight <> 480 Or cRefWidth <> 320 Or cRefS";
if (_crefheight!=480 || _crefwidth!=320 || _crefscale!=1) { 
 //BA.debugLineNum = 40;BA.debugLine="If 100%x > 100%y Then";
if (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)>anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)) { 
 //BA.debugLineNum = 42;BA.debugLine="cScaleX = 100%x / DeviceScale / (cRefHeight / c";
_cscalex = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)/(double)_devicescale/(double)(_crefheight/(double)_crefscale);
 //BA.debugLineNum = 43;BA.debugLine="cScaleY = 100%y / DeviceScale / ((cRefWidth - 5";
_cscaley = anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)_devicescale/(double)((_crefwidth-50*_crefscale)/(double)_crefscale);
 }else {
 //BA.debugLineNum = 46;BA.debugLine="cScaleX = 100%x / DeviceScale / (cRefWidth / cR";
_cscalex = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)/(double)_devicescale/(double)(_crefwidth/(double)_crefscale);
 //BA.debugLineNum = 47;BA.debugLine="cScaleY = 100%y / DeviceScale / ((cRefHeight -";
_cscaley = anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)_devicescale/(double)((_crefheight-50*_crefscale)/(double)_crefscale);
 };
 }else {
 //BA.debugLineNum = 50;BA.debugLine="If GetDevicePhysicalSize < 6 Then";
if (_getdevicephysicalsize(_ba)<6) { 
 //BA.debugLineNum = 51;BA.debugLine="If 100%x > 100%y Then";
if (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)>anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)) { 
 //BA.debugLineNum = 53;BA.debugLine="cScaleX = 100%x / DeviceScale / (cRefHeight /";
_cscalex = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)/(double)_devicescale/(double)(_crefheight/(double)_crefscale);
 //BA.debugLineNum = 54;BA.debugLine="cScaleY = 100%y / DeviceScale / ((cRefWidth -";
_cscaley = anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)_devicescale/(double)((_crefwidth-50*_crefscale)/(double)_crefscale);
 }else {
 //BA.debugLineNum = 57;BA.debugLine="cScaleX = 100%x / DeviceScale / (cRefWidth / c";
_cscalex = anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)/(double)_devicescale/(double)(_crefwidth/(double)_crefscale);
 //BA.debugLineNum = 58;BA.debugLine="cScaleY = 100%y / DeviceScale / ((cRefHeight -";
_cscaley = anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)_devicescale/(double)((_crefheight-50*_crefscale)/(double)_crefscale);
 };
 }else {
 //BA.debugLineNum = 61;BA.debugLine="If 100%x > 100%y Then";
if (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)>anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)) { 
 //BA.debugLineNum = 63;BA.debugLine="cScaleX = 1 + Rate * (100%x / DeviceScale / (c";
_cscalex = 1+_rate*(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)/(double)_devicescale/(double)(_crefheight/(double)_crefscale)-1);
 //BA.debugLineNum = 64;BA.debugLine="cScaleY = 1 + Rate * (100%y / DeviceScale / ((";
_cscaley = 1+_rate*(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)_devicescale/(double)((_crefwidth-50*_crefscale)/(double)_crefscale)-1);
 }else {
 //BA.debugLineNum = 67;BA.debugLine="cScaleX = 1 + Rate * (100%x / DeviceScale / (c";
_cscalex = 1+_rate*(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)/(double)_devicescale/(double)(_crefwidth/(double)_crefscale)-1);
 //BA.debugLineNum = 68;BA.debugLine="cScaleY = 1 + Rate * (100%y / DeviceScale / ((";
_cscaley = 1+_rate*(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)/(double)_devicescale/(double)((_crefheight-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))*_crefscale)/(double)_crefscale)-1);
 };
 };
 //BA.debugLineNum = 71;BA.debugLine="cScaleDS = 1 + Rate * ((100%x + 100%y) / DeviceS";
_cscaleds = 1+_rate*((anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba))/(double)_devicescale/(double)((_crefwidth+_crefheight-50*_crefscale)/(double)_crefscale)-1);
 };
 //BA.debugLineNum = 73;BA.debugLine="End Sub";
return "";
}
public static boolean  _isactivity(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
Object _obj = null;
 //BA.debugLineNum = 685;BA.debugLine="Public Sub IsActivity(v As View) As Boolean";
 //BA.debugLineNum = 686;BA.debugLine="Dim obj As Object";
_obj = new Object();
 //BA.debugLineNum = 687;BA.debugLine="obj = GetParent(v)";
_obj = _getparent(_ba,_v);
 //BA.debugLineNum = 688;BA.debugLine="If GetType(obj) = \"android.widget.FrameLayout\" Th";
if ((anywheresoftware.b4a.keywords.Common.GetType(_obj)).equals("android.widget.FrameLayout")) { 
 //BA.debugLineNum = 689;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 691;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 693;BA.debugLine="End Sub";
return false;
}
public static boolean  _ispanel(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
Object _obj = null;
 //BA.debugLineNum = 669;BA.debugLine="Public Sub IsPanel(v As View) As Boolean";
 //BA.debugLineNum = 670;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.BALayout\" T";
if ((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.BALayout")) { 
 //BA.debugLineNum = 671;BA.debugLine="Dim obj As Object";
_obj = new Object();
 //BA.debugLineNum = 672;BA.debugLine="obj = GetParent(v)";
_obj = _getparent(_ba,_v);
 //BA.debugLineNum = 673;BA.debugLine="If GetType(obj) = \"android.widget.FrameLayout\" T";
if ((anywheresoftware.b4a.keywords.Common.GetType(_obj)).equals("android.widget.FrameLayout")) { 
 //BA.debugLineNum = 674;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 }else {
 //BA.debugLineNum = 676;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 }else {
 //BA.debugLineNum = 679;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 681;BA.debugLine="End Sub";
return false;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 26;BA.debugLine="Public Rate As Double";
_rate = 0;
 //BA.debugLineNum = 27;BA.debugLine="Rate = 0.3 'value between 0 to 1.";
_rate = 0.3;
 //BA.debugLineNum = 28;BA.debugLine="Private cScaleX, cScaleY, cScaleDS As Double";
_cscalex = 0;
_cscaley = 0;
_cscaleds = 0;
 //BA.debugLineNum = 29;BA.debugLine="Private cRefWidth = 320 As Int";
_crefwidth = (int) (320);
 //BA.debugLineNum = 30;BA.debugLine="Private cRefHeight = 480 As Int";
_crefheight = (int) (480);
 //BA.debugLineNum = 31;BA.debugLine="Private cRefScale = 1 As Double";
_crefscale = 1;
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static int  _right(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
 //BA.debugLineNum = 658;BA.debugLine="Public Sub Right(v As View) As Int";
 //BA.debugLineNum = 659;BA.debugLine="Return v.Left + v.Width";
if (true) return (int) (_v.getLeft()+_v.getWidth());
 //BA.debugLineNum = 660;BA.debugLine="End Sub";
return 0;
}
public static String  _scaleall(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _pnl,boolean _firsttime) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
 //BA.debugLineNum = 271;BA.debugLine="Public Sub ScaleAll(pnl As Panel, FirstTime As Boo";
 //BA.debugLineNum = 272;BA.debugLine="Dim I As Int";
_i = 0;
 //BA.debugLineNum = 275;BA.debugLine="If IsPanel(pnl) And FirstTime = True Then";
if (_ispanel(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_pnl.getObject()))) && _firsttime==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 277;BA.debugLine="ScaleView(pnl)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_pnl.getObject())));
 }else {
 //BA.debugLineNum = 279;BA.debugLine="For I = 0 To pnl.NumberOfViews - 1";
{
final int step5 = 1;
final int limit5 = (int) (_pnl.getNumberOfViews()-1);
_i = (int) (0) ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
 //BA.debugLineNum = 280;BA.debugLine="Dim v As View";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
 //BA.debugLineNum = 281;BA.debugLine="v = pnl.GetView(I)";
_v = _pnl.GetView(_i);
 //BA.debugLineNum = 282;BA.debugLine="ScaleView(v)";
_scaleview(_ba,_v);
 }
};
 };
 //BA.debugLineNum = 285;BA.debugLine="End Sub";
return "";
}
public static String  _scaleallds(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _pnl,boolean _firsttime) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
 //BA.debugLineNum = 371;BA.debugLine="Public Sub ScaleAllDS(pnl As Panel, FirstTime As B";
 //BA.debugLineNum = 372;BA.debugLine="Dim I As Int";
_i = 0;
 //BA.debugLineNum = 375;BA.debugLine="If IsPanel(pnl) AND FirstTime = True Then";
if (_ispanel(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_pnl.getObject()))) && _firsttime==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 377;BA.debugLine="ScaleViewDS(pnl)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_pnl.getObject())));
 }else {
 //BA.debugLineNum = 379;BA.debugLine="For I = 0 To pnl.NumberOfViews - 1";
{
final int step5 = 1;
final int limit5 = (int) (_pnl.getNumberOfViews()-1);
_i = (int) (0) ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
 //BA.debugLineNum = 380;BA.debugLine="Dim v As View";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
 //BA.debugLineNum = 381;BA.debugLine="v = pnl.GetView(I)";
_v = _pnl.GetView(_i);
 //BA.debugLineNum = 382;BA.debugLine="ScaleViewDS(v)";
_scaleviewds(_ba,_v);
 }
};
 };
 //BA.debugLineNum = 385;BA.debugLine="End Sub";
return "";
}
public static String  _scaleallx(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.PanelWrapper _pnl,boolean _firsttime) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
 //BA.debugLineNum = 395;BA.debugLine="Public Sub ScaleAllX(pnl As Panel, FirstTime As Bo";
 //BA.debugLineNum = 396;BA.debugLine="Dim I As Int";
_i = 0;
 //BA.debugLineNum = 399;BA.debugLine="If IsPanel(pnl) AND FirstTime = True Then";
if (_ispanel(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_pnl.getObject()))) && _firsttime==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 401;BA.debugLine="ScaleViewX(pnl)";
_scaleviewx(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_pnl.getObject())));
 }else {
 //BA.debugLineNum = 403;BA.debugLine="For I = 0 To pnl.NumberOfViews - 1";
{
final int step5 = 1;
final int limit5 = (int) (_pnl.getNumberOfViews()-1);
_i = (int) (0) ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
 //BA.debugLineNum = 404;BA.debugLine="Dim v As View";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
 //BA.debugLineNum = 405;BA.debugLine="v = pnl.GetView(I)";
_v = _pnl.GetView(_i);
 //BA.debugLineNum = 406;BA.debugLine="ScaleViewX(v)";
_scaleviewx(_ba,_v);
 }
};
 };
 //BA.debugLineNum = 409;BA.debugLine="End Sub";
return "";
}
public static String  _scaleview(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _scv = null;
anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _hcv = null;
anywheresoftware.b4a.objects.ListViewWrapper _ltv = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spn = null;
 //BA.debugLineNum = 164;BA.debugLine="Public Sub ScaleView(v As View)";
 //BA.debugLineNum = 165;BA.debugLine="If IsActivity(v) Then";
if (_isactivity(_ba,_v)) { 
 //BA.debugLineNum = 166;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 169;BA.debugLine="v.Left = v.Left * cScaleX";
_v.setLeft((int) (_v.getLeft()*_cscalex));
 //BA.debugLineNum = 170;BA.debugLine="v.Top = v.Top * cScaleY";
_v.setTop((int) (_v.getTop()*_cscaley));
 //BA.debugLineNum = 171;BA.debugLine="If IsPanel(v) Then";
if (_ispanel(_ba,_v)) { 
 //BA.debugLineNum = 172;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 173;BA.debugLine="pnl = v";
_pnl.setObject((android.view.ViewGroup)(_v.getObject()));
 //BA.debugLineNum = 174;BA.debugLine="If pnl.Background Is BitmapDrawable Then";
if (_pnl.getBackground() instanceof android.graphics.drawable.BitmapDrawable) { 
 //BA.debugLineNum = 177;BA.debugLine="If v.Width > 0 Then";
if (_v.getWidth()>0) { 
 //BA.debugLineNum = 178;BA.debugLine="v.Width = v.Width * Min(cScaleX, cScaleY)";
_v.setWidth((int) (_v.getWidth()*anywheresoftware.b4a.keywords.Common.Min(_cscalex,_cscaley)));
 };
 //BA.debugLineNum = 180;BA.debugLine="If v.Height > 0 Then";
if (_v.getHeight()>0) { 
 //BA.debugLineNum = 181;BA.debugLine="v.Height = v.Height * Min(cScaleX, cScaleY)";
_v.setHeight((int) (_v.getHeight()*anywheresoftware.b4a.keywords.Common.Min(_cscalex,_cscaley)));
 };
 }else {
 //BA.debugLineNum = 184;BA.debugLine="If v.Width > 0 Then";
if (_v.getWidth()>0) { 
 //BA.debugLineNum = 185;BA.debugLine="v.Width = v.Width * cScaleX";
_v.setWidth((int) (_v.getWidth()*_cscalex));
 };
 //BA.debugLineNum = 187;BA.debugLine="If v.Height > 0 Then";
if (_v.getHeight()>0) { 
 //BA.debugLineNum = 188;BA.debugLine="v.Height = v.Height * cScaleY";
_v.setHeight((int) (_v.getHeight()*_cscaley));
 };
 };
 //BA.debugLineNum = 191;BA.debugLine="ScaleAll(pnl, False)";
_scaleall(_ba,_pnl,anywheresoftware.b4a.keywords.Common.False);
 }else if(_v.getObjectOrNull() instanceof android.widget.ImageView) { 
 //BA.debugLineNum = 195;BA.debugLine="If v.Width > 0 Then";
if (_v.getWidth()>0) { 
 //BA.debugLineNum = 196;BA.debugLine="v.Width = v.Width * Min(cScaleX, cScaleY)";
_v.setWidth((int) (_v.getWidth()*anywheresoftware.b4a.keywords.Common.Min(_cscalex,_cscaley)));
 };
 //BA.debugLineNum = 198;BA.debugLine="If v.Height > 0 Then";
if (_v.getHeight()>0) { 
 //BA.debugLineNum = 199;BA.debugLine="v.Height = v.Height * Min(cScaleX, cScaleY)";
_v.setHeight((int) (_v.getHeight()*anywheresoftware.b4a.keywords.Common.Min(_cscalex,_cscaley)));
 };
 }else {
 //BA.debugLineNum = 202;BA.debugLine="If v.Width > 0 Then";
if (_v.getWidth()>0) { 
 //BA.debugLineNum = 203;BA.debugLine="v.Width = v.Width * cScaleX";
_v.setWidth((int) (_v.getWidth()*_cscalex));
 };
 //BA.debugLineNum = 205;BA.debugLine="If v.Height > 0 Then";
if (_v.getHeight()>0) { 
 //BA.debugLineNum = 206;BA.debugLine="v.Height = v.Height * cScaleY";
_v.setHeight((int) (_v.getHeight()*_cscaley));
 };
 };
 //BA.debugLineNum = 210;BA.debugLine="If v Is Label Then 'this will catch ALL views wit";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
 //BA.debugLineNum = 211;BA.debugLine="Dim lbl As Label = v";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl.setObject((android.widget.TextView)(_v.getObject()));
 //BA.debugLineNum = 212;BA.debugLine="lbl.TextSize = lbl.TextSize * cScaleX";
_lbl.setTextSize((float) (_lbl.getTextSize()*_cscalex));
 };
 //BA.debugLineNum = 215;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Scr";
if ((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.ScrollViewWrapper$MyScrollView")) { 
 //BA.debugLineNum = 218;BA.debugLine="Dim scv As ScrollView";
_scv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 219;BA.debugLine="scv = v";
_scv.setObject((android.widget.ScrollView)(_v.getObject()));
 //BA.debugLineNum = 220;BA.debugLine="ScaleAll(scv.Panel, False)";
_scaleall(_ba,_scv.getPanel(),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 221;BA.debugLine="scv.Panel.Height = scv.Panel.Height * cScaleY";
_scv.getPanel().setHeight((int) (_scv.getPanel().getHeight()*_cscaley));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper$MyHScrollView")) { 
 //BA.debugLineNum = 225;BA.debugLine="Dim hcv As HorizontalScrollView";
_hcv = new anywheresoftware.b4a.objects.HorizontalScrollViewWrapper();
 //BA.debugLineNum = 226;BA.debugLine="hcv = v";
_hcv.setObject((android.widget.HorizontalScrollView)(_v.getObject()));
 //BA.debugLineNum = 227;BA.debugLine="ScaleAll(hcv.Panel, False)";
_scaleall(_ba,_hcv.getPanel(),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 228;BA.debugLine="hcv.Panel.Width = hcv.Panel.Width * cScaleX";
_hcv.getPanel().setWidth((int) (_hcv.getPanel().getWidth()*_cscalex));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("flm.b4a.scrollview2d.ScrollView2DWrapper$MyScrollView")) { 
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.ListViewWrapper$SimpleListView")) { 
 //BA.debugLineNum = 240;BA.debugLine="Dim ltv As ListView";
_ltv = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 241;BA.debugLine="ltv = v";
_ltv.setObject((anywheresoftware.b4a.objects.ListViewWrapper.SimpleListView)(_v.getObject()));
 //BA.debugLineNum = 242;BA.debugLine="ScaleView(ltv.SingleLineLayout.Label)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getSingleLineLayout().Label.getObject())));
 //BA.debugLineNum = 243;BA.debugLine="ltv.SingleLineLayout.ItemHeight = ltv.SingleLine";
_ltv.getSingleLineLayout().setItemHeight((int) (_ltv.getSingleLineLayout().getItemHeight()*_cscaley));
 //BA.debugLineNum = 245;BA.debugLine="ScaleView(ltv.TwoLinesLayout.Label)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesLayout().Label.getObject())));
 //BA.debugLineNum = 246;BA.debugLine="ScaleView(ltv.TwoLinesLayout.SecondLabel)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesLayout().SecondLabel.getObject())));
 //BA.debugLineNum = 247;BA.debugLine="ltv.TwoLinesLayout.ItemHeight = ltv.TwoLinesLayo";
_ltv.getTwoLinesLayout().setItemHeight((int) (_ltv.getTwoLinesLayout().getItemHeight()*_cscaley));
 //BA.debugLineNum = 249;BA.debugLine="ScaleView(ltv.TwoLinesAndBitmap.Label)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().Label.getObject())));
 //BA.debugLineNum = 250;BA.debugLine="ScaleView(ltv.TwoLinesAndBitmap.SecondLabel)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().SecondLabel.getObject())));
 //BA.debugLineNum = 251;BA.debugLine="ScaleView(ltv.TwoLinesAndBitmap.ImageView)";
_scaleview(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().ImageView.getObject())));
 //BA.debugLineNum = 252;BA.debugLine="ltv.TwoLinesAndBitmap.ItemHeight = ltv.TwoLinesA";
_ltv.getTwoLinesAndBitmap().setItemHeight((int) (_ltv.getTwoLinesAndBitmap().getItemHeight()*_cscaley));
 //BA.debugLineNum = 254;BA.debugLine="ltv.TwoLinesAndBitmap.ImageView.Top = (ltv.TwoLi";
_ltv.getTwoLinesAndBitmap().ImageView.setTop((int) ((_ltv.getTwoLinesAndBitmap().getItemHeight()-_ltv.getTwoLinesAndBitmap().ImageView.getHeight())/(double)2));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner")) { 
 //BA.debugLineNum = 258;BA.debugLine="Dim spn As Spinner";
_spn = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 259;BA.debugLine="spn = v";
_spn.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
 //BA.debugLineNum = 260;BA.debugLine="spn.TextSize = spn.TextSize * cScaleX";
_spn.setTextSize((float) (_spn.getTextSize()*_cscalex));
 };
 //BA.debugLineNum = 262;BA.debugLine="End Sub";
return "";
}
public static String  _scaleviewds(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _scv = null;
anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _hcv = null;
anywheresoftware.b4a.objects.ListViewWrapper _ltv = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spn = null;
 //BA.debugLineNum = 290;BA.debugLine="Public Sub ScaleViewDS(v As View)";
 //BA.debugLineNum = 291;BA.debugLine="If IsActivity(v) Then";
if (_isactivity(_ba,_v)) { 
 //BA.debugLineNum = 292;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 295;BA.debugLine="v.Left = v.Left * cScaleDS";
_v.setLeft((int) (_v.getLeft()*_cscaleds));
 //BA.debugLineNum = 296;BA.debugLine="v.Top = v.Top * cScaleDS";
_v.setTop((int) (_v.getTop()*_cscaleds));
 //BA.debugLineNum = 297;BA.debugLine="If v.Width > 0 Then";
if (_v.getWidth()>0) { 
 //BA.debugLineNum = 298;BA.debugLine="v.Width = v.Width * cScaleDS";
_v.setWidth((int) (_v.getWidth()*_cscaleds));
 };
 //BA.debugLineNum = 300;BA.debugLine="If v.Height > 0 Then";
if (_v.getHeight()>0) { 
 //BA.debugLineNum = 301;BA.debugLine="v.Height = v.Height * cScaleDS";
_v.setHeight((int) (_v.getHeight()*_cscaleds));
 };
 //BA.debugLineNum = 304;BA.debugLine="If IsPanel(v) Then";
if (_ispanel(_ba,_v)) { 
 //BA.debugLineNum = 305;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 306;BA.debugLine="pnl = v";
_pnl.setObject((android.view.ViewGroup)(_v.getObject()));
 //BA.debugLineNum = 307;BA.debugLine="ScaleAllDS(pnl, False)";
_scaleallds(_ba,_pnl,anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 310;BA.debugLine="If v Is Label Then 'this will catch ALL views wit";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
 //BA.debugLineNum = 311;BA.debugLine="Dim lbl As Label = v";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl.setObject((android.widget.TextView)(_v.getObject()));
 //BA.debugLineNum = 312;BA.debugLine="lbl.TextSize = lbl.TextSize * cScaleDS";
_lbl.setTextSize((float) (_lbl.getTextSize()*_cscaleds));
 };
 //BA.debugLineNum = 315;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Scr";
if ((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.ScrollViewWrapper$MyScrollView")) { 
 //BA.debugLineNum = 318;BA.debugLine="Dim scv As ScrollView";
_scv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 319;BA.debugLine="scv = v";
_scv.setObject((android.widget.ScrollView)(_v.getObject()));
 //BA.debugLineNum = 320;BA.debugLine="ScaleAllDS(scv.Panel, False)";
_scaleallds(_ba,_scv.getPanel(),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 321;BA.debugLine="scv.Panel.Height = scv.Panel.Height * cScaleDS";
_scv.getPanel().setHeight((int) (_scv.getPanel().getHeight()*_cscaleds));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper$MyHScrollView")) { 
 //BA.debugLineNum = 325;BA.debugLine="Dim hcv As HorizontalScrollView";
_hcv = new anywheresoftware.b4a.objects.HorizontalScrollViewWrapper();
 //BA.debugLineNum = 326;BA.debugLine="hcv = v";
_hcv.setObject((android.widget.HorizontalScrollView)(_v.getObject()));
 //BA.debugLineNum = 327;BA.debugLine="ScaleAllDS(hcv.Panel, False)";
_scaleallds(_ba,_hcv.getPanel(),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 328;BA.debugLine="hcv.Panel.Width = hcv.Panel.Width * cScaleDS";
_hcv.getPanel().setWidth((int) (_hcv.getPanel().getWidth()*_cscaleds));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("flm.b4a.scrollview2d.ScrollView2DWrapper$MyScrollView")) { 
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.ListViewWrapper$SimpleListView")) { 
 //BA.debugLineNum = 340;BA.debugLine="Dim ltv As ListView";
_ltv = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 341;BA.debugLine="ltv = v";
_ltv.setObject((anywheresoftware.b4a.objects.ListViewWrapper.SimpleListView)(_v.getObject()));
 //BA.debugLineNum = 342;BA.debugLine="ScaleViewDS(ltv.SingleLineLayout.Label)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getSingleLineLayout().Label.getObject())));
 //BA.debugLineNum = 343;BA.debugLine="ltv.SingleLineLayout.ItemHeight = ltv.SingleLine";
_ltv.getSingleLineLayout().setItemHeight((int) (_ltv.getSingleLineLayout().getItemHeight()*_cscaleds));
 //BA.debugLineNum = 345;BA.debugLine="ScaleViewDS(ltv.TwoLinesLayout.Label)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesLayout().Label.getObject())));
 //BA.debugLineNum = 346;BA.debugLine="ScaleViewDS(ltv.TwoLinesLayout.SecondLabel)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesLayout().SecondLabel.getObject())));
 //BA.debugLineNum = 347;BA.debugLine="ltv.TwoLinesLayout.ItemHeight = ltv.TwoLinesLayo";
_ltv.getTwoLinesLayout().setItemHeight((int) (_ltv.getTwoLinesLayout().getItemHeight()*_cscaleds));
 //BA.debugLineNum = 349;BA.debugLine="ScaleViewDS(ltv.TwoLinesAndBitmap.Label)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().Label.getObject())));
 //BA.debugLineNum = 350;BA.debugLine="ScaleViewDS(ltv.TwoLinesAndBitmap.SecondLabel)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().SecondLabel.getObject())));
 //BA.debugLineNum = 351;BA.debugLine="ScaleViewDS(ltv.TwoLinesAndBitmap.ImageView)";
_scaleviewds(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().ImageView.getObject())));
 //BA.debugLineNum = 352;BA.debugLine="ltv.TwoLinesAndBitmap.ItemHeight = ltv.TwoLinesA";
_ltv.getTwoLinesAndBitmap().setItemHeight((int) (_ltv.getTwoLinesAndBitmap().getItemHeight()*_cscaleds));
 //BA.debugLineNum = 354;BA.debugLine="ltv.TwoLinesAndBitmap.ImageView.Top = (ltv.TwoLi";
_ltv.getTwoLinesAndBitmap().ImageView.setTop((int) ((_ltv.getTwoLinesAndBitmap().getItemHeight()-_ltv.getTwoLinesAndBitmap().ImageView.getHeight())/(double)2));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner")) { 
 //BA.debugLineNum = 358;BA.debugLine="Dim spn As Spinner";
_spn = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 359;BA.debugLine="spn = v";
_spn.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
 //BA.debugLineNum = 360;BA.debugLine="spn.TextSize = spn.TextSize * cScaleDS";
_spn.setTextSize((float) (_spn.getTextSize()*_cscaleds));
 };
 //BA.debugLineNum = 362;BA.debugLine="End Sub";
return "";
}
public static String  _scaleviewx(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _scv = null;
anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _hcv = null;
anywheresoftware.b4a.objects.ListViewWrapper _ltv = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spn = null;
 //BA.debugLineNum = 415;BA.debugLine="Public Sub ScaleViewX(v As View)";
 //BA.debugLineNum = 416;BA.debugLine="If IsActivity(v) Then";
if (_isactivity(_ba,_v)) { 
 //BA.debugLineNum = 417;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 420;BA.debugLine="v.Left = v.Left * cScaleX";
_v.setLeft((int) (_v.getLeft()*_cscalex));
 //BA.debugLineNum = 421;BA.debugLine="v.Top = v.Top * cScaleX";
_v.setTop((int) (_v.getTop()*_cscalex));
 //BA.debugLineNum = 423;BA.debugLine="If IsPanel(v) Then";
if (_ispanel(_ba,_v)) { 
 //BA.debugLineNum = 424;BA.debugLine="Dim pnl As Panel";
_pnl = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 425;BA.debugLine="pnl = v";
_pnl.setObject((android.view.ViewGroup)(_v.getObject()));
 //BA.debugLineNum = 426;BA.debugLine="If v.Width > 0 Then";
if (_v.getWidth()>0) { 
 //BA.debugLineNum = 427;BA.debugLine="v.Width = v.Width * cScaleX";
_v.setWidth((int) (_v.getWidth()*_cscalex));
 };
 //BA.debugLineNum = 429;BA.debugLine="If v.Height > 0 Then";
if (_v.getHeight()>0) { 
 //BA.debugLineNum = 430;BA.debugLine="v.Height = v.Height * cScaleX";
_v.setHeight((int) (_v.getHeight()*_cscalex));
 };
 //BA.debugLineNum = 432;BA.debugLine="ScaleAllX(pnl, False)";
_scaleallx(_ba,_pnl,anywheresoftware.b4a.keywords.Common.False);
 }else {
 //BA.debugLineNum = 434;BA.debugLine="If v.Width > 0 Then";
if (_v.getWidth()>0) { 
 //BA.debugLineNum = 435;BA.debugLine="v.Width = v.Width * cScaleX";
_v.setWidth((int) (_v.getWidth()*_cscalex));
 };
 //BA.debugLineNum = 437;BA.debugLine="If v.Height > 0 Then";
if (_v.getHeight()>0) { 
 //BA.debugLineNum = 438;BA.debugLine="v.Height = v.Height * cScaleX";
_v.setHeight((int) (_v.getHeight()*_cscalex));
 };
 };
 //BA.debugLineNum = 442;BA.debugLine="If v Is Label Then 'this will catch ALL views wit";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
 //BA.debugLineNum = 443;BA.debugLine="Dim lbl As Label = v";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
_lbl.setObject((android.widget.TextView)(_v.getObject()));
 //BA.debugLineNum = 444;BA.debugLine="lbl.TextSize = lbl.TextSize * cScaleX";
_lbl.setTextSize((float) (_lbl.getTextSize()*_cscalex));
 };
 //BA.debugLineNum = 447;BA.debugLine="If GetType(v) = \"anywheresoftware.b4a.objects.Scr";
if ((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.ScrollViewWrapper$MyScrollView")) { 
 //BA.debugLineNum = 450;BA.debugLine="Dim scv As ScrollView";
_scv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 451;BA.debugLine="scv = v";
_scv.setObject((android.widget.ScrollView)(_v.getObject()));
 //BA.debugLineNum = 452;BA.debugLine="ScaleAllX(scv.Panel, False)";
_scaleallx(_ba,_scv.getPanel(),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 453;BA.debugLine="scv.Panel.Height = scv.Panel.Height * cScaleX";
_scv.getPanel().setHeight((int) (_scv.getPanel().getHeight()*_cscalex));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper$MyHScrollView")) { 
 //BA.debugLineNum = 457;BA.debugLine="Dim hcv As HorizontalScrollView";
_hcv = new anywheresoftware.b4a.objects.HorizontalScrollViewWrapper();
 //BA.debugLineNum = 458;BA.debugLine="hcv = v";
_hcv.setObject((android.widget.HorizontalScrollView)(_v.getObject()));
 //BA.debugLineNum = 459;BA.debugLine="ScaleAllX(hcv.Panel, False)";
_scaleallx(_ba,_hcv.getPanel(),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 460;BA.debugLine="hcv.Panel.Width = hcv.Panel.Width * cScaleX";
_hcv.getPanel().setWidth((int) (_hcv.getPanel().getWidth()*_cscalex));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("flm.b4a.scrollview2d.ScrollView2DWrapper$MyScrollView")) { 
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.ListViewWrapper$SimpleListView")) { 
 //BA.debugLineNum = 472;BA.debugLine="Dim ltv As ListView";
_ltv = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 473;BA.debugLine="ltv = v";
_ltv.setObject((anywheresoftware.b4a.objects.ListViewWrapper.SimpleListView)(_v.getObject()));
 //BA.debugLineNum = 474;BA.debugLine="ScaleViewX(ltv.SingleLineLayout.Label)";
_scaleviewx(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getSingleLineLayout().Label.getObject())));
 //BA.debugLineNum = 475;BA.debugLine="ltv.SingleLineLayout.ItemHeight = ltv.SingleLine";
_ltv.getSingleLineLayout().setItemHeight((int) (_ltv.getSingleLineLayout().getItemHeight()*_cscalex));
 //BA.debugLineNum = 477;BA.debugLine="ScaleViewX(ltv.TwoLinesLayout.Label)";
_scaleviewx(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesLayout().Label.getObject())));
 //BA.debugLineNum = 478;BA.debugLine="ScaleViewX(ltv.TwoLinesLayout.SecondLabel)";
_scaleviewx(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesLayout().SecondLabel.getObject())));
 //BA.debugLineNum = 479;BA.debugLine="ltv.TwoLinesLayout.ItemHeight = ltv.TwoLinesLayo";
_ltv.getTwoLinesLayout().setItemHeight((int) (_ltv.getTwoLinesLayout().getItemHeight()*_cscalex));
 //BA.debugLineNum = 481;BA.debugLine="ScaleViewX(ltv.TwoLinesAndBitmap.Label)";
_scaleviewx(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().Label.getObject())));
 //BA.debugLineNum = 482;BA.debugLine="ScaleViewX(ltv.TwoLinesAndBitmap.SecondLabel)";
_scaleviewx(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().SecondLabel.getObject())));
 //BA.debugLineNum = 483;BA.debugLine="ScaleViewX(ltv.TwoLinesAndBitmap.ImageView)";
_scaleviewx(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_ltv.getTwoLinesAndBitmap().ImageView.getObject())));
 //BA.debugLineNum = 484;BA.debugLine="ltv.TwoLinesAndBitmap.ItemHeight = ltv.TwoLinesA";
_ltv.getTwoLinesAndBitmap().setItemHeight((int) (_ltv.getTwoLinesAndBitmap().getItemHeight()*_cscalex));
 //BA.debugLineNum = 486;BA.debugLine="ltv.TwoLinesAndBitmap.ImageView.Top = (ltv.TwoLi";
_ltv.getTwoLinesAndBitmap().ImageView.setTop((int) ((_ltv.getTwoLinesAndBitmap().getItemHeight()-_ltv.getTwoLinesAndBitmap().ImageView.getHeight())/(double)2));
 }else if((anywheresoftware.b4a.keywords.Common.GetType((Object)(_v.getObject()))).equals("anywheresoftware.b4a.objects.SpinnerWrapper$B4ASpinner")) { 
 //BA.debugLineNum = 490;BA.debugLine="Dim spn As Spinner";
_spn = new anywheresoftware.b4a.objects.SpinnerWrapper();
 //BA.debugLineNum = 491;BA.debugLine="spn = v";
_spn.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
 //BA.debugLineNum = 492;BA.debugLine="spn.TextSize = spn.TextSize * cScaleX";
_spn.setTextSize((float) (_spn.getTextSize()*_cscalex));
 };
 //BA.debugLineNum = 494;BA.debugLine="End Sub";
return "";
}
public static String  _setbottom(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,int _ybottom) throws Exception{
 //BA.debugLineNum = 561;BA.debugLine="Sub SetBottom(v As View, yBottom As Int)";
 //BA.debugLineNum = 562;BA.debugLine="v.Top = yBottom - v.Height";
_v.setTop((int) (_ybottom-_v.getHeight()));
 //BA.debugLineNum = 563;BA.debugLine="End Sub";
return "";
}
public static String  _setleftandright(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,int _xleft,int _xright) throws Exception{
 //BA.debugLineNum = 567;BA.debugLine="Public Sub SetLeftAndRight(v As View, xLeft As Int";
 //BA.debugLineNum = 569;BA.debugLine="v.Left = Min(xLeft, xRight)";
_v.setLeft((int) (anywheresoftware.b4a.keywords.Common.Min(_xleft,_xright)));
 //BA.debugLineNum = 570;BA.debugLine="v.Width = Max(xLeft, xRight) - v.Left";
_v.setWidth((int) (anywheresoftware.b4a.keywords.Common.Max(_xleft,_xright)-_v.getLeft()));
 //BA.debugLineNum = 571;BA.debugLine="End Sub";
return "";
}
public static String  _setleftandright2(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.ConcreteViewWrapper _vleft,int _dxl,anywheresoftware.b4a.objects.ConcreteViewWrapper _vright,int _dxr) throws Exception{
anywheresoftware.b4a.objects.ConcreteViewWrapper _v1 = null;
 //BA.debugLineNum = 577;BA.debugLine="Public Sub SetLeftAndRight2(v As View, vLeft As Vi";
 //BA.debugLineNum = 579;BA.debugLine="If IsActivity(v) Then";
if (_isactivity(_ba,_v)) { 
 //BA.debugLineNum = 580;BA.debugLine="ToastMessageShow(\"The view is an Activity !\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("The view is an Activity !"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 581;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 585;BA.debugLine="If IsActivity(vLeft) = False AND IsActivity(vRigh";
if (_isactivity(_ba,_vleft)==anywheresoftware.b4a.keywords.Common.False && _isactivity(_ba,_vright)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 586;BA.debugLine="If vLeft.Left > vRight.Left Then";
if (_vleft.getLeft()>_vright.getLeft()) { 
 //BA.debugLineNum = 587;BA.debugLine="Dim v1 As View";
_v1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
 //BA.debugLineNum = 588;BA.debugLine="v1 = vLeft";
_v1 = _vleft;
 //BA.debugLineNum = 589;BA.debugLine="vLeft = vRight";
_vleft = _vright;
 //BA.debugLineNum = 590;BA.debugLine="vRight = v1";
_vright = _v1;
 };
 };
 //BA.debugLineNum = 594;BA.debugLine="If IsActivity(vLeft) Then";
if (_isactivity(_ba,_vleft)) { 
 //BA.debugLineNum = 595;BA.debugLine="v.Left = dxL";
_v.setLeft(_dxl);
 //BA.debugLineNum = 596;BA.debugLine="If IsActivity(vRight) Then";
if (_isactivity(_ba,_vright)) { 
 //BA.debugLineNum = 597;BA.debugLine="v.Width = 100%x - dxL - dxR";
_v.setWidth((int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-_dxl-_dxr));
 }else {
 //BA.debugLineNum = 599;BA.debugLine="v.Width = vRight.Left - dxL - dxR";
_v.setWidth((int) (_vright.getLeft()-_dxl-_dxr));
 };
 }else {
 //BA.debugLineNum = 602;BA.debugLine="v.Left = vLeft.Left + vLeft.Width + dxL";
_v.setLeft((int) (_vleft.getLeft()+_vleft.getWidth()+_dxl));
 //BA.debugLineNum = 603;BA.debugLine="If IsActivity(vRight) Then";
if (_isactivity(_ba,_vright)) { 
 //BA.debugLineNum = 604;BA.debugLine="v.Width = 100%x - v.Left";
_v.setWidth((int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),_ba)-_v.getLeft()));
 }else {
 //BA.debugLineNum = 606;BA.debugLine="v.Width = vRight.Left - v.Left - dxR";
_v.setWidth((int) (_vright.getLeft()-_v.getLeft()-_dxr));
 };
 };
 //BA.debugLineNum = 609;BA.debugLine="End Sub";
return "";
}
public static String  _setrate(anywheresoftware.b4a.BA _ba,double _crate) throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Public Sub SetRate(cRate As Double)";
 //BA.debugLineNum = 147;BA.debugLine="Rate = cRate";
_rate = _crate;
 //BA.debugLineNum = 148;BA.debugLine="Initialize";
_initialize(_ba);
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public static String  _setreferencelayout(anywheresoftware.b4a.BA _ba,int _width,int _height,double _scale) throws Exception{
 //BA.debugLineNum = 697;BA.debugLine="Public Sub SetReferenceLayout(Width As Int, Height";
 //BA.debugLineNum = 698;BA.debugLine="If Width < Height Then";
if (_width<_height) { 
 //BA.debugLineNum = 699;BA.debugLine="cRefWidth = Width";
_crefwidth = _width;
 //BA.debugLineNum = 700;BA.debugLine="cRefHeight = Height";
_crefheight = _height;
 }else {
 //BA.debugLineNum = 702;BA.debugLine="cRefWidth = Height";
_crefwidth = _height;
 //BA.debugLineNum = 703;BA.debugLine="cRefHeight = Width";
_crefheight = _width;
 };
 //BA.debugLineNum = 705;BA.debugLine="cRefScale = Scale";
_crefscale = _scale;
 //BA.debugLineNum = 706;BA.debugLine="Initialize";
_initialize(_ba);
 //BA.debugLineNum = 707;BA.debugLine="End Sub";
return "";
}
public static String  _setright(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,int _xright) throws Exception{
 //BA.debugLineNum = 555;BA.debugLine="Sub SetRight(v As View, xRight As Int)";
 //BA.debugLineNum = 556;BA.debugLine="v.Left = xRight - v.Width";
_v.setLeft((int) (_xright-_v.getWidth()));
 //BA.debugLineNum = 557;BA.debugLine="End Sub";
return "";
}
public static String  _settopandbottom(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,int _ytop,int _ybottom) throws Exception{
 //BA.debugLineNum = 613;BA.debugLine="Public Sub SetTopAndBottom(v As View, yTop As Int,";
 //BA.debugLineNum = 615;BA.debugLine="v.Top = Min(yTop, yBottom)";
_v.setTop((int) (anywheresoftware.b4a.keywords.Common.Min(_ytop,_ybottom)));
 //BA.debugLineNum = 616;BA.debugLine="v.Height = Max(yTop, yBottom) - v.Top";
_v.setHeight((int) (anywheresoftware.b4a.keywords.Common.Max(_ytop,_ybottom)-_v.getTop()));
 //BA.debugLineNum = 617;BA.debugLine="End Sub";
return "";
}
public static String  _settopandbottom2(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.ConcreteViewWrapper _vtop,int _dyt,anywheresoftware.b4a.objects.ConcreteViewWrapper _vbottom,int _dyb) throws Exception{
anywheresoftware.b4a.objects.ConcreteViewWrapper _v1 = null;
 //BA.debugLineNum = 623;BA.debugLine="Public Sub SetTopAndBottom2(v As View, vTop As Vie";
 //BA.debugLineNum = 625;BA.debugLine="If IsActivity(v) Then";
if (_isactivity(_ba,_v)) { 
 //BA.debugLineNum = 626;BA.debugLine="ToastMessageShow(\"The view is an Activity !\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("The view is an Activity !"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 627;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 630;BA.debugLine="If IsActivity(vTop) = False AND IsActivity(vBotto";
if (_isactivity(_ba,_vtop)==anywheresoftware.b4a.keywords.Common.False && _isactivity(_ba,_vbottom)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 632;BA.debugLine="If vTop.Top > vBottom.Top Then";
if (_vtop.getTop()>_vbottom.getTop()) { 
 //BA.debugLineNum = 633;BA.debugLine="Dim v1 As View";
_v1 = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
 //BA.debugLineNum = 634;BA.debugLine="v1 = vTop";
_v1 = _vtop;
 //BA.debugLineNum = 635;BA.debugLine="vTop = vBottom";
_vtop = _vbottom;
 //BA.debugLineNum = 636;BA.debugLine="vBottom = v1";
_vbottom = _v1;
 };
 };
 //BA.debugLineNum = 640;BA.debugLine="If IsActivity(vTop) Then";
if (_isactivity(_ba,_vtop)) { 
 //BA.debugLineNum = 641;BA.debugLine="v.Top = dyT";
_v.setTop(_dyt);
 //BA.debugLineNum = 642;BA.debugLine="If IsActivity(vBottom) Then";
if (_isactivity(_ba,_vbottom)) { 
 //BA.debugLineNum = 643;BA.debugLine="v.Height = 100%y - dyT - dyB";
_v.setHeight((int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)-_dyt-_dyb));
 }else {
 //BA.debugLineNum = 645;BA.debugLine="v.Height = vBottom.Top - dyT - dyB";
_v.setHeight((int) (_vbottom.getTop()-_dyt-_dyb));
 };
 }else {
 //BA.debugLineNum = 648;BA.debugLine="v.Top = vTop.Top + vTop.Height + dyT";
_v.setTop((int) (_vtop.getTop()+_vtop.getHeight()+_dyt));
 //BA.debugLineNum = 649;BA.debugLine="If IsActivity(vBottom) Then";
if (_isactivity(_ba,_vbottom)) { 
 //BA.debugLineNum = 650;BA.debugLine="v.Height = 100%y - v.Top - dyB";
_v.setHeight((int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)-_v.getTop()-_dyb));
 }else {
 //BA.debugLineNum = 652;BA.debugLine="v.Height = vBottom.Top - v.Top - dyB";
_v.setHeight((int) (_vbottom.getTop()-_v.getTop()-_dyb));
 };
 };
 //BA.debugLineNum = 655;BA.debugLine="End Sub";
return "";
}
public static String  _verticalcenter(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v) throws Exception{
 //BA.debugLineNum = 526;BA.debugLine="Public Sub VerticalCenter(v As View)";
 //BA.debugLineNum = 527;BA.debugLine="v.Top = (100%y - v.Height) / 2";
_v.setTop((int) ((anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)-_v.getHeight())/(double)2));
 //BA.debugLineNum = 528;BA.debugLine="End Sub";
return "";
}
public static String  _verticalcenter2(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.ConcreteViewWrapper _vtop,anywheresoftware.b4a.objects.ConcreteViewWrapper _vbottom) throws Exception{
 //BA.debugLineNum = 532;BA.debugLine="Public Sub VerticalCenter2(v As View, vTop As View";
 //BA.debugLineNum = 533;BA.debugLine="If IsActivity(v) Then";
if (_isactivity(_ba,_v)) { 
 //BA.debugLineNum = 534;BA.debugLine="ToastMessageShow(\"The view is an Activity !\", Fa";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("The view is an Activity !"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 535;BA.debugLine="Return";
if (true) return "";
 }else {
 //BA.debugLineNum = 537;BA.debugLine="If IsActivity(vTop) Then";
if (_isactivity(_ba,_vtop)) { 
 //BA.debugLineNum = 538;BA.debugLine="If IsActivity(vBottom) Then";
if (_isactivity(_ba,_vbottom)) { 
 //BA.debugLineNum = 539;BA.debugLine="v.Top = (100%y - v.Height) / 2";
_v.setTop((int) ((anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)-_v.getHeight())/(double)2));
 }else {
 //BA.debugLineNum = 541;BA.debugLine="v.Top = (vBottom.Top - v.Height) / 2";
_v.setTop((int) ((_vbottom.getTop()-_v.getHeight())/(double)2));
 };
 }else {
 //BA.debugLineNum = 544;BA.debugLine="If IsActivity(vBottom) Then";
if (_isactivity(_ba,_vbottom)) { 
 //BA.debugLineNum = 545;BA.debugLine="v.Top = vTop.Top + vTop.Height + (100%y - (vTo";
_v.setTop((int) (_vtop.getTop()+_vtop.getHeight()+(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),_ba)-(_vtop.getTop()+_vtop.getHeight())-_v.getHeight())/(double)2));
 }else {
 //BA.debugLineNum = 547;BA.debugLine="v.Top = vTop.Top + vTop.Height + (vBottom.Top";
_v.setTop((int) (_vtop.getTop()+_vtop.getHeight()+(_vbottom.getTop()-(_vtop.getTop()+_vtop.getHeight())-_v.getHeight())/(double)2));
 };
 };
 };
 //BA.debugLineNum = 551;BA.debugLine="End Sub";
return "";
}
}
