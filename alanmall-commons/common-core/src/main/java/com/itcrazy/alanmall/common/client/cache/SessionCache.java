package com.itcrazy.alanmall.common.client.cache;

import com.itcrazy.alanmall.common.cache.memcached.MemSessionProxy;
import com.itcrazy.alanmall.common.client.util.RandomNumUtil;
import com.whalin.MemCached.MemCachedClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

public class SessionCache {
	private static final Log log = LogFactory.getLog(SessionCache.class);
	public static int DEFAULT_EXPIRATE_MINUTES = 60 * 4;
	public static final String COOKIE_NAME = "cacheSession";

	public static void put(String key, Object value) {
		if (key == null || value == null) {
			return;
		}
		put(key, value, SessionCache.DEFAULT_EXPIRATE_MINUTES);
	}

	public static void put(String key, Object value, int expiraMinutes) {
		if (key == null || value == null) {
			return;
		}
		MemCachedClient proxy = MemSessionProxy.getInstance();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, expiraMinutes);
		proxy.set(key, value, c.getTime());
	}

	public static void put(HttpServletRequest request,
			HttpServletResponse response, String key, Object value) {
		if (key == null || value == null) {
			return;
		}
		Cookie[] cookies = request.getCookies();
		String cookieValue = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (SessionCache.COOKIE_NAME.equals(cookies[i].getName())) {
					cookieValue = cookies[i].getValue(); // 取得cacheSession的值
					break;
				}
			}
		}

		if (cookieValue == null) {
			cookieValue = RandomNumUtil.getUUIDString();
			Cookie cookie = new Cookie(SessionCache.COOKIE_NAME, cookieValue);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		key += cookieValue;

		put(key, value);
	}

	public static void put(HttpServletRequest request,
			HttpServletResponse response, String key, Object value,
			int expiraMinutes) {
		if (key == null || value == null) {
			return;
		}
		Cookie[] cookies = request.getCookies();
		String cookieValue = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (SessionCache.COOKIE_NAME.equals(cookies[i].getName())) {
					cookieValue = cookies[i].getValue();
					break;
				}
			}
		}

		if (cookieValue == null) {
			cookieValue = RandomNumUtil.getUUIDString();
			Cookie cookie = new Cookie(SessionCache.COOKIE_NAME, cookieValue);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		key += cookieValue;

		MemCachedClient proxy = MemSessionProxy.getInstance();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, expiraMinutes);
		proxy.set(key, value, c.getTime());
	}

	public static Object get(String key) {
		MemCachedClient proxy = MemSessionProxy.getInstance();
		Object o = proxy.get(key);
		if (o != null) { // 防止会话过期,自动更新过期时间
			put(key, o);
		}
		return o;
	}

	public static Object getWithoutReset(String key) {
		MemCachedClient proxy = MemSessionProxy.getInstance();
		Object o = proxy.get(key);
		return o;
	}

	public static Object get(String key, int expirateTime) {
		MemCachedClient proxy = MemSessionProxy.getInstance();
		Object o = proxy.get(key);
		if (o != null) { // 防止会话过期,自动更新过期时间
			put(key, o, expirateTime);
		}
		return o;
	}

	public static Object get(HttpServletRequest request,
			HttpServletResponse response, String key) {
		Cookie[] cookies = request.getCookies();
		String cookieValue = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (SessionCache.COOKIE_NAME.equals(cookies[i].getName())) {
					cookieValue = cookies[i].getValue();
					break;
				}
			}
		}

		if (cookieValue == null) {
			log.warn("Cookie name cacheSession not found!");
			return null;
		} else {
			key += cookieValue;
		}
		return get(key);
	}

	public static void remove(String key) {
		MemCachedClient proxy = MemSessionProxy.getInstance();
		proxy.delete(key);
	}

	public static void remove(HttpServletRequest request,
			HttpServletResponse response, String key) {
		Cookie[] cookies = request.getCookies();
		String cookieValue = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (SessionCache.COOKIE_NAME.equals(cookies[i].getName())) {
					cookieValue = cookies[i].getValue();
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
					break;
				}
			}
		}

		if (cookieValue == null) {
			log.warn("Cookie name cacheSession not found!");
		} else {
			key += cookieValue;
		}

		MemCachedClient proxy = MemSessionProxy.getInstance();
		proxy.delete(key);
	}
}
