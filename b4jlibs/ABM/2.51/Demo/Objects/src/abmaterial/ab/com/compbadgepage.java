package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compbadgepage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compbadgepage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compbadgepage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4j.object.WebSocket _ws = null;
public com.ab.abmaterial.ABMPage _page = null;
public com.ab.abmaterial.ABMTheme _theme = null;
public com.ab.abmaterial.ABMaterial _abm = null;
public String _name = "";
public String _abmpageid = "";
public int _mytoastid = 0;
public int _newmsg = 0;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _btn1_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMList _list1 = null;
com.ab.abmaterial.ABMContainer _cont = null;
com.ab.abmaterial.ABMBadge _badge = null;
 //BA.debugLineNum = 281;BA.debugLine="Sub btn1_Clicked(Target As String)";
 //BA.debugLineNum = 283;BA.debugLine="Dim list1 As ABMList = page.Component(\"List1\")";
_list1 = (com.ab.abmaterial.ABMList)(_page.Component("List1"));
 //BA.debugLineNum = 285;BA.debugLine="Dim cont As ABMContainer = list1.Item(\"S3\")";
_cont = (com.ab.abmaterial.ABMContainer)(_list1.Item("S3"));
 //BA.debugLineNum = 287;BA.debugLine="Dim badge As ABMBadge = cont.Component(\"S3Badge\")";
_badge = (com.ab.abmaterial.ABMBadge)(_cont.Component("S3Badge"));
 //BA.debugLineNum = 288;BA.debugLine="badge.IsNew = True";
_badge.IsNew = __c.True;
 //BA.debugLineNum = 289;BA.debugLine="NewMsg = NewMsg + 1";
_newmsg = (int) (_newmsg+1);
 //BA.debugLineNum = 290;BA.debugLine="badge.Text = NewMsg";
_badge.Text = BA.NumberToString(_newmsg);
 //BA.debugLineNum = 291;BA.debugLine="badge.Refresh ' IMPORTANT";
_badge.Refresh();
 //BA.debugLineNum = 292;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMContainer  _builditem(String _id,String _text,String _messages,boolean _isnew) throws Exception{
com.ab.abmaterial.ABMContainer _itemcont = null;
com.ab.abmaterial.ABMLabel _lbl = null;
com.ab.abmaterial.ABMBadge _badge = null;
 //BA.debugLineNum = 241;BA.debugLine="Sub BuildItem(id As String, text As String, messag";
 //BA.debugLineNum = 242;BA.debugLine="Dim ItemCont As ABMContainer";
_itemcont = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 243;BA.debugLine="ItemCont.Initialize(page, id, \"\")";
_itemcont.Initialize(_page,_id,"");
 //BA.debugLineNum = 244;BA.debugLine="ItemCont.AddRowsM(1,False,0,0, \"\").AddCellsOSMP(1";
_itemcont.AddRowsM((int) (1),__c.False,(int) (0),(int) (0),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (10),(int) (10),(int) (10),(int) (6),(int) (0),(int) (0),(int) (0),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (2),(int) (2),(int) (2),(int) (6),(int) (0),(int) (0),(int) (0),"");
 //BA.debugLineNum = 245;BA.debugLine="ItemCont.BuildGrid 'IMPORTANT once you loaded the";
_itemcont.BuildGrid();
 //BA.debugLineNum = 247;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 248;BA.debugLine="lbl.Initialize(page, id & \"lbl\", text, ABM.SIZE_P";
_lbl.Initialize(_page,_id+"lbl",_text,_abm.SIZE_PARAGRAPH,__c.False,"");
 //BA.debugLineNum = 249;BA.debugLine="ItemCont.Cell(1,1).AddComponent(lbl)";
_itemcont.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl));
 //BA.debugLineNum = 251;BA.debugLine="Dim badge As ABMBadge";
_badge = new com.ab.abmaterial.ABMBadge();
 //BA.debugLineNum = 252;BA.debugLine="badge.Initialize(page, id & \"badge\", messages, is";
_badge.Initialize(_page,_id+"badge",_messages,_isnew,"");
 //BA.debugLineNum = 253;BA.debugLine="ItemCont.Cell(1,2).AddComponent(badge)";
_itemcont.Cell((int) (1),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_badge));
 //BA.debugLineNum = 255;BA.debugLine="Return ItemCont";
if (true) return _itemcont;
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
return null;
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 102;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 105;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 106;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 107;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 108;BA.debugLine="page.PageTitle = \"ABMBadge\"";
_page.PageTitle = "ABMBadge";
 //BA.debugLineNum = 109;BA.debugLine="page.PageDescription = \"The badge component \"";
_page.PageDescription = "The badge component ";
 //BA.debugLineNum = 110;BA.debugLine="page.PageHTMLName = \"abmaterial-badge.html\"";
_page.PageHTMLName = "abmaterial-badge.html";
 //BA.debugLineNum = 111;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 112;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 113;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 114;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 116;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMBadge\", \".";
_abmshared._buildnavigationbar(_page,"ABMBadge","../images/logo.png","","Controls","ABMBadge");
 //BA.debugLineNum = 119;BA.debugLine="page.AddRows(9,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (9),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 120;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 125;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 90;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 91;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 95;BA.debugLine="theme.AddButtonTheme(\"bluegrey\")";
_theme.AddButtonTheme("bluegrey");
 //BA.debugLineNum = 96;BA.debugLine="theme.Button(\"bluegrey\").BackColor = ABM.COLOR_BL";
_theme.Button("bluegrey").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 97;BA.debugLine="theme.Button(\"bluegrey\").BackColorIntensity = ABM";
_theme.Button("bluegrey").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private ws As WebSocket 'ignore";
_ws = new anywheresoftware.b4j.object.WebSocket();
 //BA.debugLineNum = 5;BA.debugLine="Public page As ABMPage";
_page = new com.ab.abmaterial.ABMPage();
 //BA.debugLineNum = 7;BA.debugLine="Private theme As ABMTheme";
_theme = new com.ab.abmaterial.ABMTheme();
 //BA.debugLineNum = 9;BA.debugLine="Private ABM As ABMaterial 'ignore";
_abm = new com.ab.abmaterial.ABMaterial();
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompBadgePage\"";
_name = "CompBadgePage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="Dim NewMsg As Int";
_newmsg = 0;
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMList _list1 = null;
com.ab.abmaterial.ABMButton _btn1 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code1 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code2 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code3 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code4 = null;
 //BA.debugLineNum = 128;BA.debugLine="public Sub ConnectPage()";
 //BA.debugLineNum = 130;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 133;BA.debugLine="page.cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Badges can notify you that there are new or unread messages or notifications.")));
 //BA.debugLineNum = 136;BA.debugLine="Dim list1 As ABMList";
_list1 = new com.ab.abmaterial.ABMList();
 //BA.debugLineNum = 137;BA.debugLine="list1.Initialize(page, \"list1\", ABM.COLLAPSE_ACCO";
_list1.Initialize(_page,"list1",_abm.COLLAPSE_ACCORDION,"");
 //BA.debugLineNum = 140;BA.debugLine="list1.AddItem(\"S1\", BuildItem(\"S1\", \"Mom\", \"2\", F";
_list1.AddItem("S1",(com.ab.abmaterial.ABMComponent)(_builditem("S1","Mom","2",__c.False)));
 //BA.debugLineNum = 141;BA.debugLine="list1.AddItem(\"S2\", BuildItem(\"S2\", \"Dad\", \"7\", T";
_list1.AddItem("S2",(com.ab.abmaterial.ABMComponent)(_builditem("S2","Dad","7",__c.True)));
 //BA.debugLineNum = 142;BA.debugLine="list1.AddItem(\"S3\", BuildItem(\"S3\", \"Brother\", \"\"";
_list1.AddItem("S3",(com.ab.abmaterial.ABMComponent)(_builditem("S3","Brother","",__c.False)));
 //BA.debugLineNum = 143;BA.debugLine="list1.AddItem(\"S4\", BuildItem(\"S4\", \"Sister\", \"3\"";
_list1.AddItem("S4",(com.ab.abmaterial.ABMComponent)(_builditem("S4","Sister","3",__c.False)));
 //BA.debugLineNum = 145;BA.debugLine="page.Cell(2,1).AddComponent(list1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_list1));
 //BA.debugLineNum = 148;BA.debugLine="page.cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","Click on the list item to 'read' the messages.  You'll notice the badge changing from 'new' to 'normal' state. Click on the button below to add 'new' messages to Brother.  You'll notice the badge state changing from 'normal' to 'new'.")));
 //BA.debugLineNum = 151;BA.debugLine="Dim btn1 As ABMButton";
_btn1 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 152;BA.debugLine="btn1.InitializeRaised(page, \"btn1\", \"\", \"\", \"Add";
_btn1.InitializeRaised(_page,"btn1","","","Add message to brother","bluegrey");
 //BA.debugLineNum = 153;BA.debugLine="page.Cell(4,1).AddComponent(btn1)";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn1));
 //BA.debugLineNum = 156;BA.debugLine="Dim code1 As StringBuilder";
_code1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 157;BA.debugLine="code1.Initialize";
_code1.Initialize();
 //BA.debugLineNum = 158;BA.debugLine="code1.Append(\"// create list\").Append(CRLF)";
_code1.Append("// create list").Append(__c.CRLF);
 //BA.debugLineNum = 159;BA.debugLine="code1.Append(\"Dim list1 As ABMList\").Append(CRLF)";
_code1.Append("Dim list1 As ABMList").Append(__c.CRLF);
 //BA.debugLineNum = 160;BA.debugLine="code1.Append(\"list1.Initialize(page, \"\"list1\"\", A";
_code1.Append("list1.Initialize(page, \"list1\", ABM.COLLAPSE_ACCORDION, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 161;BA.debugLine="code1.Append(\"\").Append(CRLF)";
_code1.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 162;BA.debugLine="code1.Append(\"// add items\").Append(CRLF)";
_code1.Append("// add items").Append(__c.CRLF);
 //BA.debugLineNum = 163;BA.debugLine="code1.Append(\"list1.AddItem(\"\"S1\"\", BuildItem(\"\"S";
_code1.Append("list1.AddItem(\"S1\", BuildItem(\"S1\", \"Mom\", \"2\", False))").Append(__c.CRLF);
 //BA.debugLineNum = 164;BA.debugLine="code1.Append(\"list1.AddItem(\"\"S2\"\", BuildItem(\"\"S";
_code1.Append("list1.AddItem(\"S2\", BuildItem(\"S2\", \"Dad\", \"7\", True))").Append(__c.CRLF);
 //BA.debugLineNum = 165;BA.debugLine="code1.Append(\"list1.AddItem(\"\"S3\"\", BuildItem(\"\"S";
_code1.Append("list1.AddItem(\"S3\", BuildItem(\"S3\", \"Brother\", \"\", False))").Append(__c.CRLF);
 //BA.debugLineNum = 166;BA.debugLine="code1.Append(\"list1.AddItem(\"\"S4\"\", BuildItem(\"\"S";
_code1.Append("list1.AddItem(\"S4\", BuildItem(\"S4\", \"Sister\", \"3\", False))").Append(__c.CRLF);
 //BA.debugLineNum = 168;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code1",_code1)));
 //BA.debugLineNum = 171;BA.debugLine="Dim code2 As StringBuilder";
_code2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 172;BA.debugLine="code2.Initialize";
_code2.Initialize();
 //BA.debugLineNum = 173;BA.debugLine="code2.Append(\"Sub BuildItem(id As String, text As";
_code2.Append("Sub BuildItem(id As String, text As String, messages As String, isnew As Boolean) As ABMContainer").Append(__c.CRLF);
 //BA.debugLineNum = 174;BA.debugLine="code2.Append(\"   Dim ItemCont As ABMContainer\").A";
_code2.Append("   Dim ItemCont As ABMContainer").Append(__c.CRLF);
 //BA.debugLineNum = 175;BA.debugLine="code2.Append(\"   ItemCont.Initialize(page, id, \"\"";
_code2.Append("   ItemCont.Initialize(page, id, \")	").Append(__c.CRLF);
 //BA.debugLineNum = 176;BA.debugLine="code2.Append(\"   ItemCont.AddRowsM(1,False,0,0, \"";
_code2.Append("   ItemCont.AddRowsM(1,False,0,0, \").AddCellsOSMP(1,0,0,0,10,10,10,6,0,0,0,\").AddCellsOSMP(1,0,0,0,2,2,2,6,0,0,0,\")").Append(__c.CRLF);
 //BA.debugLineNum = 177;BA.debugLine="code2.Append(\"   ItemCont.BuildGrid //IMPORTANT o";
_code2.Append("   ItemCont.BuildGrid //IMPORTANT once you loaded the complete grid AND before you start adding components").Append(__c.CRLF);
 //BA.debugLineNum = 178;BA.debugLine="code2.Append(\"\").Append(CRLF)";
_code2.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 179;BA.debugLine="code2.Append(\"   Dim lbl As ABMLabel\").Append(CRL";
_code2.Append("   Dim lbl As ABMLabel").Append(__c.CRLF);
 //BA.debugLineNum = 180;BA.debugLine="code2.Append(\"   lbl.Initialize(page, id & \"\"lbl\"";
_code2.Append("   lbl.Initialize(page, id & \"lbl\", text, ABM.SIZE_PARAGRAPH, False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 181;BA.debugLine="code2.Append(\"   ItemCont.Cell(1,1).AddComponent(";
_code2.Append("   ItemCont.Cell(1,1).AddComponent(lbl)").Append(__c.CRLF);
 //BA.debugLineNum = 182;BA.debugLine="code2.Append(\"\").Append(CRLF)";
_code2.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 183;BA.debugLine="code2.Append(\"   Dim badge As ABMBadge\").Append(C";
_code2.Append("   Dim badge As ABMBadge").Append(__c.CRLF);
 //BA.debugLineNum = 184;BA.debugLine="code2.Append(\"   badge.Initialize(page, id & \"\"ba";
_code2.Append("   badge.Initialize(page, id & \"badge\", messages, isnew, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 185;BA.debugLine="code2.Append(\"   ItemCont.Cell(1,2).AddComponent(";
_code2.Append("   ItemCont.Cell(1,2).AddComponent(badge)").Append(__c.CRLF);
 //BA.debugLineNum = 186;BA.debugLine="code2.Append(\"\").Append(CRLF)";
_code2.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 187;BA.debugLine="code2.Append(\"   Return ItemCont\").Append(CRLF)";
_code2.Append("   Return ItemCont").Append(__c.CRLF);
 //BA.debugLineNum = 188;BA.debugLine="code2.Append(\"End Sub\").Append(CRLF)";
_code2.Append("End Sub").Append(__c.CRLF);
 //BA.debugLineNum = 190;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code2",_code2)));
 //BA.debugLineNum = 193;BA.debugLine="page.cell(7,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","The events when someone clicks on the list item to 'read' the messages and the button code to add a new message to brother.")));
 //BA.debugLineNum = 196;BA.debugLine="Dim code3 As StringBuilder";
_code3 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 197;BA.debugLine="code3.Initialize";
_code3.Initialize();
 //BA.debugLineNum = 198;BA.debugLine="code3.Append(\"Sub list1_Clicked(ItemId As String)";
_code3.Append("Sub list1_Clicked(ItemId As String)").Append(__c.CRLF);
 //BA.debugLineNum = 199;BA.debugLine="code3.Append(\"   // get the list component from t";
_code3.Append("   // get the list component from the page").Append(__c.CRLF);
 //BA.debugLineNum = 200;BA.debugLine="code3.Append(\"   Dim list1 As ABMList = page.Comp";
_code3.Append("   Dim list1 As ABMList = page.Component(\"List1\")").Append(__c.CRLF);
 //BA.debugLineNum = 201;BA.debugLine="code3.Append(\"   // get the item\").Append(CRLF)";
_code3.Append("   // get the item").Append(__c.CRLF);
 //BA.debugLineNum = 202;BA.debugLine="code3.Append(\"   Dim cont As ABMContainer = list1";
_code3.Append("   Dim cont As ABMContainer = list1.Item(ItemId)").Append(__c.CRLF);
 //BA.debugLineNum = 203;BA.debugLine="code3.Append(\"   // get the badge control\").Appen";
_code3.Append("   // get the badge control").Append(__c.CRLF);
 //BA.debugLineNum = 204;BA.debugLine="code3.Append(\"   Dim badge As ABMBadge = cont.Com";
_code3.Append("   Dim badge As ABMBadge = cont.Component(ItemId & \"Badge\")").Append(__c.CRLF);
 //BA.debugLineNum = 205;BA.debugLine="code3.Append(\"   badge.IsNew = False	\").Append(CR";
_code3.Append("   badge.IsNew = False	").Append(__c.CRLF);
 //BA.debugLineNum = 206;BA.debugLine="code3.Append(\"\").Append(CRLF)";
_code3.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 207;BA.debugLine="code3.Append(\"   badge.Refresh ' IMPORTANT\").Appe";
_code3.Append("   badge.Refresh ' IMPORTANT").Append(__c.CRLF);
 //BA.debugLineNum = 208;BA.debugLine="code3.Append(\"End Sub\").Append(CRLF)";
_code3.Append("End Sub").Append(__c.CRLF);
 //BA.debugLineNum = 210;BA.debugLine="page.Cell(8,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code3",_code3)));
 //BA.debugLineNum = 213;BA.debugLine="Dim code4 As StringBuilder";
_code4 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 214;BA.debugLine="code4.Initialize";
_code4.Initialize();
 //BA.debugLineNum = 215;BA.debugLine="code4.Append(\"Sub btn1_Clicked(Target As String)\"";
_code4.Append("Sub btn1_Clicked(Target As String)").Append(__c.CRLF);
 //BA.debugLineNum = 216;BA.debugLine="code4.Append(\"   // get the list component from t";
_code4.Append("   // get the list component from the page").Append(__c.CRLF);
 //BA.debugLineNum = 217;BA.debugLine="code4.Append(\"   Dim list1 As ABMList = page.Comp";
_code4.Append("   Dim list1 As ABMList = page.Component(\"List1\")").Append(__c.CRLF);
 //BA.debugLineNum = 218;BA.debugLine="code4.Append(\"   // get the third item (brother)\"";
_code4.Append("   // get the third item (brother)").Append(__c.CRLF);
 //BA.debugLineNum = 219;BA.debugLine="code4.Append(\"   Dim cont As ABMContainer = list1";
_code4.Append("   Dim cont As ABMContainer = list1.Item(\"S3\")").Append(__c.CRLF);
 //BA.debugLineNum = 220;BA.debugLine="code4.Append(\"   // get the badge control\").Appen";
_code4.Append("   // get the badge control").Append(__c.CRLF);
 //BA.debugLineNum = 221;BA.debugLine="code4.Append(\"   Dim badge As ABMBadge = cont.Com";
_code4.Append("   Dim badge As ABMBadge = cont.Component(\"S3Badge\")").Append(__c.CRLF);
 //BA.debugLineNum = 222;BA.debugLine="code4.Append(\"   badge.IsNew = True\").Append(CRLF";
_code4.Append("   badge.IsNew = True").Append(__c.CRLF);
 //BA.debugLineNum = 223;BA.debugLine="code4.Append(\"   NewMsg = NewMsg + 1\").Append(CRL";
_code4.Append("   NewMsg = NewMsg + 1").Append(__c.CRLF);
 //BA.debugLineNum = 224;BA.debugLine="code4.Append(\"   badge.Text = NewMsg\").Append(CRL";
_code4.Append("   badge.Text = NewMsg").Append(__c.CRLF);
 //BA.debugLineNum = 225;BA.debugLine="code4.Append(\"   badge.Refresh ' IMPORTANT\").Appe";
_code4.Append("   badge.Refresh ' IMPORTANT").Append(__c.CRLF);
 //BA.debugLineNum = 226;BA.debugLine="code4.Append(\"End Sub\").Append(CRLF)";
_code4.Append("End Sub").Append(__c.CRLF);
 //BA.debugLineNum = 228;BA.debugLine="page.Cell(9,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code4",_code4)));
 //BA.debugLineNum = 231;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 233;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 236;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 238;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 239;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 21;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 23;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public String  _list1_clicked(String _itemid) throws Exception{
com.ab.abmaterial.ABMList _list1 = null;
com.ab.abmaterial.ABMContainer _cont = null;
com.ab.abmaterial.ABMBadge _badge = null;
 //BA.debugLineNum = 294;BA.debugLine="Sub list1_Clicked(ItemId As String)";
 //BA.debugLineNum = 296;BA.debugLine="Dim list1 As ABMList = page.Component(\"List1\")";
_list1 = (com.ab.abmaterial.ABMList)(_page.Component("List1"));
 //BA.debugLineNum = 298;BA.debugLine="Dim cont As ABMContainer = list1.Item(ItemId)";
_cont = (com.ab.abmaterial.ABMContainer)(_list1.Item(_itemid));
 //BA.debugLineNum = 300;BA.debugLine="Dim badge As ABMBadge = cont.Component(ItemId & \"";
_badge = (com.ab.abmaterial.ABMBadge)(_cont.Component(_itemid+"Badge"));
 //BA.debugLineNum = 301;BA.debugLine="badge.IsNew = False";
_badge.IsNew = __c.False;
 //BA.debugLineNum = 303;BA.debugLine="badge.Refresh ' IMPORTANT";
_badge.Refresh();
 //BA.debugLineNum = 304;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 259;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 260;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 261;BA.debugLine="If Action = \"ABMBadge\" Then Return";
if ((_action).equals("ABMBadge")) { 
if (true) return "";};
 //BA.debugLineNum = 262;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 263;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 264;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 265;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 267;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 268;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 269;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 271;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 272;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 58;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 59;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 60;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 61;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 62;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 63;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 64;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 66;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 67;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 68;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 69;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 71;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 73;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 75;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 76;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 77;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 79;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 83;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 274;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 275;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 276;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 277;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 278;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 279;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 26;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 27;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 28;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 29;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 30;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 32;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 33;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 34;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 35;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 39;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 40;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 42;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 44;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 47;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 49;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 51;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 55;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
