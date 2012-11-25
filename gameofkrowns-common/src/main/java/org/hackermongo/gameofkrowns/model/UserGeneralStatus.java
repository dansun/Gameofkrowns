package org.hackermongo.gameofkrowns.model;

public class UserGeneralStatus {
	private long activeGames;
	private long nofInvitations;
	
	public UserGeneralStatus(long a, long i) {
		activeGames = a;
		nofInvitations = i;
	}	
	
	/*
	 * Returns the number of games that are waiting for a move by the requesting player
	*/
	public long getActiveGames() {
		return activeGames;
	}
	
	/*
	 * Returns the number of games this user is invited to
	 */
	public long getNofInvitations() {
		return nofInvitations;
	}

}