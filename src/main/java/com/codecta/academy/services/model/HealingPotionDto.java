package com.codecta.academy.services.model;

public class HealingPotionDto {

    private int strength;
    private Integer id;
    private Integer dungeonID;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDungeonID() {
        return dungeonID;
    }

    public void setDungeonID(Integer dungeonID) {
        this.dungeonID = dungeonID;
    }
}
