package com.example.test_practice.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import java.util.List;

import org.h2.table.Plan;
import org.hibernate.annotations.Nationalized;


@Entity
 // lombok
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    private String name;
    @Nationalized
    private String address;
    @Column(name = "address_full",length = 500)
    private LocalDateTime deliveryDate;


    @OneToMany(mappedBy = "delivery",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Plan> plants;
    

    @Type(type = "yes_no")
    private Boolean isDelivered;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeliveryDate() {
        return this.deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Boolean isIsDelivered() {
        return this.isDelivered;
    }

    public Boolean getIsDelivered() {
        return this.isDelivered;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }


}
