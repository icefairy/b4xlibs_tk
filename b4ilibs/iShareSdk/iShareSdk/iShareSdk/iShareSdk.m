//
//  iShareSdk.m
//  iShareSdk
//
//  Created by kaopuedu on 2016/11/25.
//  Copyright © 2016年 kaopuedu. All rights reserved.
//

#import "iShareSdk.h"
#import <ShareSDK/ShareSDK.h>
#import <ShareSDKConnector/ShareSDKConnector.h>

#import <ShareSDKUI/ShareSDK+SSUI.h>

//腾讯开放平台（对应QQ和QQ空间）SDK头文件
#import <TencentOpenAPI/TencentOAuth.h>
#import <TencentOpenAPI/QQApiInterface.h>
#import <ShareSDKExtension/SSEThirdPartyLoginHelper.h>
//微信SDK头文件
#import "WXApi.h"
@implementation iShareSdk
{
    NSString *EN,*gqqkey,*gqqappid,*gwxappid,*gwxkey;
    B4I *loginbi;
}
-(void)Initialize:(B4I *)bi :(NSString *)eventname{
    [B4IObjectWrapper setBIAndEventName:self :bi :eventname];
    EN=eventname.ToLowerCase;
}
- (void) RegisterApp:(NSString *)mobappkey :(NSString *)qqappid :(NSString *)qqkey :(NSString *)wxappid :(NSString *)wxkey
{
    gqqkey=qqkey;
    gqqappid=qqappid;
    gwxkey=wxkey;
    gwxappid=wxappid;
    [ShareSDK registerApp:mobappkey
     
          activePlatforms:@[
                            @(SSDKPlatformTypeMail),
                            @(SSDKPlatformTypeSMS),
                            @(SSDKPlatformTypeCopy),
                            @(SSDKPlatformTypeWechat),
                            @(SSDKPlatformTypeQQ)]
                 onImport:^(SSDKPlatformType platformType)
     {
         switch (platformType)
         {
             case SSDKPlatformTypeWechat:
                 [ShareSDKConnector connectWeChat:[WXApi class]];
                 break;
             case SSDKPlatformTypeQQ:
                 [ShareSDKConnector connectQQ:[QQApiInterface class] tencentOAuthClass:[TencentOAuth class]];
                 break;
             default:
                 break;
         }
     }
          onConfiguration:^(SSDKPlatformType platformType, NSMutableDictionary *appInfo)
     {
         
         switch (platformType)
         {
             case SSDKPlatformTypeWechat:
                 [appInfo SSDKSetupWeChatByAppId:wxappid
                                       appSecret:wxkey];
                 break;
             case SSDKPlatformTypeQQ:
                 [appInfo SSDKSetupQQByAppId:qqappid
                                      appKey:qqkey
                                    authType:SSDKAuthTypeBoth];
                 break;
            default:
                 break;
         }
     }];
    
}
-(void)ShowShare:(NSString *)title :(NSString *)weburl :(NSString *)sharecontent :(NSString *)imgurl
{
    //1、创建分享参数
    NSArray* imageArray = [NSArray arrayWithObjects:imgurl, nil]; //images:@[@"http://mob.com/Assets/images/logo.png?v=20150320"];//    （注意：图片必须要在Xcode左边目录里面，名称必须要传正确，如果要分享网络图片，可以这样传iamge参数 images:@[@"http://mob.com/Assets/images/logo.png?v=20150320"]）
    if (imageArray) {
        
        NSMutableDictionary *shareParams = [NSMutableDictionary dictionary];
        [shareParams SSDKSetupShareParamsByText:sharecontent
                                         images:imageArray
                                            url:[NSURL URLWithString:weburl]
                                          title:title
                                           type:SSDKContentTypeAuto];
        //2、分享（可以弹出我们的分享菜单和编辑界面）
        [ShareSDK showShareActionSheet:nil //要显示菜单的视图, iPad版中此参数作为弹出菜单的参照视图，只有传这个才可以弹出我们的分享菜单，可以传分享的按钮对象或者自己创建小的view 对象，iPhone可以传nil不会影响
                                 items:nil
                           shareParams:shareParams
                   onShareStateChanged:^(SSDKResponseState state, SSDKPlatformType platformType, NSDictionary *userData, SSDKContentEntity *contentEntity, NSError *error, BOOL end) {
                       
                       switch (state) {
                           case SSDKResponseStateSuccess:
                           {
                               UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:@"分享成功"
                                                                                   message:nil
                                                                                  delegate:nil
                                                                         cancelButtonTitle:@"确定"
                                                                         otherButtonTitles:nil];
                               [alertView show];
                               break;
                           }
                           case SSDKResponseStateFail:
                           {
                               UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"分享失败"
                                                                               message:[NSString stringWithFormat:@"%@",error]
                                                                              delegate:nil
                                                                     cancelButtonTitle:@"OK"
                                                                     otherButtonTitles:nil, nil];
                               [alert show];
                               break;
                           }
                           default:
                               break;
                       }
                   }
         ];}
}
//1=success 2=unsuccess 3=cancle
-(void)LoginByQQ :(B4I *)bi :(NSString *)eventname{
    [B4IObjectWrapper setBIAndEventName:self :bi :eventname];
    B4IMap *usermap=[[B4IMap alloc]init];
    [usermap Initialize];
    [SSEThirdPartyLoginHelper loginByPlatform:SSDKPlatformTypeQQ
                                   onUserSync:^(SSDKUser *user, SSEUserAssociateHandler associateHandler) {
                                       
                                       //在此回调中可以将社交平台用户信息与自身用户系统进行绑定，最后使用一个唯一用户标识来关联此用户信息。
                                       //在此示例中没有跟用户系统关联，则使用一个社交用户对应一个系统用户的方式。将社交用户的uid作为关联ID传入associateHandler。
                                       associateHandler (user.uid, user, user);
                                       NSLog(@"dd%@",user.rawData);
                                       NSLog(@"dd%@",user.credential.rawData);
                                       B4IMap *userdata=[[B4IMap alloc]init];
                                       userdata=[B4IMap convertToMap:user.credential.rawData];
                                       [usermap Put:@"user" :userdata];
//                                       [usermap setDict:user.rawData];
//                                       usermap=[B4IMap convertToMap:user.rawData];
                                       
                                   }
                                onLoginResult:^(SSDKResponseState state, SSEBaseUser *user, NSError *error) {
                                    [usermap Put:@"pt" :@"qzone"];
//                                    NSNumber *st=[NSNumber numberWithInt:state];
//                                    switch (state) {
//                                        case SSDKResponseStateSuccess:
//                                            [usermap Put:@"success" :@"state"];
//                                            break;
//                                        case SSDKResponseStateFail:
//                                            [usermap Put:@"error" :@"state"];
//                                            break;
//                                        case SSDKResponseStateCancel:
//                                            [usermap Put:@"cancel" :@"state"];
//                                            break;
//                                        default:
//                                            [usermap Put:@"other" :@"state"];
//                                            break;
//                                    }
                                    [usermap Put:@"state" :[NSNumber numberWithInt:state]];
                                    [usermap Put:@"error" :error];
                                    [B4IObjectWrapper raiseUIEvent:self :@"_onloginresult:" : @[usermap]];
                                    
                                }];

}
//1=success 2=unsuccess 3=cancle
-(void)LoginByWx :(B4I *)bi :(NSString *)eventname{
    [B4IObjectWrapper setBIAndEventName:self :bi :eventname];
    B4IMap *usermap=[[B4IMap alloc]init];
    [usermap Initialize];
    [SSEThirdPartyLoginHelper loginByPlatform:SSDKPlatformTypeWechat
                                   onUserSync:^(SSDKUser *user, SSEUserAssociateHandler associateHandler) {
                                       
                                       //在此回调中可以将社交平台用户信息与自身用户系统进行绑定，最后使用一个唯一用户标识来关联此用户信息。
                                       //在此示例中没有跟用户系统关联，则使用一个社交用户对应一个系统用户的方式。将社交用户的uid作为关联ID传入associateHandler。
                                       associateHandler (user.uid, user, user);
                                       NSLog(@"dd%@",user.rawData);
//                                       NSLog(@"dd%@",user.credential);
                                       B4IMap *userdata=[[B4IMap alloc]init];
                                       userdata=[B4IMap convertToMap:user.credential.rawData];
                                       [usermap Put:@"user" :userdata];
                                       
                                   }
                                onLoginResult:^(SSDKResponseState state, SSEBaseUser *user, NSError *error) {
                                    [usermap Put:@"pt" :@"wechat"];
                                    [usermap Put:@"state":[NSNumber numberWithInt:state]];
                                    [usermap Put:@"error" :error];
                                    [B4IObjectWrapper raiseUIEvent:self :@"_onloginresult:" : @[usermap]];

                                }];
}

@end
