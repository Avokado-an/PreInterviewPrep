package com.example.webfluxredis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data(staticConstructor = "text")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("Message")
public class Message implements Serializable {
    private String id;
    private String text;

    public Message(String text) {
        this.text = text;
    }
}
