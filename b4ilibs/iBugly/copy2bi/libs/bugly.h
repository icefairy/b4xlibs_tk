//
//  bugly.h
//  bugly
//
//  Created by kaopuedu on 2016/12/6.
//  Copyright © 2016年 kaopuedu. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "iCore.h"
@class B4I;
//~shortname:iBugly
//~author:icefairy333
//~version:1.00
//~dependson:SystemConfiguration.framework
//~dependson:Security.framework
//~dependson:Bugly.framework.3
//~dependson:libc++.tbd
//~dependson:libz.tbd
@interface bugly : NSObject
- (void)Initialize:(B4I *)bi :(NSString *)apikey;
@end
