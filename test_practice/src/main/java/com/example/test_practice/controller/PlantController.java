package com.example.test_practice.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test_practice.entity.Plant;
import com.example.test_practice.entity.PlantDTO;
import com.example.test_practice.entity.PlantResponse;
import com.example.test_practice.service.PlanService;
import com.fasterxml.jackson.annotation.JsonView;


@RestController
public class PlantController {
    @Autowired
    private PlanService planService;

    @GetMapping("/plant")
    @JsonView(PlantResponse.class)
    public Plant getPlant() {
        return planService.gtePlanByName();
    }


    public PlantDTO convertPlantTodto(Plant plant) {
        PlantDTO dto = new PlantDTO();
        BeanUtils.copyProperties(plant, dto);
        return dto;
    }

    public Plant covertDtoToPlan(PlantDTO dto) {
        Plant plant = new Plant();
        BeanUtils.copyProperties(dto, plant);
        return plant;
    }
    
}
