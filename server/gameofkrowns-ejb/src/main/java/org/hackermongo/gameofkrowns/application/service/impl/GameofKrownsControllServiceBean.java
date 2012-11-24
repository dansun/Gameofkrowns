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
 * @author dansun och sigge
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
	
	
	
	/**
	  * Returns an object with the result of the login
	  * @param userId
	  * @param password
	  * @return LoginResult
	  */
	@Override
	public LoginResult authenticate(String userId, String password) {
		 // Verify userId and password against db
		 return new LoginResult();
	 }
	 
	/**
	  * Returns an object with the result of the login
	  * @param userId
	  * @param email
	  * @param password
	  * @return LoginResult
	  */
	@Override
	 public LoginResult registerUser(String userId, String email, String password) {
		// Create user in database
		return new LoginResult();
	}
	 
	/**
	  * Returns an object with the number of active games for the user
	  * @param userId
	  * @param password
	  * @return LoginResult
	  */
	@Override
	 public UserGeneralStatus getGeneralStatus(String userId, String password){
		// Find out how many games that are active for the user and populate the return object
		return new UserGeneralStatus();
	}
	 
	/**
	  * Returns a list with the active games for the user
	  * @param userId
	  * @param password
	  * @return ArrayList<Game>
	  */
	@Override
	public ArrayList<Game> getActiveGames(String userId, String password){
		// Get the list of games that are active for the provided user
		return new ArrayList<Game>();
	}
	 
	/**
	  * Returns a list of friends for the user
	  * @param userId
	  * @param password
	  * @return ArrayList<Friend>
	  */
	@Override
	public ArrayList<Friend> getFriends(String userId, String password){
		// Get all the friends for the provided user
		return new ArrayList<Friend>();
	}
	 
	/**
	  * Requests the ID for a game to be created. If allowRandoms is true, the server will try to fill out to four players
	  * with random players looking for games
	  * @param userId
	  * @param password
	  * @param allowRandoms
	  * @param userids
	  * @return long
	  */
	@Override
	public long createGame(String userId, long password, boolean allowRandoms, ArrayList<String> userids) {
		// Create a new game in the database
		// Create invitations for the users in userids
		// If random players are allowed, see if other pending games can be merged
		return 0;
	}
	 
	/**
	  * Fetches the requested game
	  * @param userId
	  * @param password
	  * @param gameId
	  * @return Game
	  */
	@Override
	public Game fetchGame(String userId, long password,long gameId) {
		// Fetch the game object from the database
		return new Game();
	}
	 
	/**
	  * Gets the invitations that the user is currently involved in
	  * @param userId
	  * @param password
	  * @return ArrayList<Invitation>
	  */
	@Override
	public ArrayList<Invitation> getInvitations(String userId, String password) {
		//Gets the invitations for the provided user
		return new ArrayList<Invitation>();
	}
	 
	 /**
	  * Gets the invitations that the user is currently involved in
	  * @param userId
	  * @param password
	  * @param invitationId
	  * @param accept
	  * @return ArrayList<Invitation>
	  */
	 public long respondToInvitation(String userId, String password,long invitationId,boolean accept) {
		 // Updates the invitation object
		 // If the game is not full, see if this invitation can be merged with another (if randoms are wanted)
		 // If the game is full, create a game object and notify the clients with push
	 }

	/**
	  * Gets the history for the specified turn
	  * @param userId
	  * @param password
	  * @param gameId
	  * @param turnIndex
	  * @return ArrayList<HistoryEvent>
	  */
	@Override
	public ArrayList<HistoryEvent> getHistory(String userId, String password,long gameId,long turnIndex) {
		// Get the history entries that is requested. (For all userids with the provided game and turn)
		return new ArrayList<HistoryEvent>();
	}
	 
	/**
	  * Performs the action for the user. If action is not allowed, unchanged game obj is returned
	  * @param userId
	  * @param password
	  * @param gameId
	  * @param regionId
	  * @param actionId
	  * @return Game
	  */
	@Override
	public Game performAction(String userId,String password,long gameId,long regionId,long actionId) {
		if(actionId == 1) {
			// Vanligt partiarbete
		} else if (actionId == 2) {
			// Dra en löpsedel
		}
		// Om spelaren redan gjort sitt drag för denna runda, be honom dra åt helvete
		// Om inte alla gjort sitt drag, spara undan detta drag
		// Om alla gjort sina drag skapa history entries och uppdatera game obj
		// Bedöm om matchen är avgjord eller inte
		// Returnera senaste status till spelaren
		return new Game();
	}
	
}