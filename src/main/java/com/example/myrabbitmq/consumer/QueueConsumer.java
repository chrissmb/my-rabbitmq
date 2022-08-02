package com.example.myrabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.myrabbitmq.configuration.RabbitMqProperties;

import java.text.MessageFormat;

@Component
public class QueueConsumer {

    @RabbitListener(queues = {RabbitMqProperties.Q_CREATE_PERSON})
    public void receiveCreatePerson(@Payload String fileBody) {
        printMessage(RabbitMqProperties.Q_CREATE_PERSON, fileBody);
    }

    @RabbitListener(queues = {RabbitMqProperties.Q_UPDATE_PERSON})
    public void receiveUpdatePerson(@Payload String fileBody) {
        printMessage(RabbitMqProperties.Q_UPDATE_PERSON, fileBody);
    }

    private void printMessage(String queue, String message) {
        System.out.println(MessageFormat.format("Message {0}: {1}", queue, message));
    }

}
