package com.example.springbootkafkatutorial.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "${spring.kafka.topic.string.name}", groupId = "${spring.kafka.group-id.name}")
    public void consumer(final String message) {
        log.info("messaged received: " + message);
    }
}
