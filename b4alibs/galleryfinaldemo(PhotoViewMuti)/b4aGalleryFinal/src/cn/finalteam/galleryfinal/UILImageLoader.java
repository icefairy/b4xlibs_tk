/*
 * Copyright (C) 2014 pengjianbo(pengjianbosoft@gmail.com), Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.finalteam.galleryfinal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import anywheresoftware.b4a.BA;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import cn.finalteam.galleryfinal.widget.GFImageView;

/**
 * Desction:
 * Author:pengjianbo
 * Date:15/10/10 下午5:52
 */
public class UILImageLoader implements cn.finalteam.galleryfinal.ImageLoader {

    private Bitmap.Config mImageConfig;
    private DisplayImageOptions options;

    public UILImageLoader() {
        this(Bitmap.Config.RGB_565);
        options = new DisplayImageOptions.Builder()
                .cacheOnDisk(false)
                .showImageForEmptyUri(R.drawable.ic_gf_default_photo)//为空时
                .showImageOnFail(R.drawable.ic_gf_default_photo)//加载失败的图片
                .showImageOnLoading(R.drawable.pic_load_more)//加载中的图片
                .cacheInMemory(false)
                .bitmapConfig(mImageConfig)
                .build();
    }

    public UILImageLoader(Bitmap.Config config) {
        this.mImageConfig = config;
        options = new DisplayImageOptions.Builder()
                .cacheOnDisk(false)
                .cacheInMemory(false)
                .bitmapConfig(mImageConfig)
                .build();
    }

    @Override
    public void displayImage(Activity activity, String path, GFImageView imageView, Drawable defaultDrawable, int width, int height) {
        ImageSize imageSize = new ImageSize(width, height);
        if (path.indexOf("http") == -1) {
        	//路径
            ImageLoader.getInstance().displayImage("file://" + path, new ImageViewAware(imageView), options, imageSize, null, null);
		}else {
			//URL(path, new ImageViewAware(imageView), options, listener)
			final ImageViewAware imagevaAware=new ImageViewAware(imageView);
            ImageLoader.getInstance().displayImage(path, imagevaAware, options, imageSize, new ImageLoadingListener()
            {
        		@Override
        		public void onLoadingCancelled(String arg0, View arg1) {
        			// TODO Auto-generated method stub 
        			//图片加载取消调用  
                    Log.d("zttjiangqq","onLoadingCancelled...");  
                    BA.Log("onLoadingCancelled...");
        		}
        		@Override
        		public void onLoadingComplete(String arg0, View arg1, Bitmap arg2) {
        			// TODO Auto-generated method stub    
        			//图片加载完成调用  
                    Log.d("zttjiangqq","onLoadingComplete...");
                    BA.Log("onLoadingComplete...");
                    imagevaAware.setImageBitmap(arg2);
        		}
        		@Override
        		public void onLoadingFailed(String arg0, View arg1, FailReason arg2) {
        			// TODO Auto-generated method stub   
                    //图片加载失败调用  
                    Log.d("zttjiangqq","onLoadingFailed...");   
                    BA.Log("onLoadingFailed...");
                     
        			
        		}
        		@Override
        		public void onLoadingStarted(String arg0, View arg1) {
        			// TODO Auto-generated method stub  
        			//图片开始加载的时候调用  
                    Log.d("zttjiangqq","onLoadingStarted...");    
                    BA.Log("onLoadingStarted...");
        		}  
              }, null);
		}
    }
    /**
     * 载入网络图片
     * @param paramString
     * @param paramImageView
     * @param paramInt1 width
     * @param paramInt2 height
     */
    public void loadSizedImg(String paramString, final GFImageView paramImageView, int paramInt1, int paramInt2)
    {
      ImageSize ImageSize  = new ImageSize(paramInt1, paramInt2);
      ImageLoader.getInstance().loadImage(paramString, ImageSize, options, new ImageLoadingListener()
      {
		@Override
		public void onLoadingCancelled(String arg0, View arg1) {
			// TODO Auto-generated method stub 
			//图片加载取消调用  
            Log.d("zttjiangqq","onLoadingCancelled...");  
            BA.Log("onLoadingCancelled...");
		}
		@Override
		public void onLoadingComplete(String arg0, View arg1, Bitmap arg2) {
			// TODO Auto-generated method stub    
			//图片加载完成调用  
            Log.d("zttjiangqq","onLoadingComplete...");
            BA.Log("onLoadingComplete...");
            paramImageView.setImageBitmap(arg2);  
			
		}
		@Override
		public void onLoadingFailed(String arg0, View arg1, FailReason arg2) {
			// TODO Auto-generated method stub   
            //图片加载失败调用  
            Log.d("zttjiangqq","onLoadingFailed...");  
            BA.Log("onLoadingFailed...");
             
			
		}
		@Override
		public void onLoadingStarted(String arg0, View arg1) {
			// TODO Auto-generated method stub  
			//图片开始加载的时候调用  
            Log.d("zttjiangqq","onLoadingStarted...");    
            BA.Log("onLoadingStarted...");
		}  
      });
    }

    @Override
    public void clearMemoryCache() {
    	ImageLoader.getInstance().clearMemoryCache();
    }
}