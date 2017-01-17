//
//  iAMapLocation.h
//  iAMapLocation
//
//  Created by kaopuedu on 2016/11/2.
//  Copyright © 2016年 kaopuedu. All rights reserved.
//

#import "iCore.h"
#import <Foundation/Foundation.h>
#import <AMapLocationKit/AMapLocationKit.h>
@class B4I;
//~shortname:iAMapLocation
//~author:icefairy333
//~event:gotloc(iloc as iLocation)
//~event:onlocerror(merr as Map)
//~version:1.30
//~dependson:AMapLocationKit.framework.3
//~dependson:AMapFoundationKit.framework.3
//~dependson:MAMapKit.framework.3
//~dependson:JavaScriptcore.framework
//~dependson:SystemConfiguration.framework
//~dependson:CoreTelephony.framework
//~dependson:Security.framework
//~dependson:UIKit.framework
//~dependson:Foundation.framework
//~dependson:CoreGraphics.framework
//~dependson:QuartzCore.framework
//~dependson:CoreLocation.framework
//~dependson:AdSupport.framework
//~dependson:libz.tbd
//~dependson:libc++.tbd
//~dependson:libstdc++.6.0.9.tbd
@interface iAMapLocation : B4IObjectWrapper
@property (nonatomic, strong) AMapLocationManager *locationManager;
- (void)Initialize:(B4I *)bi :(NSString *)EventName :(NSString *)apikey;
- (void)startlocation;
- (void)stoplocation;
@end

//~shortname:iAMapViewer
//~author:icefairy333
@interface iAMap : B4IViewWrapper
- (void)Initialize:(B4I *)bi :(NSString *)EventName :(NSString *)apikey;
- (void)add2Parent:(B4IPanelView *)p;
- (void)showMyLoc:(BOOL *)show;
- (void)showCompass:(BOOL *)show;
- (void)showScale:(BOOL *)show;
- (void)setZoomLevel:(double *)lv :(BOOL *)animated;
- (void)setCenterCoordinate:(double *)lat :(double *)lng :(BOOL *)animated;
@end
//~shortname:iLocation
//~author:icefairy333   
@interface iLocation : NSObject<NSCopying,NSCoding>

@property (nonatomic, copy) NSString *formattedAddress;//!< 格式化地址

@property (nonatomic, copy) NSString *country; //!< 国家
@property (nonatomic, copy) NSString *province; //!< 省/直辖市
@property (nonatomic, copy) NSString *city;     //!< 市
@property (nonatomic, copy) NSString *district; //!< 区
@property (nonatomic, copy) NSString *township; //!< 乡镇
@property (nonatomic, copy) NSString *neighborhood; //!< 社区
@property (nonatomic, copy) NSString *building; //!< 建筑
@property (nonatomic, copy) NSString *citycode; //!< 城市编码
@property (nonatomic, copy) NSString *adcode;   //!< 区域编码

@property (nonatomic, copy) NSString *street;   //!< 街道名称
@property (nonatomic, copy) NSNumber *pos_lat;   //!< 门牌号
@property (nonatomic, copy) NSNumber *pos_lon;   //!< 门牌号

@property (nonatomic, copy) NSString *POIName; //!< 兴趣点名称
@property (nonatomic, copy) NSString *AOIName; //!< 所属兴趣点名称


@end
