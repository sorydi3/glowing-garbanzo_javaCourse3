package com.example.test_practice.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
public class PlantDTO {
    @JsonView(PlantResponse.class)
    private String name;
    @JsonView(PlantResponse.class)
    private String color;
    @JsonView(PlantResponse.class)
    private BigDecimal price;
}
