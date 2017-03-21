package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compbuttonpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compbuttonpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compbuttonpage.class).invoke(this, new Object[] {null});
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
anywheresoftware.b4a.objects.collections.List _mytexts = null;
anywheresoftware.b4a.objects.collections.List _myreturns = null;
 //BA.debugLineNum = 323;BA.debugLine="Sub btn1_Clicked(Target As String)";
 //BA.debugLineNum = 324;BA.debugLine="Dim myTexts, myReturns As List";
_mytexts = new anywheresoftware.b4a.objects.collections.List();
_myreturns = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 325;BA.debugLine="myTexts.Initialize";
_mytexts.Initialize();
 //BA.debugLineNum = 326;BA.debugLine="myTexts.Add(\"READ IT\")";
_mytexts.Add((Object)("READ IT"));
 //BA.debugLineNum = 327;BA.debugLine="myReturns.Initialize";
_myreturns.Initialize();
 //BA.debugLineNum = 328;BA.debugLine="myReturns.Add(\"READIT\")";
_myreturns.Add((Object)("READIT"));
 //BA.debugLineNum = 329;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 330;BA.debugLine="page.ShowToastWithReturns(\"toast\" & myToastId, \"t";
_page.ShowToastWithReturns("toast"+BA.NumberToString(_mytoastid),"toast","First raised button! ("+BA.NumberToString(_mytoastid)+")",(int) (5000),_mytexts,_myreturns);
 //BA.debugLineNum = 331;BA.debugLine="End Sub";
return "";
}
public String  _btn2_clicked(String _target) throws Exception{
anywheresoftware.b4a.objects.collections.List _mytexts = null;
anywheresoftware.b4a.objects.collections.List _myreturns = null;
 //BA.debugLineNum = 333;BA.debugLine="Sub btn2_Clicked(Target As String)";
 //BA.debugLineNum = 334;BA.debugLine="Dim myTexts, myReturns As List";
_mytexts = new anywheresoftware.b4a.objects.collections.List();
_myreturns = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 335;BA.debugLine="myTexts.Initialize";
_mytexts.Initialize();
 //BA.debugLineNum = 336;BA.debugLine="myTexts.Add(\"READ IT\")";
_mytexts.Add((Object)("READ IT"));
 //BA.debugLineNum = 337;BA.debugLine="myReturns.Initialize";
_myreturns.Initialize();
 //BA.debugLineNum = 338;BA.debugLine="myReturns.Add(\"READIT\")";
_myreturns.Add((Object)("READIT"));
 //BA.debugLineNum = 339;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 340;BA.debugLine="page.ShowToastWithReturns(\"toast\" & myToastId, \"t";
_page.ShowToastWithReturns("toast"+BA.NumberToString(_mytoastid),"toastred","Second raised button! ("+BA.NumberToString(_mytoastid)+")",(int) (5000),_mytexts,_myreturns);
 //BA.debugLineNum = 341;BA.debugLine="End Sub";
return "";
}
public String  _btn3_clicked(String _target) throws Exception{
anywheresoftware.b4a.objects.collections.List _mytexts = null;
anywheresoftware.b4a.objects.collections.List _myreturns = null;
 //BA.debugLineNum = 343;BA.debugLine="Sub btn3_Clicked(Target As String)";
 //BA.debugLineNum = 344;BA.debugLine="Dim myTexts, myReturns As List";
_mytexts = new anywheresoftware.b4a.objects.collections.List();
_myreturns = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 345;BA.debugLine="myTexts.Initialize";
_mytexts.Initialize();
 //BA.debugLineNum = 346;BA.debugLine="myTexts.Add(\"READ IT\")";
_mytexts.Add((Object)("READ IT"));
 //BA.debugLineNum = 347;BA.debugLine="myReturns.Initialize";
_myreturns.Initialize();
 //BA.debugLineNum = 348;BA.debugLine="myReturns.Add(\"READIT\")";
_myreturns.Add((Object)("READIT"));
 //BA.debugLineNum = 349;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 350;BA.debugLine="page.ShowToastWithReturns(\"toast\" & myToastId, \"t";
_page.ShowToastWithReturns("toast"+BA.NumberToString(_mytoastid),"toast","Third raised button! ("+BA.NumberToString(_mytoastid)+")",(int) (5000),_mytexts,_myreturns);
 //BA.debugLineNum = 351;BA.debugLine="End Sub";
return "";
}
public String  _btn4_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMLabel _mymodallbl = null;
 //BA.debugLineNum = 362;BA.debugLine="Sub btn4_Clicked(Target As String)";
 //BA.debugLineNum = 363;BA.debugLine="Dim mymodal As ABMModalSheet = page.ModalSheet(\"m";
_mymodal = _page.ModalSheet("myModal");
 //BA.debugLineNum = 364;BA.debugLine="Dim myModalLbl As ABMLabel= mymodal.Content.Compo";
_mymodallbl = (com.ab.abmaterial.ABMLabel)(_mymodal.Content.Component("contlbl1"));
 //BA.debugLineNum = 365;BA.debugLine="myModalLbl.Text = \"You clicked on the floating bu";
_mymodallbl.Text = "You clicked on the floating button!";
 //BA.debugLineNum = 366;BA.debugLine="page.ShowModalSheet(\"myModal\")";
_page.ShowModalSheet("myModal");
 //BA.debugLineNum = 367;BA.debugLine="End Sub";
return "";
}
public String  _btn5_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMLabel _mymodallbl = null;
 //BA.debugLineNum = 369;BA.debugLine="Sub btn5_Clicked(Target As String)";
 //BA.debugLineNum = 370;BA.debugLine="Dim mymodal As ABMModalSheet = page.ModalSheet(\"m";
_mymodal = _page.ModalSheet("myModal");
 //BA.debugLineNum = 371;BA.debugLine="Dim myModalLbl As ABMLabel= mymodal.Content.Compo";
_mymodallbl = (com.ab.abmaterial.ABMLabel)(_mymodal.Content.Component("contlbl1"));
 //BA.debugLineNum = 372;BA.debugLine="myModalLbl.Text = \"You clicked on the flat button";
_mymodallbl.Text = "You clicked on the flat button!";
 //BA.debugLineNum = 373;BA.debugLine="page.ShowModalSheet(\"myModal\")";
_page.ShowModalSheet("myModal");
 //BA.debugLineNum = 374;BA.debugLine="End Sub";
return "";
}
public String  _btn6_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMLabel _mymodallbl = null;
 //BA.debugLineNum = 376;BA.debugLine="Sub btn6_Clicked(Target As String)";
 //BA.debugLineNum = 377;BA.debugLine="Dim mymodal As ABMModalSheet = page.ModalSheet(\"m";
_mymodal = _page.ModalSheet("myModal");
 //BA.debugLineNum = 378;BA.debugLine="Dim myModalLbl As ABMLabel= mymodal.Content.Compo";
_mymodallbl = (com.ab.abmaterial.ABMLabel)(_mymodal.Content.Component("contlbl1"));
 //BA.debugLineNum = 379;BA.debugLine="myModalLbl.Text = \"You clicked on the small raise";
_mymodallbl.Text = "You clicked on the small raised button!";
 //BA.debugLineNum = 380;BA.debugLine="page.ShowModalSheet(\"myModal\")";
_page.ShowModalSheet("myModal");
 //BA.debugLineNum = 381;BA.debugLine="End Sub";
return "";
}
public String  _btn6b_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMLabel _mymodallbl = null;
 //BA.debugLineNum = 383;BA.debugLine="Sub btn6b_Clicked(Target As String)";
 //BA.debugLineNum = 384;BA.debugLine="Dim mymodal As ABMModalSheet = page.ModalSheet(\"m";
_mymodal = _page.ModalSheet("myModal");
 //BA.debugLineNum = 385;BA.debugLine="Dim myModalLbl As ABMLabel= mymodal.Content.Compo";
_mymodallbl = (com.ab.abmaterial.ABMLabel)(_mymodal.Content.Component("contlbl1"));
 //BA.debugLineNum = 386;BA.debugLine="myModalLbl.Text = \"You clicked on the normal size";
_mymodallbl.Text = "You clicked on the normal sized raised button!";
 //BA.debugLineNum = 387;BA.debugLine="page.ShowModalSheet(\"myModal\")";
_page.ShowModalSheet("myModal");
 //BA.debugLineNum = 388;BA.debugLine="End Sub";
return "";
}
public String  _btn6c_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMLabel _mymodallbl = null;
 //BA.debugLineNum = 390;BA.debugLine="Sub btn6c_Clicked(Target As String)";
 //BA.debugLineNum = 391;BA.debugLine="Dim mymodal As ABMModalSheet = page.ModalSheet(\"m";
_mymodal = _page.ModalSheet("myModal");
 //BA.debugLineNum = 392;BA.debugLine="Dim myModalLbl As ABMLabel= mymodal.Content.Compo";
_mymodallbl = (com.ab.abmaterial.ABMLabel)(_mymodal.Content.Component("contlbl1"));
 //BA.debugLineNum = 393;BA.debugLine="myModalLbl.Text = \"You clicked on the large raise";
_mymodallbl.Text = "You clicked on the large raised button!";
 //BA.debugLineNum = 394;BA.debugLine="page.ShowModalSheet(\"myModal\")";
_page.ShowModalSheet("myModal");
 //BA.debugLineNum = 395;BA.debugLine="End Sub";
return "";
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 123;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 125;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 128;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 129;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 130;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 131;BA.debugLine="page.PageTitle = \"ABMButton\"";
_page.PageTitle = "ABMButton";
 //BA.debugLineNum = 132;BA.debugLine="page.PageDescription = \"The button component \"";
_page.PageDescription = "The button component ";
 //BA.debugLineNum = 133;BA.debugLine="page.PageHTMLName = \"abmaterial-button.html\"";
_page.PageHTMLName = "abmaterial-button.html";
 //BA.debugLineNum = 134;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 135;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 136;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 137;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 139;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMButton\",\".";
_abmshared._buildnavigationbar(_page,"ABMButton","../images/logo.png","","Controls","ABMButton");
 //BA.debugLineNum = 142;BA.debugLine="page.AddRows(1,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 143;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(1,0,0,0,12,9,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (1),(int) (0),(int) (0),(int) (0),(int) (12),(int) (9),(int) (10),"");
 //BA.debugLineNum = 144;BA.debugLine="page.AddRows(13,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (13),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 145;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 150;BA.debugLine="page.AddFXToast(\"hdr1\", 0,\"passingtoast\", \"toastg";
_page.AddFXToast("hdr1",(int) (0),"passingtoast","toastgreen","You're scrolling!",(int) (5000));
 //BA.debugLineNum = 152;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 95;BA.debugLine="theme.AddToastTheme(\"toastgreen\")";
_theme.AddToastTheme("toastgreen");
 //BA.debugLineNum = 96;BA.debugLine="theme.Toast(\"toastgreen\").BackColor = ABM.COLOR_G";
_theme.Toast("toastgreen").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 97;BA.debugLine="theme.Toast(\"toastgreen\").BackColorIntensity = AB";
_theme.Toast("toastgreen").BackColorIntensity = _abm.INTENSITY_DARKEN2;
 //BA.debugLineNum = 100;BA.debugLine="theme.AddButtonTheme(\"bluegrey\")";
_theme.AddButtonTheme("bluegrey");
 //BA.debugLineNum = 101;BA.debugLine="theme.Button(\"bluegrey\").BackColor = ABM.COLOR_BL";
_theme.Button("bluegrey").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 102;BA.debugLine="theme.Button(\"bluegrey\").BackColorIntensity = ABM";
_theme.Button("bluegrey").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 105;BA.debugLine="theme.AddButtonTheme(\"darkred\")";
_theme.AddButtonTheme("darkred");
 //BA.debugLineNum = 106;BA.debugLine="theme.Button(\"darkred\").BackColor = ABM.COLOR_RED";
_theme.Button("darkred").BackColor = _abm.COLOR_RED;
 //BA.debugLineNum = 107;BA.debugLine="theme.Button(\"darkred\").BackColorIntensity = ABM.";
_theme.Button("darkred").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 110;BA.debugLine="theme.AddButtonTheme(\"transparent\")";
_theme.AddButtonTheme("transparent");
 //BA.debugLineNum = 111;BA.debugLine="theme.Button(\"transparent\").BackColor = ABM.COLOR";
_theme.Button("transparent").BackColor = _abm.COLOR_TRANSPARENT;
 //BA.debugLineNum = 114;BA.debugLine="theme.AddButtonTheme(\"darkgreen\")";
_theme.AddButtonTheme("darkgreen");
 //BA.debugLineNum = 115;BA.debugLine="theme.Button(\"darkgreen\").BackColor = ABM.COLOR_G";
_theme.Button("darkgreen").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 116;BA.debugLine="theme.Button(\"darkgreen\").BackColorIntensity = AB";
_theme.Button("darkgreen").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 119;BA.debugLine="theme.AddContainerTheme(\"modalcontent\")";
_theme.AddContainerTheme("modalcontent");
 //BA.debugLineNum = 120;BA.debugLine="theme.Container(\"modalcontent\").BackColor = ABM.C";
_theme.Container("modalcontent").BackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 121;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompButtonPage\"";
_name = "CompButtonPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public com.ab.abmaterial.ABMModalSheet  _connectmodal() throws Exception{
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMLabel _lbl1 = null;
 //BA.debugLineNum = 294;BA.debugLine="Sub ConnectModal()  As ABMModalSheet";
 //BA.debugLineNum = 295;BA.debugLine="Dim myModal As ABMModalSheet";
_mymodal = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 296;BA.debugLine="myModal.Initialize(page, \"myModal\", False, False,";
_mymodal.Initialize(_page,"myModal",__c.False,BA.ObjectToString(__c.False),"");
 //BA.debugLineNum = 297;BA.debugLine="myModal.Content.UseTheme(\"modalcontent\")";
_mymodal.Content.UseTheme("modalcontent");
 //BA.debugLineNum = 298;BA.debugLine="myModal.Footer.UseTheme(\"modalcontent\")";
_mymodal.Footer.UseTheme("modalcontent");
 //BA.debugLineNum = 299;BA.debugLine="myModal.IsDismissible = True";
_mymodal.IsDismissible = __c.True;
 //BA.debugLineNum = 301;BA.debugLine="myModal.Content.AddRows(1, True, \"\").AddCells12(1";
_mymodal.Content.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 302;BA.debugLine="myModal.Content.BuildGrid 'IMPORTANT once you loa";
_mymodal.Content.BuildGrid();
 //BA.debugLineNum = 304;BA.debugLine="Dim lbl1 As ABMLabel";
_lbl1 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 305;BA.debugLine="lbl1.Initialize(page, \"contlbl1\", \"buttonmessages";
_lbl1.Initialize(_page,"contlbl1","buttonmessages",_abm.SIZE_PARAGRAPH,__c.False,"");
 //BA.debugLineNum = 306;BA.debugLine="myModal.Content.Cell(1,1).AddComponent(lbl1)";
_mymodal.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl1));
 //BA.debugLineNum = 308;BA.debugLine="Return myModal";
if (true) return _mymodal;
 //BA.debugLineNum = 309;BA.debugLine="End Sub";
return null;
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMButton _btn1 = null;
com.ab.abmaterial.ABMButton _btn2 = null;
com.ab.abmaterial.ABMButton _btn3 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code = null;
com.ab.abmaterial.ABMButton _btn4 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code2 = null;
com.ab.abmaterial.ABMButton _btn5 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code3 = null;
com.ab.abmaterial.ABMButton _btn6 = null;
com.ab.abmaterial.ABMButton _btn6b = null;
com.ab.abmaterial.ABMButton _btn6c = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code4 = null;
com.ab.abmaterial.ABMButton _btn7 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code5 = null;
 //BA.debugLineNum = 155;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 157;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 160;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","There are 3 main button types described in ABMaterial. The raised button is a standard button that signify actions and seek to give depth to a mostly flat page. The floating circular action button is meant for very important functions. Flat buttons are usually used within elements that already have depth like cards or modals.")));
 //BA.debugLineNum = 162;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Raised")));
 //BA.debugLineNum = 165;BA.debugLine="Dim btn1 As ABMButton";
_btn1 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 166;BA.debugLine="btn1.InitializeRaised(page, \"btn1\", \"picture_as_p";
_btn1.InitializeRaised(_page,"btn1","picture_as_pdf",_abm.ICONALIGN_LEFT,"BUTTON","bluegrey");
 //BA.debugLineNum = 167;BA.debugLine="page.Cell(2,1).AddComponent(btn1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn1));
 //BA.debugLineNum = 169;BA.debugLine="Dim btn2 As ABMButton";
_btn2 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 170;BA.debugLine="btn2.InitializeRaised(page, \"btn2\", \"fa fa-home\",";
_btn2.InitializeRaised(_page,"btn2","fa fa-home",_abm.ICONALIGN_LEFT,"BUTTON","bluegrey");
 //BA.debugLineNum = 171;BA.debugLine="page.Cell(2,1).AddComponent(btn2)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn2));
 //BA.debugLineNum = 173;BA.debugLine="Dim btn3 As ABMButton";
_btn3 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 174;BA.debugLine="btn3.InitializeRaised(page, \"btn3\", \"mdi-image-pa";
_btn3.InitializeRaised(_page,"btn3","mdi-image-palette",_abm.ICONALIGN_RIGHT,"BUTTON","bluegrey");
 //BA.debugLineNum = 175;BA.debugLine="page.Cell(2,1).AddComponent(btn3)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn3));
 //BA.debugLineNum = 178;BA.debugLine="Dim code As StringBuilder";
_code = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 179;BA.debugLine="code.Initialize";
_code.Initialize();
 //BA.debugLineNum = 180;BA.debugLine="code.Append(\"Dim btn1 As ABMButton\").Append(CRLF)";
_code.Append("Dim btn1 As ABMButton").Append(__c.CRLF);
 //BA.debugLineNum = 181;BA.debugLine="code.Append(\"btn1.InitializeRaised(page, \"\"btn1\"\"";
_code.Append("btn1.InitializeRaised(page, \"btn1\", \"\", \"\", \"BUTTON\", \"bluegrey\")").Append(__c.CRLF);
 //BA.debugLineNum = 182;BA.debugLine="code.Append(\"page.Cell(2,1).AddComponent(btn1)\").";
_code.Append("page.Cell(2,1).AddComponent(btn1)").Append(__c.CRLF);
 //BA.debugLineNum = 183;BA.debugLine="code.Append(\"\").Append(CRLF)";
_code.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 184;BA.debugLine="code.Append(\"Dim btn2 As ABMButton\").Append(CRLF)";
_code.Append("Dim btn2 As ABMButton").Append(__c.CRLF);
 //BA.debugLineNum = 185;BA.debugLine="code.Append(\"btn2.InitializeRaised(page, \"\"btn2\"\"";
_code.Append("btn2.InitializeRaised(page, \"btn2\", \"mdi-image-palette\", ABM.ICONALIGN_LEFT, \"BUTTON\", \"bluegrey\")").Append(__c.CRLF);
 //BA.debugLineNum = 186;BA.debugLine="code.Append(\"page.Cell(2,1).AddComponent(btn2)\").";
_code.Append("page.Cell(2,1).AddComponent(btn2)").Append(__c.CRLF);
 //BA.debugLineNum = 187;BA.debugLine="code.Append(\"\").Append(CRLF)";
_code.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 188;BA.debugLine="code.Append(\"Dim btn3 As ABMButton\").Append(CRLF)";
_code.Append("Dim btn3 As ABMButton").Append(__c.CRLF);
 //BA.debugLineNum = 189;BA.debugLine="code.Append(\"btn3.InitializeRaised(page, \"\"btn3\"\"";
_code.Append("btn3.InitializeRaised(page, \"btn3\", \"mdi-image-palette\", ABM.ICONALIGN_RIGHT, \"BUTTON\", \"bluegrey\")").Append(__c.CRLF);
 //BA.debugLineNum = 190;BA.debugLine="code.Append(\"page.Cell(2,1).AddComponent(btn3)\").";
_code.Append("page.Cell(2,1).AddComponent(btn3)").Append(__c.CRLF);
 //BA.debugLineNum = 192;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code1",_code)));
 //BA.debugLineNum = 195;BA.debugLine="page.Cell(4,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Floating")));
 //BA.debugLineNum = 197;BA.debugLine="Dim btn4 As ABMButton";
_btn4 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 198;BA.debugLine="btn4.Initializefloating(page, \"btn4\", \"mdi-image-";
_btn4.InitializeFloating(_page,"btn4","mdi-image-palette","darkred");
 //BA.debugLineNum = 199;BA.debugLine="btn4.size = ABM.BUTTONSIZE_LARGE";
_btn4.Size = _abm.BUTTONSIZE_LARGE;
 //BA.debugLineNum = 200;BA.debugLine="page.Cell(5,1).AddComponent(btn4)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn4));
 //BA.debugLineNum = 203;BA.debugLine="Dim code2 As StringBuilder";
_code2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 204;BA.debugLine="code2.Initialize";
_code2.Initialize();
 //BA.debugLineNum = 205;BA.debugLine="code2.Append(\"Dim btn4 As ABMButton\").Append(CRLF";
_code2.Append("Dim btn4 As ABMButton").Append(__c.CRLF);
 //BA.debugLineNum = 206;BA.debugLine="code2.Append(\"btn4.Initializefloating(page, \"\"btn";
_code2.Append("btn4.Initializefloating(page, \"btn4\", \"mdi-image-palette\", \"darkred\")").Append(__c.CRLF);
 //BA.debugLineNum = 207;BA.debugLine="code2.Append(\"btn4..size = ABM.BUTTONSIZE_LARGE\")";
_code2.Append("btn4..size = ABM.BUTTONSIZE_LARGE").Append(__c.CRLF);
 //BA.debugLineNum = 208;BA.debugLine="code2.Append(\"page.Cell(5,1).AddComponent(btn4)\")";
_code2.Append("page.Cell(5,1).AddComponent(btn4)").Append(__c.CRLF);
 //BA.debugLineNum = 210;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code2",_code2)));
 //BA.debugLineNum = 213;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildHeader";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Flat")));
 //BA.debugLineNum = 215;BA.debugLine="Dim btn5 As ABMButton";
_btn5 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 216;BA.debugLine="btn5.InitializeFlat(page, \"btn5\", \"\", \"\", \"FLAT B";
_btn5.InitializeFlat(_page,"btn5","","","FLAT BUTTON","transparent");
 //BA.debugLineNum = 217;BA.debugLine="page.Cell(8,1).AddComponent(btn5)";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn5));
 //BA.debugLineNum = 220;BA.debugLine="Dim code3 As StringBuilder";
_code3 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 221;BA.debugLine="code3.Initialize";
_code3.Initialize();
 //BA.debugLineNum = 222;BA.debugLine="code3.Append(\"Dim btn5 As ABMButton\").Append(CRLF";
_code3.Append("Dim btn5 As ABMButton").Append(__c.CRLF);
 //BA.debugLineNum = 223;BA.debugLine="code3.Append(\"btn5.InitializeFlat(page, \"\"btn5\"\",";
_code3.Append("btn5.InitializeFlat(page, \"btn5\", \"\", \"\", \"FLAT BUTTON\", \"transparent\")").Append(__c.CRLF);
 //BA.debugLineNum = 224;BA.debugLine="code3.Append(\"page.AddComponent(\"\"Rgrid8C1\"\", btn";
_code3.Append("page.AddComponent(\"Rgrid8C1\", btn5)").Append(__c.CRLF);
 //BA.debugLineNum = 226;BA.debugLine="page.Cell(9,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code3",_code3)));
 //BA.debugLineNum = 229;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildHeade";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Size")));
 //BA.debugLineNum = 231;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Buttons can vary in size if they need more/less attention.")));
 //BA.debugLineNum = 233;BA.debugLine="Dim btn6 As ABMButton";
_btn6 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 234;BA.debugLine="btn6.InitializeRaised(page, \"btn6\", \"mdi-image-pa";
_btn6.InitializeRaised(_page,"btn6","mdi-image-palette",_abm.ICONALIGN_RIGHT,"BUTTON","darkgreen");
 //BA.debugLineNum = 235;BA.debugLine="btn6.size = ABM.BUTTONSIZE_SMALL";
_btn6.Size = _abm.BUTTONSIZE_SMALL;
 //BA.debugLineNum = 236;BA.debugLine="page.Cell(11,1).AddComponent(btn6)";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn6));
 //BA.debugLineNum = 238;BA.debugLine="Dim btn6b As ABMButton";
_btn6b = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 239;BA.debugLine="btn6b.InitializeRaised(page, \"btn6b\", \"mdi-image-";
_btn6b.InitializeRaised(_page,"btn6b","mdi-image-palette",_abm.ICONALIGN_RIGHT,"BUTTON","darkgreen");
 //BA.debugLineNum = 240;BA.debugLine="btn6b.size = ABM.BUTTONSIZE_NORMAL";
_btn6b.Size = _abm.BUTTONSIZE_NORMAL;
 //BA.debugLineNum = 241;BA.debugLine="page.Cell(11,1).AddComponent(btn6b)";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn6b));
 //BA.debugLineNum = 243;BA.debugLine="Dim btn6c As ABMButton";
_btn6c = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 244;BA.debugLine="btn6c.InitializeRaised(page, \"btn6c\", \"mdi-image-";
_btn6c.InitializeRaised(_page,"btn6c","mdi-image-palette",_abm.ICONALIGN_RIGHT,"BUTTON","darkgreen");
 //BA.debugLineNum = 245;BA.debugLine="btn6c.size = ABM.BUTTONSIZE_LARGE";
_btn6c.Size = _abm.BUTTONSIZE_LARGE;
 //BA.debugLineNum = 246;BA.debugLine="page.Cell(11,1).AddComponent(btn6c)";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn6c));
 //BA.debugLineNum = 249;BA.debugLine="Dim code4 As StringBuilder";
_code4 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 250;BA.debugLine="code4.Initialize";
_code4.Initialize();
 //BA.debugLineNum = 251;BA.debugLine="code4.Append(\"Dim btn6 As ABMButton\").Append(CRLF";
_code4.Append("Dim btn6 As ABMButton").Append(__c.CRLF);
 //BA.debugLineNum = 252;BA.debugLine="code4.Append(\"btn6.InitializeRaised(page, \"\"btn6\"";
_code4.Append("btn6.InitializeRaised(page, \"btn6\", \"mdi-image-palette\", ABM.ICONALIGN_RIGHT, \"BUTTON\", \"darkgreen\")").Append(__c.CRLF);
 //BA.debugLineNum = 253;BA.debugLine="code4.Append(\"btn6.Size = ABM.BUTTONSIZE_SMALL\").";
_code4.Append("btn6.Size = ABM.BUTTONSIZE_SMALL").Append(__c.CRLF);
 //BA.debugLineNum = 254;BA.debugLine="code4.Append(\"page.Cell(11,1).AddComponent(btn6)\"";
_code4.Append("page.Cell(11,1).AddComponent(btn6)").Append(__c.CRLF);
 //BA.debugLineNum = 256;BA.debugLine="page.Cell(12,1).AddComponent(ABMShared.BuildCodeB";
_page.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code4",_code4)));
 //BA.debugLineNum = 259;BA.debugLine="page.Cell(13,1).AddComponent(ABMShared.BuildHeade";
_page.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr1","Enabled/Disabled")));
 //BA.debugLineNum = 261;BA.debugLine="page.Cell(13,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","This can be applied to all button types.")));
 //BA.debugLineNum = 263;BA.debugLine="Dim btn7 As ABMButton";
_btn7 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 264;BA.debugLine="btn7.InitializeRaised(page, \"btn7\", \"mdi-image-pa";
_btn7.InitializeRaised(_page,"btn7","mdi-image-palette",_abm.ICONALIGN_RIGHT,"BUTTON","");
 //BA.debugLineNum = 265;BA.debugLine="btn7.size = ABM.BUTTONSIZE_LARGE";
_btn7.Size = _abm.BUTTONSIZE_LARGE;
 //BA.debugLineNum = 266;BA.debugLine="btn7.Enabled = False";
_btn7.Enabled = __c.False;
 //BA.debugLineNum = 267;BA.debugLine="page.Cell(14,1).AddComponent(btn7)";
_page.Cell((int) (14),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn7));
 //BA.debugLineNum = 270;BA.debugLine="Dim code5 As StringBuilder";
_code5 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 271;BA.debugLine="code5.Initialize";
_code5.Initialize();
 //BA.debugLineNum = 272;BA.debugLine="code5.Append(\"Dim btn7 As ABMButton\").Append(CRLF";
_code5.Append("Dim btn7 As ABMButton").Append(__c.CRLF);
 //BA.debugLineNum = 273;BA.debugLine="code5.Append(\"btn7.InitializeRaised(page, \"\"btn7\"";
_code5.Append("btn7.InitializeRaised(page, \"btn7\", \"mdi-image-palette\", ABM.ICONALIGN_RIGHT, \"BUTTON\", \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 274;BA.debugLine="code5.Append(\"btn7.size = ABM.BUTTONSIZE_LARGE\").";
_code5.Append("btn7.size = ABM.BUTTONSIZE_LARGE").Append(__c.CRLF);
 //BA.debugLineNum = 275;BA.debugLine="code5.Append(\"btn7.Enabled = False\").Append(CRLF)";
_code5.Append("btn7.Enabled = False").Append(__c.CRLF);
 //BA.debugLineNum = 276;BA.debugLine="code5.Append(\"page.Cell(14,1).AddComponent(btn7)\"";
_code5.Append("page.Cell(14,1).AddComponent(btn7)").Append(__c.CRLF);
 //BA.debugLineNum = 278;BA.debugLine="page.Cell(15,1).AddComponent(ABMShared.BuildCodeB";
_page.Cell((int) (15),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code5",_code5)));
 //BA.debugLineNum = 281;BA.debugLine="page.AddModalSheetTemplate(ConnectModal)";
_page.AddModalSheetTemplate(_connectmodal());
 //BA.debugLineNum = 284;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 286;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 289;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 291;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 292;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 312;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 313;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 314;BA.debugLine="If Action = \"ABMButton\" Then Return";
if ((_action).equals("ABMButton")) { 
if (true) return "";};
 //BA.debugLineNum = 315;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 316;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 317;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 318;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 320;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 321;BA.debugLine="End Sub";
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
public String  _page_toastclicked(String _toastid,String _action) throws Exception{
 //BA.debugLineNum = 353;BA.debugLine="Sub Page_ToastClicked(ToastId As String, Action As";
 //BA.debugLineNum = 354;BA.debugLine="Log(\"Toast \" & ToastId & \" clicked on \" & Action)";
__c.Log("Toast "+_toastid+" clicked on "+_action);
 //BA.debugLineNum = 355;BA.debugLine="page.DismissToast(ToastId)";
_page.DismissToast(_toastid);
 //BA.debugLineNum = 356;BA.debugLine="End Sub";
return "";
}
public String  _page_toastdismissed(String _toastid) throws Exception{
 //BA.debugLineNum = 358;BA.debugLine="Sub Page_ToastDismissed(ToastId As String)";
 //BA.debugLineNum = 359;BA.debugLine="Log(\"Toast \" & ToastId & \" dismissed!\")";
__c.Log("Toast "+_toastid+" dismissed!");
 //BA.debugLineNum = 360;BA.debugLine="End Sub";
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
