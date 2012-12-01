package org.hackermongo.gameofkrowns.access.domain.events;

import javax.xml.bind.annotation.XmlRootElement;

import org.hackermongo.gameofkrowns.access.domain.Event;

/**
 * Event representing a start of a game
 * @author dansun
 *
 */
@XmlRootElement(name="gameStarted")
public interface GameStarted<GAME> extends Event<GAME> {
	
}
