package com.itcrazy.alanmall.common.client.bs;

import com.itcrazy.alanmall.common.client.util.DateFormat;

import java.util.Date;

public class StoreDayReportKey {

	/**
	 * 一次读取多个类型数据,key值生成方式
	 * 
	 * @return
	 */
	public static String getKey(Date sumDate, Long brandId, Long storeId) {
		return DateFormat.dateTimeToDateString(sumDate) + "_" + brandId + "_"
				+ (storeId == null ? 0 : storeId);
	}

}
