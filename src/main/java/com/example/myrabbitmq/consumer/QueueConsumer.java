package com.example.myrabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class QueueConsumer {

    @RabbitListener(queues = {"${queue.teste}"})
    public void receive(@Payload String fileBody) {
        System.out.println(MessageFormat.format("Message: {0}", fileBody));
    }
}
