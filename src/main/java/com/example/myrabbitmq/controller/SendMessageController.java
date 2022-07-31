package com.example.myrabbitmq.controller;

import com.example.myrabbitmq.publisher.QueueSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("send")
public class SendMessageController {

    @Autowired
    private QueueSenderService queueSenderService;

    @PostMapping()
    public void sendMessage(@RequestBody String message) {
        queueSenderService.send(message);
    }

    @PostMapping("exchange")
    public void sendMessageExchange(@RequestBody String message) {
        queueSenderService.sendWithExchange(message);
    }
}
