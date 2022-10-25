package com.example.test_practice.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shrub")
@Getter
@Setter
// @NamedQuery(name = "Shrub.findAll", query = "SELECT s FROM Shrub s")
// @NamedQuery(name = "Shrub.findByShrubId", query = "SELECT s FROM Shrub s
// WHERE s.shrubId = :shrubId")
// @NamedQuery(name = "Shrub.findByShrubName", query = "SELECT s FROM Shrub s
// WHERE s.shrubName = :shrubName")

public class Shrub extends Plant {
    @JsonView(PlantResponse.class)
    private float height;
    @JsonView(PlantResponse.class)
    private float width;

    public Shrub() {
        // TODO document why this constructor is empty
    }
}
