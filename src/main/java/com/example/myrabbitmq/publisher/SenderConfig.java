package com.example.myrabbitmq.publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfig {

    @Value("${queue.teste}")
    private String queueTeste;

    @Bean
    public Queue queue() {
        return new Queue(queueTeste, true);
    }
}
