package com.codecta.academy.repository;

import com.codecta.academy.repository.entities.Monster;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class MonsterRepo extends Repository<Monster,Integer> {
    protected MonsterRepo() {
        super(Monster.class);
    }
}
