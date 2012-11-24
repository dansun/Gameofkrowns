package org.hackermongo.gok.model;

/*
 * OBSOLETE DO NOT USE!!! Use the webservice instead, same stuff but working
 * 
 */

import java.util.ArrayList;

public class MockupApi {
	 public MockupApi () {
		 
	 }
	 
	 /*
	  * Returns an object with a valid session id, or an error code
	  */
	 public LoginResult authenticate(String userId, String password) {
		 return new LoginResult(123,0);
	 }
	 
	 /*
	  * Registers a user and returns an object with a valid session id, or an error code
	  */
	 public LoginResult registerUser(String userId, String email, String password) {
		 return new LoginResult(123,0);
	 }
	 
	 /*
	  * Returns the match status for the player
	  */
	 public UserGeneralStatus getGeneralStatus(String userId, String password) {
		 return new UserGeneralStatus(1,3);
	 }
	 
	 /*
	  *  Returns the games that are currently active for the user
	  */
	 public ArrayList<ActiveGame> getActiveGames(String userId, String password) {
		 return new ArrayList<ActiveGame>();
	 }
	 
	 /*
	  * Returns the friends of this user. Gustaf does not have any friends. His penis is too small.
	  */
	 public ArrayList<Friend> getFriends(String userId, String password) {
		 return new ArrayList<Friend>();
	 }
	 
	 /*
	  * Requests the ID for a game to be created. If allowRandoms is true, the server will try to fill out to four players
	  * with random players looking for games
	  */
	 public long createGame(String userId, long password, boolean allowRandoms, ArrayList<String> userids) {
		 return 0;
	 }
	 
	 /*
	  * Fetches the game
	  */
	 public Game fetchGame(long gameId) {
		 return new Game();
	 }
	 
	 /*
	  * Gets the invitations that the user is currently involved in
	  */
	 public ArrayList<Invitation> getInvitations(String userId, String password) {
		 return new ArrayList<Invitation>();
	 }
	 
	 /*
	  * Gets the history for the specified turn
	  */
	 public ArrayList<HistoryEvent> getHistory(String userId, String password,long gameId,long turnIndex) {
		 return new ArrayList<HistoryEvent>();
	 }
	 
	 /*
	  * Performs the action for the user. If action is not allowed, unchanged game obj is returned
	  */
	 public Game performAction(String userId,String password,String gameId,String regionId,String actionId) {
		 return new Game();
	 }
	
}