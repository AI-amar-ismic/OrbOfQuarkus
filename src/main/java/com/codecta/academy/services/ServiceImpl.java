package com.codecta.academy.services;



import com.codecta.academy.repository.*;
import com.codecta.academy.repository.PlayerRepo;
import com.codecta.academy.repository.entities.*;
import com.codecta.academy.repository.entities.HealingPotion;
import com.codecta.academy.repository.entities.PowerUp;
import com.codecta.academy.services.model.DungeonDto;
import com.codecta.academy.services.model.GameDto;
import com.codecta.academy.services.model.PlayerDto;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Transactional
public class ServiceImpl implements OoQService {

    final String LOG_FILE = "log4j.properties";
    Logger logger = Logger.getLogger(ServiceImpl.class);

    @Inject
    GameRepo gamerepository;

    @Inject
    PlayerRepo playerRepo;

    @Inject
    LevelRepo levelRepo;

    @Inject
    MapRepo mapRepo;

    @Inject
    DungeonRepo dungeonRepo;

    @Inject
    MonsterRepo monsterRepo;

    @Inject
    PotionRepo potionRepo;

    @Inject
    PowerUpRepo powerUpRepo;

    @Override
    public Welcome welcomeMessage() {
        return new Welcome("Welcome to Orb of Quarkus");
    }

    @Override
    public GameDto createNewGame() {
        Game game = new Game();
        ModelMapper modelMapper = new ModelMapper();
        Player player = new Player();
        player.setHealth(100);
        player.setInflictDamage(getRandom(10,50));
        player.setPotion(getRandom(10,30));
        Level level = new Level();
        Map map = new Map();

        map.setCurrentRoomID(1);
        Dungeon firstRoom = new Dungeon();
        Monster firstMonster = new Monster();
        HealingPotion FhealingPotion = new HealingPotion();
        PowerUp FpowerUp = new PowerUp();
        FhealingPotion.setStrength(getRandom(10,30));
        FpowerUp.setStrength(getRandom(5,20));
        firstMonster.setHealth(50);
        firstMonster.setInflictDamage(10);
        firstRoom.setContainsOoQ(false);
        firstRoom.setFight(true);
        firstRoom.setWinner(false);
        firstRoom.setMap(map);
        firstMonster.setDungeon(firstRoom);
        firstRoom.setMonster(firstMonster);
        FhealingPotion.setDungeon(firstRoom);
        FpowerUp.setDungeon(firstRoom);
        firstRoom.setPotion(FhealingPotion);
        firstRoom.setPowerUp(FpowerUp);
        map.setFirstRoom(firstRoom);
        map.setCurrentRoom(firstRoom);
        int numOfRooms = 3;



        player.setGame(game);
        level.setGame(game);
        level.setWeightFactor(1);
        level.setMap(map);
        map.setLevel(level);
        game.setPlayer(player);
        game.setLevel(level);
        game.setGameOver(false);
        firstRoom=dungeonRepo.add(firstRoom);
        firstMonster=monsterRepo.add(firstMonster);
        FhealingPotion=potionRepo.add(FhealingPotion);
        FpowerUp=powerUpRepo.add(FpowerUp);
        player=playerRepo.add(player);
        level=levelRepo.add(level);
        map=mapRepo.add(map);
        game=gamerepository.add(game);
        Dungeon workingDungeon = firstRoom;
        for (int i=0;i<=numOfRooms-1;i++){
            Dungeon room = new Dungeon();
            Monster monster = new Monster();
            HealingPotion healingPotion = new HealingPotion();
            PowerUp powerUp = new PowerUp();
            healingPotion.setStrength(getRandom(10,30));
            powerUp.setStrength(getRandom(5,20));
            monster.setHealth(50+(i*10));
            monster.setInflictDamage(10+(i*10));

            if (i==numOfRooms-1){
                room.setContainsOoQ(true);
            }else {
                room.setContainsOoQ(false);
            }
            room.setFight(true);
            room.setWinner(false);
            room.setMap(map);
            workingDungeon.setNextDungeon(room);
            workingDungeon=workingDungeon.getNextDungeon();

            monster.setDungeon(room);
            room.setMonster(monster);
            healingPotion.setDungeon(room);
            powerUp.setDungeon(room);
            room.setPotion(healingPotion);
            room.setPowerUp(powerUp);

            room=dungeonRepo.add(room);
            monster=monsterRepo.add(monster);
            healingPotion=potionRepo.add(healingPotion);
            powerUp=powerUpRepo.add(powerUp);
        }



        return modelMapper.map(game,GameDto.class);
    }


    @Override
    public List<GameDto> getAllGames() {
        List<Game> gameList = gamerepository.findAll();
        if (gameList==null || gameList.isEmpty()){
            return null;
        }
        List<GameDto>gameDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Game game:
             gameList) {
            GameDto gameDto = modelMapper.map(game,GameDto.class);
            gameDtoList.add(gameDto);
        }
        return gameDtoList;
    }

    @Override
    public DungeonDto getNextDungeon() {
        return null;
    }

    @Override
    public GameDto getGameByID(Integer id) {
        Game game = gamerepository.findById(id);
        if(game==null){
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(game,GameDto.class);
    }

    @Override
    public DungeonDto getDungeonByID(Integer currentDungeonID) {
        Dungeon dungeon = dungeonRepo.findById(currentDungeonID);
        if(dungeon==null){
            return null;
        }
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dungeon,DungeonDto.class);
    }

    @Override
    public DungeonDto fightMonster(GameDto currentGame, PlayerDto currentPlayer) {
        ModelMapper modelMapper = new ModelMapper();
        Game game = gamerepository.findById(currentGame.getId());
        Player player = playerRepo.findById(currentPlayer.getId());
        Level level = levelRepo.findById(game.getLevel().getId());
        Map map = mapRepo.findById(level.getMap().getId());
        Dungeon dungeon = dungeonRepo.findById(map.getCurrentRoom().getId());
        Monster monster = monsterRepo.findById(dungeon.getMonster().getId());
        logger.info("Initialized player dungeon monster "+player.getId().toString()+" "+dungeon.getId().toString()+" "+monster.getId().toString());


        while (player.getHealth()>0 && monster.getHealth()>0){
            monster.setHealth(monster.getHealth()-(player.getInflictDamage()*getRandom(1,6)/5));
            player.setHealth(player.getHealth()-(monster.getInflictDamage()*getRandom(1,6)/5));

        }

        if (player.getHealth()<=0 && monster.getHealth()>0){
            return null;
        }else if (monster.getHealth()<0) {


            player.setInflictDamage(player.getInflictDamage() + dungeon.getPowerUp().getStrength());
            player.setHealth(player.getHealth() + dungeon.getPotion().getStrength());

            dungeon.getPowerUp().setStrength(0);
            dungeon.getPotion().setStrength(0);
            dungeon.getMonster().setInflictDamage(0);
            Dungeon followingDungeon = dungeon.getNextDungeon();
            if(followingDungeon!=null) {
                map.setCurrentRoom(followingDungeon);
            }else{
                Dungeon endingDungeon = new Dungeon();
                endingDungeon.setLast(true);
                endingDungeon.setDummy(true);
                return modelMapper.map(endingDungeon,DungeonDto.class);
            }


            game = gamerepository.save(game);
            player = playerRepo.save(player);
            monster = monsterRepo.save(monster);
            level = levelRepo.save(level);
            map = mapRepo.save(map);
            dungeon = dungeonRepo.save(dungeon);


            return modelMapper.map(dungeon, DungeonDto.class);


        }

        return null;

    }

    @Override
    public PlayerDto getPlayerByID(Integer id) {
        Player player = playerRepo.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        if (player!=null){
            return modelMapper.map(player,PlayerDto.class);
        }
        return null;
    }

    @Override
    public DungeonDto fleeMonster(GameDto currentGame, PlayerDto currentPlayer) {
        ModelMapper modelMapper = new ModelMapper();
        Game game = gamerepository.findById(currentGame.getId());
        Player player = playerRepo.findById(currentPlayer.getId());
        Level level = levelRepo.findById(game.getLevel().getId());
        Map map = mapRepo.findById(level.getMap().getId());
        Dungeon dungeon = dungeonRepo.findById(map.getCurrentRoom().getId());
        Monster monster = monsterRepo.findById(dungeon.getMonster().getId());
        Dungeon followingDungeon = dungeon.getNextDungeon();
        if(followingDungeon!=null) {


            player.setInflictDamage(player.getInflictDamage() - (player.getInflictDamage() / 100 * 20));
            player.setHealth(player.getHealth() - (player.getHealth() / 100 * 20));
            dungeon.setFight(false);
            dungeon = dungeonRepo.save(dungeon);
            map = mapRepo.save(map);
            level = levelRepo.save(level);
            player = playerRepo.save(player);
            monster = monsterRepo.save(monster);
            game = gamerepository.save(game);
            map.setCurrentRoom(followingDungeon);
            return modelMapper.map(dungeon, DungeonDto.class);
        }
        Dungeon endingDungeon = new Dungeon();
        endingDungeon.setLast(true);
        endingDungeon.setDummy(true);
        return modelMapper.map(endingDungeon,DungeonDto.class);

    }

    @Override
    public PlayerDto healPlayer(Integer id) {
        Player player = playerRepo.findById(id);
        if(player!=null) {
            player.setHealth(player.getHealth() + player.getPotion());
            player.setPotion(0);
            player = playerRepo.save(player);
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(player, PlayerDto.class);
        }
        if(player.getPotion()<=0){
            return null;
        }
        return null;
    }

    public int getRandom (int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
    }


}
