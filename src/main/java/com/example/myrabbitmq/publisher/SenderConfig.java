package com.example.myrabbitmq.publisher;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.myrabbitmq.configuration.RabbitMqProperties;

@Configuration
public class SenderConfig {
    
    @Bean
    public DirectExchange directExchangePerson() {
        return new DirectExchange(RabbitMqProperties.DX_PERSON);
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
    public Binding bindingCreatePerson(Queue queueCreatePerson, DirectExchange directExchangePerson) {
        return BindingBuilder
                .bind(queueCreatePerson)
                .to(directExchangePerson)
                .with(RabbitMqProperties.RK_CREATE_PERSON);
    }

    @Bean
    public Binding bindingUpdatePerson(Queue queueUpdatePerson, DirectExchange directExchangePerson) {
        return BindingBuilder
                .bind(queueUpdatePerson)
                .to(directExchangePerson)
                .with(RabbitMqProperties.RK_UPDATE_PERSON);
    }
}
