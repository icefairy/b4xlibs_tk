#import "iCore.h"
#import "iSDWebImage.h"
@interface b4i_main : B4IStaticModule
- (NSString*)  _application_background;
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav;
- (NSString*)  _img_sdcomplete:(B4IMap*) _m;
- (NSString*)  _img_sdprogress:(int) _nrec :(int) _ntot :(NSString*) _sdurl;
- (NSString*)  _page1_resize:(int) _width :(int) _height;
- (NSString*)  _process_globals;
@property (nonatomic)B4IApplicationWrapper* _app;
@property (nonatomic)B4INavigationControllerWrapper* _navcontrol;
@property (nonatomic)B4IPage* _page1;
@property (nonatomic)B4IImageViewWrapper* _imageview1;
@property (nonatomic)B4IImageViewWrapper* _imageview2;
@property (nonatomic)B4IImageViewWrapper* _imageview3;
@property (nonatomic)B4IImageViewWrapper* _imageview4;
@property (nonatomic)B4IImageViewWrapper* _imageview6;
@property (nonatomic)B4IImageViewWrapper* _imageview5;
@property (nonatomic)iSDWebImage* _sdimgldr;
@property (nonatomic)B4IBitmap* _bmpholder;
@end
