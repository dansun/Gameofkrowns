package nu.danielsundberg.gameofkrowns.domain.events;

import nu.danielsundberg.gameofkrowns.domain.Event;

/**
 * Event representing end of a game.
 */
public interface GameEnded extends Event {

	public Long getWinningPlayerId();

}
