package com.zxdemo.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_layscanner{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[layscanner/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="PnlBarCodeMask.Width=100%x"[layscanner/General script]
views.get("pnlbarcodemask").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 4;BA.debugLine="PnlBarCodeMask.Height=100%y"[layscanner/General script]
views.get("pnlbarcodemask").vw.setHeight((int)((100d / 100 * height)));
//BA.debugLineNum = 5;BA.debugLine="PnlFocus.Width=100%x*0.6"[layscanner/General script]
views.get("pnlfocus").vw.setWidth((int)((100d / 100 * width)*0.6d));
//BA.debugLineNum = 6;BA.debugLine="PnlFocus.Height=PnlFocus.Width"[layscanner/General script]
views.get("pnlfocus").vw.setHeight((int)((views.get("pnlfocus").vw.getWidth())));
//BA.debugLineNum = 7;BA.debugLine="ImgLight.Width=PnlFocus.Width"[layscanner/General script]
views.get("imglight").vw.setWidth((int)((views.get("pnlfocus").vw.getWidth())));
//BA.debugLineNum = 8;BA.debugLine="PnlFocus.Left=(100%x-PnlFocus.Width)/2"[layscanner/General script]
views.get("pnlfocus").vw.setLeft((int)(((100d / 100 * width)-(views.get("pnlfocus").vw.getWidth()))/2d));
//BA.debugLineNum = 9;BA.debugLine="PnlFocus.Top=(100%y-PnlFocus.Height)/2-20dip"[layscanner/General script]
views.get("pnlfocus").vw.setTop((int)(((100d / 100 * height)-(views.get("pnlfocus").vw.getHeight()))/2d-(20d * scale)));
//BA.debugLineNum = 10;BA.debugLine="PnlTop.SetLeftAndRight(0,100%x)"[layscanner/General script]
views.get("pnltop").vw.setLeft((int)(0d));
views.get("pnltop").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 11;BA.debugLine="PnlTop.SetTopAndBottom(0,PnlFocus.Top)"[layscanner/General script]
views.get("pnltop").vw.setTop((int)(0d));
views.get("pnltop").vw.setHeight((int)((views.get("pnlfocus").vw.getTop()) - (0d)));
//BA.debugLineNum = 12;BA.debugLine="PnlBottom.SetLeftAndRight(0,100%x)"[layscanner/General script]
views.get("pnlbottom").vw.setLeft((int)(0d));
views.get("pnlbottom").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 13;BA.debugLine="PnlBottom.SetTopAndBottom(PnlFocus.Top+PnlFocus.Height,100%y)"[layscanner/General script]
views.get("pnlbottom").vw.setTop((int)((views.get("pnlfocus").vw.getTop())+(views.get("pnlfocus").vw.getHeight())));
views.get("pnlbottom").vw.setHeight((int)((100d / 100 * height) - ((views.get("pnlfocus").vw.getTop())+(views.get("pnlfocus").vw.getHeight()))));
//BA.debugLineNum = 14;BA.debugLine="PnlLeft.SetLeftAndRight(0,PnlFocus.Left)"[layscanner/General script]
views.get("pnlleft").vw.setLeft((int)(0d));
views.get("pnlleft").vw.setWidth((int)((views.get("pnlfocus").vw.getLeft()) - (0d)));
//BA.debugLineNum = 15;BA.debugLine="PnlLeft.SetTopAndBottom(PnlTop.Height,PnlBottom.Top)"[layscanner/General script]
views.get("pnlleft").vw.setTop((int)((views.get("pnltop").vw.getHeight())));
views.get("pnlleft").vw.setHeight((int)((views.get("pnlbottom").vw.getTop()) - ((views.get("pnltop").vw.getHeight()))));
//BA.debugLineNum = 16;BA.debugLine="PnlRight.SetLeftAndRight(PnlFocus.Left+PnlFocus.Width,100%x)"[layscanner/General script]
views.get("pnlright").vw.setLeft((int)((views.get("pnlfocus").vw.getLeft())+(views.get("pnlfocus").vw.getWidth())));
views.get("pnlright").vw.setWidth((int)((100d / 100 * width) - ((views.get("pnlfocus").vw.getLeft())+(views.get("pnlfocus").vw.getWidth()))));
//BA.debugLineNum = 17;BA.debugLine="PnlRight.SetTopAndBottom(PnlTop.Height,PnlBottom.Top)"[layscanner/General script]
views.get("pnlright").vw.setTop((int)((views.get("pnltop").vw.getHeight())));
views.get("pnlright").vw.setHeight((int)((views.get("pnlbottom").vw.getTop()) - ((views.get("pnltop").vw.getHeight()))));
//BA.debugLineNum = 18;BA.debugLine="LblBarCode.Width=100%x"[layscanner/General script]
views.get("lblbarcode").vw.setWidth((int)((100d / 100 * width)));

}
}