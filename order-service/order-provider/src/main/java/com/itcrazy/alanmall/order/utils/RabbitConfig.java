package com.itcrazy.alanmall.order.utils;

import lombok.Data;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: mathyoung
 * @description: Rabbit 配置类
 */
@Configuration
@Data
@PropertySource("classpath:base_mq.properties")
public class RabbitConfig {
    @Value("${ORDER_DELAY_EXCHANGE}")
    private String delayExchange;

    @Value("${CANCEL_ORDER_QUEUE}")
    private String cancelQueue;

    @Value("${ORDER_DELAY_BINDING_KEY}")
    private String delayBindingKey;

    @Bean("cancelQueue")
    public Queue cancelQueue() {
        return new Queue(cancelQueue);
    }

    @Bean("delayExchange")
    public DirectExchange delayExchange() {
        Map<String, Object> agrs = new HashMap<>();
        agrs.put("x-delayed-type","direct");
        DirectExchange topic = new DirectExchange(delayExchange,true,false, agrs);
        topic.setDelayed(true);
        return topic;
    }

    @Bean
    public Binding cancelOrderBinding(@Qualifier("delayExchange") DirectExchange exchange, @Qualifier("cancelQueue") Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with(delayBindingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    // 设置rabbit 监听
    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory,
                                                                                     SimpleRabbitListenerContainerFactoryConfigurer configurer) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setMessageConverter(jsonMessageConverter());
        return factory;
    }

}
