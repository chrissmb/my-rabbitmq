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
    private Queue queueCreatePerson;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message) {
        rabbitTemplate.convertAndSend(queueCreatePerson.getName(), message);
    }

    public void sendWithExchange(String message) {
        amqpTemplate.convertAndSend(RabbitMqProperties.DX_PERSON, RabbitMqProperties.RK_UPDATE_PERSON, message);
    }
}
