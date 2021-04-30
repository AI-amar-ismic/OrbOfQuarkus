package com.codecta.academy.repository;

import com.codecta.academy.repository.entities.Dungeon;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class DungeonRepo extends Repository<Dungeon,Integer> {

    public DungeonRepo(){
         super(Dungeon.class);
    }


}
