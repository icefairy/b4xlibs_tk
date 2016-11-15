//
//  Photo.h
//  Camera
//
//  Created by lzc on 11-2-25.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface NSData (YYMBBase64)

+ (id)dataWithBase64EncodedString:(NSString *)string;     //  Padding '=' characters are optional. Whitespace is ignored.
- (NSString *)base64Encoding;
@end


@interface YYBase64 : NSObject {
	
}

/*
 * 缩放图片
 * image 图片对象
 * toWidth 宽
 * toHeight 高
 * return 返回图片对象
 */
+(UIImage *)scaleImage:(UIImage *)image toWidth:(int)toWidth toHeight:(int)toHeight;

/*
 * 缩放图片数据
 * imageData 图片数据
 * toWidth 宽
 * toHeight 高
 * return 返回图片数据对象
 */
+(NSData *)scaleData:(NSData *)imageData toWidth:(int)toWidth toHeight:(int)toHeight;

/*
 * 圆角
 * image 图片对象
 * size 尺寸
 */
+(id) createRoundedRectImage:(UIImage*)image size:(CGSize)size;

/*
 * 图片转换为字符串
 */
//+(NSString *) image2String:(UIImage *)image;
+(NSString *) image2String:(UIImage *)image withCompressionQuality:(CGFloat)quality;

/*
 * 字符串转换为图片
 */
+(UIImage *) string2Image:(NSString *)string;
@end
