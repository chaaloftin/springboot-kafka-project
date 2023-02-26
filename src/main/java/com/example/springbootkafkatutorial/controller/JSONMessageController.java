package com.example.springbootkafkatutorial.controller;

import com.example.springbootkafkatutorial.kafka.KafkaJSONProducer;
import com.example.springbootkafkatutorial.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class JSONMessageController {
    private KafkaJSONProducer kafkaJSONProducer;

    public JSONMessageController(KafkaJSONProducer kafkaJSONProducer) {
        this.kafkaJSONProducer = kafkaJSONProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaJSONProducer.sendMessage(user);

        return ResponseEntity.ok("JSON message sent to Kafka Topic");
    }
}
