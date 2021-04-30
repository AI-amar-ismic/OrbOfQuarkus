package com.codecta.academy.repository;

import com.codecta.academy.repository.entities.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class PlayerRepo extends Repository<Player,Integer> {
    public PlayerRepo(){super(Player.class);}
}
