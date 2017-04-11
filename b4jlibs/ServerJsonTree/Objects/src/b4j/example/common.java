package b4j.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class common extends Object{
public static common mostCurrent = new common();

public static BA ba;
static {
		ba = new  anywheresoftware.b4a.StandardBA("b4j.example", "b4j.example.common", null);
		ba.loadHtSubs(common.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.common", ba);
		}
	}
    public static Class<?> getObject() {
		return common.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static b4j.example.main _main = null;
public static class _treeitem{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.collections.List Children;
public String Text;
public void Initialize() {
IsInitialized = true;
Children = new anywheresoftware.b4a.objects.collections.List();
Text = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _caller{
public boolean IsInitialized;
public Object element;
public b4j.example.common._treeitem parent;
public anywheresoftware.b4a.keywords.StringBuilderWrapper code;
public String parentName;
public String GetFromMap;
public boolean BuildList;
public String indent;
public void Initialize() {
IsInitialized = true;
element = new Object();
parent = new b4j.example.common._treeitem();
code = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
parentName = "";
GetFromMap = "";
BuildList = false;
indent = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _parsejsoobj{
public boolean IsInitialized;
public Object obj;
public Object par;
public void Initialize() {
IsInitialized = true;
obj = new Object();
par = new Object();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Type TreeItem (Children As List, Text As String)";
;
 //BA.debugLineNum = 4;BA.debugLine="Type caller(element As Object, parent As TreeItem";
;
 //BA.debugLineNum = 6;BA.debugLine="Type parseJSOOBJ(obj As Object,par As Object)";
;
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
}
