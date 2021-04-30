package com.codecta.academy.services.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class PlayerDto {
    private Integer id;
    private int health;
    private int inflictDamage;
    private int potion;

    private Integer gameID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getInflictDamage() {
        return inflictDamage;
    }

    public void setInflictDamage(int inflictDamage) {
        this.inflictDamage = inflictDamage;
    }

    public int getPotion() {
        return potion;
    }

    public void setPotion(int potion) {
        this.potion = potion;
    }



    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }
}
