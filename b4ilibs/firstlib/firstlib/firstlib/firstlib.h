//
//  firstlib.h
//  firstlib
//
//  Created by kaopuedu on 16/10/26.
//  Copyright © 2016年 kaopuedu. All rights reserved.
//
#import "iCore.h"
#import <Foundation/Foundation.h>
@class B4I;
//~shortname:firstlib
//~author:icefairy333
//~event:gotmsg(msg as String)
//~event:noparam
//~event:gotmsg2(msg as String,code as Int)
//~version:1.01
@interface firstlib :B4IObjectWrapper
- (void)Initialize:(B4I *)bi :(NSString *)EventName :(NSString *)param ;
@end
