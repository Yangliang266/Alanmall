package com.itcrazy.alanmall.order.utils;

import lombok.Data;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Auther: mathyoung
 * @description: Rabbit 配置类
 */
@Configuration
@Data
@PropertySource("classpath:base_mq.properties")
public class RabbitConfig {
    // 设置交换机
    @Value("${ORDER_EXCHANGE}")
    private String exchange;

    @Bean("exchange")
    public DirectExchange directExchange() {
        return new DirectExchange(exchange);
    }

    // 设置队列
    @Value("${CREATE_ORDER_VALIDATE_QUEUE}")
    private String validateQueue;

    @Value("${CREATE_ORDER_SUBSTOCK_QUEUE}")
    private String subStockQueue;

    @Value("${CREATE_ORDER_CLEAR_CARTITEM_QUEUE}")
    private String clearCartItemQueue;

    @Value("${CREATE_ORDER_INIT_ORDER_QUEUE}")
    private String initOrderQueue;

    @Value("${CREATE_ORDER_LOGISTICAL_QUEUE}")
    private String logisticalQueue;

    @Bean("validateQueue")
    public Queue validateQueue() {
        return new Queue(validateQueue);
    }

    @Bean("subStockQueue")
    public Queue subStockQueue() {
        return new Queue(subStockQueue);
    }

    @Bean("clearCartItemQueue")
    public Queue clearCartItemQueue() {
        return new Queue(clearCartItemQueue);
    }

    @Bean("initOrderQueue")
    public Queue initOrderQueue() {
        return new Queue(initOrderQueue);
    }

    @Bean("logisticalQueue")
    public Queue logisticalQueue() {
        return new Queue(logisticalQueue);
    }

    @Value("${ROUTING_KEY}")
    private String routingKey;

    // 绑定
    @Bean
    public Binding validatebinding(@Qualifier("exchange") DirectExchange exchange, @Qualifier("validateQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Bean
    public Binding subStockbinding(@Qualifier("exchange") DirectExchange exchange, @Qualifier("subStockQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Bean
    public Binding initOrderbinding(@Qualifier("exchange") DirectExchange exchange, @Qualifier("initOrderQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Bean
    public Binding clearCartItembinding(@Qualifier("exchange") DirectExchange exchange, @Qualifier("clearCartItemQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    @Bean
    public Binding logisticalbinding(@Qualifier("exchange") DirectExchange exchange, @Qualifier("logisticalQueue") Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

    // 设置rabbit template
    @Bean
    public RabbitTemplate template(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

    // 设置rabbit 监听
    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(final ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        factory.setAutoStartup(true);
        return factory;
    }
}
