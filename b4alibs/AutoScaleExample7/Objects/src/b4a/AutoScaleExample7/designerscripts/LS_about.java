package b4a.AutoScaleExample7.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_about{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleRate(0.5)"[about/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.5d);
//BA.debugLineNum = 3;BA.debugLine="AutoScaleAll"[about/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 5;BA.debugLine="pnlAbout.HorizontalCenter = 50%x"[about/General script]
views.get("pnlabout").vw.setLeft((int)((50d / 100 * width) - (views.get("pnlabout").vw.getWidth() / 2)));
//BA.debugLineNum = 6;BA.debugLine="pnlAbout.VerticalCenter = 50%y"[about/General script]
views.get("pnlabout").vw.setTop((int)((50d / 100 * height) - (views.get("pnlabout").vw.getHeight() / 2)));

}
}