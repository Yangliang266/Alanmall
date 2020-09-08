package com.itcrazy.alanmall.common.client.bs;

import java.util.HashMap;
import java.util.Map;

public class PromTypeIdReplaceSmsIdUtil {
	private static Map<Long, Long> map = null;
	static {
		map = new HashMap<Long, Long>();
		map.put(1L, 101L);
		map.put(2L, 102L);
		map.put(3L, 103L);
		map.put(4L, 104L);
		map.put(5L, 105L);
		map.put(6L, 106L);
		map.put(7L, 107L);
		map.put(8L, 108L);
		map.put(10L, 21L);
	}

	/**
	 * 跟均促销类型ID转换成对应的短信模版ID
	 * 
	 * @param promTypeId
	 * @return
	 */
	public static Long promTypeIdReplaceSmsId(Long promTypeId) {
		return map.get(promTypeId);
	}

	public static void main(String[] args) {
		System.out.println(PromTypeIdReplaceSmsIdUtil
				.promTypeIdReplaceSmsId(1L));
	}
}
