package nu.danielsundberg.droid.gameofkrowns.game.model.events;

import java.util.Date;

import nu.danielsundberg.droid.gameofkrowns.game.model.EventImpl;
import nu.danielsundberg.droid.gameofkrowns.game.model.GameImpl;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.events.GameTurn;

import org.joda.time.DateTime;

/**
 * Event representing one turn complete of a game, IE all players have registered a move.
 * @author dansun
 *
 */
public class GameTurnImpl extends EventImpl implements GameTurn<GameImpl> {

	private static final long serialVersionUID = 1L;

	public GameTurnImpl() {
		this.eventType = EventType.GAME_TURN;
		this.timeout = new DateTime().plusHours(1).toDate();
	}
	
	private Date timeout;
	
	public Date getTimeout() {
		return timeout;
	}

	@Override
	public int compareTo(Event<GameImpl> o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
