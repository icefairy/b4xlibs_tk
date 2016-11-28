//
//  iRYImkit.m
//  iRYImkit
//
//  Created by kaopuedu on 2016/11/28.
//  Copyright © 2016年 kaopuedu. All rights reserved.
//

#import "iRYImkit.h"
#import <RongIMKit/RongIMKit.h>
#import "MyChatListViewController.h"
#import "RCDCustomerServiceViewController.h"
@implementation iRYImkit
- (void)Initialize:(B4I *)bi :(NSString *)EventName :(NSString *)apikey{
    [B4IObjectWrapper setBIAndEventName:self :bi :EventName];
    [[RCIM sharedRCIM] initWithAppKey:apikey];
}
- (void)Connect:(NSString *)token{
    [[RCIM sharedRCIM] connectWithToken:token success:^(NSString *userId) {
        NSLog(@"登陆成功。当前登录的用户ID：%@", userId);
        [B4IObjectWrapper raiseEvent:self :@"_onSuccess::" :[NSArray arrayWithObjects:userId, nil]];
    } error:^(RCConnectErrorCode status) {
        NSLog(@"登陆的错误码为:%d", status);
        
        [B4IObjectWrapper raiseEvent:self :@"_onError:" :[NSArray arrayWithObjects:[NSNumber numberWithInt:status], nil]];
    } tokenIncorrect:^{
        //token过期或者不正确。
        //如果设置了token有效期并且token过期，请重新请求您的服务器获取新的token
        //如果没有设置token有效期却提示token错误，请检查您客户端和服务器的appkey是否匹配，还有检查您获取token的流程。
        NSLog(@"token错误");
        [B4IObjectWrapper raiseEvent:self :@"_onTokenIncorrect:" :nil];
    }];
}

- (void)ChatWith:(NSString *)targetid :(NSString *)title :(B4INavigationControllerWrapper *)nav
{
    RCConversationViewController *chat = [[RCConversationViewController alloc]init];
    //设置会话的类型，如单聊、讨论组、群聊、聊天室、客服、公众服务会话等
    chat.conversationType = ConversationType_PRIVATE;
    //设置会话的目标会话ID。（单聊、客服、公众服务会话为对方的ID，讨论组、群聊、聊天室为会话的ID）
    chat.targetId = @"targetIdYouWillChatIn";
    //设置聊天会话界面要显示的标题
    chat.title = @"想显示的会话标题";
    //显示聊天会话界面
    [nav ShowPage:chat];
}

- (void)ShowChatList:(B4INavigationControllerWrapper *)nav{
    MyChatListViewController *chatlist=[[MyChatListViewController alloc] init];
    [nav ShowPage:chatlist];
}

- (void)ChatWithCustomerService:(NSString *)clientid :(B4INavigationControllerWrapper *)nav :(NSString *)selfnick :(NSString *)selfimg{
    RCDCustomerServiceViewController *chatService = [[RCDCustomerServiceViewController alloc] init];
    chatService.userName = @"客服";
    chatService.conversationType = ConversationType_CUSTOMERSERVICE;
    chatService.targetId = clientid;
    chatService.title = @"客服";
    RCCustomerServiceInfo *csinfo=[[RCCustomerServiceInfo alloc] init];
    [csinfo setNickName:selfnick];
    [csinfo setPortraitUrl:selfimg];
    chatService.csInfo = csinfo; //用户的详细信息，此数据用于上传用户信息到客服后台，数据的nickName和portraitUrl必须填写。(目前该字段暂时没用到，客服后台显示的用户信息是你获取token时传的参数，之后会用到）
    [nav ShowPage:chatService];
}
@end
