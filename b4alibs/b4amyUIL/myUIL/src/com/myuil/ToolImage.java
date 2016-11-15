package com.myuil;

import java.io.File;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.utils.StorageUtils;

import android.content.Context;
import android.graphics.Bitmap;

public abstract class ToolImage {

	private static ImageLoader imageLoader;


	public static ImageLoader initImageLoader(Context context) {
		File cacheDir = StorageUtils.getOwnCacheDirectory(context,"ImageLoader/Cache");
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
		.memoryCacheExtraOptions(480, 800)
		// Can slow ImageLoader, use it carefully (Better don't use it)
		// .discCacheExtraOptions(480, 800, CompressFormat.JPEG, 75,null)
		.threadPoolSize(3)
		.threadPriority(Thread.NORM_PRIORITY - 2)
		/*
		 * When you display an image in a small ImageView and later you
		 * try to display this image (from identical URI) in a larger
		 * ImageView so decoded image of bigger size will be cached in
		 * memory as a previous decoded image of smaller size. So the
		 * default behavior is to allow to cache multiple sizes of one
		 * image in memory. You can deny it by calling this method: so
		 * when some image will be cached in memory then previous cached
		 * size of this image (if it exists) will be removed from memory
		 * cache before.
		 */
		// .denyCacheImageMultipleSizesInMemory()
		// You can pass your own memory cache implementation
		.memoryCache(new UsingFreqLimitedMemoryCache(20 * 1024 *1024))
		.memoryCacheSize(20 * 1024 * 1024)
		.diskCacheFileCount(1000)
		.diskCacheSize(50 * 1024 * 1024)
		.diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
		.tasksProcessingOrder(QueueProcessingType.LIFO)
		//.defaultDisplayImageOptions(DisplayImageOptions.createSimple())
		//.imageDownloader(new BaseImageDownloader(context, 5 * 1000,30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
		.build();

		
		imageLoader = ImageLoader.getInstance();
		imageLoader.init(config);
		
		return imageLoader;
	}
	

	public static DisplayImageOptions getFadeOptions(int loadingImageResId,int errorImageResid,int emptyImageResId ) {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
	
		.showStubImage(loadingImageResId)
	
		.showImageOnFail(errorImageResid)
	
		.showImageForEmptyUri(emptyImageResId)
	
		 .cacheInMemory(true)

		.cacheOnDisk(true)
	
		.imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
		
		.bitmapConfig(Bitmap.Config.RGB_565)
		
		.delayBeforeLoading(100)
		
		.displayer(new FadeInBitmapDisplayer(1*1000))
		.build();
		return options;
	}
	

	public static DisplayImageOptions getDefaultOptions(){
		return DisplayImageOptions.createSimple();
	}

	
	public static void clearCache() {
		imageLoader.clearMemoryCache();
		imageLoader.clearDiskCache();
	}
	
	public static ImageLoader getImageLoader(){
		return imageLoader;
	}
}
