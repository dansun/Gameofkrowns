package org.hackermongo.gameofkrowns.application.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hackermongo.gameofkrowns.access.domain.Game;
import org.hackermongo.gameofkrowns.access.domain.GameEntity;
import org.hackermongo.gameofkrowns.access.domain.PlayerEntity;
import org.hackermongo.gameofkrowns.application.exception.GameAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.GameNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.IllegalMoveException;
import org.hackermongo.gameofkrowns.application.exception.PlayerAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotInvitedToGameException;
import org.hackermongo.gameofkrowns.application.exception.WrongPasswordException;
import org.hackermongo.gameofkrowns.application.service.GameofKrownsControllServiceV1;

/**
 * GameControllerService implementation
 * 
 * @author dansun
 *
 */
@Stateless(mappedName="gameofkrownsControllServiceBean-v0.0.2")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class GameofKrownsControllServiceBeanV1 implements GameofKrownsControllServiceV1, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "gameofkrownsPersistenceUnit")
    private EntityManager entityManager;
	
	/**
	 * Finds all games for specified authorized player.
	 * @param playerId
	 * @param password
	 * @return Set<Game>
	 * @throws PlayerNotFoundException
	 * @throws WrongPasswordException
	 */
	public Set<Game<?, ?, ?>> getActiveGamesForPlayer(
		Long playerId, 
		String password) 
	throws 
		PlayerNotFoundException, 
		WrongPasswordException {
		//
		// Find and validate player
		//
		PlayerEntity player = findPlayerById(playerId);
		validatePlayerPassword(player, password);
		//
		// Return games player is participating in
		//
		Set<Game<?,?,?>> games = new HashSet<Game<?,?,?>>();
		games.addAll(player.getPlayingGames());		
		return games;	
	}

	/**
	 * Registers new player with playerName and password.
	 * @param playerName
	 * @param password
	 * @return Player
	 * @throws PlayerAlreadyExistsException
	 */
	public PlayerEntity registerPlayer(
		String playerName, 
		String password) 
	throws 
		PlayerAlreadyExistsException {
		try {
			//
			// Find player, if found throw exception
			//
			findPlayerByName(playerName);
			throw new PlayerAlreadyExistsException("Player with playername "+playerName+" is already registered.");
		} catch (PlayerNotFoundException e) {
			//
			// Create new player
			//
			PlayerEntity newPlayer = new PlayerEntity();
			newPlayer.setPlayerName(playerName);
			newPlayer.setPassword(password);
			entityManager.persist(newPlayer);
			return newPlayer;
		}
	}

	/**
	 * Creates a new game with gameName for the specified authorized player
	 * @param playerId
	 * @param password
	 * @param gameName
	 * @return Game
	 * @throws GameAlreadyExistsException
	 * @throws PlayerNotFoundException 
	 * @throws WrongPasswordException 
	 */
	public GameEntity createGame(
			Long playerId, 
			String password, 
			String gameName) 
	throws 
			GameAlreadyExistsException, 
			PlayerNotFoundException, 
			WrongPasswordException {
		//
		// Find and validate player.
		//
		PlayerEntity player = findPlayerById(playerId);
		validatePlayerPassword(player, password);
		try {
			//
			// Find game, if found throw exception
			//
			findGameByName(gameName);
			throw new GameAlreadyExistsException("Game with gamename "+gameName+" is already created.");
		} catch (GameNotFoundException e) {
			//
			// Create new game.
			//
			GameEntity newGame = new GameEntity();
			newGame.setGameName(gameName);
			newGame.setOwner(player);
			newGame.getPlayers().add(player);
			entityManager.persist(newGame);
			player.getOwnedGames().add(newGame);
			player.getPlayingGames().add(newGame);
			entityManager.merge(player);
			entityManager.flush();
			entityManager.refresh(newGame);
			return newGame;
		}
	}

	/**
	 * Invites players with specified playerId´s to specified game.
	 * @param playerId
	 * @param password
	 * @param gameId
	 * @param playerIdsToInvite
	 */
	public void invitePlayers(
			Long playerId, 
			String password, 
			Long gameId, 
			Set<Long> playerIdsToInvite) 
	throws 
			PlayerNotFoundException, 
			WrongPasswordException, 
			GameNotFoundException {
		//
		// Find and validate player.
		//
		PlayerEntity player = findPlayerById(playerId);
		validatePlayerPassword(player, password);
		//
		// Find game to invite players to
		//
		GameEntity gameToInviteTo = null;
		for(GameEntity game : player.getOwnedGames()) {
			if(game.getGameId().equals(gameId)) {
				gameToInviteTo = game;
			}
		}
		if(gameToInviteTo == null) {
			throw new GameNotFoundException("Game with gameId "+gameId+" not found in players started games");
		}
		//
		// Add players, if found, to game
		//
		for(Long playerIdToInvite : playerIdsToInvite) {
			PlayerEntity playerToInvite = entityManager.find(PlayerEntity.class, playerIdToInvite);
			if(playerToInvite == null) {
				throw new PlayerNotFoundException("Invited player with playerId "+playerIdToInvite+" could not be found.");
			}
			gameToInviteTo.getInvitedPlayers().add(playerToInvite);
		}
		
	}

	public void acceptGame(
			Long playerId, 
			String password, 
			Long gameId) 
	throws 
			PlayerNotFoundException, 
			WrongPasswordException, 
			GameNotFoundException, 
			PlayerNotInvitedToGameException {
		//
		// Find and validate player.
		//
		PlayerEntity player = findPlayerById(playerId);
		validatePlayerPassword(player, password);
		//
		// Find game to accept
		//
		GameEntity gameToAccept = entityManager.find(GameEntity.class, gameId);
		if(gameToAccept == null) {
			throw new GameNotFoundException("Game to accept with gameId '"+gameId+
					"' could not be found.");
		}
		//
		// Accept game
		//
		if(gameToAccept.getInvitedPlayers().contains(player)) {
			gameToAccept.getPlayers().add(player);
		} else {
			throw new PlayerNotInvitedToGameException("Player with playerId '"+playerId+
					"' has not been invited to game with gameId '"+gameId+"'.");
		}
	}
	
	/**
	 * Finds unique player with playerName
	 * @param playerName
	 * @return Player
	 * @throws PlayerNotFoundException
	 */
	private PlayerEntity findPlayerByName(
			String playerName) 
	throws 
			PlayerNotFoundException {
		//
		// Find player with playerName and return, else throw exception
		//
		Query playerQuery = entityManager.createNamedQuery("player.findByPlayerName");
		playerQuery.setParameter("playerName", playerName);
		try {
			return (PlayerEntity) playerQuery.getSingleResult();	
		} catch (NoResultException e) {
			throw new PlayerNotFoundException("No player with playername '"+playerName+"' could be found.");
		}
	}
	
	/**
	 * Finds unique game with specified gameName
	 * @param gameName
	 * @return Game
	 * @throws GameNotFoundException
	 */
	private GameEntity findGameByName(
			String gameName) 
	throws 
			GameNotFoundException {
		//
		// Find game with gameName and return, else throw exception
		//
		Query gameQuery = entityManager.createNamedQuery("game.findByGameName");
		gameQuery.setParameter("gameName", gameName);
		try {
			return (GameEntity) gameQuery.getSingleResult();	
		} catch (NoResultException e) {
			throw new GameNotFoundException("No game with gameName '"+gameName+"' could be found.");
		}
	}
	
	/**
	 * Validates that players password is correct
	 * @param player
	 * @param password
	 * @throws WrongPasswordException
	 */
	private void validatePlayerPassword(
			PlayerEntity player, 
			String password) 
	throws 
			WrongPasswordException {
		//
		// Compare give password with that of persisted players
		//
		if(!player.getPassword().equals(password)) {
			throw new WrongPasswordException("Password for player with playerId "+player.getPlayerId()+" is wrong.");
		}
	}
	
	/**
	 * Find player by specified playerId
	 * @param playerId
	 * @return Player
	 * @throws PlayerNotFoundException
	 */
	private PlayerEntity findPlayerById(
			Long playerId) 
	throws 
			PlayerNotFoundException {
		//
		// Find player by entity ID, else throw exception
		//
		PlayerEntity player = entityManager.find(PlayerEntity.class, playerId);
		if(player==null) {
			throw new PlayerNotFoundException("Player with playerId "+playerId+" is not registered.");
		}
		return player;
	}

	@Override
	public GameEntity getGame(
			Long playerId, 
			String password, 
			Long gameId)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException,
			GameNotFoundException, 
			PlayerNotInvitedToGameException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reportBribeMove(Long playerId, String password, Long gameId,
			String countyName, BigDecimal amount)
			throws PlayerNotFoundException, WrongPasswordException,
			GameNotFoundException, PlayerNotInvitedToGameException,
			IllegalMoveException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportPropagandaMove(Long playerId, String password,
			Long gameId, String countyName, BigDecimal amount)
			throws PlayerNotFoundException, WrongPasswordException,
			GameNotFoundException, PlayerNotInvitedToGameException,
			IllegalMoveException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Get player
	 * @param playerName
	 * @param password
	 * @return Player
	 * @throws PlayerNotFoundException
	 * @throws WrongPasswordException  
	 */
	public PlayerEntity getPlayer(
			String playerName, 
			String password)
	throws 
			PlayerNotFoundException, 
			WrongPasswordException {
		PlayerEntity player = (PlayerEntity) findPlayerByName(playerName);
		validatePlayerPassword(player, password);
		return player;
	}
	
}