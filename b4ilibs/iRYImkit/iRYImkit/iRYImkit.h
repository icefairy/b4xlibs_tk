//
//  iRYImkit.h
//  iRYImkit
//
//  Created by kaopuedu on 2016/11/28.
//  Copyright © 2016年 kaopuedu. All rights reserved.
//
#import <Foundation/Foundation.h>
#import "iCore.h"
#import <RongIMKit/RongIMKit.h>
@class B4I;
//~shortname:iRYImkit
//~author:icefairy333
//~event:onSuccess(userid as String)
//~event:onError(code as Int)
//~event:onTokenIncorrect
//~event:reqUserInfo(userId as String) As Map
//~version:1.10
//~dependson:AssetsLibrary.framework
//~dependson:AudioToolbox.framework
//~dependson:AVFoundation.framework
//~dependson:CFNetwork.framework
//~dependson:CoreAudio.framework
//~dependson:CoreGraphics.framework
//~dependson:CoreLocation.framework
//~dependson:CoreMedia.framework
//~dependson:CoreTelephony.framework
//~dependson:CoreVideo.framework
//~dependson:ImageIO.framework
//~dependson:libc++.tbd
//~dependson:libc++abi.tbd
//~dependson:libsqlite3.tbd
//~dependson:libstdc++.tbd
//~dependson:libxml2.tbd
//~dependson:libz.tbd
//~dependson:MapKit.framework
//~dependson:OpenGLES.framework
//~dependson:QuartzCore.framework
//~dependson:SystemConfiguration.framework
//~dependson:UIKit.framework
//~dependson:Photos.framework
//~dependson:SafariServices.framework
//~dependson:RongIMKit.framework.3
//~dependson:RongIMLib.framework.3
//~dependson:opencore-amrnb
@interface iRYImkit : NSObject<RCIMUserInfoDataSource>
- (void)Initialize:(B4I *)bi :(NSString *)EventName :(NSString *)apikey;
/*!
 建立连接返回的错误码
 tokenerror=1
 @discussion
 开发者仅需要关注以下几种连接错误码，其余错误码SDK均会进行自动重连，开发者无须处理。
 RC_CONN_ID_REJECT, RC_CONN_TOKEN_INCORRECT, RC_CONN_NOT_AUTHRORIZED,
 RC_CONN_PACKAGE_NAME_INVALID, RC_CONN_APP_BLOCKED_OR_DELETED,
 RC_CONN_USER_BLOCKED,
 RC_DISCONN_KICK, RC_CLIENT_NOT_INIT, RC_INVALID_PARAMETER, RC_INVALID_ARGUMENT
 */
- (void)Connect:(NSString *)token;

- (void)Disconnect;

- (void)ChatWith:(NSString *)targetid :(NSString *)title :(B4INavigationControllerWrapper *)nav;

- (void)ShowChatList:(B4INavigationControllerWrapper *)nav;

- (void)ChatWithCustomerService:(NSString *)clientid :(B4INavigationControllerWrapper *)nav :(NSString *)selfnick :(NSString *)selfimg;
@end
