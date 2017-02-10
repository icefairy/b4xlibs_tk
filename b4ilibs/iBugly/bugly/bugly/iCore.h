//
// Created by b4j on 6/8/14.
// Copyright (c) 2014 Anywhere Software. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
#import <objc/objc.h>

@class B4I;
@class B4IColors;
@class B4IRegex;
@class B4IList;
@class B4IMainView;
@class B4IFile;
@class B4IMap;
@class B4IFontWrapper;
@class B4IBit;
@class B4ILayoutValues;
@class B4IBitmap;
@class B4IPanelWrapper;
@class B4ILabelWrapper;

//~version:3.00
//~DependsOn:AVFoundation.framework
@protocol B4IDebuggable
- (NSArray *)debug:(int)limit :(BOOL*)outShouldAddReflectionFields;
@end
@protocol B4ILogger
- (void) Log:(NSString *)msg :(NSString *)prefix;
@end
@protocol B4IIterable
- (int)Size;
- (NSObject *)Get:(int)Index;
@end
@protocol B4IDesignerCustomView
- (void) DesignerCreateView:(B4IPanelWrapper *)base :(B4ILabelWrapper *)lw :(B4IMap *)props;
- (void) _initialize:(B4I *)bi :(NSObject *)target :(NSString *)EventName;
- (void) base_resize:(CGFloat)width : (CGFloat)height;
@end
//~hide
@interface B4IPanelView : UIView
@property (nonatomic) CGSize currentSize;
- (void)Initialize;
@end




@interface B4IObjectWrapper : NSObject
//~hide
@property (nonatomic, strong) id object;
//~hide
@property (nonatomic, readonly)id objectOrNull;
//Gets or sets the Tag object. This is a placeholder for any object you like to tie to this object.
@property (nonatomic)NSObject *Tag;
+ (NSMutableDictionary *)getMap:(id)obj;

+ (void)setBIAndEventName:(id)obj :(B4I *)bi :(NSString *)EventName;

+ (B4I *)getBI:(id)obj;
+ (id)raiseEvent:(id)sender :(NSString *)suffix :(NSArray *)params;

+ (void)raiseUIEvent:(id)sender :(NSString *)suffix :(NSArray *)params;

+ (void)raiseEventFromDifferentThread:(id)sender :(NSString *)suffix :(NSArray *)params;

+ (BOOL)hasMethod:(id)sender :(NSString *)suffix;

+ (NSString *)getEventName:(id)obj;

//Tests whether this object was initialized.
- (BOOL)IsInitialized;

//~hide
+ (Class) getClass;
//~hide
+ (id)createWrapper:(B4IObjectWrapper *)wrapper object:(id)object;
//~hide
- (BOOL)isEqual:(id)other;
//~hide
- (NSUInteger)hash;
@end

//~hide
@interface B4IArray : NSObject<B4IIterable, B4IDebuggable>
@property (nonatomic, readonly) int Length;
@property (nonatomic) NSData *bytesData;
@property (nonatomic) NSMutableArray *objectsData;
- (instancetype)initBytes:(NSArray *)ranks1;


- (instancetype)initObjects:(NSArray *)ranks1 :(NSObject *)fillObject :(NSString *)fillClass;

- (instancetype)initObjectsWithData:(NSArray *)data1;

- (instancetype)initBytesWithData:(NSArray *)data1;


- (NSObject *)getObject:(NSArray *)indices;

- (NSObject *)getObjectFast:(int)index;

- (NSObject *)getObjectFastN:(int)index;

- (void)setObject:(NSArray *)indices :(NSObject *)value;

- (void)setObject2FastN:(int)i1 :(int)i2 :(NSObject *)value;

- (NSObject *)getObject2FastN:(int)i1 :(int)i2;

- (void)setObjectFastN:(int)index :(NSObject *)value;

- (void)setObjectFast:(int)index :(NSObject *)value;

- (void)setByte:(NSArray *)indices :(NSObject *)value;

- (void)setByteFast:(int)index :(NSObject *)value;

- (unsigned char)getByte:(NSArray *)indices;

- (unsigned char)getByteFast:(int)index;
@end
/**
* An object holding information about an exception.
* LastException will hold the last exception caught in a Try / Catch block.
*/
//~ShortName:Exception
//~ObjectWrapper:NSError*
@interface B4IExceptionWrapper : B4IObjectWrapper
//Returns the error description.
@property (nonatomic, readonly)NSString* Description;
//Same as Description (same API as in B4A and B4J).
@property (nonatomic, readonly)NSString *Message;
//Returns the error code number.
@property (nonatomic, readonly)int Code;
//Returns the error domain.
@property (nonatomic, readonly)NSString* Domain;

@end

/**
* Date and time related methods.
* Date and time values are stored as ticks. Ticks represent the number of milliseconds since January 1, 1970 00:00:00 UTC.
* This value is too large to be stored in an Int variable. It should only be stored in a Long variable.
* DateUtils module should be used for time calculations when working with intervals larger than hours.
*/
@interface B4IDateTime : NSObject
//Number of ticks per second (1000).
@property (nonatomic, readonly) long long TicksPerSecond;
/**
* Number of ticks per 24 hours. In almost all cases it is better to use DateUtils module when working with days.
* Note that there are days with less or more than 24 hours.
 */
@property (nonatomic, readonly) long long TicksPerDay;
//Number of ticks per minute.
@property (nonatomic, readonly) long long TicksPerMinute;
//Number or ticks per hour.
@property (nonatomic, readonly) long long TicksPerHour;
//Returns the current time represented as the number of milliseconds since 1/1/1970 00:00 UTC.
@property (nonatomic, readonly) long long Now;
//Returns the device default date format.
@property (nonatomic, readonly) NSString *DeviceDefaultDateFormat;
//Returns the device default time format.
@property (nonatomic, readonly) NSString *DeviceDefaultTimeFormat;
/**
* Gets or sets the process date format.
* The default format is MM/dd/yyyy (04/23/2002 for example).
* The patterns are the same as in B4A and B4J.
* <link>Supported formats|http://www.unicode.org/reports/tr35/tr35-31/tr35-dates.html#Date_Format_Patterns</link>
*/
@property (nonatomic) NSString *DateFormat;
/**
* Gets or sets the process time format.
* The default format is HH:mm:ss (23:45:12 for example).
* The patterns are the same as in B4A and B4J.
* <link>Supported formats|http://www.unicode.org/reports/tr35/tr35-31/tr35-dates.html#Date_Format_Patterns</link>
*/
@property (nonatomic) NSString *TimeFormat;
//Returns the current offset measured in hours from UTC.
@property (nonatomic, readonly) double TimeZoneOffset;
//~hide
- (long long)NSDateToTicks:(NSDate *)date;
//~hide
- (NSDate *)TicksToNSDate:(long long)Ticks;
//~hide
- (NSCalendar *)getCalendar;
//~hide
- (NSTimeZone *)getTimeZone;

/**
* Returns a string representation of the date (which is stored as ticks).
* Example:<code>
*Log("Today is: " & DateTime.Date(DateTime.Now))
* </code>
*/
- (NSString *)Date:(long long)Ticks;

/**
* Returns a string representation of the time (which is stored as ticks).
* Example:<code>
* Log("The time now is: " & DateTime.Time(DateTime.Now))</code>
*/
- (NSString *)Time:(long long)Ticks;

/**
* Parses the given date string and returns its ticks representation.
* Example:<code>
*     Dim SomeTime As Long = DateTime.DateParse("02/23/2007")</code>
*/
- (long long)DateParse:(NSString *)Date;
//Parses the given date and time strings and returns the ticks representation.
- (long long)DateTimeParse:(NSString *)Date :(NSString *)Time;

/**
* Returns the offset measured in hours from UTC at the specified date.
*/
- (double)GetTimeZoneOffsetAt:(long long)Ticks;

/**
* Sets the process time zone.
*/
- (void)SetTimeZone:(double)OffsetHours;
//Returns the year component from the ticks value.
- (int)GetYear:(long long)Ticks;
//Returns the month component from the ticks value. Values are between 1 to 12.
- (int)GetMonth:(long long)Ticks;

/**
* Returns the day of month component from the ticks value.
* Values are between 1 to 31.
*/
- (int)GetDayOfMonth:(long long)Ticks;

/**
* Returns the day of year component from the ticks value.
* Values are between 1 to 366.
*/
- (int)GetDayOfYear:(long long)Ticks;

/**
* Returns the day of week component from the ticks value.
* Values are between 1 to 7, where 1 means Sunday.
*/
- (int)GetDayOfWeek:(long long)Ticks;

/**
* Returns the hour component from the ticks value.
* Values are between 0 to 23.
*/
- (int)GetHour:(long long)Ticks;

/**
* Returns the seconds within minute component from the ticks value.
* Values are between 0 to 59.
*/
- (int)GetSecond:(long long)Ticks;

/**
* Returns the minutes within hour component from the ticks value.
* Values are between 0 to 59.
*/
- (int)GetMinute:(long long)Ticks;

/**
* Returns a ticks value which is the result of adding the specified time spans to the given ticks value.
* Pass negative values to substract.
* In most cases it is better to use DateUtils.AddPeriod.
*/
- (long long)Add:(long long)Ticks :(int)Years :(int)Months :(int)Days;
@end

//~hide
@interface B4I : NSObject
@property (nonatomic, weak) id eventsTarget;
@property (nonatomic) id<B4ILogger>logger;
@property (nonatomic, weak)B4IPanelView* mainView;
@property NSError *lastError;
@property (nonatomic) id sender;
+ (B4I *)shared;

+ (NSLocale *)cul;

- (instancetype)init:(id)me;

- (NSString *)returnString:(NSString *)res;

- (unichar)ObjectToChar:(NSObject *)o;

- (NSNumber *)ObjectToNumber:(id <NSObject>)o;

- (long long int)ObjectToLongNumber:(id <NSObject>)o;

- (BOOL)ObjectToBoolean:(id)o;

- (NSString *)ObjectToString:(id <NSObject>)o;

- (NSString *)CharToString:(unichar)c;

- (NSString *)BooleanToString:(BOOL)b;

- (void)LogInfo:(NSString *)msg;

- (void)LogError:(NSString *)msg;

- (void)Log:(NSString *)msg;

- (void)addLogPrefix:(NSString *)msg :(NSString *)prefix;

- (BOOL)IsLong:(NSNumber *)n;

- (NSString *)NumberToString:(NSNumber *)n;

- (UIColor *)ColorToUIColor:(int)clr;

- (int)UIColorToColor:(UIColor *)clr;

- (B4IList *)ArrayToList:(B4IArray *)array;

- (int)switchObjectToInt:(NSObject *)test :(NSArray *)values;

+ (NSString *)TypeToString:(NSObject *)o :(BOOL)clazz;

+ (NSObject *)NSNullToNil:(NSObject *)o;

+ (NSObject *)nilToNSNull:(NSObject *)o;

+ (void)SetException:(NSException *)e;

+ (BOOL)isShellBI;

+ (id)runDynamicMethod:(id)target method:(NSString *)e throwErrorIfMissing:(BOOL)throw args:(NSArray *)p;

- (BOOL)hasMethod:(NSString *)methodName;

- (void)errorIfMissingEvent:(NSString *)eventName :(NSString *)suffix;

- (void)raiseEventFromDifferentThread:(id)sender event:(NSString *)e params:(NSArray *)p;

- (void)raiseUIEvent:(id)sender event:(NSString *)e params:(NSArray *)p;

- (id)raiseEvent:(id)sender event:(NSString *)e params:(NSArray *)p;

@end
//~hide
@interface B4IAppDelegate : UIResponder <UIApplicationDelegate>

@property (strong, nonatomic) UIWindow *window;

@end
//~shortname:WeakRef
/**
* WeakRef object holds a weak reference to another object. This is useful to avoid a reference cycle memory leaks.
*/
@interface B4IWeakRef : NSObject
//Gets or sets the weak referenced object. The value will be "Nulled" automatically when there are no more strong references to the target object.
@property (weak, nonatomic) NSObject *Value;
@end

@interface B4ICommon: NSObject
//PI constant.
@property (nonatomic, readonly) double cPI;
@property (nonatomic, readonly) BOOL True;
@property (nonatomic, readonly) BOOL False;
@property (nonatomic, readonly) NSObject * Null;
//New line character. The value of Chr(10).
@property (nonatomic, readonly) NSString *CRLF;
//Tab character.
@property (nonatomic, readonly) NSString* TAB;
//Quote character - Chr(34).
@property (nonatomic, readonly) NSString *QUOTE;
//e (natural logarithm base) constant.
@property (nonatomic, readonly) double cE;


//~hide
+ (NSStringEncoding)getEncoding:(NSString *)charset;

+ (B4ICommon *)shared;

/**
* Loads a bitmap. Note that the file system is case sensitive.
*/
- (B4IBitmap *)LoadBitmap:(NSString *)Dir :(NSString *)FileName;
//Font related methods.
- (B4IFontWrapper *)Font;
//Bit related methods.
- (B4IBit *)Bit;
//Files related methods.
- (B4IFile *)File;
//Date and time related methods.
- (B4IDateTime *)DateTime;
//Colors related methods.
- (B4IColors *)Colors;
//Regular expressions related methods.
- (B4IRegex *)Regex;
//Inverts the value of the given boolean.
- (BOOL)Not:(BOOL)Value;
//Logs a message. The message will be visible in the Logs tab in the IDE (in debug mode).
- (void)Log:(NSString *)Text;
//Similar to Log. Sets the message color.
- (void)LogColor:(NSString *)Message :(int)Color;
//Returns the absolute value.
- (double)Abs:(double)Number;
//Returns the larger number between the two numbers.
- (double)Max:(double)Number1 :(double)Number2;
//Returns the smaller number between the two numbers.
- (double)Min:(double)Number1 :(double)Number2;
//Calculates the trigonometric sine function. Angle measured in radians.
- (double)Sin:(double)Angle;
//Calculates the trigonometric sine function. Angle measured in degrees.
- (double)SinD:(double)Degrees;
//Calculates the trigonometric cosine function. Angle measured in radians.
- (double)Cos:(double)Radians;
//Calculates the trigonometric tangent function. Angle measured in radians.
- (double)Tan:(double)Radians;
//Calculates the trigonometric tangent function. Angle measured in degrees.
- (double)TanD:(double)Degrees;
//Calculates the trigonometric cosine function. Angle measured in degrees.
- (double)CosD:(double)Degrees;
//Returns the positive square root.
- (double)Sqrt:(double)Value;
//Returns the angle measured with radians.
- (double)ASin:(double)Value;
//Returns the angle measured with degrees.
- (double)ASinD:(double)Value;
//Returns the angle measured with radians.
- (double)ACos:(double)Value;
//Returns the angle measured with degrees.
- (double)ACosD:(double)Value;
//Returns the angle measured with radians.
- (double)ATan:(double)Value;
//Returns the Base value raised to the Exponent power.
- (double)Power:(double)Base :(double)Exponent;
//Returns the angle measured with degrees.
- (double)ATanD:(double)Value;
//Returns the angle measured with radians.
- (double)ATan2:(double)Y :(double)X;
//Returns the angle measured with degrees.
- (double)ATan2D:(double)Y :(double)X;
//Returns the logarithm of the given Number.
- (double)Logarithm:(double)Number :(double)Base;
//Returns the whole number closest to the given number. In most cases it is better to use NumberFormat or NumberFormat2 instead.
- (double)Round:(double)Number;
//Returns the largest whole number that is smaller or equal to the specified number.
- (double)Floor:(double)Number;
//Returns the smaller whole number that is larger or equal to the specified number.
- (double)Ceil:(double)Number;
//Returns the character that is represented by the given unicode value.
- (unichar)Chr:(int)UnicodeValue;
//Returns the unicode code point of the give character.
- (int)Asc:(unichar)Char;

/**
* Converts the specified number to a string.
* The string will include at least Minimum Integers and at most Maximum Fractions digits.
* Example:<code>
* Log(NumberFormat(12345.6789, 0, 2)) '"12,345.68"
* Log(NumberFormat(1, 3, 0)) '"001"</code>
*/
- (NSString *)NumberFormat:(double)Number :(int)MinimumIntegers :(int)MaximumFractions;

/**
* Converts the specified number to a string.
* The string will include at least Minimum Integers, at most Maximum Fractions digits and at least Minimum Fractions digits.
*GroupingUsed - Whether to group every three integers.
*Example:<code>
*Log(NumberFormat2(12345.67, 0, 3, 3, False)) '"12345.670"</code>
*/
- (NSString *)NumberFormat2:(double)Number :(int)MinimumIntegers :(int)MaximumFractions :(int)MinimumFractions :(BOOL)GroupingUsed;

/**
* Returns the object that raised the event. Only valid while inside the event sub.
* Example:<code>
*Sub Button1_Click
* Dim b As Button = Sender
* b.Text = "I've been clicked"
*End Sub</code>
*/
- (NSObject *)Sender:(B4I *)bi;
//Tests whether the specified string can be safely parsed as a number.
- (BOOL)IsNumber:(NSString *)Value;
//Returns a random integer between Min (inclusive) and Max (exclusive).
- (int)Rnd:(int)Min :(int)Max;

/**
* Returns the actual size of the given percentage of the page width.
*This value is only exact while inside the Page_Resize event.
*In other cases it is relative to the screen width.
*/
- (float)PerXToCurrent:(float)Percentage;
/**
* Returns the actual size of the given percentage of the page height.
*This value is only exact while inside the Page_Resize event.
*In other cases it is relative to the screen height.
*/
- (float)PerYToCurrent:(float)Percentage;
//The logical scale of iOS device is always 1.0. This method returns the value of Length.
- (int)DipToCurrent:(int)Length;

/**
* Decodes the given bytes array as a string.
*Data - The bytes array.
*StartOffset - The first byte to read.
*Length - Number of bytes to read.
*CharSet - The name of the character set.
*Example:<code>
*Dim s As String = BytesToString(Buffer, 0, Buffer.Length, "UTF-8")</code>
*/
- (NSString *)BytesToString:(B4IArray */*unsigned char,1*/)Data :(int)StartOffset :(int)Length :(NSString *)CharSet;

/**
* Creates a Map with the given key / value pairs.
* The syntax is: CreateMap(key1: value1, key2: value2, ...)
* Example:<code>
*Dim m As Map = CreateMap("January": 1, "February": 2)</code>
*/
- (void)CreateMap;

/**
* Tests whether the object is of the given type.
* Note that when a number is converted to object it might change its type to a different type of number
* (for example a Byte might be converted to an Int).
* Example:<code>
*For Each v As View in Page1.RootPanel.GetAllViewsRecursive
* If v Is Button Then
*  Dim b As Button = v
*  b.Color = Colors.Blue
* End If
*Next</code>
*/
- (BOOL)Is;

//~hide
- (B4IMap *)createMap:(NSArray *)data;

/**
* Returns the device LayoutValues.
* Example:<code>
*Log(GetDeviceLayoutValues)</code>
*/
- (B4ILayoutValues *)GetDeviceLayoutValues;

/**
* Returns the last exception that was caught.
*/
- (B4IExceptionWrapper *)LastException;
/**
* Shows a message box with the given message and title.
*<b>The dialog is not a modal dialog.</b> The code will not block.
*/
//~RaisesSynchronousEvents:true
- (void)Msgbox:(NSString *)Message :(NSString *)Title;
/**
* Shows a message box with the given message and title.
*<b>The dialog is not a modal dialog.</b> The code will not block.
* EventName - Sets the sub that will handle the Click event.
* Message - The dialog message.
* Title - The dialog title.
* Buttons - A List of strings that will be used as buttons.
* Example:<code>
*Sub Page1_Click
* Msgbox2("Msg", "Title", Do you want to do delete document?", Array ("Yes", "No"))
*End Sub
*
*Sub Msg_Click (ButtonText As String)
* Log("User pressed on: " & ButtonText)
*End Sub</code>
*/
//~RaisesSynchronousEvents:true
- (void)Msgbox2:(B4I *)bi :(NSString *)EventName :(NSString *)Message :(NSString *)Title :(B4IList *)Buttons;
//~hide
- (NSObject *)CallSubDebug:(B4I *)mine :(NSObject *)Component :(NSString *)Sub;
//~hide
- (NSObject *)CallSubDebug2:(B4I *)mine :(NSObject *)Component :(NSString *)Sub :(NSObject *)Argument;
//~hide
- (NSObject *)CallSubDebug3:(B4I *)mine :(NSObject *)Component :(NSString *)Sub :(NSObject *)Argument1 :(NSObject *)Argument2;

/**
* Dynamically calls a sub. This can be used to implement events.
* In most cases you should not use CallSub and instead directly call the target sub.
* Nothing happens if the sub does not exist.
* Component - The target module or instance.
* Sub - The sub name.
*/
//~RaisesSynchronousEvents:true
- (NSObject *)CallSub:(B4I *)mine :(NSObject *)Component :(NSString *)Sub;
/**
* Similar to CallSub. Calls a sub with a single argument.
*/
//~RaisesSynchronousEvents:true
- (NSObject *)CallSub2:(B4I *)mine :(NSObject *)Component :(NSString *)Sub :(NSObject *)Argument;
/**
* Similar to CallSub. Calls a sub with two arguments.
*/
//~RaisesSynchronousEvents:true
- (NSObject *)CallSub3:(B4I *)mine :(NSObject *)Component :(NSString *)Sub :(NSObject *)Argument1 :(NSObject *)Argument2;

/**
* Similar to CallSub.
* Sends a message to the message queue. When the message is processed the sub is called.
*/
- (void)CallSubDelayed:(B4I *)mine :(NSObject *)Component :(NSString *)Sub;

/**
* Similar to CallSubDelayed. Calls a sub with a single argument.
*/
- (void)CallSubDelayed2:(B4I *)mine :(NSObject *)Component :(NSString *)Sub :(NSObject *)Argument;

/**
* Similar to CallSubDelayed. Calls a sub with two arguments.
*/
- (void)CallSubDelayed3:(B4I *)mine :(NSObject *)Component :(NSString *)Sub :(NSObject *)Argument1 :(NSObject *)Argument2;

//~hide
- (B4I *)getComponentBI:(NSObject *)component;

/**
* Checks whether the given component has a sub with the given number of arguments.
*/
- (BOOL)SubExists:(NSObject *)Component :(NSString *)Sub :(int)NumberOfArguments;
//Returns true if ToolName equals "B4i".
- (BOOL)IsDevTool:(NSString *)ToolName;
//Returns the Objective C type of the given object.
- (NSString *)GetType:(NSObject *)Object;
//Internal keyword used by the Smart String literal.
- (NSString *)SmartStringFormatter:(NSString *)Format :(NSObject *)Value;

//Returns a reference to the current instance or module.
- (NSObject *)Me:(B4I *)bi;

/**
* Creates a single dimension array of the specified type.
*The syntax is: Array As type (list of values).
*Example:<code>
*Dim Days() As String
*Days = Array As String("Sunday", "Monday", ...)</code>
*/
- (void)Array;


/**
* Single line:
*If condition Then true-statement [Else false-statement]
*Multiline:
*If condition Then
* statement
*Else If condition Then
* statement
*...
*Else
* statement
*End If
*/
-(void)If;

/**
* Any exception thrown inside a try block will be caught in the catch block.
*Call LastException to get the caught exception.
*Syntax:
*Try
* ...
*Catch
* ...
*End Try
*/
-(void)Try;
/**
* Any exception thrown inside a try block will be caught in the catch block.
*Call LastException to get the caught exception.
*Syntax:
*Try
* ...
*Catch
* ...
*End Try
*/
- (void)Catch;
/**
* Declares a variable.
*Syntax:
*Declare a single variable:
*Dim variable name [As type] [= expression]
*The default type is String.
*
*Declare multiple variables. All variables will be of the specified type.
*Dim variable1 [= expression], variable2 [= expression], ..., [As type]
*Note that the shorthand syntax only applies to Dim keyword.
*Example:<code>Dim a = 1, b = 2, c = 3 As Int</code>
*
*Declare an array:
*Dim variable(Rank1, Rank2, ...) [As type]
*Example:<code>Dim Days(7) As String</code>
*The actual rank can be omitted for zero length arrays.
*/
-(void)Dim;
/**
* Loops while the condition is true.
* Syntax:
* Do While condition
*  ...
* Loop
*/
-(void)While;
/**
* Loops until the condition is true.
* Syntax:
* Do Until condition
*  ...
* Loop
*/
-(void)Until;
/**
* Syntax:
*For variable = value1 To value2 [Step interval]
* ...
*Next
*If the iterator variable was not declared before it will be of type Int.
*
*Or:
*For Each variable As type In collection
* ...
*Next
*Examples:<code>
*For i = 1 To 10
* Log(i) 'Will print 1 to 10 (inclusive).
*Next
*For Each n As Int In Numbers 'an array
* Sum = Sum + n
*Next
*</code>
*Note that the loop limits will only be calculated once before the first iteration.
*/
-(void)For;

/**
* Declares a structure.
*Can only be used inside sub Globals or sub Process_Globals.
*Syntax:
*Type type-name (field1, field2, ...)
*Fields include name and type.
*Example:<code>
*Type MyType (Name As String, Items(10) As Int)
*Dim a, b As MyType
*a.Initialize
*a.Items(2) = 123</code>
*/
-(void)Type;
/**
* Returns from the current sub and optionally returns the given value.
*Syntax: Return [value]
*/
-(void)Return;
/**
* Declares a sub with the parameters and return type.
*Syntax: Sub name [(list of parameters)] [As return-type]
*Parameters include name and type.
*The lengths of arrays dimensions should not be included.
*Example:<code>
*Sub MySub (FirstName As String, LastName As String, Age As Int, OtherValues() As Double) As Boolean
* ...
*End Sub</code>
*In this example OtherValues is a single dimension array.
*The return type declaration is different than other declarations as the array parenthesis follow the type and not
*the name (which does not exist in this case).
*/
-(void)Sub;

/**
* Compares a single value to multiple values.
* Example:<code>
*Dim value As Int = 7
* Select value
*  Case 1
*   Log("One")
*  Case 2, 4, 6, 8
*   Log("Even")
*  Case 3, 5, 7, 9
*   Log("Odd")
*  Case Else
*   Log("Larger than 9")
* End Select</code>
*/
- (void)Select;

/**
* Exits the most inner loop.
*Note that Exit inside a Select block will exit the Select block.
*/
- (void)Exit;

/**
* Stops executing the current iteration and continues with the next one.
*/
- (void)Continue;

@end
//~hide
@interface B4IStaticModule:B4IObjectWrapper
@property (nonatomic) B4I *bi;
@property (nonatomic) B4ICommon* __c;

- (void)initializeModule;

- (void)initializeStaticModules;

- (NSString *)_process_globals;
@end
/**
* A predefined object containing color constants.
* Colors are represented as Int values. The first byte is the alpha level and the other three values are the R, G and B components.
*/
//~shortname:Colors
@interface B4IColors:NSObject
@property(nonatomic, readonly) int Black;
@property(nonatomic, readonly) int DarkGray;
@property(nonatomic, readonly) int Gray;
@property(nonatomic, readonly) int LightGray;
@property(nonatomic, readonly) int White;
@property(nonatomic, readonly) int Red;
@property(nonatomic, readonly) int Green;
@property(nonatomic, readonly) int Blue;
@property(nonatomic, readonly) int Yellow;
@property(nonatomic, readonly) int Cyan;
@property(nonatomic, readonly) int Magenta;
@property(nonatomic, readonly) int Transparent;

/**
* Returns an integer value representing the color built from the three components.
* Each component should be a value between 0 to 255 (inclusive). The alpha is set to 255.
*/
- (int) RGB:(int)R :(int)G :(int)B;
//Similar to RGB. Allows you to set the alpha level.
- (int) ARGB:(int)A :(int)R :(int)G :(int)B;
@end

@class UIView;
@class B4IInputStream;
@class B4IOutputStream;
@class B4IFontWrapper;
@class B4ILabelWrapper;
@class B4IPanelWrapper;
@class B4ILayoutData;

//~Shortname:View
//~ObjectWrapper:UIView*
//~Event:Click
//~Event:LongClick
@interface B4IViewWrapper : B4IObjectWrapper
//Gets or sets the view's left position.
@property (nonatomic) float Left;
//Gets or sets the view's top position.
@property (nonatomic) float Top;
//Gets or sets the view's width.
@property (nonatomic) float Width;
//Gets or sets the view's height.
@property (nonatomic) float Height;
//Gets or sets the view's background color.
@property (nonatomic) int Color;
//Gets or sets the view's alpha level. 0 - transparent, 1 (default) - fully opaque.
@property (nonatomic) float Alpha;
//Gets or sets the view's tint color. Some views use this color to change their appearance.
@property (nonatomic) int TintColor;
//Gets or sets whether the view is visible.
@property (nonatomic) BOOL Visible;
//Returns true if the view is focused.
@property (nonatomic, readonly) BOOL IsFocused;
//Gets or sets whether the user can interact with this view. True by default.
@property (nonatomic) BOOL UserInteractionEnabled;
//Returns the views parent. The returned view can be uninitialized (if there is no parent).
@property (nonatomic, readonly) B4IViewWrapper *Parent;
/**
 * Calculates the keyboard top point relative to the current view.
 */
- (double)CalcRelativeKeyboardHeight:(double)KeyboardHeight;

+ (UIView *)build:(UIView *)prev :(NSMutableDictionary *)props :(BOOL)designer;

+ (void)buildResize:(UIView *)prev :(NSMutableDictionary *)props :(float)scale;

+ (UIColor *)buildColor:(NSDictionary *)props :(NSString *)field;

+ (UIColor *)B4IColorToUIColor:(int)Color;
//~hide
- (void)innerInitialize:(B4I *)bi :(NSString *)eventName :(BOOL)keepOldObject;

/**
* Animates the view's background color.
* DurationMS - Animation duration measured in milliseconds.
* BackgroundColor - The new background color.
* Note that Labels do not support this type of animation.
*/
- (void)SetColorAnimated:(int)DurationMS :(int)BackgroundColor;

/**
* Animates the view's alpha level.
* DurationMS - Animation duration measured in milliseconds.
* Alpha - The new alpha level (0 - transparent, 1 - fully opaque).
*/
- (void)SetAlphaAnimated:(int)DurationMS :(float)Alpha;

/**
* Animates the view's layout.
* DurationMS - Animation duration measured in milliseconds. Set to 0 to change the layout immediately.
* DampingRatio - If smaller than 1 then a spring effect will be applied to the animation. The minimum value should be 0.1.
* Set to 1 for no spring effect.
* Left, Top, Width and Height - The new layout.
*/
- (void)SetLayoutAnimated:(int)DurationMS :(float)DampingRatio :(float)Left :(float)Top :(float)Width :(float)Height;

/**
* Sets the view's border width, color and corner radius.
*Note that the corner radius should be 0 if the view should show a shadow as well.
*/
- (void)SetBorder:(float)Width :(int)Color :(float)CornerRadius;

/**
* Adds a shadow to to the view. The border corners radius should be set to 0 when adding shadows.
*Colors - The shadow color.
*OffsetX, OffsetY - The horizontal and vertical offsets.
*Opacity - Sets the shadow opacity: 0 - transparent, 1 - opaque.
*StaticRect - (optimization parameter) Set this parameter to True if the view's size is constant.
*/
- (void)SetShadow:(int)Color :(float)OffsetX :(float)OffsetY :(float)Opacity :(BOOL)StaticRect;
//Resizes the view to make it fit its content.
- (void)SizeToFit;

/**
* Tries to set the focus on the current view. Returns True if the focus was set. Most views are not focusable.
* When a text view is focused the keyboard is shown.
*/
- (BOOL)RequestFocus;
//Removes the focus from the current view. Removing the focus from a text view will hide the keyboard.
- (BOOL)ResignFocus;
//Removes the view from its parent (same as B4A View.RemoveView method).
- (void)RemoveViewFromParent;
//Brings the view to front.
- (void)BringToFront;
//Sends the view to the back.
- (void)SendToBack;

/**
* Adds a parallax effect to the view. The view will slightly move when the device is tilted.
* Vertical - Vertical offset. Can be a positive or negative value.
* Horizontal - Horizontal offset. Can be a positive or negative value.
*/
- (void)SetParallaxEffect:(int)Vertical :(int)Horizontal;
@end
@interface B4IControlWrapper:B4IViewWrapper
//Gets or sets whether the view is enabled.
@property (nonatomic) BOOL Enabled;

+ (UIView *)build:(UIView *)prev :(NSMutableDictionary *)props :(BOOL)designer;
@end
/**
* ScrollView is a scrollable container. It can scroll horizontally and vertically (based on the inner-panel size).
* ScrollView.Panel returns the inner-panel.
* You should add views to this panel.
* Note that ContentWidth and ContentHeight properties should be used when modifying the inner-panel size.
*/
//~Shortname:ScrollView
//~ObjectWrapper:UIScrollView*
//~Event:ScrollChanged (OffsetX As Int, OffsetY As Int)
@interface B4IScrollView : B4IViewWrapper
//Returns the inner-panel.
@property (nonatomic, readonly)B4IPanelWrapper *Panel;
//Gets or sets whether a bounce effect is applied when the panel reaches one of the edges.
@property (nonatomic)BOOL Bounces;
//If true then the ScrollView will automatically scroll to the nearest "page" which is a multiple of the ScrollView size.
@property (nonatomic)BOOL PagingEnabled;
//Gets or sets the inner-panel width.
@property (nonatomic)int ContentWidth;
//Gets or sets the inner-panel height.
@property (nonatomic)int ContentHeight;
//Gets or sets the current horizontal offset.
@property (nonatomic)int ScrollOffsetX;
//Gets or sets the current vertical offset.
@property (nonatomic)int ScrollOffsetY;
//Gets or sets whether scrolling is enabled.
@property (nonatomic)BOOL ScrollEnabled;
//Gets or sets whether to show the horizontal indicator during scrolling.
@property (nonatomic)BOOL ShowsHorizontalIndicator;
//Gets or sets whether to show the vertical indicator during scrolling.
@property (nonatomic)BOOL ShowsVerticalIndicator;

/**
* Scrolls to the given offsets.
* Animated - Whether the scrolling should be animated.
*/
- (void)ScrollTo:(int)OffsetX :(int)OffsetY :(BOOL)Animated;

/**
* Initializes the ScrollView.
*EventName - Sets the subs that will handle the events.
*Width - The inner-panel width.
*Height - The inner-panel height.
*/
- (void)Initialize:(B4I *)bi :(NSString *)EventName :(int)Width :(int)Height;

@end
/**
* A picker view based on a spinning wheel. A single view can show one or more columns (wheels).
*Note that the height of this view cannot be changed.
*/
//~Shortname:Picker
//~ObjectWrapper:UIPickerView*
//~Event:ItemSelected (Column As Int, Row As Int)
@interface B4IPickerWrapper : B4IViewWrapper

//Initializes the picker and sets the subs that will handle the events.
- (void)Initialize:(B4I *)bi :(NSString *)EventName;

/**
* Sets the items of the given column.
*Column - Column index. 0 is the first column.
* Items - A List (or array) with the items. Each item should be a String or an AttributedString.
*/
- (void)SetItems:(int)Column :(B4IList *)Items;
//Returns a list with the items in the specified index.
- (B4IList *)GetItems:(int)Column;

/**
* Sets the selected item.
* Column - Column index.
* Row - Row index.
* Animated - If True then the wheel will animate the change.
*/
- (void)SelectRow:(int)Column :(int)Row :(BOOL)Animated;

/**
* Returns the selected row in the specified column.
*/
- (int)GetSelectedRow:(int)Column;
//Returns the selected item in the specified column.
- (NSObject *)GetSelectedItem:(int)Column;

/**
* Sets the columns widths. For example if there are two columns:<code>
*Picker1.SetColumnsWidths(Array (100, 200))</code>
*/
- (void)SetColumnsWidths:(B4IList *)Widths;

//Sets the rows height. The default value is 30.
- (void)SetRowsHeight:(int)RowHeight;

@end
/**
* A String with formatting attributes.
*Note that an AttributedString cannot be used instead of String unless the method explicitly expects an AttributedString.
*/
//~Shortname:AttributedString
//~ObjectWrapper:NSAttributedString*
@interface B4IAttributedString : B4IObjectWrapper
+ (NSMutableDictionary *)createAttributes:(UIFont *)Font :(UIColor *)Color;
//Initializes an AttributesString with the given Text, Font and Color.
- (void)Initialize:(NSString *)Text :(B4IFontWrapper *)Font :(int)Color;
//Returns a regular string.
- (NSString *)ToString;
@end
/**
* A Button view. There are two types of buttons: system buttons and custom buttons.
* System buttons are created with one of the STYLE constants.
* Custom buttons can be customized by accessing the CustomLabel property.
*/
//~Shortname:Button
//~ObjectWrapper:UIButton*
@interface B4IButtonWrapper : B4IControlWrapper
//Gets or sets the button's text.
@property (nonatomic) NSString *Text;
@property (nonatomic, readonly) UIButtonType STYLE_SYSTEM;
@property (nonatomic, readonly) UIButtonType STYLE_DETAIL_DISCLOSURE;
@property (nonatomic, readonly) UIButtonType STYLE_INFO;
@property (nonatomic, readonly) UIButtonType STYLE_CONTACT_ADD;
//Gets the inner label. You can use this property to customize custom buttons.
@property (nonatomic, readonly) B4ILabelWrapper *CustomLabel;
//Initializes a custom button. Sets the text default color and the pressed state color.
- (void)InitializeCustom:(NSString *)EventName :(B4I *)bi :(int)TextColor :(int)PressedTextColor;

/**
* Initializes a system button.
* Example:<code>
* Dim b1 As Button
* b1.Initialize("b1", b1.STYLE_SYSTEM)</code>
*/
- (void)Initialize:(NSString *)EventName :(B4I *)bi :(UIButtonType)Style1;

@end
/**
* A two states switch view. Note that the actual size of this view cannot be changed.
* The ValueChanged event is raised when the state changes.
*/
//~shortname:Switch
//~ObjectWrapper:UISwitch*
//~Event:ValueChanged (Value As Boolean)
@interface B4ISwitchWrapper : B4IControlWrapper
//Gets or sets the current state.
@property (nonatomic)BOOL Value;
//Initializes the view.
- (void)Initialize:(B4I *)bi :(NSString *)EventName;
//Changes the current state. Animates the transition.
- (void)SetValueAnimated:(BOOL)Value;
@end

/**
* A view with an embedded browser engine.
* WebView can show online Urls or local html strings.
* PageFinished event is raised after a page is loaded.
* OverrideUrl is called before a page is loaded. If you return True from this method then the Url will not be loaded.
*/
//~shortname:WebView
//~ObjectWrapper:UIWebView*
//~Event:PageFinished (Success As Boolean, Url As String)
//~Event:OverrideUrl (Url As String) As Boolean
@interface B4IWebViewWrapper : B4IViewWrapper
//If True then the webpage is scaled to fit and zooming is enabled. Default value is false.
@property (nonatomic)BOOL ScaleToFit;
//Initializes the WebView.
- (void)Initialize:(B4I *)bi :(NSString *)EventName;
//Returns true if the WebView can navigate to the previous page.
- (BOOL)CanGoBack;
//Returns true if the WebView can navigate forward.
- (BOOL)CanGoForward;
//Navigates to the previous page.
- (void)GoBack;
//Navigates to the next page in the stack of pages.
- (void)GoForward;

//Releases internal resources. You should call this method before removing WebView from its parent.
- (void)Release;

/**
* Loads a url. Note that you cannot use this method to load files from the Assets folder.
* Example:<code>
* WebView1.LoadUrl("http://www.google.com")</code>
*/
- (void)LoadUrl:(NSString *)Url;

/**
* Loads the given html code. The path is relative to the assets folder.
*/
- (void)LoadHtml:(NSString *)Html;
@end
/**
* A view that shows a + and - buttons that allow the user to increment of decrement a numeric value.
* The value itself is not displayed (by this view).
* You can change the color by changing the TintColor property.
* ValueChanged event is raised when the value is changed.
*/
//~shortname:Stepper
//~ObjectWrapper:UIStepper*
//~Event:ValueChanged (Value As Double)
@interface B4IStepperWrapper : B4IControlWrapper
//Gets or sets the current value.
@property (nonatomic)double Value;
//Gets or sets the maximum value. Default value is 100.
@property (nonatomic)double MaximumValue;
//Gets or sets the minimum value. Default value is 0.
@property (nonatomic)double MinimumValue;
//Gets or sets the step value. Default value is 1.
@property (nonatomic)double StepValue;
//Initializes the stepper.
- (void)Initialize:(B4I *)bi :(NSString *)EventName;

@end
/**
* A horizontal bar with a thumb. The user can change the value by dragging the thumb.
* The ValueChanged event is raised when the value is changed.
* You can change the color by changing the TintColor property.
*/
//~shortname:Slider
//~ObjectWrapper:UISlider*
//~Event:ValueChanged (Value As Float)
@interface B4ISliderWrapper : B4IControlWrapper
//If False then the ValueChanged event will only be raised when the user releases the thumb.
@property (nonatomic)BOOL Continuous;
//Gets or sets the current value.
@property (nonatomic)float Value;
//Gets or sets the maximum value. The default value is 1.
@property (nonatomic)float MaximumValue;
//Gets or sets the minimum value. The default value is 0.
@property (nonatomic)float MinimumValue;
//Initializes the Slider.
- (void)Initialize:(B4I *)bi :(NSString *)EventName;

@end
/**
* A horizontal control that shows multiple titles.
*/
//~shortname:SegmentedControl
//~ObjectWrapper:UISegmentedControl*
//~Event:IndexChanged (Index As Int)
@interface B4ISegmentedControlWrapper : B4IControlWrapper
//If true then the control does not show the selected item. Default value is false.
@property (nonatomic)BOOL Momentary;
//Gets or sets the selected index. -1 means that no item is selected.
@property (nonatomic)int SelectedIndex;
- (void)Initialize:(B4I *)bi :(NSString *)EventName;
//Sets the control titles.
- (void)SetItems:(B4IList *)Items;
//Gets a List with the control titles.
- (B4IList *)GetItems;
@end

/**
* ActionSheet allows the user to select an item from a list of items.
*On iPhone devices the list usually slides up from the bottom of the screen.
*On iPad devices the list appears anchored to the ParentView.
* The list can optionally show a "cancel" item and a "destructive" item. These items will show with a different color.
*/
//~shortname:ActionSheet
//~ObjectWrapper:UIActionSheet*
//~Event:Click (Item As String)
@interface B4IActionSheetWrapper : B4IObjectWrapper
//Returns true if the sheet is currently visible.
@property (nonatomic, readonly)BOOL Visible;

/**
* Initializes the ActionSheet and sets the items.
* EventName - Sets the sub that will handle the Click event.
* Title - The sheet title. Note that Apple guidelines recommend not to use a title.
* CancelItem - An item that will appear in black color.
* DestructiveItem - An item that will appear in red color.
* OtherItems - A List (or array) with all other items.
*/
- (void)Initialize:(B4I *)bi :(NSString *)EventName :(NSString *)Title :(NSString *)CancelItem :(NSString *)DestructiveItem :(B4IList *)OtherItems;
//~RaisesSynchronousEvents:true
//Shows the ActionSheet. The sheet will be anchored to the ParentView (on iPad devices).
- (void)Show:(UIView *)ParentView;
//Dismisses the sheet.
- (void)Dismiss;
@end
/**
* A spinning indicator, similar to Android indeterminate progress bar.
*/
//~shortname:ActivityIndicator
//~ObjectWrapper:UIActivityIndicatorView*
@interface B4IActivityIndicatorWrapper : B4IViewWrapper
@property (nonatomic, readonly)int STYLE_WHITE_LARGE;
@property (nonatomic, readonly)int STYLE_WHITE;
@property (nonatomic, readonly)int STYLE_GRAY;
//Gets or sets the indicator color.
@property (nonatomic)int Color;
//Gets or sets the indicator style. One of the STYLE constants.
@property (nonatomic)int Style;
- (void)Initialize:(B4I *)bi;
@end
/**
* A horizontal view that displays the progress of a task to the user.
* The progress is a value between 0 to 1.
*/
//~shortname:ProgressView
//~ObjectWrapper:UIProgressView*
@interface B4IProgressWrapper : B4IViewWrapper
//Gets or sets the current progress (0 to 1).
@property (nonatomic)float Progress;
- (void)Initialize:(B4I *)bi;
//Sets the current progress with animation.
- (void)SetProgressAnimated:(float)Progress;
@end

//~hide
@interface B4ICustomViewWrapper : B4IViewWrapper
@property (nonatomic) NSObject *customObject;
@property (nonatomic) NSMutableDictionary *props;

- (void)AfterDesignerScript;
@end

@interface B4ITextInputTraitsWrapper :B4IViewWrapper
@property (nonatomic, readonly) int AUTOCORRECT_DEFAULT;
@property (nonatomic, readonly) int AUTOCORRECT_NO;
@property (nonatomic, readonly) int AUTOCORRECT_YES;

@property (nonatomic, readonly) int SPELLCHECK_DEFAULT;
@property (nonatomic, readonly) int SPELLCHECK_NO;
@property (nonatomic, readonly) int SPELLCHECK_YES;

@property (nonatomic, readonly) int AUTOCAPITALIZE_NONE;
@property (nonatomic, readonly) int AUTOCAPITALIZE_WORDS;
@property (nonatomic, readonly) int AUTOCAPITALIZE_SENTENCES;
@property (nonatomic, readonly) int AUTOCAPITALIZE_ALL;

@property (nonatomic, readonly) int TYPE_DEFAULT;
@property (nonatomic, readonly) int TYPE_ASCII_CAPABLE;
@property (nonatomic, readonly) int TYPE_NUMBERS_AND_PUNCTUATIONS;
@property (nonatomic, readonly) int TYPE_URL;
@property (nonatomic, readonly) int TYPE_NUMBER_PAD;
@property (nonatomic, readonly) int TYPE_PHONE_PAD;
@property (nonatomic, readonly) int TYPE_NAME_PHONE_PAD;
@property (nonatomic, readonly) int TYPE_EMAIL_ADDRESS;
@property (nonatomic, readonly) int TYPE_DECIMAL_PAD;
@property (nonatomic, readonly) int TYPE_WEB_SEARCH;

@property (nonatomic, readonly) int APPEARANCE_DEFAULT;
@property (nonatomic, readonly) int APPEARANCE_DARK;
@property (nonatomic, readonly) int APPEARANCE_LIGHT;

@property (nonatomic, readonly) int RETURN_DEFAULT;
@property (nonatomic, readonly) int RETURN_GO;
@property (nonatomic, readonly) int RETURN_NEXT;
@property (nonatomic, readonly) int RETURN_SEARCH;
@property (nonatomic, readonly) int RETURN_SEND;
@property (nonatomic, readonly) int RETURN_DONE;


//Gets or sets th
//Gets or sets the keyboard auto-correct mode (one of the AUTOCORRECT constants).
@property (nonatomic)int Autocorrect;
//Gets or sets the keyboard type (one of the TYPE constants).
@property (nonatomic)int KeyboardType;
//Gets or sets the keyboard appearance (one of the APPEARANCE constants).
@property (nonatomic)int KeyboardAppearance;
//Gets or sets the autocapitalize mode (one of the AUTOCAPITALIZE constants).
@property (nonatomic)int Autocapitalize;
//Gets or sets the return key (one of the RETURN constants).
@property (nonatomic)int ReturnKey;
//Set to true to change the text field to password mode.
@property (nonatomic)BOOL PasswordMode;

//Gets or sets the selection start position.
@property (nonatomic)int SelectionStart;
//Returns the text selection length. Use SetSelection method if you want to set the selection.
- (int)SelectionLength;
//Selects all text.
- (void)SelectAll;
//Sets the selected text.
- (void)SetSelection:(int)Start :(int)Length;

@end
/**
* A multiline, scrollable text field.
* The keyboard appears automatically when a text field is focused.
* You need to call TextView.ResignFocus to hide the keyboard.
*/
//~shortname:TextView
//~ObjectWrapper:UITextView*
//~Event:TextChanged (OldText As String, NewText As String)
//~Event:BeginEdit
//~Event:EndEdit
@interface B4ITextViewWrapper : B4ITextInputTraitsWrapper
//Gets or sets the text.
@property (nonatomic) NSString* Text;
//Gets or sets the text color.
@property (nonatomic) int TextColor;
//Gets or sets the font.
@property (nonatomic) B4IFontWrapper *Font;
@property (nonatomic, readonly) int ALIGNMENT_LEFT;
@property (nonatomic, readonly) int ALIGNMENT_RIGHT;
@property (nonatomic, readonly) int ALIGNMENT_CENTER;
//Gets or sets the text alignment (one of the ALIGNMENT constants).
@property (nonatomic) int TextAlignment;
//Gets or sets whether the field is editable.
@property (nonatomic) BOOL Editable;
- (void)Initialize:(B4I *)bi :(NSString *)EventName;
//Scrolls to the specified index.
- (void)ScrollTo:(int)Index;
@end
/**
* This item is assigned to a Page. When the Page is added to a TabBarController the item appears in the tab's bar.
* The item is made of a text and image. You can also select one of the system items.
*/
//~shortname:TabBarItem
//~ObjectWrapper:UITabBarItem*
@interface B4ITabBarItemItemWrapper : B4IObjectWrapper
@property (nonatomic, readonly) int ITEM_MORE;
@property (nonatomic, readonly) int ITEM_FAVORITES;
@property (nonatomic, readonly) int ITEM_TOP_RATED;
@property (nonatomic, readonly) int ITEM_RECENTS;
@property (nonatomic, readonly) int ITEM_CONTACTS;
@property (nonatomic, readonly) int ITEM_HISTORY;
@property (nonatomic, readonly) int ITEM_BOOKMARKS;
@property (nonatomic, readonly) int ITEM_SEARCH;
@property (nonatomic, readonly) int ITEM_DOWNLOADS;
@property (nonatomic, readonly) int ITEM_MOST_RECENT;
@property (nonatomic, readonly) int ITEM_MOST_VIEWED;
//Gets or sets whether the item is enabled.
@property (nonatomic) BOOL Enabled;
//Gets or sets the "badge" that is displayed above the item.
@property (nonatomic) NSString * Badge;
//Sets the horizontal and vertical offsets.
- (void)SetTitleOffset:(float)X :(float)Y;

/**
* Initializes the item with the given title, image and the selected image.
* Note that the images colors are ignored. Only the alpha values are used.
* Title - The item title. Pass empty string if no title should be displayed.
* Image - The item image. Pass Null if no image should be displayed. The image size should be 30x30.
* SelectedImage - The image to display when the item is selected.
*/
- (void)Initialize:(NSString *)Title :(B4IBitmap *)Image :(B4IBitmap *)SelectedImage;

/**
* Initializes an item with one of the predefined system items (ITEM constants).
*/
- (void)InitializeSystem:(int)Type;

/**
* Sets the title font.
*/
- (void)SetFont:(B4IFontWrapper *)Font;
@end
/**
* BarButtons are assigned to Pages. These buttons appear when a Page is added to a NavigationConroller.
* There are four types of bar buttons: custom, text, bitmap or system.
* You can use the designer to create these buttons.
* Note that the designer adds "flexible space" items between each two buttons automatically.
* The Tag value is important as it is used to distinguish between the buttons in the Page_BarButtonClick event.
*/
//~shortname:BarButton
//~ObjectWrapper:UIBarButtonItem*
@interface B4IBarButtonItemWrapper : B4IObjectWrapper
@property (nonatomic, readonly) int ITEM_DONE;
@property (nonatomic, readonly) int ITEM_CANCEL;
@property (nonatomic, readonly) int ITEM_EDIT;
@property (nonatomic, readonly) int ITEM_SAVE;
@property (nonatomic, readonly) int ITEM_ADD;
@property (nonatomic, readonly) int ITEM_FLEXIBLE_SPACE;
@property (nonatomic, readonly) int ITEM_COMPOSE;
@property (nonatomic, readonly) int ITEM_REPLY;
@property (nonatomic, readonly) int ITEM_ACTION;
@property (nonatomic, readonly) int ITEM_ORGANIZE;
@property (nonatomic, readonly) int ITEM_BOOKMARKS;
@property (nonatomic, readonly) int ITEM_SEARCH;
@property (nonatomic, readonly) int ITEM_REFRESH;
@property (nonatomic, readonly) int ITEM_STOP;
@property (nonatomic, readonly) int ITEM_CAMERA;
@property (nonatomic, readonly) int ITEM_TRASH;
@property (nonatomic, readonly) int ITEM_PLAY;
@property (nonatomic, readonly) int ITEM_PAUSE;
@property (nonatomic, readonly) int ITEM_REWIND;
@property (nonatomic, readonly) int ITEM_FASTFORWARD;
@property (nonatomic, readonly) int ITEM_UNDO;
@property (nonatomic, readonly) int ITEM_REDO;
//Gets or sets the button color.
@property (nonatomic) int TintColor;
//Gets or sets whether the button is enabled.
@property (nonatomic) BOOL Enabled;

+ (UIBarButtonItem *)buildBarButton:(NSMutableDictionary *)props :(BOOL)designer;
//Initializes a system button with one of the ITEM constants.
- (void)InitializeSystem:(int)Type :(NSString *)Tag;
//Initializes a text button.
- (void)InitializeText:(NSString *)Text :(NSString *)Tag;
//Initializes a bitmap button.
- (void)InitializeBitmap:(UIImage *)Bitmap :(NSString *)Tag;
//Initializes a bar button made of a custom view.
- (void)InitializeCustom:(UIView *)View;
//Sets the button font.
- (void)SetFont:(B4IFontWrapper *)Font;
@end
/**
* A single line text field.
* The keyboard appears automatically when a text field is focused.
* You need to call TextField.ResignFocus to hide the keyboard.
*/
//~shortname:TextField
//~ObjectWrapper:UITextField*
//~Event:TextChanged (OldText As String, NewText As String)
//~Event:EnterPressed
//~Event:BeginEdit
//~Event:EndEdit
@interface B4ITextFieldWrapper : B4ITextInputTraitsWrapper
//Gets or sets the text.
@property (nonatomic) NSString *Text;
//Gets or sets the text color.
@property (nonatomic) int TextColor;
//Gets or sets the text font.
@property (nonatomic) B4IFontWrapper *Font;
//If true then the font size is adjusted automatically to make room for all the text.
@property (nonatomic) BOOL AdjustFontSizeToFit;
//Gets or sets whether the field is enabled.
@property (nonatomic) BOOL Enabled;
@property (nonatomic, readonly) int ALIGNMENT_LEFT;
@property (nonatomic, readonly) int ALIGNMENT_RIGHT;
@property (nonatomic, readonly) int ALIGNMENT_CENTER;
//Gets or sets the hint that appears when no text is set.
@property (nonatomic)NSString *HintText;
//Gets or sets the text alignment (one of the ALIGNMENT constants).
@property (nonatomic) int TextAlignment;
//Gets or sets the border style (one of the STYLE constants).
@property (nonatomic)int BorderStyle;
@property (nonatomic, readonly) int STYLE_NONE;
@property (nonatomic, readonly) int STYLE_LINE;
@property (nonatomic, readonly) int STYLE_BEZEL;
@property (nonatomic, readonly) int STYLE_ROUNDEDRECT;
//Gets or sets whether the clear button is visible when the field is focused.
@property (nonatomic)BOOL ShowClearButton;
- (void)Initialize:(B4I *)bi :(NSString *)EventName;
@end

/**
* A view that allows the user to pick a date or time (or both).
*/
//~Shortname:DatePicker
//~ObjectWrapper:UIDatePicker*
//~Event: ValueChanged
@interface B4IDatePickerWrapper:B4IViewWrapper
//Time picker mode.
@property (nonatomic, readonly)int MODE_TIME;
//Date picker mode.
@property (nonatomic, readonly)int MODE_DATE;
//Date and time picker mode.
@property (nonatomic, readonly)int MODE_DATE_TIME;
//Gets or sets the selected date (and time).
@property (nonatomic)long long Ticks;
//Gets or sets the minute wheel interval. The value should be evenly divided into 60.
@property (nonatomic)int MinuteInterval;
//Gets or sets the picker mode. Should be one of the MODE constants.
@property (nonatomic)int Mode;
- (void)Initialize:(B4I *)bi :(NSString *)EventName;
//Limits the dates to the given range.
- (void)SetValidRange:(long long)MinTicks :(long long)MaxTicks;
@end

/**
* A view that shows readonly text.
*/
//~Shortname:Label
//~ObjectWrapper:UILabel*
@interface B4ILabelWrapper :B4IViewWrapper
//Gets or sets the label text.
@property (nonatomic) NSString *Text;
//Gets or sets the text color.
@property (nonatomic) int TextColor;
//Gets or sets the label font.
@property (nonatomic) B4IFontWrapper *Font;
//Gets or sets whether the label should show multiple lines.
@property (nonatomic) BOOL Multiline;
//If true then the label will adjust the font size to make room for all the text.
@property (nonatomic) BOOL AdjustFontSizeToFit;
@property (nonatomic, readonly) int ALIGNMENT_LEFT;
@property (nonatomic, readonly) int ALIGNMENT_RIGHT;
@property (nonatomic, readonly) int ALIGNMENT_CENTER;
//Gets or sets the text alignment (one of the ALIGNMENT constants).
@property (nonatomic) int TextAlignment;

- (void)Initialize:(B4I *)bi :(NSString *)EventName;
@end
/**
* Font is a predefined object that provides access to the device installed fonts.
*/
//~Shortname:Font
//~ObjectWrapper:UIFont
@interface B4IFontWrapper : B4IObjectWrapper
//Returns the default font.
@property (nonatomic, readonly)B4IFontWrapper *DEFAULT;
//Returns the default bold font.
@property (nonatomic, readonly)B4IFontWrapper *DEFAULT_BOLD;
//Returns the default italic font.
@property (nonatomic, readonly)B4IFontWrapper *DEFAULT_ITALIC;
//Returns the font name.
@property (nonatomic, readonly)NSString *Name;
//Returns the font size.
@property (nonatomic, readonly)float Size;

+ (B4IFontWrapper *)fromDesignerMap:(NSMutableDictionary *)props :(float)scale;

//Creates a new font with the specified size (based on the default font).
- (B4IFontWrapper *)CreateNew:(float)Size1;
//Creates a new font with the specified size and font name.
- (B4IFontWrapper *)CreateNew2:(NSString *)Name :(float)Size1;
//Creates a new bold font with the specified size (based on the default font).
- (B4IFontWrapper *)CreateNewBold:(float)Size1;
//Creates a new italic font with the specified size (based on the default font).
- (B4IFontWrapper *)CreateNewItalic:(float)Size1;
//Returns an array of strings with all available fonts names.
- (B4IArray */*NSString,1*/)AvailableNames;
@end
/**
* A page is a container that contains other views.
*The main element of a page is the RootPanel. With this panel you can add or remove views.
* Note that the "Event Name" of the RootPanel is the same as the Page's Event Name.
*You can use a NavigationController or a TabController to manage multiple pages.
*/
//~Shortname:Page
//~ObjectWrapper:UIViewController*
//~Event:Appear
//~Event:Disappear
//~Event:BarButtonClick (Tag As String)
//~Event:KeyboardStateChanged (Height As Float)
@interface B4IPage : B4IObjectWrapper
//~hide
- (void)setStatusBarHeight:(float)height;
//Removes focus from all views on this page. This will hide the keyboard if it is visible.
- (void)ResignFocus;

+ (void)buildPage:(UIViewController *)controller :(NSMutableDictionary *)props :(BOOL)designer;

//Gets or sets the page title. This title appears in the navigation bar when a NavigationController is used.
@property (nonatomic) NSString * Title;
//Gets or sets the page prompt. This text will appear under the title.
@property (nonatomic) NSString * Prompt;
//If false then the back button will appear when this page is the top page and there are other pages in the back. Default value is false.
@property (nonatomic) BOOL HideBackButton;
//Gets a reference to the main panel that holds the other views.
@property (nonatomic, readonly) B4IPanelWrapper *RootPanel;
/**
* Gets or sets an array of BarButtons that will appear in the Toolbar (if it is visible).
* Note that you should set a new list or array in order to update the buttons as the returned list is a copy of the internal list.
*/
@property (nonatomic)B4IList *ToolbarButtons;
/**
*Gets or sets an array of BarButtons that will appear near the top-right corner (if the navigation bar is visible).
*Note that you should set a new list or array in order to update the buttons as the returned list is a copy of the internal list.
 */
@property (nonatomic)B4IList *TopRightButtons;
/**
*Gets or sets an array of BarButtons that will appear near the top-left corner (if the navigation bar is visible).
*Note that you should set a new list or array in order to update the buttons as the returned list is a copy of the internal list.
*/
@property (nonatomic)B4IList *TopLeftButtons;
//Returns true if this page is currently visible.
@property (nonatomic, readonly)BOOL Visible;
//Gets or sets the TabBarItem that will appear when this page is added to a TabBarController.
@property (nonatomic)B4ITabBarItemItemWrapper *TabBarItem;
- (void)Initialize:(B4I *)bi :(NSString *)EventName;

@end

//~hide
@interface B4IViewController : UIViewController
@property (nonatomic) B4IMainView *mainView;

- (void)toolbarClick:(id)sender;
@end
/**
* A controller that manages a set of pages in a stack.
* This is the default controller. It can optionally show a navigation bar (at the top) and a toolbar (at the bottom).
* The items in these bars are set by the current visible page.
* When you call ShowPage the page is added to the top of the stack.
*If the page is already in the stack then all the pages above it will be removed.
*/
//~Shortname:NavigationController
//~ObjectWrapper: UINavigationController*
@interface B4INavigationControllerWrapper: B4IObjectWrapper
//Gets or sets whether the navigation bar is visible. Default value is true.
@property (nonatomic)BOOL NavigationBarVisible;
/**
 * Gets or sets whether the tool bar (bottom bar) is visible. Default value is false.
 *Note that you should first show a page and only then add the toolbar.
 */
@property (nonatomic)BOOL ToolBarVisible;
+ (void)buildNavControl:(UINavigationController *)controller :(NSMutableDictionary *)props :(BOOL)designer;
/**
 * Similar to setting the NavigationBarVisible. Hides or shows the bar with animation.
 */
- (void)SetNavigationBarVisibleAnimated:(BOOL)Visible;

- (void)Initialize:(B4I *)bi :(NSString *)EventName;
//Clears the current stack and sets a new stack of pages. This can be useful when you restore the state of an app.
- (void)SetPagesStack:(B4IList *)Pages;

/**
* Adds a page to the top of the stack. If the page is already in the stack then all pages above it will be removed.
*The transition will be animated.
*/
- (void)ShowPage:(UIViewController *)Page;

/**
* Similar to ShowPage.
*Animated - Whether the transition will be animated or not.
*/
- (void)ShowPage2:(UIViewController *)Page :(BOOL)Animated;

//Removes the current top page from the stack. The transition will be animated.
- (void)RemoveCurrentPage;

/**
* Similar to RemoveCurrentPage.
*Animated - Whether the transition will be animated or not.
*/
- (void)RemoveCurrentPage2:(BOOL)Animated;
@end
/**
 * A controller that contains other pages and allows the user to switch pages by swiping right or left.
 *Set this controller by assigning App.KeyController.
 */
//~Shortname:PageViewController
//~Objectwrapper: UIPageViewController*
@interface B4IPageViewControllerWrapper: B4IObjectWrapper
/**
 * Sets the current selected (visible) page.
 */
- (void)SetSelectedPage:(int)PageIndex;
/**
 * Initializes the controller and sets the child pages.
 *EventName - Sets the subs that will handle the events. Currently this parameter is not used.
 *Pages - A List (or Array) with the child pages.
 */
- (void)Initialize:(B4I *)bi :(NSString *)EventName :(B4IList *)Pages;

@end
/**
* A root controller that contains other pages and allows the user to select the current page by clicking on the tab bar.
* Set this controller by assigning it to App.KeyController.
*/
//~Shortname:TabBarController
//~ObjectWrapper: UITabBarController*
@interface B4ITabBarControllerWrapper: B4IObjectWrapper
//Gets or sets the current selected index.
@property (nonatomic)int SelectedIndex;
//Gets or sets the tab pages.
@property (nonatomic)B4IList *Pages;
- (void)Initialize:(B4I *)bi :(NSString *)EventName;

@end
/**
* A mutable string, unlike regular strings which are immutable.
* StringBuilder allows you to quickly concatenate strings and modify the content.
*/
//~Shortname:StringBuilder
//~ObjectWrapper:NSMutableString*
@interface B4IStringBuilder : B4IObjectWrapper<B4IDebuggable>

- (void)Initialize;
//Appends the specified text to the StringBuilder and returns the current StringBuilder.
- (B4IStringBuilder *)Append:(NSString *)Text;
//Converts the StringBuilder content to a regular string.
- (NSString *)ToString;
//Removes the characters between StartOffset (inclusive) and EndOffset (exclusive) and returns the current StringBuilder.
- (B4IStringBuilder *)Remove:(int)StartOffset :(int)EndOffset;
//Inserts the given Text at the specified Offset and returns the current StringBuilder.
- (B4IStringBuilder *)Insert:(int)Offset :(NSString *)Text;
//Returns the string length.
@property (nonatomic, readonly) int Length;
@end
/**
* List is similar to a dynamic array of objects. You can add, insert or remove items from the list.
* Note that arrays are converted to lists automatically when needed.
*/
//~Shortname:List
//~ObjectWrapper:NSArray*
@interface B4IList : B4IObjectWrapper<B4IIterable, B4IDebuggable>
@property (nonatomic, readonly)int Size;

+ (NSArray *)debugList:(int)limit :(NSArray *)arr;
//Initializes an empty list.
- (void)Initialize;
//Initializes a list that wraps the given array.
- (void)Initialize2:(B4IList *)Array;
//Tests whether the list is readonly. A list that is returned from a library call might be read-only.
- (BOOL)IsReadOnly;
//Removes all items from the list.
- (void)Clear;
//Adds an item to the end of the list.
- (void)Add:(NSObject *)Item;
//Adds all the items from one list to the end of this list.
- (void)AddAll:(B4IList *)List;
//Adds all items from one list to this list, starting at the specified index.
- (void)AddAllAt:(int)Index :(B4IList *)List;
//Removes the item in the specified index.
- (void)RemoveAt:(int)Index;
//Inserts an item in the specified index.
- (void)InsertAt:(int)Index :(NSObject *)Item;
//Returns the item in the specified index.
- (NSObject *)Get:(int)Index;
//Sets the item in the specified index.
- (void)Set:(int)Index :(NSObject *)Item;
//Returns the index of the specified item. Returns -1 if the item was not found.
- (int)IndexOf:(NSObject *)Item;
/**
* Sorts the list. If the first item in the in the list is a number then the list will be numerically sorted.
 *Otherwise the list will be lexicographically sorted.
 */
- (void)Sort:(BOOL)Ascending;
//Similar to Sort. Ignores the strings case.
- (void)SortCaseInsensitive:(BOOL)Ascending;

/**
* Sorts a list with items of user defined type. The list is sorted based on the specified field.
*FieldName - The case-sensitive field name that will be used for sorting. Field must contain numbers of strings.
*Ascending - Whether to sort ascending or descending.
*/
- (void)SortType:(NSString *)FieldName :(BOOL)Ascending;

/**
* Similar to SortType. Ignores the strings case when sorting.
*/
- (void)SortTypeCaseInsensitive:(NSString *)FieldName :(BOOL)Ascending;
@end

//~hide
@interface B4IClass: NSObject
@property (nonatomic) B4I *bi;
@property (nonatomic) B4ICommon *__c;
+ (B4I *)createBI;

- (void)initializeClassModule;

- (NSString *)_class_globals;

- (BOOL)IsInitialized;
@end
/**
* A Matcher object is used to search for a pattern in a string.
*/
//~Shortname:Matcher
@interface B4IMatcher : NSObject
//~hide
- (instancetype)init:(NSArray *)matches1 :(NSString *)text;

/**
* Searches for the next substring that matches the pattern.
* Returns True if a match was found.
*/
- (BOOL)Find;

/**
* Returns the captured group with the specified index. Group 0 returns the full match.
*/
- (NSString *)Group:(int)Index;
//Returns the start offset of the specified captured group.
- (int)GetStart:(int)Index;
//Returns the end offset of the specified captured group.
- (int)GetEnd:(int)Index;
//Returns the number of groups.
@property (nonatomic, readonly)int GroupCount;
//Returns the matched string (same as Group(0)).
@property (nonatomic, readonly)NSString *Match;
@end

/**
* Regex is a predefined object that contains regular expressions related methods.
* All methods receive a 'pattern' string. This is the regular expression pattern.
*/
@interface B4IRegex :NSObject
//Changes ^ and $ to match the start and end of each line instead of the whole string.
@property (nonatomic, readonly) int MULTILINE;
//Enables case insensitive matching.
@property (nonatomic, readonly) int CASE_INSENSITIVE;

/**
* Tests whether the given text is a match for the given pattern.
* The whole text should match the pattern. Use matcher to search for a substring that matches the pattern.
* Note that it will return False for empty strings.
*/
- (BOOL)IsMatch:(NSString *)Pattern :(NSString *)Text;
//Similar to IsMatch. Allows you to set the pattern options.
- (BOOL)IsMatch2:(NSString *)Pattern :(int)Options :(NSString *)Text;

/**
* Replaces all the matches in the text based on the specified pattern and template.
*/
- (NSString *)Replace:(NSString *)Pattern :(NSString *)Text :(NSString *)Template;
//Similar to Replace. Allows you to set the pattern options.
- (NSString *)Replace2:(NSString *)Pattern :(int)Options :(NSString *)Text :(NSString *)Template;
//Creates a Matcher that can be used to search for matching substrings in the text.
- (B4IMatcher *)Matcher:(NSString *)Pattern :(NSString *)Text;
//Similar to Matcher. Allows you to set the pattern options.
- (B4IMatcher *)Matcher2:(NSString *)Pattern :(int)Options :(NSString *)Text;
//Splits the text to an array of strings based on the given pattern.
- (B4IArray */*string,1*/)Split:(NSString *)Pattern :(NSString *)Text;
//Similar to Split. Allows you to set the pattern options.
- (B4IArray */*string,1*/)Split2:(NSString *)Pattern :(int)Options :(NSString *)Text;
@end
/**
* Application is a special singleton object that allows you to handle application related events and
* holds other application related methods.
* The events can only be handled in the main module. The subs prefix should be Application.
* The Start event is raised when the application starts. Nav is the default navigation controller.
* The Active event is raised when the application becomes active. It is usually raised immediately after Start event and after resuming from the background.
* The InActive event is raised when the applications becomes inactive.
* This happens when there is an interruption such as a phone call or before the Background event.
* The Background event is raised when the process is moved to the background. You should expect the process to be killed a few seconds after this event.
* The Foreground event is raised when the app returns to the foreground after it was in the background (assuming that the process was not killed).
* The OpenUrl event is raised when another app has called OpenUrl with a scheme that this app has registered.
*/
//~ShortName:Application
//~ObjectWrapper:UIApplication*
//~Event:Start (Nav As NavigationController)
//~Event:Active
//~Event:Inactive
//~Event:Background
//~Event:OpenUrl (Url As String, Data As Object, SourceApplication As String) As Boolean
//~Event:Foreground
//~Event:ReceiveLocalNotification (LN As Notification)
//~Event:PushToken (Success As Boolean, Token() As Byte)
//~Event:RemoteNotification (Message As Map, CompletionHandler As CompletionHandler)
@interface B4IApplicationWrapper:B4IObjectWrapper
/**
* Gets or sets whether the network activity indicator (in the top bar) is visible.
*/
@property (nonatomic) BOOL NetworkActivityIndicatorVisible;
//Returns true if the current process is a 64 bit process.
@property (nonatomic, readonly)BOOL Is64BitProcess;
//Returns a Map with data passed to the app during launch (if there is such data).
@property (nonatomic)B4IMap* LaunchOptions;
/**
* If true then the screen will not be locked automatically even if the user is not interacting with it,
* as long as the application is in the foreground.
*/
@property (nonatomic)BOOL IdleTimerDisabled;
//Returns true if the current device is an iPad device.
@property (nonatomic, readonly) BOOL iPadDevice;
//Returns a string describing the current version.
@property (nonatomic, readonly) NSString *OSVersion;
//Gets or sets the root controller. You can use this property to switch to a different controller.
@property (nonatomic) UIViewController *KeyController;

- (BOOL)IsSimulator;
/**
*Returns true if there is an app that can open the given url.
 *Starting from iOS 9 you need to use the #QueriesScheme to list the schemes that will be passed to this method.
 */
- (BOOL)CanOpenURL:(NSString *)Url;
//Sends the Url to the system. If there is an app registered to the Url scheme then the app will be started.
- (BOOL)OpenURL:(NSString *)Url;
//Calls OpenUrl from a background thread. This is useful as OpenURL can sometimes take several seconds to complete.
- (void)OpenURLAsync:(NSString *)Url;

/**
* Gets or sets the app icon badge number. You need to call RegisterUserNotifications before setting this property.
*/
@property (nonatomic)int ApplicationIconBadgeNumber;

/**
* Requests the user permission to use one of more of the notifications features.
* You must call this method before registering a local notification or setting the ApplicationIconBadgeNumber.
*/
- (void)RegisterUserNotifications:(BOOL)Badge :(BOOL)Sound :(BOOL)Alert;

- (void)RegisterForRemoteNotifications;

//Clears all scheduled local notifications.
- (void)ClearLocalNotifications;
//Returns a list with the scheduled local notifications.
- (B4IList *)GetScheduledNotifications;

@end

@interface UIView (B4I)
@property (nonatomic) float Left;
@property (nonatomic) float Top;
@property (nonatomic) float Width;
@property (nonatomic) float Height;

- (void)SetLayoutAnimated:(int)DurationMS :(float)DampingRatio :(float)Left :(float)Top :(float)Width :(float)Height;
@end

//~hide
@interface NSObject(B4I)

- (BOOL)IsKindOfNumber:(NSString *)type;
@end

@interface NSString (B4I)
//Returns the string length.
- (int)Length;

/**
* Returns the index of the first occurrence of the specified string in this string.
* Returns -1 if the string is not found.
*/
- (int)IndexOf:(NSString *)SearchFor;

/**
* Similar to IndexOf. Starts the search from Index.
*/
- (int)IndexOf2:(NSString *)SearchFor :(int)Index;

/**
* Returns the index of the first occurrence of the specified string in this string.
* The search starts at the end of this string and advances to the beginning.
*/
- (int)LastIndexOf:(NSString *)SearchFor;

/**
* Similar to LastIndexOf. The search starts at the given index.
*/
- (int)LastIndexOf2:(NSString *)SearchFor :(int)Index;
//Returns a copy of the original string without any leading or trailing white spaces.
- (NSString *)Trim;

/**
* Returns a new string which is a substring of the original string.
* The new string will include the character at BeginIndex and will extend to the end of the string.
* Example:<code>
* "012345".SubString(2) 'Returns "2345"</code>
*/
- (NSString *)SubString:(int)BeginIndex;
/**
* Returns a new string which is a substring of the original string.
* The new string will include the character at BeginIndex and will extend to the character as EndIndex (exclusive).
* Example:<code>
* "012345".SubString(2, 4) 'Returns "23"</code>
*/
- (NSString *)SubString2:(int)BeginIndex :(int)EndIndex;
/**
* Lexicographically compares the two strings.
* Returns a value less than 0 if the current string precedes Other.
* Returns 0 if both strings are equal.
* Returns a value larger than 0 if the current string comes after Other.
* Note that upper case characters precede lower case characters.
* Examples:<code>
*"abc".CompareTo("da")  ' < 0
* "abc".CompareTo("Abc") ' > 0
* "abc".CompareTo("abca")' < 0</code>
 */
- (int)CompareTo:(NSString *)Other;
//Returns true if both strings are equal ignoring their case.
- (BOOL)EqualsIgnoreCase:(NSString *)Other;
//Returns the character at the given index.
- (unichar)CharAt:(int)Index;
//Returns true if this string starts with the given Prefix.
- (BOOL)StartsWith:(NSString *)Prefix;
//Returns true if this string ends with the given Suffix.
- (BOOL)EndsWith:(NSString *)Suffix;
//Returns a new string resulting from the replacement of all the occurrences of Target with Replacement.
- (NSString *)Replace:(NSString *)Target :(NSString *)Replacement;
//Returns a new string which is the result of lower casing this string.
- (NSString *)ToLowerCase;
//Tests whether the string contains the given string parameter.
- (BOOL)Contains:(NSString *)SearchFor;
//Returns a new string which is the result of upper casing this string.
- (NSString *)ToUpperCase;

/**
* Encodes the string into a new array of bytes.
* You can use ByteToString keyword to convert an array of bytes (encoded string) to a string.
* Example:<code>
* Dim Data() As Byte = "Some string".GetBytes("UTF8")</code>
*/
- (B4IArray */*unsigned char,1*/)GetBytes:(NSString *)CharSet;
//Returns the width of this string drawn with the given font.
- (float)MeasureWidth:(B4IFontWrapper *)Font;
//Returns the height of this string drawn with the given font.
- (float)MeasureHeight:(B4IFontWrapper *)Font;
@end

/**
* A predefined object containing bitwise related methods.
*/
@interface B4IBit : NSObject
//Returns the bitwise AND of the two values.
- (int)And:(int)N1 :(int)N2;
//Returns the bitwise OR of the two values.
- (int)Or:(int)N1 :(int)N2;
//Returns the bitwise XOR of the two values.
- (int)Xor:(int)N1 :(int)N2;
//Returns the bitwise complement of the given value.
- (int)Not:(int)N;

/**
* Shifts N left.
* Shift - Number of positions to shift.
*/
- (int)ShiftLeft:(int)N :(int)Shift;

/**
* Shift N right.
* Keeps the original value sign.
* Shift - Number of positions to shift.
*/
- (int)ShiftRight:(int)N :(int)Shift;
/**
* Shift N right.
* Shifts zeroes in the leftmost positions.
* Shift - Number of positions to shift.
*/
- (int)UnsignedShiftRight:(int)N :(int)Shift;

/**
* Parses Value as an integer using the specified radix.
* Radix - Should be between 2 to 36.
*/
- (int)ParseInt:(NSString *)Value :(int)Radix;

/**
* Reads the data from the input stream and writes it into an array of bytes.
* The input stream is automatically closed at the end.
*/
- (B4IArray */*byte,1*/)InputStreamToBytes:(B4IInputStream *)In;
//Computes the floating point remainder of N1 / N2.
- (double)FMod:(double)N1 :(double)N2;
@end
//~hide
@interface B4IMainView : UIView
@property (nonatomic) NSInteger statusBarSize;
@property(nonatomic) CGSize currentSize;

- (B4IPanelView *)getHolder;

- (UIViewController *)getViewController;

- (id)init:(UIViewController *)page;
@end

/**
* A predefined object containing files related methods. Note that iOS devices file system is case sensitive.
* Note that each application can only access its own files. There is not any shared location (such as Android File.DirRootExternal).
*/
@interface B4IFile : NSObject
//Returns a reference to the files added to the Files tab. These files are read-only.
@property (nonatomic, readonly) NSString *DirAssets;
/**
* The place for any non-user generated persistent files. This folder is backed up by iTunes automatically.
* You can create a subfolder named Caches. Files under that folder will not be backed up.
*/
@property (nonatomic, readonly) NSString *DirLibrary;
/**
* The documents folder should only be used to store user generated content. It is possible to make this folder sharable through iTunes.
* This folder is backed up by iTunes automatically.
*/
@property (nonatomic, readonly) NSString *DirDocuments;
/**
* A temporary folder. Files in this folder are not backed up by iTunes and may be deleted from time to time.
*/
@property (nonatomic, readonly) NSString *DirTemp;

//~hide
@property (nonatomic)NSString *virtualAssetsFolder;

//Checks whether the given file exists.
- (BOOL)Exists:(NSString *)Dir :(NSString *)FileName;
//Deletes the given file. Returns true if the file was deleted.
- (BOOL)Delete:(NSString *)Dir :(NSString *)FileName;
//Creates a new folder under Parent folder/
- (void)MakeDir:(NSString *)Parent :(NSString *)Dir;
//Opens an InputStream to the given file.
- (B4IInputStream *)OpenInput:(NSString *)Dir :(NSString *)FileName;
//~hide
- (NSString *)checkAssets:(NSString *)Dir :(NSString *)file :(BOOL)write;

/**
* Opens an OutputStream to the given file.
* Append - If true then new data will be appended to the existing data.
*/
- (B4IOutputStream *)OpenOutput:(NSString *)Dir :(NSString *)FileName :(BOOL)Append;
//Copies the source file to the target location.
- (void)Copy:(NSString *)DirSource :(NSString *)FileSource :(NSString *)DirTarget :(NSString *)FileTarget;

/**
* Copies the input stream to the output stream. The input stream is closed at the end.
*/
- (void)Copy2:(B4IInputStream *)In :(B4IOutputStream *)Out;
//Combines the Dir and FileName to a single string.
- (NSString *)Combine:(NSString *)Dir :(NSString *)FileName;
//Returns a List with the files under the specified directory.
- (B4IList *)ListFiles:(NSString *)Dir;
//Marks a file to be excluded from iTunes backup.
- (void)SetExcludeFromBackup:(NSString *)Dir :(NSString *)FileName :(BOOL)Value;
//Tests whether the specified file is a directory.
- (bool)IsDirectory:(NSString *)Dir :(NSString *)FileName;

//(advanced) Returns a Map with the file attributes.
- (B4IMap *)GetAttributes:(NSString *)Dir :(NSString *)FileName;
//Returns the file size.
- (long long)Size:(NSString *)Dir :(NSString *)FileName;

- (long long)LastModified:(NSString *)Dir :(NSString *)FileName;

//Reads the given text file and returns a list. Each line in the file is converted to a list item.
- (B4IList *)ReadList:(NSString *)Dir :(NSString *)FileName;
//Reads the text file with UTF8 encoding.
- (NSString *)ReadString:(NSString *)Dir :(NSString *)FileName;
//Reads the text file with the given encoding.
- (NSString *)ReadString2:(NSString *)Dir :(NSString *)FileName :(NSString *)CharSet;
//Writes the string to a file with the specified encoding.
- (void)WriteString2:(NSString *)Dir :(NSString *)FileName :(NSString *)Text :(NSString *)CharSet;
//Writes the string to a file with UTF8 encoding.
- (void)WriteString:(NSString *)Dir :(NSString *)FileName :(NSString *)Text;
//Writes a list of strings or numbers to a text file. Each item is written as a single line.
- (void)WriteList:(NSString *)Dir :(NSString *)FileName :(B4IList *)List;
//Writes a Map of strings or numbers to a text file.
- (void)WriteMap:(NSString *)Dir :(NSString *)FileName :(B4IMap *)Map;
//Reads a Map written with File.WriteMap.
- (B4IMap *)ReadMap:(NSString *)Dir :(NSString *)FileName;
@end
/**
* A stream that you can read from. Use File.OpenInput to get a file input stream.
*/
//~Shortname:InputStream
//~ObjectWrapper:NSInputStream*
@interface B4IInputStream : B4IObjectWrapper
//Closes the input stream.
- (void)Close;

/**
* Reads bytes to the stream and writes them to the buffer. Returns the number of bytes read.
* Buffer - Data will be written to this buffer.
* StartOffset - The first byte will be written at this offset.
* MaxCount - Maximum number of bytes to read.
*/
- (int)ReadBytes:(B4IArray */*unsigned char,1*/)Buffer :(int)StartOffset :(int)MaxCount;

/**
* Initializes an InputStream that reads from a bytes array.
* Buffer - The bytes array.
* StartOffset - First byte will be read from this offset.
* Length - Number of bytes to expose to the stream.
*/
- (void)InitializeFromBytesArray:(B4IArray */*unsigned char,1*/)Buffer :(int)StartOffset :(int)Length;
@end
/**
* A stream that is used to write data to.
* You can open a file output stream with File.OpenOutput.
*/
//~ShortName:OutputStream
//~ObjectWrapper:NSOutputStream*
@interface B4IOutputStream:B4IObjectWrapper
/**
* Creates a memory stream. Call ToBytesArray to convert the written data to an array of bytes.
* StartSize - Currently not used.
*/
- (void)InitializeToBytesArray:(int)StartSize;
//Converts a memory stream to an array of bytes.
- (B4IArray */*unsigned char,1*/)ToBytesArray;
//Closes the output stream.
- (void)Close;

/**
* Writes the given bytes to the stream.
* Buffer - Data to write.
* StartOffset - Offset of first byte.
* Length - Number of bytes to write.
*/
- (void)WriteBytes:(B4IArray */*unsigned char,1*/)Buffer :(int)StartOffset :(int)Length;
@end
/**
* A collection that holds pairs of keys and values. The keys are unique. Fetching items is done based on the key.
* Unlike B4J / B4A Maps, B4i Map does not retain the original order of items. You can iterate over the keys or values with the Keys or Values properties.
*/
//~ShortName:Map
@interface B4IMap : NSObject<B4IDebuggable>
//~hide
@property (nonatomic)NSDictionary *dict;
//~hide
@property (nonatomic)NSMapTable *map;
//Returns the number of elements in the collection.
@property (nonatomic, readonly)int Size;
@property (nonatomic, readonly)BOOL IsInitialized;
//In some cases libraries can return read only Maps. This property will return true for such maps.
@property (nonatomic, readonly)BOOL IsReadOnly;

+ (B4IMap *)convertToMap:(NSDictionary *)dict;

//Converts a Map to NSDictionary. This can be useful for interaction with native API.
- (NSDictionary *)ToDictionary;
//Initializes the Map.
- (void)Initialize;
//Puts the given key / value in the map. If there is already an entry with the same key then the previous entry will be removed.
- (void)Put:(NSObject *)Key :(NSObject *)Value;
//Removes the pair with the given key (if such exists).
- (void)Remove:(NSObject *)Key;
//Returns the value tied to this key. Returns Null if no such key exists.
- (NSObject *)Get:(NSObject *)Key;
//Returns the value tied to this key. Returns the Default parameter if no such key exists.
- (NSObject *)GetDefault:(NSObject *)Key :(NSObject *)Default;
//Removes all items from the Map.
- (void)Clear;
//Returns true if there is an entry with the specified key.
- (BOOL)ContainsKey:(NSObject *)Key;

/**
* Can be used to iterate over the keys.
* Example:<code>
* For Each key As String In Map1.Keys
*   Log("Value = " & Map1.Get(key))
* Next</code>
*/
- (NSObject <B4IIterable> *)Keys;
//Can be used to iterate over the values.
- (NSObject <B4IIterable> *)Values;
@end


/**
* NativeObject is similar to B4A/B4J JavaObject. It allows you to call native methods and get or set fields.
* Note that only Objective C APIs can be used. C APIs cannot be called dynamically.
*/
//~ShortName:NativeObject
//~ObjectWrapper:NSObject*
//~Event:Event (Args() As Object) As Object
@interface B4INativeObject:B4IObjectWrapper
/**
* Initializes a new object and sets it to reference the given class.
*/
- (B4INativeObject *)Initialize:(NSString *)ClassName;

/**
* Runs the given method. Params can be Null if there are no parameters.
* Note that a method name is the full name with the colons.
*/
- (B4INativeObject *)RunMethod:(NSString *)MethodName :(B4IArray */*NSObject,1*/)Params;

/**
* Similar to RunMethod. Runs a method that expects a block.
*/
//~RaisesSynchronousEvents:true
- (B4INativeObject *)RunMethodWithBlocks:(NSString *)MethodName :(B4IArray */*NSObject,1*/)Params;

/**
* Gets the value of the given property or field.
*/
- (B4INativeObject *)GetField:(NSString *)Field;

/**
* Sets the value of the given property or field.
*/
- (void)SetField:(NSString *)FieldName :(NSObject *)Value;

/**
* Converts a UIColor to B4i color value.
*/
- (int)UIColorToColor:(UIColor *)UIColor;

/**
* Converts B4i color value to UIColor.
*/
- (UIColor *)ColorToUIColor:(int)Color;
//Creates a NSRange struct.
- (NSData *)MakeRange:(int)StartLocation :(int)Length;
//Creates a CGRect struct.
- (NSData *)MakeRect:(float)X :(float)Y :(float)Width :(float)Height;
//Creates a CGPoint struct.
- (NSData *)MakePoint:(float)X :(float)Y;
//Creates a CGSize struct.
- (NSData *)MakeSize:(float)Width :(float)Height;
//Converts an NSData object to an array of bytes.
- (B4IArray */*byte,1*/)NSDataToArray:(NSObject *)Data;
//Converts an array of bytes to NSData object.
- (NSObject *)ArrayToNSData:(B4IArray */*byte,1*/)Arr;
//Returns the wrapped object as a Boolean value.
- (BOOL)AsBoolean;
//Returns the wrapped object as a String value.
- (NSString *)AsString;
//Returns the wrapped object as a numeric value.
- (NSObject *)AsNumber;

/**
* Creates a block that raises the given sub.
* SubName - The event prefix. The sub signature should be: SubName_Event (Args() As Object) As Object.
* NumberOfParameters - The number of parameters passed to the block. Should be between 0 to 2.
* Delayed - Whether the event is raised immediately or it is sent to the message queue.
*/
- (id)CreateBlock:(B4I *)bi :(NSString *)SubName :(int)NumberOfParameters :(BOOL)Delayed;

@end
/**
* A timer raises the Tick event after each interval.
* The event is raised on the main thread.
*/
//~ShortName:Timer
//~Event:Tick
@interface B4ITimer:NSObject
//Gets or sets the interval, measured in milliseconds.
@property (nonatomic) long long Interval;
//Gets or sets whether the timer is enabled. New timers are not enabled.
@property (nonatomic) BOOL Enabled;

/**
* Initializes the timer and set the sub that will handle the tick event.
* The timer is disabled until the Enabled property is set to true.
* Interval - Timer interval in milliseconds.
*/
- (void)Initialize:(B4I *)BI :(NSString *)EventName :(long long)Interval;
//Tests whether the object was initialized.
- (BOOL)IsInitialized;
@end
/**
* An object that holds an image. You can use ImageView to show an image.
*/
//~ShortName:Bitmap
//~ObjectWrapper:UIImage*
@interface B4IBitmap:B4IObjectWrapper
//Returns the bitmap width.
@property (nonatomic, readonly)float Width;
//Returns the bitmap height.
@property (nonatomic, readonly)float Height;

/**
* Loads the specified image. If the image name ends with @2x (without the extension) then the image scale is considered to be 2.
* If you load an image named image1.png. And in the same folder there is also an image named image1@2x.png then on a high resolution device
* image1@2x.png will be loaded and the image scale will be set to 2.
*/
- (void)Initialize:(NSString *)Dir :(NSString *)FileName;
//Reads a bitmap from the input stream.
- (void)Initialize2:(B4IInputStream *)InputStream;

/**
* Writes the image to the output stream.
* Quality - Value between 0 (smaller size, lower quality) to 100 (larger size, higher quality).
* Format - JPEG or PNG.
*/
- (void)WriteToStream:(B4IOutputStream *)OutputStream :(int)Quality :(NSString *)Format;
@end
/**
* A view that shows a bitmap.
*/
//~ShortName:ImageView
//~ObjectWrapper:UIImageView*
@interface B4IImageViewWrapper : B4IViewWrapper
//The bitmap will be stretched to fill the view.
@property (nonatomic, readonly) UIViewContentMode MODE_FILL;
//The bitmap will be resized to fill the view. The original aspect ratio will be kept.
@property (nonatomic, readonly) UIViewContentMode MODE_FIT;
//The bitmap will not be resized.
@property (nonatomic, readonly) UIViewContentMode MODE_TOPLEFT;
//The bitmap will be centered.
@property (nonatomic, readonly) UIViewContentMode MODE_CENTER;
//Gets or sets the content mode (one of the MODE constants).
@property (nonatomic) UIViewContentMode ContentMode;
- (void)Initialize:(B4I *)bi :(NSString *)EventName;

+ (UIImage *)buildBitmap:(NSString *)imageFile :(BOOL)designer;
//Gets or sets the bitmap.
@property (nonatomic)B4IBitmap * Bitmap;
@end
/**
* MediaPlayer allows you to play audio files.
* Note that in case of an interruption (phone call for example) the playback will be paused automatically.
* You should handle the EndInterruption event and call MediaPlayer.Play to resume playback.
*/
//~ShortName:MediaPlayer
//~Event:Complete
//~Event:EndInterruption
//~ObjectWrapper:AVAudioPlayer*
@interface B4IMediaPlayer:B4IObjectWrapper
//Returns the loaded sound total duration in milliseconds;
@property (nonatomic, readonly)int Duration;
//Gets or sets the playback position (in milliseconds).
@property (nonatomic)int Position;
//Set to True to automatically restart the playback.
@property (nonatomic)BOOL Looping;
//Gets or sets the playback volume (value between 0 to 1).
@property (nonatomic)float Volume;
//Initializes the MediaPlayer and loads the specified file.
- (void)Initialize:(B4I *)bi :(NSString *)Dir :(NSString *)FileName :(NSString *)EventName;

//Starts or resumes the playback.
- (void)Play;
//Pauses the playback.
- (void)Pause;
//Stops the playback. You should initialize MediaPlayer to play another sound.
- (void)Stop;
@end
/**
* An object that represents a rectangle. Mainly used with Canvas.
*/
//~ShortName:Rect
@interface B4IRect : NSObject
@property (nonatomic) float Left;
@property (nonatomic) float Top;
@property (nonatomic) float Right;
@property (nonatomic) float Bottom;
//Returns the horizontal center.
@property (nonatomic, readonly) float CenterX;
//Returns the vertical center.
@property (nonatomic, readonly) float CenterY;
//Initializes a new Rect and sets its dimensions.
- (void)Initialize:(float)Left :(float)Top :(float)Right :(float)Bottom;

- (float)Width;

- (float)Height;

//~Hide
- (CGRect)ToCGRect;

- (BOOL)IsInitialized;
@end
/**
* Path is used together with Canvas to allow the drawing to be clipped to a polygon.
*/
//~Shortname:Path
//~ObjectWrapper:UIBezierPath*
@interface B4IPathWrapper:B4IObjectWrapper
//Initializes the Path and sets the initial position.
- (void)Initialize:(float)x :(float)y;


/**
* Initializes a path based on the given rectangle.
* CornerRadius - Corners radius for rounded rectangles.
*/
- (void)InitializeRect:(B4IRect *)Rect1 :(float)CornerRadius;
//Adds a line from the current point to the specified point.
- (B4IPathWrapper *)LineTo:(float)x :(float)y;
@end
/**
* PDFDocument allows you to read existing PDF files and draw them with Canvas.DrawPDF.
*/
//~Shortname:PDFDocument
@interface B4IPDFDocument : NSObject
@property (nonatomic, readonly)int NumberOfPages;
@property (nonatomic, readonly) BOOL Locked;

- (void)Unlock:(NSString *)Password;

//~hide
- (CGPDFPageRef)GetPage:(int)i;

/**
* Loads the given PDF document.
*/
- (void)Initialize:(NSString *)Dir :(NSString *)FileName;

/**
* Releases resources related to the PDF document.
*/
- (void)Release;
@end
/**
* Canvas is used for drawing over other views.
* The drawings will only be updated after a call to Canvas.Refresh. Note that you should call Canvas.Release when it is no longer used.
* If the hosting is resized then the canvas should be released and initialized again.
*/
//~Shortname:Canvas
@interface B4ICanvas : NSObject
//Gets the attached view.
@property (nonatomic, readonly)B4IViewWrapper *View;
//Returns the canvas drawing rectangle;
@property (nonatomic, readonly) B4IRect *TargetRect;
/**
* Initializes the canvas with the view that it will draw on.
*/
- (void)Initialize:(B4IViewWrapper *)View;

/**
* Initializes a canvas that will create a PDF document. The default size of PDF documents is 612 x 792.
* Dir / FileName - PDF file to create.
* Width - Document width.
* Height Document height;
*/
- (void)InitializePDF:(NSString *)Dir :(NSString *)FileName :(float)Width :(float)Height;

/**
* Moves the canvas to the next page. Should only be used when the canvas was initialized with InitializePDF.
*/
- (void)NextPDFPage;

/**
* Draws the specified bitmap in the DestRect rectangle.
*/
- (void)DrawBitmap:(B4IBitmap *)Bitmap :(B4IRect *)DestRect;

/**
* Draws a PDF page in the DestRect rectangle.
*Document - PDF Document.
*PageNumber - The page to draw. Note that the first page number is 1.
*DestRect - Destination rectangle.
*/
- (void)DrawPDF:(B4IPDFDocument *)Document :(int)PageNumber :(B4IRect *)DestRect;

/**
* Similar to DrawBitmap. Draws a rotated bitmap.
*/
- (void)DrawBitmapRotated:(B4IBitmap *)Bitmap :(B4IRect *)DestRect :(float)Degrees;

/**
* Tiles the given bitmap in the DestRect rectangle. Note that the bitmap will be drawn upside down.
*/
- (void)TileBitmap:(B4IBitmap *)Bitmap :(B4IRect *)DestRect;

/**
* Draws the given view in the DestRect rectangle.
*/
- (void)DrawView:(UIView *)View :(B4IRect *)DestRect;

/**
* Fills the entire canvas with the given color. Note that you can use ClipPath to clip the drawings to a specific region.
*/
- (void)DrawColor:(int)Color;

/**
* Draws a rectangle.
* Rect1 - Rectangle coordinates.
* Color - Drawing color.
* Filled - Whether to fill the rectangle interior.
* StrokeWidth - The rectangle border width.
*/
- (void)DrawRect:(B4IRect *)Rect1 :(int)Color :(BOOL)Filled :(float)StrokeWidth;
//Similar to DrawRectRounded. Rotates the rectangle before it is drawn.
- (void)DrawRectRotated:(B4IRect *)Rect1 :(int)Color :(BOOL)Filled :(float)StrokeWidth :(float)CornersRadius :(float)Degrees;

//Similar to DrawRect. Allows you to draw a rectangle with rounded corners.
- (void)DrawRectRounded:(B4IRect *)Rect1 :(int)Color :(BOOL)Filled :(float)StrokeWidth :(float)CornersRadius;

/**
* Draws a circle.
* x / y - Circle center.
* Radius - Circle radius.
* Color - Drawing color.
* Filled - Whether to fill the circle interior.
* StrokeWidth - The circle border width.
*/
- (void)DrawCircle:(float)x :(float)y :(float)Radius :(int)Color :(BOOL)Filled :(float)StrokeWidth;

/**
* Paints a gradient fill along the two points.
* x1, y1 - Starting point.
* x2, y2 - End point.
* Colors - A list (or array) with the gradient colors.
*/
- (void)FillGradient:(float)x1 :(float)y1 :(float)x2 :(float)y2 :(B4IList *)Colors;

/**
* Clips the drawing to the specified path. Call RemoveClip to remove the clip.
*/
- (void)ClipPath:(B4IPathWrapper *)Path;

//Removes the last clipping set with ClipPath.
- (void)RemoveClip;

/**
* Draws or fills the given path.
* Path - The Path that will be filled or drawn.
* Colors - Drawing color.
* Filled - Whether to fill the path.
* StrokeWidth - The border drawing width.
*/
- (void)DrawPath:(UIBezierPath *)Path :(int)Color :(BOOL)Filled :(float)StrokeWidth;

/**
* Draws a line between two points.
* x1, y1 - Starting point.
* x2, y2 - End point.
* Color - Drawing color.
* StrokeWidth - Line width.
*/
- (void)DrawLine:(float)x1 :(float)y1 :(float)x2 :(float)y2 :(int)Color :(float)StrokeWidth;

/**
* Similar to DrawText. Draws rotated text.
*/
- (void)DrawTextRotated:(NSString *)Text :(float)x :(float)y :(B4IFontWrapper *)Font :(int)Color :(NSString *)Align :(float)Degrees;

/**
* Draws the given text.
* Text - Text to draw.
* x, y - Origin point.
* Font - Font to use for drawing.
* Color - Drawing color.
* Align - Text alignment related to the origin point. One of the following values: LEFT, CENTER or RIGHT.
*/
- (void)DrawText:(NSString *)Text :(float)x :(float)y :(B4IFontWrapper *)Font :(int)Color :(NSString *)Align;

/**
* Applies the changes done. You must call Refresh for the drawings to be applied.
*/
- (void)Refresh;

/**
* Creates a new Bitmap from the canvas layer.
*/
- (B4IBitmap *)CreateBitmap;

/**
* Releases the canvas resources. You can safely call this method multiple times or before the canvas was initialized.
*/
- (void)Release;
@end
/**
* Panel is a view that holds other views.
*/
//~Shortname:Panel
//~ObjectWrapper:B4IPanelView*
//~Event:Touch(Action As Int, X As Float, Y As Float)
//~Event:Resize (Width As Float, Height As Float)
@interface B4IPanelWrapper:B4IViewWrapper<B4IIterable>
@property (nonatomic, readonly)int ACTION_DOWN;
@property (nonatomic, readonly)int ACTION_UP;
@property (nonatomic, readonly)int ACTION_MOVE;
@property (nonatomic, readonly)int NumberOfViews;
- (void)Initialize:(B4I *)bi :(NSString *)EventName;

/**
* Adds a view to the Panel.
*/
- (void)AddView:(UIView *)View :(float)Left :(float)Top :(float)Width :(float)Height;
/**
* Loads a layout file to the panel.
*/
//~RaisesSynchronousEvents:true
- (B4ILayoutValues *)LoadLayout:(NSString *)LayoutFile :(B4I *)bi;

/**
* Removes all views from the panel.
*/
- (void)RemoveAllViews;

/**
* Removes the view at the specified index.
*/
- (void)RemoveViewAt:(int)Index;
//Gets the view at the specified index.
- (B4IViewWrapper *)GetView:(int)Index;
//Used with a For Each block to iterate over all views recursively.
- (NSObject <B4IIterable> *)GetAllViewsRecursive;
@end
//~hide
@interface B4ILayoutBuilder:NSObject

+ (UIView *)dynamicBuild:(UIView *)prev :(NSMutableDictionary *)props :(BOOL)designer :(NSObject *)tag;

+ (void)setScaleRate:(float)rate;

+ (void)scaleAll:(B4ILayoutData *)layoutData :(int)pw :(int)ph;

+ (double)getPageSize;

+ (BOOL)isPortrait;

- (B4ILayoutValues *)loadLayout:(NSString *)file :(B4I *)bi :(B4IPanelView *)parent;

- (B4ILayoutValues *)resizeLayout:(B4I *)bi :(B4IPanelView *)parent;

@end
//~hide
@interface B4IDataInputStream : NSObject
- (instancetype)init:(NSInputStream *)socket;

- (int32_t)readInt;

- (char)readByte;

- (unsigned char)readUnsignedByte;

- (int16_t)readShort;

- (float)readFloat;

- (double)readDouble;

- (long long)readLong;

- (BOOL)readFully:(void *)buf length:(int)len;

- (void)readAndDiscard:(int)len;

- (int)readNotFull:(void *)buf limit:(int)len;

- (NSString *)readString;

- (NSMutableDictionary *)readMap:(NSArray *)cache;
@end

//~shortname:LayoutValues
@interface B4ILayoutValues : NSObject
//Returns 1 as this is the scale is normalized automatically by the OS.
@property (nonatomic, readonly) float Scale;
//Returns the (normalized) width.
@property (nonatomic, readonly) int Width;
//Returns the (normalized) height.
@property (nonatomic, readonly) int Height;
//Returns the device approximate screen size measured in inches.
@property (nonatomic, readonly) double DeviceApproximateScreenSize;
//Returns the non-normalized scale.
@property (nonatomic, readonly) float NonnormalizedScale;
//~hide
- (instancetype)init:(int)width :(int)height;
//~hide
- (float)calcDistance:(B4ILayoutValues *)device;

+ (B4ILayoutValues *)readFromStream:(B4IDataInputStream *)din;
@end
/**
* Notification object allows you to schedule local notifications.
* You need to call App.RegisterUserNotifications before you create a local notification.
*/
//~shortname:Notification
//~ObjectWrapper:UILocalNotification*
@interface B4INotificationWrapper : B4IObjectWrapper
//Gets or sets the notification message.
@property (nonatomic)NSString *AlertBody;
//Gets or sets the app icon badge number.
@property (nonatomic)int IconBadgeNumber;
//Gets or sets whether the notification will play a sound.
@property (nonatomic)BOOL PlaySound;
/**
 * Gets or sets the tag string that will be tied to this notification.
 *This value will be available when the user clicks on the notification.
 */
@property (nonatomic)NSString *NotificationTag;
//Initializes the notification and sets the fire date.
- (void)Initialize:(long long)FireDate;
//Schedules the notification.
- (void)Register;
//Cancel a scheduled notification.
- (void)Cancel;
@end
//~hide
@interface B4ILayoutData : NSObject
@property (nonatomic) NSArray *variants;
@property (nonatomic) NSMutableDictionary *props;
@property (nonatomic) NSMutableDictionary *viewsMap;
@property (nonatomic) NSString *designerScriptName;

- (B4IViewWrapper *)get:(NSString *)name;

- (void)setText:(NSString *)name :(NSString *)text;

- (void)setTextSize:(NSString *)name :(float)size;

- (float)getTextSize:(NSString *)name;
@end
//~Shortname: CompletionHandler
@interface B4ICompletionHandler : NSObject
//~hide
- (instancetype)init:(void (^)(UIBackgroundFetchResult))complete1;
//Tells the OS that your app has completed handling the push notification.
- (void)Complete;
@end

