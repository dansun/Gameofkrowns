package org.hackermongo.gameofkrowns.access.domain.events;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hackermongo.gameofkrowns.access.domain.Event;
import org.hackermongo.gameofkrowns.access.domain.EventEntity;
import org.hackermongo.gameofkrowns.access.domain.EventType;
import org.hackermongo.gameofkrowns.access.domain.GameEntity;

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
