package com.codecta.academy.repository.entities;

import javax.persistence.*;

@Entity
@Table(schema = "codecta", name = "LEVELS")
public class Level extends ModelObject {

    @SequenceGenerator(
            name = "levelSeq",
            sequenceName = "LEVEL_SEQ",
            schema = "codecta",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "levelSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    @OneToOne
    private Map map;
    private double weightFactor;
    @OneToOne(cascade = {CascadeType.ALL})
    private Game game;

    //*************************************************


    public void setId(Integer id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public double getWeightFactor() {
        return weightFactor;
    }

    public void setWeightFactor(double weightFactor) {
        this.weightFactor = weightFactor;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
