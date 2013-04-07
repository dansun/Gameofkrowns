package nu.danielsundberg.droid.gameofkrowns.game.model.events;

import nu.danielsundberg.droid.gameofkrowns.game.model.EventImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.GameImpl;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.events.GameStarted;

/**
 * Event representing a start of a game

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
