package com.itcrazy.alanmall.common.client.util;

/**
 * 转换卡号。
 * 
 * @author bbb
 * 
 */
public class CodeReplaceUtil {

	public static String codeReplace(String code) {
		code = code.trim();// 去除前后空格

		if (code.length() > 16) {
			if (code.contains(";") || code.contains("；")) {
				return code.substring(3, 19);
			} else if (code.contains("=")) {
				return code.substring(0, 16);
			} else if (code.substring(0, 6).equals("999001")) {// 买买提会员卡磁道信息
				return code.substring(6, 18);
			} else {
				return code.substring(2, 18);
			}
		}

		return code;
	}

	public static void main(String[] args) {
		System.out.println(codeReplace("5130501000037291"));
	}
}
