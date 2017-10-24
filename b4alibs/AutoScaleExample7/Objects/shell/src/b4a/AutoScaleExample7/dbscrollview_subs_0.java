package b4a.AutoScaleExample7;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class dbscrollview_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (dbscrollview) ","dbscrollview",6,dbscrollview.mostCurrent.activityBA,dbscrollview.mostCurrent,51);
if (RapidSub.canDelegate("activity_create")) return b4a.AutoScaleExample7.dbscrollview.remoteMe.runUserSub(false, "dbscrollview","activity_create", _firsttime);
RemoteObject _i = RemoteObject.createImmutable(0);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 51;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 52;BA.debugLine="Dim i As Int";
Debug.ShouldStop(524288);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 55;BA.debugLine="If FirstTime = True Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_firsttime,dbscrollview.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 56;BA.debugLine="ColLineWidth = ColLineWidth * Scale.GetScaleX";
Debug.ShouldStop(8388608);
dbscrollview._collinewidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {dbscrollview._collinewidth,dbscrollview.mostCurrent._scale.runMethod(true,"_getscalex",dbscrollview.mostCurrent.activityBA)}, "*",0, 0));
 BA.debugLineNum = 57;BA.debugLine="RowLineWidth = RowLineWidth * Scale.GetScaleX";
Debug.ShouldStop(16777216);
dbscrollview._rowlinewidth = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {dbscrollview._rowlinewidth,dbscrollview.mostCurrent._scale.runMethod(true,"_getscalex",dbscrollview.mostCurrent.activityBA)}, "*",0, 0));
 BA.debugLineNum = 58;BA.debugLine="RowHeight = RowHeight * Scale.GetScaleY";
Debug.ShouldStop(33554432);
dbscrollview._rowheight = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {dbscrollview._rowheight,dbscrollview.mostCurrent._scale.runMethod(true,"_getscaley",dbscrollview.mostCurrent.activityBA)}, "*",0, 0));
 BA.debugLineNum = 59;BA.debugLine="RowHeight_1 = RowHeight - RowLineWidth";
Debug.ShouldStop(67108864);
dbscrollview._rowheight_1 = RemoteObject.solve(new RemoteObject[] {dbscrollview._rowheight,dbscrollview._rowlinewidth}, "-",1, 1);
 BA.debugLineNum = 60;BA.debugLine="FontSize = FontSize * Scale.GetScaleX";
Debug.ShouldStop(134217728);
dbscrollview._fontsize = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {dbscrollview._fontsize,dbscrollview.mostCurrent._scale.runMethod(true,"_getscalex",dbscrollview.mostCurrent.activityBA)}, "*",0, 0));
 BA.debugLineNum = 61;BA.debugLine="For i = 0 To NumberOfColumns - 1";
Debug.ShouldStop(268435456);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {dbscrollview._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
for (;(step8 > 0 && _i.<Integer>get().intValue() <= limit8) || (step8 < 0 && _i.<Integer>get().intValue() >= limit8) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step8))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 62;BA.debugLine="ColumnWidth(i) = ColumnWidth(i) * Scale.GetScal";
Debug.ShouldStop(536870912);
dbscrollview._columnwidth.setArrayElement (BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {dbscrollview._columnwidth.getArrayElement(true,_i),dbscrollview.mostCurrent._scale.runMethod(true,"_getscalex",dbscrollview.mostCurrent.activityBA)}, "*",0, 0)),_i);
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 67;BA.debugLine="TotalColumnWidth(0) = ColLineWidth";
Debug.ShouldStop(4);
dbscrollview._totalcolumnwidth.setArrayElement (dbscrollview._collinewidth,BA.numberCast(int.class, 0));
 BA.debugLineNum = 68;BA.debugLine="For i = 0 To NumberOfColumns - 1";
Debug.ShouldStop(8);
{
final int step13 = 1;
final int limit13 = RemoteObject.solve(new RemoteObject[] {dbscrollview._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
for (;(step13 > 0 && _i.<Integer>get().intValue() <= limit13) || (step13 < 0 && _i.<Integer>get().intValue() >= limit13) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step13))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 69;BA.debugLine="ColumnWidth_1(i) = ColumnWidth(i) - ColLineWidth";
Debug.ShouldStop(16);
dbscrollview._columnwidth_1.setArrayElement (RemoteObject.solve(new RemoteObject[] {dbscrollview._columnwidth.getArrayElement(true,_i),dbscrollview._collinewidth}, "-",1, 1),_i);
 BA.debugLineNum = 70;BA.debugLine="TotalColumnWidth(i + 1) = TotalColumnWidth(i) +";
Debug.ShouldStop(32);
dbscrollview._totalcolumnwidth.setArrayElement (RemoteObject.solve(new RemoteObject[] {dbscrollview._totalcolumnwidth.getArrayElement(true,_i),dbscrollview._columnwidth.getArrayElement(true,_i)}, "+",1, 1),RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(1)}, "+",1, 1));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 74;BA.debugLine="scvPersons.Initialize(100,100, \"scvPersons\")";
Debug.ShouldStop(512);
dbscrollview.mostCurrent._scvpersons.runVoidMethod ("Initialize",dbscrollview.mostCurrent.activityBA,(Object)(BA.numberCast(int.class, 100)),(Object)(BA.numberCast(int.class, 100)),(Object)(RemoteObject.createImmutable("scvPersons")));
 BA.debugLineNum = 75;BA.debugLine="Activity.AddView(scvPersons, 0, RowHeight, 100%x,";
Debug.ShouldStop(1024);
dbscrollview.mostCurrent._activity.runVoidMethod ("AddView",(Object)((dbscrollview.mostCurrent._scvpersons.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(dbscrollview._rowheight),(Object)(dbscrollview.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),dbscrollview.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {dbscrollview.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),dbscrollview.mostCurrent.activityBA),dbscrollview._rowheight}, "-",1, 1)));
 BA.debugLineNum = 78;BA.debugLine="scvPersons.Panel.Width = TotalColumnWidth(NumberO";
Debug.ShouldStop(8192);
dbscrollview.mostCurrent._scvpersons.runMethod(false,"getPanel").runMethod(true,"setWidth",dbscrollview._totalcolumnwidth.getArrayElement(true,dbscrollview._numberofcolumns));
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Pause (dbscrollview) ","dbscrollview",6,dbscrollview.mostCurrent.activityBA,dbscrollview.mostCurrent,85);
if (RapidSub.canDelegate("activity_pause")) return b4a.AutoScaleExample7.dbscrollview.remoteMe.runUserSub(false, "dbscrollview","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 85;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_Resume (dbscrollview) ","dbscrollview",6,dbscrollview.mostCurrent.activityBA,dbscrollview.mostCurrent,81);
if (RapidSub.canDelegate("activity_resume")) return b4a.AutoScaleExample7.dbscrollview.remoteMe.runUserSub(false, "dbscrollview","activity_resume");
 BA.debugLineNum = 81;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(65536);
 BA.debugLineNum = 82;BA.debugLine="SQLTableRead";
Debug.ShouldStop(131072);
_sqltableread();
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addrow(RemoteObject _values) throws Exception{
try {
		Debug.PushSubsStack("AddRow (dbscrollview) ","dbscrollview",6,dbscrollview.mostCurrent.activityBA,dbscrollview.mostCurrent,115);
if (RapidSub.canDelegate("addrow")) return b4a.AutoScaleExample7.dbscrollview.remoteMe.runUserSub(false, "dbscrollview","addrow", _values);
int _i = 0;
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _rc = RemoteObject.declareNull("b4a.AutoScaleExample7.dbscrollview._rowcol");
Debug.locals.put("Values", _values);
 BA.debugLineNum = 115;BA.debugLine="Sub AddRow(Values() As String)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 117;BA.debugLine="If Values.Length <> NumberOfColumns Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("!",_values.getField(true,"length"),BA.numberCast(double.class, dbscrollview._numberofcolumns))) { 
 BA.debugLineNum = 118;BA.debugLine="Return";
Debug.ShouldStop(2097152);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 121;BA.debugLine="For i = 0 To NumberOfColumns - 1";
Debug.ShouldStop(16777216);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {dbscrollview._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 122;BA.debugLine="Dim l As Label";
Debug.ShouldStop(33554432);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 123;BA.debugLine="l.Initialize(\"cell\")";
Debug.ShouldStop(67108864);
_l.runVoidMethod ("Initialize",dbscrollview.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("cell")));
 BA.debugLineNum = 124;BA.debugLine="l.Text = Values(i)";
Debug.ShouldStop(134217728);
_l.runMethod(true,"setText",BA.ObjectToCharSequence(_values.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 125;BA.debugLine="l.Gravity = Alignment";
Debug.ShouldStop(268435456);
_l.runMethod(true,"setGravity",dbscrollview._alignment);
 BA.debugLineNum = 126;BA.debugLine="l.TextSize = FontSize";
Debug.ShouldStop(536870912);
_l.runMethod(true,"setTextSize",dbscrollview._fontsize);
 BA.debugLineNum = 127;BA.debugLine="l.TextColor = FontColor";
Debug.ShouldStop(1073741824);
_l.runMethod(true,"setTextColor",dbscrollview._fontcolor);
 BA.debugLineNum = 128;BA.debugLine="l.Color = CellColor";
Debug.ShouldStop(-2147483648);
_l.runVoidMethod ("setColor",dbscrollview._cellcolor);
 BA.debugLineNum = 129;BA.debugLine="Dim rc As RowCol";
Debug.ShouldStop(1);
_rc = RemoteObject.createNew ("b4a.AutoScaleExample7.dbscrollview._rowcol");Debug.locals.put("rc", _rc);
 BA.debugLineNum = 130;BA.debugLine="rc.Initialize";
Debug.ShouldStop(2);
_rc.runVoidMethod ("Initialize");
 BA.debugLineNum = 131;BA.debugLine="rc.Col = i";
Debug.ShouldStop(4);
_rc.setField ("Col",BA.numberCast(int.class, _i));
 BA.debugLineNum = 132;BA.debugLine="rc.Row = NumberOfRows";
Debug.ShouldStop(8);
_rc.setField ("Row",dbscrollview._numberofrows);
 BA.debugLineNum = 133;BA.debugLine="l.Tag = rc";
Debug.ShouldStop(16);
_l.runMethod(false,"setTag",(_rc));
 BA.debugLineNum = 134;BA.debugLine="scvPersons.Panel.AddView(l, TotalColumnWidth(i),";
Debug.ShouldStop(32);
dbscrollview.mostCurrent._scvpersons.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_l.getObject())),(Object)(dbscrollview._totalcolumnwidth.getArrayElement(true,BA.numberCast(int.class, _i))),(Object)(RemoteObject.solve(new RemoteObject[] {dbscrollview._rowheight,dbscrollview._numberofrows}, "*",0, 1)),(Object)(dbscrollview._columnwidth_1.getArrayElement(true,BA.numberCast(int.class, _i))),(Object)(dbscrollview._rowheight_1));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 137;BA.debugLine="NumberOfRows = NumberOfRows + 1";
Debug.ShouldStop(256);
dbscrollview._numberofrows = RemoteObject.solve(new RemoteObject[] {dbscrollview._numberofrows,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 138;BA.debugLine="scvPersons.Panel.Height = NumberOfRows * RowHeigh";
Debug.ShouldStop(512);
dbscrollview.mostCurrent._scvpersons.runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {dbscrollview._numberofrows,dbscrollview._rowheight}, "*",0, 1));
 BA.debugLineNum = 139;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 46;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 47;BA.debugLine="Dim scvPersons As ScrollView2D";
dbscrollview.mostCurrent._scvpersons = RemoteObject.createNew ("flm.b4a.scrollview2d.ScrollView2DWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Dim pnlHeader As Panel";
dbscrollview.mostCurrent._pnlheader = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Dim NumberOfColumns = 5 As Int";
dbscrollview._numberofcolumns = BA.numberCast(int.class, 5);
 //BA.debugLineNum = 11;BA.debugLine="Dim NumberOfRows = 0 As Int";
dbscrollview._numberofrows = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 12;BA.debugLine="Dim RowHeight = 30dip As Int";
dbscrollview._rowheight = dbscrollview.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)));
 //BA.debugLineNum = 13;BA.debugLine="Dim RowLineWidth = 1dip As Int";
dbscrollview._rowlinewidth = dbscrollview.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)));
 //BA.debugLineNum = 14;BA.debugLine="Dim RowHeight_1 As Int					: RowHeight_1 = RowHei";
dbscrollview._rowheight_1 = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 14;BA.debugLine="Dim RowHeight_1 As Int					: RowHeight_1 = RowHei";
dbscrollview._rowheight_1 = RemoteObject.solve(new RemoteObject[] {dbscrollview._rowheight,dbscrollview._rowlinewidth}, "-",1, 1);
 //BA.debugLineNum = 15;BA.debugLine="Dim ColLineWidth = 1dip As Int";
dbscrollview._collinewidth = dbscrollview.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)));
 //BA.debugLineNum = 16;BA.debugLine="Dim ColumnWidth(NumberOfColumns) As Int";
dbscrollview._columnwidth = RemoteObject.createNewArray ("int", new int[] {dbscrollview._numberofcolumns.<Integer>get().intValue()}, new Object[]{});
 //BA.debugLineNum = 17;BA.debugLine="ColumnWidth(0) = 60dip";
dbscrollview._columnwidth.setArrayElement (dbscrollview.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60))),BA.numberCast(int.class, 0));
 //BA.debugLineNum = 18;BA.debugLine="ColumnWidth(1) = 120dip";
dbscrollview._columnwidth.setArrayElement (dbscrollview.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))),BA.numberCast(int.class, 1));
 //BA.debugLineNum = 19;BA.debugLine="ColumnWidth(2) = 120dip";
dbscrollview._columnwidth.setArrayElement (dbscrollview.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))),BA.numberCast(int.class, 2));
 //BA.debugLineNum = 20;BA.debugLine="ColumnWidth(3) = 180dip";
dbscrollview._columnwidth.setArrayElement (dbscrollview.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 180))),BA.numberCast(int.class, 3));
 //BA.debugLineNum = 21;BA.debugLine="ColumnWidth(4) = 120dip";
dbscrollview._columnwidth.setArrayElement (dbscrollview.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120))),BA.numberCast(int.class, 4));
 //BA.debugLineNum = 22;BA.debugLine="Dim ColumnWidth_1(NumberOfColumns) As Int";
dbscrollview._columnwidth_1 = RemoteObject.createNewArray ("int", new int[] {dbscrollview._numberofcolumns.<Integer>get().intValue()}, new Object[]{});
 //BA.debugLineNum = 23;BA.debugLine="Dim TotalColumnWidth(NumberOfColumns + 1) As Int";
dbscrollview._totalcolumnwidth = RemoteObject.createNewArray ("int", new int[] {RemoteObject.solve(new RemoteObject[] {dbscrollview._numberofcolumns,RemoteObject.createImmutable(1)}, "+",1, 1).<Integer>get().intValue()}, new Object[]{});
 //BA.debugLineNum = 26;BA.debugLine="Dim ColumnName(NumberOfColumns) As String	' names";
dbscrollview._columnname = RemoteObject.createNewArray ("String", new int[] {dbscrollview._numberofcolumns.<Integer>get().intValue()}, new Object[]{});
 //BA.debugLineNum = 27;BA.debugLine="ColumnName(0) = \"ID\"";
dbscrollview._columnname.setArrayElement (BA.ObjectToString("ID"),BA.numberCast(int.class, 0));
 //BA.debugLineNum = 28;BA.debugLine="ColumnName(1) = \"FirstName\"";
dbscrollview._columnname.setArrayElement (BA.ObjectToString("FirstName"),BA.numberCast(int.class, 1));
 //BA.debugLineNum = 29;BA.debugLine="ColumnName(2) = \"LastName\"";
dbscrollview._columnname.setArrayElement (BA.ObjectToString("LastName"),BA.numberCast(int.class, 2));
 //BA.debugLineNum = 30;BA.debugLine="ColumnName(3) = \"Address\"";
dbscrollview._columnname.setArrayElement (BA.ObjectToString("Address"),BA.numberCast(int.class, 3));
 //BA.debugLineNum = 31;BA.debugLine="ColumnName(4) = \"City\"";
dbscrollview._columnname.setArrayElement (BA.ObjectToString("City"),BA.numberCast(int.class, 4));
 //BA.debugLineNum = 34;BA.debugLine="Dim HeaderColor As Int					: HeaderColor = Colors";
dbscrollview._headercolor = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 34;BA.debugLine="Dim HeaderColor As Int					: HeaderColor = Colors";
dbscrollview._headercolor = dbscrollview.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue");
 //BA.debugLineNum = 35;BA.debugLine="Dim HeaderFontColor As Int			: HeaderFontColor =";
dbscrollview._headerfontcolor = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 35;BA.debugLine="Dim HeaderFontColor As Int			: HeaderFontColor =";
dbscrollview._headerfontcolor = dbscrollview.mostCurrent.__c.getField(false,"Colors").getField(true,"Yellow");
 //BA.debugLineNum = 36;BA.debugLine="Dim HeaderLineColor As Int			: HeaderLineColor =";
dbscrollview._headerlinecolor = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 36;BA.debugLine="Dim HeaderLineColor As Int			: HeaderLineColor =";
dbscrollview._headerlinecolor = dbscrollview.mostCurrent.__c.getField(false,"Colors").getField(true,"Yellow");
 //BA.debugLineNum = 37;BA.debugLine="Dim CellColor As Int						: CellColor = Colors.RG";
dbscrollview._cellcolor = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 37;BA.debugLine="Dim CellColor As Int						: CellColor = Colors.RG";
dbscrollview._cellcolor = dbscrollview.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 220)));
 //BA.debugLineNum = 38;BA.debugLine="Dim FontColor As Int						: FontColor = Colors.Bl";
dbscrollview._fontcolor = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 38;BA.debugLine="Dim FontColor As Int						: FontColor = Colors.Bl";
dbscrollview._fontcolor = dbscrollview.mostCurrent.__c.getField(false,"Colors").getField(true,"Black");
 //BA.debugLineNum = 39;BA.debugLine="Dim FontSize As Float						: FontSize = 14";
dbscrollview._fontsize = RemoteObject.createImmutable(0f);
 //BA.debugLineNum = 39;BA.debugLine="Dim FontSize As Float						: FontSize = 14";
dbscrollview._fontsize = BA.numberCast(float.class, 14);
 //BA.debugLineNum = 40;BA.debugLine="Dim Alignment As Int						: Alignment = Gravity.C";
dbscrollview._alignment = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 40;BA.debugLine="Dim Alignment As Int						: Alignment = Gravity.C";
dbscrollview._alignment = dbscrollview.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER");
 //BA.debugLineNum = 42;BA.debugLine="Type RowCol (Row As Int, Col As Int)";
;
 //BA.debugLineNum = 44;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _scvpersons_scrollchanged(RemoteObject _posx,RemoteObject _posy) throws Exception{
try {
		Debug.PushSubsStack("scvPersons_ScrollChanged (dbscrollview) ","dbscrollview",6,dbscrollview.mostCurrent.activityBA,dbscrollview.mostCurrent,164);
if (RapidSub.canDelegate("scvpersons_scrollchanged")) return b4a.AutoScaleExample7.dbscrollview.remoteMe.runUserSub(false, "dbscrollview","scvpersons_scrollchanged", _posx, _posy);
Debug.locals.put("PosX", _posx);
Debug.locals.put("PosY", _posy);
 BA.debugLineNum = 164;BA.debugLine="Sub scvPersons_ScrollChanged(PosX As Int, PosY As";
Debug.ShouldStop(8);
 BA.debugLineNum = 165;BA.debugLine="pnlHeader.Left = -PosX";
Debug.ShouldStop(16);
dbscrollview.mostCurrent._pnlheader.runMethod(true,"setLeft",BA.numberCast(int.class, -(double) (0 + _posx.<Integer>get().intValue())));
 BA.debugLineNum = 166;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setheader(RemoteObject _values) throws Exception{
try {
		Debug.PushSubsStack("SetHeader (dbscrollview) ","dbscrollview",6,dbscrollview.mostCurrent.activityBA,dbscrollview.mostCurrent,141);
if (RapidSub.canDelegate("setheader")) return b4a.AutoScaleExample7.dbscrollview.remoteMe.runUserSub(false, "dbscrollview","setheader", _values);
int _i = 0;
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("Values", _values);
 BA.debugLineNum = 141;BA.debugLine="Sub SetHeader(Values() As String)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 143;BA.debugLine="If pnlHeader.IsInitialized Then 'should only be c";
Debug.ShouldStop(16384);
if (dbscrollview.mostCurrent._pnlheader.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 144;BA.debugLine="Return";
Debug.ShouldStop(32768);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 147;BA.debugLine="pnlHeader.Initialize(\"\")";
Debug.ShouldStop(262144);
dbscrollview.mostCurrent._pnlheader.runVoidMethod ("Initialize",dbscrollview.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 148;BA.debugLine="pnlHeader.Color = HeaderLineColor";
Debug.ShouldStop(524288);
dbscrollview.mostCurrent._pnlheader.runVoidMethod ("setColor",dbscrollview._headerlinecolor);
 BA.debugLineNum = 150;BA.debugLine="For i = 0 To NumberOfColumns - 1";
Debug.ShouldStop(2097152);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {dbscrollview._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 151;BA.debugLine="Dim l As Label";
Debug.ShouldStop(4194304);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("l", _l);
 BA.debugLineNum = 152;BA.debugLine="l.Initialize(\"Header\")";
Debug.ShouldStop(8388608);
_l.runVoidMethod ("Initialize",dbscrollview.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("Header")));
 BA.debugLineNum = 153;BA.debugLine="l.Text = Values(i)";
Debug.ShouldStop(16777216);
_l.runMethod(true,"setText",BA.ObjectToCharSequence(_values.getArrayElement(true,BA.numberCast(int.class, _i))));
 BA.debugLineNum = 154;BA.debugLine="l.Gravity = Gravity.CENTER";
Debug.ShouldStop(33554432);
_l.runMethod(true,"setGravity",dbscrollview.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER"));
 BA.debugLineNum = 155;BA.debugLine="l.TextSize = FontSize";
Debug.ShouldStop(67108864);
_l.runMethod(true,"setTextSize",dbscrollview._fontsize);
 BA.debugLineNum = 156;BA.debugLine="l.Color = HeaderColor";
Debug.ShouldStop(134217728);
_l.runVoidMethod ("setColor",dbscrollview._headercolor);
 BA.debugLineNum = 157;BA.debugLine="l.TextColor = HeaderFontColor";
Debug.ShouldStop(268435456);
_l.runMethod(true,"setTextColor",dbscrollview._headerfontcolor);
 BA.debugLineNum = 158;BA.debugLine="l.Tag = i";
Debug.ShouldStop(536870912);
_l.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 159;BA.debugLine="pnlHeader.AddView(l, TotalColumnWidth(i), 0, Col";
Debug.ShouldStop(1073741824);
dbscrollview.mostCurrent._pnlheader.runVoidMethod ("AddView",(Object)((_l.getObject())),(Object)(dbscrollview._totalcolumnwidth.getArrayElement(true,BA.numberCast(int.class, _i))),(Object)(BA.numberCast(int.class, 0)),(Object)(dbscrollview._columnwidth_1.getArrayElement(true,BA.numberCast(int.class, _i))),(Object)(dbscrollview._rowheight_1));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 161;BA.debugLine="Activity.AddView(pnlHeader, scvPersons.Left, 0, T";
Debug.ShouldStop(1);
dbscrollview.mostCurrent._activity.runVoidMethod ("AddView",(Object)((dbscrollview.mostCurrent._pnlheader.getObject())),(Object)(dbscrollview.mostCurrent._scvpersons.runMethod(true,"getLeft")),(Object)(BA.numberCast(int.class, 0)),(Object)(dbscrollview._totalcolumnwidth.getArrayElement(true,dbscrollview._numberofcolumns)),(Object)(dbscrollview._rowheight));
 BA.debugLineNum = 162;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sqltableread() throws Exception{
try {
		Debug.PushSubsStack("SQLTableRead (dbscrollview) ","dbscrollview",6,dbscrollview.mostCurrent.activityBA,dbscrollview.mostCurrent,89);
if (RapidSub.canDelegate("sqltableread")) return b4a.AutoScaleExample7.dbscrollview.remoteMe.runUserSub(false, "dbscrollview","sqltableread");
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _txt = RemoteObject.createImmutable("");
RemoteObject _col = null;
int _j = 0;
 BA.debugLineNum = 89;BA.debugLine="Sub SQLTableRead";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 91;BA.debugLine="Dim i As Int";
Debug.ShouldStop(67108864);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 92;BA.debugLine="Dim Cursor1 As Cursor";
Debug.ShouldStop(134217728);
_cursor1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");Debug.locals.put("Cursor1", _cursor1);
 BA.debugLineNum = 93;BA.debugLine="Dim txt As String";
Debug.ShouldStop(268435456);
_txt = RemoteObject.createImmutable("");Debug.locals.put("txt", _txt);
 BA.debugLineNum = 95;BA.debugLine="txt = \"SELECT * FROM \" & Main.DBTableName";
Debug.ShouldStop(1073741824);
_txt = RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM "),dbscrollview.mostCurrent._main._dbtablename);Debug.locals.put("txt", _txt);
 BA.debugLineNum = 97;BA.debugLine="Cursor1 = Main.SQL1.ExecQuery(txt)";
Debug.ShouldStop(1);
_cursor1.setObject(dbscrollview.mostCurrent._main._sql1.runMethod(false,"ExecQuery",(Object)(_txt)));
 BA.debugLineNum = 99;BA.debugLine="Dim Col(NumberOfColumns) As String";
Debug.ShouldStop(4);
_col = RemoteObject.createNewArray ("String", new int[] {dbscrollview._numberofcolumns.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("Col", _col);
 BA.debugLineNum = 101;BA.debugLine="SetHeader(ColumnName)";
Debug.ShouldStop(16);
_setheader(dbscrollview._columnname);
 BA.debugLineNum = 102;BA.debugLine="NumberOfRows = 0";
Debug.ShouldStop(32);
dbscrollview._numberofrows = BA.numberCast(int.class, 0);
 BA.debugLineNum = 104;BA.debugLine="For i = 0 To Cursor1.RowCount - 1";
Debug.ShouldStop(128);
{
final int step9 = 1;
final int limit9 = RemoteObject.solve(new RemoteObject[] {_cursor1.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
for (;(step9 > 0 && _i.<Integer>get().intValue() <= limit9) || (step9 < 0 && _i.<Integer>get().intValue() >= limit9) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step9))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 105;BA.debugLine="Dim Col(NumberOfColumns) As String";
Debug.ShouldStop(256);
_col = RemoteObject.createNewArray ("String", new int[] {dbscrollview._numberofcolumns.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("Col", _col);
 BA.debugLineNum = 106;BA.debugLine="Cursor1.Position = i";
Debug.ShouldStop(512);
_cursor1.runMethod(true,"setPosition",_i);
 BA.debugLineNum = 107;BA.debugLine="For j = 0 To NumberOfColumns - 1";
Debug.ShouldStop(1024);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {dbscrollview._numberofcolumns,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_j = 0 ;
for (;(step12 > 0 && _j <= limit12) || (step12 < 0 && _j >= limit12) ;_j = ((int)(0 + _j + step12))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 108;BA.debugLine="Col(j) = Cursor1.GetString(ColumnName(j))";
Debug.ShouldStop(2048);
_col.setArrayElement (_cursor1.runMethod(true,"GetString",(Object)(dbscrollview._columnname.getArrayElement(true,BA.numberCast(int.class, _j)))),BA.numberCast(int.class, _j));
 }
}Debug.locals.put("j", _j);
;
 BA.debugLineNum = 110;BA.debugLine="AddRow(Col)";
Debug.ShouldStop(8192);
_addrow(_col);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 112;BA.debugLine="Cursor1.Close";
Debug.ShouldStop(32768);
_cursor1.runVoidMethod ("Close");
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}