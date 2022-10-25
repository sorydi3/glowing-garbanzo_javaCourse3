package com.example.test_practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test_practice.entity.Delivery;
import com.example.test_practice.entity.PlantResponse;
import com.example.test_practice.service.DeliveryService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @PostMapping("/delivery")
    @JsonView(PlantResponse.class)
    public Long getDelivery(@RequestBody Delivery delivery) {
        return deliveryService.scheduleDelivery(delivery);
    }

    @GetMapping("/delivery")
    @JsonView(PlantResponse.class)
    public List<Delivery> getDelivery() {
        return deliveryService.getDeliveries();
    }
}
