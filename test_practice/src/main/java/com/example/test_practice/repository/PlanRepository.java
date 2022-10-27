package com.example.test_practice.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.test_practice.entity.Plant;

public interface PlanRepository extends CrudRepository<Plant, Long> {

    @Query("select new java.lang.Boolean(p.delivery.isDelivered) from Plant p where p.id = :plantId")
    Boolean deliveryCompletedBoolean(Long plantId);

    List<Plant> findByPriceLessThan(BigDecimal price);
}
