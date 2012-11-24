package org.hackermongo.gameofkrowns.application.service;

import java.util.Set;

import org.hackermongo.gameofkrowns.access.domain.Game;
import org.hackermongo.gameofkrowns.access.domain.Player;
import org.hackermongo.gameofkrowns.application.exception.GameAllreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerAllreadyExistsException;
import org.hackermongo.gameofkrowns.application.exception.PlayerNotFoundException;
import org.hackermongo.gameofkrowns.application.exception.WrongPasswordException;

import org.hackermongo.gok.model.*;

/**
 * GameControllService interface
 * 
 * @author dansun och sigge
 *
 */
public interface GameofKrownsControllService {
	
	 /**
	  * Returns an object with the result of the login
	  * @param userId
	  * @param password
	  * @return LoginResult
	  */
	 public LoginResult authenticate(String userId, String password);
	 
	 /**
	  * Returns an object with the result of the login
	  * @param userId
	  * @param email
	  * @param password
	  * @return LoginResult
	  */
	 public LoginResult registerUser(String userId, String email, String password);
	 
	 /**
	  * Returns an object with the number of active games for the user
	  * @param userId
	  * @param password
	  * @return LoginResult
	  */
	 public UserGeneralStatus getGeneralStatus(String userId, String password);
	 
	 /**
	  * Returns a list with the active games for the user
	  * @param userId
	  * @param password
	  * @return ArrayList<Game>
	  */
	 public ArrayList<Game> getActiveGames(String userId, String password);
	 
	 /**
	  * Returns a list of friends for the user
	  * @param userId
	  * @param password
	  * @return ArrayList<Friend>
	  */
	 public ArrayList<Friend> getFriends(String userId, String password);
	 
	 /**
	  * Requests the ID for a game to be created. If allowRandoms is true, the server will try to fill out to four players
	  * with random players looking for games
	  * @param userId
	  * @param password
	  * @param allowRandoms
	  * @param userids
	  * @return long
	  */
	 public long createGame(String userId, long password, boolean allowRandoms, ArrayList<String> userids);
	 
	 /**
	  * Fetches the requested game
	  * @param userId
	  * @param password
	  * @param gameId
	  * @return Game
	  */
	 public Game fetchGame(String userId, long password,long gameId);
	 
	 /**
	  * Gets the invitations that the user is currently involved in
	  * @param userId
	  * @param password
	  * @return ArrayList<Invitation>
	  */
	 public ArrayList<Invitation> getInvitations(String userId, String password);
	 
	 /**
	  * Gets the invitations that the user is currently involved in
	  * @param userId
	  * @param password
	  * @param invitationId
	  * @param accept
	  * @return ArrayList<Invitation>
	  */
	 public long respondToInvitation(String userId, String password,long invitationId,boolean accept);

	 /**
	  * Gets the history for the specified turn
	  * @param userId
	  * @param password
	  * @param gameId
	  * @param turnIndex
	  * @return ArrayList<HistoryEvent>
	  */
	 public ArrayList<HistoryEvent> getHistory(String userId, String password,long gameId,long turnIndex);
	 
	 /**
	  * Performs the action for the user. If action is not allowed, unchanged game obj is returned
	  * @param userId
	  * @param password
	  * @param gameId
	  * @param regionId
	  * @param actionId
	  * @return Game
	  */
	 public Game performAction(String userId,String password,String gameId,String regionId,String actionId);
}
