#import "iCore.h"
#import "firstlib.h"
#import "iDebug2.h"
@interface b4i_main : B4IStaticModule
- (NSString*)  _application_background;
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav;
- (NSString*)  _btncalllib_click;
- (NSString*)  _fb_gotmsg:(NSString*) _msg;
- (NSString*)  _fb_gotmsg2:(NSString*) _msg :(int) _code;
- (NSString*)  _fb_noparam;
- (NSString*)  _firstlib_barbuttonclick:(NSString*) _tag;
- (NSString*)  _page1_resize:(int) _width :(int) _height;
- (NSString*)  _process_globals;
@property (nonatomic)B4IApplicationWrapper* _app;
@property (nonatomic)B4INavigationControllerWrapper* _navcontrol;
@property (nonatomic)B4IPage* _page1;
@property (nonatomic)firstlib* _fb;
@end
