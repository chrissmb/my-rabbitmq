package com.example.myrabbitmq.consumer;

import com.example.myrabbitmq.configuration.RabbitMqProperties;
import com.example.myrabbitmq.schema.Person;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class QueueConsumer {

    @RabbitListener(queues = {RabbitMqProperties.Q_MESSAGE})
    public void receiveMessage(@Payload String fileBody) {
        printMessage(RabbitMqProperties.Q_MESSAGE, fileBody);
    }

    @RabbitListener(queues = {RabbitMqProperties.Q_CREATE_PERSON})
    public void receiveCreatePerson(@Payload Person fileBody) {
        printMessage(RabbitMqProperties.Q_CREATE_PERSON, fileBody.toString());
    }

    @RabbitListener(queues = {RabbitMqProperties.Q_UPDATE_PERSON})
    public void receiveUpdatePerson(@Payload Person fileBody) {
        printMessage(RabbitMqProperties.Q_UPDATE_PERSON, fileBody.toString());
    }

    private void printMessage(String queue, String message) {
        System.out.println(MessageFormat.format("Message {0}: {1}", queue, message));
    }

}
