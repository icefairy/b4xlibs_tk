//
//  iPingpp.h
//  iPingpp
//
//  Created by kaopuedu on 2017/1/10.
//  Copyright © 2017年 kaopuedu. All rights reserved.
//
#import "iCore.h"
#import "Pingpp.h"
#import <Foundation/Foundation.h>
//~shortname:iPingpp
//~author:icefairy333
//~event:onPayResult(merr as Map)
//~version:1.00
//~dependson:CFNetwork.framework
//~dependson:SystemConfiguration.framework
//~dependson:Security.framework
//~dependson:QuartzCore.framework
//~dependson:CoreTelephony.framework
//~dependson:CoreMotion.framework
//~dependson:AlipaySDK.framework.3
//~dependson:libc++.tbd
//~dependson:libz.tbd
//~dependson:libsqlite3.0.tbd
//~dependson:libstdc++.tbd
@interface iPingppWrapper : B4IObjectWrapper
- (void) Initinlize:(B4I *)bi :(NSString *)eventname;
- (void) createPayment:(NSString *)charge :(NSString *)kUrlScheme;
- (BOOL) HandleOpenUrl:(NSString *)url;
@end
