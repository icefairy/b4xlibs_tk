package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compactionbuttonpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compactionbuttonpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compactionbuttonpage.class).invoke(this, new Object[] {null});
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
public String  _acb1_clicked(String _target,String _subtarget) throws Exception{
anywheresoftware.b4a.objects.collections.List _mytexts = null;
anywheresoftware.b4a.objects.collections.List _myreturns = null;
 //BA.debugLineNum = 265;BA.debugLine="Sub acb1_Clicked(Target As String, SubTarget As St";
 //BA.debugLineNum = 266;BA.debugLine="If SubTarget=\"\" Then";
if ((_subtarget).equals("")) { 
 //BA.debugLineNum = 267;BA.debugLine="Log(\"clicked main button\")";
__c.Log("clicked main button");
 //BA.debugLineNum = 268;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 270;BA.debugLine="Dim myTexts, myReturns As List";
_mytexts = new anywheresoftware.b4a.objects.collections.List();
_myreturns = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 271;BA.debugLine="myTexts.Initialize";
_mytexts.Initialize();
 //BA.debugLineNum = 272;BA.debugLine="myReturns.Initialize";
_myreturns.Initialize();
 //BA.debugLineNum = 273;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 274;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Clicked on "+_subtarget,(int) (5000));
 //BA.debugLineNum = 275;BA.debugLine="Return";
if (true) return "";
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return "";
}
public String  _acb2_clicked(String _target,String _subtarget) throws Exception{
anywheresoftware.b4a.objects.collections.List _mytexts = null;
anywheresoftware.b4a.objects.collections.List _myreturns = null;
 //BA.debugLineNum = 278;BA.debugLine="Sub acb2_Clicked(Target As String, SubTarget As St";
 //BA.debugLineNum = 279;BA.debugLine="If SubTarget=\"\" Then";
if ((_subtarget).equals("")) { 
 //BA.debugLineNum = 280;BA.debugLine="Log(\"clicked main button\")";
__c.Log("clicked main button");
 //BA.debugLineNum = 281;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 283;BA.debugLine="Dim myTexts, myReturns As List";
_mytexts = new anywheresoftware.b4a.objects.collections.List();
_myreturns = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 284;BA.debugLine="myTexts.Initialize";
_mytexts.Initialize();
 //BA.debugLineNum = 285;BA.debugLine="myReturns.Initialize";
_myreturns.Initialize();
 //BA.debugLineNum = 286;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 287;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Clicked on "+_subtarget,(int) (5000));
 //BA.debugLineNum = 288;BA.debugLine="Return";
if (true) return "";
 //BA.debugLineNum = 289;BA.debugLine="End Sub";
return "";
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 109;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 111;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 114;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 115;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 116;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 117;BA.debugLine="page.PageTitle = \"ABMActionButton\"";
_page.PageTitle = "ABMActionButton";
 //BA.debugLineNum = 118;BA.debugLine="page.PageDescription = \"The action button compone";
_page.PageDescription = "The action button component ";
 //BA.debugLineNum = 119;BA.debugLine="page.PageHTMLName = \"abmaterial-action-button.htm";
_page.PageHTMLName = "abmaterial-action-button.html";
 //BA.debugLineNum = 120;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 121;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 122;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 123;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 125;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMActionButt";
_abmshared._buildnavigationbar(_page,"ABMActionButton","../images/logo.png","","Controls","ABMActionButton");
 //BA.debugLineNum = 128;BA.debugLine="page.AddRows(3,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (3),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 129;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,12,8,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (8),(int) (6),"");
 //BA.debugLineNum = 130;BA.debugLine="page.AddRows(1,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 131;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 136;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 93;BA.debugLine="theme.AddButtonTheme(\"bigblue\")";
_theme.AddButtonTheme("bigblue");
 //BA.debugLineNum = 94;BA.debugLine="theme.Button(\"bigblue\").BackColor = ABM.COLOR_LIG";
_theme.Button("bigblue").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 96;BA.debugLine="theme.AddButtonTheme(\"sub1\")";
_theme.AddButtonTheme("sub1");
 //BA.debugLineNum = 97;BA.debugLine="theme.Button(\"sub1\").BackColor = ABM.COLOR_RED";
_theme.Button("sub1").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 99;BA.debugLine="theme.AddButtonTheme(\"sub2\")";
_theme.AddButtonTheme("sub2");
 //BA.debugLineNum = 100;BA.debugLine="theme.Button(\"sub2\").BackColor = ABM.COLOR_GREEN";
_theme.Button("sub2").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 102;BA.debugLine="theme.AddButtonTheme(\"sub3\")";
_theme.AddButtonTheme("sub3");
 //BA.debugLineNum = 103;BA.debugLine="theme.Button(\"sub3\").BackColor = ABM.COLOR_YELLOW";
_theme.Button("sub3").BackColor = _abm.COLOR_YELLOW;
 //BA.debugLineNum = 105;BA.debugLine="theme.AddCardTheme(\"whitetitle\")";
_theme.AddCardTheme("whitetitle");
 //BA.debugLineNum = 106;BA.debugLine="theme.Card(\"whitetitle\").TitleForeColor = ABM.COL";
_theme.Card("whitetitle").TitleForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompActionButtonPage\"";
_name = "CompActionButtonPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMActionButton _acb1 = null;
com.ab.abmaterial.ABMButton _btn1 = null;
com.ab.abmaterial.ABMButton _btn2 = null;
com.ab.abmaterial.ABMButton _btn3 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code = null;
com.ab.abmaterial.ABMCard _card2 = null;
com.ab.abmaterial.ABMActionButton _acb2 = null;
com.ab.abmaterial.ABMButton _btn4 = null;
com.ab.abmaterial.ABMButton _btn5 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code2 = null;
 //BA.debugLineNum = 139;BA.debugLine="public Sub ConnectPage()";
 //BA.debugLineNum = 141;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 143;BA.debugLine="Dim acb1 As ABMActionButton";
_acb1 = new com.ab.abmaterial.ABMActionButton();
 //BA.debugLineNum = 144;BA.debugLine="acb1.Initialize(page, \"acb1\", \"mdi-action-shop\",";
_acb1.Initialize(_page,"acb1","mdi-action-shop","","bigblue");
 //BA.debugLineNum = 145;BA.debugLine="acb1.MainButton.size = ABM.BUTTONSIZE_LARGE";
_acb1.MainButton().Size = _abm.BUTTONSIZE_LARGE;
 //BA.debugLineNum = 148;BA.debugLine="Dim btn1 As ABMButton";
_btn1 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 149;BA.debugLine="btn1.InitializeFloating(page, \"btn1\", \"mdi-social";
_btn1.InitializeFloating(_page,"btn1","mdi-social-share","sub1");
 //BA.debugLineNum = 150;BA.debugLine="acb1.AddMenuButton(btn1)";
_acb1.AddMenuButton(_btn1);
 //BA.debugLineNum = 151;BA.debugLine="Dim btn2 As ABMButton";
_btn2 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 152;BA.debugLine="btn2.InitializeFloating(page, \"btn2\", \"mdi-social";
_btn2.InitializeFloating(_page,"btn2","mdi-social-whatshot","sub2");
 //BA.debugLineNum = 153;BA.debugLine="acb1.AddMenuButton(btn2)";
_acb1.AddMenuButton(_btn2);
 //BA.debugLineNum = 154;BA.debugLine="Dim btn3 As ABMButton";
_btn3 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 155;BA.debugLine="btn3.InitializeFloating(page, \"btn3\", \"mdi-social";
_btn3.InitializeFloating(_page,"btn3","mdi-social-notifications","sub3");
 //BA.debugLineNum = 156;BA.debugLine="acb1.AddMenuButton(btn3)";
_acb1.AddMenuButton(_btn3);
 //BA.debugLineNum = 159;BA.debugLine="page.AddActionButton(acb1)";
_page.AddActionButton(_acb1);
 //BA.debugLineNum = 162;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Action buttons are buttons that can open a sub menu of buttons. They are generaly used on page level, but they can also be set at cell level.")));
 //BA.debugLineNum = 164;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Page Level")));
 //BA.debugLineNum = 166;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","The big blue button on the bottom right is an example of a page ActionButton.")));
 //BA.debugLineNum = 169;BA.debugLine="Dim code As StringBuilder";
_code = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 170;BA.debugLine="code.Initialize";
_code.Initialize();
 //BA.debugLineNum = 171;BA.debugLine="code.Append(\"// create the action button\").Append";
_code.Append("// create the action button").Append(__c.CRLF);
 //BA.debugLineNum = 172;BA.debugLine="code.Append(\"Dim acb1 As ABMActionButton\").Append";
_code.Append("Dim acb1 As ABMActionButton").Append(__c.CRLF);
 //BA.debugLineNum = 173;BA.debugLine="code.Append(\"acb1.Initialize(page, \"\"acb1\"\", \"\"md";
_code.Append("acb1.Initialize(page, \"acb1\", \"mdi-action-shop\", \", \"bigblue\")").Append(__c.CRLF);
 //BA.debugLineNum = 174;BA.debugLine="code.Append(\"acb1.MainButton.size = ABM.BUTTONSIZ";
_code.Append("acb1.MainButton.size = ABM.BUTTONSIZE_LARGE").Append(__c.CRLF);
 //BA.debugLineNum = 175;BA.debugLine="code.Append(\"\").Append(CRLF)";
_code.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 176;BA.debugLine="code.Append(\"// the sub buttons\").Append(CRLF)";
_code.Append("// the sub buttons").Append(__c.CRLF);
 //BA.debugLineNum = 177;BA.debugLine="code.Append(\"Dim btn1 As ABMButton\").Append(CRLF)";
_code.Append("Dim btn1 As ABMButton").Append(__c.CRLF);
 //BA.debugLineNum = 178;BA.debugLine="code.Append(\"btn1.InitializeFloating(page, \"\"btn1";
_code.Append("btn1.InitializeFloating(page, \"btn1\", \"mdi-social-share\", \"sub1\")").Append(__c.CRLF);
 //BA.debugLineNum = 179;BA.debugLine="code.Append(\"acb1.AddMenuButton(btn1)\").Append(CR";
_code.Append("acb1.AddMenuButton(btn1)").Append(__c.CRLF);
 //BA.debugLineNum = 180;BA.debugLine="code.Append(\"Dim btn2 As ABMButton\").Append(CRLF)";
_code.Append("Dim btn2 As ABMButton").Append(__c.CRLF);
 //BA.debugLineNum = 181;BA.debugLine="code.Append(\"btn2.InitializeFloating(page, \"\"btn2";
_code.Append("btn2.InitializeFloating(page, \"btn2\", \"mdi-social-whatshot\", \"sub2\")").Append(__c.CRLF);
 //BA.debugLineNum = 182;BA.debugLine="code.Append(\"acb1.AddMenuButton(btn2)\").Append(CR";
_code.Append("acb1.AddMenuButton(btn2)").Append(__c.CRLF);
 //BA.debugLineNum = 183;BA.debugLine="code.Append(\"Dim btn3 As ABMButton\").Append(CRLF)";
_code.Append("Dim btn3 As ABMButton").Append(__c.CRLF);
 //BA.debugLineNum = 184;BA.debugLine="code.Append(\"btn3.InitializeFloating(page, \"\"btn3";
_code.Append("btn3.InitializeFloating(page, \"btn3\", \"mdi-social-notifications\", \"sub3\")").Append(__c.CRLF);
 //BA.debugLineNum = 185;BA.debugLine="code.Append(\"acb1.AddMenuButton(btn3)\").Append(CR";
_code.Append("acb1.AddMenuButton(btn3)").Append(__c.CRLF);
 //BA.debugLineNum = 186;BA.debugLine="code.Append(\"\").Append(CRLF)";
_code.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 187;BA.debugLine="code.Append(\"// add To page\").Append(CRLF)";
_code.Append("// add To page").Append(__c.CRLF);
 //BA.debugLineNum = 188;BA.debugLine="code.Append(\"page.AddActionButton(acb1)\").Append(";
_code.Append("page.AddActionButton(acb1)").Append(__c.CRLF);
 //BA.debugLineNum = 190;BA.debugLine="page.Cell(2,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code",_code)));
 //BA.debugLineNum = 193;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Cell Level")));
 //BA.debugLineNum = 195;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","You can also add an action button to a cell.")));
 //BA.debugLineNum = 198;BA.debugLine="Dim card2 As ABMCard";
_card2 = new com.ab.abmaterial.ABMCard();
 //BA.debugLineNum = 199;BA.debugLine="card2.InitializeAsCard(page, \"card2\", \"Card Title";
_card2.InitializeAsCard(_page,"card2","Card Title","I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.",_abm.CARD_NOTSPECIFIED,"whitetitle");
 //BA.debugLineNum = 200;BA.debugLine="card2.Image = \"../images/sample-1.jpg\"";
_card2.Image = "../images/sample-1.jpg";
 //BA.debugLineNum = 201;BA.debugLine="card2.AddAction(\"BUTTON 1\")";
_card2.AddAction("BUTTON 1");
 //BA.debugLineNum = 202;BA.debugLine="page.Cell(4,1).AddComponent(card2)";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_card2));
 //BA.debugLineNum = 205;BA.debugLine="Dim acb2 As ABMActionButton";
_acb2 = new com.ab.abmaterial.ABMActionButton();
 //BA.debugLineNum = 206;BA.debugLine="acb2.Initialize(page, \"acb2\", \"mdi-action-shop\",";
_acb2.Initialize(_page,"acb2","mdi-action-shop","","sub1");
 //BA.debugLineNum = 209;BA.debugLine="Dim btn4 As ABMButton";
_btn4 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 210;BA.debugLine="btn4.InitializeFloating(page, \"btn4\", \"mdi-social";
_btn4.InitializeFloating(_page,"btn4","mdi-social-whatshot","sub2");
 //BA.debugLineNum = 211;BA.debugLine="acb2.AddMenuButton(btn4)";
_acb2.AddMenuButton(_btn4);
 //BA.debugLineNum = 212;BA.debugLine="Dim btn5 As ABMButton";
_btn5 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 213;BA.debugLine="btn5.InitializeFloating(page, \"btn5\", \"mdi-social";
_btn5.InitializeFloating(_page,"btn5","mdi-social-notifications","sub3");
 //BA.debugLineNum = 214;BA.debugLine="acb2.AddMenuButton(btn5)";
_acb2.AddMenuButton(_btn5);
 //BA.debugLineNum = 217;BA.debugLine="page.Cell(4,1).AddComponent(acb2)";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_acb2));
 //BA.debugLineNum = 220;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","The only difference with the page ActionButton is we've added it to the cell as a normal control.")));
 //BA.debugLineNum = 223;BA.debugLine="Dim code2 As StringBuilder";
_code2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 224;BA.debugLine="code2.Initialize";
_code2.Initialize();
 //BA.debugLineNum = 225;BA.debugLine="code2.Append(\"acb2.Initialize(page, \"\"acb2\"\", \"\"m";
_code2.Append("acb2.Initialize(page, \"acb2\", \"mdi-action-shop\", \"sub1\")").Append(__c.CRLF);
 //BA.debugLineNum = 226;BA.debugLine="code2.Append(\"...\").Append(CRLF)";
_code2.Append("...").Append(__c.CRLF);
 //BA.debugLineNum = 227;BA.debugLine="code2.Append(\"page.AddComponent(4,1, acb2)\").Appe";
_code2.Append("page.AddComponent(4,1, acb2)").Append(__c.CRLF);
 //BA.debugLineNum = 229;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code2",_code2)));
 //BA.debugLineNum = 232;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 234;BA.debugLine="page.Refresh ' IMPORTANT!";
_page.Refresh();
 //BA.debugLineNum = 237;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 239;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 240;BA.debugLine="End Sub";
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
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 243;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 244;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 245;BA.debugLine="If Action = \"ABMActionButton\" Then Return";
if ((_action).equals("ABMActionButton")) { 
if (true) return "";};
 //BA.debugLineNum = 246;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 247;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 248;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 249;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 251;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 252;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 253;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 255;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 256;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 258;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 259;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 260;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 261;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 262;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 263;BA.debugLine="End Sub";
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
