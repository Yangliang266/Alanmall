package com.itcrazy.alanmall.common.redis.redissonConfig;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * @author mathyoung
 * @Description
 * @ClassName RedissonAutoConfigration
 * @date 2020/7/8 20:36
 */
@Configuration
@EnableConfigurationProperties({ReddissonProperties.class})
@ConditionalOnClass({Redisson.class})
public class RedissonAutoConfigration {
    @Autowired
    ReddissonProperties reddissonProperties;

    @Bean
//    @Primary
//    @ConditionalOnClass({Redisson.class})
    public RedissonClient redissonClient() {
        Config config = new Config();
        String node = reddissonProperties.getAddress();
        String[] strNode = node.split(",");

        if (strNode.length > 1) {
            // redisson集群设置
            config.useClusterServers().setScanInterval(2000);
            for(int i = 0; i < strNode.length; i++) {
                strNode[i] = strNode[i].startsWith("redis://") ? strNode[i] : "redis://" + strNode[i];
                config.useClusterServers().addNodeAddress(strNode[i]);
            }
        } else {
            // redisson单机设置
            node = node.startsWith("redis://") ? node : "redis://" + node;
            SingleServerConfig singleServerConfig = config.useSingleServer()
                    .setAddress(node)
//                .setConnectionMinimumIdleSize(reddissonProperties.getPool().getMinIdel())
                    .setTimeout(reddissonProperties.getTimeout());

            if (StringUtils.isNotBlank(reddissonProperties.getPassword())) {
                singleServerConfig.setPassword(reddissonProperties.getPassword());
            }

        }
        return Redisson.create(config);
    }

//    @Autowired
//    ReddissonProperties redissonProperties;
//
//    @Bean
//    RedissonClient redissonClient() {
//        Config config = new Config();
//        String node = redissonProperties.getAddress();
//        node = node.startsWith("redis://") ? node : "redis://" + node;
//        SingleServerConfig serverConfig = config.useSingleServer()
//                .setAddress(node)
//                .setTimeout(redissonProperties.getTimeout());
////                .setConnectionMinimumIdleSize(redissonProperties.getPool().getMinIdle());
//        if (StringUtils.isNotBlank(redissonProperties.getPassword())) {
//            serverConfig.setPassword(redissonProperties.getPassword());
//        }
//        return Redisson.create(config);
//    }


}
