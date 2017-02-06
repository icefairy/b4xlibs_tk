//
//  iSDWebImage.m
//  iSDWebImage
//
//  Created by kaopuedu on 2017/2/6.
//  Copyright © 2017年 kaopuedu. All rights reserved.
//

#import "iSDWebImage.h"
#import "SDWebImageManager.h"
@implementation iSDWebImage
- (void)setImageWithURL:(B4I *)bi :(NSString *)EventName :(UIImageView *)imageview :(NSString *)imgurl :(UIImage *)placeholder{
    [B4IViewWrapper setBIAndEventName:self :bi :EventName];
//    [imageview setBitmap:placeholder];
    [imageview setImage:placeholder];
    [[SDWebImageManager sharedManager] loadImageWithURL:[NSURL URLWithString:imgurl] options:SDWebImageRetryFailed progress:^(NSInteger receivedSize, NSInteger expectedSize, NSURL * _Nullable targetURL) {
        [B4IViewWrapper raiseEventFromDifferentThread:self :@"_sdprogress:::" :@[[NSNumber numberWithInteger:receivedSize],[NSNumber numberWithInteger:expectedSize],targetURL]];
    } completed:^(UIImage * _Nullable image, NSData * _Nullable data, NSError * _Nullable error, SDImageCacheType cacheType, BOOL finished, NSURL * _Nullable imageURL) {
        B4IMap* m=[[B4IMap alloc] init];
        [m Initialize];
        [m Put:@"url" :imageURL];
        [m Put:@"finished" :[NSNumber numberWithBool:finished]];
        [m Put:@"bmp" :image];
        [m Put:@"url" :imageURL];
        [m Put:@"errmsg" :error];
        [B4IViewWrapper raiseEventFromDifferentThread:self :@"_sdcomplete:" :@[m]];
        if (error.code==0) {
            [imageview setImage:image];
        }else{
            [imageview setImage:placeholder];
        }
    }];
}
-(void)DownloadImageWithURL:(B4I *)bi :(NSString *)EventName :(NSString *)imgurl{
    [B4IViewWrapper setBIAndEventName:self :bi :EventName];
    //    [imageview setBitmap:placeholder];
    [[SDWebImageManager sharedManager] loadImageWithURL:[NSURL URLWithString:imgurl] options:SDWebImageRetryFailed progress:^(NSInteger receivedSize, NSInteger expectedSize, NSURL * _Nullable targetURL) {
        [B4IViewWrapper raiseEventFromDifferentThread:self :@"_sdprogress:::" :@[[NSNumber numberWithInteger:receivedSize],[NSNumber numberWithInteger:expectedSize],targetURL]];
    } completed:^(UIImage * _Nullable image, NSData * _Nullable data, NSError * _Nullable error, SDImageCacheType cacheType, BOOL finished, NSURL * _Nullable imageURL) {
        B4IMap* m=[[B4IMap alloc] init];
        [m Initialize];
        [m Put:@"url" :imageURL];
        [m Put:@"finished" :[NSNumber numberWithBool:finished]];
        [m Put:@"bmp" :image];
        [m Put:@"url" :imageURL];
        [m Put:@"errmsg" :error];
        [B4IViewWrapper raiseEventFromDifferentThread:self :@"_sdcomplete:" :@[m]];
    }];

}
@end
