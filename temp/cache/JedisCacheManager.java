//package com.itcrazy.alanmall.user.service.cache;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisCluster;
//import redis.clients.jedis.JedisPool;
//
///**
// * @author mathyoung
// * @Description
// * @ClassName JedisCacheManager
// * @date 2020/7/14 14:15
// */
//@Component
//public class JedisCacheManager {
//
//    @Autowired
////    JedisCluster jedisCluster;
//    StringRedisTemplate stringRedisTemplate;
//
//    public void setString(String key, String value) {
////        jedisCluster.set(key, value);
//        stringRedisTemplate.opsForValue().set(key,value);
//    }
//}
