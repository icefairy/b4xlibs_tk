package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class gridspage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.gridspage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.gridspage.class).invoke(this, new Object[] {null});
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
public String _origin = "";
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 108;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 110;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 113;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 114;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 115;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 116;BA.debugLine="page.PageTitle = \"Grids\"";
_page.PageTitle = "Grids";
 //BA.debugLineNum = 117;BA.debugLine="page.PageDescription = \"Grids and layouts in ABMa";
_page.PageDescription = "Grids and layouts in ABMaterial";
 //BA.debugLineNum = 118;BA.debugLine="page.PageHTMLName = \"abmaterial-grid-layout.html\"";
_page.PageHTMLName = "abmaterial-grid-layout.html";
 //BA.debugLineNum = 119;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 120;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 121;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 122;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 124;BA.debugLine="ABMShared.BuildNavigationBar(page, \"Grids\", \"../i";
_abmshared._buildnavigationbar(_page,"Grids","../images/logo.png","","Layouts","");
 //BA.debugLineNum = 127;BA.debugLine="page.AddRows(1, True,\"\").AddCells12(1,\"\")";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 128;BA.debugLine="page.AddRowsM(1, True,0,0,\"\").AddCellsOS(12,0,0,0";
_page.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOS((int) (12),(int) (0),(int) (0),(int) (0),(int) (3),(int) (2),(int) (1),"");
 //BA.debugLineNum = 129;BA.debugLine="page.AddRows(3, True,\"\").AddCells12(1,\"\")";
_page.AddRows((int) (3),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 130;BA.debugLine="page.AddRowsM(1, True,0,0,\"\").AddCellsOS(2,0,0,0,";
_page.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOS((int) (2),(int) (0),(int) (0),(int) (0),(int) (6),(int) (6),(int) (6),"");
 //BA.debugLineNum = 131;BA.debugLine="page.AddRows(2, True,\"\").AddCells12(1,\"\")";
_page.AddRows((int) (2),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 132;BA.debugLine="page.AddRowsM(1, True,0,0,\"\").AddCellsOS(1,6,6,6,";
_page.AddRowsM((int) (1),__c.True,(int) (0),(int) (0),"").AddCellsOS((int) (1),(int) (6),(int) (6),(int) (6),(int) (6),(int) (6),(int) (6),"");
 //BA.debugLineNum = 133;BA.debugLine="page.AddRows(11, True,\"\").AddCells12(1,\"\")";
_page.AddRows((int) (11),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 134;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 136;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 137;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 91;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 92;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 97;BA.debugLine="theme.AddCellTheme(\"cellLB\")";
_theme.AddCellTheme("cellLB");
 //BA.debugLineNum = 98;BA.debugLine="theme.Cell(\"cellLB\").BackColor = ABM.COLOR_LIGHTB";
_theme.Cell("cellLB").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 99;BA.debugLine="theme.Cell(\"cellLB\").BorderColor = ABM.COLOR_WHIT";
_theme.Cell("cellLB").BorderColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 100;BA.debugLine="theme.Cell(\"cellLB\").BorderWidth = 1";
_theme.Cell("cellLB").BorderWidth = (int) (1);
 //BA.debugLineNum = 103;BA.debugLine="theme.AddLabelTheme(\"lblGrid\")";
_theme.AddLabelTheme("lblGrid");
 //BA.debugLineNum = 104;BA.debugLine="theme.Label(\"lblGrid\").ForeColor = ABM.COLOR_WHIT";
_theme.Label("lblGrid").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 105;BA.debugLine="theme.Label(\"lblGrid\").Align = ABM.TEXTALIGN_CENT";
_theme.Label("lblGrid").Align = _abm.TEXTALIGN_CENTER;
 //BA.debugLineNum = 106;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"GridsPage\"";
_name = "GridsPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 18;BA.debugLine="Dim Origin As String = \"http://prd.one-two.com:51";
_origin = "http://prd.one-two.com:51042";
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMImage _img2 = null;
int _i = 0;
com.ab.abmaterial.ABMLabel _lblgrid = null;
String _code = "";
anywheresoftware.b4a.objects.collections.List _headers = null;
anywheresoftware.b4a.objects.collections.List _codes = null;
anywheresoftware.b4a.objects.collections.List _descriptions = null;
com.ab.abmaterial.ABMImage _img = null;
com.ab.abmaterial.ABMVideo _video1b = null;
com.ab.abmaterial.ABMImage _img2a = null;
 //BA.debugLineNum = 139;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 141;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 144;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Introduction")));
 //BA.debugLineNum = 146;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Take a look at this section to quickly understand how grids work! Make sure you have read theThemes topic first. We use themes when we design a grid.")));
 //BA.debugLineNum = 148;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1b","{B}In ABMaterial 2.20+, we have a GRID BUILDER to make it easy to build Grids.  You can find this chapter at the end of this topic, but it is very important you grab the concept of the Grid and Cells before proceeding!{/B}")));
 //BA.debugLineNum = 149;BA.debugLine="Dim img2 As ABMImage";
_img2 = new com.ab.abmaterial.ABMImage();
 //BA.debugLineNum = 150;BA.debugLine="img2.Initialize(page, \"img2\", \"../images/gridbuil";
_img2.Initialize(_page,"img2","../images/gridbuilder1.png",1);
 //BA.debugLineNum = 151;BA.debugLine="img2.IsResponsive = True";
_img2.IsResponsive = __c.True;
 //BA.debugLineNum = 152;BA.debugLine="page.Cell(1,1).AddComponent(img2)";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_img2));
 //BA.debugLineNum = 155;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildSubHea";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader(_page,"shdr1","12 Cells")));
 //BA.debugLineNum = 157;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","Our standard grid has 12 cells. No matter the size of the browser, each of these cells will always have an equal width.")));
 //BA.debugLineNum = 159;BA.debugLine="For i=1 To 12";
{
final int step11 = 1;
final int limit11 = (int) (12);
for (_i = (int) (1) ; (step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11); _i = ((int)(0 + _i + step11)) ) {
 //BA.debugLineNum = 160;BA.debugLine="page.Cell(2,i).UseTheme(\"cellLB\")";
_page.Cell((int) (2),_i).UseTheme("cellLB");
 //BA.debugLineNum = 161;BA.debugLine="Dim lblGrid As ABMLabel";
_lblgrid = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 162;BA.debugLine="lblGrid.Initialize(page, \"Rgrid2C\" & i & \"Label\"";
_lblgrid.Initialize(_page,"Rgrid2C"+BA.NumberToString(_i)+"Label",""+BA.NumberToString(_i),_abm.SIZE_H6,__c.True,"lblGrid");
 //BA.debugLineNum = 163;BA.debugLine="page.Cell(2,i).AddComponent(lblGrid)";
_page.Cell((int) (2),_i).AddComponent((com.ab.abmaterial.ABMComponent)(_lblgrid));
 }
};
 //BA.debugLineNum = 166;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","To get a feel of how the grid is used in B4J, take a look at the code below which will produce a grid definition used in this page.")));
 //BA.debugLineNum = 169;BA.debugLine="Dim code As String";
_code = "";
 //BA.debugLineNum = 170;BA.debugLine="code = $\"// create the page grid page.AddRows(1,T";
_code = ("// create the page grid\n"+"page.AddRows(1,True, \"\").AddCells12(1,\"\")	\n"+"page.AddRowsM(1,True,0,0, \"\").AddCellsOS(12,0,0,0,1,1,1,\"\")\n"+"page.AddRows(3,True, \"\").AddCells12(1,\"\")\n"+"page.AddRowsM(1,True,0,0, \"\").AddCellsOS(2,0,0,0,6,6,6,\"\")\n"+"page.AddRows(2,True, \"\").AddCells12(1,\"\")\n"+"page.AddRowsM(1,True,0,0, \"\").AddCellsOS(1,6,6,6,6,6,6,\"\")\n"+"page.AddRows(6,True, \"\").AddCells12(1,\"\")\n"+"page.BuildGrid //IMPORTANT once you loaded the complete grid AND before you start adding components");
 //BA.debugLineNum = 180;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code)));
 //BA.debugLineNum = 183;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildSubHea";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader(_page,"shdr2","Cells live inside rows")));
 //BA.debugLineNum = 185;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","You can create columns in a row by dividing the 12 cells into parts. For example here we use the 12 cells to create 2 columns, each 6 cells wide.")));
 //BA.debugLineNum = 187;BA.debugLine="page.Cell(5,1).UseTheme(\"cellLB\")";
_page.Cell((int) (5),(int) (1)).UseTheme("cellLB");
 //BA.debugLineNum = 188;BA.debugLine="Dim lblGrid As ABMLabel";
_lblgrid = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 189;BA.debugLine="lblGrid.Initialize(page, \"Rgrid5C1Label\", \"This r";
_lblgrid.Initialize(_page,"Rgrid5C1Label","This row is 12-cells wide on all screen sizes",_abm.SIZE_H6,__c.True,"lblGrid");
 //BA.debugLineNum = 190;BA.debugLine="page.Cell(5,1).AddComponent(lblGrid)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblgrid));
 //BA.debugLineNum = 192;BA.debugLine="page.Cell(6,1).UseTheme(\"cellLB\")";
_page.Cell((int) (6),(int) (1)).UseTheme("cellLB");
 //BA.debugLineNum = 193;BA.debugLine="Dim lblGrid As ABMLabel";
_lblgrid = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 194;BA.debugLine="lblGrid.Initialize(page, \"Rgrid6C1Label\", \"6-cell";
_lblgrid.Initialize(_page,"Rgrid6C1Label","6-cells (one-half)",_abm.SIZE_H6,__c.True,"lblGrid");
 //BA.debugLineNum = 195;BA.debugLine="page.Cell(6,1).AddComponent(lblGrid)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblgrid));
 //BA.debugLineNum = 197;BA.debugLine="page.Cell(6,2).UseTheme(\"cellLB\")";
_page.Cell((int) (6),(int) (2)).UseTheme("cellLB");
 //BA.debugLineNum = 198;BA.debugLine="Dim lblGrid As ABMLabel";
_lblgrid = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 199;BA.debugLine="lblGrid.Initialize(page, \"Rgrid6C2Label\", \"6-cell";
_lblgrid.Initialize(_page,"Rgrid6C2Label","6-cells (one-half)",_abm.SIZE_H6,__c.True,"lblGrid");
 //BA.debugLineNum = 200;BA.debugLine="page.Cell(6,2).AddComponent(lblGrid)";
_page.Cell((int) (6),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblgrid));
 //BA.debugLineNum = 203;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildSubHea";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader(_page,"shdr3","Offsets")));
 //BA.debugLineNum = 205;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par5","To offset use the offset parameters.  Offsets are {B}relative{/B} to the previous cell in the row (or 0 for the first one). This way you can create 'gabs' between cells. In the next example we create a 6-cell column with an offset by 6.")));
 //BA.debugLineNum = 207;BA.debugLine="page.Cell(8,1).UseTheme(\"cellLB\")";
_page.Cell((int) (8),(int) (1)).UseTheme("cellLB");
 //BA.debugLineNum = 208;BA.debugLine="Dim lblGrid As ABMLabel";
_lblgrid = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 209;BA.debugLine="lblGrid.Initialize(page, \"Rgrid8C1Label\", \"This r";
_lblgrid.Initialize(_page,"Rgrid8C1Label","This row is 12-cells wide on all screen sizes",_abm.SIZE_H6,__c.True,"lblGrid");
 //BA.debugLineNum = 210;BA.debugLine="page.Cell(8,1).AddComponent(lblGrid)";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblgrid));
 //BA.debugLineNum = 212;BA.debugLine="page.Cell(9,1).UseTheme(\"cellLB\")";
_page.Cell((int) (9),(int) (1)).UseTheme("cellLB");
 //BA.debugLineNum = 213;BA.debugLine="Dim lblGrid As ABMLabel";
_lblgrid = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 214;BA.debugLine="lblGrid.Initialize(page, \"Rgrid9C1Label\", \"6-cell";
_lblgrid.Initialize(_page,"Rgrid9C1Label","6-cells (offset-by-6)",_abm.SIZE_H6,__c.True,"lblGrid");
 //BA.debugLineNum = 215;BA.debugLine="page.Cell(9,1).AddComponent(lblGrid)";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lblgrid));
 //BA.debugLineNum = 218;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildSubHe";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader(_page,"shdr4","Screen sizes and cell offsets/sizes")));
 //BA.debugLineNum = 220;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par6","Some AddCellxxx() methods accept 6 extra parameters to set the offsets and sizes for small, medium and large screens so you can make your app adept to different device sizes (phone, tablet, desktop).")));
 //BA.debugLineNum = 222;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par7","An overview of the different AddRowxx() methods")));
 //BA.debugLineNum = 225;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par8","{B}AddRows(numberOfRows, centerInRow, themeName){/B}")));
 //BA.debugLineNum = 227;BA.debugLine="Dim Headers, codes, Descriptions As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
_codes = new anywheresoftware.b4a.objects.collections.List();
_descriptions = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 228;BA.debugLine="Headers.Initialize2(Array As String(\"Param\", \"Des";
_headers.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Param","Description"}));
 //BA.debugLineNum = 229;BA.debugLine="codes.Initialize2(Array As String(\"numberOfRows\",";
_codes.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"numberOfRows","centerInRow","themeName"}));
 //BA.debugLineNum = 230;BA.debugLine="Descriptions.Initialize2(Array As String(\"You can";
_descriptions.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"You can use this schortcut to add the same row multiple times. Instead of writing 3 times 'page.AddRows(1,True, \"\").AddCells12(1,\"\")', you can write 'page.AddRows(3,True, \"\").AddCells12(1,\"\")'. Uses a default marginTopPx and marginBottomPx of 20 pixels.","If true, the row will use approx between 75% and 85% of the available screen width, creating some sort of border. (% depends on screen size)","Optional name of the theme you have created.  Can be \"\"."}));
 //BA.debugLineNum = 231;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParam";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparamtable(_page,"param1",_headers,_codes,_descriptions)));
 //BA.debugLineNum = 234;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par9","{B}AddRowsM(numberOfRows, centerInRow, marginTopPx, marginBottomPx, themeName){/B}")));
 //BA.debugLineNum = 236;BA.debugLine="Dim Headers, codes, Descriptions As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
_codes = new anywheresoftware.b4a.objects.collections.List();
_descriptions = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 237;BA.debugLine="Headers.Initialize2(Array As String(\"Param\", \"Des";
_headers.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Param","Description"}));
 //BA.debugLineNum = 238;BA.debugLine="codes.Initialize2(Array As String(\"numberOfRows\",";
_codes.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"numberOfRows","centerInRow","marginTopPx","marginBottomPx","themeName"}));
 //BA.debugLineNum = 239;BA.debugLine="Descriptions.Initialize2(Array As String(\"You can";
_descriptions.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"You can use this schortcut to add the same row multiple times. Instead of writing 3 times 'page.AddRows(1,True, \"\").AddCells12(1,\"\")', you can write 'page.AddRows(3,True, \"\").AddCells12(1,\"\")' ","Tune the top margin of the row in pixels, can be negative.","Tune the bottom margin of the row in pixels, can be negative.","If true, the row will use approx 75% and 85% of the available screen width, creating some sort of border. (% depends on screen size)","Optional name of the theme you have created.  Can be \"\"."}));
 //BA.debugLineNum = 240;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParam";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparamtable(_page,"param2",_headers,_codes,_descriptions)));
 //BA.debugLineNum = 243;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par10","An overview of the different AddCellxx() methods")));
 //BA.debugLineNum = 246;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par11","{B}AddCells12(numberOfRows, themeName){/B}")));
 //BA.debugLineNum = 248;BA.debugLine="Dim Headers, codes, Descriptions As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
_codes = new anywheresoftware.b4a.objects.collections.List();
_descriptions = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 249;BA.debugLine="Headers.Initialize2(Array As String(\"Param\", \"Des";
_headers.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Param","Description"}));
 //BA.debugLineNum = 250;BA.debugLine="codes.Initialize2(Array As String(\"numberOfRows\",";
_codes.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"numberOfRows","themeName"}));
 //BA.debugLineNum = 251;BA.debugLine="Descriptions.Initialize2(Array As String(\"You can";
_descriptions.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"You can use this schortcut to add the same cell multiple times. Instead of writing 3 times 'page.AddRows(1,True, \"\").AddCells12(1,\"\")', you can write 'page.AddRows(1,True, \"\").AddCells12(3,\"\")'. In this method this has a certain side effect: As described above, one row can only have 12 cells.  So creating 3 x 12 Cells will 'wrap' them to the next line.","Optional name of the theme you have created.  Can be \"\"."}));
 //BA.debugLineNum = 252;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParam";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparamtable(_page,"param3",_headers,_codes,_descriptions)));
 //BA.debugLineNum = 255;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par12","{B}AddCellsOS(numberOfCells, offsetSmall, offsetMedium, offsetLarge, sizeSmall, sizeMedium, sizeLarge, themeName){/B}")));
 //BA.debugLineNum = 257;BA.debugLine="Dim Headers, codes, Descriptions As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
_codes = new anywheresoftware.b4a.objects.collections.List();
_descriptions = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 258;BA.debugLine="Headers.Initialize2(Array As String(\"Param\", \"Des";
_headers.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Param","Description"}));
 //BA.debugLineNum = 259;BA.debugLine="codes.Initialize2(Array As String(\"numberOfRows\",";
_codes.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"numberOfRows","offsetSmall","offsetMedium","offsetLarge","sizeSmall","sizeMedium","sizeLarge","themeName"}));
 //BA.debugLineNum = 260;BA.debugLine="Descriptions.Initialize2(Array As String(\"You can";
_descriptions.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"You can use this schortcut to add the same cell multiple times.","Offset of the cell on small screens.","Offset of the cell on medium screens.","Offset of the cell on large screens.","Size of the cell on small screens.","Size of the cell on medium screens.","Size of the cell on large screens.","Optional name of the theme you have created.  Can be \"\"."}));
 //BA.debugLineNum = 261;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParam";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparamtable(_page,"param4",_headers,_codes,_descriptions)));
 //BA.debugLineNum = 264;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par13","{B}AddCells12MP(numberOfCells, marginTopPx, marginBottomPx, paddingLeftPx, paddingRightPx, themeName){/B}")));
 //BA.debugLineNum = 266;BA.debugLine="Dim Headers, codes, Descriptions As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
_codes = new anywheresoftware.b4a.objects.collections.List();
_descriptions = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 267;BA.debugLine="Headers.Initialize2(Array As String(\"Param\", \"Des";
_headers.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Param","Description"}));
 //BA.debugLineNum = 268;BA.debugLine="codes.Initialize2(Array As String(\"numberOfRows\",";
_codes.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"numberOfRows","marginTopPx","marginBottomPx","paddingLeftPx","paddingRightPx","themeName"}));
 //BA.debugLineNum = 269;BA.debugLine="Descriptions.Initialize2(Array As String(\"You can";
_descriptions.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"You can use this schortcut to add the same cell multiple times.","Tune the top margin of the cell in pixels, can be negative.","Tune the bottom margin of the cell in pixels, can be negative.","Tune the left padding of the cell in pixels.","Tune the right padding of the cell in pixels.","Optional name of the theme you have created.  Can be \"\"."}));
 //BA.debugLineNum = 270;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParam";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparamtable(_page,"param5",_headers,_codes,_descriptions)));
 //BA.debugLineNum = 273;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par14","{B}AddCellsOSMP(numberOfCells, offsetSmall, offsetMedium, offsetLarge, sizeSmall, sizeMedium, sizeLarge, marginTopPx, marginBottomPx, paddingLeftPx, paddingRightPx, themeName){/B}")));
 //BA.debugLineNum = 275;BA.debugLine="Dim Headers, codes, Descriptions As List";
_headers = new anywheresoftware.b4a.objects.collections.List();
_codes = new anywheresoftware.b4a.objects.collections.List();
_descriptions = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 276;BA.debugLine="Headers.Initialize2(Array As String(\"Param\", \"Des";
_headers.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Param","Description"}));
 //BA.debugLineNum = 277;BA.debugLine="codes.Initialize2(Array As String(\"numberOfRows\",";
_codes.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"numberOfRows","offsetSmall","offsetMedium","offsetLarge","sizeSmall","sizeMedium","sizeLarge","marginTopPx","marginBottomPx","paddingLeftPx","paddingRightPx","themeName"}));
 //BA.debugLineNum = 278;BA.debugLine="Descriptions.Initialize2(Array As String(\"You can";
_descriptions.Initialize2(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"You can use this schortcut to add the same cell multiple times.","Offset of the cell on small screens.","Offset of the cell on medium screens.","Offset of the cell on large screens.","Size of the cell on small screens.","Size of the cell on medium screens.","Size of the cell on large screens.","Tune the top margin of the cell in pixels, can be negative.","Tune the bottom margin of the cell in pixels, can be negative.","Tune the left padding of the cell in pixels.","Tune the right padding of the cell in pixels.","Optional name of the theme you have created.  Can be \"\"."}));
 //BA.debugLineNum = 279;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParam";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparamtable(_page,"param6",_headers,_codes,_descriptions)));
 //BA.debugLineNum = 282;BA.debugLine="page.Cell(11,1).AddComponent(ABMShared.BuildSubHe";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader(_page,"shdr5","Some guidelines")));
 //BA.debugLineNum = 284;BA.debugLine="page.Cell(11,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par15","I'm aware this is not an easy part to understand.  Start with simple layouts, and use the more advanced methods once you start understanding what is going on.  In the beginning I found it usefull to draw my Grid on paper to visualize it.  Knowing exactly how your page needs to look is an important part of the design. Further into the tutorial, we're going to meet controls (like ABMContainer) that allows to create grids within grids so again it's {B}VERY IMPORTANT{/B} you grab this concept.  If you have to start adding rows (or even cells) afterwards, you're in for some work going over your code making adjustments!")));
 //BA.debugLineNum = 286;BA.debugLine="page.Cell(11,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par16","This is a representation of the grid of this page on paper. Compare this image with the code block at the beginning of the page.")));
 //BA.debugLineNum = 288;BA.debugLine="Dim img As ABMImage";
_img = new com.ab.abmaterial.ABMImage();
 //BA.debugLineNum = 289;BA.debugLine="img.Initialize(page, \"img\", \"../images/grid.png\",";
_img.Initialize(_page,"img","../images/grid.png",1);
 //BA.debugLineNum = 290;BA.debugLine="img.IsResponsive = True";
_img.IsResponsive = __c.True;
 //BA.debugLineNum = 291;BA.debugLine="page.Cell(12,1).AddComponent(img)";
_page.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_img));
 //BA.debugLineNum = 294;BA.debugLine="page.Cell(13,1).AddComponent(ABMShared.BuildHeade";
_page.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"grhdr1","The ABMGridBuilder")));
 //BA.debugLineNum = 296;BA.debugLine="page.Cell(13,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"grpar1","The ABMGridBuilder is a tool to make grids easy.  It is based on the excellent system introduced by Shoelace.io.  I adapted the system so it is usefull for ABMaterial and added some specific functionalities like adding rows and cells before others.")));
 //BA.debugLineNum = 298;BA.debugLine="page.Cell(13,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"grpar2","With the tool, you can generate the needed AddRow and AddCell B4J methods described before.  Using the Clipboard, you can then paste it at the relevant place in your code.")));
 //BA.debugLineNum = 300;BA.debugLine="page.Cell(13,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"grpar3","{B}But even more!{/B} You can copy your AddRow and AddCell methods to the clipboard, and ABMGridBuilder can parse this code an 'rebuild' the visual representation. Cool, no?")));
 //BA.debugLineNum = 302;BA.debugLine="page.Cell(13,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"grpar4","Have a look at this video which demonstrates the whole story.")));
 //BA.debugLineNum = 305;BA.debugLine="Dim video1b As ABMVideo";
_video1b = new com.ab.abmaterial.ABMVideo();
 //BA.debugLineNum = 306;BA.debugLine="video1b.InitializeYoutube(page, \"video1b\", \"//www";
_video1b.InitializeYouTube(_page,"video1b","//www.youtube.com/embed/rQvbq9BVoTI",_origin,__c.False,__c.False,__c.False,(int) (100));
 //BA.debugLineNum = 307;BA.debugLine="page.Cell(14,1).AddComponent(video1b)";
_page.Cell((int) (14),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_video1b));
 //BA.debugLineNum = 309;BA.debugLine="page.Cell(15,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (15),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"grpar5","Using the function buttons on the cells and the grid you can add/remove/move/resize the rows and cells.")));
 //BA.debugLineNum = 311;BA.debugLine="Dim img2a As ABMImage";
_img2a = new com.ab.abmaterial.ABMImage();
 //BA.debugLineNum = 312;BA.debugLine="img2a.Initialize(page, \"img2a\", \"../images/gridbu";
_img2a.Initialize(_page,"img2a","../images/gridbuilder2.png",1);
 //BA.debugLineNum = 313;BA.debugLine="img2a.IsResponsive = True";
_img2a.IsResponsive = __c.True;
 //BA.debugLineNum = 314;BA.debugLine="page.Cell(15,1).AddComponent(img2a)";
_page.Cell((int) (15),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_img2a));
 //BA.debugLineNum = 316;BA.debugLine="page.Cell(15,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (15),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"grpar6","Using the clipboard, you can paste the generated code into your application.  You can select the AddRows lines in you code and 'rebuild' it to a visual representation of your grid.  This is particulary useful for grids you manually created in ABMaterial version before version 2.20.")));
 //BA.debugLineNum = 318;BA.debugLine="page.Cell(16,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (16),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"grpar7","This is just a quick introduction, so make sure you also check the B4J forum for some more tutorials and tips & tricks on the ABMGridBuilder.")));
 //BA.debugLineNum = 321;BA.debugLine="page.Cell(17,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (17),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par17","Next chapter to read should be the ABMPage object in the Helpers menu.")));
 //BA.debugLineNum = 324;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 326;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 329;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 331;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 332;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 22;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 24;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 336;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 337;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 338;BA.debugLine="If Action = \"Grids\" Then Return";
if ((_action).equals("Grids")) { 
if (true) return "";};
 //BA.debugLineNum = 339;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 340;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 341;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 342;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 344;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 345;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 346;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 348;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 349;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 59;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 60;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 61;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 62;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 63;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 64;BA.debugLine="ws.session.SetAttribute(\"ABMNewSession\", True)";
_ws.getSession().SetAttribute("ABMNewSession",(Object)(__c.True));
 //BA.debugLineNum = 65;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 67;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 68;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 69;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 70;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 72;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 74;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 76;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 77;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 78;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 80;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 84;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 351;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 352;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 353;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 354;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 355;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 356;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 27;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 28;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 29;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 30;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 31;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 33;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 34;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 35;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 36;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 40;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 41;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 43;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 45;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 48;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 50;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 52;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 53;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 55;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 56;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
