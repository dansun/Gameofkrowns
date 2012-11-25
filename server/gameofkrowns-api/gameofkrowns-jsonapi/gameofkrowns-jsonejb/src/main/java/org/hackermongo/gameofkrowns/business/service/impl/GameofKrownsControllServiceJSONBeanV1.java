package org.hackermongo.gameofkrowns.business.service.impl;

import java.util.Set;

import javax.ejb.Stateless;

import org.hackermongo.gameofkrowns.access.domain.Game;
import org.hackermongo.gameofkrowns.access.domain.Player;
import org.hackermongo.gameofkrowns.application.exception.GameAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.GameNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotInvitedToGameException;
import org.hackermongo.gameofkrowns.application.exception.WrongPasswordException;
import org.hackermongo.gameofkrowns.application.service.impl.GameofKrownsControllServiceBeanV1;
import org.hackermongo.gameofkrowns.business.service.GameofKrownsControllServiceJSONV1;

@Stateless(mappedName="gameofkrownsControllServiceJSONBeanV1")
public class GameofKrownsControllServiceJSONBeanV1 extends GameofKrownsControllServiceBeanV1 implements GameofKrownsControllServiceJSONV1 {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Gets active games for player from central bean.
	 * @param playerId
	 * @param password
	 * @return Set of active games
	 * @throws PlayerNotFoundException
	 * @throws WrongPasswordException
	 */
	public Set<Game> getActiveGamesForPlayer(
		Long playerId, 
		String password)
	throws 
		PlayerNotFoundException, 
		WrongPasswordException {
		return super.getActiveGamesForPlayer(playerId, password);
	}

	/**
	 * Registers player with central bean
	 * @param playerName
	 * @param password
	 * @return Registered player
	 * @throws PlayerAlreadyExistsException 
	 */
	public Player registerPlayer(
		String playerName, 
		String password)
	throws 
		PlayerAlreadyExistsException {
		return super.registerPlayer(playerName, password);
	}

	/**
	 * Creates game with central bean
	 * @param playerId
	 * @param password
	 * @param gameName
	 * @return Created game
	 * @throws GameAlreadyExistsException
	 * @throws PlayerNotFoundException
	 * @throws WrongPasswordException
	 */
	public Game createGame(
		Long playerId, 
		String password, 
		String gameName)
	throws 
		GameAlreadyExistsException, 
		PlayerNotFoundException,
		WrongPasswordException {
		return super.createGame(playerId, password, gameName);
	}

	/**
	 * Invites players to created game with central bean
	 * @param playerId
	 * @param password
	 * @param gameId
	 * @param playersToInvite
	 * @throws GameNotFoundException 
	 * @throws WrongPasswordException 
	 * @throws PlayerNotFoundException 
	 */
	public void invitePlayers(
		Long playerId, 
		String password, 
		Long gameId,
		Set<Long> playersToInvite) 
	throws 
		PlayerNotFoundException, 
		WrongPasswordException, 
		GameNotFoundException {
		super.invitePlayers(playerId, password, gameId, playersToInvite);
	}

	/**
	 * Accept game with central bean
	 * @param playerId
	 * @param password
	 * @param gameId
	 * @throws PlayerNotInvitedToGameException 
	 * @throws GameNotFoundException 
	 * @throws WrongPasswordException 
	 * @throws PlayerNotFoundException 
	 */
	public void acceptGame(
		Long playerId, 
		String password, 
		Long gameId) 
	throws 
		PlayerNotFoundException, 
		WrongPasswordException, 
		GameNotFoundException, 
		PlayerNotInvitedToGameException {
		super.acceptGame(playerId, password, gameId);
	}
	
}