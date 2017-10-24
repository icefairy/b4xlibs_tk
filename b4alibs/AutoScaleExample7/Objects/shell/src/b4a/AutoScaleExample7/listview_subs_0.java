package b4a.AutoScaleExample7;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class listview_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (listview) ","listview",8,listview.mostCurrent.activityBA,listview.mostCurrent,18);
if (RapidSub.canDelegate("activity_create")) return b4a.AutoScaleExample7.listview.remoteMe.runUserSub(false, "listview","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 18;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 19;BA.debugLine="Activity.LoadLayout(\"listview\")";
Debug.ShouldStop(262144);
listview.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("listview")),listview.mostCurrent.activityBA);
 BA.debugLineNum = 21;BA.debugLine="Scale.SetRate(0.5)";
Debug.ShouldStop(1048576);
listview.mostCurrent._scale.runVoidMethod ("_setrate",listview.mostCurrent.activityBA,(Object)(BA.numberCast(double.class, 0.5)));
 BA.debugLineNum = 22;BA.debugLine="Scale.ScaleAll(Activity, True)";
Debug.ShouldStop(2097152);
listview.mostCurrent._scale.runVoidMethod ("_scaleall",listview.mostCurrent.activityBA,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.PanelWrapper"), listview.mostCurrent._activity.getObject()),(Object)(listview.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 24;BA.debugLine="pnlListView.Left = (100%x - pnlListView.Width) /";
Debug.ShouldStop(8388608);
listview.mostCurrent._pnllistview.runMethod(true,"setLeft",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {listview.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),listview.mostCurrent.activityBA),listview.mostCurrent._pnllistview.runMethod(true,"getWidth")}, "-",1, 1)),RemoteObject.createImmutable(2)}, "/",0, 0)));
 BA.debugLineNum = 25;BA.debugLine="pnlListView.Height = 100%y";
Debug.ShouldStop(16777216);
listview.mostCurrent._pnllistview.runMethod(true,"setHeight",listview.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),listview.mostCurrent.activityBA));
 BA.debugLineNum = 26;BA.debugLine="ltvTest.Height = pnlListView.Height - ltvTest.Top";
Debug.ShouldStop(33554432);
listview.mostCurrent._ltvtest.runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {listview.mostCurrent._pnllistview.runMethod(true,"getHeight"),listview.mostCurrent._ltvtest.runMethod(true,"getTop"),listview.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),listview.mostCurrent._scale.runMethod(true,"_getscaley",listview.mostCurrent.activityBA)}, "--*",2, 0)));
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (listview) ","listview",8,listview.mostCurrent.activityBA,listview.mostCurrent,33);
if (RapidSub.canDelegate("activity_pause")) return b4a.AutoScaleExample7.listview.remoteMe.runUserSub(false, "listview","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (listview) ","listview",8,listview.mostCurrent.activityBA,listview.mostCurrent,29);
if (RapidSub.canDelegate("activity_resume")) return b4a.AutoScaleExample7.listview.remoteMe.runUserSub(false, "listview","activity_resume");
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="FillListView";
Debug.ShouldStop(536870912);
_filllistview();
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _filllistview() throws Exception{
try {
		Debug.PushSubsStack("FillListView (listview) ","listview",8,listview.mostCurrent.activityBA,listview.mostCurrent,37);
if (RapidSub.canDelegate("filllistview")) return b4a.AutoScaleExample7.listview.remoteMe.runUserSub(false, "listview","filllistview");
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 BA.debugLineNum = 37;BA.debugLine="Sub FillListView";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="Dim i As Int";
Debug.ShouldStop(32);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 39;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(64);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 41;BA.debugLine="bmp.Initialize(File.DirAssets, \"rose.png\")";
Debug.ShouldStop(256);
_bmp.runVoidMethod ("Initialize",(Object)(listview.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("rose.png")));
 BA.debugLineNum = 43;BA.debugLine="For i = 0 To 30";
Debug.ShouldStop(1024);
{
final int step4 = 1;
final int limit4 = 30;
_i = BA.numberCast(int.class, 0) ;
for (;(step4 > 0 && _i.<Integer>get().intValue() <= limit4) || (step4 < 0 && _i.<Integer>get().intValue() >= limit4) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 44;BA.debugLine="ltvTest.AddSingleLine(\"One line \" & i)";
Debug.ShouldStop(2048);
listview.mostCurrent._ltvtest.runVoidMethod ("AddSingleLine",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("One line "),_i))));
 BA.debugLineNum = 45;BA.debugLine="ltvTest.AddTwoLines(\"First line \" & i, \"Second l";
Debug.ShouldStop(4096);
listview.mostCurrent._ltvtest.runVoidMethod ("AddTwoLines",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("First line "),_i))),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Second line "),_i))));
 BA.debugLineNum = 46;BA.debugLine="ltvTest.AddTwoLinesAndBitmap(\"First line \" & i,";
Debug.ShouldStop(8192);
listview.mostCurrent._ltvtest.runVoidMethod ("AddTwoLinesAndBitmap",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("First line "),_i))),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Second line "),_i))),(Object)((_bmp.getObject())));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim pnlListView As Panel";
listview.mostCurrent._pnllistview = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Dim lblListViewTitle As Label";
listview.mostCurrent._lbllistviewtitle = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Dim ltvTest As ListView";
listview.mostCurrent._ltvtest = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}