package com.itcrazy.alanmall.leadtest.simpletest;

import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import org.redisson.api.RCountDownLatch;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: mathyoung
 * @description:
 */
public class ThreadTest extends Thread {
    @Autowired
    RedissonConfig redissonConfig;

    @Override
    public void run() {
        RCountDownLatch rCountDownLatch = redissonConfig.getMqLock("thread",1);
        try {
            CacheTest cacheTest = CacheFactory.cacheTest1;
            cacheTest.setAddress("2222222");
            cacheTest.setName("3333333");
            System.out.println("thread is runing");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rCountDownLatch.countDown();
        }

    }
}
