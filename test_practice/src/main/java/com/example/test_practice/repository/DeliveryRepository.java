package com.example.test_practice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.test_practice.entity.Delivery;

@Repository
@Transactional
public class DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void persistDelivery(Delivery delivery) {
        entityManager.persist(delivery);
    }

    public Delivery findDeliveryById(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    public void deleteDeliveryById(Long id) {
        Delivery delivery = findDeliveryById(id);
        entityManager.remove(delivery);
    }

    public void updateDelivery(Delivery delivery) {
        entityManager.merge(delivery);
    }

    public List<Delivery> findAll() {
        return entityManager.createQuery("from Delivery", Delivery.class).getResultList();
    }

}
