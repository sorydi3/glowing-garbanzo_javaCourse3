package com.example.test_practice.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.test_practice.entity.Plant;
import com.example.test_practice.entity.PlantDTO;
import com.example.test_practice.entity.PlantResponse;
import com.example.test_practice.service.PlanService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlanService planService;

    @GetMapping("/all")
    @JsonView(PlantResponse.class)
    public List<PlantDTO> getPlant() {
        List<PlantDTO> plantDTOs = new ArrayList<>();
        planService.getAllPlants().forEach(plant -> {
            PlantDTO dto = convertPlantTodto(plant);
            plantDTOs.add(dto);
        });
        return plantDTOs;
    }

    @GetMapping("/delivered")
    public Boolean checkIfPlantDelivered(@RequestParam String id) {
        System.out.println("id: " + id);
        planService.checkIfPlantDelivered(Long.valueOf(id));

        return true;
    }

    // @GetMapping("/{price}")
    @JsonView(PlantResponse.class)
    public List<PlantDTO> getPlantByPriceLessThan(@PathVariable BigDecimal price) {
        List<PlantDTO> plantDTOs = new ArrayList<>();
        planService.getPlantsByPriceLessThan(price).forEach(plant -> {
            PlantDTO dto = convertPlantTodto(plant);
            plantDTOs.add(dto);
        });
        return plantDTOs;
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
