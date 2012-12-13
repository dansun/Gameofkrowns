package nu.danielsundberg.gameofkrowns.access.domain.events;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import nu.danielsundberg.gameofkrowns.access.domain.EventEntity;
import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.domain.Event;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.events.GameStarted;

/**
 * Event representing a start of a game
 * @author dansun
 *
 */
@Entity
@Table(name = "GAME_STARTED_EVENT")
@XmlRootElement(name="started")
public class GameStartedEntity extends EventEntity implements GameStarted<GameEntity> {

	private static final long serialVersionUID = 1L;

	public GameStartedEntity() {
		this.eventType = EventType.GAME_START;
	}

	@Override
	public int compareTo(Event<GameEntity> o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
