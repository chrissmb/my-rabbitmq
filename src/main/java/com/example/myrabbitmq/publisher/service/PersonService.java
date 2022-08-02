package com.example.myrabbitmq.publisher.service;

import com.example.myrabbitmq.configuration.RabbitMqProperties;
import com.example.myrabbitmq.schema.Person;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void createPerson(Person person) {
        rabbitTemplate.convertAndSend(RabbitMqProperties.DIRECT_EXCHANGE, RabbitMqProperties.RK_CREATE_PERSON, person);
    }

    public void updatePerson(Person person) {
        rabbitTemplate.convertAndSend(RabbitMqProperties.DIRECT_EXCHANGE, RabbitMqProperties.RK_UPDATE_PERSON, person);
    }
}
