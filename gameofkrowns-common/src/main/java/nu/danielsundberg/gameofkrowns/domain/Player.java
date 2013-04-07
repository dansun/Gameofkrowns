package nu.danielsundberg.gameofkrowns.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * Player
 */
public interface Player extends Serializable {

	public long getPlayerId();

	public String getPlayerName();

	public Set<Long> getInvitedGameIds();

	public Set<Long> getOwnedGameIds();

	public Set<Long> getPlayingGameIds();

}
