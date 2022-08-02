package com.example.myrabbitmq.publisher.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myrabbitmq.configuration.RabbitMqProperties;

@Service
public class SendMessageService {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend(RabbitMqProperties.Q_MESSAGE, message);
    }

    public void sendWithExchange(String message) {
        rabbitTemplate.convertAndSend(RabbitMqProperties.DIRECT_EXCHANGE, RabbitMqProperties.RK_MESSAGE, message);
    }
}
