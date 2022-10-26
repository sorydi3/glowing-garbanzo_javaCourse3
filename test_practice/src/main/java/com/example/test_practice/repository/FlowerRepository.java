package com.example.test_practice.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.test_practice.entity.Flower;
import javax.persistence.Query;

@Repository
@Transactional
public class FlowerRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Long persistFlower(Flower flower) {
        entityManager.persist(flower);
        return flower.getId();
    }

    public Flower findFlowerById(Long id) {
        return entityManager.find(Flower.class, id);
    }

    public void deleteFlowerById(Long id) {
        Flower flower = findFlowerById(id);
        entityManager.remove(flower);
    }

    public void updateFlower(Flower flower) {
        entityManager.merge(flower);
    }

    public Flower findFlowerByName(String name) {
        Query query = entityManager.createNamedQuery("Flower.findFlowerByName");
        query.setParameter("name", name);
        return (Flower) query.getSingleResult();
    }

    public Flower findFlowerByColor(String color) {
        Query query = entityManager.createNamedQuery("Flower.findFlowerByColor");
        query.setParameter("color", color);
        return (Flower) query.getSingleResult();
    }

    public Flower findFlowerByFlowerId(Long flowerId) {
        Query query = entityManager.createNamedQuery("Flower.findFlowerByFlowerId");
        query.setParameter("flowerId", flowerId);
        return (Flower) query.getSingleResult();
    }
}
