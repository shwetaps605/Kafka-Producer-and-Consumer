package com.example.kafka.kafkaexample.service;


import com.example.kafka.kafkaexample.dto.NotificationDto;
import com.example.kafka.kafkaexample.dto.ValuesDto;
import com.example.kafka.kafkaexample.processor.NotificationProcessor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Slf4j
@Service
public class KafkaConsumerService {

    private static final Type NOTIFICATION_DTO = new TypeToken<NotificationDto>() {
    }.getType();

    private static final Gson gson = new Gson();

    @Autowired
    private NotificationProcessor notificationProcessor;

    @KafkaListener(topics = "nntopic", groupId = "group_id",containerFactory = "kafkaListenerContainerFactory")
    public void consumedVehicle(String jsonString){
        log.info("Receiving payload...");
        NotificationDto notificationDto = gson.fromJson(jsonString, NOTIFICATION_DTO);
        ValuesDto batteryVoltageKey = notificationProcessor.processNotification(notificationDto);
        System.out.println(batteryVoltageKey.getKey()+" : "+batteryVoltageKey.getValue());
        log.info("Payload consumed");

    }
}
