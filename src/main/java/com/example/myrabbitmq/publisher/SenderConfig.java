package com.example.myrabbitmq.publisher;

import com.example.myrabbitmq.configuration.RabbitMqProperties;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    @Autowired
    private RabbitMqProperties properties;

    @Bean
    public Queue queue() {
        return new Queue(properties.getQueue(), true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(properties.getExchange());
    }

    @Bean
    public Binding testeBinding(Queue queue, DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with(properties.getRoutingKey());
    }
}
