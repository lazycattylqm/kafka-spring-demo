package com.lqm.demo.kafkaspringdemo.temp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
public class KafkaSpringDemoApplicationTests {

//    @MockBean
//    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory;
//
//    @MockBean
//    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${test.value}")
    private String value;

    @Test
    void contextLoads() {
        System.out.println(value);
    }

}
