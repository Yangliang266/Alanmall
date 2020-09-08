package com.itcrazy.alanmall.common.client.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormat {

	public static String dateToString(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}

	public static String dateToString(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	public static String dateToMDHM(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm");
		return df.format(date);
	}

	public static String dateToYMDHM(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return df.format(date);
	}

	/**
	 * 格式化日期为“月-日”
	 *
	 * @param date
	 * @return
	 */
	public static String dateToMD(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("MM-dd");
		return df.format(date);
	}

	public static String dateToTimeString(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(date);
	}

	public static String dateTimeToDateString(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	public static String dateTimeToChinaDate(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		return df.format(date);
	}

	public static String dateToChinaDate(Date date, String format) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	public static String dateTimeToMonthString(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		return df.format(date);
	}

	public static String dateTimeToYearString(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		return df.format(date);
	}

	public static String dateToFormatString(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	/**
	 *
	 * @param str
	 *            yyyy-MM-dd HH:mm:ss格式的字符串
	 * @return
	 */
	public static Date stringToDate(String str) {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date dateTime = null;
		try {
			dateTime = dateTimeFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateTime;
	}

	/**
	 *
	 * @param str
	 *            字符串
	 * @return
	 */
	public static Date stringToFormatDate(String str, String format) {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(format);
		Date dateTime = null;
		try {
			dateTime = dateTimeFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateTime;
	}

	/**
	 *
	 * @param str
	 *            yyyyMMddHHmmss格式的字符串
	 * @return
	 */
	public static Date stringToDate2(String str) {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date dateTime = null;
		try {
			dateTime = dateTimeFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateTime;
	}

	public static Date stringToTime(String str) {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("HH:mm:ss");
		Date dateTime = null;
		try {
			dateTime = dateTimeFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateTime;
	}

	public static Date stringToDate(int year, int month, int day, String time) {
		String dateStr = year + "-" + month + "-" + day + " " + time;
		return stringToDate(dateStr);
	}

	public static Date getTodayDate(String time) {
		int y, m, d;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		y = cal.get(Calendar.YEAR);
		m = cal.get(Calendar.MONTH) + 1;
		d = cal.get(Calendar.DATE);
		Date date = DateFormat.stringToDate(y, m, d, time);
		return date;
	}

	public static Date addHour(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, hour);// 把日期往后增加一小时.整数往后推,负数往前移动
		return calendar.getTime();
	}

	public static Date addDay(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);// 把日期往后增加一天.整数往后推,负数往前移动
		return calendar.getTime();
	}

	public static Date addMonth(Date date, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);// 把日期往后增加一个月.整数往后推,负数往前移动
		return calendar.getTime();
	}

	public static Date addYear(Date date, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, year);// 把日期往后增加一年.整数往后推,负数往前移动
		return calendar.getTime();
	}

	public static String dateToHHmm(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		return df.format(date);
	}

	public static Date getMonthDay(int dayOfMonth, String time) { // 获得指定月份第几天
		Calendar c = Calendar.getInstance();

		Date date = DateFormat.stringToDate(c.get(Calendar.YEAR),
				c.get(Calendar.MONTH) + 1, dayOfMonth, time);
		c.setTime(date);

		Date nowDay = new Date();
		if (date.getTime() <= nowDay.getTime()) {
			c.add(Calendar.MONTH, 1);
		}
		return c.getTime();

	}

	public static Calendar getTodayStartTime() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c;
	}

	public static Calendar getTodayEndTime() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c;
	}

	/**
	 * 时间戳转换为日期时间型
	 *
	 * @param timeStamp
	 * @return
	 */
	public static Date getDateByTimeStamp(Long timeStamp) {

		Long d = timeStamp;
		while (d < 1000000000000L) {
			d = d * 10;
		}
		return new Date(d);

	}

	public static long dateDiff(String startTime, String endTime) {
		// 按照传入的格式生成一个simpledateformate对象
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		// long nh = 1000*60*60;//一小时的毫秒数
		// long nm = 1000*60;//一分钟的毫秒数
		// long ns = 1000;//一秒钟的毫秒数
		long diff;
		long day = 0;
		try {
			// 获得两个时间的毫秒时间差异
			diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
			day = diff / nd;// 计算差多少天
			// long hour = diff%nd/nh;//计算差多少小时
			// long min = diff%nd%nh/nm;//计算差多少分钟
			// long sec = diff%nd%nh%nm/ns;//计算差多少秒//输出结果
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return day;
	}

	/**
	 * 获取两个时间之间相差的分钟数
	 *
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long minuteDiff(Date startTime, Date endTime) {
		long minute = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			startTime = sdf.parse(sdf.format(startTime));
			endTime = sdf.parse(sdf.format(endTime));

			Calendar cal = Calendar.getInstance();
			cal.setTime(startTime);
			long time1 = cal.getTimeInMillis();
			cal.setTime(endTime);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 60);

			minute = Long.parseLong(String.valueOf(between_days));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return minute;
	}

	/**
	 * 获取两个时间之间相差的秒数
	 *
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long secondDiff(Date startTime, Date endTime) {
		long second = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			startTime = sdf.parse(sdf.format(startTime));
			endTime = sdf.parse(sdf.format(endTime));
			Calendar cal = Calendar.getInstance();
			cal.setTime(startTime);
			long time1 = cal.getTimeInMillis();
			cal.setTime(endTime);
			long time2 = cal.getTimeInMillis();
			long betweenSecond = (time2 - time1) / 1000;
			second = Long.parseLong(String.valueOf(betweenSecond));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return second;
	}

	/**
	 * 生成指定日期为开始时间的Date类型（YYYY-MM-DD转换为Date类型）
	 *
	 * @param _startDate
	 * @return
	 */
	public static Date getDateStart(String _startDate) {
		if (_startDate != null) {
			Calendar c = Calendar.getInstance();
			String[] arr = _startDate.split("-");
			c.set(Calendar.YEAR, Integer.valueOf(arr[0]));
			c.set(Calendar.MONTH, Integer.valueOf(arr[1]) - 1);
			c.set(Calendar.DAY_OF_MONTH, Integer.valueOf(arr[2]));
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			return c.getTime();
		}
		return null;
	}

	/**
	 * 生成指定日期为结束时间的Date类型（YYYY-MM-DD转换为Date类型）
	 *
	 * @param _startDate
	 * @return
	 */
	public static Date getDateEnd(String _endDate) {
		if (_endDate != null) {
			Calendar c = Calendar.getInstance();
			String[] arr = _endDate.split("-");
			c.set(Calendar.YEAR, Integer.valueOf(arr[0]));
			c.set(Calendar.MONTH, Integer.valueOf(arr[1]) - 1);
			c.set(Calendar.DAY_OF_MONTH, Integer.valueOf(arr[2]));
			c.set(Calendar.HOUR_OF_DAY, 23);
			c.set(Calendar.MINUTE, 59);
			c.set(Calendar.SECOND, 59);
			return c.getTime();
		}
		return null;
	}

	/**
	 * 获取指定开始日期至结束日期之间的日期字符串列表 可以指定时间间隔的单位 可以指定输出的字符串格式
	 *
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param periodType
	 *            间隔的时间单位
	 * @param format
	 *            格式
	 * @return
	 */
	public static List<String> getPeriodList(Date startDate, Date endDate,
			int periodType, String format) {
		List<String> lstRet = new ArrayList<String>();
		// 结束日期大于开始日期
		if (startDate.compareTo(endDate) > 0) {
			return null;
		}

		Calendar calStart = Calendar.getInstance();
		Calendar calEnd = Calendar.getInstance();

		calStart.setFirstDayOfWeek(Calendar.MONDAY);
		calEnd.setFirstDayOfWeek(Calendar.MONDAY);

		calStart.setTime(startDate);
		calEnd.setTime(endDate);

		// 如果间隔时间单位为周，则要获取开始日期所在周的第一天，结束日期所在周的最后一天
		if (periodType == Calendar.WEEK_OF_YEAR) {
			calStart.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			calEnd.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			String tempDate = "";
			while (calStart.compareTo(calEnd) <= 0) {
				int weekOfYear = calStart.get(Calendar.WEEK_OF_YEAR);

				String cmpDate = calStart.getWeekYear()
						+ "_"
						+ StringUtil.addFrontZeroForNum(
								String.valueOf(weekOfYear), 2);
				System.out.println(calStart.getTime() + "     " + cmpDate);
				if (!cmpDate.equals(tempDate)) {
					tempDate = cmpDate;
					lstRet.add(cmpDate);
				}
				calStart.add(Calendar.DATE, 1);
			}
		} else if(periodType == Calendar.MONTH) {
		    calStart.set(Calendar.DATE, 1);
		    calEnd.set(Calendar.DATE, 1);
		    while (calStart.compareTo(calEnd) <= 0) {
                String dateStr = dateToFormatString(calStart.getTime(), format);
                lstRet.add(dateStr);
                calStart.add(Calendar.MONTH, 1);
            }
		} else {
			while (calStart.compareTo(calEnd) <= 0) {
				String dateStr = dateToFormatString(calStart.getTime(), format);
				lstRet.add(dateStr);
				calStart.add(periodType, 1);
			}
		}

		return lstRet;
	}

	/**
	 * 判断输入的日期是否符合实际的日期格式
	 *
	 * @param input
	 * @return
	 */
	public static boolean isDateStr(String input) {
		boolean bRet = false;
		if (input == null) {
			return bRet;
		}
		String strPat = "((^((1[8-9]\\d{2})|([2-9]\\d{3}))(10|12|0?[13578])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))(11|0?[469])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))(0?2)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(0?2)(29)$)|(^([3579][26]00)(0?2)(29)$)|(^([1][89][0][48])(0?2)(29)$)|(^([2-9][0-9][0][48])(0?2)(29)$)|(^([1][89][2468][048])(0?2)(29)$)|(^([2-9][0-9][2468][048])(0?2)(29)$)|(^([1][89][13579][26])(0?2)(29)$)|(^([2-9][0-9][13579][26])(0?2)(29)$))";
		Pattern p = Pattern.compile(strPat);
		Matcher m = p.matcher(input);
		bRet = m.matches();

		return bRet;
	}

	/**
	 * 返回系统当前时间(精确到毫秒),作为一个唯一的订单编号
	 *
	 * @return 以yyyyMMddHHmmssS为格式的当前系统时间
	 */
	public static String getOrderNum() {
		Date date = new Date();
		java.text.DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssS");
		return df.format(date);
	}

	/**
	 * 产生随机的三位数
	 *
	 * @return
	 */
	public static String getThree() {
		Random rad = new Random();
		return rad.nextInt(1000) + "";
	}

	/**
	 * 判断输入的日期字符串，是否是符合指定格式的日期类型
	 *
	 * @param srcDate
	 * @param format
	 * @return
	 */
	public static boolean isDateTime(String srcDate, String format) {
		boolean dateflag = false;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			formatter.parse(srcDate);
			dateflag = true;
		} catch (Exception e) {
			dateflag = false;
		}
		return dateflag;
	}
}
