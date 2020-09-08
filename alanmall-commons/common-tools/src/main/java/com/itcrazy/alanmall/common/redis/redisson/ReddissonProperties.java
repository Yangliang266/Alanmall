package com.itcrazy.alanmall.common.redis.redisson;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.util.Date;

/**
 * @author mathyoung
 * @Description
 * @ClassName ReddissonProperties
 * @date 2020/7/8 20:37
 */
@Data
@ConfigurationProperties(prefix = "spring.redisson",ignoreUnknownFields = false)
public class ReddissonProperties {
    private String address;

    private String password;

    private int timeout;

    private int dataBase;

    private RedissonPoolProperties pool;
}
