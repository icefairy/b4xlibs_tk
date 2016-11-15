//
//  iFaceDetect.m
//  iFaceDetect
//
//  Created by icefairy on 16/10/2.
//  Copyright © 2016年 icefairy. All rights reserved.
//

#import "iFaceDetect.h"
#import "CapedViewController.h"


@interface iFaceDetect  ()
{
    B4I *mbi;
    B4IPage *mpage;
    B4INavigationControllerWrapper *mnav;
}

@end

@implementation iFaceDetect
- (void)Initialize:(B4I *)bi :(NSString *)EventName :(B4INavigationControllerWrapper *) nav
{
    [B4IObjectWrapper setBIAndEventName:self :bi :EventName];
    mbi=bi;
    [mbi Log:@"initialize"];
    mnav=nav;
}
- (void)runwithcfg :(NSString *)xmlstr
{
    
    [mbi Log:@"runwithcfg begin"];
    CapedViewController *capVC = [[CapedViewController alloc]init];
    capVC.xmlSTR = xmlstr;
    capVC.mbi=mbi;
    //    capVC.switchCAMERAA = false;
    [mnav ShowPage2:capVC :YES];
    [mbi Log:@"runwithcfg end"];
    
}
+ (void)gotresult:(NSString *)imgbase64
{
    NSLog(@"called by oc");
    [B4IObjectWrapper raiseEvent:self :@"_gotimg:" :@[imgbase64]];
    [B4IObjectWrapper raiseUIEvent:self :@"_gotimg:" :@[imgbase64]];
}


//- (void)capedImageActions
//{
//      [mbi Log:@"capedImageActions begin"];
//    if (faceView.checkDevice) {
//                [mbi Log:@"camera is ready"];
//    [faceView startCaptureWithParam:theSinfo andResult:^(GResult *result){
//        NSString *title = nil;
//        NSString *msg=nil;
//        [mbi Log:result.returnCode];
//        [mbi Log:result.resultMsg];
////        NSLog(@"状态码%@ %@",result.returnCode,result.resultMsg);
////        NSLog(@" %d",result.imgBase64.length);
//        if ([result.returnCode intValue] == 0) {
//            title = @"采集成功";
//            [faceView showImgA];
//            [B4IObjectWrapper raiseEvent:self :@"_gotimg:" :@[result.imgBase64]];
//            //TODO:
//            //这里用result.imageBase64,取采集的base64照片，然后发送到后台做比较，处理逻辑即可
//            //数据已加密，请后台处理解密，前端不提供解密接口
//            //NSLog(@"%@",result.imgBase64);
//
//
//        }
//        else
//        {
//            title = @"采集失败";
//            msg=result.resultMsg;
//            if ([result.returnCode intValue] == -2) {
//                msg = @"检测为失败！";
//            }else if([result.returnCode intValue] == -1){
//                msg = @"抓取人脸超时";
//            }
//        }
//        [B4IObjectWrapper raiseEvent:self :@"_goterr:" :@[msg]];
//    } ];
//    }else{
//        [mbi Log:@"camera not ready"];
//    }
//    [mbi Log:@"capedImageActions end"];
//}
//
//- (void)writeB64String:(NSString *)someB64 toPath:(NSString *)path
//{
//    NSLog(@"%@",path);
//    [someB64 writeToFile:path atomically:YES encoding:NSUTF8StringEncoding error:nil];
//
//}
/*
 #pragma mark - Navigation
 
 // In a storyboard-based application, you will often want to do a little preparation before navigation
 - (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
 // Get the new view controller using [segue destinationViewController].
 // Pass the selected object to the new view controller.
 }
 */

@end
