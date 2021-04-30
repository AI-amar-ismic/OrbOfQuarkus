package com.codecta.academy.repository.entities;

import javax.persistence.*;

@Entity
@Table(schema = "codecta", name = "Dungeons")
public class Dungeon extends ModelObject{
    @OneToOne
    private HealingPotion potion;
    @OneToOne
    private PowerUp powerUp;

    public Dungeon getNextDungeon() {
        return nextDungeon;
    }

    public void setNextDungeon(Dungeon nextDungeon) {
        this.nextDungeon = nextDungeon;
    }

    @SequenceGenerator(
            name = "dungeonSeq",
            sequenceName = "DUNGEON_SEQ",
            schema = "codecta",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dungeonSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    @OneToOne
    private Monster monster;
    @ManyToOne
    private Map map;
    @OneToOne
    private Dungeon nextDungeon;

    private boolean winner;

    private boolean isDummy;

    private boolean isLast;

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public boolean isDummy() {
        return isDummy;
    }

    public void setDummy(boolean dummy) {
        isDummy = dummy;
    }



    private boolean fight;
    private boolean containsOoQ;

    public boolean isContainsOoQ() {
        return containsOoQ;
    }

    public void setContainsOoQ(boolean containsOoQ) {
        this.containsOoQ = containsOoQ;
    }

    public boolean isFight() {
        return fight;
    }

    public void setFight(boolean fight) {
        this.fight = fight;
    }

    public HealingPotion getPotion() {
        return potion;
    }

    public void setPotion(HealingPotion potion) {
        this.potion = potion;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }




    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
