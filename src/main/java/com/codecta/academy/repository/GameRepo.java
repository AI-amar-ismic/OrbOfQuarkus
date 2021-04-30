package com.codecta.academy.repository;

import com.codecta.academy.repository.entities.Game;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional(Transactional.TxType.MANDATORY)
public class GameRepo extends Repository<Game, Integer> {
    public GameRepo(){super(Game.class);
    }



}
