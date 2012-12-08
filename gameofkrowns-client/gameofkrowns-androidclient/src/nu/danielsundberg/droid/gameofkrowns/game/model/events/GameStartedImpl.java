package nu.danielsundberg.droid.gameofkrowns.game.model.events;

import nu.danielsundberg.droid.gameofkrowns.game.model.EventImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.GameImpl;

import nu.danielsundberg.gameofkrowns.access.domain.Event;
import nu.danielsundberg.gameofkrowns.access.domain.EventType;
import nu.danielsundberg.gameofkrowns.access.domain.events.GameStarted;

/**
 * Event representing a start of a game
 * @author dansun
 *
 */
public class GameStartedImpl extends EventImpl implements GameStarted<GameImpl> {

	private static final long serialVersionUID = 1L;

	public GameStartedImpl() {
		this.eventType = EventType.GAME_START;
	}

	@Override
	public int compareTo(Event<GameImpl> o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
