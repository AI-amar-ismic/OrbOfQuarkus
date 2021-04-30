package com.codecta.academy.services.model;



public class DungeonDto {

    private Integer id;
    private MonsterDto monster = new MonsterDto();
    private Integer nextDungeonID;
    private HealingPotionDto potion = new HealingPotionDto();
    private PowerUpDto powerUp = new PowerUpDto();
    private boolean fight;
    private boolean containsOoQ;
    private Integer mapId;
    private boolean winner;
    private boolean isDummy;
    private boolean isLast;


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

    public Integer getNextDungeonID() {
        return nextDungeonID;
    }

    public void setNextDungeonID(Integer nextDungeonID) {
        this.nextDungeonID = nextDungeonID;
    }

    public void setMonster(MonsterDto monster) {
        this.monster = monster;
    }

    public void setPotion(HealingPotionDto potion) {
        this.potion = potion;
    }

    public void setPowerUp(PowerUpDto powerUp) {
        this.powerUp = powerUp;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    /*
        public DungeonDto(){
            monster.setDungeonID(this.getId());
            potion.setDungeonID(this.getId());
            powerUp.setDungeonID(this.getId());
            fight=false;
            containsOoQ=false;
        }
    */
    public MonsterDto getMonster() {
        return monster;
    }

    public HealingPotionDto getPotion() {
        return potion;
    }

    public PowerUpDto getPowerUp() {
        return powerUp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isFight() {
        return fight;
    }

    public void setFight(boolean fight) {
        this.fight = fight;
    }

    public boolean isContainsOoQ() {
        return containsOoQ;
    }

    public void setContainsOoQ(boolean containsOoQ) {
        this.containsOoQ = containsOoQ;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }
}
