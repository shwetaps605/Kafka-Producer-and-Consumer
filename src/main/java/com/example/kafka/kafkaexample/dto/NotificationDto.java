package com.example.kafka.kafkaexample.dto;
import lombok.Data;

import java.util.List;

@Data
public class NotificationDto {

    private List<MessagesDto> messages;
}
