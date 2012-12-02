package org.hackermongo.gameofkrowns.android.model;

import java.io.Serializable;
import java.util.Set;

import org.hackermongo.gameofkrowns.access.domain.Player;

/**
 * Player
 * @author dansun
 *
 */
public class PlayerImpl implements Player<GameImpl>, Serializable {

	private static final long serialVersionUID = 1L;

	private long playerId;
	
	private String playerName;
	
	private String password;
	
	private Set<GameImpl> invitedGames;
	
	private Set<GameImpl> ownedGames;
	
	private Set<GameImpl> playingGames;
	
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerName() {
		return playerName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<GameImpl> getInvitedGames() {
		return this.invitedGames;
	}

	public void setInvitedGames(Set<GameImpl> invitedGames) {
		this.invitedGames = invitedGames;
	}

	public Set<GameImpl> getOwnedGames() {
		return ownedGames;
	}

	public void setOwnedGames(Set<GameImpl> ownedGames) {
		this.ownedGames = ownedGames;
	}

	public Set<GameImpl> getPlayingGames() {
		return playingGames;
	}

	public void setPlayingGames(Set<GameImpl> playingGames) {
		this.playingGames = playingGames;
	}
	
}
