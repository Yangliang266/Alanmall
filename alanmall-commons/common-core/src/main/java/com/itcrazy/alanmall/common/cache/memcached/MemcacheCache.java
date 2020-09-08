package com.itcrazy.alanmall.common.cache.memcached;

import com.whalin.MemCached.MemCachedClient;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.Calendar;
import java.util.concurrent.Callable;

/**
 * 基于memcache的方式实现缓存
 * 
 * @author wangyongqing
 * 
 */

public class MemcacheCache implements Cache {

	private String name;

	public static int DEFAULT_EXPIRATE_MINUTES = 60*25;

	public MemcacheCache() {

	}

	public MemcacheCache(String name) {
		this.name = name;
	}

	@Override
	public void clear() {

	}

	@Override
	public void evict(Object o) {
		if (o == null) {
			return;
		}
		MemCachedClient proxy = MemDataProxy.getInstance();
		proxy.delete(String.valueOf(o));
	}

	@Override
	public ValueWrapper get(Object key) {
		if (key == null) {
			return null;
		}
		ValueWrapper result = null;
		MemCachedClient proxy = MemDataProxy.getInstance();
		Object o = proxy.get(String.valueOf(key));
		if (o != null) {
			result = new SimpleValueWrapper(o);
		}
		return result;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Object getNativeCache() {
		return null;
	}

	@Override
	public void put(Object key, Object o) {
		if (o == null) {
			return;
		}
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, DEFAULT_EXPIRATE_MINUTES);
		MemCachedClient proxy = MemDataProxy.getInstance();
		proxy.set(String.valueOf(key), o, c.getTime());
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public <T> T get(Object arg0, Class<T> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T get(Object o, Callable<T> callable) {
		return null;
	}

	@Override
	public ValueWrapper putIfAbsent(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
