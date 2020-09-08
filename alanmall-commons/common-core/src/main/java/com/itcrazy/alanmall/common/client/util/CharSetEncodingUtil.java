package com.itcrazy.alanmall.common.client.util;

import java.io.UnsupportedEncodingException;

/**
 * 转换字符串的编码
 */
public class CharSetEncodingUtil {

	public static final String ISO_8859_1 = "ISO-8859-1";

	public static final String UTF_8 = "UTF-8";

	public static final String GBK = "GBK";

	/**
	 * 将字符编码转换成ISO-8859-1码
	 */
	public static String toISO_8859_1(String str)
			throws UnsupportedEncodingException {
		return charsetStr(str, ISO_8859_1);
	}

	/**
	 * 将字符编码转换成UTF-8码
	 */
	public static String toUTF_8(String str)
			throws UnsupportedEncodingException {
		return charsetStr(str, UTF_8);
	}

	/**
	 * 将字符编码转换成GBK码
	 */
	public static String toGBK(String str) throws UnsupportedEncodingException {
		return CharSetEncodingUtil.charsetStr(str, GBK);
	}

	/**
	 * 字符串编码转换的实现方法
	 * 
	 */
	public static String charsetStr(String str, String newCharset)
			throws UnsupportedEncodingException {
		if (str != null) {
			// 用默认字符编码解码字符串。
			byte[] bs = str.getBytes();
			// 用新的字符编码生成字符串
			return new String(bs, newCharset);
		}
		return null;
	}
}