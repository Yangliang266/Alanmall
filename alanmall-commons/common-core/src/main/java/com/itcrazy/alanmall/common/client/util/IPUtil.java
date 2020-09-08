package com.itcrazy.alanmall.common.client.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 5i美食服务器获取客户端ip地址
 * 
 * @author DDD
 *
 */
public class IPUtil {

	public static String getRemortIP(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");

		return ip;
	}

}
