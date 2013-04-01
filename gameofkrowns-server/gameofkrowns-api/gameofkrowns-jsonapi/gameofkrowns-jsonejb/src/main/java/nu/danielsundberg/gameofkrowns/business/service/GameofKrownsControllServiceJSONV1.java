package nu.danielsundberg.gameofkrowns.business.service;

import nu.danielsundberg.gameofkrowns.application.exception.*;
import nu.danielsundberg.gameofkrowns.application.service.GameofKrownsControllServiceV1;
import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.Player;
import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

import javax.ws.rs.*;
import java.math.BigDecimal;
import java.util.Set;

@Path("gamecontrollservice")
public interface GameofKrownsControllServiceJSONV1 extends GameofKrownsControllServiceV1 {

    @GET
    @Path("get/player/with/playername/{playerName}/and/password/{password}")
    @Produces("application/json")
    @BadgerFish
    @Override
    Player<?> getPlayer(
            @PathParam("playerName") String playerName,
            @PathParam("password") String password)
    throws
            PlayerNotFoundException,
            WrongPasswordException;

    @GET
	@Path("get/active/games/for/player/{playerId}/with/password/{password}")
	@Produces("application/json")
	@BadgerFish
	@Override
	public Set<Game<?, ?, ?>> getActiveGamesForPlayer(
			@PathParam("playerId") Long playerId, 
			@PathParam("password") String password)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException;

	@GET
	@Path("register/player/with/playername/{playerName}/and/password/{password}")
	@Produces("application/json")
	@BadgerFish
	@Override
	public Player<?> registerPlayer(
			@PathParam("playerName") String playerName, 
			@PathParam("password") String password) 
	throws 
			PlayerAlreadyExistsException;

	@GET
	@Path("register/game/with/gamename/{gameName}/for/player/{playerId}/with/password/{password}")
	@Produces("application/json")
	@BadgerFish
	@Override
	public Game<?,?,?> createGame(
			@PathParam("playerId") Long playerId, 
			@PathParam("password") String password, 
			@PathParam("gameName") String gameName)
	throws 
			GameAlreadyExistsException, 
			PlayerNotFoundException,
			WrongPasswordException;

	@PUT
	@Path("invite/players/{playerIdsToInvite}/to/game/{gameId}/for/player/{playerId}/with/password/{password}")
	@Produces("application/json")
	@BadgerFish
	@Override
	public void invitePlayers(
			@PathParam("playerId") Long playerId, 
			@PathParam("password") String password, 
			@PathParam("gameId") Long gameId,
			@PathParam("playersToInvite") Set<Long> playersToInvite)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException, 
			GameNotFoundException;

	@PUT
	@Path("accept/invitation/to/game/{gameId}/for/player/{playerId}/with/password/{password}")
	@Produces("application/json")
	@BadgerFish
	@Override
	public void acceptGame(
			@PathParam("playerId") Long playerId, 
			@PathParam("password") String password, 
			@PathParam("gameId") Long gameId)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException, 
			GameNotFoundException, 
			PlayerNotInvitedToGameException;
	
	@GET
	@Path("get/game/{gameId}/for/player/{playerId}/with/password/{password}")
	@Produces("application/json")
	@BadgerFish
	@Override
	public Game<?, ?, ?> getGame(
			@PathParam("playerId") Long playerId, 
			@PathParam("password") String password, 
			@PathParam("gameId")Long gameId)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException,
			GameNotFoundException, 
			PlayerNotInvitedToGameException;
	
	@PUT
	@Path("report/bribe/in/county/{countyName}/with/{amount}/for/player/{playerId}/with/password/{password}/for/game/{gameId}")
	@Produces("application/json")
	@BadgerFish
	@Override
	public void reportBribeMove(
			@PathParam("playerId") Long playerId, 
			@PathParam("password") String password, 
			@PathParam("gameId") Long gameId,
			@PathParam("countyName") String countyName, 
			@PathParam("amount") BigDecimal amount)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException,
			GameNotFoundException, 
			PlayerNotInvitedToGameException,
			IllegalMoveException;
	
	@PUT
	@Path("report/propaganda/in/county/{countyName}/with/{amount}/for/player/{playerId}/with/password/{password}/for/game/{gameId}")
	@Produces("application/json")
	@BadgerFish
	@Override
	public void reportPropagandaMove(
			@PathParam("playerId") Long playerId, 
			@PathParam("password") String password,
			@PathParam("gameId") Long gameId, 
			@PathParam("countyName") String countyName, 
			@PathParam("amount") BigDecimal amount)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException,
			GameNotFoundException, 
			PlayerNotInvitedToGameException,
			IllegalMoveException;
	
}