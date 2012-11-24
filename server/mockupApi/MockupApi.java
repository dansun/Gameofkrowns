import java.util.ArrayList;

public class MockupApi {
	 public MockupApi () {
		 
	 }
	 
	 /*
	  * Returns an object with a valid session id, or an error code
	  */
	 public LoginResult authenticate(String userId, Strin password) {
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
	 public UserGeneralStatus getGeneralStatus(String userId, String sessionId) {
		 return new UserGeneralStatus(1,2,3);
	 }
	 
	 /*
	  *  Returns the games that are currently active for the user
	  */
	 public ArrayList<ActiveGame> getActiveGames(String userId, String sessionId) {
		 return new ArrayList<ActiveGame>();
	 }
	 
	 /*
	  * Returns the friends of this user. Gustaf does not have any friends. His penis is too small.
	  */
	 public ArrayList<Friend> getFriends(String userId, String sessionId) {
		 return new ArrayList<Friend>();
	 }
	 
	 /*
	  * Requests a game to be created. If allowRandoms is true, the server will try to fill out to four players
	  * with random players looking for games
	  */
	 public long createGame(String userId, long sessionId, boolean allowRandoms, ArrayList<String> userids) {
		 return 0;
	 }
	 
	 /*
	  * Gets the invitations that the user is currently involved in
	  */
	 public ArrayList<Invitation> getInvitations(String userId, String sessionId) {
		 return new ArrayList<Invitation>();
	 }
	 
	 public ArrayList<HistoryEvent> getHistory(String userId, String sessionId,long gameId) {
		 return new ArrayList<HistoryEvent>();
	 }
	 
	
}