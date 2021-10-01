package com.example.webfluxredis.controller;

import com.example.webfluxredis.entity.Message;
import com.example.webfluxredis.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(MessageController.class)
public class MessageControllerTest {
    @Autowired
    private WebTestClient testClient;

    @MockBean
    private MessageService messageService;

    @Test
    public void greet() {
        when(messageService.sendGreetings(Arrays.asList("1", "2", "3"))).thenReturn(
                Flux.fromStream(
                Stream.of("Hello world!", "Hi", "Anybody here???")
                        .map(Message::new)
        ));
        testClient.get()
                .uri("/hello")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody()
                .json("[" +
                        "  {\n" +
                        "    \"text\": \"Hello world!\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"text\": \"Hi\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"text\": \"Anybody here???\"\n" +
                        "  }\n" +
                        "]");
    }
}
