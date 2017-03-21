package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compgooglemappage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compgooglemappage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compgooglemappage.class).invoke(this, new Object[] {null});
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
public int _counter = 0;
public anywheresoftware.b4a.objects.collections.List _markers = null;
public b4j.example.dateutils _dateutils = null;
public abmaterial.ab.com.main _main = null;
public abmaterial.ab.com.abmshared _abmshared = null;
public abmaterial.ab.com.abmprint _abmprint = null;
public String  _btn_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 276;BA.debugLine="Sub btn_Clicked(Target As String)";
 //BA.debugLineNum = 277;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 278;BA.debugLine="gm1.AddMarker(\"mymarker1\", 50.8500, 2.8833, ABM.C";
_gm1.AddMarker("mymarker1",50.8500,2.8833,_abm.COLOR_RED,"Hello","Ypres, the town I live in!");
 //BA.debugLineNum = 279;BA.debugLine="gm1.refresh ' IMPORTANT";
_gm1.Refresh();
 //BA.debugLineNum = 280;BA.debugLine="End Sub";
return "";
}
public String  _btn10_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 329;BA.debugLine="Sub btn10_Clicked(Target As String)";
 //BA.debugLineNum = 330;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 331;BA.debugLine="gm1.AddMarker(\"start\", 50.8500, 2.8833, ABM.COLOR";
_gm1.AddMarker("start",50.8500,2.8833,_abm.COLOR_RED,"","");
 //BA.debugLineNum = 332;BA.debugLine="gm1.AddMarker(\"stop\", 50.9333, 3.1167, ABM.COLOR_";
_gm1.AddMarker("stop",50.9333,3.1167,_abm.COLOR_RED,"","");
 //BA.debugLineNum = 333;BA.debugLine="gm1.AddRoute(50.8500, 2.8833, 50.9333, 3.1167, AB";
_gm1.AddRoute(50.8500,2.8833,50.9333,3.1167,_abm.GOOGLEMAP_TRAVELMODE_DRIVING,_abm.COLOR_DEEPPURPLE,_abm.INTENSITY_NORMAL,0.6,(int) (5));
 //BA.debugLineNum = 334;BA.debugLine="gm1.FitZoom";
_gm1.FitZoom();
 //BA.debugLineNum = 335;BA.debugLine="gm1.refresh ' IMPORTANT";
_gm1.Refresh();
 //BA.debugLineNum = 336;BA.debugLine="End Sub";
return "";
}
public String  _btn11_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 338;BA.debugLine="Sub btn11_Clicked(Target As String)";
 //BA.debugLineNum = 339;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 340;BA.debugLine="gm1.RemoveRoutes";
_gm1.RemoveRoutes();
 //BA.debugLineNum = 341;BA.debugLine="gm1.refresh ' IMPORTANT";
_gm1.Refresh();
 //BA.debugLineNum = 342;BA.debugLine="End Sub";
return "";
}
public String  _btn12_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 344;BA.debugLine="Sub btn12_Clicked(Target As String)";
 //BA.debugLineNum = 345;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 346;BA.debugLine="gm1.ReverseGeoCode(50.8500, 2.8833)";
_gm1.ReverseGeoCode(50.8500,2.8833);
 //BA.debugLineNum = 347;BA.debugLine="gm1.refresh ' IMPORTANT";
_gm1.Refresh();
 //BA.debugLineNum = 348;BA.debugLine="End Sub";
return "";
}
public String  _btn2_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 282;BA.debugLine="Sub btn2_Clicked(Target As String)";
 //BA.debugLineNum = 283;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 284;BA.debugLine="gm1.RemoveMarkers";
_gm1.RemoveMarkers();
 //BA.debugLineNum = 285;BA.debugLine="Markers.Clear";
_markers.Clear();
 //BA.debugLineNum = 286;BA.debugLine="gm1.refresh ' IMPORTANT";
_gm1.Refresh();
 //BA.debugLineNum = 287;BA.debugLine="End Sub";
return "";
}
public String  _btn3_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 289;BA.debugLine="Sub btn3_Clicked(Target As String)";
 //BA.debugLineNum = 290;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 291;BA.debugLine="gm1.GeoLocate";
_gm1.GeoLocate();
 //BA.debugLineNum = 292;BA.debugLine="End Sub";
return "";
}
public String  _btn4_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 294;BA.debugLine="Sub btn4_Clicked(Target As String)";
 //BA.debugLineNum = 295;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 296;BA.debugLine="gm1.FitZoom";
_gm1.FitZoom();
 //BA.debugLineNum = 297;BA.debugLine="End Sub";
return "";
}
public String  _btn5_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
com.ab.abmaterial.ABMInput _inp1 = null;
 //BA.debugLineNum = 299;BA.debugLine="Sub btn5_Clicked(Target As String)";
 //BA.debugLineNum = 300;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 301;BA.debugLine="Dim inp1 As ABMInput = page.Component(\"inp1\")";
_inp1 = (com.ab.abmaterial.ABMInput)(_page.Component("inp1"));
 //BA.debugLineNum = 302;BA.debugLine="gm1.GeoCode(inp1.Text)";
_gm1.GeoCode(_inp1.getText());
 //BA.debugLineNum = 303;BA.debugLine="End Sub";
return "";
}
public String  _btn6_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 305;BA.debugLine="Sub btn6_Clicked(Target As String)";
 //BA.debugLineNum = 306;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 307;BA.debugLine="gm1.AddPolyLine(Markers, ABM.COLOR_DEEPORANGE, AB";
_gm1.AddPolyLine(_markers,_abm.COLOR_DEEPORANGE,_abm.INTENSITY_NORMAL,0.6,(int) (5));
 //BA.debugLineNum = 308;BA.debugLine="gm1.refresh ' IMPORTANT";
_gm1.Refresh();
 //BA.debugLineNum = 309;BA.debugLine="End Sub";
return "";
}
public String  _btn7_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 311;BA.debugLine="Sub btn7_Clicked(Target As String)";
 //BA.debugLineNum = 312;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 313;BA.debugLine="gm1.RemovePolylines";
_gm1.RemovePolyLines();
 //BA.debugLineNum = 314;BA.debugLine="gm1.refresh ' IMPORTANT";
_gm1.Refresh();
 //BA.debugLineNum = 315;BA.debugLine="End Sub";
return "";
}
public String  _btn8_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 317;BA.debugLine="Sub btn8_Clicked(Target As String)";
 //BA.debugLineNum = 318;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 319;BA.debugLine="gm1.AddPolygon(Markers, ABM.COLOR_DEEPPURPLE, ABM";
_gm1.AddPolygon(_markers,_abm.COLOR_DEEPPURPLE,_abm.INTENSITY_NORMAL,0.6,(int) (5),_abm.COLOR_CYAN,_abm.INTENSITY_NORMAL,0.3);
 //BA.debugLineNum = 320;BA.debugLine="gm1.refresh ' IMPORTANT";
_gm1.Refresh();
 //BA.debugLineNum = 321;BA.debugLine="End Sub";
return "";
}
public String  _btn9_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 323;BA.debugLine="Sub btn9_Clicked(Target As String)";
 //BA.debugLineNum = 324;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 325;BA.debugLine="gm1.RemovePolygons";
_gm1.RemovePolygons();
 //BA.debugLineNum = 326;BA.debugLine="gm1.refresh ' IMPORTANT";
_gm1.Refresh();
 //BA.debugLineNum = 327;BA.debugLine="End Sub";
return "";
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 104;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 107;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 108;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 109;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 110;BA.debugLine="page.PageTitle = \"ABMGoogleMap\"";
_page.PageTitle = "ABMGoogleMap";
 //BA.debugLineNum = 111;BA.debugLine="page.PageDescription = \"The google map component";
_page.PageDescription = "The google map component ";
 //BA.debugLineNum = 112;BA.debugLine="page.PageHTMLName = \"abmaterial-google-map.html\"";
_page.PageHTMLName = "abmaterial-google-map.html";
 //BA.debugLineNum = 113;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 114;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 115;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 116;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 118;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMGoogleMap\"";
_abmshared._buildnavigationbar(_page,"ABMGoogleMap","../images/logo.png","","Controls","ABMGoogleMap");
 //BA.debugLineNum = 121;BA.debugLine="page.AddRows(13,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (13),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 122;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 127;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 90;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 92;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 93;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 97;BA.debugLine="theme.AddButtonTheme(\"bluegrey\")";
_theme.AddButtonTheme("bluegrey");
 //BA.debugLineNum = 98;BA.debugLine="theme.Button(\"bluegrey\").BackColor = ABM.COLOR_BL";
_theme.Button("bluegrey").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 99;BA.debugLine="theme.Button(\"bluegrey\").BackColorIntensity = ABM";
_theme.Button("bluegrey").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompGoogleMapPage\"";
_name = "CompGoogleMapPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="Dim counter As Int";
_counter = 0;
 //BA.debugLineNum = 18;BA.debugLine="Dim Markers As List";
_markers = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
com.ab.abmaterial.ABMButton _btn = null;
com.ab.abmaterial.ABMButton _btn2 = null;
com.ab.abmaterial.ABMButton _btn3 = null;
com.ab.abmaterial.ABMButton _btn4 = null;
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMButton _btn5 = null;
com.ab.abmaterial.ABMButton _btn12 = null;
com.ab.abmaterial.ABMButton _btn6 = null;
com.ab.abmaterial.ABMButton _btn7 = null;
com.ab.abmaterial.ABMButton _btn8 = null;
com.ab.abmaterial.ABMButton _btn9 = null;
com.ab.abmaterial.ABMButton _btn10 = null;
com.ab.abmaterial.ABMButton _btn11 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code = null;
com.ab.abmaterial.ABMGoogleMap _gm2 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code2 = null;
 //BA.debugLineNum = 130;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 132;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 135;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","ABMaterial allows you to use the potential of Google Maps in a simple way.")));
 //BA.debugLineNum = 138;BA.debugLine="Dim gm1 As ABMGoogleMap";
_gm1 = new com.ab.abmaterial.ABMGoogleMap();
 //BA.debugLineNum = 139;BA.debugLine="gm1.Initialize(page, \"gm1\", 50.8500, 2.8833, 15,";
_gm1.Initialize(_page,"gm1",50.8500,2.8833,(int) (15),(int) (350),_abm.GOOGLEMAPTYPE_ROADMAP);
 //BA.debugLineNum = 140;BA.debugLine="gm1.Draggable = True";
_gm1.Draggable = __c.True;
 //BA.debugLineNum = 141;BA.debugLine="gm1.HasMapTypeControl = True";
_gm1.HasMapTypeControl = __c.True;
 //BA.debugLineNum = 142;BA.debugLine="gm1.HasStreetViewControl = True";
_gm1.HasStreetViewControl = __c.True;
 //BA.debugLineNum = 143;BA.debugLine="gm1.HasZoomControl = True";
_gm1.HasZoomControl = __c.True;
 //BA.debugLineNum = 144;BA.debugLine="gm1.AddMapType(ABM.GOOGLEMAPTYPE_ROADMAP)";
_gm1.AddMapType(_abm.GOOGLEMAPTYPE_ROADMAP);
 //BA.debugLineNum = 145;BA.debugLine="gm1.AddMapType(ABM.GOOGLEMAPTYPE_TERRAIN)";
_gm1.AddMapType(_abm.GOOGLEMAPTYPE_TERRAIN);
 //BA.debugLineNum = 146;BA.debugLine="gm1.AddMapType(ABM.GOOGLEMAPTYPE_HYBRID)";
_gm1.AddMapType(_abm.GOOGLEMAPTYPE_HYBRID);
 //BA.debugLineNum = 147;BA.debugLine="gm1.AddMapType(ABM.GOOGLEMAPTYPE_SATELLITE)";
_gm1.AddMapType(_abm.GOOGLEMAPTYPE_SATELLITE);
 //BA.debugLineNum = 149;BA.debugLine="page.Cell(2,1).AddComponent(gm1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_gm1));
 //BA.debugLineNum = 151;BA.debugLine="Dim btn As ABMButton";
_btn = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 152;BA.debugLine="btn.InitializeRaised(page, \"btn\", \"\", \"\", \"Add Ma";
_btn.InitializeRaised(_page,"btn","","","Add Marker","bluegrey");
 //BA.debugLineNum = 153;BA.debugLine="page.Cell(3,1).AddComponent(btn)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn));
 //BA.debugLineNum = 155;BA.debugLine="Dim btn2 As ABMButton";
_btn2 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 156;BA.debugLine="btn2.InitializeRaised(page, \"btn2\", \"\", \"\", \"Remo";
_btn2.InitializeRaised(_page,"btn2","","","Remove Markers","bluegrey");
 //BA.debugLineNum = 157;BA.debugLine="page.Cell(3,1).AddComponent(btn2)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn2));
 //BA.debugLineNum = 159;BA.debugLine="Dim btn3 As ABMButton";
_btn3 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 160;BA.debugLine="btn3.InitializeRaised(page, \"btn3\", \"\", \"\", \"Get";
_btn3.InitializeRaised(_page,"btn3","","","Get location","bluegrey");
 //BA.debugLineNum = 161;BA.debugLine="page.Cell(4,1).AddComponent(btn3)";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn3));
 //BA.debugLineNum = 163;BA.debugLine="Dim btn4 As ABMButton";
_btn4 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 164;BA.debugLine="btn4.InitializeRaised(page, \"btn4\", \"\", \"\", \"Fit";
_btn4.InitializeRaised(_page,"btn4","","","Fit zoom all markers","bluegrey");
 //BA.debugLineNum = 165;BA.debugLine="page.Cell(4,1).AddComponent(btn4)";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn4));
 //BA.debugLineNum = 168;BA.debugLine="Dim inp1 As ABMInput";
_inp1 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 169;BA.debugLine="inp1.Initialize(page, \"inp1\", ABM.INPUT_TEXT, \"Ad";
_inp1.Initialize(_page,"inp1",_abm.INPUT_TEXT,"Address",__c.False,"");
 //BA.debugLineNum = 170;BA.debugLine="page.Cell(5,1).AddComponent(inp1)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp1));
 //BA.debugLineNum = 172;BA.debugLine="Dim btn5 As ABMButton";
_btn5 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 173;BA.debugLine="btn5.InitializeRaised(page, \"btn5\", \"\", \"\", \"Get";
_btn5.InitializeRaised(_page,"btn5","","","Get Geocode","bluegrey");
 //BA.debugLineNum = 174;BA.debugLine="page.Cell(5,1).AddComponent(btn5)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn5));
 //BA.debugLineNum = 176;BA.debugLine="Dim btn12 As ABMButton";
_btn12 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 177;BA.debugLine="btn12.InitializeRaised(page, \"btn12\", \"\", \"\", \"Re";
_btn12.InitializeRaised(_page,"btn12","","","Reverse Geocode","bluegrey");
 //BA.debugLineNum = 178;BA.debugLine="page.Cell(5,1).AddComponent(btn12)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn12));
 //BA.debugLineNum = 180;BA.debugLine="Dim btn6 As ABMButton";
_btn6 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 181;BA.debugLine="btn6.InitializeRaised(page, \"btn6\", \"\", \"\", \"Buil";
_btn6.InitializeRaised(_page,"btn6","","","Build PolyLine","bluegrey");
 //BA.debugLineNum = 182;BA.debugLine="page.Cell(6,1).AddComponent(btn6)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn6));
 //BA.debugLineNum = 184;BA.debugLine="Dim btn7 As ABMButton";
_btn7 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 185;BA.debugLine="btn7.InitializeRaised(page, \"btn7\", \"\", \"\", \"Remo";
_btn7.InitializeRaised(_page,"btn7","","","Remove Polylines","bluegrey");
 //BA.debugLineNum = 186;BA.debugLine="page.Cell(6,1).AddComponent(btn7)";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn7));
 //BA.debugLineNum = 188;BA.debugLine="Dim btn8 As ABMButton";
_btn8 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 189;BA.debugLine="btn8.InitializeRaised(page, \"btn8\", \"\", \"\", \"Buil";
_btn8.InitializeRaised(_page,"btn8","","","Build Polygon","bluegrey");
 //BA.debugLineNum = 190;BA.debugLine="page.Cell(7,1).AddComponent(btn8)";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn8));
 //BA.debugLineNum = 192;BA.debugLine="Dim btn9 As ABMButton";
_btn9 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 193;BA.debugLine="btn9.InitializeRaised(page, \"btn9\", \"\", \"\", \"Remo";
_btn9.InitializeRaised(_page,"btn9","","","Remove Polygons","bluegrey");
 //BA.debugLineNum = 194;BA.debugLine="page.Cell(7,1).AddComponent(btn9)";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn9));
 //BA.debugLineNum = 196;BA.debugLine="Dim btn10 As ABMButton";
_btn10 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 197;BA.debugLine="btn10.InitializeRaised(page, \"btn10\", \"\", \"\", \"Ad";
_btn10.InitializeRaised(_page,"btn10","","","Add Route","bluegrey");
 //BA.debugLineNum = 198;BA.debugLine="page.Cell(8,1).AddComponent(btn10)";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn10));
 //BA.debugLineNum = 200;BA.debugLine="Dim btn11 As ABMButton";
_btn11 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 201;BA.debugLine="btn11.InitializeRaised(page, \"btn11\", \"\", \"\", \"Re";
_btn11.InitializeRaised(_page,"btn11","","","Remove routes","bluegrey");
 //BA.debugLineNum = 202;BA.debugLine="page.Cell(8,1).AddComponent(btn11)";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn11));
 //BA.debugLineNum = 205;BA.debugLine="Dim code As StringBuilder";
_code = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 206;BA.debugLine="code.Initialize";
_code.Initialize();
 //BA.debugLineNum = 207;BA.debugLine="code.Append(\"// create the google map\").Append(CR";
_code.Append("// create the google map").Append(__c.CRLF);
 //BA.debugLineNum = 208;BA.debugLine="code.Append(\"Dim gm1 As ABMGoogleMap\").Append(CRL";
_code.Append("Dim gm1 As ABMGoogleMap").Append(__c.CRLF);
 //BA.debugLineNum = 209;BA.debugLine="code.Append(\"gm1.Initialize(page, \"\"gm1\"\", 50.850";
_code.Append("gm1.Initialize(page, \"gm1\", 50.8500, 2.8833, 15, 350, ABM.GOOGLEMAPTYPE_ROADMAP)").Append(__c.CRLF);
 //BA.debugLineNum = 210;BA.debugLine="code.Append(\"gm1.Draggable = True\").Append(CRLF)";
_code.Append("gm1.Draggable = True").Append(__c.CRLF);
 //BA.debugLineNum = 211;BA.debugLine="code.Append(\"gm1.HasMapTypeControl = True\").Appen";
_code.Append("gm1.HasMapTypeControl = True").Append(__c.CRLF);
 //BA.debugLineNum = 212;BA.debugLine="code.Append(\"gm1.HasStreetViewControl = True\").Ap";
_code.Append("gm1.HasStreetViewControl = True").Append(__c.CRLF);
 //BA.debugLineNum = 213;BA.debugLine="code.Append(\"gm1.HasZoomControl = True\").Append(C";
_code.Append("gm1.HasZoomControl = True").Append(__c.CRLF);
 //BA.debugLineNum = 214;BA.debugLine="code.Append(\"gm1.AddMapType(ABM.GOOGLEMAPTYPE_ROA";
_code.Append("gm1.AddMapType(ABM.GOOGLEMAPTYPE_ROADMAP)").Append(__c.CRLF);
 //BA.debugLineNum = 215;BA.debugLine="code.Append(\"gm1.AddMapType(ABM.GOOGLEMAPTYPE_TER";
_code.Append("gm1.AddMapType(ABM.GOOGLEMAPTYPE_TERRAIN)").Append(__c.CRLF);
 //BA.debugLineNum = 216;BA.debugLine="code.Append(\"gm1.AddMapType(ABM.GOOGLEMAPTYPE_HYB";
_code.Append("gm1.AddMapType(ABM.GOOGLEMAPTYPE_HYBRID)").Append(__c.CRLF);
 //BA.debugLineNum = 217;BA.debugLine="code.Append(\"gm1.AddMapType(ABM.GOOGLEMAPTYPE_SAT";
_code.Append("gm1.AddMapType(ABM.GOOGLEMAPTYPE_SATELLITE)").Append(__c.CRLF);
 //BA.debugLineNum = 218;BA.debugLine="code.Append(\"\").Append(CRLF)";
_code.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 219;BA.debugLine="code.Append(\"page.Cell(2,1).AddComponent(gm1)\").A";
_code.Append("page.Cell(2,1).AddComponent(gm1)").Append(__c.CRLF);
 //BA.debugLineNum = 221;BA.debugLine="page.Cell(9,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code",_code)));
 //BA.debugLineNum = 224;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","You can also create a 'panorama' view.")));
 //BA.debugLineNum = 227;BA.debugLine="Dim gm2 As ABMGoogleMap";
_gm2 = new com.ab.abmaterial.ABMGoogleMap();
 //BA.debugLineNum = 228;BA.debugLine="gm2.InitializeAsPanorama(page, \"gm2\", 50.8500, 2.";
_gm2.InitializeAsPanorama(_page,"gm2",50.8500,2.8833,(int) (1),(int) (300),(int) (45),(int) (0));
 //BA.debugLineNum = 229;BA.debugLine="page.Cell(11,1).AddComponent(gm2)";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_gm2));
 //BA.debugLineNum = 232;BA.debugLine="Dim code2 As StringBuilder";
_code2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 233;BA.debugLine="code2.Initialize";
_code2.Initialize();
 //BA.debugLineNum = 234;BA.debugLine="code2.Append(\"// create the panorama\").Append(CRL";
_code2.Append("// create the panorama").Append(__c.CRLF);
 //BA.debugLineNum = 235;BA.debugLine="code2.Append(\"Dim gm2 As ABMGoogleMap\").Append(CR";
_code2.Append("Dim gm2 As ABMGoogleMap").Append(__c.CRLF);
 //BA.debugLineNum = 236;BA.debugLine="code2.Append(\"gm2.InitializeAsPanorama(page, \"\"gm";
_code2.Append("gm2.InitializeAsPanorama(page, \"gm2\", 50.8500, 2.8833, 1, 300, 45, 0)").Append(__c.CRLF);
 //BA.debugLineNum = 237;BA.debugLine="code2.Append(\"\").Append(CRLF)";
_code2.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 238;BA.debugLine="code2.Append(\"page.Cell(11,1).AddComponent(gm2)\")";
_code2.Append("page.Cell(11,1).AddComponent(gm2)").Append(__c.CRLF);
 //BA.debugLineNum = 240;BA.debugLine="page.Cell(12,1).AddComponent(ABMShared.BuildCodeB";
_page.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code2",_code2)));
 //BA.debugLineNum = 243;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 245;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 248;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 250;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 251;BA.debugLine="End Sub";
return "";
}
public String  _gm1_clicked(double _latitude,double _longitude) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 354;BA.debugLine="Sub gm1_Clicked(Latitude As Double, Longitude As D";
 //BA.debugLineNum = 355;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 356;BA.debugLine="counter = counter + 1";
_counter = (int) (_counter+1);
 //BA.debugLineNum = 358;BA.debugLine="Markers.Add(Latitude)";
_markers.Add((Object)(_latitude));
 //BA.debugLineNum = 359;BA.debugLine="Markers.Add(Longitude)";
_markers.Add((Object)(_longitude));
 //BA.debugLineNum = 360;BA.debugLine="gm1.AddMarker(\"newmarker\" & counter, Latitude, Lo";
_gm1.AddMarker("newmarker"+BA.NumberToString(_counter),_latitude,_longitude,_abm.COLOR_BLUE,"New","");
 //BA.debugLineNum = 361;BA.debugLine="gm1.refresh ' IMPORTANT";
_gm1.Refresh();
 //BA.debugLineNum = 362;BA.debugLine="End Sub";
return "";
}
public String  _gm1_currentlocation(double _latitude,double _longitude) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 364;BA.debugLine="Sub gm1_CurrentLocation(Latitude As Double, Longit";
 //BA.debugLineNum = 365;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 366;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Got current location!",(int) (5000));
 //BA.debugLineNum = 367;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 368;BA.debugLine="gm1.SetLocation(Latitude, Longitude)";
_gm1.SetLocation(_latitude,_longitude);
 //BA.debugLineNum = 369;BA.debugLine="gm1.Refresh ' IMPORTANT";
_gm1.Refresh();
 //BA.debugLineNum = 370;BA.debugLine="End Sub";
return "";
}
public String  _gm1_error(String _errormessage) throws Exception{
 //BA.debugLineNum = 380;BA.debugLine="Sub gm1_Error(ErrorMessage As String)";
 //BA.debugLineNum = 381;BA.debugLine="If ErrorMessage <> \"\" Then";
if ((_errormessage).equals("") == false) { 
 //BA.debugLineNum = 382;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 383;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred",_errormessage,(int) (5000));
 };
 //BA.debugLineNum = 385;BA.debugLine="End Sub";
return "";
}
public String  _gm1_geocoderesult(double _latitude,double _longitude) throws Exception{
com.ab.abmaterial.ABMGoogleMap _gm1 = null;
 //BA.debugLineNum = 372;BA.debugLine="Sub gm1_GeoCodeResult(Latitude As Double, Longitud";
 //BA.debugLineNum = 373;BA.debugLine="Dim gm1 As ABMGoogleMap = page.Component(\"gm1\")";
_gm1 = (com.ab.abmaterial.ABMGoogleMap)(_page.Component("gm1"));
 //BA.debugLineNum = 374;BA.debugLine="counter = counter + 1";
_counter = (int) (_counter+1);
 //BA.debugLineNum = 375;BA.debugLine="gm1.AddMarker(\"newmarker\" & counter, Latitude, Lo";
_gm1.AddMarker("newmarker"+BA.NumberToString(_counter),_latitude,_longitude,_abm.COLOR_GREEN,"New","");
 //BA.debugLineNum = 376;BA.debugLine="gm1.SetLocation(Latitude, Longitude)";
_gm1.SetLocation(_latitude,_longitude);
 //BA.debugLineNum = 377;BA.debugLine="gm1.refresh ' IMPORTANT";
_gm1.Refresh();
 //BA.debugLineNum = 378;BA.debugLine="End Sub";
return "";
}
public String  _gm1_markerclicked(String _markerid) throws Exception{
 //BA.debugLineNum = 387;BA.debugLine="Sub gm1_MarkerClicked(MarkerId As String)";
 //BA.debugLineNum = 388;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 389;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", \"";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Clicked on marker "+_markerid,(int) (5000));
 //BA.debugLineNum = 390;BA.debugLine="End Sub";
return "";
}
public String  _gm1_ready() throws Exception{
 //BA.debugLineNum = 350;BA.debugLine="Sub gm1_Ready()";
 //BA.debugLineNum = 351;BA.debugLine="Log(\"Google map loaded!\")";
__c.Log("Google map loaded!");
 //BA.debugLineNum = 352;BA.debugLine="End Sub";
return "";
}
public String  _gm1_reversegeocoderesult(String _address) throws Exception{
 //BA.debugLineNum = 392;BA.debugLine="Sub gm1_ReverseGeoCodeResult(Address As String)";
 //BA.debugLineNum = 393;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 394;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\", A";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred",_address,(int) (5000));
 //BA.debugLineNum = 395;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 22;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 24;BA.debugLine="BuildPage";
_buildpage();
 //BA.debugLineNum = 25;BA.debugLine="Markers.Initialize";
_markers.Initialize();
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 254;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 255;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 256;BA.debugLine="If Action = \"ABMGoogleMap\" Then Return";
if ((_action).equals("ABMGoogleMap")) { 
if (true) return "";};
 //BA.debugLineNum = 257;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 258;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 259;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 260;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 262;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 263;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 264;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 266;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 267;BA.debugLine="End Sub";
return "";
}
public String  _page_parseevent(anywheresoftware.b4a.objects.collections.Map _params) throws Exception{
String _eventname = "";
String[] _eventparams = null;
anywheresoftware.b4a.objects.collections.List _passedtables = null;
 //BA.debugLineNum = 60;BA.debugLine="Sub Page_ParseEvent(Params As Map)";
 //BA.debugLineNum = 61;BA.debugLine="Dim eventName As String = Params.Get(\"eventname\")";
_eventname = BA.ObjectToString(_params.Get((Object)("eventname")));
 //BA.debugLineNum = 62;BA.debugLine="Dim eventParams() As String = Regex.Split(\",\",Par";
_eventparams = __c.Regex.Split(",",BA.ObjectToString(_params.Get((Object)("eventparams"))));
 //BA.debugLineNum = 63;BA.debugLine="If eventName = \"beforeunload\" Then";
if ((_eventname).equals("beforeunload")) { 
 //BA.debugLineNum = 64;BA.debugLine="Log(\"preparing for url refresh\")";
__c.Log("preparing for url refresh");
 //BA.debugLineNum = 65;BA.debugLine="ABM.RemoveMeFromCache(ABMShared.CachedPages, ABM";
_abm.RemoveMeFromCache(_abmshared._cachedpages,_abmpageid);
 //BA.debugLineNum = 66;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 68;BA.debugLine="If SubExists(Me, eventName) Then";
if (__c.SubExists(ba,this,_eventname)) { 
 //BA.debugLineNum = 69;BA.debugLine="Params.Remove(\"eventname\")";
_params.Remove((Object)("eventname"));
 //BA.debugLineNum = 70;BA.debugLine="Params.Remove(\"eventparams\")";
_params.Remove((Object)("eventparams"));
 //BA.debugLineNum = 71;BA.debugLine="Select Case Params.Size";
switch (BA.switchObjectToInt(_params.getSize(),(int) (0),(int) (1),(int) (2))) {
case 0: {
 //BA.debugLineNum = 73;BA.debugLine="CallSub(Me, eventName)";
__c.CallSubNew(ba,this,_eventname);
 break; }
case 1: {
 //BA.debugLineNum = 75;BA.debugLine="CallSub2(Me, eventName, Params.Get(eventParams";
__c.CallSubNew2(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])));
 break; }
case 2: {
 //BA.debugLineNum = 77;BA.debugLine="If Params.get(eventParams(0)) = \"abmistable\" T";
if ((_params.Get((Object)(_eventparams[(int) (0)]))).equals((Object)("abmistable"))) { 
 //BA.debugLineNum = 78;BA.debugLine="Dim PassedTables As List = ABM.ProcessTablesF";
_passedtables = new anywheresoftware.b4a.objects.collections.List();
_passedtables = _abm.ProcessTablesFromTargetName(BA.ObjectToString(_params.Get((Object)(_eventparams[(int) (1)]))));
 //BA.debugLineNum = 79;BA.debugLine="CallSub2(Me, eventName, PassedTables)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_passedtables));
 }else {
 //BA.debugLineNum = 81;BA.debugLine="CallSub3(Me, eventName, Params.Get(eventParam";
__c.CallSubNew3(ba,this,_eventname,_params.Get((Object)(_eventparams[(int) (0)])),_params.Get((Object)(_eventparams[(int) (1)])));
 };
 break; }
default: {
 //BA.debugLineNum = 85;BA.debugLine="CallSub2(Me, eventName, Params)";
__c.CallSubNew2(ba,this,_eventname,(Object)(_params));
 break; }
}
;
 };
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public String  _page_signedoffsocialnetwork(String _network,String _extra) throws Exception{
 //BA.debugLineNum = 269;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 270;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 271;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 272;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 273;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 274;BA.debugLine="End Sub";
return "";
}
public String  _websocket_connected(anywheresoftware.b4j.object.WebSocket _websocket1) throws Exception{
anywheresoftware.b4j.object.HttpSessionWrapper _session = null;
 //BA.debugLineNum = 28;BA.debugLine="Private Sub WebSocket_Connected (WebSocket1 As Web";
 //BA.debugLineNum = 29;BA.debugLine="Log(\"Connected\")";
__c.Log("Connected");
 //BA.debugLineNum = 30;BA.debugLine="ws = WebSocket1";
_ws = _websocket1;
 //BA.debugLineNum = 31;BA.debugLine="ABMPageId = ABM.GetPageID(page, Name,ws)";
_abmpageid = _abm.GetPageID(_page,_name,_ws);
 //BA.debugLineNum = 32;BA.debugLine="Dim session As HttpSession = ABM.GetSession(ws, A";
_session = new anywheresoftware.b4j.object.HttpSessionWrapper();
_session = _abm.GetSession(_ws,_abmshared._sessionmaxinactiveintervalseconds);
 //BA.debugLineNum = 34;BA.debugLine="If ABMShared.NeedsAuthorization Then";
if (_abmshared._needsauthorization) { 
 //BA.debugLineNum = 35;BA.debugLine="If session.GetAttribute2(\"IsAuthorized\", \"\") = \"";
if ((_session.GetAttribute2("IsAuthorized",(Object)(""))).equals((Object)(""))) { 
 //BA.debugLineNum = 36;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 37;BA.debugLine="Return";
if (true) return "";
 };
 };
 //BA.debugLineNum = 41;BA.debugLine="ABM.UpdateFromCache(Me, ABMShared.CachedPages, AB";
_abm.UpdateFromCache((anywheresoftware.b4a.B4AClass)(this),_abmshared._cachedpages,_abmpageid,_ws,ba);
 //BA.debugLineNum = 42;BA.debugLine="If page.ComesFromPageCache Then";
if (_page.ComesFromPageCache) { 
 //BA.debugLineNum = 44;BA.debugLine="page.Refresh";
_page.Refresh();
 //BA.debugLineNum = 46;BA.debugLine="page.FinishedLoading";
_page.FinishedLoading();
 }else {
 //BA.debugLineNum = 49;BA.debugLine="page.Prepare";
_page.Prepare();
 //BA.debugLineNum = 51;BA.debugLine="ConnectPage";
_connectpage();
 };
 //BA.debugLineNum = 53;BA.debugLine="Log(ABMPageId)";
__c.Log(_abmpageid);
 //BA.debugLineNum = 54;BA.debugLine="End Sub";
return "";
}
public String  _websocket_disconnected() throws Exception{
 //BA.debugLineNum = 56;BA.debugLine="Private Sub WebSocket_Disconnected";
 //BA.debugLineNum = 57;BA.debugLine="Log(\"Disconnected\")";
__c.Log("Disconnected");
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
