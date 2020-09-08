package com.itcrazy.alanmall.common.cache;

import com.itcrazy.alanmall.common.cache.jedis.RedisCacheConfig;
import com.itcrazy.alanmall.common.client.util.RandomNumUtil;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class RedisSessionCache {
	public static int DEFAULT_EXPIRATE_MINUTES = 60 * 4;
	public static final String COOKIE_NAME = "session";
	public static void put(String key, Object value) {
		if (key == null || value == null) {
			return;
		}
		put(key, value, RedisSessionCache.DEFAULT_EXPIRATE_MINUTES);
	}

	public static void put(String key, Object value, int expiraMinutes) {
		if (key == null || value == null) {
			return;
		}
		RedisCacheConfig.set(key, value, expiraMinutes*60);
	}

	public static void put(HttpServletRequest request, HttpServletResponse response, String key, Object value) {
		if (key == null || value == null) {
			return;
		}
		Cookie[] cookies = request.getCookies();
		String cookieValue = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (RedisSessionCache.COOKIE_NAME.equals(cookies[i].getName())) {
					cookieValue = cookies[i].getValue(); // 取得uSession的值
					break;
				}
			}
		}

		if (cookieValue == null) {
			cookieValue = RandomNumUtil.getCharacterAndNumber(32);
			Cookie cookie = new Cookie(RedisSessionCache.COOKIE_NAME, cookieValue);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		key += cookieValue;

		put(key, value);
	}

	public static void put(HttpServletRequest request, HttpServletResponse response, String key, Object value,
			int expiraMinutes) {
		if (key == null || value == null) {
			return;
		}
		Cookie[] cookies = request.getCookies();
		String cookieValue = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (RedisSessionCache.COOKIE_NAME.equals(cookies[i].getName())) {
					cookieValue = cookies[i].getValue();
					break;
				}
			}
		}

		if (cookieValue == null) {
			cookieValue =RandomNumUtil.getCharacterAndNumber(32);
			Cookie cookie = new Cookie(RedisSessionCache.COOKIE_NAME, cookieValue);
			cookie.setPath("/");//设置path路径
			response.addCookie(cookie);
		}
		key += cookieValue;
		put(key,value,expiraMinutes);
	}

	public static Object get(String key) {

		Object o = RedisCacheConfig.get(key);
		if (o != null) { // 防止会话过期,自动更新过期时间
			put(key, o);
		}
		return o;
	}

	public static Object get(String key, int expirateTime) {

		Object o = RedisCacheConfig.get(key);
		if (o != null) { // 防止会话过期,自动更新过期时间
			put(key, o, expirateTime);
		}
		return o;
	}

	public static Object get(HttpServletRequest request,String key) {
		Cookie[] cookies = request.getCookies();
		String cookieValue = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (RedisSessionCache.COOKIE_NAME.equals(cookies[i].getName())) {
					cookieValue = cookies[i].getValue();
					break;
				}
			}
		}

		if (cookieValue == null) {
			 
			return null;
		} else {
			key += cookieValue;
		}
		return get(key);
	}

	public static void remove(HttpServletRequest request, HttpServletResponse response, String key) {
		Cookie[] cookies = request.getCookies();
		String cookieValue = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (RedisSessionCache.COOKIE_NAME.equals(cookies[i].getName())) {
					cookieValue = cookies[i].getValue();
					Cookie cookie = new Cookie(RedisSessionCache.COOKIE_NAME, null);
					cookie.setPath("/"); 
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					break;
				}
			}
		} 

		if (cookieValue == null) {
			log.error("Cookie name cacheSession not found!");
		} else {
			key += cookieValue;
		}

		RedisCacheConfig.remove(key);
	}
}
