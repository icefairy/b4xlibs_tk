//
//  MInfo.h
//  YYFaceWidget 15-30-39-602
//
//  Created by yytech_mac01 on 14-3-10.
//
//

#import <Foundation/Foundation.h>

@interface SInfo : NSObject

@property (nonatomic, copy) NSString*  InitXMLStr;         //当前系统最新控件版本
@property (nonatomic, copy) NSString*  CustomInfo;      //当前客户身份证号,//终端号 12位
@property (nonatomic, copy) NSString*  Serialno;        //当前业务流水号,//token号10 位

@end
