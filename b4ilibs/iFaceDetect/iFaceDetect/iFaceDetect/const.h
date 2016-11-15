//
//  const.h
//  YYCameraController 15-30-39-602
//
//  Created by yytech_mac01 on 14-2-28.
//
//

#ifndef const_h
#define const_h

typedef enum FaceOperationType {
    FaceOperationTypeNone   = -1,
    FaceOperationTypeEnroll = 0,
    FaceOperationTypeVerify = 1,
    FaceOperationTypeModify = 2,
    FaceOperationTypeCheck  = 3,
    
    FaceOperationTypeCapture = 4
} FaceOperationType;


#define  kCropRate              0.8f            //add by cc to determine crop rect
#define  kDefaultTimeOut        15.0f             //add by cc

#define  kMySelfVersion         @"v1.1.5"     //add by cc

////////////////////////////   返回码    //////////////////////////////
//typedef NS_ENUM(NSInteger, ReturnCode) {
//    kReturnCodeSuccess           = 0,        // 操作成功
//    kReturnCodeTimeOut           = -1,       // 抓取人脸超时
//    kReturnCodeNoActive          = -2,       // 检测未通过
//    kReturnCodeNoMac             = -3,       // 获取Mac地址失败
//    kReturnCodeParamError        = -4,       // 参数错误
//    kReturnCodeNoDevice          = -5,       // 没发现设备
//    kReturnCodeOpenDeviceError   = -6,       // 打开设备失败
//    kReturnCodeDeviceDisconnect  = -7,       // 设备断开
//    kReturnCodeDeviceBusy        = -8        // 设备忙
//};
#define      kReturnCodeSuccess            @"0"        // 操作成功
#define      kReturnCodeTimeOut            @"-1"       // 抓取人脸超时
#define      kReturnCodeNoActive           @"-2"       // 检测未通过
#define      kReturnCodeNoMac              @"-3"       // 获取Mac地址失败
#define      kReturnCodeParamError         @"-4"       // 参数错误
#define      kReturnCodeNoDevice           @"-5"       // 没发现设备
#define      kReturnCodeOpenDeviceError    @"-6"       // 打开设备失败
#define      kReturnCodeDeviceDisconnect   @"-7"       // 设备断开
#define      kReturnCodeDeviceBusy         @"-8"        // 设备忙

////////////////////////////   返回码说明    //////////////////////////////
#define      kReturnCodeSuccessMsg            @"操作成功"
#define      kReturnCodeTimeOutMsg            @"抓取人脸超时"
#define      kReturnCodeNoActiveMsg           @"检测未通过"
#define      kReturnCodeNoMacMsg              @"获取Mac地址失败"
#define      kReturnCodeParamErrorMsg         @"参数错误"
#define      kReturnCodeNoDeviceMsg           @"没发现设备"
#define      kReturnCodeOpenDeviceErrorMsg    @"打开设备失败"
#define      kReturnCodeDeviceDisconnectMsg   @"设备断开"
#define      kReturnCodeDeviceBusyMsg         @"设备忙"

#endif
