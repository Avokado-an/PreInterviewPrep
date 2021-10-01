package com.example.webfluxredis.service;

import com.example.webfluxredis.entity.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MessageService {
    Flux<Message> sendGreetings(List<String> keys);

    Mono<Message> save(Message message);

    Mono<Message> findByKey(String key);
}
