package com.example.myrabbitmq.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("rmq-properties")
@Data
public class RabbitMqProperties {

    private String queue;

    private String exchange;

    private String routingKey;
}
