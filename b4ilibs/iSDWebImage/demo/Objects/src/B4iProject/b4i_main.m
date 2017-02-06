
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
    return 1;
}


- (NSString*)  _application_background{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"application_background"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"application_background" :nil]);
[B4IRDebugUtils shared].currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Private Sub Application_Background";
[B4IRDebugUtils shared].currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"application_start"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"application_start:" :@[_nav]]);
B4IArray* _url = nil;
B4IArray* _ivs = nil;
int _i = 0;
[B4IRDebugUtils shared].currentLine=65536;
 //BA.debugLineNum = 65536;BA.debugLine="Private Sub Application_Start (Nav As NavigationCo";
[B4IRDebugUtils shared].currentLine=65537;
 //BA.debugLineNum = 65537;BA.debugLine="NavControl = Nav";
self._navcontrol = _nav;
[B4IRDebugUtils shared].currentLine=65538;
 //BA.debugLineNum = 65538;BA.debugLine="Page1.Initialize(\"Page1\")";
[self._page1 Initialize:self.bi :@"Page1"];
[B4IRDebugUtils shared].currentLine=65539;
 //BA.debugLineNum = 65539;BA.debugLine="Page1.Title = \"Page 1\"";
[self._page1 setTitle:@"Page 1"];
[B4IRDebugUtils shared].currentLine=65540;
 //BA.debugLineNum = 65540;BA.debugLine="Page1.RootPanel.LoadLayout(\"laytest\")";
[[self._page1 RootPanel] LoadLayout:@"laytest" :self.bi];
[B4IRDebugUtils shared].currentLine=65541;
 //BA.debugLineNum = 65541;BA.debugLine="NavControl.ShowPage(Page1)";
[self._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
[B4IRDebugUtils shared].currentLine=65543;
 //BA.debugLineNum = 65543;BA.debugLine="Dim url() As String=Array As String(\"https://app.";
_url = [[B4IArray alloc]initObjectsWithData:@[[B4I nilToNSNull:@"https://app.kaopuedu.com/Uploads/touxiang/2016-10-02/57f0cdbdee7f4.jpg"],[B4I nilToNSNull:@"https://app.kaopuedu.com/Uploads/touxiang/2016-10-17/5804b1b4114e5.jpg"],[B4I nilToNSNull:@"https://app.kaopuedu.com/Uploads/touxiang/2016-10-12/57fdbe355efbf.jpg"],[B4I nilToNSNull:@"https://app.kaopuedu.com/Uploads/houduan/2016-10-15/58020cc774c3b.jpg"]]];
[B4IRDebugUtils shared].currentLine=65544;
 //BA.debugLineNum = 65544;BA.debugLine="Dim ivs() As ImageView=Array As ImageView(ImageVi";
_ivs = [[B4IArray alloc]initObjectsWithData:@[[B4I nilToNSNull:self._imageview1],[B4I nilToNSNull:self._imageview2],[B4I nilToNSNull:self._imageview3],[B4I nilToNSNull:self._imageview4],[B4I nilToNSNull:self._imageview5],[B4I nilToNSNull:self._imageview6]]];
[B4IRDebugUtils shared].currentLine=65546;
 //BA.debugLineNum = 65546;BA.debugLine="bmpholder=LoadBitmap(File.DirAssets,\"test_tecbg.p";
self._bmpholder = [self.__c LoadBitmap:[[self.__c File] DirAssets] :@"test_tecbg.png"];
[B4IRDebugUtils shared].currentLine=65547;
 //BA.debugLineNum = 65547;BA.debugLine="For i=0 To url.Length-1";
{
const int step9 = 1;
const int limit9 = (int) (_url.Length-1);
for (_i = (int) (0) ; (step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9); _i = ((int)(0 + _i + step9)) ) {
[B4IRDebugUtils shared].currentLine=65549;
 //BA.debugLineNum = 65549;BA.debugLine="sdimgldr.setImageWithURL(\"img\",ivs(i),url(i),bmp";
[self._sdimgldr setImageWithURL:self.bi :@"img" :(UIImageView*)((((B4IImageViewWrapper*)[_ivs getObjectFast:_i])).object) :((NSString*)[_url getObjectFast:_i]) :(UIImage*)((self._bmpholder).object)];
 }
};
[B4IRDebugUtils shared].currentLine=65551;
 //BA.debugLineNum = 65551;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _img_sdcomplete:(B4IMap*) _m{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"img_sdcomplete"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"img_sdcomplete:" :@[_m]]);
[B4IRDebugUtils shared].currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub img_sdComplete(m As Map)";
[B4IRDebugUtils shared].currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Log(\"img_sdComplete\")";
[self.__c Log:@"img_sdComplete"];
[B4IRDebugUtils shared].currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Log(m)";
[self.__c Log:[self.bi ObjectToString:_m]];
[B4IRDebugUtils shared].currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _img_sdprogress:(int) _nrec :(int) _ntot :(NSString*) _sdurl{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"img_sdprogress"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"img_sdprogress:::" :@[@(_nrec),@(_ntot),_sdurl]]);
[B4IRDebugUtils shared].currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub img_sdProgress(nRec As Int,nTot As Int,sdUrl A";
[B4IRDebugUtils shared].currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Log(nRec&\"/\"&nTot&\" \"&sdUrl)";
[self.__c Log:[@[[self.bi NumberToString:@(_nrec)],@"/",[self.bi NumberToString:@(_ntot)],@" ",_sdurl] componentsJoinedByString:@""]];
[B4IRDebugUtils shared].currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _page1_resize:(int) _width :(int) _height{
[B4IRDebugUtils shared].currentModule=@"main";
if ([B4IDebug shouldDelegate: @"page1_resize"])
	return ((NSString*) [B4IDebug delegate:self.bi :@"page1_resize::" :@[@(_width),@(_height)]]);
[B4IRDebugUtils shared].currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As I";
[B4IRDebugUtils shared].currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
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
[B4IRDebugUtils shared].currentLine=7;
 //BA.debugLineNum = 7;BA.debugLine="Private ImageView1 As ImageView";
self._imageview1 = [B4IImageViewWrapper new];
[B4IRDebugUtils shared].currentLine=8;
 //BA.debugLineNum = 8;BA.debugLine="Private ImageView2 As ImageView";
self._imageview2 = [B4IImageViewWrapper new];
[B4IRDebugUtils shared].currentLine=9;
 //BA.debugLineNum = 9;BA.debugLine="Private ImageView3 As ImageView";
self._imageview3 = [B4IImageViewWrapper new];
[B4IRDebugUtils shared].currentLine=10;
 //BA.debugLineNum = 10;BA.debugLine="Private ImageView4 As ImageView";
self._imageview4 = [B4IImageViewWrapper new];
[B4IRDebugUtils shared].currentLine=11;
 //BA.debugLineNum = 11;BA.debugLine="Private ImageView6 As ImageView";
self._imageview6 = [B4IImageViewWrapper new];
[B4IRDebugUtils shared].currentLine=12;
 //BA.debugLineNum = 12;BA.debugLine="Private ImageView5 As ImageView";
self._imageview5 = [B4IImageViewWrapper new];
[B4IRDebugUtils shared].currentLine=13;
 //BA.debugLineNum = 13;BA.debugLine="Private sdimgldr As iSDWebImage";
self._sdimgldr = [iSDWebImage new];
[B4IRDebugUtils shared].currentLine=14;
 //BA.debugLineNum = 14;BA.debugLine="Dim bmpholder As Bitmap";
self._bmpholder = [B4IBitmap new];
[B4IRDebugUtils shared].currentLine=15;
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return @"";
}
@end