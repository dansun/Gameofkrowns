package nu.danielsundberg.gameofkrowns.domain;

import nu.danielsundberg.gameofkrowns.domain.events.GameTurn;
import nu.danielsundberg.gameofkrowns.domain.game.County;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.SortedSet;

/**
 * A Game of Krowns
 */
public interface Game extends Serializable {

	public Long getGameId();

	public String getGameName();

	public GameState getGameState();

	public Date getRegistrationTime();

	public Player getOwningPlayer();

	public Set<Player> getInvitedPlayers();

	public Set<Player> getPlayers();

	public SortedSet<Event> getEvents();

	public Set<County> getCounties();

    public GameTurn getCurrentGameTurn();

}
