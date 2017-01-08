package com.sxwnljava;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;


@ShortName("sxwnl")
@Version(1.30f)
@Author("Icefairy333")
public class sxwnl {
//	private LunarCalendar c;
	/**
	 * Convert AD to Lunar
	 */
	public String ad2lunar(long dt){
		LunarCalendar c;
		c=new LunarCalendar();
		c.SetDateTimeLong(dt);
		return c.getDateString();
	}
	/**
	 * Convert AD to Ganzhi
	 * @param dt
	 * @param full include complete ganzhi
	 */
	public String ad2ganzhi(long dt,boolean full) {
		LunarCalendar c;
		c=new LunarCalendar();
		c.SetDateTimeLong(dt);
		return c.getGanZhiDateString(full);
	}
	public String getKongwang(String str) {
		LunarCalendar c;
		c=new LunarCalendar();
		c.SetDateTimeLong(new Date().getTime());
		return c.getkongwang(str);
	}
	@Hide
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c=Calendar.getInstance();
		sxwnl tSxwnl;
//		c.add(Calendar.DAY_OF_MONTH, -1);
//		c.set(Calendar.YEAR, 2015);
//		c.set(Calendar.MONTH, 9);
		c.set(Calendar.DAY_OF_MONTH, 24);
//		c.set(Calendar.HOUR_OF_DAY,1);
//		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.MINUTE, getrndminutes());
//		c.set(Calendar.SECOND,59);
		tSxwnl=new sxwnl();
		DateFormat dfDateFormat=DateFormat.getDateTimeInstance();
		System.out.println("x_"+dfDateFormat.format(c.getTime()));
		Long a;
		a=System.currentTimeMillis();
		Log("农历："+tSxwnl.ad2lunar(c.getTimeInMillis()));
		String gz=tSxwnl.ad2ganzhi(c.getTimeInMillis(), true);
		Log("干支："+gz);
		Log("空亡："+tSxwnl.getKongwang(gz));
		Log("耗时："+(System.currentTimeMillis()-a)+"ms");
		a=System.currentTimeMillis();
		c.set(Calendar.DAY_OF_MONTH, 10);
//		c.set(Calendar.HOUR_OF_DAY,1);
		c.set(Calendar.MINUTE, getrndminutes());
//		c.set(Calendar.SECOND,59);
		System.out.println("x_"+dfDateFormat.format(c.getTime()));
		Log("农历："+tSxwnl.ad2lunar(c.getTimeInMillis()));
		gz=tSxwnl.ad2ganzhi(c.getTimeInMillis(), true);
		Log("干支："+gz);
		Log("空亡："+tSxwnl.getKongwang(gz));
		Log("耗时："+(System.currentTimeMillis()-a)+"ms");
//		calendar.SetDateTimeLong(c.getTimeInMillis());
//		
//		
//        System.out.println(calendar.getDateString());  
//        System.out.println(calendar.getGanZhiDateString(false));
//        System.out.println( calendar.getGanZhiDateString(true));
//        for (int i = 0; i < 60; i++) {
//			System.out.print(calendar.getGZbyIdx(i)+" ");
//		}
	}
	private static int getrndminutes() {
		Random rnd=new Random();
		return rnd.nextInt(59);
	}
	@Hide
	public static void Log(String msg) {
		System.out.println(msg);
	}
//	说明：
//	1. LunarCalendar对象是以月历为基准的，例如：2014年8月的月历数据。
//	2. LunarCalendar的所有方法都是针对于农历而言，例如getMonth方法，代表获取的是农历月的数据，而不是公历。
//	3. LunarCalendar实例化，默认为今天，可以指定为某天，大多数方法都是依据实例化时指定的天而返回数据的。
//	4. LunarDate类，是某一天的农历数据对象，并且已经拆分，而不是以前那样都混杂在一块。
//	5. JulianDate类，是公历数据对象。
//	6. LunarConstant类，是基本常量的数据对象，里面含有大量基本数据。
//	由于代码很多，所以我以文件的形式上传到了CSDN资源库里，博文里就不贴了。
//	Java源码下载地址：
//	http://download.csdn.net/detail/wangpeng047/7755661
	//OutPut
//	getAnimalString=羊
//			getDateString=乙未年 九月大 十二日
//			getDay=12
//			getDayString=十二
//			getGanZhiDateString=乙未 丙戌 癸酉 
//			getMaxDayInMonth=30
//			getMonth=9
//			getMonthString=九
//			getYear=4713
//			getYearString=乙未
//			2015-02-04 11:58:27立春
//			2015-02-19 07:49:47雨水
//			2015-03-06 05:55:39惊蛰
//			2015-03-21 06:45:07春分
//			2015-04-05 10:39:07清明
//			2015-04-20 17:41:50谷雨
//			2015-05-06 03:52:35立夏
//			2015-05-21 16:44:45小满
//			2015-06-06 07:58:09芒种
//			2015-06-22 00:37:53夏至
//			2015-07-07 18:12:14小暑
//			2015-07-23 11:30:25大暑
//			2015-08-08 04:01:23立秋
//			2015-08-23 18:37:15处暑
//			2015-09-08 06:59:33白露
//			2015-09-23 16:20:31秋分
//			2015-10-08 22:42:47寒露
//			2015-10-24 01:46:41霜降
//			2015-11-08 01:58:36立冬
//			2015-11-22 23:25:15小雪
//			2015-12-07 18:53:19大雪
//			2015-12-22 12:47:55冬至
//			2016-01-06 06:08:21小寒
//			2016-01-20 23:27:04大寒

}
