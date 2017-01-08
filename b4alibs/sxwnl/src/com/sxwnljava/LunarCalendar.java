package com.sxwnljava;

import java.util.ArrayList;
import java.util.Calendar;

import com.sxwnljava.LunarConstant.Common;
import com.sxwnljava.LunarConstant.Oba;
import com.sxwnljava.LunarConstant.Obb;
import com.sxwnljava.LunarConstant.SSQ;
import com.sxwnljava.LunarConstant.XL;



public class LunarCalendar {

	/** 月历. 某月全部的日历数据 */
	private static LunarDate[] lunarDates;
	/** 日历 */
	private static LunarDate lunarDate;

	/** 某年气朔的数据信息 */
	private static SSQ ssq;

	/** lun.y 公历年份 */
	private int year;
	/** lun.m 公历月分 */
	@SuppressWarnings("unused")
	private int month;
	/** lun.d0 月首儒略日数 */
	@SuppressWarnings("unused")
	private int dayRL;
	/** lun.dn 月天数 */
	@SuppressWarnings("unused")
	private int daysOfMonth;
	/** lun.w0 本月第一天的星期 */
	private int weekFirst;
	/** lun.Ly 干支纪年 */
	@SuppressWarnings("unused")
	private String cnEraYear;
	/** lun.ShX 该年对应的生肖 */
	private String animalYear;
	/** lun.nianhao 年号纪年 */
	@SuppressWarnings("unused")
	private String nianHao;
	private static Calendar mCalendar=null;
	public LunarCalendar() {
		
	}

	public void SetDateTimeLong(long TimeInMillis) {
		//初次使用计算一次
		mCalendar = Calendar.getInstance();
		mCalendar.setTimeInMillis(TimeInMillis);
		if (mCalendar.get(Calendar.HOUR_OF_DAY)==23) {
			mCalendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		docalc();
	}
	private void docalc() {
		yueLiCalc(mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH) + 1);
		lunarDate = lunarDates[mCalendar.get(Calendar.DATE) - 1];
	}
	//只对单个进行赋值不用重新计算月历
	private void docalc2() {
		lunarDate = lunarDates[mCalendar.get(Calendar.DATE) - 1];
		sxwnl.Log("日干支:"+lunarDate.getCnEraDay());
		
	}
	// 农历生肖
	public String getAnimalString() {
		return animalYear;
	}

	// 获取农历日期字符串
	public String getDateString() {
		//return lunarDate.getKingYear() + "年" + lunarDate.getLunarMonthName() + "月" + (isBigMonth() ? "大" : "小")
			//	+ lunarDate.getLunarDayName() + "日";
		return lunarDate.getCnEraYear() + "年 " + lunarDate.getLunarMonthName() + "月" + (isBigMonth() ? "大 " : "小 ")
				+ lunarDate.getLunarDayName() + "日";
	}

	// 获取干支农历日期字符串
	public String getGanZhiDateString(Boolean Full) {
		
		if (Full) {
			
			return lunarDate.getCnEraYear() + " " + lunarDate.getCnEraMonth() + " " + lunarDate.getCnEraDay() + " "+lunarDate.getCnEraTime()+" "+lunarDate.getCnEraKe()+" "+lunarDate.getCnEraFen()+" "+lunarDate.getCnEraMiao();
		}else{
			return lunarDate.getCnEraYear() + " " + lunarDate.getCnEraMonth() + " " + lunarDate.getCnEraDay() + " "+lunarDate.getCnEraTime();
		}
		
	}
	private LunarDate genGztime(LunarDate lunarDate2, int rg) {
		// 时辰
		//System.out.println(mCalendar.get(Calendar.HOUR_OF_DAY));
		int sc=(mCalendar.get(Calendar.HOUR_OF_DAY)+1)/2;
		sc=sc % 12;
		int nGsc=getGan(rg,sc);
		//BA.Log("riGan:"+nRigan);
		lunarDate2.setCnEraTime(Obb.Gan[nGsc]+Obb.Zhi[sc]);
		//刻
		int nFen=mCalendar.get(Calendar.MINUTE);
		int nKe=(int)Math.floor(nFen/10);
		if (mCalendar.get(Calendar.HOUR_OF_DAY) % 2==0) {
			//偶数小时
			nKe=nKe+6;
		}
		int nGke=getGan(nGsc, nKe);
		lunarDate2.setCnEraKe(Obb.Gan[nGke]+Obb.Zhi[nKe]);
		//分
		nFen=mCalendar.get(Calendar.MINUTE);
		if (mCalendar.get(Calendar.HOUR_OF_DAY) % 2==0) {
			//偶数小时
			nFen=nFen+60;
		}
		nFen=nFen/2;
		//int nGfen=getGan(nGke, nFen);
		lunarDate2.setCnEraFen(getGZbyIdx(nFen));
		//秒
		int nMiao=mCalendar.get(Calendar.SECOND);
		if (mCalendar.get(Calendar.MINUTE) % 2!=0) {
			//偶数分
			nMiao=nMiao+60;
		}
		nMiao=nMiao/10;
		int nGmiao=getGan(nFen % 10, nMiao);
		lunarDate2.setCnEraMiao(Obb.Gan[nGmiao]+Obb.Zhi[nMiao % 12]);
		return lunarDate2;
	}

	// 农历日
	public int getDay() {
		return lunarDate.getLunarMonthOffset() + 1;
	}

	// 农历日字符串
	public String getDayString() {
		return lunarDate.getLunarDayName();
	}

	// 某农历月有多少天
	public int getMaxDayInMonth() {
		return lunarDate.getDaysofLunarMonth();
	}

	// 农历月
	public int getMonth() {
		int month = 0;
		String monthName = lunarDate.getLunarMonthName();
		if ("正".equals(monthName)) {
			month = 1;
		} else if ("二".equals(monthName)) {
			month = 2;
		} else if ("三".equals(monthName)) {
			month = 3;
		} else if ("四".equals(monthName)) {
			month = 4;
		} else if ("五".equals(monthName)) {
			month = 5;
		} else if ("六".equals(monthName)) {
			month = 6;
		} else if ("七".equals(monthName)) {
			month = 7;
		} else if ("八".equals(monthName)) {
			month = 8;
		} else if ("九".equals(monthName)) {
			month = 9;
		} else if ("十".equals(monthName)) {
			month = 10;
		} else if ("十一".equals(monthName)) {
			month = 11;
		} else if ("十二".equals(monthName)) {
			month = 12;
		}
		return month;
	}

	// 农历月字符串
	public String getMonthString() {
		return lunarDate.getLunarMonthName();
	}

	// 农历年
	public int getYear() {
		return lunarDate.getKingYear();
	}

	// 农历年字符串
	public String getYearString() {
		return lunarDate.getCnEraYear();
	}

	// 是否是大月
	public boolean isBigMonth() {
		return lunarDate.getDaysofLunarMonth() > 29;
	}

	// 是否是闰月
	public boolean isLeap() {
		return "闰".equals(lunarDate.getLunarLunarLeap());
	}

	// 是否是闰年
	public boolean isLeapYear() {
		return ssq.leap > 0;
	}

	// 获取某年的二十四节气信息
	public String[] getAllSolarTerm() {
		return qiCalc(year);
	}

	// 获取某月的农历对象
	public LunarDate[] getMonthLunarDates() {
		return lunarDates;
	}

	// 获取某一天的农历对象
	public LunarDate getDayLunarDate() {
		return lunarDate;
	}
	
	private void yueLiCalc(int year, int month) {
		int c, Bd0, Bdn;
		// 日历物件初始化
		ssq = new SSQ();
		JulianDate julianDate = new JulianDate();
		julianDate.setHour(12);
		julianDate.setMinute(0);
		julianDate.setSecond(0.1);
		julianDate.setYear(year);
		julianDate.setMonth(month);
		julianDate.setDay(1);
		Bd0 = (int) (Math.floor(julianDate.toJD()) - Common.J2000); // 公历月首,中午
		julianDate.setMonth(julianDate.getMonth() + 1);
		if (julianDate.getMonth() > 12) {
			julianDate.setYear(julianDate.getYear() + 1);
			julianDate.setMonth(1);
		}
		Bdn = (int) (Math.floor(julianDate.toJD()) - Common.J2000 - Bd0); // 本月天数(公历)

		this.weekFirst = (Bd0 + Common.J2000 + 1 + 7000000) % 7; // 本月第一天的星期
		this.year = year; // 公历年份
		this.month = month; // 公历月分
		this.dayRL = Bd0;
		this.daysOfMonth = Bdn;

		// 所属公历年对应的农历干支纪年
		c = year - 1984 + 12000;
		this.cnEraYear = Obb.Gan[c % 10] + Obb.Zhi[c % 12]; // 干支纪年
		this.animalYear = Obb.ShX[c % 12]; // 该年对应的生肖
		this.nianHao = Obb.getNH(year);

		int D;
		double w;

		// 提取各日信息
		LunarDate[] lunarDates = new LunarDate[Bdn];
		for (int i = 0, j = 0; i < Bdn; i++) {
			LunarDate lunarDate = new LunarDate();
			lunarDate.setDayRL(Bd0 + i); // 儒略日,北京时12:00
			lunarDate.setDayIndex(i); // 公历月内日序数
			lunarDate.setYear(year); // 公历年
			lunarDate.setMonth(month); // 公历月
			lunarDate.setDaysOfMonth(Bdn); // 公历月天数
			lunarDate.setWeekFirst(this.weekFirst); // 月首的星期
			lunarDate.setWeek((this.weekFirst + i) % 7); // 当前日的星期
			lunarDate.setWeekIndex((int) Math.floor((this.weekFirst + i) / 7)); // 本日所在的周序号
			lunarDate.setWeeksOfMonth((int) Math.floor((this.weekFirst + Bdn - 1) / 7) + 1); // 本月的总周数
			julianDate.setFromJD(lunarDate.getDayRL() + Common.J2000);
			lunarDate.setDay(julianDate.getDay()); // 公历日名称

			// 农历月历
			// =======================
			// 此处有线程安全问题, 暂时直接实例化，ssq.calcY是为减少计算次数而做的判断。（同一年数据一样）
			if (lunarDate.getDayRL() < ssq.ZQ[0] || lunarDate.getDayRL() >= ssq.ZQ[24]) // 如果d0已在计算农历范围内则不再计算
				ssq.calcY(lunarDate.getDayRL());
			// =======================
			int mk = (int) Math.floor((lunarDate.getDayRL() - ssq.HS[0]) / 30);
			if (mk < 13 && ssq.HS[mk + 1] <= lunarDate.getDayRL())
				mk++; // 农历所在月的序数

			lunarDate.setLunarMonthOffset(lunarDate.getDayRL() - ssq.HS[mk]); // 距农历月首的编移量,0对应初一
			lunarDate.setLunarDayName(Obb.rmc[lunarDate.getLunarMonthOffset()]); // 农历日名称
			lunarDate.setDaysToDZ(lunarDate.getDayRL() - ssq.ZQ[0]); // 距冬至的天数
			lunarDate.setDaysToXZ(lunarDate.getDayRL() - ssq.ZQ[12]); // 距夏至的天数
			lunarDate.setDaysToLQ(lunarDate.getDayRL() - ssq.ZQ[15]); // 距立秋的天数
			lunarDate.setDaysToMZ(lunarDate.getDayRL() - ssq.ZQ[11]); // 距芒种的天数
			lunarDate.setDaysToXS(lunarDate.getDayRL() - ssq.ZQ[13]); // 距小暑的天数
			if (lunarDate.getDayRL() == ssq.HS[mk] || lunarDate.getDayRL() == Bd0) { // 月的信息
				lunarDate.setLunarMonthName(ssq.ym[mk]); // 月名称
				lunarDate.setDaysofLunarMonth(ssq.dx[mk]); // 月大小
				lunarDate.setLunarLunarLeap((ssq.leap != 0 && ssq.leap == mk) ? "闰" : ""); // 闰状况
				lunarDate.setNextLunarMonthName(mk < 13 ? ssq.ym[mk + 1] : "未知"); // 下个月名称,判断除夕时要用到
			} else {
				LunarDate lunarDate2 = lunarDates[i - 1];
				lunarDate.setLunarMonthName(lunarDate2.getLunarMonthName());
				lunarDate.setDaysofLunarMonth(lunarDate2.getDaysofLunarMonth());
				lunarDate.setLunarLunarLeap(lunarDate2.getLunarLunarLeap());
				lunarDate.setNextLunarMonthName(lunarDate2.getNextLunarMonthName());
			}
			int qk = (int) Math.floor((lunarDate.getDayRL() - ssq.ZQ[0] - 7) / 15.2184);
			if (qk < 23 && lunarDate.getDayRL() >= ssq.ZQ[qk + 1])
				qk++; // 节气的取值范围是0-23
			if (lunarDate.getDayRL() == ssq.ZQ[qk])
				lunarDate.setLunarSolarTerm(Obb.jqmc[qk]);
			else
				lunarDate.setLunarSolarTerm("");

			// ob.yxmc = ob.yxjd = ob.yxsj ="";//月相名称,月相时刻(儒略日),月相时间串
			// ob.jqmc = ob.jqjd = ob.jqsj ="";//定气名称,节气时刻(儒略日),节气时间串

			// 干支纪年处理
			// 以立春为界定年首
			D = (int) (ssq.ZQ[3] + (lunarDate.getDayRL() < ssq.ZQ[3] ? -365 : 0) + 365.25 * 16 - 35); // 以立春为界定纪年
			lunarDate.setLunarYear((int) Math.floor(D / 365.2422 + 0.5)); // 农历纪年(10进制,1984年起算)
			// 以下几行以正月初一定年首
			D = ssq.HS[2]; // 一般第3个月为春节
			for (j = 0; j < 14; j++) { // 找春节
				if (!ssq.ym[j].equals("正") || ssq.leap == j && j != 0)
					continue;
				D = ssq.HS[j];
				if (lunarDate.getDayRL() < D) {
					D -= 365;
					break;
				} // 无需再找下一个正月
			}
			D = D + 5810; // 计算该年春节与1984年平均春节(立春附近)相差天数估计
			int Lyear0 = (int) Math.floor(D / 365.2422 + 0.5); // 农历纪年(10进制,1984年起算)

			D = lunarDate.getLunarYear() + 12000;
			lunarDate.setCnEraYear(Obb.Gan[D % 10] + Obb.Zhi[D % 12]); // 干支纪年(立春)
			D = Lyear0 + 12000;
			// String Lyear3 = this.Gan[D % 10] + this.Zhi[D % 12]; // 干支纪年(正月) , 与Lyear2区别在于春节才视为新年
			lunarDate.setKingYear(Lyear0 + 1984 + 2698); // 黄帝纪年

			// 纪月处理,1998年12月7(大雪)开始连续进行节气计数,0为甲子
			mk = (int) Math.floor((lunarDate.getDayRL() - ssq.ZQ[0]) / 30.43685);
			if (mk < 12 && lunarDate.getDayRL() >= ssq.ZQ[2 * mk + 1])
				mk++; // 相对大雪的月数计算,mk的取值范围0-12

			D = mk + (int) Math.floor((ssq.ZQ[12] + 390) / 365.2422) * 12 + 900000; // 相对于1998年12月7(大雪)的月数,900000为正数基数
			lunarDate.setLunarMonth(D % 12);
			lunarDate.setCnEraMonth(Obb.Gan[D % 10] + Obb.Zhi[D % 12]);

			// 纪日,2000年1月7日起算
			D = lunarDate.getDayRL() - 6 + 9000000;
			lunarDate.setCnEraDay(Obb.Gan[D % 10] + Obb.Zhi[D % 12]);
			
//			lunarDate=genGztime(lunarDate,D % 10);
			int nRigan=D % 10;
//			// 时辰
//			//System.out.println(mCalendar.get(Calendar.HOUR_OF_DAY));
			int sc=(mCalendar.get(Calendar.HOUR_OF_DAY)+1)/2;
			sc=sc % 12;
			int nGsc=getGan(D % 10,sc);
			lunarDate.setCnEraTime(Obb.Gan[nGsc]+Obb.Zhi[sc]);
			
//			//刻
			int nFen=mCalendar.get(Calendar.MINUTE);
			int nKe=(int)Math.floor(nFen/10);
			if (mCalendar.get(Calendar.HOUR_OF_DAY) % 2==0) {
				//偶数小时
				nKe=nKe+6;
			}
			int nGke=getGan(nGsc, nKe);
			lunarDate.setCnEraKe(Obb.Gan[nGke]+Obb.Zhi[nKe]);
//			//分
			nFen=mCalendar.get(Calendar.MINUTE);
			if (mCalendar.get(Calendar.HOUR_OF_DAY) % 2==0) {
				//偶数小时
				nFen=nFen+60;
			}
			nFen=nFen/2;
			//int nGfen=getGan(nGke, nFen);
			lunarDate.setCnEraFen(getGZbyIdx(nFen));
//			//秒
			int nMiao=mCalendar.get(Calendar.SECOND);
			if (mCalendar.get(Calendar.MINUTE) % 2!=0) {
				//偶数分
				nMiao=nMiao+60;
			}
			nMiao=nMiao/10;
			int nGmiao=getGan(nFen % 10, nMiao);
			lunarDate.setCnEraMiao(Obb.Gan[nGmiao]+Obb.Zhi[nMiao % 12]);
			sxwnl.Log(lunarDate.getYear()+"-"+lunarDate.getMonth()+"-"+lunarDate.getDay()+"\n");
			sxwnl.Log(lunarDate.getCnEraYear()+" "+lunarDate.getCnEraMonth()+" "+lunarDate.getCnEraDay()+" "+lunarDate.getCnEraTime()+" "+lunarDate.getCnEraKe()+" "+lunarDate.getCnEraFen()+" "+lunarDate.getCnEraMiao());
			// 星座
			mk = (int) Math.floor((lunarDate.getDayRL() - ssq.ZQ[0] - 15) / 30.43685);
			if (mk < 11 && lunarDate.getDayRL() >= ssq.ZQ[2 * mk + 2])
				mk++; // 星座所在月的序数,(如果j=13,ob.d0不会超过第14号中气)
			lunarDate.setConstellation(Obb.XiZ[(mk + 12) % 12] + "座");
			// 回历
			Oba.getHuiLi(lunarDate.getDayRL(), lunarDate);
			// 节日
			// ob.A = ob.B = ob.C = ""; ob.Fjia = 0;
			Oba.getDayName(lunarDate, lunarDate); // 公历
			Obb.getDayName(lunarDate, lunarDate); // 农历

			lunarDates[i] = lunarDate;
		}

		// 以下是月相与节气的处理
		double d;
		int xn;
		double jd2 = Bd0 + Common.dt_T(Bd0) - (double) 8 / 24;
		// 月相查找
		w = XL.MS_aLon(jd2 / 36525, 10, 3);
		w = (int) Math.floor((w - 0.78) / Math.PI * 2) * Math.PI / 2;
		do {
			d = Obb.so_accurate(w);
			D = (int) Math.floor(d + 0.5);
			xn = (int) Math.floor(w / Common.pi2 * 4 + 4000000.01) % 4;
			w += Common.pi2 / 4;
			if (D >= Bd0 + Bdn)
				break;
			if (D < Bd0)
				continue;
			LunarDate lunarDate = lunarDates[D - Bd0];
			lunarDate.setMoonPhaseName(Obb.yxmc[xn]); // 取得月相名称
			lunarDate.setMoonPhaseTime(d);
			lunarDate.setMoonPhaseTimeStr(julianDate.timeStr(d));
		} while (D + 5 < Bd0 + Bdn);

		// 节气查找
		w = XL.S_aLon(jd2 / 36525, 3);
		w = (int) Math.floor((w - 0.13) / Common.pi2 * 24) * Common.pi2 / 24;
		do {
			d = Obb.qi_accurate(w);
			D = (int) Math.floor(d + 0.5);
			xn = (int) Math.floor(w / Common.pi2 * 24 + 24000006.01) % 24;
			w += Common.pi2 / 24;
			if (D >= Bd0 + Bdn)
				break;
			if (D < Bd0)
				continue;
			LunarDate lunarDate = lunarDates[D - Bd0];
			lunarDate.setSolarTermName(Obb.jqmc[xn]); // 取得节气名称
			lunarDate.setSolarTermTime(d);
			lunarDate.setSolarTermTimeStr(julianDate.timeStr(d));
		} while (D + 12 < Bd0 + Bdn);

		LunarCalendar.lunarDates = lunarDates;
	}
	public String getGZbyIdx(int idx) {
		return Obb.Gan[idx % 10]+Obb.Zhi[idx % 12];
	}
	//定气测试函数
	private String[] qiCalc(int year) {
		String[] solarTerms = new String[24];
		double T;
		//		String s = "", s2 = "";
		int y = Common.year2Ayear(String.valueOf(year)) - 2001;
		int n = 24;
		for (int i = 21, index = 0; i < n;) {
			T = XL.S_aLon_t((y + (double) i * 15 / 360 + 1) * 2 * Math.PI); //精确节气时间计算
			//			s2 += new JulianDate().JD2str(T * 36525 + Common.J2000 + (double) 8 / 24 - Common.dt_T(T * 36525))
			//					+ Obb.jqmc[(i - 18 >= 0 ? i - 18 : i + 6) % 24]; //日期转为字串
			String solarTerm = new JulianDate().JD2str(T * 36525 + Common.J2000 + (double) 8 / 24 - Common.dt_T(T * 36525))
					+ Obb.jqmc[(i - 18 >= 0 ? i - 18 : i + 6) % 24]; //日期转为字串
			solarTerms[index] = solarTerm.trim();
			//			if (i % 2 == 0)
			//				s2 += " 视黄经" + (i * 15) + "\n";
			//			else
			//				s2 += "　";
			//			if (i % 50 == 0) {
			//				s += s2;
			//				s2 = "";
			//			}
			i++;
			index++;
			if (i == 24) {
				i = 0;
				n = 21;
				y += 1;
			}
		}
		return solarTerms;
	}
	//五鼠遁干
//	甲己还加甲, 乙庚是丙初，
//	丙辛从戊起, 丁壬居庚子；
//	戊癸在何方, 壬子是真途。
	public int getGan(int ParentIdx,int idx) {
		int ret[]=new int[]{0,2,4,6,8};
		int n= ret[ParentIdx % 5];
		n=n+idx;
		n=n % 10;
		return n;
	}
	//获取空亡
	public String getkongwang(String str) {
		String strs[]=str.split(" ");
		String ret="";
		for (int i = 0; i < strs.length; i++) {
			ret=ret+" "+getkongwang2(strs[i]);
			
		}
		return ret.trim();
	}
	private static ArrayList<String> gzLst=new ArrayList<>();
	private String getkongwang2(String s) {
		if (gzLst.size()==0) {
			for (int i = 0; i < 60; i++) {
				gzLst.add(getGZbyIdx(i));
			}
		}
		int n=gzLst.indexOf(s);
		n=n/10;
		return Obb.kwStrings[n];
	}
}
