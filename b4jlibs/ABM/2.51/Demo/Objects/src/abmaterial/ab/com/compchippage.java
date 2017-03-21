package abmaterial.ab.com;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.debug.*;

public class compchippage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.StandardBA("abmaterial.ab.com", "abmaterial.ab.com.compchippage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", abmaterial.ab.com.compchippage.class).invoke(this, new Object[] {null});
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
 //BA.debugLineNum = 104;BA.debugLine="public Sub BuildPage()";
 //BA.debugLineNum = 106;BA.debugLine="BuildTheme";
_buildtheme();
 //BA.debugLineNum = 109;BA.debugLine="page.InitializeWithTheme(Name, \"/ws/\" & ABMshared";
_page.InitializeWithTheme(_name,"/ws/"+_abmshared._appname+"/"+_name,__c.False,_abmshared._sessionmaxinactiveintervalseconds,_theme);
 //BA.debugLineNum = 110;BA.debugLine="page.ShowLoader=True";
_page.setShowLoader(__c.True);
 //BA.debugLineNum = 111;BA.debugLine="page.ShowLoaderType=ABM.LOADER_TYPE_MANUAL ' NEW";
_page.setShowLoaderType(_abm.LOADER_TYPE_MANUAL);
 //BA.debugLineNum = 112;BA.debugLine="page.PageTitle = \"ABMChip\"";
_page.PageTitle = "ABMChip";
 //BA.debugLineNum = 113;BA.debugLine="page.PageDescription = \"The chip component \"";
_page.PageDescription = "The chip component ";
 //BA.debugLineNum = 114;BA.debugLine="page.PageHTMLName = \"abmaterial-chip.html\"";
_page.PageHTMLName = "abmaterial-chip.html";
 //BA.debugLineNum = 115;BA.debugLine="page.PageKeywords = \"ABMaterial, material design,";
_page.PageKeywords = "ABMaterial, material design, B4X, B4J, SEO, framework, search engine optimization";
 //BA.debugLineNum = 116;BA.debugLine="page.PageSiteMapPriority = \"0.50\"";
_page.PageSiteMapPriority = "0.50";
 //BA.debugLineNum = 117;BA.debugLine="page.PageSiteMapFrequency = ABM.SITEMAP_FREQ_MONT";
_page.PageSiteMapFrequency = _abm.SITEMAP_FREQ_MONTHLY;
 //BA.debugLineNum = 118;BA.debugLine="page.UseGoogleAnalytics(ABMShared.TrackingID, Nul";
_page.UseGoogleAnalytics(_abmshared._trackingid,(anywheresoftware.b4a.objects.collections.List) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.List(), (java.util.List)(__c.Null)));
 //BA.debugLineNum = 120;BA.debugLine="ABMShared.BuildNavigationBar(page, \"ABMChip\", \"..";
_abmshared._buildnavigationbar(_page,"ABMChip","../images/logo.png","","Controls","ABMChip");
 //BA.debugLineNum = 123;BA.debugLine="page.AddRows(11,True, \"\").AddCells12(1,\"\")";
_page.AddRows((int) (11),__c.True,"").AddCells12((int) (1),"");
 //BA.debugLineNum = 124;BA.debugLine="page.BuildGrid 'IMPORTANT once you loaded the com";
_page.BuildGrid();
 //BA.debugLineNum = 129;BA.debugLine="ABMShared.BuildFooter(page)";
_abmshared._buildfooter(_page);
 //BA.debugLineNum = 130;BA.debugLine="End Sub";
return "";
}
public String  _buildtheme() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="public Sub BuildTheme()";
 //BA.debugLineNum = 89;BA.debugLine="theme.Initialize(\"pagetheme\")";
_theme.Initialize("pagetheme");
 //BA.debugLineNum = 90;BA.debugLine="theme.AddABMTheme(ABMShared.MyTheme)";
_theme.AddABMTheme(_abmshared._mytheme);
 //BA.debugLineNum = 94;BA.debugLine="theme.AddToastTheme(\"toastgreen\")";
_theme.AddToastTheme("toastgreen");
 //BA.debugLineNum = 95;BA.debugLine="theme.Toast(\"toastgreen\").BackColor = ABM.COLOR_G";
_theme.Toast("toastgreen").BackColor = _abm.COLOR_GREEN;
 //BA.debugLineNum = 96;BA.debugLine="theme.Toast(\"toastgreen\").BackColorIntensity = AB";
_theme.Toast("toastgreen").BackColorIntensity = _abm.INTENSITY_DARKEN2;
 //BA.debugLineNum = 99;BA.debugLine="theme.AddButtonTheme(\"bluegrey\")";
_theme.AddButtonTheme("bluegrey");
 //BA.debugLineNum = 100;BA.debugLine="theme.Button(\"bluegrey\").BackColor = ABM.COLOR_BL";
_theme.Button("bluegrey").BackColor = _abm.COLOR_BLUEGREY;
 //BA.debugLineNum = 101;BA.debugLine="theme.Button(\"bluegrey\").BackColorIntensity = ABM";
_theme.Button("bluegrey").BackColorIntensity = _abm.INTENSITY_DARKEN1;
 //BA.debugLineNum = 102;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 11;BA.debugLine="Public Name As String = \"CompChipPage\"";
_name = "CompChipPage";
 //BA.debugLineNum = 13;BA.debugLine="Private ABMPageId As String = \"\"";
_abmpageid = "";
 //BA.debugLineNum = 16;BA.debugLine="Dim myToastId As Int";
_mytoastid = 0;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public String  _connectpage() throws Exception{
com.ab.abmaterial.ABMChip _ch1 = null;
com.ab.abmaterial.ABMChip _ch2 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code1 = null;
com.ab.abmaterial.ABMChip _ch3 = null;
com.ab.abmaterial.ABMChip _ch4 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code2 = null;
com.ab.abmaterial.ABMChip _ch5 = null;
com.ab.abmaterial.ABMChip _ch6 = null;
com.ab.abmaterial.ABMChip _ch7 = null;
com.ab.abmaterial.ABMChip _ch8 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code3 = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _code4 = null;
 //BA.debugLineNum = 132;BA.debugLine="Sub ConnectPage()";
 //BA.debugLineNum = 134;BA.debugLine="ABMShared.ConnectNavigationBar(page)";
_abmshared._connectnavigationbar(_page);
 //BA.debugLineNum = 137;BA.debugLine="page.cell(1,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (1),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par1","Chips can be used to represent small blocks of information. They are most commonly used either for contacts or for tags.")));
 //BA.debugLineNum = 140;BA.debugLine="Dim ch1 As ABMChip";
_ch1 = new com.ab.abmaterial.ABMChip();
 //BA.debugLineNum = 141;BA.debugLine="ch1.Initialize(page, \"ch1\", \"Dad\", False, \"\")";
_ch1.Initialize(_page,"ch1","Dad",__c.False,"");
 //BA.debugLineNum = 142;BA.debugLine="page.Cell(2,1).AddComponent(ch1)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_ch1));
 //BA.debugLineNum = 144;BA.debugLine="Dim ch2 As ABMChip";
_ch2 = new com.ab.abmaterial.ABMChip();
 //BA.debugLineNum = 145;BA.debugLine="ch2.Initialize(page, \"ch2\", \"Mom\", False, \"\")";
_ch2.Initialize(_page,"ch2","Mom",__c.False,"");
 //BA.debugLineNum = 146;BA.debugLine="page.Cell(2,1).AddComponent(ch2)";
_page.Cell((int) (2),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_ch2));
 //BA.debugLineNum = 149;BA.debugLine="Dim code1 As StringBuilder";
_code1 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 150;BA.debugLine="code1.Initialize";
_code1.Initialize();
 //BA.debugLineNum = 151;BA.debugLine="code1.Append(\"// create the chips\").Append(CRLF)";
_code1.Append("// create the chips").Append(__c.CRLF);
 //BA.debugLineNum = 152;BA.debugLine="code1.Append(\"Dim ch1 As ABMChip\").Append(CRLF)";
_code1.Append("Dim ch1 As ABMChip").Append(__c.CRLF);
 //BA.debugLineNum = 153;BA.debugLine="code1.Append(\"ch1.Initialize(page, \"\"ch1\"\", \"\"Dad";
_code1.Append("ch1.Initialize(page, \"ch1\", \"Dad\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 154;BA.debugLine="code1.Append(\"page.Cell(2,1).AddComponent(ch1)\").";
_code1.Append("page.Cell(2,1).AddComponent(ch1)").Append(__c.CRLF);
 //BA.debugLineNum = 155;BA.debugLine="code1.Append(\"\").Append(CRLF)";
_code1.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 156;BA.debugLine="code1.Append(\"Dim ch2 As ABMChip\").Append(CRLF)";
_code1.Append("Dim ch2 As ABMChip").Append(__c.CRLF);
 //BA.debugLineNum = 157;BA.debugLine="code1.Append(\"ch2.Initialize(page, \"\"ch2\"\", \"\"Mom";
_code1.Append("ch2.Initialize(page, \"ch2\", \"Mom\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 158;BA.debugLine="code1.Append(\"page.Cell(2,1).AddComponent(ch2)\").";
_code1.Append("page.Cell(2,1).AddComponent(ch2)").Append(__c.CRLF);
 //BA.debugLineNum = 160;BA.debugLine="page.Cell(3,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (3),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code1",_code1)));
 //BA.debugLineNum = 164;BA.debugLine="page.cell(4,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (4),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par2","Chips can have a little prefix image representing some kind of contact chip.")));
 //BA.debugLineNum = 167;BA.debugLine="Dim ch3 As ABMChip";
_ch3 = new com.ab.abmaterial.ABMChip();
 //BA.debugLineNum = 168;BA.debugLine="ch3.Initialize(page, \"ch3\", \"Dad\", False, \"\")";
_ch3.Initialize(_page,"ch3","Dad",__c.False,"");
 //BA.debugLineNum = 169;BA.debugLine="ch3.Image = \"../images/dad.jpg\"";
_ch3.Image = "../images/dad.jpg";
 //BA.debugLineNum = 170;BA.debugLine="page.Cell(5,1).AddComponent(ch3)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_ch3));
 //BA.debugLineNum = 172;BA.debugLine="Dim ch4 As ABMChip";
_ch4 = new com.ab.abmaterial.ABMChip();
 //BA.debugLineNum = 173;BA.debugLine="ch4.Initialize(page, \"ch4\", \"Mom\", False, \"\")";
_ch4.Initialize(_page,"ch4","Mom",__c.False,"");
 //BA.debugLineNum = 174;BA.debugLine="ch4.Image = \"../images/mom.jpg\"";
_ch4.Image = "../images/mom.jpg";
 //BA.debugLineNum = 175;BA.debugLine="page.Cell(5,1).AddComponent(ch4)";
_page.Cell((int) (5),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_ch4));
 //BA.debugLineNum = 178;BA.debugLine="Dim code2 As StringBuilder";
_code2 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 179;BA.debugLine="code2.Initialize";
_code2.Initialize();
 //BA.debugLineNum = 180;BA.debugLine="code2.Append(\"// create the chips\").Append(CRLF)";
_code2.Append("// create the chips").Append(__c.CRLF);
 //BA.debugLineNum = 181;BA.debugLine="code2.Append(\"Dim ch3 As ABMChip\").Append(CRLF)";
_code2.Append("Dim ch3 As ABMChip").Append(__c.CRLF);
 //BA.debugLineNum = 182;BA.debugLine="code2.Append(\"ch3.Initialize(page, \"\"ch3\"\", \"\"Dad";
_code2.Append("ch3.Initialize(page, \"ch3\", \"Dad\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 183;BA.debugLine="code2.Append(\"ch3.Image = \"\"../images/dad.jpg\"\"\")";
_code2.Append("ch3.Image = \"../images/dad.jpg\"").Append(__c.CRLF);
 //BA.debugLineNum = 184;BA.debugLine="code2.Append(\"page.Cell(5,1).AddComponent(ch3)\").";
_code2.Append("page.Cell(5,1).AddComponent(ch3)").Append(__c.CRLF);
 //BA.debugLineNum = 185;BA.debugLine="code2.Append(\"\").Append(CRLF)";
_code2.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 186;BA.debugLine="code2.Append(\"Dim ch4 As ABMChip\").Append(CRLF)";
_code2.Append("Dim ch4 As ABMChip").Append(__c.CRLF);
 //BA.debugLineNum = 187;BA.debugLine="code2.Append(\"ch4.Initialize(page, \"\"ch4\"\", \"\"Mom";
_code2.Append("ch4.Initialize(page, \"ch4\", \"Mom\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 188;BA.debugLine="code2.Append(\"ch4.Image = \"\"../images/mom.jpg\"\"\")";
_code2.Append("ch4.Image = \"../images/mom.jpg\"").Append(__c.CRLF);
 //BA.debugLineNum = 189;BA.debugLine="code2.Append(\"page.Cell(5,1).AddComponent(ch4)\").";
_code2.Append("page.Cell(5,1).AddComponent(ch4)").Append(__c.CRLF);
 //BA.debugLineNum = 191;BA.debugLine="page.Cell(6,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (6),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code2",_code2)));
 //BA.debugLineNum = 195;BA.debugLine="page.cell(7,1).AddComponent(ABMShared.BuildParagr";
_page.Cell((int) (7),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par3","To create chips that can be closed, just set the 'CanBeClosed' parameter = true in the Initialize method. Brother and Sister are chips that can be closed.")));
 //BA.debugLineNum = 203;BA.debugLine="Dim ch5 As ABMChip";
_ch5 = new com.ab.abmaterial.ABMChip();
 //BA.debugLineNum = 204;BA.debugLine="ch5.Initialize(page, \"5\", \"Dad\", False, \"\")";
_ch5.Initialize(_page,"5","Dad",__c.False,"");
 //BA.debugLineNum = 205;BA.debugLine="ch5.Image = \"../images/dad.jpg\"";
_ch5.Image = "../images/dad.jpg";
 //BA.debugLineNum = 206;BA.debugLine="page.Cell(8,1).AddArrayComponent(ch5, \"mycheck\")";
_page.Cell((int) (8),(int) (1)).AddArrayComponent((com.ab.abmaterial.ABMComponent)(_ch5),"mycheck");
 //BA.debugLineNum = 208;BA.debugLine="Dim ch6 As ABMChip";
_ch6 = new com.ab.abmaterial.ABMChip();
 //BA.debugLineNum = 209;BA.debugLine="ch6.Initialize(page, \"6\", \"Mom\", False, \"\")";
_ch6.Initialize(_page,"6","Mom",__c.False,"");
 //BA.debugLineNum = 210;BA.debugLine="ch6.Image = \"../images/mom.jpg\"";
_ch6.Image = "../images/mom.jpg";
 //BA.debugLineNum = 211;BA.debugLine="page.Cell(8,1).AddArrayComponent(ch6, \"mycheck\")";
_page.Cell((int) (8),(int) (1)).AddArrayComponent((com.ab.abmaterial.ABMComponent)(_ch6),"mycheck");
 //BA.debugLineNum = 213;BA.debugLine="Dim ch7 As ABMChip";
_ch7 = new com.ab.abmaterial.ABMChip();
 //BA.debugLineNum = 214;BA.debugLine="ch7.Initialize(page, \"7\", \"Brother\", True, \"\")";
_ch7.Initialize(_page,"7","Brother",__c.True,"");
 //BA.debugLineNum = 215;BA.debugLine="ch7.Image = \"../images/brother.jpg\"";
_ch7.Image = "../images/brother.jpg";
 //BA.debugLineNum = 216;BA.debugLine="page.Cell(8,1).AddArrayComponent(ch7, \"mycheck\")";
_page.Cell((int) (8),(int) (1)).AddArrayComponent((com.ab.abmaterial.ABMComponent)(_ch7),"mycheck");
 //BA.debugLineNum = 218;BA.debugLine="Dim ch8 As ABMChip";
_ch8 = new com.ab.abmaterial.ABMChip();
 //BA.debugLineNum = 219;BA.debugLine="ch8.Initialize(page, \"8\", \"Sister\", True, \"\")";
_ch8.Initialize(_page,"8","Sister",__c.True,"");
 //BA.debugLineNum = 220;BA.debugLine="ch8.Image = \"../images/sister.jpg\"";
_ch8.Image = "../images/sister.jpg";
 //BA.debugLineNum = 221;BA.debugLine="page.Cell(8,1).AddArrayComponent(ch8, \"mycheck\")";
_page.Cell((int) (8),(int) (1)).AddArrayComponent((com.ab.abmaterial.ABMComponent)(_ch8),"mycheck");
 //BA.debugLineNum = 224;BA.debugLine="Dim code3 As StringBuilder";
_code3 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 225;BA.debugLine="code3.Initialize";
_code3.Initialize();
 //BA.debugLineNum = 226;BA.debugLine="code3.Append(\"// create the chips\").Append(CRLF)";
_code3.Append("// create the chips").Append(__c.CRLF);
 //BA.debugLineNum = 227;BA.debugLine="code3.Append(\"// This time As Array so we can Cat";
_code3.Append("// This time As Array so we can Catch the events in one method.").Append(__c.CRLF);
 //BA.debugLineNum = 228;BA.debugLine="code3.Append(\"// good practice Is using giving th";
_code3.Append("// good practice Is using giving the 'Array' components just the numeric part of the ID.").Append(__c.CRLF);
 //BA.debugLineNum = 229;BA.debugLine="code3.Append(\"// That way you can use the Event N";
_code3.Append("// That way you can use the Event Name As you would any other event.").Append(__c.CRLF);
 //BA.debugLineNum = 230;BA.debugLine="code3.Append(\"// e.g. here: 'mycheck' is the Arra";
_code3.Append("// e.g. here: 'mycheck' is the ArrayName, and '5', '6', '7', '8' are the IDs.").Append(__c.CRLF);
 //BA.debugLineNum = 231;BA.debugLine="code3.Append(\"// Now we can use mycheck_Clicked()";
_code3.Append("// Now we can use mycheck_Clicked() And use the target To get our individual component").Append(__c.CRLF);
 //BA.debugLineNum = 232;BA.debugLine="code3.Append(\"Dim ch5 As ABMChip\").Append(CRLF)";
_code3.Append("Dim ch5 As ABMChip").Append(__c.CRLF);
 //BA.debugLineNum = 233;BA.debugLine="code3.Append(\"ch5.Initialize(page, \"\"5\"\", \"\"Dad\"\"";
_code3.Append("ch5.Initialize(page, \"5\", \"Dad\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 234;BA.debugLine="code3.Append(\"ch5.Image = \"\"../images/dad.jpg\"\"\")";
_code3.Append("ch5.Image = \"../images/dad.jpg\"").Append(__c.CRLF);
 //BA.debugLineNum = 235;BA.debugLine="code3.Append(\"page.Cell(8,1).AddArrayComponent(ch";
_code3.Append("page.Cell(8,1).AddArrayComponent(ch5, \"mycheck\")").Append(__c.CRLF);
 //BA.debugLineNum = 236;BA.debugLine="code3.Append(\"\").Append(CRLF)";
_code3.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 237;BA.debugLine="code3.Append(\"Dim ch6 As ABMChip\").Append(CRLF)";
_code3.Append("Dim ch6 As ABMChip").Append(__c.CRLF);
 //BA.debugLineNum = 238;BA.debugLine="code3.Append(\"ch6.Initialize(page, \"\"6\"\", \"\"Mom\"\"";
_code3.Append("ch6.Initialize(page, \"6\", \"Mom\", False, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 239;BA.debugLine="code3.Append(\"ch6.Image = \"\"../images/mom.jpg\"\"\")";
_code3.Append("ch6.Image = \"../images/mom.jpg\"").Append(__c.CRLF);
 //BA.debugLineNum = 240;BA.debugLine="code3.Append(\"page.Cell(8,1).AddArrayComponent(ch";
_code3.Append("page.Cell(8,1).AddArrayComponent(ch6, \"mycheck\")").Append(__c.CRLF);
 //BA.debugLineNum = 241;BA.debugLine="code3.Append(\"\").Append(CRLF)";
_code3.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 242;BA.debugLine="code3.Append(\"Dim ch7 As ABMChip\").Append(CRLF)";
_code3.Append("Dim ch7 As ABMChip").Append(__c.CRLF);
 //BA.debugLineNum = 243;BA.debugLine="code3.Append(\"ch7.Initialize(page, \"\"7\"\", \"\"Broth";
_code3.Append("ch7.Initialize(page, \"7\", \"Brother\", True, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 244;BA.debugLine="code3.Append(\"ch7.Image = \"\"../images/brother.jpg";
_code3.Append("ch7.Image = \"../images/brother.jpg\"").Append(__c.CRLF);
 //BA.debugLineNum = 245;BA.debugLine="code3.Append(\"page.Cell(8,1).AddArrayComponent(ch";
_code3.Append("page.Cell(8,1).AddArrayComponent(ch7, \"mycheck\")").Append(__c.CRLF);
 //BA.debugLineNum = 246;BA.debugLine="code3.Append(\"\").Append(CRLF)";
_code3.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 247;BA.debugLine="code3.Append(\"Dim ch8 As ABMChip\").Append(CRLF)";
_code3.Append("Dim ch8 As ABMChip").Append(__c.CRLF);
 //BA.debugLineNum = 248;BA.debugLine="code3.Append(\"ch8.Initialize(page, \"\"8\"\", \"\"Siste";
_code3.Append("ch8.Initialize(page, \"8\", \"Sister\", True, \"\")").Append(__c.CRLF);
 //BA.debugLineNum = 249;BA.debugLine="code3.Append(\"ch8.Image = \"\"../images/sister.jpg\"";
_code3.Append("ch8.Image = \"../images/sister.jpg\"").Append(__c.CRLF);
 //BA.debugLineNum = 250;BA.debugLine="code3.Append(\"page.Cell(8,1).AddArrayComponent(ch";
_code3.Append("page.Cell(8,1).AddArrayComponent(ch8, \"mycheck\")").Append(__c.CRLF);
 //BA.debugLineNum = 252;BA.debugLine="page.Cell(9,1).AddComponent(ABMShared.BuildCodeBl";
_page.Cell((int) (9),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code3",_code3)));
 //BA.debugLineNum = 255;BA.debugLine="page.cell(10,1).AddComponent(ABMShared.BuildParag";
_page.Cell((int) (10),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildparagraph(_page,"par4","When the user clicks on a chip, the Clicked() event is raised.  When the close button is clicked, the Closed() event is raised.")));
 //BA.debugLineNum = 258;BA.debugLine="Dim code4 As StringBuilder";
_code4 = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 259;BA.debugLine="code4.Initialize";
_code4.Initialize();
 //BA.debugLineNum = 260;BA.debugLine="code4.Append(\"Sub mycheck_Clicked(Target As Strin";
_code4.Append("Sub mycheck_Clicked(Target As String)").Append(__c.CRLF);
 //BA.debugLineNum = 261;BA.debugLine="code4.Append(\"   Dim chip As ABMChip = page.Compo";
_code4.Append("   Dim chip As ABMChip = page.Component(Target)").Append(__c.CRLF);
 //BA.debugLineNum = 262;BA.debugLine="code4.Append(\"   Dim title As String = chip.Text\"";
_code4.Append("   Dim title As String = chip.Text").Append(__c.CRLF);
 //BA.debugLineNum = 263;BA.debugLine="code4.Append(\"   Dim myTexts, myReturns As List\")";
_code4.Append("   Dim myTexts, myReturns As List").Append(__c.CRLF);
 //BA.debugLineNum = 264;BA.debugLine="code4.Append(\"   myTexts.Initialize\").Append(CRLF";
_code4.Append("   myTexts.Initialize").Append(__c.CRLF);
 //BA.debugLineNum = 265;BA.debugLine="code4.Append(\"   myReturns.Initialize\").Append(CR";
_code4.Append("   myReturns.Initialize").Append(__c.CRLF);
 //BA.debugLineNum = 266;BA.debugLine="code4.Append(\"   myToastId = myToastId + 1\").Appe";
_code4.Append("   myToastId = myToastId + 1").Append(__c.CRLF);
 //BA.debugLineNum = 267;BA.debugLine="code4.Append(\"   page.ShowToast(\"\"toast\"\" & myToa";
_code4.Append("   page.ShowToast(\"toast\" & myToastId, \"toastgreen\", \"Clicked \" & title, 5000, myTexts, myReturns)").Append(__c.CRLF);
 //BA.debugLineNum = 268;BA.debugLine="code4.Append(\"End Sub\").Append(CRLF)";
_code4.Append("End Sub").Append(__c.CRLF);
 //BA.debugLineNum = 269;BA.debugLine="code4.Append(\"\").Append(CRLF)";
_code4.Append("").Append(__c.CRLF);
 //BA.debugLineNum = 270;BA.debugLine="code4.Append(\"Sub mycheck_Closed(Target As String";
_code4.Append("Sub mycheck_Closed(Target As String)").Append(__c.CRLF);
 //BA.debugLineNum = 271;BA.debugLine="code4.Append(\"   Dim chip As ABMChip = page.Compo";
_code4.Append("   Dim chip As ABMChip = page.Component(Target)").Append(__c.CRLF);
 //BA.debugLineNum = 272;BA.debugLine="code4.Append(\"   Dim title As String = chip.Text\"";
_code4.Append("   Dim title As String = chip.Text").Append(__c.CRLF);
 //BA.debugLineNum = 273;BA.debugLine="code4.Append(\"   Dim myTexts, myReturns As List\")";
_code4.Append("   Dim myTexts, myReturns As List").Append(__c.CRLF);
 //BA.debugLineNum = 274;BA.debugLine="code4.Append(\"   myTexts.Initialize\").Append(CRLF";
_code4.Append("   myTexts.Initialize").Append(__c.CRLF);
 //BA.debugLineNum = 275;BA.debugLine="code4.Append(\"   myReturns.Initialize\").Append(CR";
_code4.Append("   myReturns.Initialize").Append(__c.CRLF);
 //BA.debugLineNum = 276;BA.debugLine="code4.Append(\"   myToastId = myToastId + 1\").Appe";
_code4.Append("   myToastId = myToastId + 1").Append(__c.CRLF);
 //BA.debugLineNum = 277;BA.debugLine="code4.Append(\"   page.ShowToast(\"\"toast\"\" & myToa";
_code4.Append("   page.ShowToast(\"toast\" & myToastId, \"toastgreen\", \"Closed \" & title, 5000, myTexts, myReturns)").Append(__c.CRLF);
 //BA.debugLineNum = 278;BA.debugLine="code4.Append(\"End Sub\").Append(CRLF)";
_code4.Append("End Sub").Append(__c.CRLF);
 //BA.debugLineNum = 280;BA.debugLine="page.Cell(11,1).AddComponent(ABMShared.BuildCodeB";
_page.Cell((int) (11),(int) (1)).AddComponent((com.ab.abmaterial.ABMComponent)(_abmshared._buildcodeblock(_page,"code4",_code4)));
 //BA.debugLineNum = 283;BA.debugLine="ABMShared.ConnectFooter(page)";
_abmshared._connectfooter(_page);
 //BA.debugLineNum = 285;BA.debugLine="page.Refresh ' IMPORTANT";
_page.Refresh();
 //BA.debugLineNum = 288;BA.debugLine="page.FinishedLoading 'IMPORTANT";
_page.FinishedLoading();
 //BA.debugLineNum = 290;BA.debugLine="page.RestoreNavigationBarPosition";
_page.RestoreNavigationBarPosition();
 //BA.debugLineNum = 291;BA.debugLine="End Sub";
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
public String  _mycheck_clicked(String _target) throws Exception{
com.ab.abmaterial.ABMChip _chip = null;
String _title = "";
 //BA.debugLineNum = 316;BA.debugLine="Sub mycheck_Clicked(Target As String)";
 //BA.debugLineNum = 317;BA.debugLine="Log(Target)";
__c.Log(_target);
 //BA.debugLineNum = 318;BA.debugLine="Dim chip As ABMChip = page.Component(Target)";
_chip = (com.ab.abmaterial.ABMChip)(_page.Component(_target));
 //BA.debugLineNum = 319;BA.debugLine="Dim title As String = chip.Text";
_title = _chip.Text;
 //BA.debugLineNum = 320;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 321;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastgreen\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastgreen","Clicked "+_title,(int) (5000));
 //BA.debugLineNum = 323;BA.debugLine="End Sub";
return "";
}
public String  _mycheck_closed(String _target) throws Exception{
com.ab.abmaterial.ABMChip _chip = null;
String _title = "";
 //BA.debugLineNum = 327;BA.debugLine="Sub mycheck_Closed(Target As String)";
 //BA.debugLineNum = 328;BA.debugLine="Dim chip As ABMChip = page.Component(Target)";
_chip = (com.ab.abmaterial.ABMChip)(_page.Component(_target));
 //BA.debugLineNum = 329;BA.debugLine="Dim title As String = chip.Text";
_title = _chip.Text;
 //BA.debugLineNum = 330;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 331;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastgreen\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastgreen","Closed "+_title,(int) (5000));
 //BA.debugLineNum = 332;BA.debugLine="End Sub";
return "";
}
public String  _page_navigationbarclicked(String _action,String _value) throws Exception{
 //BA.debugLineNum = 294;BA.debugLine="Sub Page_NavigationbarClicked(Action As String, Va";
 //BA.debugLineNum = 295;BA.debugLine="page.SaveNavigationBarPosition";
_page.SaveNavigationBarPosition();
 //BA.debugLineNum = 296;BA.debugLine="If Action = \"ABMChip\" Then Return";
if ((_action).equals("ABMChip")) { 
if (true) return "";};
 //BA.debugLineNum = 297;BA.debugLine="If Action = \"Contact\" Then";
if ((_action).equals("Contact")) { 
 //BA.debugLineNum = 298;BA.debugLine="myToastId = myToastId + 1";
_mytoastid = (int) (_mytoastid+1);
 //BA.debugLineNum = 299;BA.debugLine="page.ShowToast(\"toast\" & myToastId, \"toastred\",";
_page.ShowToast("toast"+BA.NumberToString(_mytoastid),"toastred","Hello to you too!",(int) (5000));
 //BA.debugLineNum = 300;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 302;BA.debugLine="If Action = \"LogOff\" Then";
if ((_action).equals("LogOff")) { 
 //BA.debugLineNum = 303;BA.debugLine="ABMShared.LogOff(page)";
_abmshared._logoff(_page);
 //BA.debugLineNum = 304;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 306;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, Value)";
_abmshared._navigatetopage(_ws,_abmpageid,_value);
 //BA.debugLineNum = 307;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 309;BA.debugLine="Sub Page_SignedOffSocialNetwork(Network As String,";
 //BA.debugLineNum = 310;BA.debugLine="page.ws.Session.SetAttribute(\"authType\", \"\")";
_page.ws.getSession().SetAttribute("authType",(Object)(""));
 //BA.debugLineNum = 311;BA.debugLine="page.ws.Session.SetAttribute(\"authName\", \"\")";
_page.ws.getSession().SetAttribute("authName",(Object)(""));
 //BA.debugLineNum = 312;BA.debugLine="page.ws.Session.SetAttribute(\"IsAuthorized\", \"\")";
_page.ws.getSession().SetAttribute("IsAuthorized",(Object)(""));
 //BA.debugLineNum = 313;BA.debugLine="ABMShared.NavigateToPage(ws, ABMPageId, \"../\")";
_abmshared._navigatetopage(_ws,_abmpageid,"../");
 //BA.debugLineNum = 314;BA.debugLine="End Sub";
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
