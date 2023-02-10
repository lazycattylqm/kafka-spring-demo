package com.lqm.demo.kafkaspringdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private KafkaTemplate<String, String> template;

    @Autowired
    public KafkaController(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @PutMapping("/send")
    public String sendMessage() {
        template.send("topic", "Hello, Kafka!");
        return "success";
    }
}
