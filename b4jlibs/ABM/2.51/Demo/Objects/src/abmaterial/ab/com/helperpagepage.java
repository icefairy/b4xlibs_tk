package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class helperpagepage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.helperpagepage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.helperpagepage.class).invoke(this, new Object[] {null});
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
public int _tmpcardid = 0;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 103;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 105;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 108;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 109;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 110;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 111;BA.debugLine="page.PageTitle = \"ABMPage\"";
_page.PageTitle = "ABMPage";
 //BA.debugLineNum = 112;BA.debugLine="page.PageDescription = \"The page helper\"";
_page.PageDescription = "The page helper";
 //BA.debugLineNum = 113;BA.debugLine="page.PageHTMLName = \"abmaterial-page.html\"";
_page.PageHTMLName = "abmaterial-page.html";
 //BA.debugLineNum = 114;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 115;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 116;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 117;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 120;BA.debugLine="page.SetBackgroundVideo(\"../images/webm.webm\", \".";
_page.SetBackgroundVideo("../images/webm.webm","../images/mp4.mp4","../images/ogv.ogv",__c.True,(int) (0),__c.True,"../images/poster.jpg");
 //BA.debugLineNum = 124;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMPage\", \"..";
_abmshared._buildnavigationbar(_page,"ABMPage","../images/logo.png","","Helpers","ABMPage");
 //BA.debugLineNum = 127;BA.debugLine="page.AddRows(1,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 128;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 130;BA.debugLine="ABMShared.BuildFooterFixed(page)";
_abmshared._buildfooterfixed(_page);
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 88;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 90;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 91;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 94;BA.debugLine="theme.AddContainerTheme(\"bluegrey\")";
_theme.AddContainerTheme("bluegrey");
 //BA.debugLineNum = 95;BA.debugLine="theme.Container(\"bluegrey\").BackColor = ABM.COLOR";
_theme.Container("bluegrey").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 96;BA.debugLine="theme.Container(\"bluegrey\").BackColorIntensity =";
_theme.Container("bluegrey").BackColorIntensity = _abm.INTENSITY_LIGHTEN4;
 //BA.debugLineNum = 98;BA.debugLine="theme.AddCardTheme(\"whitetitle\")";
_theme.AddCardTheme("whitetitle");
 //BA.debugLineNum = 99;BA.debugLine="theme.Card(\"whitetitle\").TitleForeColor = ABM.COL";
_theme.Card("whitetitle").TitleForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"HelperPagePage\"";
_name = "HelperPagePage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="Dim tmpCardId As Int";
_tmpcardid = 0;
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMContainer _pagecont = null;
String _code = "";
anywheresoftware.b4a.keywords.StringBuilderWrapper _code3 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code4 = null;
String _code8 = "";
String _code6 = "";
String _code7 = "";
 //BA.debugLineNum = 133;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 135;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 138;BA.debugLine="Dim pagecont As ABMContainer";
_pagecont = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 139;BA.debugLine="pagecont.Initialize(page, \"cont\", \"bluegrey\")";
_pagecont.Initialize(_page,"cont","bluegrey");
 //BA.debugLineNum = 140;BA.debugLine="pagecont.AddRows(17,True, \"bluegrey\").AddCells12(";
_pagecont.AddRows((int) (17),__c.True,"bluegrey").AddCells12((int) (1),"");
 //BA.debugLineNum = 141;BA.debugLine="pagecont.BuildGrid 'IMPORTANT once you loaded the";
_pagecont.BuildGrid();
 //BA.debugLineNum = 144;BA.debugLine="pagecont.Cell(1,1).AddComponent(ABMShared.BuildPa";
_pagecont.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","ABMPage is the main entrypoint to your webpage in a B4J Server WebSocket class. If you've copied the ABMPageTemplate, page and all its events will be declared for you.")));
 //BA.debugLineNum = 147;BA.debugLine="pagecont.Cell(1,1).AddComponent(ABMShared.BuildPa";
_pagecont.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","It is good practice to have to methods in your page class: BuildTheme() and BuildPage().  BuildTheme() can be used to set up all your themes you are going to use in this page. You can inherit all the themes you declared in ABMShared using the AddABMTheme() method, and create additional themes for this page specific.")));
 //BA.debugLineNum = 149;BA.debugLine="Dim code As String = $\"public Sub BuildTheme() 	/";
_code = ("public Sub BuildTheme()\n"+"	// start with the base theme defined in ABMShared\n"+"	theme.Initialize(\"pagetheme\")\n"+"	theme.AddABMTheme(ABMShared.MyTheme)\n"+"	\n"+"	// add additional themes specific for this page\n"+"	theme.AddContainerTheme(\"white\")\n"+"	theme.Container(\"White\").BackColor = ABM.COLOR_WHITE\n"+"	theme.Container(\"White\").ZDepth = ABM.ZDEPTH_1\n"+"End Sub");
 //BA.debugLineNum = 160;BA.debugLine="pagecont.Cell(2,1).AddComponent(ABMShared.BuildCo";
_pagecont.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code)));
 //BA.debugLineNum = 163;BA.debugLine="pagecont.Cell(3,1).AddComponent(ABMShared.BuildPa";
_pagecont.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","BuildPage() has to be setup in a certain way before you can start adding controls. First, load your themes. Next Initialize the Page object and add a navigation bar if you need one. Before we can add components, we have to desing our page grid.  If you have not read the part on Grids, this is now a good time.")));
 //BA.debugLineNum = 165;BA.debugLine="pagecont.Cell(3,1).AddComponent(ABMShared.BuildPa";
_pagecont.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraphbq(_page,"par4","Once you have added all your rows and cells you must use the BuildGrid command {B}BEFORE{/B} you start adding components!")));
 //BA.debugLineNum = 167;BA.debugLine="code = $\"public Sub BuildPage() 	// initialize th";
_code = ("public Sub BuildPage()\n"+"	// initialize the theme\n"+"	BuildTheme\n"+"	\n"+"	// initialize this page using our theme\n"+"	page.InitializeWithTheme(Name, \"/ws/\" & AppName & \"/\" & Name, False, theme)\n"+"	page.ShowLoader=True\n"+"		\n"+"	ABMShared.BuildNavigationBar(page, \"ABMPage\", \"../images/logo.png\", \"\", \"Helpers\", \"ABMPage\")\n"+"		\n"+"	// create the page grid\n"+"	page.AddRows(5,True, \"\").AddCells12(1,\"\")\n"+"	page.BuildGrid //IMPORTANT once you loaded the complete grid AND before you start adding components\n"+"End Sub");
 //BA.debugLineNum = 182;BA.debugLine="pagecont.Cell(4,1).AddComponent(ABMShared.BuildCo";
_pagecont.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code2",_code)));
 //BA.debugLineNum = 185;BA.debugLine="pagecont.Cell(5,1).AddComponent(ABMShared.BuildHe";
_pagecont.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Start adding components")));
 //BA.debugLineNum = 187;BA.debugLine="pagecont.Cell(5,1).AddComponent(ABMShared.BuildPa";
_pagecont.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par5","You can add components to a cell with two methods: AddComponent() or AddArrayComponent(). To add a component to a specific cell, 'navigate' to the cell width Page.cell(rowIndex,cellIndex). RowIndex and cellIndex are One-Based: meaning, the first row = 1, the first cell within a row = 1. Because you have to use Page.Cell() to position yourself within you page, you can see how important it is you've designed your grid well before adding components.  If you have to 'insert' a row, you will have to go change the all the Page.Cell() lines after it to correct them.  I'm thinking of a way to avoid this problem so that you can add components 'relative' to the previous row. (work in progress).")));
 //BA.debugLineNum = 189;BA.debugLine="pagecont.Cell(5,1).AddComponent(ABMShared.BuildPa";
_pagecont.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par6","The code to add this line label looks like this (adding it to row 5, cell 1)")));
 //BA.debugLineNum = 191;BA.debugLine="code = $\"// add paragraph	 page.Cell(5,1).AddComp";
_code = ("// add paragraph	\n"+"page.Cell(5,1).AddComponent(ABMShared.BuildParagraph(page,\"par6\",\"The code to add this line label looks like this (adding it to row 5, cell 1)\") )");
 //BA.debugLineNum = 194;BA.debugLine="pagecont.Cell(6,1).AddComponent(ABMShared.BuildCo";
_pagecont.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code3",_code)));
 //BA.debugLineNum = 197;BA.debugLine="pagecont.Cell(7,1).AddComponent(ABMShared.BuildPa";
_pagecont.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraphbq(_page,"par7","When you go through the code, you will see several components are added to the same row and cell. Therefor it is important you give each component {B}a unique ID{/B}.  Internally, ABMaterial uses a Map() object to organize the components, and the same IDs will overwrite each other.  One exception you may overlook this rule is: 1. You do not need to access the control anywhere in your code (like a static label) AND 2. the components are in different rows.  But generally, just give them all a unique id, and you do not have to worry about this.")));
 //BA.debugLineNum = 200;BA.debugLine="pagecont.Cell(8,1).AddComponent(ABMShared.BuildHe";
_pagecont.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"par8","How about AddArrayComponent()?")));
 //BA.debugLineNum = 203;BA.debugLine="pagecont.Cell(8,1).AddComponent(ABMShared.BuildPa";
_pagecont.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par9","AddArrayComponent is a shortcut function to add several components that will share the same event code. For example, on the ABMChip page, we add the chips with AddArrayComponent() because we do not know how many chips there are going to be and we can't write a click event for each of them seperately.")));
 //BA.debugLineNum = 206;BA.debugLine="pagecont.Cell(8,1).AddComponent(ABMShared.BuildPa";
_pagecont.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par10","I found it practical giving the 'Array' components just the numeric part of the ID. This way you can use the Event name as you would any other event. e.g. here: 'mycheck' is the ArrayName, and '5', '6', '7', '8' are the IDs.  Now we can use mycheck_Clicked() and use the target to get our individual component.")));
 //BA.debugLineNum = 209;BA.debugLine="Dim code3 As StringBuilder";
_code3 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 210;BA.debugLine="code3.Initialize";
_code3.Initialize();
 //BA.debugLineNum = 211;BA.debugLine="code3.Append(\"// create the chips\").Append(CRLF)";
_code3.Append("// create the chips").Append(__c.CRLF);
 //BA.debugLineNum = 212;BA.debugLine="code3.Append(\"Dim ch5 As ABMChip\").Append(CRLF)";
_code3.Append("Dim ch5 As ABMChip").Append(__c.CRLF);
 //BA.debugLineNum = 213;BA.debugLine="code3.Append(\"ch5.Initialize(page, \"\"5\"\", \"\"Dad\"\"";
_code3.Append("ch5.Initialize(page, \"5\", \"Dad\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 214;BA.debugLine="code3.Append(\"ch5.Image = \"\"../images/dad.jpg\"\"\")";
_code3.Append("ch5.Image = \"../images/dad.jpg\"").Append(__c.CRLF);
 //BA.debugLineNum = 215;BA.debugLine="code3.Append(\"page.Cell(8,1).AddArrayComponent(ch";
_code3.Append("page.Cell(8,1).AddArrayComponent(ch5, \"mycheck\")").Append(__c.CRLF);
 //BA.debugLineNum = 216;BA.debugLine="code3.Append(\"\").Append(CRLF)";
_code3.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 217;BA.debugLine="code3.Append(\"Dim ch6 As ABMChip\").Append(CRLF)";
_code3.Append("Dim ch6 As ABMChip").Append(__c.CRLF);
 //BA.debugLineNum = 218;BA.debugLine="code3.Append(\"ch6.Initialize(page, \"\"6\"\", \"\"Mom\"\"";
_code3.Append("ch6.Initialize(page, \"6\", \"Mom\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 219;BA.debugLine="code3.Append(\"ch6.Image = \"\"../images/mom.jpg\"\"\")";
_code3.Append("ch6.Image = \"../images/mom.jpg\"").Append(__c.CRLF);
 //BA.debugLineNum = 220;BA.debugLine="code3.Append(\"page.Cell(8,1).AddArrayComponent(ch";
_code3.Append("page.Cell(8,1).AddArrayComponent(ch6, \"mycheck\")").Append(__c.CRLF);
 //BA.debugLineNum = 221;BA.debugLine="code3.Append(\"\").Append(CRLF)";
_code3.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 222;BA.debugLine="code3.Append(\"Dim ch7 As ABMChip\").Append(CRLF)";
_code3.Append("Dim ch7 As ABMChip").Append(__c.CRLF);
 //BA.debugLineNum = 223;BA.debugLine="code3.Append(\"ch7.Initialize(page, \"\"7\"\", \"\"Broth";
_code3.Append("ch7.Initialize(page, \"7\", \"Brother\", True, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 224;BA.debugLine="code3.Append(\"ch7.Image = \"\"../images/brother.jpg";
_code3.Append("ch7.Image = \"../images/brother.jpg\"").Append(__c.CRLF);
 //BA.debugLineNum = 225;BA.debugLine="code3.Append(\"page.Cell(8,1).AddArrayComponent(ch";
_code3.Append("page.Cell(8,1).AddArrayComponent(ch7, \"mycheck\")").Append(__c.CRLF);
 //BA.debugLineNum = 226;BA.debugLine="code3.Append(\"\").Append(CRLF)";
_code3.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 227;BA.debugLine="code3.Append(\"Dim ch8 As ABMChip\").Append(CRLF)";
_code3.Append("Dim ch8 As ABMChip").Append(__c.CRLF);
 //BA.debugLineNum = 228;BA.debugLine="code3.Append(\"ch8.Initialize(page, \"\"8\"\", \"\"Siste";
_code3.Append("ch8.Initialize(page, \"8\", \"Sister\", True, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 229;BA.debugLine="code3.Append(\"ch8.Image = \"\"../images/sister.jpg\"";
_code3.Append("ch8.Image = \"../images/sister.jpg\"").Append(__c.CRLF);
 //BA.debugLineNum = 230;BA.debugLine="code3.Append(\"page.Cell(8,1).AddArrayComponent(ch";
_code3.Append("page.Cell(8,1).AddArrayComponent(ch8, \"mycheck\")").Append(__c.CRLF);
 //BA.debugLineNum = 232;BA.debugLine="pagecont.Cell(8,1).AddComponent(ABMShared.BuildCo";
_pagecont.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code3",_code3)));
 //BA.debugLineNum = 235;BA.debugLine="Dim code4 As StringBuilder";
_code4 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 236;BA.debugLine="code4.Initialize";
_code4.Initialize();
 //BA.debugLineNum = 237;BA.debugLine="code4.Append(\"Sub mycheck_Clicked(Target As Strin";
_code4.Append("Sub mycheck_Clicked(Target As String)").Append(__c.CRLF);
 //BA.debugLineNum = 238;BA.debugLine="code4.Append(\"   Dim chip As ABMChip = page.Compo";
_code4.Append("   Dim chip As ABMChip = page.Component(Target)").Append(__c.CRLF);
 //BA.debugLineNum = 239;BA.debugLine="code4.Append(\"   Dim title As String = chip.Text\"";
_code4.Append("   Dim title As String = chip.Text").Append(__c.CRLF);
 //BA.debugLineNum = 240;BA.debugLine="code4.Append(\"   Dim myTexts, myReturns As List\")";
_code4.Append("   Dim myTexts, myReturns As List").Append(__c.CRLF);
 //BA.debugLineNum = 241;BA.debugLine="code4.Append(\"   myTexts.Initialize\").Append(CRLF";
_code4.Append("   myTexts.Initialize").Append(__c.CRLF);
 //BA.debugLineNum = 242;BA.debugLine="code4.Append(\"   myReturns.Initialize\").Append(CR";
_code4.Append("   myReturns.Initialize").Append(__c.CRLF);
 //BA.debugLineNum = 243;BA.debugLine="code4.Append(\"   myToastId = myToastId + 1\").Appe";
_code4.Append("   myToastId = myToastId + 1").Append(__c.CRLF);
 //BA.debugLineNum = 244;BA.debugLine="code4.Append(\"   page.ShowToast(\"\"toast\"\" & myToa";
_code4.Append("   page.ShowToast(\"toast\" & myToastId, \"toastgreen\", \"Clicked \" & title, 5000, myTexts, myReturns)").Append(__c.CRLF);
 //BA.debugLineNum = 245;BA.debugLine="code4.Append(\"End Sub\").Append(CRLF)";
_code4.Append("End Sub").Append(__c.CRLF);
 //BA.debugLineNum = 247;BA.debugLine="pagecont.Cell(8,1).AddComponent(ABMShared.BuildCo";
_pagecont.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code4",_code4)));
 //BA.debugLineNum = 250;BA.debugLine="pagecont.Cell(9,1).AddComponent(ABMShared.BuildHe";
_pagecont.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"par10","Adding a footer to your page")));
 //BA.debugLineNum = 253;BA.debugLine="pagecont.Cell(9,1).AddComponent(ABMShared.BuildPa";
_pagecont.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par11","Each page can have a footer.  You have floating and fixed footers.  The footers on all the pages in this app are floating (they scroll with the page), except the one on this page which is fixed (it is always on the bottom of your screen, no mather how you scroll the body).  This can be handy if you want to have e.g. buttons on the bottom of your app that should be accessible at all time. Footer is an ABMContainer, so you can put whatever ABMComponent into it, making it a powerful taskbar.")));
 //BA.debugLineNum = 256;BA.debugLine="pagecont.Cell(9,1).AddComponent(ABMShared.BuildPa";
_pagecont.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraphbq(_page,"par12","When you use a fixed footer, you need to set the padding in pixels of the bottom of the page!")));
 //BA.debugLineNum = 258;BA.debugLine="code = $\"Sub BuildFooterFixed(page As ABMPage)";
_code = ("Sub BuildFooterFixed(page As ABMPage)	\n"+"	page.isFixedFooter= True\n"+"	// because we have a fixed footer at the bottom, we have to adjust the padding of the body in pixels\n"+"	page.PaddingBottom = 150\n"+"	\n"+"	page.Footer.AddRows(1, True, \"\").AddCellsOS(2,0,0,0,6,6,6, \"\") \n"+"	page.Footer.BuildGrid //IMPORTANT once you loaded the complete grid AND before you start adding components	\n"+"	\n"+"	page.Footer.UseTheme(\"footertheme\")\n"+"	\n"+"	Dim lbl1 As ABMLabel\n"+"	lbl1.Initialize(page, \"footlbl1\", \"Blog: Alwaysbusy's Corner{BR}{BR}B4J by Anywhere Software{BR}Materialize CSS by students from Carnegie Mellon University\",ABM.SIZE_PARAGRAPH, False, \"whitefc\")\n"+"	page.Footer.Cell(1,1).AddComponent(lbl1)\n"+"	\n"+"	Dim lbl2 As ABMLabel\n"+"	lbl2.Initialize(page, \"footlbl2\", \"ABMaterial Copyright @2015-2016{BR}By Alain Bailleul{BR}{BR}Email: alain.bailleul@telenet.be\",ABM.SIZE_PARAGRAPH, False, \"whitefc\")\n"+"	page.Footer.Cell(1,2).AddComponent(lbl2)	\n"+"End Sub");
 //BA.debugLineNum = 277;BA.debugLine="pagecont.Cell(10,1).AddComponent(ABMShared.BuildC";
_pagecont.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code5",_code)));
 //BA.debugLineNum = 280;BA.debugLine="pagecont.Cell(11,1).AddComponent(ABMShared.BuildH";
_pagecont.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr10","Pausing/Resuming your Page")));
 //BA.debugLineNum = 282;BA.debugLine="pagecont.Cell(11,1).AddComponent(ABMShared.BuildP";
_pagecont.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par15","With Page.Pause you can pause your app.  This can be useful if you have to do something very time consuming on your server and the user has to wait some time. A black transparent overlay with 'loading' animation will be shown over the page.  IMPORTANT! You have to resume the action with Page.Resume. ")));
 //BA.debugLineNum = 286;BA.debugLine="pagecont.Cell(11,1).AddComponent(ABMShared.BuildP";
_pagecont.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par13","A good next read would be the ABMNavigationBar section in the Helpers menu.")));
 //BA.debugLineNum = 289;BA.debugLine="pagecont.Cell(12,1).AddComponent(ABMShared.BuildH";
_pagecont.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr19","Google Analytics and SEO (Search Engine Optimisation)")));
 //BA.debugLineNum = 290;BA.debugLine="pagecont.Cell(12,1).AddComponent(ABMShared.BuildP";
_pagecont.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par19","Unlike many other WebApp tools, ABMaterial allows you to use SEO and Google Analytics in your WebApps.  This can be done by adding just a couple of extra lines in the BuildPage method!")));
 //BA.debugLineNum = 292;BA.debugLine="Dim code8 As String = $\"page.InitializeWithTheme(";
_code8 = ("page.InitializeWithTheme(Name, \"/ws/\" & AppName & \"/\" & Name, False, theme)\n"+"page.ShowLoader=True\n"+"page.PageTitle = \"ABMPage\"\n"+"page.PageDescription = \"The page helper\"	\n"+"page.PageHTMLName = \"abmaterial-page.html\"\n"+"page.PageKeywords = \"ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization\"\n"+"page.PageSiteMapPriority = \"0.50\"\n"+"page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONTHLY\n"+"page.UseGoogleAnalytics(\"UA-73003715-6\", Null)\n"+"page.RunGoogleAnalyticsCommand(\"'send', 'event', 'link', 'click', 'http://example.com', {nonInteraction: True}\")");
 //BA.debugLineNum = 303;BA.debugLine="pagecont.Cell(13,1).AddComponent(ABMShared.BuildC";
_pagecont.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code8",_code8)));
 //BA.debugLineNum = 307;BA.debugLine="pagecont.Cell(14,1).AddComponent(ABMShared.BuildH";
_pagecont.Cell((int) (14),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr18","Infinite Scrolling Pages")));
 //BA.debugLineNum = 310;BA.debugLine="pagecont.Cell(14,1).AddComponent(ABMShared.BuildP";
_pagecont.Cell((int) (14),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par18","Using the 'page.RaiseNextContentOnComponent()' method you can create infinite pages. Keep scrollong down and new cards will be added!")));
 //BA.debugLineNum = 312;BA.debugLine="Dim code6 As String = $\"Sub Page_NextContent(Trig";
_code6 = ("Sub Page_NextContent(TriggerComponent As String)\n"+"	LoadNewCard\n"+"End Sub");
 //BA.debugLineNum = 316;BA.debugLine="pagecont.Cell(16,1).AddComponent(ABMShared.BuildC";
_pagecont.Cell((int) (16),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code6",_code6)));
 //BA.debugLineNum = 318;BA.debugLine="Dim code6 As String = $\"Sub Page_NextContent(Trig";
_code6 = ("Sub Page_NextContent(TriggerComponent As String)\n"+"	LoadNewCard\n"+"End Sub");
 //BA.debugLineNum = 322;BA.debugLine="Dim code7 As String = $\"Sub LoadNewCard()  	Dim p";
_code7 = ("Sub LoadNewCard() \n"+"	Dim pagecont As ABMContainer = page.Component(\"cont\")\n"+"	// build the card\n"+"	Dim tmpCard As ABMCard\n"+"	tmpCardId = tmpCardId + 1\n"+"	DateTime.TimeFormat = \"HH:mm:ss\"\n"+"	tmpCard.InitializeAsCard(page, \"card\" & tmpCardId, DateTime.Date(DateTime.Now) & \" \" & DateTime.Time(DateTime.now), \"This is a new card from an infinite page\", ABM.CARD_LARGE, \"whitetitle\")\n"+"	Dim picNr As Int = Rnd(1,96)\n"+"	tmpCard.Image = \"../images2/\" & picNr & \".jpg\"\n"+"	tmpCard.AddAction(\"BUTTON 1\")	\n"+"	// add the card and refresh\n"+"	pagecont.Cell(15,1).AddComponent(tmpCard)\n"+"	pagecont.cell(15,1).Refresh\n"+"	// set this card as the new trigger\n"+"	page.RaiseNextContentOnComponent(tmpCard,200)\n"+"End Sub");
 //BA.debugLineNum = 339;BA.debugLine="pagecont.Cell(16,1).AddComponent(ABMShared.BuildC";
_pagecont.Cell((int) (16),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code7",_code7)));
 //BA.debugLineNum = 341;BA.debugLine="page.Cell(1,1).AddComponent(pagecont)";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_pagecont));
 //BA.debugLineNum = 344;BA.debugLine="ABMShared.ConnectFooterFixed(page)";
_abmshared._connectfooterfixed(_page);
 //BA.debugLineNum = 346;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 349;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 351;BA.debugLine="LoadNewCard";
_loadnewcard();
 //BA.debugLineNum = 353;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 354;BA.debugLine="End Sub";
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
public String  _loadnewcard() throws Exception{
com.ab.abmaterial.ABMContainer _pagecont = null;
com.ab.abmaterial.ABMCard _tmpcard = null;
int _picnr = 0;
 //BA.debugLineNum = 360;BA.debugLine="Sub LoadNewCard()";
 //BA.debugLineNum = 361;BA.debugLine="Dim pagecont As ABMContainer = page.Component(\"co";
_pagecont = (com.ab.abmaterial.ABMContainer)(_page.Component("cont"));
 //BA.debugLineNum = 363;BA.debugLine="Dim tmpCard As ABMCard";
_tmpcard = new com.ab.abmaterial.ABMCard();
 //BA.debugLineNum = 364;BA.debugLine="tmpCardId = tmpCardId + 1";
_tmpcardid = (int) (_tmpcardid+1);
 //BA.debugLineNum = 365;BA.debugLine="DateTime.TimeFormat = \"HH:mm:ss\"";
__c.DateTime.setTimeFormat("HH:mm:ss");
 //BA.debugLineNum = 366;BA.debugLine="tmpCard.InitializeAsCard(page, \"card\" & tmpCardId";
_tmpcard.InitializeAsCard(_page,"card"+BA.NumberToString(_tmpcardid),__c.DateTime.Date(__c.DateTime.getNow())+" "+__c.DateTime.Time(__c.DateTime.getNow()),"This is a new card from an infinite page",_abm.CARD_LARGE,"whitetitle");
 //BA.debugLineNum = 367;BA.debugLine="Dim picNr As Int = Rnd(1,96)";
_picnr = __c.Rnd((int) (1),(int) (96));
 //BA.debugLineNum = 368;BA.debugLine="tmpCard.Image = \"../images2/\" & picNr & \".jpg\"";
_tmpcard.Image = "../images2/"+BA.NumberToString(_picnr)+".jpg";
 //BA.debugLineNum = 369;BA.debugLine="tmpCard.AddAction(\"BUTTON 1\")";
_tmpcard.AddAction("BUTTON 1");
 //BA.debugLineNum = 371;BA.debugLine="pagecont.Cell(17,1).AddComponent(tmpCard)";
_pagecont.Cell((int) (17),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_tmpcard));
 //BA.debugLineNum = 372;BA.debugLine="pagecont.cell(17,1).Refresh";
_pagecont.Cell((int) (17),(int) (1)).Refresh();
 //BA.debugLineNum = 374;BA.debugLine="page.RaiseNextContentOnComponent(tmpCard,200)";
_page.RaiseNextContentOnComponent((com.ab.abmaterial.ABMComponent)(_tmpcard),(int) (200));
 //BA.debugLineNum = 375;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 379;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 380;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 381;BA.debugLine="If Action = \"ABMPage\" Then Return";
if ((_action).equals("ABMPage")) { 
if (true) return "";};
 //BA.debugLineNum = 382;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 383;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 384;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 385;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 387;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 388;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 389;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 391;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 392;BA.debugLine="End Sub";
return "";
}
public String  _page_nextcontent(String _triggercomponent) throws Exception{
 //BA.debugLineNum = 356;BA.debugLine="Sub Page_NextContent(TriggerComponent As String)";
 //BA.debugLineNum = 357;BA.debugLine="LoadNewCard";
_loadnewcard();
 //BA.debugLineNum = 358;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 394;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 395;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 396;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 397;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 398;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
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
