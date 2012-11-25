package org.hackermongo.gameofkrowns.business.service;

import java.util.Set;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.hackermongo.gameofkrowns.access.domain.Game;
import org.hackermongo.gameofkrowns.access.domain.Player;
import org.hackermongo.gameofkrowns.application.exception.GameAllreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerAllreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.WrongPasswordException;
import org.hackermongo.gameofkrowns.application.service.GameofKrownsControllServiceV1;
import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

@Path("gamecontrollservice")
public class GameControllServiceJSONV1 implements GameofKrownsControllServiceV1 {

	@EJB(mappedName="gameofkrownsControllServiceBean-v0.0.2")
	private GameofKrownsControllServiceV1 serviceBean;
	
	@GET
	@Path("player/{playerId}/password/{password}/activegames")
	@Produces("application/json")
	@BadgerFish
	public Set<Game> getActiveGamesForPlayer(
			@PathParam("playerId") Long playerId, 
			@PathParam("password") String password)
			throws PlayerNotFoundException, WrongPasswordException {
		return serviceBean.getActiveGamesForPlayer(playerId, password);
	}

	@GET
	@Path("register/player/{playerName}/password/{password}")
	@Produces("application/json")
	@BadgerFish
	public Player registerPlayer(
			@PathParam("playerName") String playerName, 
			@PathParam("password") String password) 
	throws PlayerAllreadyExistsException {
		return serviceBean.registerPlayer(playerName, password);
	}

	@GET
	@Path("register/player/{playerId}/password/{password}/game/{gameName}")
	@Produces("application/json")
	@BadgerFish
	public Game createGame(
			@PathParam("playerId") Long playerId, 
			@PathParam("password") String password, 
			@PathParam("gameName") String gameName)
	throws 
		GameAllreadyExistsException, 
		PlayerNotFoundException,
		WrongPasswordException {
		return serviceBean.createGame(playerId, password, gameName);
	}

	@PUT
	@Path("player/{playerId}/password/{password}/game/{gameId}/invite/{playerIdsToInvite}")
	@Produces("application/json")
	@BadgerFish
	public void invitePlayers(
			@PathParam("playerId") Long playerId, 
			@PathParam("password") String password, 
			@PathParam("gameId") Long gameId,
			@QueryParam("playersToInvite") Set<Long> playersToInvite) {
		serviceBean.invitePlayers(playerId, password, gameId, playersToInvite);
	}

	@PUT
	@Path("player/{playerId}/password/{password}/game/{gameId}/accept")
	@Produces("application/json")
	@BadgerFish
	public void acceptGame(
			Long playerId, 
			String password, 
			Long gameId) {
		serviceBean.acceptGame(playerId, password, gameId);
	}
	
}