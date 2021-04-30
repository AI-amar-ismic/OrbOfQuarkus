package com.codecta.academy;

import com.codecta.academy.repository.entities.Dungeon;
import com.codecta.academy.services.OoQService;
import com.codecta.academy.services.model.DungeonDto;
import com.codecta.academy.services.model.GameDto;
import com.codecta.academy.services.model.MonsterDto;
import com.codecta.academy.services.model.PlayerDto;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;


@Path("/game")
public class OoQResource {

    @Inject
    OoQService qService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/welcome")
    public Response welcomeScreen (){
        return Response.ok(qService.welcomeMessage()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createGame (@Context UriInfo uriInfo){

        GameDto gameDto=qService.createNewGame();
        if (gameDto!=null){
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(gameDto.getId()));
            return Response.created(uriBuilder.build()).entity(gameDto).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGames(){
        List<GameDto> gameDtoList = qService.getAllGames();
        if (gameDtoList==null){
            return Response.noContent().build();
        }
        return Response.ok(gameDtoList).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/move")
    public Response movePlayer (@PathParam("id") Integer id){
        GameDto currentGame = qService.getGameByID(id);
        DungeonDto discoveredDungeon = qService.getDungeonByID(currentGame.getLevel().getMap().getCurrentRoom().getId() );
        if (currentGame == null || discoveredDungeon == null){
            return Response.noContent().build();
        }
        return Response.ok(discoveredDungeon).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/fight")
    public Response fightMonster (@PathParam("id") Integer id){
        GameDto currentGame = qService.getGameByID(id);
        PlayerDto currentPlayer = qService.getPlayerByID(currentGame.getPlayer().getId());

        DungeonDto nextDungeon = qService.fightMonster(currentGame, currentPlayer);

        if (nextDungeon!=null){
            if (nextDungeon.isLast()&&nextDungeon.isDummy()){
                return Response.ok("Game won!").build();
            }
            return Response.ok("Won this round!").build();
        }
        return Response.ok("GAME OVER").build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/flee")
    public Response fleeMonster (@PathParam("id") Integer id){
        GameDto currentGame = qService.getGameByID(id);
        PlayerDto currentPlayer = qService.getPlayerByID(currentGame.getPlayer().getId());
        DungeonDto nextDungeon = qService.fleeMonster(currentGame, currentPlayer);
        if(nextDungeon!=null){
            if(nextDungeon.isLast()&&nextDungeon.isDummy()) {
                return Response.ok("Hold on! You can't flee from a monster that holds the Orb of Quarkus. Get out there and fight!").build();
            }
            return Response.ok("Woah, that was close! You fled from that monster, but your Health and Strength were reduced by 20%").build();
        }

        return Response.noContent().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/heal")
    public Response healPlayer(@PathParam("id") Integer id){
        GameDto currentGame = qService.getGameByID(id);
        PlayerDto currentPlayer = qService.healPlayer(currentGame.getPlayer().getId());
        if (currentPlayer!=null){
            return Response.ok(currentPlayer).build();
        }
        return Response.noContent().build();

    }
}
