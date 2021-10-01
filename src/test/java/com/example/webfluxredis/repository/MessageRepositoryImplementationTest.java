package com.example.webfluxredis.repository;

import com.example.webfluxredis.EmbeddedRedisConfiguration;
import com.example.webfluxredis.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmbeddedRedisConfiguration.class)
public class MessageRepositoryImplementationTest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testSave() {
        Message message = new Message("1", "test");
        StepVerifier.create(messageRepository.save(message))
                .expectNext(message)
                .verifyComplete();
    }

    @Test
    public void testGetByKey() {
        Message message = new Message("1", "test");
        StepVerifier.create(messageRepository.save(message)
                        .flatMap(msg -> messageRepository.findByKey(msg.getId())))
                .expectNext(message)
                .verifyComplete();
    }

    //@Test
    //public void testGetGreetings() {
    //    StepVerifier.create(messageRepository.getGreetings(Arrays.asList("1", "2", "3")))
    //            .expectNext(
    //                    new Message("1", "Hello world!"),
    //                    new Message("2", "Hi"),
    //                    new Message("3", "Anybody here???")
    //            )
    //            .verifyComplete();
    //}
}