//
//  iFaceDetect.h
//  iFaceDetect
//
//  Created by icefairy on 16/10/2.
//  Copyright © 2016年 icefairy. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "iCore.h"
@class B4I;
//~shortname:iFaceDetect
//~event:gotimg(imgBase64 As String)
//~event:goterr(msg As String)
//~event:gotresult
//~version:1.01
//~dependson:AVFoundation.framework
//~dependson:CoreMedia.framework
//~dependson:CoreGraphics.framework
//~dependson:ImageIO.framework
//~dependson:UIKit.framework
//~dependson:MobileCoreServices.framework
//~dependson:YYFaceWidget
@interface iFaceDetect : NSObject
+ (NSString *) imgBase64;
@property (nonatomic,strong)NSString *xmlSTR;
@property (nonatomic,assign)BOOL switchCAMERAA;
- (void)Initialize:(B4I *)bi :(NSString *)EventName :(B4INavigationControllerWrapper *)nav ;
- (void)runwithcfg:(NSString * )xmlstr;
+ (void)gotresult:(NSString *)imgbase64;
@end
