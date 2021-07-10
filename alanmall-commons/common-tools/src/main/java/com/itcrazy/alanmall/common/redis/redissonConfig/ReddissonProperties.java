package com.itcrazy.alanmall.common.redis.redissonConfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mathyoung
 * @Description
 * @ClassName ReddissonProperties
 * @date 2020/7/8 20:37
 */
@Data
@ConfigurationProperties(prefix = "spring.redis",ignoreUnknownFields = false)
public class ReddissonProperties {
    private String host;

    private String password;

    private int timeout;

    private int dataBase;

    private RedissonPoolProperties pool;
}
