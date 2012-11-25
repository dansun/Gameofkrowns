package org.hackermongo.gameofkrowns.application.service;

import java.util.Set;

import org.hackermongo.gameofkrowns.access.domain.Game;
import org.hackermongo.gameofkrowns.access.domain.Player;
import org.hackermongo.gameofkrowns.application.exception.GameAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.GameNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotInvitedToGameException;
import org.hackermongo.gameofkrowns.application.exception.WrongPasswordException;

/**
 * GameControllService interface
 * 
 * @author dansun
 *
 */
public abstract interface GameofKrownsControllServiceV1 {
	
	/**
	 * Gets games for given player ID.
	 * @param playerId
	 * @param password
	 * @return Set<Game>
	 * @throws PlayerNotFoundException
	 * @throws WrongPasswordException
	 */
	public Set<Game> getActiveGamesForPlayer(
		Long playerId, 
		String password) 
	throws 
		PlayerNotFoundException, 
		WrongPasswordException;
	
	/**
	 * Registers a new player.
	 * @param playerName
	 * @param password
	 * @return Player
	 * @throws PlayerAlreadyExistsException
	 */
	public Player registerPlayer(
		String playerName, 
		String password) 
	throws 
		PlayerAlreadyExistsException;
	
	/**
	 * Creates a new game, registering player will automatically be added to the game.
	 * @param playerId
	 * @param password
	 * @param gameName
	 * @return Game
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
		WrongPasswordException;
	
	/**
	 * Invite players to created game.
	 * @param playerId
	 * @param password
	 * @param gameId
	 * @param playersToInvite
	 * @throws PlayerNotFoundException 
	 * @throws WrongPasswordException 
	 * @throws GameNotFoundException 
	 */
	public void invitePlayers(
		Long playerId, 
		String password, 
		Long gameId, 
		Set<Long> playersToInvite) 
	throws 
		PlayerNotFoundException, 
		WrongPasswordException, 
		GameNotFoundException;
	
	/**
	 * Accept invitation to game.
	 * @param playerId
	 * @param password
	 * @param gameId
	 * @throws PlayerNotFoundException 
	 * @throws WrongPasswordException 
	 * @throws GameNotFoundException 
	 * @throws PlayerNotInvitedToGameException 
	 */
	public void acceptGame(
		Long playerId, 
		String password, 
		Long gameId) 
	throws 
		PlayerNotFoundException, 
		WrongPasswordException, 
		GameNotFoundException, 
		PlayerNotInvitedToGameException;

}
