//
//  firstlib.m
//  firstlib
//
//  Created by kaopuedu on 16/10/26.
//  Copyright © 2016年 kaopuedu. All rights reserved.
//

#import "firstlib.h"

@implementation firstlib
-(void)Initialize:(B4I *)bi :(NSString *)EventName :(NSString *)param{
    NSLog(@"testfunc:%@ param:%@",EventName,param);
    [B4IObjectWrapper setBIAndEventName:self :bi :EventName];//绑定参数（主要是bi和eventname）不然后面的事件无法正
    //常回调
    //带参数的回调事件名称后面要带冒号，没有参数可能可以不带
    [B4IObjectWrapper raiseUIEvent:self :@"_gotmsg:" :@[param]];
    
//    [B4IObjectWrapper raiseEvent:self :@"_gotmsg:" :@[param]];
    NSLog(@"over");
}

@end
