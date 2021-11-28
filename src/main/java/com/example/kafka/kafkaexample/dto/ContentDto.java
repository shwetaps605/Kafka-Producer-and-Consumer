package com.example.kafka.kafkaexample.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ContentDto {

    @SerializedName("values")
    private List<ValuesDto> values;


}
