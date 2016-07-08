package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class comm {
private static comm mostCurrent = new comm();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.collections.List _lstact = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.act2 _act2 = null;
public b4a.example.act3 _act3 = null;
public b4a.example.act4 _act4 = null;
public static String  _addthis(anywheresoftware.b4a.BA _ba,Object _obj) throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Public Sub addthis(obj As Object)";
 //BA.debugLineNum = 16;BA.debugLine="If lstAct.IsInitialized=False Then lstAct.Initial";
if (_lstact.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_lstact.Initialize();};
 //BA.debugLineNum = 17;BA.debugLine="lstAct.Add(obj)";
_lstact.Add(_obj);
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public static String  _exitall(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.agraham.reflection.Reflection _act = null;
int _i = 0;
 //BA.debugLineNum = 19;BA.debugLine="public Sub exitall";
 //BA.debugLineNum = 20;BA.debugLine="Dim act As Reflector";
_act = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 21;BA.debugLine="For i=0 To lstAct.Size-1";
{
final int step2 = 1;
final int limit2 = (int) (_lstact.getSize()-1);
for (_i = (int) (0) ; (step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2); _i = ((int)(0 + _i + step2)) ) {
 //BA.debugLineNum = 22;BA.debugLine="act.Target=lstAct.Get(0)";
_act.Target = _lstact.Get((int) (0));
 //BA.debugLineNum = 23;BA.debugLine="Try";
try { //BA.debugLineNum = 24;BA.debugLine="act.RunMethod(\"finish\")";
_act.RunMethod("finish");
 } 
       catch (Exception e7) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e7); //BA.debugLineNum = 26;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage());
 };
 //BA.debugLineNum = 28;BA.debugLine="lstAct.RemoveAt(0)";
_lstact.RemoveAt((int) (0));
 }
};
 //BA.debugLineNum = 30;BA.debugLine="StopService(Starter)";
anywheresoftware.b4a.keywords.Common.StopService(_ba,(Object)(mostCurrent._starter.getObject()));
 //BA.debugLineNum = 31;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public static Object  _getthis(anywheresoftware.b4a.BA _ba,Object _obj) throws Exception{
anywheresoftware.b4a.agraham.reflection.Reflection _ref = null;
 //BA.debugLineNum = 10;BA.debugLine="public Sub getthis(obj As Object) As Object";
 //BA.debugLineNum = 11;BA.debugLine="Dim ref As Reflector";
_ref = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 12;BA.debugLine="ref.Target=obj";
_ref.Target = _obj;
 //BA.debugLineNum = 13;BA.debugLine="Return ref.GetActivity";
if (true) return (Object)(_ref.GetActivity((_ba.processBA == null ? _ba : _ba.processBA)));
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return null;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 4;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private lstAct As List";
_lstact = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
}
