package com.example.myrabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class MyRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRabbitmqApplication.class, args);
	}

}
