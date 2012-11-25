package org.hackermongo.gameofkrowns.access.domain.events;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hackermongo.gameofkrowns.access.domain.Event;

/**
 * Event representing a start of a game
 * @author dansun
 *
 */
@Entity
@Table(name = "GAME_STARTED_EVENT")
@Inheritance(strategy=InheritanceType.JOINED)
@XmlRootElement(name="started")
public class GameStarted extends Event {

	private static final long serialVersionUID = 1L;

	public GameStarted() {
		this.eventType = EventType.GAME_START;
	}
	
}
