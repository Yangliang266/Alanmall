package com.itcrazy.alanmall.common.cache.jedis;

public class RedisDataCache {

	public static int DEFAULT_EXPIRATE_MINUTES = 60*24*7;
	
	public static void put(String key, Object value) {
		if (key == null || value == null) {
			return;
		}
		RedisCacheConfig.set(key, value, DEFAULT_EXPIRATE_MINUTES * 60);

	}
	
	public static void put(String key, Object value, int expiraMinutes) {
		if (key == null || value == null) {
			return;
		}
		RedisCacheConfig.set(key, value, expiraMinutes * 60);

	}

	public static String putnx(String key,  int timeOutSecond) {
		if (key == null ) {
			return null;
		}
		return RedisCacheConfig.setnx(key,  timeOutSecond);

	}
	public static void remove(String key) {
		RedisCacheConfig.remove(key);
	}

	public static Object get(String key) {
		return RedisCacheConfig.get(key);
	}
	public static Boolean isKeyExists(String key) {
		return RedisCacheConfig.isKeyExists(key);
	}
}
