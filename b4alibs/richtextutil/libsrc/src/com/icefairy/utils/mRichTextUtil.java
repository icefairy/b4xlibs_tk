package com.icefairy.utils;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;

import org.xml.sax.XMLReader;

import java.io.IOException;

import anywheresoftware.b4a.BA;

@BA.ShortName("RichTextUtil")
@BA.Author("Icefairy333")
@BA.Version(1.00f)
public class mRichTextUtil {
    private static mRichTextUtil rtu =null;
    private static SpannableStringBuilder ssb=null;
    private static Context ctx;
    @BA.Hide
    public static mRichTextUtil getInst(Context context){
        rtu =new mRichTextUtil();
        ssb=new SpannableStringBuilder();
        ctx=context;
        return rtu;
    }
    public static mRichTextUtil getInst(){
        rtu =new mRichTextUtil();
        ssb=new SpannableStringBuilder();
        ctx=BA.applicationContext;
        return rtu;
    }
    /**
    reset the builder
     */
    public mRichTextUtil newSSB(){
        ssb=new SpannableStringBuilder();
        return rtu;
    }
    public mRichTextUtil addString(String str){
        ssb.append(str);
        return rtu;
    }
    public mRichTextUtil addColor(String str,int ColorVal){
        int pos=ssb.length();
        ssb.append(str);
        ssb.setSpan(new ForegroundColorSpan(ColorVal), pos, pos+ str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return rtu;
    }
    /**
    unit is px
     */
    public mRichTextUtil addSize(String str,int size){
        int pos=ssb.length();
        ssb.append(str);
        ssb.setSpan(new AbsoluteSizeSpan(size), pos, pos + str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return rtu;
    }
    public mRichTextUtil addRelativeSize(String str,float size){
        int pos=ssb.length();
        ssb.append(str);
        ssb.setSpan(new RelativeSizeSpan(size), pos, pos + str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return rtu;
    }
    public mRichTextUtil addDeleteLine(String str){
        int pos=ssb.length();
        ssb.append(str);
        ssb.setSpan(new StrikethroughSpan(), pos, pos + str.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return rtu;
    }
    public mRichTextUtil addHTMLString(String htmlstr, final int imgw, final int imgh){
        int pos=ssb.length();
        ssb.append(Html.fromHtml(htmlstr, new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String s) {
                int resid=ctx.getResources().getIdentifier(s,"drawable",ctx.getPackageName());
                Drawable dw;
                if (resid>0){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        dw=ctx.getDrawable(resid);
                    }else{
                        dw=ctx.getResources().getDrawable(resid);
                    }
                }else {
                    //load from assets
                    try {
                        BitmapDrawable bd=new BitmapDrawable(ctx.getAssets().open(s));
                        dw=bd;
                    } catch (IOException e) {
                        e.printStackTrace();
                        ColorDrawable cd=new ColorDrawable(Color.rgb(255,255,255));
                        dw=cd;
                    }
                }

                dw.setBounds(0,0,imgw,imgh);
                return dw;
            }
        }, null));
        return rtu;
    }
    public SpannableStringBuilder getRichString(){
        return ssb;
    }
}
