package com.example.test_practice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.test_practice.entity.Delivery;

@Repository
@Transactional
public interface DeliveryRepository {

    public void persistDelivery(Delivery delivery);

    public Delivery findDeliveryById(Long id);

    public void deleteDeliveryById(Long id);

    public void updateDelivery(Delivery delivery);

    public List<Delivery> findAll();

}
