package com.example.test_practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test_practice.entity.Delivery;
import com.example.test_practice.repository.DeliveryRepository;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public Delivery getDelivery(Long id) {
        return deliveryRepository
                .findDeliveryById(null);
    }

    public Long scheduleDelivery(Delivery delivery) {

        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));

        deliveryRepository.persistDelivery(delivery);

        return delivery.getId();
    }

    public List<Delivery> getDeliveries() {
        return deliveryRepository.findAll();
    }

}
