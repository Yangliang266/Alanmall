//package com.itcrazy.alanmall.common.mq.rabbitmq;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import org.springframework.amqp.core.Queue;
//import java.util.concurrent.DelayQueue;
//
//@Configuration
//@PropertySource("classpath:rabbitmq.properties")
//public class RabbitConfig {
//    // 声明
//    @Value("${delayexchange}")
//    private String delayExchange;
//
//    @Value("${directexchange}")
//    private String directexchange;
//
//    @Value("${topicexchange}")
//    private String topicExchange;
//
//    @Value("${fanoutexchange}")
//    private String fanoutExchange;
//
//    // 交换机
//    @Bean
//    public Queue delayQueue() {
//        return new Queue(delayExchange);
//    }
//
//    // 队列
//
//
//    // 绑定
//
//    // 模板设置（// 数据转换/mq节点的设置/）
//
//}
