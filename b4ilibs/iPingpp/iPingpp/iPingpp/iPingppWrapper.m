//
//  iPingpp.m
//  iPingpp
//
//  Created by kaopuedu on 2017/1/10.
//  Copyright © 2017年 kaopuedu. All rights reserved.
//

#import "iPingppWrapper.h"

@implementation iPingppWrapper
-(void)Initinlize:(B4I *)bi :(NSString *)eventname{
    [B4IObjectWrapper setBIAndEventName:self :bi :eventname];
}
- (void)createPayment:(NSString *)charge :(NSString *)kUrlScheme{
    [Pingpp createPayment:charge appURLScheme:kUrlScheme withCompletion:^(NSString *result, PingppError *error) {
        [self HandlePaymentResult:result :error];
    }];
      
}
-(void)HandlePaymentResult:(NSString *)result :(PingppError *)error{
    B4IMap *map=[[B4IMap alloc]init];
    [map Initialize];
    [map Put:@"result" :result];
    NSLog(@"completion block: %@", result);
    if (error == nil) {
        NSLog(@"PingppError is nil");
        [map Put:@"code" :0];
        [map Put:@"msg" :@""];
    } else {
        NSLog(@"PingppError: code=%lu msg=%@", (unsigned  long)error.code, [error getMsg]);
        [map Put:@"code" :[NSNumber numberWithLong:error.code]];
        [map Put:@"msg" :[error getMsg]];
    }
    [B4IObjectWrapper raiseUIEvent:self :@"_onpayresult:" :@[map]];
}
-(BOOL)HandleOpenUrl:(NSString *)url{
    BOOL canHandleURL = [Pingpp handleOpenURL:url withCompletion:^(NSString *result, PingppError *error) {
        [self HandlePaymentResult:result :error];
    }];
    return canHandleURL;
}
@end
