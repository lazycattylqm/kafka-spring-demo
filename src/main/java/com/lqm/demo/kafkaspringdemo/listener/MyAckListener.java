package com.lqm.demo.kafkaspringdemo.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

//@Component
public class MyAckListener implements AcknowledgingMessageListener<String, String> {
    @Override
    public void onMessage(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
        System.out.println("MyAckListener Received: " + consumerRecord.value());
        acknowledgment.acknowledge();
    }
}
