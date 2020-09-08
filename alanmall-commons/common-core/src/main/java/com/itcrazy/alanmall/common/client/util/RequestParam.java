package com.itcrazy.alanmall.common.client.util;

import java.util.Map;

/**
 * 从reqest参数
 * 
 * @author DDD
 *
 */
public class RequestParam {

	/**
	 * 从request的map里面获取参数
	 * 
	 * @param params
	 * @param param
	 * @return
	 */
	public static String getRequestParam(Map<String, Object> params,
			String param) {
		Object oParam = params.get(param);
		if (oParam == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();

		if (oParam instanceof String[]) {
			String[] arr = (String[]) oParam;
			for (String value : arr) {
				sb.append(value);
			}
		} else {
			return null;
		}
		return sb.toString();
	}

}
