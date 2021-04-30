package com.codecta.academy.repository.entities;

import com.codecta.academy.repository.entities.Game;
import com.codecta.academy.repository.entities.ModelObject;

import javax.persistence.*;
@Entity
@Table(schema="codecta", name = "PLAYERS")
public class Player extends ModelObject {

    @SequenceGenerator(
            name = "playerSeq",
            sequenceName = "PLAYER_SEQ",
            schema = "codecta",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playerSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    private int health;
    private int inflictDamage;
    private int potion;


    @OneToOne(cascade = {CascadeType.ALL})
    private Game game;

    public void setId(Integer id) {
        this.id = id;
    }

    /*
        public Player (){
            this.health = 90;
            this.inflictDamage =(int)(Math.random() * (50 - 20 + 1) + 20);
            this.potion = (int)(Math.random() * (30 - 10 + 1) + 10);
            this.currentDungeonID=0;
        }
    */
    //***************************************************



    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
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

    @Override
    public Integer getId() {
        return this.id;
    }
}
