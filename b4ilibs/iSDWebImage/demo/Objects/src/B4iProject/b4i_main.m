
#import "b4i_main.h"


@implementation b4i_main 


+ (instancetype)new {
    static b4i_main* shared = nil;
    if (shared == nil) {
        shared = [self alloc];
        shared.bi = [[B4I alloc] init:shared];
        shared.__c = [B4ICommon new];
    }
    return shared;
}

- (NSString*)  _application_background{
 //BA.debugLineNum = 57;BA.debugLine="Private Sub Application_Background";
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _application_start:(B4INavigationControllerWrapper*) _nav{
[self initializeStaticModules];
B4IArray* _url = nil;
B4IArray* _ivs = nil;
int _i = 0;
 //BA.debugLineNum = 30;BA.debugLine="Private Sub Application_Start (Nav As NavigationCo";
 //BA.debugLineNum = 31;BA.debugLine="NavControl = Nav";
self._navcontrol = _nav;
 //BA.debugLineNum = 32;BA.debugLine="Page1.Initialize(\"Page1\")";
[self._page1 Initialize:self.bi :@"Page1"];
 //BA.debugLineNum = 33;BA.debugLine="Page1.Title = \"Page 1\"";
[self._page1 setTitle:@"Page 1"];
 //BA.debugLineNum = 34;BA.debugLine="Page1.RootPanel.LoadLayout(\"laytest\")";
[[self._page1 RootPanel] LoadLayout:@"laytest" :self.bi];
 //BA.debugLineNum = 35;BA.debugLine="NavControl.ShowPage(Page1)";
[self._navcontrol ShowPage:(UIViewController*)((self._page1).object)];
 //BA.debugLineNum = 37;BA.debugLine="Dim url() As String=Array As String(\"https://app.";
_url = [[B4IArray alloc]initObjectsWithData:@[[B4I nilToNSNull:@"https://app.kaopuedu.com/Uploads/touxiang/2016-10-02/57f0cdbdee7f4.jpg"],[B4I nilToNSNull:@"https://app.kaopuedu.com/Uploads/touxiang/2016-10-17/5804b1b4114e5.jpg"],[B4I nilToNSNull:@"https://app.kaopuedu.com/Uploads/touxiang/2016-10-12/57fdbe355efbf.jpg"],[B4I nilToNSNull:@"https://app.kaopuedu.com/Uploads/houduan/2016-10-15/58020cc774c3b.jpg"]]];
 //BA.debugLineNum = 38;BA.debugLine="Dim ivs() As ImageView=Array As ImageView(ImageVi";
_ivs = [[B4IArray alloc]initObjectsWithData:@[[B4I nilToNSNull:self._imageview1],[B4I nilToNSNull:self._imageview2],[B4I nilToNSNull:self._imageview3],[B4I nilToNSNull:self._imageview4],[B4I nilToNSNull:self._imageview5],[B4I nilToNSNull:self._imageview6]]];
 //BA.debugLineNum = 40;BA.debugLine="bmpholder=LoadBitmap(File.DirAssets,\"test_tecbg.p";
self._bmpholder = [self.__c LoadBitmap:[[self.__c File] DirAssets] :@"test_tecbg.png"];
 //BA.debugLineNum = 41;BA.debugLine="For i=0 To url.Length-1";
{
const int step9 = 1;
const int limit9 = (int) (_url.Length-1);
for (_i = (int) (0) ; (step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9); _i = ((int)(0 + _i + step9)) ) {
 //BA.debugLineNum = 43;BA.debugLine="sdimgldr.setImageWithURL(\"img\",ivs(i),url(i),bmp";
[self._sdimgldr setImageWithURL:self.bi :@"img" :(UIImageView*)((((B4IImageViewWrapper*)[_ivs getObjectFast:_i])).object) :((NSString*)[_url getObjectFast:_i]) :(UIImage*)((self._bmpholder).object)];
 }
};
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _img_sdcomplete:(B4IMap*) _m{
 //BA.debugLineNum = 46;BA.debugLine="Sub img_sdComplete(m As Map)";
 //BA.debugLineNum = 47;BA.debugLine="Log(\"img_sdComplete\")";
[self.__c Log:@"img_sdComplete"];
 //BA.debugLineNum = 48;BA.debugLine="Log(m)";
[self.__c Log:[self.bi ObjectToString:_m]];
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _img_sdprogress:(int) _nrec :(int) _ntot :(NSString*) _sdurl{
 //BA.debugLineNum = 50;BA.debugLine="Sub img_sdProgress(nRec As Int,nTot As Int,sdUrl A";
 //BA.debugLineNum = 51;BA.debugLine="Log(nRec&\"/\"&nTot&\" \"&sdUrl)";
[self.__c Log:[@[[self.bi NumberToString:@(_nrec)],@"/",[self.bi NumberToString:@(_ntot)],@" ",_sdurl] componentsJoinedByString:@""]];
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return @"";
}
- (NSString*)  _page1_resize:(int) _width :(int) _height{
 //BA.debugLineNum = 53;BA.debugLine="Private Sub Page1_Resize(Width As Int, Height As I";
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return @"";
}

- (void)initializeStaticModules {
    [[b4i_main new]initializeModule];

}
- (NSString*)  _process_globals{
 //BA.debugLineNum = 13;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="Public App As Application";
self._app = [B4IApplicationWrapper new];
 //BA.debugLineNum = 17;BA.debugLine="Public NavControl As NavigationController";
self._navcontrol = [B4INavigationControllerWrapper new];
 //BA.debugLineNum = 18;BA.debugLine="Private Page1 As Page";
self._page1 = [B4IPage new];
 //BA.debugLineNum = 20;BA.debugLine="Private ImageView1 As ImageView";
self._imageview1 = [B4IImageViewWrapper new];
 //BA.debugLineNum = 21;BA.debugLine="Private ImageView2 As ImageView";
self._imageview2 = [B4IImageViewWrapper new];
 //BA.debugLineNum = 22;BA.debugLine="Private ImageView3 As ImageView";
self._imageview3 = [B4IImageViewWrapper new];
 //BA.debugLineNum = 23;BA.debugLine="Private ImageView4 As ImageView";
self._imageview4 = [B4IImageViewWrapper new];
 //BA.debugLineNum = 24;BA.debugLine="Private ImageView6 As ImageView";
self._imageview6 = [B4IImageViewWrapper new];
 //BA.debugLineNum = 25;BA.debugLine="Private ImageView5 As ImageView";
self._imageview5 = [B4IImageViewWrapper new];
 //BA.debugLineNum = 26;BA.debugLine="Private sdimgldr As iSDWebImage";
self._sdimgldr = [iSDWebImage new];
 //BA.debugLineNum = 27;BA.debugLine="Dim bmpholder As Bitmap";
self._bmpholder = [B4IBitmap new];
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return @"";
}
@end
