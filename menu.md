
#B4XLIBS目录<br>
***
##通用说明
> * 项目中libs或者lib目录一般存放的是编译好的支持库文件（可能还包括需要用到的res资源文件）
* B4I的库目前比较少放编译好的版本，你可以自己根据源码用xcode进行编译

***
├─b4alibs<br>
│  ├─amaplocation<br>
> 高德地图（amap.com)+高德定位支持库以及例子项目
│  ├─daynightswitch<br>
> 切换日夜主题

│  │  ├─amaplocationDemo<br>
> 高德地图（amap.com)+高德定位例子

│  │  │  ├─libs<br>
> 支持库文件

│  │  │  └─Objects<br>
│  │  └─amaplocation_src<br>
> 支持库源代码

│  ├─apkmgr<br>
> 使用PackageManager创建的一个简单的带ListView的应用列表的项目源码

│  ├─b4aFastBlurUtil<br>
> 封装自开源项目FastBlur的高斯模糊库

│  │  ├─b4aFastBlurUtil<br>
> 库源码

│  │  ├─demo<br>
> 使用例程

│  │  └─libs<br>
> 库文件（编译好的）

│  ├─b4aJpush<br>
> jpush极光推送库（v1.63）

│  │  └─lib<br>
│  ├─b4amyUIL<br>
> 封装自开源库UIL(universal-image-loader-1.9.5)

│  │  ├─demo<br>
> 使用例程

│  │  ├─libs<br>
> 编译版本

│  │  └─myUIL<br>
> 库源码

│  ├─b4aRIV<br>
> 圆形图片框控件(可以用myUIL直接实现圆形、圆角等效果，那样就可以不用这个了）

│  │  ├─b4aRoundImageView<br>
> 库源码

│  │  └─rivdemo<br>
> 圆形图片框例程

│  ├─b4arongyunimkit<br>
> 容联云通讯(rongcloud.cn)旗下的IMKit聊天组件

│  │  └─lib<br>
> 编译好的库文件

│  │      └─res<br>
> IMKit要用到的资源文件

│  ├─bugly<br>
> 腾讯Bugly错误捕获支持库（发布app后可以在Bugly.qq.com看错误日志以及用户数量之类简单的统计信息）

│  │  ├─b4aBugly<br>
> 库源码

│  │  ├─demo<br>
> 使用例程

│  │  └─libs<br>
> 编译版本

│  ├─CRZxing<br>
> 仿微信的二维码扫描项目，基于b4x论坛CameraExClass类，主要都是类文件源码就和项目一起的

│  │  ├─doc<br>
> 运行截图和apk

│  │  ├─lib<br>

│  ├─exitall<br>
> 用javaobject库实现的模仿Java世界的ActivityManager，可以在App中任意一个地方真正退出整个App，比较适合懒人，或者是由于种种原因App的导航逻辑毕竟复杂或者混乱的情况使用

│  ├─FontAwesome<br>
> FontAwesome 字体使用（从b4a6.3以及同时代的b4i b4j开始都有ide直接支持了，所以 用不上了，可以参考学习下）

│  ├─galleryfinaldemo<br>
> 封装自开源项目GalleryFinal的Android图片（以及相册、拍照）选择库，支持裁剪缩放旋转等，相比自己写的兼容性比较好

│  │  ├─b4aGalleryFinal<br>
> 封装的源码

│  │  ├─demo<br>
> 使用例子

│  │  │  └─res<br>
> 注意要复制资源文件（到项目根目录下即可）

│  │  └─libs<br>
│  ├─galleryfinaldemo(PhotoViewMuti)<br>
> 和上面的类似，这是晨飞（QQ：254264955）修改的增强版，增加了多图片查看功能

│  ├─GaodeMap<br>
> 高德地图模块

│  │  ├─b4aGaodeMap<br>
> 支持库源码

│  │  └─libs<br>
│  ├─getui<br>
> 个推(getui.com) 推送支持库 + 例程

│  │  ├─b4agetui<br>
> 支持库源码

│  │  ├─Files<br>
│  │  ├─getuires<br>
> 支持库资源文件

│  │  ├─libs<br>
> 编译好的文件

│  ├─httpsmixedcontent<br>
> 开启WebView加载HTTPS混合内容的库

│  │  ├─libs<br>
│  │  └─libsrc<br>
│  ├─myLight<br>
> 手电筒例程

│  ├─NiceSpinner<br>
> NiceSpinner 个人觉得并不怎么Nice所以只是封装了下~没用上

│  │  └─b4aNiceSpinner<br>
│  ├─NoHttp<br>
> NoHttp开源项目（未完成，感觉没必要了，就丢这了，谁有兴趣可以继续下去）

│  ├─pageind<br>
> 界面指示器创建（用于自己写一些自定义控件用的）

│  ├─Pingxx<br>
> Pingxx(pingxx.com)聚合支付支持库（只封装了微信和支付宝其他渠道由于我用不上就没往里面加，你需要可以自己加进去），注意这家只支持企业用户使用，个人就别考虑这个了

│  │  ├─b4aPingxx<br>
> 支持库源码

│  │  └─demo<br>
> 并没有demo 只有编译好的Libs，使用方法去参考pingxx的技术文档吧，稍微麻烦点

│  │      └─libs<br>
│  ├─PtrLoadMore<br>
> 封装的一个下拉刷新的开源库（未完成）

│  ├─richtextutil<br>
> 创建富文本的小工具，源码例程齐全

│  ├─RongyunIMKit<br>
> 容联云通讯（和上面的一样）的支持库源码以及资源文件

│  ├─shareSdk<br>
> ShareSdk(mob.com)聚合社会化分享以及第三方登录支持库（封装了微信qq）例子以及源码

│  ├─sxwnl<br>
> 封装自开源（JavaScript）项目寿星万年历，带公历转农历，公历取干支历法（有时辰分令刻令），纳干采用五鼠盾法

│  └─vitamio<br>
> vitamio开源播放器支持库（版本有点老可能不能用了，源码都有可以自行升级或者去b4x论坛找其他人封装的更新的版本）
***

├─b4ilibs<br>
> 下面就是IOS的库，其中项目文件夹中copy2bi文件夹下的文件一般需要全部复制到B4I项目的files文件夹的special目录中去（如果还没有生成你可以先保存项目然后运行一下ide就会自动创建了）

│  ├─firstlib<br>
> 第一个库（没有啥实际功能，主要展示了各种事件回调以及申明方法的方法

│  ├─iAdMob<br>
> 官方提供的例子，作参考用的

│  ├─iAMapLocation<br>
> 高德地图和定位支持库

│  │  ├─copy2bi<br>
│  ├─iBugly<br>
> 腾讯bugly支持库（用于发布后异常捕获以及用户量统计）

│  │  └─copy2bi<br>
│  ├─iFaceDetect<br>
> 一个人脸识别的第三方库（此乃商业版的需要授权才能自定义包名，否则只能测试）

│  ├─iLocation<br>
> B4X官方提供的例子

│  ├─iPingpp<br>
> pingxx聚合支付支持库

│  │  ├─copy2bi<br>
│  ├─iRYImkit<br>
> 容联云通讯的IMKit

│  │  ├─copy2b4i<br>
│  ├─iSDWebImage<br>
> IOS开发世界中大名鼎鼎的开源图片加载库SDWebImage，支持网络缓存（自动处理），封装了显示图片以及下载图片，并相应的回调事件

│  │  ├─demo<br>
> 使用例子

│  │  ├─iSDWebImage<br>
> 封装源码

│  │  └─orglib<br>
> 这里是原始开源项目的代码，封装的话需要先编译这个然后把a文件和h文件引入封装项目，使用的话不用管这个

│  ├─iShareSdk<br>
> ShareSdk(mob.com)聚合社会化分享以及第三方登录（同样支付只封装了微信支付宝，登录只封装了qq和微信）

│  │  └─iShareSdk<br>
│  │      ├─copy2b4i<br>
│  └─zoomableimageview<br>
> 可缩放的图片框，用于点击图片后打开查看大图这类功能模块

├─b4ilibsrelease<br>
> 这里的xml是全部的编译好的对应库的xml说明文件，将B4I的附加库路径设置到这个文件夹即可被B4I识别

***

├─b4jlibs<br>
> B4J的库相对较少

│  ├─GetSSCData<br>
> 时时彩数据抓取的一个web小项目，可以学习json，httputils等的使用

│  ├─ServerJsonTree<br>
> Json处理小工具（ORM代码生成）[详情可以看B4X论坛帖子](https://www.b4x.com/android/forum/threads/the-first-b4x-orm-framework.75484/)

│  └─threadusage<br>
> 演示线程使用的小例程

├─b4xtools<br>
> B4I 封装库能用到的几个小脚本,比如smb加载，生成xml文件等

├─commonBase<br>
> 这里面是一些大部分代码能通用的B4X类文件比如CustomListView之类的

├─ABM<br>
> 用于WEB开发的ABM框架，详情参考[B4X论坛帖子](https://www.b4x.com/android/forum/threads/abmaterial-framework-for-webapps.60072/)
这里有[在线演示](http://abmaterial.com)

***

└─openproject<br>
> 部分开源项目

    ├─cowMgr<br>
> 放牛娃，对开源项目cow的Android化封装，凑合能用但是不咋方便
