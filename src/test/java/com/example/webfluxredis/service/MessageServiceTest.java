package com.example.webfluxredis.service;

import com.example.webfluxredis.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @Test
    public void testSendGreetings() {
        StepVerifier.create(messageService.sendGreetings(Arrays.asList("1", "2", "3")))
                .expectNext(
                        new Message("Hello world!"),
                        new Message("Hi"),
                        new Message("Anybody here???")
                )
                .verifyComplete();
    }
}
