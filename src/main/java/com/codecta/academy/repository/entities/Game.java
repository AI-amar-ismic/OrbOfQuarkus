package com.codecta.academy.repository.entities;



import javax.persistence.*;
@Entity
@Table(schema = "codecta", name = "GAMES")
public class Game extends ModelObject{

    @SequenceGenerator(
            name = "gameSeq",
            sequenceName = "GAME_SEQ",
            schema = "codecta",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gameSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @OneToOne(cascade = {CascadeType.ALL})
    private Player player;
    @OneToOne(cascade = {CascadeType.ALL})
    private Level level;

    private boolean gameOver;

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
