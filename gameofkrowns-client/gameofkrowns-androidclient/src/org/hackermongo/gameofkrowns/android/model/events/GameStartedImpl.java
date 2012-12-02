package org.hackermongo.gameofkrowns.android.model.events;

import org.hackermongo.gameofkrowns.access.domain.Event;
import org.hackermongo.gameofkrowns.access.domain.EventType;
import org.hackermongo.gameofkrowns.access.domain.events.GameStarted;
import org.hackermongo.gameofkrowns.android.model.EventImpl;
import org.hackermongo.gameofkrowns.android.model.GameImpl;

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
