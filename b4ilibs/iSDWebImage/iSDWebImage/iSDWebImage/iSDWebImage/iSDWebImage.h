//
//  iSDWebImage.h
//  iSDWebImage
//
//  Created by kaopuedu on 2017/2/6.
//  Copyright © 2017年 kaopuedu. All rights reserved.
//
#import "iCore.h"
#import <Foundation/Foundation.h>
//~shortname:iSDWebImage
//~author:icefairy333
//~event:sdProgress(nRec As Int,nTot As Int,sdUrl As String)
//~event:sdComplete(m As Map)
//~version:1.00
//~dependson:ImageIO.framework
//~dependson:MapKit.framework
//~dependson:UIKit.framework
//~dependson:CoreGraphics.framework
//~dependson:SDWebImage
@interface iSDWebImage : NSObject
-(void) setImageWithURL :(B4I *)bi :(NSString *)EventName :(UIImageView *)imageview :(NSString *)imgurl :(UIImage *)placeholder;
-(void) DownloadImageWithURL :(B4I *)bi :(NSString *)EventName :(NSString *)imgurl;
@end
