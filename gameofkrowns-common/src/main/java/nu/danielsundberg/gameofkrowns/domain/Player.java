package nu.danielsundberg.gameofkrowns.domain;

import java.io.Serializable;
import java.util.Set;


/**
 * Player
 * @author dansun
 *
 */
public interface Player<GAME> extends Serializable {

	public void setPlayerId(long playerId);

	public long getPlayerId();

	public void setPlayerName(String playerName);
	
	public String getPlayerName();
	
	public String getPassword();

	public void setPassword(String password);

	public Set<GAME> getInvitedGames();

	public void setInvitedGames(Set<GAME> invitedGames);

	public Set<GAME> getOwnedGames();

	public void setOwnedGames(Set<GAME> ownedGames);

	public Set<GAME> getPlayingGames();

	public void setPlayingGames(Set<GAME> playingGames);
	
}
