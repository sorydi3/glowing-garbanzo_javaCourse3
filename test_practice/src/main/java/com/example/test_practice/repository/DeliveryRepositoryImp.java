package com.example.test_practice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.test_practice.entity.Delivery;

@Repository
@Transactional
public class DeliveryRepositoryImp implements DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void persistDelivery(Delivery delivery) {
        entityManager.persist(delivery);
    }

    @Override
    public Delivery findDeliveryById(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    @Override
    public void deleteDeliveryById(Long id) {
        Delivery delivery = findDeliveryById(id);
        entityManager.remove(delivery);
    }

    @Override
    public void updateDelivery(Delivery delivery) {
        entityManager.merge(delivery);
    }

    @Override
    public List<Delivery> findAll() {
        return entityManager.createQuery("from Delivery", Delivery.class).getResultList();
    }
}
