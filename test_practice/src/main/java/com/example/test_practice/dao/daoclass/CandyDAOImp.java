package com.example.test_practice.dao.daoclass;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.test_practice.dao.data.CandyData;

@Repository
public class CandyDAOImp implements CandyDAO {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String FIND_BY_DELIVERY = "SELECT * FROM candy WHERE delivery_id = :deliveryId";
    private static final String FIND_ALL = "SELECT * FROM candy";
    private static final String ADD_TO_DELIVERY = "INSERT INTO candy_order (candy_id, delivery_id) VALUES (:candyId, :deliveryId)";
    private static final String DELETE_BY_ID = "DELETE FROM candy WHERE id = :id";
    private static final String UPDATE = "UPDATE candy SET name = :name, price = :price WHERE id = :id";
    private static final String FIND_BY_ID = "SELECT * FROM candy WHERE id = :id";

    @Override
    public List<CandyData> list() {
        return namedParameterJdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(CandyData.class));
    }

    @Override
    public void addToDelivery(Long candyId, Long deliveryid) {
        namedParameterJdbcTemplate.update(ADD_TO_DELIVERY, Map.of("candyId", candyId, "deliveryId", deliveryid));
    }

    @Override
    public List<CandyData> findByDelivery(Long deliveryId) {
        return namedParameterJdbcTemplate.query(FIND_BY_DELIVERY, Map.of("deliveryId", deliveryId),
                new BeanPropertyRowMapper<>(CandyData.class));
    }

}
