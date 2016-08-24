package b4j.example.designerscripts;
import anywheresoftware.b4a.BA;


public class LS_laymain{

public static void LS_general(anywheresoftware.b4j.objects.LayoutBuilder.LayoutData views, int width, int height, float scale) {
;
//BA.debugLineNum = 2;BA.debugLine="edtJson.Width=40%x"[laymain/General script]
views.get("edtjson").setPrefWidth((int)((40d / 100 * width)));
//BA.debugLineNum = 3;BA.debugLine="edtcode.Width=55%x"[laymain/General script]
views.get("edtcode").setPrefWidth((int)((55d / 100 * width)));
//BA.debugLineNum = 4;BA.debugLine="edtcode.Right=100%x-10"[laymain/General script]
views.get("edtcode").setLeft((int)((100d / 100 * width)-10d - (views.get("edtcode").getPrefWidth())));

}
}