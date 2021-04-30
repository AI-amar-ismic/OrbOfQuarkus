package com.codecta.academy.repository.entities;

import com.codecta.academy.repository.entities.Dungeon;
import com.codecta.academy.repository.entities.ModelObject;

import javax.persistence.*;

@Entity
@Table(schema="codecta", name = "MONSTERS")
public class Monster extends ModelObject {


    @SequenceGenerator(
            name = "monsterSeq",
            sequenceName = "MONSTER_SEQ ",
            schema = "codecta",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "monsterSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    private int health;
    private int inflictDamage;
    @OneToOne
    Dungeon dungeon;

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

    @Override
    public Integer getId() {
        return this.id;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
}
