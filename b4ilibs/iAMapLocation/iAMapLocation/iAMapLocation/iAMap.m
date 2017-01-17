//
//  iAMap.m
//  iAMapLocation
//
//  Created by kaopuedu on 2016/12/22.
//  Copyright © 2016年 kaopuedu. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "iAMapLocation.h"
#import <AMapFoundationKit/AMapFoundationKit.h>
#import <MAMapKit/MAMapKit.h>
@implementation iAMap : B4IViewWrapper
    MAMapView * _mapView;

-(void)Initialize:(B4I *)bi :(NSString *)EventName :(NSString *)apikey {
    [B4IViewWrapper setBIAndEventName:self :bi :EventName];
    [[AMapServices sharedServices] setEnableHTTPS:YES];
    [AMapServices sharedServices].apiKey =apikey;
}

-(void)add2Parent:(B4IPanelView *)p{
    _mapView = [[MAMapView alloc] initWithFrame:[p bounds]];
    
    [p addSubview:_mapView];
}

-(void)showMyLoc:(BOOL *)show{
    [_mapView setShowsUserLocation:show];
    [_mapView setUserTrackingMode:MAUserTrackingModeFollow];
}
-(void)showCompass:(BOOL *)show{
    [_mapView setShowsCompass:show];
}
-(void)showScale:(BOOL *)show{
    [_mapView setShowsScale:show];
}
-(void)setZoomLevel:(double *)lv :(BOOL *)animated{
    [_mapView setZoomLevel:*lv animated:animated];
}
-(void)setCenterCoordinate:(double *)lat :(double *)lng :(BOOL *)animated{
    CLLocationCoordinate2D *pos={lat,lng};
    [_mapView setCenterCoordinate:*pos animated:animated];
}
@end
