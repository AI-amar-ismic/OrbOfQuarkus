package com.codecta.academy.services.model;



public class LevelDto {

    private Integer id;
    private double weightFactor;
    private Integer gameID;
    private MapDto map = new MapDto();



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getWeightFactor() {
        return weightFactor;
    }

    public void setWeightFactor(double weightFactor) {
        this.weightFactor = weightFactor;
    }

    public MapDto getMap() {
        return map;
    }

    public void setMap(MapDto map) {
        this.map = map;
    }

    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }
}
