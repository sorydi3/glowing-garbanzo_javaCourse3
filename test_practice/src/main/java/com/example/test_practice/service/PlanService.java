package com.example.test_practice.service;

import org.springframework.stereotype.Service;

import com.example.test_practice.entity.*;

@Service
public class PlanService {
    public Plant gtePlanByName() {
        return new Plant();
    }
}
