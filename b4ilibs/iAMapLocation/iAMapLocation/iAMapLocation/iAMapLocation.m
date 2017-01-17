//
//  iAMapLocation.m
//  iAMapLocation
//
//  Created by kaopuedu on 2016/11/2.
//  Copyright © 2016年 kaopuedu. All rights reserved.
//

#import "iAMapLocation.h"
#import <AMapFoundationKit/AMapFoundationKit.h>
#import "iCore.h"
#import <AMapLocationKit/AMapLocationKit.h>

@implementation iAMapLocation

//    NSInteger *nLocTimeout;
//    NSInteger *nAdrTimeout;


-(void)Initialize:(B4I *)bi :(NSString *)EventName :(NSString *)apikey {
    [B4IObjectWrapper setBIAndEventName:self :bi :EventName];
    [[AMapServices sharedServices] setEnableHTTPS:YES];
    [AMapServices sharedServices].apiKey =apikey;
//    nLocTimeout=6;
//    nAdrTimeout=3;
    NSLog(@"init");
    [self configLocationManager];
    
}
-(void)startlocation{
        NSLog(@"startlocation");
    // 带逆地理（返回坐标和地址信息）。将下面代码中的 YES 改成 NO ，则不会返回地址信息。
    [self.locationManager requestLocationWithReGeocode:YES completionBlock:^(CLLocation *location, AMapLocationReGeocode *regeocode, NSError *error) {
        
        B4IMap *map=[[B4IMap alloc]init];
        [map Initialize];

        if (error)
        {
            [map Put:@"code" :[NSNumber numberWithLong:error.code]];
            [map Put:@"msg" :error.localizedDescription];
//            [map Put:@"msg" :[NSString stringWithFormat:@"%@",error.localizedFailureReason];
            [B4IObjectWrapper raiseUIEvent:self :@"_onlocerror:" :@[map]];
            NSLog(@"locError:{%ld - %@};", (long)error.code, error.localizedDescription);
            
            if (error.code == AMapLocationErrorLocateFailed)
            {
                return;
            }
        }
        

        NSLog(@"location:%@", location);
        
        if (regeocode)
        {
            NSLog(@"reGeocode:%@", regeocode);
//            [NSString stringWithFormat:@"lat:%f;lon:%f \n accuracy:%.2fm", location.coordinate.latitude, location.coordinate.longitude, location.horizontalAccuracy];
            iLocation *iloc=[[iLocation alloc]init];
            iloc.pos_lat=[NSNumber numberWithDouble:location.coordinate.latitude];
            iloc.pos_lon=[NSNumber numberWithDouble:location.coordinate.longitude];
            iloc.city=[NSString stringWithFormat:@"%@",regeocode.city?regeocode.city:@""];
            iloc.street=[NSString stringWithFormat:@"%@",regeocode.street?regeocode.street:@""];
            iloc.province=[NSString stringWithFormat:@"%@",regeocode.province?regeocode.province:@""];
//            iloc.country=[NSString stringWithFormat:@"%@",regeocode.country?];
            iloc.formattedAddress=[NSString stringWithFormat:@"%@",regeocode.formattedAddress?regeocode.formattedAddress:@""];
            iloc.citycode=[NSString stringWithFormat:@"%@",regeocode.citycode?regeocode.citycode:@""];
            iloc.district=[NSString stringWithFormat:@"%@",regeocode.district?regeocode.district:@""];
            [B4IObjectWrapper raiseUIEvent:self :@"_gotloc:" :@[iloc]];
        }
    }];}
-(void)configLocationManager
{
    self.locationManager = [[AMapLocationManager alloc] init];
//    NSLog(@"configLocationManager2");
    [self.locationManager setDelegate:self];
//    NSLog(@"configLocationManager3");

    
    //设置期望定位精度
    [self.locationManager setDesiredAccuracy:kCLLocationAccuracyHundredMeters];
//    NSLog(@"configLocationManager4");

//    //设置不允许系统暂停定位
//    [self.locationManager setPausesLocationUpdatesAutomatically:NO];
////    
////    //设置允许在后台定位
//    [self.locationManager setAllowsBackgroundLocationUpdates:NO];
////
    //设置定位超时时间
    [self.locationManager setLocationTimeout:6];
//    NSLog(@"configLocationManager5");

    //设置逆地理超时时间

    [self.locationManager setReGeocodeTimeout:3];
//    NSLog(@"configLocationManager6");

}

- (void)stoplocation
{
    //停止定位
    [self.locationManager stopUpdatingLocation];
    
//    [self.locationManager setDelegate:nil];
    
}

@end
@implementation iLocation

-(void)Initialize:(B4I *)bi{
    [B4IObjectWrapper setBIAndEventName:self :bi :@""];
    
}

@end
