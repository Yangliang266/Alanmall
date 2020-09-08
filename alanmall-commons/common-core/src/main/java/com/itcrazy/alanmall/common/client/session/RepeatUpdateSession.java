package com.itcrazy.alanmall.common.client.session;

import com.itcrazy.alanmall.common.client.cache.DataCache;

public class RepeatUpdateSession {

	/**
	 * 判断在指定时间内是否重复提交
	 * 
	 * @param sid
	 * @param seconds
	 * @return
	 */
	public static synchronized Boolean isRepeat(String sid, String request,
			int seconds) {
		if (sid == null) {
			return false;
		}
		String key = request + "_" + sid;
		Object t = (Object) DataCache.get(key);
		if (t == null) {// 缓存中不存在
			Long time = System.currentTimeMillis();
			DataCache.put(key, time, 1);// 1分钟自动过期
			return false;
		}
		if (t != null) {
			Long time = System.currentTimeMillis();
			Long tLong = Long.valueOf(t.toString());
			Long d = (time - tLong) / 1000;// 两次操作相距秒数

			if (d <= seconds) { // 3秒之内防止重复提交
				return true;
			}
			DataCache.put(key, time, 1);// 1分钟自动过期
		}

		return false;
	}

}
