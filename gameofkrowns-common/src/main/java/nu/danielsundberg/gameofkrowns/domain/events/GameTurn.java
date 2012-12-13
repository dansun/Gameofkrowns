package nu.danielsundberg.gameofkrowns.domain.events;

import java.util.Date;

import nu.danielsundberg.gameofkrowns.domain.Event;

/**
 * Event representing one turn complete of a game, IE all players have registered a move.
 * @author dansun
 *
 */
public interface GameTurn<GAME> extends Event<GAME> {

	public Date getTimeout();
	
}
