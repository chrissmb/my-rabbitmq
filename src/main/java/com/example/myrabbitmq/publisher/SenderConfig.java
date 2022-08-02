package com.example.myrabbitmq.publisher;

import com.example.myrabbitmq.configuration.RabbitMqProperties;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {
    
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(RabbitMqProperties.DIRECT_EXCHANGE);
    }

    @Bean
    public Queue queueCreatePerson() {
        return new Queue(RabbitMqProperties.Q_CREATE_PERSON, true);
    }

    @Bean
    public Queue queueUpdatePerson() {
        return new Queue(RabbitMqProperties.Q_UPDATE_PERSON, true);
    }

    @Bean
    public Queue queueMessage() {
        return new Queue(RabbitMqProperties.Q_MESSAGE, true);
    }

    @Bean
    public Binding bindingCreatePerson(Queue queueCreatePerson, DirectExchange directExchange) {
        return BindingBuilder
                .bind(queueCreatePerson)
                .to(directExchange)
                .with(RabbitMqProperties.RK_CREATE_PERSON);
    }

    @Bean
    public Binding bindingUpdatePerson(Queue queueUpdatePerson, DirectExchange directExchange) {
        return BindingBuilder
                .bind(queueUpdatePerson)
                .to(directExchange)
                .with(RabbitMqProperties.RK_UPDATE_PERSON);
    }

    @Bean
    public Binding bindingMessage(Queue queueMessage, DirectExchange directExchange) {
        return BindingBuilder
                .bind(queueMessage)
                .to(directExchange)
                .with(RabbitMqProperties.RK_MESSAGE);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
