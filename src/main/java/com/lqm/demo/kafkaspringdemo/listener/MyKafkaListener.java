package com.lqm.demo.kafkaspringdemo.listener;

import com.lqm.demo.kafkaspringdemo.bean.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaListener {

    @KafkaListener(topics = "topic", containerFactory = "kafkaListenerContainerFactory")
    public void listen(User message, Acknowledgment ack) {
        System.out.println("Received: " + message);
        ack.acknowledge();
    }
}
