package com.codecta.academy.repository;

import com.codecta.academy.repository.entities.HealingPotion;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;


@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class PotionRepo extends Repository<HealingPotion,Integer> {

    public PotionRepo(){
        super(HealingPotion.class);
    }
}
