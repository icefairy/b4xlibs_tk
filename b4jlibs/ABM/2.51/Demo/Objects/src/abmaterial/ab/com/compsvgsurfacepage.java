package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compsvgsurfacepage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compsvgsurfacepage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compsvgsurfacepage.class).invoke(this, new Object[] {null});
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
public String  _addbarrow(int _pagerow,String _id,String _text,double _perc,double _weektodoperc,boolean _isbad) throws Exception{
com.ab.abmaterial.ABMContainer _cnt = null;
com.ab.abmaterial.ABMLabel _lbl1 = null;
com.ab.abmaterial.ABMSVGSurface _svg = null;
com.ab.abmaterial.ABMSVGElement _rect1 = null;
com.ab.abmaterial.ABMSVGElement _line2 = null;
 //BA.debugLineNum = 284;BA.debugLine="Sub AddBarRow(PageRow As Int, id As String, Text A";
 //BA.debugLineNum = 285;BA.debugLine="Dim cnt As ABMContainer";
_cnt = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 286;BA.debugLine="cnt.Initialize(page , \"cnt_\" & id, \"\")";
_cnt.Initialize(_page,"cnt_"+_id,"");
 //BA.debugLineNum = 288;BA.debugLine="cnt.AddRowsM(1, False,0,0,\"\").AddCellsOSMP(1,0,0,";
_cnt.AddRowsM((int) (1),__c.False,(int) (0),(int) (0),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (6),(int) (6),(int) (0),(int) (0),(int) (10),(int) (10),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (6),(int) (6),(int) (0),(int) (0),(int) (10),(int) (10),"");
 //BA.debugLineNum = 289;BA.debugLine="cnt.BuildGrid";
_cnt.BuildGrid();
 //BA.debugLineNum = 291;BA.debugLine="Dim lbl1 As ABMLabel";
_lbl1 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 292;BA.debugLine="lbl1.Initialize(page, \"lbl1_\" & id, Text, ABM.SIZ";
_lbl1.Initialize(_page,"lbl1_"+_id,_text,_abm.SIZE_H6,__c.True,"");
 //BA.debugLineNum = 294;BA.debugLine="cnt.Cell(1,1).AddComponent(lbl1)";
_cnt.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl1));
 //BA.debugLineNum = 297;BA.debugLine="page.Cell(PageRow,1).AddComponent(cnt)";
_page.Cell(_pagerow,(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_cnt));
 //BA.debugLineNum = 299;BA.debugLine="Dim svg As ABMSVGSurface";
_svg = new com.ab.abmaterial.ABMSVGSurface();
 //BA.debugLineNum = 300;BA.debugLine="svg.Initialize(page, \"svg_\" & id, \"0 0 400 50\", \"";
_svg.Initialize(_page,"svg_"+_id,"0 0 400 50","none","400px","50px");
 //BA.debugLineNum = 301;BA.debugLine="cnt.Cell(1,2).AddComponent(svg)";
_cnt.Cell((int) (1),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_svg));
 //BA.debugLineNum = 302;BA.debugLine="cnt.Cell(1,2).MarginBottom = \"-28px\"";
_cnt.Cell((int) (1),(int) (2)).MarginBottom = "-28px";
 //BA.debugLineNum = 304;BA.debugLine="Dim rect1 As ABMSVGElement = svg.Rect(\"rect\" & id";
_rect1 = _svg.Rect("rect"+_id,(int) (0),(int) (0),(int) (_perc*4),(int) (50),(int) (0),(int) (0));
 //BA.debugLineNum = 306;BA.debugLine="If perc >= WeekToDoPerc Then";
if (_perc>=_weektodoperc) { 
 //BA.debugLineNum = 307;BA.debugLine="rect1.SetAttributes($\"{fill: \"#e6ee9c\"}\"$)";
_rect1.SetAttributes(("{fill: \"#e6ee9c\"}"));
 }else {
 //BA.debugLineNum = 309;BA.debugLine="rect1.SetAttributes($\"{fill: \"#ffcc80\"}\"$)";
_rect1.SetAttributes(("{fill: \"#ffcc80\"}"));
 //BA.debugLineNum = 310;BA.debugLine="If perc < (WeekToDoPerc - 10) Then";
if (_perc<(_weektodoperc-10)) { 
 //BA.debugLineNum = 311;BA.debugLine="rect1.AddAnimationContinuousRun($\"{fill: \"#e651";
_rect1.AddAnimationContinuousRun(("{fill: \"#e65100\"}"),(int) (1500),"",("{fill: \"#ffcc80\"}"),(int) (500),"");
 };
 };
 //BA.debugLineNum = 315;BA.debugLine="Dim line2 As ABMSVGElement = svg.Line(\"line2_\" &";
_line2 = _svg.Line("line2_"+_id,(int) (_weektodoperc*4),(int) (0),(int) (_weektodoperc*4),(int) (50));
 //BA.debugLineNum = 316;BA.debugLine="line2.SetAttributes($\"{fill: \"#b71c1c\", stroke: \"";
_line2.SetAttributes(("{fill: \"#b71c1c\", stroke: \"#b71c1c\", strokeWidth: 1}"));
 //BA.debugLineNum = 317;BA.debugLine="End Sub";
return "";
}
public String  _addpierow(int _rownum,int _id,String _text2,double _perc) throws Exception{
com.ab.abmaterial.ABMContainer _cnt = null;
com.ab.abmaterial.ABMContainer _cnt2 = null;
com.ab.abmaterial.ABMLabel _lbl2 = null;
com.ab.abmaterial.ABMSVGSurface _svg = null;
com.ab.abmaterial.ABMSVGElement _cir1 = null;
com.ab.abmaterial.ABMSVGElement _pie1 = null;
com.ab.abmaterial.ABMSVGElement _pie1group = null;
int _endval = 0;
com.ab.abmaterial.ABMSVGElement _txt1 = null;
 //BA.debugLineNum = 319;BA.debugLine="Sub AddPieRow(RowNum As Int, id As Int, text2 As S";
 //BA.debugLineNum = 320;BA.debugLine="Dim cnt As ABMContainer";
_cnt = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 321;BA.debugLine="cnt.Initialize(page , \"pcnt_\" & id, \"\")";
_cnt.Initialize(_page,"pcnt_"+BA.NumberToString(_id),"");
 //BA.debugLineNum = 323;BA.debugLine="cnt.AddRowsM(1, False,0,0,\"\").AddCellsOS(1,0,0,0,";
_cnt.AddRowsM((int) (1),__c.False,(int) (0),(int) (0),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (4),(int) (4),(int) (4),"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (8),(int) (8),(int) (8),"");
 //BA.debugLineNum = 324;BA.debugLine="cnt.BuildGrid";
_cnt.BuildGrid();
 //BA.debugLineNum = 326;BA.debugLine="Dim cnt2 As ABMContainer";
_cnt2 = new com.ab.abmaterial.ABMContainer();
 //BA.debugLineNum = 327;BA.debugLine="cnt2.Initialize(page , \"pcnt2_\" & id, \"\")";
_cnt2.Initialize(_page,"pcnt2_"+BA.NumberToString(_id),"");
 //BA.debugLineNum = 329;BA.debugLine="cnt2.AddRowsM(1, False,0,0,\"\").AddCellsOSMP(1, 0,";
_cnt2.AddRowsM((int) (1),__c.False,(int) (0),(int) (0),"").AddCellsOSMP((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (12),(int) (12),(int) (0),(int) (0),(int) (0),(int) (0),"");
 //BA.debugLineNum = 330;BA.debugLine="cnt2.BuildGrid";
_cnt2.BuildGrid();
 //BA.debugLineNum = 332;BA.debugLine="Dim lbl2 As ABMLabel";
_lbl2 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 333;BA.debugLine="lbl2.Initialize(page, \"plbl2_\" & id, text2, ABM.S";
_lbl2.Initialize(_page,"plbl2_"+BA.NumberToString(_id),_text2,_abm.SIZE_H6,__c.True,"");
 //BA.debugLineNum = 335;BA.debugLine="cnt.cell(1,1).addcomponent(cnt2)";
_cnt.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_cnt2));
 //BA.debugLineNum = 336;BA.debugLine="cnt.Cell(1,2).AddComponent(lbl2)";
_cnt.Cell((int) (1),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl2));
 //BA.debugLineNum = 338;BA.debugLine="page.Cell(RowNum,1).AddComponent(cnt)";
_page.Cell(_rownum,(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_cnt));
 //BA.debugLineNum = 340;BA.debugLine="Dim svg As ABMSVGSurface";
_svg = new com.ab.abmaterial.ABMSVGSurface();
 //BA.debugLineNum = 341;BA.debugLine="svg.Initialize(page, id, \"0 0 80 80\", \"none\", \"80";
_svg.Initialize(_page,BA.NumberToString(_id),"0 0 80 80","none","80px","80px");
 //BA.debugLineNum = 342;BA.debugLine="cnt.Cell(1,1).AddArrayComponent(svg, \"psvg\")";
_cnt.Cell((int) (1),(int) (1)).AddArrayComponent((com.ab.abmaterial.ABMComponent)(_svg),"psvg");
 //BA.debugLineNum = 343;BA.debugLine="cnt.Cell(1,1).MarginBottom = \"-20px\"";
_cnt.Cell((int) (1),(int) (1)).MarginBottom = "-20px";
 //BA.debugLineNum = 345;BA.debugLine="Dim cir1 As ABMSVGElement = svg.circle(\"pcir\" & i";
_cir1 = _svg.Circle("pcir"+BA.NumberToString(_id),(int) (40),(int) (40),(int) (30));
 //BA.debugLineNum = 346;BA.debugLine="cir1.SetAttributes(\"{fill: '#e6ee9c'}\")";
_cir1.SetAttributes("{fill: '#e6ee9c'}");
 //BA.debugLineNum = 348;BA.debugLine="Dim pie1 As ABMSVGElement = svg.Pie(\"ppie\" & id,";
_pie1 = _svg.Pie("ppie"+BA.NumberToString(_id),(int) (40),(int) (40),(int) (0),(int) (30),(int) (-90),(int) (0));
 //BA.debugLineNum = 350;BA.debugLine="Dim pie1Group As ABMSVGElement = svg.Group(\"ppie\"";
_pie1group = _svg.Group("ppie"+BA.NumberToString(_id)+"Group",anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"ppie"+BA.NumberToString(_id)}));
 //BA.debugLineNum = 351;BA.debugLine="pie1Group.SetAttributes(\"{cursor: 'pointer'}\")";
_pie1group.SetAttributes("{cursor: 'pointer'}");
 //BA.debugLineNum = 353;BA.debugLine="pie1.SetAttributes(\"{fill: '#ffcc80'}\")";
_pie1.SetAttributes("{fill: '#ffcc80'}");
 //BA.debugLineNum = 354;BA.debugLine="Dim EndVal As Int = (360*perc/100)-90";
_endval = (int) ((360*_perc/(double)100)-90);
 //BA.debugLineNum = 355;BA.debugLine="pie1.AddHoverINAnimation(\"{r2: 40}\",250,\"\")";
_pie1.AddHoverINAnimation("{r2: 40}",(int) (250),"");
 //BA.debugLineNum = 356;BA.debugLine="pie1.AddHoverOUTAnimation(\"{r2: 30}\",250,\"\")";
_pie1.AddHoverOUTAnimation("{r2: 30}",(int) (250),"");
 //BA.debugLineNum = 358;BA.debugLine="pie1.AddAnimationSingleRun(\"{start: -90, end: \" &";
_pie1.AddAnimationSingleRun("{start: -90, end: "+BA.NumberToString(_endval)+"}",(int) (3000),"mina.bounce");
 //BA.debugLineNum = 359;BA.debugLine="pie1.HasEvents = True";
_pie1.HasEvents = __c.True;
 //BA.debugLineNum = 361;BA.debugLine="If perc < 40 Then";
if (_perc<40) { 
 //BA.debugLineNum = 362;BA.debugLine="pie1.AddAnimationContinuousRun(\"{fill: '#e65100'";
_pie1.AddAnimationContinuousRun("{fill: '#e65100'}",(int) (1500),"","{fill: '#ffcc80'}",(int) (500),"");
 };
 //BA.debugLineNum = 365;BA.debugLine="Dim txt1 As ABMSVGElement = svg.Text(\"txt\" & id,";
_txt1 = _svg.Text("txt"+BA.NumberToString(_id),(int) (40),(int) (40),BA.NumberToString(_perc)+"%");
 //BA.debugLineNum = 366;BA.debugLine="txt1.SetAttributes(\"{fill: '#000000', 'text-ancho";
_txt1.SetAttributes("{fill: '#000000', 'text-anchor': 'middle', 'alignment-baseline': 'middle'}");
 //BA.debugLineNum = 367;BA.debugLine="End Sub";
return "";
}
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
 //BA.debugLineNum = 104;BA.debugLine="page.PageTitle = \"ABMSVGSurface\"";
_page.PageTitle = "ABMSVGSurface";
 //BA.debugLineNum = 105;BA.debugLine="page.PageDescription = \"The SVG component \"";
_page.PageDescription = "The SVG component ";
 //BA.debugLineNum = 106;BA.debugLine="page.PageHTMLName = \"abmaterial-svgsurface.html\"";
_page.PageHTMLName = "abmaterial-svgsurface.html";
 //BA.debugLineNum = 107;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 108;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 109;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 110;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 112;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMSVGSurface";
_abmshared._buildnavigationbar(_page,"ABMSVGSurface","../images/logo.png","","Controls","ABMSVGSurface");
 //BA.debugLineNum = 115;BA.debugLine="page.AddRows(9,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (9),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 116;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 118;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 119;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompSVGSurfacePage\"";
_name = "CompSVGSurfacePage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
anywheresoftware.b4a.objects.collections.List _values = null;
int _i = 0;
double _value = 0;
String _code1 = "";
double _perc = 0;
String _code2 = "";
String _code3 = "";
 //BA.debugLineNum = 121;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 123;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 125;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","ABMSVGSurface and ABMSVGElement make it possible to make interactive and animated SVG images. This can be useful to build custom lightweight graphics like charts that do not need the full ABMChart library.")));
 //BA.debugLineNum = 127;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","{B}Note{/B}: although the attribute strings look very much like CSS, they are not. Check out {AL}https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute{AT}https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute{/AL} For more info.")));
 //BA.debugLineNum = 129;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","Here are some examples of such SVG components. E.g. an animated bar chart:")));
 //BA.debugLineNum = 134;BA.debugLine="Dim values As List";
_values = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 135;BA.debugLine="values.initialize";
_values.Initialize();
 //BA.debugLineNum = 136;BA.debugLine="For i = 1 To 10";
{
final int step7 = 1;
final int limit7 = (int) (10);
_i = (int) (1) ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
 //BA.debugLineNum = 137;BA.debugLine="Dim value As Double = Rnd(20,100)";
_value = __c.Rnd((int) (20),(int) (100));
 //BA.debugLineNum = 138;BA.debugLine="values.Add(value)";
_values.Add((Object)(_value));
 }
};
 //BA.debugLineNum = 140;BA.debugLine="For i = 1 To 10";
{
final int step11 = 1;
final int limit11 = (int) (10);
_i = (int) (1) ;
for (;(step11 > 0 && _i <= limit11) || (step11 < 0 && _i >= limit11) ;_i = ((int)(0 + _i + step11))  ) {
 //BA.debugLineNum = 141;BA.debugLine="Dim value As Double = values.Get(i-1)";
_value = (double)(BA.ObjectToNumber(_values.Get((int) (_i-1))));
 //BA.debugLineNum = 142;BA.debugLine="AddBarRow(2, \"per\" & i, \"Person \" & i, value, 75";
_addbarrow((int) (2),"per"+BA.NumberToString(_i),"Person "+BA.NumberToString(_i),_value,75,(_value<40));
 }
};
 //BA.debugLineNum = 146;BA.debugLine="Dim code1 As String = $\"Sub AddBarRow(PageRow As";
_code1 = ("Sub AddBarRow(PageRow As Int, id As String, Text As String, perc As Double, WeekToDoPerc As Double, IsBad As Boolean)\n"+"	Dim cnt As ABMContainer\n"+"	cnt.Initialize(page , \"cnt_\" & id, \"\")\n"+"	\n"+"	cnt.AddRowsM(1, False,0,0,\"\").AddCellsOSMP(1,0,0,0,12,6,6,0,0,10,10,\"\").AddCellsOSMP(1,0,0,0,12,6,6,0,0,10,10,\"\")\n"+"	cnt.BuildGrid\n"+"	\n"+"	Dim lbl1 As ABMLabel\n"+"	lbl1.Initialize(page, \"lbl1_\" & id, Text, ABM.SIZE_H6, True, \"\")\n"+"		\n"+"	cnt.Cell(1,1).AddComponent(lbl1)\n"+"	\n"+"	// make sure the container is added BEFORE adding an SVGsurface\n"+"	page.Cell(PageRow,1).AddComponent(cnt)\n"+"	\n"+"	Dim svg As ABMSVGSurface\n"+"	svg.Initialize(page, \"svg_\" & id, \"0 0 400 50\", \"none\", \"400px\", \"50px\")\n"+"	cnt.Cell(1,2).AddComponent(svg)\n"+"	cnt.Cell(1,2).MarginBottom = \"-28px\"\n"+"		\n"+"	Dim rect1 As ABMSVGElement = svg.Rect(\"rect\" & id, 0,0,perc*4,50,0,0)\n"+"		\n"+"	If perc >= WeekToDoPerc Then\n"+"		rect1.SetAttributes(\"{fill: '#e6ee9c'}\")\n"+"	Else\n"+"		rect1.SetAttributes(\"{fill: '#ffcc80'}\")\n"+"		If perc < (WeekToDoPerc - 10) Then\n"+"			rect1.AddAnimationContinuousRun(\"{fill: '#e65100'}\", 1500, \"\", \"{fill: '#ffcc80'}\", 500, \"\")\n"+"		End If\n"+"	End If\n"+"	\n"+"	Dim line2 As ABMSVGElement = svg.Line(\"line2_\" & id, WeekToDoPerc*4,0,WeekToDoPerc*4,50)\n"+"	line2.SetAttributes(\"{fill: '#b71c1c', stroke: '#b71c1c', strokeWidth: 1}\")	\n"+"End Sub");
 //BA.debugLineNum = 181;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code1",_code1)));
 //BA.debugLineNum = 184;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","An interactive Pie chart (hover to see the effect, click on the Pie part see interactivity).")));
 //BA.debugLineNum = 186;BA.debugLine="For i = 1 To 10";
{
final int step18 = 1;
final int limit18 = (int) (10);
_i = (int) (1) ;
for (;(step18 > 0 && _i <= limit18) || (step18 < 0 && _i >= limit18) ;_i = ((int)(0 + _i + step18))  ) {
 //BA.debugLineNum = 187;BA.debugLine="Dim perc As Double = Rnd(10, 100)";
_perc = __c.Rnd((int) (10),(int) (100));
 //BA.debugLineNum = 188;BA.debugLine="AddPieRow(5, i, \"Pie in row \" & i, perc)";
_addpierow((int) (5),_i,"Pie in row "+BA.NumberToString(_i),_perc);
 }
};
 //BA.debugLineNum = 192;BA.debugLine="Dim code2 As String = $\"Sub AddPieRow(RowNum As I";
_code2 = ("Sub AddPieRow(RowNum As Int, id As Int, text2 As String, perc As Double)\n"+"	Dim cnt As ABMContainer\n"+"	cnt.Initialize(page , \"pcnt_\" & id, \"\")\n"+"	\n"+"	cnt.AddRowsM(1, False,0,0,\"\").AddCellsOS(1,0,0,0,4,4,4,\"\").AddCellsOS(1,0,0,0,8,8,8,\"\")\n"+"	cnt.BuildGrid\n"+"	\n"+"	Dim cnt2 As ABMContainer\n"+"	cnt2.Initialize(page , \"pcnt2_\" & id, \"\")\n"+"	\n"+"	cnt2.AddRowsM(1, False,0,0,\"\").AddCellsOSMP(1, 0,0,0,12,12,12,0,0,0,0,\"\")\n"+"	cnt2.BuildGrid	\n"+"	\n"+"	Dim lbl2 As ABMLabel\n"+"	lbl2.Initialize(page, \"plbl2_\" & id, text2, ABM.SIZE_H6, True, \"\")	\n"+"\n"+"	cnt.cell(1,1).addcomponent(cnt2)\n"+"	cnt.Cell(1,2).AddComponent(lbl2)\n"+"	\n"+"	page.Cell(RowNum,1).AddComponent(cnt)\n"+"	\n"+"	Dim svg As ABMSVGSurface\n"+"	svg.Initialize(page, id, \"0 0 80 80\", \"none\", \"80px\", \"80px\")\n"+"	cnt.Cell(1,1).AddArrayComponent(svg, \"psvg\")\n"+"	cnt.Cell(1,1).MarginBottom = \"-20px\"\n"+"		\n"+"	Dim cir1 As ABMSVGElement = svg.circle(\"pcir\" & id, 40,40,30)\n"+"	cir1.SetAttributes(\"{fill: '#e6ee9c'}\")\n"+"\n"+"	Dim pie1 As ABMSVGElement = svg.Pie(\"ppie\" & id, 40,40,0,30, -90, 0)\n"+"	\n"+"	Dim pie1Group As ABMSVGElement = svg.Group(\"ppie\" & id & \"Group\", Array As String(\"ppie\" & id))  ' <- Needed for the pointer cursor, can only be set to a group\n"+"	pie1Group.SetAttributes(\"{cursor: 'pointer'}\")\n"+"	\n"+"	pie1.SetAttributes(\"{fill: '#ffcc80'}\")\n"+"	Dim EndVal As Int = (360*perc/100)-90\n"+"	pie1.AddHoverINAnimation(\"{r2: 40}\",250,\"\")\n"+"	pie1.AddHoverOUTAnimation(\"{r2: 30}\",250,\"\")\n"+"	//pie1.AddAnimationContinuousRun(\"{start: -90, end: \" & EndVal & \"}\", 3000, \"mina.bounce\", \"{start: -90, end: -90}\", 3000, \"mina.bounce\")\n"+"	pie1.AddAnimationSingleRun(\"{start: -90, end: \" & EndVal & \"}\", 3000, \"mina.bounce\")\n"+"	pie1.HasEvents = True\n"+"	\n"+"	If perc < 40 Then\n"+"		pie1.AddAnimationContinuousRun(\"{fill: '#e65100'}\", 1500, \"\", \"{fill: '#ffcc80'}\", 500, \"\")\n"+"	End If	\n"+"			\n"+"	Dim txt1 As ABMSVGElement = svg.Text(\"txt\" & id, 40,40, perc & \"%\")\n"+"	txt1.SetAttributes(\"{fill: '#000000', 'text-anchor': 'middle', 'alignment-baseline': 'middle'}\")\n"+"End Sub");
 //BA.debugLineNum = 241;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code2",_code2)));
 //BA.debugLineNum = 243;BA.debugLine="Dim code3 As String = $\"Sub psvg_SVGClicked(eleme";
_code3 = ("Sub psvg_SVGClicked(elementID As String)\n"+"	myToastId = myToastId + 1	\n"+"	page.ShowToast(\"toast\" & myToastId, \"toastred\", \"Clicked on SVGelement \" & elementID, 2000)\n"+"End Sub");
 //BA.debugLineNum = 248;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblockfromsmartstring(_page,"code3",_code3)));
 //BA.debugLineNum = 251;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 253;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 256;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 258;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 259;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 262;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 263;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 264;BA.debugLine="If Action = \"ABMSVGSurface\" Then Return";
if ((_action).equals("ABMSVGSurface")) { 
if (true) return "";};
 //BA.debugLineNum = 265;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 266;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 267;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 268;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 270;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 271;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 272;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 274;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 275;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 277;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 278;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 279;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 280;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 281;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 282;BA.debugLine="End Sub";
return "";
}
public String  _psvg_svgclicked(String _elementid) throws Exception{
 //BA.debugLineNum = 369;BA.debugLine="Sub psvg_SVGClicked(elementID As String)";
 //BA.debugLineNum = 370;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 371;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Clicked on SVGelement "+_elementid,(int) (2000));
 //BA.debugLineNum = 372;BA.debugLine="End Sub";
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
