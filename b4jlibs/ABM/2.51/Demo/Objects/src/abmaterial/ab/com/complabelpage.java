package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class complabelpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.complabelpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.complabelpage.class).invoke(this, new Object[] {null});
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
 //BA.debugLineNum = 98;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 100;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 103;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 104;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 105;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 106;BA.debugLine="page.PageTitle = \"ABMLabel\"";
_page.PageTitle = "ABMLabel";
 //BA.debugLineNum = 107;BA.debugLine="page.PageDescription = \"The label component \"";
_page.PageDescription = "The label component ";
 //BA.debugLineNum = 108;BA.debugLine="page.PageHTMLName = \"abmaterial-label.html\"";
_page.PageHTMLName = "abmaterial-label.html";
 //BA.debugLineNum = 109;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 110;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 111;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 112;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 114;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMLabel\", \".";
_abmshared._buildnavigationbar(_page,"ABMLabel","../images/logo.png","","Controls","ABMLabel");
 //BA.debugLineNum = 117;BA.debugLine="page.AddRows(12,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (12),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 118;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 123;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 93;BA.debugLine="theme.AddContainerTheme(\"white\")";
_theme.AddContainerTheme("white");
 //BA.debugLineNum = 94;BA.debugLine="theme.Container(\"White\").BackColor = ABM.COLOR_WH";
_theme.Container("White").BackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 95;BA.debugLine="theme.Container(\"White\").ZDepth = ABM.ZDEPTH_1";
_theme.Container("White").ZDepth = _abm.ZDEPTH_1;
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompLabelPage\"";
_name = "CompLabelPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMLabel _lblh1 = null;
com.ab.abmaterial.ABMLabel _lblh2 = null;
com.ab.abmaterial.ABMLabel _lblh3 = null;
com.ab.abmaterial.ABMLabel _lblh4 = null;
com.ab.abmaterial.ABMLabel _lblh5 = null;
com.ab.abmaterial.ABMLabel _lblh6 = null;
com.ab.abmaterial.ABMLabel _lblpar = null;
com.ab.abmaterial.ABMLabel _lblspan = null;
com.ab.abmaterial.ABMLabel _lblblockquote = null;
com.ab.abmaterial.ABMContainer _cont1 = null;
com.ab.abmaterial.ABMLabel _lbltextflowno = null;
com.ab.abmaterial.ABMContainer _cont2 = null;
com.ab.abmaterial.ABMLabel _lbltextflow = null;
anywheresoftware.b4a.objects.collections.List _headers = null;
anywheresoftware.b4a.objects.collections.List _codes = null;
anywheresoftware.b4a.objects.collections.List _descriptions = null;
com.ab.abmaterial.ABMLabel _lbltruncate = null;
 //BA.debugLineNum = 126;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 128;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 131;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Roboto 2.0")));
 //BA.debugLineNum = 133;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Labels are the main 'text' objects you can use within ABMaterial. The standard font Material Design uses is Roboto. The font files are included in the framework.")));
 //BA.debugLineNum = 135;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","ABMaterial has 6 heading sizes and 2 special ones: PARAGRAPH and SPAN.  They are the same as in HTML using <h1>, <h2>, <h3>, <h4>, <h5>, <h6>, <p> and <span>.  The size and weight of PARAGRAPH and SPAN is the same as H6, but behave like <p> and <span> tags.  You can find them as constants in ABMMaterial starting with 'SIZE_'.")));
 //BA.debugLineNum = 137;BA.debugLine="Dim lblH1 As ABMLabel";
_lblh1 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 138;BA.debugLine="lblH1.Initialize(page, \"lblH1\", \"SIZE_H1\", ABM.SI";
_lblh1.Initialize(_page,"lblH1","SIZE_H1",_abm.SIZE_H1,__c.False,"");
 //BA.debugLineNum = 139;BA.debugLine="page.Cell(2,1).AddComponent(lblH1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblh1));
 //BA.debugLineNum = 141;BA.debugLine="Dim lblH2 As ABMLabel";
_lblh2 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 142;BA.debugLine="lblH2.Initialize(page, \"lblH2\", \"SIZE_H2\", ABM.SI";
_lblh2.Initialize(_page,"lblH2","SIZE_H2",_abm.SIZE_H2,__c.False,"");
 //BA.debugLineNum = 143;BA.debugLine="page.Cell(2,1).AddComponent(lblH2)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblh2));
 //BA.debugLineNum = 145;BA.debugLine="Dim lblH3 As ABMLabel";
_lblh3 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 146;BA.debugLine="lblH3.Initialize(page, \"lblH3\", \"SIZE_H3\", ABM.SI";
_lblh3.Initialize(_page,"lblH3","SIZE_H3",_abm.SIZE_H3,__c.False,"");
 //BA.debugLineNum = 147;BA.debugLine="page.Cell(2,1).AddComponent(lblH3)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblh3));
 //BA.debugLineNum = 149;BA.debugLine="Dim lblH4 As ABMLabel";
_lblh4 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 150;BA.debugLine="lblH4.Initialize(page, \"lblH4\", \"SIZE_H4\", ABM.SI";
_lblh4.Initialize(_page,"lblH4","SIZE_H4",_abm.SIZE_H4,__c.False,"");
 //BA.debugLineNum = 151;BA.debugLine="page.Cell(2,1).AddComponent(lblH4)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblh4));
 //BA.debugLineNum = 153;BA.debugLine="Dim lblH5 As ABMLabel";
_lblh5 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 154;BA.debugLine="lblH5.Initialize(page, \"lblH5\", \"SIZE_H5\", ABM.SI";
_lblh5.Initialize(_page,"lblH5","SIZE_H5",_abm.SIZE_H5,__c.False,"");
 //BA.debugLineNum = 155;BA.debugLine="page.Cell(2,1).AddComponent(lblH5)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblh5));
 //BA.debugLineNum = 157;BA.debugLine="Dim lblH6 As ABMLabel";
_lblh6 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 158;BA.debugLine="lblH6.Initialize(page, \"lblH6\", \"SIZE_H6\", ABM.SI";
_lblh6.Initialize(_page,"lblH6","SIZE_H6",_abm.SIZE_H6,__c.False,"");
 //BA.debugLineNum = 159;BA.debugLine="page.Cell(2,1).AddComponent(lblH6)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblh6));
 //BA.debugLineNum = 161;BA.debugLine="Dim lblPar As ABMLabel";
_lblpar = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 162;BA.debugLine="lblPar.Initialize(page, \"lblPar\", \"SIZE_PARAGRAPH";
_lblpar.Initialize(_page,"lblPar","SIZE_PARAGRAPH",_abm.SIZE_PARAGRAPH,__c.False,"");
 //BA.debugLineNum = 163;BA.debugLine="page.Cell(2,1).AddComponent(lblPar)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblpar));
 //BA.debugLineNum = 165;BA.debugLine="Dim lblSpan As ABMLabel";
_lblspan = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 166;BA.debugLine="lblSpan.Initialize(page, \"lblSpan\", \"SIZE_SPAN\",";
_lblspan.Initialize(_page,"lblSpan","SIZE_SPAN",_abm.SIZE_SPAN,__c.False,"");
 //BA.debugLineNum = 167;BA.debugLine="page.Cell(2,1).AddComponent(lblSpan)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblspan));
 //BA.debugLineNum = 170;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Blockquotes")));
 //BA.debugLineNum = 172;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Blockquotes are mainly used to give emphasis to a quote or citation. You can also use these for some extra text hierarchy and emphasis. A little colored block will appear next to the text.")));
 //BA.debugLineNum = 174;BA.debugLine="Dim lblBlockquote As ABMLabel";
_lblblockquote = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 175;BA.debugLine="lblBlockquote.Initialize(page, \"Blockquote\", \"Thi";
_lblblockquote.Initialize(_page,"Blockquote","This is an example quotation that uses the blockquote setting.{BR}Here is another line to make it look bigger.",_abm.SIZE_SPAN,__c.False,"");
 //BA.debugLineNum = 176;BA.debugLine="lblBlockquote.IsBlockQuote = True";
_lblblockquote.IsBlockQuote = __c.True;
 //BA.debugLineNum = 177;BA.debugLine="page.Cell(4,1).AddComponent(lblBlockquote)";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblblockquote));
 //BA.debugLineNum = 180;BA.debugLine="page.Cell(5,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Flow Text")));
 //BA.debugLineNum = 183;BA.debugLine="Dim cont1 As ABMContainer";
_cont1 = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 184;BA.debugLine="cont1.Initialize(page, \"cont1\", \"white\")";
_cont1.Initialize(_page,"cont1","white");
 //BA.debugLineNum = 185;BA.debugLine="cont1.AddRows(1, True, \"\").AddCells12(1, \"\")";
_cont1.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 186;BA.debugLine="cont1.BuildGrid 'IMPORTANT once you loaded the co";
_cont1.BuildGrid();
 //BA.debugLineNum = 188;BA.debugLine="Dim lblTextFlowNo As ABMLabel";
_lbltextflowno = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 189;BA.debugLine="lblTextFlowNo.Initialize(page, \"textflowno\", \"NOT";
_lbltextflowno.Initialize(_page,"textflowno","NOT USING TEXTFLOW{BR}{BR}One common flaw we've seen in many frameworks is a lack of support for truly responsive text. While elements on the page resize fluidly, text still resizes on a fixed basis. To ameliorate this problem, for text heavy pages, we've created a property that fluidly scales text size and line-height to optimize readability for the user. Line length stays between 45-80 characters and line height scales to be larger on smaller screens.{BR}{BR}To see Flow Text in action, slowly resize your browser And watch the size of this text body change! Watch the differrence with the text below to see the difference!",_abm.SIZE_SPAN,__c.True,"");
 //BA.debugLineNum = 190;BA.debugLine="cont1.Cell(1,1).AddComponent(lblTextFlowNo)";
_cont1.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbltextflowno));
 //BA.debugLineNum = 191;BA.debugLine="page.Cell(6,1).AddComponent(cont1)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_cont1));
 //BA.debugLineNum = 194;BA.debugLine="Dim cont2 As ABMContainer";
_cont2 = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 195;BA.debugLine="cont2.Initialize(page, \"cont2\", \"white\")";
_cont2.Initialize(_page,"cont2","white");
 //BA.debugLineNum = 196;BA.debugLine="cont2.AddRows(1, True, \"\").AddCells12(1, \"\")";
_cont2.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 197;BA.debugLine="cont2.BuildGrid 'IMPORTANT once you loaded the co";
_cont2.BuildGrid();
 //BA.debugLineNum = 199;BA.debugLine="Dim lblTextFlow As ABMLabel";
_lbltextflow = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 200;BA.debugLine="lblTextFlow.Initialize(page, \"textflow\", \"USING T";
_lbltextflow.Initialize(_page,"textflow","USING TEXTFLOW{BR}{BR}One common flaw we've seen in many frameworks is a lack of support for truly responsive text. While elements on the page resize fluidly, text still resizes on a fixed basis. To ameliorate this problem, for text heavy pages, we've created a property that fluidly scales text size and line-height to optimize readability for the user. Line length stays between 45-80 characters and line height scales to be larger on smaller screens.{BR}{BR}To see Flow Text in action, slowly resize your browser And watch the size of this text body change! Watch the differrence with the text below to see the difference!",_abm.SIZE_SPAN,__c.True,"");
 //BA.debugLineNum = 201;BA.debugLine="lblTextFlow.IsFlowText = True";
_lbltextflow.IsFlowText = __c.True;
 //BA.debugLineNum = 202;BA.debugLine="cont2.Cell(1,1).AddComponent(lblTextFlow)";
_cont2.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbltextflow));
 //BA.debugLineNum = 203;BA.debugLine="page.Cell(7,1).AddComponent(cont2)";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_cont2));
 //BA.debugLineNum = 206;BA.debugLine="page.Cell(8,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Inline Formatting")));
 //BA.debugLineNum = 208;BA.debugLine="page.Cell(8,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Labels can have some basic inline formatting using some 'RichtString' codes {B}(Case sensitive!){/B}. Note: They can have to be paired (except the AT, BR and NBSP tags)!")));
 //BA.debugLineNum = 211;BA.debugLine="Dim Headers, codes, Descriptions As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
_codes = new anywheresoftware.b4a.objects.collections.List();
_descriptions = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 212;BA.debugLine="Headers.Initialize2(Array As String(\"Code\", \"Desc";
_headers.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Code","Description"}));
 //BA.debugLineNum = 213;BA.debugLine="codes.Initialize2(Array As String(\"{B} and {/B}\",";
_codes.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"{B} and {/B}","{I} and {/I}","{U} and {/U}","{SUB} and {/SUB}","{SUP} and {/SUP}","{BR}","{NBSP}","{AL}{AT}{/AL}"}));
 //BA.debugLineNum = 214;BA.debugLine="Descriptions.Initialize2(Array As String(\"Bold\",\"";
_descriptions.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Bold","Italic","Underlined","Subscript","Superscript","Line Break","Non breakable space","Hyperlink e.g. {AL}http://alwaysbusyscorner.com{AT}Alwaysbusy's Corner{/AL}"}));
 //BA.debugLineNum = 215;BA.debugLine="page.Cell(9,1).AddComponent(ABMShared.BuildParamT";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparamtable(_page,"param1",_headers,_codes,_descriptions)));
 //BA.debugLineNum = 218;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildHeade";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Truncate")));
 //BA.debugLineNum = 220;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Labels can be truncated if they do not fit.  Three dot (...) are added to show there is more.")));
 //BA.debugLineNum = 222;BA.debugLine="Dim lblTruncate As ABMLabel";
_lbltruncate = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 223;BA.debugLine="lblTruncate.Initialize(page, \"truncate\", \"This te";
_lbltruncate.Initialize(_page,"truncate","This text will be truncated if it does not fit on one line anymore instead of wrapping. Resize the browser window to see this effect.",_abm.SIZE_SPAN,__c.False,"");
 //BA.debugLineNum = 224;BA.debugLine="lblTruncate.Truncate = True";
_lbltruncate.Truncate = __c.True;
 //BA.debugLineNum = 225;BA.debugLine="page.Cell(11,1).AddComponent(lblTruncate)";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbltruncate));
 //BA.debugLineNum = 228;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 230;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 233;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 235;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 236;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 239;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 240;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 241;BA.debugLine="If Action = \"ABMLabel\" Then Return";
if ((_action).equals("ABMLabel")) { 
if (true) return "";};
 //BA.debugLineNum = 242;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 243;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 244;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 245;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 247;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 248;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 249;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 251;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 254;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 255;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 256;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 257;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 258;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 259;BA.debugLine="End Sub";
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
