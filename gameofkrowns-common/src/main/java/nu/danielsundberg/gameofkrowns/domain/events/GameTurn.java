package nu.danielsundberg.gameofkrowns.domain.events;

import nu.danielsundberg.gameofkrowns.domain.Event;

import java.util.Date;

/**
 * Event representing one turn complete of a game,
 * IE all players have registered a move or timeout occured.
 */
public interface GameTurn extends Event {

	public Date getTimeout();
	
}
