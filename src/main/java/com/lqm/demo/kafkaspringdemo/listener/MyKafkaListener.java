package com.lqm.demo.kafkaspringdemo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaListener {

    @KafkaListener(topics = "topic", containerFactory = "kafkaListenerContainerFactory")
    public void listen(String message, Acknowledgment ack) {
        System.out.println("Received: " + message);
        ack.acknowledge();
    }
}
