package com.icefairy;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;

@ShortName("httpsmixedcontent")
@Author("icefairy333")
@Version(1.00f)
public class httpsmixedcontent{
	public void enablemaxedcontent(WebView wv){
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			wv.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
		}
	}
}