package nu.danielsundberg.gameofkrowns.domain.events;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import nu.danielsundberg.gameofkrowns.domain.Event;

/**
 * Event representing end of a game
 */
@XmlRootElement(name="gameEnded")
public interface GameEnded<PLAYER, GAME> extends Event<GAME> {

	@XmlAttribute(name="winningPlayer", required=true)
	public PLAYER getWinningPlayer();

	public void setWinningPlayer(PLAYER winningPlayer);
	
}
