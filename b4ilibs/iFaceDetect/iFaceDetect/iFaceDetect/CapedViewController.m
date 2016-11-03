//
//  CapedViewController.m
//  TCDemo
//
//  Created by jinkeke@techshino.com on 15/11/16.
//  Copyright © 2015年 www.techshino.com. All rights reserved.
//


#import "CapedViewController.h"

#import "YYBase64.h"
#import "YYFaceView.h"
#import "SInfo.h"
#import "GResult.h"
#import "MInfo.h"

@interface CapedViewController ()
{
    YYFaceView *faceView;
    SInfo *theSinfo;
    
    
}
@end

@implementation CapedViewController

- (void)goBackBtn
{
    if (faceView) {
        if ([faceView checkDevice]) {
            [faceView closeDevice];
        }
        
        //如果没使用arc
        //[faceView release];
        faceView = nil;
    }
    
    
    //如下你的导航条设置
    [self.navigationController popViewControllerAnimated:YES];
    
}


- (void)viewWillDisappear:(BOOL)animated
{
    if (faceView) {
        if ([faceView checkDevice]) {
            [faceView closeDevice];
        }
    }
    
    
    //    [faceView release];
    faceView = nil;
    theSinfo = nil;
    
}


- (void)viewDidLoad
{
    [super viewDidLoad];
    self.title = @"人脸采集";
    
    UIBarButtonItem *agsBtn = [[UIBarButtonItem alloc]initWithTitle:@"重试" style:0 target:self action:@selector(capedImageActions)];
    self.navigationItem.rightBarButtonItem = agsBtn;
    
    self.view.backgroundColor = [UIColor whiteColor];
    CGFloat faceViewHeight = CGRectGetHeight(self.view.bounds) - 64;
    faceView = [[YYFaceView alloc]initWithFrame:CGRectMake(0,0, CGRectGetWidth(self.view.bounds), faceViewHeight)];
    
    faceView.microModel = NO;
    //xml参数主要由后台服务器获取
    self.xmlSTR = @"<param><imgWidth>360</imgWidth><imgHeight>440</imgHeight><imgCompress>85</imgCompress><pupilDistMin>180</pupilDistMin><pupilDistMax>260</pupilDistMax><isActived>2</isActived><isAudio>1</isAudio><timeOut>45</timeOut><version>v1.1.5</version><deviceIdx>0</deviceIdx><definitionAsk>15</definitionAsk><cryptType>1</cryptType><interfaceType>4</interfaceType><cryptKey>37010519820902167800</cryptKey><action>2</action><headLeft>-20</headLeft><headRight>25</headRight><headLow>-20</headLow><headHigh>15</headHigh><eyeDegree>30</eyeDegree><mouthDegree>30</mouthDegree><outType>1</outType><supportLow>1</supportLow></param>";
    [faceView setXMLConfig:self.xmlSTR];
    [self.view addSubview:faceView];
    
    if([faceView checkDevice]==NO)
    {
        faceView = nil;
        return;
    }
    
    theSinfo = [[SInfo alloc]init];
    theSinfo.InitXMLStr = self.xmlSTR;
    theSinfo.CustomInfo=@"1234567890";  //终端号10位
    theSinfo.Serialno=@"123456789012";  //token，12位
    
    [faceView showView];
    
    
    
    if (self.switchCAMERAA) {
        [faceView switchFrontAndBackCameras:YES];
    }
    
    [iFaceDetect gotresult:@"testimg"];
//    [B4IObjectWrapper raiseUIEvent:self :@"_gotresult" :nil];
//    [B4IObjectWrapper raiseUIEvent:self :@"ifd_gotresult" :nil];
//    [B4IObjectWrapper raiseUIEvent:self :@"ifd_gotimg:" :@[@"222222222"]];
//    [B4IObjectWrapper raiseUIEvent:self :@"ifd_gotimg:" :@[@"33333"]];
//    
//    [B4IObjectWrapper raiseEventFromDifferentThread:_mbi :@"_gotimg:" :@[@"3333"]];
//    [B4IObjectWrapper raiseEventFromDifferentThread:self.mbi :@"ifb_gotimg:" :@[@"44444"]];
//    [B4IObjectWrapper raiseEventFromDifferentThread:self :@"ifb_gotimg:" :@[@"55555"]];NSLog(@"close current page");
//    [B4IObjectWrapper raiseUIEvent:_mbi :@"_gotresult" :nil];
//    [B4IObjectWrapper raiseUIEvent:_mbi :@"_gotimg:" :@[@"222222222"]];
//    [B4IObjectWrapper raiseEventFromDifferentThread:_mbi :@"_gotimg:" :@[@"3333"]];
//    [B4IObjectWrapper raiseEventFromDifferentThread:self.mbi :@"ifb_gotimg:" :@[@"44444"]];
//    [B4IObjectWrapper raiseEventFromDifferentThread:self :@"ifb_gotimg:" :@[@"55555"]];
//    [self capedImageActions];
    
    
    
    
}

- (void)doCloseActions
{
    [faceView closeDevice];
}

- (void)capedImageActions
{
    [faceView startCaptureWithParam:theSinfo andResultB:^(GResult *result){
        NSString *title = nil;
        NSString *msg   = nil;
        NSLog(@"状态吗%@ %@",result.returnCode,result.resultMsg);
        NSLog(@" %d",result.imgBase64.length);
        if ([result.returnCode intValue] == 0) {
            title = @"采集成功";
            NSLog(@"采集成功 from oc");
            [faceView showImgA];
            //            [iFaceView alloc].imgBase64=@[result.imgBase64];
            //            [iFaceView imgBase64]=@[result.imgBase64];
            //            NSLog(@"begin raiseevent from oc");
            //            [B4IObjectWrapper raiseEvent:nil :@"ifv_gotimg":@[result.imgBase64]];
            //            NSLog(@"begin raiseevent from oc2");
            //            [B4IObjectWrapper raiseEvent:self :@"_gotimg":@[result.imgBase64]];
            //            NSLog(@"begin raiseevent from oc3");
            //            [B4IObjectWrapper raiseEvent:nil :@"gotimg":@[result.imgBase64]];
            NSString *path=[NSString stringWithFormat:@"%@sbrlsb.txt",NSTemporaryDirectory()];
            NSLog(@"path=%@",path);
            [self writeB64String:result.imgBase64 toPath:path];
            NSLog(@"close current page");
            [B4IObjectWrapper raiseUIEvent:_mbi :@"_gotresult" :nil];
            [B4IObjectWrapper raiseUIEvent:_mbi :@"_gotimg:" :@[@"222222222"]];
            [B4IObjectWrapper raiseEventFromDifferentThread:_mbi :@"_gotimg:" :@[@"3333"]];
//            [self.mbi raiseEventFromDifferentThread:self.mbi event:@"_gotimg:" params:@[@"111"]];
//            [self.mbi raiseUIEvent:self.mbi event:@"_gotimg:" params:@[@"222"]];
//            [self.mbi raiseEventFromDifferentThread:self.mbi event:@"ifd_gotimg:" params:@[@"333"]];
//            [B4IObjectWrapper raiseEventFromDifferentThread:nil :@"ifd_gotimg:" :@[@"444444"]];
            [self goBackBtn];
            //TODO:
            //这里用result.imageBase64,取采集的base64照片，然后发送到后台做比较，处理逻辑即可
            //数据已加密，请后台处理解密，前端不提供解密接口
            //NSLog(@"%@",result.imgBase64);
            
            
        }
        else
        {
            title = @"采集失败";
            msg = result.resultMsg;
            if ([result.returnCode intValue] == -2) {
                msg = @"检测为失败！";
            }else if([result.returnCode intValue] == -1){
                msg = @"抓取人脸超时";
            }
        }
        UIAlertView *av = [[UIAlertView alloc] initWithTitle:title message:msg delegate:nil cancelButtonTitle:@"确定" otherButtonTitles: nil];
        [av show];
    } ];
}

- (void)writeB64String:(NSString *)someB64 toPath:(NSString *)path
{
    NSLog(@"%@",path);
    [someB64 writeToFile:path atomically:YES encoding:NSUTF8StringEncoding error:nil];
    
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
 #pragma mark - Navigation
 
 // In a storyboard-based application, you will often want to do a little preparation before navigation
 - (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
 // Get the new view controller using [segue destinationViewController].
 // Pass the selected object to the new view controller.
 }
 */

@end
