package com.sxwnljava;

import com.sxwnljava.LunarConstant.Common;

public class JulianDate {

	/** 所在公历年 */
	private int year = 2000;
	/** 所在公历月 */
	private int month = 1;
	/** 所在公历日 */
	private int day = 1;
	/** 所在公历小时 */
	private int hour = 12;
	/** 所在公历分钟 */
	private int minute = 0;
	/** 所在公历秒钟 */
	private double second = 0;

	//	private final String[] weeks = { "日", "一", "二", "三", "四", "五", "六", "七" };

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public double getSecond() {
		return second;
	}

	public void setSecond(double second) {
		this.second = second;
	}

	// 公历转儒略日
	private double JD(int year, int month, double day) {
		int n = 0, G = 0;
		if (year * 372 + month * 31 + Math.floor(day) >= 588829)
			G = 1; // 判断是否为格里高利历日1582*372+10*31+15
		if (month <= 2) {
			month += 12;
			year--;
		}
		if (G != 0) {
			n = (int) Math.floor(year / 100);
			n = 2 - n + (int) Math.floor(n / 4); // 加百年闰
		}
		return Math.floor(365.25 * (year + 4716)) + Math.floor(30.6001 * (month + 1)) + day + n - 1524.5;
	}

	// 儒略日数转公历
	private JulianDate DD(double jd) {
		JulianDate julianDate = new JulianDate();
		int year, month, day, hour, minute;
		double second;
		int D = (int) Math.floor(jd + 0.5), c;
		double F = jd + 0.5 - D; // 取得日数的整数部份A及小数部分F

		if (D >= 2299161) {
			c = (int) Math.floor((D - 1867216.25) / 36524.25);
			D += 1 + c - Math.floor(c / 4);
		}
		D += 1524;
		year = (int) Math.floor((D - 122.1) / 365.25);// 年数
		D -= Math.floor(365.25 * year);
		month = (int) Math.floor(D / 30.601); // 月数
		D -= Math.floor(30.601 * month);
		day = D; // 日数
		if (month > 13) {
			month -= 13;
			year -= 4715;
		} else {
			month -= 1;
			year -= 4716;
		}
		// 日的小数转为时分秒
		F *= 24;
		hour = (int) Math.floor(F);
		F -= hour;
		F *= 60;
		minute = (int) Math.floor(F);
		F -= minute;
		F *= 60;
		second = F;

		julianDate.setYear(year);
		julianDate.setMonth(month);
		julianDate.setDay(day);
		julianDate.setHour(hour);
		julianDate.setMinute(minute);
		julianDate.setSecond(second);
		return julianDate;
	}

	//日期转为串
	private String DD2str(JulianDate julianDate) {
		String Y = "     " + julianDate.getYear(), M = "0" + julianDate.getMonth(), D = "0" + julianDate.getDay();
		int h = julianDate.getHour(), m = julianDate.getMinute(), s = (int) Math.floor(julianDate.getSecond() + .5);
		if (s >= 60) {
			s -= 60;
			m++;
		}
		if (m >= 60) {
			m -= 60;
			h++;
		}
		String hStr, mStr, sStr;
		hStr = "0" + h;
		mStr = "0" + m;
		sStr = "0" + s;
		Y = Common.subString(Y, Y.length() - 5);
		M = Common.subString(M, M.length() - 2);
		D = Common.subString(D, D.length() - 2);
		hStr = Common.subString(hStr, hStr.length() - 2);
		mStr = Common.subString(mStr, mStr.length() - 2);
		sStr = Common.subString(sStr, sStr.length() - 2);
		return Y + "-" + M + "-" + D + " " + hStr + ":" + mStr + ":" + sStr;
	}

	//JD转为串
	protected String JD2str(double jd) {
		JulianDate julianDate = this.DD(jd);
		return this.DD2str(julianDate);
	}

	// 公历转儒略日
	protected double toJD() {
		return this.JD(this.year, this.month, this.day + ((this.second / 60 + this.minute) / 60 + this.hour) / 24);
	}

	// 儒略日数转公历
	protected void setFromJD(double jd) {
		JulianDate julianDate = this.DD(jd);
		this.year = julianDate.getYear();
		this.month = julianDate.getMonth();
		this.day = julianDate.getDay();
		this.minute = julianDate.getMinute();
		this.hour = julianDate.getHour();
		this.second = julianDate.getSecond();
	}

	protected String timeStr(double jd) {
		// 提取jd中的时间(去除日期)
		int h, m, s;
		jd += 0.5;
		jd = (jd - Math.floor(jd));
		s = (int) Math.floor(jd * 86400 + 0.5);
		h = (int) Math.floor(s / 3600);
		s -= h * 3600;
		m = (int) Math.floor(s / 60);
		s -= m * 60;
		String hStr, mStr, sStr;
		hStr = "0" + h;
		mStr = "0" + m;
		sStr = "0" + s;
		return Common.subString(hStr, hStr.length() - 2, hStr.length()) + ":" + Common.subString(mStr, mStr.length() - 2, mStr.length())
				+ ":" + Common.subString(sStr, sStr.length() - 2, sStr.length());
	}

	protected int getWeek(double jd) {
		//星期计算
		return (int) Math.floor(jd + 1.5 + 7000000) % 7;
	}

	protected int nnweek(int year, int month, int n, int week) {
		//=================可能有错

		//求y年m月的第n个星期w的儒略日数
		double jd = this.JD(year, month, 1.5); //月首儒略日
		double w0 = (jd + 1 + 7000000) % 7; //月首的星期
		int r = (int) (jd - w0 + 7 * n + week);
		//jd-w0+7*n是和n个星期0,起算下本月第一行的星期日(可能落在上一月)。加w后为第n个星期w
		if (week >= w0)
			r -= 7; //第1个星期w可能落在上个月,造成多算1周,所以考虑减1周
		if (n == 5) {
			month++;
			if (month > 12) {
				month = 1;
				year++;
			} //下个月
			if (r >= this.JD(year, month, 1.5))
				r -= 7; //r跑到下个月则减1周
		}
		return r;
	}
}
