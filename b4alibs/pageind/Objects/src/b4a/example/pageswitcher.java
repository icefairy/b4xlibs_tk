package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class pageswitcher extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.pageswitcher");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.pageswitcher.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public int _nmax = 0;
public int _ncur = 0;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _activebmp = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _inactivebmp = null;
public anywheresoftware.b4a.objects.PanelWrapper _basepanel = null;
public int _nheight = 0;
public int _width = 0;
public int _njg = 0;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public String  _add2parent(anywheresoftware.b4a.objects.PanelWrapper _panel) throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Public Sub Add2Parent(panel As Panel)";
 //BA.debugLineNum = 64;BA.debugLine="panel.AddView(basePanel,(panel.Width-Width)/2,pan";
_panel.AddView((android.view.View)(_basepanel.getObject()),(int) ((_panel.getWidth()-_width)/(double)2),(int) (_panel.getHeight()-_nheight-_njg),_width,_nheight);
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.PanelWrapper  _asview() throws Exception{
 //BA.debugLineNum = 41;BA.debugLine="Public Sub asView As Panel";
 //BA.debugLineNum = 42;BA.debugLine="Return basePanel";
if (true) return _basepanel;
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return null;
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Public nMax As Int";
_nmax = 0;
 //BA.debugLineNum = 4;BA.debugLine="Private nCur As Int=0";
_ncur = (int) (0);
 //BA.debugLineNum = 5;BA.debugLine="Public activebmp As Bitmap=LoadBitmap(File.DirAss";
_activebmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_activebmp = __c.LoadBitmap(__c.File.getDirAssets(),"indicator_active.png");
 //BA.debugLineNum = 6;BA.debugLine="Public inactivebmp As Bitmap=LoadBitmap(File.DirA";
_inactivebmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_inactivebmp = __c.LoadBitmap(__c.File.getDirAssets(),"indicator_inactive.png");
 //BA.debugLineNum = 7;BA.debugLine="Private basePanel As Panel";
_basepanel = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 8;BA.debugLine="Public nHeight As Int=7dip";
_nheight = __c.DipToCurrent((int) (7));
 //BA.debugLineNum = 9;BA.debugLine="Public Width As Int=0";
_width = (int) (0);
 //BA.debugLineNum = 10;BA.debugLine="Public njg As Int=5dip";
_njg = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public String  _getcurpage() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Public Sub getCurPage";
 //BA.debugLineNum = 61;BA.debugLine="Return nCur";
if (true) return BA.NumberToString(_ncur);
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,int _nmaxpage) throws Exception{
innerInitialize(_ba);
int _imagesize = 0;
int _maxwidth = 0;
int _gap = 0;
int _top = 0;
int _i = 0;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
 //BA.debugLineNum = 15;BA.debugLine="Public Sub Initialize(nMaxPage As Int)";
 //BA.debugLineNum = 16;BA.debugLine="nMax=nMaxPage";
_nmax = _nmaxpage;
 //BA.debugLineNum = 17;BA.debugLine="Width=nHeight*nMax";
_width = (int) (_nheight*_nmax);
 //BA.debugLineNum = 18;BA.debugLine="Dim imageSize, maxWidth, Gap, Top As Int";
_imagesize = 0;
_maxwidth = 0;
_gap = 0;
_top = 0;
 //BA.debugLineNum = 19;BA.debugLine="njg=5dip";
_njg = __c.DipToCurrent((int) (5));
 //BA.debugLineNum = 20;BA.debugLine="Width=Width+njg*(nMax-1)";
_width = (int) (_width+_njg*(_nmax-1));
 //BA.debugLineNum = 21;BA.debugLine="maxWidth = Width / nMax 'org";
_maxwidth = (int) (_width/(double)_nmax);
 //BA.debugLineNum = 22;BA.debugLine="If maxWidth < nHeight Then";
if (_maxwidth<_nheight) { 
 //BA.debugLineNum = 23;BA.debugLine="imageSize = maxWidth";
_imagesize = _maxwidth;
 //BA.debugLineNum = 24;BA.debugLine="Top = (nHeight - maxWidth) / 2";
_top = (int) ((_nheight-_maxwidth)/(double)2);
 //BA.debugLineNum = 25;BA.debugLine="Gap = 0";
_gap = (int) (0);
 }else {
 //BA.debugLineNum = 27;BA.debugLine="imageSize = nHeight";
_imagesize = _nheight;
 //BA.debugLineNum = 28;BA.debugLine="Top = 0";
_top = (int) (0);
 //BA.debugLineNum = 29;BA.debugLine="Gap = (Width - nMax * imageSize) / (nMax - 1)";
_gap = (int) ((_width-_nmax*_imagesize)/(double)(_nmax-1));
 };
 //BA.debugLineNum = 31;BA.debugLine="basePanel.Initialize(\"\")";
_basepanel.Initialize(ba,"");
 //BA.debugLineNum = 32;BA.debugLine="For i = 0 To nMax - 1";
{
final int step17 = 1;
final int limit17 = (int) (_nmax-1);
for (_i = (int) (0) ; (step17 > 0 && _i <= limit17) || (step17 < 0 && _i >= limit17); _i = ((int)(0 + _i + step17)) ) {
 //BA.debugLineNum = 33;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 34;BA.debugLine="iv.Initialize(\"\")";
_iv.Initialize(ba,"");
 //BA.debugLineNum = 35;BA.debugLine="iv.Gravity=Gravity.FILL";
_iv.setGravity(__c.Gravity.FILL);
 //BA.debugLineNum = 36;BA.debugLine="iv.Bitmap = inactivebmp";
_iv.setBitmap((android.graphics.Bitmap)(_inactivebmp.getObject()));
 //BA.debugLineNum = 37;BA.debugLine="basePanel.AddView(iv, i * (imageSize + Gap), Top";
_basepanel.AddView((android.view.View)(_iv.getObject()),(int) (_i*(_imagesize+_gap)),_top,_imagesize,_imagesize);
 }
};
 //BA.debugLineNum = 39;BA.debugLine="SetPageIndicator(0)";
_setpageindicator((int) (0));
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public String  _setpageindicator(int _page) throws Exception{
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
int _i = 0;
 //BA.debugLineNum = 44;BA.debugLine="public Sub SetPageIndicator(page As Int)";
 //BA.debugLineNum = 45;BA.debugLine="Dim v As View";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 47;BA.debugLine="nCur=page";
_ncur = _page;
 //BA.debugLineNum = 48;BA.debugLine="For i = 0 To nMax - 1";
{
final int step4 = 1;
final int limit4 = (int) (_nmax-1);
for (_i = (int) (0) ; (step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4); _i = ((int)(0 + _i + step4)) ) {
 //BA.debugLineNum = 49;BA.debugLine="v = basePanel.GetView(i)";
_v = _basepanel.GetView(_i);
 //BA.debugLineNum = 50;BA.debugLine="If v Is ImageView Then";
if (_v.getObjectOrNull() instanceof android.widget.ImageView) { 
 //BA.debugLineNum = 51;BA.debugLine="iv = v";
_iv.setObject((android.widget.ImageView)(_v.getObject()));
 //BA.debugLineNum = 52;BA.debugLine="If i = page Then";
if (_i==_page) { 
 //BA.debugLineNum = 53;BA.debugLine="iv.Bitmap = activebmp";
_iv.setBitmap((android.graphics.Bitmap)(_activebmp.getObject()));
 }else {
 //BA.debugLineNum = 55;BA.debugLine="iv.Bitmap = inactivebmp";
_iv.setBitmap((android.graphics.Bitmap)(_inactivebmp.getObject()));
 };
 };
 }
};
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
