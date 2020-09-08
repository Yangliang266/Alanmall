//package com.itcrazy.alanmall.common.redis.jedis;
//
//import org.apache.commons.lang3.StringUtils;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import redis.clients.jedis.*;
//
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
///**
// * @author mathyoung
// * @Description
// * @ClassName JedisAutoConfigration
// * @date 2020/7/14 13:30
// */
//@Configuration
//@EnableConfigurationProperties(JedisProperties.class)
//public class JedisAutoConfigration {
//    @Autowired
//    JedisProperties jedisProperties;
//
//    private Set<HostAndPort> set = new HashSet<HostAndPort>();
//
//    private JedisPool pool = null;
//
//    @Bean
//    @Primary
//    @ConditionalOnClass({Jedis.class})
//    public JedisCluster jedisCluster() {
////        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//
//        Map<String, String> map = jedisProperties.getRedisAddress();
//
//        if (map.size() > 0) {
//            for (Map.Entry<String, String> o : map.entrySet()) {
//                String str = o.getValue();
//                String[] strArrays = str.split(":");
//
//                HostAndPort hostAndPort = new HostAndPort(strArrays[0], Integer.parseInt(strArrays[1]));
//
//                set.add(hostAndPort);
//            }
//        }
//
//        return new JedisCluster(set);
//    }
//
////    @Bean
////    @ConditionalOnClass({Jedis.class})
////    public Jedis jedisClient() {
////        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
////
////        Map<String, String> map = jedisProperties.getRedisAddress();
////
////        if (map.size() == 1) {
////            for (Map.Entry<String, String> o : map.entrySet()) {
////                String str = o.getValue();
////                String[] strArrays = str.split(":");
////
////                if (StringUtils.isBlank(jedisProperties.getPassword())) {
////                    pool = new JedisPool(jedisPoolConfig, strArrays[0], Integer.parseInt(strArrays[1]), 10000);
////                } else if (StringUtils.isNotBlank(jedisProperties.getPassword())) {
////                    pool = new JedisPool(jedisPoolConfig, strArrays[0], Integer.parseInt(strArrays[1]), 10000, jedisProperties.getPassword());
////                } else {
////                    return null;
////                }
////            }
////        }
////
////        return pool.getResource();
////    }
//
//}
