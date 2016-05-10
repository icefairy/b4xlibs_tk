package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class ptrplmcls extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.example.ptrplmcls");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.example.ptrplmcls.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _vv5 = "";
public Object _vv6 = null;
public anywheresoftware.b4a.objects.PanelWrapper _vv7 = null;
public com.zaiten.ScrollViewWrapper _vv0 = null;
public anywheresoftware.b4a.objects.PanelWrapper _vvv1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _vvv2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _vvv3 = null;
public anywheresoftware.b4a.agraham.reflection.Reflection _vvv4 = null;
public long _vvv5 = 0L;
public long _vvv6 = 0L;
public boolean _vvv7 = false;
public boolean _vvv0 = false;
public int _vvvv1 = 0;
public int _vvvv2 = 0;
public boolean _vvvv3 = false;
public boolean _vvvv4 = false;
public boolean _vvvv5 = false;
public boolean _vvvv6 = false;
public long _vvvv7 = 0L;
public b4a.example.main _vvvv0 = null;
public b4a.example.starter _vvvvv1 = null;
public String  _v5() throws Exception{
 //BA.debugLineNum = 138;BA.debugLine="private Sub AddHeader";
 //BA.debugLineNum = 139;BA.debugLine="pHeader.SetVisibleAnimated(500,True)";
_vvv1.SetVisibleAnimated((int) (500),__c.True);
 //BA.debugLineNum = 140;BA.debugLine="pHeader.BringToFront";
_vvv1.BringToFront();
 //BA.debugLineNum = 142;BA.debugLine="End Sub";
return "";
}
public String  _v6() throws Exception{
 //BA.debugLineNum = 153;BA.debugLine="private Sub AddTailer";
 //BA.debugLineNum = 155;BA.debugLine="pTailer.Top=pData.Height-nTailerHeight";
_vvv2.setTop((int) (_vvv3.getHeight()-_vvvv2));
 //BA.debugLineNum = 156;BA.debugLine="pTailer.SetVisibleAnimated(500,True)";
_vvv2.SetVisibleAnimated((int) (500),__c.True);
 //BA.debugLineNum = 157;BA.debugLine="pTailer.BringToFront";
_vvv2.BringToFront();
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 12;BA.debugLine="Private EventName As String 'ignore";
_vv5 = "";
 //BA.debugLineNum = 13;BA.debugLine="Private CallBack As Object 'ignore";
_vv6 = new Object();
 //BA.debugLineNum = 14;BA.debugLine="Private mBase As Panel";
_vv7 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private sv As ScrollViewEx";
_vv0 = new com.zaiten.ScrollViewWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private pHeader,pTailer,pData As Panel";
_vvv1 = new anywheresoftware.b4a.objects.PanelWrapper();
_vvv2 = new anywheresoftware.b4a.objects.PanelWrapper();
_vvv3 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private ref As Reflector";
_vvv4 = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 18;BA.debugLine="Private StartY1,StartY2 As Long";
_vvv5 = 0L;
_vvv6 = 0L;
 //BA.debugLineNum = 19;BA.debugLine="Private IsOverScroll1,IsOverScroll2 As Boolean";
_vvv7 = false;
_vvv0 = false;
 //BA.debugLineNum = 20;BA.debugLine="Public nHeaderHeight=30dip,nTailerHeight=30dip As";
_vvvv1 = __c.DipToCurrent((int) (30));
_vvvv2 = __c.DipToCurrent((int) (30));
 //BA.debugLineNum = 21;BA.debugLine="Public hasHeader=True,hasTailer=True,pullToRefush";
_vvvv3 = __c.True;
_vvvv4 = __c.True;
_vvvv5 = __c.False;
_vvvv6 = __c.True;
 //BA.debugLineNum = 22;BA.debugLine="Private lastAddItemsTime As Long";
_vvvv7 = 0L;
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(anywheresoftware.b4a.objects.PanelWrapper _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
 //BA.debugLineNum = 33;BA.debugLine="Public Sub DesignerCreateView (Base As Panel, Lbl";
 //BA.debugLineNum = 34;BA.debugLine="mBase = Base";
_vv7 = _base;
 //BA.debugLineNum = 35;BA.debugLine="hasHeader=Props.GetDefault(\"hasHeader\",True)";
_vvvv3 = BA.ObjectToBoolean(_props.GetDefault((Object)("hasHeader"),(Object)(__c.True)));
 //BA.debugLineNum = 36;BA.debugLine="hasTailer=Props.GetDefault(\"hasTailer\",True)";
_vvvv4 = BA.ObjectToBoolean(_props.GetDefault((Object)("hasTailer"),(Object)(__c.True)));
 //BA.debugLineNum = 37;BA.debugLine="pullToRefush=Props.GetDefault(\"pullToRefush\",Fals";
_vvvv5 = BA.ObjectToBoolean(_props.GetDefault((Object)("pullToRefush"),(Object)(__c.False)));
 //BA.debugLineNum = 38;BA.debugLine="loadMore=Props.GetDefault(\"loadMore\",True)";
_vvvv6 = BA.ObjectToBoolean(_props.GetDefault((Object)("loadMore"),(Object)(__c.True)));
 //BA.debugLineNum = 39;BA.debugLine="sv.Initialize2(Base.Height,\"sv\")";
_vv0.Initialize2(ba,_base.getHeight(),"sv");
 //BA.debugLineNum = 41;BA.debugLine="mBase.AddView(sv,0,0,mBase.Width,mBase.Height)";
_vv7.AddView((android.view.View)(_vv0.getObject()),(int) (0),(int) (0),_vv7.getWidth(),_vv7.getHeight());
 //BA.debugLineNum = 42;BA.debugLine="If hasHeader Then";
if (_vvvv3) { 
 //BA.debugLineNum = 43;BA.debugLine="sv.Panel.AddView(pHeader,0,0,sv.Panel.Width,nHea";
_vv0.getPanel().AddView((android.view.View)(_vvv1.getObject()),(int) (0),(int) (0),_vv0.getPanel().getWidth(),_vvvv1);
 //BA.debugLineNum = 45;BA.debugLine="Dim Lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
 //BA.debugLineNum = 47;BA.debugLine="Lbl.Text=\"我是头部\"";
_lbl.setText((Object)("我是头部"));
 //BA.debugLineNum = 48;BA.debugLine="Lbl.Gravity=Gravity.CENTER";
_lbl.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 49;BA.debugLine="pHeader.Visible=False";
_vvv1.setVisible(__c.False);
 //BA.debugLineNum = 50;BA.debugLine="pHeader.Color=Colors.Gray";
_vvv1.setColor(__c.Colors.Gray);
 //BA.debugLineNum = 51;BA.debugLine="pHeader.AddView(Lbl,0,0,-1,-1)";
_vvv1.AddView((android.view.View)(_lbl.getObject()),(int) (0),(int) (0),(int) (-1),(int) (-1));
 };
 //BA.debugLineNum = 54;BA.debugLine="sv.Panel.AddView(pData,0,0,sv.Width,sv.Height)";
_vv0.getPanel().AddView((android.view.View)(_vvv3.getObject()),(int) (0),(int) (0),_vv0.getWidth(),_vv0.getHeight());
 //BA.debugLineNum = 55;BA.debugLine="If hasTailer Then";
if (_vvvv4) { 
 //BA.debugLineNum = 56;BA.debugLine="sv.Panel.AddView(pTailer,0,mBase.Height-nTailerH";
_vv0.getPanel().AddView((android.view.View)(_vvv2.getObject()),(int) (0),(int) (_vv7.getHeight()-_vvvv2),_vv0.getPanel().getWidth(),_vvvv2);
 //BA.debugLineNum = 58;BA.debugLine="Dim Lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 59;BA.debugLine="Lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
 //BA.debugLineNum = 60;BA.debugLine="Lbl.Text=\"我是尾部\"";
_lbl.setText((Object)("我是尾部"));
 //BA.debugLineNum = 61;BA.debugLine="Lbl.Gravity=Gravity.CENTER";
_lbl.setGravity(__c.Gravity.CENTER);
 //BA.debugLineNum = 62;BA.debugLine="pTailer.Color=Colors.Gray";
_vvv2.setColor(__c.Colors.Gray);
 //BA.debugLineNum = 63;BA.debugLine="pTailer.Visible=False";
_vvv2.setVisible(__c.False);
 //BA.debugLineNum = 64;BA.debugLine="pTailer.AddView(Lbl,0,0,-1,-1)";
_vvv2.AddView((android.view.View)(_lbl.getObject()),(int) (0),(int) (0),(int) (-1),(int) (-1));
 };
 //BA.debugLineNum = 67;BA.debugLine="ref.Target=sv";
_vvv4.Target = (Object)(_vv0.getObject());
 //BA.debugLineNum = 68;BA.debugLine="ref.SetOnTouchListener(\"ScrollView_Touch\")";
_vvv4.SetOnTouchListener(ba,"ScrollView_Touch");
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.PanelWrapper  _v7() throws Exception{
 //BA.debugLineNum = 163;BA.debugLine="public Sub GetPData As Panel";
 //BA.debugLineNum = 164;BA.debugLine="Return pData";
if (true) return _vvv3;
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.ScrollViewWrapper  _v0() throws Exception{
 //BA.debugLineNum = 160;BA.debugLine="Public Sub GetSV As ScrollView";
 //BA.debugLineNum = 161;BA.debugLine="Return sv";
if (true) return (anywheresoftware.b4a.objects.ScrollViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ScrollViewWrapper(), (android.widget.ScrollView)(_vv0.getObject()));
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _vcallback,String _veventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 25;BA.debugLine="Public Sub Initialize (vCallback As Object, vEvent";
 //BA.debugLineNum = 26;BA.debugLine="EventName = vEventName";
_vv5 = _veventname;
 //BA.debugLineNum = 27;BA.debugLine="CallBack = vCallback";
_vv6 = _vcallback;
 //BA.debugLineNum = 28;BA.debugLine="pHeader.Initialize(\"\")";
_vvv1.Initialize(ba,"");
 //BA.debugLineNum = 29;BA.debugLine="pTailer.Initialize(\"\")";
_vvv2.Initialize(ba,"");
 //BA.debugLineNum = 30;BA.debugLine="pData.Initialize(\"\")";
_vvv3.Initialize(ba,"");
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return "";
}
public boolean  _scrollview_touch(Object _viewtag,int _action,float _x,float _y,Object _motionevent) throws Exception{
 //BA.debugLineNum = 84;BA.debugLine="Sub ScrollView_Touch (viewtag As Object, action";
 //BA.debugLineNum = 86;BA.debugLine="Select Case action";
switch (_action) {
case 0: {
 //BA.debugLineNum = 89;BA.debugLine="StartY1=-1";
_vvv5 = (long) (-1);
 //BA.debugLineNum = 90;BA.debugLine="StartY2=-1";
_vvv6 = (long) (-1);
 //BA.debugLineNum = 91;BA.debugLine="IsOverScroll1=False";
_vvv7 = __c.False;
 //BA.debugLineNum = 92;BA.debugLine="IsOverScroll2=False";
_vvv0 = __c.False;
 break; }
case 1: {
 //BA.debugLineNum = 95;BA.debugLine="StartY1=-1";
_vvv5 = (long) (-1);
 //BA.debugLineNum = 96;BA.debugLine="StartY2=-1";
_vvv6 = (long) (-1);
 //BA.debugLineNum = 97;BA.debugLine="If IsOverScroll1 Then";
if (_vvv7) { 
 //BA.debugLineNum = 98;BA.debugLine="SubHeader '移除头部区域";
_vv2();
 };
 //BA.debugLineNum = 100;BA.debugLine="If IsOverScroll2 Then";
if (_vvv0) { 
 //BA.debugLineNum = 101;BA.debugLine="SubTailer '移除尾部区域";
_vv3();
 };
 break; }
case 2: {
 //BA.debugLineNum = 105;BA.debugLine="If StartY1<>-1 Then";
if (_vvv5!=-1) { 
 //BA.debugLineNum = 106;BA.debugLine="If Y>StartY1 And IsOverScroll1=False Then";
if (_y>_vvv5 && _vvv7==__c.False) { 
 //BA.debugLineNum = 108;BA.debugLine="IsOverScroll1=True";
_vvv7 = __c.True;
 //BA.debugLineNum = 109;BA.debugLine="AddHeader '增加头部区域";
_v5();
 };
 };
 //BA.debugLineNum = 112;BA.debugLine="If StartY2<>-1 Then";
if (_vvv6!=-1) { 
 //BA.debugLineNum = 113;BA.debugLine="If Y<StartY2 And IsOverScroll2=False Then";
if (_y<_vvv6 && _vvv0==__c.False) { 
 //BA.debugLineNum = 115;BA.debugLine="IsOverScroll2=True";
_vvv0 = __c.True;
 //BA.debugLineNum = 116;BA.debugLine="AddTailer '增加尾部区域";
_v6();
 };
 };
 //BA.debugLineNum = 119;BA.debugLine="If sv.ScrollPosition=0 And IsOverScroll1=Fal";
if (_vv0.getScrollPosition()==0 && _vvv7==__c.False) { 
 //BA.debugLineNum = 121;BA.debugLine="StartY1=Y";
_vvv5 = (long) (_y);
 };
 //BA.debugLineNum = 123;BA.debugLine="If sv.ScrollPosition=sv.Panel.Height-sv.Heig";
if (_vv0.getScrollPosition()==_vv0.getPanel().getHeight()-_vv0.getHeight() && _vvv0==__c.False) { 
 //BA.debugLineNum = 125;BA.debugLine="StartY2=Y";
_vvv6 = (long) (_y);
 };
 break; }
}
;
 //BA.debugLineNum = 128;BA.debugLine="Return False '允许继续响应控件事件";
if (true) return __c.False;
 //BA.debugLineNum = 129;BA.debugLine="End Sub";
return false;
}
public String  _setvv4(long _nh) throws Exception{
int _nmax = 0;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
 //BA.debugLineNum = 72;BA.debugLine="Public Sub setInnerHeight(nh As Long)";
 //BA.debugLineNum = 73;BA.debugLine="If nh=-1 Then";
if (_nh==-1) { 
 //BA.debugLineNum = 74;BA.debugLine="Dim nMax As Int";
_nmax = 0;
 //BA.debugLineNum = 75;BA.debugLine="For Each v As View In pData.GetAllViewsRecursive";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
final anywheresoftware.b4a.BA.IterableList group3 = _vvv3.GetAllViewsRecursive();
final int groupLen3 = group3.getSize();
for (int index3 = 0;index3 < groupLen3 ;index3++){
_v.setObject((android.view.View)(group3.Get(index3)));
 //BA.debugLineNum = 76;BA.debugLine="If (v.Top+v.Height)>nMax Then nMax=v.Top+v.Heig";
if ((_v.getTop()+_v.getHeight())>_nmax) { 
_nmax = (int) (_v.getTop()+_v.getHeight());};
 }
;
 //BA.debugLineNum = 78;BA.debugLine="setInnerHeight(nMax)";
_setvv4((long) (_nmax));
 };
 //BA.debugLineNum = 80;BA.debugLine="If nh<mBase.Height Then Return";
if (_nh<_vv7.getHeight()) { 
if (true) return "";};
 //BA.debugLineNum = 81;BA.debugLine="pData.Height=nh";
_vvv3.setHeight((int) (_nh));
 //BA.debugLineNum = 82;BA.debugLine="sv.Panel.Height=nh";
_vv0.getPanel().setHeight((int) (_nh));
 //BA.debugLineNum = 83;BA.debugLine="End Sub";
return "";
}
public String  _vv2() throws Exception{
 //BA.debugLineNum = 130;BA.debugLine="Private Sub SubHeader";
 //BA.debugLineNum = 131;BA.debugLine="pHeader.SetVisibleAnimated(1000,False)";
_vvv1.SetVisibleAnimated((int) (1000),__c.False);
 //BA.debugLineNum = 132;BA.debugLine="If hasHeader And pullToRefush And SubExists(CallB";
if (_vvvv3 && _vvvv5 && __c.SubExists(ba,_vv6,_vv5+"_reqRefush")) { 
__c.CallSubDelayed(ba,_vv6,_vv5+"_reqRefush");};
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public String  _vv3() throws Exception{
 //BA.debugLineNum = 134;BA.debugLine="Private Sub SubTailer";
 //BA.debugLineNum = 135;BA.debugLine="pTailer.SetVisibleAnimated(1000,False)";
_vvv2.SetVisibleAnimated((int) (1000),__c.False);
 //BA.debugLineNum = 136;BA.debugLine="If hasTailer And loadMore And SubExists(CallBack,";
if (_vvvv4 && _vvvv6 && __c.SubExists(ba,_vv6,_vv5+"_loadMore")) { 
__c.CallSubDelayed(ba,_vv6,_vv5+"_loadMore");};
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
