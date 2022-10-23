package com.example.test_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test_practice.entity.Delivery;
import com.example.test_practice.service.DeliveryService;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @PostMapping("/delivery")
    public Long getDelivery(@RequestBody Delivery delivery) {
        return deliveryService.scheduleDelivery(delivery);
    }
}
