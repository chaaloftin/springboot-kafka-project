package com.example.springbootkafkatutorial.kafka;

import com.example.springbootkafkatutorial.config.KafkaTopicConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(final String message) {
        LOGGER.info("Sending message : " +  message);
        kafkaTemplate.send(KafkaTopicConfig.TOPIC_NAME, message);
    }
}
