//
//  bugly.m
//  bugly
//
//  Created by kaopuedu on 2016/12/6.
//  Copyright © 2016年 kaopuedu. All rights reserved.
//
#import <Bugly/Bugly.h>
#import "bugly.h"

@implementation bugly
- (void) Initialize:(B4I *)bi :(NSString *)apikey{
    [Bugly startWithAppId:apikey];
    NSLog(@"bugly started");
}
@end
