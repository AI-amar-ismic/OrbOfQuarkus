package com.codecta.academy.repository;

import com.codecta.academy.repository.entities.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class MapRepo extends Repository<Map, Integer> {
    public MapRepo() {
        super(Map.class);
    }
}
