package com.itcrazy.alanmall.common.redis.redissonConfig;

import lombok.Data;

/**
 * @author mathyoung
 * @Description
 * @ClassName RedissonPoolProperties
 * @date 2020/7/8 20:42
 */
@Data
public class RedissonPoolProperties {
    // 连接池最小空闲连接
    private int minIdel;

    // 连接池最大空闲连接
    private int maxIdel;

    // 连接池最大连接数
    private int maxActive;

    // 最大阻塞等待时间
    private int maxWait;
}
