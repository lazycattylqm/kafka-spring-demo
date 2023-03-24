package com.lqm.demo.kafkaspringdemo;

import com.lqm.demo.kafkaspringdemo.config.ConsumerConfigTest;
import com.lqm.demo.kafkaspringdemo.config.ProducerConfigTest;
import com.lqm.demo.kafkaspringdemo.listener.MyKafkaListener;
import com.lqm.demo.kafkaspringdemo.producer.KafkaProducer;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = {ConsumerConfigTest.class,MyKafkaListener.class, KafkaProducer.class, ProducerConfigTest.class})
@DirtiesContext
@EmbeddedKafka(partitions = 1, topics = "topic", brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
public class EmbeddedKafkaIntegrationTest {
    @Autowired
    private MyKafkaListener consumer;

    @Autowired
    private KafkaProducer producer;


    @Test
    public void givenKafkaDockerContainer_whenSendingWithSimpleProducer_thenMessageReceived()
            throws Exception {
        String data = "Sending with our own simple KafkaProducer";

        producer.sendMessage();

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();
//        boolean messageConsumed = consumer.getLatch().await(10, TimeUnit.SECONDS);

//        assertTrue(messageConsumed);

    }
    @AfterEach
    public void afterClass(@Autowired EmbeddedKafkaBroker embeddedKafkaBroker) {
        embeddedKafkaBroker.destroy();
    }
}
