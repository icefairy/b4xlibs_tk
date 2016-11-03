//
//  YYFaceView.h
//  YYFaceWidget
//
//  Created by yytech_mac01 on 14-3-27.
//
//

#import <UIKit/UIKit.h>


@class SInfo;
@class MInfo;
@class GResult;

@interface YYFaceView : UIView


/*
 *  是否开启微视窗功能，YES 表示开启; 开启之后，采集页面上的采集框将被取消,默认NO；
 */
@property (nonatomic,assign)BOOL microModel;


#pragma mark 稳定版本

/**
 *  显示采集视图
 */
- (void)showView;

/**
 *  开始采集
 *
 *  @param sinfo xml串及加密等参数
 *  @param block 采集完成回调的block
 */
- (void)startCaptureWithParam:(SInfo *)sinfo andResult :(void (^)(GResult *result)) block;



/**
 *  仅限控件内显示采集结果
 */
- (void)showImgA;


/**
 *  前后摄像头切换
 *
 *  @param animated 切换动画
 */
- (void)switchFrontAndBackCameras:(BOOL)animated;//切换摄像头

/**
    处理设备旋转需要实现如下两个方法，实现方式固定，见Demo
 */
//设备旋转前
- (void)willAnimateRotationToInterfaceOrientation:(UIInterfaceOrientation)toInterfaceOrientation duration:(NSTimeInterval)duration;

//设备旋转完
- (void)didRotateFromInterfaceOrientation:(UIInterfaceOrientation)fromInterfaceOrientation;


#pragma mark 控件升级新增加的


/**
 *  XML 串配置信息解析
 *
 *  @param xmlConfig 后台返回的xml串
 */
- (void)setXMLConfig:(NSString *)xmlConfig;


/**
 *  检测摄像头是否可以打开
 *
 *  @return YES,可以打开; 反之NO
 */
- (BOOL)checkDevice;

/**
 *  打开摄像头，并准备采集；同上showView
 *
 *  @return ，YES，打开成功；反之NO
 */
- (BOOL)openDevice;


/**
 *  关闭摄像头，并结束一切采集活动, 
 *
 *  @return YES关闭成功，反之NO
 */
- (BOOL)closeDevice;


/**
 *  开始采集，同上面startCapture
 *
 *  @param sinfo xml或是加密参数
 *  @param block 完成采集回调的block
 */
- (void)startCaptureWithParam:(SInfo *)sinfo andResultB:(void (^)(GResult *result))block;


@end
