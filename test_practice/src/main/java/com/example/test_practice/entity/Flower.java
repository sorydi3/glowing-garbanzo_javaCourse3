package com.example.test_practice.entity;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// @NamedQuery(name = "Flower.findAll", query = "SELECT f FROM Flower f")
// @NamedQuery(name = "Flower.findByFlowerId", query = "SELECT f FROM Flower f
// WHERE f.flowerId = :flowerId")
// @NamedQuery(name = "Flower.findByFlowerName", query = "SELECT f FROM Flower f
// WHERE f.flowerName = :flowerName")
public class Flower extends Plant {
    @JsonView(PlantResponse.class)
    private String color;
}
