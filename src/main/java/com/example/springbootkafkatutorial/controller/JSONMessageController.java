package com.example.springbootkafkatutorial.controller;

import com.example.springbootkafkatutorial.kafka.JSONKafkaProducer;
import com.example.springbootkafkatutorial.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class JSONMessageController {
    private JSONKafkaProducer JSONKafkaProducer;

    public JSONMessageController(JSONKafkaProducer JSONKafkaProducer) {
        this.JSONKafkaProducer = JSONKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        JSONKafkaProducer.sendMessage(user);

        return ResponseEntity.ok("JSON message sent to Kafka Topic");
    }
}
