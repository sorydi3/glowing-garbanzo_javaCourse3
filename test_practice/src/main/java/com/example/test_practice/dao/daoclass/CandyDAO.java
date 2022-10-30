package com.example.test_practice.dao.daoclass;

import java.util.List;

import javax.transaction.Transactional;

import com.example.test_practice.dao.data.CandyData;

public interface CandyDAO {

    @Transactional
    List<CandyData> list();

    @Transactional
    void addToDelivery(Long candyId, Long deliveryid);

    @Transactional
    List<CandyData> findByDelivery(Long deliveryId);
}