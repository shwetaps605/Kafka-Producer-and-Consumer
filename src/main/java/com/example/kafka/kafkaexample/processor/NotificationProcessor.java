package com.example.kafka.kafkaexample.processor;

import com.example.kafka.kafkaexample.dto.MessagesDto;
import com.example.kafka.kafkaexample.dto.NotificationDto;
import com.example.kafka.kafkaexample.dto.ValuesDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationProcessor {

    public ValuesDto processNotification(NotificationDto notificationDto){
        List<MessagesDto> messages = notificationDto.getMessages();
        MessagesDto message = messages.get(0);
        List<ValuesDto> values = message.getPayload().getContent().getValues();
        ValuesDto batteryVoltage = values.get(2);
        return batteryVoltage;
    }
}
