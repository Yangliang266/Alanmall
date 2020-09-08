package com.itcrazy.alanmall.common.cache.anno;


import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

public class CacheManagerAnno extends AbstractCacheManager {
	private Collection<? extends RedisCacheAnno> caches;

	
	public void setCaches(Collection<? extends RedisCacheAnno> caches) {
		this.caches = caches;
	}

	@Override
	protected Collection<? extends RedisCacheAnno> loadCaches() {
		return this.caches;
	}

}