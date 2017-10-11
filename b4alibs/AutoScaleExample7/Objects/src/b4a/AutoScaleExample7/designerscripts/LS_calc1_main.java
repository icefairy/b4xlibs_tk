package b4a.AutoScaleExample7.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_calc1_main{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.4d);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("pnlcalculator").vw.setLeft((int)((50d / 100 * width) - (views.get("pnlcalculator").vw.getWidth() / 2)));
//BA.debugLineNum = 7;BA.debugLine="pnlCalculator.VerticalCenter = 50%y"[calc1_main/General script]
views.get("pnlcalculator").vw.setTop((int)((50d / 100 * height) - (views.get("pnlcalculator").vw.getHeight() / 2)));
//BA.debugLineNum = 9;BA.debugLine="pnlFunctions.HorizontalCenter = 50%x"[calc1_main/General script]
views.get("pnlfunctions").vw.setLeft((int)((50d / 100 * width) - (views.get("pnlfunctions").vw.getWidth() / 2)));
//BA.debugLineNum = 10;BA.debugLine="pnlFunctions.Bottom = pnlCalculator.Bottom"[calc1_main/General script]
views.get("pnlfunctions").vw.setTop((int)((views.get("pnlcalculator").vw.getTop() + views.get("pnlcalculator").vw.getHeight()) - (views.get("pnlfunctions").vw.getHeight())));

}
}