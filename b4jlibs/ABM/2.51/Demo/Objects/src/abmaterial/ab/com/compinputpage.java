package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compinputpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compinputpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compinputpage.class).invoke(this, new Object[] {null});
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
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMInput _inp2 = null;
com.ab.abmaterial.ABMInput _inp3 = null;
com.ab.abmaterial.ABMInput _inp4 = null;
com.ab.abmaterial.ABMInput _inp5 = null;
com.ab.abmaterial.ABMInput _inp6 = null;
com.ab.abmaterial.ABMInput _inp7 = null;
com.ab.abmaterial.ABMInput _inp8 = null;
com.ab.abmaterial.ABMInput _inp9 = null;
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMLabel _mymodallbl = null;
 //BA.debugLineNum = 356;BA.debugLine="Sub btn1_Clicked(Target As String)";
 //BA.debugLineNum = 358;BA.debugLine="Dim inp1 As ABMInput = page.Component(\"inp1\")";
_inp1 = (com.ab.abmaterial.ABMInput)(_page.Component("inp1"));
 //BA.debugLineNum = 360;BA.debugLine="Dim inp2 As ABMInput = page.Component(\"inp2\")";
_inp2 = (com.ab.abmaterial.ABMInput)(_page.Component("inp2"));
 //BA.debugLineNum = 361;BA.debugLine="Dim inp3 As ABMInput = page.Component(\"inp3\")";
_inp3 = (com.ab.abmaterial.ABMInput)(_page.Component("inp3"));
 //BA.debugLineNum = 362;BA.debugLine="Dim inp4 As ABMInput = page.Component(\"inp4\")";
_inp4 = (com.ab.abmaterial.ABMInput)(_page.Component("inp4"));
 //BA.debugLineNum = 363;BA.debugLine="Dim inp5 As ABMInput = page.Component(\"inp5\")";
_inp5 = (com.ab.abmaterial.ABMInput)(_page.Component("inp5"));
 //BA.debugLineNum = 364;BA.debugLine="Dim inp6 As ABMInput = page.Component(\"inp6\")";
_inp6 = (com.ab.abmaterial.ABMInput)(_page.Component("inp6"));
 //BA.debugLineNum = 365;BA.debugLine="Dim inp7 As ABMInput = page.Component(\"inp7\")";
_inp7 = (com.ab.abmaterial.ABMInput)(_page.Component("inp7"));
 //BA.debugLineNum = 366;BA.debugLine="Dim inp8 As ABMInput = page.Component(\"inp8\")";
_inp8 = (com.ab.abmaterial.ABMInput)(_page.Component("inp8"));
 //BA.debugLineNum = 367;BA.debugLine="Dim inp9 As ABMInput = page.Component(\"inp9\")";
_inp9 = (com.ab.abmaterial.ABMInput)(_page.Component("inp9"));
 //BA.debugLineNum = 368;BA.debugLine="Dim mymodal As ABMModalSheet = page.ModalSheet(\"m";
_mymodal = _page.ModalSheet("myModal");
 //BA.debugLineNum = 369;BA.debugLine="Dim myModalLbl As ABMLabel= mymodal.Content.Compo";
_mymodallbl = (com.ab.abmaterial.ABMLabel)(_mymodal.Content.Component("contlbl1"));
 //BA.debugLineNum = 370;BA.debugLine="myModalLbl.Text = inp1.Text & \"{BR}\" & inp2.Text";
_mymodallbl.Text = _inp1.getText()+"{BR}"+_inp2.getText()+"{BR}"+_inp3.getText()+"{BR}"+_inp4.getText()+"{BR}"+_inp5.getText()+"{BR}"+_inp6.getText()+"{BR}"+_inp7.getText()+"{BR}"+_inp8.getText()+"{BR}"+_inp9.getText();
 //BA.debugLineNum = 374;BA.debugLine="page.ShowModalSheet(\"myModal\")";
_page.ShowModalSheet("myModal");
 //BA.debugLineNum = 375;BA.debugLine="End Sub";
return "";
}
public String  _buildpage() throws Exception{
 //BA.debugLineNum = 106;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 108;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 111;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMShared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 112;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 113;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 114;BA.debugLine="page.PageTitle = \"ABMInput\"";
_page.PageTitle = "ABMInput";
 //BA.debugLineNum = 115;BA.debugLine="page.PageDescription = \"The input component \"";
_page.PageDescription = "The input component ";
 //BA.debugLineNum = 116;BA.debugLine="page.PageHTMLName = \"abmaterial-input.html\"";
_page.PageHTMLName = "abmaterial-input.html";
 //BA.debugLineNum = 117;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 118;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 119;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 120;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 122;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMInput\", \".";
_abmshared._buildnavigationbar(_page,"ABMInput","../images/logo.png","","Controls","ABMInput");
 //BA.debugLineNum = 125;BA.debugLine="page.AddRows(1,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 126;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(2,0,0,0,12,6,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (2),(int) (0),(int) (0),(int) (0),(int) (12),(int) (6),(int) (6),"");
 //BA.debugLineNum = 127;BA.debugLine="page.AddRows(8,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (8),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 128;BA.debugLine="page.AddRows(1,True, \"\").AddCellsOS(2,0,0,0,12,6,";
_page.AddRows((int) (1),__c.True,"").AddCellsOS((int) (2),(int) (0),(int) (0),(int) (0),(int) (12),(int) (6),(int) (6),"");
 //BA.debugLineNum = 129;BA.debugLine="page.AddRows(8,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (8),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 130;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
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
 //BA.debugLineNum = 94;BA.debugLine="theme.Page.PlaceHolderColorIntensity = ABM.INTENS";
_theme.Page.PlaceHolderColorIntensity = _abm.INTENSITY_DARKEN2;
 //BA.debugLineNum = 97;BA.debugLine="theme.AddButtonTheme(\"bluegrey\")";
_theme.AddButtonTheme("bluegrey");
 //BA.debugLineNum = 98;BA.debugLine="theme.Button(\"bluegrey\").BackColor = ABM.COLOR_BL";
_theme.Button("bluegrey").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 99;BA.debugLine="theme.Button(\"bluegrey\").BackColorIntensity = ABM";
_theme.Button("bluegrey").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 102;BA.debugLine="theme.AddContainerTheme(\"modalcontent\")";
_theme.AddContainerTheme("modalcontent");
 //BA.debugLineNum = 103;BA.debugLine="theme.Container(\"modalcontent\").BackColor = ABM.C";
_theme.Container("modalcontent").BackColor = _abm.COLOR_WHITE;
 //BA.debugLineNum = 104;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompInputPage\"";
_name = "CompInputPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMInput _inp1 = null;
com.ab.abmaterial.ABMInput _inp2 = null;
com.ab.abmaterial.ABMInput _inp3 = null;
com.ab.abmaterial.ABMInput _inp4 = null;
com.ab.abmaterial.ABMInput _inp5 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code1 = null;
com.ab.abmaterial.ABMInput _inp6 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code2 = null;
com.ab.abmaterial.ABMInput _inp7 = null;
com.ab.abmaterial.ABMInput _inp8 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code3 = null;
com.ab.abmaterial.ABMInput _inp9 = null;
com.ab.abmaterial.ABMButton _btn1 = null;
com.ab.abmaterial.ABMInput _inp10 = null;
com.ab.abmaterial.ABMModalSheet _mymodal = null;
com.ab.abmaterial.ABMLabel _lbl1 = null;
 //BA.debugLineNum = 139;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 141;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 144;BA.debugLine="page.Cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Text fields allow user input. The border should light up simply and clearly indicating which field the user is currently editing. If you don't want the Green and Red validation states, just set validate to false.")));
 //BA.debugLineNum = 147;BA.debugLine="Dim inp1 As ABMInput";
_inp1 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 148;BA.debugLine="inp1.Initialize(page, \"inp1\", ABM.INPUT_TEXT, \"Fi";
_inp1.Initialize(_page,"inp1",_abm.INPUT_TEXT,"First Name",__c.False,"");
 //BA.debugLineNum = 149;BA.debugLine="inp1.PlaceHolderText = \"or your call name\"";
_inp1.PlaceHolderText = "or your call name";
 //BA.debugLineNum = 168;BA.debugLine="page.Cell(2,1).AddComponent(inp1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp1));
 //BA.debugLineNum = 170;BA.debugLine="Dim inp2 As ABMInput";
_inp2 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 171;BA.debugLine="inp2.Initialize(page, \"inp2\", ABM.INPUT_TEXT, \"La";
_inp2.Initialize(_page,"inp2",_abm.INPUT_TEXT,"Last Name",__c.False,"");
 //BA.debugLineNum = 181;BA.debugLine="page.Cell(2,2).AddComponent(inp2)";
_page.Cell((int) (2),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp2));
 //BA.debugLineNum = 183;BA.debugLine="Dim inp3 As ABMInput";
_inp3 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 184;BA.debugLine="inp3.Initialize(page, \"inp3\", ABM.INPUT_TEXT, \"Di";
_inp3.Initialize(_page,"inp3",_abm.INPUT_TEXT,"Disabled",__c.False,"");
 //BA.debugLineNum = 185;BA.debugLine="inp3.Enabled = False";
_inp3.Enabled = __c.False;
 //BA.debugLineNum = 186;BA.debugLine="inp3.PlaceHolderText = \"I'm disabled!\"";
_inp3.PlaceHolderText = "I'm disabled!";
 //BA.debugLineNum = 187;BA.debugLine="page.Cell(3,1).AddComponent(inp3)";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp3));
 //BA.debugLineNum = 189;BA.debugLine="Dim inp4 As ABMInput";
_inp4 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 190;BA.debugLine="inp4.Initialize(page, \"inp4\", ABM.INPUT_PASSWORD,";
_inp4.Initialize(_page,"inp4",_abm.INPUT_PASSWORD,"Password",__c.False,"");
 //BA.debugLineNum = 191;BA.debugLine="page.Cell(4,1).AddComponent(inp4)";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp4));
 //BA.debugLineNum = 193;BA.debugLine="Dim inp5 As ABMInput";
_inp5 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 194;BA.debugLine="inp5.Initialize(page, \"inp5\", ABM.INPUT_EMAIL, \"E";
_inp5.Initialize(_page,"inp5",_abm.INPUT_EMAIL,"Email",__c.False,"");
 //BA.debugLineNum = 195;BA.debugLine="inp5.WrongMessage = \"Wrong\"";
_inp5.WrongMessage = "Wrong";
 //BA.debugLineNum = 196;BA.debugLine="inp5.SuccessMessage = \"Correct\"";
_inp5.SuccessMessage = "Correct";
 //BA.debugLineNum = 197;BA.debugLine="page.Cell(5,1).AddComponent(inp5)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp5));
 //BA.debugLineNum = 200;BA.debugLine="Dim code1 As StringBuilder";
_code1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 201;BA.debugLine="code1.Initialize";
_code1.Initialize();
 //BA.debugLineNum = 202;BA.debugLine="code1.Append(\"Dim inp1 As ABMInput\").Append(CRLF)";
_code1.Append("Dim inp1 As ABMInput").Append(__c.CRLF);
 //BA.debugLineNum = 203;BA.debugLine="code1.Append(\"inp1.Initialize(page, \"\"inp1\"\", ABM";
_code1.Append("inp1.Initialize(page, \"inp1\", ABM.INPUT_TEXT, \"First Name\" False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 204;BA.debugLine="code1.Append(\"inp1.PlaceHolderText = \"\"or your ca";
_code1.Append("inp1.PlaceHolderText = \"or your call name\"").Append(__c.CRLF);
 //BA.debugLineNum = 205;BA.debugLine="code1.Append(\"page.Cell(2,1).AddComponent(inp1)\")";
_code1.Append("page.Cell(2,1).AddComponent(inp1)").Append(__c.CRLF);
 //BA.debugLineNum = 206;BA.debugLine="code1.Append(\"\").Append(CRLF)";
_code1.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 207;BA.debugLine="code1.Append(\"Dim inp2 As ABMInput\").Append(CRLF)";
_code1.Append("Dim inp2 As ABMInput").Append(__c.CRLF);
 //BA.debugLineNum = 208;BA.debugLine="code1.Append(\"inp2.Initialize(page, \"\"inp2\"\", ABM";
_code1.Append("inp2.Initialize(page, \"inp2\", ABM.INPUT_TEXT, \"Last Name\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 209;BA.debugLine="code1.Append(\"page.Cell(2,2).AddComponent(inp2)\")";
_code1.Append("page.Cell(2,2).AddComponent(inp2)").Append(__c.CRLF);
 //BA.debugLineNum = 210;BA.debugLine="code1.Append(\"\").Append(CRLF)";
_code1.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 211;BA.debugLine="code1.Append(\"Dim inp3 As ABMInput\").Append(CRLF)";
_code1.Append("Dim inp3 As ABMInput").Append(__c.CRLF);
 //BA.debugLineNum = 212;BA.debugLine="code1.Append(\"inp3.Initialize(page, \"\"inp3\"\", ABM";
_code1.Append("inp3.Initialize(page, \"inp3\", ABM.INPUT_TEXT, \"Disabled\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 213;BA.debugLine="code1.Append(\"inp3.Disabled = True\").Append(CRLF)";
_code1.Append("inp3.Disabled = True").Append(__c.CRLF);
 //BA.debugLineNum = 214;BA.debugLine="code1.Append(\"inp3.PlaceHolderText = \"\"I'm disabl";
_code1.Append("inp3.PlaceHolderText = \"I'm disabled!\"").Append(__c.CRLF);
 //BA.debugLineNum = 215;BA.debugLine="code1.Append(\"page.Cell(3,1).AddComponent(inp3)\")";
_code1.Append("page.Cell(3,1).AddComponent(inp3)").Append(__c.CRLF);
 //BA.debugLineNum = 216;BA.debugLine="code1.Append(\"\").Append(CRLF)";
_code1.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 217;BA.debugLine="code1.Append(\"Dim inp4 As ABMInput\").Append(CRLF)";
_code1.Append("Dim inp4 As ABMInput").Append(__c.CRLF);
 //BA.debugLineNum = 218;BA.debugLine="code1.Append(\"inp4.Initialize(page, \"\"inp4\"\", ABM";
_code1.Append("inp4.Initialize(page, \"inp4\", ABM.INPUT_PASSWORD, \"Password\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 219;BA.debugLine="code1.Append(\"page.Cell(4,1).AddComponent(inp4)\")";
_code1.Append("page.Cell(4,1).AddComponent(inp4)").Append(__c.CRLF);
 //BA.debugLineNum = 220;BA.debugLine="code1.Append(\"\").Append(CRLF)";
_code1.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 221;BA.debugLine="code1.Append(\"Dim inp5 As ABMInput\").Append(CRLF)";
_code1.Append("Dim inp5 As ABMInput").Append(__c.CRLF);
 //BA.debugLineNum = 222;BA.debugLine="code1.Append(\"inp5.Initialize(page, \"\"inp5\"\", ABM";
_code1.Append("inp5.Initialize(page, \"inp5\", ABM.INPUT_EMAIL, \"Email\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 223;BA.debugLine="code1.Append(\"inp5.WrongMessage = \"\"Wrong\"\"\").App";
_code1.Append("inp5.WrongMessage = \"Wrong\"").Append(__c.CRLF);
 //BA.debugLineNum = 224;BA.debugLine="code1.Append(\"inp5.SuccessMessage = \"\"Correct\"\"\")";
_code1.Append("inp5.SuccessMessage = \"Correct\"").Append(__c.CRLF);
 //BA.debugLineNum = 225;BA.debugLine="code1.Append(\"page.Cell(5,1).AddComponent(inp5)\")";
_code1.Append("page.Cell(5,1).AddComponent(inp5)").Append(__c.CRLF);
 //BA.debugLineNum = 227;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code1",_code1)));
 //BA.debugLineNum = 230;BA.debugLine="page.Cell(7,1).AddComponent(ABMShared.BuildSubHea";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader(_page,"hdr1","Prefilled Text Inputs")));
 //BA.debugLineNum = 233;BA.debugLine="Dim inp6 As ABMInput";
_inp6 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 234;BA.debugLine="inp6.Initialize(page, \"inp6\", ABM.INPUT_TEXT, \"Fi";
_inp6.Initialize(_page,"inp6",_abm.INPUT_TEXT,"First Name",__c.False,"");
 //BA.debugLineNum = 235;BA.debugLine="inp6.Text = \"Alain\"";
_inp6.setText("Alain");
 //BA.debugLineNum = 236;BA.debugLine="page.Cell(8,1).AddComponent(inp6)";
_page.Cell((int) (8),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp6));
 //BA.debugLineNum = 239;BA.debugLine="Dim code2 As StringBuilder";
_code2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 240;BA.debugLine="code2.Initialize";
_code2.Initialize();
 //BA.debugLineNum = 241;BA.debugLine="code2.Append(\"Dim inp6 As ABMInput\").Append(CRLF)";
_code2.Append("Dim inp6 As ABMInput").Append(__c.CRLF);
 //BA.debugLineNum = 242;BA.debugLine="code2.Append(\"inp6.Initialize(page, \"\"inp6\"\", ABM";
_code2.Append("inp6.Initialize(page, \"inp6\", ABM.INPUT_TEXT, \"First Name\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 243;BA.debugLine="code2.Append(\"inp6.Text = \"\"Alain\"\"\").Append(CRLF";
_code2.Append("inp6.Text = \"Alain\"").Append(__c.CRLF);
 //BA.debugLineNum = 244;BA.debugLine="code2.Append(\"page.Cell(8,1).AddComponent(inp6)\")";
_code2.Append("page.Cell(8,1).AddComponent(inp6)").Append(__c.CRLF);
 //BA.debugLineNum = 246;BA.debugLine="page.Cell(9,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code2",_code2)));
 //BA.debugLineNum = 249;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildSubHe";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildsubheader(_page,"hdr2","Icon Prefixes")));
 //BA.debugLineNum = 252;BA.debugLine="page.Cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","You can add an icon prefix to make the form input label even more clear. ")));
 //BA.debugLineNum = 255;BA.debugLine="Dim inp7 As ABMInput";
_inp7 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 256;BA.debugLine="inp7.Initialize(page, \"inp7\", ABM.INPUT_TEXT, \"Fi";
_inp7.Initialize(_page,"inp7",_abm.INPUT_TEXT,"First Name",__c.False,"");
 //BA.debugLineNum = 257;BA.debugLine="inp7.IconName = \"mdi-action-account-circle\"";
_inp7.IconName = "mdi-action-account-circle";
 //BA.debugLineNum = 258;BA.debugLine="page.Cell(11,1).AddComponent(inp7)";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp7));
 //BA.debugLineNum = 261;BA.debugLine="Dim inp8 As ABMInput";
_inp8 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 262;BA.debugLine="inp8.Initialize(page, \"inp8\", ABM.INPUT_TEXT, \"Te";
_inp8.Initialize(_page,"inp8",_abm.INPUT_TEXT,"Telephone",__c.False,"");
 //BA.debugLineNum = 263;BA.debugLine="inp8.IconName = \"mdi-communication-phone\"";
_inp8.IconName = "mdi-communication-phone";
 //BA.debugLineNum = 264;BA.debugLine="page.Cell(11,2).AddComponent(inp8)";
_page.Cell((int) (11),(int) (2)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp8));
 //BA.debugLineNum = 267;BA.debugLine="Dim code3 As StringBuilder";
_code3 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 268;BA.debugLine="code3.Initialize";
_code3.Initialize();
 //BA.debugLineNum = 269;BA.debugLine="code3.Append(\"Dim inp7 As ABMInput\").Append(CRLF)";
_code3.Append("Dim inp7 As ABMInput").Append(__c.CRLF);
 //BA.debugLineNum = 270;BA.debugLine="code3.Append(\"inp7.Initialize(page, \"\"inp7\"\", ABM";
_code3.Append("inp7.Initialize(page, \"inp7\", ABM.INPUT_TEXT, \"First Name\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 271;BA.debugLine="code3.Append(\"inp7.IconName = \"\"mdi-action-accoun";
_code3.Append("inp7.IconName = \"mdi-action-account-circle\"").Append(__c.CRLF);
 //BA.debugLineNum = 272;BA.debugLine="code3.Append(\"page.Cell(11,1).AddComponent(inp7)\"";
_code3.Append("page.Cell(11,1).AddComponent(inp7)").Append(__c.CRLF);
 //BA.debugLineNum = 273;BA.debugLine="code3.Append(\"\").Append(CRLF)";
_code3.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 274;BA.debugLine="code3.Append(\"Dim inp8 As ABMInput\").Append(CRLF)";
_code3.Append("Dim inp8 As ABMInput").Append(__c.CRLF);
 //BA.debugLineNum = 275;BA.debugLine="code3.Append(\"inp8.Initialize(page, \"\"inp8\"\", ABM";
_code3.Append("inp8.Initialize(page, \"inp8\", ABM.INPUT_TEXT, \"Telephone\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 276;BA.debugLine="code3.Append(\"inp8.IconName = \"\"mdi-communication";
_code3.Append("inp8.IconName = \"mdi-communication-phone\"").Append(__c.CRLF);
 //BA.debugLineNum = 277;BA.debugLine="code3.Append(\"page.Cell(11,2).AddComponent(inp8)\"";
_code3.Append("page.Cell(11,2).AddComponent(inp8)").Append(__c.CRLF);
 //BA.debugLineNum = 279;BA.debugLine="page.Cell(12,1).AddComponent(ABMShared.BuildCodeB";
_page.Cell((int) (12),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code3",_code3)));
 //BA.debugLineNum = 282;BA.debugLine="page.Cell(13,1).AddComponent(ABMShared.BuildHeade";
_page.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildheader(_page,"hdr3","Text Area")));
 //BA.debugLineNum = 285;BA.debugLine="page.Cell(13,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (13),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","Textareas allow larger expandable user input. The border should light up simply and clearly indicating which field the user is currently editing. ")));
 //BA.debugLineNum = 288;BA.debugLine="Dim inp9 As ABMInput";
_inp9 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 289;BA.debugLine="inp9.Initialize(page, \"inp9\", ABM.INPUT_TEXT, \"Co";
_inp9.Initialize(_page,"inp9",_abm.INPUT_TEXT,"Comment",__c.True,"");
 //BA.debugLineNum = 290;BA.debugLine="inp9.IconName = \"mdi-communication-comment\"";
_inp9.IconName = "mdi-communication-comment";
 //BA.debugLineNum = 291;BA.debugLine="page.Cell(14,1).AddComponent(inp9)";
_page.Cell((int) (14),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp9));
 //BA.debugLineNum = 294;BA.debugLine="Dim btn1 As ABMButton";
_btn1 = new com.ab.abmaterial.ABMButton();
 //BA.debugLineNum = 295;BA.debugLine="btn1.InitializeRaised(page, \"btn1\", \"\", \"\", \"Get";
_btn1.InitializeRaised(_page,"btn1","","","Get the text","bluegrey");
 //BA.debugLineNum = 296;BA.debugLine="page.Cell(15,1).AddComponent(btn1)";
_page.Cell((int) (15),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_btn1));
 //BA.debugLineNum = 299;BA.debugLine="Dim inp10 As ABMInput";
_inp10 = new com.ab.abmaterial.ABMInput();
 //BA.debugLineNum = 300;BA.debugLine="inp10.Initialize(page, \"inp10\", ABM.INPUT_TEXT, \"";
_inp10.Initialize(_page,"inp10",_abm.INPUT_TEXT,"With date mask",__c.False,"");
 //BA.debugLineNum = 302;BA.debugLine="inp10.inputMask = \"'mask': 'd/m/y'\"";
_inp10.InputMask = "'mask': 'd/m/y'";
 //BA.debugLineNum = 303;BA.debugLine="page.Cell(16,1).AddComponent(inp10)";
_page.Cell((int) (16),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_inp10));
 //BA.debugLineNum = 306;BA.debugLine="Dim myModal As ABMModalSheet";
_mymodal = new com.ab.abmaterial.ABMModalSheet();
 //BA.debugLineNum = 307;BA.debugLine="myModal.Initialize(page, \"myModal\", False, False,";
_mymodal.Initialize(_page,"myModal",__c.False,BA.ObjectToString(__c.False),"");
 //BA.debugLineNum = 308;BA.debugLine="myModal.Content.UseTheme(\"modalcontent\")";
_mymodal.Content.UseTheme("modalcontent");
 //BA.debugLineNum = 309;BA.debugLine="myModal.Footer.UseTheme(\"modalcontent\")";
_mymodal.Footer.UseTheme("modalcontent");
 //BA.debugLineNum = 310;BA.debugLine="myModal.IsDismissible = True";
_mymodal.IsDismissible = __c.True;
 //BA.debugLineNum = 312;BA.debugLine="myModal.Content.AddRows(1, True, \"\").AddCells12(1";
_mymodal.Content.AddRows((int) (1),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 313;BA.debugLine="myModal.content.BuildGrid 'IMPORTANT once you loa";
_mymodal.Content.BuildGrid();
 //BA.debugLineNum = 315;BA.debugLine="Dim lbl1 As ABMLabel";
_lbl1 = new com.ab.abmaterial.ABMLabel();
 //BA.debugLineNum = 316;BA.debugLine="lbl1.Initialize(page, \"contlbl1\", \"buttonmessages";
_lbl1.Initialize(_page,"contlbl1","buttonmessages",_abm.SIZE_PARAGRAPH,__c.False,"");
 //BA.debugLineNum = 317;BA.debugLine="myModal.content.Cell(1,1).AddComponent(lbl1)";
_mymodal.Content.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_lbl1));
 //BA.debugLineNum = 319;BA.debugLine="page.AddModalSheetTemplate(myModal)";
_page.AddModalSheetTemplate(_mymodal);
 //BA.debugLineNum = 322;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 324;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 327;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 329;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 330;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 333;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 334;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 335;BA.debugLine="If Action = \"GettingStarted\" Then Return";
if ((_action).equals("GettingStarted")) { 
if (true) return "";};
 //BA.debugLineNum = 336;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 337;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 338;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 339;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 341;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 342;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 343;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 345;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 346;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 62;BA.debugLine="ws.session.SetAttribute(\"ABMNewSession\", True)";
_ws.getSession().SetAttribute("ABMNewSession",(Object)(__c.True));
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
 //BA.debugLineNum = 348;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 349;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 350;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 351;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 352;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 353;BA.debugLine="End Sub";
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
