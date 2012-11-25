package org.hackermongo.gameofkrowns.access.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A game of krowns move
 * 
 * @author dansun
 *
 */
@Entity
@Table(name = "MOVES")
@NamedQueries({
    @NamedQuery(name = "move.findByGame", query = "SELECT move FROM Move move WHERE move.game = :game")
})
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="move")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Move extends Event {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Player player;
	
	@Column(name="MOVETYPE", nullable=false)
	@Enumerated(EnumType.STRING)
	private MoveType moveType;
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public MoveType getMoveType() {
		return moveType;
	}
	
	@Override
	public final EventType getEventType() {
		return EventType.GAME_MOVE;
	}

	/**
	 * All types of moves that we want to persist.
	 * @author dansun
	 *
	 */
	public enum MoveType {
		PROPAGANDA,
		BRIBE
	}
	

}
