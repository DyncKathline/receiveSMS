package org.dync.receivesms;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {

	/**
	 * 获取现在时间字符串
	 *
	 * @return 返回字符串格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取现在短时间字符串
	 *
	 * @return 返回短时间字符串格式：年-月-日
	 */
	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",
				Locale.getDefault());
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取时间 小时:分;秒 HH:mm:ss
	 *
	 * @return 返回短时间字符串格式：时-分-秒
	 */
	public static String getTimeShort() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss",
				Locale.getDefault());
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 将长时间字符串转换为时间类型 yyyy-MM-dd HH:mm:ss
	 *
	 * @return 返回时间类型长字符串时间 yyyy-MM-dd HH:mm:ss
	 */
	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 将长时间类型转换为字符串 yyyy-MM-dd HH:mm:ss
	 *
	 * @param dateDate
	 *            时间类型
	 * @return 字符串时间
	 */
	public static String dateToStrLong(java.util.Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 *
	 * @param dateDate
	 *            时间类型
	 * @return 短时间字符串 yyyy-MM-dd
	 */
	public static String dateToStr(java.util.Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",
				Locale.getDefault());
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 *
	 * @return 短时间格式 yyyy-MM-dd
	 */
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",
				Locale.getDefault());
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 得到现在时间
	 *
	 * @return 现在的时间类型
	 */
	public static Date getNow() {
		Date currentTime = new Date();
		return currentTime;
	}

	/**
	 * 得到现在小时
	 */
	public static String getHour() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		String dateString = formatter.format(currentTime);
		String hour;
		hour = dateString.substring(11, 13);
		return hour;
	}

	/**
	 * 得到现在分钟
	 *
	 * @return
	 */
	public static String getTime() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		String dateString = formatter.format(currentTime);
		String min;
		min = dateString.substring(14, 16);
		return min;
	}

	/**
	 * 根据用户传入的时间表示格式，返回当前时间的格式 例如：yyyy-MM-dd HH:mm:ss，注意字母y不能大写。
	 *
	 * @param sformat
	 *            yyyy-MM-dd HH:mm:ss
	 * @return 指定格式的时间
	 */
	public static String getUserDate(String sformat) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(sformat,
				Locale.getDefault());
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	 *
	 * @param st1
	 *            "HH:MM"的格式
	 * @param st2
	 *            "HH:MM"的格式
	 * @return 两个时间间的分钟
	 */
	public static String getTwoHour(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		int y = Integer.parseInt(kk[0]) - Integer.parseInt(jj[0]);
		int u = Integer.parseInt(kk[1]) - Integer.parseInt(jj[1]);
		if (y > 0)
			return y * 60 + u + "";
		else if (y < 0)
			return -(y * 60 + u) + "";
		else {
			if (u >= 0) {
				return u + "";
			} else {
				return -u + "";
			}
		}
	}

	/**
	 * 得到二个日期间的间隔天数，保证时间字符格式为yyyy-MM-dd
	 *
	 * @param sj1
	 *            时间字符格式为yyyy-MM-dd
	 * @param sj2
	 *            时间字符格式为yyyy-MM-dd
	 * @return 两个日期间的天数
	 */
	public static String getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd",
				Locale.getDefault());
		long day = 0;
		try {
			java.util.Date date = myFormatter.parse(sj1);
			java.util.Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}

	/**
	 * 时间前推或后推分钟,其中fzh表示分钟数，保证时间字符格式为yyyy-MM-dd HH:mm:ss
	 *
	 * @param sj1
	 *            时间字符格式为yyyy-MM-dd HH:mm:ss
	 * @param sj1
	 *            fzh表示为前移或后延的分钟数
	 */
	public static String getPreTime(String sj1, String fzh) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				Locale.getDefault());
		String mydate1 = "";
		try {
			Date date1 = format.parse(sj1);
			long Time = (date1.getTime() / 1000) + Integer.parseInt(fzh) * 60;
			date1.setTime(Time * 1000);
			mydate1 = format.format(date1);
		} catch (Exception e) {
		}
		return mydate1;
	}

	/**
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数，保证时间字符格式为yyyy-MM-dd
	 *
	 * @param nowdate
	 *            时间字符格式为yyyy-MM-dd
	 * @param delay
	 *            为前移或后延的天数，负值为前移
	 */
	public static String getNextDay(String nowdate, String delay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",
					Locale.getDefault());
			String mdate = "";
			Date d = strToDate(nowdate);
			long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24
					* 60 * 60;
			d.setTime(myTime * 1000);
			mdate = format.format(d);
			return mdate;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 判断是否润年
	 *
	 * @param ddate
	 *            字符串格式的时间
	 * @return
	 */
	public static boolean isLeapYear(String ddate) {

		/**
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰年
		 */
		Date d = strToDate(ddate);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		int year = gc.get(Calendar.YEAR);
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0) {
			if ((year % 100) == 0)
				return false;
			else
				return true;
		} else
			return false;
	}

	/**
	 * 返回美国时间格式 26 Apr 2006 ，保证时间字符格式为yyyy-MM-dd
	 *
	 * @param str
	 *            字符串格式的时间yyyy-MM-dd
	 * @return 美国时间字符串 例如：26 Apr 2006
	 */
	public static String getEDate(String str) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",
				Locale.getDefault());
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(str, pos);
		String j = strtodate.toString();
		String[] k = j.split(" ");
		return k[2] + " " + k[1].toUpperCase(Locale.ENGLISH) + " "
				+ k[5].substring(0, 4);
	}

	/**
	 * 获取一个月的最后一天，建议时间格式为yyyy-MM-dd
	 *
	 * @param dat
	 *            字符串格式的yyyy-MM-dd
	 * @return
	 */
	public static String getEndDateOfMonth(String dat) {
		String str = dat.substring(0, 8);
		String month = dat.substring(5, 7);
		int mon = Integer.parseInt(month);
		if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8
				|| mon == 10 || mon == 12) {
			str += "31";
		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			str += "30";
		} else {
			if (isLeapYear(dat)) {
				str += "29";
			} else {
				str += "28";
			}
		}
		return str;
	}

	/**
	 * 判断二个时间是否在同一个周
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameWeekDates(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (0 == subYear) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
			// 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}

	/**
	 * 产生周序列,即得到当前时间所在的年度是第几周
	 *
	 * @return
	 */
	public static String getSeqWeek() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
			week = "0" + week;
		return week;
	}

	/**
	 * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
	 *
	 * @param sdate
	 *            字符串格式的yyyy-MM-dd
	 * @param num
	 *            星期几，例如1表示星期一
	 */
	public static String getWeek(String sdate, int num) {
		// 再转换为时间
		Date dd = DateUtil.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(dd);
		switch (num) {
		case 1:
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			break;
		case 2:
			c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			break;
		case 3:
			c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
			break;
		case 4:
			c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
			break;
		case 5:
			c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			break;
		case 6:
			c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
			break;
		case 7:
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			break;

		default:
			break;
		}
		return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(c
				.getTime());
	}

	/**
	 * 根据一个日期，返回是星期几的数字字符串
	 *
	 * @param sdate
	 *            字符串格式的yyyy-MM-dd
	 * @return
	 */
	public static String getWeek(String sdate) {
		// 再转换为时间
		Date date = DateUtil.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return new SimpleDateFormat("EEEE", Locale.getDefault()).format(c
				.getTime());
	}

	/**
	 * 将农历日期转换为公历日期
	 *
	 * @param year
	 *            农历年份
	 * @param month
	 *            农历月
	 * @param monthDay
	 *            农历日
	 * @param isLeapMonth
	 *            该月是否是闰月
	 * @return 返回农历日期对应的公历日期，0:year, 1:month, 2:day
	 */
	public static int[] lunarToSolar(int year, int month, int monthDay,
			boolean isLeapMonth) {
		return PaseDateUtil.lunarToSolar(year, month, monthDay, isLeapMonth);
	}

	/**
	 * 将农历日期转换为公历日期
	 *
	 * @param year
	 *            农历年份
	 * @param month
	 *            农历月
	 * @param monthDay
	 *            农历日
	 * @param isLeapMonth
	 *            该月是否是闰月
	 * @return 返回农历日期对应的公历日期，0:year, 1:month, 2:day
	 */
	public static int[] lunarToSolar(String year, String month,
			String monthDay, boolean isLeapMonth) {
		return PaseDateUtil.lunarToSolar(year, month, monthDay, isLeapMonth);
	}

	/**
	 * 将公历日期转换为农历日期，且返回标识是否是闰月
	 *
	 * @param year
	 * @param month
	 * @param monthDay
	 * @return 返回公历日期对应的农历日期，year0，month1，day2，leap3
	 */
	public static final int[] solarToLunar(int year, int month, int monthDay) {
		return PaseDateUtil.solarToLunar(year, month, monthDay);
	}

	/**
	 * 将公历日期转换为农历日期，且返回标识是否是闰月
	 *
	 * @param year
	 * @param month
	 * @param monthDay
	 * @return 返回公历日期对应的农历日期，year0，month1，day2，leap3
	 */
	public static final int[] solarToLunar(String year, String month,
			String monthDay) {
		return PaseDateUtil.solarToLunar(year, month, monthDay);
	}
}

/**
 * 工具类，实现公农历互转
 */
class PaseDateUtil {

	/**
	 * 支持转换的最小农历年份
	 */
	public static final int MIN_YEAR = 1900;
	/**
	 * 支持转换的最大农历年份
	 */
	public static final int MAX_YEAR = 2099;

	/**
	 * 公历每月前的天数
	 */
	private static final int DAYS_BEFORE_MONTH[] = { 0, 31, 59, 90, 120, 151,
			181, 212, 243, 273, 304, 334, 365 };

	/**
	 * 用来表示1900年到2099年间农历年份的相关信息，共24位bit的16进制表示，其中： 1. 前4位表示该年闰哪个月； 2.
	 * 5-17位表示农历年份13个月的大小月分布，0表示小，1表示大； 3. 最后7位表示农历年首（正月初一）对应的公历日期。
	 *
	 * 以2014年的数据0x955ABF为例说明： 1001 0101 0101 1010 1011 1111 闰九月 农历正月初一对应公历1月31号
	 */
	private static final int LUNAR_INFO[] = { 0x84B6BF,/* 1900 */
	0x04AE53, 0x0A5748, 0x5526BD, 0x0D2650, 0x0D9544, 0x46AAB9, 0x056A4D,
			0x09AD42, 0x24AEB6, 0x04AE4A,/* 1901-1910 */
			0x6A4DBE, 0x0A4D52, 0x0D2546, 0x5D52BA, 0x0B544E, 0x0D6A43,
			0x296D37, 0x095B4B, 0x749BC1, 0x049754,/* 1911-1920 */
			0x0A4B48, 0x5B25BC, 0x06A550, 0x06D445, 0x4ADAB8, 0x02B64D,
			0x095742, 0x2497B7, 0x04974A, 0x664B3E,/* 1921-1930 */
			0x0D4A51, 0x0EA546, 0x56D4BA, 0x05AD4E, 0x02B644, 0x393738,
			0x092E4B, 0x7C96BF, 0x0C9553, 0x0D4A48,/* 1931-1940 */
			0x6DA53B, 0x0B554F, 0x056A45, 0x4AADB9, 0x025D4D, 0x092D42,
			0x2C95B6, 0x0A954A, 0x7B4ABD, 0x06CA51,/* 1941-1950 */
			0x0B5546, 0x555ABB, 0x04DA4E, 0x0A5B43, 0x352BB8, 0x052B4C,
			0x8A953F, 0x0E9552, 0x06AA48, 0x6AD53C,/* 1951-1960 */
			0x0AB54F, 0x04B645, 0x4A5739, 0x0A574D, 0x052642, 0x3E9335,
			0x0D9549, 0x75AABE, 0x056A51, 0x096D46,/* 1961-1970 */
			0x54AEBB, 0x04AD4F, 0x0A4D43, 0x4D26B7, 0x0D254B, 0x8D52BF,
			0x0B5452, 0x0B6A47, 0x696D3C, 0x095B50,/* 1971-1980 */
			0x049B45, 0x4A4BB9, 0x0A4B4D, 0xAB25C2, 0x06A554, 0x06D449,
			0x6ADA3D, 0x0AB651, 0x095746, 0x5497BB,/* 1981-1990 */
			0x04974F, 0x064B44, 0x36A537, 0x0EA54A, 0x86B2BF, 0x05AC53,
			0x0AB647, 0x5936BC, 0x092E50, 0x0C9645,/* 1991-2000 */
			0x4D4AB8, 0x0D4A4C, 0x0DA541, 0x25AAB6, 0x056A49, 0x7AADBD,
			0x025D52, 0x092D47, 0x5C95BA, 0x0A954E,/* 2001-2010 */
			0x0B4A43, 0x4B5537, 0x0AD54A, 0x955ABF, 0x04BA53, 0x0A5B48,
			0x652BBC, 0x052B50, 0x0A9345, 0x474AB9,/* 2011-2020 */
			0x06AA4C, 0x0AD541, 0x24DAB6, 0x04B64A, 0x6a573D, 0x0A4E51,
			0x0D2646, 0x5E933A, 0x0D534D, 0x05AA43,/* 2021-2030 */
			0x36B537, 0x096D4B, 0xB4AEBF, 0x04AD53, 0x0A4D48, 0x6D25BC,
			0x0D254F, 0x0D5244, 0x5DAA38, 0x0B5A4C,/* 2031-2040 */
			0x056D41, 0x24ADB6, 0x049B4A, 0x7A4BBE, 0x0A4B51, 0x0AA546,
			0x5B52BA, 0x06D24E, 0x0ADA42, 0x355B37,/* 2041-2050 */
			0x09374B, 0x8497C1, 0x049753, 0x064B48, 0x66A53C, 0x0EA54F,
			0x06AA44, 0x4AB638, 0x0AAE4C, 0x092E42,/* 2051-2060 */
			0x3C9735, 0x0C9649, 0x7D4ABD, 0x0D4A51, 0x0DA545, 0x55AABA,
			0x056A4E, 0x0A6D43, 0x452EB7, 0x052D4B,/* 2061-2070 */
			0x8A95BF, 0x0A9553, 0x0B4A47, 0x6B553B, 0x0AD54F, 0x055A45,
			0x4A5D38, 0x0A5B4C, 0x052B42, 0x3A93B6,/* 2071-2080 */
			0x069349, 0x7729BD, 0x06AA51, 0x0AD546, 0x54DABA, 0x04B64E,
			0x0A5743, 0x452738, 0x0D264A, 0x8E933E,/* 2081-2090 */
			0x0D5252, 0x0DAA47, 0x66B53B, 0x056D4F, 0x04AE45, 0x4A4EB9,
			0x0A4D4C, 0x0D1541, 0x2D92B5 /* 2091-2099 */
	};

	/**
	 * 将农历日期转换为公历日期
	 *
	 * @param year
	 *            农历年份
	 * @param month
	 *            农历月
	 * @param monthDay
	 *            农历日
	 * @param isLeapMonth
	 *            该月是否是闰月
	 * @return 返回农历日期对应的公历日期，0:year, 1:month, 2:day
	 */
	public static final int[] lunarToSolar(int year, int month, int monthDay,
			boolean isLeapMonth) {
		int dayOffset;
		int leapMonth;
		int i;

		if (year < MIN_YEAR || year > MAX_YEAR || month < 1 || month > 12
				|| monthDay < 1 || monthDay > 30) {
			throw new IllegalArgumentException(
					"Illegal lunar date, must be like that:\n\t"
							+ "year : 1900~2099\n\t" + "month : 1~12\n\t"
							+ "day : 1~30");
		}

		dayOffset = (LUNAR_INFO[year - MIN_YEAR] & 0x001F) - 1;

		if (((LUNAR_INFO[year - MIN_YEAR] & 0x0060) >> 5) == 2)
			dayOffset += 31;

		for (i = 1; i < month; i++) {
			if ((LUNAR_INFO[year - MIN_YEAR] & (0x80000 >> (i - 1))) == 0)
				dayOffset += 29;
			else
				dayOffset += 30;
		}

		dayOffset += monthDay;
		leapMonth = (LUNAR_INFO[year - MIN_YEAR] & 0xf00000) >> 20;

		// 这一年有闰月
		if (leapMonth != 0) {
			if (month > leapMonth || (month == leapMonth && isLeapMonth)) {
				if ((LUNAR_INFO[year - MIN_YEAR] & (0x80000 >> (month - 1))) == 0)
					dayOffset += 29;
				else
					dayOffset += 30;
			}
		}

		if (dayOffset > 366 || (year % 4 != 0 && dayOffset > 365)) {
			year += 1;
			if (year % 4 == 1)
				dayOffset -= 366;
			else
				dayOffset -= 365;
		}

		int[] solarInfo = new int[3];
		for (i = 1; i < 13; i++) {
			int iPos = DAYS_BEFORE_MONTH[i];
			if (year % 4 == 0 && i > 2) {
				iPos += 1;
			}

			if (year % 4 == 0 && i == 2 && iPos + 1 == dayOffset) {
				solarInfo[1] = i;
				solarInfo[2] = dayOffset - 31;
				break;
			}

			if (iPos >= dayOffset) {
				solarInfo[1] = i;
				iPos = DAYS_BEFORE_MONTH[i - 1];
				if (year % 4 == 0 && i > 2) {
					iPos += 1;
				}
				if (dayOffset > iPos)
					solarInfo[2] = dayOffset - iPos;
				else if (dayOffset == iPos) {
					if (year % 4 == 0 && i == 2)
						solarInfo[2] = DAYS_BEFORE_MONTH[i]
								- DAYS_BEFORE_MONTH[i - 1] + 1;
					else
						solarInfo[2] = DAYS_BEFORE_MONTH[i]
								- DAYS_BEFORE_MONTH[i - 1];

				} else
					solarInfo[2] = dayOffset;
				break;
			}
		}
		solarInfo[0] = year;

		return solarInfo;
	}

	/**
	 * 将农历日期转换为公历日期
	 *
	 * @param year
	 *            农历年份
	 * @param month
	 *            农历月
	 * @param monthDay
	 *            农历日
	 * @param isLeapMonth
	 *            该月是否是闰月
	 * @return 返回农历日期对应的公历日期，0:year, 1:month, 2:day
	 */
	public static final int[] lunarToSolar(String year, String month,
			String monthDay, boolean isLeapMonth) {
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month);
		int md = Integer.parseInt(monthDay);
		return lunarToSolar(y, m, md, isLeapMonth);
	}

	/**
	 * 将公历日期转换为农历日期，且返回标识是否是闰月
	 *
	 * @param year
	 * @param month
	 * @param monthDay
	 * @return 返回公历日期对应的农历日期，year0，month1，day2，leap3
	 */
	public static final int[] solarToLunar(int year, int month, int monthDay) {
		int[] lunarDate = new int[4];
		Date baseDate = new GregorianCalendar(1900, 0, 31).getTime();
		Date objDate = new GregorianCalendar(year, month - 1, monthDay)
				.getTime();
		int offset = (int) ((objDate.getTime() - baseDate.getTime()) / 86400000L);

		// 用offset减去每农历年的天数计算当天是农历第几天
		// iYear最终结果是农历的年份, offset是当年的第几天
		int iYear, daysOfYear = 0;
		for (iYear = MIN_YEAR; iYear <= MAX_YEAR && offset > 0; iYear++) {
			daysOfYear = daysInLunarYear(iYear);
			offset -= daysOfYear;
		}
		if (offset < 0) {
			offset += daysOfYear;
			iYear--;
		}

		// 农历年份
		lunarDate[0] = iYear;
		int leapMonth = leapMonth(iYear); // 闰哪个月,1-12
		boolean isLeap = false;
		// 用当年的天数offset,逐个减去每月（农历）的天数，求出当天是本月的第几天
		int iMonth, daysOfMonth = 0;
		for (iMonth = 1; iMonth <= 13 && offset > 0; iMonth++) {
			daysOfMonth = daysInLunarMonth(iYear, iMonth);
			offset -= daysOfMonth;
		}
		// 当前月超过闰月，要校正
		if (leapMonth != 0 && iMonth > leapMonth) {
			--iMonth;

			if (iMonth == leapMonth) {
				isLeap = true;
			}
		}
		// offset小于0时，也要校正
		if (offset < 0) {
			offset += daysOfMonth;
			--iMonth;
		}

		lunarDate[1] = iMonth;
		lunarDate[2] = offset + 1;
		lunarDate[3] = isLeap ? 1 : 0;

		return lunarDate;
	}

	/**
	 * 将公历日期转换为农历日期，且返回标识是否是闰月
	 *
	 * @param year
	 * @param month
	 * @param monthDay
	 * @return 返回公历日期对应的农历日期，year0，month1，day2，leap3
	 */
	public static final int[] solarToLunar(String year, String month,
			String monthDay) {
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month);
		int md = Integer.parseInt(monthDay);
		return solarToLunar(y, m, md);
	}

	/**
	 * 传回农历year年month月的总天数
	 *
	 * @param year
	 *            要计算的年份
	 * @param month
	 *            要计算的月
	 * @return 传回天数
	 */
	public static final int daysInMonth(int year, int month) {
		return daysInMonth(year, month, false);
	}

	/**
	 * 传回农历year年month月的总天数
	 *
	 * @param year
	 *            要计算的年份
	 * @param month
	 *            要计算的月
	 * @param leap
	 *            当月是否是闰月
	 * @return 传回天数，如果闰月是错误的，返回0.
	 */
	public static final int daysInMonth(int year, int month, boolean leap) {
		int leapMonth = leapMonth(year);
		int offset = 0;

		// 如果本年有闰月且month大于闰月时，需要校正
		if (leapMonth != 0 && month > leapMonth) {
			offset = 1;
		}

		// 不考虑闰月
		if (!leap) {
			return daysInLunarMonth(year, month + offset);
		} else {
			// 传入的闰月是正确的月份
			if (leapMonth != 0 && leapMonth == month) {
				return daysInLunarMonth(year, month + 1);
			}
		}

		return 0;
	}

	/**
	 * 传回农历 year年的总天数
	 *
	 * @param year
	 *            将要计算的年份
	 * @return 返回传入年份的总天数
	 */
	private static int daysInLunarYear(int year) {
		int i, sum = 348;
		if (leapMonth(year) != 0) {
			sum = 377;
		}
		int monthInfo = LUNAR_INFO[year - MIN_YEAR] & 0x0FFF80;
		for (i = 0x80000; i > 0x7; i >>= 1) {
			if ((monthInfo & i) != 0)
				sum += 1;
		}
		return sum;
	}

	/**
	 * 传回农历 year年month月的总天数，总共有13个月包括闰月
	 *
	 * @param year
	 *            将要计算的年份
	 * @param month
	 *            将要计算的月份
	 * @return 传回农历 year年month月的总天数
	 */
	private static int daysInLunarMonth(int year, int month) {
		if ((LUNAR_INFO[year - MIN_YEAR] & (0x100000 >> month)) == 0)
			return 29;
		else
			return 30;
	}

	/**
	 * 传回农历 year年闰哪个月 1-12 , 没闰传回 0
	 *
	 * @param year
	 *            将要计算的年份
	 * @return 传回农历 year年闰哪个月1-12, 没闰传回 0
	 */
	private static int leapMonth(int year) {
		return (int) ((LUNAR_INFO[year - MIN_YEAR] & 0xF00000)) >> 20;
	}
}