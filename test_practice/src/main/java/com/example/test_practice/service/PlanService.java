package com.example.test_practice.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test_practice.entity.*;
import com.example.test_practice.repository.PlanRepository;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    public Long createPlan(Plant plant) {
        planRepository.save(plant);
        return plant.getId();
    }

    public Iterable<Plant> getAllPlants() {
        return planRepository.findAll();
    }

    public Boolean checkIfPlantDelivered(Long id) {
        return planRepository.deliveryCompletedBoolean(id);
    }

    public Iterable<Plant> getPlantsByPriceLessThan(BigDecimal price) {
        return planRepository.findByPriceLessThan(price);
    }
}
