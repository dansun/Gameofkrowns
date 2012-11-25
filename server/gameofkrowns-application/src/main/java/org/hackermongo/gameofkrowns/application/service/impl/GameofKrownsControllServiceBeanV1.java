package org.hackermongo.gameofkrowns.application.service.impl;

import java.io.Serializable;
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
import org.hackermongo.gameofkrowns.application.exception.GameAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.GameNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotInvitedToGameException;
import org.hackermongo.gameofkrowns.application.exception.PlayerAlreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
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
	public Set<Game> getActiveGamesForPlayer(
		Long playerId, 
		String password) 
	throws 
		PlayerNotFoundException, 
		WrongPasswordException {
		//
		// Find and validate player
		//
		Player player = findPlayerById(playerId);
		validatePlayerPassword(player, password);
		//
		// Return games player is participating in
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
	 * @throws PlayerAlreadyExistsException
	 */
	public Player registerPlayer(
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
			throw new GameAlreadyExistsException("Game with gamename "+gameName+" is already created.");
		} catch (GameNotFoundException e) {
			//
			// Create new game.
			//
			Game newGame = new Game();
			newGame.setGameName(gameName);
			newGame.setOwner(player);
			newGame.getPlayers().add(player);
			player.getOwnedGames().add(newGame);
			player.getPlayingGames().add(newGame);
			entityManager.persist(newGame);
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
		Player player = findPlayerById(playerId);
		validatePlayerPassword(player, password);
		//
		// Find game to invite players to
		//
		Game gameToInviteTo = null;
		for(Game game : player.getOwnedGames()) {
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
			Player playerToInvite = entityManager.find(Player.class, playerIdToInvite);
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
		Player player = findPlayerById(playerId);
		validatePlayerPassword(player, password);
		//
		// Find game to accept
		//
		Game gameToAccept = entityManager.find(Game.class, gameId);
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
	private Player findPlayerByName(
		String playerName) 
	throws 
		PlayerNotFoundException {
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
	private Game findGameByName(
		String gameName) 
	throws 
		GameNotFoundException {
		//
		// Find game with gameName and return, else throw exception
		//
		Query gameQuery = entityManager.createNamedQuery("game.findByGameName");
		gameQuery.setParameter("gameName", gameName);
		try {
			return (Game) gameQuery.getSingleResult();	
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
		Player player, 
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
	private Player findPlayerById(
		Long playerId) 
	throws 
		PlayerNotFoundException {
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