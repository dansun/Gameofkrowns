package nu.danielsundberg.gameofkrowns.application.service;

import nu.danielsundberg.gameofkrowns.application.exception.*;
import nu.danielsundberg.gameofkrowns.domain.Game;
import nu.danielsundberg.gameofkrowns.domain.Player;

import java.math.BigDecimal;
import java.util.Set;

/**
 * GameControllService interface V1
 */
public interface GameofKrownsControllServiceV1 {
	
	/**
	 * Gets games for given player ID.
	 * @param playerId
	 * @param password
	 * @return Set<Game>
	 * @throws PlayerNotFoundException
	 * @throws WrongPasswordException
     * @return All active games for player.
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
     * @return Registered player.
	 */
	public Player registerPlayer(
			String playerName, 
			String password) 
	throws 
			PlayerAlreadyExistsException;
	
	/**
	 * Get a player.
	 * @param playerName
	 * @param password
	 * @return Player
	 * @throws PlayerNotFoundException
     * @throws WrongPasswordException
     * @return Found player.
	 */
	public Player getPlayer(
			String playerName, 
			String password) 
	throws 
			PlayerNotFoundException,
			WrongPasswordException;
	
	/**
	 * Creates a new game, registering player will automatically be added to the game.
	 * @param playerId
	 * @param password
	 * @param gameName
	 * @return Game
	 * @throws GameAlreadyExistsException
	 * @throws PlayerNotFoundException
	 * @throws WrongPasswordException
     * @return Created game.
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
	 * @param playerToInvite
	 * @throws PlayerNotFoundException 
	 * @throws WrongPasswordException 
	 * @throws GameNotFoundException 
	 */
	public void invitePlayer(
			Long playerId, 
			String password, 
			Long gameId, 
			Long playerToInvite)
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
            PlayerNotInvitedToGameException, IllegalGameStateException;
	
	/**
	 * Get game.
	 * @param playerId
	 * @param password
	 * @param gameId
	 * @throws PlayerNotFoundException
	 * @throws WrongPasswordException
	 * @throws GameNotFoundException
	 * @throws PlayerNotInvitedToGameException
     * @return Found game.
	 */
	public Game getGame(
			Long playerId,
			String password,
			Long gameId)
	throws
			PlayerNotFoundException,
			WrongPasswordException,
			GameNotFoundException,
			PlayerNotInvitedToGameException;

	/**
	 * Report a bribe move
     * @param playerId Reporting player ID.
     * @param password Reporting player password.
     * @param gameId Game to register move for.
     * @param turnId Turn in game to register move for.
     * @param countyName County in game to register move on.
     * @param amount Amount to register.
	 * @throws PlayerNotFoundException
	 * @throws WrongPasswordException
	 * @throws GameNotFoundException
	 * @throws PlayerNotInvitedToGameException
	 * @throws IllegalMoveException
	 */
	public void reportBribeMove(
			Long playerId,
			String password,
			Long gameId,
            Long turnId,
            String countyName,
			BigDecimal amount)
	throws
			PlayerNotFoundException,
			WrongPasswordException,
			GameNotFoundException,
			PlayerNotInvitedToGameException,
			IllegalMoveException;

	/**
	 * Report a propaganda move
	 * @param playerId Reporting player ID.
	 * @param password Reporting player password.
	 * @param gameId Game to register move for.
     * @param turnId Turn in game to register move for.
	 * @param countyName County in game to register move on.
	 * @param amount Amount to register.
	 * @throws PlayerNotFoundException
	 * @throws WrongPasswordException
	 * @throws GameNotFoundException
	 * @throws PlayerNotInvitedToGameException
	 * @throws IllegalMoveException
	 */
	public void reportPropagandaMove(
			Long playerId,
			String password,
			Long gameId,
            Long turnId,
			String countyName,
			BigDecimal amount)
		throws
			PlayerNotFoundException,
			WrongPasswordException,
			GameNotFoundException,
			PlayerNotInvitedToGameException,
			IllegalMoveException;
	
}
