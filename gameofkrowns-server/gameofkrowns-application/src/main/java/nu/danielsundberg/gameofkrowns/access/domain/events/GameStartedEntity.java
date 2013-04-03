package nu.danielsundberg.gameofkrowns.access.domain.events;

import nu.danielsundberg.gameofkrowns.access.domain.EventEntity;
import nu.danielsundberg.gameofkrowns.access.domain.GameEntity;
import nu.danielsundberg.gameofkrowns.domain.EventType;
import nu.danielsundberg.gameofkrowns.domain.events.GameStarted;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Event representing a start of a game
 * @author dansun
 *
 */
@Entity
@DiscriminatorValue(value = "GAME_START")
@Table(name = "GAME_STARTED_EVENT")
public class GameStartedEntity extends EventEntity implements GameStarted<GameEntity> {

	private static final long serialVersionUID = 1L;

	public GameStartedEntity() {
		this.eventType = EventType.GAME_START;
	}

}
