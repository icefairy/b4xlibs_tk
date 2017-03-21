package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compcardpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compcardpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compcardpage.class).invoke(this, new Object[] {null});
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
 //BA.debugLineNum = 117;BA.debugLine="page.PageTitle = \"ABMCard\"";
_page.PageTitle = "ABMCard";
 //BA.debugLineNum = 118;BA.debugLine="page.PageDescription = \"The card component \"";
_page.PageDescription = "The card component ";
 //BA.debugLineNum = 119;BA.debugLine="page.PageHTMLName = \"abmaterial-card.html\"";
_page.PageHTMLName = "abmaterial-card.html";
 //BA.debugLineNum = 120;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 121;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 122;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 123;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 125;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMCard\", \"..";
_abmshared._buildnavigationbar(_page,"ABMCard","../images/logo.png","","Controls","ABMCard");
 //BA.debugLineNum = 128;BA.debugLine="page.AddRows(1,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 129;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,12,6,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (6),(int) (6),"");
 //BA.debugLineNum = 130;BA.debugLine="page.AddRows(2,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (2),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 131;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,12,7,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (7),(int) (7),"");
 //BA.debugLineNum = 132;BA.debugLine="page.AddRows(2,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (2),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 133;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,12,7,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (7),(int) (7),"");
 //BA.debugLineNum = 134;BA.debugLine="page.AddRows(2,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (2),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 135;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,12,6,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (6),(int) (6),"");
 //BA.debugLineNum = 136;BA.debugLine="page.AddRows(1,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 137;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,12,7,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (7),(int) (7),"");
 //BA.debugLineNum = 138;BA.debugLine="page.AddRows(1,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 139;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,12,8,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (8),(int) (8),"");
 //BA.debugLineNum = 140;BA.debugLine="page.AddRows(1,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 141;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,12,6,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (6),(int) (6),"");
 //BA.debugLineNum = 142;BA.debugLine="page.AddRows(1,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 143;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 148;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 95;BA.debugLine="theme.AddCardTheme(\"basiccard\")";
_theme.AddCardTheme("basiccard");
 //BA.debugLineNum = 96;BA.debugLine="theme.Card(\"basiccard\").BackColor = ABM.COLOR_BLU";
_theme.Card("basiccard").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 97;BA.debugLine="theme.Card(\"basiccard\").TitleForeColor = ABM.COLO";
_theme.Card("basiccard").TitleForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 98;BA.debugLine="theme.Card(\"basiccard\").ContentForeColor = ABM.CO";
_theme.Card("basiccard").ContentForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 99;BA.debugLine="theme.Card(\"basiccard\").ActionForeColor = ABM.COL";
_theme.Card("basiccard").ActionForeColor = _abm.COLOR_ORANGE;
 //BA.debugLineNum = 101;BA.debugLine="theme.AddCardTheme(\"whitetitle\")";
_theme.AddCardTheme("whitetitle");
 //BA.debugLineNum = 102;BA.debugLine="theme.Card(\"whitetitle\").TitleForeColor = ABM.COL";
_theme.Card("whitetitle").TitleForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 104;BA.debugLine="theme.AddCardTheme(\"redpanel\")";
_theme.AddCardTheme("redpanel");
 //BA.debugLineNum = 105;BA.debugLine="theme.Card(\"redpanel\").ContentForeColor = ABM.COL";
_theme.Card("redpanel").ContentForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 106;BA.debugLine="theme.Card(\"redpanel\").BackColor = ABM.COLOR_RED";
_theme.Card("redpanel").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 107;BA.debugLine="End Sub";
return "";
}
public String  _card1_linkclicked(String _card,String _action) throws Exception{
 //BA.debugLineNum = 331;BA.debugLine="Sub card1_LinkClicked(Card As String, Action As St";
 //BA.debugLineNum = 332;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 333;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Clicked on "+_action+"!",(int) (5000));
 //BA.debugLineNum = 334;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompCardPage\"";
_name = "CompCardPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMCard _card1 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code = null;
com.ab.abmaterial.ABMCard _card2 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code2 = null;
com.ab.abmaterial.ABMCard _card3 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code3 = null;
com.ab.abmaterial.ABMCard _card4 = null;
com.ab.abmaterial.ABMCard _card5 = null;
com.ab.abmaterial.ABMCard _card6 = null;
com.ab.abmaterial.ABMCard _card7 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code4 = null;
 //BA.debugLineNum = 151;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 153;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 156;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Cards are a convenient means of displaying content composed of different types of objects. They’re also well-suited for presenting similar objects whose size or supported actions can vary considerably, like photos with captions of variable length.")));
 //BA.debugLineNum = 159;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Basic Card")));
 //BA.debugLineNum = 162;BA.debugLine="Dim card1 As ABMCard";
_card1 = new com.ab.abmaterial.ABMCard();
 //BA.debugLineNum = 163;BA.debugLine="card1.InitializeAsCard(page, \"card1\", \"Card Title";
_card1.InitializeAsCard(_page,"card1","Card Title","I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.",_abm.CARD_NOTSPECIFIED,"basiccard");
 //BA.debugLineNum = 164;BA.debugLine="card1.AddAction(\"BUTTON 1\")";
_card1.AddAction("BUTTON 1");
 //BA.debugLineNum = 165;BA.debugLine="card1.AddAction(\"BUTTON 2\")";
_card1.AddAction("BUTTON 2");
 //BA.debugLineNum = 166;BA.debugLine="page.Cell(2,1).AddComponent(card1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_card1));
 //BA.debugLineNum = 169;BA.debugLine="Dim code As StringBuilder";
_code = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 170;BA.debugLine="code.Initialize";
_code.Initialize();
 //BA.debugLineNum = 171;BA.debugLine="code.Append(\"Dim card1 As ABMCard\").Append(CRLF)";
_code.Append("Dim card1 As ABMCard").Append(__c.CRLF);
 //BA.debugLineNum = 172;BA.debugLine="code.Append(\"card1.InitializeAsCard(page, \"\"card1";
_code.Append("card1.InitializeAsCard(page, \"card1\", \"Card Title\", \"I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.\", ABM.CARD_NOTSPECIFIED,\"basiccard\")").Append(__c.CRLF);
 //BA.debugLineNum = 173;BA.debugLine="code.Append(\"card1.AddAction(\"\"BUTTON 1\"\")\").Appe";
_code.Append("card1.AddAction(\"BUTTON 1\")").Append(__c.CRLF);
 //BA.debugLineNum = 174;BA.debugLine="code.Append(\"card1.AddAction(\"\"BUTTON 2\"\")\").Appe";
_code.Append("card1.AddAction(\"BUTTON 2\")").Append(__c.CRLF);
 //BA.debugLineNum = 175;BA.debugLine="code.Append(\"page.Cell(2,1).AddComponent(card1)\")";
_code.Append("page.Cell(2,1).AddComponent(card1)").Append(__c.CRLF);
 //BA.debugLineNum = 177;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code",_code)));
 //BA.debugLineNum = 180;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr2","Image Card")));
 //BA.debugLineNum = 183;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","Here is the standard card with an image thumbnail.")));
 //BA.debugLineNum = 186;BA.debugLine="Dim card2 As ABMCard";
_card2 = new com.ab.abmaterial.ABMCard();
 //BA.debugLineNum = 187;BA.debugLine="card2.InitializeAsCard(page, \"card2\", \"{I}Card Ti";
_card2.InitializeAsCard(_page,"card2","{I}Card Title{/I}","I am a very {B}simple{/B} card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.",_abm.CARD_NOTSPECIFIED,"whitetitle");
 //BA.debugLineNum = 188;BA.debugLine="card2.Image = \"../images/sample-1.jpg\"";
_card2.Image = "../images/sample-1.jpg";
 //BA.debugLineNum = 189;BA.debugLine="card2.AddAction(\"BUTTON 1\")";
_card2.AddAction("BUTTON 1");
 //BA.debugLineNum = 190;BA.debugLine="page.Cell(5,1).AddComponent(card2)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_card2));
 //BA.debugLineNum = 193;BA.debugLine="Dim code2 As StringBuilder";
_code2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 194;BA.debugLine="code2.Initialize";
_code2.Initialize();
 //BA.debugLineNum = 195;BA.debugLine="code2.Append(\"Dim card2 As ABMCard\").Append(CRLF)";
_code2.Append("Dim card2 As ABMCard").Append(__c.CRLF);
 //BA.debugLineNum = 196;BA.debugLine="code2.Append(\"card2.InitializeAsCard(page, \"\"card";
_code2.Append("card2.InitializeAsCard(page, \"card2\", \"Card Title\", \"I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.\", ABM.CARD_NOTSPECIFIED,\"whitetitle\")").Append(__c.CRLF);
 //BA.debugLineNum = 197;BA.debugLine="code2.Append(\"card2.Image = \"\"../images/sample-1.";
_code2.Append("card2.Image = \"../images/sample-1.jpg\"").Append(__c.CRLF);
 //BA.debugLineNum = 198;BA.debugLine="code2.Append(\"card2.AddAction(\"\"BUTTON 1\"\")\").App";
_code2.Append("card2.AddAction(\"BUTTON 1\")").Append(__c.CRLF);
 //BA.debugLineNum = 199;BA.debugLine="code2.Append(\"page.Cell(5,1).AddComponent(card2)\"";
_code2.Append("page.Cell(5,1).AddComponent(card2)").Append(__c.CRLF);
 //BA.debugLineNum = 201;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code2",_code2)));
 //BA.debugLineNum = 204;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr3","Card Reveal")));
 //BA.debugLineNum = 207;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","Here you can add a card that reveals more information once clicked. Just add the line .IsReveal = true.")));
 //BA.debugLineNum = 210;BA.debugLine="Dim card3 As ABMCard";
_card3 = new com.ab.abmaterial.ABMCard();
 //BA.debugLineNum = 211;BA.debugLine="card3.InitializeAsCard(page, \"card3\", \"{I}Card Ti";
_card3.InitializeAsCard(_page,"card3","{I}Card Title{/I}","I am a very {B}simple{/B} card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.",_abm.CARD_NOTSPECIFIED,"");
 //BA.debugLineNum = 212;BA.debugLine="card3.Image = \"../images/sample-2.jpg\"";
_card3.Image = "../images/sample-2.jpg";
 //BA.debugLineNum = 213;BA.debugLine="card3.IsReveal = True";
_card3.IsReveal = __c.True;
 //BA.debugLineNum = 214;BA.debugLine="card3.AddAction(\"BUTTON 1\")";
_card3.AddAction("BUTTON 1");
 //BA.debugLineNum = 215;BA.debugLine="page.Cell(8,1).AddComponent(card3)";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_card3));
 //BA.debugLineNum = 218;BA.debugLine="Dim code3 As StringBuilder";
_code3 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 219;BA.debugLine="code3.Initialize";
_code3.Initialize();
 //BA.debugLineNum = 220;BA.debugLine="code3.Append(\"Dim card3 As ABMCard\").Append(CRLF)";
_code3.Append("Dim card3 As ABMCard").Append(__c.CRLF);
 //BA.debugLineNum = 221;BA.debugLine="code3.Append(\"card3.InitializeAsCard(page, \"\"card";
_code3.Append("card3.InitializeAsCard(page, \"card3\", \"Card Title\", \"I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively.\", ABM.CARD_NOTSPECIFIED,\"\")").Append(__c.CRLF);
 //BA.debugLineNum = 222;BA.debugLine="code3.Append(\"card3.Image = \"\"../images/sample-1.";
_code3.Append("card3.Image = \"../images/sample-1.jpg\"").Append(__c.CRLF);
 //BA.debugLineNum = 223;BA.debugLine="code3.Append(\"card3.IsReveal = True\").Append(CRLF";
_code3.Append("card3.IsReveal = True").Append(__c.CRLF);
 //BA.debugLineNum = 224;BA.debugLine="code3.Append(\"card2.AddAction(\"\"BUTTON 1\"\")\").App";
_code3.Append("card2.AddAction(\"BUTTON 1\")").Append(__c.CRLF);
 //BA.debugLineNum = 225;BA.debugLine="code3.Append(\"page.Cell(8,1).AddComponent(card3)\"";
_code3.Append("page.Cell(8,1).AddComponent(card3)").Append(__c.CRLF);
 //BA.debugLineNum = 227;BA.debugLine="page.Cell(9,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code3",_code3)));
 //BA.debugLineNum = 230;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildHeade";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr3b","Card Sizes")));
 //BA.debugLineNum = 233;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3b","If you want to have uniformly sized cards, you can use our premade size types. Just add the size type in the Initialize method. The width is not affected by this parameter but is determined by your cell size.")));
 //BA.debugLineNum = 236;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildSubHe";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader(_page,"hdr4b","CARD_SMALL")));
 //BA.debugLineNum = 239;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4b","The Small Card limits the height of the card to 300px.")));
 //BA.debugLineNum = 242;BA.debugLine="Dim card4 As ABMCard";
_card4 = new com.ab.abmaterial.ABMCard();
 //BA.debugLineNum = 243;BA.debugLine="card4.InitializeAsCard(page, \"card4\", \"Small\", \"N";
_card4.InitializeAsCard(_page,"card4","Small","Note: Because I have a fixed height, my text may not fit!",_abm.CARD_SMALL,"whitetitle");
 //BA.debugLineNum = 244;BA.debugLine="card4.Image = \"../images/sample-1.jpg\"";
_card4.Image = "../images/sample-1.jpg";
 //BA.debugLineNum = 245;BA.debugLine="card4.AddAction(\"BUTTON 1\")";
_card4.AddAction("BUTTON 1");
 //BA.debugLineNum = 246;BA.debugLine="card4.AddAction(\"BUTTON 2\")";
_card4.AddAction("BUTTON 2");
 //BA.debugLineNum = 247;BA.debugLine="page.Cell(11,1).AddComponent(card4)";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_card4));
 //BA.debugLineNum = 250;BA.debugLine="page.Cell(12,1).AddComponent(ABMShared.BuildSubHe";
_page.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader(_page,"hdr5","CARD_MEDIUM")));
 //BA.debugLineNum = 253;BA.debugLine="page.Cell(12,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par5","The Medium Card limits the height of the card to 400px.")));
 //BA.debugLineNum = 256;BA.debugLine="Dim card5 As ABMCard";
_card5 = new com.ab.abmaterial.ABMCard();
 //BA.debugLineNum = 257;BA.debugLine="card5.InitializeAsCard(page, \"card5\", \"Medium\", \"";
_card5.InitializeAsCard(_page,"card5","Medium","Note: Because I have a fixed height, my text may not fit!",_abm.CARD_MEDIUM,"whitetitle");
 //BA.debugLineNum = 258;BA.debugLine="card5.Image = \"../images/sample-1.jpg\"";
_card5.Image = "../images/sample-1.jpg";
 //BA.debugLineNum = 259;BA.debugLine="card5.AddAction(\"BUTTON 1\")";
_card5.AddAction("BUTTON 1");
 //BA.debugLineNum = 260;BA.debugLine="card5.AddAction(\"BUTTON 2\")";
_card5.AddAction("BUTTON 2");
 //BA.debugLineNum = 261;BA.debugLine="page.Cell(13,1).AddComponent(card5)";
_page.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_card5));
 //BA.debugLineNum = 264;BA.debugLine="page.Cell(14,1).AddComponent(ABMShared.BuildSubHe";
_page.Cell((int) (14),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader(_page,"hdr6","CARD_LARGE")));
 //BA.debugLineNum = 267;BA.debugLine="page.Cell(14,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (14),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par6","The Large Card limits the height of the card to 500px.")));
 //BA.debugLineNum = 270;BA.debugLine="Dim card6 As ABMCard";
_card6 = new com.ab.abmaterial.ABMCard();
 //BA.debugLineNum = 271;BA.debugLine="card6.InitializeAsCard(page, \"card6\", \"Large\", \"N";
_card6.InitializeAsCard(_page,"card6","Large","Note: Because I have a fixed height, my text may not fit!",_abm.CARD_LARGE,"whitetitle");
 //BA.debugLineNum = 272;BA.debugLine="card6.Image = \"../images/sample-1.jpg\"";
_card6.Image = "../images/sample-1.jpg";
 //BA.debugLineNum = 273;BA.debugLine="card6.AddAction(\"BUTTON 1\")";
_card6.AddAction("BUTTON 1");
 //BA.debugLineNum = 274;BA.debugLine="card6.AddAction(\"BUTTON 2\")";
_card6.AddAction("BUTTON 2");
 //BA.debugLineNum = 275;BA.debugLine="page.Cell(15,1).AddComponent(card6)";
_page.Cell((int) (15),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_card6));
 //BA.debugLineNum = 278;BA.debugLine="page.Cell(16,1).AddComponent(ABMShared.BuildHeade";
_page.Cell((int) (16),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr7","Card Panel")));
 //BA.debugLineNum = 281;BA.debugLine="page.Cell(16,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (16),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par7","For a simpler card with less markup, try using a card panel which just has padding and a shadow effect")));
 //BA.debugLineNum = 284;BA.debugLine="Dim card7 As ABMCard";
_card7 = new com.ab.abmaterial.ABMCard();
 //BA.debugLineNum = 285;BA.debugLine="card7.InitializeAsPanel(page, \"card7\", \"I am a ve";
_card7.InitializeAsPanel(_page,"card7","I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively. I am similar to what is called a panel in other frameworks.","redpanel");
 //BA.debugLineNum = 286;BA.debugLine="page.Cell(17,1).AddComponent(card7)";
_page.Cell((int) (17),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_card7));
 //BA.debugLineNum = 289;BA.debugLine="Dim code4 As StringBuilder";
_code4 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 290;BA.debugLine="code4.Initialize";
_code4.Initialize();
 //BA.debugLineNum = 291;BA.debugLine="code4.Append(\"Dim card4 As ABMCard\").Append(CRLF)";
_code4.Append("Dim card4 As ABMCard").Append(__c.CRLF);
 //BA.debugLineNum = 292;BA.debugLine="code4.Append(\"card7.InitializeAsPanel(page, \"\"car";
_code4.Append("card7.InitializeAsPanel(page, \"card7\", \"I am a very simple card. I am good at containing small bits of information. I am convenient because I require little markup to use effectively. I am similar to what is called a panel in other frameworks.\" ,\"redpanel\"))").Append(__c.CRLF);
 //BA.debugLineNum = 293;BA.debugLine="code4.Append(\"page.Cell(17,1).AddComponent(card7)";
_code4.Append("page.Cell(17,1).AddComponent(card7)").Append(__c.CRLF);
 //BA.debugLineNum = 295;BA.debugLine="page.Cell(18,1).AddComponent(ABMShared.BuildCodeB";
_page.Cell((int) (18),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code4",_code4)));
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
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 309;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 310;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 311;BA.debugLine="If Action = \"ABMCard\" Then Return";
if ((_action).equals("ABMCard")) { 
if (true) return "";};
 //BA.debugLineNum = 312;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 313;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 314;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 315;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 317;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 318;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 319;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 321;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 322;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 324;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 325;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 326;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 327;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 328;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 329;BA.debugLine="End Sub";
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
