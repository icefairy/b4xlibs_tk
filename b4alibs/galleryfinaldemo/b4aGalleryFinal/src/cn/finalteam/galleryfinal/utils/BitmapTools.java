package cn.finalteam.galleryfinal.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import anywheresoftware.b4a.BA;
import cn.finalteam.toolsfinal.io.stream.ByteArrayOutputStream;

public class BitmapTools {
	public static int readPictureDegree(String path) {
	    int degree  = 0;
	    try {
	        ExifInterface exifInterface = new ExifInterface(path);
	        int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
	        switch (orientation) {
	            case ExifInterface.ORIENTATION_ROTATE_90:
	                degree = 90;
	                break;
	            case ExifInterface.ORIENTATION_ROTATE_180:
	                degree = 180;
	                break;
	            case ExifInterface.ORIENTATION_ROTATE_270:
	                degree = 270;
	                break;
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return degree;
	}
	public static Bitmap rotaingImageView(int angle , Bitmap bitmap) {
	    //旋转图片 动作
	    Matrix matrix = new Matrix();;
	    matrix.postRotate(angle);
	    //System.out.println("angle2=" + angle);
	    // 创建新的图片
	    Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
	            bitmap.getWidth(), bitmap.getHeight(), matrix, true);
	    return resizedBitmap;
	}
	public static Bitmap loadimg(String path) {
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
	    //开始读入图片，此时把options.inJustDecodeBounds 设回true了
		//newOpts.inJustDecodeBounds = false; //这里是只读取边界
	    Bitmap bitmap = BitmapFactory.decodeFile(path,newOpts);//此时返回bm为空
	    return bitmap;
	}
	public static void saveimg(String path,Bitmap bmp) {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		 OutputStream os;
		  try {
		    os = new FileOutputStream(path);
		    bmp.compress(Bitmap.CompressFormat.JPEG, 100, os);
		    os.flush();
		    os.close();
		  } catch (Exception e) {
		    BA.LogError(e.getMessage());
		  }
	}
	public static Bitmap getimage(String srcPath) {
	    BitmapFactory.Options newOpts = new BitmapFactory.Options();
	    //开始读入图片，此时把options.inJustDecodeBounds 设回true了
	    newOpts.inJustDecodeBounds = true;
	    Bitmap bitmap = BitmapFactory.decodeFile(srcPath,newOpts);//此时返回bm为空

	    newOpts.inJustDecodeBounds = false;
	    int w = newOpts.outWidth;
	    int h = newOpts.outHeight;
	    //现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
	    float hh = 800f;//这里设置高度为800f
	    float ww = 480f;//这里设置宽度为480f
	    //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
	    int be = 1;//be=1表示不缩放
	    if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
	        be = (int) (newOpts.outWidth / ww);
	    } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
	        be = (int) (newOpts.outHeight / hh);
	    }
	    if (be <= 0)
	        be = 1;
	    newOpts.inSampleSize = be;//设置缩放比例
	    //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
	    bitmap = BitmapFactory.decodeFile(srcPath, newOpts);
	    return compressImage(bitmap);//压缩好比例大小后再进行质量压缩
	}
	public static Bitmap compressImage(Bitmap image) {

	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
	    int options = 100;
	    while ( baos.toByteArray().length / 1024>100) {	//循环判断如果压缩后图片是否大于100kb,大于继续压缩
	        baos.reset();//重置baos即清空baos
	        image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
	        options -= 10;//每次都减少10
	    }
	    ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
	    Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
	    return bitmap;
	}
}
