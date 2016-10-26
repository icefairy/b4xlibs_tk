
#import "b4i_main.h"


@implementation b4i_main 


+ (instancetype)new {
    static b4i_main* shared = nil;
    if (shared == nil) {
        shared = [self alloc];
        shared.bi = [[B4IShellBI alloc] init:shared];
        shared.__c = [B4ICommon new];
    }
    return shared;
}
- (int)debugAppId {
    return 3;
}


- (NSString*)  _application_background{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"application_background"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"application_background" :nil]);
[B4IRDebugUtils shared].currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Private Sub Application_Background";
[B4IRDebugUtils shared].currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"application_start"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"application_start:" :@[_nav]]);
[B4IRDebugUtils shared].currentLine=65536;
 //BA.debugLineNum = 65536;BA.debugLine="Private Sub Application_Start (Nav As NavigationCo";
[B4IRDebugUtils shared].currentLine=65537;
 //BA.debugLineNum = 65537;BA.debugLine="NavControl = Nav";
self._navcontrol = _nav;
[B4IRDebugUtils shared].currentLine=65538;
 //BA.debugLineNum = 65538;BA.debugLine="Page1.Initialize(\"firstlib\")";
[self._page1 Initialize:self.bi :@"firstlib"];
[B4IRDebugUtils shared].currentLine=65539;
 //BA.debugLineNum = 65539;BA.debugLine="Page1.Title = \"第一个库\"";
[self._page1 setTitle:@"第一个库"];
[B4IRDebugUtils shared].currentLine=65540;
 //BA.debugLineNum = 65540;BA.debugLine="Page1.RootPanel.LoadLayout(\"layfirst\")";
[[self._page1 RootPanel] LoadLayout:@"layfirst" :self.bi];
[B4IRDebugUtils shared].currentLine=65541;
 //BA.debugLineNum = 65541;BA.debugLine="NavControl.ShowPage(Page1)";
[self._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
[B4IRDebugUtils shared].currentLine=65542;
 //BA.debugLineNum = 65542;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _btncalllib_click{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"btncalllib_click"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"btncalllib_click" :nil]);
[B4IRDebugUtils shared].currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub btncalllib_Click";
[B4IRDebugUtils shared].currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Log(\"btncalllib_Click\")";
[self.__c Log:@"btncalllib_Click"];
[B4IRDebugUtils shared].currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="fb.Initialize(\"fb\",\"testparam\")";
[self._fb Initialize:self.bi :@"fb" :@"testparam"];
[B4IRDebugUtils shared].currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _fb_gotmsg:(NSString*) _msg{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"fb_gotmsg"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"fb_gotmsg:" :@[_msg]]);
[B4IRDebugUtils shared].currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub fb_gotmsg(msg As String)";
[B4IRDebugUtils shared].currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Log(\"fb_gotmsg:\"&msg)";
[self.__c Log:[@[@"fb_gotmsg:",_msg] componentsJoinedByString:@""]];
[B4IRDebugUtils shared].currentLine=524291;
 //BA.debugLineNum = 524291;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _fb_gotmsg2:(NSString*) _msg :(int) _code{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"fb_gotmsg2"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"fb_gotmsg2::" :@[_msg,@(_code)]]);
[B4IRDebugUtils shared].currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub fb_gotmsg2(msg As String,code As Int)";
[B4IRDebugUtils shared].currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Log(\"fb_gotmsg2:\"&msg&\" code:\"&code)";
[self.__c Log:[@[@"fb_gotmsg2:",_msg,@" code:",[self.bi NumberToString:@(_code)]] componentsJoinedByString:@""]];
[B4IRDebugUtils shared].currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _fb_noparam{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"fb_noparam"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"fb_noparam" :nil]);
[B4IRDebugUtils shared].currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub fb_noparam";
[B4IRDebugUtils shared].currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Log(\"fb_noparam\")";
[self.__c Log:@"fb_noparam"];
[B4IRDebugUtils shared].currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _firstlib_barbuttonclick:(NSString*) _tag{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"firstlib_barbuttonclick"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"firstlib_barbuttonclick:" :@[_tag]]);
[B4IRDebugUtils shared].currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub firstlib_BarButtonClick (Tag As String)";
[B4IRDebugUtils shared].currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Log(\"tag:\"&Tag)";
[self.__c Log:[@[@"tag:",_tag] componentsJoinedByString:@""]];
[B4IRDebugUtils shared].currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _page1_resize:(int) _width :(int) _height{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"page1_resize"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"page1_resize::" :@[@(_width),@(_height)]]);
[B4IRDebugUtils shared].currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As I";
[B4IRDebugUtils shared].currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return @"";
}

- (void)initializeStaticModules {
    [[b4i_main new]initializeModule];

}
- (NSString*)  _process_globals{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"process_globals"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"process_globals" :nil]);
[B4IRDebugUtils shared].currentLine=0;
 //BA.debugLineNum = 0;BA.debugLine="Sub Process_Globals";
[B4IRDebugUtils shared].currentLine=3;
 //BA.debugLineNum = 3;BA.debugLine="Public App As Application";
self._app = [B4IApplicationWrapper new];
[B4IRDebugUtils shared].currentLine=4;
 //BA.debugLineNum = 4;BA.debugLine="Public NavControl As NavigationController";
self._navcontrol = [B4INavigationControllerWrapper new];
[B4IRDebugUtils shared].currentLine=5;
 //BA.debugLineNum = 5;BA.debugLine="Private Page1 As Page";
self._page1 = [B4IPage new];
[B4IRDebugUtils shared].currentLine=6;
 //BA.debugLineNum = 6;BA.debugLine="Dim fb As firstlib";
self._fb = [firstlib new];
[B4IRDebugUtils shared].currentLine=7;
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return @"";
}
@end