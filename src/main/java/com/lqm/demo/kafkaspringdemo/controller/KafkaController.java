package com.lqm.demo.kafkaspringdemo.controller;

import com.lqm.demo.kafkaspringdemo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private KafkaTemplate<String, User> template;

    @Autowired
    public KafkaController(KafkaTemplate<String, User> template) {
        this.template = template;
    }

    @PutMapping("/send")
    public String sendMessage() {
        User user = new User();
        user.setAge(18);
        user.setName("lqm");
        template.send("topic", user);
        return "success";
    }
}
