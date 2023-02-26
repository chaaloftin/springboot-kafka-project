package com.example.springbootkafkatutorial.controller;

import com.example.springbootkafkatutorial.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {
    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // http:localhost:8080/api/v1/kafka/publish?message=my first message
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") final String message) {
        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok("Message successfully published to a Kafka Topic");
    }
}
