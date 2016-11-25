//
//  iShareSdk.h
//  iShareSdk
//
//  Created by kaopuedu on 2016/11/25.
//  Copyright © 2016年 kaopuedu. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "iCore.h"
@class B4I;
//~shortname:iShareSdk
//~event:gotimg(imgBase64 As String)
//~event:goterr(msg As String)
//~event:gotresult
//~version:1.00
//~dependson:ShareSDK.framework.3
//~dependson:MOBFoundation.framework.3
//~dependson:ShareSDKConnector.framework.3
//~dependson:ShareSDKExtension.framework.3
//~dependson:CopyConnector.framework.3
//~dependson:MailConnector.framework.3
//~dependson:QQConnector.framework.3
//~dependson:SMSConnector.framework.3
//~dependson:WechatConnector.framework.3
//~dependson:WeChatSDK
//~dependson:MessageUI.framework
//~dependson:ShareSDKUI.framework.3
//~dependson:ShareSDKConfigFile.framework.3
//~dependson:TencentOpenAPI.framework.3
//~dependson:libicucore.tbd
//~dependson:libz.tbd
//~dependson:libstdc++.tbd
//~dependson:JavaScriptCore.framework
//~dependson:libsqlite3.tbd
@interface iShareSdk : NSObject
-(void)RegisterApp:(NSString *)qqappid:(NSString *)qqkey:(NSString *)wxappid:(NSString *)wxkey;
-(void)ShowShare:(NSString *)title:(NSString *)weburl:(NSString *)sharecontent:(NSString *)imgurl;
@end
