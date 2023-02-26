package com.example.springbootkafkatutorial.kafka;

import com.example.springbootkafkatutorial.config.KafkaTopicConfig;
import com.example.springbootkafkatutorial.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JSONKafkaProducer {
    private KafkaTemplate<String, User> kafkaTemplate;

    public JSONKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data) {
        log.info("Sending Message: " + data.toString());

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, KafkaTopicConfig.JSON_TOPIC_NAME)
                .build();
        kafkaTemplate.send(message);
    }
}
