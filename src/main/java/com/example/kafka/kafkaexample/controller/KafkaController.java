package com.example.kafka.kafkaexample.controller;

import com.example.kafka.kafkaexample.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/publish")
    public String publishJsonObject(@RequestBody String jsonObject){
        kafkaProducerService.sendPayload(jsonObject);
        return "JSON OBJECT SENT VIA CONTROLLER";
    }
}
