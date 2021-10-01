package com.example.webfluxredis.repository;

import com.example.webfluxredis.entity.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MessageRepository {
    Flux<Message> getGreetings(List<String> ids);

    Mono<Message> save(Message message);

    Mono<Message> findByKey(String key);
}
