package com.codecta.academy.services;

import com.codecta.academy.repository.entities.Welcome;
import com.codecta.academy.services.model.DungeonDto;
import com.codecta.academy.services.model.GameDto;
import com.codecta.academy.services.model.PlayerDto;

import java.util.List;

public interface OoQService {

    Welcome welcomeMessage();
    GameDto createNewGame();

    List<GameDto> getAllGames();

    DungeonDto getNextDungeon();

    GameDto getGameByID(Integer id);

    DungeonDto getDungeonByID(Integer currentDungeonID);

    DungeonDto fightMonster(GameDto currentGame, PlayerDto currentPlayer);

    PlayerDto getPlayerByID(Integer id);

    DungeonDto fleeMonster(GameDto currentGame, PlayerDto currentPlayer);

    PlayerDto healPlayer(Integer id);
}
