package org.hackermongo.gameofkrowns.application.service.impl;

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
import org.hackermongo.gameofkrowns.access.domain.Player;
import org.hackermongo.gameofkrowns.application.exception.GameAllreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.GameNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerAllreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.WrongPasswordException;
import org.hackermongo.gameofkrowns.application.service.GameofKrownsControllService;

/**
 * GameControllerService implementation
 * 
 * @author dansun
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class GameofKrownsControllServiceBean implements GameofKrownsControllService {

	@PersistenceContext(unitName = "gameofkrownsPersistenceUnit")
    private EntityManager entityManager;
    
	/**
	 * Set entitymanager reference, used for mocking the likes
	 * @param entityManager
	 */
	public void setEntityManager(final EntityManager entityManager) {
            this.entityManager = entityManager;
    }

	/**
	 * Finds all games for specified authorized player.
	 * @param playerId
	 * @param password
	 * @return Set<Game>
	 * @throws PlayerNotFoundException
	 * @throws WrongPasswordException
	 */
	@Override
	public Set<Game> getActiveGamesForPlayer(Long playerId, String password) throws PlayerNotFoundException, WrongPasswordException {
		//
		// Find and validate player
		//
		Player player = findPlayerById(playerId);
		validatePlayerPassword(player, password);
		//
		// Return games player is partisipating in
		//
		Set<Game> games = new HashSet<Game>();
		games.addAll(player.getPlayingGames());		
		return games;	
	}

	/**
	 * Registers new player with playerName and password.
	 * @param playerName
	 * @param password
	 * @return Player
	 * @throws PlayerAllreadyExistsException
	 */
	@Override
	public Player registerPlayer(String playerName, String password) throws PlayerAllreadyExistsException {
		try {
			//
			// Find player, if found throw exception
			//
			findPlayerByName(playerName);
			throw new PlayerAllreadyExistsException("Player with playername "+playerName+" is allready registered.");
		} catch (PlayerNotFoundException e) {
			//
			// Create new player
			//
			Player newPlayer = new Player();
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
	 * @throws GameAllreadyExistsException
	 * @throws PlayerNotFoundException 
	 * @throws WrongPasswordException 
	 */
	@Override
	public Game createGame(Long playerId, String password, String gameName) throws GameAllreadyExistsException, PlayerNotFoundException, WrongPasswordException {
		//
		// Find and validate player.
		//
		Player player = findPlayerById(playerId);
		validatePlayerPassword(player, password);
		try {
			//
			// Find game, if found throw exception
			//
			findGameByName(gameName);
			throw new GameAllreadyExistsException("Game with gamename "+gameName+" is allready created.");
		} catch (GameNotFoundException e) {
			//
			// Create new game.
			//
			Game newGame = new Game();
			newGame.setGameName(gameName);
			newGame.setOwner(player);
			newGame.getPlayers().add(player);
			entityManager.persist(newGame);
			entityManager.flush();
			entityManager.refresh(newGame);
			return newGame;
		}
	}

	@Override
	public void invitePlayers(Long playerId, String password, Long gameId, Set<Player> playersToInvite) {
		// TODO Implement invitation of players.
		
	}

	@Override
	public void acceptGame(Long playerId, String password, Long gameId) {
		// TODO Implement acceptance of game invite.
		
	}
	
	/**
	 * Finds unique player with playerName
	 * @param playerName
	 * @return Player
	 * @throws PlayerNotFoundException
	 */
	private Player findPlayerByName(String playerName) throws PlayerNotFoundException {
		//
		// Find player with playerName and return, else throw exception
		//
		Query playerQuery = entityManager.createNamedQuery("player.findByPlayerName");
		playerQuery.setParameter("playerName", playerName);
		try {
			return (Player) playerQuery.getSingleResult();	
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
	private Game findGameByName(String gameName) throws GameNotFoundException {
		//
		// Find game with gameName and return, else throw exception
		//
		Query gameQuery = entityManager.createNamedQuery("game.findByGameName");
		gameQuery.setParameter("gameName", gameName);
		try {
			return (Game) gameQuery.getSingleResult();	
		} catch (NoResultException e) {
			throw new GameNotFoundException("No game with gamename '"+gameName+"' could be found.");
		}
	}
	
	/**
	 * Validates that players password is correct
	 * @param player
	 * @param password
	 * @throws WrongPasswordException
	 */
	private void validatePlayerPassword(Player player, String password) throws WrongPasswordException {
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
	private Player findPlayerById(Long playerId) throws PlayerNotFoundException {
		//
		// Find player by entity ID, else throw exception
		//
		Player player = entityManager.find(Player.class, playerId);
		if(player==null) {
			throw new PlayerNotFoundException("Player with playerId "+playerId+" is not registered.");
		}
		return player;
	}
	
}