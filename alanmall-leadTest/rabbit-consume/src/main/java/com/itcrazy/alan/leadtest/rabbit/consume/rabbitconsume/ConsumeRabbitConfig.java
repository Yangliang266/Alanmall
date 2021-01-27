package com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;

@Configuration
@PropertySource("classpath:rabbitmq.properties")
public class ConsumeRabbitConfig {

    @Value("${rabbit.exchange.test}")
    private String exchange;

    @Value("${rabbit.queue.dirct.test}")
    private String queue;

    @Value("${rabbit.bindingKey}")
    private String bindingKey;

    @Bean("testExchange")
    public DirectExchange directExchange() {
        return new DirectExchange(exchange);
    }

    @Bean("directQueue")
    public Queue queue() {
        return new Queue(queue);
    }

    @Bean
    public Binding binding(@Qualifier("directQueue") Queue queue, @Qualifier("testExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(bindingKey);
    }


    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(final ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        factory.setAutoStartup(true);
        return factory;
    }
}
