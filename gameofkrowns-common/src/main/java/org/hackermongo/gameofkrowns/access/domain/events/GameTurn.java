package org.hackermongo.gameofkrowns.access.domain.events;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.hackermongo.gameofkrowns.access.domain.Event;

/**
 * Event representing one turn complete of a game, IE all players have registered a move.
 * @author dansun
 *
 */
@XmlRootElement(name="gameTurn")
public interface GameTurn<GAME> extends Event<GAME> {

	@XmlAttribute(name="timeout", required=true)
	public Date getTimeout();
	
}