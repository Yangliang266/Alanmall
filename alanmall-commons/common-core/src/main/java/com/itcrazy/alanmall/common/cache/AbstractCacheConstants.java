package com.itcrazy.alanmall.common.cache;

import jdk.nashorn.internal.runtime.GlobalConstants;

/**
 * @Auther: mathyoung
 * @description:
 */
public abstract class AbstractCacheConstants {
    public static String generatorKey(long userId, String cacheKey){
        return cacheKey + ":" + userId;
    }
}
