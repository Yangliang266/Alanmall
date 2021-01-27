package com.itcrazy.alanmall.test.controller.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:rabbitmq.properties")
public class RabbitConfig {
    @Value("${rabbit.exchange.test}")
    private String exchange;

    @Value("${rabbit.queue.dirct.test}")
    private String queue;

    @Value("${rabbit.bindingKey}")
    private String bindingKey;

    @Bean("dirctExchange")
    public DirectExchange directExchange() {
        return new DirectExchange(exchange);
    }

    @Bean("dirctQueue")
    public Queue queue() {
        return new Queue(queue);
    }

//    @Bean
//    public Binding binding(@Qualifier("directQueue") Queue queue, @Qualifier("directExchange") DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
//    }

//    @Bean
//    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setMessageConverter(new Jackson2JsonMessageConverter());
//        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        factory.setAutoStartup(true);
//        return factory;
//    }


//    @Bean("dirctExchange")
//    public TopicExchange getDirctExchange(){
//        return new TopicExchange("DIRCT_EXCHANGE");
//    }


//    @Bean("dirctQueue")
//    public Queue getDirctQueue(){
//        return new Queue("DIRCT_QUEUE");
//    }

    // 两个绑定
    @Bean
    public Binding bindSecond(@Qualifier("dirctQueue") Queue queue,@Qualifier("dirctExchange") DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(bindingKey);
    }
}
