package com.codecta.academy.repository.entities;

import com.codecta.academy.repository.entities.Dungeon;
import com.codecta.academy.repository.entities.ModelObject;

import javax.persistence.*;

@Entity
@Table(schema = "codecta", name = "PoweUps")
public class PowerUp extends ModelObject {

    private int strength;
    @SequenceGenerator(
            name = "powerUpSeq",
            sequenceName = "POWERUP_SEQ",
            schema = "codecta",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "powerUpSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @OneToOne
    Dungeon dungeon;

    public void setId(Integer id) {
        this.id = id;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }



    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
