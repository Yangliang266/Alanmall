package com.itcrazy.alanmall.common.cache.anno;


import com.itcrazy.alanmall.common.cache.jedis.RedisCacheConfig;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.concurrent.Callable;


/**
 * 注解
 * @author dell
 *
 */
public class RedisCacheAnno implements Cache {

   private String name;

   public static int DEFAULT_EXPIRATE_MINUTES = 30;
   public RedisCacheAnno() {

   }

   public RedisCacheAnno(String name) {
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
       RedisCacheConfig.remove(String.valueOf(o));
   }

   @Override
   public ValueWrapper get(Object key) {
       if (key == null) {
           return null;
       }
       ValueWrapper result = null;

       Object o = RedisCacheConfig.get(String.valueOf(key));
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

       RedisCacheConfig.set(String.valueOf(key), o,DEFAULT_EXPIRATE_MINUTES*60);
   }

   public void setName(String name) {
       this.name = name;
   }

   @Override
   public <T> T get(Object key, Class<T> type) {
       // TODO Auto-generated method stub
       return null;
   }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }

    @Override
   public ValueWrapper putIfAbsent(Object key, Object value) {
       // TODO Auto-generated method stub
       return null;
   }

}
