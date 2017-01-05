Type=Class
Version=3.48
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
#Event:onSelect(imgpath As String)
Sub Class_Globals
	Dim cam As Camera
	Dim ac As ActionSheet
	Private mPg As Page
	Private mCb As Object,mEn As String
	Private pg As Page
	Public newbmp As Bitmap
	Private cvzi As cviZoomableImageView
	Private prect As Panel
	Private bMove As Boolean=False
	Private fx,fy As Float
	Private f as Float
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(cb As Object,en As String,pg1 As Page)
	cam.Initialize("cam",pg1)
	mCb=cb
	mPg=pg1
	mEn=en.ToLowerCase
End Sub
Public Sub show(title As String)
	ac.Initialize("ac",title,"取消","相册",Array As String("相机"))
	ac.Show(mPg.RootPanel)
End Sub
Sub ac_Click (Item As String)
	Select Item.ToLowerCase
		Case "相册"
			cam.SelectFromPhotoLibrary(Null,cam.TYPE_ALL)
		Case "相机"
			If cam.IsSupported Then
				cam.TakePicture
			Else
				Msgbox("当前设备不支持拍照","错误")
			End If
	End Select
End Sub
Sub cam_Complete (Success As Boolean, Image As Bitmap, VideoPath As String)
	If Success Then
		newbmp=fixOrientation_image(Image)
		Msgbox2("crop","你要对照片进行裁剪吗？为了更好的显示效果，我们强烈建议您进行裁剪。","裁剪",Array("裁剪","不裁剪"))
	Else
		comm.TL("选择图片或拍照失败")
	End If
	
End Sub
Sub crop_Click(it As String)
	If it.EqualsIgnoreCase("裁剪") Then
		pg.Initialize("pg")
		pg.RootPanel.Color=0xFFf5f5f5
		pg.RootPanel.LoadLayout("laycrop")
		Dim bb As 	BarButton
		bb.InitializeText("确定","ok")
		pg.Title="裁剪图片"
		pg.TopRightButtons=Array(bb)
		comm.SetPageTitleColor(comm.clrTitleTxt,comm.clrTitleBG,True,1)
		Main.NavControl.ShowPage(pg)
		Dim nw As Float=pg.RootPanel.Width*pg.RootPanel.Height/(newbmp.Width*newbmp.Height)
'		cvzi.MinScale=nw/2
		cvzi.MaxScale=3
		'at last set the bitmap
		cvzi.Bitmap=newbmp
		
	Else
		retBmp
	End If
End Sub
Sub pg_Resize (Width As Float, Height As Float)
	Log("cvzi:"&cvzi.ImageView.Width&"*"&cvzi.ImageView.Height)
	cvzi.AsView.ScrollOffsetX=0
	cvzi.AsView.ScrollOffsetY=0
End Sub
Sub prect_Touch(Action As Int, X As Float, Y As Float)
	Select Action
		Case prect.ACTION_DOWN
			bMove=True
			fx=X-prect.Left
			fy=Y-prect.Top
		Case prect.ACTION_UP
			prect.Left=x-fx
			prect.Top=y-fy
			bMove=False
		Case prect.ACTION_MOVE
			If bMove Then
				prect.Left=X-fx
				prect.Top=y-fy
			End If
	End Select
End Sub
Sub pg_BarButtonClick (Tag As String)
	If Tag.EqualsIgnoreCase("ok") Then
		Dim fl,ft,fw,fh As Float
		fl=prect.Left'/cvzi.AsView.Width'*cvzi.Bitmap.Width
		ft=prect.Top'/cvzi.AsView.Height'*cvzi.Bitmap.Height
		fw=prect.Width'/cvzi.AsView.Width'*cvzi.Bitmap.Width
		fh=prect.Height'/cvzi.AsView.Height'*cvzi.Bitmap.Height
		Log("rect:"&fl&","&ft&","&fw&","&fh)
'		newbmp=cvzi.ZoomedImageArea(prect.Left,prect.Top,prect.Width,prect.Height)
		newbmp=cvzi.ZoomedImageArea(fl,ft,fw,fh)
		Main.NavControl.RemoveCurrentPage
		retBmp
	End If
End Sub

Sub pg_Appear
	comm.showPageTitle(True)
End Sub

Sub retBmp
	Dim fn As String=Rnd(1000,99999)&".jpg"
	Dim ops As OutputStream= File.OpenOutput(File.DirTemp,fn,False)
	newbmp.WriteToStream(ops,100,"JPEG")
	ops.Close
	Dim path As String=File.Combine(File.DirTemp,fn)
	Log(path)
	comm.compressIMG(path,comm.MAX_PIC_SIZE_KB)
	Log(SubExists(mCb,mEn&"_onSelect",1))
	CallSub2(mCb,mEn&"_onSelect",path)
End Sub

Private Sub fixOrientation_image(bmp As Bitmap) As Bitmap
	Dim no As NativeObject = Me
	Return no.RunMethod("fixOrientation:", Array(bmp))
End Sub

#if OBJC
- (UIImage *)fixOrientation:(UIImage *)aImage {

    // No-op if the orientation is already correct
    if (aImage.imageOrientation == UIImageOrientationUp) 
        return aImage;

    // We need to calculate the proper transformation to make the image upright.
    // We do it in 2 steps: Rotate if Left/Right/Down, and then flip if Mirrored.
    CGAffineTransform transform = CGAffineTransformIdentity;

    switch (aImage.imageOrientation) {
        case UIImageOrientationDown:
        case UIImageOrientationDownMirrored:
            transform = CGAffineTransformTranslate(transform, aImage.size.width, aImage.size.height);
            transform = CGAffineTransformRotate(transform, M_PI);
            break;

        case UIImageOrientationLeft:
        case UIImageOrientationLeftMirrored:
            transform = CGAffineTransformTranslate(transform, aImage.size.width, 0);
            transform = CGAffineTransformRotate(transform, M_PI_2);
            break;

        case UIImageOrientationRight:
        case UIImageOrientationRightMirrored:
            transform = CGAffineTransformTranslate(transform, 0, aImage.size.height);
            transform = CGAffineTransformRotate(transform, -M_PI_2);
            break;
        default:
            break;
    }

    switch (aImage.imageOrientation) {
        case UIImageOrientationUpMirrored:
        case UIImageOrientationDownMirrored:
            transform = CGAffineTransformTranslate(transform, aImage.size.width, 0);
            transform = CGAffineTransformScale(transform, -1, 1);
            break;

        case UIImageOrientationLeftMirrored:
        case UIImageOrientationRightMirrored:
            transform = CGAffineTransformTranslate(transform, aImage.size.height, 0);
            transform = CGAffineTransformScale(transform, -1, 1);
            break;
        default:
            break;
    }

    // Now we draw the underlying CGImage into a new context, applying the transform
    // calculated above.
    CGContextRef ctx = CGBitmapContextCreate(NULL, aImage.size.width, aImage.size.height,
                                             CGImageGetBitsPerComponent(aImage.CGImage), 0,
                                             CGImageGetColorSpace(aImage.CGImage),
                                             CGImageGetBitmapInfo(aImage.CGImage));
    CGContextConcatCTM(ctx, transform);
    switch (aImage.imageOrientation) {
        case UIImageOrientationLeft:
        case UIImageOrientationLeftMirrored:
        case UIImageOrientationRight:
        case UIImageOrientationRightMirrored:
            // Grr...
            CGContextDrawImage(ctx, CGRectMake(0,0,aImage.size.height,aImage.size.width), aImage.CGImage);
            break;

        default:
            CGContextDrawImage(ctx, CGRectMake(0,0,aImage.size.width,aImage.size.height), aImage.CGImage);
            break;
    }

    // And now we just create a new UIImage from the drawing context
    CGImageRef cgimg = CGBitmapContextCreateImage(ctx);
    UIImage *img = [UIImage imageWithCGImage:cgimg];
    CGContextRelease(ctx);
    CGImageRelease(cgimg);
    return img;
}
#end if