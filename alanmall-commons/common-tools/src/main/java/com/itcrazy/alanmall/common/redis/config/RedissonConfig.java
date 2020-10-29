package com.itcrazy.alanmall.common.redis.config;

import lombok.Data;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class RedissonConfig {

    //private static RedissonClient redissonClient = null;
    @Autowired
    RedissonClient redissonClient;

    /**
     * @Description 检查是否存在缓存
     * @Param key
     * @return str
     * @Author Mathyoung
     * @Date 2020.07.09 20:14
     **/
    public String checkCache(String key) {
        try {
            RBucket rBucket = redissonClient.getBucket(key);
            String string = rBucket.get().toString();
            return rBucket.get().toString();
        }catch (Exception e){
            return null;
        }
    }

    /**
     * @Description 设置到cache
     * @Param key val expire
     * @return
     * @Author Mathyoung
     * @Date 2020.07.09 20:17
     **/
    public void setCache(String key, String val, int expire) {
        RBucket rBucket = redissonClient.getBucket(key);

        rBucket.set(val);

        rBucket.expire(expire, TimeUnit.SECONDS);
    }


    public String getCache(String key) {
        RBucket rBucket = redissonClient.getBucket(key);
        return rBucket.get().toString();
    }

    /**
     * @Description 设置缓存超时时间
     * @Param key expire
     * @return
     * @Author Mathyoung
     * @Date 2020.07.09 20:19
     **/
    public void expireSeconds(String key, int expire) {
        RBucket rBucket = redissonClient.getBucket(key);
        rBucket.expire(expire, TimeUnit.SECONDS);
    }

    public void expireDay(String key, int expire) {
        RBucket rBucket = redissonClient.getBucket(key);
        rBucket.expire(expire, TimeUnit.DAYS);
    }

    /**
     * @Description 设置hash set
     * @Param String key, Object field, Object value, int expire
     * @return
     * @Author Mathyoung
     * @Date 2020.07.14 10:07
     **/
    public void setMapCacheSeconds(String key, String field, String value, int expire) {
        RMap<String, String> map = redissonClient.getMap(key);
        map.put(field, value);
        map.expire(expire, TimeUnit.SECONDS);
    }

    public void setMapCacheDays(String key, String field, String value, int expire) {
        RMap<String, String> map = redissonClient.getMap(key);
        map.put(field, value);
        map.expire(expire, TimeUnit.DAYS);
    }

    public boolean checkMapCache(String key, String field) {
        Map<String, String> map = redissonClient.getMap(key);
        return map.containsKey(field);
    }

    public void removeMapCache(String key, String field) {
        Map<String, String> map = redissonClient.getMap(key);
        map.remove(field);
    }

    public Map getMap(String key) {
        Map<String, String> map = redissonClient.getMap(key);
        return map;
    }

    /**
     * @Description
     * @Param String key, String field, String value
     * @return
     * @Author Mathyoung
     * @Date 2020.07.14 12:37
     **/
    public boolean checkMapHashCache(String key, String field, String value) {
        RMap<String, String> map = redissonClient.getMap(key);
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry.getKey());
            if (stringStringEntry.getKey().equals(field)) {
                if (stringStringEntry.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }
}
