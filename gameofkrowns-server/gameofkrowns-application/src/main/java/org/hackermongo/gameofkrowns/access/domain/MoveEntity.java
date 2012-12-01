package org.hackermongo.gameofkrowns.access.domain;

import java.io.Serializable;

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

/**
 * A game of krowns move
 * 
 * @author dansun
 *
 */
@Entity
@Table(name = "MOVES")
@NamedQueries({
    @NamedQuery(name = "move.findByGame", query = "SELECT move FROM MoveEntity move WHERE move.game = :game")
})
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class MoveEntity extends EventEntity implements Move<PlayerEntity, GameEntity>, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private PlayerEntity player;
	
	@Column(name="MOVETYPE", nullable=false)
	@Enumerated(EnumType.STRING)
	private MoveType moveType;
	
	public PlayerEntity getPlayer() {
		return player;
	}

	public void setPlayer(PlayerEntity player) {
		this.player = player;
	}
	
	public MoveType getMoveType() {
		return moveType;
	}
	
	public final EventType getEventType() {
		return EventType.GAME_MOVE;
	}	

}
