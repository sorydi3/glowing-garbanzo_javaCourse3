package com.example.test_practice.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(name = "Flower.findAll", query = "SELECT f FROM Flower f")
@NamedQuery(name = "Flower.findByFlowerId", query = "SELECT f FROM Flower f WHERE f.id = :flowerId")
@NamedQuery(name = "Flower.findByFlowerName", query = "SELECT f FROM Flower f WHERE f.name = :flowerName")
@NamedQuery(name = "Flower.findByFlowerColor", query = "SELECT f FROM Flower f WHERE f.color = :flowerColor")
public class Flower extends Plant {
    @JsonView(PlantResponse.class)
    private String color;
}
