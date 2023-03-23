package com.lqm.demo.kafkaspringdemo.listener;

import com.lqm.demo.kafkaspringdemo.bean.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class MyKafkaListener {

//    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "topic", containerFactory = "kafkaListenerContainerFactory")
    public void listen(User message, Acknowledgment ack) {
        System.out.println("Received: " + message);
        ack.acknowledge();
//        latch.countDown();
    }

//    public CountDownLatch getLatch() {
//        return latch;
//    }

    public void resetLatch() {
//        latch = new CountDownLatch(1);
    }
}
