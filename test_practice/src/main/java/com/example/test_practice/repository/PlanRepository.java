package com.example.test_practice.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PlanRepository {
    @PersistenceContext
    EntityManager entityManager;

}
