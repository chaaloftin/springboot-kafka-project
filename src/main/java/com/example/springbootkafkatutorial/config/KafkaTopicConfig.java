package com.example.springbootkafkatutorial.config;

import lombok.Getter;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    public static final String TOPIC_NAME = "test-topic";
    @Bean
    public NewTopic myNewTopic()  {
        return TopicBuilder
                .name(TOPIC_NAME)
                .build();
    }
}
