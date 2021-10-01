package com.example.webfluxredis.service.impl;

import com.example.webfluxredis.entity.Message;
import com.example.webfluxredis.repository.MessageRepository;
import com.example.webfluxredis.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MessageServiceImplementation implements MessageService {
    private final MessageRepository messageRepository;

    @Override
    public Flux<Message> sendGreetings(List<String> keys) {
        return messageRepository.getGreetings(keys);
    }

    @Override
    public Mono<Message> save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Mono<Message> findByKey(String key) {
        return messageRepository.findByKey(key);
    }
}
