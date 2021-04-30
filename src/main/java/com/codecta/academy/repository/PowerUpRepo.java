package com.codecta.academy.repository;

import com.codecta.academy.repository.entities.PowerUp;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class PowerUpRepo extends Repository<PowerUp,Integer> {

    public PowerUpRepo(){
        super(PowerUp.class);
    }
}
