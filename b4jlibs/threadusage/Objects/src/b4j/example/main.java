package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class main extends Object{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.ShellBA("b4j.example", "b4j.example.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			anywheresoftware.b4a.ShellBA.delegateBA = new anywheresoftware.b4a.StandardBA("b4j.example", null, null);
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) throws Exception{
        try {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program started.");
            initializeProcessGlobals();
            ba.raiseEvent(null, "appstart", (Object)args);
        } catch (Throwable t) {
			BA.printException(t, true);
		
        } finally {
            anywheresoftware.b4a.keywords.Common.LogDebug("Program terminated (StartMessageLoop was not called).");
        }
    }


private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.agraham.threading.Threading _thd1 = null;
public static anywheresoftware.b4a.agraham.threading.Threading _thd2 = null;
public static int _a = 0;
public static anywheresoftware.b4a.agraham.threading.Threading.SemaphoreWrapper _lck = null;
public static String  _appstart(String[] _args) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "appstart"))
	return (String) Debug.delegate(ba, "appstart", new Object[] {_args});
RDebugUtils.currentLine=65536;
 //BA.debugLineNum = 65536;BA.debugLine="Sub AppStart (Args() As String)";
RDebugUtils.currentLine=65537;
 //BA.debugLineNum = 65537;BA.debugLine="thd1.Initialise(\"thd1\")";
_thd1.Initialise(ba,"thd1");
RDebugUtils.currentLine=65538;
 //BA.debugLineNum = 65538;BA.debugLine="thd1.Name=\"A\"";
_thd1.setName("A");
RDebugUtils.currentLine=65539;
 //BA.debugLineNum = 65539;BA.debugLine="thd2.Initialise(\"thd2\")";
_thd2.Initialise(ba,"thd2");
RDebugUtils.currentLine=65540;
 //BA.debugLineNum = 65540;BA.debugLine="thd2.Name=\"B\"";
_thd2.setName("B");
RDebugUtils.currentLine=65543;
 //BA.debugLineNum = 65543;BA.debugLine="printint";
_printint();
RDebugUtils.currentLine=65544;
 //BA.debugLineNum = 65544;BA.debugLine="thd2.Start(Me,\"printint\",Null)";
_thd2.Start(main.getObject(),"printint",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=65545;
 //BA.debugLineNum = 65545;BA.debugLine="StartMessageLoop";
anywheresoftware.b4a.keywords.Common.StartMessageLoop(ba);
RDebugUtils.currentLine=65546;
 //BA.debugLineNum = 65546;BA.debugLine="End Sub";
return "";
}
public static String  _printint() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "printint"))
	return (String) Debug.delegate(ba, "printint", null);
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub printint";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Do While a>0";
while (_a>0) {
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Log(a)";
anywheresoftware.b4a.keywords.Common.Log(BA.NumberToString(_a));
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="a=a+1";
_a = (int) (_a+1);
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="If a>99 Then";
if (_a>99) { 
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="Exit";
if (true) break;
 };
 }
;
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="CallSubDelayed(Me,\"endall\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(ba,main.getObject(),"endall");
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="End Sub";
return "";
}
public static String  _endall() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(ba, "endall"))
	return (String) Debug.delegate(ba, "endall", null);
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub endall";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="StopMessageLoop";
anywheresoftware.b4a.keywords.Common.StopMessageLoop(ba);
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
}