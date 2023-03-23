package com.lqm.demo.kafkaspringdemo.producer;

import com.lqm.demo.kafkaspringdemo.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, User> template;

    public KafkaProducer(KafkaTemplate<String, User> template) {
        this.template = template;
    }

    public void sendMessage() {
        User user = new User();
        user.setAge(18);
        user.setName("lqm");
        template.send("topic", user);
    }
}
