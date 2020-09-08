package com.itcrazy.alanmall.common.client.util;

import java.util.regex.Pattern;

public class StringUtil {
	/**
	 * 字符串前补0
	 *
	 * @param str
	 *            字符串
	 * @param strLength
	 *            指定长度
	 *
	 * @return String 补0后的字符串
	 */
	public static String addFrontZeroForNum(String str, int strLength) {
		int strLen = str.length();
		if (strLen < strLength) {
			StringBuffer rslt = new StringBuffer();
			while (strLen < strLength) {
				rslt.append("0");
				strLen++;
			}
			rslt.append(str);
			str = rslt.toString();
		}
		return str;
	}

	/**
	 * 判断string是否是含0的正整数
	 * @param str
	 * @return
	 */
	public static Boolean isNum(String str) {
		Pattern pattern = Pattern.compile("^[0-9]*$");
		return pattern.matcher(str).matches();
	}
}
