package nu.danielsundberg.gameofkrowns.domain;

import java.io.Serializable;
import java.util.Set;
import java.util.SortedSet;

import org.joda.time.DateTime;

/**
 * A Game of Krowns
 *
 * @author dansun
 *
 */

public interface Game<PLAYER, EVENT, COUNTY> extends Serializable {

	public void setGameId(long gameId);
	
	public Long getGameId();

	public void setGameName(String gameName);

	public String getGameName();
	
	public GameState getGameState();

	public DateTime getRegistrationTime();

	public PLAYER getOwner();

	public void setOwner(PLAYER owner);

	public Set<PLAYER> getInvitedPlayers();

	public void setInvitedPlayers(Set<PLAYER> invitedPlayers);

	public Set<PLAYER> getPlayers();

	public void setPlayers(Set<PLAYER> players);

	public SortedSet<EVENT> getEvents();

	public void setEvents(SortedSet<EVENT> events);

	public Set<COUNTY> getCounties();

	public void setCounties(Set<COUNTY> counties);
	
}
