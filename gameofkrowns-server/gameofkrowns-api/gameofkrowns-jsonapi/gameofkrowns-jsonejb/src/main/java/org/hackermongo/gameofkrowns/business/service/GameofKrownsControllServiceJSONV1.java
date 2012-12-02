package org.hackermongo.gameofkrowns.business.service;

import java.math.BigDecimal;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.hackermongo.gameofkrowns.access.domain.Game;
import org.hackermongo.gameofkrowns.access.domain.Player;
import org.hackermongo.gameofkrowns.application.exception.GameAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.GameNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.IllegalMoveException;
import org.hackermongo.gameofkrowns.application.exception.PlayerAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotInvitedToGameException;
import org.hackermongo.gameofkrowns.application.exception.WrongPasswordException;
import org.hackermongo.gameofkrowns.application.service.GameofKrownsControllServiceV1;
import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

@Path("gamecontrollservice")
public interface GameofKrownsControllServiceJSONV1 extends GameofKrownsControllServiceV1 {

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
	@Path("report/bribe/{countyName}/with/{amount}/for/player/{playerId}/with/password/{password}/for/game/{gameId}")
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
	@Path("report/bribe/{countyName}/with/{amount}/for/player/{playerId}/with/password/{password}/for/game/{gameId}")
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