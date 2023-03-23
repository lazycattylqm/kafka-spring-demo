package com.lqm.demo.kafkaspringdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
@Profile({"test"})
public class ProducerConfigTest {
    private Map<String, Object> producerConfigs() {
        return Map.of(
                "bootstrap.servers", "localhost:9092",
                "key.serializer", "org.apache.kafka.common.serialization.StringSerializer",
                "value.serializer", "org.springframework.kafka.support.serializer.JsonSerializer"
        );
        /*return new HashMap<String,Object>(){
            {
                put("bootstrap.servers", "localhost:9092");
                put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
                put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            }
        };*/
    }

    private  <T> ProducerFactory<String, T> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public <T> KafkaTemplate<String, T> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
