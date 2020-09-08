package com.itcrazy.alanmall.common.client.bs;

import java.util.HashMap;
import java.util.Map;

public class BrandCallUtil {

	/**
	 * 根据用户id获取坐席号码
	 * 
	 * @param userId
	 * @return
	 */
	public static String getSeatCode(Long userId) {
		Map<Long, String> m = new HashMap<Long, String>();
		m.put(10014L, "58117"); // 黄林花
		m.put(10018L, "58118"); // 孙玉演
		m.put(10017L, "58120"); // 瑶瑶
		m.put(10004L, "58121"); // 张宁
		m.put(10015L, "58122"); // 承梅
		m.put(10016L, "58123"); // 夏成林
		return m.get(userId);
	}

	/**
	 * 通过400电话查找对应品牌
	 * 
	 * @param telphone
	 * @return
	 */
	public static Long getBrandId(String callPhone) {
		return 75L;
	}

	/**
	 * 通过400电话查找对应商户ID
	 * 
	 * @param telphone
	 * @return
	 */
	public static Long getCompanyId(String callPhone) {
		return 63L;
	}
}
