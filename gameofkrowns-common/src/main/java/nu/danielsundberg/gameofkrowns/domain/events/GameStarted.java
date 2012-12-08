package nu.danielsundberg.gameofkrowns.domain.events;

import javax.xml.bind.annotation.XmlRootElement;

import nu.danielsundberg.gameofkrowns.domain.Event;

/**
 * Event representing a start of a game
 * @author dansun
 *
 */
@XmlRootElement(name="gameStarted")
public interface GameStarted<GAME> extends Event<GAME> {
	
}
