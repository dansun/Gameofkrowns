package nu.danielsundberg.gameofkrowns.domain.events;

import nu.danielsundberg.gameofkrowns.domain.Event;

/**
 * Event representing end of a game
 */
public interface GameEnded<PLAYER, GAME> extends Event<GAME> {

	public PLAYER getWinningPlayer();

	public void setWinningPlayer(PLAYER winningPlayer);
	
}
