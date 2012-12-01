package org.hackermongo.gameofkrowns.business.service;

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
import org.hackermongo.gameofkrowns.application.exception.PlayerAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotInvitedToGameException;
import org.hackermongo.gameofkrowns.application.exception.WrongPasswordException;
import org.hackermongo.gameofkrowns.application.service.GameofKrownsControllServiceV1;
import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

@Path("gamecontrollservice")
public interface GameofKrownsControllServiceJSONV1 extends GameofKrownsControllServiceV1 {

	@GET
	@Path("player/{playerId}/password/{password}/activegames")
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
	@Path("register/player/{playerName}/password/{password}")
	@Produces("application/json")
	@BadgerFish
	@Override
	public Player<?> registerPlayer(
		@PathParam("playerName") String playerName, 
		@PathParam("password") String password) 
	throws 
		PlayerAlreadyExistsException;

	@GET
	@Path("register/player/{playerId}/password/{password}/game/{gameName}")
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
	@Path("player/{playerId}/password/{password}/game/{gameId}/invite/{playerIdsToInvite}")
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
	@Path("player/{playerId}/password/{password}/game/{gameId}/accept")
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
	
}