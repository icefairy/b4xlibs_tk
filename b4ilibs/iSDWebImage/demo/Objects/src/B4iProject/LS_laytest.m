
#import "iCore.h"
@interface LS_laytest:NSObject
@end

@implementation LS_laytest

- (void)LS_general:(B4ILayoutData*)views :(int)width :(int)height{
[B4ILayoutBuilder setScaleRate:0.3];
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[laytest/General script]
[B4ILayoutBuilder scaleAll:views :width :height];

}
@end