package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_1{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[1/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="l1.Width=1dip"[1/General script]
views.get("l1").vw.setWidth((int)((1d * scale)));
//BA.debugLineNum = 4;BA.debugLine="l1.HorizontalCenter=30%x"[1/General script]
views.get("l1").vw.setLeft((int)((30d / 100 * width) - (views.get("l1").vw.getWidth() / 2)));
//BA.debugLineNum = 5;BA.debugLine="l2.Width=1dip"[1/General script]
views.get("l2").vw.setWidth((int)((1d * scale)));
//BA.debugLineNum = 6;BA.debugLine="l2.HorizontalCenter=50%x"[1/General script]
views.get("l2").vw.setLeft((int)((50d / 100 * width) - (views.get("l2").vw.getWidth() / 2)));
//BA.debugLineNum = 7;BA.debugLine="l3.Width=1dip"[1/General script]
views.get("l3").vw.setWidth((int)((1d * scale)));
//BA.debugLineNum = 8;BA.debugLine="l3.HorizontalCenter=70%x"[1/General script]
views.get("l3").vw.setLeft((int)((70d / 100 * width) - (views.get("l3").vw.getWidth() / 2)));

}
}