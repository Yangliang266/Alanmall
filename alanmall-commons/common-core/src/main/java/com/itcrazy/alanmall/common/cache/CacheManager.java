package com.itcrazy.alanmall.common.cache;

import com.itcrazy.alanmall.common.cache.memcached.MemcacheCache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

public class CacheManager extends AbstractCacheManager {
	private Collection<? extends MemcacheCache> caches;

	public void setCaches(Collection<? extends MemcacheCache> caches) {
		this.caches = caches;
	}

	@Override
	protected Collection<? extends MemcacheCache> loadCaches() {
		return this.caches;
	}

}