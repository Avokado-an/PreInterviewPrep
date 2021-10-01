package com.example.webfluxredis.controller;

import com.example.webfluxredis.entity.Message;
import com.example.webfluxredis.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/hello")
    public Flux<Message> greet(List<String> keys) {
        return messageService.sendGreetings(keys);
    }
}
