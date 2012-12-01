package org.hackermongo.gameofkrowns.access.domain.events;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.hackermongo.gameofkrowns.access.domain.Event;

/**
 * Event representing end of a game
 */
@XmlRootElement(name="gameEnded")
public interface GameEnded<PLAYER, GAME> extends Event<GAME> {

	@XmlAttribute(name="winningPlayer", required=true)
	public PLAYER getWinningPlayer();

	public void setWinningPlayer(PLAYER winningPlayer);
	
}
