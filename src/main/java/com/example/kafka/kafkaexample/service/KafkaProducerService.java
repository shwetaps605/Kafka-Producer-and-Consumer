package com.example.kafka.kafkaexample.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private String TOPIC = "nntopic";

    public void sendPayload(@Payload String jsonObject){
        log.info("Sending payload to topic {}...",TOPIC);
        kafkaTemplate.send(TOPIC,jsonObject);
        log.info("Payload sent");
    }

}
