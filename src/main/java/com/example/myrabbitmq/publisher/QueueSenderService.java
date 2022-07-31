package com.example.myrabbitmq.publisher;

import com.example.myrabbitmq.configuration.RabbitMqProperties;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueSenderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RabbitMqProperties properties;

    public void send(String message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }

    public void sendWithExchange(String message) {
        amqpTemplate.convertAndSend(properties.getExchange(), properties.getRoutingKey(), message);
    }
}
