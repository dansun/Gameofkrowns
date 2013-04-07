package nu.danielsundberg.gameofkrowns.business.service;

import nu.danielsundberg.gameofkrowns.application.exception.*;
import nu.danielsundberg.gameofkrowns.application.service.GameofKrownsControllServiceV1;
import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.Player;
import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Game of Krowns REST api V1
 */
@Path("gamecontrollservice")
public interface GameofKrownsControllServiceJSONV1 extends GameofKrownsControllServiceV1 {

    @GET
    @Path("player")
    @Produces(MediaType.APPLICATION_JSON)
    @BadgerFish
    @Override
    public Player getPlayer(
            @QueryParam("playerName") String playerName,
            @QueryParam("password") String password)
    throws
            PlayerNotFoundException,
            WrongPasswordException;

    @GET
	@Path("game/active")
    @Produces(MediaType.APPLICATION_JSON)
    @BadgerFish
	@Override
	public Set<Game> getActiveGamesForPlayer(
			@QueryParam("playerId") Long playerId,
			@QueryParam("password") String password)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException;

	@PUT
	@Path("player")
    @Produces(MediaType.APPLICATION_JSON)
	@BadgerFish
	@Override
	public Player registerPlayer(
			@QueryParam("playerName") String playerName,
			@QueryParam("password") String password)
	throws 
			PlayerAlreadyExistsException;

	@PUT
	@Path("game")
    @Produces(MediaType.APPLICATION_JSON)
	@BadgerFish
	@Override
	public Game createGame(
			@QueryParam("playerId") Long playerId,
			@QueryParam("password") String password,
			@QueryParam("gameName") String gameName)
	throws 
			GameAlreadyExistsException, 
			PlayerNotFoundException,
			WrongPasswordException;

	@PUT
	@Path("game/invite")
    @Produces(MediaType.APPLICATION_JSON)
	@BadgerFish
	@Override
	public void invitePlayer(
			@QueryParam("playerId") Long playerId,
			@QueryParam("password") String password,
			@QueryParam("gameId") Long gameId,
			@QueryParam("playerIdToInvite") Long playerToInvite)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException, 
			GameNotFoundException;

	@PUT
	@Path("game/accept")
    @Produces(MediaType.APPLICATION_JSON)
	@BadgerFish
	@Override
	public void acceptGame(
			@QueryParam("playerId") Long playerId,
			@QueryParam("password") String password,
			@QueryParam("gameId") Long gameId)
            throws
            PlayerNotFoundException,
            WrongPasswordException,
            GameNotFoundException,
            PlayerNotInvitedToGameException, IllegalGameStateException;
	
	@GET
	@Path("game")
    @Produces(MediaType.APPLICATION_JSON)
	@BadgerFish
	@Override
	public Game getGame(
			@QueryParam("playerId") Long playerId,
			@QueryParam("password") String password,
			@QueryParam("gameId")Long gameId)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException,
			GameNotFoundException, 
			PlayerNotInvitedToGameException;
	
	@PUT
	@Path("game/bribe")
    @Produces(MediaType.APPLICATION_JSON)
	@BadgerFish
	@Override
	public void reportBribeMove(
			@QueryParam("playerId") Long playerId,
			@QueryParam("password") String password,
			@QueryParam("gameId") Long gameId,
            @QueryParam("turnId") Long turnId,
			@QueryParam("countyName") String countyName,
			@QueryParam("amount") BigDecimal amount)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException,
			GameNotFoundException, 
			PlayerNotInvitedToGameException,
			IllegalMoveException;
	
	@GET
	@Path("game/propaganda")
    @Produces(MediaType.APPLICATION_JSON)
	@BadgerFish
	@Override
	public void reportPropagandaMove(
			@QueryParam("playerId") Long playerId,
			@QueryParam("password") String password,
			@QueryParam("gameId") Long gameId,
            @QueryParam("turnId") Long turnId,
			@QueryParam("countyName") String countyName,
			@QueryParam("amount") BigDecimal amount)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException,
			GameNotFoundException, 
			PlayerNotInvitedToGameException,
			IllegalMoveException;
	
}