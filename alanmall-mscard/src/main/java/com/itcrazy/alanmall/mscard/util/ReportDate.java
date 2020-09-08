package com.itcrazy.alanmall.mscard.util;

import com.itcrazy.alanmall.common.client.util.DateFormat;

import java.util.Calendar;
import java.util.Date;

public class ReportDate {

	public static String getEndDate(String endDate){
		Calendar c=Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.add(Calendar.DATE, -1);
		if(endDate==null || "".equals(endDate.trim())){
			return DateFormat.dateToString(c.getTime());
		}
		Date d=DateFormat.stringToDate(endDate+" 23:59:59");
		if(d.getTime()>c.getTime().getTime()){
			return DateFormat.dateToString(c.getTime());
		}
		return endDate+" 23:59:59";
	}
}
