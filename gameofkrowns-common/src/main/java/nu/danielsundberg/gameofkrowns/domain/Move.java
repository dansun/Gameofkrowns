package nu.danielsundberg.gameofkrowns.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * A game of krowns move
 * 
 * @author dansun
 * @param <GAME>
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="move")
public abstract interface Move<PLAYER, GAME> extends Event<GAME> {
	
	public PLAYER getPlayer();

	public void setPlayer(PLAYER player);
	
	public MoveType getMoveType();
	
	public EventType getEventType();
	

}
