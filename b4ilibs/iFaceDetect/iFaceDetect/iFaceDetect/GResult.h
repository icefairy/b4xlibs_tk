//
//  GResult.h
//  YYFaceWidget
//
//  Created by yytech_mac01 on 14-3-26.
//
//
#import <Foundation/Foundation.h>
@interface GResult : NSObject

@property (nonatomic, copy)  NSString* imgBase64;       //图像的Base64编码
@property (nonatomic, copy)  NSString* returnCode;      //控件返回码，详见返回代码表
@property (nonatomic, copy)  NSString* version;         //当前系统控件版本号
//@property (nonatomic, copy)  NSString* deviceId;      //传入设备ID
@property (nonatomic, copy)  NSString* camType;          //摄像头类型（待定，目前作为预留字段）
@property (nonatomic, copy) NSString* resultMsg;        //返回类型描述

@property (nonatomic, copy)NSString *cryptKey;      //加密证件号或因子
@property (nonatomic,copy)NSString *photoSeqNo;     //照片流水值


@end
