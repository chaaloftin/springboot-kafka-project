package com.example.springbootkafkatutorial.kafka;

import com.example.springbootkafkatutorial.config.KafkaTopicConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = KafkaTopicConfig.TOPIC_NAME, groupId = "myGroup")
    public void consumer(final String message) {
        LOGGER.info("messaged received: " + message);
    }
}
