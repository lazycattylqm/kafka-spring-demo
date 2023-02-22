package com.lqm.demo.kafkaspringdemo.listener;

import com.lqm.demo.kafkaspringdemo.bean.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AnotherListener implements AcknowledgingMessageListener<String, User> {
    @Override public void onMessage(ConsumerRecord<String, User> consumerRecord, Acknowledgment acknowledgment) {
        System.out.println("Received: " + consumerRecord.value());
        Optional.ofNullable(acknowledgment).ifPresent(Acknowledgment::acknowledge);
    }
}
