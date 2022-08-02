package com.example.myrabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myrabbitmq.publisher.service.SendMessageService;

@RestController
@RequestMapping("send")
public class SendMessageController {

    @Autowired
    private SendMessageService sendMessageService;

    @PostMapping()
    public void sendMessage(@RequestBody String message) {
        sendMessageService.send(message);
    }

    @PostMapping("exchange")
    public void sendMessageExchange(@RequestBody String message) {
        sendMessageService.sendWithExchange(message);
    }
}
