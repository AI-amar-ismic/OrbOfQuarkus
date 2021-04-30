package com.codecta.academy.repository;

import com.codecta.academy.repository.entities.Level;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class LevelRepo extends Repository<Level, Integer>{
    public LevelRepo() {
        super(Level.class);
    }
}
