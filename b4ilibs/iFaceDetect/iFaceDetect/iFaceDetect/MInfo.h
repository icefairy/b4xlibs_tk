//
//  MInfo.h
//  YYFaceWidget 15-30-39-602
//
//  Created by yytech_mac01 on 14-3-10.
//
//

#import <Foundation/Foundation.h>
#import "SInfo.h"

@interface MInfo : NSObject
@property (nonatomic, assign)NSInteger imgWidth;     //控件宽度
@property (nonatomic, assign)NSInteger imgHeight;     //控件高度

@property (nonatomic, assign)NSInteger imgCompress;     //图像压缩比(0-100)，0图片质量最差，100图像质量最好
@property (nonatomic, assign)NSInteger pupilDistMin;	//瞳孔间距最小值，小于最小值不进行抓取
@property (nonatomic, assign)NSInteger pupilDistMax;	//瞳孔间距最大值，大于最大值不进行抓取

@property (nonatomic, assign)NSInteger isActived;       //是否进行活体检测
@property (nonatomic, assign)NSInteger isAudio;         //是否进行语音提示
@property (nonatomic, assign)NSInteger timeOut;         //抓取人脸超时时间，毫秒为单位

//@property (nonatomic, assign)NSInteger showConfirmMenu; //确认菜单

@property (nonatomic, copy) NSString*  deviceIdx;         //系统调用摄像头ID
@property (nonatomic, copy) NSString*  definitionAsk;     //清晰度值
@property (nonatomic, copy) NSString*  cryptType;         //是否进行加密
@property (nonatomic, copy) NSString*  interfaceType;         //是否自助 1YES


@property (nonatomic, copy) NSString*  version;         //当前系统最新控件版本
@property (nonatomic,copy)NSString *cryptKey;           //加密因子
@property (nonatomic,copy)NSString *action;           //配置的检活动作
@property (nonatomic,copy)NSString *headLeft;           //左转头预值
@property (nonatomic,copy)NSString *headRight;           //右转头预值
@property (nonatomic,copy)NSString *headLow;           //低头值
@property (nonatomic,copy)NSString *headHigh;           //抬头值
@property (nonatomic,copy)NSString *eyeDegree;           //闭眼值
@property (nonatomic,copy)NSString *mouthDegree;           //张嘴值

@property (nonatomic,copy)NSString *outType;           //图像输出模式，单图多图模式
@property (nonatomic,copy)NSString *supportLow;        //是否支持4和4s


@property (nonatomic,retain)SInfo *sinfo;

@end
