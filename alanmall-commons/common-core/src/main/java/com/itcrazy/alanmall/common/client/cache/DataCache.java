package com.itcrazy.alanmall.common.client.cache;

import com.itcrazy.alanmall.common.cache.memcached.MemProxy;
import com.whalin.MemCached.MemCachedClient;
import java.util.Calendar;

public class DataCache {

	public static void put(String key, Object value, int expiraMinutes) {
		if (key == null || value == null) {
			return;
		}
		MemCachedClient proxy = MemProxy.getInstance();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, expiraMinutes);
		proxy.set(key, value, c.getTime());
	}

	public static boolean add(String key, Object value, int expiraMinutes) {
		if (key == null || value == null) {
			return false;
		}
		MemCachedClient proxy = MemProxy.getInstance();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, expiraMinutes);
		return proxy.add(key, value, c.getTime());
	}

	public static void remove(String key) {
		MemCachedClient proxy = MemProxy.getInstance();
		proxy.delete(key);
	}

	public static Object get(String key) {
		MemCachedClient proxy = MemProxy.getInstance();
		return proxy.get(key);
	}

}
