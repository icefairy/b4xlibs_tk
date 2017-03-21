package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class helpernavigationbarpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.helpernavigationbarpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.helpernavigationbarpage.class).invoke(this, new Object[] {null});
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
 //BA.debugLineNum = 96;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 98;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 101;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 102;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 103;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 104;BA.debugLine="page.PageTitle = \"ABMNavigationBar\"";
_page.PageTitle = "ABMNavigationBar";
 //BA.debugLineNum = 105;BA.debugLine="page.PageDescription = \"The navigation bar helper";
_page.PageDescription = "The navigation bar helper";
 //BA.debugLineNum = 106;BA.debugLine="page.PageHTMLName = \"abmaterial-navigation-bar.ht";
_page.PageHTMLName = "abmaterial-navigation-bar.html";
 //BA.debugLineNum = 107;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 108;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 109;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 110;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 112;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMNavigation";
_abmshared._buildnavigationbar(_page,"ABMNavigationBar","../images/logo.png","","Helpers","ABMNavigationBar");
 //BA.debugLineNum = 115;BA.debugLine="page.AddRows(12,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (12),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 116;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 121;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"HelperNavigationBarPage\"";
_name = "HelperNavigationBarPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
String _code = "";
anywheresoftware.b4a.objects.collections.List _headers = null;
anywheresoftware.b4a.objects.collections.List _codes = null;
anywheresoftware.b4a.objects.collections.List _descriptions = null;
 //BA.debugLineNum = 124;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 126;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 129;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Introduction")));
 //BA.debugLineNum = 131;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","ABMNavigationBar is not a real stand-alone component, but a property of an ABMPage.  This is why it is placed under Helpers.")));
 //BA.debugLineNum = 134;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr2","How does it work")));
 //BA.debugLineNum = 136;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","Building a Naviagion Bar with an optional Side Bar is really easy in ABMaterial. It is important to know that for every page that uses the Navigation Bar, you must create the complete bar, just changing the active items. The sidebar can have only {B}one{/B} sublevel in the tree.")));
 //BA.debugLineNum = 138;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","Let's start with checking out the code we used for this WebApp and I'll explain afterwards.")));
 //BA.debugLineNum = 142;BA.debugLine="Dim code As String = $\"Sub BuildNavigationBar(pag";
_code = ("Sub BuildNavigationBar(page As ABMPage, Title As String, logo As String, ActiveTopReturnName As String, ActiveSideReturnName As String, ActiveSideSubReturnName As String) \n"+"	page.NavigationBar.Initialize(page, \"nav1\", Title, ABM.TEXTALIGN_LEFT, False, True, False,True, 300, 48, logo, ABM.COLLAPSE_ACCORDION, \"nav1theme\")\n"+"	page.NavigationBar.ActiveTopReturnName = ActiveTopReturnName\n"+"	page.NavigationBar.ActiveSideReturnName = ActiveSideReturnName\n"+"	page.NavigationBar.ActiveSideSubReturnName = ActiveSideSubReturnName\n"+"			\n"+"	// this is a special one: a full screen toggle icon.  Will be handled automatically\n"+"	// this is experimental, as it has side effects e.g. when you navigate to another page, it is switched of again\n"+"	// nb.AddTopFullScreenIcon\n"+"	\n"+"	page.NavigationBar.AddTopItem(\"Contact\", \"\", \"mdi-action-account-circle\", \"\")\n"+"		\n"+"	page.NavigationBar.AddSideBarItem(\"About\", \"About\", \"mdi-action-dashboard\", \"../AboutPage\")\n"+"	page.NavigationBar.AddSideBarItem(\"GettingStarted\", \"Getting started\", \"mdi-editor-insert-comment\", \"../GettingStartedPage\")\n"+"	page.NavigationBar.AddSideBarItem(\"Themes\", \"Themes\", \"mdi-action-invert-colors\", \"../ThemesPage\")\n"+"	page.NavigationBar.AddSideBarItem(\"Layouts\", \"Grids\", \"mdi-editor-border-all\", \"../GridsPage\")	\n"+"	page.NavigationBar.AddSideBarDivider(\"\")\n"+"	page.NavigationBar.AddSideBarItem(\"Controls\", \"Controls\", \"mdi-image-palette\", \"\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMActionButton\", \"ABMActionButton\", \"\", \"../CompActionButtonPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMBadge\", \"ABMBadge\", \"\", \"../CompBadgePage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMButton\", \"ABMButton\", \"\", \"../CompButtonPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMCanvas\", \"ABMCanvas\", \"\", \"../CompCanvasPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMCard\", \"ABMCard\", \"\", \"../CompCardPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMCheckbox\", \"ABMCheckbox\", \"\", \"../CompCheckboxPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMCombo\", \"ABMCombo\", \"\", \"../CompComboPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMChip\", \"ABMChip\", \"\", \"../CompChipPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMCodeLabel\", \"ABMCodeLabel\", \"\", \"../CompCodeLabelPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMDivider\", \"ABMDivider\", \"\", \"../CompDividerPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMGoogleMap\", \"ABMGoogleMap\", \"\", \"../CompGoogleMapPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMLabel\", \"ABMLabel\", \"\", \"../CompLabelPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMList\", \"ABMList\", \"\", \"../CompListPage\")	\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMImage\", \"ABMImage\", \"\", \"../CompImagePage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMInput\", \"ABMInput\", \"\", \"../CompInputPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMRadioGroup\", \"ABMRadioGroup\", \"\", \"../CompRadioGroupPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMSignaturePad\", \"ABMSignaturePad\", \"\", \"../CompSignaturePage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMImageSlider\", \"ABMImageSlider\", \"\", \"../CompSliderPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMSwitch\", \"ABMSwitch\", \"\", \"../CompSwitchPage\")	\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMTabs\", \"ABMTabs\", \"\", \"../CompTabsPage\")	\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMUpload\", \"ABMUpload\", \"\", \"../CompUploadPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Controls\", \"ABMVideo\", \"ABMVideo\", \"\", \"../CompVideoPage\")\n"+"	page.NavigationBar.AddSideBarDivider(\"\")	\n"+"	page.NavigationBar.AddSideBarItem(\"Helpers\", \"Helpers\", \"mdi-device-now-widgets\", \"\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Helpers\", \"ABMContainer\", \"ABMContainer\", \"\", \"../HelperContainerPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Helpers\", \"ABMModalSheet\", \"ABMModalSheet\", \"\", \"../HelperModalSheetPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Helpers\", \"ABMNavigationBar\", \"ABMNavigationBar\", \"\", \"../HelperNavigationBarPage\")	\n"+"	page.NavigationBar.AddSideBarSubItem(\"Helpers\", \"ABMPage\", \"ABMPage\", \"\", \"../HelperPagePage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Helpers\", \"ABMParallax\", \"ABMParallax\", \"\", \"../HelperParallaxPage\")\n"+"	page.NavigationBar.AddSideBarSubItem(\"Helpers\", \"ABMTable\", \"ABMTable\", \"\", \"../HelperTablePage\")	\n"+"	page.NavigationBar.AddSideBarDivider(\"\")\n"+"	page.NavigationBar.AddSideBarItem(\"Icons\", \"Icons\", \"mdi-action-account-circle\", \"../IconsPage\")	\n"+"End Sub");
 //BA.debugLineNum = 194;BA.debugLine="page.Cell(2,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code)));
 //BA.debugLineNum = 197;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","We also take the code from the BuildPage() method of this page 'HelperNaviagationBarPage' with us.")));
 //BA.debugLineNum = 199;BA.debugLine="code = $\"ABMShared.BuildNavigationBar(page, \"ABMN";
_code = ("ABMShared.BuildNavigationBar(page, \"ABMNavigationBar\", \"../images/logo.png\", \"\", \"Helpers\", \"ABMNavigationBar\")");
 //BA.debugLineNum = 200;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code2",_code)));
 //BA.debugLineNum = 203;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par5","If we go over the parameters we filled in in the BuildNavigationBar() method, we'll notice we gave it a Title (the text on top), a logo (the picture on the top of the Side Bar saying ABMaterial) and three extra parameters:")));
 //BA.debugLineNum = 206;BA.debugLine="Dim Headers, codes, Descriptions As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
_codes = new anywheresoftware.b4a.objects.collections.List();
_descriptions = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 207;BA.debugLine="Headers.Initialize2(Array As String(\"Param\", \"Des";
_headers.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Param","Description"}));
 //BA.debugLineNum = 208;BA.debugLine="codes.Initialize2(Array As String(\"ActiveTopRetur";
_codes.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"ActiveTopReturnName","ActiveSideReturnName","ActiveSideSubReturnName"}));
 //BA.debugLineNum = 209;BA.debugLine="Descriptions.Initialize2(Array As String(\"If you";
_descriptions.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"If you have multiple TopItems, you set this parameter to be the active one.  In this demo, we have only one item, so we can leave it empty.","This sets the active item from the side bar.  In our example it is 'Helpers'.","This sets the active sub item from the side bar.  In our example it is 'ABMNavigationBar'."}));
 //BA.debugLineNum = 210;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildParamT";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparamtable(_page,"param1",_headers,_codes,_descriptions)));
 //BA.debugLineNum = 213;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par6","We can find those values back in the BuildNavigationBar() method, being params (1) and (2).  Param (3) is here the same, but this is the title of the item. Param(4) is an optional icon name and param(5) is de page we want to jump to when the user clicks on the item.  Note the '../' before as we have to respect the folder tree. (it is one folder down, then the page name in this case.  Check the folder structure in Explorer if you are in doubt.")));
 //BA.debugLineNum = 216;BA.debugLine="Dim code As String = $\"page.NavigationBar.AddSide";
_code = ("page.NavigationBar.AddSideBarSubItem(\"Helpers\", \"ABMNavigationBar\", \"ABMNavigationBar\", \"\", \"../HelperNavigationBarPage\")");
 //BA.debugLineNum = 218;BA.debugLine="page.Cell(8,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code3",_code)));
 //BA.debugLineNum = 221;BA.debugLine="page.Cell(9,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr2","Initialization")));
 //BA.debugLineNum = 223;BA.debugLine="page.Cell(9,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par7","There are some options you can set to the Naviagation Bar during Initialization:")));
 //BA.debugLineNum = 226;BA.debugLine="Dim Headers, codes, Descriptions As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
_codes = new anywheresoftware.b4a.objects.collections.List();
_descriptions = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 227;BA.debugLine="Headers.Initialize2(Array As String(\"Param\", \"Des";
_headers.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Param","Description"}));
 //BA.debugLineNum = 228;BA.debugLine="codes.Initialize2(Array As String(\"page\", \"id\", \"";
_codes.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"page","id","title","alignTitle","alignTopItemsLeftIfTitleCentered","topBarDropDownBelow","hideTopBarItemsOnSmallAndMedium","topBarFixed","sideBarWidthPx","sideBarItemHeightPx","sideBarLogo","sideBarCollapseType","themeName"}));
 //BA.debugLineNum = 229;BA.debugLine="Descriptions.Initialize";
_descriptions.Initialize();
 //BA.debugLineNum = 230;BA.debugLine="Descriptions.Add(\"The page object in you class. I";
_descriptions.Add((Object)("The page object in you class. Is only to be conform with all other controls and may be usefull in the future."));
 //BA.debugLineNum = 231;BA.debugLine="Descriptions.Add(\"The ID of the control.\")";
_descriptions.Add((Object)("The ID of the control."));
 //BA.debugLineNum = 232;BA.debugLine="Descriptions.Add(\"The title on the top bar.\")";
_descriptions.Add((Object)("The title on the top bar."));
 //BA.debugLineNum = 233;BA.debugLine="Descriptions.Add(\"Alignment of the title text. Ca";
_descriptions.Add((Object)("Alignment of the title text. Can be one of the constants ABM.TEXTALIGN_LEFT, ABM.TEXTALIGN_CENTER or ABM.TEXTALIGN_RIGHT."));
 //BA.debugLineNum = 234;BA.debugLine="Descriptions.Add(\"If the Title is centered, do yo";
_descriptions.Add((Object)("If the Title is centered, do you want the items to be on the left of it.  On the right by default."));
 //BA.debugLineNum = 235;BA.debugLine="Descriptions.Add(\"If the topbar has sub items, do";
_descriptions.Add((Object)("If the topbar has sub items, does the dropdown list be under the bar, or over it."));
 //BA.debugLineNum = 236;BA.debugLine="Descriptions.Add(\"Hide all the topbar items if on";
_descriptions.Add((Object)("Hide all the topbar items if on a small screen."));
 //BA.debugLineNum = 237;BA.debugLine="Descriptions.Add(\"If fixed, the top bar stays on";
_descriptions.Add((Object)("If fixed, the top bar stays on top of the window when scrolling the body.  If false, then the top bar will float with the scrolling.  In this Web App, all top bars are fixed."));
 //BA.debugLineNum = 238;BA.debugLine="Descriptions.Add(\"Width of the side bar.\")";
_descriptions.Add((Object)("Width of the side bar."));
 //BA.debugLineNum = 239;BA.debugLine="Descriptions.Add(\"Height of a sidebar item.\")";
_descriptions.Add((Object)("Height of a sidebar item."));
 //BA.debugLineNum = 240;BA.debugLine="Descriptions.Add(\"Logo on the top left of the sid";
_descriptions.Add((Object)("Logo on the top left of the side bar."));
 //BA.debugLineNum = 241;BA.debugLine="Descriptions.Add(\"Can be either the constant ABM.";
_descriptions.Add((Object)("Can be either the constant ABM.COLLAPSE_ACCORDION or ABM.COLLAPSE_EXPANDABLE."));
 //BA.debugLineNum = 242;BA.debugLine="Descriptions.Add(\"The name of the theme you want";
_descriptions.Add((Object)("The name of the theme you want to use."));
 //BA.debugLineNum = 243;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParam";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparamtable(_page,"param1",_headers,_codes,_descriptions)));
 //BA.debugLineNum = 246;BA.debugLine="page.Cell(11,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par8","The Navigation bar has one event NavigationbarClicked(), raised on the page object. Use this event to load another page for example.")));
 //BA.debugLineNum = 248;BA.debugLine="code = $\"Sub Page_NavigationbarClicked(Action As";
_code = ("Sub Page_NavigationbarClicked(Action As String, Value As String)\n"+"	page.SaveNavigationBarPosition	\n"+"	If Action = \"ABMNavigationBar\" Then Return\n"+"	If Action = \"Contact\" Then	\n"+"		myToastId = myToastId + 1	\n"+"		page.ShowToast(\"toast\" & myToastId, \"toastred\", \"Hello to you too!\", 5000)\n"+"		Return\n"+"	End If\n"+"	ABMShared.NavigateToPage(ws, Value)\n"+"End Sub");
 //BA.debugLineNum = 259;BA.debugLine="page.Cell(12,1).AddComponent(ABMShared.BuildCodeB";
_page.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code4",_code)));
 //BA.debugLineNum = 263;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 265;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 268;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 270;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 271;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 274;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 275;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 276;BA.debugLine="If Action = \"ABMNavigationBar\" Then Return";
if ((_action).equals("ABMNavigationBar")) { 
if (true) return "";};
 //BA.debugLineNum = 277;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 278;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 279;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 280;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 282;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 283;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 284;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 286;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 287;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 289;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 290;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 291;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 292;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 293;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 294;BA.debugLine="End Sub";
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
