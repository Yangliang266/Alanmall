package com.itcrazy.alanmall.leadtest.simpletest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: mathyoung
 * @description:
 */
public class CacheFactory {
    public  static Map<String, CacheTest> pool = new ConcurrentHashMap<>();

    public static  CacheTest cacheTest1 = new CacheTest();

    public static CacheTest getCache(String str) {
        synchronized (CacheFactory.class) {
            CacheTest cacheTest = null;

            if (pool.containsKey(str)) {
                System.out.println("使用缓存:" + str + "->" + pool.get(str));
                cacheTest1 = pool.get(str);
                return pool.get(str);
            }
            cacheTest = new CacheTest();
            System.out.println("创建缓存:" + str + "->" + pool.get(str));
            pool.put(str, cacheTest);
            cacheTest1 = cacheTest;
            return cacheTest;
        }
    }
}
