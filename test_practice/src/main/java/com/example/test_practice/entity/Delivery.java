package com.example.test_practice.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import org.hibernate.annotations.Nationalized;

@Entity
@Getter
@Setter
// @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d")
// @NamedQuery(name = "Delivery.findByDeliveryId", query = "SELECT d
// FROMDelivery d WHERE d.deliveryId = :deliveryId")
// @NamedQuery(name = "Delivery.findByDeliveryName", query = "SELECT d FROM
// Delivery d WHERE d.deliveryName = :deliveryName")
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    @JsonView(PlantResponse.class)
    private String name;

    @Nationalized
    @JsonView(PlantResponse.class)
    private String address;

    @Column(name = "address_full", length = 500)
    @JsonView(PlantResponse.class)
    private LocalDateTime deliveryDate;

    @OneToMany(mappedBy = "delivery", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonView(PlantResponse.class)
    private List<Plant> plants;

    @Type(type = "yes_no")
    @JsonView(PlantResponse.class)
    private Boolean isDelivered;
}
