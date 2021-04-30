package com.codecta.academy.services.model;

import java.util.ArrayList;
import java.util.List;

public class MapDto {
    private Integer id;
    private Integer levelID;
    private Integer currentRoomID;
    private DungeonDto firstRoom = new DungeonDto();
    private DungeonDto currentRoom=new DungeonDto();

    public DungeonDto getFirstRoom() {
        return firstRoom;
    }

    public void setFirstRoom(DungeonDto firstRoom) {
        this.firstRoom = firstRoom;
    }

    public DungeonDto getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(DungeonDto currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Integer getCurrentRoomID() {
        return currentRoomID;
    }

    public void setCurrentRoomID(Integer currentRoomID) {
        this.currentRoomID = currentRoomID;
    }

    private List<DungeonDto>rooms = new ArrayList<>();
/*
    public MapDto(){
        this.currentRoomID=0;
        for (int i=0;i<5;i++){
            DungeonDto dungeon = new DungeonDto();
            dungeon.setMapId(this.getId());
            rooms.add(dungeon);
        }
    }
*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevelID() {
        return levelID;
    }

    public void setLevelID(Integer levelID) {
        this.levelID = levelID;
    }



    public List<DungeonDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<DungeonDto> rooms) {
        this.rooms = rooms;
    }
}
