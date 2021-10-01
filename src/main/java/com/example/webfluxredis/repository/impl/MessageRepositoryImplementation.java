package com.example.webfluxredis.repository.impl;

import com.example.webfluxredis.entity.Message;
import com.example.webfluxredis.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MessageRepositoryImplementation implements MessageRepository {
    private final ReactiveRedisTemplate<String, Message> redisOperations;

    @Override
    public Flux<Message> getGreetings(List<String> keys) {
        return redisOperations.opsForValue()
                .multiGet(keys)
                .flatMapMany(Flux::fromIterable);
    }

    @Override
    public Mono<Message> save(Message message) {
        System.out.println(redisOperations);
        return redisOperations.opsForValue()
                .set(message.getId(), message)
                .map(msg -> message);

    }

    @Override
    public Mono<Message> findByKey(String key) {
        return redisOperations.opsForValue()
                .get(key);
    }
}
