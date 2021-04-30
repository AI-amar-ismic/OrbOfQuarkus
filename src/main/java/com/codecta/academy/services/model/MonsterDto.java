package com.codecta.academy.services.model;

public class MonsterDto {
    private Integer id;
    private int health;
    private int inflictDamage;
    private Integer dungeonID;

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

    public Integer getDungeonID() {
        return dungeonID;
    }

    public void setDungeonID(Integer dungeonID) {
        this.dungeonID = dungeonID;
    }
}
