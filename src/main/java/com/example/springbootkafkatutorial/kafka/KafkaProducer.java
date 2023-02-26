package com.example.springbootkafkatutorial.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.kafka.topic.string.name}")
    private String topicName;
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(final String message) {
        log.info("Sending message : " +  message);
        kafkaTemplate.send(topicName, message);
    }
}
