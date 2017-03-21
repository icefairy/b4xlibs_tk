package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class complistpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.complistpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.complistpage.class).invoke(this, new Object[] {null});
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
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public com.ab.abmaterial.ABMCard  _builditem(String _id,String _image,String _title) throws Exception{
com.ab.abmaterial.ABMCard _card4 = null;
 //BA.debugLineNum = 321;BA.debugLine="Sub BuildItem(id As String, image As String, title";
 //BA.debugLineNum = 323;BA.debugLine="Dim card4 As ABMCard";
_card4 = new com.ab.abmaterial.ABMCard();
 //BA.debugLineNum = 324;BA.debugLine="card4.InitializeAsCard(page, \"card4\", title, \"Thi";
_card4.InitializeAsCard(_page,"card4",_title,"This is my card content...",_abm.CARD_NOTSPECIFIED,"whitetitle");
 //BA.debugLineNum = 325;BA.debugLine="card4.Image = image";
_card4.Image = _image;
 //BA.debugLineNum = 326;BA.debugLine="Return card4";
if (true) return _card4;
 //BA.debugLineNum = 327;BA.debugLine="End Sub";
return null;
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 113;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 116;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 117;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 118;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 119;BA.debugLine="page.PageTitle = \"ABMList\"";
_page.PageTitle = "ABMList";
 //BA.debugLineNum = 120;BA.debugLine="page.PageDescription = \"The list component \"";
_page.PageDescription = "The list component ";
 //BA.debugLineNum = 121;BA.debugLine="page.PageHTMLName = \"abmaterial-list.html\"";
_page.PageHTMLName = "abmaterial-list.html";
 //BA.debugLineNum = 122;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 123;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 124;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 125;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 127;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMList\", \"..";
_abmshared._buildnavigationbar(_page,"ABMList","../images/logo.png","","Controls","ABMList");
 //BA.debugLineNum = 130;BA.debugLine="page.AddRows(8,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (8),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 131;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,12,6,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (6),(int) (6),"");
 //BA.debugLineNum = 132;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 137;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMLabel  _buildsimpleitem(String _id,String _icon,String _title) throws Exception{
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 308;BA.debugLine="Sub BuildSimpleItem(id As String, icon As String,";
 //BA.debugLineNum = 309;BA.debugLine="Dim lbl As ABMLabel";
_lbl = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 310;BA.debugLine="If icon <> \"\" Then";
if ((_icon).equals("") == false) { 
 //BA.debugLineNum = 311;BA.debugLine="lbl.Initialize(page, id, Title, ABM.SIZE_H6, Fal";
_lbl.Initialize(_page,_id,_title,_abm.SIZE_H6,__c.False,"header");
 }else {
 //BA.debugLineNum = 313;BA.debugLine="lbl.Initialize(page, id, Title, ABM.SIZE_H6, Tru";
_lbl.Initialize(_page,_id,_title,_abm.SIZE_H6,__c.True,"");
 };
 //BA.debugLineNum = 315;BA.debugLine="lbl.VerticalAlign = True";
_lbl.VerticalAlign = __c.True;
 //BA.debugLineNum = 316;BA.debugLine="lbl.IconName = icon";
_lbl.IconName = _icon;
 //BA.debugLineNum = 317;BA.debugLine="Return lbl";
if (true) return _lbl;
 //BA.debugLineNum = 318;BA.debugLine="End Sub";
return null;
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 93;BA.debugLine="theme.AddListTheme(\"list1theme\")";
_theme.AddListTheme("list1theme");
 //BA.debugLineNum = 94;BA.debugLine="theme.List(\"list1theme\").ItemBackColor = ABM.COLO";
_theme.List("list1theme").ItemBackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 95;BA.debugLine="theme.List(\"list1theme\").SubItemBackColor = ABM.C";
_theme.List("list1theme").SubItemBackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 96;BA.debugLine="theme.List(\"list1theme\").BackColor = ABM.COLOR_WH";
_theme.List("list1theme").BackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 98;BA.debugLine="theme.AddListTheme(\"list3theme\")";
_theme.AddListTheme("list3theme");
 //BA.debugLineNum = 99;BA.debugLine="theme.List(\"list3theme\").ItemBackColor = ABM.COLO";
_theme.List("list3theme").ItemBackColor = _abm.COLOR_LIME;
 //BA.debugLineNum = 100;BA.debugLine="theme.List(\"list3theme\").SubItemBackColor = ABM.C";
_theme.List("list3theme").SubItemBackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 101;BA.debugLine="theme.List(\"list3theme\").SubItemDividerColor = AB";
_theme.List("list3theme").SubItemDividerColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 102;BA.debugLine="theme.List(\"list3theme\").BackColor = ABM.COLOR_WH";
_theme.List("list3theme").BackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 104;BA.debugLine="theme.AddLabelTheme(\"header\")";
_theme.AddLabelTheme("header");
 //BA.debugLineNum = 105;BA.debugLine="theme.Label(\"header\").ForeColor = ABM.COLOR_BLACK";
_theme.Label("header").ForeColor = _abm.COLOR_BLACK;
 //BA.debugLineNum = 107;BA.debugLine="theme.AddCardTheme(\"whitetitle\")";
_theme.AddCardTheme("whitetitle");
 //BA.debugLineNum = 108;BA.debugLine="theme.Card(\"whitetitle\").TitleForeColor = ABM.COL";
_theme.Card("whitetitle").TitleForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompListPage\"";
_name = "CompListPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMList _list1 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code1 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code1a = null;
com.ab.abmaterial.ABMList _list2 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code2 = null;
com.ab.abmaterial.ABMList _list3 = null;
 //BA.debugLineNum = 140;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 142;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 145;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Lists allow you to group list objects together. The items are collapsibles that expand when clicked on. They allow you to hide content that is not immediately relevant to the user.")));
 //BA.debugLineNum = 148;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","In Page Lists")));
 //BA.debugLineNum = 151;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","In Page Lists are lists that grow inside your page.  They do not have a seperate scrollbar.")));
 //BA.debugLineNum = 154;BA.debugLine="Dim list1 As ABMList";
_list1 = new com.ab.abmaterial.ABMList();
 //BA.debugLineNum = 155;BA.debugLine="list1.Initialize(page, \"list1\", ABM.COLLAPSE_ACCO";
_list1.Initialize(_page,"list1",_abm.COLLAPSE_ACCORDION,"list1theme");
 //BA.debugLineNum = 158;BA.debugLine="list1.AddItem(\"H1\", BuildSimpleItem(\"L1H1\",\"mdi-a";
_list1.AddItem("H1",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H1","mdi-action-account-circle","Family")));
 //BA.debugLineNum = 159;BA.debugLine="list1.AddSubItem(\"H1\", \"S1\", BuildSimpleItem(\"L1H";
_list1.AddSubItem("H1","S1",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H1S1","","Mom")));
 //BA.debugLineNum = 160;BA.debugLine="list1.AddSubItem(\"H1\", \"S2\", BuildSimpleItem(\"L1H";
_list1.AddSubItem("H1","S2",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H1S2","","Dad")));
 //BA.debugLineNum = 161;BA.debugLine="list1.AddSubItem(\"H1\", \"S3\", BuildSimpleItem(\"L1H";
_list1.AddSubItem("H1","S3",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H1S3","","Brother")));
 //BA.debugLineNum = 162;BA.debugLine="list1.AddSubItem(\"H1\", \"S4\", BuildSimpleItem(\"L1H";
_list1.AddSubItem("H1","S4",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H1S4","","Sister")));
 //BA.debugLineNum = 163;BA.debugLine="list1.AddItem(\"H2\", BuildSimpleItem(\"L1H2\",\"mdi-a";
_list1.AddItem("H2",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H2","mdi-action-dashboard","Colleagues")));
 //BA.debugLineNum = 164;BA.debugLine="list1.AddSubItem(\"H2\", \"S5\", BuildSimpleItem(\"L1H";
_list1.AddSubItem("H2","S5",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H2S5","","Boss")));
 //BA.debugLineNum = 165;BA.debugLine="list1.AddSubItem(\"H2\", \"S6\", BuildSimpleItem(\"L1H";
_list1.AddSubItem("H2","S6",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H2S6","","Secretary")));
 //BA.debugLineNum = 166;BA.debugLine="list1.AddItem(\"H3\", BuildSimpleItem(\"L1H3\",\"mdi-e";
_list1.AddItem("H3",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H3","mdi-editor-border-all","Friends")));
 //BA.debugLineNum = 167;BA.debugLine="list1.AddSubItem(\"H3\", \"S7\", BuildSimpleItem(\"L1H";
_list1.AddSubItem("H3","S7",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H3S7","","Jean")));
 //BA.debugLineNum = 168;BA.debugLine="list1.AddSubItem(\"H3\", \"S8\", BuildSimpleItem(\"L1H";
_list1.AddSubItem("H3","S8",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H3S8","","Walter")));
 //BA.debugLineNum = 169;BA.debugLine="list1.AddSubItem(\"H3\", \"S9\", BuildSimpleItem(\"L1H";
_list1.AddSubItem("H3","S9",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H3S9","","Betty")));
 //BA.debugLineNum = 170;BA.debugLine="list1.AddSubItem(\"H3\", \"S10\", BuildSimpleItem(\"L1";
_list1.AddSubItem("H3","S10",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H3S10","","Thomas")));
 //BA.debugLineNum = 171;BA.debugLine="list1.AddSubItem(\"H3\", \"S11\", BuildSimpleItem(\"L1";
_list1.AddSubItem("H3","S11",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H3S11","","Jones")));
 //BA.debugLineNum = 172;BA.debugLine="list1.AddSubItem(\"H3\", \"S12\", BuildSimpleItem(\"L1";
_list1.AddSubItem("H3","S12",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H3S12","","Steven")));
 //BA.debugLineNum = 173;BA.debugLine="list1.AddSubItem(\"H3\", \"S13\", BuildSimpleItem(\"L1";
_list1.AddSubItem("H3","S13",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H3S13","","Andrea")));
 //BA.debugLineNum = 174;BA.debugLine="list1.AddSubItem(\"H3\", \"S14\", BuildSimpleItem(\"L1";
_list1.AddSubItem("H3","S14",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H3S14","","Julie")));
 //BA.debugLineNum = 175;BA.debugLine="list1.AddItem(\"H4\", BuildSimpleItem(\"L1H4\",\"mdi-e";
_list1.AddItem("H4",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H4","mdi-editor-border-all","Others")));
 //BA.debugLineNum = 177;BA.debugLine="page.Cell(2,1).AddComponent(list1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_list1));
 //BA.debugLineNum = 180;BA.debugLine="Dim code1 As StringBuilder";
_code1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 181;BA.debugLine="code1.Initialize";
_code1.Initialize();
 //BA.debugLineNum = 183;BA.debugLine="code1.Append(\"' create list\").Append(CRLF)";
_code1.Append("' create list").Append(__c.CRLF);
 //BA.debugLineNum = 184;BA.debugLine="code1.Append(\"Dim list1 As ABMList\").Append(CRLF)";
_code1.Append("Dim list1 As ABMList").Append(__c.CRLF);
 //BA.debugLineNum = 185;BA.debugLine="code1.Append(\"list1.Initialize(page, \"\"list1\"\", A";
_code1.Append("list1.Initialize(page, \"list1\", ABM.COLLAPSE_ACCORDION, \"list1theme\")").Append(__c.CRLF);
 //BA.debugLineNum = 186;BA.debugLine="code1.Append(\"\").Append(CRLF)";
_code1.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 187;BA.debugLine="code1.Append(\"' add items\").Append(CRLF)";
_code1.Append("' add items").Append(__c.CRLF);
 //BA.debugLineNum = 188;BA.debugLine="code1.Append(\"list1.AddItem(\"\"H1\"\", BuildSimpleIt";
_code1.Append("list1.AddItem(\"H1\", BuildSimpleItem(\"L1H1\",\"mdi-action-account-circle\",\"Family\"))").Append(__c.CRLF);
 //BA.debugLineNum = 189;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H1\"\", \"\"S1\"\", Bu";
_code1.Append("list1.AddSubItem(\"H1\", \"S1\", BuildSimpleItem(\"L1H1S1\",\"\", \"Mom\"))").Append(__c.CRLF);
 //BA.debugLineNum = 190;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H1\"\", \"\"S2\"\", Bu";
_code1.Append("list1.AddSubItem(\"H1\", \"S2\", BuildSimpleItem(\"L1H1S2\",\"\", \"Dad\"))").Append(__c.CRLF);
 //BA.debugLineNum = 191;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H1\"\", \"\"S3\"\", Bu";
_code1.Append("list1.AddSubItem(\"H1\", \"S3\", BuildSimpleItem(\"L1H1S3\",\"\", \"Brother\"))").Append(__c.CRLF);
 //BA.debugLineNum = 192;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H1\"\", \"\"S4\"\", Bu";
_code1.Append("list1.AddSubItem(\"H1\", \"S4\", BuildSimpleItem(\"L1H1S4\",\"\", \"Sister\"))").Append(__c.CRLF);
 //BA.debugLineNum = 193;BA.debugLine="code1.Append(\"list1.AddItem(\"\"H2\"\", BuildSimpleIt";
_code1.Append("list1.AddItem(\"H2\", BuildSimpleItem(\"L1H2\",\"mdi-action-dashboard\",\"Colleagues\"))").Append(__c.CRLF);
 //BA.debugLineNum = 194;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H2\"\", \"\"S5\"\", Bu";
_code1.Append("list1.AddSubItem(\"H2\", \"S5\", BuildSimpleItem(\"L1H2S5\",\"\", \"Boss\"))").Append(__c.CRLF);
 //BA.debugLineNum = 195;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H2\"\", \"\"S6\"\", Bu";
_code1.Append("list1.AddSubItem(\"H2\", \"S6\", BuildSimpleItem(\"L1H2S6\",\"\", \"Secretary\"))").Append(__c.CRLF);
 //BA.debugLineNum = 196;BA.debugLine="code1.Append(\"list1.AddItem(\"\"H3\"\", BuildSimpleIt";
_code1.Append("list1.AddItem(\"H3\", BuildSimpleItem(\"L1H3\",\"mdi-editor-border-all\",\"Friends\"))").Append(__c.CRLF);
 //BA.debugLineNum = 197;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H3\"\", \"\"S7\"\", Bu";
_code1.Append("list1.AddSubItem(\"H3\", \"S7\", BuildSimpleItem(\"L1H3S7\",\"\", \"Jean\"))").Append(__c.CRLF);
 //BA.debugLineNum = 198;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H3\"\", \"\"S8\"\", Bu";
_code1.Append("list1.AddSubItem(\"H3\", \"S8\", BuildSimpleItem(\"L1H3S8\",\"\", \"Walter\"))").Append(__c.CRLF);
 //BA.debugLineNum = 199;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H3\"\", \"\"S9\"\", Bu";
_code1.Append("list1.AddSubItem(\"H3\", \"S9\", BuildSimpleItem(\"L1H3S9\",\"\", \"Betty\"))").Append(__c.CRLF);
 //BA.debugLineNum = 200;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H3\"\", \"\"S10\"\", B";
_code1.Append("list1.AddSubItem(\"H3\", \"S10\", BuildSimpleItem(\"L1H3S10\",\"\", \"Thomas\"))").Append(__c.CRLF);
 //BA.debugLineNum = 201;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H3\"\", \"\"S11\"\", B";
_code1.Append("list1.AddSubItem(\"H3\", \"S11\", BuildSimpleItem(\"L1H3S11\",\"\", \"Jones\"))").Append(__c.CRLF);
 //BA.debugLineNum = 202;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H3\"\", \"\"S12\"\", B";
_code1.Append("list1.AddSubItem(\"H3\", \"S12\", BuildSimpleItem(\"L1H3S12\",\"\", \"Steven\"))").Append(__c.CRLF);
 //BA.debugLineNum = 203;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H3\"\", \"\"S13\"\", B";
_code1.Append("list1.AddSubItem(\"H3\", \"S13\", BuildSimpleItem(\"L1H3S13\",\"\", \"Andrea\"))").Append(__c.CRLF);
 //BA.debugLineNum = 204;BA.debugLine="code1.Append(\"list1.AddSubItem(\"\"H3\"\", \"\"S14\"\", B";
_code1.Append("list1.AddSubItem(\"H3\", \"S14\", BuildSimpleItem(\"L1H3S14\",\"\", \"Julie\"))").Append(__c.CRLF);
 //BA.debugLineNum = 205;BA.debugLine="code1.Append(\"\").Append(CRLF)";
_code1.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 206;BA.debugLine="code1.Append(\"page.Cell(2,1).AddComponent(list1)\"";
_code1.Append("page.Cell(2,1).AddComponent(list1)").Append(__c.CRLF);
 //BA.debugLineNum = 208;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code1",_code1)));
 //BA.debugLineNum = 211;BA.debugLine="Dim code1a As StringBuilder";
_code1a = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 212;BA.debugLine="code1a.Initialize";
_code1a.Initialize();
 //BA.debugLineNum = 213;BA.debugLine="code1a.Append(\"// the list clicked event\").Append";
_code1a.Append("// the list clicked event").Append(__c.CRLF);
 //BA.debugLineNum = 214;BA.debugLine="code1a.Append(\"Sub List1_Clicked(ItemId As String";
_code1a.Append("Sub List1_Clicked(ItemId As String)").Append(__c.CRLF);
 //BA.debugLineNum = 215;BA.debugLine="code1a.Append(\"   If ItemId.StartsWith(\"\"H\"\") The";
_code1a.Append("   If ItemId.StartsWith(\"H\") Then Return").Append(__c.CRLF);
 //BA.debugLineNum = 216;BA.debugLine="code1a.Append(\"   Dim list1 As ABMList = page.Com";
_code1a.Append("   Dim list1 As ABMList = page.Component(\"list1\")").Append(__c.CRLF);
 //BA.debugLineNum = 217;BA.debugLine="code1a.Append(\"   Dim lbl As ABMLabel = list1.Ite";
_code1a.Append("   Dim lbl As ABMLabel = list1.Item(ItemId)").Append(__c.CRLF);
 //BA.debugLineNum = 218;BA.debugLine="code1a.Append(\"   Dim myTexts, myReturns As List\"";
_code1a.Append("   Dim myTexts, myReturns As List").Append(__c.CRLF);
 //BA.debugLineNum = 219;BA.debugLine="code1a.Append(\"   myTexts.Initialize\").Append(CRL";
_code1a.Append("   myTexts.Initialize").Append(__c.CRLF);
 //BA.debugLineNum = 220;BA.debugLine="code1a.Append(\"   myReturns.Initialize\").Append(C";
_code1a.Append("   myReturns.Initialize").Append(__c.CRLF);
 //BA.debugLineNum = 221;BA.debugLine="code1a.Append(\"   myToastId = myToastId + 1\").App";
_code1a.Append("   myToastId = myToastId + 1").Append(__c.CRLF);
 //BA.debugLineNum = 222;BA.debugLine="code1a.Append(\"   page.ShowToast(\"\"toast\"\" & myTo";
_code1a.Append("   page.ShowToast(\"toast\" & myToastId, \"toastred\", \"Clicked on \" & lbl.Text, 5000, myTexts, myReturns)").Append(__c.CRLF);
 //BA.debugLineNum = 223;BA.debugLine="code1a.Append(\"End Sub\").Append(CRLF)";
_code1a.Append("End Sub").Append(__c.CRLF);
 //BA.debugLineNum = 225;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code1a",_code1a)));
 //BA.debugLineNum = 228;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr2","Lists with scrollbar")));
 //BA.debugLineNum = 231;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","Lists with a scrollbar have a maximum height. In this example we also use another collapsing method: ABM.COLLAPSE_EXPANDABLE.")));
 //BA.debugLineNum = 234;BA.debugLine="Dim list2 As ABMList";
_list2 = new com.ab.abmaterial.ABMList();
 //BA.debugLineNum = 235;BA.debugLine="list2.InitializeWithMaxHeight(page, \"list2\", ABM.";
_list2.InitializeWithMaxHeight(_page,"list2",_abm.COLLAPSE_EXPANDABLE,(int) (310),"list1theme");
 //BA.debugLineNum = 238;BA.debugLine="list2.AddItem(\"H1\", BuildSimpleItem(\"L2H1\",\"mdi-a";
_list2.AddItem("H1",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H1","mdi-action-account-circle","Family")));
 //BA.debugLineNum = 239;BA.debugLine="list2.AddSubItem(\"H1\", \"S1\", BuildSimpleItem(\"L2H";
_list2.AddSubItem("H1","S1",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H1S1","","Mom")));
 //BA.debugLineNum = 240;BA.debugLine="list2.AddSubItem(\"H1\", \"S2\", BuildSimpleItem(\"L2H";
_list2.AddSubItem("H1","S2",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H1S2","","Dad")));
 //BA.debugLineNum = 241;BA.debugLine="list2.AddSubItem(\"H1\", \"S3\", BuildSimpleItem(\"L2H";
_list2.AddSubItem("H1","S3",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H1S3","","Brother")));
 //BA.debugLineNum = 242;BA.debugLine="list2.AddSubItem(\"H1\", \"S4\", BuildSimpleItem(\"L2H";
_list2.AddSubItem("H1","S4",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H1S4","","Sister")));
 //BA.debugLineNum = 243;BA.debugLine="list2.AddItem(\"H2\", BuildSimpleItem(\"L2H2\",\"mdi-a";
_list2.AddItem("H2",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H2","mdi-action-dashboard","Colleagues")));
 //BA.debugLineNum = 244;BA.debugLine="list2.AddSubItem(\"H2\", \"S5\", BuildSimpleItem(\"L2H";
_list2.AddSubItem("H2","S5",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H2S5","","Boss")));
 //BA.debugLineNum = 245;BA.debugLine="list2.AddSubItem(\"H2\", \"S6\", BuildSimpleItem(\"L2H";
_list2.AddSubItem("H2","S6",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H2S6","","Secretary")));
 //BA.debugLineNum = 246;BA.debugLine="list2.AddItem(\"H3\", BuildSimpleItem(\"L2H3\",\"mdi-e";
_list2.AddItem("H3",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H3","mdi-editor-border-all","Friends")));
 //BA.debugLineNum = 247;BA.debugLine="list2.AddSubItem(\"H3\", \"S7\", BuildSimpleItem(\"L2H";
_list2.AddSubItem("H3","S7",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H3S7","","Jean")));
 //BA.debugLineNum = 248;BA.debugLine="list2.AddSubItem(\"H3\", \"S8\", BuildSimpleItem(\"L2H";
_list2.AddSubItem("H3","S8",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H3S8","","Walter")));
 //BA.debugLineNum = 249;BA.debugLine="list2.AddSubItem(\"H3\", \"S9\", BuildSimpleItem(\"L2H";
_list2.AddSubItem("H3","S9",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H3S9","","Betty")));
 //BA.debugLineNum = 250;BA.debugLine="list2.AddSubItem(\"H3\", \"S10\", BuildSimpleItem(\"L2";
_list2.AddSubItem("H3","S10",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H3S10","","Thomas")));
 //BA.debugLineNum = 251;BA.debugLine="list2.AddSubItem(\"H3\", \"S11\", BuildSimpleItem(\"L2";
_list2.AddSubItem("H3","S11",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H3S11","","Jones")));
 //BA.debugLineNum = 252;BA.debugLine="list2.AddSubItem(\"H3\", \"S12\", BuildSimpleItem(\"L2";
_list2.AddSubItem("H3","S12",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H3S12","","Steven")));
 //BA.debugLineNum = 253;BA.debugLine="list2.AddSubItem(\"H3\", \"S13\", BuildSimpleItem(\"L2";
_list2.AddSubItem("H3","S13",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H3S13","","Andrea")));
 //BA.debugLineNum = 254;BA.debugLine="list2.AddSubItem(\"H3\", \"S14\", BuildSimpleItem(\"L2";
_list2.AddSubItem("H3","S14",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L2H3S14","","Julie")));
 //BA.debugLineNum = 256;BA.debugLine="page.Cell(6,1).AddComponent(list2)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_list2));
 //BA.debugLineNum = 259;BA.debugLine="Dim code2 As StringBuilder";
_code2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 260;BA.debugLine="code2.Initialize";
_code2.Initialize();
 //BA.debugLineNum = 261;BA.debugLine="code2.Append(\"list2.InitializeWithMaxHeight(page,";
_code2.Append("list2.InitializeWithMaxHeight(page, \"list2\", ABM.COLLAPSE_EXPANDABLE, 310, \"list1theme\")").Append(__c.CRLF);
 //BA.debugLineNum = 262;BA.debugLine="code2.Append(\"...\").Append(CRLF)";
_code2.Append("...").Append(__c.CRLF);
 //BA.debugLineNum = 264;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code2",_code2)));
 //BA.debugLineNum = 267;BA.debugLine="page.Cell(8,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr2","Complex list layout")));
 //BA.debugLineNum = 270;BA.debugLine="page.Cell(8,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","The layouts of the items in a list can be complex. For example this list has ABMCards as items.")));
 //BA.debugLineNum = 273;BA.debugLine="Dim list3 As ABMList";
_list3 = new com.ab.abmaterial.ABMList();
 //BA.debugLineNum = 274;BA.debugLine="list3.InitializeWithMaxHeight(page, \"list3\", ABM.";
_list3.InitializeWithMaxHeight(_page,"list3",_abm.COLLAPSE_ACCORDION,(int) (620),"list3theme");
 //BA.debugLineNum = 277;BA.debugLine="list3.AddItem(\"H1\", BuildSimpleItem(\"L3H1\",\"mdi-a";
_list3.AddItem("H1",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L3H1","mdi-action-account-circle","Family")));
 //BA.debugLineNum = 278;BA.debugLine="list3.AddSubItem(\"H1\", \"S1\", BuildItem(\"L3H1S1\",\"";
_list3.AddSubItem("H1","S1",(com.ab.abmaterial.ABMComponent)(_builditem("L3H1S1","../images/list1.jpg","Mom")));
 //BA.debugLineNum = 279;BA.debugLine="list3.AddSubItem(\"H1\", \"S2\", BuildItem(\"L3H1S2\",\"";
_list3.AddSubItem("H1","S2",(com.ab.abmaterial.ABMComponent)(_builditem("L3H1S2","../images/list2.jpg","Dad")));
 //BA.debugLineNum = 280;BA.debugLine="list3.AddSubItem(\"H1\", \"S3\", BuildItem(\"L3H1S3\",\"";
_list3.AddSubItem("H1","S3",(com.ab.abmaterial.ABMComponent)(_builditem("L3H1S3","../images/list3.jpg","Brother")));
 //BA.debugLineNum = 281;BA.debugLine="list3.AddSubItem(\"H1\", \"S4\", BuildItem(\"L3H1S4\",\"";
_list3.AddSubItem("H1","S4",(com.ab.abmaterial.ABMComponent)(_builditem("L3H1S4","../images/list4.jpg","Sister")));
 //BA.debugLineNum = 282;BA.debugLine="list3.AddItem(\"H2\", BuildSimpleItem(\"L3H2\",\"mdi-a";
_list3.AddItem("H2",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L3H2","mdi-action-dashboard","Colleagues")));
 //BA.debugLineNum = 283;BA.debugLine="list3.AddSubItem(\"H2\", \"S5\", BuildItem(\"L3H2S5\",\"";
_list3.AddSubItem("H2","S5",(com.ab.abmaterial.ABMComponent)(_builditem("L3H2S5","../images/list5.jpg","Boss")));
 //BA.debugLineNum = 284;BA.debugLine="list3.AddSubItem(\"H2\", \"S6\", BuildItem(\"L3H2S6\",\"";
_list3.AddSubItem("H2","S6",(com.ab.abmaterial.ABMComponent)(_builditem("L3H2S6","../images/list6.jpg","Secretary")));
 //BA.debugLineNum = 285;BA.debugLine="list3.AddItem(\"H3\", BuildSimpleItem(\"L3H3\",\"mdi-e";
_list3.AddItem("H3",(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L3H3","mdi-editor-border-all","Friends")));
 //BA.debugLineNum = 286;BA.debugLine="list3.AddSubItem(\"H3\", \"S7\", BuildItem(\"L3H3S7\",\"";
_list3.AddSubItem("H3","S7",(com.ab.abmaterial.ABMComponent)(_builditem("L3H3S7","../images/list7.jpg","Jean")));
 //BA.debugLineNum = 287;BA.debugLine="list3.AddSubItem(\"H3\", \"S8\", BuildItem(\"L3H3S8\",\"";
_list3.AddSubItem("H3","S8",(com.ab.abmaterial.ABMComponent)(_builditem("L3H3S8","../images/list8.jpg","Walter")));
 //BA.debugLineNum = 288;BA.debugLine="list3.AddSubItem(\"H3\", \"S9\", BuildItem(\"L3H3S9\",\"";
_list3.AddSubItem("H3","S9",(com.ab.abmaterial.ABMComponent)(_builditem("L3H3S9","../images/list9.jpg","Betty")));
 //BA.debugLineNum = 289;BA.debugLine="list3.AddSubItem(\"H3\", \"S10\", BuildItem(\"L3H3S10\"";
_list3.AddSubItem("H3","S10",(com.ab.abmaterial.ABMComponent)(_builditem("L3H3S10","../images/list10.jpg","Thomas")));
 //BA.debugLineNum = 290;BA.debugLine="list3.AddSubItem(\"H3\", \"S11\", BuildItem(\"L3H3S11\"";
_list3.AddSubItem("H3","S11",(com.ab.abmaterial.ABMComponent)(_builditem("L3H3S11","../images/list11.jpg","Jones")));
 //BA.debugLineNum = 291;BA.debugLine="list3.AddSubItem(\"H3\", \"S12\", BuildItem(\"L3H3S12\"";
_list3.AddSubItem("H3","S12",(com.ab.abmaterial.ABMComponent)(_builditem("L3H3S12","../images/list12.jpg","Steven")));
 //BA.debugLineNum = 292;BA.debugLine="list3.AddSubItem(\"H3\", \"S13\", BuildItem(\"L3H3S13\"";
_list3.AddSubItem("H3","S13",(com.ab.abmaterial.ABMComponent)(_builditem("L3H3S13","../images/list13.jpg","Andrea")));
 //BA.debugLineNum = 293;BA.debugLine="list3.AddSubItem(\"H3\", \"S14\", BuildItem(\"L3H3S14\"";
_list3.AddSubItem("H3","S14",(com.ab.abmaterial.ABMComponent)(_builditem("L3H3S14","../images/list14.jpg","Julie")));
 //BA.debugLineNum = 295;BA.debugLine="page.Cell(9,1).AddComponent(list3)";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_list3));
 //BA.debugLineNum = 298;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 300;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 303;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 305;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 306;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 20;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 22;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return "";
}
public String  _list1_clicked(String _itemid) throws Exception{
com.ab.abmaterial.ABMList _list1 = null;
com.ab.abmaterial.ABMLabel _lbl = null;
 //BA.debugLineNum = 354;BA.debugLine="Sub List1_Clicked(ItemId As String)";
 //BA.debugLineNum = 355;BA.debugLine="If ItemId.StartsWith(\"H\") Then Return";
if (_itemid.startsWith("H")) { 
if (true) return "";};
 //BA.debugLineNum = 356;BA.debugLine="Dim list1 As ABMList = page.Component(\"list1\")";
_list1 = (com.ab.abmaterial.ABMList)(_page.Component("list1"));
 //BA.debugLineNum = 357;BA.debugLine="list1.AddSubItem(\"H4\", \"S\" & (1000+myToastId), Bu";
_list1.AddSubItem("H4","S"+BA.NumberToString((1000+_mytoastid)),(com.ab.abmaterial.ABMComponent)(_buildsimpleitem("L1H4S"+BA.NumberToString((1000+_mytoastid)),"","Item"+BA.NumberToString((1000+_mytoastid)))));
 //BA.debugLineNum = 358;BA.debugLine="list1.Refresh";
_list1.Refresh();
 //BA.debugLineNum = 359;BA.debugLine="Dim lbl As ABMLabel = list1.Item(ItemId)";
_lbl = (com.ab.abmaterial.ABMLabel)(_list1.Item(_itemid));
 //BA.debugLineNum = 360;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 361;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Clicked on "+_lbl.Text,(int) (5000));
 //BA.debugLineNum = 362;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 331;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 332;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 333;BA.debugLine="If Action = \"GettingStarted\" Then Return";
if ((_action).equals("GettingStarted")) { 
if (true) return "";};
 //BA.debugLineNum = 334;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 335;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 336;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too! ",(int) (5000));
 //BA.debugLineNum = 337;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 339;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 340;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 341;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 343;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 344;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 57;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 58;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 59;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 60;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 61;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 62;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 63;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 65;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 66;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 67;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 68;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 70;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 72;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 74;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 75;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 76;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 78;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 82;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 85;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 346;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 347;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 348;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 349;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 350;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 351;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 25;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 26;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 27;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 28;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 29;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 31;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 32;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 33;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 34;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 38;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 39;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 41;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 43;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 46;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 48;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 50;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 54;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
