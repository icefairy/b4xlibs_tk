package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class helpercontainerpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.helpercontainerpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.helpercontainerpage.class).invoke(this, new Object[] {null});
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
public String  _btn1_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMButton _btn1 = null;
com.ab.abmaterial.ABMContainer _cont2 = null;
 //BA.debugLineNum = 464;BA.debugLine="Sub btn1_Clicked(Target As String)";
 //BA.debugLineNum = 465;BA.debugLine="Dim btn1 As ABMButton = page.Component(\"btn1\")";
_btn1 = (com.ab.abmaterial.ABMButton)(_page.Component("btn1"));
 //BA.debugLineNum = 466;BA.debugLine="Dim cont2 As ABMContainer = page.Component(\"cont2";
_cont2 = (com.ab.abmaterial.ABMContainer)(_page.Component("cont2"));
 //BA.debugLineNum = 468;BA.debugLine="Select Case btn1.Tag";
switch (BA.switchObjectToInt(_btn1.Tag,(Object)("animin"),(Object)("animout"))) {
case 0: {
 //BA.debugLineNum = 470;BA.debugLine="cont2.RunAnimation(\"animin\")";
_cont2.RunAnimation("animin");
 break; }
case 1: {
 //BA.debugLineNum = 472;BA.debugLine="cont2.RunAnimation(\"animout\")";
_cont2.RunAnimation("animout");
 break; }
}
;
 //BA.debugLineNum = 474;BA.debugLine="End Sub";
return "";
}
public String  _btn2_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMButton _btn2 = null;
com.ab.abmaterial.ABMContainer _cont3 = null;
 //BA.debugLineNum = 495;BA.debugLine="Sub btn2_Clicked(Target As String)";
 //BA.debugLineNum = 496;BA.debugLine="Dim btn2 As ABMButton = page.Component(\"btn2\")";
_btn2 = (com.ab.abmaterial.ABMButton)(_page.Component("btn2"));
 //BA.debugLineNum = 497;BA.debugLine="Dim cont3 As ABMContainer = page.Component(\"cont3";
_cont3 = (com.ab.abmaterial.ABMContainer)(_page.Component("cont3"));
 //BA.debugLineNum = 499;BA.debugLine="Select Case btn2.Tag";
switch (BA.switchObjectToInt(_btn2.Tag,(Object)("unblur"),(Object)("blur"))) {
case 0: {
 //BA.debugLineNum = 501;BA.debugLine="cont3.RunAnimation(\"unblur\")";
_cont3.RunAnimation("unblur");
 break; }
case 1: {
 //BA.debugLineNum = 503;BA.debugLine="cont3.RunAnimation(\"blur\")";
_cont3.RunAnimation("blur");
 break; }
}
;
 //BA.debugLineNum = 505;BA.debugLine="End Sub";
return "";
}
public String  _btn3_clicked(String _target) throws Exception{
 //BA.debugLineNum = 507;BA.debugLine="Sub btn3_Clicked(Target As String)";
 //BA.debugLineNum = 511;BA.debugLine="End Sub";
return "";
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 113;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 115;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 118;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 119;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 120;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 121;BA.debugLine="page.PageTitle = \"ABMContainer\"";
_page.PageTitle = "ABMContainer";
 //BA.debugLineNum = 122;BA.debugLine="page.PageDescription = \"The container helper\"";
_page.PageDescription = "The container helper";
 //BA.debugLineNum = 123;BA.debugLine="page.PageHTMLName = \"abmaterial-container.html\"";
_page.PageHTMLName = "abmaterial-container.html";
 //BA.debugLineNum = 124;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 125;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 126;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 127;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 131;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMContainer\"";
_abmshared._buildnavigationbar(_page,"ABMContainer","../images/logo.png","","Helpers","ABMContainer");
 //BA.debugLineNum = 134;BA.debugLine="page.AddRows(1,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 135;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,12,8,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (8),(int) (6),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (4),(int) (6),"");
 //BA.debugLineNum = 136;BA.debugLine="page.AddRows(16,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (16),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 137;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 143;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 94;BA.debugLine="theme.AddCellTheme(\"cellLB\")";
_theme.AddCellTheme("cellLB");
 //BA.debugLineNum = 95;BA.debugLine="theme.Cell(\"cellLB\").BackColor = ABM.COLOR_LIGHTB";
_theme.Cell("cellLB").BackColor = _abm.COLOR_LIGHTBLUE;
 //BA.debugLineNum = 96;BA.debugLine="theme.Cell(\"cellLB\").BorderColor = ABM.COLOR_WHIT";
_theme.Cell("cellLB").BorderColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 97;BA.debugLine="theme.Cell(\"cellLB\").BorderWidth = 1";
_theme.Cell("cellLB").BorderWidth = (int) (1);
 //BA.debugLineNum = 100;BA.debugLine="theme.AddLabelTheme(\"lblGrid\")";
_theme.AddLabelTheme("lblGrid");
 //BA.debugLineNum = 101;BA.debugLine="theme.Label(\"lblGrid\").ForeColor = ABM.COLOR_WHIT";
_theme.Label("lblGrid").ForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 102;BA.debugLine="theme.Label(\"lblGrid\").Align = ABM.TEXTALIGN_CENT";
_theme.Label("lblGrid").Align = _abm.TEXTALIGN_CENTER;
 //BA.debugLineNum = 105;BA.debugLine="theme.AddButtonTheme(\"bluegrey\")";
_theme.AddButtonTheme("bluegrey");
 //BA.debugLineNum = 106;BA.debugLine="theme.Button(\"bluegrey\").BackColor = ABM.COLOR_BL";
_theme.Button("bluegrey").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 107;BA.debugLine="theme.Button(\"bluegrey\").BackColorIntensity = ABM";
_theme.Button("bluegrey").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 109;BA.debugLine="theme.AddCardTheme(\"whitetitle\")";
_theme.AddCardTheme("whitetitle");
 //BA.debugLineNum = 110;BA.debugLine="theme.Card(\"whitetitle\").TitleForeColor = ABM.COL";
_theme.Card("whitetitle").TitleForeColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 111;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"HelperContainerPage\"";
_name = "HelperContainerPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMContainer _cont1 = null;
int _i = 0;
com.ab.abmaterial.ABMLabel _lblgrid = null;
String _code = "";
com.ab.abmaterial.ABMButton _btn1 = null;
com.ab.abmaterial.ABMAnimation _myanim1 = null;
com.ab.abmaterial.ABMAnimation _myanim2 = null;
com.ab.abmaterial.ABMAnimation _myanim3 = null;
com.ab.abmaterial.ABMContainer _cont2 = null;
com.ab.abmaterial.ABMCard _tmpcard = null;
com.ab.abmaterial.ABMButton _btn2 = null;
com.ab.abmaterial.ABMAnimation _myanim4 = null;
com.ab.abmaterial.ABMAnimation _myanim5 = null;
com.ab.abmaterial.ABMAnimation _myanim6 = null;
com.ab.abmaterial.ABMContainer _cont3 = null;
String _codeblock = "";
String _codeblock2 = "";
String _codeblock3 = "";
 //BA.debugLineNum = 146;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 148;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 151;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","The best way to look at a ABMContainer component is like it is a mini ABMPage helper.  It has less options but the flow is almost the same.  You can add Rows, Cells and other components.")));
 //BA.debugLineNum = 153;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","ABMContainers are mosly used to further drill down a cell defined in the page.  With an ABMContainer control, you get again a grid of 12 cells so you can do exactly as it was a page.")));
 //BA.debugLineNum = 155;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","Lets show an example.  We have a page with a row split into two columns of each 6 cells.  In the left cell we've added a container with the grid example from the ABMPage chapter.")));
 //BA.debugLineNum = 158;BA.debugLine="Dim cont1 As ABMContainer";
_cont1 = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 159;BA.debugLine="cont1.Initialize(page, \"cont1\", \"\")";
_cont1.Initialize(_page,"cont1","");
 //BA.debugLineNum = 204;BA.debugLine="cont1.AddRows(1, True,\"\").AddCells12(1,\"\")";
_cont1.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 205;BA.debugLine="cont1.AddRows(1, True,\"\").AddCellsOS(12,0,0,0,4,3";
_cont1.AddRows((int) (1),__c.True,"").AddCellsOS((int) (12),(int) (0),(int) (0),(int) (0),(int) (4),(int) (3),(int) (1),"");
 //BA.debugLineNum = 206;BA.debugLine="cont1.AddRows(2, True,\"\").AddCells12(1,\"\")";
_cont1.AddRows((int) (2),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 207;BA.debugLine="cont1.BuildGrid ' IMPORTANT!";
_cont1.BuildGrid();
 //BA.debugLineNum = 210;BA.debugLine="cont1.Cell(1,1).AddComponent(ABMShared.BuildSubHe";
_cont1.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader(_page,"shdr1","12 Cells")));
 //BA.debugLineNum = 213;BA.debugLine="cont1.Cell(1,1).AddComponent(ABMShared.BuildParag";
_cont1.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","Our standard grid has 12 cells. No matter the size of the browser, each of these cells will always have an equal width.")));
 //BA.debugLineNum = 215;BA.debugLine="For i=1 To 12";
{
final int step13 = 1;
final int limit13 = (int) (12);
_i = (int) (1) ;
for (;(step13 > 0 && _i <= limit13) || (step13 < 0 && _i >= limit13) ;_i = ((int)(0 + _i + step13))  ) {
 //BA.debugLineNum = 216;BA.debugLine="cont1.Cell(2,i).UseTheme(\"cellLB\")";
_cont1.Cell((int) (2),_i).UseTheme("cellLB");
 //BA.debugLineNum = 217;BA.debugLine="Dim lblGrid As ABMLabel";
_lblgrid = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 218;BA.debugLine="lblGrid.Initialize(page, \"Rgrid2C\" & i & \"Label\"";
_lblgrid.Initialize(_page,"Rgrid2C"+BA.NumberToString(_i)+"Label",""+BA.NumberToString(_i),_abm.SIZE_H6,__c.True,"lblGrid");
 //BA.debugLineNum = 219;BA.debugLine="cont1.Cell(2,i).AddComponent(lblGrid)";
_cont1.Cell((int) (2),_i).AddComponent((com.ab.abmaterial.ABMComponent)(_lblgrid));
 }
};
 //BA.debugLineNum = 223;BA.debugLine="cont1.Cell(3,1).AddComponent(ABMShared.BuildParag";
_cont1.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","To get a feel of how the grid is used ...")));
 //BA.debugLineNum = 225;BA.debugLine="page.Cell(2,1).AddComponent(cont1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_cont1));
 //BA.debugLineNum = 227;BA.debugLine="Dim code As String = $\"// create the container Di";
_code = ("// create the container\n"+"Dim cont1 As ABMContainer\n"+"cont1.Initialize(page, \"cont1\", \"\")\n"+"cont1.AddRows(1,True, \"\").AddCells12(1,\"\")	\n"+"cont1.AddRowsM(1,True,0,0, \"\").AddCellsOS(12,0,0,0,1,1,1,\"\")\n"+"cont1.AddRows(1,True, \"\").AddCells12(1,\"\")	\n"+"cont1.BuildGrid // IMPORTANT\n"+"	\n"+"// add sub header\n"+"cont1.Cell(1,1).AddComponent(ABMShared.BuildSubHeader(page, \"shdr1\", \"12 Cells\"))\n"+"// add paragraph\n"+"cont1.Cell(1,1).AddComponent(ABMShared.BuildParagraph(page, \"par2\",\"Our standard grid has 12 cells. No matter the size of the browser, each of these cells will always have an equal width.\"))\n"+"// add 12 cells\n"+"For i=1 To 12\n"+"	cont1.Cell(2,i).UseTheme(\"cellLB\")\n"+"	Dim lblGrid As ABMLabel\n"+"	lblGrid.Initialize(page, \"Rgrid2C\" & i & \"Label\", \"\" & i, ABM.SIZE_H6, True, \"lblGrid\")\n"+"	cont1.Cell(2,i).AddComponent(lblGrid)\n"+"Next\n"+"	\n"+"// add paragraph\n"+"cont1.Cell(3,1).AddComponent(ABMShared.BuildParagraph(page, \"par3\", \"To get a feel of how the grid is used ...\"))\n"+"	\n"+"page.Cell(2,1).AddComponent(cont1)");
 //BA.debugLineNum = 252;BA.debugLine="page.Cell(2,2).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (2),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code)));
 //BA.debugLineNum = 255;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","As you can see, this code is almost exactly the same as the beginning of the code in the ABMPage chapter, except we changed page.Add... to cont1.Add... and added the components accordingly.")));
 //BA.debugLineNum = 258;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par5","This is a very powerful component and if you take your time to think about how the grid of your page must look like, a real time saver.")));
 //BA.debugLineNum = 261;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par6","For further information on how the container works, check out the ABMPage and the Grids chapter (but I'm sure you know that one by heart by now).")));
 //BA.debugLineNum = 263;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildSubHea";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader(_page,"shdr2","Animations")));
 //BA.debugLineNum = 265;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par7","ABMContainers (and ergo all it's children) can be animated with scaling, rotating, moving, blurring and transparancies. This can be done with InitializeAnimated() and creating ABMAnimation objects.  See the blur demo to see how it is done!")));
 //BA.debugLineNum = 267;BA.debugLine="Dim btn1 As ABMButton";
_btn1 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 268;BA.debugLine="btn1.InitializeRaised(page, \"btn1\", \"\", \"\", \"Slid";
_btn1.InitializeRaised(_page,"btn1","","","Slide card IN","bluegrey");
 //BA.debugLineNum = 269;BA.debugLine="btn1.Tag = \"animin\"";
_btn1.Tag = (Object)("animin");
 //BA.debugLineNum = 270;BA.debugLine="page.Cell(6,1).AddComponent(btn1)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn1));
 //BA.debugLineNum = 275;BA.debugLine="Dim myAnim1 As ABMAnimation";
_myanim1 = new com.ab.abmaterial.ABMAnimation();
 //BA.debugLineNum = 276;BA.debugLine="myAnim1.Initialize(\"initial\", 0, ABM.TWEEN_EASEIN";
_myanim1.Initialize("initial",(int) (0),_abm.TWEEN_EASEINQUAD);
 //BA.debugLineNum = 277;BA.debugLine="myAnim1.SlideLeft ' move it a screen to the left";
_myanim1.SlideLeft();
 //BA.debugLineNum = 278;BA.debugLine="myAnim1.ScaleX(0)";
_myanim1.ScaleX(0);
 //BA.debugLineNum = 279;BA.debugLine="myAnim1.ScaleY(0)";
_myanim1.ScaleY(0);
 //BA.debugLineNum = 280;BA.debugLine="myAnim1.RotateY(-180)";
_myanim1.RotateY((int) (-180));
 //BA.debugLineNum = 281;BA.debugLine="page.AddAnimation(myAnim1)";
_page.AddAnimation(_myanim1);
 //BA.debugLineNum = 284;BA.debugLine="Dim myAnim2 As ABMAnimation";
_myanim2 = new com.ab.abmaterial.ABMAnimation();
 //BA.debugLineNum = 285;BA.debugLine="myAnim2.Initialize(\"animin\", 500, ABM.TWEEN_EASEI";
_myanim2.Initialize("animin",(int) (500),_abm.TWEEN_EASEINQUAD);
 //BA.debugLineNum = 286;BA.debugLine="myAnim2.SlideInPositionX ' sliding in the 'normal";
_myanim2.SlideInPositionX();
 //BA.debugLineNum = 287;BA.debugLine="myAnim2.ScaleX(1)";
_myanim2.ScaleX(1);
 //BA.debugLineNum = 288;BA.debugLine="myAnim2.ScaleY(1)";
_myanim2.ScaleY(1);
 //BA.debugLineNum = 289;BA.debugLine="myAnim2.RotateY(0)";
_myanim2.RotateY((int) (0));
 //BA.debugLineNum = 290;BA.debugLine="page.AddAnimation(myAnim2)";
_page.AddAnimation(_myanim2);
 //BA.debugLineNum = 293;BA.debugLine="Dim myAnim3 As ABMAnimation";
_myanim3 = new com.ab.abmaterial.ABMAnimation();
 //BA.debugLineNum = 294;BA.debugLine="myAnim3.Initialize(\"animout\", 500, ABM.TWEEN_EASE";
_myanim3.Initialize("animout",(int) (500),_abm.TWEEN_EASEINQUAD);
 //BA.debugLineNum = 295;BA.debugLine="myAnim3.SlideRight ' move it a screen to the righ";
_myanim3.SlideRight();
 //BA.debugLineNum = 296;BA.debugLine="myAnim3.ScaleX(0)";
_myanim3.ScaleX(0);
 //BA.debugLineNum = 297;BA.debugLine="myAnim3.ScaleY(0)";
_myanim3.ScaleY(0);
 //BA.debugLineNum = 298;BA.debugLine="myAnim3.RotateY(-180)";
_myanim3.RotateY((int) (-180));
 //BA.debugLineNum = 299;BA.debugLine="page.AddAnimation(myAnim3)";
_page.AddAnimation(_myanim3);
 //BA.debugLineNum = 301;BA.debugLine="Dim cont2 As ABMContainer";
_cont2 = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 303;BA.debugLine="cont2.InitializeAnimated(page, \"cont2\", \"initial\"";
_cont2.InitializeAnimated(_page,"cont2","initial","");
 //BA.debugLineNum = 304;BA.debugLine="cont2.AddRowsM(1,False,0,0, \"\").AddCells12(1,\"\")";
_cont2.AddRowsM((int) (1),__c.False,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 305;BA.debugLine="cont2.BuildGrid ' IMPORTANT";
_cont2.BuildGrid();
 //BA.debugLineNum = 308;BA.debugLine="Dim tmpCard As ABMCard";
_tmpcard = new com.ab.abmaterial.ABMCard();
 //BA.debugLineNum = 309;BA.debugLine="tmpCard.InitializeAsCard(page, \"card1\", DateTime.";
_tmpcard.InitializeAsCard(_page,"card1",__c.DateTime.Date(__c.DateTime.getNow())+" "+__c.DateTime.Time(__c.DateTime.getNow()),"This is a new animated card",_abm.CARD_LARGE,"whitetitle");
 //BA.debugLineNum = 310;BA.debugLine="tmpCard.Image = \"../images2/16.jpg\"";
_tmpcard.Image = "../images2/16.jpg";
 //BA.debugLineNum = 311;BA.debugLine="tmpCard.AddAction(\"BUTTON 1\")";
_tmpcard.AddAction("BUTTON 1");
 //BA.debugLineNum = 313;BA.debugLine="cont2.Cell(1,1).AddComponent(tmpCard)";
_cont2.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_tmpcard));
 //BA.debugLineNum = 315;BA.debugLine="page.Cell(7,1).AddComponent(cont2)";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_cont2));
 //BA.debugLineNum = 318;BA.debugLine="Dim btn2 As ABMButton";
_btn2 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 319;BA.debugLine="btn2.InitializeRaised(page, \"btn2\", \"\", \"\", \"Unbl";
_btn2.InitializeRaised(_page,"btn2","","","Unblur","bluegrey");
 //BA.debugLineNum = 320;BA.debugLine="btn2.Tag = \"unblur\"";
_btn2.Tag = (Object)("unblur");
 //BA.debugLineNum = 321;BA.debugLine="page.Cell(8,1).AddComponent(btn2)";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn2));
 //BA.debugLineNum = 326;BA.debugLine="Dim myAnim4 As ABMAnimation";
_myanim4 = new com.ab.abmaterial.ABMAnimation();
 //BA.debugLineNum = 327;BA.debugLine="myAnim4.Initialize(\"initialblur\", 0, ABM.TWEEN_EA";
_myanim4.Initialize("initialblur",(int) (0),_abm.TWEEN_EASEINQUAD);
 //BA.debugLineNum = 328;BA.debugLine="myAnim4.Opacity(0.0)";
_myanim4.Opacity(0.0);
 //BA.debugLineNum = 329;BA.debugLine="myAnim4.Blur(20)";
_myanim4.Blur((int) (20));
 //BA.debugLineNum = 330;BA.debugLine="page.AddAnimation(myAnim4)";
_page.AddAnimation(_myanim4);
 //BA.debugLineNum = 333;BA.debugLine="Dim myAnim5 As ABMAnimation";
_myanim5 = new com.ab.abmaterial.ABMAnimation();
 //BA.debugLineNum = 334;BA.debugLine="myAnim5.Initialize(\"unblur\", 500, ABM.TWEEN_EASEI";
_myanim5.Initialize("unblur",(int) (500),_abm.TWEEN_EASEINQUAD);
 //BA.debugLineNum = 335;BA.debugLine="myAnim5.Opacity(1)";
_myanim5.Opacity(1);
 //BA.debugLineNum = 336;BA.debugLine="myAnim5.Blur(0)";
_myanim5.Blur((int) (0));
 //BA.debugLineNum = 337;BA.debugLine="page.AddAnimation(myAnim5)";
_page.AddAnimation(_myanim5);
 //BA.debugLineNum = 340;BA.debugLine="Dim myAnim6 As ABMAnimation";
_myanim6 = new com.ab.abmaterial.ABMAnimation();
 //BA.debugLineNum = 341;BA.debugLine="myAnim6.Initialize(\"blur\", 500, ABM.TWEEN_EASEINQ";
_myanim6.Initialize("blur",(int) (500),_abm.TWEEN_EASEINQUAD);
 //BA.debugLineNum = 342;BA.debugLine="myAnim6.Opacity(0.0)";
_myanim6.Opacity(0.0);
 //BA.debugLineNum = 343;BA.debugLine="myAnim6.Blur(20)";
_myanim6.Blur((int) (20));
 //BA.debugLineNum = 344;BA.debugLine="page.AddAnimation(myAnim6)";
_page.AddAnimation(_myanim6);
 //BA.debugLineNum = 346;BA.debugLine="Dim cont3 As ABMContainer";
_cont3 = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 348;BA.debugLine="cont3.InitializeAnimated(page, \"cont3\", \"initialb";
_cont3.InitializeAnimated(_page,"cont3","initialblur","");
 //BA.debugLineNum = 349;BA.debugLine="cont3.AddRowsM(1,False,0,0, \"\").AddCells12(1,\"\")";
_cont3.AddRowsM((int) (1),__c.False,(int) (0),(int) (0),"").AddCells12((int) (1),"");
 //BA.debugLineNum = 350;BA.debugLine="cont3.BuildGrid ' IMPORTANT";
_cont3.BuildGrid();
 //BA.debugLineNum = 352;BA.debugLine="Dim codeBlock As String = $\"// the blur effect	 D";
_codeblock = ("// the blur effect	\n"+"Dim btn2 As ABMButton\n"+"btn2.InitializeRaised(page, \"btn2\", \"\", \"\", \"Unblur\", \"bluegrey\")\n"+"btn2.Tag = \"unblur\"\n"+"page.Cell(8,1).AddComponent(btn2)\n"+"	\n"+"// create the container with animation	\n"+"\n"+"// you ALWAYS need an Initial state, duration should be 0 for the initial state\n"+"Dim myAnim4 As ABMAnimation\n"+"myAnim4.Initialize(\"initialblur\", 0, ABM.TWEEN_EASEINQUAD)\n"+"myAnim4.Opacity(0.0)\n"+"myAnim4.Blur(20)\n"+"page.AddAnimation(myAnim4)\n"+"\n"+"// we create an animation to 'unblur'\n"+"Dim myAnim5 As ABMAnimation\n"+"myAnim5.Initialize(\"unblur\", 500, ABM.TWEEN_EASEINQUAD)\n"+"myAnim5.Opacity(1)\n"+"myAnim5.Blur(0)\n"+"page.AddAnimation(myAnim5)	\n"+"\n"+"// we create an animation to 'blur'\n"+"Dim myAnim6 As ABMAnimation\n"+"myAnim6.Initialize(\"blur\", 500, ABM.TWEEN_EASEINQUAD)\n"+"myAnim6.Opacity(0.0)\n"+"myAnim6.Blur(20)\n"+"page.AddAnimation(myAnim6)\n"+"\n"+"Dim cont3 As ABMContainer\n"+"// new initialize method where you have to set your initial animation\n"+"cont3.InitializeAnimated(page, \"cont3\", \"initialblur\", \"\")\n"+"cont3.AddRowsM(1,False,0,0, \"\").AddCells12(1,\"\")\n"+"cont3.BuildGrid // IMPORTANT	\n"+"\n"+"Dim codeBlock As String = \"...\"\n"+"\n"+"cont3.Cell(1,1).AddComponent(ABMShared.BuildCodeBlockFromSmartString(page, \"codeblock\", codeBlock))\n"+"\n"+"page.Cell(9,1).AddComponent(cont3)");
 //BA.debugLineNum = 393;BA.debugLine="cont3.Cell(1,1).AddComponent(ABMShared.BuildCodeB";
_cont3.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"codeblock",_codeblock)));
 //BA.debugLineNum = 395;BA.debugLine="page.Cell(9,1).AddComponent(cont3)";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_cont3));
 //BA.debugLineNum = 397;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par8","Using the AnimationFinished event and the RunAnimation method, you can control what must be animated:")));
 //BA.debugLineNum = 399;BA.debugLine="Dim codeBlock2 As String = $\"Sub cont3_AnimationF";
_codeblock2 = ("Sub cont3_AnimationFinished(Target As String, lastAnimation As String)\n"+"	Log(\"Animation finished: \" & lastAnimation)\n"+"	Select Case lastAnimation\n"+"		Case \"unblur\"\n"+"			Dim btn2 As ABMButton = page.Component(\"btn2\")	\n"+"			btn2.Tag = \"blur\"		\n"+"			btn2.Text = \"Blur\"\n"+"			btn2.Refresh	\n"+"		Case \"blur\"\n"+"			Dim btn2 As ABMButton = page.Component(\"btn2\")\n"+"			btn2.Tag = \"unblur\"\n"+"			btn2.Text = \"Unblur\"\n"+"			btn2.Refresh\n"+"			// reset to start position\n"+"			Dim cont3 As ABMContainer = page.Component(\"cont3\")\n"+"			cont3.RunAnimation(\"initialblur\")\n"+"	End Select\n"+"End Sub");
 //BA.debugLineNum = 418;BA.debugLine="page.Cell(11,1).AddComponent(ABMShared.BuildCodeB";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"codeblock2",_codeblock2)));
 //BA.debugLineNum = 420;BA.debugLine="Dim codeBlock3 As String = $\"Sub btn2_Clicked(Tar";
_codeblock3 = ("Sub btn2_Clicked(Target As String)\n"+"	Dim btn2 As ABMButton = page.Component(\"btn2\")	\n"+"	Dim cont3 As ABMContainer = page.Component(\"cont3\")\n"+"	\n"+"	Select Case btn2.Tag\n"+"		Case \"unblur\"\n"+"			cont3.RunAnimation(\"unblur\")			\n"+"		Case \"blur\"		\n"+"			cont3.RunAnimation(\"blur\")	\n"+"	End Select	\n"+"End Sub");
 //BA.debugLineNum = 432;BA.debugLine="page.Cell(12,1).AddComponent(ABMShared.BuildCodeB";
_page.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"codeblock3",_codeblock3)));
 //BA.debugLineNum = 435;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 437;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 440;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 442;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 443;BA.debugLine="End Sub";
return "";
}
public String  _cont2_animationfinished(String _target,String _lastanimation) throws Exception{
com.ab.abmaterial.ABMButton _btn1 = null;
com.ab.abmaterial.ABMContainer _cont2 = null;
 //BA.debugLineNum = 445;BA.debugLine="Sub cont2_AnimationFinished(Target As String, last";
 //BA.debugLineNum = 446;BA.debugLine="Log(\"Animation finished: \" & lastAnimation)";
__c.Log("Animation finished: "+_lastanimation);
 //BA.debugLineNum = 447;BA.debugLine="Select Case lastAnimation";
switch (BA.switchObjectToInt(_lastanimation,"animin","animout")) {
case 0: {
 //BA.debugLineNum = 449;BA.debugLine="Dim btn1 As ABMButton = page.Component(\"btn1\")";
_btn1 = (com.ab.abmaterial.ABMButton)(_page.Component("btn1"));
 //BA.debugLineNum = 450;BA.debugLine="btn1.Tag = \"animout\"";
_btn1.Tag = (Object)("animout");
 //BA.debugLineNum = 451;BA.debugLine="btn1.Text = \"Slide card OUT\"";
_btn1.Text = "Slide card OUT";
 //BA.debugLineNum = 452;BA.debugLine="btn1.Refresh";
_btn1.Refresh();
 break; }
case 1: {
 //BA.debugLineNum = 454;BA.debugLine="Dim btn1 As ABMButton = page.Component(\"btn1\")";
_btn1 = (com.ab.abmaterial.ABMButton)(_page.Component("btn1"));
 //BA.debugLineNum = 455;BA.debugLine="btn1.Tag = \"animin\"";
_btn1.Tag = (Object)("animin");
 //BA.debugLineNum = 456;BA.debugLine="btn1.Text = \"Slide card IN\"";
_btn1.Text = "Slide card IN";
 //BA.debugLineNum = 457;BA.debugLine="btn1.Refresh";
_btn1.Refresh();
 //BA.debugLineNum = 459;BA.debugLine="Dim cont2 As ABMContainer = page.Component(\"con";
_cont2 = (com.ab.abmaterial.ABMContainer)(_page.Component("cont2"));
 //BA.debugLineNum = 460;BA.debugLine="cont2.RunAnimation(\"initial\")";
_cont2.RunAnimation("initial");
 break; }
}
;
 //BA.debugLineNum = 462;BA.debugLine="End Sub";
return "";
}
public String  _cont3_animationfinished(String _target,String _lastanimation) throws Exception{
com.ab.abmaterial.ABMButton _btn2 = null;
com.ab.abmaterial.ABMContainer _cont3 = null;
 //BA.debugLineNum = 476;BA.debugLine="Sub cont3_AnimationFinished(Target As String, last";
 //BA.debugLineNum = 477;BA.debugLine="Log(\"Animation finished: \" & lastAnimation)";
__c.Log("Animation finished: "+_lastanimation);
 //BA.debugLineNum = 478;BA.debugLine="Select Case lastAnimation";
switch (BA.switchObjectToInt(_lastanimation,"unblur","blur")) {
case 0: {
 //BA.debugLineNum = 480;BA.debugLine="Dim btn2 As ABMButton = page.Component(\"btn2\")";
_btn2 = (com.ab.abmaterial.ABMButton)(_page.Component("btn2"));
 //BA.debugLineNum = 481;BA.debugLine="btn2.Tag = \"blur\"";
_btn2.Tag = (Object)("blur");
 //BA.debugLineNum = 482;BA.debugLine="btn2.Text = \"Blur\"";
_btn2.Text = "Blur";
 //BA.debugLineNum = 483;BA.debugLine="btn2.Refresh";
_btn2.Refresh();
 break; }
case 1: {
 //BA.debugLineNum = 485;BA.debugLine="Dim btn2 As ABMButton = page.Component(\"btn2\")";
_btn2 = (com.ab.abmaterial.ABMButton)(_page.Component("btn2"));
 //BA.debugLineNum = 486;BA.debugLine="btn2.Tag = \"unblur\"";
_btn2.Tag = (Object)("unblur");
 //BA.debugLineNum = 487;BA.debugLine="btn2.Text = \"Unblur\"";
_btn2.Text = "Unblur";
 //BA.debugLineNum = 488;BA.debugLine="btn2.Refresh";
_btn2.Refresh();
 //BA.debugLineNum = 490;BA.debugLine="Dim cont3 As ABMContainer = page.Component(\"con";
_cont3 = (com.ab.abmaterial.ABMContainer)(_page.Component("cont3"));
 //BA.debugLineNum = 491;BA.debugLine="cont3.RunAnimation(\"initialblur\")";
_cont3.RunAnimation("initialblur");
 break; }
}
;
 //BA.debugLineNum = 493;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 514;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 515;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 516;BA.debugLine="If Action = \"ABMContainer\" Then Return";
if ((_action).equals("ABMContainer")) { 
if (true) return "";};
 //BA.debugLineNum = 517;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 518;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 519;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 520;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 522;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 523;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 524;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 526;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 527;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 529;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 530;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 531;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 532;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 533;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 534;BA.debugLine="End Sub";
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
