package com.example.springbootkafkatutorial.kafka;

import com.example.springbootkafkatutorial.config.KafkaTopicConfig;
import com.example.springbootkafkatutorial.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JSONKafkaConsumer {
    @KafkaListener(topics = KafkaTopicConfig.JSON_TOPIC_NAME, groupId = "myGroup")
    public void consumer(User user) {
        log.info("JSON message received: " + user.toString());
    }
}
