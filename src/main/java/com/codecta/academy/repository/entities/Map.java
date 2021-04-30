package com.codecta.academy.repository.entities;

import com.codecta.academy.repository.DungeonRepo;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(schema = "codecta", name = "MAPS")
public class Map extends ModelObject{



    public void setId(Integer id) {
        this.id = id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }


    @SequenceGenerator(
            name = "mapSequence",
            sequenceName = "MAP_SEQ",
            schema = "codecta",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mapSequence")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    @OneToOne
    private Level level;

    @OneToOne
    private Dungeon firstRoom;
    @OneToOne
    private Dungeon currentRoom;
    private Integer currentRoomID;

    public Dungeon getCurrentRoom(){
        return currentRoom;
    }

    public Integer getCurrentRoomID() {
        return currentRoomID;
    }

    public void setCurrentRoomID(Integer currentRoomID) {
        this.currentRoomID = currentRoomID;
    }

    public List<Dungeon> getRooms() {
        List<Dungeon> rooms = new ArrayList<>();
        Dungeon workingDungeon = firstRoom;
        while (workingDungeon.getNextDungeon()!=null){
            rooms.add(workingDungeon);
            workingDungeon=workingDungeon.getNextDungeon();
        }
        return rooms;
    }

    public Dungeon getFirstRoom() {
        return firstRoom;
    }

    public void setFirstRoom(Dungeon firstRoom) {
        this.firstRoom = firstRoom;
    }

    public void setCurrentRoom(Dungeon currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
